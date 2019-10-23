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

package com.sambaash.platform.srv.legalandcontract.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.legalandcontract.service.AgencyLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class AgencyClp extends BaseModelImpl<Agency> implements Agency {
	public AgencyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Agency.class;
	}

	@Override
	public String getModelClassName() {
		return Agency.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spAgencyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpAgencyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spAgencyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spAgencyId", getSpAgencyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("number", getNumber());
		attributes.put("country", getCountry());
		attributes.put("name", getName());
		attributes.put("reference", getReference());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("address", getAddress());
		attributes.put("remarks", getRemarks());
		attributes.put("status", getStatus());
		attributes.put("customField1", getCustomField1());
		attributes.put("customField2", getCustomField2());
		attributes.put("customField3", getCustomField3());
		attributes.put("customDate1", getCustomDate1());
		attributes.put("customDate2", getCustomDate2());
		attributes.put("customDate3", getCustomDate3());
		attributes.put("version", getVersion());
		attributes.put("rootSpAgencyId", getRootSpAgencyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spAgencyId = (Long)attributes.get("spAgencyId");

		if (spAgencyId != null) {
			setSpAgencyId(spAgencyId);
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

		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String reference = (String)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}

		String startDate = (String)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String endDate = (String)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String customField1 = (String)attributes.get("customField1");

		if (customField1 != null) {
			setCustomField1(customField1);
		}

		String customField2 = (String)attributes.get("customField2");

		if (customField2 != null) {
			setCustomField2(customField2);
		}

		String customField3 = (String)attributes.get("customField3");

		if (customField3 != null) {
			setCustomField3(customField3);
		}

		Date customDate1 = (Date)attributes.get("customDate1");

		if (customDate1 != null) {
			setCustomDate1(customDate1);
		}

		Date customDate2 = (Date)attributes.get("customDate2");

		if (customDate2 != null) {
			setCustomDate2(customDate2);
		}

		Date customDate3 = (Date)attributes.get("customDate3");

		if (customDate3 != null) {
			setCustomDate3(customDate3);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long rootSpAgencyId = (Long)attributes.get("rootSpAgencyId");

		if (rootSpAgencyId != null) {
			setRootSpAgencyId(rootSpAgencyId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_agencyRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpAgencyId() {
		return _spAgencyId;
	}

	@Override
	public void setSpAgencyId(long spAgencyId) {
		_spAgencyId = spAgencyId;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAgencyId", long.class);

				method.invoke(_agencyRemoteModel, spAgencyId);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_agencyRemoteModel, groupId);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_agencyRemoteModel, companyId);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_agencyRemoteModel, userId);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_agencyRemoteModel, userName);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_agencyRemoteModel, createDate);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_agencyRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNumber() {
		return _number;
	}

	@Override
	public void setNumber(String number) {
		_number = number;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setNumber", String.class);

				method.invoke(_agencyRemoteModel, number);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_agencyRemoteModel, country);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_agencyRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReference() {
		return _reference;
	}

	@Override
	public void setReference(String reference) {
		_reference = reference;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setReference", String.class);

				method.invoke(_agencyRemoteModel, reference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(String startDate) {
		_startDate = startDate;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", String.class);

				method.invoke(_agencyRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(String endDate) {
		_endDate = endDate;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", String.class);

				method.invoke(_agencyRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_agencyRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemarks() {
		return _remarks;
	}

	@Override
	public void setRemarks(String remarks) {
		_remarks = remarks;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setRemarks", String.class);

				method.invoke(_agencyRemoteModel, remarks);
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

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_agencyRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomField1() {
		return _customField1;
	}

	@Override
	public void setCustomField1(String customField1) {
		_customField1 = customField1;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField1", String.class);

				method.invoke(_agencyRemoteModel, customField1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomField2() {
		return _customField2;
	}

	@Override
	public void setCustomField2(String customField2) {
		_customField2 = customField2;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField2", String.class);

				method.invoke(_agencyRemoteModel, customField2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomField3() {
		return _customField3;
	}

	@Override
	public void setCustomField3(String customField3) {
		_customField3 = customField3;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField3", String.class);

				method.invoke(_agencyRemoteModel, customField3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCustomDate1() {
		return _customDate1;
	}

	@Override
	public void setCustomDate1(Date customDate1) {
		_customDate1 = customDate1;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate1", Date.class);

				method.invoke(_agencyRemoteModel, customDate1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCustomDate2() {
		return _customDate2;
	}

	@Override
	public void setCustomDate2(Date customDate2) {
		_customDate2 = customDate2;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate2", Date.class);

				method.invoke(_agencyRemoteModel, customDate2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCustomDate3() {
		return _customDate3;
	}

	@Override
	public void setCustomDate3(Date customDate3) {
		_customDate3 = customDate3;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate3", Date.class);

				method.invoke(_agencyRemoteModel, customDate3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_agencyRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRootSpAgencyId() {
		return _rootSpAgencyId;
	}

	@Override
	public void setRootSpAgencyId(long rootSpAgencyId) {
		_rootSpAgencyId = rootSpAgencyId;

		if (_agencyRemoteModel != null) {
			try {
				Class<?> clazz = _agencyRemoteModel.getClass();

				Method method = clazz.getMethod("setRootSpAgencyId", long.class);

				method.invoke(_agencyRemoteModel, rootSpAgencyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Agency.class.getName()));
	}

	public BaseModel<?> getAgencyRemoteModel() {
		return _agencyRemoteModel;
	}

	public void setAgencyRemoteModel(BaseModel<?> agencyRemoteModel) {
		_agencyRemoteModel = agencyRemoteModel;
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

		Class<?> remoteModelClass = _agencyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_agencyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AgencyLocalServiceUtil.addAgency(this);
		}
		else {
			AgencyLocalServiceUtil.updateAgency(this);
		}
	}

	@Override
	public Agency toEscapedModel() {
		return (Agency)ProxyUtil.newProxyInstance(Agency.class.getClassLoader(),
			new Class[] { Agency.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AgencyClp clone = new AgencyClp();

		clone.setUuid(getUuid());
		clone.setSpAgencyId(getSpAgencyId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNumber(getNumber());
		clone.setCountry(getCountry());
		clone.setName(getName());
		clone.setReference(getReference());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setAddress(getAddress());
		clone.setRemarks(getRemarks());
		clone.setStatus(getStatus());
		clone.setCustomField1(getCustomField1());
		clone.setCustomField2(getCustomField2());
		clone.setCustomField3(getCustomField3());
		clone.setCustomDate1(getCustomDate1());
		clone.setCustomDate2(getCustomDate2());
		clone.setCustomDate3(getCustomDate3());
		clone.setVersion(getVersion());
		clone.setRootSpAgencyId(getRootSpAgencyId());

		return clone;
	}

	@Override
	public int compareTo(Agency agency) {
		long primaryKey = agency.getPrimaryKey();

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

		if (!(obj instanceof AgencyClp)) {
			return false;
		}

		AgencyClp agency = (AgencyClp)obj;

		long primaryKey = agency.getPrimaryKey();

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
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spAgencyId=");
		sb.append(getSpAgencyId());
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
		sb.append(", number=");
		sb.append(getNumber());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", reference=");
		sb.append(getReference());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", remarks=");
		sb.append(getRemarks());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", customField1=");
		sb.append(getCustomField1());
		sb.append(", customField2=");
		sb.append(getCustomField2());
		sb.append(", customField3=");
		sb.append(getCustomField3());
		sb.append(", customDate1=");
		sb.append(getCustomDate1());
		sb.append(", customDate2=");
		sb.append(getCustomDate2());
		sb.append(", customDate3=");
		sb.append(getCustomDate3());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", rootSpAgencyId=");
		sb.append(getRootSpAgencyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.legalandcontract.model.Agency");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAgencyId</column-name><column-value><![CDATA[");
		sb.append(getSpAgencyId());
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
			"<column><column-name>number</column-name><column-value><![CDATA[");
		sb.append(getNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reference</column-name><column-value><![CDATA[");
		sb.append(getReference());
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
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remarks</column-name><column-value><![CDATA[");
		sb.append(getRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField1</column-name><column-value><![CDATA[");
		sb.append(getCustomField1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField2</column-name><column-value><![CDATA[");
		sb.append(getCustomField2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customField3</column-name><column-value><![CDATA[");
		sb.append(getCustomField3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate1</column-name><column-value><![CDATA[");
		sb.append(getCustomDate1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate2</column-name><column-value><![CDATA[");
		sb.append(getCustomDate2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customDate3</column-name><column-value><![CDATA[");
		sb.append(getCustomDate3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootSpAgencyId</column-name><column-value><![CDATA[");
		sb.append(getRootSpAgencyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spAgencyId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _number;
	private String _country;
	private String _name;
	private String _reference;
	private String _startDate;
	private String _endDate;
	private String _address;
	private String _remarks;
	private String _status;
	private String _customField1;
	private String _customField2;
	private String _customField3;
	private Date _customDate1;
	private Date _customDate2;
	private Date _customDate3;
	private String _version;
	private long _rootSpAgencyId;
	private BaseModel<?> _agencyRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.legalandcontract.service.ClpSerializer.class;
}