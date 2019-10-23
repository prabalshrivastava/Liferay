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
 * Provides a wrapper for {@link FetchLocalService}.
 *
 * @author biswo
 * @see FetchLocalService
 * @generated
 */
public class FetchLocalServiceWrapper implements FetchLocalService,
	ServiceWrapper<FetchLocalService> {
	public FetchLocalServiceWrapper(FetchLocalService fetchLocalService) {
		_fetchLocalService = fetchLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _fetchLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fetchLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fetchLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public long getLoggedInUserId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fetchLocalService.getLoggedInUserId();
	}

	@Override
	public java.lang.String fetchRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId) {
		return _fetchLocalService.fetchRecord(storageId, model, userId, siteId);
	}

	@Override
	public java.lang.String getAllRecord(java.lang.String modelName,
		long userId, long siteId) {
		return _fetchLocalService.getAllRecord(modelName, userId, siteId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FetchLocalService getWrappedFetchLocalService() {
		return _fetchLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFetchLocalService(FetchLocalService fetchLocalService) {
		_fetchLocalService = fetchLocalService;
	}

	@Override
	public FetchLocalService getWrappedService() {
		return _fetchLocalService;
	}

	@Override
	public void setWrappedService(FetchLocalService fetchLocalService) {
		_fetchLocalService = fetchLocalService;
	}

	private FetchLocalService _fetchLocalService;
}