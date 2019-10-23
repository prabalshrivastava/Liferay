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

package com.sambaash.platform.srv.spsocialprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileFriendsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SocialProfileFriendsClp extends BaseModelImpl<SocialProfileFriends>
	implements SocialProfileFriends {
	public SocialProfileFriendsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfileFriends.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfileFriends.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _socialProfileFriendsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSocialProfileFriendsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _socialProfileFriendsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("socialProfileFriendsId", getSocialProfileFriendsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("belongsToUserId", getBelongsToUserId());
		attributes.put("socialNetworkProfileId", getSocialNetworkProfileId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("birthday", getBirthday());
		attributes.put("location", getLocation());
		attributes.put("pictureUrl", getPictureUrl());
		attributes.put("userName", getUserName());
		attributes.put("gender", getGender());
		attributes.put("socialNetworkType", getSocialNetworkType());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long socialProfileFriendsId = (Long)attributes.get(
				"socialProfileFriendsId");

		if (socialProfileFriendsId != null) {
			setSocialProfileFriendsId(socialProfileFriendsId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long belongsToUserId = (Long)attributes.get("belongsToUserId");

		if (belongsToUserId != null) {
			setBelongsToUserId(belongsToUserId);
		}

		Long socialNetworkProfileId = (Long)attributes.get(
				"socialNetworkProfileId");

		if (socialNetworkProfileId != null) {
			setSocialNetworkProfileId(socialNetworkProfileId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String birthday = (String)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String pictureUrl = (String)attributes.get("pictureUrl");

		if (pictureUrl != null) {
			setPictureUrl(pictureUrl);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Integer socialNetworkType = (Integer)attributes.get("socialNetworkType");

		if (socialNetworkType != null) {
			setSocialNetworkType(socialNetworkType);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getSocialProfileFriendsId() {
		return _socialProfileFriendsId;
	}

	@Override
	public void setSocialProfileFriendsId(long socialProfileFriendsId) {
		_socialProfileFriendsId = socialProfileFriendsId;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialProfileFriendsId",
						long.class);

				method.invoke(_socialProfileFriendsRemoteModel,
					socialProfileFriendsId);
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

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_socialProfileFriendsRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBelongsToUserId() {
		return _belongsToUserId;
	}

	@Override
	public void setBelongsToUserId(long belongsToUserId) {
		_belongsToUserId = belongsToUserId;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setBelongsToUserId", long.class);

				method.invoke(_socialProfileFriendsRemoteModel, belongsToUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBelongsToUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getBelongsToUserId(), "uuid",
			_belongsToUserUuid);
	}

	@Override
	public void setBelongsToUserUuid(String belongsToUserUuid) {
		_belongsToUserUuid = belongsToUserUuid;
	}

	@Override
	public long getSocialNetworkProfileId() {
		return _socialNetworkProfileId;
	}

	@Override
	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_socialNetworkProfileId = socialNetworkProfileId;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialNetworkProfileId",
						long.class);

				method.invoke(_socialProfileFriendsRemoteModel,
					socialNetworkProfileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_socialProfileFriendsRemoteModel, firstName);
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

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_socialProfileFriendsRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBirthday() {
		return _birthday;
	}

	@Override
	public void setBirthday(String birthday) {
		_birthday = birthday;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setBirthday", String.class);

				method.invoke(_socialProfileFriendsRemoteModel, birthday);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_socialProfileFriendsRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPictureUrl() {
		return _pictureUrl;
	}

	@Override
	public void setPictureUrl(String pictureUrl) {
		_pictureUrl = pictureUrl;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setPictureUrl", String.class);

				method.invoke(_socialProfileFriendsRemoteModel, pictureUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_socialProfileFriendsRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGender() {
		return _gender;
	}

	@Override
	public void setGender(int gender) {
		_gender = gender;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", int.class);

				method.invoke(_socialProfileFriendsRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSocialNetworkType() {
		return _socialNetworkType;
	}

	@Override
	public void setSocialNetworkType(int socialNetworkType) {
		_socialNetworkType = socialNetworkType;

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialNetworkType",
						int.class);

				method.invoke(_socialProfileFriendsRemoteModel,
					socialNetworkType);
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

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_socialProfileFriendsRemoteModel, createDate);
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

		if (_socialProfileFriendsRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileFriendsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_socialProfileFriendsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSocialProfileFriendsRemoteModel() {
		return _socialProfileFriendsRemoteModel;
	}

	public void setSocialProfileFriendsRemoteModel(
		BaseModel<?> socialProfileFriendsRemoteModel) {
		_socialProfileFriendsRemoteModel = socialProfileFriendsRemoteModel;
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

		Class<?> remoteModelClass = _socialProfileFriendsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_socialProfileFriendsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SocialProfileFriendsLocalServiceUtil.addSocialProfileFriends(this);
		}
		else {
			SocialProfileFriendsLocalServiceUtil.updateSocialProfileFriends(this);
		}
	}

	@Override
	public SocialProfileFriends toEscapedModel() {
		return (SocialProfileFriends)ProxyUtil.newProxyInstance(SocialProfileFriends.class.getClassLoader(),
			new Class[] { SocialProfileFriends.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SocialProfileFriendsClp clone = new SocialProfileFriendsClp();

		clone.setSocialProfileFriendsId(getSocialProfileFriendsId());
		clone.setCompanyId(getCompanyId());
		clone.setBelongsToUserId(getBelongsToUserId());
		clone.setSocialNetworkProfileId(getSocialNetworkProfileId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setBirthday(getBirthday());
		clone.setLocation(getLocation());
		clone.setPictureUrl(getPictureUrl());
		clone.setUserName(getUserName());
		clone.setGender(getGender());
		clone.setSocialNetworkType(getSocialNetworkType());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SocialProfileFriends socialProfileFriends) {
		long primaryKey = socialProfileFriends.getPrimaryKey();

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

		if (!(obj instanceof SocialProfileFriendsClp)) {
			return false;
		}

		SocialProfileFriendsClp socialProfileFriends = (SocialProfileFriendsClp)obj;

		long primaryKey = socialProfileFriends.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{socialProfileFriendsId=");
		sb.append(getSocialProfileFriendsId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", belongsToUserId=");
		sb.append(getBelongsToUserId());
		sb.append(", socialNetworkProfileId=");
		sb.append(getSocialNetworkProfileId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", pictureUrl=");
		sb.append(getPictureUrl());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", socialNetworkType=");
		sb.append(getSocialNetworkType());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>socialProfileFriendsId</column-name><column-value><![CDATA[");
		sb.append(getSocialProfileFriendsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>belongsToUserId</column-name><column-value><![CDATA[");
		sb.append(getBelongsToUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialNetworkProfileId</column-name><column-value><![CDATA[");
		sb.append(getSocialNetworkProfileId());
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
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pictureUrl</column-name><column-value><![CDATA[");
		sb.append(getPictureUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialNetworkType</column-name><column-value><![CDATA[");
		sb.append(getSocialNetworkType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _socialProfileFriendsId;
	private long _companyId;
	private long _belongsToUserId;
	private String _belongsToUserUuid;
	private long _socialNetworkProfileId;
	private String _firstName;
	private String _lastName;
	private String _birthday;
	private String _location;
	private String _pictureUrl;
	private String _userName;
	private int _gender;
	private int _socialNetworkType;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _socialProfileFriendsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.class;
}