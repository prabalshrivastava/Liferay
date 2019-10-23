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
 * This class is a wrapper for {@link OrganisationRemarks}.
 * </p>
 *
 * @author pradeep
 * @see OrganisationRemarks
 * @generated
 */
public class OrganisationRemarksWrapper implements OrganisationRemarks,
	ModelWrapper<OrganisationRemarks> {
	public OrganisationRemarksWrapper(OrganisationRemarks organisationRemarks) {
		_organisationRemarks = organisationRemarks;
	}

	@Override
	public Class<?> getModelClass() {
		return OrganisationRemarks.class;
	}

	@Override
	public String getModelClassName() {
		return OrganisationRemarks.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("remarksId", getRemarksId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("remarkType", getRemarkType());
		attributes.put("Remarks", getRemarks());
		attributes.put("Notes", getNotes());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long remarksId = (Long)attributes.get("remarksId");

		if (remarksId != null) {
			setRemarksId(remarksId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String remarkType = (String)attributes.get("remarkType");

		if (remarkType != null) {
			setRemarkType(remarkType);
		}

		String Remarks = (String)attributes.get("Remarks");

		if (Remarks != null) {
			setRemarks(Remarks);
		}

		String Notes = (String)attributes.get("Notes");

		if (Notes != null) {
			setNotes(Notes);
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
	}

	/**
	* Returns the primary key of this organisation remarks.
	*
	* @return the primary key of this organisation remarks
	*/
	@Override
	public long getPrimaryKey() {
		return _organisationRemarks.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organisation remarks.
	*
	* @param primaryKey the primary key of this organisation remarks
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_organisationRemarks.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the remarks ID of this organisation remarks.
	*
	* @return the remarks ID of this organisation remarks
	*/
	@Override
	public long getRemarksId() {
		return _organisationRemarks.getRemarksId();
	}

	/**
	* Sets the remarks ID of this organisation remarks.
	*
	* @param remarksId the remarks ID of this organisation remarks
	*/
	@Override
	public void setRemarksId(long remarksId) {
		_organisationRemarks.setRemarksId(remarksId);
	}

	/**
	* Returns the organization ID of this organisation remarks.
	*
	* @return the organization ID of this organisation remarks
	*/
	@Override
	public long getOrganizationId() {
		return _organisationRemarks.getOrganizationId();
	}

	/**
	* Sets the organization ID of this organisation remarks.
	*
	* @param organizationId the organization ID of this organisation remarks
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_organisationRemarks.setOrganizationId(organizationId);
	}

	/**
	* Returns the remark type of this organisation remarks.
	*
	* @return the remark type of this organisation remarks
	*/
	@Override
	public java.lang.String getRemarkType() {
		return _organisationRemarks.getRemarkType();
	}

	/**
	* Sets the remark type of this organisation remarks.
	*
	* @param remarkType the remark type of this organisation remarks
	*/
	@Override
	public void setRemarkType(java.lang.String remarkType) {
		_organisationRemarks.setRemarkType(remarkType);
	}

	/**
	* Returns the remarks of this organisation remarks.
	*
	* @return the remarks of this organisation remarks
	*/
	@Override
	public java.lang.String getRemarks() {
		return _organisationRemarks.getRemarks();
	}

	/**
	* Sets the remarks of this organisation remarks.
	*
	* @param Remarks the remarks of this organisation remarks
	*/
	@Override
	public void setRemarks(java.lang.String Remarks) {
		_organisationRemarks.setRemarks(Remarks);
	}

	/**
	* Returns the notes of this organisation remarks.
	*
	* @return the notes of this organisation remarks
	*/
	@Override
	public java.lang.String getNotes() {
		return _organisationRemarks.getNotes();
	}

	/**
	* Sets the notes of this organisation remarks.
	*
	* @param Notes the notes of this organisation remarks
	*/
	@Override
	public void setNotes(java.lang.String Notes) {
		_organisationRemarks.setNotes(Notes);
	}

	/**
	* Returns the group ID of this organisation remarks.
	*
	* @return the group ID of this organisation remarks
	*/
	@Override
	public long getGroupId() {
		return _organisationRemarks.getGroupId();
	}

	/**
	* Sets the group ID of this organisation remarks.
	*
	* @param groupId the group ID of this organisation remarks
	*/
	@Override
	public void setGroupId(long groupId) {
		_organisationRemarks.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this organisation remarks.
	*
	* @return the company ID of this organisation remarks
	*/
	@Override
	public long getCompanyId() {
		return _organisationRemarks.getCompanyId();
	}

	/**
	* Sets the company ID of this organisation remarks.
	*
	* @param companyId the company ID of this organisation remarks
	*/
	@Override
	public void setCompanyId(long companyId) {
		_organisationRemarks.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this organisation remarks.
	*
	* @return the user ID of this organisation remarks
	*/
	@Override
	public long getUserId() {
		return _organisationRemarks.getUserId();
	}

	/**
	* Sets the user ID of this organisation remarks.
	*
	* @param userId the user ID of this organisation remarks
	*/
	@Override
	public void setUserId(long userId) {
		_organisationRemarks.setUserId(userId);
	}

	/**
	* Returns the user uuid of this organisation remarks.
	*
	* @return the user uuid of this organisation remarks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarks.getUserUuid();
	}

	/**
	* Sets the user uuid of this organisation remarks.
	*
	* @param userUuid the user uuid of this organisation remarks
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_organisationRemarks.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this organisation remarks.
	*
	* @return the user name of this organisation remarks
	*/
	@Override
	public java.lang.String getUserName() {
		return _organisationRemarks.getUserName();
	}

	/**
	* Sets the user name of this organisation remarks.
	*
	* @param userName the user name of this organisation remarks
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_organisationRemarks.setUserName(userName);
	}

	/**
	* Returns the create date of this organisation remarks.
	*
	* @return the create date of this organisation remarks
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _organisationRemarks.getCreateDate();
	}

	/**
	* Sets the create date of this organisation remarks.
	*
	* @param createDate the create date of this organisation remarks
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_organisationRemarks.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this organisation remarks.
	*
	* @return the modified date of this organisation remarks
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _organisationRemarks.getModifiedDate();
	}

	/**
	* Sets the modified date of this organisation remarks.
	*
	* @param modifiedDate the modified date of this organisation remarks
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_organisationRemarks.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _organisationRemarks.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_organisationRemarks.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _organisationRemarks.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_organisationRemarks.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _organisationRemarks.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _organisationRemarks.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_organisationRemarks.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organisationRemarks.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_organisationRemarks.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_organisationRemarks.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organisationRemarks.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrganisationRemarksWrapper((OrganisationRemarks)_organisationRemarks.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks organisationRemarks) {
		return _organisationRemarks.compareTo(organisationRemarks);
	}

	@Override
	public int hashCode() {
		return _organisationRemarks.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks> toCacheModel() {
		return _organisationRemarks.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks toEscapedModel() {
		return new OrganisationRemarksWrapper(_organisationRemarks.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks toUnescapedModel() {
		return new OrganisationRemarksWrapper(_organisationRemarks.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _organisationRemarks.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _organisationRemarks.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_organisationRemarks.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganisationRemarksWrapper)) {
			return false;
		}

		OrganisationRemarksWrapper organisationRemarksWrapper = (OrganisationRemarksWrapper)obj;

		if (Validator.equals(_organisationRemarks,
					organisationRemarksWrapper._organisationRemarks)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OrganisationRemarks getWrappedOrganisationRemarks() {
		return _organisationRemarks;
	}

	@Override
	public OrganisationRemarks getWrappedModel() {
		return _organisationRemarks;
	}

	@Override
	public void resetOriginalValues() {
		_organisationRemarks.resetOriginalValues();
	}

	private OrganisationRemarks _organisationRemarks;
}