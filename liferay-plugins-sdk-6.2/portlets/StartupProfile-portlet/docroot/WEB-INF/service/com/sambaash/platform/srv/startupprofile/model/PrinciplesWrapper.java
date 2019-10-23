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
 * This class is a wrapper for {@link Principles}.
 * </p>
 *
 * @author pradeep
 * @see Principles
 * @generated
 */
public class PrinciplesWrapper implements Principles, ModelWrapper<Principles> {
	public PrinciplesWrapper(Principles principles) {
		_principles = principles;
	}

	@Override
	public Class<?> getModelClass() {
		return Principles.class;
	}

	@Override
	public String getModelClassName() {
		return Principles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("siteId", getSiteId());
		attributes.put("principleId", getPrincipleId());
		attributes.put("principleText", getPrincipleText());
		attributes.put("guideline1", getGuideline1());
		attributes.put("guideline2", getGuideline2());
		attributes.put("guideline3", getGuideline3());
		attributes.put("guideline4", getGuideline4());
		attributes.put("guideline5", getGuideline5());
		attributes.put("guideline6", getGuideline6());
		attributes.put("guideline7", getGuideline7());
		attributes.put("guideline8", getGuideline8());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long siteId = (Long)attributes.get("siteId");

		if (siteId != null) {
			setSiteId(siteId);
		}

		Long principleId = (Long)attributes.get("principleId");

		if (principleId != null) {
			setPrincipleId(principleId);
		}

		String principleText = (String)attributes.get("principleText");

		if (principleText != null) {
			setPrincipleText(principleText);
		}

		String guideline1 = (String)attributes.get("guideline1");

		if (guideline1 != null) {
			setGuideline1(guideline1);
		}

		String guideline2 = (String)attributes.get("guideline2");

		if (guideline2 != null) {
			setGuideline2(guideline2);
		}

		String guideline3 = (String)attributes.get("guideline3");

		if (guideline3 != null) {
			setGuideline3(guideline3);
		}

		String guideline4 = (String)attributes.get("guideline4");

		if (guideline4 != null) {
			setGuideline4(guideline4);
		}

		String guideline5 = (String)attributes.get("guideline5");

		if (guideline5 != null) {
			setGuideline5(guideline5);
		}

		String guideline6 = (String)attributes.get("guideline6");

		if (guideline6 != null) {
			setGuideline6(guideline6);
		}

		String guideline7 = (String)attributes.get("guideline7");

		if (guideline7 != null) {
			setGuideline7(guideline7);
		}

		String guideline8 = (String)attributes.get("guideline8");

		if (guideline8 != null) {
			setGuideline8(guideline8);
		}
	}

	/**
	* Returns the primary key of this principles.
	*
	* @return the primary key of this principles
	*/
	@Override
	public long getPrimaryKey() {
		return _principles.getPrimaryKey();
	}

	/**
	* Sets the primary key of this principles.
	*
	* @param primaryKey the primary key of this principles
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_principles.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this principles.
	*
	* @return the uuid of this principles
	*/
	@Override
	public java.lang.String getUuid() {
		return _principles.getUuid();
	}

	/**
	* Sets the uuid of this principles.
	*
	* @param uuid the uuid of this principles
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_principles.setUuid(uuid);
	}

	/**
	* Returns the site ID of this principles.
	*
	* @return the site ID of this principles
	*/
	@Override
	public long getSiteId() {
		return _principles.getSiteId();
	}

	/**
	* Sets the site ID of this principles.
	*
	* @param siteId the site ID of this principles
	*/
	@Override
	public void setSiteId(long siteId) {
		_principles.setSiteId(siteId);
	}

	/**
	* Returns the principle ID of this principles.
	*
	* @return the principle ID of this principles
	*/
	@Override
	public long getPrincipleId() {
		return _principles.getPrincipleId();
	}

	/**
	* Sets the principle ID of this principles.
	*
	* @param principleId the principle ID of this principles
	*/
	@Override
	public void setPrincipleId(long principleId) {
		_principles.setPrincipleId(principleId);
	}

	/**
	* Returns the principle text of this principles.
	*
	* @return the principle text of this principles
	*/
	@Override
	public java.lang.String getPrincipleText() {
		return _principles.getPrincipleText();
	}

	/**
	* Sets the principle text of this principles.
	*
	* @param principleText the principle text of this principles
	*/
	@Override
	public void setPrincipleText(java.lang.String principleText) {
		_principles.setPrincipleText(principleText);
	}

	/**
	* Returns the guideline1 of this principles.
	*
	* @return the guideline1 of this principles
	*/
	@Override
	public java.lang.String getGuideline1() {
		return _principles.getGuideline1();
	}

