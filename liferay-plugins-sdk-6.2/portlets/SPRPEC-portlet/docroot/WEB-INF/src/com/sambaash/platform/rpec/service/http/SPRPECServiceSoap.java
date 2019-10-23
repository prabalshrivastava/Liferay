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

package com.sambaash.platform.rpec.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.rpec.service.SPRPECServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.rpec.service.SPRPECServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
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
 * @author gaurav.kapadiya
 * @see SPRPECServiceHttp
 * @see com.sambaash.platform.rpec.service.SPRPECServiceUtil
 * @generated
 */
public class SPRPECServiceSoap {
	public static void updateStatusNotification(
		java.lang.String candidateEmail, java.lang.String firstName,
		java.lang.String lastName, java.lang.String rpecStatus,
		java.lang.String updateBy, java.lang.String dateOfUpdation,
		java.lang.String mentorId, java.lang.String trainingPricipalId)
		throws RemoteException {
		try {
			SPRPECServiceUtil.updateStatusNotification(candidateEmail,
				firstName, lastName, rpecStatus, updateBy, dateOfUpdation,
				mentorId, trainingPricipalId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPRPECServiceSoap.class);
}