package com.sambaash.platform.pe.handlers.job.listener;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.helpers.PEOutputHelper;
import com.sambaash.platform.pe.rule.PERuleEngine;
import com.sambaash.platform.pe.rule.PERuleEngineImpl;
import com.sambaash.platform.scheduler.SPScheduledJob;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public abstract class AbstractJobListener extends SPScheduledJob {
	private static final Log LOG = LogFactoryUtil.getLog(AbstractJobListener.class);
	
	protected abstract void doJobExecutionLogic() throws Throwable;

	protected String jobName;
	protected long processStateId;
	protected long nodeId;
	protected long rulesetId;
	protected PEDataSource dataSource;
	
	@Override
	public void executeJob() {
		Map<String, Object> jobMap = getJobExecutionContext().getMergedJobDataMap().getWrappedMap();

		jobName = getJobExecutionContext().getJobDetail().getDescription();	
		LOG.debug("Checking execution of " + jobName + " :: " + getSPJobEntryId());
		boolean execOnce = (boolean) jobMap.get("execOnce");
		processStateId = (long) jobMap.get("jobProcessStateId");
		nodeId = (long) jobMap.get("jobNodeId");
		rulesetId = (long) jobMap.get("rulesetId");
		LOG.debug(processStateId+"|"+nodeId+" - Execute Once : "+execOnce);
		
		try {
			LOG.debug("Preparing DataSource");
//			SambaashUtil.clearAllCaches();
			PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			processState = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(processState);
			LOG.debug("GOT processState => "+processState.getModifiedDate());
			LOG.debug("state data => "+processState.getData());
			PERequestData requestData = PERequestData.getRequestDataUsingProcessStateId(processStateId, false);
			dataSource = PEOutputHelper.prepareDataSource(requestData, processState);
			LOG.debug("GOT DataSource");
		} catch (Exception e) {
			LOG.error("Unable to prepare DataSource", e);
		}
		
		if (execOnce && hasBeenExecutedOnce()) {
			LOG.debug("Unscheduling "+jobName);
			unschedule();
		} else if(canExecuteJob()) {
			LOG.debug("Job " + jobName + " executing");
			try {
				doJobExecutionLogic();
				LOG.debug("Done executing " + jobName + ". Creating exec audit.");
				createExecAudit();	
//				SambaashUtil.clearAllCaches();
			} catch (Throwable e) {
				LOG.debug("Error creating exec audit", e);
			}
		}
	}

	protected boolean canExecuteJob() {
		boolean retval = false;
		if (rulesetId <= 0) {
			// no rules, always execute
			retval =  true;
		} else {
			// got rules, evaluate. If any rule got satisfied then execute
			try {
				PERuleEngine ruleEngine = new PERuleEngineImpl(rulesetId, dataSource, 2);
				retval = ruleEngine.evaluateRuleset() != PEConstants.RULE_ID_DEFAULT;				
			} catch (Exception e) {
				LOG.error("Unable to evaluate job rules", e);
			}
		}
		return retval;
	}

	protected void unschedule() {
		try {
			List<SPJobEntry> jobEntryList = SPJobEntryLocalServiceUtil.getSPJobEntryByJobNameAndJobClass(jobName, AbstractJobListener.class.getName());
			
			if (!jobEntryList.isEmpty()) {
				SPJobEntryLocalServiceUtil.unSchedule(jobName, AbstractJobListener.class.getName());
			}
			createUnscheduleAudit();
		} catch (Exception e) {
			LOG.error("Unable to unschedule " + jobName);
		}		
	}

	protected boolean hasBeenExecutedOnce(){
		try {
			return PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(processStateId, nodeId, PEAuditConstants.ACTION_EXECUTE) != null;
		} catch (NoSuchPEProcessAuditException | SystemException e) {
			return false;
		}
	}
	
	protected PEProcessAudit createExecAudit() throws SystemException, PortalException  {
		PEProcessAudit audit = createAudit();
		audit.setType(PEAuditConstants.TYPE_TIMER);
		audit.setAction(PEAuditConstants.ACTION_EXECUTE);
		return PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
	}
	
	protected PEProcessAudit createUnscheduleAudit() throws SystemException, PortalException  {
		PEProcessAudit audit = createAudit();
		audit.setType(PEAuditConstants.TYPE_TIMER);
		audit.setAction("unscheduled");
		return PEProcessAuditLocalServiceUtil.updatePEProcessAudit(audit);
	}
	
	protected PEProcessAudit createAudit() throws SystemException, PortalException  {
		PEProcessAudit audit = PEProcessAuditLocalServiceUtil.create(processStateId);
		User user = UserLocalServiceUtil.getUser(SambaashUtil.getAdminUserId());
		Date now = new Date();
		audit.setCreateDate(now);
		audit.setModifiedDate(now);
		audit.setUserId(user.getUserId());
		audit.setUserName(user.getFullName());
		audit.setCompanyId(user.getCompanyId());
		audit.setNodeId(nodeId);
		return audit;
	}
	
}
