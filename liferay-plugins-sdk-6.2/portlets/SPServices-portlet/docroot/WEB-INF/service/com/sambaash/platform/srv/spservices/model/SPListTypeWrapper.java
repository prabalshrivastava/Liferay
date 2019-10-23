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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPListType}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPListType
 * @generated
 */
public class SPListTypeWrapper implements SPListType, ModelWrapper<SPListType> {
	public SPListTypeWrapper(SPListType spListType) {
		_spListType = spListType;
	}

	@Override
	public Class<?> getModelClass() {
		return SPListType.class;
	}

	@Override
	public String getModelClassName() {
		return SPListType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spListTypeId", getSpListTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("itemKey", getItemKey());
		attributes.put("itemValue", getItemValue());
		attributes.put("displayName", getDisplayName());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("categoryId", getCategoryId());
		attributes.put("modeldata", getModeldata());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spListTypeId = (Long)attributes.get("spListTypeId");

		if (spListTypeId != null) {
			setSpListTypeId(spListTypeId);
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

		String itemKey = (String)attributes.get("itemKey");

		if (itemKey != null) {
			setItemKey(itemKey);
		}

		String itemValue = (String)attributes.get("itemValue");

		if (itemValue != null) {
			setItemValue(itemValue);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		Integer displayOrder = (Integer)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String modeldata = (String)attributes.get("modeldata");

		if (modeldata != null) {
			setModeldata(modeldata);
		}
	}

	/**
	* Returns the primary key of this s p list type.
	*
	* @return the primary key of this s p list type
	*/
	@Override
	public long getPrimaryKey() {
		return _spListType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p list type.
	*
	* @param primaryKey the primary key of this s p list type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spListType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p list type.
	*
	* @return the uuid of this s p list type
	*/
	@Override
	public java.lang.String getUuid() {
		return _spListType.getUuid();
	}

	/**
	* Sets the uuid of this s p list type.
	*
	* @param uuid the uuid of this s p list type
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spListType.setUuid(uuid);
	}

	/**
	* Returns the sp list type ID of this s p list type.
	*
	* @return the sp list type ID of this s p list type
	*/
	@Override
	public long getSpListTypeId() {
		return _spListType.getSpListTypeId();
	}

	/**
	* Sets the sp list type ID of this s p list type.
	*
	* @param spListTypeId the sp list type ID of this s p list type
	*/
	@Override
	public void setSpListTypeId(long spListTypeId) {
		_spListType.setSpListTypeId(spListTypeId);
	}

	/**
	* Returns the group ID of this s p list type.
	*
	* @return the group ID of this s p list type
	*/
	@Override
	public long getGroupId() {
		return _spListType.getGroupId();
	}

	/**
	* Sets the group ID of this s p list type.
	*
	* @param groupId the group ID of this s p list type
	*/
	@Override
	public void setGroupId(long groupId) {
		_spListType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p list type.
	*
	* @return the company ID of this s p list type
	*/
	@Override
	public long getCompanyId() {
		return _spListType.getCompanyId();
	}

	/**
	* Sets the company ID of this s p list type.
	*
	* @param companyId the company ID of this s p list type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spListType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p list type.
	*
	* @return the user ID of this s p list type
	*/
	@Override
	public long getUserId() {
		return _spListType.getUserId();
	}

	/**
	* Sets the user ID of this s p list type.
	*
	* @param userId the user ID of this s p list type
	*/
	@Override
	public void setUserId(long userId) {
		_spListType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p list type.
	*
	* @return the user uuid of this s p list type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spListType.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p list type.
	*
	* @param userUuid the user uuid of this s p list type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spListType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p list type.
	*
	* @return the user name of this s p list type
	*/
	@Override
	public java.lang.String getUserName() {
		return _spListType.getUserName();
	}

	/**
	* Sets the user name of this s p list type.
	*
	* @param userName the user name of this s p list type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spListType.setUserName(userName);
	}

	/**
	* Returns the create date of this s p list type.
	*
	* @return the create date of this s p list type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spListType.getCreateDate();
	}

	/**
	* Sets the create date of this s p list type.
	*
	* @param createDate the create date of this s p list type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spListType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p list type.
	*
	* @return the modified date of this s p list type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spListType.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p list type.
	*
	* @param modifiedDate the modified date of this s p list type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spListType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the item key of this s p list type.
	*
	* @return the item key of this s p list type
	*/
	@Override
	public java.lang.String getItemKey() {
		return _spListType.getItemKey();
	}

	/**
	* Sets the item key of this s p list type.
	*
	* @param itemKey the item key of this s p list type
	*/
	@Override
	public void setItemKey(java.lang.String itemKey) {
		_spListType.setItemKey(itemKey);
	}

	/**
	* Returns the item value of this s p list type.
	*
	* @return the item value of this s p list type
	*/
	@Override
	public java.lang.String getItemValue() {
		return _spListType.getItemValue();
	}

	/**
	* Sets the item value of this s p list type.
	*
	* @param itemValue the item value of this s p list type
	*/
	@Override
	public void setItemValue(java.lang.String itemValue) {
		_spListType.setItemValue(itemValue);
	}

	/**
	* Returns the display name of this s p list type.
	*
	* @return the display name of this s p list type
	*/
	@Override
	public java.lang.String getDisplayName() {
		return _spListType.getDisplayName();
	}

	/**
	* Sets the display name of this s p list type.
	*
	* @param displayName the display name of this s p list type
	*/
	@Override
	public void setDisplayName(java.lang.String displayName) {
		_spListType.setDisplayName(displayName);
	}

	/**
	* Returns the display order of this s p list type.
	*
	* @return the display order of this s p list type
	*/
	@Override
	public int getDisplayOrder() {
		return _spListType.getDisplayOrder();
	}

	/**
	* Sets the display order of this s p list type.
	*
	* @param displayOrder the display order of this s p list type
	*/
	@Override
	public void setDisplayOrder(int displayOrder) {
		_spListType.setDisplayOrder(displayOrder);
	}

	/**
	* Returns the category ID of this s p list type.
	*
	* @return the category ID of this s p list type
	*/
	@Override
	public long getCategoryId() {
		return _spListType.getCategoryId();
	}

	/**
	* Sets the category ID of this s p list type.
	*
	* @param categoryId the category ID of this s p list type
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_spListType.setCategoryId(categoryId);
	}

	/**
	* Returns the modeldata of this s p list type.
	*
	* @return the modeldata of this s p list type
	*/
	@Override
	public java.lang.String getModeldata() {
		return _spListType.getModeldata();
	}

	/**
	* Sets the modeldata of this s p list type.
	*
	* @param modeldata the modeldata of this s p list type
	*/
	@Override
	public void setModeldata(java.lang.String modeldata) {
		_spListType.setModeldata(modeldata);
	}

	@Override
	public boolean isNew() {
		return _spListType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spListType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spListType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spListType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spListType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spListType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spListType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spListType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spListType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spListType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spListType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPListTypeWrapper((SPListType)_spListType.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPListType spListType) {
		return _spListType.compareTo(spListType);
	}

	@Override
	public int hashCode() {
		return _spListType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPListType> toCacheModel() {
		return _spListType.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPListType toEscapedModel() {
		return new SPListTypeWrapper(_spListType.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPListType toUnescapedModel() {
		return new SPListTypeWrapper(_spListType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spListType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spListType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spListType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPListTypeWrapper)) {
			return false;
		}

		SPListTypeWrapper spListTypeWrapper = (SPListTypeWrapper)obj;

		if (Validator.equals(_spListType, spListTypeWrapper._spListType)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spListType.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPListType getWrappedSPListType() {
		return _spListType;
	}

	@Override
	public SPListType getWrappedModel() {
		return _spListType;
	}

	@Override
	public void resetOriginalValues() {
		_spListType.resetOriginalValues();
	}

	private SPListType _spListType;
}