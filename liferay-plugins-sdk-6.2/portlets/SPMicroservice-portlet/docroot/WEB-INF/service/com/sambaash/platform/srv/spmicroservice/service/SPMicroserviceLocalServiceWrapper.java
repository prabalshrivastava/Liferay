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
 * Provides a wrapper for {@link SPMicroserviceLocalService}.
 *
 * @author glenn
 * @see SPMicroserviceLocalService
 * @generated
 */
public class SPMicroserviceLocalServiceWrapper
	implements SPMicroserviceLocalService,
		ServiceWrapper<SPMicroserviceLocalService> {
	public SPMicroserviceLocalServiceWrapper(
		SPMicroserviceLocalService spMicroserviceLocalService) {
		_spMicroserviceLocalService = spMicroserviceLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMicroserviceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMicroserviceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMicroserviceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String getServiceAccessToken(java.lang.String clientId,
		java.lang.String clientSecret) {
		return _spMicroserviceLocalService.getServiceAccessToken(clientId,
			clientSecret);
	}

	@Override
	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getVocabularyCategories(
		long vocabularyId, int start, int end) {
		return _spMicroserviceLocalService.getVocabularyCategories(vocabularyId,
			start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMicroserviceLocalService getWrappedSPMicroserviceLocalService() {
		return _spMicroserviceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMicroserviceLocalService(
		SPMicroserviceLocalService spMicroserviceLocalService) {
		_spMicroserviceLocalService = spMicroserviceLocalService;
	}

	@Override
	public SPMicroserviceLocalService getWrappedService() {
		return _spMicroserviceLocalService;
	}

	@Override
	public void setWrappedService(
		SPMicroserviceLocalService spMicroserviceLocalService) {
		_spMicroserviceLocalService = spMicroserviceLocalService;
	}

	private SPMicroserviceLocalService _spMicroserviceLocalService;
}