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
import com.sambaash.platform.srv.spservices.service.ServiceComponentGroupLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ServiceComponentGroupClp extends BaseModelImpl<ServiceComponentGroup>
	implements ServiceComponentGroup {
	public ServiceComponentGroupClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceComponentGroup.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceComponentGroup.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _scgId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScgId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scgId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scgId", getScgId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("phase", getPhase());
		attributes.put("status", getStatus());
		attributes.put("version", getVersion());
		attributes.put("deploymentCluster", getDeploymentCluster());
		attributes.put("community", getCommunity());
		attributes.put("dateAdded", getDateAdded());
		attributes.put("dateModified", getDateModified());
		attributes.put("author", getAuthor());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());
		attributes.put("extra6", getExtra6());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scgId = (Long)attributes.get("scgId");

		if (scgId != null) {
			setScgId(scgId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String phase = (String)attributes.get("phase");

		if (phase != null) {
			setPhase(phase);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String deploymentCluster = (String)attributes.get("deploymentCluster");

		if (deploymentCluster != null) {
			setDeploymentCluster(deploymentCluster);
		}

		String community = (String)attributes.get("community");

		if (community != null) {
			setCommunity(community);
		}

		Date dateAdded = (Date)attributes.get("dateAdded");

		if (dateAdded != null) {
			setDateAdded(dateAdded);
		}

		Date dateModified = (Date)attributes.get("dateModified");

		if (dateModified != null) {
			setDateModified(dateModified);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}

		String extra3 = (String)attributes.get("extra3");

		if (extra3 != null) {
			setExtra3(extra3);
		}

		String extra4 = (String)attributes.get("extra4");

		if (extra4 != null) {
			setExtra4(extra4);
		}

		Date extra5 = (Date)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}

		Date extra6 = (Date)attributes.get("extra6");

		if (extra6 != null) {
			setExtra6(extra6);
		}
	}

	@Override
	public long getScgId() {
		return _scgId;
	}

	@Override
	public void setScgId(long scgId) {
		_scgId = scgId;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setScgId", long.class);

				method.invoke(_serviceComponentGroupRemoteModel, scgId);
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

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhase() {
		return _phase;
	}

	@Override
	public void setPhase(String phase) {
		_phase = phase;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setPhase", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, phase);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeploymentCluster() {
		return _deploymentCluster;
	}

	@Override
	public void setDeploymentCluster(String deploymentCluster) {
		_deploymentCluster = deploymentCluster;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setDeploymentCluster",
						String.class);

				method.invoke(_serviceComponentGroupRemoteModel,
					deploymentCluster);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCommunity() {
		return _community;
	}

	@Override
	public void setCommunity(String community) {
		_community = community;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCommunity", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, community);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateAdded() {
		return _dateAdded;
	}

	@Override
	public void setDateAdded(Date dateAdded) {
		_dateAdded = dateAdded;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setDateAdded", Date.class);

				method.invoke(_serviceComponentGroupRemoteModel, dateAdded);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateModified() {
		return _dateModified;
	}

	@Override
	public void setDateModified(Date dateModified) {
		_dateModified = dateModified;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setDateModified", Date.class);

				method.invoke(_serviceComponentGroupRemoteModel, dateModified);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthor() {
		return _author;
	}

	@Override
	public void setAuthor(String author) {
		_author = author;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra1() {
		return _extra1;
	}

	@Override
	public void setExtra1(String extra1) {
		_extra1 = extra1;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, extra1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra2() {
		return _extra2;
	}

	@Override
	public void setExtra2(String extra2) {
		_extra2 = extra2;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, extra2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra3() {
		return _extra3;
	}

	@Override
	public void setExtra3(String extra3) {
		_extra3 = extra3;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra3", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, extra3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra4() {
		return _extra4;
	}

	@Override
	public void setExtra4(String extra4) {
		_extra4 = extra4;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra4", String.class);

				method.invoke(_serviceComponentGroupRemoteModel, extra4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExtra5() {
		return _extra5;
	}

	@Override
	public void setExtra5(Date extra5) {
		_extra5 = extra5;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra5", Date.class);

				method.invoke(_serviceComponentGroupRemoteModel, extra5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExtra6() {
		return _extra6;
	}

	@Override
	public void setExtra6(Date extra6) {
		_extra6 = extra6;

		if (_serviceComponentGroupRemoteModel != null) {
			try {
				Class<?> clazz = _serviceComponentGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra6", Date.class);

				method.invoke(_serviceComponentGroupRemoteModel, extra6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getServiceComponentGroupRemoteModel() {
		return _serviceComponentGroupRemoteModel;
	}

	public void setServiceComponentGroupRemoteModel(
		BaseModel<?> serviceComponentGroupRemoteModel) {
		_serviceComponentGroupRemoteModel = serviceComponentGroupRemoteModel;
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

		Class<?> remoteModelClass = _serviceComponentGroupRemoteModel.getClass();

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

		Object returnValue = method.invoke(_serviceComponentGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ServiceComponentGroupLocalServiceUtil.addServiceComponentGroup(this);
		}
		else {
			ServiceComponentGroupLocalServiceUtil.updateServiceComponentGroup(this);
		}
	}

	@Override
	public ServiceComponentGroup toEscapedModel() {
		return (ServiceComponentGroup)ProxyUtil.newProxyInstance(ServiceComponentGroup.class.getClassLoader(),
			new Class[] { ServiceComponentGroup.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServiceComponentGroupClp clone = new ServiceComponentGroupClp();

		clone.setScgId(getScgId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setPhase(getPhase());
		clone.setStatus(getStatus());
		clone.setVersion(getVersion());
		clone.setDeploymentCluster(getDeploymentCluster());
		clone.setCommunity(getCommunity());
		clone.setDateAdded(getDateAdded());
		clone.setDateModified(getDateModified());
		clone.setAuthor(getAuthor());
		clone.setExtra1(getExtra1());
		clone.setExtra2(getExtra2());
		clone.setExtra3(getExtra3());
		clone.setExtra4(getExtra4());
		clone.setExtra5(getExtra5());
		clone.setExtra6(getExtra6());

		return clone;
	}

	@Override
	public int compareTo(ServiceComponentGroup serviceComponentGroup) {
		int value = 0;

		value = getName().compareTo(serviceComponentGroup.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceComponentGroupClp)) {
			return false;
		}

		ServiceComponentGroupClp serviceComponentGroup = (ServiceComponentGroupClp)obj;

		long primaryKey = serviceComponentGroup.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{scgId=");
		sb.append(getScgId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", phase=");
		sb.append(getPhase());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", deploymentCluster=");
		sb.append(getDeploymentCluster());
		sb.append(", community=");
		sb.append(getCommunity());
		sb.append(", dateAdded=");
		sb.append(getDateAdded());
		sb.append(", dateModified=");
		sb.append(getDateModified());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", extra1=");
		sb.append(getExtra1());
		sb.append(", extra2=");
		sb.append(getExtra2());
		sb.append(", extra3=");
		sb.append(getExtra3());
		sb.append(", extra4=");
		sb.append(getExtra4());
		sb.append(", extra5=");
		sb.append(getExtra5());
		sb.append(", extra6=");
		sb.append(getExtra6());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spservices.model.ServiceComponentGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scgId</column-name><column-value><![CDATA[");
		sb.append(getScgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phase</column-name><column-value><![CDATA[");
		sb.append(getPhase());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deploymentCluster</column-name><column-value><![CDATA[");
		sb.append(getDeploymentCluster());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>community</column-name><column-value><![CDATA[");
		sb.append(getCommunity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateAdded</column-name><column-value><![CDATA[");
		sb.append(getDateAdded());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateModified</column-name><column-value><![CDATA[");
		sb.append(getDateModified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra1</column-name><column-value><![CDATA[");
		sb.append(getExtra1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra2</column-name><column-value><![CDATA[");
		sb.append(getExtra2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra3</column-name><column-value><![CDATA[");
		sb.append(getExtra3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra4</column-name><column-value><![CDATA[");
		sb.append(getExtra4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra5</column-name><column-value><![CDATA[");
		sb.append(getExtra5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra6</column-name><column-value><![CDATA[");
		sb.append(getExtra6());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scgId;
	private String _name;
	private String _description;
	private String _phase;
	private String _status;
	private String _version;
	private String _deploymentCluster;
	private String _community;
	private Date _dateAdded;
	private Date _dateModified;
	private String _author;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private Date _extra5;
	private Date _extra6;
	private BaseModel<?> _serviceComponentGroupRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}