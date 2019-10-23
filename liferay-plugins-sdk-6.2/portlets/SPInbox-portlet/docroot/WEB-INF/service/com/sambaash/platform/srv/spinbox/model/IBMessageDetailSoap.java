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
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.spinbox.service.http.IBMessageDetailServiceSoap}.
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.spinbox.service.http.IBMessageDetailServiceSoap
 * @generated
 */
public class IBMessageDetailSoap implements Serializable {
	public static IBMessageDetailSoap toSoapModel(IBMessageDetail model) {
		IBMessageDetailSoap soapModel = new IBMessageDetailSoap();

		soapModel.setIbMsgDetailId(model.getIbMsgDetailId());
		soapModel.setReceiverId(model.getReceiverId());
		soapModel.setMessageId(model.getMessageId());
		soapModel.setReceiverMsgStatus(model.getReceiverMsgStatus());
		soapModel.setSenderMsgStatus(model.getSenderMsgStatus());
		soapModel.setStatus(model.getStatus());
		soapModel.setReceiveDate(model.getReceiveDate());
		soapModel.setReceiveBy(model.getReceiveBy());
		soapModel.setArchived(model.getArchived());
		soapModel.setUpdateDate(model.getUpdateDate());
		soapModel.setUpdateBy(model.getUpdateBy());
		soapModel.setCategory(model.getCategory());
		soapModel.setProcessId(model.getProcessId());
		soapModel.setCorpProfileId(model.getCorpProfileId());

		return soapModel;
	}

	public static IBMessageDetailSoap[] toSoapModels(IBMessageDetail[] models) {
		IBMessageDetailSoap[] soapModels = new IBMessageDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IBMessageDetailSoap[][] toSoapModels(
		IBMessageDetail[][] models) {
		IBMessageDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IBMessageDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IBMessageDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IBMessageDetailSoap[] toSoapModels(
		List<IBMessageDetail> models) {
		List<IBMessageDetailSoap> soapModels = new ArrayList<IBMessageDetailSoap>(models.size());

		for (IBMessageDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IBMessageDetailSoap[soapModels.size()]);
	}

	public IBMessageDetailSoap() {
	}

	public long getPrimaryKey() {
		return _ibMsgDetailId;
	}

	public void setPrimaryKey(long pk) {
		setIbMsgDetailId(pk);
	}

	public long getIbMsgDetailId() {
		return _ibMsgDetailId;
	}

	public void setIbMsgDetailId(long ibMsgDetailId) {
		_ibMsgDetailId = ibMsgDetailId;
	}

	public long getReceiverId() {
		return _receiverId;
	}

	public void setReceiverId(long receiverId) {
		_receiverId = receiverId;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public String getReceiverMsgStatus() {
		return _receiverMsgStatus;
	}

	public void setReceiverMsgStatus(String receiverMsgStatus) {
		_receiverMsgStatus = receiverMsgStatus;
	}

	public String getSenderMsgStatus() {
		return _senderMsgStatus;
	}

	public void setSenderMsgStatus(String senderMsgStatus) {
		_senderMsgStatus = senderMsgStatus;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getReceiveDate() {
		return _receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		_receiveDate = receiveDate;
	}

	public String getReceiveBy() {
		return _receiveBy;
	}

	public void setReceiveBy(String receiveBy) {
		_receiveBy = receiveBy;
	}

	public boolean getArchived() {
		return _archived;
	}

	public boolean isArchived() {
		return _archived;
	}

	public void setArchived(boolean archived) {
		_archived = archived;
	}

	public Date getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
	}

	public String getUpdateBy() {
		return _updateBy;
	}

	public void setUpdateBy(String updateBy) {
		_updateBy = updateBy;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public long getProcessId() {
		return _processId;
	}

	public void setProcessId(long processId) {
		_processId = processId;
	}

	public long getCorpProfileId() {
		return _corpProfileId;
	}

	public void setCorpProfileId(long corpProfileId) {
		_corpProfileId = corpProfileId;
	}

	private long _ibMsgDetailId;
	private long _receiverId;
	private long _messageId;
	private String _receiverMsgStatus;
	private String _senderMsgStatus;
	private String _status;
	private Date _receiveDate;
	private String _receiveBy;
	private boolean _archived;
	private Date _updateDate;
	private String _updateBy;
	private String _category;
	private long _processId;
	private long _corpProfileId;
}