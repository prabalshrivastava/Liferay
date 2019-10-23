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

package com.sambaash.platform.srv.spjob.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spjob.service.ClpSerializer;
import com.sambaash.platform.srv.spjob.service.SPJobLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPJobClp extends BaseModelImpl<SPJob> implements SPJob {
	public SPJobClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPJob.class;
	}

	@Override
	public String getModelClassName() {
		return SPJob.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spJobId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpJobId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spJobId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spJobId", getSpJobId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("yearsOfExperience", getYearsOfExperience());
		attributes.put("corporateName", getCorporateName());
		attributes.put("corporateId", getCorporateId());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("jobType", getJobType());
		attributes.put("jobLocation", getJobLocation());
		attributes.put("jobDescription", getJobDescription());
		attributes.put("status", getStatus());
		attributes.put("autoMatch", getAutoMatch());
		attributes.put("currency", getCurrency());
		attributes.put("salary", getSalary());
		attributes.put("rate", getRate());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("closingDate", getClosingDate());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());
		attributes.put("notefto", getNotefto());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spJobId = (Long)attributes.get("spJobId");

		if (spJobId != null) {
			setSpJobId(spJobId);
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

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long updatedBy = (Long)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		String yearsOfExperience = (String)attributes.get("yearsOfExperience");

		if (yearsOfExperience != null) {
			setYearsOfExperience(yearsOfExperience);
		}

		String corporateName = (String)attributes.get("corporateName");

		if (corporateName != null) {
			setCorporateName(corporateName);
		}

		Long corporateId = (Long)attributes.get("corporateId");

		if (corporateId != null) {
			setCorporateId(corporateId);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String jobType = (String)attributes.get("jobType");

		if (jobType != null) {
			setJobType(jobType);
		}

		String jobLocation = (String)attributes.get("jobLocation");

		if (jobLocation != null) {
			setJobLocation(jobLocation);
		}

		String jobDescription = (String)attributes.get("jobDescription");

		if (jobDescription != null) {
			setJobDescription(jobDescription);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean autoMatch = (Boolean)attributes.get("autoMatch");

		if (autoMatch != null) {
			setAutoMatch(autoMatch);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Double salary = (Double)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}

		String rate = (String)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date closingDate = (Date)attributes.get("closingDate");

		if (closingDate != null) {
			setClosingDate(closingDate);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}

		String extra3 = (String)attributes.get("extra3");

		if (extra3 != null) {
			setExtra3(extra3);
		}

		String extra4 = (String)attributes.get("extra4");

		if (extra4 != null) {
			setExtra4(extra4);
		}

		String extra5 = (String)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}

		String notefto = (String)attributes.get("notefto");

		if (notefto != null) {
			setNotefto(notefto);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spJobRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpJobId() {
		return _spJobId;
	}

	@Override
	public void setSpJobId(long spJobId) {
		_spJobId = spJobId;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setSpJobId", long.class);

				method.invoke(_spJobRemoteModel, spJobId);
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

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spJobRemoteModel, groupId);
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

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spJobRemoteModel, companyId);
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

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spJobRemoteModel, userId);
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
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_spJobRemoteModel, createdBy);
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

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spJobRemoteModel, createDate);
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

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spJobRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUpdatedBy() {
		return _updatedBy;
	}

	@Override
	public void setUpdatedBy(long updatedBy) {
		_updatedBy = updatedBy;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", long.class);

				method.invoke(_spJobRemoteModel, updatedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYearsOfExperience() {
		return _yearsOfExperience;
	}

	@Override
	public void setYearsOfExperience(String yearsOfExperience) {
		_yearsOfExperience = yearsOfExperience;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setYearsOfExperience",
						String.class);

				method.invoke(_spJobRemoteModel, yearsOfExperience);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCorporateName() {
		return _corporateName;
	}

	@Override
	public void setCorporateName(String corporateName) {
		_corporateName = corporateName;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setCorporateName", String.class);

				method.invoke(_spJobRemoteModel, corporateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCorporateId() {
		return _corporateId;
	}

	@Override
	public void setCorporateId(long corporateId) {
		_corporateId = corporateId;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setCorporateId", long.class);

				method.invoke(_spJobRemoteModel, corporateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobTitle() {
		return _jobTitle;
	}

	@Override
	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitle", String.class);

				method.invoke(_spJobRemoteModel, jobTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobType() {
		return _jobType;
	}

	@Override
	public void setJobType(String jobType) {
		_jobType = jobType;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobType", String.class);

				method.invoke(_spJobRemoteModel, jobType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobLocation() {
		return _jobLocation;
	}

	@Override
	public void setJobLocation(String jobLocation) {
		_jobLocation = jobLocation;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobLocation", String.class);

				method.invoke(_spJobRemoteModel, jobLocation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobDescription() {
		return _jobDescription;
	}

	@Override
	public void setJobDescription(String jobDescription) {
		_jobDescription = jobDescription;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobDescription",
						String.class);

				method.invoke(_spJobRemoteModel, jobDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_spJobRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAutoMatch() {
		return _autoMatch;
	}

	@Override
	public boolean isAutoMatch() {
		return _autoMatch;
	}

	@Override
	public void setAutoMatch(boolean autoMatch) {
		_autoMatch = autoMatch;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setAutoMatch", boolean.class);

				method.invoke(_spJobRemoteModel, autoMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrency() {
		return _currency;
	}

	@Override
	public void setCurrency(String currency) {
		_currency = currency;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_spJobRemoteModel, currency);
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

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setSalary", double.class);

				method.invoke(_spJobRemoteModel, salary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRate() {
		return _rate;
	}

	@Override
	public void setRate(String rate) {
		_rate = rate;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setRate", String.class);

				method.invoke(_spJobRemoteModel, rate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_spJobRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_spJobRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getClosingDate() {
		return _closingDate;
	}

	@Override
	public void setClosingDate(Date closingDate) {
		_closingDate = closingDate;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setClosingDate", Date.class);

				method.invoke(_spJobRemoteModel, closingDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra1() {
		return _extra1;
	}

	@Override
	public void setExtra1(String extra1) {
		_extra1 = extra1;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_spJobRemoteModel, extra1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra2() {
		return _extra2;
	}

	@Override
	public void setExtra2(String extra2) {
		_extra2 = extra2;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_spJobRemoteModel, extra2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra3() {
		return _extra3;
	}

	@Override
	public void setExtra3(String extra3) {
		_extra3 = extra3;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra3", String.class);

				method.invoke(_spJobRemoteModel, extra3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra4() {
		return _extra4;
	}

	@Override
	public void setExtra4(String extra4) {
		_extra4 = extra4;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra4", String.class);

				method.invoke(_spJobRemoteModel, extra4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra5() {
		return _extra5;
	}

	@Override
	public void setExtra5(String extra5) {
		_extra5 = extra5;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra5", String.class);

				method.invoke(_spJobRemoteModel, extra5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotefto() {
		return _notefto;
	}

	@Override
	public void setNotefto(String notefto) {
		_notefto = notefto;

		if (_spJobRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRemoteModel.getClass();

				Method method = clazz.getMethod("setNotefto", String.class);

				method.invoke(_spJobRemoteModel, notefto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPJob.class.getName()));
	}

	public BaseModel<?> getSPJobRemoteModel() {
		return _spJobRemoteModel;
	}

	public void setSPJobRemoteModel(BaseModel<?> spJobRemoteModel) {
		_spJobRemoteModel = spJobRemoteModel;
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

		Class<?> remoteModelClass = _spJobRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spJobRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPJobLocalServiceUtil.addSPJob(this);
		}
		else {
			SPJobLocalServiceUtil.updateSPJob(this);
		}
	}

	@Override
	public SPJob toEscapedModel() {
		return (SPJob)ProxyUtil.newProxyInstance(SPJob.class.getClassLoader(),
			new Class[] { SPJob.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPJobClp clone = new SPJobClp();

		clone.setUuid(getUuid());
		clone.setSpJobId(getSpJobId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setYearsOfExperience(getYearsOfExperience());
		clone.setCorporateName(getCorporateName());
		clone.setCorporateId(getCorporateId());
		clone.setJobTitle(getJobTitle());
		clone.setJobType(getJobType());
		clone.setJobLocation(getJobLocation());
		clone.setJobDescription(getJobDescription());
		clone.setStatus(getStatus());
		clone.setAutoMatch(getAutoMatch());
		clone.setCurrency(getCurrency());
		clone.setSalary(getSalary());
		clone.setRate(getRate());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setClosingDate(getClosingDate());
		clone.setExtra1(getExtra1());
		clone.setExtra2(getExtra2());
		clone.setExtra3(getExtra3());
		clone.setExtra4(getExtra4());
		clone.setExtra5(getExtra5());
		clone.setNotefto(getNotefto());

		return clone;
	}

	@Override
	public int compareTo(SPJob spJob) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(), spJob.getModifiedDate());

		value = value * -1;

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

		if (!(obj instanceof SPJobClp)) {
			return false;
		}

		SPJobClp spJob = (SPJobClp)obj;

		long primaryKey = spJob.getPrimaryKey();

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
		StringBundler sb = new StringBundler(61);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spJobId=");
		sb.append(getSpJobId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", yearsOfExperience=");
		sb.append(getYearsOfExperience());
		sb.append(", corporateName=");
		sb.append(getCorporateName());
		sb.append(", corporateId=");
		sb.append(getCorporateId());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append(", jobType=");
		sb.append(getJobType());
		sb.append(", jobLocation=");
		sb.append(getJobLocation());
		sb.append(", jobDescription=");
		sb.append(getJobDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", autoMatch=");
		sb.append(getAutoMatch());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", salary=");
		sb.append(getSalary());
		sb.append(", rate=");
		sb.append(getRate());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", closingDate=");
		sb.append(getClosingDate());
		sb.append(", extra1=");
		sb.append(getExtra1());
		sb.append(", extra2=");
		sb.append(getExtra2());
		sb.append(", extra3=");
		sb.append(getExtra3());
		sb.append(", extra4=");
		sb.append(getExtra4());
		sb.append(", extra5=");
		sb.append(getExtra5());
		sb.append(", notefto=");
		sb.append(getNotefto());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spjob.model.SPJob");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spJobId</column-name><column-value><![CDATA[");
		sb.append(getSpJobId());
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
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
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
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearsOfExperience</column-name><column-value><![CDATA[");
		sb.append(getYearsOfExperience());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporateName</column-name><column-value><![CDATA[");
		sb.append(getCorporateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporateId</column-name><column-value><![CDATA[");
		sb.append(getCorporateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobType</column-name><column-value><![CDATA[");
		sb.append(getJobType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobLocation</column-name><column-value><![CDATA[");
		sb.append(getJobLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobDescription</column-name><column-value><![CDATA[");
		sb.append(getJobDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autoMatch</column-name><column-value><![CDATA[");
		sb.append(getAutoMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>salary</column-name><column-value><![CDATA[");
		sb.append(getSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rate</column-name><column-value><![CDATA[");
		sb.append(getRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closingDate</column-name><column-value><![CDATA[");
		sb.append(getClosingDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra1</column-name><column-value><![CDATA[");
		sb.append(getExtra1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra2</column-name><column-value><![CDATA[");
		sb.append(getExtra2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra3</column-name><column-value><![CDATA[");
		sb.append(getExtra3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra4</column-name><column-value><![CDATA[");
		sb.append(getExtra4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra5</column-name><column-value><![CDATA[");
		sb.append(getExtra5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notefto</column-name><column-value><![CDATA[");
		sb.append(getNotefto());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spJobId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _createdBy;
	private Date _createDate;
	private Date _modifiedDate;
	private long _updatedBy;
	private String _yearsOfExperience;
	private String _corporateName;
	private long _corporateId;
	private String _jobTitle;
	private String _jobType;
	private String _jobLocation;
	private String _jobDescription;
	private String _status;
	private boolean _autoMatch;
	private String _currency;
	private double _salary;
	private String _rate;
	private Date _startDate;
	private Date _endDate;
	private Date _closingDate;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private String _extra5;
	private String _notefto;
	private BaseModel<?> _spJobRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spjob.service.ClpSerializer.class;
}