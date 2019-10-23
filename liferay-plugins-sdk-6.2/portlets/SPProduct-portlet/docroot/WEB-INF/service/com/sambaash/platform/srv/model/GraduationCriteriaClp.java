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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.service.ClpSerializer;
import com.sambaash.platform.srv.service.GraduationCriteriaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class GraduationCriteriaClp extends BaseModelImpl<GraduationCriteria>
	implements GraduationCriteria {
	public GraduationCriteriaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GraduationCriteria.class;
	}

	@Override
	public String getModelClassName() {
		return GraduationCriteria.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spGraduationCriteriaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpGraduationCriteriaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spGraduationCriteriaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spGraduationCriteriaId", getSpGraduationCriteriaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("criteriaType", getCriteriaType());
		attributes.put("criteriaLevel", getCriteriaLevel());
		attributes.put("criteriaValueRange", getCriteriaValueRange());
		attributes.put("criteriaDesc", getCriteriaDesc());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spGraduationCriteriaId = (Long)attributes.get(
				"spGraduationCriteriaId");

		if (spGraduationCriteriaId != null) {
			setSpGraduationCriteriaId(spGraduationCriteriaId);
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

		Long criteriaType = (Long)attributes.get("criteriaType");

		if (criteriaType != null) {
			setCriteriaType(criteriaType);
		}

		Long criteriaLevel = (Long)attributes.get("criteriaLevel");

		if (criteriaLevel != null) {
			setCriteriaLevel(criteriaLevel);
		}

		String criteriaValueRange = (String)attributes.get("criteriaValueRange");

		if (criteriaValueRange != null) {
			setCriteriaValueRange(criteriaValueRange);
		}

		String criteriaDesc = (String)attributes.get("criteriaDesc");

		if (criteriaDesc != null) {
			setCriteriaDesc(criteriaDesc);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	@Override
	public long getSpGraduationCriteriaId() {
		return _spGraduationCriteriaId;
	}

	@Override
	public void setSpGraduationCriteriaId(long spGraduationCriteriaId) {
		_spGraduationCriteriaId = spGraduationCriteriaId;

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setSpGraduationCriteriaId",
						long.class);

				method.invoke(_graduationCriteriaRemoteModel,
					spGraduationCriteriaId);
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

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_graduationCriteriaRemoteModel, groupId);
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

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_graduationCriteriaRemoteModel, companyId);
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

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_graduationCriteriaRemoteModel, userId);
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

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_graduationCriteriaRemoteModel, userName);
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

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_graduationCriteriaRemoteModel, createDate);
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

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_graduationCriteriaRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCriteriaType() {
		return _criteriaType;
	}

	@Override
	public void setCriteriaType(long criteriaType) {
		_criteriaType = criteriaType;

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setCriteriaType", long.class);

				method.invoke(_graduationCriteriaRemoteModel, criteriaType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCriteriaLevel() {
		return _criteriaLevel;
	}

	@Override
	public void setCriteriaLevel(long criteriaLevel) {
		_criteriaLevel = criteriaLevel;

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setCriteriaLevel", long.class);

				method.invoke(_graduationCriteriaRemoteModel, criteriaLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCriteriaValueRange() {
		return _criteriaValueRange;
	}

	@Override
	public void setCriteriaValueRange(String criteriaValueRange) {
		_criteriaValueRange = criteriaValueRange;

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setCriteriaValueRange",
						String.class);

				method.invoke(_graduationCriteriaRemoteModel, criteriaValueRange);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCriteriaDesc() {
		return _criteriaDesc;
	}

	@Override
	public void setCriteriaDesc(String criteriaDesc) {
		_criteriaDesc = criteriaDesc;

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setCriteriaDesc", String.class);

				method.invoke(_graduationCriteriaRemoteModel, criteriaDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;

		if (_graduationCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _graduationCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_graduationCriteriaRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGraduationCriteriaRemoteModel() {
		return _graduationCriteriaRemoteModel;
	}

	public void setGraduationCriteriaRemoteModel(
		BaseModel<?> graduationCriteriaRemoteModel) {
		_graduationCriteriaRemoteModel = graduationCriteriaRemoteModel;
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

		Class<?> remoteModelClass = _graduationCriteriaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_graduationCriteriaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GraduationCriteriaLocalServiceUtil.addGraduationCriteria(this);
		}
		else {
			GraduationCriteriaLocalServiceUtil.updateGraduationCriteria(this);
		}
	}

	@Override
	public GraduationCriteria toEscapedModel() {
		return (GraduationCriteria)ProxyUtil.newProxyInstance(GraduationCriteria.class.getClassLoader(),
			new Class[] { GraduationCriteria.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GraduationCriteriaClp clone = new GraduationCriteriaClp();

		clone.setSpGraduationCriteriaId(getSpGraduationCriteriaId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCriteriaType(getCriteriaType());
		clone.setCriteriaLevel(getCriteriaLevel());
		clone.setCriteriaValueRange(getCriteriaValueRange());
		clone.setCriteriaDesc(getCriteriaDesc());
		clone.setSpCourseId(getSpCourseId());

		return clone;
	}

	@Override
	public int compareTo(GraduationCriteria graduationCriteria) {
		int value = 0;

		if (getSpCourseId() < graduationCriteria.getSpCourseId()) {
			value = -1;
		}
		else if (getSpCourseId() > graduationCriteria.getSpCourseId()) {
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

		if (!(obj instanceof GraduationCriteriaClp)) {
			return false;
		}

		GraduationCriteriaClp graduationCriteria = (GraduationCriteriaClp)obj;

		long primaryKey = graduationCriteria.getPrimaryKey();

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

		sb.append("{spGraduationCriteriaId=");
		sb.append(getSpGraduationCriteriaId());
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
		sb.append(", criteriaType=");
		sb.append(getCriteriaType());
		sb.append(", criteriaLevel=");
		sb.append(getCriteriaLevel());
		sb.append(", criteriaValueRange=");
		sb.append(getCriteriaValueRange());
		sb.append(", criteriaDesc=");
		sb.append(getCriteriaDesc());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.GraduationCriteria");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spGraduationCriteriaId</column-name><column-value><![CDATA[");
		sb.append(getSpGraduationCriteriaId());
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
			"<column><column-name>criteriaType</column-name><column-value><![CDATA[");
		sb.append(getCriteriaType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>criteriaLevel</column-name><column-value><![CDATA[");
		sb.append(getCriteriaLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>criteriaValueRange</column-name><column-value><![CDATA[");
		sb.append(getCriteriaValueRange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>criteriaDesc</column-name><column-value><![CDATA[");
		sb.append(getCriteriaDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spGraduationCriteriaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _criteriaType;
	private long _criteriaLevel;
	private String _criteriaValueRange;
	private String _criteriaDesc;
	private long _spCourseId;
	private BaseModel<?> _graduationCriteriaRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}