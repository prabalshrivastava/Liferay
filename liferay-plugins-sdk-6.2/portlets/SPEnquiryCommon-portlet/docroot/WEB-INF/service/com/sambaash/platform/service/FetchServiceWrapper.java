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

package com.sambaash.platform.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FetchService}.
 *
 * @author biswo
 * @see FetchService
 * @generated
 */
public class FetchServiceWrapper implements FetchService,
	ServiceWrapper<FetchService> {
	public FetchServiceWrapper(FetchService fetchService) {
		_fetchService = fetchService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fetchService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fetchService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fetchService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAllRolesOne()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fetchService.getAllRolesOne();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getLayoutsOne()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fetchService.getLayoutsOne();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getParentLayouts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fetchService.getParentLayouts();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getConfiguredParentLayouts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fetchService.getConfiguredParentLayouts();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getChildLayouts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fetchService.getChildLayouts();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getNavigationParentLayouts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fetchService.getNavigationParentLayouts();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getFavourites()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fetchService.getFavourites();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FetchService getWrappedFetchService() {
		return _fetchService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFetchService(FetchService fetchService) {
		_fetchService = fetchService;
	}

	@Override
	public FetchService getWrappedService() {
		return _fetchService;
	}

	@Override
	public void setWrappedService(FetchService fetchService) {
		_fetchService = fetchService;
	}

	private FetchService _fetchService;
}