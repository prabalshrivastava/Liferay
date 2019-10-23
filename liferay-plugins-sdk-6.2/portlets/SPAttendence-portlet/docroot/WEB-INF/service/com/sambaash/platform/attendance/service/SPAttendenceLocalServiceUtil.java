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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPAttendence. This utility wraps
 * {@link com.sambaash.platform.attendance.service.impl.SPAttendenceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author keyur.kalariya
 * @see SPAttendenceLocalService
 * @see com.sambaash.platform.attendance.service.base.SPAttendenceLocalServiceBaseImpl
 * @see com.sambaash.platform.attendance.service.impl.SPAttendenceLocalServiceImpl
 * @generated
 */
public class SPAttendenceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.attendance.service.impl.SPAttendenceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.lang.String updateRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().updateRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String scannedDataRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().scannedDataRecord(resourceRequest, resourceResponse);
	}

	public static java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelColumnList(resourceRequest, modelName);
	}

	public static java.lang.String convertToAPIModel(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelData, java.lang.String existingData)
		throws com.liferay.portal.kernel.json.JSONException {
		return getService()
				   .convertToAPIModel(resourceRequest, modelData, existingData);
	}

	public static com.liferay.portal.kernel.json.JSONObject FormIOToModelJSON(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject inp,
		com.liferay.portal.kernel.json.JSONObject jsonModelExistingData) {
		return getService()
				   .FormIOToModelJSON(resourceRequest, inp,
			jsonModelExistingData);
	}

	public static java.lang.String generateReferenceNumber(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType) {
		return getService()
				   .generateReferenceNumber(scopeGroupId, productType,
			productSubType, functionalComponent, categoryType, clientType);
	}

	public static java.lang.String getElasticsearchData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .getElasticsearchData(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchExamDocketUserListing(long userId,
		long siteId, java.lang.String condition) {
		return getService().fetchExamDocketUserListing(userId, siteId, condition);
	}

	public static void exportPdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		getService().exportPdf(resourceRequest, resourceResponse);
	}

	public static java.lang.String createRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().createRecord(resourceRequest, resourceResponse);
	}

	public static boolean hasExamDocket(java.lang.String candidateNumber) {
		return getService().hasExamDocket(candidateNumber);
	}

	public static java.lang.String exportExamDocket(
		java.lang.String candidateNumber) {
		return getService().exportExamDocket(candidateNumber);
	}

	public static java.lang.String findByStorageId(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().findByStorageId(resourceRequest, resourceResponse);
	}

	public static java.lang.String sendNotification(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().sendNotification(resourceRequest, resourceResponse);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getSpListTypeMap(
		java.lang.String key, javax.servlet.http.HttpServletRequest request) {
		return getService().getSpListTypeMap(key, request);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPAttendenceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPAttendenceLocalService.class.getName());

			if (invokableLocalService instanceof SPAttendenceLocalService) {
				_service = (SPAttendenceLocalService)invokableLocalService;
			}
			else {
				_service = new SPAttendenceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPAttendenceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPAttendenceLocalService service) {
	}

	private static SPAttendenceLocalService _service;
}