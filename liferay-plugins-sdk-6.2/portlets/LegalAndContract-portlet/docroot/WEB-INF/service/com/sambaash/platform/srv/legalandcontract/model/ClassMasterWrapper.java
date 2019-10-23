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

package com.sambaash.platform.srv.legalandcontract.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ClassMaster}.
 * </p>
 *
 * @author nareshchebolu
 * @see ClassMaster
 * @generated
 */
public class ClassMasterWrapper implements ClassMaster,
	ModelWrapper<ClassMaster> {
	public ClassMasterWrapper(ClassMaster classMaster) {
		_classMaster = classMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return ClassMaster.class;
	}

	@Override
	public String getModelClassName() {
		return ClassMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spClassId", getSpClassId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("country", getCountry());
		attributes.put("filedBy", getFiledBy());
		attributes.put("customField1", getCustomField1());
		attributes.put("customField2", getCustomField2());
		attributes.put("customDate1", getCustomDate1());
		attributes.put("customDate2", getCustomDate2());
		attributes.put("version", getVersion());
		attributes.put("rootSpClassId", getRootSpClassId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spClassId = (Long)attributes.get("spClassId");

		if (spClassId != null) {
			setSpClassId(spClassId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String filedBy = (String)attributes.get("filedBy");

		if (filedBy != null) {
			setFiledBy(filedBy);
		}

		String customField1 = (String)attributes.get("customField1");

		if (customField1 != null) {
			setCustomField1(customField1);
		}

		String customField2 = (String)attributes.get("customField2");

		if (customField2 != null) {
			setCustomField2(customField2);
		}

		Date customDate1 = (Date)attributes.get("customDate1");

		if (customDate1 != null) {
			setCustomDate1(customDate1);
		}

		Date customDate2 = (Date)attributes.get("customDate2");

		if (customDate2 != null) {
			setCustomDate2(customDate2);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long rootSpClassId = (Long)attributes.get("rootSpClassId");

		if (rootSpClassId != null) {
			setRootSpClassId(rootSpClassId);
		}
	}

	/**
	* Returns the primary key of this class master.
	*
	* @return the primary key of this class master
	*/
	@Override
	public long getPrimaryKey() {
		return _classMaster.getPrimaryKey();
	}

	/**
	* Sets the primary key of this class master.
	*
	* @param primaryKey the primary key of this class master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_classMaster.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this class master.
	*
	* @return the uuid of this class master
	*/
	@Override
	public java.lang.String getUuid() {
		return _classMaster.getUuid();
	}

	/**
	* Sets the uuid of this class master.
	*
	* @param uuid the uuid of this class master
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_classMaster.setUuid(uuid);
	}

	/**
	* Returns the sp class ID of this class master.
	*
	* @return the sp class ID of this class master
	*/
	@Override
	public long getSpClassId() {
		return _classMaster.getSpClassId();
	}

	/**
	* Sets the sp class ID of this class master.
	*
	* @param spClassId the sp class ID of this class master
	*/
	@Override
	public void setSpClassId(long spClassId) {
		_classMaster.setSpClassId(spClassId);
	}

	/**
	* Returns the group ID of this class master.
	*
	* @return the group ID of this class master
	*/
	@Override
	public long getGroupId() {
		return _classMaster.getGroupId();
	}

	/**
	* Sets the group ID of this class master.
	*
	* @param groupId the group ID of this class master
	*/
	@Override
	public void setGroupId(long groupId) {
		_classMaster.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this class master.
	*
	* @return the company ID of this class master
	*/
	@Override
	public long getCompanyId() {
		return _classMaster.getCompanyId();
	}

	/**
	* Sets the company ID of this class master.
	*
	* @param companyId the company ID of this class master
	*/
	@Override
	public void setCompanyId(long companyId) {
		_classMaster.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this class master.
	*
	* @return the user ID of this class master
	*/
	@Override
	public long getUserId() {
		return _classMaster.getUserId();
	}

	/**
	* Sets the user ID of this class master.
	*
	* @param userId the user ID of this class master
	*/
	@Override
	public void setUserId(long userId) {
		_classMaster.setUserId(userId);
	}

	/**
	* Returns the user uuid of this class master.
	*
	* @return the user uuid of this class master
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classMaster.getUserUuid();
	}

	/**
	* Sets the user uuid of this class master.
	*
	* @param userUuid the user uuid of this class master
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_classMaster.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this class master.
	*
	* @return the user name of this class master
	*/
	@Override
	public java.lang.String getUserName() {
		return _classMaster.getUserName();
	}

	/**
	* Sets the user name of this class master.
	*
	* @param userName the user name of this class master
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_classMaster.setUserName(userName);
	}

	/**
	* Returns the create date of this class master.
	*
	* @return the create date of this class master
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _classMaster.getCreateDate();
	}

	/**
	* Sets the create date of this class master.
	*
	* @param createDate the create date of this class master
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_classMaster.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this class master.
	*
	* @return the modified date of this class master
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _classMaster.getModifiedDate();
	}

	/**
	* Sets the modified date of this class master.
	*
	* @param modifiedDate the modified date of this class master
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_classMaster.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the code of this class master.
	*
	* @return the code of this class master
	*/
	@Override
	public java.lang.String getCode() {
		return _classMaster.getCode();
	}

	/**
	* Sets the code of this class master.
	*
	* @param code the code of this class master
	*/
	@Override
	public void setCode(java.lang.String code) {
		_classMaster.setCode(code);
	}

	/**
	* Returns the country of this class master.
	*
	* @return the country of this class master
	*/
	@Override
	public java.lang.String getCountry() {
		return _classMaster.getCountry();
	}

	/**
	* Sets the country of this class master.
	*
	* @param country the country of this class master
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_classMaster.setCountry(country);
	}

	/**
	* Returns the filed by of this class master.
	*
	* @return the filed by of this class master
	*/
	@Override
	public java.lang.String getFiledBy() {
		return _classMaster.getFiledBy();
	}

	/**
	* Sets the filed by of this class master.
	*
	* @param filedBy the filed by of this class master
	*/
	@Override
	public void setFiledBy(java.lang.String filedBy) {
		_classMaster.setFiledBy(filedBy);
	}

	/**
	* Returns the custom field1 of this class master.
	*
	* @return the custom field1 of this class master
	*/
	@Override
	public java.lang.String getCustomField1() {
		return _classMaster.getCustomField1();
	}

	/**
	* Sets the custom field1 of this class master.
	*
	* @param customField1 the custom field1 of this class master
	*/
	@Override
	public void setCustomField1(java.lang.String customField1) {
		_classMaster.setCustomField1(customField1);
	}

	/**
	* Returns the custom field2 of this class master.
	*
	* @return the custom field2 of this class master
	*/
	@Override
	public java.lang.String getCustomField2() {
		return _classMaster.getCustomField2();
	}

	/**
	* Sets the custom field2 of this class master.
	*
	* @param customField2 the custom field2 of this class master
	*/
	@Override
	public void setCustomField2(java.lang.String customField2) {
		_classMaster.setCustomField2(customField2);
	}

	/**
	* Returns the custom date1 of this class master.
	*
	* @return the custom date1 of this class master
	*/
	@Override
	public java.util.Date getCustomDate1() {
		return _classMaster.getCustomDate1();
	}

	/**
	* Sets the custom date1 of this class master.
	*
	* @param customDate1 the custom date1 of this class master
	*/
	@Override
	public void setCustomDate1(java.util.Date customDate1) {
		_classMaster.setCustomDate1(customDate1);
	}

	/**
	* Returns the custom date2 of this class master.
	*
	* @return the custom date2 of this class master
	*/
	@Override
	public java.util.Date getCustomDate2() {
		return _classMaster.getCustomDate2();
	}

	/**
	* Sets the custom date2 of this class master.
	*
	* @param customDate2 the custom date2 of this class master
	*/
	@Override
	public void setCustomDate2(java.util.Date customDate2) {
		_classMaster.setCustomDate2(customDate2);
	}

	/**
	* Returns the version of this class master.
	*
	* @return the version of this class master
	*/
	@Override
	public java.lang.String getVersion() {
		return _classMaster.getVersion();
	}

	/**
	* Sets the version of this class master.
	*
	* @param version the version of this class master
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_classMaster.setVersion(version);
	}

	/**
	* Returns the root sp class ID of this class master.
	*
	* @return the root sp class ID of this class master
	*/
	@Override
	public long getRootSpClassId() {
		return _classMaster.getRootSpClassId();
	}

	/**
	* Sets the root sp class ID of this class master.
	*
	* @param rootSpClassId the root sp class ID of this class master
	*/
	@Override
	public void setRootSpClassId(long rootSpClassId) {
		_classMaster.setRootSpClassId(rootSpClassId);
	}

	@Override
	public boolean isNew() {
		return _classMaster.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_classMaster.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _classMaster.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_classMaster.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _classMaster.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _classMaster.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_classMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _classMaster.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_classMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_classMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_classMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ClassMasterWrapper((ClassMaster)_classMaster.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster) {
		return _classMaster.compareTo(classMaster);
	}

	@Override
	public int hashCode() {
		return _classMaster.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.legalandcontract.model.ClassMaster> toCacheModel() {
		return _classMaster.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster toEscapedModel() {
		return new ClassMasterWrapper(_classMaster.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.legalandcontract.model.ClassMaster toUnescapedModel() {
		return new ClassMasterWrapper(_classMaster.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _classMaster.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _classMaster.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_classMaster.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClassMasterWrapper)) {
			return false;
		}

		ClassMasterWrapper classMasterWrapper = (ClassMasterWrapper)obj;

		if (Validator.equals(_classMaster, classMasterWrapper._classMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _classMaster.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ClassMaster getWrappedClassMaster() {
		return _classMaster;
	}

	@Override
	public ClassMaster getWrappedModel() {
		return _classMaster;
	}

	@Override
	public void resetOriginalValues() {
		_classMaster.resetOriginalValues();
	}

	private ClassMaster _classMaster;
}