package com.sambaash.platform.model;

public enum SPGroupStatus {

	OPEN(0), CLOSED(1);
	 
	private int status;
	
	private SPGroupStatus(int status) {
		this.status = status;
	}
	
	public int getValue() {
		return status;
	}

}
