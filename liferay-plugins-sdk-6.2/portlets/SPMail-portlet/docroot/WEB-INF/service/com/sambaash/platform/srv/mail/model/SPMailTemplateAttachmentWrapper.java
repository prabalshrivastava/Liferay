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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPMailTemplateAttachment}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailTemplateAttachment
 * @generated
 */
public class SPMailTemplateAttachmentWrapper implements SPMailTemplateAttachment,
	ModelWrapper<SPMailTemplateAttachment> {
	public SPMailTemplateAttachmentWrapper(
		SPMailTemplateAttachment spMailTemplateAttachment) {
		_spMailTemplateAttachment = spMailTemplateAttachment;
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailTemplateAttachment.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailTemplateAttachment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spTemplateAttachmentId", getSpTemplateAttachmentId());
		attributes.put("templateId", getTemplateId());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spTemplateAttachmentId = (Long)attributes.get(
				"spTemplateAttachmentId");

		if (spTemplateAttachmentId != null) {
			setSpTemplateAttachmentId(spTemplateAttachmentId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	/**
	* Returns the primary key of this s p mail template attachment.
	*
	* @return the primary key of this s p mail template attachment
	*/
	@Override
	public long getPrimaryKey() {
		return _spMailTemplateAttachment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p mail template attachment.
	*
	* @param primaryKey the primary key of this s p mail template attachment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spMailTemplateAttachment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp template attachment ID of this s p mail template attachment.
	*
	* @return the sp template attachment ID of this s p mail template attachment
	*/
	@Override
	public long getSpTemplateAttachmentId() {
		return _spMailTemplateAttachment.getSpTemplateAttachmentId();
	}

	/**
	* Sets the sp template attachment ID of this s p mail template attachment.
	*
	* @param spTemplateAttachmentId the sp template attachment ID of this s p mail template attachment
	*/
	@Override
	public void setSpTemplateAttachmentId(long spTemplateAttachmentId) {
		_spMailTemplateAttachment.setSpTemplateAttachmentId(spTemplateAttachmentId);
	}

	/**
	* Returns the template ID of this s p mail template attachment.
	*
	* @return the template ID of this s p mail template attachment
	*/
	@Override
	public long getTemplateId() {
		return _spMailTemplateAttachment.getTemplateId();
	}

	/**
	* Sets the template ID of this s p mail template attachment.
	*
	* @param templateId the template ID of this s p mail template attachment
	*/
	@Override
	public void setTemplateId(long templateId) {
		_spMailTemplateAttachment.setTemplateId(templateId);
	}

	/**
	* Returns the rsvp ID of this s p mail template attachment.
	*
	* @return the rsvp ID of this s p mail template attachment
	*/
	@Override
	public long getRsvpId() {
		return _spMailTemplateAttachment.getRsvpId();
	}

	/**
	* Sets the rsvp ID of this s p mail template attachment.
	*
	* @param rsvpId the rsvp ID of this s p mail template attachment
	*/
	@Override
	public void setRsvpId(long rsvpId) {
		_spMailTemplateAttachment.setRsvpId(rsvpId);
	}

	/**
	* Returns the file entry ID of this s p mail template attachment.
	*
	* @return the file entry ID of this s p mail template attachment
	*/
	@Override
	public long getFileEntryId() {
		return _spMailTemplateAttachment.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this s p mail template attachment.
	*
	* @param fileEntryId the file entry ID of this s p mail template attachment
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_spMailTemplateAttachment.setFileEntryId(fileEntryId);
	}

	@Override
	public boolean isNew() {
		return _spMailTemplateAttachment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spMailTemplateAttachment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spMailTemplateAttachment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spMailTemplateAttachment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spMailTemplateAttachment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spMailTemplateAttachment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spMailTemplateAttachment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spMailTemplateAttachment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spMailTemplateAttachment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spMailTemplateAttachment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spMailTemplateAttachment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPMailTemplateAttachmentWrapper((SPMailTemplateAttachment)_spMailTemplateAttachment.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment spMailTemplateAttachment) {
		return _spMailTemplateAttachment.compareTo(spMailTemplateAttachment);
	}

	@Override
	public int hashCode() {
		return _spMailTemplateAttachment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment> toCacheModel() {
		return _spMailTemplateAttachment.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment toEscapedModel() {
		return new SPMailTemplateAttachmentWrapper(_spMailTemplateAttachment.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment toUnescapedModel() {
		return new SPMailTemplateAttachmentWrapper(_spMailTemplateAttachment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spMailTemplateAttachment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spMailTemplateAttachment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailTemplateAttachment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailTemplateAttachmentWrapper)) {
			return false;
		}

		SPMailTemplateAttachmentWrapper spMailTemplateAttachmentWrapper = (SPMailTemplateAttachmentWrapper)obj;

		if (Validator.equals(_spMailTemplateAttachment,
					spMailTemplateAttachmentWrapper._spMailTemplateAttachment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPMailTemplateAttachment getWrappedSPMailTemplateAttachment() {
		return _spMailTemplateAttachment;
	}

	@Override
	public SPMailTemplateAttachment getWrappedModel() {
		return _spMailTemplateAttachment;
	}

	@Override
	public void resetOriginalValues() {
		_spMailTemplateAttachment.resetOriginalValues();
	}

	private SPMailTemplateAttachment _spMailTemplateAttachment;
}