/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.mail.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPMailBlackList}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailBlackList
 * @generated
 */
public class SPMailBlackListWrapper implements SPMailBlackList,
	ModelWrapper<SPMailBlackList> {
	public SPMailBlackListWrapper(SPMailBlackList spMailBlackList) {
		_spMailBlackList = spMailBlackList;
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailBlackList.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailBlackList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailBlackListId", getSpMailBlackListId());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("userId", getUserId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("bounced", getBounced());
		attributes.put("bounce_soft", getBounce_soft());
		attributes.put("complain", getComplain());
		attributes.put("createDate", getCreateDate());
		attributes.put("message", getMessage());
		attributes.put("messageId", getMessageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailBlackListId = (Long)attributes.get("spMailBlackListId");

		if (spMailBlackListId != null) {
			setSpMailBlackListId(spMailBlackListId);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Boolean bounced = (Boolean)attributes.get("bounced");

		if (bounced != null) {
			setBounced(bounced);
		}

		Boolean bounce_soft = (Boolean)attributes.get("bounce_soft");

		if (bounce_soft != null) {
			setBounce_soft(bounce_soft);
		}

		Boolean complain = (Boolean)attributes.get("complain");

		if (complain != null) {
			setComplain(complain);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String messageId = (String)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}
	}

	/**
	* Returns the primary key of this s p mail black list.
	*
	* @return the primary key of this s p mail black list
	*/
	@Override
	public long getPrimaryKey() {
		return _spMailBlackList.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p mail black list.
	*
	* @param primaryKey the primary key of this s p mail black list
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spMailBlackList.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp mail black list ID of this s p mail black list.
	*
	* @return the sp mail black list ID of this s p mail black list
	*/
	@Override
	public long getSpMailBlackListId() {
		return _spMailBlackList.getSpMailBlackListId();
	}

	/**
	* Sets the sp mail black list ID of this s p mail black list.
	*
	* @param spMailBlackListId the sp mail black list ID of this s p mail black list
	*/
	@Override
	public void setSpMailBlackListId(long spMailBlackListId) {
		_spMailBlackList.setSpMailBlackListId(spMailBlackListId);
	}

	/**
	* Returns the sp mail campaign ID of this s p mail black list.
	*
	* @return the sp mail campaign ID of this s p mail black list
	*/
	@Override
	public long getSpMailCampaignId() {
		return _spMailBlackList.getSpMailCampaignId();
	}

	/**
	* Sets the sp mail campaign ID of this s p mail black list.
	*
	* @param spMailCampaignId the sp mail campaign ID of this s p mail black list
	*/
	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailBlackList.setSpMailCampaignId(spMailCampaignId);
	}

	/**
	* Returns the user ID of this s p mail black list.
	*
	* @return the user ID of this s p mail black list
	*/
	@Override
	public long getUserId() {
		return _spMailBlackList.getUserId();
	}

	/**
	* Sets the user ID of this s p mail black list.
	*
	* @param userId the user ID of this s p mail black list
	*/
	@Override
	public void setUserId(long userId) {
		_spMailBlackList.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p mail black list.
	*
	* @return the user uuid of this s p mail black list
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailBlackList.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p mail black list.
	*
	* @param userUuid the user uuid of this s p mail black list
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spMailBlackList.setUserUuid(userUuid);
	}

	/**
	* Returns the email address of this s p mail black list.
	*
	* @return the email address of this s p mail black list
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spMailBlackList.getEmailAddress();
	}

	/**
	* Sets the email address of this s p mail black list.
	*
	* @param emailAddress the email address of this s p mail black list
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spMailBlackList.setEmailAddress(emailAddress);
	}

	/**
	* Returns the bounced of this s p mail black list.
	*
	* @return the bounced of this s p mail black list
	*/
	@Override
	public boolean getBounced() {
		return _spMailBlackList.getBounced();
	}

	/**
	* Returns <code>true</code> if this s p mail black list is bounced.
	*
	* @return <code>true</code> if this s p mail black list is bounced; <code>false</code> otherwise
	*/
	@Override
	public boolean isBounced() {
		return _spMailBlackList.isBounced();
	}

	/**
	* Sets whether this s p mail black list is bounced.
	*
	* @param bounced the bounced of this s p mail black list
	*/
	@Override
	public void setBounced(boolean bounced) {
		_spMailBlackList.setBounced(bounced);
	}

	/**
	* Returns the bounce_soft of this s p mail black list.
	*
	* @return the bounce_soft of this s p mail black list
	*/
	@Override
	public boolean getBounce_soft() {
		return _spMailBlackList.getBounce_soft();
	}

	/**
	* Returns <code>true</code> if this s p mail black list is bounce_soft.
	*
	* @return <code>true</code> if this s p mail black list is bounce_soft; <code>false</code> otherwise
	*/
	@Override
	public boolean isBounce_soft() {
		return _spMailBlackList.isBounce_soft();
	}

	/**
	* Sets whether this s p mail black list is bounce_soft.
	*
	* @param bounce_soft the bounce_soft of this s p mail black list
	*/
	@Override
	public void setBounce_soft(boolean bounce_soft) {
		_spMailBlackList.setBounce_soft(bounce_soft);
	}

	/**
	* Returns the complain of this s p mail black list.
	*
	* @return the complain of this s p mail black list
	*/
	@Override
	public boolean getComplain() {
		return _spMailBlackList.getComplain();
	}

	/**
	* Returns <code>true</code> if this s p mail black list is complain.
	*
	* @return <code>true</code> if this s p mail black list is complain; <code>false</code> otherwise
	*/
	@Override
	public boolean isComplain() {
		return _spMailBlackList.isComplain();
	}

	/**
	* Sets whether this s p mail black list is complain.
	*
	* @param complain the complain of this s p mail black list
	*/
	@Override
	public void setComplain(boolean complain) {
		_spMailBlackList.setComplain(complain);
	}

	/**
	* Returns the create date of this s p mail black list.
	*
	* @return the create date of this s p mail black list
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spMailBlackList.getCreateDate();
	}

	/**
	* Sets the create date of this s p mail black list.
	*
	* @param createDate the create date of this s p mail black list
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spMailBlackList.setCreateDate(createDate);
	}

	/**
	* Returns the message of this s p mail black list.
	*
	* @return the message of this s p mail black list
	*/
	@Override
	public java.lang.String getMessage() {
		return _spMailBlackList.getMessage();
	}

	/**
	* Sets the message of this s p mail black list.
	*
	* @param message the message of this s p mail black list
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_spMailBlackList.setMessage(message);
	}

	/**
	* Returns the message ID of this s p mail black list.
	*
	* @return the message ID of this s p mail black list
	*/
	@Override
	public java.lang.String getMessageId() {
		return _spMailBlackList.getMessageId();
	}

	/**
	* Sets the message ID of this s p mail black list.
	*
	* @param messageId the message ID of this s p mail black list
	*/
	@Override
	public void setMessageId(java.lang.String messageId) {
		_spMailBlackList.setMessageId(messageId);
	}

	@Override
	public boolean isNew() {
		return _spMailBlackList.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spMailBlackList.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spMailBlackList.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spMailBlackList.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spMailBlackList.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spMailBlackList.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spMailBlackList.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spMailBlackList.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spMailBlackList.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spMailBlackList.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spMailBlackList.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPMailBlackListWrapper((SPMailBlackList)_spMailBlackList.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPMailBlackList spMailBlackList) {
		return _spMailBlackList.compareTo(spMailBlackList);
	}

	@Override
	public int hashCode() {
		return _spMailBlackList.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPMailBlackList> toCacheModel() {
		return _spMailBlackList.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailBlackList toEscapedModel() {
		return new SPMailBlackListWrapper(_spMailBlackList.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailBlackList toUnescapedModel() {
		return new SPMailBlackListWrapper(_spMailBlackList.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spMailBlackList.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spMailBlackList.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailBlackList.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailBlackListWrapper)) {
			return false;
		}

		SPMailBlackListWrapper spMailBlackListWrapper = (SPMailBlackListWrapper)obj;

		if (Validator.equals(_spMailBlackList,
					spMailBlackListWrapper._spMailBlackList)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPMailBlackList getWrappedSPMailBlackList() {
		return _spMailBlackList;
	}

	@Override
	public SPMailBlackList getWrappedModel() {
		return _spMailBlackList;
	}

	@Override
	public void resetOriginalValues() {
		_spMailBlackList.resetOriginalValues();
	}

	private SPMailBlackList _spMailBlackList;
}