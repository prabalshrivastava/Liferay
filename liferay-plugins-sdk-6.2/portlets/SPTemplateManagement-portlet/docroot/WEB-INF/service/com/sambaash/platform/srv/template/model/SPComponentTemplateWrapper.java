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
 * This class is a wrapper for {@link SPComponentTemplate}.
 * </p>
 *
 * @author WattabyteIT
 * @see SPComponentTemplate
 * @generated
 */
public class SPComponentTemplateWrapper implements SPComponentTemplate,
	ModelWrapper<SPComponentTemplate> {
	public SPComponentTemplateWrapper(SPComponentTemplate spComponentTemplate) {
		_spComponentTemplate = spComponentTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return SPComponentTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return SPComponentTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spComponentTemplateId", getSpComponentTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("spTemplateId", getSpTemplateId());
		attributes.put("level0ClassNameId", getLevel0ClassNameId());
		attributes.put("level0FormId", getLevel0FormId());
		attributes.put("level1ClassNameId", getLevel1ClassNameId());
		attributes.put("level1FormId", getLevel1FormId());
		attributes.put("level2ClassNameId", getLevel2ClassNameId());
		attributes.put("level2FormId", getLevel2FormId());
		attributes.put("level3ClassNameId", getLevel3ClassNameId());
		attributes.put("level3FormId", getLevel3FormId());
		attributes.put("level4ClassNameId", getLevel4ClassNameId());
		attributes.put("level4FormId", getLevel4FormId());
		attributes.put("level5ClassNameId", getLevel5ClassNameId());
		attributes.put("level5FormId", getLevel5FormId());
		attributes.put("level6ClassNameId", getLevel6ClassNameId());
		attributes.put("level6FormId", getLevel6FormId());
		attributes.put("level7ClassNameId", getLevel7ClassNameId());
		attributes.put("level7FormId", getLevel7FormId());
		attributes.put("level8ClassNameId", getLevel8ClassNameId());
		attributes.put("level8FormId", getLevel8FormId());
		attributes.put("level9ClassNameId", getLevel9ClassNameId());
		attributes.put("level9FormId", getLevel9FormId());
		attributes.put("level10ClassNameId", getLevel10ClassNameId());
		attributes.put("level10FormId", getLevel10FormId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spComponentTemplateId = (Long)attributes.get(
				"spComponentTemplateId");

		if (spComponentTemplateId != null) {
			setSpComponentTemplateId(spComponentTemplateId);
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

		Long spTemplateId = (Long)attributes.get("spTemplateId");

		if (spTemplateId != null) {
			setSpTemplateId(spTemplateId);
		}

		Long level0ClassNameId = (Long)attributes.get("level0ClassNameId");

		if (level0ClassNameId != null) {
			setLevel0ClassNameId(level0ClassNameId);
		}

		Long level0FormId = (Long)attributes.get("level0FormId");

		if (level0FormId != null) {
			setLevel0FormId(level0FormId);
		}

		Long level1ClassNameId = (Long)attributes.get("level1ClassNameId");

		if (level1ClassNameId != null) {
			setLevel1ClassNameId(level1ClassNameId);
		}

		Long level1FormId = (Long)attributes.get("level1FormId");

		if (level1FormId != null) {
			setLevel1FormId(level1FormId);
		}

		Long level2ClassNameId = (Long)attributes.get("level2ClassNameId");

		if (level2ClassNameId != null) {
			setLevel2ClassNameId(level2ClassNameId);
		}

		Long level2FormId = (Long)attributes.get("level2FormId");

		if (level2FormId != null) {
			setLevel2FormId(level2FormId);
		}

		Long level3ClassNameId = (Long)attributes.get("level3ClassNameId");

		if (level3ClassNameId != null) {
			setLevel3ClassNameId(level3ClassNameId);
		}

		Long level3FormId = (Long)attributes.get("level3FormId");

		if (level3FormId != null) {
			setLevel3FormId(level3FormId);
		}

		Long level4ClassNameId = (Long)attributes.get("level4ClassNameId");

		if (level4ClassNameId != null) {
			setLevel4ClassNameId(level4ClassNameId);
		}

		Long level4FormId = (Long)attributes.get("level4FormId");

		if (level4FormId != null) {
			setLevel4FormId(level4FormId);
		}

		Long level5ClassNameId = (Long)attributes.get("level5ClassNameId");

		if (level5ClassNameId != null) {
			setLevel5ClassNameId(level5ClassNameId);
		}

		Long level5FormId = (Long)attributes.get("level5FormId");

		if (level5FormId != null) {
			setLevel5FormId(level5FormId);
		}

		Long level6ClassNameId = (Long)attributes.get("level6ClassNameId");

		if (level6ClassNameId != null) {
			setLevel6ClassNameId(level6ClassNameId);
		}

		Long level6FormId = (Long)attributes.get("level6FormId");

		if (level6FormId != null) {
			setLevel6FormId(level6FormId);
		}

		Long level7ClassNameId = (Long)attributes.get("level7ClassNameId");

		if (level7ClassNameId != null) {
			setLevel7ClassNameId(level7ClassNameId);
		}

		Long level7FormId = (Long)attributes.get("level7FormId");

		if (level7FormId != null) {
			setLevel7FormId(level7FormId);
		}

		Long level8ClassNameId = (Long)attributes.get("level8ClassNameId");

		if (level8ClassNameId != null) {
			setLevel8ClassNameId(level8ClassNameId);
		}

		Long level8FormId = (Long)attributes.get("level8FormId");

		if (level8FormId != null) {
			setLevel8FormId(level8FormId);
		}

		Long level9ClassNameId = (Long)attributes.get("level9ClassNameId");

		if (level9ClassNameId != null) {
			setLevel9ClassNameId(level9ClassNameId);
		}

		Long level9FormId = (Long)attributes.get("level9FormId");

		if (level9FormId != null) {
			setLevel9FormId(level9FormId);
		}

		Long level10ClassNameId = (Long)attributes.get("level10ClassNameId");

		if (level10ClassNameId != null) {
			setLevel10ClassNameId(level10ClassNameId);
		}

		Long level10FormId = (Long)attributes.get("level10FormId");

		if (level10FormId != null) {
			setLevel10FormId(level10FormId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this s p component template.
	*
	* @return the primary key of this s p component template
	*/
	@Override
	public long getPrimaryKey() {
		return _spComponentTemplate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p component template.
	*
	* @param primaryKey the primary key of this s p component template
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spComponentTemplate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p component template.
	*
	* @return the uuid of this s p component template
	*/
	@Override
	public java.lang.String getUuid() {
		return _spComponentTemplate.getUuid();
	}

	/**
	* Sets the uuid of this s p component template.
	*
	* @param uuid the uuid of this s p component template
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spComponentTemplate.setUuid(uuid);
	}

	/**
	* Returns the sp component template ID of this s p component template.
	*
	* @return the sp component template ID of this s p component template
	*/
	@Override
	public long getSpComponentTemplateId() {
		return _spComponentTemplate.getSpComponentTemplateId();
	}

	/**
	* Sets the sp component template ID of this s p component template.
	*
	* @param spComponentTemplateId the sp component template ID of this s p component template
	*/
	@Override
	public void setSpComponentTemplateId(long spComponentTemplateId) {
		_spComponentTemplate.setSpComponentTemplateId(spComponentTemplateId);
	}

	/**
	* Returns the group ID of this s p component template.
	*
	* @return the group ID of this s p component template
	*/
	@Override
	public long getGroupId() {
		return _spComponentTemplate.getGroupId();
	}

	/**
	* Sets the group ID of this s p component template.
	*
	* @param groupId the group ID of this s p component template
	*/
	@Override
	public void setGroupId(long groupId) {
		_spComponentTemplate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p component template.
	*
	* @return the company ID of this s p component template
	*/
	@Override
	public long getCompanyId() {
		return _spComponentTemplate.getCompanyId();
	}

	/**
	* Sets the company ID of this s p component template.
	*
	* @param companyId the company ID of this s p component template
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spComponentTemplate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p component template.
	*
	* @return the user ID of this s p component template
	*/
	@Override
	public long getUserId() {
		return _spComponentTemplate.getUserId();
	}

	/**
	* Sets the user ID of this s p component template.
	*
	* @param userId the user ID of this s p component template
	*/
	@Override
	public void setUserId(long userId) {
		_spComponentTemplate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p component template.
	*
	* @return the user uuid of this s p component template
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spComponentTemplate.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p component template.
	*
	* @param userUuid the user uuid of this s p component template
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spComponentTemplate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p component template.
	*
	* @return the user name of this s p component template
	*/
	@Override
	public java.lang.String getUserName() {
		return _spComponentTemplate.getUserName();
	}

	/**
	* Sets the user name of this s p component template.
	*
	* @param userName the user name of this s p component template
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spComponentTemplate.setUserName(userName);
	}

	/**
	* Returns the create date of this s p component template.
	*
	* @return the create date of this s p component template
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spComponentTemplate.getCreateDate();
	}

	/**
	* Sets the create date of this s p component template.
	*
	* @param createDate the create date of this s p component template
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spComponentTemplate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p component template.
	*
	* @return the modified date of this s p component template
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spComponentTemplate.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p component template.
	*
	* @param modifiedDate the modified date of this s p component template
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spComponentTemplate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the create by of this s p component template.
	*
	* @return the create by of this s p component template
	*/
	@Override
	public long getCreateBy() {
		return _spComponentTemplate.getCreateBy();
	}

	/**
	* Sets the create by of this s p component template.
	*
	* @param createBy the create by of this s p component template
	*/
	@Override
	public void setCreateBy(long createBy) {
		_spComponentTemplate.setCreateBy(createBy);
	}

	/**
	* Returns the modified by of this s p component template.
	*
	* @return the modified by of this s p component template
	*/
	@Override
	public long getModifiedBy() {
		return _spComponentTemplate.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p component template.
	*
	* @param modifiedBy the modified by of this s p component template
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_spComponentTemplate.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the sp template ID of this s p component template.
	*
	* @return the sp template ID of this s p component template
	*/
	@Override
	public long getSpTemplateId() {
		return _spComponentTemplate.getSpTemplateId();
	}

	/**
	* Sets the sp template ID of this s p component template.
	*
	* @param spTemplateId the sp template ID of this s p component template
	*/
	@Override
	public void setSpTemplateId(long spTemplateId) {
		_spComponentTemplate.setSpTemplateId(spTemplateId);
	}

	/**
	* Returns the level0 class name ID of this s p component template.
	*
	* @return the level0 class name ID of this s p component template
	*/
	@Override
	public long getLevel0ClassNameId() {
		return _spComponentTemplate.getLevel0ClassNameId();
	}

	/**
	* Sets the level0 class name ID of this s p component template.
	*
	* @param level0ClassNameId the level0 class name ID of this s p component template
	*/
	@Override
	public void setLevel0ClassNameId(long level0ClassNameId) {
		_spComponentTemplate.setLevel0ClassNameId(level0ClassNameId);
	}

	/**
	* Returns the level0 form ID of this s p component template.
	*
	* @return the level0 form ID of this s p component template
	*/
	@Override
	public long getLevel0FormId() {
		return _spComponentTemplate.getLevel0FormId();
	}

	/**
	* Sets the level0 form ID of this s p component template.
	*
	* @param level0FormId the level0 form ID of this s p component template
	*/
	@Override
	public void setLevel0FormId(long level0FormId) {
		_spComponentTemplate.setLevel0FormId(level0FormId);
	}

	/**
	* Returns the level1 class name ID of this s p component template.
	*
	* @return the level1 class name ID of this s p component template
	*/
	@Override
	public long getLevel1ClassNameId() {
		return _spComponentTemplate.getLevel1ClassNameId();
	}

	/**
	* Sets the level1 class name ID of this s p component template.
	*
	* @param level1ClassNameId the level1 class name ID of this s p component template
	*/
	@Override
	public void setLevel1ClassNameId(long level1ClassNameId) {
		_spComponentTemplate.setLevel1ClassNameId(level1ClassNameId);
	}

	/**
	* Returns the level1 form ID of this s p component template.
	*
	* @return the level1 form ID of this s p component template
	*/
	@Override
	public long getLevel1FormId() {
		return _spComponentTemplate.getLevel1FormId();
	}

	/**
	* Sets the level1 form ID of this s p component template.
	*
	* @param level1FormId the level1 form ID of this s p component template
	*/
	@Override
	public void setLevel1FormId(long level1FormId) {
		_spComponentTemplate.setLevel1FormId(level1FormId);
	}

	/**
	* Returns the level2 class name ID of this s p component template.
	*
	* @return the level2 class name ID of this s p component template
	*/
	@Override
	public long getLevel2ClassNameId() {
		return _spComponentTemplate.getLevel2ClassNameId();
	}

	/**
	* Sets the level2 class name ID of this s p component template.
	*
	* @param level2ClassNameId the level2 class name ID of this s p component template
	*/
	@Override
	public void setLevel2ClassNameId(long level2ClassNameId) {
		_spComponentTemplate.setLevel2ClassNameId(level2ClassNameId);
	}

	/**
	* Returns the level2 form ID of this s p component template.
	*
	* @return the level2 form ID of this s p component template
	*/
	@Override
	public long getLevel2FormId() {
		return _spComponentTemplate.getLevel2FormId();
	}

	/**
	* Sets the level2 form ID of this s p component template.
	*
	* @param level2FormId the level2 form ID of this s p component template
	*/
	@Override
	public void setLevel2FormId(long level2FormId) {
		_spComponentTemplate.setLevel2FormId(level2FormId);
	}

	/**
	* Returns the level3 class name ID of this s p component template.
	*
	* @return the level3 class name ID of this s p component template
	*/
	@Override
	public long getLevel3ClassNameId() {
		return _spComponentTemplate.getLevel3ClassNameId();
	}

	/**
	* Sets the level3 class name ID of this s p component template.
	*
	* @param level3ClassNameId the level3 class name ID of this s p component template
	*/
	@Override
	public void setLevel3ClassNameId(long level3ClassNameId) {
		_spComponentTemplate.setLevel3ClassNameId(level3ClassNameId);
	}

	/**
	* Returns the level3 form ID of this s p component template.
	*
	* @return the level3 form ID of this s p component template
	*/
	@Override
	public long getLevel3FormId() {
		return _spComponentTemplate.getLevel3FormId();
	}

	/**
	* Sets the level3 form ID of this s p component template.
	*
	* @param level3FormId the level3 form ID of this s p component template
	*/
	@Override
	public void setLevel3FormId(long level3FormId) {
		_spComponentTemplate.setLevel3FormId(level3FormId);
	}

	/**
	* Returns the level4 class name ID of this s p component template.
	*
	* @return the level4 class name ID of this s p component template
	*/
	@Override
	public long getLevel4ClassNameId() {
		return _spComponentTemplate.getLevel4ClassNameId();
	}

	/**
	* Sets the level4 class name ID of this s p component template.
	*
	* @param level4ClassNameId the level4 class name ID of this s p component template
	*/
	@Override
	public void setLevel4ClassNameId(long level4ClassNameId) {
		_spComponentTemplate.setLevel4ClassNameId(level4ClassNameId);
	}

	/**
	* Returns the level4 form ID of this s p component template.
	*
	* @return the level4 form ID of this s p component template
	*/
	@Override
	public long getLevel4FormId() {
		return _spComponentTemplate.getLevel4FormId();
	}

	/**
	* Sets the level4 form ID of this s p component template.
	*
	* @param level4FormId the level4 form ID of this s p component template
	*/
	@Override
	public void setLevel4FormId(long level4FormId) {
		_spComponentTemplate.setLevel4FormId(level4FormId);
	}

	/**
	* Returns the level5 class name ID of this s p component template.
	*
	* @return the level5 class name ID of this s p component template
	*/
	@Override
	public long getLevel5ClassNameId() {
		return _spComponentTemplate.getLevel5ClassNameId();
	}

	/**
	* Sets the level5 class name ID of this s p component template.
	*
	* @param level5ClassNameId the level5 class name ID of this s p component template
	*/
	@Override
	public void setLevel5ClassNameId(long level5ClassNameId) {
		_spComponentTemplate.setLevel5ClassNameId(level5ClassNameId);
	}

	/**
	* Returns the level5 form ID of this s p component template.
	*
	* @return the level5 form ID of this s p component template
	*/
	@Override
	public long getLevel5FormId() {
		return _spComponentTemplate.getLevel5FormId();
	}

	/**
	* Sets the level5 form ID of this s p component template.
	*
	* @param level5FormId the level5 form ID of this s p component template
	*/
	@Override
	public void setLevel5FormId(long level5FormId) {
		_spComponentTemplate.setLevel5FormId(level5FormId);
	}

	/**
	* Returns the level6 class name ID of this s p component template.
	*
	* @return the level6 class name ID of this s p component template
	*/
	@Override
	public long getLevel6ClassNameId() {
		return _spComponentTemplate.getLevel6ClassNameId();
	}

	/**
	* Sets the level6 class name ID of this s p component template.
	*
	* @param level6ClassNameId the level6 class name ID of this s p component template
	*/
	@Override
	public void setLevel6ClassNameId(long level6ClassNameId) {
		_spComponentTemplate.setLevel6ClassNameId(level6ClassNameId);
	}

	/**
	* Returns the level6 form ID of this s p component template.
	*
	* @return the level6 form ID of this s p component template
	*/
	@Override
	public long getLevel6FormId() {
		return _spComponentTemplate.getLevel6FormId();
	}

	/**
	* Sets the level6 form ID of this s p component template.
	*
	* @param level6FormId the level6 form ID of this s p component template
	*/
	@Override
	public void setLevel6FormId(long level6FormId) {
		_spComponentTemplate.setLevel6FormId(level6FormId);
	}

	/**
	* Returns the level7 class name ID of this s p component template.
	*
	* @return the level7 class name ID of this s p component template
	*/
	@Override
	public long getLevel7ClassNameId() {
		return _spComponentTemplate.getLevel7ClassNameId();
	}

	/**
	* Sets the level7 class name ID of this s p component template.
	*
	* @param level7ClassNameId the level7 class name ID of this s p component template
	*/
	@Override
	public void setLevel7ClassNameId(long level7ClassNameId) {
		_spComponentTemplate.setLevel7ClassNameId(level7ClassNameId);
	}

	/**
	* Returns the level7 form ID of this s p component template.
	*
	* @return the level7 form ID of this s p component template
	*/
	@Override
	public long getLevel7FormId() {
		return _spComponentTemplate.getLevel7FormId();
	}

	/**
	* Sets the level7 form ID of this s p component template.
	*
	* @param level7FormId the level7 form ID of this s p component template
	*/
	@Override
	public void setLevel7FormId(long level7FormId) {
		_spComponentTemplate.setLevel7FormId(level7FormId);
	}

	/**
	* Returns the level8 class name ID of this s p component template.
	*
	* @return the level8 class name ID of this s p component template
	*/
	@Override
	public long getLevel8ClassNameId() {
		return _spComponentTemplate.getLevel8ClassNameId();
	}

	/**
	* Sets the level8 class name ID of this s p component template.
	*
	* @param level8ClassNameId the level8 class name ID of this s p component template
	*/
	@Override
	public void setLevel8ClassNameId(long level8ClassNameId) {
		_spComponentTemplate.setLevel8ClassNameId(level8ClassNameId);
	}

	/**
	* Returns the level8 form ID of this s p component template.
	*
	* @return the level8 form ID of this s p component template
	*/
	@Override
	public long getLevel8FormId() {
		return _spComponentTemplate.getLevel8FormId();
	}

	/**
	* Sets the level8 form ID of this s p component template.
	*
	* @param level8FormId the level8 form ID of this s p component template
	*/
	@Override
	public void setLevel8FormId(long level8FormId) {
		_spComponentTemplate.setLevel8FormId(level8FormId);
	}

	/**
	* Returns the level9 class name ID of this s p component template.
	*
	* @return the level9 class name ID of this s p component template
	*/
	@Override
	public long getLevel9ClassNameId() {
		return _spComponentTemplate.getLevel9ClassNameId();
	}

	/**
	* Sets the level9 class name ID of this s p component template.
	*
	* @param level9ClassNameId the level9 class name ID of this s p component template
	*/
	@Override
	public void setLevel9ClassNameId(long level9ClassNameId) {
		_spComponentTemplate.setLevel9ClassNameId(level9ClassNameId);
	}

	/**
	* Returns the level9 form ID of this s p component template.
	*
	* @return the level9 form ID of this s p component template
	*/
	@Override
	public long getLevel9FormId() {
		return _spComponentTemplate.getLevel9FormId();
	}

	/**
	* Sets the level9 form ID of this s p component template.
	*
	* @param level9FormId the level9 form ID of this s p component template
	*/
	@Override
	public void setLevel9FormId(long level9FormId) {
		_spComponentTemplate.setLevel9FormId(level9FormId);
	}

	/**
	* Returns the level10 class name ID of this s p component template.
	*
	* @return the level10 class name ID of this s p component template
	*/
	@Override
	public long getLevel10ClassNameId() {
		return _spComponentTemplate.getLevel10ClassNameId();
	}

	/**
	* Sets the level10 class name ID of this s p component template.
	*
	* @param level10ClassNameId the level10 class name ID of this s p component template
	*/
	@Override
	public void setLevel10ClassNameId(long level10ClassNameId) {
		_spComponentTemplate.setLevel10ClassNameId(level10ClassNameId);
	}

	/**
	* Returns the level10 form ID of this s p component template.
	*
	* @return the level10 form ID of this s p component template
	*/
	@Override
	public long getLevel10FormId() {
		return _spComponentTemplate.getLevel10FormId();
	}

	/**
	* Sets the level10 form ID of this s p component template.
	*
	* @param level10FormId the level10 form ID of this s p component template
	*/
	@Override
	public void setLevel10FormId(long level10FormId) {
		_spComponentTemplate.setLevel10FormId(level10FormId);
	}

	/**
	* Returns the status of this s p component template.
	*
	* @return the status of this s p component template
	*/
	@Override
	public int getStatus() {
		return _spComponentTemplate.getStatus();
	}

	/**
	* Sets the status of this s p component template.
	*
	* @param status the status of this s p component template
	*/
	@Override
	public void setStatus(int status) {
		_spComponentTemplate.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _spComponentTemplate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spComponentTemplate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spComponentTemplate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spComponentTemplate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spComponentTemplate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spComponentTemplate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spComponentTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spComponentTemplate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spComponentTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spComponentTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spComponentTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPComponentTemplateWrapper((SPComponentTemplate)_spComponentTemplate.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.template.model.SPComponentTemplate spComponentTemplate) {
		return _spComponentTemplate.compareTo(spComponentTemplate);
	}

	@Override
	public int hashCode() {
		return _spComponentTemplate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.template.model.SPComponentTemplate> toCacheModel() {
		return _spComponentTemplate.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.template.model.SPComponentTemplate toEscapedModel() {
		return new SPComponentTemplateWrapper(_spComponentTemplate.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.template.model.SPComponentTemplate toUnescapedModel() {
		return new SPComponentTemplateWrapper(_spComponentTemplate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spComponentTemplate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spComponentTemplate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spComponentTemplate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPComponentTemplateWrapper)) {
			return false;
		}

		SPComponentTemplateWrapper spComponentTemplateWrapper = (SPComponentTemplateWrapper)obj;

		if (Validator.equals(_spComponentTemplate,
					spComponentTemplateWrapper._spComponentTemplate)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spComponentTemplate.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPComponentTemplate getWrappedSPComponentTemplate() {
		return _spComponentTemplate;
	}

	@Override
	public SPComponentTemplate getWrappedModel() {
		return _spComponentTemplate;
	}

	@Override
	public void resetOriginalValues() {
		_spComponentTemplate.resetOriginalValues();
	}

	private SPComponentTemplate _spComponentTemplate;
}