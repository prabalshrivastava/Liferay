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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.SPLdapProfileLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPLdapProfileClp extends BaseModelImpl<SPLdapProfile>
	implements SPLdapProfile {
	public SPLdapProfileClp() {
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
		_spLdapProfileId = spLdapProfileId;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSpLdapProfileId", long.class);

				method.invoke(_spLdapProfileRemoteModel, spLdapProfileId);
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

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spLdapProfileRemoteModel, groupId);
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

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spLdapProfileRemoteModel, companyId);
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

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spLdapProfileRemoteModel, createDate);
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

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spLdapProfileRemoteModel, modifiedDate);
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

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spLdapProfileRemoteModel, userId);
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
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_spLdapProfileRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentId", long.class);

				method.invoke(_spLdapProfileRemoteModel, departmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGivenName() {
		return _givenName;
	}

	@Override
	public void setGivenName(String givenName) {
		_givenName = givenName;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGivenName", String.class);

				method.invoke(_spLdapProfileRemoteModel, givenName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSn() {
		return _sn;
	}

	@Override
	public void setSn(String sn) {
		_sn = sn;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSn", String.class);

				method.invoke(_spLdapProfileRemoteModel, sn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplayName() {
		return _displayName;
	}

	@Override
	public void setDisplayName(String displayName) {
		_displayName = displayName;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayName", String.class);

				method.invoke(_spLdapProfileRemoteModel, displayName);
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

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_spLdapProfileRemoteModel, company);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDivision() {
		return _division;
	}

	@Override
	public void setDivision(String division) {
		_division = division;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setDivision", String.class);

				method.invoke(_spLdapProfileRemoteModel, division);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_spLdapProfileRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMail() {
		return _mail;
	}

	@Override
	public void setMail(String mail) {
		_mail = mail;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setMail", String.class);

				method.invoke(_spLdapProfileRemoteModel, mail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSamAccountName() {
		return _samAccountName;
	}

	@Override
	public void setSamAccountName(String samAccountName) {
		_samAccountName = samAccountName;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSamAccountName",
						String.class);

				method.invoke(_spLdapProfileRemoteModel, samAccountName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(String employeeId) {
		_employeeId = employeeId;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", String.class);

				method.invoke(_spLdapProfileRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getManager() {
		return _manager;
	}

	@Override
	public void setManager(String manager) {
		_manager = manager;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setManager", String.class);

				method.invoke(_spLdapProfileRemoteModel, manager);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelephoneNumber() {
		return _telephoneNumber;
	}

	@Override
	public void setTelephoneNumber(String telephoneNumber) {
		_telephoneNumber = telephoneNumber;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setTelephoneNumber",
						String.class);

				method.invoke(_spLdapProfileRemoteModel, telephoneNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobile() {
		return _mobile;
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setMobile", String.class);

				method.invoke(_spLdapProfileRemoteModel, mobile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFacsimileTelephoneNumber() {
		return _facsimileTelephoneNumber;
	}

	@Override
	public void setFacsimileTelephoneNumber(String facsimileTelephoneNumber) {
		_facsimileTelephoneNumber = facsimileTelephoneNumber;

		if (_spLdapProfileRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setFacsimileTelephoneNumber",
						String.class);

				method.invoke(_spLdapProfileRemoteModel,
					facsimileTelephoneNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPLdapProfileRemoteModel() {
		return _spLdapProfileRemoteModel;
	}

	public void setSPLdapProfileRemoteModel(
		BaseModel<?> spLdapProfileRemoteModel) {
		_spLdapProfileRemoteModel = spLdapProfileRemoteModel;
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

		Class<?> remoteModelClass = _spLdapProfileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spLdapProfileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPLdapProfileLocalServiceUtil.addSPLdapProfile(this);
		}
		else {
			SPLdapProfileLocalServiceUtil.updateSPLdapProfile(this);
		}
	}

	@Override
	public SPLdapProfile toEscapedModel() {
		return (SPLdapProfile)ProxyUtil.newProxyInstance(SPLdapProfile.class.getClassLoader(),
			new Class[] { SPLdapProfile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPLdapProfileClp clone = new SPLdapProfileClp();

		clone.setSpLdapProfileId(getSpLdapProfileId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setCountryId(getCountryId());
		clone.setDepartmentId(getDepartmentId());
		clone.setGivenName(getGivenName());
		clone.setSn(getSn());
		clone.setDisplayName(getDisplayName());
		clone.setCompany(getCompany());
		clone.setDivision(getDivision());
		clone.setTitle(getTitle());
		clone.setMail(getMail());
		clone.setSamAccountName(getSamAccountName());
		clone.setEmployeeId(getEmployeeId());
		clone.setManager(getManager());
		clone.setTelephoneNumber(getTelephoneNumber());
		clone.setMobile(getMobile());
		clone.setFacsimileTelephoneNumber(getFacsimileTelephoneNumber());

		return clone;
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

		if (!(obj instanceof SPLdapProfileClp)) {
			return false;
		}

		SPLdapProfileClp spLdapProfile = (SPLdapProfileClp)obj;

		long primaryKey = spLdapProfile.getPrimaryKey();

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

	private long _spLdapProfileId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _spLdapProfileRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}