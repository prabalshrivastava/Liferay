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

package com.sambaash.platform.srv.startupprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class ApprovedMentorsClp extends BaseModelImpl<ApprovedMentors>
	implements ApprovedMentors {
	public ApprovedMentorsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ApprovedMentors.class;
	}

	@Override
	public String getModelClassName() {
		return ApprovedMentors.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _mentorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMentorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mentorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("mentorId", getMentorId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("approvedDate", getApprovedDate());
		attributes.put("remarks", getRemarks());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long mentorId = (Long)attributes.get("mentorId");

		if (mentorId != null) {
			setMentorId(mentorId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date approvedDate = (Date)attributes.get("approvedDate");

		if (approvedDate != null) {
			setApprovedDate(approvedDate);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
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

		if (_approvedMentorsRemoteModel != null) {
			try {
				Class<?> clazz = _approvedMentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_approvedMentorsRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMentorId() {
		return _mentorId;
	}

	@Override
	public void setMentorId(long mentorId) {
		_mentorId = mentorId;

		if (_approvedMentorsRemoteModel != null) {
			try {
				Class<?> clazz = _approvedMentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setMentorId", long.class);

				method.invoke(_approvedMentorsRemoteModel, mentorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_approvedMentorsRemoteModel != null) {
			try {
				Class<?> clazz = _approvedMentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_approvedMentorsRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(String userId) {
		_userId = userId;

		if (_approvedMentorsRemoteModel != null) {
			try {
				Class<?> clazz = _approvedMentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", String.class);

				method.invoke(_approvedMentorsRemoteModel, userId);
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

		if (_approvedMentorsRemoteModel != null) {
			try {
				Class<?> clazz = _approvedMentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_approvedMentorsRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getApprovedDate() {
		return _approvedDate;
	}

	@Override
	public void setApprovedDate(Date approvedDate) {
		_approvedDate = approvedDate;

		if (_approvedMentorsRemoteModel != null) {
			try {
				Class<?> clazz = _approvedMentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setApprovedDate", Date.class);

				method.invoke(_approvedMentorsRemoteModel, approvedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemarks() {
		return _remarks;
	}

	@Override
	public void setRemarks(String remarks) {
		_remarks = remarks;

		if (_approvedMentorsRemoteModel != null) {
			try {
				Class<?> clazz = _approvedMentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setRemarks", String.class);

				method.invoke(_approvedMentorsRemoteModel, remarks);
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

		if (_approvedMentorsRemoteModel != null) {
			try {
				Class<?> clazz = _approvedMentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_approvedMentorsRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getLastName() {
		try {
			String methodName = "getLastName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setEmail(java.lang.String email) {
		try {
			String methodName = "setEmail";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { email };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getJobTitle() {
		try {
			String methodName = "getJobTitle";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setLastName(java.lang.String lastName) {
		try {
			String methodName = "setLastName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { lastName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setTitleId(int titleId) {
		try {
			String methodName = "setTitleId";

			Class<?>[] parameterTypes = new Class<?>[] { int.class };

			Object[] parameterValues = new Object[] { titleId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		try {
			String methodName = "setJobTitle";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { jobTitle };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getMobile() {
		try {
			String methodName = "getMobile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setFirstName(java.lang.String firstName) {
		try {
			String methodName = "setFirstName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { firstName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getFirstName() {
		try {
			String methodName = "getFirstName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getEmail() {
		try {
			String methodName = "getEmail";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setMobile(java.lang.String mobile) {
		try {
			String methodName = "setMobile";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { mobile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getTitleId() {
		try {
			String methodName = "getTitleId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getApprovedMentorsRemoteModel() {
		return _approvedMentorsRemoteModel;
	}

	public void setApprovedMentorsRemoteModel(
		BaseModel<?> approvedMentorsRemoteModel) {
		_approvedMentorsRemoteModel = approvedMentorsRemoteModel;
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

		Class<?> remoteModelClass = _approvedMentorsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_approvedMentorsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ApprovedMentorsLocalServiceUtil.addApprovedMentors(this);
		}
		else {
			ApprovedMentorsLocalServiceUtil.updateApprovedMentors(this);
		}
	}

	@Override
	public ApprovedMentors toEscapedModel() {
		return (ApprovedMentors)ProxyUtil.newProxyInstance(ApprovedMentors.class.getClassLoader(),
			new Class[] { ApprovedMentors.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ApprovedMentorsClp clone = new ApprovedMentorsClp();

		clone.setUuid(getUuid());
		clone.setMentorId(getMentorId());
		clone.setOrganizationId(getOrganizationId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setApprovedDate(getApprovedDate());
		clone.setRemarks(getRemarks());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(ApprovedMentors approvedMentors) {
		long primaryKey = approvedMentors.getPrimaryKey();

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

		if (!(obj instanceof ApprovedMentorsClp)) {
			return false;
		}

		ApprovedMentorsClp approvedMentors = (ApprovedMentorsClp)obj;

		long primaryKey = approvedMentors.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", mentorId=");
		sb.append(getMentorId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", approvedDate=");
		sb.append(getApprovedDate());
		sb.append(", remarks=");
		sb.append(getRemarks());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.ApprovedMentors");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mentorId</column-name><column-value><![CDATA[");
		sb.append(getMentorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedDate</column-name><column-value><![CDATA[");
		sb.append(getApprovedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remarks</column-name><column-value><![CDATA[");
		sb.append(getRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _mentorId;
	private long _organizationId;
	private String _userId;
	private Date _createDate;
	private Date _approvedDate;
	private String _remarks;
	private int _status;
	private BaseModel<?> _approvedMentorsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}