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
import com.sambaash.platform.srv.service.PersonaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class PersonaClp extends BaseModelImpl<Persona> implements Persona {
	public PersonaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Persona.class;
	}

	@Override
	public String getModelClassName() {
		return Persona.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPersonaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPersonaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPersonaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPersonaId", getSpPersonaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("personaType", getPersonaType());
		attributes.put("ageGroup", getAgeGroup());
		attributes.put("personaDesc", getPersonaDesc());
		attributes.put("personaImageId", getPersonaImageId());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPersonaId = (Long)attributes.get("spPersonaId");

		if (spPersonaId != null) {
			setSpPersonaId(spPersonaId);
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

		Long personaType = (Long)attributes.get("personaType");

		if (personaType != null) {
			setPersonaType(personaType);
		}

		String ageGroup = (String)attributes.get("ageGroup");

		if (ageGroup != null) {
			setAgeGroup(ageGroup);
		}

		String personaDesc = (String)attributes.get("personaDesc");

		if (personaDesc != null) {
			setPersonaDesc(personaDesc);
		}

		Long personaImageId = (Long)attributes.get("personaImageId");

		if (personaImageId != null) {
			setPersonaImageId(personaImageId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	@Override
	public long getSpPersonaId() {
		return _spPersonaId;
	}

	@Override
	public void setSpPersonaId(long spPersonaId) {
		_spPersonaId = spPersonaId;

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPersonaId", long.class);

				method.invoke(_personaRemoteModel, spPersonaId);
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

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_personaRemoteModel, groupId);
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

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_personaRemoteModel, companyId);
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

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_personaRemoteModel, userId);
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

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_personaRemoteModel, userName);
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

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_personaRemoteModel, createDate);
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

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_personaRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPersonaType() {
		return _personaType;
	}

	@Override
	public void setPersonaType(long personaType) {
		_personaType = personaType;

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonaType", long.class);

				method.invoke(_personaRemoteModel, personaType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAgeGroup() {
		return _ageGroup;
	}

	@Override
	public void setAgeGroup(String ageGroup) {
		_ageGroup = ageGroup;

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setAgeGroup", String.class);

				method.invoke(_personaRemoteModel, ageGroup);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPersonaDesc() {
		return _personaDesc;
	}

	@Override
	public void setPersonaDesc(String personaDesc) {
		_personaDesc = personaDesc;

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonaDesc", String.class);

				method.invoke(_personaRemoteModel, personaDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPersonaImageId() {
		return _personaImageId;
	}

	@Override
	public void setPersonaImageId(long personaImageId) {
		_personaImageId = personaImageId;

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonaImageId", long.class);

				method.invoke(_personaRemoteModel, personaImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;

		if (_personaRemoteModel != null) {
			try {
				Class<?> clazz = _personaRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_personaRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPersonaRemoteModel() {
		return _personaRemoteModel;
	}

	public void setPersonaRemoteModel(BaseModel<?> personaRemoteModel) {
		_personaRemoteModel = personaRemoteModel;
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

		Class<?> remoteModelClass = _personaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_personaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PersonaLocalServiceUtil.addPersona(this);
		}
		else {
			PersonaLocalServiceUtil.updatePersona(this);
		}
	}

	@Override
	public Persona toEscapedModel() {
		return (Persona)ProxyUtil.newProxyInstance(Persona.class.getClassLoader(),
			new Class[] { Persona.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PersonaClp clone = new PersonaClp();

		clone.setSpPersonaId(getSpPersonaId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPersonaType(getPersonaType());
		clone.setAgeGroup(getAgeGroup());
		clone.setPersonaDesc(getPersonaDesc());
		clone.setPersonaImageId(getPersonaImageId());
		clone.setSpCourseId(getSpCourseId());

		return clone;
	}

	@Override
	public int compareTo(Persona persona) {
		int value = 0;

		if (getSpCourseId() < persona.getSpCourseId()) {
			value = -1;
		}
		else if (getSpCourseId() > persona.getSpCourseId()) {
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

		if (!(obj instanceof PersonaClp)) {
			return false;
		}

		PersonaClp persona = (PersonaClp)obj;

		long primaryKey = persona.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{spPersonaId=");
		sb.append(getSpPersonaId());
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
		sb.append(", personaType=");
		sb.append(getPersonaType());
		sb.append(", ageGroup=");
		sb.append(getAgeGroup());
		sb.append(", personaDesc=");
		sb.append(getPersonaDesc());
		sb.append(", personaImageId=");
		sb.append(getPersonaImageId());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Persona");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spPersonaId</column-name><column-value><![CDATA[");
		sb.append(getSpPersonaId());
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
			"<column><column-name>personaType</column-name><column-value><![CDATA[");
		sb.append(getPersonaType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ageGroup</column-name><column-value><![CDATA[");
		sb.append(getAgeGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personaDesc</column-name><column-value><![CDATA[");
		sb.append(getPersonaDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personaImageId</column-name><column-value><![CDATA[");
		sb.append(getPersonaImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spPersonaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _personaType;
	private String _ageGroup;
	private String _personaDesc;
	private long _personaImageId;
	private long _spCourseId;
	private BaseModel<?> _personaRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}