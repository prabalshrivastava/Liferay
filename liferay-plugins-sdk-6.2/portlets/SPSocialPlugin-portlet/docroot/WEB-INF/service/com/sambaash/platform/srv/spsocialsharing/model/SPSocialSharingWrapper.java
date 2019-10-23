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

package com.sambaash.platform.srv.spsocialsharing.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPSocialSharing}.
 * </p>
 *
 * @author harini
 * @see SPSocialSharing
 * @generated
 */
public class SPSocialSharingWrapper implements SPSocialSharing,
	ModelWrapper<SPSocialSharing> {
	public SPSocialSharingWrapper(SPSocialSharing spSocialSharing) {
		_spSocialSharing = spSocialSharing;
	}

	@Override
	public Class<?> getModelClass() {
		return SPSocialSharing.class;
	}

	@Override
	public String getModelClassName() {
		return SPSocialSharing.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spSocialSharingId", getSpSocialSharingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("facebook", getFacebook());
		attributes.put("twitter", getTwitter());
		attributes.put("linkedin", getLinkedin());
		attributes.put("yahoo", getYahoo());
		attributes.put("google", getGoogle());
		attributes.put("facebookPage", getFacebookPage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spSocialSharingId = (Long)attributes.get("spSocialSharingId");

		if (spSocialSharingId != null) {
			setSpSocialSharingId(spSocialSharingId);
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

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Integer facebook = (Integer)attributes.get("facebook");

		if (facebook != null) {
			setFacebook(facebook);
		}

		Integer twitter = (Integer)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}

		Integer linkedin = (Integer)attributes.get("linkedin");

		if (linkedin != null) {
			setLinkedin(linkedin);
		}

		Integer yahoo = (Integer)attributes.get("yahoo");

		if (yahoo != null) {
			setYahoo(yahoo);
		}

		Integer google = (Integer)attributes.get("google");

		if (google != null) {
			setGoogle(google);
		}

		Integer facebookPage = (Integer)attributes.get("facebookPage");

		if (facebookPage != null) {
			setFacebookPage(facebookPage);
		}
	}

	/**
	* Returns the primary key of this s p social sharing.
	*
	* @return the primary key of this s p social sharing
	*/
	@Override
	public long getPrimaryKey() {
		return _spSocialSharing.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p social sharing.
	*
	* @param primaryKey the primary key of this s p social sharing
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spSocialSharing.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p social sharing.
	*
	* @return the uuid of this s p social sharing
	*/
	@Override
	public java.lang.String getUuid() {
		return _spSocialSharing.getUuid();
	}

	/**
	* Sets the uuid of this s p social sharing.
	*
	* @param uuid the uuid of this s p social sharing
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spSocialSharing.setUuid(uuid);
	}

	/**
	* Returns the sp social sharing ID of this s p social sharing.
	*
	* @return the sp social sharing ID of this s p social sharing
	*/
	@Override
	public long getSpSocialSharingId() {
		return _spSocialSharing.getSpSocialSharingId();
	}

	/**
	* Sets the sp social sharing ID of this s p social sharing.
	*
	* @param spSocialSharingId the sp social sharing ID of this s p social sharing
	*/
	@Override
	public void setSpSocialSharingId(long spSocialSharingId) {
		_spSocialSharing.setSpSocialSharingId(spSocialSharingId);
	}

	/**
	* Returns the group ID of this s p social sharing.
	*
	* @return the group ID of this s p social sharing
	*/
	@Override
	public long getGroupId() {
		return _spSocialSharing.getGroupId();
	}

	/**
	* Sets the group ID of this s p social sharing.
	*
	* @param groupId the group ID of this s p social sharing
	*/
	@Override
	public void setGroupId(long groupId) {
		_spSocialSharing.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p social sharing.
	*
	* @return the company ID of this s p social sharing
	*/
	@Override
	public long getCompanyId() {
		return _spSocialSharing.getCompanyId();
	}

	/**
	* Sets the company ID of this s p social sharing.
	*
	* @param companyId the company ID of this s p social sharing
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spSocialSharing.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p social sharing.
	*
	* @return the user ID of this s p social sharing
	*/
	@Override
	public long getUserId() {
		return _spSocialSharing.getUserId();
	}

	/**
	* Sets the user ID of this s p social sharing.
	*
	* @param userId the user ID of this s p social sharing
	*/
	@Override
	public void setUserId(long userId) {
		_spSocialSharing.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p social sharing.
	*
	* @return the user uuid of this s p social sharing
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSocialSharing.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p social sharing.
	*
	* @param userUuid the user uuid of this s p social sharing
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spSocialSharing.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p social sharing.
	*
	* @return the user name of this s p social sharing
	*/
	@Override
	public java.lang.String getUserName() {
		return _spSocialSharing.getUserName();
	}

	/**
	* Sets the user name of this s p social sharing.
	*
	* @param userName the user name of this s p social sharing
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spSocialSharing.setUserName(userName);
	}

	/**
	* Returns the create date of this s p social sharing.
	*
	* @return the create date of this s p social sharing
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spSocialSharing.getCreateDate();
	}

	/**
	* Sets the create date of this s p social sharing.
	*
	* @param createDate the create date of this s p social sharing
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spSocialSharing.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p social sharing.
	*
	* @return the modified date of this s p social sharing
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spSocialSharing.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p social sharing.
	*
	* @param modifiedDate the modified date of this s p social sharing
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spSocialSharing.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fully qualified class name of this s p social sharing.
	*
	* @return the fully qualified class name of this s p social sharing
	*/
	@Override
	public java.lang.String getClassName() {
		return _spSocialSharing.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_spSocialSharing.setClassName(className);
	}

	/**
	* Returns the class name ID of this s p social sharing.
	*
	* @return the class name ID of this s p social sharing
	*/
	@Override
	public long getClassNameId() {
		return _spSocialSharing.getClassNameId();
	}

	/**
	* Sets the class name ID of this s p social sharing.
	*
	* @param classNameId the class name ID of this s p social sharing
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_spSocialSharing.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this s p social sharing.
	*
	* @return the class p k of this s p social sharing
	*/
	@Override
	public long getClassPK() {
		return _spSocialSharing.getClassPK();
	}

	/**
	* Sets the class p k of this s p social sharing.
	*
	* @param classPK the class p k of this s p social sharing
	*/
	@Override
	public void setClassPK(long classPK) {
		_spSocialSharing.setClassPK(classPK);
	}

	/**
	* Returns the facebook of this s p social sharing.
	*
	* @return the facebook of this s p social sharing
	*/
	@Override
	public int getFacebook() {
		return _spSocialSharing.getFacebook();
	}

	/**
	* Sets the facebook of this s p social sharing.
	*
	* @param facebook the facebook of this s p social sharing
	*/
	@Override
	public void setFacebook(int facebook) {
		_spSocialSharing.setFacebook(facebook);
	}

	/**
	* Returns the twitter of this s p social sharing.
	*
	* @return the twitter of this s p social sharing
	*/
	@Override
	public int getTwitter() {
		return _spSocialSharing.getTwitter();
	}

	/**
	* Sets the twitter of this s p social sharing.
	*
	* @param twitter the twitter of this s p social sharing
	*/
	@Override
	public void setTwitter(int twitter) {
		_spSocialSharing.setTwitter(twitter);
	}

	/**
	* Returns the linkedin of this s p social sharing.
	*
	* @return the linkedin of this s p social sharing
	*/
	@Override
	public int getLinkedin() {
		return _spSocialSharing.getLinkedin();
	}

	/**
	* Sets the linkedin of this s p social sharing.
	*
	* @param linkedin the linkedin of this s p social sharing
	*/
	@Override
	public void setLinkedin(int linkedin) {
		_spSocialSharing.setLinkedin(linkedin);
	}

	/**
	* Returns the yahoo of this s p social sharing.
	*
	* @return the yahoo of this s p social sharing
	*/
	@Override
	public int getYahoo() {
		return _spSocialSharing.getYahoo();
	}

	/**
	* Sets the yahoo of this s p social sharing.
	*
	* @param yahoo the yahoo of this s p social sharing
	*/
	@Override
	public void setYahoo(int yahoo) {
		_spSocialSharing.setYahoo(yahoo);
	}

	/**
	* Returns the google of this s p social sharing.
	*
	* @return the google of this s p social sharing
	*/
	@Override
	public int getGoogle() {
		return _spSocialSharing.getGoogle();
	}

	/**
	* Sets the google of this s p social sharing.
	*
	* @param google the google of this s p social sharing
	*/
	@Override
	public void setGoogle(int google) {
		_spSocialSharing.setGoogle(google);
	}

	/**
	* Returns the facebook page of this s p social sharing.
	*
	* @return the facebook page of this s p social sharing
	*/
	@Override
	public int getFacebookPage() {
		return _spSocialSharing.getFacebookPage();
	}

	/**
	* Sets the facebook page of this s p social sharing.
	*
	* @param facebookPage the facebook page of this s p social sharing
	*/
	@Override
	public void setFacebookPage(int facebookPage) {
		_spSocialSharing.setFacebookPage(facebookPage);
	}

	@Override
	public boolean isNew() {
		return _spSocialSharing.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spSocialSharing.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spSocialSharing.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spSocialSharing.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spSocialSharing.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spSocialSharing.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spSocialSharing.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spSocialSharing.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spSocialSharing.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spSocialSharing.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spSocialSharing.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPSocialSharingWrapper((SPSocialSharing)_spSocialSharing.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing) {
		return _spSocialSharing.compareTo(spSocialSharing);
	}

	@Override
	public int hashCode() {
		return _spSocialSharing.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing> toCacheModel() {
		return _spSocialSharing.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing toEscapedModel() {
		return new SPSocialSharingWrapper(_spSocialSharing.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing toUnescapedModel() {
		return new SPSocialSharingWrapper(_spSocialSharing.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spSocialSharing.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spSocialSharing.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spSocialSharing.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPSocialSharingWrapper)) {
			return false;
		}

		SPSocialSharingWrapper spSocialSharingWrapper = (SPSocialSharingWrapper)obj;

		if (Validator.equals(_spSocialSharing,
					spSocialSharingWrapper._spSocialSharing)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spSocialSharing.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPSocialSharing getWrappedSPSocialSharing() {
		return _spSocialSharing;
	}

	@Override
	public SPSocialSharing getWrappedModel() {
		return _spSocialSharing;
	}

	@Override
	public void resetOriginalValues() {
		_spSocialSharing.resetOriginalValues();
	}

	private SPSocialSharing _spSocialSharing;
}