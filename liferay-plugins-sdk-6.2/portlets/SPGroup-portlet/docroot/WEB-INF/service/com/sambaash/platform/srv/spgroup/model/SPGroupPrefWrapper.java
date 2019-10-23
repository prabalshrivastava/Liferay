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

package com.sambaash.platform.srv.spgroup.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPGroupPref}.
 * </p>
 *
 * @author harini
 * @see SPGroupPref
 * @generated
 */
public class SPGroupPrefWrapper implements SPGroupPref,
	ModelWrapper<SPGroupPref> {
	public SPGroupPrefWrapper(SPGroupPref spGroupPref) {
		_spGroupPref = spGroupPref;
	}

	@Override
	public Class<?> getModelClass() {
		return SPGroupPref.class;
	}

	@Override
	public String getModelClassName() {
		return SPGroupPref.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spGroupPrefId", getSpGroupPrefId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dIn", getDIn());
		attributes.put("dGoogle", getDGoogle());
		attributes.put("dFb", getDFb());
		attributes.put("dTw", getDTw());
		attributes.put("cIn", getCIn());
		attributes.put("cGoogle", getCGoogle());
		attributes.put("cFb", getCFb());
		attributes.put("cTw", getCTw());
		attributes.put("enableSubscribeToComments",
			getEnableSubscribeToComments());
		attributes.put("enableGroupUpdateNotification",
			getEnableGroupUpdateNotification());
		attributes.put("enableMemberUpdate", getEnableMemberUpdate());
		attributes.put("enableDiscussionUpdate", getEnableDiscussionUpdate());
		attributes.put("updateFrequency", getUpdateFrequency());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spGroupPrefId = (Long)attributes.get("spGroupPrefId");

		if (spGroupPrefId != null) {
			setSpGroupPrefId(spGroupPrefId);
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

		Boolean dIn = (Boolean)attributes.get("dIn");

		if (dIn != null) {
			setDIn(dIn);
		}

		Boolean dGoogle = (Boolean)attributes.get("dGoogle");

		if (dGoogle != null) {
			setDGoogle(dGoogle);
		}

		Boolean dFb = (Boolean)attributes.get("dFb");

		if (dFb != null) {
			setDFb(dFb);
		}

		Boolean dTw = (Boolean)attributes.get("dTw");

		if (dTw != null) {
			setDTw(dTw);
		}

		Boolean cIn = (Boolean)attributes.get("cIn");

		if (cIn != null) {
			setCIn(cIn);
		}

		Boolean cGoogle = (Boolean)attributes.get("cGoogle");

		if (cGoogle != null) {
			setCGoogle(cGoogle);
		}

		Boolean cFb = (Boolean)attributes.get("cFb");

		if (cFb != null) {
			setCFb(cFb);
		}

		Boolean cTw = (Boolean)attributes.get("cTw");

		if (cTw != null) {
			setCTw(cTw);
		}

		Boolean enableSubscribeToComments = (Boolean)attributes.get(
				"enableSubscribeToComments");

		if (enableSubscribeToComments != null) {
			setEnableSubscribeToComments(enableSubscribeToComments);
		}

		Boolean enableGroupUpdateNotification = (Boolean)attributes.get(
				"enableGroupUpdateNotification");

		if (enableGroupUpdateNotification != null) {
			setEnableGroupUpdateNotification(enableGroupUpdateNotification);
		}

		Boolean enableMemberUpdate = (Boolean)attributes.get(
				"enableMemberUpdate");

		if (enableMemberUpdate != null) {
			setEnableMemberUpdate(enableMemberUpdate);
		}

		Boolean enableDiscussionUpdate = (Boolean)attributes.get(
				"enableDiscussionUpdate");

		if (enableDiscussionUpdate != null) {
			setEnableDiscussionUpdate(enableDiscussionUpdate);
		}

		String updateFrequency = (String)attributes.get("updateFrequency");

		if (updateFrequency != null) {
			setUpdateFrequency(updateFrequency);
		}
	}

	/**
	* Returns the primary key of this s p group pref.
	*
	* @return the primary key of this s p group pref
	*/
	@Override
	public long getPrimaryKey() {
		return _spGroupPref.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p group pref.
	*
	* @param primaryKey the primary key of this s p group pref
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spGroupPref.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp group pref ID of this s p group pref.
	*
	* @return the sp group pref ID of this s p group pref
	*/
	@Override
	public long getSpGroupPrefId() {
		return _spGroupPref.getSpGroupPrefId();
	}

	/**
	* Sets the sp group pref ID of this s p group pref.
	*
	* @param spGroupPrefId the sp group pref ID of this s p group pref
	*/
	@Override
	public void setSpGroupPrefId(long spGroupPrefId) {
		_spGroupPref.setSpGroupPrefId(spGroupPrefId);
	}

	/**
	* Returns the group ID of this s p group pref.
	*
	* @return the group ID of this s p group pref
	*/
	@Override
	public long getGroupId() {
		return _spGroupPref.getGroupId();
	}

	/**
	* Sets the group ID of this s p group pref.
	*
	* @param groupId the group ID of this s p group pref
	*/
	@Override
	public void setGroupId(long groupId) {
		_spGroupPref.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p group pref.
	*
	* @return the company ID of this s p group pref
	*/
	@Override
	public long getCompanyId() {
		return _spGroupPref.getCompanyId();
	}

	/**
	* Sets the company ID of this s p group pref.
	*
	* @param companyId the company ID of this s p group pref
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spGroupPref.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p group pref.
	*
	* @return the user ID of this s p group pref
	*/
	@Override
	public long getUserId() {
		return _spGroupPref.getUserId();
	}

	/**
	* Sets the user ID of this s p group pref.
	*
	* @param userId the user ID of this s p group pref
	*/
	@Override
	public void setUserId(long userId) {
		_spGroupPref.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p group pref.
	*
	* @return the user uuid of this s p group pref
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupPref.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p group pref.
	*
	* @param userUuid the user uuid of this s p group pref
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spGroupPref.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p group pref.
	*
	* @return the user name of this s p group pref
	*/
	@Override
	public java.lang.String getUserName() {
		return _spGroupPref.getUserName();
	}

	/**
	* Sets the user name of this s p group pref.
	*
	* @param userName the user name of this s p group pref
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spGroupPref.setUserName(userName);
	}

	/**
	* Returns the create date of this s p group pref.
	*
	* @return the create date of this s p group pref
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spGroupPref.getCreateDate();
	}

	/**
	* Sets the create date of this s p group pref.
	*
	* @param createDate the create date of this s p group pref
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spGroupPref.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p group pref.
	*
	* @return the modified date of this s p group pref
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spGroupPref.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p group pref.
	*
	* @param modifiedDate the modified date of this s p group pref
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spGroupPref.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the d in of this s p group pref.
	*
	* @return the d in of this s p group pref
	*/
	@Override
	public boolean getDIn() {
		return _spGroupPref.getDIn();
	}

	/**
	* Returns <code>true</code> if this s p group pref is d in.
	*
	* @return <code>true</code> if this s p group pref is d in; <code>false</code> otherwise
	*/
	@Override
	public boolean isDIn() {
		return _spGroupPref.isDIn();
	}

	/**
	* Sets whether this s p group pref is d in.
	*
	* @param dIn the d in of this s p group pref
	*/
	@Override
	public void setDIn(boolean dIn) {
		_spGroupPref.setDIn(dIn);
	}

	/**
	* Returns the d google of this s p group pref.
	*
	* @return the d google of this s p group pref
	*/
	@Override
	public boolean getDGoogle() {
		return _spGroupPref.getDGoogle();
	}

	/**
	* Returns <code>true</code> if this s p group pref is d google.
	*
	* @return <code>true</code> if this s p group pref is d google; <code>false</code> otherwise
	*/
	@Override
	public boolean isDGoogle() {
		return _spGroupPref.isDGoogle();
	}

	/**
	* Sets whether this s p group pref is d google.
	*
	* @param dGoogle the d google of this s p group pref
	*/
	@Override
	public void setDGoogle(boolean dGoogle) {
		_spGroupPref.setDGoogle(dGoogle);
	}

	/**
	* Returns the d fb of this s p group pref.
	*
	* @return the d fb of this s p group pref
	*/
	@Override
	public boolean getDFb() {
		return _spGroupPref.getDFb();
	}

	/**
	* Returns <code>true</code> if this s p group pref is d fb.
	*
	* @return <code>true</code> if this s p group pref is d fb; <code>false</code> otherwise
	*/
	@Override
	public boolean isDFb() {
		return _spGroupPref.isDFb();
	}

	/**
	* Sets whether this s p group pref is d fb.
	*
	* @param dFb the d fb of this s p group pref
	*/
	@Override
	public void setDFb(boolean dFb) {
		_spGroupPref.setDFb(dFb);
	}

	/**
	* Returns the d tw of this s p group pref.
	*
	* @return the d tw of this s p group pref
	*/
	@Override
	public boolean getDTw() {
		return _spGroupPref.getDTw();
	}

	/**
	* Returns <code>true</code> if this s p group pref is d tw.
	*
	* @return <code>true</code> if this s p group pref is d tw; <code>false</code> otherwise
	*/
	@Override
	public boolean isDTw() {
		return _spGroupPref.isDTw();
	}

	/**
	* Sets whether this s p group pref is d tw.
	*
	* @param dTw the d tw of this s p group pref
	*/
	@Override
	public void setDTw(boolean dTw) {
		_spGroupPref.setDTw(dTw);
	}

	/**
	* Returns the c in of this s p group pref.
	*
	* @return the c in of this s p group pref
	*/
	@Override
	public boolean getCIn() {
		return _spGroupPref.getCIn();
	}

	/**
	* Returns <code>true</code> if this s p group pref is c in.
	*
	* @return <code>true</code> if this s p group pref is c in; <code>false</code> otherwise
	*/
	@Override
	public boolean isCIn() {
		return _spGroupPref.isCIn();
	}

	/**
	* Sets whether this s p group pref is c in.
	*
	* @param cIn the c in of this s p group pref
	*/
	@Override
	public void setCIn(boolean cIn) {
		_spGroupPref.setCIn(cIn);
	}

	/**
	* Returns the c google of this s p group pref.
	*
	* @return the c google of this s p group pref
	*/
	@Override
	public boolean getCGoogle() {
		return _spGroupPref.getCGoogle();
	}

	/**
	* Returns <code>true</code> if this s p group pref is c google.
	*
	* @return <code>true</code> if this s p group pref is c google; <code>false</code> otherwise
	*/
	@Override
	public boolean isCGoogle() {
		return _spGroupPref.isCGoogle();
	}

	/**
	* Sets whether this s p group pref is c google.
	*
	* @param cGoogle the c google of this s p group pref
	*/
	@Override
	public void setCGoogle(boolean cGoogle) {
		_spGroupPref.setCGoogle(cGoogle);
	}

	/**
	* Returns the c fb of this s p group pref.
	*
	* @return the c fb of this s p group pref
	*/
	@Override
	public boolean getCFb() {
		return _spGroupPref.getCFb();
	}

	/**
	* Returns <code>true</code> if this s p group pref is c fb.
	*
	* @return <code>true</code> if this s p group pref is c fb; <code>false</code> otherwise
	*/
	@Override
	public boolean isCFb() {
		return _spGroupPref.isCFb();
	}

	/**
	* Sets whether this s p group pref is c fb.
	*
	* @param cFb the c fb of this s p group pref
	*/
	@Override
	public void setCFb(boolean cFb) {
		_spGroupPref.setCFb(cFb);
	}

	/**
	* Returns the c tw of this s p group pref.
	*
	* @return the c tw of this s p group pref
	*/
	@Override
	public boolean getCTw() {
		return _spGroupPref.getCTw();
	}

	/**
	* Returns <code>true</code> if this s p group pref is c tw.
	*
	* @return <code>true</code> if this s p group pref is c tw; <code>false</code> otherwise
	*/
	@Override
	public boolean isCTw() {
		return _spGroupPref.isCTw();
	}

	/**
	* Sets whether this s p group pref is c tw.
	*
	* @param cTw the c tw of this s p group pref
	*/
	@Override
	public void setCTw(boolean cTw) {
		_spGroupPref.setCTw(cTw);
	}

	/**
	* Returns the enable subscribe to comments of this s p group pref.
	*
	* @return the enable subscribe to comments of this s p group pref
	*/
	@Override
	public boolean getEnableSubscribeToComments() {
		return _spGroupPref.getEnableSubscribeToComments();
	}

	/**
	* Returns <code>true</code> if this s p group pref is enable subscribe to comments.
	*
	* @return <code>true</code> if this s p group pref is enable subscribe to comments; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnableSubscribeToComments() {
		return _spGroupPref.isEnableSubscribeToComments();
	}

	/**
	* Sets whether this s p group pref is enable subscribe to comments.
	*
	* @param enableSubscribeToComments the enable subscribe to comments of this s p group pref
	*/
	@Override
	public void setEnableSubscribeToComments(boolean enableSubscribeToComments) {
		_spGroupPref.setEnableSubscribeToComments(enableSubscribeToComments);
	}

	/**
	* Returns the enable group update notification of this s p group pref.
	*
	* @return the enable group update notification of this s p group pref
	*/
	@Override
	public boolean getEnableGroupUpdateNotification() {
		return _spGroupPref.getEnableGroupUpdateNotification();
	}

	/**
	* Returns <code>true</code> if this s p group pref is enable group update notification.
	*
	* @return <code>true</code> if this s p group pref is enable group update notification; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnableGroupUpdateNotification() {
		return _spGroupPref.isEnableGroupUpdateNotification();
	}

	/**
	* Sets whether this s p group pref is enable group update notification.
	*
	* @param enableGroupUpdateNotification the enable group update notification of this s p group pref
	*/
	@Override
	public void setEnableGroupUpdateNotification(
		boolean enableGroupUpdateNotification) {
		_spGroupPref.setEnableGroupUpdateNotification(enableGroupUpdateNotification);
	}

	/**
	* Returns the enable member update of this s p group pref.
	*
	* @return the enable member update of this s p group pref
	*/
	@Override
	public boolean getEnableMemberUpdate() {
		return _spGroupPref.getEnableMemberUpdate();
	}

	/**
	* Returns <code>true</code> if this s p group pref is enable member update.
	*
	* @return <code>true</code> if this s p group pref is enable member update; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnableMemberUpdate() {
		return _spGroupPref.isEnableMemberUpdate();
	}

	/**
	* Sets whether this s p group pref is enable member update.
	*
	* @param enableMemberUpdate the enable member update of this s p group pref
	*/
	@Override
	public void setEnableMemberUpdate(boolean enableMemberUpdate) {
		_spGroupPref.setEnableMemberUpdate(enableMemberUpdate);
	}

	/**
	* Returns the enable discussion update of this s p group pref.
	*
	* @return the enable discussion update of this s p group pref
	*/
	@Override
	public boolean getEnableDiscussionUpdate() {
		return _spGroupPref.getEnableDiscussionUpdate();
	}

	/**
	* Returns <code>true</code> if this s p group pref is enable discussion update.
	*
	* @return <code>true</code> if this s p group pref is enable discussion update; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnableDiscussionUpdate() {
		return _spGroupPref.isEnableDiscussionUpdate();
	}

	/**
	* Sets whether this s p group pref is enable discussion update.
	*
	* @param enableDiscussionUpdate the enable discussion update of this s p group pref
	*/
	@Override
	public void setEnableDiscussionUpdate(boolean enableDiscussionUpdate) {
		_spGroupPref.setEnableDiscussionUpdate(enableDiscussionUpdate);
	}

	/**
	* Returns the update frequency of this s p group pref.
	*
	* @return the update frequency of this s p group pref
	*/
	@Override
	public java.lang.String getUpdateFrequency() {
		return _spGroupPref.getUpdateFrequency();
	}

	/**
	* Sets the update frequency of this s p group pref.
	*
	* @param updateFrequency the update frequency of this s p group pref
	*/
	@Override
	public void setUpdateFrequency(java.lang.String updateFrequency) {
		_spGroupPref.setUpdateFrequency(updateFrequency);
	}

	@Override
	public boolean isNew() {
		return _spGroupPref.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spGroupPref.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spGroupPref.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spGroupPref.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spGroupPref.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spGroupPref.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spGroupPref.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spGroupPref.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spGroupPref.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spGroupPref.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spGroupPref.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPGroupPrefWrapper((SPGroupPref)_spGroupPref.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spgroup.model.SPGroupPref spGroupPref) {
		return _spGroupPref.compareTo(spGroupPref);
	}

	@Override
	public int hashCode() {
		return _spGroupPref.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spgroup.model.SPGroupPref> toCacheModel() {
		return _spGroupPref.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupPref toEscapedModel() {
		return new SPGroupPrefWrapper(_spGroupPref.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupPref toUnescapedModel() {
		return new SPGroupPrefWrapper(_spGroupPref.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spGroupPref.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spGroupPref.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spGroupPref.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPGroupPrefWrapper)) {
			return false;
		}

		SPGroupPrefWrapper spGroupPrefWrapper = (SPGroupPrefWrapper)obj;

		if (Validator.equals(_spGroupPref, spGroupPrefWrapper._spGroupPref)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPGroupPref getWrappedSPGroupPref() {
		return _spGroupPref;
	}

	@Override
	public SPGroupPref getWrappedModel() {
		return _spGroupPref;
	}

	@Override
	public void resetOriginalValues() {
		_spGroupPref.resetOriginalValues();
	}

	private SPGroupPref _spGroupPref;
}