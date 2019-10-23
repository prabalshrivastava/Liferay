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
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.spservices.service.http.SPUserTypeServiceSoap}.
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.http.SPUserTypeServiceSoap
 * @generated
 */
public class SPUserTypeSoap implements Serializable {
	public static SPUserTypeSoap toSoapModel(SPUserType model) {
		SPUserTypeSoap soapModel = new SPUserTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpUserTypeId(model.getSpUserTypeId());
		soapModel.setSpSiteId(model.getSpSiteId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserTypeId(model.getUserTypeId());
		soapModel.setUserStatusId(model.getUserStatusId());
		soapModel.setDeclarationCompleted(model.getDeclarationCompleted());
		soapModel.setDeclarationDate(model.getDeclarationDate());
		soapModel.setDeclarationStorageId(model.getDeclarationStorageId());
		soapModel.setPdpaCompleted(model.getPdpaCompleted());
		soapModel.setPdpaCompletionDate(model.getPdpaCompletionDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPUserTypeSoap[] toSoapModels(SPUserType[] models) {
		SPUserTypeSoap[] soapModels = new SPUserTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPUserTypeSoap[][] toSoapModels(SPUserType[][] models) {
		SPUserTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPUserTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPUserTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPUserTypeSoap[] toSoapModels(List<SPUserType> models) {
		List<SPUserTypeSoap> soapModels = new ArrayList<SPUserTypeSoap>(models.size());

		for (SPUserType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPUserTypeSoap[soapModels.size()]);
	}

	public SPUserTypeSoap() {
	}

	public long getPrimaryKey() {
		return _spUserTypeId;
	}

	public void setPrimaryKey(long pk) {
		setSpUserTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpUserTypeId() {
		return _spUserTypeId;
	}

	public void setSpUserTypeId(long spUserTypeId) {
		_spUserTypeId = spUserTypeId;
	}

	public long getSpSiteId() {
		return _spSiteId;
	}

	public void setSpSiteId(long spSiteId) {
		_spSiteId = spSiteId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getUserTypeId() {
		return _userTypeId;
	}

	public void setUserTypeId(long userTypeId) {
		_userTypeId = userTypeId;
	}

	public long getUserStatusId() {
		return _userStatusId;
	}

	public void setUserStatusId(long userStatusId) {
		_userStatusId = userStatusId;
	}

	public boolean getDeclarationCompleted() {
		return _declarationCompleted;
	}

	public boolean isDeclarationCompleted() {
		return _declarationCompleted;
	}

	public void setDeclarationCompleted(boolean declarationCompleted) {
		_declarationCompleted = declarationCompleted;
	}

	public long getDeclarationDate() {
		return _declarationDate;
	}

	public void setDeclarationDate(long declarationDate) {
		_declarationDate = declarationDate;
	}

	public long getDeclarationStorageId() {
		return _declarationStorageId;
	}

	public void setDeclarationStorageId(long declarationStorageId) {
		_declarationStorageId = declarationStorageId;
	}

	public boolean getPdpaCompleted() {
		return _pdpaCompleted;
	}

	public boolean isPdpaCompleted() {
		return _pdpaCompleted;
	}

	public void setPdpaCompleted(boolean pdpaCompleted) {
		_pdpaCompleted = pdpaCompleted;
	}

	public long getPdpaCompletionDate() {
		return _pdpaCompletionDate;
	}

	public void setPdpaCompletionDate(long pdpaCompletionDate) {
		_pdpaCompletionDate = pdpaCompletionDate;
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

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _spUserTypeId;
	private long _spSiteId;
	private long _userId;
	private long _userTypeId;
	private long _userStatusId;
	private boolean _declarationCompleted;
	private long _declarationDate;
	private long _declarationStorageId;
	private boolean _pdpaCompleted;
	private long _pdpaCompletionDate;
	private long _groupId;
	private long _companyId;
	private long _createdBy;
	private long _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;
}