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
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.OrganisationRemarksLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class OrganisationRemarksClp extends BaseModelImpl<OrganisationRemarks>
	implements OrganisationRemarks {
	public OrganisationRemarksClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OrganisationRemarks.class;
	}

	@Override
	public String getModelClassName() {
		return OrganisationRemarks.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _remarksId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRemarksId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _remarksId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("remarksId", getRemarksId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("remarkType", getRemarkType());
		attributes.put("Remarks", getRemarks());
		attributes.put("Notes", getNotes());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long remarksId = (Long)attributes.get("remarksId");

		if (remarksId != null) {
			setRemarksId(remarksId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String remarkType = (String)attributes.get("remarkType");

		if (remarkType != null) {
			setRemarkType(remarkType);
		}

		String Remarks = (String)attributes.get("Remarks");

		if (Remarks != null) {
			setRemarks(Remarks);
		}

		String Notes = (String)attributes.get("Notes");

		if (Notes != null) {
			setNotes(Notes);
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
	}

	@Override
	public long getRemarksId() {
		return _remarksId;
	}

	@Override
	public void setRemarksId(long remarksId) {
		_remarksId = remarksId;

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setRemarksId", long.class);

				method.invoke(_organisationRemarksRemoteModel, remarksId);
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

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_organisationRemarksRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemarkType() {
		return _remarkType;
	}

	@Override
	public void setRemarkType(String remarkType) {
		_remarkType = remarkType;

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setRemarkType", String.class);

				method.invoke(_organisationRemarksRemoteModel, remarkType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemarks() {
		return _Remarks;
	}

	@Override
	public void setRemarks(String Remarks) {
		_Remarks = Remarks;

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setRemarks", String.class);

				method.invoke(_organisationRemarksRemoteModel, Remarks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _Notes;
	}

	@Override
	public void setNotes(String Notes) {
		_Notes = Notes;

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_organisationRemarksRemoteModel, Notes);
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

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_organisationRemarksRemoteModel, groupId);
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

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_organisationRemarksRemoteModel, companyId);
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

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_organisationRemarksRemoteModel, userId);
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

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_organisationRemarksRemoteModel, userName);
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

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_organisationRemarksRemoteModel, createDate);
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

		if (_organisationRemarksRemoteModel != null) {
			try {
				Class<?> clazz = _organisationRemarksRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_organisationRemarksRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrganisationRemarksRemoteModel() {
		return _organisationRemarksRemoteModel;
	}

	public void setOrganisationRemarksRemoteModel(
		BaseModel<?> organisationRemarksRemoteModel) {
		_organisationRemarksRemoteModel = organisationRemarksRemoteModel;
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

		Class<?> remoteModelClass = _organisationRemarksRemoteModel.getClass();

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

		Object returnValue = method.invoke(_organisationRemarksRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrganisationRemarksLocalServiceUtil.addOrganisationRemarks(this);
		}
		else {
			OrganisationRemarksLocalServiceUtil.updateOrganisationRemarks(this);
		}
	}

	@Override
	public OrganisationRemarks toEscapedModel() {
		return (OrganisationRemarks)ProxyUtil.newProxyInstance(OrganisationRemarks.class.getClassLoader(),
			new Class[] { OrganisationRemarks.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrganisationRemarksClp clone = new OrganisationRemarksClp();

		clone.setRemarksId(getRemarksId());
		clone.setOrganizationId(getOrganizationId());
		clone.setRemarkType(getRemarkType());
		clone.setRemarks(getRemarks());
		clone.setNotes(getNotes());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(OrganisationRemarks organisationRemarks) {
		long primaryKey = organisationRemarks.getPrimaryKey();

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

		if (!(obj instanceof OrganisationRemarksClp)) {
			return false;
		}

		OrganisationRemarksClp organisationRemarks = (OrganisationRemarksClp)obj;

		long primaryKey = organisationRemarks.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{remarksId=");
		sb.append(getRemarksId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", remarkType=");
		sb.append(getRemarkType());
		sb.append(", Remarks=");
		sb.append(getRemarks());
		sb.append(", Notes=");
		sb.append(getNotes());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>remarksId</column-name><column-value><![CDATA[");
		sb.append(getRemarksId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remarkType</column-name><column-value><![CDATA[");
		sb.append(getRemarkType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Remarks</column-name><column-value><![CDATA[");
		sb.append(getRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _remarksId;
	private long _organizationId;
	private String _remarkType;
	private String _Remarks;
	private String _Notes;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _organisationRemarksRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}