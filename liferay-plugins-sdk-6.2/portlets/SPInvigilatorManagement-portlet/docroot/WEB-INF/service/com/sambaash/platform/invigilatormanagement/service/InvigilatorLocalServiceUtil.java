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

package com.sambaash.platform.invigilatormanagement.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Invigilator. This utility wraps
 * {@link com.sambaash.platform.invigilatormanagement.service.impl.InvigilatorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Himadri
 * @see InvigilatorLocalService
 * @see com.sambaash.platform.invigilatormanagement.service.base.InvigilatorLocalServiceBaseImpl
 * @see com.sambaash.platform.invigilatormanagement.service.impl.InvigilatorLocalServiceImpl
 * @generated
 */
public class InvigilatorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.invigilatormanagement.service.impl.InvigilatorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelFilterColumnList(resourceRequest,
			modelName);
	}

	public static java.lang.String getUniqueList(
		javax.portlet.ResourceRequest resourceRequest) {
		return getService().getUniqueList(resourceRequest);
	}

	public static java.lang.String getScheduleList(
		javax.portlet.ResourceRequest resourceRequest) {
		return getService().getScheduleList(resourceRequest);
	}

	public static java.lang.String getPastAppointmentList(
		javax.portlet.ResourceRequest resourceRequest) {
		return getService().getPastAppointmentList(resourceRequest);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return getService()
				   .getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	public static java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .getFilterColumnHeader(resourceRequest, resourceResponse);
	}

	public static java.lang.String fetchUpcommingFacilitySchedul(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .fetchUpcommingFacilitySchedul(resourceRequest,
			resourceResponse);
	}

	public static java.lang.String getGroupNameHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getGroupNameHeader(resourceRequest, resourceResponse);
	}

	public static java.lang.String getUniqueData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().getUniqueData(resourceRequest, resourceResponse);
	}

	public static java.lang.String updateAppointmentStatus(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService()
				   .updateAppointmentStatus(resourceRequest, resourceResponse);
	}

	public static java.lang.String notifyInvigilator(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return getService().notifyInvigilator(resourceRequest, resourceResponse);
	}

	public static void sendNewUserLoginDetailsEmail(
		com.liferay.portal.model.User user, java.lang.String templateName) {
		getService().sendNewUserLoginDetailsEmail(user, templateName);
	}

	public static java.lang.String getPriceScheme(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject appointData) {
		return getService().getPriceScheme(resourceRequest, appointData);
	}

	public static void clearService() {
		_service = null;
	}

	public static InvigilatorLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					InvigilatorLocalService.class.getName());

			if (invokableLocalService instanceof InvigilatorLocalService) {
				_service = (InvigilatorLocalService)invokableLocalService;
			}
			else {
				_service = new InvigilatorLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(InvigilatorLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(InvigilatorLocalService service) {
	}

	private static InvigilatorLocalService _service;
}