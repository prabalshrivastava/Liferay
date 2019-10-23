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

package com.sambaash.platform.srv.processbuilder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author nareshchebolu
 * @generated
 */
public class PEProcessStatusTypeSoap implements Serializable {
	public static PEProcessStatusTypeSoap toSoapModel(PEProcessStatusType model) {
		PEProcessStatusTypeSoap soapModel = new PEProcessStatusTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpPEProcessStatusTypeId(model.getSpPEProcessStatusTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpPEProcessId(model.getSpPEProcessId());
		soapModel.setStatusName(model.getStatusName());
		soapModel.setSeqNo(model.getSeqNo());
		soapModel.setApproveTemplateId(model.getApproveTemplateId());
		soapModel.setRejectTemplateId(model.getRejectTemplateId());
		soapModel.setSpPEProcessStageId(model.getSpPEProcessStageId());

		return soapModel;
	}

	public static PEProcessStatusTypeSoap[] toSoapModels(
		PEProcessStatusType[] models) {
		PEProcessStatusTypeSoap[] soapModels = new PEProcessStatusTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PEProcessStatusTypeSoap[][] toSoapModels(
		PEProcessStatusType[][] models) {
		PEProcessStatusTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PEProcessStatusTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PEProcessStatusTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PEProcessStatusTypeSoap[] toSoapModels(
		List<PEProcessStatusType> models) {
		List<PEProcessStatusTypeSoap> soapModels = new ArrayList<PEProcessStatusTypeSoap>(models.size());

		for (PEProcessStatusType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PEProcessStatusTypeSoap[soapModels.size()]);
	}

	public PEProcessStatusTypeSoap() {
	}

	public long getPrimaryKey() {
		return _spPEProcessStatusTypeId;
	}

	public void setPrimaryKey(long pk) {
		setSpPEProcessStatusTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpPEProcessStatusTypeId() {
		return _spPEProcessStatusTypeId;
	}

	public void setSpPEProcessStatusTypeId(long spPEProcessStatusTypeId) {
		_spPEProcessStatusTypeId = spPEProcessStatusTypeId;
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

	public long getSpPEProcessId() {
		return _spPEProcessId;
	}

	public void setSpPEProcessId(long spPEProcessId) {
		_spPEProcessId = spPEProcessId;
	}

	public String getStatusName() {
		return _statusName;
	}

	public void setStatusName(String statusName) {
		_statusName = statusName;
	}

	public long getSeqNo() {
		return _seqNo;
	}

	public void setSeqNo(long seqNo) {
		_seqNo = seqNo;
	}

	public long getApproveTemplateId() {
		return _approveTemplateId;
	}

	public void setApproveTemplateId(long approveTemplateId) {
		_approveTemplateId = approveTemplateId;
	}

	public long getRejectTemplateId() {
		return _rejectTemplateId;
	}

	public void setRejectTemplateId(long rejectTemplateId) {
		_rejectTemplateId = rejectTemplateId;
	}

	public long getSpPEProcessStageId() {
		return _spPEProcessStageId;
	}

	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_spPEProcessStageId = spPEProcessStageId;
	}

	private String _uuid;
	private long _spPEProcessStatusTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPEProcessId;
	private String _statusName;
	private long _seqNo;
	private long _approveTemplateId;
	private long _rejectTemplateId;
	private long _spPEProcessStageId;
}