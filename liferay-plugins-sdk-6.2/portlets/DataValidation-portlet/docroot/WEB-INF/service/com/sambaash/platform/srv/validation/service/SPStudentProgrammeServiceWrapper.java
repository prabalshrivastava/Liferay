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

package com.sambaash.platform.srv.validation.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPStudentProgrammeService}.
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammeService
 * @generated
 */
public class SPStudentProgrammeServiceWrapper
	implements SPStudentProgrammeService,
		ServiceWrapper<SPStudentProgrammeService> {
	public SPStudentProgrammeServiceWrapper(
		SPStudentProgrammeService spStudentProgrammeService) {
		_spStudentProgrammeService = spStudentProgrammeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spStudentProgrammeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spStudentProgrammeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spStudentProgrammeService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String getStudentProgramme(java.lang.Long scopeGroupId,
		java.lang.String programmeCode, java.lang.String nric,
		java.lang.String emailAddress, java.util.Date programmeEndDate,
		boolean validationRequired) {
		return _spStudentProgrammeService.getStudentProgramme(scopeGroupId,
			programmeCode, nric, emailAddress, programmeEndDate,
			validationRequired);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getStudentProgramme(
		java.lang.Long scopeGroupId, java.lang.String programmeCode,
		java.lang.String nric) {
		return _spStudentProgrammeService.getStudentProgramme(scopeGroupId,
			programmeCode, nric);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPStudentProgrammeService getWrappedSPStudentProgrammeService() {
		return _spStudentProgrammeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPStudentProgrammeService(
		SPStudentProgrammeService spStudentProgrammeService) {
		_spStudentProgrammeService = spStudentProgrammeService;
	}

	@Override
	public SPStudentProgrammeService getWrappedService() {
		return _spStudentProgrammeService;
	}

	@Override
	public void setWrappedService(
		SPStudentProgrammeService spStudentProgrammeService) {
		_spStudentProgrammeService = spStudentProgrammeService;
	}

	private SPStudentProgrammeService _spStudentProgrammeService;
}