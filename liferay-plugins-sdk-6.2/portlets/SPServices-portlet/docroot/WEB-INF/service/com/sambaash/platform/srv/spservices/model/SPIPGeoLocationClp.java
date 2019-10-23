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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.SPIPGeoLocationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPIPGeoLocationClp extends BaseModelImpl<SPIPGeoLocation>
	implements SPIPGeoLocation {
	public SPIPGeoLocationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPIPGeoLocation.class;
	}

	@Override
	public String getModelClassName() {
		return SPIPGeoLocation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spIPGeoLocationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpIPGeoLocationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spIPGeoLocationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spIPGeoLocationId", getSpIPGeoLocationId());
		attributes.put("ipPrefix", getIpPrefix());
		attributes.put("country", getCountry());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spIPGeoLocationId = (Long)attributes.get("spIPGeoLocationId");

		if (spIPGeoLocationId != null) {
			setSpIPGeoLocationId(spIPGeoLocationId);
		}

		String ipPrefix = (String)attributes.get("ipPrefix");

		if (ipPrefix != null) {
			setIpPrefix(ipPrefix);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spipGeoLocationRemoteModel != null) {
			try {
				Class<?> clazz = _spipGeoLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spipGeoLocationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpIPGeoLocationId() {
		return _spIPGeoLocationId;
	}

	@Override
	public void setSpIPGeoLocationId(long spIPGeoLocationId) {
		_spIPGeoLocationId = spIPGeoLocationId;

		if (_spipGeoLocationRemoteModel != null) {
			try {
				Class<?> clazz = _spipGeoLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpIPGeoLocationId",
						long.class);

				method.invoke(_spipGeoLocationRemoteModel, spIPGeoLocationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIpPrefix() {
		return _ipPrefix;
	}

	@Override
	public void setIpPrefix(String ipPrefix) {
		_ipPrefix = ipPrefix;

		if (_spipGeoLocationRemoteModel != null) {
			try {
				Class<?> clazz = _spipGeoLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setIpPrefix", String.class);

				method.invoke(_spipGeoLocationRemoteModel, ipPrefix);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_spipGeoLocationRemoteModel != null) {
			try {
				Class<?> clazz = _spipGeoLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_spipGeoLocationRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPIPGeoLocationRemoteModel() {
		return _spipGeoLocationRemoteModel;
	}

	public void setSPIPGeoLocationRemoteModel(
		BaseModel<?> spipGeoLocationRemoteModel) {
		_spipGeoLocationRemoteModel = spipGeoLocationRemoteModel;
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

		Class<?> remoteModelClass = _spipGeoLocationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spipGeoLocationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPIPGeoLocationLocalServiceUtil.addSPIPGeoLocation(this);
		}
		else {
			SPIPGeoLocationLocalServiceUtil.updateSPIPGeoLocation(this);
		}
	}

	@Override
	public SPIPGeoLocation toEscapedModel() {
		return (SPIPGeoLocation)ProxyUtil.newProxyInstance(SPIPGeoLocation.class.getClassLoader(),
			new Class[] { SPIPGeoLocation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPIPGeoLocationClp clone = new SPIPGeoLocationClp();

		clone.setUuid(getUuid());
		clone.setSpIPGeoLocationId(getSpIPGeoLocationId());
		clone.setIpPrefix(getIpPrefix());
		clone.setCountry(getCountry());

		return clone;
	}

	@Override
	public int compareTo(SPIPGeoLocation spipGeoLocation) {
		long primaryKey = spipGeoLocation.getPrimaryKey();

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

		if (!(obj instanceof SPIPGeoLocationClp)) {
			return false;
		}

		SPIPGeoLocationClp spipGeoLocation = (SPIPGeoLocationClp)obj;

		long primaryKey = spipGeoLocation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spIPGeoLocationId=");
		sb.append(getSpIPGeoLocationId());
		sb.append(", ipPrefix=");
		sb.append(getIpPrefix());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPIPGeoLocation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spIPGeoLocationId</column-name><column-value><![CDATA[");
		sb.append(getSpIPGeoLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipPrefix</column-name><column-value><![CDATA[");
		sb.append(getIpPrefix());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spIPGeoLocationId;
	private String _ipPrefix;
	private String _country;
	private BaseModel<?> _spipGeoLocationRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}