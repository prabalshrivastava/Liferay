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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPUserType}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPUserType
 * @generated
 */
public class SPUserTypeWrapper implements SPUserType, ModelWrapper<SPUserType> {
	public SPUserTypeWrapper(SPUserType spUserType) {
		_spUserType = spUserType;
	}

	@Override
	public Class<?> getModelClass() {
		return SPUserType.class;
	}

	@Override
	public String getModelClassName() {
		return SPUserType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spUserTypeId", getSpUserTypeId());
		attributes.put("spSiteId", getSpSiteId());
		attributes.put("userId", getUserId());
		attributes.put("userTypeId", getUserTypeId());
		attributes.put("userStatusId", getUserStatusId());
		attributes.put("declarationCompleted", getDeclarationCompleted());
		attributes.put("declarationDate", getDeclarationDate());
		attributes.put("declarationStorageId", getDeclarationStorageId());
		attributes.put("pdpaCompleted", getPdpaCompleted());
		attributes.put("pdpaCompletionDate", getPdpaCompletionDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spUserTypeId = (Long)attributes.get("spUserTypeId");

		if (spUserTypeId != null) {
			setSpUserTypeId(spUserTypeId);
		}

		Long spSiteId = (Long)attributes.get("spSiteId");

		if (spSiteId != null) {
			setSpSiteId(spSiteId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long userTypeId = (Long)attributes.get("userTypeId");

		if (userTypeId != null) {
			setUserTypeId(userTypeId);
		}

		Long userStatusId = (Long)attributes.get("userStatusId");

		if (userStatusId != null) {
			setUserStatusId(userStatusId);
		}

		Boolean declarationCompleted = (Boolean)attributes.get(
				"declarationCompleted");

		if (declarationCompleted != null) {
			setDeclarationCompleted(declarationCompleted);
		}

		Long declarationDate = (Long)attributes.get("declarationDate");

		if (declarationDate != null) {
			setDeclarationDate(declarationDate);
		}

		Long declarationStorageId = (Long)attributes.get("declarationStorageId");

		if (declarationStorageId != null) {
			setDeclarationStorageId(declarationStorageId);
		}

		Boolean pdpaCompleted = (Boolean)attributes.get("pdpaCompleted");

		if (pdpaCompleted != null) {
			setPdpaCompleted(pdpaCompleted);
		}

		Long pdpaCompletionDate = (Long)attributes.get("pdpaCompletionDate");

		if (pdpaCompletionDate != null) {
			setPdpaCompletionDate(pdpaCompletionDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this s p user type.
	*
	* @return the primary key of this s p user type
	*/
	@Override
	public long getPrimaryKey() {
		return _spUserType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p user type.
	*
	* @param primaryKey the primary key of this s p user type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spUserType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p user type.
	*
	* @return the uuid of this s p user type
	*/
	@Override
	public java.lang.String getUuid() {
		return _spUserType.getUuid();
	}

	/**
	* Sets the uuid of this s p user type.
	*
	* @param uuid the uuid of this s p user type
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spUserType.setUuid(uuid);
	}

	/**
	* Returns the sp user type ID of this s p user type.
	*
	* @return the sp user type ID of this s p user type
	*/
	@Override
	public long getSpUserTypeId() {
		return _spUserType.getSpUserTypeId();
	}

	/**
	* Sets the sp user type ID of this s p user type.
	*
	* @param spUserTypeId the sp user type ID of this s p user type
	*/
	@Override
	public void setSpUserTypeId(long spUserTypeId) {
		_spUserType.setSpUserTypeId(spUserTypeId);
	}

	/**
	* Returns the sp site ID of this s p user type.
	*
	* @return the sp site ID of this s p user type
	*/
	@Override
	public long getSpSiteId() {
		return _spUserType.getSpSiteId();
	}

	/**
	* Sets the sp site ID of this s p user type.
	*
	* @param spSiteId the sp site ID of this s p user type
	*/
	@Override
	public void setSpSiteId(long spSiteId) {
		_spUserType.setSpSiteId(spSiteId);
	}

	/**
	* Returns the user ID of this s p user type.
	*
	* @return the user ID of this s p user type
	*/
	@Override
	public long getUserId() {
		return _spUserType.getUserId();
	}

	/**
	* Sets the user ID of this s p user type.
	*
	* @param userId the user ID of this s p user type
	*/
	@Override
	public void setUserId(long userId) {
		_spUserType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p user type.
	*
	* @return the user uuid of this s p user type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spUserType.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p user type.
	*
	* @param userUuid the user uuid of this s p user type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spUserType.setUserUuid(userUuid);
	}

	/**
	* Returns the user type ID of this s p user type.
	*
	* @return the user type ID of this s p user type
	*/
	@Override
	public long getUserTypeId() {
		return _spUserType.getUserTypeId();
	}

	/**
	* Sets the user type ID of this s p user type.
	*
	* @param userTypeId the user type ID of this s p user type
	*/
	@Override
	public void setUserTypeId(long userTypeId) {
		_spUserType.setUserTypeId(userTypeId);
	}

	/**
	* Returns the user status ID of this s p user type.
	*
	* @return the user status ID of this s p user type
	*/
	@Override
	public long getUserStatusId() {
		return _spUserType.getUserStatusId();
	}

	/**
	* Sets the user status ID of this s p user type.
	*
	* @param userStatusId the user status ID of this s p user type
	*/
	@Override
	public void setUserStatusId(long userStatusId) {
		_spUserType.setUserStatusId(userStatusId);
	}

	/**
	* Returns the declaration completed of this s p user type.
	*
	* @return the declaration completed of this s p user type
	*/
	@Override
	public boolean getDeclarationCompleted() {
		return _spUserType.getDeclarationCompleted();
	}

	/**
	* Returns <code>true</code> if this s p user type is declaration completed.
	*
	* @return <code>true</code> if this s p user type is declaration completed; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeclarationCompleted() {
		return _spUserType.isDeclarationCompleted();
	}

	/**
	* Sets whether this s p user type is declaration completed.
	*
	* @param declarationCompleted the declaration completed of this s p user type
	*/
	@Override
	public void setDeclarationCompleted(boolean declarationCompleted) {
		_spUserType.setDeclarationCompleted(declarationCompleted);
	}

	/**
	* Returns the declaration date of this s p user type.
	*
	* @return the declaration date of this s p user type
	*/
	@Override
	public long getDeclarationDate() {
		return _spUserType.getDeclarationDate();
	}

	/**
	* Sets the declaration date of this s p user type.
	*
	* @param declarationDate the declaration date of this s p user type
	*/
	@Override
	public void setDeclarationDate(long declarationDate) {
		_spUserType.setDeclarationDate(declarationDate);
	}

	/**
	* Returns the declaration storage ID of this s p user type.
	*
	* @return the declaration storage ID of this s p user type
	*/
	@Override
	public long getDeclarationStorageId() {
		return _spUserType.getDeclarationStorageId();
	}

	/**
	* Sets the declaration storage ID of this s p user type.
	*
	* @param declarationStorageId the declaration storage ID of this s p user type
	*/
	@Override
	public void setDeclarationStorageId(long declarationStorageId) {
		_spUserType.setDeclarationStorageId(declarationStorageId);
	}

	/**
	* Returns the pdpa completed of this s p user type.
	*
	* @return the pdpa completed of this s p user type
	*/
	@Override
	public boolean getPdpaCompleted() {
		return _spUserType.getPdpaCompleted();
	}

	/**
	* Returns <code>true</code> if this s p user type is pdpa completed.
	*
	* @return <code>true</code> if this s p user type is pdpa completed; <code>false</code> otherwise
	*/
	@Override
	public boolean isPdpaCompleted() {
		return _spUserType.isPdpaCompleted();
	}

	/**
	* Sets whether this s p user type is pdpa completed.
	*
	* @param pdpaCompleted the pdpa completed of this s p user type
	*/
	@Override
	public void setPdpaCompleted(boolean pdpaCompleted) {
		_spUserType.setPdpaCompleted(pdpaCompleted);
	}

	/**
	* Returns the pdpa completion date of this s p user type.
	*
	* @return the pdpa completion date of this s p user type
	*/
	@Override
	public long getPdpaCompletionDate() {
		return _spUserType.getPdpaCompletionDate();
	}

	/**
	* Sets the pdpa completion date of this s p user type.
	*
	* @param pdpaCompletionDate the pdpa completion date of this s p user type
	*/
	@Override
	public void setPdpaCompletionDate(long pdpaCompletionDate) {
		_spUserType.setPdpaCompletionDate(pdpaCompletionDate);
	}

	/**
	* Returns the group ID of this s p user type.
	*
	* @return the group ID of this s p user type
	*/
	@Override
	public long getGroupId() {
		return _spUserType.getGroupId();
	}

	/**
	* Sets the group ID of this s p user type.
	*
	* @param groupId the group ID of this s p user type
	*/
	@Override
	public void setGroupId(long groupId) {
		_spUserType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p user type.
	*
	* @return the company ID of this s p user type
	*/
	@Override
	public long getCompanyId() {
		return _spUserType.getCompanyId();
	}

	/**
	* Sets the company ID of this s p user type.
	*
	* @param companyId the company ID of this s p user type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spUserType.setCompanyId(companyId);
	}

	/**
	* Returns the created by of this s p user type.
	*
	* @return the created by of this s p user type
	*/
	@Override
	public long getCreatedBy() {
		return _spUserType.getCreatedBy();
	}

	/**
	* Sets the created by of this s p user type.
	*
	* @param createdBy the created by of this s p user type
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_spUserType.setCreatedBy(createdBy);
	}

	/**
	* Returns the modified by of this s p user type.
	*
	* @return the modified by of this s p user type
	*/
	@Override
	public long getModifiedBy() {
		return _spUserType.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p user type.
	*
	* @param modifiedBy the modified by of this s p user type
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_spUserType.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the created date of this s p user type.
	*
	* @return the created date of this s p user type
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _spUserType.getCreatedDate();
	}

	/**
	* Sets the created date of this s p user type.
	*
	* @param createdDate the created date of this s p user type
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_spUserType.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this s p user type.
	*
	* @return the modified date of this s p user type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spUserType.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p user type.
	*
	* @param modifiedDate the modified date of this s p user type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spUserType.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spUserType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spUserType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spUserType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spUserType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spUserType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spUserType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spUserType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spUserType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spUserType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spUserType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spUserType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPUserTypeWrapper((SPUserType)_spUserType.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType) {
		return _spUserType.compareTo(spUserType);
	}

	@Override
	public int hashCode() {
		return _spUserType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPUserType> toCacheModel() {
		return _spUserType.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType toEscapedModel() {
		return new SPUserTypeWrapper(_spUserType.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserType toUnescapedModel() {
		return new SPUserTypeWrapper(_spUserType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spUserType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spUserType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spUserType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPUserTypeWrapper)) {
			return false;
		}

		SPUserTypeWrapper spUserTypeWrapper = (SPUserTypeWrapper)obj;

		if (Validator.equals(_spUserType, spUserTypeWrapper._spUserType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPUserType getWrappedSPUserType() {
		return _spUserType;
	}

	@Override
	public SPUserType getWrappedModel() {
		return _spUserType;
	}

	@Override
	public void resetOriginalValues() {
		_spUserType.resetOriginalValues();
	}

	private SPUserType _spUserType;
}