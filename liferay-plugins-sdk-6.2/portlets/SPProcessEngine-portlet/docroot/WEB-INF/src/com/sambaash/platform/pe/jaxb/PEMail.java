package com.sambaash.platform.pe.jaxb;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.handlers.PEMailHandler;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.xml.bind.annotation.XmlElement;

public class PEMail extends PEActionNode {

	private static Log _log = LogFactoryUtil.getLog(PEMail.class);

	public long getMailTemplateId() {
		return mailTemplateId;
	}

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.MAIL;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.BACKEND_ACTION;
	}

	@Override
	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PENodeHandler handler = new PEMailHandler(this, ds);
			output = handler.process();
		} catch (Exception ex) {
			_log.error(ex.getMessage());
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	@XmlElement(name = "templateId")
	public void setMailTemplateId(long mailTemplateId) {
		this.mailTemplateId = mailTemplateId;
	}

	public String getRecipient() {
		return recipient;
	}

	@XmlElement(name = "recipient")
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getOfficerRoleIds() {
		return officerRoleIds;
	}

	@XmlElement(name = "officerRoleIds")
	public void setOfficerRoleIds(String officerRoleIds) {
		this.officerRoleIds = officerRoleIds;
	}

	public String getCc() {
		return cc;
	}

	@XmlElement(name = "cc")
	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getCcEmailAddressText() {
		return ccEmailAddressText;
	}

	@XmlElement(name = "ccEmailAddressText")
	public void setCcEmailAddressText(String ccEmailAddressText) {
		this.ccEmailAddressText = ccEmailAddressText;
	}

	private long mailTemplateId;
	private String recipient;
	private String officerRoleIds;
	private String cc;
	private String ccEmailAddressText;

}