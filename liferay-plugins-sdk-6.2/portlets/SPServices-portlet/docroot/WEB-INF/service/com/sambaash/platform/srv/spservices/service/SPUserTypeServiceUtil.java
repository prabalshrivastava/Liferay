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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SPUserType. This utility wraps
 * {@link com.sambaash.platform.srv.spservices.service.impl.SPUserTypeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author gauravvijayvergia
 * @see SPUserTypeService
 * @see com.sambaash.platform.srv.spservices.service.base.SPUserTypeServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.impl.SPUserTypeServiceImpl
 * @generated
 */
public class SPUserTypeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spservices.service.impl.SPUserTypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.lang.String saveUserDeclaration(long spUserTypeId,
		long userId, long formId, java.lang.String declarationJsonString) {
		return getService()
				   .saveUserDeclaration(spUserTypeId, userId, formId,
			declarationJsonString);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPUserTypeService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPUserTypeService.class.getName());

			if (invokableService instanceof SPUserTypeService) {
				_service = (SPUserTypeService)invokableService;
			}
			else {
				_service = new SPUserTypeServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SPUserTypeServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPUserTypeService service) {
	}

	private static SPUserTypeService _service;
}