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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.MembershipSubscriptionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class MembershipSubscriptionClp extends BaseModelImpl<MembershipSubscription>
	implements MembershipSubscription {
	public MembershipSubscriptionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipSubscription.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipSubscription.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _msId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _msId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("msId", getMsId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("mporder_1", getMporder_1());
		attributes.put("mpId_1", getMpId_1());
		attributes.put("mpName_1", getMpName_1());
		attributes.put("mpQty_1", getMpQty_1());
		attributes.put("mpPrice_1", getMpPrice_1());
		attributes.put("mpPriceCurrency_1", getMpPriceCurrency_1());
		attributes.put("mporder_2", getMporder_2());
		attributes.put("mpId_2", getMpId_2());
		attributes.put("mpName_2", getMpName_2());
		attributes.put("mpQty_2", getMpQty_2());
		attributes.put("mpPrice_2", getMpPrice_2());
		attributes.put("mpPriceCurrency_2", getMpPriceCurrency_2());
		attributes.put("mporder_3", getMporder_3());
		attributes.put("mpId_3", getMpId_3());
		attributes.put("mpName_3", getMpName_3());
		attributes.put("mpQty_3", getMpQty_3());
		attributes.put("mpPrice_3", getMpPrice_3());
		attributes.put("mpPriceCurrency_3", getMpPriceCurrency_3());
		attributes.put("mporder_4", getMporder_4());
		attributes.put("mpId_4", getMpId_4());
		attributes.put("mpName_4", getMpName_4());
		attributes.put("mpQty_4", getMpQty_4());
		attributes.put("mpPrice_4", getMpPrice_4());
		attributes.put("mpPriceCurrency_4", getMpPriceCurrency_4());
		attributes.put("mpSubtotal", getMpSubtotal());
		attributes.put("mpSubtotalCurrency", getMpSubtotalCurrency());
		attributes.put("addOnSubtotal", getAddOnSubtotal());
		attributes.put("addOnSubtotalCurrency", getAddOnSubtotalCurrency());
		attributes.put("tax", getTax());
		attributes.put("comments", getComments());
		attributes.put("promotionCode", getPromotionCode());
		attributes.put("promotionFrom", getPromotionFrom());
		attributes.put("promotionTo", getPromotionTo());
		attributes.put("discount", getDiscount());
		attributes.put("nettotal", getNettotal());
		attributes.put("nettotalCurrency", getNettotalCurrency());
		attributes.put("ppTxnId", getPpTxnId());
		attributes.put("ppPaymentStatus", getPpPaymentStatus());
		attributes.put("ppPaymentGross", getPpPaymentGross());
		attributes.put("ppReceiverEmail", getPpReceiverEmail());
		attributes.put("ppPayerEmail", getPpPayerEmail());
		attributes.put("sendOrderEmail", getSendOrderEmail());
		attributes.put("sendShippingEmail", getSendShippingEmail());
		attributes.put("effectiveFromDate", getEffectiveFromDate());
		attributes.put("effectiveToDate", getEffectiveToDate());
		attributes.put("altShipping", getAltShipping());
		attributes.put("shipping", getShipping());
		attributes.put("requiresShipping", getRequiresShipping());
		attributes.put("insure", getInsure());
		attributes.put("insurance", getInsurance());
		attributes.put("billingFirstName", getBillingFirstName());
		attributes.put("billingLastName", getBillingLastName());
		attributes.put("billingEmailAddress", getBillingEmailAddress());
		attributes.put("billingCompany", getBillingCompany());
		attributes.put("billingStreet", getBillingStreet());
		attributes.put("billingCity", getBillingCity());
		attributes.put("billingState", getBillingState());
		attributes.put("billingZip", getBillingZip());
		attributes.put("billingCountry", getBillingCountry());
		attributes.put("billingPhone", getBillingPhone());
		attributes.put("shipToBilling", getShipToBilling());
		attributes.put("shippingFirstName", getShippingFirstName());
		attributes.put("shippingLastName", getShippingLastName());
		attributes.put("shippingEmailAddress", getShippingEmailAddress());
		attributes.put("shippingCompany", getShippingCompany());
		attributes.put("shippingStreet", getShippingStreet());
		attributes.put("shippingCity", getShippingCity());
		attributes.put("shippingState", getShippingState());
		attributes.put("shippingZip", getShippingZip());
		attributes.put("shippingCountry", getShippingCountry());
		attributes.put("shippingPhone", getShippingPhone());
		attributes.put("ccName", getCcName());
		attributes.put("ccType", getCcType());
		attributes.put("ccNumber", getCcNumber());
		attributes.put("ccExpMonth", getCcExpMonth());
		attributes.put("ccExpYear", getCcExpYear());
		attributes.put("ccVerNumber", getCcVerNumber());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long msId = (Long)attributes.get("msId");

		if (msId != null) {
			setMsId(msId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String mporder_1 = (String)attributes.get("mporder_1");

		if (mporder_1 != null) {
			setMporder_1(mporder_1);
		}

		String mpId_1 = (String)attributes.get("mpId_1");

		if (mpId_1 != null) {
			setMpId_1(mpId_1);
		}

		String mpName_1 = (String)attributes.get("mpName_1");

		if (mpName_1 != null) {
			setMpName_1(mpName_1);
		}

		Integer mpQty_1 = (Integer)attributes.get("mpQty_1");

		if (mpQty_1 != null) {
			setMpQty_1(mpQty_1);
		}

		Float mpPrice_1 = (Float)attributes.get("mpPrice_1");

		if (mpPrice_1 != null) {
			setMpPrice_1(mpPrice_1);
		}

		String mpPriceCurrency_1 = (String)attributes.get("mpPriceCurrency_1");

		if (mpPriceCurrency_1 != null) {
			setMpPriceCurrency_1(mpPriceCurrency_1);
		}

		String mporder_2 = (String)attributes.get("mporder_2");

		if (mporder_2 != null) {
			setMporder_2(mporder_2);
		}

		String mpId_2 = (String)attributes.get("mpId_2");

		if (mpId_2 != null) {
			setMpId_2(mpId_2);
		}

		String mpName_2 = (String)attributes.get("mpName_2");

		if (mpName_2 != null) {
			setMpName_2(mpName_2);
		}

		Integer mpQty_2 = (Integer)attributes.get("mpQty_2");

		if (mpQty_2 != null) {
			setMpQty_2(mpQty_2);
		}

		Float mpPrice_2 = (Float)attributes.get("mpPrice_2");

		if (mpPrice_2 != null) {
			setMpPrice_2(mpPrice_2);
		}

		String mpPriceCurrency_2 = (String)attributes.get("mpPriceCurrency_2");

		if (mpPriceCurrency_2 != null) {
			setMpPriceCurrency_2(mpPriceCurrency_2);
		}

		String mporder_3 = (String)attributes.get("mporder_3");

		if (mporder_3 != null) {
			setMporder_3(mporder_3);
		}

		String mpId_3 = (String)attributes.get("mpId_3");

		if (mpId_3 != null) {
			setMpId_3(mpId_3);
		}

		String mpName_3 = (String)attributes.get("mpName_3");

		if (mpName_3 != null) {
			setMpName_3(mpName_3);
		}

		Integer mpQty_3 = (Integer)attributes.get("mpQty_3");

		if (mpQty_3 != null) {
			setMpQty_3(mpQty_3);
		}

		Float mpPrice_3 = (Float)attributes.get("mpPrice_3");

		if (mpPrice_3 != null) {
			setMpPrice_3(mpPrice_3);
		}

		String mpPriceCurrency_3 = (String)attributes.get("mpPriceCurrency_3");

		if (mpPriceCurrency_3 != null) {
			setMpPriceCurrency_3(mpPriceCurrency_3);
		}

		String mporder_4 = (String)attributes.get("mporder_4");

		if (mporder_4 != null) {
			setMporder_4(mporder_4);
		}

		String mpId_4 = (String)attributes.get("mpId_4");

		if (mpId_4 != null) {
			setMpId_4(mpId_4);
		}

		String mpName_4 = (String)attributes.get("mpName_4");

		if (mpName_4 != null) {
			setMpName_4(mpName_4);
		}

		Integer mpQty_4 = (Integer)attributes.get("mpQty_4");

		if (mpQty_4 != null) {
			setMpQty_4(mpQty_4);
		}

		Float mpPrice_4 = (Float)attributes.get("mpPrice_4");

		if (mpPrice_4 != null) {
			setMpPrice_4(mpPrice_4);
		}

		String mpPriceCurrency_4 = (String)attributes.get("mpPriceCurrency_4");

		if (mpPriceCurrency_4 != null) {
			setMpPriceCurrency_4(mpPriceCurrency_4);
		}

		Float mpSubtotal = (Float)attributes.get("mpSubtotal");

		if (mpSubtotal != null) {
			setMpSubtotal(mpSubtotal);
		}

		String mpSubtotalCurrency = (String)attributes.get("mpSubtotalCurrency");

		if (mpSubtotalCurrency != null) {
			setMpSubtotalCurrency(mpSubtotalCurrency);
		}

		Float addOnSubtotal = (Float)attributes.get("addOnSubtotal");

		if (addOnSubtotal != null) {
			setAddOnSubtotal(addOnSubtotal);
		}

		String addOnSubtotalCurrency = (String)attributes.get(
				"addOnSubtotalCurrency");

		if (addOnSubtotalCurrency != null) {
			setAddOnSubtotalCurrency(addOnSubtotalCurrency);
		}

		Float tax = (Float)attributes.get("tax");

		if (tax != null) {
			setTax(tax);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String promotionCode = (String)attributes.get("promotionCode");

		if (promotionCode != null) {
			setPromotionCode(promotionCode);
		}

		Date promotionFrom = (Date)attributes.get("promotionFrom");

		if (promotionFrom != null) {
			setPromotionFrom(promotionFrom);
		}

		Date promotionTo = (Date)attributes.get("promotionTo");

		if (promotionTo != null) {
			setPromotionTo(promotionTo);
		}

		String discount = (String)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Float nettotal = (Float)attributes.get("nettotal");

		if (nettotal != null) {
			setNettotal(nettotal);
		}

		String nettotalCurrency = (String)attributes.get("nettotalCurrency");

		if (nettotalCurrency != null) {
			setNettotalCurrency(nettotalCurrency);
		}

		String ppTxnId = (String)attributes.get("ppTxnId");

		if (ppTxnId != null) {
			setPpTxnId(ppTxnId);
		}

		String ppPaymentStatus = (String)attributes.get("ppPaymentStatus");

		if (ppPaymentStatus != null) {
			setPpPaymentStatus(ppPaymentStatus);
		}

		Float ppPaymentGross = (Float)attributes.get("ppPaymentGross");

		if (ppPaymentGross != null) {
			setPpPaymentGross(ppPaymentGross);
		}

		String ppReceiverEmail = (String)attributes.get("ppReceiverEmail");

		if (ppReceiverEmail != null) {
			setPpReceiverEmail(ppReceiverEmail);
		}

		String ppPayerEmail = (String)attributes.get("ppPayerEmail");

		if (ppPayerEmail != null) {
			setPpPayerEmail(ppPayerEmail);
		}

		String sendOrderEmail = (String)attributes.get("sendOrderEmail");

		if (sendOrderEmail != null) {
			setSendOrderEmail(sendOrderEmail);
		}

		String sendShippingEmail = (String)attributes.get("sendShippingEmail");

		if (sendShippingEmail != null) {
			setSendShippingEmail(sendShippingEmail);
		}

		Date effectiveFromDate = (Date)attributes.get("effectiveFromDate");

		if (effectiveFromDate != null) {
			setEffectiveFromDate(effectiveFromDate);
		}

		Date effectiveToDate = (Date)attributes.get("effectiveToDate");

		if (effectiveToDate != null) {
			setEffectiveToDate(effectiveToDate);
		}

		Integer altShipping = (Integer)attributes.get("altShipping");

		if (altShipping != null) {
			setAltShipping(altShipping);
		}

		Double shipping = (Double)attributes.get("shipping");

		if (shipping != null) {
			setShipping(shipping);
		}

		Boolean requiresShipping = (Boolean)attributes.get("requiresShipping");

		if (requiresShipping != null) {
			setRequiresShipping(requiresShipping);
		}

		Boolean insure = (Boolean)attributes.get("insure");

		if (insure != null) {
			setInsure(insure);
		}

		Double insurance = (Double)attributes.get("insurance");

		if (insurance != null) {
			setInsurance(insurance);
		}

		String billingFirstName = (String)attributes.get("billingFirstName");

		if (billingFirstName != null) {
			setBillingFirstName(billingFirstName);
		}

		String billingLastName = (String)attributes.get("billingLastName");

		if (billingLastName != null) {
			setBillingLastName(billingLastName);
		}

		String billingEmailAddress = (String)attributes.get(
				"billingEmailAddress");

		if (billingEmailAddress != null) {
			setBillingEmailAddress(billingEmailAddress);
		}

		String billingCompany = (String)attributes.get("billingCompany");

		if (billingCompany != null) {
			setBillingCompany(billingCompany);
		}

		String billingStreet = (String)attributes.get("billingStreet");

		if (billingStreet != null) {
			setBillingStreet(billingStreet);
		}

		String billingCity = (String)attributes.get("billingCity");

		if (billingCity != null) {
			setBillingCity(billingCity);
		}

		String billingState = (String)attributes.get("billingState");

		if (billingState != null) {
			setBillingState(billingState);
		}

		String billingZip = (String)attributes.get("billingZip");

		if (billingZip != null) {
			setBillingZip(billingZip);
		}

		String billingCountry = (String)attributes.get("billingCountry");

		if (billingCountry != null) {
			setBillingCountry(billingCountry);
		}

		String billingPhone = (String)attributes.get("billingPhone");

		if (billingPhone != null) {
			setBillingPhone(billingPhone);
		}

		Boolean shipToBilling = (Boolean)attributes.get("shipToBilling");

		if (shipToBilling != null) {
			setShipToBilling(shipToBilling);
		}

		String shippingFirstName = (String)attributes.get("shippingFirstName");

		if (shippingFirstName != null) {
			setShippingFirstName(shippingFirstName);
		}

		String shippingLastName = (String)attributes.get("shippingLastName");

		if (shippingLastName != null) {
			setShippingLastName(shippingLastName);
		}

		String shippingEmailAddress = (String)attributes.get(
				"shippingEmailAddress");

		if (shippingEmailAddress != null) {
			setShippingEmailAddress(shippingEmailAddress);
		}

		String shippingCompany = (String)attributes.get("shippingCompany");

		if (shippingCompany != null) {
			setShippingCompany(shippingCompany);
		}

		String shippingStreet = (String)attributes.get("shippingStreet");

		if (shippingStreet != null) {
			setShippingStreet(shippingStreet);
		}

		String shippingCity = (String)attributes.get("shippingCity");

		if (shippingCity != null) {
			setShippingCity(shippingCity);
		}

		String shippingState = (String)attributes.get("shippingState");

		if (shippingState != null) {
			setShippingState(shippingState);
		}

		String shippingZip = (String)attributes.get("shippingZip");

		if (shippingZip != null) {
			setShippingZip(shippingZip);
		}

		String shippingCountry = (String)attributes.get("shippingCountry");

		if (shippingCountry != null) {
			setShippingCountry(shippingCountry);
		}

		String shippingPhone = (String)attributes.get("shippingPhone");

		if (shippingPhone != null) {
			setShippingPhone(shippingPhone);
		}

		String ccName = (String)attributes.get("ccName");

		if (ccName != null) {
			setCcName(ccName);
		}

		String ccType = (String)attributes.get("ccType");

		if (ccType != null) {
			setCcType(ccType);
		}

		String ccNumber = (String)attributes.get("ccNumber");

		if (ccNumber != null) {
			setCcNumber(ccNumber);
		}

		Integer ccExpMonth = (Integer)attributes.get("ccExpMonth");

		if (ccExpMonth != null) {
			setCcExpMonth(ccExpMonth);
		}

		Integer ccExpYear = (Integer)attributes.get("ccExpYear");

		if (ccExpYear != null) {
			setCcExpYear(ccExpYear);
		}

		String ccVerNumber = (String)attributes.get("ccVerNumber");

		if (ccVerNumber != null) {
			setCcVerNumber(ccVerNumber);
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
	}

	@Override
	public long getMsId() {
		return _msId;
	}

	@Override
	public void setMsId(long msId) {
		_msId = msId;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMsId", long.class);

				method.invoke(_membershipSubscriptionRemoteModel, msId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, name);
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

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMporder_1() {
		return _mporder_1;
	}

	@Override
	public void setMporder_1(String mporder_1) {
		_mporder_1 = mporder_1;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMporder_1", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mporder_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpId_1() {
		return _mpId_1;
	}

	@Override
	public void setMpId_1(String mpId_1) {
		_mpId_1 = mpId_1;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpId_1", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpId_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpName_1() {
		return _mpName_1;
	}

	@Override
	public void setMpName_1(String mpName_1) {
		_mpName_1 = mpName_1;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpName_1", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpName_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMpQty_1() {
		return _mpQty_1;
	}

	@Override
	public void setMpQty_1(int mpQty_1) {
		_mpQty_1 = mpQty_1;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpQty_1", int.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpQty_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getMpPrice_1() {
		return _mpPrice_1;
	}

	@Override
	public void setMpPrice_1(float mpPrice_1) {
		_mpPrice_1 = mpPrice_1;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpPrice_1", float.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpPrice_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpPriceCurrency_1() {
		return _mpPriceCurrency_1;
	}

	@Override
	public void setMpPriceCurrency_1(String mpPriceCurrency_1) {
		_mpPriceCurrency_1 = mpPriceCurrency_1;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpPriceCurrency_1",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					mpPriceCurrency_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMporder_2() {
		return _mporder_2;
	}

	@Override
	public void setMporder_2(String mporder_2) {
		_mporder_2 = mporder_2;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMporder_2", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mporder_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpId_2() {
		return _mpId_2;
	}

	@Override
	public void setMpId_2(String mpId_2) {
		_mpId_2 = mpId_2;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpId_2", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpId_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpName_2() {
		return _mpName_2;
	}

	@Override
	public void setMpName_2(String mpName_2) {
		_mpName_2 = mpName_2;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpName_2", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpName_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMpQty_2() {
		return _mpQty_2;
	}

	@Override
	public void setMpQty_2(int mpQty_2) {
		_mpQty_2 = mpQty_2;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpQty_2", int.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpQty_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getMpPrice_2() {
		return _mpPrice_2;
	}

	@Override
	public void setMpPrice_2(float mpPrice_2) {
		_mpPrice_2 = mpPrice_2;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpPrice_2", float.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpPrice_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpPriceCurrency_2() {
		return _mpPriceCurrency_2;
	}

	@Override
	public void setMpPriceCurrency_2(String mpPriceCurrency_2) {
		_mpPriceCurrency_2 = mpPriceCurrency_2;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpPriceCurrency_2",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					mpPriceCurrency_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMporder_3() {
		return _mporder_3;
	}

	@Override
	public void setMporder_3(String mporder_3) {
		_mporder_3 = mporder_3;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMporder_3", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mporder_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpId_3() {
		return _mpId_3;
	}

	@Override
	public void setMpId_3(String mpId_3) {
		_mpId_3 = mpId_3;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpId_3", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpId_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpName_3() {
		return _mpName_3;
	}

	@Override
	public void setMpName_3(String mpName_3) {
		_mpName_3 = mpName_3;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpName_3", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpName_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMpQty_3() {
		return _mpQty_3;
	}

	@Override
	public void setMpQty_3(int mpQty_3) {
		_mpQty_3 = mpQty_3;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpQty_3", int.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpQty_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getMpPrice_3() {
		return _mpPrice_3;
	}

	@Override
	public void setMpPrice_3(float mpPrice_3) {
		_mpPrice_3 = mpPrice_3;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpPrice_3", float.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpPrice_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpPriceCurrency_3() {
		return _mpPriceCurrency_3;
	}

	@Override
	public void setMpPriceCurrency_3(String mpPriceCurrency_3) {
		_mpPriceCurrency_3 = mpPriceCurrency_3;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpPriceCurrency_3",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					mpPriceCurrency_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMporder_4() {
		return _mporder_4;
	}

	@Override
	public void setMporder_4(String mporder_4) {
		_mporder_4 = mporder_4;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMporder_4", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mporder_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpId_4() {
		return _mpId_4;
	}

	@Override
	public void setMpId_4(String mpId_4) {
		_mpId_4 = mpId_4;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpId_4", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpId_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpName_4() {
		return _mpName_4;
	}

	@Override
	public void setMpName_4(String mpName_4) {
		_mpName_4 = mpName_4;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpName_4", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpName_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMpQty_4() {
		return _mpQty_4;
	}

	@Override
	public void setMpQty_4(int mpQty_4) {
		_mpQty_4 = mpQty_4;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpQty_4", int.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpQty_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getMpPrice_4() {
		return _mpPrice_4;
	}

	@Override
	public void setMpPrice_4(float mpPrice_4) {
		_mpPrice_4 = mpPrice_4;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpPrice_4", float.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpPrice_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpPriceCurrency_4() {
		return _mpPriceCurrency_4;
	}

	@Override
	public void setMpPriceCurrency_4(String mpPriceCurrency_4) {
		_mpPriceCurrency_4 = mpPriceCurrency_4;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpPriceCurrency_4",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					mpPriceCurrency_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getMpSubtotal() {
		return _mpSubtotal;
	}

	@Override
	public void setMpSubtotal(float mpSubtotal) {
		_mpSubtotal = mpSubtotal;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpSubtotal", float.class);

				method.invoke(_membershipSubscriptionRemoteModel, mpSubtotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMpSubtotalCurrency() {
		return _mpSubtotalCurrency;
	}

	@Override
	public void setMpSubtotalCurrency(String mpSubtotalCurrency) {
		_mpSubtotalCurrency = mpSubtotalCurrency;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setMpSubtotalCurrency",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					mpSubtotalCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getAddOnSubtotal() {
		return _addOnSubtotal;
	}

	@Override
	public void setAddOnSubtotal(float addOnSubtotal) {
		_addOnSubtotal = addOnSubtotal;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setAddOnSubtotal", float.class);

				method.invoke(_membershipSubscriptionRemoteModel, addOnSubtotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddOnSubtotalCurrency() {
		return _addOnSubtotalCurrency;
	}

	@Override
	public void setAddOnSubtotalCurrency(String addOnSubtotalCurrency) {
		_addOnSubtotalCurrency = addOnSubtotalCurrency;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setAddOnSubtotalCurrency",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					addOnSubtotalCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getTax() {
		return _tax;
	}

	@Override
	public void setTax(float tax) {
		_tax = tax;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setTax", float.class);

				method.invoke(_membershipSubscriptionRemoteModel, tax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPromotionCode() {
		return _promotionCode;
	}

	@Override
	public void setPromotionCode(String promotionCode) {
		_promotionCode = promotionCode;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionCode", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, promotionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPromotionFrom() {
		return _promotionFrom;
	}

	@Override
	public void setPromotionFrom(Date promotionFrom) {
		_promotionFrom = promotionFrom;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionFrom", Date.class);

				method.invoke(_membershipSubscriptionRemoteModel, promotionFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPromotionTo() {
		return _promotionTo;
	}

	@Override
	public void setPromotionTo(Date promotionTo) {
		_promotionTo = promotionTo;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionTo", Date.class);

				method.invoke(_membershipSubscriptionRemoteModel, promotionTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiscount() {
		return _discount;
	}

	@Override
	public void setDiscount(String discount) {
		_discount = discount;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, discount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getNettotal() {
		return _nettotal;
	}

	@Override
	public void setNettotal(float nettotal) {
		_nettotal = nettotal;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setNettotal", float.class);

				method.invoke(_membershipSubscriptionRemoteModel, nettotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNettotalCurrency() {
		return _nettotalCurrency;
	}

	@Override
	public void setNettotalCurrency(String nettotalCurrency) {
		_nettotalCurrency = nettotalCurrency;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setNettotalCurrency",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					nettotalCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPpTxnId() {
		return _ppTxnId;
	}

	@Override
	public void setPpTxnId(String ppTxnId) {
		_ppTxnId = ppTxnId;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPpTxnId", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, ppTxnId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPpPaymentStatus() {
		return _ppPaymentStatus;
	}

	@Override
	public void setPpPaymentStatus(String ppPaymentStatus) {
		_ppPaymentStatus = ppPaymentStatus;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPpPaymentStatus",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					ppPaymentStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getPpPaymentGross() {
		return _ppPaymentGross;
	}

	@Override
	public void setPpPaymentGross(float ppPaymentGross) {
		_ppPaymentGross = ppPaymentGross;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPpPaymentGross", float.class);

				method.invoke(_membershipSubscriptionRemoteModel, ppPaymentGross);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPpReceiverEmail() {
		return _ppReceiverEmail;
	}

	@Override
	public void setPpReceiverEmail(String ppReceiverEmail) {
		_ppReceiverEmail = ppReceiverEmail;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPpReceiverEmail",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					ppReceiverEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPpPayerEmail() {
		return _ppPayerEmail;
	}

	@Override
	public void setPpPayerEmail(String ppPayerEmail) {
		_ppPayerEmail = ppPayerEmail;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPpPayerEmail", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, ppPayerEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSendOrderEmail() {
		return _sendOrderEmail;
	}

	@Override
	public void setSendOrderEmail(String sendOrderEmail) {
		_sendOrderEmail = sendOrderEmail;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSendOrderEmail",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel, sendOrderEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSendShippingEmail() {
		return _sendShippingEmail;
	}

	@Override
	public void setSendShippingEmail(String sendShippingEmail) {
		_sendShippingEmail = sendShippingEmail;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSendShippingEmail",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					sendShippingEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEffectiveFromDate() {
		return _effectiveFromDate;
	}

	@Override
	public void setEffectiveFromDate(Date effectiveFromDate) {
		_effectiveFromDate = effectiveFromDate;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setEffectiveFromDate",
						Date.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					effectiveFromDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEffectiveToDate() {
		return _effectiveToDate;
	}

	@Override
	public void setEffectiveToDate(Date effectiveToDate) {
		_effectiveToDate = effectiveToDate;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setEffectiveToDate", Date.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					effectiveToDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAltShipping() {
		return _altShipping;
	}

	@Override
	public void setAltShipping(int altShipping) {
		_altShipping = altShipping;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setAltShipping", int.class);

				method.invoke(_membershipSubscriptionRemoteModel, altShipping);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getShipping() {
		return _shipping;
	}

	@Override
	public void setShipping(double shipping) {
		_shipping = shipping;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShipping", double.class);

				method.invoke(_membershipSubscriptionRemoteModel, shipping);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRequiresShipping() {
		return _requiresShipping;
	}

	@Override
	public boolean isRequiresShipping() {
		return _requiresShipping;
	}

	@Override
	public void setRequiresShipping(boolean requiresShipping) {
		_requiresShipping = requiresShipping;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiresShipping",
						boolean.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					requiresShipping);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getInsure() {
		return _insure;
	}

	@Override
	public boolean isInsure() {
		return _insure;
	}

	@Override
	public void setInsure(boolean insure) {
		_insure = insure;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setInsure", boolean.class);

				method.invoke(_membershipSubscriptionRemoteModel, insure);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getInsurance() {
		return _insurance;
	}

	@Override
	public void setInsurance(double insurance) {
		_insurance = insurance;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setInsurance", double.class);

				method.invoke(_membershipSubscriptionRemoteModel, insurance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingFirstName() {
		return _billingFirstName;
	}

	@Override
	public void setBillingFirstName(String billingFirstName) {
		_billingFirstName = billingFirstName;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingFirstName",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					billingFirstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingLastName() {
		return _billingLastName;
	}

	@Override
	public void setBillingLastName(String billingLastName) {
		_billingLastName = billingLastName;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingLastName",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					billingLastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingEmailAddress() {
		return _billingEmailAddress;
	}

	@Override
	public void setBillingEmailAddress(String billingEmailAddress) {
		_billingEmailAddress = billingEmailAddress;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingEmailAddress",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					billingEmailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingCompany() {
		return _billingCompany;
	}

	@Override
	public void setBillingCompany(String billingCompany) {
		_billingCompany = billingCompany;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingCompany",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel, billingCompany);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingStreet() {
		return _billingStreet;
	}

	@Override
	public void setBillingStreet(String billingStreet) {
		_billingStreet = billingStreet;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingStreet", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, billingStreet);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingCity() {
		return _billingCity;
	}

	@Override
	public void setBillingCity(String billingCity) {
		_billingCity = billingCity;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingCity", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, billingCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingState() {
		return _billingState;
	}

	@Override
	public void setBillingState(String billingState) {
		_billingState = billingState;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingState", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, billingState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingZip() {
		return _billingZip;
	}

	@Override
	public void setBillingZip(String billingZip) {
		_billingZip = billingZip;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingZip", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, billingZip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingCountry() {
		return _billingCountry;
	}

	@Override
	public void setBillingCountry(String billingCountry) {
		_billingCountry = billingCountry;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingCountry",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel, billingCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBillingPhone() {
		return _billingPhone;
	}

	@Override
	public void setBillingPhone(String billingPhone) {
		_billingPhone = billingPhone;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingPhone", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, billingPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getShipToBilling() {
		return _shipToBilling;
	}

	@Override
	public boolean isShipToBilling() {
		return _shipToBilling;
	}

	@Override
	public void setShipToBilling(boolean shipToBilling) {
		_shipToBilling = shipToBilling;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShipToBilling",
						boolean.class);

				method.invoke(_membershipSubscriptionRemoteModel, shipToBilling);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingFirstName() {
		return _shippingFirstName;
	}

	@Override
	public void setShippingFirstName(String shippingFirstName) {
		_shippingFirstName = shippingFirstName;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingFirstName",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					shippingFirstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingLastName() {
		return _shippingLastName;
	}

	@Override
	public void setShippingLastName(String shippingLastName) {
		_shippingLastName = shippingLastName;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingLastName",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					shippingLastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingEmailAddress() {
		return _shippingEmailAddress;
	}

	@Override
	public void setShippingEmailAddress(String shippingEmailAddress) {
		_shippingEmailAddress = shippingEmailAddress;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingEmailAddress",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					shippingEmailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingCompany() {
		return _shippingCompany;
	}

	@Override
	public void setShippingCompany(String shippingCompany) {
		_shippingCompany = shippingCompany;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingCompany",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					shippingCompany);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingStreet() {
		return _shippingStreet;
	}

	@Override
	public void setShippingStreet(String shippingStreet) {
		_shippingStreet = shippingStreet;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingStreet",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel, shippingStreet);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingCity() {
		return _shippingCity;
	}

	@Override
	public void setShippingCity(String shippingCity) {
		_shippingCity = shippingCity;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingCity", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, shippingCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingState() {
		return _shippingState;
	}

	@Override
	public void setShippingState(String shippingState) {
		_shippingState = shippingState;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingState", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, shippingState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingZip() {
		return _shippingZip;
	}

	@Override
	public void setShippingZip(String shippingZip) {
		_shippingZip = shippingZip;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingZip", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, shippingZip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingCountry() {
		return _shippingCountry;
	}

	@Override
	public void setShippingCountry(String shippingCountry) {
		_shippingCountry = shippingCountry;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingCountry",
						String.class);

				method.invoke(_membershipSubscriptionRemoteModel,
					shippingCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShippingPhone() {
		return _shippingPhone;
	}

	@Override
	public void setShippingPhone(String shippingPhone) {
		_shippingPhone = shippingPhone;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setShippingPhone", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, shippingPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCcName() {
		return _ccName;
	}

	@Override
	public void setCcName(String ccName) {
		_ccName = ccName;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCcName", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, ccName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCcType() {
		return _ccType;
	}

	@Override
	public void setCcType(String ccType) {
		_ccType = ccType;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCcType", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, ccType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCcNumber() {
		return _ccNumber;
	}

	@Override
	public void setCcNumber(String ccNumber) {
		_ccNumber = ccNumber;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCcNumber", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, ccNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCcExpMonth() {
		return _ccExpMonth;
	}

	@Override
	public void setCcExpMonth(int ccExpMonth) {
		_ccExpMonth = ccExpMonth;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCcExpMonth", int.class);

				method.invoke(_membershipSubscriptionRemoteModel, ccExpMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCcExpYear() {
		return _ccExpYear;
	}

	@Override
	public void setCcExpYear(int ccExpYear) {
		_ccExpYear = ccExpYear;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCcExpYear", int.class);

				method.invoke(_membershipSubscriptionRemoteModel, ccExpYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCcVerNumber() {
		return _ccVerNumber;
	}

	@Override
	public void setCcVerNumber(String ccVerNumber) {
		_ccVerNumber = ccVerNumber;

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCcVerNumber", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, ccVerNumber);
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

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_membershipSubscriptionRemoteModel, groupId);
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

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_membershipSubscriptionRemoteModel, companyId);
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

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_membershipSubscriptionRemoteModel, userId);
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

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_membershipSubscriptionRemoteModel, userName);
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

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_membershipSubscriptionRemoteModel, createDate);
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

		if (_membershipSubscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _membershipSubscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_membershipSubscriptionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMembershipSubscriptionRemoteModel() {
		return _membershipSubscriptionRemoteModel;
	}

	public void setMembershipSubscriptionRemoteModel(
		BaseModel<?> membershipSubscriptionRemoteModel) {
		_membershipSubscriptionRemoteModel = membershipSubscriptionRemoteModel;
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

		Class<?> remoteModelClass = _membershipSubscriptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_membershipSubscriptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MembershipSubscriptionLocalServiceUtil.addMembershipSubscription(this);
		}
		else {
			MembershipSubscriptionLocalServiceUtil.updateMembershipSubscription(this);
		}
	}

	@Override
	public MembershipSubscription toEscapedModel() {
		return (MembershipSubscription)ProxyUtil.newProxyInstance(MembershipSubscription.class.getClassLoader(),
			new Class[] { MembershipSubscription.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MembershipSubscriptionClp clone = new MembershipSubscriptionClp();

		clone.setMsId(getMsId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setMporder_1(getMporder_1());
		clone.setMpId_1(getMpId_1());
		clone.setMpName_1(getMpName_1());
		clone.setMpQty_1(getMpQty_1());
		clone.setMpPrice_1(getMpPrice_1());
		clone.setMpPriceCurrency_1(getMpPriceCurrency_1());
		clone.setMporder_2(getMporder_2());
		clone.setMpId_2(getMpId_2());
		clone.setMpName_2(getMpName_2());
		clone.setMpQty_2(getMpQty_2());
		clone.setMpPrice_2(getMpPrice_2());
		clone.setMpPriceCurrency_2(getMpPriceCurrency_2());
		clone.setMporder_3(getMporder_3());
		clone.setMpId_3(getMpId_3());
		clone.setMpName_3(getMpName_3());
		clone.setMpQty_3(getMpQty_3());
		clone.setMpPrice_3(getMpPrice_3());
		clone.setMpPriceCurrency_3(getMpPriceCurrency_3());
		clone.setMporder_4(getMporder_4());
		clone.setMpId_4(getMpId_4());
		clone.setMpName_4(getMpName_4());
		clone.setMpQty_4(getMpQty_4());
		clone.setMpPrice_4(getMpPrice_4());
		clone.setMpPriceCurrency_4(getMpPriceCurrency_4());
		clone.setMpSubtotal(getMpSubtotal());
		clone.setMpSubtotalCurrency(getMpSubtotalCurrency());
		clone.setAddOnSubtotal(getAddOnSubtotal());
		clone.setAddOnSubtotalCurrency(getAddOnSubtotalCurrency());
		clone.setTax(getTax());
		clone.setComments(getComments());
		clone.setPromotionCode(getPromotionCode());
		clone.setPromotionFrom(getPromotionFrom());
		clone.setPromotionTo(getPromotionTo());
		clone.setDiscount(getDiscount());
		clone.setNettotal(getNettotal());
		clone.setNettotalCurrency(getNettotalCurrency());
		clone.setPpTxnId(getPpTxnId());
		clone.setPpPaymentStatus(getPpPaymentStatus());
		clone.setPpPaymentGross(getPpPaymentGross());
		clone.setPpReceiverEmail(getPpReceiverEmail());
		clone.setPpPayerEmail(getPpPayerEmail());
		clone.setSendOrderEmail(getSendOrderEmail());
		clone.setSendShippingEmail(getSendShippingEmail());
		clone.setEffectiveFromDate(getEffectiveFromDate());
		clone.setEffectiveToDate(getEffectiveToDate());
		clone.setAltShipping(getAltShipping());
		clone.setShipping(getShipping());
		clone.setRequiresShipping(getRequiresShipping());
		clone.setInsure(getInsure());
		clone.setInsurance(getInsurance());
		clone.setBillingFirstName(getBillingFirstName());
		clone.setBillingLastName(getBillingLastName());
		clone.setBillingEmailAddress(getBillingEmailAddress());
		clone.setBillingCompany(getBillingCompany());
		clone.setBillingStreet(getBillingStreet());
		clone.setBillingCity(getBillingCity());
		clone.setBillingState(getBillingState());
		clone.setBillingZip(getBillingZip());
		clone.setBillingCountry(getBillingCountry());
		clone.setBillingPhone(getBillingPhone());
		clone.setShipToBilling(getShipToBilling());
		clone.setShippingFirstName(getShippingFirstName());
		clone.setShippingLastName(getShippingLastName());
		clone.setShippingEmailAddress(getShippingEmailAddress());
		clone.setShippingCompany(getShippingCompany());
		clone.setShippingStreet(getShippingStreet());
		clone.setShippingCity(getShippingCity());
		clone.setShippingState(getShippingState());
		clone.setShippingZip(getShippingZip());
		clone.setShippingCountry(getShippingCountry());
		clone.setShippingPhone(getShippingPhone());
		clone.setCcName(getCcName());
		clone.setCcType(getCcType());
		clone.setCcNumber(getCcNumber());
		clone.setCcExpMonth(getCcExpMonth());
		clone.setCcExpYear(getCcExpYear());
		clone.setCcVerNumber(getCcVerNumber());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(MembershipSubscription membershipSubscription) {
		long primaryKey = membershipSubscription.getPrimaryKey();

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

		if (!(obj instanceof MembershipSubscriptionClp)) {
			return false;
		}

		MembershipSubscriptionClp membershipSubscription = (MembershipSubscriptionClp)obj;

		long primaryKey = membershipSubscription.getPrimaryKey();

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
		StringBundler sb = new StringBundler(173);

		sb.append("{msId=");
		sb.append(getMsId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", mporder_1=");
		sb.append(getMporder_1());
		sb.append(", mpId_1=");
		sb.append(getMpId_1());
		sb.append(", mpName_1=");
		sb.append(getMpName_1());
		sb.append(", mpQty_1=");
		sb.append(getMpQty_1());
		sb.append(", mpPrice_1=");
		sb.append(getMpPrice_1());
		sb.append(", mpPriceCurrency_1=");
		sb.append(getMpPriceCurrency_1());
		sb.append(", mporder_2=");
		sb.append(getMporder_2());
		sb.append(", mpId_2=");
		sb.append(getMpId_2());
		sb.append(", mpName_2=");
		sb.append(getMpName_2());
		sb.append(", mpQty_2=");
		sb.append(getMpQty_2());
		sb.append(", mpPrice_2=");
		sb.append(getMpPrice_2());
		sb.append(", mpPriceCurrency_2=");
		sb.append(getMpPriceCurrency_2());
		sb.append(", mporder_3=");
		sb.append(getMporder_3());
		sb.append(", mpId_3=");
		sb.append(getMpId_3());
		sb.append(", mpName_3=");
		sb.append(getMpName_3());
		sb.append(", mpQty_3=");
		sb.append(getMpQty_3());
		sb.append(", mpPrice_3=");
		sb.append(getMpPrice_3());
		sb.append(", mpPriceCurrency_3=");
		sb.append(getMpPriceCurrency_3());
		sb.append(", mporder_4=");
		sb.append(getMporder_4());
		sb.append(", mpId_4=");
		sb.append(getMpId_4());
		sb.append(", mpName_4=");
		sb.append(getMpName_4());
		sb.append(", mpQty_4=");
		sb.append(getMpQty_4());
		sb.append(", mpPrice_4=");
		sb.append(getMpPrice_4());
		sb.append(", mpPriceCurrency_4=");
		sb.append(getMpPriceCurrency_4());
		sb.append(", mpSubtotal=");
		sb.append(getMpSubtotal());
		sb.append(", mpSubtotalCurrency=");
		sb.append(getMpSubtotalCurrency());
		sb.append(", addOnSubtotal=");
		sb.append(getAddOnSubtotal());
		sb.append(", addOnSubtotalCurrency=");
		sb.append(getAddOnSubtotalCurrency());
		sb.append(", tax=");
		sb.append(getTax());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", promotionCode=");
		sb.append(getPromotionCode());
		sb.append(", promotionFrom=");
		sb.append(getPromotionFrom());
		sb.append(", promotionTo=");
		sb.append(getPromotionTo());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", nettotal=");
		sb.append(getNettotal());
		sb.append(", nettotalCurrency=");
		sb.append(getNettotalCurrency());
		sb.append(", ppTxnId=");
		sb.append(getPpTxnId());
		sb.append(", ppPaymentStatus=");
		sb.append(getPpPaymentStatus());
		sb.append(", ppPaymentGross=");
		sb.append(getPpPaymentGross());
		sb.append(", ppReceiverEmail=");
		sb.append(getPpReceiverEmail());
		sb.append(", ppPayerEmail=");
		sb.append(getPpPayerEmail());
		sb.append(", sendOrderEmail=");
		sb.append(getSendOrderEmail());
		sb.append(", sendShippingEmail=");
		sb.append(getSendShippingEmail());
		sb.append(", effectiveFromDate=");
		sb.append(getEffectiveFromDate());
		sb.append(", effectiveToDate=");
		sb.append(getEffectiveToDate());
		sb.append(", altShipping=");
		sb.append(getAltShipping());
		sb.append(", shipping=");
		sb.append(getShipping());
		sb.append(", requiresShipping=");
		sb.append(getRequiresShipping());
		sb.append(", insure=");
		sb.append(getInsure());
		sb.append(", insurance=");
		sb.append(getInsurance());
		sb.append(", billingFirstName=");
		sb.append(getBillingFirstName());
		sb.append(", billingLastName=");
		sb.append(getBillingLastName());
		sb.append(", billingEmailAddress=");
		sb.append(getBillingEmailAddress());
		sb.append(", billingCompany=");
		sb.append(getBillingCompany());
		sb.append(", billingStreet=");
		sb.append(getBillingStreet());
		sb.append(", billingCity=");
		sb.append(getBillingCity());
		sb.append(", billingState=");
		sb.append(getBillingState());
		sb.append(", billingZip=");
		sb.append(getBillingZip());
		sb.append(", billingCountry=");
		sb.append(getBillingCountry());
		sb.append(", billingPhone=");
		sb.append(getBillingPhone());
		sb.append(", shipToBilling=");
		sb.append(getShipToBilling());
		sb.append(", shippingFirstName=");
		sb.append(getShippingFirstName());
		sb.append(", shippingLastName=");
		sb.append(getShippingLastName());
		sb.append(", shippingEmailAddress=");
		sb.append(getShippingEmailAddress());
		sb.append(", shippingCompany=");
		sb.append(getShippingCompany());
		sb.append(", shippingStreet=");
		sb.append(getShippingStreet());
		sb.append(", shippingCity=");
		sb.append(getShippingCity());
		sb.append(", shippingState=");
		sb.append(getShippingState());
		sb.append(", shippingZip=");
		sb.append(getShippingZip());
		sb.append(", shippingCountry=");
		sb.append(getShippingCountry());
		sb.append(", shippingPhone=");
		sb.append(getShippingPhone());
		sb.append(", ccName=");
		sb.append(getCcName());
		sb.append(", ccType=");
		sb.append(getCcType());
		sb.append(", ccNumber=");
		sb.append(getCcNumber());
		sb.append(", ccExpMonth=");
		sb.append(getCcExpMonth());
		sb.append(", ccExpYear=");
		sb.append(getCcExpYear());
		sb.append(", ccVerNumber=");
		sb.append(getCcVerNumber());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(262);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spservices.model.MembershipSubscription");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>msId</column-name><column-value><![CDATA[");
		sb.append(getMsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mporder_1</column-name><column-value><![CDATA[");
		sb.append(getMporder_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpId_1</column-name><column-value><![CDATA[");
		sb.append(getMpId_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpName_1</column-name><column-value><![CDATA[");
		sb.append(getMpName_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpQty_1</column-name><column-value><![CDATA[");
		sb.append(getMpQty_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpPrice_1</column-name><column-value><![CDATA[");
		sb.append(getMpPrice_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpPriceCurrency_1</column-name><column-value><![CDATA[");
		sb.append(getMpPriceCurrency_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mporder_2</column-name><column-value><![CDATA[");
		sb.append(getMporder_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpId_2</column-name><column-value><![CDATA[");
		sb.append(getMpId_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpName_2</column-name><column-value><![CDATA[");
		sb.append(getMpName_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpQty_2</column-name><column-value><![CDATA[");
		sb.append(getMpQty_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpPrice_2</column-name><column-value><![CDATA[");
		sb.append(getMpPrice_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpPriceCurrency_2</column-name><column-value><![CDATA[");
		sb.append(getMpPriceCurrency_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mporder_3</column-name><column-value><![CDATA[");
		sb.append(getMporder_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpId_3</column-name><column-value><![CDATA[");
		sb.append(getMpId_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpName_3</column-name><column-value><![CDATA[");
		sb.append(getMpName_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpQty_3</column-name><column-value><![CDATA[");
		sb.append(getMpQty_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpPrice_3</column-name><column-value><![CDATA[");
		sb.append(getMpPrice_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpPriceCurrency_3</column-name><column-value><![CDATA[");
		sb.append(getMpPriceCurrency_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mporder_4</column-name><column-value><![CDATA[");
		sb.append(getMporder_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpId_4</column-name><column-value><![CDATA[");
		sb.append(getMpId_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpName_4</column-name><column-value><![CDATA[");
		sb.append(getMpName_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpQty_4</column-name><column-value><![CDATA[");
		sb.append(getMpQty_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpPrice_4</column-name><column-value><![CDATA[");
		sb.append(getMpPrice_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpPriceCurrency_4</column-name><column-value><![CDATA[");
		sb.append(getMpPriceCurrency_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpSubtotal</column-name><column-value><![CDATA[");
		sb.append(getMpSubtotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpSubtotalCurrency</column-name><column-value><![CDATA[");
		sb.append(getMpSubtotalCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addOnSubtotal</column-name><column-value><![CDATA[");
		sb.append(getAddOnSubtotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addOnSubtotalCurrency</column-name><column-value><![CDATA[");
		sb.append(getAddOnSubtotalCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tax</column-name><column-value><![CDATA[");
		sb.append(getTax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotionCode</column-name><column-value><![CDATA[");
		sb.append(getPromotionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotionFrom</column-name><column-value><![CDATA[");
		sb.append(getPromotionFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotionTo</column-name><column-value><![CDATA[");
		sb.append(getPromotionTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nettotal</column-name><column-value><![CDATA[");
		sb.append(getNettotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nettotalCurrency</column-name><column-value><![CDATA[");
		sb.append(getNettotalCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppTxnId</column-name><column-value><![CDATA[");
		sb.append(getPpTxnId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppPaymentStatus</column-name><column-value><![CDATA[");
		sb.append(getPpPaymentStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppPaymentGross</column-name><column-value><![CDATA[");
		sb.append(getPpPaymentGross());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppReceiverEmail</column-name><column-value><![CDATA[");
		sb.append(getPpReceiverEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppPayerEmail</column-name><column-value><![CDATA[");
		sb.append(getPpPayerEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendOrderEmail</column-name><column-value><![CDATA[");
		sb.append(getSendOrderEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendShippingEmail</column-name><column-value><![CDATA[");
		sb.append(getSendShippingEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveFromDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveFromDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveToDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveToDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>altShipping</column-name><column-value><![CDATA[");
		sb.append(getAltShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipping</column-name><column-value><![CDATA[");
		sb.append(getShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiresShipping</column-name><column-value><![CDATA[");
		sb.append(getRequiresShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insure</column-name><column-value><![CDATA[");
		sb.append(getInsure());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insurance</column-name><column-value><![CDATA[");
		sb.append(getInsurance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingFirstName</column-name><column-value><![CDATA[");
		sb.append(getBillingFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingLastName</column-name><column-value><![CDATA[");
		sb.append(getBillingLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getBillingEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingCompany</column-name><column-value><![CDATA[");
		sb.append(getBillingCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingStreet</column-name><column-value><![CDATA[");
		sb.append(getBillingStreet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingCity</column-name><column-value><![CDATA[");
		sb.append(getBillingCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingState</column-name><column-value><![CDATA[");
		sb.append(getBillingState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingZip</column-name><column-value><![CDATA[");
		sb.append(getBillingZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingCountry</column-name><column-value><![CDATA[");
		sb.append(getBillingCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingPhone</column-name><column-value><![CDATA[");
		sb.append(getBillingPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipToBilling</column-name><column-value><![CDATA[");
		sb.append(getShipToBilling());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingFirstName</column-name><column-value><![CDATA[");
		sb.append(getShippingFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingLastName</column-name><column-value><![CDATA[");
		sb.append(getShippingLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getShippingEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCompany</column-name><column-value><![CDATA[");
		sb.append(getShippingCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingStreet</column-name><column-value><![CDATA[");
		sb.append(getShippingStreet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCity</column-name><column-value><![CDATA[");
		sb.append(getShippingCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingState</column-name><column-value><![CDATA[");
		sb.append(getShippingState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingZip</column-name><column-value><![CDATA[");
		sb.append(getShippingZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCountry</column-name><column-value><![CDATA[");
		sb.append(getShippingCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingPhone</column-name><column-value><![CDATA[");
		sb.append(getShippingPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccName</column-name><column-value><![CDATA[");
		sb.append(getCcName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccType</column-name><column-value><![CDATA[");
		sb.append(getCcType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccNumber</column-name><column-value><![CDATA[");
		sb.append(getCcNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccExpMonth</column-name><column-value><![CDATA[");
		sb.append(getCcExpMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccExpYear</column-name><column-value><![CDATA[");
		sb.append(getCcExpYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccVerNumber</column-name><column-value><![CDATA[");
		sb.append(getCcVerNumber());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _msId;
	private String _name;
	private String _description;
	private String _mporder_1;
	private String _mpId_1;
	private String _mpName_1;
	private int _mpQty_1;
	private float _mpPrice_1;
	private String _mpPriceCurrency_1;
	private String _mporder_2;
	private String _mpId_2;
	private String _mpName_2;
	private int _mpQty_2;
	private float _mpPrice_2;
	private String _mpPriceCurrency_2;
	private String _mporder_3;
	private String _mpId_3;
	private String _mpName_3;
	private int _mpQty_3;
	private float _mpPrice_3;
	private String _mpPriceCurrency_3;
	private String _mporder_4;
	private String _mpId_4;
	private String _mpName_4;
	private int _mpQty_4;
	private float _mpPrice_4;
	private String _mpPriceCurrency_4;
	private float _mpSubtotal;
	private String _mpSubtotalCurrency;
	private float _addOnSubtotal;
	private String _addOnSubtotalCurrency;
	private float _tax;
	private String _comments;
	private String _promotionCode;
	private Date _promotionFrom;
	private Date _promotionTo;
	private String _discount;
	private float _nettotal;
	private String _nettotalCurrency;
	private String _ppTxnId;
	private String _ppPaymentStatus;
	private float _ppPaymentGross;
	private String _ppReceiverEmail;
	private String _ppPayerEmail;
	private String _sendOrderEmail;
	private String _sendShippingEmail;
	private Date _effectiveFromDate;
	private Date _effectiveToDate;
	private int _altShipping;
	private double _shipping;
	private boolean _requiresShipping;
	private boolean _insure;
	private double _insurance;
	private String _billingFirstName;
	private String _billingLastName;
	private String _billingEmailAddress;
	private String _billingCompany;
	private String _billingStreet;
	private String _billingCity;
	private String _billingState;
	private String _billingZip;
	private String _billingCountry;
	private String _billingPhone;
	private boolean _shipToBilling;
	private String _shippingFirstName;
	private String _shippingLastName;
	private String _shippingEmailAddress;
	private String _shippingCompany;
	private String _shippingStreet;
	private String _shippingCity;
	private String _shippingState;
	private String _shippingZip;
	private String _shippingCountry;
	private String _shippingPhone;
	private String _ccName;
	private String _ccType;
	private String _ccNumber;
	private int _ccExpMonth;
	private int _ccExpYear;
	private String _ccVerNumber;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _membershipSubscriptionRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}