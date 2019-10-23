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
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.spasset.service.http.SPAssetTypeServiceSoap}.
 *
 * @author harini
 * @see com.sambaash.platform.srv.spasset.service.http.SPAssetTypeServiceSoap
 * @generated
 */
public class SPAssetTypeSoap implements Serializable {
	public static SPAssetTypeSoap toSoapModel(SPAssetType model) {
		SPAssetTypeSoap soapModel = new SPAssetTypeSoap();

		soapModel.setUuid_(model.getUuid_());
		soapModel.setSpAssetTypeId(model.getSpAssetTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpAssetTypeName(model.getSpAssetTypeName());
		soapModel.setStatus(model.getStatus());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setSpAssetTypeCreateUrl(model.getSpAssetTypeCreateUrl());
		soapModel.setSpAssetTypeDetailUrl(model.getSpAssetTypeDetailUrl());
		soapModel.setSpAssetTypeInnerDetailUrl(model.getSpAssetTypeInnerDetailUrl());
		soapModel.setRequiredTermsOfUse(model.getRequiredTermsOfUse());
		soapModel.setRequiredLogin(model.getRequiredLogin());
		soapModel.setCategoryMandatory(model.getCategoryMandatory());
		soapModel.setNotifyUponCreation(model.getNotifyUponCreation());
		soapModel.setNotificationTemplateId(model.getNotificationTemplateId());
		soapModel.setAllowedFileTypes(model.getAllowedFileTypes());
		soapModel.setMaxFileSize(model.getMaxFileSize());
		soapModel.setMinImageHeight(model.getMinImageHeight());
		soapModel.setMinImageWidth(model.getMinImageWidth());

		return soapModel;
	}

	public static SPAssetTypeSoap[] toSoapModels(SPAssetType[] models) {
		SPAssetTypeSoap[] soapModels = new SPAssetTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPAssetTypeSoap[][] toSoapModels(SPAssetType[][] models) {
		SPAssetTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPAssetTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPAssetTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPAssetTypeSoap[] toSoapModels(List<SPAssetType> models) {
		List<SPAssetTypeSoap> soapModels = new ArrayList<SPAssetTypeSoap>(models.size());

		for (SPAssetType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPAssetTypeSoap[soapModels.size()]);
	}

	public SPAssetTypeSoap() {
	}

	public long getPrimaryKey() {
		return _spAssetTypeId;
	}

	public void setPrimaryKey(long pk) {
		setSpAssetTypeId(pk);
	}

	public String getUuid_() {
		return _uuid_;
	}

	public void setUuid_(String uuid_) {
		_uuid_ = uuid_;
	}

	public long getSpAssetTypeId() {
		return _spAssetTypeId;
	}

	public void setSpAssetTypeId(long spAssetTypeId) {
		_spAssetTypeId = spAssetTypeId;
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

	public String getSpAssetTypeName() {
		return _spAssetTypeName;
	}

	public void setSpAssetTypeName(String spAssetTypeName) {
		_spAssetTypeName = spAssetTypeName;
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

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public String getSpAssetTypeCreateUrl() {
		return _spAssetTypeCreateUrl;
	}

	public void setSpAssetTypeCreateUrl(String spAssetTypeCreateUrl) {
		_spAssetTypeCreateUrl = spAssetTypeCreateUrl;
	}

	public String getSpAssetTypeDetailUrl() {
		return _spAssetTypeDetailUrl;
	}

	public void setSpAssetTypeDetailUrl(String spAssetTypeDetailUrl) {
		_spAssetTypeDetailUrl = spAssetTypeDetailUrl;
	}

	public String getSpAssetTypeInnerDetailUrl() {
		return _spAssetTypeInnerDetailUrl;
	}

	public void setSpAssetTypeInnerDetailUrl(String spAssetTypeInnerDetailUrl) {
		_spAssetTypeInnerDetailUrl = spAssetTypeInnerDetailUrl;
	}

	public boolean getRequiredTermsOfUse() {
		return _requiredTermsOfUse;
	}

	public boolean isRequiredTermsOfUse() {
		return _requiredTermsOfUse;
	}

	public void setRequiredTermsOfUse(boolean requiredTermsOfUse) {
		_requiredTermsOfUse = requiredTermsOfUse;
	}

	public boolean getRequiredLogin() {
		return _requiredLogin;
	}

	public boolean isRequiredLogin() {
		return _requiredLogin;
	}

	public void setRequiredLogin(boolean requiredLogin) {
		_requiredLogin = requiredLogin;
	}

	public boolean getCategoryMandatory() {
		return _categoryMandatory;
	}

	public boolean isCategoryMandatory() {
		return _categoryMandatory;
	}

	public void setCategoryMandatory(boolean categoryMandatory) {
		_categoryMandatory = categoryMandatory;
	}

	public boolean getNotifyUponCreation() {
		return _notifyUponCreation;
	}

	public boolean isNotifyUponCreation() {
		return _notifyUponCreation;
	}

	public void setNotifyUponCreation(boolean notifyUponCreation) {
		_notifyUponCreation = notifyUponCreation;
	}

	public long getNotificationTemplateId() {
		return _notificationTemplateId;
	}

	public void setNotificationTemplateId(long notificationTemplateId) {
		_notificationTemplateId = notificationTemplateId;
	}

	public String getAllowedFileTypes() {
		return _allowedFileTypes;
	}

	public void setAllowedFileTypes(String allowedFileTypes) {
		_allowedFileTypes = allowedFileTypes;
	}

	public int getMaxFileSize() {
		return _maxFileSize;
	}

	public void setMaxFileSize(int maxFileSize) {
		_maxFileSize = maxFileSize;
	}

	public int getMinImageHeight() {
		return _minImageHeight;
	}

	public void setMinImageHeight(int minImageHeight) {
		_minImageHeight = minImageHeight;
	}

	public int getMinImageWidth() {
		return _minImageWidth;
	}

	public void setMinImageWidth(int minImageWidth) {
		_minImageWidth = minImageWidth;
	}

	private String _uuid_;
	private long _spAssetTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _spAssetTypeName;
	private boolean _status;
	private String _modifiedBy;
	private String _spAssetTypeCreateUrl;
	private String _spAssetTypeDetailUrl;
	private String _spAssetTypeInnerDetailUrl;
	private boolean _requiredTermsOfUse;
	private boolean _requiredLogin;
	private boolean _categoryMandatory;
	private boolean _notifyUponCreation;
	private long _notificationTemplateId;
	private String _allowedFileTypes;
	private int _maxFileSize;
	private int _minImageHeight;
	private int _minImageWidth;
}