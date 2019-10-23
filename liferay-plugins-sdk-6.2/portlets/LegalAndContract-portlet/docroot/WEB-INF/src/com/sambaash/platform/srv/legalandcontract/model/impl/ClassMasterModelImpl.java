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

package com.sambaash.platform.srv.legalandcontract.model.impl;

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

import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;
import com.sambaash.platform.srv.legalandcontract.model.ClassMasterModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ClassMaster service. Represents a row in the &quot;SPClassMaster&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.legalandcontract.model.ClassMasterModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ClassMasterImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see ClassMasterImpl
 * @see com.sambaash.platform.srv.legalandcontract.model.ClassMaster
 * @see com.sambaash.platform.srv.legalandcontract.model.ClassMasterModel
 * @generated
 */
public class ClassMasterModelImpl extends BaseModelImpl<ClassMaster>
	implements ClassMasterModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a class master model instance should use the {@link com.sambaash.platform.srv.legalandcontract.model.ClassMaster} interface instead.
	 */
	public static final String TABLE_NAME = "SPClassMaster";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "spClassId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "code_", Types.VARCHAR },
			{ "country", Types.VARCHAR },
			{ "filedBy", Types.VARCHAR },
			{ "customField1", Types.VARCHAR },
			{ "customField2", Types.VARCHAR },
			{ "customDate1", Types.TIMESTAMP },
			{ "customDate2", Types.TIMESTAMP },
			{ "version", Types.VARCHAR },
			{ "rootSpClassId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPClassMaster (uuid_ VARCHAR(75) null,spClassId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,code_ VARCHAR(75) null,country VARCHAR(75) null,filedBy VARCHAR(75) null,customField1 VARCHAR(75) null,customField2 VARCHAR(75) null,customDate1 DATETIME null,customDate2 DATETIME null,version VARCHAR(75) null,rootSpClassId BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPClassMaster";
	public static final String ORDER_BY_JPQL = " ORDER BY classMaster.spClassId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPClassMaster.spClassId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.legalandcontract.model.ClassMaster"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.legalandcontract.model.ClassMaster"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.legalandcontract.model.ClassMaster"),
			true);
	public static long CODE_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long COUNTRY_COLUMN_BITMASK = 4L;
	public static long GROUPID_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;
	public static long SPCLASSID_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.legalandcontract.model.ClassMaster"));

	public ClassMasterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spClassId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpClassId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spClassId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ClassMaster.class;
	}

	@Override
	public String getModelClassName() {
		return ClassMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spClassId", getSpClassId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("country", getCountry());
		attributes.put("filedBy", getFiledBy());
		attributes.put("customField1", getCustomField1());
		attributes.put("customField2", getCustomField2());
		attributes.put("customDate1", getCustomDate1());
		attributes.put("customDate2", getCustomDate2());
		attributes.put("version", getVersion());
		attributes.put("rootSpClassId", getRootSpClassId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spClassId = (Long)attributes.get("spClassId");

		if (spClassId != null) {
			setSpClassId(spClassId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String filedBy = (String)attributes.get("filedBy");

		if (filedBy != null) {
			setFiledBy(filedBy);
		}

		String customField1 = (String)attributes.get("customField1");

		if (customField1 != null) {
			setCustomField1(customField1);
		}

		String customField2 = (String)attributes.get("customField2");

		if (customField2 != null) {
			setCustomField2(customField2);
		}

		Date customDate1 = (Date)attributes.get("customDate1");

		if (customDate1 != null) {
			setCustomDate1(customDate1);
		}

		Date customDate2 = (Date)attributes.get("customDate2");

		if (customDate2 != null) {
			setCustomDate2(customDate2);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long rootSpClassId = (Long)attributes.get("rootSpClassId");

		if (rootSpClassId != null) {
			setRootSpClassId(rootSpClassId);
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
	public long getSpClassId() {
		return _spClassId;
	}

	@Override
	public void setSpClassId(long spClassId) {
		_spClassId = spClassId;
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
	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		_columnBitmask |= CODE_COLUMN_BITMASK;

		if (_originalCode == null) {
			_originalCode = _code;
		}

		_code = code;
	}

	public String getOriginalCode() {
		return GetterUtil.getString(_originalCode);
	}

	@Override
	public String getCountry() {
		if (_country == null) {
			return StringPool.BLANK;
		}
		else {
			return _country;
		}
	}

	@Override
	public void setCountry(String country) {
		_columnBitmask |= COUNTRY_COLUMN_BITMASK;

		if (_originalCountry == null) {
			_originalCountry = _country;
		}

		_country = country;
	}

	public String getOriginalCountry() {
		return GetterUtil.getString(_originalCountry);
	}

	@Override
	public String getFiledBy() {
		if (_filedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _filedBy;
		}
	}

	@Override
	public void setFiledBy(String filedBy) {
		_filedBy = filedBy;
	}

	@Override
	public String getCustomField1() {
		if (_customField1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _customField1;
		}
	}

	@Override
	public void setCustomField1(String customField1) {
		_customField1 = customField1;
	}

	@Override
	public String getCustomField2() {
		if (_customField2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _customField2;
		}
	}

	@Override
	public void setCustomField2(String customField2) {
		_customField2 = customField2;
	}

	@Override
	public Date getCustomDate1() {
		return _customDate1;
	}

	@Override
	public void setCustomDate1(Date customDate1) {
		_customDate1 = customDate1;
	}

	@Override
	public Date getCustomDate2() {
		return _customDate2;
	}

	@Override
	public void setCustomDate2(Date customDate2) {
		_customDate2 = customDate2;
	}

	@Override
	public String getVersion() {
		if (_version == null) {
			return StringPool.BLANK;
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		_version = version;
	}

	@Override
	public long getRootSpClassId() {
		return _rootSpClassId;
	}

	@Override
	public void setRootSpClassId(long rootSpClassId) {
		_rootSpClassId = rootSpClassId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ClassMaster.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ClassMaster.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ClassMaster toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ClassMaster)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ClassMasterImpl classMasterImpl = new ClassMasterImpl();

		classMasterImpl.setUuid(getUuid());
		classMasterImpl.setSpClassId(getSpClassId());
		classMasterImpl.setGroupId(getGroupId());
		classMasterImpl.setCompanyId(getCompanyId());
		classMasterImpl.setUserId(getUserId());
		classMasterImpl.setUserName(getUserName());
		classMasterImpl.setCreateDate(getCreateDate());
		classMasterImpl.setModifiedDate(getModifiedDate());
		classMasterImpl.setCode(getCode());
		classMasterImpl.setCountry(getCountry());
		classMasterImpl.setFiledBy(getFiledBy());
		classMasterImpl.setCustomField1(getCustomField1());
		classMasterImpl.setCustomField2(getCustomField2());
		classMasterImpl.setCustomDate1(getCustomDate1());
		classMasterImpl.setCustomDate2(getCustomDate2());
		classMasterImpl.setVersion(getVersion());
		classMasterImpl.setRootSpClassId(getRootSpClassId());

		classMasterImpl.resetOriginalValues();

		return classMasterImpl;
	}

	@Override
	public int compareTo(ClassMaster classMaster) {
		long primaryKey = classMaster.getPrimaryKey();

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

		if (!(obj instanceof ClassMaster)) {
			return false;
		}

		ClassMaster classMaster = (ClassMaster)obj;

		long primaryKey = classMaster.getPrimaryKey();

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
		ClassMasterModelImpl classMasterModelImpl = this;

		classMasterModelImpl._originalUuid = classMasterModelImpl._uuid;

		classMasterModelImpl._originalGroupId = classMasterModelImpl._groupId;

		classMasterModelImpl._setOriginalGroupId = false;

		classMasterModelImpl._originalCompanyId = classMasterModelImpl._companyId;

		classMasterModelImpl._setOriginalCompanyId = false;

		classMasterModelImpl._originalCode = classMasterModelImpl._code;

		classMasterModelImpl._originalCountry = classMasterModelImpl._country;

		classMasterModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ClassMaster> toCacheModel() {
		ClassMasterCacheModel classMasterCacheModel = new ClassMasterCacheModel();

		classMasterCacheModel.uuid = getUuid();

		String uuid = classMasterCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			classMasterCacheModel.uuid = null;
		}

		classMasterCacheModel.spClassId = getSpClassId();

		classMasterCacheModel.groupId = getGroupId();

		classMasterCacheModel.companyId = getCompanyId();

		classMasterCacheModel.userId = getUserId();

		classMasterCacheModel.userName = getUserName();

		String userName = classMasterCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			classMasterCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			classMasterCacheModel.createDate = createDate.getTime();
		}
		else {
			classMasterCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			classMasterCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			classMasterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		classMasterCacheModel.code = getCode();

		String code = classMasterCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			classMasterCacheModel.code = null;
		}

		classMasterCacheModel.country = getCountry();

		String country = classMasterCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			classMasterCacheModel.country = null;
		}

		classMasterCacheModel.filedBy = getFiledBy();

		String filedBy = classMasterCacheModel.filedBy;

		if ((filedBy != null) && (filedBy.length() == 0)) {
			classMasterCacheModel.filedBy = null;
		}

		classMasterCacheModel.customField1 = getCustomField1();

		String customField1 = classMasterCacheModel.customField1;

		if ((customField1 != null) && (customField1.length() == 0)) {
			classMasterCacheModel.customField1 = null;
		}

		classMasterCacheModel.customField2 = getCustomField2();

		String customField2 = classMasterCacheModel.customField2;

		if ((customField2 != null) && (customField2.length() == 0)) {
			classMasterCacheModel.customField2 = null;
		}

		Date customDate1 = getCustomDate1();

		if (customDate1 != null) {
			classMasterCacheModel.customDate1 = customDate1.getTime();
		}
		else {
			classMasterCacheModel.customDate1 = Long.MIN_VALUE;
		}

		Date customDate2 = getCustomDate2();

		if (customDate2 != null) {
			classMasterCacheModel.customDate2 = customDate2.getTime();
		}
		else {
			classMasterCacheModel.customDate2 = Long.MIN_VALUE;
		}

		classMasterCacheModel.version = getVersion();

		String version = classMasterCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			classMasterCacheModel.version = null;
		}

		classMasterCacheModel.rootSpClassId = getRootSpClassId();

		return classMasterCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spClassId=");
		sb.append(getSpClassId());
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
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", filedBy=");
		sb.append(getFiledBy());
		sb.append(", customField1=");
		sb.append(getCustomField1());
		sb.append(", customField2=");
		sb.append(getCustomField2());
		sb.append(", customDate1=");
		sb.append(getCustomDate1());
		sb.append(", customDate2=");
		sb.append(getCustomDate2());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", rootSpClassId=");
		sb.append(getRootSpClassId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.legalandcontract.model.ClassMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spClassId</column-name><column-value><![CDATA[");
		sb.append(getSpClassId());
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
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filedBy</column-name><column-value><![CDATA[");
		sb.append(getFiledBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField1</column-name><column-value><![CDATA[");
		sb.append(getCustomField1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField2</column-name><column-value><![CDATA[");
		sb.append(getCustomField2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate1</column-name><column-value><![CDATA[");
		sb.append(getCustomDate1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate2</column-name><column-value><![CDATA[");
		sb.append(getCustomDate2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootSpClassId</column-name><column-value><![CDATA[");
		sb.append(getRootSpClassId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ClassMaster.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ClassMaster.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _spClassId;
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
	private String _code;
	private String _originalCode;
	private String _country;
	private String _originalCountry;
	private String _filedBy;
	private String _customField1;
	private String _customField2;
	private Date _customDate1;
	private Date _customDate2;
	private String _version;
	private long _rootSpClassId;
	private long _columnBitmask;
	private ClassMaster _escapedModel;
}