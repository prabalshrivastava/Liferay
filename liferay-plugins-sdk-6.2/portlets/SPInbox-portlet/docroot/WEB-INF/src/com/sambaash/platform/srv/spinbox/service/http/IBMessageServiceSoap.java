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

package com.sambaash.platform.srv.spinbox.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.srv.spinbox.service.IBMessageServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.srv.spinbox.service.IBMessageServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.sambaash.platform.srv.spinbox.model.IBMessageSoap}.
 * If the method in the service utility returns a
 * {@link com.sambaash.platform.srv.spinbox.model.IBMessage}, that is translated to a
 * {@link com.sambaash.platform.srv.spinbox.model.IBMessageSoap}. Methods that SOAP cannot
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
 * @author nareshchebolu
 * @see IBMessageServiceHttp
 * @see com.sambaash.platform.srv.spinbox.model.IBMessageSoap
 * @see com.sambaash.platform.srv.spinbox.service.IBMessageServiceUtil
 * @generated
 */
public class IBMessageServiceSoap {
	public static com.sambaash.platform.srv.spinbox.model.IBMessageSoap addMessage(
		java.lang.String uuid, long parentMessageId, long groupId,
		long companyId, java.lang.String subject, java.lang.String content,
		java.util.Date createDate, java.lang.String from, java.lang.String to,
		java.lang.String createBy, java.lang.String createByUserId,
		boolean isAllowOpen, boolean isDraft, java.lang.String draftStatus,
		boolean isSentMeCopy) throws RemoteException {
		try {
			com.sambaash.platform.srv.spinbox.model.IBMessage returnValue = IBMessageServiceUtil.addMessage(uuid,
					parentMessageId, groupId, companyId, subject, content,
					createDate, from, to, createBy, createByUserId,
					isAllowOpen, isDraft, draftStatus, isSentMeCopy);

			return com.sambaash.platform.srv.spinbox.model.IBMessageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(IBMessageServiceSoap.class);
}