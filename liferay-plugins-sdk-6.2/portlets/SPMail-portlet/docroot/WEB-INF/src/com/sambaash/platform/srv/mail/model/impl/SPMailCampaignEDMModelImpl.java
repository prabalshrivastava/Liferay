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

package com.sambaash.platform.srv.mail.model.impl;

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

import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDMModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SPMailCampaignEDM service. Represents a row in the &quot;SPMailCampaignEDM&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.mail.model.SPMailCampaignEDMModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SPMailCampaignEDMImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignEDMImpl
 * @see com.sambaash.platform.srv.mail.model.SPMailCampaignEDM
 * @see com.sambaash.platform.srv.mail.model.SPMailCampaignEDMModel
 * @generated
 */
public class SPMailCampaignEDMModelImpl extends BaseModelImpl<SPMailCampaignEDM>
	implements SPMailCampaignEDMModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s p mail campaign e d m model instance should use the {@link com.sambaash.platform.srv.mail.model.SPMailCampaignEDM} interface instead.
	 */
	public static final String TABLE_NAME = "SPMailCampaignEDM";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spMailCampaignEDMId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "spMailCampaignId", Types.BIGINT },
			{ "spMailTemplateId", Types.BIGINT },
			{ "seqNo", Types.INTEGER },
			{ "dayOfWeek", Types.INTEGER },
			{ "dayOfMonth", Types.INTEGER },
			{ "delayUnit", Types.VARCHAR },
			{ "status", Types.VARCHAR },
			{ "delayAmount", Types.INTEGER },
			{ "croneType", Types.VARCHAR },
			{ "nextScheduleDateTime", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table SPMailCampaignEDM (spMailCampaignEDMId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,name VARCHAR(250) null,spMailCampaignId BIGINT(20),spMailTemplateId BIGINT(20),seqNo INTEGER,dayOfWeek INTEGER,dayOfMonth INTEGER,delayUnit VARCHAR(75) null,status VARCHAR(75) null,delayAmount INTEGER,croneType VARCHAR(75) null,nextScheduleDateTime DATETIME null)";
	public static final String TABLE_SQL_DROP = "drop table SPMailCampaignEDM";
	public static final String ORDER_BY_JPQL = " ORDER BY spMailCampaignEDM.seqNo ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPMailCampaignEDM.seqNo ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.mail.model.SPMailCampaignEDM"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.mail.model.SPMailCampaignEDM"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.mail.model.SPMailCampaignEDM"),
			true);
	public static long SEQNO_COLUMN_BITMASK = 1L;
	public static long SPMAILCAMPAIGNID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.mail.model.SPMailCampaignEDM"));

	public SPMailCampaignEDMModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spMailCampaignEDMId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMailCampaignEDMId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMailCampaignEDMId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailCampaignEDM.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailCampaignEDM.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailCampaignEDMId", getSpMailCampaignEDMId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("spMailTemplateId", getSpMailTemplateId());
		attributes.put("seqNo", getSeqNo());
		attributes.put("dayOfWeek", getDayOfWeek());
		attributes.put("dayOfMonth", getDayOfMonth());
		attributes.put("delayUnit", getDelayUnit());
		attributes.put("status", getStatus());
		attributes.put("delayAmount", getDelayAmount());
		attributes.put("croneType", getCroneType());
		attributes.put("nextScheduleDateTime", getNextScheduleDateTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailCampaignEDMId = (Long)attributes.get("spMailCampaignEDMId");

		if (spMailCampaignEDMId != null) {
			setSpMailCampaignEDMId(spMailCampaignEDMId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		Long spMailTemplateId = (Long)attributes.get("spMailTemplateId");

		if (spMailTemplateId != null) {
			setSpMailTemplateId(spMailTemplateId);
		}

		Integer seqNo = (Integer)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Integer dayOfWeek = (Integer)attributes.get("dayOfWeek");

		if (dayOfWeek != null) {
			setDayOfWeek(dayOfWeek);
		}

		Integer dayOfMonth = (Integer)attributes.get("dayOfMonth");

		if (dayOfMonth != null) {
			setDayOfMonth(dayOfMonth);
		}

		String delayUnit = (String)attributes.get("delayUnit");

		if (delayUnit != null) {
			setDelayUnit(delayUnit);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer delayAmount = (Integer)attributes.get("delayAmount");

		if (delayAmount != null) {
			setDelayAmount(delayAmount);
		}

		String croneType = (String)attributes.get("croneType");

		if (croneType != null) {
			setCroneType(croneType);
		}

		Date nextScheduleDateTime = (Date)attributes.get("nextScheduleDateTime");

		if (nextScheduleDateTime != null) {
			setNextScheduleDateTime(nextScheduleDateTime);
		}
	}

	@Override
	public long getSpMailCampaignEDMId() {
		return _spMailCampaignEDMId;
	}

	@Override
	public void setSpMailCampaignEDMId(long spMailCampaignEDMId) {
		_spMailCampaignEDMId = spMailCampaignEDMId;
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
	public long getSpMailCampaignId() {
		return _spMailCampaignId;
	}

	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_columnBitmask |= SPMAILCAMPAIGNID_COLUMN_BITMASK;

		if (!_setOriginalSpMailCampaignId) {
			_setOriginalSpMailCampaignId = true;

			_originalSpMailCampaignId = _spMailCampaignId;
		}

		_spMailCampaignId = spMailCampaignId;
	}

	public long getOriginalSpMailCampaignId() {
		return _originalSpMailCampaignId;
	}

	@Override
	public long getSpMailTemplateId() {
		return _spMailTemplateId;
	}

	@Override
	public void setSpMailTemplateId(long spMailTemplateId) {
		_spMailTemplateId = spMailTemplateId;
	}

	@Override
	public int getSeqNo() {
		return _seqNo;
	}

	@Override
	public void setSeqNo(int seqNo) {
		_columnBitmask = -1L;

		if (!_setOriginalSeqNo) {
			_setOriginalSeqNo = true;

			_originalSeqNo = _seqNo;
		}

		_seqNo = seqNo;
	}

	public int getOriginalSeqNo() {
		return _originalSeqNo;
	}

	@Override
	public int getDayOfWeek() {
		return _dayOfWeek;
	}

	@Override
	public void setDayOfWeek(int dayOfWeek) {
		_dayOfWeek = dayOfWeek;
	}

	@Override
	public int getDayOfMonth() {
		return _dayOfMonth;
	}

	@Override
	public void setDayOfMonth(int dayOfMonth) {
		_dayOfMonth = dayOfMonth;
	}

	@Override
	public String getDelayUnit() {
		if (_delayUnit == null) {
			return StringPool.BLANK;
		}
		else {
			return _delayUnit;
		}
	}

	@Override
	public void setDelayUnit(String delayUnit) {
		_delayUnit = delayUnit;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	@Override
	public int getDelayAmount() {
		return _delayAmount;
	}

	@Override
	public void setDelayAmount(int delayAmount) {
		_delayAmount = delayAmount;
	}

	@Override
	public String getCroneType() {
		if (_croneType == null) {
			return StringPool.BLANK;
		}
		else {
			return _croneType;
		}
	}

	@Override
	public void setCroneType(String croneType) {
		_croneType = croneType;
	}

	@Override
	public Date getNextScheduleDateTime() {
		return _nextScheduleDateTime;
	}

	@Override
	public void setNextScheduleDateTime(Date nextScheduleDateTime) {
		_nextScheduleDateTime = nextScheduleDateTime;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SPMailCampaignEDM.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SPMailCampaignEDM toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SPMailCampaignEDM)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SPMailCampaignEDMImpl spMailCampaignEDMImpl = new SPMailCampaignEDMImpl();

		spMailCampaignEDMImpl.setSpMailCampaignEDMId(getSpMailCampaignEDMId());
		spMailCampaignEDMImpl.setGroupId(getGroupId());
		spMailCampaignEDMImpl.setCompanyId(getCompanyId());
		spMailCampaignEDMImpl.setUserId(getUserId());
		spMailCampaignEDMImpl.setUserName(getUserName());
		spMailCampaignEDMImpl.setCreateDate(getCreateDate());
		spMailCampaignEDMImpl.setModifiedDate(getModifiedDate());
		spMailCampaignEDMImpl.setName(getName());
		spMailCampaignEDMImpl.setSpMailCampaignId(getSpMailCampaignId());
		spMailCampaignEDMImpl.setSpMailTemplateId(getSpMailTemplateId());
		spMailCampaignEDMImpl.setSeqNo(getSeqNo());
		spMailCampaignEDMImpl.setDayOfWeek(getDayOfWeek());
		spMailCampaignEDMImpl.setDayOfMonth(getDayOfMonth());
		spMailCampaignEDMImpl.setDelayUnit(getDelayUnit());
		spMailCampaignEDMImpl.setStatus(getStatus());
		spMailCampaignEDMImpl.setDelayAmount(getDelayAmount());
		spMailCampaignEDMImpl.setCroneType(getCroneType());
		spMailCampaignEDMImpl.setNextScheduleDateTime(getNextScheduleDateTime());

		spMailCampaignEDMImpl.resetOriginalValues();

		return spMailCampaignEDMImpl;
	}

	@Override
	public int compareTo(SPMailCampaignEDM spMailCampaignEDM) {
		int value = 0;

		if (getSeqNo() < spMailCampaignEDM.getSeqNo()) {
			value = -1;
		}
		else if (getSeqNo() > spMailCampaignEDM.getSeqNo()) {
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

		if (!(obj instanceof SPMailCampaignEDM)) {
			return false;
		}

		SPMailCampaignEDM spMailCampaignEDM = (SPMailCampaignEDM)obj;

		long primaryKey = spMailCampaignEDM.getPrimaryKey();

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
		SPMailCampaignEDMModelImpl spMailCampaignEDMModelImpl = this;

		spMailCampaignEDMModelImpl._originalSpMailCampaignId = spMailCampaignEDMModelImpl._spMailCampaignId;

		spMailCampaignEDMModelImpl._setOriginalSpMailCampaignId = false;

		spMailCampaignEDMModelImpl._originalSeqNo = spMailCampaignEDMModelImpl._seqNo;

		spMailCampaignEDMModelImpl._setOriginalSeqNo = false;

		spMailCampaignEDMModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SPMailCampaignEDM> toCacheModel() {
		SPMailCampaignEDMCacheModel spMailCampaignEDMCacheModel = new SPMailCampaignEDMCacheModel();

		spMailCampaignEDMCacheModel.spMailCampaignEDMId = getSpMailCampaignEDMId();

		spMailCampaignEDMCacheModel.groupId = getGroupId();

		spMailCampaignEDMCacheModel.companyId = getCompanyId();

		spMailCampaignEDMCacheModel.userId = getUserId();

		spMailCampaignEDMCacheModel.userName = getUserName();

		String userName = spMailCampaignEDMCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			spMailCampaignEDMCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			spMailCampaignEDMCacheModel.createDate = createDate.getTime();
		}
		else {
			spMailCampaignEDMCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			spMailCampaignEDMCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			spMailCampaignEDMCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		spMailCampaignEDMCacheModel.name = getName();

		String name = spMailCampaignEDMCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			spMailCampaignEDMCacheModel.name = null;
		}

		spMailCampaignEDMCacheModel.spMailCampaignId = getSpMailCampaignId();

		spMailCampaignEDMCacheModel.spMailTemplateId = getSpMailTemplateId();

		spMailCampaignEDMCacheModel.seqNo = getSeqNo();

		spMailCampaignEDMCacheModel.dayOfWeek = getDayOfWeek();

		spMailCampaignEDMCacheModel.dayOfMonth = getDayOfMonth();

		spMailCampaignEDMCacheModel.delayUnit = getDelayUnit();

		String delayUnit = spMailCampaignEDMCacheModel.delayUnit;

		if ((delayUnit != null) && (delayUnit.length() == 0)) {
			spMailCampaignEDMCacheModel.delayUnit = null;
		}

		spMailCampaignEDMCacheModel.status = getStatus();

		String status = spMailCampaignEDMCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			spMailCampaignEDMCacheModel.status = null;
		}

		spMailCampaignEDMCacheModel.delayAmount = getDelayAmount();

		spMailCampaignEDMCacheModel.croneType = getCroneType();

		String croneType = spMailCampaignEDMCacheModel.croneType;

		if ((croneType != null) && (croneType.length() == 0)) {
			spMailCampaignEDMCacheModel.croneType = null;
		}

		Date nextScheduleDateTime = getNextScheduleDateTime();

		if (nextScheduleDateTime != null) {
			spMailCampaignEDMCacheModel.nextScheduleDateTime = nextScheduleDateTime.getTime();
		}
		else {
			spMailCampaignEDMCacheModel.nextScheduleDateTime = Long.MIN_VALUE;
		}

		return spMailCampaignEDMCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{spMailCampaignEDMId=");
		sb.append(getSpMailCampaignEDMId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", spMailCampaignId=");
		sb.append(getSpMailCampaignId());
		sb.append(", spMailTemplateId=");
		sb.append(getSpMailTemplateId());
		sb.append(", seqNo=");
		sb.append(getSeqNo());
		sb.append(", dayOfWeek=");
		sb.append(getDayOfWeek());
		sb.append(", dayOfMonth=");
		sb.append(getDayOfMonth());
		sb.append(", delayUnit=");
		sb.append(getDelayUnit());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", delayAmount=");
		sb.append(getDelayAmount());
		sb.append(", croneType=");
		sb.append(getCroneType());
		sb.append(", nextScheduleDateTime=");
		sb.append(getNextScheduleDateTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.mail.model.SPMailCampaignEDM");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMailCampaignEDMId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignEDMId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailCampaignId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailTemplateId</column-name><column-value><![CDATA[");
		sb.append(getSpMailTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seqNo</column-name><column-value><![CDATA[");
		sb.append(getSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayOfWeek</column-name><column-value><![CDATA[");
		sb.append(getDayOfWeek());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayOfMonth</column-name><column-value><![CDATA[");
		sb.append(getDayOfMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>delayUnit</column-name><column-value><![CDATA[");
		sb.append(getDelayUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>delayAmount</column-name><column-value><![CDATA[");
		sb.append(getDelayAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>croneType</column-name><column-value><![CDATA[");
		sb.append(getCroneType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextScheduleDateTime</column-name><column-value><![CDATA[");
		sb.append(getNextScheduleDateTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SPMailCampaignEDM.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SPMailCampaignEDM.class
		};
	private long _spMailCampaignEDMId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _spMailCampaignId;
	private long _originalSpMailCampaignId;
	private boolean _setOriginalSpMailCampaignId;
	private long _spMailTemplateId;
	private int _seqNo;
	private int _originalSeqNo;
	private boolean _setOriginalSeqNo;
	private int _dayOfWeek;
	private int _dayOfMonth;
	private String _delayUnit;
	private String _status;
	private int _delayAmount;
	private String _croneType;
	private Date _nextScheduleDateTime;
	private long _columnBitmask;
	private SPMailCampaignEDM _escapedModel;
}