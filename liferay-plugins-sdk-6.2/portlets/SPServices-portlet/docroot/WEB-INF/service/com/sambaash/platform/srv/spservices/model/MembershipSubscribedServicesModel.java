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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MembershipSubscribedServices service. Represents a row in the &quot;SPMembershipSubscribedServices&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscribedServices
 * @see com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesImpl
 * @see com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl
 * @generated
 */
public interface MembershipSubscribedServicesModel extends BaseModel<MembershipSubscribedServices> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a membership subscribed services model instance should use the {@link MembershipSubscribedServices} interface instead.
	 */

	/**
	 * Returns the primary key of this membership subscribed services.
	 *
	 * @return the primary key of this membership subscribed services
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this membership subscribed services.
	 *
	 * @param primaryKey the primary key of this membership subscribed services
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mss ID of this membership subscribed services.
	 *
	 * @return the mss ID of this membership subscribed services
	 */
	public long getMssId();

	/**
	 * Sets the mss ID of this membership subscribed services.
	 *
	 * @param mssId the mss ID of this membership subscribed services
	 */
	public void setMssId(long mssId);

	/**
	 * Returns the userid of this membership subscribed services.
	 *
	 * @return the userid of this membership subscribed services
	 */
	public long getUserid();

	/**
	 * Sets the userid of this membership subscribed services.
	 *
	 * @param userid the userid of this membership subscribed services
	 */
	public void setUserid(long userid);

	/**
	 * Returns the company ID of this membership subscribed services.
	 *
	 * @return the company ID of this membership subscribed services
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this membership subscribed services.
	 *
	 * @param companyId the company ID of this membership subscribed services
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the sc ID of this membership subscribed services.
	 *
	 * @return the sc ID of this membership subscribed services
	 */
	@AutoEscape
	public String getScId();

	/**
	 * Sets the sc ID of this membership subscribed services.
	 *
	 * @param scId the sc ID of this membership subscribed services
	 */
	public void setScId(String scId);

	/**
	 * Returns the sc name of this membership subscribed services.
	 *
	 * @return the sc name of this membership subscribed services
	 */
	@AutoEscape
	public String getScName();

	/**
	 * Sets the sc name of this membership subscribed services.
	 *
	 * @param scName the sc name of this membership subscribed services
	 */
	public void setScName(String scName);

	/**
	 * Returns the count of this membership subscribed services.
	 *
	 * @return the count of this membership subscribed services
	 */
	@AutoEscape
	public String getCount();

	/**
	 * Sets the count of this membership subscribed services.
	 *
	 * @param count the count of this membership subscribed services
	 */
	public void setCount(String count);

	/**
	 * Returns the status of this membership subscribed services.
	 *
	 * @return the status of this membership subscribed services
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this membership subscribed services.
	 *
	 * @param status the status of this membership subscribed services
	 */
	public void setStatus(String status);

	/**
	 * Returns the description of this membership subscribed services.
	 *
	 * @return the description of this membership subscribed services
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this membership subscribed services.
	 *
	 * @param description the description of this membership subscribed services
	 */
	public void setDescription(String description);

	/**
	 * Returns the date added of this membership subscribed services.
	 *
	 * @return the date added of this membership subscribed services
	 */
	public Date getDateAdded();

	/**
	 * Sets the date added of this membership subscribed services.
	 *
	 * @param dateAdded the date added of this membership subscribed services
	 */
	public void setDateAdded(Date dateAdded);

	/**
	 * Returns the date modified of this membership subscribed services.
	 *
	 * @return the date modified of this membership subscribed services
	 */
	public Date getDateModified();

	/**
	 * Sets the date modified of this membership subscribed services.
	 *
	 * @param dateModified the date modified of this membership subscribed services
	 */
	public void setDateModified(Date dateModified);

	/**
	 * Returns the created by of this membership subscribed services.
	 *
	 * @return the created by of this membership subscribed services
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this membership subscribed services.
	 *
	 * @param createdBy the created by of this membership subscribed services
	 */
	public void setCreatedBy(String createdBy);

	/**
	 * Returns the modified by of this membership subscribed services.
	 *
	 * @return the modified by of this membership subscribed services
	 */
	@AutoEscape
	public String getModifiedBy();

	/**
	 * Sets the modified by of this membership subscribed services.
	 *
	 * @param modifiedBy the modified by of this membership subscribed services
	 */
	public void setModifiedBy(String modifiedBy);

	/**
	 * Returns the effective from date of this membership subscribed services.
	 *
	 * @return the effective from date of this membership subscribed services
	 */
	public Date getEffectiveFromDate();

	/**
	 * Sets the effective from date of this membership subscribed services.
	 *
	 * @param effectiveFromDate the effective from date of this membership subscribed services
	 */
	public void setEffectiveFromDate(Date effectiveFromDate);

	/**
	 * Returns the effective to date of this membership subscribed services.
	 *
	 * @return the effective to date of this membership subscribed services
	 */
	public Date getEffectiveToDate();

	/**
	 * Sets the effective to date of this membership subscribed services.
	 *
	 * @param effectiveToDate the effective to date of this membership subscribed services
	 */
	public void setEffectiveToDate(Date effectiveToDate);

	/**
	 * Returns the param from of this membership subscribed services.
	 *
	 * @return the param from of this membership subscribed services
	 */
	@AutoEscape
	public String getParamFrom();

	/**
	 * Sets the param from of this membership subscribed services.
	 *
	 * @param paramFrom the param from of this membership subscribed services
	 */
	public void setParamFrom(String paramFrom);

	/**
	 * Returns the param upto of this membership subscribed services.
	 *
	 * @return the param upto of this membership subscribed services
	 */
	@AutoEscape
	public String getParamUpto();

	/**
	 * Sets the param upto of this membership subscribed services.
	 *
	 * @param paramUpto the param upto of this membership subscribed services
	 */
	public void setParamUpto(String paramUpto);

	/**
	 * Returns the duration of this membership subscribed services.
	 *
	 * @return the duration of this membership subscribed services
	 */
	@AutoEscape
	public String getDuration();

	/**
	 * Sets the duration of this membership subscribed services.
	 *
	 * @param duration the duration of this membership subscribed services
	 */
	public void setDuration(String duration);

	/**
	 * Returns the duration type of this membership subscribed services.
	 *
	 * @return the duration type of this membership subscribed services
	 */
	@AutoEscape
	public String getDurationType();

	/**
	 * Sets the duration type of this membership subscribed services.
	 *
	 * @param durationType the duration type of this membership subscribed services
	 */
	public void setDurationType(String durationType);

	/**
	 * Returns the service charges of this membership subscribed services.
	 *
	 * @return the service charges of this membership subscribed services
	 */
	public float getServiceCharges();

	/**
	 * Sets the service charges of this membership subscribed services.
	 *
	 * @param serviceCharges the service charges of this membership subscribed services
	 */
	public void setServiceCharges(float serviceCharges);

	/**
	 * Returns the service charges currency of this membership subscribed services.
	 *
	 * @return the service charges currency of this membership subscribed services
	 */
	@AutoEscape
	public String getServiceChargesCurrency();

	/**
	 * Sets the service charges currency of this membership subscribed services.
	 *
	 * @param serviceChargesCurrency the service charges currency of this membership subscribed services
	 */
	public void setServiceChargesCurrency(String serviceChargesCurrency);

	/**
	 * Returns the service charges period of this membership subscribed services.
	 *
	 * @return the service charges period of this membership subscribed services
	 */
	@AutoEscape
	public String getServiceChargesPeriod();

	/**
	 * Sets the service charges period of this membership subscribed services.
	 *
	 * @param serviceChargesPeriod the service charges period of this membership subscribed services
	 */
	public void setServiceChargesPeriod(String serviceChargesPeriod);

	/**
	 * Returns the service charges period type of this membership subscribed services.
	 *
	 * @return the service charges period type of this membership subscribed services
	 */
	@AutoEscape
	public String getServiceChargesPeriodType();

	/**
	 * Sets the service charges period type of this membership subscribed services.
	 *
	 * @param serviceChargesPeriodType the service charges period type of this membership subscribed services
	 */
	public void setServiceChargesPeriodType(String serviceChargesPeriodType);

	/**
	 * Returns the extra1 of this membership subscribed services.
	 *
	 * @return the extra1 of this membership subscribed services
	 */
	@AutoEscape
	public String getExtra1();

	/**
	 * Sets the extra1 of this membership subscribed services.
	 *
	 * @param extra1 the extra1 of this membership subscribed services
	 */
	public void setExtra1(String extra1);

	/**
	 * Returns the extra2 of this membership subscribed services.
	 *
	 * @return the extra2 of this membership subscribed services
	 */
	@AutoEscape
	public String getExtra2();

	/**
	 * Sets the extra2 of this membership subscribed services.
	 *
	 * @param extra2 the extra2 of this membership subscribed services
	 */
	public void setExtra2(String extra2);

	/**
	 * Returns the extra3 of this membership subscribed services.
	 *
	 * @return the extra3 of this membership subscribed services
	 */
	@AutoEscape
	public String getExtra3();

	/**
	 * Sets the extra3 of this membership subscribed services.
	 *
	 * @param extra3 the extra3 of this membership subscribed services
	 */
	public void setExtra3(String extra3);

	/**
	 * Returns the extra4 of this membership subscribed services.
	 *
	 * @return the extra4 of this membership subscribed services
	 */
	@AutoEscape
	public String getExtra4();

	/**
	 * Sets the extra4 of this membership subscribed services.
	 *
	 * @param extra4 the extra4 of this membership subscribed services
	 */
	public void setExtra4(String extra4);

	/**
	 * Returns the extra5 of this membership subscribed services.
	 *
	 * @return the extra5 of this membership subscribed services
	 */
	public Date getExtra5();

	/**
	 * Sets the extra5 of this membership subscribed services.
	 *
	 * @param extra5 the extra5 of this membership subscribed services
	 */
	public void setExtra5(Date extra5);

	/**
	 * Returns the extra6 of this membership subscribed services.
	 *
	 * @return the extra6 of this membership subscribed services
	 */
	public Date getExtra6();

	/**
	 * Sets the extra6 of this membership subscribed services.
	 *
	 * @param extra6 the extra6 of this membership subscribed services
	 */
	public void setExtra6(Date extra6);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}