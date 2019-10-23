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

package com.sambaash.platform.srv.startupprofile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class ReAccreditationSoap implements Serializable {
	public static ReAccreditationSoap toSoapModel(ReAccreditation model) {
		ReAccreditationSoap soapModel = new ReAccreditationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAccreditationId(model.getAccreditationId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setAccreditationStatus(model.getAccreditationStatus());
		soapModel.setDateOfAccreditation(model.getDateOfAccreditation());
		soapModel.setDateOfExpiry(model.getDateOfExpiry());
		soapModel.setLatestPaymentDate(model.getLatestPaymentDate());
		soapModel.setStartDateOfReaccreditation(model.getStartDateOfReaccreditation());
		soapModel.setDateOfReaccdtReview(model.getDateOfReaccdtReview());
		soapModel.setAccreditationBy(model.getAccreditationBy());

		return soapModel;
	}

	public static ReAccreditationSoap[] toSoapModels(ReAccreditation[] models) {
		ReAccreditationSoap[] soapModels = new ReAccreditationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReAccreditationSoap[][] toSoapModels(
		ReAccreditation[][] models) {
		ReAccreditationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReAccreditationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReAccreditationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReAccreditationSoap[] toSoapModels(
		List<ReAccreditation> models) {
		List<ReAccreditationSoap> soapModels = new ArrayList<ReAccreditationSoap>(models.size());

		for (ReAccreditation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReAccreditationSoap[soapModels.size()]);
	}

	public ReAccreditationSoap() {
	}

	public long getPrimaryKey() {
		return _accreditationId;
	}

	public void setPrimaryKey(long pk) {
		setAccreditationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAccreditationId() {
		return _accreditationId;
	}

	public void setAccreditationId(long accreditationId) {
		_accreditationId = accreditationId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getAccreditationStatus() {
		return _accreditationStatus;
	}

	public void setAccreditationStatus(String accreditationStatus) {
		_accreditationStatus = accreditationStatus;
	}

	public Date getDateOfAccreditation() {
		return _dateOfAccreditation;
	}

	public void setDateOfAccreditation(Date dateOfAccreditation) {
		_dateOfAccreditation = dateOfAccreditation;
	}

	public Date getDateOfExpiry() {
		return _dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		_dateOfExpiry = dateOfExpiry;
	}

	public Date getLatestPaymentDate() {
		return _latestPaymentDate;
	}

	public void setLatestPaymentDate(Date latestPaymentDate) {
		_latestPaymentDate = latestPaymentDate;
	}

	public Date getStartDateOfReaccreditation() {
		return _startDateOfReaccreditation;
	}

	public void setStartDateOfReaccreditation(Date startDateOfReaccreditation) {
		_startDateOfReaccreditation = startDateOfReaccreditation;
	}

	public Date getDateOfReaccdtReview() {
		return _dateOfReaccdtReview;
	}

	public void setDateOfReaccdtReview(Date dateOfReaccdtReview) {
		_dateOfReaccdtReview = dateOfReaccdtReview;
	}

	public String getAccreditationBy() {
		return _AccreditationBy;
	}

	public void setAccreditationBy(String AccreditationBy) {
		_AccreditationBy = AccreditationBy;
	}

	private String _uuid;
	private long _accreditationId;
	private long _organizationId;
	private String _accreditationStatus;
	private Date _dateOfAccreditation;
	private Date _dateOfExpiry;
	private Date _latestPaymentDate;
	private Date _startDateOfReaccreditation;
	private Date _dateOfReaccdtReview;
	private String _AccreditationBy;
}