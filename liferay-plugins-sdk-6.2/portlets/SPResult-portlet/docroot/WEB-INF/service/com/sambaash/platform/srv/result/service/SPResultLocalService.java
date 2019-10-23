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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for SPResult. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author sunil.sharma
 * @see SPResultLocalServiceUtil
 * @see com.sambaash.platform.srv.result.service.base.SPResultLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.result.service.impl.SPResultLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPResultLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPResultLocalServiceUtil} to access the s p result local service. Add custom service methods to {@link com.sambaash.platform.srv.result.service.impl.SPResultLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public com.liferay.portal.kernel.json.JSONObject filterDistinct(
		com.liferay.portal.kernel.json.JSONObject distinct);

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
	public java.util.Map<java.lang.Long, java.util.List<com.liferay.portal.model.Layout>> getUserLayoutsOne(
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

	public java.lang.String generateReferenceNumber(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType);

	public java.lang.String saveTransactionData(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType, java.lang.String txnDate,
		java.lang.String source, java.lang.String txnType,
		java.lang.String title, java.lang.String description,
		java.lang.String dueDate, java.lang.String valueDate,
		java.lang.String creditDate, java.lang.String transactionDetailJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isSubmitter(javax.servlet.http.HttpServletRequest request);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isApprover(javax.servlet.http.HttpServletRequest request);

	public void exportPdf(javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	public java.lang.String exportTranscript(java.lang.String programCode,
		java.lang.String candidateNumber);

	public java.lang.String processRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getCategoryMap(
		javax.servlet.http.HttpServletRequest request);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getTransactionTypeMap(
		javax.servlet.http.HttpServletRequest request);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getClientTypeMap(
		javax.servlet.http.HttpServletRequest request);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getFunctionalComponentMap(
		javax.servlet.http.HttpServletRequest request);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getProductTypeMap(
		javax.servlet.http.HttpServletRequest request);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getProductSubTypeMap(
		javax.servlet.http.HttpServletRequest request);
}