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

package com.sambaash.platform.srv.mail.model;

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
public class SPEMailAuditSoap implements Serializable {
	public static SPEMailAuditSoap toSoapModel(SPEMailAudit model) {
		SPEMailAuditSoap soapModel = new SPEMailAuditSoap();

		soapModel.setSpEMailAudit(model.getSpEMailAudit());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setSentTo(model.getSentTo());
		soapModel.setCc(model.getCc());
		soapModel.setBcc(model.getBcc());
		soapModel.setCategory(model.getCategory());
		soapModel.setSubject(model.getSubject());
		soapModel.setContent(model.getContent());
		soapModel.setSentDate(model.getSentDate());
		soapModel.setMessasgeId(model.getMessasgeId());
		soapModel.setUserId(model.getUserId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setProcessStateId(model.getProcessStateId());
		soapModel.setNodeId(model.getNodeId());

		return soapModel;
	}

	public static SPEMailAuditSoap[] toSoapModels(SPEMailAudit[] models) {
		SPEMailAuditSoap[] soapModels = new SPEMailAuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPEMailAuditSoap[][] toSoapModels(SPEMailAudit[][] models) {
		SPEMailAuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPEMailAuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPEMailAuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPEMailAuditSoap[] toSoapModels(List<SPEMailAudit> models) {
		List<SPEMailAuditSoap> soapModels = new ArrayList<SPEMailAuditSoap>(models.size());

		for (SPEMailAudit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPEMailAuditSoap[soapModels.size()]);
	}

	public SPEMailAuditSoap() {
	}

	public long getPrimaryKey() {
		return _spEMailAudit;
	}

	public void setPrimaryKey(long pk) {
		setSpEMailAudit(pk);
	}

	public long getSpEMailAudit() {
		return _spEMailAudit;
	}

	public void setSpEMailAudit(long spEMailAudit) {
		_spEMailAudit = spEMailAudit;
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

	public String getSentTo() {
		return _sentTo;
	}

	public void setSentTo(String sentTo) {
		_sentTo = sentTo;
	}

	public String getCc() {
		return _cc;
	}

	public void setCc(String cc) {
		_cc = cc;
	}

	public String getBcc() {
		return _bcc;
	}

	public void setBcc(String bcc) {
		_bcc = bcc;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
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

	public Date getSentDate() {
		return _sentDate;
	}

	public void setSentDate(Date sentDate) {
		_sentDate = sentDate;
	}

	public String getMessasgeId() {
		return _messasgeId;
	}

	public void setMessasgeId(String messasgeId) {
		_messasgeId = messasgeId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getOrgId() {
		return _orgId;
	}

	public void setOrgId(long orgId) {
		_orgId = orgId;
	}

	public long getProcessStateId() {
		return _processStateId;
	}

	public void setProcessStateId(long processStateId) {
		_processStateId = processStateId;
	}

	public long getNodeId() {
		return _nodeId;
	}

	public void setNodeId(long nodeId) {
		_nodeId = nodeId;
	}

	private long _spEMailAudit;
	private long _groupId;
	private long _companyId;
	private String _sentTo;
	private String _cc;
	private String _bcc;
	private String _category;
	private String _subject;
	private String _content;
	private Date _sentDate;
	private String _messasgeId;
	private long _userId;
	private long _orgId;
	private long _processStateId;
	private long _nodeId;
}