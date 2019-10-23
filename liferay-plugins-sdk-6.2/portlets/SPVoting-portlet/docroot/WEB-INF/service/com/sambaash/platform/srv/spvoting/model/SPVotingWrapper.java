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

package com.sambaash.platform.srv.spvoting.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPVoting}.
 * </p>
 *
 * @author harini
 * @see SPVoting
 * @generated
 */
public class SPVotingWrapper implements SPVoting, ModelWrapper<SPVoting> {
	public SPVotingWrapper(SPVoting spVoting) {
		_spVoting = spVoting;
	}

	@Override
	public Class<?> getModelClass() {
		return SPVoting.class;
	}

	@Override
	public String getModelClassName() {
		return SPVoting.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spVotingId", getSpVotingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("ip", getIp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spVotingId = (Long)attributes.get("spVotingId");

		if (spVotingId != null) {
			setSpVotingId(spVotingId);
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

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String ip = (String)attributes.get("ip");

		if (ip != null) {
			setIp(ip);
		}
	}

	/**
	* Returns the primary key of this s p voting.
	*
	* @return the primary key of this s p voting
	*/
	@Override
	public long getPrimaryKey() {
		return _spVoting.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p voting.
	*
	* @param primaryKey the primary key of this s p voting
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spVoting.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p voting.
	*
	* @return the uuid of this s p voting
	*/
	@Override
	public java.lang.String getUuid() {
		return _spVoting.getUuid();
	}

	/**
	* Sets the uuid of this s p voting.
	*
	* @param uuid the uuid of this s p voting
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spVoting.setUuid(uuid);
	}

	/**
	* Returns the sp voting ID of this s p voting.
	*
	* @return the sp voting ID of this s p voting
	*/
	@Override
	public long getSpVotingId() {
		return _spVoting.getSpVotingId();
	}

	/**
	* Sets the sp voting ID of this s p voting.
	*
	* @param spVotingId the sp voting ID of this s p voting
	*/
	@Override
	public void setSpVotingId(long spVotingId) {
		_spVoting.setSpVotingId(spVotingId);
	}

	/**
	* Returns the group ID of this s p voting.
	*
	* @return the group ID of this s p voting
	*/
	@Override
	public long getGroupId() {
		return _spVoting.getGroupId();
	}

	/**
	* Sets the group ID of this s p voting.
	*
	* @param groupId the group ID of this s p voting
	*/
	@Override
	public void setGroupId(long groupId) {
		_spVoting.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p voting.
	*
	* @return the company ID of this s p voting
	*/
	@Override
	public long getCompanyId() {
		return _spVoting.getCompanyId();
	}

	/**
	* Sets the company ID of this s p voting.
	*
	* @param companyId the company ID of this s p voting
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spVoting.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p voting.
	*
	* @return the user ID of this s p voting
	*/
	@Override
	public long getUserId() {
		return _spVoting.getUserId();
	}

	/**
	* Sets the user ID of this s p voting.
	*
	* @param userId the user ID of this s p voting
	*/
	@Override
	public void setUserId(long userId) {
		_spVoting.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p voting.
	*
	* @return the user uuid of this s p voting
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spVoting.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p voting.
	*
	* @param userUuid the user uuid of this s p voting
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spVoting.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p voting.
	*
	* @return the user name of this s p voting
	*/
	@Override
	public java.lang.String getUserName() {
		return _spVoting.getUserName();
	}

	/**
	* Sets the user name of this s p voting.
	*
	* @param userName the user name of this s p voting
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spVoting.setUserName(userName);
	}

	/**
	* Returns the create date of this s p voting.
	*
	* @return the create date of this s p voting
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spVoting.getCreateDate();
	}

	/**
	* Sets the create date of this s p voting.
	*
	* @param createDate the create date of this s p voting
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spVoting.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p voting.
	*
	* @return the modified date of this s p voting
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spVoting.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p voting.
	*
	* @param modifiedDate the modified date of this s p voting
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spVoting.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the class name of this s p voting.
	*
	* @return the class name of this s p voting
	*/
	@Override
	public java.lang.String getClassName() {
		return _spVoting.getClassName();
	}

	/**
	* Sets the class name of this s p voting.
	*
	* @param className the class name of this s p voting
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_spVoting.setClassName(className);
	}

	/**
	* Returns the class p k of this s p voting.
	*
	* @return the class p k of this s p voting
	*/
	@Override
	public long getClassPK() {
		return _spVoting.getClassPK();
	}

	/**
	* Sets the class p k of this s p voting.
	*
	* @param classPK the class p k of this s p voting
	*/
	@Override
	public void setClassPK(long classPK) {
		_spVoting.setClassPK(classPK);
	}

	/**
	* Returns the ip of this s p voting.
	*
	* @return the ip of this s p voting
	*/
	@Override
	public java.lang.String getIp() {
		return _spVoting.getIp();
	}

	/**
	* Sets the ip of this s p voting.
	*
	* @param ip the ip of this s p voting
	*/
	@Override
	public void setIp(java.lang.String ip) {
		_spVoting.setIp(ip);
	}

	@Override
	public boolean isNew() {
		return _spVoting.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spVoting.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spVoting.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spVoting.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spVoting.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spVoting.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spVoting.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spVoting.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spVoting.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spVoting.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spVoting.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPVotingWrapper((SPVoting)_spVoting.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spvoting.model.SPVoting spVoting) {
		return _spVoting.compareTo(spVoting);
	}

	@Override
	public int hashCode() {
		return _spVoting.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spvoting.model.SPVoting> toCacheModel() {
		return _spVoting.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spvoting.model.SPVoting toEscapedModel() {
		return new SPVotingWrapper(_spVoting.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spvoting.model.SPVoting toUnescapedModel() {
		return new SPVotingWrapper(_spVoting.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spVoting.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spVoting.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spVoting.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPVotingWrapper)) {
			return false;
		}

		SPVotingWrapper spVotingWrapper = (SPVotingWrapper)obj;

		if (Validator.equals(_spVoting, spVotingWrapper._spVoting)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spVoting.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPVoting getWrappedSPVoting() {
		return _spVoting;
	}

	@Override
	public SPVoting getWrappedModel() {
		return _spVoting;
	}

	@Override
	public void resetOriginalValues() {
		_spVoting.resetOriginalValues();
	}

	private SPVoting _spVoting;
}