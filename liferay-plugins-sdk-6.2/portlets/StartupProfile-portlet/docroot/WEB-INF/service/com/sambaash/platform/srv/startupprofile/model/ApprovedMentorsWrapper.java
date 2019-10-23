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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ApprovedMentors}.
 * </p>
 *
 * @author pradeep
 * @see ApprovedMentors
 * @generated
 */
public class ApprovedMentorsWrapper implements ApprovedMentors,
	ModelWrapper<ApprovedMentors> {
	public ApprovedMentorsWrapper(ApprovedMentors approvedMentors) {
		_approvedMentors = approvedMentors;
	}

	@Override
	public Class<?> getModelClass() {
		return ApprovedMentors.class;
	}

	@Override
	public String getModelClassName() {
		return ApprovedMentors.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("mentorId", getMentorId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("approvedDate", getApprovedDate());
		attributes.put("remarks", getRemarks());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long mentorId = (Long)attributes.get("mentorId");

		if (mentorId != null) {
			setMentorId(mentorId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date approvedDate = (Date)attributes.get("approvedDate");

		if (approvedDate != null) {
			setApprovedDate(approvedDate);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this approved mentors.
	*
	* @return the primary key of this approved mentors
	*/
	@Override
	public long getPrimaryKey() {
		return _approvedMentors.getPrimaryKey();
	}

	/**
	* Sets the primary key of this approved mentors.
	*
	* @param primaryKey the primary key of this approved mentors
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_approvedMentors.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this approved mentors.
	*
	* @return the uuid of this approved mentors
	*/
	@Override
	public java.lang.String getUuid() {
		return _approvedMentors.getUuid();
	}

	/**
	* Sets the uuid of this approved mentors.
	*
	* @param uuid the uuid of this approved mentors
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_approvedMentors.setUuid(uuid);
	}

	/**
	* Returns the mentor ID of this approved mentors.
	*
	* @return the mentor ID of this approved mentors
	*/
	@Override
	public long getMentorId() {
		return _approvedMentors.getMentorId();
	}

	/**
	* Sets the mentor ID of this approved mentors.
	*
	* @param mentorId the mentor ID of this approved mentors
	*/
	@Override
	public void setMentorId(long mentorId) {
		_approvedMentors.setMentorId(mentorId);
	}

	/**
	* Returns the organization ID of this approved mentors.
	*
	* @return the organization ID of this approved mentors
	*/
	@Override
	public long getOrganizationId() {
		return _approvedMentors.getOrganizationId();
	}

	/**
	* Sets the organization ID of this approved mentors.
	*
	* @param organizationId the organization ID of this approved mentors
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_approvedMentors.setOrganizationId(organizationId);
	}

	/**
	* Returns the user ID of this approved mentors.
	*
	* @return the user ID of this approved mentors
	*/
	@Override
	public java.lang.String getUserId() {
		return _approvedMentors.getUserId();
	}

	/**
	* Sets the user ID of this approved mentors.
	*
	* @param userId the user ID of this approved mentors
	*/
	@Override
	public void setUserId(java.lang.String userId) {
		_approvedMentors.setUserId(userId);
	}

	/**
	* Returns the create date of this approved mentors.
	*
	* @return the create date of this approved mentors
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _approvedMentors.getCreateDate();
	}

	/**
	* Sets the create date of this approved mentors.
	*
	* @param createDate the create date of this approved mentors
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_approvedMentors.setCreateDate(createDate);
	}

	/**
	* Returns the approved date of this approved mentors.
	*
	* @return the approved date of this approved mentors
	*/
	@Override
	public java.util.Date getApprovedDate() {
		return _approvedMentors.getApprovedDate();
	}

	/**
	* Sets the approved date of this approved mentors.
	*
	* @param approvedDate the approved date of this approved mentors
	*/
	@Override
	public void setApprovedDate(java.util.Date approvedDate) {
		_approvedMentors.setApprovedDate(approvedDate);
	}

	/**
	* Returns the remarks of this approved mentors.
	*
	* @return the remarks of this approved mentors
	*/
	@Override
	public java.lang.String getRemarks() {
		return _approvedMentors.getRemarks();
	}

	/**
	* Sets the remarks of this approved mentors.
	*
	* @param remarks the remarks of this approved mentors
	*/
	@Override
	public void setRemarks(java.lang.String remarks) {
		_approvedMentors.setRemarks(remarks);
	}

	/**
	* Returns the status of this approved mentors.
	*
	* @return the status of this approved mentors
	*/
	@Override
	public int getStatus() {
		return _approvedMentors.getStatus();
	}

	/**
	* Sets the status of this approved mentors.
	*
	* @param status the status of this approved mentors
	*/
	@Override
	public void setStatus(int status) {
		_approvedMentors.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _approvedMentors.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_approvedMentors.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _approvedMentors.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_approvedMentors.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _approvedMentors.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _approvedMentors.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_approvedMentors.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _approvedMentors.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_approvedMentors.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_approvedMentors.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_approvedMentors.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ApprovedMentorsWrapper((ApprovedMentors)_approvedMentors.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.ApprovedMentors approvedMentors) {
		return _approvedMentors.compareTo(approvedMentors);
	}

	@Override
	public int hashCode() {
		return _approvedMentors.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> toCacheModel() {
		return _approvedMentors.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ApprovedMentors toEscapedModel() {
		return new ApprovedMentorsWrapper(_approvedMentors.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ApprovedMentors toUnescapedModel() {
		return new ApprovedMentorsWrapper(_approvedMentors.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _approvedMentors.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _approvedMentors.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_approvedMentors.persist();
	}

	@Override
	public int getTitleId() {
		return _approvedMentors.getTitleId();
	}

	@Override
	public void setTitleId(int titleId) {
		_approvedMentors.setTitleId(titleId);
	}

	@Override
	public java.lang.String getJobTitle() {
		return _approvedMentors.getJobTitle();
	}

	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_approvedMentors.setJobTitle(jobTitle);
	}

	@Override
	public java.lang.String getMobile() {
		return _approvedMentors.getMobile();
	}

	@Override
	public void setMobile(java.lang.String mobile) {
		_approvedMentors.setMobile(mobile);
	}

	@Override
	public java.lang.String getEmail() {
		return _approvedMentors.getEmail();
	}

	@Override
	public void setEmail(java.lang.String email) {
		_approvedMentors.setEmail(email);
	}

	@Override
	public java.lang.String getFirstName() {
		return _approvedMentors.getFirstName();
	}

	@Override
	public void setFirstName(java.lang.String firstName) {
		_approvedMentors.setFirstName(firstName);
	}

	@Override
	public java.lang.String getLastName() {
		return _approvedMentors.getLastName();
	}

	@Override
	public void setLastName(java.lang.String lastName) {
		_approvedMentors.setLastName(lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApprovedMentorsWrapper)) {
			return false;
		}

		ApprovedMentorsWrapper approvedMentorsWrapper = (ApprovedMentorsWrapper)obj;

		if (Validator.equals(_approvedMentors,
					approvedMentorsWrapper._approvedMentors)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ApprovedMentors getWrappedApprovedMentors() {
		return _approvedMentors;
	}

	@Override
	public ApprovedMentors getWrappedModel() {
		return _approvedMentors;
	}

	@Override
	public void resetOriginalValues() {
		_approvedMentors.resetOriginalValues();
	}

	private ApprovedMentors _approvedMentors;
}