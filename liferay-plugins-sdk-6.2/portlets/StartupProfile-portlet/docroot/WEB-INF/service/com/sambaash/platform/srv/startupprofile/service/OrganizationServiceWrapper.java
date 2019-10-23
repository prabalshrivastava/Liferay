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

package com.sambaash.platform.srv.startupprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrganizationService}.
 *
 * @author pradeep
 * @see OrganizationService
 * @generated
 */
public class OrganizationServiceWrapper implements OrganizationService,
	ServiceWrapper<OrganizationService> {
	public OrganizationServiceWrapper(OrganizationService organizationService) {
		_organizationService = organizationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _organizationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_organizationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _organizationService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> getUsersByRole(
		java.lang.String roleName) {
		return _organizationService.getUsersByRole(roleName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrganizationService getWrappedOrganizationService() {
		return _organizationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrganizationService(
		OrganizationService organizationService) {
		_organizationService = organizationService;
	}

	@Override
	public OrganizationService getWrappedService() {
		return _organizationService;
	}

	@Override
	public void setWrappedService(OrganizationService organizationService) {
		_organizationService = organizationService;
	}

	private OrganizationService _organizationService;
}