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
 * This class is a wrapper for {@link PEProcessStage}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStage
 * @generated
 */
public class PEProcessStageWrapper implements PEProcessStage,
	ModelWrapper<PEProcessStage> {
	public PEProcessStageWrapper(PEProcessStage peProcessStage) {
		_peProcessStage = peProcessStage;
	}

	@Override
	public Class<?> getModelClass() {
		return PEProcessStage.class;
	}

	@Override
	public String getModelClassName() {
		return PEProcessStage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEProcessStageId", getSpPEProcessStageId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("style", getStyle());
		attributes.put("seqNo", getSeqNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEProcessStageId = (Long)attributes.get("spPEProcessStageId");

		if (spPEProcessStageId != null) {
			setSpPEProcessStageId(spPEProcessStageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String style = (String)attributes.get("style");

		if (style != null) {
			setStyle(style);
		}

		Long seqNo = (Long)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}
	}

	/**
	* Returns the primary key of this p e process stage.
	*
	* @return the primary key of this p e process stage
	*/
	@Override
	public long getPrimaryKey() {
		return _peProcessStage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e process stage.
	*
	* @param primaryKey the primary key of this p e process stage
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peProcessStage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e process stage.
	*
	* @return the uuid of this p e process stage
	*/
	@Override
	public java.lang.String getUuid() {
		return _peProcessStage.getUuid();
	}

	/**
	* Sets the uuid of this p e process stage.
	*
	* @param uuid the uuid of this p e process stage
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peProcessStage.setUuid(uuid);
	}

	/**
	* Returns the sp p e process stage ID of this p e process stage.
	*
	* @return the sp p e process stage ID of this p e process stage
	*/
	@Override
	public long getSpPEProcessStageId() {
		return _peProcessStage.getSpPEProcessStageId();
	}

	/**
	* Sets the sp p e process stage ID of this p e process stage.
	*
	* @param spPEProcessStageId the sp p e process stage ID of this p e process stage
	*/
	@Override
	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_peProcessStage.setSpPEProcessStageId(spPEProcessStageId);
	}

	/**
	* Returns the group ID of this p e process stage.
	*
	* @return the group ID of this p e process stage
	*/
	@Override
	public long getGroupId() {
		return _peProcessStage.getGroupId();
	}

	/**
	* Sets the group ID of this p e process stage.
	*
	* @param groupId the group ID of this p e process stage
	*/
	@Override
	public void setGroupId(long groupId) {
		_peProcessStage.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this p e process stage.
	*
	* @return the user ID of this p e process stage
	*/
	@Override
	public long getUserId() {
		return _peProcessStage.getUserId();
	}

	/**
	* Sets the user ID of this p e process stage.
	*
	* @param userId the user ID of this p e process stage
	*/
	@Override
	public void setUserId(long userId) {
		_peProcessStage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e process stage.
	*
	* @return the user uuid of this p e process stage
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStage.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e process stage.
	*
	* @param userUuid the user uuid of this p e process stage
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peProcessStage.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this p e process stage.
	*
	* @return the company ID of this p e process stage
	*/
	@Override
	public long getCompanyId() {
		return _peProcessStage.getCompanyId();
	}

	/**
	* Sets the company ID of this p e process stage.
	*
	* @param companyId the company ID of this p e process stage
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peProcessStage.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this p e process stage.
	*
	* @return the user name of this p e process stage
	*/
	@Override
	public java.lang.String getUserName() {
		return _peProcessStage.getUserName();
	}

	/**
	* Sets the user name of this p e process stage.
	*
	* @param userName the user name of this p e process stage
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peProcessStage.setUserName(userName);
	}

	/**
	* Returns the create date of this p e process stage.
	*
	* @return the create date of this p e process stage
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peProcessStage.getCreateDate();
	}

	/**
	* Sets the create date of this p e process stage.
	*
	* @param createDate the create date of this p e process stage
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peProcessStage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e process stage.
	*
	* @return the modified date of this p e process stage
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peProcessStage.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e process stage.
	*
	* @param modifiedDate the modified date of this p e process stage
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peProcessStage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this p e process stage.
	*
	* @return the name of this p e process stage
	*/
	@Override
	public java.lang.String getName() {
		return _peProcessStage.getName();
	}

	/**
	* Sets the name of this p e process stage.
	*
	* @param name the name of this p e process stage
	*/
	@Override
	public void setName(java.lang.String name) {
		_peProcessStage.setName(name);
	}

	/**
	* Returns the style of this p e process stage.
	*
	* @return the style of this p e process stage
	*/
	@Override
	public java.lang.String getStyle() {
		return _peProcessStage.getStyle();
	}

	/**
	* Sets the style of this p e process stage.
	*
	* @param style the style of this p e process stage
	*/
	@Override
	public void setStyle(java.lang.String style) {
		_peProcessStage.setStyle(style);
	}

	/**
	* Returns the seq no of this p e process stage.
	*
	* @return the seq no of this p e process stage
	*/
	@Override
	public long getSeqNo() {
		return _peProcessStage.getSeqNo();
	}

	/**
	* Sets the seq no of this p e process stage.
	*
	* @param seqNo the seq no of this p e process stage
	*/
	@Override
	public void setSeqNo(long seqNo) {
		_peProcessStage.setSeqNo(seqNo);
	}

	@Override
	public boolean isNew() {
		return _peProcessStage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peProcessStage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peProcessStage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peProcessStage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peProcessStage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peProcessStage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peProcessStage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peProcessStage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peProcessStage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peProcessStage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peProcessStage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PEProcessStageWrapper((PEProcessStage)_peProcessStage.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStage peProcessStage) {
		return _peProcessStage.compareTo(peProcessStage);
	}

	@Override
	public int hashCode() {
		return _peProcessStage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PEProcessStage> toCacheModel() {
		return _peProcessStage.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage toEscapedModel() {
		return new PEProcessStageWrapper(_peProcessStage.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStage toUnescapedModel() {
		return new PEProcessStageWrapper(_peProcessStage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peProcessStage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peProcessStage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peProcessStage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PEProcessStageWrapper)) {
			return false;
		}

		PEProcessStageWrapper peProcessStageWrapper = (PEProcessStageWrapper)obj;

		if (Validator.equals(_peProcessStage,
					peProcessStageWrapper._peProcessStage)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peProcessStage.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PEProcessStage getWrappedPEProcessStage() {
		return _peProcessStage;
	}

	@Override
	public PEProcessStage getWrappedModel() {
		return _peProcessStage;
	}

	@Override
	public void resetOriginalValues() {
		_peProcessStage.resetOriginalValues();
	}

	private PEProcessStage _peProcessStage;
}