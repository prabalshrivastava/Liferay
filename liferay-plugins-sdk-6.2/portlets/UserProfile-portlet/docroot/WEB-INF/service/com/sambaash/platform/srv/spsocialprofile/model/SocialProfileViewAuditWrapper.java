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
 * This class is a wrapper for {@link SocialProfileViewAudit}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileViewAudit
 * @generated
 */
public class SocialProfileViewAuditWrapper implements SocialProfileViewAudit,
	ModelWrapper<SocialProfileViewAudit> {
	public SocialProfileViewAuditWrapper(
		SocialProfileViewAudit socialProfileViewAudit) {
		_socialProfileViewAudit = socialProfileViewAudit;
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfileViewAudit.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfileViewAudit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("socialProfileViewAuditId", getSocialProfileViewAuditId());
		attributes.put("loggedInUserId", getLoggedInUserId());
		attributes.put("profileUserId", getProfileUserId());
		attributes.put("lastViewDate", getLastViewDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long socialProfileViewAuditId = (Long)attributes.get(
				"socialProfileViewAuditId");

		if (socialProfileViewAuditId != null) {
			setSocialProfileViewAuditId(socialProfileViewAuditId);
		}

		Long loggedInUserId = (Long)attributes.get("loggedInUserId");

		if (loggedInUserId != null) {
			setLoggedInUserId(loggedInUserId);
		}

		Long profileUserId = (Long)attributes.get("profileUserId");

		if (profileUserId != null) {
			setProfileUserId(profileUserId);
		}

		Date lastViewDate = (Date)attributes.get("lastViewDate");

		if (lastViewDate != null) {
			setLastViewDate(lastViewDate);
		}
	}

	/**
	* Returns the primary key of this social profile view audit.
	*
	* @return the primary key of this social profile view audit
	*/
	@Override
	public long getPrimaryKey() {
		return _socialProfileViewAudit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social profile view audit.
	*
	* @param primaryKey the primary key of this social profile view audit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_socialProfileViewAudit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this social profile view audit.
	*
	* @return the uuid of this social profile view audit
	*/
	@Override
	public java.lang.String getUuid() {
		return _socialProfileViewAudit.getUuid();
	}

	/**
	* Sets the uuid of this social profile view audit.
	*
	* @param uuid the uuid of this social profile view audit
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_socialProfileViewAudit.setUuid(uuid);
	}

	/**
	* Returns the social profile view audit ID of this social profile view audit.
	*
	* @return the social profile view audit ID of this social profile view audit
	*/
	@Override
	public long getSocialProfileViewAuditId() {
		return _socialProfileViewAudit.getSocialProfileViewAuditId();
	}

	/**
	* Sets the social profile view audit ID of this social profile view audit.
	*
	* @param socialProfileViewAuditId the social profile view audit ID of this social profile view audit
	*/
	@Override
	public void setSocialProfileViewAuditId(long socialProfileViewAuditId) {
		_socialProfileViewAudit.setSocialProfileViewAuditId(socialProfileViewAuditId);
	}

	/**
	* Returns the logged in user ID of this social profile view audit.
	*
	* @return the logged in user ID of this social profile view audit
	*/
	@Override
	public long getLoggedInUserId() {
		return _socialProfileViewAudit.getLoggedInUserId();
	}

	/**
	* Sets the logged in user ID of this social profile view audit.
	*
	* @param loggedInUserId the logged in user ID of this social profile view audit
	*/
	@Override
	public void setLoggedInUserId(long loggedInUserId) {
		_socialProfileViewAudit.setLoggedInUserId(loggedInUserId);
	}

	/**
	* Returns the logged in user uuid of this social profile view audit.
	*
	* @return the logged in user uuid of this social profile view audit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getLoggedInUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileViewAudit.getLoggedInUserUuid();
	}

	/**
	* Sets the logged in user uuid of this social profile view audit.
	*
	* @param loggedInUserUuid the logged in user uuid of this social profile view audit
	*/
	@Override
	public void setLoggedInUserUuid(java.lang.String loggedInUserUuid) {
		_socialProfileViewAudit.setLoggedInUserUuid(loggedInUserUuid);
	}

	/**
	* Returns the profile user ID of this social profile view audit.
	*
	* @return the profile user ID of this social profile view audit
	*/
	@Override
	public long getProfileUserId() {
		return _socialProfileViewAudit.getProfileUserId();
	}

	/**
	* Sets the profile user ID of this social profile view audit.
	*
	* @param profileUserId the profile user ID of this social profile view audit
	*/
	@Override
	public void setProfileUserId(long profileUserId) {
		_socialProfileViewAudit.setProfileUserId(profileUserId);
	}

	/**
	* Returns the profile user uuid of this social profile view audit.
	*
	* @return the profile user uuid of this social profile view audit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getProfileUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileViewAudit.getProfileUserUuid();
	}

	/**
	* Sets the profile user uuid of this social profile view audit.
	*
	* @param profileUserUuid the profile user uuid of this social profile view audit
	*/
	@Override
	public void setProfileUserUuid(java.lang.String profileUserUuid) {
		_socialProfileViewAudit.setProfileUserUuid(profileUserUuid);
	}

	/**
	* Returns the last view date of this social profile view audit.
	*
	* @return the last view date of this social profile view audit
	*/
	@Override
	public java.util.Date getLastViewDate() {
		return _socialProfileViewAudit.getLastViewDate();
	}

	/**
	* Sets the last view date of this social profile view audit.
	*
	* @param lastViewDate the last view date of this social profile view audit
	*/
	@Override
	public void setLastViewDate(java.util.Date lastViewDate) {
		_socialProfileViewAudit.setLastViewDate(lastViewDate);
	}

	@Override
	public boolean isNew() {
		return _socialProfileViewAudit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_socialProfileViewAudit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _socialProfileViewAudit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_socialProfileViewAudit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _socialProfileViewAudit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _socialProfileViewAudit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_socialProfileViewAudit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialProfileViewAudit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_socialProfileViewAudit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_socialProfileViewAudit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialProfileViewAudit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SocialProfileViewAuditWrapper((SocialProfileViewAudit)_socialProfileViewAudit.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit socialProfileViewAudit) {
		return _socialProfileViewAudit.compareTo(socialProfileViewAudit);
	}

	@Override
	public int hashCode() {
		return _socialProfileViewAudit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit> toCacheModel() {
		return _socialProfileViewAudit.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit toEscapedModel() {
		return new SocialProfileViewAuditWrapper(_socialProfileViewAudit.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit toUnescapedModel() {
		return new SocialProfileViewAuditWrapper(_socialProfileViewAudit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _socialProfileViewAudit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _socialProfileViewAudit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileViewAudit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialProfileViewAuditWrapper)) {
			return false;
		}

		SocialProfileViewAuditWrapper socialProfileViewAuditWrapper = (SocialProfileViewAuditWrapper)obj;

		if (Validator.equals(_socialProfileViewAudit,
					socialProfileViewAuditWrapper._socialProfileViewAudit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SocialProfileViewAudit getWrappedSocialProfileViewAudit() {
		return _socialProfileViewAudit;
	}

	@Override
	public SocialProfileViewAudit getWrappedModel() {
		return _socialProfileViewAudit;
	}

	@Override
	public void resetOriginalValues() {
		_socialProfileViewAudit.resetOriginalValues();
	}

	private SocialProfileViewAudit _socialProfileViewAudit;
}