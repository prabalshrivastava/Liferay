package com.sambaash.platform.model.spneo4j.wrapper;

import java.io.Serializable;
import java.util.Date;

public class ActivityFeedGraphWrapper extends BaseGraphWrapper implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long startUserId;
	private String startUserFirstName;
	private String startUserLastName;
	private String startUserScreenName;
	private long startUserPortraitId;
	
	private String endClassName;
	private long endClassPK;
	
	private String endAssetEntityTitle;
	private String endAssetEntityUrlTitle;
	private String endAssetEntityContent;
	private String endAssetEntityImageUrl;

	private String endUserFirstName;
	private String endUserLastName;
	private String endUserScreenName;
	private long endUserPortraitId;

	private Date createDate;
	
	private long type;

	// only applicable for spGroup discussion
	private long endAssetEntityReferenceId;
	private String endAssetEntityReferenceTitle;
	private String endAssetEntityReferenceUrlTitle;

	// only applicable for spGroup
	private int endAssetEntityType;

	public ActivityFeedGraphWrapper() {
		
	}

	public long getStartUserId() {
		return startUserId;
	}

	public void setStartUserId(long startUserId) {
		this.startUserId = startUserId;
	}

	public String getStartUserFirstName() {
		return startUserFirstName;
	}

	public void setStartUserFirstName(String startUserFirstName) {
		this.startUserFirstName = startUserFirstName;
	}

	public String getStartUserLastName() {
		return startUserLastName;
	}

	public void setStartUserLastName(String startUserLastName) {
		this.startUserLastName = startUserLastName;
	}

	public String getStartUserScreenName() {
		return startUserScreenName;
	}

	public void setStartUserScreenName(String startUserScreenName) {
		this.startUserScreenName = startUserScreenName;
	}

	public long getStartUserPortraitId() {
		return startUserPortraitId;
	}

	public void setStartUserPortraitId(long startUserPortraitId) {
		this.startUserPortraitId = startUserPortraitId;
	}

	public String getEndClassName() {
		return endClassName;
	}

	public void setEndClassName(String endClassName) {
		this.endClassName = endClassName;
	}

	public long getEndClassPK() {
		return endClassPK;
	}

	public void setEndClassPK(long endClassPK) {
		this.endClassPK = endClassPK;
	}

	public String getEndAssetEntityTitle() {
		return endAssetEntityTitle;
	}

	public void setEndAssetEntityTitle(String endAssetEntityTitle) {
		this.endAssetEntityTitle = endAssetEntityTitle;
	}

	public String getEndAssetEntityUrlTitle() {
		return endAssetEntityUrlTitle;
	}

	public void setEndAssetEntityUrlTitle(String endAssetEntityUrlTitle) {
		this.endAssetEntityUrlTitle = endAssetEntityUrlTitle;
	}

	public String getEndAssetEntityContent() {
		return endAssetEntityContent;
	}

	public void setEndAssetEntityContent(String endAssetEntityContent) {
		this.endAssetEntityContent = endAssetEntityContent;
	}

	public String getEndAssetEntityImageUrl() {
		return endAssetEntityImageUrl;
	}

	public void setEndAssetEntityImageUrl(String endAssetEntityImageUrl) {
		this.endAssetEntityImageUrl = endAssetEntityImageUrl;
	}

	public String getEndUserFirstName() {
		return endUserFirstName;
	}

	public void setEndUserFirstName(String endUserFirstName) {
		this.endUserFirstName = endUserFirstName;
	}

	public String getEndUserLastName() {
		return endUserLastName;
	}

	public void setEndUserLastName(String endUserLastName) {
		this.endUserLastName = endUserLastName;
	}

	public String getEndUserScreenName() {
		return endUserScreenName;
	}

	public void setEndUserScreenName(String endUserScreenName) {
		this.endUserScreenName = endUserScreenName;
	}

	public long getEndUserPortraitId() {
		return endUserPortraitId;
	}

	public void setEndUserPortraitId(long endUserPortraitId) {
		this.endUserPortraitId = endUserPortraitId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public long getEndAssetEntityReferenceId() {
		return endAssetEntityReferenceId;
	}

	public void setEndAssetEntityReferenceId(long endAssetEntityReferenceId) {
		this.endAssetEntityReferenceId = endAssetEntityReferenceId;
	}

	public String getEndAssetEntityReferenceTitle() {
		return endAssetEntityReferenceTitle;
	}

	public void setEndAssetEntityReferenceTitle(String endAssetEntityReferenceTitle) {
		this.endAssetEntityReferenceTitle = endAssetEntityReferenceTitle;
	}

	public String getEndAssetEntityReferenceUrlTitle() {
		return endAssetEntityReferenceUrlTitle;
	}

	public void setEndAssetEntityReferenceUrlTitle(
			String endAssetEntityReferenceUrlTitle) {
		this.endAssetEntityReferenceUrlTitle = endAssetEntityReferenceUrlTitle;
	}

	public int getEndAssetEntityType() {
		return endAssetEntityType;
	}

	public void setEndAssetEntityType(int endAssetEntityType) {
		this.endAssetEntityType = endAssetEntityType;
	}

}
