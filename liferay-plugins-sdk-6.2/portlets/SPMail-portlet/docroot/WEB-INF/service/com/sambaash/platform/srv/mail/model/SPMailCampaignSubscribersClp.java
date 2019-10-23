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

package com.sambaash.platform.srv.mail.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.mail.service.ClpSerializer;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPMailCampaignSubscribersClp extends BaseModelImpl<SPMailCampaignSubscribers>
	implements SPMailCampaignSubscribers {
	public SPMailCampaignSubscribersClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailCampaignSubscribers.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailCampaignSubscribers.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spMailCampaignSubscribersId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMailCampaignSubscribersId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMailCampaignSubscribersId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailCampaignSubscribersId",
			getSpMailCampaignSubscribersId());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("userId", getUserId());
		attributes.put("parentSubscriberId", getParentSubscriberId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("spMailType", getSpMailType());
		attributes.put("messageId", getMessageId());
		attributes.put("opened", getOpened());
		attributes.put("countryName", getCountryName());
		attributes.put("city", getCity());
		attributes.put("regionName", getRegionName());
		attributes.put("areaCode", getAreaCode());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("ipAddress", getIpAddress());
		attributes.put("webVersion", getWebVersion());
		attributes.put("openedDate", getOpenedDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailCampaignSubscribersId = (Long)attributes.get(
				"spMailCampaignSubscribersId");

		if (spMailCampaignSubscribersId != null) {
			setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long parentSubscriberId = (Long)attributes.get("parentSubscriberId");

		if (parentSubscriberId != null) {
			setParentSubscriberId(parentSubscriberId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Integer spMailType = (Integer)attributes.get("spMailType");

		if (spMailType != null) {
			setSpMailType(spMailType);
		}

		String messageId = (String)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Boolean opened = (Boolean)attributes.get("opened");

		if (opened != null) {
			setOpened(opened);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String regionName = (String)attributes.get("regionName");

		if (regionName != null) {
			setRegionName(regionName);
		}

		Integer areaCode = (Integer)attributes.get("areaCode");

		if (areaCode != null) {
			setAreaCode(areaCode);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}

		Boolean webVersion = (Boolean)attributes.get("webVersion");

		if (webVersion != null) {
			setWebVersion(webVersion);
		}

		Date openedDate = (Date)attributes.get("openedDate");

		if (openedDate != null) {
			setOpenedDate(openedDate);
		}

		Long createBy = (Long)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getSpMailCampaignSubscribersId() {
		return _spMailCampaignSubscribersId;
	}

	@Override
	public void setSpMailCampaignSubscribersId(long spMailCampaignSubscribersId) {
		_spMailCampaignSubscribersId = spMailCampaignSubscribersId;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignSubscribersId",
						long.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel,
					spMailCampaignSubscribersId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpMailCampaignId() {
		return _spMailCampaignId;
	}

	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignId = spMailCampaignId;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignId",
						long.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel,
					spMailCampaignId);
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

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, userId);
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
	public long getParentSubscriberId() {
		return _parentSubscriberId;
	}

	@Override
	public void setParentSubscriberId(long parentSubscriberId) {
		_parentSubscriberId = parentSubscriberId;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setParentSubscriberId",
						long.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel,
					parentSubscriberId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel,
					emailAddress);
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

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, firstName);
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

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSpMailType() {
		return _spMailType;
	}

	@Override
	public void setSpMailType(int spMailType) {
		_spMailType = spMailType;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailType", int.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, spMailType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(String messageId) {
		_messageId = messageId;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageId", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, messageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getOpened() {
		return _opened;
	}

	@Override
	public boolean isOpened() {
		return _opened;
	}

	@Override
	public void setOpened(boolean opened) {
		_opened = opened;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setOpened", boolean.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, opened);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryName() {
		return _countryName;
	}

	@Override
	public void setCountryName(String countryName) {
		_countryName = countryName;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryName", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, countryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionName() {
		return _regionName;
	}

	@Override
	public void setRegionName(String regionName) {
		_regionName = regionName;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionName", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, regionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAreaCode() {
		return _areaCode;
	}

	@Override
	public void setAreaCode(int areaCode) {
		_areaCode = areaCode;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setAreaCode", int.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, areaCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(String latitude) {
		_latitude = latitude;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(String longitude) {
		_longitude = longitude;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIpAddress() {
		return _ipAddress;
	}

	@Override
	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setIpAddress", String.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, ipAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getWebVersion() {
		return _webVersion;
	}

	@Override
	public boolean isWebVersion() {
		return _webVersion;
	}

	@Override
	public void setWebVersion(boolean webVersion) {
		_webVersion = webVersion;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setWebVersion", boolean.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, webVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getOpenedDate() {
		return _openedDate;
	}

	@Override
	public void setOpenedDate(Date openedDate) {
		_openedDate = openedDate;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setOpenedDate", Date.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, openedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateBy() {
		return _createBy;
	}

	@Override
	public void setCreateBy(long createBy) {
		_createBy = createBy;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateBy", long.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, createBy);
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

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, modifiedBy);
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

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel,
					modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_spMailCampaignSubscribersRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignSubscribersRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_spMailCampaignSubscribersRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPMailCampaignSubscribersRemoteModel() {
		return _spMailCampaignSubscribersRemoteModel;
	}

	public void setSPMailCampaignSubscribersRemoteModel(
		BaseModel<?> spMailCampaignSubscribersRemoteModel) {
		_spMailCampaignSubscribersRemoteModel = spMailCampaignSubscribersRemoteModel;
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

		Class<?> remoteModelClass = _spMailCampaignSubscribersRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spMailCampaignSubscribersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailCampaignSubscribersLocalServiceUtil.addSPMailCampaignSubscribers(this);
		}
		else {
			SPMailCampaignSubscribersLocalServiceUtil.updateSPMailCampaignSubscribers(this);
		}
	}

	@Override
	public SPMailCampaignSubscribers toEscapedModel() {
		return (SPMailCampaignSubscribers)ProxyUtil.newProxyInstance(SPMailCampaignSubscribers.class.getClassLoader(),
			new Class[] { SPMailCampaignSubscribers.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPMailCampaignSubscribersClp clone = new SPMailCampaignSubscribersClp();

		clone.setSpMailCampaignSubscribersId(getSpMailCampaignSubscribersId());
		clone.setSpMailCampaignId(getSpMailCampaignId());
		clone.setUserId(getUserId());
		clone.setParentSubscriberId(getParentSubscriberId());
		clone.setEmailAddress(getEmailAddress());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setSpMailType(getSpMailType());
		clone.setMessageId(getMessageId());
		clone.setOpened(getOpened());
		clone.setCountryName(getCountryName());
		clone.setCity(getCity());
		clone.setRegionName(getRegionName());
		clone.setAreaCode(getAreaCode());
		clone.setLatitude(getLatitude());
		clone.setLongitude(getLongitude());
		clone.setIpAddress(getIpAddress());
		clone.setWebVersion(getWebVersion());
		clone.setOpenedDate(getOpenedDate());
		clone.setCreateBy(getCreateBy());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedBy(getModifiedBy());
		clone.setModifiedDate(getModifiedDate());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(SPMailCampaignSubscribers spMailCampaignSubscribers) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				spMailCampaignSubscribers.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof SPMailCampaignSubscribersClp)) {
			return false;
		}

		SPMailCampaignSubscribersClp spMailCampaignSubscribers = (SPMailCampaignSubscribersClp)obj;

		long primaryKey = spMailCampaignSubscribers.getPrimaryKey();

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
		StringBundler sb = new StringBundler(49);

		sb.append("{spMailCampaignSubscribersId=");
		sb.append(getSpMailCampaignSubscribersId());
		sb.append(", spMailCampaignId=");
		sb.append(getSpMailCampaignId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", parentSubscriberId=");
		sb.append(getParentSubscriberId());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", spMailType=");
		sb.append(getSpMailType());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", opened=");
		sb.append(getOpened());
		sb.append(", countryName=");
		sb.append(getCountryName());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", regionName=");
		sb.append(getRegionName());
		sb.append(", areaCode=");
		sb.append(getAreaCode());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", ipAddress=");
		sb.append(getIpAddress());
		sb.append(", webVersion=");
		sb.append(getWebVersion());
		sb.append(", openedDate=");
		sb.append(getOpenedDate());
		sb.append(", createBy=");
		sb.append(getCreateBy());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMailCampaignSubscribersId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignSubscribersId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailCampaignId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentSubscriberId</column-name><column-value><![CDATA[");
		sb.append(getParentSubscriberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
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
			"<column><column-name>spMailType</column-name><column-value><![CDATA[");
		sb.append(getSpMailType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>opened</column-name><column-value><![CDATA[");
		sb.append(getOpened());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryName</column-name><column-value><![CDATA[");
		sb.append(getCountryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionName</column-name><column-value><![CDATA[");
		sb.append(getRegionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>areaCode</column-name><column-value><![CDATA[");
		sb.append(getAreaCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipAddress</column-name><column-value><![CDATA[");
		sb.append(getIpAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webVersion</column-name><column-value><![CDATA[");
		sb.append(getWebVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openedDate</column-name><column-value><![CDATA[");
		sb.append(getOpenedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createBy</column-name><column-value><![CDATA[");
		sb.append(getCreateBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spMailCampaignSubscribersId;
	private long _spMailCampaignId;
	private long _userId;
	private String _userUuid;
	private long _parentSubscriberId;
	private String _emailAddress;
	private String _firstName;
	private String _lastName;
	private int _spMailType;
	private String _messageId;
	private boolean _opened;
	private String _countryName;
	private String _city;
	private String _regionName;
	private int _areaCode;
	private String _latitude;
	private String _longitude;
	private String _ipAddress;
	private boolean _webVersion;
	private Date _openedDate;
	private long _createBy;
	private Date _createDate;
	private long _modifiedBy;
	private Date _modifiedDate;
	private int _status;
	private BaseModel<?> _spMailCampaignSubscribersRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}