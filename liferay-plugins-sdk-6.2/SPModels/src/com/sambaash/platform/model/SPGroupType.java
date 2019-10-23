package com.sambaash.platform.model;

public enum SPGroupType {

	PUBLIC(0), MEMBERS_ONLY(1), ADMIN(2);
	
	private int status;
	
	private SPGroupType(int status) {
		this.status = status;
	}
	
	public int getValue() {
		return status;
	}
}
