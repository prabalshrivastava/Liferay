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
import com.sambaash.platform.srv.service.OutcomeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class OutcomeClp extends BaseModelImpl<Outcome> implements Outcome {
	public OutcomeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Outcome.class;
	}

	@Override
	public String getModelClassName() {
		return Outcome.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spOutcomeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpOutcomeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spOutcomeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spOutcomeId", getSpOutcomeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("outcomeCode", getOutcomeCode());
		attributes.put("outcomeDesc", getOutcomeDesc());
		attributes.put("outcomeType", getOutcomeType());
		attributes.put("outcomeFolderId", getOutcomeFolderId());
		attributes.put("spCompetencyUnitId", getSpCompetencyUnitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spOutcomeId = (Long)attributes.get("spOutcomeId");

		if (spOutcomeId != null) {
			setSpOutcomeId(spOutcomeId);
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

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String outcomeCode = (String)attributes.get("outcomeCode");

		if (outcomeCode != null) {
			setOutcomeCode(outcomeCode);
		}

		String outcomeDesc = (String)attributes.get("outcomeDesc");

		if (outcomeDesc != null) {
			setOutcomeDesc(outcomeDesc);
		}

		Long outcomeType = (Long)attributes.get("outcomeType");

		if (outcomeType != null) {
			setOutcomeType(outcomeType);
		}

		Long outcomeFolderId = (Long)attributes.get("outcomeFolderId");

		if (outcomeFolderId != null) {
			setOutcomeFolderId(outcomeFolderId);
		}

		Long spCompetencyUnitId = (Long)attributes.get("spCompetencyUnitId");

		if (spCompetencyUnitId != null) {
			setSpCompetencyUnitId(spCompetencyUnitId);
		}
	}

	@Override
	public long getSpOutcomeId() {
		return _spOutcomeId;
	}

	@Override
	public void setSpOutcomeId(long spOutcomeId) {
		_spOutcomeId = spOutcomeId;

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpOutcomeId", long.class);

				method.invoke(_outcomeRemoteModel, spOutcomeId);
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

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_outcomeRemoteModel, groupId);
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

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_outcomeRemoteModel, companyId);
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

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_outcomeRemoteModel, userId);
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

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_outcomeRemoteModel, userName);
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

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_outcomeRemoteModel, createDate);
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

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_outcomeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_outcomeRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOutcomeCode() {
		return _outcomeCode;
	}

	@Override
	public void setOutcomeCode(String outcomeCode) {
		_outcomeCode = outcomeCode;

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setOutcomeCode", String.class);

				method.invoke(_outcomeRemoteModel, outcomeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOutcomeDesc() {
		return _outcomeDesc;
	}

	@Override
	public void setOutcomeDesc(String outcomeDesc) {
		_outcomeDesc = outcomeDesc;

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setOutcomeDesc", String.class);

				method.invoke(_outcomeRemoteModel, outcomeDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOutcomeType() {
		return _outcomeType;
	}

	@Override
	public void setOutcomeType(long outcomeType) {
		_outcomeType = outcomeType;

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setOutcomeType", long.class);

				method.invoke(_outcomeRemoteModel, outcomeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOutcomeFolderId() {
		return _outcomeFolderId;
	}

	@Override
	public void setOutcomeFolderId(long outcomeFolderId) {
		_outcomeFolderId = outcomeFolderId;

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setOutcomeFolderId", long.class);

				method.invoke(_outcomeRemoteModel, outcomeFolderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCompetencyUnitId() {
		return _spCompetencyUnitId;
	}

	@Override
	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_spCompetencyUnitId = spCompetencyUnitId;

		if (_outcomeRemoteModel != null) {
			try {
				Class<?> clazz = _outcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCompetencyUnitId",
						long.class);

				method.invoke(_outcomeRemoteModel, spCompetencyUnitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOutcomeRemoteModel() {
		return _outcomeRemoteModel;
	}

	public void setOutcomeRemoteModel(BaseModel<?> outcomeRemoteModel) {
		_outcomeRemoteModel = outcomeRemoteModel;
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

		Class<?> remoteModelClass = _outcomeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_outcomeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OutcomeLocalServiceUtil.addOutcome(this);
		}
		else {
			OutcomeLocalServiceUtil.updateOutcome(this);
		}
	}

	@Override
	public Outcome toEscapedModel() {
		return (Outcome)ProxyUtil.newProxyInstance(Outcome.class.getClassLoader(),
			new Class[] { Outcome.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OutcomeClp clone = new OutcomeClp();

		clone.setSpOutcomeId(getSpOutcomeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryId(getCountryId());
		clone.setOutcomeCode(getOutcomeCode());
		clone.setOutcomeDesc(getOutcomeDesc());
		clone.setOutcomeType(getOutcomeType());
		clone.setOutcomeFolderId(getOutcomeFolderId());
		clone.setSpCompetencyUnitId(getSpCompetencyUnitId());

		return clone;
	}

	@Override
	public int compareTo(Outcome outcome) {
		int value = 0;

		value = getOutcomeCode().compareTo(outcome.getOutcomeCode());

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

		if (!(obj instanceof OutcomeClp)) {
			return false;
		}

		OutcomeClp outcome = (OutcomeClp)obj;

		long primaryKey = outcome.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{spOutcomeId=");
		sb.append(getSpOutcomeId());
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
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", outcomeCode=");
		sb.append(getOutcomeCode());
		sb.append(", outcomeDesc=");
		sb.append(getOutcomeDesc());
		sb.append(", outcomeType=");
		sb.append(getOutcomeType());
		sb.append(", outcomeFolderId=");
		sb.append(getOutcomeFolderId());
		sb.append(", spCompetencyUnitId=");
		sb.append(getSpCompetencyUnitId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Outcome");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spOutcomeId</column-name><column-value><![CDATA[");
		sb.append(getSpOutcomeId());
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
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outcomeCode</column-name><column-value><![CDATA[");
		sb.append(getOutcomeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outcomeDesc</column-name><column-value><![CDATA[");
		sb.append(getOutcomeDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outcomeType</column-name><column-value><![CDATA[");
		sb.append(getOutcomeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outcomeFolderId</column-name><column-value><![CDATA[");
		sb.append(getOutcomeFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCompetencyUnitId</column-name><column-value><![CDATA[");
		sb.append(getSpCompetencyUnitId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spOutcomeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private String _outcomeCode;
	private String _outcomeDesc;
	private long _outcomeType;
	private long _outcomeFolderId;
	private long _spCompetencyUnitId;
	private BaseModel<?> _outcomeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}