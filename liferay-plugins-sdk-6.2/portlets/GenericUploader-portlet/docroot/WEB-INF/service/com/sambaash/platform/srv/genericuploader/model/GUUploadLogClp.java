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

package com.sambaash.platform.srv.genericuploader.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.genericuploader.service.ClpSerializer;
import com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class GUUploadLogClp extends BaseModelImpl<GUUploadLog>
	implements GUUploadLog {
	public GUUploadLogClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GUUploadLog.class;
	}

	@Override
	public String getModelClassName() {
		return GUUploadLog.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _SPGUUploadLogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSPGUUploadLogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _SPGUUploadLogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SPGUUploadLogId", getSPGUUploadLogId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("successCount", getSuccessCount());
		attributes.put("errorCount", getErrorCount());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("uploadedFileEntryId", getUploadedFileEntryId());
		attributes.put("errorFileEntryId", getErrorFileEntryId());
		attributes.put("errors", getErrors());
		attributes.put("msgs", getMsgs());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long SPGUUploadLogId = (Long)attributes.get("SPGUUploadLogId");

		if (SPGUUploadLogId != null) {
			setSPGUUploadLogId(SPGUUploadLogId);
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

		Integer successCount = (Integer)attributes.get("successCount");

		if (successCount != null) {
			setSuccessCount(successCount);
		}

		Integer errorCount = (Integer)attributes.get("errorCount");

		if (errorCount != null) {
			setErrorCount(errorCount);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long uploadedFileEntryId = (Long)attributes.get("uploadedFileEntryId");

		if (uploadedFileEntryId != null) {
			setUploadedFileEntryId(uploadedFileEntryId);
		}

		Long errorFileEntryId = (Long)attributes.get("errorFileEntryId");

		if (errorFileEntryId != null) {
			setErrorFileEntryId(errorFileEntryId);
		}

		String errors = (String)attributes.get("errors");

		if (errors != null) {
			setErrors(errors);
		}

		String msgs = (String)attributes.get("msgs");

		if (msgs != null) {
			setMsgs(msgs);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getSPGUUploadLogId() {
		return _SPGUUploadLogId;
	}

	@Override
	public void setSPGUUploadLogId(long SPGUUploadLogId) {
		_SPGUUploadLogId = SPGUUploadLogId;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setSPGUUploadLogId", long.class);

				method.invoke(_guUploadLogRemoteModel, SPGUUploadLogId);
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

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_guUploadLogRemoteModel, groupId);
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

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_guUploadLogRemoteModel, companyId);
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

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_guUploadLogRemoteModel, userId);
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

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_guUploadLogRemoteModel, userName);
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

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_guUploadLogRemoteModel, createDate);
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

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_guUploadLogRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSuccessCount() {
		return _successCount;
	}

	@Override
	public void setSuccessCount(int successCount) {
		_successCount = successCount;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setSuccessCount", int.class);

				method.invoke(_guUploadLogRemoteModel, successCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getErrorCount() {
		return _errorCount;
	}

	@Override
	public void setErrorCount(int errorCount) {
		_errorCount = errorCount;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorCount", int.class);

				method.invoke(_guUploadLogRemoteModel, errorCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", Date.class);

				method.invoke(_guUploadLogRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", Date.class);

				method.invoke(_guUploadLogRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUploadedFileEntryId() {
		return _uploadedFileEntryId;
	}

	@Override
	public void setUploadedFileEntryId(long uploadedFileEntryId) {
		_uploadedFileEntryId = uploadedFileEntryId;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadedFileEntryId",
						long.class);

				method.invoke(_guUploadLogRemoteModel, uploadedFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getErrorFileEntryId() {
		return _errorFileEntryId;
	}

	@Override
	public void setErrorFileEntryId(long errorFileEntryId) {
		_errorFileEntryId = errorFileEntryId;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorFileEntryId",
						long.class);

				method.invoke(_guUploadLogRemoteModel, errorFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getErrors() {
		return _errors;
	}

	@Override
	public void setErrors(String errors) {
		_errors = errors;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setErrors", String.class);

				method.invoke(_guUploadLogRemoteModel, errors);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMsgs() {
		return _msgs;
	}

	@Override
	public void setMsgs(String msgs) {
		_msgs = msgs;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setMsgs", String.class);

				method.invoke(_guUploadLogRemoteModel, msgs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_guUploadLogRemoteModel != null) {
			try {
				Class<?> clazz = _guUploadLogRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_guUploadLogRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGUUploadLogRemoteModel() {
		return _guUploadLogRemoteModel;
	}

	public void setGUUploadLogRemoteModel(BaseModel<?> guUploadLogRemoteModel) {
		_guUploadLogRemoteModel = guUploadLogRemoteModel;
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

		Class<?> remoteModelClass = _guUploadLogRemoteModel.getClass();

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

		Object returnValue = method.invoke(_guUploadLogRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GUUploadLogLocalServiceUtil.addGUUploadLog(this);
		}
		else {
			GUUploadLogLocalServiceUtil.updateGUUploadLog(this);
		}
	}

	@Override
	public GUUploadLog toEscapedModel() {
		return (GUUploadLog)ProxyUtil.newProxyInstance(GUUploadLog.class.getClassLoader(),
			new Class[] { GUUploadLog.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GUUploadLogClp clone = new GUUploadLogClp();

		clone.setSPGUUploadLogId(getSPGUUploadLogId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSuccessCount(getSuccessCount());
		clone.setErrorCount(getErrorCount());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setUploadedFileEntryId(getUploadedFileEntryId());
		clone.setErrorFileEntryId(getErrorFileEntryId());
		clone.setErrors(getErrors());
		clone.setMsgs(getMsgs());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(GUUploadLog guUploadLog) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				guUploadLog.getModifiedDate());

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

		if (!(obj instanceof GUUploadLogClp)) {
			return false;
		}

		GUUploadLogClp guUploadLog = (GUUploadLogClp)obj;

		long primaryKey = guUploadLog.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{SPGUUploadLogId=");
		sb.append(getSPGUUploadLogId());
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
		sb.append(", successCount=");
		sb.append(getSuccessCount());
		sb.append(", errorCount=");
		sb.append(getErrorCount());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", uploadedFileEntryId=");
		sb.append(getUploadedFileEntryId());
		sb.append(", errorFileEntryId=");
		sb.append(getErrorFileEntryId());
		sb.append(", errors=");
		sb.append(getErrors());
		sb.append(", msgs=");
		sb.append(getMsgs());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.genericuploader.model.GUUploadLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>SPGUUploadLogId</column-name><column-value><![CDATA[");
		sb.append(getSPGUUploadLogId());
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
			"<column><column-name>successCount</column-name><column-value><![CDATA[");
		sb.append(getSuccessCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorCount</column-name><column-value><![CDATA[");
		sb.append(getErrorCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uploadedFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getUploadedFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getErrorFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errors</column-name><column-value><![CDATA[");
		sb.append(getErrors());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>msgs</column-name><column-value><![CDATA[");
		sb.append(getMsgs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _SPGUUploadLogId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _successCount;
	private int _errorCount;
	private Date _startTime;
	private Date _endTime;
	private long _uploadedFileEntryId;
	private long _errorFileEntryId;
	private String _errors;
	private String _msgs;
	private String _status;
	private BaseModel<?> _guUploadLogRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.genericuploader.service.ClpSerializer.class;
}