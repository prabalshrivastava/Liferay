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
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class SPSiteSetupSoap implements Serializable {
	public static SPSiteSetupSoap toSoapModel(SPSiteSetup model) {
		SPSiteSetupSoap soapModel = new SPSiteSetupSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpSiteSetupId(model.getSpSiteSetupId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setProductId(model.getProductId());
		soapModel.setProductName(model.getProductName());
		soapModel.setSubProductId(model.getSubProductId());
		soapModel.setSubProductName(model.getSubProductName());
		soapModel.setVirtualHostId(model.getVirtualHostId());
		soapModel.setBackOfficeVirtualHostId(model.getBackOfficeVirtualHostId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPSiteSetupSoap[] toSoapModels(SPSiteSetup[] models) {
		SPSiteSetupSoap[] soapModels = new SPSiteSetupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPSiteSetupSoap[][] toSoapModels(SPSiteSetup[][] models) {
		SPSiteSetupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPSiteSetupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPSiteSetupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPSiteSetupSoap[] toSoapModels(List<SPSiteSetup> models) {
		List<SPSiteSetupSoap> soapModels = new ArrayList<SPSiteSetupSoap>(models.size());

		for (SPSiteSetup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPSiteSetupSoap[soapModels.size()]);
	}

	public SPSiteSetupSoap() {
	}

	public long getPrimaryKey() {
		return _spSiteSetupId;
	}

	public void setPrimaryKey(long pk) {
		setSpSiteSetupId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpSiteSetupId() {
		return _spSiteSetupId;
	}

	public void setSpSiteSetupId(long spSiteSetupId) {
		_spSiteSetupId = spSiteSetupId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public String getProductName() {
		return _productName;
	}

	public void setProductName(String productName) {
		_productName = productName;
	}

	public long getSubProductId() {
		return _subProductId;
	}

	public void setSubProductId(long subProductId) {
		_subProductId = subProductId;
	}

	public String getSubProductName() {
		return _subProductName;
	}

	public void setSubProductName(String subProductName) {
		_subProductName = subProductName;
	}

	public long getVirtualHostId() {
		return _virtualHostId;
	}

	public void setVirtualHostId(long virtualHostId) {
		_virtualHostId = virtualHostId;
	}

	public long getBackOfficeVirtualHostId() {
		return _backOfficeVirtualHostId;
	}

	public void setBackOfficeVirtualHostId(long backOfficeVirtualHostId) {
		_backOfficeVirtualHostId = backOfficeVirtualHostId;
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
	private long _spSiteSetupId;
	private long _groupId;
	private long _productId;
	private String _productName;
	private long _subProductId;
	private String _subProductName;
	private long _virtualHostId;
	private long _backOfficeVirtualHostId;
	private long _companyId;
	private long _createdBy;
	private long _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;
}