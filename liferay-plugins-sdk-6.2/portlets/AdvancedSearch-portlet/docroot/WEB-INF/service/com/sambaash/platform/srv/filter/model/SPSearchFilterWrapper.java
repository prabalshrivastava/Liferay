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

package com.sambaash.platform.srv.filter.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPSearchFilter}.
 * </p>
 *
 * @author harini
 * @see SPSearchFilter
 * @generated
 */
public class SPSearchFilterWrapper implements SPSearchFilter,
	ModelWrapper<SPSearchFilter> {
	public SPSearchFilterWrapper(SPSearchFilter spSearchFilter) {
		_spSearchFilter = spSearchFilter;
	}

	@Override
	public Class<?> getModelClass() {
		return SPSearchFilter.class;
	}

	@Override
	public String getModelClassName() {
		return SPSearchFilter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spSearchFilterId", getSpSearchFilterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("filterName", getFilterName());
		attributes.put("filterParameter", getFilterParameter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spSearchFilterId = (Long)attributes.get("spSearchFilterId");

		if (spSearchFilterId != null) {
			setSpSearchFilterId(spSearchFilterId);
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

		String filterName = (String)attributes.get("filterName");

		if (filterName != null) {
			setFilterName(filterName);
		}

		String filterParameter = (String)attributes.get("filterParameter");

		if (filterParameter != null) {
			setFilterParameter(filterParameter);
		}
	}

	/**
	* Returns the primary key of this s p search filter.
	*
	* @return the primary key of this s p search filter
	*/
	@Override
	public long getPrimaryKey() {
		return _spSearchFilter.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p search filter.
	*
	* @param primaryKey the primary key of this s p search filter
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spSearchFilter.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p search filter.
	*
	* @return the uuid of this s p search filter
	*/
	@Override
	public java.lang.String getUuid() {
		return _spSearchFilter.getUuid();
	}

	/**
	* Sets the uuid of this s p search filter.
	*
	* @param uuid the uuid of this s p search filter
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spSearchFilter.setUuid(uuid);
	}

	/**
	* Returns the sp search filter ID of this s p search filter.
	*
	* @return the sp search filter ID of this s p search filter
	*/
	@Override
	public long getSpSearchFilterId() {
		return _spSearchFilter.getSpSearchFilterId();
	}

	/**
	* Sets the sp search filter ID of this s p search filter.
	*
	* @param spSearchFilterId the sp search filter ID of this s p search filter
	*/
	@Override
	public void setSpSearchFilterId(long spSearchFilterId) {
		_spSearchFilter.setSpSearchFilterId(spSearchFilterId);
	}

	/**
	* Returns the group ID of this s p search filter.
	*
	* @return the group ID of this s p search filter
	*/
	@Override
	public long getGroupId() {
		return _spSearchFilter.getGroupId();
	}

	/**
	* Sets the group ID of this s p search filter.
	*
	* @param groupId the group ID of this s p search filter
	*/
	@Override
	public void setGroupId(long groupId) {
		_spSearchFilter.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p search filter.
	*
	* @return the company ID of this s p search filter
	*/
	@Override
	public long getCompanyId() {
		return _spSearchFilter.getCompanyId();
	}

	/**
	* Sets the company ID of this s p search filter.
	*
	* @param companyId the company ID of this s p search filter
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spSearchFilter.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p search filter.
	*
	* @return the user ID of this s p search filter
	*/
	@Override
	public long getUserId() {
		return _spSearchFilter.getUserId();
	}

	/**
	* Sets the user ID of this s p search filter.
	*
	* @param userId the user ID of this s p search filter
	*/
	@Override
	public void setUserId(long userId) {
		_spSearchFilter.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p search filter.
	*
	* @return the user uuid of this s p search filter
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSearchFilter.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p search filter.
	*
	* @param userUuid the user uuid of this s p search filter
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spSearchFilter.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p search filter.
	*
	* @return the user name of this s p search filter
	*/
	@Override
	public java.lang.String getUserName() {
		return _spSearchFilter.getUserName();
	}

	/**
	* Sets the user name of this s p search filter.
	*
	* @param userName the user name of this s p search filter
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spSearchFilter.setUserName(userName);
	}

	/**
	* Returns the create date of this s p search filter.
	*
	* @return the create date of this s p search filter
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spSearchFilter.getCreateDate();
	}

	/**
	* Sets the create date of this s p search filter.
	*
	* @param createDate the create date of this s p search filter
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spSearchFilter.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p search filter.
	*
	* @return the modified date of this s p search filter
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spSearchFilter.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p search filter.
	*
	* @param modifiedDate the modified date of this s p search filter
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spSearchFilter.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the filter name of this s p search filter.
	*
	* @return the filter name of this s p search filter
	*/
	@Override
	public java.lang.String getFilterName() {
		return _spSearchFilter.getFilterName();
	}

	/**
	* Sets the filter name of this s p search filter.
	*
	* @param filterName the filter name of this s p search filter
	*/
	@Override
	public void setFilterName(java.lang.String filterName) {
		_spSearchFilter.setFilterName(filterName);
	}

	/**
	* Returns the filter parameter of this s p search filter.
	*
	* @return the filter parameter of this s p search filter
	*/
	@Override
	public java.lang.String getFilterParameter() {
		return _spSearchFilter.getFilterParameter();
	}

	/**
	* Sets the filter parameter of this s p search filter.
	*
	* @param filterParameter the filter parameter of this s p search filter
	*/
	@Override
	public void setFilterParameter(java.lang.String filterParameter) {
		_spSearchFilter.setFilterParameter(filterParameter);
	}

	@Override
	public boolean isNew() {
		return _spSearchFilter.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spSearchFilter.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spSearchFilter.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spSearchFilter.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spSearchFilter.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spSearchFilter.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spSearchFilter.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spSearchFilter.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spSearchFilter.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spSearchFilter.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spSearchFilter.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPSearchFilterWrapper((SPSearchFilter)_spSearchFilter.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.filter.model.SPSearchFilter spSearchFilter) {
		return _spSearchFilter.compareTo(spSearchFilter);
	}

	@Override
	public int hashCode() {
		return _spSearchFilter.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.filter.model.SPSearchFilter> toCacheModel() {
		return _spSearchFilter.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.filter.model.SPSearchFilter toEscapedModel() {
		return new SPSearchFilterWrapper(_spSearchFilter.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.filter.model.SPSearchFilter toUnescapedModel() {
		return new SPSearchFilterWrapper(_spSearchFilter.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spSearchFilter.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spSearchFilter.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spSearchFilter.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPSearchFilterWrapper)) {
			return false;
		}

		SPSearchFilterWrapper spSearchFilterWrapper = (SPSearchFilterWrapper)obj;

		if (Validator.equals(_spSearchFilter,
					spSearchFilterWrapper._spSearchFilter)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spSearchFilter.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPSearchFilter getWrappedSPSearchFilter() {
		return _spSearchFilter;
	}

	@Override
	public SPSearchFilter getWrappedModel() {
		return _spSearchFilter;
	}

	@Override
	public void resetOriginalValues() {
		_spSearchFilter.resetOriginalValues();
	}

	private SPSearchFilter _spSearchFilter;
}