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

package com.sambaash.platform.srv.enrolment.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EnrollUploadedTempRecords}.
 * </p>
 *
 * @author Baxture
 * @see EnrollUploadedTempRecords
 * @generated
 */
public class EnrollUploadedTempRecordsWrapper
	implements EnrollUploadedTempRecords,
		ModelWrapper<EnrollUploadedTempRecords> {
	public EnrollUploadedTempRecordsWrapper(
		EnrollUploadedTempRecords enrollUploadedTempRecords) {
		_enrollUploadedTempRecords = enrollUploadedTempRecords;
	}

	@Override
	public Class<?> getModelClass() {
		return EnrollUploadedTempRecords.class;
	}

	@Override
	public String getModelClassName() {
		return EnrollUploadedTempRecords.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uploadedRecId", getUploadedRecId());
		attributes.put("uploadTransactId", getUploadTransactId());
		attributes.put("sprCode", getSprCode());
		attributes.put("title", getTitle());
		attributes.put("fullOfficialName", getFullOfficialName());
		attributes.put("gender", getGender());
		attributes.put("dateofBirth", getDateofBirth());
		attributes.put("email", getEmail());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uploadedRecId = (Long)attributes.get("uploadedRecId");

		if (uploadedRecId != null) {
			setUploadedRecId(uploadedRecId);
		}

		String uploadTransactId = (String)attributes.get("uploadTransactId");

		if (uploadTransactId != null) {
			setUploadTransactId(uploadTransactId);
		}

		String sprCode = (String)attributes.get("sprCode");

		if (sprCode != null) {
			setSprCode(sprCode);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String fullOfficialName = (String)attributes.get("fullOfficialName");

		if (fullOfficialName != null) {
			setFullOfficialName(fullOfficialName);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String dateofBirth = (String)attributes.get("dateofBirth");

		if (dateofBirth != null) {
			setDateofBirth(dateofBirth);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this enroll uploaded temp records.
	*
	* @return the primary key of this enroll uploaded temp records
	*/
	@Override
	public long getPrimaryKey() {
		return _enrollUploadedTempRecords.getPrimaryKey();
	}

	/**
	* Sets the primary key of this enroll uploaded temp records.
	*
	* @param primaryKey the primary key of this enroll uploaded temp records
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_enrollUploadedTempRecords.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uploaded rec ID of this enroll uploaded temp records.
	*
	* @return the uploaded rec ID of this enroll uploaded temp records
	*/
	@Override
	public long getUploadedRecId() {
		return _enrollUploadedTempRecords.getUploadedRecId();
	}

	/**
	* Sets the uploaded rec ID of this enroll uploaded temp records.
	*
	* @param uploadedRecId the uploaded rec ID of this enroll uploaded temp records
	*/
	@Override
	public void setUploadedRecId(long uploadedRecId) {
		_enrollUploadedTempRecords.setUploadedRecId(uploadedRecId);
	}

	/**
	* Returns the upload transact ID of this enroll uploaded temp records.
	*
	* @return the upload transact ID of this enroll uploaded temp records
	*/
	@Override
	public java.lang.String getUploadTransactId() {
		return _enrollUploadedTempRecords.getUploadTransactId();
	}

	/**
	* Sets the upload transact ID of this enroll uploaded temp records.
	*
	* @param uploadTransactId the upload transact ID of this enroll uploaded temp records
	*/
	@Override
	public void setUploadTransactId(java.lang.String uploadTransactId) {
		_enrollUploadedTempRecords.setUploadTransactId(uploadTransactId);
	}

	/**
	* Returns the spr code of this enroll uploaded temp records.
	*
	* @return the spr code of this enroll uploaded temp records
	*/
	@Override
	public java.lang.String getSprCode() {
		return _enrollUploadedTempRecords.getSprCode();
	}

	/**
	* Sets the spr code of this enroll uploaded temp records.
	*
	* @param sprCode the spr code of this enroll uploaded temp records
	*/
	@Override
	public void setSprCode(java.lang.String sprCode) {
		_enrollUploadedTempRecords.setSprCode(sprCode);
	}

	/**
	* Returns the title of this enroll uploaded temp records.
	*
	* @return the title of this enroll uploaded temp records
	*/
	@Override
	public java.lang.String getTitle() {
		return _enrollUploadedTempRecords.getTitle();
	}

	/**
	* Sets the title of this enroll uploaded temp records.
	*
	* @param title the title of this enroll uploaded temp records
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_enrollUploadedTempRecords.setTitle(title);
	}

	/**
	* Returns the full official name of this enroll uploaded temp records.
	*
	* @return the full official name of this enroll uploaded temp records
	*/
	@Override
	public java.lang.String getFullOfficialName() {
		return _enrollUploadedTempRecords.getFullOfficialName();
	}

	/**
	* Sets the full official name of this enroll uploaded temp records.
	*
	* @param fullOfficialName the full official name of this enroll uploaded temp records
	*/
	@Override
	public void setFullOfficialName(java.lang.String fullOfficialName) {
		_enrollUploadedTempRecords.setFullOfficialName(fullOfficialName);
	}

	/**
	* Returns the gender of this enroll uploaded temp records.
	*
	* @return the gender of this enroll uploaded temp records
	*/
	@Override
	public java.lang.String getGender() {
		return _enrollUploadedTempRecords.getGender();
	}

	/**
	* Sets the gender of this enroll uploaded temp records.
	*
	* @param gender the gender of this enroll uploaded temp records
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_enrollUploadedTempRecords.setGender(gender);
	}

	/**
	* Returns the dateof birth of this enroll uploaded temp records.
	*
	* @return the dateof birth of this enroll uploaded temp records
	*/
	@Override
	public java.lang.String getDateofBirth() {
		return _enrollUploadedTempRecords.getDateofBirth();
	}

	/**
	* Sets the dateof birth of this enroll uploaded temp records.
	*
	* @param dateofBirth the dateof birth of this enroll uploaded temp records
	*/
	@Override
	public void setDateofBirth(java.lang.String dateofBirth) {
		_enrollUploadedTempRecords.setDateofBirth(dateofBirth);
	}

	/**
	* Returns the email of this enroll uploaded temp records.
	*
	* @return the email of this enroll uploaded temp records
	*/
	@Override
	public java.lang.String getEmail() {
		return _enrollUploadedTempRecords.getEmail();
	}

	/**
	* Sets the email of this enroll uploaded temp records.
	*
	* @param email the email of this enroll uploaded temp records
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_enrollUploadedTempRecords.setEmail(email);
	}

	/**
	* Returns the user ID of this enroll uploaded temp records.
	*
	* @return the user ID of this enroll uploaded temp records
	*/
	@Override
	public long getUserId() {
		return _enrollUploadedTempRecords.getUserId();
	}

	/**
	* Sets the user ID of this enroll uploaded temp records.
	*
	* @param userId the user ID of this enroll uploaded temp records
	*/
	@Override
	public void setUserId(long userId) {
		_enrollUploadedTempRecords.setUserId(userId);
	}

	/**
	* Returns the user uuid of this enroll uploaded temp records.
	*
	* @return the user uuid of this enroll uploaded temp records
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecords.getUserUuid();
	}

	/**
	* Sets the user uuid of this enroll uploaded temp records.
	*
	* @param userUuid the user uuid of this enroll uploaded temp records
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_enrollUploadedTempRecords.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this enroll uploaded temp records.
	*
	* @return the create date of this enroll uploaded temp records
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _enrollUploadedTempRecords.getCreateDate();
	}

	/**
	* Sets the create date of this enroll uploaded temp records.
	*
	* @param createDate the create date of this enroll uploaded temp records
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_enrollUploadedTempRecords.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this enroll uploaded temp records.
	*
	* @return the modified date of this enroll uploaded temp records
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _enrollUploadedTempRecords.getModifiedDate();
	}

	/**
	* Sets the modified date of this enroll uploaded temp records.
	*
	* @param modifiedDate the modified date of this enroll uploaded temp records
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_enrollUploadedTempRecords.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _enrollUploadedTempRecords.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_enrollUploadedTempRecords.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _enrollUploadedTempRecords.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_enrollUploadedTempRecords.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _enrollUploadedTempRecords.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _enrollUploadedTempRecords.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_enrollUploadedTempRecords.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _enrollUploadedTempRecords.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_enrollUploadedTempRecords.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_enrollUploadedTempRecords.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_enrollUploadedTempRecords.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EnrollUploadedTempRecordsWrapper((EnrollUploadedTempRecords)_enrollUploadedTempRecords.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords enrollUploadedTempRecords) {
		return _enrollUploadedTempRecords.compareTo(enrollUploadedTempRecords);
	}

	@Override
	public int hashCode() {
		return _enrollUploadedTempRecords.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords> toCacheModel() {
		return _enrollUploadedTempRecords.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords toEscapedModel() {
		return new EnrollUploadedTempRecordsWrapper(_enrollUploadedTempRecords.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords toUnescapedModel() {
		return new EnrollUploadedTempRecordsWrapper(_enrollUploadedTempRecords.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _enrollUploadedTempRecords.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _enrollUploadedTempRecords.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_enrollUploadedTempRecords.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EnrollUploadedTempRecordsWrapper)) {
			return false;
		}

		EnrollUploadedTempRecordsWrapper enrollUploadedTempRecordsWrapper = (EnrollUploadedTempRecordsWrapper)obj;

		if (Validator.equals(_enrollUploadedTempRecords,
					enrollUploadedTempRecordsWrapper._enrollUploadedTempRecords)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EnrollUploadedTempRecords getWrappedEnrollUploadedTempRecords() {
		return _enrollUploadedTempRecords;
	}

	@Override
	public EnrollUploadedTempRecords getWrappedModel() {
		return _enrollUploadedTempRecords;
	}

	@Override
	public void resetOriginalValues() {
		_enrollUploadedTempRecords.resetOriginalValues();
	}

	private EnrollUploadedTempRecords _enrollUploadedTempRecords;
}