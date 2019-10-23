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

package com.sambaash.platform.srv.legalandcontract.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RDL}.
 * </p>
 *
 * @author nareshchebolu
 * @see RDL
 * @generated
 */
public class RDLWrapper implements RDL, ModelWrapper<RDL> {
	public RDLWrapper(RDL rdl) {
		_rdl = rdl;
	}

	@Override
	public Class<?> getModelClass() {
		return RDL.class;
	}

	@Override
	public String getModelClassName() {
		return RDL.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spRdlId", getSpRdlId());
		attributes.put("spLitigationId", getSpLitigationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("responseDeadline", getResponseDeadline());
		attributes.put("claimsRemarks", getClaimsRemarks());
		attributes.put("alertBefore", getAlertBefore());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spRdlId = (Long)attributes.get("spRdlId");

		if (spRdlId != null) {
			setSpRdlId(spRdlId);
		}

		Long spLitigationId = (Long)attributes.get("spLitigationId");

		if (spLitigationId != null) {
			setSpLitigationId(spLitigationId);
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

		Date responseDeadline = (Date)attributes.get("responseDeadline");

		if (responseDeadline != null) {
			setResponseDeadline(responseDeadline);
		}

		String claimsRemarks = (String)attributes.get("claimsRemarks");

		if (claimsRemarks != null) {
			setClaimsRemarks(claimsRemarks);
		}

		Long alertBefore = (Long)attributes.get("alertBefore");

		if (alertBefore != null) {
			setAlertBefore(alertBefore);
		}
	}

	/**
	* Returns the primary key of this r d l.
	*
	* @return the primary key of this r d l
	*/
	@Override
	public long getPrimaryKey() {
		return _rdl.getPrimaryKey();
	}

	/**
	* Sets the primary key of this r d l.
	*
	* @param primaryKey the primary key of this r d l
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rdl.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this r d l.
	*
	* @return the uuid of this r d l
	*/
	@Override
	public java.lang.String getUuid() {
		return _rdl.getUuid();
	}

	/**
	* Sets the uuid of this r d l.
	*
	* @param uuid the uuid of this r d l
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rdl.setUuid(uuid);
	}

	/**
	* Returns the sp rdl ID of this r d l.
	*
	* @return the sp rdl ID of this r d l
	*/
	@Override
	public long getSpRdlId() {
		return _rdl.getSpRdlId();
	}

	/**
	* Sets the sp rdl ID of this r d l.
	*
	* @param spRdlId the sp rdl ID of this r d l
	*/
	@Override
	public void setSpRdlId(long spRdlId) {
		_rdl.setSpRdlId(spRdlId);
	}

	/**
	* Returns the sp litigation ID of this r d l.
	*
	* @return the sp litigation ID of this r d l
	*/
	@Override
	public long getSpLitigationId() {
		return _rdl.getSpLitigationId();
	}

	/**
	* Sets the sp litigation ID of this r d l.
	*
	* @param spLitigationId the sp litigation ID of this r d l
	*/
	@Override
	public void setSpLitigationId(long spLitigationId) {
		_rdl.setSpLitigationId(spLitigationId);
	}

	/**
	* Returns the group ID of this r d l.
	*
	* @return the group ID of this r d l
	*/
	@Override
	public long getGroupId() {
		return _rdl.getGroupId();
	}

	/**
	* Sets the group ID of this r d l.
	*
	* @param groupId the group ID of this r d l
	*/
	@Override
	public void setGroupId(long groupId) {
		_rdl.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this r d l.
	*
	* @return the company ID of this r d l
	*/
	@Override
	public long getCompanyId() {
		return _rdl.getCompanyId();
	}

	/**
	* Sets the company ID of this r d l.
	*
	* @param companyId the company ID of this r d l
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rdl.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this r d l.
	*
	* @return the user ID of this r d l
	*/
	@Override
	public long getUserId() {
		return _rdl.getUserId();
	}

	/**
	* Sets the user ID of this r d l.
	*
	* @param userId the user ID of this r d l
	*/
	@Override
	public void setUserId(long userId) {
		_rdl.setUserId(userId);
	}

	/**
	* Returns the user uuid of this r d l.
	*
	* @return the user uuid of this r d l
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdl.getUserUuid();
	}

	/**
	* Sets the user uuid of this r d l.
	*
	* @param userUuid the user uuid of this r d l
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rdl.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this r d l.
	*
	* @return the user name of this r d l
	*/
	@Override
	public java.lang.String getUserName() {
		return _rdl.getUserName();
	}

	/**
	* Sets the user name of this r d l.
	*
	* @param userName the user name of this r d l
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rdl.setUserName(userName);
	}

	/**
	* Returns the create date of this r d l.
	*
	* @return the create date of this r d l
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rdl.getCreateDate();
	}

	/**
	* Sets the create date of this r d l.
	*
	* @param createDate the create date of this r d l
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rdl.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this r d l.
	*
	* @return the modified date of this r d l
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rdl.getModifiedDate();
	}

	/**
	* Sets the modified date of this r d l.
	*
	* @param modifiedDate the modified date of this r d l
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rdl.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the response deadline of this r d l.
	*
	* @return the response deadline of this r d l
	*/
	@Override
	public java.util.Date getResponseDeadline() {
		return _rdl.getResponseDeadline();
	}

	/**
	* Sets the response deadline of this r d l.
	*
	* @param responseDeadline the response deadline of this r d l
	*/
	@Override
	public void setResponseDeadline(java.util.Date responseDeadline) {
		_rdl.setResponseDeadline(responseDeadline);
	}

	/**
	* Returns the claims remarks of this r d l.
	*
	* @return the claims remarks of this r d l
	*/
	@Override
	public java.lang.String getClaimsRemarks() {
		return _rdl.getClaimsRemarks();
	}

	/**
	* Sets the claims remarks of this r d l.
	*
	* @param claimsRemarks the claims remarks of this r d l
	*/
	@Override
	public void setClaimsRemarks(java.lang.String claimsRemarks) {
		_rdl.setClaimsRemarks(claimsRemarks);
	}

	/**
	* Returns the alert before of this r d l.
	*
	* @return the alert before of this r d l
	*/
	@Override
	public long getAlertBefore() {
		return _rdl.getAlertBefore();
	}

	/**
	* Sets the alert before of this r d l.
	*
	* @param alertBefore the alert before of this r d l
	*/
	@Override
	public void setAlertBefore(long alertBefore) {
		_rdl.setAlertBefore(alertBefore);
	}

	@Override
	public boolean isNew() {
		return _rdl.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rdl.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rdl.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rdl.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rdl.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rdl.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rdl.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rdl.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rdl.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rdl.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rdl.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RDLWrapper((RDL)_rdl.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl) {
		return _rdl.compareTo(rdl);
	}

	@Override
	public int hashCode() {
		return _rdl.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.legalandcontract.model.RDL> toCacheModel() {
		return _rdl.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL toEscapedModel() {
		return new RDLWrapper(_rdl.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.RDL toUnescapedModel() {
		return new RDLWrapper(_rdl.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rdl.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rdl.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rdl.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RDLWrapper)) {
			return false;
		}

		RDLWrapper rdlWrapper = (RDLWrapper)obj;

		if (Validator.equals(_rdl, rdlWrapper._rdl)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _rdl.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RDL getWrappedRDL() {
		return _rdl;
	}

	@Override
	public RDL getWrappedModel() {
		return _rdl;
	}

	@Override
	public void resetOriginalValues() {
		_rdl.resetOriginalValues();
	}

	private RDL _rdl;
}