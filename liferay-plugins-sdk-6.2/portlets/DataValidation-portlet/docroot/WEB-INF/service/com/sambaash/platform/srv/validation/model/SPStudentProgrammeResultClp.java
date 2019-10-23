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

package com.sambaash.platform.srv.validation.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.validation.service.ClpSerializer;
import com.sambaash.platform.srv.validation.service.SPStudentProgrammeResultLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPStudentProgrammeResultClp extends BaseModelImpl<SPStudentProgrammeResult>
	implements SPStudentProgrammeResult {
	public SPStudentProgrammeResultClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPStudentProgrammeResult.class;
	}

	@Override
	public String getModelClassName() {
		return SPStudentProgrammeResult.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spStudentProgrammeResultId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpStudentProgrammeResultId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spStudentProgrammeResultId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudentProgrammeResultId",
			getSpStudentProgrammeResultId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nric", getNric());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("courseCentre", getCourseCentre());
		attributes.put("courseStartDate", getCourseStartDate());
		attributes.put("courseEndDate", getCourseEndDate());
		attributes.put("programme", getProgramme());
		attributes.put("exam", getExam());
		attributes.put("examType", getExamType());
		attributes.put("paper1Result", getPaper1Result());
		attributes.put("paper2Result", getPaper2Result());
		attributes.put("overallResult", getOverallResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudentProgrammeResultId = (Long)attributes.get(
				"spStudentProgrammeResultId");

		if (spStudentProgrammeResultId != null) {
			setSpStudentProgrammeResultId(spStudentProgrammeResultId);
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

		String nric = (String)attributes.get("nric");

		if (nric != null) {
			setNric(nric);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String courseCentre = (String)attributes.get("courseCentre");

		if (courseCentre != null) {
			setCourseCentre(courseCentre);
		}

		Date courseStartDate = (Date)attributes.get("courseStartDate");

		if (courseStartDate != null) {
			setCourseStartDate(courseStartDate);
		}

		Date courseEndDate = (Date)attributes.get("courseEndDate");

		if (courseEndDate != null) {
			setCourseEndDate(courseEndDate);
		}

		String programme = (String)attributes.get("programme");

		if (programme != null) {
			setProgramme(programme);
		}

		Date exam = (Date)attributes.get("exam");

		if (exam != null) {
			setExam(exam);
		}

		String examType = (String)attributes.get("examType");

		if (examType != null) {
			setExamType(examType);
		}

		String paper1Result = (String)attributes.get("paper1Result");

		if (paper1Result != null) {
			setPaper1Result(paper1Result);
		}

		String paper2Result = (String)attributes.get("paper2Result");

		if (paper2Result != null) {
			setPaper2Result(paper2Result);
		}

		String overallResult = (String)attributes.get("overallResult");

		if (overallResult != null) {
			setOverallResult(overallResult);
		}
	}

	@Override
	public long getSpStudentProgrammeResultId() {
		return _spStudentProgrammeResultId;
	}

	@Override
	public void setSpStudentProgrammeResultId(long spStudentProgrammeResultId) {
		_spStudentProgrammeResultId = spStudentProgrammeResultId;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSpStudentProgrammeResultId",
						long.class);

				method.invoke(_spStudentProgrammeResultRemoteModel,
					spStudentProgrammeResultId);
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

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, companyId);
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

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, userId);
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

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, userName);
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

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, createDate);
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

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNric() {
		return _nric;
	}

	@Override
	public void setNric(String nric) {
		_nric = nric;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setNric", String.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, nric);
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

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourseCentre() {
		return _courseCentre;
	}

	@Override
	public void setCourseCentre(String courseCentre) {
		_courseCentre = courseCentre;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseCentre", String.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, courseCentre);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCourseStartDate() {
		return _courseStartDate;
	}

	@Override
	public void setCourseStartDate(Date courseStartDate) {
		_courseStartDate = courseStartDate;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseStartDate", Date.class);

				method.invoke(_spStudentProgrammeResultRemoteModel,
					courseStartDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCourseEndDate() {
		return _courseEndDate;
	}

	@Override
	public void setCourseEndDate(Date courseEndDate) {
		_courseEndDate = courseEndDate;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseEndDate", Date.class);

				method.invoke(_spStudentProgrammeResultRemoteModel,
					courseEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProgramme() {
		return _programme;
	}

	@Override
	public void setProgramme(String programme) {
		_programme = programme;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setProgramme", String.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, programme);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExam() {
		return _exam;
	}

	@Override
	public void setExam(Date exam) {
		_exam = exam;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setExam", Date.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, exam);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExamType() {
		return _examType;
	}

	@Override
	public void setExamType(String examType) {
		_examType = examType;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setExamType", String.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, examType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaper1Result() {
		return _paper1Result;
	}

	@Override
	public void setPaper1Result(String paper1Result) {
		_paper1Result = paper1Result;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setPaper1Result", String.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, paper1Result);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaper2Result() {
		return _paper2Result;
	}

	@Override
	public void setPaper2Result(String paper2Result) {
		_paper2Result = paper2Result;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setPaper2Result", String.class);

				method.invoke(_spStudentProgrammeResultRemoteModel, paper2Result);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOverallResult() {
		return _overallResult;
	}

	@Override
	public void setOverallResult(String overallResult) {
		_overallResult = overallResult;

		if (_spStudentProgrammeResultRemoteModel != null) {
			try {
				Class<?> clazz = _spStudentProgrammeResultRemoteModel.getClass();

				Method method = clazz.getMethod("setOverallResult", String.class);

				method.invoke(_spStudentProgrammeResultRemoteModel,
					overallResult);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPStudentProgrammeResultRemoteModel() {
		return _spStudentProgrammeResultRemoteModel;
	}

	public void setSPStudentProgrammeResultRemoteModel(
		BaseModel<?> spStudentProgrammeResultRemoteModel) {
		_spStudentProgrammeResultRemoteModel = spStudentProgrammeResultRemoteModel;
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

		Class<?> remoteModelClass = _spStudentProgrammeResultRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spStudentProgrammeResultRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPStudentProgrammeResultLocalServiceUtil.addSPStudentProgrammeResult(this);
		}
		else {
			SPStudentProgrammeResultLocalServiceUtil.updateSPStudentProgrammeResult(this);
		}
	}

	@Override
	public SPStudentProgrammeResult toEscapedModel() {
		return (SPStudentProgrammeResult)ProxyUtil.newProxyInstance(SPStudentProgrammeResult.class.getClassLoader(),
			new Class[] { SPStudentProgrammeResult.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPStudentProgrammeResultClp clone = new SPStudentProgrammeResultClp();

		clone.setSpStudentProgrammeResultId(getSpStudentProgrammeResultId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNric(getNric());
		clone.setEmailAddress(getEmailAddress());
		clone.setCourseCentre(getCourseCentre());
		clone.setCourseStartDate(getCourseStartDate());
		clone.setCourseEndDate(getCourseEndDate());
		clone.setProgramme(getProgramme());
		clone.setExam(getExam());
		clone.setExamType(getExamType());
		clone.setPaper1Result(getPaper1Result());
		clone.setPaper2Result(getPaper2Result());
		clone.setOverallResult(getOverallResult());

		return clone;
	}

	@Override
	public int compareTo(SPStudentProgrammeResult spStudentProgrammeResult) {
		int value = 0;

		value = DateUtil.compareTo(getExam(), spStudentProgrammeResult.getExam());

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

		if (!(obj instanceof SPStudentProgrammeResultClp)) {
			return false;
		}

		SPStudentProgrammeResultClp spStudentProgrammeResult = (SPStudentProgrammeResultClp)obj;

		long primaryKey = spStudentProgrammeResult.getPrimaryKey();

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

		sb.append("{spStudentProgrammeResultId=");
		sb.append(getSpStudentProgrammeResultId());
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
		sb.append(", nric=");
		sb.append(getNric());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", courseCentre=");
		sb.append(getCourseCentre());
		sb.append(", courseStartDate=");
		sb.append(getCourseStartDate());
		sb.append(", courseEndDate=");
		sb.append(getCourseEndDate());
		sb.append(", programme=");
		sb.append(getProgramme());
		sb.append(", exam=");
		sb.append(getExam());
		sb.append(", examType=");
		sb.append(getExamType());
		sb.append(", paper1Result=");
		sb.append(getPaper1Result());
		sb.append(", paper2Result=");
		sb.append(getPaper2Result());
		sb.append(", overallResult=");
		sb.append(getOverallResult());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spStudentProgrammeResultId</column-name><column-value><![CDATA[");
		sb.append(getSpStudentProgrammeResultId());
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
			"<column><column-name>nric</column-name><column-value><![CDATA[");
		sb.append(getNric());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseCentre</column-name><column-value><![CDATA[");
		sb.append(getCourseCentre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseStartDate</column-name><column-value><![CDATA[");
		sb.append(getCourseStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseEndDate</column-name><column-value><![CDATA[");
		sb.append(getCourseEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>programme</column-name><column-value><![CDATA[");
		sb.append(getProgramme());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>exam</column-name><column-value><![CDATA[");
		sb.append(getExam());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>examType</column-name><column-value><![CDATA[");
		sb.append(getExamType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paper1Result</column-name><column-value><![CDATA[");
		sb.append(getPaper1Result());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paper2Result</column-name><column-value><![CDATA[");
		sb.append(getPaper2Result());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>overallResult</column-name><column-value><![CDATA[");
		sb.append(getOverallResult());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spStudentProgrammeResultId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nric;
	private String _emailAddress;
	private String _courseCentre;
	private Date _courseStartDate;
	private Date _courseEndDate;
	private String _programme;
	private Date _exam;
	private String _examType;
	private String _paper1Result;
	private String _paper2Result;
	private String _overallResult;
	private BaseModel<?> _spStudentProgrammeResultRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.validation.service.ClpSerializer.class;
}