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

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sambaash.platform.srv.startupprofile.model.FundingRound;
import com.sambaash.platform.srv.startupprofile.model.FundingRoundModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the FundingRound service. Represents a row in the &quot;SPFundingRounds&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.startupprofile.model.FundingRoundModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FundingRoundImpl}.
 * </p>
 *
 * @author pradeep
 * @see FundingRoundImpl
 * @see com.sambaash.platform.srv.startupprofile.model.FundingRound
 * @see com.sambaash.platform.srv.startupprofile.model.FundingRoundModel
 * @generated
 */
public class FundingRoundModelImpl extends BaseModelImpl<FundingRound>
	implements FundingRoundModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a funding round model instance should use the {@link com.sambaash.platform.srv.startupprofile.model.FundingRound} interface instead.
	 */
	public static final String TABLE_NAME = "SPFundingRounds";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "fundingRoundId", Types.BIGINT },
			{ "organizationId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "apiPath", Types.VARCHAR },
			{ "imageUrl", Types.VARCHAR },
			{ "announcedOn", Types.VARCHAR },
			{ "moneyRaisedInUsd", Types.VARCHAR },
			{ "fundingType", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "active_", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table SPFundingRounds (uuid_ VARCHAR(75) null,fundingRoundId BIGINT(20) not null primary key,organizationId BIGINT(20),name VARCHAR(100) null,apiPath VARCHAR(120) null,imageUrl VARCHAR(200) null,announcedOn VARCHAR(15) null,moneyRaisedInUsd VARCHAR(20) null,fundingType VARCHAR(50) null,description LONGTEXT null,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table SPFundingRounds";
	public static final String ORDER_BY_JPQL = " ORDER BY fundingRound.fundingRoundId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPFundingRounds.fundingRoundId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.startupprofile.model.FundingRound"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.startupprofile.model.FundingRound"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.startupprofile.model.FundingRound"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;
	public static long FUNDINGROUNDID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.startupprofile.model.FundingRound"));

	public FundingRoundModelImpl() {
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
	public Class<?> getModelClass() {
		return FundingRound.class;
	}

	@Override
	public String getModelClassName() {
		return FundingRound.class.getName();
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
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getFundingRoundId() {
		return _fundingRoundId;
	}

	@Override
	public void setFundingRoundId(long fundingRoundId) {
		_fundingRoundId = fundingRoundId;
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getApiPath() {
		if (_apiPath == null) {
			return StringPool.BLANK;
		}
		else {
			return _apiPath;
		}
	}

	@Override
	public void setApiPath(String apiPath) {
		_apiPath = apiPath;
	}

	@Override
	public String getImageUrl() {
		if (_imageUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageUrl;
		}
	}

	@Override
	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	@Override
	public String getAnnouncedOn() {
		if (_announcedOn == null) {
			return StringPool.BLANK;
		}
		else {
			return _announcedOn;
		}
	}

	@Override
	public void setAnnouncedOn(String announcedOn) {
		_announcedOn = announcedOn;
	}

	@Override
	public String getMoneyRaisedInUsd() {
		if (_moneyRaisedInUsd == null) {
			return StringPool.BLANK;
		}
		else {
			return _moneyRaisedInUsd;
		}
	}

	@Override
	public void setMoneyRaisedInUsd(String moneyRaisedInUsd) {
		_moneyRaisedInUsd = moneyRaisedInUsd;
	}

	@Override
	public String getFundingType() {
		if (_fundingType == null) {
			return StringPool.BLANK;
		}
		else {
			return _fundingType;
		}
	}

	@Override
	public void setFundingType(String fundingType) {
		_fundingType = fundingType;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				FundingRound.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			FundingRound.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FundingRound toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FundingRound)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FundingRoundImpl fundingRoundImpl = new FundingRoundImpl();

		fundingRoundImpl.setUuid(getUuid());
		fundingRoundImpl.setFundingRoundId(getFundingRoundId());
		fundingRoundImpl.setOrganizationId(getOrganizationId());
		fundingRoundImpl.setName(getName());
		fundingRoundImpl.setApiPath(getApiPath());
		fundingRoundImpl.setImageUrl(getImageUrl());
		fundingRoundImpl.setAnnouncedOn(getAnnouncedOn());
		fundingRoundImpl.setMoneyRaisedInUsd(getMoneyRaisedInUsd());
		fundingRoundImpl.setFundingType(getFundingType());
		fundingRoundImpl.setDescription(getDescription());
		fundingRoundImpl.setGroupId(getGroupId());
		fundingRoundImpl.setCompanyId(getCompanyId());
		fundingRoundImpl.setUserId(getUserId());
		fundingRoundImpl.setUserName(getUserName());
		fundingRoundImpl.setCreateDate(getCreateDate());
		fundingRoundImpl.setModifiedDate(getModifiedDate());
		fundingRoundImpl.setActive(getActive());

		fundingRoundImpl.resetOriginalValues();

		return fundingRoundImpl;
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

		if (!(obj instanceof FundingRound)) {
			return false;
		}

		FundingRound fundingRound = (FundingRound)obj;

		long primaryKey = fundingRound.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		FundingRoundModelImpl fundingRoundModelImpl = this;

		fundingRoundModelImpl._originalUuid = fundingRoundModelImpl._uuid;

		fundingRoundModelImpl._originalGroupId = fundingRoundModelImpl._groupId;

		fundingRoundModelImpl._setOriginalGroupId = false;

		fundingRoundModelImpl._originalCompanyId = fundingRoundModelImpl._companyId;

		fundingRoundModelImpl._setOriginalCompanyId = false;

		fundingRoundModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FundingRound> toCacheModel() {
		FundingRoundCacheModel fundingRoundCacheModel = new FundingRoundCacheModel();

		fundingRoundCacheModel.uuid = getUuid();

		String uuid = fundingRoundCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			fundingRoundCacheModel.uuid = null;
		}

		fundingRoundCacheModel.fundingRoundId = getFundingRoundId();

		fundingRoundCacheModel.organizationId = getOrganizationId();

		fundingRoundCacheModel.name = getName();

		String name = fundingRoundCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			fundingRoundCacheModel.name = null;
		}

		fundingRoundCacheModel.apiPath = getApiPath();

		String apiPath = fundingRoundCacheModel.apiPath;

		if ((apiPath != null) && (apiPath.length() == 0)) {
			fundingRoundCacheModel.apiPath = null;
		}

		fundingRoundCacheModel.imageUrl = getImageUrl();

		String imageUrl = fundingRoundCacheModel.imageUrl;

		if ((imageUrl != null) && (imageUrl.length() == 0)) {
			fundingRoundCacheModel.imageUrl = null;
		}

		fundingRoundCacheModel.announcedOn = getAnnouncedOn();

		String announcedOn = fundingRoundCacheModel.announcedOn;

		if ((announcedOn != null) && (announcedOn.length() == 0)) {
			fundingRoundCacheModel.announcedOn = null;
		}

		fundingRoundCacheModel.moneyRaisedInUsd = getMoneyRaisedInUsd();

		String moneyRaisedInUsd = fundingRoundCacheModel.moneyRaisedInUsd;

		if ((moneyRaisedInUsd != null) && (moneyRaisedInUsd.length() == 0)) {
			fundingRoundCacheModel.moneyRaisedInUsd = null;
		}

		fundingRoundCacheModel.fundingType = getFundingType();

		String fundingType = fundingRoundCacheModel.fundingType;

		if ((fundingType != null) && (fundingType.length() == 0)) {
			fundingRoundCacheModel.fundingType = null;
		}

		fundingRoundCacheModel.description = getDescription();

		String description = fundingRoundCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			fundingRoundCacheModel.description = null;
		}

		fundingRoundCacheModel.groupId = getGroupId();

		fundingRoundCacheModel.companyId = getCompanyId();

		fundingRoundCacheModel.userId = getUserId();

		fundingRoundCacheModel.userName = getUserName();

		String userName = fundingRoundCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			fundingRoundCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			fundingRoundCacheModel.createDate = createDate.getTime();
		}
		else {
			fundingRoundCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			fundingRoundCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			fundingRoundCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		fundingRoundCacheModel.active = getActive();

		return fundingRoundCacheModel;
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

	private static ClassLoader _classLoader = FundingRound.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FundingRound.class
		};
	private String _uuid;
	private String _originalUuid;
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
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private long _columnBitmask;
	private FundingRound _escapedModel;
}