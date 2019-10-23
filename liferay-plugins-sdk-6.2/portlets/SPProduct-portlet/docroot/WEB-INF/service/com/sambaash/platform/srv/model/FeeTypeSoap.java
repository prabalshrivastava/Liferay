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
public class FeeTypeSoap implements Serializable {
	public static FeeTypeSoap toSoapModel(FeeType model) {
		FeeTypeSoap soapModel = new FeeTypeSoap();

		soapModel.setSpFeeTypeId(model.getSpFeeTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFeeType(model.getFeeType());
		soapModel.setFeeTypeName(model.getFeeTypeName());
		soapModel.setFeeTypeDesc(model.getFeeTypeDesc());
		soapModel.setMisc(model.getMisc());

		return soapModel;
	}

	public static FeeTypeSoap[] toSoapModels(FeeType[] models) {
		FeeTypeSoap[] soapModels = new FeeTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeeTypeSoap[][] toSoapModels(FeeType[][] models) {
		FeeTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeeTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeeTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeeTypeSoap[] toSoapModels(List<FeeType> models) {
		List<FeeTypeSoap> soapModels = new ArrayList<FeeTypeSoap>(models.size());

		for (FeeType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeeTypeSoap[soapModels.size()]);
	}

	public FeeTypeSoap() {
	}

	public long getPrimaryKey() {
		return _spFeeTypeId;
	}

	public void setPrimaryKey(long pk) {
		setSpFeeTypeId(pk);
	}

	public long getSpFeeTypeId() {
		return _spFeeTypeId;
	}

	public void setSpFeeTypeId(long spFeeTypeId) {
		_spFeeTypeId = spFeeTypeId;
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

	public String getFeeType() {
		return _feeType;
	}

	public void setFeeType(String feeType) {
		_feeType = feeType;
	}

	public String getFeeTypeName() {
		return _feeTypeName;
	}

	public void setFeeTypeName(String feeTypeName) {
		_feeTypeName = feeTypeName;
	}

	public String getFeeTypeDesc() {
		return _feeTypeDesc;
	}

	public void setFeeTypeDesc(String feeTypeDesc) {
		_feeTypeDesc = feeTypeDesc;
	}

	public boolean getMisc() {
		return _misc;
	}

	public boolean isMisc() {
		return _misc;
	}

	public void setMisc(boolean misc) {
		_misc = misc;
	}

	private long _spFeeTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _feeType;
	private String _feeTypeName;
	private String _feeTypeDesc;
	private boolean _misc;
}