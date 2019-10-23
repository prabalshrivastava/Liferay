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
public class MembershipSubscriptionAddonServicesSoap implements Serializable {
	public static MembershipSubscriptionAddonServicesSoap toSoapModel(
		MembershipSubscriptionAddonServices model) {
		MembershipSubscriptionAddonServicesSoap soapModel = new MembershipSubscriptionAddonServicesSoap();

		soapModel.setMsAddonId(model.getMsAddonId());
		soapModel.setMsId(model.getMsId());
		soapModel.setScId(model.getScId());
		soapModel.setScName(model.getScName());
		soapModel.setParamType(model.getParamType());
		soapModel.setParamFrom(model.getParamFrom());
		soapModel.setParamUpto(model.getParamUpto());
		soapModel.setDuration(model.getDuration());
		soapModel.setDurationType(model.getDurationType());
		soapModel.setServiceCharges(model.getServiceCharges());
		soapModel.setServiceChargesCurrency(model.getServiceChargesCurrency());
		soapModel.setServiceChargesPeriod(model.getServiceChargesPeriod());
		soapModel.setServiceChargesPeriodType(model.getServiceChargesPeriodType());
		soapModel.setStatus(model.getStatus());
		soapModel.setDescription(model.getDescription());
		soapModel.setEffectiveFromDate(model.getEffectiveFromDate());
		soapModel.setEffectiveToDate(model.getEffectiveToDate());
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

		return soapModel;
	}

	public static MembershipSubscriptionAddonServicesSoap[] toSoapModels(
		MembershipSubscriptionAddonServices[] models) {
		MembershipSubscriptionAddonServicesSoap[] soapModels = new MembershipSubscriptionAddonServicesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MembershipSubscriptionAddonServicesSoap[][] toSoapModels(
		MembershipSubscriptionAddonServices[][] models) {
		MembershipSubscriptionAddonServicesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MembershipSubscriptionAddonServicesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MembershipSubscriptionAddonServicesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MembershipSubscriptionAddonServicesSoap[] toSoapModels(
		List<MembershipSubscriptionAddonServices> models) {
		List<MembershipSubscriptionAddonServicesSoap> soapModels = new ArrayList<MembershipSubscriptionAddonServicesSoap>(models.size());

		for (MembershipSubscriptionAddonServices model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MembershipSubscriptionAddonServicesSoap[soapModels.size()]);
	}

	public MembershipSubscriptionAddonServicesSoap() {
	}

	public long getPrimaryKey() {
		return _msAddonId;
	}

	public void setPrimaryKey(long pk) {
		setMsAddonId(pk);
	}

	public long getMsAddonId() {
		return _msAddonId;
	}

	public void setMsAddonId(long msAddonId) {
		_msAddonId = msAddonId;
	}

	public long getMsId() {
		return _msId;
	}

	public void setMsId(long msId) {
		_msId = msId;
	}

	public String getScId() {
		return _scId;
	}

	public void setScId(String scId) {
		_scId = scId;
	}

	public String getScName() {
		return _scName;
	}

	public void setScName(String scName) {
		_scName = scName;
	}

	public String getParamType() {
		return _paramType;
	}

	public void setParamType(String paramType) {
		_paramType = paramType;
	}

	public String getParamFrom() {
		return _paramFrom;
	}

	public void setParamFrom(String paramFrom) {
		_paramFrom = paramFrom;
	}

	public String getParamUpto() {
		return _paramUpto;
	}

	public void setParamUpto(String paramUpto) {
		_paramUpto = paramUpto;
	}

	public String getDuration() {
		return _duration;
	}

	public void setDuration(String duration) {
		_duration = duration;
	}

	public String getDurationType() {
		return _durationType;
	}

	public void setDurationType(String durationType) {
		_durationType = durationType;
	}

	public float getServiceCharges() {
		return _serviceCharges;
	}

	public void setServiceCharges(float serviceCharges) {
		_serviceCharges = serviceCharges;
	}

	public String getServiceChargesCurrency() {
		return _serviceChargesCurrency;
	}

	public void setServiceChargesCurrency(String serviceChargesCurrency) {
		_serviceChargesCurrency = serviceChargesCurrency;
	}

	public String getServiceChargesPeriod() {
		return _serviceChargesPeriod;
	}

	public void setServiceChargesPeriod(String serviceChargesPeriod) {
		_serviceChargesPeriod = serviceChargesPeriod;
	}

	public String getServiceChargesPeriodType() {
		return _serviceChargesPeriodType;
	}

	public void setServiceChargesPeriodType(String serviceChargesPeriodType) {
		_serviceChargesPeriodType = serviceChargesPeriodType;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	private long _msAddonId;
	private long _msId;
	private String _scId;
	private String _scName;
	private String _paramType;
	private String _paramFrom;
	private String _paramUpto;
	private String _duration;
	private String _durationType;
	private float _serviceCharges;
	private String _serviceChargesCurrency;
	private String _serviceChargesPeriod;
	private String _serviceChargesPeriodType;
	private String _status;
	private String _description;
	private Date _effectiveFromDate;
	private Date _effectiveToDate;
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
}