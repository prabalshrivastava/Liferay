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

import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.model.FundingModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Funding service. Represents a row in the &quot;SPFunding&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.model.FundingModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FundingImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see FundingImpl
 * @see com.sambaash.platform.srv.model.Funding
 * @see com.sambaash.platform.srv.model.FundingModel
 * @generated
 */
public class FundingModelImpl extends BaseModelImpl<Funding>
	implements FundingModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a funding model instance should use the {@link com.sambaash.platform.srv.model.Funding} interface instead.
	 */
	public static final String TABLE_NAME = "SPFunding";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spFundingId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "courseType", Types.BIGINT },
			{ "fundingDesc", Types.VARCHAR },
			{ "fundingCriteria", Types.VARCHAR },
			{ "fundOrder", Types.BIGINT },
			{ "sponsoredBy", Types.BIGINT },
			{ "residenceStatus", Types.VARCHAR },
			{ "ageOperator", Types.VARCHAR },
			{ "age", Types.DOUBLE },
			{ "earningStatus", Types.VARCHAR },
			{ "salaryOperator", Types.VARCHAR },
			{ "salary", Types.DOUBLE },
			{ "fundingHour", Types.VARCHAR },
			{ "fundingAmount", Types.DOUBLE },
			{ "netFees", Types.DOUBLE },
			{ "absenteePayroll", Types.VARCHAR },
			{ "fundingCourseFee", Types.VARCHAR },
			{ "spCourseId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table SPFunding (spFundingId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,courseType BIGINT(20),fundingDesc LONGTEXT null,fundingCriteria LONGTEXT null,fundOrder BIGINT(20),sponsoredBy BIGINT(20),residenceStatus VARCHAR(75) null,ageOperator VARCHAR(75) null,age DOUBLE,earningStatus VARCHAR(75) null,salaryOperator VARCHAR(75) null,salary DOUBLE,fundingHour VARCHAR(75) null,fundingAmount DOUBLE,netFees DOUBLE,absenteePayroll LONGTEXT null,fundingCourseFee LONGTEXT null,spCourseId BIGINT(20))";
	public static final String TABLE_SQL_DROP = "drop table SPFunding";
	public static final String ORDER_BY_JPQL = " ORDER BY funding.fundOrder ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPFunding.fundOrder ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.model.Funding"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.model.Funding"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.model.Funding"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long SPCOURSEID_COLUMN_BITMASK = 2L;
	public static long SPONSOREDBY_COLUMN_BITMASK = 4L;
	public static long FUNDORDER_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.model.Funding"));

	public FundingModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spFundingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpFundingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spFundingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Funding.class;
	}

	@Override
	public String getModelClassName() {
		return Funding.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFundingId", getSpFundingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("courseType", getCourseType());
		attributes.put("fundingDesc", getFundingDesc());
		attributes.put("fundingCriteria", getFundingCriteria());
		attributes.put("fundOrder", getFundOrder());
		attributes.put("sponsoredBy", getSponsoredBy());
		attributes.put("residenceStatus", getResidenceStatus());
		attributes.put("ageOperator", getAgeOperator());
		attributes.put("age", getAge());
		attributes.put("earningStatus", getEarningStatus());
		attributes.put("salaryOperator", getSalaryOperator());
		attributes.put("salary", getSalary());
		attributes.put("fundingHour", getFundingHour());
		attributes.put("fundingAmount", getFundingAmount());
		attributes.put("netFees", getNetFees());
		attributes.put("absenteePayroll", getAbsenteePayroll());
		attributes.put("fundingCourseFee", getFundingCourseFee());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFundingId = (Long)attributes.get("spFundingId");

		if (spFundingId != null) {
			setSpFundingId(spFundingId);
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

		Long courseType = (Long)attributes.get("courseType");

		if (courseType != null) {
			setCourseType(courseType);
		}

		String fundingDesc = (String)attributes.get("fundingDesc");

		if (fundingDesc != null) {
			setFundingDesc(fundingDesc);
		}

		String fundingCriteria = (String)attributes.get("fundingCriteria");

		if (fundingCriteria != null) {
			setFundingCriteria(fundingCriteria);
		}

		Long fundOrder = (Long)attributes.get("fundOrder");

		if (fundOrder != null) {
			setFundOrder(fundOrder);
		}

		Long sponsoredBy = (Long)attributes.get("sponsoredBy");

		if (sponsoredBy != null) {
			setSponsoredBy(sponsoredBy);
		}

		String residenceStatus = (String)attributes.get("residenceStatus");

		if (residenceStatus != null) {
			setResidenceStatus(residenceStatus);
		}

		String ageOperator = (String)attributes.get("ageOperator");

		if (ageOperator != null) {
			setAgeOperator(ageOperator);
		}

		Double age = (Double)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String earningStatus = (String)attributes.get("earningStatus");

		if (earningStatus != null) {
			setEarningStatus(earningStatus);
		}

		String salaryOperator = (String)attributes.get("salaryOperator");

		if (salaryOperator != null) {
			setSalaryOperator(salaryOperator);
		}

		Double salary = (Double)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}

		String fundingHour = (String)attributes.get("fundingHour");

		if (fundingHour != null) {
			setFundingHour(fundingHour);
		}

		Double fundingAmount = (Double)attributes.get("fundingAmount");

		if (fundingAmount != null) {
			setFundingAmount(fundingAmount);
		}

		Double netFees = (Double)attributes.get("netFees");

		if (netFees != null) {
			setNetFees(netFees);
		}

		String absenteePayroll = (String)attributes.get("absenteePayroll");

		if (absenteePayroll != null) {
			setAbsenteePayroll(absenteePayroll);
		}

		String fundingCourseFee = (String)attributes.get("fundingCourseFee");

		if (fundingCourseFee != null) {
			setFundingCourseFee(fundingCourseFee);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	@Override
	public long getSpFundingId() {
		return _spFundingId;
	}

	@Override
	public void setSpFundingId(long spFundingId) {
		_spFundingId = spFundingId;
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
	public long getCourseType() {
		return _courseType;
	}

	@Override
	public void setCourseType(long courseType) {
		_courseType = courseType;
	}

	@Override
	public String getFundingDesc() {
		if (_fundingDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _fundingDesc;
		}
	}

	@Override
	public void setFundingDesc(String fundingDesc) {
		_fundingDesc = fundingDesc;
	}

	@Override
	public String getFundingCriteria() {
		if (_fundingCriteria == null) {
			return StringPool.BLANK;
		}
		else {
			return _fundingCriteria;
		}
	}

	@Override
	public void setFundingCriteria(String fundingCriteria) {
		_fundingCriteria = fundingCriteria;
	}

	@Override
	public long getFundOrder() {
		return _fundOrder;
	}

	@Override
	public void setFundOrder(long fundOrder) {
		_columnBitmask = -1L;

		_fundOrder = fundOrder;
	}

	@Override
	public long getSponsoredBy() {
		return _sponsoredBy;
	}

	@Override
	public void setSponsoredBy(long sponsoredBy) {
		_columnBitmask |= SPONSOREDBY_COLUMN_BITMASK;

		if (!_setOriginalSponsoredBy) {
			_setOriginalSponsoredBy = true;

			_originalSponsoredBy = _sponsoredBy;
		}

		_sponsoredBy = sponsoredBy;
	}

	public long getOriginalSponsoredBy() {
		return _originalSponsoredBy;
	}

	@Override
	public String getResidenceStatus() {
		if (_residenceStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _residenceStatus;
		}
	}

	@Override
	public void setResidenceStatus(String residenceStatus) {
		_residenceStatus = residenceStatus;
	}

	@Override
	public String getAgeOperator() {
		if (_ageOperator == null) {
			return StringPool.BLANK;
		}
		else {
			return _ageOperator;
		}
	}

	@Override
	public void setAgeOperator(String ageOperator) {
		_ageOperator = ageOperator;
	}

	@Override
	public double getAge() {
		return _age;
	}

	@Override
	public void setAge(double age) {
		_age = age;
	}

	@Override
	public String getEarningStatus() {
		if (_earningStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _earningStatus;
		}
	}

	@Override
	public void setEarningStatus(String earningStatus) {
		_earningStatus = earningStatus;
	}

	@Override
	public String getSalaryOperator() {
		if (_salaryOperator == null) {
			return StringPool.BLANK;
		}
		else {
			return _salaryOperator;
		}
	}

	@Override
	public void setSalaryOperator(String salaryOperator) {
		_salaryOperator = salaryOperator;
	}

	@Override
	public double getSalary() {
		return _salary;
	}

	@Override
	public void setSalary(double salary) {
		_salary = salary;
	}

	@Override
	public String getFundingHour() {
		if (_fundingHour == null) {
			return StringPool.BLANK;
		}
		else {
			return _fundingHour;
		}
	}

	@Override
	public void setFundingHour(String fundingHour) {
		_fundingHour = fundingHour;
	}

	@Override
	public double getFundingAmount() {
		return _fundingAmount;
	}

	@Override
	public void setFundingAmount(double fundingAmount) {
		_fundingAmount = fundingAmount;
	}

	@Override
	public double getNetFees() {
		return _netFees;
	}

	@Override
	public void setNetFees(double netFees) {
		_netFees = netFees;
	}

	@Override
	public String getAbsenteePayroll() {
		if (_absenteePayroll == null) {
			return StringPool.BLANK;
		}
		else {
			return _absenteePayroll;
		}
	}

	@Override
	public void setAbsenteePayroll(String absenteePayroll) {
		_absenteePayroll = absenteePayroll;
	}

	@Override
	public String getFundingCourseFee() {
		if (_fundingCourseFee == null) {
			return StringPool.BLANK;
		}
		else {
			return _fundingCourseFee;
		}
	}

	@Override
	public void setFundingCourseFee(String fundingCourseFee) {
		_fundingCourseFee = fundingCourseFee;
	}

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_columnBitmask |= SPCOURSEID_COLUMN_BITMASK;

		if (!_setOriginalSpCourseId) {
			_setOriginalSpCourseId = true;

			_originalSpCourseId = _spCourseId;
		}

		_spCourseId = spCourseId;
	}

	public long getOriginalSpCourseId() {
		return _originalSpCourseId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Funding.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Funding toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Funding)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FundingImpl fundingImpl = new FundingImpl();

		fundingImpl.setSpFundingId(getSpFundingId());
		fundingImpl.setGroupId(getGroupId());
		fundingImpl.setCompanyId(getCompanyId());
		fundingImpl.setUserId(getUserId());
		fundingImpl.setUserName(getUserName());
		fundingImpl.setCreateDate(getCreateDate());
		fundingImpl.setModifiedDate(getModifiedDate());
		fundingImpl.setCourseType(getCourseType());
		fundingImpl.setFundingDesc(getFundingDesc());
		fundingImpl.setFundingCriteria(getFundingCriteria());
		fundingImpl.setFundOrder(getFundOrder());
		fundingImpl.setSponsoredBy(getSponsoredBy());
		fundingImpl.setResidenceStatus(getResidenceStatus());
		fundingImpl.setAgeOperator(getAgeOperator());
		fundingImpl.setAge(getAge());
		fundingImpl.setEarningStatus(getEarningStatus());
		fundingImpl.setSalaryOperator(getSalaryOperator());
		fundingImpl.setSalary(getSalary());
		fundingImpl.setFundingHour(getFundingHour());
		fundingImpl.setFundingAmount(getFundingAmount());
		fundingImpl.setNetFees(getNetFees());
		fundingImpl.setAbsenteePayroll(getAbsenteePayroll());
		fundingImpl.setFundingCourseFee(getFundingCourseFee());
		fundingImpl.setSpCourseId(getSpCourseId());

		fundingImpl.resetOriginalValues();

		return fundingImpl;
	}

	@Override
	public int compareTo(Funding funding) {
		int value = 0;

		if (getFundOrder() < funding.getFundOrder()) {
			value = -1;
		}
		else if (getFundOrder() > funding.getFundOrder()) {
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

		if (!(obj instanceof Funding)) {
			return false;
		}

		Funding funding = (Funding)obj;

		long primaryKey = funding.getPrimaryKey();

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
		FundingModelImpl fundingModelImpl = this;

		fundingModelImpl._originalGroupId = fundingModelImpl._groupId;

		fundingModelImpl._setOriginalGroupId = false;

		fundingModelImpl._originalSponsoredBy = fundingModelImpl._sponsoredBy;

		fundingModelImpl._setOriginalSponsoredBy = false;

		fundingModelImpl._originalSpCourseId = fundingModelImpl._spCourseId;

		fundingModelImpl._setOriginalSpCourseId = false;

		fundingModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Funding> toCacheModel() {
		FundingCacheModel fundingCacheModel = new FundingCacheModel();

		fundingCacheModel.spFundingId = getSpFundingId();

		fundingCacheModel.groupId = getGroupId();

		fundingCacheModel.companyId = getCompanyId();

		fundingCacheModel.userId = getUserId();

		fundingCacheModel.userName = getUserName();

		String userName = fundingCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			fundingCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			fundingCacheModel.createDate = createDate.getTime();
		}
		else {
			fundingCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			fundingCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			fundingCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		fundingCacheModel.courseType = getCourseType();

		fundingCacheModel.fundingDesc = getFundingDesc();

		String fundingDesc = fundingCacheModel.fundingDesc;

		if ((fundingDesc != null) && (fundingDesc.length() == 0)) {
			fundingCacheModel.fundingDesc = null;
		}

		fundingCacheModel.fundingCriteria = getFundingCriteria();

		String fundingCriteria = fundingCacheModel.fundingCriteria;

		if ((fundingCriteria != null) && (fundingCriteria.length() == 0)) {
			fundingCacheModel.fundingCriteria = null;
		}

		fundingCacheModel.fundOrder = getFundOrder();

		fundingCacheModel.sponsoredBy = getSponsoredBy();

		fundingCacheModel.residenceStatus = getResidenceStatus();

		String residenceStatus = fundingCacheModel.residenceStatus;

		if ((residenceStatus != null) && (residenceStatus.length() == 0)) {
			fundingCacheModel.residenceStatus = null;
		}

		fundingCacheModel.ageOperator = getAgeOperator();

		String ageOperator = fundingCacheModel.ageOperator;

		if ((ageOperator != null) && (ageOperator.length() == 0)) {
			fundingCacheModel.ageOperator = null;
		}

		fundingCacheModel.age = getAge();

		fundingCacheModel.earningStatus = getEarningStatus();

		String earningStatus = fundingCacheModel.earningStatus;

		if ((earningStatus != null) && (earningStatus.length() == 0)) {
			fundingCacheModel.earningStatus = null;
		}

		fundingCacheModel.salaryOperator = getSalaryOperator();

		String salaryOperator = fundingCacheModel.salaryOperator;

		if ((salaryOperator != null) && (salaryOperator.length() == 0)) {
			fundingCacheModel.salaryOperator = null;
		}

		fundingCacheModel.salary = getSalary();

		fundingCacheModel.fundingHour = getFundingHour();

		String fundingHour = fundingCacheModel.fundingHour;

		if ((fundingHour != null) && (fundingHour.length() == 0)) {
			fundingCacheModel.fundingHour = null;
		}

		fundingCacheModel.fundingAmount = getFundingAmount();

		fundingCacheModel.netFees = getNetFees();

		fundingCacheModel.absenteePayroll = getAbsenteePayroll();

		String absenteePayroll = fundingCacheModel.absenteePayroll;

		if ((absenteePayroll != null) && (absenteePayroll.length() == 0)) {
			fundingCacheModel.absenteePayroll = null;
		}

		fundingCacheModel.fundingCourseFee = getFundingCourseFee();

		String fundingCourseFee = fundingCacheModel.fundingCourseFee;

		if ((fundingCourseFee != null) && (fundingCourseFee.length() == 0)) {
			fundingCacheModel.fundingCourseFee = null;
		}

		fundingCacheModel.spCourseId = getSpCourseId();

		return fundingCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{spFundingId=");
		sb.append(getSpFundingId());
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
		sb.append(", courseType=");
		sb.append(getCourseType());
		sb.append(", fundingDesc=");
		sb.append(getFundingDesc());
		sb.append(", fundingCriteria=");
		sb.append(getFundingCriteria());
		sb.append(", fundOrder=");
		sb.append(getFundOrder());
		sb.append(", sponsoredBy=");
		sb.append(getSponsoredBy());
		sb.append(", residenceStatus=");
		sb.append(getResidenceStatus());
		sb.append(", ageOperator=");
		sb.append(getAgeOperator());
		sb.append(", age=");
		sb.append(getAge());
		sb.append(", earningStatus=");
		sb.append(getEarningStatus());
		sb.append(", salaryOperator=");
		sb.append(getSalaryOperator());
		sb.append(", salary=");
		sb.append(getSalary());
		sb.append(", fundingHour=");
		sb.append(getFundingHour());
		sb.append(", fundingAmount=");
		sb.append(getFundingAmount());
		sb.append(", netFees=");
		sb.append(getNetFees());
		sb.append(", absenteePayroll=");
		sb.append(getAbsenteePayroll());
		sb.append(", fundingCourseFee=");
		sb.append(getFundingCourseFee());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Funding");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spFundingId</column-name><column-value><![CDATA[");
		sb.append(getSpFundingId());
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
			"<column><column-name>courseType</column-name><column-value><![CDATA[");
		sb.append(getCourseType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingDesc</column-name><column-value><![CDATA[");
		sb.append(getFundingDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingCriteria</column-name><column-value><![CDATA[");
		sb.append(getFundingCriteria());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundOrder</column-name><column-value><![CDATA[");
		sb.append(getFundOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sponsoredBy</column-name><column-value><![CDATA[");
		sb.append(getSponsoredBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>residenceStatus</column-name><column-value><![CDATA[");
		sb.append(getResidenceStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ageOperator</column-name><column-value><![CDATA[");
		sb.append(getAgeOperator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>age</column-name><column-value><![CDATA[");
		sb.append(getAge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>earningStatus</column-name><column-value><![CDATA[");
		sb.append(getEarningStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>salaryOperator</column-name><column-value><![CDATA[");
		sb.append(getSalaryOperator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>salary</column-name><column-value><![CDATA[");
		sb.append(getSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingHour</column-name><column-value><![CDATA[");
		sb.append(getFundingHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingAmount</column-name><column-value><![CDATA[");
		sb.append(getFundingAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>netFees</column-name><column-value><![CDATA[");
		sb.append(getNetFees());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absenteePayroll</column-name><column-value><![CDATA[");
		sb.append(getAbsenteePayroll());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingCourseFee</column-name><column-value><![CDATA[");
		sb.append(getFundingCourseFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Funding.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Funding.class
		};
	private long _spFundingId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _courseType;
	private String _fundingDesc;
	private String _fundingCriteria;
	private long _fundOrder;
	private long _sponsoredBy;
	private long _originalSponsoredBy;
	private boolean _setOriginalSponsoredBy;
	private String _residenceStatus;
	private String _ageOperator;
	private double _age;
	private String _earningStatus;
	private String _salaryOperator;
	private double _salary;
	private String _fundingHour;
	private double _fundingAmount;
	private double _netFees;
	private String _absenteePayroll;
	private String _fundingCourseFee;
	private long _spCourseId;
	private long _originalSpCourseId;
	private boolean _setOriginalSpCourseId;
	private long _columnBitmask;
	private Funding _escapedModel;
}