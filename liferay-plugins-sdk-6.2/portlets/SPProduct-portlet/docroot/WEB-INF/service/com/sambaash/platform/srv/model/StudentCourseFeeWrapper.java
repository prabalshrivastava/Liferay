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
 * This class is a wrapper for {@link StudentCourseFee}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudentCourseFee
 * @generated
 */
public class StudentCourseFeeWrapper implements StudentCourseFee,
	ModelWrapper<StudentCourseFee> {
	public StudentCourseFeeWrapper(StudentCourseFee studentCourseFee) {
		_studentCourseFee = studentCourseFee;
	}

	@Override
	public Class<?> getModelClass() {
		return StudentCourseFee.class;
	}

	@Override
	public String getModelClassName() {
		return StudentCourseFee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudentCourseFeeId", getSpStudentCourseFeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessStateId", getSpPEProcessStateId());
		attributes.put("feeType", getFeeType());
		attributes.put("amount", getAmount());
		attributes.put("order", getOrder());
		attributes.put("formula", getFormula());
		attributes.put("label", getLabel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudentCourseFeeId = (Long)attributes.get("spStudentCourseFeeId");

		if (spStudentCourseFeeId != null) {
			setSpStudentCourseFeeId(spStudentCourseFeeId);
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

		Long spPEProcessStateId = (Long)attributes.get("spPEProcessStateId");

		if (spPEProcessStateId != null) {
			setSpPEProcessStateId(spPEProcessStateId);
		}

		String feeType = (String)attributes.get("feeType");

		if (feeType != null) {
			setFeeType(feeType);
		}

		String amount = (String)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String formula = (String)attributes.get("formula");

		if (formula != null) {
			setFormula(formula);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}
	}

	/**
	* Returns the primary key of this student course fee.
	*
	* @return the primary key of this student course fee
	*/
	@Override
	public long getPrimaryKey() {
		return _studentCourseFee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student course fee.
	*
	* @param primaryKey the primary key of this student course fee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_studentCourseFee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp student course fee ID of this student course fee.
	*
	* @return the sp student course fee ID of this student course fee
	*/
	@Override
	public long getSpStudentCourseFeeId() {
		return _studentCourseFee.getSpStudentCourseFeeId();
	}

	/**
	* Sets the sp student course fee ID of this student course fee.
	*
	* @param spStudentCourseFeeId the sp student course fee ID of this student course fee
	*/
	@Override
	public void setSpStudentCourseFeeId(long spStudentCourseFeeId) {
		_studentCourseFee.setSpStudentCourseFeeId(spStudentCourseFeeId);
	}

	/**
	* Returns the group ID of this student course fee.
	*
	* @return the group ID of this student course fee
	*/
	@Override
	public long getGroupId() {
		return _studentCourseFee.getGroupId();
	}

	/**
	* Sets the group ID of this student course fee.
	*
	* @param groupId the group ID of this student course fee
	*/
	@Override
	public void setGroupId(long groupId) {
		_studentCourseFee.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this student course fee.
	*
	* @return the company ID of this student course fee
	*/
	@Override
	public long getCompanyId() {
		return _studentCourseFee.getCompanyId();
	}

	/**
	* Sets the company ID of this student course fee.
	*
	* @param companyId the company ID of this student course fee
	*/
	@Override
	public void setCompanyId(long companyId) {
		_studentCourseFee.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this student course fee.
	*
	* @return the user ID of this student course fee
	*/
	@Override
	public long getUserId() {
		return _studentCourseFee.getUserId();
	}

	/**
	* Sets the user ID of this student course fee.
	*
	* @param userId the user ID of this student course fee
	*/
	@Override
	public void setUserId(long userId) {
		_studentCourseFee.setUserId(userId);
	}

	/**
	* Returns the user uuid of this student course fee.
	*
	* @return the user uuid of this student course fee
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFee.getUserUuid();
	}

	/**
	* Sets the user uuid of this student course fee.
	*
	* @param userUuid the user uuid of this student course fee
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_studentCourseFee.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this student course fee.
	*
	* @return the user name of this student course fee
	*/
	@Override
	public java.lang.String getUserName() {
		return _studentCourseFee.getUserName();
	}

	/**
	* Sets the user name of this student course fee.
	*
	* @param userName the user name of this student course fee
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_studentCourseFee.setUserName(userName);
	}

	/**
	* Returns the create date of this student course fee.
	*
	* @return the create date of this student course fee
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _studentCourseFee.getCreateDate();
	}

	/**
	* Sets the create date of this student course fee.
	*
	* @param createDate the create date of this student course fee
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_studentCourseFee.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this student course fee.
	*
	* @return the modified date of this student course fee
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _studentCourseFee.getModifiedDate();
	}

	/**
	* Sets the modified date of this student course fee.
	*
	* @param modifiedDate the modified date of this student course fee
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_studentCourseFee.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp p e process state ID of this student course fee.
	*
	* @return the sp p e process state ID of this student course fee
	*/
	@Override
	public long getSpPEProcessStateId() {
		return _studentCourseFee.getSpPEProcessStateId();
	}

	/**
	* Sets the sp p e process state ID of this student course fee.
	*
	* @param spPEProcessStateId the sp p e process state ID of this student course fee
	*/
	@Override
	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_studentCourseFee.setSpPEProcessStateId(spPEProcessStateId);
	}

	/**
	* Returns the fee type of this student course fee.
	*
	* @return the fee type of this student course fee
	*/
	@Override
	public java.lang.String getFeeType() {
		return _studentCourseFee.getFeeType();
	}

	/**
	* Sets the fee type of this student course fee.
	*
	* @param feeType the fee type of this student course fee
	*/
	@Override
	public void setFeeType(java.lang.String feeType) {
		_studentCourseFee.setFeeType(feeType);
	}

	/**
	* Returns the amount of this student course fee.
	*
	* @return the amount of this student course fee
	*/
	@Override
	public java.lang.String getAmount() {
		return _studentCourseFee.getAmount();
	}

	/**
	* Sets the amount of this student course fee.
	*
	* @param amount the amount of this student course fee
	*/
	@Override
	public void setAmount(java.lang.String amount) {
		_studentCourseFee.setAmount(amount);
	}

	/**
	* Returns the order of this student course fee.
	*
	* @return the order of this student course fee
	*/
	@Override
	public int getOrder() {
		return _studentCourseFee.getOrder();
	}

	/**
	* Sets the order of this student course fee.
	*
	* @param order the order of this student course fee
	*/
	@Override
	public void setOrder(int order) {
		_studentCourseFee.setOrder(order);
	}

	/**
	* Returns the formula of this student course fee.
	*
	* @return the formula of this student course fee
	*/
	@Override
	public java.lang.String getFormula() {
		return _studentCourseFee.getFormula();
	}

	/**
	* Sets the formula of this student course fee.
	*
	* @param formula the formula of this student course fee
	*/
	@Override
	public void setFormula(java.lang.String formula) {
		_studentCourseFee.setFormula(formula);
	}

	/**
	* Returns the label of this student course fee.
	*
	* @return the label of this student course fee
	*/
	@Override
	public java.lang.String getLabel() {
		return _studentCourseFee.getLabel();
	}

	/**
	* Sets the label of this student course fee.
	*
	* @param label the label of this student course fee
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_studentCourseFee.setLabel(label);
	}

	@Override
	public boolean isNew() {
		return _studentCourseFee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_studentCourseFee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _studentCourseFee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_studentCourseFee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _studentCourseFee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _studentCourseFee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_studentCourseFee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _studentCourseFee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_studentCourseFee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_studentCourseFee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_studentCourseFee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentCourseFeeWrapper((StudentCourseFee)_studentCourseFee.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.StudentCourseFee studentCourseFee) {
		return _studentCourseFee.compareTo(studentCourseFee);
	}

	@Override
	public int hashCode() {
		return _studentCourseFee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.StudentCourseFee> toCacheModel() {
		return _studentCourseFee.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee toEscapedModel() {
		return new StudentCourseFeeWrapper(_studentCourseFee.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee toUnescapedModel() {
		return new StudentCourseFeeWrapper(_studentCourseFee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _studentCourseFee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _studentCourseFee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_studentCourseFee.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentCourseFeeWrapper)) {
			return false;
		}

		StudentCourseFeeWrapper studentCourseFeeWrapper = (StudentCourseFeeWrapper)obj;

		if (Validator.equals(_studentCourseFee,
					studentCourseFeeWrapper._studentCourseFee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StudentCourseFee getWrappedStudentCourseFee() {
		return _studentCourseFee;
	}

	@Override
	public StudentCourseFee getWrappedModel() {
		return _studentCourseFee;
	}

	@Override
	public void resetOriginalValues() {
		_studentCourseFee.resetOriginalValues();
	}

	private StudentCourseFee _studentCourseFee;
}