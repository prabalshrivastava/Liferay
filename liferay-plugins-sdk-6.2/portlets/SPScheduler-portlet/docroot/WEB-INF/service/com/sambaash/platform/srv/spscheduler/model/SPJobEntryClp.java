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

package com.sambaash.platform.srv.spscheduler.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spscheduler.service.ClpSerializer;
import com.sambaash.platform.srv.spscheduler.service.SPJobEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPJobEntryClp extends BaseModelImpl<SPJobEntry>
	implements SPJobEntry {
	public SPJobEntryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPJobEntry.class;
	}

	@Override
	public String getModelClassName() {
		return SPJobEntry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spJobEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpJobEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spJobEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spJobEntryId", getSpJobEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("jobName", getJobName());
		attributes.put("jobClass", getJobClass());
		attributes.put("portletId", getPortletId());
		attributes.put("status", getStatus());
		attributes.put("statusMsg", getStatusMsg());
		attributes.put("cronExpression", getCronExpression());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spJobEntryId = (Long)attributes.get("spJobEntryId");

		if (spJobEntryId != null) {
			setSpJobEntryId(spJobEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String jobName = (String)attributes.get("jobName");

		if (jobName != null) {
			setJobName(jobName);
		}

		String jobClass = (String)attributes.get("jobClass");

		if (jobClass != null) {
			setJobClass(jobClass);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String statusMsg = (String)attributes.get("statusMsg");

		if (statusMsg != null) {
			setStatusMsg(statusMsg);
		}

		String cronExpression = (String)attributes.get("cronExpression");

		if (cronExpression != null) {
			setCronExpression(cronExpression);
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
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spJobEntryRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpJobEntryId() {
		return _spJobEntryId;
	}

	@Override
	public void setSpJobEntryId(long spJobEntryId) {
		_spJobEntryId = spJobEntryId;

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setSpJobEntryId", long.class);

				method.invoke(_spJobEntryRemoteModel, spJobEntryId);
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

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spJobEntryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobName() {
		return _jobName;
	}

	@Override
	public void setJobName(String jobName) {
		_jobName = jobName;

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setJobName", String.class);

				method.invoke(_spJobEntryRemoteModel, jobName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobClass() {
		return _jobClass;
	}

	@Override
	public void setJobClass(String jobClass) {
		_jobClass = jobClass;

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setJobClass", String.class);

				method.invoke(_spJobEntryRemoteModel, jobClass);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPortletId() {
		return _portletId;
	}

	@Override
	public void setPortletId(String portletId) {
		_portletId = portletId;

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", String.class);

				method.invoke(_spJobEntryRemoteModel, portletId);
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

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_spJobEntryRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusMsg() {
		return _statusMsg;
	}

	@Override
	public void setStatusMsg(String statusMsg) {
		_statusMsg = statusMsg;

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusMsg", String.class);

				method.invoke(_spJobEntryRemoteModel, statusMsg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCronExpression() {
		return _cronExpression;
	}

	@Override
	public void setCronExpression(String cronExpression) {
		_cronExpression = cronExpression;

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCronExpression",
						String.class);

				method.invoke(_spJobEntryRemoteModel, cronExpression);
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

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spJobEntryRemoteModel, companyId);
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

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spJobEntryRemoteModel, userId);
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

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spJobEntryRemoteModel, userName);
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

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spJobEntryRemoteModel, createDate);
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

		if (_spJobEntryRemoteModel != null) {
			try {
				Class<?> clazz = _spJobEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spJobEntryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPJobEntry.class.getName()));
	}

	public BaseModel<?> getSPJobEntryRemoteModel() {
		return _spJobEntryRemoteModel;
	}

	public void setSPJobEntryRemoteModel(BaseModel<?> spJobEntryRemoteModel) {
		_spJobEntryRemoteModel = spJobEntryRemoteModel;
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

		Class<?> remoteModelClass = _spJobEntryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spJobEntryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPJobEntryLocalServiceUtil.addSPJobEntry(this);
		}
		else {
			SPJobEntryLocalServiceUtil.updateSPJobEntry(this);
		}
	}

	@Override
	public SPJobEntry toEscapedModel() {
		return (SPJobEntry)ProxyUtil.newProxyInstance(SPJobEntry.class.getClassLoader(),
			new Class[] { SPJobEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPJobEntryClp clone = new SPJobEntryClp();

		clone.setUuid(getUuid());
		clone.setSpJobEntryId(getSpJobEntryId());
		clone.setGroupId(getGroupId());
		clone.setJobName(getJobName());
		clone.setJobClass(getJobClass());
		clone.setPortletId(getPortletId());
		clone.setStatus(getStatus());
		clone.setStatusMsg(getStatusMsg());
		clone.setCronExpression(getCronExpression());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPJobEntry spJobEntry) {
		long primaryKey = spJobEntry.getPrimaryKey();

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

		if (!(obj instanceof SPJobEntryClp)) {
			return false;
		}

		SPJobEntryClp spJobEntry = (SPJobEntryClp)obj;

		long primaryKey = spJobEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spJobEntryId=");
		sb.append(getSpJobEntryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", jobName=");
		sb.append(getJobName());
		sb.append(", jobClass=");
		sb.append(getJobClass());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusMsg=");
		sb.append(getStatusMsg());
		sb.append(", cronExpression=");
		sb.append(getCronExpression());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spscheduler.model.SPJobEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spJobEntryId</column-name><column-value><![CDATA[");
		sb.append(getSpJobEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobName</column-name><column-value><![CDATA[");
		sb.append(getJobName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobClass</column-name><column-value><![CDATA[");
		sb.append(getJobClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusMsg</column-name><column-value><![CDATA[");
		sb.append(getStatusMsg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cronExpression</column-name><column-value><![CDATA[");
		sb.append(getCronExpression());
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

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spJobEntryId;
	private long _groupId;
	private String _jobName;
	private String _jobClass;
	private String _portletId;
	private int _status;
	private String _statusMsg;
	private String _cronExpression;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spJobEntryRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spscheduler.service.ClpSerializer.class;
}