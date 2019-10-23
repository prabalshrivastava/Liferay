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

package com.sambaash.platform.srv.sharing.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.sharing.service.ClpSerializer;
import com.sambaash.platform.srv.sharing.service.SPSharingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPSharingClp extends BaseModelImpl<SPSharing> implements SPSharing {
	public SPSharingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPSharing.class;
	}

	@Override
	public String getModelClassName() {
		return SPSharing.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spSharingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpSharingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spSharingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spSharingId", getSpSharingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("duration", getDuration());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("url", getUrl());
		attributes.put("expired", getExpired());
		attributes.put("internalShare", getInternalShare());
		attributes.put("writePermission", getWritePermission());
		attributes.put("viewCount", getViewCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spSharingId = (Long)attributes.get("spSharingId");

		if (spSharingId != null) {
			setSpSharingId(spSharingId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Integer duration = (Integer)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Boolean expired = (Boolean)attributes.get("expired");

		if (expired != null) {
			setExpired(expired);
		}

		Boolean internalShare = (Boolean)attributes.get("internalShare");

		if (internalShare != null) {
			setInternalShare(internalShare);
		}

		Boolean writePermission = (Boolean)attributes.get("writePermission");

		if (writePermission != null) {
			setWritePermission(writePermission);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}
	}

	@Override
	public long getSpSharingId() {
		return _spSharingId;
	}

	@Override
	public void setSpSharingId(long spSharingId) {
		_spSharingId = spSharingId;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpSharingId", long.class);

				method.invoke(_spSharingRemoteModel, spSharingId);
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

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spSharingRemoteModel, groupId);
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

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spSharingRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_spSharingRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spSharingRemoteModel, userName);
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

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spSharingRemoteModel, createDate);
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

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spSharingRemoteModel, modifiedDate);
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

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spSharingRemoteModel, userId);
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
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_spSharingRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_spSharingRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_spSharingRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDuration() {
		return _duration;
	}

	@Override
	public void setDuration(int duration) {
		_duration = duration;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", int.class);

				method.invoke(_spSharingRemoteModel, duration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_spSharingRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_spSharingRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_spSharingRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getExpired() {
		return _expired;
	}

	@Override
	public boolean isExpired() {
		return _expired;
	}

	@Override
	public void setExpired(boolean expired) {
		_expired = expired;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setExpired", boolean.class);

				method.invoke(_spSharingRemoteModel, expired);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getInternalShare() {
		return _internalShare;
	}

	@Override
	public boolean isInternalShare() {
		return _internalShare;
	}

	@Override
	public void setInternalShare(boolean internalShare) {
		_internalShare = internalShare;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setInternalShare",
						boolean.class);

				method.invoke(_spSharingRemoteModel, internalShare);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getWritePermission() {
		return _writePermission;
	}

	@Override
	public boolean isWritePermission() {
		return _writePermission;
	}

	@Override
	public void setWritePermission(boolean writePermission) {
		_writePermission = writePermission;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setWritePermission",
						boolean.class);

				method.invoke(_spSharingRemoteModel, writePermission);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getViewCount() {
		return _viewCount;
	}

	@Override
	public void setViewCount(int viewCount) {
		_viewCount = viewCount;

		if (_spSharingRemoteModel != null) {
			try {
				Class<?> clazz = _spSharingRemoteModel.getClass();

				Method method = clazz.getMethod("setViewCount", int.class);

				method.invoke(_spSharingRemoteModel, viewCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPSharingRemoteModel() {
		return _spSharingRemoteModel;
	}

	public void setSPSharingRemoteModel(BaseModel<?> spSharingRemoteModel) {
		_spSharingRemoteModel = spSharingRemoteModel;
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

		Class<?> remoteModelClass = _spSharingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spSharingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPSharingLocalServiceUtil.addSPSharing(this);
		}
		else {
			SPSharingLocalServiceUtil.updateSPSharing(this);
		}
	}

	@Override
	public SPSharing toEscapedModel() {
		return (SPSharing)ProxyUtil.newProxyInstance(SPSharing.class.getClassLoader(),
			new Class[] { SPSharing.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPSharingClp clone = new SPSharingClp();

		clone.setSpSharingId(getSpSharingId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedBy(getCreatedBy());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setEmailAddress(getEmailAddress());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());
		clone.setDuration(getDuration());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setUrl(getUrl());
		clone.setExpired(getExpired());
		clone.setInternalShare(getInternalShare());
		clone.setWritePermission(getWritePermission());
		clone.setViewCount(getViewCount());

		return clone;
	}

	@Override
	public int compareTo(SPSharing spSharing) {
		long primaryKey = spSharing.getPrimaryKey();

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

		if (!(obj instanceof SPSharingClp)) {
			return false;
		}

		SPSharingClp spSharing = (SPSharingClp)obj;

		long primaryKey = spSharing.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{spSharingId=");
		sb.append(getSpSharingId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", expired=");
		sb.append(getExpired());
		sb.append(", internalShare=");
		sb.append(getInternalShare());
		sb.append(", writePermission=");
		sb.append(getWritePermission());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.sharing.model.SPSharing");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spSharingId</column-name><column-value><![CDATA[");
		sb.append(getSpSharingId());
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
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expired</column-name><column-value><![CDATA[");
		sb.append(getExpired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>internalShare</column-name><column-value><![CDATA[");
		sb.append(getInternalShare());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writePermission</column-name><column-value><![CDATA[");
		sb.append(getWritePermission());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spSharingId;
	private long _groupId;
	private long _companyId;
	private long _createdBy;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _emailAddress;
	private long _classNameId;
	private long _classPK;
	private int _duration;
	private Date _startDate;
	private Date _endDate;
	private String _url;
	private boolean _expired;
	private boolean _internalShare;
	private boolean _writePermission;
	private int _viewCount;
	private BaseModel<?> _spSharingRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.sharing.service.ClpSerializer.class;
}