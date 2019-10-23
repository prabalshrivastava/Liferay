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

package com.sambaash.platform.rpec.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPRPECService}.
 *
 * @author gaurav.kapadiya
 * @see SPRPECService
 * @generated
 */
public class SPRPECServiceWrapper implements SPRPECService,
	ServiceWrapper<SPRPECService> {
	public SPRPECServiceWrapper(SPRPECService sprpecService) {
		_sprpecService = sprpecService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sprpecService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sprpecService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sprpecService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void updateStatusNotification(java.lang.String candidateEmail,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String rpecStatus, java.lang.String updateBy,
		java.lang.String dateOfUpdation, java.lang.String mentorId,
		java.lang.String trainingPricipalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_sprpecService.updateStatusNotification(candidateEmail, firstName,
			lastName, rpecStatus, updateBy, dateOfUpdation, mentorId,
			trainingPricipalId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPRPECService getWrappedSPRPECService() {
		return _sprpecService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPRPECService(SPRPECService sprpecService) {
		_sprpecService = sprpecService;
	}

	@Override
	public SPRPECService getWrappedService() {
		return _sprpecService;
	}

	@Override
	public void setWrappedService(SPRPECService sprpecService) {
		_sprpecService = sprpecService;
	}

	private SPRPECService _sprpecService;
}