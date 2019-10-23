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

import com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks;
import com.sambaash.platform.srv.startupprofile.model.OrganisationRemarksModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the OrganisationRemarks service. Represents a row in the &quot;SPOrganisationRemarks&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.startupprofile.model.OrganisationRemarksModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrganisationRemarksImpl}.
 * </p>
 *
 * @author pradeep
 * @see OrganisationRemarksImpl
 * @see com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks
 * @see com.sambaash.platform.srv.startupprofile.model.OrganisationRemarksModel
 * @generated
 */
public class OrganisationRemarksModelImpl extends BaseModelImpl<OrganisationRemarks>
	implements OrganisationRemarksModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a organisation remarks model instance should use the {@link com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks} interface instead.
	 */
	public static final String TABLE_NAME = "SPOrganisationRemarks";
	public static final Object[][] TABLE_COLUMNS = {
			{ "remarksId", Types.BIGINT },
			{ "organizationId", Types.BIGINT },
			{ "remarkType", Types.VARCHAR },
			{ "Remarks", Types.VARCHAR },
			{ "Notes", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table SPOrganisationRemarks (remarksId BIGINT(20) not null primary key,organizationId BIGINT(20),remarkType VARCHAR(75) null,Remarks LONGTEXT null,Notes LONGTEXT null,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null)";
	public static final String TABLE_SQL_DROP = "drop table SPOrganisationRemarks";
	public static final String ORDER_BY_JPQL = " ORDER BY organisationRemarks.remarksId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPOrganisationRemarks.remarksId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks"),
			true);
	public static long ORGANIZATIONID_COLUMN_BITMASK = 1L;
	public static long REMARKSID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks"));

	public OrganisationRemarksModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _remarksId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRemarksId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _remarksId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OrganisationRemarks.class;
	}

	@Override
	public String getModelClassName() {
		return OrganisationRemarks.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("remarksId", getRemarksId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("remarkType", getRemarkType());
		attributes.put("Remarks", getRemarks());
		attributes.put("Notes", getNotes());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long remarksId = (Long)attributes.get("remarksId");

		if (remarksId != null) {
			setRemarksId(remarksId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String remarkType = (String)attributes.get("remarkType");

		if (remarkType != null) {
			setRemarkType(remarkType);
		}

		String Remarks = (String)attributes.get("Remarks");

		if (Remarks != null) {
			setRemarks(Remarks);
		}

		String Notes = (String)attributes.get("Notes");

		if (Notes != null) {
			setNotes(Notes);
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
	}

	@Override
	public long getRemarksId() {
		return _remarksId;
	}

	@Override
	public void setRemarksId(long remarksId) {
		_remarksId = remarksId;
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
	public String getRemarkType() {
		if (_remarkType == null) {
			return StringPool.BLANK;
		}
		else {
			return _remarkType;
		}
	}

	@Override
	public void setRemarkType(String remarkType) {
		_remarkType = remarkType;
	}

	@Override
	public String getRemarks() {
		if (_Remarks == null) {
			return StringPool.BLANK;
		}
		else {
			return _Remarks;
		}
	}

	@Override
	public void setRemarks(String Remarks) {
		_Remarks = Remarks;
	}

	@Override
	public String getNotes() {
		if (_Notes == null) {
			return StringPool.BLANK;
		}
		else {
			return _Notes;
		}
	}

	@Override
	public void setNotes(String Notes) {
		_Notes = Notes;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			OrganisationRemarks.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OrganisationRemarks toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OrganisationRemarks)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OrganisationRemarksImpl organisationRemarksImpl = new OrganisationRemarksImpl();

		organisationRemarksImpl.setRemarksId(getRemarksId());
		organisationRemarksImpl.setOrganizationId(getOrganizationId());
		organisationRemarksImpl.setRemarkType(getRemarkType());
		organisationRemarksImpl.setRemarks(getRemarks());
		organisationRemarksImpl.setNotes(getNotes());
		organisationRemarksImpl.setGroupId(getGroupId());
		organisationRemarksImpl.setCompanyId(getCompanyId());
		organisationRemarksImpl.setUserId(getUserId());
		organisationRemarksImpl.setUserName(getUserName());
		organisationRemarksImpl.setCreateDate(getCreateDate());
		organisationRemarksImpl.setModifiedDate(getModifiedDate());

		organisationRemarksImpl.resetOriginalValues();

		return organisationRemarksImpl;
	}

	@Override
	public int compareTo(OrganisationRemarks organisationRemarks) {
		long primaryKey = organisationRemarks.getPrimaryKey();

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

		if (!(obj instanceof OrganisationRemarks)) {
			return false;
		}

		OrganisationRemarks organisationRemarks = (OrganisationRemarks)obj;

		long primaryKey = organisationRemarks.getPrimaryKey();

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
		OrganisationRemarksModelImpl organisationRemarksModelImpl = this;

		organisationRemarksModelImpl._originalOrganizationId = organisationRemarksModelImpl._organizationId;

		organisationRemarksModelImpl._setOriginalOrganizationId = false;

		organisationRemarksModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OrganisationRemarks> toCacheModel() {
		OrganisationRemarksCacheModel organisationRemarksCacheModel = new OrganisationRemarksCacheModel();

		organisationRemarksCacheModel.remarksId = getRemarksId();

		organisationRemarksCacheModel.organizationId = getOrganizationId();

		organisationRemarksCacheModel.remarkType = getRemarkType();

		String remarkType = organisationRemarksCacheModel.remarkType;

		if ((remarkType != null) && (remarkType.length() == 0)) {
			organisationRemarksCacheModel.remarkType = null;
		}

		organisationRemarksCacheModel.Remarks = getRemarks();

		String Remarks = organisationRemarksCacheModel.Remarks;

		if ((Remarks != null) && (Remarks.length() == 0)) {
			organisationRemarksCacheModel.Remarks = null;
		}

		organisationRemarksCacheModel.Notes = getNotes();

		String Notes = organisationRemarksCacheModel.Notes;

		if ((Notes != null) && (Notes.length() == 0)) {
			organisationRemarksCacheModel.Notes = null;
		}

		organisationRemarksCacheModel.groupId = getGroupId();

		organisationRemarksCacheModel.companyId = getCompanyId();

		organisationRemarksCacheModel.userId = getUserId();

		organisationRemarksCacheModel.userName = getUserName();

		String userName = organisationRemarksCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			organisationRemarksCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			organisationRemarksCacheModel.createDate = createDate.getTime();
		}
		else {
			organisationRemarksCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			organisationRemarksCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			organisationRemarksCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return organisationRemarksCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{remarksId=");
		sb.append(getRemarksId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", remarkType=");
		sb.append(getRemarkType());
		sb.append(", Remarks=");
		sb.append(getRemarks());
		sb.append(", Notes=");
		sb.append(getNotes());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>remarksId</column-name><column-value><![CDATA[");
		sb.append(getRemarksId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remarkType</column-name><column-value><![CDATA[");
		sb.append(getRemarkType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Remarks</column-name><column-value><![CDATA[");
		sb.append(getRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OrganisationRemarks.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			OrganisationRemarks.class
		};
	private long _remarksId;
	private long _organizationId;
	private long _originalOrganizationId;
	private boolean _setOriginalOrganizationId;
	private String _remarkType;
	private String _Remarks;
	private String _Notes;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private OrganisationRemarks _escapedModel;
}