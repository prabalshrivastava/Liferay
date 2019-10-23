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

package com.sambaash.platform.srv.spsocialprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer;
import com.sambaash.platform.srv.spsocialprofile.service.ExamBodyUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ExamBodyUserClp extends BaseModelImpl<ExamBodyUser>
	implements ExamBodyUser {
	public ExamBodyUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ExamBodyUser.class;
	}

	@Override
	public String getModelClassName() {
		return ExamBodyUser.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _examBodyUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setExamBodyUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _examBodyUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("examBodyUserId", getExamBodyUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("examBody", getExamBody());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long examBodyUserId = (Long)attributes.get("examBodyUserId");

		if (examBodyUserId != null) {
			setExamBodyUserId(examBodyUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String examBody = (String)attributes.get("examBody");

		if (examBody != null) {
			setExamBody(examBody);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public long getExamBodyUserId() {
		return _examBodyUserId;
	}

	@Override
	public void setExamBodyUserId(long examBodyUserId) {
		_examBodyUserId = examBodyUserId;

		if (_examBodyUserRemoteModel != null) {
			try {
				Class<?> clazz = _examBodyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setExamBodyUserId", long.class);

				method.invoke(_examBodyUserRemoteModel, examBodyUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExamBodyUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getExamBodyUserId(), "uuid",
			_examBodyUserUuid);
	}

	@Override
	public void setExamBodyUserUuid(String examBodyUserUuid) {
		_examBodyUserUuid = examBodyUserUuid;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_examBodyUserRemoteModel != null) {
			try {
				Class<?> clazz = _examBodyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_examBodyUserRemoteModel, groupId);
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

		if (_examBodyUserRemoteModel != null) {
			try {
				Class<?> clazz = _examBodyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_examBodyUserRemoteModel, companyId);
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

		if (_examBodyUserRemoteModel != null) {
			try {
				Class<?> clazz = _examBodyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_examBodyUserRemoteModel, createDate);
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

		if (_examBodyUserRemoteModel != null) {
			try {
				Class<?> clazz = _examBodyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_examBodyUserRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_examBodyUserRemoteModel != null) {
			try {
				Class<?> clazz = _examBodyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_examBodyUserRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExamBody() {
		return _examBody;
	}

	@Override
	public void setExamBody(String examBody) {
		_examBody = examBody;

		if (_examBodyUserRemoteModel != null) {
			try {
				Class<?> clazz = _examBodyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setExamBody", String.class);

				method.invoke(_examBodyUserRemoteModel, examBody);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_examBodyUserRemoteModel != null) {
			try {
				Class<?> clazz = _examBodyUserRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_examBodyUserRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getExamBodyUserRemoteModel() {
		return _examBodyUserRemoteModel;
	}

	public void setExamBodyUserRemoteModel(BaseModel<?> examBodyUserRemoteModel) {
		_examBodyUserRemoteModel = examBodyUserRemoteModel;
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

		Class<?> remoteModelClass = _examBodyUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_examBodyUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ExamBodyUserLocalServiceUtil.addExamBodyUser(this);
		}
		else {
			ExamBodyUserLocalServiceUtil.updateExamBodyUser(this);
		}
	}

	@Override
	public ExamBodyUser toEscapedModel() {
		return (ExamBodyUser)ProxyUtil.newProxyInstance(ExamBodyUser.class.getClassLoader(),
			new Class[] { ExamBodyUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ExamBodyUserClp clone = new ExamBodyUserClp();

		clone.setExamBodyUserId(getExamBodyUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEmailAddress(getEmailAddress());
		clone.setExamBody(getExamBody());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(ExamBodyUser examBodyUser) {
		long primaryKey = examBodyUser.getPrimaryKey();

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

		if (!(obj instanceof ExamBodyUserClp)) {
			return false;
		}

		ExamBodyUserClp examBodyUser = (ExamBodyUserClp)obj;

		long primaryKey = examBodyUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{examBodyUserId=");
		sb.append(getExamBodyUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", examBody=");
		sb.append(getExamBody());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>examBodyUserId</column-name><column-value><![CDATA[");
		sb.append(getExamBodyUserId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>examBody</column-name><column-value><![CDATA[");
		sb.append(getExamBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _examBodyUserId;
	private String _examBodyUserUuid;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _emailAddress;
	private String _examBody;
	private boolean _active;
	private BaseModel<?> _examBodyUserRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.class;
}