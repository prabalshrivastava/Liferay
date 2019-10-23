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
 * This class is a wrapper for {@link SPLikes}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLikes
 * @generated
 */
public class SPLikesWrapper implements SPLikes, ModelWrapper<SPLikes> {
	public SPLikesWrapper(SPLikes spLikes) {
		_spLikes = spLikes;
	}

	@Override
	public Class<?> getModelClass() {
		return SPLikes.class;
	}

	@Override
	public String getModelClassName() {
		return SPLikes.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spLikesId", getSpLikesId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("layoutSetId", getLayoutSetId());
		attributes.put("action", getAction());
		attributes.put("actorUserId", getActorUserId());
		attributes.put("classId", getClassId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spLikesId = (Long)attributes.get("spLikesId");

		if (spLikesId != null) {
			setSpLikesId(spLikesId);
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

		Long layoutSetId = (Long)attributes.get("layoutSetId");

		if (layoutSetId != null) {
			setLayoutSetId(layoutSetId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		Long actorUserId = (Long)attributes.get("actorUserId");

		if (actorUserId != null) {
			setActorUserId(actorUserId);
		}

		Long classId = (Long)attributes.get("classId");

		if (classId != null) {
			setClassId(classId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}
	}

	/**
	* Returns the primary key of this s p likes.
	*
	* @return the primary key of this s p likes
	*/
	@Override
	public long getPrimaryKey() {
		return _spLikes.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p likes.
	*
	* @param primaryKey the primary key of this s p likes
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spLikes.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p likes.
	*
	* @return the uuid of this s p likes
	*/
	@Override
	public java.lang.String getUuid() {
		return _spLikes.getUuid();
	}

	/**
	* Sets the uuid of this s p likes.
	*
	* @param uuid the uuid of this s p likes
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spLikes.setUuid(uuid);
	}

	/**
	* Returns the sp likes ID of this s p likes.
	*
	* @return the sp likes ID of this s p likes
	*/
	@Override
	public long getSpLikesId() {
		return _spLikes.getSpLikesId();
	}

	/**
	* Sets the sp likes ID of this s p likes.
	*
	* @param spLikesId the sp likes ID of this s p likes
	*/
	@Override
	public void setSpLikesId(long spLikesId) {
		_spLikes.setSpLikesId(spLikesId);
	}

	/**
	* Returns the group ID of this s p likes.
	*
	* @return the group ID of this s p likes
	*/
	@Override
	public long getGroupId() {
		return _spLikes.getGroupId();
	}

	/**
	* Sets the group ID of this s p likes.
	*
	* @param groupId the group ID of this s p likes
	*/
	@Override
	public void setGroupId(long groupId) {
		_spLikes.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p likes.
	*
	* @return the company ID of this s p likes
	*/
	@Override
	public long getCompanyId() {
		return _spLikes.getCompanyId();
	}

	/**
	* Sets the company ID of this s p likes.
	*
	* @param companyId the company ID of this s p likes
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spLikes.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p likes.
	*
	* @return the user ID of this s p likes
	*/
	@Override
	public long getUserId() {
		return _spLikes.getUserId();
	}

	/**
	* Sets the user ID of this s p likes.
	*
	* @param userId the user ID of this s p likes
	*/
	@Override
	public void setUserId(long userId) {
		_spLikes.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p likes.
	*
	* @return the user uuid of this s p likes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikes.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p likes.
	*
	* @param userUuid the user uuid of this s p likes
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spLikes.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p likes.
	*
	* @return the user name of this s p likes
	*/
	@Override
	public java.lang.String getUserName() {
		return _spLikes.getUserName();
	}

	/**
	* Sets the user name of this s p likes.
	*
	* @param userName the user name of this s p likes
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spLikes.setUserName(userName);
	}

	/**
	* Returns the create date of this s p likes.
	*
	* @return the create date of this s p likes
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spLikes.getCreateDate();
	}

	/**
	* Sets the create date of this s p likes.
	*
	* @param createDate the create date of this s p likes
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spLikes.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p likes.
	*
	* @return the modified date of this s p likes
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spLikes.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p likes.
	*
	* @param modifiedDate the modified date of this s p likes
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spLikes.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the layout set ID of this s p likes.
	*
	* @return the layout set ID of this s p likes
	*/
	@Override
	public long getLayoutSetId() {
		return _spLikes.getLayoutSetId();
	}

	/**
	* Sets the layout set ID of this s p likes.
	*
	* @param layoutSetId the layout set ID of this s p likes
	*/
	@Override
	public void setLayoutSetId(long layoutSetId) {
		_spLikes.setLayoutSetId(layoutSetId);
	}

	/**
	* Returns the action of this s p likes.
	*
	* @return the action of this s p likes
	*/
	@Override
	public java.lang.String getAction() {
		return _spLikes.getAction();
	}

	/**
	* Sets the action of this s p likes.
	*
	* @param action the action of this s p likes
	*/
	@Override
	public void setAction(java.lang.String action) {
		_spLikes.setAction(action);
	}

	/**
	* Returns the actor user ID of this s p likes.
	*
	* @return the actor user ID of this s p likes
	*/
	@Override
	public long getActorUserId() {
		return _spLikes.getActorUserId();
	}

	/**
	* Sets the actor user ID of this s p likes.
	*
	* @param actorUserId the actor user ID of this s p likes
	*/
	@Override
	public void setActorUserId(long actorUserId) {
		_spLikes.setActorUserId(actorUserId);
	}

	/**
	* Returns the actor user uuid of this s p likes.
	*
	* @return the actor user uuid of this s p likes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getActorUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLikes.getActorUserUuid();
	}

	/**
	* Sets the actor user uuid of this s p likes.
	*
	* @param actorUserUuid the actor user uuid of this s p likes
	*/
	@Override
	public void setActorUserUuid(java.lang.String actorUserUuid) {
		_spLikes.setActorUserUuid(actorUserUuid);
	}

	/**
	* Returns the class ID of this s p likes.
	*
	* @return the class ID of this s p likes
	*/
	@Override
	public long getClassId() {
		return _spLikes.getClassId();
	}

	/**
	* Sets the class ID of this s p likes.
	*
	* @param classId the class ID of this s p likes
	*/
	@Override
	public void setClassId(long classId) {
		_spLikes.setClassId(classId);
	}

	/**
	* Returns the class name of this s p likes.
	*
	* @return the class name of this s p likes
	*/
	@Override
	public java.lang.String getClassName() {
		return _spLikes.getClassName();
	}

	/**
	* Sets the class name of this s p likes.
	*
	* @param className the class name of this s p likes
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_spLikes.setClassName(className);
	}

	/**
	* Returns the class p k of this s p likes.
	*
	* @return the class p k of this s p likes
	*/
	@Override
	public long getClassPK() {
		return _spLikes.getClassPK();
	}

	/**
	* Sets the class p k of this s p likes.
	*
	* @param classPK the class p k of this s p likes
	*/
	@Override
	public void setClassPK(long classPK) {
		_spLikes.setClassPK(classPK);
	}

	@Override
	public boolean isNew() {
		return _spLikes.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spLikes.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spLikes.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spLikes.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spLikes.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spLikes.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spLikes.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spLikes.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spLikes.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spLikes.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spLikes.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPLikesWrapper((SPLikes)_spLikes.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPLikes spLikes) {
		return _spLikes.compareTo(spLikes);
	}

	@Override
	public int hashCode() {
		return _spLikes.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPLikes> toCacheModel() {
		return _spLikes.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes toEscapedModel() {
		return new SPLikesWrapper(_spLikes.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLikes toUnescapedModel() {
		return new SPLikesWrapper(_spLikes.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spLikes.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spLikes.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spLikes.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPLikesWrapper)) {
			return false;
		}

		SPLikesWrapper spLikesWrapper = (SPLikesWrapper)obj;

		if (Validator.equals(_spLikes, spLikesWrapper._spLikes)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spLikes.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPLikes getWrappedSPLikes() {
		return _spLikes;
	}

	@Override
	public SPLikes getWrappedModel() {
		return _spLikes;
	}

	@Override
	public void resetOriginalValues() {
		_spLikes.resetOriginalValues();
	}

	private SPLikes _spLikes;
}