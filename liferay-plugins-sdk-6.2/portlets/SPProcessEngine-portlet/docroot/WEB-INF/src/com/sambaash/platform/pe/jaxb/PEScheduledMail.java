package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.pe.handlers.PEScheduledMailHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

public class PEScheduledMail extends PEMail implements PEScheduledJob {
	private long ruleSetId;
	private String cronSchedule;
	private String execOnce;
	private String jobListener;

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.SCHEDULED_MAIL;
	}

	@Override
	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PENodeHandler handler = new PEScheduledMailHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	public long getRuleSetId() {
		return ruleSetId;
	}

	@XmlElement (name ="rulesetId")
	public void setRuleSetId(long ruleSetId) {
		this.ruleSetId = ruleSetId;
	}

	public String getCronSchedule() {
		return cronSchedule;
	}

	@XmlElement (name ="cronSchedule")
	public void setCronSchedule(String cronSchedule) {
		this.cronSchedule = cronSchedule;
	}

	public String getExecOnce() {
		return execOnce;
	}

	@XmlElement (name ="execOnce")
	public void setExecOnce(String execOnce) {
		this.execOnce = execOnce;
	}

	@Override
	public boolean isExecuteOnceOnly() {
		return Boolean.parseBoolean(getExecOnce());
	}

	public String getJobListener() {
		return jobListener;
	}

	@XmlElement (name ="jobListener")
	public void setJobListener(String jobListener) {
		this.jobListener = jobListener;
	}
	
}