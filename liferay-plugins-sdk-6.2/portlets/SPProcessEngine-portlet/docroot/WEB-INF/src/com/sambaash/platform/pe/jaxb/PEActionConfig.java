package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;
public class PEActionConfig extends PEConfigImpl {
	@XmlElement (name ="actionId")
	public void setActionId(long actionId) {
		this.actionId = actionId;
	} public long getActionId() {
		return actionId;
	}

	private long actionId;

}