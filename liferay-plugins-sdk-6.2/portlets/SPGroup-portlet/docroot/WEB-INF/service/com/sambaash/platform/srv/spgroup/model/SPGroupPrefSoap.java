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

package com.sambaash.platform.srv.spgroup.model;

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
public class SPGroupPrefSoap implements Serializable {
	public static SPGroupPrefSoap toSoapModel(SPGroupPref model) {
		SPGroupPrefSoap soapModel = new SPGroupPrefSoap();

		soapModel.setSpGroupPrefId(model.getSpGroupPrefId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDIn(model.getDIn());
		soapModel.setDGoogle(model.getDGoogle());
		soapModel.setDFb(model.getDFb());
		soapModel.setDTw(model.getDTw());
		soapModel.setCIn(model.getCIn());
		soapModel.setCGoogle(model.getCGoogle());
		soapModel.setCFb(model.getCFb());
		soapModel.setCTw(model.getCTw());
		soapModel.setEnableSubscribeToComments(model.getEnableSubscribeToComments());
		soapModel.setEnableGroupUpdateNotification(model.getEnableGroupUpdateNotification());
		soapModel.setEnableMemberUpdate(model.getEnableMemberUpdate());
		soapModel.setEnableDiscussionUpdate(model.getEnableDiscussionUpdate());
		soapModel.setUpdateFrequency(model.getUpdateFrequency());

		return soapModel;
	}

	public static SPGroupPrefSoap[] toSoapModels(SPGroupPref[] models) {
		SPGroupPrefSoap[] soapModels = new SPGroupPrefSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPGroupPrefSoap[][] toSoapModels(SPGroupPref[][] models) {
		SPGroupPrefSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPGroupPrefSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPGroupPrefSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPGroupPrefSoap[] toSoapModels(List<SPGroupPref> models) {
		List<SPGroupPrefSoap> soapModels = new ArrayList<SPGroupPrefSoap>(models.size());

		for (SPGroupPref model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPGroupPrefSoap[soapModels.size()]);
	}

	public SPGroupPrefSoap() {
	}

	public long getPrimaryKey() {
		return _spGroupPrefId;
	}

	public void setPrimaryKey(long pk) {
		setSpGroupPrefId(pk);
	}

	public long getSpGroupPrefId() {
		return _spGroupPrefId;
	}

	public void setSpGroupPrefId(long spGroupPrefId) {
		_spGroupPrefId = spGroupPrefId;
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

	public boolean getDIn() {
		return _dIn;
	}

	public boolean isDIn() {
		return _dIn;
	}

	public void setDIn(boolean dIn) {
		_dIn = dIn;
	}

	public boolean getDGoogle() {
		return _dGoogle;
	}

	public boolean isDGoogle() {
		return _dGoogle;
	}

	public void setDGoogle(boolean dGoogle) {
		_dGoogle = dGoogle;
	}

	public boolean getDFb() {
		return _dFb;
	}

	public boolean isDFb() {
		return _dFb;
	}

	public void setDFb(boolean dFb) {
		_dFb = dFb;
	}

	public boolean getDTw() {
		return _dTw;
	}

	public boolean isDTw() {
		return _dTw;
	}

	public void setDTw(boolean dTw) {
		_dTw = dTw;
	}

	public boolean getCIn() {
		return _cIn;
	}

	public boolean isCIn() {
		return _cIn;
	}

	public void setCIn(boolean cIn) {
		_cIn = cIn;
	}

	public boolean getCGoogle() {
		return _cGoogle;
	}

	public boolean isCGoogle() {
		return _cGoogle;
	}

	public void setCGoogle(boolean cGoogle) {
		_cGoogle = cGoogle;
	}

	public boolean getCFb() {
		return _cFb;
	}

	public boolean isCFb() {
		return _cFb;
	}

	public void setCFb(boolean cFb) {
		_cFb = cFb;
	}

	public boolean getCTw() {
		return _cTw;
	}

	public boolean isCTw() {
		return _cTw;
	}

	public void setCTw(boolean cTw) {
		_cTw = cTw;
	}

	public boolean getEnableSubscribeToComments() {
		return _enableSubscribeToComments;
	}

	public boolean isEnableSubscribeToComments() {
		return _enableSubscribeToComments;
	}

	public void setEnableSubscribeToComments(boolean enableSubscribeToComments) {
		_enableSubscribeToComments = enableSubscribeToComments;
	}

	public boolean getEnableGroupUpdateNotification() {
		return _enableGroupUpdateNotification;
	}

	public boolean isEnableGroupUpdateNotification() {
		return _enableGroupUpdateNotification;
	}

	public void setEnableGroupUpdateNotification(
		boolean enableGroupUpdateNotification) {
		_enableGroupUpdateNotification = enableGroupUpdateNotification;
	}

	public boolean getEnableMemberUpdate() {
		return _enableMemberUpdate;
	}

	public boolean isEnableMemberUpdate() {
		return _enableMemberUpdate;
	}

	public void setEnableMemberUpdate(boolean enableMemberUpdate) {
		_enableMemberUpdate = enableMemberUpdate;
	}

	public boolean getEnableDiscussionUpdate() {
		return _enableDiscussionUpdate;
	}

	public boolean isEnableDiscussionUpdate() {
		return _enableDiscussionUpdate;
	}

	public void setEnableDiscussionUpdate(boolean enableDiscussionUpdate) {
		_enableDiscussionUpdate = enableDiscussionUpdate;
	}

	public String getUpdateFrequency() {
		return _updateFrequency;
	}

	public void setUpdateFrequency(String updateFrequency) {
		_updateFrequency = updateFrequency;
	}

	private long _spGroupPrefId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _dIn;
	private boolean _dGoogle;
	private boolean _dFb;
	private boolean _dTw;
	private boolean _cIn;
	private boolean _cGoogle;
	private boolean _cFb;
	private boolean _cTw;
	private boolean _enableSubscribeToComments;
	private boolean _enableGroupUpdateNotification;
	private boolean _enableMemberUpdate;
	private boolean _enableDiscussionUpdate;
	private String _updateFrequency;
}