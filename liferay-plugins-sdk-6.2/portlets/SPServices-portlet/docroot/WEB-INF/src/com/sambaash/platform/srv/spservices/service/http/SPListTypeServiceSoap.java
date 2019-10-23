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

package com.sambaash.platform.srv.spservices.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.srv.spservices.service.SPListTypeServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.srv.spservices.service.SPListTypeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sambaash.platform.srv.spservices.model.SPListTypeSoap}.
 * If the method in the service utility returns a
 * {@link com.sambaash.platform.srv.spservices.model.SPListType}, that is translated to a
 * {@link com.sambaash.platform.srv.spservices.model.SPListTypeSoap}. Methods that SOAP cannot
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
 * @see SPListTypeServiceHttp
 * @see com.sambaash.platform.srv.spservices.model.SPListTypeSoap
 * @see com.sambaash.platform.srv.spservices.service.SPListTypeServiceUtil
 * @generated
 */
public class SPListTypeServiceSoap {
	public static com.sambaash.platform.srv.spservices.model.SPListTypeSoap[] getListByKey(
		java.lang.String key, long groupId) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> returnValue =
				SPListTypeServiceUtil.getListByKey(key, groupId);

			return com.sambaash.platform.srv.spservices.model.SPListTypeSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.sambaash.platform.srv.spservices.model.SPListTypeSoap[] getSPListTypeByCategoryIdGroupId(
		long groupId, long categoryId) throws RemoteException {
		try {
			java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> returnValue =
				SPListTypeServiceUtil.getSPListTypeByCategoryIdGroupId(groupId,
					categoryId);

			return com.sambaash.platform.srv.spservices.model.SPListTypeSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPListTypeServiceSoap.class);
}