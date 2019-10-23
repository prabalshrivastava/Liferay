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
 * This class is a wrapper for {@link SPJobRole}.
 * </p>
 *
 * @author harini
 * @see SPJobRole
 * @generated
 */
public class SPJobRoleWrapper implements SPJobRole, ModelWrapper<SPJobRole> {
	public SPJobRoleWrapper(SPJobRole spJobRole) {
		_spJobRole = spJobRole;
	}

	@Override
	public Class<?> getModelClass() {
		return SPJobRole.class;
	}

	@Override
	public String getModelClassName() {
		return SPJobRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spJobRoleId", getSpJobRoleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("functionalGroupId", getFunctionalGroupId());
		attributes.put("JobLevelId", getJobLevelId());
		attributes.put("careerPathId", getCareerPathId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spJobRoleId = (Long)attributes.get("spJobRoleId");

		if (spJobRoleId != null) {
			setSpJobRoleId(spJobRoleId);
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

		Long functionalGroupId = (Long)attributes.get("functionalGroupId");

		if (functionalGroupId != null) {
			setFunctionalGroupId(functionalGroupId);
		}

		Long JobLevelId = (Long)attributes.get("JobLevelId");

		if (JobLevelId != null) {
			setJobLevelId(JobLevelId);
		}

		Long careerPathId = (Long)attributes.get("careerPathId");

		if (careerPathId != null) {
			setCareerPathId(careerPathId);
		}
	}

	/**
	* Returns the primary key of this s p job role.
	*
	* @return the primary key of this s p job role
	*/
	@Override
	public long getPrimaryKey() {
		return _spJobRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p job role.
	*
	* @param primaryKey the primary key of this s p job role
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spJobRole.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp job role ID of this s p job role.
	*
	* @return the sp job role ID of this s p job role
	*/
	@Override
	public long getSpJobRoleId() {
		return _spJobRole.getSpJobRoleId();
	}

	/**
	* Sets the sp job role ID of this s p job role.
	*
	* @param spJobRoleId the sp job role ID of this s p job role
	*/
	@Override
	public void setSpJobRoleId(long spJobRoleId) {
		_spJobRole.setSpJobRoleId(spJobRoleId);
	}

	/**
	* Returns the group ID of this s p job role.
	*
	* @return the group ID of this s p job role
	*/
	@Override
	public long getGroupId() {
		return _spJobRole.getGroupId();
	}

	/**
	* Sets the group ID of this s p job role.
	*
	* @param groupId the group ID of this s p job role
	*/
	@Override
	public void setGroupId(long groupId) {
		_spJobRole.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p job role.
	*
	* @return the company ID of this s p job role
	*/
	@Override
	public long getCompanyId() {
		return _spJobRole.getCompanyId();
	}

	/**
	* Sets the company ID of this s p job role.
	*
	* @param companyId the company ID of this s p job role
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spJobRole.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p job role.
	*
	* @return the user ID of this s p job role
	*/
	@Override
	public long getUserId() {
		return _spJobRole.getUserId();
	}

	/**
	* Sets the user ID of this s p job role.
	*
	* @param userId the user ID of this s p job role
	*/
	@Override
	public void setUserId(long userId) {
		_spJobRole.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p job role.
	*
	* @return the user uuid of this s p job role
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobRole.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p job role.
	*
	* @param userUuid the user uuid of this s p job role
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spJobRole.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p job role.
	*
	* @return the user name of this s p job role
	*/
	@Override
	public java.lang.String getUserName() {
		return _spJobRole.getUserName();
	}

	/**
	* Sets the user name of this s p job role.
	*
	* @param userName the user name of this s p job role
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spJobRole.setUserName(userName);
	}

	/**
	* Returns the create date of this s p job role.
	*
	* @return the create date of this s p job role
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spJobRole.getCreateDate();
	}

	/**
	* Sets the create date of this s p job role.
	*
	* @param createDate the create date of this s p job role
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spJobRole.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p job role.
	*
	* @return the modified date of this s p job role
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spJobRole.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p job role.
	*
	* @param modifiedDate the modified date of this s p job role
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spJobRole.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the functional group ID of this s p job role.
	*
	* @return the functional group ID of this s p job role
	*/
	@Override
	public long getFunctionalGroupId() {
		return _spJobRole.getFunctionalGroupId();
	}

	/**
	* Sets the functional group ID of this s p job role.
	*
	* @param functionalGroupId the functional group ID of this s p job role
	*/
	@Override
	public void setFunctionalGroupId(long functionalGroupId) {
		_spJobRole.setFunctionalGroupId(functionalGroupId);
	}

	/**
	* Returns the job level ID of this s p job role.
	*
	* @return the job level ID of this s p job role
	*/
	@Override
	public long getJobLevelId() {
		return _spJobRole.getJobLevelId();
	}

	/**
	* Sets the job level ID of this s p job role.
	*
	* @param JobLevelId the job level ID of this s p job role
	*/
	@Override
	public void setJobLevelId(long JobLevelId) {
		_spJobRole.setJobLevelId(JobLevelId);
	}

	/**
	* Returns the career path ID of this s p job role.
	*
	* @return the career path ID of this s p job role
	*/
	@Override
	public long getCareerPathId() {
		return _spJobRole.getCareerPathId();
	}

	/**
	* Sets the career path ID of this s p job role.
	*
	* @param careerPathId the career path ID of this s p job role
	*/
	@Override
	public void setCareerPathId(long careerPathId) {
		_spJobRole.setCareerPathId(careerPathId);
	}

	@Override
	public boolean isNew() {
		return _spJobRole.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spJobRole.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spJobRole.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spJobRole.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spJobRole.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spJobRole.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spJobRole.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spJobRole.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spJobRole.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spJobRole.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spJobRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPJobRoleWrapper((SPJobRole)_spJobRole.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.extendedprofile.model.SPJobRole spJobRole) {
		return _spJobRole.compareTo(spJobRole);
	}

	@Override
	public int hashCode() {
		return _spJobRole.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.extendedprofile.model.SPJobRole> toCacheModel() {
		return _spJobRole.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPJobRole toEscapedModel() {
		return new SPJobRoleWrapper(_spJobRole.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.extendedprofile.model.SPJobRole toUnescapedModel() {
		return new SPJobRoleWrapper(_spJobRole.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spJobRole.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spJobRole.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spJobRole.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPJobRoleWrapper)) {
			return false;
		}

		SPJobRoleWrapper spJobRoleWrapper = (SPJobRoleWrapper)obj;

		if (Validator.equals(_spJobRole, spJobRoleWrapper._spJobRole)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPJobRole getWrappedSPJobRole() {
		return _spJobRole;
	}

	@Override
	public SPJobRole getWrappedModel() {
		return _spJobRole;
	}

	@Override
	public void resetOriginalValues() {
		_spJobRole.resetOriginalValues();
	}

	private SPJobRole _spJobRole;
}