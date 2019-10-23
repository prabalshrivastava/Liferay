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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPFinance. This utility wraps
 * {@link com.sambaash.platform.finance.service.impl.SPFinanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author abhishek.upadhyay
 * @see SPFinanceLocalService
 * @see com.sambaash.platform.finance.service.base.SPFinanceLocalServiceBaseImpl
 * @see com.sambaash.platform.finance.service.impl.SPFinanceLocalServiceImpl
 * @generated
 */
public class SPFinanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.finance.service.impl.SPFinanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.lang.String fetchInvoiceReceipt(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .fetchInvoiceReceipt(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchOrganizationIds(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .fetchOrganizationIds(resourceRequest, resourceResponse);
	}

	public static java.lang.String getReportPdfData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getReportPdfData(resourceRequest, resourceResponse);
	}

	public static java.lang.String getCreditDetailByUserId(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .getCreditDetailByUserId(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchTodayRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().fetchTodayRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String checkLOR(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().checkLOR(resourceRequest, resourceResponse);
	}

	public static java.lang.String invoiceFilter(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().invoiceFilter(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchMiscFeeSchemeList(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .fetchMiscFeeSchemeList(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchReportType(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().fetchReportType(resourceRequest, resourceResponse);
	}

	public static java.lang.String getRefundMiscFees(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getRefundMiscFees(resourceRequest, resourceResponse);
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

	public static java.util.Map<java.lang.String, java.lang.String> getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	public static java.lang.String getMicroserviceModelColumnTitleMapNew(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelColumnTitleMapNew(resourceRequest,
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

	public static com.liferay.portal.kernel.json.JSONObject convertToReportData(
		java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return getService().convertToReportData(existingData);
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

	public static java.lang.String searchAdmissionRecords(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String[] transactionCodes) {
		return getService()
				   .searchAdmissionRecords(resourceRequest, transactionCodes);
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

	public static java.lang.String exportPaymentAdvicePdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .exportPaymentAdvicePdf(resourceRequest, resourceResponse);
	}

	public static void exportPaymentAdviceExcel(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		getService().exportPaymentAdviceExcel(resourceRequest, resourceResponse);
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
		java.lang.String source, java.lang.String componentRefNumber,
		java.lang.String txnType, java.lang.String title,
		java.lang.String description, java.lang.String dueDate,
		java.lang.String valueDate, java.lang.String creditDate,
		java.lang.String transactionDetailJson,
		java.lang.String paymentDetailJson) {
		return getService()
				   .saveTransactionData(scopeGroupId, productType,
			productSubType, functionalComponent, categoryType, clientType,
			txnDate, source, componentRefNumber, txnType, title, description,
			dueDate, valueDate, creditDate, transactionDetailJson,
			paymentDetailJson);
	}

	public static java.lang.String saveCreditBalance(long scopeGroupId,
		java.lang.Long creditBalanceAmt, java.lang.String status,
		java.lang.String usereId, java.lang.String userName,
		java.lang.String userType) {
		return getService()
				   .saveCreditBalance(scopeGroupId, creditBalanceAmt, status,
			usereId, userName, userType);
	}

	public static boolean checkRole(
		javax.servlet.http.HttpServletRequest request, java.lang.String role) {
		return getService().checkRole(request, role);
	}

	public static void downloadPdfFromServer(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		getService().downloadPdfFromServer(resourceRequest, resourceResponse);
	}

	public static java.lang.String preparePdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().preparePdf(resourceRequest, resourceResponse);
	}

	public static java.lang.String preparePdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse, java.lang.String data) {
		return getService().preparePdf(resourceRequest, resourceResponse, data);
	}

	public static java.lang.String prepareLorPdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().prepareLorPdf(resourceRequest, resourceResponse);
	}

	public static java.lang.String processRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().processRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String processWorkFlow(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().processWorkFlow(resourceRequest, resourceResponse);
	}

	public static java.lang.String generateReport(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().generateReport(resourceRequest, resourceResponse);
	}

	public static void generateReportZip(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		getService().generateReportZip(resourceRequest, resourceResponse);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getCategoryMap(request);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		long scopeId) {
		return getService().getCategoryMap(scopeId);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getClaimMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getClaimMap(request);
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

	public static java.util.Map<java.lang.String, java.lang.String> getFunctionalComponentDisplayMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getFunctionalComponentDisplayMap(request);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getProductTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getProductTypeMap(request);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getProductSubTypeMap(
		javax.servlet.http.HttpServletRequest request) {
		return getService().getProductSubTypeMap(request);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getSpListTypeMap(
		java.lang.String key, javax.servlet.http.HttpServletRequest request) {
		return getService().getSpListTypeMap(key, request);
	}

	public static java.util.Map<java.lang.Long, java.lang.String> getSpListTypeIdToDisplayName(
		java.lang.String key, javax.servlet.http.HttpServletRequest request) {
		return getService().getSpListTypeIdToDisplayName(key, request);
	}

	public static java.lang.String stripeCharge(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().stripeCharge(resourceRequest, resourceResponse);
	}

	public static java.lang.String getWalletAmount(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getWalletAmount(resourceRequest, resourceResponse);
	}

	public static java.lang.String getWalletListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getWalletListing(resourceRequest, resourceResponse);
	}

	public static java.lang.String autoCloseCounter() {
		return getService().autoCloseCounter();
	}

	public static java.lang.String generateLorReport(java.lang.String groupIds) {
		return getService().generateLorReport(groupIds);
	}

	public static java.lang.String getGroupIds() {
		return getService().getGroupIds();
	}

	public static long getScopeGroupId(java.lang.Long siteId) {
		return getService().getScopeGroupId(siteId);
	}

	public static java.lang.String getUploadedFileUrl(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getUploadedFileUrl(resourceRequest, resourceResponse);
	}

	public static java.lang.String prepareDccPdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().prepareDccPdf(resourceRequest, resourceResponse);
	}

	public static boolean[] checkUserRoles(
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return getService().checkUserRoles(themeDisplay);
	}

	public static void handlePendingAmendmentsClaimNotification(
		boolean submitter, boolean verifier, boolean approver,
		com.liferay.portal.model.User invigilatorUser,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		com.liferay.portal.theme.ThemeDisplay themeDisplay, java.lang.String ws) {
		getService()
			.handlePendingAmendmentsClaimNotification(submitter, verifier,
			approver, invigilatorUser, notifyData, themeDisplay, ws);
	}

	public static void handleRejectedClaimNotification(boolean submitter,
		boolean verifier, boolean approver,
		com.liferay.portal.model.User invigilatorUser,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		getService()
			.handleRejectedClaimNotification(submitter, verifier, approver,
			invigilatorUser, notifyData, themeDisplay);
	}

	public static void handlePendingApprovalClaimNotification(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		boolean verifier) {
		getService()
			.handlePendingApprovalClaimNotification(themeDisplay, notifyData,
			verifier);
	}

	public static void handleApprovedClaimNotification(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.util.List<java.util.List<java.lang.Object>> notifyData,
		boolean approver, com.liferay.portal.model.User invigilatorUser)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.handleApprovedClaimNotification(themeDisplay, notifyData,
			approver, invigilatorUser);
	}

	public static java.util.List<com.liferay.portal.model.User> getUsersByRoles(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String roleParam) {
		return getService().getUsersByRoles(themeDisplay, roleParam);
	}

	public static void sendSubmittedClaimNotifications(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String inputData, java.lang.String response) {
		getService()
			.sendSubmittedClaimNotifications(resourceRequest, inputData,
			response);
	}

	public static void sendEmailNotification(
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String toAddress, java.lang.String templateName,
		java.util.Map<java.lang.String, java.lang.String> params) {
		getService()
			.sendEmailNotification(themeDisplay, toAddress, templateName, params);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPFinanceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPFinanceLocalService.class.getName());

			if (invokableLocalService instanceof SPFinanceLocalService) {
				_service = (SPFinanceLocalService)invokableLocalService;
			}
			else {
				_service = new SPFinanceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPFinanceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPFinanceLocalService service) {
	}

	private static SPFinanceLocalService _service;
}