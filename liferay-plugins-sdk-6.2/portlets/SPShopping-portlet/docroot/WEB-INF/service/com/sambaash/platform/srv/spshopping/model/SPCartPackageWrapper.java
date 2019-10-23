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
 * This class is a wrapper for {@link SPCartPackage}.
 * </p>
 *
 * @author pradeep
 * @see SPCartPackage
 * @generated
 */
public class SPCartPackageWrapper implements SPCartPackage,
	ModelWrapper<SPCartPackage> {
	public SPCartPackageWrapper(SPCartPackage spCartPackage) {
		_spCartPackage = spCartPackage;
	}

	@Override
	public Class<?> getModelClass() {
		return SPCartPackage.class;
	}

	@Override
	public String getModelClassName() {
		return SPCartPackage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCartPackageId", getSpCartPackageId());
		attributes.put("groupId", getGroupId());
		attributes.put("cartId", getCartId());
		attributes.put("packageId", getPackageId());
		attributes.put("selectedCurrency", getSelectedCurrency());
		attributes.put("usedDiscountRefId", getUsedDiscountRefId());
		attributes.put("usedDiscountRefPCId", getUsedDiscountRefPCId());
		attributes.put("discount", getDiscount());
		attributes.put("initialPrice", getInitialPrice());
		attributes.put("totalPrice", getTotalPrice());
		attributes.put("remarks", getRemarks());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCartPackageId = (Long)attributes.get("spCartPackageId");

		if (spCartPackageId != null) {
			setSpCartPackageId(spCartPackageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		Long packageId = (Long)attributes.get("packageId");

		if (packageId != null) {
			setPackageId(packageId);
		}

		String selectedCurrency = (String)attributes.get("selectedCurrency");

		if (selectedCurrency != null) {
			setSelectedCurrency(selectedCurrency);
		}

		Long usedDiscountRefId = (Long)attributes.get("usedDiscountRefId");

		if (usedDiscountRefId != null) {
			setUsedDiscountRefId(usedDiscountRefId);
		}

		Long usedDiscountRefPCId = (Long)attributes.get("usedDiscountRefPCId");

		if (usedDiscountRefPCId != null) {
			setUsedDiscountRefPCId(usedDiscountRefPCId);
		}

		String discount = (String)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		String initialPrice = (String)attributes.get("initialPrice");

		if (initialPrice != null) {
			setInitialPrice(initialPrice);
		}

		String totalPrice = (String)attributes.get("totalPrice");

		if (totalPrice != null) {
			setTotalPrice(totalPrice);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
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
	* Returns the primary key of this s p cart package.
	*
	* @return the primary key of this s p cart package
	*/
	@Override
	public long getPrimaryKey() {
		return _spCartPackage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p cart package.
	*
	* @param primaryKey the primary key of this s p cart package
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spCartPackage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp cart package ID of this s p cart package.
	*
	* @return the sp cart package ID of this s p cart package
	*/
	@Override
	public long getSpCartPackageId() {
		return _spCartPackage.getSpCartPackageId();
	}

	/**
	* Sets the sp cart package ID of this s p cart package.
	*
	* @param spCartPackageId the sp cart package ID of this s p cart package
	*/
	@Override
	public void setSpCartPackageId(long spCartPackageId) {
		_spCartPackage.setSpCartPackageId(spCartPackageId);
	}

	/**
	* Returns the group ID of this s p cart package.
	*
	* @return the group ID of this s p cart package
	*/
	@Override
	public long getGroupId() {
		return _spCartPackage.getGroupId();
	}

	/**
	* Sets the group ID of this s p cart package.
	*
	* @param groupId the group ID of this s p cart package
	*/
	@Override
	public void setGroupId(long groupId) {
		_spCartPackage.setGroupId(groupId);
	}

	/**
	* Returns the cart ID of this s p cart package.
	*
	* @return the cart ID of this s p cart package
	*/
	@Override
	public long getCartId() {
		return _spCartPackage.getCartId();
	}

	/**
	* Sets the cart ID of this s p cart package.
	*
	* @param cartId the cart ID of this s p cart package
	*/
	@Override
	public void setCartId(long cartId) {
		_spCartPackage.setCartId(cartId);
	}

	/**
	* Returns the package ID of this s p cart package.
	*
	* @return the package ID of this s p cart package
	*/
	@Override
	public long getPackageId() {
		return _spCartPackage.getPackageId();
	}

	/**
	* Sets the package ID of this s p cart package.
	*
	* @param packageId the package ID of this s p cart package
	*/
	@Override
	public void setPackageId(long packageId) {
		_spCartPackage.setPackageId(packageId);
	}

	/**
	* Returns the selected currency of this s p cart package.
	*
	* @return the selected currency of this s p cart package
	*/
	@Override
	public java.lang.String getSelectedCurrency() {
		return _spCartPackage.getSelectedCurrency();
	}

	/**
	* Sets the selected currency of this s p cart package.
	*
	* @param selectedCurrency the selected currency of this s p cart package
	*/
	@Override
	public void setSelectedCurrency(java.lang.String selectedCurrency) {
		_spCartPackage.setSelectedCurrency(selectedCurrency);
	}

	/**
	* Returns the used discount ref ID of this s p cart package.
	*
	* @return the used discount ref ID of this s p cart package
	*/
	@Override
	public long getUsedDiscountRefId() {
		return _spCartPackage.getUsedDiscountRefId();
	}

	/**
	* Sets the used discount ref ID of this s p cart package.
	*
	* @param usedDiscountRefId the used discount ref ID of this s p cart package
	*/
	@Override
	public void setUsedDiscountRefId(long usedDiscountRefId) {
		_spCartPackage.setUsedDiscountRefId(usedDiscountRefId);
	}

	/**
	* Returns the used discount ref p c ID of this s p cart package.
	*
	* @return the used discount ref p c ID of this s p cart package
	*/
	@Override
	public long getUsedDiscountRefPCId() {
		return _spCartPackage.getUsedDiscountRefPCId();
	}

	/**
	* Sets the used discount ref p c ID of this s p cart package.
	*
	* @param usedDiscountRefPCId the used discount ref p c ID of this s p cart package
	*/
	@Override
	public void setUsedDiscountRefPCId(long usedDiscountRefPCId) {
		_spCartPackage.setUsedDiscountRefPCId(usedDiscountRefPCId);
	}

	/**
	* Returns the discount of this s p cart package.
	*
	* @return the discount of this s p cart package
	*/
	@Override
	public java.lang.String getDiscount() {
		return _spCartPackage.getDiscount();
	}

	/**
	* Sets the discount of this s p cart package.
	*
	* @param discount the discount of this s p cart package
	*/
	@Override
	public void setDiscount(java.lang.String discount) {
		_spCartPackage.setDiscount(discount);
	}

	/**
	* Returns the initial price of this s p cart package.
	*
	* @return the initial price of this s p cart package
	*/
	@Override
	public java.lang.String getInitialPrice() {
		return _spCartPackage.getInitialPrice();
	}

	/**
	* Sets the initial price of this s p cart package.
	*
	* @param initialPrice the initial price of this s p cart package
	*/
	@Override
	public void setInitialPrice(java.lang.String initialPrice) {
		_spCartPackage.setInitialPrice(initialPrice);
	}

	/**
	* Returns the total price of this s p cart package.
	*
	* @return the total price of this s p cart package
	*/
	@Override
	public java.lang.String getTotalPrice() {
		return _spCartPackage.getTotalPrice();
	}

	/**
	* Sets the total price of this s p cart package.
	*
	* @param totalPrice the total price of this s p cart package
	*/
	@Override
	public void setTotalPrice(java.lang.String totalPrice) {
		_spCartPackage.setTotalPrice(totalPrice);
	}

	/**
	* Returns the remarks of this s p cart package.
	*
	* @return the remarks of this s p cart package
	*/
	@Override
	public java.lang.String getRemarks() {
		return _spCartPackage.getRemarks();
	}

	/**
	* Sets the remarks of this s p cart package.
	*
	* @param remarks the remarks of this s p cart package
	*/
	@Override
	public void setRemarks(java.lang.String remarks) {
		_spCartPackage.setRemarks(remarks);
	}

	/**
	* Returns the company ID of this s p cart package.
	*
	* @return the company ID of this s p cart package
	*/
	@Override
	public long getCompanyId() {
		return _spCartPackage.getCompanyId();
	}

	/**
	* Sets the company ID of this s p cart package.
	*
	* @param companyId the company ID of this s p cart package
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spCartPackage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p cart package.
	*
	* @return the user ID of this s p cart package
	*/
	@Override
	public long getUserId() {
		return _spCartPackage.getUserId();
	}

	/**
	* Sets the user ID of this s p cart package.
	*
	* @param userId the user ID of this s p cart package
	*/
	@Override
	public void setUserId(long userId) {
		_spCartPackage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p cart package.
	*
	* @return the user uuid of this s p cart package
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCartPackage.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p cart package.
	*
	* @param userUuid the user uuid of this s p cart package
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spCartPackage.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p cart package.
	*
	* @return the user name of this s p cart package
	*/
	@Override
	public java.lang.String getUserName() {
		return _spCartPackage.getUserName();
	}

	/**
	* Sets the user name of this s p cart package.
	*
	* @param userName the user name of this s p cart package
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spCartPackage.setUserName(userName);
	}

	/**
	* Returns the create date of this s p cart package.
	*
	* @return the create date of this s p cart package
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spCartPackage.getCreateDate();
	}

	/**
	* Sets the create date of this s p cart package.
	*
	* @param createDate the create date of this s p cart package
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spCartPackage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p cart package.
	*
	* @return the modified date of this s p cart package
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spCartPackage.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p cart package.
	*
	* @param modifiedDate the modified date of this s p cart package
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spCartPackage.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spCartPackage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spCartPackage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spCartPackage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spCartPackage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spCartPackage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spCartPackage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spCartPackage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spCartPackage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spCartPackage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spCartPackage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spCartPackage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPCartPackageWrapper((SPCartPackage)_spCartPackage.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spshopping.model.SPCartPackage spCartPackage) {
		return _spCartPackage.compareTo(spCartPackage);
	}

	@Override
	public int hashCode() {
		return _spCartPackage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spshopping.model.SPCartPackage> toCacheModel() {
		return _spCartPackage.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage toEscapedModel() {
		return new SPCartPackageWrapper(_spCartPackage.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPCartPackage toUnescapedModel() {
		return new SPCartPackageWrapper(_spCartPackage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spCartPackage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spCartPackage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spCartPackage.persist();
	}

	@Override
	public java.math.BigDecimal getInitialPriceAmount() {
		return _spCartPackage.getInitialPriceAmount();
	}

	@Override
	public void setInitialPriceAmount(java.math.BigDecimal initialPriceAmount) {
		_spCartPackage.setInitialPriceAmount(initialPriceAmount);
	}

	@Override
	public java.math.BigDecimal getTotalPriceAmount() {
		return _spCartPackage.getTotalPriceAmount();
	}

	@Override
	public void setTotalPriceAmount(java.math.BigDecimal totalPriceAmount) {
		_spCartPackage.setTotalPriceAmount(totalPriceAmount);
	}

	@Override
	public java.math.BigDecimal getDiscountAmount() {
		return _spCartPackage.getDiscountAmount();
	}

	@Override
	public void setDiscountAmount(java.math.BigDecimal discount) {
		_spCartPackage.setDiscountAmount(discount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPCartPackageWrapper)) {
			return false;
		}

		SPCartPackageWrapper spCartPackageWrapper = (SPCartPackageWrapper)obj;

		if (Validator.equals(_spCartPackage, spCartPackageWrapper._spCartPackage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPCartPackage getWrappedSPCartPackage() {
		return _spCartPackage;
	}

	@Override
	public SPCartPackage getWrappedModel() {
		return _spCartPackage;
	}

	@Override
	public void resetOriginalValues() {
		_spCartPackage.resetOriginalValues();
	}

	private SPCartPackage _spCartPackage;
}