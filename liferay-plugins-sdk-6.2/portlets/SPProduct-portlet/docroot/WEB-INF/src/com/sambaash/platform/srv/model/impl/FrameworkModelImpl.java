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

package com.sambaash.platform.srv.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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

import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.FrameworkModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Framework service. Represents a row in the &quot;SPFramework&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.model.FrameworkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FrameworkImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see FrameworkImpl
 * @see com.sambaash.platform.srv.model.Framework
 * @see com.sambaash.platform.srv.model.FrameworkModel
 * @generated
 */
public class FrameworkModelImpl extends BaseModelImpl<Framework>
	implements FrameworkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a framework model instance should use the {@link com.sambaash.platform.srv.model.Framework} interface instead.
	 */
	public static final String TABLE_NAME = "SPFramework";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spFrameworkId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "countryId", Types.BIGINT },
			{ "frameworkCode", Types.VARCHAR },
			{ "frameworkName", Types.VARCHAR },
			{ "frameworkImageId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPFramework (spFrameworkId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,countryId BIGINT(20),frameworkCode VARCHAR(75) null,frameworkName LONGTEXT null,frameworkImageId BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPFramework";
	public static final String ORDER_BY_JPQL = " ORDER BY framework.frameworkName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPFramework.frameworkName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.model.Framework"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.model.Framework"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.model.Framework"),
			true);
	public static long COUNTRYID_COLUMN_BITMASK = 1L;
	public static long FRAMEWORKCODE_COLUMN_BITMASK = 2L;
	public static long FRAMEWORKNAME_COLUMN_BITMASK = 4L;
	public static long GROUPID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.model.Framework"));

	public FrameworkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spFrameworkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpFrameworkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spFrameworkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Framework.class;
	}

	@Override
	public String getModelClassName() {
		return Framework.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFrameworkId", getSpFrameworkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("frameworkCode", getFrameworkCode());
		attributes.put("frameworkName", getFrameworkName());
		attributes.put("frameworkImageId", getFrameworkImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFrameworkId = (Long)attributes.get("spFrameworkId");

		if (spFrameworkId != null) {
			setSpFrameworkId(spFrameworkId);
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

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String frameworkCode = (String)attributes.get("frameworkCode");

		if (frameworkCode != null) {
			setFrameworkCode(frameworkCode);
		}

		String frameworkName = (String)attributes.get("frameworkName");

		if (frameworkName != null) {
			setFrameworkName(frameworkName);
		}

		Long frameworkImageId = (Long)attributes.get("frameworkImageId");

		if (frameworkImageId != null) {
			setFrameworkImageId(frameworkImageId);
		}
	}

	@Override
	public long getSpFrameworkId() {
		return _spFrameworkId;
	}

	@Override
	public void setSpFrameworkId(long spFrameworkId) {
		_spFrameworkId = spFrameworkId;
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
		_companyId = companyId;
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
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_columnBitmask |= COUNTRYID_COLUMN_BITMASK;

		if (!_setOriginalCountryId) {
			_setOriginalCountryId = true;

			_originalCountryId = _countryId;
		}

		_countryId = countryId;
	}

	public long getOriginalCountryId() {
		return _originalCountryId;
	}

	@Override
	public String getFrameworkCode() {
		if (_frameworkCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _frameworkCode;
		}
	}

	@Override
	public void setFrameworkCode(String frameworkCode) {
		_columnBitmask |= FRAMEWORKCODE_COLUMN_BITMASK;

		if (_originalFrameworkCode == null) {
			_originalFrameworkCode = _frameworkCode;
		}

		_frameworkCode = frameworkCode;
	}

	public String getOriginalFrameworkCode() {
		return GetterUtil.getString(_originalFrameworkCode);
	}

	@Override
	public String getFrameworkName() {
		if (_frameworkName == null) {
			return StringPool.BLANK;
		}
		else {
			return _frameworkName;
		}
	}

	@Override
	public void setFrameworkName(String frameworkName) {
		_columnBitmask = -1L;

		if (_originalFrameworkName == null) {
			_originalFrameworkName = _frameworkName;
		}

		_frameworkName = frameworkName;
	}

	public String getOriginalFrameworkName() {
		return GetterUtil.getString(_originalFrameworkName);
	}

	@Override
	public Long getFrameworkImageId() {
		return _frameworkImageId;
	}

	@Override
	public void setFrameworkImageId(Long frameworkImageId) {
		_frameworkImageId = frameworkImageId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Framework.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Framework toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Framework)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FrameworkImpl frameworkImpl = new FrameworkImpl();

		frameworkImpl.setSpFrameworkId(getSpFrameworkId());
		frameworkImpl.setGroupId(getGroupId());
		frameworkImpl.setCompanyId(getCompanyId());
		frameworkImpl.setUserId(getUserId());
		frameworkImpl.setUserName(getUserName());
		frameworkImpl.setCreateDate(getCreateDate());
		frameworkImpl.setModifiedDate(getModifiedDate());
		frameworkImpl.setCountryId(getCountryId());
		frameworkImpl.setFrameworkCode(getFrameworkCode());
		frameworkImpl.setFrameworkName(getFrameworkName());
		frameworkImpl.setFrameworkImageId(getFrameworkImageId());

		frameworkImpl.resetOriginalValues();

		return frameworkImpl;
	}

	@Override
	public int compareTo(Framework framework) {
		int value = 0;

		value = getFrameworkName().compareTo(framework.getFrameworkName());

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

		if (!(obj instanceof Framework)) {
			return false;
		}

		Framework framework = (Framework)obj;

		long primaryKey = framework.getPrimaryKey();

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
		FrameworkModelImpl frameworkModelImpl = this;

		frameworkModelImpl._originalGroupId = frameworkModelImpl._groupId;

		frameworkModelImpl._setOriginalGroupId = false;

		frameworkModelImpl._originalCountryId = frameworkModelImpl._countryId;

		frameworkModelImpl._setOriginalCountryId = false;

		frameworkModelImpl._originalFrameworkCode = frameworkModelImpl._frameworkCode;

		frameworkModelImpl._originalFrameworkName = frameworkModelImpl._frameworkName;

		frameworkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Framework> toCacheModel() {
		FrameworkCacheModel frameworkCacheModel = new FrameworkCacheModel();

		frameworkCacheModel.spFrameworkId = getSpFrameworkId();

		frameworkCacheModel.groupId = getGroupId();

		frameworkCacheModel.companyId = getCompanyId();

		frameworkCacheModel.userId = getUserId();

		frameworkCacheModel.userName = getUserName();

		String userName = frameworkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			frameworkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			frameworkCacheModel.createDate = createDate.getTime();
		}
		else {
			frameworkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			frameworkCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			frameworkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		frameworkCacheModel.countryId = getCountryId();

		frameworkCacheModel.frameworkCode = getFrameworkCode();

		String frameworkCode = frameworkCacheModel.frameworkCode;

		if ((frameworkCode != null) && (frameworkCode.length() == 0)) {
			frameworkCacheModel.frameworkCode = null;
		}

		frameworkCacheModel.frameworkName = getFrameworkName();

		String frameworkName = frameworkCacheModel.frameworkName;

		if ((frameworkName != null) && (frameworkName.length() == 0)) {
			frameworkCacheModel.frameworkName = null;
		}

		frameworkCacheModel.frameworkImageId = getFrameworkImageId();

		return frameworkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spFrameworkId=");
		sb.append(getSpFrameworkId());
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
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", frameworkCode=");
		sb.append(getFrameworkCode());
		sb.append(", frameworkName=");
		sb.append(getFrameworkName());
		sb.append(", frameworkImageId=");
		sb.append(getFrameworkImageId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Framework");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spFrameworkId</column-name><column-value><![CDATA[");
		sb.append(getSpFrameworkId());
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
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frameworkCode</column-name><column-value><![CDATA[");
		sb.append(getFrameworkCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frameworkName</column-name><column-value><![CDATA[");
		sb.append(getFrameworkName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frameworkImageId</column-name><column-value><![CDATA[");
		sb.append(getFrameworkImageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Framework.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Framework.class
		};
	private long _spFrameworkId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private long _originalCountryId;
	private boolean _setOriginalCountryId;
	private String _frameworkCode;
	private String _originalFrameworkCode;
	private String _frameworkName;
	private String _originalFrameworkName;
	private Long _frameworkImageId;
	private long _columnBitmask;
	private Framework _escapedModel;
}