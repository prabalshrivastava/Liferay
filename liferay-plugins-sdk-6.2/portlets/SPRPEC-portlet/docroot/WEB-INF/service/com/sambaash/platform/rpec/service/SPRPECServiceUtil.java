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

package com.sambaash.platform.rpec.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SPRPEC. This utility wraps
 * {@link com.sambaash.platform.rpec.service.impl.SPRPECServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author gaurav.kapadiya
 * @see SPRPECService
 * @see com.sambaash.platform.rpec.service.base.SPRPECServiceBaseImpl
 * @see com.sambaash.platform.rpec.service.impl.SPRPECServiceImpl
 * @generated
 */
public class SPRPECServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.rpec.service.impl.SPRPECServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static void updateStatusNotification(
		java.lang.String candidateEmail, java.lang.String firstName,
		java.lang.String lastName, java.lang.String rpecStatus,
		java.lang.String updateBy, java.lang.String dateOfUpdation,
		java.lang.String mentorId, java.lang.String trainingPricipalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateStatusNotification(candidateEmail, firstName, lastName,
			rpecStatus, updateBy, dateOfUpdation, mentorId, trainingPricipalId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPRPECService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPRPECService.class.getName());

			if (invokableService instanceof SPRPECService) {
				_service = (SPRPECService)invokableService;
			}
			else {
				_service = new SPRPECServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SPRPECServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPRPECService service) {
	}

	private static SPRPECService _service;
}