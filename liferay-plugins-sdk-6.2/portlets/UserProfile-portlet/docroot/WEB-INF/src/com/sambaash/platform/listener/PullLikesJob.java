package com.sambaash.platform.listener;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLikeLocalServiceUtil;
public class PullLikesJob implements MessageListener {

	private static Log _log = LogFactoryUtil.getLog(PullLikesJob.class);

	public void receive(Message message) throws MessageListenerException {
		_log.debug(" PullLikesJob : message - " + message.toString());
		try {
			Group group = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));
			User user = UserLocalServiceUtil.getUser(message.getLong("templateCategoryId"));
			SocialProfileLikeLocalServiceUtil.unschedule(user.getUserId());
			SocialProfileLikeLocalServiceUtil.addContactsAndLikes(user, group.getGroupId());
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}
}