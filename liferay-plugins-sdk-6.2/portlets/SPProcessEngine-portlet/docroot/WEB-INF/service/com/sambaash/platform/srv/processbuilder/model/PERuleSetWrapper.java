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

package com.sambaash.platform.srv.processbuilder.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PERuleSet}.
 * </p>
 *
 * @author nareshchebolu
 * @see PERuleSet
 * @generated
 */
public class PERuleSetWrapper implements PERuleSet, ModelWrapper<PERuleSet> {
	public PERuleSetWrapper(PERuleSet peRuleSet) {
		_peRuleSet = peRuleSet;
	}

	@Override
	public Class<?> getModelClass() {
		return PERuleSet.class;
	}

	@Override
	public String getModelClassName() {
		return PERuleSet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPERuleSetId", getSpPERuleSetId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("componentType", getComponentType());
		attributes.put("componentId", getComponentId());
		attributes.put("status", getStatus());
		attributes.put("formVersion", getFormVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPERuleSetId = (Long)attributes.get("spPERuleSetId");

		if (spPERuleSetId != null) {
			setSpPERuleSetId(spPERuleSetId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String componentType = (String)attributes.get("componentType");

		if (componentType != null) {
			setComponentType(componentType);
		}

		String componentId = (String)attributes.get("componentId");

		if (componentId != null) {
			setComponentId(componentId);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String formVersion = (String)attributes.get("formVersion");

		if (formVersion != null) {
			setFormVersion(formVersion);
		}
	}

	/**
	* Returns the primary key of this p e rule set.
	*
	* @return the primary key of this p e rule set
	*/
	@Override
	public long getPrimaryKey() {
		return _peRuleSet.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e rule set.
	*
	* @param primaryKey the primary key of this p e rule set
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peRuleSet.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e rule set.
	*
	* @return the uuid of this p e rule set
	*/
	@Override
	public java.lang.String getUuid() {
		return _peRuleSet.getUuid();
	}

	/**
	* Sets the uuid of this p e rule set.
	*
	* @param uuid the uuid of this p e rule set
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peRuleSet.setUuid(uuid);
	}

	/**
	* Returns the sp p e rule set ID of this p e rule set.
	*
	* @return the sp p e rule set ID of this p e rule set
	*/
	@Override
	public long getSpPERuleSetId() {
		return _peRuleSet.getSpPERuleSetId();
	}

	/**
	* Sets the sp p e rule set ID of this p e rule set.
	*
	* @param spPERuleSetId the sp p e rule set ID of this p e rule set
	*/
	@Override
	public void setSpPERuleSetId(long spPERuleSetId) {
		_peRuleSet.setSpPERuleSetId(spPERuleSetId);
	}

	/**
	* Returns the group ID of this p e rule set.
	*
	* @return the group ID of this p e rule set
	*/
	@Override
	public long getGroupId() {
		return _peRuleSet.getGroupId();
	}

	/**
	* Sets the group ID of this p e rule set.
	*
	* @param groupId the group ID of this p e rule set
	*/
	@Override
	public void setGroupId(long groupId) {
		_peRuleSet.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this p e rule set.
	*
	* @return the company ID of this p e rule set
	*/
	@Override
	public long getCompanyId() {
		return _peRuleSet.getCompanyId();
	}

	/**
	* Sets the company ID of this p e rule set.
	*
	* @param companyId the company ID of this p e rule set
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peRuleSet.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this p e rule set.
	*
	* @return the user ID of this p e rule set
	*/
	@Override
	public long getUserId() {
		return _peRuleSet.getUserId();
	}

	/**
	* Sets the user ID of this p e rule set.
	*
	* @param userId the user ID of this p e rule set
	*/
	@Override
	public void setUserId(long userId) {
		_peRuleSet.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e rule set.
	*
	* @return the user uuid of this p e rule set
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRuleSet.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e rule set.
	*
	* @param userUuid the user uuid of this p e rule set
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peRuleSet.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this p e rule set.
	*
	* @return the user name of this p e rule set
	*/
	@Override
	public java.lang.String getUserName() {
		return _peRuleSet.getUserName();
	}

	/**
	* Sets the user name of this p e rule set.
	*
	* @param userName the user name of this p e rule set
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peRuleSet.setUserName(userName);
	}

	/**
	* Returns the create date of this p e rule set.
	*
	* @return the create date of this p e rule set
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peRuleSet.getCreateDate();
	}

	/**
	* Sets the create date of this p e rule set.
	*
	* @param createDate the create date of this p e rule set
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peRuleSet.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e rule set.
	*
	* @return the modified date of this p e rule set
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peRuleSet.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e rule set.
	*
	* @param modifiedDate the modified date of this p e rule set
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peRuleSet.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this p e rule set.
	*
	* @return the name of this p e rule set
	*/
	@Override
	public java.lang.String getName() {
		return _peRuleSet.getName();
	}

	/**
	* Sets the name of this p e rule set.
	*
	* @param name the name of this p e rule set
	*/
	@Override
	public void setName(java.lang.String name) {
		_peRuleSet.setName(name);
	}

	/**
	* Returns the component type of this p e rule set.
	*
	* @return the component type of this p e rule set
	*/
	@Override
	public java.lang.String getComponentType() {
		return _peRuleSet.getComponentType();
	}

	/**
	* Sets the component type of this p e rule set.
	*
	* @param componentType the component type of this p e rule set
	*/
	@Override
	public void setComponentType(java.lang.String componentType) {
		_peRuleSet.setComponentType(componentType);
	}

	/**
	* Returns the component ID of this p e rule set.
	*
	* @return the component ID of this p e rule set
	*/
	@Override
	public java.lang.String getComponentId() {
		return _peRuleSet.getComponentId();
	}

	/**
	* Sets the component ID of this p e rule set.
	*
	* @param componentId the component ID of this p e rule set
	*/
	@Override
	public void setComponentId(java.lang.String componentId) {
		_peRuleSet.setComponentId(componentId);
	}

	/**
	* Returns the status of this p e rule set.
	*
	* @return the status of this p e rule set
	*/
	@Override
	public long getStatus() {
		return _peRuleSet.getStatus();
	}

	/**
	* Sets the status of this p e rule set.
	*
	* @param status the status of this p e rule set
	*/
	@Override
	public void setStatus(long status) {
		_peRuleSet.setStatus(status);
	}

	/**
	* Returns the form version of this p e rule set.
	*
	* @return the form version of this p e rule set
	*/
	@Override
	public java.lang.String getFormVersion() {
		return _peRuleSet.getFormVersion();
	}

	/**
	* Sets the form version of this p e rule set.
	*
	* @param formVersion the form version of this p e rule set
	*/
	@Override
	public void setFormVersion(java.lang.String formVersion) {
		_peRuleSet.setFormVersion(formVersion);
	}

	@Override
	public boolean isNew() {
		return _peRuleSet.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peRuleSet.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peRuleSet.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peRuleSet.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peRuleSet.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peRuleSet.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peRuleSet.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peRuleSet.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peRuleSet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peRuleSet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peRuleSet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PERuleSetWrapper((PERuleSet)_peRuleSet.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PERuleSet peRuleSet) {
		return _peRuleSet.compareTo(peRuleSet);
	}

	@Override
	public int hashCode() {
		return _peRuleSet.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PERuleSet> toCacheModel() {
		return _peRuleSet.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet toEscapedModel() {
		return new PERuleSetWrapper(_peRuleSet.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet toUnescapedModel() {
		return new PERuleSetWrapper(_peRuleSet.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peRuleSet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peRuleSet.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peRuleSet.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PERuleSetWrapper)) {
			return false;
		}

		PERuleSetWrapper peRuleSetWrapper = (PERuleSetWrapper)obj;

		if (Validator.equals(_peRuleSet, peRuleSetWrapper._peRuleSet)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peRuleSet.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PERuleSet getWrappedPERuleSet() {
		return _peRuleSet;
	}

	@Override
	public PERuleSet getWrappedModel() {
		return _peRuleSet;
	}

	@Override
	public void resetOriginalValues() {
		_peRuleSet.resetOriginalValues();
	}

	private PERuleSet _peRuleSet;
}