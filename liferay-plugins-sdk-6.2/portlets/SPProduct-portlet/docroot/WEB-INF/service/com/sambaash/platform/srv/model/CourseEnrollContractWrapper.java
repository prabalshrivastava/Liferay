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
 * This class is a wrapper for {@link CourseEnrollContract}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseEnrollContract
 * @generated
 */
public class CourseEnrollContractWrapper implements CourseEnrollContract,
	ModelWrapper<CourseEnrollContract> {
	public CourseEnrollContractWrapper(
		CourseEnrollContract courseEnrollContract) {
		_courseEnrollContract = courseEnrollContract;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseEnrollContract.class;
	}

	@Override
	public String getModelClassName() {
		return CourseEnrollContract.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseContractId", getSpCourseContractId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("courseType", getCourseType());
		attributes.put("docType", getDocType());
		attributes.put("seqNo", getSeqNo());
		attributes.put("contractTemplateFileEntryId",
			getContractTemplateFileEntryId());
		attributes.put("dataTemplateFileEntryId", getDataTemplateFileEntryId());
		attributes.put("extraInfo", getExtraInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseContractId = (Long)attributes.get("spCourseContractId");

		if (spCourseContractId != null) {
			setSpCourseContractId(spCourseContractId);
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

		String countryId = (String)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long courseType = (Long)attributes.get("courseType");

		if (courseType != null) {
			setCourseType(courseType);
		}

		String docType = (String)attributes.get("docType");

		if (docType != null) {
			setDocType(docType);
		}

		Integer seqNo = (Integer)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Long contractTemplateFileEntryId = (Long)attributes.get(
				"contractTemplateFileEntryId");

		if (contractTemplateFileEntryId != null) {
			setContractTemplateFileEntryId(contractTemplateFileEntryId);
		}

		Long dataTemplateFileEntryId = (Long)attributes.get(
				"dataTemplateFileEntryId");

		if (dataTemplateFileEntryId != null) {
			setDataTemplateFileEntryId(dataTemplateFileEntryId);
		}

		String extraInfo = (String)attributes.get("extraInfo");

		if (extraInfo != null) {
			setExtraInfo(extraInfo);
		}
	}

	/**
	* Returns the primary key of this course enroll contract.
	*
	* @return the primary key of this course enroll contract
	*/
	@Override
	public long getPrimaryKey() {
		return _courseEnrollContract.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course enroll contract.
	*
	* @param primaryKey the primary key of this course enroll contract
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseEnrollContract.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp course contract ID of this course enroll contract.
	*
	* @return the sp course contract ID of this course enroll contract
	*/
	@Override
	public long getSpCourseContractId() {
		return _courseEnrollContract.getSpCourseContractId();
	}

	/**
	* Sets the sp course contract ID of this course enroll contract.
	*
	* @param spCourseContractId the sp course contract ID of this course enroll contract
	*/
	@Override
	public void setSpCourseContractId(long spCourseContractId) {
		_courseEnrollContract.setSpCourseContractId(spCourseContractId);
	}

	/**
	* Returns the group ID of this course enroll contract.
	*
	* @return the group ID of this course enroll contract
	*/
	@Override
	public long getGroupId() {
		return _courseEnrollContract.getGroupId();
	}

	/**
	* Sets the group ID of this course enroll contract.
	*
	* @param groupId the group ID of this course enroll contract
	*/
	@Override
	public void setGroupId(long groupId) {
		_courseEnrollContract.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course enroll contract.
	*
	* @return the company ID of this course enroll contract
	*/
	@Override
	public long getCompanyId() {
		return _courseEnrollContract.getCompanyId();
	}

	/**
	* Sets the company ID of this course enroll contract.
	*
	* @param companyId the company ID of this course enroll contract
	*/
	@Override
	public void setCompanyId(long companyId) {
		_courseEnrollContract.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course enroll contract.
	*
	* @return the user ID of this course enroll contract
	*/
	@Override
	public long getUserId() {
		return _courseEnrollContract.getUserId();
	}

	/**
	* Sets the user ID of this course enroll contract.
	*
	* @param userId the user ID of this course enroll contract
	*/
	@Override
	public void setUserId(long userId) {
		_courseEnrollContract.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course enroll contract.
	*
	* @return the user uuid of this course enroll contract
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollContract.getUserUuid();
	}

	/**
	* Sets the user uuid of this course enroll contract.
	*
	* @param userUuid the user uuid of this course enroll contract
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseEnrollContract.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course enroll contract.
	*
	* @return the user name of this course enroll contract
	*/
	@Override
	public java.lang.String getUserName() {
		return _courseEnrollContract.getUserName();
	}

	/**
	* Sets the user name of this course enroll contract.
	*
	* @param userName the user name of this course enroll contract
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseEnrollContract.setUserName(userName);
	}

	/**
	* Returns the create date of this course enroll contract.
	*
	* @return the create date of this course enroll contract
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _courseEnrollContract.getCreateDate();
	}

	/**
	* Sets the create date of this course enroll contract.
	*
	* @param createDate the create date of this course enroll contract
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_courseEnrollContract.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course enroll contract.
	*
	* @return the modified date of this course enroll contract
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _courseEnrollContract.getModifiedDate();
	}

	/**
	* Sets the modified date of this course enroll contract.
	*
	* @param modifiedDate the modified date of this course enroll contract
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseEnrollContract.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country ID of this course enroll contract.
	*
	* @return the country ID of this course enroll contract
	*/
	@Override
	public java.lang.String getCountryId() {
		return _courseEnrollContract.getCountryId();
	}

	/**
	* Sets the country ID of this course enroll contract.
	*
	* @param countryId the country ID of this course enroll contract
	*/
	@Override
	public void setCountryId(java.lang.String countryId) {
		_courseEnrollContract.setCountryId(countryId);
	}

	/**
	* Returns the course type of this course enroll contract.
	*
	* @return the course type of this course enroll contract
	*/
	@Override
	public long getCourseType() {
		return _courseEnrollContract.getCourseType();
	}

	/**
	* Sets the course type of this course enroll contract.
	*
	* @param courseType the course type of this course enroll contract
	*/
	@Override
	public void setCourseType(long courseType) {
		_courseEnrollContract.setCourseType(courseType);
	}

	/**
	* Returns the doc type of this course enroll contract.
	*
	* @return the doc type of this course enroll contract
	*/
	@Override
	public java.lang.String getDocType() {
		return _courseEnrollContract.getDocType();
	}

	/**
	* Sets the doc type of this course enroll contract.
	*
	* @param docType the doc type of this course enroll contract
	*/
	@Override
	public void setDocType(java.lang.String docType) {
		_courseEnrollContract.setDocType(docType);
	}

	/**
	* Returns the seq no of this course enroll contract.
	*
	* @return the seq no of this course enroll contract
	*/
	@Override
	public int getSeqNo() {
		return _courseEnrollContract.getSeqNo();
	}

	/**
	* Sets the seq no of this course enroll contract.
	*
	* @param seqNo the seq no of this course enroll contract
	*/
	@Override
	public void setSeqNo(int seqNo) {
		_courseEnrollContract.setSeqNo(seqNo);
	}

	/**
	* Returns the contract template file entry ID of this course enroll contract.
	*
	* @return the contract template file entry ID of this course enroll contract
	*/
	@Override
	public long getContractTemplateFileEntryId() {
		return _courseEnrollContract.getContractTemplateFileEntryId();
	}

	/**
	* Sets the contract template file entry ID of this course enroll contract.
	*
	* @param contractTemplateFileEntryId the contract template file entry ID of this course enroll contract
	*/
	@Override
	public void setContractTemplateFileEntryId(long contractTemplateFileEntryId) {
		_courseEnrollContract.setContractTemplateFileEntryId(contractTemplateFileEntryId);
	}

	/**
	* Returns the data template file entry ID of this course enroll contract.
	*
	* @return the data template file entry ID of this course enroll contract
	*/
	@Override
	public long getDataTemplateFileEntryId() {
		return _courseEnrollContract.getDataTemplateFileEntryId();
	}

	/**
	* Sets the data template file entry ID of this course enroll contract.
	*
	* @param dataTemplateFileEntryId the data template file entry ID of this course enroll contract
	*/
	@Override
	public void setDataTemplateFileEntryId(long dataTemplateFileEntryId) {
		_courseEnrollContract.setDataTemplateFileEntryId(dataTemplateFileEntryId);
	}

	/**
	* Returns the extra info of this course enroll contract.
	*
	* @return the extra info of this course enroll contract
	*/
	@Override
	public java.lang.String getExtraInfo() {
		return _courseEnrollContract.getExtraInfo();
	}

	/**
	* Sets the extra info of this course enroll contract.
	*
	* @param extraInfo the extra info of this course enroll contract
	*/
	@Override
	public void setExtraInfo(java.lang.String extraInfo) {
		_courseEnrollContract.setExtraInfo(extraInfo);
	}

	@Override
	public boolean isNew() {
		return _courseEnrollContract.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseEnrollContract.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseEnrollContract.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseEnrollContract.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseEnrollContract.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseEnrollContract.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseEnrollContract.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseEnrollContract.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseEnrollContract.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseEnrollContract.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseEnrollContract.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseEnrollContractWrapper((CourseEnrollContract)_courseEnrollContract.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.CourseEnrollContract courseEnrollContract) {
		return _courseEnrollContract.compareTo(courseEnrollContract);
	}

	@Override
	public int hashCode() {
		return _courseEnrollContract.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.CourseEnrollContract> toCacheModel() {
		return _courseEnrollContract.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollContract toEscapedModel() {
		return new CourseEnrollContractWrapper(_courseEnrollContract.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollContract toUnescapedModel() {
		return new CourseEnrollContractWrapper(_courseEnrollContract.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseEnrollContract.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseEnrollContract.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseEnrollContract.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseEnrollContractWrapper)) {
			return false;
		}

		CourseEnrollContractWrapper courseEnrollContractWrapper = (CourseEnrollContractWrapper)obj;

		if (Validator.equals(_courseEnrollContract,
					courseEnrollContractWrapper._courseEnrollContract)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseEnrollContract getWrappedCourseEnrollContract() {
		return _courseEnrollContract;
	}

	@Override
	public CourseEnrollContract getWrappedModel() {
		return _courseEnrollContract;
	}

	@Override
	public void resetOriginalValues() {
		_courseEnrollContract.resetOriginalValues();
	}

	private CourseEnrollContract _courseEnrollContract;
}