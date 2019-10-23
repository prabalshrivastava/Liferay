package com.sambaash.platform.pe.jaxb;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.handlers.PEAccountCreationHandler;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

import javax.xml.bind.annotation.XmlElement;
public class PECreatAccountNode extends PEActionNode {
	private static Log _log = LogFactoryUtil.getLog(PECreatAccountNode.class);
	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.CREATEACCOUNT;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.BACKEND_ACTION;
	}

	@Override
	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PENodeHandler handler = new PEAccountCreationHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			_log.error(ex);
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	@XmlElement(name ="templateId")
	public void setMailTemplateId(long mailTemplateId) {
		this.mailTemplateId = mailTemplateId;
	} public long getMailTemplateId() {
		return mailTemplateId;
	}
	
	@XmlElement(name ="accountStatusId")
	public void setAccountStatusId(int accountStatusId) {
		this.accountStatusId = accountStatusId;
	} public int getAccountStatusId() {
		return accountStatusId;
	}
	
	@XmlElement(name ="emailAddressVerifiedId")
	public void setEmailAddressVerifiedId(int emailAddressVerifiedId) {
		this.emailAddressVerifiedId = emailAddressVerifiedId;
	} public int getEmailAddressVerifiedId() {
		return emailAddressVerifiedId;
	}

	private long mailTemplateId;
	private int accountStatusId;
	private int emailAddressVerifiedId;

}