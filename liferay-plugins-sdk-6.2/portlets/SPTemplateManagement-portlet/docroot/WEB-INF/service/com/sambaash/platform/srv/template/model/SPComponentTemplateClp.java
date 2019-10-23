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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.template.service.ClpSerializer;
import com.sambaash.platform.srv.template.service.SPComponentTemplateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WattabyteIT
 */
public class SPComponentTemplateClp extends BaseModelImpl<SPComponentTemplate>
	implements SPComponentTemplate {
	public SPComponentTemplateClp() {
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
	public long getPrimaryKey() {
		return _spComponentTemplateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpComponentTemplateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spComponentTemplateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spComponentTemplateRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpComponentTemplateId() {
		return _spComponentTemplateId;
	}

	@Override
	public void setSpComponentTemplateId(long spComponentTemplateId) {
		_spComponentTemplateId = spComponentTemplateId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpComponentTemplateId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel,
					spComponentTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spComponentTemplateRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spComponentTemplateRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spComponentTemplateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateBy() {
		return _createBy;
	}

	@Override
	public void setCreateBy(long createBy) {
		_createBy = createBy;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateBy", long.class);

				method.invoke(_spComponentTemplateRemoteModel, createBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_spComponentTemplateRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpTemplateId() {
		return _spTemplateId;
	}

	@Override
	public void setSpTemplateId(long spTemplateId) {
		_spTemplateId = spTemplateId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpTemplateId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, spTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel0ClassNameId() {
		return _level0ClassNameId;
	}

	@Override
	public void setLevel0ClassNameId(long level0ClassNameId) {
		_level0ClassNameId = level0ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel0ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level0ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel0FormId() {
		return _level0FormId;
	}

	@Override
	public void setLevel0FormId(long level0FormId) {
		_level0FormId = level0FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel0FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level0FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel1ClassNameId() {
		return _level1ClassNameId;
	}

	@Override
	public void setLevel1ClassNameId(long level1ClassNameId) {
		_level1ClassNameId = level1ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel1ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level1ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel1FormId() {
		return _level1FormId;
	}

	@Override
	public void setLevel1FormId(long level1FormId) {
		_level1FormId = level1FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel1FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level1FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel2ClassNameId() {
		return _level2ClassNameId;
	}

	@Override
	public void setLevel2ClassNameId(long level2ClassNameId) {
		_level2ClassNameId = level2ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel2ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level2ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel2FormId() {
		return _level2FormId;
	}

	@Override
	public void setLevel2FormId(long level2FormId) {
		_level2FormId = level2FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel2FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level2FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel3ClassNameId() {
		return _level3ClassNameId;
	}

	@Override
	public void setLevel3ClassNameId(long level3ClassNameId) {
		_level3ClassNameId = level3ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel3ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level3ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel3FormId() {
		return _level3FormId;
	}

	@Override
	public void setLevel3FormId(long level3FormId) {
		_level3FormId = level3FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel3FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level3FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel4ClassNameId() {
		return _level4ClassNameId;
	}

	@Override
	public void setLevel4ClassNameId(long level4ClassNameId) {
		_level4ClassNameId = level4ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel4ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level4ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel4FormId() {
		return _level4FormId;
	}

	@Override
	public void setLevel4FormId(long level4FormId) {
		_level4FormId = level4FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel4FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level4FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel5ClassNameId() {
		return _level5ClassNameId;
	}

	@Override
	public void setLevel5ClassNameId(long level5ClassNameId) {
		_level5ClassNameId = level5ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel5ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level5ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel5FormId() {
		return _level5FormId;
	}

	@Override
	public void setLevel5FormId(long level5FormId) {
		_level5FormId = level5FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel5FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level5FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel6ClassNameId() {
		return _level6ClassNameId;
	}

	@Override
	public void setLevel6ClassNameId(long level6ClassNameId) {
		_level6ClassNameId = level6ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel6ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level6ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel6FormId() {
		return _level6FormId;
	}

	@Override
	public void setLevel6FormId(long level6FormId) {
		_level6FormId = level6FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel6FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level6FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel7ClassNameId() {
		return _level7ClassNameId;
	}

	@Override
	public void setLevel7ClassNameId(long level7ClassNameId) {
		_level7ClassNameId = level7ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel7ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level7ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel7FormId() {
		return _level7FormId;
	}

	@Override
	public void setLevel7FormId(long level7FormId) {
		_level7FormId = level7FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel7FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level7FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel8ClassNameId() {
		return _level8ClassNameId;
	}

	@Override
	public void setLevel8ClassNameId(long level8ClassNameId) {
		_level8ClassNameId = level8ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel8ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level8ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel8FormId() {
		return _level8FormId;
	}

	@Override
	public void setLevel8FormId(long level8FormId) {
		_level8FormId = level8FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel8FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level8FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel9ClassNameId() {
		return _level9ClassNameId;
	}

	@Override
	public void setLevel9ClassNameId(long level9ClassNameId) {
		_level9ClassNameId = level9ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel9ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel, level9ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel9FormId() {
		return _level9FormId;
	}

	@Override
	public void setLevel9FormId(long level9FormId) {
		_level9FormId = level9FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel9FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level9FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel10ClassNameId() {
		return _level10ClassNameId;
	}

	@Override
	public void setLevel10ClassNameId(long level10ClassNameId) {
		_level10ClassNameId = level10ClassNameId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel10ClassNameId",
						long.class);

				method.invoke(_spComponentTemplateRemoteModel,
					level10ClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel10FormId() {
		return _level10FormId;
	}

	@Override
	public void setLevel10FormId(long level10FormId) {
		_level10FormId = level10FormId;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel10FormId", long.class);

				method.invoke(_spComponentTemplateRemoteModel, level10FormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_spComponentTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _spComponentTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_spComponentTemplateRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPComponentTemplate.class.getName()));
	}

	public BaseModel<?> getSPComponentTemplateRemoteModel() {
		return _spComponentTemplateRemoteModel;
	}

	public void setSPComponentTemplateRemoteModel(
		BaseModel<?> spComponentTemplateRemoteModel) {
		_spComponentTemplateRemoteModel = spComponentTemplateRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _spComponentTemplateRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_spComponentTemplateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPComponentTemplateLocalServiceUtil.addSPComponentTemplate(this);
		}
		else {
			SPComponentTemplateLocalServiceUtil.updateSPComponentTemplate(this);
		}
	}

	@Override
	public SPComponentTemplate toEscapedModel() {
		return (SPComponentTemplate)ProxyUtil.newProxyInstance(SPComponentTemplate.class.getClassLoader(),
			new Class[] { SPComponentTemplate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPComponentTemplateClp clone = new SPComponentTemplateClp();

		clone.setUuid(getUuid());
		clone.setSpComponentTemplateId(getSpComponentTemplateId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCreateBy(getCreateBy());
		clone.setModifiedBy(getModifiedBy());
		clone.setSpTemplateId(getSpTemplateId());
		clone.setLevel0ClassNameId(getLevel0ClassNameId());
		clone.setLevel0FormId(getLevel0FormId());
		clone.setLevel1ClassNameId(getLevel1ClassNameId());
		clone.setLevel1FormId(getLevel1FormId());
		clone.setLevel2ClassNameId(getLevel2ClassNameId());
		clone.setLevel2FormId(getLevel2FormId());
		clone.setLevel3ClassNameId(getLevel3ClassNameId());
		clone.setLevel3FormId(getLevel3FormId());
		clone.setLevel4ClassNameId(getLevel4ClassNameId());
		clone.setLevel4FormId(getLevel4FormId());
		clone.setLevel5ClassNameId(getLevel5ClassNameId());
		clone.setLevel5FormId(getLevel5FormId());
		clone.setLevel6ClassNameId(getLevel6ClassNameId());
		clone.setLevel6FormId(getLevel6FormId());
		clone.setLevel7ClassNameId(getLevel7ClassNameId());
		clone.setLevel7FormId(getLevel7FormId());
		clone.setLevel8ClassNameId(getLevel8ClassNameId());
		clone.setLevel8FormId(getLevel8FormId());
		clone.setLevel9ClassNameId(getLevel9ClassNameId());
		clone.setLevel9FormId(getLevel9FormId());
		clone.setLevel10ClassNameId(getLevel10ClassNameId());
		clone.setLevel10FormId(getLevel10FormId());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(SPComponentTemplate spComponentTemplate) {
		long primaryKey = spComponentTemplate.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPComponentTemplateClp)) {
			return false;
		}

		SPComponentTemplateClp spComponentTemplate = (SPComponentTemplateClp)obj;

		long primaryKey = spComponentTemplate.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(69);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spComponentTemplateId=");
		sb.append(getSpComponentTemplateId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", createBy=");
		sb.append(getCreateBy());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", spTemplateId=");
		sb.append(getSpTemplateId());
		sb.append(", level0ClassNameId=");
		sb.append(getLevel0ClassNameId());
		sb.append(", level0FormId=");
		sb.append(getLevel0FormId());
		sb.append(", level1ClassNameId=");
		sb.append(getLevel1ClassNameId());
		sb.append(", level1FormId=");
		sb.append(getLevel1FormId());
		sb.append(", level2ClassNameId=");
		sb.append(getLevel2ClassNameId());
		sb.append(", level2FormId=");
		sb.append(getLevel2FormId());
		sb.append(", level3ClassNameId=");
		sb.append(getLevel3ClassNameId());
		sb.append(", level3FormId=");
		sb.append(getLevel3FormId());
		sb.append(", level4ClassNameId=");
		sb.append(getLevel4ClassNameId());
		sb.append(", level4FormId=");
		sb.append(getLevel4FormId());
		sb.append(", level5ClassNameId=");
		sb.append(getLevel5ClassNameId());
		sb.append(", level5FormId=");
		sb.append(getLevel5FormId());
		sb.append(", level6ClassNameId=");
		sb.append(getLevel6ClassNameId());
		sb.append(", level6FormId=");
		sb.append(getLevel6FormId());
		sb.append(", level7ClassNameId=");
		sb.append(getLevel7ClassNameId());
		sb.append(", level7FormId=");
		sb.append(getLevel7FormId());
		sb.append(", level8ClassNameId=");
		sb.append(getLevel8ClassNameId());
		sb.append(", level8FormId=");
		sb.append(getLevel8FormId());
		sb.append(", level9ClassNameId=");
		sb.append(getLevel9ClassNameId());
		sb.append(", level9FormId=");
		sb.append(getLevel9FormId());
		sb.append(", level10ClassNameId=");
		sb.append(getLevel10ClassNameId());
		sb.append(", level10FormId=");
		sb.append(getLevel10FormId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(106);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.template.model.SPComponentTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spComponentTemplateId</column-name><column-value><![CDATA[");
		sb.append(getSpComponentTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createBy</column-name><column-value><![CDATA[");
		sb.append(getCreateBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spTemplateId</column-name><column-value><![CDATA[");
		sb.append(getSpTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level0ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel0ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level0FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel0FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level1ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel1ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level1FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel1FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level2ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel2ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level2FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel2FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level3ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel3ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level3FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel3FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level4ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel4ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level4FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel4FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level5ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel5ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level5FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel5FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level6ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel6ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level6FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel6FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level7ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel7ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level7FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel7FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level8ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel8ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level8FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel8FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level9ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel9ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level9FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel9FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level10ClassNameId</column-name><column-value><![CDATA[");
		sb.append(getLevel10ClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level10FormId</column-name><column-value><![CDATA[");
		sb.append(getLevel10FormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spComponentTemplateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _createBy;
	private long _modifiedBy;
	private long _spTemplateId;
	private long _level0ClassNameId;
	private long _level0FormId;
	private long _level1ClassNameId;
	private long _level1FormId;
	private long _level2ClassNameId;
	private long _level2FormId;
	private long _level3ClassNameId;
	private long _level3FormId;
	private long _level4ClassNameId;
	private long _level4FormId;
	private long _level5ClassNameId;
	private long _level5FormId;
	private long _level6ClassNameId;
	private long _level6FormId;
	private long _level7ClassNameId;
	private long _level7FormId;
	private long _level8ClassNameId;
	private long _level8FormId;
	private long _level9ClassNameId;
	private long _level9FormId;
	private long _level10ClassNameId;
	private long _level10FormId;
	private int _status;
	private BaseModel<?> _spComponentTemplateRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.template.service.ClpSerializer.class;
}