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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Certificate}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Certificate
 * @generated
 */
public class CertificateWrapper implements Certificate,
	ModelWrapper<Certificate> {
	public CertificateWrapper(Certificate certificate) {
		_certificate = certificate;
	}

	@Override
	public Class<?> getModelClass() {
		return Certificate.class;
	}

	@Override
	public String getModelClassName() {
		return Certificate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCertificatetId", getSpCertificatetId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("certificateCode", getCertificateCode());
		attributes.put("certificateType", getCertificateType());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("level", getLevel());
		attributes.put("attachmentFolderId", getAttachmentFolderId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCertificatetId = (Long)attributes.get("spCertificatetId");

		if (spCertificatetId != null) {
			setSpCertificatetId(spCertificatetId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String certificateCode = (String)attributes.get("certificateCode");

		if (certificateCode != null) {
			setCertificateCode(certificateCode);
		}

		Long certificateType = (Long)attributes.get("certificateType");

		if (certificateType != null) {
			setCertificateType(certificateType);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long level = (Long)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long attachmentFolderId = (Long)attributes.get("attachmentFolderId");

		if (attachmentFolderId != null) {
			setAttachmentFolderId(attachmentFolderId);
		}
	}

	/**
	* Returns the primary key of this certificate.
	*
	* @return the primary key of this certificate
	*/
	@Override
	public long getPrimaryKey() {
		return _certificate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this certificate.
	*
	* @param primaryKey the primary key of this certificate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_certificate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp certificatet ID of this certificate.
	*
	* @return the sp certificatet ID of this certificate
	*/
	@Override
	public long getSpCertificatetId() {
		return _certificate.getSpCertificatetId();
	}

	/**
	* Sets the sp certificatet ID of this certificate.
	*
	* @param spCertificatetId the sp certificatet ID of this certificate
	*/
	@Override
	public void setSpCertificatetId(long spCertificatetId) {
		_certificate.setSpCertificatetId(spCertificatetId);
	}

	/**
	* Returns the group ID of this certificate.
	*
	* @return the group ID of this certificate
	*/
	@Override
	public long getGroupId() {
		return _certificate.getGroupId();
	}

	/**
	* Sets the group ID of this certificate.
	*
	* @param groupId the group ID of this certificate
	*/
	@Override
	public void setGroupId(long groupId) {
		_certificate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this certificate.
	*
	* @return the company ID of this certificate
	*/
	@Override
	public long getCompanyId() {
		return _certificate.getCompanyId();
	}

	/**
	* Sets the company ID of this certificate.
	*
	* @param companyId the company ID of this certificate
	*/
	@Override
	public void setCompanyId(long companyId) {
		_certificate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this certificate.
	*
	* @return the user ID of this certificate
	*/
	@Override
	public long getUserId() {
		return _certificate.getUserId();
	}

	/**
	* Sets the user ID of this certificate.
	*
	* @param userId the user ID of this certificate
	*/
	@Override
	public void setUserId(long userId) {
		_certificate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this certificate.
	*
	* @return the user uuid of this certificate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificate.getUserUuid();
	}

	/**
	* Sets the user uuid of this certificate.
	*
	* @param userUuid the user uuid of this certificate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_certificate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this certificate.
	*
	* @return the user name of this certificate
	*/
	@Override
	public java.lang.String getUserName() {
		return _certificate.getUserName();
	}

	/**
	* Sets the user name of this certificate.
	*
	* @param userName the user name of this certificate
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_certificate.setUserName(userName);
	}

	/**
	* Returns the create date of this certificate.
	*
	* @return the create date of this certificate
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _certificate.getCreateDate();
	}

	/**
	* Sets the create date of this certificate.
	*
	* @param createDate the create date of this certificate
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_certificate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this certificate.
	*
	* @return the modified date of this certificate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _certificate.getModifiedDate();
	}

	/**
	* Sets the modified date of this certificate.
	*
	* @param modifiedDate the modified date of this certificate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_certificate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country ID of this certificate.
	*
	* @return the country ID of this certificate
	*/
	@Override
	public long getCountryId() {
		return _certificate.getCountryId();
	}

	/**
	* Sets the country ID of this certificate.
	*
	* @param countryId the country ID of this certificate
	*/
	@Override
	public void setCountryId(long countryId) {
		_certificate.setCountryId(countryId);
	}

	/**
	* Returns the certificate code of this certificate.
	*
	* @return the certificate code of this certificate
	*/
	@Override
	public java.lang.String getCertificateCode() {
		return _certificate.getCertificateCode();
	}

	/**
	* Sets the certificate code of this certificate.
	*
	* @param certificateCode the certificate code of this certificate
	*/
	@Override
	public void setCertificateCode(java.lang.String certificateCode) {
		_certificate.setCertificateCode(certificateCode);
	}

	/**
	* Returns the certificate type of this certificate.
	*
	* @return the certificate type of this certificate
	*/
	@Override
	public long getCertificateType() {
		return _certificate.getCertificateType();
	}

	/**
	* Sets the certificate type of this certificate.
	*
	* @param certificateType the certificate type of this certificate
	*/
	@Override
	public void setCertificateType(long certificateType) {
		_certificate.setCertificateType(certificateType);
	}

	/**
	* Returns the title of this certificate.
	*
	* @return the title of this certificate
	*/
	@Override
	public java.lang.String getTitle() {
		return _certificate.getTitle();
	}

	/**
	* Sets the title of this certificate.
	*
	* @param title the title of this certificate
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_certificate.setTitle(title);
	}

	/**
	* Returns the description of this certificate.
	*
	* @return the description of this certificate
	*/
	@Override
	public java.lang.String getDescription() {
		return _certificate.getDescription();
	}

	/**
	* Sets the description of this certificate.
	*
	* @param description the description of this certificate
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_certificate.setDescription(description);
	}

	/**
	* Returns the level of this certificate.
	*
	* @return the level of this certificate
	*/
	@Override
	public long getLevel() {
		return _certificate.getLevel();
	}

	/**
	* Sets the level of this certificate.
	*
	* @param level the level of this certificate
	*/
	@Override
	public void setLevel(long level) {
		_certificate.setLevel(level);
	}

	/**
	* Returns the attachment folder ID of this certificate.
	*
	* @return the attachment folder ID of this certificate
	*/
	@Override
	public long getAttachmentFolderId() {
		return _certificate.getAttachmentFolderId();
	}

	/**
	* Sets the attachment folder ID of this certificate.
	*
	* @param attachmentFolderId the attachment folder ID of this certificate
	*/
	@Override
	public void setAttachmentFolderId(long attachmentFolderId) {
		_certificate.setAttachmentFolderId(attachmentFolderId);
	}

	@Override
	public boolean isNew() {
		return _certificate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_certificate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _certificate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_certificate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _certificate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _certificate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_certificate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _certificate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_certificate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_certificate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_certificate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CertificateWrapper((Certificate)_certificate.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.Certificate certificate) {
		return _certificate.compareTo(certificate);
	}

	@Override
	public int hashCode() {
		return _certificate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Certificate> toCacheModel() {
		return _certificate.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Certificate toEscapedModel() {
		return new CertificateWrapper(_certificate.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Certificate toUnescapedModel() {
		return new CertificateWrapper(_certificate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _certificate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _certificate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_certificate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CertificateWrapper)) {
			return false;
		}

		CertificateWrapper certificateWrapper = (CertificateWrapper)obj;

		if (Validator.equals(_certificate, certificateWrapper._certificate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Certificate getWrappedCertificate() {
		return _certificate;
	}

	@Override
	public Certificate getWrappedModel() {
		return _certificate;
	}

	@Override
	public void resetOriginalValues() {
		_certificate.resetOriginalValues();
	}

	private Certificate _certificate;
}