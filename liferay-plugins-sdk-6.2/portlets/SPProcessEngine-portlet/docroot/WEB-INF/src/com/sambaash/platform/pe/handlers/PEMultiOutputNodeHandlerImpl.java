package com.sambaash.platform.pe.handlers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.jaxb.MultiOutputNode;
import com.sambaash.platform.pe.jaxb.PEOutcome;
import com.sambaash.platform.pe.rule.PERuleEngine;
import com.sambaash.platform.pe.rule.PERuleEngineImpl;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public abstract class PEMultiOutputNodeHandlerImpl extends PENodeHandlerImpl {

	protected MultiOutputNode node;

	public long getNextNodeId(PEProcessState processState, PEDataSource ds) throws PortalException, SystemException {
		PEOutcome outcome = calculateOutcome( ds);

		long nextNodeId = 0;

		if (Validator.isNotNull(outcome)) {
			nextNodeId = outcome.getNextNodeId();
		}

		return nextNodeId;
	} 

	public long getNextNodeIdV2(PEProcessState processState, PEDataSource ds) throws PortalException, SystemException {
		PEOutcome outcome = calculateOutcomeV2( ds);

		long nextNodeId = 0;

		if (Validator.isNotNull(outcome)) {
			nextNodeId = outcome.getNextNodeId();
		}

		return nextNodeId;
	} 
	
	private long calculateRuleId(PEDataSource ds) throws PortalException, SystemException {
		PERuleEngine ruleEngine;
		ruleEngine = new PERuleEngineImpl(node.getRuleSetId(), ds);
		return ruleEngine.evaluateRuleset();
	}

	private long calculateRuleIdV2(PEDataSource ds) throws PortalException, SystemException {
		PERuleEngine ruleEngine;
		ruleEngine = new PERuleEngineImpl(node.getRuleSetId(), ds, 2);
		return ruleEngine.evaluateRuleset();
	}
	
	PEMultiOutputNodeHandlerImpl(MultiOutputNode node, PEDataSource ds) {
		super(ds);
		this.node = node;
	}

	private PEOutcome calculateOutcome(PEDataSource ds) throws PortalException, SystemException {
		return node.getOutcome(calculateRuleId(ds));
	}

	private PEOutcome calculateOutcomeV2(PEDataSource ds) throws PortalException, SystemException {
		return node.getOutcome(calculateRuleIdV2(ds));
	}
	
}