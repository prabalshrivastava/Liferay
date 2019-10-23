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
public class AccreditationSoap implements Serializable {
	public static AccreditationSoap toSoapModel(Accreditation model) {
		AccreditationSoap soapModel = new AccreditationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAccreditationId(model.getAccreditationId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setAselected(model.getAselected());
		soapModel.setAvalue(model.getAvalue());
		soapModel.setBselected(model.getBselected());
		soapModel.setBvalue(model.getBvalue());
		soapModel.setCselected(model.getCselected());
		soapModel.setCvalue(model.getCvalue());
		soapModel.setCcompanyName(model.getCcompanyName());
		soapModel.setCsamepolicy(model.getCsamepolicy());
		soapModel.setCelaborate(model.getCelaborate());
		soapModel.setDselected(model.getDselected());
		soapModel.setDvalue(model.getDvalue());
		soapModel.setAccreditationStatus(model.getAccreditationStatus());
		soapModel.setDateOfAccreditation(model.getDateOfAccreditation());
		soapModel.setDateOfExpiry(model.getDateOfExpiry());
		soapModel.setLatestPaymentDate(model.getLatestPaymentDate());
		soapModel.setStartDateOfReaccreditation(model.getStartDateOfReaccreditation());
		soapModel.setDateOfReaccdtReview(model.getDateOfReaccdtReview());
		soapModel.setAccreditationBy(model.getAccreditationBy());

		return soapModel;
	}

	public static AccreditationSoap[] toSoapModels(Accreditation[] models) {
		AccreditationSoap[] soapModels = new AccreditationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccreditationSoap[][] toSoapModels(Accreditation[][] models) {
		AccreditationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AccreditationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccreditationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccreditationSoap[] toSoapModels(List<Accreditation> models) {
		List<AccreditationSoap> soapModels = new ArrayList<AccreditationSoap>(models.size());

		for (Accreditation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AccreditationSoap[soapModels.size()]);
	}

	public AccreditationSoap() {
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

	public boolean getAselected() {
		return _aselected;
	}

	public boolean isAselected() {
		return _aselected;
	}

	public void setAselected(boolean aselected) {
		_aselected = aselected;
	}

	public String getAvalue() {
		return _avalue;
	}

	public void setAvalue(String avalue) {
		_avalue = avalue;
	}

	public boolean getBselected() {
		return _bselected;
	}

	public boolean isBselected() {
		return _bselected;
	}

	public void setBselected(boolean bselected) {
		_bselected = bselected;
	}

	public String getBvalue() {
		return _bvalue;
	}

	public void setBvalue(String bvalue) {
		_bvalue = bvalue;
	}

	public boolean getCselected() {
		return _cselected;
	}

	public boolean isCselected() {
		return _cselected;
	}

	public void setCselected(boolean cselected) {
		_cselected = cselected;
	}

	public String getCvalue() {
		return _cvalue;
	}

	public void setCvalue(String cvalue) {
		_cvalue = cvalue;
	}

	public String getCcompanyName() {
		return _ccompanyName;
	}

	public void setCcompanyName(String ccompanyName) {
		_ccompanyName = ccompanyName;
	}

	public boolean getCsamepolicy() {
		return _csamepolicy;
	}

	public boolean isCsamepolicy() {
		return _csamepolicy;
	}

	public void setCsamepolicy(boolean csamepolicy) {
		_csamepolicy = csamepolicy;
	}

	public String getCelaborate() {
		return _celaborate;
	}

	public void setCelaborate(String celaborate) {
		_celaborate = celaborate;
	}

	public boolean getDselected() {
		return _dselected;
	}

	public boolean isDselected() {
		return _dselected;
	}

	public void setDselected(boolean dselected) {
		_dselected = dselected;
	}

	public String getDvalue() {
		return _dvalue;
	}

	public void setDvalue(String dvalue) {
		_dvalue = dvalue;
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
	private boolean _aselected;
	private String _avalue;
	private boolean _bselected;
	private String _bvalue;
	private boolean _cselected;
	private String _cvalue;
	private String _ccompanyName;
	private boolean _csamepolicy;
	private String _celaborate;
	private boolean _dselected;
	private String _dvalue;
	private String _accreditationStatus;
	private Date _dateOfAccreditation;
	private Date _dateOfExpiry;
	private Date _latestPaymentDate;
	private Date _startDateOfReaccreditation;
	private Date _dateOfReaccdtReview;
	private String _AccreditationBy;
}