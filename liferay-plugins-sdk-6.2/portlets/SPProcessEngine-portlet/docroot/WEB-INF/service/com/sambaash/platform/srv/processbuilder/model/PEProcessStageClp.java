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

package com.sambaash.platform.srv.processbuilder.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.processbuilder.service.ClpSerializer;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class PEProcessStageClp extends BaseModelImpl<PEProcessStage>
	implements PEProcessStage {
	public PEProcessStageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PEProcessStage.class;
	}

	@Override
	public String getModelClassName() {
		return PEProcessStage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPEProcessStageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPEProcessStageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPEProcessStageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEProcessStageId", getSpPEProcessStageId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("style", getStyle());
		attributes.put("seqNo", getSeqNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEProcessStageId = (Long)attributes.get("spPEProcessStageId");

		if (spPEProcessStageId != null) {
			setSpPEProcessStageId(spPEProcessStageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String style = (String)attributes.get("style");

		if (style != null) {
			setStyle(style);
		}

		Long seqNo = (Long)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_peProcessStageRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessStageId() {
		return _spPEProcessStageId;
	}

	@Override
	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_spPEProcessStageId = spPEProcessStageId;

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStageId",
						long.class);

				method.invoke(_peProcessStageRemoteModel, spPEProcessStageId);
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

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_peProcessStageRemoteModel, groupId);
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

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_peProcessStageRemoteModel, userId);
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
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_peProcessStageRemoteModel, companyId);
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

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_peProcessStageRemoteModel, userName);
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

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_peProcessStageRemoteModel, createDate);
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

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_peProcessStageRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_peProcessStageRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStyle() {
		return _style;
	}

	@Override
	public void setStyle(String style) {
		_style = style;

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setStyle", String.class);

				method.invoke(_peProcessStageRemoteModel, style);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSeqNo() {
		return _seqNo;
	}

	@Override
	public void setSeqNo(long seqNo) {
		_seqNo = seqNo;

		if (_peProcessStageRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStageRemoteModel.getClass();

				Method method = clazz.getMethod("setSeqNo", long.class);

				method.invoke(_peProcessStageRemoteModel, seqNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PEProcessStage.class.getName()));
	}

	public BaseModel<?> getPEProcessStageRemoteModel() {
		return _peProcessStageRemoteModel;
	}

	public void setPEProcessStageRemoteModel(
		BaseModel<?> peProcessStageRemoteModel) {
		_peProcessStageRemoteModel = peProcessStageRemoteModel;
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

		Class<?> remoteModelClass = _peProcessStageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_peProcessStageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PEProcessStageLocalServiceUtil.addPEProcessStage(this);
		}
		else {
			PEProcessStageLocalServiceUtil.updatePEProcessStage(this);
		}
	}

	@Override
	public PEProcessStage toEscapedModel() {
		return (PEProcessStage)ProxyUtil.newProxyInstance(PEProcessStage.class.getClassLoader(),
			new Class[] { PEProcessStage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PEProcessStageClp clone = new PEProcessStageClp();

		clone.setUuid(getUuid());
		clone.setSpPEProcessStageId(getSpPEProcessStageId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setStyle(getStyle());
		clone.setSeqNo(getSeqNo());

		return clone;
	}

	@Override
	public int compareTo(PEProcessStage peProcessStage) {
		int value = 0;

		if (getSeqNo() < peProcessStage.getSeqNo()) {
			value = -1;
		}
		else if (getSeqNo() > peProcessStage.getSeqNo()) {
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

		if (!(obj instanceof PEProcessStageClp)) {
			return false;
		}

		PEProcessStageClp peProcessStage = (PEProcessStageClp)obj;

		long primaryKey = peProcessStage.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spPEProcessStageId=");
		sb.append(getSpPEProcessStageId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", style=");
		sb.append(getStyle());
		sb.append(", seqNo=");
		sb.append(getSeqNo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.processbuilder.model.PEProcessStage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessStageId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>style</column-name><column-value><![CDATA[");
		sb.append(getStyle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seqNo</column-name><column-value><![CDATA[");
		sb.append(getSeqNo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spPEProcessStageId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _style;
	private long _seqNo;
	private BaseModel<?> _peProcessStageRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class;
}