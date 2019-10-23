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

package com.sambaash.platform.srv.extendedprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.extendedprofile.service.ClpSerializer;
import com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPJobRoleClp extends BaseModelImpl<SPJobRole> implements SPJobRole {
	public SPJobRoleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPJobRole.class;
	}

	@Override
	public String getModelClassName() {
		return SPJobRole.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spJobRoleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpJobRoleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spJobRoleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spJobRoleId", getSpJobRoleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("functionalGroupId", getFunctionalGroupId());
		attributes.put("JobLevelId", getJobLevelId());
		attributes.put("careerPathId", getCareerPathId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spJobRoleId = (Long)attributes.get("spJobRoleId");

		if (spJobRoleId != null) {
			setSpJobRoleId(spJobRoleId);
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

		Long functionalGroupId = (Long)attributes.get("functionalGroupId");

		if (functionalGroupId != null) {
			setFunctionalGroupId(functionalGroupId);
		}

		Long JobLevelId = (Long)attributes.get("JobLevelId");

		if (JobLevelId != null) {
			setJobLevelId(JobLevelId);
		}

		Long careerPathId = (Long)attributes.get("careerPathId");

		if (careerPathId != null) {
			setCareerPathId(careerPathId);
		}
	}

	@Override
	public long getSpJobRoleId() {
		return _spJobRoleId;
	}

	@Override
	public void setSpJobRoleId(long spJobRoleId) {
		_spJobRoleId = spJobRoleId;

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setSpJobRoleId", long.class);

				method.invoke(_spJobRoleRemoteModel, spJobRoleId);
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

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spJobRoleRemoteModel, groupId);
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

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spJobRoleRemoteModel, companyId);
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

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spJobRoleRemoteModel, userId);
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

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spJobRoleRemoteModel, userName);
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

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spJobRoleRemoteModel, createDate);
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

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spJobRoleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFunctionalGroupId() {
		return _functionalGroupId;
	}

	@Override
	public void setFunctionalGroupId(long functionalGroupId) {
		_functionalGroupId = functionalGroupId;

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setFunctionalGroupId",
						long.class);

				method.invoke(_spJobRoleRemoteModel, functionalGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobLevelId() {
		return _JobLevelId;
	}

	@Override
	public void setJobLevelId(long JobLevelId) {
		_JobLevelId = JobLevelId;

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setJobLevelId", long.class);

				method.invoke(_spJobRoleRemoteModel, JobLevelId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCareerPathId() {
		return _careerPathId;
	}

	@Override
	public void setCareerPathId(long careerPathId) {
		_careerPathId = careerPathId;

		if (_spJobRoleRemoteModel != null) {
			try {
				Class<?> clazz = _spJobRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCareerPathId", long.class);

				method.invoke(_spJobRoleRemoteModel, careerPathId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPJobRoleRemoteModel() {
		return _spJobRoleRemoteModel;
	}

	public void setSPJobRoleRemoteModel(BaseModel<?> spJobRoleRemoteModel) {
		_spJobRoleRemoteModel = spJobRoleRemoteModel;
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

		Class<?> remoteModelClass = _spJobRoleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spJobRoleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPJobRoleLocalServiceUtil.addSPJobRole(this);
		}
		else {
			SPJobRoleLocalServiceUtil.updateSPJobRole(this);
		}
	}

	@Override
	public SPJobRole toEscapedModel() {
		return (SPJobRole)ProxyUtil.newProxyInstance(SPJobRole.class.getClassLoader(),
			new Class[] { SPJobRole.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPJobRoleClp clone = new SPJobRoleClp();

		clone.setSpJobRoleId(getSpJobRoleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFunctionalGroupId(getFunctionalGroupId());
		clone.setJobLevelId(getJobLevelId());
		clone.setCareerPathId(getCareerPathId());

		return clone;
	}

	@Override
	public int compareTo(SPJobRole spJobRole) {
		int value = 0;

		if (getUserId() < spJobRole.getUserId()) {
			value = -1;
		}
		else if (getUserId() > spJobRole.getUserId()) {
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

		if (!(obj instanceof SPJobRoleClp)) {
			return false;
		}

		SPJobRoleClp spJobRole = (SPJobRoleClp)obj;

		long primaryKey = spJobRole.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{spJobRoleId=");
		sb.append(getSpJobRoleId());
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
		sb.append(", functionalGroupId=");
		sb.append(getFunctionalGroupId());
		sb.append(", JobLevelId=");
		sb.append(getJobLevelId());
		sb.append(", careerPathId=");
		sb.append(getCareerPathId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.extendedprofile.model.SPJobRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spJobRoleId</column-name><column-value><![CDATA[");
		sb.append(getSpJobRoleId());
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
			"<column><column-name>functionalGroupId</column-name><column-value><![CDATA[");
		sb.append(getFunctionalGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>JobLevelId</column-name><column-value><![CDATA[");
		sb.append(getJobLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>careerPathId</column-name><column-value><![CDATA[");
		sb.append(getCareerPathId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spJobRoleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _functionalGroupId;
	private long _JobLevelId;
	private long _careerPathId;
	private BaseModel<?> _spJobRoleRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.extendedprofile.service.ClpSerializer.class;
}