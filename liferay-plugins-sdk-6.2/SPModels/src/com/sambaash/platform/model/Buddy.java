package com.sambaash.platform.model;

import com.liferay.portal.model.User;

public class Buddy {
	
	private Boolean awake;
	private String firstName;
	private Long groupId;
	private String lastName;
	private Boolean male;
	private String middleName;
	private Boolean online;
	private Long portraitId;
	private String screenName;
	private Long userId;
	private String uuid;
	
	public Buddy() {
	}
	
	public Buddy(User user, Boolean awake, Boolean online) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		try {this.male = user.isMale();}catch(Exception e) {this.male=true;}
		this.online = online;
		this.portraitId = user.getPortraitId();
		this.userId=user.getUserId();
		this.uuid=user.getUuid();
		this.screenName = user.getScreenName();
		this.middleName = user.getMiddleName();
		try {this.groupId = user.getGroupId();} catch (Exception e) {}
		this.awake = awake;
	}
	
	public Boolean isAwake() {
		return awake;
	}
	public String getFirstName() {
		return firstName;
	}
	public Long getGroupId() {
		return groupId;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public Boolean getOnline() {
		return online;
	}
	public Long getPortraitId() {
		return portraitId;
	}
	public String getScreenName() {
		return screenName;
	}
	public Long getUserId() {
		return userId;
	}
	public String getUuid() {
		return uuid;
	}
	public Boolean isMale() {
		return male;
	}
	public void isOnline(Boolean online) {
		this.online = online;
	}
	public void setAwake(Boolean awake) {
		this.awake = awake;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setMale(Boolean male) {
		this.male = male;
	}
	public void setPortraitId(Long portraitId) {
		this.portraitId = portraitId;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}