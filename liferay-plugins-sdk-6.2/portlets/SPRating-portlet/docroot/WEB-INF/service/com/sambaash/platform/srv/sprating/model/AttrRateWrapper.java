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

package com.sambaash.platform.srv.sprating.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AttrRate}.
 * </p>
 *
 * @author harini
 * @see AttrRate
 * @generated
 */
public class AttrRateWrapper implements AttrRate, ModelWrapper<AttrRate> {
	public AttrRateWrapper(AttrRate attrRate) {
		_attrRate = attrRate;
	}

	@Override
	public Class<?> getModelClass() {
		return AttrRate.class;
	}

	@Override
	public String getModelClassName() {
		return AttrRate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spAttrRateId", getSpAttrRateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("objId", getObjId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("ratingAttrId", getRatingAttrId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spAttrRateId = (Long)attributes.get("spAttrRateId");

		if (spAttrRateId != null) {
			setSpAttrRateId(spAttrRateId);
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

		String objId = (String)attributes.get("objId");

		if (objId != null) {
			setObjId(objId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long ratingAttrId = (Long)attributes.get("ratingAttrId");

		if (ratingAttrId != null) {
			setRatingAttrId(ratingAttrId);
		}

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this attr rate.
	*
	* @return the primary key of this attr rate
	*/
	@Override
	public long getPrimaryKey() {
		return _attrRate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this attr rate.
	*
	* @param primaryKey the primary key of this attr rate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_attrRate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this attr rate.
	*
	* @return the uuid of this attr rate
	*/
	@Override
	public java.lang.String getUuid() {
		return _attrRate.getUuid();
	}

	/**
	* Sets the uuid of this attr rate.
	*
	* @param uuid the uuid of this attr rate
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_attrRate.setUuid(uuid);
	}

	/**
	* Returns the sp attr rate ID of this attr rate.
	*
	* @return the sp attr rate ID of this attr rate
	*/
	@Override
	public long getSpAttrRateId() {
		return _attrRate.getSpAttrRateId();
	}

	/**
	* Sets the sp attr rate ID of this attr rate.
	*
	* @param spAttrRateId the sp attr rate ID of this attr rate
	*/
	@Override
	public void setSpAttrRateId(long spAttrRateId) {
		_attrRate.setSpAttrRateId(spAttrRateId);
	}

	/**
	* Returns the group ID of this attr rate.
	*
	* @return the group ID of this attr rate
	*/
	@Override
	public long getGroupId() {
		return _attrRate.getGroupId();
	}

	/**
	* Sets the group ID of this attr rate.
	*
	* @param groupId the group ID of this attr rate
	*/
	@Override
	public void setGroupId(long groupId) {
		_attrRate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this attr rate.
	*
	* @return the company ID of this attr rate
	*/
	@Override
	public long getCompanyId() {
		return _attrRate.getCompanyId();
	}

	/**
	* Sets the company ID of this attr rate.
	*
	* @param companyId the company ID of this attr rate
	*/
	@Override
	public void setCompanyId(long companyId) {
		_attrRate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this attr rate.
	*
	* @return the user ID of this attr rate
	*/
	@Override
	public long getUserId() {
		return _attrRate.getUserId();
	}

	/**
	* Sets the user ID of this attr rate.
	*
	* @param userId the user ID of this attr rate
	*/
	@Override
	public void setUserId(long userId) {
		_attrRate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this attr rate.
	*
	* @return the user uuid of this attr rate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attrRate.getUserUuid();
	}

	/**
	* Sets the user uuid of this attr rate.
	*
	* @param userUuid the user uuid of this attr rate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_attrRate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this attr rate.
	*
	* @return the user name of this attr rate
	*/
	@Override
	public java.lang.String getUserName() {
		return _attrRate.getUserName();
	}

	/**
	* Sets the user name of this attr rate.
	*
	* @param userName the user name of this attr rate
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_attrRate.setUserName(userName);
	}

	/**
	* Returns the create date of this attr rate.
	*
	* @return the create date of this attr rate
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _attrRate.getCreateDate();
	}

	/**
	* Sets the create date of this attr rate.
	*
	* @param createDate the create date of this attr rate
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_attrRate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this attr rate.
	*
	* @return the modified date of this attr rate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _attrRate.getModifiedDate();
	}

	/**
	* Sets the modified date of this attr rate.
	*
	* @param modifiedDate the modified date of this attr rate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_attrRate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the obj ID of this attr rate.
	*
	* @return the obj ID of this attr rate
	*/
	@Override
	public java.lang.String getObjId() {
		return _attrRate.getObjId();
	}

	/**
	* Sets the obj ID of this attr rate.
	*
	* @param objId the obj ID of this attr rate
	*/
	@Override
	public void setObjId(java.lang.String objId) {
		_attrRate.setObjId(objId);
	}

	/**
	* Returns the fully qualified class name of this attr rate.
	*
	* @return the fully qualified class name of this attr rate
	*/
	@Override
	public java.lang.String getClassName() {
		return _attrRate.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_attrRate.setClassName(className);
	}

	/**
	* Returns the class name ID of this attr rate.
	*
	* @return the class name ID of this attr rate
	*/
	@Override
	public long getClassNameId() {
		return _attrRate.getClassNameId();
	}

	/**
	* Sets the class name ID of this attr rate.
	*
	* @param classNameId the class name ID of this attr rate
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_attrRate.setClassNameId(classNameId);
	}

	/**
	* Returns the rating attr ID of this attr rate.
	*
	* @return the rating attr ID of this attr rate
	*/
	@Override
	public long getRatingAttrId() {
		return _attrRate.getRatingAttrId();
	}

	/**
	* Sets the rating attr ID of this attr rate.
	*
	* @param ratingAttrId the rating attr ID of this attr rate
	*/
	@Override
	public void setRatingAttrId(long ratingAttrId) {
		_attrRate.setRatingAttrId(ratingAttrId);
	}

	/**
	* Returns the value of this attr rate.
	*
	* @return the value of this attr rate
	*/
	@Override
	public double getValue() {
		return _attrRate.getValue();
	}

	/**
	* Sets the value of this attr rate.
	*
	* @param value the value of this attr rate
	*/
	@Override
	public void setValue(double value) {
		_attrRate.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _attrRate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_attrRate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _attrRate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_attrRate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _attrRate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _attrRate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_attrRate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _attrRate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_attrRate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_attrRate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_attrRate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AttrRateWrapper((AttrRate)_attrRate.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.sprating.model.AttrRate attrRate) {
		return _attrRate.compareTo(attrRate);
	}

	@Override
	public int hashCode() {
		return _attrRate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.sprating.model.AttrRate> toCacheModel() {
		return _attrRate.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.sprating.model.AttrRate toEscapedModel() {
		return new AttrRateWrapper(_attrRate.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.sprating.model.AttrRate toUnescapedModel() {
		return new AttrRateWrapper(_attrRate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _attrRate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _attrRate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_attrRate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttrRateWrapper)) {
			return false;
		}

		AttrRateWrapper attrRateWrapper = (AttrRateWrapper)obj;

		if (Validator.equals(_attrRate, attrRateWrapper._attrRate)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _attrRate.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AttrRate getWrappedAttrRate() {
		return _attrRate;
	}

	@Override
	public AttrRate getWrappedModel() {
		return _attrRate;
	}

	@Override
	public void resetOriginalValues() {
		_attrRate.resetOriginalValues();
	}

	private AttrRate _attrRate;
}