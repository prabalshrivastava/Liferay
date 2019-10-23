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

package com.sambaash.platform.srv.spdynamicforms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPDynamicFormsService}.
 *
 * @author glenn
 * @see SPDynamicFormsService
 * @generated
 */
public class SPDynamicFormsServiceWrapper implements SPDynamicFormsService,
	ServiceWrapper<SPDynamicFormsService> {
	public SPDynamicFormsServiceWrapper(
		SPDynamicFormsService spDynamicFormsService) {
		_spDynamicFormsService = spDynamicFormsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spDynamicFormsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spDynamicFormsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spDynamicFormsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject persistFormStorage(
		long userId, long formId, long formStorageId,
		java.lang.String jsonString) {
		return _spDynamicFormsService.persistFormStorage(userId, formId,
			formStorageId, jsonString);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getFormStorage(
		long formStorageId) {
		return _spDynamicFormsService.getFormStorage(formStorageId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPDynamicFormsService getWrappedSPDynamicFormsService() {
		return _spDynamicFormsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPDynamicFormsService(
		SPDynamicFormsService spDynamicFormsService) {
		_spDynamicFormsService = spDynamicFormsService;
	}

	@Override
	public SPDynamicFormsService getWrappedService() {
		return _spDynamicFormsService;
	}

	@Override
	public void setWrappedService(SPDynamicFormsService spDynamicFormsService) {
		_spDynamicFormsService = spDynamicFormsService;
	}

	private SPDynamicFormsService _spDynamicFormsService;
}