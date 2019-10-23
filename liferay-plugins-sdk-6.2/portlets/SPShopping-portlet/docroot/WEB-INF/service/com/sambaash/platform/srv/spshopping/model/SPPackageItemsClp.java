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

package com.sambaash.platform.srv.spshopping.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spshopping.service.ClpSerializer;
import com.sambaash.platform.srv.spshopping.service.SPPackageItemsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPPackageItemsClp extends BaseModelImpl<SPPackageItems>
	implements SPPackageItems {
	public SPPackageItemsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPPackageItems.class;
	}

	@Override
	public String getModelClassName() {
		return SPPackageItems.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPackageItemsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPackageItemsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPackageItemsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPackageItemsId", getSpPackageItemsId());
		attributes.put("groupId", getGroupId());
		attributes.put("packageId", getPackageId());
		attributes.put("itemId", getItemId());
		attributes.put("quantity", getQuantity());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPackageItemsId = (Long)attributes.get("spPackageItemsId");

		if (spPackageItemsId != null) {
			setSpPackageItemsId(spPackageItemsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long packageId = (Long)attributes.get("packageId");

		if (packageId != null) {
			setPackageId(packageId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
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
	}

	@Override
	public long getSpPackageItemsId() {
		return _spPackageItemsId;
	}

	@Override
	public void setSpPackageItemsId(long spPackageItemsId) {
		_spPackageItemsId = spPackageItemsId;

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPackageItemsId",
						long.class);

				method.invoke(_spPackageItemsRemoteModel, spPackageItemsId);
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

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spPackageItemsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPackageId() {
		return _packageId;
	}

	@Override
	public void setPackageId(long packageId) {
		_packageId = packageId;

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setPackageId", long.class);

				method.invoke(_spPackageItemsRemoteModel, packageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_spPackageItemsRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", int.class);

				method.invoke(_spPackageItemsRemoteModel, quantity);
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

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spPackageItemsRemoteModel, companyId);
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

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spPackageItemsRemoteModel, userId);
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

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spPackageItemsRemoteModel, userName);
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

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spPackageItemsRemoteModel, createDate);
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

		if (_spPackageItemsRemoteModel != null) {
			try {
				Class<?> clazz = _spPackageItemsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spPackageItemsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPPackageItemsRemoteModel() {
		return _spPackageItemsRemoteModel;
	}

	public void setSPPackageItemsRemoteModel(
		BaseModel<?> spPackageItemsRemoteModel) {
		_spPackageItemsRemoteModel = spPackageItemsRemoteModel;
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

		Class<?> remoteModelClass = _spPackageItemsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spPackageItemsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPPackageItemsLocalServiceUtil.addSPPackageItems(this);
		}
		else {
			SPPackageItemsLocalServiceUtil.updateSPPackageItems(this);
		}
	}

	@Override
	public SPPackageItems toEscapedModel() {
		return (SPPackageItems)ProxyUtil.newProxyInstance(SPPackageItems.class.getClassLoader(),
			new Class[] { SPPackageItems.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPPackageItemsClp clone = new SPPackageItemsClp();

		clone.setSpPackageItemsId(getSpPackageItemsId());
		clone.setGroupId(getGroupId());
		clone.setPackageId(getPackageId());
		clone.setItemId(getItemId());
		clone.setQuantity(getQuantity());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPPackageItems spPackageItems) {
		long primaryKey = spPackageItems.getPrimaryKey();

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

		if (!(obj instanceof SPPackageItemsClp)) {
			return false;
		}

		SPPackageItemsClp spPackageItems = (SPPackageItemsClp)obj;

		long primaryKey = spPackageItems.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{spPackageItemsId=");
		sb.append(getSpPackageItemsId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", packageId=");
		sb.append(getPackageId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", quantity=");
		sb.append(getQuantity());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spshopping.model.SPPackageItems");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spPackageItemsId</column-name><column-value><![CDATA[");
		sb.append(getSpPackageItemsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>packageId</column-name><column-value><![CDATA[");
		sb.append(getPackageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _spPackageItemsId;
	private long _groupId;
	private long _packageId;
	private long _itemId;
	private int _quantity;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spPackageItemsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spshopping.service.ClpSerializer.class;
}