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

package com.sambaash.platform.srv.programmepath.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPProgrammePathLocalService}.
 *
 * @author glenn
 * @see SPProgrammePathLocalService
 * @generated
 */
public class SPProgrammePathLocalServiceWrapper
	implements SPProgrammePathLocalService,
		ServiceWrapper<SPProgrammePathLocalService> {
	public SPProgrammePathLocalServiceWrapper(
		SPProgrammePathLocalService spProgrammePathLocalService) {
		_spProgrammePathLocalService = spProgrammePathLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spProgrammePathLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spProgrammePathLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spProgrammePathLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPProgrammePathLocalService getWrappedSPProgrammePathLocalService() {
		return _spProgrammePathLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPProgrammePathLocalService(
		SPProgrammePathLocalService spProgrammePathLocalService) {
		_spProgrammePathLocalService = spProgrammePathLocalService;
	}

	@Override
	public SPProgrammePathLocalService getWrappedService() {
		return _spProgrammePathLocalService;
	}

	@Override
	public void setWrappedService(
		SPProgrammePathLocalService spProgrammePathLocalService) {
		_spProgrammePathLocalService = spProgrammePathLocalService;
	}

	private SPProgrammePathLocalService _spProgrammePathLocalService;
}