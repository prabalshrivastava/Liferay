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
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class CompetencyUnitClp extends BaseModelImpl<CompetencyUnit>
	implements CompetencyUnit {
	public CompetencyUnitClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CompetencyUnit.class;
	}

	@Override
	public String getModelClassName() {
		return CompetencyUnit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCompetencyUnitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCompetencyUnitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCompetencyUnitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCompetencyUnitId", getSpCompetencyUnitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("spFrameworkId", getSpFrameworkId());
		attributes.put("competencyUnitCode", getCompetencyUnitCode());
		attributes.put("competencyUnitDesc", getCompetencyUnitDesc());
		attributes.put("jobFamily", getJobFamily());
		attributes.put("competencyLevel", getCompetencyLevel());
		attributes.put("creditValue", getCreditValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCompetencyUnitId = (Long)attributes.get("spCompetencyUnitId");

		if (spCompetencyUnitId != null) {
			setSpCompetencyUnitId(spCompetencyUnitId);
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

		Long spFrameworkId = (Long)attributes.get("spFrameworkId");

		if (spFrameworkId != null) {
			setSpFrameworkId(spFrameworkId);
		}

		String competencyUnitCode = (String)attributes.get("competencyUnitCode");

		if (competencyUnitCode != null) {
			setCompetencyUnitCode(competencyUnitCode);
		}

		String competencyUnitDesc = (String)attributes.get("competencyUnitDesc");

		if (competencyUnitDesc != null) {
			setCompetencyUnitDesc(competencyUnitDesc);
		}

		Long jobFamily = (Long)attributes.get("jobFamily");

		if (jobFamily != null) {
			setJobFamily(jobFamily);
		}

		Long competencyLevel = (Long)attributes.get("competencyLevel");

		if (competencyLevel != null) {
			setCompetencyLevel(competencyLevel);
		}

		Long creditValue = (Long)attributes.get("creditValue");

		if (creditValue != null) {
			setCreditValue(creditValue);
		}
	}

	@Override
	public long getSpCompetencyUnitId() {
		return _spCompetencyUnitId;
	}

	@Override
	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_spCompetencyUnitId = spCompetencyUnitId;

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCompetencyUnitId",
						long.class);

				method.invoke(_competencyUnitRemoteModel, spCompetencyUnitId);
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

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_competencyUnitRemoteModel, groupId);
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

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_competencyUnitRemoteModel, companyId);
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

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_competencyUnitRemoteModel, userId);
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

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_competencyUnitRemoteModel, userName);
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

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_competencyUnitRemoteModel, createDate);
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

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_competencyUnitRemoteModel, modifiedDate);
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

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_competencyUnitRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpFrameworkId() {
		return _spFrameworkId;
	}

	@Override
	public void setSpFrameworkId(long spFrameworkId) {
		_spFrameworkId = spFrameworkId;

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setSpFrameworkId", long.class);

				method.invoke(_competencyUnitRemoteModel, spFrameworkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompetencyUnitCode() {
		return _competencyUnitCode;
	}

	@Override
	public void setCompetencyUnitCode(String competencyUnitCode) {
		_competencyUnitCode = competencyUnitCode;

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompetencyUnitCode",
						String.class);

				method.invoke(_competencyUnitRemoteModel, competencyUnitCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompetencyUnitDesc() {
		return _competencyUnitDesc;
	}

	@Override
	public void setCompetencyUnitDesc(String competencyUnitDesc) {
		_competencyUnitDesc = competencyUnitDesc;

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompetencyUnitDesc",
						String.class);

				method.invoke(_competencyUnitRemoteModel, competencyUnitDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobFamily() {
		return _jobFamily;
	}

	@Override
	public void setJobFamily(long jobFamily) {
		_jobFamily = jobFamily;

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setJobFamily", long.class);

				method.invoke(_competencyUnitRemoteModel, jobFamily);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompetencyLevel() {
		return _competencyLevel;
	}

	@Override
	public void setCompetencyLevel(long competencyLevel) {
		_competencyLevel = competencyLevel;

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompetencyLevel", long.class);

				method.invoke(_competencyUnitRemoteModel, competencyLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreditValue() {
		return _creditValue;
	}

	@Override
	public void setCreditValue(long creditValue) {
		_creditValue = creditValue;

		if (_competencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _competencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditValue", long.class);

				method.invoke(_competencyUnitRemoteModel, creditValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCompetencyUnitRemoteModel() {
		return _competencyUnitRemoteModel;
	}

	public void setCompetencyUnitRemoteModel(
		BaseModel<?> competencyUnitRemoteModel) {
		_competencyUnitRemoteModel = competencyUnitRemoteModel;
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

		Class<?> remoteModelClass = _competencyUnitRemoteModel.getClass();

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

		Object returnValue = method.invoke(_competencyUnitRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CompetencyUnitLocalServiceUtil.addCompetencyUnit(this);
		}
		else {
			CompetencyUnitLocalServiceUtil.updateCompetencyUnit(this);
		}
	}

	@Override
	public CompetencyUnit toEscapedModel() {
		return (CompetencyUnit)ProxyUtil.newProxyInstance(CompetencyUnit.class.getClassLoader(),
			new Class[] { CompetencyUnit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CompetencyUnitClp clone = new CompetencyUnitClp();

		clone.setSpCompetencyUnitId(getSpCompetencyUnitId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryId(getCountryId());
		clone.setSpFrameworkId(getSpFrameworkId());
		clone.setCompetencyUnitCode(getCompetencyUnitCode());
		clone.setCompetencyUnitDesc(getCompetencyUnitDesc());
		clone.setJobFamily(getJobFamily());
		clone.setCompetencyLevel(getCompetencyLevel());
		clone.setCreditValue(getCreditValue());

		return clone;
	}

	@Override
	public int compareTo(CompetencyUnit competencyUnit) {
		int value = 0;

		value = getCompetencyUnitCode()
					.compareTo(competencyUnit.getCompetencyUnitCode());

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

		if (!(obj instanceof CompetencyUnitClp)) {
			return false;
		}

		CompetencyUnitClp competencyUnit = (CompetencyUnitClp)obj;

		long primaryKey = competencyUnit.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{spCompetencyUnitId=");
		sb.append(getSpCompetencyUnitId());
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
		sb.append(", spFrameworkId=");
		sb.append(getSpFrameworkId());
		sb.append(", competencyUnitCode=");
		sb.append(getCompetencyUnitCode());
		sb.append(", competencyUnitDesc=");
		sb.append(getCompetencyUnitDesc());
		sb.append(", jobFamily=");
		sb.append(getJobFamily());
		sb.append(", competencyLevel=");
		sb.append(getCompetencyLevel());
		sb.append(", creditValue=");
		sb.append(getCreditValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.CompetencyUnit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCompetencyUnitId</column-name><column-value><![CDATA[");
		sb.append(getSpCompetencyUnitId());
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
			"<column><column-name>spFrameworkId</column-name><column-value><![CDATA[");
		sb.append(getSpFrameworkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyUnitCode</column-name><column-value><![CDATA[");
		sb.append(getCompetencyUnitCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyUnitDesc</column-name><column-value><![CDATA[");
		sb.append(getCompetencyUnitDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobFamily</column-name><column-value><![CDATA[");
		sb.append(getJobFamily());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyLevel</column-name><column-value><![CDATA[");
		sb.append(getCompetencyLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditValue</column-name><column-value><![CDATA[");
		sb.append(getCreditValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spCompetencyUnitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private long _spFrameworkId;
	private String _competencyUnitCode;
	private String _competencyUnitDesc;
	private long _jobFamily;
	private long _competencyLevel;
	private long _creditValue;
	private BaseModel<?> _competencyUnitRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}