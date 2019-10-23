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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Conversation}.
 * </p>
 *
 * @author aishwarya
 * @see Conversation
 * @generated
 */
public class ConversationWrapper implements Conversation,
	ModelWrapper<Conversation> {
	public ConversationWrapper(Conversation conversation) {
		_conversation = conversation;
	}

	@Override
	public Class<?> getModelClass() {
		return Conversation.class;
	}

	@Override
	public String getModelClassName() {
		return Conversation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spConversationId", getSpConversationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("entityClassName", getEntityClassName());
		attributes.put("entityId", getEntityId());
		attributes.put("sentByUserId", getSentByUserId());
		attributes.put("message", getMessage());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("associatedWith", getAssociatedWith());
		attributes.put("restricted", getRestricted());
		attributes.put("status", getStatus());
		attributes.put("parentConverstationId", getParentConverstationId());
		attributes.put("currentPlId", getCurrentPlId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spConversationId = (Long)attributes.get("spConversationId");

		if (spConversationId != null) {
			setSpConversationId(spConversationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long entityClassId = (Long)attributes.get("entityClassId");

		if (entityClassId != null) {
			setEntityClassId(entityClassId);
		}

		String entityClassName = (String)attributes.get("entityClassName");

		if (entityClassName != null) {
			setEntityClassName(entityClassName);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long sentByUserId = (Long)attributes.get("sentByUserId");

		if (sentByUserId != null) {
			setSentByUserId(sentByUserId);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String fileEntryId = (String)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long associatedWith = (Long)attributes.get("associatedWith");

		if (associatedWith != null) {
			setAssociatedWith(associatedWith);
		}

		Integer restricted = (Integer)attributes.get("restricted");

		if (restricted != null) {
			setRestricted(restricted);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long parentConverstationId = (Long)attributes.get(
				"parentConverstationId");

		if (parentConverstationId != null) {
			setParentConverstationId(parentConverstationId);
		}

		Long currentPlId = (Long)attributes.get("currentPlId");

		if (currentPlId != null) {
			setCurrentPlId(currentPlId);
		}
	}

	/**
	* Returns the primary key of this conversation.
	*
	* @return the primary key of this conversation
	*/
	@Override
	public long getPrimaryKey() {
		return _conversation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this conversation.
	*
	* @param primaryKey the primary key of this conversation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_conversation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this conversation.
	*
	* @return the uuid of this conversation
	*/
	@Override
	public java.lang.String getUuid() {
		return _conversation.getUuid();
	}

	/**
	* Sets the uuid of this conversation.
	*
	* @param uuid the uuid of this conversation
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_conversation.setUuid(uuid);
	}

	/**
	* Returns the sp conversation ID of this conversation.
	*
	* @return the sp conversation ID of this conversation
	*/
	@Override
	public long getSpConversationId() {
		return _conversation.getSpConversationId();
	}

	/**
	* Sets the sp conversation ID of this conversation.
	*
	* @param spConversationId the sp conversation ID of this conversation
	*/
	@Override
	public void setSpConversationId(long spConversationId) {
		_conversation.setSpConversationId(spConversationId);
	}

	/**
	* Returns the group ID of this conversation.
	*
	* @return the group ID of this conversation
	*/
	@Override
	public long getGroupId() {
		return _conversation.getGroupId();
	}

	/**
	* Sets the group ID of this conversation.
	*
	* @param groupId the group ID of this conversation
	*/
	@Override
	public void setGroupId(long groupId) {
		_conversation.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this conversation.
	*
	* @return the company ID of this conversation
	*/
	@Override
	public long getCompanyId() {
		return _conversation.getCompanyId();
	}

	/**
	* Sets the company ID of this conversation.
	*
	* @param companyId the company ID of this conversation
	*/
	@Override
	public void setCompanyId(long companyId) {
		_conversation.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this conversation.
	*
	* @return the user ID of this conversation
	*/
	@Override
	public long getUserId() {
		return _conversation.getUserId();
	}

	/**
	* Sets the user ID of this conversation.
	*
	* @param userId the user ID of this conversation
	*/
	@Override
	public void setUserId(long userId) {
		_conversation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this conversation.
	*
	* @return the user uuid of this conversation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversation.getUserUuid();
	}

	/**
	* Sets the user uuid of this conversation.
	*
	* @param userUuid the user uuid of this conversation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_conversation.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this conversation.
	*
	* @return the user name of this conversation
	*/
	@Override
	public java.lang.String getUserName() {
		return _conversation.getUserName();
	}

	/**
	* Sets the user name of this conversation.
	*
	* @param userName the user name of this conversation
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_conversation.setUserName(userName);
	}

	/**
	* Returns the create date of this conversation.
	*
	* @return the create date of this conversation
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _conversation.getCreateDate();
	}

	/**
	* Sets the create date of this conversation.
	*
	* @param createDate the create date of this conversation
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_conversation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this conversation.
	*
	* @return the modified date of this conversation
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _conversation.getModifiedDate();
	}

	/**
	* Sets the modified date of this conversation.
	*
	* @param modifiedDate the modified date of this conversation
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_conversation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the entity class ID of this conversation.
	*
	* @return the entity class ID of this conversation
	*/
	@Override
	public long getEntityClassId() {
		return _conversation.getEntityClassId();
	}

	/**
	* Sets the entity class ID of this conversation.
	*
	* @param entityClassId the entity class ID of this conversation
	*/
	@Override
	public void setEntityClassId(long entityClassId) {
		_conversation.setEntityClassId(entityClassId);
	}

	/**
	* Returns the entity class name of this conversation.
	*
	* @return the entity class name of this conversation
	*/
	@Override
	public java.lang.String getEntityClassName() {
		return _conversation.getEntityClassName();
	}

	/**
	* Sets the entity class name of this conversation.
	*
	* @param entityClassName the entity class name of this conversation
	*/
	@Override
	public void setEntityClassName(java.lang.String entityClassName) {
		_conversation.setEntityClassName(entityClassName);
	}

	/**
	* Returns the entity ID of this conversation.
	*
	* @return the entity ID of this conversation
	*/
	@Override
	public long getEntityId() {
		return _conversation.getEntityId();
	}

	/**
	* Sets the entity ID of this conversation.
	*
	* @param entityId the entity ID of this conversation
	*/
	@Override
	public void setEntityId(long entityId) {
		_conversation.setEntityId(entityId);
	}

	/**
	* Returns the sent by user ID of this conversation.
	*
	* @return the sent by user ID of this conversation
	*/
	@Override
	public long getSentByUserId() {
		return _conversation.getSentByUserId();
	}

	/**
	* Sets the sent by user ID of this conversation.
	*
	* @param sentByUserId the sent by user ID of this conversation
	*/
	@Override
	public void setSentByUserId(long sentByUserId) {
		_conversation.setSentByUserId(sentByUserId);
	}

	/**
	* Returns the sent by user uuid of this conversation.
	*
	* @return the sent by user uuid of this conversation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getSentByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversation.getSentByUserUuid();
	}

	/**
	* Sets the sent by user uuid of this conversation.
	*
	* @param sentByUserUuid the sent by user uuid of this conversation
	*/
	@Override
	public void setSentByUserUuid(java.lang.String sentByUserUuid) {
		_conversation.setSentByUserUuid(sentByUserUuid);
	}

	/**
	* Returns the message of this conversation.
	*
	* @return the message of this conversation
	*/
	@Override
	public java.lang.String getMessage() {
		return _conversation.getMessage();
	}

	/**
	* Sets the message of this conversation.
	*
	* @param message the message of this conversation
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_conversation.setMessage(message);
	}

	/**
	* Returns the file entry ID of this conversation.
	*
	* @return the file entry ID of this conversation
	*/
	@Override
	public java.lang.String getFileEntryId() {
		return _conversation.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this conversation.
	*
	* @param fileEntryId the file entry ID of this conversation
	*/
	@Override
	public void setFileEntryId(java.lang.String fileEntryId) {
		_conversation.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the associated with of this conversation.
	*
	* @return the associated with of this conversation
	*/
	@Override
	public long getAssociatedWith() {
		return _conversation.getAssociatedWith();
	}

	/**
	* Sets the associated with of this conversation.
	*
	* @param associatedWith the associated with of this conversation
	*/
	@Override
	public void setAssociatedWith(long associatedWith) {
		_conversation.setAssociatedWith(associatedWith);
	}

	/**
	* Returns the restricted of this conversation.
	*
	* @return the restricted of this conversation
	*/
	@Override
	public int getRestricted() {
		return _conversation.getRestricted();
	}

	/**
	* Sets the restricted of this conversation.
	*
	* @param restricted the restricted of this conversation
	*/
	@Override
	public void setRestricted(int restricted) {
		_conversation.setRestricted(restricted);
	}

	/**
	* Returns the status of this conversation.
	*
	* @return the status of this conversation
	*/
	@Override
	public int getStatus() {
		return _conversation.getStatus();
	}

	/**
	* Sets the status of this conversation.
	*
	* @param status the status of this conversation
	*/
	@Override
	public void setStatus(int status) {
		_conversation.setStatus(status);
	}

	/**
	* Returns the parent converstation ID of this conversation.
	*
	* @return the parent converstation ID of this conversation
	*/
	@Override
	public long getParentConverstationId() {
		return _conversation.getParentConverstationId();
	}

	/**
	* Sets the parent converstation ID of this conversation.
	*
	* @param parentConverstationId the parent converstation ID of this conversation
	*/
	@Override
	public void setParentConverstationId(long parentConverstationId) {
		_conversation.setParentConverstationId(parentConverstationId);
	}

	/**
	* Returns the current pl ID of this conversation.
	*
	* @return the current pl ID of this conversation
	*/
	@Override
	public long getCurrentPlId() {
		return _conversation.getCurrentPlId();
	}

	/**
	* Sets the current pl ID of this conversation.
	*
	* @param currentPlId the current pl ID of this conversation
	*/
	@Override
	public void setCurrentPlId(long currentPlId) {
		_conversation.setCurrentPlId(currentPlId);
	}

	@Override
	public boolean isNew() {
		return _conversation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_conversation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _conversation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_conversation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _conversation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _conversation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_conversation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _conversation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_conversation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_conversation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_conversation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConversationWrapper((Conversation)_conversation.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.Conversation conversation) {
		return _conversation.compareTo(conversation);
	}

	@Override
	public int hashCode() {
		return _conversation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Conversation> toCacheModel() {
		return _conversation.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Conversation toEscapedModel() {
		return new ConversationWrapper(_conversation.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Conversation toUnescapedModel() {
		return new ConversationWrapper(_conversation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _conversation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _conversation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_conversation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConversationWrapper)) {
			return false;
		}

		ConversationWrapper conversationWrapper = (ConversationWrapper)obj;

		if (Validator.equals(_conversation, conversationWrapper._conversation)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _conversation.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Conversation getWrappedConversation() {
		return _conversation;
	}

	@Override
	public Conversation getWrappedModel() {
		return _conversation;
	}

	@Override
	public void resetOriginalValues() {
		_conversation.resetOriginalValues();
	}

	private Conversation _conversation;
}