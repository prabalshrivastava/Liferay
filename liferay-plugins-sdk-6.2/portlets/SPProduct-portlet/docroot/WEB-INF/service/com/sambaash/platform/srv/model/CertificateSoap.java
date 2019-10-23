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
public class CertificateSoap implements Serializable {
	public static CertificateSoap toSoapModel(Certificate model) {
		CertificateSoap soapModel = new CertificateSoap();

		soapModel.setSpCertificatetId(model.getSpCertificatetId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setCertificateCode(model.getCertificateCode());
		soapModel.setCertificateType(model.getCertificateType());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setLevel(model.getLevel());
		soapModel.setAttachmentFolderId(model.getAttachmentFolderId());

		return soapModel;
	}

	public static CertificateSoap[] toSoapModels(Certificate[] models) {
		CertificateSoap[] soapModels = new CertificateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CertificateSoap[][] toSoapModels(Certificate[][] models) {
		CertificateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CertificateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CertificateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CertificateSoap[] toSoapModels(List<Certificate> models) {
		List<CertificateSoap> soapModels = new ArrayList<CertificateSoap>(models.size());

		for (Certificate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CertificateSoap[soapModels.size()]);
	}

	public CertificateSoap() {
	}

	public long getPrimaryKey() {
		return _spCertificatetId;
	}

	public void setPrimaryKey(long pk) {
		setSpCertificatetId(pk);
	}

	public long getSpCertificatetId() {
		return _spCertificatetId;
	}

	public void setSpCertificatetId(long spCertificatetId) {
		_spCertificatetId = spCertificatetId;
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

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getCertificateCode() {
		return _certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		_certificateCode = certificateCode;
	}

	public long getCertificateType() {
		return _certificateType;
	}

	public void setCertificateType(long certificateType) {
		_certificateType = certificateType;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getLevel() {
		return _level;
	}

	public void setLevel(long level) {
		_level = level;
	}

	public long getAttachmentFolderId() {
		return _attachmentFolderId;
	}

	public void setAttachmentFolderId(long attachmentFolderId) {
		_attachmentFolderId = attachmentFolderId;
	}

	private long _spCertificatetId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private String _certificateCode;
	private long _certificateType;
	private String _title;
	private String _description;
	private long _level;
	private long _attachmentFolderId;
}