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

import com.sambaash.platform.srv.mail.service.ClpSerializer;
import com.sambaash.platform.srv.mail.service.SPMailSubscriberUserAgentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPMailSubscriberUserAgentClp extends BaseModelImpl<SPMailSubscriberUserAgent>
	implements SPMailSubscriberUserAgent {
	public SPMailSubscriberUserAgentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailSubscriberUserAgent.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailSubscriberUserAgent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spMailSubscriberUserAgentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMailSubscriberUserAgentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMailSubscriberUserAgentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailSubscriberUserAgentId",
			getSpMailSubscriberUserAgentId());
		attributes.put("spMailCampaignSubscribersId",
			getSpMailCampaignSubscribersId());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("typeName", getTypeName());
		attributes.put("deviceCategory", getDeviceCategory());
		attributes.put("family", getFamily());
		attributes.put("operatingSystem", getOperatingSystem());
		attributes.put("versionNumber", getVersionNumber());
		attributes.put("userAgent", getUserAgent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailSubscriberUserAgentId = (Long)attributes.get(
				"spMailSubscriberUserAgentId");

		if (spMailSubscriberUserAgentId != null) {
			setSpMailSubscriberUserAgentId(spMailSubscriberUserAgentId);
		}

		Long spMailCampaignSubscribersId = (Long)attributes.get(
				"spMailCampaignSubscribersId");

		if (spMailCampaignSubscribersId != null) {
			setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String typeName = (String)attributes.get("typeName");

		if (typeName != null) {
			setTypeName(typeName);
		}

		String deviceCategory = (String)attributes.get("deviceCategory");

		if (deviceCategory != null) {
			setDeviceCategory(deviceCategory);
		}

		String family = (String)attributes.get("family");

		if (family != null) {
			setFamily(family);
		}

		String operatingSystem = (String)attributes.get("operatingSystem");

		if (operatingSystem != null) {
			setOperatingSystem(operatingSystem);
		}

		String versionNumber = (String)attributes.get("versionNumber");

		if (versionNumber != null) {
			setVersionNumber(versionNumber);
		}

		String userAgent = (String)attributes.get("userAgent");

		if (userAgent != null) {
			setUserAgent(userAgent);
		}
	}

	@Override
	public long getSpMailSubscriberUserAgentId() {
		return _spMailSubscriberUserAgentId;
	}

	@Override
	public void setSpMailSubscriberUserAgentId(long spMailSubscriberUserAgentId) {
		_spMailSubscriberUserAgentId = spMailSubscriberUserAgentId;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailSubscriberUserAgentId",
						long.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel,
					spMailSubscriberUserAgentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpMailCampaignSubscribersId() {
		return _spMailCampaignSubscribersId;
	}

	@Override
	public void setSpMailCampaignSubscribersId(long spMailCampaignSubscribersId) {
		_spMailCampaignSubscribersId = spMailCampaignSubscribersId;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignSubscribersId",
						long.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel,
					spMailCampaignSubscribersId);
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

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignId",
						long.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel,
					spMailCampaignId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTypeName() {
		return _typeName;
	}

	@Override
	public void setTypeName(String typeName) {
		_typeName = typeName;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeName", String.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel, typeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeviceCategory() {
		return _deviceCategory;
	}

	@Override
	public void setDeviceCategory(String deviceCategory) {
		_deviceCategory = deviceCategory;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceCategory",
						String.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel,
					deviceCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFamily() {
		return _family;
	}

	@Override
	public void setFamily(String family) {
		_family = family;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setFamily", String.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel, family);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOperatingSystem() {
		return _operatingSystem;
	}

	@Override
	public void setOperatingSystem(String operatingSystem) {
		_operatingSystem = operatingSystem;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setOperatingSystem",
						String.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel,
					operatingSystem);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersionNumber() {
		return _versionNumber;
	}

	@Override
	public void setVersionNumber(String versionNumber) {
		_versionNumber = versionNumber;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setVersionNumber", String.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel,
					versionNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserAgent() {
		return _userAgent;
	}

	@Override
	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;

		if (_spMailSubscriberUserAgentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailSubscriberUserAgentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserAgent", String.class);

				method.invoke(_spMailSubscriberUserAgentRemoteModel, userAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPMailSubscriberUserAgentRemoteModel() {
		return _spMailSubscriberUserAgentRemoteModel;
	}

	public void setSPMailSubscriberUserAgentRemoteModel(
		BaseModel<?> spMailSubscriberUserAgentRemoteModel) {
		_spMailSubscriberUserAgentRemoteModel = spMailSubscriberUserAgentRemoteModel;
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

		Class<?> remoteModelClass = _spMailSubscriberUserAgentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spMailSubscriberUserAgentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailSubscriberUserAgentLocalServiceUtil.addSPMailSubscriberUserAgent(this);
		}
		else {
			SPMailSubscriberUserAgentLocalServiceUtil.updateSPMailSubscriberUserAgent(this);
		}
	}

	@Override
	public SPMailSubscriberUserAgent toEscapedModel() {
		return (SPMailSubscriberUserAgent)ProxyUtil.newProxyInstance(SPMailSubscriberUserAgent.class.getClassLoader(),
			new Class[] { SPMailSubscriberUserAgent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPMailSubscriberUserAgentClp clone = new SPMailSubscriberUserAgentClp();

		clone.setSpMailSubscriberUserAgentId(getSpMailSubscriberUserAgentId());
		clone.setSpMailCampaignSubscribersId(getSpMailCampaignSubscribersId());
		clone.setSpMailCampaignId(getSpMailCampaignId());
		clone.setName(getName());
		clone.setType(getType());
		clone.setTypeName(getTypeName());
		clone.setDeviceCategory(getDeviceCategory());
		clone.setFamily(getFamily());
		clone.setOperatingSystem(getOperatingSystem());
		clone.setVersionNumber(getVersionNumber());
		clone.setUserAgent(getUserAgent());

		return clone;
	}

	@Override
	public int compareTo(SPMailSubscriberUserAgent spMailSubscriberUserAgent) {
		long primaryKey = spMailSubscriberUserAgent.getPrimaryKey();

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

		if (!(obj instanceof SPMailSubscriberUserAgentClp)) {
			return false;
		}

		SPMailSubscriberUserAgentClp spMailSubscriberUserAgent = (SPMailSubscriberUserAgentClp)obj;

		long primaryKey = spMailSubscriberUserAgent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{spMailSubscriberUserAgentId=");
		sb.append(getSpMailSubscriberUserAgentId());
		sb.append(", spMailCampaignSubscribersId=");
		sb.append(getSpMailCampaignSubscribersId());
		sb.append(", spMailCampaignId=");
		sb.append(getSpMailCampaignId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", typeName=");
		sb.append(getTypeName());
		sb.append(", deviceCategory=");
		sb.append(getDeviceCategory());
		sb.append(", family=");
		sb.append(getFamily());
		sb.append(", operatingSystem=");
		sb.append(getOperatingSystem());
		sb.append(", versionNumber=");
		sb.append(getVersionNumber());
		sb.append(", userAgent=");
		sb.append(getUserAgent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMailSubscriberUserAgentId</column-name><column-value><![CDATA[");
		sb.append(getSpMailSubscriberUserAgentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailCampaignSubscribersId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignSubscribersId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailCampaignId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeName</column-name><column-value><![CDATA[");
		sb.append(getTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deviceCategory</column-name><column-value><![CDATA[");
		sb.append(getDeviceCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>family</column-name><column-value><![CDATA[");
		sb.append(getFamily());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>operatingSystem</column-name><column-value><![CDATA[");
		sb.append(getOperatingSystem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versionNumber</column-name><column-value><![CDATA[");
		sb.append(getVersionNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userAgent</column-name><column-value><![CDATA[");
		sb.append(getUserAgent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spMailSubscriberUserAgentId;
	private long _spMailCampaignSubscribersId;
	private long _spMailCampaignId;
	private String _name;
	private String _type;
	private String _typeName;
	private String _deviceCategory;
	private String _family;
	private String _operatingSystem;
	private String _versionNumber;
	private String _userAgent;
	private BaseModel<?> _spMailSubscriberUserAgentRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}