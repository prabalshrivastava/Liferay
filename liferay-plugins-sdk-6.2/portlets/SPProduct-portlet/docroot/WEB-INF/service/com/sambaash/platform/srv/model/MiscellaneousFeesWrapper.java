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
 * This class is a wrapper for {@link MiscellaneousFees}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see MiscellaneousFees
 * @generated
 */
public class MiscellaneousFeesWrapper implements MiscellaneousFees,
	ModelWrapper<MiscellaneousFees> {
	public MiscellaneousFeesWrapper(MiscellaneousFees miscellaneousFees) {
		_miscellaneousFees = miscellaneousFees;
	}

	@Override
	public Class<?> getModelClass() {
		return MiscellaneousFees.class;
	}

	@Override
	public String getModelClassName() {
		return MiscellaneousFees.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMiscFeesId", getSpMiscFeesId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("miscFeeType", getMiscFeeType());
		attributes.put("amount", getAmount());
		attributes.put("payable", getPayable());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMiscFeesId = (Long)attributes.get("spMiscFeesId");

		if (spMiscFeesId != null) {
			setSpMiscFeesId(spMiscFeesId);
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

		Long miscFeeType = (Long)attributes.get("miscFeeType");

		if (miscFeeType != null) {
			setMiscFeeType(miscFeeType);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long payable = (Long)attributes.get("payable");

		if (payable != null) {
			setPayable(payable);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	/**
	* Returns the primary key of this miscellaneous fees.
	*
	* @return the primary key of this miscellaneous fees
	*/
	@Override
	public long getPrimaryKey() {
		return _miscellaneousFees.getPrimaryKey();
	}

	/**
	* Sets the primary key of this miscellaneous fees.
	*
	* @param primaryKey the primary key of this miscellaneous fees
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_miscellaneousFees.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp misc fees ID of this miscellaneous fees.
	*
	* @return the sp misc fees ID of this miscellaneous fees
	*/
	@Override
	public long getSpMiscFeesId() {
		return _miscellaneousFees.getSpMiscFeesId();
	}

	/**
	* Sets the sp misc fees ID of this miscellaneous fees.
	*
	* @param spMiscFeesId the sp misc fees ID of this miscellaneous fees
	*/
	@Override
	public void setSpMiscFeesId(long spMiscFeesId) {
		_miscellaneousFees.setSpMiscFeesId(spMiscFeesId);
	}

	/**
	* Returns the group ID of this miscellaneous fees.
	*
	* @return the group ID of this miscellaneous fees
	*/
	@Override
	public long getGroupId() {
		return _miscellaneousFees.getGroupId();
	}

	/**
	* Sets the group ID of this miscellaneous fees.
	*
	* @param groupId the group ID of this miscellaneous fees
	*/
	@Override
	public void setGroupId(long groupId) {
		_miscellaneousFees.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this miscellaneous fees.
	*
	* @return the company ID of this miscellaneous fees
	*/
	@Override
	public long getCompanyId() {
		return _miscellaneousFees.getCompanyId();
	}

	/**
	* Sets the company ID of this miscellaneous fees.
	*
	* @param companyId the company ID of this miscellaneous fees
	*/
	@Override
	public void setCompanyId(long companyId) {
		_miscellaneousFees.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this miscellaneous fees.
	*
	* @return the user ID of this miscellaneous fees
	*/
	@Override
	public long getUserId() {
		return _miscellaneousFees.getUserId();
	}

	/**
	* Sets the user ID of this miscellaneous fees.
	*
	* @param userId the user ID of this miscellaneous fees
	*/
	@Override
	public void setUserId(long userId) {
		_miscellaneousFees.setUserId(userId);
	}

	/**
	* Returns the user uuid of this miscellaneous fees.
	*
	* @return the user uuid of this miscellaneous fees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _miscellaneousFees.getUserUuid();
	}

	/**
	* Sets the user uuid of this miscellaneous fees.
	*
	* @param userUuid the user uuid of this miscellaneous fees
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_miscellaneousFees.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this miscellaneous fees.
	*
	* @return the user name of this miscellaneous fees
	*/
	@Override
	public java.lang.String getUserName() {
		return _miscellaneousFees.getUserName();
	}

	/**
	* Sets the user name of this miscellaneous fees.
	*
	* @param userName the user name of this miscellaneous fees
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_miscellaneousFees.setUserName(userName);
	}

	/**
	* Returns the create date of this miscellaneous fees.
	*
	* @return the create date of this miscellaneous fees
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _miscellaneousFees.getCreateDate();
	}

	/**
	* Sets the create date of this miscellaneous fees.
	*
	* @param createDate the create date of this miscellaneous fees
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_miscellaneousFees.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this miscellaneous fees.
	*
	* @return the modified date of this miscellaneous fees
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _miscellaneousFees.getModifiedDate();
	}

	/**
	* Sets the modified date of this miscellaneous fees.
	*
	* @param modifiedDate the modified date of this miscellaneous fees
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_miscellaneousFees.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the misc fee type of this miscellaneous fees.
	*
	* @return the misc fee type of this miscellaneous fees
	*/
	@Override
	public long getMiscFeeType() {
		return _miscellaneousFees.getMiscFeeType();
	}

	/**
	* Sets the misc fee type of this miscellaneous fees.
	*
	* @param miscFeeType the misc fee type of this miscellaneous fees
	*/
	@Override
	public void setMiscFeeType(long miscFeeType) {
		_miscellaneousFees.setMiscFeeType(miscFeeType);
	}

	/**
	* Returns the amount of this miscellaneous fees.
	*
	* @return the amount of this miscellaneous fees
	*/
	@Override
	public double getAmount() {
		return _miscellaneousFees.getAmount();
	}

	/**
	* Sets the amount of this miscellaneous fees.
	*
	* @param amount the amount of this miscellaneous fees
	*/
	@Override
	public void setAmount(double amount) {
		_miscellaneousFees.setAmount(amount);
	}

	/**
	* Returns the payable of this miscellaneous fees.
	*
	* @return the payable of this miscellaneous fees
	*/
	@Override
	public long getPayable() {
		return _miscellaneousFees.getPayable();
	}

	/**
	* Sets the payable of this miscellaneous fees.
	*
	* @param payable the payable of this miscellaneous fees
	*/
	@Override
	public void setPayable(long payable) {
		_miscellaneousFees.setPayable(payable);
	}

	/**
	* Returns the sp course ID of this miscellaneous fees.
	*
	* @return the sp course ID of this miscellaneous fees
	*/
	@Override
	public long getSpCourseId() {
		return _miscellaneousFees.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this miscellaneous fees.
	*
	* @param spCourseId the sp course ID of this miscellaneous fees
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_miscellaneousFees.setSpCourseId(spCourseId);
	}

	@Override
	public boolean isNew() {
		return _miscellaneousFees.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_miscellaneousFees.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _miscellaneousFees.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_miscellaneousFees.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _miscellaneousFees.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _miscellaneousFees.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_miscellaneousFees.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _miscellaneousFees.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_miscellaneousFees.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_miscellaneousFees.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_miscellaneousFees.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MiscellaneousFeesWrapper((MiscellaneousFees)_miscellaneousFees.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.MiscellaneousFees miscellaneousFees) {
		return _miscellaneousFees.compareTo(miscellaneousFees);
	}

	@Override
	public int hashCode() {
		return _miscellaneousFees.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.MiscellaneousFees> toCacheModel() {
		return _miscellaneousFees.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.MiscellaneousFees toEscapedModel() {
		return new MiscellaneousFeesWrapper(_miscellaneousFees.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.MiscellaneousFees toUnescapedModel() {
		return new MiscellaneousFeesWrapper(_miscellaneousFees.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _miscellaneousFees.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _miscellaneousFees.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_miscellaneousFees.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MiscellaneousFeesWrapper)) {
			return false;
		}

		MiscellaneousFeesWrapper miscellaneousFeesWrapper = (MiscellaneousFeesWrapper)obj;

		if (Validator.equals(_miscellaneousFees,
					miscellaneousFeesWrapper._miscellaneousFees)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MiscellaneousFees getWrappedMiscellaneousFees() {
		return _miscellaneousFees;
	}

	@Override
	public MiscellaneousFees getWrappedModel() {
		return _miscellaneousFees;
	}

	@Override
	public void resetOriginalValues() {
		_miscellaneousFees.resetOriginalValues();
	}

	private MiscellaneousFees _miscellaneousFees;
}