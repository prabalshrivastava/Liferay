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

package com.sambaash.platform.srv.template.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPTemplate}.
 * </p>
 *
 * @author WattabyteIT
 * @see SPTemplate
 * @generated
 */
public class SPTemplateWrapper implements SPTemplate, ModelWrapper<SPTemplate> {
	public SPTemplateWrapper(SPTemplate spTemplate) {
		_spTemplate = spTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return SPTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return SPTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spTemplateId", getSpTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("templateName", getTemplateName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spTemplateId = (Long)attributes.get("spTemplateId");

		if (spTemplateId != null) {
			setSpTemplateId(spTemplateId);
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

		Long createBy = (Long)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this s p template.
	*
	* @return the primary key of this s p template
	*/
	@Override
	public long getPrimaryKey() {
		return _spTemplate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p template.
	*
	* @param primaryKey the primary key of this s p template
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spTemplate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p template.
	*
	* @return the uuid of this s p template
	*/
	@Override
	public java.lang.String getUuid() {
		return _spTemplate.getUuid();
	}

	/**
	* Sets the uuid of this s p template.
	*
	* @param uuid the uuid of this s p template
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spTemplate.setUuid(uuid);
	}

	/**
	* Returns the sp template ID of this s p template.
	*
	* @return the sp template ID of this s p template
	*/
	@Override
	public long getSpTemplateId() {
		return _spTemplate.getSpTemplateId();
	}

	/**
	* Sets the sp template ID of this s p template.
	*
	* @param spTemplateId the sp template ID of this s p template
	*/
	@Override
	public void setSpTemplateId(long spTemplateId) {
		_spTemplate.setSpTemplateId(spTemplateId);
	}

	/**
	* Returns the group ID of this s p template.
	*
	* @return the group ID of this s p template
	*/
	@Override
	public long getGroupId() {
		return _spTemplate.getGroupId();
	}

	/**
	* Sets the group ID of this s p template.
	*
	* @param groupId the group ID of this s p template
	*/
	@Override
	public void setGroupId(long groupId) {
		_spTemplate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p template.
	*
	* @return the company ID of this s p template
	*/
	@Override
	public long getCompanyId() {
		return _spTemplate.getCompanyId();
	}

	/**
	* Sets the company ID of this s p template.
	*
	* @param companyId the company ID of this s p template
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spTemplate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p template.
	*
	* @return the user ID of this s p template
	*/
	@Override
	public long getUserId() {
		return _spTemplate.getUserId();
	}

	/**
	* Sets the user ID of this s p template.
	*
	* @param userId the user ID of this s p template
	*/
	@Override
	public void setUserId(long userId) {
		_spTemplate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p template.
	*
	* @return the user uuid of this s p template
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spTemplate.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p template.
	*
	* @param userUuid the user uuid of this s p template
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spTemplate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p template.
	*
	* @return the user name of this s p template
	*/
	@Override
	public java.lang.String getUserName() {
		return _spTemplate.getUserName();
	}

	/**
	* Sets the user name of this s p template.
	*
	* @param userName the user name of this s p template
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spTemplate.setUserName(userName);
	}

	/**
	* Returns the create date of this s p template.
	*
	* @return the create date of this s p template
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spTemplate.getCreateDate();
	}

	/**
	* Sets the create date of this s p template.
	*
	* @param createDate the create date of this s p template
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spTemplate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p template.
	*
	* @return the modified date of this s p template
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spTemplate.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p template.
	*
	* @param modifiedDate the modified date of this s p template
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spTemplate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the create by of this s p template.
	*
	* @return the create by of this s p template
	*/
	@Override
	public long getCreateBy() {
		return _spTemplate.getCreateBy();
	}

	/**
	* Sets the create by of this s p template.
	*
	* @param createBy the create by of this s p template
	*/
	@Override
	public void setCreateBy(long createBy) {
		_spTemplate.setCreateBy(createBy);
	}

	/**
	* Returns the modified by of this s p template.
	*
	* @return the modified by of this s p template
	*/
	@Override
	public long getModifiedBy() {
		return _spTemplate.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p template.
	*
	* @param modifiedBy the modified by of this s p template
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_spTemplate.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the fully qualified class name of this s p template.
	*
	* @return the fully qualified class name of this s p template
	*/
	@Override
	public java.lang.String getClassName() {
		return _spTemplate.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_spTemplate.setClassName(className);
	}

	/**
	* Returns the class name ID of this s p template.
	*
	* @return the class name ID of this s p template
	*/
	@Override
	public long getClassNameId() {
		return _spTemplate.getClassNameId();
	}

	/**
	* Sets the class name ID of this s p template.
	*
	* @param classNameId the class name ID of this s p template
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_spTemplate.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this s p template.
	*
	* @return the class p k of this s p template
	*/
	@Override
	public long getClassPK() {
		return _spTemplate.getClassPK();
	}

	/**
	* Sets the class p k of this s p template.
	*
	* @param classPK the class p k of this s p template
	*/
	@Override
	public void setClassPK(long classPK) {
		_spTemplate.setClassPK(classPK);
	}

	/**
	* Returns the template name of this s p template.
	*
	* @return the template name of this s p template
	*/
	@Override
	public java.lang.String getTemplateName() {
		return _spTemplate.getTemplateName();
	}

	/**
	* Sets the template name of this s p template.
	*
	* @param templateName the template name of this s p template
	*/
	@Override
	public void setTemplateName(java.lang.String templateName) {
		_spTemplate.setTemplateName(templateName);
	}

	/**
	* Returns the status of this s p template.
	*
	* @return the status of this s p template
	*/
	@Override
	public int getStatus() {
		return _spTemplate.getStatus();
	}

	/**
	* Sets the status of this s p template.
	*
	* @param status the status of this s p template
	*/
	@Override
	public void setStatus(int status) {
		_spTemplate.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _spTemplate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spTemplate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spTemplate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spTemplate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spTemplate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spTemplate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spTemplate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPTemplateWrapper((SPTemplate)_spTemplate.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.template.model.SPTemplate spTemplate) {
		return _spTemplate.compareTo(spTemplate);
	}

	@Override
	public int hashCode() {
		return _spTemplate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.template.model.SPTemplate> toCacheModel() {
		return _spTemplate.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate toEscapedModel() {
		return new SPTemplateWrapper(_spTemplate.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.template.model.SPTemplate toUnescapedModel() {
		return new SPTemplateWrapper(_spTemplate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spTemplate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spTemplate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spTemplate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPTemplateWrapper)) {
			return false;
		}

		SPTemplateWrapper spTemplateWrapper = (SPTemplateWrapper)obj;

		if (Validator.equals(_spTemplate, spTemplateWrapper._spTemplate)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spTemplate.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPTemplate getWrappedSPTemplate() {
		return _spTemplate;
	}

	@Override
	public SPTemplate getWrappedModel() {
		return _spTemplate;
	}

	@Override
	public void resetOriginalValues() {
		_spTemplate.resetOriginalValues();
	}

	private SPTemplate _spTemplate;
}