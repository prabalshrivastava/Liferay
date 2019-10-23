package com.sambaash.platform.pe.jaxb;

import com.liferay.portal.kernel.util.Validator;

import javax.xml.bind.annotation.XmlElement;
public abstract class MultiOutputNodeImpl extends PEProcessableNodeImpl implements MultiOutputNode {
	@Override
	public PEOutcome getOutcome(long ruleId) {
		PEOutcome outcome = null;

		if (Validator.isNotNull(outcomes)) {
			outcome = outcomes.getOutcome(ruleId);
		}

		return outcome;
	}

	public PEOutcomeList getOutcomes() {
		return outcomes;
	}

	public long getRuleSetId() {
		return ruleSetId;
	}

	@XmlElement (name ="outcomes")
	public void setOutcomes(PEOutcomeList outcomes) {
		this.outcomes = outcomes;
	}

	@XmlElement (name ="rulesetId")
	public void setRuleSetId(long ruleSetId) {
		this.ruleSetId = ruleSetId;
	}

	private PEOutcomeList outcomes;
	private long ruleSetId;

}