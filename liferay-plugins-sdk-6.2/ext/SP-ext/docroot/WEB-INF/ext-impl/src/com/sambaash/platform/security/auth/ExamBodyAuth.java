/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.security.auth;

import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.admin.util.OmniadminUtil;

import com.sambaash.platform.thread.ExamBodyThreadLocal;
import com.sambaash.platform.srv.spsocialprofile.service.ExamBodyUserLocalServiceUtil;

/**
 * @author Glenn
 */
public class ExamBodyAuth implements Authenticator {
	private static Log _log = LogFactoryUtil.getLog(ExamBodyAuth.class);

	@Override
	public int authenticateByEmailAddress(long companyId, String emailAddress, String password, Map<String, String[]> headerMap,
			Map<String, String[]> parameterMap) throws AuthException {
		boolean userFound = false;
		try {
			String examBody = ExamBodyThreadLocal.getValue();
			userFound = ExamBodyUserLocalServiceUtil.isExamBodyUser(examBody, emailAddress);
			// else check if admin
			if (!userFound) {
				User u = findUser(companyId, emailAddress);
				userFound = (u != null) && OmniadminUtil.isOmniadmin(u);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
			throw new AuthException(e);
		}
		return userFound ? SUCCESS : FAILURE;
	}

	@Override
	public int authenticateByScreenName(long companyId, String screenName, String password, Map<String, String[]> headerMap,
			Map<String, String[]> parameterMap) throws AuthException {
		// not implemented
		return 0;
	}

	@Override
	public int authenticateByUserId(long companyId, long userId, String password, Map<String, String[]> headerMap,
			Map<String, String[]> parameterMap) throws AuthException {
		// not implemented
		return 0;
	}
			
	private User findUser(long companyId, String emailAddress) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
		} catch (Exception e){
			_log.error(e);
		}
		
		return user;
	}


}