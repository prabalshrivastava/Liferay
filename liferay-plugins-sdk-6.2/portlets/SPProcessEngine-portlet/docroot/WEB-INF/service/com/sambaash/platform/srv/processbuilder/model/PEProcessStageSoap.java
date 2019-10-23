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
public class PEProcessStageSoap implements Serializable {
	public static PEProcessStageSoap toSoapModel(PEProcessStage model) {
		PEProcessStageSoap soapModel = new PEProcessStageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpPEProcessStageId(model.getSpPEProcessStageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setStyle(model.getStyle());
		soapModel.setSeqNo(model.getSeqNo());

		return soapModel;
	}

	public static PEProcessStageSoap[] toSoapModels(PEProcessStage[] models) {
		PEProcessStageSoap[] soapModels = new PEProcessStageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PEProcessStageSoap[][] toSoapModels(PEProcessStage[][] models) {
		PEProcessStageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PEProcessStageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PEProcessStageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PEProcessStageSoap[] toSoapModels(List<PEProcessStage> models) {
		List<PEProcessStageSoap> soapModels = new ArrayList<PEProcessStageSoap>(models.size());

		for (PEProcessStage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PEProcessStageSoap[soapModels.size()]);
	}

	public PEProcessStageSoap() {
	}

	public long getPrimaryKey() {
		return _spPEProcessStageId;
	}

	public void setPrimaryKey(long pk) {
		setSpPEProcessStageId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpPEProcessStageId() {
		return _spPEProcessStageId;
	}

	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_spPEProcessStageId = spPEProcessStageId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getStyle() {
		return _style;
	}

	public void setStyle(String style) {
		_style = style;
	}

	public long getSeqNo() {
		return _seqNo;
	}

	public void setSeqNo(long seqNo) {
		_seqNo = seqNo;
	}

	private String _uuid;
	private long _spPEProcessStageId;
	private long _groupId;
	private long _userId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _style;
	private long _seqNo;
}