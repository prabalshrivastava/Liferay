package com.sambaash.platform.rpec.scheduler;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class EmailReminderScheduler implements MessageListener {

	private static Log _log = LogFactoryUtil.getLog(EmailReminderScheduler.class);

	@Override
	public void receive(Message arg0) throws MessageListenerException {
		try {
			SPRPECLocalServiceUtil.notifyByEmail();
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

}
