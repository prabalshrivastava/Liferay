package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;
public class PEDataMappingElement {

	public String getFieldId() {
		return fieldId;
	}

	@XmlElement(name ="fieldId")
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	} public String getProcessFieldId() {
		return processFieldId;
	}

	@XmlElement(name ="processFieldId")
	public void setProcessFieldId(String processFieldId) {
		this.processFieldId = processFieldId;
	}

	private String fieldId;
	private String processFieldId;

}