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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.SPLikesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPLikesClp extends BaseModelImpl<SPLikes> implements SPLikes {
	public SPLikesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPLikes.class;
	}

	@Override
	public String getModelClassName() {
		return SPLikes.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spLikesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpLikesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spLikesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spLikesId", getSpLikesId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("layoutSetId", getLayoutSetId());
		attributes.put("action", getAction());
		attributes.put("actorUserId", getActorUserId());
		attributes.put("classId", getClassId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spLikesId = (Long)attributes.get("spLikesId");

		if (spLikesId != null) {
			setSpLikesId(spLikesId);
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

		Long layoutSetId = (Long)attributes.get("layoutSetId");

		if (layoutSetId != null) {
			setLayoutSetId(layoutSetId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		Long actorUserId = (Long)attributes.get("actorUserId");

		if (actorUserId != null) {
			setActorUserId(actorUserId);
		}

		Long classId = (Long)attributes.get("classId");

		if (classId != null) {
			setClassId(classId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spLikesRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpLikesId() {
		return _spLikesId;
	}

	@Override
	public void setSpLikesId(long spLikesId) {
		_spLikesId = spLikesId;

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setSpLikesId", long.class);

				method.invoke(_spLikesRemoteModel, spLikesId);
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

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spLikesRemoteModel, groupId);
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

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spLikesRemoteModel, companyId);
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

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spLikesRemoteModel, userId);
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

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spLikesRemoteModel, userName);
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

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spLikesRemoteModel, createDate);
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

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spLikesRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLayoutSetId() {
		return _layoutSetId;
	}

	@Override
	public void setLayoutSetId(long layoutSetId) {
		_layoutSetId = layoutSetId;

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setLayoutSetId", long.class);

				method.invoke(_spLikesRemoteModel, layoutSetId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAction() {
		return _action;
	}

	@Override
	public void setAction(String action) {
		_action = action;

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setAction", String.class);

				method.invoke(_spLikesRemoteModel, action);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getActorUserId() {
		return _actorUserId;
	}

	@Override
	public void setActorUserId(long actorUserId) {
		_actorUserId = actorUserId;

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setActorUserId", long.class);

				method.invoke(_spLikesRemoteModel, actorUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActorUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getActorUserId(), "uuid", _actorUserUuid);
	}

	@Override
	public void setActorUserUuid(String actorUserUuid) {
		_actorUserUuid = actorUserUuid;
	}

	@Override
	public long getClassId() {
		return _classId;
	}

	@Override
	public void setClassId(long classId) {
		_classId = classId;

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setClassId", long.class);

				method.invoke(_spLikesRemoteModel, classId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		return _className;
	}

	@Override
	public void setClassName(String className) {
		_className = className;

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_spLikesRemoteModel, className);
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

		if (_spLikesRemoteModel != null) {
			try {
				Class<?> clazz = _spLikesRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_spLikesRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPLikes.class.getName()));
	}

	public BaseModel<?> getSPLikesRemoteModel() {
		return _spLikesRemoteModel;
	}

	public void setSPLikesRemoteModel(BaseModel<?> spLikesRemoteModel) {
		_spLikesRemoteModel = spLikesRemoteModel;
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

		Class<?> remoteModelClass = _spLikesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spLikesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPLikesLocalServiceUtil.addSPLikes(this);
		}
		else {
			SPLikesLocalServiceUtil.updateSPLikes(this);
		}
	}

	@Override
	public SPLikes toEscapedModel() {
		return (SPLikes)ProxyUtil.newProxyInstance(SPLikes.class.getClassLoader(),
			new Class[] { SPLikes.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPLikesClp clone = new SPLikesClp();

		clone.setUuid(getUuid());
		clone.setSpLikesId(getSpLikesId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLayoutSetId(getLayoutSetId());
		clone.setAction(getAction());
		clone.setActorUserId(getActorUserId());
		clone.setClassId(getClassId());
		clone.setClassName(getClassName());
		clone.setClassPK(getClassPK());

		return clone;
	}

	@Override
	public int compareTo(SPLikes spLikes) {
		long primaryKey = spLikes.getPrimaryKey();

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

		if (!(obj instanceof SPLikesClp)) {
			return false;
		}

		SPLikesClp spLikes = (SPLikesClp)obj;

		long primaryKey = spLikes.getPrimaryKey();

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
		sb.append(", spLikesId=");
		sb.append(getSpLikesId());
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
		sb.append(", layoutSetId=");
		sb.append(getLayoutSetId());
		sb.append(", action=");
		sb.append(getAction());
		sb.append(", actorUserId=");
		sb.append(getActorUserId());
		sb.append(", classId=");
		sb.append(getClassId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPLikes");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spLikesId</column-name><column-value><![CDATA[");
		sb.append(getSpLikesId());
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
			"<column><column-name>layoutSetId</column-name><column-value><![CDATA[");
		sb.append(getLayoutSetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actorUserId</column-name><column-value><![CDATA[");
		sb.append(getActorUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classId</column-name><column-value><![CDATA[");
		sb.append(getClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spLikesId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _layoutSetId;
	private String _action;
	private long _actorUserId;
	private String _actorUserUuid;
	private long _classId;
	private String _className;
	private long _classPK;
	private BaseModel<?> _spLikesRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}