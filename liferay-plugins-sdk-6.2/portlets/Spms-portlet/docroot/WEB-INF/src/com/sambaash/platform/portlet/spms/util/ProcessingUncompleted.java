package com.sambaash.platform.portlet.spms.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
public class ProcessingUncompleted implements MessageListener {

	public void receive(Message message) {
		try {
			_log.info("MessageListener : ");
			_log.info("Scheduler is running : ");
			_log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			//Util.checkStatus();
		}
		catch (Exception e) {
			_log.error("Unable to process scheduler " + message, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ProcessingUncompleted.class);

}