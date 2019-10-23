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
import com.sambaash.platform.srv.service.StudentCourseFeeInstmntLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class StudentCourseFeeInstmntClp extends BaseModelImpl<StudentCourseFeeInstmnt>
	implements StudentCourseFeeInstmnt {
	public StudentCourseFeeInstmntClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StudentCourseFeeInstmnt.class;
	}

	@Override
	public String getModelClassName() {
		return StudentCourseFeeInstmnt.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spStudentCourseFeeInstmntId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpStudentCourseFeeInstmntId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spStudentCourseFeeInstmntId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudentCourseFeeInstmntId",
			getSpStudentCourseFeeInstmntId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessStateId", getSpPEProcessStateId());
		attributes.put("insmntNo", getInsmntNo());
		attributes.put("amount", getAmount());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudentCourseFeeInstmntId = (Long)attributes.get(
				"spStudentCourseFeeInstmntId");

		if (spStudentCourseFeeInstmntId != null) {
			setSpStudentCourseFeeInstmntId(spStudentCourseFeeInstmntId);
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

		Long spPEProcessStateId = (Long)attributes.get("spPEProcessStateId");

		if (spPEProcessStateId != null) {
			setSpPEProcessStateId(spPEProcessStateId);
		}

		Integer insmntNo = (Integer)attributes.get("insmntNo");

		if (insmntNo != null) {
			setInsmntNo(insmntNo);
		}

		String amount = (String)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@Override
	public long getSpStudentCourseFeeInstmntId() {
		return _spStudentCourseFeeInstmntId;
	}

	@Override
	public void setSpStudentCourseFeeInstmntId(long spStudentCourseFeeInstmntId) {
		_spStudentCourseFeeInstmntId = spStudentCourseFeeInstmntId;

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setSpStudentCourseFeeInstmntId",
						long.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel,
					spStudentCourseFeeInstmntId);
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

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel, groupId);
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

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel, companyId);
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

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel, userId);
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

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel, userName);
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

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel, createDate);
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

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessStateId() {
		return _spPEProcessStateId;
	}

	@Override
	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_spPEProcessStateId = spPEProcessStateId;

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStateId",
						long.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel,
					spPEProcessStateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getInsmntNo() {
		return _insmntNo;
	}

	@Override
	public void setInsmntNo(int insmntNo) {
		_insmntNo = insmntNo;

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setInsmntNo", int.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel, insmntNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(String amount) {
		_amount = amount;

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", String.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;

		if (_studentCourseFeeInstmntRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeInstmntRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_studentCourseFeeInstmntRemoteModel, date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStudentCourseFeeInstmntRemoteModel() {
		return _studentCourseFeeInstmntRemoteModel;
	}

	public void setStudentCourseFeeInstmntRemoteModel(
		BaseModel<?> studentCourseFeeInstmntRemoteModel) {
		_studentCourseFeeInstmntRemoteModel = studentCourseFeeInstmntRemoteModel;
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

		Class<?> remoteModelClass = _studentCourseFeeInstmntRemoteModel.getClass();

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

		Object returnValue = method.invoke(_studentCourseFeeInstmntRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StudentCourseFeeInstmntLocalServiceUtil.addStudentCourseFeeInstmnt(this);
		}
		else {
			StudentCourseFeeInstmntLocalServiceUtil.updateStudentCourseFeeInstmnt(this);
		}
	}

	@Override
	public StudentCourseFeeInstmnt toEscapedModel() {
		return (StudentCourseFeeInstmnt)ProxyUtil.newProxyInstance(StudentCourseFeeInstmnt.class.getClassLoader(),
			new Class[] { StudentCourseFeeInstmnt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudentCourseFeeInstmntClp clone = new StudentCourseFeeInstmntClp();

		clone.setSpStudentCourseFeeInstmntId(getSpStudentCourseFeeInstmntId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpPEProcessStateId(getSpPEProcessStateId());
		clone.setInsmntNo(getInsmntNo());
		clone.setAmount(getAmount());
		clone.setDate(getDate());

		return clone;
	}

	@Override
	public int compareTo(StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		long primaryKey = studentCourseFeeInstmnt.getPrimaryKey();

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

		if (!(obj instanceof StudentCourseFeeInstmntClp)) {
			return false;
		}

		StudentCourseFeeInstmntClp studentCourseFeeInstmnt = (StudentCourseFeeInstmntClp)obj;

		long primaryKey = studentCourseFeeInstmnt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{spStudentCourseFeeInstmntId=");
		sb.append(getSpStudentCourseFeeInstmntId());
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
		sb.append(", spPEProcessStateId=");
		sb.append(getSpPEProcessStateId());
		sb.append(", insmntNo=");
		sb.append(getInsmntNo());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", date=");
		sb.append(getDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.StudentCourseFeeInstmnt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spStudentCourseFeeInstmntId</column-name><column-value><![CDATA[");
		sb.append(getSpStudentCourseFeeInstmntId());
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
			"<column><column-name>spPEProcessStateId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insmntNo</column-name><column-value><![CDATA[");
		sb.append(getInsmntNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spStudentCourseFeeInstmntId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPEProcessStateId;
	private int _insmntNo;
	private String _amount;
	private Date _date;
	private BaseModel<?> _studentCourseFeeInstmntRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}