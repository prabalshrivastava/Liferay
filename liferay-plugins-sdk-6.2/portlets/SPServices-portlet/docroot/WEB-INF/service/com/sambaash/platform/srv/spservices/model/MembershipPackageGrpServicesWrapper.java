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
 * This class is a wrapper for {@link MembershipPackageGrpServices}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageGrpServices
 * @generated
 */
public class MembershipPackageGrpServicesWrapper
	implements MembershipPackageGrpServices,
		ModelWrapper<MembershipPackageGrpServices> {
	public MembershipPackageGrpServicesWrapper(
		MembershipPackageGrpServices membershipPackageGrpServices) {
		_membershipPackageGrpServices = membershipPackageGrpServices;
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackageGrpServices.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackageGrpServices.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mpgsscId", getMpgsscId());
		attributes.put("mpId", getMpId());
		attributes.put("scorder", getScorder());
		attributes.put("scgId", getScgId());
		attributes.put("scId", getScId());
		attributes.put("paramType", getParamType());
		attributes.put("paramFrom", getParamFrom());
		attributes.put("paramUpto", getParamUpto());
		attributes.put("duration", getDuration());
		attributes.put("durationType", getDurationType());
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
		attributes.put("serviceCharges", getServiceCharges());
		attributes.put("costCurrency", getCostCurrency());
		attributes.put("costPeriod", getCostPeriod());
		attributes.put("costPeriodType", getCostPeriodType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mpgsscId = (Long)attributes.get("mpgsscId");

		if (mpgsscId != null) {
			setMpgsscId(mpgsscId);
		}

		Long mpId = (Long)attributes.get("mpId");

		if (mpId != null) {
			setMpId(mpId);
		}

		Integer scorder = (Integer)attributes.get("scorder");

		if (scorder != null) {
			setScorder(scorder);
		}

		String scgId = (String)attributes.get("scgId");

		if (scgId != null) {
			setScgId(scgId);
		}

		String scId = (String)attributes.get("scId");

		if (scId != null) {
			setScId(scId);
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

		Float serviceCharges = (Float)attributes.get("serviceCharges");

		if (serviceCharges != null) {
			setServiceCharges(serviceCharges);
		}

		String costCurrency = (String)attributes.get("costCurrency");

		if (costCurrency != null) {
			setCostCurrency(costCurrency);
		}

		String costPeriod = (String)attributes.get("costPeriod");

		if (costPeriod != null) {
			setCostPeriod(costPeriod);
		}

		String costPeriodType = (String)attributes.get("costPeriodType");

		if (costPeriodType != null) {
			setCostPeriodType(costPeriodType);
		}
	}

	/**
	* Returns the primary key of this membership package grp services.
	*
	* @return the primary key of this membership package grp services
	*/
	@Override
	public long getPrimaryKey() {
		return _membershipPackageGrpServices.getPrimaryKey();
	}

	/**
	* Sets the primary key of this membership package grp services.
	*
	* @param primaryKey the primary key of this membership package grp services
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_membershipPackageGrpServices.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mpgssc ID of this membership package grp services.
	*
	* @return the mpgssc ID of this membership package grp services
	*/
	@Override
	public long getMpgsscId() {
		return _membershipPackageGrpServices.getMpgsscId();
	}

	/**
	* Sets the mpgssc ID of this membership package grp services.
	*
	* @param mpgsscId the mpgssc ID of this membership package grp services
	*/
	@Override
	public void setMpgsscId(long mpgsscId) {
		_membershipPackageGrpServices.setMpgsscId(mpgsscId);
	}

	/**
	* Returns the mp ID of this membership package grp services.
	*
	* @return the mp ID of this membership package grp services
	*/
	@Override
	public long getMpId() {
		return _membershipPackageGrpServices.getMpId();
	}

	/**
	* Sets the mp ID of this membership package grp services.
	*
	* @param mpId the mp ID of this membership package grp services
	*/
	@Override
	public void setMpId(long mpId) {
		_membershipPackageGrpServices.setMpId(mpId);
	}

	/**
	* Returns the scorder of this membership package grp services.
	*
	* @return the scorder of this membership package grp services
	*/
	@Override
	public int getScorder() {
		return _membershipPackageGrpServices.getScorder();
	}

	/**
	* Sets the scorder of this membership package grp services.
	*
	* @param scorder the scorder of this membership package grp services
	*/
	@Override
	public void setScorder(int scorder) {
		_membershipPackageGrpServices.setScorder(scorder);
	}

	/**
	* Returns the scg ID of this membership package grp services.
	*
	* @return the scg ID of this membership package grp services
	*/
	@Override
	public java.lang.String getScgId() {
		return _membershipPackageGrpServices.getScgId();
	}

	/**
	* Sets the scg ID of this membership package grp services.
	*
	* @param scgId the scg ID of this membership package grp services
	*/
	@Override
	public void setScgId(java.lang.String scgId) {
		_membershipPackageGrpServices.setScgId(scgId);
	}

	/**
	* Returns the sc ID of this membership package grp services.
	*
	* @return the sc ID of this membership package grp services
	*/
	@Override
	public java.lang.String getScId() {
		return _membershipPackageGrpServices.getScId();
	}

	/**
	* Sets the sc ID of this membership package grp services.
	*
	* @param scId the sc ID of this membership package grp services
	*/
	@Override
	public void setScId(java.lang.String scId) {
		_membershipPackageGrpServices.setScId(scId);
	}

	/**
	* Returns the param type of this membership package grp services.
	*
	* @return the param type of this membership package grp services
	*/
	@Override
	public java.lang.String getParamType() {
		return _membershipPackageGrpServices.getParamType();
	}

	/**
	* Sets the param type of this membership package grp services.
	*
	* @param paramType the param type of this membership package grp services
	*/
	@Override
	public void setParamType(java.lang.String paramType) {
		_membershipPackageGrpServices.setParamType(paramType);
	}

	/**
	* Returns the param from of this membership package grp services.
	*
	* @return the param from of this membership package grp services
	*/
	@Override
	public java.lang.String getParamFrom() {
		return _membershipPackageGrpServices.getParamFrom();
	}

	/**
	* Sets the param from of this membership package grp services.
	*
	* @param paramFrom the param from of this membership package grp services
	*/
	@Override
	public void setParamFrom(java.lang.String paramFrom) {
		_membershipPackageGrpServices.setParamFrom(paramFrom);
	}

	/**
	* Returns the param upto of this membership package grp services.
	*
	* @return the param upto of this membership package grp services
	*/
	@Override
	public java.lang.String getParamUpto() {
		return _membershipPackageGrpServices.getParamUpto();
	}

	/**
	* Sets the param upto of this membership package grp services.
	*
	* @param paramUpto the param upto of this membership package grp services
	*/
	@Override
	public void setParamUpto(java.lang.String paramUpto) {
		_membershipPackageGrpServices.setParamUpto(paramUpto);
	}

	/**
	* Returns the duration of this membership package grp services.
	*
	* @return the duration of this membership package grp services
	*/
	@Override
	public java.lang.String getDuration() {
		return _membershipPackageGrpServices.getDuration();
	}

	/**
	* Sets the duration of this membership package grp services.
	*
	* @param duration the duration of this membership package grp services
	*/
	@Override
	public void setDuration(java.lang.String duration) {
		_membershipPackageGrpServices.setDuration(duration);
	}

	/**
	* Returns the duration type of this membership package grp services.
	*
	* @return the duration type of this membership package grp services
	*/
	@Override
	public java.lang.String getDurationType() {
		return _membershipPackageGrpServices.getDurationType();
	}

	/**
	* Sets the duration type of this membership package grp services.
	*
	* @param durationType the duration type of this membership package grp services
	*/
	@Override
	public void setDurationType(java.lang.String durationType) {
		_membershipPackageGrpServices.setDurationType(durationType);
	}

	/**
	* Returns the status of this membership package grp services.
	*
	* @return the status of this membership package grp services
	*/
	@Override
	public java.lang.String getStatus() {
		return _membershipPackageGrpServices.getStatus();
	}

	/**
	* Sets the status of this membership package grp services.
	*
	* @param status the status of this membership package grp services
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_membershipPackageGrpServices.setStatus(status);
	}

	/**
	* Returns the description of this membership package grp services.
	*
	* @return the description of this membership package grp services
	*/
	@Override
	public java.lang.String getDescription() {
		return _membershipPackageGrpServices.getDescription();
	}

	/**
	* Sets the description of this membership package grp services.
	*
	* @param description the description of this membership package grp services
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_membershipPackageGrpServices.setDescription(description);
	}

	/**
	* Returns the date added of this membership package grp services.
	*
	* @return the date added of this membership package grp services
	*/
	@Override
	public java.util.Date getDateAdded() {
		return _membershipPackageGrpServices.getDateAdded();
	}

	/**
	* Sets the date added of this membership package grp services.
	*
	* @param dateAdded the date added of this membership package grp services
	*/
	@Override
	public void setDateAdded(java.util.Date dateAdded) {
		_membershipPackageGrpServices.setDateAdded(dateAdded);
	}

	/**
	* Returns the date modified of this membership package grp services.
	*
	* @return the date modified of this membership package grp services
	*/
	@Override
	public java.util.Date getDateModified() {
		return _membershipPackageGrpServices.getDateModified();
	}

	/**
	* Sets the date modified of this membership package grp services.
	*
	* @param dateModified the date modified of this membership package grp services
	*/
	@Override
	public void setDateModified(java.util.Date dateModified) {
		_membershipPackageGrpServices.setDateModified(dateModified);
	}

	/**
	* Returns the created by of this membership package grp services.
	*
	* @return the created by of this membership package grp services
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _membershipPackageGrpServices.getCreatedBy();
	}

	/**
	* Sets the created by of this membership package grp services.
	*
	* @param createdBy the created by of this membership package grp services
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_membershipPackageGrpServices.setCreatedBy(createdBy);
	}

	/**
	* Returns the modified by of this membership package grp services.
	*
	* @return the modified by of this membership package grp services
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _membershipPackageGrpServices.getModifiedBy();
	}

	/**
	* Sets the modified by of this membership package grp services.
	*
	* @param modifiedBy the modified by of this membership package grp services
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_membershipPackageGrpServices.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the extra1 of this membership package grp services.
	*
	* @return the extra1 of this membership package grp services
	*/
	@Override
	public java.lang.String getExtra1() {
		return _membershipPackageGrpServices.getExtra1();
	}

	/**
	* Sets the extra1 of this membership package grp services.
	*
	* @param extra1 the extra1 of this membership package grp services
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_membershipPackageGrpServices.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this membership package grp services.
	*
	* @return the extra2 of this membership package grp services
	*/
	@Override
	public java.lang.String getExtra2() {
		return _membershipPackageGrpServices.getExtra2();
	}

	/**
	* Sets the extra2 of this membership package grp services.
	*
	* @param extra2 the extra2 of this membership package grp services
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_membershipPackageGrpServices.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this membership package grp services.
	*
	* @return the extra3 of this membership package grp services
	*/
	@Override
	public java.lang.String getExtra3() {
		return _membershipPackageGrpServices.getExtra3();
	}

	/**
	* Sets the extra3 of this membership package grp services.
	*
	* @param extra3 the extra3 of this membership package grp services
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_membershipPackageGrpServices.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this membership package grp services.
	*
	* @return the extra4 of this membership package grp services
	*/
	@Override
	public java.lang.String getExtra4() {
		return _membershipPackageGrpServices.getExtra4();
	}

	/**
	* Sets the extra4 of this membership package grp services.
	*
	* @param extra4 the extra4 of this membership package grp services
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_membershipPackageGrpServices.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this membership package grp services.
	*
	* @return the extra5 of this membership package grp services
	*/
	@Override
	public java.util.Date getExtra5() {
		return _membershipPackageGrpServices.getExtra5();
	}

	/**
	* Sets the extra5 of this membership package grp services.
	*
	* @param extra5 the extra5 of this membership package grp services
	*/
	@Override
	public void setExtra5(java.util.Date extra5) {
		_membershipPackageGrpServices.setExtra5(extra5);
	}

	/**
	* Returns the extra6 of this membership package grp services.
	*
	* @return the extra6 of this membership package grp services
	*/
	@Override
	public java.util.Date getExtra6() {
		return _membershipPackageGrpServices.getExtra6();
	}

	/**
	* Sets the extra6 of this membership package grp services.
	*
	* @param extra6 the extra6 of this membership package grp services
	*/
	@Override
	public void setExtra6(java.util.Date extra6) {
		_membershipPackageGrpServices.setExtra6(extra6);
	}

	/**
	* Returns the service charges of this membership package grp services.
	*
	* @return the service charges of this membership package grp services
	*/
	@Override
	public float getServiceCharges() {
		return _membershipPackageGrpServices.getServiceCharges();
	}

	/**
	* Sets the service charges of this membership package grp services.
	*
	* @param serviceCharges the service charges of this membership package grp services
	*/
	@Override
	public void setServiceCharges(float serviceCharges) {
		_membershipPackageGrpServices.setServiceCharges(serviceCharges);
	}

	/**
	* Returns the cost currency of this membership package grp services.
	*
	* @return the cost currency of this membership package grp services
	*/
	@Override
	public java.lang.String getCostCurrency() {
		return _membershipPackageGrpServices.getCostCurrency();
	}

	/**
	* Sets the cost currency of this membership package grp services.
	*
	* @param costCurrency the cost currency of this membership package grp services
	*/
	@Override
	public void setCostCurrency(java.lang.String costCurrency) {
		_membershipPackageGrpServices.setCostCurrency(costCurrency);
	}

	/**
	* Returns the cost period of this membership package grp services.
	*
	* @return the cost period of this membership package grp services
	*/
	@Override
	public java.lang.String getCostPeriod() {
		return _membershipPackageGrpServices.getCostPeriod();
	}

	/**
	* Sets the cost period of this membership package grp services.
	*
	* @param costPeriod the cost period of this membership package grp services
	*/
	@Override
	public void setCostPeriod(java.lang.String costPeriod) {
		_membershipPackageGrpServices.setCostPeriod(costPeriod);
	}

	/**
	* Returns the cost period type of this membership package grp services.
	*
	* @return the cost period type of this membership package grp services
	*/
	@Override
	public java.lang.String getCostPeriodType() {
		return _membershipPackageGrpServices.getCostPeriodType();
	}

	/**
	* Sets the cost period type of this membership package grp services.
	*
	* @param costPeriodType the cost period type of this membership package grp services
	*/
	@Override
	public void setCostPeriodType(java.lang.String costPeriodType) {
		_membershipPackageGrpServices.setCostPeriodType(costPeriodType);
	}

	@Override
	public boolean isNew() {
		return _membershipPackageGrpServices.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_membershipPackageGrpServices.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _membershipPackageGrpServices.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_membershipPackageGrpServices.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _membershipPackageGrpServices.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _membershipPackageGrpServices.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_membershipPackageGrpServices.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _membershipPackageGrpServices.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_membershipPackageGrpServices.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_membershipPackageGrpServices.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_membershipPackageGrpServices.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MembershipPackageGrpServicesWrapper((MembershipPackageGrpServices)_membershipPackageGrpServices.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices) {
		return _membershipPackageGrpServices.compareTo(membershipPackageGrpServices);
	}

	@Override
	public int hashCode() {
		return _membershipPackageGrpServices.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices> toCacheModel() {
		return _membershipPackageGrpServices.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices toEscapedModel() {
		return new MembershipPackageGrpServicesWrapper(_membershipPackageGrpServices.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices toUnescapedModel() {
		return new MembershipPackageGrpServicesWrapper(_membershipPackageGrpServices.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _membershipPackageGrpServices.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _membershipPackageGrpServices.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipPackageGrpServices.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MembershipPackageGrpServicesWrapper)) {
			return false;
		}

		MembershipPackageGrpServicesWrapper membershipPackageGrpServicesWrapper = (MembershipPackageGrpServicesWrapper)obj;

		if (Validator.equals(_membershipPackageGrpServices,
					membershipPackageGrpServicesWrapper._membershipPackageGrpServices)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MembershipPackageGrpServices getWrappedMembershipPackageGrpServices() {
		return _membershipPackageGrpServices;
	}

	@Override
	public MembershipPackageGrpServices getWrappedModel() {
		return _membershipPackageGrpServices;
	}

	@Override
	public void resetOriginalValues() {
		_membershipPackageGrpServices.resetOriginalValues();
	}

	private MembershipPackageGrpServices _membershipPackageGrpServices;
}