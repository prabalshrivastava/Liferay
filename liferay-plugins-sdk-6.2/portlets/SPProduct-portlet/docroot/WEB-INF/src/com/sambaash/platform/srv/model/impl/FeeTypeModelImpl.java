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

import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.FeeTypeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the FeeType service. Represents a row in the &quot;SPFeeType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.model.FeeTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FeeTypeImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see FeeTypeImpl
 * @see com.sambaash.platform.srv.model.FeeType
 * @see com.sambaash.platform.srv.model.FeeTypeModel
 * @generated
 */
public class FeeTypeModelImpl extends BaseModelImpl<FeeType>
	implements FeeTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fee type model instance should use the {@link com.sambaash.platform.srv.model.FeeType} interface instead.
	 */
	public static final String TABLE_NAME = "SPFeeType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spFeeTypeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "feeType", Types.VARCHAR },
			{ "feeTypeName", Types.VARCHAR },
			{ "feeTypeDesc", Types.VARCHAR },
			{ "misc", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table SPFeeType (spFeeTypeId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,feeType VARCHAR(75) null,feeTypeName VARCHAR(75) null,feeTypeDesc VARCHAR(75) null,misc BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table SPFeeType";
	public static final String ORDER_BY_JPQL = " ORDER BY feeType.spFeeTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPFeeType.spFeeTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.model.FeeType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.model.FeeType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.model.FeeType"),
			true);
	public static long FEETYPENAME_COLUMN_BITMASK = 1L;
	public static long MISC_COLUMN_BITMASK = 2L;
	public static long SPFEETYPEID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.model.FeeType"));

	public FeeTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spFeeTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpFeeTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spFeeTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FeeType.class;
	}

	@Override
	public String getModelClassName() {
		return FeeType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFeeTypeId", getSpFeeTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("feeType", getFeeType());
		attributes.put("feeTypeName", getFeeTypeName());
		attributes.put("feeTypeDesc", getFeeTypeDesc());
		attributes.put("misc", getMisc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFeeTypeId = (Long)attributes.get("spFeeTypeId");

		if (spFeeTypeId != null) {
			setSpFeeTypeId(spFeeTypeId);
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

		String feeType = (String)attributes.get("feeType");

		if (feeType != null) {
			setFeeType(feeType);
		}

		String feeTypeName = (String)attributes.get("feeTypeName");

		if (feeTypeName != null) {
			setFeeTypeName(feeTypeName);
		}

		String feeTypeDesc = (String)attributes.get("feeTypeDesc");

		if (feeTypeDesc != null) {
			setFeeTypeDesc(feeTypeDesc);
		}

		Boolean misc = (Boolean)attributes.get("misc");

		if (misc != null) {
			setMisc(misc);
		}
	}

	@Override
	public long getSpFeeTypeId() {
		return _spFeeTypeId;
	}

	@Override
	public void setSpFeeTypeId(long spFeeTypeId) {
		_spFeeTypeId = spFeeTypeId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
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
	public String getFeeType() {
		if (_feeType == null) {
			return StringPool.BLANK;
		}
		else {
			return _feeType;
		}
	}

	@Override
	public void setFeeType(String feeType) {
		_feeType = feeType;
	}

	@Override
	public String getFeeTypeName() {
		if (_feeTypeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _feeTypeName;
		}
	}

	@Override
	public void setFeeTypeName(String feeTypeName) {
		_columnBitmask |= FEETYPENAME_COLUMN_BITMASK;

		if (_originalFeeTypeName == null) {
			_originalFeeTypeName = _feeTypeName;
		}

		_feeTypeName = feeTypeName;
	}

	public String getOriginalFeeTypeName() {
		return GetterUtil.getString(_originalFeeTypeName);
	}

	@Override
	public String getFeeTypeDesc() {
		if (_feeTypeDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _feeTypeDesc;
		}
	}

	@Override
	public void setFeeTypeDesc(String feeTypeDesc) {
		_feeTypeDesc = feeTypeDesc;
	}

	@Override
	public boolean getMisc() {
		return _misc;
	}

	@Override
	public boolean isMisc() {
		return _misc;
	}

	@Override
	public void setMisc(boolean misc) {
		_columnBitmask |= MISC_COLUMN_BITMASK;

		if (!_setOriginalMisc) {
			_setOriginalMisc = true;

			_originalMisc = _misc;
		}

		_misc = misc;
	}

	public boolean getOriginalMisc() {
		return _originalMisc;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			FeeType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FeeType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FeeType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FeeTypeImpl feeTypeImpl = new FeeTypeImpl();

		feeTypeImpl.setSpFeeTypeId(getSpFeeTypeId());
		feeTypeImpl.setGroupId(getGroupId());
		feeTypeImpl.setCompanyId(getCompanyId());
		feeTypeImpl.setUserId(getUserId());
		feeTypeImpl.setUserName(getUserName());
		feeTypeImpl.setCreateDate(getCreateDate());
		feeTypeImpl.setModifiedDate(getModifiedDate());
		feeTypeImpl.setFeeType(getFeeType());
		feeTypeImpl.setFeeTypeName(getFeeTypeName());
		feeTypeImpl.setFeeTypeDesc(getFeeTypeDesc());
		feeTypeImpl.setMisc(getMisc());

		feeTypeImpl.resetOriginalValues();

		return feeTypeImpl;
	}

	@Override
	public int compareTo(FeeType feeType) {
		long primaryKey = feeType.getPrimaryKey();

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

		if (!(obj instanceof FeeType)) {
			return false;
		}

		FeeType feeType = (FeeType)obj;

		long primaryKey = feeType.getPrimaryKey();

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
		FeeTypeModelImpl feeTypeModelImpl = this;

		feeTypeModelImpl._originalFeeTypeName = feeTypeModelImpl._feeTypeName;

		feeTypeModelImpl._originalMisc = feeTypeModelImpl._misc;

		feeTypeModelImpl._setOriginalMisc = false;

		feeTypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FeeType> toCacheModel() {
		FeeTypeCacheModel feeTypeCacheModel = new FeeTypeCacheModel();

		feeTypeCacheModel.spFeeTypeId = getSpFeeTypeId();

		feeTypeCacheModel.groupId = getGroupId();

		feeTypeCacheModel.companyId = getCompanyId();

		feeTypeCacheModel.userId = getUserId();

		feeTypeCacheModel.userName = getUserName();

		String userName = feeTypeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			feeTypeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			feeTypeCacheModel.createDate = createDate.getTime();
		}
		else {
			feeTypeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			feeTypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			feeTypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		feeTypeCacheModel.feeType = getFeeType();

		String feeType = feeTypeCacheModel.feeType;

		if ((feeType != null) && (feeType.length() == 0)) {
			feeTypeCacheModel.feeType = null;
		}

		feeTypeCacheModel.feeTypeName = getFeeTypeName();

		String feeTypeName = feeTypeCacheModel.feeTypeName;

		if ((feeTypeName != null) && (feeTypeName.length() == 0)) {
			feeTypeCacheModel.feeTypeName = null;
		}

		feeTypeCacheModel.feeTypeDesc = getFeeTypeDesc();

		String feeTypeDesc = feeTypeCacheModel.feeTypeDesc;

		if ((feeTypeDesc != null) && (feeTypeDesc.length() == 0)) {
			feeTypeCacheModel.feeTypeDesc = null;
		}

		feeTypeCacheModel.misc = getMisc();

		return feeTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spFeeTypeId=");
		sb.append(getSpFeeTypeId());
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
		sb.append(", feeType=");
		sb.append(getFeeType());
		sb.append(", feeTypeName=");
		sb.append(getFeeTypeName());
		sb.append(", feeTypeDesc=");
		sb.append(getFeeTypeDesc());
		sb.append(", misc=");
		sb.append(getMisc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.FeeType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spFeeTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpFeeTypeId());
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
			"<column><column-name>feeType</column-name><column-value><![CDATA[");
		sb.append(getFeeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feeTypeName</column-name><column-value><![CDATA[");
		sb.append(getFeeTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feeTypeDesc</column-name><column-value><![CDATA[");
		sb.append(getFeeTypeDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>misc</column-name><column-value><![CDATA[");
		sb.append(getMisc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FeeType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FeeType.class
		};
	private long _spFeeTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _feeType;
	private String _feeTypeName;
	private String _originalFeeTypeName;
	private String _feeTypeDesc;
	private boolean _misc;
	private boolean _originalMisc;
	private boolean _setOriginalMisc;
	private long _columnBitmask;
	private FeeType _escapedModel;
}