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
 * This class is a wrapper for {@link ModuleCertificate}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleCertificate
 * @generated
 */
public class ModuleCertificateWrapper implements ModuleCertificate,
	ModelWrapper<ModuleCertificate> {
	public ModuleCertificateWrapper(ModuleCertificate moduleCertificate) {
		_moduleCertificate = moduleCertificate;
	}

	@Override
	public Class<?> getModelClass() {
		return ModuleCertificate.class;
	}

	@Override
	public String getModelClassName() {
		return ModuleCertificate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spModuleCertificateId", getSpModuleCertificateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("spCertificatetId", getSpCertificatetId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spModuleCertificateId = (Long)attributes.get(
				"spModuleCertificateId");

		if (spModuleCertificateId != null) {
			setSpModuleCertificateId(spModuleCertificateId);
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

		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
		}

		Long spCertificatetId = (Long)attributes.get("spCertificatetId");

		if (spCertificatetId != null) {
			setSpCertificatetId(spCertificatetId);
		}
	}

	/**
	* Returns the primary key of this module certificate.
	*
	* @return the primary key of this module certificate
	*/
	@Override
	public long getPrimaryKey() {
		return _moduleCertificate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this module certificate.
	*
	* @param primaryKey the primary key of this module certificate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_moduleCertificate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp module certificate ID of this module certificate.
	*
	* @return the sp module certificate ID of this module certificate
	*/
	@Override
	public long getSpModuleCertificateId() {
		return _moduleCertificate.getSpModuleCertificateId();
	}

	/**
	* Sets the sp module certificate ID of this module certificate.
	*
	* @param spModuleCertificateId the sp module certificate ID of this module certificate
	*/
	@Override
	public void setSpModuleCertificateId(long spModuleCertificateId) {
		_moduleCertificate.setSpModuleCertificateId(spModuleCertificateId);
	}

	/**
	* Returns the group ID of this module certificate.
	*
	* @return the group ID of this module certificate
	*/
	@Override
	public long getGroupId() {
		return _moduleCertificate.getGroupId();
	}

	/**
	* Sets the group ID of this module certificate.
	*
	* @param groupId the group ID of this module certificate
	*/
	@Override
	public void setGroupId(long groupId) {
		_moduleCertificate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this module certificate.
	*
	* @return the company ID of this module certificate
	*/
	@Override
	public long getCompanyId() {
		return _moduleCertificate.getCompanyId();
	}

	/**
	* Sets the company ID of this module certificate.
	*
	* @param companyId the company ID of this module certificate
	*/
	@Override
	public void setCompanyId(long companyId) {
		_moduleCertificate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this module certificate.
	*
	* @return the user ID of this module certificate
	*/
	@Override
	public long getUserId() {
		return _moduleCertificate.getUserId();
	}

	/**
	* Sets the user ID of this module certificate.
	*
	* @param userId the user ID of this module certificate
	*/
	@Override
	public void setUserId(long userId) {
		_moduleCertificate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this module certificate.
	*
	* @return the user uuid of this module certificate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCertificate.getUserUuid();
	}

	/**
	* Sets the user uuid of this module certificate.
	*
	* @param userUuid the user uuid of this module certificate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_moduleCertificate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this module certificate.
	*
	* @return the user name of this module certificate
	*/
	@Override
	public java.lang.String getUserName() {
		return _moduleCertificate.getUserName();
	}

	/**
	* Sets the user name of this module certificate.
	*
	* @param userName the user name of this module certificate
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_moduleCertificate.setUserName(userName);
	}

	/**
	* Returns the create date of this module certificate.
	*
	* @return the create date of this module certificate
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _moduleCertificate.getCreateDate();
	}

	/**
	* Sets the create date of this module certificate.
	*
	* @param createDate the create date of this module certificate
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_moduleCertificate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this module certificate.
	*
	* @return the modified date of this module certificate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _moduleCertificate.getModifiedDate();
	}

	/**
	* Sets the modified date of this module certificate.
	*
	* @param modifiedDate the modified date of this module certificate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_moduleCertificate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp module ID of this module certificate.
	*
	* @return the sp module ID of this module certificate
	*/
	@Override
	public long getSpModuleId() {
		return _moduleCertificate.getSpModuleId();
	}

	/**
	* Sets the sp module ID of this module certificate.
	*
	* @param spModuleId the sp module ID of this module certificate
	*/
	@Override
	public void setSpModuleId(long spModuleId) {
		_moduleCertificate.setSpModuleId(spModuleId);
	}

	/**
	* Returns the sp certificatet ID of this module certificate.
	*
	* @return the sp certificatet ID of this module certificate
	*/
	@Override
	public long getSpCertificatetId() {
		return _moduleCertificate.getSpCertificatetId();
	}

	/**
	* Sets the sp certificatet ID of this module certificate.
	*
	* @param spCertificatetId the sp certificatet ID of this module certificate
	*/
	@Override
	public void setSpCertificatetId(long spCertificatetId) {
		_moduleCertificate.setSpCertificatetId(spCertificatetId);
	}

	@Override
	public boolean isNew() {
		return _moduleCertificate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_moduleCertificate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _moduleCertificate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_moduleCertificate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _moduleCertificate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _moduleCertificate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_moduleCertificate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _moduleCertificate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_moduleCertificate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_moduleCertificate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_moduleCertificate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ModuleCertificateWrapper((ModuleCertificate)_moduleCertificate.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.ModuleCertificate moduleCertificate) {
		return _moduleCertificate.compareTo(moduleCertificate);
	}

	@Override
	public int hashCode() {
		return _moduleCertificate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.ModuleCertificate> toCacheModel() {
		return _moduleCertificate.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.ModuleCertificate toEscapedModel() {
		return new ModuleCertificateWrapper(_moduleCertificate.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.ModuleCertificate toUnescapedModel() {
		return new ModuleCertificateWrapper(_moduleCertificate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _moduleCertificate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _moduleCertificate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_moduleCertificate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ModuleCertificateWrapper)) {
			return false;
		}

		ModuleCertificateWrapper moduleCertificateWrapper = (ModuleCertificateWrapper)obj;

		if (Validator.equals(_moduleCertificate,
					moduleCertificateWrapper._moduleCertificate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ModuleCertificate getWrappedModuleCertificate() {
		return _moduleCertificate;
	}

	@Override
	public ModuleCertificate getWrappedModel() {
		return _moduleCertificate;
	}

	@Override
	public void resetOriginalValues() {
		_moduleCertificate.resetOriginalValues();
	}

	private ModuleCertificate _moduleCertificate;
}