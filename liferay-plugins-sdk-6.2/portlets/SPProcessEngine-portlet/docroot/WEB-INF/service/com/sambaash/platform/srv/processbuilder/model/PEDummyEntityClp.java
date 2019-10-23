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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.processbuilder.service.ClpSerializer;
import com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class PEDummyEntityClp extends BaseModelImpl<PEDummyEntity>
	implements PEDummyEntity {
	public PEDummyEntityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PEDummyEntity.class;
	}

	@Override
	public String getModelClassName() {
		return PEDummyEntity.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPEDummyEntityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPEDummyEntityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPEDummyEntityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEDummyEntityId", getSpPEDummyEntityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEDummyEntityId = (Long)attributes.get("spPEDummyEntityId");

		if (spPEDummyEntityId != null) {
			setSpPEDummyEntityId(spPEDummyEntityId);
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
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_peDummyEntityRemoteModel != null) {
			try {
				Class<?> clazz = _peDummyEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_peDummyEntityRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEDummyEntityId() {
		return _spPEDummyEntityId;
	}

	@Override
	public void setSpPEDummyEntityId(long spPEDummyEntityId) {
		_spPEDummyEntityId = spPEDummyEntityId;

		if (_peDummyEntityRemoteModel != null) {
			try {
				Class<?> clazz = _peDummyEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEDummyEntityId",
						long.class);

				method.invoke(_peDummyEntityRemoteModel, spPEDummyEntityId);
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

		if (_peDummyEntityRemoteModel != null) {
			try {
				Class<?> clazz = _peDummyEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_peDummyEntityRemoteModel, groupId);
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

		if (_peDummyEntityRemoteModel != null) {
			try {
				Class<?> clazz = _peDummyEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_peDummyEntityRemoteModel, companyId);
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

		if (_peDummyEntityRemoteModel != null) {
			try {
				Class<?> clazz = _peDummyEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_peDummyEntityRemoteModel, userId);
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

		if (_peDummyEntityRemoteModel != null) {
			try {
				Class<?> clazz = _peDummyEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_peDummyEntityRemoteModel, userName);
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

		if (_peDummyEntityRemoteModel != null) {
			try {
				Class<?> clazz = _peDummyEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_peDummyEntityRemoteModel, createDate);
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

		if (_peDummyEntityRemoteModel != null) {
			try {
				Class<?> clazz = _peDummyEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_peDummyEntityRemoteModel, modifiedDate);
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

		if (_peDummyEntityRemoteModel != null) {
			try {
				Class<?> clazz = _peDummyEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_peDummyEntityRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PEDummyEntity.class.getName()));
	}

	public BaseModel<?> getPEDummyEntityRemoteModel() {
		return _peDummyEntityRemoteModel;
	}

	public void setPEDummyEntityRemoteModel(
		BaseModel<?> peDummyEntityRemoteModel) {
		_peDummyEntityRemoteModel = peDummyEntityRemoteModel;
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

		Class<?> remoteModelClass = _peDummyEntityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_peDummyEntityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PEDummyEntityLocalServiceUtil.addPEDummyEntity(this);
		}
		else {
			PEDummyEntityLocalServiceUtil.updatePEDummyEntity(this);
		}
	}

	@Override
	public PEDummyEntity toEscapedModel() {
		return (PEDummyEntity)ProxyUtil.newProxyInstance(PEDummyEntity.class.getClassLoader(),
			new Class[] { PEDummyEntity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PEDummyEntityClp clone = new PEDummyEntityClp();

		clone.setUuid(getUuid());
		clone.setSpPEDummyEntityId(getSpPEDummyEntityId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(PEDummyEntity peDummyEntity) {
		long primaryKey = peDummyEntity.getPrimaryKey();

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

		if (!(obj instanceof PEDummyEntityClp)) {
			return false;
		}

		PEDummyEntityClp peDummyEntity = (PEDummyEntityClp)obj;

		long primaryKey = peDummyEntity.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spPEDummyEntityId=");
		sb.append(getSpPEDummyEntityId());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.processbuilder.model.PEDummyEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEDummyEntityId</column-name><column-value><![CDATA[");
		sb.append(getSpPEDummyEntityId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spPEDummyEntityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private BaseModel<?> _peDummyEntityRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class;
}