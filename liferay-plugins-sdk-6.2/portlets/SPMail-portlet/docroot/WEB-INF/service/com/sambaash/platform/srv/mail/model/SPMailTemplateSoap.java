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
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.mail.service.http.SPMailTemplateServiceSoap}.
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.mail.service.http.SPMailTemplateServiceSoap
 * @generated
 */
public class SPMailTemplateSoap implements Serializable {
	public static SPMailTemplateSoap toSoapModel(SPMailTemplate model) {
		SPMailTemplateSoap soapModel = new SPMailTemplateSoap();

		soapModel.setSpMailTemplateId(model.getSpMailTemplateId());
		soapModel.setProductTypeId(model.getProductTypeId());
		soapModel.setSubProductTypeId(model.getSubProductTypeId());
		soapModel.setTemplateName(model.getTemplateName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setSubject(model.getSubject());
		soapModel.setHtmlContent(model.getHtmlContent());
		soapModel.setTextContent(model.getTextContent());
		soapModel.setHtmlUpload(model.getHtmlUpload());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setParentTempalteId(model.getParentTempalteId());
		soapModel.setVersionNumber(model.getVersionNumber());
		soapModel.setFromAddress(model.getFromAddress());
		soapModel.setFromName(model.getFromName());

		return soapModel;
	}

	public static SPMailTemplateSoap[] toSoapModels(SPMailTemplate[] models) {
		SPMailTemplateSoap[] soapModels = new SPMailTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPMailTemplateSoap[][] toSoapModels(SPMailTemplate[][] models) {
		SPMailTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPMailTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPMailTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPMailTemplateSoap[] toSoapModels(List<SPMailTemplate> models) {
		List<SPMailTemplateSoap> soapModels = new ArrayList<SPMailTemplateSoap>(models.size());

		for (SPMailTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPMailTemplateSoap[soapModels.size()]);
	}

	public SPMailTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _spMailTemplateId;
	}

	public void setPrimaryKey(long pk) {
		setSpMailTemplateId(pk);
	}

	public long getSpMailTemplateId() {
		return _spMailTemplateId;
	}

	public void setSpMailTemplateId(long spMailTemplateId) {
		_spMailTemplateId = spMailTemplateId;
	}

	public long getProductTypeId() {
		return _productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		_productTypeId = productTypeId;
	}

	public long getSubProductTypeId() {
		return _subProductTypeId;
	}

	public void setSubProductTypeId(long subProductTypeId) {
		_subProductTypeId = subProductTypeId;
	}

	public String getTemplateName() {
		return _templateName;
	}

	public void setTemplateName(String templateName) {
		_templateName = templateName;
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

	public String getHtmlContent() {
		return _htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		_htmlContent = htmlContent;
	}

	public String getTextContent() {
		return _textContent;
	}

	public void setTextContent(String textContent) {
		_textContent = textContent;
	}

	public boolean getHtmlUpload() {
		return _htmlUpload;
	}

	public boolean isHtmlUpload() {
		return _htmlUpload;
	}

	public void setHtmlUpload(boolean htmlUpload) {
		_htmlUpload = htmlUpload;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public long getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(long createBy) {
		_createBy = createBy;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getParentTempalteId() {
		return _parentTempalteId;
	}

	public void setParentTempalteId(long parentTempalteId) {
		_parentTempalteId = parentTempalteId;
	}

	public String getVersionNumber() {
		return _versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		_versionNumber = versionNumber;
	}

	public String getFromAddress() {
		return _fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		_fromAddress = fromAddress;
	}

	public String getFromName() {
		return _fromName;
	}

	public void setFromName(String fromName) {
		_fromName = fromName;
	}

	private long _spMailTemplateId;
	private long _productTypeId;
	private long _subProductTypeId;
	private String _templateName;
	private long _groupId;
	private long _companyId;
	private String _subject;
	private String _htmlContent;
	private String _textContent;
	private boolean _htmlUpload;
	private boolean _status;
	private long _createBy;
	private Date _createDate;
	private long _modifiedBy;
	private Date _modifiedDate;
	private long _parentTempalteId;
	private String _versionNumber;
	private String _fromAddress;
	private String _fromName;
}