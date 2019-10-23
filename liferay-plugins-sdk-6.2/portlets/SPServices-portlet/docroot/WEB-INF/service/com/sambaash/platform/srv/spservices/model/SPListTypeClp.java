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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPListTypeClp extends BaseModelImpl<SPListType>
	implements SPListType {
	public SPListTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPListType.class;
	}

	@Override
	public String getModelClassName() {
		return SPListType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spListTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpListTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spListTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spListTypeId", getSpListTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("itemKey", getItemKey());
		attributes.put("itemValue", getItemValue());
		attributes.put("displayName", getDisplayName());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("categoryId", getCategoryId());
		attributes.put("modeldata", getModeldata());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spListTypeId = (Long)attributes.get("spListTypeId");

		if (spListTypeId != null) {
			setSpListTypeId(spListTypeId);
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

		String itemKey = (String)attributes.get("itemKey");

		if (itemKey != null) {
			setItemKey(itemKey);
		}

		String itemValue = (String)attributes.get("itemValue");

		if (itemValue != null) {
			setItemValue(itemValue);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		Integer displayOrder = (Integer)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String modeldata = (String)attributes.get("modeldata");

		if (modeldata != null) {
			setModeldata(modeldata);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spListTypeRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpListTypeId() {
		return _spListTypeId;
	}

	@Override
	public void setSpListTypeId(long spListTypeId) {
		_spListTypeId = spListTypeId;

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpListTypeId", long.class);

				method.invoke(_spListTypeRemoteModel, spListTypeId);
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

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spListTypeRemoteModel, groupId);
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

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spListTypeRemoteModel, companyId);
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

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spListTypeRemoteModel, userId);
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

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spListTypeRemoteModel, userName);
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

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spListTypeRemoteModel, createDate);
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

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spListTypeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemKey() {
		return _itemKey;
	}

	@Override
	public void setItemKey(String itemKey) {
		_itemKey = itemKey;

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemKey", String.class);

				method.invoke(_spListTypeRemoteModel, itemKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemValue() {
		return _itemValue;
	}

	@Override
	public void setItemValue(String itemValue) {
		_itemValue = itemValue;

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemValue", String.class);

				method.invoke(_spListTypeRemoteModel, itemValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplayName() {
		return _displayName;
	}

	@Override
	public void setDisplayName(String displayName) {
		_displayName = displayName;

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayName", String.class);

				method.invoke(_spListTypeRemoteModel, displayName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDisplayOrder() {
		return _displayOrder;
	}

	@Override
	public void setDisplayOrder(int displayOrder) {
		_displayOrder = displayOrder;

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrder", int.class);

				method.invoke(_spListTypeRemoteModel, displayOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_spListTypeRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModeldata() {
		return _modeldata;
	}

	@Override
	public void setModeldata(String modeldata) {
		_modeldata = modeldata;

		if (_spListTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spListTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModeldata", String.class);

				method.invoke(_spListTypeRemoteModel, modeldata);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPListType.class.getName()));
	}

	public BaseModel<?> getSPListTypeRemoteModel() {
		return _spListTypeRemoteModel;
	}

	public void setSPListTypeRemoteModel(BaseModel<?> spListTypeRemoteModel) {
		_spListTypeRemoteModel = spListTypeRemoteModel;
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

		Class<?> remoteModelClass = _spListTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spListTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPListTypeLocalServiceUtil.addSPListType(this);
		}
		else {
			SPListTypeLocalServiceUtil.updateSPListType(this);
		}
	}

	@Override
	public SPListType toEscapedModel() {
		return (SPListType)ProxyUtil.newProxyInstance(SPListType.class.getClassLoader(),
			new Class[] { SPListType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPListTypeClp clone = new SPListTypeClp();

		clone.setUuid(getUuid());
		clone.setSpListTypeId(getSpListTypeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setItemKey(getItemKey());
		clone.setItemValue(getItemValue());
		clone.setDisplayName(getDisplayName());
		clone.setDisplayOrder(getDisplayOrder());
		clone.setCategoryId(getCategoryId());
		clone.setModeldata(getModeldata());

		return clone;
	}

	@Override
	public int compareTo(SPListType spListType) {
		int value = 0;

		if (getDisplayOrder() < spListType.getDisplayOrder()) {
			value = -1;
		}
		else if (getDisplayOrder() > spListType.getDisplayOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getItemValue().compareTo(spListType.getItemValue());

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

		if (!(obj instanceof SPListTypeClp)) {
			return false;
		}

		SPListTypeClp spListType = (SPListTypeClp)obj;

		long primaryKey = spListType.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spListTypeId=");
		sb.append(getSpListTypeId());
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
		sb.append(", itemKey=");
		sb.append(getItemKey());
		sb.append(", itemValue=");
		sb.append(getItemValue());
		sb.append(", displayName=");
		sb.append(getDisplayName());
		sb.append(", displayOrder=");
		sb.append(getDisplayOrder());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", modeldata=");
		sb.append(getModeldata());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPListType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spListTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpListTypeId());
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
			"<column><column-name>itemKey</column-name><column-value><![CDATA[");
		sb.append(getItemKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemValue</column-name><column-value><![CDATA[");
		sb.append(getItemValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayName</column-name><column-value><![CDATA[");
		sb.append(getDisplayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrder</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modeldata</column-name><column-value><![CDATA[");
		sb.append(getModeldata());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spListTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _itemKey;
	private String _itemValue;
	private String _displayName;
	private int _displayOrder;
	private long _categoryId;
	private String _modeldata;
	private BaseModel<?> _spListTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}