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
public class StudentCourseFeeInstmntSoap implements Serializable {
	public static StudentCourseFeeInstmntSoap toSoapModel(
		StudentCourseFeeInstmnt model) {
		StudentCourseFeeInstmntSoap soapModel = new StudentCourseFeeInstmntSoap();

		soapModel.setSpStudentCourseFeeInstmntId(model.getSpStudentCourseFeeInstmntId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpPEProcessStateId(model.getSpPEProcessStateId());
		soapModel.setInsmntNo(model.getInsmntNo());
		soapModel.setAmount(model.getAmount());
		soapModel.setDate(model.getDate());

		return soapModel;
	}

	public static StudentCourseFeeInstmntSoap[] toSoapModels(
		StudentCourseFeeInstmnt[] models) {
		StudentCourseFeeInstmntSoap[] soapModels = new StudentCourseFeeInstmntSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentCourseFeeInstmntSoap[][] toSoapModels(
		StudentCourseFeeInstmnt[][] models) {
		StudentCourseFeeInstmntSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentCourseFeeInstmntSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentCourseFeeInstmntSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentCourseFeeInstmntSoap[] toSoapModels(
		List<StudentCourseFeeInstmnt> models) {
		List<StudentCourseFeeInstmntSoap> soapModels = new ArrayList<StudentCourseFeeInstmntSoap>(models.size());

		for (StudentCourseFeeInstmnt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentCourseFeeInstmntSoap[soapModels.size()]);
	}

	public StudentCourseFeeInstmntSoap() {
	}

	public long getPrimaryKey() {
		return _spStudentCourseFeeInstmntId;
	}

	public void setPrimaryKey(long pk) {
		setSpStudentCourseFeeInstmntId(pk);
	}

	public long getSpStudentCourseFeeInstmntId() {
		return _spStudentCourseFeeInstmntId;
	}

	public void setSpStudentCourseFeeInstmntId(long spStudentCourseFeeInstmntId) {
		_spStudentCourseFeeInstmntId = spStudentCourseFeeInstmntId;
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

	public long getSpPEProcessStateId() {
		return _spPEProcessStateId;
	}

	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_spPEProcessStateId = spPEProcessStateId;
	}

	public int getInsmntNo() {
		return _insmntNo;
	}

	public void setInsmntNo(int insmntNo) {
		_insmntNo = insmntNo;
	}

	public String getAmount() {
		return _amount;
	}

	public void setAmount(String amount) {
		_amount = amount;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	private long _spStudentCourseFeeInstmntId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPEProcessStateId;
	private int _insmntNo;
	private String _amount;
	private Date _date;
}