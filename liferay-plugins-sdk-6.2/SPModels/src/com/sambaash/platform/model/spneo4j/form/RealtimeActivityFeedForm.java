package com.sambaash.platform.model.spneo4j.form;

import java.util.ArrayList;
import java.util.List;

public class RealtimeActivityFeedForm {

	private String communityName;

	private String className;
	
	private long classPK;
	
	private int type;

	private List<String> sendToUsers = new ArrayList<String>();

	public RealtimeActivityFeedForm() {
		
	}

	public RealtimeActivityFeedForm(String communityName, String className, long classPK, int type) {
		this.communityName = communityName;
		this.className = className;
		this.classPK = classPK;
		this.type = type;
	}

	public RealtimeActivityFeedForm(String communityName, String className,
			long classPK, int type, List<String> sendToUsers) {
		this.communityName = communityName;
		this.className = className;
		this.classPK = classPK;
		this.type = type;
		this.sendToUsers = sendToUsers;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<String> getSendToUsers() {
		return sendToUsers;
	}

	public void setSendToUsers(List<String> sendToUsers) {
		this.sendToUsers = sendToUsers;
	}
	
}
