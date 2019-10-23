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
 * This class is a wrapper for {@link CourseEnrollEsignInfo}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseEnrollEsignInfo
 * @generated
 */
public class CourseEnrollEsignInfoWrapper implements CourseEnrollEsignInfo,
	ModelWrapper<CourseEnrollEsignInfo> {
	public CourseEnrollEsignInfoWrapper(
		CourseEnrollEsignInfo courseEnrollEsignInfo) {
		_courseEnrollEsignInfo = courseEnrollEsignInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseEnrollEsignInfo.class;
	}

	@Override
	public String getModelClassName() {
		return CourseEnrollEsignInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spEsignInfoId", getSpEsignInfoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("signerId", getSignerId());
		attributes.put("packageId", getPackageId());
		attributes.put("documentId", getDocumentId());
		attributes.put("lastGeneratedUrl", getLastGeneratedUrl());
		attributes.put("spPEProcessStateId", getSpPEProcessStateId());
		attributes.put("extraInfo", getExtraInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spEsignInfoId = (Long)attributes.get("spEsignInfoId");

		if (spEsignInfoId != null) {
			setSpEsignInfoId(spEsignInfoId);
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

		String signerId = (String)attributes.get("signerId");

		if (signerId != null) {
			setSignerId(signerId);
		}

		String packageId = (String)attributes.get("packageId");

		if (packageId != null) {
			setPackageId(packageId);
		}

		String documentId = (String)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String lastGeneratedUrl = (String)attributes.get("lastGeneratedUrl");

		if (lastGeneratedUrl != null) {
			setLastGeneratedUrl(lastGeneratedUrl);
		}

		Long spPEProcessStateId = (Long)attributes.get("spPEProcessStateId");

		if (spPEProcessStateId != null) {
			setSpPEProcessStateId(spPEProcessStateId);
		}

		String extraInfo = (String)attributes.get("extraInfo");

		if (extraInfo != null) {
			setExtraInfo(extraInfo);
		}
	}

	/**
	* Returns the primary key of this course enroll esign info.
	*
	* @return the primary key of this course enroll esign info
	*/
	@Override
	public long getPrimaryKey() {
		return _courseEnrollEsignInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course enroll esign info.
	*
	* @param primaryKey the primary key of this course enroll esign info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseEnrollEsignInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp esign info ID of this course enroll esign info.
	*
	* @return the sp esign info ID of this course enroll esign info
	*/
	@Override
	public long getSpEsignInfoId() {
		return _courseEnrollEsignInfo.getSpEsignInfoId();
	}

	/**
	* Sets the sp esign info ID of this course enroll esign info.
	*
	* @param spEsignInfoId the sp esign info ID of this course enroll esign info
	*/
	@Override
	public void setSpEsignInfoId(long spEsignInfoId) {
		_courseEnrollEsignInfo.setSpEsignInfoId(spEsignInfoId);
	}

	/**
	* Returns the group ID of this course enroll esign info.
	*
	* @return the group ID of this course enroll esign info
	*/
	@Override
	public long getGroupId() {
		return _courseEnrollEsignInfo.getGroupId();
	}

	/**
	* Sets the group ID of this course enroll esign info.
	*
	* @param groupId the group ID of this course enroll esign info
	*/
	@Override
	public void setGroupId(long groupId) {
		_courseEnrollEsignInfo.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course enroll esign info.
	*
	* @return the company ID of this course enroll esign info
	*/
	@Override
	public long getCompanyId() {
		return _courseEnrollEsignInfo.getCompanyId();
	}

	/**
	* Sets the company ID of this course enroll esign info.
	*
	* @param companyId the company ID of this course enroll esign info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_courseEnrollEsignInfo.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course enroll esign info.
	*
	* @return the user ID of this course enroll esign info
	*/
	@Override
	public long getUserId() {
		return _courseEnrollEsignInfo.getUserId();
	}

	/**
	* Sets the user ID of this course enroll esign info.
	*
	* @param userId the user ID of this course enroll esign info
	*/
	@Override
	public void setUserId(long userId) {
		_courseEnrollEsignInfo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course enroll esign info.
	*
	* @return the user uuid of this course enroll esign info
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfo.getUserUuid();
	}

	/**
	* Sets the user uuid of this course enroll esign info.
	*
	* @param userUuid the user uuid of this course enroll esign info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseEnrollEsignInfo.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course enroll esign info.
	*
	* @return the user name of this course enroll esign info
	*/
	@Override
	public java.lang.String getUserName() {
		return _courseEnrollEsignInfo.getUserName();
	}

	/**
	* Sets the user name of this course enroll esign info.
	*
	* @param userName the user name of this course enroll esign info
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseEnrollEsignInfo.setUserName(userName);
	}

	/**
	* Returns the create date of this course enroll esign info.
	*
	* @return the create date of this course enroll esign info
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _courseEnrollEsignInfo.getCreateDate();
	}

	/**
	* Sets the create date of this course enroll esign info.
	*
	* @param createDate the create date of this course enroll esign info
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_courseEnrollEsignInfo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course enroll esign info.
	*
	* @return the modified date of this course enroll esign info
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _courseEnrollEsignInfo.getModifiedDate();
	}

	/**
	* Sets the modified date of this course enroll esign info.
	*
	* @param modifiedDate the modified date of this course enroll esign info
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseEnrollEsignInfo.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the signer ID of this course enroll esign info.
	*
	* @return the signer ID of this course enroll esign info
	*/
	@Override
	public java.lang.String getSignerId() {
		return _courseEnrollEsignInfo.getSignerId();
	}

	/**
	* Sets the signer ID of this course enroll esign info.
	*
	* @param signerId the signer ID of this course enroll esign info
	*/
	@Override
	public void setSignerId(java.lang.String signerId) {
		_courseEnrollEsignInfo.setSignerId(signerId);
	}

	/**
	* Returns the package ID of this course enroll esign info.
	*
	* @return the package ID of this course enroll esign info
	*/
	@Override
	public java.lang.String getPackageId() {
		return _courseEnrollEsignInfo.getPackageId();
	}

	/**
	* Sets the package ID of this course enroll esign info.
	*
	* @param packageId the package ID of this course enroll esign info
	*/
	@Override
	public void setPackageId(java.lang.String packageId) {
		_courseEnrollEsignInfo.setPackageId(packageId);
	}

	/**
	* Returns the document ID of this course enroll esign info.
	*
	* @return the document ID of this course enroll esign info
	*/
	@Override
	public java.lang.String getDocumentId() {
		return _courseEnrollEsignInfo.getDocumentId();
	}

	/**
	* Sets the document ID of this course enroll esign info.
	*
	* @param documentId the document ID of this course enroll esign info
	*/
	@Override
	public void setDocumentId(java.lang.String documentId) {
		_courseEnrollEsignInfo.setDocumentId(documentId);
	}

	/**
	* Returns the last generated url of this course enroll esign info.
	*
	* @return the last generated url of this course enroll esign info
	*/
	@Override
	public java.lang.String getLastGeneratedUrl() {
		return _courseEnrollEsignInfo.getLastGeneratedUrl();
	}

	/**
	* Sets the last generated url of this course enroll esign info.
	*
	* @param lastGeneratedUrl the last generated url of this course enroll esign info
	*/
	@Override
	public void setLastGeneratedUrl(java.lang.String lastGeneratedUrl) {
		_courseEnrollEsignInfo.setLastGeneratedUrl(lastGeneratedUrl);
	}

	/**
	* Returns the sp p e process state ID of this course enroll esign info.
	*
	* @return the sp p e process state ID of this course enroll esign info
	*/
	@Override
	public long getSpPEProcessStateId() {
		return _courseEnrollEsignInfo.getSpPEProcessStateId();
	}

	/**
	* Sets the sp p e process state ID of this course enroll esign info.
	*
	* @param spPEProcessStateId the sp p e process state ID of this course enroll esign info
	*/
	@Override
	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_courseEnrollEsignInfo.setSpPEProcessStateId(spPEProcessStateId);
	}

	/**
	* Returns the extra info of this course enroll esign info.
	*
	* @return the extra info of this course enroll esign info
	*/
	@Override
	public java.lang.String getExtraInfo() {
		return _courseEnrollEsignInfo.getExtraInfo();
	}

	/**
	* Sets the extra info of this course enroll esign info.
	*
	* @param extraInfo the extra info of this course enroll esign info
	*/
	@Override
	public void setExtraInfo(java.lang.String extraInfo) {
		_courseEnrollEsignInfo.setExtraInfo(extraInfo);
	}

	@Override
	public boolean isNew() {
		return _courseEnrollEsignInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseEnrollEsignInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseEnrollEsignInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseEnrollEsignInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseEnrollEsignInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseEnrollEsignInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseEnrollEsignInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseEnrollEsignInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseEnrollEsignInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseEnrollEsignInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseEnrollEsignInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseEnrollEsignInfoWrapper((CourseEnrollEsignInfo)_courseEnrollEsignInfo.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.CourseEnrollEsignInfo courseEnrollEsignInfo) {
		return _courseEnrollEsignInfo.compareTo(courseEnrollEsignInfo);
	}

	@Override
	public int hashCode() {
		return _courseEnrollEsignInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.CourseEnrollEsignInfo> toCacheModel() {
		return _courseEnrollEsignInfo.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo toEscapedModel() {
		return new CourseEnrollEsignInfoWrapper(_courseEnrollEsignInfo.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo toUnescapedModel() {
		return new CourseEnrollEsignInfoWrapper(_courseEnrollEsignInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseEnrollEsignInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseEnrollEsignInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseEnrollEsignInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseEnrollEsignInfoWrapper)) {
			return false;
		}

		CourseEnrollEsignInfoWrapper courseEnrollEsignInfoWrapper = (CourseEnrollEsignInfoWrapper)obj;

		if (Validator.equals(_courseEnrollEsignInfo,
					courseEnrollEsignInfoWrapper._courseEnrollEsignInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseEnrollEsignInfo getWrappedCourseEnrollEsignInfo() {
		return _courseEnrollEsignInfo;
	}

	@Override
	public CourseEnrollEsignInfo getWrappedModel() {
		return _courseEnrollEsignInfo;
	}

	@Override
	public void resetOriginalValues() {
		_courseEnrollEsignInfo.resetOriginalValues();
	}

	private CourseEnrollEsignInfo _courseEnrollEsignInfo;
}