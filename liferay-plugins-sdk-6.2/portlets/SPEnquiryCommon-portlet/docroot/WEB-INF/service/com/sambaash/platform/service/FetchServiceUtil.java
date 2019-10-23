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

package com.sambaash.platform.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Fetch. This utility wraps
 * {@link com.sambaash.platform.service.impl.FetchServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author biswo
 * @see FetchService
 * @see com.sambaash.platform.service.base.FetchServiceBaseImpl
 * @see com.sambaash.platform.service.impl.FetchServiceImpl
 * @generated
 */
public class FetchServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.service.impl.FetchServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONArray getAllRolesOne()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllRolesOne();
	}

	public static com.liferay.portal.kernel.json.JSONArray getLayoutsOne()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLayoutsOne();
	}

	public static com.liferay.portal.kernel.json.JSONArray getParentLayouts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getParentLayouts();
	}

	public static com.liferay.portal.kernel.json.JSONArray getConfiguredParentLayouts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfiguredParentLayouts();
	}

	public static com.liferay.portal.kernel.json.JSONArray getChildLayouts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChildLayouts();
	}

	public static com.liferay.portal.kernel.json.JSONArray getNavigationParentLayouts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNavigationParentLayouts();
	}

	public static com.liferay.portal.kernel.json.JSONArray getFavourites()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFavourites();
	}

	public static void clearService() {
		_service = null;
	}

	public static FetchService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FetchService.class.getName());

			if (invokableService instanceof FetchService) {
				_service = (FetchService)invokableService;
			}
			else {
				_service = new FetchServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(FetchServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FetchService service) {
	}

	private static FetchService _service;
}