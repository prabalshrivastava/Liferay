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

import com.sambaash.platform.srv.model.CourseCertificate;
import com.sambaash.platform.srv.model.CourseCertificateModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CourseCertificate service. Represents a row in the &quot;SPCourseCertificate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.model.CourseCertificateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CourseCertificateImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseCertificateImpl
 * @see com.sambaash.platform.srv.model.CourseCertificate
 * @see com.sambaash.platform.srv.model.CourseCertificateModel
 * @generated
 */
public class CourseCertificateModelImpl extends BaseModelImpl<CourseCertificate>
	implements CourseCertificateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a course certificate model instance should use the {@link com.sambaash.platform.srv.model.CourseCertificate} interface instead.
	 */
	public static final String TABLE_NAME = "SPCourseCertificate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spCourseCertificateId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "spCourseId", Types.BIGINT },
			{ "spCertificatetId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPCourseCertificate (spCourseCertificateId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,spCourseId BIGINT(20),spCertificatetId BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPCourseCertificate";
	public static final String ORDER_BY_JPQL = " ORDER BY courseCertificate.spCourseId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPCourseCertificate.spCourseId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.model.CourseCertificate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.model.CourseCertificate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.model.CourseCertificate"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long SPCERTIFICATETID_COLUMN_BITMASK = 2L;
	public static long SPCOURSEID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.model.CourseCertificate"));

	public CourseCertificateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spCourseCertificateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCourseCertificateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCourseCertificateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CourseCertificate.class;
	}

	@Override
	public String getModelClassName() {
		return CourseCertificate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseCertificateId", getSpCourseCertificateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("spCertificatetId", getSpCertificatetId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseCertificateId = (Long)attributes.get(
				"spCourseCertificateId");

		if (spCourseCertificateId != null) {
			setSpCourseCertificateId(spCourseCertificateId);
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

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}

		Long spCertificatetId = (Long)attributes.get("spCertificatetId");

		if (spCertificatetId != null) {
			setSpCertificatetId(spCertificatetId);
		}
	}

	@Override
	public long getSpCourseCertificateId() {
		return _spCourseCertificateId;
	}

	@Override
	public void setSpCourseCertificateId(long spCourseCertificateId) {
		_spCourseCertificateId = spCourseCertificateId;
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
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_columnBitmask = -1L;

		if (!_setOriginalSpCourseId) {
			_setOriginalSpCourseId = true;

			_originalSpCourseId = _spCourseId;
		}

		_spCourseId = spCourseId;
	}

	public long getOriginalSpCourseId() {
		return _originalSpCourseId;
	}

	@Override
	public long getSpCertificatetId() {
		return _spCertificatetId;
	}

	@Override
	public void setSpCertificatetId(long spCertificatetId) {
		_columnBitmask |= SPCERTIFICATETID_COLUMN_BITMASK;

		if (!_setOriginalSpCertificatetId) {
			_setOriginalSpCertificatetId = true;

			_originalSpCertificatetId = _spCertificatetId;
		}

		_spCertificatetId = spCertificatetId;
	}

	public long getOriginalSpCertificatetId() {
		return _originalSpCertificatetId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CourseCertificate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CourseCertificate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CourseCertificate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CourseCertificateImpl courseCertificateImpl = new CourseCertificateImpl();

		courseCertificateImpl.setSpCourseCertificateId(getSpCourseCertificateId());
		courseCertificateImpl.setGroupId(getGroupId());
		courseCertificateImpl.setCompanyId(getCompanyId());
		courseCertificateImpl.setUserId(getUserId());
		courseCertificateImpl.setUserName(getUserName());
		courseCertificateImpl.setCreateDate(getCreateDate());
		courseCertificateImpl.setModifiedDate(getModifiedDate());
		courseCertificateImpl.setSpCourseId(getSpCourseId());
		courseCertificateImpl.setSpCertificatetId(getSpCertificatetId());

		courseCertificateImpl.resetOriginalValues();

		return courseCertificateImpl;
	}

	@Override
	public int compareTo(CourseCertificate courseCertificate) {
		int value = 0;

		if (getSpCourseId() < courseCertificate.getSpCourseId()) {
			value = -1;
		}
		else if (getSpCourseId() > courseCertificate.getSpCourseId()) {
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

		if (!(obj instanceof CourseCertificate)) {
			return false;
		}

		CourseCertificate courseCertificate = (CourseCertificate)obj;

		long primaryKey = courseCertificate.getPrimaryKey();

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
		CourseCertificateModelImpl courseCertificateModelImpl = this;

		courseCertificateModelImpl._originalGroupId = courseCertificateModelImpl._groupId;

		courseCertificateModelImpl._setOriginalGroupId = false;

		courseCertificateModelImpl._originalSpCourseId = courseCertificateModelImpl._spCourseId;

		courseCertificateModelImpl._setOriginalSpCourseId = false;

		courseCertificateModelImpl._originalSpCertificatetId = courseCertificateModelImpl._spCertificatetId;

		courseCertificateModelImpl._setOriginalSpCertificatetId = false;

		courseCertificateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CourseCertificate> toCacheModel() {
		CourseCertificateCacheModel courseCertificateCacheModel = new CourseCertificateCacheModel();

		courseCertificateCacheModel.spCourseCertificateId = getSpCourseCertificateId();

		courseCertificateCacheModel.groupId = getGroupId();

		courseCertificateCacheModel.companyId = getCompanyId();

		courseCertificateCacheModel.userId = getUserId();

		courseCertificateCacheModel.userName = getUserName();

		String userName = courseCertificateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			courseCertificateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			courseCertificateCacheModel.createDate = createDate.getTime();
		}
		else {
			courseCertificateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			courseCertificateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			courseCertificateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		courseCertificateCacheModel.spCourseId = getSpCourseId();

		courseCertificateCacheModel.spCertificatetId = getSpCertificatetId();

		return courseCertificateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{spCourseCertificateId=");
		sb.append(getSpCourseCertificateId());
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
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append(", spCertificatetId=");
		sb.append(getSpCertificatetId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.CourseCertificate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCourseCertificateId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseCertificateId());
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
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCertificatetId</column-name><column-value><![CDATA[");
		sb.append(getSpCertificatetId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CourseCertificate.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CourseCertificate.class
		};
	private long _spCourseCertificateId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseId;
	private long _originalSpCourseId;
	private boolean _setOriginalSpCourseId;
	private long _spCertificatetId;
	private long _originalSpCertificatetId;
	private boolean _setOriginalSpCertificatetId;
	private long _columnBitmask;
	private CourseCertificate _escapedModel;
}