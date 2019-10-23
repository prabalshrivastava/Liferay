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

package com.sambaash.platform.srv.spsocialprofile.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAuditModel;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePullAuditPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SocialProfilePullAudit service. Represents a row in the &quot;SPSocialProfilePullAudit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAuditModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SocialProfilePullAuditImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfilePullAuditImpl
 * @see com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit
 * @see com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAuditModel
 * @generated
 */
public class SocialProfilePullAuditModelImpl extends BaseModelImpl<SocialProfilePullAudit>
	implements SocialProfilePullAuditModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a social profile pull audit model instance should use the {@link com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit} interface instead.
	 */
	public static final String TABLE_NAME = "SPSocialProfilePullAudit";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userId", Types.BIGINT },
			{ "socialNetworkProfileId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "lastQueriedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table SPSocialProfilePullAudit (userId BIGINT(20) not null,socialNetworkProfileId BIGINT(20) not null,companyId BIGINT(20),createDate DATETIME null,lastQueriedDate DATETIME null,primary key (userId, socialNetworkProfileId))";
	public static final String TABLE_SQL_DROP = "drop table SPSocialProfilePullAudit";
	public static final String ORDER_BY_JPQL = " ORDER BY socialProfilePullAudit.id.userId ASC, socialProfilePullAudit.id.socialNetworkProfileId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPSocialProfilePullAudit.userId ASC, SPSocialProfilePullAudit.socialNetworkProfileId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long SOCIALNETWORKPROFILEID_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit"));

	public SocialProfilePullAuditModelImpl() {
	}

	@Override
	public SocialProfilePullAuditPK getPrimaryKey() {
		return new SocialProfilePullAuditPK(_userId, _socialNetworkProfileId);
	}

	@Override
	public void setPrimaryKey(SocialProfilePullAuditPK primaryKey) {
		setUserId(primaryKey.userId);
		setSocialNetworkProfileId(primaryKey.socialNetworkProfileId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SocialProfilePullAuditPK(_userId, _socialNetworkProfileId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SocialProfilePullAuditPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfilePullAudit.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfilePullAudit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("socialNetworkProfileId", getSocialNetworkProfileId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("lastQueriedDate", getLastQueriedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long socialNetworkProfileId = (Long)attributes.get(
				"socialNetworkProfileId");

		if (socialNetworkProfileId != null) {
			setSocialNetworkProfileId(socialNetworkProfileId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date lastQueriedDate = (Date)attributes.get("lastQueriedDate");

		if (lastQueriedDate != null) {
			setLastQueriedDate(lastQueriedDate);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public long getSocialNetworkProfileId() {
		return _socialNetworkProfileId;
	}

	@Override
	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_columnBitmask |= SOCIALNETWORKPROFILEID_COLUMN_BITMASK;

		if (!_setOriginalSocialNetworkProfileId) {
			_setOriginalSocialNetworkProfileId = true;

			_originalSocialNetworkProfileId = _socialNetworkProfileId;
		}

		_socialNetworkProfileId = socialNetworkProfileId;
	}

	public long getOriginalSocialNetworkProfileId() {
		return _originalSocialNetworkProfileId;
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getLastQueriedDate() {
		return _lastQueriedDate;
	}

	@Override
	public void setLastQueriedDate(Date lastQueriedDate) {
		_lastQueriedDate = lastQueriedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public SocialProfilePullAudit toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SocialProfilePullAudit)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SocialProfilePullAuditImpl socialProfilePullAuditImpl = new SocialProfilePullAuditImpl();

		socialProfilePullAuditImpl.setUserId(getUserId());
		socialProfilePullAuditImpl.setSocialNetworkProfileId(getSocialNetworkProfileId());
		socialProfilePullAuditImpl.setCompanyId(getCompanyId());
		socialProfilePullAuditImpl.setCreateDate(getCreateDate());
		socialProfilePullAuditImpl.setLastQueriedDate(getLastQueriedDate());

		socialProfilePullAuditImpl.resetOriginalValues();

		return socialProfilePullAuditImpl;
	}

	@Override
	public int compareTo(SocialProfilePullAudit socialProfilePullAudit) {
		SocialProfilePullAuditPK primaryKey = socialProfilePullAudit.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialProfilePullAudit)) {
			return false;
		}

		SocialProfilePullAudit socialProfilePullAudit = (SocialProfilePullAudit)obj;

		SocialProfilePullAuditPK primaryKey = socialProfilePullAudit.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		SocialProfilePullAuditModelImpl socialProfilePullAuditModelImpl = this;

		socialProfilePullAuditModelImpl._originalUserId = socialProfilePullAuditModelImpl._userId;

		socialProfilePullAuditModelImpl._setOriginalUserId = false;

		socialProfilePullAuditModelImpl._originalSocialNetworkProfileId = socialProfilePullAuditModelImpl._socialNetworkProfileId;

		socialProfilePullAuditModelImpl._setOriginalSocialNetworkProfileId = false;

		socialProfilePullAuditModelImpl._originalCompanyId = socialProfilePullAuditModelImpl._companyId;

		socialProfilePullAuditModelImpl._setOriginalCompanyId = false;

		socialProfilePullAuditModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SocialProfilePullAudit> toCacheModel() {
		SocialProfilePullAuditCacheModel socialProfilePullAuditCacheModel = new SocialProfilePullAuditCacheModel();

		socialProfilePullAuditCacheModel.userId = getUserId();

		socialProfilePullAuditCacheModel.socialNetworkProfileId = getSocialNetworkProfileId();

		socialProfilePullAuditCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			socialProfilePullAuditCacheModel.createDate = createDate.getTime();
		}
		else {
			socialProfilePullAuditCacheModel.createDate = Long.MIN_VALUE;
		}

		Date lastQueriedDate = getLastQueriedDate();

		if (lastQueriedDate != null) {
			socialProfilePullAuditCacheModel.lastQueriedDate = lastQueriedDate.getTime();
		}
		else {
			socialProfilePullAuditCacheModel.lastQueriedDate = Long.MIN_VALUE;
		}

		return socialProfilePullAuditCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", socialNetworkProfileId=");
		sb.append(getSocialNetworkProfileId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", lastQueriedDate=");
		sb.append(getLastQueriedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialNetworkProfileId</column-name><column-value><![CDATA[");
		sb.append(getSocialNetworkProfileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastQueriedDate</column-name><column-value><![CDATA[");
		sb.append(getLastQueriedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SocialProfilePullAudit.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SocialProfilePullAudit.class
		};
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _socialNetworkProfileId;
	private long _originalSocialNetworkProfileId;
	private boolean _setOriginalSocialNetworkProfileId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _createDate;
	private Date _lastQueriedDate;
	private long _columnBitmask;
	private SocialProfilePullAudit _escapedModel;
}