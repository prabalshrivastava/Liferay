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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.MembershipSubscription;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MembershipSubscription in entity cache.
 *
 * @author gauravvijayvergia
 * @see MembershipSubscription
 * @generated
 */
public class MembershipSubscriptionCacheModel implements CacheModel<MembershipSubscription>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(173);

		sb.append("{msId=");
		sb.append(msId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", mporder_1=");
		sb.append(mporder_1);
		sb.append(", mpId_1=");
		sb.append(mpId_1);
		sb.append(", mpName_1=");
		sb.append(mpName_1);
		sb.append(", mpQty_1=");
		sb.append(mpQty_1);
		sb.append(", mpPrice_1=");
		sb.append(mpPrice_1);
		sb.append(", mpPriceCurrency_1=");
		sb.append(mpPriceCurrency_1);
		sb.append(", mporder_2=");
		sb.append(mporder_2);
		sb.append(", mpId_2=");
		sb.append(mpId_2);
		sb.append(", mpName_2=");
		sb.append(mpName_2);
		sb.append(", mpQty_2=");
		sb.append(mpQty_2);
		sb.append(", mpPrice_2=");
		sb.append(mpPrice_2);
		sb.append(", mpPriceCurrency_2=");
		sb.append(mpPriceCurrency_2);
		sb.append(", mporder_3=");
		sb.append(mporder_3);
		sb.append(", mpId_3=");
		sb.append(mpId_3);
		sb.append(", mpName_3=");
		sb.append(mpName_3);
		sb.append(", mpQty_3=");
		sb.append(mpQty_3);
		sb.append(", mpPrice_3=");
		sb.append(mpPrice_3);
		sb.append(", mpPriceCurrency_3=");
		sb.append(mpPriceCurrency_3);
		sb.append(", mporder_4=");
		sb.append(mporder_4);
		sb.append(", mpId_4=");
		sb.append(mpId_4);
		sb.append(", mpName_4=");
		sb.append(mpName_4);
		sb.append(", mpQty_4=");
		sb.append(mpQty_4);
		sb.append(", mpPrice_4=");
		sb.append(mpPrice_4);
		sb.append(", mpPriceCurrency_4=");
		sb.append(mpPriceCurrency_4);
		sb.append(", mpSubtotal=");
		sb.append(mpSubtotal);
		sb.append(", mpSubtotalCurrency=");
		sb.append(mpSubtotalCurrency);
		sb.append(", addOnSubtotal=");
		sb.append(addOnSubtotal);
		sb.append(", addOnSubtotalCurrency=");
		sb.append(addOnSubtotalCurrency);
		sb.append(", tax=");
		sb.append(tax);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", promotionCode=");
		sb.append(promotionCode);
		sb.append(", promotionFrom=");
		sb.append(promotionFrom);
		sb.append(", promotionTo=");
		sb.append(promotionTo);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", nettotal=");
		sb.append(nettotal);
		sb.append(", nettotalCurrency=");
		sb.append(nettotalCurrency);
		sb.append(", ppTxnId=");
		sb.append(ppTxnId);
		sb.append(", ppPaymentStatus=");
		sb.append(ppPaymentStatus);
		sb.append(", ppPaymentGross=");
		sb.append(ppPaymentGross);
		sb.append(", ppReceiverEmail=");
		sb.append(ppReceiverEmail);
		sb.append(", ppPayerEmail=");
		sb.append(ppPayerEmail);
		sb.append(", sendOrderEmail=");
		sb.append(sendOrderEmail);
		sb.append(", sendShippingEmail=");
		sb.append(sendShippingEmail);
		sb.append(", effectiveFromDate=");
		sb.append(effectiveFromDate);
		sb.append(", effectiveToDate=");
		sb.append(effectiveToDate);
		sb.append(", altShipping=");
		sb.append(altShipping);
		sb.append(", shipping=");
		sb.append(shipping);
		sb.append(", requiresShipping=");
		sb.append(requiresShipping);
		sb.append(", insure=");
		sb.append(insure);
		sb.append(", insurance=");
		sb.append(insurance);
		sb.append(", billingFirstName=");
		sb.append(billingFirstName);
		sb.append(", billingLastName=");
		sb.append(billingLastName);
		sb.append(", billingEmailAddress=");
		sb.append(billingEmailAddress);
		sb.append(", billingCompany=");
		sb.append(billingCompany);
		sb.append(", billingStreet=");
		sb.append(billingStreet);
		sb.append(", billingCity=");
		sb.append(billingCity);
		sb.append(", billingState=");
		sb.append(billingState);
		sb.append(", billingZip=");
		sb.append(billingZip);
		sb.append(", billingCountry=");
		sb.append(billingCountry);
		sb.append(", billingPhone=");
		sb.append(billingPhone);
		sb.append(", shipToBilling=");
		sb.append(shipToBilling);
		sb.append(", shippingFirstName=");
		sb.append(shippingFirstName);
		sb.append(", shippingLastName=");
		sb.append(shippingLastName);
		sb.append(", shippingEmailAddress=");
		sb.append(shippingEmailAddress);
		sb.append(", shippingCompany=");
		sb.append(shippingCompany);
		sb.append(", shippingStreet=");
		sb.append(shippingStreet);
		sb.append(", shippingCity=");
		sb.append(shippingCity);
		sb.append(", shippingState=");
		sb.append(shippingState);
		sb.append(", shippingZip=");
		sb.append(shippingZip);
		sb.append(", shippingCountry=");
		sb.append(shippingCountry);
		sb.append(", shippingPhone=");
		sb.append(shippingPhone);
		sb.append(", ccName=");
		sb.append(ccName);
		sb.append(", ccType=");
		sb.append(ccType);
		sb.append(", ccNumber=");
		sb.append(ccNumber);
		sb.append(", ccExpMonth=");
		sb.append(ccExpMonth);
		sb.append(", ccExpYear=");
		sb.append(ccExpYear);
		sb.append(", ccVerNumber=");
		sb.append(ccVerNumber);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MembershipSubscription toEntityModel() {
		MembershipSubscriptionImpl membershipSubscriptionImpl = new MembershipSubscriptionImpl();

		membershipSubscriptionImpl.setMsId(msId);

		if (name == null) {
			membershipSubscriptionImpl.setName(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setName(name);
		}

		if (description == null) {
			membershipSubscriptionImpl.setDescription(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setDescription(description);
		}

		if (mporder_1 == null) {
			membershipSubscriptionImpl.setMporder_1(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMporder_1(mporder_1);
		}

		if (mpId_1 == null) {
			membershipSubscriptionImpl.setMpId_1(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpId_1(mpId_1);
		}

		if (mpName_1 == null) {
			membershipSubscriptionImpl.setMpName_1(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpName_1(mpName_1);
		}

		membershipSubscriptionImpl.setMpQty_1(mpQty_1);
		membershipSubscriptionImpl.setMpPrice_1(mpPrice_1);

		if (mpPriceCurrency_1 == null) {
			membershipSubscriptionImpl.setMpPriceCurrency_1(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpPriceCurrency_1(mpPriceCurrency_1);
		}

		if (mporder_2 == null) {
			membershipSubscriptionImpl.setMporder_2(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMporder_2(mporder_2);
		}

		if (mpId_2 == null) {
			membershipSubscriptionImpl.setMpId_2(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpId_2(mpId_2);
		}

		if (mpName_2 == null) {
			membershipSubscriptionImpl.setMpName_2(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpName_2(mpName_2);
		}

		membershipSubscriptionImpl.setMpQty_2(mpQty_2);
		membershipSubscriptionImpl.setMpPrice_2(mpPrice_2);

		if (mpPriceCurrency_2 == null) {
			membershipSubscriptionImpl.setMpPriceCurrency_2(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpPriceCurrency_2(mpPriceCurrency_2);
		}

		if (mporder_3 == null) {
			membershipSubscriptionImpl.setMporder_3(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMporder_3(mporder_3);
		}

		if (mpId_3 == null) {
			membershipSubscriptionImpl.setMpId_3(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpId_3(mpId_3);
		}

		if (mpName_3 == null) {
			membershipSubscriptionImpl.setMpName_3(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpName_3(mpName_3);
		}

		membershipSubscriptionImpl.setMpQty_3(mpQty_3);
		membershipSubscriptionImpl.setMpPrice_3(mpPrice_3);

		if (mpPriceCurrency_3 == null) {
			membershipSubscriptionImpl.setMpPriceCurrency_3(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpPriceCurrency_3(mpPriceCurrency_3);
		}

		if (mporder_4 == null) {
			membershipSubscriptionImpl.setMporder_4(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMporder_4(mporder_4);
		}

		if (mpId_4 == null) {
			membershipSubscriptionImpl.setMpId_4(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpId_4(mpId_4);
		}

		if (mpName_4 == null) {
			membershipSubscriptionImpl.setMpName_4(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpName_4(mpName_4);
		}

		membershipSubscriptionImpl.setMpQty_4(mpQty_4);
		membershipSubscriptionImpl.setMpPrice_4(mpPrice_4);

		if (mpPriceCurrency_4 == null) {
			membershipSubscriptionImpl.setMpPriceCurrency_4(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpPriceCurrency_4(mpPriceCurrency_4);
		}

		membershipSubscriptionImpl.setMpSubtotal(mpSubtotal);

		if (mpSubtotalCurrency == null) {
			membershipSubscriptionImpl.setMpSubtotalCurrency(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setMpSubtotalCurrency(mpSubtotalCurrency);
		}

		membershipSubscriptionImpl.setAddOnSubtotal(addOnSubtotal);

		if (addOnSubtotalCurrency == null) {
			membershipSubscriptionImpl.setAddOnSubtotalCurrency(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setAddOnSubtotalCurrency(addOnSubtotalCurrency);
		}

		membershipSubscriptionImpl.setTax(tax);

		if (comments == null) {
			membershipSubscriptionImpl.setComments(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setComments(comments);
		}

		if (promotionCode == null) {
			membershipSubscriptionImpl.setPromotionCode(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setPromotionCode(promotionCode);
		}

		if (promotionFrom == Long.MIN_VALUE) {
			membershipSubscriptionImpl.setPromotionFrom(null);
		}
		else {
			membershipSubscriptionImpl.setPromotionFrom(new Date(promotionFrom));
		}

		if (promotionTo == Long.MIN_VALUE) {
			membershipSubscriptionImpl.setPromotionTo(null);
		}
		else {
			membershipSubscriptionImpl.setPromotionTo(new Date(promotionTo));
		}

		if (discount == null) {
			membershipSubscriptionImpl.setDiscount(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setDiscount(discount);
		}

		membershipSubscriptionImpl.setNettotal(nettotal);

		if (nettotalCurrency == null) {
			membershipSubscriptionImpl.setNettotalCurrency(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setNettotalCurrency(nettotalCurrency);
		}

		if (ppTxnId == null) {
			membershipSubscriptionImpl.setPpTxnId(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setPpTxnId(ppTxnId);
		}

		if (ppPaymentStatus == null) {
			membershipSubscriptionImpl.setPpPaymentStatus(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setPpPaymentStatus(ppPaymentStatus);
		}

		membershipSubscriptionImpl.setPpPaymentGross(ppPaymentGross);

		if (ppReceiverEmail == null) {
			membershipSubscriptionImpl.setPpReceiverEmail(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setPpReceiverEmail(ppReceiverEmail);
		}

		if (ppPayerEmail == null) {
			membershipSubscriptionImpl.setPpPayerEmail(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setPpPayerEmail(ppPayerEmail);
		}

		if (sendOrderEmail == null) {
			membershipSubscriptionImpl.setSendOrderEmail(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setSendOrderEmail(sendOrderEmail);
		}

		if (sendShippingEmail == null) {
			membershipSubscriptionImpl.setSendShippingEmail(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setSendShippingEmail(sendShippingEmail);
		}

		if (effectiveFromDate == Long.MIN_VALUE) {
			membershipSubscriptionImpl.setEffectiveFromDate(null);
		}
		else {
			membershipSubscriptionImpl.setEffectiveFromDate(new Date(
					effectiveFromDate));
		}

		if (effectiveToDate == Long.MIN_VALUE) {
			membershipSubscriptionImpl.setEffectiveToDate(null);
		}
		else {
			membershipSubscriptionImpl.setEffectiveToDate(new Date(
					effectiveToDate));
		}

		membershipSubscriptionImpl.setAltShipping(altShipping);
		membershipSubscriptionImpl.setShipping(shipping);
		membershipSubscriptionImpl.setRequiresShipping(requiresShipping);
		membershipSubscriptionImpl.setInsure(insure);
		membershipSubscriptionImpl.setInsurance(insurance);

		if (billingFirstName == null) {
			membershipSubscriptionImpl.setBillingFirstName(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingFirstName(billingFirstName);
		}

		if (billingLastName == null) {
			membershipSubscriptionImpl.setBillingLastName(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingLastName(billingLastName);
		}

		if (billingEmailAddress == null) {
			membershipSubscriptionImpl.setBillingEmailAddress(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingEmailAddress(billingEmailAddress);
		}

		if (billingCompany == null) {
			membershipSubscriptionImpl.setBillingCompany(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingCompany(billingCompany);
		}

		if (billingStreet == null) {
			membershipSubscriptionImpl.setBillingStreet(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingStreet(billingStreet);
		}

		if (billingCity == null) {
			membershipSubscriptionImpl.setBillingCity(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingCity(billingCity);
		}

		if (billingState == null) {
			membershipSubscriptionImpl.setBillingState(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingState(billingState);
		}

		if (billingZip == null) {
			membershipSubscriptionImpl.setBillingZip(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingZip(billingZip);
		}

		if (billingCountry == null) {
			membershipSubscriptionImpl.setBillingCountry(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingCountry(billingCountry);
		}

		if (billingPhone == null) {
			membershipSubscriptionImpl.setBillingPhone(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setBillingPhone(billingPhone);
		}

		membershipSubscriptionImpl.setShipToBilling(shipToBilling);

		if (shippingFirstName == null) {
			membershipSubscriptionImpl.setShippingFirstName(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingFirstName(shippingFirstName);
		}

		if (shippingLastName == null) {
			membershipSubscriptionImpl.setShippingLastName(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingLastName(shippingLastName);
		}

		if (shippingEmailAddress == null) {
			membershipSubscriptionImpl.setShippingEmailAddress(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingEmailAddress(shippingEmailAddress);
		}

		if (shippingCompany == null) {
			membershipSubscriptionImpl.setShippingCompany(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingCompany(shippingCompany);
		}

		if (shippingStreet == null) {
			membershipSubscriptionImpl.setShippingStreet(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingStreet(shippingStreet);
		}

		if (shippingCity == null) {
			membershipSubscriptionImpl.setShippingCity(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingCity(shippingCity);
		}

		if (shippingState == null) {
			membershipSubscriptionImpl.setShippingState(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingState(shippingState);
		}

		if (shippingZip == null) {
			membershipSubscriptionImpl.setShippingZip(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingZip(shippingZip);
		}

		if (shippingCountry == null) {
			membershipSubscriptionImpl.setShippingCountry(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingCountry(shippingCountry);
		}

		if (shippingPhone == null) {
			membershipSubscriptionImpl.setShippingPhone(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setShippingPhone(shippingPhone);
		}

		if (ccName == null) {
			membershipSubscriptionImpl.setCcName(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setCcName(ccName);
		}

		if (ccType == null) {
			membershipSubscriptionImpl.setCcType(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setCcType(ccType);
		}

		if (ccNumber == null) {
			membershipSubscriptionImpl.setCcNumber(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setCcNumber(ccNumber);
		}

		membershipSubscriptionImpl.setCcExpMonth(ccExpMonth);
		membershipSubscriptionImpl.setCcExpYear(ccExpYear);

		if (ccVerNumber == null) {
			membershipSubscriptionImpl.setCcVerNumber(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setCcVerNumber(ccVerNumber);
		}

		membershipSubscriptionImpl.setGroupId(groupId);
		membershipSubscriptionImpl.setCompanyId(companyId);
		membershipSubscriptionImpl.setUserId(userId);

		if (userName == null) {
			membershipSubscriptionImpl.setUserName(StringPool.BLANK);
		}
		else {
			membershipSubscriptionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			membershipSubscriptionImpl.setCreateDate(null);
		}
		else {
			membershipSubscriptionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			membershipSubscriptionImpl.setModifiedDate(null);
		}
		else {
			membershipSubscriptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		membershipSubscriptionImpl.resetOriginalValues();

		return membershipSubscriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		msId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		mporder_1 = objectInput.readUTF();
		mpId_1 = objectInput.readUTF();
		mpName_1 = objectInput.readUTF();
		mpQty_1 = objectInput.readInt();
		mpPrice_1 = objectInput.readFloat();
		mpPriceCurrency_1 = objectInput.readUTF();
		mporder_2 = objectInput.readUTF();
		mpId_2 = objectInput.readUTF();
		mpName_2 = objectInput.readUTF();
		mpQty_2 = objectInput.readInt();
		mpPrice_2 = objectInput.readFloat();
		mpPriceCurrency_2 = objectInput.readUTF();
		mporder_3 = objectInput.readUTF();
		mpId_3 = objectInput.readUTF();
		mpName_3 = objectInput.readUTF();
		mpQty_3 = objectInput.readInt();
		mpPrice_3 = objectInput.readFloat();
		mpPriceCurrency_3 = objectInput.readUTF();
		mporder_4 = objectInput.readUTF();
		mpId_4 = objectInput.readUTF();
		mpName_4 = objectInput.readUTF();
		mpQty_4 = objectInput.readInt();
		mpPrice_4 = objectInput.readFloat();
		mpPriceCurrency_4 = objectInput.readUTF();
		mpSubtotal = objectInput.readFloat();
		mpSubtotalCurrency = objectInput.readUTF();
		addOnSubtotal = objectInput.readFloat();
		addOnSubtotalCurrency = objectInput.readUTF();
		tax = objectInput.readFloat();
		comments = objectInput.readUTF();
		promotionCode = objectInput.readUTF();
		promotionFrom = objectInput.readLong();
		promotionTo = objectInput.readLong();
		discount = objectInput.readUTF();
		nettotal = objectInput.readFloat();
		nettotalCurrency = objectInput.readUTF();
		ppTxnId = objectInput.readUTF();
		ppPaymentStatus = objectInput.readUTF();
		ppPaymentGross = objectInput.readFloat();
		ppReceiverEmail = objectInput.readUTF();
		ppPayerEmail = objectInput.readUTF();
		sendOrderEmail = objectInput.readUTF();
		sendShippingEmail = objectInput.readUTF();
		effectiveFromDate = objectInput.readLong();
		effectiveToDate = objectInput.readLong();
		altShipping = objectInput.readInt();
		shipping = objectInput.readDouble();
		requiresShipping = objectInput.readBoolean();
		insure = objectInput.readBoolean();
		insurance = objectInput.readDouble();
		billingFirstName = objectInput.readUTF();
		billingLastName = objectInput.readUTF();
		billingEmailAddress = objectInput.readUTF();
		billingCompany = objectInput.readUTF();
		billingStreet = objectInput.readUTF();
		billingCity = objectInput.readUTF();
		billingState = objectInput.readUTF();
		billingZip = objectInput.readUTF();
		billingCountry = objectInput.readUTF();
		billingPhone = objectInput.readUTF();
		shipToBilling = objectInput.readBoolean();
		shippingFirstName = objectInput.readUTF();
		shippingLastName = objectInput.readUTF();
		shippingEmailAddress = objectInput.readUTF();
		shippingCompany = objectInput.readUTF();
		shippingStreet = objectInput.readUTF();
		shippingCity = objectInput.readUTF();
		shippingState = objectInput.readUTF();
		shippingZip = objectInput.readUTF();
		shippingCountry = objectInput.readUTF();
		shippingPhone = objectInput.readUTF();
		ccName = objectInput.readUTF();
		ccType = objectInput.readUTF();
		ccNumber = objectInput.readUTF();
		ccExpMonth = objectInput.readInt();
		ccExpYear = objectInput.readInt();
		ccVerNumber = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(msId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (mporder_1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mporder_1);
		}

		if (mpId_1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpId_1);
		}

		if (mpName_1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpName_1);
		}

		objectOutput.writeInt(mpQty_1);
		objectOutput.writeFloat(mpPrice_1);

		if (mpPriceCurrency_1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpPriceCurrency_1);
		}

		if (mporder_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mporder_2);
		}

		if (mpId_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpId_2);
		}

		if (mpName_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpName_2);
		}

		objectOutput.writeInt(mpQty_2);
		objectOutput.writeFloat(mpPrice_2);

		if (mpPriceCurrency_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpPriceCurrency_2);
		}

		if (mporder_3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mporder_3);
		}

		if (mpId_3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpId_3);
		}

		if (mpName_3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpName_3);
		}

		objectOutput.writeInt(mpQty_3);
		objectOutput.writeFloat(mpPrice_3);

		if (mpPriceCurrency_3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpPriceCurrency_3);
		}

		if (mporder_4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mporder_4);
		}

		if (mpId_4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpId_4);
		}

		if (mpName_4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpName_4);
		}

		objectOutput.writeInt(mpQty_4);
		objectOutput.writeFloat(mpPrice_4);

		if (mpPriceCurrency_4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpPriceCurrency_4);
		}

		objectOutput.writeFloat(mpSubtotal);

		if (mpSubtotalCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mpSubtotalCurrency);
		}

		objectOutput.writeFloat(addOnSubtotal);

		if (addOnSubtotalCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addOnSubtotalCurrency);
		}

		objectOutput.writeFloat(tax);

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (promotionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(promotionCode);
		}

		objectOutput.writeLong(promotionFrom);
		objectOutput.writeLong(promotionTo);

		if (discount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(discount);
		}

		objectOutput.writeFloat(nettotal);

		if (nettotalCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nettotalCurrency);
		}

		if (ppTxnId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ppTxnId);
		}

		if (ppPaymentStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ppPaymentStatus);
		}

		objectOutput.writeFloat(ppPaymentGross);

		if (ppReceiverEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ppReceiverEmail);
		}

		if (ppPayerEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ppPayerEmail);
		}

		if (sendOrderEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sendOrderEmail);
		}

		if (sendShippingEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sendShippingEmail);
		}

		objectOutput.writeLong(effectiveFromDate);
		objectOutput.writeLong(effectiveToDate);
		objectOutput.writeInt(altShipping);
		objectOutput.writeDouble(shipping);
		objectOutput.writeBoolean(requiresShipping);
		objectOutput.writeBoolean(insure);
		objectOutput.writeDouble(insurance);

		if (billingFirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingFirstName);
		}

		if (billingLastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingLastName);
		}

		if (billingEmailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingEmailAddress);
		}

		if (billingCompany == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingCompany);
		}

		if (billingStreet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingStreet);
		}

		if (billingCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingCity);
		}

		if (billingState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingState);
		}

		if (billingZip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingZip);
		}

		if (billingCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingCountry);
		}

		if (billingPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billingPhone);
		}

		objectOutput.writeBoolean(shipToBilling);

		if (shippingFirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingFirstName);
		}

		if (shippingLastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingLastName);
		}

		if (shippingEmailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingEmailAddress);
		}

		if (shippingCompany == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingCompany);
		}

		if (shippingStreet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingStreet);
		}

		if (shippingCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingCity);
		}

		if (shippingState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingState);
		}

		if (shippingZip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingZip);
		}

		if (shippingCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingCountry);
		}

		if (shippingPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shippingPhone);
		}

		if (ccName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccName);
		}

		if (ccType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccType);
		}

		if (ccNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccNumber);
		}

		objectOutput.writeInt(ccExpMonth);
		objectOutput.writeInt(ccExpYear);

		if (ccVerNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccVerNumber);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long msId;
	public String name;
	public String description;
	public String mporder_1;
	public String mpId_1;
	public String mpName_1;
	public int mpQty_1;
	public float mpPrice_1;
	public String mpPriceCurrency_1;
	public String mporder_2;
	public String mpId_2;
	public String mpName_2;
	public int mpQty_2;
	public float mpPrice_2;
	public String mpPriceCurrency_2;
	public String mporder_3;
	public String mpId_3;
	public String mpName_3;
	public int mpQty_3;
	public float mpPrice_3;
	public String mpPriceCurrency_3;
	public String mporder_4;
	public String mpId_4;
	public String mpName_4;
	public int mpQty_4;
	public float mpPrice_4;
	public String mpPriceCurrency_4;
	public float mpSubtotal;
	public String mpSubtotalCurrency;
	public float addOnSubtotal;
	public String addOnSubtotalCurrency;
	public float tax;
	public String comments;
	public String promotionCode;
	public long promotionFrom;
	public long promotionTo;
	public String discount;
	public float nettotal;
	public String nettotalCurrency;
	public String ppTxnId;
	public String ppPaymentStatus;
	public float ppPaymentGross;
	public String ppReceiverEmail;
	public String ppPayerEmail;
	public String sendOrderEmail;
	public String sendShippingEmail;
	public long effectiveFromDate;
	public long effectiveToDate;
	public int altShipping;
	public double shipping;
	public boolean requiresShipping;
	public boolean insure;
	public double insurance;
	public String billingFirstName;
	public String billingLastName;
	public String billingEmailAddress;
	public String billingCompany;
	public String billingStreet;
	public String billingCity;
	public String billingState;
	public String billingZip;
	public String billingCountry;
	public String billingPhone;
	public boolean shipToBilling;
	public String shippingFirstName;
	public String shippingLastName;
	public String shippingEmailAddress;
	public String shippingCompany;
	public String shippingStreet;
	public String shippingCity;
	public String shippingState;
	public String shippingZip;
	public String shippingCountry;
	public String shippingPhone;
	public String ccName;
	public String ccType;
	public String ccNumber;
	public int ccExpMonth;
	public int ccExpYear;
	public String ccVerNumber;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}