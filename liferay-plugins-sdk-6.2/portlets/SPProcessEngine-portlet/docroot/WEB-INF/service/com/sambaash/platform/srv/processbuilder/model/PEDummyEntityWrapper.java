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
 * This class is a wrapper for {@link PEDummyEntity}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEDummyEntity
 * @generated
 */
public class PEDummyEntityWrapper implements PEDummyEntity,
	ModelWrapper<PEDummyEntity> {
	public PEDummyEntityWrapper(PEDummyEntity peDummyEntity) {
		_peDummyEntity = peDummyEntity;
	}

	@Override
	public Class<?> getModelClass() {
		return PEDummyEntity.class;
	}

	@Override
	public String getModelClassName() {
		return PEDummyEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEDummyEntityId", getSpPEDummyEntityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEDummyEntityId = (Long)attributes.get("spPEDummyEntityId");

		if (spPEDummyEntityId != null) {
			setSpPEDummyEntityId(spPEDummyEntityId);
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
	}

	/**
	* Returns the primary key of this p e dummy entity.
	*
	* @return the primary key of this p e dummy entity
	*/
	@Override
	public long getPrimaryKey() {
		return _peDummyEntity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e dummy entity.
	*
	* @param primaryKey the primary key of this p e dummy entity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peDummyEntity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e dummy entity.
	*
	* @return the uuid of this p e dummy entity
	*/
	@Override
	public java.lang.String getUuid() {
		return _peDummyEntity.getUuid();
	}

	/**
	* Sets the uuid of this p e dummy entity.
	*
	* @param uuid the uuid of this p e dummy entity
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peDummyEntity.setUuid(uuid);
	}

	/**
	* Returns the sp p e dummy entity ID of this p e dummy entity.
	*
	* @return the sp p e dummy entity ID of this p e dummy entity
	*/
	@Override
	public long getSpPEDummyEntityId() {
		return _peDummyEntity.getSpPEDummyEntityId();
	}

	/**
	* Sets the sp p e dummy entity ID of this p e dummy entity.
	*
	* @param spPEDummyEntityId the sp p e dummy entity ID of this p e dummy entity
	*/
	@Override
	public void setSpPEDummyEntityId(long spPEDummyEntityId) {
		_peDummyEntity.setSpPEDummyEntityId(spPEDummyEntityId);
	}

	/**
	* Returns the group ID of this p e dummy entity.
	*
	* @return the group ID of this p e dummy entity
	*/
	@Override
	public long getGroupId() {
		return _peDummyEntity.getGroupId();
	}

	/**
	* Sets the group ID of this p e dummy entity.
	*
	* @param groupId the group ID of this p e dummy entity
	*/
	@Override
	public void setGroupId(long groupId) {
		_peDummyEntity.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this p e dummy entity.
	*
	* @return the company ID of this p e dummy entity
	*/
	@Override
	public long getCompanyId() {
		return _peDummyEntity.getCompanyId();
	}

	/**
	* Sets the company ID of this p e dummy entity.
	*
	* @param companyId the company ID of this p e dummy entity
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peDummyEntity.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this p e dummy entity.
	*
	* @return the user ID of this p e dummy entity
	*/
	@Override
	public long getUserId() {
		return _peDummyEntity.getUserId();
	}

	/**
	* Sets the user ID of this p e dummy entity.
	*
	* @param userId the user ID of this p e dummy entity
	*/
	@Override
	public void setUserId(long userId) {
		_peDummyEntity.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e dummy entity.
	*
	* @return the user uuid of this p e dummy entity
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peDummyEntity.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e dummy entity.
	*
	* @param userUuid the user uuid of this p e dummy entity
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peDummyEntity.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this p e dummy entity.
	*
	* @return the user name of this p e dummy entity
	*/
	@Override
	public java.lang.String getUserName() {
		return _peDummyEntity.getUserName();
	}

	/**
	* Sets the user name of this p e dummy entity.
	*
	* @param userName the user name of this p e dummy entity
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peDummyEntity.setUserName(userName);
	}

	/**
	* Returns the create date of this p e dummy entity.
	*
	* @return the create date of this p e dummy entity
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peDummyEntity.getCreateDate();
	}

	/**
	* Sets the create date of this p e dummy entity.
	*
	* @param createDate the create date of this p e dummy entity
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peDummyEntity.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e dummy entity.
	*
	* @return the modified date of this p e dummy entity
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peDummyEntity.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e dummy entity.
	*
	* @param modifiedDate the modified date of this p e dummy entity
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peDummyEntity.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this p e dummy entity.
	*
	* @return the name of this p e dummy entity
	*/
	@Override
	public java.lang.String getName() {
		return _peDummyEntity.getName();
	}

	/**
	* Sets the name of this p e dummy entity.
	*
	* @param name the name of this p e dummy entity
	*/
	@Override
	public void setName(java.lang.String name) {
		_peDummyEntity.setName(name);
	}

	@Override
	public boolean isNew() {
		return _peDummyEntity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peDummyEntity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peDummyEntity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peDummyEntity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peDummyEntity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peDummyEntity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peDummyEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peDummyEntity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peDummyEntity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peDummyEntity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peDummyEntity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PEDummyEntityWrapper((PEDummyEntity)_peDummyEntity.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PEDummyEntity peDummyEntity) {
		return _peDummyEntity.compareTo(peDummyEntity);
	}

	@Override
	public int hashCode() {
		return _peDummyEntity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PEDummyEntity> toCacheModel() {
		return _peDummyEntity.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity toEscapedModel() {
		return new PEDummyEntityWrapper(_peDummyEntity.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEDummyEntity toUnescapedModel() {
		return new PEDummyEntityWrapper(_peDummyEntity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peDummyEntity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peDummyEntity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peDummyEntity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PEDummyEntityWrapper)) {
			return false;
		}

		PEDummyEntityWrapper peDummyEntityWrapper = (PEDummyEntityWrapper)obj;

		if (Validator.equals(_peDummyEntity, peDummyEntityWrapper._peDummyEntity)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peDummyEntity.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PEDummyEntity getWrappedPEDummyEntity() {
		return _peDummyEntity;
	}

	@Override
	public PEDummyEntity getWrappedModel() {
		return _peDummyEntity;
	}

	@Override
	public void resetOriginalValues() {
		_peDummyEntity.resetOriginalValues();
	}

	private PEDummyEntity _peDummyEntity;
}