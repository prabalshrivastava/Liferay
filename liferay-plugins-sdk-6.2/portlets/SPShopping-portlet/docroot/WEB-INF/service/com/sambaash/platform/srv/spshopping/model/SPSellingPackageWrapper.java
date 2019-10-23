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
 * This class is a wrapper for {@link SPSellingPackage}.
 * </p>
 *
 * @author pradeep
 * @see SPSellingPackage
 * @generated
 */
public class SPSellingPackageWrapper implements SPSellingPackage,
	ModelWrapper<SPSellingPackage> {
	public SPSellingPackageWrapper(SPSellingPackage spSellingPackage) {
		_spSellingPackage = spSellingPackage;
	}

	@Override
	public Class<?> getModelClass() {
		return SPSellingPackage.class;
	}

	@Override
	public String getModelClassName() {
		return SPSellingPackage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spSellingPackageId", getSpSellingPackageId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("pkgCode", getPkgCode());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("longDescription", getLongDescription());
		attributes.put("currencyCode", getCurrencyCode());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("notify", getNotify());
		attributes.put("needsPayment", getNeedsPayment());
		attributes.put("orderPage", getOrderPage());
		attributes.put("orderSequence", getOrderSequence());
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
		Long spSellingPackageId = (Long)attributes.get("spSellingPackageId");

		if (spSellingPackageId != null) {
			setSpSellingPackageId(spSellingPackageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String pkgCode = (String)attributes.get("pkgCode");

		if (pkgCode != null) {
			setPkgCode(pkgCode);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String longDescription = (String)attributes.get("longDescription");

		if (longDescription != null) {
			setLongDescription(longDescription);
		}

		String currencyCode = (String)attributes.get("currencyCode");

		if (currencyCode != null) {
			setCurrencyCode(currencyCode);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String notify = (String)attributes.get("notify");

		if (notify != null) {
			setNotify(notify);
		}

		Boolean needsPayment = (Boolean)attributes.get("needsPayment");

		if (needsPayment != null) {
			setNeedsPayment(needsPayment);
		}

		String orderPage = (String)attributes.get("orderPage");

		if (orderPage != null) {
			setOrderPage(orderPage);
		}

		String orderSequence = (String)attributes.get("orderSequence");

		if (orderSequence != null) {
			setOrderSequence(orderSequence);
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
	* Returns the primary key of this s p selling package.
	*
	* @return the primary key of this s p selling package
	*/
	@Override
	public long getPrimaryKey() {
		return _spSellingPackage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p selling package.
	*
	* @param primaryKey the primary key of this s p selling package
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spSellingPackage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp selling package ID of this s p selling package.
	*
	* @return the sp selling package ID of this s p selling package
	*/
	@Override
	public long getSpSellingPackageId() {
		return _spSellingPackage.getSpSellingPackageId();
	}

	/**
	* Sets the sp selling package ID of this s p selling package.
	*
	* @param spSellingPackageId the sp selling package ID of this s p selling package
	*/
	@Override
	public void setSpSellingPackageId(long spSellingPackageId) {
		_spSellingPackage.setSpSellingPackageId(spSellingPackageId);
	}

	/**
	* Returns the group ID of this s p selling package.
	*
	* @return the group ID of this s p selling package
	*/
	@Override
	public long getGroupId() {
		return _spSellingPackage.getGroupId();
	}

	/**
	* Sets the group ID of this s p selling package.
	*
	* @param groupId the group ID of this s p selling package
	*/
	@Override
	public void setGroupId(long groupId) {
		_spSellingPackage.setGroupId(groupId);
	}

	/**
	* Returns the title of this s p selling package.
	*
	* @return the title of this s p selling package
	*/
	@Override
	public java.lang.String getTitle() {
		return _spSellingPackage.getTitle();
	}

	/**
	* Sets the title of this s p selling package.
	*
	* @param title the title of this s p selling package
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_spSellingPackage.setTitle(title);
	}

	/**
	* Returns the pkg code of this s p selling package.
	*
	* @return the pkg code of this s p selling package
	*/
	@Override
	public java.lang.String getPkgCode() {
		return _spSellingPackage.getPkgCode();
	}

	/**
	* Sets the pkg code of this s p selling package.
	*
	* @param pkgCode the pkg code of this s p selling package
	*/
	@Override
	public void setPkgCode(java.lang.String pkgCode) {
		_spSellingPackage.setPkgCode(pkgCode);
	}

	/**
	* Returns the short description of this s p selling package.
	*
	* @return the short description of this s p selling package
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _spSellingPackage.getShortDescription();
	}

	/**
	* Sets the short description of this s p selling package.
	*
	* @param shortDescription the short description of this s p selling package
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_spSellingPackage.setShortDescription(shortDescription);
	}

	/**
	* Returns the long description of this s p selling package.
	*
	* @return the long description of this s p selling package
	*/
	@Override
	public java.lang.String getLongDescription() {
		return _spSellingPackage.getLongDescription();
	}

	/**
	* Sets the long description of this s p selling package.
	*
	* @param longDescription the long description of this s p selling package
	*/
	@Override
	public void setLongDescription(java.lang.String longDescription) {
		_spSellingPackage.setLongDescription(longDescription);
	}

	/**
	* Returns the currency code of this s p selling package.
	*
	* @return the currency code of this s p selling package
	*/
	@Override
	public java.lang.String getCurrencyCode() {
		return _spSellingPackage.getCurrencyCode();
	}

	/**
	* Sets the currency code of this s p selling package.
	*
	* @param currencyCode the currency code of this s p selling package
	*/
	@Override
	public void setCurrencyCode(java.lang.String currencyCode) {
		_spSellingPackage.setCurrencyCode(currencyCode);
	}

	/**
	* Returns the start date of this s p selling package.
	*
	* @return the start date of this s p selling package
	*/
	@Override
	public java.util.Date getStartDate() {
		return _spSellingPackage.getStartDate();
	}

	/**
	* Sets the start date of this s p selling package.
	*
	* @param startDate the start date of this s p selling package
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_spSellingPackage.setStartDate(startDate);
	}

	/**
	* Returns the end date of this s p selling package.
	*
	* @return the end date of this s p selling package
	*/
	@Override
	public java.util.Date getEndDate() {
		return _spSellingPackage.getEndDate();
	}

	/**
	* Sets the end date of this s p selling package.
	*
	* @param endDate the end date of this s p selling package
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_spSellingPackage.setEndDate(endDate);
	}

	/**
	* Returns the notify of this s p selling package.
	*
	* @return the notify of this s p selling package
	*/
	@Override
	public java.lang.String getNotify() {
		return _spSellingPackage.getNotify();
	}

	/**
	* Sets the notify of this s p selling package.
	*
	* @param notify the notify of this s p selling package
	*/
	@Override
	public void setNotify(java.lang.String notify) {
		_spSellingPackage.setNotify(notify);
	}

	/**
	* Returns the needs payment of this s p selling package.
	*
	* @return the needs payment of this s p selling package
	*/
	@Override
	public boolean getNeedsPayment() {
		return _spSellingPackage.getNeedsPayment();
	}

	/**
	* Returns <code>true</code> if this s p selling package is needs payment.
	*
	* @return <code>true</code> if this s p selling package is needs payment; <code>false</code> otherwise
	*/
	@Override
	public boolean isNeedsPayment() {
		return _spSellingPackage.isNeedsPayment();
	}

	/**
	* Sets whether this s p selling package is needs payment.
	*
	* @param needsPayment the needs payment of this s p selling package
	*/
	@Override
	public void setNeedsPayment(boolean needsPayment) {
		_spSellingPackage.setNeedsPayment(needsPayment);
	}

	/**
	* Returns the order page of this s p selling package.
	*
	* @return the order page of this s p selling package
	*/
	@Override
	public java.lang.String getOrderPage() {
		return _spSellingPackage.getOrderPage();
	}

	/**
	* Sets the order page of this s p selling package.
	*
	* @param orderPage the order page of this s p selling package
	*/
	@Override
	public void setOrderPage(java.lang.String orderPage) {
		_spSellingPackage.setOrderPage(orderPage);
	}

	/**
	* Returns the order sequence of this s p selling package.
	*
	* @return the order sequence of this s p selling package
	*/
	@Override
	public java.lang.String getOrderSequence() {
		return _spSellingPackage.getOrderSequence();
	}

	/**
	* Sets the order sequence of this s p selling package.
	*
	* @param orderSequence the order sequence of this s p selling package
	*/
	@Override
	public void setOrderSequence(java.lang.String orderSequence) {
		_spSellingPackage.setOrderSequence(orderSequence);
	}

	/**
	* Returns the active of this s p selling package.
	*
	* @return the active of this s p selling package
	*/
	@Override
	public boolean getActive() {
		return _spSellingPackage.getActive();
	}

	/**
	* Returns <code>true</code> if this s p selling package is active.
	*
	* @return <code>true</code> if this s p selling package is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _spSellingPackage.isActive();
	}

	/**
	* Sets whether this s p selling package is active.
	*
	* @param active the active of this s p selling package
	*/
	@Override
	public void setActive(boolean active) {
		_spSellingPackage.setActive(active);
	}

	/**
	* Returns the company ID of this s p selling package.
	*
	* @return the company ID of this s p selling package
	*/
	@Override
	public long getCompanyId() {
		return _spSellingPackage.getCompanyId();
	}

	/**
	* Sets the company ID of this s p selling package.
	*
	* @param companyId the company ID of this s p selling package
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spSellingPackage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p selling package.
	*
	* @return the user ID of this s p selling package
	*/
	@Override
	public long getUserId() {
		return _spSellingPackage.getUserId();
	}

	/**
	* Sets the user ID of this s p selling package.
	*
	* @param userId the user ID of this s p selling package
	*/
	@Override
	public void setUserId(long userId) {
		_spSellingPackage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p selling package.
	*
	* @return the user uuid of this s p selling package
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPackage.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p selling package.
	*
	* @param userUuid the user uuid of this s p selling package
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spSellingPackage.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p selling package.
	*
	* @return the user name of this s p selling package
	*/
	@Override
	public java.lang.String getUserName() {
		return _spSellingPackage.getUserName();
	}

	/**
	* Sets the user name of this s p selling package.
	*
	* @param userName the user name of this s p selling package
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spSellingPackage.setUserName(userName);
	}

	/**
	* Returns the create date of this s p selling package.
	*
	* @return the create date of this s p selling package
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spSellingPackage.getCreateDate();
	}

	/**
	* Sets the create date of this s p selling package.
	*
	* @param createDate the create date of this s p selling package
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spSellingPackage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p selling package.
	*
	* @return the modified date of this s p selling package
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spSellingPackage.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p selling package.
	*
	* @param modifiedDate the modified date of this s p selling package
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spSellingPackage.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spSellingPackage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spSellingPackage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spSellingPackage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spSellingPackage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spSellingPackage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spSellingPackage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spSellingPackage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spSellingPackage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spSellingPackage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spSellingPackage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spSellingPackage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPSellingPackageWrapper((SPSellingPackage)_spSellingPackage.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage) {
		return _spSellingPackage.compareTo(spSellingPackage);
	}

	@Override
	public int hashCode() {
		return _spSellingPackage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spshopping.model.SPSellingPackage> toCacheModel() {
		return _spSellingPackage.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage toEscapedModel() {
		return new SPSellingPackageWrapper(_spSellingPackage.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPackage toUnescapedModel() {
		return new SPSellingPackageWrapper(_spSellingPackage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spSellingPackage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spSellingPackage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spSellingPackage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPSellingPackageWrapper)) {
			return false;
		}

		SPSellingPackageWrapper spSellingPackageWrapper = (SPSellingPackageWrapper)obj;

		if (Validator.equals(_spSellingPackage,
					spSellingPackageWrapper._spSellingPackage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPSellingPackage getWrappedSPSellingPackage() {
		return _spSellingPackage;
	}

	@Override
	public SPSellingPackage getWrappedModel() {
		return _spSellingPackage;
	}

	@Override
	public void resetOriginalValues() {
		_spSellingPackage.resetOriginalValues();
	}

	private SPSellingPackage _spSellingPackage;
}