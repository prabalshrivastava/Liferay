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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPUserTypeService}.
 *
 * @author gauravvijayvergia
 * @see SPUserTypeService
 * @generated
 */
public class SPUserTypeServiceWrapper implements SPUserTypeService,
	ServiceWrapper<SPUserTypeService> {
	public SPUserTypeServiceWrapper(SPUserTypeService spUserTypeService) {
		_spUserTypeService = spUserTypeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spUserTypeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spUserTypeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spUserTypeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String saveUserDeclaration(long spUserTypeId, long userId,
		long formId, java.lang.String declarationJsonString) {
		return _spUserTypeService.saveUserDeclaration(spUserTypeId, userId,
			formId, declarationJsonString);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPUserTypeService getWrappedSPUserTypeService() {
		return _spUserTypeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPUserTypeService(SPUserTypeService spUserTypeService) {
		_spUserTypeService = spUserTypeService;
	}

	@Override
	public SPUserTypeService getWrappedService() {
		return _spUserTypeService;
	}

	@Override
	public void setWrappedService(SPUserTypeService spUserTypeService) {
		_spUserTypeService = spUserTypeService;
	}

	private SPUserTypeService _spUserTypeService;
}