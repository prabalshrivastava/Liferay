package com.sambaash.platform.pe.jaxb;

import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEActions {

	public PEMailList getMails() {
		return mails;
	}

	public List<PEProcessableNode> getNodes() {
		List<PEProcessableNode>nodes = new ArrayList<PEProcessableNode>();

		if (Validator.isNotNull(statuses)) {
			nodes.addAll(getStatuses().getNodes());
		}

		if (Validator.isNotNull(mails)) {
			nodes.addAll(getMails().getList());
		}

		if (Validator.isNotNull(createAccount)) {
			nodes.add(createAccount);
		}
		
		if(Validator.isNotNull(customActions)){
			nodes.addAll(getCustomActions().getList());
		}

		return nodes;
	}

	public PEStatusList getStatuses() {
		return statuses;
	}

	public void setCreateAccount(PECreatAccountNode createAccount) {
		this.createAccount = createAccount;
	}

	@XmlElement (name = "mails")
	public void setMails(PEMailList mails) {
		this.mails = mails;
	}

	@XmlElement(name ="statuses")
	public void setStatuses(PEStatusList statuses) {
		this.statuses = statuses;
	}
	
	public PECustomActionList getCustomActions() {
		return customActions;
	}

	@XmlElement(name ="customActions")
	public void setCustomActions(PECustomActionList customActions) {
		this.customActions = customActions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Actions [");

		if (statuses != null) {
			builder.append("statuses=");
			builder.append(statuses);
			builder.append(", ");
		}

		if (mails != null) {
			builder.append("mails=");
			builder.append(mails);
			builder.append(", ");
		}

		if (createAccount != null) {
			builder.append("createAccount=");
			builder.append(createAccount);
		}

		builder.append("]");
		return builder.toString();
	} public PECreatAccountNode getCreateAccount() {
		return createAccount;
	}

	private PECreatAccountNode createAccount;
	private PEMailList mails;
	private PEStatusList statuses;
	private PECustomActionList customActions;
}