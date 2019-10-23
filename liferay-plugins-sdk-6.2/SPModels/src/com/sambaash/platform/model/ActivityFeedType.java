package com.sambaash.platform.model;

public enum ActivityFeedType {

	ADD_ENTITY(1), UPDATE_ENTITY(2), ADD_COMMENT(3), FOLLOW(4), LIKE(5);
	
	private int type;
	
	private ActivityFeedType(int type) {
		this.type = type;
	}
	
	public int getValue() {
		return type;
	}
	
}
