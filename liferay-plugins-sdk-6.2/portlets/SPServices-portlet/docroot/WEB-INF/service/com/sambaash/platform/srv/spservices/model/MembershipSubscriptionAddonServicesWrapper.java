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
 * This class is a wrapper for {@link MembershipSubscriptionAddonServices}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionAddonServices
 * @generated
 */
public class MembershipSubscriptionAddonServicesWrapper
	implements MembershipSubscriptionAddonServices,
		ModelWrapper<MembershipSubscriptionAddonServices> {
	public MembershipSubscriptionAddonServicesWrapper(
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices) {
		_membershipSubscriptionAddonServices = membershipSubscriptionAddonServices;
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipSubscriptionAddonServices.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipSubscriptionAddonServices.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("msAddonId", getMsAddonId());
		attributes.put("msId", getMsId());
		attributes.put("scId", getScId());
		attributes.put("scName", getScName());
		attributes.put("paramType", getParamType());
		attributes.put("paramFrom", getParamFrom());
		attributes.put("paramUpto", getParamUpto());
		attributes.put("duration", getDuration());
		attributes.put("durationType", getDurationType());
		attributes.put("serviceCharges", getServiceCharges());
		attributes.put("serviceChargesCurrency", getServiceChargesCurrency());
		attributes.put("serviceChargesPeriod", getServiceChargesPeriod());
		attributes.put("serviceChargesPeriodType", getServiceChargesPeriodType());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());
		attributes.put("effectiveFromDate", getEffectiveFromDate());
		attributes.put("effectiveToDate", getEffectiveToDate());
		attributes.put("dateAdded", getDateAdded());
		attributes.put("dateModified", getDateModified());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
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
		Long msAddonId = (Long)attributes.get("msAddonId");

		if (msAddonId != null) {
			setMsAddonId(msAddonId);
		}

		Long msId = (Long)attributes.get("msId");

		if (msId != null) {
			setMsId(msId);
		}

		String scId = (String)attributes.get("scId");

		if (scId != null) {
			setScId(scId);
		}

		String scName = (String)attributes.get("scName");

		if (scName != null) {
			setScName(scName);
		}

		String paramType = (String)attributes.get("paramType");

		if (paramType != null) {
			setParamType(paramType);
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

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date effectiveFromDate = (Date)attributes.get("effectiveFromDate");

		if (effectiveFromDate != null) {
			setEffectiveFromDate(effectiveFromDate);
		}

		Date effectiveToDate = (Date)attributes.get("effectiveToDate");

		if (effectiveToDate != null) {
			setEffectiveToDate(effectiveToDate);
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
	* Returns the primary key of this membership subscription addon services.
	*
	* @return the primary key of this membership subscription addon services
	*/
	@Override
	public long getPrimaryKey() {
		return _membershipSubscriptionAddonServices.getPrimaryKey();
	}

	/**
	* Sets the primary key of this membership subscription addon services.
	*
	* @param primaryKey the primary key of this membership subscription addon services
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_membershipSubscriptionAddonServices.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ms addon ID of this membership subscription addon services.
	*
	* @return the ms addon ID of this membership subscription addon services
	*/
	@Override
	public long getMsAddonId() {
		return _membershipSubscriptionAddonServices.getMsAddonId();
	}

	/**
	* Sets the ms addon ID of this membership subscription addon services.
	*
	* @param msAddonId the ms addon ID of this membership subscription addon services
	*/
	@Override
	public void setMsAddonId(long msAddonId) {
		_membershipSubscriptionAddonServices.setMsAddonId(msAddonId);
	}

	/**
	* Returns the ms ID of this membership subscription addon services.
	*
	* @return the ms ID of this membership subscription addon services
	*/
	@Override
	public long getMsId() {
		return _membershipSubscriptionAddonServices.getMsId();
	}

	/**
	* Sets the ms ID of this membership subscription addon services.
	*
	* @param msId the ms ID of this membership subscription addon services
	*/
	@Override
	public void setMsId(long msId) {
		_membershipSubscriptionAddonServices.setMsId(msId);
	}

	/**
	* Returns the sc ID of this membership subscription addon services.
	*
	* @return the sc ID of this membership subscription addon services
	*/
	@Override
	public java.lang.String getScId() {
		return _membershipSubscriptionAddonServices.getScId();
	}

	/**
	* Sets the sc ID of this membership subscription addon services.
	*
	* @param scId the sc ID of this membership subscription addon services
	*/
	@Override
	public void setScId(java.lang.String scId) {
		_membershipSubscriptionAddonServices.setScId(scId);
	}

	/**
	* Returns the sc name of this membership subscription addon services.
	*
	* @return the sc name of this membership subscription addon services
	*/
	@Override
	public java.lang.String getScName() {
		return _membershipSubscriptionAddonServices.getScName();
	}

	/**
	* Sets the sc name of this membership subscription addon services.
	*
	* @param scName the sc name of this membership subscription addon services
	*/
	@Override
	public void setScName(java.lang.String scName) {
		_membershipSubscriptionAddonServices.setScName(scName);
	}

	/**
	* Returns the param type of this membership subscription addon services.
	*
	* @return the param type of this membership subscription addon services
	*/
	@Override
	public java.lang.String getParamType() {
		return _membershipSubscriptionAddonServices.getParamType();
	}

	/**
	* Sets the param type of this membership subscription addon services.
	*
	* @param paramType the param type of this membership subscription addon services
	*/
	@Override
	public void setParamType(java.lang.String paramType) {
		_membershipSubscriptionAddonServices.setParamType(paramType);
	}

	/**
	* Returns the param from of this membership subscription addon services.
	*
	* @return the param from of this membership subscription addon services
	*/
	@Override
	public java.lang.String getParamFrom() {
		return _membershipSubscriptionAddonServices.getParamFrom();
	}

	/**
	* Sets the param from of this membership subscription addon services.
	*
	* @param paramFrom the param from of this membership subscription addon services
	*/
	@Override
	public void setParamFrom(java.lang.String paramFrom) {
		_membershipSubscriptionAddonServices.setParamFrom(paramFrom);
	}

	/**
	* Returns the param upto of this membership subscription addon services.
	*
	* @return the param upto of this membership subscription addon services
	*/
	@Override
	public java.lang.String getParamUpto() {
		return _membershipSubscriptionAddonServices.getParamUpto();
	}

	/**
	* Sets the param upto of this membership subscription addon services.
	*
	* @param paramUpto the param upto of this membership subscription addon services
	*/
	@Override
	public void setParamUpto(java.lang.String paramUpto) {
		_membershipSubscriptionAddonServices.setParamUpto(paramUpto);
	}

	/**
	* Returns the duration of this membership subscription addon services.
	*
	* @return the duration of this membership subscription addon services
	*/
	@Override
	public java.lang.String getDuration() {
		return _membershipSubscriptionAddonServices.getDuration();
	}

	/**
	* Sets the duration of this membership subscription addon services.
	*
	* @param duration the duration of this membership subscription addon services
	*/
	@Override
	public void setDuration(java.lang.String duration) {
		_membershipSubscriptionAddonServices.setDuration(duration);
	}

	/**
	* Returns the duration type of this membership subscription addon services.
	*
	* @return the duration type of this membership subscription addon services
	*/
	@Override
	public java.lang.String getDurationType() {
		return _membershipSubscriptionAddonServices.getDurationType();
	}

	/**
	* Sets the duration type of this membership subscription addon services.
	*
	* @param durationType the duration type of this membership subscription addon services
	*/
	@Override
	public void setDurationType(java.lang.String durationType) {
		_membershipSubscriptionAddonServices.setDurationType(durationType);
	}

	/**
	* Returns the service charges of this membership subscription addon services.
	*
	* @return the service charges of this membership subscription addon services
	*/
	@Override
	public float getServiceCharges() {
		return _membershipSubscriptionAddonServices.getServiceCharges();
	}

	/**
	* Sets the service charges of this membership subscription addon services.
	*
	* @param serviceCharges the service charges of this membership subscription addon services
	*/
	@Override
	public void setServiceCharges(float serviceCharges) {
		_membershipSubscriptionAddonServices.setServiceCharges(serviceCharges);
	}

	/**
	* Returns the service charges currency of this membership subscription addon services.
	*
	* @return the service charges currency of this membership subscription addon services
	*/
	@Override
	public java.lang.String getServiceChargesCurrency() {
		return _membershipSubscriptionAddonServices.getServiceChargesCurrency();
	}

	/**
	* Sets the service charges currency of this membership subscription addon services.
	*
	* @param serviceChargesCurrency the service charges currency of this membership subscription addon services
	*/
	@Override
	public void setServiceChargesCurrency(
		java.lang.String serviceChargesCurrency) {
		_membershipSubscriptionAddonServices.setServiceChargesCurrency(serviceChargesCurrency);
	}

	/**
	* Returns the service charges period of this membership subscription addon services.
	*
	* @return the service charges period of this membership subscription addon services
	*/
	@Override
	public java.lang.String getServiceChargesPeriod() {
		return _membershipSubscriptionAddonServices.getServiceChargesPeriod();
	}

	/**
	* Sets the service charges period of this membership subscription addon services.
	*
	* @param serviceChargesPeriod the service charges period of this membership subscription addon services
	*/
	@Override
	public void setServiceChargesPeriod(java.lang.String serviceChargesPeriod) {
		_membershipSubscriptionAddonServices.setServiceChargesPeriod(serviceChargesPeriod);
	}

	/**
	* Returns the service charges period type of this membership subscription addon services.
	*
	* @return the service charges period type of this membership subscription addon services
	*/
	@Override
	public java.lang.String getServiceChargesPeriodType() {
		return _membershipSubscriptionAddonServices.getServiceChargesPeriodType();
	}

	/**
	* Sets the service charges period type of this membership subscription addon services.
	*
	* @param serviceChargesPeriodType the service charges period type of this membership subscription addon services
	*/
	@Override
	public void setServiceChargesPeriodType(
		java.lang.String serviceChargesPeriodType) {
		_membershipSubscriptionAddonServices.setServiceChargesPeriodType(serviceChargesPeriodType);
	}

	/**
	* Returns the status of this membership subscription addon services.
	*
	* @return the status of this membership subscription addon services
	*/
	@Override
	public java.lang.String getStatus() {
		return _membershipSubscriptionAddonServices.getStatus();
	}

	/**
	* Sets the status of this membership subscription addon services.
	*
	* @param status the status of this membership subscription addon services
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_membershipSubscriptionAddonServices.setStatus(status);
	}

	/**
	* Returns the description of this membership subscription addon services.
	*
	* @return the description of this membership subscription addon services
	*/
	@Override
	public java.lang.String getDescription() {
		return _membershipSubscriptionAddonServices.getDescription();
	}

	/**
	* Sets the description of this membership subscription addon services.
	*
	* @param description the description of this membership subscription addon services
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_membershipSubscriptionAddonServices.setDescription(description);
	}

	/**
	* Returns the effective from date of this membership subscription addon services.
	*
	* @return the effective from date of this membership subscription addon services
	*/
	@Override
	public java.util.Date getEffectiveFromDate() {
		return _membershipSubscriptionAddonServices.getEffectiveFromDate();
	}

	/**
	* Sets the effective from date of this membership subscription addon services.
	*
	* @param effectiveFromDate the effective from date of this membership subscription addon services
	*/
	@Override
	public void setEffectiveFromDate(java.util.Date effectiveFromDate) {
		_membershipSubscriptionAddonServices.setEffectiveFromDate(effectiveFromDate);
	}

	/**
	* Returns the effective to date of this membership subscription addon services.
	*
	* @return the effective to date of this membership subscription addon services
	*/
	@Override
	public java.util.Date getEffectiveToDate() {
		return _membershipSubscriptionAddonServices.getEffectiveToDate();
	}

	/**
	* Sets the effective to date of this membership subscription addon services.
	*
	* @param effectiveToDate the effective to date of this membership subscription addon services
	*/
	@Override
	public void setEffectiveToDate(java.util.Date effectiveToDate) {
		_membershipSubscriptionAddonServices.setEffectiveToDate(effectiveToDate);
	}

	/**
	* Returns the date added of this membership subscription addon services.
	*
	* @return the date added of this membership subscription addon services
	*/
	@Override
	public java.util.Date getDateAdded() {
		return _membershipSubscriptionAddonServices.getDateAdded();
	}

	/**
	* Sets the date added of this membership subscription addon services.
	*
	* @param dateAdded the date added of this membership subscription addon services
	*/
	@Override
	public void setDateAdded(java.util.Date dateAdded) {
		_membershipSubscriptionAddonServices.setDateAdded(dateAdded);
	}

	/**
	* Returns the date modified of this membership subscription addon services.
	*
	* @return the date modified of this membership subscription addon services
	*/
	@Override
	public java.util.Date getDateModified() {
		return _membershipSubscriptionAddonServices.getDateModified();
	}

	/**
	* Sets the date modified of this membership subscription addon services.
	*
	* @param dateModified the date modified of this membership subscription addon services
	*/
	@Override
	public void setDateModified(java.util.Date dateModified) {
		_membershipSubscriptionAddonServices.setDateModified(dateModified);
	}

	/**
	* Returns the created by of this membership subscription addon services.
	*
	* @return the created by of this membership subscription addon services
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _membershipSubscriptionAddonServices.getCreatedBy();
	}

	/**
	* Sets the created by of this membership subscription addon services.
	*
	* @param createdBy the created by of this membership subscription addon services
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_membershipSubscriptionAddonServices.setCreatedBy(createdBy);
	}

	/**
	* Returns the modified by of this membership subscription addon services.
	*
	* @return the modified by of this membership subscription addon services
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _membershipSubscriptionAddonServices.getModifiedBy();
	}

	/**
	* Sets the modified by of this membership subscription addon services.
	*
	* @param modifiedBy the modified by of this membership subscription addon services
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_membershipSubscriptionAddonServices.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the extra1 of this membership subscription addon services.
	*
	* @return the extra1 of this membership subscription addon services
	*/
	@Override
	public java.lang.String getExtra1() {
		return _membershipSubscriptionAddonServices.getExtra1();
	}

	/**
	* Sets the extra1 of this membership subscription addon services.
	*
	* @param extra1 the extra1 of this membership subscription addon services
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_membershipSubscriptionAddonServices.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this membership subscription addon services.
	*
	* @return the extra2 of this membership subscription addon services
	*/
	@Override
	public java.lang.String getExtra2() {
		return _membershipSubscriptionAddonServices.getExtra2();
	}

	/**
	* Sets the extra2 of this membership subscription addon services.
	*
	* @param extra2 the extra2 of this membership subscription addon services
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_membershipSubscriptionAddonServices.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this membership subscription addon services.
	*
	* @return the extra3 of this membership subscription addon services
	*/
	@Override
	public java.lang.String getExtra3() {
		return _membershipSubscriptionAddonServices.getExtra3();
	}

	/**
	* Sets the extra3 of this membership subscription addon services.
	*
	* @param extra3 the extra3 of this membership subscription addon services
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_membershipSubscriptionAddonServices.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this membership subscription addon services.
	*
	* @return the extra4 of this membership subscription addon services
	*/
	@Override
	public java.lang.String getExtra4() {
		return _membershipSubscriptionAddonServices.getExtra4();
	}

	/**
	* Sets the extra4 of this membership subscription addon services.
	*
	* @param extra4 the extra4 of this membership subscription addon services
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_membershipSubscriptionAddonServices.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this membership subscription addon services.
	*
	* @return the extra5 of this membership subscription addon services
	*/
	@Override
	public java.util.Date getExtra5() {
		return _membershipSubscriptionAddonServices.getExtra5();
	}

	/**
	* Sets the extra5 of this membership subscription addon services.
	*
	* @param extra5 the extra5 of this membership subscription addon services
	*/
	@Override
	public void setExtra5(java.util.Date extra5) {
		_membershipSubscriptionAddonServices.setExtra5(extra5);
	}

	/**
	* Returns the extra6 of this membership subscription addon services.
	*
	* @return the extra6 of this membership subscription addon services
	*/
	@Override
	public java.util.Date getExtra6() {
		return _membershipSubscriptionAddonServices.getExtra6();
	}

	/**
	* Sets the extra6 of this membership subscription addon services.
	*
	* @param extra6 the extra6 of this membership subscription addon services
	*/
	@Override
	public void setExtra6(java.util.Date extra6) {
		_membershipSubscriptionAddonServices.setExtra6(extra6);
	}

	@Override
	public boolean isNew() {
		return _membershipSubscriptionAddonServices.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_membershipSubscriptionAddonServices.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _membershipSubscriptionAddonServices.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_membershipSubscriptionAddonServices.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _membershipSubscriptionAddonServices.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _membershipSubscriptionAddonServices.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_membershipSubscriptionAddonServices.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _membershipSubscriptionAddonServices.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_membershipSubscriptionAddonServices.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_membershipSubscriptionAddonServices.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_membershipSubscriptionAddonServices.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MembershipSubscriptionAddonServicesWrapper((MembershipSubscriptionAddonServices)_membershipSubscriptionAddonServices.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices membershipSubscriptionAddonServices) {
		return _membershipSubscriptionAddonServices.compareTo(membershipSubscriptionAddonServices);
	}

	@Override
	public int hashCode() {
		return _membershipSubscriptionAddonServices.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices> toCacheModel() {
		return _membershipSubscriptionAddonServices.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices toEscapedModel() {
		return new MembershipSubscriptionAddonServicesWrapper(_membershipSubscriptionAddonServices.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices toUnescapedModel() {
		return new MembershipSubscriptionAddonServicesWrapper(_membershipSubscriptionAddonServices.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _membershipSubscriptionAddonServices.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _membershipSubscriptionAddonServices.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipSubscriptionAddonServices.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MembershipSubscriptionAddonServicesWrapper)) {
			return false;
		}

		MembershipSubscriptionAddonServicesWrapper membershipSubscriptionAddonServicesWrapper =
			(MembershipSubscriptionAddonServicesWrapper)obj;

		if (Validator.equals(_membershipSubscriptionAddonServices,
					membershipSubscriptionAddonServicesWrapper._membershipSubscriptionAddonServices)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MembershipSubscriptionAddonServices getWrappedMembershipSubscriptionAddonServices() {
		return _membershipSubscriptionAddonServices;
	}

	@Override
	public MembershipSubscriptionAddonServices getWrappedModel() {
		return _membershipSubscriptionAddonServices;
	}

	@Override
	public void resetOriginalValues() {
		_membershipSubscriptionAddonServices.resetOriginalValues();
	}

	private MembershipSubscriptionAddonServices _membershipSubscriptionAddonServices;
}