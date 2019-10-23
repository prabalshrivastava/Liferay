package com.sambaash.platform.pe.handlers.job.listener;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.handlers.PEMailHandler;
import com.sambaash.platform.pe.jaxb.PEMail;

public class ScheduledMailJob extends AbstractJobListener {
	private static final Log LOG = LogFactoryUtil.getLog(ScheduledMailJob.class);

	@Override
	protected void doJobExecutionLogic() throws SystemException {
		LOG.debug("Executing Job Logic of ScheduledMailJob");
		PEMailHandler mailHandler = new PEMailHandler((PEMail) dataSource.getDirectory().getNode(nodeId), dataSource);
		mailHandler.process();		
	}
	
}
