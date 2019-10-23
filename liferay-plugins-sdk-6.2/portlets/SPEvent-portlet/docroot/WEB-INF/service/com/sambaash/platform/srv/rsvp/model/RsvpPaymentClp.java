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
import com.sambaash.platform.srv.rsvp.service.RsvpPaymentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class RsvpPaymentClp extends BaseModelImpl<RsvpPayment>
	implements RsvpPayment {
	public RsvpPaymentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpPayment.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpPayment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _rsvpPaymentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRsvpPaymentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rsvpPaymentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpPaymentId", getRsvpPaymentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpDetailId", getRsvpDetailId());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("rsvpTicketId", getRsvpTicketId());
		attributes.put("rsvpDiscountId", getRsvpDiscountId());
		attributes.put("rsvpPromoCodeId", getRsvpPromoCodeId());
		attributes.put("price", getPrice());
		attributes.put("numberOfPeople", getNumberOfPeople());
		attributes.put("discount", getDiscount());
		attributes.put("netTotal", getNetTotal());
		attributes.put("ticketNumber", getTicketNumber());
		attributes.put("payerEmailAddress", getPayerEmailAddress());
		attributes.put("receiverEmailAddress", getReceiverEmailAddress());
		attributes.put("transactionId", getTransactionId());
		attributes.put("transactionStatus", getTransactionStatus());
		attributes.put("transactionAmount", getTransactionAmount());
		attributes.put("transactionDate", getTransactionDate());
		attributes.put("emailStatus", getEmailStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpPaymentId = (Long)attributes.get("rsvpPaymentId");

		if (rsvpPaymentId != null) {
			setRsvpPaymentId(rsvpPaymentId);
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

		Long rsvpDetailId = (Long)attributes.get("rsvpDetailId");

		if (rsvpDetailId != null) {
			setRsvpDetailId(rsvpDetailId);
		}

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
		}

		Long rsvpTicketId = (Long)attributes.get("rsvpTicketId");

		if (rsvpTicketId != null) {
			setRsvpTicketId(rsvpTicketId);
		}

		Long rsvpDiscountId = (Long)attributes.get("rsvpDiscountId");

		if (rsvpDiscountId != null) {
			setRsvpDiscountId(rsvpDiscountId);
		}

		Long rsvpPromoCodeId = (Long)attributes.get("rsvpPromoCodeId");

		if (rsvpPromoCodeId != null) {
			setRsvpPromoCodeId(rsvpPromoCodeId);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer numberOfPeople = (Integer)attributes.get("numberOfPeople");

		if (numberOfPeople != null) {
			setNumberOfPeople(numberOfPeople);
		}

		Integer discount = (Integer)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Double netTotal = (Double)attributes.get("netTotal");

		if (netTotal != null) {
			setNetTotal(netTotal);
		}

		String ticketNumber = (String)attributes.get("ticketNumber");

		if (ticketNumber != null) {
			setTicketNumber(ticketNumber);
		}

		String payerEmailAddress = (String)attributes.get("payerEmailAddress");

		if (payerEmailAddress != null) {
			setPayerEmailAddress(payerEmailAddress);
		}

		String receiverEmailAddress = (String)attributes.get(
				"receiverEmailAddress");

		if (receiverEmailAddress != null) {
			setReceiverEmailAddress(receiverEmailAddress);
		}

		String transactionId = (String)attributes.get("transactionId");

		if (transactionId != null) {
			setTransactionId(transactionId);
		}

		String transactionStatus = (String)attributes.get("transactionStatus");

		if (transactionStatus != null) {
			setTransactionStatus(transactionStatus);
		}

		Double transactionAmount = (Double)attributes.get("transactionAmount");

		if (transactionAmount != null) {
			setTransactionAmount(transactionAmount);
		}

		Date transactionDate = (Date)attributes.get("transactionDate");

		if (transactionDate != null) {
			setTransactionDate(transactionDate);
		}

		Boolean emailStatus = (Boolean)attributes.get("emailStatus");

		if (emailStatus != null) {
			setEmailStatus(emailStatus);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_rsvpPaymentRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpPaymentId() {
		return _rsvpPaymentId;
	}

	@Override
	public void setRsvpPaymentId(long rsvpPaymentId) {
		_rsvpPaymentId = rsvpPaymentId;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpPaymentId", long.class);

				method.invoke(_rsvpPaymentRemoteModel, rsvpPaymentId);
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

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_rsvpPaymentRemoteModel, groupId);
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

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_rsvpPaymentRemoteModel, companyId);
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

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rsvpPaymentRemoteModel, userId);
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

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_rsvpPaymentRemoteModel, userName);
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

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_rsvpPaymentRemoteModel, createDate);
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

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_rsvpPaymentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpDetailId() {
		return _rsvpDetailId;
	}

	@Override
	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpDetailId = rsvpDetailId;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpDetailId", long.class);

				method.invoke(_rsvpPaymentRemoteModel, rsvpDetailId);
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

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpId", long.class);

				method.invoke(_rsvpPaymentRemoteModel, rsvpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpTicketId() {
		return _rsvpTicketId;
	}

	@Override
	public void setRsvpTicketId(long rsvpTicketId) {
		_rsvpTicketId = rsvpTicketId;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpTicketId", long.class);

				method.invoke(_rsvpPaymentRemoteModel, rsvpTicketId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpDiscountId() {
		return _rsvpDiscountId;
	}

	@Override
	public void setRsvpDiscountId(long rsvpDiscountId) {
		_rsvpDiscountId = rsvpDiscountId;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpDiscountId", long.class);

				method.invoke(_rsvpPaymentRemoteModel, rsvpDiscountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpPromoCodeId() {
		return _rsvpPromoCodeId;
	}

	@Override
	public void setRsvpPromoCodeId(long rsvpPromoCodeId) {
		_rsvpPromoCodeId = rsvpPromoCodeId;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpPromoCodeId", long.class);

				method.invoke(_rsvpPaymentRemoteModel, rsvpPromoCodeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_rsvpPaymentRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberOfPeople() {
		return _numberOfPeople;
	}

	@Override
	public void setNumberOfPeople(int numberOfPeople) {
		_numberOfPeople = numberOfPeople;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfPeople", int.class);

				method.invoke(_rsvpPaymentRemoteModel, numberOfPeople);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDiscount() {
		return _discount;
	}

	@Override
	public void setDiscount(int discount) {
		_discount = discount;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", int.class);

				method.invoke(_rsvpPaymentRemoteModel, discount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getNetTotal() {
		return _netTotal;
	}

	@Override
	public void setNetTotal(double netTotal) {
		_netTotal = netTotal;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setNetTotal", double.class);

				method.invoke(_rsvpPaymentRemoteModel, netTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTicketNumber() {
		return _ticketNumber;
	}

	@Override
	public void setTicketNumber(String ticketNumber) {
		_ticketNumber = ticketNumber;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNumber", String.class);

				method.invoke(_rsvpPaymentRemoteModel, ticketNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPayerEmailAddress() {
		return _payerEmailAddress;
	}

	@Override
	public void setPayerEmailAddress(String payerEmailAddress) {
		_payerEmailAddress = payerEmailAddress;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setPayerEmailAddress",
						String.class);

				method.invoke(_rsvpPaymentRemoteModel, payerEmailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceiverEmailAddress() {
		return _receiverEmailAddress;
	}

	@Override
	public void setReceiverEmailAddress(String receiverEmailAddress) {
		_receiverEmailAddress = receiverEmailAddress;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setReceiverEmailAddress",
						String.class);

				method.invoke(_rsvpPaymentRemoteModel, receiverEmailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTransactionId() {
		return _transactionId;
	}

	@Override
	public void setTransactionId(String transactionId) {
		_transactionId = transactionId;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setTransactionId", String.class);

				method.invoke(_rsvpPaymentRemoteModel, transactionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTransactionStatus() {
		return _transactionStatus;
	}

	@Override
	public void setTransactionStatus(String transactionStatus) {
		_transactionStatus = transactionStatus;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setTransactionStatus",
						String.class);

				method.invoke(_rsvpPaymentRemoteModel, transactionStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTransactionAmount() {
		return _transactionAmount;
	}

	@Override
	public void setTransactionAmount(double transactionAmount) {
		_transactionAmount = transactionAmount;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setTransactionAmount",
						double.class);

				method.invoke(_rsvpPaymentRemoteModel, transactionAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTransactionDate() {
		return _transactionDate;
	}

	@Override
	public void setTransactionDate(Date transactionDate) {
		_transactionDate = transactionDate;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setTransactionDate", Date.class);

				method.invoke(_rsvpPaymentRemoteModel, transactionDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEmailStatus() {
		return _emailStatus;
	}

	@Override
	public boolean isEmailStatus() {
		return _emailStatus;
	}

	@Override
	public void setEmailStatus(boolean emailStatus) {
		_emailStatus = emailStatus;

		if (_rsvpPaymentRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpPaymentRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailStatus", boolean.class);

				method.invoke(_rsvpPaymentRemoteModel, emailStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RsvpPayment.class.getName()));
	}

	public BaseModel<?> getRsvpPaymentRemoteModel() {
		return _rsvpPaymentRemoteModel;
	}

	public void setRsvpPaymentRemoteModel(BaseModel<?> rsvpPaymentRemoteModel) {
		_rsvpPaymentRemoteModel = rsvpPaymentRemoteModel;
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

		Class<?> remoteModelClass = _rsvpPaymentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rsvpPaymentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RsvpPaymentLocalServiceUtil.addRsvpPayment(this);
		}
		else {
			RsvpPaymentLocalServiceUtil.updateRsvpPayment(this);
		}
	}

	@Override
	public RsvpPayment toEscapedModel() {
		return (RsvpPayment)ProxyUtil.newProxyInstance(RsvpPayment.class.getClassLoader(),
			new Class[] { RsvpPayment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RsvpPaymentClp clone = new RsvpPaymentClp();

		clone.setUuid(getUuid());
		clone.setRsvpPaymentId(getRsvpPaymentId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRsvpDetailId(getRsvpDetailId());
		clone.setRsvpId(getRsvpId());
		clone.setRsvpTicketId(getRsvpTicketId());
		clone.setRsvpDiscountId(getRsvpDiscountId());
		clone.setRsvpPromoCodeId(getRsvpPromoCodeId());
		clone.setPrice(getPrice());
		clone.setNumberOfPeople(getNumberOfPeople());
		clone.setDiscount(getDiscount());
		clone.setNetTotal(getNetTotal());
		clone.setTicketNumber(getTicketNumber());
		clone.setPayerEmailAddress(getPayerEmailAddress());
		clone.setReceiverEmailAddress(getReceiverEmailAddress());
		clone.setTransactionId(getTransactionId());
		clone.setTransactionStatus(getTransactionStatus());
		clone.setTransactionAmount(getTransactionAmount());
		clone.setTransactionDate(getTransactionDate());
		clone.setEmailStatus(getEmailStatus());

		return clone;
	}

	@Override
	public int compareTo(RsvpPayment rsvpPayment) {
		long primaryKey = rsvpPayment.getPrimaryKey();

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

		if (!(obj instanceof RsvpPaymentClp)) {
			return false;
		}

		RsvpPaymentClp rsvpPayment = (RsvpPaymentClp)obj;

		long primaryKey = rsvpPayment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", rsvpPaymentId=");
		sb.append(getRsvpPaymentId());
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
		sb.append(", rsvpDetailId=");
		sb.append(getRsvpDetailId());
		sb.append(", rsvpId=");
		sb.append(getRsvpId());
		sb.append(", rsvpTicketId=");
		sb.append(getRsvpTicketId());
		sb.append(", rsvpDiscountId=");
		sb.append(getRsvpDiscountId());
		sb.append(", rsvpPromoCodeId=");
		sb.append(getRsvpPromoCodeId());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", numberOfPeople=");
		sb.append(getNumberOfPeople());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", netTotal=");
		sb.append(getNetTotal());
		sb.append(", ticketNumber=");
		sb.append(getTicketNumber());
		sb.append(", payerEmailAddress=");
		sb.append(getPayerEmailAddress());
		sb.append(", receiverEmailAddress=");
		sb.append(getReceiverEmailAddress());
		sb.append(", transactionId=");
		sb.append(getTransactionId());
		sb.append(", transactionStatus=");
		sb.append(getTransactionStatus());
		sb.append(", transactionAmount=");
		sb.append(getTransactionAmount());
		sb.append(", transactionDate=");
		sb.append(getTransactionDate());
		sb.append(", emailStatus=");
		sb.append(getEmailStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.rsvp.model.RsvpPayment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpPaymentId</column-name><column-value><![CDATA[");
		sb.append(getRsvpPaymentId());
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
			"<column><column-name>rsvpDetailId</column-name><column-value><![CDATA[");
		sb.append(getRsvpDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpId</column-name><column-value><![CDATA[");
		sb.append(getRsvpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpTicketId</column-name><column-value><![CDATA[");
		sb.append(getRsvpTicketId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpDiscountId</column-name><column-value><![CDATA[");
		sb.append(getRsvpDiscountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpPromoCodeId</column-name><column-value><![CDATA[");
		sb.append(getRsvpPromoCodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfPeople</column-name><column-value><![CDATA[");
		sb.append(getNumberOfPeople());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>netTotal</column-name><column-value><![CDATA[");
		sb.append(getNetTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNumber</column-name><column-value><![CDATA[");
		sb.append(getTicketNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payerEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getPayerEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiverEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getReceiverEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactionId</column-name><column-value><![CDATA[");
		sb.append(getTransactionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactionStatus</column-name><column-value><![CDATA[");
		sb.append(getTransactionStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactionAmount</column-name><column-value><![CDATA[");
		sb.append(getTransactionAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactionDate</column-name><column-value><![CDATA[");
		sb.append(getTransactionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailStatus</column-name><column-value><![CDATA[");
		sb.append(getEmailStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _rsvpPaymentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rsvpDetailId;
	private long _rsvpId;
	private long _rsvpTicketId;
	private long _rsvpDiscountId;
	private long _rsvpPromoCodeId;
	private double _price;
	private int _numberOfPeople;
	private int _discount;
	private double _netTotal;
	private String _ticketNumber;
	private String _payerEmailAddress;
	private String _receiverEmailAddress;
	private String _transactionId;
	private String _transactionStatus;
	private double _transactionAmount;
	private Date _transactionDate;
	private boolean _emailStatus;
	private BaseModel<?> _rsvpPaymentRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.rsvp.service.ClpSerializer.class;
}