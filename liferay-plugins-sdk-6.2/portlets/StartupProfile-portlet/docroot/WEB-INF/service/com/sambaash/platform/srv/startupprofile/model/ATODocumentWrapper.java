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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ATODocument}.
 * </p>
 *
 * @author pradeep
 * @see ATODocument
 * @generated
 */
public class ATODocumentWrapper implements ATODocument,
	ModelWrapper<ATODocument> {
	public ATODocumentWrapper(ATODocument atoDocument) {
		_atoDocument = atoDocument;
	}

	@Override
	public Class<?> getModelClass() {
		return ATODocument.class;
	}

	@Override
	public String getModelClassName() {
		return ATODocument.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("atoDocumentId", getAtoDocumentId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("documentType", getDocumentType());
		attributes.put("documentFileId", getDocumentFileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long atoDocumentId = (Long)attributes.get("atoDocumentId");

		if (atoDocumentId != null) {
			setAtoDocumentId(atoDocumentId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String documentType = (String)attributes.get("documentType");

		if (documentType != null) {
			setDocumentType(documentType);
		}

		String documentFileId = (String)attributes.get("documentFileId");

		if (documentFileId != null) {
			setDocumentFileId(documentFileId);
		}
	}

	/**
	* Returns the primary key of this a t o document.
	*
	* @return the primary key of this a t o document
	*/
	@Override
	public long getPrimaryKey() {
		return _atoDocument.getPrimaryKey();
	}

	/**
	* Sets the primary key of this a t o document.
	*
	* @param primaryKey the primary key of this a t o document
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_atoDocument.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this a t o document.
	*
	* @return the uuid of this a t o document
	*/
	@Override
	public java.lang.String getUuid() {
		return _atoDocument.getUuid();
	}

	/**
	* Sets the uuid of this a t o document.
	*
	* @param uuid the uuid of this a t o document
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_atoDocument.setUuid(uuid);
	}

	/**
	* Returns the ato document ID of this a t o document.
	*
	* @return the ato document ID of this a t o document
	*/
	@Override
	public long getAtoDocumentId() {
		return _atoDocument.getAtoDocumentId();
	}

	/**
	* Sets the ato document ID of this a t o document.
	*
	* @param atoDocumentId the ato document ID of this a t o document
	*/
	@Override
	public void setAtoDocumentId(long atoDocumentId) {
		_atoDocument.setAtoDocumentId(atoDocumentId);
	}

	/**
	* Returns the organization ID of this a t o document.
	*
	* @return the organization ID of this a t o document
	*/
	@Override
	public long getOrganizationId() {
		return _atoDocument.getOrganizationId();
	}

	/**
	* Sets the organization ID of this a t o document.
	*
	* @param organizationId the organization ID of this a t o document
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_atoDocument.setOrganizationId(organizationId);
	}

	/**
	* Returns the document type of this a t o document.
	*
	* @return the document type of this a t o document
	*/
	@Override
	public java.lang.String getDocumentType() {
		return _atoDocument.getDocumentType();
	}

	/**
	* Sets the document type of this a t o document.
	*
	* @param documentType the document type of this a t o document
	*/
	@Override
	public void setDocumentType(java.lang.String documentType) {
		_atoDocument.setDocumentType(documentType);
	}

	/**
	* Returns the document file ID of this a t o document.
	*
	* @return the document file ID of this a t o document
	*/
	@Override
	public java.lang.String getDocumentFileId() {
		return _atoDocument.getDocumentFileId();
	}

	/**
	* Sets the document file ID of this a t o document.
	*
	* @param documentFileId the document file ID of this a t o document
	*/
	@Override
	public void setDocumentFileId(java.lang.String documentFileId) {
		_atoDocument.setDocumentFileId(documentFileId);
	}

	@Override
	public boolean isNew() {
		return _atoDocument.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_atoDocument.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _atoDocument.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_atoDocument.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _atoDocument.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _atoDocument.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_atoDocument.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _atoDocument.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_atoDocument.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_atoDocument.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_atoDocument.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ATODocumentWrapper((ATODocument)_atoDocument.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.ATODocument atoDocument) {
		return _atoDocument.compareTo(atoDocument);
	}

	@Override
	public int hashCode() {
		return _atoDocument.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.ATODocument> toCacheModel() {
		return _atoDocument.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ATODocument toEscapedModel() {
		return new ATODocumentWrapper(_atoDocument.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ATODocument toUnescapedModel() {
		return new ATODocumentWrapper(_atoDocument.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _atoDocument.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _atoDocument.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_atoDocument.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ATODocumentWrapper)) {
			return false;
		}

		ATODocumentWrapper atoDocumentWrapper = (ATODocumentWrapper)obj;

		if (Validator.equals(_atoDocument, atoDocumentWrapper._atoDocument)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ATODocument getWrappedATODocument() {
		return _atoDocument;
	}

	@Override
	public ATODocument getWrappedModel() {
		return _atoDocument;
	}

	@Override
	public void resetOriginalValues() {
		_atoDocument.resetOriginalValues();
	}

	private ATODocument _atoDocument;
}