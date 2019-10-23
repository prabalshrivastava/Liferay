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
import com.sambaash.platform.srv.service.CourseEnrollContractLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class CourseEnrollContractClp extends BaseModelImpl<CourseEnrollContract>
	implements CourseEnrollContract {
	public CourseEnrollContractClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CourseEnrollContract.class;
	}

	@Override
	public String getModelClassName() {
		return CourseEnrollContract.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCourseContractId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCourseContractId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCourseContractId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseContractId", getSpCourseContractId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("courseType", getCourseType());
		attributes.put("docType", getDocType());
		attributes.put("seqNo", getSeqNo());
		attributes.put("contractTemplateFileEntryId",
			getContractTemplateFileEntryId());
		attributes.put("dataTemplateFileEntryId", getDataTemplateFileEntryId());
		attributes.put("extraInfo", getExtraInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseContractId = (Long)attributes.get("spCourseContractId");

		if (spCourseContractId != null) {
			setSpCourseContractId(spCourseContractId);
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

		String countryId = (String)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long courseType = (Long)attributes.get("courseType");

		if (courseType != null) {
			setCourseType(courseType);
		}

		String docType = (String)attributes.get("docType");

		if (docType != null) {
			setDocType(docType);
		}

		Integer seqNo = (Integer)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Long contractTemplateFileEntryId = (Long)attributes.get(
				"contractTemplateFileEntryId");

		if (contractTemplateFileEntryId != null) {
			setContractTemplateFileEntryId(contractTemplateFileEntryId);
		}

		Long dataTemplateFileEntryId = (Long)attributes.get(
				"dataTemplateFileEntryId");

		if (dataTemplateFileEntryId != null) {
			setDataTemplateFileEntryId(dataTemplateFileEntryId);
		}

		String extraInfo = (String)attributes.get("extraInfo");

		if (extraInfo != null) {
			setExtraInfo(extraInfo);
		}
	}

	@Override
	public long getSpCourseContractId() {
		return _spCourseContractId;
	}

	@Override
	public void setSpCourseContractId(long spCourseContractId) {
		_spCourseContractId = spCourseContractId;

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseContractId",
						long.class);

				method.invoke(_courseEnrollContractRemoteModel,
					spCourseContractId);
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

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_courseEnrollContractRemoteModel, groupId);
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

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_courseEnrollContractRemoteModel, companyId);
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

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_courseEnrollContractRemoteModel, userId);
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

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_courseEnrollContractRemoteModel, userName);
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

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_courseEnrollContractRemoteModel, createDate);
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

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_courseEnrollContractRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(String countryId) {
		_countryId = countryId;

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", String.class);

				method.invoke(_courseEnrollContractRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCourseType() {
		return _courseType;
	}

	@Override
	public void setCourseType(long courseType) {
		_courseType = courseType;

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseType", long.class);

				method.invoke(_courseEnrollContractRemoteModel, courseType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDocType() {
		return _docType;
	}

	@Override
	public void setDocType(String docType) {
		_docType = docType;

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setDocType", String.class);

				method.invoke(_courseEnrollContractRemoteModel, docType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSeqNo() {
		return _seqNo;
	}

	@Override
	public void setSeqNo(int seqNo) {
		_seqNo = seqNo;

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setSeqNo", int.class);

				method.invoke(_courseEnrollContractRemoteModel, seqNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContractTemplateFileEntryId() {
		return _contractTemplateFileEntryId;
	}

	@Override
	public void setContractTemplateFileEntryId(long contractTemplateFileEntryId) {
		_contractTemplateFileEntryId = contractTemplateFileEntryId;

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setContractTemplateFileEntryId",
						long.class);

				method.invoke(_courseEnrollContractRemoteModel,
					contractTemplateFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDataTemplateFileEntryId() {
		return _dataTemplateFileEntryId;
	}

	@Override
	public void setDataTemplateFileEntryId(long dataTemplateFileEntryId) {
		_dataTemplateFileEntryId = dataTemplateFileEntryId;

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setDataTemplateFileEntryId",
						long.class);

				method.invoke(_courseEnrollContractRemoteModel,
					dataTemplateFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtraInfo() {
		return _extraInfo;
	}

	@Override
	public void setExtraInfo(String extraInfo) {
		_extraInfo = extraInfo;

		if (_courseEnrollContractRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollContractRemoteModel.getClass();

				Method method = clazz.getMethod("setExtraInfo", String.class);

				method.invoke(_courseEnrollContractRemoteModel, extraInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCourseEnrollContractRemoteModel() {
		return _courseEnrollContractRemoteModel;
	}

	public void setCourseEnrollContractRemoteModel(
		BaseModel<?> courseEnrollContractRemoteModel) {
		_courseEnrollContractRemoteModel = courseEnrollContractRemoteModel;
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

		Class<?> remoteModelClass = _courseEnrollContractRemoteModel.getClass();

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

		Object returnValue = method.invoke(_courseEnrollContractRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseEnrollContractLocalServiceUtil.addCourseEnrollContract(this);
		}
		else {
			CourseEnrollContractLocalServiceUtil.updateCourseEnrollContract(this);
		}
	}

	@Override
	public CourseEnrollContract toEscapedModel() {
		return (CourseEnrollContract)ProxyUtil.newProxyInstance(CourseEnrollContract.class.getClassLoader(),
			new Class[] { CourseEnrollContract.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseEnrollContractClp clone = new CourseEnrollContractClp();

		clone.setSpCourseContractId(getSpCourseContractId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryId(getCountryId());
		clone.setCourseType(getCourseType());
		clone.setDocType(getDocType());
		clone.setSeqNo(getSeqNo());
		clone.setContractTemplateFileEntryId(getContractTemplateFileEntryId());
		clone.setDataTemplateFileEntryId(getDataTemplateFileEntryId());
		clone.setExtraInfo(getExtraInfo());

		return clone;
	}

	@Override
	public int compareTo(CourseEnrollContract courseEnrollContract) {
		int value = 0;

		if (getSeqNo() < courseEnrollContract.getSeqNo()) {
			value = -1;
		}
		else if (getSeqNo() > courseEnrollContract.getSeqNo()) {
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

		if (!(obj instanceof CourseEnrollContractClp)) {
			return false;
		}

		CourseEnrollContractClp courseEnrollContract = (CourseEnrollContractClp)obj;

		long primaryKey = courseEnrollContract.getPrimaryKey();

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

		sb.append("{spCourseContractId=");
		sb.append(getSpCourseContractId());
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
		sb.append(", courseType=");
		sb.append(getCourseType());
		sb.append(", docType=");
		sb.append(getDocType());
		sb.append(", seqNo=");
		sb.append(getSeqNo());
		sb.append(", contractTemplateFileEntryId=");
		sb.append(getContractTemplateFileEntryId());
		sb.append(", dataTemplateFileEntryId=");
		sb.append(getDataTemplateFileEntryId());
		sb.append(", extraInfo=");
		sb.append(getExtraInfo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.CourseEnrollContract");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCourseContractId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseContractId());
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
			"<column><column-name>courseType</column-name><column-value><![CDATA[");
		sb.append(getCourseType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>docType</column-name><column-value><![CDATA[");
		sb.append(getDocType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seqNo</column-name><column-value><![CDATA[");
		sb.append(getSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractTemplateFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getContractTemplateFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataTemplateFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getDataTemplateFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extraInfo</column-name><column-value><![CDATA[");
		sb.append(getExtraInfo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spCourseContractId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _countryId;
	private long _courseType;
	private String _docType;
	private int _seqNo;
	private long _contractTemplateFileEntryId;
	private long _dataTemplateFileEntryId;
	private String _extraInfo;
	private BaseModel<?> _courseEnrollContractRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}