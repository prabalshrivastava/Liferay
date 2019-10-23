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

import com.sambaash.platform.srv.service.AssessmentLocalServiceUtil;
import com.sambaash.platform.srv.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class AssessmentClp extends BaseModelImpl<Assessment>
	implements Assessment {
	public AssessmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Assessment.class;
	}

	@Override
	public String getModelClassName() {
		return Assessment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spAssessmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpAssessmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spAssessmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spAssessmentId", getSpAssessmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("assessmentDesc", getAssessmentDesc());
		attributes.put("assessmentType", getAssessmentType());
		attributes.put("assessmentMethod", getAssessmentMethod());
		attributes.put("assessmentMode", getAssessmentMode());
		attributes.put("locationType", getLocationType());
		attributes.put("eligibility", getEligibility());
		attributes.put("gradingType", getGradingType());
		attributes.put("maximumMarks", getMaximumMarks());
		attributes.put("passingMarks", getPassingMarks());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spAssessmentId = (Long)attributes.get("spAssessmentId");

		if (spAssessmentId != null) {
			setSpAssessmentId(spAssessmentId);
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

		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
		}

		String assessmentDesc = (String)attributes.get("assessmentDesc");

		if (assessmentDesc != null) {
			setAssessmentDesc(assessmentDesc);
		}

		Long assessmentType = (Long)attributes.get("assessmentType");

		if (assessmentType != null) {
			setAssessmentType(assessmentType);
		}

		Long assessmentMethod = (Long)attributes.get("assessmentMethod");

		if (assessmentMethod != null) {
			setAssessmentMethod(assessmentMethod);
		}

		Long assessmentMode = (Long)attributes.get("assessmentMode");

		if (assessmentMode != null) {
			setAssessmentMode(assessmentMode);
		}

		Long locationType = (Long)attributes.get("locationType");

		if (locationType != null) {
			setLocationType(locationType);
		}

		String eligibility = (String)attributes.get("eligibility");

		if (eligibility != null) {
			setEligibility(eligibility);
		}

		Long gradingType = (Long)attributes.get("gradingType");

		if (gradingType != null) {
			setGradingType(gradingType);
		}

		String maximumMarks = (String)attributes.get("maximumMarks");

		if (maximumMarks != null) {
			setMaximumMarks(maximumMarks);
		}

		String passingMarks = (String)attributes.get("passingMarks");

		if (passingMarks != null) {
			setPassingMarks(passingMarks);
		}
	}

	@Override
	public long getSpAssessmentId() {
		return _spAssessmentId;
	}

	@Override
	public void setSpAssessmentId(long spAssessmentId) {
		_spAssessmentId = spAssessmentId;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssessmentId", long.class);

				method.invoke(_assessmentRemoteModel, spAssessmentId);
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

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_assessmentRemoteModel, groupId);
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

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_assessmentRemoteModel, companyId);
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

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_assessmentRemoteModel, userId);
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

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_assessmentRemoteModel, userName);
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

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_assessmentRemoteModel, createDate);
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

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_assessmentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpModuleId() {
		return _spModuleId;
	}

	@Override
	public void setSpModuleId(long spModuleId) {
		_spModuleId = spModuleId;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setSpModuleId", long.class);

				method.invoke(_assessmentRemoteModel, spModuleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssessmentDesc() {
		return _assessmentDesc;
	}

	@Override
	public void setAssessmentDesc(String assessmentDesc) {
		_assessmentDesc = assessmentDesc;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAssessmentDesc",
						String.class);

				method.invoke(_assessmentRemoteModel, assessmentDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssessmentType() {
		return _assessmentType;
	}

	@Override
	public void setAssessmentType(long assessmentType) {
		_assessmentType = assessmentType;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAssessmentType", long.class);

				method.invoke(_assessmentRemoteModel, assessmentType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssessmentMethod() {
		return _assessmentMethod;
	}

	@Override
	public void setAssessmentMethod(long assessmentMethod) {
		_assessmentMethod = assessmentMethod;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAssessmentMethod",
						long.class);

				method.invoke(_assessmentRemoteModel, assessmentMethod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssessmentMode() {
		return _assessmentMode;
	}

	@Override
	public void setAssessmentMode(long assessmentMode) {
		_assessmentMode = assessmentMode;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAssessmentMode", long.class);

				method.invoke(_assessmentRemoteModel, assessmentMode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLocationType() {
		return _locationType;
	}

	@Override
	public void setLocationType(long locationType) {
		_locationType = locationType;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationType", long.class);

				method.invoke(_assessmentRemoteModel, locationType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEligibility() {
		return _eligibility;
	}

	@Override
	public void setEligibility(String eligibility) {
		_eligibility = eligibility;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setEligibility", String.class);

				method.invoke(_assessmentRemoteModel, eligibility);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGradingType() {
		return _gradingType;
	}

	@Override
	public void setGradingType(long gradingType) {
		_gradingType = gradingType;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setGradingType", long.class);

				method.invoke(_assessmentRemoteModel, gradingType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaximumMarks() {
		return _maximumMarks;
	}

	@Override
	public void setMaximumMarks(String maximumMarks) {
		_maximumMarks = maximumMarks;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setMaximumMarks", String.class);

				method.invoke(_assessmentRemoteModel, maximumMarks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassingMarks() {
		return _passingMarks;
	}

	@Override
	public void setPassingMarks(String passingMarks) {
		_passingMarks = passingMarks;

		if (_assessmentRemoteModel != null) {
			try {
				Class<?> clazz = _assessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setPassingMarks", String.class);

				method.invoke(_assessmentRemoteModel, passingMarks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAssessmentRemoteModel() {
		return _assessmentRemoteModel;
	}

	public void setAssessmentRemoteModel(BaseModel<?> assessmentRemoteModel) {
		_assessmentRemoteModel = assessmentRemoteModel;
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

		Class<?> remoteModelClass = _assessmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_assessmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AssessmentLocalServiceUtil.addAssessment(this);
		}
		else {
			AssessmentLocalServiceUtil.updateAssessment(this);
		}
	}

	@Override
	public Assessment toEscapedModel() {
		return (Assessment)ProxyUtil.newProxyInstance(Assessment.class.getClassLoader(),
			new Class[] { Assessment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AssessmentClp clone = new AssessmentClp();

		clone.setSpAssessmentId(getSpAssessmentId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpModuleId(getSpModuleId());
		clone.setAssessmentDesc(getAssessmentDesc());
		clone.setAssessmentType(getAssessmentType());
		clone.setAssessmentMethod(getAssessmentMethod());
		clone.setAssessmentMode(getAssessmentMode());
		clone.setLocationType(getLocationType());
		clone.setEligibility(getEligibility());
		clone.setGradingType(getGradingType());
		clone.setMaximumMarks(getMaximumMarks());
		clone.setPassingMarks(getPassingMarks());

		return clone;
	}

	@Override
	public int compareTo(Assessment assessment) {
		int value = 0;

		value = getAssessmentDesc().compareTo(assessment.getAssessmentDesc());

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

		if (!(obj instanceof AssessmentClp)) {
			return false;
		}

		AssessmentClp assessment = (AssessmentClp)obj;

		long primaryKey = assessment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{spAssessmentId=");
		sb.append(getSpAssessmentId());
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
		sb.append(", spModuleId=");
		sb.append(getSpModuleId());
		sb.append(", assessmentDesc=");
		sb.append(getAssessmentDesc());
		sb.append(", assessmentType=");
		sb.append(getAssessmentType());
		sb.append(", assessmentMethod=");
		sb.append(getAssessmentMethod());
		sb.append(", assessmentMode=");
		sb.append(getAssessmentMode());
		sb.append(", locationType=");
		sb.append(getLocationType());
		sb.append(", eligibility=");
		sb.append(getEligibility());
		sb.append(", gradingType=");
		sb.append(getGradingType());
		sb.append(", maximumMarks=");
		sb.append(getMaximumMarks());
		sb.append(", passingMarks=");
		sb.append(getPassingMarks());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Assessment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spAssessmentId</column-name><column-value><![CDATA[");
		sb.append(getSpAssessmentId());
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
			"<column><column-name>spModuleId</column-name><column-value><![CDATA[");
		sb.append(getSpModuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assessmentDesc</column-name><column-value><![CDATA[");
		sb.append(getAssessmentDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assessmentType</column-name><column-value><![CDATA[");
		sb.append(getAssessmentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assessmentMethod</column-name><column-value><![CDATA[");
		sb.append(getAssessmentMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assessmentMode</column-name><column-value><![CDATA[");
		sb.append(getAssessmentMode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationType</column-name><column-value><![CDATA[");
		sb.append(getLocationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eligibility</column-name><column-value><![CDATA[");
		sb.append(getEligibility());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gradingType</column-name><column-value><![CDATA[");
		sb.append(getGradingType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maximumMarks</column-name><column-value><![CDATA[");
		sb.append(getMaximumMarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passingMarks</column-name><column-value><![CDATA[");
		sb.append(getPassingMarks());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spAssessmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private String _assessmentDesc;
	private long _assessmentType;
	private long _assessmentMethod;
	private long _assessmentMode;
	private long _locationType;
	private String _eligibility;
	private long _gradingType;
	private String _maximumMarks;
	private String _passingMarks;
	private BaseModel<?> _assessmentRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}