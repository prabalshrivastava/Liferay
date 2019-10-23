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
 * This class is a wrapper for {@link MembershipPackage}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackage
 * @generated
 */
public class MembershipPackageWrapper implements MembershipPackage,
	ModelWrapper<MembershipPackage> {
	public MembershipPackageWrapper(MembershipPackage membershipPackage) {
		_membershipPackage = membershipPackage;
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackage.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mpId", getMpId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("type", getType());
		attributes.put("version", getVersion());
		attributes.put("cost", getCost());
		attributes.put("costCurrency", getCostCurrency());
		attributes.put("costPeriod", getCostPeriod());
		attributes.put("costPeriodType", getCostPeriodType());
		attributes.put("promotionCode", getPromotionCode());
		attributes.put("promotionFrom", getPromotionFrom());
		attributes.put("promotionTo", getPromotionTo());
		attributes.put("discount", getDiscount());
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
		attributes.put("extra7", getExtra7());
		attributes.put("extra8", getExtra8());
		attributes.put("extra9", getExtra9());
		attributes.put("extra10", getExtra10());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mpId = (Long)attributes.get("mpId");

		if (mpId != null) {
			setMpId(mpId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Float cost = (Float)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
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

		String promotionCode = (String)attributes.get("promotionCode");

		if (promotionCode != null) {
			setPromotionCode(promotionCode);
		}

		Date promotionFrom = (Date)attributes.get("promotionFrom");

		if (promotionFrom != null) {
			setPromotionFrom(promotionFrom);
		}

		Date promotionTo = (Date)attributes.get("promotionTo");

		if (promotionTo != null) {
			setPromotionTo(promotionTo);
		}

		String discount = (String)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
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

		String extra7 = (String)attributes.get("extra7");

		if (extra7 != null) {
			setExtra7(extra7);
		}

		String extra8 = (String)attributes.get("extra8");

		if (extra8 != null) {
			setExtra8(extra8);
		}

		String extra9 = (String)attributes.get("extra9");

		if (extra9 != null) {
			setExtra9(extra9);
		}

		String extra10 = (String)attributes.get("extra10");

		if (extra10 != null) {
			setExtra10(extra10);
		}
	}

	/**
	* Returns the primary key of this membership package.
	*
	* @return the primary key of this membership package
	*/
	@Override
	public long getPrimaryKey() {
		return _membershipPackage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this membership package.
	*
	* @param primaryKey the primary key of this membership package
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_membershipPackage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mp ID of this membership package.
	*
	* @return the mp ID of this membership package
	*/
	@Override
	public long getMpId() {
		return _membershipPackage.getMpId();
	}

	/**
	* Sets the mp ID of this membership package.
	*
	* @param mpId the mp ID of this membership package
	*/
	@Override
	public void setMpId(long mpId) {
		_membershipPackage.setMpId(mpId);
	}

	/**
	* Returns the name of this membership package.
	*
	* @return the name of this membership package
	*/
	@Override
	public java.lang.String getName() {
		return _membershipPackage.getName();
	}

	/**
	* Sets the name of this membership package.
	*
	* @param name the name of this membership package
	*/
	@Override
	public void setName(java.lang.String name) {
		_membershipPackage.setName(name);
	}

	/**
	* Returns the description of this membership package.
	*
	* @return the description of this membership package
	*/
	@Override
	public java.lang.String getDescription() {
		return _membershipPackage.getDescription();
	}

	/**
	* Sets the description of this membership package.
	*
	* @param description the description of this membership package
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_membershipPackage.setDescription(description);
	}

	/**
	* Returns the status of this membership package.
	*
	* @return the status of this membership package
	*/
	@Override
	public java.lang.String getStatus() {
		return _membershipPackage.getStatus();
	}

	/**
	* Sets the status of this membership package.
	*
	* @param status the status of this membership package
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_membershipPackage.setStatus(status);
	}

	/**
	* Returns the type of this membership package.
	*
	* @return the type of this membership package
	*/
	@Override
	public java.lang.String getType() {
		return _membershipPackage.getType();
	}

	/**
	* Sets the type of this membership package.
	*
	* @param type the type of this membership package
	*/
	@Override
	public void setType(java.lang.String type) {
		_membershipPackage.setType(type);
	}

	/**
	* Returns the version of this membership package.
	*
	* @return the version of this membership package
	*/
	@Override
	public java.lang.String getVersion() {
		return _membershipPackage.getVersion();
	}

	/**
	* Sets the version of this membership package.
	*
	* @param version the version of this membership package
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_membershipPackage.setVersion(version);
	}

	/**
	* Returns the cost of this membership package.
	*
	* @return the cost of this membership package
	*/
	@Override
	public float getCost() {
		return _membershipPackage.getCost();
	}

	/**
	* Sets the cost of this membership package.
	*
	* @param cost the cost of this membership package
	*/
	@Override
	public void setCost(float cost) {
		_membershipPackage.setCost(cost);
	}

	/**
	* Returns the cost currency of this membership package.
	*
	* @return the cost currency of this membership package
	*/
	@Override
	public java.lang.String getCostCurrency() {
		return _membershipPackage.getCostCurrency();
	}

	/**
	* Sets the cost currency of this membership package.
	*
	* @param costCurrency the cost currency of this membership package
	*/
	@Override
	public void setCostCurrency(java.lang.String costCurrency) {
		_membershipPackage.setCostCurrency(costCurrency);
	}

	/**
	* Returns the cost period of this membership package.
	*
	* @return the cost period of this membership package
	*/
	@Override
	public java.lang.String getCostPeriod() {
		return _membershipPackage.getCostPeriod();
	}

	/**
	* Sets the cost period of this membership package.
	*
	* @param costPeriod the cost period of this membership package
	*/
	@Override
	public void setCostPeriod(java.lang.String costPeriod) {
		_membershipPackage.setCostPeriod(costPeriod);
	}

	/**
	* Returns the cost period type of this membership package.
	*
	* @return the cost period type of this membership package
	*/
	@Override
	public java.lang.String getCostPeriodType() {
		return _membershipPackage.getCostPeriodType();
	}

	/**
	* Sets the cost period type of this membership package.
	*
	* @param costPeriodType the cost period type of this membership package
	*/
	@Override
	public void setCostPeriodType(java.lang.String costPeriodType) {
		_membershipPackage.setCostPeriodType(costPeriodType);
	}

	/**
	* Returns the promotion code of this membership package.
	*
	* @return the promotion code of this membership package
	*/
	@Override
	public java.lang.String getPromotionCode() {
		return _membershipPackage.getPromotionCode();
	}

	/**
	* Sets the promotion code of this membership package.
	*
	* @param promotionCode the promotion code of this membership package
	*/
	@Override
	public void setPromotionCode(java.lang.String promotionCode) {
		_membershipPackage.setPromotionCode(promotionCode);
	}

	/**
	* Returns the promotion from of this membership package.
	*
	* @return the promotion from of this membership package
	*/
	@Override
	public java.util.Date getPromotionFrom() {
		return _membershipPackage.getPromotionFrom();
	}

	/**
	* Sets the promotion from of this membership package.
	*
	* @param promotionFrom the promotion from of this membership package
	*/
	@Override
	public void setPromotionFrom(java.util.Date promotionFrom) {
		_membershipPackage.setPromotionFrom(promotionFrom);
	}

	/**
	* Returns the promotion to of this membership package.
	*
	* @return the promotion to of this membership package
	*/
	@Override
	public java.util.Date getPromotionTo() {
		return _membershipPackage.getPromotionTo();
	}

	/**
	* Sets the promotion to of this membership package.
	*
	* @param promotionTo the promotion to of this membership package
	*/
	@Override
	public void setPromotionTo(java.util.Date promotionTo) {
		_membershipPackage.setPromotionTo(promotionTo);
	}

	/**
	* Returns the discount of this membership package.
	*
	* @return the discount of this membership package
	*/
	@Override
	public java.lang.String getDiscount() {
		return _membershipPackage.getDiscount();
	}

	/**
	* Sets the discount of this membership package.
	*
	* @param discount the discount of this membership package
	*/
	@Override
	public void setDiscount(java.lang.String discount) {
		_membershipPackage.setDiscount(discount);
	}

	/**
	* Returns the date added of this membership package.
	*
	* @return the date added of this membership package
	*/
	@Override
	public java.util.Date getDateAdded() {
		return _membershipPackage.getDateAdded();
	}

	/**
	* Sets the date added of this membership package.
	*
	* @param dateAdded the date added of this membership package
	*/
	@Override
	public void setDateAdded(java.util.Date dateAdded) {
		_membershipPackage.setDateAdded(dateAdded);
	}

	/**
	* Returns the date modified of this membership package.
	*
	* @return the date modified of this membership package
	*/
	@Override
	public java.util.Date getDateModified() {
		return _membershipPackage.getDateModified();
	}

	/**
	* Sets the date modified of this membership package.
	*
	* @param dateModified the date modified of this membership package
	*/
	@Override
	public void setDateModified(java.util.Date dateModified) {
		_membershipPackage.setDateModified(dateModified);
	}

	/**
	* Returns the created by of this membership package.
	*
	* @return the created by of this membership package
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _membershipPackage.getCreatedBy();
	}

	/**
	* Sets the created by of this membership package.
	*
	* @param createdBy the created by of this membership package
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_membershipPackage.setCreatedBy(createdBy);
	}

	/**
	* Returns the modified by of this membership package.
	*
	* @return the modified by of this membership package
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _membershipPackage.getModifiedBy();
	}

	/**
	* Sets the modified by of this membership package.
	*
	* @param modifiedBy the modified by of this membership package
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_membershipPackage.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the extra1 of this membership package.
	*
	* @return the extra1 of this membership package
	*/
	@Override
	public java.lang.String getExtra1() {
		return _membershipPackage.getExtra1();
	}

	/**
	* Sets the extra1 of this membership package.
	*
	* @param extra1 the extra1 of this membership package
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_membershipPackage.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this membership package.
	*
	* @return the extra2 of this membership package
	*/
	@Override
	public java.lang.String getExtra2() {
		return _membershipPackage.getExtra2();
	}

	/**
	* Sets the extra2 of this membership package.
	*
	* @param extra2 the extra2 of this membership package
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_membershipPackage.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this membership package.
	*
	* @return the extra3 of this membership package
	*/
	@Override
	public java.lang.String getExtra3() {
		return _membershipPackage.getExtra3();
	}

	/**
	* Sets the extra3 of this membership package.
	*
	* @param extra3 the extra3 of this membership package
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_membershipPackage.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this membership package.
	*
	* @return the extra4 of this membership package
	*/
	@Override
	public java.lang.String getExtra4() {
		return _membershipPackage.getExtra4();
	}

	/**
	* Sets the extra4 of this membership package.
	*
	* @param extra4 the extra4 of this membership package
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_membershipPackage.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this membership package.
	*
	* @return the extra5 of this membership package
	*/
	@Override
	public java.util.Date getExtra5() {
		return _membershipPackage.getExtra5();
	}

	/**
	* Sets the extra5 of this membership package.
	*
	* @param extra5 the extra5 of this membership package
	*/
	@Override
	public void setExtra5(java.util.Date extra5) {
		_membershipPackage.setExtra5(extra5);
	}

	/**
	* Returns the extra6 of this membership package.
	*
	* @return the extra6 of this membership package
	*/
	@Override
	public java.util.Date getExtra6() {
		return _membershipPackage.getExtra6();
	}

	/**
	* Sets the extra6 of this membership package.
	*
	* @param extra6 the extra6 of this membership package
	*/
	@Override
	public void setExtra6(java.util.Date extra6) {
		_membershipPackage.setExtra6(extra6);
	}

	/**
	* Returns the extra7 of this membership package.
	*
	* @return the extra7 of this membership package
	*/
	@Override
	public java.lang.String getExtra7() {
		return _membershipPackage.getExtra7();
	}

	/**
	* Sets the extra7 of this membership package.
	*
	* @param extra7 the extra7 of this membership package
	*/
	@Override
	public void setExtra7(java.lang.String extra7) {
		_membershipPackage.setExtra7(extra7);
	}

	/**
	* Returns the extra8 of this membership package.
	*
	* @return the extra8 of this membership package
	*/
	@Override
	public java.lang.String getExtra8() {
		return _membershipPackage.getExtra8();
	}

	/**
	* Sets the extra8 of this membership package.
	*
	* @param extra8 the extra8 of this membership package
	*/
	@Override
	public void setExtra8(java.lang.String extra8) {
		_membershipPackage.setExtra8(extra8);
	}

	/**
	* Returns the extra9 of this membership package.
	*
	* @return the extra9 of this membership package
	*/
	@Override
	public java.lang.String getExtra9() {
		return _membershipPackage.getExtra9();
	}

	/**
	* Sets the extra9 of this membership package.
	*
	* @param extra9 the extra9 of this membership package
	*/
	@Override
	public void setExtra9(java.lang.String extra9) {
		_membershipPackage.setExtra9(extra9);
	}

	/**
	* Returns the extra10 of this membership package.
	*
	* @return the extra10 of this membership package
	*/
	@Override
	public java.lang.String getExtra10() {
		return _membershipPackage.getExtra10();
	}

	/**
	* Sets the extra10 of this membership package.
	*
	* @param extra10 the extra10 of this membership package
	*/
	@Override
	public void setExtra10(java.lang.String extra10) {
		_membershipPackage.setExtra10(extra10);
	}

	@Override
	public boolean isNew() {
		return _membershipPackage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_membershipPackage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _membershipPackage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_membershipPackage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _membershipPackage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _membershipPackage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_membershipPackage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _membershipPackage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_membershipPackage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_membershipPackage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_membershipPackage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MembershipPackageWrapper((MembershipPackage)_membershipPackage.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.MembershipPackage membershipPackage) {
		return _membershipPackage.compareTo(membershipPackage);
	}

	@Override
	public int hashCode() {
		return _membershipPackage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.MembershipPackage> toCacheModel() {
		return _membershipPackage.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackage toEscapedModel() {
		return new MembershipPackageWrapper(_membershipPackage.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackage toUnescapedModel() {
		return new MembershipPackageWrapper(_membershipPackage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _membershipPackage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _membershipPackage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipPackage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MembershipPackageWrapper)) {
			return false;
		}

		MembershipPackageWrapper membershipPackageWrapper = (MembershipPackageWrapper)obj;

		if (Validator.equals(_membershipPackage,
					membershipPackageWrapper._membershipPackage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MembershipPackage getWrappedMembershipPackage() {
		return _membershipPackage;
	}

	@Override
	public MembershipPackage getWrappedModel() {
		return _membershipPackage;
	}

	@Override
	public void resetOriginalValues() {
		_membershipPackage.resetOriginalValues();
	}

	private MembershipPackage _membershipPackage;
}