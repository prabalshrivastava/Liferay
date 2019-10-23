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

package com.sambaash.platform.srv.startupprofile.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author pradeep
 * @see Address
 * @generated
 */
public class AddressWrapper implements Address, ModelWrapper<Address> {
	public AddressWrapper(Address address) {
		_address = address;
	}

	@Override
	public Class<?> getModelClass() {
		return Address.class;
	}

	@Override
	public String getModelClassName() {
		return Address.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("addressId", getAddressId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("name", getName());
		attributes.put("street1", getStreet1());
		attributes.put("street2", getStreet2());
		attributes.put("street3", getStreet3());
		attributes.put("street4", getStreet4());
		attributes.put("city", getCity());
		attributes.put("region", getRegion());
		attributes.put("country", getCountry());
		attributes.put("postalCode", getPostalCode());
		attributes.put("hq", getHq());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String street1 = (String)attributes.get("street1");

		if (street1 != null) {
			setStreet1(street1);
		}

		String street2 = (String)attributes.get("street2");

		if (street2 != null) {
			setStreet2(street2);
		}

		String street3 = (String)attributes.get("street3");

		if (street3 != null) {
			setStreet3(street3);
		}

		String street4 = (String)attributes.get("street4");

		if (street4 != null) {
			setStreet4(street4);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String region = (String)attributes.get("region");

		if (region != null) {
			setRegion(region);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		Boolean hq = (Boolean)attributes.get("hq");

		if (hq != null) {
			setHq(hq);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this address.
	*
	* @return the primary key of this address
	*/
	@Override
	public long getPrimaryKey() {
		return _address.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address.
	*
	* @param primaryKey the primary key of this address
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_address.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this address.
	*
	* @return the uuid of this address
	*/
	@Override
	public java.lang.String getUuid() {
		return _address.getUuid();
	}

	/**
	* Sets the uuid of this address.
	*
	* @param uuid the uuid of this address
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_address.setUuid(uuid);
	}

	/**
	* Returns the address ID of this address.
	*
	* @return the address ID of this address
	*/
	@Override
	public long getAddressId() {
		return _address.getAddressId();
	}

	/**
	* Sets the address ID of this address.
	*
	* @param addressId the address ID of this address
	*/
	@Override
	public void setAddressId(long addressId) {
		_address.setAddressId(addressId);
	}

	/**
	* Returns the organization ID of this address.
	*
	* @return the organization ID of this address
	*/
	@Override
	public long getOrganizationId() {
		return _address.getOrganizationId();
	}

	/**
	* Sets the organization ID of this address.
	*
	* @param organizationId the organization ID of this address
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_address.setOrganizationId(organizationId);
	}

	/**
	* Returns the name of this address.
	*
	* @return the name of this address
	*/
	@Override
	public java.lang.String getName() {
		return _address.getName();
	}

	/**
	* Sets the name of this address.
	*
	* @param name the name of this address
	*/
	@Override
	public void setName(java.lang.String name) {
		_address.setName(name);
	}

	/**
	* Returns the street1 of this address.
	*
	* @return the street1 of this address
	*/
	@Override
	public java.lang.String getStreet1() {
		return _address.getStreet1();
	}

	/**
	* Sets the street1 of this address.
	*
	* @param street1 the street1 of this address
	*/
	@Override
	public void setStreet1(java.lang.String street1) {
		_address.setStreet1(street1);
	}

	/**
	* Returns the street2 of this address.
	*
	* @return the street2 of this address
	*/
	@Override
	public java.lang.String getStreet2() {
		return _address.getStreet2();
	}

	/**
	* Sets the street2 of this address.
	*
	* @param street2 the street2 of this address
	*/
	@Override
	public void setStreet2(java.lang.String street2) {
		_address.setStreet2(street2);
	}

	/**
	* Returns the street3 of this address.
	*
	* @return the street3 of this address
	*/
	@Override
	public java.lang.String getStreet3() {
		return _address.getStreet3();
	}

	/**
	* Sets the street3 of this address.
	*
	* @param street3 the street3 of this address
	*/
	@Override
	public void setStreet3(java.lang.String street3) {
		_address.setStreet3(street3);
	}

	/**
	* Returns the street4 of this address.
	*
	* @return the street4 of this address
	*/
	@Override
	public java.lang.String getStreet4() {
		return _address.getStreet4();
	}

	/**
	* Sets the street4 of this address.
	*
	* @param street4 the street4 of this address
	*/
	@Override
	public void setStreet4(java.lang.String street4) {
		_address.setStreet4(street4);
	}

	/**
	* Returns the city of this address.
	*
	* @return the city of this address
	*/
	@Override
	public java.lang.String getCity() {
		return _address.getCity();
	}

	/**
	* Sets the city of this address.
	*
	* @param city the city of this address
	*/
	@Override
	public void setCity(java.lang.String city) {
		_address.setCity(city);
	}

	/**
	* Returns the region of this address.
	*
	* @return the region of this address
	*/
	@Override
	public java.lang.String getRegion() {
		return _address.getRegion();
	}

	/**
	* Sets the region of this address.
	*
	* @param region the region of this address
	*/
	@Override
	public void setRegion(java.lang.String region) {
		_address.setRegion(region);
	}

	/**
	* Returns the country of this address.
	*
	* @return the country of this address
	*/
	@Override
	public java.lang.String getCountry() {
		return _address.getCountry();
	}

	/**
	* Sets the country of this address.
	*
	* @param country the country of this address
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_address.setCountry(country);
	}

	/**
	* Returns the postal code of this address.
	*
	* @return the postal code of this address
	*/
	@Override
	public java.lang.String getPostalCode() {
		return _address.getPostalCode();
	}

	/**
	* Sets the postal code of this address.
	*
	* @param postalCode the postal code of this address
	*/
	@Override
	public void setPostalCode(java.lang.String postalCode) {
		_address.setPostalCode(postalCode);
	}

	/**
	* Returns the hq of this address.
	*
	* @return the hq of this address
	*/
	@Override
	public boolean getHq() {
		return _address.getHq();
	}

	/**
	* Returns <code>true</code> if this address is hq.
	*
	* @return <code>true</code> if this address is hq; <code>false</code> otherwise
	*/
	@Override
	public boolean isHq() {
		return _address.isHq();
	}

	/**
	* Sets whether this address is hq.
	*
	* @param hq the hq of this address
	*/
	@Override
	public void setHq(boolean hq) {
		_address.setHq(hq);
	}

	/**
	* Returns the group ID of this address.
	*
	* @return the group ID of this address
	*/
	@Override
	public long getGroupId() {
		return _address.getGroupId();
	}

	/**
	* Sets the group ID of this address.
	*
	* @param groupId the group ID of this address
	*/
	@Override
	public void setGroupId(long groupId) {
		_address.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this address.
	*
	* @return the company ID of this address
	*/
	@Override
	public long getCompanyId() {
		return _address.getCompanyId();
	}

	/**
	* Sets the company ID of this address.
	*
	* @param companyId the company ID of this address
	*/
	@Override
	public void setCompanyId(long companyId) {
		_address.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this address.
	*
	* @return the user ID of this address
	*/
	@Override
	public long getUserId() {
		return _address.getUserId();
	}

	/**
	* Sets the user ID of this address.
	*
	* @param userId the user ID of this address
	*/
	@Override
	public void setUserId(long userId) {
		_address.setUserId(userId);
	}

	/**
	* Returns the user uuid of this address.
	*
	* @return the user uuid of this address
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _address.getUserUuid();
	}

	/**
	* Sets the user uuid of this address.
	*
	* @param userUuid the user uuid of this address
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_address.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this address.
	*
	* @return the user name of this address
	*/
	@Override
	public java.lang.String getUserName() {
		return _address.getUserName();
	}

	/**
	* Sets the user name of this address.
	*
	* @param userName the user name of this address
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_address.setUserName(userName);
	}

	/**
	* Returns the create date of this address.
	*
	* @return the create date of this address
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _address.getCreateDate();
	}

	/**
	* Sets the create date of this address.
	*
	* @param createDate the create date of this address
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_address.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this address.
	*
	* @return the modified date of this address
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _address.getModifiedDate();
	}

	/**
	* Sets the modified date of this address.
	*
	* @param modifiedDate the modified date of this address
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_address.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the active of this address.
	*
	* @return the active of this address
	*/
	@Override
	public boolean getActive() {
		return _address.getActive();
	}

	/**
	* Returns <code>true</code> if this address is active.
	*
	* @return <code>true</code> if this address is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _address.isActive();
	}

	/**
	* Sets whether this address is active.
	*
	* @param active the active of this address
	*/
	@Override
	public void setActive(boolean active) {
		_address.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _address.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_address.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _address.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_address.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _address.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _address.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_address.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _address.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_address.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_address.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_address.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressWrapper((Address)_address.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.Address address) {
		return _address.compareTo(address);
	}

	@Override
	public int hashCode() {
		return _address.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.Address> toCacheModel() {
		return _address.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Address toEscapedModel() {
		return new AddressWrapper(_address.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Address toUnescapedModel() {
		return new AddressWrapper(_address.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _address.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _address.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_address.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressWrapper)) {
			return false;
		}

		AddressWrapper addressWrapper = (AddressWrapper)obj;

		if (Validator.equals(_address, addressWrapper._address)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _address.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Address getWrappedAddress() {
		return _address;
	}

	@Override
	public Address getWrappedModel() {
		return _address;
	}

	@Override
	public void resetOriginalValues() {
		_address.resetOriginalValues();
	}

	private Address _address;
}