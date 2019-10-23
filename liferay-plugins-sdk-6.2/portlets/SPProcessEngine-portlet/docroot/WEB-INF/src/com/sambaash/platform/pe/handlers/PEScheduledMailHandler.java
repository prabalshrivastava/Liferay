package com.sambaash.platform.pe.handlers;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.pe.jaxb.PEScheduledMail;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;

public class PEScheduledMailHandler extends PEMailHandler {

	private static final Log LOG = LogFactoryUtil.getLog(PEScheduledMailHandler.class);
	private static final String PORTLET_ID = "processstatelisting_WAR_SPProcessEngineportlet";

	public PEScheduledMailHandler(PEScheduledMail node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() throws SystemException {
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		PEScheduledMail jobNode = (PEScheduledMail) node;
		String cronExpression = jobNode.getCronSchedule();
		if (StringUtils.isEmpty(cronExpression)) {
			cronExpression = "0 */5 * * * ?";
		}
		Map<String, Object> jobData = new HashMap<>();
		jobData.put("execOnce", jobNode.isExecuteOnceOnly());
		jobData.put("rulesetId", jobNode.getRuleSetId());
		jobData.put("jobProcessStateId", processState.getSpPEProcessStateId());
		jobData.put("jobNodeId", jobNode.getNodeId());
		jobData.put("nodeSnapshot", JSONFactoryUtil.looseSerialize(jobNode));

		String jobName = getJobName();
		LOG.debug("Submitting PE Job: " + jobName);
		SPJobEntryLocalServiceUtil.schedule(PORTLET_ID, getJobListener(jobNode), jobName, cronExpression, jobName,
				jobData);
		LOG.debug("Submitted " + jobName + " successfully");

		output.setNextNodeId(jobNode.getNextNodeId());
		output.setCanProceedToNext(true);

		PEAuditHelper auditHelper = ds.getAuditHelper();
		PEProcessAudit audit = auditHelper.create();
		audit.setType(PEAuditConstants.TYPE_TIMER);
		audit.setAction("scheduled");
		audit.setNodeId(node.getNodeId());
		auditHelper.updateAudit(audit);
		return output;
	}

	private String getJobListener(PEScheduledMail jobNode) {
		String jobListenerSimpleName = StringUtils.isEmpty(jobNode.getJobListener()) ? PEConstants.DEFAULT_JOB_LISTENER : jobNode.getJobListener();
		return String.format("%s.%s", PEConstants.JOB_LISTENER_PACKAGE, jobListenerSimpleName);
	}
	
	public String getJobName() {
		return String.format("PE-JOB-%d-%d", processState.getSpPEProcessStateId(), node.getNodeId());
	}
}