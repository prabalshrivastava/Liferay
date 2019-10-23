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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FormBuilderLocalService}.
 *
 * @author nareshchebolu
 * @see FormBuilderLocalService
 * @generated
 */
public class FormBuilderLocalServiceWrapper implements FormBuilderLocalService,
	ServiceWrapper<FormBuilderLocalService> {
	public FormBuilderLocalServiceWrapper(
		FormBuilderLocalService formBuilderLocalService) {
		_formBuilderLocalService = formBuilderLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _formBuilderLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_formBuilderLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _formBuilderLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the URL to fetch form schema for single form.
	*  URL will have place holders for params required by form builder
	*
	* @return
	*/
	@Override
	public java.lang.String getUrlTemplateFormSchema() {
		return _formBuilderLocalService.getUrlTemplateFormSchema();
	}

	/**
	* Returns URL to fetch form schema for multiple forms
	* URL will have place holders for params required by form builder
	*
	* @return
	*/
	@Override
	public java.lang.String getUrlTemplateFormSchemas() {
		return _formBuilderLocalService.getUrlTemplateFormSchemas();
	}

	/**
	* Returns URL to fetch list of form
	*  URL will have place holders for params required by form builder
	*/
	@Override
	public java.lang.String getUrlTemplateFormsList() {
		return _formBuilderLocalService.getUrlTemplateFormsList();
	}

	@Override
	public java.lang.String getUrlTemplateFormStorageList() {
		return _formBuilderLocalService.getUrlTemplateFormStorageList();
	}

	/**
	* This url template used for loading form which is submitted earlier.
	* Each submitted form gets storage id.
	*
	* @return
	*/
	@Override
	public java.lang.String getUrlTemplateLoadFormWithStorageId() {
		return _formBuilderLocalService.getUrlTemplateLoadFormWithStorageId();
	}

	/**
	* This url template used for loading fresh form
	*
	* @return
	*/
	@Override
	public java.lang.String getUrlTemplateLoadFormWithOutStorageId() {
		return _formBuilderLocalService.getUrlTemplateLoadFormWithOutStorageId();
	}

	/**
	* Method used to get url for  attachment info
	*
	* @return
	*/
	@Override
	public java.lang.String getUrlTemplateAttachmentSInfo() {
		return _formBuilderLocalService.getUrlTemplateAttachmentSInfo();
	}

	/**
	* Method to get url for loading the form
	*/
	@Override
	public java.lang.String getUrlFormLoad(long formId, long processId,
		long entityId, long entityClassId) {
		return _formBuilderLocalService.getUrlFormLoad(formId, processId,
			entityId, entityClassId);
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
	@Override
	public java.lang.String getUrlFormSchema(java.lang.String applicationId,
		java.lang.String authToke, long userId, long formId) {
		return _formBuilderLocalService.getUrlFormSchema(applicationId,
			authToke, userId, formId);
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
	@Override
	public java.lang.String getUrlFormSchemas(java.lang.String applicationId,
		java.lang.String authToke, long userId, java.lang.String formIds) {
		return _formBuilderLocalService.getUrlFormSchemas(applicationId,
			authToke, userId, formIds);
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
	@Override
	public java.lang.String getUrlFormsList(java.lang.String applicationId,
		java.lang.String authToke, long userId, java.lang.String hostName) {
		return _formBuilderLocalService.getUrlFormsList(applicationId,
			authToke, userId, hostName);
	}

	@Override
	public java.lang.String getUrlFormStorageList(
		java.lang.String applicationId, java.lang.String authToke,
		java.lang.String storageIds) {
		return _formBuilderLocalService.getUrlFormStorageList(applicationId,
			authToke, storageIds);
	}

	@Override
	public java.lang.String getUrlLoadFormWithStorageId(long userId,
		long formId, long storageId, boolean canEdit,
		java.util.Map<java.lang.String, java.lang.String> extraParams) {
		return _formBuilderLocalService.getUrlLoadFormWithStorageId(userId,
			formId, storageId, canEdit, extraParams);
	}

	@Override
	public java.lang.String getUrlLoadFormWithOutStorageId(long formId,
		java.util.Map<java.lang.String, java.lang.String> extraParams) {
		return _formBuilderLocalService.getUrlLoadFormWithOutStorageId(formId,
			extraParams);
	}

	/**
	* Url to lock/unlock form.
	*/
	@Override
	public java.lang.String getUrlLockForm() {
		return _formBuilderLocalService.getUrlLockForm();
	}

	/**
	* Url to add form data.
	*/
	@Override
	public java.lang.String getUrlAddFormData() {
		return _formBuilderLocalService.getUrlAddFormData();
	}

	/**
	* Url to add multipart form data.
	*/
	@Override
	public java.lang.String getUrlAddFormDataMultipart() {
		return _formBuilderLocalService.getUrlAddFormDataMultipart();
	}

	@Override
	public java.lang.String getUrlAddFormDataMultipartBulkUpload() {
		return _formBuilderLocalService.getUrlAddFormDataMultipartBulkUpload();
	}

	@Override
	public java.lang.String getUrlAttachmentPrefix() {
		return _formBuilderLocalService.getUrlAttachmentPrefix();
	}

	@Override
	public java.lang.String getUrlAttachmentSInfo(
		java.lang.String applicationId, java.lang.String authToke, long userId,
		long storageId) {
		return _formBuilderLocalService.getUrlAttachmentSInfo(applicationId,
			authToke, userId, storageId);
	}

	@Override
	public java.lang.String constructAttachmentUrl(java.lang.String prefix,
		java.lang.String suffix) {
		return _formBuilderLocalService.constructAttachmentUrl(prefix, suffix);
	}

	@Override
	public java.lang.String getAttachmentSInfo(long userId, long storageId) {
		return _formBuilderLocalService.getAttachmentSInfo(userId, storageId);
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
	@Override
	public java.lang.String submitFormData(long formId, java.lang.String json,
		long userId) {
		return _formBuilderLocalService.submitFormData(formId, json, userId);
	}

	/**
	* Method used to lock form.
	*
	* @param formId
	* @param lock
	* @param userId
	* @return
	*/
	@Override
	public java.lang.String submitFormData(long formId, java.lang.Boolean lock,
		long userId) {
		return _formBuilderLocalService.submitFormData(formId, lock, userId);
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
	@Override
	public java.lang.String submitFormDataMultipart(long formId,
		java.lang.String json, long userId,
		java.util.Map<java.lang.String, java.io.File> filesList)
		throws java.io.FileNotFoundException {
		return _formBuilderLocalService.submitFormDataMultipart(formId, json,
			userId, filesList);
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
	@Override
	public java.lang.String submitFormDataMultipartMultipleFiles(long formId,
		java.lang.String json, long userId,
		java.util.Map<java.lang.String, java.util.List<java.io.File>> filesList)
		throws java.io.FileNotFoundException {
		return _formBuilderLocalService.submitFormDataMultipartMultipleFiles(formId,
			json, userId, filesList);
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
	@Override
	public java.lang.String submitFormDataMultipartBulkRegistration(
		long processId, long entityClassId, long formId, long userId,
		java.io.File file) throws java.io.FileNotFoundException {
		return _formBuilderLocalService.submitFormDataMultipartBulkRegistration(processId,
			entityClassId, formId, userId, file);
	}

	/**
	* Method used to return form schema for given form id
	*
	* @param userId
	* @param formId
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray getFormSchema(long userId,
		long formId) {
		return _formBuilderLocalService.getFormSchema(userId, formId);
	}

	/**
	* Method used to return form schema for multple form ids
	*
	* @param userId
	* @param formIdsCommaSeparated comma separated ids
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray getFormSchemas(
		long userId, java.lang.String formIdsCommaSeparated) {
		return _formBuilderLocalService.getFormSchemas(userId,
			formIdsCommaSeparated);
	}

	/**
	* Method used to fetch form storages for given storage ids
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray getFormStorages(
		java.lang.String storageIdsCommaSeparated) {
		return _formBuilderLocalService.getFormStorages(storageIdsCommaSeparated);
	}

	/**
	* To get list of forms available in form builder
	*
	* @param userId
	* @param formIds
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray getFormsList(long userId) {
		return _formBuilderLocalService.getFormsList(userId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getFormsListV2() {
		return _formBuilderLocalService.getFormsListV2();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getV2FormsArrayData(
		java.lang.String requestMappingUrl,
		java.util.Map<java.lang.String, java.lang.String> params) {
		return _formBuilderLocalService.getV2FormsArrayData(requestMappingUrl,
			params);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getV2FormsData(
		java.lang.String requestMappingUrl,
		java.util.Map<java.lang.String, java.lang.String> params) {
		return _formBuilderLocalService.getV2FormsData(requestMappingUrl, params);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject createFormCopy(
		java.lang.String formId) {
		return _formBuilderLocalService.createFormCopy(formId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FormBuilderLocalService getWrappedFormBuilderLocalService() {
		return _formBuilderLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFormBuilderLocalService(
		FormBuilderLocalService formBuilderLocalService) {
		_formBuilderLocalService = formBuilderLocalService;
	}

	@Override
	public FormBuilderLocalService getWrappedService() {
		return _formBuilderLocalService;
	}

	@Override
	public void setWrappedService(
		FormBuilderLocalService formBuilderLocalService) {
		_formBuilderLocalService = formBuilderLocalService;
	}

	private FormBuilderLocalService _formBuilderLocalService;
}