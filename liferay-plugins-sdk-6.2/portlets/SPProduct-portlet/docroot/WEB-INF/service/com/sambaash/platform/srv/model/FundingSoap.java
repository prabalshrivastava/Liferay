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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class FundingSoap implements Serializable {
	public static FundingSoap toSoapModel(Funding model) {
		FundingSoap soapModel = new FundingSoap();

		soapModel.setSpFundingId(model.getSpFundingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCourseType(model.getCourseType());
		soapModel.setFundingDesc(model.getFundingDesc());
		soapModel.setFundingCriteria(model.getFundingCriteria());
		soapModel.setFundOrder(model.getFundOrder());
		soapModel.setSponsoredBy(model.getSponsoredBy());
		soapModel.setResidenceStatus(model.getResidenceStatus());
		soapModel.setAgeOperator(model.getAgeOperator());
		soapModel.setAge(model.getAge());
		soapModel.setEarningStatus(model.getEarningStatus());
		soapModel.setSalaryOperator(model.getSalaryOperator());
		soapModel.setSalary(model.getSalary());
		soapModel.setFundingHour(model.getFundingHour());
		soapModel.setFundingAmount(model.getFundingAmount());
		soapModel.setNetFees(model.getNetFees());
		soapModel.setAbsenteePayroll(model.getAbsenteePayroll());
		soapModel.setFundingCourseFee(model.getFundingCourseFee());
		soapModel.setSpCourseId(model.getSpCourseId());

		return soapModel;
	}

	public static FundingSoap[] toSoapModels(Funding[] models) {
		FundingSoap[] soapModels = new FundingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FundingSoap[][] toSoapModels(Funding[][] models) {
		FundingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FundingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FundingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FundingSoap[] toSoapModels(List<Funding> models) {
		List<FundingSoap> soapModels = new ArrayList<FundingSoap>(models.size());

		for (Funding model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FundingSoap[soapModels.size()]);
	}

	public FundingSoap() {
	}

	public long getPrimaryKey() {
		return _spFundingId;
	}

	public void setPrimaryKey(long pk) {
		setSpFundingId(pk);
	}

	public long getSpFundingId() {
		return _spFundingId;
	}

	public void setSpFundingId(long spFundingId) {
		_spFundingId = spFundingId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCourseType() {
		return _courseType;
	}

	public void setCourseType(long courseType) {
		_courseType = courseType;
	}

	public String getFundingDesc() {
		return _fundingDesc;
	}

	public void setFundingDesc(String fundingDesc) {
		_fundingDesc = fundingDesc;
	}

	public String getFundingCriteria() {
		return _fundingCriteria;
	}

	public void setFundingCriteria(String fundingCriteria) {
		_fundingCriteria = fundingCriteria;
	}

	public long getFundOrder() {
		return _fundOrder;
	}

	public void setFundOrder(long fundOrder) {
		_fundOrder = fundOrder;
	}

	public long getSponsoredBy() {
		return _sponsoredBy;
	}

	public void setSponsoredBy(long sponsoredBy) {
		_sponsoredBy = sponsoredBy;
	}

	public String getResidenceStatus() {
		return _residenceStatus;
	}

	public void setResidenceStatus(String residenceStatus) {
		_residenceStatus = residenceStatus;
	}

	public String getAgeOperator() {
		return _ageOperator;
	}

	public void setAgeOperator(String ageOperator) {
		_ageOperator = ageOperator;
	}

	public double getAge() {
		return _age;
	}

	public void setAge(double age) {
		_age = age;
	}

	public String getEarningStatus() {
		return _earningStatus;
	}

	public void setEarningStatus(String earningStatus) {
		_earningStatus = earningStatus;
	}

	public String getSalaryOperator() {
		return _salaryOperator;
	}

	public void setSalaryOperator(String salaryOperator) {
		_salaryOperator = salaryOperator;
	}

	public double getSalary() {
		return _salary;
	}

	public void setSalary(double salary) {
		_salary = salary;
	}

	public String getFundingHour() {
		return _fundingHour;
	}

	public void setFundingHour(String fundingHour) {
		_fundingHour = fundingHour;
	}

	public double getFundingAmount() {
		return _fundingAmount;
	}

	public void setFundingAmount(double fundingAmount) {
		_fundingAmount = fundingAmount;
	}

	public double getNetFees() {
		return _netFees;
	}

	public void setNetFees(double netFees) {
		_netFees = netFees;
	}

	public String getAbsenteePayroll() {
		return _absenteePayroll;
	}

	public void setAbsenteePayroll(String absenteePayroll) {
		_absenteePayroll = absenteePayroll;
	}

	public String getFundingCourseFee() {
		return _fundingCourseFee;
	}

	public void setFundingCourseFee(String fundingCourseFee) {
		_fundingCourseFee = fundingCourseFee;
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	private long _spFundingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _courseType;
	private String _fundingDesc;
	private String _fundingCriteria;
	private long _fundOrder;
	private long _sponsoredBy;
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
}