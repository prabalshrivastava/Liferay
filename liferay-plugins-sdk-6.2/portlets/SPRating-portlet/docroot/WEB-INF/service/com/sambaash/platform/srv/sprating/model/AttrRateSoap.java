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
public class AttrRateSoap implements Serializable {
	public static AttrRateSoap toSoapModel(AttrRate model) {
		AttrRateSoap soapModel = new AttrRateSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpAttrRateId(model.getSpAttrRateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setObjId(model.getObjId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setRatingAttrId(model.getRatingAttrId());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static AttrRateSoap[] toSoapModels(AttrRate[] models) {
		AttrRateSoap[] soapModels = new AttrRateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttrRateSoap[][] toSoapModels(AttrRate[][] models) {
		AttrRateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AttrRateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttrRateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttrRateSoap[] toSoapModels(List<AttrRate> models) {
		List<AttrRateSoap> soapModels = new ArrayList<AttrRateSoap>(models.size());

		for (AttrRate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttrRateSoap[soapModels.size()]);
	}

	public AttrRateSoap() {
	}

	public long getPrimaryKey() {
		return _spAttrRateId;
	}

	public void setPrimaryKey(long pk) {
		setSpAttrRateId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpAttrRateId() {
		return _spAttrRateId;
	}

	public void setSpAttrRateId(long spAttrRateId) {
		_spAttrRateId = spAttrRateId;
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

	public String getObjId() {
		return _objId;
	}

	public void setObjId(String objId) {
		_objId = objId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getRatingAttrId() {
		return _ratingAttrId;
	}

	public void setRatingAttrId(long ratingAttrId) {
		_ratingAttrId = ratingAttrId;
	}

	public double getValue() {
		return _value;
	}

	public void setValue(double value) {
		_value = value;
	}

	private String _uuid;
	private long _spAttrRateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _objId;
	private long _classNameId;
	private long _ratingAttrId;
	private double _value;
}