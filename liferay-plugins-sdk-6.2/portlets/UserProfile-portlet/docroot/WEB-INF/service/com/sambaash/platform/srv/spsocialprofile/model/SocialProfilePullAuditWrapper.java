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
 * This class is a wrapper for {@link SocialProfilePullAudit}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfilePullAudit
 * @generated
 */
public class SocialProfilePullAuditWrapper implements SocialProfilePullAudit,
	ModelWrapper<SocialProfilePullAudit> {
	public SocialProfilePullAuditWrapper(
		SocialProfilePullAudit socialProfilePullAudit) {
		_socialProfilePullAudit = socialProfilePullAudit;
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfilePullAudit.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfilePullAudit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("socialNetworkProfileId", getSocialNetworkProfileId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("lastQueriedDate", getLastQueriedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long socialNetworkProfileId = (Long)attributes.get(
				"socialNetworkProfileId");

		if (socialNetworkProfileId != null) {
			setSocialNetworkProfileId(socialNetworkProfileId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date lastQueriedDate = (Date)attributes.get("lastQueriedDate");

		if (lastQueriedDate != null) {
			setLastQueriedDate(lastQueriedDate);
		}
	}

	/**
	* Returns the primary key of this social profile pull audit.
	*
	* @return the primary key of this social profile pull audit
	*/
	@Override
	public com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePullAuditPK getPrimaryKey() {
		return _socialProfilePullAudit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social profile pull audit.
	*
	* @param primaryKey the primary key of this social profile pull audit
	*/
	@Override
	public void setPrimaryKey(
		com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePullAuditPK primaryKey) {
		_socialProfilePullAudit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this social profile pull audit.
	*
	* @return the user ID of this social profile pull audit
	*/
	@Override
	public long getUserId() {
		return _socialProfilePullAudit.getUserId();
	}

	/**
	* Sets the user ID of this social profile pull audit.
	*
	* @param userId the user ID of this social profile pull audit
	*/
	@Override
	public void setUserId(long userId) {
		_socialProfilePullAudit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this social profile pull audit.
	*
	* @return the user uuid of this social profile pull audit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfilePullAudit.getUserUuid();
	}

	/**
	* Sets the user uuid of this social profile pull audit.
	*
	* @param userUuid the user uuid of this social profile pull audit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_socialProfilePullAudit.setUserUuid(userUuid);
	}

	/**
	* Returns the social network profile ID of this social profile pull audit.
	*
	* @return the social network profile ID of this social profile pull audit
	*/
	@Override
	public long getSocialNetworkProfileId() {
		return _socialProfilePullAudit.getSocialNetworkProfileId();
	}

	/**
	* Sets the social network profile ID of this social profile pull audit.
	*
	* @param socialNetworkProfileId the social network profile ID of this social profile pull audit
	*/
	@Override
	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_socialProfilePullAudit.setSocialNetworkProfileId(socialNetworkProfileId);
	}

	/**
	* Returns the company ID of this social profile pull audit.
	*
	* @return the company ID of this social profile pull audit
	*/
	@Override
	public long getCompanyId() {
		return _socialProfilePullAudit.getCompanyId();
	}

	/**
	* Sets the company ID of this social profile pull audit.
	*
	* @param companyId the company ID of this social profile pull audit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_socialProfilePullAudit.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this social profile pull audit.
	*
	* @return the create date of this social profile pull audit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _socialProfilePullAudit.getCreateDate();
	}

	/**
	* Sets the create date of this social profile pull audit.
	*
	* @param createDate the create date of this social profile pull audit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_socialProfilePullAudit.setCreateDate(createDate);
	}

	/**
	* Returns the last queried date of this social profile pull audit.
	*
	* @return the last queried date of this social profile pull audit
	*/
	@Override
	public java.util.Date getLastQueriedDate() {
		return _socialProfilePullAudit.getLastQueriedDate();
	}

	/**
	* Sets the last queried date of this social profile pull audit.
	*
	* @param lastQueriedDate the last queried date of this social profile pull audit
	*/
	@Override
	public void setLastQueriedDate(java.util.Date lastQueriedDate) {
		_socialProfilePullAudit.setLastQueriedDate(lastQueriedDate);
	}

	@Override
	public boolean isNew() {
		return _socialProfilePullAudit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_socialProfilePullAudit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _socialProfilePullAudit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_socialProfilePullAudit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _socialProfilePullAudit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _socialProfilePullAudit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_socialProfilePullAudit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialProfilePullAudit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_socialProfilePullAudit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_socialProfilePullAudit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialProfilePullAudit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SocialProfilePullAuditWrapper((SocialProfilePullAudit)_socialProfilePullAudit.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit socialProfilePullAudit) {
		return _socialProfilePullAudit.compareTo(socialProfilePullAudit);
	}

	@Override
	public int hashCode() {
		return _socialProfilePullAudit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit> toCacheModel() {
		return _socialProfilePullAudit.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit toEscapedModel() {
		return new SocialProfilePullAuditWrapper(_socialProfilePullAudit.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit toUnescapedModel() {
		return new SocialProfilePullAuditWrapper(_socialProfilePullAudit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _socialProfilePullAudit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _socialProfilePullAudit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfilePullAudit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialProfilePullAuditWrapper)) {
			return false;
		}

		SocialProfilePullAuditWrapper socialProfilePullAuditWrapper = (SocialProfilePullAuditWrapper)obj;

		if (Validator.equals(_socialProfilePullAudit,
					socialProfilePullAuditWrapper._socialProfilePullAudit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SocialProfilePullAudit getWrappedSocialProfilePullAudit() {
		return _socialProfilePullAudit;
	}

	@Override
	public SocialProfilePullAudit getWrappedModel() {
		return _socialProfilePullAudit;
	}

	@Override
	public void resetOriginalValues() {
		_socialProfilePullAudit.resetOriginalValues();
	}

	private SocialProfilePullAudit _socialProfilePullAudit;
}