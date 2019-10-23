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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.service.ClpSerializer;
import com.sambaash.platform.srv.service.FundingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class FundingClp extends BaseModelImpl<Funding> implements Funding {
	public FundingClp() {
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

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpFundingId", long.class);

				method.invoke(_fundingRemoteModel, spFundingId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_fundingRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_fundingRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_fundingRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_fundingRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_fundingRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_fundingRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCourseType() {
		return _courseType;
	}

	@Override
	public void setCourseType(long courseType) {
		_courseType = courseType;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseType", long.class);

				method.invoke(_fundingRemoteModel, courseType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFundingDesc() {
		return _fundingDesc;
	}

	@Override
	public void setFundingDesc(String fundingDesc) {
		_fundingDesc = fundingDesc;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingDesc", String.class);

				method.invoke(_fundingRemoteModel, fundingDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFundingCriteria() {
		return _fundingCriteria;
	}

	@Override
	public void setFundingCriteria(String fundingCriteria) {
		_fundingCriteria = fundingCriteria;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingCriteria",
						String.class);

				method.invoke(_fundingRemoteModel, fundingCriteria);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFundOrder() {
		return _fundOrder;
	}

	@Override
	public void setFundOrder(long fundOrder) {
		_fundOrder = fundOrder;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setFundOrder", long.class);

				method.invoke(_fundingRemoteModel, fundOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSponsoredBy() {
		return _sponsoredBy;
	}

	@Override
	public void setSponsoredBy(long sponsoredBy) {
		_sponsoredBy = sponsoredBy;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setSponsoredBy", long.class);

				method.invoke(_fundingRemoteModel, sponsoredBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResidenceStatus() {
		return _residenceStatus;
	}

	@Override
	public void setResidenceStatus(String residenceStatus) {
		_residenceStatus = residenceStatus;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setResidenceStatus",
						String.class);

				method.invoke(_fundingRemoteModel, residenceStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAgeOperator() {
		return _ageOperator;
	}

	@Override
	public void setAgeOperator(String ageOperator) {
		_ageOperator = ageOperator;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setAgeOperator", String.class);

				method.invoke(_fundingRemoteModel, ageOperator);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAge() {
		return _age;
	}

	@Override
	public void setAge(double age) {
		_age = age;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setAge", double.class);

				method.invoke(_fundingRemoteModel, age);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEarningStatus() {
		return _earningStatus;
	}

	@Override
	public void setEarningStatus(String earningStatus) {
		_earningStatus = earningStatus;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setEarningStatus", String.class);

				method.invoke(_fundingRemoteModel, earningStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSalaryOperator() {
		return _salaryOperator;
	}

	@Override
	public void setSalaryOperator(String salaryOperator) {
		_salaryOperator = salaryOperator;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setSalaryOperator",
						String.class);

				method.invoke(_fundingRemoteModel, salaryOperator);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getSalary() {
		return _salary;
	}

	@Override
	public void setSalary(double salary) {
		_salary = salary;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setSalary", double.class);

				method.invoke(_fundingRemoteModel, salary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFundingHour() {
		return _fundingHour;
	}

	@Override
	public void setFundingHour(String fundingHour) {
		_fundingHour = fundingHour;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingHour", String.class);

				method.invoke(_fundingRemoteModel, fundingHour);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFundingAmount() {
		return _fundingAmount;
	}

	@Override
	public void setFundingAmount(double fundingAmount) {
		_fundingAmount = fundingAmount;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingAmount", double.class);

				method.invoke(_fundingRemoteModel, fundingAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getNetFees() {
		return _netFees;
	}

	@Override
	public void setNetFees(double netFees) {
		_netFees = netFees;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setNetFees", double.class);

				method.invoke(_fundingRemoteModel, netFees);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAbsenteePayroll() {
		return _absenteePayroll;
	}

	@Override
	public void setAbsenteePayroll(String absenteePayroll) {
		_absenteePayroll = absenteePayroll;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setAbsenteePayroll",
						String.class);

				method.invoke(_fundingRemoteModel, absenteePayroll);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFundingCourseFee() {
		return _fundingCourseFee;
	}

	@Override
	public void setFundingCourseFee(String fundingCourseFee) {
		_fundingCourseFee = fundingCourseFee;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingCourseFee",
						String.class);

				method.invoke(_fundingRemoteModel, fundingCourseFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;

		if (_fundingRemoteModel != null) {
			try {
				Class<?> clazz = _fundingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_fundingRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFundingRemoteModel() {
		return _fundingRemoteModel;
	}

	public void setFundingRemoteModel(BaseModel<?> fundingRemoteModel) {
		_fundingRemoteModel = fundingRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _fundingRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_fundingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FundingLocalServiceUtil.addFunding(this);
		}
		else {
			FundingLocalServiceUtil.updateFunding(this);
		}
	}

	@Override
	public Funding toEscapedModel() {
		return (Funding)ProxyUtil.newProxyInstance(Funding.class.getClassLoader(),
			new Class[] { Funding.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FundingClp clone = new FundingClp();

		clone.setSpFundingId(getSpFundingId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCourseType(getCourseType());
		clone.setFundingDesc(getFundingDesc());
		clone.setFundingCriteria(getFundingCriteria());
		clone.setFundOrder(getFundOrder());
		clone.setSponsoredBy(getSponsoredBy());
		clone.setResidenceStatus(getResidenceStatus());
		clone.setAgeOperator(getAgeOperator());
		clone.setAge(getAge());
		clone.setEarningStatus(getEarningStatus());
		clone.setSalaryOperator(getSalaryOperator());
		clone.setSalary(getSalary());
		clone.setFundingHour(getFundingHour());
		clone.setFundingAmount(getFundingAmount());
		clone.setNetFees(getNetFees());
		clone.setAbsenteePayroll(getAbsenteePayroll());
		clone.setFundingCourseFee(getFundingCourseFee());
		clone.setSpCourseId(getSpCourseId());

		return clone;
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

		if (!(obj instanceof FundingClp)) {
			return false;
		}

		FundingClp funding = (FundingClp)obj;

		long primaryKey = funding.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
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

	private long _spFundingId;
	private long _groupId;
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
	private BaseModel<?> _fundingRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}