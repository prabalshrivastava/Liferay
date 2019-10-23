package com.sambaash.platform.rpec.scheduler;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil;



public class EmailReminderScheduler implements MessageListener {

	@Override
	public void receive(Message arg0) throws MessageListenerException {
		try
		{
			SPRPECLocalServiceUtil.notifyByEmail();
System.out.println("email is sent.......................");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
