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
import com.sambaash.platform.srv.spshopping.service.SPDiscountLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPDiscountClp extends BaseModelImpl<SPDiscount>
	implements SPDiscount {
	public SPDiscountClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPDiscount.class;
	}

	@Override
	public String getModelClassName() {
		return SPDiscount.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spDiscountId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpDiscountId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spDiscountId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spDiscountId", getSpDiscountId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("percent", getPercent());
		attributes.put("packageId", getPackageId());
		attributes.put("value", getValue());
		attributes.put("couponCode", getCouponCode());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("minQuantity", getMinQuantity());
		attributes.put("maxQuantity", getMaxQuantity());
		attributes.put("active", getActive());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spDiscountId = (Long)attributes.get("spDiscountId");

		if (spDiscountId != null) {
			setSpDiscountId(spDiscountId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Boolean percent = (Boolean)attributes.get("percent");

		if (percent != null) {
			setPercent(percent);
		}

		Long packageId = (Long)attributes.get("packageId");

		if (packageId != null) {
			setPackageId(packageId);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String couponCode = (String)attributes.get("couponCode");

		if (couponCode != null) {
			setCouponCode(couponCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer minQuantity = (Integer)attributes.get("minQuantity");

		if (minQuantity != null) {
			setMinQuantity(minQuantity);
		}

		Integer maxQuantity = (Integer)attributes.get("maxQuantity");

		if (maxQuantity != null) {
			setMaxQuantity(maxQuantity);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
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
	public long getSpDiscountId() {
		return _spDiscountId;
	}

	@Override
	public void setSpDiscountId(long spDiscountId) {
		_spDiscountId = spDiscountId;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setSpDiscountId", long.class);

				method.invoke(_spDiscountRemoteModel, spDiscountId);
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

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spDiscountRemoteModel, groupId);
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

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_spDiscountRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPercent() {
		return _percent;
	}

	@Override
	public boolean isPercent() {
		return _percent;
	}

	@Override
	public void setPercent(boolean percent) {
		_percent = percent;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setPercent", boolean.class);

				method.invoke(_spDiscountRemoteModel, percent);
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

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setPackageId", long.class);

				method.invoke(_spDiscountRemoteModel, packageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValue() {
		return _value;
	}

	@Override
	public void setValue(String value) {
		_value = value;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", String.class);

				method.invoke(_spDiscountRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCouponCode() {
		return _couponCode;
	}

	@Override
	public void setCouponCode(String couponCode) {
		_couponCode = couponCode;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setCouponCode", String.class);

				method.invoke(_spDiscountRemoteModel, couponCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_spDiscountRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_spDiscountRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_spDiscountRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMinQuantity() {
		return _minQuantity;
	}

	@Override
	public void setMinQuantity(int minQuantity) {
		_minQuantity = minQuantity;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setMinQuantity", int.class);

				method.invoke(_spDiscountRemoteModel, minQuantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMaxQuantity() {
		return _maxQuantity;
	}

	@Override
	public void setMaxQuantity(int maxQuantity) {
		_maxQuantity = maxQuantity;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxQuantity", int.class);

				method.invoke(_spDiscountRemoteModel, maxQuantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_spDiscountRemoteModel, active);
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

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spDiscountRemoteModel, companyId);
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

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spDiscountRemoteModel, userId);
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

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spDiscountRemoteModel, userName);
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

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spDiscountRemoteModel, createDate);
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

		if (_spDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _spDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spDiscountRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setValue(java.math.BigDecimal valueAmount) {
		try {
			String methodName = "setValue";

			Class<?>[] parameterTypes = new Class<?>[] {
					java.math.BigDecimal.class
				};

			Object[] parameterValues = new Object[] { valueAmount };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.math.BigDecimal getValueAmount() {
		try {
			String methodName = "getValueAmount";

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

	public BaseModel<?> getSPDiscountRemoteModel() {
		return _spDiscountRemoteModel;
	}

	public void setSPDiscountRemoteModel(BaseModel<?> spDiscountRemoteModel) {
		_spDiscountRemoteModel = spDiscountRemoteModel;
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

		Class<?> remoteModelClass = _spDiscountRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spDiscountRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPDiscountLocalServiceUtil.addSPDiscount(this);
		}
		else {
			SPDiscountLocalServiceUtil.updateSPDiscount(this);
		}
	}

	@Override
	public SPDiscount toEscapedModel() {
		return (SPDiscount)ProxyUtil.newProxyInstance(SPDiscount.class.getClassLoader(),
			new Class[] { SPDiscount.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPDiscountClp clone = new SPDiscountClp();

		clone.setSpDiscountId(getSpDiscountId());
		clone.setGroupId(getGroupId());
		clone.setTitle(getTitle());
		clone.setPercent(getPercent());
		clone.setPackageId(getPackageId());
		clone.setValue(getValue());
		clone.setCouponCode(getCouponCode());
		clone.setDescription(getDescription());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setMinQuantity(getMinQuantity());
		clone.setMaxQuantity(getMaxQuantity());
		clone.setActive(getActive());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPDiscount spDiscount) {
		long primaryKey = spDiscount.getPrimaryKey();

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

		if (!(obj instanceof SPDiscountClp)) {
			return false;
		}

		SPDiscountClp spDiscount = (SPDiscountClp)obj;

		long primaryKey = spDiscount.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{spDiscountId=");
		sb.append(getSpDiscountId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", percent=");
		sb.append(getPercent());
		sb.append(", packageId=");
		sb.append(getPackageId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", couponCode=");
		sb.append(getCouponCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", minQuantity=");
		sb.append(getMinQuantity());
		sb.append(", maxQuantity=");
		sb.append(getMaxQuantity());
		sb.append(", active=");
		sb.append(getActive());
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
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spshopping.model.SPDiscount");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spDiscountId</column-name><column-value><![CDATA[");
		sb.append(getSpDiscountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>percent</column-name><column-value><![CDATA[");
		sb.append(getPercent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>packageId</column-name><column-value><![CDATA[");
		sb.append(getPackageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>couponCode</column-name><column-value><![CDATA[");
		sb.append(getCouponCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minQuantity</column-name><column-value><![CDATA[");
		sb.append(getMinQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxQuantity</column-name><column-value><![CDATA[");
		sb.append(getMaxQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
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

	private long _spDiscountId;
	private long _groupId;
	private String _title;
	private boolean _percent;
	private long _packageId;
	private String _value;
	private String _couponCode;
	private String _description;
	private Date _startDate;
	private Date _endDate;
	private int _minQuantity;
	private int _maxQuantity;
	private boolean _active;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spDiscountRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spshopping.service.ClpSerializer.class;
}