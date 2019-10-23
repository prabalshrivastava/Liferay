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

package com.sambaash.platform.spchat.hook.listeners;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.sambaash.platform.spchat.jabber.JabberUtil;
import com.sambaash.platform.srv.spchat.model.Status;
import com.sambaash.platform.srv.spchat.service.EntryLocalServiceUtil;
import com.sambaash.platform.srv.spchat.service.StatusLocalServiceUtil;

/**
 * @author Scott Lee
 * @author Bruno Farache
 */
public class UserModelListener extends BaseModelListener<User> {

	@Override
	public void onAfterRemove(User user) {
		try {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Removing chat entries and status for user " +
						user.getUserId());
			}

			EntryLocalServiceUtil.deleteEntries(user.getUserId());

			Status status = StatusLocalServiceUtil.getUserStatus(
				user.getUserId());

			if (status != null) {
				StatusLocalServiceUtil.deleteStatus(status);
			}
		}
		catch (Exception e) {
			_log.error(
				"Unable to remove chat entries and status for user " +
					user.getUserId());
		}
	}

	@Override
	public void onAfterUpdate(User user) {
		JabberUtil.updatePassword(
			user.getUserId(), user.getPasswordUnencrypted());
	}

	private static Log _log = LogFactoryUtil.getLog(UserModelListener.class);

}