package com.sambaash.platform.model.spneo4j.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserGraphForm extends BaseGraphForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long userId;
	private String firstName;
	private String lastName;
	private String screenName;
	private String emailAddress;
	private long portraitId;
	private boolean emailAddressVerified;
	private int status;
	private Date createDate;
	private Date modifiedDate;
//	private Long groupId;
//	private String virtualHost;
	private String gender;

	List<Long> interestIds = new ArrayList<Long>();
	
	public UserGraphForm() {
		
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getPortraitId() {
		return portraitId;
	}

	public void setPortraitId(long portraitId) {
		this.portraitId = portraitId;
	}

	public boolean getEmailAddressVerified() {
		return emailAddressVerified;
	}

	public void setEmailAddressVerified(boolean emailAddressVerified) {
		this.emailAddressVerified = emailAddressVerified;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<Long> getInterestIds() {
		return interestIds;
	}

	public void setInterestIds(List<Long> interestIds) {
		this.interestIds = interestIds;
	}
	
//	public Long getGroupId() {
//		return groupId;
//	}
//
//	public void setGroupId(Long groupId) {
//		this.groupId = groupId;
//	}
//
//	public String getVirtualHost() {
//		return virtualHost;
//	}
//
//	public void setVirtualHost(String virtualHost) {
//		this.virtualHost = virtualHost;
//	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
