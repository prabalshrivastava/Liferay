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
 * Provides the remote service utility for SPListType. This utility wraps
 * {@link com.sambaash.platform.srv.spservices.service.impl.SPListTypeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author gauravvijayvergia
 * @see SPListTypeService
 * @see com.sambaash.platform.srv.spservices.service.base.SPListTypeServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.impl.SPListTypeServiceImpl
 * @generated
 */
public class SPListTypeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spservices.service.impl.SPListTypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> getListByKey(
		java.lang.String key, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getListByKey(key, groupId);
	}

	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> getSPListTypeByCategoryIdGroupId(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPListTypeByCategoryIdGroupId(groupId, categoryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPListTypeService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPListTypeService.class.getName());

			if (invokableService instanceof SPListTypeService) {
				_service = (SPListTypeService)invokableService;
			}
			else {
				_service = new SPListTypeServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SPListTypeServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPListTypeService service) {
	}

	private static SPListTypeService _service;
}