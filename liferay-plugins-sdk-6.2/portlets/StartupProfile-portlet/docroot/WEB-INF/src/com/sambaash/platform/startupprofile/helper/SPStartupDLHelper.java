package com.sambaash.platform.startupprofile.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SPStartupDLHelper {

	private static final Log logger = LogFactoryUtil.getLog(SPStartupDLHelper.class);
	
	public static boolean isLogoTypAllowed(String type) {
		return type.equalsIgnoreCase("image/jpeg")
				|| type.equalsIgnoreCase("image/jpg")
				|| type.equalsIgnoreCase("image/png");
	}
	
	private static Folder getOrAddFolder(PortletRequest request,
			long folderId, String folderName) throws PortalException,
			SystemException {
		Folder folder = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		if (logger.isDebugEnabled()) {
			logger.debug("groupId=" + groupId);
			logger.debug("CompanyId=" + themeDisplay.getCompanyId());
			logger.debug("Parent folder Id=" + folderId);
			logger.debug("Parent folderName=" + folderName);
		}
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		try {
			PermissionUtil.initializeAdminPermissionCheckerByCompanyId(themeDisplay.getCompanyId());
			folder = DLAppServiceUtil.getFolder(groupId, folderId, folderName);
			if (logger.isDebugEnabled()) {
				logger.debug("folderId="+folder.getFolderId());
			}
		} catch (NoSuchFolderException ex) {
			try{
				PermissionUtil.initializeAdminPermissionCheckerByCompanyId(themeDisplay.getCompanyId());
				folder = DLAppServiceUtil.addFolder(groupId, folderId, folderName,
						StringPool.BLANK, serviceContext);
				addDefaultFolderPermissions(themeDisplay.getCompanyId(),
						folder.getFolderId());
				PermissionUtil.resetPermissionChecker(themeDisplay.getUser());
			}catch(Exception ep) {
				logger.error("Error while adding startup folder" + ep.getMessage());
			}	
		} catch (Exception e) {
			logger.error("Error while getting startup folder"
					+ e.getMessage());
		}
		return folder;
	}

	/*
	 * root/startupProfiles
	 */
	private static Folder getRootStartupFolder(PortletRequest request)
			throws PortalException, SystemException {
		return getOrAddFolder(request, StartupConstants.DL_ROOT_FOLDER_ID,
				StartupConstants.STARTUP_FOLDERNAME);
	}
	
	/*
	 * will return organization specific folder root/startupProfiles/ORG_1234
	 */
	private static Folder getStartupFolder(PortletRequest request, String orgIdStr)
			throws PortalException, SystemException {
		if (Validator.isNull(orgIdStr)) {
			logger.error("Organization Id hasnt been passed while uploading images");
			throw new SystemException("organizationId not available");
		}
		String orgName = StartupConstants.STARTUP_FOLDER_PREFIX + orgIdStr;
		return getOrAddFolder(request, getRootStartupFolder(request)
				.getFolderId(), orgName);
	}
	
	/*
	 * will return root/startupProfiles/ORG_1234/temp
	 */
	private static Folder getStartupTempFolder(PortletRequest request,
			String orgIdStr) throws PortalException,
			SystemException {
		return getOrAddFolder(request,
				getStartupFolder(request, orgIdStr).getFolderId(), "temp");
	}
	
	/*
	 * will return root/startupProfiles/ORG_1234/temp/<type>
	 */
	private static Folder getStartupTempFolderType(PortletRequest request,
			String orgIdStr, String uploadToFolder) throws PortalException,
			SystemException {
		return getOrAddFolder(request, getStartupTempFolder(request, orgIdStr)
				.getFolderId(), uploadToFolder);
	}
	
	/*
	 * will return root/startupProfiles/ORG_1234/<type>
	 */
	private static Folder getStartupFolderType(PortletRequest request,
			String orgIdStr, String uploadToFolder) throws PortalException,
			SystemException {
		return getOrAddFolder(request,
				getStartupFolder(request, orgIdStr).getFolderId(),
				uploadToFolder);
	}

	private static void addDefaultFilePermissions(long companyId,
			long fileEntryId) {
		// TODO: Assign permission to default roles. Presently hard coding to
		// Site member
		// GetterUtil.getString(SambaashUtil.getParameter(SambaashConstants.LEGAL_HIGH_PRIVILIGED_ROLES,0));
		String temp = "Site Member";
		String[] privilegedRoles = temp.split(",");
		String actions[] = { ActionKeys.DELETE,
				ActionKeys.PERMISSIONS, ActionKeys.VIEW, ActionKeys.UPDATE };
		for (String roleName : privilegedRoles) {
			try {
				Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
				PermissionUtil.addResourcePermission(companyId,
						role.getRoleId(), DLFileEntry.class.getName(),
						fileEntryId, actions);
			} catch (Exception e) {
				logger.error("Error while assigning permissions to roles "
						+ e.getMessage());
			}
		}
	}

	public static void addDefaultFolderPermissions(long companyId, long folderId) {
		String actions[] = { ActionKeys.ADD_DOCUMENT, ActionKeys.DELETE,
				ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_SUBFOLDER };
		try {
			Role role = RoleLocalServiceUtil.getRole(companyId, "Site Member");
			PermissionUtil.addResourcePermission(companyId, role.getRoleId(),
					DLFolder.class.getName(), folderId, actions);
		} catch (Exception e) {
			logger.error("Error while assigning permissions to roles "
					+ e.getMessage());
		}

	}

	public static void clearFolderContents(Folder folder) {
		if (Validator.isNotNull(folder)) {
			try {
				List<FileEntry> list = DLAppServiceUtil.getFileEntries(
						folder.getRepositoryId(), folder.getFolderId());
				for (FileEntry fe : list) {
					DLAppServiceUtil.deleteFileEntry(fe.getFileEntryId());
				}
			} catch (Exception e) {
				logger.error("Error deleting folder!!", e);
			}
		}
	}
	
	/*
	 * uploadType: logo..cover..other files
	 */
	public static FileEntry uploadToTemp(PortletRequest request, String orgIdStr, FileItem item,
			String uploadToFolder) throws PortalException, SystemException {
		Folder tempFolder = getStartupTempFolderType(request, orgIdStr, uploadToFolder);
		if (uploadToFolder.equals(StartupConstants.FOLDERTYPE_COVER)
				|| uploadToFolder.equals(StartupConstants.FOLDERTYPE_LOGO)) {
			if (!SPStartupDLHelper.isLogoTypAllowed(item.getContentType())) {
				logger.error("User trying to upload incorrect fileformats for either logo or cover image");
				return null;
			}
			// clear content from temp folder in case of logo and cover image.
			clearFolderContents(tempFolder);
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		
		final long folderId = tempFolder.getFolderId();
		String name = item.getName();
		FileEntry fileEntry = null;
		try {
			PermissionUtil.initializeAdminPermissionCheckerByCompanyId(themeDisplay.getCompanyId());
			fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId, folderId,
					name, item.getContentType(), name, StringPool.BLANK,
					StringPool.BLANK, item.getInputStream(), item.getSize(),
					serviceContext);
			addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
			PermissionUtil.resetPermissionChecker(themeDisplay.getUser());
		} catch (DuplicateFileException ex) {
			// will not happen for logo and cover since we clear the content of
			// the temp folder
			logger.error("file already exists returning the file instance", ex);
			List<FileEntry> files = DLAppServiceUtil.getFileEntries(
					tempFolder.getRepositoryId(), tempFolder.getFolderId());
			return files.get(0);
		} catch (FileSizeException ex) {
			logger.error("File size exceeds maximum allowed limit"
					+ ex.getMessage(), ex);
		} catch (Exception ex) {
			logger.error("Error while uploading file " + ex.getMessage(), ex);
		}
		return fileEntry;
	}
	
	public static FileEntry updateOrMoveFolders(PortletRequest request, String orgIdStr,
			String... folders) throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		if (ArrayUtil.isEmpty(folders)) {
			logger.warn("folders param is empty");
		}
		FileEntry logoFileEntry = null;
		for (String folderType : folders) {
			Folder tempFolder = getStartupTempFolderType(request, orgIdStr, folderType);
			Folder mainFolder = getStartupFolderType(request, orgIdStr, folderType);
			List<FileEntry> list = DLAppServiceUtil.getFileEntries(
					tempFolder.getRepositoryId(), tempFolder.getFolderId());
			if (Validator.isNull(list) || list.isEmpty())
				continue;
			for (FileEntry fileEntry : list) {
				try {
					if (folderType.equals(StartupConstants.FOLDERTYPE_LOGO)
							|| folderType
									.equals(StartupConstants.FOLDERTYPE_COVER)) {
						clearFolderContents(mainFolder);
					}
					PermissionUtil.initializeAdminPermissionCheckerByCompanyId(themeDisplay.getCompanyId());
					FileEntry fe = DLAppServiceUtil.moveFileEntry(
							fileEntry.getFileEntryId(),
							mainFolder.getFolderId(), serviceContext);
					if (folderType.equals(StartupConstants.FOLDERTYPE_LOGO))
						logoFileEntry = fe;
					addDefaultFilePermissions(companyId, fe.getFileEntryId());
					PermissionUtil.resetPermissionChecker(themeDisplay.getUser());
				} catch (Exception e) {
					logger.error(
							"Error moving file from temp to main directory", e);
				}
			}
		}
		
		try {
			Folder folder = getStartupTempFolder(request, orgIdStr);
			DLAppServiceUtil.deleteFolder(folder.getFolderId());
			logger.debug("Deleted temp folder for organization" + orgIdStr);
		} catch (Exception e) {
			logger.error("Error deleting temp folder", e);
		}
		return logoFileEntry;
	}
	
	public static FileEntry updateOrMoveFolders(PortletRequest request, String orgName,String orgIdStr,
			String folderType) throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		if (folderType.isEmpty()) {
			logger.warn("folders param is empty");
		}
		FileEntry logoFileEntry = null;
			Folder tempFolder = getStartupTempFolderType(request, orgName, folderType);
			Folder mainFolder = getStartupFolderType(request, orgIdStr, folderType);
			List<FileEntry> list = DLAppServiceUtil.getFileEntries(
					tempFolder.getRepositoryId(), tempFolder.getFolderId());
			for (FileEntry fileEntry : list) {
				try {
					if (folderType.equals(StartupConstants.FOLDERTYPE_LOGO)
							|| folderType
									.equals(StartupConstants.FOLDERTYPE_COVER)) {
						clearFolderContents(mainFolder);
					}
					PermissionUtil.initializeAdminPermissionCheckerByCompanyId(themeDisplay.getCompanyId());
					FileEntry fe = DLAppServiceUtil.moveFileEntry(
							fileEntry.getFileEntryId(),
							mainFolder.getFolderId(), serviceContext);
					if (folderType.equals(StartupConstants.FOLDERTYPE_LOGO))
						logoFileEntry = fe;
					addDefaultFilePermissions(companyId, fe.getFileEntryId());
					PermissionUtil.resetPermissionChecker(themeDisplay.getUser());
				} catch (Exception e) {
					logger.error(
							"Error moving file from temp to main directory", e);
				}
			}
		
		try {
			Folder folder = getStartupTempFolder(request, orgIdStr);
			DLAppServiceUtil.deleteFolder(folder.getFolderId());
			logger.debug("Deleted temp folder for organization" + orgIdStr);
		} catch (Exception e) {
			logger.error("Error deleting temp folder", e);
		}
		return logoFileEntry;
	}
	public static Object[] parseFileUploadRequest(PortletRequest actionRequest,
			PortletResponse actionResponse) throws FileUploadException {
		Object[] objs = new Object[2];
		Map<String, String> paramMap = new HashMap<String, String>();
		List<FileItem> files = new ArrayList<FileItem>();

		HttpServletRequest request_ = PortalUtil
				.getHttpServletRequest(actionRequest);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(request_);
		try {
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(httpRequest);
			String key;
			for (FileItem item : items) {
				if (item.isFormField()) {
					key = item.getFieldName();
					//key = key.substring(actionResponse.getNamespace().length());
					paramMap.put(key, item.getString());
				} else {
					files.add(item);
				}
			}

		} catch (FileUploadException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

		objs[0] = paramMap;
		objs[1] = files;

		return objs;
	}

	public static void addOrgFilesToRequest(PortletRequest actionRequest,
			Organization org) {
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put(StartupConstants.LOGO_URL,
				SambaashUtil.getDLFileUrl(actionRequest, org.getLogoId()));
		obj.put(StartupConstants.FILE_ENTRY_ID, org.getLogoId());
		actionRequest.setAttribute("logoObj", obj);
		actionRequest.setAttribute(StartupConstants.LOGO_URL, 
				SambaashUtil.getDLFileUrl(actionRequest, org.getLogoId()));

		try {
			Folder folder = getStartupFolderType(actionRequest,
					String.valueOf(org.getOrganizationId()),
					StartupConstants.FOLDERTYPE_COVER);
			List<FileEntry> files = DLAppServiceUtil.getFileEntries(
					folder.getRepositoryId(), folder.getFolderId());
			if (Validator.isNotNull(files) && files.size() > 0) {
				obj = JSONFactoryUtil.createJSONObject();
				long entryId = files.get(0).getFileEntryId();
				obj.put(StartupConstants.LOGO_URL,
						SambaashUtil.getDLFileUrl(actionRequest, entryId));
				obj.put(StartupConstants.FILE_ENTRY_ID, entryId);
				actionRequest.setAttribute("coverObj", obj);
			}

			folder = getStartupFolderType(actionRequest,
					String.valueOf(org.getOrganizationId()),
					StartupConstants.FOLDERTYPE_OTHERS);
			files = DLAppServiceUtil.getFileEntries(folder.getRepositoryId(),
					folder.getFolderId());
			if (Validator.isNotNull(files) && files.size() > 0) {
				JSONArray array = JSONFactoryUtil.createJSONArray();
				for (FileEntry fileEntry : files) {
					obj = JSONFactoryUtil.createJSONObject();
					long entryId = fileEntry.getFileEntryId();
					obj.put(StartupConstants.LOGO_URL,
							SambaashUtil.getDLFileUrl(actionRequest, entryId));
					obj.put(StartupConstants.FILE_ENTRY_ID, entryId);
					array.put(obj);
				}
				if (array.length() > 0)
					actionRequest.setAttribute("othersObj", array);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public static List<String> getShowcaseFiles(PortletRequest request,
			String orgIdStr, boolean includeTemp) {
		List<String> listOfFiles = new ArrayList<String>();
		try {
			Folder folder = getStartupFolderType(request, orgIdStr,
					StartupConstants.FOLDERTYPE_OTHERS);
			addFileNames(request, folder, listOfFiles, includeTemp, false);
			if (includeTemp) {
				folder = getStartupTempFolderType(request, orgIdStr,
					StartupConstants.FOLDERTYPE_OTHERS);
			    addFileNames(request, folder, listOfFiles, includeTemp, true);
			}
		} catch (Exception e) {
			logger.error("Error while getting files", e);
		}
		return listOfFiles;
	}

	private static void addFileNames(PortletRequest request, Folder folder,
			List<String> listOfFiles, boolean includeFullInfo, boolean isDraft)
			throws Exception {
		List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(
				folder.getRepositoryId(), folder.getFolderId());
		if (includeFullInfo) {
			for (FileEntry fileEntry : fileEntries) {
				listOfFiles.add(fileEntry.getTitle()
						+ "::"
						+ fileEntry.getFileEntryId()
						+ "::"
						+ SambaashUtil.getDLFileIconUrl(request,
								fileEntry.getFileEntryId()) + "::" + isDraft);
			}
		} else {
			for (FileEntry fileEntry : fileEntries) {
				if (fileEntry.getMimeType().toLowerCase().startsWith("image")) {
					listOfFiles.add(SambaashUtil.getDLFileIconUrl(request,
							fileEntry.getFileEntryId()));
				} else {
					listOfFiles.add(SambaashUtil.getDLFileUrl(request,
							fileEntry.getFileEntryId()));
				}
			}
		}
	}
	
}
