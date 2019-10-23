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

package com.sambaash.platform.srv.sprating.model;

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
public class RatingComponentSoap implements Serializable {
	public static RatingComponentSoap toSoapModel(RatingComponent model) {
		RatingComponentSoap soapModel = new RatingComponentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpRatingComponentId(model.getSpRatingComponentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setClassNameId(model.getClassNameId());

		return soapModel;
	}

	public static RatingComponentSoap[] toSoapModels(RatingComponent[] models) {
		RatingComponentSoap[] soapModels = new RatingComponentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RatingComponentSoap[][] toSoapModels(
		RatingComponent[][] models) {
		RatingComponentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RatingComponentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RatingComponentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RatingComponentSoap[] toSoapModels(
		List<RatingComponent> models) {
		List<RatingComponentSoap> soapModels = new ArrayList<RatingComponentSoap>(models.size());

		for (RatingComponent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RatingComponentSoap[soapModels.size()]);
	}

	public RatingComponentSoap() {
	}

	public long getPrimaryKey() {
		return _spRatingComponentId;
	}

	public void setPrimaryKey(long pk) {
		setSpRatingComponentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpRatingComponentId() {
		return _spRatingComponentId;
	}

	public void setSpRatingComponentId(long spRatingComponentId) {
		_spRatingComponentId = spRatingComponentId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	private String _uuid;
	private long _spRatingComponentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _classNameId;
}