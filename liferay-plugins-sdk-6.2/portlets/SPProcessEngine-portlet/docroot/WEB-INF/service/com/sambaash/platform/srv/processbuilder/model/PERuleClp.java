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
import com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class PERuleClp extends BaseModelImpl<PERule> implements PERule {
	public PERuleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PERule.class;
	}

	@Override
	public String getModelClassName() {
		return PERule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPERuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPERuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPERuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPERuleId", getSpPERuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPERuleSetId", getSpPERuleSetId());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("definition", getDefinition());
		attributes.put("sequenceNO", getSequenceNO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPERuleId = (Long)attributes.get("spPERuleId");

		if (spPERuleId != null) {
			setSpPERuleId(spPERuleId);
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

		Long spPERuleSetId = (Long)attributes.get("spPERuleSetId");

		if (spPERuleSetId != null) {
			setSpPERuleSetId(spPERuleSetId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String definition = (String)attributes.get("definition");

		if (definition != null) {
			setDefinition(definition);
		}

		Long sequenceNO = (Long)attributes.get("sequenceNO");

		if (sequenceNO != null) {
			setSequenceNO(sequenceNO);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_peRuleRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPERuleId() {
		return _spPERuleId;
	}

	@Override
	public void setSpPERuleId(long spPERuleId) {
		_spPERuleId = spPERuleId;

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPERuleId", long.class);

				method.invoke(_peRuleRemoteModel, spPERuleId);
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

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_peRuleRemoteModel, groupId);
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

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_peRuleRemoteModel, companyId);
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

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_peRuleRemoteModel, userId);
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

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_peRuleRemoteModel, userName);
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

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_peRuleRemoteModel, createDate);
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

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_peRuleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPERuleSetId() {
		return _spPERuleSetId;
	}

	@Override
	public void setSpPERuleSetId(long spPERuleSetId) {
		_spPERuleSetId = spPERuleSetId;

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPERuleSetId", long.class);

				method.invoke(_peRuleRemoteModel, spPERuleSetId);
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

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_peRuleRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_peRuleRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDefinition() {
		return _definition;
	}

	@Override
	public void setDefinition(String definition) {
		_definition = definition;

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setDefinition", String.class);

				method.invoke(_peRuleRemoteModel, definition);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSequenceNO() {
		return _sequenceNO;
	}

	@Override
	public void setSequenceNO(long sequenceNO) {
		_sequenceNO = sequenceNO;

		if (_peRuleRemoteModel != null) {
			try {
				Class<?> clazz = _peRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setSequenceNO", long.class);

				method.invoke(_peRuleRemoteModel, sequenceNO);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PERule.class.getName()));
	}

	public BaseModel<?> getPERuleRemoteModel() {
		return _peRuleRemoteModel;
	}

	public void setPERuleRemoteModel(BaseModel<?> peRuleRemoteModel) {
		_peRuleRemoteModel = peRuleRemoteModel;
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

		Class<?> remoteModelClass = _peRuleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_peRuleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PERuleLocalServiceUtil.addPERule(this);
		}
		else {
			PERuleLocalServiceUtil.updatePERule(this);
		}
	}

	@Override
	public PERule toEscapedModel() {
		return (PERule)ProxyUtil.newProxyInstance(PERule.class.getClassLoader(),
			new Class[] { PERule.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PERuleClp clone = new PERuleClp();

		clone.setUuid(getUuid());
		clone.setSpPERuleId(getSpPERuleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpPERuleSetId(getSpPERuleSetId());
		clone.setName(getName());
		clone.setType(getType());
		clone.setDefinition(getDefinition());
		clone.setSequenceNO(getSequenceNO());

		return clone;
	}

	@Override
	public int compareTo(PERule peRule) {
		long primaryKey = peRule.getPrimaryKey();

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

		if (!(obj instanceof PERuleClp)) {
			return false;
		}

		PERuleClp peRule = (PERuleClp)obj;

		long primaryKey = peRule.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spPERuleId=");
		sb.append(getSpPERuleId());
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
		sb.append(", spPERuleSetId=");
		sb.append(getSpPERuleSetId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", definition=");
		sb.append(getDefinition());
		sb.append(", sequenceNO=");
		sb.append(getSequenceNO());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.processbuilder.model.PERule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPERuleId</column-name><column-value><![CDATA[");
		sb.append(getSpPERuleId());
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
			"<column><column-name>spPERuleSetId</column-name><column-value><![CDATA[");
		sb.append(getSpPERuleSetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>definition</column-name><column-value><![CDATA[");
		sb.append(getDefinition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNO</column-name><column-value><![CDATA[");
		sb.append(getSequenceNO());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spPERuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPERuleSetId;
	private String _name;
	private String _type;
	private String _definition;
	private long _sequenceNO;
	private BaseModel<?> _peRuleRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class;
}