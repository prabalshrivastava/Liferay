package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class PEHeader {

	private List<PEParameter> parameters;

	public List<PEParameter> getParameters() {
		if (parameters == null) {
			parameters = new ArrayList<>();
		}
		return parameters;
	}

	@XmlElement(name ="parameter")
	public void setParameters(List<PEParameter> parameters) {
		this.parameters = parameters;
	}

}