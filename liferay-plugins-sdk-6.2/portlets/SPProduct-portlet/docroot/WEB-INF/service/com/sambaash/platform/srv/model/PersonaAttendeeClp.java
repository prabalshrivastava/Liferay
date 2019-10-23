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
import com.sambaash.platform.srv.service.PersonaAttendeeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class PersonaAttendeeClp extends BaseModelImpl<PersonaAttendee>
	implements PersonaAttendee {
	public PersonaAttendeeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PersonaAttendee.class;
	}

	@Override
	public String getModelClassName() {
		return PersonaAttendee.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPersonaAttendeeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPersonaAttendeeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPersonaAttendeeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPersonaAttendeeId", getSpPersonaAttendeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("imageId", getImageId());
		attributes.put("spPersonaId", getSpPersonaId());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPersonaAttendeeId = (Long)attributes.get("spPersonaAttendeeId");

		if (spPersonaAttendeeId != null) {
			setSpPersonaAttendeeId(spPersonaAttendeeId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Long spPersonaId = (Long)attributes.get("spPersonaId");

		if (spPersonaId != null) {
			setSpPersonaId(spPersonaId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	@Override
	public long getSpPersonaAttendeeId() {
		return _spPersonaAttendeeId;
	}

	@Override
	public void setSpPersonaAttendeeId(long spPersonaAttendeeId) {
		_spPersonaAttendeeId = spPersonaAttendeeId;

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPersonaAttendeeId",
						long.class);

				method.invoke(_personaAttendeeRemoteModel, spPersonaAttendeeId);
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

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_personaAttendeeRemoteModel, groupId);
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

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_personaAttendeeRemoteModel, companyId);
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

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_personaAttendeeRemoteModel, userId);
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

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_personaAttendeeRemoteModel, userName);
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

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_personaAttendeeRemoteModel, createDate);
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

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_personaAttendeeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_personaAttendeeRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImageId() {
		return _imageId;
	}

	@Override
	public void setImageId(long imageId) {
		_imageId = imageId;

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setImageId", long.class);

				method.invoke(_personaAttendeeRemoteModel, imageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPersonaId() {
		return _spPersonaId;
	}

	@Override
	public void setSpPersonaId(long spPersonaId) {
		_spPersonaId = spPersonaId;

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPersonaId", long.class);

				method.invoke(_personaAttendeeRemoteModel, spPersonaId);
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

		if (_personaAttendeeRemoteModel != null) {
			try {
				Class<?> clazz = _personaAttendeeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_personaAttendeeRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPersonaAttendeeRemoteModel() {
		return _personaAttendeeRemoteModel;
	}

	public void setPersonaAttendeeRemoteModel(
		BaseModel<?> personaAttendeeRemoteModel) {
		_personaAttendeeRemoteModel = personaAttendeeRemoteModel;
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

		Class<?> remoteModelClass = _personaAttendeeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_personaAttendeeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PersonaAttendeeLocalServiceUtil.addPersonaAttendee(this);
		}
		else {
			PersonaAttendeeLocalServiceUtil.updatePersonaAttendee(this);
		}
	}

	@Override
	public PersonaAttendee toEscapedModel() {
		return (PersonaAttendee)ProxyUtil.newProxyInstance(PersonaAttendee.class.getClassLoader(),
			new Class[] { PersonaAttendee.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PersonaAttendeeClp clone = new PersonaAttendeeClp();

		clone.setSpPersonaAttendeeId(getSpPersonaAttendeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDescription(getDescription());
		clone.setImageId(getImageId());
		clone.setSpPersonaId(getSpPersonaId());
		clone.setSpCourseId(getSpCourseId());

		return clone;
	}

	@Override
	public int compareTo(PersonaAttendee personaAttendee) {
		int value = 0;

		if (getSpPersonaId() < personaAttendee.getSpPersonaId()) {
			value = -1;
		}
		else if (getSpPersonaId() > personaAttendee.getSpPersonaId()) {
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

		if (!(obj instanceof PersonaAttendeeClp)) {
			return false;
		}

		PersonaAttendeeClp personaAttendee = (PersonaAttendeeClp)obj;

		long primaryKey = personaAttendee.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{spPersonaAttendeeId=");
		sb.append(getSpPersonaAttendeeId());
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
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", imageId=");
		sb.append(getImageId());
		sb.append(", spPersonaId=");
		sb.append(getSpPersonaId());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.PersonaAttendee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spPersonaAttendeeId</column-name><column-value><![CDATA[");
		sb.append(getSpPersonaAttendeeId());
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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPersonaId</column-name><column-value><![CDATA[");
		sb.append(getSpPersonaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spPersonaAttendeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private long _imageId;
	private long _spPersonaId;
	private long _spCourseId;
	private BaseModel<?> _personaAttendeeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}