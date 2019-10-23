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
 * This class is a wrapper for {@link FeeDetails}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see FeeDetails
 * @generated
 */
public class FeeDetailsWrapper implements FeeDetails, ModelWrapper<FeeDetails> {
	public FeeDetailsWrapper(FeeDetails feeDetails) {
		_feeDetails = feeDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return FeeDetails.class;
	}

	@Override
	public String getModelClassName() {
		return FeeDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFeeDetailsId", getSpFeeDetailsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("feeType", getFeeType());
		attributes.put("feeDesc", getFeeDesc());
		attributes.put("calculationBase", getCalculationBase());
		attributes.put("amount", getAmount());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("fundId", getFundId());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFeeDetailsId = (Long)attributes.get("spFeeDetailsId");

		if (spFeeDetailsId != null) {
			setSpFeeDetailsId(spFeeDetailsId);
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

		Long feeType = (Long)attributes.get("feeType");

		if (feeType != null) {
			setFeeType(feeType);
		}

		String feeDesc = (String)attributes.get("feeDesc");

		if (feeDesc != null) {
			setFeeDesc(feeDesc);
		}

		String calculationBase = (String)attributes.get("calculationBase");

		if (calculationBase != null) {
			setCalculationBase(calculationBase);
		}

		String amount = (String)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long displayOrder = (Long)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
		}

		Long fundId = (Long)attributes.get("fundId");

		if (fundId != null) {
			setFundId(fundId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	/**
	* Returns the primary key of this fee details.
	*
	* @return the primary key of this fee details
	*/
	@Override
	public long getPrimaryKey() {
		return _feeDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fee details.
	*
	* @param primaryKey the primary key of this fee details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_feeDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp fee details ID of this fee details.
	*
	* @return the sp fee details ID of this fee details
	*/
	@Override
	public long getSpFeeDetailsId() {
		return _feeDetails.getSpFeeDetailsId();
	}

	/**
	* Sets the sp fee details ID of this fee details.
	*
	* @param spFeeDetailsId the sp fee details ID of this fee details
	*/
	@Override
	public void setSpFeeDetailsId(long spFeeDetailsId) {
		_feeDetails.setSpFeeDetailsId(spFeeDetailsId);
	}

	/**
	* Returns the group ID of this fee details.
	*
	* @return the group ID of this fee details
	*/
	@Override
	public long getGroupId() {
		return _feeDetails.getGroupId();
	}

	/**
	* Sets the group ID of this fee details.
	*
	* @param groupId the group ID of this fee details
	*/
	@Override
	public void setGroupId(long groupId) {
		_feeDetails.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this fee details.
	*
	* @return the company ID of this fee details
	*/
	@Override
	public long getCompanyId() {
		return _feeDetails.getCompanyId();
	}

	/**
	* Sets the company ID of this fee details.
	*
	* @param companyId the company ID of this fee details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_feeDetails.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this fee details.
	*
	* @return the user ID of this fee details
	*/
	@Override
	public long getUserId() {
		return _feeDetails.getUserId();
	}

	/**
	* Sets the user ID of this fee details.
	*
	* @param userId the user ID of this fee details
	*/
	@Override
	public void setUserId(long userId) {
		_feeDetails.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fee details.
	*
	* @return the user uuid of this fee details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feeDetails.getUserUuid();
	}

	/**
	* Sets the user uuid of this fee details.
	*
	* @param userUuid the user uuid of this fee details
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_feeDetails.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fee details.
	*
	* @return the user name of this fee details
	*/
	@Override
	public java.lang.String getUserName() {
		return _feeDetails.getUserName();
	}

	/**
	* Sets the user name of this fee details.
	*
	* @param userName the user name of this fee details
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_feeDetails.setUserName(userName);
	}

	/**
	* Returns the create date of this fee details.
	*
	* @return the create date of this fee details
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _feeDetails.getCreateDate();
	}

	/**
	* Sets the create date of this fee details.
	*
	* @param createDate the create date of this fee details
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_feeDetails.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this fee details.
	*
	* @return the modified date of this fee details
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _feeDetails.getModifiedDate();
	}

	/**
	* Sets the modified date of this fee details.
	*
	* @param modifiedDate the modified date of this fee details
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_feeDetails.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fee type of this fee details.
	*
	* @return the fee type of this fee details
	*/
	@Override
	public long getFeeType() {
		return _feeDetails.getFeeType();
	}

	/**
	* Sets the fee type of this fee details.
	*
	* @param feeType the fee type of this fee details
	*/
	@Override
	public void setFeeType(long feeType) {
		_feeDetails.setFeeType(feeType);
	}

	/**
	* Returns the fee desc of this fee details.
	*
	* @return the fee desc of this fee details
	*/
	@Override
	public java.lang.String getFeeDesc() {
		return _feeDetails.getFeeDesc();
	}

	/**
	* Sets the fee desc of this fee details.
	*
	* @param feeDesc the fee desc of this fee details
	*/
	@Override
	public void setFeeDesc(java.lang.String feeDesc) {
		_feeDetails.setFeeDesc(feeDesc);
	}

	/**
	* Returns the calculation base of this fee details.
	*
	* @return the calculation base of this fee details
	*/
	@Override
	public java.lang.String getCalculationBase() {
		return _feeDetails.getCalculationBase();
	}

	/**
	* Sets the calculation base of this fee details.
	*
	* @param calculationBase the calculation base of this fee details
	*/
	@Override
	public void setCalculationBase(java.lang.String calculationBase) {
		_feeDetails.setCalculationBase(calculationBase);
	}

	/**
	* Returns the amount of this fee details.
	*
	* @return the amount of this fee details
	*/
	@Override
	public java.lang.String getAmount() {
		return _feeDetails.getAmount();
	}

	/**
	* Sets the amount of this fee details.
	*
	* @param amount the amount of this fee details
	*/
	@Override
	public void setAmount(java.lang.String amount) {
		_feeDetails.setAmount(amount);
	}

	/**
	* Returns the display order of this fee details.
	*
	* @return the display order of this fee details
	*/
	@Override
	public long getDisplayOrder() {
		return _feeDetails.getDisplayOrder();
	}

	/**
	* Sets the display order of this fee details.
	*
	* @param displayOrder the display order of this fee details
	*/
	@Override
	public void setDisplayOrder(long displayOrder) {
		_feeDetails.setDisplayOrder(displayOrder);
	}

	/**
	* Returns the fund ID of this fee details.
	*
	* @return the fund ID of this fee details
	*/
	@Override
	public long getFundId() {
		return _feeDetails.getFundId();
	}

	/**
	* Sets the fund ID of this fee details.
	*
	* @param fundId the fund ID of this fee details
	*/
	@Override
	public void setFundId(long fundId) {
		_feeDetails.setFundId(fundId);
	}

	/**
	* Returns the sp course ID of this fee details.
	*
	* @return the sp course ID of this fee details
	*/
	@Override
	public long getSpCourseId() {
		return _feeDetails.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this fee details.
	*
	* @param spCourseId the sp course ID of this fee details
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_feeDetails.setSpCourseId(spCourseId);
	}

	@Override
	public boolean isNew() {
		return _feeDetails.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_feeDetails.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _feeDetails.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feeDetails.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _feeDetails.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _feeDetails.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_feeDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _feeDetails.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_feeDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_feeDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_feeDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FeeDetailsWrapper((FeeDetails)_feeDetails.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.FeeDetails feeDetails) {
		return _feeDetails.compareTo(feeDetails);
	}

	@Override
	public int hashCode() {
		return _feeDetails.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.FeeDetails> toCacheModel() {
		return _feeDetails.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.FeeDetails toEscapedModel() {
		return new FeeDetailsWrapper(_feeDetails.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.FeeDetails toUnescapedModel() {
		return new FeeDetailsWrapper(_feeDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _feeDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _feeDetails.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_feeDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeeDetailsWrapper)) {
			return false;
		}

		FeeDetailsWrapper feeDetailsWrapper = (FeeDetailsWrapper)obj;

		if (Validator.equals(_feeDetails, feeDetailsWrapper._feeDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FeeDetails getWrappedFeeDetails() {
		return _feeDetails;
	}

	@Override
	public FeeDetails getWrappedModel() {
		return _feeDetails;
	}

	@Override
	public void resetOriginalValues() {
		_feeDetails.resetOriginalValues();
	}

	private FeeDetails _feeDetails;
}