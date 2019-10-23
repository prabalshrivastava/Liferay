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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Conversation service. Represents a row in the &quot;SPConversation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.ConversationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.ConversationImpl}.
 * </p>
 *
 * @author aishwarya
 * @see Conversation
 * @see com.sambaash.platform.srv.model.impl.ConversationImpl
 * @see com.sambaash.platform.srv.model.impl.ConversationModelImpl
 * @generated
 */
public interface ConversationModel extends BaseModel<Conversation>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a conversation model instance should use the {@link Conversation} interface instead.
	 */

	/**
	 * Returns the primary key of this conversation.
	 *
	 * @return the primary key of this conversation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this conversation.
	 *
	 * @param primaryKey the primary key of this conversation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this conversation.
	 *
	 * @return the uuid of this conversation
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this conversation.
	 *
	 * @param uuid the uuid of this conversation
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sp conversation ID of this conversation.
	 *
	 * @return the sp conversation ID of this conversation
	 */
	public long getSpConversationId();

	/**
	 * Sets the sp conversation ID of this conversation.
	 *
	 * @param spConversationId the sp conversation ID of this conversation
	 */
	public void setSpConversationId(long spConversationId);

	/**
	 * Returns the group ID of this conversation.
	 *
	 * @return the group ID of this conversation
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this conversation.
	 *
	 * @param groupId the group ID of this conversation
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this conversation.
	 *
	 * @return the company ID of this conversation
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this conversation.
	 *
	 * @param companyId the company ID of this conversation
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this conversation.
	 *
	 * @return the user ID of this conversation
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this conversation.
	 *
	 * @param userId the user ID of this conversation
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this conversation.
	 *
	 * @return the user uuid of this conversation
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this conversation.
	 *
	 * @param userUuid the user uuid of this conversation
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this conversation.
	 *
	 * @return the user name of this conversation
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this conversation.
	 *
	 * @param userName the user name of this conversation
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this conversation.
	 *
	 * @return the create date of this conversation
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this conversation.
	 *
	 * @param createDate the create date of this conversation
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this conversation.
	 *
	 * @return the modified date of this conversation
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this conversation.
	 *
	 * @param modifiedDate the modified date of this conversation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the entity class ID of this conversation.
	 *
	 * @return the entity class ID of this conversation
	 */
	public long getEntityClassId();

	/**
	 * Sets the entity class ID of this conversation.
	 *
	 * @param entityClassId the entity class ID of this conversation
	 */
	public void setEntityClassId(long entityClassId);

	/**
	 * Returns the entity class name of this conversation.
	 *
	 * @return the entity class name of this conversation
	 */
	@AutoEscape
	public String getEntityClassName();

	/**
	 * Sets the entity class name of this conversation.
	 *
	 * @param entityClassName the entity class name of this conversation
	 */
	public void setEntityClassName(String entityClassName);

	/**
	 * Returns the entity ID of this conversation.
	 *
	 * @return the entity ID of this conversation
	 */
	public long getEntityId();

	/**
	 * Sets the entity ID of this conversation.
	 *
	 * @param entityId the entity ID of this conversation
	 */
	public void setEntityId(long entityId);

	/**
	 * Returns the sent by user ID of this conversation.
	 *
	 * @return the sent by user ID of this conversation
	 */
	public long getSentByUserId();

	/**
	 * Sets the sent by user ID of this conversation.
	 *
	 * @param sentByUserId the sent by user ID of this conversation
	 */
	public void setSentByUserId(long sentByUserId);

	/**
	 * Returns the sent by user uuid of this conversation.
	 *
	 * @return the sent by user uuid of this conversation
	 * @throws SystemException if a system exception occurred
	 */
	public String getSentByUserUuid() throws SystemException;

	/**
	 * Sets the sent by user uuid of this conversation.
	 *
	 * @param sentByUserUuid the sent by user uuid of this conversation
	 */
	public void setSentByUserUuid(String sentByUserUuid);

	/**
	 * Returns the message of this conversation.
	 *
	 * @return the message of this conversation
	 */
	@AutoEscape
	public String getMessage();

	/**
	 * Sets the message of this conversation.
	 *
	 * @param message the message of this conversation
	 */
	public void setMessage(String message);

	/**
	 * Returns the file entry ID of this conversation.
	 *
	 * @return the file entry ID of this conversation
	 */
	@AutoEscape
	public String getFileEntryId();

	/**
	 * Sets the file entry ID of this conversation.
	 *
	 * @param fileEntryId the file entry ID of this conversation
	 */
	public void setFileEntryId(String fileEntryId);

	/**
	 * Returns the associated with of this conversation.
	 *
	 * @return the associated with of this conversation
	 */
	public long getAssociatedWith();

	/**
	 * Sets the associated with of this conversation.
	 *
	 * @param associatedWith the associated with of this conversation
	 */
	public void setAssociatedWith(long associatedWith);

	/**
	 * Returns the restricted of this conversation.
	 *
	 * @return the restricted of this conversation
	 */
	public int getRestricted();

	/**
	 * Sets the restricted of this conversation.
	 *
	 * @param restricted the restricted of this conversation
	 */
	public void setRestricted(int restricted);

	/**
	 * Returns the status of this conversation.
	 *
	 * @return the status of this conversation
	 */
	public int getStatus();

	/**
	 * Sets the status of this conversation.
	 *
	 * @param status the status of this conversation
	 */
	public void setStatus(int status);

	/**
	 * Returns the parent converstation ID of this conversation.
	 *
	 * @return the parent converstation ID of this conversation
	 */
	public long getParentConverstationId();

	/**
	 * Sets the parent converstation ID of this conversation.
	 *
	 * @param parentConverstationId the parent converstation ID of this conversation
	 */
	public void setParentConverstationId(long parentConverstationId);

	/**
	 * Returns the current pl ID of this conversation.
	 *
	 * @return the current pl ID of this conversation
	 */
	public long getCurrentPlId();

	/**
	 * Sets the current pl ID of this conversation.
	 *
	 * @param currentPlId the current pl ID of this conversation
	 */
	public void setCurrentPlId(long currentPlId);

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
		com.sambaash.platform.srv.model.Conversation conversation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.Conversation> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.Conversation toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.Conversation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}