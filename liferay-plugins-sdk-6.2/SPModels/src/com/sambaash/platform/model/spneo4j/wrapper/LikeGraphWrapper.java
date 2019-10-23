package com.sambaash.platform.model.spneo4j.wrapper;

import java.io.Serializable;

public class LikeGraphWrapper extends BaseGraphWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;
	
	private long startUserId;

	private String endEntityClassName;
	
	private long endEntityClassPK;
	
	public LikeGraphWrapper() {
		
	}

	public LikeGraphWrapper(String communityName, long startUserId, String endEntityClassName, long endEntityClassPK) {
		this.communityName = communityName;
		this.startUserId = startUserId;
		this.endEntityClassName = endEntityClassName;
		this.endEntityClassPK = endEntityClassPK;
	}

	public LikeGraphWrapper(String communityName, String action, long startUserId, String endEntityClassName, long endEntityClassPK) {
		this.communityName = communityName;
		this.action = action;
		this.startUserId = startUserId;
		this.endEntityClassName = endEntityClassName;
		this.endEntityClassPK = endEntityClassPK;
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

	public long getEndEntityClassPK() {
		return endEntityClassPK;
	}

	public void setEndEntityClassPK(long endEntityClassPK) {
		this.endEntityClassPK = endEntityClassPK;
	}

}
