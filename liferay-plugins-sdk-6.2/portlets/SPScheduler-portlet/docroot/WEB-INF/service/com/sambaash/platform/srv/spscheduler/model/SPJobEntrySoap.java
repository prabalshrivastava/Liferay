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

package com.sambaash.platform.srv.spscheduler.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class SPJobEntrySoap implements Serializable {
	public static SPJobEntrySoap toSoapModel(SPJobEntry model) {
		SPJobEntrySoap soapModel = new SPJobEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpJobEntryId(model.getSpJobEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setJobName(model.getJobName());
		soapModel.setJobClass(model.getJobClass());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusMsg(model.getStatusMsg());
		soapModel.setCronExpression(model.getCronExpression());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPJobEntrySoap[] toSoapModels(SPJobEntry[] models) {
		SPJobEntrySoap[] soapModels = new SPJobEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPJobEntrySoap[][] toSoapModels(SPJobEntry[][] models) {
		SPJobEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPJobEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPJobEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPJobEntrySoap[] toSoapModels(List<SPJobEntry> models) {
		List<SPJobEntrySoap> soapModels = new ArrayList<SPJobEntrySoap>(models.size());

		for (SPJobEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPJobEntrySoap[soapModels.size()]);
	}

	public SPJobEntrySoap() {
	}

	public long getPrimaryKey() {
		return _spJobEntryId;
	}

	public void setPrimaryKey(long pk) {
		setSpJobEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpJobEntryId() {
		return _spJobEntryId;
	}

	public void setSpJobEntryId(long spJobEntryId) {
		_spJobEntryId = spJobEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getJobName() {
		return _jobName;
	}

	public void setJobName(String jobName) {
		_jobName = jobName;
	}

	public String getJobClass() {
		return _jobClass;
	}

	public void setJobClass(String jobClass) {
		_jobClass = jobClass;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getStatusMsg() {
		return _statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		_statusMsg = statusMsg;
	}

	public String getCronExpression() {
		return _cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		_cronExpression = cronExpression;
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

	private String _uuid;
	private long _spJobEntryId;
	private long _groupId;
	private String _jobName;
	private String _jobClass;
	private String _portletId;
	private int _status;
	private String _statusMsg;
	private String _cronExpression;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}