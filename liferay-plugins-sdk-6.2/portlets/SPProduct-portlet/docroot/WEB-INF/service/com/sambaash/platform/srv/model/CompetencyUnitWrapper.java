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
 * This class is a wrapper for {@link CompetencyUnit}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CompetencyUnit
 * @generated
 */
public class CompetencyUnitWrapper implements CompetencyUnit,
	ModelWrapper<CompetencyUnit> {
	public CompetencyUnitWrapper(CompetencyUnit competencyUnit) {
		_competencyUnit = competencyUnit;
	}

	@Override
	public Class<?> getModelClass() {
		return CompetencyUnit.class;
	}

	@Override
	public String getModelClassName() {
		return CompetencyUnit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCompetencyUnitId", getSpCompetencyUnitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("spFrameworkId", getSpFrameworkId());
		attributes.put("competencyUnitCode", getCompetencyUnitCode());
		attributes.put("competencyUnitDesc", getCompetencyUnitDesc());
		attributes.put("jobFamily", getJobFamily());
		attributes.put("competencyLevel", getCompetencyLevel());
		attributes.put("creditValue", getCreditValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCompetencyUnitId = (Long)attributes.get("spCompetencyUnitId");

		if (spCompetencyUnitId != null) {
			setSpCompetencyUnitId(spCompetencyUnitId);
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

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long spFrameworkId = (Long)attributes.get("spFrameworkId");

		if (spFrameworkId != null) {
			setSpFrameworkId(spFrameworkId);
		}

		String competencyUnitCode = (String)attributes.get("competencyUnitCode");

		if (competencyUnitCode != null) {
			setCompetencyUnitCode(competencyUnitCode);
		}

		String competencyUnitDesc = (String)attributes.get("competencyUnitDesc");

		if (competencyUnitDesc != null) {
			setCompetencyUnitDesc(competencyUnitDesc);
		}

		Long jobFamily = (Long)attributes.get("jobFamily");

		if (jobFamily != null) {
			setJobFamily(jobFamily);
		}

		Long competencyLevel = (Long)attributes.get("competencyLevel");

		if (competencyLevel != null) {
			setCompetencyLevel(competencyLevel);
		}

		Long creditValue = (Long)attributes.get("creditValue");

		if (creditValue != null) {
			setCreditValue(creditValue);
		}
	}

	/**
	* Returns the primary key of this competency unit.
	*
	* @return the primary key of this competency unit
	*/
	@Override
	public long getPrimaryKey() {
		return _competencyUnit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this competency unit.
	*
	* @param primaryKey the primary key of this competency unit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_competencyUnit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp competency unit ID of this competency unit.
	*
	* @return the sp competency unit ID of this competency unit
	*/
	@Override
	public long getSpCompetencyUnitId() {
		return _competencyUnit.getSpCompetencyUnitId();
	}

	/**
	* Sets the sp competency unit ID of this competency unit.
	*
	* @param spCompetencyUnitId the sp competency unit ID of this competency unit
	*/
	@Override
	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_competencyUnit.setSpCompetencyUnitId(spCompetencyUnitId);
	}

	/**
	* Returns the group ID of this competency unit.
	*
	* @return the group ID of this competency unit
	*/
	@Override
	public long getGroupId() {
		return _competencyUnit.getGroupId();
	}

	/**
	* Sets the group ID of this competency unit.
	*
	* @param groupId the group ID of this competency unit
	*/
	@Override
	public void setGroupId(long groupId) {
		_competencyUnit.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this competency unit.
	*
	* @return the company ID of this competency unit
	*/
	@Override
	public long getCompanyId() {
		return _competencyUnit.getCompanyId();
	}

	/**
	* Sets the company ID of this competency unit.
	*
	* @param companyId the company ID of this competency unit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_competencyUnit.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this competency unit.
	*
	* @return the user ID of this competency unit
	*/
	@Override
	public long getUserId() {
		return _competencyUnit.getUserId();
	}

	/**
	* Sets the user ID of this competency unit.
	*
	* @param userId the user ID of this competency unit
	*/
	@Override
	public void setUserId(long userId) {
		_competencyUnit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this competency unit.
	*
	* @return the user uuid of this competency unit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _competencyUnit.getUserUuid();
	}

	/**
	* Sets the user uuid of this competency unit.
	*
	* @param userUuid the user uuid of this competency unit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_competencyUnit.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this competency unit.
	*
	* @return the user name of this competency unit
	*/
	@Override
	public java.lang.String getUserName() {
		return _competencyUnit.getUserName();
	}

	/**
	* Sets the user name of this competency unit.
	*
	* @param userName the user name of this competency unit
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_competencyUnit.setUserName(userName);
	}

	/**
	* Returns the create date of this competency unit.
	*
	* @return the create date of this competency unit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _competencyUnit.getCreateDate();
	}

	/**
	* Sets the create date of this competency unit.
	*
	* @param createDate the create date of this competency unit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_competencyUnit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this competency unit.
	*
	* @return the modified date of this competency unit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _competencyUnit.getModifiedDate();
	}

	/**
	* Sets the modified date of this competency unit.
	*
	* @param modifiedDate the modified date of this competency unit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_competencyUnit.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country ID of this competency unit.
	*
	* @return the country ID of this competency unit
	*/
	@Override
	public long getCountryId() {
		return _competencyUnit.getCountryId();
	}

	/**
	* Sets the country ID of this competency unit.
	*
	* @param countryId the country ID of this competency unit
	*/
	@Override
	public void setCountryId(long countryId) {
		_competencyUnit.setCountryId(countryId);
	}

	/**
	* Returns the sp framework ID of this competency unit.
	*
	* @return the sp framework ID of this competency unit
	*/
	@Override
	public long getSpFrameworkId() {
		return _competencyUnit.getSpFrameworkId();
	}

	/**
	* Sets the sp framework ID of this competency unit.
	*
	* @param spFrameworkId the sp framework ID of this competency unit
	*/
	@Override
	public void setSpFrameworkId(long spFrameworkId) {
		_competencyUnit.setSpFrameworkId(spFrameworkId);
	}

	/**
	* Returns the competency unit code of this competency unit.
	*
	* @return the competency unit code of this competency unit
	*/
	@Override
	public java.lang.String getCompetencyUnitCode() {
		return _competencyUnit.getCompetencyUnitCode();
	}

	/**
	* Sets the competency unit code of this competency unit.
	*
	* @param competencyUnitCode the competency unit code of this competency unit
	*/
	@Override
	public void setCompetencyUnitCode(java.lang.String competencyUnitCode) {
		_competencyUnit.setCompetencyUnitCode(competencyUnitCode);
	}

	/**
	* Returns the competency unit desc of this competency unit.
	*
	* @return the competency unit desc of this competency unit
	*/
	@Override
	public java.lang.String getCompetencyUnitDesc() {
		return _competencyUnit.getCompetencyUnitDesc();
	}

	/**
	* Sets the competency unit desc of this competency unit.
	*
	* @param competencyUnitDesc the competency unit desc of this competency unit
	*/
	@Override
	public void setCompetencyUnitDesc(java.lang.String competencyUnitDesc) {
		_competencyUnit.setCompetencyUnitDesc(competencyUnitDesc);
	}

	/**
	* Returns the job family of this competency unit.
	*
	* @return the job family of this competency unit
	*/
	@Override
	public long getJobFamily() {
		return _competencyUnit.getJobFamily();
	}

	/**
	* Sets the job family of this competency unit.
	*
	* @param jobFamily the job family of this competency unit
	*/
	@Override
	public void setJobFamily(long jobFamily) {
		_competencyUnit.setJobFamily(jobFamily);
	}

	/**
	* Returns the competency level of this competency unit.
	*
	* @return the competency level of this competency unit
	*/
	@Override
	public long getCompetencyLevel() {
		return _competencyUnit.getCompetencyLevel();
	}

	/**
	* Sets the competency level of this competency unit.
	*
	* @param competencyLevel the competency level of this competency unit
	*/
	@Override
	public void setCompetencyLevel(long competencyLevel) {
		_competencyUnit.setCompetencyLevel(competencyLevel);
	}

	/**
	* Returns the credit value of this competency unit.
	*
	* @return the credit value of this competency unit
	*/
	@Override
	public long getCreditValue() {
		return _competencyUnit.getCreditValue();
	}

	/**
	* Sets the credit value of this competency unit.
	*
	* @param creditValue the credit value of this competency unit
	*/
	@Override
	public void setCreditValue(long creditValue) {
		_competencyUnit.setCreditValue(creditValue);
	}

	@Override
	public boolean isNew() {
		return _competencyUnit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_competencyUnit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _competencyUnit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_competencyUnit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _competencyUnit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _competencyUnit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_competencyUnit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _competencyUnit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_competencyUnit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_competencyUnit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_competencyUnit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CompetencyUnitWrapper((CompetencyUnit)_competencyUnit.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.CompetencyUnit competencyUnit) {
		return _competencyUnit.compareTo(competencyUnit);
	}

	@Override
	public int hashCode() {
		return _competencyUnit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.CompetencyUnit> toCacheModel() {
		return _competencyUnit.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit toEscapedModel() {
		return new CompetencyUnitWrapper(_competencyUnit.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.CompetencyUnit toUnescapedModel() {
		return new CompetencyUnitWrapper(_competencyUnit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _competencyUnit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _competencyUnit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_competencyUnit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompetencyUnitWrapper)) {
			return false;
		}

		CompetencyUnitWrapper competencyUnitWrapper = (CompetencyUnitWrapper)obj;

		if (Validator.equals(_competencyUnit,
					competencyUnitWrapper._competencyUnit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CompetencyUnit getWrappedCompetencyUnit() {
		return _competencyUnit;
	}

	@Override
	public CompetencyUnit getWrappedModel() {
		return _competencyUnit;
	}

	@Override
	public void resetOriginalValues() {
		_competencyUnit.resetOriginalValues();
	}

	private CompetencyUnit _competencyUnit;
}