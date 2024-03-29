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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices;
import com.sambaash.platform.srv.spservices.model.MembershipPackageIndServicesModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the MembershipPackageIndServices service. Represents a row in the &quot;SPMembershipPackageIndServices&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.spservices.model.MembershipPackageIndServicesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MembershipPackageIndServicesImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageIndServicesImpl
 * @see com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices
 * @see com.sambaash.platform.srv.spservices.model.MembershipPackageIndServicesModel
 * @generated
 */
public class MembershipPackageIndServicesModelImpl extends BaseModelImpl<MembershipPackageIndServices>
	implements MembershipPackageIndServicesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a membership package ind services model instance should use the {@link com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices} interface instead.
	 */
	public static final String TABLE_NAME = "SPMembershipPackageIndServices";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mpgsscId", Types.BIGINT },
			{ "mpId", Types.BIGINT },
			{ "scorder", Types.VARCHAR },
			{ "scgId", Types.VARCHAR },
			{ "scId", Types.VARCHAR },
			{ "paramType", Types.VARCHAR },
			{ "paramFrom", Types.VARCHAR },
			{ "paramUpto", Types.VARCHAR },
			{ "duration", Types.VARCHAR },
			{ "durationType", Types.VARCHAR },
			{ "status", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "dateAdded", Types.TIMESTAMP },
			{ "dateModified", Types.TIMESTAMP },
			{ "createdBy", Types.VARCHAR },
			{ "modifiedBy", Types.VARCHAR },
			{ "extra1", Types.VARCHAR },
			{ "extra2", Types.VARCHAR },
			{ "extra3", Types.VARCHAR },
			{ "extra4", Types.VARCHAR },
			{ "extra5", Types.TIMESTAMP },
			{ "extra6", Types.TIMESTAMP },
			{ "serviceCharges", Types.FLOAT },
			{ "costCurrency", Types.VARCHAR },
			{ "costPeriod", Types.VARCHAR },
			{ "costPeriodType", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SPMembershipPackageIndServices (mpgsscId BIGINT(20) not null primary key,mpId BIGINT(20),scorder VARCHAR(75) null,scgId VARCHAR(75) null,scId VARCHAR(75) null,paramType VARCHAR(75) null,paramFrom VARCHAR(75) null,paramUpto VARCHAR(75) null,duration VARCHAR(75) null,durationType VARCHAR(75) null,status VARCHAR(75) null,description VARCHAR(75) null,dateAdded DATETIME null,dateModified DATETIME null,createdBy VARCHAR(75) null,modifiedBy VARCHAR(75) null,extra1 VARCHAR(75) null,extra2 VARCHAR(75) null,extra3 VARCHAR(75) null,extra4 VARCHAR(75) null,extra5 DATETIME null,extra6 DATETIME null,serviceCharges DOUBLE,costCurrency VARCHAR(75) null,costPeriod VARCHAR(75) null,costPeriodType VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SPMembershipPackageIndServices";
	public static final String ORDER_BY_JPQL = " ORDER BY membershipPackageIndServices.scorder ASC, membershipPackageIndServices.scId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPMembershipPackageIndServices.scorder ASC, SPMembershipPackageIndServices.scId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices"),
			true);
	public static long EXTRA1_COLUMN_BITMASK = 1L;
	public static long MPID_COLUMN_BITMASK = 2L;
	public static long SCID_COLUMN_BITMASK = 4L;
	public static long SCORDER_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices"));

	public MembershipPackageIndServicesModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _mpgsscId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMpgsscId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mpgsscId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackageIndServices.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackageIndServices.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mpgsscId", getMpgsscId());
		attributes.put("mpId", getMpId());
		attributes.put("scorder", getScorder());
		attributes.put("scgId", getScgId());
		attributes.put("scId", getScId());
		attributes.put("paramType", getParamType());
		attributes.put("paramFrom", getParamFrom());
		attributes.put("paramUpto", getParamUpto());
		attributes.put("duration", getDuration());
		attributes.put("durationType", getDurationType());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());
		attributes.put("dateAdded", getDateAdded());
		attributes.put("dateModified", getDateModified());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());
		attributes.put("extra6", getExtra6());
		attributes.put("serviceCharges", getServiceCharges());
		attributes.put("costCurrency", getCostCurrency());
		attributes.put("costPeriod", getCostPeriod());
		attributes.put("costPeriodType", getCostPeriodType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mpgsscId = (Long)attributes.get("mpgsscId");

		if (mpgsscId != null) {
			setMpgsscId(mpgsscId);
		}

		Long mpId = (Long)attributes.get("mpId");

		if (mpId != null) {
			setMpId(mpId);
		}

		String scorder = (String)attributes.get("scorder");

		if (scorder != null) {
			setScorder(scorder);
		}

		String scgId = (String)attributes.get("scgId");

		if (scgId != null) {
			setScgId(scgId);
		}

		String scId = (String)attributes.get("scId");

		if (scId != null) {
			setScId(scId);
		}

		String paramType = (String)attributes.get("paramType");

		if (paramType != null) {
			setParamType(paramType);
		}

		String paramFrom = (String)attributes.get("paramFrom");

		if (paramFrom != null) {
			setParamFrom(paramFrom);
		}

		String paramUpto = (String)attributes.get("paramUpto");

		if (paramUpto != null) {
			setParamUpto(paramUpto);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String durationType = (String)attributes.get("durationType");

		if (durationType != null) {
			setDurationType(durationType);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date dateAdded = (Date)attributes.get("dateAdded");

		if (dateAdded != null) {
			setDateAdded(dateAdded);
		}

		Date dateModified = (Date)attributes.get("dateModified");

		if (dateModified != null) {
			setDateModified(dateModified);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}

		String extra3 = (String)attributes.get("extra3");

		if (extra3 != null) {
			setExtra3(extra3);
		}

		String extra4 = (String)attributes.get("extra4");

		if (extra4 != null) {
			setExtra4(extra4);
		}

		Date extra5 = (Date)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}

		Date extra6 = (Date)attributes.get("extra6");

		if (extra6 != null) {
			setExtra6(extra6);
		}

		Float serviceCharges = (Float)attributes.get("serviceCharges");

		if (serviceCharges != null) {
			setServiceCharges(serviceCharges);
		}

		String costCurrency = (String)attributes.get("costCurrency");

		if (costCurrency != null) {
			setCostCurrency(costCurrency);
		}

		String costPeriod = (String)attributes.get("costPeriod");

		if (costPeriod != null) {
			setCostPeriod(costPeriod);
		}

		String costPeriodType = (String)attributes.get("costPeriodType");

		if (costPeriodType != null) {
			setCostPeriodType(costPeriodType);
		}
	}

	@Override
	public long getMpgsscId() {
		return _mpgsscId;
	}

	@Override
	public void setMpgsscId(long mpgsscId) {
		_mpgsscId = mpgsscId;
	}

	@Override
	public long getMpId() {
		return _mpId;
	}

	@Override
	public void setMpId(long mpId) {
		_columnBitmask |= MPID_COLUMN_BITMASK;

		if (!_setOriginalMpId) {
			_setOriginalMpId = true;

			_originalMpId = _mpId;
		}

		_mpId = mpId;
	}

	public long getOriginalMpId() {
		return _originalMpId;
	}

	@Override
	public String getScorder() {
		if (_scorder == null) {
			return StringPool.BLANK;
		}
		else {
			return _scorder;
		}
	}

	@Override
	public void setScorder(String scorder) {
		_columnBitmask = -1L;

		_scorder = scorder;
	}

	@Override
	public String getScgId() {
		if (_scgId == null) {
			return StringPool.BLANK;
		}
		else {
			return _scgId;
		}
	}

	@Override
	public void setScgId(String scgId) {
		_scgId = scgId;
	}

	@Override
	public String getScId() {
		if (_scId == null) {
			return StringPool.BLANK;
		}
		else {
			return _scId;
		}
	}

	@Override
	public void setScId(String scId) {
		_columnBitmask = -1L;

		if (_originalScId == null) {
			_originalScId = _scId;
		}

		_scId = scId;
	}

	public String getOriginalScId() {
		return GetterUtil.getString(_originalScId);
	}

	@Override
	public String getParamType() {
		if (_paramType == null) {
			return StringPool.BLANK;
		}
		else {
			return _paramType;
		}
	}

	@Override
	public void setParamType(String paramType) {
		_paramType = paramType;
	}

	@Override
	public String getParamFrom() {
		if (_paramFrom == null) {
			return StringPool.BLANK;
		}
		else {
			return _paramFrom;
		}
	}

	@Override
	public void setParamFrom(String paramFrom) {
		_paramFrom = paramFrom;
	}

	@Override
	public String getParamUpto() {
		if (_paramUpto == null) {
			return StringPool.BLANK;
		}
		else {
			return _paramUpto;
		}
	}

	@Override
	public void setParamUpto(String paramUpto) {
		_paramUpto = paramUpto;
	}

	@Override
	public String getDuration() {
		if (_duration == null) {
			return StringPool.BLANK;
		}
		else {
			return _duration;
		}
	}

	@Override
	public void setDuration(String duration) {
		_duration = duration;
	}

	@Override
	public String getDurationType() {
		if (_durationType == null) {
			return StringPool.BLANK;
		}
		else {
			return _durationType;
		}
	}

	@Override
	public void setDurationType(String durationType) {
		_durationType = durationType;
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
	public Date getDateAdded() {
		return _dateAdded;
	}

	@Override
	public void setDateAdded(Date dateAdded) {
		_dateAdded = dateAdded;
	}

	@Override
	public Date getDateModified() {
		return _dateModified;
	}

	@Override
	public void setDateModified(Date dateModified) {
		_dateModified = dateModified;
	}

	@Override
	public String getCreatedBy() {
		if (_createdBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _createdBy;
		}
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	@Override
	public String getModifiedBy() {
		if (_modifiedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _modifiedBy;
		}
	}

	@Override
	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	@Override
	public String getExtra1() {
		if (_extra1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _extra1;
		}
	}

	@Override
	public void setExtra1(String extra1) {
		_columnBitmask |= EXTRA1_COLUMN_BITMASK;

		if (_originalExtra1 == null) {
			_originalExtra1 = _extra1;
		}

		_extra1 = extra1;
	}

	public String getOriginalExtra1() {
		return GetterUtil.getString(_originalExtra1);
	}

	@Override
	public String getExtra2() {
		if (_extra2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _extra2;
		}
	}

	@Override
	public void setExtra2(String extra2) {
		_extra2 = extra2;
	}

	@Override
	public String getExtra3() {
		if (_extra3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _extra3;
		}
	}

	@Override
	public void setExtra3(String extra3) {
		_extra3 = extra3;
	}

	@Override
	public String getExtra4() {
		if (_extra4 == null) {
			return StringPool.BLANK;
		}
		else {
			return _extra4;
		}
	}

	@Override
	public void setExtra4(String extra4) {
		_extra4 = extra4;
	}

	@Override
	public Date getExtra5() {
		return _extra5;
	}

	@Override
	public void setExtra5(Date extra5) {
		_extra5 = extra5;
	}

	@Override
	public Date getExtra6() {
		return _extra6;
	}

	@Override
	public void setExtra6(Date extra6) {
		_extra6 = extra6;
	}

	@Override
	public float getServiceCharges() {
		return _serviceCharges;
	}

	@Override
	public void setServiceCharges(float serviceCharges) {
		_serviceCharges = serviceCharges;
	}

	@Override
	public String getCostCurrency() {
		if (_costCurrency == null) {
			return StringPool.BLANK;
		}
		else {
			return _costCurrency;
		}
	}

	@Override
	public void setCostCurrency(String costCurrency) {
		_costCurrency = costCurrency;
	}

	@Override
	public String getCostPeriod() {
		if (_costPeriod == null) {
			return StringPool.BLANK;
		}
		else {
			return _costPeriod;
		}
	}

	@Override
	public void setCostPeriod(String costPeriod) {
		_costPeriod = costPeriod;
	}

	@Override
	public String getCostPeriodType() {
		if (_costPeriodType == null) {
			return StringPool.BLANK;
		}
		else {
			return _costPeriodType;
		}
	}

	@Override
	public void setCostPeriodType(String costPeriodType) {
		_costPeriodType = costPeriodType;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			MembershipPackageIndServices.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MembershipPackageIndServices toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MembershipPackageIndServices)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MembershipPackageIndServicesImpl membershipPackageIndServicesImpl = new MembershipPackageIndServicesImpl();

		membershipPackageIndServicesImpl.setMpgsscId(getMpgsscId());
		membershipPackageIndServicesImpl.setMpId(getMpId());
		membershipPackageIndServicesImpl.setScorder(getScorder());
		membershipPackageIndServicesImpl.setScgId(getScgId());
		membershipPackageIndServicesImpl.setScId(getScId());
		membershipPackageIndServicesImpl.setParamType(getParamType());
		membershipPackageIndServicesImpl.setParamFrom(getParamFrom());
		membershipPackageIndServicesImpl.setParamUpto(getParamUpto());
		membershipPackageIndServicesImpl.setDuration(getDuration());
		membershipPackageIndServicesImpl.setDurationType(getDurationType());
		membershipPackageIndServicesImpl.setStatus(getStatus());
		membershipPackageIndServicesImpl.setDescription(getDescription());
		membershipPackageIndServicesImpl.setDateAdded(getDateAdded());
		membershipPackageIndServicesImpl.setDateModified(getDateModified());
		membershipPackageIndServicesImpl.setCreatedBy(getCreatedBy());
		membershipPackageIndServicesImpl.setModifiedBy(getModifiedBy());
		membershipPackageIndServicesImpl.setExtra1(getExtra1());
		membershipPackageIndServicesImpl.setExtra2(getExtra2());
		membershipPackageIndServicesImpl.setExtra3(getExtra3());
		membershipPackageIndServicesImpl.setExtra4(getExtra4());
		membershipPackageIndServicesImpl.setExtra5(getExtra5());
		membershipPackageIndServicesImpl.setExtra6(getExtra6());
		membershipPackageIndServicesImpl.setServiceCharges(getServiceCharges());
		membershipPackageIndServicesImpl.setCostCurrency(getCostCurrency());
		membershipPackageIndServicesImpl.setCostPeriod(getCostPeriod());
		membershipPackageIndServicesImpl.setCostPeriodType(getCostPeriodType());

		membershipPackageIndServicesImpl.resetOriginalValues();

		return membershipPackageIndServicesImpl;
	}

	@Override
	public int compareTo(
		MembershipPackageIndServices membershipPackageIndServices) {
		int value = 0;

		value = getScorder().compareTo(membershipPackageIndServices.getScorder());

		if (value != 0) {
			return value;
		}

		value = getScId().compareTo(membershipPackageIndServices.getScId());

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

		if (!(obj instanceof MembershipPackageIndServices)) {
			return false;
		}

		MembershipPackageIndServices membershipPackageIndServices = (MembershipPackageIndServices)obj;

		long primaryKey = membershipPackageIndServices.getPrimaryKey();

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
		MembershipPackageIndServicesModelImpl membershipPackageIndServicesModelImpl =
			this;

		membershipPackageIndServicesModelImpl._originalMpId = membershipPackageIndServicesModelImpl._mpId;

		membershipPackageIndServicesModelImpl._setOriginalMpId = false;

		membershipPackageIndServicesModelImpl._originalScId = membershipPackageIndServicesModelImpl._scId;

		membershipPackageIndServicesModelImpl._originalExtra1 = membershipPackageIndServicesModelImpl._extra1;

		membershipPackageIndServicesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MembershipPackageIndServices> toCacheModel() {
		MembershipPackageIndServicesCacheModel membershipPackageIndServicesCacheModel =
			new MembershipPackageIndServicesCacheModel();

		membershipPackageIndServicesCacheModel.mpgsscId = getMpgsscId();

		membershipPackageIndServicesCacheModel.mpId = getMpId();

		membershipPackageIndServicesCacheModel.scorder = getScorder();

		String scorder = membershipPackageIndServicesCacheModel.scorder;

		if ((scorder != null) && (scorder.length() == 0)) {
			membershipPackageIndServicesCacheModel.scorder = null;
		}

		membershipPackageIndServicesCacheModel.scgId = getScgId();

		String scgId = membershipPackageIndServicesCacheModel.scgId;

		if ((scgId != null) && (scgId.length() == 0)) {
			membershipPackageIndServicesCacheModel.scgId = null;
		}

		membershipPackageIndServicesCacheModel.scId = getScId();

		String scId = membershipPackageIndServicesCacheModel.scId;

		if ((scId != null) && (scId.length() == 0)) {
			membershipPackageIndServicesCacheModel.scId = null;
		}

		membershipPackageIndServicesCacheModel.paramType = getParamType();

		String paramType = membershipPackageIndServicesCacheModel.paramType;

		if ((paramType != null) && (paramType.length() == 0)) {
			membershipPackageIndServicesCacheModel.paramType = null;
		}

		membershipPackageIndServicesCacheModel.paramFrom = getParamFrom();

		String paramFrom = membershipPackageIndServicesCacheModel.paramFrom;

		if ((paramFrom != null) && (paramFrom.length() == 0)) {
			membershipPackageIndServicesCacheModel.paramFrom = null;
		}

		membershipPackageIndServicesCacheModel.paramUpto = getParamUpto();

		String paramUpto = membershipPackageIndServicesCacheModel.paramUpto;

		if ((paramUpto != null) && (paramUpto.length() == 0)) {
			membershipPackageIndServicesCacheModel.paramUpto = null;
		}

		membershipPackageIndServicesCacheModel.duration = getDuration();

		String duration = membershipPackageIndServicesCacheModel.duration;

		if ((duration != null) && (duration.length() == 0)) {
			membershipPackageIndServicesCacheModel.duration = null;
		}

		membershipPackageIndServicesCacheModel.durationType = getDurationType();

		String durationType = membershipPackageIndServicesCacheModel.durationType;

		if ((durationType != null) && (durationType.length() == 0)) {
			membershipPackageIndServicesCacheModel.durationType = null;
		}

		membershipPackageIndServicesCacheModel.status = getStatus();

		String status = membershipPackageIndServicesCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			membershipPackageIndServicesCacheModel.status = null;
		}

		membershipPackageIndServicesCacheModel.description = getDescription();

		String description = membershipPackageIndServicesCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			membershipPackageIndServicesCacheModel.description = null;
		}

		Date dateAdded = getDateAdded();

		if (dateAdded != null) {
			membershipPackageIndServicesCacheModel.dateAdded = dateAdded.getTime();
		}
		else {
			membershipPackageIndServicesCacheModel.dateAdded = Long.MIN_VALUE;
		}

		Date dateModified = getDateModified();

		if (dateModified != null) {
			membershipPackageIndServicesCacheModel.dateModified = dateModified.getTime();
		}
		else {
			membershipPackageIndServicesCacheModel.dateModified = Long.MIN_VALUE;
		}

		membershipPackageIndServicesCacheModel.createdBy = getCreatedBy();

		String createdBy = membershipPackageIndServicesCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			membershipPackageIndServicesCacheModel.createdBy = null;
		}

		membershipPackageIndServicesCacheModel.modifiedBy = getModifiedBy();

		String modifiedBy = membershipPackageIndServicesCacheModel.modifiedBy;

		if ((modifiedBy != null) && (modifiedBy.length() == 0)) {
			membershipPackageIndServicesCacheModel.modifiedBy = null;
		}

		membershipPackageIndServicesCacheModel.extra1 = getExtra1();

		String extra1 = membershipPackageIndServicesCacheModel.extra1;

		if ((extra1 != null) && (extra1.length() == 0)) {
			membershipPackageIndServicesCacheModel.extra1 = null;
		}

		membershipPackageIndServicesCacheModel.extra2 = getExtra2();

		String extra2 = membershipPackageIndServicesCacheModel.extra2;

		if ((extra2 != null) && (extra2.length() == 0)) {
			membershipPackageIndServicesCacheModel.extra2 = null;
		}

		membershipPackageIndServicesCacheModel.extra3 = getExtra3();

		String extra3 = membershipPackageIndServicesCacheModel.extra3;

		if ((extra3 != null) && (extra3.length() == 0)) {
			membershipPackageIndServicesCacheModel.extra3 = null;
		}

		membershipPackageIndServicesCacheModel.extra4 = getExtra4();

		String extra4 = membershipPackageIndServicesCacheModel.extra4;

		if ((extra4 != null) && (extra4.length() == 0)) {
			membershipPackageIndServicesCacheModel.extra4 = null;
		}

		Date extra5 = getExtra5();

		if (extra5 != null) {
			membershipPackageIndServicesCacheModel.extra5 = extra5.getTime();
		}
		else {
			membershipPackageIndServicesCacheModel.extra5 = Long.MIN_VALUE;
		}

		Date extra6 = getExtra6();

		if (extra6 != null) {
			membershipPackageIndServicesCacheModel.extra6 = extra6.getTime();
		}
		else {
			membershipPackageIndServicesCacheModel.extra6 = Long.MIN_VALUE;
		}

		membershipPackageIndServicesCacheModel.serviceCharges = getServiceCharges();

		membershipPackageIndServicesCacheModel.costCurrency = getCostCurrency();

		String costCurrency = membershipPackageIndServicesCacheModel.costCurrency;

		if ((costCurrency != null) && (costCurrency.length() == 0)) {
			membershipPackageIndServicesCacheModel.costCurrency = null;
		}

		membershipPackageIndServicesCacheModel.costPeriod = getCostPeriod();

		String costPeriod = membershipPackageIndServicesCacheModel.costPeriod;

		if ((costPeriod != null) && (costPeriod.length() == 0)) {
			membershipPackageIndServicesCacheModel.costPeriod = null;
		}

		membershipPackageIndServicesCacheModel.costPeriodType = getCostPeriodType();

		String costPeriodType = membershipPackageIndServicesCacheModel.costPeriodType;

		if ((costPeriodType != null) && (costPeriodType.length() == 0)) {
			membershipPackageIndServicesCacheModel.costPeriodType = null;
		}

		return membershipPackageIndServicesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{mpgsscId=");
		sb.append(getMpgsscId());
		sb.append(", mpId=");
		sb.append(getMpId());
		sb.append(", scorder=");
		sb.append(getScorder());
		sb.append(", scgId=");
		sb.append(getScgId());
		sb.append(", scId=");
		sb.append(getScId());
		sb.append(", paramType=");
		sb.append(getParamType());
		sb.append(", paramFrom=");
		sb.append(getParamFrom());
		sb.append(", paramUpto=");
		sb.append(getParamUpto());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", durationType=");
		sb.append(getDurationType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", dateAdded=");
		sb.append(getDateAdded());
		sb.append(", dateModified=");
		sb.append(getDateModified());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", extra1=");
		sb.append(getExtra1());
		sb.append(", extra2=");
		sb.append(getExtra2());
		sb.append(", extra3=");
		sb.append(getExtra3());
		sb.append(", extra4=");
		sb.append(getExtra4());
		sb.append(", extra5=");
		sb.append(getExtra5());
		sb.append(", extra6=");
		sb.append(getExtra6());
		sb.append(", serviceCharges=");
		sb.append(getServiceCharges());
		sb.append(", costCurrency=");
		sb.append(getCostCurrency());
		sb.append(", costPeriod=");
		sb.append(getCostPeriod());
		sb.append(", costPeriodType=");
		sb.append(getCostPeriodType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mpgsscId</column-name><column-value><![CDATA[");
		sb.append(getMpgsscId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpId</column-name><column-value><![CDATA[");
		sb.append(getMpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scorder</column-name><column-value><![CDATA[");
		sb.append(getScorder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scgId</column-name><column-value><![CDATA[");
		sb.append(getScgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scId</column-name><column-value><![CDATA[");
		sb.append(getScId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paramType</column-name><column-value><![CDATA[");
		sb.append(getParamType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paramFrom</column-name><column-value><![CDATA[");
		sb.append(getParamFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paramUpto</column-name><column-value><![CDATA[");
		sb.append(getParamUpto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>durationType</column-name><column-value><![CDATA[");
		sb.append(getDurationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateAdded</column-name><column-value><![CDATA[");
		sb.append(getDateAdded());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateModified</column-name><column-value><![CDATA[");
		sb.append(getDateModified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra1</column-name><column-value><![CDATA[");
		sb.append(getExtra1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra2</column-name><column-value><![CDATA[");
		sb.append(getExtra2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra3</column-name><column-value><![CDATA[");
		sb.append(getExtra3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra4</column-name><column-value><![CDATA[");
		sb.append(getExtra4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra5</column-name><column-value><![CDATA[");
		sb.append(getExtra5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra6</column-name><column-value><![CDATA[");
		sb.append(getExtra6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceCharges</column-name><column-value><![CDATA[");
		sb.append(getServiceCharges());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costCurrency</column-name><column-value><![CDATA[");
		sb.append(getCostCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costPeriod</column-name><column-value><![CDATA[");
		sb.append(getCostPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costPeriodType</column-name><column-value><![CDATA[");
		sb.append(getCostPeriodType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MembershipPackageIndServices.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MembershipPackageIndServices.class
		};
	private long _mpgsscId;
	private long _mpId;
	private long _originalMpId;
	private boolean _setOriginalMpId;
	private String _scorder;
	private String _scgId;
	private String _scId;
	private String _originalScId;
	private String _paramType;
	private String _paramFrom;
	private String _paramUpto;
	private String _duration;
	private String _durationType;
	private String _status;
	private String _description;
	private Date _dateAdded;
	private Date _dateModified;
	private String _createdBy;
	private String _modifiedBy;
	private String _extra1;
	private String _originalExtra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private Date _extra5;
	private Date _extra6;
	private float _serviceCharges;
	private String _costCurrency;
	private String _costPeriod;
	private String _costPeriodType;
	private long _columnBitmask;
	private MembershipPackageIndServices _escapedModel;
}