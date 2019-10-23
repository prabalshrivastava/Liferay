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

package com.sambaash.platform.srv.processbuilder.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.srv.processbuilder.service.FormBuilderServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.srv.processbuilder.service.FormBuilderServiceUtil} service utility. The
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
 * @author nareshchebolu
 * @see FormBuilderServiceHttp
 * @see com.sambaash.platform.srv.processbuilder.service.FormBuilderServiceUtil
 * @generated
 */
public class FormBuilderServiceSoap {
	public static java.lang.String getFormSchema(long userId, long formId)
		throws RemoteException {
		try {
			java.lang.String returnValue = FormBuilderServiceUtil.getFormSchema(userId,
					formId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getFormSchemas(long userId,
		java.lang.String formIdsCommaSeparated) throws RemoteException {
		try {
			java.lang.String returnValue = FormBuilderServiceUtil.getFormSchemas(userId,
					formIdsCommaSeparated);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getFormsList(long userId)
		throws RemoteException {
		try {
			java.lang.String returnValue = FormBuilderServiceUtil.getFormsList(userId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getV2FormsList() throws RemoteException {
		try {
			java.lang.String returnValue = FormBuilderServiceUtil.getV2FormsList();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getV2FormsSchema(long userId, long formId)
		throws RemoteException {
		try {
			java.lang.String returnValue = FormBuilderServiceUtil.getV2FormsSchema(userId,
					formId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getRoles(long companyId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = FormBuilderServiceUtil.getRoles(companyId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FormBuilderServiceSoap.class);
}