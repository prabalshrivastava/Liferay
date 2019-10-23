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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.mail.service.ClpSerializer;
import com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPMailBlackListClp extends BaseModelImpl<SPMailBlackList>
	implements SPMailBlackList {
	public SPMailBlackListClp() {
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
	public long getPrimaryKey() {
		return _spMailBlackListId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMailBlackListId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMailBlackListId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpMailBlackListId() {
		return _spMailBlackListId;
	}

	@Override
	public void setSpMailBlackListId(long spMailBlackListId) {
		_spMailBlackListId = spMailBlackListId;

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailBlackListId",
						long.class);

				method.invoke(_spMailBlackListRemoteModel, spMailBlackListId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpMailCampaignId() {
		return _spMailCampaignId;
	}

	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignId = spMailCampaignId;

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignId",
						long.class);

				method.invoke(_spMailBlackListRemoteModel, spMailCampaignId);
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

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spMailBlackListRemoteModel, userId);
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
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_spMailBlackListRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBounced() {
		return _bounced;
	}

	@Override
	public boolean isBounced() {
		return _bounced;
	}

	@Override
	public void setBounced(boolean bounced) {
		_bounced = bounced;

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setBounced", boolean.class);

				method.invoke(_spMailBlackListRemoteModel, bounced);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBounce_soft() {
		return _bounce_soft;
	}

	@Override
	public boolean isBounce_soft() {
		return _bounce_soft;
	}

	@Override
	public void setBounce_soft(boolean bounce_soft) {
		_bounce_soft = bounce_soft;

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setBounce_soft", boolean.class);

				method.invoke(_spMailBlackListRemoteModel, bounce_soft);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getComplain() {
		return _complain;
	}

	@Override
	public boolean isComplain() {
		return _complain;
	}

	@Override
	public void setComplain(boolean complain) {
		_complain = complain;

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setComplain", boolean.class);

				method.invoke(_spMailBlackListRemoteModel, complain);
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

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spMailBlackListRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessage() {
		return _message;
	}

	@Override
	public void setMessage(String message) {
		_message = message;

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setMessage", String.class);

				method.invoke(_spMailBlackListRemoteModel, message);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(String messageId) {
		_messageId = messageId;

		if (_spMailBlackListRemoteModel != null) {
			try {
				Class<?> clazz = _spMailBlackListRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageId", String.class);

				method.invoke(_spMailBlackListRemoteModel, messageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPMailBlackListRemoteModel() {
		return _spMailBlackListRemoteModel;
	}

	public void setSPMailBlackListRemoteModel(
		BaseModel<?> spMailBlackListRemoteModel) {
		_spMailBlackListRemoteModel = spMailBlackListRemoteModel;
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

		Class<?> remoteModelClass = _spMailBlackListRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spMailBlackListRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailBlackListLocalServiceUtil.addSPMailBlackList(this);
		}
		else {
			SPMailBlackListLocalServiceUtil.updateSPMailBlackList(this);
		}
	}

	@Override
	public SPMailBlackList toEscapedModel() {
		return (SPMailBlackList)ProxyUtil.newProxyInstance(SPMailBlackList.class.getClassLoader(),
			new Class[] { SPMailBlackList.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPMailBlackListClp clone = new SPMailBlackListClp();

		clone.setSpMailBlackListId(getSpMailBlackListId());
		clone.setSpMailCampaignId(getSpMailCampaignId());
		clone.setUserId(getUserId());
		clone.setEmailAddress(getEmailAddress());
		clone.setBounced(getBounced());
		clone.setBounce_soft(getBounce_soft());
		clone.setComplain(getComplain());
		clone.setCreateDate(getCreateDate());
		clone.setMessage(getMessage());
		clone.setMessageId(getMessageId());

		return clone;
	}

	@Override
	public int compareTo(SPMailBlackList spMailBlackList) {
		long primaryKey = spMailBlackList.getPrimaryKey();

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

		if (!(obj instanceof SPMailBlackListClp)) {
			return false;
		}

		SPMailBlackListClp spMailBlackList = (SPMailBlackListClp)obj;

		long primaryKey = spMailBlackList.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{spMailBlackListId=");
		sb.append(getSpMailBlackListId());
		sb.append(", spMailCampaignId=");
		sb.append(getSpMailCampaignId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", bounced=");
		sb.append(getBounced());
		sb.append(", bounce_soft=");
		sb.append(getBounce_soft());
		sb.append(", complain=");
		sb.append(getComplain());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.mail.model.SPMailBlackList");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMailBlackListId</column-name><column-value><![CDATA[");
		sb.append(getSpMailBlackListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailCampaignId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bounced</column-name><column-value><![CDATA[");
		sb.append(getBounced());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bounce_soft</column-name><column-value><![CDATA[");
		sb.append(getBounce_soft());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complain</column-name><column-value><![CDATA[");
		sb.append(getComplain());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spMailBlackListId;
	private long _spMailCampaignId;
	private long _userId;
	private String _userUuid;
	private String _emailAddress;
	private boolean _bounced;
	private boolean _bounce_soft;
	private boolean _complain;
	private Date _createDate;
	private String _message;
	private String _messageId;
	private BaseModel<?> _spMailBlackListRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}