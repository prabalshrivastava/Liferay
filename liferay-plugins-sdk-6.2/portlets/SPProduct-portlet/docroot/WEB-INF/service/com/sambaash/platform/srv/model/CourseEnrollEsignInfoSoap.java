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

package com.sambaash.platform.srv.model;

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
public class CourseEnrollEsignInfoSoap implements Serializable {
	public static CourseEnrollEsignInfoSoap toSoapModel(
		CourseEnrollEsignInfo model) {
		CourseEnrollEsignInfoSoap soapModel = new CourseEnrollEsignInfoSoap();

		soapModel.setSpEsignInfoId(model.getSpEsignInfoId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSignerId(model.getSignerId());
		soapModel.setPackageId(model.getPackageId());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setLastGeneratedUrl(model.getLastGeneratedUrl());
		soapModel.setSpPEProcessStateId(model.getSpPEProcessStateId());
		soapModel.setExtraInfo(model.getExtraInfo());

		return soapModel;
	}

	public static CourseEnrollEsignInfoSoap[] toSoapModels(
		CourseEnrollEsignInfo[] models) {
		CourseEnrollEsignInfoSoap[] soapModels = new CourseEnrollEsignInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseEnrollEsignInfoSoap[][] toSoapModels(
		CourseEnrollEsignInfo[][] models) {
		CourseEnrollEsignInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseEnrollEsignInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseEnrollEsignInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseEnrollEsignInfoSoap[] toSoapModels(
		List<CourseEnrollEsignInfo> models) {
		List<CourseEnrollEsignInfoSoap> soapModels = new ArrayList<CourseEnrollEsignInfoSoap>(models.size());

		for (CourseEnrollEsignInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseEnrollEsignInfoSoap[soapModels.size()]);
	}

	public CourseEnrollEsignInfoSoap() {
	}

	public long getPrimaryKey() {
		return _spEsignInfoId;
	}

	public void setPrimaryKey(long pk) {
		setSpEsignInfoId(pk);
	}

	public long getSpEsignInfoId() {
		return _spEsignInfoId;
	}

	public void setSpEsignInfoId(long spEsignInfoId) {
		_spEsignInfoId = spEsignInfoId;
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

	public String getSignerId() {
		return _signerId;
	}

	public void setSignerId(String signerId) {
		_signerId = signerId;
	}

	public String getPackageId() {
		return _packageId;
	}

	public void setPackageId(String packageId) {
		_packageId = packageId;
	}

	public String getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(String documentId) {
		_documentId = documentId;
	}

	public String getLastGeneratedUrl() {
		return _lastGeneratedUrl;
	}

	public void setLastGeneratedUrl(String lastGeneratedUrl) {
		_lastGeneratedUrl = lastGeneratedUrl;
	}

	public long getSpPEProcessStateId() {
		return _spPEProcessStateId;
	}

	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_spPEProcessStateId = spPEProcessStateId;
	}

	public String getExtraInfo() {
		return _extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		_extraInfo = extraInfo;
	}

	private long _spEsignInfoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _signerId;
	private String _packageId;
	private String _documentId;
	private String _lastGeneratedUrl;
	private long _spPEProcessStateId;
	private String _extraInfo;
}