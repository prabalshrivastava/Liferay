package com.sambaash.platform.model;

public enum SPGroupUserStatus {

	APPROVE(0), REQUEST_PENDING(1), INVITATION_UNCONFIRMED(2), REJECTED(3);
	 
	private int status;
	
	private SPGroupUserStatus(int status) {
		this.status = status;
	}
	
	public int getValue() {
		return status;
	}

}
