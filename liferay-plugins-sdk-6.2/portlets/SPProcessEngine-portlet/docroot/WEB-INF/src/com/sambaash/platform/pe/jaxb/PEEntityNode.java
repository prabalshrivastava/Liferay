package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.handlers.PEEntityHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

public class PEEntityNode extends SingleOutputNodeImpl {
	
	private String type;
	private String identifier;
	
	public String getType() {
		return type;
	}

	@XmlElement(name ="type")
	public void setType(String type) {
		this.type = type;
	}

	public String getIdentifier() {
		return identifier;
	}

	@XmlElement(name ="identifier")
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.ENTITY;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.BACKEND_ACTION;
	}

	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PEEntityHandler handler = new PEEntityHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

}