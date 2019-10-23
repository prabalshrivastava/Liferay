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

package com.sambaash.platform.srv.legalandcontract.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Agency}.
 * </p>
 *
 * @author nareshchebolu
 * @see Agency
 * @generated
 */
public class AgencyWrapper implements Agency, ModelWrapper<Agency> {
	public AgencyWrapper(Agency agency) {
		_agency = agency;
	}

	@Override
	public Class<?> getModelClass() {
		return Agency.class;
	}

	@Override
	public String getModelClassName() {
		return Agency.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spAgencyId", getSpAgencyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("number", getNumber());
		attributes.put("country", getCountry());
		attributes.put("name", getName());
		attributes.put("reference", getReference());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("address", getAddress());
		attributes.put("remarks", getRemarks());
		attributes.put("status", getStatus());
		attributes.put("customField1", getCustomField1());
		attributes.put("customField2", getCustomField2());
		attributes.put("customField3", getCustomField3());
		attributes.put("customDate1", getCustomDate1());
		attributes.put("customDate2", getCustomDate2());
		attributes.put("customDate3", getCustomDate3());
		attributes.put("version", getVersion());
		attributes.put("rootSpAgencyId", getRootSpAgencyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spAgencyId = (Long)attributes.get("spAgencyId");

		if (spAgencyId != null) {
			setSpAgencyId(spAgencyId);
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

		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String reference = (String)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}

		String startDate = (String)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String endDate = (String)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String customField1 = (String)attributes.get("customField1");

		if (customField1 != null) {
			setCustomField1(customField1);
		}

		String customField2 = (String)attributes.get("customField2");

		if (customField2 != null) {
			setCustomField2(customField2);
		}

		String customField3 = (String)attributes.get("customField3");

		if (customField3 != null) {
			setCustomField3(customField3);
		}

		Date customDate1 = (Date)attributes.get("customDate1");

		if (customDate1 != null) {
			setCustomDate1(customDate1);
		}

		Date customDate2 = (Date)attributes.get("customDate2");

		if (customDate2 != null) {
			setCustomDate2(customDate2);
		}

		Date customDate3 = (Date)attributes.get("customDate3");

		if (customDate3 != null) {
			setCustomDate3(customDate3);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long rootSpAgencyId = (Long)attributes.get("rootSpAgencyId");

		if (rootSpAgencyId != null) {
			setRootSpAgencyId(rootSpAgencyId);
		}
	}

	/**
	* Returns the primary key of this agency.
	*
	* @return the primary key of this agency
	*/
	@Override
	public long getPrimaryKey() {
		return _agency.getPrimaryKey();
	}

	/**
	* Sets the primary key of this agency.
	*
	* @param primaryKey the primary key of this agency
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_agency.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this agency.
	*
	* @return the uuid of this agency
	*/
	@Override
	public java.lang.String getUuid() {
		return _agency.getUuid();
	}

	/**
	* Sets the uuid of this agency.
	*
	* @param uuid the uuid of this agency
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_agency.setUuid(uuid);
	}

	/**
	* Returns the sp agency ID of this agency.
	*
	* @return the sp agency ID of this agency
	*/
	@Override
	public long getSpAgencyId() {
		return _agency.getSpAgencyId();
	}

	/**
	* Sets the sp agency ID of this agency.
	*
	* @param spAgencyId the sp agency ID of this agency
	*/
	@Override
	public void setSpAgencyId(long spAgencyId) {
		_agency.setSpAgencyId(spAgencyId);
	}

	/**
	* Returns the group ID of this agency.
	*
	* @return the group ID of this agency
	*/
	@Override
	public long getGroupId() {
		return _agency.getGroupId();
	}

	/**
	* Sets the group ID of this agency.
	*
	* @param groupId the group ID of this agency
	*/
	@Override
	public void setGroupId(long groupId) {
		_agency.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this agency.
	*
	* @return the company ID of this agency
	*/
	@Override
	public long getCompanyId() {
		return _agency.getCompanyId();
	}

	/**
	* Sets the company ID of this agency.
	*
	* @param companyId the company ID of this agency
	*/
	@Override
	public void setCompanyId(long companyId) {
		_agency.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this agency.
	*
	* @return the user ID of this agency
	*/
	@Override
	public long getUserId() {
		return _agency.getUserId();
	}

	/**
	* Sets the user ID of this agency.
	*
	* @param userId the user ID of this agency
	*/
	@Override
	public void setUserId(long userId) {
		_agency.setUserId(userId);
	}

	/**
	* Returns the user uuid of this agency.
	*
	* @return the user uuid of this agency
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _agency.getUserUuid();
	}

	/**
	* Sets the user uuid of this agency.
	*
	* @param userUuid the user uuid of this agency
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_agency.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this agency.
	*
	* @return the user name of this agency
	*/
	@Override
	public java.lang.String getUserName() {
		return _agency.getUserName();
	}

	/**
	* Sets the user name of this agency.
	*
	* @param userName the user name of this agency
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_agency.setUserName(userName);
	}

	/**
	* Returns the create date of this agency.
	*
	* @return the create date of this agency
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _agency.getCreateDate();
	}

	/**
	* Sets the create date of this agency.
	*
	* @param createDate the create date of this agency
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_agency.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this agency.
	*
	* @return the modified date of this agency
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _agency.getModifiedDate();
	}

	/**
	* Sets the modified date of this agency.
	*
	* @param modifiedDate the modified date of this agency
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_agency.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the number of this agency.
	*
	* @return the number of this agency
	*/
	@Override
	public java.lang.String getNumber() {
		return _agency.getNumber();
	}

	/**
	* Sets the number of this agency.
	*
	* @param number the number of this agency
	*/
	@Override
	public void setNumber(java.lang.String number) {
		_agency.setNumber(number);
	}

	/**
	* Returns the country of this agency.
	*
	* @return the country of this agency
	*/
	@Override
	public java.lang.String getCountry() {
		return _agency.getCountry();
	}

	/**
	* Sets the country of this agency.
	*
	* @param country the country of this agency
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_agency.setCountry(country);
	}

	/**
	* Returns the name of this agency.
	*
	* @return the name of this agency
	*/
	@Override
	public java.lang.String getName() {
		return _agency.getName();
	}

	/**
	* Sets the name of this agency.
	*
	* @param name the name of this agency
	*/
	@Override
	public void setName(java.lang.String name) {
		_agency.setName(name);
	}

	/**
	* Returns the reference of this agency.
	*
	* @return the reference of this agency
	*/
	@Override
	public java.lang.String getReference() {
		return _agency.getReference();
	}

	/**
	* Sets the reference of this agency.
	*
	* @param reference the reference of this agency
	*/
	@Override
	public void setReference(java.lang.String reference) {
		_agency.setReference(reference);
	}

	/**
	* Returns the start date of this agency.
	*
	* @return the start date of this agency
	*/
	@Override
	public java.lang.String getStartDate() {
		return _agency.getStartDate();
	}

	/**
	* Sets the start date of this agency.
	*
	* @param startDate the start date of this agency
	*/
	@Override
	public void setStartDate(java.lang.String startDate) {
		_agency.setStartDate(startDate);
	}

	/**
	* Returns the end date of this agency.
	*
	* @return the end date of this agency
	*/
	@Override
	public java.lang.String getEndDate() {
		return _agency.getEndDate();
	}

	/**
	* Sets the end date of this agency.
	*
	* @param endDate the end date of this agency
	*/
	@Override
	public void setEndDate(java.lang.String endDate) {
		_agency.setEndDate(endDate);
	}

	/**
	* Returns the address of this agency.
	*
	* @return the address of this agency
	*/
	@Override
	public java.lang.String getAddress() {
		return _agency.getAddress();
	}

	/**
	* Sets the address of this agency.
	*
	* @param address the address of this agency
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_agency.setAddress(address);
	}

	/**
	* Returns the remarks of this agency.
	*
	* @return the remarks of this agency
	*/
	@Override
	public java.lang.String getRemarks() {
		return _agency.getRemarks();
	}

	/**
	* Sets the remarks of this agency.
	*
	* @param remarks the remarks of this agency
	*/
	@Override
	public void setRemarks(java.lang.String remarks) {
		_agency.setRemarks(remarks);
	}

	/**
	* Returns the status of this agency.
	*
	* @return the status of this agency
	*/
	@Override
	public java.lang.String getStatus() {
		return _agency.getStatus();
	}

	/**
	* Sets the status of this agency.
	*
	* @param status the status of this agency
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_agency.setStatus(status);
	}

	/**
	* Returns the custom field1 of this agency.
	*
	* @return the custom field1 of this agency
	*/
	@Override
	public java.lang.String getCustomField1() {
		return _agency.getCustomField1();
	}

	/**
	* Sets the custom field1 of this agency.
	*
	* @param customField1 the custom field1 of this agency
	*/
	@Override
	public void setCustomField1(java.lang.String customField1) {
		_agency.setCustomField1(customField1);
	}

	/**
	* Returns the custom field2 of this agency.
	*
	* @return the custom field2 of this agency
	*/
	@Override
	public java.lang.String getCustomField2() {
		return _agency.getCustomField2();
	}

	/**
	* Sets the custom field2 of this agency.
	*
	* @param customField2 the custom field2 of this agency
	*/
	@Override
	public void setCustomField2(java.lang.String customField2) {
		_agency.setCustomField2(customField2);
	}

	/**
	* Returns the custom field3 of this agency.
	*
	* @return the custom field3 of this agency
	*/
	@Override
	public java.lang.String getCustomField3() {
		return _agency.getCustomField3();
	}

	/**
	* Sets the custom field3 of this agency.
	*
	* @param customField3 the custom field3 of this agency
	*/
	@Override
	public void setCustomField3(java.lang.String customField3) {
		_agency.setCustomField3(customField3);
	}

	/**
	* Returns the custom date1 of this agency.
	*
	* @return the custom date1 of this agency
	*/
	@Override
	public java.util.Date getCustomDate1() {
		return _agency.getCustomDate1();
	}

	/**
	* Sets the custom date1 of this agency.
	*
	* @param customDate1 the custom date1 of this agency
	*/
	@Override
	public void setCustomDate1(java.util.Date customDate1) {
		_agency.setCustomDate1(customDate1);
	}

	/**
	* Returns the custom date2 of this agency.
	*
	* @return the custom date2 of this agency
	*/
	@Override
	public java.util.Date getCustomDate2() {
		return _agency.getCustomDate2();
	}

	/**
	* Sets the custom date2 of this agency.
	*
	* @param customDate2 the custom date2 of this agency
	*/
	@Override
	public void setCustomDate2(java.util.Date customDate2) {
		_agency.setCustomDate2(customDate2);
	}

	/**
	* Returns the custom date3 of this agency.
	*
	* @return the custom date3 of this agency
	*/
	@Override
	public java.util.Date getCustomDate3() {
		return _agency.getCustomDate3();
	}

	/**
	* Sets the custom date3 of this agency.
	*
	* @param customDate3 the custom date3 of this agency
	*/
	@Override
	public void setCustomDate3(java.util.Date customDate3) {
		_agency.setCustomDate3(customDate3);
	}

	/**
	* Returns the version of this agency.
	*
	* @return the version of this agency
	*/
	@Override
	public java.lang.String getVersion() {
		return _agency.getVersion();
	}

	/**
	* Sets the version of this agency.
	*
	* @param version the version of this agency
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_agency.setVersion(version);
	}

	/**
	* Returns the root sp agency ID of this agency.
	*
	* @return the root sp agency ID of this agency
	*/
	@Override
	public long getRootSpAgencyId() {
		return _agency.getRootSpAgencyId();
	}

	/**
	* Sets the root sp agency ID of this agency.
	*
	* @param rootSpAgencyId the root sp agency ID of this agency
	*/
	@Override
	public void setRootSpAgencyId(long rootSpAgencyId) {
		_agency.setRootSpAgencyId(rootSpAgencyId);
	}

	@Override
	public boolean isNew() {
		return _agency.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_agency.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _agency.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_agency.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _agency.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _agency.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_agency.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _agency.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_agency.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_agency.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_agency.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AgencyWrapper((Agency)_agency.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency) {
		return _agency.compareTo(agency);
	}

	@Override
	public int hashCode() {
		return _agency.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.legalandcontract.model.Agency> toCacheModel() {
		return _agency.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency toEscapedModel() {
		return new AgencyWrapper(_agency.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.Agency toUnescapedModel() {
		return new AgencyWrapper(_agency.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _agency.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _agency.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_agency.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AgencyWrapper)) {
			return false;
		}

		AgencyWrapper agencyWrapper = (AgencyWrapper)obj;

		if (Validator.equals(_agency, agencyWrapper._agency)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _agency.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Agency getWrappedAgency() {
		return _agency;
	}

	@Override
	public Agency getWrappedModel() {
		return _agency;
	}

	@Override
	public void resetOriginalValues() {
		_agency.resetOriginalValues();
	}

	private Agency _agency;
}