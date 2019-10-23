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
import com.sambaash.platform.srv.service.ProductCourseLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ProductCourseClp extends BaseModelImpl<ProductCourse>
	implements ProductCourse {
	public ProductCourseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ProductCourse.class;
	}

	@Override
	public String getModelClassName() {
		return ProductCourse.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spProductCourseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpProductCourseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spProductCourseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spProductCourseId", getSpProductCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spProductId", getSpProductId());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spProductCourseId = (Long)attributes.get("spProductCourseId");

		if (spProductCourseId != null) {
			setSpProductCourseId(spProductCourseId);
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

		Long spProductId = (Long)attributes.get("spProductId");

		if (spProductId != null) {
			setSpProductId(spProductId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	@Override
	public long getSpProductCourseId() {
		return _spProductCourseId;
	}

	@Override
	public void setSpProductCourseId(long spProductCourseId) {
		_spProductCourseId = spProductCourseId;

		if (_productCourseRemoteModel != null) {
			try {
				Class<?> clazz = _productCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setSpProductCourseId",
						long.class);

				method.invoke(_productCourseRemoteModel, spProductCourseId);
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

		if (_productCourseRemoteModel != null) {
			try {
				Class<?> clazz = _productCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_productCourseRemoteModel, groupId);
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

		if (_productCourseRemoteModel != null) {
			try {
				Class<?> clazz = _productCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_productCourseRemoteModel, companyId);
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

		if (_productCourseRemoteModel != null) {
			try {
				Class<?> clazz = _productCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_productCourseRemoteModel, userId);
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

		if (_productCourseRemoteModel != null) {
			try {
				Class<?> clazz = _productCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_productCourseRemoteModel, userName);
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

		if (_productCourseRemoteModel != null) {
			try {
				Class<?> clazz = _productCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_productCourseRemoteModel, createDate);
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

		if (_productCourseRemoteModel != null) {
			try {
				Class<?> clazz = _productCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_productCourseRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpProductId() {
		return _spProductId;
	}

	@Override
	public void setSpProductId(long spProductId) {
		_spProductId = spProductId;

		if (_productCourseRemoteModel != null) {
			try {
				Class<?> clazz = _productCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setSpProductId", long.class);

				method.invoke(_productCourseRemoteModel, spProductId);
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

		if (_productCourseRemoteModel != null) {
			try {
				Class<?> clazz = _productCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_productCourseRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProductCourseRemoteModel() {
		return _productCourseRemoteModel;
	}

	public void setProductCourseRemoteModel(
		BaseModel<?> productCourseRemoteModel) {
		_productCourseRemoteModel = productCourseRemoteModel;
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

		Class<?> remoteModelClass = _productCourseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_productCourseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProductCourseLocalServiceUtil.addProductCourse(this);
		}
		else {
			ProductCourseLocalServiceUtil.updateProductCourse(this);
		}
	}

	@Override
	public ProductCourse toEscapedModel() {
		return (ProductCourse)ProxyUtil.newProxyInstance(ProductCourse.class.getClassLoader(),
			new Class[] { ProductCourse.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProductCourseClp clone = new ProductCourseClp();

		clone.setSpProductCourseId(getSpProductCourseId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpProductId(getSpProductId());
		clone.setSpCourseId(getSpCourseId());

		return clone;
	}

	@Override
	public int compareTo(ProductCourse productCourse) {
		int value = 0;

		if (getSpProductId() < productCourse.getSpProductId()) {
			value = -1;
		}
		else if (getSpProductId() > productCourse.getSpProductId()) {
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

		if (!(obj instanceof ProductCourseClp)) {
			return false;
		}

		ProductCourseClp productCourse = (ProductCourseClp)obj;

		long primaryKey = productCourse.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{spProductCourseId=");
		sb.append(getSpProductCourseId());
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
		sb.append(", spProductId=");
		sb.append(getSpProductId());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.ProductCourse");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spProductCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpProductCourseId());
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
			"<column><column-name>spProductId</column-name><column-value><![CDATA[");
		sb.append(getSpProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spProductCourseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spProductId;
	private long _spCourseId;
	private BaseModel<?> _productCourseRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}