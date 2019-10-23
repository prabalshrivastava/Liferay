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

package com.sambaash.platform.srv.extendedprofile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPCompetency}.
 * </p>
 *
 * @author harini
 * @see SPCompetency
 * @generated
 */
public class SPCompetencyWrapper implements SPCompetency,
	ModelWrapper<SPCompetency> {
	public SPCompetencyWrapper(SPCompetency spCompetency) {
		_spCompetency = spCompetency;
	}

	@Override
	public Class<?> getModelClass() {
		return SPCompetency.class;
	}

	@Override
	public String getModelClassName() {
		return SPCompetency.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("classpk", getClasspk());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("competencyId", getCompetencyId());
		attributes.put("competencyLevelId", getCompetencyLevelId());
		attributes.put("belongsToJobRole", getBelongsToJobRole());
		attributes.put("publicView", getPublicView());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long classpk = (Long)attributes.get("classpk");

		if (classpk != null) {
			setClasspk(classpk);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long competencyId = (Long)attributes.get("competencyId");

		if (competencyId != null) {
			setCompetencyId(competencyId);
		}

		Long competencyLevelId = (Long)attributes.get("competencyLevelId");

		if (competencyLevelId != null) {
			setCompetencyLevelId(competencyLevelId);
		}

		Long belongsToJobRole = (Long)attributes.get("belongsToJobRole");

		if (belongsToJobRole != null) {
			setBelongsToJobRole(belongsToJobRole);
		}

		Boolean publicView = (Boolean)attributes.get("publicView");

		if (publicView != null) {
			setPublicView(publicView);
		}
	}

	/**
	* Returns the primary key of this s p competency.
	*
	* @return the primary key of this s p competency
	*/
	@Override
	public long getPrimaryKey() {
		return _spCompetency.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p competency.
	*
	* @param primaryKey the primary key of this s p competency
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spCompetency.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the classpk of this s p competency.
	*
	* @return the classpk of this s p competency
	*/
	@Override
	public long getClasspk() {
		return _spCompetency.getClasspk();
	}

	/**
	* Sets the classpk of this s p competency.
	*
	* @param classpk the classpk of this s p competency
	*/
	@Override
	public void setClasspk(long classpk) {
		_spCompetency.setClasspk(classpk);
	}

	/**
	* Returns the group ID of this s p competency.
	*
	* @return the group ID of this s p competency
	*/
	@Override
	public long getGroupId() {
		return _spCompetency.getGroupId();
	}

	/**
	* Sets the group ID of this s p competency.
	*
	* @param groupId the group ID of this s p competency
	*/
	@Override
	public void setGroupId(long groupId) {
		_spCompetency.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p competency.
	*
	* @return the company ID of this s p competency
	*/
	@Override
	public long getCompanyId() {
		return _spCompetency.getCompanyId();
	}

	/**
	* Sets the company ID of this s p competency.
	*
	* @param companyId the company ID of this s p competency
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spCompetency.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p competency.
	*
	* @return the user ID of this s p competency
	*/
	@Override
	public long getUserId() {
		return _spCompetency.getUserId();
	}

	/**
	* Sets the user ID of this s p competency.
	*
	* @param userId the user ID of this s p competency
	*/
	@Override
	public void setUserId(long userId) {
		_spCompetency.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p competency.
	*
	* @return the user uuid of this s p competency
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spCompetency.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p competency.
	*
	* @param userUuid the user uuid of this s p competency
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spCompetency.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p competency.
	*
	* @return the user name of this s p competency
	*/
	@Override
	public java.lang.String getUserName() {
		return _spCompetency.getUserName();
	}

	/**
	* Sets the user name of this s p competency.
	*
	* @param userName the user name of this s p competency
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spCompetency.setUserName(userName);
	}

	/**
	* Returns the create date of this s p competency.
	*
	* @return the create date of this s p competency
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spCompetency.getCreateDate();
	}

	/**
	* Sets the create date of this s p competency.
	*
	* @param createDate the create date of this s p competency
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spCompetency.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p competency.
	*
	* @return the modified date of this s p competency
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spCompetency.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p competency.
	*
	* @param modifiedDate the modified date of this s p competency
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spCompetency.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category ID of this s p competency.
	*
	* @return the category ID of this s p competency
	*/
	@Override
	public long getCategoryId() {
		return _spCompetency.getCategoryId();
	}

	/**
	* Sets the category ID of this s p competency.
	*
	* @param categoryId the category ID of this s p competency
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_spCompetency.setCategoryId(categoryId);
	}

	/**
	* Returns the competency ID of this s p competency.
	*
	* @return the competency ID of this s p competency
	*/
	@Override
	public long getCompetencyId() {
		return _spCompetency.getCompetencyId();
	}

	/**
	* Sets the competency ID of this s p competency.
	*
	* @param competencyId the competency ID of this s p competency
	*/
	@Override
	public void setCompetencyId(long competencyId) {
		_spCompetency.setCompetencyId(competencyId);
	}

	/**
	* Returns the competency level ID of this s p competency.
	*
	* @return the competency level ID of this s p competency
	*/
	@Override
	public long getCompetencyLevelId() {
		return _spCompetency.getCompetencyLevelId();
	}

	/**
	* Sets the competency level ID of this s p competency.
	*
	* @param competencyLevelId the competency level ID of this s p competency
	*/
	@Override
	public void setCompetencyLevelId(long competencyLevelId) {
		_spCompetency.setCompetencyLevelId(competencyLevelId);
	}

	/**
	* Returns the belongs to job role of this s p competency.
	*
	* @return the belongs to job role of this s p competency
	*/
	@Override
	public long getBelongsToJobRole() {
		return _spCompetency.getBelongsToJobRole();
	}

	/**
	* Sets the belongs to job role of this s p competency.
	*
	* @param belongsToJobRole the belongs to job role of this s p competency
	*/
	@Override
	public void setBelongsToJobRole(long belongsToJobRole) {
		_spCompetency.setBelongsToJobRole(belongsToJobRole);
	}

	/**
	* Returns the public view of this s p competency.
	*
	* @return the public view of this s p competency
	*/
	@Override
	public boolean getPublicView() {
		return _spCompetency.getPublicView();
	}

	/**
	* Returns <code>true</code> if this s p competency is public view.
	*
	* @return <code>true</code> if this s p competency is public view; <code>false</code> otherwise
	*/
	@Override
	public boolean isPublicView() {
		return _spCompetency.isPublicView();
	}

	/**
	* Sets whether this s p competency is public view.
	*
	* @param publicView the public view of this s p competency
	*/
	@Override
	public void setPublicView(boolean publicView) {
		_spCompetency.setPublicView(publicView);
	}

	@Override
	public boolean isNew() {
		return _spCompetency.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spCompetency.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spCompetency.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spCompetency.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spCompetency.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spCompetency.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spCompetency.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spCompetency.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spCompetency.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spCompetency.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spCompetency.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPCompetencyWrapper((SPCompetency)_spCompetency.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.extendedprofile.model.SPCompetency spCompetency) {
		return _spCompetency.compareTo(spCompetency);
	}

	@Override
	public int hashCode() {
		return _spCompetency.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.extendedprofile.model.SPCompetency> toCacheModel() {
		return _spCompetency.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency toEscapedModel() {
		return new SPCompetencyWrapper(_spCompetency.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPCompetency toUnescapedModel() {
		return new SPCompetencyWrapper(_spCompetency.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spCompetency.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spCompetency.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spCompetency.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPCompetencyWrapper)) {
			return false;
		}

		SPCompetencyWrapper spCompetencyWrapper = (SPCompetencyWrapper)obj;

		if (Validator.equals(_spCompetency, spCompetencyWrapper._spCompetency)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPCompetency getWrappedSPCompetency() {
		return _spCompetency;
	}

	@Override
	public SPCompetency getWrappedModel() {
		return _spCompetency;
	}

	@Override
	public void resetOriginalValues() {
		_spCompetency.resetOriginalValues();
	}

	private SPCompetency _spCompetency;
}