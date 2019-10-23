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

import com.sambaash.platform.srv.model.DurationType;
import com.sambaash.platform.srv.model.DurationTypeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DurationType service. Represents a row in the &quot;SPDurationType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.model.DurationTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DurationTypeImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see DurationTypeImpl
 * @see com.sambaash.platform.srv.model.DurationType
 * @see com.sambaash.platform.srv.model.DurationTypeModel
 * @generated
 */
public class DurationTypeModelImpl extends BaseModelImpl<DurationType>
	implements DurationTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a duration type model instance should use the {@link com.sambaash.platform.srv.model.DurationType} interface instead.
	 */
	public static final String TABLE_NAME = "SPDurationType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spDurationTypeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "spLearningDurationId", Types.BIGINT },
			{ "spCourseId", Types.BIGINT },
			{ "title1", Types.VARCHAR },
			{ "duration1", Types.BIGINT },
			{ "title2", Types.VARCHAR },
			{ "duration2", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPDurationType (spDurationTypeId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,spLearningDurationId BIGINT(20),spCourseId BIGINT(20),title1 VARCHAR(75) null,duration1 BIGINT(20),title2 VARCHAR(75) null,duration2 BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPDurationType";
	public static final String ORDER_BY_JPQL = " ORDER BY durationType.spDurationTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPDurationType.spDurationTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.model.DurationType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.model.DurationType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.model.DurationType"));

	public DurationTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spDurationTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpDurationTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spDurationTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DurationType.class;
	}

	@Override
	public String getModelClassName() {
		return DurationType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spDurationTypeId", getSpDurationTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spLearningDurationId", getSpLearningDurationId());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("title1", getTitle1());
		attributes.put("duration1", getDuration1());
		attributes.put("title2", getTitle2());
		attributes.put("duration2", getDuration2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spDurationTypeId = (Long)attributes.get("spDurationTypeId");

		if (spDurationTypeId != null) {
			setSpDurationTypeId(spDurationTypeId);
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

		Long spLearningDurationId = (Long)attributes.get("spLearningDurationId");

		if (spLearningDurationId != null) {
			setSpLearningDurationId(spLearningDurationId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}

		String title1 = (String)attributes.get("title1");

		if (title1 != null) {
			setTitle1(title1);
		}

		Long duration1 = (Long)attributes.get("duration1");

		if (duration1 != null) {
			setDuration1(duration1);
		}

		String title2 = (String)attributes.get("title2");

		if (title2 != null) {
			setTitle2(title2);
		}

		Long duration2 = (Long)attributes.get("duration2");

		if (duration2 != null) {
			setDuration2(duration2);
		}
	}

	@Override
	public long getSpDurationTypeId() {
		return _spDurationTypeId;
	}

	@Override
	public void setSpDurationTypeId(long spDurationTypeId) {
		_spDurationTypeId = spDurationTypeId;
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
	public long getSpLearningDurationId() {
		return _spLearningDurationId;
	}

	@Override
	public void setSpLearningDurationId(long spLearningDurationId) {
		_spLearningDurationId = spLearningDurationId;
	}

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	@Override
	public String getTitle1() {
		if (_title1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _title1;
		}
	}

	@Override
	public void setTitle1(String title1) {
		_title1 = title1;
	}

	@Override
	public long getDuration1() {
		return _duration1;
	}

	@Override
	public void setDuration1(long duration1) {
		_duration1 = duration1;
	}

	@Override
	public String getTitle2() {
		if (_title2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _title2;
		}
	}

	@Override
	public void setTitle2(String title2) {
		_title2 = title2;
	}

	@Override
	public long getDuration2() {
		return _duration2;
	}

	@Override
	public void setDuration2(long duration2) {
		_duration2 = duration2;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DurationType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DurationType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DurationType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DurationTypeImpl durationTypeImpl = new DurationTypeImpl();

		durationTypeImpl.setSpDurationTypeId(getSpDurationTypeId());
		durationTypeImpl.setGroupId(getGroupId());
		durationTypeImpl.setCompanyId(getCompanyId());
		durationTypeImpl.setUserId(getUserId());
		durationTypeImpl.setUserName(getUserName());
		durationTypeImpl.setCreateDate(getCreateDate());
		durationTypeImpl.setModifiedDate(getModifiedDate());
		durationTypeImpl.setSpLearningDurationId(getSpLearningDurationId());
		durationTypeImpl.setSpCourseId(getSpCourseId());
		durationTypeImpl.setTitle1(getTitle1());
		durationTypeImpl.setDuration1(getDuration1());
		durationTypeImpl.setTitle2(getTitle2());
		durationTypeImpl.setDuration2(getDuration2());

		durationTypeImpl.resetOriginalValues();

		return durationTypeImpl;
	}

	@Override
	public int compareTo(DurationType durationType) {
		long primaryKey = durationType.getPrimaryKey();

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

		if (!(obj instanceof DurationType)) {
			return false;
		}

		DurationType durationType = (DurationType)obj;

		long primaryKey = durationType.getPrimaryKey();

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
	}

	@Override
	public CacheModel<DurationType> toCacheModel() {
		DurationTypeCacheModel durationTypeCacheModel = new DurationTypeCacheModel();

		durationTypeCacheModel.spDurationTypeId = getSpDurationTypeId();

		durationTypeCacheModel.groupId = getGroupId();

		durationTypeCacheModel.companyId = getCompanyId();

		durationTypeCacheModel.userId = getUserId();

		durationTypeCacheModel.userName = getUserName();

		String userName = durationTypeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			durationTypeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			durationTypeCacheModel.createDate = createDate.getTime();
		}
		else {
			durationTypeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			durationTypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			durationTypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		durationTypeCacheModel.spLearningDurationId = getSpLearningDurationId();

		durationTypeCacheModel.spCourseId = getSpCourseId();

		durationTypeCacheModel.title1 = getTitle1();

		String title1 = durationTypeCacheModel.title1;

		if ((title1 != null) && (title1.length() == 0)) {
			durationTypeCacheModel.title1 = null;
		}

		durationTypeCacheModel.duration1 = getDuration1();

		durationTypeCacheModel.title2 = getTitle2();

		String title2 = durationTypeCacheModel.title2;

		if ((title2 != null) && (title2.length() == 0)) {
			durationTypeCacheModel.title2 = null;
		}

		durationTypeCacheModel.duration2 = getDuration2();

		return durationTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spDurationTypeId=");
		sb.append(getSpDurationTypeId());
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
		sb.append(", spLearningDurationId=");
		sb.append(getSpLearningDurationId());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append(", title1=");
		sb.append(getTitle1());
		sb.append(", duration1=");
		sb.append(getDuration1());
		sb.append(", title2=");
		sb.append(getTitle2());
		sb.append(", duration2=");
		sb.append(getDuration2());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.DurationType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spDurationTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpDurationTypeId());
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
			"<column><column-name>spLearningDurationId</column-name><column-value><![CDATA[");
		sb.append(getSpLearningDurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title1</column-name><column-value><![CDATA[");
		sb.append(getTitle1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration1</column-name><column-value><![CDATA[");
		sb.append(getDuration1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title2</column-name><column-value><![CDATA[");
		sb.append(getTitle2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration2</column-name><column-value><![CDATA[");
		sb.append(getDuration2());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DurationType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DurationType.class
		};
	private long _spDurationTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spLearningDurationId;
	private long _spCourseId;
	private String _title1;
	private long _duration1;
	private String _title2;
	private long _duration2;
	private DurationType _escapedModel;
}