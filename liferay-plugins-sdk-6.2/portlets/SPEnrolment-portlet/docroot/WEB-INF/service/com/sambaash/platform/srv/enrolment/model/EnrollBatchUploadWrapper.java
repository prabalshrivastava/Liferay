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
 * This class is a wrapper for {@link EnrollBatchUpload}.
 * </p>
 *
 * @author Baxture
 * @see EnrollBatchUpload
 * @generated
 */
public class EnrollBatchUploadWrapper implements EnrollBatchUpload,
	ModelWrapper<EnrollBatchUpload> {
	public EnrollBatchUploadWrapper(EnrollBatchUpload enrollBatchUpload) {
		_enrollBatchUpload = enrollBatchUpload;
	}

	@Override
	public Class<?> getModelClass() {
		return EnrollBatchUpload.class;
	}

	@Override
	public String getModelClassName() {
		return EnrollBatchUpload.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uploadStatId", getUploadStatId());
		attributes.put("uploadTransactId", getUploadTransactId());
		attributes.put("errorField", getErrorField());
		attributes.put("errorReason", getErrorReason());
		attributes.put("uploadedRecId", getUploadedRecId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uploadStatId = (Long)attributes.get("uploadStatId");

		if (uploadStatId != null) {
			setUploadStatId(uploadStatId);
		}

		String uploadTransactId = (String)attributes.get("uploadTransactId");

		if (uploadTransactId != null) {
			setUploadTransactId(uploadTransactId);
		}

		String errorField = (String)attributes.get("errorField");

		if (errorField != null) {
			setErrorField(errorField);
		}

		String errorReason = (String)attributes.get("errorReason");

		if (errorReason != null) {
			setErrorReason(errorReason);
		}

		Long uploadedRecId = (Long)attributes.get("uploadedRecId");

		if (uploadedRecId != null) {
			setUploadedRecId(uploadedRecId);
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
	* Returns the primary key of this enroll batch upload.
	*
	* @return the primary key of this enroll batch upload
	*/
	@Override
	public long getPrimaryKey() {
		return _enrollBatchUpload.getPrimaryKey();
	}

	/**
	* Sets the primary key of this enroll batch upload.
	*
	* @param primaryKey the primary key of this enroll batch upload
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_enrollBatchUpload.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the upload stat ID of this enroll batch upload.
	*
	* @return the upload stat ID of this enroll batch upload
	*/
	@Override
	public long getUploadStatId() {
		return _enrollBatchUpload.getUploadStatId();
	}

	/**
	* Sets the upload stat ID of this enroll batch upload.
	*
	* @param uploadStatId the upload stat ID of this enroll batch upload
	*/
	@Override
	public void setUploadStatId(long uploadStatId) {
		_enrollBatchUpload.setUploadStatId(uploadStatId);
	}

	/**
	* Returns the upload transact ID of this enroll batch upload.
	*
	* @return the upload transact ID of this enroll batch upload
	*/
	@Override
	public java.lang.String getUploadTransactId() {
		return _enrollBatchUpload.getUploadTransactId();
	}

	/**
	* Sets the upload transact ID of this enroll batch upload.
	*
	* @param uploadTransactId the upload transact ID of this enroll batch upload
	*/
	@Override
	public void setUploadTransactId(java.lang.String uploadTransactId) {
		_enrollBatchUpload.setUploadTransactId(uploadTransactId);
	}

	/**
	* Returns the error field of this enroll batch upload.
	*
	* @return the error field of this enroll batch upload
	*/
	@Override
	public java.lang.String getErrorField() {
		return _enrollBatchUpload.getErrorField();
	}

	/**
	* Sets the error field of this enroll batch upload.
	*
	* @param errorField the error field of this enroll batch upload
	*/
	@Override
	public void setErrorField(java.lang.String errorField) {
		_enrollBatchUpload.setErrorField(errorField);
	}

	/**
	* Returns the error reason of this enroll batch upload.
	*
	* @return the error reason of this enroll batch upload
	*/
	@Override
	public java.lang.String getErrorReason() {
		return _enrollBatchUpload.getErrorReason();
	}

	/**
	* Sets the error reason of this enroll batch upload.
	*
	* @param errorReason the error reason of this enroll batch upload
	*/
	@Override
	public void setErrorReason(java.lang.String errorReason) {
		_enrollBatchUpload.setErrorReason(errorReason);
	}

	/**
	* Returns the uploaded rec ID of this enroll batch upload.
	*
	* @return the uploaded rec ID of this enroll batch upload
	*/
	@Override
	public long getUploadedRecId() {
		return _enrollBatchUpload.getUploadedRecId();
	}

	/**
	* Sets the uploaded rec ID of this enroll batch upload.
	*
	* @param uploadedRecId the uploaded rec ID of this enroll batch upload
	*/
	@Override
	public void setUploadedRecId(long uploadedRecId) {
		_enrollBatchUpload.setUploadedRecId(uploadedRecId);
	}

	/**
	* Returns the user ID of this enroll batch upload.
	*
	* @return the user ID of this enroll batch upload
	*/
	@Override
	public long getUserId() {
		return _enrollBatchUpload.getUserId();
	}

	/**
	* Sets the user ID of this enroll batch upload.
	*
	* @param userId the user ID of this enroll batch upload
	*/
	@Override
	public void setUserId(long userId) {
		_enrollBatchUpload.setUserId(userId);
	}

	/**
	* Returns the user uuid of this enroll batch upload.
	*
	* @return the user uuid of this enroll batch upload
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollBatchUpload.getUserUuid();
	}

	/**
	* Sets the user uuid of this enroll batch upload.
	*
	* @param userUuid the user uuid of this enroll batch upload
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_enrollBatchUpload.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this enroll batch upload.
	*
	* @return the create date of this enroll batch upload
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _enrollBatchUpload.getCreateDate();
	}

	/**
	* Sets the create date of this enroll batch upload.
	*
	* @param createDate the create date of this enroll batch upload
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_enrollBatchUpload.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this enroll batch upload.
	*
	* @return the modified date of this enroll batch upload
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _enrollBatchUpload.getModifiedDate();
	}

	/**
	* Sets the modified date of this enroll batch upload.
	*
	* @param modifiedDate the modified date of this enroll batch upload
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_enrollBatchUpload.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _enrollBatchUpload.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_enrollBatchUpload.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _enrollBatchUpload.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_enrollBatchUpload.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _enrollBatchUpload.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _enrollBatchUpload.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_enrollBatchUpload.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _enrollBatchUpload.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_enrollBatchUpload.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_enrollBatchUpload.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_enrollBatchUpload.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EnrollBatchUploadWrapper((EnrollBatchUpload)_enrollBatchUpload.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload enrollBatchUpload) {
		return _enrollBatchUpload.compareTo(enrollBatchUpload);
	}

	@Override
	public int hashCode() {
		return _enrollBatchUpload.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload> toCacheModel() {
		return _enrollBatchUpload.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload toEscapedModel() {
		return new EnrollBatchUploadWrapper(_enrollBatchUpload.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload toUnescapedModel() {
		return new EnrollBatchUploadWrapper(_enrollBatchUpload.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _enrollBatchUpload.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _enrollBatchUpload.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_enrollBatchUpload.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EnrollBatchUploadWrapper)) {
			return false;
		}

		EnrollBatchUploadWrapper enrollBatchUploadWrapper = (EnrollBatchUploadWrapper)obj;

		if (Validator.equals(_enrollBatchUpload,
					enrollBatchUploadWrapper._enrollBatchUpload)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EnrollBatchUpload getWrappedEnrollBatchUpload() {
		return _enrollBatchUpload;
	}

	@Override
	public EnrollBatchUpload getWrappedModel() {
		return _enrollBatchUpload;
	}

	@Override
	public void resetOriginalValues() {
		_enrollBatchUpload.resetOriginalValues();
	}

	private EnrollBatchUpload _enrollBatchUpload;
}