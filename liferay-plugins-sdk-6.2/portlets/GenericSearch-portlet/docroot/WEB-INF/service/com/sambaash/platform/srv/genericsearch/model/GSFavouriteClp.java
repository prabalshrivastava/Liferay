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

package com.sambaash.platform.srv.genericsearch.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.genericsearch.service.ClpSerializer;
import com.sambaash.platform.srv.genericsearch.service.GSFavouriteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class GSFavouriteClp extends BaseModelImpl<GSFavourite>
	implements GSFavourite {
	public GSFavouriteClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GSFavourite.class;
	}

	@Override
	public String getModelClassName() {
		return GSFavourite.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _SPGSFavouriteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSPGSFavouriteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _SPGSFavouriteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SPGSFavouriteId", getSPGSFavouriteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("layoutId", getLayoutId());
		attributes.put("portletInstanceId", getPortletInstanceId());
		attributes.put("config", getConfig());
		attributes.put("permissionType", getPermissionType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long SPGSFavouriteId = (Long)attributes.get("SPGSFavouriteId");

		if (SPGSFavouriteId != null) {
			setSPGSFavouriteId(SPGSFavouriteId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long layoutId = (Long)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
		}

		String portletInstanceId = (String)attributes.get("portletInstanceId");

		if (portletInstanceId != null) {
			setPortletInstanceId(portletInstanceId);
		}

		String config = (String)attributes.get("config");

		if (config != null) {
			setConfig(config);
		}

		Integer permissionType = (Integer)attributes.get("permissionType");

		if (permissionType != null) {
			setPermissionType(permissionType);
		}
	}

	@Override
	public long getSPGSFavouriteId() {
		return _SPGSFavouriteId;
	}

	@Override
	public void setSPGSFavouriteId(long SPGSFavouriteId) {
		_SPGSFavouriteId = SPGSFavouriteId;

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setSPGSFavouriteId", long.class);

				method.invoke(_gsFavouriteRemoteModel, SPGSFavouriteId);
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

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_gsFavouriteRemoteModel, groupId);
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

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_gsFavouriteRemoteModel, companyId);
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

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_gsFavouriteRemoteModel, userId);
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

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_gsFavouriteRemoteModel, userName);
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

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_gsFavouriteRemoteModel, createDate);
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

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_gsFavouriteRemoteModel, modifiedDate);
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

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_gsFavouriteRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_gsFavouriteRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLayoutId() {
		return _layoutId;
	}

	@Override
	public void setLayoutId(long layoutId) {
		_layoutId = layoutId;

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setLayoutId", long.class);

				method.invoke(_gsFavouriteRemoteModel, layoutId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPortletInstanceId() {
		return _portletInstanceId;
	}

	@Override
	public void setPortletInstanceId(String portletInstanceId) {
		_portletInstanceId = portletInstanceId;

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletInstanceId",
						String.class);

				method.invoke(_gsFavouriteRemoteModel, portletInstanceId);
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

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setConfig", String.class);

				method.invoke(_gsFavouriteRemoteModel, config);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPermissionType() {
		return _permissionType;
	}

	@Override
	public void setPermissionType(int permissionType) {
		_permissionType = permissionType;

		if (_gsFavouriteRemoteModel != null) {
			try {
				Class<?> clazz = _gsFavouriteRemoteModel.getClass();

				Method method = clazz.getMethod("setPermissionType", int.class);

				method.invoke(_gsFavouriteRemoteModel, permissionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGSFavouriteRemoteModel() {
		return _gsFavouriteRemoteModel;
	}

	public void setGSFavouriteRemoteModel(BaseModel<?> gsFavouriteRemoteModel) {
		_gsFavouriteRemoteModel = gsFavouriteRemoteModel;
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

		Class<?> remoteModelClass = _gsFavouriteRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gsFavouriteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GSFavouriteLocalServiceUtil.addGSFavourite(this);
		}
		else {
			GSFavouriteLocalServiceUtil.updateGSFavourite(this);
		}
	}

	@Override
	public GSFavourite toEscapedModel() {
		return (GSFavourite)ProxyUtil.newProxyInstance(GSFavourite.class.getClassLoader(),
			new Class[] { GSFavourite.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GSFavouriteClp clone = new GSFavouriteClp();

		clone.setSPGSFavouriteId(getSPGSFavouriteId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setCreatedBy(getCreatedBy());
		clone.setLayoutId(getLayoutId());
		clone.setPortletInstanceId(getPortletInstanceId());
		clone.setConfig(getConfig());
		clone.setPermissionType(getPermissionType());

		return clone;
	}

	@Override
	public int compareTo(GSFavourite gsFavourite) {
		int value = 0;

		value = getName().compareTo(gsFavourite.getName());

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

		if (!(obj instanceof GSFavouriteClp)) {
			return false;
		}

		GSFavouriteClp gsFavourite = (GSFavouriteClp)obj;

		long primaryKey = gsFavourite.getPrimaryKey();

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

		sb.append("{SPGSFavouriteId=");
		sb.append(getSPGSFavouriteId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", portletInstanceId=");
		sb.append(getPortletInstanceId());
		sb.append(", config=");
		sb.append(getConfig());
		sb.append(", permissionType=");
		sb.append(getPermissionType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.genericsearch.model.GSFavourite");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>SPGSFavouriteId</column-name><column-value><![CDATA[");
		sb.append(getSPGSFavouriteId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletInstanceId</column-name><column-value><![CDATA[");
		sb.append(getPortletInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>config</column-name><column-value><![CDATA[");
		sb.append(getConfig());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permissionType</column-name><column-value><![CDATA[");
		sb.append(getPermissionType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _SPGSFavouriteId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _createdBy;
	private long _layoutId;
	private String _portletInstanceId;
	private String _config;
	private int _permissionType;
	private BaseModel<?> _gsFavouriteRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.genericsearch.service.ClpSerializer.class;
}