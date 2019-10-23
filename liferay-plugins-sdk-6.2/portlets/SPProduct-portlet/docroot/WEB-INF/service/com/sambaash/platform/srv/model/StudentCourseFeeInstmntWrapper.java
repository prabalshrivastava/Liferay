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
 * This class is a wrapper for {@link StudentCourseFeeInstmnt}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeeInstmnt
 * @generated
 */
public class StudentCourseFeeInstmntWrapper implements StudentCourseFeeInstmnt,
	ModelWrapper<StudentCourseFeeInstmnt> {
	public StudentCourseFeeInstmntWrapper(
		StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		_studentCourseFeeInstmnt = studentCourseFeeInstmnt;
	}

	@Override
	public Class<?> getModelClass() {
		return StudentCourseFeeInstmnt.class;
	}

	@Override
	public String getModelClassName() {
		return StudentCourseFeeInstmnt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudentCourseFeeInstmntId",
			getSpStudentCourseFeeInstmntId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessStateId", getSpPEProcessStateId());
		attributes.put("insmntNo", getInsmntNo());
		attributes.put("amount", getAmount());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudentCourseFeeInstmntId = (Long)attributes.get(
				"spStudentCourseFeeInstmntId");

		if (spStudentCourseFeeInstmntId != null) {
			setSpStudentCourseFeeInstmntId(spStudentCourseFeeInstmntId);
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

		Integer insmntNo = (Integer)attributes.get("insmntNo");

		if (insmntNo != null) {
			setInsmntNo(insmntNo);
		}

		String amount = (String)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	/**
	* Returns the primary key of this student course fee instmnt.
	*
	* @return the primary key of this student course fee instmnt
	*/
	@Override
	public long getPrimaryKey() {
		return _studentCourseFeeInstmnt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student course fee instmnt.
	*
	* @param primaryKey the primary key of this student course fee instmnt
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_studentCourseFeeInstmnt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp student course fee instmnt ID of this student course fee instmnt.
	*
	* @return the sp student course fee instmnt ID of this student course fee instmnt
	*/
	@Override
	public long getSpStudentCourseFeeInstmntId() {
		return _studentCourseFeeInstmnt.getSpStudentCourseFeeInstmntId();
	}

	/**
	* Sets the sp student course fee instmnt ID of this student course fee instmnt.
	*
	* @param spStudentCourseFeeInstmntId the sp student course fee instmnt ID of this student course fee instmnt
	*/
	@Override
	public void setSpStudentCourseFeeInstmntId(long spStudentCourseFeeInstmntId) {
		_studentCourseFeeInstmnt.setSpStudentCourseFeeInstmntId(spStudentCourseFeeInstmntId);
	}

	/**
	* Returns the group ID of this student course fee instmnt.
	*
	* @return the group ID of this student course fee instmnt
	*/
	@Override
	public long getGroupId() {
		return _studentCourseFeeInstmnt.getGroupId();
	}

	/**
	* Sets the group ID of this student course fee instmnt.
	*
	* @param groupId the group ID of this student course fee instmnt
	*/
	@Override
	public void setGroupId(long groupId) {
		_studentCourseFeeInstmnt.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this student course fee instmnt.
	*
	* @return the company ID of this student course fee instmnt
	*/
	@Override
	public long getCompanyId() {
		return _studentCourseFeeInstmnt.getCompanyId();
	}

	/**
	* Sets the company ID of this student course fee instmnt.
	*
	* @param companyId the company ID of this student course fee instmnt
	*/
	@Override
	public void setCompanyId(long companyId) {
		_studentCourseFeeInstmnt.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this student course fee instmnt.
	*
	* @return the user ID of this student course fee instmnt
	*/
	@Override
	public long getUserId() {
		return _studentCourseFeeInstmnt.getUserId();
	}

	/**
	* Sets the user ID of this student course fee instmnt.
	*
	* @param userId the user ID of this student course fee instmnt
	*/
	@Override
	public void setUserId(long userId) {
		_studentCourseFeeInstmnt.setUserId(userId);
	}

	/**
	* Returns the user uuid of this student course fee instmnt.
	*
	* @return the user uuid of this student course fee instmnt
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmnt.getUserUuid();
	}

	/**
	* Sets the user uuid of this student course fee instmnt.
	*
	* @param userUuid the user uuid of this student course fee instmnt
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_studentCourseFeeInstmnt.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this student course fee instmnt.
	*
	* @return the user name of this student course fee instmnt
	*/
	@Override
	public java.lang.String getUserName() {
		return _studentCourseFeeInstmnt.getUserName();
	}

	/**
	* Sets the user name of this student course fee instmnt.
	*
	* @param userName the user name of this student course fee instmnt
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_studentCourseFeeInstmnt.setUserName(userName);
	}

	/**
	* Returns the create date of this student course fee instmnt.
	*
	* @return the create date of this student course fee instmnt
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _studentCourseFeeInstmnt.getCreateDate();
	}

	/**
	* Sets the create date of this student course fee instmnt.
	*
	* @param createDate the create date of this student course fee instmnt
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_studentCourseFeeInstmnt.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this student course fee instmnt.
	*
	* @return the modified date of this student course fee instmnt
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _studentCourseFeeInstmnt.getModifiedDate();
	}

	/**
	* Sets the modified date of this student course fee instmnt.
	*
	* @param modifiedDate the modified date of this student course fee instmnt
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_studentCourseFeeInstmnt.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp p e process state ID of this student course fee instmnt.
	*
	* @return the sp p e process state ID of this student course fee instmnt
	*/
	@Override
	public long getSpPEProcessStateId() {
		return _studentCourseFeeInstmnt.getSpPEProcessStateId();
	}

	/**
	* Sets the sp p e process state ID of this student course fee instmnt.
	*
	* @param spPEProcessStateId the sp p e process state ID of this student course fee instmnt
	*/
	@Override
	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_studentCourseFeeInstmnt.setSpPEProcessStateId(spPEProcessStateId);
	}

	/**
	* Returns the insmnt no of this student course fee instmnt.
	*
	* @return the insmnt no of this student course fee instmnt
	*/
	@Override
	public int getInsmntNo() {
		return _studentCourseFeeInstmnt.getInsmntNo();
	}

	/**
	* Sets the insmnt no of this student course fee instmnt.
	*
	* @param insmntNo the insmnt no of this student course fee instmnt
	*/
	@Override
	public void setInsmntNo(int insmntNo) {
		_studentCourseFeeInstmnt.setInsmntNo(insmntNo);
	}

	/**
	* Returns the amount of this student course fee instmnt.
	*
	* @return the amount of this student course fee instmnt
	*/
	@Override
	public java.lang.String getAmount() {
		return _studentCourseFeeInstmnt.getAmount();
	}

	/**
	* Sets the amount of this student course fee instmnt.
	*
	* @param amount the amount of this student course fee instmnt
	*/
	@Override
	public void setAmount(java.lang.String amount) {
		_studentCourseFeeInstmnt.setAmount(amount);
	}

	/**
	* Returns the date of this student course fee instmnt.
	*
	* @return the date of this student course fee instmnt
	*/
	@Override
	public java.util.Date getDate() {
		return _studentCourseFeeInstmnt.getDate();
	}

	/**
	* Sets the date of this student course fee instmnt.
	*
	* @param date the date of this student course fee instmnt
	*/
	@Override
	public void setDate(java.util.Date date) {
		_studentCourseFeeInstmnt.setDate(date);
	}

	@Override
	public boolean isNew() {
		return _studentCourseFeeInstmnt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_studentCourseFeeInstmnt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _studentCourseFeeInstmnt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_studentCourseFeeInstmnt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _studentCourseFeeInstmnt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _studentCourseFeeInstmnt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_studentCourseFeeInstmnt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _studentCourseFeeInstmnt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_studentCourseFeeInstmnt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_studentCourseFeeInstmnt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_studentCourseFeeInstmnt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentCourseFeeInstmntWrapper((StudentCourseFeeInstmnt)_studentCourseFeeInstmnt.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		return _studentCourseFeeInstmnt.compareTo(studentCourseFeeInstmnt);
	}

	@Override
	public int hashCode() {
		return _studentCourseFeeInstmnt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> toCacheModel() {
		return _studentCourseFeeInstmnt.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt toEscapedModel() {
		return new StudentCourseFeeInstmntWrapper(_studentCourseFeeInstmnt.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt toUnescapedModel() {
		return new StudentCourseFeeInstmntWrapper(_studentCourseFeeInstmnt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _studentCourseFeeInstmnt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _studentCourseFeeInstmnt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_studentCourseFeeInstmnt.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentCourseFeeInstmntWrapper)) {
			return false;
		}

		StudentCourseFeeInstmntWrapper studentCourseFeeInstmntWrapper = (StudentCourseFeeInstmntWrapper)obj;

		if (Validator.equals(_studentCourseFeeInstmnt,
					studentCourseFeeInstmntWrapper._studentCourseFeeInstmnt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StudentCourseFeeInstmnt getWrappedStudentCourseFeeInstmnt() {
		return _studentCourseFeeInstmnt;
	}

	@Override
	public StudentCourseFeeInstmnt getWrappedModel() {
		return _studentCourseFeeInstmnt;
	}

	@Override
	public void resetOriginalValues() {
		_studentCourseFeeInstmnt.resetOriginalValues();
	}

	private StudentCourseFeeInstmnt _studentCourseFeeInstmnt;
}