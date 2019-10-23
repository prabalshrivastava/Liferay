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

package com.sambaash.platform.srv.extendedprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.extendedprofile.service.ClpSerializer;
import com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPCompetencyClp extends BaseModelImpl<SPCompetency>
	implements SPCompetency {
	public SPCompetencyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPCompetency.class;
	}

	@Override
	public String getModelClassName() {
		return SPCompetency.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _classpk;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClasspk(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _classpk;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("classpk", getClasspk());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("competencyId", getCompetencyId());
		attributes.put("competencyLevelId", getCompetencyLevelId());
		attributes.put("belongsToJobRole", getBelongsToJobRole());
		attributes.put("publicView", getPublicView());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long classpk = (Long)attributes.get("classpk");

		if (classpk != null) {
			setClasspk(classpk);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long competencyId = (Long)attributes.get("competencyId");

		if (competencyId != null) {
			setCompetencyId(competencyId);
		}

		Long competencyLevelId = (Long)attributes.get("competencyLevelId");

		if (competencyLevelId != null) {
			setCompetencyLevelId(competencyLevelId);
		}

		Long belongsToJobRole = (Long)attributes.get("belongsToJobRole");

		if (belongsToJobRole != null) {
			setBelongsToJobRole(belongsToJobRole);
		}

		Boolean publicView = (Boolean)attributes.get("publicView");

		if (publicView != null) {
			setPublicView(publicView);
		}
	}

	@Override
	public long getClasspk() {
		return _classpk;
	}

	@Override
	public void setClasspk(long classpk) {
		_classpk = classpk;

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setClasspk", long.class);

				method.invoke(_spCompetencyRemoteModel, classpk);
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

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spCompetencyRemoteModel, groupId);
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

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spCompetencyRemoteModel, companyId);
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

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spCompetencyRemoteModel, userId);
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

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spCompetencyRemoteModel, userName);
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

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spCompetencyRemoteModel, createDate);
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

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spCompetencyRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_spCompetencyRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompetencyId() {
		return _competencyId;
	}

	@Override
	public void setCompetencyId(long competencyId) {
		_competencyId = competencyId;

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCompetencyId", long.class);

				method.invoke(_spCompetencyRemoteModel, competencyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompetencyLevelId() {
		return _competencyLevelId;
	}

	@Override
	public void setCompetencyLevelId(long competencyLevelId) {
		_competencyLevelId = competencyLevelId;

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCompetencyLevelId",
						long.class);

				method.invoke(_spCompetencyRemoteModel, competencyLevelId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBelongsToJobRole() {
		return _belongsToJobRole;
	}

	@Override
	public void setBelongsToJobRole(long belongsToJobRole) {
		_belongsToJobRole = belongsToJobRole;

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setBelongsToJobRole",
						long.class);

				method.invoke(_spCompetencyRemoteModel, belongsToJobRole);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPublicView() {
		return _publicView;
	}

	@Override
	public boolean isPublicView() {
		return _publicView;
	}

	@Override
	public void setPublicView(boolean publicView) {
		_publicView = publicView;

		if (_spCompetencyRemoteModel != null) {
			try {
				Class<?> clazz = _spCompetencyRemoteModel.getClass();

				Method method = clazz.getMethod("setPublicView", boolean.class);

				method.invoke(_spCompetencyRemoteModel, publicView);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPCompetencyRemoteModel() {
		return _spCompetencyRemoteModel;
	}

	public void setSPCompetencyRemoteModel(BaseModel<?> spCompetencyRemoteModel) {
		_spCompetencyRemoteModel = spCompetencyRemoteModel;
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

		Class<?> remoteModelClass = _spCompetencyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spCompetencyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPCompetencyLocalServiceUtil.addSPCompetency(this);
		}
		else {
			SPCompetencyLocalServiceUtil.updateSPCompetency(this);
		}
	}

	@Override
	public SPCompetency toEscapedModel() {
		return (SPCompetency)ProxyUtil.newProxyInstance(SPCompetency.class.getClassLoader(),
			new Class[] { SPCompetency.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPCompetencyClp clone = new SPCompetencyClp();

		clone.setClasspk(getClasspk());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCategoryId(getCategoryId());
		clone.setCompetencyId(getCompetencyId());
		clone.setCompetencyLevelId(getCompetencyLevelId());
		clone.setBelongsToJobRole(getBelongsToJobRole());
		clone.setPublicView(getPublicView());

		return clone;
	}

	@Override
	public int compareTo(SPCompetency spCompetency) {
		int value = 0;

		if (getUserId() < spCompetency.getUserId()) {
			value = -1;
		}
		else if (getUserId() > spCompetency.getUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof SPCompetencyClp)) {
			return false;
		}

		SPCompetencyClp spCompetency = (SPCompetencyClp)obj;

		long primaryKey = spCompetency.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{classpk=");
		sb.append(getClasspk());
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
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", competencyId=");
		sb.append(getCompetencyId());
		sb.append(", competencyLevelId=");
		sb.append(getCompetencyLevelId());
		sb.append(", belongsToJobRole=");
		sb.append(getBelongsToJobRole());
		sb.append(", publicView=");
		sb.append(getPublicView());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.extendedprofile.model.SPCompetency");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>classpk</column-name><column-value><![CDATA[");
		sb.append(getClasspk());
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
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyId</column-name><column-value><![CDATA[");
		sb.append(getCompetencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyLevelId</column-name><column-value><![CDATA[");
		sb.append(getCompetencyLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>belongsToJobRole</column-name><column-value><![CDATA[");
		sb.append(getBelongsToJobRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicView</column-name><column-value><![CDATA[");
		sb.append(getPublicView());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _classpk;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private long _competencyId;
	private long _competencyLevelId;
	private long _belongsToJobRole;
	private boolean _publicView;
	private BaseModel<?> _spCompetencyRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.extendedprofile.service.ClpSerializer.class;
}