package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.pe.handlers.PEProcessHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public class PEProcessNode extends MultiOutputNodeImpl {
	private String ruleVersion = PEConstants.RULE_VERSION_1; // default to version 1 for backward compatibility

	public String getRuleVersion() {
		return ruleVersion;
	}

	@XmlElement(name ="ruleVersion")
	public void setRuleVersion(String ruleVersion) {
		this.ruleVersion = ruleVersion;
	}

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.PROCESS;
	}

	@Override
	public PENodeType getNodeType() {
		//TODO: as of now, keeping as BACKEND_ACTION. But this node actually not an action.

		// Need to idenitify the nodetype for this node.

		return PENodeType.BACKEND_ACTION;
	}

	@Override
	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PENodeHandler handler = new PEProcessHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

}