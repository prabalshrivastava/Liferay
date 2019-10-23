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

package com.sambaash.platform.srv.spshopping.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPSellingItem}.
 * </p>
 *
 * @author pradeep
 * @see SPSellingItem
 * @generated
 */
public class SPSellingItemWrapper implements SPSellingItem,
	ModelWrapper<SPSellingItem> {
	public SPSellingItemWrapper(SPSellingItem spSellingItem) {
		_spSellingItem = spSellingItem;
	}

	@Override
	public Class<?> getModelClass() {
		return SPSellingItem.class;
	}

	@Override
	public String getModelClassName() {
		return SPSellingItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spSellingItemId", getSpSellingItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("itemCode", getItemCode());
		attributes.put("entityClassPk", getEntityClassPk());
		attributes.put("entityClassNameId", getEntityClassNameId());
		attributes.put("entityClassName", getEntityClassName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("longDescription", getLongDescription());
		attributes.put("active", getActive());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spSellingItemId = (Long)attributes.get("spSellingItemId");

		if (spSellingItemId != null) {
			setSpSellingItemId(spSellingItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String itemCode = (String)attributes.get("itemCode");

		if (itemCode != null) {
			setItemCode(itemCode);
		}

		Long entityClassPk = (Long)attributes.get("entityClassPk");

		if (entityClassPk != null) {
			setEntityClassPk(entityClassPk);
		}

		Long entityClassNameId = (Long)attributes.get("entityClassNameId");

		if (entityClassNameId != null) {
			setEntityClassNameId(entityClassNameId);
		}

		String entityClassName = (String)attributes.get("entityClassName");

		if (entityClassName != null) {
			setEntityClassName(entityClassName);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String longDescription = (String)attributes.get("longDescription");

		if (longDescription != null) {
			setLongDescription(longDescription);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
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
	}

	/**
	* Returns the primary key of this s p selling item.
	*
	* @return the primary key of this s p selling item
	*/
	@Override
	public long getPrimaryKey() {
		return _spSellingItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p selling item.
	*
	* @param primaryKey the primary key of this s p selling item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spSellingItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp selling item ID of this s p selling item.
	*
	* @return the sp selling item ID of this s p selling item
	*/
	@Override
	public long getSpSellingItemId() {
		return _spSellingItem.getSpSellingItemId();
	}

	/**
	* Sets the sp selling item ID of this s p selling item.
	*
	* @param spSellingItemId the sp selling item ID of this s p selling item
	*/
	@Override
	public void setSpSellingItemId(long spSellingItemId) {
		_spSellingItem.setSpSellingItemId(spSellingItemId);
	}

	/**
	* Returns the group ID of this s p selling item.
	*
	* @return the group ID of this s p selling item
	*/
	@Override
	public long getGroupId() {
		return _spSellingItem.getGroupId();
	}

	/**
	* Sets the group ID of this s p selling item.
	*
	* @param groupId the group ID of this s p selling item
	*/
	@Override
	public void setGroupId(long groupId) {
		_spSellingItem.setGroupId(groupId);
	}

	/**
	* Returns the title of this s p selling item.
	*
	* @return the title of this s p selling item
	*/
	@Override
	public java.lang.String getTitle() {
		return _spSellingItem.getTitle();
	}

	/**
	* Sets the title of this s p selling item.
	*
	* @param title the title of this s p selling item
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_spSellingItem.setTitle(title);
	}

	/**
	* Returns the item code of this s p selling item.
	*
	* @return the item code of this s p selling item
	*/
	@Override
	public java.lang.String getItemCode() {
		return _spSellingItem.getItemCode();
	}

	/**
	* Sets the item code of this s p selling item.
	*
	* @param itemCode the item code of this s p selling item
	*/
	@Override
	public void setItemCode(java.lang.String itemCode) {
		_spSellingItem.setItemCode(itemCode);
	}

	/**
	* Returns the entity class pk of this s p selling item.
	*
	* @return the entity class pk of this s p selling item
	*/
	@Override
	public long getEntityClassPk() {
		return _spSellingItem.getEntityClassPk();
	}

	/**
	* Sets the entity class pk of this s p selling item.
	*
	* @param entityClassPk the entity class pk of this s p selling item
	*/
	@Override
	public void setEntityClassPk(long entityClassPk) {
		_spSellingItem.setEntityClassPk(entityClassPk);
	}

	/**
	* Returns the entity class name ID of this s p selling item.
	*
	* @return the entity class name ID of this s p selling item
	*/
	@Override
	public long getEntityClassNameId() {
		return _spSellingItem.getEntityClassNameId();
	}

	/**
	* Sets the entity class name ID of this s p selling item.
	*
	* @param entityClassNameId the entity class name ID of this s p selling item
	*/
	@Override
	public void setEntityClassNameId(long entityClassNameId) {
		_spSellingItem.setEntityClassNameId(entityClassNameId);
	}

	/**
	* Returns the entity class name of this s p selling item.
	*
	* @return the entity class name of this s p selling item
	*/
	@Override
	public java.lang.String getEntityClassName() {
		return _spSellingItem.getEntityClassName();
	}

	/**
	* Sets the entity class name of this s p selling item.
	*
	* @param entityClassName the entity class name of this s p selling item
	*/
	@Override
	public void setEntityClassName(java.lang.String entityClassName) {
		_spSellingItem.setEntityClassName(entityClassName);
	}

	/**
	* Returns the short description of this s p selling item.
	*
	* @return the short description of this s p selling item
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _spSellingItem.getShortDescription();
	}

	/**
	* Sets the short description of this s p selling item.
	*
	* @param shortDescription the short description of this s p selling item
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_spSellingItem.setShortDescription(shortDescription);
	}

	/**
	* Returns the long description of this s p selling item.
	*
	* @return the long description of this s p selling item
	*/
	@Override
	public java.lang.String getLongDescription() {
		return _spSellingItem.getLongDescription();
	}

	/**
	* Sets the long description of this s p selling item.
	*
	* @param longDescription the long description of this s p selling item
	*/
	@Override
	public void setLongDescription(java.lang.String longDescription) {
		_spSellingItem.setLongDescription(longDescription);
	}

	/**
	* Returns the active of this s p selling item.
	*
	* @return the active of this s p selling item
	*/
	@Override
	public boolean getActive() {
		return _spSellingItem.getActive();
	}

	/**
	* Returns <code>true</code> if this s p selling item is active.
	*
	* @return <code>true</code> if this s p selling item is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _spSellingItem.isActive();
	}

	/**
	* Sets whether this s p selling item is active.
	*
	* @param active the active of this s p selling item
	*/
	@Override
	public void setActive(boolean active) {
		_spSellingItem.setActive(active);
	}

	/**
	* Returns the company ID of this s p selling item.
	*
	* @return the company ID of this s p selling item
	*/
	@Override
	public long getCompanyId() {
		return _spSellingItem.getCompanyId();
	}

	/**
	* Sets the company ID of this s p selling item.
	*
	* @param companyId the company ID of this s p selling item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spSellingItem.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p selling item.
	*
	* @return the user ID of this s p selling item
	*/
	@Override
	public long getUserId() {
		return _spSellingItem.getUserId();
	}

	/**
	* Sets the user ID of this s p selling item.
	*
	* @param userId the user ID of this s p selling item
	*/
	@Override
	public void setUserId(long userId) {
		_spSellingItem.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p selling item.
	*
	* @return the user uuid of this s p selling item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingItem.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p selling item.
	*
	* @param userUuid the user uuid of this s p selling item
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spSellingItem.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p selling item.
	*
	* @return the user name of this s p selling item
	*/
	@Override
	public java.lang.String getUserName() {
		return _spSellingItem.getUserName();
	}

	/**
	* Sets the user name of this s p selling item.
	*
	* @param userName the user name of this s p selling item
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spSellingItem.setUserName(userName);
	}

	/**
	* Returns the create date of this s p selling item.
	*
	* @return the create date of this s p selling item
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spSellingItem.getCreateDate();
	}

	/**
	* Sets the create date of this s p selling item.
	*
	* @param createDate the create date of this s p selling item
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spSellingItem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p selling item.
	*
	* @return the modified date of this s p selling item
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spSellingItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p selling item.
	*
	* @param modifiedDate the modified date of this s p selling item
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spSellingItem.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spSellingItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spSellingItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spSellingItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spSellingItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spSellingItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spSellingItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spSellingItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spSellingItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spSellingItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spSellingItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spSellingItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPSellingItemWrapper((SPSellingItem)_spSellingItem.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spshopping.model.SPSellingItem spSellingItem) {
		return _spSellingItem.compareTo(spSellingItem);
	}

	@Override
	public int hashCode() {
		return _spSellingItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spshopping.model.SPSellingItem> toCacheModel() {
		return _spSellingItem.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingItem toEscapedModel() {
		return new SPSellingItemWrapper(_spSellingItem.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingItem toUnescapedModel() {
		return new SPSellingItemWrapper(_spSellingItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spSellingItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spSellingItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spSellingItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPSellingItemWrapper)) {
			return false;
		}

		SPSellingItemWrapper spSellingItemWrapper = (SPSellingItemWrapper)obj;

		if (Validator.equals(_spSellingItem, spSellingItemWrapper._spSellingItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPSellingItem getWrappedSPSellingItem() {
		return _spSellingItem;
	}

	@Override
	public SPSellingItem getWrappedModel() {
		return _spSellingItem;
	}

	@Override
	public void resetOriginalValues() {
		_spSellingItem.resetOriginalValues();
	}

	private SPSellingItem _spSellingItem;
}