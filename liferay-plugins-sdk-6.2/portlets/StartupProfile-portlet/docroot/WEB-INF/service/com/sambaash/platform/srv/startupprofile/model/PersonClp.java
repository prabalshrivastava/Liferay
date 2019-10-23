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

package com.sambaash.platform.srv.startupprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.PersonLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class PersonClp extends BaseModelImpl<Person> implements Person {
	public PersonClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Person.class;
	}

	@Override
	public String getModelClassName() {
		return Person.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _personId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPersonId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _personId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("personId", getPersonId());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("apiPath", getApiPath());
		attributes.put("emailId", getEmailId());
		attributes.put("description", getDescription());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("mobile", getMobile());
		attributes.put("skype", getSkype());
		attributes.put("memberUserId", getMemberUserId());
		attributes.put("extras", getExtras());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String apiPath = (String)attributes.get("apiPath");

		if (apiPath != null) {
			setApiPath(apiPath);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String skype = (String)attributes.get("skype");

		if (skype != null) {
			setSkype(skype);
		}

		Long memberUserId = (Long)attributes.get("memberUserId");

		if (memberUserId != null) {
			setMemberUserId(memberUserId);
		}

		String extras = (String)attributes.get("extras");

		if (extras != null) {
			setExtras(extras);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_personRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPersonId() {
		return _personId;
	}

	@Override
	public void setPersonId(long personId) {
		_personId = personId;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonId", long.class);

				method.invoke(_personRemoteModel, personId);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_personRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_personRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApiPath() {
		return _apiPath;
	}

	@Override
	public void setApiPath(String apiPath) {
		_apiPath = apiPath;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setApiPath", String.class);

				method.invoke(_personRemoteModel, apiPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailId() {
		return _emailId;
	}

	@Override
	public void setEmailId(String emailId) {
		_emailId = emailId;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailId", String.class);

				method.invoke(_personRemoteModel, emailId);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_personRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUrl() {
		return _imageUrl;
	}

	@Override
	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_personRemoteModel, imageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobile() {
		return _mobile;
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setMobile", String.class);

				method.invoke(_personRemoteModel, mobile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSkype() {
		return _skype;
	}

	@Override
	public void setSkype(String skype) {
		_skype = skype;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setSkype", String.class);

				method.invoke(_personRemoteModel, skype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMemberUserId() {
		return _memberUserId;
	}

	@Override
	public void setMemberUserId(long memberUserId) {
		_memberUserId = memberUserId;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberUserId", long.class);

				method.invoke(_personRemoteModel, memberUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMemberUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getMemberUserId(), "uuid",
			_memberUserUuid);
	}

	@Override
	public void setMemberUserUuid(String memberUserUuid) {
		_memberUserUuid = memberUserUuid;
	}

	@Override
	public String getExtras() {
		return _extras;
	}

	@Override
	public void setExtras(String extras) {
		_extras = extras;

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setExtras", String.class);

				method.invoke(_personRemoteModel, extras);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_personRemoteModel, groupId);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_personRemoteModel, companyId);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_personRemoteModel, userId);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_personRemoteModel, userName);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_personRemoteModel, createDate);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_personRemoteModel, modifiedDate);
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

		if (_personRemoteModel != null) {
			try {
				Class<?> clazz = _personRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_personRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Person.class.getName()));
	}

	public BaseModel<?> getPersonRemoteModel() {
		return _personRemoteModel;
	}

	public void setPersonRemoteModel(BaseModel<?> personRemoteModel) {
		_personRemoteModel = personRemoteModel;
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

		Class<?> remoteModelClass = _personRemoteModel.getClass();

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

		Object returnValue = method.invoke(_personRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PersonLocalServiceUtil.addPerson(this);
		}
		else {
			PersonLocalServiceUtil.updatePerson(this);
		}
	}

	@Override
	public Person toEscapedModel() {
		return (Person)ProxyUtil.newProxyInstance(Person.class.getClassLoader(),
			new Class[] { Person.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PersonClp clone = new PersonClp();

		clone.setUuid(getUuid());
		clone.setPersonId(getPersonId());
		clone.setName(getName());
		clone.setTitle(getTitle());
		clone.setApiPath(getApiPath());
		clone.setEmailId(getEmailId());
		clone.setDescription(getDescription());
		clone.setImageUrl(getImageUrl());
		clone.setMobile(getMobile());
		clone.setSkype(getSkype());
		clone.setMemberUserId(getMemberUserId());
		clone.setExtras(getExtras());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(Person person) {
		long primaryKey = person.getPrimaryKey();

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

		if (!(obj instanceof PersonClp)) {
			return false;
		}

		PersonClp person = (PersonClp)obj;

		long primaryKey = person.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", personId=");
		sb.append(getPersonId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", apiPath=");
		sb.append(getApiPath());
		sb.append(", emailId=");
		sb.append(getEmailId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", imageUrl=");
		sb.append(getImageUrl());
		sb.append(", mobile=");
		sb.append(getMobile());
		sb.append(", skype=");
		sb.append(getSkype());
		sb.append(", memberUserId=");
		sb.append(getMemberUserId());
		sb.append(", extras=");
		sb.append(getExtras());
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
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.startupprofile.model.Person");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personId</column-name><column-value><![CDATA[");
		sb.append(getPersonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apiPath</column-name><column-value><![CDATA[");
		sb.append(getApiPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailId</column-name><column-value><![CDATA[");
		sb.append(getEmailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(getMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skype</column-name><column-value><![CDATA[");
		sb.append(getSkype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberUserId</column-name><column-value><![CDATA[");
		sb.append(getMemberUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extras</column-name><column-value><![CDATA[");
		sb.append(getExtras());
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
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _personId;
	private String _name;
	private String _title;
	private String _apiPath;
	private String _emailId;
	private String _description;
	private String _imageUrl;
	private String _mobile;
	private String _skype;
	private long _memberUserId;
	private String _memberUserUuid;
	private String _extras;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private BaseModel<?> _personRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}