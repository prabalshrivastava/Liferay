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

package com.sambaash.platform.srv.legalandcontract.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author nareshchebolu
 * @generated
 */
public class TrademarksSoap implements Serializable {
	public static TrademarksSoap toSoapModel(Trademarks model) {
		TrademarksSoap soapModel = new TrademarksSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpTrademarksId(model.getSpTrademarksId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRegistrationNumber(model.getRegistrationNumber());
		soapModel.setApplicationNo(model.getApplicationNo());
		soapModel.setCountry(model.getCountry());
		soapModel.setTrademark(model.getTrademark());
		soapModel.setTrademarkLocalized(model.getTrademarkLocalized());
		soapModel.setRegisteredOwner(model.getRegisteredOwner());
		soapModel.setApplicationDate(model.getApplicationDate());
		soapModel.setFirstRegistrationDate(model.getFirstRegistrationDate());
		soapModel.setRenewalDate(model.getRenewalDate());
		soapModel.setGoodsServices(model.getGoodsServices());
		soapModel.setPendingComments(model.getPendingComments());
		soapModel.setSpAgencyId(model.getSpAgencyId());
		soapModel.setClassDescription(model.getClassDescription());
		soapModel.setLegalConfRemarks(model.getLegalConfRemarks());
		soapModel.setWorkflowStatus(model.getWorkflowStatus());
		soapModel.setCustomField1(model.getCustomField1());
		soapModel.setCustomField2(model.getCustomField2());
		soapModel.setCustomField3(model.getCustomField3());
		soapModel.setCustomDate1(model.getCustomDate1());
		soapModel.setCustomDate2(model.getCustomDate2());
		soapModel.setCustomDate3(model.getCustomDate3());
		soapModel.setClassCodes(model.getClassCodes());
		soapModel.setVersion(model.getVersion());
		soapModel.setTrademarkType(model.getTrademarkType());
		soapModel.setRootSpTrademarksId(model.getRootSpTrademarksId());

		return soapModel;
	}

	public static TrademarksSoap[] toSoapModels(Trademarks[] models) {
		TrademarksSoap[] soapModels = new TrademarksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrademarksSoap[][] toSoapModels(Trademarks[][] models) {
		TrademarksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TrademarksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrademarksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrademarksSoap[] toSoapModels(List<Trademarks> models) {
		List<TrademarksSoap> soapModels = new ArrayList<TrademarksSoap>(models.size());

		for (Trademarks model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrademarksSoap[soapModels.size()]);
	}

	public TrademarksSoap() {
	}

	public long getPrimaryKey() {
		return _spTrademarksId;
	}

	public void setPrimaryKey(long pk) {
		setSpTrademarksId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpTrademarksId() {
		return _spTrademarksId;
	}

	public void setSpTrademarksId(long spTrademarksId) {
		_spTrademarksId = spTrademarksId;
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

	public String getRegistrationNumber() {
		return _registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		_registrationNumber = registrationNumber;
	}

	public String getApplicationNo() {
		return _applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		_applicationNo = applicationNo;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getTrademark() {
		return _trademark;
	}

	public void setTrademark(String trademark) {
		_trademark = trademark;
	}

	public String getTrademarkLocalized() {
		return _trademarkLocalized;
	}

	public void setTrademarkLocalized(String trademarkLocalized) {
		_trademarkLocalized = trademarkLocalized;
	}

	public String getRegisteredOwner() {
		return _registeredOwner;
	}

	public void setRegisteredOwner(String registeredOwner) {
		_registeredOwner = registeredOwner;
	}

	public Date getApplicationDate() {
		return _applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		_applicationDate = applicationDate;
	}

	public Date getFirstRegistrationDate() {
		return _firstRegistrationDate;
	}

	public void setFirstRegistrationDate(Date firstRegistrationDate) {
		_firstRegistrationDate = firstRegistrationDate;
	}

	public Date getRenewalDate() {
		return _renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		_renewalDate = renewalDate;
	}

	public String getGoodsServices() {
		return _goodsServices;
	}

	public void setGoodsServices(String goodsServices) {
		_goodsServices = goodsServices;
	}

	public String getPendingComments() {
		return _pendingComments;
	}

	public void setPendingComments(String pendingComments) {
		_pendingComments = pendingComments;
	}

	public long getSpAgencyId() {
		return _spAgencyId;
	}

	public void setSpAgencyId(long spAgencyId) {
		_spAgencyId = spAgencyId;
	}

	public String getClassDescription() {
		return _classDescription;
	}

	public void setClassDescription(String classDescription) {
		_classDescription = classDescription;
	}

	public String getLegalConfRemarks() {
		return _legalConfRemarks;
	}

	public void setLegalConfRemarks(String legalConfRemarks) {
		_legalConfRemarks = legalConfRemarks;
	}

	public long getWorkflowStatus() {
		return _workflowStatus;
	}

	public void setWorkflowStatus(long workflowStatus) {
		_workflowStatus = workflowStatus;
	}

	public String getCustomField1() {
		return _customField1;
	}

	public void setCustomField1(String customField1) {
		_customField1 = customField1;
	}

	public String getCustomField2() {
		return _customField2;
	}

	public void setCustomField2(String customField2) {
		_customField2 = customField2;
	}

	public String getCustomField3() {
		return _customField3;
	}

	public void setCustomField3(String customField3) {
		_customField3 = customField3;
	}

	public Date getCustomDate1() {
		return _customDate1;
	}

	public void setCustomDate1(Date customDate1) {
		_customDate1 = customDate1;
	}

	public Date getCustomDate2() {
		return _customDate2;
	}

	public void setCustomDate2(Date customDate2) {
		_customDate2 = customDate2;
	}

	public Date getCustomDate3() {
		return _customDate3;
	}

	public void setCustomDate3(Date customDate3) {
		_customDate3 = customDate3;
	}

	public String getClassCodes() {
		return _classCodes;
	}

	public void setClassCodes(String classCodes) {
		_classCodes = classCodes;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public String getTrademarkType() {
		return _trademarkType;
	}

	public void setTrademarkType(String trademarkType) {
		_trademarkType = trademarkType;
	}

	public long getRootSpTrademarksId() {
		return _rootSpTrademarksId;
	}

	public void setRootSpTrademarksId(long rootSpTrademarksId) {
		_rootSpTrademarksId = rootSpTrademarksId;
	}

	private String _uuid;
	private long _spTrademarksId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _registrationNumber;
	private String _applicationNo;
	private String _country;
	private String _trademark;
	private String _trademarkLocalized;
	private String _registeredOwner;
	private Date _applicationDate;
	private Date _firstRegistrationDate;
	private Date _renewalDate;
	private String _goodsServices;
	private String _pendingComments;
	private long _spAgencyId;
	private String _classDescription;
	private String _legalConfRemarks;
	private long _workflowStatus;
	private String _customField1;
	private String _customField2;
	private String _customField3;
	private Date _customDate1;
	private Date _customDate2;
	private Date _customDate3;
	private String _classCodes;
	private String _version;
	private String _trademarkType;
	private long _rootSpTrademarksId;
}