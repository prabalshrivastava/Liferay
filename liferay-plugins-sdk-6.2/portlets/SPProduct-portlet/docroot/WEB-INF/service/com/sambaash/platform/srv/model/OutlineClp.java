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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.service.ClpSerializer;
import com.sambaash.platform.srv.service.OutlineLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class OutlineClp extends BaseModelImpl<Outline> implements Outline {
	public OutlineClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Outline.class;
	}

	@Override
	public String getModelClassName() {
		return Outline.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spOutlineId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpOutlineId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spOutlineId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spOutlineId", getSpOutlineId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCompetencyUnitId", getSpCompetencyUnitId());
		attributes.put("outlineType", getOutlineType());
		attributes.put("outlineDesc", getOutlineDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spOutlineId = (Long)attributes.get("spOutlineId");

		if (spOutlineId != null) {
			setSpOutlineId(spOutlineId);
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

		Long spCompetencyUnitId = (Long)attributes.get("spCompetencyUnitId");

		if (spCompetencyUnitId != null) {
			setSpCompetencyUnitId(spCompetencyUnitId);
		}

		Long outlineType = (Long)attributes.get("outlineType");

		if (outlineType != null) {
			setOutlineType(outlineType);
		}

		String outlineDesc = (String)attributes.get("outlineDesc");

		if (outlineDesc != null) {
			setOutlineDesc(outlineDesc);
		}
	}

	@Override
	public long getSpOutlineId() {
		return _spOutlineId;
	}

	@Override
	public void setSpOutlineId(long spOutlineId) {
		_spOutlineId = spOutlineId;

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setSpOutlineId", long.class);

				method.invoke(_outlineRemoteModel, spOutlineId);
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

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_outlineRemoteModel, groupId);
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

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_outlineRemoteModel, companyId);
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

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_outlineRemoteModel, userId);
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

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_outlineRemoteModel, userName);
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

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_outlineRemoteModel, createDate);
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

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_outlineRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCompetencyUnitId() {
		return _spCompetencyUnitId;
	}

	@Override
	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_spCompetencyUnitId = spCompetencyUnitId;

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCompetencyUnitId",
						long.class);

				method.invoke(_outlineRemoteModel, spCompetencyUnitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOutlineType() {
		return _outlineType;
	}

	@Override
	public void setOutlineType(long outlineType) {
		_outlineType = outlineType;

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setOutlineType", long.class);

				method.invoke(_outlineRemoteModel, outlineType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOutlineDesc() {
		return _outlineDesc;
	}

	@Override
	public void setOutlineDesc(String outlineDesc) {
		_outlineDesc = outlineDesc;

		if (_outlineRemoteModel != null) {
			try {
				Class<?> clazz = _outlineRemoteModel.getClass();

				Method method = clazz.getMethod("setOutlineDesc", String.class);

				method.invoke(_outlineRemoteModel, outlineDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOutlineRemoteModel() {
		return _outlineRemoteModel;
	}

	public void setOutlineRemoteModel(BaseModel<?> outlineRemoteModel) {
		_outlineRemoteModel = outlineRemoteModel;
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

		Class<?> remoteModelClass = _outlineRemoteModel.getClass();

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

		Object returnValue = method.invoke(_outlineRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OutlineLocalServiceUtil.addOutline(this);
		}
		else {
			OutlineLocalServiceUtil.updateOutline(this);
		}
	}

	@Override
	public Outline toEscapedModel() {
		return (Outline)ProxyUtil.newProxyInstance(Outline.class.getClassLoader(),
			new Class[] { Outline.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OutlineClp clone = new OutlineClp();

		clone.setSpOutlineId(getSpOutlineId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpCompetencyUnitId(getSpCompetencyUnitId());
		clone.setOutlineType(getOutlineType());
		clone.setOutlineDesc(getOutlineDesc());

		return clone;
	}

	@Override
	public int compareTo(Outline outline) {
		int value = 0;

		if (getOutlineType() < outline.getOutlineType()) {
			value = -1;
		}
		else if (getOutlineType() > outline.getOutlineType()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof OutlineClp)) {
			return false;
		}

		OutlineClp outline = (OutlineClp)obj;

		long primaryKey = outline.getPrimaryKey();

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

		sb.append("{spOutlineId=");
		sb.append(getSpOutlineId());
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
		sb.append(", spCompetencyUnitId=");
		sb.append(getSpCompetencyUnitId());
		sb.append(", outlineType=");
		sb.append(getOutlineType());
		sb.append(", outlineDesc=");
		sb.append(getOutlineDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Outline");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spOutlineId</column-name><column-value><![CDATA[");
		sb.append(getSpOutlineId());
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
			"<column><column-name>spCompetencyUnitId</column-name><column-value><![CDATA[");
		sb.append(getSpCompetencyUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outlineType</column-name><column-value><![CDATA[");
		sb.append(getOutlineType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outlineDesc</column-name><column-value><![CDATA[");
		sb.append(getOutlineDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spOutlineId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCompetencyUnitId;
	private long _outlineType;
	private String _outlineDesc;
	private BaseModel<?> _outlineRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}