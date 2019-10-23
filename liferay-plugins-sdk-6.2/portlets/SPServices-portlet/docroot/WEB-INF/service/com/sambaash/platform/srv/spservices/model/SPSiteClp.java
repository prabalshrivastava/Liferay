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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPSiteClp extends BaseModelImpl<SPSite> implements SPSite {
	public SPSiteClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPSite.class;
	}

	@Override
	public String getModelClassName() {
		return SPSite.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spSiteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpSiteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spSiteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spSiteId", getSpSiteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("virtualHostId", getVirtualHostId());
		attributes.put("layoutSetId", getLayoutSetId());
		attributes.put("authAccessId", getAuthAccessId());
		attributes.put("loginType", getLoginType());
		attributes.put("password", getPassword());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spSiteId = (Long)attributes.get("spSiteId");

		if (spSiteId != null) {
			setSpSiteId(spSiteId);
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

		Long virtualHostId = (Long)attributes.get("virtualHostId");

		if (virtualHostId != null) {
			setVirtualHostId(virtualHostId);
		}

		Long layoutSetId = (Long)attributes.get("layoutSetId");

		if (layoutSetId != null) {
			setLayoutSetId(layoutSetId);
		}

		Long authAccessId = (Long)attributes.get("authAccessId");

		if (authAccessId != null) {
			setAuthAccessId(authAccessId);
		}

		Long loginType = (Long)attributes.get("loginType");

		if (loginType != null) {
			setLoginType(loginType);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spSiteRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpSiteId() {
		return _spSiteId;
	}

	@Override
	public void setSpSiteId(long spSiteId) {
		_spSiteId = spSiteId;

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setSpSiteId", long.class);

				method.invoke(_spSiteRemoteModel, spSiteId);
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

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spSiteRemoteModel, groupId);
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

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spSiteRemoteModel, companyId);
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

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spSiteRemoteModel, userId);
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

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spSiteRemoteModel, userName);
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

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spSiteRemoteModel, createDate);
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

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spSiteRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVirtualHostId() {
		return _virtualHostId;
	}

	@Override
	public void setVirtualHostId(long virtualHostId) {
		_virtualHostId = virtualHostId;

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualHostId", long.class);

				method.invoke(_spSiteRemoteModel, virtualHostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLayoutSetId() {
		return _layoutSetId;
	}

	@Override
	public void setLayoutSetId(long layoutSetId) {
		_layoutSetId = layoutSetId;

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setLayoutSetId", long.class);

				method.invoke(_spSiteRemoteModel, layoutSetId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAuthAccessId() {
		return _authAccessId;
	}

	@Override
	public void setAuthAccessId(long authAccessId) {
		_authAccessId = authAccessId;

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthAccessId", long.class);

				method.invoke(_spSiteRemoteModel, authAccessId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLoginType() {
		return _loginType;
	}

	@Override
	public void setLoginType(long loginType) {
		_loginType = loginType;

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setLoginType", long.class);

				method.invoke(_spSiteRemoteModel, loginType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassword() {
		return _password;
	}

	@Override
	public void setPassword(String password) {
		_password = password;

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setPassword", String.class);

				method.invoke(_spSiteRemoteModel, password);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_spSiteRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_spSiteRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPSite.class.getName()));
	}

	public BaseModel<?> getSPSiteRemoteModel() {
		return _spSiteRemoteModel;
	}

	public void setSPSiteRemoteModel(BaseModel<?> spSiteRemoteModel) {
		_spSiteRemoteModel = spSiteRemoteModel;
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

		Class<?> remoteModelClass = _spSiteRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spSiteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPSiteLocalServiceUtil.addSPSite(this);
		}
		else {
			SPSiteLocalServiceUtil.updateSPSite(this);
		}
	}

	@Override
	public SPSite toEscapedModel() {
		return (SPSite)ProxyUtil.newProxyInstance(SPSite.class.getClassLoader(),
			new Class[] { SPSite.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPSiteClp clone = new SPSiteClp();

		clone.setUuid(getUuid());
		clone.setSpSiteId(getSpSiteId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setVirtualHostId(getVirtualHostId());
		clone.setLayoutSetId(getLayoutSetId());
		clone.setAuthAccessId(getAuthAccessId());
		clone.setLoginType(getLoginType());
		clone.setPassword(getPassword());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(SPSite spSite) {
		long primaryKey = spSite.getPrimaryKey();

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

		if (!(obj instanceof SPSiteClp)) {
			return false;
		}

		SPSiteClp spSite = (SPSiteClp)obj;

		long primaryKey = spSite.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spSiteId=");
		sb.append(getSpSiteId());
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
		sb.append(", virtualHostId=");
		sb.append(getVirtualHostId());
		sb.append(", layoutSetId=");
		sb.append(getLayoutSetId());
		sb.append(", authAccessId=");
		sb.append(getAuthAccessId());
		sb.append(", loginType=");
		sb.append(getLoginType());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPSite");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spSiteId</column-name><column-value><![CDATA[");
		sb.append(getSpSiteId());
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
			"<column><column-name>virtualHostId</column-name><column-value><![CDATA[");
		sb.append(getVirtualHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutSetId</column-name><column-value><![CDATA[");
		sb.append(getLayoutSetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authAccessId</column-name><column-value><![CDATA[");
		sb.append(getAuthAccessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loginType</column-name><column-value><![CDATA[");
		sb.append(getLoginType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spSiteId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _virtualHostId;
	private long _layoutSetId;
	private long _authAccessId;
	private long _loginType;
	private String _password;
	private boolean _active;
	private BaseModel<?> _spSiteRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}