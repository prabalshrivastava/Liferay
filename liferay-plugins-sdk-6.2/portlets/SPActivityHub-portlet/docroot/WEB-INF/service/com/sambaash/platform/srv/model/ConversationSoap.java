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
 * @author aishwarya
 * @generated
 */
public class ConversationSoap implements Serializable {
	public static ConversationSoap toSoapModel(Conversation model) {
		ConversationSoap soapModel = new ConversationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpConversationId(model.getSpConversationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEntityClassId(model.getEntityClassId());
		soapModel.setEntityClassName(model.getEntityClassName());
		soapModel.setEntityId(model.getEntityId());
		soapModel.setSentByUserId(model.getSentByUserId());
		soapModel.setMessage(model.getMessage());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setAssociatedWith(model.getAssociatedWith());
		soapModel.setRestricted(model.getRestricted());
		soapModel.setStatus(model.getStatus());
		soapModel.setParentConverstationId(model.getParentConverstationId());
		soapModel.setCurrentPlId(model.getCurrentPlId());

		return soapModel;
	}

	public static ConversationSoap[] toSoapModels(Conversation[] models) {
		ConversationSoap[] soapModels = new ConversationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConversationSoap[][] toSoapModels(Conversation[][] models) {
		ConversationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConversationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConversationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConversationSoap[] toSoapModels(List<Conversation> models) {
		List<ConversationSoap> soapModels = new ArrayList<ConversationSoap>(models.size());

		for (Conversation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConversationSoap[soapModels.size()]);
	}

	public ConversationSoap() {
	}

	public long getPrimaryKey() {
		return _spConversationId;
	}

	public void setPrimaryKey(long pk) {
		setSpConversationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpConversationId() {
		return _spConversationId;
	}

	public void setSpConversationId(long spConversationId) {
		_spConversationId = spConversationId;
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

	public long getEntityClassId() {
		return _entityClassId;
	}

	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;
	}

	public String getEntityClassName() {
		return _entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
	}

	public long getSentByUserId() {
		return _sentByUserId;
	}

	public void setSentByUserId(long sentByUserId) {
		_sentByUserId = sentByUserId;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(String fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getAssociatedWith() {
		return _associatedWith;
	}

	public void setAssociatedWith(long associatedWith) {
		_associatedWith = associatedWith;
	}

	public int getRestricted() {
		return _restricted;
	}

	public void setRestricted(int restricted) {
		_restricted = restricted;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getParentConverstationId() {
		return _parentConverstationId;
	}

	public void setParentConverstationId(long parentConverstationId) {
		_parentConverstationId = parentConverstationId;
	}

	public long getCurrentPlId() {
		return _currentPlId;
	}

	public void setCurrentPlId(long currentPlId) {
		_currentPlId = currentPlId;
	}

	private String _uuid;
	private long _spConversationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _entityClassId;
	private String _entityClassName;
	private long _entityId;
	private long _sentByUserId;
	private String _message;
	private String _fileEntryId;
	private long _associatedWith;
	private int _restricted;
	private int _status;
	private long _parentConverstationId;
	private long _currentPlId;
}