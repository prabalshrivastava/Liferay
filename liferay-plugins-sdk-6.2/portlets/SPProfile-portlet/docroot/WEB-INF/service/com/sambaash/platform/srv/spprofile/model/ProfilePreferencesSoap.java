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

package com.sambaash.platform.srv.spprofile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.spprofile.service.http.ProfilePreferencesServiceSoap}.
 *
 * @author harini
 * @see com.sambaash.platform.srv.spprofile.service.http.ProfilePreferencesServiceSoap
 * @generated
 */
public class ProfilePreferencesSoap implements Serializable {
	public static ProfilePreferencesSoap toSoapModel(ProfilePreferences model) {
		ProfilePreferencesSoap soapModel = new ProfilePreferencesSoap();

		soapModel.setProferenceId(model.getProferenceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLayoutId(model.getLayoutId());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setPreferenceName(model.getPreferenceName());
		soapModel.setPortletPreferences(model.getPortletPreferences());

		return soapModel;
	}

	public static ProfilePreferencesSoap[] toSoapModels(
		ProfilePreferences[] models) {
		ProfilePreferencesSoap[] soapModels = new ProfilePreferencesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfilePreferencesSoap[][] toSoapModels(
		ProfilePreferences[][] models) {
		ProfilePreferencesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProfilePreferencesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfilePreferencesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfilePreferencesSoap[] toSoapModels(
		List<ProfilePreferences> models) {
		List<ProfilePreferencesSoap> soapModels = new ArrayList<ProfilePreferencesSoap>(models.size());

		for (ProfilePreferences model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProfilePreferencesSoap[soapModels.size()]);
	}

	public ProfilePreferencesSoap() {
	}

	public long getPrimaryKey() {
		return _proferenceId;
	}

	public void setPrimaryKey(long pk) {
		setProferenceId(pk);
	}

	public long getProferenceId() {
		return _proferenceId;
	}

	public void setProferenceId(long proferenceId) {
		_proferenceId = proferenceId;
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

	public String getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(String layoutId) {
		_layoutId = layoutId;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public String getPreferenceName() {
		return _preferenceName;
	}

	public void setPreferenceName(String preferenceName) {
		_preferenceName = preferenceName;
	}

	public String getPortletPreferences() {
		return _portletPreferences;
	}

	public void setPortletPreferences(String portletPreferences) {
		_portletPreferences = portletPreferences;
	}

	private long _proferenceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _layoutId;
	private String _portletId;
	private String _preferenceName;
	private String _portletPreferences;
}