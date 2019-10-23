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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class MembershipSubscriptionSoap implements Serializable {
	public static MembershipSubscriptionSoap toSoapModel(
		MembershipSubscription model) {
		MembershipSubscriptionSoap soapModel = new MembershipSubscriptionSoap();

		soapModel.setMsId(model.getMsId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setMporder_1(model.getMporder_1());
		soapModel.setMpId_1(model.getMpId_1());
		soapModel.setMpName_1(model.getMpName_1());
		soapModel.setMpQty_1(model.getMpQty_1());
		soapModel.setMpPrice_1(model.getMpPrice_1());
		soapModel.setMpPriceCurrency_1(model.getMpPriceCurrency_1());
		soapModel.setMporder_2(model.getMporder_2());
		soapModel.setMpId_2(model.getMpId_2());
		soapModel.setMpName_2(model.getMpName_2());
		soapModel.setMpQty_2(model.getMpQty_2());
		soapModel.setMpPrice_2(model.getMpPrice_2());
		soapModel.setMpPriceCurrency_2(model.getMpPriceCurrency_2());
		soapModel.setMporder_3(model.getMporder_3());
		soapModel.setMpId_3(model.getMpId_3());
		soapModel.setMpName_3(model.getMpName_3());
		soapModel.setMpQty_3(model.getMpQty_3());
		soapModel.setMpPrice_3(model.getMpPrice_3());
		soapModel.setMpPriceCurrency_3(model.getMpPriceCurrency_3());
		soapModel.setMporder_4(model.getMporder_4());
		soapModel.setMpId_4(model.getMpId_4());
		soapModel.setMpName_4(model.getMpName_4());
		soapModel.setMpQty_4(model.getMpQty_4());
		soapModel.setMpPrice_4(model.getMpPrice_4());
		soapModel.setMpPriceCurrency_4(model.getMpPriceCurrency_4());
		soapModel.setMpSubtotal(model.getMpSubtotal());
		soapModel.setMpSubtotalCurrency(model.getMpSubtotalCurrency());
		soapModel.setAddOnSubtotal(model.getAddOnSubtotal());
		soapModel.setAddOnSubtotalCurrency(model.getAddOnSubtotalCurrency());
		soapModel.setTax(model.getTax());
		soapModel.setComments(model.getComments());
		soapModel.setPromotionCode(model.getPromotionCode());
		soapModel.setPromotionFrom(model.getPromotionFrom());
		soapModel.setPromotionTo(model.getPromotionTo());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setNettotal(model.getNettotal());
		soapModel.setNettotalCurrency(model.getNettotalCurrency());
		soapModel.setPpTxnId(model.getPpTxnId());
		soapModel.setPpPaymentStatus(model.getPpPaymentStatus());
		soapModel.setPpPaymentGross(model.getPpPaymentGross());
		soapModel.setPpReceiverEmail(model.getPpReceiverEmail());
		soapModel.setPpPayerEmail(model.getPpPayerEmail());
		soapModel.setSendOrderEmail(model.getSendOrderEmail());
		soapModel.setSendShippingEmail(model.getSendShippingEmail());
		soapModel.setEffectiveFromDate(model.getEffectiveFromDate());
		soapModel.setEffectiveToDate(model.getEffectiveToDate());
		soapModel.setAltShipping(model.getAltShipping());
		soapModel.setShipping(model.getShipping());
		soapModel.setRequiresShipping(model.getRequiresShipping());
		soapModel.setInsure(model.getInsure());
		soapModel.setInsurance(model.getInsurance());
		soapModel.setBillingFirstName(model.getBillingFirstName());
		soapModel.setBillingLastName(model.getBillingLastName());
		soapModel.setBillingEmailAddress(model.getBillingEmailAddress());
		soapModel.setBillingCompany(model.getBillingCompany());
		soapModel.setBillingStreet(model.getBillingStreet());
		soapModel.setBillingCity(model.getBillingCity());
		soapModel.setBillingState(model.getBillingState());
		soapModel.setBillingZip(model.getBillingZip());
		soapModel.setBillingCountry(model.getBillingCountry());
		soapModel.setBillingPhone(model.getBillingPhone());
		soapModel.setShipToBilling(model.getShipToBilling());
		soapModel.setShippingFirstName(model.getShippingFirstName());
		soapModel.setShippingLastName(model.getShippingLastName());
		soapModel.setShippingEmailAddress(model.getShippingEmailAddress());
		soapModel.setShippingCompany(model.getShippingCompany());
		soapModel.setShippingStreet(model.getShippingStreet());
		soapModel.setShippingCity(model.getShippingCity());
		soapModel.setShippingState(model.getShippingState());
		soapModel.setShippingZip(model.getShippingZip());
		soapModel.setShippingCountry(model.getShippingCountry());
		soapModel.setShippingPhone(model.getShippingPhone());
		soapModel.setCcName(model.getCcName());
		soapModel.setCcType(model.getCcType());
		soapModel.setCcNumber(model.getCcNumber());
		soapModel.setCcExpMonth(model.getCcExpMonth());
		soapModel.setCcExpYear(model.getCcExpYear());
		soapModel.setCcVerNumber(model.getCcVerNumber());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MembershipSubscriptionSoap[] toSoapModels(
		MembershipSubscription[] models) {
		MembershipSubscriptionSoap[] soapModels = new MembershipSubscriptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MembershipSubscriptionSoap[][] toSoapModels(
		MembershipSubscription[][] models) {
		MembershipSubscriptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MembershipSubscriptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MembershipSubscriptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MembershipSubscriptionSoap[] toSoapModels(
		List<MembershipSubscription> models) {
		List<MembershipSubscriptionSoap> soapModels = new ArrayList<MembershipSubscriptionSoap>(models.size());

		for (MembershipSubscription model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MembershipSubscriptionSoap[soapModels.size()]);
	}

	public MembershipSubscriptionSoap() {
	}

	public long getPrimaryKey() {
		return _msId;
	}

	public void setPrimaryKey(long pk) {
		setMsId(pk);
	}

	public long getMsId() {
		return _msId;
	}

	public void setMsId(long msId) {
		_msId = msId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getMporder_1() {
		return _mporder_1;
	}

	public void setMporder_1(String mporder_1) {
		_mporder_1 = mporder_1;
	}

	public String getMpId_1() {
		return _mpId_1;
	}

	public void setMpId_1(String mpId_1) {
		_mpId_1 = mpId_1;
	}

	public String getMpName_1() {
		return _mpName_1;
	}

	public void setMpName_1(String mpName_1) {
		_mpName_1 = mpName_1;
	}

	public int getMpQty_1() {
		return _mpQty_1;
	}

	public void setMpQty_1(int mpQty_1) {
		_mpQty_1 = mpQty_1;
	}

	public float getMpPrice_1() {
		return _mpPrice_1;
	}

	public void setMpPrice_1(float mpPrice_1) {
		_mpPrice_1 = mpPrice_1;
	}

	public String getMpPriceCurrency_1() {
		return _mpPriceCurrency_1;
	}

	public void setMpPriceCurrency_1(String mpPriceCurrency_1) {
		_mpPriceCurrency_1 = mpPriceCurrency_1;
	}

	public String getMporder_2() {
		return _mporder_2;
	}

	public void setMporder_2(String mporder_2) {
		_mporder_2 = mporder_2;
	}

	public String getMpId_2() {
		return _mpId_2;
	}

	public void setMpId_2(String mpId_2) {
		_mpId_2 = mpId_2;
	}

	public String getMpName_2() {
		return _mpName_2;
	}

	public void setMpName_2(String mpName_2) {
		_mpName_2 = mpName_2;
	}

	public int getMpQty_2() {
		return _mpQty_2;
	}

	public void setMpQty_2(int mpQty_2) {
		_mpQty_2 = mpQty_2;
	}

	public float getMpPrice_2() {
		return _mpPrice_2;
	}

	public void setMpPrice_2(float mpPrice_2) {
		_mpPrice_2 = mpPrice_2;
	}

	public String getMpPriceCurrency_2() {
		return _mpPriceCurrency_2;
	}

	public void setMpPriceCurrency_2(String mpPriceCurrency_2) {
		_mpPriceCurrency_2 = mpPriceCurrency_2;
	}

	public String getMporder_3() {
		return _mporder_3;
	}

	public void setMporder_3(String mporder_3) {
		_mporder_3 = mporder_3;
	}

	public String getMpId_3() {
		return _mpId_3;
	}

	public void setMpId_3(String mpId_3) {
		_mpId_3 = mpId_3;
	}

	public String getMpName_3() {
		return _mpName_3;
	}

	public void setMpName_3(String mpName_3) {
		_mpName_3 = mpName_3;
	}

	public int getMpQty_3() {
		return _mpQty_3;
	}

	public void setMpQty_3(int mpQty_3) {
		_mpQty_3 = mpQty_3;
	}

	public float getMpPrice_3() {
		return _mpPrice_3;
	}

	public void setMpPrice_3(float mpPrice_3) {
		_mpPrice_3 = mpPrice_3;
	}

	public String getMpPriceCurrency_3() {
		return _mpPriceCurrency_3;
	}

	public void setMpPriceCurrency_3(String mpPriceCurrency_3) {
		_mpPriceCurrency_3 = mpPriceCurrency_3;
	}

	public String getMporder_4() {
		return _mporder_4;
	}

	public void setMporder_4(String mporder_4) {
		_mporder_4 = mporder_4;
	}

	public String getMpId_4() {
		return _mpId_4;
	}

	public void setMpId_4(String mpId_4) {
		_mpId_4 = mpId_4;
	}

	public String getMpName_4() {
		return _mpName_4;
	}

	public void setMpName_4(String mpName_4) {
		_mpName_4 = mpName_4;
	}

	public int getMpQty_4() {
		return _mpQty_4;
	}

	public void setMpQty_4(int mpQty_4) {
		_mpQty_4 = mpQty_4;
	}

	public float getMpPrice_4() {
		return _mpPrice_4;
	}

	public void setMpPrice_4(float mpPrice_4) {
		_mpPrice_4 = mpPrice_4;
	}

	public String getMpPriceCurrency_4() {
		return _mpPriceCurrency_4;
	}

	public void setMpPriceCurrency_4(String mpPriceCurrency_4) {
		_mpPriceCurrency_4 = mpPriceCurrency_4;
	}

	public float getMpSubtotal() {
		return _mpSubtotal;
	}

	public void setMpSubtotal(float mpSubtotal) {
		_mpSubtotal = mpSubtotal;
	}

	public String getMpSubtotalCurrency() {
		return _mpSubtotalCurrency;
	}

	public void setMpSubtotalCurrency(String mpSubtotalCurrency) {
		_mpSubtotalCurrency = mpSubtotalCurrency;
	}

	public float getAddOnSubtotal() {
		return _addOnSubtotal;
	}

	public void setAddOnSubtotal(float addOnSubtotal) {
		_addOnSubtotal = addOnSubtotal;
	}

	public String getAddOnSubtotalCurrency() {
		return _addOnSubtotalCurrency;
	}

	public void setAddOnSubtotalCurrency(String addOnSubtotalCurrency) {
		_addOnSubtotalCurrency = addOnSubtotalCurrency;
	}

	public float getTax() {
		return _tax;
	}

	public void setTax(float tax) {
		_tax = tax;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getPromotionCode() {
		return _promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		_promotionCode = promotionCode;
	}

	public Date getPromotionFrom() {
		return _promotionFrom;
	}

	public void setPromotionFrom(Date promotionFrom) {
		_promotionFrom = promotionFrom;
	}

	public Date getPromotionTo() {
		return _promotionTo;
	}

	public void setPromotionTo(Date promotionTo) {
		_promotionTo = promotionTo;
	}

	public String getDiscount() {
		return _discount;
	}

	public void setDiscount(String discount) {
		_discount = discount;
	}

	public float getNettotal() {
		return _nettotal;
	}

	public void setNettotal(float nettotal) {
		_nettotal = nettotal;
	}

	public String getNettotalCurrency() {
		return _nettotalCurrency;
	}

	public void setNettotalCurrency(String nettotalCurrency) {
		_nettotalCurrency = nettotalCurrency;
	}

	public String getPpTxnId() {
		return _ppTxnId;
	}

	public void setPpTxnId(String ppTxnId) {
		_ppTxnId = ppTxnId;
	}

	public String getPpPaymentStatus() {
		return _ppPaymentStatus;
	}

	public void setPpPaymentStatus(String ppPaymentStatus) {
		_ppPaymentStatus = ppPaymentStatus;
	}

	public float getPpPaymentGross() {
		return _ppPaymentGross;
	}

	public void setPpPaymentGross(float ppPaymentGross) {
		_ppPaymentGross = ppPaymentGross;
	}

	public String getPpReceiverEmail() {
		return _ppReceiverEmail;
	}

	public void setPpReceiverEmail(String ppReceiverEmail) {
		_ppReceiverEmail = ppReceiverEmail;
	}

	public String getPpPayerEmail() {
		return _ppPayerEmail;
	}

	public void setPpPayerEmail(String ppPayerEmail) {
		_ppPayerEmail = ppPayerEmail;
	}

	public String getSendOrderEmail() {
		return _sendOrderEmail;
	}

	public void setSendOrderEmail(String sendOrderEmail) {
		_sendOrderEmail = sendOrderEmail;
	}

	public String getSendShippingEmail() {
		return _sendShippingEmail;
	}

	public void setSendShippingEmail(String sendShippingEmail) {
		_sendShippingEmail = sendShippingEmail;
	}

	public Date getEffectiveFromDate() {
		return _effectiveFromDate;
	}

	public void setEffectiveFromDate(Date effectiveFromDate) {
		_effectiveFromDate = effectiveFromDate;
	}

	public Date getEffectiveToDate() {
		return _effectiveToDate;
	}

	public void setEffectiveToDate(Date effectiveToDate) {
		_effectiveToDate = effectiveToDate;
	}

	public int getAltShipping() {
		return _altShipping;
	}

	public void setAltShipping(int altShipping) {
		_altShipping = altShipping;
	}

	public double getShipping() {
		return _shipping;
	}

	public void setShipping(double shipping) {
		_shipping = shipping;
	}

	public boolean getRequiresShipping() {
		return _requiresShipping;
	}

	public boolean isRequiresShipping() {
		return _requiresShipping;
	}

	public void setRequiresShipping(boolean requiresShipping) {
		_requiresShipping = requiresShipping;
	}

	public boolean getInsure() {
		return _insure;
	}

	public boolean isInsure() {
		return _insure;
	}

	public void setInsure(boolean insure) {
		_insure = insure;
	}

	public double getInsurance() {
		return _insurance;
	}

	public void setInsurance(double insurance) {
		_insurance = insurance;
	}

	public String getBillingFirstName() {
		return _billingFirstName;
	}

	public void setBillingFirstName(String billingFirstName) {
		_billingFirstName = billingFirstName;
	}

	public String getBillingLastName() {
		return _billingLastName;
	}

	public void setBillingLastName(String billingLastName) {
		_billingLastName = billingLastName;
	}

	public String getBillingEmailAddress() {
		return _billingEmailAddress;
	}

	public void setBillingEmailAddress(String billingEmailAddress) {
		_billingEmailAddress = billingEmailAddress;
	}

	public String getBillingCompany() {
		return _billingCompany;
	}

	public void setBillingCompany(String billingCompany) {
		_billingCompany = billingCompany;
	}

	public String getBillingStreet() {
		return _billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		_billingStreet = billingStreet;
	}

	public String getBillingCity() {
		return _billingCity;
	}

	public void setBillingCity(String billingCity) {
		_billingCity = billingCity;
	}

	public String getBillingState() {
		return _billingState;
	}

	public void setBillingState(String billingState) {
		_billingState = billingState;
	}

	public String getBillingZip() {
		return _billingZip;
	}

	public void setBillingZip(String billingZip) {
		_billingZip = billingZip;
	}

	public String getBillingCountry() {
		return _billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		_billingCountry = billingCountry;
	}

	public String getBillingPhone() {
		return _billingPhone;
	}

	public void setBillingPhone(String billingPhone) {
		_billingPhone = billingPhone;
	}

	public boolean getShipToBilling() {
		return _shipToBilling;
	}

	public boolean isShipToBilling() {
		return _shipToBilling;
	}

	public void setShipToBilling(boolean shipToBilling) {
		_shipToBilling = shipToBilling;
	}

	public String getShippingFirstName() {
		return _shippingFirstName;
	}

	public void setShippingFirstName(String shippingFirstName) {
		_shippingFirstName = shippingFirstName;
	}

	public String getShippingLastName() {
		return _shippingLastName;
	}

	public void setShippingLastName(String shippingLastName) {
		_shippingLastName = shippingLastName;
	}

	public String getShippingEmailAddress() {
		return _shippingEmailAddress;
	}

	public void setShippingEmailAddress(String shippingEmailAddress) {
		_shippingEmailAddress = shippingEmailAddress;
	}

	public String getShippingCompany() {
		return _shippingCompany;
	}

	public void setShippingCompany(String shippingCompany) {
		_shippingCompany = shippingCompany;
	}

	public String getShippingStreet() {
		return _shippingStreet;
	}

	public void setShippingStreet(String shippingStreet) {
		_shippingStreet = shippingStreet;
	}

	public String getShippingCity() {
		return _shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		_shippingCity = shippingCity;
	}

	public String getShippingState() {
		return _shippingState;
	}

	public void setShippingState(String shippingState) {
		_shippingState = shippingState;
	}

	public String getShippingZip() {
		return _shippingZip;
	}

	public void setShippingZip(String shippingZip) {
		_shippingZip = shippingZip;
	}

	public String getShippingCountry() {
		return _shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		_shippingCountry = shippingCountry;
	}

	public String getShippingPhone() {
		return _shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		_shippingPhone = shippingPhone;
	}

	public String getCcName() {
		return _ccName;
	}

	public void setCcName(String ccName) {
		_ccName = ccName;
	}

	public String getCcType() {
		return _ccType;
	}

	public void setCcType(String ccType) {
		_ccType = ccType;
	}

	public String getCcNumber() {
		return _ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		_ccNumber = ccNumber;
	}

	public int getCcExpMonth() {
		return _ccExpMonth;
	}

	public void setCcExpMonth(int ccExpMonth) {
		_ccExpMonth = ccExpMonth;
	}

	public int getCcExpYear() {
		return _ccExpYear;
	}

	public void setCcExpYear(int ccExpYear) {
		_ccExpYear = ccExpYear;
	}

	public String getCcVerNumber() {
		return _ccVerNumber;
	}

	public void setCcVerNumber(String ccVerNumber) {
		_ccVerNumber = ccVerNumber;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}