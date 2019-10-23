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
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class FeeDetailsClp extends BaseModelImpl<FeeDetails>
	implements FeeDetails {
	public FeeDetailsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FeeDetails.class;
	}

	@Override
	public String getModelClassName() {
		return FeeDetails.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spFeeDetailsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpFeeDetailsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spFeeDetailsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFeeDetailsId", getSpFeeDetailsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("feeType", getFeeType());
		attributes.put("feeDesc", getFeeDesc());
		attributes.put("calculationBase", getCalculationBase());
		attributes.put("amount", getAmount());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("fundId", getFundId());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFeeDetailsId = (Long)attributes.get("spFeeDetailsId");

		if (spFeeDetailsId != null) {
			setSpFeeDetailsId(spFeeDetailsId);
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

		Long feeType = (Long)attributes.get("feeType");

		if (feeType != null) {
			setFeeType(feeType);
		}

		String feeDesc = (String)attributes.get("feeDesc");

		if (feeDesc != null) {
			setFeeDesc(feeDesc);
		}

		String calculationBase = (String)attributes.get("calculationBase");

		if (calculationBase != null) {
			setCalculationBase(calculationBase);
		}

		String amount = (String)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long displayOrder = (Long)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
		}

		Long fundId = (Long)attributes.get("fundId");

		if (fundId != null) {
			setFundId(fundId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	@Override
	public long getSpFeeDetailsId() {
		return _spFeeDetailsId;
	}

	@Override
	public void setSpFeeDetailsId(long spFeeDetailsId) {
		_spFeeDetailsId = spFeeDetailsId;

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setSpFeeDetailsId", long.class);

				method.invoke(_feeDetailsRemoteModel, spFeeDetailsId);
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

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_feeDetailsRemoteModel, groupId);
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

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_feeDetailsRemoteModel, companyId);
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

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_feeDetailsRemoteModel, userId);
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

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_feeDetailsRemoteModel, userName);
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

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_feeDetailsRemoteModel, createDate);
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

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_feeDetailsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFeeType() {
		return _feeType;
	}

	@Override
	public void setFeeType(long feeType) {
		_feeType = feeType;

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setFeeType", long.class);

				method.invoke(_feeDetailsRemoteModel, feeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFeeDesc() {
		return _feeDesc;
	}

	@Override
	public void setFeeDesc(String feeDesc) {
		_feeDesc = feeDesc;

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setFeeDesc", String.class);

				method.invoke(_feeDetailsRemoteModel, feeDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCalculationBase() {
		return _calculationBase;
	}

	@Override
	public void setCalculationBase(String calculationBase) {
		_calculationBase = calculationBase;

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCalculationBase",
						String.class);

				method.invoke(_feeDetailsRemoteModel, calculationBase);
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

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", String.class);

				method.invoke(_feeDetailsRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisplayOrder() {
		return _displayOrder;
	}

	@Override
	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrder", long.class);

				method.invoke(_feeDetailsRemoteModel, displayOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFundId() {
		return _fundId;
	}

	@Override
	public void setFundId(long fundId) {
		_fundId = fundId;

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setFundId", long.class);

				method.invoke(_feeDetailsRemoteModel, fundId);
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

		if (_feeDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _feeDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_feeDetailsRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFeeDetailsRemoteModel() {
		return _feeDetailsRemoteModel;
	}

	public void setFeeDetailsRemoteModel(BaseModel<?> feeDetailsRemoteModel) {
		_feeDetailsRemoteModel = feeDetailsRemoteModel;
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

		Class<?> remoteModelClass = _feeDetailsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_feeDetailsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FeeDetailsLocalServiceUtil.addFeeDetails(this);
		}
		else {
			FeeDetailsLocalServiceUtil.updateFeeDetails(this);
		}
	}

	@Override
	public FeeDetails toEscapedModel() {
		return (FeeDetails)ProxyUtil.newProxyInstance(FeeDetails.class.getClassLoader(),
			new Class[] { FeeDetails.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FeeDetailsClp clone = new FeeDetailsClp();

		clone.setSpFeeDetailsId(getSpFeeDetailsId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFeeType(getFeeType());
		clone.setFeeDesc(getFeeDesc());
		clone.setCalculationBase(getCalculationBase());
		clone.setAmount(getAmount());
		clone.setDisplayOrder(getDisplayOrder());
		clone.setFundId(getFundId());
		clone.setSpCourseId(getSpCourseId());

		return clone;
	}

	@Override
	public int compareTo(FeeDetails feeDetails) {
		int value = 0;

		if (getDisplayOrder() < feeDetails.getDisplayOrder()) {
			value = -1;
		}
		else if (getDisplayOrder() > feeDetails.getDisplayOrder()) {
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

		if (!(obj instanceof FeeDetailsClp)) {
			return false;
		}

		FeeDetailsClp feeDetails = (FeeDetailsClp)obj;

		long primaryKey = feeDetails.getPrimaryKey();

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

		sb.append("{spFeeDetailsId=");
		sb.append(getSpFeeDetailsId());
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
		sb.append(", feeType=");
		sb.append(getFeeType());
		sb.append(", feeDesc=");
		sb.append(getFeeDesc());
		sb.append(", calculationBase=");
		sb.append(getCalculationBase());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", displayOrder=");
		sb.append(getDisplayOrder());
		sb.append(", fundId=");
		sb.append(getFundId());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.FeeDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spFeeDetailsId</column-name><column-value><![CDATA[");
		sb.append(getSpFeeDetailsId());
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
			"<column><column-name>feeType</column-name><column-value><![CDATA[");
		sb.append(getFeeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feeDesc</column-name><column-value><![CDATA[");
		sb.append(getFeeDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>calculationBase</column-name><column-value><![CDATA[");
		sb.append(getCalculationBase());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrder</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundId</column-name><column-value><![CDATA[");
		sb.append(getFundId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spFeeDetailsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _feeType;
	private String _feeDesc;
	private String _calculationBase;
	private String _amount;
	private long _displayOrder;
	private long _fundId;
	private long _spCourseId;
	private BaseModel<?> _feeDetailsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}