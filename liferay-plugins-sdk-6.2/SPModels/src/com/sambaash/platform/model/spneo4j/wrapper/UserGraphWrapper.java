package com.sambaash.platform.model.spneo4j.wrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserGraphWrapper extends BaseGraphWrapper implements Serializable {

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

	List<Long> interestIds = new ArrayList<Long>();
	
	public UserGraphWrapper() {
		
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

}
