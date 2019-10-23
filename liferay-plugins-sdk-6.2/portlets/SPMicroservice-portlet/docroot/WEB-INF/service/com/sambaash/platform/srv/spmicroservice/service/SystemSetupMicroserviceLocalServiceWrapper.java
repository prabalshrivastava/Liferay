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

package com.sambaash.platform.srv.spmicroservice.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SystemSetupMicroserviceLocalService}.
 *
 * @author glenn
 * @see SystemSetupMicroserviceLocalService
 * @generated
 */
public class SystemSetupMicroserviceLocalServiceWrapper
	implements SystemSetupMicroserviceLocalService,
		ServiceWrapper<SystemSetupMicroserviceLocalService> {
	public SystemSetupMicroserviceLocalServiceWrapper(
		SystemSetupMicroserviceLocalService systemSetupMicroserviceLocalService) {
		_systemSetupMicroserviceLocalService = systemSetupMicroserviceLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _systemSetupMicroserviceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_systemSetupMicroserviceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _systemSetupMicroserviceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPostalAddress(
		java.lang.String countryCode, java.lang.String postalCode) {
		return _systemSetupMicroserviceLocalService.getPostalAddress(countryCode,
			postalCode);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject updateContentJson(
		long scopeGroupId, java.lang.String modelName,
		java.lang.String storageId, java.lang.String patchJsonString) {
		return _systemSetupMicroserviceLocalService.updateContentJson(scopeGroupId,
			modelName, storageId, patchJsonString);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SystemSetupMicroserviceLocalService getWrappedSystemSetupMicroserviceLocalService() {
		return _systemSetupMicroserviceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSystemSetupMicroserviceLocalService(
		SystemSetupMicroserviceLocalService systemSetupMicroserviceLocalService) {
		_systemSetupMicroserviceLocalService = systemSetupMicroserviceLocalService;
	}

	@Override
	public SystemSetupMicroserviceLocalService getWrappedService() {
		return _systemSetupMicroserviceLocalService;
	}

	@Override
	public void setWrappedService(
		SystemSetupMicroserviceLocalService systemSetupMicroserviceLocalService) {
		_systemSetupMicroserviceLocalService = systemSetupMicroserviceLocalService;
	}

	private SystemSetupMicroserviceLocalService _systemSetupMicroserviceLocalService;
}