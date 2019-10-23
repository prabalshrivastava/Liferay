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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for FormBuilder. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author nareshchebolu
 * @see FormBuilderLocalServiceUtil
 * @see com.sambaash.platform.srv.processbuilder.service.base.FormBuilderLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.impl.FormBuilderLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface FormBuilderLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormBuilderLocalServiceUtil} to access the form builder local service. Add custom service methods to {@link com.sambaash.platform.srv.processbuilder.service.impl.FormBuilderLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* Returns the URL to fetch form schema for single form.
	*  URL will have place holders for params required by form builder
	*
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlTemplateFormSchema();

	/**
	* Returns URL to fetch form schema for multiple forms
	* URL will have place holders for params required by form builder
	*
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlTemplateFormSchemas();

	/**
	* Returns URL to fetch list of form
	*  URL will have place holders for params required by form builder
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlTemplateFormsList();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlTemplateFormStorageList();

	/**
	* This url template used for loading form which is submitted earlier.
	* Each submitted form gets storage id.
	*
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlTemplateLoadFormWithStorageId();

	/**
	* This url template used for loading fresh form
	*
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlTemplateLoadFormWithOutStorageId();

	/**
	* Method used to get url for  attachment info
	*
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlTemplateAttachmentSInfo();

	/**
	* Method to get url for loading the form
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlFormLoad(long formId, long processId,
		long entityId, long entityClassId);

	/**
	* Returns URL to fetch form schema for single form
	*
	* @param applicationId
	* @param authToke
	* @param userId
	* @param formIds
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlFormSchema(java.lang.String applicationId,
		java.lang.String authToke, long userId, long formId);

	/**
	* Returns URL to fetch form schema for multiple forms
	*
	* @param applicationId
	* @param authToke
	* @param userId
	* @param formIds
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlFormSchemas(java.lang.String applicationId,
		java.lang.String authToke, long userId, java.lang.String formIds);

	/**
	* Returns URL to get list of forms
	*
	* @param applicationId
	* @param authToke
	* @param userId
	* @param formIds
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlFormsList(java.lang.String applicationId,
		java.lang.String authToke, long userId, java.lang.String hostName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlFormStorageList(
		java.lang.String applicationId, java.lang.String authToke,
		java.lang.String storageIds);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlLoadFormWithStorageId(long userId,
		long formId, long storageId, boolean canEdit,
		java.util.Map<java.lang.String, java.lang.String> extraParams);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlLoadFormWithOutStorageId(long formId,
		java.util.Map<java.lang.String, java.lang.String> extraParams);

	/**
	* Url to lock/unlock form.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlLockForm();

	/**
	* Url to add form data.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlAddFormData();

	/**
	* Url to add multipart form data.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlAddFormDataMultipart();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlAddFormDataMultipartBulkUpload();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlAttachmentPrefix();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUrlAttachmentSInfo(
		java.lang.String applicationId, java.lang.String authToke, long userId,
		long storageId);

	public java.lang.String constructAttachmentUrl(java.lang.String prefix,
		java.lang.String suffix);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getAttachmentSInfo(long userId, long storageId);

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
	public java.lang.String submitFormData(long formId, java.lang.String json,
		long userId);

	/**
	* Method used to lock form.
	*
	* @param formId
	* @param lock
	* @param userId
	* @return
	*/
	public java.lang.String submitFormData(long formId, java.lang.Boolean lock,
		long userId);

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
	public java.lang.String submitFormDataMultipart(long formId,
		java.lang.String json, long userId,
		java.util.Map<java.lang.String, java.io.File> filesList)
		throws java.io.FileNotFoundException;

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
	public java.lang.String submitFormDataMultipartMultipleFiles(long formId,
		java.lang.String json, long userId,
		java.util.Map<java.lang.String, java.util.List<java.io.File>> filesList)
		throws java.io.FileNotFoundException;

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
	public java.lang.String submitFormDataMultipartBulkRegistration(
		long processId, long entityClassId, long formId, long userId,
		java.io.File file) throws java.io.FileNotFoundException;

	/**
	* Method used to return form schema for given form id
	*
	* @param userId
	* @param formId
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getFormSchema(long userId,
		long formId);

	/**
	* Method used to return form schema for multple form ids
	*
	* @param userId
	* @param formIdsCommaSeparated comma separated ids
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getFormSchemas(
		long userId, java.lang.String formIdsCommaSeparated);

	/**
	* Method used to fetch form storages for given storage ids
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getFormStorages(
		java.lang.String storageIdsCommaSeparated);

	/**
	* To get list of forms available in form builder
	*
	* @param userId
	* @param formIds
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getFormsList(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getFormsListV2();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getV2FormsArrayData(
		java.lang.String requestMappingUrl,
		java.util.Map<java.lang.String, java.lang.String> params);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getV2FormsData(
		java.lang.String requestMappingUrl,
		java.util.Map<java.lang.String, java.lang.String> params);

	public com.liferay.portal.kernel.json.JSONObject createFormCopy(
		java.lang.String formId);
}