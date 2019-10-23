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

package com.sambaash.platform.srv.filter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.filter.service.ClpSerializer;
import com.sambaash.platform.srv.filter.service.SPSearchFilterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPSearchFilterClp extends BaseModelImpl<SPSearchFilter>
	implements SPSearchFilter {
	public SPSearchFilterClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPSearchFilter.class;
	}

	@Override
	public String getModelClassName() {
		return SPSearchFilter.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spSearchFilterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpSearchFilterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spSearchFilterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spSearchFilterId", getSpSearchFilterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("filterName", getFilterName());
		attributes.put("filterParameter", getFilterParameter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spSearchFilterId = (Long)attributes.get("spSearchFilterId");

		if (spSearchFilterId != null) {
			setSpSearchFilterId(spSearchFilterId);
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

		String filterName = (String)attributes.get("filterName");

		if (filterName != null) {
			setFilterName(filterName);
		}

		String filterParameter = (String)attributes.get("filterParameter");

		if (filterParameter != null) {
			setFilterParameter(filterParameter);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spSearchFilterRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpSearchFilterId() {
		return _spSearchFilterId;
	}

	@Override
	public void setSpSearchFilterId(long spSearchFilterId) {
		_spSearchFilterId = spSearchFilterId;

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setSpSearchFilterId",
						long.class);

				method.invoke(_spSearchFilterRemoteModel, spSearchFilterId);
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

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spSearchFilterRemoteModel, groupId);
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

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spSearchFilterRemoteModel, companyId);
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

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spSearchFilterRemoteModel, userId);
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

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spSearchFilterRemoteModel, userName);
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

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spSearchFilterRemoteModel, createDate);
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

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spSearchFilterRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFilterName() {
		return _filterName;
	}

	@Override
	public void setFilterName(String filterName) {
		_filterName = filterName;

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setFilterName", String.class);

				method.invoke(_spSearchFilterRemoteModel, filterName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFilterParameter() {
		return _filterParameter;
	}

	@Override
	public void setFilterParameter(String filterParameter) {
		_filterParameter = filterParameter;

		if (_spSearchFilterRemoteModel != null) {
			try {
				Class<?> clazz = _spSearchFilterRemoteModel.getClass();

				Method method = clazz.getMethod("setFilterParameter",
						String.class);

				method.invoke(_spSearchFilterRemoteModel, filterParameter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPSearchFilter.class.getName()));
	}

	public BaseModel<?> getSPSearchFilterRemoteModel() {
		return _spSearchFilterRemoteModel;
	}

	public void setSPSearchFilterRemoteModel(
		BaseModel<?> spSearchFilterRemoteModel) {
		_spSearchFilterRemoteModel = spSearchFilterRemoteModel;
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

		Class<?> remoteModelClass = _spSearchFilterRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spSearchFilterRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPSearchFilterLocalServiceUtil.addSPSearchFilter(this);
		}
		else {
			SPSearchFilterLocalServiceUtil.updateSPSearchFilter(this);
		}
	}

	@Override
	public SPSearchFilter toEscapedModel() {
		return (SPSearchFilter)ProxyUtil.newProxyInstance(SPSearchFilter.class.getClassLoader(),
			new Class[] { SPSearchFilter.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPSearchFilterClp clone = new SPSearchFilterClp();

		clone.setUuid(getUuid());
		clone.setSpSearchFilterId(getSpSearchFilterId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFilterName(getFilterName());
		clone.setFilterParameter(getFilterParameter());

		return clone;
	}

	@Override
	public int compareTo(SPSearchFilter spSearchFilter) {
		long primaryKey = spSearchFilter.getPrimaryKey();

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

		if (!(obj instanceof SPSearchFilterClp)) {
			return false;
		}

		SPSearchFilterClp spSearchFilter = (SPSearchFilterClp)obj;

		long primaryKey = spSearchFilter.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spSearchFilterId=");
		sb.append(getSpSearchFilterId());
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
		sb.append(", filterName=");
		sb.append(getFilterName());
		sb.append(", filterParameter=");
		sb.append(getFilterParameter());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.filter.model.SPSearchFilter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spSearchFilterId</column-name><column-value><![CDATA[");
		sb.append(getSpSearchFilterId());
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
			"<column><column-name>filterName</column-name><column-value><![CDATA[");
		sb.append(getFilterName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filterParameter</column-name><column-value><![CDATA[");
		sb.append(getFilterParameter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spSearchFilterId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _filterName;
	private String _filterParameter;
	private BaseModel<?> _spSearchFilterRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.filter.service.ClpSerializer.class;
}