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
 * This class is a wrapper for {@link PERule}.
 * </p>
 *
 * @author nareshchebolu
 * @see PERule
 * @generated
 */
public class PERuleWrapper implements PERule, ModelWrapper<PERule> {
	public PERuleWrapper(PERule peRule) {
		_peRule = peRule;
	}

	@Override
	public Class<?> getModelClass() {
		return PERule.class;
	}

	@Override
	public String getModelClassName() {
		return PERule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPERuleId", getSpPERuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPERuleSetId", getSpPERuleSetId());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("definition", getDefinition());
		attributes.put("sequenceNO", getSequenceNO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPERuleId = (Long)attributes.get("spPERuleId");

		if (spPERuleId != null) {
			setSpPERuleId(spPERuleId);
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

		Long spPERuleSetId = (Long)attributes.get("spPERuleSetId");

		if (spPERuleSetId != null) {
			setSpPERuleSetId(spPERuleSetId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String definition = (String)attributes.get("definition");

		if (definition != null) {
			setDefinition(definition);
		}

		Long sequenceNO = (Long)attributes.get("sequenceNO");

		if (sequenceNO != null) {
			setSequenceNO(sequenceNO);
		}
	}

	/**
	* Returns the primary key of this p e rule.
	*
	* @return the primary key of this p e rule
	*/
	@Override
	public long getPrimaryKey() {
		return _peRule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e rule.
	*
	* @param primaryKey the primary key of this p e rule
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peRule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e rule.
	*
	* @return the uuid of this p e rule
	*/
	@Override
	public java.lang.String getUuid() {
		return _peRule.getUuid();
	}

	/**
	* Sets the uuid of this p e rule.
	*
	* @param uuid the uuid of this p e rule
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peRule.setUuid(uuid);
	}

	/**
	* Returns the sp p e rule ID of this p e rule.
	*
	* @return the sp p e rule ID of this p e rule
	*/
	@Override
	public long getSpPERuleId() {
		return _peRule.getSpPERuleId();
	}

	/**
	* Sets the sp p e rule ID of this p e rule.
	*
	* @param spPERuleId the sp p e rule ID of this p e rule
	*/
	@Override
	public void setSpPERuleId(long spPERuleId) {
		_peRule.setSpPERuleId(spPERuleId);
	}

	/**
	* Returns the group ID of this p e rule.
	*
	* @return the group ID of this p e rule
	*/
	@Override
	public long getGroupId() {
		return _peRule.getGroupId();
	}

	/**
	* Sets the group ID of this p e rule.
	*
	* @param groupId the group ID of this p e rule
	*/
	@Override
	public void setGroupId(long groupId) {
		_peRule.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this p e rule.
	*
	* @return the company ID of this p e rule
	*/
	@Override
	public long getCompanyId() {
		return _peRule.getCompanyId();
	}

	/**
	* Sets the company ID of this p e rule.
	*
	* @param companyId the company ID of this p e rule
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peRule.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this p e rule.
	*
	* @return the user ID of this p e rule
	*/
	@Override
	public long getUserId() {
		return _peRule.getUserId();
	}

	/**
	* Sets the user ID of this p e rule.
	*
	* @param userId the user ID of this p e rule
	*/
	@Override
	public void setUserId(long userId) {
		_peRule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e rule.
	*
	* @return the user uuid of this p e rule
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peRule.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e rule.
	*
	* @param userUuid the user uuid of this p e rule
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peRule.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this p e rule.
	*
	* @return the user name of this p e rule
	*/
	@Override
	public java.lang.String getUserName() {
		return _peRule.getUserName();
	}

	/**
	* Sets the user name of this p e rule.
	*
	* @param userName the user name of this p e rule
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peRule.setUserName(userName);
	}

	/**
	* Returns the create date of this p e rule.
	*
	* @return the create date of this p e rule
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peRule.getCreateDate();
	}

	/**
	* Sets the create date of this p e rule.
	*
	* @param createDate the create date of this p e rule
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peRule.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e rule.
	*
	* @return the modified date of this p e rule
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peRule.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e rule.
	*
	* @param modifiedDate the modified date of this p e rule
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peRule.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp p e rule set ID of this p e rule.
	*
	* @return the sp p e rule set ID of this p e rule
	*/
	@Override
	public long getSpPERuleSetId() {
		return _peRule.getSpPERuleSetId();
	}

	/**
	* Sets the sp p e rule set ID of this p e rule.
	*
	* @param spPERuleSetId the sp p e rule set ID of this p e rule
	*/
	@Override
	public void setSpPERuleSetId(long spPERuleSetId) {
		_peRule.setSpPERuleSetId(spPERuleSetId);
	}

	/**
	* Returns the name of this p e rule.
	*
	* @return the name of this p e rule
	*/
	@Override
	public java.lang.String getName() {
		return _peRule.getName();
	}

	/**
	* Sets the name of this p e rule.
	*
	* @param name the name of this p e rule
	*/
	@Override
	public void setName(java.lang.String name) {
		_peRule.setName(name);
	}

	/**
	* Returns the type of this p e rule.
	*
	* @return the type of this p e rule
	*/
	@Override
	public java.lang.String getType() {
		return _peRule.getType();
	}

	/**
	* Sets the type of this p e rule.
	*
	* @param type the type of this p e rule
	*/
	@Override
	public void setType(java.lang.String type) {
		_peRule.setType(type);
	}

	/**
	* Returns the definition of this p e rule.
	*
	* @return the definition of this p e rule
	*/
	@Override
	public java.lang.String getDefinition() {
		return _peRule.getDefinition();
	}

	/**
	* Sets the definition of this p e rule.
	*
	* @param definition the definition of this p e rule
	*/
	@Override
	public void setDefinition(java.lang.String definition) {
		_peRule.setDefinition(definition);
	}

	/**
	* Returns the sequence n o of this p e rule.
	*
	* @return the sequence n o of this p e rule
	*/
	@Override
	public long getSequenceNO() {
		return _peRule.getSequenceNO();
	}

	/**
	* Sets the sequence n o of this p e rule.
	*
	* @param sequenceNO the sequence n o of this p e rule
	*/
	@Override
	public void setSequenceNO(long sequenceNO) {
		_peRule.setSequenceNO(sequenceNO);
	}

	@Override
	public boolean isNew() {
		return _peRule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peRule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peRule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peRule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peRule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peRule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peRule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peRule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peRule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peRule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peRule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PERuleWrapper((PERule)_peRule.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PERule peRule) {
		return _peRule.compareTo(peRule);
	}

	@Override
	public int hashCode() {
		return _peRule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PERule> toCacheModel() {
		return _peRule.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERule toEscapedModel() {
		return new PERuleWrapper(_peRule.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PERule toUnescapedModel() {
		return new PERuleWrapper(_peRule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peRule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peRule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peRule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PERuleWrapper)) {
			return false;
		}

		PERuleWrapper peRuleWrapper = (PERuleWrapper)obj;

		if (Validator.equals(_peRule, peRuleWrapper._peRule)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peRule.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PERule getWrappedPERule() {
		return _peRule;
	}

	@Override
	public PERule getWrappedModel() {
		return _peRule;
	}

	@Override
	public void resetOriginalValues() {
		_peRule.resetOriginalValues();
	}

	private PERule _peRule;
}