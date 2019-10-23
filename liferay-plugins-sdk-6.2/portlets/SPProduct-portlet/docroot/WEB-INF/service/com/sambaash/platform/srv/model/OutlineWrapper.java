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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Outline}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Outline
 * @generated
 */
public class OutlineWrapper implements Outline, ModelWrapper<Outline> {
	public OutlineWrapper(Outline outline) {
		_outline = outline;
	}

	@Override
	public Class<?> getModelClass() {
		return Outline.class;
	}

	@Override
	public String getModelClassName() {
		return Outline.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spOutlineId", getSpOutlineId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCompetencyUnitId", getSpCompetencyUnitId());
		attributes.put("outlineType", getOutlineType());
		attributes.put("outlineDesc", getOutlineDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spOutlineId = (Long)attributes.get("spOutlineId");

		if (spOutlineId != null) {
			setSpOutlineId(spOutlineId);
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

		Long spCompetencyUnitId = (Long)attributes.get("spCompetencyUnitId");

		if (spCompetencyUnitId != null) {
			setSpCompetencyUnitId(spCompetencyUnitId);
		}

		Long outlineType = (Long)attributes.get("outlineType");

		if (outlineType != null) {
			setOutlineType(outlineType);
		}

		String outlineDesc = (String)attributes.get("outlineDesc");

		if (outlineDesc != null) {
			setOutlineDesc(outlineDesc);
		}
	}

	/**
	* Returns the primary key of this outline.
	*
	* @return the primary key of this outline
	*/
	@Override
	public long getPrimaryKey() {
		return _outline.getPrimaryKey();
	}

	/**
	* Sets the primary key of this outline.
	*
	* @param primaryKey the primary key of this outline
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_outline.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp outline ID of this outline.
	*
	* @return the sp outline ID of this outline
	*/
	@Override
	public long getSpOutlineId() {
		return _outline.getSpOutlineId();
	}

	/**
	* Sets the sp outline ID of this outline.
	*
	* @param spOutlineId the sp outline ID of this outline
	*/
	@Override
	public void setSpOutlineId(long spOutlineId) {
		_outline.setSpOutlineId(spOutlineId);
	}

	/**
	* Returns the group ID of this outline.
	*
	* @return the group ID of this outline
	*/
	@Override
	public long getGroupId() {
		return _outline.getGroupId();
	}

	/**
	* Sets the group ID of this outline.
	*
	* @param groupId the group ID of this outline
	*/
	@Override
	public void setGroupId(long groupId) {
		_outline.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this outline.
	*
	* @return the company ID of this outline
	*/
	@Override
	public long getCompanyId() {
		return _outline.getCompanyId();
	}

	/**
	* Sets the company ID of this outline.
	*
	* @param companyId the company ID of this outline
	*/
	@Override
	public void setCompanyId(long companyId) {
		_outline.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this outline.
	*
	* @return the user ID of this outline
	*/
	@Override
	public long getUserId() {
		return _outline.getUserId();
	}

	/**
	* Sets the user ID of this outline.
	*
	* @param userId the user ID of this outline
	*/
	@Override
	public void setUserId(long userId) {
		_outline.setUserId(userId);
	}

	/**
	* Returns the user uuid of this outline.
	*
	* @return the user uuid of this outline
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _outline.getUserUuid();
	}

	/**
	* Sets the user uuid of this outline.
	*
	* @param userUuid the user uuid of this outline
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_outline.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this outline.
	*
	* @return the user name of this outline
	*/
	@Override
	public java.lang.String getUserName() {
		return _outline.getUserName();
	}

	/**
	* Sets the user name of this outline.
	*
	* @param userName the user name of this outline
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_outline.setUserName(userName);
	}

	/**
	* Returns the create date of this outline.
	*
	* @return the create date of this outline
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _outline.getCreateDate();
	}

	/**
	* Sets the create date of this outline.
	*
	* @param createDate the create date of this outline
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_outline.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this outline.
	*
	* @return the modified date of this outline
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _outline.getModifiedDate();
	}

	/**
	* Sets the modified date of this outline.
	*
	* @param modifiedDate the modified date of this outline
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_outline.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp competency unit ID of this outline.
	*
	* @return the sp competency unit ID of this outline
	*/
	@Override
	public long getSpCompetencyUnitId() {
		return _outline.getSpCompetencyUnitId();
	}

	/**
	* Sets the sp competency unit ID of this outline.
	*
	* @param spCompetencyUnitId the sp competency unit ID of this outline
	*/
	@Override
	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_outline.setSpCompetencyUnitId(spCompetencyUnitId);
	}

	/**
	* Returns the outline type of this outline.
	*
	* @return the outline type of this outline
	*/
	@Override
	public long getOutlineType() {
		return _outline.getOutlineType();
	}

	/**
	* Sets the outline type of this outline.
	*
	* @param outlineType the outline type of this outline
	*/
	@Override
	public void setOutlineType(long outlineType) {
		_outline.setOutlineType(outlineType);
	}

	/**
	* Returns the outline desc of this outline.
	*
	* @return the outline desc of this outline
	*/
	@Override
	public java.lang.String getOutlineDesc() {
		return _outline.getOutlineDesc();
	}

	/**
	* Sets the outline desc of this outline.
	*
	* @param outlineDesc the outline desc of this outline
	*/
	@Override
	public void setOutlineDesc(java.lang.String outlineDesc) {
		_outline.setOutlineDesc(outlineDesc);
	}

	@Override
	public boolean isNew() {
		return _outline.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_outline.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _outline.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_outline.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _outline.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _outline.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_outline.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _outline.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_outline.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_outline.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_outline.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OutlineWrapper((Outline)_outline.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Outline outline) {
		return _outline.compareTo(outline);
	}

	@Override
	public int hashCode() {
		return _outline.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Outline> toCacheModel() {
		return _outline.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Outline toEscapedModel() {
		return new OutlineWrapper(_outline.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Outline toUnescapedModel() {
		return new OutlineWrapper(_outline.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _outline.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _outline.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_outline.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OutlineWrapper)) {
			return false;
		}

		OutlineWrapper outlineWrapper = (OutlineWrapper)obj;

		if (Validator.equals(_outline, outlineWrapper._outline)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Outline getWrappedOutline() {
		return _outline;
	}

	@Override
	public Outline getWrappedModel() {
		return _outline;
	}

	@Override
	public void resetOriginalValues() {
		_outline.resetOriginalValues();
	}

	private Outline _outline;
}