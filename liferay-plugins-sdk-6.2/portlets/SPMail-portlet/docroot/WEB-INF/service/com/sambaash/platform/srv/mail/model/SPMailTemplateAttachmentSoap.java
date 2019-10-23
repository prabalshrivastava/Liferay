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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class SPMailTemplateAttachmentSoap implements Serializable {
	public static SPMailTemplateAttachmentSoap toSoapModel(
		SPMailTemplateAttachment model) {
		SPMailTemplateAttachmentSoap soapModel = new SPMailTemplateAttachmentSoap();

		soapModel.setSpTemplateAttachmentId(model.getSpTemplateAttachmentId());
		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setRsvpId(model.getRsvpId());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static SPMailTemplateAttachmentSoap[] toSoapModels(
		SPMailTemplateAttachment[] models) {
		SPMailTemplateAttachmentSoap[] soapModels = new SPMailTemplateAttachmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPMailTemplateAttachmentSoap[][] toSoapModels(
		SPMailTemplateAttachment[][] models) {
		SPMailTemplateAttachmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPMailTemplateAttachmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPMailTemplateAttachmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPMailTemplateAttachmentSoap[] toSoapModels(
		List<SPMailTemplateAttachment> models) {
		List<SPMailTemplateAttachmentSoap> soapModels = new ArrayList<SPMailTemplateAttachmentSoap>(models.size());

		for (SPMailTemplateAttachment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPMailTemplateAttachmentSoap[soapModels.size()]);
	}

	public SPMailTemplateAttachmentSoap() {
	}

	public long getPrimaryKey() {
		return _spTemplateAttachmentId;
	}

	public void setPrimaryKey(long pk) {
		setSpTemplateAttachmentId(pk);
	}

	public long getSpTemplateAttachmentId() {
		return _spTemplateAttachmentId;
	}

	public void setSpTemplateAttachmentId(long spTemplateAttachmentId) {
		_spTemplateAttachmentId = spTemplateAttachmentId;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public long getRsvpId() {
		return _rsvpId;
	}

	public void setRsvpId(long rsvpId) {
		_rsvpId = rsvpId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	private long _spTemplateAttachmentId;
	private long _templateId;
	private long _rsvpId;
	private long _fileEntryId;
}