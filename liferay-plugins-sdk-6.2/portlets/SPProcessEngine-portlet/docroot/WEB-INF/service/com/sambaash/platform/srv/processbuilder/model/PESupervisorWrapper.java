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

package com.sambaash.platform.srv.processbuilder.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PESupervisor}.
 * </p>
 *
 * @author nareshchebolu
 * @see PESupervisor
 * @generated
 */
public class PESupervisorWrapper implements PESupervisor,
	ModelWrapper<PESupervisor> {
	public PESupervisorWrapper(PESupervisor peSupervisor) {
		_peSupervisor = peSupervisor;
	}

	@Override
	public Class<?> getModelClass() {
		return PESupervisor.class;
	}

	@Override
	public String getModelClassName() {
		return PESupervisor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPESupervisorId", getSpPESupervisorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("filter1", getFilter1());
		attributes.put("filter2", getFilter2());
		attributes.put("filter3", getFilter3());
		attributes.put("filter4", getFilter4());
		attributes.put("filter5", getFilter5());
		attributes.put("supervisorId", getSupervisorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPESupervisorId = (Long)attributes.get("spPESupervisorId");

		if (spPESupervisorId != null) {
			setSpPESupervisorId(spPESupervisorId);
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

		String filter1 = (String)attributes.get("filter1");

		if (filter1 != null) {
			setFilter1(filter1);
		}

		String filter2 = (String)attributes.get("filter2");

		if (filter2 != null) {
			setFilter2(filter2);
		}

		String filter3 = (String)attributes.get("filter3");

		if (filter3 != null) {
			setFilter3(filter3);
		}

		String filter4 = (String)attributes.get("filter4");

		if (filter4 != null) {
			setFilter4(filter4);
		}

		String filter5 = (String)attributes.get("filter5");

		if (filter5 != null) {
			setFilter5(filter5);
		}

		Long supervisorId = (Long)attributes.get("supervisorId");

		if (supervisorId != null) {
			setSupervisorId(supervisorId);
		}
	}

	/**
	* Returns the primary key of this p e supervisor.
	*
	* @return the primary key of this p e supervisor
	*/
	@Override
	public long getPrimaryKey() {
		return _peSupervisor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e supervisor.
	*
	* @param primaryKey the primary key of this p e supervisor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peSupervisor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp p e supervisor ID of this p e supervisor.
	*
	* @return the sp p e supervisor ID of this p e supervisor
	*/
	@Override
	public long getSpPESupervisorId() {
		return _peSupervisor.getSpPESupervisorId();
	}

	/**
	* Sets the sp p e supervisor ID of this p e supervisor.
	*
	* @param spPESupervisorId the sp p e supervisor ID of this p e supervisor
	*/
	@Override
	public void setSpPESupervisorId(long spPESupervisorId) {
		_peSupervisor.setSpPESupervisorId(spPESupervisorId);
	}

	/**
	* Returns the group ID of this p e supervisor.
	*
	* @return the group ID of this p e supervisor
	*/
	@Override
	public long getGroupId() {
		return _peSupervisor.getGroupId();
	}

	/**
	* Sets the group ID of this p e supervisor.
	*
	* @param groupId the group ID of this p e supervisor
	*/
	@Override
	public void setGroupId(long groupId) {
		_peSupervisor.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this p e supervisor.
	*
	* @return the company ID of this p e supervisor
	*/
	@Override
	public long getCompanyId() {
		return _peSupervisor.getCompanyId();
	}

	/**
	* Sets the company ID of this p e supervisor.
	*
	* @param companyId the company ID of this p e supervisor
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peSupervisor.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this p e supervisor.
	*
	* @return the user ID of this p e supervisor
	*/
	@Override
	public long getUserId() {
		return _peSupervisor.getUserId();
	}

	/**
	* Sets the user ID of this p e supervisor.
	*
	* @param userId the user ID of this p e supervisor
	*/
	@Override
	public void setUserId(long userId) {
		_peSupervisor.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e supervisor.
	*
	* @return the user uuid of this p e supervisor
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peSupervisor.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e supervisor.
	*
	* @param userUuid the user uuid of this p e supervisor
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peSupervisor.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this p e supervisor.
	*
	* @return the user name of this p e supervisor
	*/
	@Override
	public java.lang.String getUserName() {
		return _peSupervisor.getUserName();
	}

	/**
	* Sets the user name of this p e supervisor.
	*
	* @param userName the user name of this p e supervisor
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peSupervisor.setUserName(userName);
	}

	/**
	* Returns the create date of this p e supervisor.
	*
	* @return the create date of this p e supervisor
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peSupervisor.getCreateDate();
	}

	/**
	* Sets the create date of this p e supervisor.
	*
	* @param createDate the create date of this p e supervisor
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peSupervisor.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e supervisor.
	*
	* @return the modified date of this p e supervisor
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peSupervisor.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e supervisor.
	*
	* @param modifiedDate the modified date of this p e supervisor
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peSupervisor.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the filter1 of this p e supervisor.
	*
	* @return the filter1 of this p e supervisor
	*/
	@Override
	public java.lang.String getFilter1() {
		return _peSupervisor.getFilter1();
	}

	/**
	* Sets the filter1 of this p e supervisor.
	*
	* @param filter1 the filter1 of this p e supervisor
	*/
	@Override
	public void setFilter1(java.lang.String filter1) {
		_peSupervisor.setFilter1(filter1);
	}

	/**
	* Returns the filter2 of this p e supervisor.
	*
	* @return the filter2 of this p e supervisor
	*/
	@Override
	public java.lang.String getFilter2() {
		return _peSupervisor.getFilter2();
	}

	/**
	* Sets the filter2 of this p e supervisor.
	*
	* @param filter2 the filter2 of this p e supervisor
	*/
	@Override
	public void setFilter2(java.lang.String filter2) {
		_peSupervisor.setFilter2(filter2);
	}

	/**
	* Returns the filter3 of this p e supervisor.
	*
	* @return the filter3 of this p e supervisor
	*/
	@Override
	public java.lang.String getFilter3() {
		return _peSupervisor.getFilter3();
	}

	/**
	* Sets the filter3 of this p e supervisor.
	*
	* @param filter3 the filter3 of this p e supervisor
	*/
	@Override
	public void setFilter3(java.lang.String filter3) {
		_peSupervisor.setFilter3(filter3);
	}

	/**
	* Returns the filter4 of this p e supervisor.
	*
	* @return the filter4 of this p e supervisor
	*/
	@Override
	public java.lang.String getFilter4() {
		return _peSupervisor.getFilter4();
	}

	/**
	* Sets the filter4 of this p e supervisor.
	*
	* @param filter4 the filter4 of this p e supervisor
	*/
	@Override
	public void setFilter4(java.lang.String filter4) {
		_peSupervisor.setFilter4(filter4);
	}

	/**
	* Returns the filter5 of this p e supervisor.
	*
	* @return the filter5 of this p e supervisor
	*/
	@Override
	public java.lang.String getFilter5() {
		return _peSupervisor.getFilter5();
	}

	/**
	* Sets the filter5 of this p e supervisor.
	*
	* @param filter5 the filter5 of this p e supervisor
	*/
	@Override
	public void setFilter5(java.lang.String filter5) {
		_peSupervisor.setFilter5(filter5);
	}

	/**
	* Returns the supervisor ID of this p e supervisor.
	*
	* @return the supervisor ID of this p e supervisor
	*/
	@Override
	public long getSupervisorId() {
		return _peSupervisor.getSupervisorId();
	}

	/**
	* Sets the supervisor ID of this p e supervisor.
	*
	* @param supervisorId the supervisor ID of this p e supervisor
	*/
	@Override
	public void setSupervisorId(long supervisorId) {
		_peSupervisor.setSupervisorId(supervisorId);
	}

	@Override
	public boolean isNew() {
		return _peSupervisor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peSupervisor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peSupervisor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peSupervisor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peSupervisor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peSupervisor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peSupervisor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peSupervisor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peSupervisor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peSupervisor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peSupervisor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PESupervisorWrapper((PESupervisor)_peSupervisor.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PESupervisor peSupervisor) {
		return _peSupervisor.compareTo(peSupervisor);
	}

	@Override
	public int hashCode() {
		return _peSupervisor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PESupervisor> toCacheModel() {
		return _peSupervisor.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor toEscapedModel() {
		return new PESupervisorWrapper(_peSupervisor.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PESupervisor toUnescapedModel() {
		return new PESupervisorWrapper(_peSupervisor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peSupervisor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peSupervisor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peSupervisor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PESupervisorWrapper)) {
			return false;
		}

		PESupervisorWrapper peSupervisorWrapper = (PESupervisorWrapper)obj;

		if (Validator.equals(_peSupervisor, peSupervisorWrapper._peSupervisor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PESupervisor getWrappedPESupervisor() {
		return _peSupervisor;
	}

	@Override
	public PESupervisor getWrappedModel() {
		return _peSupervisor;
	}

	@Override
	public void resetOriginalValues() {
		_peSupervisor.resetOriginalValues();
	}

	private PESupervisor _peSupervisor;
}