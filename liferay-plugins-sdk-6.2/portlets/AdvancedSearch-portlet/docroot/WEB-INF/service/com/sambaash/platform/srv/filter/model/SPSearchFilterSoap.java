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

package com.sambaash.platform.srv.filter.model;

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
public class SPSearchFilterSoap implements Serializable {
	public static SPSearchFilterSoap toSoapModel(SPSearchFilter model) {
		SPSearchFilterSoap soapModel = new SPSearchFilterSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpSearchFilterId(model.getSpSearchFilterId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFilterName(model.getFilterName());
		soapModel.setFilterParameter(model.getFilterParameter());

		return soapModel;
	}

	public static SPSearchFilterSoap[] toSoapModels(SPSearchFilter[] models) {
		SPSearchFilterSoap[] soapModels = new SPSearchFilterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPSearchFilterSoap[][] toSoapModels(SPSearchFilter[][] models) {
		SPSearchFilterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPSearchFilterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPSearchFilterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPSearchFilterSoap[] toSoapModels(List<SPSearchFilter> models) {
		List<SPSearchFilterSoap> soapModels = new ArrayList<SPSearchFilterSoap>(models.size());

		for (SPSearchFilter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPSearchFilterSoap[soapModels.size()]);
	}

	public SPSearchFilterSoap() {
	}

	public long getPrimaryKey() {
		return _spSearchFilterId;
	}

	public void setPrimaryKey(long pk) {
		setSpSearchFilterId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpSearchFilterId() {
		return _spSearchFilterId;
	}

	public void setSpSearchFilterId(long spSearchFilterId) {
		_spSearchFilterId = spSearchFilterId;
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

	public String getFilterName() {
		return _filterName;
	}

	public void setFilterName(String filterName) {
		_filterName = filterName;
	}

	public String getFilterParameter() {
		return _filterParameter;
	}

	public void setFilterParameter(String filterParameter) {
		_filterParameter = filterParameter;
	}

	private String _uuid;
	private long _spSearchFilterId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _filterName;
	private String _filterParameter;
}