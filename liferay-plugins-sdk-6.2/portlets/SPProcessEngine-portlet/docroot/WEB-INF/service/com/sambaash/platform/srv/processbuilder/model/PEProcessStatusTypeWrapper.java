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
 * This class is a wrapper for {@link PEProcessStatusType}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStatusType
 * @generated
 */
public class PEProcessStatusTypeWrapper implements PEProcessStatusType,
	ModelWrapper<PEProcessStatusType> {
	public PEProcessStatusTypeWrapper(PEProcessStatusType peProcessStatusType) {
		_peProcessStatusType = peProcessStatusType;
	}

	@Override
	public Class<?> getModelClass() {
		return PEProcessStatusType.class;
	}

	@Override
	public String getModelClassName() {
		return PEProcessStatusType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEProcessStatusTypeId", getSpPEProcessStatusTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessId", getSpPEProcessId());
		attributes.put("statusName", getStatusName());
		attributes.put("seqNo", getSeqNo());
		attributes.put("approveTemplateId", getApproveTemplateId());
		attributes.put("rejectTemplateId", getRejectTemplateId());
		attributes.put("spPEProcessStageId", getSpPEProcessStageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEProcessStatusTypeId = (Long)attributes.get(
				"spPEProcessStatusTypeId");

		if (spPEProcessStatusTypeId != null) {
			setSpPEProcessStatusTypeId(spPEProcessStatusTypeId);
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

		Long spPEProcessId = (Long)attributes.get("spPEProcessId");

		if (spPEProcessId != null) {
			setSpPEProcessId(spPEProcessId);
		}

		String statusName = (String)attributes.get("statusName");

		if (statusName != null) {
			setStatusName(statusName);
		}

		Long seqNo = (Long)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Long approveTemplateId = (Long)attributes.get("approveTemplateId");

		if (approveTemplateId != null) {
			setApproveTemplateId(approveTemplateId);
		}

		Long rejectTemplateId = (Long)attributes.get("rejectTemplateId");

		if (rejectTemplateId != null) {
			setRejectTemplateId(rejectTemplateId);
		}

		Long spPEProcessStageId = (Long)attributes.get("spPEProcessStageId");

		if (spPEProcessStageId != null) {
			setSpPEProcessStageId(spPEProcessStageId);
		}
	}

	/**
	* Returns the primary key of this p e process status type.
	*
	* @return the primary key of this p e process status type
	*/
	@Override
	public long getPrimaryKey() {
		return _peProcessStatusType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e process status type.
	*
	* @param primaryKey the primary key of this p e process status type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peProcessStatusType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e process status type.
	*
	* @return the uuid of this p e process status type
	*/
	@Override
	public java.lang.String getUuid() {
		return _peProcessStatusType.getUuid();
	}

	/**
	* Sets the uuid of this p e process status type.
	*
	* @param uuid the uuid of this p e process status type
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peProcessStatusType.setUuid(uuid);
	}

	/**
	* Returns the sp p e process status type ID of this p e process status type.
	*
	* @return the sp p e process status type ID of this p e process status type
	*/
	@Override
	public long getSpPEProcessStatusTypeId() {
		return _peProcessStatusType.getSpPEProcessStatusTypeId();
	}

	/**
	* Sets the sp p e process status type ID of this p e process status type.
	*
	* @param spPEProcessStatusTypeId the sp p e process status type ID of this p e process status type
	*/
	@Override
	public void setSpPEProcessStatusTypeId(long spPEProcessStatusTypeId) {
		_peProcessStatusType.setSpPEProcessStatusTypeId(spPEProcessStatusTypeId);
	}

	/**
	* Returns the group ID of this p e process status type.
	*
	* @return the group ID of this p e process status type
	*/
	@Override
	public long getGroupId() {
		return _peProcessStatusType.getGroupId();
	}

	/**
	* Sets the group ID of this p e process status type.
	*
	* @param groupId the group ID of this p e process status type
	*/
	@Override
	public void setGroupId(long groupId) {
		_peProcessStatusType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this p e process status type.
	*
	* @return the company ID of this p e process status type
	*/
	@Override
	public long getCompanyId() {
		return _peProcessStatusType.getCompanyId();
	}

	/**
	* Sets the company ID of this p e process status type.
	*
	* @param companyId the company ID of this p e process status type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peProcessStatusType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this p e process status type.
	*
	* @return the user ID of this p e process status type
	*/
	@Override
	public long getUserId() {
		return _peProcessStatusType.getUserId();
	}

	/**
	* Sets the user ID of this p e process status type.
	*
	* @param userId the user ID of this p e process status type
	*/
	@Override
	public void setUserId(long userId) {
		_peProcessStatusType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e process status type.
	*
	* @return the user uuid of this p e process status type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessStatusType.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e process status type.
	*
	* @param userUuid the user uuid of this p e process status type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peProcessStatusType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this p e process status type.
	*
	* @return the user name of this p e process status type
	*/
	@Override
	public java.lang.String getUserName() {
		return _peProcessStatusType.getUserName();
	}

	/**
	* Sets the user name of this p e process status type.
	*
	* @param userName the user name of this p e process status type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peProcessStatusType.setUserName(userName);
	}

	/**
	* Returns the create date of this p e process status type.
	*
	* @return the create date of this p e process status type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peProcessStatusType.getCreateDate();
	}

	/**
	* Sets the create date of this p e process status type.
	*
	* @param createDate the create date of this p e process status type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peProcessStatusType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e process status type.
	*
	* @return the modified date of this p e process status type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peProcessStatusType.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e process status type.
	*
	* @param modifiedDate the modified date of this p e process status type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peProcessStatusType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp p e process ID of this p e process status type.
	*
	* @return the sp p e process ID of this p e process status type
	*/
	@Override
	public long getSpPEProcessId() {
		return _peProcessStatusType.getSpPEProcessId();
	}

	/**
	* Sets the sp p e process ID of this p e process status type.
	*
	* @param spPEProcessId the sp p e process ID of this p e process status type
	*/
	@Override
	public void setSpPEProcessId(long spPEProcessId) {
		_peProcessStatusType.setSpPEProcessId(spPEProcessId);
	}

	/**
	* Returns the status name of this p e process status type.
	*
	* @return the status name of this p e process status type
	*/
	@Override
	public java.lang.String getStatusName() {
		return _peProcessStatusType.getStatusName();
	}

	/**
	* Sets the status name of this p e process status type.
	*
	* @param statusName the status name of this p e process status type
	*/
	@Override
	public void setStatusName(java.lang.String statusName) {
		_peProcessStatusType.setStatusName(statusName);
	}

	/**
	* Returns the seq no of this p e process status type.
	*
	* @return the seq no of this p e process status type
	*/
	@Override
	public long getSeqNo() {
		return _peProcessStatusType.getSeqNo();
	}

	/**
	* Sets the seq no of this p e process status type.
	*
	* @param seqNo the seq no of this p e process status type
	*/
	@Override
	public void setSeqNo(long seqNo) {
		_peProcessStatusType.setSeqNo(seqNo);
	}

	/**
	* Returns the approve template ID of this p e process status type.
	*
	* @return the approve template ID of this p e process status type
	*/
	@Override
	public long getApproveTemplateId() {
		return _peProcessStatusType.getApproveTemplateId();
	}

	/**
	* Sets the approve template ID of this p e process status type.
	*
	* @param approveTemplateId the approve template ID of this p e process status type
	*/
	@Override
	public void setApproveTemplateId(long approveTemplateId) {
		_peProcessStatusType.setApproveTemplateId(approveTemplateId);
	}

	/**
	* Returns the reject template ID of this p e process status type.
	*
	* @return the reject template ID of this p e process status type
	*/
	@Override
	public long getRejectTemplateId() {
		return _peProcessStatusType.getRejectTemplateId();
	}

	/**
	* Sets the reject template ID of this p e process status type.
	*
	* @param rejectTemplateId the reject template ID of this p e process status type
	*/
	@Override
	public void setRejectTemplateId(long rejectTemplateId) {
		_peProcessStatusType.setRejectTemplateId(rejectTemplateId);
	}

	/**
	* Returns the sp p e process stage ID of this p e process status type.
	*
	* @return the sp p e process stage ID of this p e process status type
	*/
	@Override
	public long getSpPEProcessStageId() {
		return _peProcessStatusType.getSpPEProcessStageId();
	}

	/**
	* Sets the sp p e process stage ID of this p e process status type.
	*
	* @param spPEProcessStageId the sp p e process stage ID of this p e process status type
	*/
	@Override
	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_peProcessStatusType.setSpPEProcessStageId(spPEProcessStageId);
	}

	@Override
	public boolean isNew() {
		return _peProcessStatusType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peProcessStatusType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peProcessStatusType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peProcessStatusType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peProcessStatusType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peProcessStatusType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peProcessStatusType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peProcessStatusType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peProcessStatusType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peProcessStatusType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peProcessStatusType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PEProcessStatusTypeWrapper((PEProcessStatusType)_peProcessStatusType.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType peProcessStatusType) {
		return _peProcessStatusType.compareTo(peProcessStatusType);
	}

	@Override
	public int hashCode() {
		return _peProcessStatusType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType> toCacheModel() {
		return _peProcessStatusType.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType toEscapedModel() {
		return new PEProcessStatusTypeWrapper(_peProcessStatusType.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType toUnescapedModel() {
		return new PEProcessStatusTypeWrapper(_peProcessStatusType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peProcessStatusType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peProcessStatusType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peProcessStatusType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PEProcessStatusTypeWrapper)) {
			return false;
		}

		PEProcessStatusTypeWrapper peProcessStatusTypeWrapper = (PEProcessStatusTypeWrapper)obj;

		if (Validator.equals(_peProcessStatusType,
					peProcessStatusTypeWrapper._peProcessStatusType)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peProcessStatusType.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PEProcessStatusType getWrappedPEProcessStatusType() {
		return _peProcessStatusType;
	}

	@Override
	public PEProcessStatusType getWrappedModel() {
		return _peProcessStatusType;
	}

	@Override
	public void resetOriginalValues() {
		_peProcessStatusType.resetOriginalValues();
	}

	private PEProcessStatusType _peProcessStatusType;
}