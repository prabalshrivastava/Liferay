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

package com.sambaash.platform.srv.spservices.model;

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
public class SPLikesSoap implements Serializable {
	public static SPLikesSoap toSoapModel(SPLikes model) {
		SPLikesSoap soapModel = new SPLikesSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpLikesId(model.getSpLikesId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLayoutSetId(model.getLayoutSetId());
		soapModel.setAction(model.getAction());
		soapModel.setActorUserId(model.getActorUserId());
		soapModel.setClassId(model.getClassId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());

		return soapModel;
	}

	public static SPLikesSoap[] toSoapModels(SPLikes[] models) {
		SPLikesSoap[] soapModels = new SPLikesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPLikesSoap[][] toSoapModels(SPLikes[][] models) {
		SPLikesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPLikesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPLikesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPLikesSoap[] toSoapModels(List<SPLikes> models) {
		List<SPLikesSoap> soapModels = new ArrayList<SPLikesSoap>(models.size());

		for (SPLikes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPLikesSoap[soapModels.size()]);
	}

	public SPLikesSoap() {
	}

	public long getPrimaryKey() {
		return _spLikesId;
	}

	public void setPrimaryKey(long pk) {
		setSpLikesId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpLikesId() {
		return _spLikesId;
	}

	public void setSpLikesId(long spLikesId) {
		_spLikesId = spLikesId;
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

	public long getLayoutSetId() {
		return _layoutSetId;
	}

	public void setLayoutSetId(long layoutSetId) {
		_layoutSetId = layoutSetId;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public long getActorUserId() {
		return _actorUserId;
	}

	public void setActorUserId(long actorUserId) {
		_actorUserId = actorUserId;
	}

	public long getClassId() {
		return _classId;
	}

	public void setClassId(long classId) {
		_classId = classId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	private String _uuid;
	private long _spLikesId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _layoutSetId;
	private String _action;
	private long _actorUserId;
	private long _classId;
	private String _className;
	private long _classPK;
}