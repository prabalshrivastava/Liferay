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
public class StudentCourseFeeSoap implements Serializable {
	public static StudentCourseFeeSoap toSoapModel(StudentCourseFee model) {
		StudentCourseFeeSoap soapModel = new StudentCourseFeeSoap();

		soapModel.setSpStudentCourseFeeId(model.getSpStudentCourseFeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpPEProcessStateId(model.getSpPEProcessStateId());
		soapModel.setFeeType(model.getFeeType());
		soapModel.setAmount(model.getAmount());
		soapModel.setOrder(model.getOrder());
		soapModel.setFormula(model.getFormula());
		soapModel.setLabel(model.getLabel());

		return soapModel;
	}

	public static StudentCourseFeeSoap[] toSoapModels(StudentCourseFee[] models) {
		StudentCourseFeeSoap[] soapModels = new StudentCourseFeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentCourseFeeSoap[][] toSoapModels(
		StudentCourseFee[][] models) {
		StudentCourseFeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentCourseFeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentCourseFeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentCourseFeeSoap[] toSoapModels(
		List<StudentCourseFee> models) {
		List<StudentCourseFeeSoap> soapModels = new ArrayList<StudentCourseFeeSoap>(models.size());

		for (StudentCourseFee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentCourseFeeSoap[soapModels.size()]);
	}

	public StudentCourseFeeSoap() {
	}

	public long getPrimaryKey() {
		return _spStudentCourseFeeId;
	}

	public void setPrimaryKey(long pk) {
		setSpStudentCourseFeeId(pk);
	}

	public long getSpStudentCourseFeeId() {
		return _spStudentCourseFeeId;
	}

	public void setSpStudentCourseFeeId(long spStudentCourseFeeId) {
		_spStudentCourseFeeId = spStudentCourseFeeId;
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

	public String getFeeType() {
		return _feeType;
	}

	public void setFeeType(String feeType) {
		_feeType = feeType;
	}

	public String getAmount() {
		return _amount;
	}

	public void setAmount(String amount) {
		_amount = amount;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public String getFormula() {
		return _formula;
	}

	public void setFormula(String formula) {
		_formula = formula;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	private long _spStudentCourseFeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPEProcessStateId;
	private String _feeType;
	private String _amount;
	private int _order;
	private String _formula;
	private String _label;
}