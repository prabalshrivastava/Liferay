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

package com.sambaash.platform.srv.spsocialprofile.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sambaash.platform.srv.spsocialprofile.model.SocialProfileSoap}.
 * If the method in the service utility returns a
 * {@link com.sambaash.platform.srv.spsocialprofile.model.SocialProfile}, that is translated to a
 * {@link com.sambaash.platform.srv.spsocialprofile.model.SocialProfileSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileServiceHttp
 * @see com.sambaash.platform.srv.spsocialprofile.model.SocialProfileSoap
 * @see com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil
 * @generated
 */
public class SocialProfileServiceSoap {
	public static com.liferay.portal.model.User addUser(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress)
		throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SocialProfileServiceUtil.addUser(apiKey,
					firstName, lastName, emailAdddress);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User addUser(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail) throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SocialProfileServiceUtil.addUser(apiKey,
					firstName, lastName, emailAdddress, sendPasswordEmail);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User addUser(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		java.lang.String password, boolean sendPasswordEmail)
		throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SocialProfileServiceUtil.addUser(apiKey,
					firstName, lastName, emailAdddress, password,
					sendPasswordEmail);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean addUser(java.lang.String apiKey,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAdddress, java.lang.String password,
		java.lang.String facebookId, java.lang.String gender,
		java.lang.String profileImageUrl) throws RemoteException {
		try {
			boolean returnValue = SocialProfileServiceUtil.addUser(apiKey,
					firstName, lastName, emailAdddress, password, facebookId,
					gender, profileImageUrl);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.UserSoap[] getCompanyUsers(
		long companyId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.portal.model.User> returnValue = SocialProfileServiceUtil.getCompanyUsers(companyId,
					start, end);

			return com.liferay.portal.model.UserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User getUser(long userId)
		throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SocialProfileServiceUtil.getUser(userId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User getUser(
		java.lang.String emailAddress) throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SocialProfileServiceUtil.getUser(emailAddress);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SocialProfileServiceSoap.class);
}