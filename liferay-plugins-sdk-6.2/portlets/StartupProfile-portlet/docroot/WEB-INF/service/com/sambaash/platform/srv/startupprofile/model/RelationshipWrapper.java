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
 * This class is a wrapper for {@link Relationship}.
 * </p>
 *
 * @author pradeep
 * @see Relationship
 * @generated
 */
public class RelationshipWrapper implements Relationship,
	ModelWrapper<Relationship> {
	public RelationshipWrapper(Relationship relationship) {
		_relationship = relationship;
	}

	@Override
	public Class<?> getModelClass() {
		return Relationship.class;
	}

	@Override
	public String getModelClassName() {
		return Relationship.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("relationshipId", getRelationshipId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("refId", getRefId());
		attributes.put("refTypeId", getRefTypeId());
		attributes.put("relation", getRelation());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long relationshipId = (Long)attributes.get("relationshipId");

		if (relationshipId != null) {
			setRelationshipId(relationshipId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long refId = (Long)attributes.get("refId");

		if (refId != null) {
			setRefId(refId);
		}

		Long refTypeId = (Long)attributes.get("refTypeId");

		if (refTypeId != null) {
			setRefTypeId(refTypeId);
		}

		Long relation = (Long)attributes.get("relation");

		if (relation != null) {
			setRelation(relation);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this relationship.
	*
	* @return the primary key of this relationship
	*/
	@Override
	public long getPrimaryKey() {
		return _relationship.getPrimaryKey();
	}

	/**
	* Sets the primary key of this relationship.
	*
	* @param primaryKey the primary key of this relationship
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_relationship.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the relationship ID of this relationship.
	*
	* @return the relationship ID of this relationship
	*/
	@Override
	public long getRelationshipId() {
		return _relationship.getRelationshipId();
	}

	/**
	* Sets the relationship ID of this relationship.
	*
	* @param relationshipId the relationship ID of this relationship
	*/
	@Override
	public void setRelationshipId(long relationshipId) {
		_relationship.setRelationshipId(relationshipId);
	}

	/**
	* Returns the organization ID of this relationship.
	*
	* @return the organization ID of this relationship
	*/
	@Override
	public long getOrganizationId() {
		return _relationship.getOrganizationId();
	}

	/**
	* Sets the organization ID of this relationship.
	*
	* @param organizationId the organization ID of this relationship
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_relationship.setOrganizationId(organizationId);
	}

	/**
	* Returns the ref ID of this relationship.
	*
	* @return the ref ID of this relationship
	*/
	@Override
	public long getRefId() {
		return _relationship.getRefId();
	}

	/**
	* Sets the ref ID of this relationship.
	*
	* @param refId the ref ID of this relationship
	*/
	@Override
	public void setRefId(long refId) {
		_relationship.setRefId(refId);
	}

	/**
	* Returns the ref type ID of this relationship.
	*
	* @return the ref type ID of this relationship
	*/
	@Override
	public long getRefTypeId() {
		return _relationship.getRefTypeId();
	}

	/**
	* Sets the ref type ID of this relationship.
	*
	* @param refTypeId the ref type ID of this relationship
	*/
	@Override
	public void setRefTypeId(long refTypeId) {
		_relationship.setRefTypeId(refTypeId);
	}

	/**
	* Returns the relation of this relationship.
	*
	* @return the relation of this relationship
	*/
	@Override
	public long getRelation() {
		return _relationship.getRelation();
	}

	/**
	* Sets the relation of this relationship.
	*
	* @param relation the relation of this relationship
	*/
	@Override
	public void setRelation(long relation) {
		_relationship.setRelation(relation);
	}

	/**
	* Returns the group ID of this relationship.
	*
	* @return the group ID of this relationship
	*/
	@Override
	public long getGroupId() {
		return _relationship.getGroupId();
	}

	/**
	* Sets the group ID of this relationship.
	*
	* @param groupId the group ID of this relationship
	*/
	@Override
	public void setGroupId(long groupId) {
		_relationship.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this relationship.
	*
	* @return the company ID of this relationship
	*/
	@Override
	public long getCompanyId() {
		return _relationship.getCompanyId();
	}

	/**
	* Sets the company ID of this relationship.
	*
	* @param companyId the company ID of this relationship
	*/
	@Override
	public void setCompanyId(long companyId) {
		_relationship.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this relationship.
	*
	* @return the user ID of this relationship
	*/
	@Override
	public long getUserId() {
		return _relationship.getUserId();
	}

	/**
	* Sets the user ID of this relationship.
	*
	* @param userId the user ID of this relationship
	*/
	@Override
	public void setUserId(long userId) {
		_relationship.setUserId(userId);
	}

	/**
	* Returns the user uuid of this relationship.
	*
	* @return the user uuid of this relationship
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _relationship.getUserUuid();
	}

	/**
	* Sets the user uuid of this relationship.
	*
	* @param userUuid the user uuid of this relationship
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_relationship.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this relationship.
	*
	* @return the user name of this relationship
	*/
	@Override
	public java.lang.String getUserName() {
		return _relationship.getUserName();
	}

	/**
	* Sets the user name of this relationship.
	*
	* @param userName the user name of this relationship
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_relationship.setUserName(userName);
	}

	/**
	* Returns the create date of this relationship.
	*
	* @return the create date of this relationship
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _relationship.getCreateDate();
	}

	/**
	* Sets the create date of this relationship.
	*
	* @param createDate the create date of this relationship
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_relationship.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this relationship.
	*
	* @return the modified date of this relationship
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _relationship.getModifiedDate();
	}

	/**
	* Sets the modified date of this relationship.
	*
	* @param modifiedDate the modified date of this relationship
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_relationship.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the active of this relationship.
	*
	* @return the active of this relationship
	*/
	@Override
	public boolean getActive() {
		return _relationship.getActive();
	}

	/**
	* Returns <code>true</code> if this relationship is active.
	*
	* @return <code>true</code> if this relationship is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _relationship.isActive();
	}

	/**
	* Sets whether this relationship is active.
	*
	* @param active the active of this relationship
	*/
	@Override
	public void setActive(boolean active) {
		_relationship.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _relationship.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_relationship.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _relationship.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_relationship.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _relationship.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _relationship.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_relationship.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _relationship.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_relationship.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_relationship.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_relationship.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RelationshipWrapper((Relationship)_relationship.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.Relationship relationship) {
		return _relationship.compareTo(relationship);
	}

	@Override
	public int hashCode() {
		return _relationship.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.Relationship> toCacheModel() {
		return _relationship.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Relationship toEscapedModel() {
		return new RelationshipWrapper(_relationship.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Relationship toUnescapedModel() {
		return new RelationshipWrapper(_relationship.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _relationship.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _relationship.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_relationship.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RelationshipWrapper)) {
			return false;
		}

		RelationshipWrapper relationshipWrapper = (RelationshipWrapper)obj;

		if (Validator.equals(_relationship, relationshipWrapper._relationship)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Relationship getWrappedRelationship() {
		return _relationship;
	}

	@Override
	public Relationship getWrappedModel() {
		return _relationship;
	}

	@Override
	public void resetOriginalValues() {
		_relationship.resetOriginalValues();
	}

	private Relationship _relationship;
}