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

package com.sambaash.platform.srv.sppayment.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPPurchase}.
 * </p>
 *
 * @author pradeep
 * @see SPPurchase
 * @generated
 */
public class SPPurchaseWrapper implements SPPurchase, ModelWrapper<SPPurchase> {
	public SPPurchaseWrapper(SPPurchase spPurchase) {
		_spPurchase = spPurchase;
	}

	@Override
	public Class<?> getModelClass() {
		return SPPurchase.class;
	}

	@Override
	public String getModelClassName() {
		return SPPurchase.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPurchaseId", getSpPurchaseId());
		attributes.put("groupId", getGroupId());
		attributes.put("cartId", getCartId());
		attributes.put("extPaymentId", getExtPaymentId());
		attributes.put("extStatus", getExtStatus());
		attributes.put("extErrorCode", getExtErrorCode());
		attributes.put("extErrorMsg", getExtErrorMsg());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPurchaseId = (Long)attributes.get("spPurchaseId");

		if (spPurchaseId != null) {
			setSpPurchaseId(spPurchaseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		String extPaymentId = (String)attributes.get("extPaymentId");

		if (extPaymentId != null) {
			setExtPaymentId(extPaymentId);
		}

		String extStatus = (String)attributes.get("extStatus");

		if (extStatus != null) {
			setExtStatus(extStatus);
		}

		Long extErrorCode = (Long)attributes.get("extErrorCode");

		if (extErrorCode != null) {
			setExtErrorCode(extErrorCode);
		}

		String extErrorMsg = (String)attributes.get("extErrorMsg");

		if (extErrorMsg != null) {
			setExtErrorMsg(extErrorMsg);
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
	* Returns the primary key of this s p purchase.
	*
	* @return the primary key of this s p purchase
	*/
	@Override
	public long getPrimaryKey() {
		return _spPurchase.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p purchase.
	*
	* @param primaryKey the primary key of this s p purchase
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spPurchase.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp purchase ID of this s p purchase.
	*
	* @return the sp purchase ID of this s p purchase
	*/
	@Override
	public long getSpPurchaseId() {
		return _spPurchase.getSpPurchaseId();
	}

	/**
	* Sets the sp purchase ID of this s p purchase.
	*
	* @param spPurchaseId the sp purchase ID of this s p purchase
	*/
	@Override
	public void setSpPurchaseId(long spPurchaseId) {
		_spPurchase.setSpPurchaseId(spPurchaseId);
	}

	/**
	* Returns the group ID of this s p purchase.
	*
	* @return the group ID of this s p purchase
	*/
	@Override
	public long getGroupId() {
		return _spPurchase.getGroupId();
	}

	/**
	* Sets the group ID of this s p purchase.
	*
	* @param groupId the group ID of this s p purchase
	*/
	@Override
	public void setGroupId(long groupId) {
		_spPurchase.setGroupId(groupId);
	}

	/**
	* Returns the cart ID of this s p purchase.
	*
	* @return the cart ID of this s p purchase
	*/
	@Override
	public long getCartId() {
		return _spPurchase.getCartId();
	}

	/**
	* Sets the cart ID of this s p purchase.
	*
	* @param cartId the cart ID of this s p purchase
	*/
	@Override
	public void setCartId(long cartId) {
		_spPurchase.setCartId(cartId);
	}

	/**
	* Returns the ext payment ID of this s p purchase.
	*
	* @return the ext payment ID of this s p purchase
	*/
	@Override
	public java.lang.String getExtPaymentId() {
		return _spPurchase.getExtPaymentId();
	}

	/**
	* Sets the ext payment ID of this s p purchase.
	*
	* @param extPaymentId the ext payment ID of this s p purchase
	*/
	@Override
	public void setExtPaymentId(java.lang.String extPaymentId) {
		_spPurchase.setExtPaymentId(extPaymentId);
	}

	/**
	* Returns the ext status of this s p purchase.
	*
	* @return the ext status of this s p purchase
	*/
	@Override
	public java.lang.String getExtStatus() {
		return _spPurchase.getExtStatus();
	}

	/**
	* Sets the ext status of this s p purchase.
	*
	* @param extStatus the ext status of this s p purchase
	*/
	@Override
	public void setExtStatus(java.lang.String extStatus) {
		_spPurchase.setExtStatus(extStatus);
	}

	/**
	* Returns the ext error code of this s p purchase.
	*
	* @return the ext error code of this s p purchase
	*/
	@Override
	public long getExtErrorCode() {
		return _spPurchase.getExtErrorCode();
	}

	/**
	* Sets the ext error code of this s p purchase.
	*
	* @param extErrorCode the ext error code of this s p purchase
	*/
	@Override
	public void setExtErrorCode(long extErrorCode) {
		_spPurchase.setExtErrorCode(extErrorCode);
	}

	/**
	* Returns the ext error msg of this s p purchase.
	*
	* @return the ext error msg of this s p purchase
	*/
	@Override
	public java.lang.String getExtErrorMsg() {
		return _spPurchase.getExtErrorMsg();
	}

	/**
	* Sets the ext error msg of this s p purchase.
	*
	* @param extErrorMsg the ext error msg of this s p purchase
	*/
	@Override
	public void setExtErrorMsg(java.lang.String extErrorMsg) {
		_spPurchase.setExtErrorMsg(extErrorMsg);
	}

	/**
	* Returns the company ID of this s p purchase.
	*
	* @return the company ID of this s p purchase
	*/
	@Override
	public long getCompanyId() {
		return _spPurchase.getCompanyId();
	}

	/**
	* Sets the company ID of this s p purchase.
	*
	* @param companyId the company ID of this s p purchase
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spPurchase.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p purchase.
	*
	* @return the user ID of this s p purchase
	*/
	@Override
	public long getUserId() {
		return _spPurchase.getUserId();
	}

	/**
	* Sets the user ID of this s p purchase.
	*
	* @param userId the user ID of this s p purchase
	*/
	@Override
	public void setUserId(long userId) {
		_spPurchase.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p purchase.
	*
	* @return the user uuid of this s p purchase
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPurchase.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p purchase.
	*
	* @param userUuid the user uuid of this s p purchase
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spPurchase.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p purchase.
	*
	* @return the user name of this s p purchase
	*/
	@Override
	public java.lang.String getUserName() {
		return _spPurchase.getUserName();
	}

	/**
	* Sets the user name of this s p purchase.
	*
	* @param userName the user name of this s p purchase
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spPurchase.setUserName(userName);
	}

	/**
	* Returns the create date of this s p purchase.
	*
	* @return the create date of this s p purchase
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spPurchase.getCreateDate();
	}

	/**
	* Sets the create date of this s p purchase.
	*
	* @param createDate the create date of this s p purchase
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spPurchase.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p purchase.
	*
	* @return the modified date of this s p purchase
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spPurchase.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p purchase.
	*
	* @param modifiedDate the modified date of this s p purchase
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spPurchase.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spPurchase.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spPurchase.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spPurchase.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spPurchase.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spPurchase.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spPurchase.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spPurchase.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spPurchase.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spPurchase.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spPurchase.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spPurchase.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPPurchaseWrapper((SPPurchase)_spPurchase.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.sppayment.model.SPPurchase spPurchase) {
		return _spPurchase.compareTo(spPurchase);
	}

	@Override
	public int hashCode() {
		return _spPurchase.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.sppayment.model.SPPurchase> toCacheModel() {
		return _spPurchase.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPurchase toEscapedModel() {
		return new SPPurchaseWrapper(_spPurchase.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPurchase toUnescapedModel() {
		return new SPPurchaseWrapper(_spPurchase.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spPurchase.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spPurchase.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spPurchase.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPPurchaseWrapper)) {
			return false;
		}

		SPPurchaseWrapper spPurchaseWrapper = (SPPurchaseWrapper)obj;

		if (Validator.equals(_spPurchase, spPurchaseWrapper._spPurchase)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPPurchase getWrappedSPPurchase() {
		return _spPurchase;
	}

	@Override
	public SPPurchase getWrappedModel() {
		return _spPurchase;
	}

	@Override
	public void resetOriginalValues() {
		_spPurchase.resetOriginalValues();
	}

	private SPPurchase _spPurchase;
}