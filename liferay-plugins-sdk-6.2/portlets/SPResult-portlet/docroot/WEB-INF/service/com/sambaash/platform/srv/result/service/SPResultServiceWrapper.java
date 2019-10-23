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

package com.sambaash.platform.srv.result.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPResultService}.
 *
 * @author sunil.sharma
 * @see SPResultService
 * @generated
 */
public class SPResultServiceWrapper implements SPResultService,
	ServiceWrapper<SPResultService> {
	public SPResultServiceWrapper(SPResultService spResultService) {
		_spResultService = spResultService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spResultService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spResultService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spResultService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String exportTranscriptByCandidateNumber(
		java.lang.String programCode, java.lang.String candidateNumber) {
		return _spResultService.exportTranscriptByCandidateNumber(programCode,
			candidateNumber);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPResultService getWrappedSPResultService() {
		return _spResultService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPResultService(SPResultService spResultService) {
		_spResultService = spResultService;
	}

	@Override
	public SPResultService getWrappedService() {
		return _spResultService;
	}

	@Override
	public void setWrappedService(SPResultService spResultService) {
		_spResultService = spResultService;
	}

	private SPResultService _spResultService;
}