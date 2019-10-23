package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;
public class PEOutcome {

	public long getRuleId() {
		return ruleId;
	}

	@XmlElement(name ="nextNodeId")
	public void setNextNodeId(long nextNodeId) {
		this.nextNodeId = nextNodeId;
	}

	@XmlElement(name ="ruleId")
	public void setRuleId(long ruleSetId) {
		this.ruleId = ruleSetId;
	}

	@Override
	public String toString() {
		return "Outcome [ruleId=" + ruleId + ", nextNodeId=" + nextNodeId + "]";
	} public long getNextNodeId() {
		return nextNodeId;
	}

	private long nextNodeId;
	private long ruleId;

}