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
 * This class is a wrapper for {@link PECustomActionInfo}.
 * </p>
 *
 * @author nareshchebolu
 * @see PECustomActionInfo
 * @generated
 */
public class PECustomActionInfoWrapper implements PECustomActionInfo,
	ModelWrapper<PECustomActionInfo> {
	public PECustomActionInfoWrapper(PECustomActionInfo peCustomActionInfo) {
		_peCustomActionInfo = peCustomActionInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return PECustomActionInfo.class;
	}

	@Override
	public String getModelClassName() {
		return PECustomActionInfo.class.getName();
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
	* Returns the primary key of this p e custom action info.
	*
	* @return the primary key of this p e custom action info
	*/
	@Override
	public long getPrimaryKey() {
		return _peCustomActionInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e custom action info.
	*
	* @param primaryKey the primary key of this p e custom action info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peCustomActionInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e custom action info.
	*
	* @return the uuid of this p e custom action info
	*/
	@Override
	public java.lang.String getUuid() {
		return _peCustomActionInfo.getUuid();
	}

	/**
	* Sets the uuid of this p e custom action info.
	*
	* @param uuid the uuid of this p e custom action info
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peCustomActionInfo.setUuid(uuid);
	}

	/**
	* Returns the sp p e action ID of this p e custom action info.
	*
	* @return the sp p e action ID of this p e custom action info
	*/
	@Override
	public long getSpPEActionId() {
		return _peCustomActionInfo.getSpPEActionId();
	}

	/**
	* Sets the sp p e action ID of this p e custom action info.
	*
	* @param spPEActionId the sp p e action ID of this p e custom action info
	*/
	@Override
	public void setSpPEActionId(long spPEActionId) {
		_peCustomActionInfo.setSpPEActionId(spPEActionId);
	}

	/**
	* Returns the group ID of this p e custom action info.
	*
	* @return the group ID of this p e custom action info
	*/
	@Override
	public long getGroupId() {
		return _peCustomActionInfo.getGroupId();
	}

	/**
	* Sets the group ID of this p e custom action info.
	*
	* @param groupId the group ID of this p e custom action info
	*/
	@Override
	public void setGroupId(long groupId) {
		_peCustomActionInfo.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this p e custom action info.
	*
	* @return the company ID of this p e custom action info
	*/
	@Override
	public long getCompanyId() {
		return _peCustomActionInfo.getCompanyId();
	}

	/**
	* Sets the company ID of this p e custom action info.
	*
	* @param companyId the company ID of this p e custom action info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peCustomActionInfo.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this p e custom action info.
	*
	* @return the user ID of this p e custom action info
	*/
	@Override
	public long getUserId() {
		return _peCustomActionInfo.getUserId();
	}

	/**
	* Sets the user ID of this p e custom action info.
	*
	* @param userId the user ID of this p e custom action info
	*/
	@Override
	public void setUserId(long userId) {
		_peCustomActionInfo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e custom action info.
	*
	* @return the user uuid of this p e custom action info
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peCustomActionInfo.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e custom action info.
	*
	* @param userUuid the user uuid of this p e custom action info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peCustomActionInfo.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this p e custom action info.
	*
	* @return the user name of this p e custom action info
	*/
	@Override
	public java.lang.String getUserName() {
		return _peCustomActionInfo.getUserName();
	}

	/**
	* Sets the user name of this p e custom action info.
	*
	* @param userName the user name of this p e custom action info
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peCustomActionInfo.setUserName(userName);
	}

	/**
	* Returns the create date of this p e custom action info.
	*
	* @return the create date of this p e custom action info
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peCustomActionInfo.getCreateDate();
	}

	/**
	* Sets the create date of this p e custom action info.
	*
	* @param createDate the create date of this p e custom action info
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peCustomActionInfo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e custom action info.
	*
	* @return the modified date of this p e custom action info
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peCustomActionInfo.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e custom action info.
	*
	* @param modifiedDate the modified date of this p e custom action info
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peCustomActionInfo.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the action class name of this p e custom action info.
	*
	* @return the action class name of this p e custom action info
	*/
	@Override
	public java.lang.String getActionClassName() {
		return _peCustomActionInfo.getActionClassName();
	}

	/**
	* Sets the action class name of this p e custom action info.
	*
	* @param actionClassName the action class name of this p e custom action info
	*/
	@Override
	public void setActionClassName(java.lang.String actionClassName) {
		_peCustomActionInfo.setActionClassName(actionClassName);
	}

	/**
	* Returns the title of this p e custom action info.
	*
	* @return the title of this p e custom action info
	*/
	@Override
	public java.lang.String getTitle() {
		return _peCustomActionInfo.getTitle();
	}

	/**
	* Sets the title of this p e custom action info.
	*
	* @param title the title of this p e custom action info
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_peCustomActionInfo.setTitle(title);
	}

	/**
	* Returns the default configuration of this p e custom action info.
	*
	* @return the default configuration of this p e custom action info
	*/
	@Override
	public java.lang.String getDefaultConfiguration() {
		return _peCustomActionInfo.getDefaultConfiguration();
	}

	/**
	* Sets the default configuration of this p e custom action info.
	*
	* @param defaultConfiguration the default configuration of this p e custom action info
	*/
	@Override
	public void setDefaultConfiguration(java.lang.String defaultConfiguration) {
		_peCustomActionInfo.setDefaultConfiguration(defaultConfiguration);
	}

	@Override
	public boolean isNew() {
		return _peCustomActionInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peCustomActionInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peCustomActionInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peCustomActionInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peCustomActionInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peCustomActionInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peCustomActionInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peCustomActionInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peCustomActionInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peCustomActionInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peCustomActionInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PECustomActionInfoWrapper((PECustomActionInfo)_peCustomActionInfo.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo peCustomActionInfo) {
		return _peCustomActionInfo.compareTo(peCustomActionInfo);
	}

	@Override
	public int hashCode() {
		return _peCustomActionInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo> toCacheModel() {
		return _peCustomActionInfo.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo toEscapedModel() {
		return new PECustomActionInfoWrapper(_peCustomActionInfo.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo toUnescapedModel() {
		return new PECustomActionInfoWrapper(_peCustomActionInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peCustomActionInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peCustomActionInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peCustomActionInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PECustomActionInfoWrapper)) {
			return false;
		}

		PECustomActionInfoWrapper peCustomActionInfoWrapper = (PECustomActionInfoWrapper)obj;

		if (Validator.equals(_peCustomActionInfo,
					peCustomActionInfoWrapper._peCustomActionInfo)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peCustomActionInfo.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PECustomActionInfo getWrappedPECustomActionInfo() {
		return _peCustomActionInfo;
	}

	@Override
	public PECustomActionInfo getWrappedModel() {
		return _peCustomActionInfo;
	}

	@Override
	public void resetOriginalValues() {
		_peCustomActionInfo.resetOriginalValues();
	}

	private PECustomActionInfo _peCustomActionInfo;
}