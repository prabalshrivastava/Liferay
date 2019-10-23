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
public class FeeDetailsSoap implements Serializable {
	public static FeeDetailsSoap toSoapModel(FeeDetails model) {
		FeeDetailsSoap soapModel = new FeeDetailsSoap();

		soapModel.setSpFeeDetailsId(model.getSpFeeDetailsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFeeType(model.getFeeType());
		soapModel.setFeeDesc(model.getFeeDesc());
		soapModel.setCalculationBase(model.getCalculationBase());
		soapModel.setAmount(model.getAmount());
		soapModel.setDisplayOrder(model.getDisplayOrder());
		soapModel.setFundId(model.getFundId());
		soapModel.setSpCourseId(model.getSpCourseId());

		return soapModel;
	}

	public static FeeDetailsSoap[] toSoapModels(FeeDetails[] models) {
		FeeDetailsSoap[] soapModels = new FeeDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeeDetailsSoap[][] toSoapModels(FeeDetails[][] models) {
		FeeDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeeDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeeDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeeDetailsSoap[] toSoapModels(List<FeeDetails> models) {
		List<FeeDetailsSoap> soapModels = new ArrayList<FeeDetailsSoap>(models.size());

		for (FeeDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeeDetailsSoap[soapModels.size()]);
	}

	public FeeDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _spFeeDetailsId;
	}

	public void setPrimaryKey(long pk) {
		setSpFeeDetailsId(pk);
	}

	public long getSpFeeDetailsId() {
		return _spFeeDetailsId;
	}

	public void setSpFeeDetailsId(long spFeeDetailsId) {
		_spFeeDetailsId = spFeeDetailsId;
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

	public long getFeeType() {
		return _feeType;
	}

	public void setFeeType(long feeType) {
		_feeType = feeType;
	}

	public String getFeeDesc() {
		return _feeDesc;
	}

	public void setFeeDesc(String feeDesc) {
		_feeDesc = feeDesc;
	}

	public String getCalculationBase() {
		return _calculationBase;
	}

	public void setCalculationBase(String calculationBase) {
		_calculationBase = calculationBase;
	}

	public String getAmount() {
		return _amount;
	}

	public void setAmount(String amount) {
		_amount = amount;
	}

	public long getDisplayOrder() {
		return _displayOrder;
	}

	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;
	}

	public long getFundId() {
		return _fundId;
	}

	public void setFundId(long fundId) {
		_fundId = fundId;
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	private long _spFeeDetailsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _feeType;
	private String _feeDesc;
	private String _calculationBase;
	private String _amount;
	private long _displayOrder;
	private long _fundId;
	private long _spCourseId;
}