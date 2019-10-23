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

package com.sambaash.platform.srv.rsvp.model.impl;

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

import com.sambaash.platform.srv.rsvp.model.RsvpPromoCode;
import com.sambaash.platform.srv.rsvp.model.RsvpPromoCodeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the RsvpPromoCode service. Represents a row in the &quot;SPRsvpPromoCode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.rsvp.model.RsvpPromoCodeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RsvpPromoCodeImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPromoCodeImpl
 * @see com.sambaash.platform.srv.rsvp.model.RsvpPromoCode
 * @see com.sambaash.platform.srv.rsvp.model.RsvpPromoCodeModel
 * @generated
 */
public class RsvpPromoCodeModelImpl extends BaseModelImpl<RsvpPromoCode>
	implements RsvpPromoCodeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rsvp promo code model instance should use the {@link com.sambaash.platform.srv.rsvp.model.RsvpPromoCode} interface instead.
	 */
	public static final String TABLE_NAME = "SPRsvpPromoCode";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "spRsvpPromoCodeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "spRsvpId", Types.BIGINT },
			{ "spRsvpTicketId", Types.BIGINT },
			{ "promoCode", Types.VARCHAR },
			{ "fromDate", Types.TIMESTAMP },
			{ "toDate", Types.TIMESTAMP },
			{ "noOfTickets", Types.INTEGER },
			{ "discount", Types.INTEGER },
			{ "modifiedBy", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPRsvpPromoCode (uuid_ VARCHAR(75) null,spRsvpPromoCodeId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,spRsvpId BIGINT(20),spRsvpTicketId BIGINT(20),promoCode VARCHAR(75) null,fromDate DATETIME null,toDate DATETIME null,noOfTickets INTEGER,discount INTEGER,modifiedBy BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPRsvpPromoCode";
	public static final String ORDER_BY_JPQL = " ORDER BY rsvpPromoCode.rsvpPromoCodeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPRsvpPromoCode.spRsvpPromoCodeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.rsvp.model.RsvpPromoCode"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.rsvp.model.RsvpPromoCode"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.rsvp.model.RsvpPromoCode"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long PROMOCODE_COLUMN_BITMASK = 4L;
	public static long RSVPID_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;
	public static long RSVPPROMOCODEID_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.rsvp.model.RsvpPromoCode"));

	public RsvpPromoCodeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _rsvpPromoCodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRsvpPromoCodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rsvpPromoCodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpPromoCode.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpPromoCode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpPromoCodeId", getRsvpPromoCodeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("rsvpTicketId", getRsvpTicketId());
		attributes.put("promoCode", getPromoCode());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("noOfTickets", getNoOfTickets());
		attributes.put("discount", getDiscount());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpPromoCodeId = (Long)attributes.get("rsvpPromoCodeId");

		if (rsvpPromoCodeId != null) {
			setRsvpPromoCodeId(rsvpPromoCodeId);
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

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
		}

		Long rsvpTicketId = (Long)attributes.get("rsvpTicketId");

		if (rsvpTicketId != null) {
			setRsvpTicketId(rsvpTicketId);
		}

		String promoCode = (String)attributes.get("promoCode");

		if (promoCode != null) {
			setPromoCode(promoCode);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Integer noOfTickets = (Integer)attributes.get("noOfTickets");

		if (noOfTickets != null) {
			setNoOfTickets(noOfTickets);
		}

		Integer discount = (Integer)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
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
	public long getRsvpPromoCodeId() {
		return _rsvpPromoCodeId;
	}

	@Override
	public void setRsvpPromoCodeId(long rsvpPromoCodeId) {
		_rsvpPromoCodeId = rsvpPromoCodeId;
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
	public long getRsvpId() {
		return _rsvpId;
	}

	@Override
	public void setRsvpId(long rsvpId) {
		_columnBitmask |= RSVPID_COLUMN_BITMASK;

		if (!_setOriginalRsvpId) {
			_setOriginalRsvpId = true;

			_originalRsvpId = _rsvpId;
		}

		_rsvpId = rsvpId;
	}

	public long getOriginalRsvpId() {
		return _originalRsvpId;
	}

	@Override
	public long getRsvpTicketId() {
		return _rsvpTicketId;
	}

	@Override
	public void setRsvpTicketId(long rsvpTicketId) {
		_rsvpTicketId = rsvpTicketId;
	}

	@Override
	public String getPromoCode() {
		if (_promoCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _promoCode;
		}
	}

	@Override
	public void setPromoCode(String promoCode) {
		_columnBitmask |= PROMOCODE_COLUMN_BITMASK;

		if (_originalPromoCode == null) {
			_originalPromoCode = _promoCode;
		}

		_promoCode = promoCode;
	}

	public String getOriginalPromoCode() {
		return GetterUtil.getString(_originalPromoCode);
	}

	@Override
	public Date getFromDate() {
		return _fromDate;
	}

	@Override
	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	@Override
	public Date getToDate() {
		return _toDate;
	}

	@Override
	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	@Override
	public int getNoOfTickets() {
		return _noOfTickets;
	}

	@Override
	public void setNoOfTickets(int noOfTickets) {
		_noOfTickets = noOfTickets;
	}

	@Override
	public int getDiscount() {
		return _discount;
	}

	@Override
	public void setDiscount(int discount) {
		_discount = discount;
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RsvpPromoCode.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			RsvpPromoCode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RsvpPromoCode toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RsvpPromoCode)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RsvpPromoCodeImpl rsvpPromoCodeImpl = new RsvpPromoCodeImpl();

		rsvpPromoCodeImpl.setUuid(getUuid());
		rsvpPromoCodeImpl.setRsvpPromoCodeId(getRsvpPromoCodeId());
		rsvpPromoCodeImpl.setGroupId(getGroupId());
		rsvpPromoCodeImpl.setCompanyId(getCompanyId());
		rsvpPromoCodeImpl.setUserId(getUserId());
		rsvpPromoCodeImpl.setUserName(getUserName());
		rsvpPromoCodeImpl.setCreateDate(getCreateDate());
		rsvpPromoCodeImpl.setModifiedDate(getModifiedDate());
		rsvpPromoCodeImpl.setRsvpId(getRsvpId());
		rsvpPromoCodeImpl.setRsvpTicketId(getRsvpTicketId());
		rsvpPromoCodeImpl.setPromoCode(getPromoCode());
		rsvpPromoCodeImpl.setFromDate(getFromDate());
		rsvpPromoCodeImpl.setToDate(getToDate());
		rsvpPromoCodeImpl.setNoOfTickets(getNoOfTickets());
		rsvpPromoCodeImpl.setDiscount(getDiscount());
		rsvpPromoCodeImpl.setModifiedBy(getModifiedBy());

		rsvpPromoCodeImpl.resetOriginalValues();

		return rsvpPromoCodeImpl;
	}

	@Override
	public int compareTo(RsvpPromoCode rsvpPromoCode) {
		long primaryKey = rsvpPromoCode.getPrimaryKey();

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

		if (!(obj instanceof RsvpPromoCode)) {
			return false;
		}

		RsvpPromoCode rsvpPromoCode = (RsvpPromoCode)obj;

		long primaryKey = rsvpPromoCode.getPrimaryKey();

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
		RsvpPromoCodeModelImpl rsvpPromoCodeModelImpl = this;

		rsvpPromoCodeModelImpl._originalUuid = rsvpPromoCodeModelImpl._uuid;

		rsvpPromoCodeModelImpl._originalGroupId = rsvpPromoCodeModelImpl._groupId;

		rsvpPromoCodeModelImpl._setOriginalGroupId = false;

		rsvpPromoCodeModelImpl._originalCompanyId = rsvpPromoCodeModelImpl._companyId;

		rsvpPromoCodeModelImpl._setOriginalCompanyId = false;

		rsvpPromoCodeModelImpl._originalRsvpId = rsvpPromoCodeModelImpl._rsvpId;

		rsvpPromoCodeModelImpl._setOriginalRsvpId = false;

		rsvpPromoCodeModelImpl._originalPromoCode = rsvpPromoCodeModelImpl._promoCode;

		rsvpPromoCodeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RsvpPromoCode> toCacheModel() {
		RsvpPromoCodeCacheModel rsvpPromoCodeCacheModel = new RsvpPromoCodeCacheModel();

		rsvpPromoCodeCacheModel.uuid = getUuid();

		String uuid = rsvpPromoCodeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			rsvpPromoCodeCacheModel.uuid = null;
		}

		rsvpPromoCodeCacheModel.rsvpPromoCodeId = getRsvpPromoCodeId();

		rsvpPromoCodeCacheModel.groupId = getGroupId();

		rsvpPromoCodeCacheModel.companyId = getCompanyId();

		rsvpPromoCodeCacheModel.userId = getUserId();

		rsvpPromoCodeCacheModel.userName = getUserName();

		String userName = rsvpPromoCodeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			rsvpPromoCodeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			rsvpPromoCodeCacheModel.createDate = createDate.getTime();
		}
		else {
			rsvpPromoCodeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			rsvpPromoCodeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			rsvpPromoCodeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		rsvpPromoCodeCacheModel.rsvpId = getRsvpId();

		rsvpPromoCodeCacheModel.rsvpTicketId = getRsvpTicketId();

		rsvpPromoCodeCacheModel.promoCode = getPromoCode();

		String promoCode = rsvpPromoCodeCacheModel.promoCode;

		if ((promoCode != null) && (promoCode.length() == 0)) {
			rsvpPromoCodeCacheModel.promoCode = null;
		}

		Date fromDate = getFromDate();

		if (fromDate != null) {
			rsvpPromoCodeCacheModel.fromDate = fromDate.getTime();
		}
		else {
			rsvpPromoCodeCacheModel.fromDate = Long.MIN_VALUE;
		}

		Date toDate = getToDate();

		if (toDate != null) {
			rsvpPromoCodeCacheModel.toDate = toDate.getTime();
		}
		else {
			rsvpPromoCodeCacheModel.toDate = Long.MIN_VALUE;
		}

		rsvpPromoCodeCacheModel.noOfTickets = getNoOfTickets();

		rsvpPromoCodeCacheModel.discount = getDiscount();

		rsvpPromoCodeCacheModel.modifiedBy = getModifiedBy();

		return rsvpPromoCodeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", rsvpPromoCodeId=");
		sb.append(getRsvpPromoCodeId());
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
		sb.append(", rsvpId=");
		sb.append(getRsvpId());
		sb.append(", rsvpTicketId=");
		sb.append(getRsvpTicketId());
		sb.append(", promoCode=");
		sb.append(getPromoCode());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", noOfTickets=");
		sb.append(getNoOfTickets());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.rsvp.model.RsvpPromoCode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpPromoCodeId</column-name><column-value><![CDATA[");
		sb.append(getRsvpPromoCodeId());
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
			"<column><column-name>rsvpId</column-name><column-value><![CDATA[");
		sb.append(getRsvpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpTicketId</column-name><column-value><![CDATA[");
		sb.append(getRsvpTicketId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promoCode</column-name><column-value><![CDATA[");
		sb.append(getPromoCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromDate</column-name><column-value><![CDATA[");
		sb.append(getFromDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toDate</column-name><column-value><![CDATA[");
		sb.append(getToDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noOfTickets</column-name><column-value><![CDATA[");
		sb.append(getNoOfTickets());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = RsvpPromoCode.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			RsvpPromoCode.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _rsvpPromoCodeId;
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
	private long _rsvpId;
	private long _originalRsvpId;
	private boolean _setOriginalRsvpId;
	private long _rsvpTicketId;
	private String _promoCode;
	private String _originalPromoCode;
	private Date _fromDate;
	private Date _toDate;
	private int _noOfTickets;
	private int _discount;
	private long _modifiedBy;
	private long _columnBitmask;
	private RsvpPromoCode _escapedModel;
}