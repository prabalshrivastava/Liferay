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
 * This class is a wrapper for {@link SPPaymentCustomer}.
 * </p>
 *
 * @author pradeep
 * @see SPPaymentCustomer
 * @generated
 */
public class SPPaymentCustomerWrapper implements SPPaymentCustomer,
	ModelWrapper<SPPaymentCustomer> {
	public SPPaymentCustomerWrapper(SPPaymentCustomer spPaymentCustomer) {
		_spPaymentCustomer = spPaymentCustomer;
	}

	@Override
	public Class<?> getModelClass() {
		return SPPaymentCustomer.class;
	}

	@Override
	public String getModelClassName() {
		return SPPaymentCustomer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sPPaymentCustomerId", getSPPaymentCustomerId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("providerCustomerId", getProviderCustomerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sPPaymentCustomerId = (Long)attributes.get("sPPaymentCustomerId");

		if (sPPaymentCustomerId != null) {
			setSPPaymentCustomerId(sPPaymentCustomerId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String providerCustomerId = (String)attributes.get("providerCustomerId");

		if (providerCustomerId != null) {
			setProviderCustomerId(providerCustomerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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
	* Returns the primary key of this s p payment customer.
	*
	* @return the primary key of this s p payment customer
	*/
	@Override
	public long getPrimaryKey() {
		return _spPaymentCustomer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p payment customer.
	*
	* @param primaryKey the primary key of this s p payment customer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spPaymentCustomer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the s p payment customer ID of this s p payment customer.
	*
	* @return the s p payment customer ID of this s p payment customer
	*/
	@Override
	public long getSPPaymentCustomerId() {
		return _spPaymentCustomer.getSPPaymentCustomerId();
	}

	/**
	* Sets the s p payment customer ID of this s p payment customer.
	*
	* @param sPPaymentCustomerId the s p payment customer ID of this s p payment customer
	*/
	@Override
	public void setSPPaymentCustomerId(long sPPaymentCustomerId) {
		_spPaymentCustomer.setSPPaymentCustomerId(sPPaymentCustomerId);
	}

	/**
	* Returns the email address of this s p payment customer.
	*
	* @return the email address of this s p payment customer
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spPaymentCustomer.getEmailAddress();
	}

	/**
	* Sets the email address of this s p payment customer.
	*
	* @param emailAddress the email address of this s p payment customer
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spPaymentCustomer.setEmailAddress(emailAddress);
	}

	/**
	* Returns the provider customer ID of this s p payment customer.
	*
	* @return the provider customer ID of this s p payment customer
	*/
	@Override
	public java.lang.String getProviderCustomerId() {
		return _spPaymentCustomer.getProviderCustomerId();
	}

	/**
	* Sets the provider customer ID of this s p payment customer.
	*
	* @param providerCustomerId the provider customer ID of this s p payment customer
	*/
	@Override
	public void setProviderCustomerId(java.lang.String providerCustomerId) {
		_spPaymentCustomer.setProviderCustomerId(providerCustomerId);
	}

	/**
	* Returns the group ID of this s p payment customer.
	*
	* @return the group ID of this s p payment customer
	*/
	@Override
	public long getGroupId() {
		return _spPaymentCustomer.getGroupId();
	}

	/**
	* Sets the group ID of this s p payment customer.
	*
	* @param groupId the group ID of this s p payment customer
	*/
	@Override
	public void setGroupId(long groupId) {
		_spPaymentCustomer.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p payment customer.
	*
	* @return the company ID of this s p payment customer
	*/
	@Override
	public long getCompanyId() {
		return _spPaymentCustomer.getCompanyId();
	}

	/**
	* Sets the company ID of this s p payment customer.
	*
	* @param companyId the company ID of this s p payment customer
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spPaymentCustomer.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p payment customer.
	*
	* @return the user ID of this s p payment customer
	*/
	@Override
	public long getUserId() {
		return _spPaymentCustomer.getUserId();
	}

	/**
	* Sets the user ID of this s p payment customer.
	*
	* @param userId the user ID of this s p payment customer
	*/
	@Override
	public void setUserId(long userId) {
		_spPaymentCustomer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p payment customer.
	*
	* @return the user uuid of this s p payment customer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomer.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p payment customer.
	*
	* @param userUuid the user uuid of this s p payment customer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spPaymentCustomer.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p payment customer.
	*
	* @return the user name of this s p payment customer
	*/
	@Override
	public java.lang.String getUserName() {
		return _spPaymentCustomer.getUserName();
	}

	/**
	* Sets the user name of this s p payment customer.
	*
	* @param userName the user name of this s p payment customer
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spPaymentCustomer.setUserName(userName);
	}

	/**
	* Returns the create date of this s p payment customer.
	*
	* @return the create date of this s p payment customer
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spPaymentCustomer.getCreateDate();
	}

	/**
	* Sets the create date of this s p payment customer.
	*
	* @param createDate the create date of this s p payment customer
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spPaymentCustomer.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p payment customer.
	*
	* @return the modified date of this s p payment customer
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spPaymentCustomer.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p payment customer.
	*
	* @param modifiedDate the modified date of this s p payment customer
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spPaymentCustomer.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spPaymentCustomer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spPaymentCustomer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spPaymentCustomer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spPaymentCustomer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spPaymentCustomer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spPaymentCustomer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spPaymentCustomer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spPaymentCustomer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spPaymentCustomer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spPaymentCustomer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spPaymentCustomer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPPaymentCustomerWrapper((SPPaymentCustomer)_spPaymentCustomer.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer spPaymentCustomer) {
		return _spPaymentCustomer.compareTo(spPaymentCustomer);
	}

	@Override
	public int hashCode() {
		return _spPaymentCustomer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> toCacheModel() {
		return _spPaymentCustomer.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer toEscapedModel() {
		return new SPPaymentCustomerWrapper(_spPaymentCustomer.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer toUnescapedModel() {
		return new SPPaymentCustomerWrapper(_spPaymentCustomer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spPaymentCustomer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spPaymentCustomer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spPaymentCustomer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPPaymentCustomerWrapper)) {
			return false;
		}

		SPPaymentCustomerWrapper spPaymentCustomerWrapper = (SPPaymentCustomerWrapper)obj;

		if (Validator.equals(_spPaymentCustomer,
					spPaymentCustomerWrapper._spPaymentCustomer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPPaymentCustomer getWrappedSPPaymentCustomer() {
		return _spPaymentCustomer;
	}

	@Override
	public SPPaymentCustomer getWrappedModel() {
		return _spPaymentCustomer;
	}

	@Override
	public void resetOriginalValues() {
		_spPaymentCustomer.resetOriginalValues();
	}

	private SPPaymentCustomer _spPaymentCustomer;
}