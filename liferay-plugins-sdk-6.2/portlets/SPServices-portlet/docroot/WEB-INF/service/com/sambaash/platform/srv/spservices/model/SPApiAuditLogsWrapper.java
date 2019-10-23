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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPApiAuditLogs}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPApiAuditLogs
 * @generated
 */
public class SPApiAuditLogsWrapper implements SPApiAuditLogs,
	ModelWrapper<SPApiAuditLogs> {
	public SPApiAuditLogsWrapper(SPApiAuditLogs spApiAuditLogs) {
		_spApiAuditLogs = spApiAuditLogs;
	}

	@Override
	public Class<?> getModelClass() {
		return SPApiAuditLogs.class;
	}

	@Override
	public String getModelClassName() {
		return SPApiAuditLogs.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spApiAuditLogsId", getSpApiAuditLogsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("apiName", getApiName());
		attributes.put("parameters", getParameters());
		attributes.put("result", getResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spApiAuditLogsId = (Long)attributes.get("spApiAuditLogsId");

		if (spApiAuditLogsId != null) {
			setSpApiAuditLogsId(spApiAuditLogsId);
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

		String apiName = (String)attributes.get("apiName");

		if (apiName != null) {
			setApiName(apiName);
		}

		String parameters = (String)attributes.get("parameters");

		if (parameters != null) {
			setParameters(parameters);
		}

		String result = (String)attributes.get("result");

		if (result != null) {
			setResult(result);
		}
	}

	/**
	* Returns the primary key of this s p api audit logs.
	*
	* @return the primary key of this s p api audit logs
	*/
	@Override
	public long getPrimaryKey() {
		return _spApiAuditLogs.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p api audit logs.
	*
	* @param primaryKey the primary key of this s p api audit logs
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spApiAuditLogs.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p api audit logs.
	*
	* @return the uuid of this s p api audit logs
	*/
	@Override
	public java.lang.String getUuid() {
		return _spApiAuditLogs.getUuid();
	}

	/**
	* Sets the uuid of this s p api audit logs.
	*
	* @param uuid the uuid of this s p api audit logs
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spApiAuditLogs.setUuid(uuid);
	}

	/**
	* Returns the sp api audit logs ID of this s p api audit logs.
	*
	* @return the sp api audit logs ID of this s p api audit logs
	*/
	@Override
	public long getSpApiAuditLogsId() {
		return _spApiAuditLogs.getSpApiAuditLogsId();
	}

	/**
	* Sets the sp api audit logs ID of this s p api audit logs.
	*
	* @param spApiAuditLogsId the sp api audit logs ID of this s p api audit logs
	*/
	@Override
	public void setSpApiAuditLogsId(long spApiAuditLogsId) {
		_spApiAuditLogs.setSpApiAuditLogsId(spApiAuditLogsId);
	}

	/**
	* Returns the group ID of this s p api audit logs.
	*
	* @return the group ID of this s p api audit logs
	*/
	@Override
	public long getGroupId() {
		return _spApiAuditLogs.getGroupId();
	}

	/**
	* Sets the group ID of this s p api audit logs.
	*
	* @param groupId the group ID of this s p api audit logs
	*/
	@Override
	public void setGroupId(long groupId) {
		_spApiAuditLogs.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p api audit logs.
	*
	* @return the company ID of this s p api audit logs
	*/
	@Override
	public long getCompanyId() {
		return _spApiAuditLogs.getCompanyId();
	}

	/**
	* Sets the company ID of this s p api audit logs.
	*
	* @param companyId the company ID of this s p api audit logs
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spApiAuditLogs.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p api audit logs.
	*
	* @return the user ID of this s p api audit logs
	*/
	@Override
	public long getUserId() {
		return _spApiAuditLogs.getUserId();
	}

	/**
	* Sets the user ID of this s p api audit logs.
	*
	* @param userId the user ID of this s p api audit logs
	*/
	@Override
	public void setUserId(long userId) {
		_spApiAuditLogs.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p api audit logs.
	*
	* @return the user uuid of this s p api audit logs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spApiAuditLogs.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p api audit logs.
	*
	* @param userUuid the user uuid of this s p api audit logs
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spApiAuditLogs.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p api audit logs.
	*
	* @return the user name of this s p api audit logs
	*/
	@Override
	public java.lang.String getUserName() {
		return _spApiAuditLogs.getUserName();
	}

	/**
	* Sets the user name of this s p api audit logs.
	*
	* @param userName the user name of this s p api audit logs
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spApiAuditLogs.setUserName(userName);
	}

	/**
	* Returns the create date of this s p api audit logs.
	*
	* @return the create date of this s p api audit logs
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spApiAuditLogs.getCreateDate();
	}

	/**
	* Sets the create date of this s p api audit logs.
	*
	* @param createDate the create date of this s p api audit logs
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spApiAuditLogs.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p api audit logs.
	*
	* @return the modified date of this s p api audit logs
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spApiAuditLogs.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p api audit logs.
	*
	* @param modifiedDate the modified date of this s p api audit logs
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spApiAuditLogs.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the api name of this s p api audit logs.
	*
	* @return the api name of this s p api audit logs
	*/
	@Override
	public java.lang.String getApiName() {
		return _spApiAuditLogs.getApiName();
	}

	/**
	* Sets the api name of this s p api audit logs.
	*
	* @param apiName the api name of this s p api audit logs
	*/
	@Override
	public void setApiName(java.lang.String apiName) {
		_spApiAuditLogs.setApiName(apiName);
	}

	/**
	* Returns the parameters of this s p api audit logs.
	*
	* @return the parameters of this s p api audit logs
	*/
	@Override
	public java.lang.String getParameters() {
		return _spApiAuditLogs.getParameters();
	}

	/**
	* Sets the parameters of this s p api audit logs.
	*
	* @param parameters the parameters of this s p api audit logs
	*/
	@Override
	public void setParameters(java.lang.String parameters) {
		_spApiAuditLogs.setParameters(parameters);
	}

	/**
	* Returns the result of this s p api audit logs.
	*
	* @return the result of this s p api audit logs
	*/
	@Override
	public java.lang.String getResult() {
		return _spApiAuditLogs.getResult();
	}

	/**
	* Sets the result of this s p api audit logs.
	*
	* @param result the result of this s p api audit logs
	*/
	@Override
	public void setResult(java.lang.String result) {
		_spApiAuditLogs.setResult(result);
	}

	@Override
	public boolean isNew() {
		return _spApiAuditLogs.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spApiAuditLogs.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spApiAuditLogs.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spApiAuditLogs.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spApiAuditLogs.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spApiAuditLogs.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spApiAuditLogs.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spApiAuditLogs.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spApiAuditLogs.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spApiAuditLogs.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spApiAuditLogs.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPApiAuditLogsWrapper((SPApiAuditLogs)_spApiAuditLogs.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPApiAuditLogs spApiAuditLogs) {
		return _spApiAuditLogs.compareTo(spApiAuditLogs);
	}

	@Override
	public int hashCode() {
		return _spApiAuditLogs.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPApiAuditLogs> toCacheModel() {
		return _spApiAuditLogs.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs toEscapedModel() {
		return new SPApiAuditLogsWrapper(_spApiAuditLogs.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPApiAuditLogs toUnescapedModel() {
		return new SPApiAuditLogsWrapper(_spApiAuditLogs.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spApiAuditLogs.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spApiAuditLogs.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spApiAuditLogs.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPApiAuditLogsWrapper)) {
			return false;
		}

		SPApiAuditLogsWrapper spApiAuditLogsWrapper = (SPApiAuditLogsWrapper)obj;

		if (Validator.equals(_spApiAuditLogs,
					spApiAuditLogsWrapper._spApiAuditLogs)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spApiAuditLogs.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPApiAuditLogs getWrappedSPApiAuditLogs() {
		return _spApiAuditLogs;
	}

	@Override
	public SPApiAuditLogs getWrappedModel() {
		return _spApiAuditLogs;
	}

	@Override
	public void resetOriginalValues() {
		_spApiAuditLogs.resetOriginalValues();
	}

	private SPApiAuditLogs _spApiAuditLogs;
}