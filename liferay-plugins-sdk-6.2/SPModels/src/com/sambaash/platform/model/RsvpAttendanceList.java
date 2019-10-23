package com.sambaash.platform.model;


public class RsvpAttendanceList {

	private String type;
	private String value;
	private String label;
	
	public RsvpAttendanceList(String value, String type, String label) {
		this.type = type;
		this.value = value;
		this.label = label;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
