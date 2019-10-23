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

package com.sambaash.platform.srv.sprating.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.sprating.service.AttrRateLocalServiceUtil;
import com.sambaash.platform.srv.sprating.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class AttrRateClp extends BaseModelImpl<AttrRate> implements AttrRate {
	public AttrRateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AttrRate.class;
	}

	@Override
	public String getModelClassName() {
		return AttrRate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spAttrRateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpAttrRateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spAttrRateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spAttrRateId", getSpAttrRateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("objId", getObjId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("ratingAttrId", getRatingAttrId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spAttrRateId = (Long)attributes.get("spAttrRateId");

		if (spAttrRateId != null) {
			setSpAttrRateId(spAttrRateId);
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

		String objId = (String)attributes.get("objId");

		if (objId != null) {
			setObjId(objId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long ratingAttrId = (Long)attributes.get("ratingAttrId");

		if (ratingAttrId != null) {
			setRatingAttrId(ratingAttrId);
		}

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_attrRateRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpAttrRateId() {
		return _spAttrRateId;
	}

	@Override
	public void setSpAttrRateId(long spAttrRateId) {
		_spAttrRateId = spAttrRateId;

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAttrRateId", long.class);

				method.invoke(_attrRateRemoteModel, spAttrRateId);
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

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_attrRateRemoteModel, groupId);
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

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_attrRateRemoteModel, companyId);
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

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_attrRateRemoteModel, userId);
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

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_attrRateRemoteModel, userName);
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

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_attrRateRemoteModel, createDate);
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

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_attrRateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObjId() {
		return _objId;
	}

	@Override
	public void setObjId(String objId) {
		_objId = objId;

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setObjId", String.class);

				method.invoke(_attrRateRemoteModel, objId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_attrRateRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRatingAttrId() {
		return _ratingAttrId;
	}

	@Override
	public void setRatingAttrId(long ratingAttrId) {
		_ratingAttrId = ratingAttrId;

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setRatingAttrId", long.class);

				method.invoke(_attrRateRemoteModel, ratingAttrId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getValue() {
		return _value;
	}

	@Override
	public void setValue(double value) {
		_value = value;

		if (_attrRateRemoteModel != null) {
			try {
				Class<?> clazz = _attrRateRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", double.class);

				method.invoke(_attrRateRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				AttrRate.class.getName()), getClassNameId());
	}

	public BaseModel<?> getAttrRateRemoteModel() {
		return _attrRateRemoteModel;
	}

	public void setAttrRateRemoteModel(BaseModel<?> attrRateRemoteModel) {
		_attrRateRemoteModel = attrRateRemoteModel;
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

		Class<?> remoteModelClass = _attrRateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_attrRateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AttrRateLocalServiceUtil.addAttrRate(this);
		}
		else {
			AttrRateLocalServiceUtil.updateAttrRate(this);
		}
	}

	@Override
	public AttrRate toEscapedModel() {
		return (AttrRate)ProxyUtil.newProxyInstance(AttrRate.class.getClassLoader(),
			new Class[] { AttrRate.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AttrRateClp clone = new AttrRateClp();

		clone.setUuid(getUuid());
		clone.setSpAttrRateId(getSpAttrRateId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setObjId(getObjId());
		clone.setClassNameId(getClassNameId());
		clone.setRatingAttrId(getRatingAttrId());
		clone.setValue(getValue());

		return clone;
	}

	@Override
	public int compareTo(AttrRate attrRate) {
		int value = 0;

		if (getValue() < attrRate.getValue()) {
			value = -1;
		}
		else if (getValue() > attrRate.getValue()) {
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

		if (!(obj instanceof AttrRateClp)) {
			return false;
		}

		AttrRateClp attrRate = (AttrRateClp)obj;

		long primaryKey = attrRate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spAttrRateId=");
		sb.append(getSpAttrRateId());
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
		sb.append(", objId=");
		sb.append(getObjId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", ratingAttrId=");
		sb.append(getRatingAttrId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.sprating.model.AttrRate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAttrRateId</column-name><column-value><![CDATA[");
		sb.append(getSpAttrRateId());
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
			"<column><column-name>objId</column-name><column-value><![CDATA[");
		sb.append(getObjId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingAttrId</column-name><column-value><![CDATA[");
		sb.append(getRatingAttrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spAttrRateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _objId;
	private long _classNameId;
	private long _ratingAttrId;
	private double _value;
	private BaseModel<?> _attrRateRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.sprating.service.ClpSerializer.class;
}