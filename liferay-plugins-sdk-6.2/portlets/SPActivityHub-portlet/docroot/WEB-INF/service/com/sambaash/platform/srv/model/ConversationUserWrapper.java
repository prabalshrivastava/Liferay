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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ConversationUser}.
 * </p>
 *
 * @author aishwarya
 * @see ConversationUser
 * @generated
 */
public class ConversationUserWrapper implements ConversationUser,
	ModelWrapper<ConversationUser> {
	public ConversationUserWrapper(ConversationUser conversationUser) {
		_conversationUser = conversationUser;
	}

	@Override
	public Class<?> getModelClass() {
		return ConversationUser.class;
	}

	@Override
	public String getModelClassName() {
		return ConversationUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spConversationUserId", getSpConversationUserId());
		attributes.put("spConversationId", getSpConversationId());
		attributes.put("sentToUserId", getSentToUserId());
		attributes.put("status", getStatus());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("entityId", getEntityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spConversationUserId = (Long)attributes.get("spConversationUserId");

		if (spConversationUserId != null) {
			setSpConversationUserId(spConversationUserId);
		}

		Long spConversationId = (Long)attributes.get("spConversationId");

		if (spConversationId != null) {
			setSpConversationId(spConversationId);
		}

		Long sentToUserId = (Long)attributes.get("sentToUserId");

		if (sentToUserId != null) {
			setSentToUserId(sentToUserId);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long entityClassId = (Long)attributes.get("entityClassId");

		if (entityClassId != null) {
			setEntityClassId(entityClassId);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}
	}

	/**
	* Returns the primary key of this conversation user.
	*
	* @return the primary key of this conversation user
	*/
	@Override
	public long getPrimaryKey() {
		return _conversationUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this conversation user.
	*
	* @param primaryKey the primary key of this conversation user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_conversationUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp conversation user ID of this conversation user.
	*
	* @return the sp conversation user ID of this conversation user
	*/
	@Override
	public long getSpConversationUserId() {
		return _conversationUser.getSpConversationUserId();
	}

	/**
	* Sets the sp conversation user ID of this conversation user.
	*
	* @param spConversationUserId the sp conversation user ID of this conversation user
	*/
	@Override
	public void setSpConversationUserId(long spConversationUserId) {
		_conversationUser.setSpConversationUserId(spConversationUserId);
	}

	/**
	* Returns the sp conversation user uuid of this conversation user.
	*
	* @return the sp conversation user uuid of this conversation user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getSpConversationUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUser.getSpConversationUserUuid();
	}

	/**
	* Sets the sp conversation user uuid of this conversation user.
	*
	* @param spConversationUserUuid the sp conversation user uuid of this conversation user
	*/
	@Override
	public void setSpConversationUserUuid(
		java.lang.String spConversationUserUuid) {
		_conversationUser.setSpConversationUserUuid(spConversationUserUuid);
	}

	/**
	* Returns the sp conversation ID of this conversation user.
	*
	* @return the sp conversation ID of this conversation user
	*/
	@Override
	public long getSpConversationId() {
		return _conversationUser.getSpConversationId();
	}

	/**
	* Sets the sp conversation ID of this conversation user.
	*
	* @param spConversationId the sp conversation ID of this conversation user
	*/
	@Override
	public void setSpConversationId(long spConversationId) {
		_conversationUser.setSpConversationId(spConversationId);
	}

	/**
	* Returns the sent to user ID of this conversation user.
	*
	* @return the sent to user ID of this conversation user
	*/
	@Override
	public long getSentToUserId() {
		return _conversationUser.getSentToUserId();
	}

	/**
	* Sets the sent to user ID of this conversation user.
	*
	* @param sentToUserId the sent to user ID of this conversation user
	*/
	@Override
	public void setSentToUserId(long sentToUserId) {
		_conversationUser.setSentToUserId(sentToUserId);
	}

	/**
	* Returns the sent to user uuid of this conversation user.
	*
	* @return the sent to user uuid of this conversation user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getSentToUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _conversationUser.getSentToUserUuid();
	}

	/**
	* Sets the sent to user uuid of this conversation user.
	*
	* @param sentToUserUuid the sent to user uuid of this conversation user
	*/
	@Override
	public void setSentToUserUuid(java.lang.String sentToUserUuid) {
		_conversationUser.setSentToUserUuid(sentToUserUuid);
	}

	/**
	* Returns the status of this conversation user.
	*
	* @return the status of this conversation user
	*/
	@Override
	public long getStatus() {
		return _conversationUser.getStatus();
	}

	/**
	* Sets the status of this conversation user.
	*
	* @param status the status of this conversation user
	*/
	@Override
	public void setStatus(long status) {
		_conversationUser.setStatus(status);
	}

	/**
	* Returns the entity class ID of this conversation user.
	*
	* @return the entity class ID of this conversation user
	*/
	@Override
	public long getEntityClassId() {
		return _conversationUser.getEntityClassId();
	}

	/**
	* Sets the entity class ID of this conversation user.
	*
	* @param entityClassId the entity class ID of this conversation user
	*/
	@Override
	public void setEntityClassId(long entityClassId) {
		_conversationUser.setEntityClassId(entityClassId);
	}

	/**
	* Returns the entity ID of this conversation user.
	*
	* @return the entity ID of this conversation user
	*/
	@Override
	public long getEntityId() {
		return _conversationUser.getEntityId();
	}

	/**
	* Sets the entity ID of this conversation user.
	*
	* @param entityId the entity ID of this conversation user
	*/
	@Override
	public void setEntityId(long entityId) {
		_conversationUser.setEntityId(entityId);
	}

	@Override
	public boolean isNew() {
		return _conversationUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_conversationUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _conversationUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_conversationUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _conversationUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _conversationUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_conversationUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _conversationUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_conversationUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_conversationUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_conversationUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConversationUserWrapper((ConversationUser)_conversationUser.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.ConversationUser conversationUser) {
		return _conversationUser.compareTo(conversationUser);
	}

	@Override
	public int hashCode() {
		return _conversationUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.ConversationUser> toCacheModel() {
		return _conversationUser.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.ConversationUser toEscapedModel() {
		return new ConversationUserWrapper(_conversationUser.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.ConversationUser toUnescapedModel() {
		return new ConversationUserWrapper(_conversationUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _conversationUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _conversationUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_conversationUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConversationUserWrapper)) {
			return false;
		}

		ConversationUserWrapper conversationUserWrapper = (ConversationUserWrapper)obj;

		if (Validator.equals(_conversationUser,
					conversationUserWrapper._conversationUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ConversationUser getWrappedConversationUser() {
		return _conversationUser;
	}

	@Override
	public ConversationUser getWrappedModel() {
		return _conversationUser;
	}

	@Override
	public void resetOriginalValues() {
		_conversationUser.resetOriginalValues();
	}

	private ConversationUser _conversationUser;
}