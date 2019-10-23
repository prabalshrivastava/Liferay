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

package com.sambaash.platform.srv.spsocialprofile.model;

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
public class SocialProfileViewAuditSoap implements Serializable {
	public static SocialProfileViewAuditSoap toSoapModel(
		SocialProfileViewAudit model) {
		SocialProfileViewAuditSoap soapModel = new SocialProfileViewAuditSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSocialProfileViewAuditId(model.getSocialProfileViewAuditId());
		soapModel.setLoggedInUserId(model.getLoggedInUserId());
		soapModel.setProfileUserId(model.getProfileUserId());
		soapModel.setLastViewDate(model.getLastViewDate());

		return soapModel;
	}

	public static SocialProfileViewAuditSoap[] toSoapModels(
		SocialProfileViewAudit[] models) {
		SocialProfileViewAuditSoap[] soapModels = new SocialProfileViewAuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileViewAuditSoap[][] toSoapModels(
		SocialProfileViewAudit[][] models) {
		SocialProfileViewAuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialProfileViewAuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialProfileViewAuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileViewAuditSoap[] toSoapModels(
		List<SocialProfileViewAudit> models) {
		List<SocialProfileViewAuditSoap> soapModels = new ArrayList<SocialProfileViewAuditSoap>(models.size());

		for (SocialProfileViewAudit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialProfileViewAuditSoap[soapModels.size()]);
	}

	public SocialProfileViewAuditSoap() {
	}

	public long getPrimaryKey() {
		return _socialProfileViewAuditId;
	}

	public void setPrimaryKey(long pk) {
		setSocialProfileViewAuditId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSocialProfileViewAuditId() {
		return _socialProfileViewAuditId;
	}

	public void setSocialProfileViewAuditId(long socialProfileViewAuditId) {
		_socialProfileViewAuditId = socialProfileViewAuditId;
	}

	public long getLoggedInUserId() {
		return _loggedInUserId;
	}

	public void setLoggedInUserId(long loggedInUserId) {
		_loggedInUserId = loggedInUserId;
	}

	public long getProfileUserId() {
		return _profileUserId;
	}

	public void setProfileUserId(long profileUserId) {
		_profileUserId = profileUserId;
	}

	public Date getLastViewDate() {
		return _lastViewDate;
	}

	public void setLastViewDate(Date lastViewDate) {
		_lastViewDate = lastViewDate;
	}

	private String _uuid;
	private long _socialProfileViewAuditId;
	private long _loggedInUserId;
	private long _profileUserId;
	private Date _lastViewDate;
}