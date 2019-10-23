package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.handlers.PECustomActionHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public class PECustomActionNode extends PEActionNode {

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.CUSTOM_ACTION;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.BACKEND_ACTION;
	}

	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			//TODO:
			PECustomActionHandler handler = new PECustomActionHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	public String getConfiguration() {
		return configuration;
	}
	@XmlElement(name ="configuration")
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	public long getActionClassId() {
		return actionClassId;
	}

	@XmlElement(name ="customActionId")
	public void setActionClassId(long actionClassId) {
		this.actionClassId = actionClassId;
	}

	private long actionClassId;
	private String configuration;
}