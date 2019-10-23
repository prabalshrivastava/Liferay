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

package com.sambaash.platform.srv.spprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spprofile.service.ClpSerializer;
import com.sambaash.platform.srv.spprofile.service.ProfilePreferencesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class ProfilePreferencesClp extends BaseModelImpl<ProfilePreferences>
	implements ProfilePreferences {
	public ProfilePreferencesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ProfilePreferences.class;
	}

	@Override
	public String getModelClassName() {
		return ProfilePreferences.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _proferenceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProferenceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _proferenceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("proferenceId", getProferenceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("layoutId", getLayoutId());
		attributes.put("portletId", getPortletId());
		attributes.put("preferenceName", getPreferenceName());
		attributes.put("portletPreferences", getPortletPreferences());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long proferenceId = (Long)attributes.get("proferenceId");

		if (proferenceId != null) {
			setProferenceId(proferenceId);
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

		String layoutId = (String)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String preferenceName = (String)attributes.get("preferenceName");

		if (preferenceName != null) {
			setPreferenceName(preferenceName);
		}

		String portletPreferences = (String)attributes.get("portletPreferences");

		if (portletPreferences != null) {
			setPortletPreferences(portletPreferences);
		}
	}

	@Override
	public long getProferenceId() {
		return _proferenceId;
	}

	@Override
	public void setProferenceId(long proferenceId) {
		_proferenceId = proferenceId;

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setProferenceId", long.class);

				method.invoke(_profilePreferencesRemoteModel, proferenceId);
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

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_profilePreferencesRemoteModel, groupId);
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

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_profilePreferencesRemoteModel, companyId);
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

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_profilePreferencesRemoteModel, userId);
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

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_profilePreferencesRemoteModel, userName);
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

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_profilePreferencesRemoteModel, createDate);
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

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_profilePreferencesRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLayoutId() {
		return _layoutId;
	}

	@Override
	public void setLayoutId(String layoutId) {
		_layoutId = layoutId;

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setLayoutId", String.class);

				method.invoke(_profilePreferencesRemoteModel, layoutId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPortletId() {
		return _portletId;
	}

	@Override
	public void setPortletId(String portletId) {
		_portletId = portletId;

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", String.class);

				method.invoke(_profilePreferencesRemoteModel, portletId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPreferenceName() {
		return _preferenceName;
	}

	@Override
	public void setPreferenceName(String preferenceName) {
		_preferenceName = preferenceName;

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setPreferenceName",
						String.class);

				method.invoke(_profilePreferencesRemoteModel, preferenceName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPortletPreferences() {
		return _portletPreferences;
	}

	@Override
	public void setPortletPreferences(String portletPreferences) {
		_portletPreferences = portletPreferences;

		if (_profilePreferencesRemoteModel != null) {
			try {
				Class<?> clazz = _profilePreferencesRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletPreferences",
						String.class);

				method.invoke(_profilePreferencesRemoteModel, portletPreferences);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProfilePreferencesRemoteModel() {
		return _profilePreferencesRemoteModel;
	}

	public void setProfilePreferencesRemoteModel(
		BaseModel<?> profilePreferencesRemoteModel) {
		_profilePreferencesRemoteModel = profilePreferencesRemoteModel;
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

		Class<?> remoteModelClass = _profilePreferencesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_profilePreferencesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProfilePreferencesLocalServiceUtil.addProfilePreferences(this);
		}
		else {
			ProfilePreferencesLocalServiceUtil.updateProfilePreferences(this);
		}
	}

	@Override
	public ProfilePreferences toEscapedModel() {
		return (ProfilePreferences)ProxyUtil.newProxyInstance(ProfilePreferences.class.getClassLoader(),
			new Class[] { ProfilePreferences.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProfilePreferencesClp clone = new ProfilePreferencesClp();

		clone.setProferenceId(getProferenceId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLayoutId(getLayoutId());
		clone.setPortletId(getPortletId());
		clone.setPreferenceName(getPreferenceName());
		clone.setPortletPreferences(getPortletPreferences());

		return clone;
	}

	@Override
	public int compareTo(ProfilePreferences profilePreferences) {
		long primaryKey = profilePreferences.getPrimaryKey();

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

		if (!(obj instanceof ProfilePreferencesClp)) {
			return false;
		}

		ProfilePreferencesClp profilePreferences = (ProfilePreferencesClp)obj;

		long primaryKey = profilePreferences.getPrimaryKey();

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

		sb.append("{proferenceId=");
		sb.append(getProferenceId());
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
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", preferenceName=");
		sb.append(getPreferenceName());
		sb.append(", portletPreferences=");
		sb.append(getPortletPreferences());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spprofile.model.ProfilePreferences");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>proferenceId</column-name><column-value><![CDATA[");
		sb.append(getProferenceId());
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
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preferenceName</column-name><column-value><![CDATA[");
		sb.append(getPreferenceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletPreferences</column-name><column-value><![CDATA[");
		sb.append(getPortletPreferences());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _proferenceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _layoutId;
	private String _portletId;
	private String _preferenceName;
	private String _portletPreferences;
	private BaseModel<?> _profilePreferencesRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spprofile.service.ClpSerializer.class;
}