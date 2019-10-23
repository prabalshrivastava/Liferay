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
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class PEProcessStatusTypeClp extends BaseModelImpl<PEProcessStatusType>
	implements PEProcessStatusType {
	public PEProcessStatusTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PEProcessStatusType.class;
	}

	@Override
	public String getModelClassName() {
		return PEProcessStatusType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPEProcessStatusTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPEProcessStatusTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPEProcessStatusTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEProcessStatusTypeId", getSpPEProcessStatusTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessId", getSpPEProcessId());
		attributes.put("statusName", getStatusName());
		attributes.put("seqNo", getSeqNo());
		attributes.put("approveTemplateId", getApproveTemplateId());
		attributes.put("rejectTemplateId", getRejectTemplateId());
		attributes.put("spPEProcessStageId", getSpPEProcessStageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEProcessStatusTypeId = (Long)attributes.get(
				"spPEProcessStatusTypeId");

		if (spPEProcessStatusTypeId != null) {
			setSpPEProcessStatusTypeId(spPEProcessStatusTypeId);
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

		Long spPEProcessId = (Long)attributes.get("spPEProcessId");

		if (spPEProcessId != null) {
			setSpPEProcessId(spPEProcessId);
		}

		String statusName = (String)attributes.get("statusName");

		if (statusName != null) {
			setStatusName(statusName);
		}

		Long seqNo = (Long)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Long approveTemplateId = (Long)attributes.get("approveTemplateId");

		if (approveTemplateId != null) {
			setApproveTemplateId(approveTemplateId);
		}

		Long rejectTemplateId = (Long)attributes.get("rejectTemplateId");

		if (rejectTemplateId != null) {
			setRejectTemplateId(rejectTemplateId);
		}

		Long spPEProcessStageId = (Long)attributes.get("spPEProcessStageId");

		if (spPEProcessStageId != null) {
			setSpPEProcessStageId(spPEProcessStageId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_peProcessStatusTypeRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessStatusTypeId() {
		return _spPEProcessStatusTypeId;
	}

	@Override
	public void setSpPEProcessStatusTypeId(long spPEProcessStatusTypeId) {
		_spPEProcessStatusTypeId = spPEProcessStatusTypeId;

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStatusTypeId",
						long.class);

				method.invoke(_peProcessStatusTypeRemoteModel,
					spPEProcessStatusTypeId);
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

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_peProcessStatusTypeRemoteModel, groupId);
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

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_peProcessStatusTypeRemoteModel, companyId);
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

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_peProcessStatusTypeRemoteModel, userId);
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

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_peProcessStatusTypeRemoteModel, userName);
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

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_peProcessStatusTypeRemoteModel, createDate);
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

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_peProcessStatusTypeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessId() {
		return _spPEProcessId;
	}

	@Override
	public void setSpPEProcessId(long spPEProcessId) {
		_spPEProcessId = spPEProcessId;

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessId", long.class);

				method.invoke(_peProcessStatusTypeRemoteModel, spPEProcessId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusName() {
		return _statusName;
	}

	@Override
	public void setStatusName(String statusName) {
		_statusName = statusName;

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusName", String.class);

				method.invoke(_peProcessStatusTypeRemoteModel, statusName);
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

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSeqNo", long.class);

				method.invoke(_peProcessStatusTypeRemoteModel, seqNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApproveTemplateId() {
		return _approveTemplateId;
	}

	@Override
	public void setApproveTemplateId(long approveTemplateId) {
		_approveTemplateId = approveTemplateId;

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setApproveTemplateId",
						long.class);

				method.invoke(_peProcessStatusTypeRemoteModel, approveTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRejectTemplateId() {
		return _rejectTemplateId;
	}

	@Override
	public void setRejectTemplateId(long rejectTemplateId) {
		_rejectTemplateId = rejectTemplateId;

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setRejectTemplateId",
						long.class);

				method.invoke(_peProcessStatusTypeRemoteModel, rejectTemplateId);
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

		if (_peProcessStatusTypeRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStatusTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStageId",
						long.class);

				method.invoke(_peProcessStatusTypeRemoteModel,
					spPEProcessStageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PEProcessStatusType.class.getName()));
	}

	public BaseModel<?> getPEProcessStatusTypeRemoteModel() {
		return _peProcessStatusTypeRemoteModel;
	}

	public void setPEProcessStatusTypeRemoteModel(
		BaseModel<?> peProcessStatusTypeRemoteModel) {
		_peProcessStatusTypeRemoteModel = peProcessStatusTypeRemoteModel;
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

		Class<?> remoteModelClass = _peProcessStatusTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_peProcessStatusTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PEProcessStatusTypeLocalServiceUtil.addPEProcessStatusType(this);
		}
		else {
			PEProcessStatusTypeLocalServiceUtil.updatePEProcessStatusType(this);
		}
	}

	@Override
	public PEProcessStatusType toEscapedModel() {
		return (PEProcessStatusType)ProxyUtil.newProxyInstance(PEProcessStatusType.class.getClassLoader(),
			new Class[] { PEProcessStatusType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PEProcessStatusTypeClp clone = new PEProcessStatusTypeClp();

		clone.setUuid(getUuid());
		clone.setSpPEProcessStatusTypeId(getSpPEProcessStatusTypeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpPEProcessId(getSpPEProcessId());
		clone.setStatusName(getStatusName());
		clone.setSeqNo(getSeqNo());
		clone.setApproveTemplateId(getApproveTemplateId());
		clone.setRejectTemplateId(getRejectTemplateId());
		clone.setSpPEProcessStageId(getSpPEProcessStageId());

		return clone;
	}

	@Override
	public int compareTo(PEProcessStatusType peProcessStatusType) {
		int value = 0;

		if (getSeqNo() < peProcessStatusType.getSeqNo()) {
			value = -1;
		}
		else if (getSeqNo() > peProcessStatusType.getSeqNo()) {
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

		if (!(obj instanceof PEProcessStatusTypeClp)) {
			return false;
		}

		PEProcessStatusTypeClp peProcessStatusType = (PEProcessStatusTypeClp)obj;

		long primaryKey = peProcessStatusType.getPrimaryKey();

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
		sb.append(", spPEProcessStatusTypeId=");
		sb.append(getSpPEProcessStatusTypeId());
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
		sb.append(", spPEProcessId=");
		sb.append(getSpPEProcessId());
		sb.append(", statusName=");
		sb.append(getStatusName());
		sb.append(", seqNo=");
		sb.append(getSeqNo());
		sb.append(", approveTemplateId=");
		sb.append(getApproveTemplateId());
		sb.append(", rejectTemplateId=");
		sb.append(getRejectTemplateId());
		sb.append(", spPEProcessStageId=");
		sb.append(getSpPEProcessStageId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessStatusTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStatusTypeId());
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
			"<column><column-name>spPEProcessId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusName</column-name><column-value><![CDATA[");
		sb.append(getStatusName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seqNo</column-name><column-value><![CDATA[");
		sb.append(getSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approveTemplateId</column-name><column-value><![CDATA[");
		sb.append(getApproveTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rejectTemplateId</column-name><column-value><![CDATA[");
		sb.append(getRejectTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessStageId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spPEProcessStatusTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPEProcessId;
	private String _statusName;
	private long _seqNo;
	private long _approveTemplateId;
	private long _rejectTemplateId;
	private long _spPEProcessStageId;
	private BaseModel<?> _peProcessStatusTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class;
}