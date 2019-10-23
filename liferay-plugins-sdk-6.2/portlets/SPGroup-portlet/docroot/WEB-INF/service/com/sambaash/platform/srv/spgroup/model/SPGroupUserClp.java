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

package com.sambaash.platform.srv.spgroup.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spgroup.service.ClpSerializer;
import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPGroupUserClp extends BaseModelImpl<SPGroupUser>
	implements SPGroupUser {
	public SPGroupUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPGroupUser.class;
	}

	@Override
	public String getModelClassName() {
		return SPGroupUser.class.getName();
	}

	@Override
	public SPGroupUserPK getPrimaryKey() {
		return new SPGroupUserPK(_spGroupId, _userId);
	}

	@Override
	public void setPrimaryKey(SPGroupUserPK primaryKey) {
		setSpGroupId(primaryKey.spGroupId);
		setUserId(primaryKey.userId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SPGroupUserPK(_spGroupId, _userId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SPGroupUserPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spGroupId", getSpGroupId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("joinDate", getJoinDate());
		attributes.put("role", getRole());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spGroupId = (Long)attributes.get("spGroupId");

		if (spGroupId != null) {
			setSpGroupId(spGroupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Date joinDate = (Date)attributes.get("joinDate");

		if (joinDate != null) {
			setJoinDate(joinDate);
		}

		Integer role = (Integer)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getSpGroupId() {
		return _spGroupId;
	}

	@Override
	public void setSpGroupId(long spGroupId) {
		_spGroupId = spGroupId;

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSpGroupId", long.class);

				method.invoke(_spGroupUserRemoteModel, spGroupId);
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

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spGroupUserRemoteModel, userId);
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spGroupUserRemoteModel, groupId);
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

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spGroupUserRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spGroupUserRemoteModel, userName);
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

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spGroupUserRemoteModel, createDate);
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

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spGroupUserRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJoinDate() {
		return _joinDate;
	}

	@Override
	public void setJoinDate(Date joinDate) {
		_joinDate = joinDate;

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setJoinDate", Date.class);

				method.invoke(_spGroupUserRemoteModel, joinDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRole() {
		return _role;
	}

	@Override
	public void setRole(int role) {
		_role = role;

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setRole", int.class);

				method.invoke(_spGroupUserRemoteModel, role);
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

		if (_spGroupUserRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupUserRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_spGroupUserRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPGroupUserRemoteModel() {
		return _spGroupUserRemoteModel;
	}

	public void setSPGroupUserRemoteModel(BaseModel<?> spGroupUserRemoteModel) {
		_spGroupUserRemoteModel = spGroupUserRemoteModel;
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

		Class<?> remoteModelClass = _spGroupUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spGroupUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPGroupUserLocalServiceUtil.addSPGroupUser(this);
		}
		else {
			SPGroupUserLocalServiceUtil.updateSPGroupUser(this);
		}
	}

	@Override
	public SPGroupUser toEscapedModel() {
		return (SPGroupUser)ProxyUtil.newProxyInstance(SPGroupUser.class.getClassLoader(),
			new Class[] { SPGroupUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPGroupUserClp clone = new SPGroupUserClp();

		clone.setSpGroupId(getSpGroupId());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setJoinDate(getJoinDate());
		clone.setRole(getRole());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(SPGroupUser spGroupUser) {
		int value = 0;

		value = DateUtil.compareTo(getJoinDate(), spGroupUser.getJoinDate());

		value = value * -1;

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

		if (!(obj instanceof SPGroupUserClp)) {
			return false;
		}

		SPGroupUserClp spGroupUser = (SPGroupUserClp)obj;

		SPGroupUserPK primaryKey = spGroupUser.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spGroupId=");
		sb.append(getSpGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", joinDate=");
		sb.append(getJoinDate());
		sb.append(", role=");
		sb.append(getRole());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spgroup.model.SPGroupUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spGroupId</column-name><column-value><![CDATA[");
		sb.append(getSpGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>joinDate</column-name><column-value><![CDATA[");
		sb.append(getJoinDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>role</column-name><column-value><![CDATA[");
		sb.append(getRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spGroupId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _joinDate;
	private int _role;
	private int _status;
	private BaseModel<?> _spGroupUserRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spgroup.service.ClpSerializer.class;
}