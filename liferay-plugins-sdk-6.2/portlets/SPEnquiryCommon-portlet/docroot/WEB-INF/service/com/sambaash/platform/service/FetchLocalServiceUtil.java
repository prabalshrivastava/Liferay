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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Fetch. This utility wraps
 * {@link com.sambaash.platform.service.impl.FetchLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author biswo
 * @see FetchLocalService
 * @see com.sambaash.platform.service.base.FetchLocalServiceBaseImpl
 * @see com.sambaash.platform.service.impl.FetchLocalServiceImpl
 * @generated
 */
public class FetchLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.service.impl.FetchLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static long getLoggedInUserId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLoggedInUserId();
	}

	public static java.lang.String fetchRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId) {
		return getService().fetchRecord(storageId, model, userId, siteId);
	}

	public static java.lang.String getAllRecord(java.lang.String modelName,
		long userId, long siteId) {
		return getService().getAllRecord(modelName, userId, siteId);
	}

	public static void clearService() {
		_service = null;
	}

	public static FetchLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FetchLocalService.class.getName());

			if (invokableLocalService instanceof FetchLocalService) {
				_service = (FetchLocalService)invokableLocalService;
			}
			else {
				_service = new FetchLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FetchLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FetchLocalService service) {
	}

	private static FetchLocalService _service;
}