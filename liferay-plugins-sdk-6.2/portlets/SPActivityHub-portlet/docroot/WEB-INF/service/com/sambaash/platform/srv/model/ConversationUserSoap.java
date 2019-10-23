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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author aishwarya
 * @generated
 */
public class ConversationUserSoap implements Serializable {
	public static ConversationUserSoap toSoapModel(ConversationUser model) {
		ConversationUserSoap soapModel = new ConversationUserSoap();

		soapModel.setSpConversationUserId(model.getSpConversationUserId());
		soapModel.setSpConversationId(model.getSpConversationId());
		soapModel.setSentToUserId(model.getSentToUserId());
		soapModel.setStatus(model.getStatus());
		soapModel.setEntityClassId(model.getEntityClassId());
		soapModel.setEntityId(model.getEntityId());

		return soapModel;
	}

	public static ConversationUserSoap[] toSoapModels(ConversationUser[] models) {
		ConversationUserSoap[] soapModels = new ConversationUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConversationUserSoap[][] toSoapModels(
		ConversationUser[][] models) {
		ConversationUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConversationUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConversationUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConversationUserSoap[] toSoapModels(
		List<ConversationUser> models) {
		List<ConversationUserSoap> soapModels = new ArrayList<ConversationUserSoap>(models.size());

		for (ConversationUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConversationUserSoap[soapModels.size()]);
	}

	public ConversationUserSoap() {
	}

	public long getPrimaryKey() {
		return _spConversationUserId;
	}

	public void setPrimaryKey(long pk) {
		setSpConversationUserId(pk);
	}

	public long getSpConversationUserId() {
		return _spConversationUserId;
	}

	public void setSpConversationUserId(long spConversationUserId) {
		_spConversationUserId = spConversationUserId;
	}

	public long getSpConversationId() {
		return _spConversationId;
	}

	public void setSpConversationId(long spConversationId) {
		_spConversationId = spConversationId;
	}

	public long getSentToUserId() {
		return _sentToUserId;
	}

	public void setSentToUserId(long sentToUserId) {
		_sentToUserId = sentToUserId;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public long getEntityClassId() {
		return _entityClassId;
	}

	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
	}

	private long _spConversationUserId;
	private long _spConversationId;
	private long _sentToUserId;
	private long _status;
	private long _entityClassId;
	private long _entityId;
}