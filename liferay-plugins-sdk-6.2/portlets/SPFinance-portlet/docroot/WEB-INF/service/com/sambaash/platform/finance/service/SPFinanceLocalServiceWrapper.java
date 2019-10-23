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

package com.sambaash.platform.finance.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPFinanceLocalService}.
 *
 * @author abhishek.upadhyay
 * @see SPFinanceLocalService
 * @generated
 */
public class SPFinanceLocalServiceWrapper implements SPFinanceLocalService,
	ServiceWrapper<SPFinanceLocalService> {
	public SPFinanceLocalServiceWrapper(
		SPFinanceLocalService spFinanceLocalService) {
		_spFinanceLocalService = spFinanceLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spFinanceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spFinanceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spFinanceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String createRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.createRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String multiCreateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.multiCreateRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchElasticRecordsForGenericSearch(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String jsonElasticSearchQuery, java.lang.String subUrl) {
		return _spFinanceLocalService.fetchElasticRecordsForGenericSearch(resourceRequest,
			jsonElasticSearchQuery, subUrl);
	}

	@Override
	public java.lang.String fetchRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.fetchRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchInvoiceReceipt(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.fetchInvoiceReceipt(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchOrganizationIds(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.fetchOrganizationIds(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getReportPdfData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getReportPdfData(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getCreditDetailByUserId(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getCreditDetailByUserId(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchTodayRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.fetchTodayRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String checkLOR(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.checkLOR(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String invoiceFilter(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.invoiceFilter(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchMiscFeeSchemeList(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.fetchMiscFeeSchemeList(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchReportType(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.fetchReportType(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getRefundMiscFees(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getRefundMiscFees(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String updateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.updateRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spFinanceLocalService.getMicroserviceModelColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spFinanceLocalService.getMicroserviceModelFilterColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spFinanceLocalService.getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String getMicroserviceModelColumnTitleMapNew(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spFinanceLocalService.getMicroserviceModelColumnTitleMapNew(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spFinanceLocalService.convertToAPIModel(resourceRequest,
			modelData, existingData);
	}

	@Override
	public java.lang.String convertToFormModel(java.lang.String existingData,
		java.lang.String modelName)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spFinanceLocalService.convertToFormModel(existingData, modelName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		return _spFinanceLocalService.FormIOToModelJSON(resourceRequest, inp,
			jsonModelExistingData);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject convertToReportData(
		java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spFinanceLocalService.convertToReportData(existingData);
	}

	@Override
	public java.lang.String getFormV2Fields(
		javax.portlet.ResourceRequest resourceRequest) {
		return _spFinanceLocalService.getFormV2Fields(resourceRequest);
	}

	@Override
	public java.lang.String getListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getElasticSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getElasticSearchListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String searchAdmissionRecords(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String[] transactionCodes) {
		return _spFinanceLocalService.searchAdmissionRecords(resourceRequest,
			transactionCodes);
	}

	@Override
	public java.lang.String getSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getSearchListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.archiveRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		_spFinanceLocalService.handleFileUpload(request, response);
	}

	@Override
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getFilterColumnHeader(resourceRequest,
			resourceResponse);
	}

	@Override
	public void exportListToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spFinanceLocalService.exportListToExcelFile(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String exportPaymentAdvicePdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.exportPaymentAdvicePdf(resourceRequest,
			resourceResponse);
	}

	@Override
	public void exportPaymentAdviceExcel(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spFinanceLocalService.exportPaymentAdviceExcel(resourceRequest,
			resourceResponse);
	}

	@Override
	public void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spFinanceLocalService.exportRowToExcelFile(resourceRequest,
			resourceResponse);
	}

	@Override
	public void saveExportQuery(java.lang.String querytype,
		java.lang.String pageModelData,
		javax.portlet.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.json.JSONException {
		_spFinanceLocalService.saveExportQuery(querytype, pageModelData,
			resourceRequest);
	}

	@Override
	public void saveCurrentQuery(java.lang.String query,
		javax.portlet.ResourceRequest resourceRequest) {
		_spFinanceLocalService.saveCurrentQuery(query, resourceRequest);
	}

	@Override
	public java.util.Map<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _spFinanceLocalService.getUserLayoutsOne(themeDisplay);
	}

	@Override
	public java.lang.String fetchElasticRecordsForGenericSearch(long userId,
		long scopeId, java.lang.String jsonElasticSearchQuery,
		java.lang.String subUrl) {
		return _spFinanceLocalService.fetchElasticRecordsForGenericSearch(userId,
			scopeId, jsonElasticSearchQuery, subUrl);
	}

	@Override
	public java.util.Map fetchDocumentS3(
		javax.portlet.ResourceRequest resourceRequest, java.lang.String fileName) {
		return _spFinanceLocalService.fetchDocumentS3(resourceRequest, fileName);
	}

	@Override
	public java.lang.String getElasticSearchListForModel(
		java.lang.String model, long siteId) {
		return _spFinanceLocalService.getElasticSearchListForModel(model, siteId);
	}

	@Override
	public java.lang.String generateReferenceNumber(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType) {
		return _spFinanceLocalService.generateReferenceNumber(scopeGroupId,
			productType, productSubType, functionalComponent, categoryType,
			clientType);
	}

	@Override
	public java.lang.String saveTransactionData(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType, java.lang.String txnDate,
		java.lang.String source, java.lang.String componentRefNumber,
		java.lang.String txnType, java.lang.String title,
		java.lang.String description, java.lang.String dueDate,
		java.lang.String valueDate, java.lang.String creditDate,
		java.lang.String transactionDetailJson,
		java.lang.String paymentDetailJson) {
		return _spFinanceLocalService.saveTransactionData(scopeGroupId,
			productType, productSubType, functionalComponent, categoryType,
			clientType, txnDate, source, componentRefNumber, txnType, title,
			description, dueDate, valueDate, creditDate, transactionDetailJson,
			paymentDetailJson);
	}

	@Override
	public java.lang.String saveCreditBalance(long scopeGroupId,
		java.lang.Long creditBalanceAmt, java.lang.String status,
		java.lang.String usereId, java.lang.String userName,
		java.lang.String userType) {
		return _spFinanceLocalService.saveCreditBalance(scopeGroupId,
			creditBalanceAmt, status, usereId, userName, userType);
	}

	@Override
	public boolean checkRole(javax.servlet.http.HttpServletRequest request,
		java.lang.String role) {
		return _spFinanceLocalService.checkRole(request, role);
	}

	@Override
	public void downloadPdfFromServer(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spFinanceLocalService.downloadPdfFromServer(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String preparePdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.preparePdf(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String preparePdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse, java.lang.String data) {
		return _spFinanceLocalService.preparePdf(resourceRequest,
			resourceResponse, data);
	}

	@Override
	public java.lang.String prepareLorPdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.prepareLorPdf(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String processRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.processRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String processWorkFlow(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.processWorkFlow(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String generateReport(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.generateReport(resourceRequest,
			resourceResponse);
	}

	@Override
	public void generateReportZip(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spFinanceLocalService.generateReportZip(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getCategoryMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		long scopeId) {
		return _spFinanceLocalService.getCategoryMap(scopeId);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getClaimMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getClaimMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getTransactionTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getTransactionTypeMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getClientTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getClientTypeMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getFunctionalComponentMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getFunctionalComponentMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getFunctionalComponentDisplayMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getFunctionalComponentDisplayMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getProductTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getProductTypeMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getProductSubTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getProductSubTypeMap(request);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getSpListTypeMap(
		java.lang.String key, javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getSpListTypeMap(key, request);
	}

	@Override
	public java.util.Map<java.lang.Long, java.lang.String> getSpListTypeIdToDisplayName(
		java.lang.String key, javax.servlet.http.HttpServletRequest request) {
		return _spFinanceLocalService.getSpListTypeIdToDisplayName(key, request);
	}

	@Override
	public java.lang.String stripeCharge(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.stripeCharge(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getWalletAmount(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getWalletAmount(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getWalletListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getWalletListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String autoCloseCounter() {
		return _spFinanceLocalService.autoCloseCounter();
	}

	@Override
	public java.lang.String generateLorReport(java.lang.String groupIds) {
		return _spFinanceLocalService.generateLorReport(groupIds);
	}

	@Override
	public java.lang.String getGroupIds() {
		return _spFinanceLocalService.getGroupIds();
	}

	@Override
	public long getScopeGroupId(java.lang.Long siteId) {
		return _spFinanceLocalService.getScopeGroupId(siteId);
	}

	@Override
	public java.lang.String getUploadedFileUrl(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.getUploadedFileUrl(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String prepareDccPdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spFinanceLocalService.prepareDccPdf(resourceRequest,
			resourceResponse);
	}

	@Override
	public boolean[] checkUserRoles(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _spFinanceLocalService.checkUserRoles(themeDisplay);
	}

	@Override
	public void handlePendingAmendmentsClaimNotification(boolean submitter,
		boolean verifier, boolean approver,
		com.liferay.portal.model.User invigilatorUser,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		com.liferay.portal.theme.ThemeDisplay themeDisplay, java.lang.String ws) {
		_spFinanceLocalService.handlePendingAmendmentsClaimNotification(submitter,
			verifier, approver, invigilatorUser, notifyData, themeDisplay, ws);
	}

	@Override
	public void handleRejectedClaimNotification(boolean submitter,
		boolean verifier, boolean approver,
		com.liferay.portal.model.User invigilatorUser,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		_spFinanceLocalService.handleRejectedClaimNotification(submitter,
			verifier, approver, invigilatorUser, notifyData, themeDisplay);
	}

	@Override
	public void handlePendingApprovalClaimNotification(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		boolean verifier) {
		_spFinanceLocalService.handlePendingApprovalClaimNotification(themeDisplay,
			notifyData, verifier);
	}

	@Override
	public void handleApprovedClaimNotification(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		boolean approver, com.liferay.portal.model.User invigilatorUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_spFinanceLocalService.handleApprovedClaimNotification(themeDisplay,
			notifyData, approver, invigilatorUser);
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> getUsersByRoles(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String roleParam) {
		return _spFinanceLocalService.getUsersByRoles(themeDisplay, roleParam);
	}

	@Override
	public void sendSubmittedClaimNotifications(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String inputData, java.lang.String response) {
		_spFinanceLocalService.sendSubmittedClaimNotifications(resourceRequest,
			inputData, response);
	}

	@Override
	public void sendEmailNotification(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String toAddress, java.lang.String templateName,
		java.util.Map<java.lang.String, java.lang.String> params) {
		_spFinanceLocalService.sendEmailNotification(themeDisplay, toAddress,
			templateName, params);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPFinanceLocalService getWrappedSPFinanceLocalService() {
		return _spFinanceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPFinanceLocalService(
		SPFinanceLocalService spFinanceLocalService) {
		_spFinanceLocalService = spFinanceLocalService;
	}

	@Override
	public SPFinanceLocalService getWrappedService() {
		return _spFinanceLocalService;
	}

	@Override
	public void setWrappedService(SPFinanceLocalService spFinanceLocalService) {
		_spFinanceLocalService = spFinanceLocalService;
	}

	private SPFinanceLocalService _spFinanceLocalService;
}