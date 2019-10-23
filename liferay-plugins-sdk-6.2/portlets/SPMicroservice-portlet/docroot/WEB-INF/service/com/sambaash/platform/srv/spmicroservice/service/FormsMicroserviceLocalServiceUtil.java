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

package com.sambaash.platform.srv.spmicroservice.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FormsMicroservice. This utility wraps
 * {@link com.sambaash.platform.srv.spmicroservice.service.impl.FormsMicroserviceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author glenn
 * @see FormsMicroserviceLocalService
 * @see com.sambaash.platform.srv.spmicroservice.service.base.FormsMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.impl.FormsMicroserviceLocalServiceImpl
 * @generated
 */
public class FormsMicroserviceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spmicroservice.service.impl.FormsMicroserviceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONArray getFormListing() {
		return getService().getFormListing();
	}

	public static com.liferay.portal.kernel.json.JSONObject getForm(long formId) {
		return getService().getForm(formId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getFormFields(
		long formId, boolean includeLayout, boolean fullInfo) {
		return getService().getFormFields(formId, includeLayout, fullInfo);
	}

	public static void synchroniseRole(long groupId, long roleId,
		java.lang.String roleName) {
		getService().synchroniseRole(groupId, roleId, roleName);
	}

	public static void addFormEvent(java.lang.String action,
		java.lang.String description) {
		getService().addFormEvent(action, description);
	}

	public static void clearService() {
		_service = null;
	}

	public static FormsMicroserviceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FormsMicroserviceLocalService.class.getName());

			if (invokableLocalService instanceof FormsMicroserviceLocalService) {
				_service = (FormsMicroserviceLocalService)invokableLocalService;
			}
			else {
				_service = new FormsMicroserviceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FormsMicroserviceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FormsMicroserviceLocalService service) {
	}

	private static FormsMicroserviceLocalService _service;
}