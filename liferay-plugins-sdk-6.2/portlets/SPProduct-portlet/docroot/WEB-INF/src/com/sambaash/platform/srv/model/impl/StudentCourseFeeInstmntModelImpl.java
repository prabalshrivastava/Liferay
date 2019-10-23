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

import com.sambaash.platform.srv.model.StudentCourseFeeInstmnt;
import com.sambaash.platform.srv.model.StudentCourseFeeInstmntModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the StudentCourseFeeInstmnt service. Represents a row in the &quot;SPStudentCourseFeeInstmnt&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.model.StudentCourseFeeInstmntModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudentCourseFeeInstmntImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeeInstmntImpl
 * @see com.sambaash.platform.srv.model.StudentCourseFeeInstmnt
 * @see com.sambaash.platform.srv.model.StudentCourseFeeInstmntModel
 * @generated
 */
public class StudentCourseFeeInstmntModelImpl extends BaseModelImpl<StudentCourseFeeInstmnt>
	implements StudentCourseFeeInstmntModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student course fee instmnt model instance should use the {@link com.sambaash.platform.srv.model.StudentCourseFeeInstmnt} interface instead.
	 */
	public static final String TABLE_NAME = "SPStudentCourseFeeInstmnt";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spStudentCourseFeeInstmntId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "spPEProcessStateId", Types.BIGINT },
			{ "insmntNo", Types.INTEGER },
			{ "amount", Types.VARCHAR },
			{ "date_", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table SPStudentCourseFeeInstmnt (spStudentCourseFeeInstmntId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,spPEProcessStateId BIGINT(20),insmntNo INTEGER,amount VARCHAR(75) null,date_ DATETIME null)";
	public static final String TABLE_SQL_DROP = "drop table SPStudentCourseFeeInstmnt";
	public static final String ORDER_BY_JPQL = " ORDER BY studentCourseFeeInstmnt.spStudentCourseFeeInstmntId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPStudentCourseFeeInstmnt.spStudentCourseFeeInstmntId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.model.StudentCourseFeeInstmnt"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.model.StudentCourseFeeInstmnt"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.model.StudentCourseFeeInstmnt"),
			true);
	public static long INSMNTNO_COLUMN_BITMASK = 1L;
	public static long SPPEPROCESSSTATEID_COLUMN_BITMASK = 2L;
	public static long SPSTUDENTCOURSEFEEINSTMNTID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.model.StudentCourseFeeInstmnt"));

	public StudentCourseFeeInstmntModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spStudentCourseFeeInstmntId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpStudentCourseFeeInstmntId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spStudentCourseFeeInstmntId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StudentCourseFeeInstmnt.class;
	}

	@Override
	public String getModelClassName() {
		return StudentCourseFeeInstmnt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudentCourseFeeInstmntId",
			getSpStudentCourseFeeInstmntId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessStateId", getSpPEProcessStateId());
		attributes.put("insmntNo", getInsmntNo());
		attributes.put("amount", getAmount());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudentCourseFeeInstmntId = (Long)attributes.get(
				"spStudentCourseFeeInstmntId");

		if (spStudentCourseFeeInstmntId != null) {
			setSpStudentCourseFeeInstmntId(spStudentCourseFeeInstmntId);
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

		Long spPEProcessStateId = (Long)attributes.get("spPEProcessStateId");

		if (spPEProcessStateId != null) {
			setSpPEProcessStateId(spPEProcessStateId);
		}

		Integer insmntNo = (Integer)attributes.get("insmntNo");

		if (insmntNo != null) {
			setInsmntNo(insmntNo);
		}

		String amount = (String)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@Override
	public long getSpStudentCourseFeeInstmntId() {
		return _spStudentCourseFeeInstmntId;
	}

	@Override
	public void setSpStudentCourseFeeInstmntId(long spStudentCourseFeeInstmntId) {
		_spStudentCourseFeeInstmntId = spStudentCourseFeeInstmntId;
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
	public long getSpPEProcessStateId() {
		return _spPEProcessStateId;
	}

	@Override
	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_columnBitmask |= SPPEPROCESSSTATEID_COLUMN_BITMASK;

		if (!_setOriginalSpPEProcessStateId) {
			_setOriginalSpPEProcessStateId = true;

			_originalSpPEProcessStateId = _spPEProcessStateId;
		}

		_spPEProcessStateId = spPEProcessStateId;
	}

	public long getOriginalSpPEProcessStateId() {
		return _originalSpPEProcessStateId;
	}

	@Override
	public int getInsmntNo() {
		return _insmntNo;
	}

	@Override
	public void setInsmntNo(int insmntNo) {
		_columnBitmask |= INSMNTNO_COLUMN_BITMASK;

		if (!_setOriginalInsmntNo) {
			_setOriginalInsmntNo = true;

			_originalInsmntNo = _insmntNo;
		}

		_insmntNo = insmntNo;
	}

	public int getOriginalInsmntNo() {
		return _originalInsmntNo;
	}

	@Override
	public String getAmount() {
		if (_amount == null) {
			return StringPool.BLANK;
		}
		else {
			return _amount;
		}
	}

	@Override
	public void setAmount(String amount) {
		_amount = amount;
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			StudentCourseFeeInstmnt.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StudentCourseFeeInstmnt toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StudentCourseFeeInstmnt)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StudentCourseFeeInstmntImpl studentCourseFeeInstmntImpl = new StudentCourseFeeInstmntImpl();

		studentCourseFeeInstmntImpl.setSpStudentCourseFeeInstmntId(getSpStudentCourseFeeInstmntId());
		studentCourseFeeInstmntImpl.setGroupId(getGroupId());
		studentCourseFeeInstmntImpl.setCompanyId(getCompanyId());
		studentCourseFeeInstmntImpl.setUserId(getUserId());
		studentCourseFeeInstmntImpl.setUserName(getUserName());
		studentCourseFeeInstmntImpl.setCreateDate(getCreateDate());
		studentCourseFeeInstmntImpl.setModifiedDate(getModifiedDate());
		studentCourseFeeInstmntImpl.setSpPEProcessStateId(getSpPEProcessStateId());
		studentCourseFeeInstmntImpl.setInsmntNo(getInsmntNo());
		studentCourseFeeInstmntImpl.setAmount(getAmount());
		studentCourseFeeInstmntImpl.setDate(getDate());

		studentCourseFeeInstmntImpl.resetOriginalValues();

		return studentCourseFeeInstmntImpl;
	}

	@Override
	public int compareTo(StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		long primaryKey = studentCourseFeeInstmnt.getPrimaryKey();

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

		if (!(obj instanceof StudentCourseFeeInstmnt)) {
			return false;
		}

		StudentCourseFeeInstmnt studentCourseFeeInstmnt = (StudentCourseFeeInstmnt)obj;

		long primaryKey = studentCourseFeeInstmnt.getPrimaryKey();

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
		StudentCourseFeeInstmntModelImpl studentCourseFeeInstmntModelImpl = this;

		studentCourseFeeInstmntModelImpl._originalSpPEProcessStateId = studentCourseFeeInstmntModelImpl._spPEProcessStateId;

		studentCourseFeeInstmntModelImpl._setOriginalSpPEProcessStateId = false;

		studentCourseFeeInstmntModelImpl._originalInsmntNo = studentCourseFeeInstmntModelImpl._insmntNo;

		studentCourseFeeInstmntModelImpl._setOriginalInsmntNo = false;

		studentCourseFeeInstmntModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StudentCourseFeeInstmnt> toCacheModel() {
		StudentCourseFeeInstmntCacheModel studentCourseFeeInstmntCacheModel = new StudentCourseFeeInstmntCacheModel();

		studentCourseFeeInstmntCacheModel.spStudentCourseFeeInstmntId = getSpStudentCourseFeeInstmntId();

		studentCourseFeeInstmntCacheModel.groupId = getGroupId();

		studentCourseFeeInstmntCacheModel.companyId = getCompanyId();

		studentCourseFeeInstmntCacheModel.userId = getUserId();

		studentCourseFeeInstmntCacheModel.userName = getUserName();

		String userName = studentCourseFeeInstmntCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			studentCourseFeeInstmntCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			studentCourseFeeInstmntCacheModel.createDate = createDate.getTime();
		}
		else {
			studentCourseFeeInstmntCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			studentCourseFeeInstmntCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			studentCourseFeeInstmntCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		studentCourseFeeInstmntCacheModel.spPEProcessStateId = getSpPEProcessStateId();

		studentCourseFeeInstmntCacheModel.insmntNo = getInsmntNo();

		studentCourseFeeInstmntCacheModel.amount = getAmount();

		String amount = studentCourseFeeInstmntCacheModel.amount;

		if ((amount != null) && (amount.length() == 0)) {
			studentCourseFeeInstmntCacheModel.amount = null;
		}

		Date date = getDate();

		if (date != null) {
			studentCourseFeeInstmntCacheModel.date = date.getTime();
		}
		else {
			studentCourseFeeInstmntCacheModel.date = Long.MIN_VALUE;
		}

		return studentCourseFeeInstmntCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spStudentCourseFeeInstmntId=");
		sb.append(getSpStudentCourseFeeInstmntId());
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
		sb.append(", spPEProcessStateId=");
		sb.append(getSpPEProcessStateId());
		sb.append(", insmntNo=");
		sb.append(getInsmntNo());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", date=");
		sb.append(getDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.StudentCourseFeeInstmnt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spStudentCourseFeeInstmntId</column-name><column-value><![CDATA[");
		sb.append(getSpStudentCourseFeeInstmntId());
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
			"<column><column-name>spPEProcessStateId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insmntNo</column-name><column-value><![CDATA[");
		sb.append(getInsmntNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = StudentCourseFeeInstmnt.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StudentCourseFeeInstmnt.class
		};
	private long _spStudentCourseFeeInstmntId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPEProcessStateId;
	private long _originalSpPEProcessStateId;
	private boolean _setOriginalSpPEProcessStateId;
	private int _insmntNo;
	private int _originalInsmntNo;
	private boolean _setOriginalInsmntNo;
	private String _amount;
	private Date _date;
	private long _columnBitmask;
	private StudentCourseFeeInstmnt _escapedModel;
}