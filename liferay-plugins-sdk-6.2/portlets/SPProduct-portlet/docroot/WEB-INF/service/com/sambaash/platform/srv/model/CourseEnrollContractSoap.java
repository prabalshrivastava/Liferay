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
public class CourseEnrollContractSoap implements Serializable {
	public static CourseEnrollContractSoap toSoapModel(
		CourseEnrollContract model) {
		CourseEnrollContractSoap soapModel = new CourseEnrollContractSoap();

		soapModel.setSpCourseContractId(model.getSpCourseContractId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setCourseType(model.getCourseType());
		soapModel.setDocType(model.getDocType());
		soapModel.setSeqNo(model.getSeqNo());
		soapModel.setContractTemplateFileEntryId(model.getContractTemplateFileEntryId());
		soapModel.setDataTemplateFileEntryId(model.getDataTemplateFileEntryId());
		soapModel.setExtraInfo(model.getExtraInfo());

		return soapModel;
	}

	public static CourseEnrollContractSoap[] toSoapModels(
		CourseEnrollContract[] models) {
		CourseEnrollContractSoap[] soapModels = new CourseEnrollContractSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseEnrollContractSoap[][] toSoapModels(
		CourseEnrollContract[][] models) {
		CourseEnrollContractSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseEnrollContractSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseEnrollContractSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseEnrollContractSoap[] toSoapModels(
		List<CourseEnrollContract> models) {
		List<CourseEnrollContractSoap> soapModels = new ArrayList<CourseEnrollContractSoap>(models.size());

		for (CourseEnrollContract model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseEnrollContractSoap[soapModels.size()]);
	}

	public CourseEnrollContractSoap() {
	}

	public long getPrimaryKey() {
		return _spCourseContractId;
	}

	public void setPrimaryKey(long pk) {
		setSpCourseContractId(pk);
	}

	public long getSpCourseContractId() {
		return _spCourseContractId;
	}

	public void setSpCourseContractId(long spCourseContractId) {
		_spCourseContractId = spCourseContractId;
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

	public String getCountryId() {
		return _countryId;
	}

	public void setCountryId(String countryId) {
		_countryId = countryId;
	}

	public long getCourseType() {
		return _courseType;
	}

	public void setCourseType(long courseType) {
		_courseType = courseType;
	}

	public String getDocType() {
		return _docType;
	}

	public void setDocType(String docType) {
		_docType = docType;
	}

	public int getSeqNo() {
		return _seqNo;
	}

	public void setSeqNo(int seqNo) {
		_seqNo = seqNo;
	}

	public long getContractTemplateFileEntryId() {
		return _contractTemplateFileEntryId;
	}

	public void setContractTemplateFileEntryId(long contractTemplateFileEntryId) {
		_contractTemplateFileEntryId = contractTemplateFileEntryId;
	}

	public long getDataTemplateFileEntryId() {
		return _dataTemplateFileEntryId;
	}

	public void setDataTemplateFileEntryId(long dataTemplateFileEntryId) {
		_dataTemplateFileEntryId = dataTemplateFileEntryId;
	}

	public String getExtraInfo() {
		return _extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		_extraInfo = extraInfo;
	}

	private long _spCourseContractId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _countryId;
	private long _courseType;
	private String _docType;
	private int _seqNo;
	private long _contractTemplateFileEntryId;
	private long _dataTemplateFileEntryId;
	private String _extraInfo;
}