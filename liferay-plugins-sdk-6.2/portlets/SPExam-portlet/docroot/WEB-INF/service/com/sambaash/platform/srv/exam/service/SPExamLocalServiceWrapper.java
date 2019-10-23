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

package com.sambaash.platform.srv.exam.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPExamLocalService}.
 *
 * @author sunil.sharma
 * @see SPExamLocalService
 * @generated
 */
public class SPExamLocalServiceWrapper implements SPExamLocalService,
	ServiceWrapper<SPExamLocalService> {
	public SPExamLocalServiceWrapper(SPExamLocalService spExamLocalService) {
		_spExamLocalService = spExamLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spExamLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spExamLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spExamLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String createRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.createRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String updateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.updateRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.getListing(resourceRequest, resourceResponse);
	}

	@Override
	public void saveCurrentQuery(java.lang.String query,
		javax.portlet.ResourceRequest resourceRequest) {
		_spExamLocalService.saveCurrentQuery(query, resourceRequest);
	}

	@Override
	public java.lang.String getSearchListing(
		javax.portlet.PortletRequest portletRequest,
		javax.portlet.PortletResponse portletResponse) {
		return _spExamLocalService.getSearchListing(portletRequest,
			portletResponse);
	}

	@Override
	public java.lang.String fetchRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.fetchRecord(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String fetchEntityScheduleRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.fetchEntityScheduleRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String removeUserAssignedSeats(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.removeUserAssignedSeats(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.fetchData(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String fetchActionData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.fetchActionData(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spExamLocalService.convertToAPIModel(resourceRequest,
			modelData, existingData);
	}

	@Override
	public java.lang.String convertToFormModel(java.lang.String existingData,
		java.lang.String modelName)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spExamLocalService.convertToFormModel(existingData, modelName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		return _spExamLocalService.FormIOToModelJSON(resourceRequest, inp,
			jsonModelExistingData);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spExamLocalService.getMicroserviceModelColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.archiveRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getElasticSearchListing(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.getElasticSearchListing(resourceRequest,
			resourceResponse);
	}

	@Override
	public void saveExportQuery(java.lang.String querytype,
		java.lang.String pageModelData,
		javax.portlet.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.json.JSONException {
		_spExamLocalService.saveExportQuery(querytype, pageModelData,
			resourceRequest);
	}

	@Override
	public void exportListToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spExamLocalService.exportListToExcelFile(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spExamLocalService.getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	@Override
	public void exportPdf(javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spExamLocalService.exportPdf(resourceRequest, resourceResponse);
	}

	@Override
	public void exportRowToExcelFile(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spExamLocalService.exportRowToExcelFile(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getFormV2Fields(
		javax.portlet.ResourceRequest resourceRequest) {
		return _spExamLocalService.getFormV2Fields(resourceRequest);
	}

	@Override
	public java.util.Map fetchDocumentS3(
		javax.portlet.ResourceRequest resourceRequest, java.lang.String fileName) {
		return _spExamLocalService.fetchDocumentS3(resourceRequest, fileName);
	}

	@Override
	public void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		_spExamLocalService.handleFileUpload(request, response);
	}

	@Override
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.getFilterColumnHeader(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String processRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spExamLocalService.processRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spExamLocalService.getMicroserviceModelFilterColumnList(resourceRequest,
			modelName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPExamLocalService getWrappedSPExamLocalService() {
		return _spExamLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPExamLocalService(
		SPExamLocalService spExamLocalService) {
		_spExamLocalService = spExamLocalService;
	}

	@Override
	public SPExamLocalService getWrappedService() {
		return _spExamLocalService;
	}

	@Override
	public void setWrappedService(SPExamLocalService spExamLocalService) {
		_spExamLocalService = spExamLocalService;
	}

	private SPExamLocalService _spExamLocalService;
}