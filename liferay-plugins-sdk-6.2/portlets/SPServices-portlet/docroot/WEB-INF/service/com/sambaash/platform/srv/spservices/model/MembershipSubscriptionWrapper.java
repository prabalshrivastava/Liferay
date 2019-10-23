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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MembershipSubscription}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscription
 * @generated
 */
public class MembershipSubscriptionWrapper implements MembershipSubscription,
	ModelWrapper<MembershipSubscription> {
	public MembershipSubscriptionWrapper(
		MembershipSubscription membershipSubscription) {
		_membershipSubscription = membershipSubscription;
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

	/**
	* Returns the primary key of this membership subscription.
	*
	* @return the primary key of this membership subscription
	*/
	@Override
	public long getPrimaryKey() {
		return _membershipSubscription.getPrimaryKey();
	}

	/**
	* Sets the primary key of this membership subscription.
	*
	* @param primaryKey the primary key of this membership subscription
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_membershipSubscription.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ms ID of this membership subscription.
	*
	* @return the ms ID of this membership subscription
	*/
	@Override
	public long getMsId() {
		return _membershipSubscription.getMsId();
	}

	/**
	* Sets the ms ID of this membership subscription.
	*
	* @param msId the ms ID of this membership subscription
	*/
	@Override
	public void setMsId(long msId) {
		_membershipSubscription.setMsId(msId);
	}

	/**
	* Returns the name of this membership subscription.
	*
	* @return the name of this membership subscription
	*/
	@Override
	public java.lang.String getName() {
		return _membershipSubscription.getName();
	}

	/**
	* Sets the name of this membership subscription.
	*
	* @param name the name of this membership subscription
	*/
	@Override
	public void setName(java.lang.String name) {
		_membershipSubscription.setName(name);
	}

	/**
	* Returns the description of this membership subscription.
	*
	* @return the description of this membership subscription
	*/
	@Override
	public java.lang.String getDescription() {
		return _membershipSubscription.getDescription();
	}

	/**
	* Sets the description of this membership subscription.
	*
	* @param description the description of this membership subscription
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_membershipSubscription.setDescription(description);
	}

	/**
	* Returns the mporder_1 of this membership subscription.
	*
	* @return the mporder_1 of this membership subscription
	*/
	@Override
	public java.lang.String getMporder_1() {
		return _membershipSubscription.getMporder_1();
	}

	/**
	* Sets the mporder_1 of this membership subscription.
	*
	* @param mporder_1 the mporder_1 of this membership subscription
	*/
	@Override
	public void setMporder_1(java.lang.String mporder_1) {
		_membershipSubscription.setMporder_1(mporder_1);
	}

	/**
	* Returns the mp id_1 of this membership subscription.
	*
	* @return the mp id_1 of this membership subscription
	*/
	@Override
	public java.lang.String getMpId_1() {
		return _membershipSubscription.getMpId_1();
	}

	/**
	* Sets the mp id_1 of this membership subscription.
	*
	* @param mpId_1 the mp id_1 of this membership subscription
	*/
	@Override
	public void setMpId_1(java.lang.String mpId_1) {
		_membershipSubscription.setMpId_1(mpId_1);
	}

	/**
	* Returns the mp name_1 of this membership subscription.
	*
	* @return the mp name_1 of this membership subscription
	*/
	@Override
	public java.lang.String getMpName_1() {
		return _membershipSubscription.getMpName_1();
	}

	/**
	* Sets the mp name_1 of this membership subscription.
	*
	* @param mpName_1 the mp name_1 of this membership subscription
	*/
	@Override
	public void setMpName_1(java.lang.String mpName_1) {
		_membershipSubscription.setMpName_1(mpName_1);
	}

	/**
	* Returns the mp qty_1 of this membership subscription.
	*
	* @return the mp qty_1 of this membership subscription
	*/
	@Override
	public int getMpQty_1() {
		return _membershipSubscription.getMpQty_1();
	}

	/**
	* Sets the mp qty_1 of this membership subscription.
	*
	* @param mpQty_1 the mp qty_1 of this membership subscription
	*/
	@Override
	public void setMpQty_1(int mpQty_1) {
		_membershipSubscription.setMpQty_1(mpQty_1);
	}

	/**
	* Returns the mp price_1 of this membership subscription.
	*
	* @return the mp price_1 of this membership subscription
	*/
	@Override
	public float getMpPrice_1() {
		return _membershipSubscription.getMpPrice_1();
	}

	/**
	* Sets the mp price_1 of this membership subscription.
	*
	* @param mpPrice_1 the mp price_1 of this membership subscription
	*/
	@Override
	public void setMpPrice_1(float mpPrice_1) {
		_membershipSubscription.setMpPrice_1(mpPrice_1);
	}

	/**
	* Returns the mp price currency_1 of this membership subscription.
	*
	* @return the mp price currency_1 of this membership subscription
	*/
	@Override
	public java.lang.String getMpPriceCurrency_1() {
		return _membershipSubscription.getMpPriceCurrency_1();
	}

	/**
	* Sets the mp price currency_1 of this membership subscription.
	*
	* @param mpPriceCurrency_1 the mp price currency_1 of this membership subscription
	*/
	@Override
	public void setMpPriceCurrency_1(java.lang.String mpPriceCurrency_1) {
		_membershipSubscription.setMpPriceCurrency_1(mpPriceCurrency_1);
	}

	/**
	* Returns the mporder_2 of this membership subscription.
	*
	* @return the mporder_2 of this membership subscription
	*/
	@Override
	public java.lang.String getMporder_2() {
		return _membershipSubscription.getMporder_2();
	}

	/**
	* Sets the mporder_2 of this membership subscription.
	*
	* @param mporder_2 the mporder_2 of this membership subscription
	*/
	@Override
	public void setMporder_2(java.lang.String mporder_2) {
		_membershipSubscription.setMporder_2(mporder_2);
	}

	/**
	* Returns the mp id_2 of this membership subscription.
	*
	* @return the mp id_2 of this membership subscription
	*/
	@Override
	public java.lang.String getMpId_2() {
		return _membershipSubscription.getMpId_2();
	}

	/**
	* Sets the mp id_2 of this membership subscription.
	*
	* @param mpId_2 the mp id_2 of this membership subscription
	*/
	@Override
	public void setMpId_2(java.lang.String mpId_2) {
		_membershipSubscription.setMpId_2(mpId_2);
	}

	/**
	* Returns the mp name_2 of this membership subscription.
	*
	* @return the mp name_2 of this membership subscription
	*/
	@Override
	public java.lang.String getMpName_2() {
		return _membershipSubscription.getMpName_2();
	}

	/**
	* Sets the mp name_2 of this membership subscription.
	*
	* @param mpName_2 the mp name_2 of this membership subscription
	*/
	@Override
	public void setMpName_2(java.lang.String mpName_2) {
		_membershipSubscription.setMpName_2(mpName_2);
	}

	/**
	* Returns the mp qty_2 of this membership subscription.
	*
	* @return the mp qty_2 of this membership subscription
	*/
	@Override
	public int getMpQty_2() {
		return _membershipSubscription.getMpQty_2();
	}

	/**
	* Sets the mp qty_2 of this membership subscription.
	*
	* @param mpQty_2 the mp qty_2 of this membership subscription
	*/
	@Override
	public void setMpQty_2(int mpQty_2) {
		_membershipSubscription.setMpQty_2(mpQty_2);
	}

	/**
	* Returns the mp price_2 of this membership subscription.
	*
	* @return the mp price_2 of this membership subscription
	*/
	@Override
	public float getMpPrice_2() {
		return _membershipSubscription.getMpPrice_2();
	}

	/**
	* Sets the mp price_2 of this membership subscription.
	*
	* @param mpPrice_2 the mp price_2 of this membership subscription
	*/
	@Override
	public void setMpPrice_2(float mpPrice_2) {
		_membershipSubscription.setMpPrice_2(mpPrice_2);
	}

	/**
	* Returns the mp price currency_2 of this membership subscription.
	*
	* @return the mp price currency_2 of this membership subscription
	*/
	@Override
	public java.lang.String getMpPriceCurrency_2() {
		return _membershipSubscription.getMpPriceCurrency_2();
	}

	/**
	* Sets the mp price currency_2 of this membership subscription.
	*
	* @param mpPriceCurrency_2 the mp price currency_2 of this membership subscription
	*/
	@Override
	public void setMpPriceCurrency_2(java.lang.String mpPriceCurrency_2) {
		_membershipSubscription.setMpPriceCurrency_2(mpPriceCurrency_2);
	}

	/**
	* Returns the mporder_3 of this membership subscription.
	*
	* @return the mporder_3 of this membership subscription
	*/
	@Override
	public java.lang.String getMporder_3() {
		return _membershipSubscription.getMporder_3();
	}

	/**
	* Sets the mporder_3 of this membership subscription.
	*
	* @param mporder_3 the mporder_3 of this membership subscription
	*/
	@Override
	public void setMporder_3(java.lang.String mporder_3) {
		_membershipSubscription.setMporder_3(mporder_3);
	}

	/**
	* Returns the mp id_3 of this membership subscription.
	*
	* @return the mp id_3 of this membership subscription
	*/
	@Override
	public java.lang.String getMpId_3() {
		return _membershipSubscription.getMpId_3();
	}

	/**
	* Sets the mp id_3 of this membership subscription.
	*
	* @param mpId_3 the mp id_3 of this membership subscription
	*/
	@Override
	public void setMpId_3(java.lang.String mpId_3) {
		_membershipSubscription.setMpId_3(mpId_3);
	}

	/**
	* Returns the mp name_3 of this membership subscription.
	*
	* @return the mp name_3 of this membership subscription
	*/
	@Override
	public java.lang.String getMpName_3() {
		return _membershipSubscription.getMpName_3();
	}

	/**
	* Sets the mp name_3 of this membership subscription.
	*
	* @param mpName_3 the mp name_3 of this membership subscription
	*/
	@Override
	public void setMpName_3(java.lang.String mpName_3) {
		_membershipSubscription.setMpName_3(mpName_3);
	}

	/**
	* Returns the mp qty_3 of this membership subscription.
	*
	* @return the mp qty_3 of this membership subscription
	*/
	@Override
	public int getMpQty_3() {
		return _membershipSubscription.getMpQty_3();
	}

	/**
	* Sets the mp qty_3 of this membership subscription.
	*
	* @param mpQty_3 the mp qty_3 of this membership subscription
	*/
	@Override
	public void setMpQty_3(int mpQty_3) {
		_membershipSubscription.setMpQty_3(mpQty_3);
	}

	/**
	* Returns the mp price_3 of this membership subscription.
	*
	* @return the mp price_3 of this membership subscription
	*/
	@Override
	public float getMpPrice_3() {
		return _membershipSubscription.getMpPrice_3();
	}

	/**
	* Sets the mp price_3 of this membership subscription.
	*
	* @param mpPrice_3 the mp price_3 of this membership subscription
	*/
	@Override
	public void setMpPrice_3(float mpPrice_3) {
		_membershipSubscription.setMpPrice_3(mpPrice_3);
	}

	/**
	* Returns the mp price currency_3 of this membership subscription.
	*
	* @return the mp price currency_3 of this membership subscription
	*/
	@Override
	public java.lang.String getMpPriceCurrency_3() {
		return _membershipSubscription.getMpPriceCurrency_3();
	}

	/**
	* Sets the mp price currency_3 of this membership subscription.
	*
	* @param mpPriceCurrency_3 the mp price currency_3 of this membership subscription
	*/
	@Override
	public void setMpPriceCurrency_3(java.lang.String mpPriceCurrency_3) {
		_membershipSubscription.setMpPriceCurrency_3(mpPriceCurrency_3);
	}

	/**
	* Returns the mporder_4 of this membership subscription.
	*
	* @return the mporder_4 of this membership subscription
	*/
	@Override
	public java.lang.String getMporder_4() {
		return _membershipSubscription.getMporder_4();
	}

	/**
	* Sets the mporder_4 of this membership subscription.
	*
	* @param mporder_4 the mporder_4 of this membership subscription
	*/
	@Override
	public void setMporder_4(java.lang.String mporder_4) {
		_membershipSubscription.setMporder_4(mporder_4);
	}

	/**
	* Returns the mp id_4 of this membership subscription.
	*
	* @return the mp id_4 of this membership subscription
	*/
	@Override
	public java.lang.String getMpId_4() {
		return _membershipSubscription.getMpId_4();
	}

	/**
	* Sets the mp id_4 of this membership subscription.
	*
	* @param mpId_4 the mp id_4 of this membership subscription
	*/
	@Override
	public void setMpId_4(java.lang.String mpId_4) {
		_membershipSubscription.setMpId_4(mpId_4);
	}

	/**
	* Returns the mp name_4 of this membership subscription.
	*
	* @return the mp name_4 of this membership subscription
	*/
	@Override
	public java.lang.String getMpName_4() {
		return _membershipSubscription.getMpName_4();
	}

	/**
	* Sets the mp name_4 of this membership subscription.
	*
	* @param mpName_4 the mp name_4 of this membership subscription
	*/
	@Override
	public void setMpName_4(java.lang.String mpName_4) {
		_membershipSubscription.setMpName_4(mpName_4);
	}

	/**
	* Returns the mp qty_4 of this membership subscription.
	*
	* @return the mp qty_4 of this membership subscription
	*/
	@Override
	public int getMpQty_4() {
		return _membershipSubscription.getMpQty_4();
	}

	/**
	* Sets the mp qty_4 of this membership subscription.
	*
	* @param mpQty_4 the mp qty_4 of this membership subscription
	*/
	@Override
	public void setMpQty_4(int mpQty_4) {
		_membershipSubscription.setMpQty_4(mpQty_4);
	}

	/**
	* Returns the mp price_4 of this membership subscription.
	*
	* @return the mp price_4 of this membership subscription
	*/
	@Override
	public float getMpPrice_4() {
		return _membershipSubscription.getMpPrice_4();
	}

	/**
	* Sets the mp price_4 of this membership subscription.
	*
	* @param mpPrice_4 the mp price_4 of this membership subscription
	*/
	@Override
	public void setMpPrice_4(float mpPrice_4) {
		_membershipSubscription.setMpPrice_4(mpPrice_4);
	}

	/**
	* Returns the mp price currency_4 of this membership subscription.
	*
	* @return the mp price currency_4 of this membership subscription
	*/
	@Override
	public java.lang.String getMpPriceCurrency_4() {
		return _membershipSubscription.getMpPriceCurrency_4();
	}

	/**
	* Sets the mp price currency_4 of this membership subscription.
	*
	* @param mpPriceCurrency_4 the mp price currency_4 of this membership subscription
	*/
	@Override
	public void setMpPriceCurrency_4(java.lang.String mpPriceCurrency_4) {
		_membershipSubscription.setMpPriceCurrency_4(mpPriceCurrency_4);
	}

	/**
	* Returns the mp subtotal of this membership subscription.
	*
	* @return the mp subtotal of this membership subscription
	*/
	@Override
	public float getMpSubtotal() {
		return _membershipSubscription.getMpSubtotal();
	}

	/**
	* Sets the mp subtotal of this membership subscription.
	*
	* @param mpSubtotal the mp subtotal of this membership subscription
	*/
	@Override
	public void setMpSubtotal(float mpSubtotal) {
		_membershipSubscription.setMpSubtotal(mpSubtotal);
	}

	/**
	* Returns the mp subtotal currency of this membership subscription.
	*
	* @return the mp subtotal currency of this membership subscription
	*/
	@Override
	public java.lang.String getMpSubtotalCurrency() {
		return _membershipSubscription.getMpSubtotalCurrency();
	}

	/**
	* Sets the mp subtotal currency of this membership subscription.
	*
	* @param mpSubtotalCurrency the mp subtotal currency of this membership subscription
	*/
	@Override
	public void setMpSubtotalCurrency(java.lang.String mpSubtotalCurrency) {
		_membershipSubscription.setMpSubtotalCurrency(mpSubtotalCurrency);
	}

	/**
	* Returns the add on subtotal of this membership subscription.
	*
	* @return the add on subtotal of this membership subscription
	*/
	@Override
	public float getAddOnSubtotal() {
		return _membershipSubscription.getAddOnSubtotal();
	}

	/**
	* Sets the add on subtotal of this membership subscription.
	*
	* @param addOnSubtotal the add on subtotal of this membership subscription
	*/
	@Override
	public void setAddOnSubtotal(float addOnSubtotal) {
		_membershipSubscription.setAddOnSubtotal(addOnSubtotal);
	}

	/**
	* Returns the add on subtotal currency of this membership subscription.
	*
	* @return the add on subtotal currency of this membership subscription
	*/
	@Override
	public java.lang.String getAddOnSubtotalCurrency() {
		return _membershipSubscription.getAddOnSubtotalCurrency();
	}

	/**
	* Sets the add on subtotal currency of this membership subscription.
	*
	* @param addOnSubtotalCurrency the add on subtotal currency of this membership subscription
	*/
	@Override
	public void setAddOnSubtotalCurrency(java.lang.String addOnSubtotalCurrency) {
		_membershipSubscription.setAddOnSubtotalCurrency(addOnSubtotalCurrency);
	}

	/**
	* Returns the tax of this membership subscription.
	*
	* @return the tax of this membership subscription
	*/
	@Override
	public float getTax() {
		return _membershipSubscription.getTax();
	}

	/**
	* Sets the tax of this membership subscription.
	*
	* @param tax the tax of this membership subscription
	*/
	@Override
	public void setTax(float tax) {
		_membershipSubscription.setTax(tax);
	}

	/**
	* Returns the comments of this membership subscription.
	*
	* @return the comments of this membership subscription
	*/
	@Override
	public java.lang.String getComments() {
		return _membershipSubscription.getComments();
	}

	/**
	* Sets the comments of this membership subscription.
	*
	* @param comments the comments of this membership subscription
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_membershipSubscription.setComments(comments);
	}

	/**
	* Returns the promotion code of this membership subscription.
	*
	* @return the promotion code of this membership subscription
	*/
	@Override
	public java.lang.String getPromotionCode() {
		return _membershipSubscription.getPromotionCode();
	}

	/**
	* Sets the promotion code of this membership subscription.
	*
	* @param promotionCode the promotion code of this membership subscription
	*/
	@Override
	public void setPromotionCode(java.lang.String promotionCode) {
		_membershipSubscription.setPromotionCode(promotionCode);
	}

	/**
	* Returns the promotion from of this membership subscription.
	*
	* @return the promotion from of this membership subscription
	*/
	@Override
	public java.util.Date getPromotionFrom() {
		return _membershipSubscription.getPromotionFrom();
	}

	/**
	* Sets the promotion from of this membership subscription.
	*
	* @param promotionFrom the promotion from of this membership subscription
	*/
	@Override
	public void setPromotionFrom(java.util.Date promotionFrom) {
		_membershipSubscription.setPromotionFrom(promotionFrom);
	}

	/**
	* Returns the promotion to of this membership subscription.
	*
	* @return the promotion to of this membership subscription
	*/
	@Override
	public java.util.Date getPromotionTo() {
		return _membershipSubscription.getPromotionTo();
	}

	/**
	* Sets the promotion to of this membership subscription.
	*
	* @param promotionTo the promotion to of this membership subscription
	*/
	@Override
	public void setPromotionTo(java.util.Date promotionTo) {
		_membershipSubscription.setPromotionTo(promotionTo);
	}

	/**
	* Returns the discount of this membership subscription.
	*
	* @return the discount of this membership subscription
	*/
	@Override
	public java.lang.String getDiscount() {
		return _membershipSubscription.getDiscount();
	}

	/**
	* Sets the discount of this membership subscription.
	*
	* @param discount the discount of this membership subscription
	*/
	@Override
	public void setDiscount(java.lang.String discount) {
		_membershipSubscription.setDiscount(discount);
	}

	/**
	* Returns the nettotal of this membership subscription.
	*
	* @return the nettotal of this membership subscription
	*/
	@Override
	public float getNettotal() {
		return _membershipSubscription.getNettotal();
	}

	/**
	* Sets the nettotal of this membership subscription.
	*
	* @param nettotal the nettotal of this membership subscription
	*/
	@Override
	public void setNettotal(float nettotal) {
		_membershipSubscription.setNettotal(nettotal);
	}

	/**
	* Returns the nettotal currency of this membership subscription.
	*
	* @return the nettotal currency of this membership subscription
	*/
	@Override
	public java.lang.String getNettotalCurrency() {
		return _membershipSubscription.getNettotalCurrency();
	}

	/**
	* Sets the nettotal currency of this membership subscription.
	*
	* @param nettotalCurrency the nettotal currency of this membership subscription
	*/
	@Override
	public void setNettotalCurrency(java.lang.String nettotalCurrency) {
		_membershipSubscription.setNettotalCurrency(nettotalCurrency);
	}

	/**
	* Returns the pp txn ID of this membership subscription.
	*
	* @return the pp txn ID of this membership subscription
	*/
	@Override
	public java.lang.String getPpTxnId() {
		return _membershipSubscription.getPpTxnId();
	}

	/**
	* Sets the pp txn ID of this membership subscription.
	*
	* @param ppTxnId the pp txn ID of this membership subscription
	*/
	@Override
	public void setPpTxnId(java.lang.String ppTxnId) {
		_membershipSubscription.setPpTxnId(ppTxnId);
	}

	/**
	* Returns the pp payment status of this membership subscription.
	*
	* @return the pp payment status of this membership subscription
	*/
	@Override
	public java.lang.String getPpPaymentStatus() {
		return _membershipSubscription.getPpPaymentStatus();
	}

	/**
	* Sets the pp payment status of this membership subscription.
	*
	* @param ppPaymentStatus the pp payment status of this membership subscription
	*/
	@Override
	public void setPpPaymentStatus(java.lang.String ppPaymentStatus) {
		_membershipSubscription.setPpPaymentStatus(ppPaymentStatus);
	}

	/**
	* Returns the pp payment gross of this membership subscription.
	*
	* @return the pp payment gross of this membership subscription
	*/
	@Override
	public float getPpPaymentGross() {
		return _membershipSubscription.getPpPaymentGross();
	}

	/**
	* Sets the pp payment gross of this membership subscription.
	*
	* @param ppPaymentGross the pp payment gross of this membership subscription
	*/
	@Override
	public void setPpPaymentGross(float ppPaymentGross) {
		_membershipSubscription.setPpPaymentGross(ppPaymentGross);
	}

	/**
	* Returns the pp receiver email of this membership subscription.
	*
	* @return the pp receiver email of this membership subscription
	*/
	@Override
	public java.lang.String getPpReceiverEmail() {
		return _membershipSubscription.getPpReceiverEmail();
	}

	/**
	* Sets the pp receiver email of this membership subscription.
	*
	* @param ppReceiverEmail the pp receiver email of this membership subscription
	*/
	@Override
	public void setPpReceiverEmail(java.lang.String ppReceiverEmail) {
		_membershipSubscription.setPpReceiverEmail(ppReceiverEmail);
	}

	/**
	* Returns the pp payer email of this membership subscription.
	*
	* @return the pp payer email of this membership subscription
	*/
	@Override
	public java.lang.String getPpPayerEmail() {
		return _membershipSubscription.getPpPayerEmail();
	}

	/**
	* Sets the pp payer email of this membership subscription.
	*
	* @param ppPayerEmail the pp payer email of this membership subscription
	*/
	@Override
	public void setPpPayerEmail(java.lang.String ppPayerEmail) {
		_membershipSubscription.setPpPayerEmail(ppPayerEmail);
	}

	/**
	* Returns the send order email of this membership subscription.
	*
	* @return the send order email of this membership subscription
	*/
	@Override
	public java.lang.String getSendOrderEmail() {
		return _membershipSubscription.getSendOrderEmail();
	}

	/**
	* Sets the send order email of this membership subscription.
	*
	* @param sendOrderEmail the send order email of this membership subscription
	*/
	@Override
	public void setSendOrderEmail(java.lang.String sendOrderEmail) {
		_membershipSubscription.setSendOrderEmail(sendOrderEmail);
	}

	/**
	* Returns the send shipping email of this membership subscription.
	*
	* @return the send shipping email of this membership subscription
	*/
	@Override
	public java.lang.String getSendShippingEmail() {
		return _membershipSubscription.getSendShippingEmail();
	}

	/**
	* Sets the send shipping email of this membership subscription.
	*
	* @param sendShippingEmail the send shipping email of this membership subscription
	*/
	@Override
	public void setSendShippingEmail(java.lang.String sendShippingEmail) {
		_membershipSubscription.setSendShippingEmail(sendShippingEmail);
	}

	/**
	* Returns the effective from date of this membership subscription.
	*
	* @return the effective from date of this membership subscription
	*/
	@Override
	public java.util.Date getEffectiveFromDate() {
		return _membershipSubscription.getEffectiveFromDate();
	}

	/**
	* Sets the effective from date of this membership subscription.
	*
	* @param effectiveFromDate the effective from date of this membership subscription
	*/
	@Override
	public void setEffectiveFromDate(java.util.Date effectiveFromDate) {
		_membershipSubscription.setEffectiveFromDate(effectiveFromDate);
	}

	/**
	* Returns the effective to date of this membership subscription.
	*
	* @return the effective to date of this membership subscription
	*/
	@Override
	public java.util.Date getEffectiveToDate() {
		return _membershipSubscription.getEffectiveToDate();
	}

	/**
	* Sets the effective to date of this membership subscription.
	*
	* @param effectiveToDate the effective to date of this membership subscription
	*/
	@Override
	public void setEffectiveToDate(java.util.Date effectiveToDate) {
		_membershipSubscription.setEffectiveToDate(effectiveToDate);
	}

	/**
	* Returns the alt shipping of this membership subscription.
	*
	* @return the alt shipping of this membership subscription
	*/
	@Override
	public int getAltShipping() {
		return _membershipSubscription.getAltShipping();
	}

	/**
	* Sets the alt shipping of this membership subscription.
	*
	* @param altShipping the alt shipping of this membership subscription
	*/
	@Override
	public void setAltShipping(int altShipping) {
		_membershipSubscription.setAltShipping(altShipping);
	}

	/**
	* Returns the shipping of this membership subscription.
	*
	* @return the shipping of this membership subscription
	*/
	@Override
	public double getShipping() {
		return _membershipSubscription.getShipping();
	}

	/**
	* Sets the shipping of this membership subscription.
	*
	* @param shipping the shipping of this membership subscription
	*/
	@Override
	public void setShipping(double shipping) {
		_membershipSubscription.setShipping(shipping);
	}

	/**
	* Returns the requires shipping of this membership subscription.
	*
	* @return the requires shipping of this membership subscription
	*/
	@Override
	public boolean getRequiresShipping() {
		return _membershipSubscription.getRequiresShipping();
	}

	/**
	* Returns <code>true</code> if this membership subscription is requires shipping.
	*
	* @return <code>true</code> if this membership subscription is requires shipping; <code>false</code> otherwise
	*/
	@Override
	public boolean isRequiresShipping() {
		return _membershipSubscription.isRequiresShipping();
	}

	/**
	* Sets whether this membership subscription is requires shipping.
	*
	* @param requiresShipping the requires shipping of this membership subscription
	*/
	@Override
	public void setRequiresShipping(boolean requiresShipping) {
		_membershipSubscription.setRequiresShipping(requiresShipping);
	}

	/**
	* Returns the insure of this membership subscription.
	*
	* @return the insure of this membership subscription
	*/
	@Override
	public boolean getInsure() {
		return _membershipSubscription.getInsure();
	}

	/**
	* Returns <code>true</code> if this membership subscription is insure.
	*
	* @return <code>true</code> if this membership subscription is insure; <code>false</code> otherwise
	*/
	@Override
	public boolean isInsure() {
		return _membershipSubscription.isInsure();
	}

	/**
	* Sets whether this membership subscription is insure.
	*
	* @param insure the insure of this membership subscription
	*/
	@Override
	public void setInsure(boolean insure) {
		_membershipSubscription.setInsure(insure);
	}

	/**
	* Returns the insurance of this membership subscription.
	*
	* @return the insurance of this membership subscription
	*/
	@Override
	public double getInsurance() {
		return _membershipSubscription.getInsurance();
	}

	/**
	* Sets the insurance of this membership subscription.
	*
	* @param insurance the insurance of this membership subscription
	*/
	@Override
	public void setInsurance(double insurance) {
		_membershipSubscription.setInsurance(insurance);
	}

	/**
	* Returns the billing first name of this membership subscription.
	*
	* @return the billing first name of this membership subscription
	*/
	@Override
	public java.lang.String getBillingFirstName() {
		return _membershipSubscription.getBillingFirstName();
	}

	/**
	* Sets the billing first name of this membership subscription.
	*
	* @param billingFirstName the billing first name of this membership subscription
	*/
	@Override
	public void setBillingFirstName(java.lang.String billingFirstName) {
		_membershipSubscription.setBillingFirstName(billingFirstName);
	}

	/**
	* Returns the billing last name of this membership subscription.
	*
	* @return the billing last name of this membership subscription
	*/
	@Override
	public java.lang.String getBillingLastName() {
		return _membershipSubscription.getBillingLastName();
	}

	/**
	* Sets the billing last name of this membership subscription.
	*
	* @param billingLastName the billing last name of this membership subscription
	*/
	@Override
	public void setBillingLastName(java.lang.String billingLastName) {
		_membershipSubscription.setBillingLastName(billingLastName);
	}

	/**
	* Returns the billing email address of this membership subscription.
	*
	* @return the billing email address of this membership subscription
	*/
	@Override
	public java.lang.String getBillingEmailAddress() {
		return _membershipSubscription.getBillingEmailAddress();
	}

	/**
	* Sets the billing email address of this membership subscription.
	*
	* @param billingEmailAddress the billing email address of this membership subscription
	*/
	@Override
	public void setBillingEmailAddress(java.lang.String billingEmailAddress) {
		_membershipSubscription.setBillingEmailAddress(billingEmailAddress);
	}

	/**
	* Returns the billing company of this membership subscription.
	*
	* @return the billing company of this membership subscription
	*/
	@Override
	public java.lang.String getBillingCompany() {
		return _membershipSubscription.getBillingCompany();
	}

	/**
	* Sets the billing company of this membership subscription.
	*
	* @param billingCompany the billing company of this membership subscription
	*/
	@Override
	public void setBillingCompany(java.lang.String billingCompany) {
		_membershipSubscription.setBillingCompany(billingCompany);
	}

	/**
	* Returns the billing street of this membership subscription.
	*
	* @return the billing street of this membership subscription
	*/
	@Override
	public java.lang.String getBillingStreet() {
		return _membershipSubscription.getBillingStreet();
	}

	/**
	* Sets the billing street of this membership subscription.
	*
	* @param billingStreet the billing street of this membership subscription
	*/
	@Override
	public void setBillingStreet(java.lang.String billingStreet) {
		_membershipSubscription.setBillingStreet(billingStreet);
	}

	/**
	* Returns the billing city of this membership subscription.
	*
	* @return the billing city of this membership subscription
	*/
	@Override
	public java.lang.String getBillingCity() {
		return _membershipSubscription.getBillingCity();
	}

	/**
	* Sets the billing city of this membership subscription.
	*
	* @param billingCity the billing city of this membership subscription
	*/
	@Override
	public void setBillingCity(java.lang.String billingCity) {
		_membershipSubscription.setBillingCity(billingCity);
	}

	/**
	* Returns the billing state of this membership subscription.
	*
	* @return the billing state of this membership subscription
	*/
	@Override
	public java.lang.String getBillingState() {
		return _membershipSubscription.getBillingState();
	}

	/**
	* Sets the billing state of this membership subscription.
	*
	* @param billingState the billing state of this membership subscription
	*/
	@Override
	public void setBillingState(java.lang.String billingState) {
		_membershipSubscription.setBillingState(billingState);
	}

	/**
	* Returns the billing zip of this membership subscription.
	*
	* @return the billing zip of this membership subscription
	*/
	@Override
	public java.lang.String getBillingZip() {
		return _membershipSubscription.getBillingZip();
	}

	/**
	* Sets the billing zip of this membership subscription.
	*
	* @param billingZip the billing zip of this membership subscription
	*/
	@Override
	public void setBillingZip(java.lang.String billingZip) {
		_membershipSubscription.setBillingZip(billingZip);
	}

	/**
	* Returns the billing country of this membership subscription.
	*
	* @return the billing country of this membership subscription
	*/
	@Override
	public java.lang.String getBillingCountry() {
		return _membershipSubscription.getBillingCountry();
	}

	/**
	* Sets the billing country of this membership subscription.
	*
	* @param billingCountry the billing country of this membership subscription
	*/
	@Override
	public void setBillingCountry(java.lang.String billingCountry) {
		_membershipSubscription.setBillingCountry(billingCountry);
	}

	/**
	* Returns the billing phone of this membership subscription.
	*
	* @return the billing phone of this membership subscription
	*/
	@Override
	public java.lang.String getBillingPhone() {
		return _membershipSubscription.getBillingPhone();
	}

	/**
	* Sets the billing phone of this membership subscription.
	*
	* @param billingPhone the billing phone of this membership subscription
	*/
	@Override
	public void setBillingPhone(java.lang.String billingPhone) {
		_membershipSubscription.setBillingPhone(billingPhone);
	}

	/**
	* Returns the ship to billing of this membership subscription.
	*
	* @return the ship to billing of this membership subscription
	*/
	@Override
	public boolean getShipToBilling() {
		return _membershipSubscription.getShipToBilling();
	}

	/**
	* Returns <code>true</code> if this membership subscription is ship to billing.
	*
	* @return <code>true</code> if this membership subscription is ship to billing; <code>false</code> otherwise
	*/
	@Override
	public boolean isShipToBilling() {
		return _membershipSubscription.isShipToBilling();
	}

	/**
	* Sets whether this membership subscription is ship to billing.
	*
	* @param shipToBilling the ship to billing of this membership subscription
	*/
	@Override
	public void setShipToBilling(boolean shipToBilling) {
		_membershipSubscription.setShipToBilling(shipToBilling);
	}

	/**
	* Returns the shipping first name of this membership subscription.
	*
	* @return the shipping first name of this membership subscription
	*/
	@Override
	public java.lang.String getShippingFirstName() {
		return _membershipSubscription.getShippingFirstName();
	}

	/**
	* Sets the shipping first name of this membership subscription.
	*
	* @param shippingFirstName the shipping first name of this membership subscription
	*/
	@Override
	public void setShippingFirstName(java.lang.String shippingFirstName) {
		_membershipSubscription.setShippingFirstName(shippingFirstName);
	}

	/**
	* Returns the shipping last name of this membership subscription.
	*
	* @return the shipping last name of this membership subscription
	*/
	@Override
	public java.lang.String getShippingLastName() {
		return _membershipSubscription.getShippingLastName();
	}

	/**
	* Sets the shipping last name of this membership subscription.
	*
	* @param shippingLastName the shipping last name of this membership subscription
	*/
	@Override
	public void setShippingLastName(java.lang.String shippingLastName) {
		_membershipSubscription.setShippingLastName(shippingLastName);
	}

	/**
	* Returns the shipping email address of this membership subscription.
	*
	* @return the shipping email address of this membership subscription
	*/
	@Override
	public java.lang.String getShippingEmailAddress() {
		return _membershipSubscription.getShippingEmailAddress();
	}

	/**
	* Sets the shipping email address of this membership subscription.
	*
	* @param shippingEmailAddress the shipping email address of this membership subscription
	*/
	@Override
	public void setShippingEmailAddress(java.lang.String shippingEmailAddress) {
		_membershipSubscription.setShippingEmailAddress(shippingEmailAddress);
	}

	/**
	* Returns the shipping company of this membership subscription.
	*
	* @return the shipping company of this membership subscription
	*/
	@Override
	public java.lang.String getShippingCompany() {
		return _membershipSubscription.getShippingCompany();
	}

	/**
	* Sets the shipping company of this membership subscription.
	*
	* @param shippingCompany the shipping company of this membership subscription
	*/
	@Override
	public void setShippingCompany(java.lang.String shippingCompany) {
		_membershipSubscription.setShippingCompany(shippingCompany);
	}

	/**
	* Returns the shipping street of this membership subscription.
	*
	* @return the shipping street of this membership subscription
	*/
	@Override
	public java.lang.String getShippingStreet() {
		return _membershipSubscription.getShippingStreet();
	}

	/**
	* Sets the shipping street of this membership subscription.
	*
	* @param shippingStreet the shipping street of this membership subscription
	*/
	@Override
	public void setShippingStreet(java.lang.String shippingStreet) {
		_membershipSubscription.setShippingStreet(shippingStreet);
	}

	/**
	* Returns the shipping city of this membership subscription.
	*
	* @return the shipping city of this membership subscription
	*/
	@Override
	public java.lang.String getShippingCity() {
		return _membershipSubscription.getShippingCity();
	}

	/**
	* Sets the shipping city of this membership subscription.
	*
	* @param shippingCity the shipping city of this membership subscription
	*/
	@Override
	public void setShippingCity(java.lang.String shippingCity) {
		_membershipSubscription.setShippingCity(shippingCity);
	}

	/**
	* Returns the shipping state of this membership subscription.
	*
	* @return the shipping state of this membership subscription
	*/
	@Override
	public java.lang.String getShippingState() {
		return _membershipSubscription.getShippingState();
	}

	/**
	* Sets the shipping state of this membership subscription.
	*
	* @param shippingState the shipping state of this membership subscription
	*/
	@Override
	public void setShippingState(java.lang.String shippingState) {
		_membershipSubscription.setShippingState(shippingState);
	}

	/**
	* Returns the shipping zip of this membership subscription.
	*
	* @return the shipping zip of this membership subscription
	*/
	@Override
	public java.lang.String getShippingZip() {
		return _membershipSubscription.getShippingZip();
	}

	/**
	* Sets the shipping zip of this membership subscription.
	*
	* @param shippingZip the shipping zip of this membership subscription
	*/
	@Override
	public void setShippingZip(java.lang.String shippingZip) {
		_membershipSubscription.setShippingZip(shippingZip);
	}

	/**
	* Returns the shipping country of this membership subscription.
	*
	* @return the shipping country of this membership subscription
	*/
	@Override
	public java.lang.String getShippingCountry() {
		return _membershipSubscription.getShippingCountry();
	}

	/**
	* Sets the shipping country of this membership subscription.
	*
	* @param shippingCountry the shipping country of this membership subscription
	*/
	@Override
	public void setShippingCountry(java.lang.String shippingCountry) {
		_membershipSubscription.setShippingCountry(shippingCountry);
	}

	/**
	* Returns the shipping phone of this membership subscription.
	*
	* @return the shipping phone of this membership subscription
	*/
	@Override
	public java.lang.String getShippingPhone() {
		return _membershipSubscription.getShippingPhone();
	}

	/**
	* Sets the shipping phone of this membership subscription.
	*
	* @param shippingPhone the shipping phone of this membership subscription
	*/
	@Override
	public void setShippingPhone(java.lang.String shippingPhone) {
		_membershipSubscription.setShippingPhone(shippingPhone);
	}

	/**
	* Returns the cc name of this membership subscription.
	*
	* @return the cc name of this membership subscription
	*/
	@Override
	public java.lang.String getCcName() {
		return _membershipSubscription.getCcName();
	}

	/**
	* Sets the cc name of this membership subscription.
	*
	* @param ccName the cc name of this membership subscription
	*/
	@Override
	public void setCcName(java.lang.String ccName) {
		_membershipSubscription.setCcName(ccName);
	}

	/**
	* Returns the cc type of this membership subscription.
	*
	* @return the cc type of this membership subscription
	*/
	@Override
	public java.lang.String getCcType() {
		return _membershipSubscription.getCcType();
	}

	/**
	* Sets the cc type of this membership subscription.
	*
	* @param ccType the cc type of this membership subscription
	*/
	@Override
	public void setCcType(java.lang.String ccType) {
		_membershipSubscription.setCcType(ccType);
	}

	/**
	* Returns the cc number of this membership subscription.
	*
	* @return the cc number of this membership subscription
	*/
	@Override
	public java.lang.String getCcNumber() {
		return _membershipSubscription.getCcNumber();
	}

	/**
	* Sets the cc number of this membership subscription.
	*
	* @param ccNumber the cc number of this membership subscription
	*/
	@Override
	public void setCcNumber(java.lang.String ccNumber) {
		_membershipSubscription.setCcNumber(ccNumber);
	}

	/**
	* Returns the cc exp month of this membership subscription.
	*
	* @return the cc exp month of this membership subscription
	*/
	@Override
	public int getCcExpMonth() {
		return _membershipSubscription.getCcExpMonth();
	}

	/**
	* Sets the cc exp month of this membership subscription.
	*
	* @param ccExpMonth the cc exp month of this membership subscription
	*/
	@Override
	public void setCcExpMonth(int ccExpMonth) {
		_membershipSubscription.setCcExpMonth(ccExpMonth);
	}

	/**
	* Returns the cc exp year of this membership subscription.
	*
	* @return the cc exp year of this membership subscription
	*/
	@Override
	public int getCcExpYear() {
		return _membershipSubscription.getCcExpYear();
	}

	/**
	* Sets the cc exp year of this membership subscription.
	*
	* @param ccExpYear the cc exp year of this membership subscription
	*/
	@Override
	public void setCcExpYear(int ccExpYear) {
		_membershipSubscription.setCcExpYear(ccExpYear);
	}

	/**
	* Returns the cc ver number of this membership subscription.
	*
	* @return the cc ver number of this membership subscription
	*/
	@Override
	public java.lang.String getCcVerNumber() {
		return _membershipSubscription.getCcVerNumber();
	}

	/**
	* Sets the cc ver number of this membership subscription.
	*
	* @param ccVerNumber the cc ver number of this membership subscription
	*/
	@Override
	public void setCcVerNumber(java.lang.String ccVerNumber) {
		_membershipSubscription.setCcVerNumber(ccVerNumber);
	}

	/**
	* Returns the group ID of this membership subscription.
	*
	* @return the group ID of this membership subscription
	*/
	@Override
	public long getGroupId() {
		return _membershipSubscription.getGroupId();
	}

	/**
	* Sets the group ID of this membership subscription.
	*
	* @param groupId the group ID of this membership subscription
	*/
	@Override
	public void setGroupId(long groupId) {
		_membershipSubscription.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this membership subscription.
	*
	* @return the company ID of this membership subscription
	*/
	@Override
	public long getCompanyId() {
		return _membershipSubscription.getCompanyId();
	}

	/**
	* Sets the company ID of this membership subscription.
	*
	* @param companyId the company ID of this membership subscription
	*/
	@Override
	public void setCompanyId(long companyId) {
		_membershipSubscription.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this membership subscription.
	*
	* @return the user ID of this membership subscription
	*/
	@Override
	public long getUserId() {
		return _membershipSubscription.getUserId();
	}

	/**
	* Sets the user ID of this membership subscription.
	*
	* @param userId the user ID of this membership subscription
	*/
	@Override
	public void setUserId(long userId) {
		_membershipSubscription.setUserId(userId);
	}

	/**
	* Returns the user uuid of this membership subscription.
	*
	* @return the user uuid of this membership subscription
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscription.getUserUuid();
	}

	/**
	* Sets the user uuid of this membership subscription.
	*
	* @param userUuid the user uuid of this membership subscription
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_membershipSubscription.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this membership subscription.
	*
	* @return the user name of this membership subscription
	*/
	@Override
	public java.lang.String getUserName() {
		return _membershipSubscription.getUserName();
	}

	/**
	* Sets the user name of this membership subscription.
	*
	* @param userName the user name of this membership subscription
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_membershipSubscription.setUserName(userName);
	}

	/**
	* Returns the create date of this membership subscription.
	*
	* @return the create date of this membership subscription
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _membershipSubscription.getCreateDate();
	}

	/**
	* Sets the create date of this membership subscription.
	*
	* @param createDate the create date of this membership subscription
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_membershipSubscription.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this membership subscription.
	*
	* @return the modified date of this membership subscription
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _membershipSubscription.getModifiedDate();
	}

	/**
	* Sets the modified date of this membership subscription.
	*
	* @param modifiedDate the modified date of this membership subscription
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_membershipSubscription.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _membershipSubscription.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_membershipSubscription.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _membershipSubscription.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_membershipSubscription.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _membershipSubscription.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _membershipSubscription.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_membershipSubscription.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _membershipSubscription.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_membershipSubscription.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_membershipSubscription.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_membershipSubscription.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MembershipSubscriptionWrapper((MembershipSubscription)_membershipSubscription.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.MembershipSubscription membershipSubscription) {
		return _membershipSubscription.compareTo(membershipSubscription);
	}

	@Override
	public int hashCode() {
		return _membershipSubscription.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.MembershipSubscription> toCacheModel() {
		return _membershipSubscription.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription toEscapedModel() {
		return new MembershipSubscriptionWrapper(_membershipSubscription.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription toUnescapedModel() {
		return new MembershipSubscriptionWrapper(_membershipSubscription.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _membershipSubscription.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _membershipSubscription.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipSubscription.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MembershipSubscriptionWrapper)) {
			return false;
		}

		MembershipSubscriptionWrapper membershipSubscriptionWrapper = (MembershipSubscriptionWrapper)obj;

		if (Validator.equals(_membershipSubscription,
					membershipSubscriptionWrapper._membershipSubscription)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MembershipSubscription getWrappedMembershipSubscription() {
		return _membershipSubscription;
	}

	@Override
	public MembershipSubscription getWrappedModel() {
		return _membershipSubscription;
	}

	@Override
	public void resetOriginalValues() {
		_membershipSubscription.resetOriginalValues();
	}

	private MembershipSubscription _membershipSubscription;
}