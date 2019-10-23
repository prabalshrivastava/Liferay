package com.sambaash.platform.pe;

public enum PEComponentType {

	REQUEST("request"),RESPONSE("response"),FORM("form"),PROCESS("process"),LAST_SUBMITTED_FORM("datasubmitted");

	PEComponentType(String type) {
		this.type = type;
	}

	private String type;

	public String toString() {
		return type;
	}
}