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

package com.sambaash.platform.srv.graph.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.srv.graph.service.SPNeoforjServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.srv.graph.service.SPNeoforjServiceUtil} service utility. The
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
 * @author harini
 * @see SPNeoforjServiceHttp
 * @see com.sambaash.platform.srv.graph.service.SPNeoforjServiceUtil
 * @generated
 */
public class SPNeoforjServiceSoap {
	public static java.lang.String follow(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityId)
		throws RemoteException {
		try {
			java.lang.String returnValue = SPNeoforjServiceUtil.follow(companyId,
					groupId, layoutSetId, action, startUserId,
					endEntityClassName, endEntityId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean isFollowing(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityId)
		throws RemoteException {
		try {
			boolean returnValue = SPNeoforjServiceUtil.isFollowing(companyId,
					groupId, layoutSetId, startUserId, endEntityClassName,
					endEntityId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String like(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String action, long startUserId,
		java.lang.String endEntityClassName, long endEntityId)
		throws RemoteException {
		try {
			java.lang.String returnValue = SPNeoforjServiceUtil.like(companyId,
					groupId, layoutSetId, action, startUserId,
					endEntityClassName, endEntityId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean isLiking(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityId)
		throws RemoteException {
		try {
			boolean returnValue = SPNeoforjServiceUtil.isLiking(companyId,
					groupId, layoutSetId, startUserId, endEntityClassName,
					endEntityId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int findUsersWhoLikeCount(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId,
		java.lang.String endEntityClassName, java.lang.Long endEntityId)
		throws RemoteException {
		try {
			int returnValue = SPNeoforjServiceUtil.findUsersWhoLikeCount(companyId,
					groupId, layoutSetId, endEntityClassName, endEntityId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String join(java.lang.String action,
		long startUserId, java.lang.String endEntityClassName,
		long endEntityClassPK, int type, int status, java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId)
		throws RemoteException {
		try {
			java.lang.String returnValue = SPNeoforjServiceUtil.join(action,
					startUserId, endEntityClassName, endEntityClassPK, type,
					status, companyId, groupId, layoutSetId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean isJoined(java.lang.Long companyId,
		java.lang.Long groupId, java.lang.Long layoutSetId, long startUserId,
		java.lang.String endEntityClassName, long endEntityClassPK)
		throws RemoteException {
		try {
			boolean returnValue = SPNeoforjServiceUtil.isJoined(companyId,
					groupId, layoutSetId, startUserId, endEntityClassName,
					endEntityClassPK);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String updateJoinGraph(
		com.sambaash.platform.model.spneo4j.form.JoinGraphForm joinGraphForm)
		throws RemoteException {
		try {
			java.lang.String returnValue = SPNeoforjServiceUtil.updateJoinGraph(joinGraphForm);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPNeoforjServiceSoap.class);
}