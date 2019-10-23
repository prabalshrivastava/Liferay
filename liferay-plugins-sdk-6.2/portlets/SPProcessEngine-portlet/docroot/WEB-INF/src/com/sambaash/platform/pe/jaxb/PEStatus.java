package com.sambaash.platform.pe.jaxb;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.pe.handlers.PEStatusHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

import javax.xml.bind.annotation.XmlElement;

public class PEStatus extends PEActionNode {

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.STATUS;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.BACKEND_ACTION;
	}

	public String getStatus() {
		return status;
	}

	public long getStatusTypeId() {
		return statusTypeId;
	}

	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PENodeHandler handler = new PEStatusHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	@XmlElement(name ="status")
	public void setStatus(String status) {
		this.status = status;
	} 

	@XmlElement(name = "statusTypeId")
	public void setStatusTypeId(long statusTypeId) {
		this.statusTypeId = statusTypeId;
	}
	
	
	public long getMailTemplateId() {
		return mailTemplateId;
	}

	@XmlElement(name = "emailTemplateId")
	public void setMailTemplateId(long mailTemplateId) {
		this.mailTemplateId = mailTemplateId;
	}
	
	public String getApproverRoleIds() {
		return approverRoleIds;
	}

	@XmlElement(name = "statusApproverIds")
	public void setApproverRoleIds(String approverRoleIds) {
		this.approverRoleIds = approverRoleIds;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PEStatus [approvers=");
		builder.append(getApproverRoleIds());
		builder.append(", status=");
		builder.append(status);
		builder.append(", statusTypeId=");
		builder.append(statusTypeId);
		builder.append("]");
		return builder.toString();
	}
	
	private String approverRoleIds;
	private String status;
	private long statusTypeId;
	private long mailTemplateId;
}