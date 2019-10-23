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

import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePullAuditPK;

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
public class SocialProfilePullAuditSoap implements Serializable {
	public static SocialProfilePullAuditSoap toSoapModel(
		SocialProfilePullAudit model) {
		SocialProfilePullAuditSoap soapModel = new SocialProfilePullAuditSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setSocialNetworkProfileId(model.getSocialNetworkProfileId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setLastQueriedDate(model.getLastQueriedDate());

		return soapModel;
	}

	public static SocialProfilePullAuditSoap[] toSoapModels(
		SocialProfilePullAudit[] models) {
		SocialProfilePullAuditSoap[] soapModels = new SocialProfilePullAuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialProfilePullAuditSoap[][] toSoapModels(
		SocialProfilePullAudit[][] models) {
		SocialProfilePullAuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialProfilePullAuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialProfilePullAuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialProfilePullAuditSoap[] toSoapModels(
		List<SocialProfilePullAudit> models) {
		List<SocialProfilePullAuditSoap> soapModels = new ArrayList<SocialProfilePullAuditSoap>(models.size());

		for (SocialProfilePullAudit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialProfilePullAuditSoap[soapModels.size()]);
	}

	public SocialProfilePullAuditSoap() {
	}

	public SocialProfilePullAuditPK getPrimaryKey() {
		return new SocialProfilePullAuditPK(_userId, _socialNetworkProfileId);
	}

	public void setPrimaryKey(SocialProfilePullAuditPK pk) {
		setUserId(pk.userId);
		setSocialNetworkProfileId(pk.socialNetworkProfileId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getSocialNetworkProfileId() {
		return _socialNetworkProfileId;
	}

	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_socialNetworkProfileId = socialNetworkProfileId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getLastQueriedDate() {
		return _lastQueriedDate;
	}

	public void setLastQueriedDate(Date lastQueriedDate) {
		_lastQueriedDate = lastQueriedDate;
	}

	private long _userId;
	private long _socialNetworkProfileId;
	private long _companyId;
	private Date _createDate;
	private Date _lastQueriedDate;
}