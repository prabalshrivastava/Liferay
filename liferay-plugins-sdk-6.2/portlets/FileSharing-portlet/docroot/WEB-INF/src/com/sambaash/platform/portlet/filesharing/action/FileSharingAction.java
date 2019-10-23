package com.sambaash.platform.portlet.filesharing.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.FileNameException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.InvalidFileEntryTypeException;
import com.liferay.portlet.documentlibrary.InvalidFileVersionException;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.portlet.documentlibrary.SourceFileNameException;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.filesharing.util.FileSharingConstants;
import com.sambaash.platform.portlet.filesharing.util.FileSharingHelper;
import com.sambaash.platform.portlet.filesharing.util.FileSharingUtils;
import com.sambaash.platform.srv.sharing.model.SPSharing;
import com.sambaash.platform.srv.sharing.service.SPSharingLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class FileSharingAction
 */

public class FileSharingAction extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(FileSharingAction.class);

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		doSharedWithMe(renderRequest, renderResponse);
		doSharedByMe(renderRequest, renderResponse);

		super.doView(renderRequest, renderResponse);
	}

	public void revokeAccess(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException,
			PrincipalException, PortalException, SystemException {
		try {
			String sharingId = actionRequest.getParameter("sharingId");
			_log.debug("revoking access for classPk = " + sharingId);
			SPSharing share = SPSharingLocalServiceUtil.getSPSharing(GetterUtil
					.getLong(sharingId));
			share.setExpired(true);
			SPSharingLocalServiceUtil.updateSPSharing(share);
			doSharedByMe(actionRequest, actionResponse);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("tab", "sharedByMe");
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage",
					"/html/filesharing/view.jsp");
		} catch (Exception e) {
			_log.error("error while revoking accesss", e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		String action = resourceRequest.getParameter("action");

		HttpServletRequest request_ = PortalUtil
				.getHttpServletRequest(resourceRequest);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(request_);

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("utf-8");

		String filePath = ParamUtil.get(resourceRequest, "filePath", "");
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		User loggedInUser = themeDisplay.getUser();
		try {
			FileSharingUtils.initializePermissionChecker();
		} catch (Exception ex) {
			_log.error("Error while initailizing permission checker", ex);
			dataJSONObject.put("statusMsg", "error");
			return;
		}

		JSONArray array1 = null;

		if ("uploadFile".equalsIgnoreCase(action)) {
			List<FileItem> items;
			String statusMsg = "error";

			try {
				items = new ServletFileUpload(new DiskFileItemFactory())
						.parseRequest(httpRequest);
				String folderIdStr = ParamUtil.get(resourceRequest, "folderId",
						"");
				_log.debug("Upload request for folderid = " + folderIdStr);

				if (Validator.isNotNull(folderIdStr)) {
					long folderId = Long.parseLong(folderIdStr);
					Folder parentFolder = DLAppServiceUtil.getFolder(folderId);

					if (Validator.isNotNull(items) && items.size() > 0) {
						FileItem item = items.get(0);
						String[] folderNames = filePath.split(File.separator);
						long tempParentId = parentFolder.getFolderId();
						Folder tempParent = parentFolder;

						// countryDeptFolderName is used to identify the default role; Ex: Regional-IT is foldername then default role : Regional-IT-User

						String countryDeptFolderName = getCountryDeptFolder(parentFolder);
						ServiceContext serviceContext = ServiceContextFactory
								.getInstance(DLFolder.class.getName(),
										resourceRequest);
				//		serviceContext.setUserId(loggedInUser.getUserId());
						boolean gotFolder;

						for (int i = 0; i < folderNames.length - 1; i++) {
							if (Validator.isNull(folderNames[i])) {
								continue;
							}

							gotFolder = false;
							int attempt = 0;
							while (!gotFolder) {
								try {
									tempParent = DLAppServiceUtil.getFolder(
											themeDisplay.getScopeGroupId(),
											tempParentId, folderNames[i]);
									tempParentId = tempParent.getFolderId();
									gotFolder = true;
								} catch (Exception ex) {
									try {
										synchronized (FileSharingAction.class) {

											// set logged in user as owner of the folder

											tempParent = DLAppLocalServiceUtil
													.addFolder(loggedInUser.getUserId(), themeDisplay
															.getScopeGroupId(),
															tempParentId,
															folderNames[i],
															folderNames[i],
															serviceContext);
											tempParentId = tempParent
													.getFolderId();
											FileSharingUtils.addDefaultFolderPermissions(themeDisplay.getCompanyId(), tempParent.getFolderId(), countryDeptFolderName);
											gotFolder = true;
										/* try {
												DLFolder dlfolder = DLFolderLocalServiceUtil.getDLFolder(tempParentId);
												dlfolder.setUserId(loggedInUser.getUserId());
												//dlfolder.setUserUuid(loggedInUser.getUuid());
												dlfolder.setUserName(loggedInUser.getFullName());
												DLFolderLocalServiceUtil.updateDLFolder(dlfolder);
												//tempParent.setUserId(loggedInUser.getUserId());
												//tempParent.setUserName(loggedInUser.getFullName());
											//	serviceContext.setUserId(loggedInUser.getUserId());
											//	DLAppServiceUtil.updateFolder(tempParentId, tempParent.getName(), tempParent.getDescription(), serviceContext);
											}catch (Exception e) {

											} */
										}
									} catch (Exception ex1) {
										List<Folder> childs = DLAppServiceUtil
												.getFolders(themeDisplay
														.getScopeGroupId(),
														tempParentId);
//										System.out
//												.println("to check infinity loop "
//														+ filePath);

										for (Folder folder : childs) {
											if (folder.getName()
													.equalsIgnoreCase(
															folderNames[i])) {
												tempParent = folder;
												tempParentId = tempParent
														.getFolderId();
												gotFolder = true;
												break;
											}
										}

										attempt++;

										if (attempt > 2) {
											break;
										}
									}

									Thread.sleep(2000);
								}
							}
						}

						FileEntry fileEntry = null;
						String fileName = StringPool.BLANK;
						try {
							
							// to replace null character in the file name
							fileName = item.getName().replace("\\0", " ");
							
							// to replace non-printable characters in the file name
							fileName = fileName.replaceAll("[^\\p{Graph}]", "");
							
							// set logged in user as file owner
							fileEntry = DLAppLocalServiceUtil.addFileEntry(loggedInUser.getUserId(), themeDisplay.getScopeGroupId(), tempParentId, fileName,
									item.getContentType(), fileName,
									StringPool.BLANK, StringPool.BLANK,
									item.getInputStream(), item.getSize(),
									serviceContext);
					/* fileEntry = DLAppServiceUtil.addFileEntry(
									themeDisplay.getScopeGroupId(),
									tempParentId, item.getName(),
									item.getContentType(), item.getName(),
									StringPool.BLANK, StringPool.BLANK,
									item.getInputStream(), item.getSize(),
									serviceContext); */
							statusMsg = "success";
						} catch (DuplicateFileException ex) {
							fileEntry = DLAppServiceUtil.getFileEntry(
									themeDisplay.getScopeGroupId(),
									tempParentId, fileName);
							DLFileVersion fileVersion = DLFileVersionLocalServiceUtil
									.getLatestFileVersion(
											fileEntry.getFileEntryId(), false);

							if (fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE) {
								fileVersion
										.setStatus(WorkflowConstants.STATUS_APPROVED);
								DLFileVersionLocalServiceUtil
										.updateDLFileVersion(fileVersion);
							}

							try {
								fileEntry = DLAppServiceUtil
										.updateFileEntryAndCheckIn(
												fileEntry.getFileEntryId(),
												fileEntry.getTitle(),
												item.getContentType(),
												fileName, "", "", true,
												item.getInputStream(),
												item.getSize(), serviceContext);
								statusMsg = "success";
							} catch (FileSizeException fs) {
								statusMsg = "File size exceeds maximum allowed limit";
								_log.error(fs);
							} catch (FileNameException ex1) {
								statusMsg = "Invalid file name";
								_log.error(ex1);
							} catch (InvalidFileEntryTypeException | InvalidFileVersionException | NoSuchFileException | SourceFileNameException ex1) {
								statusMsg = "Reupload the files";
								_log.error(ex1);
							} catch (Exception ex1) {
								statusMsg = "error";
								_log.error(ex1);
							}
						} catch (FileSizeException ex) {
							statusMsg = "File size exceeds maximum allowed limit";
							_log.error(ex);
						} catch (FileNameException ex1) {
							statusMsg = "Invalid file name";
							_log.error(ex1);
						} catch (InvalidFileEntryTypeException | InvalidFileVersionException | NoSuchFileException | SourceFileNameException ex1) {
							statusMsg = "Reupload the files";
							_log.error(ex1);
						} catch (Exception ex) {
							statusMsg = "error";
							_log.error(ex);
						}

						if (Validator.isNotNull(fileEntry)) {
							dataJSONObject.put(FileSharingConstants.FILE_ENTRY_ID,
									fileEntry.getFileEntryId());
							FileSharingUtils.addDefaultFilePermissions(themeDisplay.getCompanyId(), fileEntry.getFileEntryId(), countryDeptFolderName);
						}
					}
				}
			} catch (Exception e) {
				statusMsg = "error";
				_log.error(e);
			}

			dataJSONObject.put("statusMsg", statusMsg);
		} else if ("removeFile".equalsIgnoreCase(action)) {
			String param = resourceRequest
					.getParameter(FileSharingConstants.FILE_ENTRY_ID);
			String status = "error";

			if (Validator.isNotNull(param)) {
				long fileEntryId = GetterUtil.getLong(param);
				try {
					DLAppServiceUtil.deleteFileEntry(fileEntryId);
					dataJSONObject.put(FileSharingConstants.FILE_ENTRY_ID, fileEntryId);
					status = "success";
				} catch (Exception e) {
					_log.error("Failed to delete file ", e);
				}
			}

			dataJSONObject.put("statusMsg", status);
		} else if ("checkPermission".equalsIgnoreCase(action)) {
			
			dataJSONObject.put("canWrite", false);
			String folderIdStr = ParamUtil.getString(resourceRequest, "folderId", "");
			if(folderIdStr.indexOf(FileSharingConstants.SHARING_ID) != -1){
				try {
					long shareId = GetterUtil.getLong(folderIdStr.substring(0,folderIdStr.indexOf("fd")).substring(FileSharingConstants.SHARING_ID.length()));
					SPSharing share = SPSharingLocalServiceUtil.getSPSharing(shareId);
					if(share.getUserId() == themeDisplay.getUserId()){
						dataJSONObject.put("canWrite", share.isWritePermission());
					}
				} catch (Exception e) {
					_log.error("Failed to change permission", e);
					dataJSONObject.put("canWrite", false);
				}
				
			}
		} else if ("getAllShares".equalsIgnoreCase(action)) {
			JSONArray array = JSONFactoryUtil.createJSONArray();
			try {
				List<SPSharing> sharings = SPSharingLocalServiceUtil
						.getUserSharings(themeDisplay.getUserId(), new Date());

				boolean isFile = false;

				for (SPSharing share : sharings) {
					try {
					String name = "";
					String classpkStr = "";
					FileEntry fileEntry = null;

					if (FileSharingHelper.isFile(share)) {
						isFile = true;
						fileEntry = DLAppServiceUtil
								.getFileEntry(share.getClassPK());
						name = fileEntry.getTitle();
						classpkStr = "fe" + fileEntry.getFileEntryId();
					} else {
						isFile = false;
						Folder folder = DLAppServiceUtil.getFolder(share
								.getClassPK());
						name = folder.getName();
						classpkStr = FileSharingConstants.SHARING_ID + share.getSpSharingId() + "fd" + folder.getFolderId();
					}

					JSONObject json = JSONFactoryUtil.createJSONObject();

					json.put(FileSharingConstants.AJAX_LEAF, isFile);
					//json.put(FileSharingConstants.AJAX_CSSCLASS, classpkStr);
					json.put("id", classpkStr);

					if (!isFile) {
						json.put(FileSharingConstants.AJAX_TYPE, FileSharingConstants.AJAX_IO);
						LiferayPortletURL ajaxUrl = PortletURLFactoryUtil
								.create(request_, FileSharingConstants.PORTLET_ID,
										themeDisplay.getPlid(),
										PortletRequest.RESOURCE_PHASE);
						ajaxUrl.setParameter(Field.CLASS_PK, "" + share.getClassPK());
						ajaxUrl.setParameter("action", "getTreeContent");
						ajaxUrl.setParameter(FileSharingConstants.SHARING_ID, share.getSpSharingId() + "");
						json.put(FileSharingConstants.AJAX_IO, ajaxUrl.toString());
						json.put(FileSharingConstants.AJAX_LABEL, createFolderLabel(name, share.getClassPK(),resourceRequest));
					} else {
						json.put(FileSharingConstants.AJAX_LABEL, createFileLabel(fileEntry,resourceRequest));
					}

					array.put(json);
					}catch (Exception e) {
						_log.error("error while fetching file/folder entry", e);
					}
				}

				dataJSONObject.put("items", array);
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		} else if ("getTreeContent".equalsIgnoreCase(action)) {
			try {
				String classPkStr = resourceRequest
						.getParameter(Field.CLASS_PK);
				String shareId = ParamUtil.getString(resourceRequest, FileSharingConstants.SHARING_ID);
				array1 = JSONFactoryUtil.createJSONArray();

				if (Validator.isNotNull(classPkStr)) {
					Long classPk = Long.parseLong(classPkStr);
					List<Object> list = DLAppServiceUtil
							.getFoldersAndFileEntriesAndFileShortcuts(
									themeDisplay.getScopeGroupId(), classPk,
									WorkflowConstants.STATUS_ANY, true, -1, -1,
									null);

					for (Object obj : list) {
						String name = null;
						JSONObject json = JSONFactoryUtil.createJSONObject();

						if (obj instanceof FileEntry) {
							FileEntry fe = (FileEntry)obj;
							name = fe.getTitle();
							json.put(FileSharingConstants.AJAX_LEAF, true);
							json.put(FileSharingConstants.AJAX_CSSCLASS, "fe" + fe.getFileEntryId());
							json.put(FileSharingConstants.AJAX_LABEL, createFileLabel(fe,resourceRequest));
						} else if (obj instanceof Folder) {
							Folder folder = (Folder)obj;
							name = folder.getName();
							json.put(FileSharingConstants.AJAX_LEAF, false);
							//json.put(FileSharingConstants.AJAX_CSSCLASS, FileSharingConstants.SHARING_ID + shareId + "fd" + folder.getFolderId());
							json.put("id", FileSharingConstants.SHARING_ID + shareId + "fd" + folder.getFolderId());
							json.put(FileSharingConstants.AJAX_TYPE, FileSharingConstants.AJAX_IO);
							LiferayPortletURL ajaxUrl = PortletURLFactoryUtil
									.create(request_, FileSharingConstants.PORTLET_ID,
											themeDisplay.getPlid(),
											PortletRequest.RESOURCE_PHASE);
							ajaxUrl.setParameter(Field.CLASS_PK,
									"" + folder.getFolderId());
							ajaxUrl.setParameter("action", "getTreeContent");
							ajaxUrl.setParameter(FileSharingConstants.SHARING_ID, shareId);
							json.put(FileSharingConstants.AJAX_IO, ajaxUrl.toString());
							json.put(FileSharingConstants.AJAX_LABEL, createFolderLabel(name, folder.getFolderId(),resourceRequest));
						}

						array1.put(json);
					}
				}
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		} else {
			dataJSONObject.put("statusMsg", "error");
		}

		if ("getTreeContent".equalsIgnoreCase(action))
			resourceResponse.getWriter().write(array1.toString());
		else
			resourceResponse.getWriter().write(dataJSONObject.toString());
	}

	private String createFileLabel(FileEntry fe,PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		if (FileSharingHelper.isImageFile(fe.getTitle()) || fe.getMimeType().toLowerCase().contains("image"))
			return fe.getTitle();
		else
			return fe.getTitle() + "<a href='/FileSharing-portlet/download?fileEntryId="+ fe.getFileEntryId() +"'> &nbsp;<img width='15' height='15' src='" + themeDisplay.getPathThemeImages() + "/common/download.png' alt='download'/></a>";
	}

	private String createFolderLabel(String name, long folderId,PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		return name + "<a href='/FileSharing-portlet/download?folderIdTest="+ folderId +"'> &nbsp;<img width='15' height='15' src='" + themeDisplay.getPathThemeImages() + "/common/download.png' alt='download'/></a>";
	}

	private void doSharedByMe(PortletRequest portletRequest,
			PortletResponse portletResponse) {
		try {
			FileSharingUtils.initializePermissionChecker();
			ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			FileSharingHelper helper = new FileSharingHelper();
			SearchContainer container = helper.getFilesSharedByUser(
					themeDisplay.getUserId(), portletRequest);
			portletRequest.setAttribute("searchContainer", container);
		} catch (Exception e) {
			_log.error("error in doSharedByMe", e);
		}
	}

	private void doSharedWithMe(RenderRequest renderRequest,
			RenderResponse renderResponse) {

		long folderId = -1L;

		String encString = FileSharingHelper.parseTokenId(renderRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		_log.debug("encString :" + encString);
		try {
			FileSharingUtils.initializePermissionChecker();
			SPSharing share = FileSharingHelper.getShareIfValidRequest(renderRequest, themeDisplay);

			if (share == null || FileSharingHelper.isFile(share)) {
				List<SPSharing> sharings = SPSharingLocalServiceUtil
						.getUserSharings(themeDisplay.getUserId(), new Date());

				for (SPSharing sharing : sharings) {
					if (!FileSharingHelper.isFile(sharing)) {
						try {

							// temp fix for deleted folder..i.e. folders are
							// first shared and then deleted then it will still
							// exist in the spsharing table

							DLAppServiceUtil.getFolder(sharing.getClassPK());
							folderId = sharing.getClassPK();
							break;
						} catch (Exception ex) {
						}
					}
				}
			} else {
				folderId = share.getClassPK();
			}

			if (folderId != -1L) {
				renderRequest.setAttribute(FileSharingConstants.SHARED_FOLDER_ID,
					folderId);
			}

			// TODO: default selection of file/folder on UI for the token

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	private String getCountryDeptFolder(Folder folder) {
		Folder countryDeptFolder = null;
		String folderName = StringPool.BLANK;

		if (Validator.isNotNull(folder)) {
			Folder temp = folder;
			List<Folder>list = new ArrayList<Folder>();
			try {
				while (Validator.isNotNull(temp)&&(temp.getFolderId()) != 0) {
					list.add(0, temp);
					temp = temp.getParentFolder();
				}

				countryDeptFolder = list.get(0);
				folderName = countryDeptFolder.getName();
			}catch (Exception ex) {
			}
		}

		return folderName;
	}

	public void addDefaultPermissionsToDeptUsers(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {
		List<SPSharing>shares = SPSharingLocalServiceUtil.getSPSharings(-1, -1);
		long folderClassId = PortalUtil.getClassNameId(DLFolder.class.getName());
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		for(SPSharing share:shares){
			try{
				String email = share.getEmailAddress();
				boolean isExternalUser = false; 
				if(Validator.isNotNull(email)){
					isExternalUser = !email.contains("@menariniapac");
				}
				if(share.getClassNameId() == folderClassId){
					Folder folder = DLAppServiceUtil.getFolder(share.getClassPK());
					if( folder.getParentFolderId() == 0 && folder.getName().equalsIgnoreCase("Legal")){
						continue;
					}
					String roleNamePrefix = getCountryDeptFolder(folder);
					if(Validator.isNotNull(roleNamePrefix)){
						addPermissions(folder, themeDisplay.getCompanyId(), roleNamePrefix,isExternalUser);
					}
				}else{
					FileEntry fe = DLAppServiceUtil.getFileEntry(share.getClassPK());
					String roleNamePrefix = getCountryDeptFolder(fe.getFolder());

					FileSharingUtils.addDefaultFilePermissions(companyId, fe.getFileEntryId(), roleNamePrefix);
				}
			}catch(Exception ex){
				_log.error("Error while processing the sharing shareid= " + share.getSpSharingId());
			}
		}
	}
	private void addPermissions(Folder folder,long companyId,String roleNamePrefix,boolean isExternalUser) throws PortalException, SystemException, IOException {
		try {
			if (Validator.isNotNull(folder)) {
				List<Folder> childFolders = DLAppServiceUtil.getFolders(folder.getGroupId(), folder.getFolderId());
				for (Folder childFolder : childFolders) {
					try{
						addPermissions(childFolder,companyId,roleNamePrefix,isExternalUser);
						if(childFolder.getUserId() == SambaashUtil.getAdminUserId() || isExternalUser){
							FileSharingUtils.addDefaultFolderPermissions(companyId, childFolder.getFolderId(), roleNamePrefix);
						}
					}catch(Exception ex){
					}
				}
				List<FileEntry> fes = DLAppServiceUtil.getFileEntries(folder.getGroupId(), folder.getFolderId());
				for (FileEntry fe : fes) {
					try {
							if(fe.getUserId() == SambaashUtil.getAdminUserId() || isExternalUser){
								FileSharingUtils.addDefaultFilePermissions(companyId, fe.getFileEntryId(), roleNamePrefix);
							}
					} catch (Exception ex) {
						_log.error("Error while assigning permissions for file entry id " + fe.getFileEntryId());
					}
				}
			}
		} catch (Exception e) {
			_log.error("Error while assigning permissions");
		}
	}
}