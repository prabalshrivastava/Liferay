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

package com.sambaash.platform.ato.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPATOAdmissionService}.
 *
 * @author keyur.kalariya
 * @see SPATOAdmissionService
 * @generated
 */
public class SPATOAdmissionServiceWrapper implements SPATOAdmissionService,
	ServiceWrapper<SPATOAdmissionService> {
	public SPATOAdmissionServiceWrapper(
		SPATOAdmissionService spatoAdmissionService) {
		_spatoAdmissionService = spatoAdmissionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spatoAdmissionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spatoAdmissionService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spatoAdmissionService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String sendInvoiceToCandidate(long companyId,
		java.lang.String storageIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spatoAdmissionService.sendInvoiceToCandidate(companyId,
			storageIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPATOAdmissionService getWrappedSPATOAdmissionService() {
		return _spatoAdmissionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPATOAdmissionService(
		SPATOAdmissionService spatoAdmissionService) {
		_spatoAdmissionService = spatoAdmissionService;
	}

	@Override
	public SPATOAdmissionService getWrappedService() {
		return _spatoAdmissionService;
	}

	@Override
	public void setWrappedService(SPATOAdmissionService spatoAdmissionService) {
		_spatoAdmissionService = spatoAdmissionService;
	}

	private SPATOAdmissionService _spatoAdmissionService;
}