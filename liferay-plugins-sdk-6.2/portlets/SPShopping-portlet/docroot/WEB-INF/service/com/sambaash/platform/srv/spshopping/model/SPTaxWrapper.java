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
 * This class is a wrapper for {@link SPTax}.
 * </p>
 *
 * @author pradeep
 * @see SPTax
 * @generated
 */
public class SPTaxWrapper implements SPTax, ModelWrapper<SPTax> {
	public SPTaxWrapper(SPTax spTax) {
		_spTax = spTax;
	}

	@Override
	public Class<?> getModelClass() {
		return SPTax.class;
	}

	@Override
	public String getModelClassName() {
		return SPTax.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spTaxId", getSpTaxId());
		attributes.put("groupId", getGroupId());
		attributes.put("currencyCode", getCurrencyCode());
		attributes.put("taxName", getTaxName());
		attributes.put("taxValue", getTaxValue());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spTaxId = (Long)attributes.get("spTaxId");

		if (spTaxId != null) {
			setSpTaxId(spTaxId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String currencyCode = (String)attributes.get("currencyCode");

		if (currencyCode != null) {
			setCurrencyCode(currencyCode);
		}

		String taxName = (String)attributes.get("taxName");

		if (taxName != null) {
			setTaxName(taxName);
		}

		Long taxValue = (Long)attributes.get("taxValue");

		if (taxValue != null) {
			setTaxValue(taxValue);
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
	* Returns the primary key of this s p tax.
	*
	* @return the primary key of this s p tax
	*/
	@Override
	public long getPrimaryKey() {
		return _spTax.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p tax.
	*
	* @param primaryKey the primary key of this s p tax
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spTax.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp tax ID of this s p tax.
	*
	* @return the sp tax ID of this s p tax
	*/
	@Override
	public long getSpTaxId() {
		return _spTax.getSpTaxId();
	}

	/**
	* Sets the sp tax ID of this s p tax.
	*
	* @param spTaxId the sp tax ID of this s p tax
	*/
	@Override
	public void setSpTaxId(long spTaxId) {
		_spTax.setSpTaxId(spTaxId);
	}

	/**
	* Returns the group ID of this s p tax.
	*
	* @return the group ID of this s p tax
	*/
	@Override
	public long getGroupId() {
		return _spTax.getGroupId();
	}

	/**
	* Sets the group ID of this s p tax.
	*
	* @param groupId the group ID of this s p tax
	*/
	@Override
	public void setGroupId(long groupId) {
		_spTax.setGroupId(groupId);
	}

	/**
	* Returns the currency code of this s p tax.
	*
	* @return the currency code of this s p tax
	*/
	@Override
	public java.lang.String getCurrencyCode() {
		return _spTax.getCurrencyCode();
	}

	/**
	* Sets the currency code of this s p tax.
	*
	* @param currencyCode the currency code of this s p tax
	*/
	@Override
	public void setCurrencyCode(java.lang.String currencyCode) {
		_spTax.setCurrencyCode(currencyCode);
	}

	/**
	* Returns the tax name of this s p tax.
	*
	* @return the tax name of this s p tax
	*/
	@Override
	public java.lang.String getTaxName() {
		return _spTax.getTaxName();
	}

	/**
	* Sets the tax name of this s p tax.
	*
	* @param taxName the tax name of this s p tax
	*/
	@Override
	public void setTaxName(java.lang.String taxName) {
		_spTax.setTaxName(taxName);
	}

	/**
	* Returns the tax value of this s p tax.
	*
	* @return the tax value of this s p tax
	*/
	@Override
	public long getTaxValue() {
		return _spTax.getTaxValue();
	}

	/**
	* Sets the tax value of this s p tax.
	*
	* @param taxValue the tax value of this s p tax
	*/
	@Override
	public void setTaxValue(long taxValue) {
		_spTax.setTaxValue(taxValue);
	}

	/**
	* Returns the company ID of this s p tax.
	*
	* @return the company ID of this s p tax
	*/
	@Override
	public long getCompanyId() {
		return _spTax.getCompanyId();
	}

	/**
	* Sets the company ID of this s p tax.
	*
	* @param companyId the company ID of this s p tax
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spTax.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p tax.
	*
	* @return the user ID of this s p tax
	*/
	@Override
	public long getUserId() {
		return _spTax.getUserId();
	}

	/**
	* Sets the user ID of this s p tax.
	*
	* @param userId the user ID of this s p tax
	*/
	@Override
	public void setUserId(long userId) {
		_spTax.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p tax.
	*
	* @return the user uuid of this s p tax
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTax.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p tax.
	*
	* @param userUuid the user uuid of this s p tax
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spTax.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p tax.
	*
	* @return the user name of this s p tax
	*/
	@Override
	public java.lang.String getUserName() {
		return _spTax.getUserName();
	}

	/**
	* Sets the user name of this s p tax.
	*
	* @param userName the user name of this s p tax
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spTax.setUserName(userName);
	}

	/**
	* Returns the create date of this s p tax.
	*
	* @return the create date of this s p tax
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spTax.getCreateDate();
	}

	/**
	* Sets the create date of this s p tax.
	*
	* @param createDate the create date of this s p tax
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spTax.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p tax.
	*
	* @return the modified date of this s p tax
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spTax.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p tax.
	*
	* @param modifiedDate the modified date of this s p tax
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spTax.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spTax.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spTax.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spTax.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spTax.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spTax.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spTax.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spTax.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spTax.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spTax.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spTax.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spTax.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPTaxWrapper((SPTax)_spTax.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.spshopping.model.SPTax spTax) {
		return _spTax.compareTo(spTax);
	}

	@Override
	public int hashCode() {
		return _spTax.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spshopping.model.SPTax> toCacheModel() {
		return _spTax.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPTax toEscapedModel() {
		return new SPTaxWrapper(_spTax.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPTax toUnescapedModel() {
		return new SPTaxWrapper(_spTax.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spTax.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spTax.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spTax.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPTaxWrapper)) {
			return false;
		}

		SPTaxWrapper spTaxWrapper = (SPTaxWrapper)obj;

		if (Validator.equals(_spTax, spTaxWrapper._spTax)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPTax getWrappedSPTax() {
		return _spTax;
	}

	@Override
	public SPTax getWrappedModel() {
		return _spTax;
	}

	@Override
	public void resetOriginalValues() {
		_spTax.resetOriginalValues();
	}

	private SPTax _spTax;
}