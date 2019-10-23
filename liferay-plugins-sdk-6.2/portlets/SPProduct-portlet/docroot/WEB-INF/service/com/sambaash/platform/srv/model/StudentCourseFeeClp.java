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
import com.sambaash.platform.srv.service.StudentCourseFeeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class StudentCourseFeeClp extends BaseModelImpl<StudentCourseFee>
	implements StudentCourseFee {
	public StudentCourseFeeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StudentCourseFee.class;
	}

	@Override
	public String getModelClassName() {
		return StudentCourseFee.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spStudentCourseFeeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpStudentCourseFeeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spStudentCourseFeeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudentCourseFeeId", getSpStudentCourseFeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessStateId", getSpPEProcessStateId());
		attributes.put("feeType", getFeeType());
		attributes.put("amount", getAmount());
		attributes.put("order", getOrder());
		attributes.put("formula", getFormula());
		attributes.put("label", getLabel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudentCourseFeeId = (Long)attributes.get("spStudentCourseFeeId");

		if (spStudentCourseFeeId != null) {
			setSpStudentCourseFeeId(spStudentCourseFeeId);
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

		String feeType = (String)attributes.get("feeType");

		if (feeType != null) {
			setFeeType(feeType);
		}

		String amount = (String)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String formula = (String)attributes.get("formula");

		if (formula != null) {
			setFormula(formula);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}
	}

	@Override
	public long getSpStudentCourseFeeId() {
		return _spStudentCourseFeeId;
	}

	@Override
	public void setSpStudentCourseFeeId(long spStudentCourseFeeId) {
		_spStudentCourseFeeId = spStudentCourseFeeId;

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpStudentCourseFeeId",
						long.class);

				method.invoke(_studentCourseFeeRemoteModel, spStudentCourseFeeId);
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

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_studentCourseFeeRemoteModel, groupId);
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

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_studentCourseFeeRemoteModel, companyId);
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

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_studentCourseFeeRemoteModel, userId);
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

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_studentCourseFeeRemoteModel, userName);
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

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_studentCourseFeeRemoteModel, createDate);
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

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_studentCourseFeeRemoteModel, modifiedDate);
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

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStateId",
						long.class);

				method.invoke(_studentCourseFeeRemoteModel, spPEProcessStateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFeeType() {
		return _feeType;
	}

	@Override
	public void setFeeType(String feeType) {
		_feeType = feeType;

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setFeeType", String.class);

				method.invoke(_studentCourseFeeRemoteModel, feeType);
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

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", String.class);

				method.invoke(_studentCourseFeeRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_order = order;

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder", int.class);

				method.invoke(_studentCourseFeeRemoteModel, order);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormula() {
		return _formula;
	}

	@Override
	public void setFormula(String formula) {
		_formula = formula;

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setFormula", String.class);

				method.invoke(_studentCourseFeeRemoteModel, formula);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLabel() {
		return _label;
	}

	@Override
	public void setLabel(String label) {
		_label = label;

		if (_studentCourseFeeRemoteModel != null) {
			try {
				Class<?> clazz = _studentCourseFeeRemoteModel.getClass();

				Method method = clazz.getMethod("setLabel", String.class);

				method.invoke(_studentCourseFeeRemoteModel, label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStudentCourseFeeRemoteModel() {
		return _studentCourseFeeRemoteModel;
	}

	public void setStudentCourseFeeRemoteModel(
		BaseModel<?> studentCourseFeeRemoteModel) {
		_studentCourseFeeRemoteModel = studentCourseFeeRemoteModel;
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

		Class<?> remoteModelClass = _studentCourseFeeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_studentCourseFeeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StudentCourseFeeLocalServiceUtil.addStudentCourseFee(this);
		}
		else {
			StudentCourseFeeLocalServiceUtil.updateStudentCourseFee(this);
		}
	}

	@Override
	public StudentCourseFee toEscapedModel() {
		return (StudentCourseFee)ProxyUtil.newProxyInstance(StudentCourseFee.class.getClassLoader(),
			new Class[] { StudentCourseFee.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudentCourseFeeClp clone = new StudentCourseFeeClp();

		clone.setSpStudentCourseFeeId(getSpStudentCourseFeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpPEProcessStateId(getSpPEProcessStateId());
		clone.setFeeType(getFeeType());
		clone.setAmount(getAmount());
		clone.setOrder(getOrder());
		clone.setFormula(getFormula());
		clone.setLabel(getLabel());

		return clone;
	}

	@Override
	public int compareTo(StudentCourseFee studentCourseFee) {
		long primaryKey = studentCourseFee.getPrimaryKey();

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

		if (!(obj instanceof StudentCourseFeeClp)) {
			return false;
		}

		StudentCourseFeeClp studentCourseFee = (StudentCourseFeeClp)obj;

		long primaryKey = studentCourseFee.getPrimaryKey();

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

		sb.append("{spStudentCourseFeeId=");
		sb.append(getSpStudentCourseFeeId());
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
		sb.append(", feeType=");
		sb.append(getFeeType());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append(", formula=");
		sb.append(getFormula());
		sb.append(", label=");
		sb.append(getLabel());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.StudentCourseFee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spStudentCourseFeeId</column-name><column-value><![CDATA[");
		sb.append(getSpStudentCourseFeeId());
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
			"<column><column-name>feeType</column-name><column-value><![CDATA[");
		sb.append(getFeeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formula</column-name><column-value><![CDATA[");
		sb.append(getFormula());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>label</column-name><column-value><![CDATA[");
		sb.append(getLabel());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spStudentCourseFeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPEProcessStateId;
	private String _feeType;
	private String _amount;
	private int _order;
	private String _formula;
	private String _label;
	private BaseModel<?> _studentCourseFeeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}