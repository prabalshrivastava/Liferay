package com.sambaash.platform.pe.handlers.job.listener;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SampleCustomJobListener extends AbstractJobListener {
	private static final Log LOG = LogFactoryUtil.getLog(SampleCustomJobListener.class);

	@Override
	protected void doJobExecutionLogic() throws SystemException {
		// don't want to do anything but to log a message
		LOG.error("SampleCustomJobListener EXECUTED.");
	}

	@Override
	protected boolean canExecuteJob() {
		// this sample job listener does not need to check the rule, so always return true
		return true;
	}

}
