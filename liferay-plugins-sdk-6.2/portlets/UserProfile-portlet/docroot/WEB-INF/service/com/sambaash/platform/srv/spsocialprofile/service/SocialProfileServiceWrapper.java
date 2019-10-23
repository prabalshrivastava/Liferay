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

package com.sambaash.platform.srv.spsocialprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SocialProfileService}.
 *
 * @author gauravvijayvergia
 * @see SocialProfileService
 * @generated
 */
public class SocialProfileServiceWrapper implements SocialProfileService,
	ServiceWrapper<SocialProfileService> {
	public SocialProfileServiceWrapper(
		SocialProfileService socialProfileService) {
		_socialProfileService = socialProfileService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _socialProfileService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_socialProfileService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _socialProfileService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.model.User addUser(java.lang.String apiKey,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAdddress) {
		return _socialProfileService.addUser(apiKey, firstName, lastName,
			emailAdddress);
	}

	@Override
	public com.liferay.portal.model.User addUser(java.lang.String apiKey,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAdddress, boolean sendPasswordEmail) {
		return _socialProfileService.addUser(apiKey, firstName, lastName,
			emailAdddress, sendPasswordEmail);
	}

	@Override
	public com.liferay.portal.model.User addUser(java.lang.String apiKey,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAdddress, java.lang.String password,
		boolean sendPasswordEmail) {
		return _socialProfileService.addUser(apiKey, firstName, lastName,
			emailAdddress, password, sendPasswordEmail);
	}

	@Override
	public boolean addUser(java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		java.lang.String password, java.lang.String facebookId,
		java.lang.String gender, java.lang.String profileImageUrl) {
		return _socialProfileService.addUser(apiKey, firstName, lastName,
			emailAdddress, password, facebookId, gender, profileImageUrl);
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> getCompanyUsers(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileService.getCompanyUsers(companyId, start, end);
	}

	@Override
	public com.liferay.portal.model.User getUser(long userId) {
		return _socialProfileService.getUser(userId);
	}

	@Override
	public com.liferay.portal.model.User getUser(java.lang.String emailAddress) {
		return _socialProfileService.getUser(emailAddress);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SocialProfileService getWrappedSocialProfileService() {
		return _socialProfileService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSocialProfileService(
		SocialProfileService socialProfileService) {
		_socialProfileService = socialProfileService;
	}

	@Override
	public SocialProfileService getWrappedService() {
		return _socialProfileService;
	}

	@Override
	public void setWrappedService(SocialProfileService socialProfileService) {
		_socialProfileService = socialProfileService;
	}

	private SocialProfileService _socialProfileService;
}