	/**
	* Sets the guideline1 of this principles.
	*
	* @param guideline1 the guideline1 of this principles
	*/
	@Override
	public void setGuideline1(java.lang.String guideline1) {
		_principles.setGuideline1(guideline1);
	}

	/**
	* Returns the guideline2 of this principles.
	*
	* @return the guideline2 of this principles
	*/
	@Override
	public java.lang.String getGuideline2() {
		return _principles.getGuideline2();
	}

	/**
	* Sets the guideline2 of this principles.
	*
	* @param guideline2 the guideline2 of this principles
	*/
	@Override
	public void setGuideline2(java.lang.String guideline2) {
		_principles.setGuideline2(guideline2);
	}

	/**
	* Returns the guideline3 of this principles.
	*
	* @return the guideline3 of this principles
	*/
	@Override
	public java.lang.String getGuideline3() {
		return _principles.getGuideline3();
	}

	/**
	* Sets the guideline3 of this principles.
	*
	* @param guideline3 the guideline3 of this principles
	*/
	@Override
	public void setGuideline3(java.lang.String guideline3) {
		_principles.setGuideline3(guideline3);
	}

	/**
	* Returns the guideline4 of this principles.
	*
	* @return the guideline4 of this principles
	*/
	@Override
	public java.lang.String getGuideline4() {
		return _principles.getGuideline4();
	}

	/**
	* Sets the guideline4 of this principles.
	*
	* @param guideline4 the guideline4 of this principles
	*/
	@Override
	public void setGuideline4(java.lang.String guideline4) {
		_principles.setGuideline4(guideline4);
	}

	/**
	* Returns the guideline5 of this principles.
	*
	* @return the guideline5 of this principles
	*/
	@Override
	public java.lang.String getGuideline5() {
		return _principles.getGuideline5();
	}

	/**
	* Sets the guideline5 of this principles.
	*
	* @param guideline5 the guideline5 of this principles
	*/
	@Override
	public void setGuideline5(java.lang.String guideline5) {
		_principles.setGuideline5(guideline5);
	}

	/**
	* Returns the guideline6 of this principles.
	*
	* @return the guideline6 of this principles
	*/
	@Override
	public java.lang.String getGuideline6() {
		return _principles.getGuideline6();
	}

	/**
	* Sets the guideline6 of this principles.
	*
	* @param guideline6 the guideline6 of this principles
	*/
	@Override
	public void setGuideline6(java.lang.String guideline6) {
		_principles.setGuideline6(guideline6);
	}

	/**
	* Returns the guideline7 of this principles.
	*
	* @return the guideline7 of this principles
	*/
	@Override
	public java.lang.String getGuideline7() {
		return _principles.getGuideline7();
	}

	/**
	* Sets the guideline7 of this principles.
	*
	* @param guideline7 the guideline7 of this principles
	*/
	@Override
	public void setGuideline7(java.lang.String guideline7) {
		_principles.setGuideline7(guideline7);
	}

	/**
	* Returns the guideline8 of this principles.
	*
	* @return the guideline8 of this principles
	*/
	@Override
	public java.lang.String getGuideline8() {
		return _principles.getGuideline8();
	}

	/**
	* Sets the guideline8 of this principles.
	*
	* @param guideline8 the guideline8 of this principles
	*/
	@Override
	public void setGuideline8(java.lang.String guideline8) {
		_principles.setGuideline8(guideline8);
	}

	@Override
	public boolean isNew() {
		return _principles.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_principles.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _principles.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_principles.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _principles.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _principles.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_principles.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _principles.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_principles.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_principles.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_principles.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PrinciplesWrapper((Principles)_principles.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.Principles principles) {
		return _principles.compareTo(principles);
	}

	@Override
	public int hashCode() {
		return _principles.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.Principles> toCacheModel() {
		return _principles.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Principles toEscapedModel() {
		return new PrinciplesWrapper(_principles.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Principles toUnescapedModel() {
		return new PrinciplesWrapper(_principles.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _principles.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _principles.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_principles.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PrinciplesWrapper)) {
			return false;
		}

		PrinciplesWrapper principlesWrapper = (PrinciplesWrapper)obj;

		if (Validator.equals(_principles, principlesWrapper._principles)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Principles getWrappedPrinciples() {
		return _principles;
	}

	@Override
	public Principles getWrappedModel() {
		return _principles;
	}

	@Override
	public void resetOriginalValues() {
		_principles.resetOriginalValues();
	}

	private Principles _principles;
}