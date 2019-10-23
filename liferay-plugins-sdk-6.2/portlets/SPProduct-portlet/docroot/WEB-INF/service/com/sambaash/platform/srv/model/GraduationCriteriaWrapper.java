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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GraduationCriteria}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see GraduationCriteria
 * @generated
 */
public class GraduationCriteriaWrapper implements GraduationCriteria,
	ModelWrapper<GraduationCriteria> {
	public GraduationCriteriaWrapper(GraduationCriteria graduationCriteria) {
		_graduationCriteria = graduationCriteria;
	}

	@Override
	public Class<?> getModelClass() {
		return GraduationCriteria.class;
	}

	@Override
	public String getModelClassName() {
		return GraduationCriteria.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spGraduationCriteriaId", getSpGraduationCriteriaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("criteriaType", getCriteriaType());
		attributes.put("criteriaLevel", getCriteriaLevel());
		attributes.put("criteriaValueRange", getCriteriaValueRange());
		attributes.put("criteriaDesc", getCriteriaDesc());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spGraduationCriteriaId = (Long)attributes.get(
				"spGraduationCriteriaId");

		if (spGraduationCriteriaId != null) {
			setSpGraduationCriteriaId(spGraduationCriteriaId);
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

		Long criteriaType = (Long)attributes.get("criteriaType");

		if (criteriaType != null) {
			setCriteriaType(criteriaType);
		}

		Long criteriaLevel = (Long)attributes.get("criteriaLevel");

		if (criteriaLevel != null) {
			setCriteriaLevel(criteriaLevel);
		}

		String criteriaValueRange = (String)attributes.get("criteriaValueRange");

		if (criteriaValueRange != null) {
			setCriteriaValueRange(criteriaValueRange);
		}

		String criteriaDesc = (String)attributes.get("criteriaDesc");

		if (criteriaDesc != null) {
			setCriteriaDesc(criteriaDesc);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	/**
	* Returns the primary key of this graduation criteria.
	*
	* @return the primary key of this graduation criteria
	*/
	@Override
	public long getPrimaryKey() {
		return _graduationCriteria.getPrimaryKey();
	}

	/**
	* Sets the primary key of this graduation criteria.
	*
	* @param primaryKey the primary key of this graduation criteria
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_graduationCriteria.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp graduation criteria ID of this graduation criteria.
	*
	* @return the sp graduation criteria ID of this graduation criteria
	*/
	@Override
	public long getSpGraduationCriteriaId() {
		return _graduationCriteria.getSpGraduationCriteriaId();
	}

	/**
	* Sets the sp graduation criteria ID of this graduation criteria.
	*
	* @param spGraduationCriteriaId the sp graduation criteria ID of this graduation criteria
	*/
	@Override
	public void setSpGraduationCriteriaId(long spGraduationCriteriaId) {
		_graduationCriteria.setSpGraduationCriteriaId(spGraduationCriteriaId);
	}

	/**
	* Returns the group ID of this graduation criteria.
	*
	* @return the group ID of this graduation criteria
	*/
	@Override
	public long getGroupId() {
		return _graduationCriteria.getGroupId();
	}

	/**
	* Sets the group ID of this graduation criteria.
	*
	* @param groupId the group ID of this graduation criteria
	*/
	@Override
	public void setGroupId(long groupId) {
		_graduationCriteria.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this graduation criteria.
	*
	* @return the company ID of this graduation criteria
	*/
	@Override
	public long getCompanyId() {
		return _graduationCriteria.getCompanyId();
	}

	/**
	* Sets the company ID of this graduation criteria.
	*
	* @param companyId the company ID of this graduation criteria
	*/
	@Override
	public void setCompanyId(long companyId) {
		_graduationCriteria.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this graduation criteria.
	*
	* @return the user ID of this graduation criteria
	*/
	@Override
	public long getUserId() {
		return _graduationCriteria.getUserId();
	}

	/**
	* Sets the user ID of this graduation criteria.
	*
	* @param userId the user ID of this graduation criteria
	*/
	@Override
	public void setUserId(long userId) {
		_graduationCriteria.setUserId(userId);
	}

	/**
	* Returns the user uuid of this graduation criteria.
	*
	* @return the user uuid of this graduation criteria
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _graduationCriteria.getUserUuid();
	}

	/**
	* Sets the user uuid of this graduation criteria.
	*
	* @param userUuid the user uuid of this graduation criteria
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_graduationCriteria.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this graduation criteria.
	*
	* @return the user name of this graduation criteria
	*/
	@Override
	public java.lang.String getUserName() {
		return _graduationCriteria.getUserName();
	}

	/**
	* Sets the user name of this graduation criteria.
	*
	* @param userName the user name of this graduation criteria
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_graduationCriteria.setUserName(userName);
	}

	/**
	* Returns the create date of this graduation criteria.
	*
	* @return the create date of this graduation criteria
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _graduationCriteria.getCreateDate();
	}

	/**
	* Sets the create date of this graduation criteria.
	*
	* @param createDate the create date of this graduation criteria
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_graduationCriteria.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this graduation criteria.
	*
	* @return the modified date of this graduation criteria
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _graduationCriteria.getModifiedDate();
	}

	/**
	* Sets the modified date of this graduation criteria.
	*
	* @param modifiedDate the modified date of this graduation criteria
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_graduationCriteria.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the criteria type of this graduation criteria.
	*
	* @return the criteria type of this graduation criteria
	*/
	@Override
	public long getCriteriaType() {
		return _graduationCriteria.getCriteriaType();
	}

	/**
	* Sets the criteria type of this graduation criteria.
	*
	* @param criteriaType the criteria type of this graduation criteria
	*/
	@Override
	public void setCriteriaType(long criteriaType) {
		_graduationCriteria.setCriteriaType(criteriaType);
	}

	/**
	* Returns the criteria level of this graduation criteria.
	*
	* @return the criteria level of this graduation criteria
	*/
	@Override
	public long getCriteriaLevel() {
		return _graduationCriteria.getCriteriaLevel();
	}

	/**
	* Sets the criteria level of this graduation criteria.
	*
	* @param criteriaLevel the criteria level of this graduation criteria
	*/
	@Override
	public void setCriteriaLevel(long criteriaLevel) {
		_graduationCriteria.setCriteriaLevel(criteriaLevel);
	}

	/**
	* Returns the criteria value range of this graduation criteria.
	*
	* @return the criteria value range of this graduation criteria
	*/
	@Override
	public java.lang.String getCriteriaValueRange() {
		return _graduationCriteria.getCriteriaValueRange();
	}

	/**
	* Sets the criteria value range of this graduation criteria.
	*
	* @param criteriaValueRange the criteria value range of this graduation criteria
	*/
	@Override
	public void setCriteriaValueRange(java.lang.String criteriaValueRange) {
		_graduationCriteria.setCriteriaValueRange(criteriaValueRange);
	}

	/**
	* Returns the criteria desc of this graduation criteria.
	*
	* @return the criteria desc of this graduation criteria
	*/
	@Override
	public java.lang.String getCriteriaDesc() {
		return _graduationCriteria.getCriteriaDesc();
	}

	/**
	* Sets the criteria desc of this graduation criteria.
	*
	* @param criteriaDesc the criteria desc of this graduation criteria
	*/
	@Override
	public void setCriteriaDesc(java.lang.String criteriaDesc) {
		_graduationCriteria.setCriteriaDesc(criteriaDesc);
	}

	/**
	* Returns the sp course ID of this graduation criteria.
	*
	* @return the sp course ID of this graduation criteria
	*/
	@Override
	public long getSpCourseId() {
		return _graduationCriteria.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this graduation criteria.
	*
	* @param spCourseId the sp course ID of this graduation criteria
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_graduationCriteria.setSpCourseId(spCourseId);
	}

	@Override
	public boolean isNew() {
		return _graduationCriteria.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_graduationCriteria.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _graduationCriteria.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_graduationCriteria.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _graduationCriteria.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _graduationCriteria.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_graduationCriteria.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _graduationCriteria.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_graduationCriteria.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_graduationCriteria.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_graduationCriteria.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GraduationCriteriaWrapper((GraduationCriteria)_graduationCriteria.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria) {
		return _graduationCriteria.compareTo(graduationCriteria);
	}

	@Override
	public int hashCode() {
		return _graduationCriteria.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.GraduationCriteria> toCacheModel() {
		return _graduationCriteria.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria toEscapedModel() {
		return new GraduationCriteriaWrapper(_graduationCriteria.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.GraduationCriteria toUnescapedModel() {
		return new GraduationCriteriaWrapper(_graduationCriteria.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _graduationCriteria.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _graduationCriteria.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_graduationCriteria.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GraduationCriteriaWrapper)) {
			return false;
		}

		GraduationCriteriaWrapper graduationCriteriaWrapper = (GraduationCriteriaWrapper)obj;

		if (Validator.equals(_graduationCriteria,
					graduationCriteriaWrapper._graduationCriteria)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GraduationCriteria getWrappedGraduationCriteria() {
		return _graduationCriteria;
	}

	@Override
	public GraduationCriteria getWrappedModel() {
		return _graduationCriteria;
	}

	@Override
	public void resetOriginalValues() {
		_graduationCriteria.resetOriginalValues();
	}

	private GraduationCriteria _graduationCriteria;
}