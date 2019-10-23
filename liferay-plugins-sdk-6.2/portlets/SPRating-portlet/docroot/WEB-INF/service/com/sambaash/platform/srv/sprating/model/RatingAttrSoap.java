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
public class RatingAttrSoap implements Serializable {
	public static RatingAttrSoap toSoapModel(RatingAttr model) {
		RatingAttrSoap soapModel = new RatingAttrSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpRatingAttrId(model.getSpRatingAttrId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRatingComponentId(model.getRatingComponentId());
		soapModel.setName(model.getName());
		soapModel.setWeight(model.getWeight());
		soapModel.setVisible(model.getVisible());

		return soapModel;
	}

	public static RatingAttrSoap[] toSoapModels(RatingAttr[] models) {
		RatingAttrSoap[] soapModels = new RatingAttrSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RatingAttrSoap[][] toSoapModels(RatingAttr[][] models) {
		RatingAttrSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RatingAttrSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RatingAttrSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RatingAttrSoap[] toSoapModels(List<RatingAttr> models) {
		List<RatingAttrSoap> soapModels = new ArrayList<RatingAttrSoap>(models.size());

		for (RatingAttr model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RatingAttrSoap[soapModels.size()]);
	}

	public RatingAttrSoap() {
	}

	public long getPrimaryKey() {
		return _spRatingAttrId;
	}

	public void setPrimaryKey(long pk) {
		setSpRatingAttrId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpRatingAttrId() {
		return _spRatingAttrId;
	}

	public void setSpRatingAttrId(long spRatingAttrId) {
		_spRatingAttrId = spRatingAttrId;
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

	public long getRatingComponentId() {
		return _ratingComponentId;
	}

	public void setRatingComponentId(long ratingComponentId) {
		_ratingComponentId = ratingComponentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public double getWeight() {
		return _weight;
	}

	public void setWeight(double weight) {
		_weight = weight;
	}

	public boolean getVisible() {
		return _visible;
	}

	public boolean isVisible() {
		return _visible;
	}

	public void setVisible(boolean visible) {
		_visible = visible;
	}

	private String _uuid;
	private long _spRatingAttrId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _ratingComponentId;
	private String _name;
	private double _weight;
	private boolean _visible;
}