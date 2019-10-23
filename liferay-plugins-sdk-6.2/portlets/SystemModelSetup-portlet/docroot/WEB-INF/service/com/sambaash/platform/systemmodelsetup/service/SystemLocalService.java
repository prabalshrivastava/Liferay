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

package com.sambaash.platform.systemmodelsetup.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for System. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author biswo
 * @see SystemLocalServiceUtil
 * @see com.sambaash.platform.systemmodelsetup.service.base.SystemLocalServiceBaseImpl
 * @see com.sambaash.platform.systemmodelsetup.service.impl.SystemLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SystemLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SystemLocalServiceUtil} to access the system local service. Add custom service methods to {@link com.sambaash.platform.systemmodelsetup.service.impl.SystemLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public java.lang.String createRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String sendRequest(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String multiCreateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchElasticRecordsForGenericSearch(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String jsonElasticSearchQuery, java.lang.String subUrl);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchRecordByModelId(java.lang.String modelId,
		java.lang.String model, long userId, long siteId);

	public java.lang.String updateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName);

	public java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException;

	public java.lang.String convertToFormModel(java.lang.String existingData,
		java.lang.String modelName)
		throws com.liferay.portal.kernel.json.JSONException;

	public com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getFormV2Fields(
		javax.portlet.ResourceRequest resourceRequest);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getElasticSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response);

	public void handleBatchUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public void exportListToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public void saveExportQuery(java.lang.String querytype,
		java.lang.String pageModelData,
		javax.portlet.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.json.JSONException;

	public void saveCurrentQuery(java.lang.String query,
		javax.portlet.ResourceRequest resourceRequest);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.HashMap<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne1(
		com.liferay.portal.theme.ThemeDisplay themeDisplay);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.HashMap<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne(
		com.liferay.portal.theme.ThemeDisplay themeDisplay);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchElasticRecordsForGenericSearch(long userId,
		long scopeId, java.lang.String jsonElasticSearchQuery,
		java.lang.String subUrl);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map fetchDocumentS3(
		javax.portlet.ResourceRequest resourceRequest, java.lang.String fileName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId, java.lang.String matchJsonString,
		java.lang.String sortString);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId, java.lang.String matchJsonString,
		java.lang.String sortString, int pageSize);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchEntityLink(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchEntityLinkObject(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String fetchEntityLink(java.lang.String storageId,
		java.lang.String modeldata, long userId, long siteId);

	/**
	* @param actionLink
	a String type. Upon action will lead to this link.
	* @param actionLabel
	a String type. Label to be displayed on Timeline.
	* @param title
	a String type. Title to be displayed on Timeline Activity.
	* @param description
	a String type. Description to be displayed on Timeline
	Activity. Not used currently.
	* @param imagePath
	a String type. Image to be displayed on Timeline Activity. Not
	used currently.
	* @param status
	a String type. Status to be displayed on Timeline Activity.
	* @param createdByUserId
	a long type. Person who is creating this Activity..
	* @param activityType
	a String type. ActivityType to be displayed on Timeline
	Activity.
	* @param category
	a String type. Category to be displayed on Timeline Activity.
	* @param subProductId
	a String type. Should be fetched from SPSiteSetup
	subProductId.
	* @param content
	a String type. Not used currently. Can be set blank.
	* @param assignedTo
	a String type. Person whom this activity should be assigned to
	and can see it on his/her Timeline.
	* @param groupId
	a long type.
	*/
	public void addTimelineActivity(java.lang.String actionLink,
		java.lang.String actionLabel, java.lang.String title,
		java.lang.String description, java.lang.String imagePath,
		java.lang.String status, long createdByUserId,
		java.lang.String activityType, java.lang.String category,
		java.lang.String subProductId, java.lang.String content,
		java.lang.String assignedTo, long groupId);
}