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
public class ModuleCertificateSoap implements Serializable {
	public static ModuleCertificateSoap toSoapModel(ModuleCertificate model) {
		ModuleCertificateSoap soapModel = new ModuleCertificateSoap();

		soapModel.setSpModuleCertificateId(model.getSpModuleCertificateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpModuleId(model.getSpModuleId());
		soapModel.setSpCertificatetId(model.getSpCertificatetId());

		return soapModel;
	}

	public static ModuleCertificateSoap[] toSoapModels(
		ModuleCertificate[] models) {
		ModuleCertificateSoap[] soapModels = new ModuleCertificateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ModuleCertificateSoap[][] toSoapModels(
		ModuleCertificate[][] models) {
		ModuleCertificateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ModuleCertificateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ModuleCertificateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ModuleCertificateSoap[] toSoapModels(
		List<ModuleCertificate> models) {
		List<ModuleCertificateSoap> soapModels = new ArrayList<ModuleCertificateSoap>(models.size());

		for (ModuleCertificate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ModuleCertificateSoap[soapModels.size()]);
	}

	public ModuleCertificateSoap() {
	}

	public long getPrimaryKey() {
		return _spModuleCertificateId;
	}

	public void setPrimaryKey(long pk) {
		setSpModuleCertificateId(pk);
	}

	public long getSpModuleCertificateId() {
		return _spModuleCertificateId;
	}

	public void setSpModuleCertificateId(long spModuleCertificateId) {
		_spModuleCertificateId = spModuleCertificateId;
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

	public long getSpModuleId() {
		return _spModuleId;
	}

	public void setSpModuleId(long spModuleId) {
		_spModuleId = spModuleId;
	}

	public long getSpCertificatetId() {
		return _spCertificatetId;
	}

	public void setSpCertificatetId(long spCertificatetId) {
		_spCertificatetId = spCertificatetId;
	}

	private long _spModuleCertificateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private long _spCertificatetId;
}