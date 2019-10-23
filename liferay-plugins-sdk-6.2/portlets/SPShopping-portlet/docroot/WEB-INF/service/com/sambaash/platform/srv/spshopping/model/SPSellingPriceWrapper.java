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
 * This class is a wrapper for {@link SPSellingPrice}.
 * </p>
 *
 * @author pradeep
 * @see SPSellingPrice
 * @generated
 */
public class SPSellingPriceWrapper implements SPSellingPrice,
	ModelWrapper<SPSellingPrice> {
	public SPSellingPriceWrapper(SPSellingPrice spSellingPrice) {
		_spSellingPrice = spSellingPrice;
	}

	@Override
	public Class<?> getModelClass() {
		return SPSellingPrice.class;
	}

	@Override
	public String getModelClassName() {
		return SPSellingPrice.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spSellingPriceId", getSpSellingPriceId());
		attributes.put("groupId", getGroupId());
		attributes.put("priceRefId", getPriceRefId());
		attributes.put("priceRefTypeId", getPriceRefTypeId());
		attributes.put("currencyCode", getCurrencyCode());
		attributes.put("basePrice", getBasePrice());
		attributes.put("taxName", getTaxName());
		attributes.put("taxValue", getTaxValue());
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
		Long spSellingPriceId = (Long)attributes.get("spSellingPriceId");

		if (spSellingPriceId != null) {
			setSpSellingPriceId(spSellingPriceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long priceRefId = (Long)attributes.get("priceRefId");

		if (priceRefId != null) {
			setPriceRefId(priceRefId);
		}

		Long priceRefTypeId = (Long)attributes.get("priceRefTypeId");

		if (priceRefTypeId != null) {
			setPriceRefTypeId(priceRefTypeId);
		}

		String currencyCode = (String)attributes.get("currencyCode");

		if (currencyCode != null) {
			setCurrencyCode(currencyCode);
		}

		String basePrice = (String)attributes.get("basePrice");

		if (basePrice != null) {
			setBasePrice(basePrice);
		}

		String taxName = (String)attributes.get("taxName");

		if (taxName != null) {
			setTaxName(taxName);
		}

		String taxValue = (String)attributes.get("taxValue");

		if (taxValue != null) {
			setTaxValue(taxValue);
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
	* Returns the primary key of this s p selling price.
	*
	* @return the primary key of this s p selling price
	*/
	@Override
	public long getPrimaryKey() {
		return _spSellingPrice.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p selling price.
	*
	* @param primaryKey the primary key of this s p selling price
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spSellingPrice.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp selling price ID of this s p selling price.
	*
	* @return the sp selling price ID of this s p selling price
	*/
	@Override
	public long getSpSellingPriceId() {
		return _spSellingPrice.getSpSellingPriceId();
	}

	/**
	* Sets the sp selling price ID of this s p selling price.
	*
	* @param spSellingPriceId the sp selling price ID of this s p selling price
	*/
	@Override
	public void setSpSellingPriceId(long spSellingPriceId) {
		_spSellingPrice.setSpSellingPriceId(spSellingPriceId);
	}

	/**
	* Returns the group ID of this s p selling price.
	*
	* @return the group ID of this s p selling price
	*/
	@Override
	public long getGroupId() {
		return _spSellingPrice.getGroupId();
	}

	/**
	* Sets the group ID of this s p selling price.
	*
	* @param groupId the group ID of this s p selling price
	*/
	@Override
	public void setGroupId(long groupId) {
		_spSellingPrice.setGroupId(groupId);
	}

	/**
	* Returns the price ref ID of this s p selling price.
	*
	* @return the price ref ID of this s p selling price
	*/
	@Override
	public long getPriceRefId() {
		return _spSellingPrice.getPriceRefId();
	}

	/**
	* Sets the price ref ID of this s p selling price.
	*
	* @param priceRefId the price ref ID of this s p selling price
	*/
	@Override
	public void setPriceRefId(long priceRefId) {
		_spSellingPrice.setPriceRefId(priceRefId);
	}

	/**
	* Returns the price ref type ID of this s p selling price.
	*
	* @return the price ref type ID of this s p selling price
	*/
	@Override
	public long getPriceRefTypeId() {
		return _spSellingPrice.getPriceRefTypeId();
	}

	/**
	* Sets the price ref type ID of this s p selling price.
	*
	* @param priceRefTypeId the price ref type ID of this s p selling price
	*/
	@Override
	public void setPriceRefTypeId(long priceRefTypeId) {
		_spSellingPrice.setPriceRefTypeId(priceRefTypeId);
	}

	/**
	* Returns the currency code of this s p selling price.
	*
	* @return the currency code of this s p selling price
	*/
	@Override
	public java.lang.String getCurrencyCode() {
		return _spSellingPrice.getCurrencyCode();
	}

	/**
	* Sets the currency code of this s p selling price.
	*
	* @param currencyCode the currency code of this s p selling price
	*/
	@Override
	public void setCurrencyCode(java.lang.String currencyCode) {
		_spSellingPrice.setCurrencyCode(currencyCode);
	}

	/**
	* Returns the base price of this s p selling price.
	*
	* @return the base price of this s p selling price
	*/
	@Override
	public java.lang.String getBasePrice() {
		return _spSellingPrice.getBasePrice();
	}

	/**
	* Sets the base price of this s p selling price.
	*
	* @param basePrice the base price of this s p selling price
	*/
	@Override
	public void setBasePrice(java.lang.String basePrice) {
		_spSellingPrice.setBasePrice(basePrice);
	}

	/**
	* Returns the tax name of this s p selling price.
	*
	* @return the tax name of this s p selling price
	*/
	@Override
	public java.lang.String getTaxName() {
		return _spSellingPrice.getTaxName();
	}

	/**
	* Sets the tax name of this s p selling price.
	*
	* @param taxName the tax name of this s p selling price
	*/
	@Override
	public void setTaxName(java.lang.String taxName) {
		_spSellingPrice.setTaxName(taxName);
	}

	/**
	* Returns the tax value of this s p selling price.
	*
	* @return the tax value of this s p selling price
	*/
	@Override
	public java.lang.String getTaxValue() {
		return _spSellingPrice.getTaxValue();
	}

	/**
	* Sets the tax value of this s p selling price.
	*
	* @param taxValue the tax value of this s p selling price
	*/
	@Override
	public void setTaxValue(java.lang.String taxValue) {
		_spSellingPrice.setTaxValue(taxValue);
	}

	/**
	* Returns the total price of this s p selling price.
	*
	* @return the total price of this s p selling price
	*/
	@Override
	public java.lang.String getTotalPrice() {
		return _spSellingPrice.getTotalPrice();
	}

	/**
	* Sets the total price of this s p selling price.
	*
	* @param totalPrice the total price of this s p selling price
	*/
	@Override
	public void setTotalPrice(java.lang.String totalPrice) {
		_spSellingPrice.setTotalPrice(totalPrice);
	}

	/**
	* Returns the company ID of this s p selling price.
	*
	* @return the company ID of this s p selling price
	*/
	@Override
	public long getCompanyId() {
		return _spSellingPrice.getCompanyId();
	}

	/**
	* Sets the company ID of this s p selling price.
	*
	* @param companyId the company ID of this s p selling price
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spSellingPrice.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p selling price.
	*
	* @return the user ID of this s p selling price
	*/
	@Override
	public long getUserId() {
		return _spSellingPrice.getUserId();
	}

	/**
	* Sets the user ID of this s p selling price.
	*
	* @param userId the user ID of this s p selling price
	*/
	@Override
	public void setUserId(long userId) {
		_spSellingPrice.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p selling price.
	*
	* @return the user uuid of this s p selling price
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPrice.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p selling price.
	*
	* @param userUuid the user uuid of this s p selling price
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spSellingPrice.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p selling price.
	*
	* @return the user name of this s p selling price
	*/
	@Override
	public java.lang.String getUserName() {
		return _spSellingPrice.getUserName();
	}

	/**
	* Sets the user name of this s p selling price.
	*
	* @param userName the user name of this s p selling price
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spSellingPrice.setUserName(userName);
	}

	/**
	* Returns the create date of this s p selling price.
	*
	* @return the create date of this s p selling price
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spSellingPrice.getCreateDate();
	}

	/**
	* Sets the create date of this s p selling price.
	*
	* @param createDate the create date of this s p selling price
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spSellingPrice.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p selling price.
	*
	* @return the modified date of this s p selling price
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spSellingPrice.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p selling price.
	*
	* @param modifiedDate the modified date of this s p selling price
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spSellingPrice.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spSellingPrice.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spSellingPrice.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spSellingPrice.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spSellingPrice.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spSellingPrice.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spSellingPrice.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spSellingPrice.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spSellingPrice.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spSellingPrice.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spSellingPrice.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spSellingPrice.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPSellingPriceWrapper((SPSellingPrice)_spSellingPrice.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice) {
		return _spSellingPrice.compareTo(spSellingPrice);
	}

	@Override
	public int hashCode() {
		return _spSellingPrice.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> toCacheModel() {
		return _spSellingPrice.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice toEscapedModel() {
		return new SPSellingPriceWrapper(_spSellingPrice.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice toUnescapedModel() {
		return new SPSellingPriceWrapper(_spSellingPrice.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spSellingPrice.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spSellingPrice.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spSellingPrice.persist();
	}

	@Override
	public java.math.BigDecimal getBasePriceAmount() {
		return _spSellingPrice.getBasePriceAmount();
	}

	@Override
	public void setBasePriceAmount(java.math.BigDecimal basePriceAmount) {
		_spSellingPrice.setBasePriceAmount(basePriceAmount);
	}

	@Override
	public java.math.BigDecimal getTaxValueAmount() {
		return _spSellingPrice.getTaxValueAmount();
	}

	@Override
	public void setTaxValueAmount(java.lang.String taxValueAmount) {
		_spSellingPrice.setTaxValueAmount(taxValueAmount);
	}

	@Override
	public java.math.BigDecimal getTotalPriceAmount() {
		return _spSellingPrice.getTotalPriceAmount();
	}

	@Override
	public void setTotalPriceAmount(java.math.BigDecimal totalPriceAmount) {
		_spSellingPrice.setTotalPriceAmount(totalPriceAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPSellingPriceWrapper)) {
			return false;
		}

		SPSellingPriceWrapper spSellingPriceWrapper = (SPSellingPriceWrapper)obj;

		if (Validator.equals(_spSellingPrice,
					spSellingPriceWrapper._spSellingPrice)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPSellingPrice getWrappedSPSellingPrice() {
		return _spSellingPrice;
	}

	@Override
	public SPSellingPrice getWrappedModel() {
		return _spSellingPrice;
	}

	@Override
	public void resetOriginalValues() {
		_spSellingPrice.resetOriginalValues();
	}

	private SPSellingPrice _spSellingPrice;
}