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

package com.sambaash.platform.srv.legalandcontract.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.legalandcontract.service.ClpSerializer;
import com.sambaash.platform.srv.legalandcontract.service.RDLLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class RDLClp extends BaseModelImpl<RDL> implements RDL {
	public RDLClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RDL.class;
	}

	@Override
	public String getModelClassName() {
		return RDL.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spRdlId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpRdlId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spRdlId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spRdlId", getSpRdlId());
		attributes.put("spLitigationId", getSpLitigationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("responseDeadline", getResponseDeadline());
		attributes.put("claimsRemarks", getClaimsRemarks());
		attributes.put("alertBefore", getAlertBefore());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spRdlId = (Long)attributes.get("spRdlId");

		if (spRdlId != null) {
			setSpRdlId(spRdlId);
		}

		Long spLitigationId = (Long)attributes.get("spLitigationId");

		if (spLitigationId != null) {
			setSpLitigationId(spLitigationId);
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

		Date responseDeadline = (Date)attributes.get("responseDeadline");

		if (responseDeadline != null) {
			setResponseDeadline(responseDeadline);
		}

		String claimsRemarks = (String)attributes.get("claimsRemarks");

		if (claimsRemarks != null) {
			setClaimsRemarks(claimsRemarks);
		}

		Long alertBefore = (Long)attributes.get("alertBefore");

		if (alertBefore != null) {
			setAlertBefore(alertBefore);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_rdlRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpRdlId() {
		return _spRdlId;
	}

	@Override
	public void setSpRdlId(long spRdlId) {
		_spRdlId = spRdlId;

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setSpRdlId", long.class);

				method.invoke(_rdlRemoteModel, spRdlId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpLitigationId() {
		return _spLitigationId;
	}

	@Override
	public void setSpLitigationId(long spLitigationId) {
		_spLitigationId = spLitigationId;

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setSpLitigationId", long.class);

				method.invoke(_rdlRemoteModel, spLitigationId);
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

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_rdlRemoteModel, groupId);
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

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_rdlRemoteModel, companyId);
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

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rdlRemoteModel, userId);
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

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_rdlRemoteModel, userName);
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

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_rdlRemoteModel, createDate);
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

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_rdlRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getResponseDeadline() {
		return _responseDeadline;
	}

	@Override
	public void setResponseDeadline(Date responseDeadline) {
		_responseDeadline = responseDeadline;

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setResponseDeadline",
						Date.class);

				method.invoke(_rdlRemoteModel, responseDeadline);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClaimsRemarks() {
		return _claimsRemarks;
	}

	@Override
	public void setClaimsRemarks(String claimsRemarks) {
		_claimsRemarks = claimsRemarks;

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setClaimsRemarks", String.class);

				method.invoke(_rdlRemoteModel, claimsRemarks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAlertBefore() {
		return _alertBefore;
	}

	@Override
	public void setAlertBefore(long alertBefore) {
		_alertBefore = alertBefore;

		if (_rdlRemoteModel != null) {
			try {
				Class<?> clazz = _rdlRemoteModel.getClass();

				Method method = clazz.getMethod("setAlertBefore", long.class);

				method.invoke(_rdlRemoteModel, alertBefore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RDL.class.getName()));
	}

	public BaseModel<?> getRDLRemoteModel() {
		return _rdlRemoteModel;
	}

	public void setRDLRemoteModel(BaseModel<?> rdlRemoteModel) {
		_rdlRemoteModel = rdlRemoteModel;
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

		Class<?> remoteModelClass = _rdlRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rdlRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RDLLocalServiceUtil.addRDL(this);
		}
		else {
			RDLLocalServiceUtil.updateRDL(this);
		}
	}

	@Override
	public RDL toEscapedModel() {
		return (RDL)ProxyUtil.newProxyInstance(RDL.class.getClassLoader(),
			new Class[] { RDL.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RDLClp clone = new RDLClp();

		clone.setUuid(getUuid());
		clone.setSpRdlId(getSpRdlId());
		clone.setSpLitigationId(getSpLitigationId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setResponseDeadline(getResponseDeadline());
		clone.setClaimsRemarks(getClaimsRemarks());
		clone.setAlertBefore(getAlertBefore());

		return clone;
	}

	@Override
	public int compareTo(RDL rdl) {
		int value = 0;

		value = DateUtil.compareTo(getResponseDeadline(),
				rdl.getResponseDeadline());

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

		if (!(obj instanceof RDLClp)) {
			return false;
		}

		RDLClp rdl = (RDLClp)obj;

		long primaryKey = rdl.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spRdlId=");
		sb.append(getSpRdlId());
		sb.append(", spLitigationId=");
		sb.append(getSpLitigationId());
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
		sb.append(", responseDeadline=");
		sb.append(getResponseDeadline());
		sb.append(", claimsRemarks=");
		sb.append(getClaimsRemarks());
		sb.append(", alertBefore=");
		sb.append(getAlertBefore());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.legalandcontract.model.RDL");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spRdlId</column-name><column-value><![CDATA[");
		sb.append(getSpRdlId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spLitigationId</column-name><column-value><![CDATA[");
		sb.append(getSpLitigationId());
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
			"<column><column-name>responseDeadline</column-name><column-value><![CDATA[");
		sb.append(getResponseDeadline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>claimsRemarks</column-name><column-value><![CDATA[");
		sb.append(getClaimsRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>alertBefore</column-name><column-value><![CDATA[");
		sb.append(getAlertBefore());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spRdlId;
	private long _spLitigationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _responseDeadline;
	private String _claimsRemarks;
	private long _alertBefore;
	private BaseModel<?> _rdlRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.legalandcontract.service.ClpSerializer.class;
}