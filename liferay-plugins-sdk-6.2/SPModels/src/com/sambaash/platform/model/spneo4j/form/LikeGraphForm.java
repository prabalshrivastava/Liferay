package com.sambaash.platform.model.spneo4j.form;

import java.io.Serializable;
import java.util.Date;

public class LikeGraphForm extends BaseGraphForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;
	
	private long startUserId;

	private String endEntityClassName;
	
	private long endEntityClassPK;
	
	private Date likedDate;
	
	public LikeGraphForm() {
		
	}

	public LikeGraphForm(String communityName, long startUserId, String endEntityClassName, long endEntityClassPK, Date likedDate) {
		super.setCommunityName(communityName);
		this.startUserId = startUserId;
		this.endEntityClassName = endEntityClassName;
		this.endEntityClassPK = endEntityClassPK;
		this.likedDate = likedDate;
	}

	public LikeGraphForm(String communityName, String action, long startUserId, String endEntityClassName, long endEntityClassPK, Date likedDate) {
		super.setCommunityName(communityName);
		this.action = action;
		this.startUserId = startUserId;
		this.endEntityClassName = endEntityClassName;
		this.endEntityClassPK = endEntityClassPK;
		this.likedDate = likedDate;
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

	public Date getLikedDate() {
		return likedDate;
	}

	public void setLikedDate(Date likedDate) {
		this.likedDate = likedDate;
	}

}
