package com.sambaash.platform.portlet.spmail.action;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spmail.util.MailSchedularHelper;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment;
import com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Portlet implementation class SPMailTemplateCreateAction
 */
public class SPMailTemplateCreateAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPMailTemplateCreateAction.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		_log.info("SPMailTemplateCreateAction");

		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(renderRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String rsvpId = httpRequest.getParameter("rsvpId");
		String emailTemplateName = StringPool.BLANK;
		String emailTemplateEditorContent= StringPool.BLANK;

		if (rsvpId != null) {
			renderRequest.setAttribute("rsvpId", httpRequest.getParameter("rsvpId"));

		}
		_log.info("MailTemplateCreateAction   " + rsvpId);

		String detailTemplateId = httpRequest.getParameter("detailTemplateId");
		if (Validator.isNotNull(detailTemplateId)) {
			try {
			renderRequest.setAttribute("detailTemplateId", detailTemplateId);
			SPMailTemplate template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(GetterUtil.getLong(detailTemplateId));
			emailTemplateName = template.getTemplateName() + " (v "+ template.getVersionNumber() + ")";
			emailTemplateEditorContent = template.getHtmlContent();
			//getFileEntry(themeDisplay.getScopeGroupId(), template.getSpMailTemplateId());
			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (Validator.isNotNull(httpRequest.getParameter("redirect"))) {
			renderRequest.setAttribute("rsvpRedirect", httpRequest.getParameter("redirect"));
		}

		// end get list of mail templates
		renderRequest.setAttribute("hasAccess", (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId()) || SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId())));
		renderRequest.setAttribute("previewIcon", themeDisplay.getPathThemeImages() + "/calendar/icon-preview-01@2x.png");
		renderRequest.setAttribute("emailTemplateName", emailTemplateName);
		renderRequest.setAttribute("emailTemplateContent", emailTemplateEditorContent);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		String listingPageName = preferences.getValue("listingPageName", StringPool.BLANK);
		renderRequest.setAttribute("listingPageName", listingPageName);

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {

		PortletPreferences preferences = actionRequest.getPreferences();
		String action = actionRequest.getParameter("action");
		if ("editTemplate".equalsIgnoreCase(action)) {
			String listingPageName = actionRequest.getParameter("listingPageName");
			preferences.setValue("listingPageName", listingPageName);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} else {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil
					.getHttpServletRequest(actionRequest));
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String rsvpId = httpRequest.getParameter("rsvpId");
			_log.info("MailTemplateaction   " + rsvpId);
			String filesAttachmentStream = actionRequest.getParameter("attachmentsFileTotal");
			String fileIds = actionRequest.getParameter("imageFileTotal");
			String templateName = actionRequest.getParameter("templateTitle");
			String subject = actionRequest.getParameter("txtSubject");
			String htmlContent = actionRequest.getParameter("template_content");
			String htmlContentByUpload = actionRequest.getParameter("EditorContent");
			String rsvpRedirect1 = actionRequest.getParameter("rsvpRedirect");
			String newFlag = actionRequest.getParameter("newFlag");
			String updateTemplateId = actionRequest.getParameter("updateTemplateId");
			String uploadHtml = actionRequest.getParameter("htmlUpload");

			_log.info(rsvpRedirect1);
			String[] lstFileEntryIds = null;
			String[] lstImageFileIds = null;

			Calendar cal = Calendar.getInstance();
			_log.error("filesAttachmentStream" + filesAttachmentStream);
			try {
				long spTemplateAttachementId = CounterLocalServiceUtil.increment("SPTemplateAttachment.class");
				if ("true".equals(newFlag)) {
					long spMailTemplateId = CounterLocalServiceUtil.increment("SPMailTemplate.class");
					SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil
							.createSPMailTemplate(spMailTemplateId);

					if (null != filesAttachmentStream) {
						if (!filesAttachmentStream.trim().equals("")) {
							lstFileEntryIds = filesAttachmentStream.split(",");

							for (String fileEntryId : lstFileEntryIds) {

								SPMailTemplateAttachment spTemplateAttachment = SPMailTemplateAttachmentLocalServiceUtil
										.createSPMailTemplateAttachment(spTemplateAttachementId);

								spTemplateAttachment.setTemplateId(spMailTemplateId);
								_log.info("rsvpId   " + rsvpId);
								if (rsvpId != null) {
									if (!rsvpId.trim().equals("")) {
										spTemplateAttachment.setRsvpId(Long.valueOf(rsvpId));
									}
								}
								spTemplateAttachment.setFileEntryId(Long.valueOf(fileEntryId));
								SPMailTemplateAttachmentLocalServiceUtil
										.addSPMailTemplateAttachment(spTemplateAttachment);

							}
						}

					}

					if (Validator.isNotNull(fileIds)) {
						lstImageFileIds = fileIds.split(",");
						for (String fileEntryId : lstImageFileIds) {
							try {
								if (Validator.isNotNull(fileEntryId)) {
									FileEntry fileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(fileEntryId));
									addImageFile(fileEntry, themeDisplay.getScopeGroupId(),
											ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest),
											spMailTemplateId);
								}
							} catch (Exception e) {
								_log.error(e);
							}

						}

					}

					spMailTemplate.setTemplateName(templateName);
					spMailTemplate.setSubject(subject);
					spMailTemplate.setHtmlContent(htmlContent);
					spMailTemplate.setStatus(false);
					spMailTemplate.setCreateBy(themeDisplay.getUserId());
					spMailTemplate.setCreateDate(cal.getTime());
					spMailTemplate.setModifiedBy(themeDisplay.getUserId());
					spMailTemplate.setModifiedDate(cal.getTime());
					spMailTemplate.setGroupId(themeDisplay.getScopeGroupId());
					spMailTemplate.setCompanyId(themeDisplay.getCompanyId());
					spMailTemplate.setVersionNumber("1");
					spMailTemplate.setParentTempalteId(spMailTemplate.getSpMailTemplateId());
					if (Validator.isNotNull(uploadHtml)) {
						if(uploadHtml.equalsIgnoreCase("true")){
							spMailTemplate.setHtmlUpload(Boolean.valueOf(uploadHtml));
							spMailTemplate.setHtmlContent(htmlContentByUpload);
						}	
					}

					SPMailTemplateLocalServiceUtil.addCustomSPMailTemplate(spMailTemplate);

				} else {

					try {

						SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long
								.valueOf(updateTemplateId));

						long spMailTemplateId = CounterLocalServiceUtil.increment("SPMailTemplate.class");
						SPMailTemplate spMailTemplateUpdate = SPMailTemplateLocalServiceUtil
								.createSPMailTemplate(spMailTemplateId);

						spMailTemplateUpdate.setTemplateName(templateName);
						spMailTemplateUpdate.setSubject(subject);
						spMailTemplateUpdate.setHtmlContent(htmlContent);
						spMailTemplateUpdate.setStatus(false);
						spMailTemplateUpdate.setFromName(spMailTemplate.getFromName());
						spMailTemplateUpdate.setFromAddress(spMailTemplate.getFromAddress());
						spMailTemplateUpdate.setProductTypeId(spMailTemplate.getProductTypeId());
						spMailTemplateUpdate.setSubProductTypeId(spMailTemplate.getSubProductTypeId());
						spMailTemplateUpdate.setCreateBy(themeDisplay.getUserId());
						spMailTemplateUpdate.setCreateDate(cal.getTime());
						spMailTemplateUpdate.setModifiedBy(themeDisplay.getUserId());
						spMailTemplateUpdate.setModifiedDate(cal.getTime());
						spMailTemplateUpdate.setGroupId(themeDisplay.getScopeGroupId());
						spMailTemplateUpdate.setCompanyId(themeDisplay.getCompanyId());
						if (Validator.isNotNull(uploadHtml)) {
							if(uploadHtml.equalsIgnoreCase("true")){
								spMailTemplateUpdate.setHtmlUpload(Boolean.valueOf(uploadHtml));
								spMailTemplateUpdate.setHtmlContent(htmlContentByUpload);
							}	
						}
						List<SPMailTemplate> lstSPMailTemplate = null;

						if (spMailTemplate.getParentTempalteId() != 0) {
							lstSPMailTemplate = SPMailTemplateLocalServiceUtil.findByparentTempalteId(spMailTemplate
									.getParentTempalteId());
							spMailTemplateUpdate.setParentTempalteId(spMailTemplate.getParentTempalteId());
						} else {
							lstSPMailTemplate = SPMailTemplateLocalServiceUtil.findByparentTempalteId(Long
									.valueOf(updateTemplateId));
							spMailTemplateUpdate.setParentTempalteId(Long.valueOf(updateTemplateId));
						}

						if (null != filesAttachmentStream) {
							if (!filesAttachmentStream.trim().equals("")) {
								lstFileEntryIds = filesAttachmentStream.split(",");

								for (String fileEntryId : lstFileEntryIds) {
									List<SPMailTemplateAttachment> lstExistingAttach = null;
									if ("false".equals(newFlag)) {
										lstExistingAttach = SPMailTemplateAttachmentLocalServiceUtil
												.findByTemplateIdFileEntryId(
														spMailTemplateUpdate.getSpMailTemplateId(),
														Long.valueOf(fileEntryId));
									}
									_log.error("lstExistingAttach" + lstExistingAttach);
									if (lstExistingAttach.isEmpty()) {
										SPMailTemplateAttachment spTemplateAttachment = SPMailTemplateAttachmentLocalServiceUtil
												.createSPMailTemplateAttachment(spTemplateAttachementId);
										spTemplateAttachment.setTemplateId(Long.valueOf(spMailTemplateId));
										_log.info("rsvpId   " + rsvpId);
										if (rsvpId != null) {
											if (!rsvpId.trim().equals("")) {
												spTemplateAttachment.setRsvpId(Long.valueOf(rsvpId));
											}
										}
										spTemplateAttachment.setFileEntryId(Long.valueOf(fileEntryId));
										SPMailTemplateAttachmentLocalServiceUtil
												.addSPMailTemplateAttachment(spTemplateAttachment);
									}/*else{
										FileEntry fileEntry = DLAppServiceUtil.getFileEntry(Long.valueOf(fileEntryId));
										if(Validator.isNotNull(fileEntry)){
											DLFileEntryLocalServiceUtil.
											DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), fileEntry.getFolderId(), fileEntry.getTitle(),
													fileEntry.getMimeType(), fileEntry.getTitle(), StringPool.BLANK, StringPool.BLANK, inputStream, fileEntry.getSize(),
													ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest));
										}
										
									}*/		
								}
								
							}
						}
						double maxVersionNumber = 0.0;

						if (lstSPMailTemplate.size() == 0) {
							maxVersionNumber = 1;
						} else {
							for (SPMailTemplate sp : lstSPMailTemplate) {
								if (Double.parseDouble(sp.getVersionNumber()) > maxVersionNumber) {
									maxVersionNumber = Double.parseDouble(sp.getVersionNumber());
								}
							}
						}
						maxVersionNumber = maxVersionNumber + 0.1;

						DecimalFormat df = new DecimalFormat("#.##");
						spMailTemplateUpdate.setVersionNumber(df.format(maxVersionNumber));

						SPMailTemplateLocalServiceUtil.addCustomSPMailTemplate(spMailTemplateUpdate);

					} catch (Exception e) {
						_log.error(e.getMessage());
					}
				}

				actionRequest.setAttribute("success", true);
				actionRequest.setAttribute("rsvpRedirectURL", rsvpRedirect1);
				if (rsvpId != null) {
					if (!rsvpId.trim().equals("")) {
						rsvpRedirect1 += "&rsvpId=" + rsvpId;
						actionResponse.sendRedirect(rsvpRedirect1);
					}

				}
				if (Validator.isNotNull(rsvpRedirect1)) {
					actionResponse.sendRedirect(rsvpRedirect1);
				}

			} catch (SystemException e) {
				_log.error(e);
			}

			String listingPageName = preferences.getValue("listingPageName", StringPool.BLANK);
			actionResponse.sendRedirect(PortalUtil.getPortalURL(actionRequest) + StringPool.FORWARD_SLASH
					+ listingPageName + "?flag=success");
		}

	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		_log.info("serveResource");
		String filterName = resourceRequest.getParameter("filterName");
		String filterValue = resourceRequest.getParameter("filterValue");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String detailTemplateId = resourceRequest.getParameter("detailTemplateId");
		_log.info("filterName  " + filterName + " filterValue " + filterValue);

		if ("templateDetail".equals(filterName)) {
			try {
				JSONObject lstObjectObject = JSONFactoryUtil.createJSONObject();
				SPMailTemplate spMailTemplate = SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long
						.parseLong(filterValue));
				JSONObject spMailTemplateObject = JSONFactoryUtil.createJSONObject();
				spMailTemplateObject.put("id", spMailTemplate.getSpMailTemplateId());
				spMailTemplateObject.put("title", spMailTemplate.getTemplateName());
				spMailTemplateObject.put("subject", spMailTemplate.getSubject());
				spMailTemplateObject.put("htmlContent", spMailTemplate.getHtmlContent());
				spMailTemplateObject.put("textContent", spMailTemplate.getTextContent());
				spMailTemplateObject.put("modifiedBy", spMailTemplate.getModifiedBy());
				spMailTemplateObject.put("modifiedDate", spMailTemplate.getModifiedDate());
				spMailTemplateObject.put("status", spMailTemplate.getStatus());
				spMailTemplateObject.put("attachment",
						MailSchedularHelper.getFileEntry(themeDisplay.getScopeGroupId(), spMailTemplate.getSpMailTemplateId()));

				spMailTemplateObject.put("images",
						getImageFileEntry(themeDisplay.getScopeGroupId(), spMailTemplate.getSpMailTemplateId()));
				spMailTemplateObject.put("htmlUpload", spMailTemplate.getHtmlUpload());
				lstObjectObject.put(String.valueOf(spMailTemplate.getSpMailTemplateId()), spMailTemplateObject);
				resourceResponse.getWriter().append(lstObjectObject.toString());
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}

		} else if ("deleteFile".equals(filterName)) {
			try {
				List<SPMailTemplateAttachment> mailTemplateAttchList = SPMailTemplateAttachmentLocalServiceUtil.findByfileEntryId(Long.valueOf(filterValue));
				if(mailTemplateAttchList.size() == 1){
					DLAppServiceUtil.deleteFileEntry(Long.valueOf(filterValue));
				}
			} catch (Exception e) {
				_log.error(e);
			}
		} else if ("imagesUploadHTML".equals(filterName)) {
			try {
				String inputString = readHTMLContent(resourceRequest);
				resourceResponse.getWriter().append(inputString);
			} catch (Exception e) {
				_log.error(e);
			}

		} else {
			try {
				HashMap<String, String> imageMap = addFileEntry(resourceRequest);

				JSONObject fileUploadObject = JSONFactoryUtil.createJSONObject();
				for (String key : imageMap.keySet()) {
					fileUploadObject.put(key, imageMap.get(key));
				}

				resourceResponse.getWriter().append(fileUploadObject.toString());

			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}
		}

	}

	private String readHTMLContent(ResourceRequest resourceRequest) throws IOException, PortalException,
			SystemException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(resourceRequest));
		String content = "";
		try {
			@SuppressWarnings("rawtypes")
			List items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(httpRequest);
			if (items != null) {
				for (int i = 0; i < items.size(); i++) {
					FileItem fileItem = (FileItem) items.get(i);

					InputStream inputStream = fileItem.getInputStream();

					BufferedInputStream buff = new BufferedInputStream(inputStream);
					byte[] bytes = new byte[buff.available()];
					buff.read(bytes, 0, bytes.length);
					content = new String(bytes);

				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return content;
	}

	private HashMap<String, String> addFileEntry(ResourceRequest resourceRequest) throws IOException, PortalException,
			SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(resourceRequest));
		String imageUrl = "";
		HashMap<String, String> fileEntryMap = new HashMap<String, String>();
		long folderId = 0;

		if ("imagesUpload".equals(resourceRequest.getParameter("cmd"))) {
			folderId = initFolder(themeDisplay.getScopeGroupId(),
					ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest), "images");

		} else {
			folderId = initFolder(themeDisplay.getScopeGroupId(),
					ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest), "attachments");
		}

		try {
			@SuppressWarnings("rawtypes")
			List items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(httpRequest);

			if (items != null) {
				for (int i = 0; i < items.size(); i++) {
					FileItem fileItem = (FileItem)items.get(i);
					InputStream inputStream = fileItem.getInputStream();
					String mimeType = fileItem.getContentType();
					FileEntry fileEntry = null;

					Calendar cal = Calendar.getInstance();
					String fileName = fileItem.getName().substring(0, fileItem.getName().indexOf(".")) +
							cal.getTimeInMillis() +
							fileItem.getName()
									.substring(fileItem.getName().indexOf("."), fileItem.getName().length());

					fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName,
							mimeType, fileName, StringPool.BLANK, StringPool.BLANK, inputStream, fileItem.getSize(),
							ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest));

					imageUrl = "/documents/" + themeDisplay.getScopeGroupId() + "/" + folderId + "/" +
							fileEntry.getTitle();
					fileEntryMap.put(String.valueOf(fileEntry.getFileEntryId()), imageUrl);
				}
			}
		} catch (FileUploadException e) {
			_log.error(e);
		}

		return fileEntryMap;
	}

	private long initFolder(long repositoryId, ServiceContext serviceContext, String folderName) throws PortalException {
		Folder folder = null;
		long folderId = 0;
		serviceContext.setGroupPermissions(null);
		serviceContext.setGuestPermissions(null);
		long parentFolderId = 0;

		try {
			try {
				parentFolderId = DLAppServiceUtil.getFolder(repositoryId, 0, "SPMailTemplate").getFolderId();
			} catch (Exception e) {
				if (parentFolderId == 0) {
					Folder folderParent = DLAppServiceUtil.addFolder(repositoryId, 0, "SPMailTemplate",
							StringPool.BLANK, serviceContext);
					parentFolderId = folderParent.getFolderId();
				}
			}

			try {
				folder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			} catch (NoSuchFolderException e) {
				_log.error(e);
			}

			if (folder == null) {
				folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, folderName, folderName,
						serviceContext);
			}
			if (folder != null) {
				folderId = folder.getFolderId();
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return folderId;
	}

	private void addImageFile(FileEntry f, long repositoryId, ServiceContext serviceContext, long spMailTemplateId)
			throws PortalException {
		long parentFolderId = 0;
		long secondParentFolderId = 0;
		long thirdParentFolderId = 0;

		try {
			parentFolderId = DLAppServiceUtil.getFolder(repositoryId, 0, "SPMailTemplate").getFolderId();
		} catch (Exception e) {
			if (parentFolderId == 0) {
				Folder folderParent;
				try {
					folderParent = DLAppServiceUtil.addFolder(repositoryId, 0, "SPMailTemplate", StringPool.BLANK,
							serviceContext);
					parentFolderId = folderParent.getFolderId();
				} catch (SystemException e1) {
					_log.error(e1);
				}
			}
		}

		try {
			secondParentFolderId = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, "images").getFolderId();
		} catch (Exception e) {
			if (parentFolderId == 0) {
				Folder folderParent;
				try {
					folderParent = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, "images", StringPool.BLANK,
							serviceContext);
					secondParentFolderId = folderParent.getFolderId();
				} catch (SystemException e1) {
					_log.error(e1);
				}
			}
		}

		try {
			thirdParentFolderId = DLAppServiceUtil.getFolder(repositoryId, secondParentFolderId,
					String.valueOf(spMailTemplateId)).getFolderId();
		} catch (Exception e) {
			if (thirdParentFolderId == 0) {
				Folder folderParent;
				try {
					folderParent = DLAppServiceUtil.addFolder(repositoryId, secondParentFolderId,
							String.valueOf(spMailTemplateId), StringPool.BLANK, serviceContext);
					thirdParentFolderId = folderParent.getFolderId();
				} catch (SystemException e1) {
					_log.error(e1);
				}
			}

		}
		try {
			f = DLAppServiceUtil.addFileEntry(repositoryId, thirdParentFolderId, f.getTitle(), f.getMimeType(),
					f.getTitle(), f.getDescription(), StringPool.BLANK, f.getContentStream(), f.getSize(),
					serviceContext);
			DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, secondParentFolderId, f.getTitle());

		} catch (Exception e) {
			_log.error(e);
		}

	}

	private String getImageFileEntry(long groupId, long templateId) {
		String fileString = "";
		try {
			Folder folder = DLAppServiceUtil.getFolder(groupId, 0, "SPMailTemplate");

			long secondParentFolderId = DLAppServiceUtil.getFolder(groupId, folder.getFolderId(), "images")
					.getFolderId();
			Folder subFolder = DLAppServiceUtil.getFolder(groupId, secondParentFolderId, String.valueOf(templateId));
			List<FileEntry> lstFileEntry = DLAppServiceUtil.getFileEntries(groupId, subFolder.getFolderId());
			for (FileEntry f : lstFileEntry) {

				String imageUrl = "/documents/" + groupId + "/" + f.getFolderId() + "/" + f.getTitle();

				imageUrl += ":" + f.getFileEntryId();
				if (!("".equals(fileString))) {
					fileString += "," + imageUrl;
				} else {
					fileString = imageUrl;
				}

			}
		} catch (Exception e) {
			_log.error(e);
		}
		return fileString;
	}

}
