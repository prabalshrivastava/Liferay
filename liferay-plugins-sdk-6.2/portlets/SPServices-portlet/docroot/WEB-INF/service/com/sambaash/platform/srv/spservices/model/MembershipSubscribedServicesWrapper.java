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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MembershipSubscribedServices}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscribedServices
 * @generated
 */
public class MembershipSubscribedServicesWrapper
	implements MembershipSubscribedServices,
		ModelWrapper<MembershipSubscribedServices> {
	public MembershipSubscribedServicesWrapper(
		MembershipSubscribedServices membershipSubscribedServices) {
		_membershipSubscribedServices = membershipSubscribedServices;
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipSubscribedServices.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipSubscribedServices.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mssId", getMssId());
		attributes.put("userid", getUserid());
		attributes.put("companyId", getCompanyId());
		attributes.put("scId", getScId());
		attributes.put("scName", getScName());
		attributes.put("count", getCount());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());
		attributes.put("dateAdded", getDateAdded());
		attributes.put("dateModified", getDateModified());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("effectiveFromDate", getEffectiveFromDate());
		attributes.put("effectiveToDate", getEffectiveToDate());
		attributes.put("paramFrom", getParamFrom());
		attributes.put("paramUpto", getParamUpto());
		attributes.put("duration", getDuration());
		attributes.put("durationType", getDurationType());
		attributes.put("serviceCharges", getServiceCharges());
		attributes.put("serviceChargesCurrency", getServiceChargesCurrency());
		attributes.put("serviceChargesPeriod", getServiceChargesPeriod());
		attributes.put("serviceChargesPeriodType", getServiceChargesPeriodType());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());
		attributes.put("extra6", getExtra6());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mssId = (Long)attributes.get("mssId");

		if (mssId != null) {
			setMssId(mssId);
		}

		Long userid = (Long)attributes.get("userid");

		if (userid != null) {
			setUserid(userid);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String scId = (String)attributes.get("scId");

		if (scId != null) {
			setScId(scId);
		}

		String scName = (String)attributes.get("scName");

		if (scName != null) {
			setScName(scName);
		}

		String count = (String)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date dateAdded = (Date)attributes.get("dateAdded");

		if (dateAdded != null) {
			setDateAdded(dateAdded);
		}

		Date dateModified = (Date)attributes.get("dateModified");

		if (dateModified != null) {
			setDateModified(dateModified);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date effectiveFromDate = (Date)attributes.get("effectiveFromDate");

		if (effectiveFromDate != null) {
			setEffectiveFromDate(effectiveFromDate);
		}

		Date effectiveToDate = (Date)attributes.get("effectiveToDate");

		if (effectiveToDate != null) {
			setEffectiveToDate(effectiveToDate);
		}

		String paramFrom = (String)attributes.get("paramFrom");

		if (paramFrom != null) {
			setParamFrom(paramFrom);
		}

		String paramUpto = (String)attributes.get("paramUpto");

		if (paramUpto != null) {
			setParamUpto(paramUpto);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String durationType = (String)attributes.get("durationType");

		if (durationType != null) {
			setDurationType(durationType);
		}

		Float serviceCharges = (Float)attributes.get("serviceCharges");

		if (serviceCharges != null) {
			setServiceCharges(serviceCharges);
		}

		String serviceChargesCurrency = (String)attributes.get(
				"serviceChargesCurrency");

		if (serviceChargesCurrency != null) {
			setServiceChargesCurrency(serviceChargesCurrency);
		}

		String serviceChargesPeriod = (String)attributes.get(
				"serviceChargesPeriod");

		if (serviceChargesPeriod != null) {
			setServiceChargesPeriod(serviceChargesPeriod);
		}

		String serviceChargesPeriodType = (String)attributes.get(
				"serviceChargesPeriodType");

		if (serviceChargesPeriodType != null) {
			setServiceChargesPeriodType(serviceChargesPeriodType);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}

		String extra3 = (String)attributes.get("extra3");

		if (extra3 != null) {
			setExtra3(extra3);
		}

		String extra4 = (String)attributes.get("extra4");

		if (extra4 != null) {
			setExtra4(extra4);
		}

		Date extra5 = (Date)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}

		Date extra6 = (Date)attributes.get("extra6");

		if (extra6 != null) {
			setExtra6(extra6);
		}
	}

	/**
	* Returns the primary key of this membership subscribed services.
	*
	* @return the primary key of this membership subscribed services
	*/
	@Override
	public long getPrimaryKey() {
		return _membershipSubscribedServices.getPrimaryKey();
	}

	/**
	* Sets the primary key of this membership subscribed services.
	*
	* @param primaryKey the primary key of this membership subscribed services
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_membershipSubscribedServices.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mss ID of this membership subscribed services.
	*
	* @return the mss ID of this membership subscribed services
	*/
	@Override
	public long getMssId() {
		return _membershipSubscribedServices.getMssId();
	}

	/**
	* Sets the mss ID of this membership subscribed services.
	*
	* @param mssId the mss ID of this membership subscribed services
	*/
	@Override
	public void setMssId(long mssId) {
		_membershipSubscribedServices.setMssId(mssId);
	}

	/**
	* Returns the userid of this membership subscribed services.
	*
	* @return the userid of this membership subscribed services
	*/
	@Override
	public long getUserid() {
		return _membershipSubscribedServices.getUserid();
	}

	/**
	* Sets the userid of this membership subscribed services.
	*
	* @param userid the userid of this membership subscribed services
	*/
	@Override
	public void setUserid(long userid) {
		_membershipSubscribedServices.setUserid(userid);
	}

	/**
	* Returns the company ID of this membership subscribed services.
	*
	* @return the company ID of this membership subscribed services
	*/
	@Override
	public long getCompanyId() {
		return _membershipSubscribedServices.getCompanyId();
	}

	/**
	* Sets the company ID of this membership subscribed services.
	*
	* @param companyId the company ID of this membership subscribed services
	*/
	@Override
	public void setCompanyId(long companyId) {
		_membershipSubscribedServices.setCompanyId(companyId);
	}

	/**
	* Returns the sc ID of this membership subscribed services.
	*
	* @return the sc ID of this membership subscribed services
	*/
	@Override
	public java.lang.String getScId() {
		return _membershipSubscribedServices.getScId();
	}

	/**
	* Sets the sc ID of this membership subscribed services.
	*
	* @param scId the sc ID of this membership subscribed services
	*/
	@Override
	public void setScId(java.lang.String scId) {
		_membershipSubscribedServices.setScId(scId);
	}

	/**
	* Returns the sc name of this membership subscribed services.
	*
	* @return the sc name of this membership subscribed services
	*/
	@Override
	public java.lang.String getScName() {
		return _membershipSubscribedServices.getScName();
	}

	/**
	* Sets the sc name of this membership subscribed services.
	*
	* @param scName the sc name of this membership subscribed services
	*/
	@Override
	public void setScName(java.lang.String scName) {
		_membershipSubscribedServices.setScName(scName);
	}

	/**
	* Returns the count of this membership subscribed services.
	*
	* @return the count of this membership subscribed services
	*/
	@Override
	public java.lang.String getCount() {
		return _membershipSubscribedServices.getCount();
	}

	/**
	* Sets the count of this membership subscribed services.
	*
	* @param count the count of this membership subscribed services
	*/
	@Override
	public void setCount(java.lang.String count) {
		_membershipSubscribedServices.setCount(count);
	}

	/**
	* Returns the status of this membership subscribed services.
	*
	* @return the status of this membership subscribed services
	*/
	@Override
	public java.lang.String getStatus() {
		return _membershipSubscribedServices.getStatus();
	}

	/**
	* Sets the status of this membership subscribed services.
	*
	* @param status the status of this membership subscribed services
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_membershipSubscribedServices.setStatus(status);
	}

	/**
	* Returns the description of this membership subscribed services.
	*
	* @return the description of this membership subscribed services
	*/
	@Override
	public java.lang.String getDescription() {
		return _membershipSubscribedServices.getDescription();
	}

	/**
	* Sets the description of this membership subscribed services.
	*
	* @param description the description of this membership subscribed services
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_membershipSubscribedServices.setDescription(description);
	}

	/**
	* Returns the date added of this membership subscribed services.
	*
	* @return the date added of this membership subscribed services
	*/
	@Override
	public java.util.Date getDateAdded() {
		return _membershipSubscribedServices.getDateAdded();
	}

	/**
	* Sets the date added of this membership subscribed services.
	*
	* @param dateAdded the date added of this membership subscribed services
	*/
	@Override
	public void setDateAdded(java.util.Date dateAdded) {
		_membershipSubscribedServices.setDateAdded(dateAdded);
	}

	/**
	* Returns the date modified of this membership subscribed services.
	*
	* @return the date modified of this membership subscribed services
	*/
	@Override
	public java.util.Date getDateModified() {
		return _membershipSubscribedServices.getDateModified();
	}

	/**
	* Sets the date modified of this membership subscribed services.
	*
	* @param dateModified the date modified of this membership subscribed services
	*/
	@Override
	public void setDateModified(java.util.Date dateModified) {
		_membershipSubscribedServices.setDateModified(dateModified);
	}

	/**
	* Returns the created by of this membership subscribed services.
	*
	* @return the created by of this membership subscribed services
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _membershipSubscribedServices.getCreatedBy();
	}

	/**
	* Sets the created by of this membership subscribed services.
	*
	* @param createdBy the created by of this membership subscribed services
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_membershipSubscribedServices.setCreatedBy(createdBy);
	}

	/**
	* Returns the modified by of this membership subscribed services.
	*
	* @return the modified by of this membership subscribed services
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _membershipSubscribedServices.getModifiedBy();
	}

	/**
	* Sets the modified by of this membership subscribed services.
	*
	* @param modifiedBy the modified by of this membership subscribed services
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_membershipSubscribedServices.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the effective from date of this membership subscribed services.
	*
	* @return the effective from date of this membership subscribed services
	*/
	@Override
	public java.util.Date getEffectiveFromDate() {
		return _membershipSubscribedServices.getEffectiveFromDate();
	}

	/**
	* Sets the effective from date of this membership subscribed services.
	*
	* @param effectiveFromDate the effective from date of this membership subscribed services
	*/
	@Override
	public void setEffectiveFromDate(java.util.Date effectiveFromDate) {
		_membershipSubscribedServices.setEffectiveFromDate(effectiveFromDate);
	}

	/**
	* Returns the effective to date of this membership subscribed services.
	*
	* @return the effective to date of this membership subscribed services
	*/
	@Override
	public java.util.Date getEffectiveToDate() {
		return _membershipSubscribedServices.getEffectiveToDate();
	}

	/**
	* Sets the effective to date of this membership subscribed services.
	*
	* @param effectiveToDate the effective to date of this membership subscribed services
	*/
	@Override
	public void setEffectiveToDate(java.util.Date effectiveToDate) {
		_membershipSubscribedServices.setEffectiveToDate(effectiveToDate);
	}

	/**
	* Returns the param from of this membership subscribed services.
	*
	* @return the param from of this membership subscribed services
	*/
	@Override
	public java.lang.String getParamFrom() {
		return _membershipSubscribedServices.getParamFrom();
	}

	/**
	* Sets the param from of this membership subscribed services.
	*
	* @param paramFrom the param from of this membership subscribed services
	*/
	@Override
	public void setParamFrom(java.lang.String paramFrom) {
		_membershipSubscribedServices.setParamFrom(paramFrom);
	}

	/**
	* Returns the param upto of this membership subscribed services.
	*
	* @return the param upto of this membership subscribed services
	*/
	@Override
	public java.lang.String getParamUpto() {
		return _membershipSubscribedServices.getParamUpto();
	}

	/**
	* Sets the param upto of this membership subscribed services.
	*
	* @param paramUpto the param upto of this membership subscribed services
	*/
	@Override
	public void setParamUpto(java.lang.String paramUpto) {
		_membershipSubscribedServices.setParamUpto(paramUpto);
	}

	/**
	* Returns the duration of this membership subscribed services.
	*
	* @return the duration of this membership subscribed services
	*/
	@Override
	public java.lang.String getDuration() {
		return _membershipSubscribedServices.getDuration();
	}

	/**
	* Sets the duration of this membership subscribed services.
	*
	* @param duration the duration of this membership subscribed services
	*/
	@Override
	public void setDuration(java.lang.String duration) {
		_membershipSubscribedServices.setDuration(duration);
	}

	/**
	* Returns the duration type of this membership subscribed services.
	*
	* @return the duration type of this membership subscribed services
	*/
	@Override
	public java.lang.String getDurationType() {
		return _membershipSubscribedServices.getDurationType();
	}

	/**
	* Sets the duration type of this membership subscribed services.
	*
	* @param durationType the duration type of this membership subscribed services
	*/
	@Override
	public void setDurationType(java.lang.String durationType) {
		_membershipSubscribedServices.setDurationType(durationType);
	}

	/**
	* Returns the service charges of this membership subscribed services.
	*
	* @return the service charges of this membership subscribed services
	*/
	@Override
	public float getServiceCharges() {
		return _membershipSubscribedServices.getServiceCharges();
	}

	/**
	* Sets the service charges of this membership subscribed services.
	*
	* @param serviceCharges the service charges of this membership subscribed services
	*/
	@Override
	public void setServiceCharges(float serviceCharges) {
		_membershipSubscribedServices.setServiceCharges(serviceCharges);
	}

	/**
	* Returns the service charges currency of this membership subscribed services.
	*
	* @return the service charges currency of this membership subscribed services
	*/
	@Override
	public java.lang.String getServiceChargesCurrency() {
		return _membershipSubscribedServices.getServiceChargesCurrency();
	}

	/**
	* Sets the service charges currency of this membership subscribed services.
	*
	* @param serviceChargesCurrency the service charges currency of this membership subscribed services
	*/
	@Override
	public void setServiceChargesCurrency(
		java.lang.String serviceChargesCurrency) {
		_membershipSubscribedServices.setServiceChargesCurrency(serviceChargesCurrency);
	}

	/**
	* Returns the service charges period of this membership subscribed services.
	*
	* @return the service charges period of this membership subscribed services
	*/
	@Override
	public java.lang.String getServiceChargesPeriod() {
		return _membershipSubscribedServices.getServiceChargesPeriod();
	}

	/**
	* Sets the service charges period of this membership subscribed services.
	*
	* @param serviceChargesPeriod the service charges period of this membership subscribed services
	*/
	@Override
	public void setServiceChargesPeriod(java.lang.String serviceChargesPeriod) {
		_membershipSubscribedServices.setServiceChargesPeriod(serviceChargesPeriod);
	}

	/**
	* Returns the service charges period type of this membership subscribed services.
	*
	* @return the service charges period type of this membership subscribed services
	*/
	@Override
	public java.lang.String getServiceChargesPeriodType() {
		return _membershipSubscribedServices.getServiceChargesPeriodType();
	}

	/**
	* Sets the service charges period type of this membership subscribed services.
	*
	* @param serviceChargesPeriodType the service charges period type of this membership subscribed services
	*/
	@Override
	public void setServiceChargesPeriodType(
		java.lang.String serviceChargesPeriodType) {
		_membershipSubscribedServices.setServiceChargesPeriodType(serviceChargesPeriodType);
	}

	/**
	* Returns the extra1 of this membership subscribed services.
	*
	* @return the extra1 of this membership subscribed services
	*/
	@Override
	public java.lang.String getExtra1() {
		return _membershipSubscribedServices.getExtra1();
	}

	/**
	* Sets the extra1 of this membership subscribed services.
	*
	* @param extra1 the extra1 of this membership subscribed services
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_membershipSubscribedServices.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this membership subscribed services.
	*
	* @return the extra2 of this membership subscribed services
	*/
	@Override
	public java.lang.String getExtra2() {
		return _membershipSubscribedServices.getExtra2();
	}

	/**
	* Sets the extra2 of this membership subscribed services.
	*
	* @param extra2 the extra2 of this membership subscribed services
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_membershipSubscribedServices.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this membership subscribed services.
	*
	* @return the extra3 of this membership subscribed services
	*/
	@Override
	public java.lang.String getExtra3() {
		return _membershipSubscribedServices.getExtra3();
	}

	/**
	* Sets the extra3 of this membership subscribed services.
	*
	* @param extra3 the extra3 of this membership subscribed services
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_membershipSubscribedServices.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this membership subscribed services.
	*
	* @return the extra4 of this membership subscribed services
	*/
	@Override
	public java.lang.String getExtra4() {
		return _membershipSubscribedServices.getExtra4();
	}

	/**
	* Sets the extra4 of this membership subscribed services.
	*
	* @param extra4 the extra4 of this membership subscribed services
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_membershipSubscribedServices.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this membership subscribed services.
	*
	* @return the extra5 of this membership subscribed services
	*/
	@Override
	public java.util.Date getExtra5() {
		return _membershipSubscribedServices.getExtra5();
	}

	/**
	* Sets the extra5 of this membership subscribed services.
	*
	* @param extra5 the extra5 of this membership subscribed services
	*/
	@Override
	public void setExtra5(java.util.Date extra5) {
		_membershipSubscribedServices.setExtra5(extra5);
	}

	/**
	* Returns the extra6 of this membership subscribed services.
	*
	* @return the extra6 of this membership subscribed services
	*/
	@Override
	public java.util.Date getExtra6() {
		return _membershipSubscribedServices.getExtra6();
	}

	/**
	* Sets the extra6 of this membership subscribed services.
	*
	* @param extra6 the extra6 of this membership subscribed services
	*/
	@Override
	public void setExtra6(java.util.Date extra6) {
		_membershipSubscribedServices.setExtra6(extra6);
	}

	@Override
	public boolean isNew() {
		return _membershipSubscribedServices.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_membershipSubscribedServices.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _membershipSubscribedServices.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_membershipSubscribedServices.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _membershipSubscribedServices.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _membershipSubscribedServices.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_membershipSubscribedServices.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _membershipSubscribedServices.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_membershipSubscribedServices.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_membershipSubscribedServices.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_membershipSubscribedServices.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MembershipSubscribedServicesWrapper((MembershipSubscribedServices)_membershipSubscribedServices.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices) {
		return _membershipSubscribedServices.compareTo(membershipSubscribedServices);
	}

	@Override
	public int hashCode() {
		return _membershipSubscribedServices.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> toCacheModel() {
		return _membershipSubscribedServices.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices toEscapedModel() {
		return new MembershipSubscribedServicesWrapper(_membershipSubscribedServices.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices toUnescapedModel() {
		return new MembershipSubscribedServicesWrapper(_membershipSubscribedServices.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _membershipSubscribedServices.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _membershipSubscribedServices.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipSubscribedServices.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MembershipSubscribedServicesWrapper)) {
			return false;
		}

		MembershipSubscribedServicesWrapper membershipSubscribedServicesWrapper = (MembershipSubscribedServicesWrapper)obj;

		if (Validator.equals(_membershipSubscribedServices,
					membershipSubscribedServicesWrapper._membershipSubscribedServices)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MembershipSubscribedServices getWrappedMembershipSubscribedServices() {
		return _membershipSubscribedServices;
	}

	@Override
	public MembershipSubscribedServices getWrappedModel() {
		return _membershipSubscribedServices;
	}

	@Override
	public void resetOriginalValues() {
		_membershipSubscribedServices.resetOriginalValues();
	}

	private MembershipSubscribedServices _membershipSubscribedServices;
}