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
import com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class MiscellaneousFeesClp extends BaseModelImpl<MiscellaneousFees>
	implements MiscellaneousFees {
	public MiscellaneousFeesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MiscellaneousFees.class;
	}

	@Override
	public String getModelClassName() {
		return MiscellaneousFees.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spMiscFeesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMiscFeesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMiscFeesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMiscFeesId", getSpMiscFeesId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("miscFeeType", getMiscFeeType());
		attributes.put("amount", getAmount());
		attributes.put("payable", getPayable());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMiscFeesId = (Long)attributes.get("spMiscFeesId");

		if (spMiscFeesId != null) {
			setSpMiscFeesId(spMiscFeesId);
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

		Long miscFeeType = (Long)attributes.get("miscFeeType");

		if (miscFeeType != null) {
			setMiscFeeType(miscFeeType);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long payable = (Long)attributes.get("payable");

		if (payable != null) {
			setPayable(payable);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	@Override
	public long getSpMiscFeesId() {
		return _spMiscFeesId;
	}

	@Override
	public void setSpMiscFeesId(long spMiscFeesId) {
		_spMiscFeesId = spMiscFeesId;

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMiscFeesId", long.class);

				method.invoke(_miscellaneousFeesRemoteModel, spMiscFeesId);
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

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_miscellaneousFeesRemoteModel, groupId);
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

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_miscellaneousFeesRemoteModel, companyId);
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

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_miscellaneousFeesRemoteModel, userId);
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

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_miscellaneousFeesRemoteModel, userName);
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

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_miscellaneousFeesRemoteModel, createDate);
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

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_miscellaneousFeesRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMiscFeeType() {
		return _miscFeeType;
	}

	@Override
	public void setMiscFeeType(long miscFeeType) {
		_miscFeeType = miscFeeType;

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setMiscFeeType", long.class);

				method.invoke(_miscellaneousFeesRemoteModel, miscFeeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(double amount) {
		_amount = amount;

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", double.class);

				method.invoke(_miscellaneousFeesRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPayable() {
		return _payable;
	}

	@Override
	public void setPayable(long payable) {
		_payable = payable;

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setPayable", long.class);

				method.invoke(_miscellaneousFeesRemoteModel, payable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;

		if (_miscellaneousFeesRemoteModel != null) {
			try {
				Class<?> clazz = _miscellaneousFeesRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_miscellaneousFeesRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMiscellaneousFeesRemoteModel() {
		return _miscellaneousFeesRemoteModel;
	}

	public void setMiscellaneousFeesRemoteModel(
		BaseModel<?> miscellaneousFeesRemoteModel) {
		_miscellaneousFeesRemoteModel = miscellaneousFeesRemoteModel;
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

		Class<?> remoteModelClass = _miscellaneousFeesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_miscellaneousFeesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MiscellaneousFeesLocalServiceUtil.addMiscellaneousFees(this);
		}
		else {
			MiscellaneousFeesLocalServiceUtil.updateMiscellaneousFees(this);
		}
	}

	@Override
	public MiscellaneousFees toEscapedModel() {
		return (MiscellaneousFees)ProxyUtil.newProxyInstance(MiscellaneousFees.class.getClassLoader(),
			new Class[] { MiscellaneousFees.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MiscellaneousFeesClp clone = new MiscellaneousFeesClp();

		clone.setSpMiscFeesId(getSpMiscFeesId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMiscFeeType(getMiscFeeType());
		clone.setAmount(getAmount());
		clone.setPayable(getPayable());
		clone.setSpCourseId(getSpCourseId());

		return clone;
	}

	@Override
	public int compareTo(MiscellaneousFees miscellaneousFees) {
		int value = 0;

		if (getSpCourseId() < miscellaneousFees.getSpCourseId()) {
			value = -1;
		}
		else if (getSpCourseId() > miscellaneousFees.getSpCourseId()) {
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

		if (!(obj instanceof MiscellaneousFeesClp)) {
			return false;
		}

		MiscellaneousFeesClp miscellaneousFees = (MiscellaneousFeesClp)obj;

		long primaryKey = miscellaneousFees.getPrimaryKey();

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

		sb.append("{spMiscFeesId=");
		sb.append(getSpMiscFeesId());
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
		sb.append(", miscFeeType=");
		sb.append(getMiscFeeType());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", payable=");
		sb.append(getPayable());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.MiscellaneousFees");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMiscFeesId</column-name><column-value><![CDATA[");
		sb.append(getSpMiscFeesId());
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
			"<column><column-name>miscFeeType</column-name><column-value><![CDATA[");
		sb.append(getMiscFeeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payable</column-name><column-value><![CDATA[");
		sb.append(getPayable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spMiscFeesId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _miscFeeType;
	private double _amount;
	private long _payable;
	private long _spCourseId;
	private BaseModel<?> _miscellaneousFeesRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}