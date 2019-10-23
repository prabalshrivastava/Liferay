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
public class ApprovedMentorsSoap implements Serializable {
	public static ApprovedMentorsSoap toSoapModel(ApprovedMentors model) {
		ApprovedMentorsSoap soapModel = new ApprovedMentorsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMentorId(model.getMentorId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setRemarks(model.getRemarks());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ApprovedMentorsSoap[] toSoapModels(ApprovedMentors[] models) {
		ApprovedMentorsSoap[] soapModels = new ApprovedMentorsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApprovedMentorsSoap[][] toSoapModels(
		ApprovedMentors[][] models) {
		ApprovedMentorsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApprovedMentorsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApprovedMentorsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApprovedMentorsSoap[] toSoapModels(
		List<ApprovedMentors> models) {
		List<ApprovedMentorsSoap> soapModels = new ArrayList<ApprovedMentorsSoap>(models.size());

		for (ApprovedMentors model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApprovedMentorsSoap[soapModels.size()]);
	}

	public ApprovedMentorsSoap() {
	}

	public long getPrimaryKey() {
		return _mentorId;
	}

	public void setPrimaryKey(long pk) {
		setMentorId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMentorId() {
		return _mentorId;
	}

	public void setMentorId(long mentorId) {
		_mentorId = mentorId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getUserId() {
		return _userId;
	}

	public void setUserId(String userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getApprovedDate() {
		return _approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		_approvedDate = approvedDate;
	}

	public String getRemarks() {
		return _remarks;
	}

	public void setRemarks(String remarks) {
		_remarks = remarks;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _uuid;
	private long _mentorId;
	private long _organizationId;
	private String _userId;
	private Date _createDate;
	private Date _approvedDate;
	private String _remarks;
	private int _status;
}