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

package com.liferay.calendar.model.impl;

import com.liferay.calendar.model.CalendarNotificationTemplate;
import com.liferay.calendar.model.CalendarNotificationTemplateModel;
import com.liferay.calendar.model.CalendarNotificationTemplateSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
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

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CalendarNotificationTemplate service. Represents a row in the &quot;CalendarNotificationTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.calendar.model.CalendarNotificationTemplateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarNotificationTemplateImpl}.
 * </p>
 *
 * @author Eduardo Lundgren
 * @see CalendarNotificationTemplateImpl
 * @see com.liferay.calendar.model.CalendarNotificationTemplate
 * @see com.liferay.calendar.model.CalendarNotificationTemplateModel
 * @generated
 */
@JSON(strict = true)
public class CalendarNotificationTemplateModelImpl extends BaseModelImpl<CalendarNotificationTemplate>
	implements CalendarNotificationTemplateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar notification template model instance should use the {@link com.liferay.calendar.model.CalendarNotificationTemplate} interface instead.
	 */
	public static final String TABLE_NAME = "CalendarNotificationTemplate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "calendarNotificationTemplateId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "calendarId", Types.BIGINT },
			{ "notificationType", Types.VARCHAR },
			{ "notificationTypeSettings", Types.VARCHAR },
			{ "notificationTemplateType", Types.VARCHAR },
			{ "subject", Types.VARCHAR },
			{ "body", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table CalendarNotificationTemplate (uuid_ VARCHAR(75) null,calendarNotificationTemplateId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,calendarId BIGINT(20),notificationType VARCHAR(75) null,notificationTypeSettings VARCHAR(75) null,notificationTemplateType VARCHAR(75) null,subject VARCHAR(75) null,body LONGTEXT null)";
	public static final String TABLE_SQL_DROP = "drop table CalendarNotificationTemplate";
	public static final String ORDER_BY_JPQL = " ORDER BY calendarNotificationTemplate.calendarNotificationTemplateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CalendarNotificationTemplate.calendarNotificationTemplateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.calendar.model.CalendarNotificationTemplate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.calendar.model.CalendarNotificationTemplate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.calendar.model.CalendarNotificationTemplate"),
			true);
	public static long CALENDARID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long NOTIFICATIONTEMPLATETYPE_COLUMN_BITMASK = 8L;
	public static long NOTIFICATIONTYPE_COLUMN_BITMASK = 16L;
	public static long UUID_COLUMN_BITMASK = 32L;
	public static long CALENDARNOTIFICATIONTEMPLATEID_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CalendarNotificationTemplate toModel(
		CalendarNotificationTemplateSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CalendarNotificationTemplate model = new CalendarNotificationTemplateImpl();

		model.setUuid(soapModel.getUuid());
		model.setCalendarNotificationTemplateId(soapModel.getCalendarNotificationTemplateId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCalendarId(soapModel.getCalendarId());
		model.setNotificationType(soapModel.getNotificationType());
		model.setNotificationTypeSettings(soapModel.getNotificationTypeSettings());
		model.setNotificationTemplateType(soapModel.getNotificationTemplateType());
		model.setSubject(soapModel.getSubject());
		model.setBody(soapModel.getBody());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CalendarNotificationTemplate> toModels(
		CalendarNotificationTemplateSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CalendarNotificationTemplate> models = new ArrayList<CalendarNotificationTemplate>(soapModels.length);

		for (CalendarNotificationTemplateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.calendar.model.CalendarNotificationTemplate"));

	public CalendarNotificationTemplateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _calendarNotificationTemplateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCalendarNotificationTemplateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _calendarNotificationTemplateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CalendarNotificationTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return CalendarNotificationTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("calendarNotificationTemplateId",
			getCalendarNotificationTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("calendarId", getCalendarId());
		attributes.put("notificationType", getNotificationType());
		attributes.put("notificationTypeSettings", getNotificationTypeSettings());
		attributes.put("notificationTemplateType", getNotificationTemplateType());
		attributes.put("subject", getSubject());
		attributes.put("body", getBody());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long calendarNotificationTemplateId = (Long)attributes.get(
				"calendarNotificationTemplateId");

		if (calendarNotificationTemplateId != null) {
			setCalendarNotificationTemplateId(calendarNotificationTemplateId);
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

		Long calendarId = (Long)attributes.get("calendarId");

		if (calendarId != null) {
			setCalendarId(calendarId);
		}

		String notificationType = (String)attributes.get("notificationType");

		if (notificationType != null) {
			setNotificationType(notificationType);
		}

		String notificationTypeSettings = (String)attributes.get(
				"notificationTypeSettings");

		if (notificationTypeSettings != null) {
			setNotificationTypeSettings(notificationTypeSettings);
		}

		String notificationTemplateType = (String)attributes.get(
				"notificationTemplateType");

		if (notificationTemplateType != null) {
			setNotificationTemplateType(notificationTemplateType);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}
	}

	@JSON
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

	@JSON
	@Override
	public long getCalendarNotificationTemplateId() {
		return _calendarNotificationTemplateId;
	}

	@Override
	public void setCalendarNotificationTemplateId(
		long calendarNotificationTemplateId) {
		_calendarNotificationTemplateId = calendarNotificationTemplateId;
	}

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCalendarId() {
		return _calendarId;
	}

	@Override
	public void setCalendarId(long calendarId) {
		_columnBitmask |= CALENDARID_COLUMN_BITMASK;

		if (!_setOriginalCalendarId) {
			_setOriginalCalendarId = true;

			_originalCalendarId = _calendarId;
		}

		_calendarId = calendarId;
	}

	public long getOriginalCalendarId() {
		return _originalCalendarId;
	}

	@JSON
	@Override
	public String getNotificationType() {
		if (_notificationType == null) {
			return StringPool.BLANK;
		}
		else {
			return _notificationType;
		}
	}

	@Override
	public void setNotificationType(String notificationType) {
		_columnBitmask |= NOTIFICATIONTYPE_COLUMN_BITMASK;

		if (_originalNotificationType == null) {
			_originalNotificationType = _notificationType;
		}

		_notificationType = notificationType;
	}

	public String getOriginalNotificationType() {
		return GetterUtil.getString(_originalNotificationType);
	}

	@JSON
	@Override
	public String getNotificationTypeSettings() {
		if (_notificationTypeSettings == null) {
			return StringPool.BLANK;
		}
		else {
			return _notificationTypeSettings;
		}
	}

	@Override
	public void setNotificationTypeSettings(String notificationTypeSettings) {
		_notificationTypeSettings = notificationTypeSettings;
	}

	@JSON
	@Override
	public String getNotificationTemplateType() {
		if (_notificationTemplateType == null) {
			return StringPool.BLANK;
		}
		else {
			return _notificationTemplateType;
		}
	}

	@Override
	public void setNotificationTemplateType(String notificationTemplateType) {
		_columnBitmask |= NOTIFICATIONTEMPLATETYPE_COLUMN_BITMASK;

		if (_originalNotificationTemplateType == null) {
			_originalNotificationTemplateType = _notificationTemplateType;
		}

		_notificationTemplateType = notificationTemplateType;
	}

	public String getOriginalNotificationTemplateType() {
		return GetterUtil.getString(_originalNotificationTemplateType);
	}

	@JSON
	@Override
	public String getSubject() {
		if (_subject == null) {
			return StringPool.BLANK;
		}
		else {
			return _subject;
		}
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;
	}

	@JSON
	@Override
	public String getBody() {
		if (_body == null) {
			return StringPool.BLANK;
		}
		else {
			return _body;
		}
	}

	@Override
	public void setBody(String body) {
		_body = body;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				CalendarNotificationTemplate.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CalendarNotificationTemplate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CalendarNotificationTemplate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CalendarNotificationTemplate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CalendarNotificationTemplateImpl calendarNotificationTemplateImpl = new CalendarNotificationTemplateImpl();

		calendarNotificationTemplateImpl.setUuid(getUuid());
		calendarNotificationTemplateImpl.setCalendarNotificationTemplateId(getCalendarNotificationTemplateId());
		calendarNotificationTemplateImpl.setGroupId(getGroupId());
		calendarNotificationTemplateImpl.setCompanyId(getCompanyId());
		calendarNotificationTemplateImpl.setUserId(getUserId());
		calendarNotificationTemplateImpl.setUserName(getUserName());
		calendarNotificationTemplateImpl.setCreateDate(getCreateDate());
		calendarNotificationTemplateImpl.setModifiedDate(getModifiedDate());
		calendarNotificationTemplateImpl.setCalendarId(getCalendarId());
		calendarNotificationTemplateImpl.setNotificationType(getNotificationType());
		calendarNotificationTemplateImpl.setNotificationTypeSettings(getNotificationTypeSettings());
		calendarNotificationTemplateImpl.setNotificationTemplateType(getNotificationTemplateType());
		calendarNotificationTemplateImpl.setSubject(getSubject());
		calendarNotificationTemplateImpl.setBody(getBody());

		calendarNotificationTemplateImpl.resetOriginalValues();

		return calendarNotificationTemplateImpl;
	}

	@Override
	public int compareTo(
		CalendarNotificationTemplate calendarNotificationTemplate) {
		long primaryKey = calendarNotificationTemplate.getPrimaryKey();

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

		if (!(obj instanceof CalendarNotificationTemplate)) {
			return false;
		}

		CalendarNotificationTemplate calendarNotificationTemplate = (CalendarNotificationTemplate)obj;

		long primaryKey = calendarNotificationTemplate.getPrimaryKey();

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
		CalendarNotificationTemplateModelImpl calendarNotificationTemplateModelImpl =
			this;

		calendarNotificationTemplateModelImpl._originalUuid = calendarNotificationTemplateModelImpl._uuid;

		calendarNotificationTemplateModelImpl._originalGroupId = calendarNotificationTemplateModelImpl._groupId;

		calendarNotificationTemplateModelImpl._setOriginalGroupId = false;

		calendarNotificationTemplateModelImpl._originalCompanyId = calendarNotificationTemplateModelImpl._companyId;

		calendarNotificationTemplateModelImpl._setOriginalCompanyId = false;

		calendarNotificationTemplateModelImpl._originalCalendarId = calendarNotificationTemplateModelImpl._calendarId;

		calendarNotificationTemplateModelImpl._setOriginalCalendarId = false;

		calendarNotificationTemplateModelImpl._originalNotificationType = calendarNotificationTemplateModelImpl._notificationType;

		calendarNotificationTemplateModelImpl._originalNotificationTemplateType = calendarNotificationTemplateModelImpl._notificationTemplateType;

		calendarNotificationTemplateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CalendarNotificationTemplate> toCacheModel() {
		CalendarNotificationTemplateCacheModel calendarNotificationTemplateCacheModel =
			new CalendarNotificationTemplateCacheModel();

		calendarNotificationTemplateCacheModel.uuid = getUuid();

		String uuid = calendarNotificationTemplateCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			calendarNotificationTemplateCacheModel.uuid = null;
		}

		calendarNotificationTemplateCacheModel.calendarNotificationTemplateId = getCalendarNotificationTemplateId();

		calendarNotificationTemplateCacheModel.groupId = getGroupId();

		calendarNotificationTemplateCacheModel.companyId = getCompanyId();

		calendarNotificationTemplateCacheModel.userId = getUserId();

		calendarNotificationTemplateCacheModel.userName = getUserName();

		String userName = calendarNotificationTemplateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			calendarNotificationTemplateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			calendarNotificationTemplateCacheModel.createDate = createDate.getTime();
		}
		else {
			calendarNotificationTemplateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			calendarNotificationTemplateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			calendarNotificationTemplateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		calendarNotificationTemplateCacheModel.calendarId = getCalendarId();

		calendarNotificationTemplateCacheModel.notificationType = getNotificationType();

		String notificationType = calendarNotificationTemplateCacheModel.notificationType;

		if ((notificationType != null) && (notificationType.length() == 0)) {
			calendarNotificationTemplateCacheModel.notificationType = null;
		}

		calendarNotificationTemplateCacheModel.notificationTypeSettings = getNotificationTypeSettings();

		String notificationTypeSettings = calendarNotificationTemplateCacheModel.notificationTypeSettings;

		if ((notificationTypeSettings != null) &&
				(notificationTypeSettings.length() == 0)) {
			calendarNotificationTemplateCacheModel.notificationTypeSettings = null;
		}

		calendarNotificationTemplateCacheModel.notificationTemplateType = getNotificationTemplateType();

		String notificationTemplateType = calendarNotificationTemplateCacheModel.notificationTemplateType;

		if ((notificationTemplateType != null) &&
				(notificationTemplateType.length() == 0)) {
			calendarNotificationTemplateCacheModel.notificationTemplateType = null;
		}

		calendarNotificationTemplateCacheModel.subject = getSubject();

		String subject = calendarNotificationTemplateCacheModel.subject;

		if ((subject != null) && (subject.length() == 0)) {
			calendarNotificationTemplateCacheModel.subject = null;
		}

		calendarNotificationTemplateCacheModel.body = getBody();

		String body = calendarNotificationTemplateCacheModel.body;

		if ((body != null) && (body.length() == 0)) {
			calendarNotificationTemplateCacheModel.body = null;
		}

		return calendarNotificationTemplateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", calendarNotificationTemplateId=");
		sb.append(getCalendarNotificationTemplateId());
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
		sb.append(", calendarId=");
		sb.append(getCalendarId());
		sb.append(", notificationType=");
		sb.append(getNotificationType());
		sb.append(", notificationTypeSettings=");
		sb.append(getNotificationTypeSettings());
		sb.append(", notificationTemplateType=");
		sb.append(getNotificationTemplateType());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", body=");
		sb.append(getBody());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.calendar.model.CalendarNotificationTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>calendarNotificationTemplateId</column-name><column-value><![CDATA[");
		sb.append(getCalendarNotificationTemplateId());
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
			"<column><column-name>calendarId</column-name><column-value><![CDATA[");
		sb.append(getCalendarId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationType</column-name><column-value><![CDATA[");
		sb.append(getNotificationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationTypeSettings</column-name><column-value><![CDATA[");
		sb.append(getNotificationTypeSettings());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationTemplateType</column-name><column-value><![CDATA[");
		sb.append(getNotificationTemplateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CalendarNotificationTemplate.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CalendarNotificationTemplate.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _calendarNotificationTemplateId;
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
	private long _calendarId;
	private long _originalCalendarId;
	private boolean _setOriginalCalendarId;
	private String _notificationType;
	private String _originalNotificationType;
	private String _notificationTypeSettings;
	private String _notificationTemplateType;
	private String _originalNotificationTemplateType;
	private String _subject;
	private String _body;
	private long _columnBitmask;
	private CalendarNotificationTemplate _escapedModel;
}