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

package com.sambaash.platform.srv.extendedprofile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author harini
 * @generated
 */
public class SPCertificationSoap implements Serializable {
	public static SPCertificationSoap toSoapModel(SPCertification model) {
		SPCertificationSoap soapModel = new SPCertificationSoap();

		soapModel.setClassPk(model.getClassPk());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCertificationId(model.getCertificationId());

		return soapModel;
	}

	public static SPCertificationSoap[] toSoapModels(SPCertification[] models) {
		SPCertificationSoap[] soapModels = new SPCertificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPCertificationSoap[][] toSoapModels(
		SPCertification[][] models) {
		SPCertificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPCertificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPCertificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPCertificationSoap[] toSoapModels(
		List<SPCertification> models) {
		List<SPCertificationSoap> soapModels = new ArrayList<SPCertificationSoap>(models.size());

		for (SPCertification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPCertificationSoap[soapModels.size()]);
	}

	public SPCertificationSoap() {
	}

	public long getPrimaryKey() {
		return _classPk;
	}

	public void setPrimaryKey(long pk) {
		setClassPk(pk);
	}

	public long getClassPk() {
		return _classPk;
	}

	public void setClassPk(long classPk) {
		_classPk = classPk;
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

	public long getCertificationId() {
		return _certificationId;
	}

	public void setCertificationId(long certificationId) {
		_certificationId = certificationId;
	}

	private long _classPk;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _certificationId;
}