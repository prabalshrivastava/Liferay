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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the IBMessage service. Represents a row in the &quot;SPInboxMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessage
 * @see com.sambaash.platform.srv.spinbox.model.impl.IBMessageImpl
 * @see com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl
 * @generated
 */
public interface IBMessageModel extends BaseModel<IBMessage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a i b message model instance should use the {@link IBMessage} interface instead.
	 */

	/**
	 * Returns the primary key of this i b message.
	 *
	 * @return the primary key of this i b message
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this i b message.
	 *
	 * @param primaryKey the primary key of this i b message
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this i b message.
	 *
	 * @return the uuid of this i b message
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this i b message.
	 *
	 * @param uuid the uuid of this i b message
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the message ID of this i b message.
	 *
	 * @return the message ID of this i b message
	 */
	public long getMessageId();

	/**
	 * Sets the message ID of this i b message.
	 *
	 * @param messageId the message ID of this i b message
	 */
	public void setMessageId(long messageId);

	/**
	 * Returns the parent message ID of this i b message.
	 *
	 * @return the parent message ID of this i b message
	 */
	public long getParentMessageId();

	/**
	 * Sets the parent message ID of this i b message.
	 *
	 * @param parentMessageId the parent message ID of this i b message
	 */
	public void setParentMessageId(long parentMessageId);

	/**
	 * Returns the group ID of this i b message.
	 *
	 * @return the group ID of this i b message
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this i b message.
	 *
	 * @param groupId the group ID of this i b message
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this i b message.
	 *
	 * @return the company ID of this i b message
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this i b message.
	 *
	 * @param companyId the company ID of this i b message
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the subject of this i b message.
	 *
	 * @return the subject of this i b message
	 */
	@AutoEscape
	public String getSubject();

	/**
	 * Sets the subject of this i b message.
	 *
	 * @param subject the subject of this i b message
	 */
	public void setSubject(String subject);

	/**
	 * Returns the content of this i b message.
	 *
	 * @return the content of this i b message
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this i b message.
	 *
	 * @param content the content of this i b message
	 */
	public void setContent(String content);

	/**
	 * Returns the from of this i b message.
	 *
	 * @return the from of this i b message
	 */
	@AutoEscape
	public String getFrom();

	/**
	 * Sets the from of this i b message.
	 *
	 * @param from the from of this i b message
	 */
	public void setFrom(String from);

	/**
	 * Returns the to of this i b message.
	 *
	 * @return the to of this i b message
	 */
	@AutoEscape
	public String getTo();

	/**
	 * Sets the to of this i b message.
	 *
	 * @param to the to of this i b message
	 */
	public void setTo(String to);

	/**
	 * Returns the allow open of this i b message.
	 *
	 * @return the allow open of this i b message
	 */
	public boolean getAllowOpen();

	/**
	 * Returns <code>true</code> if this i b message is allow open.
	 *
	 * @return <code>true</code> if this i b message is allow open; <code>false</code> otherwise
	 */
	public boolean isAllowOpen();

	/**
	 * Sets whether this i b message is allow open.
	 *
	 * @param allowOpen the allow open of this i b message
	 */
	public void setAllowOpen(boolean allowOpen);

	/**
	 * Returns the send date of this i b message.
	 *
	 * @return the send date of this i b message
	 */
	public Date getSendDate();

	/**
	 * Sets the send date of this i b message.
	 *
	 * @param sendDate the send date of this i b message
	 */
	public void setSendDate(Date sendDate);

	/**
	 * Returns the create date of this i b message.
	 *
	 * @return the create date of this i b message
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this i b message.
	 *
	 * @param createDate the create date of this i b message
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the create by of this i b message.
	 *
	 * @return the create by of this i b message
	 */
	@AutoEscape
	public String getCreateBy();

	/**
	 * Sets the create by of this i b message.
	 *
	 * @param createBy the create by of this i b message
	 */
	public void setCreateBy(String createBy);

	/**
	 * Returns the create by user ID of this i b message.
	 *
	 * @return the create by user ID of this i b message
	 */
	@AutoEscape
	public String getCreateByUserId();

	/**
	 * Sets the create by user ID of this i b message.
	 *
	 * @param createByUserId the create by user ID of this i b message
	 */
	public void setCreateByUserId(String createByUserId);

	/**
	 * Returns the draft of this i b message.
	 *
	 * @return the draft of this i b message
	 */
	public boolean getDraft();

	/**
	 * Returns <code>true</code> if this i b message is draft.
	 *
	 * @return <code>true</code> if this i b message is draft; <code>false</code> otherwise
	 */
	public boolean isDraft();

	/**
	 * Sets whether this i b message is draft.
	 *
	 * @param draft the draft of this i b message
	 */
	public void setDraft(boolean draft);

	/**
	 * Returns the delete status of this i b message.
	 *
	 * @return the delete status of this i b message
	 */
	public boolean getDeleteStatus();

	/**
	 * Returns <code>true</code> if this i b message is delete status.
	 *
	 * @return <code>true</code> if this i b message is delete status; <code>false</code> otherwise
	 */
	public boolean isDeleteStatus();

	/**
	 * Sets whether this i b message is delete status.
	 *
	 * @param deleteStatus the delete status of this i b message
	 */
	public void setDeleteStatus(boolean deleteStatus);

	/**
	 * Returns the draft status of this i b message.
	 *
	 * @return the draft status of this i b message
	 */
	@AutoEscape
	public String getDraftStatus();

	/**
	 * Sets the draft status of this i b message.
	 *
	 * @param draftStatus the draft status of this i b message
	 */
	public void setDraftStatus(String draftStatus);

	/**
	 * Returns the sent me copy of this i b message.
	 *
	 * @return the sent me copy of this i b message
	 */
	public boolean getSentMeCopy();

	/**
	 * Returns <code>true</code> if this i b message is sent me copy.
	 *
	 * @return <code>true</code> if this i b message is sent me copy; <code>false</code> otherwise
	 */
	public boolean isSentMeCopy();

	/**
	 * Sets whether this i b message is sent me copy.
	 *
	 * @param sentMeCopy the sent me copy of this i b message
	 */
	public void setSentMeCopy(boolean sentMeCopy);

	/**
	 * Returns the belong to group detail ID of this i b message.
	 *
	 * @return the belong to group detail ID of this i b message
	 */
	public long getBelongToGroupDetailId();

	/**
	 * Sets the belong to group detail ID of this i b message.
	 *
	 * @param belongToGroupDetailId the belong to group detail ID of this i b message
	 */
	public void setBelongToGroupDetailId(long belongToGroupDetailId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spinbox.model.IBMessage> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessage toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spinbox.model.IBMessage toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}