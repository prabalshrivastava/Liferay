package com.sambaash.platform.portlet.spjob.util;

public enum SPJobStatus {

	/**
	ACTIVE(0), DRAFT(1), CLOSED(2);
	 
	private int status;
	
	private SPJobStatus(int status) {
		this.status = status;
	}
	
	public int getValue() {
		return status;
	}
	*/
	

	ACTIVE("Active"), DRAFT("Draft"), CLOSED("Closed");
	 
	private String status;
	
	private SPJobStatus(String status) {
		this.status = status;
	}
	
	public String getValue() {
		return status;
	}

}
