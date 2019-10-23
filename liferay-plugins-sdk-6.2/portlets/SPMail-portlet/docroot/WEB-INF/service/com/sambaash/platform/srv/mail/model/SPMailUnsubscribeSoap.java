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

package com.sambaash.platform.srv.mail.model;

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
public class SPMailUnsubscribeSoap implements Serializable {
	public static SPMailUnsubscribeSoap toSoapModel(SPMailUnsubscribe model) {
		SPMailUnsubscribeSoap soapModel = new SPMailUnsubscribeSoap();

		soapModel.setSpMailUnsubscribeId(model.getSpMailUnsubscribeId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setUserId(model.getUserId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setUnsubscribeDate(model.getUnsubscribeDate());

		return soapModel;
	}

	public static SPMailUnsubscribeSoap[] toSoapModels(
		SPMailUnsubscribe[] models) {
		SPMailUnsubscribeSoap[] soapModels = new SPMailUnsubscribeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPMailUnsubscribeSoap[][] toSoapModels(
		SPMailUnsubscribe[][] models) {
		SPMailUnsubscribeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPMailUnsubscribeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPMailUnsubscribeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPMailUnsubscribeSoap[] toSoapModels(
		List<SPMailUnsubscribe> models) {
		List<SPMailUnsubscribeSoap> soapModels = new ArrayList<SPMailUnsubscribeSoap>(models.size());

		for (SPMailUnsubscribe model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPMailUnsubscribeSoap[soapModels.size()]);
	}

	public SPMailUnsubscribeSoap() {
	}

	public long getPrimaryKey() {
		return _spMailUnsubscribeId;
	}

	public void setPrimaryKey(long pk) {
		setSpMailUnsubscribeId(pk);
	}

	public long getSpMailUnsubscribeId() {
		return _spMailUnsubscribeId;
	}

	public void setSpMailUnsubscribeId(long spMailUnsubscribeId) {
		_spMailUnsubscribeId = spMailUnsubscribeId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public Date getUnsubscribeDate() {
		return _unsubscribeDate;
	}

	public void setUnsubscribeDate(Date unsubscribeDate) {
		_unsubscribeDate = unsubscribeDate;
	}

	private long _spMailUnsubscribeId;
	private long _categoryId;
	private long _userId;
	private String _emailAddress;
	private Date _unsubscribeDate;
}