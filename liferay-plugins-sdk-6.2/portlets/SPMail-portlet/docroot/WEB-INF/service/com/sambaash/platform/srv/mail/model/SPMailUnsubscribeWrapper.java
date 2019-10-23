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
 * This class is a wrapper for {@link SPMailUnsubscribe}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailUnsubscribe
 * @generated
 */
public class SPMailUnsubscribeWrapper implements SPMailUnsubscribe,
	ModelWrapper<SPMailUnsubscribe> {
	public SPMailUnsubscribeWrapper(SPMailUnsubscribe spMailUnsubscribe) {
		_spMailUnsubscribe = spMailUnsubscribe;
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailUnsubscribe.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailUnsubscribe.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailUnsubscribeId", getSpMailUnsubscribeId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("userId", getUserId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("unsubscribeDate", getUnsubscribeDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailUnsubscribeId = (Long)attributes.get("spMailUnsubscribeId");

		if (spMailUnsubscribeId != null) {
			setSpMailUnsubscribeId(spMailUnsubscribeId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Date unsubscribeDate = (Date)attributes.get("unsubscribeDate");

		if (unsubscribeDate != null) {
			setUnsubscribeDate(unsubscribeDate);
		}
	}

	/**
	* Returns the primary key of this s p mail unsubscribe.
	*
	* @return the primary key of this s p mail unsubscribe
	*/
	@Override
	public long getPrimaryKey() {
		return _spMailUnsubscribe.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p mail unsubscribe.
	*
	* @param primaryKey the primary key of this s p mail unsubscribe
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spMailUnsubscribe.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp mail unsubscribe ID of this s p mail unsubscribe.
	*
	* @return the sp mail unsubscribe ID of this s p mail unsubscribe
	*/
	@Override
	public long getSpMailUnsubscribeId() {
		return _spMailUnsubscribe.getSpMailUnsubscribeId();
	}

	/**
	* Sets the sp mail unsubscribe ID of this s p mail unsubscribe.
	*
	* @param spMailUnsubscribeId the sp mail unsubscribe ID of this s p mail unsubscribe
	*/
	@Override
	public void setSpMailUnsubscribeId(long spMailUnsubscribeId) {
		_spMailUnsubscribe.setSpMailUnsubscribeId(spMailUnsubscribeId);
	}

	/**
	* Returns the category ID of this s p mail unsubscribe.
	*
	* @return the category ID of this s p mail unsubscribe
	*/
	@Override
	public long getCategoryId() {
		return _spMailUnsubscribe.getCategoryId();
	}

	/**
	* Sets the category ID of this s p mail unsubscribe.
	*
	* @param categoryId the category ID of this s p mail unsubscribe
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_spMailUnsubscribe.setCategoryId(categoryId);
	}

	/**
	* Returns the user ID of this s p mail unsubscribe.
	*
	* @return the user ID of this s p mail unsubscribe
	*/
	@Override
	public long getUserId() {
		return _spMailUnsubscribe.getUserId();
	}

	/**
	* Sets the user ID of this s p mail unsubscribe.
	*
	* @param userId the user ID of this s p mail unsubscribe
	*/
	@Override
	public void setUserId(long userId) {
		_spMailUnsubscribe.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p mail unsubscribe.
	*
	* @return the user uuid of this s p mail unsubscribe
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailUnsubscribe.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p mail unsubscribe.
	*
	* @param userUuid the user uuid of this s p mail unsubscribe
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spMailUnsubscribe.setUserUuid(userUuid);
	}

	/**
	* Returns the email address of this s p mail unsubscribe.
	*
	* @return the email address of this s p mail unsubscribe
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spMailUnsubscribe.getEmailAddress();
	}

	/**
	* Sets the email address of this s p mail unsubscribe.
	*
	* @param emailAddress the email address of this s p mail unsubscribe
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spMailUnsubscribe.setEmailAddress(emailAddress);
	}

	/**
	* Returns the unsubscribe date of this s p mail unsubscribe.
	*
	* @return the unsubscribe date of this s p mail unsubscribe
	*/
	@Override
	public java.util.Date getUnsubscribeDate() {
		return _spMailUnsubscribe.getUnsubscribeDate();
	}

	/**
	* Sets the unsubscribe date of this s p mail unsubscribe.
	*
	* @param unsubscribeDate the unsubscribe date of this s p mail unsubscribe
	*/
	@Override
	public void setUnsubscribeDate(java.util.Date unsubscribeDate) {
		_spMailUnsubscribe.setUnsubscribeDate(unsubscribeDate);
	}

	@Override
	public boolean isNew() {
		return _spMailUnsubscribe.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spMailUnsubscribe.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spMailUnsubscribe.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spMailUnsubscribe.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spMailUnsubscribe.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spMailUnsubscribe.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spMailUnsubscribe.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spMailUnsubscribe.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spMailUnsubscribe.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spMailUnsubscribe.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spMailUnsubscribe.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPMailUnsubscribeWrapper((SPMailUnsubscribe)_spMailUnsubscribe.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe) {
		return _spMailUnsubscribe.compareTo(spMailUnsubscribe);
	}

	@Override
	public int hashCode() {
		return _spMailUnsubscribe.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPMailUnsubscribe> toCacheModel() {
		return _spMailUnsubscribe.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe toEscapedModel() {
		return new SPMailUnsubscribeWrapper(_spMailUnsubscribe.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailUnsubscribe toUnescapedModel() {
		return new SPMailUnsubscribeWrapper(_spMailUnsubscribe.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spMailUnsubscribe.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spMailUnsubscribe.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailUnsubscribe.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailUnsubscribeWrapper)) {
			return false;
		}

		SPMailUnsubscribeWrapper spMailUnsubscribeWrapper = (SPMailUnsubscribeWrapper)obj;

		if (Validator.equals(_spMailUnsubscribe,
					spMailUnsubscribeWrapper._spMailUnsubscribe)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPMailUnsubscribe getWrappedSPMailUnsubscribe() {
		return _spMailUnsubscribe;
	}

	@Override
	public SPMailUnsubscribe getWrappedModel() {
		return _spMailUnsubscribe;
	}

	@Override
	public void resetOriginalValues() {
		_spMailUnsubscribe.resetOriginalValues();
	}

	private SPMailUnsubscribe _spMailUnsubscribe;
}