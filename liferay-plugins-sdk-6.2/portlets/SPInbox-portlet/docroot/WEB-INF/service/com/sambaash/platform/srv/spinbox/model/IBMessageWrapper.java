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

package com.sambaash.platform.srv.spinbox.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link IBMessage}.
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessage
 * @generated
 */
public class IBMessageWrapper implements IBMessage, ModelWrapper<IBMessage> {
	public IBMessageWrapper(IBMessage ibMessage) {
		_ibMessage = ibMessage;
	}

	@Override
	public Class<?> getModelClass() {
		return IBMessage.class;
	}

	@Override
	public String getModelClassName() {
		return IBMessage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("messageId", getMessageId());
		attributes.put("parentMessageId", getParentMessageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("subject", getSubject());
		attributes.put("content", getContent());
		attributes.put("from", getFrom());
		attributes.put("to", getTo());
		attributes.put("allowOpen", getAllowOpen());
		attributes.put("sendDate", getSendDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("createByUserId", getCreateByUserId());
		attributes.put("draft", getDraft());
		attributes.put("deleteStatus", getDeleteStatus());
		attributes.put("draftStatus", getDraftStatus());
		attributes.put("sentMeCopy", getSentMeCopy());
		attributes.put("belongToGroupDetailId", getBelongToGroupDetailId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long parentMessageId = (Long)attributes.get("parentMessageId");

		if (parentMessageId != null) {
			setParentMessageId(parentMessageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String from = (String)attributes.get("from");

		if (from != null) {
			setFrom(from);
		}

		String to = (String)attributes.get("to");

		if (to != null) {
			setTo(to);
		}

		Boolean allowOpen = (Boolean)attributes.get("allowOpen");

		if (allowOpen != null) {
			setAllowOpen(allowOpen);
		}

		Date sendDate = (Date)attributes.get("sendDate");

		if (sendDate != null) {
			setSendDate(sendDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String createBy = (String)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		String createByUserId = (String)attributes.get("createByUserId");

		if (createByUserId != null) {
			setCreateByUserId(createByUserId);
		}

		Boolean draft = (Boolean)attributes.get("draft");

		if (draft != null) {
			setDraft(draft);
		}

		Boolean deleteStatus = (Boolean)attributes.get("deleteStatus");

		if (deleteStatus != null) {
			setDeleteStatus(deleteStatus);
		}

		String draftStatus = (String)attributes.get("draftStatus");

		if (draftStatus != null) {
			setDraftStatus(draftStatus);
		}

		Boolean sentMeCopy = (Boolean)attributes.get("sentMeCopy");

		if (sentMeCopy != null) {
			setSentMeCopy(sentMeCopy);
		}

		Long belongToGroupDetailId = (Long)attributes.get(
				"belongToGroupDetailId");

		if (belongToGroupDetailId != null) {
			setBelongToGroupDetailId(belongToGroupDetailId);
		}
	}

	/**
	* Returns the primary key of this i b message.
	*
	* @return the primary key of this i b message
	*/
	@Override
	public long getPrimaryKey() {
		return _ibMessage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this i b message.
	*
	* @param primaryKey the primary key of this i b message
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ibMessage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this i b message.
	*
	* @return the uuid of this i b message
	*/
	@Override
	public java.lang.String getUuid() {
		return _ibMessage.getUuid();
	}

	/**
	* Sets the uuid of this i b message.
	*
	* @param uuid the uuid of this i b message
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_ibMessage.setUuid(uuid);
	}

	/**
	* Returns the message ID of this i b message.
	*
	* @return the message ID of this i b message
	*/
	@Override
	public long getMessageId() {
		return _ibMessage.getMessageId();
	}

	/**
	* Sets the message ID of this i b message.
	*
	* @param messageId the message ID of this i b message
	*/
	@Override
	public void setMessageId(long messageId) {
		_ibMessage.setMessageId(messageId);
	}

	/**
	* Returns the parent message ID of this i b message.
	*
	* @return the parent message ID of this i b message
	*/
	@Override
	public long getParentMessageId() {
		return _ibMessage.getParentMessageId();
	}

	/**
	* Sets the parent message ID of this i b message.
	*
	* @param parentMessageId the parent message ID of this i b message
	*/
	@Override
	public void setParentMessageId(long parentMessageId) {
		_ibMessage.setParentMessageId(parentMessageId);
	}

	/**
	* Returns the group ID of this i b message.
	*
	* @return the group ID of this i b message
	*/
	@Override
	public long getGroupId() {
		return _ibMessage.getGroupId();
	}

	/**
	* Sets the group ID of this i b message.
	*
	* @param groupId the group ID of this i b message
	*/
	@Override
	public void setGroupId(long groupId) {
		_ibMessage.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this i b message.
	*
	* @return the company ID of this i b message
	*/
	@Override
	public long getCompanyId() {
		return _ibMessage.getCompanyId();
	}

	/**
	* Sets the company ID of this i b message.
	*
	* @param companyId the company ID of this i b message
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ibMessage.setCompanyId(companyId);
	}

	/**
	* Returns the subject of this i b message.
	*
	* @return the subject of this i b message
	*/
	@Override
	public java.lang.String getSubject() {
		return _ibMessage.getSubject();
	}

	/**
	* Sets the subject of this i b message.
	*
	* @param subject the subject of this i b message
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_ibMessage.setSubject(subject);
	}

	/**
	* Returns the content of this i b message.
	*
	* @return the content of this i b message
	*/
	@Override
	public java.lang.String getContent() {
		return _ibMessage.getContent();
	}

	/**
	* Sets the content of this i b message.
	*
	* @param content the content of this i b message
	*/
	@Override
	public void setContent(java.lang.String content) {
		_ibMessage.setContent(content);
	}

	/**
	* Returns the from of this i b message.
	*
	* @return the from of this i b message
	*/
	@Override
	public java.lang.String getFrom() {
		return _ibMessage.getFrom();
	}

	/**
	* Sets the from of this i b message.
	*
	* @param from the from of this i b message
	*/
	@Override
	public void setFrom(java.lang.String from) {
		_ibMessage.setFrom(from);
	}

	/**
	* Returns the to of this i b message.
	*
	* @return the to of this i b message
	*/
	@Override
	public java.lang.String getTo() {
		return _ibMessage.getTo();
	}

	/**
	* Sets the to of this i b message.
	*
	* @param to the to of this i b message
	*/
	@Override
	public void setTo(java.lang.String to) {
		_ibMessage.setTo(to);
	}

	/**
	* Returns the allow open of this i b message.
	*
	* @return the allow open of this i b message
	*/
	@Override
	public boolean getAllowOpen() {
		return _ibMessage.getAllowOpen();
	}

	/**
	* Returns <code>true</code> if this i b message is allow open.
	*
	* @return <code>true</code> if this i b message is allow open; <code>false</code> otherwise
	*/
	@Override
	public boolean isAllowOpen() {
		return _ibMessage.isAllowOpen();
	}

	/**
	* Sets whether this i b message is allow open.
	*
	* @param allowOpen the allow open of this i b message
	*/
	@Override
	public void setAllowOpen(boolean allowOpen) {
		_ibMessage.setAllowOpen(allowOpen);
	}

	/**
	* Returns the send date of this i b message.
	*
	* @return the send date of this i b message
	*/
	@Override
	public java.util.Date getSendDate() {
		return _ibMessage.getSendDate();
	}

	/**
	* Sets the send date of this i b message.
	*
	* @param sendDate the send date of this i b message
	*/
	@Override
	public void setSendDate(java.util.Date sendDate) {
		_ibMessage.setSendDate(sendDate);
	}

	/**
	* Returns the create date of this i b message.
	*
	* @return the create date of this i b message
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _ibMessage.getCreateDate();
	}

	/**
	* Sets the create date of this i b message.
	*
	* @param createDate the create date of this i b message
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_ibMessage.setCreateDate(createDate);
	}

	/**
	* Returns the create by of this i b message.
	*
	* @return the create by of this i b message
	*/
	@Override
	public java.lang.String getCreateBy() {
		return _ibMessage.getCreateBy();
	}

	/**
	* Sets the create by of this i b message.
	*
	* @param createBy the create by of this i b message
	*/
	@Override
	public void setCreateBy(java.lang.String createBy) {
		_ibMessage.setCreateBy(createBy);
	}

	/**
	* Returns the create by user ID of this i b message.
	*
	* @return the create by user ID of this i b message
	*/
	@Override
	public java.lang.String getCreateByUserId() {
		return _ibMessage.getCreateByUserId();
	}

	/**
	* Sets the create by user ID of this i b message.
	*
	* @param createByUserId the create by user ID of this i b message
	*/
	@Override
	public void setCreateByUserId(java.lang.String createByUserId) {
		_ibMessage.setCreateByUserId(createByUserId);
	}

	/**
	* Returns the draft of this i b message.
	*
	* @return the draft of this i b message
	*/
	@Override
	public boolean getDraft() {
		return _ibMessage.getDraft();
	}

	/**
	* Returns <code>true</code> if this i b message is draft.
	*
	* @return <code>true</code> if this i b message is draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _ibMessage.isDraft();
	}

	/**
	* Sets whether this i b message is draft.
	*
	* @param draft the draft of this i b message
	*/
	@Override
	public void setDraft(boolean draft) {
		_ibMessage.setDraft(draft);
	}

	/**
	* Returns the delete status of this i b message.
	*
	* @return the delete status of this i b message
	*/
	@Override
	public boolean getDeleteStatus() {
		return _ibMessage.getDeleteStatus();
	}

	/**
	* Returns <code>true</code> if this i b message is delete status.
	*
	* @return <code>true</code> if this i b message is delete status; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleteStatus() {
		return _ibMessage.isDeleteStatus();
	}

	/**
	* Sets whether this i b message is delete status.
	*
	* @param deleteStatus the delete status of this i b message
	*/
	@Override
	public void setDeleteStatus(boolean deleteStatus) {
		_ibMessage.setDeleteStatus(deleteStatus);
	}

	/**
	* Returns the draft status of this i b message.
	*
	* @return the draft status of this i b message
	*/
	@Override
	public java.lang.String getDraftStatus() {
		return _ibMessage.getDraftStatus();
	}

	/**
	* Sets the draft status of this i b message.
	*
	* @param draftStatus the draft status of this i b message
	*/
	@Override
	public void setDraftStatus(java.lang.String draftStatus) {
		_ibMessage.setDraftStatus(draftStatus);
	}

	/**
	* Returns the sent me copy of this i b message.
	*
	* @return the sent me copy of this i b message
	*/
	@Override
	public boolean getSentMeCopy() {
		return _ibMessage.getSentMeCopy();
	}

	/**
	* Returns <code>true</code> if this i b message is sent me copy.
	*
	* @return <code>true</code> if this i b message is sent me copy; <code>false</code> otherwise
	*/
	@Override
	public boolean isSentMeCopy() {
		return _ibMessage.isSentMeCopy();
	}

	/**
	* Sets whether this i b message is sent me copy.
	*
	* @param sentMeCopy the sent me copy of this i b message
	*/
	@Override
	public void setSentMeCopy(boolean sentMeCopy) {
		_ibMessage.setSentMeCopy(sentMeCopy);
	}

	/**
	* Returns the belong to group detail ID of this i b message.
	*
	* @return the belong to group detail ID of this i b message
	*/
	@Override
	public long getBelongToGroupDetailId() {
		return _ibMessage.getBelongToGroupDetailId();
	}

	/**
	* Sets the belong to group detail ID of this i b message.
	*
	* @param belongToGroupDetailId the belong to group detail ID of this i b message
	*/
	@Override
	public void setBelongToGroupDetailId(long belongToGroupDetailId) {
		_ibMessage.setBelongToGroupDetailId(belongToGroupDetailId);
	}

	@Override
	public boolean isNew() {
		return _ibMessage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ibMessage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ibMessage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ibMessage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ibMessage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ibMessage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ibMessage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ibMessage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ibMessage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ibMessage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ibMessage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IBMessageWrapper((IBMessage)_ibMessage.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage) {
		return _ibMessage.compareTo(ibMessage);
	}

	@Override
	public int hashCode() {
		return _ibMessage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spinbox.model.IBMessage> toCacheModel() {
		return _ibMessage.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessage toEscapedModel() {
		return new IBMessageWrapper(_ibMessage.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessage toUnescapedModel() {
		return new IBMessageWrapper(_ibMessage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ibMessage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ibMessage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ibMessage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IBMessageWrapper)) {
			return false;
		}

		IBMessageWrapper ibMessageWrapper = (IBMessageWrapper)obj;

		if (Validator.equals(_ibMessage, ibMessageWrapper._ibMessage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public IBMessage getWrappedIBMessage() {
		return _ibMessage;
	}

	@Override
	public IBMessage getWrappedModel() {
		return _ibMessage;
	}

	@Override
	public void resetOriginalValues() {
		_ibMessage.resetOriginalValues();
	}

	private IBMessage _ibMessage;
}