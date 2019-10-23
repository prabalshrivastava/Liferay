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

package com.sambaash.platform.attendance.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPAttendenceService}.
 *
 * @author keyur.kalariya
 * @see SPAttendenceService
 * @generated
 */
public class SPAttendenceServiceWrapper implements SPAttendenceService,
	ServiceWrapper<SPAttendenceService> {
	public SPAttendenceServiceWrapper(SPAttendenceService spAttendenceService) {
		_spAttendenceService = spAttendenceService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spAttendenceService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spAttendenceService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spAttendenceService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String exportExamDocketByCandidateNumber(
		java.lang.String candidateNumber) {
		return _spAttendenceService.exportExamDocketByCandidateNumber(candidateNumber);
	}

	@Override
	public boolean hasExamDocket(java.lang.String candidateNumber) {
		return _spAttendenceService.hasExamDocket(candidateNumber);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPAttendenceService getWrappedSPAttendenceService() {
		return _spAttendenceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPAttendenceService(
		SPAttendenceService spAttendenceService) {
		_spAttendenceService = spAttendenceService;
	}

	@Override
	public SPAttendenceService getWrappedService() {
		return _spAttendenceService;
	}

	@Override
	public void setWrappedService(SPAttendenceService spAttendenceService) {
		_spAttendenceService = spAttendenceService;
	}

	private SPAttendenceService _spAttendenceService;
}