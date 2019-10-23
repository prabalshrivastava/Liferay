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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.service.ClpSerializer;
import com.sambaash.platform.srv.service.ConversationUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aishwarya
 */
public class ConversationUserClp extends BaseModelImpl<ConversationUser>
	implements ConversationUser {
	public ConversationUserClp() {
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
	public long getPrimaryKey() {
		return _spConversationUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpConversationUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spConversationUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpConversationUserId() {
		return _spConversationUserId;
	}

	@Override
	public void setSpConversationUserId(long spConversationUserId) {
		_spConversationUserId = spConversationUserId;

		if (_conversationUserRemoteModel != null) {
			try {
				Class<?> clazz = _conversationUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSpConversationUserId",
						long.class);

				method.invoke(_conversationUserRemoteModel, spConversationUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpConversationUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSpConversationUserId(), "uuid",
			_spConversationUserUuid);
	}

	@Override
	public void setSpConversationUserUuid(String spConversationUserUuid) {
		_spConversationUserUuid = spConversationUserUuid;
	}

	@Override
	public long getSpConversationId() {
		return _spConversationId;
	}

	@Override
	public void setSpConversationId(long spConversationId) {
		_spConversationId = spConversationId;

		if (_conversationUserRemoteModel != null) {
			try {
				Class<?> clazz = _conversationUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSpConversationId",
						long.class);

				method.invoke(_conversationUserRemoteModel, spConversationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSentToUserId() {
		return _sentToUserId;
	}

	@Override
	public void setSentToUserId(long sentToUserId) {
		_sentToUserId = sentToUserId;

		if (_conversationUserRemoteModel != null) {
			try {
				Class<?> clazz = _conversationUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSentToUserId", long.class);

				method.invoke(_conversationUserRemoteModel, sentToUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSentToUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSentToUserId(), "uuid",
			_sentToUserUuid);
	}

	@Override
	public void setSentToUserUuid(String sentToUserUuid) {
		_sentToUserUuid = sentToUserUuid;
	}

	@Override
	public long getStatus() {
		return _status;
	}

	@Override
	public void setStatus(long status) {
		_status = status;

		if (_conversationUserRemoteModel != null) {
			try {
				Class<?> clazz = _conversationUserRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", long.class);

				method.invoke(_conversationUserRemoteModel, status);
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

		if (_conversationUserRemoteModel != null) {
			try {
				Class<?> clazz = _conversationUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassId", long.class);

				method.invoke(_conversationUserRemoteModel, entityClassId);
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

		if (_conversationUserRemoteModel != null) {
			try {
				Class<?> clazz = _conversationUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityId", long.class);

				method.invoke(_conversationUserRemoteModel, entityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getConversationUserRemoteModel() {
		return _conversationUserRemoteModel;
	}

	public void setConversationUserRemoteModel(
		BaseModel<?> conversationUserRemoteModel) {
		_conversationUserRemoteModel = conversationUserRemoteModel;
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

		Class<?> remoteModelClass = _conversationUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_conversationUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ConversationUserLocalServiceUtil.addConversationUser(this);
		}
		else {
			ConversationUserLocalServiceUtil.updateConversationUser(this);
		}
	}

	@Override
	public ConversationUser toEscapedModel() {
		return (ConversationUser)ProxyUtil.newProxyInstance(ConversationUser.class.getClassLoader(),
			new Class[] { ConversationUser.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ConversationUserClp clone = new ConversationUserClp();

		clone.setSpConversationUserId(getSpConversationUserId());
		clone.setSpConversationId(getSpConversationId());
		clone.setSentToUserId(getSentToUserId());
		clone.setStatus(getStatus());
		clone.setEntityClassId(getEntityClassId());
		clone.setEntityId(getEntityId());

		return clone;
	}

	@Override
	public int compareTo(ConversationUser conversationUser) {
		long primaryKey = conversationUser.getPrimaryKey();

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

		if (!(obj instanceof ConversationUserClp)) {
			return false;
		}

		ConversationUserClp conversationUser = (ConversationUserClp)obj;

		long primaryKey = conversationUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{spConversationUserId=");
		sb.append(getSpConversationUserId());
		sb.append(", spConversationId=");
		sb.append(getSpConversationId());
		sb.append(", sentToUserId=");
		sb.append(getSentToUserId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", entityClassId=");
		sb.append(getEntityClassId());
		sb.append(", entityId=");
		sb.append(getEntityId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.ConversationUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spConversationUserId</column-name><column-value><![CDATA[");
		sb.append(getSpConversationUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spConversationId</column-name><column-value><![CDATA[");
		sb.append(getSpConversationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentToUserId</column-name><column-value><![CDATA[");
		sb.append(getSentToUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassId</column-name><column-value><![CDATA[");
		sb.append(getEntityClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spConversationUserId;
	private String _spConversationUserUuid;
	private long _spConversationId;
	private long _sentToUserId;
	private String _sentToUserUuid;
	private long _status;
	private long _entityClassId;
	private long _entityId;
	private BaseModel<?> _conversationUserRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}