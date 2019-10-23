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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SocialProfile. This utility wraps
 * {@link com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author gauravvijayvergia
 * @see SocialProfileService
 * @see com.sambaash.platform.srv.spsocialprofile.service.base.SocialProfileServiceBaseImpl
 * @see com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileServiceImpl
 * @generated
 */
public class SocialProfileServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spsocialprofile.service.impl.SocialProfileServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.model.User addUser(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress) {
		return getService().addUser(apiKey, firstName, lastName, emailAdddress);
	}

	public static com.liferay.portal.model.User addUser(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail) {
		return getService()
				   .addUser(apiKey, firstName, lastName, emailAdddress,
			sendPasswordEmail);
	}

	public static com.liferay.portal.model.User addUser(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		java.lang.String password, boolean sendPasswordEmail) {
		return getService()
				   .addUser(apiKey, firstName, lastName, emailAdddress,
			password, sendPasswordEmail);
	}

	public static boolean addUser(java.lang.String apiKey,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAdddress, java.lang.String password,
		java.lang.String facebookId, java.lang.String gender,
		java.lang.String profileImageUrl) {
		return getService()
				   .addUser(apiKey, firstName, lastName, emailAdddress,
			password, facebookId, gender, profileImageUrl);
	}

	public static java.util.List<com.liferay.portal.model.User> getCompanyUsers(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanyUsers(companyId, start, end);
	}

	public static com.liferay.portal.model.User getUser(long userId) {
		return getService().getUser(userId);
	}

	public static com.liferay.portal.model.User getUser(
		java.lang.String emailAddress) {
		return getService().getUser(emailAddress);
	}

	public static void clearService() {
		_service = null;
	}

	public static SocialProfileService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SocialProfileService.class.getName());

			if (invokableService instanceof SocialProfileService) {
				_service = (SocialProfileService)invokableService;
			}
			else {
				_service = new SocialProfileServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SocialProfileServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SocialProfileService service) {
	}

	private static SocialProfileService _service;
}