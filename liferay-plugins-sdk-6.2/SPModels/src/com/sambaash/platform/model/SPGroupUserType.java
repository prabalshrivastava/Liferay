package com.sambaash.platform.model;

public enum SPGroupUserType {

	MEMBER(0), ADMIN(1), OWNER(2);
	 
	private int type;
	
	private SPGroupUserType(int type) {
		this.type = type;
	}
	
	public int getValue() {
		return type;
	}

}
