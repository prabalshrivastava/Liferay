package com.sambaash.platform.product.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.PermissionUtil;

public class FileUtil {

	private static Log _log = LogFactoryUtil.getLog(FileUtil.class);

	public static void setDefaultPermissions(ServiceContext serviceContext) {
		serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
		serviceContext.setGroupPermissions(
				new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER });
	}

	public static void fixFolderPermissions(ResourceRequest resourceRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Folder rootFolder = getRootFolder(themeDisplay);
		updatePermissions(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), rootFolder.getFolderId());
	}

	public static void updatePermissions(long companyId, long groupId, long primaryKey) {

		try {

			_log.error(" Updating folder permission for :  " + primaryKey);
			ResourceLocalServiceUtil.updateResources(
					companyId, groupId, DLFolder.class.getName(), primaryKey, new String[] { ActionKeys.VIEW,
							ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER },
					new String[] { ActionKeys.VIEW });

			List<DLFolder> subFolderList = DLFolderLocalServiceUtil.getFolders(groupId, primaryKey);

			for (DLFolder dlFolder : subFolderList) {
				updatePermissions(companyId, groupId, dlFolder.getFolderId());
			}
		} catch (PortalException | SystemException e) {
			_log.error("Error occured while updating permission : " + e.getMessage());
		}
	}

	public static Folder getRootFolder(ThemeDisplay themeDisplay) {
		Folder rootFolder = null;
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
		setDefaultPermissions(serviceContext);
		try {
			rootFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, SPProductConstants.ROOT_FOLDER);

		} catch (NoSuchFolderException e) {
			try {
				rootFolder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), 0,
						SPProductConstants.ROOT_FOLDER, SPProductConstants.ROOT_FOLDER, serviceContext);

				DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(),
						SPProductConstants.TEMP_FOLDER, SPProductConstants.TEMP_FOLDER, serviceContext);

				DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(),
						SPProductConstants.CERTIFICATE_FOLDER, SPProductConstants.CERTIFICATE_FOLDER, serviceContext);

				DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(),
						SPProductConstants.OUTCOME_FOLDER, SPProductConstants.OUTCOME_FOLDER, serviceContext);

				DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(),
						SPProductConstants.PRODUCT_FOLDER, SPProductConstants.PRODUCT_FOLDER, serviceContext);

				DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), rootFolder.getFolderId(),
						SPProductConstants.COURSE_CAREER_FOLDER, SPProductConstants.COURSE_CAREER_FOLDER,
						serviceContext);

			} catch (PortalException e2) {
				_log.error(e2);
			} catch (SystemException e1) {
				_log.error(e1);
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return rootFolder;

	}

	public static Folder getTempFolder(ThemeDisplay themeDisplay, long parentFolderId)
			throws PortalException, SystemException {
		return DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
				SPProductConstants.TEMP_FOLDER);
	}

	public static Folder getCertificateFolder(ThemeDisplay themeDisplay, long parentFolderId)
			throws PortalException, SystemException {
		return DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
				SPProductConstants.CERTIFICATE_FOLDER);
	}

	public static Folder getOutcomeFolder(ThemeDisplay themeDisplay, long parentFolderId)
			throws PortalException, SystemException {
		return DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
				SPProductConstants.OUTCOME_FOLDER);
	}

	public static Folder getProductFolder(ThemeDisplay themeDisplay, long parentFolderId)
			throws PortalException, SystemException {
		return DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,
				SPProductConstants.PRODUCT_FOLDER);
	}

	public static Folder getCareerFolder(PortletRequest request) throws SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Folder root = getRootFolder(themeDisplay);
		try {
			return DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), root.getFolderId(),
					SPProductConstants.COURSE_CAREER_FOLDER);
		} catch (NoSuchFolderException e) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			setDefaultPermissions(serviceContext);
			return DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), root.getFolderId(),
					SPProductConstants.COURSE_CAREER_FOLDER, SPProductConstants.COURSE_CAREER_FOLDER, serviceContext);
		}
	}

	public static Folder getAttendeeFolder(PortletRequest request) throws SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Folder root = getRootFolder(themeDisplay);
		try {
			return DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), root.getFolderId(),
					SPProductConstants.ATTENDEE_FOLDER);
		} catch (NoSuchFolderException e) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			setDefaultPermissions(serviceContext);
			return DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), root.getFolderId(),
					SPProductConstants.ATTENDEE_FOLDER, SPProductConstants.ATTENDEE_FOLDER, serviceContext);
		}
	}

	public static void moveFolder(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, String parentFolderName,
			long folderIdToMove, String folderNewName, String folderType) throws Exception {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
					resourceRequest);

			Long productBaseFolderId = getRootFolder(themeDisplay).getFolderId();
			Long rootFolderIdByFolderType = null;
			Long parentFolderId = null;

			if (SPProductConstants.CERTIFICATE_FOLDER.equalsIgnoreCase(folderType)) {
				rootFolderIdByFolderType = getCertificateFolder(themeDisplay, productBaseFolderId).getFolderId();
			} else if (SPProductConstants.PRODUCT_FOLDER.equalsIgnoreCase(folderType)) {
				rootFolderIdByFolderType = getProductFolder(themeDisplay, productBaseFolderId).getFolderId();
			} else if (SPProductConstants.OUTCOME_FOLDER.equalsIgnoreCase(folderType)) {
				rootFolderIdByFolderType = getOutcomeFolder(themeDisplay, productBaseFolderId).getFolderId();
			}

			Folder parentFolder = null;

			try {
				parentFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), rootFolderIdByFolderType,
						parentFolderName);

			} catch (PortalException e) {
				parentFolder = addFolder(resourceRequest, themeDisplay, parentFolderName, rootFolderIdByFolderType);

			}

			parentFolderId = parentFolder.getFolderId();
			_log.error("parentFolder : " + parentFolder.getFolderId() + " : parentFolder.getName() : "
					+ parentFolder.getName());

			DLAppServiceUtil.moveFolder(folderIdToMove, parentFolderId, serviceContext);

			if (Validator.isNotNull(folderNewName)) {
				DLAppServiceUtil.updateFolder(folderIdToMove, folderNewName, folderNewName, serviceContext);
			}

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

	}

	public static void moveFileToCareerFolder(PortletRequest request, long fileEntryId) {
		if (fileEntryId > 0) {

			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
				FileEntry fe = DLAppServiceUtil.getFileEntry(fileEntryId);
				Folder career = getCareerFolder(request);
				if (fe.getFolderId() != career.getFolderId()) {
					DLAppServiceUtil.moveFileEntry(fileEntryId, career.getFolderId(), serviceContext);
				}
			} catch (PortalException | SystemException e) {
				_log.error(e);
			}
		}
	}

	public static void moveFileToPersonaFolder(PortletRequest request, long fileEntryId) {
		if (fileEntryId > 0) {

			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
				FileEntry fe = DLAppServiceUtil.getFileEntry(fileEntryId);
				Folder career = getAttendeeFolder(request);
				if (fe.getFolderId() != career.getFolderId()) {
					DLAppServiceUtil.moveFileEntry(fileEntryId, career.getFolderId(), serviceContext);
				}
			} catch (PortalException | SystemException e) {
				_log.error(e);
			}
		}
	}

	public static Folder moveFile(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, long folderId,
			long tempFileEntryId, long rootFolderId, String folderType) throws Exception {
		Folder folder = null;
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					resourceRequest);

			if (SPProductConstants.OUTCOME_FOLDER.equalsIgnoreCase(folderType)) {
				Folder outcomeRootFolder = FileUtil.getOutcomeFolder(themeDisplay, rootFolderId);
				try {
					DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), outcomeRootFolder.getFolderId(),
							String.valueOf(folderId));
				} catch (PortalException e) {
					folder = addFolder(resourceRequest, themeDisplay, String.valueOf(folderId),
							outcomeRootFolder.getFolderId());
				}

				_log.error("folder.getFolderId() : " + folder.getFolderId());

			} else if (SPProductConstants.PRODUCT_FOLDER.equalsIgnoreCase(folderType)) {
				Folder productRootFolder = FileUtil.getProductFolder(themeDisplay, rootFolderId);
				try {
					folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), productRootFolder.getFolderId(),
							String.valueOf(folderId));
				} catch (PortalException e) {
					folder = addFolder(resourceRequest, themeDisplay, String.valueOf(folderId),
							productRootFolder.getFolderId());
				}

				_log.error("folder.getFolderId() : " + folder.getFolderId());
			}

			if (folder != null) {

				FileEntry fileEntry = DLAppServiceUtil.getFileEntry(tempFileEntryId);

				if (Validator.isNotNull(fileEntry) && Validator.isNotNull(fileEntry.getFolderId())
						&& fileEntry.getFolderId() != folder.getFolderId()) {
					try {
						DLAppServiceUtil.moveFileEntry(tempFileEntryId, folder.getFolderId(), serviceContext);
					} catch (DuplicateFileException e) {
						DLAppServiceUtil.deleteFileEntry(tempFileEntryId);
					}
				} else {
					_log.error(" tempFileEntryId : " + tempFileEntryId
							+ " : Both current and new folder id is same so nothing to move. Current folderId : "
							+ (Validator.isNotNull(fileEntry) && Validator.isNotNull(fileEntry.getFolderId())
									? fileEntry.getFolderId() : " : folderId not found")
							+ " : New folderId : " + folder.getFolderId());
				}

			} else {
				throw new Exception(LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.move.folder.error") + folderType);
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return folder;
	}

	public static Folder addFolder(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, String folderName,
			long parentFolderId) {
		Folder folder = null;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
					resourceRequest);
			folder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName, folderName,
					serviceContext);

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return folder;
	}

	public static JSONObject uploadToProductBrochuresFolder(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String productBrochuresFolderId = resourceRequest.getParameter("productBrochuresFolderId");

			Long folderId = null;
			if (Validator.isNumber(productBrochuresFolderId)) {
				folderId = Long.parseLong(productBrochuresFolderId);
			} else {
				Folder tempProductBrochuresFolder = addFolder(resourceRequest, themeDisplay,
						"Brochures_" + String.valueOf(DateUtil.newDate().getTime()) + "_"
								+ themeDisplay.getUser().getUserId(),
						getTempFolder(themeDisplay, getRootFolder(themeDisplay).getFolderId()).getFolderId());
				folderId = tempProductBrochuresFolder.getFolderId();
			}

			return uploadFile(resourceRequest, resourceResponse, folderId, SPProductConstants.TYPE_FOLDER);
		} catch (Exception e) {
			_log.error(e);
			JSONObject response = JSONFactoryUtil.createJSONObject();
			response.put("tempFolderId", "");
			return response;
		}
	}

	public static JSONObject uploadToCertificatesFolder(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String certificateFolderId = resourceRequest.getParameter("certificateFolderId");

			Long folderId = null;
			if (Validator.isNumber(certificateFolderId)) {
				folderId = Long.parseLong(certificateFolderId);
			} else {
				Folder tempCertificateFolder = addFolder(resourceRequest, themeDisplay,
						"Certificates_" + String.valueOf(DateUtil.newDate().getTime()) + "_"
								+ themeDisplay.getUser().getUserId(),
						getTempFolder(themeDisplay, getRootFolder(themeDisplay).getFolderId()).getFolderId());
				folderId = tempCertificateFolder.getFolderId();
			}

			return uploadFile(resourceRequest, resourceResponse, folderId, SPProductConstants.TYPE_FOLDER);
		} catch (Exception e) {
			_log.error(e);
			JSONObject response = JSONFactoryUtil.createJSONObject();
			response.put("tempFolderId", "");
			return response;
		}
	}

	public static JSONObject uploadToOutcomeLogoFolder(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String outcomeFolderId = resourceRequest.getParameter("outcomeFolderId");

			Long folderId = null;
			if (Validator.isNumber(outcomeFolderId)) {
				folderId = Long.parseLong(outcomeFolderId);
			} else {
				Folder tempOutcomeFolder = addFolder(resourceRequest, themeDisplay,
						"Outcome_" + String.valueOf(DateUtil.newDate().getTime()) + "_"
								+ themeDisplay.getUser().getUserId(),
						getTempFolder(themeDisplay, getRootFolder(themeDisplay).getFolderId()).getFolderId());
				folderId = tempOutcomeFolder.getFolderId();
			}

			return uploadFile(resourceRequest, resourceResponse, folderId, SPProductConstants.TYPE_FOLDER);
		} catch (Exception e) {
			_log.error(e);
			JSONObject response = JSONFactoryUtil.createJSONObject();
			response.put("tempFolderId", "");
			return response;
		}
	}

	public static JSONObject uploadToAttendeeImageFolder(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String attendeeFolderId = resourceRequest
					.getParameter("personaWrapperId_0_attendiesSectionId_0_attendAttachmentId_0");

			Long folderId = null;
			if (Validator.isNumber(attendeeFolderId)) {
				folderId = Long.parseLong(attendeeFolderId);
			} else {
				Folder tempOutcomeFolder = addFolder(resourceRequest, themeDisplay,
						"Outcome_" + String.valueOf(DateUtil.newDate().getTime()) + "_"
								+ themeDisplay.getUser().getUserId(),
						getTempFolder(themeDisplay, getRootFolder(themeDisplay).getFolderId()).getFolderId());
				folderId = tempOutcomeFolder.getFolderId();
			}

			return uploadFile(resourceRequest, resourceResponse, folderId, SPProductConstants.TYPE_FOLDER);
		} catch (Exception e) {
			_log.error(e);
			JSONObject response = JSONFactoryUtil.createJSONObject();
			response.put("tempFolderId", "");
			return response;
		}
	}

	public static JSONObject uploadToProductVideoFolder(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String productVideosFolderId = resourceRequest.getParameter("productVideosFolderId");

			Long folderId = null;
			if (Validator.isNumber(productVideosFolderId)) {
				folderId = Long.parseLong(productVideosFolderId);
			} else {
				Folder tempVideoFolder = addFolder(resourceRequest, themeDisplay,
						"Video_" + String.valueOf(DateUtil.newDate().getTime()) + "_"
								+ themeDisplay.getUser().getUserId(),
						getTempFolder(themeDisplay, getRootFolder(themeDisplay).getFolderId()).getFolderId());
				folderId = tempVideoFolder.getFolderId();
			}

			return uploadFile(resourceRequest, resourceResponse, folderId, SPProductConstants.TYPE_FOLDER);
		} catch (Exception e) {
			_log.error(e);
			JSONObject response = JSONFactoryUtil.createJSONObject();
			response.put("tempFolderId", "");
			return response;
		}
	}

	public static JSONObject uploadFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		return uploadFile(resourceRequest, resourceResponse, null, SPProductConstants.TYPE_FILE);
	}

	public static JSONObject uploadFile(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			Long folderId, String returnType) {

		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {

			_log.error(" folderId : " + folderId);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					resourceRequest);

			Role guestRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);

			Folder rootFolder = FileUtil.getRootFolder(themeDisplay);
			Folder tempFolder = null;

			if (Validator.isNotNull(folderId)) {
				tempFolder = DLAppServiceUtil.getFolder(folderId);
			} else {
				tempFolder = FileUtil.getTempFolder(themeDisplay, rootFolder.getFolderId());
			}

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
			_log.error("uploadPortletRequest.getFileName(file) : " + uploadPortletRequest.getFileName("file"));

			FileEntry fileEntry = null;
			InputStream is = uploadPortletRequest.getFileAsStream("file");
			String contentType = uploadPortletRequest.getContentType("file");
			long size = uploadPortletRequest.getSize("file");
			String name = uploadPortletRequest.getFileName("file");
			try {
				fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), tempFolder.getFolderId(),
						name, contentType, name, StringPool.BLANK, StringPool.BLANK, is, size, serviceContext);
			} catch (DuplicateFileException dfe) {
				name = DateUtil.newDate().getTime() + "-" + name;

				_log.error("Exception new name : " + name);
				fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), tempFolder.getFolderId(),
						name, contentType, name, StringPool.BLANK, StringPool.BLANK, is, size, serviceContext);

				_log.error("Exception fileEntry.getFileEntryId() : " + fileEntry.getFileEntryId());
			} finally {
				StreamUtil.cleanUp(is);
			}

			if (fileEntry != null) {
				PermissionUtil.addResourcePermission(themeDisplay.getCompanyId(), guestRole.getRoleId(),
						DLFileEntry.class.getName(), fileEntry.getFileEntryId(), new String[] { ActionKeys.VIEW });
			}

			if (SPProductConstants.TYPE_FOLDER.equalsIgnoreCase(returnType)) {
				response.put("tempFolderId", tempFolder.getFolderId());
			} else {
				response.put("tempFileEntryId", fileEntry.getFileEntryId());
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		}

		return response;

	}

}
