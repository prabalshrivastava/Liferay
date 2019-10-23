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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPATOContactsClp extends BaseModelImpl<SPATOContacts>
	implements SPATOContacts {
	public SPATOContactsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPATOContacts.class;
	}

	@Override
	public String getModelClassName() {
		return SPATOContacts.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spATOContactId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpATOContactId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spATOContactId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spATOContactId", getSpATOContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("userId", getUserId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("primaryPrincipalUserId", getPrimaryPrincipalUserId());
		attributes.put("secondaryPrincipalUserId", getSecondaryPrincipalUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spATOContactId = (Long)attributes.get("spATOContactId");

		if (spATOContactId != null) {
			setSpATOContactId(spATOContactId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String primaryPrincipalUserId = (String)attributes.get(
				"primaryPrincipalUserId");

		if (primaryPrincipalUserId != null) {
			setPrimaryPrincipalUserId(primaryPrincipalUserId);
		}

		String secondaryPrincipalUserId = (String)attributes.get(
				"secondaryPrincipalUserId");

		if (secondaryPrincipalUserId != null) {
			setSecondaryPrincipalUserId(secondaryPrincipalUserId);
		}
	}

	@Override
	public long getSpATOContactId() {
		return _spATOContactId;
	}

	@Override
	public void setSpATOContactId(long spATOContactId) {
		_spATOContactId = spATOContactId;

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setSpATOContactId", long.class);

				method.invoke(_spatoContactsRemoteModel, spATOContactId);
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

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spatoContactsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_spatoContactsRemoteModel, organizationId);
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

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spatoContactsRemoteModel, userId);
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
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_spatoContactsRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_spatoContactsRemoteModel, lastName);
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

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spatoContactsRemoteModel, createDate);
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

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spatoContactsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrimaryPrincipalUserId() {
		return _primaryPrincipalUserId;
	}

	@Override
	public void setPrimaryPrincipalUserId(String primaryPrincipalUserId) {
		_primaryPrincipalUserId = primaryPrincipalUserId;

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setPrimaryPrincipalUserId",
						String.class);

				method.invoke(_spatoContactsRemoteModel, primaryPrincipalUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecondaryPrincipalUserId() {
		return _secondaryPrincipalUserId;
	}

	@Override
	public void setSecondaryPrincipalUserId(String secondaryPrincipalUserId) {
		_secondaryPrincipalUserId = secondaryPrincipalUserId;

		if (_spatoContactsRemoteModel != null) {
			try {
				Class<?> clazz = _spatoContactsRemoteModel.getClass();

				Method method = clazz.getMethod("setSecondaryPrincipalUserId",
						String.class);

				method.invoke(_spatoContactsRemoteModel,
					secondaryPrincipalUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSecondaryPrincipalUserEmail(
		java.lang.String secondaryPrincipalUserEmail) {
		try {
			String methodName = "setSecondaryPrincipalUserEmail";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { secondaryPrincipalUserEmail };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSecondaryJobTitle() {
		try {
			String methodName = "getSecondaryJobTitle";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSecondaryMobile(java.lang.String secondaryMobile) {
		try {
			String methodName = "setSecondaryMobile";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { secondaryMobile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getPrimaryJobTitle() {
		try {
			String methodName = "getPrimaryJobTitle";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSecondaryPrincipalUserFirstName(
		java.lang.String secondaryPrincipalUserFirstName) {
		try {
			String methodName = "setSecondaryPrincipalUserFirstName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] {
					secondaryPrincipalUserFirstName
				};

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSecondaryPrincipalUserFirstName() {
		try {
			String methodName = "getSecondaryPrincipalUserFirstName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getSecondaryTitleId() {
		try {
			String methodName = "getSecondaryTitleId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSecondaryPrincipalUserEmail() {
		try {
			String methodName = "getSecondaryPrincipalUserEmail";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPrimaryJobTitle(java.lang.String primaryJobTitle) {
		try {
			String methodName = "setPrimaryJobTitle";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { primaryJobTitle };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPrimaryPrincipalUserFirstName(
		java.lang.String primaryPrincipalUserFirstName) {
		try {
			String methodName = "setPrimaryPrincipalUserFirstName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] {
					primaryPrincipalUserFirstName
				};

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSecondaryMobile() {
		try {
			String methodName = "getSecondaryMobile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPrimaryMobile(java.lang.String primaryMobile) {
		try {
			String methodName = "setPrimaryMobile";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { primaryMobile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSecondaryPrincipalUserLastName() {
		try {
			String methodName = "getSecondaryPrincipalUserLastName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPrimaryTitleId(int primaryTitleId) {
		try {
			String methodName = "setPrimaryTitleId";

			Class<?>[] parameterTypes = new Class<?>[] { int.class };

			Object[] parameterValues = new Object[] { primaryTitleId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getPrimaryPrincipalUserFirstName() {
		try {
			String methodName = "getPrimaryPrincipalUserFirstName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSecondaryJobTitle(java.lang.String secondaryJobTitle) {
		try {
			String methodName = "setSecondaryJobTitle";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { secondaryJobTitle };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPrimaryPrincipalUserEmail(
		java.lang.String primaryPrincipalUserEmail) {
		try {
			String methodName = "setPrimaryPrincipalUserEmail";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { primaryPrincipalUserEmail };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getPrimaryMobile() {
		try {
			String methodName = "getPrimaryMobile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSecondaryTitleId(int secondaryTitleId) {
		try {
			String methodName = "setSecondaryTitleId";

			Class<?>[] parameterTypes = new Class<?>[] { int.class };

			Object[] parameterValues = new Object[] { secondaryTitleId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getPrimaryPrincipalUserEmail() {
		try {
			String methodName = "getPrimaryPrincipalUserEmail";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPrimaryPrincipalUserLastName(
		java.lang.String primaryPrincipalUserLastName) {
		try {
			String methodName = "setPrimaryPrincipalUserLastName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { primaryPrincipalUserLastName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getPrimaryPrincipalUserLastName() {
		try {
			String methodName = "getPrimaryPrincipalUserLastName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSecondaryPrincipalUserLastName(
		java.lang.String secondaryPrincipalUserLastName) {
		try {
			String methodName = "setSecondaryPrincipalUserLastName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] {
					secondaryPrincipalUserLastName
				};

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getPrimaryTitleId() {
		try {
			String methodName = "getPrimaryTitleId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSPATOContactsRemoteModel() {
		return _spatoContactsRemoteModel;
	}

	public void setSPATOContactsRemoteModel(
		BaseModel<?> spatoContactsRemoteModel) {
		_spatoContactsRemoteModel = spatoContactsRemoteModel;
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

		Class<?> remoteModelClass = _spatoContactsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spatoContactsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPATOContactsLocalServiceUtil.addSPATOContacts(this);
		}
		else {
			SPATOContactsLocalServiceUtil.updateSPATOContacts(this);
		}
	}

	@Override
	public SPATOContacts toEscapedModel() {
		return (SPATOContacts)ProxyUtil.newProxyInstance(SPATOContacts.class.getClassLoader(),
			new Class[] { SPATOContacts.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPATOContactsClp clone = new SPATOContactsClp();

		clone.setSpATOContactId(getSpATOContactId());
		clone.setGroupId(getGroupId());
		clone.setOrganizationId(getOrganizationId());
		clone.setUserId(getUserId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPrimaryPrincipalUserId(getPrimaryPrincipalUserId());
		clone.setSecondaryPrincipalUserId(getSecondaryPrincipalUserId());

		return clone;
	}

	@Override
	public int compareTo(SPATOContacts spatoContacts) {
		long primaryKey = spatoContacts.getPrimaryKey();

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

		if (!(obj instanceof SPATOContactsClp)) {
			return false;
		}

		SPATOContactsClp spatoContacts = (SPATOContactsClp)obj;

		long primaryKey = spatoContacts.getPrimaryKey();

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

		sb.append("{spATOContactId=");
		sb.append(getSpATOContactId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", primaryPrincipalUserId=");
		sb.append(getPrimaryPrincipalUserId());
		sb.append(", secondaryPrincipalUserId=");
		sb.append(getSecondaryPrincipalUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.SPATOContacts");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spATOContactId</column-name><column-value><![CDATA[");
		sb.append(getSpATOContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
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
			"<column><column-name>primaryPrincipalUserId</column-name><column-value><![CDATA[");
		sb.append(getPrimaryPrincipalUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secondaryPrincipalUserId</column-name><column-value><![CDATA[");
		sb.append(getSecondaryPrincipalUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spATOContactId;
	private long _groupId;
	private long _organizationId;
	private long _userId;
	private String _userUuid;
	private String _firstName;
	private String _lastName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _primaryPrincipalUserId;
	private String _secondaryPrincipalUserId;
	private BaseModel<?> _spatoContactsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}