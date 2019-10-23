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
import com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPMailUnsubscribeClp extends BaseModelImpl<SPMailUnsubscribe>
	implements SPMailUnsubscribe {
	public SPMailUnsubscribeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailUnsubscribe.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailUnsubscribe.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spMailUnsubscribeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMailUnsubscribeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMailUnsubscribeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailUnsubscribeId", getSpMailUnsubscribeId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("userId", getUserId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("unsubscribeDate", getUnsubscribeDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailUnsubscribeId = (Long)attributes.get("spMailUnsubscribeId");

		if (spMailUnsubscribeId != null) {
			setSpMailUnsubscribeId(spMailUnsubscribeId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Date unsubscribeDate = (Date)attributes.get("unsubscribeDate");

		if (unsubscribeDate != null) {
			setUnsubscribeDate(unsubscribeDate);
		}
	}

	@Override
	public long getSpMailUnsubscribeId() {
		return _spMailUnsubscribeId;
	}

	@Override
	public void setSpMailUnsubscribeId(long spMailUnsubscribeId) {
		_spMailUnsubscribeId = spMailUnsubscribeId;

		if (_spMailUnsubscribeRemoteModel != null) {
			try {
				Class<?> clazz = _spMailUnsubscribeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailUnsubscribeId",
						long.class);

				method.invoke(_spMailUnsubscribeRemoteModel, spMailUnsubscribeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_spMailUnsubscribeRemoteModel != null) {
			try {
				Class<?> clazz = _spMailUnsubscribeRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_spMailUnsubscribeRemoteModel, categoryId);
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

		if (_spMailUnsubscribeRemoteModel != null) {
			try {
				Class<?> clazz = _spMailUnsubscribeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spMailUnsubscribeRemoteModel, userId);
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

		if (_spMailUnsubscribeRemoteModel != null) {
			try {
				Class<?> clazz = _spMailUnsubscribeRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_spMailUnsubscribeRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUnsubscribeDate() {
		return _unsubscribeDate;
	}

	@Override
	public void setUnsubscribeDate(Date unsubscribeDate) {
		_unsubscribeDate = unsubscribeDate;

		if (_spMailUnsubscribeRemoteModel != null) {
			try {
				Class<?> clazz = _spMailUnsubscribeRemoteModel.getClass();

				Method method = clazz.getMethod("setUnsubscribeDate", Date.class);

				method.invoke(_spMailUnsubscribeRemoteModel, unsubscribeDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPMailUnsubscribeRemoteModel() {
		return _spMailUnsubscribeRemoteModel;
	}

	public void setSPMailUnsubscribeRemoteModel(
		BaseModel<?> spMailUnsubscribeRemoteModel) {
		_spMailUnsubscribeRemoteModel = spMailUnsubscribeRemoteModel;
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

		Class<?> remoteModelClass = _spMailUnsubscribeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spMailUnsubscribeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailUnsubscribeLocalServiceUtil.addSPMailUnsubscribe(this);
		}
		else {
			SPMailUnsubscribeLocalServiceUtil.updateSPMailUnsubscribe(this);
		}
	}

	@Override
	public SPMailUnsubscribe toEscapedModel() {
		return (SPMailUnsubscribe)ProxyUtil.newProxyInstance(SPMailUnsubscribe.class.getClassLoader(),
			new Class[] { SPMailUnsubscribe.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPMailUnsubscribeClp clone = new SPMailUnsubscribeClp();

		clone.setSpMailUnsubscribeId(getSpMailUnsubscribeId());
		clone.setCategoryId(getCategoryId());
		clone.setUserId(getUserId());
		clone.setEmailAddress(getEmailAddress());
		clone.setUnsubscribeDate(getUnsubscribeDate());

		return clone;
	}

	@Override
	public int compareTo(SPMailUnsubscribe spMailUnsubscribe) {
		long primaryKey = spMailUnsubscribe.getPrimaryKey();

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

		if (!(obj instanceof SPMailUnsubscribeClp)) {
			return false;
		}

		SPMailUnsubscribeClp spMailUnsubscribe = (SPMailUnsubscribeClp)obj;

		long primaryKey = spMailUnsubscribe.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{spMailUnsubscribeId=");
		sb.append(getSpMailUnsubscribeId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", unsubscribeDate=");
		sb.append(getUnsubscribeDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.mail.model.SPMailUnsubscribe");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMailUnsubscribeId</column-name><column-value><![CDATA[");
		sb.append(getSpMailUnsubscribeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
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
			"<column><column-name>unsubscribeDate</column-name><column-value><![CDATA[");
		sb.append(getUnsubscribeDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spMailUnsubscribeId;
	private long _categoryId;
	private long _userId;
	private String _userUuid;
	private String _emailAddress;
	private Date _unsubscribeDate;
	private BaseModel<?> _spMailUnsubscribeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}