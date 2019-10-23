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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.service.ClpSerializer;
import com.sambaash.platform.srv.service.ConversationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aishwarya
 */
public class ConversationClp extends BaseModelImpl<Conversation>
	implements Conversation {
	public ConversationClp() {
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
	public long getPrimaryKey() {
		return _spConversationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpConversationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spConversationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_conversationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpConversationId() {
		return _spConversationId;
	}

	@Override
	public void setSpConversationId(long spConversationId) {
		_spConversationId = spConversationId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpConversationId",
						long.class);

				method.invoke(_conversationRemoteModel, spConversationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_conversationRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_conversationRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_conversationRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_conversationRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_conversationRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_conversationRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityClassId() {
		return _entityClassId;
	}

	@Override
	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassId", long.class);

				method.invoke(_conversationRemoteModel, entityClassId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntityClassName() {
		return _entityClassName;
	}

	@Override
	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassName",
						String.class);

				method.invoke(_conversationRemoteModel, entityClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		_entityId = entityId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityId", long.class);

				method.invoke(_conversationRemoteModel, entityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSentByUserId() {
		return _sentByUserId;
	}

	@Override
	public void setSentByUserId(long sentByUserId) {
		_sentByUserId = sentByUserId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setSentByUserId", long.class);

				method.invoke(_conversationRemoteModel, sentByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSentByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSentByUserId(), "uuid",
			_sentByUserUuid);
	}

	@Override
	public void setSentByUserUuid(String sentByUserUuid) {
		_sentByUserUuid = sentByUserUuid;
	}

	@Override
	public String getMessage() {
		return _message;
	}

	@Override
	public void setMessage(String message) {
		_message = message;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setMessage", String.class);

				method.invoke(_conversationRemoteModel, message);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(String fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", String.class);

				method.invoke(_conversationRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssociatedWith() {
		return _associatedWith;
	}

	@Override
	public void setAssociatedWith(long associatedWith) {
		_associatedWith = associatedWith;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setAssociatedWith", long.class);

				method.invoke(_conversationRemoteModel, associatedWith);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRestricted() {
		return _restricted;
	}

	@Override
	public void setRestricted(int restricted) {
		_restricted = restricted;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setRestricted", int.class);

				method.invoke(_conversationRemoteModel, restricted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_conversationRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentConverstationId() {
		return _parentConverstationId;
	}

	@Override
	public void setParentConverstationId(long parentConverstationId) {
		_parentConverstationId = parentConverstationId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setParentConverstationId",
						long.class);

				method.invoke(_conversationRemoteModel, parentConverstationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCurrentPlId() {
		return _currentPlId;
	}

	@Override
	public void setCurrentPlId(long currentPlId) {
		_currentPlId = currentPlId;

		if (_conversationRemoteModel != null) {
			try {
				Class<?> clazz = _conversationRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentPlId", long.class);

				method.invoke(_conversationRemoteModel, currentPlId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Conversation.class.getName()));
	}

	public BaseModel<?> getConversationRemoteModel() {
		return _conversationRemoteModel;
	}

	public void setConversationRemoteModel(BaseModel<?> conversationRemoteModel) {
		_conversationRemoteModel = conversationRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _conversationRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_conversationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ConversationLocalServiceUtil.addConversation(this);
		}
		else {
			ConversationLocalServiceUtil.updateConversation(this);
		}
	}

	@Override
	public Conversation toEscapedModel() {
		return (Conversation)ProxyUtil.newProxyInstance(Conversation.class.getClassLoader(),
			new Class[] { Conversation.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ConversationClp clone = new ConversationClp();

		clone.setUuid(getUuid());
		clone.setSpConversationId(getSpConversationId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEntityClassId(getEntityClassId());
		clone.setEntityClassName(getEntityClassName());
		clone.setEntityId(getEntityId());
		clone.setSentByUserId(getSentByUserId());
		clone.setMessage(getMessage());
		clone.setFileEntryId(getFileEntryId());
		clone.setAssociatedWith(getAssociatedWith());
		clone.setRestricted(getRestricted());
		clone.setStatus(getStatus());
		clone.setParentConverstationId(getParentConverstationId());
		clone.setCurrentPlId(getCurrentPlId());

		return clone;
	}

	@Override
	public int compareTo(Conversation conversation) {
		long primaryKey = conversation.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConversationClp)) {
			return false;
		}

		ConversationClp conversation = (ConversationClp)obj;

		long primaryKey = conversation.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spConversationId=");
		sb.append(getSpConversationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", entityClassId=");
		sb.append(getEntityClassId());
		sb.append(", entityClassName=");
		sb.append(getEntityClassName());
		sb.append(", entityId=");
		sb.append(getEntityId());
		sb.append(", sentByUserId=");
		sb.append(getSentByUserId());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", associatedWith=");
		sb.append(getAssociatedWith());
		sb.append(", restricted=");
		sb.append(getRestricted());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", parentConverstationId=");
		sb.append(getParentConverstationId());
		sb.append(", currentPlId=");
		sb.append(getCurrentPlId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Conversation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spConversationId</column-name><column-value><![CDATA[");
		sb.append(getSpConversationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassId</column-name><column-value><![CDATA[");
		sb.append(getEntityClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassName</column-name><column-value><![CDATA[");
		sb.append(getEntityClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentByUserId</column-name><column-value><![CDATA[");
		sb.append(getSentByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>associatedWith</column-name><column-value><![CDATA[");
		sb.append(getAssociatedWith());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>restricted</column-name><column-value><![CDATA[");
		sb.append(getRestricted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentConverstationId</column-name><column-value><![CDATA[");
		sb.append(getParentConverstationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentPlId</column-name><column-value><![CDATA[");
		sb.append(getCurrentPlId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spConversationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _entityClassId;
	private String _entityClassName;
	private long _entityId;
	private long _sentByUserId;
	private String _sentByUserUuid;
	private String _message;
	private String _fileEntryId;
	private long _associatedWith;
	private int _restricted;
	private int _status;
	private long _parentConverstationId;
	private long _currentPlId;
	private BaseModel<?> _conversationRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}