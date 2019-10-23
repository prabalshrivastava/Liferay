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

package com.sambaash.platform.srv.processbuilder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FormBuilder. This utility wraps
 * {@link com.sambaash.platform.srv.processbuilder.service.impl.FormBuilderLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nareshchebolu
 * @see FormBuilderLocalService
 * @see com.sambaash.platform.srv.processbuilder.service.base.FormBuilderLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.impl.FormBuilderLocalServiceImpl
 * @generated
 */
public class FormBuilderLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.processbuilder.service.impl.FormBuilderLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the URL to fetch form schema for single form.
	*  URL will have place holders for params required by form builder
	*
	* @return
	*/
	public static java.lang.String getUrlTemplateFormSchema() {
		return getService().getUrlTemplateFormSchema();
	}

	/**
	* Returns URL to fetch form schema for multiple forms
	* URL will have place holders for params required by form builder
	*
	* @return
	*/
	public static java.lang.String getUrlTemplateFormSchemas() {
		return getService().getUrlTemplateFormSchemas();
	}

	/**
	* Returns URL to fetch list of form
	*  URL will have place holders for params required by form builder
	*/
	public static java.lang.String getUrlTemplateFormsList() {
		return getService().getUrlTemplateFormsList();
	}

	public static java.lang.String getUrlTemplateFormStorageList() {
		return getService().getUrlTemplateFormStorageList();
	}

	/**
	* This url template used for loading form which is submitted earlier.
	* Each submitted form gets storage id.
	*
	* @return
	*/
	public static java.lang.String getUrlTemplateLoadFormWithStorageId() {
		return getService().getUrlTemplateLoadFormWithStorageId();
	}

	/**
	* This url template used for loading fresh form
	*
	* @return
	*/
	public static java.lang.String getUrlTemplateLoadFormWithOutStorageId() {
		return getService().getUrlTemplateLoadFormWithOutStorageId();
	}

	/**
	* Method used to get url for  attachment info
	*
	* @return
	*/
	public static java.lang.String getUrlTemplateAttachmentSInfo() {
		return getService().getUrlTemplateAttachmentSInfo();
	}

	/**
	* Method to get url for loading the form
	*/
	public static java.lang.String getUrlFormLoad(long formId, long processId,
		long entityId, long entityClassId) {
		return getService()
				   .getUrlFormLoad(formId, processId, entityId, entityClassId);
	}

	/**
	* Returns URL to fetch form schema for single form
	*
	* @param applicationId
	* @param authToke
	* @param userId
	* @param formIds
	* @return
	*/
	public static java.lang.String getUrlFormSchema(
		java.lang.String applicationId, java.lang.String authToke, long userId,
		long formId) {
		return getService()
				   .getUrlFormSchema(applicationId, authToke, userId, formId);
	}

	/**
	* Returns URL to fetch form schema for multiple forms
	*
	* @param applicationId
	* @param authToke
	* @param userId
	* @param formIds
	* @return
	*/
	public static java.lang.String getUrlFormSchemas(
		java.lang.String applicationId, java.lang.String authToke, long userId,
		java.lang.String formIds) {
		return getService()
				   .getUrlFormSchemas(applicationId, authToke, userId, formIds);
	}

	/**
	* Returns URL to get list of forms
	*
	* @param applicationId
	* @param authToke
	* @param userId
	* @param formIds
	* @return
	*/
	public static java.lang.String getUrlFormsList(
		java.lang.String applicationId, java.lang.String authToke, long userId,
		java.lang.String hostName) {
		return getService()
				   .getUrlFormsList(applicationId, authToke, userId, hostName);
	}

	public static java.lang.String getUrlFormStorageList(
		java.lang.String applicationId, java.lang.String authToke,
		java.lang.String storageIds) {
		return getService()
				   .getUrlFormStorageList(applicationId, authToke, storageIds);
	}

	public static java.lang.String getUrlLoadFormWithStorageId(long userId,
		long formId, long storageId, boolean canEdit,
		java.util.Map<java.lang.String, java.lang.String> extraParams) {
		return getService()
				   .getUrlLoadFormWithStorageId(userId, formId, storageId,
			canEdit, extraParams);
	}

	public static java.lang.String getUrlLoadFormWithOutStorageId(long formId,
		java.util.Map<java.lang.String, java.lang.String> extraParams) {
		return getService().getUrlLoadFormWithOutStorageId(formId, extraParams);
	}

	/**
	* Url to lock/unlock form.
	*/
	public static java.lang.String getUrlLockForm() {
		return getService().getUrlLockForm();
	}

	/**
	* Url to add form data.
	*/
	public static java.lang.String getUrlAddFormData() {
		return getService().getUrlAddFormData();
	}

	/**
	* Url to add multipart form data.
	*/
	public static java.lang.String getUrlAddFormDataMultipart() {
		return getService().getUrlAddFormDataMultipart();
	}

	public static java.lang.String getUrlAddFormDataMultipartBulkUpload() {
		return getService().getUrlAddFormDataMultipartBulkUpload();
	}

	public static java.lang.String getUrlAttachmentPrefix() {
		return getService().getUrlAttachmentPrefix();
	}

	public static java.lang.String getUrlAttachmentSInfo(
		java.lang.String applicationId, java.lang.String authToke, long userId,
		long storageId) {
		return getService()
				   .getUrlAttachmentSInfo(applicationId, authToke, userId,
			storageId);
	}

	public static java.lang.String constructAttachmentUrl(
		java.lang.String prefix, java.lang.String suffix) {
		return getService().constructAttachmentUrl(prefix, suffix);
	}

	public static java.lang.String getAttachmentSInfo(long userId,
		long storageId) {
		return getService().getAttachmentSInfo(userId, storageId);
	}

	/**
	* Method used to submit data to form builder.
	*
	*  Usually data submission happens from web-browser where undlying javascript will create required json format and submits the request to formbuilder directly.
	*  Below method is useful when we want to submit request from server side.
	*
	*  Submitting the forms does not have any uploads.(input type =file)
	*
	* @param formId
	* @param json
	* @param userId
	* @return
	*/
	public static java.lang.String submitFormData(long formId,
		java.lang.String json, long userId) {
		return getService().submitFormData(formId, json, userId);
	}

	/**
	* Method used to lock form.
	*
	* @param formId
	* @param lock
	* @param userId
	* @return
	*/
	public static java.lang.String submitFormData(long formId,
		java.lang.Boolean lock, long userId) {
		return getService().submitFormData(formId, lock, userId);
	}

	/**
	* Method used to submit data to form builder.
	*
	*  Usually data submission happens from web-browser where undlying javascript will create required json format and submits the request to formbuilder directly.
	*  Below method is useful when we want to submit request from server side.
	*
	*  Submitting the multipart form data
	*
	* @param formId
	* @param json
	* @param userId
	* @param filesList  - list of files to be uploaded. Key is field Id
	* @return
	*/
	public static java.lang.String submitFormDataMultipart(long formId,
		java.lang.String json, long userId,
		java.util.Map<java.lang.String, java.io.File> filesList)
		throws java.io.FileNotFoundException {
		return getService()
				   .submitFormDataMultipart(formId, json, userId, filesList);
	}

	/**
	* Method used to submit data to form builder.File upload field can be either single or multiple file
	*
	*  Usually data submission happens from web-browser where undlying javascript will create required json format and submits the request to formbuilder directly.
	*  Below method is useful when we want to submit request from server side.
	*
	*  Submitting the multipart form data
	*
	* @param formId
	* @param json
	* @param userId
	* @param filesList  - list of files to be uploaded. Key is field Id
	* @return
	*/
	public static java.lang.String submitFormDataMultipartMultipleFiles(
		long formId, java.lang.String json, long userId,
		java.util.Map<java.lang.String, java.util.List<java.io.File>> filesList)
		throws java.io.FileNotFoundException {
		return getService()
				   .submitFormDataMultipartMultipleFiles(formId, json, userId,
			filesList);
	}

	/**
	* Method used to submit data to form builder.
	*
	*  Usually data submission happens from web-browser where undlying javascript will create required json format and submits the request to formbuilder directly.
	*  Below method is useful when we want to submit request from server side.
	*
	*  Submitting the multipart form data
	*
	* @param formId
	* @param json
	* @param userId
	* @param filesList  - list of files to be uploaded. Key is field Id
	* @return
	*/
	public static java.lang.String submitFormDataMultipartBulkRegistration(
		long processId, long entityClassId, long formId, long userId,
		java.io.File file) throws java.io.FileNotFoundException {
		return getService()
				   .submitFormDataMultipartBulkRegistration(processId,
			entityClassId, formId, userId, file);
	}

	/**
	* Method used to return form schema for given form id
	*
	* @param userId
	* @param formId
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONArray getFormSchema(
		long userId, long formId) {
		return getService().getFormSchema(userId, formId);
	}

	/**
	* Method used to return form schema for multple form ids
	*
	* @param userId
	* @param formIdsCommaSeparated comma separated ids
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONArray getFormSchemas(
		long userId, java.lang.String formIdsCommaSeparated) {
		return getService().getFormSchemas(userId, formIdsCommaSeparated);
	}

	/**
	* Method used to fetch form storages for given storage ids
	*/
	public static com.liferay.portal.kernel.json.JSONArray getFormStorages(
		java.lang.String storageIdsCommaSeparated) {
		return getService().getFormStorages(storageIdsCommaSeparated);
	}

	/**
	* To get list of forms available in form builder
	*
	* @param userId
	* @param formIds
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONArray getFormsList(
		long userId) {
		return getService().getFormsList(userId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getFormsListV2() {
		return getService().getFormsListV2();
	}

	public static com.liferay.portal.kernel.json.JSONArray getV2FormsArrayData(
		java.lang.String requestMappingUrl,
		java.util.Map<java.lang.String, java.lang.String> params) {
		return getService().getV2FormsArrayData(requestMappingUrl, params);
	}

	public static com.liferay.portal.kernel.json.JSONObject getV2FormsData(
		java.lang.String requestMappingUrl,
		java.util.Map<java.lang.String, java.lang.String> params) {
		return getService().getV2FormsData(requestMappingUrl, params);
	}

	public static com.liferay.portal.kernel.json.JSONObject createFormCopy(
		java.lang.String formId) {
		return getService().createFormCopy(formId);
	}

	public static void clearService() {
		_service = null;
	}

	public static FormBuilderLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FormBuilderLocalService.class.getName());

			if (invokableLocalService instanceof FormBuilderLocalService) {
				_service = (FormBuilderLocalService)invokableLocalService;
			}
			else {
				_service = new FormBuilderLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FormBuilderLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FormBuilderLocalService service) {
	}

	private static FormBuilderLocalService _service;
}