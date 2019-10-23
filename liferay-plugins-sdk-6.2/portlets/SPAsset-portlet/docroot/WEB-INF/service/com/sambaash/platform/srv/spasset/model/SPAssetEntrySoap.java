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

package com.sambaash.platform.srv.spasset.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.spasset.service.http.SPAssetEntryServiceSoap}.
 *
 * @author harini
 * @see com.sambaash.platform.srv.spasset.service.http.SPAssetEntryServiceSoap
 * @generated
 */
public class SPAssetEntrySoap implements Serializable {
	public static SPAssetEntrySoap toSoapModel(SPAssetEntry model) {
		SPAssetEntrySoap soapModel = new SPAssetEntrySoap();

		soapModel.setUuid_(model.getUuid_());
		soapModel.setSpAssetEntryId(model.getSpAssetEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDlFolderId(model.getDlFolderId());
		soapModel.setCoverFileEntryId(model.getCoverFileEntryId());
		soapModel.setSpAssetTypeId(model.getSpAssetTypeId());
		soapModel.setSpAssetEntrySubType(model.getSpAssetEntrySubType());
		soapModel.setCorporateProfileUserId(model.getCorporateProfileUserId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setTitle(model.getTitle());
		soapModel.setUrlTitle(model.getUrlTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setContent(model.getContent());
		soapModel.setLink(model.getLink());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setType(model.getType());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setAllowPingbacks(model.getAllowPingbacks());
		soapModel.setAllowTrackbacks(model.getAllowTrackbacks());
		soapModel.setTrackbacks(model.getTrackbacks());
		soapModel.setPermissionType(model.getPermissionType());
		soapModel.setAgreedToTermsOfUse(model.getAgreedToTermsOfUse());

		return soapModel;
	}

	public static SPAssetEntrySoap[] toSoapModels(SPAssetEntry[] models) {
		SPAssetEntrySoap[] soapModels = new SPAssetEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPAssetEntrySoap[][] toSoapModels(SPAssetEntry[][] models) {
		SPAssetEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPAssetEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPAssetEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPAssetEntrySoap[] toSoapModels(List<SPAssetEntry> models) {
		List<SPAssetEntrySoap> soapModels = new ArrayList<SPAssetEntrySoap>(models.size());

		for (SPAssetEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPAssetEntrySoap[soapModels.size()]);
	}

	public SPAssetEntrySoap() {
	}

	public long getPrimaryKey() {
		return _spAssetEntryId;
	}

	public void setPrimaryKey(long pk) {
		setSpAssetEntryId(pk);
	}

	public String getUuid_() {
		return _uuid_;
	}

	public void setUuid_(String uuid_) {
		_uuid_ = uuid_;
	}

	public long getSpAssetEntryId() {
		return _spAssetEntryId;
	}

	public void setSpAssetEntryId(long spAssetEntryId) {
		_spAssetEntryId = spAssetEntryId;
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

	public long getDlFolderId() {
		return _dlFolderId;
	}

	public void setDlFolderId(long dlFolderId) {
		_dlFolderId = dlFolderId;
	}

	public long getCoverFileEntryId() {
		return _coverFileEntryId;
	}

	public void setCoverFileEntryId(long coverFileEntryId) {
		_coverFileEntryId = coverFileEntryId;
	}

	public long getSpAssetTypeId() {
		return _spAssetTypeId;
	}

	public void setSpAssetTypeId(long spAssetTypeId) {
		_spAssetTypeId = spAssetTypeId;
	}

	public String getSpAssetEntrySubType() {
		return _spAssetEntrySubType;
	}

	public void setSpAssetEntrySubType(String spAssetEntrySubType) {
		_spAssetEntrySubType = spAssetEntrySubType;
	}

	public long getCorporateProfileUserId() {
		return _corporateProfileUserId;
	}

	public void setCorporateProfileUserId(long corporateProfileUserId) {
		_corporateProfileUserId = corporateProfileUserId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getUrlTitle() {
		return _urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public boolean getAllowPingbacks() {
		return _allowPingbacks;
	}

	public boolean isAllowPingbacks() {
		return _allowPingbacks;
	}

	public void setAllowPingbacks(boolean allowPingbacks) {
		_allowPingbacks = allowPingbacks;
	}

	public boolean getAllowTrackbacks() {
		return _allowTrackbacks;
	}

	public boolean isAllowTrackbacks() {
		return _allowTrackbacks;
	}

	public void setAllowTrackbacks(boolean allowTrackbacks) {
		_allowTrackbacks = allowTrackbacks;
	}

	public String getTrackbacks() {
		return _trackbacks;
	}

	public void setTrackbacks(String trackbacks) {
		_trackbacks = trackbacks;
	}

	public int getPermissionType() {
		return _permissionType;
	}

	public void setPermissionType(int permissionType) {
		_permissionType = permissionType;
	}

	public boolean getAgreedToTermsOfUse() {
		return _agreedToTermsOfUse;
	}

	public boolean isAgreedToTermsOfUse() {
		return _agreedToTermsOfUse;
	}

	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse) {
		_agreedToTermsOfUse = agreedToTermsOfUse;
	}

	private String _uuid_;
	private long _spAssetEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dlFolderId;
	private long _coverFileEntryId;
	private long _spAssetTypeId;
	private String _spAssetEntrySubType;
	private long _corporateProfileUserId;
	private long _classNameId;
	private String _title;
	private String _urlTitle;
	private String _description;
	private String _content;
	private String _link;
	private boolean _status;
	private String _statusByUserName;
	private String _type;
	private String _modifiedBy;
	private boolean _allowPingbacks;
	private boolean _allowTrackbacks;
	private String _trackbacks;
	private int _permissionType;
	private boolean _agreedToTermsOfUse;
}