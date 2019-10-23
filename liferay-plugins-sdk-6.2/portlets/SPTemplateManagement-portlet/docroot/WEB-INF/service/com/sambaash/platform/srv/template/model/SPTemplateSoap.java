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

package com.sambaash.platform.srv.template.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author WattabyteIT
 * @generated
 */
public class SPTemplateSoap implements Serializable {
	public static SPTemplateSoap toSoapModel(SPTemplate model) {
		SPTemplateSoap soapModel = new SPTemplateSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpTemplateId(model.getSpTemplateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setTemplateName(model.getTemplateName());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SPTemplateSoap[] toSoapModels(SPTemplate[] models) {
		SPTemplateSoap[] soapModels = new SPTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPTemplateSoap[][] toSoapModels(SPTemplate[][] models) {
		SPTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPTemplateSoap[] toSoapModels(List<SPTemplate> models) {
		List<SPTemplateSoap> soapModels = new ArrayList<SPTemplateSoap>(models.size());

		for (SPTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPTemplateSoap[soapModels.size()]);
	}

	public SPTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _spTemplateId;
	}

	public void setPrimaryKey(long pk) {
		setSpTemplateId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpTemplateId() {
		return _spTemplateId;
	}

	public void setSpTemplateId(long spTemplateId) {
		_spTemplateId = spTemplateId;
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

	public long getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(long createBy) {
		_createBy = createBy;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getTemplateName() {
		return _templateName;
	}

	public void setTemplateName(String templateName) {
		_templateName = templateName;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _uuid;
	private long _spTemplateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _createBy;
	private long _modifiedBy;
	private long _classNameId;
	private long _classPK;
	private String _templateName;
	private int _status;
}