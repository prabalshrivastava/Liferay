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
import com.sambaash.platform.srv.spservices.service.SPAuditLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPAuditClp extends BaseModelImpl<SPAudit> implements SPAudit {
	public SPAuditClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPAudit.class;
	}

	@Override
	public String getModelClassName() {
		return SPAudit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _SPAuditId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSPAuditId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _SPAuditId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("SPAuditId", getSPAuditId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("doneByUserId", getDoneByUserId());
		attributes.put("entityClassNameId", getEntityClassNameId());
		attributes.put("entityId", getEntityId());
		attributes.put("action", getAction());
		attributes.put("field1Str", getField1Str());
		attributes.put("field1Long", getField1Long());
		attributes.put("field2Str", getField2Str());
		attributes.put("field2Long", getField2Long());
		attributes.put("data1", getData1());
		attributes.put("data2", getData2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long SPAuditId = (Long)attributes.get("SPAuditId");

		if (SPAuditId != null) {
			setSPAuditId(SPAuditId);
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

		Long doneByUserId = (Long)attributes.get("doneByUserId");

		if (doneByUserId != null) {
			setDoneByUserId(doneByUserId);
		}

		Long entityClassNameId = (Long)attributes.get("entityClassNameId");

		if (entityClassNameId != null) {
			setEntityClassNameId(entityClassNameId);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String field1Str = (String)attributes.get("field1Str");

		if (field1Str != null) {
			setField1Str(field1Str);
		}

		Long field1Long = (Long)attributes.get("field1Long");

		if (field1Long != null) {
			setField1Long(field1Long);
		}

		String field2Str = (String)attributes.get("field2Str");

		if (field2Str != null) {
			setField2Str(field2Str);
		}

		Long field2Long = (Long)attributes.get("field2Long");

		if (field2Long != null) {
			setField2Long(field2Long);
		}

		String data1 = (String)attributes.get("data1");

		if (data1 != null) {
			setData1(data1);
		}

		String data2 = (String)attributes.get("data2");

		if (data2 != null) {
			setData2(data2);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spAuditRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSPAuditId() {
		return _SPAuditId;
	}

	@Override
	public void setSPAuditId(long SPAuditId) {
		_SPAuditId = SPAuditId;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSPAuditId", long.class);

				method.invoke(_spAuditRemoteModel, SPAuditId);
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

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spAuditRemoteModel, groupId);
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

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spAuditRemoteModel, companyId);
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

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spAuditRemoteModel, userId);
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

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spAuditRemoteModel, userName);
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

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spAuditRemoteModel, createDate);
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

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spAuditRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDoneByUserId() {
		return _doneByUserId;
	}

	@Override
	public void setDoneByUserId(long doneByUserId) {
		_doneByUserId = doneByUserId;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setDoneByUserId", long.class);

				method.invoke(_spAuditRemoteModel, doneByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDoneByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getDoneByUserId(), "uuid",
			_doneByUserUuid);
	}

	@Override
	public void setDoneByUserUuid(String doneByUserUuid) {
		_doneByUserUuid = doneByUserUuid;
	}

	@Override
	public long getEntityClassNameId() {
		return _entityClassNameId;
	}

	@Override
	public void setEntityClassNameId(long entityClassNameId) {
		_entityClassNameId = entityClassNameId;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassNameId",
						long.class);

				method.invoke(_spAuditRemoteModel, entityClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		_entityId = entityId;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityId", long.class);

				method.invoke(_spAuditRemoteModel, entityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAction() {
		return _action;
	}

	@Override
	public void setAction(String action) {
		_action = action;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setAction", String.class);

				method.invoke(_spAuditRemoteModel, action);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getField1Str() {
		return _field1Str;
	}

	@Override
	public void setField1Str(String field1Str) {
		_field1Str = field1Str;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setField1Str", String.class);

				method.invoke(_spAuditRemoteModel, field1Str);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getField1Long() {
		return _field1Long;
	}

	@Override
	public void setField1Long(long field1Long) {
		_field1Long = field1Long;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setField1Long", long.class);

				method.invoke(_spAuditRemoteModel, field1Long);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getField2Str() {
		return _field2Str;
	}

	@Override
	public void setField2Str(String field2Str) {
		_field2Str = field2Str;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setField2Str", String.class);

				method.invoke(_spAuditRemoteModel, field2Str);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getField2Long() {
		return _field2Long;
	}

	@Override
	public void setField2Long(long field2Long) {
		_field2Long = field2Long;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setField2Long", long.class);

				method.invoke(_spAuditRemoteModel, field2Long);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getData1() {
		return _data1;
	}

	@Override
	public void setData1(String data1) {
		_data1 = data1;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setData1", String.class);

				method.invoke(_spAuditRemoteModel, data1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getData2() {
		return _data2;
	}

	@Override
	public void setData2(String data2) {
		_data2 = data2;

		if (_spAuditRemoteModel != null) {
			try {
				Class<?> clazz = _spAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setData2", String.class);

				method.invoke(_spAuditRemoteModel, data2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPAudit.class.getName()));
	}

	public BaseModel<?> getSPAuditRemoteModel() {
		return _spAuditRemoteModel;
	}

	public void setSPAuditRemoteModel(BaseModel<?> spAuditRemoteModel) {
		_spAuditRemoteModel = spAuditRemoteModel;
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

		Class<?> remoteModelClass = _spAuditRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spAuditRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPAuditLocalServiceUtil.addSPAudit(this);
		}
		else {
			SPAuditLocalServiceUtil.updateSPAudit(this);
		}
	}

	@Override
	public SPAudit toEscapedModel() {
		return (SPAudit)ProxyUtil.newProxyInstance(SPAudit.class.getClassLoader(),
			new Class[] { SPAudit.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPAuditClp clone = new SPAuditClp();

		clone.setUuid(getUuid());
		clone.setSPAuditId(getSPAuditId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDoneByUserId(getDoneByUserId());
		clone.setEntityClassNameId(getEntityClassNameId());
		clone.setEntityId(getEntityId());
		clone.setAction(getAction());
		clone.setField1Str(getField1Str());
		clone.setField1Long(getField1Long());
		clone.setField2Str(getField2Str());
		clone.setField2Long(getField2Long());
		clone.setData1(getData1());
		clone.setData2(getData2());

		return clone;
	}

	@Override
	public int compareTo(SPAudit spAudit) {
		long primaryKey = spAudit.getPrimaryKey();

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

		if (!(obj instanceof SPAuditClp)) {
			return false;
		}

		SPAuditClp spAudit = (SPAuditClp)obj;

		long primaryKey = spAudit.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", SPAuditId=");
		sb.append(getSPAuditId());
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
		sb.append(", doneByUserId=");
		sb.append(getDoneByUserId());
		sb.append(", entityClassNameId=");
		sb.append(getEntityClassNameId());
		sb.append(", entityId=");
		sb.append(getEntityId());
		sb.append(", action=");
		sb.append(getAction());
		sb.append(", field1Str=");
		sb.append(getField1Str());
		sb.append(", field1Long=");
		sb.append(getField1Long());
		sb.append(", field2Str=");
		sb.append(getField2Str());
		sb.append(", field2Long=");
		sb.append(getField2Long());
		sb.append(", data1=");
		sb.append(getData1());
		sb.append(", data2=");
		sb.append(getData2());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPAudit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SPAuditId</column-name><column-value><![CDATA[");
		sb.append(getSPAuditId());
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
			"<column><column-name>doneByUserId</column-name><column-value><![CDATA[");
		sb.append(getDoneByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassNameId</column-name><column-value><![CDATA[");
		sb.append(getEntityClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field1Str</column-name><column-value><![CDATA[");
		sb.append(getField1Str());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field1Long</column-name><column-value><![CDATA[");
		sb.append(getField1Long());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field2Str</column-name><column-value><![CDATA[");
		sb.append(getField2Str());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field2Long</column-name><column-value><![CDATA[");
		sb.append(getField2Long());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data1</column-name><column-value><![CDATA[");
		sb.append(getData1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data2</column-name><column-value><![CDATA[");
		sb.append(getData2());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _SPAuditId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _doneByUserId;
	private String _doneByUserUuid;
	private long _entityClassNameId;
	private long _entityId;
	private String _action;
	private String _field1Str;
	private long _field1Long;
	private String _field2Str;
	private long _field2Long;
	private String _data1;
	private String _data2;
	private BaseModel<?> _spAuditRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}