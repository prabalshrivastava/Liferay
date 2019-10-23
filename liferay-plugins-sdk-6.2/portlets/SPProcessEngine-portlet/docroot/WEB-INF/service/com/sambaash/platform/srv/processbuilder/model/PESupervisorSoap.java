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
public class PESupervisorSoap implements Serializable {
	public static PESupervisorSoap toSoapModel(PESupervisor model) {
		PESupervisorSoap soapModel = new PESupervisorSoap();

		soapModel.setSpPESupervisorId(model.getSpPESupervisorId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFilter1(model.getFilter1());
		soapModel.setFilter2(model.getFilter2());
		soapModel.setFilter3(model.getFilter3());
		soapModel.setFilter4(model.getFilter4());
		soapModel.setFilter5(model.getFilter5());
		soapModel.setSupervisorId(model.getSupervisorId());

		return soapModel;
	}

	public static PESupervisorSoap[] toSoapModels(PESupervisor[] models) {
		PESupervisorSoap[] soapModels = new PESupervisorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PESupervisorSoap[][] toSoapModels(PESupervisor[][] models) {
		PESupervisorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PESupervisorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PESupervisorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PESupervisorSoap[] toSoapModels(List<PESupervisor> models) {
		List<PESupervisorSoap> soapModels = new ArrayList<PESupervisorSoap>(models.size());

		for (PESupervisor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PESupervisorSoap[soapModels.size()]);
	}

	public PESupervisorSoap() {
	}

	public long getPrimaryKey() {
		return _spPESupervisorId;
	}

	public void setPrimaryKey(long pk) {
		setSpPESupervisorId(pk);
	}

	public long getSpPESupervisorId() {
		return _spPESupervisorId;
	}

	public void setSpPESupervisorId(long spPESupervisorId) {
		_spPESupervisorId = spPESupervisorId;
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

	public String getFilter1() {
		return _filter1;
	}

	public void setFilter1(String filter1) {
		_filter1 = filter1;
	}

	public String getFilter2() {
		return _filter2;
	}

	public void setFilter2(String filter2) {
		_filter2 = filter2;
	}

	public String getFilter3() {
		return _filter3;
	}

	public void setFilter3(String filter3) {
		_filter3 = filter3;
	}

	public String getFilter4() {
		return _filter4;
	}

	public void setFilter4(String filter4) {
		_filter4 = filter4;
	}

	public String getFilter5() {
		return _filter5;
	}

	public void setFilter5(String filter5) {
		_filter5 = filter5;
	}

	public long getSupervisorId() {
		return _supervisorId;
	}

	public void setSupervisorId(long supervisorId) {
		_supervisorId = supervisorId;
	}

	private long _spPESupervisorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _filter1;
	private String _filter2;
	private String _filter3;
	private String _filter4;
	private String _filter5;
	private long _supervisorId;
}