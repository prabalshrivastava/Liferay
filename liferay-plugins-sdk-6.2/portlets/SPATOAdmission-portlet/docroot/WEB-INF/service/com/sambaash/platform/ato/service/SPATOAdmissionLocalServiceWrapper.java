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

package com.sambaash.platform.ato.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPATOAdmissionLocalService}.
 *
 * @author keyur.kalariya
 * @see SPATOAdmissionLocalService
 * @generated
 */
public class SPATOAdmissionLocalServiceWrapper
	implements SPATOAdmissionLocalService,
		ServiceWrapper<SPATOAdmissionLocalService> {
	public SPATOAdmissionLocalServiceWrapper(
		SPATOAdmissionLocalService spatoAdmissionLocalService) {
		_spatoAdmissionLocalService = spatoAdmissionLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spatoAdmissionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spatoAdmissionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spatoAdmissionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getListOfComponent(
		java.lang.Long groupId, java.lang.String key) {
		return _spatoAdmissionLocalService.getListOfComponent(groupId, key);
	}

	@Override
	public java.lang.String handleBatchUploadFile(
		javax.portlet.ActionRequest request,
		javax.portlet.ActionResponse response, java.lang.String creditTerms) {
		return _spatoAdmissionLocalService.handleBatchUploadFile(request,
			response, creditTerms);
	}

	@Override
	public java.lang.String getSPListParamVal(java.lang.String key,
		java.lang.String displayName) {
		return _spatoAdmissionLocalService.getSPListParamVal(key, displayName);
	}

	@Override
	public java.lang.String getSPListParamId(java.lang.String key,
		java.lang.String displayName) {
		return _spatoAdmissionLocalService.getSPListParamId(key, displayName);
	}

	@Override
	public java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spatoAdmissionLocalService.convertToAPIModel(resourceRequest,
			modelData, existingData);
	}

	@Override
	public java.lang.String convertToFormModel(java.lang.String existingData,
		java.lang.String modelName)
		throws com.liferay.portal.kernel.json.JSONException {
		return _spatoAdmissionLocalService.convertToFormModel(existingData,
			modelName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		return _spatoAdmissionLocalService.FormIOToModelJSON(resourceRequest,
			inp, jsonModelExistingData);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _spatoAdmissionLocalService.getMicroserviceModelColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spatoAdmissionLocalService.archiveRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String scannedDataRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spatoAdmissionLocalService.scannedDataRecord(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String changeProcessStatus(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spatoAdmissionLocalService.changeProcessStatus(resourceRequest,
			resourceResponse);
	}

	@Override
	public void exportPdf(javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		_spatoAdmissionLocalService.exportPdf(resourceRequest, resourceResponse);
	}

	@Override
	public java.lang.String sendInvoice(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _spatoAdmissionLocalService.sendInvoice(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String sendInvoiceToCantidate(long userId, long siteId,
		java.lang.String storageIds) {
		return _spatoAdmissionLocalService.sendInvoiceToCantidate(userId,
			siteId, storageIds);
	}

	@Override
	public boolean isATO(javax.servlet.http.HttpServletRequest request) {
		return _spatoAdmissionLocalService.isATO(request);
	}

	@Override
	public java.lang.String getUserType(java.lang.String secondaryContact,
		java.lang.String trainingRole, java.lang.Long userIdForRole) {
		return _spatoAdmissionLocalService.getUserType(secondaryContact,
			trainingRole, userIdForRole);
	}

	@Override
	public java.lang.String getAtoName(java.lang.String userType,
		java.lang.Long userIdForRole) {
		return _spatoAdmissionLocalService.getAtoName(userType, userIdForRole);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPATOAdmissionLocalService getWrappedSPATOAdmissionLocalService() {
		return _spatoAdmissionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPATOAdmissionLocalService(
		SPATOAdmissionLocalService spatoAdmissionLocalService) {
		_spatoAdmissionLocalService = spatoAdmissionLocalService;
	}

	@Override
	public SPATOAdmissionLocalService getWrappedService() {
		return _spatoAdmissionLocalService;
	}

	@Override
	public void setWrappedService(
		SPATOAdmissionLocalService spatoAdmissionLocalService) {
		_spatoAdmissionLocalService = spatoAdmissionLocalService;
	}

	private SPATOAdmissionLocalService _spatoAdmissionLocalService;
}