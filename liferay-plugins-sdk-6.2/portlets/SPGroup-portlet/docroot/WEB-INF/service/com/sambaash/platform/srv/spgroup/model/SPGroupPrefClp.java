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

package com.sambaash.platform.srv.spgroup.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spgroup.service.ClpSerializer;
import com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPGroupPrefClp extends BaseModelImpl<SPGroupPref>
	implements SPGroupPref {
	public SPGroupPrefClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPGroupPref.class;
	}

	@Override
	public String getModelClassName() {
		return SPGroupPref.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spGroupPrefId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpGroupPrefId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spGroupPrefId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spGroupPrefId", getSpGroupPrefId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dIn", getDIn());
		attributes.put("dGoogle", getDGoogle());
		attributes.put("dFb", getDFb());
		attributes.put("dTw", getDTw());
		attributes.put("cIn", getCIn());
		attributes.put("cGoogle", getCGoogle());
		attributes.put("cFb", getCFb());
		attributes.put("cTw", getCTw());
		attributes.put("enableSubscribeToComments",
			getEnableSubscribeToComments());
		attributes.put("enableGroupUpdateNotification",
			getEnableGroupUpdateNotification());
		attributes.put("enableMemberUpdate", getEnableMemberUpdate());
		attributes.put("enableDiscussionUpdate", getEnableDiscussionUpdate());
		attributes.put("updateFrequency", getUpdateFrequency());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spGroupPrefId = (Long)attributes.get("spGroupPrefId");

		if (spGroupPrefId != null) {
			setSpGroupPrefId(spGroupPrefId);
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

		Boolean dIn = (Boolean)attributes.get("dIn");

		if (dIn != null) {
			setDIn(dIn);
		}

		Boolean dGoogle = (Boolean)attributes.get("dGoogle");

		if (dGoogle != null) {
			setDGoogle(dGoogle);
		}

		Boolean dFb = (Boolean)attributes.get("dFb");

		if (dFb != null) {
			setDFb(dFb);
		}

		Boolean dTw = (Boolean)attributes.get("dTw");

		if (dTw != null) {
			setDTw(dTw);
		}

		Boolean cIn = (Boolean)attributes.get("cIn");

		if (cIn != null) {
			setCIn(cIn);
		}

		Boolean cGoogle = (Boolean)attributes.get("cGoogle");

		if (cGoogle != null) {
			setCGoogle(cGoogle);
		}

		Boolean cFb = (Boolean)attributes.get("cFb");

		if (cFb != null) {
			setCFb(cFb);
		}

		Boolean cTw = (Boolean)attributes.get("cTw");

		if (cTw != null) {
			setCTw(cTw);
		}

		Boolean enableSubscribeToComments = (Boolean)attributes.get(
				"enableSubscribeToComments");

		if (enableSubscribeToComments != null) {
			setEnableSubscribeToComments(enableSubscribeToComments);
		}

		Boolean enableGroupUpdateNotification = (Boolean)attributes.get(
				"enableGroupUpdateNotification");

		if (enableGroupUpdateNotification != null) {
			setEnableGroupUpdateNotification(enableGroupUpdateNotification);
		}

		Boolean enableMemberUpdate = (Boolean)attributes.get(
				"enableMemberUpdate");

		if (enableMemberUpdate != null) {
			setEnableMemberUpdate(enableMemberUpdate);
		}

		Boolean enableDiscussionUpdate = (Boolean)attributes.get(
				"enableDiscussionUpdate");

		if (enableDiscussionUpdate != null) {
			setEnableDiscussionUpdate(enableDiscussionUpdate);
		}

		String updateFrequency = (String)attributes.get("updateFrequency");

		if (updateFrequency != null) {
			setUpdateFrequency(updateFrequency);
		}
	}

	@Override
	public long getSpGroupPrefId() {
		return _spGroupPrefId;
	}

	@Override
	public void setSpGroupPrefId(long spGroupPrefId) {
		_spGroupPrefId = spGroupPrefId;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setSpGroupPrefId", long.class);

				method.invoke(_spGroupPrefRemoteModel, spGroupPrefId);
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

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spGroupPrefRemoteModel, groupId);
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

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spGroupPrefRemoteModel, companyId);
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

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spGroupPrefRemoteModel, userId);
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

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spGroupPrefRemoteModel, userName);
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

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spGroupPrefRemoteModel, createDate);
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

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spGroupPrefRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDIn() {
		return _dIn;
	}

	@Override
	public boolean isDIn() {
		return _dIn;
	}

	@Override
	public void setDIn(boolean dIn) {
		_dIn = dIn;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setDIn", boolean.class);

				method.invoke(_spGroupPrefRemoteModel, dIn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDGoogle() {
		return _dGoogle;
	}

	@Override
	public boolean isDGoogle() {
		return _dGoogle;
	}

	@Override
	public void setDGoogle(boolean dGoogle) {
		_dGoogle = dGoogle;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setDGoogle", boolean.class);

				method.invoke(_spGroupPrefRemoteModel, dGoogle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDFb() {
		return _dFb;
	}

	@Override
	public boolean isDFb() {
		return _dFb;
	}

	@Override
	public void setDFb(boolean dFb) {
		_dFb = dFb;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setDFb", boolean.class);

				method.invoke(_spGroupPrefRemoteModel, dFb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDTw() {
		return _dTw;
	}

	@Override
	public boolean isDTw() {
		return _dTw;
	}

	@Override
	public void setDTw(boolean dTw) {
		_dTw = dTw;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setDTw", boolean.class);

				method.invoke(_spGroupPrefRemoteModel, dTw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCIn() {
		return _cIn;
	}

	@Override
	public boolean isCIn() {
		return _cIn;
	}

	@Override
	public void setCIn(boolean cIn) {
		_cIn = cIn;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setCIn", boolean.class);

				method.invoke(_spGroupPrefRemoteModel, cIn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCGoogle() {
		return _cGoogle;
	}

	@Override
	public boolean isCGoogle() {
		return _cGoogle;
	}

	@Override
	public void setCGoogle(boolean cGoogle) {
		_cGoogle = cGoogle;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setCGoogle", boolean.class);

				method.invoke(_spGroupPrefRemoteModel, cGoogle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCFb() {
		return _cFb;
	}

	@Override
	public boolean isCFb() {
		return _cFb;
	}

	@Override
	public void setCFb(boolean cFb) {
		_cFb = cFb;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setCFb", boolean.class);

				method.invoke(_spGroupPrefRemoteModel, cFb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCTw() {
		return _cTw;
	}

	@Override
	public boolean isCTw() {
		return _cTw;
	}

	@Override
	public void setCTw(boolean cTw) {
		_cTw = cTw;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setCTw", boolean.class);

				method.invoke(_spGroupPrefRemoteModel, cTw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnableSubscribeToComments() {
		return _enableSubscribeToComments;
	}

	@Override
	public boolean isEnableSubscribeToComments() {
		return _enableSubscribeToComments;
	}

	@Override
	public void setEnableSubscribeToComments(boolean enableSubscribeToComments) {
		_enableSubscribeToComments = enableSubscribeToComments;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setEnableSubscribeToComments",
						boolean.class);

				method.invoke(_spGroupPrefRemoteModel, enableSubscribeToComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnableGroupUpdateNotification() {
		return _enableGroupUpdateNotification;
	}

	@Override
	public boolean isEnableGroupUpdateNotification() {
		return _enableGroupUpdateNotification;
	}

	@Override
	public void setEnableGroupUpdateNotification(
		boolean enableGroupUpdateNotification) {
		_enableGroupUpdateNotification = enableGroupUpdateNotification;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setEnableGroupUpdateNotification",
						boolean.class);

				method.invoke(_spGroupPrefRemoteModel,
					enableGroupUpdateNotification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnableMemberUpdate() {
		return _enableMemberUpdate;
	}

	@Override
	public boolean isEnableMemberUpdate() {
		return _enableMemberUpdate;
	}

	@Override
	public void setEnableMemberUpdate(boolean enableMemberUpdate) {
		_enableMemberUpdate = enableMemberUpdate;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setEnableMemberUpdate",
						boolean.class);

				method.invoke(_spGroupPrefRemoteModel, enableMemberUpdate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnableDiscussionUpdate() {
		return _enableDiscussionUpdate;
	}

	@Override
	public boolean isEnableDiscussionUpdate() {
		return _enableDiscussionUpdate;
	}

	@Override
	public void setEnableDiscussionUpdate(boolean enableDiscussionUpdate) {
		_enableDiscussionUpdate = enableDiscussionUpdate;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setEnableDiscussionUpdate",
						boolean.class);

				method.invoke(_spGroupPrefRemoteModel, enableDiscussionUpdate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdateFrequency() {
		return _updateFrequency;
	}

	@Override
	public void setUpdateFrequency(String updateFrequency) {
		_updateFrequency = updateFrequency;

		if (_spGroupPrefRemoteModel != null) {
			try {
				Class<?> clazz = _spGroupPrefRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateFrequency",
						String.class);

				method.invoke(_spGroupPrefRemoteModel, updateFrequency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPGroupPrefRemoteModel() {
		return _spGroupPrefRemoteModel;
	}

	public void setSPGroupPrefRemoteModel(BaseModel<?> spGroupPrefRemoteModel) {
		_spGroupPrefRemoteModel = spGroupPrefRemoteModel;
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

		Class<?> remoteModelClass = _spGroupPrefRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spGroupPrefRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPGroupPrefLocalServiceUtil.addSPGroupPref(this);
		}
		else {
			SPGroupPrefLocalServiceUtil.updateSPGroupPref(this);
		}
	}

	@Override
	public SPGroupPref toEscapedModel() {
		return (SPGroupPref)ProxyUtil.newProxyInstance(SPGroupPref.class.getClassLoader(),
			new Class[] { SPGroupPref.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPGroupPrefClp clone = new SPGroupPrefClp();

		clone.setSpGroupPrefId(getSpGroupPrefId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDIn(getDIn());
		clone.setDGoogle(getDGoogle());
		clone.setDFb(getDFb());
		clone.setDTw(getDTw());
		clone.setCIn(getCIn());
		clone.setCGoogle(getCGoogle());
		clone.setCFb(getCFb());
		clone.setCTw(getCTw());
		clone.setEnableSubscribeToComments(getEnableSubscribeToComments());
		clone.setEnableGroupUpdateNotification(getEnableGroupUpdateNotification());
		clone.setEnableMemberUpdate(getEnableMemberUpdate());
		clone.setEnableDiscussionUpdate(getEnableDiscussionUpdate());
		clone.setUpdateFrequency(getUpdateFrequency());

		return clone;
	}

	@Override
	public int compareTo(SPGroupPref spGroupPref) {
		long primaryKey = spGroupPref.getPrimaryKey();

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

		if (!(obj instanceof SPGroupPrefClp)) {
			return false;
		}

		SPGroupPrefClp spGroupPref = (SPGroupPrefClp)obj;

		long primaryKey = spGroupPref.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{spGroupPrefId=");
		sb.append(getSpGroupPrefId());
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
		sb.append(", dIn=");
		sb.append(getDIn());
		sb.append(", dGoogle=");
		sb.append(getDGoogle());
		sb.append(", dFb=");
		sb.append(getDFb());
		sb.append(", dTw=");
		sb.append(getDTw());
		sb.append(", cIn=");
		sb.append(getCIn());
		sb.append(", cGoogle=");
		sb.append(getCGoogle());
		sb.append(", cFb=");
		sb.append(getCFb());
		sb.append(", cTw=");
		sb.append(getCTw());
		sb.append(", enableSubscribeToComments=");
		sb.append(getEnableSubscribeToComments());
		sb.append(", enableGroupUpdateNotification=");
		sb.append(getEnableGroupUpdateNotification());
		sb.append(", enableMemberUpdate=");
		sb.append(getEnableMemberUpdate());
		sb.append(", enableDiscussionUpdate=");
		sb.append(getEnableDiscussionUpdate());
		sb.append(", updateFrequency=");
		sb.append(getUpdateFrequency());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spgroup.model.SPGroupPref");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spGroupPrefId</column-name><column-value><![CDATA[");
		sb.append(getSpGroupPrefId());
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
			"<column><column-name>dIn</column-name><column-value><![CDATA[");
		sb.append(getDIn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dGoogle</column-name><column-value><![CDATA[");
		sb.append(getDGoogle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dFb</column-name><column-value><![CDATA[");
		sb.append(getDFb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dTw</column-name><column-value><![CDATA[");
		sb.append(getDTw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cIn</column-name><column-value><![CDATA[");
		sb.append(getCIn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cGoogle</column-name><column-value><![CDATA[");
		sb.append(getCGoogle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cFb</column-name><column-value><![CDATA[");
		sb.append(getCFb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cTw</column-name><column-value><![CDATA[");
		sb.append(getCTw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enableSubscribeToComments</column-name><column-value><![CDATA[");
		sb.append(getEnableSubscribeToComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enableGroupUpdateNotification</column-name><column-value><![CDATA[");
		sb.append(getEnableGroupUpdateNotification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enableMemberUpdate</column-name><column-value><![CDATA[");
		sb.append(getEnableMemberUpdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enableDiscussionUpdate</column-name><column-value><![CDATA[");
		sb.append(getEnableDiscussionUpdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateFrequency</column-name><column-value><![CDATA[");
		sb.append(getUpdateFrequency());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spGroupPrefId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _dIn;
	private boolean _dGoogle;
	private boolean _dFb;
	private boolean _dTw;
	private boolean _cIn;
	private boolean _cGoogle;
	private boolean _cFb;
	private boolean _cTw;
	private boolean _enableSubscribeToComments;
	private boolean _enableGroupUpdateNotification;
	private boolean _enableMemberUpdate;
	private boolean _enableDiscussionUpdate;
	private String _updateFrequency;
	private BaseModel<?> _spGroupPrefRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spgroup.service.ClpSerializer.class;
}