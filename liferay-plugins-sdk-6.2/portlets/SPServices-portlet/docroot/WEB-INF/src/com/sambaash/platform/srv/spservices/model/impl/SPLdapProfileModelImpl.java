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

package com.sambaash.platform.srv.spservices.model.impl;

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

import com.sambaash.platform.srv.spservices.model.SPLdapProfile;
import com.sambaash.platform.srv.spservices.model.SPLdapProfileModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SPLdapProfile service. Represents a row in the &quot;SPLdapProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.spservices.model.SPLdapProfileModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SPLdapProfileImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLdapProfileImpl
 * @see com.sambaash.platform.srv.spservices.model.SPLdapProfile
 * @see com.sambaash.platform.srv.spservices.model.SPLdapProfileModel
 * @generated
 */
public class SPLdapProfileModelImpl extends BaseModelImpl<SPLdapProfile>
	implements SPLdapProfileModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s p ldap profile model instance should use the {@link com.sambaash.platform.srv.spservices.model.SPLdapProfile} interface instead.
	 */
	public static final String TABLE_NAME = "SPLdapProfile";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spLdapProfileId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "countryId", Types.BIGINT },
			{ "departmentId", Types.BIGINT },
			{ "givenName", Types.VARCHAR },
			{ "sn", Types.VARCHAR },
			{ "displayName", Types.VARCHAR },
			{ "company", Types.VARCHAR },
			{ "division", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "mail", Types.VARCHAR },
			{ "samAccountName", Types.VARCHAR },
			{ "employeeId", Types.VARCHAR },
			{ "manager", Types.VARCHAR },
			{ "telephoneNumber", Types.VARCHAR },
			{ "mobile", Types.VARCHAR },
			{ "facsimileTelephoneNumber", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SPLdapProfile (spLdapProfileId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),createDate DATETIME null,modifiedDate DATETIME null,userId BIGINT(20),countryId BIGINT(20),departmentId BIGINT(20),givenName VARCHAR(75) null,sn VARCHAR(75) null,displayName VARCHAR(75) null,company VARCHAR(75) null,division VARCHAR(75) null,title VARCHAR(75) null,mail VARCHAR(75) null,samAccountName VARCHAR(75) null,employeeId VARCHAR(75) null,manager VARCHAR(75) null,telephoneNumber VARCHAR(75) null,mobile VARCHAR(75) null,facsimileTelephoneNumber VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SPLdapProfile";
	public static final String ORDER_BY_JPQL = " ORDER BY spLdapProfile.spLdapProfileId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPLdapProfile.spLdapProfileId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.spservices.model.SPLdapProfile"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.spservices.model.SPLdapProfile"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.spservices.model.SPLdapProfile"),
			true);
	public static long USERID_COLUMN_BITMASK = 1L;
	public static long SPLDAPPROFILEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.spservices.model.SPLdapProfile"));

	public SPLdapProfileModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spLdapProfileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpLdapProfileId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spLdapProfileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SPLdapProfile.class;
	}

	@Override
	public String getModelClassName() {
		return SPLdapProfile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spLdapProfileId", getSpLdapProfileId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("countryId", getCountryId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("givenName", getGivenName());
		attributes.put("sn", getSn());
		attributes.put("displayName", getDisplayName());
		attributes.put("company", getCompany());
		attributes.put("division", getDivision());
		attributes.put("title", getTitle());
		attributes.put("mail", getMail());
		attributes.put("samAccountName", getSamAccountName());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("manager", getManager());
		attributes.put("telephoneNumber", getTelephoneNumber());
		attributes.put("mobile", getMobile());
		attributes.put("facsimileTelephoneNumber", getFacsimileTelephoneNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spLdapProfileId = (Long)attributes.get("spLdapProfileId");

		if (spLdapProfileId != null) {
			setSpLdapProfileId(spLdapProfileId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String givenName = (String)attributes.get("givenName");

		if (givenName != null) {
			setGivenName(givenName);
		}

		String sn = (String)attributes.get("sn");

		if (sn != null) {
			setSn(sn);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}

		String samAccountName = (String)attributes.get("samAccountName");

		if (samAccountName != null) {
			setSamAccountName(samAccountName);
		}

		String employeeId = (String)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String manager = (String)attributes.get("manager");

		if (manager != null) {
			setManager(manager);
		}

		String telephoneNumber = (String)attributes.get("telephoneNumber");

		if (telephoneNumber != null) {
			setTelephoneNumber(telephoneNumber);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String facsimileTelephoneNumber = (String)attributes.get(
				"facsimileTelephoneNumber");

		if (facsimileTelephoneNumber != null) {
			setFacsimileTelephoneNumber(facsimileTelephoneNumber);
		}
	}

	@Override
	public long getSpLdapProfileId() {
		return _spLdapProfileId;
	}

	@Override
	public void setSpLdapProfileId(long spLdapProfileId) {
		_columnBitmask = -1L;

		_spLdapProfileId = spLdapProfileId;
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
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	@Override
	public String getGivenName() {
		if (_givenName == null) {
			return StringPool.BLANK;
		}
		else {
			return _givenName;
		}
	}

	@Override
	public void setGivenName(String givenName) {
		_givenName = givenName;
	}

	@Override
	public String getSn() {
		if (_sn == null) {
			return StringPool.BLANK;
		}
		else {
			return _sn;
		}
	}

	@Override
	public void setSn(String sn) {
		_sn = sn;
	}

	@Override
	public String getDisplayName() {
		if (_displayName == null) {
			return StringPool.BLANK;
		}
		else {
			return _displayName;
		}
	}

	@Override
	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	@Override
	public String getCompany() {
		if (_company == null) {
			return StringPool.BLANK;
		}
		else {
			return _company;
		}
	}

	@Override
	public void setCompany(String company) {
		_company = company;
	}

	@Override
	public String getDivision() {
		if (_division == null) {
			return StringPool.BLANK;
		}
		else {
			return _division;
		}
	}

	@Override
	public void setDivision(String division) {
		_division = division;
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
		_title = title;
	}

	@Override
	public String getMail() {
		if (_mail == null) {
			return StringPool.BLANK;
		}
		else {
			return _mail;
		}
	}

	@Override
	public void setMail(String mail) {
		_mail = mail;
	}

	@Override
	public String getSamAccountName() {
		if (_samAccountName == null) {
			return StringPool.BLANK;
		}
		else {
			return _samAccountName;
		}
	}

	@Override
	public void setSamAccountName(String samAccountName) {
		_samAccountName = samAccountName;
	}

	@Override
	public String getEmployeeId() {
		if (_employeeId == null) {
			return StringPool.BLANK;
		}
		else {
			return _employeeId;
		}
	}

	@Override
	public void setEmployeeId(String employeeId) {
		_employeeId = employeeId;
	}

	@Override
	public String getManager() {
		if (_manager == null) {
			return StringPool.BLANK;
		}
		else {
			return _manager;
		}
	}

	@Override
	public void setManager(String manager) {
		_manager = manager;
	}

	@Override
	public String getTelephoneNumber() {
		if (_telephoneNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _telephoneNumber;
		}
	}

	@Override
	public void setTelephoneNumber(String telephoneNumber) {
		_telephoneNumber = telephoneNumber;
	}

	@Override
	public String getMobile() {
		if (_mobile == null) {
			return StringPool.BLANK;
		}
		else {
			return _mobile;
		}
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	@Override
	public String getFacsimileTelephoneNumber() {
		if (_facsimileTelephoneNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _facsimileTelephoneNumber;
		}
	}

	@Override
	public void setFacsimileTelephoneNumber(String facsimileTelephoneNumber) {
		_facsimileTelephoneNumber = facsimileTelephoneNumber;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SPLdapProfile.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SPLdapProfile toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SPLdapProfile)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SPLdapProfileImpl spLdapProfileImpl = new SPLdapProfileImpl();

		spLdapProfileImpl.setSpLdapProfileId(getSpLdapProfileId());
		spLdapProfileImpl.setGroupId(getGroupId());
		spLdapProfileImpl.setCompanyId(getCompanyId());
		spLdapProfileImpl.setCreateDate(getCreateDate());
		spLdapProfileImpl.setModifiedDate(getModifiedDate());
		spLdapProfileImpl.setUserId(getUserId());
		spLdapProfileImpl.setCountryId(getCountryId());
		spLdapProfileImpl.setDepartmentId(getDepartmentId());
		spLdapProfileImpl.setGivenName(getGivenName());
		spLdapProfileImpl.setSn(getSn());
		spLdapProfileImpl.setDisplayName(getDisplayName());
		spLdapProfileImpl.setCompany(getCompany());
		spLdapProfileImpl.setDivision(getDivision());
		spLdapProfileImpl.setTitle(getTitle());
		spLdapProfileImpl.setMail(getMail());
		spLdapProfileImpl.setSamAccountName(getSamAccountName());
		spLdapProfileImpl.setEmployeeId(getEmployeeId());
		spLdapProfileImpl.setManager(getManager());
		spLdapProfileImpl.setTelephoneNumber(getTelephoneNumber());
		spLdapProfileImpl.setMobile(getMobile());
		spLdapProfileImpl.setFacsimileTelephoneNumber(getFacsimileTelephoneNumber());

		spLdapProfileImpl.resetOriginalValues();

		return spLdapProfileImpl;
	}

	@Override
	public int compareTo(SPLdapProfile spLdapProfile) {
		int value = 0;

		if (getSpLdapProfileId() < spLdapProfile.getSpLdapProfileId()) {
			value = -1;
		}
		else if (getSpLdapProfileId() > spLdapProfile.getSpLdapProfileId()) {
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

		if (!(obj instanceof SPLdapProfile)) {
			return false;
		}

		SPLdapProfile spLdapProfile = (SPLdapProfile)obj;

		long primaryKey = spLdapProfile.getPrimaryKey();

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
		SPLdapProfileModelImpl spLdapProfileModelImpl = this;

		spLdapProfileModelImpl._originalUserId = spLdapProfileModelImpl._userId;

		spLdapProfileModelImpl._setOriginalUserId = false;

		spLdapProfileModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SPLdapProfile> toCacheModel() {
		SPLdapProfileCacheModel spLdapProfileCacheModel = new SPLdapProfileCacheModel();

		spLdapProfileCacheModel.spLdapProfileId = getSpLdapProfileId();

		spLdapProfileCacheModel.groupId = getGroupId();

		spLdapProfileCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			spLdapProfileCacheModel.createDate = createDate.getTime();
		}
		else {
			spLdapProfileCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			spLdapProfileCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			spLdapProfileCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		spLdapProfileCacheModel.userId = getUserId();

		spLdapProfileCacheModel.countryId = getCountryId();

		spLdapProfileCacheModel.departmentId = getDepartmentId();

		spLdapProfileCacheModel.givenName = getGivenName();

		String givenName = spLdapProfileCacheModel.givenName;

		if ((givenName != null) && (givenName.length() == 0)) {
			spLdapProfileCacheModel.givenName = null;
		}

		spLdapProfileCacheModel.sn = getSn();

		String sn = spLdapProfileCacheModel.sn;

		if ((sn != null) && (sn.length() == 0)) {
			spLdapProfileCacheModel.sn = null;
		}

		spLdapProfileCacheModel.displayName = getDisplayName();

		String displayName = spLdapProfileCacheModel.displayName;

		if ((displayName != null) && (displayName.length() == 0)) {
			spLdapProfileCacheModel.displayName = null;
		}

		spLdapProfileCacheModel.company = getCompany();

		String company = spLdapProfileCacheModel.company;

		if ((company != null) && (company.length() == 0)) {
			spLdapProfileCacheModel.company = null;
		}

		spLdapProfileCacheModel.division = getDivision();

		String division = spLdapProfileCacheModel.division;

		if ((division != null) && (division.length() == 0)) {
			spLdapProfileCacheModel.division = null;
		}

		spLdapProfileCacheModel.title = getTitle();

		String title = spLdapProfileCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			spLdapProfileCacheModel.title = null;
		}

		spLdapProfileCacheModel.mail = getMail();

		String mail = spLdapProfileCacheModel.mail;

		if ((mail != null) && (mail.length() == 0)) {
			spLdapProfileCacheModel.mail = null;
		}

		spLdapProfileCacheModel.samAccountName = getSamAccountName();

		String samAccountName = spLdapProfileCacheModel.samAccountName;

		if ((samAccountName != null) && (samAccountName.length() == 0)) {
			spLdapProfileCacheModel.samAccountName = null;
		}

		spLdapProfileCacheModel.employeeId = getEmployeeId();

		String employeeId = spLdapProfileCacheModel.employeeId;

		if ((employeeId != null) && (employeeId.length() == 0)) {
			spLdapProfileCacheModel.employeeId = null;
		}

		spLdapProfileCacheModel.manager = getManager();

		String manager = spLdapProfileCacheModel.manager;

		if ((manager != null) && (manager.length() == 0)) {
			spLdapProfileCacheModel.manager = null;
		}

		spLdapProfileCacheModel.telephoneNumber = getTelephoneNumber();

		String telephoneNumber = spLdapProfileCacheModel.telephoneNumber;

		if ((telephoneNumber != null) && (telephoneNumber.length() == 0)) {
			spLdapProfileCacheModel.telephoneNumber = null;
		}

		spLdapProfileCacheModel.mobile = getMobile();

		String mobile = spLdapProfileCacheModel.mobile;

		if ((mobile != null) && (mobile.length() == 0)) {
			spLdapProfileCacheModel.mobile = null;
		}

		spLdapProfileCacheModel.facsimileTelephoneNumber = getFacsimileTelephoneNumber();

		String facsimileTelephoneNumber = spLdapProfileCacheModel.facsimileTelephoneNumber;

		if ((facsimileTelephoneNumber != null) &&
				(facsimileTelephoneNumber.length() == 0)) {
			spLdapProfileCacheModel.facsimileTelephoneNumber = null;
		}

		return spLdapProfileCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{spLdapProfileId=");
		sb.append(getSpLdapProfileId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", givenName=");
		sb.append(getGivenName());
		sb.append(", sn=");
		sb.append(getSn());
		sb.append(", displayName=");
		sb.append(getDisplayName());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", division=");
		sb.append(getDivision());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", mail=");
		sb.append(getMail());
		sb.append(", samAccountName=");
		sb.append(getSamAccountName());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", manager=");
		sb.append(getManager());
		sb.append(", telephoneNumber=");
		sb.append(getTelephoneNumber());
		sb.append(", mobile=");
		sb.append(getMobile());
		sb.append(", facsimileTelephoneNumber=");
		sb.append(getFacsimileTelephoneNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPLdapProfile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spLdapProfileId</column-name><column-value><![CDATA[");
		sb.append(getSpLdapProfileId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>givenName</column-name><column-value><![CDATA[");
		sb.append(getGivenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sn</column-name><column-value><![CDATA[");
		sb.append(getSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayName</column-name><column-value><![CDATA[");
		sb.append(getDisplayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>division</column-name><column-value><![CDATA[");
		sb.append(getDivision());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mail</column-name><column-value><![CDATA[");
		sb.append(getMail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>samAccountName</column-name><column-value><![CDATA[");
		sb.append(getSamAccountName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manager</column-name><column-value><![CDATA[");
		sb.append(getManager());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telephoneNumber</column-name><column-value><![CDATA[");
		sb.append(getTelephoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(getMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facsimileTelephoneNumber</column-name><column-value><![CDATA[");
		sb.append(getFacsimileTelephoneNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SPLdapProfile.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SPLdapProfile.class
		};
	private long _spLdapProfileId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _countryId;
	private long _departmentId;
	private String _givenName;
	private String _sn;
	private String _displayName;
	private String _company;
	private String _division;
	private String _title;
	private String _mail;
	private String _samAccountName;
	private String _employeeId;
	private String _manager;
	private String _telephoneNumber;
	private String _mobile;
	private String _facsimileTelephoneNumber;
	private long _columnBitmask;
	private SPLdapProfile _escapedModel;
}