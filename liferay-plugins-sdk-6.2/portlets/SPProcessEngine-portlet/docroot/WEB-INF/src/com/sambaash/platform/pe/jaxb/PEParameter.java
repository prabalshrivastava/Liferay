package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;
public class PEParameter {
	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	@XmlElement(name ="key")
	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	@XmlElement(name ="value")
	public void setValue(String value) {
		this.value = value;
	}

}