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

package com.sambaash.platform.srv.mail.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SPMailTemplate. This utility wraps
 * {@link com.sambaash.platform.srv.mail.service.impl.SPMailTemplateServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author gauravvijayvergia
 * @see SPMailTemplateService
 * @see com.sambaash.platform.srv.mail.service.base.SPMailTemplateServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.impl.SPMailTemplateServiceImpl
 * @generated
 */
public class SPMailTemplateServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.mail.service.impl.SPMailTemplateServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.sambaash.platform.srv.mail.model.SPMailTemplate getTemplateByName(
		java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTemplateByName(templateName);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailTemplate getTemplateByName(
		long productTypeId, long subProductTypeId, java.lang.String templateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTemplateByName(productTypeId, subProductTypeId,
			templateName);
	}

	public static void sendAdHocEmaills(java.lang.String userIdsStr,
		long templateId) {
		getService().sendAdHocEmaills(userIdsStr, templateId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPMailTemplateService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPMailTemplateService.class.getName());

			if (invokableService instanceof SPMailTemplateService) {
				_service = (SPMailTemplateService)invokableService;
			}
			else {
				_service = new SPMailTemplateServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SPMailTemplateServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPMailTemplateService service) {
	}

	private static SPMailTemplateService _service;
}