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

package com.sambaash.platform.srv.spprofile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProfilePreferences}.
 * </p>
 *
 * @author harini
 * @see ProfilePreferences
 * @generated
 */
public class ProfilePreferencesWrapper implements ProfilePreferences,
	ModelWrapper<ProfilePreferences> {
	public ProfilePreferencesWrapper(ProfilePreferences profilePreferences) {
		_profilePreferences = profilePreferences;
	}

	@Override
	public Class<?> getModelClass() {
		return ProfilePreferences.class;
	}

	@Override
	public String getModelClassName() {
		return ProfilePreferences.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("proferenceId", getProferenceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("layoutId", getLayoutId());
		attributes.put("portletId", getPortletId());
		attributes.put("preferenceName", getPreferenceName());
		attributes.put("portletPreferences", getPortletPreferences());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long proferenceId = (Long)attributes.get("proferenceId");

		if (proferenceId != null) {
			setProferenceId(proferenceId);
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

		String layoutId = (String)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String preferenceName = (String)attributes.get("preferenceName");

		if (preferenceName != null) {
			setPreferenceName(preferenceName);
		}

		String portletPreferences = (String)attributes.get("portletPreferences");

		if (portletPreferences != null) {
			setPortletPreferences(portletPreferences);
		}
	}

	/**
	* Returns the primary key of this profile preferences.
	*
	* @return the primary key of this profile preferences
	*/
	@Override
	public long getPrimaryKey() {
		return _profilePreferences.getPrimaryKey();
	}

	/**
	* Sets the primary key of this profile preferences.
	*
	* @param primaryKey the primary key of this profile preferences
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_profilePreferences.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the proference ID of this profile preferences.
	*
	* @return the proference ID of this profile preferences
	*/
	@Override
	public long getProferenceId() {
		return _profilePreferences.getProferenceId();
	}

	/**
	* Sets the proference ID of this profile preferences.
	*
	* @param proferenceId the proference ID of this profile preferences
	*/
	@Override
	public void setProferenceId(long proferenceId) {
		_profilePreferences.setProferenceId(proferenceId);
	}

	/**
	* Returns the group ID of this profile preferences.
	*
	* @return the group ID of this profile preferences
	*/
	@Override
	public long getGroupId() {
		return _profilePreferences.getGroupId();
	}

	/**
	* Sets the group ID of this profile preferences.
	*
	* @param groupId the group ID of this profile preferences
	*/
	@Override
	public void setGroupId(long groupId) {
		_profilePreferences.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this profile preferences.
	*
	* @return the company ID of this profile preferences
	*/
	@Override
	public long getCompanyId() {
		return _profilePreferences.getCompanyId();
	}

	/**
	* Sets the company ID of this profile preferences.
	*
	* @param companyId the company ID of this profile preferences
	*/
	@Override
	public void setCompanyId(long companyId) {
		_profilePreferences.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this profile preferences.
	*
	* @return the user ID of this profile preferences
	*/
	@Override
	public long getUserId() {
		return _profilePreferences.getUserId();
	}

	/**
	* Sets the user ID of this profile preferences.
	*
	* @param userId the user ID of this profile preferences
	*/
	@Override
	public void setUserId(long userId) {
		_profilePreferences.setUserId(userId);
	}

	/**
	* Returns the user uuid of this profile preferences.
	*
	* @return the user uuid of this profile preferences
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _profilePreferences.getUserUuid();
	}

	/**
	* Sets the user uuid of this profile preferences.
	*
	* @param userUuid the user uuid of this profile preferences
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_profilePreferences.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this profile preferences.
	*
	* @return the user name of this profile preferences
	*/
	@Override
	public java.lang.String getUserName() {
		return _profilePreferences.getUserName();
	}

	/**
	* Sets the user name of this profile preferences.
	*
	* @param userName the user name of this profile preferences
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_profilePreferences.setUserName(userName);
	}

	/**
	* Returns the create date of this profile preferences.
	*
	* @return the create date of this profile preferences
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _profilePreferences.getCreateDate();
	}

	/**
	* Sets the create date of this profile preferences.
	*
	* @param createDate the create date of this profile preferences
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_profilePreferences.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this profile preferences.
	*
	* @return the modified date of this profile preferences
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _profilePreferences.getModifiedDate();
	}

	/**
	* Sets the modified date of this profile preferences.
	*
	* @param modifiedDate the modified date of this profile preferences
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_profilePreferences.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the layout ID of this profile preferences.
	*
	* @return the layout ID of this profile preferences
	*/
	@Override
	public java.lang.String getLayoutId() {
		return _profilePreferences.getLayoutId();
	}

	/**
	* Sets the layout ID of this profile preferences.
	*
	* @param layoutId the layout ID of this profile preferences
	*/
	@Override
	public void setLayoutId(java.lang.String layoutId) {
		_profilePreferences.setLayoutId(layoutId);
	}

	/**
	* Returns the portlet ID of this profile preferences.
	*
	* @return the portlet ID of this profile preferences
	*/
	@Override
	public java.lang.String getPortletId() {
		return _profilePreferences.getPortletId();
	}

	/**
	* Sets the portlet ID of this profile preferences.
	*
	* @param portletId the portlet ID of this profile preferences
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_profilePreferences.setPortletId(portletId);
	}

	/**
	* Returns the preference name of this profile preferences.
	*
	* @return the preference name of this profile preferences
	*/
	@Override
	public java.lang.String getPreferenceName() {
		return _profilePreferences.getPreferenceName();
	}

	/**
	* Sets the preference name of this profile preferences.
	*
	* @param preferenceName the preference name of this profile preferences
	*/
	@Override
	public void setPreferenceName(java.lang.String preferenceName) {
		_profilePreferences.setPreferenceName(preferenceName);
	}

	/**
	* Returns the portlet preferences of this profile preferences.
	*
	* @return the portlet preferences of this profile preferences
	*/
	@Override
	public java.lang.String getPortletPreferences() {
		return _profilePreferences.getPortletPreferences();
	}

	/**
	* Sets the portlet preferences of this profile preferences.
	*
	* @param portletPreferences the portlet preferences of this profile preferences
	*/
	@Override
	public void setPortletPreferences(java.lang.String portletPreferences) {
		_profilePreferences.setPortletPreferences(portletPreferences);
	}

	@Override
	public boolean isNew() {
		return _profilePreferences.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_profilePreferences.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _profilePreferences.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_profilePreferences.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _profilePreferences.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _profilePreferences.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_profilePreferences.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _profilePreferences.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_profilePreferences.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_profilePreferences.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_profilePreferences.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProfilePreferencesWrapper((ProfilePreferences)_profilePreferences.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spprofile.model.ProfilePreferences profilePreferences) {
		return _profilePreferences.compareTo(profilePreferences);
	}

	@Override
	public int hashCode() {
		return _profilePreferences.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spprofile.model.ProfilePreferences> toCacheModel() {
		return _profilePreferences.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences toEscapedModel() {
		return new ProfilePreferencesWrapper(_profilePreferences.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spprofile.model.ProfilePreferences toUnescapedModel() {
		return new ProfilePreferencesWrapper(_profilePreferences.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _profilePreferences.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _profilePreferences.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_profilePreferences.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProfilePreferencesWrapper)) {
			return false;
		}

		ProfilePreferencesWrapper profilePreferencesWrapper = (ProfilePreferencesWrapper)obj;

		if (Validator.equals(_profilePreferences,
					profilePreferencesWrapper._profilePreferences)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProfilePreferences getWrappedProfilePreferences() {
		return _profilePreferences;
	}

	@Override
	public ProfilePreferences getWrappedModel() {
		return _profilePreferences;
	}

	@Override
	public void resetOriginalValues() {
		_profilePreferences.resetOriginalValues();
	}

	private ProfilePreferences _profilePreferences;
}