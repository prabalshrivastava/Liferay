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

package com.sambaash.platform.srv.spshopping.model;

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
public class SPSellingPackageSoap implements Serializable {
	public static SPSellingPackageSoap toSoapModel(SPSellingPackage model) {
		SPSellingPackageSoap soapModel = new SPSellingPackageSoap();

		soapModel.setSpSellingPackageId(model.getSpSellingPackageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTitle(model.getTitle());
		soapModel.setPkgCode(model.getPkgCode());
		soapModel.setShortDescription(model.getShortDescription());
		soapModel.setLongDescription(model.getLongDescription());
		soapModel.setCurrencyCode(model.getCurrencyCode());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setNotify(model.getNotify());
		soapModel.setNeedsPayment(model.getNeedsPayment());
		soapModel.setOrderPage(model.getOrderPage());
		soapModel.setOrderSequence(model.getOrderSequence());
		soapModel.setActive(model.getActive());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPSellingPackageSoap[] toSoapModels(SPSellingPackage[] models) {
		SPSellingPackageSoap[] soapModels = new SPSellingPackageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPSellingPackageSoap[][] toSoapModels(
		SPSellingPackage[][] models) {
		SPSellingPackageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPSellingPackageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPSellingPackageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPSellingPackageSoap[] toSoapModels(
		List<SPSellingPackage> models) {
		List<SPSellingPackageSoap> soapModels = new ArrayList<SPSellingPackageSoap>(models.size());

		for (SPSellingPackage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPSellingPackageSoap[soapModels.size()]);
	}

	public SPSellingPackageSoap() {
	}

	public long getPrimaryKey() {
		return _spSellingPackageId;
	}

	public void setPrimaryKey(long pk) {
		setSpSellingPackageId(pk);
	}

	public long getSpSellingPackageId() {
		return _spSellingPackageId;
	}

	public void setSpSellingPackageId(long spSellingPackageId) {
		_spSellingPackageId = spSellingPackageId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getPkgCode() {
		return _pkgCode;
	}

	public void setPkgCode(String pkgCode) {
		_pkgCode = pkgCode;
	}

	public String getShortDescription() {
		return _shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return _longDescription;
	}

	public void setLongDescription(String longDescription) {
		_longDescription = longDescription;
	}

	public String getCurrencyCode() {
		return _currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		_currencyCode = currencyCode;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getNotify() {
		return _notify;
	}

	public void setNotify(String notify) {
		_notify = notify;
	}

	public boolean getNeedsPayment() {
		return _needsPayment;
	}

	public boolean isNeedsPayment() {
		return _needsPayment;
	}

	public void setNeedsPayment(boolean needsPayment) {
		_needsPayment = needsPayment;
	}

	public String getOrderPage() {
		return _orderPage;
	}

	public void setOrderPage(String orderPage) {
		_orderPage = orderPage;
	}

	public String getOrderSequence() {
		return _orderSequence;
	}

	public void setOrderSequence(String orderSequence) {
		_orderSequence = orderSequence;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
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

	private long _spSellingPackageId;
	private long _groupId;
	private String _title;
	private String _pkgCode;
	private String _shortDescription;
	private String _longDescription;
	private String _currencyCode;
	private Date _startDate;
	private Date _endDate;
	private String _notify;
	private boolean _needsPayment;
	private String _orderPage;
	private String _orderSequence;
	private boolean _active;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}