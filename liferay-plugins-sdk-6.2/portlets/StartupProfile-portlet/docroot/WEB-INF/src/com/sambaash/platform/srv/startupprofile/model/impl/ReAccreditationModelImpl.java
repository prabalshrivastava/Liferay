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

import com.sambaash.platform.srv.startupprofile.model.ReAccreditation;
import com.sambaash.platform.srv.startupprofile.model.ReAccreditationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ReAccreditation service. Represents a row in the &quot;SPReAccreditation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.startupprofile.model.ReAccreditationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReAccreditationImpl}.
 * </p>
 *
 * @author pradeep
 * @see ReAccreditationImpl
 * @see com.sambaash.platform.srv.startupprofile.model.ReAccreditation
 * @see com.sambaash.platform.srv.startupprofile.model.ReAccreditationModel
 * @generated
 */
public class ReAccreditationModelImpl extends BaseModelImpl<ReAccreditation>
	implements ReAccreditationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a re accreditation model instance should use the {@link com.sambaash.platform.srv.startupprofile.model.ReAccreditation} interface instead.
	 */
	public static final String TABLE_NAME = "SPReAccreditation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "accreditationId", Types.BIGINT },
			{ "organizationId", Types.BIGINT },
			{ "accreditationStatus", Types.VARCHAR },
			{ "dateOfAccreditation", Types.TIMESTAMP },
			{ "dateOfExpiry", Types.TIMESTAMP },
			{ "latestPaymentDate", Types.TIMESTAMP },
			{ "startDateOfReaccreditation", Types.TIMESTAMP },
			{ "dateOfReaccdtReview", Types.TIMESTAMP },
			{ "AccreditationBy", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SPReAccreditation (uuid_ VARCHAR(75) null,accreditationId BIGINT(20) not null primary key,organizationId BIGINT(20),accreditationStatus VARCHAR(75) null,dateOfAccreditation DATETIME null,dateOfExpiry DATETIME null,latestPaymentDate DATETIME null,startDateOfReaccreditation DATETIME null,dateOfReaccdtReview DATETIME null,AccreditationBy VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SPReAccreditation";
	public static final String ORDER_BY_JPQL = " ORDER BY reAccreditation.accreditationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPReAccreditation.accreditationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.startupprofile.model.ReAccreditation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.startupprofile.model.ReAccreditation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.startupprofile.model.ReAccreditation"),
			true);
	public static long ORGANIZATIONID_COLUMN_BITMASK = 1L;
	public static long UUID_COLUMN_BITMASK = 2L;
	public static long ACCREDITATIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.startupprofile.model.ReAccreditation"));

	public ReAccreditationModelImpl() {
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
		return ReAccreditation.class;
	}

	@Override
	public String getModelClassName() {
		return ReAccreditation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("accreditationId", getAccreditationId());
		attributes.put("organizationId", getOrganizationId());
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
			ReAccreditation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ReAccreditation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ReAccreditation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ReAccreditationImpl reAccreditationImpl = new ReAccreditationImpl();

		reAccreditationImpl.setUuid(getUuid());
		reAccreditationImpl.setAccreditationId(getAccreditationId());
		reAccreditationImpl.setOrganizationId(getOrganizationId());
		reAccreditationImpl.setAccreditationStatus(getAccreditationStatus());
		reAccreditationImpl.setDateOfAccreditation(getDateOfAccreditation());
		reAccreditationImpl.setDateOfExpiry(getDateOfExpiry());
		reAccreditationImpl.setLatestPaymentDate(getLatestPaymentDate());
		reAccreditationImpl.setStartDateOfReaccreditation(getStartDateOfReaccreditation());
		reAccreditationImpl.setDateOfReaccdtReview(getDateOfReaccdtReview());
		reAccreditationImpl.setAccreditationBy(getAccreditationBy());

		reAccreditationImpl.resetOriginalValues();

		return reAccreditationImpl;
	}

	@Override
	public int compareTo(ReAccreditation reAccreditation) {
		long primaryKey = reAccreditation.getPrimaryKey();

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

		if (!(obj instanceof ReAccreditation)) {
			return false;
		}

		ReAccreditation reAccreditation = (ReAccreditation)obj;

		long primaryKey = reAccreditation.getPrimaryKey();

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
		ReAccreditationModelImpl reAccreditationModelImpl = this;

		reAccreditationModelImpl._originalUuid = reAccreditationModelImpl._uuid;

		reAccreditationModelImpl._originalOrganizationId = reAccreditationModelImpl._organizationId;

		reAccreditationModelImpl._setOriginalOrganizationId = false;

		reAccreditationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ReAccreditation> toCacheModel() {
		ReAccreditationCacheModel reAccreditationCacheModel = new ReAccreditationCacheModel();

		reAccreditationCacheModel.uuid = getUuid();

		String uuid = reAccreditationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			reAccreditationCacheModel.uuid = null;
		}

		reAccreditationCacheModel.accreditationId = getAccreditationId();

		reAccreditationCacheModel.organizationId = getOrganizationId();

		reAccreditationCacheModel.accreditationStatus = getAccreditationStatus();

		String accreditationStatus = reAccreditationCacheModel.accreditationStatus;

		if ((accreditationStatus != null) &&
				(accreditationStatus.length() == 0)) {
			reAccreditationCacheModel.accreditationStatus = null;
		}

		Date dateOfAccreditation = getDateOfAccreditation();

		if (dateOfAccreditation != null) {
			reAccreditationCacheModel.dateOfAccreditation = dateOfAccreditation.getTime();
		}
		else {
			reAccreditationCacheModel.dateOfAccreditation = Long.MIN_VALUE;
		}

		Date dateOfExpiry = getDateOfExpiry();

		if (dateOfExpiry != null) {
			reAccreditationCacheModel.dateOfExpiry = dateOfExpiry.getTime();
		}
		else {
			reAccreditationCacheModel.dateOfExpiry = Long.MIN_VALUE;
		}

		Date latestPaymentDate = getLatestPaymentDate();

		if (latestPaymentDate != null) {
			reAccreditationCacheModel.latestPaymentDate = latestPaymentDate.getTime();
		}
		else {
			reAccreditationCacheModel.latestPaymentDate = Long.MIN_VALUE;
		}

		Date startDateOfReaccreditation = getStartDateOfReaccreditation();

		if (startDateOfReaccreditation != null) {
			reAccreditationCacheModel.startDateOfReaccreditation = startDateOfReaccreditation.getTime();
		}
		else {
			reAccreditationCacheModel.startDateOfReaccreditation = Long.MIN_VALUE;
		}

		Date dateOfReaccdtReview = getDateOfReaccdtReview();

		if (dateOfReaccdtReview != null) {
			reAccreditationCacheModel.dateOfReaccdtReview = dateOfReaccdtReview.getTime();
		}
		else {
			reAccreditationCacheModel.dateOfReaccdtReview = Long.MIN_VALUE;
		}

		reAccreditationCacheModel.AccreditationBy = getAccreditationBy();

		String AccreditationBy = reAccreditationCacheModel.AccreditationBy;

		if ((AccreditationBy != null) && (AccreditationBy.length() == 0)) {
			reAccreditationCacheModel.AccreditationBy = null;
		}

		return reAccreditationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", accreditationId=");
		sb.append(getAccreditationId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.ReAccreditation");
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

	private static ClassLoader _classLoader = ReAccreditation.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ReAccreditation.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _accreditationId;
	private long _organizationId;
	private long _originalOrganizationId;
	private boolean _setOriginalOrganizationId;
	private String _accreditationStatus;
	private Date _dateOfAccreditation;
	private Date _dateOfExpiry;
	private Date _latestPaymentDate;
	private Date _startDateOfReaccreditation;
	private Date _dateOfReaccdtReview;
	private String _AccreditationBy;
	private long _columnBitmask;
	private ReAccreditation _escapedModel;
}