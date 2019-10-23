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

import com.sambaash.platform.srv.legalandcontract.service.ClpSerializer;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class LitigationClp extends BaseModelImpl<Litigation>
	implements Litigation {
	public LitigationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Litigation.class;
	}

	@Override
	public String getModelClassName() {
		return Litigation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spLitigationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpLitigationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spLitigationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spLitigationId", getSpLitigationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("country", getCountry());
		attributes.put("filedBy", getFiledBy());
		attributes.put("filedOn", getFiledOn());
		attributes.put("filedAtCountry", getFiledAtCountry());
		attributes.put("claimsRemarks", getClaimsRemarks());
		attributes.put("responseDeadline", getResponseDeadline());
		attributes.put("actualResponseDate", getActualResponseDate());
		attributes.put("status", getStatus());
		attributes.put("customField1", getCustomField1());
		attributes.put("customField2", getCustomField2());
		attributes.put("customField3", getCustomField3());
		attributes.put("customDate1", getCustomDate1());
		attributes.put("customDate2", getCustomDate2());
		attributes.put("customDate3", getCustomDate3());
		attributes.put("legalConfRemarks", getLegalConfRemarks());
		attributes.put("version", getVersion());
		attributes.put("spTrademarksId", getSpTrademarksId());
		attributes.put("rootSpLitigationId", getRootSpLitigationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spLitigationId = (Long)attributes.get("spLitigationId");

		if (spLitigationId != null) {
			setSpLitigationId(spLitigationId);
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

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String filedBy = (String)attributes.get("filedBy");

		if (filedBy != null) {
			setFiledBy(filedBy);
		}

		Date filedOn = (Date)attributes.get("filedOn");

		if (filedOn != null) {
			setFiledOn(filedOn);
		}

		String filedAtCountry = (String)attributes.get("filedAtCountry");

		if (filedAtCountry != null) {
			setFiledAtCountry(filedAtCountry);
		}

		String claimsRemarks = (String)attributes.get("claimsRemarks");

		if (claimsRemarks != null) {
			setClaimsRemarks(claimsRemarks);
		}

		Date responseDeadline = (Date)attributes.get("responseDeadline");

		if (responseDeadline != null) {
			setResponseDeadline(responseDeadline);
		}

		Date actualResponseDate = (Date)attributes.get("actualResponseDate");

		if (actualResponseDate != null) {
			setActualResponseDate(actualResponseDate);
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

		String legalConfRemarks = (String)attributes.get("legalConfRemarks");

		if (legalConfRemarks != null) {
			setLegalConfRemarks(legalConfRemarks);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long spTrademarksId = (Long)attributes.get("spTrademarksId");

		if (spTrademarksId != null) {
			setSpTrademarksId(spTrademarksId);
		}

		Long rootSpLitigationId = (Long)attributes.get("rootSpLitigationId");

		if (rootSpLitigationId != null) {
			setRootSpLitigationId(rootSpLitigationId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_litigationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpLitigationId() {
		return _spLitigationId;
	}

	@Override
	public void setSpLitigationId(long spLitigationId) {
		_spLitigationId = spLitigationId;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpLitigationId", long.class);

				method.invoke(_litigationRemoteModel, spLitigationId);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_litigationRemoteModel, groupId);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_litigationRemoteModel, companyId);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_litigationRemoteModel, userId);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_litigationRemoteModel, userName);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_litigationRemoteModel, createDate);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_litigationRemoteModel, modifiedDate);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_litigationRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFiledBy() {
		return _filedBy;
	}

	@Override
	public void setFiledBy(String filedBy) {
		_filedBy = filedBy;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setFiledBy", String.class);

				method.invoke(_litigationRemoteModel, filedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFiledOn() {
		return _filedOn;
	}

	@Override
	public void setFiledOn(Date filedOn) {
		_filedOn = filedOn;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setFiledOn", Date.class);

				method.invoke(_litigationRemoteModel, filedOn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFiledAtCountry() {
		return _filedAtCountry;
	}

	@Override
	public void setFiledAtCountry(String filedAtCountry) {
		_filedAtCountry = filedAtCountry;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setFiledAtCountry",
						String.class);

				method.invoke(_litigationRemoteModel, filedAtCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClaimsRemarks() {
		return _claimsRemarks;
	}

	@Override
	public void setClaimsRemarks(String claimsRemarks) {
		_claimsRemarks = claimsRemarks;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setClaimsRemarks", String.class);

				method.invoke(_litigationRemoteModel, claimsRemarks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getResponseDeadline() {
		return _responseDeadline;
	}

	@Override
	public void setResponseDeadline(Date responseDeadline) {
		_responseDeadline = responseDeadline;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setResponseDeadline",
						Date.class);

				method.invoke(_litigationRemoteModel, responseDeadline);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getActualResponseDate() {
		return _actualResponseDate;
	}

	@Override
	public void setActualResponseDate(Date actualResponseDate) {
		_actualResponseDate = actualResponseDate;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setActualResponseDate",
						Date.class);

				method.invoke(_litigationRemoteModel, actualResponseDate);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_litigationRemoteModel, status);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField1", String.class);

				method.invoke(_litigationRemoteModel, customField1);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField2", String.class);

				method.invoke(_litigationRemoteModel, customField2);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomField3", String.class);

				method.invoke(_litigationRemoteModel, customField3);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate1", Date.class);

				method.invoke(_litigationRemoteModel, customDate1);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate2", Date.class);

				method.invoke(_litigationRemoteModel, customDate2);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomDate3", Date.class);

				method.invoke(_litigationRemoteModel, customDate3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLegalConfRemarks() {
		return _legalConfRemarks;
	}

	@Override
	public void setLegalConfRemarks(String legalConfRemarks) {
		_legalConfRemarks = legalConfRemarks;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setLegalConfRemarks",
						String.class);

				method.invoke(_litigationRemoteModel, legalConfRemarks);
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

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_litigationRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpTrademarksId() {
		return _spTrademarksId;
	}

	@Override
	public void setSpTrademarksId(long spTrademarksId) {
		_spTrademarksId = spTrademarksId;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setSpTrademarksId", long.class);

				method.invoke(_litigationRemoteModel, spTrademarksId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRootSpLitigationId() {
		return _rootSpLitigationId;
	}

	@Override
	public void setRootSpLitigationId(long rootSpLitigationId) {
		_rootSpLitigationId = rootSpLitigationId;

		if (_litigationRemoteModel != null) {
			try {
				Class<?> clazz = _litigationRemoteModel.getClass();

				Method method = clazz.getMethod("setRootSpLitigationId",
						long.class);

				method.invoke(_litigationRemoteModel, rootSpLitigationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Litigation.class.getName()));
	}

	public BaseModel<?> getLitigationRemoteModel() {
		return _litigationRemoteModel;
	}

	public void setLitigationRemoteModel(BaseModel<?> litigationRemoteModel) {
		_litigationRemoteModel = litigationRemoteModel;
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

		Class<?> remoteModelClass = _litigationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_litigationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LitigationLocalServiceUtil.addLitigation(this);
		}
		else {
			LitigationLocalServiceUtil.updateLitigation(this);
		}
	}

	@Override
	public Litigation toEscapedModel() {
		return (Litigation)ProxyUtil.newProxyInstance(Litigation.class.getClassLoader(),
			new Class[] { Litigation.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LitigationClp clone = new LitigationClp();

		clone.setUuid(getUuid());
		clone.setSpLitigationId(getSpLitigationId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountry(getCountry());
		clone.setFiledBy(getFiledBy());
		clone.setFiledOn(getFiledOn());
		clone.setFiledAtCountry(getFiledAtCountry());
		clone.setClaimsRemarks(getClaimsRemarks());
		clone.setResponseDeadline(getResponseDeadline());
		clone.setActualResponseDate(getActualResponseDate());
		clone.setStatus(getStatus());
		clone.setCustomField1(getCustomField1());
		clone.setCustomField2(getCustomField2());
		clone.setCustomField3(getCustomField3());
		clone.setCustomDate1(getCustomDate1());
		clone.setCustomDate2(getCustomDate2());
		clone.setCustomDate3(getCustomDate3());
		clone.setLegalConfRemarks(getLegalConfRemarks());
		clone.setVersion(getVersion());
		clone.setSpTrademarksId(getSpTrademarksId());
		clone.setRootSpLitigationId(getRootSpLitigationId());

		return clone;
	}

	@Override
	public int compareTo(Litigation litigation) {
		long primaryKey = litigation.getPrimaryKey();

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

		if (!(obj instanceof LitigationClp)) {
			return false;
		}

		LitigationClp litigation = (LitigationClp)obj;

		long primaryKey = litigation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(53);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spLitigationId=");
		sb.append(getSpLitigationId());
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
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", filedBy=");
		sb.append(getFiledBy());
		sb.append(", filedOn=");
		sb.append(getFiledOn());
		sb.append(", filedAtCountry=");
		sb.append(getFiledAtCountry());
		sb.append(", claimsRemarks=");
		sb.append(getClaimsRemarks());
		sb.append(", responseDeadline=");
		sb.append(getResponseDeadline());
		sb.append(", actualResponseDate=");
		sb.append(getActualResponseDate());
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
		sb.append(", legalConfRemarks=");
		sb.append(getLegalConfRemarks());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", spTrademarksId=");
		sb.append(getSpTrademarksId());
		sb.append(", rootSpLitigationId=");
		sb.append(getRootSpLitigationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.legalandcontract.model.Litigation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spLitigationId</column-name><column-value><![CDATA[");
		sb.append(getSpLitigationId());
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
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filedBy</column-name><column-value><![CDATA[");
		sb.append(getFiledBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filedOn</column-name><column-value><![CDATA[");
		sb.append(getFiledOn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filedAtCountry</column-name><column-value><![CDATA[");
		sb.append(getFiledAtCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>claimsRemarks</column-name><column-value><![CDATA[");
		sb.append(getClaimsRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>responseDeadline</column-name><column-value><![CDATA[");
		sb.append(getResponseDeadline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actualResponseDate</column-name><column-value><![CDATA[");
		sb.append(getActualResponseDate());
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
			"<column><column-name>legalConfRemarks</column-name><column-value><![CDATA[");
		sb.append(getLegalConfRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spTrademarksId</column-name><column-value><![CDATA[");
		sb.append(getSpTrademarksId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootSpLitigationId</column-name><column-value><![CDATA[");
		sb.append(getRootSpLitigationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spLitigationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _country;
	private String _filedBy;
	private Date _filedOn;
	private String _filedAtCountry;
	private String _claimsRemarks;
	private Date _responseDeadline;
	private Date _actualResponseDate;
	private String _status;
	private String _customField1;
	private String _customField2;
	private String _customField3;
	private Date _customDate1;
	private Date _customDate2;
	private Date _customDate3;
	private String _legalConfRemarks;
	private String _version;
	private long _spTrademarksId;
	private long _rootSpLitigationId;
	private BaseModel<?> _litigationRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.legalandcontract.service.ClpSerializer.class;
}