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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sambaash.platform.srv.startupprofile.model.Accreditation;
import com.sambaash.platform.srv.startupprofile.model.AccreditationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Accreditation service. Represents a row in the &quot;SPAccreditation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.startupprofile.model.AccreditationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AccreditationImpl}.
 * </p>
 *
 * @author pradeep
 * @see AccreditationImpl
 * @see com.sambaash.platform.srv.startupprofile.model.Accreditation
 * @see com.sambaash.platform.srv.startupprofile.model.AccreditationModel
 * @generated
 */
public class AccreditationModelImpl extends BaseModelImpl<Accreditation>
	implements AccreditationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a accreditation model instance should use the {@link com.sambaash.platform.srv.startupprofile.model.Accreditation} interface instead.
	 */
	public static final String TABLE_NAME = "SPAccreditation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "accreditationId", Types.BIGINT },
			{ "organizationId", Types.BIGINT },
			{ "aselected", Types.BOOLEAN },
			{ "avalue", Types.VARCHAR },
			{ "bselected", Types.BOOLEAN },
			{ "bvalue", Types.VARCHAR },
			{ "cselected", Types.BOOLEAN },
			{ "cvalue", Types.VARCHAR },
			{ "cCompanyName", Types.VARCHAR },
			{ "csamepolicy", Types.BOOLEAN },
			{ "celaborate", Types.VARCHAR },
			{ "dselected", Types.BOOLEAN },
			{ "dvalue", Types.VARCHAR },
			{ "accreditationStatus", Types.VARCHAR },
			{ "dateOfAccreditation", Types.TIMESTAMP },
			{ "dateOfExpiry", Types.TIMESTAMP },
			{ "latestPaymentDate", Types.TIMESTAMP },
			{ "startDateOfReaccreditation", Types.TIMESTAMP },
			{ "dateOfReaccdtReview", Types.TIMESTAMP },
			{ "AccreditationBy", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SPAccreditation (uuid_ VARCHAR(75) null,accreditationId BIGINT(20) not null primary key,organizationId BIGINT(20),aselected BOOLEAN,avalue VARCHAR(75) null,bselected BOOLEAN,bvalue VARCHAR(75) null,cselected BOOLEAN,cvalue VARCHAR(75) null,cCompanyName VARCHAR(75) null,csamepolicy BOOLEAN,celaborate VARCHAR(75) null,dselected BOOLEAN,dvalue VARCHAR(75) null,accreditationStatus VARCHAR(75) null,dateOfAccreditation DATETIME null,dateOfExpiry DATETIME null,latestPaymentDate DATETIME null,startDateOfReaccreditation DATETIME null,dateOfReaccdtReview DATETIME null,AccreditationBy VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SPAccreditation";
	public static final String ORDER_BY_JPQL = " ORDER BY accreditation.accreditationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPAccreditation.accreditationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.startupprofile.model.Accreditation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.startupprofile.model.Accreditation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.startupprofile.model.Accreditation"),
			true);
	public static long ORGANIZATIONID_COLUMN_BITMASK = 1L;
	public static long UUID_COLUMN_BITMASK = 2L;
	public static long ACCREDITATIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.startupprofile.model.Accreditation"));

	public AccreditationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _accreditationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAccreditationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _accreditationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Accreditation.class;
	}

	@Override
	public String getModelClassName() {
		return Accreditation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("accreditationId", getAccreditationId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("aselected", getAselected());
		attributes.put("avalue", getAvalue());
		attributes.put("bselected", getBselected());
		attributes.put("bvalue", getBvalue());
		attributes.put("cselected", getCselected());
		attributes.put("cvalue", getCvalue());
		attributes.put("ccompanyName", getCcompanyName());
		attributes.put("csamepolicy", getCsamepolicy());
		attributes.put("celaborate", getCelaborate());
		attributes.put("dselected", getDselected());
		attributes.put("dvalue", getDvalue());
		attributes.put("accreditationStatus", getAccreditationStatus());
		attributes.put("dateOfAccreditation", getDateOfAccreditation());
		attributes.put("dateOfExpiry", getDateOfExpiry());
		attributes.put("latestPaymentDate", getLatestPaymentDate());
		attributes.put("startDateOfReaccreditation",
			getStartDateOfReaccreditation());
		attributes.put("dateOfReaccdtReview", getDateOfReaccdtReview());
		attributes.put("AccreditationBy", getAccreditationBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long accreditationId = (Long)attributes.get("accreditationId");

		if (accreditationId != null) {
			setAccreditationId(accreditationId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Boolean aselected = (Boolean)attributes.get("aselected");

		if (aselected != null) {
			setAselected(aselected);
		}

		String avalue = (String)attributes.get("avalue");

		if (avalue != null) {
			setAvalue(avalue);
		}

		Boolean bselected = (Boolean)attributes.get("bselected");

		if (bselected != null) {
			setBselected(bselected);
		}

		String bvalue = (String)attributes.get("bvalue");

		if (bvalue != null) {
			setBvalue(bvalue);
		}

		Boolean cselected = (Boolean)attributes.get("cselected");

		if (cselected != null) {
			setCselected(cselected);
		}

		String cvalue = (String)attributes.get("cvalue");

		if (cvalue != null) {
			setCvalue(cvalue);
		}

		String ccompanyName = (String)attributes.get("ccompanyName");

		if (ccompanyName != null) {
			setCcompanyName(ccompanyName);
		}

		Boolean csamepolicy = (Boolean)attributes.get("csamepolicy");

		if (csamepolicy != null) {
			setCsamepolicy(csamepolicy);
		}

		String celaborate = (String)attributes.get("celaborate");

		if (celaborate != null) {
			setCelaborate(celaborate);
		}

		Boolean dselected = (Boolean)attributes.get("dselected");

		if (dselected != null) {
			setDselected(dselected);
		}

		String dvalue = (String)attributes.get("dvalue");

		if (dvalue != null) {
			setDvalue(dvalue);
		}

		String accreditationStatus = (String)attributes.get(
				"accreditationStatus");

		if (accreditationStatus != null) {
			setAccreditationStatus(accreditationStatus);
		}

		Date dateOfAccreditation = (Date)attributes.get("dateOfAccreditation");

		if (dateOfAccreditation != null) {
			setDateOfAccreditation(dateOfAccreditation);
		}

		Date dateOfExpiry = (Date)attributes.get("dateOfExpiry");

		if (dateOfExpiry != null) {
			setDateOfExpiry(dateOfExpiry);
		}

		Date latestPaymentDate = (Date)attributes.get("latestPaymentDate");

		if (latestPaymentDate != null) {
			setLatestPaymentDate(latestPaymentDate);
		}

		Date startDateOfReaccreditation = (Date)attributes.get(
				"startDateOfReaccreditation");

		if (startDateOfReaccreditation != null) {
			setStartDateOfReaccreditation(startDateOfReaccreditation);
		}

		Date dateOfReaccdtReview = (Date)attributes.get("dateOfReaccdtReview");

		if (dateOfReaccdtReview != null) {
			setDateOfReaccdtReview(dateOfReaccdtReview);
		}

		String AccreditationBy = (String)attributes.get("AccreditationBy");

		if (AccreditationBy != null) {
			setAccreditationBy(AccreditationBy);
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
	public long getAccreditationId() {
		return _accreditationId;
	}

	@Override
	public void setAccreditationId(long accreditationId) {
		_accreditationId = accreditationId;
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_columnBitmask |= ORGANIZATIONID_COLUMN_BITMASK;

		if (!_setOriginalOrganizationId) {
			_setOriginalOrganizationId = true;

			_originalOrganizationId = _organizationId;
		}

		_organizationId = organizationId;
	}

	public long getOriginalOrganizationId() {
		return _originalOrganizationId;
	}

	@Override
	public boolean getAselected() {
		return _aselected;
	}

	@Override
	public boolean isAselected() {
		return _aselected;
	}

	@Override
	public void setAselected(boolean aselected) {
		_aselected = aselected;
	}

	@Override
	public String getAvalue() {
		if (_avalue == null) {
			return StringPool.BLANK;
		}
		else {
			return _avalue;
		}
	}

	@Override
	public void setAvalue(String avalue) {
		_avalue = avalue;
	}

	@Override
	public boolean getBselected() {
		return _bselected;
	}

	@Override
	public boolean isBselected() {
		return _bselected;
	}

	@Override
	public void setBselected(boolean bselected) {
		_bselected = bselected;
	}

	@Override
	public String getBvalue() {
		if (_bvalue == null) {
			return StringPool.BLANK;
		}
		else {
			return _bvalue;
		}
	}

	@Override
	public void setBvalue(String bvalue) {
		_bvalue = bvalue;
	}

	@Override
	public boolean getCselected() {
		return _cselected;
	}

	@Override
	public boolean isCselected() {
		return _cselected;
	}

	@Override
	public void setCselected(boolean cselected) {
		_cselected = cselected;
	}

	@Override
	public String getCvalue() {
		if (_cvalue == null) {
			return StringPool.BLANK;
		}
		else {
			return _cvalue;
		}
	}

	@Override
	public void setCvalue(String cvalue) {
		_cvalue = cvalue;
	}

	@Override
	public String getCcompanyName() {
		if (_ccompanyName == null) {
			return StringPool.BLANK;
		}
		else {
			return _ccompanyName;
		}
	}

	@Override
	public void setCcompanyName(String ccompanyName) {
		_ccompanyName = ccompanyName;
	}

	@Override
	public boolean getCsamepolicy() {
		return _csamepolicy;
	}

	@Override
	public boolean isCsamepolicy() {
		return _csamepolicy;
	}

	@Override
	public void setCsamepolicy(boolean csamepolicy) {
		_csamepolicy = csamepolicy;
	}

	@Override
	public String getCelaborate() {
		if (_celaborate == null) {
			return StringPool.BLANK;
		}
		else {
			return _celaborate;
		}
	}

	@Override
	public void setCelaborate(String celaborate) {
		_celaborate = celaborate;
	}

	@Override
	public boolean getDselected() {
		return _dselected;
	}

	@Override
	public boolean isDselected() {
		return _dselected;
	}

	@Override
	public void setDselected(boolean dselected) {
		_dselected = dselected;
	}

	@Override
	public String getDvalue() {
		if (_dvalue == null) {
			return StringPool.BLANK;
		}
		else {
			return _dvalue;
		}
	}

	@Override
	public void setDvalue(String dvalue) {
		_dvalue = dvalue;
	}

	@Override
	public String getAccreditationStatus() {
		if (_accreditationStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _accreditationStatus;
		}
	}

	@Override
	public void setAccreditationStatus(String accreditationStatus) {
		_accreditationStatus = accreditationStatus;
	}

	@Override
	public Date getDateOfAccreditation() {
		return _dateOfAccreditation;
	}

	@Override
	public void setDateOfAccreditation(Date dateOfAccreditation) {
		_dateOfAccreditation = dateOfAccreditation;
	}

	@Override
	public Date getDateOfExpiry() {
		return _dateOfExpiry;
	}

	@Override
	public void setDateOfExpiry(Date dateOfExpiry) {
		_dateOfExpiry = dateOfExpiry;
	}

	@Override
	public Date getLatestPaymentDate() {
		return _latestPaymentDate;
	}

	@Override
	public void setLatestPaymentDate(Date latestPaymentDate) {
		_latestPaymentDate = latestPaymentDate;
	}

	@Override
	public Date getStartDateOfReaccreditation() {
		return _startDateOfReaccreditation;
	}

	@Override
	public void setStartDateOfReaccreditation(Date startDateOfReaccreditation) {
		_startDateOfReaccreditation = startDateOfReaccreditation;
	}

	@Override
	public Date getDateOfReaccdtReview() {
		return _dateOfReaccdtReview;
	}

	@Override
	public void setDateOfReaccdtReview(Date dateOfReaccdtReview) {
		_dateOfReaccdtReview = dateOfReaccdtReview;
	}

	@Override
	public String getAccreditationBy() {
		if (_AccreditationBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _AccreditationBy;
		}
	}

	@Override
	public void setAccreditationBy(String AccreditationBy) {
		_AccreditationBy = AccreditationBy;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Accreditation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Accreditation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Accreditation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AccreditationImpl accreditationImpl = new AccreditationImpl();

		accreditationImpl.setUuid(getUuid());
		accreditationImpl.setAccreditationId(getAccreditationId());
		accreditationImpl.setOrganizationId(getOrganizationId());
		accreditationImpl.setAselected(getAselected());
		accreditationImpl.setAvalue(getAvalue());
		accreditationImpl.setBselected(getBselected());
		accreditationImpl.setBvalue(getBvalue());
		accreditationImpl.setCselected(getCselected());
		accreditationImpl.setCvalue(getCvalue());
		accreditationImpl.setCcompanyName(getCcompanyName());
		accreditationImpl.setCsamepolicy(getCsamepolicy());
		accreditationImpl.setCelaborate(getCelaborate());
		accreditationImpl.setDselected(getDselected());
		accreditationImpl.setDvalue(getDvalue());
		accreditationImpl.setAccreditationStatus(getAccreditationStatus());
		accreditationImpl.setDateOfAccreditation(getDateOfAccreditation());
		accreditationImpl.setDateOfExpiry(getDateOfExpiry());
		accreditationImpl.setLatestPaymentDate(getLatestPaymentDate());
		accreditationImpl.setStartDateOfReaccreditation(getStartDateOfReaccreditation());
		accreditationImpl.setDateOfReaccdtReview(getDateOfReaccdtReview());
		accreditationImpl.setAccreditationBy(getAccreditationBy());

		accreditationImpl.resetOriginalValues();

		return accreditationImpl;
	}

	@Override
	public int compareTo(Accreditation accreditation) {
		long primaryKey = accreditation.getPrimaryKey();

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

		if (!(obj instanceof Accreditation)) {
			return false;
		}

		Accreditation accreditation = (Accreditation)obj;

		long primaryKey = accreditation.getPrimaryKey();

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
		AccreditationModelImpl accreditationModelImpl = this;

		accreditationModelImpl._originalUuid = accreditationModelImpl._uuid;

		accreditationModelImpl._originalOrganizationId = accreditationModelImpl._organizationId;

		accreditationModelImpl._setOriginalOrganizationId = false;

		accreditationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Accreditation> toCacheModel() {
		AccreditationCacheModel accreditationCacheModel = new AccreditationCacheModel();

		accreditationCacheModel.uuid = getUuid();

		String uuid = accreditationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			accreditationCacheModel.uuid = null;
		}

		accreditationCacheModel.accreditationId = getAccreditationId();

		accreditationCacheModel.organizationId = getOrganizationId();

		accreditationCacheModel.aselected = getAselected();

		accreditationCacheModel.avalue = getAvalue();

		String avalue = accreditationCacheModel.avalue;

		if ((avalue != null) && (avalue.length() == 0)) {
			accreditationCacheModel.avalue = null;
		}

		accreditationCacheModel.bselected = getBselected();

		accreditationCacheModel.bvalue = getBvalue();

		String bvalue = accreditationCacheModel.bvalue;

		if ((bvalue != null) && (bvalue.length() == 0)) {
			accreditationCacheModel.bvalue = null;
		}

		accreditationCacheModel.cselected = getCselected();

		accreditationCacheModel.cvalue = getCvalue();

		String cvalue = accreditationCacheModel.cvalue;

		if ((cvalue != null) && (cvalue.length() == 0)) {
			accreditationCacheModel.cvalue = null;
		}

		accreditationCacheModel.ccompanyName = getCcompanyName();

		String ccompanyName = accreditationCacheModel.ccompanyName;

		if ((ccompanyName != null) && (ccompanyName.length() == 0)) {
			accreditationCacheModel.ccompanyName = null;
		}

		accreditationCacheModel.csamepolicy = getCsamepolicy();

		accreditationCacheModel.celaborate = getCelaborate();

		String celaborate = accreditationCacheModel.celaborate;

		if ((celaborate != null) && (celaborate.length() == 0)) {
			accreditationCacheModel.celaborate = null;
		}

		accreditationCacheModel.dselected = getDselected();

		accreditationCacheModel.dvalue = getDvalue();

		String dvalue = accreditationCacheModel.dvalue;

		if ((dvalue != null) && (dvalue.length() == 0)) {
			accreditationCacheModel.dvalue = null;
		}

		accreditationCacheModel.accreditationStatus = getAccreditationStatus();

		String accreditationStatus = accreditationCacheModel.accreditationStatus;

		if ((accreditationStatus != null) &&
				(accreditationStatus.length() == 0)) {
			accreditationCacheModel.accreditationStatus = null;
		}

		Date dateOfAccreditation = getDateOfAccreditation();

		if (dateOfAccreditation != null) {
			accreditationCacheModel.dateOfAccreditation = dateOfAccreditation.getTime();
		}
		else {
			accreditationCacheModel.dateOfAccreditation = Long.MIN_VALUE;
		}

		Date dateOfExpiry = getDateOfExpiry();

		if (dateOfExpiry != null) {
			accreditationCacheModel.dateOfExpiry = dateOfExpiry.getTime();
		}
		else {
			accreditationCacheModel.dateOfExpiry = Long.MIN_VALUE;
		}

		Date latestPaymentDate = getLatestPaymentDate();

		if (latestPaymentDate != null) {
			accreditationCacheModel.latestPaymentDate = latestPaymentDate.getTime();
		}
		else {
			accreditationCacheModel.latestPaymentDate = Long.MIN_VALUE;
		}

		Date startDateOfReaccreditation = getStartDateOfReaccreditation();

		if (startDateOfReaccreditation != null) {
			accreditationCacheModel.startDateOfReaccreditation = startDateOfReaccreditation.getTime();
		}
		else {
			accreditationCacheModel.startDateOfReaccreditation = Long.MIN_VALUE;
		}

		Date dateOfReaccdtReview = getDateOfReaccdtReview();

		if (dateOfReaccdtReview != null) {
			accreditationCacheModel.dateOfReaccdtReview = dateOfReaccdtReview.getTime();
		}
		else {
			accreditationCacheModel.dateOfReaccdtReview = Long.MIN_VALUE;
		}

		accreditationCacheModel.AccreditationBy = getAccreditationBy();

		String AccreditationBy = accreditationCacheModel.AccreditationBy;

		if ((AccreditationBy != null) && (AccreditationBy.length() == 0)) {
			accreditationCacheModel.AccreditationBy = null;
		}

		return accreditationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", accreditationId=");
		sb.append(getAccreditationId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", aselected=");
		sb.append(getAselected());
		sb.append(", avalue=");
		sb.append(getAvalue());
		sb.append(", bselected=");
		sb.append(getBselected());
		sb.append(", bvalue=");
		sb.append(getBvalue());
		sb.append(", cselected=");
		sb.append(getCselected());
		sb.append(", cvalue=");
		sb.append(getCvalue());
		sb.append(", ccompanyName=");
		sb.append(getCcompanyName());
		sb.append(", csamepolicy=");
		sb.append(getCsamepolicy());
		sb.append(", celaborate=");
		sb.append(getCelaborate());
		sb.append(", dselected=");
		sb.append(getDselected());
		sb.append(", dvalue=");
		sb.append(getDvalue());
		sb.append(", accreditationStatus=");
		sb.append(getAccreditationStatus());
		sb.append(", dateOfAccreditation=");
		sb.append(getDateOfAccreditation());
		sb.append(", dateOfExpiry=");
		sb.append(getDateOfExpiry());
		sb.append(", latestPaymentDate=");
		sb.append(getLatestPaymentDate());
		sb.append(", startDateOfReaccreditation=");
		sb.append(getStartDateOfReaccreditation());
		sb.append(", dateOfReaccdtReview=");
		sb.append(getDateOfReaccdtReview());
		sb.append(", AccreditationBy=");
		sb.append(getAccreditationBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.Accreditation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accreditationId</column-name><column-value><![CDATA[");
		sb.append(getAccreditationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aselected</column-name><column-value><![CDATA[");
		sb.append(getAselected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avalue</column-name><column-value><![CDATA[");
		sb.append(getAvalue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bselected</column-name><column-value><![CDATA[");
		sb.append(getBselected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bvalue</column-name><column-value><![CDATA[");
		sb.append(getBvalue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cselected</column-name><column-value><![CDATA[");
		sb.append(getCselected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cvalue</column-name><column-value><![CDATA[");
		sb.append(getCvalue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccompanyName</column-name><column-value><![CDATA[");
		sb.append(getCcompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>csamepolicy</column-name><column-value><![CDATA[");
		sb.append(getCsamepolicy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>celaborate</column-name><column-value><![CDATA[");
		sb.append(getCelaborate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dselected</column-name><column-value><![CDATA[");
		sb.append(getDselected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dvalue</column-name><column-value><![CDATA[");
		sb.append(getDvalue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accreditationStatus</column-name><column-value><![CDATA[");
		sb.append(getAccreditationStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfAccreditation</column-name><column-value><![CDATA[");
		sb.append(getDateOfAccreditation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfExpiry</column-name><column-value><![CDATA[");
		sb.append(getDateOfExpiry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latestPaymentDate</column-name><column-value><![CDATA[");
		sb.append(getLatestPaymentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDateOfReaccreditation</column-name><column-value><![CDATA[");
		sb.append(getStartDateOfReaccreditation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfReaccdtReview</column-name><column-value><![CDATA[");
		sb.append(getDateOfReaccdtReview());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AccreditationBy</column-name><column-value><![CDATA[");
		sb.append(getAccreditationBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Accreditation.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Accreditation.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _accreditationId;
	private long _organizationId;
	private long _originalOrganizationId;
	private boolean _setOriginalOrganizationId;
	private boolean _aselected;
	private String _avalue;
	private boolean _bselected;
	private String _bvalue;
	private boolean _cselected;
	private String _cvalue;
	private String _ccompanyName;
	private boolean _csamepolicy;
	private String _celaborate;
	private boolean _dselected;
	private String _dvalue;
	private String _accreditationStatus;
	private Date _dateOfAccreditation;
	private Date _dateOfExpiry;
	private Date _latestPaymentDate;
	private Date _startDateOfReaccreditation;
	private Date _dateOfReaccdtReview;
	private String _AccreditationBy;
	private long _columnBitmask;
	private Accreditation _escapedModel;
}