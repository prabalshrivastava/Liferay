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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Guidelines}.
 * </p>
 *
 * @author pradeep
 * @see Guidelines
 * @generated
 */
public class GuidelinesWrapper implements Guidelines, ModelWrapper<Guidelines> {
	public GuidelinesWrapper(Guidelines guidelines) {
		_guidelines = guidelines;
	}

	@Override
	public Class<?> getModelClass() {
		return Guidelines.class;
	}

	@Override
	public String getModelClassName() {
		return Guidelines.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("guidelineId", getGuidelineId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("principleId", getPrincipleId());
		attributes.put("guideline1", getGuideline1());
		attributes.put("guideline2", getGuideline2());
		attributes.put("guideline3", getGuideline3());
		attributes.put("guideline4", getGuideline4());
		attributes.put("guideline5", getGuideline5());
		attributes.put("guideline6", getGuideline6());
		attributes.put("guideline7", getGuideline7());
		attributes.put("guideline8", getGuideline8());
		attributes.put("moreInfo", getMoreInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long guidelineId = (Long)attributes.get("guidelineId");

		if (guidelineId != null) {
			setGuidelineId(guidelineId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long principleId = (Long)attributes.get("principleId");

		if (principleId != null) {
			setPrincipleId(principleId);
		}

		Boolean guideline1 = (Boolean)attributes.get("guideline1");

		if (guideline1 != null) {
			setGuideline1(guideline1);
		}

		Boolean guideline2 = (Boolean)attributes.get("guideline2");

		if (guideline2 != null) {
			setGuideline2(guideline2);
		}

		Boolean guideline3 = (Boolean)attributes.get("guideline3");

		if (guideline3 != null) {
			setGuideline3(guideline3);
		}

		Boolean guideline4 = (Boolean)attributes.get("guideline4");

		if (guideline4 != null) {
			setGuideline4(guideline4);
		}

		Boolean guideline5 = (Boolean)attributes.get("guideline5");

		if (guideline5 != null) {
			setGuideline5(guideline5);
		}

		Boolean guideline6 = (Boolean)attributes.get("guideline6");

		if (guideline6 != null) {
			setGuideline6(guideline6);
		}

		Boolean guideline7 = (Boolean)attributes.get("guideline7");

		if (guideline7 != null) {
			setGuideline7(guideline7);
		}

		Boolean guideline8 = (Boolean)attributes.get("guideline8");

		if (guideline8 != null) {
			setGuideline8(guideline8);
		}

		String moreInfo = (String)attributes.get("moreInfo");

		if (moreInfo != null) {
			setMoreInfo(moreInfo);
		}
	}

	/**
	* Returns the primary key of this guidelines.
	*
	* @return the primary key of this guidelines
	*/
	@Override
	public long getPrimaryKey() {
		return _guidelines.getPrimaryKey();
	}

	/**
	* Sets the primary key of this guidelines.
	*
	* @param primaryKey the primary key of this guidelines
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_guidelines.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this guidelines.
	*
	* @return the uuid of this guidelines
	*/
	@Override
	public java.lang.String getUuid() {
		return _guidelines.getUuid();
	}

	/**
	* Sets the uuid of this guidelines.
	*
	* @param uuid the uuid of this guidelines
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_guidelines.setUuid(uuid);
	}

	/**
	* Returns the guideline ID of this guidelines.
	*
	* @return the guideline ID of this guidelines
	*/
	@Override
	public long getGuidelineId() {
		return _guidelines.getGuidelineId();
	}

	/**
	* Sets the guideline ID of this guidelines.
	*
	* @param guidelineId the guideline ID of this guidelines
	*/
	@Override
	public void setGuidelineId(long guidelineId) {
		_guidelines.setGuidelineId(guidelineId);
	}

	/**
	* Returns the organization ID of this guidelines.
	*
	* @return the organization ID of this guidelines
	*/
	@Override
	public long getOrganizationId() {
		return _guidelines.getOrganizationId();
	}

	/**
	* Sets the organization ID of this guidelines.
	*
	* @param organizationId the organization ID of this guidelines
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_guidelines.setOrganizationId(organizationId);
	}

	/**
	* Returns the principle ID of this guidelines.
	*
	* @return the principle ID of this guidelines
	*/
	@Override
	public long getPrincipleId() {
		return _guidelines.getPrincipleId();
	}

	/**
	* Sets the principle ID of this guidelines.
	*
	* @param principleId the principle ID of this guidelines
	*/
	@Override
	public void setPrincipleId(long principleId) {
		_guidelines.setPrincipleId(principleId);
	}

	/**
	* Returns the guideline1 of this guidelines.
	*
	* @return the guideline1 of this guidelines
	*/
	@Override
	public boolean getGuideline1() {
		return _guidelines.getGuideline1();
	}

	/**
	* Returns <code>true</code> if this guidelines is guideline1.
	*
	* @return <code>true</code> if this guidelines is guideline1; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuideline1() {
		return _guidelines.isGuideline1();
	}

	/**
	* Sets whether this guidelines is guideline1.
	*
	* @param guideline1 the guideline1 of this guidelines
	*/
	@Override
	public void setGuideline1(boolean guideline1) {
		_guidelines.setGuideline1(guideline1);
	}

	/**
	* Returns the guideline2 of this guidelines.
	*
	* @return the guideline2 of this guidelines
	*/
	@Override
	public boolean getGuideline2() {
		return _guidelines.getGuideline2();
	}

	/**
	* Returns <code>true</code> if this guidelines is guideline2.
	*
	* @return <code>true</code> if this guidelines is guideline2; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuideline2() {
		return _guidelines.isGuideline2();
	}

	/**
	* Sets whether this guidelines is guideline2.
	*
	* @param guideline2 the guideline2 of this guidelines
	*/
	@Override
	public void setGuideline2(boolean guideline2) {
		_guidelines.setGuideline2(guideline2);
	}

	/**
	* Returns the guideline3 of this guidelines.
	*
	* @return the guideline3 of this guidelines
	*/
	@Override
	public boolean getGuideline3() {
		return _guidelines.getGuideline3();
	}

	/**
	* Returns <code>true</code> if this guidelines is guideline3.
	*
	* @return <code>true</code> if this guidelines is guideline3; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuideline3() {
		return _guidelines.isGuideline3();
	}

	/**
	* Sets whether this guidelines is guideline3.
	*
	* @param guideline3 the guideline3 of this guidelines
	*/
	@Override
	public void setGuideline3(boolean guideline3) {
		_guidelines.setGuideline3(guideline3);
	}

	/**
	* Returns the guideline4 of this guidelines.
	*
	* @return the guideline4 of this guidelines
	*/
	@Override
	public boolean getGuideline4() {
		return _guidelines.getGuideline4();
	}

	/**
	* Returns <code>true</code> if this guidelines is guideline4.
	*
	* @return <code>true</code> if this guidelines is guideline4; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuideline4() {
		return _guidelines.isGuideline4();
	}

	/**
	* Sets whether this guidelines is guideline4.
	*
	* @param guideline4 the guideline4 of this guidelines
	*/
	@Override
	public void setGuideline4(boolean guideline4) {
		_guidelines.setGuideline4(guideline4);
	}

	/**
	* Returns the guideline5 of this guidelines.
	*
	* @return the guideline5 of this guidelines
	*/
	@Override
	public boolean getGuideline5() {
		return _guidelines.getGuideline5();
	}

	/**
	* Returns <code>true</code> if this guidelines is guideline5.
	*
	* @return <code>true</code> if this guidelines is guideline5; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuideline5() {
		return _guidelines.isGuideline5();
	}

	/**
	* Sets whether this guidelines is guideline5.
	*
	* @param guideline5 the guideline5 of this guidelines
	*/
	@Override
	public void setGuideline5(boolean guideline5) {
		_guidelines.setGuideline5(guideline5);
	}

	/**
	* Returns the guideline6 of this guidelines.
	*
	* @return the guideline6 of this guidelines
	*/
	@Override
	public boolean getGuideline6() {
		return _guidelines.getGuideline6();
	}

	/**
	* Returns <code>true</code> if this guidelines is guideline6.
	*
	* @return <code>true</code> if this guidelines is guideline6; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuideline6() {
		return _guidelines.isGuideline6();
	}

	/**
	* Sets whether this guidelines is guideline6.
	*
	* @param guideline6 the guideline6 of this guidelines
	*/
	@Override
	public void setGuideline6(boolean guideline6) {
		_guidelines.setGuideline6(guideline6);
	}

	/**
	* Returns the guideline7 of this guidelines.
	*
	* @return the guideline7 of this guidelines
	*/
	@Override
	public boolean getGuideline7() {
		return _guidelines.getGuideline7();
	}

	/**
	* Returns <code>true</code> if this guidelines is guideline7.
	*
	* @return <code>true</code> if this guidelines is guideline7; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuideline7() {
		return _guidelines.isGuideline7();
	}

	/**
	* Sets whether this guidelines is guideline7.
	*
	* @param guideline7 the guideline7 of this guidelines
	*/
	@Override
	public void setGuideline7(boolean guideline7) {
		_guidelines.setGuideline7(guideline7);
	}

	/**
	* Returns the guideline8 of this guidelines.
	*
	* @return the guideline8 of this guidelines
	*/
	@Override
	public boolean getGuideline8() {
		return _guidelines.getGuideline8();
	}

	/**
	* Returns <code>true</code> if this guidelines is guideline8.
	*
	* @return <code>true</code> if this guidelines is guideline8; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuideline8() {
		return _guidelines.isGuideline8();
	}

	/**
	* Sets whether this guidelines is guideline8.
	*
	* @param guideline8 the guideline8 of this guidelines
	*/
	@Override
	public void setGuideline8(boolean guideline8) {
		_guidelines.setGuideline8(guideline8);
	}

	/**
	* Returns the more info of this guidelines.
	*
	* @return the more info of this guidelines
	*/
	@Override
	public java.lang.String getMoreInfo() {
		return _guidelines.getMoreInfo();
	}

	/**
	* Sets the more info of this guidelines.
	*
	* @param moreInfo the more info of this guidelines
	*/
	@Override
	public void setMoreInfo(java.lang.String moreInfo) {
		_guidelines.setMoreInfo(moreInfo);
	}

	@Override
	public boolean isNew() {
		return _guidelines.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_guidelines.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _guidelines.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_guidelines.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _guidelines.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _guidelines.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_guidelines.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _guidelines.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_guidelines.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_guidelines.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_guidelines.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GuidelinesWrapper((Guidelines)_guidelines.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.Guidelines guidelines) {
		return _guidelines.compareTo(guidelines);
	}

	@Override
	public int hashCode() {
		return _guidelines.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.Guidelines> toCacheModel() {
		return _guidelines.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Guidelines toEscapedModel() {
		return new GuidelinesWrapper(_guidelines.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Guidelines toUnescapedModel() {
		return new GuidelinesWrapper(_guidelines.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _guidelines.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _guidelines.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_guidelines.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GuidelinesWrapper)) {
			return false;
		}

		GuidelinesWrapper guidelinesWrapper = (GuidelinesWrapper)obj;

		if (Validator.equals(_guidelines, guidelinesWrapper._guidelines)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Guidelines getWrappedGuidelines() {
		return _guidelines;
	}

	@Override
	public Guidelines getWrappedModel() {
		return _guidelines;
	}

	@Override
	public void resetOriginalValues() {
		_guidelines.resetOriginalValues();
	}

	private Guidelines _guidelines;
}