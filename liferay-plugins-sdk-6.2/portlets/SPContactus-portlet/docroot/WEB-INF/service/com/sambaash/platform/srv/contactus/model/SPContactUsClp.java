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

package com.sambaash.platform.srv.contactus.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.contactus.service.ClpSerializer;
import com.sambaash.platform.srv.contactus.service.SPContactUsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPContactUsClp extends BaseModelImpl<SPContactUs>
	implements SPContactUs {
	public SPContactUsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPContactUs.class;
	}

	@Override
	public String getModelClassName() {
		return SPContactUs.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spContactUsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpContactUsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spContactUsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spContactUsId", getSpContactUsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("category", getCategory());
		attributes.put("comment", getComment());
		attributes.put("countryName", getCountryName());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("company", getCompany());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("companyUrl", getCompanyUrl());
		attributes.put("noOfEmployee", getNoOfEmployee());
		attributes.put("rate", getRate());
		attributes.put("typeOfEnquiry", getTypeOfEnquiry());
		attributes.put("location", getLocation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spContactUsId = (Long)attributes.get("spContactUsId");

		if (spContactUsId != null) {
			setSpContactUsId(spContactUsId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		Long contactNumber = (Long)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String companyUrl = (String)attributes.get("companyUrl");

		if (companyUrl != null) {
			setCompanyUrl(companyUrl);
		}

		Long noOfEmployee = (Long)attributes.get("noOfEmployee");

		if (noOfEmployee != null) {
			setNoOfEmployee(noOfEmployee);
		}

		String rate = (String)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}

		String typeOfEnquiry = (String)attributes.get("typeOfEnquiry");

		if (typeOfEnquiry != null) {
			setTypeOfEnquiry(typeOfEnquiry);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}
	}

	@Override
	public long getSpContactUsId() {
		return _spContactUsId;
	}

	@Override
	public void setSpContactUsId(long spContactUsId) {
		_spContactUsId = spContactUsId;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setSpContactUsId", long.class);

				method.invoke(_spContactUsRemoteModel, spContactUsId);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spContactUsRemoteModel, groupId);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spContactUsRemoteModel, companyId);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spContactUsRemoteModel, userId);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spContactUsRemoteModel, userName);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spContactUsRemoteModel, createDate);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spContactUsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_spContactUsRemoteModel, name);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_spContactUsRemoteModel, lastName);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_spContactUsRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_spContactUsRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComment() {
		return _comment;
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_spContactUsRemoteModel, comment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryName() {
		return _countryName;
	}

	@Override
	public void setCountryName(String countryName) {
		_countryName = countryName;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryName", String.class);

				method.invoke(_spContactUsRemoteModel, countryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactNumber() {
		return _contactNumber;
	}

	@Override
	public void setContactNumber(long contactNumber) {
		_contactNumber = contactNumber;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setContactNumber", long.class);

				method.invoke(_spContactUsRemoteModel, contactNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompany() {
		return _company;
	}

	@Override
	public void setCompany(String company) {
		_company = company;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_spContactUsRemoteModel, company);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitle", String.class);

				method.invoke(_spContactUsRemoteModel, jobTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyUrl() {
		return _companyUrl;
	}

	@Override
	public void setCompanyUrl(String companyUrl) {
		_companyUrl = companyUrl;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyUrl", String.class);

				method.invoke(_spContactUsRemoteModel, companyUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNoOfEmployee() {
		return _noOfEmployee;
	}

	@Override
	public void setNoOfEmployee(long noOfEmployee) {
		_noOfEmployee = noOfEmployee;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setNoOfEmployee", long.class);

				method.invoke(_spContactUsRemoteModel, noOfEmployee);
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

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setRate", String.class);

				method.invoke(_spContactUsRemoteModel, rate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTypeOfEnquiry() {
		return _typeOfEnquiry;
	}

	@Override
	public void setTypeOfEnquiry(String typeOfEnquiry) {
		_typeOfEnquiry = typeOfEnquiry;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeOfEnquiry", String.class);

				method.invoke(_spContactUsRemoteModel, typeOfEnquiry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_spContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_spContactUsRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPContactUsRemoteModel() {
		return _spContactUsRemoteModel;
	}

	public void setSPContactUsRemoteModel(BaseModel<?> spContactUsRemoteModel) {
		_spContactUsRemoteModel = spContactUsRemoteModel;
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

		Class<?> remoteModelClass = _spContactUsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spContactUsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPContactUsLocalServiceUtil.addSPContactUs(this);
		}
		else {
			SPContactUsLocalServiceUtil.updateSPContactUs(this);
		}
	}

	@Override
	public SPContactUs toEscapedModel() {
		return (SPContactUs)ProxyUtil.newProxyInstance(SPContactUs.class.getClassLoader(),
			new Class[] { SPContactUs.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPContactUsClp clone = new SPContactUsClp();

		clone.setSpContactUsId(getSpContactUsId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setLastName(getLastName());
		clone.setEmailAddress(getEmailAddress());
		clone.setCategory(getCategory());
		clone.setComment(getComment());
		clone.setCountryName(getCountryName());
		clone.setContactNumber(getContactNumber());
		clone.setCompany(getCompany());
		clone.setJobTitle(getJobTitle());
		clone.setCompanyUrl(getCompanyUrl());
		clone.setNoOfEmployee(getNoOfEmployee());
		clone.setRate(getRate());
		clone.setTypeOfEnquiry(getTypeOfEnquiry());
		clone.setLocation(getLocation());

		return clone;
	}

	@Override
	public int compareTo(SPContactUs spContactUs) {
		long primaryKey = spContactUs.getPrimaryKey();

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

		if (!(obj instanceof SPContactUsClp)) {
			return false;
		}

		SPContactUsClp spContactUs = (SPContactUsClp)obj;

		long primaryKey = spContactUs.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{spContactUsId=");
		sb.append(getSpContactUsId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", countryName=");
		sb.append(getCountryName());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append(", companyUrl=");
		sb.append(getCompanyUrl());
		sb.append(", noOfEmployee=");
		sb.append(getNoOfEmployee());
		sb.append(", rate=");
		sb.append(getRate());
		sb.append(", typeOfEnquiry=");
		sb.append(getTypeOfEnquiry());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.contactus.model.SPContactUs");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spContactUsId</column-name><column-value><![CDATA[");
		sb.append(getSpContactUsId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
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
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryName</column-name><column-value><![CDATA[");
		sb.append(getCountryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNumber</column-name><column-value><![CDATA[");
		sb.append(getContactNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyUrl</column-name><column-value><![CDATA[");
		sb.append(getCompanyUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noOfEmployee</column-name><column-value><![CDATA[");
		sb.append(getNoOfEmployee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rate</column-name><column-value><![CDATA[");
		sb.append(getRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeOfEnquiry</column-name><column-value><![CDATA[");
		sb.append(getTypeOfEnquiry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spContactUsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _lastName;
	private String _emailAddress;
	private String _category;
	private String _comment;
	private String _countryName;
	private long _contactNumber;
	private String _company;
	private String _jobTitle;
	private String _companyUrl;
	private long _noOfEmployee;
	private String _rate;
	private String _typeOfEnquiry;
	private String _location;
	private BaseModel<?> _spContactUsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.contactus.service.ClpSerializer.class;
}