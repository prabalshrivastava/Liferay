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

package com.sambaash.platform.srv.processbuilder.model.impl;

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

import com.sambaash.platform.srv.processbuilder.model.PECustomAction;
import com.sambaash.platform.srv.processbuilder.model.PECustomActionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PECustomAction service. Represents a row in the &quot;SPPECustomAction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.processbuilder.model.PECustomActionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PECustomActionImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see PECustomActionImpl
 * @see com.sambaash.platform.srv.processbuilder.model.PECustomAction
 * @see com.sambaash.platform.srv.processbuilder.model.PECustomActionModel
 * @generated
 */
public class PECustomActionModelImpl extends BaseModelImpl<PECustomAction>
	implements PECustomActionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a p e custom action model instance should use the {@link com.sambaash.platform.srv.processbuilder.model.PECustomAction} interface instead.
	 */
	public static final String TABLE_NAME = "SPPECustomAction";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "spPEActionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "actionClassName", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "defaultConfiguration", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SPPECustomAction (uuid_ VARCHAR(75) null,spPEActionId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,actionClassName VARCHAR(75) null,title VARCHAR(75) null,defaultConfiguration VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SPPECustomAction";
	public static final String ORDER_BY_JPQL = " ORDER BY peCustomAction.title ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPPECustomAction.title ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.processbuilder.model.PECustomAction"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.processbuilder.model.PECustomAction"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.processbuilder.model.PECustomAction"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;
	public static long TITLE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.processbuilder.model.PECustomAction"));

	public PECustomActionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spPEActionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPEActionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPEActionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PECustomAction.class;
	}

	@Override
	public String getModelClassName() {
		return PECustomAction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEActionId", getSpPEActionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("actionClassName", getActionClassName());
		attributes.put("title", getTitle());
		attributes.put("defaultConfiguration", getDefaultConfiguration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEActionId = (Long)attributes.get("spPEActionId");

		if (spPEActionId != null) {
			setSpPEActionId(spPEActionId);
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

		String actionClassName = (String)attributes.get("actionClassName");

		if (actionClassName != null) {
			setActionClassName(actionClassName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String defaultConfiguration = (String)attributes.get(
				"defaultConfiguration");

		if (defaultConfiguration != null) {
			setDefaultConfiguration(defaultConfiguration);
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
	public long getSpPEActionId() {
		return _spPEActionId;
	}

	@Override
	public void setSpPEActionId(long spPEActionId) {
		_spPEActionId = spPEActionId;
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
	public String getActionClassName() {
		if (_actionClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _actionClassName;
		}
	}

	@Override
	public void setActionClassName(String actionClassName) {
		_actionClassName = actionClassName;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_columnBitmask = -1L;

		_title = title;
	}

	@Override
	public String getDefaultConfiguration() {
		if (_defaultConfiguration == null) {
			return StringPool.BLANK;
		}
		else {
			return _defaultConfiguration;
		}
	}

	@Override
	public void setDefaultConfiguration(String defaultConfiguration) {
		_defaultConfiguration = defaultConfiguration;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PECustomAction.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			PECustomAction.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PECustomAction toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PECustomAction)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PECustomActionImpl peCustomActionImpl = new PECustomActionImpl();

		peCustomActionImpl.setUuid(getUuid());
		peCustomActionImpl.setSpPEActionId(getSpPEActionId());
		peCustomActionImpl.setGroupId(getGroupId());
		peCustomActionImpl.setCompanyId(getCompanyId());
		peCustomActionImpl.setUserId(getUserId());
		peCustomActionImpl.setUserName(getUserName());
		peCustomActionImpl.setCreateDate(getCreateDate());
		peCustomActionImpl.setModifiedDate(getModifiedDate());
		peCustomActionImpl.setActionClassName(getActionClassName());
		peCustomActionImpl.setTitle(getTitle());
		peCustomActionImpl.setDefaultConfiguration(getDefaultConfiguration());

		peCustomActionImpl.resetOriginalValues();

		return peCustomActionImpl;
	}

	@Override
	public int compareTo(PECustomAction peCustomAction) {
		int value = 0;

		value = getTitle().compareTo(peCustomAction.getTitle());

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

		if (!(obj instanceof PECustomAction)) {
			return false;
		}

		PECustomAction peCustomAction = (PECustomAction)obj;

		long primaryKey = peCustomAction.getPrimaryKey();

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
		PECustomActionModelImpl peCustomActionModelImpl = this;

		peCustomActionModelImpl._originalUuid = peCustomActionModelImpl._uuid;

		peCustomActionModelImpl._originalGroupId = peCustomActionModelImpl._groupId;

		peCustomActionModelImpl._setOriginalGroupId = false;

		peCustomActionModelImpl._originalCompanyId = peCustomActionModelImpl._companyId;

		peCustomActionModelImpl._setOriginalCompanyId = false;

		peCustomActionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PECustomAction> toCacheModel() {
		PECustomActionCacheModel peCustomActionCacheModel = new PECustomActionCacheModel();

		peCustomActionCacheModel.uuid = getUuid();

		String uuid = peCustomActionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			peCustomActionCacheModel.uuid = null;
		}

		peCustomActionCacheModel.spPEActionId = getSpPEActionId();

		peCustomActionCacheModel.groupId = getGroupId();

		peCustomActionCacheModel.companyId = getCompanyId();

		peCustomActionCacheModel.userId = getUserId();

		peCustomActionCacheModel.userName = getUserName();

		String userName = peCustomActionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			peCustomActionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			peCustomActionCacheModel.createDate = createDate.getTime();
		}
		else {
			peCustomActionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			peCustomActionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			peCustomActionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		peCustomActionCacheModel.actionClassName = getActionClassName();

		String actionClassName = peCustomActionCacheModel.actionClassName;

		if ((actionClassName != null) && (actionClassName.length() == 0)) {
			peCustomActionCacheModel.actionClassName = null;
		}

		peCustomActionCacheModel.title = getTitle();

		String title = peCustomActionCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			peCustomActionCacheModel.title = null;
		}

		peCustomActionCacheModel.defaultConfiguration = getDefaultConfiguration();

		String defaultConfiguration = peCustomActionCacheModel.defaultConfiguration;

		if ((defaultConfiguration != null) &&
				(defaultConfiguration.length() == 0)) {
			peCustomActionCacheModel.defaultConfiguration = null;
		}

		return peCustomActionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spPEActionId=");
		sb.append(getSpPEActionId());
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
		sb.append(", actionClassName=");
		sb.append(getActionClassName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", defaultConfiguration=");
		sb.append(getDefaultConfiguration());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.processbuilder.model.PECustomAction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEActionId</column-name><column-value><![CDATA[");
		sb.append(getSpPEActionId());
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
			"<column><column-name>actionClassName</column-name><column-value><![CDATA[");
		sb.append(getActionClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultConfiguration</column-name><column-value><![CDATA[");
		sb.append(getDefaultConfiguration());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = PECustomAction.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			PECustomAction.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _spPEActionId;
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
	private String _actionClassName;
	private String _title;
	private String _defaultConfiguration;
	private long _columnBitmask;
	private PECustomAction _escapedModel;
}