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
public class MembershipPackageSoap implements Serializable {
	public static MembershipPackageSoap toSoapModel(MembershipPackage model) {
		MembershipPackageSoap soapModel = new MembershipPackageSoap();

		soapModel.setMpId(model.getMpId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setType(model.getType());
		soapModel.setVersion(model.getVersion());
		soapModel.setCost(model.getCost());
		soapModel.setCostCurrency(model.getCostCurrency());
		soapModel.setCostPeriod(model.getCostPeriod());
		soapModel.setCostPeriodType(model.getCostPeriodType());
		soapModel.setPromotionCode(model.getPromotionCode());
		soapModel.setPromotionFrom(model.getPromotionFrom());
		soapModel.setPromotionTo(model.getPromotionTo());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setDateAdded(model.getDateAdded());
		soapModel.setDateModified(model.getDateModified());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setExtra1(model.getExtra1());
		soapModel.setExtra2(model.getExtra2());
		soapModel.setExtra3(model.getExtra3());
		soapModel.setExtra4(model.getExtra4());
		soapModel.setExtra5(model.getExtra5());
		soapModel.setExtra6(model.getExtra6());
		soapModel.setExtra7(model.getExtra7());
		soapModel.setExtra8(model.getExtra8());
		soapModel.setExtra9(model.getExtra9());
		soapModel.setExtra10(model.getExtra10());

		return soapModel;
	}

	public static MembershipPackageSoap[] toSoapModels(
		MembershipPackage[] models) {
		MembershipPackageSoap[] soapModels = new MembershipPackageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MembershipPackageSoap[][] toSoapModels(
		MembershipPackage[][] models) {
		MembershipPackageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MembershipPackageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MembershipPackageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MembershipPackageSoap[] toSoapModels(
		List<MembershipPackage> models) {
		List<MembershipPackageSoap> soapModels = new ArrayList<MembershipPackageSoap>(models.size());

		for (MembershipPackage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MembershipPackageSoap[soapModels.size()]);
	}

	public MembershipPackageSoap() {
	}

	public long getPrimaryKey() {
		return _mpId;
	}

	public void setPrimaryKey(long pk) {
		setMpId(pk);
	}

	public long getMpId() {
		return _mpId;
	}

	public void setMpId(long mpId) {
		_mpId = mpId;
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

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public float getCost() {
		return _cost;
	}

	public void setCost(float cost) {
		_cost = cost;
	}

	public String getCostCurrency() {
		return _costCurrency;
	}

	public void setCostCurrency(String costCurrency) {
		_costCurrency = costCurrency;
	}

	public String getCostPeriod() {
		return _costPeriod;
	}

	public void setCostPeriod(String costPeriod) {
		_costPeriod = costPeriod;
	}

	public String getCostPeriodType() {
		return _costPeriodType;
	}

	public void setCostPeriodType(String costPeriodType) {
		_costPeriodType = costPeriodType;
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

	public Date getDateAdded() {
		return _dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		_dateAdded = dateAdded;
	}

	public Date getDateModified() {
		return _dateModified;
	}

	public void setDateModified(Date dateModified) {
		_dateModified = dateModified;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
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

	public Date getExtra5() {
		return _extra5;
	}

	public void setExtra5(Date extra5) {
		_extra5 = extra5;
	}

	public Date getExtra6() {
		return _extra6;
	}

	public void setExtra6(Date extra6) {
		_extra6 = extra6;
	}

	public String getExtra7() {
		return _extra7;
	}

	public void setExtra7(String extra7) {
		_extra7 = extra7;
	}

	public String getExtra8() {
		return _extra8;
	}

	public void setExtra8(String extra8) {
		_extra8 = extra8;
	}

	public String getExtra9() {
		return _extra9;
	}

	public void setExtra9(String extra9) {
		_extra9 = extra9;
	}

	public String getExtra10() {
		return _extra10;
	}

	public void setExtra10(String extra10) {
		_extra10 = extra10;
	}

	private long _mpId;
	private String _name;
	private String _description;
	private String _status;
	private String _type;
	private String _version;
	private float _cost;
	private String _costCurrency;
	private String _costPeriod;
	private String _costPeriodType;
	private String _promotionCode;
	private Date _promotionFrom;
	private Date _promotionTo;
	private String _discount;
	private Date _dateAdded;
	private Date _dateModified;
	private String _createdBy;
	private String _modifiedBy;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private Date _extra5;
	private Date _extra6;
	private String _extra7;
	private String _extra8;
	private String _extra9;
	private String _extra10;
}