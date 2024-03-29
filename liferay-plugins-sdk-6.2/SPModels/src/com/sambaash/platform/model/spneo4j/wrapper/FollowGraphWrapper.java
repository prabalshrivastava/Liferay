package com.sambaash.platform.model.spneo4j.wrapper;

import java.io.Serializable;

public class FollowGraphWrapper extends BaseGraphWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;
	
	private long startUserId;

	private String endEntityClassName;
	
	private long endEntityId;
	
	public FollowGraphWrapper() {
		
	}

	public FollowGraphWrapper(String communityName, long startUserId, String endEntityClassName, long endEntityId) {
		this.communityName = communityName;
		this.startUserId = startUserId;
		this.endEntityClassName = endEntityClassName;
		this.endEntityId = endEntityId;
	}
	
	public FollowGraphWrapper(String communityName, String action, long startUserId, String endEntityClassName, long endEntityId) {
		this.communityName = communityName;
		this.action = action;
		this.startUserId = startUserId;
		this.endEntityClassName = endEntityClassName;
		this.endEntityId = endEntityId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public long getStartUserId() {
		return startUserId;
	}

	public void setStartUserId(long startUserId) {
		this.startUserId = startUserId;
	}

	public String getEndEntityClassName() {
		return endEntityClassName;
	}

	public void setEndEntityClassName(String endEntityClassName) {
		this.endEntityClassName = endEntityClassName;
	}

	public long getEndEntityId() {
		return endEntityId;
	}

	public void setEndEntityId(long endEntityId) {
		this.endEntityId = endEntityId;
	}
	
}
