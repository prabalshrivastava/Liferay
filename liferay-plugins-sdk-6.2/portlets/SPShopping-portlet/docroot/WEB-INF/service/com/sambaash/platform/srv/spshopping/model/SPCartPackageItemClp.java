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
import com.sambaash.platform.srv.spshopping.service.SPCartPackageItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPCartPackageItemClp extends BaseModelImpl<SPCartPackageItem>
	implements SPCartPackageItem {
	public SPCartPackageItemClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPCartPackageItem.class;
	}

	@Override
	public String getModelClassName() {
		return SPCartPackageItem.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCartPackageItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCartPackageItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCartPackageItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCartPackageItemId", getSpCartPackageItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("spCartPackageId", getSpCartPackageId());
		attributes.put("title", getTitle());
		attributes.put("itemCode", getItemCode());
		attributes.put("quantity", getQuantity());
		attributes.put("entityClassPk", getEntityClassPk());
		attributes.put("entityClassName", getEntityClassName());
		attributes.put("totalPrice", getTotalPrice());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCartPackageItemId = (Long)attributes.get("spCartPackageItemId");

		if (spCartPackageItemId != null) {
			setSpCartPackageItemId(spCartPackageItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long spCartPackageId = (Long)attributes.get("spCartPackageId");

		if (spCartPackageId != null) {
			setSpCartPackageId(spCartPackageId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String itemCode = (String)attributes.get("itemCode");

		if (itemCode != null) {
			setItemCode(itemCode);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Long entityClassPk = (Long)attributes.get("entityClassPk");

		if (entityClassPk != null) {
			setEntityClassPk(entityClassPk);
		}

		String entityClassName = (String)attributes.get("entityClassName");

		if (entityClassName != null) {
			setEntityClassName(entityClassName);
		}

		String totalPrice = (String)attributes.get("totalPrice");

		if (totalPrice != null) {
			setTotalPrice(totalPrice);
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
	public long getSpCartPackageItemId() {
		return _spCartPackageItemId;
	}

	@Override
	public void setSpCartPackageItemId(long spCartPackageItemId) {
		_spCartPackageItemId = spCartPackageItemId;

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCartPackageItemId",
						long.class);

				method.invoke(_spCartPackageItemRemoteModel, spCartPackageItemId);
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

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spCartPackageItemRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCartPackageId() {
		return _spCartPackageId;
	}

	@Override
	public void setSpCartPackageId(long spCartPackageId) {
		_spCartPackageId = spCartPackageId;

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCartPackageId", long.class);

				method.invoke(_spCartPackageItemRemoteModel, spCartPackageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_spCartPackageItemRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemCode() {
		return _itemCode;
	}

	@Override
	public void setItemCode(String itemCode) {
		_itemCode = itemCode;

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCode", String.class);

				method.invoke(_spCartPackageItemRemoteModel, itemCode);
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

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", int.class);

				method.invoke(_spCartPackageItemRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityClassPk() {
		return _entityClassPk;
	}

	@Override
	public void setEntityClassPk(long entityClassPk) {
		_entityClassPk = entityClassPk;

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassPk", long.class);

				method.invoke(_spCartPackageItemRemoteModel, entityClassPk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntityClassName() {
		return _entityClassName;
	}

	@Override
	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassName",
						String.class);

				method.invoke(_spCartPackageItemRemoteModel, entityClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTotalPrice() {
		return _totalPrice;
	}

	@Override
	public void setTotalPrice(String totalPrice) {
		_totalPrice = totalPrice;

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalPrice", String.class);

				method.invoke(_spCartPackageItemRemoteModel, totalPrice);
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

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spCartPackageItemRemoteModel, companyId);
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

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spCartPackageItemRemoteModel, userId);
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

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spCartPackageItemRemoteModel, userName);
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

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spCartPackageItemRemoteModel, createDate);
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

		if (_spCartPackageItemRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spCartPackageItemRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.math.BigDecimal getTotalPriceAmount() {
		try {
			String methodName = "getTotalPriceAmount";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.math.BigDecimal returnObj = (java.math.BigDecimal)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setTotalPriceAmount(java.math.BigDecimal totalPrice) {
		try {
			String methodName = "setTotalPriceAmount";

			Class<?>[] parameterTypes = new Class<?>[] {
					java.math.BigDecimal.class
				};

			Object[] parameterValues = new Object[] { totalPrice };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSPCartPackageItemRemoteModel() {
		return _spCartPackageItemRemoteModel;
	}

	public void setSPCartPackageItemRemoteModel(
		BaseModel<?> spCartPackageItemRemoteModel) {
		_spCartPackageItemRemoteModel = spCartPackageItemRemoteModel;
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

		Class<?> remoteModelClass = _spCartPackageItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spCartPackageItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPCartPackageItemLocalServiceUtil.addSPCartPackageItem(this);
		}
		else {
			SPCartPackageItemLocalServiceUtil.updateSPCartPackageItem(this);
		}
	}

	@Override
	public SPCartPackageItem toEscapedModel() {
		return (SPCartPackageItem)ProxyUtil.newProxyInstance(SPCartPackageItem.class.getClassLoader(),
			new Class[] { SPCartPackageItem.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPCartPackageItemClp clone = new SPCartPackageItemClp();

		clone.setSpCartPackageItemId(getSpCartPackageItemId());
		clone.setGroupId(getGroupId());
		clone.setSpCartPackageId(getSpCartPackageId());
		clone.setTitle(getTitle());
		clone.setItemCode(getItemCode());
		clone.setQuantity(getQuantity());
		clone.setEntityClassPk(getEntityClassPk());
		clone.setEntityClassName(getEntityClassName());
		clone.setTotalPrice(getTotalPrice());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPCartPackageItem spCartPackageItem) {
		long primaryKey = spCartPackageItem.getPrimaryKey();

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

		if (!(obj instanceof SPCartPackageItemClp)) {
			return false;
		}

		SPCartPackageItemClp spCartPackageItem = (SPCartPackageItemClp)obj;

		long primaryKey = spCartPackageItem.getPrimaryKey();

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

		sb.append("{spCartPackageItemId=");
		sb.append(getSpCartPackageItemId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", spCartPackageId=");
		sb.append(getSpCartPackageId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", itemCode=");
		sb.append(getItemCode());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", entityClassPk=");
		sb.append(getEntityClassPk());
		sb.append(", entityClassName=");
		sb.append(getEntityClassName());
		sb.append(", totalPrice=");
		sb.append(getTotalPrice());
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
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spshopping.model.SPCartPackageItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCartPackageItemId</column-name><column-value><![CDATA[");
		sb.append(getSpCartPackageItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCartPackageId</column-name><column-value><![CDATA[");
		sb.append(getSpCartPackageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCode</column-name><column-value><![CDATA[");
		sb.append(getItemCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassPk</column-name><column-value><![CDATA[");
		sb.append(getEntityClassPk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassName</column-name><column-value><![CDATA[");
		sb.append(getEntityClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalPrice</column-name><column-value><![CDATA[");
		sb.append(getTotalPrice());
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

	private long _spCartPackageItemId;
	private long _groupId;
	private long _spCartPackageId;
	private String _title;
	private String _itemCode;
	private int _quantity;
	private long _entityClassPk;
	private String _entityClassName;
	private String _totalPrice;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spCartPackageItemRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spshopping.service.ClpSerializer.class;
}