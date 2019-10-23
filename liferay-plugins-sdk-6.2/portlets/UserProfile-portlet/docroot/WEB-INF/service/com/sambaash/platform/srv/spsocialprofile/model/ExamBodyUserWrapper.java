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

package com.sambaash.platform.srv.spsocialprofile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ExamBodyUser}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ExamBodyUser
 * @generated
 */
public class ExamBodyUserWrapper implements ExamBodyUser,
	ModelWrapper<ExamBodyUser> {
	public ExamBodyUserWrapper(ExamBodyUser examBodyUser) {
		_examBodyUser = examBodyUser;
	}

	@Override
	public Class<?> getModelClass() {
		return ExamBodyUser.class;
	}

	@Override
	public String getModelClassName() {
		return ExamBodyUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("examBodyUserId", getExamBodyUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("examBody", getExamBody());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long examBodyUserId = (Long)attributes.get("examBodyUserId");

		if (examBodyUserId != null) {
			setExamBodyUserId(examBodyUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String examBody = (String)attributes.get("examBody");

		if (examBody != null) {
			setExamBody(examBody);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this exam body user.
	*
	* @return the primary key of this exam body user
	*/
	@Override
	public long getPrimaryKey() {
		return _examBodyUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this exam body user.
	*
	* @param primaryKey the primary key of this exam body user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_examBodyUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the exam body user ID of this exam body user.
	*
	* @return the exam body user ID of this exam body user
	*/
	@Override
	public long getExamBodyUserId() {
		return _examBodyUser.getExamBodyUserId();
	}

	/**
	* Sets the exam body user ID of this exam body user.
	*
	* @param examBodyUserId the exam body user ID of this exam body user
	*/
	@Override
	public void setExamBodyUserId(long examBodyUserId) {
		_examBodyUser.setExamBodyUserId(examBodyUserId);
	}

	/**
	* Returns the exam body user uuid of this exam body user.
	*
	* @return the exam body user uuid of this exam body user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getExamBodyUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _examBodyUser.getExamBodyUserUuid();
	}

	/**
	* Sets the exam body user uuid of this exam body user.
	*
	* @param examBodyUserUuid the exam body user uuid of this exam body user
	*/
	@Override
	public void setExamBodyUserUuid(java.lang.String examBodyUserUuid) {
		_examBodyUser.setExamBodyUserUuid(examBodyUserUuid);
	}

	/**
	* Returns the group ID of this exam body user.
	*
	* @return the group ID of this exam body user
	*/
	@Override
	public long getGroupId() {
		return _examBodyUser.getGroupId();
	}

	/**
	* Sets the group ID of this exam body user.
	*
	* @param groupId the group ID of this exam body user
	*/
	@Override
	public void setGroupId(long groupId) {
		_examBodyUser.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this exam body user.
	*
	* @return the company ID of this exam body user
	*/
	@Override
	public long getCompanyId() {
		return _examBodyUser.getCompanyId();
	}

	/**
	* Sets the company ID of this exam body user.
	*
	* @param companyId the company ID of this exam body user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_examBodyUser.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this exam body user.
	*
	* @return the create date of this exam body user
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _examBodyUser.getCreateDate();
	}

	/**
	* Sets the create date of this exam body user.
	*
	* @param createDate the create date of this exam body user
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_examBodyUser.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this exam body user.
	*
	* @return the modified date of this exam body user
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _examBodyUser.getModifiedDate();
	}

	/**
	* Sets the modified date of this exam body user.
	*
	* @param modifiedDate the modified date of this exam body user
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_examBodyUser.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the email address of this exam body user.
	*
	* @return the email address of this exam body user
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _examBodyUser.getEmailAddress();
	}

	/**
	* Sets the email address of this exam body user.
	*
	* @param emailAddress the email address of this exam body user
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_examBodyUser.setEmailAddress(emailAddress);
	}

	/**
	* Returns the exam body of this exam body user.
	*
	* @return the exam body of this exam body user
	*/
	@Override
	public java.lang.String getExamBody() {
		return _examBodyUser.getExamBody();
	}

	/**
	* Sets the exam body of this exam body user.
	*
	* @param examBody the exam body of this exam body user
	*/
	@Override
	public void setExamBody(java.lang.String examBody) {
		_examBodyUser.setExamBody(examBody);
	}

	/**
	* Returns the active of this exam body user.
	*
	* @return the active of this exam body user
	*/
	@Override
	public boolean getActive() {
		return _examBodyUser.getActive();
	}

	/**
	* Returns <code>true</code> if this exam body user is active.
	*
	* @return <code>true</code> if this exam body user is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _examBodyUser.isActive();
	}

	/**
	* Sets whether this exam body user is active.
	*
	* @param active the active of this exam body user
	*/
	@Override
	public void setActive(boolean active) {
		_examBodyUser.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _examBodyUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_examBodyUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _examBodyUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_examBodyUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _examBodyUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _examBodyUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_examBodyUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _examBodyUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_examBodyUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_examBodyUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_examBodyUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExamBodyUserWrapper((ExamBodyUser)_examBodyUser.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser examBodyUser) {
		return _examBodyUser.compareTo(examBodyUser);
	}

	@Override
	public int hashCode() {
		return _examBodyUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser> toCacheModel() {
		return _examBodyUser.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser toEscapedModel() {
		return new ExamBodyUserWrapper(_examBodyUser.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser toUnescapedModel() {
		return new ExamBodyUserWrapper(_examBodyUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _examBodyUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _examBodyUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_examBodyUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExamBodyUserWrapper)) {
			return false;
		}

		ExamBodyUserWrapper examBodyUserWrapper = (ExamBodyUserWrapper)obj;

		if (Validator.equals(_examBodyUser, examBodyUserWrapper._examBodyUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ExamBodyUser getWrappedExamBodyUser() {
		return _examBodyUser;
	}

	@Override
	public ExamBodyUser getWrappedModel() {
		return _examBodyUser;
	}

	@Override
	public void resetOriginalValues() {
		_examBodyUser.resetOriginalValues();
	}

	private ExamBodyUser _examBodyUser;
}