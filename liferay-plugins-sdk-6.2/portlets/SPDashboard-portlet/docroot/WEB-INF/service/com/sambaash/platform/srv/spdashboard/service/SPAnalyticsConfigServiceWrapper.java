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

package com.sambaash.platform.srv.spdashboard.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPAnalyticsConfigService}.
 *
 * @author pradeep
 * @see SPAnalyticsConfigService
 * @generated
 */
public class SPAnalyticsConfigServiceWrapper implements SPAnalyticsConfigService,
	ServiceWrapper<SPAnalyticsConfigService> {
	public SPAnalyticsConfigServiceWrapper(
		SPAnalyticsConfigService spAnalyticsConfigService) {
		_spAnalyticsConfigService = spAnalyticsConfigService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spAnalyticsConfigService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spAnalyticsConfigService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spAnalyticsConfigService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPAnalyticsConfigService getWrappedSPAnalyticsConfigService() {
		return _spAnalyticsConfigService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPAnalyticsConfigService(
		SPAnalyticsConfigService spAnalyticsConfigService) {
		_spAnalyticsConfigService = spAnalyticsConfigService;
	}

	@Override
	public SPAnalyticsConfigService getWrappedService() {
		return _spAnalyticsConfigService;
	}

	@Override
	public void setWrappedService(
		SPAnalyticsConfigService spAnalyticsConfigService) {
		_spAnalyticsConfigService = spAnalyticsConfigService;
	}

	private SPAnalyticsConfigService _spAnalyticsConfigService;
}