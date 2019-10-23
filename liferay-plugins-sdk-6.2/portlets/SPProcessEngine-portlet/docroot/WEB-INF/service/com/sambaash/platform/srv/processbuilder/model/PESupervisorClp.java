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

package com.sambaash.platform.srv.processbuilder.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.processbuilder.service.ClpSerializer;
import com.sambaash.platform.srv.processbuilder.service.PESupervisorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class PESupervisorClp extends BaseModelImpl<PESupervisor>
	implements PESupervisor {
	public PESupervisorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PESupervisor.class;
	}

	@Override
	public String getModelClassName() {
		return PESupervisor.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPESupervisorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPESupervisorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPESupervisorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPESupervisorId", getSpPESupervisorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("filter1", getFilter1());
		attributes.put("filter2", getFilter2());
		attributes.put("filter3", getFilter3());
		attributes.put("filter4", getFilter4());
		attributes.put("filter5", getFilter5());
		attributes.put("supervisorId", getSupervisorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPESupervisorId = (Long)attributes.get("spPESupervisorId");

		if (spPESupervisorId != null) {
			setSpPESupervisorId(spPESupervisorId);
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

		String filter1 = (String)attributes.get("filter1");

		if (filter1 != null) {
			setFilter1(filter1);
		}

		String filter2 = (String)attributes.get("filter2");

		if (filter2 != null) {
			setFilter2(filter2);
		}

		String filter3 = (String)attributes.get("filter3");

		if (filter3 != null) {
			setFilter3(filter3);
		}

		String filter4 = (String)attributes.get("filter4");

		if (filter4 != null) {
			setFilter4(filter4);
		}

		String filter5 = (String)attributes.get("filter5");

		if (filter5 != null) {
			setFilter5(filter5);
		}

		Long supervisorId = (Long)attributes.get("supervisorId");

		if (supervisorId != null) {
			setSupervisorId(supervisorId);
		}
	}

	@Override
	public long getSpPESupervisorId() {
		return _spPESupervisorId;
	}

	@Override
	public void setSpPESupervisorId(long spPESupervisorId) {
		_spPESupervisorId = spPESupervisorId;

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPESupervisorId",
						long.class);

				method.invoke(_peSupervisorRemoteModel, spPESupervisorId);
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

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_peSupervisorRemoteModel, groupId);
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

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_peSupervisorRemoteModel, companyId);
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

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_peSupervisorRemoteModel, userId);
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

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_peSupervisorRemoteModel, userName);
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

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_peSupervisorRemoteModel, createDate);
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

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_peSupervisorRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFilter1() {
		return _filter1;
	}

	@Override
	public void setFilter1(String filter1) {
		_filter1 = filter1;

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setFilter1", String.class);

				method.invoke(_peSupervisorRemoteModel, filter1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFilter2() {
		return _filter2;
	}

	@Override
	public void setFilter2(String filter2) {
		_filter2 = filter2;

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setFilter2", String.class);

				method.invoke(_peSupervisorRemoteModel, filter2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFilter3() {
		return _filter3;
	}

	@Override
	public void setFilter3(String filter3) {
		_filter3 = filter3;

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setFilter3", String.class);

				method.invoke(_peSupervisorRemoteModel, filter3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFilter4() {
		return _filter4;
	}

	@Override
	public void setFilter4(String filter4) {
		_filter4 = filter4;

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setFilter4", String.class);

				method.invoke(_peSupervisorRemoteModel, filter4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFilter5() {
		return _filter5;
	}

	@Override
	public void setFilter5(String filter5) {
		_filter5 = filter5;

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setFilter5", String.class);

				method.invoke(_peSupervisorRemoteModel, filter5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSupervisorId() {
		return _supervisorId;
	}

	@Override
	public void setSupervisorId(long supervisorId) {
		_supervisorId = supervisorId;

		if (_peSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _peSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisorId", long.class);

				method.invoke(_peSupervisorRemoteModel, supervisorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPESupervisorRemoteModel() {
		return _peSupervisorRemoteModel;
	}

	public void setPESupervisorRemoteModel(BaseModel<?> peSupervisorRemoteModel) {
		_peSupervisorRemoteModel = peSupervisorRemoteModel;
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

		Class<?> remoteModelClass = _peSupervisorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_peSupervisorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PESupervisorLocalServiceUtil.addPESupervisor(this);
		}
		else {
			PESupervisorLocalServiceUtil.updatePESupervisor(this);
		}
	}

	@Override
	public PESupervisor toEscapedModel() {
		return (PESupervisor)ProxyUtil.newProxyInstance(PESupervisor.class.getClassLoader(),
			new Class[] { PESupervisor.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PESupervisorClp clone = new PESupervisorClp();

		clone.setSpPESupervisorId(getSpPESupervisorId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFilter1(getFilter1());
		clone.setFilter2(getFilter2());
		clone.setFilter3(getFilter3());
		clone.setFilter4(getFilter4());
		clone.setFilter5(getFilter5());
		clone.setSupervisorId(getSupervisorId());

		return clone;
	}

	@Override
	public int compareTo(PESupervisor peSupervisor) {
		long primaryKey = peSupervisor.getPrimaryKey();

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

		if (!(obj instanceof PESupervisorClp)) {
			return false;
		}

		PESupervisorClp peSupervisor = (PESupervisorClp)obj;

		long primaryKey = peSupervisor.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{spPESupervisorId=");
		sb.append(getSpPESupervisorId());
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
		sb.append(", filter1=");
		sb.append(getFilter1());
		sb.append(", filter2=");
		sb.append(getFilter2());
		sb.append(", filter3=");
		sb.append(getFilter3());
		sb.append(", filter4=");
		sb.append(getFilter4());
		sb.append(", filter5=");
		sb.append(getFilter5());
		sb.append(", supervisorId=");
		sb.append(getSupervisorId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.processbuilder.model.PESupervisor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spPESupervisorId</column-name><column-value><![CDATA[");
		sb.append(getSpPESupervisorId());
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
			"<column><column-name>filter1</column-name><column-value><![CDATA[");
		sb.append(getFilter1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filter2</column-name><column-value><![CDATA[");
		sb.append(getFilter2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filter3</column-name><column-value><![CDATA[");
		sb.append(getFilter3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filter4</column-name><column-value><![CDATA[");
		sb.append(getFilter4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filter5</column-name><column-value><![CDATA[");
		sb.append(getFilter5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supervisorId</column-name><column-value><![CDATA[");
		sb.append(getSupervisorId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spPESupervisorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _filter1;
	private String _filter2;
	private String _filter3;
	private String _filter4;
	private String _filter5;
	private long _supervisorId;
	private BaseModel<?> _peSupervisorRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class;
}