package com.sambaash.platform.model.spneo4j.form;

import java.io.Serializable;
import java.util.Date;

public class JoinGraphForm extends BaseGraphForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;
	
	private long startUserId;

	private String endEntityClassName;
	
	private long endEntityClassPK;

	private int role;
    
	private int status;
	
	private Date joinedDate;
	
	public JoinGraphForm() {
		
	}

	public JoinGraphForm(String action, long startUserId, String endEntityClassName, long endEntityClassPK, int role,
			int status, Date joinedDate) {
		this.action = action;
		this.startUserId = startUserId;
		this.endEntityClassName = endEntityClassName;
		this.endEntityClassPK = endEntityClassPK;
		this.role = role;
		this.status = status;
		this.joinedDate = joinedDate;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

}
