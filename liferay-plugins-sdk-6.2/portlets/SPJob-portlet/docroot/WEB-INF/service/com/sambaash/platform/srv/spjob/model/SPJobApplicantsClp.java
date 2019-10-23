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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spjob.service.ClpSerializer;
import com.sambaash.platform.srv.spjob.service.SPJobApplicantsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPJobApplicantsClp extends BaseModelImpl<SPJobApplicants>
	implements SPJobApplicants {
	public SPJobApplicantsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPJobApplicants.class;
	}

	@Override
	public String getModelClassName() {
		return SPJobApplicants.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spJobApplicantsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpJobApplicantsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spJobApplicantsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spJobApplicantsId", getSpJobApplicantsId());
		attributes.put("jobId", getJobId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("yearsOfExperience", getYearsOfExperience());
		attributes.put("resume", getResume());
		attributes.put("coverLetter", getCoverLetter());
		attributes.put("briefInfos", getBriefInfos());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spJobApplicantsId = (Long)attributes.get("spJobApplicantsId");

		if (spJobApplicantsId != null) {
			setSpJobApplicantsId(spJobApplicantsId);
		}

		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
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

		Long updatedBy = (Long)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String yearsOfExperience = (String)attributes.get("yearsOfExperience");

		if (yearsOfExperience != null) {
			setYearsOfExperience(yearsOfExperience);
		}

		String resume = (String)attributes.get("resume");

		if (resume != null) {
			setResume(resume);
		}

		String coverLetter = (String)attributes.get("coverLetter");

		if (coverLetter != null) {
			setCoverLetter(coverLetter);
		}

		String briefInfos = (String)attributes.get("briefInfos");

		if (briefInfos != null) {
			setBriefInfos(briefInfos);
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
	}

	@Override
	public long getSpJobApplicantsId() {
		return _spJobApplicantsId;
	}

	@Override
	public void setSpJobApplicantsId(long spJobApplicantsId) {
		_spJobApplicantsId = spJobApplicantsId;

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setSpJobApplicantsId",
						long.class);

				method.invoke(_spJobApplicantsRemoteModel, spJobApplicantsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobId() {
		return _jobId;
	}

	@Override
	public void setJobId(long jobId) {
		_jobId = jobId;

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setJobId", long.class);

				method.invoke(_spJobApplicantsRemoteModel, jobId);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spJobApplicantsRemoteModel, groupId);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spJobApplicantsRemoteModel, companyId);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spJobApplicantsRemoteModel, userId);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_spJobApplicantsRemoteModel, createdBy);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", long.class);

				method.invoke(_spJobApplicantsRemoteModel, updatedBy);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spJobApplicantsRemoteModel, createDate);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spJobApplicantsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_spJobApplicantsRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_spJobApplicantsRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_spJobApplicantsRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactNumber() {
		return _contactNumber;
	}

	@Override
	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setContactNumber", String.class);

				method.invoke(_spJobApplicantsRemoteModel, contactNumber);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setYearsOfExperience",
						String.class);

				method.invoke(_spJobApplicantsRemoteModel, yearsOfExperience);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResume() {
		return _resume;
	}

	@Override
	public void setResume(String resume) {
		_resume = resume;

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setResume", String.class);

				method.invoke(_spJobApplicantsRemoteModel, resume);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCoverLetter() {
		return _coverLetter;
	}

	@Override
	public void setCoverLetter(String coverLetter) {
		_coverLetter = coverLetter;

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setCoverLetter", String.class);

				method.invoke(_spJobApplicantsRemoteModel, coverLetter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBriefInfos() {
		return _briefInfos;
	}

	@Override
	public void setBriefInfos(String briefInfos) {
		_briefInfos = briefInfos;

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setBriefInfos", String.class);

				method.invoke(_spJobApplicantsRemoteModel, briefInfos);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_spJobApplicantsRemoteModel, extra1);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_spJobApplicantsRemoteModel, extra2);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra3", String.class);

				method.invoke(_spJobApplicantsRemoteModel, extra3);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra4", String.class);

				method.invoke(_spJobApplicantsRemoteModel, extra4);
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

		if (_spJobApplicantsRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra5", String.class);

				method.invoke(_spJobApplicantsRemoteModel, extra5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPJobApplicantsRemoteModel() {
		return _spJobApplicantsRemoteModel;
	}

	public void setSPJobApplicantsRemoteModel(
		BaseModel<?> spJobApplicantsRemoteModel) {
		_spJobApplicantsRemoteModel = spJobApplicantsRemoteModel;
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

		Class<?> remoteModelClass = _spJobApplicantsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spJobApplicantsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPJobApplicantsLocalServiceUtil.addSPJobApplicants(this);
		}
		else {
			SPJobApplicantsLocalServiceUtil.updateSPJobApplicants(this);
		}
	}

	@Override
	public SPJobApplicants toEscapedModel() {
		return (SPJobApplicants)ProxyUtil.newProxyInstance(SPJobApplicants.class.getClassLoader(),
			new Class[] { SPJobApplicants.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPJobApplicantsClp clone = new SPJobApplicantsClp();

		clone.setSpJobApplicantsId(getSpJobApplicantsId());
		clone.setJobId(getJobId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedBy(getCreatedBy());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setEmailAddress(getEmailAddress());
		clone.setContactNumber(getContactNumber());
		clone.setYearsOfExperience(getYearsOfExperience());
		clone.setResume(getResume());
		clone.setCoverLetter(getCoverLetter());
		clone.setBriefInfos(getBriefInfos());
		clone.setExtra1(getExtra1());
		clone.setExtra2(getExtra2());
		clone.setExtra3(getExtra3());
		clone.setExtra4(getExtra4());
		clone.setExtra5(getExtra5());

		return clone;
	}

	@Override
	public int compareTo(SPJobApplicants spJobApplicants) {
		long primaryKey = spJobApplicants.getPrimaryKey();

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

		if (!(obj instanceof SPJobApplicantsClp)) {
			return false;
		}

		SPJobApplicantsClp spJobApplicants = (SPJobApplicantsClp)obj;

		long primaryKey = spJobApplicants.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{spJobApplicantsId=");
		sb.append(getSpJobApplicantsId());
		sb.append(", jobId=");
		sb.append(getJobId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", yearsOfExperience=");
		sb.append(getYearsOfExperience());
		sb.append(", resume=");
		sb.append(getResume());
		sb.append(", coverLetter=");
		sb.append(getCoverLetter());
		sb.append(", briefInfos=");
		sb.append(getBriefInfos());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spjob.model.SPJobApplicants");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spJobApplicantsId</column-name><column-value><![CDATA[");
		sb.append(getSpJobApplicantsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobId</column-name><column-value><![CDATA[");
		sb.append(getJobId());
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
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
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
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNumber</column-name><column-value><![CDATA[");
		sb.append(getContactNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearsOfExperience</column-name><column-value><![CDATA[");
		sb.append(getYearsOfExperience());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resume</column-name><column-value><![CDATA[");
		sb.append(getResume());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coverLetter</column-name><column-value><![CDATA[");
		sb.append(getCoverLetter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>briefInfos</column-name><column-value><![CDATA[");
		sb.append(getBriefInfos());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _spJobApplicantsId;
	private long _jobId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _createdBy;
	private long _updatedBy;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _emailAddress;
	private String _contactNumber;
	private String _yearsOfExperience;
	private String _resume;
	private String _coverLetter;
	private String _briefInfos;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private String _extra5;
	private BaseModel<?> _spJobApplicantsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spjob.service.ClpSerializer.class;
}