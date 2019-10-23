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
 * This class is a wrapper for {@link SPCart}.
 * </p>
 *
 * @author pradeep
 * @see SPCart
 * @generated
 */
public class SPCartWrapper implements SPCart, ModelWrapper<SPCart> {
	public SPCartWrapper(SPCart spCart) {
		_spCart = spCart;
	}

	@Override
	public Class<?> getModelClass() {
		return SPCart.class;
	}

	@Override
	public String getModelClassName() {
		return SPCart.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCartId", getSpCartId());
		attributes.put("groupId", getGroupId());
		attributes.put("discount", getDiscount());
		attributes.put("totalPrice", getTotalPrice());
		attributes.put("userRemarks", getUserRemarks());
		attributes.put("status", getStatus());
		attributes.put("transactionDetails", getTransactionDetails());
		attributes.put("orderPage", getOrderPage());
		attributes.put("rsvpDetailId", getRsvpDetailId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCartId = (Long)attributes.get("spCartId");

		if (spCartId != null) {
			setSpCartId(spCartId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String discount = (String)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		String totalPrice = (String)attributes.get("totalPrice");

		if (totalPrice != null) {
			setTotalPrice(totalPrice);
		}

		String userRemarks = (String)attributes.get("userRemarks");

		if (userRemarks != null) {
			setUserRemarks(userRemarks);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String transactionDetails = (String)attributes.get("transactionDetails");

		if (transactionDetails != null) {
			setTransactionDetails(transactionDetails);
		}

		String orderPage = (String)attributes.get("orderPage");

		if (orderPage != null) {
			setOrderPage(orderPage);
		}

		Long rsvpDetailId = (Long)attributes.get("rsvpDetailId");

		if (rsvpDetailId != null) {
			setRsvpDetailId(rsvpDetailId);
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
	* Returns the primary key of this s p cart.
	*
	* @return the primary key of this s p cart
	*/
	@Override
	public long getPrimaryKey() {
		return _spCart.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p cart.
	*
	* @param primaryKey the primary key of this s p cart
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spCart.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp cart ID of this s p cart.
	*
	* @return the sp cart ID of this s p cart
	*/
	@Override
	public long getSpCartId() {
		return _spCart.getSpCartId();
	}

	/**
	* Sets the sp cart ID of this s p cart.
	*
	* @param spCartId the sp cart ID of this s p cart
	*/
	@Override
	public void setSpCartId(long spCartId) {
		_spCart.setSpCartId(spCartId);
	}

	/**
	* Returns the group ID of this s p cart.
	*
	* @return the group ID of this s p cart
	*/
	@Override
	public long getGroupId() {
		return _spCart.getGroupId();
	}

	/**
	* Sets the group ID of this s p cart.
	*
	* @param groupId the group ID of this s p cart
	*/
	@Override
	public void setGroupId(long groupId) {
		_spCart.setGroupId(groupId);
	}

	/**
	* Returns the discount of this s p cart.
	*
	* @return the discount of this s p cart
	*/
	@Override
	public java.lang.String getDiscount() {
		return _spCart.getDiscount();
	}

	/**
	* Sets the discount of this s p cart.
	*
	* @param discount the discount of this s p cart
	*/
	@Override
	public void setDiscount(java.lang.String discount) {
		_spCart.setDiscount(discount);
	}

	/**
	* Returns the total price of this s p cart.
	*
	* @return the total price of this s p cart
	*/
	@Override
	public java.lang.String getTotalPrice() {
		return _spCart.getTotalPrice();
	}

	/**
	* Sets the total price of this s p cart.
	*
	* @param totalPrice the total price of this s p cart
	*/
	@Override
	public void setTotalPrice(java.lang.String totalPrice) {
		_spCart.setTotalPrice(totalPrice);
	}

	/**
	* Returns the user remarks of this s p cart.
	*
	* @return the user remarks of this s p cart
	*/
	@Override
	public java.lang.String getUserRemarks() {
		return _spCart.getUserRemarks();
	}

	/**
	* Sets the user remarks of this s p cart.
	*
	* @param userRemarks the user remarks of this s p cart
	*/
	@Override
	public void setUserRemarks(java.lang.String userRemarks) {
		_spCart.setUserRemarks(userRemarks);
	}

	/**
	* Returns the status of this s p cart.
	*
	* @return the status of this s p cart
	*/
	@Override
	public int getStatus() {
		return _spCart.getStatus();
	}

	/**
	* Sets the status of this s p cart.
	*
	* @param status the status of this s p cart
	*/
	@Override
	public void setStatus(int status) {
		_spCart.setStatus(status);
	}

	/**
	* Returns the transaction details of this s p cart.
	*
	* @return the transaction details of this s p cart
	*/
	@Override
	public java.lang.String getTransactionDetails() {
		return _spCart.getTransactionDetails();
	}

	/**
	* Sets the transaction details of this s p cart.
	*
	* @param transactionDetails the transaction details of this s p cart
	*/
	@Override
	public void setTransactionDetails(java.lang.String transactionDetails) {
		_spCart.setTransactionDetails(transactionDetails);
	}

	/**
	* Returns the order page of this s p cart.
	*
	* @return the order page of this s p cart
	*/
	@Override
	public java.lang.String getOrderPage() {
		return _spCart.getOrderPage();
	}

	/**
	* Sets the order page of this s p cart.
	*
	* @param orderPage the order page of this s p cart
	*/
	@Override
	public void setOrderPage(java.lang.String orderPage) {
		_spCart.setOrderPage(orderPage);
	}

	/**
	* Returns the rsvp detail ID of this s p cart.
	*
	* @return the rsvp detail ID of this s p cart
	*/
	@Override
	public long getRsvpDetailId() {
		return _spCart.getRsvpDetailId();
	}

	/**
	* Sets the rsvp detail ID of this s p cart.
	*
	* @param rsvpDetailId the rsvp detail ID of this s p cart
	*/
	@Override
	public void setRsvpDetailId(long rsvpDetailId) {
		_spCart.setRsvpDetailId(rsvpDetailId);
	}

	/**
	* Returns the company ID of this s p cart.
	*
	* @return the company ID of this s p cart
	*/
	@Override
	public long getCompanyId() {
		return _spCart.getCompanyId();
	}

	/**
	* Sets the company ID of this s p cart.
	*
	* @param companyId the company ID of this s p cart
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spCart.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p cart.
	*
	* @return the user ID of this s p cart
	*/
	@Override
	public long getUserId() {
		return _spCart.getUserId();
	}

	/**
	* Sets the user ID of this s p cart.
	*
	* @param userId the user ID of this s p cart
	*/
	@Override
	public void setUserId(long userId) {
		_spCart.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p cart.
	*
	* @return the user uuid of this s p cart
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCart.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p cart.
	*
	* @param userUuid the user uuid of this s p cart
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spCart.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p cart.
	*
	* @return the user name of this s p cart
	*/
	@Override
	public java.lang.String getUserName() {
		return _spCart.getUserName();
	}

	/**
	* Sets the user name of this s p cart.
	*
	* @param userName the user name of this s p cart
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spCart.setUserName(userName);
	}

	/**
	* Returns the create date of this s p cart.
	*
	* @return the create date of this s p cart
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spCart.getCreateDate();
	}

	/**
	* Sets the create date of this s p cart.
	*
	* @param createDate the create date of this s p cart
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spCart.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p cart.
	*
	* @return the modified date of this s p cart
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spCart.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p cart.
	*
	* @param modifiedDate the modified date of this s p cart
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spCart.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spCart.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spCart.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spCart.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spCart.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spCart.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spCart.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spCart.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spCart.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spCart.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spCart.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spCart.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPCartWrapper((SPCart)_spCart.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spshopping.model.SPCart spCart) {
		return _spCart.compareTo(spCart);
	}

	@Override
	public int hashCode() {
		return _spCart.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spshopping.model.SPCart> toCacheModel() {
		return _spCart.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPCart toEscapedModel() {
		return new SPCartWrapper(_spCart.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPCart toUnescapedModel() {
		return new SPCartWrapper(_spCart.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spCart.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spCart.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spCart.persist();
	}

	@Override
	public java.math.BigDecimal getTotalPriceAmount() {
		return _spCart.getTotalPriceAmount();
	}

	@Override
	public void setTotalPriceAmount(java.math.BigDecimal totalPriceAmount) {
		_spCart.setTotalPriceAmount(totalPriceAmount);
	}

	@Override
	public java.math.BigDecimal getDiscountAmount() {
		return _spCart.getDiscountAmount();
	}

	@Override
	public void setDiscountAmount(java.math.BigDecimal discountAmount) {
		_spCart.setDiscountAmount(discountAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPCartWrapper)) {
			return false;
		}

		SPCartWrapper spCartWrapper = (SPCartWrapper)obj;

		if (Validator.equals(_spCart, spCartWrapper._spCart)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPCart getWrappedSPCart() {
		return _spCart;
	}

	@Override
	public SPCart getWrappedModel() {
		return _spCart;
	}

	@Override
	public void resetOriginalValues() {
		_spCart.resetOriginalValues();
	}

	private SPCart _spCart;
}