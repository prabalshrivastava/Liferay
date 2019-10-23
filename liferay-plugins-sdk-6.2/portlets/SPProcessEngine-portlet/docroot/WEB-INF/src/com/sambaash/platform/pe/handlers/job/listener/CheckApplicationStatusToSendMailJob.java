package com.sambaash.platform.pe.handlers.job.listener;

import java.util.Calendar;
import java.util.Date;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.handlers.PEMailHandler;
import com.sambaash.platform.pe.jaxb.PEMail;

public class CheckApplicationStatusToSendMailJob extends AbstractJobListener {
	private static final Log LOG = LogFactoryUtil.getLog(CheckApplicationStatusToSendMailJob.class);

	@Override
	protected void doJobExecutionLogic() throws SystemException {
		LOG.debug("Executing Job Logic of CheckApplicationStatusToMailJob");
		
		String status = dataSource.getProcessState().getStatus();
		Calendar c = Calendar.getInstance();
		c.setTime(dataSource.getProcessState().getModifiedDate());
		c.add(Calendar.DATE,3);
		if(c.getTime().compareTo(new Date())<0 && (status.equalsIgnoreCase("Started") || status.equalsIgnoreCase("Pending") || status.equalsIgnoreCase("InProgress"))){
			PEMailHandler mailHandler = new PEMailHandler((PEMail) dataSource.getDirectory().getNode(nodeId), dataSource);
			mailHandler.process();		
		}

	}
	
	@Override
	protected boolean canExecuteJob() {
		// this sample job listener does not need to check the rule, so always return true
		return true;
	}
	
}
