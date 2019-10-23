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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class ATODocumentSoap implements Serializable {
	public static ATODocumentSoap toSoapModel(ATODocument model) {
		ATODocumentSoap soapModel = new ATODocumentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAtoDocumentId(model.getAtoDocumentId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setDocumentType(model.getDocumentType());
		soapModel.setDocumentFileId(model.getDocumentFileId());

		return soapModel;
	}

	public static ATODocumentSoap[] toSoapModels(ATODocument[] models) {
		ATODocumentSoap[] soapModels = new ATODocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ATODocumentSoap[][] toSoapModels(ATODocument[][] models) {
		ATODocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ATODocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ATODocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ATODocumentSoap[] toSoapModels(List<ATODocument> models) {
		List<ATODocumentSoap> soapModels = new ArrayList<ATODocumentSoap>(models.size());

		for (ATODocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ATODocumentSoap[soapModels.size()]);
	}

	public ATODocumentSoap() {
	}

	public long getPrimaryKey() {
		return _atoDocumentId;
	}

	public void setPrimaryKey(long pk) {
		setAtoDocumentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAtoDocumentId() {
		return _atoDocumentId;
	}

	public void setAtoDocumentId(long atoDocumentId) {
		_atoDocumentId = atoDocumentId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getDocumentType() {
		return _documentType;
	}

	public void setDocumentType(String documentType) {
		_documentType = documentType;
	}

	public String getDocumentFileId() {
		return _documentFileId;
	}

	public void setDocumentFileId(String documentFileId) {
		_documentFileId = documentFileId;
	}

	private String _uuid;
	private long _atoDocumentId;
	private long _organizationId;
	private String _documentType;
	private String _documentFileId;
}