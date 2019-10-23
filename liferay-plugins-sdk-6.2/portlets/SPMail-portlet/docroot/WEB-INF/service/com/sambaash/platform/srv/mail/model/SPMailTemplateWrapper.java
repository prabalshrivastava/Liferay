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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPMailTemplate}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailTemplate
 * @generated
 */
public class SPMailTemplateWrapper implements SPMailTemplate,
	ModelWrapper<SPMailTemplate> {
	public SPMailTemplateWrapper(SPMailTemplate spMailTemplate) {
		_spMailTemplate = spMailTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailTemplateId", getSpMailTemplateId());
		attributes.put("productTypeId", getProductTypeId());
		attributes.put("subProductTypeId", getSubProductTypeId());
		attributes.put("templateName", getTemplateName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("subject", getSubject());
		attributes.put("htmlContent", getHtmlContent());
		attributes.put("textContent", getTextContent());
		attributes.put("htmlUpload", getHtmlUpload());
		attributes.put("status", getStatus());
		attributes.put("createBy", getCreateBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("parentTempalteId", getParentTempalteId());
		attributes.put("versionNumber", getVersionNumber());
		attributes.put("fromAddress", getFromAddress());
		attributes.put("fromName", getFromName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailTemplateId = (Long)attributes.get("spMailTemplateId");

		if (spMailTemplateId != null) {
			setSpMailTemplateId(spMailTemplateId);
		}

		Long productTypeId = (Long)attributes.get("productTypeId");

		if (productTypeId != null) {
			setProductTypeId(productTypeId);
		}

		Long subProductTypeId = (Long)attributes.get("subProductTypeId");

		if (subProductTypeId != null) {
			setSubProductTypeId(subProductTypeId);
		}

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String htmlContent = (String)attributes.get("htmlContent");

		if (htmlContent != null) {
			setHtmlContent(htmlContent);
		}

		String textContent = (String)attributes.get("textContent");

		if (textContent != null) {
			setTextContent(textContent);
		}

		Boolean htmlUpload = (Boolean)attributes.get("htmlUpload");

		if (htmlUpload != null) {
			setHtmlUpload(htmlUpload);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long createBy = (Long)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long parentTempalteId = (Long)attributes.get("parentTempalteId");

		if (parentTempalteId != null) {
			setParentTempalteId(parentTempalteId);
		}

		String versionNumber = (String)attributes.get("versionNumber");

		if (versionNumber != null) {
			setVersionNumber(versionNumber);
		}

		String fromAddress = (String)attributes.get("fromAddress");

		if (fromAddress != null) {
			setFromAddress(fromAddress);
		}

		String fromName = (String)attributes.get("fromName");

		if (fromName != null) {
			setFromName(fromName);
		}
	}

	/**
	* Returns the primary key of this s p mail template.
	*
	* @return the primary key of this s p mail template
	*/
	@Override
	public long getPrimaryKey() {
		return _spMailTemplate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p mail template.
	*
	* @param primaryKey the primary key of this s p mail template
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spMailTemplate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp mail template ID of this s p mail template.
	*
	* @return the sp mail template ID of this s p mail template
	*/
	@Override
	public long getSpMailTemplateId() {
		return _spMailTemplate.getSpMailTemplateId();
	}

	/**
	* Sets the sp mail template ID of this s p mail template.
	*
	* @param spMailTemplateId the sp mail template ID of this s p mail template
	*/
	@Override
	public void setSpMailTemplateId(long spMailTemplateId) {
		_spMailTemplate.setSpMailTemplateId(spMailTemplateId);
	}

	/**
	* Returns the product type ID of this s p mail template.
	*
	* @return the product type ID of this s p mail template
	*/
	@Override
	public long getProductTypeId() {
		return _spMailTemplate.getProductTypeId();
	}

	/**
	* Sets the product type ID of this s p mail template.
	*
	* @param productTypeId the product type ID of this s p mail template
	*/
	@Override
	public void setProductTypeId(long productTypeId) {
		_spMailTemplate.setProductTypeId(productTypeId);
	}

	/**
	* Returns the sub product type ID of this s p mail template.
	*
	* @return the sub product type ID of this s p mail template
	*/
	@Override
	public long getSubProductTypeId() {
		return _spMailTemplate.getSubProductTypeId();
	}

	/**
	* Sets the sub product type ID of this s p mail template.
	*
	* @param subProductTypeId the sub product type ID of this s p mail template
	*/
	@Override
	public void setSubProductTypeId(long subProductTypeId) {
		_spMailTemplate.setSubProductTypeId(subProductTypeId);
	}

	/**
	* Returns the template name of this s p mail template.
	*
	* @return the template name of this s p mail template
	*/
	@Override
	public java.lang.String getTemplateName() {
		return _spMailTemplate.getTemplateName();
	}

	/**
	* Sets the template name of this s p mail template.
	*
	* @param templateName the template name of this s p mail template
	*/
	@Override
	public void setTemplateName(java.lang.String templateName) {
		_spMailTemplate.setTemplateName(templateName);
	}

	/**
	* Returns the group ID of this s p mail template.
	*
	* @return the group ID of this s p mail template
	*/
	@Override
	public long getGroupId() {
		return _spMailTemplate.getGroupId();
	}

	/**
	* Sets the group ID of this s p mail template.
	*
	* @param groupId the group ID of this s p mail template
	*/
	@Override
	public void setGroupId(long groupId) {
		_spMailTemplate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p mail template.
	*
	* @return the company ID of this s p mail template
	*/
	@Override
	public long getCompanyId() {
		return _spMailTemplate.getCompanyId();
	}

	/**
	* Sets the company ID of this s p mail template.
	*
	* @param companyId the company ID of this s p mail template
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spMailTemplate.setCompanyId(companyId);
	}

	/**
	* Returns the subject of this s p mail template.
	*
	* @return the subject of this s p mail template
	*/
	@Override
	public java.lang.String getSubject() {
		return _spMailTemplate.getSubject();
	}

	/**
	* Sets the subject of this s p mail template.
	*
	* @param subject the subject of this s p mail template
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_spMailTemplate.setSubject(subject);
	}

	/**
	* Returns the html content of this s p mail template.
	*
	* @return the html content of this s p mail template
	*/
	@Override
	public java.lang.String getHtmlContent() {
		return _spMailTemplate.getHtmlContent();
	}

	/**
	* Sets the html content of this s p mail template.
	*
	* @param htmlContent the html content of this s p mail template
	*/
	@Override
	public void setHtmlContent(java.lang.String htmlContent) {
		_spMailTemplate.setHtmlContent(htmlContent);
	}

	/**
	* Returns the text content of this s p mail template.
	*
	* @return the text content of this s p mail template
	*/
	@Override
	public java.lang.String getTextContent() {
		return _spMailTemplate.getTextContent();
	}

	/**
	* Sets the text content of this s p mail template.
	*
	* @param textContent the text content of this s p mail template
	*/
	@Override
	public void setTextContent(java.lang.String textContent) {
		_spMailTemplate.setTextContent(textContent);
	}

	/**
	* Returns the html upload of this s p mail template.
	*
	* @return the html upload of this s p mail template
	*/
	@Override
	public boolean getHtmlUpload() {
		return _spMailTemplate.getHtmlUpload();
	}

	/**
	* Returns <code>true</code> if this s p mail template is html upload.
	*
	* @return <code>true</code> if this s p mail template is html upload; <code>false</code> otherwise
	*/
	@Override
	public boolean isHtmlUpload() {
		return _spMailTemplate.isHtmlUpload();
	}

	/**
	* Sets whether this s p mail template is html upload.
	*
	* @param htmlUpload the html upload of this s p mail template
	*/
	@Override
	public void setHtmlUpload(boolean htmlUpload) {
		_spMailTemplate.setHtmlUpload(htmlUpload);
	}

	/**
	* Returns the status of this s p mail template.
	*
	* @return the status of this s p mail template
	*/
	@Override
	public boolean getStatus() {
		return _spMailTemplate.getStatus();
	}

	/**
	* Returns <code>true</code> if this s p mail template is status.
	*
	* @return <code>true</code> if this s p mail template is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _spMailTemplate.isStatus();
	}

	/**
	* Sets whether this s p mail template is status.
	*
	* @param status the status of this s p mail template
	*/
	@Override
	public void setStatus(boolean status) {
		_spMailTemplate.setStatus(status);
	}

	/**
	* Returns the create by of this s p mail template.
	*
	* @return the create by of this s p mail template
	*/
	@Override
	public long getCreateBy() {
		return _spMailTemplate.getCreateBy();
	}

	/**
	* Sets the create by of this s p mail template.
	*
	* @param createBy the create by of this s p mail template
	*/
	@Override
	public void setCreateBy(long createBy) {
		_spMailTemplate.setCreateBy(createBy);
	}

	/**
	* Returns the create date of this s p mail template.
	*
	* @return the create date of this s p mail template
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spMailTemplate.getCreateDate();
	}

	/**
	* Sets the create date of this s p mail template.
	*
	* @param createDate the create date of this s p mail template
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spMailTemplate.setCreateDate(createDate);
	}

	/**
	* Returns the modified by of this s p mail template.
	*
	* @return the modified by of this s p mail template
	*/
	@Override
	public long getModifiedBy() {
		return _spMailTemplate.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p mail template.
	*
	* @param modifiedBy the modified by of this s p mail template
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_spMailTemplate.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the modified date of this s p mail template.
	*
	* @return the modified date of this s p mail template
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spMailTemplate.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p mail template.
	*
	* @param modifiedDate the modified date of this s p mail template
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spMailTemplate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the parent tempalte ID of this s p mail template.
	*
	* @return the parent tempalte ID of this s p mail template
	*/
	@Override
	public long getParentTempalteId() {
		return _spMailTemplate.getParentTempalteId();
	}

	/**
	* Sets the parent tempalte ID of this s p mail template.
	*
	* @param parentTempalteId the parent tempalte ID of this s p mail template
	*/
	@Override
	public void setParentTempalteId(long parentTempalteId) {
		_spMailTemplate.setParentTempalteId(parentTempalteId);
	}

	/**
	* Returns the version number of this s p mail template.
	*
	* @return the version number of this s p mail template
	*/
	@Override
	public java.lang.String getVersionNumber() {
		return _spMailTemplate.getVersionNumber();
	}

	/**
	* Sets the version number of this s p mail template.
	*
	* @param versionNumber the version number of this s p mail template
	*/
	@Override
	public void setVersionNumber(java.lang.String versionNumber) {
		_spMailTemplate.setVersionNumber(versionNumber);
	}

	/**
	* Returns the from address of this s p mail template.
	*
	* @return the from address of this s p mail template
	*/
	@Override
	public java.lang.String getFromAddress() {
		return _spMailTemplate.getFromAddress();
	}

	/**
	* Sets the from address of this s p mail template.
	*
	* @param fromAddress the from address of this s p mail template
	*/
	@Override
	public void setFromAddress(java.lang.String fromAddress) {
		_spMailTemplate.setFromAddress(fromAddress);
	}

	/**
	* Returns the from name of this s p mail template.
	*
	* @return the from name of this s p mail template
	*/
	@Override
	public java.lang.String getFromName() {
		return _spMailTemplate.getFromName();
	}

	/**
	* Sets the from name of this s p mail template.
	*
	* @param fromName the from name of this s p mail template
	*/
	@Override
	public void setFromName(java.lang.String fromName) {
		_spMailTemplate.setFromName(fromName);
	}

	@Override
	public boolean isNew() {
		return _spMailTemplate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spMailTemplate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spMailTemplate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spMailTemplate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spMailTemplate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spMailTemplate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spMailTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spMailTemplate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spMailTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spMailTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spMailTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPMailTemplateWrapper((SPMailTemplate)_spMailTemplate.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPMailTemplate spMailTemplate) {
		return _spMailTemplate.compareTo(spMailTemplate);
	}

	@Override
	public int hashCode() {
		return _spMailTemplate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPMailTemplate> toCacheModel() {
		return _spMailTemplate.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate toEscapedModel() {
		return new SPMailTemplateWrapper(_spMailTemplate.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplate toUnescapedModel() {
		return new SPMailTemplateWrapper(_spMailTemplate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spMailTemplate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spMailTemplate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailTemplate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailTemplateWrapper)) {
			return false;
		}

		SPMailTemplateWrapper spMailTemplateWrapper = (SPMailTemplateWrapper)obj;

		if (Validator.equals(_spMailTemplate,
					spMailTemplateWrapper._spMailTemplate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPMailTemplate getWrappedSPMailTemplate() {
		return _spMailTemplate;
	}

	@Override
	public SPMailTemplate getWrappedModel() {
		return _spMailTemplate;
	}

	@Override
	public void resetOriginalValues() {
		_spMailTemplate.resetOriginalValues();
	}

	private SPMailTemplate _spMailTemplate;
}