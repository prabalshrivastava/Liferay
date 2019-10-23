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

package com.sambaash.platform.srv.sharing.model;

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
public class SPSharingSoap implements Serializable {
	public static SPSharingSoap toSoapModel(SPSharing model) {
		SPSharingSoap soapModel = new SPSharingSoap();

		soapModel.setSpSharingId(model.getSpSharingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setDuration(model.getDuration());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setUrl(model.getUrl());
		soapModel.setExpired(model.getExpired());
		soapModel.setInternalShare(model.getInternalShare());
		soapModel.setWritePermission(model.getWritePermission());
		soapModel.setViewCount(model.getViewCount());

		return soapModel;
	}

	public static SPSharingSoap[] toSoapModels(SPSharing[] models) {
		SPSharingSoap[] soapModels = new SPSharingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPSharingSoap[][] toSoapModels(SPSharing[][] models) {
		SPSharingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPSharingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPSharingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPSharingSoap[] toSoapModels(List<SPSharing> models) {
		List<SPSharingSoap> soapModels = new ArrayList<SPSharingSoap>(models.size());

		for (SPSharing model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPSharingSoap[soapModels.size()]);
	}

	public SPSharingSoap() {
	}

	public long getPrimaryKey() {
		return _spSharingId;
	}

	public void setPrimaryKey(long pk) {
		setSpSharingId(pk);
	}

	public long getSpSharingId() {
		return _spSharingId;
	}

	public void setSpSharingId(long spSharingId) {
		_spSharingId = spSharingId;
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

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
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

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public int getDuration() {
		return _duration;
	}

	public void setDuration(int duration) {
		_duration = duration;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public boolean getExpired() {
		return _expired;
	}

	public boolean isExpired() {
		return _expired;
	}

	public void setExpired(boolean expired) {
		_expired = expired;
	}

	public boolean getInternalShare() {
		return _internalShare;
	}

	public boolean isInternalShare() {
		return _internalShare;
	}

	public void setInternalShare(boolean internalShare) {
		_internalShare = internalShare;
	}

	public boolean getWritePermission() {
		return _writePermission;
	}

	public boolean isWritePermission() {
		return _writePermission;
	}

	public void setWritePermission(boolean writePermission) {
		_writePermission = writePermission;
	}

	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	private long _spSharingId;
	private long _groupId;
	private long _companyId;
	private long _createdBy;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _emailAddress;
	private long _classNameId;
	private long _classPK;
	private int _duration;
	private Date _startDate;
	private Date _endDate;
	private String _url;
	private boolean _expired;
	private boolean _internalShare;
	private boolean _writePermission;
	private int _viewCount;
}