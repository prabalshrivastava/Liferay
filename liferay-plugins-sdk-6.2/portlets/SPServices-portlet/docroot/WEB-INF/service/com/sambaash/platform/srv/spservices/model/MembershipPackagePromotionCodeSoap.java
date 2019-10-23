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
public class MembershipPackagePromotionCodeSoap implements Serializable {
	public static MembershipPackagePromotionCodeSoap toSoapModel(
		MembershipPackagePromotionCode model) {
		MembershipPackagePromotionCodeSoap soapModel = new MembershipPackagePromotionCodeSoap();

		soapModel.setPromotionCode_id(model.getPromotionCode_id());
		soapModel.setMembershipPackage_id(model.getMembershipPackage_id());
		soapModel.setPromotionCode(model.getPromotionCode());
		soapModel.setPromotionFrom(model.getPromotionFrom());
		soapModel.setPromotionTo(model.getPromotionTo());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setExtra1(model.getExtra1());
		soapModel.setExtra2(model.getExtra2());
		soapModel.setExtra3(model.getExtra3());
		soapModel.setExtra4(model.getExtra4());
		soapModel.setExtra5(model.getExtra5());

		return soapModel;
	}

	public static MembershipPackagePromotionCodeSoap[] toSoapModels(
		MembershipPackagePromotionCode[] models) {
		MembershipPackagePromotionCodeSoap[] soapModels = new MembershipPackagePromotionCodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MembershipPackagePromotionCodeSoap[][] toSoapModels(
		MembershipPackagePromotionCode[][] models) {
		MembershipPackagePromotionCodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MembershipPackagePromotionCodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MembershipPackagePromotionCodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MembershipPackagePromotionCodeSoap[] toSoapModels(
		List<MembershipPackagePromotionCode> models) {
		List<MembershipPackagePromotionCodeSoap> soapModels = new ArrayList<MembershipPackagePromotionCodeSoap>(models.size());

		for (MembershipPackagePromotionCode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MembershipPackagePromotionCodeSoap[soapModels.size()]);
	}

	public MembershipPackagePromotionCodeSoap() {
	}

	public long getPrimaryKey() {
		return _promotionCode_id;
	}

	public void setPrimaryKey(long pk) {
		setPromotionCode_id(pk);
	}

	public long getPromotionCode_id() {
		return _promotionCode_id;
	}

	public void setPromotionCode_id(long promotionCode_id) {
		_promotionCode_id = promotionCode_id;
	}

	public long getMembershipPackage_id() {
		return _membershipPackage_id;
	}

	public void setMembershipPackage_id(long membershipPackage_id) {
		_membershipPackage_id = membershipPackage_id;
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

	public String getExtra1() {
		return _extra1;
	}

	public void setExtra1(String extra1) {
		_extra1 = extra1;
	}

	public String getExtra2() {
		return _extra2;
	}

	public void setExtra2(String extra2) {
		_extra2 = extra2;
	}

	public String getExtra3() {
		return _extra3;
	}

	public void setExtra3(String extra3) {
		_extra3 = extra3;
	}

	public String getExtra4() {
		return _extra4;
	}

	public void setExtra4(String extra4) {
		_extra4 = extra4;
	}

	public String getExtra5() {
		return _extra5;
	}

	public void setExtra5(String extra5) {
		_extra5 = extra5;
	}

	private long _promotionCode_id;
	private long _membershipPackage_id;
	private String _promotionCode;
	private Date _promotionFrom;
	private Date _promotionTo;
	private String _discount;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private String _extra5;
}