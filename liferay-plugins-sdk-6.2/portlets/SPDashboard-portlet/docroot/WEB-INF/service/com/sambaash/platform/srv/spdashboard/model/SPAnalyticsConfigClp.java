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

package com.sambaash.platform.srv.spdashboard.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.spdashboard.service.ClpSerializer;
import com.sambaash.platform.srv.spdashboard.service.SPAnalyticsConfigLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPAnalyticsConfigClp extends BaseModelImpl<SPAnalyticsConfig>
	implements SPAnalyticsConfig {
	public SPAnalyticsConfigClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPAnalyticsConfig.class;
	}

	@Override
	public String getModelClassName() {
		return SPAnalyticsConfig.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spAnalyticsConfigId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpAnalyticsConfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spAnalyticsConfigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spAnalyticsConfigId", getSpAnalyticsConfigId());
		attributes.put("name", getName());
		attributes.put("config", getConfig());
		attributes.put("type", getType());
		attributes.put("query", getQuery());
		attributes.put("warId", getWarId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spAnalyticsConfigId = (Long)attributes.get("spAnalyticsConfigId");

		if (spAnalyticsConfigId != null) {
			setSpAnalyticsConfigId(spAnalyticsConfigId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String config = (String)attributes.get("config");

		if (config != null) {
			setConfig(config);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String query = (String)attributes.get("query");

		if (query != null) {
			setQuery(query);
		}

		String warId = (String)attributes.get("warId");

		if (warId != null) {
			setWarId(warId);
		}
	}

	@Override
	public long getSpAnalyticsConfigId() {
		return _spAnalyticsConfigId;
	}

	@Override
	public void setSpAnalyticsConfigId(long spAnalyticsConfigId) {
		_spAnalyticsConfigId = spAnalyticsConfigId;

		if (_spAnalyticsConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spAnalyticsConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAnalyticsConfigId",
						long.class);

				method.invoke(_spAnalyticsConfigRemoteModel, spAnalyticsConfigId);
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

		if (_spAnalyticsConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spAnalyticsConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_spAnalyticsConfigRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConfig() {
		return _config;
	}

	@Override
	public void setConfig(String config) {
		_config = config;

		if (_spAnalyticsConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spAnalyticsConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setConfig", String.class);

				method.invoke(_spAnalyticsConfigRemoteModel, config);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;

		if (_spAnalyticsConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spAnalyticsConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_spAnalyticsConfigRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuery() {
		return _query;
	}

	@Override
	public void setQuery(String query) {
		_query = query;

		if (_spAnalyticsConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spAnalyticsConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setQuery", String.class);

				method.invoke(_spAnalyticsConfigRemoteModel, query);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWarId() {
		return _warId;
	}

	@Override
	public void setWarId(String warId) {
		_warId = warId;

		if (_spAnalyticsConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spAnalyticsConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setWarId", String.class);

				method.invoke(_spAnalyticsConfigRemoteModel, warId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPAnalyticsConfigRemoteModel() {
		return _spAnalyticsConfigRemoteModel;
	}

	public void setSPAnalyticsConfigRemoteModel(
		BaseModel<?> spAnalyticsConfigRemoteModel) {
		_spAnalyticsConfigRemoteModel = spAnalyticsConfigRemoteModel;
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

		Class<?> remoteModelClass = _spAnalyticsConfigRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spAnalyticsConfigRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPAnalyticsConfigLocalServiceUtil.addSPAnalyticsConfig(this);
		}
		else {
			SPAnalyticsConfigLocalServiceUtil.updateSPAnalyticsConfig(this);
		}
	}

	@Override
	public SPAnalyticsConfig toEscapedModel() {
		return (SPAnalyticsConfig)ProxyUtil.newProxyInstance(SPAnalyticsConfig.class.getClassLoader(),
			new Class[] { SPAnalyticsConfig.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPAnalyticsConfigClp clone = new SPAnalyticsConfigClp();

		clone.setSpAnalyticsConfigId(getSpAnalyticsConfigId());
		clone.setName(getName());
		clone.setConfig(getConfig());
		clone.setType(getType());
		clone.setQuery(getQuery());
		clone.setWarId(getWarId());

		return clone;
	}

	@Override
	public int compareTo(SPAnalyticsConfig spAnalyticsConfig) {
		long primaryKey = spAnalyticsConfig.getPrimaryKey();

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

		if (!(obj instanceof SPAnalyticsConfigClp)) {
			return false;
		}

		SPAnalyticsConfigClp spAnalyticsConfig = (SPAnalyticsConfigClp)obj;

		long primaryKey = spAnalyticsConfig.getPrimaryKey();

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

		sb.append("{spAnalyticsConfigId=");
		sb.append(getSpAnalyticsConfigId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", config=");
		sb.append(getConfig());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", query=");
		sb.append(getQuery());
		sb.append(", warId=");
		sb.append(getWarId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spAnalyticsConfigId</column-name><column-value><![CDATA[");
		sb.append(getSpAnalyticsConfigId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>config</column-name><column-value><![CDATA[");
		sb.append(getConfig());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>query</column-name><column-value><![CDATA[");
		sb.append(getQuery());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>warId</column-name><column-value><![CDATA[");
		sb.append(getWarId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spAnalyticsConfigId;
	private String _name;
	private String _config;
	private int _type;
	private String _query;
	private String _warId;
	private BaseModel<?> _spAnalyticsConfigRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spdashboard.service.ClpSerializer.class;
}