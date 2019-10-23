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
 * This class is a wrapper for {@link SPDiscount}.
 * </p>
 *
 * @author pradeep
 * @see SPDiscount
 * @generated
 */
public class SPDiscountWrapper implements SPDiscount, ModelWrapper<SPDiscount> {
	public SPDiscountWrapper(SPDiscount spDiscount) {
		_spDiscount = spDiscount;
	}

	@Override
	public Class<?> getModelClass() {
		return SPDiscount.class;
	}

	@Override
	public String getModelClassName() {
		return SPDiscount.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spDiscountId", getSpDiscountId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("percent", getPercent());
		attributes.put("packageId", getPackageId());
		attributes.put("value", getValue());
		attributes.put("couponCode", getCouponCode());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("minQuantity", getMinQuantity());
		attributes.put("maxQuantity", getMaxQuantity());
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
		Long spDiscountId = (Long)attributes.get("spDiscountId");

		if (spDiscountId != null) {
			setSpDiscountId(spDiscountId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Boolean percent = (Boolean)attributes.get("percent");

		if (percent != null) {
			setPercent(percent);
		}

		Long packageId = (Long)attributes.get("packageId");

		if (packageId != null) {
			setPackageId(packageId);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String couponCode = (String)attributes.get("couponCode");

		if (couponCode != null) {
			setCouponCode(couponCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer minQuantity = (Integer)attributes.get("minQuantity");

		if (minQuantity != null) {
			setMinQuantity(minQuantity);
		}

		Integer maxQuantity = (Integer)attributes.get("maxQuantity");

		if (maxQuantity != null) {
			setMaxQuantity(maxQuantity);
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
	* Returns the primary key of this s p discount.
	*
	* @return the primary key of this s p discount
	*/
	@Override
	public long getPrimaryKey() {
		return _spDiscount.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p discount.
	*
	* @param primaryKey the primary key of this s p discount
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spDiscount.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp discount ID of this s p discount.
	*
	* @return the sp discount ID of this s p discount
	*/
	@Override
	public long getSpDiscountId() {
		return _spDiscount.getSpDiscountId();
	}

	/**
	* Sets the sp discount ID of this s p discount.
	*
	* @param spDiscountId the sp discount ID of this s p discount
	*/
	@Override
	public void setSpDiscountId(long spDiscountId) {
		_spDiscount.setSpDiscountId(spDiscountId);
	}

	/**
	* Returns the group ID of this s p discount.
	*
	* @return the group ID of this s p discount
	*/
	@Override
	public long getGroupId() {
		return _spDiscount.getGroupId();
	}

	/**
	* Sets the group ID of this s p discount.
	*
	* @param groupId the group ID of this s p discount
	*/
	@Override
	public void setGroupId(long groupId) {
		_spDiscount.setGroupId(groupId);
	}

	/**
	* Returns the title of this s p discount.
	*
	* @return the title of this s p discount
	*/
	@Override
	public java.lang.String getTitle() {
		return _spDiscount.getTitle();
	}

	/**
	* Sets the title of this s p discount.
	*
	* @param title the title of this s p discount
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_spDiscount.setTitle(title);
	}

	/**
	* Returns the percent of this s p discount.
	*
	* @return the percent of this s p discount
	*/
	@Override
	public boolean getPercent() {
		return _spDiscount.getPercent();
	}

	/**
	* Returns <code>true</code> if this s p discount is percent.
	*
	* @return <code>true</code> if this s p discount is percent; <code>false</code> otherwise
	*/
	@Override
	public boolean isPercent() {
		return _spDiscount.isPercent();
	}

	/**
	* Sets whether this s p discount is percent.
	*
	* @param percent the percent of this s p discount
	*/
	@Override
	public void setPercent(boolean percent) {
		_spDiscount.setPercent(percent);
	}

	/**
	* Returns the package ID of this s p discount.
	*
	* @return the package ID of this s p discount
	*/
	@Override
	public long getPackageId() {
		return _spDiscount.getPackageId();
	}

	/**
	* Sets the package ID of this s p discount.
	*
	* @param packageId the package ID of this s p discount
	*/
	@Override
	public void setPackageId(long packageId) {
		_spDiscount.setPackageId(packageId);
	}

	/**
	* Returns the value of this s p discount.
	*
	* @return the value of this s p discount
	*/
	@Override
	public java.lang.String getValue() {
		return _spDiscount.getValue();
	}

	/**
	* Sets the value of this s p discount.
	*
	* @param value the value of this s p discount
	*/
	@Override
	public void setValue(java.lang.String value) {
		_spDiscount.setValue(value);
	}

	/**
	* Returns the coupon code of this s p discount.
	*
	* @return the coupon code of this s p discount
	*/
	@Override
	public java.lang.String getCouponCode() {
		return _spDiscount.getCouponCode();
	}

	/**
	* Sets the coupon code of this s p discount.
	*
	* @param couponCode the coupon code of this s p discount
	*/
	@Override
	public void setCouponCode(java.lang.String couponCode) {
		_spDiscount.setCouponCode(couponCode);
	}

	/**
	* Returns the description of this s p discount.
	*
	* @return the description of this s p discount
	*/
	@Override
	public java.lang.String getDescription() {
		return _spDiscount.getDescription();
	}

	/**
	* Sets the description of this s p discount.
	*
	* @param description the description of this s p discount
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_spDiscount.setDescription(description);
	}

	/**
	* Returns the start date of this s p discount.
	*
	* @return the start date of this s p discount
	*/
	@Override
	public java.util.Date getStartDate() {
		return _spDiscount.getStartDate();
	}

	/**
	* Sets the start date of this s p discount.
	*
	* @param startDate the start date of this s p discount
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_spDiscount.setStartDate(startDate);
	}

	/**
	* Returns the end date of this s p discount.
	*
	* @return the end date of this s p discount
	*/
	@Override
	public java.util.Date getEndDate() {
		return _spDiscount.getEndDate();
	}

	/**
	* Sets the end date of this s p discount.
	*
	* @param endDate the end date of this s p discount
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_spDiscount.setEndDate(endDate);
	}

	/**
	* Returns the min quantity of this s p discount.
	*
	* @return the min quantity of this s p discount
	*/
	@Override
	public int getMinQuantity() {
		return _spDiscount.getMinQuantity();
	}

	/**
	* Sets the min quantity of this s p discount.
	*
	* @param minQuantity the min quantity of this s p discount
	*/
	@Override
	public void setMinQuantity(int minQuantity) {
		_spDiscount.setMinQuantity(minQuantity);
	}

	/**
	* Returns the max quantity of this s p discount.
	*
	* @return the max quantity of this s p discount
	*/
	@Override
	public int getMaxQuantity() {
		return _spDiscount.getMaxQuantity();
	}

	/**
	* Sets the max quantity of this s p discount.
	*
	* @param maxQuantity the max quantity of this s p discount
	*/
	@Override
	public void setMaxQuantity(int maxQuantity) {
		_spDiscount.setMaxQuantity(maxQuantity);
	}

	/**
	* Returns the active of this s p discount.
	*
	* @return the active of this s p discount
	*/
	@Override
	public boolean getActive() {
		return _spDiscount.getActive();
	}

	/**
	* Returns <code>true</code> if this s p discount is active.
	*
	* @return <code>true</code> if this s p discount is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _spDiscount.isActive();
	}

	/**
	* Sets whether this s p discount is active.
	*
	* @param active the active of this s p discount
	*/
	@Override
	public void setActive(boolean active) {
		_spDiscount.setActive(active);
	}

	/**
	* Returns the company ID of this s p discount.
	*
	* @return the company ID of this s p discount
	*/
	@Override
	public long getCompanyId() {
		return _spDiscount.getCompanyId();
	}

	/**
	* Sets the company ID of this s p discount.
	*
	* @param companyId the company ID of this s p discount
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spDiscount.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p discount.
	*
	* @return the user ID of this s p discount
	*/
	@Override
	public long getUserId() {
		return _spDiscount.getUserId();
	}

	/**
	* Sets the user ID of this s p discount.
	*
	* @param userId the user ID of this s p discount
	*/
	@Override
	public void setUserId(long userId) {
		_spDiscount.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p discount.
	*
	* @return the user uuid of this s p discount
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDiscount.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p discount.
	*
	* @param userUuid the user uuid of this s p discount
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spDiscount.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p discount.
	*
	* @return the user name of this s p discount
	*/
	@Override
	public java.lang.String getUserName() {
		return _spDiscount.getUserName();
	}

	/**
	* Sets the user name of this s p discount.
	*
	* @param userName the user name of this s p discount
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spDiscount.setUserName(userName);
	}

	/**
	* Returns the create date of this s p discount.
	*
	* @return the create date of this s p discount
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spDiscount.getCreateDate();
	}

	/**
	* Sets the create date of this s p discount.
	*
	* @param createDate the create date of this s p discount
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spDiscount.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p discount.
	*
	* @return the modified date of this s p discount
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spDiscount.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p discount.
	*
	* @param modifiedDate the modified date of this s p discount
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spDiscount.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spDiscount.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spDiscount.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spDiscount.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spDiscount.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spDiscount.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spDiscount.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spDiscount.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spDiscount.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spDiscount.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spDiscount.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spDiscount.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPDiscountWrapper((SPDiscount)_spDiscount.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spshopping.model.SPDiscount spDiscount) {
		return _spDiscount.compareTo(spDiscount);
	}

	@Override
	public int hashCode() {
		return _spDiscount.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spshopping.model.SPDiscount> toCacheModel() {
		return _spDiscount.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount toEscapedModel() {
		return new SPDiscountWrapper(_spDiscount.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount toUnescapedModel() {
		return new SPDiscountWrapper(_spDiscount.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spDiscount.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spDiscount.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spDiscount.persist();
	}

	@Override
	public java.math.BigDecimal getValueAmount() {
		return _spDiscount.getValueAmount();
	}

	@Override
	public void setValue(java.math.BigDecimal valueAmount) {
		_spDiscount.setValue(valueAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPDiscountWrapper)) {
			return false;
		}

		SPDiscountWrapper spDiscountWrapper = (SPDiscountWrapper)obj;

		if (Validator.equals(_spDiscount, spDiscountWrapper._spDiscount)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPDiscount getWrappedSPDiscount() {
		return _spDiscount;
	}

	@Override
	public SPDiscount getWrappedModel() {
		return _spDiscount;
	}

	@Override
	public void resetOriginalValues() {
		_spDiscount.resetOriginalValues();
	}

	private SPDiscount _spDiscount;
}