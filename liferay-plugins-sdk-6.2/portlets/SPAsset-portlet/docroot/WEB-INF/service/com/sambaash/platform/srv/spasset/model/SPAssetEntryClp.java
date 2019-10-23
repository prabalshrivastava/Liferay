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

package com.sambaash.platform.srv.spasset.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spasset.service.ClpSerializer;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPAssetEntryClp extends BaseModelImpl<SPAssetEntry>
	implements SPAssetEntry {
	public SPAssetEntryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPAssetEntry.class;
	}

	@Override
	public String getModelClassName() {
		return SPAssetEntry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spAssetEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpAssetEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spAssetEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid_", getUuid_());
		attributes.put("spAssetEntryId", getSpAssetEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dlFolderId", getDlFolderId());
		attributes.put("coverFileEntryId", getCoverFileEntryId());
		attributes.put("spAssetTypeId", getSpAssetTypeId());
		attributes.put("spAssetEntrySubType", getSpAssetEntrySubType());
		attributes.put("corporateProfileUserId", getCorporateProfileUserId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("title", getTitle());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("description", getDescription());
		attributes.put("content", getContent());
		attributes.put("link", getLink());
		attributes.put("status", getStatus());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("type", getType());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("allowPingbacks", getAllowPingbacks());
		attributes.put("allowTrackbacks", getAllowTrackbacks());
		attributes.put("trackbacks", getTrackbacks());
		attributes.put("permissionType", getPermissionType());
		attributes.put("agreedToTermsOfUse", getAgreedToTermsOfUse());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid_ = (String)attributes.get("uuid_");

		if (uuid_ != null) {
			setUuid_(uuid_);
		}

		Long spAssetEntryId = (Long)attributes.get("spAssetEntryId");

		if (spAssetEntryId != null) {
			setSpAssetEntryId(spAssetEntryId);
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

		Long dlFolderId = (Long)attributes.get("dlFolderId");

		if (dlFolderId != null) {
			setDlFolderId(dlFolderId);
		}

		Long coverFileEntryId = (Long)attributes.get("coverFileEntryId");

		if (coverFileEntryId != null) {
			setCoverFileEntryId(coverFileEntryId);
		}

		Long spAssetTypeId = (Long)attributes.get("spAssetTypeId");

		if (spAssetTypeId != null) {
			setSpAssetTypeId(spAssetTypeId);
		}

		String spAssetEntrySubType = (String)attributes.get(
				"spAssetEntrySubType");

		if (spAssetEntrySubType != null) {
			setSpAssetEntrySubType(spAssetEntrySubType);
		}

		Long corporateProfileUserId = (Long)attributes.get(
				"corporateProfileUserId");

		if (corporateProfileUserId != null) {
			setCorporateProfileUserId(corporateProfileUserId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Boolean allowPingbacks = (Boolean)attributes.get("allowPingbacks");

		if (allowPingbacks != null) {
			setAllowPingbacks(allowPingbacks);
		}

		Boolean allowTrackbacks = (Boolean)attributes.get("allowTrackbacks");

		if (allowTrackbacks != null) {
			setAllowTrackbacks(allowTrackbacks);
		}

		String trackbacks = (String)attributes.get("trackbacks");

		if (trackbacks != null) {
			setTrackbacks(trackbacks);
		}

		Integer permissionType = (Integer)attributes.get("permissionType");

		if (permissionType != null) {
			setPermissionType(permissionType);
		}

		Boolean agreedToTermsOfUse = (Boolean)attributes.get(
				"agreedToTermsOfUse");

		if (agreedToTermsOfUse != null) {
			setAgreedToTermsOfUse(agreedToTermsOfUse);
		}
	}

	@Override
	public String getUuid_() {
		return _uuid_;
	}

	@Override
	public void setUuid_(String uuid_) {
		_uuid_ = uuid_;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid_", String.class);

				method.invoke(_spAssetEntryRemoteModel, uuid_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpAssetEntryId() {
		return _spAssetEntryId;
	}

	@Override
	public void setSpAssetEntryId(long spAssetEntryId) {
		_spAssetEntryId = spAssetEntryId;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssetEntryId", long.class);

				method.invoke(_spAssetEntryRemoteModel, spAssetEntryId);
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

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spAssetEntryRemoteModel, groupId);
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

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spAssetEntryRemoteModel, companyId);
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

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spAssetEntryRemoteModel, userId);
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

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spAssetEntryRemoteModel, userName);
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

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spAssetEntryRemoteModel, createDate);
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

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spAssetEntryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDlFolderId() {
		return _dlFolderId;
	}

	@Override
	public void setDlFolderId(long dlFolderId) {
		_dlFolderId = dlFolderId;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setDlFolderId", long.class);

				method.invoke(_spAssetEntryRemoteModel, dlFolderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCoverFileEntryId() {
		return _coverFileEntryId;
	}

	@Override
	public void setCoverFileEntryId(long coverFileEntryId) {
		_coverFileEntryId = coverFileEntryId;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCoverFileEntryId",
						long.class);

				method.invoke(_spAssetEntryRemoteModel, coverFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpAssetTypeId() {
		return _spAssetTypeId;
	}

	@Override
	public void setSpAssetTypeId(long spAssetTypeId) {
		_spAssetTypeId = spAssetTypeId;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssetTypeId", long.class);

				method.invoke(_spAssetEntryRemoteModel, spAssetTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpAssetEntrySubType() {
		return _spAssetEntrySubType;
	}

	@Override
	public void setSpAssetEntrySubType(String spAssetEntrySubType) {
		_spAssetEntrySubType = spAssetEntrySubType;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssetEntrySubType",
						String.class);

				method.invoke(_spAssetEntryRemoteModel, spAssetEntrySubType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCorporateProfileUserId() {
		return _corporateProfileUserId;
	}

	@Override
	public void setCorporateProfileUserId(long corporateProfileUserId) {
		_corporateProfileUserId = corporateProfileUserId;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCorporateProfileUserId",
						long.class);

				method.invoke(_spAssetEntryRemoteModel, corporateProfileUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCorporateProfileUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCorporateProfileUserId(), "uuid",
			_corporateProfileUserUuid);
	}

	@Override
	public void setCorporateProfileUserUuid(String corporateProfileUserUuid) {
		_corporateProfileUserUuid = corporateProfileUserUuid;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_spAssetEntryRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_spAssetEntryRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrlTitle() {
		return _urlTitle;
	}

	@Override
	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUrlTitle", String.class);

				method.invoke(_spAssetEntryRemoteModel, urlTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_spAssetEntryRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_spAssetEntryRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLink() {
		return _link;
	}

	@Override
	public void setLink(String link) {
		_link = link;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setLink", String.class);

				method.invoke(_spAssetEntryRemoteModel, link);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_spAssetEntryRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_spAssetEntryRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_spAssetEntryRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", String.class);

				method.invoke(_spAssetEntryRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAllowPingbacks() {
		return _allowPingbacks;
	}

	@Override
	public boolean isAllowPingbacks() {
		return _allowPingbacks;
	}

	@Override
	public void setAllowPingbacks(boolean allowPingbacks) {
		_allowPingbacks = allowPingbacks;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAllowPingbacks",
						boolean.class);

				method.invoke(_spAssetEntryRemoteModel, allowPingbacks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAllowTrackbacks() {
		return _allowTrackbacks;
	}

	@Override
	public boolean isAllowTrackbacks() {
		return _allowTrackbacks;
	}

	@Override
	public void setAllowTrackbacks(boolean allowTrackbacks) {
		_allowTrackbacks = allowTrackbacks;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAllowTrackbacks",
						boolean.class);

				method.invoke(_spAssetEntryRemoteModel, allowTrackbacks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTrackbacks() {
		return _trackbacks;
	}

	@Override
	public void setTrackbacks(String trackbacks) {
		_trackbacks = trackbacks;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setTrackbacks", String.class);

				method.invoke(_spAssetEntryRemoteModel, trackbacks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPermissionType() {
		return _permissionType;
	}

	@Override
	public void setPermissionType(int permissionType) {
		_permissionType = permissionType;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setPermissionType", int.class);

				method.invoke(_spAssetEntryRemoteModel, permissionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAgreedToTermsOfUse() {
		return _agreedToTermsOfUse;
	}

	@Override
	public boolean isAgreedToTermsOfUse() {
		return _agreedToTermsOfUse;
	}

	@Override
	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse) {
		_agreedToTermsOfUse = agreedToTermsOfUse;

		if (_spAssetEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAgreedToTermsOfUse",
						boolean.class);

				method.invoke(_spAssetEntryRemoteModel, agreedToTermsOfUse);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPAssetEntryRemoteModel() {
		return _spAssetEntryRemoteModel;
	}

	public void setSPAssetEntryRemoteModel(BaseModel<?> spAssetEntryRemoteModel) {
		_spAssetEntryRemoteModel = spAssetEntryRemoteModel;
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

		Class<?> remoteModelClass = _spAssetEntryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spAssetEntryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPAssetEntryLocalServiceUtil.addSPAssetEntry(this);
		}
		else {
			SPAssetEntryLocalServiceUtil.updateSPAssetEntry(this);
		}
	}

	@Override
	public SPAssetEntry toEscapedModel() {
		return (SPAssetEntry)ProxyUtil.newProxyInstance(SPAssetEntry.class.getClassLoader(),
			new Class[] { SPAssetEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPAssetEntryClp clone = new SPAssetEntryClp();

		clone.setUuid_(getUuid_());
		clone.setSpAssetEntryId(getSpAssetEntryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDlFolderId(getDlFolderId());
		clone.setCoverFileEntryId(getCoverFileEntryId());
		clone.setSpAssetTypeId(getSpAssetTypeId());
		clone.setSpAssetEntrySubType(getSpAssetEntrySubType());
		clone.setCorporateProfileUserId(getCorporateProfileUserId());
		clone.setClassNameId(getClassNameId());
		clone.setTitle(getTitle());
		clone.setUrlTitle(getUrlTitle());
		clone.setDescription(getDescription());
		clone.setContent(getContent());
		clone.setLink(getLink());
		clone.setStatus(getStatus());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setType(getType());
		clone.setModifiedBy(getModifiedBy());
		clone.setAllowPingbacks(getAllowPingbacks());
		clone.setAllowTrackbacks(getAllowTrackbacks());
		clone.setTrackbacks(getTrackbacks());
		clone.setPermissionType(getPermissionType());
		clone.setAgreedToTermsOfUse(getAgreedToTermsOfUse());

		return clone;
	}

	@Override
	public int compareTo(SPAssetEntry spAssetEntry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), spAssetEntry.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPAssetEntryClp)) {
			return false;
		}

		SPAssetEntryClp spAssetEntry = (SPAssetEntryClp)obj;

		long primaryKey = spAssetEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(57);

		sb.append("{uuid_=");
		sb.append(getUuid_());
		sb.append(", spAssetEntryId=");
		sb.append(getSpAssetEntryId());
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
		sb.append(", dlFolderId=");
		sb.append(getDlFolderId());
		sb.append(", coverFileEntryId=");
		sb.append(getCoverFileEntryId());
		sb.append(", spAssetTypeId=");
		sb.append(getSpAssetTypeId());
		sb.append(", spAssetEntrySubType=");
		sb.append(getSpAssetEntrySubType());
		sb.append(", corporateProfileUserId=");
		sb.append(getCorporateProfileUserId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", urlTitle=");
		sb.append(getUrlTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", link=");
		sb.append(getLink());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", allowPingbacks=");
		sb.append(getAllowPingbacks());
		sb.append(", allowTrackbacks=");
		sb.append(getAllowTrackbacks());
		sb.append(", trackbacks=");
		sb.append(getTrackbacks());
		sb.append(", permissionType=");
		sb.append(getPermissionType());
		sb.append(", agreedToTermsOfUse=");
		sb.append(getAgreedToTermsOfUse());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spasset.model.SPAssetEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid_</column-name><column-value><![CDATA[");
		sb.append(getUuid_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAssetEntryId</column-name><column-value><![CDATA[");
		sb.append(getSpAssetEntryId());
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
			"<column><column-name>dlFolderId</column-name><column-value><![CDATA[");
		sb.append(getDlFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coverFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getCoverFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAssetTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpAssetTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAssetEntrySubType</column-name><column-value><![CDATA[");
		sb.append(getSpAssetEntrySubType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporateProfileUserId</column-name><column-value><![CDATA[");
		sb.append(getCorporateProfileUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlTitle</column-name><column-value><![CDATA[");
		sb.append(getUrlTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>link</column-name><column-value><![CDATA[");
		sb.append(getLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allowPingbacks</column-name><column-value><![CDATA[");
		sb.append(getAllowPingbacks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allowTrackbacks</column-name><column-value><![CDATA[");
		sb.append(getAllowTrackbacks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trackbacks</column-name><column-value><![CDATA[");
		sb.append(getTrackbacks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permissionType</column-name><column-value><![CDATA[");
		sb.append(getPermissionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agreedToTermsOfUse</column-name><column-value><![CDATA[");
		sb.append(getAgreedToTermsOfUse());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid_;
	private long _spAssetEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dlFolderId;
	private long _coverFileEntryId;
	private long _spAssetTypeId;
	private String _spAssetEntrySubType;
	private long _corporateProfileUserId;
	private String _corporateProfileUserUuid;
	private long _classNameId;
	private String _title;
	private String _urlTitle;
	private String _description;
	private String _content;
	private String _link;
	private boolean _status;
	private String _statusByUserName;
	private String _type;
	private String _modifiedBy;
	private boolean _allowPingbacks;
	private boolean _allowTrackbacks;
	private String _trackbacks;
	private int _permissionType;
	private boolean _agreedToTermsOfUse;
	private BaseModel<?> _spAssetEntryRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spasset.service.ClpSerializer.class;
}