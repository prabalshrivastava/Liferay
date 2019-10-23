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
 * This class is a wrapper for {@link FeeType}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see FeeType
 * @generated
 */
public class FeeTypeWrapper implements FeeType, ModelWrapper<FeeType> {
	public FeeTypeWrapper(FeeType feeType) {
		_feeType = feeType;
	}

	@Override
	public Class<?> getModelClass() {
		return FeeType.class;
	}

	@Override
	public String getModelClassName() {
		return FeeType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFeeTypeId", getSpFeeTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("feeType", getFeeType());
		attributes.put("feeTypeName", getFeeTypeName());
		attributes.put("feeTypeDesc", getFeeTypeDesc());
		attributes.put("misc", getMisc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFeeTypeId = (Long)attributes.get("spFeeTypeId");

		if (spFeeTypeId != null) {
			setSpFeeTypeId(spFeeTypeId);
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

		String feeType = (String)attributes.get("feeType");

		if (feeType != null) {
			setFeeType(feeType);
		}

		String feeTypeName = (String)attributes.get("feeTypeName");

		if (feeTypeName != null) {
			setFeeTypeName(feeTypeName);
		}

		String feeTypeDesc = (String)attributes.get("feeTypeDesc");

		if (feeTypeDesc != null) {
			setFeeTypeDesc(feeTypeDesc);
		}

		Boolean misc = (Boolean)attributes.get("misc");

		if (misc != null) {
			setMisc(misc);
		}
	}

	/**
	* Returns the primary key of this fee type.
	*
	* @return the primary key of this fee type
	*/
	@Override
	public long getPrimaryKey() {
		return _feeType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fee type.
	*
	* @param primaryKey the primary key of this fee type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_feeType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp fee type ID of this fee type.
	*
	* @return the sp fee type ID of this fee type
	*/
	@Override
	public long getSpFeeTypeId() {
		return _feeType.getSpFeeTypeId();
	}

	/**
	* Sets the sp fee type ID of this fee type.
	*
	* @param spFeeTypeId the sp fee type ID of this fee type
	*/
	@Override
	public void setSpFeeTypeId(long spFeeTypeId) {
		_feeType.setSpFeeTypeId(spFeeTypeId);
	}

	/**
	* Returns the group ID of this fee type.
	*
	* @return the group ID of this fee type
	*/
	@Override
	public long getGroupId() {
		return _feeType.getGroupId();
	}

	/**
	* Sets the group ID of this fee type.
	*
	* @param groupId the group ID of this fee type
	*/
	@Override
	public void setGroupId(long groupId) {
		_feeType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this fee type.
	*
	* @return the company ID of this fee type
	*/
	@Override
	public long getCompanyId() {
		return _feeType.getCompanyId();
	}

	/**
	* Sets the company ID of this fee type.
	*
	* @param companyId the company ID of this fee type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_feeType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this fee type.
	*
	* @return the user ID of this fee type
	*/
	@Override
	public long getUserId() {
		return _feeType.getUserId();
	}

	/**
	* Sets the user ID of this fee type.
	*
	* @param userId the user ID of this fee type
	*/
	@Override
	public void setUserId(long userId) {
		_feeType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fee type.
	*
	* @return the user uuid of this fee type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feeType.getUserUuid();
	}

	/**
	* Sets the user uuid of this fee type.
	*
	* @param userUuid the user uuid of this fee type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_feeType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fee type.
	*
	* @return the user name of this fee type
	*/
	@Override
	public java.lang.String getUserName() {
		return _feeType.getUserName();
	}

	/**
	* Sets the user name of this fee type.
	*
	* @param userName the user name of this fee type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_feeType.setUserName(userName);
	}

	/**
	* Returns the create date of this fee type.
	*
	* @return the create date of this fee type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _feeType.getCreateDate();
	}

	/**
	* Sets the create date of this fee type.
	*
	* @param createDate the create date of this fee type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_feeType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this fee type.
	*
	* @return the modified date of this fee type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _feeType.getModifiedDate();
	}

	/**
	* Sets the modified date of this fee type.
	*
	* @param modifiedDate the modified date of this fee type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_feeType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fee type of this fee type.
	*
	* @return the fee type of this fee type
	*/
	@Override
	public java.lang.String getFeeType() {
		return _feeType.getFeeType();
	}

	/**
	* Sets the fee type of this fee type.
	*
	* @param feeType the fee type of this fee type
	*/
	@Override
	public void setFeeType(java.lang.String feeType) {
		_feeType.setFeeType(feeType);
	}

	/**
	* Returns the fee type name of this fee type.
	*
	* @return the fee type name of this fee type
	*/
	@Override
	public java.lang.String getFeeTypeName() {
		return _feeType.getFeeTypeName();
	}

	/**
	* Sets the fee type name of this fee type.
	*
	* @param feeTypeName the fee type name of this fee type
	*/
	@Override
	public void setFeeTypeName(java.lang.String feeTypeName) {
		_feeType.setFeeTypeName(feeTypeName);
	}

	/**
	* Returns the fee type desc of this fee type.
	*
	* @return the fee type desc of this fee type
	*/
	@Override
	public java.lang.String getFeeTypeDesc() {
		return _feeType.getFeeTypeDesc();
	}

	/**
	* Sets the fee type desc of this fee type.
	*
	* @param feeTypeDesc the fee type desc of this fee type
	*/
	@Override
	public void setFeeTypeDesc(java.lang.String feeTypeDesc) {
		_feeType.setFeeTypeDesc(feeTypeDesc);
	}

	/**
	* Returns the misc of this fee type.
	*
	* @return the misc of this fee type
	*/
	@Override
	public boolean getMisc() {
		return _feeType.getMisc();
	}

	/**
	* Returns <code>true</code> if this fee type is misc.
	*
	* @return <code>true</code> if this fee type is misc; <code>false</code> otherwise
	*/
	@Override
	public boolean isMisc() {
		return _feeType.isMisc();
	}

	/**
	* Sets whether this fee type is misc.
	*
	* @param misc the misc of this fee type
	*/
	@Override
	public void setMisc(boolean misc) {
		_feeType.setMisc(misc);
	}

	@Override
	public boolean isNew() {
		return _feeType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_feeType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _feeType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feeType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _feeType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _feeType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_feeType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _feeType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_feeType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_feeType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_feeType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FeeTypeWrapper((FeeType)_feeType.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.FeeType feeType) {
		return _feeType.compareTo(feeType);
	}

	@Override
	public int hashCode() {
		return _feeType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.FeeType> toCacheModel() {
		return _feeType.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.FeeType toEscapedModel() {
		return new FeeTypeWrapper(_feeType.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.FeeType toUnescapedModel() {
		return new FeeTypeWrapper(_feeType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _feeType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _feeType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_feeType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeeTypeWrapper)) {
			return false;
		}

		FeeTypeWrapper feeTypeWrapper = (FeeTypeWrapper)obj;

		if (Validator.equals(_feeType, feeTypeWrapper._feeType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FeeType getWrappedFeeType() {
		return _feeType;
	}

	@Override
	public FeeType getWrappedModel() {
		return _feeType;
	}

	@Override
	public void resetOriginalValues() {
		_feeType.resetOriginalValues();
	}

	private FeeType _feeType;
}