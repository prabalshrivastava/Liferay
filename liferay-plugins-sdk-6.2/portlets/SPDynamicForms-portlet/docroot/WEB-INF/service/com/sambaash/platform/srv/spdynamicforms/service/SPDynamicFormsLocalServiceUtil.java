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

package com.sambaash.platform.srv.spdynamicforms.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPDynamicForms. This utility wraps
 * {@link com.sambaash.platform.srv.spdynamicforms.service.impl.SPDynamicFormsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author glenn
 * @see SPDynamicFormsLocalService
 * @see com.sambaash.platform.srv.spdynamicforms.service.base.SPDynamicFormsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spdynamicforms.service.impl.SPDynamicFormsLocalServiceImpl
 * @generated
 */
public class SPDynamicFormsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spdynamicforms.service.impl.SPDynamicFormsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONObject retrieveLoadParam(
		javax.portlet.RenderRequest renderRequest) {
		return getService().retrieveLoadParam(renderRequest);
	}

	public static void handleLoadData(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		getService().handleLoadData(request, response);
	}

	public static void handlePersist(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		getService().handlePersist(request, response);
	}

	public static java.lang.String persistFormJsonData(
		com.liferay.portal.theme.ThemeDisplay themeDisplay, long formId,
		java.lang.Long formStorageId,
		com.liferay.portal.kernel.json.JSONObject formJsonData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .persistFormJsonData(themeDisplay, formId, formStorageId,
			formJsonData);
	}

	public static java.lang.String handlePersist(long userId, long formId,
		long formStorageId, java.lang.String jsonString) {
		return getService()
				   .handlePersist(userId, formId, formStorageId, jsonString);
	}

	public static void handleFileUpload(javax.portlet.ResourceRequest request,
		javax.portlet.ResourceResponse response) {
		getService().handleFileUpload(request, response);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPDynamicFormsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPDynamicFormsLocalService.class.getName());

			if (invokableLocalService instanceof SPDynamicFormsLocalService) {
				_service = (SPDynamicFormsLocalService)invokableLocalService;
			}
			else {
				_service = new SPDynamicFormsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPDynamicFormsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPDynamicFormsLocalService service) {
	}

	private static SPDynamicFormsLocalService _service;
}