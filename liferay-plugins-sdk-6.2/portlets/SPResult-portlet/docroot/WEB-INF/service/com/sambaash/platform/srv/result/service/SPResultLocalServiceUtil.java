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

package com.sambaash.platform.srv.result.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPResult. This utility wraps
 * {@link com.sambaash.platform.srv.result.service.impl.SPResultLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sunil.sharma
 * @see SPResultLocalService
 * @see com.sambaash.platform.srv.result.service.base.SPResultLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.result.service.impl.SPResultLocalServiceImpl
 * @generated
 */
public class SPResultLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.result.service.impl.SPResultLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONObject filterDistinct(
		com.liferay.portal.kernel.json.JSONObject distinct) {
		return getService().filterDistinct(distinct);
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

	public static java.util.Map<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne(
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

	public static java.lang.String generateReferenceNumber(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType) {
		return getService()
				   .generateReferenceNumber(scopeGroupId, productType,
			productSubType, functionalComponent, categoryType, clientType);
	}

	public static java.lang.String saveTransactionData(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType, java.lang.String txnDate,
		java.lang.String source, java.lang.String txnType,
		java.lang.String title, java.lang.String description,
		java.lang.String dueDate, java.lang.String valueDate,
		java.lang.String creditDate, java.lang.String transactionDetailJson) {
		return getService()
				   .saveTransactionData(scopeGroupId, productType,
			productSubType, functionalComponent, categoryType, clientType,
			txnDate, source, txnType, title, description, dueDate, valueDate,
			creditDate, transactionDetailJson);
	}

	public static boolean isSubmitter(
		javax.servlet.http.HttpServletRequest request) {
		return getService().isSubmitter(request);
	}

	public static boolean isApprover(
		javax.servlet.http.HttpServletRequest request) {
		return getService().isApprover(request);
	}

	public static void exportPdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		getService().exportPdf(resourceRequest, resourceResponse);
	}

	public static java.lang.String exportTranscript(
		java.lang.String programCode, java.lang.String candidateNumber) {
		return getService().exportTranscript(programCode, candidateNumber);
	}

	public static java.lang.String processRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().processRecord(resourceRequest, resourceResponse);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getCategoryMap(request);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getTransactionTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getTransactionTypeMap(request);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getClientTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getClientTypeMap(request);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getFunctionalComponentMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getFunctionalComponentMap(request);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getProductTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getProductTypeMap(request);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getProductSubTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getProductSubTypeMap(request);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPResultLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPResultLocalService.class.getName());

			if (invokableLocalService instanceof SPResultLocalService) {
				_service = (SPResultLocalService)invokableLocalService;
			}
			else {
				_service = new SPResultLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPResultLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPResultLocalService service) {
	}

	private static SPResultLocalService _service;
}