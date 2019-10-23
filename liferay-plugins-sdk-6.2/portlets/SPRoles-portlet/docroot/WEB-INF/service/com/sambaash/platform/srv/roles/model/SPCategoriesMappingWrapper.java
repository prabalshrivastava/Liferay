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

package com.sambaash.platform.srv.roles.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPCategoriesMapping}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPCategoriesMapping
 * @generated
 */
public class SPCategoriesMappingWrapper implements SPCategoriesMapping,
	ModelWrapper<SPCategoriesMapping> {
	public SPCategoriesMappingWrapper(SPCategoriesMapping spCategoriesMapping) {
		_spCategoriesMapping = spCategoriesMapping;
	}

	@Override
	public Class<?> getModelClass() {
		return SPCategoriesMapping.class;
	}

	@Override
	public String getModelClassName() {
		return SPCategoriesMapping.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spCategoryMappingId", getSpCategoryMappingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdVocabularyId", getCreatedVocabularyId());
		attributes.put("mainCategoryId", getMainCategoryId());
		attributes.put("subCategoryId", getSubCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spCategoryMappingId = (Long)attributes.get("spCategoryMappingId");

		if (spCategoryMappingId != null) {
			setSpCategoryMappingId(spCategoryMappingId);
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

		Long createdVocabularyId = (Long)attributes.get("createdVocabularyId");

		if (createdVocabularyId != null) {
			setCreatedVocabularyId(createdVocabularyId);
		}

		Long mainCategoryId = (Long)attributes.get("mainCategoryId");

		if (mainCategoryId != null) {
			setMainCategoryId(mainCategoryId);
		}

		Long subCategoryId = (Long)attributes.get("subCategoryId");

		if (subCategoryId != null) {
			setSubCategoryId(subCategoryId);
		}
	}

	/**
	* Returns the primary key of this s p categories mapping.
	*
	* @return the primary key of this s p categories mapping
	*/
	@Override
	public long getPrimaryKey() {
		return _spCategoriesMapping.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p categories mapping.
	*
	* @param primaryKey the primary key of this s p categories mapping
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spCategoriesMapping.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p categories mapping.
	*
	* @return the uuid of this s p categories mapping
	*/
	@Override
	public java.lang.String getUuid() {
		return _spCategoriesMapping.getUuid();
	}

	/**
	* Sets the uuid of this s p categories mapping.
	*
	* @param uuid the uuid of this s p categories mapping
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spCategoriesMapping.setUuid(uuid);
	}

	/**
	* Returns the sp category mapping ID of this s p categories mapping.
	*
	* @return the sp category mapping ID of this s p categories mapping
	*/
	@Override
	public long getSpCategoryMappingId() {
		return _spCategoriesMapping.getSpCategoryMappingId();
	}

	/**
	* Sets the sp category mapping ID of this s p categories mapping.
	*
	* @param spCategoryMappingId the sp category mapping ID of this s p categories mapping
	*/
	@Override
	public void setSpCategoryMappingId(long spCategoryMappingId) {
		_spCategoriesMapping.setSpCategoryMappingId(spCategoryMappingId);
	}

	/**
	* Returns the group ID of this s p categories mapping.
	*
	* @return the group ID of this s p categories mapping
	*/
	@Override
	public long getGroupId() {
		return _spCategoriesMapping.getGroupId();
	}

	/**
	* Sets the group ID of this s p categories mapping.
	*
	* @param groupId the group ID of this s p categories mapping
	*/
	@Override
	public void setGroupId(long groupId) {
		_spCategoriesMapping.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p categories mapping.
	*
	* @return the company ID of this s p categories mapping
	*/
	@Override
	public long getCompanyId() {
		return _spCategoriesMapping.getCompanyId();
	}

	/**
	* Sets the company ID of this s p categories mapping.
	*
	* @param companyId the company ID of this s p categories mapping
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spCategoriesMapping.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p categories mapping.
	*
	* @return the user ID of this s p categories mapping
	*/
	@Override
	public long getUserId() {
		return _spCategoriesMapping.getUserId();
	}

	/**
	* Sets the user ID of this s p categories mapping.
	*
	* @param userId the user ID of this s p categories mapping
	*/
	@Override
	public void setUserId(long userId) {
		_spCategoriesMapping.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p categories mapping.
	*
	* @return the user uuid of this s p categories mapping
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCategoriesMapping.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p categories mapping.
	*
	* @param userUuid the user uuid of this s p categories mapping
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spCategoriesMapping.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p categories mapping.
	*
	* @return the user name of this s p categories mapping
	*/
	@Override
	public java.lang.String getUserName() {
		return _spCategoriesMapping.getUserName();
	}

	/**
	* Sets the user name of this s p categories mapping.
	*
	* @param userName the user name of this s p categories mapping
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spCategoriesMapping.setUserName(userName);
	}

	/**
	* Returns the create date of this s p categories mapping.
	*
	* @return the create date of this s p categories mapping
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spCategoriesMapping.getCreateDate();
	}

	/**
	* Sets the create date of this s p categories mapping.
	*
	* @param createDate the create date of this s p categories mapping
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spCategoriesMapping.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p categories mapping.
	*
	* @return the modified date of this s p categories mapping
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spCategoriesMapping.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p categories mapping.
	*
	* @param modifiedDate the modified date of this s p categories mapping
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spCategoriesMapping.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the created vocabulary ID of this s p categories mapping.
	*
	* @return the created vocabulary ID of this s p categories mapping
	*/
	@Override
	public long getCreatedVocabularyId() {
		return _spCategoriesMapping.getCreatedVocabularyId();
	}

	/**
	* Sets the created vocabulary ID of this s p categories mapping.
	*
	* @param createdVocabularyId the created vocabulary ID of this s p categories mapping
	*/
	@Override
	public void setCreatedVocabularyId(long createdVocabularyId) {
		_spCategoriesMapping.setCreatedVocabularyId(createdVocabularyId);
	}

	/**
	* Returns the main category ID of this s p categories mapping.
	*
	* @return the main category ID of this s p categories mapping
	*/
	@Override
	public long getMainCategoryId() {
		return _spCategoriesMapping.getMainCategoryId();
	}

	/**
	* Sets the main category ID of this s p categories mapping.
	*
	* @param mainCategoryId the main category ID of this s p categories mapping
	*/
	@Override
	public void setMainCategoryId(long mainCategoryId) {
		_spCategoriesMapping.setMainCategoryId(mainCategoryId);
	}

	/**
	* Returns the sub category ID of this s p categories mapping.
	*
	* @return the sub category ID of this s p categories mapping
	*/
	@Override
	public long getSubCategoryId() {
		return _spCategoriesMapping.getSubCategoryId();
	}

	/**
	* Sets the sub category ID of this s p categories mapping.
	*
	* @param subCategoryId the sub category ID of this s p categories mapping
	*/
	@Override
	public void setSubCategoryId(long subCategoryId) {
		_spCategoriesMapping.setSubCategoryId(subCategoryId);
	}

	@Override
	public boolean isNew() {
		return _spCategoriesMapping.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spCategoriesMapping.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spCategoriesMapping.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spCategoriesMapping.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spCategoriesMapping.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spCategoriesMapping.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spCategoriesMapping.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spCategoriesMapping.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spCategoriesMapping.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spCategoriesMapping.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spCategoriesMapping.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPCategoriesMappingWrapper((SPCategoriesMapping)_spCategoriesMapping.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.roles.model.SPCategoriesMapping spCategoriesMapping) {
		return _spCategoriesMapping.compareTo(spCategoriesMapping);
	}

	@Override
	public int hashCode() {
		return _spCategoriesMapping.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.roles.model.SPCategoriesMapping> toCacheModel() {
		return _spCategoriesMapping.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping toEscapedModel() {
		return new SPCategoriesMappingWrapper(_spCategoriesMapping.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.roles.model.SPCategoriesMapping toUnescapedModel() {
		return new SPCategoriesMappingWrapper(_spCategoriesMapping.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spCategoriesMapping.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spCategoriesMapping.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spCategoriesMapping.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPCategoriesMappingWrapper)) {
			return false;
		}

		SPCategoriesMappingWrapper spCategoriesMappingWrapper = (SPCategoriesMappingWrapper)obj;

		if (Validator.equals(_spCategoriesMapping,
					spCategoriesMappingWrapper._spCategoriesMapping)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spCategoriesMapping.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPCategoriesMapping getWrappedSPCategoriesMapping() {
		return _spCategoriesMapping;
	}

	@Override
	public SPCategoriesMapping getWrappedModel() {
		return _spCategoriesMapping;
	}

	@Override
	public void resetOriginalValues() {
		_spCategoriesMapping.resetOriginalValues();
	}

	private SPCategoriesMapping _spCategoriesMapping;
}