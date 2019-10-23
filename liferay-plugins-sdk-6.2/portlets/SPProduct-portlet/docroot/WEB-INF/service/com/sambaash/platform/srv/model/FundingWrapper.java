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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Funding}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Funding
 * @generated
 */
public class FundingWrapper implements Funding, ModelWrapper<Funding> {
	public FundingWrapper(Funding funding) {
		_funding = funding;
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

	/**
	* Returns the primary key of this funding.
	*
	* @return the primary key of this funding
	*/
	@Override
	public long getPrimaryKey() {
		return _funding.getPrimaryKey();
	}

	/**
	* Sets the primary key of this funding.
	*
	* @param primaryKey the primary key of this funding
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_funding.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp funding ID of this funding.
	*
	* @return the sp funding ID of this funding
	*/
	@Override
	public long getSpFundingId() {
		return _funding.getSpFundingId();
	}

	/**
	* Sets the sp funding ID of this funding.
	*
	* @param spFundingId the sp funding ID of this funding
	*/
	@Override
	public void setSpFundingId(long spFundingId) {
		_funding.setSpFundingId(spFundingId);
	}

	/**
	* Returns the group ID of this funding.
	*
	* @return the group ID of this funding
	*/
	@Override
	public long getGroupId() {
		return _funding.getGroupId();
	}

	/**
	* Sets the group ID of this funding.
	*
	* @param groupId the group ID of this funding
	*/
	@Override
	public void setGroupId(long groupId) {
		_funding.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this funding.
	*
	* @return the company ID of this funding
	*/
	@Override
	public long getCompanyId() {
		return _funding.getCompanyId();
	}

	/**
	* Sets the company ID of this funding.
	*
	* @param companyId the company ID of this funding
	*/
	@Override
	public void setCompanyId(long companyId) {
		_funding.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this funding.
	*
	* @return the user ID of this funding
	*/
	@Override
	public long getUserId() {
		return _funding.getUserId();
	}

	/**
	* Sets the user ID of this funding.
	*
	* @param userId the user ID of this funding
	*/
	@Override
	public void setUserId(long userId) {
		_funding.setUserId(userId);
	}

	/**
	* Returns the user uuid of this funding.
	*
	* @return the user uuid of this funding
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding.getUserUuid();
	}

	/**
	* Sets the user uuid of this funding.
	*
	* @param userUuid the user uuid of this funding
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_funding.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this funding.
	*
	* @return the user name of this funding
	*/
	@Override
	public java.lang.String getUserName() {
		return _funding.getUserName();
	}

	/**
	* Sets the user name of this funding.
	*
	* @param userName the user name of this funding
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_funding.setUserName(userName);
	}

	/**
	* Returns the create date of this funding.
	*
	* @return the create date of this funding
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _funding.getCreateDate();
	}

	/**
	* Sets the create date of this funding.
	*
	* @param createDate the create date of this funding
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_funding.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this funding.
	*
	* @return the modified date of this funding
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _funding.getModifiedDate();
	}

	/**
	* Sets the modified date of this funding.
	*
	* @param modifiedDate the modified date of this funding
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_funding.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the course type of this funding.
	*
	* @return the course type of this funding
	*/
	@Override
	public long getCourseType() {
		return _funding.getCourseType();
	}

	/**
	* Sets the course type of this funding.
	*
	* @param courseType the course type of this funding
	*/
	@Override
	public void setCourseType(long courseType) {
		_funding.setCourseType(courseType);
	}

	/**
	* Returns the funding desc of this funding.
	*
	* @return the funding desc of this funding
	*/
	@Override
	public java.lang.String getFundingDesc() {
		return _funding.getFundingDesc();
	}

	/**
	* Sets the funding desc of this funding.
	*
	* @param fundingDesc the funding desc of this funding
	*/
	@Override
	public void setFundingDesc(java.lang.String fundingDesc) {
		_funding.setFundingDesc(fundingDesc);
	}

	/**
	* Returns the funding criteria of this funding.
	*
	* @return the funding criteria of this funding
	*/
	@Override
	public java.lang.String getFundingCriteria() {
		return _funding.getFundingCriteria();
	}

	/**
	* Sets the funding criteria of this funding.
	*
	* @param fundingCriteria the funding criteria of this funding
	*/
	@Override
	public void setFundingCriteria(java.lang.String fundingCriteria) {
		_funding.setFundingCriteria(fundingCriteria);
	}

	/**
	* Returns the fund order of this funding.
	*
	* @return the fund order of this funding
	*/
	@Override
	public long getFundOrder() {
		return _funding.getFundOrder();
	}

	/**
	* Sets the fund order of this funding.
	*
	* @param fundOrder the fund order of this funding
	*/
	@Override
	public void setFundOrder(long fundOrder) {
		_funding.setFundOrder(fundOrder);
	}

	/**
	* Returns the sponsored by of this funding.
	*
	* @return the sponsored by of this funding
	*/
	@Override
	public long getSponsoredBy() {
		return _funding.getSponsoredBy();
	}

	/**
	* Sets the sponsored by of this funding.
	*
	* @param sponsoredBy the sponsored by of this funding
	*/
	@Override
	public void setSponsoredBy(long sponsoredBy) {
		_funding.setSponsoredBy(sponsoredBy);
	}

	/**
	* Returns the residence status of this funding.
	*
	* @return the residence status of this funding
	*/
	@Override
	public java.lang.String getResidenceStatus() {
		return _funding.getResidenceStatus();
	}

	/**
	* Sets the residence status of this funding.
	*
	* @param residenceStatus the residence status of this funding
	*/
	@Override
	public void setResidenceStatus(java.lang.String residenceStatus) {
		_funding.setResidenceStatus(residenceStatus);
	}

	/**
	* Returns the age operator of this funding.
	*
	* @return the age operator of this funding
	*/
	@Override
	public java.lang.String getAgeOperator() {
		return _funding.getAgeOperator();
	}

	/**
	* Sets the age operator of this funding.
	*
	* @param ageOperator the age operator of this funding
	*/
	@Override
	public void setAgeOperator(java.lang.String ageOperator) {
		_funding.setAgeOperator(ageOperator);
	}

	/**
	* Returns the age of this funding.
	*
	* @return the age of this funding
	*/
	@Override
	public double getAge() {
		return _funding.getAge();
	}

	/**
	* Sets the age of this funding.
	*
	* @param age the age of this funding
	*/
	@Override
	public void setAge(double age) {
		_funding.setAge(age);
	}

	/**
	* Returns the earning status of this funding.
	*
	* @return the earning status of this funding
	*/
	@Override
	public java.lang.String getEarningStatus() {
		return _funding.getEarningStatus();
	}

	/**
	* Sets the earning status of this funding.
	*
	* @param earningStatus the earning status of this funding
	*/
	@Override
	public void setEarningStatus(java.lang.String earningStatus) {
		_funding.setEarningStatus(earningStatus);
	}

	/**
	* Returns the salary operator of this funding.
	*
	* @return the salary operator of this funding
	*/
	@Override
	public java.lang.String getSalaryOperator() {
		return _funding.getSalaryOperator();
	}

	/**
	* Sets the salary operator of this funding.
	*
	* @param salaryOperator the salary operator of this funding
	*/
	@Override
	public void setSalaryOperator(java.lang.String salaryOperator) {
		_funding.setSalaryOperator(salaryOperator);
	}

	/**
	* Returns the salary of this funding.
	*
	* @return the salary of this funding
	*/
	@Override
	public double getSalary() {
		return _funding.getSalary();
	}

	/**
	* Sets the salary of this funding.
	*
	* @param salary the salary of this funding
	*/
	@Override
	public void setSalary(double salary) {
		_funding.setSalary(salary);
	}

	/**
	* Returns the funding hour of this funding.
	*
	* @return the funding hour of this funding
	*/
	@Override
	public java.lang.String getFundingHour() {
		return _funding.getFundingHour();
	}

	/**
	* Sets the funding hour of this funding.
	*
	* @param fundingHour the funding hour of this funding
	*/
	@Override
	public void setFundingHour(java.lang.String fundingHour) {
		_funding.setFundingHour(fundingHour);
	}

	/**
	* Returns the funding amount of this funding.
	*
	* @return the funding amount of this funding
	*/
	@Override
	public double getFundingAmount() {
		return _funding.getFundingAmount();
	}

	/**
	* Sets the funding amount of this funding.
	*
	* @param fundingAmount the funding amount of this funding
	*/
	@Override
	public void setFundingAmount(double fundingAmount) {
		_funding.setFundingAmount(fundingAmount);
	}

	/**
	* Returns the net fees of this funding.
	*
	* @return the net fees of this funding
	*/
	@Override
	public double getNetFees() {
		return _funding.getNetFees();
	}

	/**
	* Sets the net fees of this funding.
	*
	* @param netFees the net fees of this funding
	*/
	@Override
	public void setNetFees(double netFees) {
		_funding.setNetFees(netFees);
	}

	/**
	* Returns the absentee payroll of this funding.
	*
	* @return the absentee payroll of this funding
	*/
	@Override
	public java.lang.String getAbsenteePayroll() {
		return _funding.getAbsenteePayroll();
	}

	/**
	* Sets the absentee payroll of this funding.
	*
	* @param absenteePayroll the absentee payroll of this funding
	*/
	@Override
	public void setAbsenteePayroll(java.lang.String absenteePayroll) {
		_funding.setAbsenteePayroll(absenteePayroll);
	}

	/**
	* Returns the funding course fee of this funding.
	*
	* @return the funding course fee of this funding
	*/
	@Override
	public java.lang.String getFundingCourseFee() {
		return _funding.getFundingCourseFee();
	}

	/**
	* Sets the funding course fee of this funding.
	*
	* @param fundingCourseFee the funding course fee of this funding
	*/
	@Override
	public void setFundingCourseFee(java.lang.String fundingCourseFee) {
		_funding.setFundingCourseFee(fundingCourseFee);
	}

	/**
	* Returns the sp course ID of this funding.
	*
	* @return the sp course ID of this funding
	*/
	@Override
	public long getSpCourseId() {
		return _funding.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this funding.
	*
	* @param spCourseId the sp course ID of this funding
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_funding.setSpCourseId(spCourseId);
	}

	@Override
	public boolean isNew() {
		return _funding.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_funding.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _funding.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_funding.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _funding.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _funding.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_funding.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _funding.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_funding.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_funding.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_funding.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FundingWrapper((Funding)_funding.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Funding funding) {
		return _funding.compareTo(funding);
	}

	@Override
	public int hashCode() {
		return _funding.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Funding> toCacheModel() {
		return _funding.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Funding toEscapedModel() {
		return new FundingWrapper(_funding.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Funding toUnescapedModel() {
		return new FundingWrapper(_funding.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _funding.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _funding.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_funding.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundingWrapper)) {
			return false;
		}

		FundingWrapper fundingWrapper = (FundingWrapper)obj;

		if (Validator.equals(_funding, fundingWrapper._funding)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Funding getWrappedFunding() {
		return _funding;
	}

	@Override
	public Funding getWrappedModel() {
		return _funding;
	}

	@Override
	public void resetOriginalValues() {
		_funding.resetOriginalValues();
	}

	private Funding _funding;
}