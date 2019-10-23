package com.sambaash.platform.pe.jaxb;

public interface MultiOutputNode extends PEProcessableNode {

	PEOutcome getOutcome(long ruleId);
	long getRuleSetId();
	void setRuleSetId(long ruleSetId);

}