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

import com.sambaash.platform.srv.model.Conversation;
import com.sambaash.platform.srv.model.ConversationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Conversation service. Represents a row in the &quot;SPConversation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.model.ConversationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ConversationImpl}.
 * </p>
 *
 * @author aishwarya
 * @see ConversationImpl
 * @see com.sambaash.platform.srv.model.Conversation
 * @see com.sambaash.platform.srv.model.ConversationModel
 * @generated
 */
public class ConversationModelImpl extends BaseModelImpl<Conversation>
	implements ConversationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a conversation model instance should use the {@link com.sambaash.platform.srv.model.Conversation} interface instead.
	 */
	public static final String TABLE_NAME = "SPConversation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "spConversationId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "entityClassId", Types.BIGINT },
			{ "entityClassName", Types.VARCHAR },
			{ "entityId", Types.BIGINT },
			{ "sentByUserId", Types.BIGINT },
			{ "message", Types.VARCHAR },
			{ "fileEntryId", Types.VARCHAR },
			{ "associatedWith", Types.BIGINT },
			{ "restricted", Types.INTEGER },
			{ "status", Types.INTEGER },
			{ "parentConverstationId", Types.BIGINT },
			{ "currentPlId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPConversation (uuid_ VARCHAR(75) null,spConversationId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,entityClassId BIGINT(20),entityClassName VARCHAR(75) null,entityId BIGINT(20),sentByUserId BIGINT(20),message VARCHAR(75) null,fileEntryId VARCHAR(75) null,associatedWith BIGINT(20),restricted INTEGER,status INTEGER,parentConverstationId BIGINT(20),currentPlId BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPConversation";
	public static final String ORDER_BY_JPQL = " ORDER BY conversation.spConversationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPConversation.spConversationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.model.Conversation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.model.Conversation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.model.Conversation"),
			true);
	public static long ASSOCIATEDWITH_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long ENTITYCLASSID_COLUMN_BITMASK = 4L;
	public static long ENTITYID_COLUMN_BITMASK = 8L;
	public static long GROUPID_COLUMN_BITMASK = 16L;
	public static long PARENTCONVERSTATIONID_COLUMN_BITMASK = 32L;
	public static long RESTRICTED_COLUMN_BITMASK = 64L;
	public static long STATUS_COLUMN_BITMASK = 128L;
	public static long UUID_COLUMN_BITMASK = 256L;
	public static long SPCONVERSATIONID_COLUMN_BITMASK = 512L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.model.Conversation"));

	public ConversationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spConversationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpConversationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spConversationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Conversation.class;
	}

	@Override
	public String getModelClassName() {
		return Conversation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spConversationId", getSpConversationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("entityClassName", getEntityClassName());
		attributes.put("entityId", getEntityId());
		attributes.put("sentByUserId", getSentByUserId());
		attributes.put("message", getMessage());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("associatedWith", getAssociatedWith());
		attributes.put("restricted", getRestricted());
		attributes.put("status", getStatus());
		attributes.put("parentConverstationId", getParentConverstationId());
		attributes.put("currentPlId", getCurrentPlId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spConversationId = (Long)attributes.get("spConversationId");

		if (spConversationId != null) {
			setSpConversationId(spConversationId);
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

		Long entityClassId = (Long)attributes.get("entityClassId");

		if (entityClassId != null) {
			setEntityClassId(entityClassId);
		}

		String entityClassName = (String)attributes.get("entityClassName");

		if (entityClassName != null) {
			setEntityClassName(entityClassName);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long sentByUserId = (Long)attributes.get("sentByUserId");

		if (sentByUserId != null) {
			setSentByUserId(sentByUserId);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String fileEntryId = (String)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long associatedWith = (Long)attributes.get("associatedWith");

		if (associatedWith != null) {
			setAssociatedWith(associatedWith);
		}

		Integer restricted = (Integer)attributes.get("restricted");

		if (restricted != null) {
			setRestricted(restricted);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long parentConverstationId = (Long)attributes.get(
				"parentConverstationId");

		if (parentConverstationId != null) {
			setParentConverstationId(parentConverstationId);
		}

		Long currentPlId = (Long)attributes.get("currentPlId");

		if (currentPlId != null) {
			setCurrentPlId(currentPlId);
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
	public long getSpConversationId() {
		return _spConversationId;
	}

	@Override
	public void setSpConversationId(long spConversationId) {
		_spConversationId = spConversationId;
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
	public long getEntityClassId() {
		return _entityClassId;
	}

	@Override
	public void setEntityClassId(long entityClassId) {
		_columnBitmask |= ENTITYCLASSID_COLUMN_BITMASK;

		if (!_setOriginalEntityClassId) {
			_setOriginalEntityClassId = true;

			_originalEntityClassId = _entityClassId;
		}

		_entityClassId = entityClassId;
	}

	public long getOriginalEntityClassId() {
		return _originalEntityClassId;
	}

	@Override
	public String getEntityClassName() {
		if (_entityClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _entityClassName;
		}
	}

	@Override
	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;
	}

	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		_columnBitmask |= ENTITYID_COLUMN_BITMASK;

		if (!_setOriginalEntityId) {
			_setOriginalEntityId = true;

			_originalEntityId = _entityId;
		}

		_entityId = entityId;
	}

	public long getOriginalEntityId() {
		return _originalEntityId;
	}

	@Override
	public long getSentByUserId() {
		return _sentByUserId;
	}

	@Override
	public void setSentByUserId(long sentByUserId) {
		_sentByUserId = sentByUserId;
	}

	@Override
	public String getSentByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSentByUserId(), "uuid",
			_sentByUserUuid);
	}

	@Override
	public void setSentByUserUuid(String sentByUserUuid) {
		_sentByUserUuid = sentByUserUuid;
	}

	@Override
	public String getMessage() {
		if (_message == null) {
			return StringPool.BLANK;
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		_message = message;
	}

	@Override
	public String getFileEntryId() {
		if (_fileEntryId == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileEntryId;
		}
	}

	@Override
	public void setFileEntryId(String fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	@Override
	public long getAssociatedWith() {
		return _associatedWith;
	}

	@Override
	public void setAssociatedWith(long associatedWith) {
		_columnBitmask |= ASSOCIATEDWITH_COLUMN_BITMASK;

		if (!_setOriginalAssociatedWith) {
			_setOriginalAssociatedWith = true;

			_originalAssociatedWith = _associatedWith;
		}

		_associatedWith = associatedWith;
	}

	public long getOriginalAssociatedWith() {
		return _originalAssociatedWith;
	}

	@Override
	public int getRestricted() {
		return _restricted;
	}

	@Override
	public void setRestricted(int restricted) {
		_columnBitmask |= RESTRICTED_COLUMN_BITMASK;

		if (!_setOriginalRestricted) {
			_setOriginalRestricted = true;

			_originalRestricted = _restricted;
		}

		_restricted = restricted;
	}

	public int getOriginalRestricted() {
		return _originalRestricted;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public long getParentConverstationId() {
		return _parentConverstationId;
	}

	@Override
	public void setParentConverstationId(long parentConverstationId) {
		_columnBitmask |= PARENTCONVERSTATIONID_COLUMN_BITMASK;

		if (!_setOriginalParentConverstationId) {
			_setOriginalParentConverstationId = true;

			_originalParentConverstationId = _parentConverstationId;
		}

		_parentConverstationId = parentConverstationId;
	}

	public long getOriginalParentConverstationId() {
		return _originalParentConverstationId;
	}

	@Override
	public long getCurrentPlId() {
		return _currentPlId;
	}

	@Override
	public void setCurrentPlId(long currentPlId) {
		_currentPlId = currentPlId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Conversation.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Conversation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Conversation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Conversation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ConversationImpl conversationImpl = new ConversationImpl();

		conversationImpl.setUuid(getUuid());
		conversationImpl.setSpConversationId(getSpConversationId());
		conversationImpl.setGroupId(getGroupId());
		conversationImpl.setCompanyId(getCompanyId());
		conversationImpl.setUserId(getUserId());
		conversationImpl.setUserName(getUserName());
		conversationImpl.setCreateDate(getCreateDate());
		conversationImpl.setModifiedDate(getModifiedDate());
		conversationImpl.setEntityClassId(getEntityClassId());
		conversationImpl.setEntityClassName(getEntityClassName());
		conversationImpl.setEntityId(getEntityId());
		conversationImpl.setSentByUserId(getSentByUserId());
		conversationImpl.setMessage(getMessage());
		conversationImpl.setFileEntryId(getFileEntryId());
		conversationImpl.setAssociatedWith(getAssociatedWith());
		conversationImpl.setRestricted(getRestricted());
		conversationImpl.setStatus(getStatus());
		conversationImpl.setParentConverstationId(getParentConverstationId());
		conversationImpl.setCurrentPlId(getCurrentPlId());

		conversationImpl.resetOriginalValues();

		return conversationImpl;
	}

	@Override
	public int compareTo(Conversation conversation) {
		long primaryKey = conversation.getPrimaryKey();

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

		if (!(obj instanceof Conversation)) {
			return false;
		}

		Conversation conversation = (Conversation)obj;

		long primaryKey = conversation.getPrimaryKey();

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
		ConversationModelImpl conversationModelImpl = this;

		conversationModelImpl._originalUuid = conversationModelImpl._uuid;

		conversationModelImpl._originalGroupId = conversationModelImpl._groupId;

		conversationModelImpl._setOriginalGroupId = false;

		conversationModelImpl._originalCompanyId = conversationModelImpl._companyId;

		conversationModelImpl._setOriginalCompanyId = false;

		conversationModelImpl._originalEntityClassId = conversationModelImpl._entityClassId;

		conversationModelImpl._setOriginalEntityClassId = false;

		conversationModelImpl._originalEntityId = conversationModelImpl._entityId;

		conversationModelImpl._setOriginalEntityId = false;

		conversationModelImpl._originalAssociatedWith = conversationModelImpl._associatedWith;

		conversationModelImpl._setOriginalAssociatedWith = false;

		conversationModelImpl._originalRestricted = conversationModelImpl._restricted;

		conversationModelImpl._setOriginalRestricted = false;

		conversationModelImpl._originalStatus = conversationModelImpl._status;

		conversationModelImpl._setOriginalStatus = false;

		conversationModelImpl._originalParentConverstationId = conversationModelImpl._parentConverstationId;

		conversationModelImpl._setOriginalParentConverstationId = false;

		conversationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Conversation> toCacheModel() {
		ConversationCacheModel conversationCacheModel = new ConversationCacheModel();

		conversationCacheModel.uuid = getUuid();

		String uuid = conversationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			conversationCacheModel.uuid = null;
		}

		conversationCacheModel.spConversationId = getSpConversationId();

		conversationCacheModel.groupId = getGroupId();

		conversationCacheModel.companyId = getCompanyId();

		conversationCacheModel.userId = getUserId();

		conversationCacheModel.userName = getUserName();

		String userName = conversationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			conversationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			conversationCacheModel.createDate = createDate.getTime();
		}
		else {
			conversationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			conversationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			conversationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		conversationCacheModel.entityClassId = getEntityClassId();

		conversationCacheModel.entityClassName = getEntityClassName();

		String entityClassName = conversationCacheModel.entityClassName;

		if ((entityClassName != null) && (entityClassName.length() == 0)) {
			conversationCacheModel.entityClassName = null;
		}

		conversationCacheModel.entityId = getEntityId();

		conversationCacheModel.sentByUserId = getSentByUserId();

		conversationCacheModel.message = getMessage();

		String message = conversationCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			conversationCacheModel.message = null;
		}

		conversationCacheModel.fileEntryId = getFileEntryId();

		String fileEntryId = conversationCacheModel.fileEntryId;

		if ((fileEntryId != null) && (fileEntryId.length() == 0)) {
			conversationCacheModel.fileEntryId = null;
		}

		conversationCacheModel.associatedWith = getAssociatedWith();

		conversationCacheModel.restricted = getRestricted();

		conversationCacheModel.status = getStatus();

		conversationCacheModel.parentConverstationId = getParentConverstationId();

		conversationCacheModel.currentPlId = getCurrentPlId();

		return conversationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spConversationId=");
		sb.append(getSpConversationId());
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
		sb.append(", entityClassId=");
		sb.append(getEntityClassId());
		sb.append(", entityClassName=");
		sb.append(getEntityClassName());
		sb.append(", entityId=");
		sb.append(getEntityId());
		sb.append(", sentByUserId=");
		sb.append(getSentByUserId());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", associatedWith=");
		sb.append(getAssociatedWith());
		sb.append(", restricted=");
		sb.append(getRestricted());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", parentConverstationId=");
		sb.append(getParentConverstationId());
		sb.append(", currentPlId=");
		sb.append(getCurrentPlId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Conversation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spConversationId</column-name><column-value><![CDATA[");
		sb.append(getSpConversationId());
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
			"<column><column-name>entityClassId</column-name><column-value><![CDATA[");
		sb.append(getEntityClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassName</column-name><column-value><![CDATA[");
		sb.append(getEntityClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentByUserId</column-name><column-value><![CDATA[");
		sb.append(getSentByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>associatedWith</column-name><column-value><![CDATA[");
		sb.append(getAssociatedWith());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>restricted</column-name><column-value><![CDATA[");
		sb.append(getRestricted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentConverstationId</column-name><column-value><![CDATA[");
		sb.append(getParentConverstationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentPlId</column-name><column-value><![CDATA[");
		sb.append(getCurrentPlId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Conversation.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Conversation.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _spConversationId;
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
	private long _entityClassId;
	private long _originalEntityClassId;
	private boolean _setOriginalEntityClassId;
	private String _entityClassName;
	private long _entityId;
	private long _originalEntityId;
	private boolean _setOriginalEntityId;
	private long _sentByUserId;
	private String _sentByUserUuid;
	private String _message;
	private String _fileEntryId;
	private long _associatedWith;
	private long _originalAssociatedWith;
	private boolean _setOriginalAssociatedWith;
	private int _restricted;
	private int _originalRestricted;
	private boolean _setOriginalRestricted;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _parentConverstationId;
	private long _originalParentConverstationId;
	private boolean _setOriginalParentConverstationId;
	private long _currentPlId;
	private long _columnBitmask;
	private Conversation _escapedModel;
}