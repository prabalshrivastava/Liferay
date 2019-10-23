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
 * This class is a wrapper for {@link SPPackageItems}.
 * </p>
 *
 * @author pradeep
 * @see SPPackageItems
 * @generated
 */
public class SPPackageItemsWrapper implements SPPackageItems,
	ModelWrapper<SPPackageItems> {
	public SPPackageItemsWrapper(SPPackageItems spPackageItems) {
		_spPackageItems = spPackageItems;
	}

	@Override
	public Class<?> getModelClass() {
		return SPPackageItems.class;
	}

	@Override
	public String getModelClassName() {
		return SPPackageItems.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPackageItemsId", getSpPackageItemsId());
		attributes.put("groupId", getGroupId());
		attributes.put("packageId", getPackageId());
		attributes.put("itemId", getItemId());
		attributes.put("quantity", getQuantity());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPackageItemsId = (Long)attributes.get("spPackageItemsId");

		if (spPackageItemsId != null) {
			setSpPackageItemsId(spPackageItemsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long packageId = (Long)attributes.get("packageId");

		if (packageId != null) {
			setPackageId(packageId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
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
	* Returns the primary key of this s p package items.
	*
	* @return the primary key of this s p package items
	*/
	@Override
	public long getPrimaryKey() {
		return _spPackageItems.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p package items.
	*
	* @param primaryKey the primary key of this s p package items
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spPackageItems.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp package items ID of this s p package items.
	*
	* @return the sp package items ID of this s p package items
	*/
	@Override
	public long getSpPackageItemsId() {
		return _spPackageItems.getSpPackageItemsId();
	}

	/**
	* Sets the sp package items ID of this s p package items.
	*
	* @param spPackageItemsId the sp package items ID of this s p package items
	*/
	@Override
	public void setSpPackageItemsId(long spPackageItemsId) {
		_spPackageItems.setSpPackageItemsId(spPackageItemsId);
	}

	/**
	* Returns the group ID of this s p package items.
	*
	* @return the group ID of this s p package items
	*/
	@Override
	public long getGroupId() {
		return _spPackageItems.getGroupId();
	}

	/**
	* Sets the group ID of this s p package items.
	*
	* @param groupId the group ID of this s p package items
	*/
	@Override
	public void setGroupId(long groupId) {
		_spPackageItems.setGroupId(groupId);
	}

	/**
	* Returns the package ID of this s p package items.
	*
	* @return the package ID of this s p package items
	*/
	@Override
	public long getPackageId() {
		return _spPackageItems.getPackageId();
	}

	/**
	* Sets the package ID of this s p package items.
	*
	* @param packageId the package ID of this s p package items
	*/
	@Override
	public void setPackageId(long packageId) {
		_spPackageItems.setPackageId(packageId);
	}

	/**
	* Returns the item ID of this s p package items.
	*
	* @return the item ID of this s p package items
	*/
	@Override
	public long getItemId() {
		return _spPackageItems.getItemId();
	}

	/**
	* Sets the item ID of this s p package items.
	*
	* @param itemId the item ID of this s p package items
	*/
	@Override
	public void setItemId(long itemId) {
		_spPackageItems.setItemId(itemId);
	}

	/**
	* Returns the quantity of this s p package items.
	*
	* @return the quantity of this s p package items
	*/
	@Override
	public int getQuantity() {
		return _spPackageItems.getQuantity();
	}

	/**
	* Sets the quantity of this s p package items.
	*
	* @param quantity the quantity of this s p package items
	*/
	@Override
	public void setQuantity(int quantity) {
		_spPackageItems.setQuantity(quantity);
	}

	/**
	* Returns the company ID of this s p package items.
	*
	* @return the company ID of this s p package items
	*/
	@Override
	public long getCompanyId() {
		return _spPackageItems.getCompanyId();
	}

	/**
	* Sets the company ID of this s p package items.
	*
	* @param companyId the company ID of this s p package items
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spPackageItems.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p package items.
	*
	* @return the user ID of this s p package items
	*/
	@Override
	public long getUserId() {
		return _spPackageItems.getUserId();
	}

	/**
	* Sets the user ID of this s p package items.
	*
	* @param userId the user ID of this s p package items
	*/
	@Override
	public void setUserId(long userId) {
		_spPackageItems.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p package items.
	*
	* @return the user uuid of this s p package items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPackageItems.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p package items.
	*
	* @param userUuid the user uuid of this s p package items
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spPackageItems.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p package items.
	*
	* @return the user name of this s p package items
	*/
	@Override
	public java.lang.String getUserName() {
		return _spPackageItems.getUserName();
	}

	/**
	* Sets the user name of this s p package items.
	*
	* @param userName the user name of this s p package items
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spPackageItems.setUserName(userName);
	}

	/**
	* Returns the create date of this s p package items.
	*
	* @return the create date of this s p package items
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spPackageItems.getCreateDate();
	}

	/**
	* Sets the create date of this s p package items.
	*
	* @param createDate the create date of this s p package items
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spPackageItems.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p package items.
	*
	* @return the modified date of this s p package items
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spPackageItems.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p package items.
	*
	* @param modifiedDate the modified date of this s p package items
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spPackageItems.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spPackageItems.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spPackageItems.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spPackageItems.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spPackageItems.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spPackageItems.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spPackageItems.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spPackageItems.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spPackageItems.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spPackageItems.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spPackageItems.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spPackageItems.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPPackageItemsWrapper((SPPackageItems)_spPackageItems.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spshopping.model.SPPackageItems spPackageItems) {
		return _spPackageItems.compareTo(spPackageItems);
	}

	@Override
	public int hashCode() {
		return _spPackageItems.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spshopping.model.SPPackageItems> toCacheModel() {
		return _spPackageItems.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems toEscapedModel() {
		return new SPPackageItemsWrapper(_spPackageItems.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPPackageItems toUnescapedModel() {
		return new SPPackageItemsWrapper(_spPackageItems.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spPackageItems.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spPackageItems.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spPackageItems.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPPackageItemsWrapper)) {
			return false;
		}

		SPPackageItemsWrapper spPackageItemsWrapper = (SPPackageItemsWrapper)obj;

		if (Validator.equals(_spPackageItems,
					spPackageItemsWrapper._spPackageItems)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPPackageItems getWrappedSPPackageItems() {
		return _spPackageItems;
	}

	@Override
	public SPPackageItems getWrappedModel() {
		return _spPackageItems;
	}

	@Override
	public void resetOriginalValues() {
		_spPackageItems.resetOriginalValues();
	}

	private SPPackageItems _spPackageItems;
}