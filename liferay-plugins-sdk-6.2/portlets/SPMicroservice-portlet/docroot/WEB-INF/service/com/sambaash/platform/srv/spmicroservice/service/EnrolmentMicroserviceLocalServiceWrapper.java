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
 * Provides a wrapper for {@link EnrolmentMicroserviceLocalService}.
 *
 * @author glenn
 * @see EnrolmentMicroserviceLocalService
 * @generated
 */
public class EnrolmentMicroserviceLocalServiceWrapper
	implements EnrolmentMicroserviceLocalService,
		ServiceWrapper<EnrolmentMicroserviceLocalService> {
	public EnrolmentMicroserviceLocalServiceWrapper(
		EnrolmentMicroserviceLocalService enrolmentMicroserviceLocalService) {
		_enrolmentMicroserviceLocalService = enrolmentMicroserviceLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _enrolmentMicroserviceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_enrolmentMicroserviceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _enrolmentMicroserviceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public boolean validateBatchSwitchEnrolmentIds(long scopeGroupId,
		java.lang.String enrolmentIds) {
		return _enrolmentMicroserviceLocalService.validateBatchSwitchEnrolmentIds(scopeGroupId,
			enrolmentIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EnrolmentMicroserviceLocalService getWrappedEnrolmentMicroserviceLocalService() {
		return _enrolmentMicroserviceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEnrolmentMicroserviceLocalService(
		EnrolmentMicroserviceLocalService enrolmentMicroserviceLocalService) {
		_enrolmentMicroserviceLocalService = enrolmentMicroserviceLocalService;
	}

	@Override
	public EnrolmentMicroserviceLocalService getWrappedService() {
		return _enrolmentMicroserviceLocalService;
	}

	@Override
	public void setWrappedService(
		EnrolmentMicroserviceLocalService enrolmentMicroserviceLocalService) {
		_enrolmentMicroserviceLocalService = enrolmentMicroserviceLocalService;
	}

	private EnrolmentMicroserviceLocalService _enrolmentMicroserviceLocalService;
}