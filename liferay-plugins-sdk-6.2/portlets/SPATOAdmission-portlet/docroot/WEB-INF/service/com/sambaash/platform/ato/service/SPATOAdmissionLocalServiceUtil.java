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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPATOAdmission. This utility wraps
 * {@link com.sambaash.platform.ato.service.impl.SPATOAdmissionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author keyur.kalariya
 * @see SPATOAdmissionLocalService
 * @see com.sambaash.platform.ato.service.base.SPATOAdmissionLocalServiceBaseImpl
 * @see com.sambaash.platform.ato.service.impl.SPATOAdmissionLocalServiceImpl
 * @generated
 */
public class SPATOAdmissionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.ato.service.impl.SPATOAdmissionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.util.Map<java.lang.String, java.lang.String> getListOfComponent(
		java.lang.Long groupId, java.lang.String key) {
		return getService().getListOfComponent(groupId, key);
	}

	public static java.lang.String handleBatchUploadFile(
		javax.portlet.ActionRequest request,
		javax.portlet.ActionResponse response, java.lang.String creditTerms) {
		return getService().handleBatchUploadFile(request, response, creditTerms);
	}

	public static java.lang.String getSPListParamVal(java.lang.String key,
		java.lang.String displayName) {
		return getService().getSPListParamVal(key, displayName);
	}

	public static java.lang.String getSPListParamId(java.lang.String key,
		java.lang.String displayName) {
		return getService().getSPListParamId(key, displayName);
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

	public static java.util.List<java.lang.String> getMicroserviceModelColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelColumnList(resourceRequest, modelName);
	}

	public static java.lang.String archiveRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().archiveRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String scannedDataRecord(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().scannedDataRecord(resourceRequest, resourceResponse);
	}

	public static java.lang.String changeProcessStatus(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .changeProcessStatus(resourceRequest, resourceResponse);
	}

	public static void exportPdf(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		getService().exportPdf(resourceRequest, resourceResponse);
	}

	public static java.lang.String sendInvoice(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().sendInvoice(resourceRequest, resourceResponse);
	}

	public static java.lang.String sendInvoiceToCantidate(long userId,
		long siteId, java.lang.String storageIds) {
		return getService().sendInvoiceToCantidate(userId, siteId, storageIds);
	}

	public static boolean isATO(javax.servlet.http.HttpServletRequest request) {
		return getService().isATO(request);
	}

	public static java.lang.String getUserType(
		java.lang.String secondaryContact, java.lang.String trainingRole,
		java.lang.Long userIdForRole) {
		return getService()
				   .getUserType(secondaryContact, trainingRole, userIdForRole);
	}

	public static java.lang.String getAtoName(java.lang.String userType,
		java.lang.Long userIdForRole) {
		return getService().getAtoName(userType, userIdForRole);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPATOAdmissionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPATOAdmissionLocalService.class.getName());

			if (invokableLocalService instanceof SPATOAdmissionLocalService) {
				_service = (SPATOAdmissionLocalService)invokableLocalService;
			}
			else {
				_service = new SPATOAdmissionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPATOAdmissionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPATOAdmissionLocalService service) {
	}

	private static SPATOAdmissionLocalService _service;
}