package com.sambaash.platform.pe.handlers.job.listener;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class AnnualCandidature extends AbstractJobListener {
	private static final Log LOG = LogFactoryUtil.getLog(AnnualCandidature.class);

	@Override
	protected void doJobExecutionLogic() throws SystemException {
		LOG.error("Executing Job Logic of AnnualCandidatureJob");
	}


	@Override
	protected boolean canExecuteJob() {
		return true;
	}

}
