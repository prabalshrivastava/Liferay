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

package com.sambaash.platform.srv.sppayment.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class SPPaymentCustomerSoap implements Serializable {
	public static SPPaymentCustomerSoap toSoapModel(SPPaymentCustomer model) {
		SPPaymentCustomerSoap soapModel = new SPPaymentCustomerSoap();

		soapModel.setSPPaymentCustomerId(model.getSPPaymentCustomerId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setProviderCustomerId(model.getProviderCustomerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPPaymentCustomerSoap[] toSoapModels(
		SPPaymentCustomer[] models) {
		SPPaymentCustomerSoap[] soapModels = new SPPaymentCustomerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPPaymentCustomerSoap[][] toSoapModels(
		SPPaymentCustomer[][] models) {
		SPPaymentCustomerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPPaymentCustomerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPPaymentCustomerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPPaymentCustomerSoap[] toSoapModels(
		List<SPPaymentCustomer> models) {
		List<SPPaymentCustomerSoap> soapModels = new ArrayList<SPPaymentCustomerSoap>(models.size());

		for (SPPaymentCustomer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPPaymentCustomerSoap[soapModels.size()]);
	}

	public SPPaymentCustomerSoap() {
	}

	public long getPrimaryKey() {
		return _sPPaymentCustomerId;
	}

	public void setPrimaryKey(long pk) {
		setSPPaymentCustomerId(pk);
	}

	public long getSPPaymentCustomerId() {
		return _sPPaymentCustomerId;
	}

	public void setSPPaymentCustomerId(long sPPaymentCustomerId) {
		_sPPaymentCustomerId = sPPaymentCustomerId;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getProviderCustomerId() {
		return _providerCustomerId;
	}

	public void setProviderCustomerId(String providerCustomerId) {
		_providerCustomerId = providerCustomerId;
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

	private long _sPPaymentCustomerId;
	private String _emailAddress;
	private String _providerCustomerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}