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

package com.sambaash.platform.srv.legalandcontract.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.legalandcontract.service.ClassMasterLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class ClassMasterClp extends BaseModelImpl<ClassMaster>
	implements ClassMaster {
	public ClassMasterClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ClassMaster.class;
	}

	@Override
	public String getModelClassName() {
		return ClassMaster.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spClassId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpClassId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spClassId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spClassId", getSpClassId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("country", getCountry());
		attributes.put("filedBy", getFiledBy());
		attributes.put("customField1", getCustomField1());
		attributes.put("customField2", getCustomField2());
		attributes.put("customDate1", getCustomDate1());
		attributes.put("customDate2", getCustomDate2());
		attributes.put("version", getVersion());
		attributes.put("rootSpClassId", getRootSpClassId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spClassId = (Long)attributes.get("spClassId");

		if (spClassId != null) {
			setSpClassId(spClassId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String filedBy = (String)attributes.get("filedBy");

		if (filedBy != null) {
			setFiledBy(filedBy);
		}

		String customField1 = (String)attributes.get("customField1");

		if (customField1 != null) {
			setCustomField1(customField1);
		}

		String customField2 = (String)attributes.get("customField2");

		if (customField2 != null) {
			setCustomField2(customField2);
		}

		Date customDate1 = (Date)attributes.get("customDate1");

		if (customDate1 != null) {
			setCustomDate1(customDate1);
		}

		Date customDate2 = (Date)attributes.get("customDate2");

		if (customDate2 != null) {
			setCustomDate2(customDate2);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long rootSpClassId = (Long)attributes.get("rootSpClassId");

		if (rootSpClassId != null) {
			setRootSpClassId(rootSpClassId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_classMasterRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpClassId() {
		return _spClassId;
	}

	@Override
	public void setSpClassId(long spClassId) {
		_spClassId = spClassId;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setSpClassId", long.class);

				method.invoke(_classMasterRemoteModel, spClassId);
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

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_classMasterRemoteModel, groupId);
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

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_classMasterRemoteModel, companyId);
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

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_classMasterRemoteModel, userId);
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

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_classMasterRemoteModel, userName);
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

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_classMasterRemoteModel, createDate);
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

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_classMasterRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_classMasterRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_classMasterRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFiledBy() {
		return _filedBy;
	}

	@Override
	public void setFiledBy(String filedBy) {
		_filedBy = filedBy;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setFiledBy", String.class);

				method.invoke(_classMasterRemoteModel, filedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomField1() {
		return _customField1;
	}

	@Override
	public void setCustomField1(String customField1) {
		_customField1 = customField1;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField1", String.class);

				method.invoke(_classMasterRemoteModel, customField1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomField2() {
		return _customField2;
	}

	@Override
	public void setCustomField2(String customField2) {
		_customField2 = customField2;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField2", String.class);

				method.invoke(_classMasterRemoteModel, customField2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCustomDate1() {
		return _customDate1;
	}

	@Override
	public void setCustomDate1(Date customDate1) {
		_customDate1 = customDate1;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate1", Date.class);

				method.invoke(_classMasterRemoteModel, customDate1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCustomDate2() {
		return _customDate2;
	}

	@Override
	public void setCustomDate2(Date customDate2) {
		_customDate2 = customDate2;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate2", Date.class);

				method.invoke(_classMasterRemoteModel, customDate2);
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

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_classMasterRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRootSpClassId() {
		return _rootSpClassId;
	}

	@Override
	public void setRootSpClassId(long rootSpClassId) {
		_rootSpClassId = rootSpClassId;

		if (_classMasterRemoteModel != null) {
			try {
				Class<?> clazz = _classMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setRootSpClassId", long.class);

				method.invoke(_classMasterRemoteModel, rootSpClassId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ClassMaster.class.getName()));
	}

	public BaseModel<?> getClassMasterRemoteModel() {
		return _classMasterRemoteModel;
	}

	public void setClassMasterRemoteModel(BaseModel<?> classMasterRemoteModel) {
		_classMasterRemoteModel = classMasterRemoteModel;
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

		Class<?> remoteModelClass = _classMasterRemoteModel.getClass();

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

		Object returnValue = method.invoke(_classMasterRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ClassMasterLocalServiceUtil.addClassMaster(this);
		}
		else {
			ClassMasterLocalServiceUtil.updateClassMaster(this);
		}
	}

	@Override
	public ClassMaster toEscapedModel() {
		return (ClassMaster)ProxyUtil.newProxyInstance(ClassMaster.class.getClassLoader(),
			new Class[] { ClassMaster.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ClassMasterClp clone = new ClassMasterClp();

		clone.setUuid(getUuid());
		clone.setSpClassId(getSpClassId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCode(getCode());
		clone.setCountry(getCountry());
		clone.setFiledBy(getFiledBy());
		clone.setCustomField1(getCustomField1());
		clone.setCustomField2(getCustomField2());
		clone.setCustomDate1(getCustomDate1());
		clone.setCustomDate2(getCustomDate2());
		clone.setVersion(getVersion());
		clone.setRootSpClassId(getRootSpClassId());

		return clone;
	}

	@Override
	public int compareTo(ClassMaster classMaster) {
		long primaryKey = classMaster.getPrimaryKey();

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

		if (!(obj instanceof ClassMasterClp)) {
			return false;
		}

		ClassMasterClp classMaster = (ClassMasterClp)obj;

		long primaryKey = classMaster.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spClassId=");
		sb.append(getSpClassId());
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
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", filedBy=");
		sb.append(getFiledBy());
		sb.append(", customField1=");
		sb.append(getCustomField1());
		sb.append(", customField2=");
		sb.append(getCustomField2());
		sb.append(", customDate1=");
		sb.append(getCustomDate1());
		sb.append(", customDate2=");
		sb.append(getCustomDate2());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", rootSpClassId=");
		sb.append(getRootSpClassId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.legalandcontract.model.ClassMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spClassId</column-name><column-value><![CDATA[");
		sb.append(getSpClassId());
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
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filedBy</column-name><column-value><![CDATA[");
		sb.append(getFiledBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField1</column-name><column-value><![CDATA[");
		sb.append(getCustomField1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField2</column-name><column-value><![CDATA[");
		sb.append(getCustomField2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate1</column-name><column-value><![CDATA[");
		sb.append(getCustomDate1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate2</column-name><column-value><![CDATA[");
		sb.append(getCustomDate2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootSpClassId</column-name><column-value><![CDATA[");
		sb.append(getRootSpClassId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spClassId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _country;
	private String _filedBy;
	private String _customField1;
	private String _customField2;
	private Date _customDate1;
	private Date _customDate2;
	private String _version;
	private long _rootSpClassId;
	private BaseModel<?> _classMasterRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.legalandcontract.service.ClpSerializer.class;
}