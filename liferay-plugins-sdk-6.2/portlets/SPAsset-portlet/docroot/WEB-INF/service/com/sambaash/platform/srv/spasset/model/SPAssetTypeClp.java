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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spasset.service.ClpSerializer;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPAssetTypeClp extends BaseModelImpl<SPAssetType>
	implements SPAssetType {
	public SPAssetTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPAssetType.class;
	}

	@Override
	public String getModelClassName() {
		return SPAssetType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spAssetTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpAssetTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spAssetTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid_", getUuid_());
		attributes.put("spAssetTypeId", getSpAssetTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spAssetTypeName", getSpAssetTypeName());
		attributes.put("status", getStatus());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("spAssetTypeCreateUrl", getSpAssetTypeCreateUrl());
		attributes.put("spAssetTypeDetailUrl", getSpAssetTypeDetailUrl());
		attributes.put("spAssetTypeInnerDetailUrl",
			getSpAssetTypeInnerDetailUrl());
		attributes.put("requiredTermsOfUse", getRequiredTermsOfUse());
		attributes.put("requiredLogin", getRequiredLogin());
		attributes.put("categoryMandatory", getCategoryMandatory());
		attributes.put("notifyUponCreation", getNotifyUponCreation());
		attributes.put("notificationTemplateId", getNotificationTemplateId());
		attributes.put("allowedFileTypes", getAllowedFileTypes());
		attributes.put("maxFileSize", getMaxFileSize());
		attributes.put("minImageHeight", getMinImageHeight());
		attributes.put("minImageWidth", getMinImageWidth());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid_ = (String)attributes.get("uuid_");

		if (uuid_ != null) {
			setUuid_(uuid_);
		}

		Long spAssetTypeId = (Long)attributes.get("spAssetTypeId");

		if (spAssetTypeId != null) {
			setSpAssetTypeId(spAssetTypeId);
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

		String spAssetTypeName = (String)attributes.get("spAssetTypeName");

		if (spAssetTypeName != null) {
			setSpAssetTypeName(spAssetTypeName);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		String spAssetTypeCreateUrl = (String)attributes.get(
				"spAssetTypeCreateUrl");

		if (spAssetTypeCreateUrl != null) {
			setSpAssetTypeCreateUrl(spAssetTypeCreateUrl);
		}

		String spAssetTypeDetailUrl = (String)attributes.get(
				"spAssetTypeDetailUrl");

		if (spAssetTypeDetailUrl != null) {
			setSpAssetTypeDetailUrl(spAssetTypeDetailUrl);
		}

		String spAssetTypeInnerDetailUrl = (String)attributes.get(
				"spAssetTypeInnerDetailUrl");

		if (spAssetTypeInnerDetailUrl != null) {
			setSpAssetTypeInnerDetailUrl(spAssetTypeInnerDetailUrl);
		}

		Boolean requiredTermsOfUse = (Boolean)attributes.get(
				"requiredTermsOfUse");

		if (requiredTermsOfUse != null) {
			setRequiredTermsOfUse(requiredTermsOfUse);
		}

		Boolean requiredLogin = (Boolean)attributes.get("requiredLogin");

		if (requiredLogin != null) {
			setRequiredLogin(requiredLogin);
		}

		Boolean categoryMandatory = (Boolean)attributes.get("categoryMandatory");

		if (categoryMandatory != null) {
			setCategoryMandatory(categoryMandatory);
		}

		Boolean notifyUponCreation = (Boolean)attributes.get(
				"notifyUponCreation");

		if (notifyUponCreation != null) {
			setNotifyUponCreation(notifyUponCreation);
		}

		Long notificationTemplateId = (Long)attributes.get(
				"notificationTemplateId");

		if (notificationTemplateId != null) {
			setNotificationTemplateId(notificationTemplateId);
		}

		String allowedFileTypes = (String)attributes.get("allowedFileTypes");

		if (allowedFileTypes != null) {
			setAllowedFileTypes(allowedFileTypes);
		}

		Integer maxFileSize = (Integer)attributes.get("maxFileSize");

		if (maxFileSize != null) {
			setMaxFileSize(maxFileSize);
		}

		Integer minImageHeight = (Integer)attributes.get("minImageHeight");

		if (minImageHeight != null) {
			setMinImageHeight(minImageHeight);
		}

		Integer minImageWidth = (Integer)attributes.get("minImageWidth");

		if (minImageWidth != null) {
			setMinImageWidth(minImageWidth);
		}
	}

	@Override
	public String getUuid_() {
		return _uuid_;
	}

	@Override
	public void setUuid_(String uuid_) {
		_uuid_ = uuid_;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid_", String.class);

				method.invoke(_spAssetTypeRemoteModel, uuid_);
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

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssetTypeId", long.class);

				method.invoke(_spAssetTypeRemoteModel, spAssetTypeId);
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

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spAssetTypeRemoteModel, groupId);
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

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spAssetTypeRemoteModel, companyId);
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

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spAssetTypeRemoteModel, userId);
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

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spAssetTypeRemoteModel, userName);
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

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spAssetTypeRemoteModel, createDate);
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

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spAssetTypeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpAssetTypeName() {
		return _spAssetTypeName;
	}

	@Override
	public void setSpAssetTypeName(String spAssetTypeName) {
		_spAssetTypeName = spAssetTypeName;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssetTypeName",
						String.class);

				method.invoke(_spAssetTypeRemoteModel, spAssetTypeName);
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

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_spAssetTypeRemoteModel, status);
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

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", String.class);

				method.invoke(_spAssetTypeRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpAssetTypeCreateUrl() {
		return _spAssetTypeCreateUrl;
	}

	@Override
	public void setSpAssetTypeCreateUrl(String spAssetTypeCreateUrl) {
		_spAssetTypeCreateUrl = spAssetTypeCreateUrl;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssetTypeCreateUrl",
						String.class);

				method.invoke(_spAssetTypeRemoteModel, spAssetTypeCreateUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpAssetTypeDetailUrl() {
		return _spAssetTypeDetailUrl;
	}

	@Override
	public void setSpAssetTypeDetailUrl(String spAssetTypeDetailUrl) {
		_spAssetTypeDetailUrl = spAssetTypeDetailUrl;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssetTypeDetailUrl",
						String.class);

				method.invoke(_spAssetTypeRemoteModel, spAssetTypeDetailUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpAssetTypeInnerDetailUrl() {
		return _spAssetTypeInnerDetailUrl;
	}

	@Override
	public void setSpAssetTypeInnerDetailUrl(String spAssetTypeInnerDetailUrl) {
		_spAssetTypeInnerDetailUrl = spAssetTypeInnerDetailUrl;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpAssetTypeInnerDetailUrl",
						String.class);

				method.invoke(_spAssetTypeRemoteModel, spAssetTypeInnerDetailUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRequiredTermsOfUse() {
		return _requiredTermsOfUse;
	}

	@Override
	public boolean isRequiredTermsOfUse() {
		return _requiredTermsOfUse;
	}

	@Override
	public void setRequiredTermsOfUse(boolean requiredTermsOfUse) {
		_requiredTermsOfUse = requiredTermsOfUse;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredTermsOfUse",
						boolean.class);

				method.invoke(_spAssetTypeRemoteModel, requiredTermsOfUse);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRequiredLogin() {
		return _requiredLogin;
	}

	@Override
	public boolean isRequiredLogin() {
		return _requiredLogin;
	}

	@Override
	public void setRequiredLogin(boolean requiredLogin) {
		_requiredLogin = requiredLogin;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredLogin",
						boolean.class);

				method.invoke(_spAssetTypeRemoteModel, requiredLogin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCategoryMandatory() {
		return _categoryMandatory;
	}

	@Override
	public boolean isCategoryMandatory() {
		return _categoryMandatory;
	}

	@Override
	public void setCategoryMandatory(boolean categoryMandatory) {
		_categoryMandatory = categoryMandatory;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryMandatory",
						boolean.class);

				method.invoke(_spAssetTypeRemoteModel, categoryMandatory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNotifyUponCreation() {
		return _notifyUponCreation;
	}

	@Override
	public boolean isNotifyUponCreation() {
		return _notifyUponCreation;
	}

	@Override
	public void setNotifyUponCreation(boolean notifyUponCreation) {
		_notifyUponCreation = notifyUponCreation;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setNotifyUponCreation",
						boolean.class);

				method.invoke(_spAssetTypeRemoteModel, notifyUponCreation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNotificationTemplateId() {
		return _notificationTemplateId;
	}

	@Override
	public void setNotificationTemplateId(long notificationTemplateId) {
		_notificationTemplateId = notificationTemplateId;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationTemplateId",
						long.class);

				method.invoke(_spAssetTypeRemoteModel, notificationTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAllowedFileTypes() {
		return _allowedFileTypes;
	}

	@Override
	public void setAllowedFileTypes(String allowedFileTypes) {
		_allowedFileTypes = allowedFileTypes;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setAllowedFileTypes",
						String.class);

				method.invoke(_spAssetTypeRemoteModel, allowedFileTypes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMaxFileSize() {
		return _maxFileSize;
	}

	@Override
	public void setMaxFileSize(int maxFileSize) {
		_maxFileSize = maxFileSize;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxFileSize", int.class);

				method.invoke(_spAssetTypeRemoteModel, maxFileSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMinImageHeight() {
		return _minImageHeight;
	}

	@Override
	public void setMinImageHeight(int minImageHeight) {
		_minImageHeight = minImageHeight;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMinImageHeight", int.class);

				method.invoke(_spAssetTypeRemoteModel, minImageHeight);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMinImageWidth() {
		return _minImageWidth;
	}

	@Override
	public void setMinImageWidth(int minImageWidth) {
		_minImageWidth = minImageWidth;

		if (_spAssetTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spAssetTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMinImageWidth", int.class);

				method.invoke(_spAssetTypeRemoteModel, minImageWidth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPAssetTypeRemoteModel() {
		return _spAssetTypeRemoteModel;
	}

	public void setSPAssetTypeRemoteModel(BaseModel<?> spAssetTypeRemoteModel) {
		_spAssetTypeRemoteModel = spAssetTypeRemoteModel;
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

		Class<?> remoteModelClass = _spAssetTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spAssetTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPAssetTypeLocalServiceUtil.addSPAssetType(this);
		}
		else {
			SPAssetTypeLocalServiceUtil.updateSPAssetType(this);
		}
	}

	@Override
	public SPAssetType toEscapedModel() {
		return (SPAssetType)ProxyUtil.newProxyInstance(SPAssetType.class.getClassLoader(),
			new Class[] { SPAssetType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPAssetTypeClp clone = new SPAssetTypeClp();

		clone.setUuid_(getUuid_());
		clone.setSpAssetTypeId(getSpAssetTypeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpAssetTypeName(getSpAssetTypeName());
		clone.setStatus(getStatus());
		clone.setModifiedBy(getModifiedBy());
		clone.setSpAssetTypeCreateUrl(getSpAssetTypeCreateUrl());
		clone.setSpAssetTypeDetailUrl(getSpAssetTypeDetailUrl());
		clone.setSpAssetTypeInnerDetailUrl(getSpAssetTypeInnerDetailUrl());
		clone.setRequiredTermsOfUse(getRequiredTermsOfUse());
		clone.setRequiredLogin(getRequiredLogin());
		clone.setCategoryMandatory(getCategoryMandatory());
		clone.setNotifyUponCreation(getNotifyUponCreation());
		clone.setNotificationTemplateId(getNotificationTemplateId());
		clone.setAllowedFileTypes(getAllowedFileTypes());
		clone.setMaxFileSize(getMaxFileSize());
		clone.setMinImageHeight(getMinImageHeight());
		clone.setMinImageWidth(getMinImageWidth());

		return clone;
	}

	@Override
	public int compareTo(SPAssetType spAssetType) {
		long primaryKey = spAssetType.getPrimaryKey();

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

		if (!(obj instanceof SPAssetTypeClp)) {
			return false;
		}

		SPAssetTypeClp spAssetType = (SPAssetTypeClp)obj;

		long primaryKey = spAssetType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid_=");
		sb.append(getUuid_());
		sb.append(", spAssetTypeId=");
		sb.append(getSpAssetTypeId());
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
		sb.append(", spAssetTypeName=");
		sb.append(getSpAssetTypeName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", spAssetTypeCreateUrl=");
		sb.append(getSpAssetTypeCreateUrl());
		sb.append(", spAssetTypeDetailUrl=");
		sb.append(getSpAssetTypeDetailUrl());
		sb.append(", spAssetTypeInnerDetailUrl=");
		sb.append(getSpAssetTypeInnerDetailUrl());
		sb.append(", requiredTermsOfUse=");
		sb.append(getRequiredTermsOfUse());
		sb.append(", requiredLogin=");
		sb.append(getRequiredLogin());
		sb.append(", categoryMandatory=");
		sb.append(getCategoryMandatory());
		sb.append(", notifyUponCreation=");
		sb.append(getNotifyUponCreation());
		sb.append(", notificationTemplateId=");
		sb.append(getNotificationTemplateId());
		sb.append(", allowedFileTypes=");
		sb.append(getAllowedFileTypes());
		sb.append(", maxFileSize=");
		sb.append(getMaxFileSize());
		sb.append(", minImageHeight=");
		sb.append(getMinImageHeight());
		sb.append(", minImageWidth=");
		sb.append(getMinImageWidth());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spasset.model.SPAssetType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid_</column-name><column-value><![CDATA[");
		sb.append(getUuid_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAssetTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpAssetTypeId());
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
			"<column><column-name>spAssetTypeName</column-name><column-value><![CDATA[");
		sb.append(getSpAssetTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAssetTypeCreateUrl</column-name><column-value><![CDATA[");
		sb.append(getSpAssetTypeCreateUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAssetTypeDetailUrl</column-name><column-value><![CDATA[");
		sb.append(getSpAssetTypeDetailUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spAssetTypeInnerDetailUrl</column-name><column-value><![CDATA[");
		sb.append(getSpAssetTypeInnerDetailUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiredTermsOfUse</column-name><column-value><![CDATA[");
		sb.append(getRequiredTermsOfUse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiredLogin</column-name><column-value><![CDATA[");
		sb.append(getRequiredLogin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryMandatory</column-name><column-value><![CDATA[");
		sb.append(getCategoryMandatory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notifyUponCreation</column-name><column-value><![CDATA[");
		sb.append(getNotifyUponCreation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationTemplateId</column-name><column-value><![CDATA[");
		sb.append(getNotificationTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allowedFileTypes</column-name><column-value><![CDATA[");
		sb.append(getAllowedFileTypes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxFileSize</column-name><column-value><![CDATA[");
		sb.append(getMaxFileSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minImageHeight</column-name><column-value><![CDATA[");
		sb.append(getMinImageHeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minImageWidth</column-name><column-value><![CDATA[");
		sb.append(getMinImageWidth());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid_;
	private long _spAssetTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _spAssetTypeName;
	private boolean _status;
	private String _modifiedBy;
	private String _spAssetTypeCreateUrl;
	private String _spAssetTypeDetailUrl;
	private String _spAssetTypeInnerDetailUrl;
	private boolean _requiredTermsOfUse;
	private boolean _requiredLogin;
	private boolean _categoryMandatory;
	private boolean _notifyUponCreation;
	private long _notificationTemplateId;
	private String _allowedFileTypes;
	private int _maxFileSize;
	private int _minImageHeight;
	private int _minImageWidth;
	private BaseModel<?> _spAssetTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spasset.service.ClpSerializer.class;
}