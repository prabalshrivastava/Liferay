package com.sambaash.platform.pe.jaxb;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public class PEStatusCheckTimer extends PEActionNode {

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
			 output = new PEProcessableNodeOutput();
			output.setNextNodeId(getNextNodeId());
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

}