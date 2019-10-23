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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InvigilatorLocalService}.
 *
 * @author Himadri
 * @see InvigilatorLocalService
 * @generated
 */
public class InvigilatorLocalServiceWrapper implements InvigilatorLocalService,
	ServiceWrapper<InvigilatorLocalService> {
	public InvigilatorLocalServiceWrapper(
		InvigilatorLocalService invigilatorLocalService) {
		_invigilatorLocalService = invigilatorLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _invigilatorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_invigilatorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _invigilatorLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<java.lang.String> getMicroserviceModelFilterColumnList(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _invigilatorLocalService.getMicroserviceModelFilterColumnList(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String getUniqueList(
		javax.portlet.ResourceRequest resourceRequest) {
		return _invigilatorLocalService.getUniqueList(resourceRequest);
	}

	@Override
	public java.lang.String getScheduleList(
		javax.portlet.ResourceRequest resourceRequest) {
		return _invigilatorLocalService.getScheduleList(resourceRequest);
	}

	@Override
	public java.lang.String getPastAppointmentList(
		javax.portlet.ResourceRequest resourceRequest) {
		return _invigilatorLocalService.getPastAppointmentList(resourceRequest);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getMicroserviceModelColumnTitleMap(
		javax.portlet.ResourceRequest resourceRequest,
		java.lang.String modelName) {
		return _invigilatorLocalService.getMicroserviceModelColumnTitleMap(resourceRequest,
			modelName);
	}

	@Override
	public java.lang.String getFilterColumnHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _invigilatorLocalService.getFilterColumnHeader(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String fetchUpcommingFacilitySchedul(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _invigilatorLocalService.fetchUpcommingFacilitySchedul(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getGroupNameHeader(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _invigilatorLocalService.getGroupNameHeader(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String getUniqueData(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _invigilatorLocalService.getUniqueData(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String updateAppointmentStatus(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _invigilatorLocalService.updateAppointmentStatus(resourceRequest,
			resourceResponse);
	}

	@Override
	public java.lang.String notifyInvigilator(
		javax.portlet.ResourceRequest resourceRequest,
		javax.portlet.ResourceResponse resourceResponse) {
		return _invigilatorLocalService.notifyInvigilator(resourceRequest,
			resourceResponse);
	}

	@Override
	public void sendNewUserLoginDetailsEmail(
		com.liferay.portal.model.User user, java.lang.String templateName) {
		_invigilatorLocalService.sendNewUserLoginDetailsEmail(user, templateName);
	}

	@Override
	public java.lang.String getPriceScheme(
		javax.portlet.ResourceRequest resourceRequest,
		com.liferay.portal.kernel.json.JSONObject appointData) {
		return _invigilatorLocalService.getPriceScheme(resourceRequest,
			appointData);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InvigilatorLocalService getWrappedInvigilatorLocalService() {
		return _invigilatorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInvigilatorLocalService(
		InvigilatorLocalService invigilatorLocalService) {
		_invigilatorLocalService = invigilatorLocalService;
	}

	@Override
	public InvigilatorLocalService getWrappedService() {
		return _invigilatorLocalService;
	}

	@Override
	public void setWrappedService(
		InvigilatorLocalService invigilatorLocalService) {
		_invigilatorLocalService = invigilatorLocalService;
	}

	private InvigilatorLocalService _invigilatorLocalService;
}