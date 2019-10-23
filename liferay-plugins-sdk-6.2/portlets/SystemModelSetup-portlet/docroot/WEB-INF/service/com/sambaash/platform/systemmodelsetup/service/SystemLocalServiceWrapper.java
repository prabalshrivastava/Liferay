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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SystemLocalService}.
 *
 * @author biswo
 * @see SystemLocalService
 * @generated
 */
public class SystemLocalServiceWrapper implements SystemLocalService,
	ServiceWrapper<SystemLocalService> {
	public SystemLocalServiceWrapper(SystemLocalService systemLocalService) {
		_systemLocalService = systemLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _systemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_systemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _systemLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String createRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.createRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String sendRequest(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.sendRequest(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String multiCreateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.multiCreateRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchElasticRecordsForGenericSearch(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String jsonElasticSearchQuery, java.lang.String subUrl) {
		return _systemLocalService.fetchElasticRecordsForGenericSearch(resourceRequest,
			jsonElasticSearchQuery, subUrl);
	}

	@Override
	public java.lang.String fetchRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.fetchRecord(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String fetchRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId) {
		return _systemLocalService.fetchRecord(storageId, model, userId, siteId);
	}

	@Override
	public java.lang.String fetchRecordByModelId(java.lang.String modelId,
		java.lang.String model, long userId, long siteId) {
		return _systemLocalService.fetchRecordByModelId(modelId, model, userId,
			siteId);
	}

	@Override
	public java.lang.String updateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.updateRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _systemLocalService.getMicroserviceModelColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _systemLocalService.getMicroserviceModelFilterColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _systemLocalService.getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return _systemLocalService.convertToAPIModel(resourceRequest,
			modelData, existingData);
	}

	@Override
	public java.lang.String convertToFormModel(java.lang.String existingData,
		java.lang.String modelName)
		throws com.liferay.portal.kernel.json.JSONException {
		return _systemLocalService.convertToFormModel(existingData, modelName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		return _systemLocalService.FormIOToModelJSON(resourceRequest, inp,
			jsonModelExistingData);
	}

	@Override
	public java.lang.String getFormV2Fields(
		javax.portlet.ResourceRequest resourceRequest) {
		return _systemLocalService.getFormV2Fields(resourceRequest);
	}

	@Override
	public java.lang.String getListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.getListing(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String getElasticSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.getElasticSearchListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.getSearchListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.archiveRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		_systemLocalService.handleFileUpload(request, response);
	}

	@Override
	public void handleBatchUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		_systemLocalService.handleBatchUpload(request, response);
	}

	@Override
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.getFilterColumnHeader(resourceRequest,
			resourceResponse);
	}

	@Override
	public void exportListToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_systemLocalService.exportListToExcelFile(resourceRequest,
			resourceResponse);
	}

	@Override
	public void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_systemLocalService.exportRowToExcelFile(resourceRequest,
			resourceResponse);
	}

	@Override
	public void saveExportQuery(java.lang.String querytype,
		java.lang.String pageModelData,
		javax.portlet.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.json.JSONException {
		_systemLocalService.saveExportQuery(querytype, pageModelData,
			resourceRequest);
	}

	@Override
	public void saveCurrentQuery(java.lang.String query,
		javax.portlet.ResourceRequest resourceRequest) {
		_systemLocalService.saveCurrentQuery(query, resourceRequest);
	}

	@Override
	public java.util.HashMap<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne1(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _systemLocalService.getUserLayoutsOne1(themeDisplay);
	}

	@Override
	public java.util.HashMap<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _systemLocalService.getUserLayoutsOne(themeDisplay);
	}

	@Override
	public java.lang.String fetchElasticRecordsForGenericSearch(long userId,
		long scopeId, java.lang.String jsonElasticSearchQuery,
		java.lang.String subUrl) {
		return _systemLocalService.fetchElasticRecordsForGenericSearch(userId,
			scopeId, jsonElasticSearchQuery, subUrl);
	}

	@Override
	public java.util.Map fetchDocumentS3(
		javax.portlet.ResourceRequest resourceRequest, java.lang.String fileName) {
		return _systemLocalService.fetchDocumentS3(resourceRequest, fileName);
	}

	@Override
	public java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId) {
		return _systemLocalService.getElasticSearchListForModel(model, siteId);
	}

	@Override
	public java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId, java.lang.String matchJsonString,
		java.lang.String sortString) {
		return _systemLocalService.getElasticSearchListForModel(model, siteId,
			matchJsonString, sortString);
	}

	@Override
	public java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId, java.lang.String matchJsonString,
		java.lang.String sortString, int pageSize) {
		return _systemLocalService.getElasticSearchListForModel(model, siteId,
			matchJsonString, sortString, pageSize);
	}

	@Override
	public java.lang.String fetchEntityLink(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.fetchEntityLink(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchEntityLinkObject(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _systemLocalService.fetchEntityLinkObject(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchEntityLink(java.lang.String storageId,
		java.lang.String modeldata, long userId, long siteId) {
		return _systemLocalService.fetchEntityLink(storageId, modeldata,
			userId, siteId);
	}

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
	@Override
	public void addTimelineActivity(java.lang.String actionLink,
		java.lang.String actionLabel, java.lang.String title,
		java.lang.String description, java.lang.String imagePath,
		java.lang.String status, long createdByUserId,
		java.lang.String activityType, java.lang.String category,
		java.lang.String subProductId, java.lang.String content,
		java.lang.String assignedTo, long groupId) {
		_systemLocalService.addTimelineActivity(actionLink, actionLabel, title,
			description, imagePath, status, createdByUserId, activityType,
			category, subProductId, content, assignedTo, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SystemLocalService getWrappedSystemLocalService() {
		return _systemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSystemLocalService(
		SystemLocalService systemLocalService) {
		_systemLocalService = systemLocalService;
	}

	@Override
	public SystemLocalService getWrappedService() {
		return _systemLocalService;
	}

	@Override
	public void setWrappedService(SystemLocalService systemLocalService) {
		_systemLocalService = systemLocalService;
	}

	private SystemLocalService _systemLocalService;
}