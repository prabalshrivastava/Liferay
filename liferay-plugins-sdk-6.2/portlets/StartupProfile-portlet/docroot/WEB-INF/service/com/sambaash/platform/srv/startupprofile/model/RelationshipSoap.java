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

package com.sambaash.platform.srv.startupprofile.model;

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
public class RelationshipSoap implements Serializable {
	public static RelationshipSoap toSoapModel(Relationship model) {
		RelationshipSoap soapModel = new RelationshipSoap();

		soapModel.setRelationshipId(model.getRelationshipId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setRefId(model.getRefId());
		soapModel.setRefTypeId(model.getRefTypeId());
		soapModel.setRelation(model.getRelation());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static RelationshipSoap[] toSoapModels(Relationship[] models) {
		RelationshipSoap[] soapModels = new RelationshipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RelationshipSoap[][] toSoapModels(Relationship[][] models) {
		RelationshipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RelationshipSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RelationshipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RelationshipSoap[] toSoapModels(List<Relationship> models) {
		List<RelationshipSoap> soapModels = new ArrayList<RelationshipSoap>(models.size());

		for (Relationship model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RelationshipSoap[soapModels.size()]);
	}

	public RelationshipSoap() {
	}

	public long getPrimaryKey() {
		return _relationshipId;
	}

	public void setPrimaryKey(long pk) {
		setRelationshipId(pk);
	}

	public long getRelationshipId() {
		return _relationshipId;
	}

	public void setRelationshipId(long relationshipId) {
		_relationshipId = relationshipId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getRefId() {
		return _refId;
	}

	public void setRefId(long refId) {
		_refId = refId;
	}

	public long getRefTypeId() {
		return _refTypeId;
	}

	public void setRefTypeId(long refTypeId) {
		_refTypeId = refTypeId;
	}

	public long getRelation() {
		return _relation;
	}

	public void setRelation(long relation) {
		_relation = relation;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _relationshipId;
	private long _organizationId;
	private long _refId;
	private long _refTypeId;
	private long _relation;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
}