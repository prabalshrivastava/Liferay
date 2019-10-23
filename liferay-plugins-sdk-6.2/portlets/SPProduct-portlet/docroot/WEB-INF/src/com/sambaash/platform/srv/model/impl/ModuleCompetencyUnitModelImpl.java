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

import com.sambaash.platform.srv.model.ModuleCompetencyUnit;
import com.sambaash.platform.srv.model.ModuleCompetencyUnitModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ModuleCompetencyUnit service. Represents a row in the &quot;SPModuleCompetencyUnit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.model.ModuleCompetencyUnitModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ModuleCompetencyUnitImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleCompetencyUnitImpl
 * @see com.sambaash.platform.srv.model.ModuleCompetencyUnit
 * @see com.sambaash.platform.srv.model.ModuleCompetencyUnitModel
 * @generated
 */
public class ModuleCompetencyUnitModelImpl extends BaseModelImpl<ModuleCompetencyUnit>
	implements ModuleCompetencyUnitModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a module competency unit model instance should use the {@link com.sambaash.platform.srv.model.ModuleCompetencyUnit} interface instead.
	 */
	public static final String TABLE_NAME = "SPModuleCompetencyUnit";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spModuleCompetencyUnitId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "spModuleId", Types.BIGINT },
			{ "spCompetencyUnitId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPModuleCompetencyUnit (spModuleCompetencyUnitId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,spModuleId BIGINT(20),spCompetencyUnitId BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPModuleCompetencyUnit";
	public static final String ORDER_BY_JPQL = " ORDER BY moduleCompetencyUnit.spModuleId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPModuleCompetencyUnit.spModuleId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.model.ModuleCompetencyUnit"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.model.ModuleCompetencyUnit"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.model.ModuleCompetencyUnit"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long SPCOMPETENCYUNITID_COLUMN_BITMASK = 2L;
	public static long SPMODULEID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.model.ModuleCompetencyUnit"));

	public ModuleCompetencyUnitModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spModuleCompetencyUnitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpModuleCompetencyUnitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spModuleCompetencyUnitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ModuleCompetencyUnit.class;
	}

	@Override
	public String getModelClassName() {
		return ModuleCompetencyUnit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spModuleCompetencyUnitId", getSpModuleCompetencyUnitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("spCompetencyUnitId", getSpCompetencyUnitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spModuleCompetencyUnitId = (Long)attributes.get(
				"spModuleCompetencyUnitId");

		if (spModuleCompetencyUnitId != null) {
			setSpModuleCompetencyUnitId(spModuleCompetencyUnitId);
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

		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
		}

		Long spCompetencyUnitId = (Long)attributes.get("spCompetencyUnitId");

		if (spCompetencyUnitId != null) {
			setSpCompetencyUnitId(spCompetencyUnitId);
		}
	}

	@Override
	public long getSpModuleCompetencyUnitId() {
		return _spModuleCompetencyUnitId;
	}

	@Override
	public void setSpModuleCompetencyUnitId(long spModuleCompetencyUnitId) {
		_spModuleCompetencyUnitId = spModuleCompetencyUnitId;
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
	public long getSpModuleId() {
		return _spModuleId;
	}

	@Override
	public void setSpModuleId(long spModuleId) {
		_columnBitmask = -1L;

		if (!_setOriginalSpModuleId) {
			_setOriginalSpModuleId = true;

			_originalSpModuleId = _spModuleId;
		}

		_spModuleId = spModuleId;
	}

	public long getOriginalSpModuleId() {
		return _originalSpModuleId;
	}

	@Override
	public long getSpCompetencyUnitId() {
		return _spCompetencyUnitId;
	}

	@Override
	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_columnBitmask |= SPCOMPETENCYUNITID_COLUMN_BITMASK;

		if (!_setOriginalSpCompetencyUnitId) {
			_setOriginalSpCompetencyUnitId = true;

			_originalSpCompetencyUnitId = _spCompetencyUnitId;
		}

		_spCompetencyUnitId = spCompetencyUnitId;
	}

	public long getOriginalSpCompetencyUnitId() {
		return _originalSpCompetencyUnitId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ModuleCompetencyUnit.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ModuleCompetencyUnit toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ModuleCompetencyUnit)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ModuleCompetencyUnitImpl moduleCompetencyUnitImpl = new ModuleCompetencyUnitImpl();

		moduleCompetencyUnitImpl.setSpModuleCompetencyUnitId(getSpModuleCompetencyUnitId());
		moduleCompetencyUnitImpl.setGroupId(getGroupId());
		moduleCompetencyUnitImpl.setCompanyId(getCompanyId());
		moduleCompetencyUnitImpl.setUserId(getUserId());
		moduleCompetencyUnitImpl.setUserName(getUserName());
		moduleCompetencyUnitImpl.setCreateDate(getCreateDate());
		moduleCompetencyUnitImpl.setModifiedDate(getModifiedDate());
		moduleCompetencyUnitImpl.setSpModuleId(getSpModuleId());
		moduleCompetencyUnitImpl.setSpCompetencyUnitId(getSpCompetencyUnitId());

		moduleCompetencyUnitImpl.resetOriginalValues();

		return moduleCompetencyUnitImpl;
	}

	@Override
	public int compareTo(ModuleCompetencyUnit moduleCompetencyUnit) {
		int value = 0;

		if (getSpModuleId() < moduleCompetencyUnit.getSpModuleId()) {
			value = -1;
		}
		else if (getSpModuleId() > moduleCompetencyUnit.getSpModuleId()) {
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

		if (!(obj instanceof ModuleCompetencyUnit)) {
			return false;
		}

		ModuleCompetencyUnit moduleCompetencyUnit = (ModuleCompetencyUnit)obj;

		long primaryKey = moduleCompetencyUnit.getPrimaryKey();

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
		ModuleCompetencyUnitModelImpl moduleCompetencyUnitModelImpl = this;

		moduleCompetencyUnitModelImpl._originalGroupId = moduleCompetencyUnitModelImpl._groupId;

		moduleCompetencyUnitModelImpl._setOriginalGroupId = false;

		moduleCompetencyUnitModelImpl._originalSpModuleId = moduleCompetencyUnitModelImpl._spModuleId;

		moduleCompetencyUnitModelImpl._setOriginalSpModuleId = false;

		moduleCompetencyUnitModelImpl._originalSpCompetencyUnitId = moduleCompetencyUnitModelImpl._spCompetencyUnitId;

		moduleCompetencyUnitModelImpl._setOriginalSpCompetencyUnitId = false;

		moduleCompetencyUnitModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ModuleCompetencyUnit> toCacheModel() {
		ModuleCompetencyUnitCacheModel moduleCompetencyUnitCacheModel = new ModuleCompetencyUnitCacheModel();

		moduleCompetencyUnitCacheModel.spModuleCompetencyUnitId = getSpModuleCompetencyUnitId();

		moduleCompetencyUnitCacheModel.groupId = getGroupId();

		moduleCompetencyUnitCacheModel.companyId = getCompanyId();

		moduleCompetencyUnitCacheModel.userId = getUserId();

		moduleCompetencyUnitCacheModel.userName = getUserName();

		String userName = moduleCompetencyUnitCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			moduleCompetencyUnitCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			moduleCompetencyUnitCacheModel.createDate = createDate.getTime();
		}
		else {
			moduleCompetencyUnitCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			moduleCompetencyUnitCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			moduleCompetencyUnitCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		moduleCompetencyUnitCacheModel.spModuleId = getSpModuleId();

		moduleCompetencyUnitCacheModel.spCompetencyUnitId = getSpCompetencyUnitId();

		return moduleCompetencyUnitCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{spModuleCompetencyUnitId=");
		sb.append(getSpModuleCompetencyUnitId());
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
		sb.append(", spModuleId=");
		sb.append(getSpModuleId());
		sb.append(", spCompetencyUnitId=");
		sb.append(getSpCompetencyUnitId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.ModuleCompetencyUnit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spModuleCompetencyUnitId</column-name><column-value><![CDATA[");
		sb.append(getSpModuleCompetencyUnitId());
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
			"<column><column-name>spModuleId</column-name><column-value><![CDATA[");
		sb.append(getSpModuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCompetencyUnitId</column-name><column-value><![CDATA[");
		sb.append(getSpCompetencyUnitId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ModuleCompetencyUnit.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ModuleCompetencyUnit.class
		};
	private long _spModuleCompetencyUnitId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private long _originalSpModuleId;
	private boolean _setOriginalSpModuleId;
	private long _spCompetencyUnitId;
	private long _originalSpCompetencyUnitId;
	private boolean _setOriginalSpCompetencyUnitId;
	private long _columnBitmask;
	private ModuleCompetencyUnit _escapedModel;
}