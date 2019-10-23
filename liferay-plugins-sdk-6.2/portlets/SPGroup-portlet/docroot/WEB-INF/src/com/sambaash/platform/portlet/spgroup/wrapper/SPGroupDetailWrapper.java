package com.sambaash.platform.portlet.spgroup.wrapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.NoSuchUserException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
public class SPGroupDetailWrapper {

	public SPGroupDetailWrapper() {
	}

	public SPGroupDetailWrapper(SPGroup spGroup) {
		this.spGroup = spGroup;
		try {
			this.user = UserLocalServiceUtil.getUserById(spGroup.getUserId());
		} catch (Exception e) {
			if (e instanceof NoSuchUserException) {

				// do nothing

			}else {
				_log.error(e.getMessage(), e);
			}
		}
	}

	public String getScreenName() {
		return user != null ? user.getScreenName() : StringPool.BLANK;
	}

	public String getUsername() {
		return user != null ? user.getFullName() : spGroup.getUserName();
	}

	private static Log _log = LogFactoryUtil.getLog(SPGroupDetailWrapper.class);

	private SPGroup spGroup;
	private User user;

}