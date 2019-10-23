/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.spdynamicforms.service.impl;

import static com.sambaash.platform.dynamicforms.DynamicFormsConstants.DEFAULT_FORM_APP_VERSION;
import static com.sambaash.platform.dynamicforms.DynamicFormsConstants.LOAD_FORM_ID;
import static com.sambaash.platform.dynamicforms.DynamicFormsConstants.LOAD_FORM_READ_ONLY;
import static com.sambaash.platform.dynamicforms.DynamicFormsConstants.LOAD_FORM_STORAGE_ID;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage;
import com.sambaash.platform.srv.spdynamicforms.service.SPFormStorageLocalServiceUtil;
import com.sambaash.platform.srv.spdynamicforms.service.base.SPDynamicFormsLocalServiceBaseImpl;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p dynamic forms local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spdynamicforms.service.base.SPDynamicFormsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalServiceUtil
 */
public class SPDynamicFormsLocalServiceImpl extends SPDynamicFormsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.spdynamicforms.service.
	 * SPDynamicFormsLocalServiceUtil} to access the s p dynamic forms local
	 * service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(SPDynamicFormsLocalServiceImpl.class);

	private static final List<String> INTERNAL_FIELD_LIST = Arrays.asList("saveAsDraft", "_USER_NAME", "_USER_ID",
			"_USER_ROLES", "_GROUP_ID", "_COMPANY_ID", "_IS_DRAFT", "_PK", "saveStatus", "_USER_EMAIL",
			"_USER_FIRST_NAME", "_USER_LAST_NAME", "_MODE");

	public JSONObject retrieveLoadParam(RenderRequest renderRequest) {
		JSONObject param = JSONFactoryUtil.createJSONObject();
		String action = renderRequest.getParameter("actionp");
		param.put("action", action);
		param.put(LOAD_FORM_ID, renderRequest.getParameter(LOAD_FORM_ID));
		param.put(LOAD_FORM_STORAGE_ID, renderRequest.getParameter(LOAD_FORM_STORAGE_ID));
		param.put(LOAD_FORM_READ_ONLY, renderRequest.getParameter(LOAD_FORM_READ_ONLY));
		return param;
	}

	public void handleLoadData(ResourceRequest request, ResourceResponse response) {
		long formStorageId = ParamUtil.getLong(request, LOAD_FORM_STORAGE_ID);
		try {
			SPFormStorage data = SPFormStorageLocalServiceUtil.getSPFormStorage(formStorageId);
			response.getWriter().write(data.getContent());
		} catch (Exception e) {
			LOG.error("Unable to get retrieve form storage", e);
			Util.setErrorResponse(response, e);
		}
	}

	public void handlePersist(ResourceRequest request, ResourceResponse response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long formId = ParamUtil.getLong(request, "formId");
			Long pkId = ParamUtil.getLong(request, "formStorageId");
			String jsonString = ParamUtil.getString(request, "data");
			JSONObject jsonData = JSONFactoryUtil.createJSONObject(jsonString);
			response.getWriter().write(persistFormJsonData(themeDisplay, formId, pkId, jsonData));
		} catch (Exception e) {
			LOG.error("Unable to persist form data", e);
			Util.setErrorResponse(response, e);
		}
	}

	public String persistFormJsonData(ThemeDisplay themeDisplay, long formId, Long formStorageId,
			JSONObject formJsonData) throws SystemException, PortalException {
		removeInternalData(formJsonData);
		SPFormStorage formStorage;
		if (formStorageId != null && formStorageId > 0) {
			formStorage = SPFormStorageLocalServiceUtil.fetchSPFormStorage(formStorageId);
			formStorage.setModifiedDate(new Date());
		} else {
			User u = themeDisplay.getUser();
			formStorageId = CounterLocalServiceUtil.increment("SPFormStorage");
			formStorage = SPFormStorageLocalServiceUtil.createSPFormStorage(formStorageId);
			formStorage.setCreateDate(new Date());
			storeUserInformation(formStorage, u);
		}
		formStorage.setApplicationId(DEFAULT_FORM_APP_VERSION);
		formStorage.setHtmlFormId(formId);
		formStorage.setContent(formJsonData.toString());
		SPFormStorageLocalServiceUtil.updateSPFormStorage(formStorage);
		return JSONFactoryUtil.looseSerialize(formStorage);
	}
	
	public String handlePersist(long userId, long formId, long formStorageId, String jsonString) {
		try {
			JSONObject jsonData = JSONFactoryUtil.createJSONObject(jsonString);
			removeInternalData(jsonData);
			SPFormStorage formStorage;
			if (formStorageId > 0) {
				formStorage = SPFormStorageLocalServiceUtil.fetchSPFormStorage(formStorageId);
				formStorage.setModifiedDate(new Date());
			} else {
				User u = UserLocalServiceUtil.getUser(userId);
				formStorageId = CounterLocalServiceUtil.increment("SPFormStorage");
				formStorage = SPFormStorageLocalServiceUtil.createSPFormStorage(formStorageId);
				formStorage.setCreateDate(new Date());
				storeUserInformation(formStorage, u);
			}
			formStorage.setApplicationId(DEFAULT_FORM_APP_VERSION);
			formStorage.setHtmlFormId(formId);
			formStorage.setContent(jsonData.toString());
			SPFormStorageLocalServiceUtil.updateSPFormStorage(formStorage);
			return JSONFactoryUtil.looseSerialize(formStorage);
		} catch (Exception e) {
			LOG.error("Unable to persist form data", e);
			return "{}";
		}
	}

	private void storeUserInformation(SPFormStorage formStorage, User u) throws PortalException, SystemException {
		formStorage.setUserId(u.getUserId());
		formStorage.setUserName(u.getFullName());
		formStorage.setCompanyId(u.getCompanyId());
		try {
			formStorage.setGroupId(u.getGroupId());
		} catch (Exception e) {
			LOG.debug("Unable to persist group info : " + e.getMessage());
			// means this was persisted by Guest user
			formStorage.setUserName("Guest");
		}
	}

	private void removeInternalData(JSONObject jsonData) {
		for (String field : INTERNAL_FIELD_LIST) {
			try {
				jsonData.remove(field);				
			} catch (Exception e) {
				// ignore if not present
			}
		}
	}

	public void handleFileUpload(ResourceRequest request, ResourceResponse response) {
		JSONObject retObj = JSONFactoryUtil.createJSONObject();
		JSONArray objArr = JSONFactoryUtil.createJSONArray();
		try {
			Object[] multiPartData = Util.parseFileUploadRequest(request);

			FileEntry fe = null;
			if (ArrayUtil.isNotEmpty(multiPartData)) {
				@SuppressWarnings("unchecked")
				List<FileItem> files = (List<FileItem>) multiPartData[1];
				if (Validator.isNotNull(files) && files.size() > 0) {
					for (FileItem f : files) {
						JSONObject obj = JSONFactoryUtil.createJSONObject();
						fe = Util.uploadFile(request, f, false);
						if (Validator.isNotNull(fe)) {
							String fileUrl = SambaashUtil.getDLFileUrl(request, fe.getFileEntryId());
							obj.put("name", f.getName());
							obj.put("size", f.getSize());
							obj.put("url", fileUrl);
							obj.put("fileEntryId", fe.getFileEntryId());
						} else {
							obj.put("error", "Error uploading the file.");
						}
						objArr.put(obj);
					}
					retObj.put("result", objArr);
					retObj.put("data", objArr.getJSONObject(0));
				}
			}
			response.getWriter().write(retObj.toString());
		} catch (Exception e) {
			LOG.error("Error uploading files.", e);
		}
	}

	private static class Util {
		private static final String FILE_CLASSNAME = DLFileEntry.class.getName();
		private static final String FOLDER_CLASSNAME = DLFolder.class.getName();
		private static final String[] DEFAULT_PERMISSIONS = { "SHARE", ActionKeys.DELETE, ActionKeys.PERMISSIONS,
				ActionKeys.VIEW, ActionKeys.UPDATE };
		private static final String DEFAULT_PERMISSION_ROLES = "Site Member"; // comma-delimited
		private static final long DL_ROOT_FOLDER_ID = 0;
		private static final Log LOG = LogFactoryUtil.getLog(Util.class);

		private Util() {
			// only static methods can be added here
		}

		@SuppressWarnings("unchecked")
		public static Object[] parseFileUploadRequest(PortletRequest actionRequest) throws FileUploadException {
			Object[] objs = new Object[2];
			Map<String, String> paramMap = new HashMap<>();
			List<FileItem> files = new ArrayList<>();

			HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
			try {
				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(httpRequest);
				String key;
				for (FileItem item : items) {
					if (item.isFormField()) {
						key = item.getFieldName();
						paramMap.put(key, item.getString());
					} else {
						files.add(item);
					}
				}

			} catch (FileUploadException e) {
				LOG.error(e.getMessage(), e);
				throw e;
			}

			objs[0] = paramMap;
			objs[1] = files;

			return objs;
		}

		public static FileEntry uploadFile(PortletRequest request, FileItem item, boolean isTemp)
				throws PortalException, SystemException {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(FILE_CLASSNAME, request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long scopeGroupId = themeDisplay.getScopeGroupId();
			long companyId = themeDisplay.getCompanyId();
			FileEntry fileEntry = null;

			Folder folder = getSPFormFolder(request, isTemp);

			final long folderId = folder.getFolderId();
			String name = item.getName();

			try {
				fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId, folderId, name, item.getContentType(), name,
						StringPool.BLANK, StringPool.BLANK, item.getInputStream(), item.getSize(), serviceContext);
				addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
			} catch (DuplicateFileException ex) {
				fileEntry = DLAppServiceUtil.getFileEntry(scopeGroupId, folderId, name); // the
																							// duplicate
				DLFileVersion fileVersion = DLFileVersionLocalServiceUtil
						.getLatestFileVersion(fileEntry.getFileEntryId(), false);
				if (fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE) {
					fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
					DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
				}
				try {
					fileEntry = DLAppServiceUtil.updateFileEntryAndCheckIn(fileEntry.getFileEntryId(),
							fileEntry.getTitle(), item.getContentType(), name, "", "", true, item.getInputStream(),
							item.getSize(), serviceContext);
					addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
				} catch (FileSizeException fs) {
					LOG.error("File size exceeds maximum allowed limit" + fs.getMessage());
				} catch (Exception ex1) {
					LOG.error("Error while uploading file " + ex1.getMessage());
				}
			} catch (IOException e) {
				LOG.error("Error uploading file.", e);
			}
			return fileEntry;
		}

		private static String getSPFormFolderName(long formId) {
			return String.format("SPForm/%d", formId);
		}

		private static String getUserFolderName(long userId, long formId) {
			return String.format("%s/User_%d", getSPFormFolderName(formId), userId);
		}

		private static void addDefaultFolderPermissions(long companyId, long folderId) {
			addDefaultPermissions(companyId, folderId, FOLDER_CLASSNAME);
		}

		private static void addDefaultFilePermissions(long companyId, long fileEntryId) {
			addDefaultPermissions(companyId, fileEntryId, FILE_CLASSNAME);
		}

		private static void addDefaultPermissions(long companyId, long entryId, String permClassname) {
			String[] privilegedRoles = DEFAULT_PERMISSION_ROLES.split(",");
			for (String roleName : privilegedRoles) {
				try {
					Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
					PermissionUtil.addResourcePermission(companyId, role.getRoleId(), permClassname, entryId,
							DEFAULT_PERMISSIONS);
				} catch (Exception e) {
					LOG.error("Error while assigning permissions to roles " + e.getMessage());
				}
			}
		}

		private static Folder getSPFormFolder(PortletRequest request, boolean isTemp)
				throws PortalException, SystemException {
			Folder folder;
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String formId = request.getParameter(LOAD_FORM_ID);
			long id = StringUtils.isEmpty(formId) ? 0L : Long.parseLong(formId);
			String folderName = getUserFolderName(themeDisplay.getUserId(), id);
			if (isTemp) {
				folderName = folderName + "/temp";
			}
			folder = recursiveGetFolder(request, new LinkedList<>(Arrays.asList(folderName.split("/"))), null);
			return folder;
		}

		private static Folder recursiveGetFolder(PortletRequest request, LinkedList<String> folderList,
				Folder parentFolder) throws PortalException, SystemException {
			if (folderList.isEmpty())
				return parentFolder;
			String folderName = folderList.removeFirst();
			Folder folder = getFolder(request, folderName,
					parentFolder == null ? DL_ROOT_FOLDER_ID : parentFolder.getFolderId());
			return recursiveGetFolder(request, folderList, folder);
		}

		private static Folder getFolder(PortletRequest request, String folderName, Long parentFolderId)
				throws PortalException, SystemException {
			if (folderName == null) {
				return null;
			}
			Folder folder;
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getScopeGroupId();
			try {
				folder = DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			} catch (NoSuchFolderException ex) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(FOLDER_CLASSNAME, request);

				LOG.error("groupId : " + groupId + " : parentFolderId : " + parentFolderId + " : folderName : "
						+ folderName);

				updatePermissions(themeDisplay.getCompanyId(), groupId, parentFolderId);

				folder = DLAppServiceUtil.addFolder(groupId, parentFolderId, folderName, folderName, serviceContext);
				addDefaultFolderPermissions(themeDisplay.getCompanyId(), folder.getFolderId());
			} catch (PortalException | SystemException e) {
				folder = null;
				LOG.error("Error while getting folder" + e.getMessage());
			}
			return folder;
		}

		public static void setErrorResponse(ResourceResponse response, Exception e) {
			JSONObject errorObj = JSONFactoryUtil.createJSONObject();
			String errMsg = StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString();
			errorObj.put("error", errMsg);
			try {
				response.getWriter().write(errorObj.toString());
			} catch (Exception e2) {
				// should not reach here
				LOG.error("Error returning error message", e);
			}
		}

		public static void updatePermissions(long companyId, long groupId, long primaryKey) {
			try {
				LOG.error(" Updating folder permission for :  " + primaryKey);
				ResourceLocalServiceUtil.updateResources(companyId,
						groupId, DLFolder.class.getName(), primaryKey, new String[] { ActionKeys.VIEW,
								ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER },
						new String[] { ActionKeys.VIEW });
			} catch (PortalException | SystemException e) {
				LOG.error("Error occured while updating permission : " + e.getMessage());
			}
		}

	}

}