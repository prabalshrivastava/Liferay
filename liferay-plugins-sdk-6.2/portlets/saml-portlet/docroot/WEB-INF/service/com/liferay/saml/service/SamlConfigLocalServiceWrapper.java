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

package com.liferay.saml.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SamlConfigLocalService}.
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlConfigLocalService
 * @generated
 */
public class SamlConfigLocalServiceWrapper implements SamlConfigLocalService,
	ServiceWrapper<SamlConfigLocalService> {
	public SamlConfigLocalServiceWrapper(
		SamlConfigLocalService samlConfigLocalService) {
		_samlConfigLocalService = samlConfigLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _samlConfigLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_samlConfigLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _samlConfigLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.Boolean isEnabled(long companyId, long groupId) {
		return _samlConfigLocalService.isEnabled(companyId, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SamlConfigLocalService getWrappedSamlConfigLocalService() {
		return _samlConfigLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSamlConfigLocalService(
		SamlConfigLocalService samlConfigLocalService) {
		_samlConfigLocalService = samlConfigLocalService;
	}

	@Override
	public SamlConfigLocalService getWrappedService() {
		return _samlConfigLocalService;
	}

	@Override
	public void setWrappedService(SamlConfigLocalService samlConfigLocalService) {
		_samlConfigLocalService = samlConfigLocalService;
	}

	private SamlConfigLocalService _samlConfigLocalService;
}