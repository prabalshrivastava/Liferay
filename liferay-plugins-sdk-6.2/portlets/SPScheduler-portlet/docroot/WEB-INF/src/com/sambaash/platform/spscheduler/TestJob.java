package com.sambaash.platform.spscheduler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.scheduler.SPScheduledJob;

public class TestJob extends SPScheduledJob {

	private static Log _log = LogFactoryUtil.getLog(TestJob.class);

	@Override
	public void executeJob() {
		_log.debug("THIS IS A TEST MESSAGE");
	}
}
