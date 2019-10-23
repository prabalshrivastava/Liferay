
package com.sambaash.platform.finance.scheduler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;
import com.sambaash.platform.finance.service.impl.SPFinanceLocalServiceImpl;
import com.sambaash.platform.util.SambaashUtil;

public class FinanceScheduler implements MessageListener {
	
	private static final Log _log = LogFactoryUtil.getLog(SPFinanceLocalServiceImpl.class);
	
	@Override
    public void receive(Message message) throws MessageListenerException {
		String groupIds = SPFinanceLocalServiceUtil.getGroupIds();
		String response = SPFinanceLocalServiceUtil.autoCloseCounter();
		if(!response.equals("success")) {
			_log.error("failed to close the counters !!");
		} else {
			_log.info("successfully close the counters !!");
		}
		
		response = SPFinanceLocalServiceUtil.generateLorReport(groupIds);
		if(!response.equals("success")) {
			_log.error("failed to generate LOR report !!");
		} else {
			_log.info("successfully generated LOR report !!");
		}
	}

}
