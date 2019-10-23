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

package com.sambaash.platform.srv.extendedprofile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPCertification}.
 * </p>
 *
 * @author harini
 * @see SPCertification
 * @generated
 */
public class SPCertificationWrapper implements SPCertification,
	ModelWrapper<SPCertification> {
	public SPCertificationWrapper(SPCertification spCertification) {
		_spCertification = spCertification;
	}

	@Override
	public Class<?> getModelClass() {
		return SPCertification.class;
	}

	@Override
	public String getModelClassName() {
		return SPCertification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("classPk", getClassPk());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("certificationId", getCertificationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long classPk = (Long)attributes.get("classPk");

		if (classPk != null) {
			setClassPk(classPk);
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

		Long certificationId = (Long)attributes.get("certificationId");

		if (certificationId != null) {
			setCertificationId(certificationId);
		}
	}

	/**
	* Returns the primary key of this s p certification.
	*
	* @return the primary key of this s p certification
	*/
	@Override
	public long getPrimaryKey() {
		return _spCertification.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p certification.
	*
	* @param primaryKey the primary key of this s p certification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spCertification.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the class pk of this s p certification.
	*
	* @return the class pk of this s p certification
	*/
	@Override
	public long getClassPk() {
		return _spCertification.getClassPk();
	}

	/**
	* Sets the class pk of this s p certification.
	*
	* @param classPk the class pk of this s p certification
	*/
	@Override
	public void setClassPk(long classPk) {
		_spCertification.setClassPk(classPk);
	}

	/**
	* Returns the group ID of this s p certification.
	*
	* @return the group ID of this s p certification
	*/
	@Override
	public long getGroupId() {
		return _spCertification.getGroupId();
	}

	/**
	* Sets the group ID of this s p certification.
	*
	* @param groupId the group ID of this s p certification
	*/
	@Override
	public void setGroupId(long groupId) {
		_spCertification.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p certification.
	*
	* @return the company ID of this s p certification
	*/
	@Override
	public long getCompanyId() {
		return _spCertification.getCompanyId();
	}

	/**
	* Sets the company ID of this s p certification.
	*
	* @param companyId the company ID of this s p certification
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spCertification.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p certification.
	*
	* @return the user ID of this s p certification
	*/
	@Override
	public long getUserId() {
		return _spCertification.getUserId();
	}

	/**
	* Sets the user ID of this s p certification.
	*
	* @param userId the user ID of this s p certification
	*/
	@Override
	public void setUserId(long userId) {
		_spCertification.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p certification.
	*
	* @return the user uuid of this s p certification
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCertification.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p certification.
	*
	* @param userUuid the user uuid of this s p certification
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spCertification.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p certification.
	*
	* @return the user name of this s p certification
	*/
	@Override
	public java.lang.String getUserName() {
		return _spCertification.getUserName();
	}

	/**
	* Sets the user name of this s p certification.
	*
	* @param userName the user name of this s p certification
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spCertification.setUserName(userName);
	}

	/**
	* Returns the create date of this s p certification.
	*
	* @return the create date of this s p certification
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spCertification.getCreateDate();
	}

	/**
	* Sets the create date of this s p certification.
	*
	* @param createDate the create date of this s p certification
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spCertification.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p certification.
	*
	* @return the modified date of this s p certification
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spCertification.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p certification.
	*
	* @param modifiedDate the modified date of this s p certification
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spCertification.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the certification ID of this s p certification.
	*
	* @return the certification ID of this s p certification
	*/
	@Override
	public long getCertificationId() {
		return _spCertification.getCertificationId();
	}

	/**
	* Sets the certification ID of this s p certification.
	*
	* @param certificationId the certification ID of this s p certification
	*/
	@Override
	public void setCertificationId(long certificationId) {
		_spCertification.setCertificationId(certificationId);
	}

	@Override
	public boolean isNew() {
		return _spCertification.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spCertification.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spCertification.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spCertification.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spCertification.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spCertification.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spCertification.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spCertification.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spCertification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spCertification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spCertification.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPCertificationWrapper((SPCertification)_spCertification.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.extendedprofile.model.SPCertification spCertification) {
		return _spCertification.compareTo(spCertification);
	}

	@Override
	public int hashCode() {
		return _spCertification.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.extendedprofile.model.SPCertification> toCacheModel() {
		return _spCertification.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification toEscapedModel() {
		return new SPCertificationWrapper(_spCertification.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCertification toUnescapedModel() {
		return new SPCertificationWrapper(_spCertification.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spCertification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spCertification.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spCertification.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPCertificationWrapper)) {
			return false;
		}

		SPCertificationWrapper spCertificationWrapper = (SPCertificationWrapper)obj;

		if (Validator.equals(_spCertification,
					spCertificationWrapper._spCertification)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPCertification getWrappedSPCertification() {
		return _spCertification;
	}

	@Override
	public SPCertification getWrappedModel() {
		return _spCertification;
	}

	@Override
	public void resetOriginalValues() {
		_spCertification.resetOriginalValues();
	}

	private SPCertification _spCertification;
}