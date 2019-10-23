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
 * Provides a wrapper for {@link StartupProfileLocalService}.
 *
 * @author pradeep
 * @see StartupProfileLocalService
 * @generated
 */
public class StartupProfileLocalServiceWrapper
	implements StartupProfileLocalService,
		ServiceWrapper<StartupProfileLocalService> {
	public StartupProfileLocalServiceWrapper(
		StartupProfileLocalService startupProfileLocalService) {
		_startupProfileLocalService = startupProfileLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _startupProfileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_startupProfileLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _startupProfileLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.Organization> getAllActiveOrganizations() {
		return _startupProfileLocalService.getAllActiveOrganizations();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization addOrganization(
		com.sambaash.platform.srv.startupprofile.model.Organization organization) {
		return _startupProfileLocalService.addOrganization(organization);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation addOrganizationReAccreditation(
		com.sambaash.platform.srv.startupprofile.model.ReAccreditation reAccreditation) {
		return _startupProfileLocalService.addOrganizationReAccreditation(reAccreditation);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StartupProfileLocalService getWrappedStartupProfileLocalService() {
		return _startupProfileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStartupProfileLocalService(
		StartupProfileLocalService startupProfileLocalService) {
		_startupProfileLocalService = startupProfileLocalService;
	}

	@Override
	public StartupProfileLocalService getWrappedService() {
		return _startupProfileLocalService;
	}

	@Override
	public void setWrappedService(
		StartupProfileLocalService startupProfileLocalService) {
		_startupProfileLocalService = startupProfileLocalService;
	}

	private StartupProfileLocalService _startupProfileLocalService;
}