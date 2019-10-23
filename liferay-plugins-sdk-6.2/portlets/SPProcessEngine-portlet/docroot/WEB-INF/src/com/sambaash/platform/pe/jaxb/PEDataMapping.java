package com.sambaash.platform.pe.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEDataMapping {

	public List<PEDataMappingElement> getElmnts() {
		return elmnts;
	}

	@XmlElement(name ="mappingElement")
	public void setElmnts(List<PEDataMappingElement> elmnts) {
		this.elmnts = elmnts;
	}

	private List<PEDataMappingElement> elmnts;

}