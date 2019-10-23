package com.sambaash.platform.pe.handlers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.jaxb.PEProcessNode;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
public class PEProcessHandler extends PEMultiOutputNodeHandlerImpl {

	public PEProcessHandler(PEProcessNode node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() {
		PEProcessNode process = (PEProcessNode)node;
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
		try {
			long nextNodeId = determineNextNodeId(process);
			output.setNextNodeId(nextNodeId);
			proceedToNextNode(output, nextNodeId, false);
			PEAuditHelper audit = PEAuditHelper.getAuditHelper(processState, ds);
			long rulesetId = process.getRuleSetId();
			audit.logProcessNode(PEAuditConstants.DONE_BY_PE, rulesetId,process.getNodeId() ,StringPool.BLANK);
		}catch (Exception ex) {
			output.setError(PEErrors.format(PEErrors.AUDIT_PROCESS_ARGS,node.toString()));
		}

		return output;
	}

	private long determineNextNodeId(PEProcessNode process) throws PortalException, SystemException {
		long nextNodeId;
		if (PEConstants.RULE_VERSION_2.equals(process.getRuleVersion())) {
			nextNodeId = getNextNodeIdV2(processState, ds);
		} else {
			nextNodeId = getNextNodeId(processState, ds);
		}
		return nextNodeId;
	}

}