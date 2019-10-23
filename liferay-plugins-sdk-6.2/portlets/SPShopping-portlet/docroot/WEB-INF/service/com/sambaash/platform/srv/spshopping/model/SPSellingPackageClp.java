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
import com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPSellingPackageClp extends BaseModelImpl<SPSellingPackage>
	implements SPSellingPackage {
	public SPSellingPackageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPSellingPackage.class;
	}

	@Override
	public String getModelClassName() {
		return SPSellingPackage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spSellingPackageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpSellingPackageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spSellingPackageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spSellingPackageId", getSpSellingPackageId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("pkgCode", getPkgCode());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("longDescription", getLongDescription());
		attributes.put("currencyCode", getCurrencyCode());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("notify", getNotify());
		attributes.put("needsPayment", getNeedsPayment());
		attributes.put("orderPage", getOrderPage());
		attributes.put("orderSequence", getOrderSequence());
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
		Long spSellingPackageId = (Long)attributes.get("spSellingPackageId");

		if (spSellingPackageId != null) {
			setSpSellingPackageId(spSellingPackageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String pkgCode = (String)attributes.get("pkgCode");

		if (pkgCode != null) {
			setPkgCode(pkgCode);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String longDescription = (String)attributes.get("longDescription");

		if (longDescription != null) {
			setLongDescription(longDescription);
		}

		String currencyCode = (String)attributes.get("currencyCode");

		if (currencyCode != null) {
			setCurrencyCode(currencyCode);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String notify = (String)attributes.get("notify");

		if (notify != null) {
			setNotify(notify);
		}

		Boolean needsPayment = (Boolean)attributes.get("needsPayment");

		if (needsPayment != null) {
			setNeedsPayment(needsPayment);
		}

		String orderPage = (String)attributes.get("orderPage");

		if (orderPage != null) {
			setOrderPage(orderPage);
		}

		String orderSequence = (String)attributes.get("orderSequence");

		if (orderSequence != null) {
			setOrderSequence(orderSequence);
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
	public long getSpSellingPackageId() {
		return _spSellingPackageId;
	}

	@Override
	public void setSpSellingPackageId(long spSellingPackageId) {
		_spSellingPackageId = spSellingPackageId;

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setSpSellingPackageId",
						long.class);

				method.invoke(_spSellingPackageRemoteModel, spSellingPackageId);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spSellingPackageRemoteModel, groupId);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_spSellingPackageRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPkgCode() {
		return _pkgCode;
	}

	@Override
	public void setPkgCode(String pkgCode) {
		_pkgCode = pkgCode;

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setPkgCode", String.class);

				method.invoke(_spSellingPackageRemoteModel, pkgCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortDescription() {
		return _shortDescription;
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setShortDescription",
						String.class);

				method.invoke(_spSellingPackageRemoteModel, shortDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongDescription() {
		return _longDescription;
	}

	@Override
	public void setLongDescription(String longDescription) {
		_longDescription = longDescription;

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setLongDescription",
						String.class);

				method.invoke(_spSellingPackageRemoteModel, longDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrencyCode() {
		return _currencyCode;
	}

	@Override
	public void setCurrencyCode(String currencyCode) {
		_currencyCode = currencyCode;

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrencyCode", String.class);

				method.invoke(_spSellingPackageRemoteModel, currencyCode);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_spSellingPackageRemoteModel, startDate);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_spSellingPackageRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotify() {
		return _notify;
	}

	@Override
	public void setNotify(String notify) {
		_notify = notify;

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setNotify", String.class);

				method.invoke(_spSellingPackageRemoteModel, notify);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNeedsPayment() {
		return _needsPayment;
	}

	@Override
	public boolean isNeedsPayment() {
		return _needsPayment;
	}

	@Override
	public void setNeedsPayment(boolean needsPayment) {
		_needsPayment = needsPayment;

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setNeedsPayment", boolean.class);

				method.invoke(_spSellingPackageRemoteModel, needsPayment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrderPage() {
		return _orderPage;
	}

	@Override
	public void setOrderPage(String orderPage) {
		_orderPage = orderPage;

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderPage", String.class);

				method.invoke(_spSellingPackageRemoteModel, orderPage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrderSequence() {
		return _orderSequence;
	}

	@Override
	public void setOrderSequence(String orderSequence) {
		_orderSequence = orderSequence;

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderSequence", String.class);

				method.invoke(_spSellingPackageRemoteModel, orderSequence);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_spSellingPackageRemoteModel, active);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spSellingPackageRemoteModel, companyId);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spSellingPackageRemoteModel, userId);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spSellingPackageRemoteModel, userName);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spSellingPackageRemoteModel, createDate);
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

		if (_spSellingPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spSellingPackageRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPSellingPackageRemoteModel() {
		return _spSellingPackageRemoteModel;
	}

	public void setSPSellingPackageRemoteModel(
		BaseModel<?> spSellingPackageRemoteModel) {
		_spSellingPackageRemoteModel = spSellingPackageRemoteModel;
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

		Class<?> remoteModelClass = _spSellingPackageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spSellingPackageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPSellingPackageLocalServiceUtil.addSPSellingPackage(this);
		}
		else {
			SPSellingPackageLocalServiceUtil.updateSPSellingPackage(this);
		}
	}

	@Override
	public SPSellingPackage toEscapedModel() {
		return (SPSellingPackage)ProxyUtil.newProxyInstance(SPSellingPackage.class.getClassLoader(),
			new Class[] { SPSellingPackage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPSellingPackageClp clone = new SPSellingPackageClp();

		clone.setSpSellingPackageId(getSpSellingPackageId());
		clone.setGroupId(getGroupId());
		clone.setTitle(getTitle());
		clone.setPkgCode(getPkgCode());
		clone.setShortDescription(getShortDescription());
		clone.setLongDescription(getLongDescription());
		clone.setCurrencyCode(getCurrencyCode());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setNotify(getNotify());
		clone.setNeedsPayment(getNeedsPayment());
		clone.setOrderPage(getOrderPage());
		clone.setOrderSequence(getOrderSequence());
		clone.setActive(getActive());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPSellingPackage spSellingPackage) {
		long primaryKey = spSellingPackage.getPrimaryKey();

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

		if (!(obj instanceof SPSellingPackageClp)) {
			return false;
		}

		SPSellingPackageClp spSellingPackage = (SPSellingPackageClp)obj;

		long primaryKey = spSellingPackage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{spSellingPackageId=");
		sb.append(getSpSellingPackageId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", pkgCode=");
		sb.append(getPkgCode());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", longDescription=");
		sb.append(getLongDescription());
		sb.append(", currencyCode=");
		sb.append(getCurrencyCode());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", notify=");
		sb.append(getNotify());
		sb.append(", needsPayment=");
		sb.append(getNeedsPayment());
		sb.append(", orderPage=");
		sb.append(getOrderPage());
		sb.append(", orderSequence=");
		sb.append(getOrderSequence());
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
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spshopping.model.SPSellingPackage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spSellingPackageId</column-name><column-value><![CDATA[");
		sb.append(getSpSellingPackageId());
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
			"<column><column-name>pkgCode</column-name><column-value><![CDATA[");
		sb.append(getPkgCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longDescription</column-name><column-value><![CDATA[");
		sb.append(getLongDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currencyCode</column-name><column-value><![CDATA[");
		sb.append(getCurrencyCode());
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
			"<column><column-name>notify</column-name><column-value><![CDATA[");
		sb.append(getNotify());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>needsPayment</column-name><column-value><![CDATA[");
		sb.append(getNeedsPayment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderPage</column-name><column-value><![CDATA[");
		sb.append(getOrderPage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderSequence</column-name><column-value><![CDATA[");
		sb.append(getOrderSequence());
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

	private long _spSellingPackageId;
	private long _groupId;
	private String _title;
	private String _pkgCode;
	private String _shortDescription;
	private String _longDescription;
	private String _currencyCode;
	private Date _startDate;
	private Date _endDate;
	private String _notify;
	private boolean _needsPayment;
	private String _orderPage;
	private String _orderSequence;
	private boolean _active;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spSellingPackageRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spshopping.service.ClpSerializer.class;
}