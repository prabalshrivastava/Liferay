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

package com.sambaash.platform.srv.rsvp.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.rsvp.service.ClpSerializer;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class RsvpClp extends BaseModelImpl<Rsvp> implements Rsvp {
	public RsvpClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Rsvp.class;
	}

	@Override
	public String getModelClassName() {
		return Rsvp.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _rsvpId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRsvpId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rsvpId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("eventId", getEventId());
		attributes.put("spAssetTypeId", getSpAssetTypeId());
		attributes.put("status", getStatus());
		attributes.put("rsvpUrl", getRsvpUrl());
		attributes.put("processing", getProcessing());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("tax", getTax());
		attributes.put("accountId", getAccountId());
		attributes.put("paymentFlag", getPaymentFlag());
		attributes.put("registerFlag", getRegisterFlag());
		attributes.put("ticketFlag", getTicketFlag());
		attributes.put("dynamicSectionName", getDynamicSectionName());
		attributes.put("ccEmail", getCcEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long spAssetTypeId = (Long)attributes.get("spAssetTypeId");

		if (spAssetTypeId != null) {
			setSpAssetTypeId(spAssetTypeId);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String rsvpUrl = (String)attributes.get("rsvpUrl");

		if (rsvpUrl != null) {
			setRsvpUrl(rsvpUrl);
		}

		Integer processing = (Integer)attributes.get("processing");

		if (processing != null) {
			setProcessing(processing);
		}

		String price = (String)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String tax = (String)attributes.get("tax");

		if (tax != null) {
			setTax(tax);
		}

		String accountId = (String)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Boolean paymentFlag = (Boolean)attributes.get("paymentFlag");

		if (paymentFlag != null) {
			setPaymentFlag(paymentFlag);
		}

		Boolean registerFlag = (Boolean)attributes.get("registerFlag");

		if (registerFlag != null) {
			setRegisterFlag(registerFlag);
		}

		Boolean ticketFlag = (Boolean)attributes.get("ticketFlag");

		if (ticketFlag != null) {
			setTicketFlag(ticketFlag);
		}

		String dynamicSectionName = (String)attributes.get("dynamicSectionName");

		if (dynamicSectionName != null) {
			setDynamicSectionName(dynamicSectionName);
		}

		Boolean ccEmail = (Boolean)attributes.get("ccEmail");

		if (ccEmail != null) {
			setCcEmail(ccEmail);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_rsvpRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpId() {
		return _rsvpId;
	}

	@Override
	public void setRsvpId(long rsvpId) {
		_rsvpId = rsvpId;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpId", long.class);

				method.invoke(_rsvpRemoteModel, rsvpId);
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

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_rsvpRemoteModel, groupId);
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

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_rsvpRemoteModel, companyId);
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

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rsvpRemoteModel, userId);
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

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_rsvpRemoteModel, userName);
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

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_rsvpRemoteModel, createDate);
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

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_rsvpRemoteModel, modifiedDate);
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

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_rsvpRemoteModel, title);
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

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_rsvpRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_rsvpRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpAssetTypeId() {
		return _spAssetTypeId;
	}

	@Override
	public void setSpAssetTypeId(long spAssetTypeId) {
		_spAssetTypeId = spAssetTypeId;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssetTypeId", long.class);

				method.invoke(_rsvpRemoteModel, spAssetTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_rsvpRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRsvpUrl() {
		return _rsvpUrl;
	}

	@Override
	public void setRsvpUrl(String rsvpUrl) {
		_rsvpUrl = rsvpUrl;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpUrl", String.class);

				method.invoke(_rsvpRemoteModel, rsvpUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getProcessing() {
		return _processing;
	}

	@Override
	public void setProcessing(int processing) {
		_processing = processing;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessing", int.class);

				method.invoke(_rsvpRemoteModel, processing);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrice() {
		return _price;
	}

	@Override
	public void setPrice(String price) {
		_price = price;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", String.class);

				method.invoke(_rsvpRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrency() {
		return _currency;
	}

	@Override
	public void setCurrency(String currency) {
		_currency = currency;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_rsvpRemoteModel, currency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTax() {
		return _tax;
	}

	@Override
	public void setTax(String tax) {
		_tax = tax;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setTax", String.class);

				method.invoke(_rsvpRemoteModel, tax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(String accountId) {
		_accountId = accountId;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountId", String.class);

				method.invoke(_rsvpRemoteModel, accountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPaymentFlag() {
		return _paymentFlag;
	}

	@Override
	public boolean isPaymentFlag() {
		return _paymentFlag;
	}

	@Override
	public void setPaymentFlag(boolean paymentFlag) {
		_paymentFlag = paymentFlag;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentFlag", boolean.class);

				method.invoke(_rsvpRemoteModel, paymentFlag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRegisterFlag() {
		return _registerFlag;
	}

	@Override
	public boolean isRegisterFlag() {
		return _registerFlag;
	}

	@Override
	public void setRegisterFlag(boolean registerFlag) {
		_registerFlag = registerFlag;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setRegisterFlag", boolean.class);

				method.invoke(_rsvpRemoteModel, registerFlag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTicketFlag() {
		return _ticketFlag;
	}

	@Override
	public boolean isTicketFlag() {
		return _ticketFlag;
	}

	@Override
	public void setTicketFlag(boolean ticketFlag) {
		_ticketFlag = ticketFlag;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketFlag", boolean.class);

				method.invoke(_rsvpRemoteModel, ticketFlag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDynamicSectionName() {
		return _dynamicSectionName;
	}

	@Override
	public void setDynamicSectionName(String dynamicSectionName) {
		_dynamicSectionName = dynamicSectionName;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setDynamicSectionName",
						String.class);

				method.invoke(_rsvpRemoteModel, dynamicSectionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCcEmail() {
		return _ccEmail;
	}

	@Override
	public boolean isCcEmail() {
		return _ccEmail;
	}

	@Override
	public void setCcEmail(boolean ccEmail) {
		_ccEmail = ccEmail;

		if (_rsvpRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpRemoteModel.getClass();

				Method method = clazz.getMethod("setCcEmail", boolean.class);

				method.invoke(_rsvpRemoteModel, ccEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Rsvp.class.getName()));
	}

	public BaseModel<?> getRsvpRemoteModel() {
		return _rsvpRemoteModel;
	}

	public void setRsvpRemoteModel(BaseModel<?> rsvpRemoteModel) {
		_rsvpRemoteModel = rsvpRemoteModel;
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

		Class<?> remoteModelClass = _rsvpRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rsvpRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RsvpLocalServiceUtil.addRsvp(this);
		}
		else {
			RsvpLocalServiceUtil.updateRsvp(this);
		}
	}

	@Override
	public Rsvp toEscapedModel() {
		return (Rsvp)ProxyUtil.newProxyInstance(Rsvp.class.getClassLoader(),
			new Class[] { Rsvp.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RsvpClp clone = new RsvpClp();

		clone.setUuid(getUuid());
		clone.setRsvpId(getRsvpId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setEventId(getEventId());
		clone.setSpAssetTypeId(getSpAssetTypeId());
		clone.setStatus(getStatus());
		clone.setRsvpUrl(getRsvpUrl());
		clone.setProcessing(getProcessing());
		clone.setPrice(getPrice());
		clone.setCurrency(getCurrency());
		clone.setTax(getTax());
		clone.setAccountId(getAccountId());
		clone.setPaymentFlag(getPaymentFlag());
		clone.setRegisterFlag(getRegisterFlag());
		clone.setTicketFlag(getTicketFlag());
		clone.setDynamicSectionName(getDynamicSectionName());
		clone.setCcEmail(getCcEmail());

		return clone;
	}

	@Override
	public int compareTo(Rsvp rsvp) {
		long primaryKey = rsvp.getPrimaryKey();

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

		if (!(obj instanceof RsvpClp)) {
			return false;
		}

		RsvpClp rsvp = (RsvpClp)obj;

		long primaryKey = rsvp.getPrimaryKey();

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
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", rsvpId=");
		sb.append(getRsvpId());
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
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", spAssetTypeId=");
		sb.append(getSpAssetTypeId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", rsvpUrl=");
		sb.append(getRsvpUrl());
		sb.append(", processing=");
		sb.append(getProcessing());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", tax=");
		sb.append(getTax());
		sb.append(", accountId=");
		sb.append(getAccountId());
		sb.append(", paymentFlag=");
		sb.append(getPaymentFlag());
		sb.append(", registerFlag=");
		sb.append(getRegisterFlag());
		sb.append(", ticketFlag=");
		sb.append(getTicketFlag());
		sb.append(", dynamicSectionName=");
		sb.append(getDynamicSectionName());
		sb.append(", ccEmail=");
		sb.append(getCcEmail());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.rsvp.model.Rsvp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpId</column-name><column-value><![CDATA[");
		sb.append(getRsvpId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAssetTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpAssetTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpUrl</column-name><column-value><![CDATA[");
		sb.append(getRsvpUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processing</column-name><column-value><![CDATA[");
		sb.append(getProcessing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tax</column-name><column-value><![CDATA[");
		sb.append(getTax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentFlag</column-name><column-value><![CDATA[");
		sb.append(getPaymentFlag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registerFlag</column-name><column-value><![CDATA[");
		sb.append(getRegisterFlag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketFlag</column-name><column-value><![CDATA[");
		sb.append(getTicketFlag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dynamicSectionName</column-name><column-value><![CDATA[");
		sb.append(getDynamicSectionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccEmail</column-name><column-value><![CDATA[");
		sb.append(getCcEmail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _rsvpId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private long _eventId;
	private long _spAssetTypeId;
	private boolean _status;
	private String _rsvpUrl;
	private int _processing;
	private String _price;
	private String _currency;
	private String _tax;
	private String _accountId;
	private boolean _paymentFlag;
	private boolean _registerFlag;
	private boolean _ticketFlag;
	private String _dynamicSectionName;
	private boolean _ccEmail;
	private BaseModel<?> _rsvpRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.rsvp.service.ClpSerializer.class;
}