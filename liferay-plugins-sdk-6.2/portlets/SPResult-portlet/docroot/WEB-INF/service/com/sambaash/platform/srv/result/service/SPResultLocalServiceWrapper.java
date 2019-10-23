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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPResultLocalService}.
 *
 * @author sunil.sharma
 * @see SPResultLocalService
 * @generated
 */
public class SPResultLocalServiceWrapper implements SPResultLocalService,
	ServiceWrapper<SPResultLocalService> {
	public SPResultLocalServiceWrapper(
		SPResultLocalService spResultLocalService) {
		_spResultLocalService = spResultLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spResultLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spResultLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spResultLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String createRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.createRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String multiCreateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.multiCreateRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchElasticRecordsForGenericSearch(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String jsonElasticSearchQuery, java.lang.String subUrl) {
		return _spResultLocalService.fetchElasticRecordsForGenericSearch(resourceRequest,
			jsonElasticSearchQuery, subUrl);
	}

	@Override
	public java.lang.String fetchRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.fetchRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String updateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.updateRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spResultLocalService.getMicroserviceModelColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spResultLocalService.getMicroserviceModelFilterColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spResultLocalService.getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spResultLocalService.convertToAPIModel(resourceRequest,
			modelData, existingData);
	}

	@Override
	public java.lang.String convertToFormModel(java.lang.String existingData,
		java.lang.String modelName)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spResultLocalService.convertToFormModel(existingData, modelName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		return _spResultLocalService.FormIOToModelJSON(resourceRequest, inp,
			jsonModelExistingData);
	}

	@Override
	public java.lang.String getFormV2Fields(
		javax.portlet.ResourceRequest resourceRequest) {
		return _spResultLocalService.getFormV2Fields(resourceRequest);
	}

	@Override
	public java.lang.String getListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.getListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getElasticSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.getElasticSearchListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.getSearchListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.archiveRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		_spResultLocalService.handleFileUpload(request, response);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject filterDistinct(
		com.liferay.portal.kernel.json.JSONObject distinct) {
		return _spResultLocalService.filterDistinct(distinct);
	}

	@Override
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.getFilterColumnHeader(resourceRequest,
			resourceResponse);
	}

	@Override
	public void exportListToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spResultLocalService.exportListToExcelFile(resourceRequest,
			resourceResponse);
	}

	@Override
	public void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spResultLocalService.exportRowToExcelFile(resourceRequest,
			resourceResponse);
	}

	@Override
	public void saveExportQuery(java.lang.String querytype,
		java.lang.String pageModelData,
		javax.portlet.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.json.JSONException {
		_spResultLocalService.saveExportQuery(querytype, pageModelData,
			resourceRequest);
	}

	@Override
	public void saveCurrentQuery(java.lang.String query,
		javax.portlet.ResourceRequest resourceRequest) {
		_spResultLocalService.saveCurrentQuery(query, resourceRequest);
	}

	@Override
	public java.util.Map<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _spResultLocalService.getUserLayoutsOne(themeDisplay);
	}

	@Override
	public java.lang.String fetchElasticRecordsForGenericSearch(long userId,
		long scopeId, java.lang.String jsonElasticSearchQuery,
		java.lang.String subUrl) {
		return _spResultLocalService.fetchElasticRecordsForGenericSearch(userId,
			scopeId, jsonElasticSearchQuery, subUrl);
	}

	@Override
	public java.util.Map fetchDocumentS3(
		javax.portlet.ResourceRequest resourceRequest, java.lang.String fileName) {
		return _spResultLocalService.fetchDocumentS3(resourceRequest, fileName);
	}

	@Override
	public java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId) {
		return _spResultLocalService.getElasticSearchListForModel(model, siteId);
	}

	@Override
	public java.lang.String generateReferenceNumber(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType) {
		return _spResultLocalService.generateReferenceNumber(scopeGroupId,
			productType, productSubType, functionalComponent, categoryType,
			clientType);
	}

	@Override
	public java.lang.String saveTransactionData(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType, java.lang.String txnDate,
		java.lang.String source, java.lang.String txnType,
		java.lang.String title, java.lang.String description,
		java.lang.String dueDate, java.lang.String valueDate,
		java.lang.String creditDate, java.lang.String transactionDetailJson) {
		return _spResultLocalService.saveTransactionData(scopeGroupId,
			productType, productSubType, functionalComponent, categoryType,
			clientType, txnDate, source, txnType, title, description, dueDate,
			valueDate, creditDate, transactionDetailJson);
	}

	@Override
	public boolean isSubmitter(javax.servlet.http.HttpServletRequest request) {
		return _spResultLocalService.isSubmitter(request);
	}

	@Override
	public boolean isApprover(javax.servlet.http.HttpServletRequest request) {
		return _spResultLocalService.isApprover(request);
	}

	@Override
	public void exportPdf(javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spResultLocalService.exportPdf(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String exportTranscript(java.lang.String programCode,
		java.lang.String candidateNumber) {
		return _spResultLocalService.exportTranscript(programCode,
			candidateNumber);
	}

	@Override
	public java.lang.String processRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spResultLocalService.processRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spResultLocalService.getCategoryMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getTransactionTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spResultLocalService.getTransactionTypeMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getClientTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spResultLocalService.getClientTypeMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getFunctionalComponentMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spResultLocalService.getFunctionalComponentMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getProductTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spResultLocalService.getProductTypeMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getProductSubTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spResultLocalService.getProductSubTypeMap(request);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPResultLocalService getWrappedSPResultLocalService() {
		return _spResultLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPResultLocalService(
		SPResultLocalService spResultLocalService) {
		_spResultLocalService = spResultLocalService;
	}

	@Override
	public SPResultLocalService getWrappedService() {
		return _spResultLocalService;
	}

	@Override
	public void setWrappedService(SPResultLocalService spResultLocalService) {
		_spResultLocalService = spResultLocalService;
	}

	private SPResultLocalService _spResultLocalService;
}