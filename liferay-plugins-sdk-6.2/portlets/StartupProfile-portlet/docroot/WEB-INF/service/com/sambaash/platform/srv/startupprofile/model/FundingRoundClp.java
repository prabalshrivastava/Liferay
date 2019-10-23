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
import com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class FundingRoundClp extends BaseModelImpl<FundingRound>
	implements FundingRound {
	public FundingRoundClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FundingRound.class;
	}

	@Override
	public String getModelClassName() {
		return FundingRound.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _fundingRoundId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFundingRoundId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fundingRoundId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fundingRoundId", getFundingRoundId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("name", getName());
		attributes.put("apiPath", getApiPath());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("announcedOn", getAnnouncedOn());
		attributes.put("moneyRaisedInUsd", getMoneyRaisedInUsd());
		attributes.put("fundingType", getFundingType());
		attributes.put("description", getDescription());
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

		Long fundingRoundId = (Long)attributes.get("fundingRoundId");

		if (fundingRoundId != null) {
			setFundingRoundId(fundingRoundId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String apiPath = (String)attributes.get("apiPath");

		if (apiPath != null) {
			setApiPath(apiPath);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String announcedOn = (String)attributes.get("announcedOn");

		if (announcedOn != null) {
			setAnnouncedOn(announcedOn);
		}

		String moneyRaisedInUsd = (String)attributes.get("moneyRaisedInUsd");

		if (moneyRaisedInUsd != null) {
			setMoneyRaisedInUsd(moneyRaisedInUsd);
		}

		String fundingType = (String)attributes.get("fundingType");

		if (fundingType != null) {
			setFundingType(fundingType);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_fundingRoundRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFundingRoundId() {
		return _fundingRoundId;
	}

	@Override
	public void setFundingRoundId(long fundingRoundId) {
		_fundingRoundId = fundingRoundId;

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingRoundId", long.class);

				method.invoke(_fundingRoundRemoteModel, fundingRoundId);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_fundingRoundRemoteModel, organizationId);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_fundingRoundRemoteModel, name);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setApiPath", String.class);

				method.invoke(_fundingRoundRemoteModel, apiPath);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_fundingRoundRemoteModel, imageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnnouncedOn() {
		return _announcedOn;
	}

	@Override
	public void setAnnouncedOn(String announcedOn) {
		_announcedOn = announcedOn;

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setAnnouncedOn", String.class);

				method.invoke(_fundingRoundRemoteModel, announcedOn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMoneyRaisedInUsd() {
		return _moneyRaisedInUsd;
	}

	@Override
	public void setMoneyRaisedInUsd(String moneyRaisedInUsd) {
		_moneyRaisedInUsd = moneyRaisedInUsd;

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setMoneyRaisedInUsd",
						String.class);

				method.invoke(_fundingRoundRemoteModel, moneyRaisedInUsd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFundingType() {
		return _fundingType;
	}

	@Override
	public void setFundingType(String fundingType) {
		_fundingType = fundingType;

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingType", String.class);

				method.invoke(_fundingRoundRemoteModel, fundingType);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_fundingRoundRemoteModel, description);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_fundingRoundRemoteModel, groupId);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_fundingRoundRemoteModel, companyId);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_fundingRoundRemoteModel, userId);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_fundingRoundRemoteModel, userName);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_fundingRoundRemoteModel, createDate);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_fundingRoundRemoteModel, modifiedDate);
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

		if (_fundingRoundRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRoundRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_fundingRoundRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				FundingRound.class.getName()));
	}

	public BaseModel<?> getFundingRoundRemoteModel() {
		return _fundingRoundRemoteModel;
	}

	public void setFundingRoundRemoteModel(BaseModel<?> fundingRoundRemoteModel) {
		_fundingRoundRemoteModel = fundingRoundRemoteModel;
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

		Class<?> remoteModelClass = _fundingRoundRemoteModel.getClass();

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

		Object returnValue = method.invoke(_fundingRoundRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FundingRoundLocalServiceUtil.addFundingRound(this);
		}
		else {
			FundingRoundLocalServiceUtil.updateFundingRound(this);
		}
	}

	@Override
	public FundingRound toEscapedModel() {
		return (FundingRound)ProxyUtil.newProxyInstance(FundingRound.class.getClassLoader(),
			new Class[] { FundingRound.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FundingRoundClp clone = new FundingRoundClp();

		clone.setUuid(getUuid());
		clone.setFundingRoundId(getFundingRoundId());
		clone.setOrganizationId(getOrganizationId());
		clone.setName(getName());
		clone.setApiPath(getApiPath());
		clone.setImageUrl(getImageUrl());
		clone.setAnnouncedOn(getAnnouncedOn());
		clone.setMoneyRaisedInUsd(getMoneyRaisedInUsd());
		clone.setFundingType(getFundingType());
		clone.setDescription(getDescription());
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
	public int compareTo(FundingRound fundingRound) {
		long primaryKey = fundingRound.getPrimaryKey();

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

		if (!(obj instanceof FundingRoundClp)) {
			return false;
		}

		FundingRoundClp fundingRound = (FundingRoundClp)obj;

		long primaryKey = fundingRound.getPrimaryKey();

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
		sb.append(", fundingRoundId=");
		sb.append(getFundingRoundId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", apiPath=");
		sb.append(getApiPath());
		sb.append(", imageUrl=");
		sb.append(getImageUrl());
		sb.append(", announcedOn=");
		sb.append(getAnnouncedOn());
		sb.append(", moneyRaisedInUsd=");
		sb.append(getMoneyRaisedInUsd());
		sb.append(", fundingType=");
		sb.append(getFundingType());
		sb.append(", description=");
		sb.append(getDescription());
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
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.startupprofile.model.FundingRound");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingRoundId</column-name><column-value><![CDATA[");
		sb.append(getFundingRoundId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apiPath</column-name><column-value><![CDATA[");
		sb.append(getApiPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>announcedOn</column-name><column-value><![CDATA[");
		sb.append(getAnnouncedOn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moneyRaisedInUsd</column-name><column-value><![CDATA[");
		sb.append(getMoneyRaisedInUsd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingType</column-name><column-value><![CDATA[");
		sb.append(getFundingType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
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
	private long _fundingRoundId;
	private long _organizationId;
	private String _name;
	private String _apiPath;
	private String _imageUrl;
	private String _announcedOn;
	private String _moneyRaisedInUsd;
	private String _fundingType;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private BaseModel<?> _fundingRoundRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}