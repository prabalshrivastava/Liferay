package com.sambaash.platform.spscheduler.action;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.sambaash.platform.spscheduler.impl.SPSchedulerUtil;

public class SchedulerStartupAction extends SimpleAction{
	
	public void run(String[] arg0) throws ActionException {
		SPSchedulerUtil.init();
	}

}
