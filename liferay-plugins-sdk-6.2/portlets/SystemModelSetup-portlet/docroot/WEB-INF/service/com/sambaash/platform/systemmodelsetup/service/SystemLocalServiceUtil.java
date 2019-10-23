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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for System. This utility wraps
 * {@link com.sambaash.platform.systemmodelsetup.service.impl.SystemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author biswo
 * @see SystemLocalService
 * @see com.sambaash.platform.systemmodelsetup.service.base.SystemLocalServiceBaseImpl
 * @see com.sambaash.platform.systemmodelsetup.service.impl.SystemLocalServiceImpl
 * @generated
 */
public class SystemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.systemmodelsetup.service.impl.SystemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.lang.String createRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().createRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String sendRequest(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().sendRequest(resourceRequest, resourceResponse);
	}

	public static java.lang.String multiCreateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().multiCreateRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchElasticRecordsForGenericSearch(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String jsonElasticSearchQuery, java.lang.String subUrl) {
		return getService()
				   .fetchElasticRecordsForGenericSearch(resourceRequest,
			jsonElasticSearchQuery, subUrl);
	}

	public static java.lang.String fetchRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().fetchRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId) {
		return getService().fetchRecord(storageId, model, userId, siteId);
	}

	public static java.lang.String fetchRecordByModelId(
		java.lang.String modelId, java.lang.String model, long userId,
		long siteId) {
		return getService().fetchRecordByModelId(modelId, model, userId, siteId);
	}

	public static java.lang.String updateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().updateRecord(resourceRequest, resourceResponse);
	}

	public static java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelColumnList(resourceRequest, modelName);
	}

	public static java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelFilterColumnList(resourceRequest,
			modelName);
	}

	public static java.lang.String getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	public static java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return getService()
				   .convertToAPIModel(resourceRequest, modelData, existingData);
	}

	public static java.lang.String convertToFormModel(
		java.lang.String existingData, java.lang.String modelName)
		throws com.liferay.portal.kernel.json.JSONException {
		return getService().convertToFormModel(existingData, modelName);
	}

	public static com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		return getService()
				   .FormIOToModelJSON(resourceRequest, inp,
			jsonModelExistingData);
	}

	public static java.lang.String getFormV2Fields(
		javax.portlet.ResourceRequest resourceRequest) {
		return getService().getFormV2Fields(resourceRequest);
	}

	public static java.lang.String getListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getListing(resourceRequest, resourceResponse);
	}

	public static java.lang.String getElasticSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .getElasticSearchListing(resourceRequest, resourceResponse);
	}

	public static java.lang.String getSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getSearchListing(resourceRequest, resourceResponse);
	}

	public static java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().archiveRecord(resourceRequest, resourceResponse);
	}

	public static void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		getService().handleFileUpload(request, response);
	}

	public static void handleBatchUpload(
		javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		getService().handleBatchUpload(request, response);
	}

	public static java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .getFilterColumnHeader(resourceRequest, resourceResponse);
	}

	public static void exportListToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		getService().exportListToExcelFile(resourceRequest, resourceResponse);
	}

	public static void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		getService().exportRowToExcelFile(resourceRequest, resourceResponse);
	}

	public static void saveExportQuery(java.lang.String querytype,
		java.lang.String pageModelData,
		javax.portlet.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.json.JSONException {
		getService().saveExportQuery(querytype, pageModelData, resourceRequest);
	}

	public static void saveCurrentQuery(java.lang.String query,
		javax.portlet.ResourceRequest resourceRequest) {
		getService().saveCurrentQuery(query, resourceRequest);
	}

	public static java.util.HashMap<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne1(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return getService().getUserLayoutsOne1(themeDisplay);
	}

	public static java.util.HashMap<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return getService().getUserLayoutsOne(themeDisplay);
	}

	public static java.lang.String fetchElasticRecordsForGenericSearch(
		long userId, long scopeId, java.lang.String jsonElasticSearchQuery,
		java.lang.String subUrl) {
		return getService()
				   .fetchElasticRecordsForGenericSearch(userId, scopeId,
			jsonElasticSearchQuery, subUrl);
	}

	public static java.util.Map fetchDocumentS3(
		javax.portlet.ResourceRequest resourceRequest, java.lang.String fileName) {
		return getService().fetchDocumentS3(resourceRequest, fileName);
	}

	public static java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId) {
		return getService().getElasticSearchListForModel(model, siteId);
	}

	public static java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId, java.lang.String matchJsonString,
		java.lang.String sortString) {
		return getService()
				   .getElasticSearchListForModel(model, siteId,
			matchJsonString, sortString);
	}

	public static java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId, java.lang.String matchJsonString,
		java.lang.String sortString, int pageSize) {
		return getService()
				   .getElasticSearchListForModel(model, siteId,
			matchJsonString, sortString, pageSize);
	}

	public static java.lang.String fetchEntityLink(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().fetchEntityLink(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchEntityLinkObject(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .fetchEntityLinkObject(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchEntityLink(java.lang.String storageId,
		java.lang.String modeldata, long userId, long siteId) {
		return getService().fetchEntityLink(storageId, modeldata, userId, siteId);
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
	public static void addTimelineActivity(java.lang.String actionLink,
		java.lang.String actionLabel, java.lang.String title,
		java.lang.String description, java.lang.String imagePath,
		java.lang.String status, long createdByUserId,
		java.lang.String activityType, java.lang.String category,
		java.lang.String subProductId, java.lang.String content,
		java.lang.String assignedTo, long groupId) {
		getService()
			.addTimelineActivity(actionLink, actionLabel, title, description,
			imagePath, status, createdByUserId, activityType, category,
			subProductId, content, assignedTo, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SystemLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SystemLocalService.class.getName());

			if (invokableLocalService instanceof SystemLocalService) {
				_service = (SystemLocalService)invokableLocalService;
			}
			else {
				_service = new SystemLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SystemLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SystemLocalService service) {
	}

	private static SystemLocalService _service;
}