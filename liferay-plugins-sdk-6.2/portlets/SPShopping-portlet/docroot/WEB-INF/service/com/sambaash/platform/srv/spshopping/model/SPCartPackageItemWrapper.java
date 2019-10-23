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
 * This class is a wrapper for {@link SPCartPackageItem}.
 * </p>
 *
 * @author pradeep
 * @see SPCartPackageItem
 * @generated
 */
public class SPCartPackageItemWrapper implements SPCartPackageItem,
	ModelWrapper<SPCartPackageItem> {
	public SPCartPackageItemWrapper(SPCartPackageItem spCartPackageItem) {
		_spCartPackageItem = spCartPackageItem;
	}

	@Override
	public Class<?> getModelClass() {
		return SPCartPackageItem.class;
	}

	@Override
	public String getModelClassName() {
		return SPCartPackageItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCartPackageItemId", getSpCartPackageItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("spCartPackageId", getSpCartPackageId());
		attributes.put("title", getTitle());
		attributes.put("itemCode", getItemCode());
		attributes.put("quantity", getQuantity());
		attributes.put("entityClassPk", getEntityClassPk());
		attributes.put("entityClassName", getEntityClassName());
		attributes.put("totalPrice", getTotalPrice());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCartPackageItemId = (Long)attributes.get("spCartPackageItemId");

		if (spCartPackageItemId != null) {
			setSpCartPackageItemId(spCartPackageItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long spCartPackageId = (Long)attributes.get("spCartPackageId");

		if (spCartPackageId != null) {
			setSpCartPackageId(spCartPackageId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String itemCode = (String)attributes.get("itemCode");

		if (itemCode != null) {
			setItemCode(itemCode);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Long entityClassPk = (Long)attributes.get("entityClassPk");

		if (entityClassPk != null) {
			setEntityClassPk(entityClassPk);
		}

		String entityClassName = (String)attributes.get("entityClassName");

		if (entityClassName != null) {
			setEntityClassName(entityClassName);
		}

		String totalPrice = (String)attributes.get("totalPrice");

		if (totalPrice != null) {
			setTotalPrice(totalPrice);
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
	* Returns the primary key of this s p cart package item.
	*
	* @return the primary key of this s p cart package item
	*/
	@Override
	public long getPrimaryKey() {
		return _spCartPackageItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p cart package item.
	*
	* @param primaryKey the primary key of this s p cart package item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spCartPackageItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp cart package item ID of this s p cart package item.
	*
	* @return the sp cart package item ID of this s p cart package item
	*/
	@Override
	public long getSpCartPackageItemId() {
		return _spCartPackageItem.getSpCartPackageItemId();
	}

	/**
	* Sets the sp cart package item ID of this s p cart package item.
	*
	* @param spCartPackageItemId the sp cart package item ID of this s p cart package item
	*/
	@Override
	public void setSpCartPackageItemId(long spCartPackageItemId) {
		_spCartPackageItem.setSpCartPackageItemId(spCartPackageItemId);
	}

	/**
	* Returns the group ID of this s p cart package item.
	*
	* @return the group ID of this s p cart package item
	*/
	@Override
	public long getGroupId() {
		return _spCartPackageItem.getGroupId();
	}

	/**
	* Sets the group ID of this s p cart package item.
	*
	* @param groupId the group ID of this s p cart package item
	*/
	@Override
	public void setGroupId(long groupId) {
		_spCartPackageItem.setGroupId(groupId);
	}

	/**
	* Returns the sp cart package ID of this s p cart package item.
	*
	* @return the sp cart package ID of this s p cart package item
	*/
	@Override
	public long getSpCartPackageId() {
		return _spCartPackageItem.getSpCartPackageId();
	}

	/**
	* Sets the sp cart package ID of this s p cart package item.
	*
	* @param spCartPackageId the sp cart package ID of this s p cart package item
	*/
	@Override
	public void setSpCartPackageId(long spCartPackageId) {
		_spCartPackageItem.setSpCartPackageId(spCartPackageId);
	}

	/**
	* Returns the title of this s p cart package item.
	*
	* @return the title of this s p cart package item
	*/
	@Override
	public java.lang.String getTitle() {
		return _spCartPackageItem.getTitle();
	}

	/**
	* Sets the title of this s p cart package item.
	*
	* @param title the title of this s p cart package item
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_spCartPackageItem.setTitle(title);
	}

	/**
	* Returns the item code of this s p cart package item.
	*
	* @return the item code of this s p cart package item
	*/
	@Override
	public java.lang.String getItemCode() {
		return _spCartPackageItem.getItemCode();
	}

	/**
	* Sets the item code of this s p cart package item.
	*
	* @param itemCode the item code of this s p cart package item
	*/
	@Override
	public void setItemCode(java.lang.String itemCode) {
		_spCartPackageItem.setItemCode(itemCode);
	}

	/**
	* Returns the quantity of this s p cart package item.
	*
	* @return the quantity of this s p cart package item
	*/
	@Override
	public int getQuantity() {
		return _spCartPackageItem.getQuantity();
	}

	/**
	* Sets the quantity of this s p cart package item.
	*
	* @param quantity the quantity of this s p cart package item
	*/
	@Override
	public void setQuantity(int quantity) {
		_spCartPackageItem.setQuantity(quantity);
	}

	/**
	* Returns the entity class pk of this s p cart package item.
	*
	* @return the entity class pk of this s p cart package item
	*/
	@Override
	public long getEntityClassPk() {
		return _spCartPackageItem.getEntityClassPk();
	}

	/**
	* Sets the entity class pk of this s p cart package item.
	*
	* @param entityClassPk the entity class pk of this s p cart package item
	*/
	@Override
	public void setEntityClassPk(long entityClassPk) {
		_spCartPackageItem.setEntityClassPk(entityClassPk);
	}

	/**
	* Returns the entity class name of this s p cart package item.
	*
	* @return the entity class name of this s p cart package item
	*/
	@Override
	public java.lang.String getEntityClassName() {
		return _spCartPackageItem.getEntityClassName();
	}

	/**
	* Sets the entity class name of this s p cart package item.
	*
	* @param entityClassName the entity class name of this s p cart package item
	*/
	@Override
	public void setEntityClassName(java.lang.String entityClassName) {
		_spCartPackageItem.setEntityClassName(entityClassName);
	}

	/**
	* Returns the total price of this s p cart package item.
	*
	* @return the total price of this s p cart package item
	*/
	@Override
	public java.lang.String getTotalPrice() {
		return _spCartPackageItem.getTotalPrice();
	}

	/**
	* Sets the total price of this s p cart package item.
	*
	* @param totalPrice the total price of this s p cart package item
	*/
	@Override
	public void setTotalPrice(java.lang.String totalPrice) {
		_spCartPackageItem.setTotalPrice(totalPrice);
	}

	/**
	* Returns the company ID of this s p cart package item.
	*
	* @return the company ID of this s p cart package item
	*/
	@Override
	public long getCompanyId() {
		return _spCartPackageItem.getCompanyId();
	}

	/**
	* Sets the company ID of this s p cart package item.
	*
	* @param companyId the company ID of this s p cart package item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spCartPackageItem.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p cart package item.
	*
	* @return the user ID of this s p cart package item
	*/
	@Override
	public long getUserId() {
		return _spCartPackageItem.getUserId();
	}

	/**
	* Sets the user ID of this s p cart package item.
	*
	* @param userId the user ID of this s p cart package item
	*/
	@Override
	public void setUserId(long userId) {
		_spCartPackageItem.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p cart package item.
	*
	* @return the user uuid of this s p cart package item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCartPackageItem.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p cart package item.
	*
	* @param userUuid the user uuid of this s p cart package item
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spCartPackageItem.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p cart package item.
	*
	* @return the user name of this s p cart package item
	*/
	@Override
	public java.lang.String getUserName() {
		return _spCartPackageItem.getUserName();
	}

	/**
	* Sets the user name of this s p cart package item.
	*
	* @param userName the user name of this s p cart package item
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spCartPackageItem.setUserName(userName);
	}

	/**
	* Returns the create date of this s p cart package item.
	*
	* @return the create date of this s p cart package item
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spCartPackageItem.getCreateDate();
	}

	/**
	* Sets the create date of this s p cart package item.
	*
	* @param createDate the create date of this s p cart package item
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spCartPackageItem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p cart package item.
	*
	* @return the modified date of this s p cart package item
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spCartPackageItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p cart package item.
	*
	* @param modifiedDate the modified date of this s p cart package item
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spCartPackageItem.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spCartPackageItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spCartPackageItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spCartPackageItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spCartPackageItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spCartPackageItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spCartPackageItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spCartPackageItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spCartPackageItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spCartPackageItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spCartPackageItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spCartPackageItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPCartPackageItemWrapper((SPCartPackageItem)_spCartPackageItem.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spshopping.model.SPCartPackageItem spCartPackageItem) {
		return _spCartPackageItem.compareTo(spCartPackageItem);
	}

	@Override
	public int hashCode() {
		return _spCartPackageItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spshopping.model.SPCartPackageItem> toCacheModel() {
		return _spCartPackageItem.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPCartPackageItem toEscapedModel() {
		return new SPCartPackageItemWrapper(_spCartPackageItem.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPCartPackageItem toUnescapedModel() {
		return new SPCartPackageItemWrapper(_spCartPackageItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spCartPackageItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spCartPackageItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spCartPackageItem.persist();
	}

	@Override
	public java.math.BigDecimal getTotalPriceAmount() {
		return _spCartPackageItem.getTotalPriceAmount();
	}

	@Override
	public void setTotalPriceAmount(java.math.BigDecimal totalPrice) {
		_spCartPackageItem.setTotalPriceAmount(totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPCartPackageItemWrapper)) {
			return false;
		}

		SPCartPackageItemWrapper spCartPackageItemWrapper = (SPCartPackageItemWrapper)obj;

		if (Validator.equals(_spCartPackageItem,
					spCartPackageItemWrapper._spCartPackageItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPCartPackageItem getWrappedSPCartPackageItem() {
		return _spCartPackageItem;
	}

	@Override
	public SPCartPackageItem getWrappedModel() {
		return _spCartPackageItem;
	}

	@Override
	public void resetOriginalValues() {
		_spCartPackageItem.resetOriginalValues();
	}

	private SPCartPackageItem _spCartPackageItem;
}