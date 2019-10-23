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
 * This class is a wrapper for {@link MembershipPackagePromotionCode}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackagePromotionCode
 * @generated
 */
public class MembershipPackagePromotionCodeWrapper
	implements MembershipPackagePromotionCode,
		ModelWrapper<MembershipPackagePromotionCode> {
	public MembershipPackagePromotionCodeWrapper(
		MembershipPackagePromotionCode membershipPackagePromotionCode) {
		_membershipPackagePromotionCode = membershipPackagePromotionCode;
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackagePromotionCode.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackagePromotionCode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("promotionCode_id", getPromotionCode_id());
		attributes.put("membershipPackage_id", getMembershipPackage_id());
		attributes.put("promotionCode", getPromotionCode());
		attributes.put("promotionFrom", getPromotionFrom());
		attributes.put("promotionTo", getPromotionTo());
		attributes.put("discount", getDiscount());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long promotionCode_id = (Long)attributes.get("promotionCode_id");

		if (promotionCode_id != null) {
			setPromotionCode_id(promotionCode_id);
		}

		Long membershipPackage_id = (Long)attributes.get("membershipPackage_id");

		if (membershipPackage_id != null) {
			setMembershipPackage_id(membershipPackage_id);
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

		String extra5 = (String)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}
	}

	/**
	* Returns the primary key of this membership package promotion code.
	*
	* @return the primary key of this membership package promotion code
	*/
	@Override
	public long getPrimaryKey() {
		return _membershipPackagePromotionCode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this membership package promotion code.
	*
	* @param primaryKey the primary key of this membership package promotion code
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_membershipPackagePromotionCode.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the promotion code_id of this membership package promotion code.
	*
	* @return the promotion code_id of this membership package promotion code
	*/
	@Override
	public long getPromotionCode_id() {
		return _membershipPackagePromotionCode.getPromotionCode_id();
	}

	/**
	* Sets the promotion code_id of this membership package promotion code.
	*
	* @param promotionCode_id the promotion code_id of this membership package promotion code
	*/
	@Override
	public void setPromotionCode_id(long promotionCode_id) {
		_membershipPackagePromotionCode.setPromotionCode_id(promotionCode_id);
	}

	/**
	* Returns the membership package_id of this membership package promotion code.
	*
	* @return the membership package_id of this membership package promotion code
	*/
	@Override
	public long getMembershipPackage_id() {
		return _membershipPackagePromotionCode.getMembershipPackage_id();
	}

	/**
	* Sets the membership package_id of this membership package promotion code.
	*
	* @param membershipPackage_id the membership package_id of this membership package promotion code
	*/
	@Override
	public void setMembershipPackage_id(long membershipPackage_id) {
		_membershipPackagePromotionCode.setMembershipPackage_id(membershipPackage_id);
	}

	/**
	* Returns the promotion code of this membership package promotion code.
	*
	* @return the promotion code of this membership package promotion code
	*/
	@Override
	public java.lang.String getPromotionCode() {
		return _membershipPackagePromotionCode.getPromotionCode();
	}

	/**
	* Sets the promotion code of this membership package promotion code.
	*
	* @param promotionCode the promotion code of this membership package promotion code
	*/
	@Override
	public void setPromotionCode(java.lang.String promotionCode) {
		_membershipPackagePromotionCode.setPromotionCode(promotionCode);
	}

	/**
	* Returns the promotion from of this membership package promotion code.
	*
	* @return the promotion from of this membership package promotion code
	*/
	@Override
	public java.util.Date getPromotionFrom() {
		return _membershipPackagePromotionCode.getPromotionFrom();
	}

	/**
	* Sets the promotion from of this membership package promotion code.
	*
	* @param promotionFrom the promotion from of this membership package promotion code
	*/
	@Override
	public void setPromotionFrom(java.util.Date promotionFrom) {
		_membershipPackagePromotionCode.setPromotionFrom(promotionFrom);
	}

	/**
	* Returns the promotion to of this membership package promotion code.
	*
	* @return the promotion to of this membership package promotion code
	*/
	@Override
	public java.util.Date getPromotionTo() {
		return _membershipPackagePromotionCode.getPromotionTo();
	}

	/**
	* Sets the promotion to of this membership package promotion code.
	*
	* @param promotionTo the promotion to of this membership package promotion code
	*/
	@Override
	public void setPromotionTo(java.util.Date promotionTo) {
		_membershipPackagePromotionCode.setPromotionTo(promotionTo);
	}

	/**
	* Returns the discount of this membership package promotion code.
	*
	* @return the discount of this membership package promotion code
	*/
	@Override
	public java.lang.String getDiscount() {
		return _membershipPackagePromotionCode.getDiscount();
	}

	/**
	* Sets the discount of this membership package promotion code.
	*
	* @param discount the discount of this membership package promotion code
	*/
	@Override
	public void setDiscount(java.lang.String discount) {
		_membershipPackagePromotionCode.setDiscount(discount);
	}

	/**
	* Returns the extra1 of this membership package promotion code.
	*
	* @return the extra1 of this membership package promotion code
	*/
	@Override
	public java.lang.String getExtra1() {
		return _membershipPackagePromotionCode.getExtra1();
	}

	/**
	* Sets the extra1 of this membership package promotion code.
	*
	* @param extra1 the extra1 of this membership package promotion code
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_membershipPackagePromotionCode.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this membership package promotion code.
	*
	* @return the extra2 of this membership package promotion code
	*/
	@Override
	public java.lang.String getExtra2() {
		return _membershipPackagePromotionCode.getExtra2();
	}

	/**
	* Sets the extra2 of this membership package promotion code.
	*
	* @param extra2 the extra2 of this membership package promotion code
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_membershipPackagePromotionCode.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this membership package promotion code.
	*
	* @return the extra3 of this membership package promotion code
	*/
	@Override
	public java.lang.String getExtra3() {
		return _membershipPackagePromotionCode.getExtra3();
	}

	/**
	* Sets the extra3 of this membership package promotion code.
	*
	* @param extra3 the extra3 of this membership package promotion code
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_membershipPackagePromotionCode.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this membership package promotion code.
	*
	* @return the extra4 of this membership package promotion code
	*/
	@Override
	public java.lang.String getExtra4() {
		return _membershipPackagePromotionCode.getExtra4();
	}

	/**
	* Sets the extra4 of this membership package promotion code.
	*
	* @param extra4 the extra4 of this membership package promotion code
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_membershipPackagePromotionCode.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this membership package promotion code.
	*
	* @return the extra5 of this membership package promotion code
	*/
	@Override
	public java.lang.String getExtra5() {
		return _membershipPackagePromotionCode.getExtra5();
	}

	/**
	* Sets the extra5 of this membership package promotion code.
	*
	* @param extra5 the extra5 of this membership package promotion code
	*/
	@Override
	public void setExtra5(java.lang.String extra5) {
		_membershipPackagePromotionCode.setExtra5(extra5);
	}

	@Override
	public boolean isNew() {
		return _membershipPackagePromotionCode.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_membershipPackagePromotionCode.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _membershipPackagePromotionCode.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_membershipPackagePromotionCode.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _membershipPackagePromotionCode.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _membershipPackagePromotionCode.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_membershipPackagePromotionCode.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _membershipPackagePromotionCode.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_membershipPackagePromotionCode.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_membershipPackagePromotionCode.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_membershipPackagePromotionCode.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MembershipPackagePromotionCodeWrapper((MembershipPackagePromotionCode)_membershipPackagePromotionCode.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode membershipPackagePromotionCode) {
		return _membershipPackagePromotionCode.compareTo(membershipPackagePromotionCode);
	}

	@Override
	public int hashCode() {
		return _membershipPackagePromotionCode.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> toCacheModel() {
		return _membershipPackagePromotionCode.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode toEscapedModel() {
		return new MembershipPackagePromotionCodeWrapper(_membershipPackagePromotionCode.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode toUnescapedModel() {
		return new MembershipPackagePromotionCodeWrapper(_membershipPackagePromotionCode.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _membershipPackagePromotionCode.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _membershipPackagePromotionCode.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_membershipPackagePromotionCode.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MembershipPackagePromotionCodeWrapper)) {
			return false;
		}

		MembershipPackagePromotionCodeWrapper membershipPackagePromotionCodeWrapper =
			(MembershipPackagePromotionCodeWrapper)obj;

		if (Validator.equals(_membershipPackagePromotionCode,
					membershipPackagePromotionCodeWrapper._membershipPackagePromotionCode)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MembershipPackagePromotionCode getWrappedMembershipPackagePromotionCode() {
		return _membershipPackagePromotionCode;
	}

	@Override
	public MembershipPackagePromotionCode getWrappedModel() {
		return _membershipPackagePromotionCode;
	}

	@Override
	public void resetOriginalValues() {
		_membershipPackagePromotionCode.resetOriginalValues();
	}

	private MembershipPackagePromotionCode _membershipPackagePromotionCode;
}