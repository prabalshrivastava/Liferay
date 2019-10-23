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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SocialProfileDetail}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileDetail
 * @generated
 */
public class SocialProfileDetailWrapper implements SocialProfileDetail,
	ModelWrapper<SocialProfileDetail> {
	public SocialProfileDetailWrapper(SocialProfileDetail socialProfileDetail) {
		_socialProfileDetail = socialProfileDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfileDetail.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfileDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("socialProfileDetailId", getSocialProfileDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userJobId", getUserJobId());
		attributes.put("companyName", getCompanyName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long socialProfileDetailId = (Long)attributes.get(
				"socialProfileDetailId");

		if (socialProfileDetailId != null) {
			setSocialProfileDetailId(socialProfileDetailId);
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

		String userJobId = (String)attributes.get("userJobId");

		if (userJobId != null) {
			setUserJobId(userJobId);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}
	}

	/**
	* Returns the primary key of this social profile detail.
	*
	* @return the primary key of this social profile detail
	*/
	@Override
	public long getPrimaryKey() {
		return _socialProfileDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social profile detail.
	*
	* @param primaryKey the primary key of this social profile detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_socialProfileDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this social profile detail.
	*
	* @return the uuid of this social profile detail
	*/
	@Override
	public java.lang.String getUuid() {
		return _socialProfileDetail.getUuid();
	}

	/**
	* Sets the uuid of this social profile detail.
	*
	* @param uuid the uuid of this social profile detail
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_socialProfileDetail.setUuid(uuid);
	}

	/**
	* Returns the social profile detail ID of this social profile detail.
	*
	* @return the social profile detail ID of this social profile detail
	*/
	@Override
	public long getSocialProfileDetailId() {
		return _socialProfileDetail.getSocialProfileDetailId();
	}

	/**
	* Sets the social profile detail ID of this social profile detail.
	*
	* @param socialProfileDetailId the social profile detail ID of this social profile detail
	*/
	@Override
	public void setSocialProfileDetailId(long socialProfileDetailId) {
		_socialProfileDetail.setSocialProfileDetailId(socialProfileDetailId);
	}

	/**
	* Returns the group ID of this social profile detail.
	*
	* @return the group ID of this social profile detail
	*/
	@Override
	public long getGroupId() {
		return _socialProfileDetail.getGroupId();
	}

	/**
	* Sets the group ID of this social profile detail.
	*
	* @param groupId the group ID of this social profile detail
	*/
	@Override
	public void setGroupId(long groupId) {
		_socialProfileDetail.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this social profile detail.
	*
	* @return the company ID of this social profile detail
	*/
	@Override
	public long getCompanyId() {
		return _socialProfileDetail.getCompanyId();
	}

	/**
	* Sets the company ID of this social profile detail.
	*
	* @param companyId the company ID of this social profile detail
	*/
	@Override
	public void setCompanyId(long companyId) {
		_socialProfileDetail.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this social profile detail.
	*
	* @return the user ID of this social profile detail
	*/
	@Override
	public long getUserId() {
		return _socialProfileDetail.getUserId();
	}

	/**
	* Sets the user ID of this social profile detail.
	*
	* @param userId the user ID of this social profile detail
	*/
	@Override
	public void setUserId(long userId) {
		_socialProfileDetail.setUserId(userId);
	}

	/**
	* Returns the user uuid of this social profile detail.
	*
	* @return the user uuid of this social profile detail
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileDetail.getUserUuid();
	}

	/**
	* Sets the user uuid of this social profile detail.
	*
	* @param userUuid the user uuid of this social profile detail
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_socialProfileDetail.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this social profile detail.
	*
	* @return the user name of this social profile detail
	*/
	@Override
	public java.lang.String getUserName() {
		return _socialProfileDetail.getUserName();
	}

	/**
	* Sets the user name of this social profile detail.
	*
	* @param userName the user name of this social profile detail
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_socialProfileDetail.setUserName(userName);
	}

	/**
	* Returns the create date of this social profile detail.
	*
	* @return the create date of this social profile detail
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _socialProfileDetail.getCreateDate();
	}

	/**
	* Sets the create date of this social profile detail.
	*
	* @param createDate the create date of this social profile detail
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_socialProfileDetail.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this social profile detail.
	*
	* @return the modified date of this social profile detail
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _socialProfileDetail.getModifiedDate();
	}

	/**
	* Sets the modified date of this social profile detail.
	*
	* @param modifiedDate the modified date of this social profile detail
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_socialProfileDetail.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user job ID of this social profile detail.
	*
	* @return the user job ID of this social profile detail
	*/
	@Override
	public java.lang.String getUserJobId() {
		return _socialProfileDetail.getUserJobId();
	}

	/**
	* Sets the user job ID of this social profile detail.
	*
	* @param userJobId the user job ID of this social profile detail
	*/
	@Override
	public void setUserJobId(java.lang.String userJobId) {
		_socialProfileDetail.setUserJobId(userJobId);
	}

	/**
	* Returns the company name of this social profile detail.
	*
	* @return the company name of this social profile detail
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _socialProfileDetail.getCompanyName();
	}

	/**
	* Sets the company name of this social profile detail.
	*
	* @param companyName the company name of this social profile detail
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_socialProfileDetail.setCompanyName(companyName);
	}

	@Override
	public boolean isNew() {
		return _socialProfileDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_socialProfileDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _socialProfileDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_socialProfileDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _socialProfileDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _socialProfileDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_socialProfileDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialProfileDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_socialProfileDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_socialProfileDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialProfileDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SocialProfileDetailWrapper((SocialProfileDetail)_socialProfileDetail.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail socialProfileDetail) {
		return _socialProfileDetail.compareTo(socialProfileDetail);
	}

	@Override
	public int hashCode() {
		return _socialProfileDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail> toCacheModel() {
		return _socialProfileDetail.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail toEscapedModel() {
		return new SocialProfileDetailWrapper(_socialProfileDetail.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail toUnescapedModel() {
		return new SocialProfileDetailWrapper(_socialProfileDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _socialProfileDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _socialProfileDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialProfileDetailWrapper)) {
			return false;
		}

		SocialProfileDetailWrapper socialProfileDetailWrapper = (SocialProfileDetailWrapper)obj;

		if (Validator.equals(_socialProfileDetail,
					socialProfileDetailWrapper._socialProfileDetail)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _socialProfileDetail.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SocialProfileDetail getWrappedSocialProfileDetail() {
		return _socialProfileDetail;
	}

	@Override
	public SocialProfileDetail getWrappedModel() {
		return _socialProfileDetail;
	}

	@Override
	public void resetOriginalValues() {
		_socialProfileDetail.resetOriginalValues();
	}

	private SocialProfileDetail _socialProfileDetail;
}