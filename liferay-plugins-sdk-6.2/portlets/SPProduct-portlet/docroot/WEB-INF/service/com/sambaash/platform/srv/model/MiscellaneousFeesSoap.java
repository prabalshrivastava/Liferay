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

package com.sambaash.platform.srv.model;

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
public class MiscellaneousFeesSoap implements Serializable {
	public static MiscellaneousFeesSoap toSoapModel(MiscellaneousFees model) {
		MiscellaneousFeesSoap soapModel = new MiscellaneousFeesSoap();

		soapModel.setSpMiscFeesId(model.getSpMiscFeesId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMiscFeeType(model.getMiscFeeType());
		soapModel.setAmount(model.getAmount());
		soapModel.setPayable(model.getPayable());
		soapModel.setSpCourseId(model.getSpCourseId());

		return soapModel;
	}

	public static MiscellaneousFeesSoap[] toSoapModels(
		MiscellaneousFees[] models) {
		MiscellaneousFeesSoap[] soapModels = new MiscellaneousFeesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MiscellaneousFeesSoap[][] toSoapModels(
		MiscellaneousFees[][] models) {
		MiscellaneousFeesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MiscellaneousFeesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MiscellaneousFeesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MiscellaneousFeesSoap[] toSoapModels(
		List<MiscellaneousFees> models) {
		List<MiscellaneousFeesSoap> soapModels = new ArrayList<MiscellaneousFeesSoap>(models.size());

		for (MiscellaneousFees model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MiscellaneousFeesSoap[soapModels.size()]);
	}

	public MiscellaneousFeesSoap() {
	}

	public long getPrimaryKey() {
		return _spMiscFeesId;
	}

	public void setPrimaryKey(long pk) {
		setSpMiscFeesId(pk);
	}

	public long getSpMiscFeesId() {
		return _spMiscFeesId;
	}

	public void setSpMiscFeesId(long spMiscFeesId) {
		_spMiscFeesId = spMiscFeesId;
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

	public long getMiscFeeType() {
		return _miscFeeType;
	}

	public void setMiscFeeType(long miscFeeType) {
		_miscFeeType = miscFeeType;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public long getPayable() {
		return _payable;
	}

	public void setPayable(long payable) {
		_payable = payable;
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	private long _spMiscFeesId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _miscFeeType;
	private double _amount;
	private long _payable;
	private long _spCourseId;
}