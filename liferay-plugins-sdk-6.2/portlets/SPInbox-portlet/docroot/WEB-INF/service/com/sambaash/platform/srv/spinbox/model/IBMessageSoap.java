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

package com.sambaash.platform.srv.spinbox.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.spinbox.service.http.IBMessageServiceSoap}.
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.spinbox.service.http.IBMessageServiceSoap
 * @generated
 */
public class IBMessageSoap implements Serializable {
	public static IBMessageSoap toSoapModel(IBMessage model) {
		IBMessageSoap soapModel = new IBMessageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMessageId(model.getMessageId());
		soapModel.setParentMessageId(model.getParentMessageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setSubject(model.getSubject());
		soapModel.setContent(model.getContent());
		soapModel.setFrom(model.getFrom());
		soapModel.setTo(model.getTo());
		soapModel.setAllowOpen(model.getAllowOpen());
		soapModel.setSendDate(model.getSendDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setCreateByUserId(model.getCreateByUserId());
		soapModel.setDraft(model.getDraft());
		soapModel.setDeleteStatus(model.getDeleteStatus());
		soapModel.setDraftStatus(model.getDraftStatus());
		soapModel.setSentMeCopy(model.getSentMeCopy());
		soapModel.setBelongToGroupDetailId(model.getBelongToGroupDetailId());

		return soapModel;
	}

	public static IBMessageSoap[] toSoapModels(IBMessage[] models) {
		IBMessageSoap[] soapModels = new IBMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IBMessageSoap[][] toSoapModels(IBMessage[][] models) {
		IBMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IBMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IBMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IBMessageSoap[] toSoapModels(List<IBMessage> models) {
		List<IBMessageSoap> soapModels = new ArrayList<IBMessageSoap>(models.size());

		for (IBMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IBMessageSoap[soapModels.size()]);
	}

	public IBMessageSoap() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public long getParentMessageId() {
		return _parentMessageId;
	}

	public void setParentMessageId(long parentMessageId) {
		_parentMessageId = parentMessageId;
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

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getFrom() {
		return _from;
	}

	public void setFrom(String from) {
		_from = from;
	}

	public String getTo() {
		return _to;
	}

	public void setTo(String to) {
		_to = to;
	}

	public boolean getAllowOpen() {
		return _allowOpen;
	}

	public boolean isAllowOpen() {
		return _allowOpen;
	}

	public void setAllowOpen(boolean allowOpen) {
		_allowOpen = allowOpen;
	}

	public Date getSendDate() {
		return _sendDate;
	}

	public void setSendDate(Date sendDate) {
		_sendDate = sendDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(String createBy) {
		_createBy = createBy;
	}

	public String getCreateByUserId() {
		return _createByUserId;
	}

	public void setCreateByUserId(String createByUserId) {
		_createByUserId = createByUserId;
	}

	public boolean getDraft() {
		return _draft;
	}

	public boolean isDraft() {
		return _draft;
	}

	public void setDraft(boolean draft) {
		_draft = draft;
	}

	public boolean getDeleteStatus() {
		return _deleteStatus;
	}

	public boolean isDeleteStatus() {
		return _deleteStatus;
	}

	public void setDeleteStatus(boolean deleteStatus) {
		_deleteStatus = deleteStatus;
	}

	public String getDraftStatus() {
		return _draftStatus;
	}

	public void setDraftStatus(String draftStatus) {
		_draftStatus = draftStatus;
	}

	public boolean getSentMeCopy() {
		return _sentMeCopy;
	}

	public boolean isSentMeCopy() {
		return _sentMeCopy;
	}

	public void setSentMeCopy(boolean sentMeCopy) {
		_sentMeCopy = sentMeCopy;
	}

	public long getBelongToGroupDetailId() {
		return _belongToGroupDetailId;
	}

	public void setBelongToGroupDetailId(long belongToGroupDetailId) {
		_belongToGroupDetailId = belongToGroupDetailId;
	}

	private String _uuid;
	private long _messageId;
	private long _parentMessageId;
	private long _groupId;
	private long _companyId;
	private String _subject;
	private String _content;
	private String _from;
	private String _to;
	private boolean _allowOpen;
	private Date _sendDate;
	private Date _createDate;
	private String _createBy;
	private String _createByUserId;
	private boolean _draft;
	private boolean _deleteStatus;
	private String _draftStatus;
	private boolean _sentMeCopy;
	private long _belongToGroupDetailId;
}