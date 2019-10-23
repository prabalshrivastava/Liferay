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
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class FeeTypeClp extends BaseModelImpl<FeeType> implements FeeType {
	public FeeTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FeeType.class;
	}

	@Override
	public String getModelClassName() {
		return FeeType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spFeeTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpFeeTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spFeeTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFeeTypeId", getSpFeeTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("feeType", getFeeType());
		attributes.put("feeTypeName", getFeeTypeName());
		attributes.put("feeTypeDesc", getFeeTypeDesc());
		attributes.put("misc", getMisc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFeeTypeId = (Long)attributes.get("spFeeTypeId");

		if (spFeeTypeId != null) {
			setSpFeeTypeId(spFeeTypeId);
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

		String feeType = (String)attributes.get("feeType");

		if (feeType != null) {
			setFeeType(feeType);
		}

		String feeTypeName = (String)attributes.get("feeTypeName");

		if (feeTypeName != null) {
			setFeeTypeName(feeTypeName);
		}

		String feeTypeDesc = (String)attributes.get("feeTypeDesc");

		if (feeTypeDesc != null) {
			setFeeTypeDesc(feeTypeDesc);
		}

		Boolean misc = (Boolean)attributes.get("misc");

		if (misc != null) {
			setMisc(misc);
		}
	}

	@Override
	public long getSpFeeTypeId() {
		return _spFeeTypeId;
	}

	@Override
	public void setSpFeeTypeId(long spFeeTypeId) {
		_spFeeTypeId = spFeeTypeId;

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpFeeTypeId", long.class);

				method.invoke(_feeTypeRemoteModel, spFeeTypeId);
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

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_feeTypeRemoteModel, groupId);
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

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_feeTypeRemoteModel, companyId);
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

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_feeTypeRemoteModel, userId);
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

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_feeTypeRemoteModel, userName);
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

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_feeTypeRemoteModel, createDate);
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

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_feeTypeRemoteModel, modifiedDate);
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

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setFeeType", String.class);

				method.invoke(_feeTypeRemoteModel, feeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFeeTypeName() {
		return _feeTypeName;
	}

	@Override
	public void setFeeTypeName(String feeTypeName) {
		_feeTypeName = feeTypeName;

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setFeeTypeName", String.class);

				method.invoke(_feeTypeRemoteModel, feeTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFeeTypeDesc() {
		return _feeTypeDesc;
	}

	@Override
	public void setFeeTypeDesc(String feeTypeDesc) {
		_feeTypeDesc = feeTypeDesc;

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setFeeTypeDesc", String.class);

				method.invoke(_feeTypeRemoteModel, feeTypeDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMisc() {
		return _misc;
	}

	@Override
	public boolean isMisc() {
		return _misc;
	}

	@Override
	public void setMisc(boolean misc) {
		_misc = misc;

		if (_feeTypeRemoteModel != null) {
			try {
				Class<?> clazz = _feeTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMisc", boolean.class);

				method.invoke(_feeTypeRemoteModel, misc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFeeTypeRemoteModel() {
		return _feeTypeRemoteModel;
	}

	public void setFeeTypeRemoteModel(BaseModel<?> feeTypeRemoteModel) {
		_feeTypeRemoteModel = feeTypeRemoteModel;
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

		Class<?> remoteModelClass = _feeTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_feeTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FeeTypeLocalServiceUtil.addFeeType(this);
		}
		else {
			FeeTypeLocalServiceUtil.updateFeeType(this);
		}
	}

	@Override
	public FeeType toEscapedModel() {
		return (FeeType)ProxyUtil.newProxyInstance(FeeType.class.getClassLoader(),
			new Class[] { FeeType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FeeTypeClp clone = new FeeTypeClp();

		clone.setSpFeeTypeId(getSpFeeTypeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFeeType(getFeeType());
		clone.setFeeTypeName(getFeeTypeName());
		clone.setFeeTypeDesc(getFeeTypeDesc());
		clone.setMisc(getMisc());

		return clone;
	}

	@Override
	public int compareTo(FeeType feeType) {
		long primaryKey = feeType.getPrimaryKey();

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

		if (!(obj instanceof FeeTypeClp)) {
			return false;
		}

		FeeTypeClp feeType = (FeeTypeClp)obj;

		long primaryKey = feeType.getPrimaryKey();

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

		sb.append("{spFeeTypeId=");
		sb.append(getSpFeeTypeId());
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
		sb.append(", feeTypeName=");
		sb.append(getFeeTypeName());
		sb.append(", feeTypeDesc=");
		sb.append(getFeeTypeDesc());
		sb.append(", misc=");
		sb.append(getMisc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.FeeType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spFeeTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpFeeTypeId());
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
			"<column><column-name>feeTypeName</column-name><column-value><![CDATA[");
		sb.append(getFeeTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feeTypeDesc</column-name><column-value><![CDATA[");
		sb.append(getFeeTypeDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>misc</column-name><column-value><![CDATA[");
		sb.append(getMisc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spFeeTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _feeType;
	private String _feeTypeName;
	private String _feeTypeDesc;
	private boolean _misc;
	private BaseModel<?> _feeTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}