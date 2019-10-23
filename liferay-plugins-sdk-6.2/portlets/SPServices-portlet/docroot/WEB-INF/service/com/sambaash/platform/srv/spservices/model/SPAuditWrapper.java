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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPAudit}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPAudit
 * @generated
 */
public class SPAuditWrapper implements SPAudit, ModelWrapper<SPAudit> {
	public SPAuditWrapper(SPAudit spAudit) {
		_spAudit = spAudit;
	}

	@Override
	public Class<?> getModelClass() {
		return SPAudit.class;
	}

	@Override
	public String getModelClassName() {
		return SPAudit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("SPAuditId", getSPAuditId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("doneByUserId", getDoneByUserId());
		attributes.put("entityClassNameId", getEntityClassNameId());
		attributes.put("entityId", getEntityId());
		attributes.put("action", getAction());
		attributes.put("field1Str", getField1Str());
		attributes.put("field1Long", getField1Long());
		attributes.put("field2Str", getField2Str());
		attributes.put("field2Long", getField2Long());
		attributes.put("data1", getData1());
		attributes.put("data2", getData2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long SPAuditId = (Long)attributes.get("SPAuditId");

		if (SPAuditId != null) {
			setSPAuditId(SPAuditId);
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

		Long doneByUserId = (Long)attributes.get("doneByUserId");

		if (doneByUserId != null) {
			setDoneByUserId(doneByUserId);
		}

		Long entityClassNameId = (Long)attributes.get("entityClassNameId");

		if (entityClassNameId != null) {
			setEntityClassNameId(entityClassNameId);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String field1Str = (String)attributes.get("field1Str");

		if (field1Str != null) {
			setField1Str(field1Str);
		}

		Long field1Long = (Long)attributes.get("field1Long");

		if (field1Long != null) {
			setField1Long(field1Long);
		}

		String field2Str = (String)attributes.get("field2Str");

		if (field2Str != null) {
			setField2Str(field2Str);
		}

		Long field2Long = (Long)attributes.get("field2Long");

		if (field2Long != null) {
			setField2Long(field2Long);
		}

		String data1 = (String)attributes.get("data1");

		if (data1 != null) {
			setData1(data1);
		}

		String data2 = (String)attributes.get("data2");

		if (data2 != null) {
			setData2(data2);
		}
	}

	/**
	* Returns the primary key of this s p audit.
	*
	* @return the primary key of this s p audit
	*/
	@Override
	public long getPrimaryKey() {
		return _spAudit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p audit.
	*
	* @param primaryKey the primary key of this s p audit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spAudit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p audit.
	*
	* @return the uuid of this s p audit
	*/
	@Override
	public java.lang.String getUuid() {
		return _spAudit.getUuid();
	}

	/**
	* Sets the uuid of this s p audit.
	*
	* @param uuid the uuid of this s p audit
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spAudit.setUuid(uuid);
	}

	/**
	* Returns the s p audit ID of this s p audit.
	*
	* @return the s p audit ID of this s p audit
	*/
	@Override
	public long getSPAuditId() {
		return _spAudit.getSPAuditId();
	}

	/**
	* Sets the s p audit ID of this s p audit.
	*
	* @param SPAuditId the s p audit ID of this s p audit
	*/
	@Override
	public void setSPAuditId(long SPAuditId) {
		_spAudit.setSPAuditId(SPAuditId);
	}

	/**
	* Returns the group ID of this s p audit.
	*
	* @return the group ID of this s p audit
	*/
	@Override
	public long getGroupId() {
		return _spAudit.getGroupId();
	}

	/**
	* Sets the group ID of this s p audit.
	*
	* @param groupId the group ID of this s p audit
	*/
	@Override
	public void setGroupId(long groupId) {
		_spAudit.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p audit.
	*
	* @return the company ID of this s p audit
	*/
	@Override
	public long getCompanyId() {
		return _spAudit.getCompanyId();
	}

	/**
	* Sets the company ID of this s p audit.
	*
	* @param companyId the company ID of this s p audit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spAudit.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p audit.
	*
	* @return the user ID of this s p audit
	*/
	@Override
	public long getUserId() {
		return _spAudit.getUserId();
	}

	/**
	* Sets the user ID of this s p audit.
	*
	* @param userId the user ID of this s p audit
	*/
	@Override
	public void setUserId(long userId) {
		_spAudit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p audit.
	*
	* @return the user uuid of this s p audit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAudit.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p audit.
	*
	* @param userUuid the user uuid of this s p audit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spAudit.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p audit.
	*
	* @return the user name of this s p audit
	*/
	@Override
	public java.lang.String getUserName() {
		return _spAudit.getUserName();
	}

	/**
	* Sets the user name of this s p audit.
	*
	* @param userName the user name of this s p audit
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spAudit.setUserName(userName);
	}

	/**
	* Returns the create date of this s p audit.
	*
	* @return the create date of this s p audit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spAudit.getCreateDate();
	}

	/**
	* Sets the create date of this s p audit.
	*
	* @param createDate the create date of this s p audit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spAudit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p audit.
	*
	* @return the modified date of this s p audit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spAudit.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p audit.
	*
	* @param modifiedDate the modified date of this s p audit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spAudit.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the done by user ID of this s p audit.
	*
	* @return the done by user ID of this s p audit
	*/
	@Override
	public long getDoneByUserId() {
		return _spAudit.getDoneByUserId();
	}

	/**
	* Sets the done by user ID of this s p audit.
	*
	* @param doneByUserId the done by user ID of this s p audit
	*/
	@Override
	public void setDoneByUserId(long doneByUserId) {
		_spAudit.setDoneByUserId(doneByUserId);
	}

	/**
	* Returns the done by user uuid of this s p audit.
	*
	* @return the done by user uuid of this s p audit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getDoneByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAudit.getDoneByUserUuid();
	}

	/**
	* Sets the done by user uuid of this s p audit.
	*
	* @param doneByUserUuid the done by user uuid of this s p audit
	*/
	@Override
	public void setDoneByUserUuid(java.lang.String doneByUserUuid) {
		_spAudit.setDoneByUserUuid(doneByUserUuid);
	}

	/**
	* Returns the entity class name ID of this s p audit.
	*
	* @return the entity class name ID of this s p audit
	*/
	@Override
	public long getEntityClassNameId() {
		return _spAudit.getEntityClassNameId();
	}

	/**
	* Sets the entity class name ID of this s p audit.
	*
	* @param entityClassNameId the entity class name ID of this s p audit
	*/
	@Override
	public void setEntityClassNameId(long entityClassNameId) {
		_spAudit.setEntityClassNameId(entityClassNameId);
	}

	/**
	* Returns the entity ID of this s p audit.
	*
	* @return the entity ID of this s p audit
	*/
	@Override
	public long getEntityId() {
		return _spAudit.getEntityId();
	}

	/**
	* Sets the entity ID of this s p audit.
	*
	* @param entityId the entity ID of this s p audit
	*/
	@Override
	public void setEntityId(long entityId) {
		_spAudit.setEntityId(entityId);
	}

	/**
	* Returns the action of this s p audit.
	*
	* @return the action of this s p audit
	*/
	@Override
	public java.lang.String getAction() {
		return _spAudit.getAction();
	}

	/**
	* Sets the action of this s p audit.
	*
	* @param action the action of this s p audit
	*/
	@Override
	public void setAction(java.lang.String action) {
		_spAudit.setAction(action);
	}

	/**
	* Returns the field1 str of this s p audit.
	*
	* @return the field1 str of this s p audit
	*/
	@Override
	public java.lang.String getField1Str() {
		return _spAudit.getField1Str();
	}

	/**
	* Sets the field1 str of this s p audit.
	*
	* @param field1Str the field1 str of this s p audit
	*/
	@Override
	public void setField1Str(java.lang.String field1Str) {
		_spAudit.setField1Str(field1Str);
	}

	/**
	* Returns the field1 long of this s p audit.
	*
	* @return the field1 long of this s p audit
	*/
	@Override
	public long getField1Long() {
		return _spAudit.getField1Long();
	}

	/**
	* Sets the field1 long of this s p audit.
	*
	* @param field1Long the field1 long of this s p audit
	*/
	@Override
	public void setField1Long(long field1Long) {
		_spAudit.setField1Long(field1Long);
	}

	/**
	* Returns the field2 str of this s p audit.
	*
	* @return the field2 str of this s p audit
	*/
	@Override
	public java.lang.String getField2Str() {
		return _spAudit.getField2Str();
	}

	/**
	* Sets the field2 str of this s p audit.
	*
	* @param field2Str the field2 str of this s p audit
	*/
	@Override
	public void setField2Str(java.lang.String field2Str) {
		_spAudit.setField2Str(field2Str);
	}

	/**
	* Returns the field2 long of this s p audit.
	*
	* @return the field2 long of this s p audit
	*/
	@Override
	public long getField2Long() {
		return _spAudit.getField2Long();
	}

	/**
	* Sets the field2 long of this s p audit.
	*
	* @param field2Long the field2 long of this s p audit
	*/
	@Override
	public void setField2Long(long field2Long) {
		_spAudit.setField2Long(field2Long);
	}

	/**
	* Returns the data1 of this s p audit.
	*
	* @return the data1 of this s p audit
	*/
	@Override
	public java.lang.String getData1() {
		return _spAudit.getData1();
	}

	/**
	* Sets the data1 of this s p audit.
	*
	* @param data1 the data1 of this s p audit
	*/
	@Override
	public void setData1(java.lang.String data1) {
		_spAudit.setData1(data1);
	}

	/**
	* Returns the data2 of this s p audit.
	*
	* @return the data2 of this s p audit
	*/
	@Override
	public java.lang.String getData2() {
		return _spAudit.getData2();
	}

	/**
	* Sets the data2 of this s p audit.
	*
	* @param data2 the data2 of this s p audit
	*/
	@Override
	public void setData2(java.lang.String data2) {
		_spAudit.setData2(data2);
	}

	@Override
	public boolean isNew() {
		return _spAudit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spAudit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spAudit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spAudit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spAudit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spAudit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spAudit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spAudit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spAudit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spAudit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spAudit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPAuditWrapper((SPAudit)_spAudit.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPAudit spAudit) {
		return _spAudit.compareTo(spAudit);
	}

	@Override
	public int hashCode() {
		return _spAudit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPAudit> toCacheModel() {
		return _spAudit.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit toEscapedModel() {
		return new SPAuditWrapper(_spAudit.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPAudit toUnescapedModel() {
		return new SPAuditWrapper(_spAudit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spAudit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spAudit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spAudit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPAuditWrapper)) {
			return false;
		}

		SPAuditWrapper spAuditWrapper = (SPAuditWrapper)obj;

		if (Validator.equals(_spAudit, spAuditWrapper._spAudit)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spAudit.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPAudit getWrappedSPAudit() {
		return _spAudit;
	}

	@Override
	public SPAudit getWrappedModel() {
		return _spAudit;
	}

	@Override
	public void resetOriginalValues() {
		_spAudit.resetOriginalValues();
	}

	private SPAudit _spAudit;
}