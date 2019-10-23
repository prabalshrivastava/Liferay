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

import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusTypeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PEProcessStatusType service. Represents a row in the &quot;SPPEProcessStatusType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.processbuilder.model.PEProcessStatusTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PEProcessStatusTypeImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStatusTypeImpl
 * @see com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType
 * @see com.sambaash.platform.srv.processbuilder.model.PEProcessStatusTypeModel
 * @generated
 */
public class PEProcessStatusTypeModelImpl extends BaseModelImpl<PEProcessStatusType>
	implements PEProcessStatusTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a p e process status type model instance should use the {@link com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType} interface instead.
	 */
	public static final String TABLE_NAME = "SPPEProcessStatusType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "spPEProcessStatusTypeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "spPEProcessId", Types.BIGINT },
			{ "statusName", Types.VARCHAR },
			{ "seqNo", Types.BIGINT },
			{ "approveTemplateId", Types.BIGINT },
			{ "rejectTemplateId", Types.BIGINT },
			{ "spPEProcessStageId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPPEProcessStatusType (uuid_ VARCHAR(75) null,spPEProcessStatusTypeId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,spPEProcessId BIGINT(20),statusName VARCHAR(75) null,seqNo BIGINT(20),approveTemplateId BIGINT(20),rejectTemplateId BIGINT(20),spPEProcessStageId BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPPEProcessStatusType";
	public static final String ORDER_BY_JPQL = " ORDER BY peProcessStatusType.seqNo ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPPEProcessStatusType.seqNo ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long SPPEPROCESSID_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;
	public static long SEQNO_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType"));

	public PEProcessStatusTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spPEProcessStatusTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPEProcessStatusTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPEProcessStatusTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PEProcessStatusType.class;
	}

	@Override
	public String getModelClassName() {
		return PEProcessStatusType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEProcessStatusTypeId", getSpPEProcessStatusTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessId", getSpPEProcessId());
		attributes.put("statusName", getStatusName());
		attributes.put("seqNo", getSeqNo());
		attributes.put("approveTemplateId", getApproveTemplateId());
		attributes.put("rejectTemplateId", getRejectTemplateId());
		attributes.put("spPEProcessStageId", getSpPEProcessStageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEProcessStatusTypeId = (Long)attributes.get(
				"spPEProcessStatusTypeId");

		if (spPEProcessStatusTypeId != null) {
			setSpPEProcessStatusTypeId(spPEProcessStatusTypeId);
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

		Long spPEProcessId = (Long)attributes.get("spPEProcessId");

		if (spPEProcessId != null) {
			setSpPEProcessId(spPEProcessId);
		}

		String statusName = (String)attributes.get("statusName");

		if (statusName != null) {
			setStatusName(statusName);
		}

		Long seqNo = (Long)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Long approveTemplateId = (Long)attributes.get("approveTemplateId");

		if (approveTemplateId != null) {
			setApproveTemplateId(approveTemplateId);
		}

		Long rejectTemplateId = (Long)attributes.get("rejectTemplateId");

		if (rejectTemplateId != null) {
			setRejectTemplateId(rejectTemplateId);
		}

		Long spPEProcessStageId = (Long)attributes.get("spPEProcessStageId");

		if (spPEProcessStageId != null) {
			setSpPEProcessStageId(spPEProcessStageId);
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
	public long getSpPEProcessStatusTypeId() {
		return _spPEProcessStatusTypeId;
	}

	@Override
	public void setSpPEProcessStatusTypeId(long spPEProcessStatusTypeId) {
		_spPEProcessStatusTypeId = spPEProcessStatusTypeId;
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
	public long getSpPEProcessId() {
		return _spPEProcessId;
	}

	@Override
	public void setSpPEProcessId(long spPEProcessId) {
		_columnBitmask |= SPPEPROCESSID_COLUMN_BITMASK;

		if (!_setOriginalSpPEProcessId) {
			_setOriginalSpPEProcessId = true;

			_originalSpPEProcessId = _spPEProcessId;
		}

		_spPEProcessId = spPEProcessId;
	}

	public long getOriginalSpPEProcessId() {
		return _originalSpPEProcessId;
	}

	@Override
	public String getStatusName() {
		if (_statusName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusName;
		}
	}

	@Override
	public void setStatusName(String statusName) {
		_statusName = statusName;
	}

	@Override
	public long getSeqNo() {
		return _seqNo;
	}

	@Override
	public void setSeqNo(long seqNo) {
		_columnBitmask = -1L;

		_seqNo = seqNo;
	}

	@Override
	public long getApproveTemplateId() {
		return _approveTemplateId;
	}

	@Override
	public void setApproveTemplateId(long approveTemplateId) {
		_approveTemplateId = approveTemplateId;
	}

	@Override
	public long getRejectTemplateId() {
		return _rejectTemplateId;
	}

	@Override
	public void setRejectTemplateId(long rejectTemplateId) {
		_rejectTemplateId = rejectTemplateId;
	}

	@Override
	public long getSpPEProcessStageId() {
		return _spPEProcessStageId;
	}

	@Override
	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_spPEProcessStageId = spPEProcessStageId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PEProcessStatusType.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			PEProcessStatusType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PEProcessStatusType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PEProcessStatusType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PEProcessStatusTypeImpl peProcessStatusTypeImpl = new PEProcessStatusTypeImpl();

		peProcessStatusTypeImpl.setUuid(getUuid());
		peProcessStatusTypeImpl.setSpPEProcessStatusTypeId(getSpPEProcessStatusTypeId());
		peProcessStatusTypeImpl.setGroupId(getGroupId());
		peProcessStatusTypeImpl.setCompanyId(getCompanyId());
		peProcessStatusTypeImpl.setUserId(getUserId());
		peProcessStatusTypeImpl.setUserName(getUserName());
		peProcessStatusTypeImpl.setCreateDate(getCreateDate());
		peProcessStatusTypeImpl.setModifiedDate(getModifiedDate());
		peProcessStatusTypeImpl.setSpPEProcessId(getSpPEProcessId());
		peProcessStatusTypeImpl.setStatusName(getStatusName());
		peProcessStatusTypeImpl.setSeqNo(getSeqNo());
		peProcessStatusTypeImpl.setApproveTemplateId(getApproveTemplateId());
		peProcessStatusTypeImpl.setRejectTemplateId(getRejectTemplateId());
		peProcessStatusTypeImpl.setSpPEProcessStageId(getSpPEProcessStageId());

		peProcessStatusTypeImpl.resetOriginalValues();

		return peProcessStatusTypeImpl;
	}

	@Override
	public int compareTo(PEProcessStatusType peProcessStatusType) {
		int value = 0;

		if (getSeqNo() < peProcessStatusType.getSeqNo()) {
			value = -1;
		}
		else if (getSeqNo() > peProcessStatusType.getSeqNo()) {
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

		if (!(obj instanceof PEProcessStatusType)) {
			return false;
		}

		PEProcessStatusType peProcessStatusType = (PEProcessStatusType)obj;

		long primaryKey = peProcessStatusType.getPrimaryKey();

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
		PEProcessStatusTypeModelImpl peProcessStatusTypeModelImpl = this;

		peProcessStatusTypeModelImpl._originalUuid = peProcessStatusTypeModelImpl._uuid;

		peProcessStatusTypeModelImpl._originalGroupId = peProcessStatusTypeModelImpl._groupId;

		peProcessStatusTypeModelImpl._setOriginalGroupId = false;

		peProcessStatusTypeModelImpl._originalCompanyId = peProcessStatusTypeModelImpl._companyId;

		peProcessStatusTypeModelImpl._setOriginalCompanyId = false;

		peProcessStatusTypeModelImpl._originalSpPEProcessId = peProcessStatusTypeModelImpl._spPEProcessId;

		peProcessStatusTypeModelImpl._setOriginalSpPEProcessId = false;

		peProcessStatusTypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PEProcessStatusType> toCacheModel() {
		PEProcessStatusTypeCacheModel peProcessStatusTypeCacheModel = new PEProcessStatusTypeCacheModel();

		peProcessStatusTypeCacheModel.uuid = getUuid();

		String uuid = peProcessStatusTypeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			peProcessStatusTypeCacheModel.uuid = null;
		}

		peProcessStatusTypeCacheModel.spPEProcessStatusTypeId = getSpPEProcessStatusTypeId();

		peProcessStatusTypeCacheModel.groupId = getGroupId();

		peProcessStatusTypeCacheModel.companyId = getCompanyId();

		peProcessStatusTypeCacheModel.userId = getUserId();

		peProcessStatusTypeCacheModel.userName = getUserName();

		String userName = peProcessStatusTypeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			peProcessStatusTypeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			peProcessStatusTypeCacheModel.createDate = createDate.getTime();
		}
		else {
			peProcessStatusTypeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			peProcessStatusTypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			peProcessStatusTypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		peProcessStatusTypeCacheModel.spPEProcessId = getSpPEProcessId();

		peProcessStatusTypeCacheModel.statusName = getStatusName();

		String statusName = peProcessStatusTypeCacheModel.statusName;

		if ((statusName != null) && (statusName.length() == 0)) {
			peProcessStatusTypeCacheModel.statusName = null;
		}

		peProcessStatusTypeCacheModel.seqNo = getSeqNo();

		peProcessStatusTypeCacheModel.approveTemplateId = getApproveTemplateId();

		peProcessStatusTypeCacheModel.rejectTemplateId = getRejectTemplateId();

		peProcessStatusTypeCacheModel.spPEProcessStageId = getSpPEProcessStageId();

		return peProcessStatusTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spPEProcessStatusTypeId=");
		sb.append(getSpPEProcessStatusTypeId());
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
		sb.append(", spPEProcessId=");
		sb.append(getSpPEProcessId());
		sb.append(", statusName=");
		sb.append(getStatusName());
		sb.append(", seqNo=");
		sb.append(getSeqNo());
		sb.append(", approveTemplateId=");
		sb.append(getApproveTemplateId());
		sb.append(", rejectTemplateId=");
		sb.append(getRejectTemplateId());
		sb.append(", spPEProcessStageId=");
		sb.append(getSpPEProcessStageId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessStatusTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStatusTypeId());
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
			"<column><column-name>spPEProcessId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusName</column-name><column-value><![CDATA[");
		sb.append(getStatusName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seqNo</column-name><column-value><![CDATA[");
		sb.append(getSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approveTemplateId</column-name><column-value><![CDATA[");
		sb.append(getApproveTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rejectTemplateId</column-name><column-value><![CDATA[");
		sb.append(getRejectTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessStageId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = PEProcessStatusType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			PEProcessStatusType.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _spPEProcessStatusTypeId;
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
	private long _spPEProcessId;
	private long _originalSpPEProcessId;
	private boolean _setOriginalSpPEProcessId;
	private String _statusName;
	private long _seqNo;
	private long _approveTemplateId;
	private long _rejectTemplateId;
	private long _spPEProcessStageId;
	private long _columnBitmask;
	private PEProcessStatusType _escapedModel;
}