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
 * This class is a wrapper for {@link MembershipPackageAddonServices}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageAddonServices
 * @generated
 */
public class MembershipPackageAddonServicesWrapper
	implements MembershipPackageAddonServices,
		ModelWrapper<MembershipPackageAddonServices> {
	public MembershipPackageAddonServicesWrapper(
		MembershipPackageAddonServices membershipPackageAddonServices) {
		_membershipPackageAddonServices = membershipPackageAddonServices;
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackageAddonServices.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackageAddonServices.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mpAddonId", getMpAddonId());
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
		Long mpAddonId = (Long)attributes.get("mpAddonId");

		if (mpAddonId != null) {
			setMpAddonId(mpAddonId);
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
	* Returns the primary key of this membership package addon services.
	*
	* @return the primary key of this membership package addon services
	*/
	@Override
	public long getPrimaryKey() {
		return _membershipPackageAddonServices.getPrimaryKey();
	}

	/**
	* Sets the primary key of this membership package addon services.
	*
	* @param primaryKey the primary key of this membership package addon services
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_membershipPackageAddonServices.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mp addon ID of this membership package addon services.
	*
	* @return the mp addon ID of this membership package addon services
	*/
	@Override
	public long getMpAddonId() {
		return _membershipPackageAddonServices.getMpAddonId();
	}

	/**
	* Sets the mp addon ID of this membership package addon services.
	*
	* @param mpAddonId the mp addon ID of this membership package addon services
	*/
	@Override
	public void setMpAddonId(long mpAddonId) {
		_membershipPackageAddonServices.setMpAddonId(mpAddonId);
	}

	/**
	* Returns the sc ID of this membership package addon services.
	*
	* @return the sc ID of this membership package addon services
	*/
	@Override
	public java.lang.String getScId() {
		return _membershipPackageAddonServices.getScId();
	}

	/**
	* Sets the sc ID of this membership package addon services.
	*
	* @param scId the sc ID of this membership package addon services
	*/
	@Override
	public void setScId(java.lang.String scId) {
		_membershipPackageAddonServices.setScId(scId);
	}

	/**
	* Returns the sc name of this membership package addon services.
	*
	* @return the sc name of this membership package addon services
	*/
	@Override
	public java.lang.String getScName() {
		return _membershipPackageAddonServices.getScName();
	}

	/**
	* Sets the sc name of this membership package addon services.
	*
	* @param scName the sc name of this membership package addon services
	*/
	@Override
	public void setScName(java.lang.String scName) {
		_membershipPackageAddonServices.setScName(scName);
	}

	/**
	* Returns the param type of this membership package addon services.
	*
	* @return the param type of this membership package addon services
	*/
	@Override
	public java.lang.String getParamType() {
		return _membershipPackageAddonServices.getParamType();
	}

	/**
	* Sets the param type of this membership package addon services.
	*
	* @param paramType the param type of this membership package addon services
	*/
	@Override
	public void setParamType(java.lang.String paramType) {
		_membershipPackageAddonServices.setParamType(paramType);
	}

	/**
	* Returns the param from of this membership package addon services.
	*
	* @return the param from of this membership package addon services
	*/
	@Override
	public java.lang.String getParamFrom() {
		return _membershipPackageAddonServices.getParamFrom();
	}

	/**
	* Sets the param from of this membership package addon services.
	*
	* @param paramFrom the param from of this membership package addon services
	*/
	@Override
	public void setParamFrom(java.lang.String paramFrom) {
		_membershipPackageAddonServices.setParamFrom(paramFrom);
	}

	/**
	* Returns the param upto of this membership package addon services.
	*
	* @return the param upto of this membership package addon services
	*/
	@Override
	public java.lang.String getParamUpto() {
		return _membershipPackageAddonServices.getParamUpto();
	}

	/**
	* Sets the param upto of this membership package addon services.
	*
	* @param paramUpto the param upto of this membership package addon services
	*/
	@Override
	public void setParamUpto(java.lang.String paramUpto) {
		_membershipPackageAddonServices.setParamUpto(paramUpto);
	}

	/**
	* Returns the duration of this membership package addon services.
	*
	* @return the duration of this membership package addon services
	*/
	@Override
	public java.lang.String getDuration() {
		return _membershipPackageAddonServices.getDuration();
	}

	/**
	* Sets the duration of this membership package addon services.
	*
	* @param duration the duration of this membership package addon services
	*/
	@Override
	public void setDuration(java.lang.String duration) {
		_membershipPackageAddonServices.setDuration(duration);
	}

	/**
	* Returns the duration type of this membership package addon services.
	*
	* @return the duration type of this membership package addon services
	*/
	@Override
	public java.lang.String getDurationType() {
		return _membershipPackageAddonServices.getDurationType();
	}

	/**
	* Sets the duration type of this membership package addon services.
	*
	* @param durationType the duration type of this membership package addon services
	*/
	@Override
	public void setDurationType(java.lang.String durationType) {
		_membershipPackageAddonServices.setDurationType(durationType);
	}

	/**
	* Returns the service charges of this membership package addon services.
	*
	* @return the service charges of this membership package addon services
	*/
	@Override
	public float getServiceCharges() {
		return _membershipPackageAddonServices.getServiceCharges();
	}

	/**
	* Sets the service charges of this membership package addon services.
	*
	* @param serviceCharges the service charges of this membership package addon services
	*/
	@Override
	public void setServiceCharges(float serviceCharges) {
		_membershipPackageAddonServices.setServiceCharges(serviceCharges);
	}

	/**
	* Returns the service charges currency of this membership package addon services.
	*
	* @return the service charges currency of this membership package addon services
	*/
	@Override
	public java.lang.String getServiceChargesCurrency() {
		return _membershipPackageAddonServices.getServiceChargesCurrency();
	}

	/**
	* Sets the service charges currency of this membership package addon services.
	*
	* @param serviceChargesCurrency the service charges currency of this membership package addon services
	*/
	@Override
	public void setServiceChargesCurrency(
		java.lang.String serviceChargesCurrency) {
		_membershipPackageAddonServices.setServiceChargesCurrency(serviceChargesCurrency);
	}

	/**
	* Returns the service charges period of this membership package addon services.
	*
	* @return the service charges period of this membership package addon services
	*/
	@Override
	public java.lang.String getServiceChargesPeriod() {
		return _membershipPackageAddonServices.getServiceChargesPeriod();
	}

	/**
	* Sets the service charges period of this membership package addon services.
	*
	* @param serviceChargesPeriod the service charges period of this membership package addon services
	*/
	@Override
	public void setServiceChargesPeriod(java.lang.String serviceChargesPeriod) {
		_membershipPackageAddonServices.setServiceChargesPeriod(serviceChargesPeriod);
	}

	/**
	* Returns the service charges period type of this membership package addon services.
	*
	* @return the service charges period type of this membership package addon services
	*/
	@Override
	public java.lang.String getServiceChargesPeriodType() {
		return _membershipPackageAddonServices.getServiceChargesPeriodType();
	}

	/**
	* Sets the service charges period type of this membership package addon services.
	*
	* @param serviceChargesPeriodType the service charges period type of this membership package addon services
	*/
	@Override
	public void setServiceChargesPeriodType(
		java.lang.String serviceChargesPeriodType) {
		_membershipPackageAddonServices.setServiceChargesPeriodType(serviceChargesPeriodType);
	}

	/**
	* Returns the status of this membership package addon services.
	*
	* @return the status of this membership package addon services
	*/
	@Override
	public java.lang.String getStatus() {
		return _membershipPackageAddonServices.getStatus();
	}

	/**
	* Sets the status of this membership package addon services.
	*
	* @param status the status of this membership package addon services
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_membershipPackageAddonServices.setStatus(status);
	}

	/**
	* Returns the description of this membership package addon services.
	*
	* @return the description of this membership package addon services
	*/
	@Override
	public java.lang.String getDescription() {
		return _membershipPackageAddonServices.getDescription();
	}

	/**
	* Sets the description of this membership package addon services.
	*
	* @param description the description of this membership package addon services
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_membershipPackageAddonServices.setDescription(description);
	}

	/**
	* Returns the date added of this membership package addon services.
	*
	* @return the date added of this membership package addon services
	*/
	@Override
	public java.util.Date getDateAdded() {
		return _membershipPackageAddonServices.getDateAdded();
	}

	/**
	* Sets the date added of this membership package addon services.
	*
	* @param dateAdded the date added of this membership package addon services
	*/
	@Override
	public void setDateAdded(java.util.Date dateAdded) {
		_membershipPackageAddonServices.setDateAdded(dateAdded);
	}

	/**
	* Returns the date modified of this membership package addon services.
	*
	* @return the date modified of this membership package addon services
	*/
	@Override
	public java.util.Date getDateModified() {
		return _membershipPackageAddonServices.getDateModified();
	}

	/**
	* Sets the date modified of this membership package addon services.
	*
	* @param dateModified the date modified of this membership package addon services
	*/
	@Override
	public void setDateModified(java.util.Date dateModified) {
		_membershipPackageAddonServices.setDateModified(dateModified);
	}

	/**
	* Returns the created by of this membership package addon services.
	*
	* @return the created by of this membership package addon services
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _membershipPackageAddonServices.getCreatedBy();
	}

	/**
	* Sets the created by of this membership package addon services.
	*
	* @param createdBy the created by of this membership package addon services
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_membershipPackageAddonServices.setCreatedBy(createdBy);
	}

	/**
	* Returns the modified by of this membership package addon services.
	*
	* @return the modified by of this membership package addon services
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _membershipPackageAddonServices.getModifiedBy();
	}

	/**
	* Sets the modified by of this membership package addon services.
	*
	* @param modifiedBy the modified by of this membership package addon services
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_membershipPackageAddonServices.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the extra1 of this membership package addon services.
	*
	* @return the extra1 of this membership package addon services
	*/
	@Override
	public java.lang.String getExtra1() {
		return _membershipPackageAddonServices.getExtra1();
	}

	/**
	* Sets the extra1 of this membership package addon services.
	*
	* @param extra1 the extra1 of this membership package addon services
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_membershipPackageAddonServices.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this membership package addon services.
	*
	* @return the extra2 of this membership package addon services
	*/
	@Override
	public java.lang.String getExtra2() {
		return _membershipPackageAddonServices.getExtra2();
	}

	/**
	* Sets the extra2 of this membership package addon services.
	*
	* @param extra2 the extra2 of this membership package addon services
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_membershipPackageAddonServices.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this membership package addon services.
	*
	* @return the extra3 of this membership package addon services
	*/
	@Override
	public java.lang.String getExtra3() {
		return _membershipPackageAddonServices.getExtra3();
	}

	/**
	* Sets the extra3 of this membership package addon services.
	*
	* @param extra3 the extra3 of this membership package addon services
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_membershipPackageAddonServices.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this membership package addon services.
	*
	* @return the extra4 of this membership package addon services
	*/
	@Override
	public java.lang.String getExtra4() {
		return _membershipPackageAddonServices.getExtra4();
	}

	/**
	* Sets the extra4 of this membership package addon services.
	*
	* @param extra4 the extra4 of this membership package addon services
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_membershipPackageAddonServices.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this membership package addon services.
	*
	* @return the extra5 of this membership package addon services
	*/
	@Override
	public java.util.Date getExtra5() {
		return _membershipPackageAddonServices.getExtra5();
	}

	/**
	* Sets the extra5 of this membership package addon services.
	*
	* @param extra5 the extra5 of this membership package addon services
	*/
	@Override
	public void setExtra5(java.util.Date extra5) {
		_membershipPackageAddonServices.setExtra5(extra5);
	}

	/**
	* Returns the extra6 of this membership package addon services.
	*
	* @return the extra6 of this membership package addon services
	*/
	@Override
	public java.util.Date getExtra6() {
		return _membershipPackageAddonServices.getExtra6();
	}

	/**
	* Sets the extra6 of this membership package addon services.
	*
	* @param extra6 the extra6 of this membership package addon services
	*/
	@Override
	public void setExtra6(java.util.Date extra6) {
		_membershipPackageAddonServices.setExtra6(extra6);
	}

	@Override
	public boolean isNew() {
		return _membershipPackageAddonServices.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_membershipPackageAddonServices.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _membershipPackageAddonServices.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_membershipPackageAddonServices.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _membershipPackageAddonServices.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _membershipPackageAddonServices.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_membershipPackageAddonServices.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _membershipPackageAddonServices.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_membershipPackageAddonServices.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_membershipPackageAddonServices.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_membershipPackageAddonServices.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MembershipPackageAddonServicesWrapper((MembershipPackageAddonServices)_membershipPackageAddonServices.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices membershipPackageAddonServices) {
		return _membershipPackageAddonServices.compareTo(membershipPackageAddonServices);
	}

	@Override
	public int hashCode() {
		return _membershipPackageAddonServices.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices> toCacheModel() {
		return _membershipPackageAddonServices.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices toEscapedModel() {
		return new MembershipPackageAddonServicesWrapper(_membershipPackageAddonServices.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices toUnescapedModel() {
		return new MembershipPackageAddonServicesWrapper(_membershipPackageAddonServices.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _membershipPackageAddonServices.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _membershipPackageAddonServices.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipPackageAddonServices.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MembershipPackageAddonServicesWrapper)) {
			return false;
		}

		MembershipPackageAddonServicesWrapper membershipPackageAddonServicesWrapper =
			(MembershipPackageAddonServicesWrapper)obj;

		if (Validator.equals(_membershipPackageAddonServices,
					membershipPackageAddonServicesWrapper._membershipPackageAddonServices)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MembershipPackageAddonServices getWrappedMembershipPackageAddonServices() {
		return _membershipPackageAddonServices;
	}

	@Override
	public MembershipPackageAddonServices getWrappedModel() {
		return _membershipPackageAddonServices;
	}

	@Override
	public void resetOriginalValues() {
		_membershipPackageAddonServices.resetOriginalValues();
	}

	private MembershipPackageAddonServices _membershipPackageAddonServices;
}