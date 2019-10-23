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
 * This class is a wrapper for {@link PECustomAction}.
 * </p>
 *
 * @author nareshchebolu
 * @see PECustomAction
 * @generated
 */
public class PECustomActionWrapper implements PECustomAction,
	ModelWrapper<PECustomAction> {
	public PECustomActionWrapper(PECustomAction peCustomAction) {
		_peCustomAction = peCustomAction;
	}

	@Override
	public Class<?> getModelClass() {
		return PECustomAction.class;
	}

	@Override
	public String getModelClassName() {
		return PECustomAction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEActionId", getSpPEActionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("actionClassName", getActionClassName());
		attributes.put("title", getTitle());
		attributes.put("defaultConfiguration", getDefaultConfiguration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEActionId = (Long)attributes.get("spPEActionId");

		if (spPEActionId != null) {
			setSpPEActionId(spPEActionId);
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

		String actionClassName = (String)attributes.get("actionClassName");

		if (actionClassName != null) {
			setActionClassName(actionClassName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String defaultConfiguration = (String)attributes.get(
				"defaultConfiguration");

		if (defaultConfiguration != null) {
			setDefaultConfiguration(defaultConfiguration);
		}
	}

	/**
	* Returns the primary key of this p e custom action.
	*
	* @return the primary key of this p e custom action
	*/
	@Override
	public long getPrimaryKey() {
		return _peCustomAction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e custom action.
	*
	* @param primaryKey the primary key of this p e custom action
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peCustomAction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e custom action.
	*
	* @return the uuid of this p e custom action
	*/
	@Override
	public java.lang.String getUuid() {
		return _peCustomAction.getUuid();
	}

	/**
	* Sets the uuid of this p e custom action.
	*
	* @param uuid the uuid of this p e custom action
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peCustomAction.setUuid(uuid);
	}

	/**
	* Returns the sp p e action ID of this p e custom action.
	*
	* @return the sp p e action ID of this p e custom action
	*/
	@Override
	public long getSpPEActionId() {
		return _peCustomAction.getSpPEActionId();
	}

	/**
	* Sets the sp p e action ID of this p e custom action.
	*
	* @param spPEActionId the sp p e action ID of this p e custom action
	*/
	@Override
	public void setSpPEActionId(long spPEActionId) {
		_peCustomAction.setSpPEActionId(spPEActionId);
	}

	/**
	* Returns the group ID of this p e custom action.
	*
	* @return the group ID of this p e custom action
	*/
	@Override
	public long getGroupId() {
		return _peCustomAction.getGroupId();
	}

	/**
	* Sets the group ID of this p e custom action.
	*
	* @param groupId the group ID of this p e custom action
	*/
	@Override
	public void setGroupId(long groupId) {
		_peCustomAction.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this p e custom action.
	*
	* @return the company ID of this p e custom action
	*/
	@Override
	public long getCompanyId() {
		return _peCustomAction.getCompanyId();
	}

	/**
	* Sets the company ID of this p e custom action.
	*
	* @param companyId the company ID of this p e custom action
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peCustomAction.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this p e custom action.
	*
	* @return the user ID of this p e custom action
	*/
	@Override
	public long getUserId() {
		return _peCustomAction.getUserId();
	}

	/**
	* Sets the user ID of this p e custom action.
	*
	* @param userId the user ID of this p e custom action
	*/
	@Override
	public void setUserId(long userId) {
		_peCustomAction.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e custom action.
	*
	* @return the user uuid of this p e custom action
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomAction.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e custom action.
	*
	* @param userUuid the user uuid of this p e custom action
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peCustomAction.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this p e custom action.
	*
	* @return the user name of this p e custom action
	*/
	@Override
	public java.lang.String getUserName() {
		return _peCustomAction.getUserName();
	}

	/**
	* Sets the user name of this p e custom action.
	*
	* @param userName the user name of this p e custom action
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peCustomAction.setUserName(userName);
	}

	/**
	* Returns the create date of this p e custom action.
	*
	* @return the create date of this p e custom action
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peCustomAction.getCreateDate();
	}

	/**
	* Sets the create date of this p e custom action.
	*
	* @param createDate the create date of this p e custom action
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peCustomAction.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e custom action.
	*
	* @return the modified date of this p e custom action
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peCustomAction.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e custom action.
	*
	* @param modifiedDate the modified date of this p e custom action
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peCustomAction.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the action class name of this p e custom action.
	*
	* @return the action class name of this p e custom action
	*/
	@Override
	public java.lang.String getActionClassName() {
		return _peCustomAction.getActionClassName();
	}

	/**
	* Sets the action class name of this p e custom action.
	*
	* @param actionClassName the action class name of this p e custom action
	*/
	@Override
	public void setActionClassName(java.lang.String actionClassName) {
		_peCustomAction.setActionClassName(actionClassName);
	}

	/**
	* Returns the title of this p e custom action.
	*
	* @return the title of this p e custom action
	*/
	@Override
	public java.lang.String getTitle() {
		return _peCustomAction.getTitle();
	}

	/**
	* Sets the title of this p e custom action.
	*
	* @param title the title of this p e custom action
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_peCustomAction.setTitle(title);
	}

	/**
	* Returns the default configuration of this p e custom action.
	*
	* @return the default configuration of this p e custom action
	*/
	@Override
	public java.lang.String getDefaultConfiguration() {
		return _peCustomAction.getDefaultConfiguration();
	}

	/**
	* Sets the default configuration of this p e custom action.
	*
	* @param defaultConfiguration the default configuration of this p e custom action
	*/
	@Override
	public void setDefaultConfiguration(java.lang.String defaultConfiguration) {
		_peCustomAction.setDefaultConfiguration(defaultConfiguration);
	}

	@Override
	public boolean isNew() {
		return _peCustomAction.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peCustomAction.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peCustomAction.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peCustomAction.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peCustomAction.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peCustomAction.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peCustomAction.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peCustomAction.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peCustomAction.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peCustomAction.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peCustomAction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PECustomActionWrapper((PECustomAction)_peCustomAction.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PECustomAction peCustomAction) {
		return _peCustomAction.compareTo(peCustomAction);
	}

	@Override
	public int hashCode() {
		return _peCustomAction.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PECustomAction> toCacheModel() {
		return _peCustomAction.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction toEscapedModel() {
		return new PECustomActionWrapper(_peCustomAction.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomAction toUnescapedModel() {
		return new PECustomActionWrapper(_peCustomAction.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peCustomAction.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peCustomAction.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peCustomAction.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PECustomActionWrapper)) {
			return false;
		}

		PECustomActionWrapper peCustomActionWrapper = (PECustomActionWrapper)obj;

		if (Validator.equals(_peCustomAction,
					peCustomActionWrapper._peCustomAction)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peCustomAction.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PECustomAction getWrappedPECustomAction() {
		return _peCustomAction;
	}

	@Override
	public PECustomAction getWrappedModel() {
		return _peCustomAction;
	}

	@Override
	public void resetOriginalValues() {
		_peCustomAction.resetOriginalValues();
	}

	private PECustomAction _peCustomAction;
}