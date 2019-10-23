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
import com.sambaash.platform.srv.service.ProductSupervisorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ProductSupervisorClp extends BaseModelImpl<ProductSupervisor>
	implements ProductSupervisor {
	public ProductSupervisorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ProductSupervisor.class;
	}

	@Override
	public String getModelClassName() {
		return ProductSupervisor.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spProductSupervisorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpProductSupervisorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spProductSupervisorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spProductSupervisorId", getSpProductSupervisorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryName", getCountryName());
		attributes.put("countryId", getCountryId());
		attributes.put("productId", getProductId());
		attributes.put("supervisorId", getSupervisorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spProductSupervisorId = (Long)attributes.get(
				"spProductSupervisorId");

		if (spProductSupervisorId != null) {
			setSpProductSupervisorId(spProductSupervisorId);
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

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long supervisorId = (Long)attributes.get("supervisorId");

		if (supervisorId != null) {
			setSupervisorId(supervisorId);
		}
	}

	@Override
	public long getSpProductSupervisorId() {
		return _spProductSupervisorId;
	}

	@Override
	public void setSpProductSupervisorId(long spProductSupervisorId) {
		_spProductSupervisorId = spProductSupervisorId;

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setSpProductSupervisorId",
						long.class);

				method.invoke(_productSupervisorRemoteModel,
					spProductSupervisorId);
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

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_productSupervisorRemoteModel, groupId);
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

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_productSupervisorRemoteModel, companyId);
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

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_productSupervisorRemoteModel, userId);
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

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_productSupervisorRemoteModel, userName);
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

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_productSupervisorRemoteModel, createDate);
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

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_productSupervisorRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryName() {
		return _countryName;
	}

	@Override
	public void setCountryName(String countryName) {
		_countryName = countryName;

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryName", String.class);

				method.invoke(_productSupervisorRemoteModel, countryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_productSupervisorRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		_productId = productId;

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setProductId", long.class);

				method.invoke(_productSupervisorRemoteModel, productId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSupervisorId() {
		return _supervisorId;
	}

	@Override
	public void setSupervisorId(long supervisorId) {
		_supervisorId = supervisorId;

		if (_productSupervisorRemoteModel != null) {
			try {
				Class<?> clazz = _productSupervisorRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisorId", long.class);

				method.invoke(_productSupervisorRemoteModel, supervisorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProductSupervisorRemoteModel() {
		return _productSupervisorRemoteModel;
	}

	public void setProductSupervisorRemoteModel(
		BaseModel<?> productSupervisorRemoteModel) {
		_productSupervisorRemoteModel = productSupervisorRemoteModel;
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

		Class<?> remoteModelClass = _productSupervisorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_productSupervisorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProductSupervisorLocalServiceUtil.addProductSupervisor(this);
		}
		else {
			ProductSupervisorLocalServiceUtil.updateProductSupervisor(this);
		}
	}

	@Override
	public ProductSupervisor toEscapedModel() {
		return (ProductSupervisor)ProxyUtil.newProxyInstance(ProductSupervisor.class.getClassLoader(),
			new Class[] { ProductSupervisor.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProductSupervisorClp clone = new ProductSupervisorClp();

		clone.setSpProductSupervisorId(getSpProductSupervisorId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryName(getCountryName());
		clone.setCountryId(getCountryId());
		clone.setProductId(getProductId());
		clone.setSupervisorId(getSupervisorId());

		return clone;
	}

	@Override
	public int compareTo(ProductSupervisor productSupervisor) {
		long primaryKey = productSupervisor.getPrimaryKey();

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

		if (!(obj instanceof ProductSupervisorClp)) {
			return false;
		}

		ProductSupervisorClp productSupervisor = (ProductSupervisorClp)obj;

		long primaryKey = productSupervisor.getPrimaryKey();

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

		sb.append("{spProductSupervisorId=");
		sb.append(getSpProductSupervisorId());
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
		sb.append(", countryName=");
		sb.append(getCountryName());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", supervisorId=");
		sb.append(getSupervisorId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.ProductSupervisor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spProductSupervisorId</column-name><column-value><![CDATA[");
		sb.append(getSpProductSupervisorId());
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
			"<column><column-name>countryName</column-name><column-value><![CDATA[");
		sb.append(getCountryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supervisorId</column-name><column-value><![CDATA[");
		sb.append(getSupervisorId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spProductSupervisorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _countryName;
	private long _countryId;
	private long _productId;
	private long _supervisorId;
	private BaseModel<?> _productSupervisorRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}