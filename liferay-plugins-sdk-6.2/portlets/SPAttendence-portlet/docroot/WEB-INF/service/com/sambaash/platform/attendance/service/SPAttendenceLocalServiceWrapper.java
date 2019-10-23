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

package com.sambaash.platform.attendance.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPAttendenceLocalService}.
 *
 * @author keyur.kalariya
 * @see SPAttendenceLocalService
 * @generated
 */
public class SPAttendenceLocalServiceWrapper implements SPAttendenceLocalService,
	ServiceWrapper<SPAttendenceLocalService> {
	public SPAttendenceLocalServiceWrapper(
		SPAttendenceLocalService spAttendenceLocalService) {
		_spAttendenceLocalService = spAttendenceLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spAttendenceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spAttendenceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spAttendenceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String updateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spAttendenceLocalService.updateRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String scannedDataRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spAttendenceLocalService.scannedDataRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spAttendenceLocalService.getMicroserviceModelColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spAttendenceLocalService.convertToAPIModel(resourceRequest,
			modelData, existingData);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		return _spAttendenceLocalService.FormIOToModelJSON(resourceRequest,
			inp, jsonModelExistingData);
	}

	@Override
	public java.lang.String generateReferenceNumber(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType) {
		return _spAttendenceLocalService.generateReferenceNumber(scopeGroupId,
			productType, productSubType, functionalComponent, categoryType,
			clientType);
	}

	@Override
	public java.lang.String getElasticsearchData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spAttendenceLocalService.getElasticsearchData(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchExamDocketUserListing(long userId,
		long siteId, java.lang.String condition) {
		return _spAttendenceLocalService.fetchExamDocketUserListing(userId,
			siteId, condition);
	}

	@Override
	public void exportPdf(javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spAttendenceLocalService.exportPdf(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String createRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spAttendenceLocalService.createRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public boolean hasExamDocket(java.lang.String candidateNumber) {
		return _spAttendenceLocalService.hasExamDocket(candidateNumber);
	}

	@Override
	public java.lang.String exportExamDocket(java.lang.String candidateNumber) {
		return _spAttendenceLocalService.exportExamDocket(candidateNumber);
	}

	@Override
	public java.lang.String findByStorageId(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spAttendenceLocalService.findByStorageId(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String sendNotification(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spAttendenceLocalService.sendNotification(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getSpListTypeMap(
		java.lang.String key, javax.servlet.http.HttpServletRequest request) {
		return _spAttendenceLocalService.getSpListTypeMap(key, request);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPAttendenceLocalService getWrappedSPAttendenceLocalService() {
		return _spAttendenceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPAttendenceLocalService(
		SPAttendenceLocalService spAttendenceLocalService) {
		_spAttendenceLocalService = spAttendenceLocalService;
	}

	@Override
	public SPAttendenceLocalService getWrappedService() {
		return _spAttendenceLocalService;
	}

	@Override
	public void setWrappedService(
		SPAttendenceLocalService spAttendenceLocalService) {
		_spAttendenceLocalService = spAttendenceLocalService;
	}

	private SPAttendenceLocalService _spAttendenceLocalService;
}