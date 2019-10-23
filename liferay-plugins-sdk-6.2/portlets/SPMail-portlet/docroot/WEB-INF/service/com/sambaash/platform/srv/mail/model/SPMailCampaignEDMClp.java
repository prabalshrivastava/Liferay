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

package com.sambaash.platform.srv.mail.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.mail.service.ClpSerializer;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPMailCampaignEDMClp extends BaseModelImpl<SPMailCampaignEDM>
	implements SPMailCampaignEDM {
	public SPMailCampaignEDMClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailCampaignEDM.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailCampaignEDM.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spMailCampaignEDMId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMailCampaignEDMId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMailCampaignEDMId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailCampaignEDMId", getSpMailCampaignEDMId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("spMailTemplateId", getSpMailTemplateId());
		attributes.put("seqNo", getSeqNo());
		attributes.put("dayOfWeek", getDayOfWeek());
		attributes.put("dayOfMonth", getDayOfMonth());
		attributes.put("delayUnit", getDelayUnit());
		attributes.put("status", getStatus());
		attributes.put("delayAmount", getDelayAmount());
		attributes.put("croneType", getCroneType());
		attributes.put("nextScheduleDateTime", getNextScheduleDateTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailCampaignEDMId = (Long)attributes.get("spMailCampaignEDMId");

		if (spMailCampaignEDMId != null) {
			setSpMailCampaignEDMId(spMailCampaignEDMId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		Long spMailTemplateId = (Long)attributes.get("spMailTemplateId");

		if (spMailTemplateId != null) {
			setSpMailTemplateId(spMailTemplateId);
		}

		Integer seqNo = (Integer)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Integer dayOfWeek = (Integer)attributes.get("dayOfWeek");

		if (dayOfWeek != null) {
			setDayOfWeek(dayOfWeek);
		}

		Integer dayOfMonth = (Integer)attributes.get("dayOfMonth");

		if (dayOfMonth != null) {
			setDayOfMonth(dayOfMonth);
		}

		String delayUnit = (String)attributes.get("delayUnit");

		if (delayUnit != null) {
			setDelayUnit(delayUnit);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer delayAmount = (Integer)attributes.get("delayAmount");

		if (delayAmount != null) {
			setDelayAmount(delayAmount);
		}

		String croneType = (String)attributes.get("croneType");

		if (croneType != null) {
			setCroneType(croneType);
		}

		Date nextScheduleDateTime = (Date)attributes.get("nextScheduleDateTime");

		if (nextScheduleDateTime != null) {
			setNextScheduleDateTime(nextScheduleDateTime);
		}
	}

	@Override
	public long getSpMailCampaignEDMId() {
		return _spMailCampaignEDMId;
	}

	@Override
	public void setSpMailCampaignEDMId(long spMailCampaignEDMId) {
		_spMailCampaignEDMId = spMailCampaignEDMId;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignEDMId",
						long.class);

				method.invoke(_spMailCampaignEDMRemoteModel, spMailCampaignEDMId);
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

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spMailCampaignEDMRemoteModel, groupId);
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

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spMailCampaignEDMRemoteModel, companyId);
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

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spMailCampaignEDMRemoteModel, userId);
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

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spMailCampaignEDMRemoteModel, userName);
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

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spMailCampaignEDMRemoteModel, createDate);
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

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spMailCampaignEDMRemoteModel, modifiedDate);
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

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_spMailCampaignEDMRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpMailCampaignId() {
		return _spMailCampaignId;
	}

	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignId = spMailCampaignId;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignId",
						long.class);

				method.invoke(_spMailCampaignEDMRemoteModel, spMailCampaignId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpMailTemplateId() {
		return _spMailTemplateId;
	}

	@Override
	public void setSpMailTemplateId(long spMailTemplateId) {
		_spMailTemplateId = spMailTemplateId;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailTemplateId",
						long.class);

				method.invoke(_spMailCampaignEDMRemoteModel, spMailTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSeqNo() {
		return _seqNo;
	}

	@Override
	public void setSeqNo(int seqNo) {
		_seqNo = seqNo;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setSeqNo", int.class);

				method.invoke(_spMailCampaignEDMRemoteModel, seqNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDayOfWeek() {
		return _dayOfWeek;
	}

	@Override
	public void setDayOfWeek(int dayOfWeek) {
		_dayOfWeek = dayOfWeek;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setDayOfWeek", int.class);

				method.invoke(_spMailCampaignEDMRemoteModel, dayOfWeek);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDayOfMonth() {
		return _dayOfMonth;
	}

	@Override
	public void setDayOfMonth(int dayOfMonth) {
		_dayOfMonth = dayOfMonth;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setDayOfMonth", int.class);

				method.invoke(_spMailCampaignEDMRemoteModel, dayOfMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDelayUnit() {
		return _delayUnit;
	}

	@Override
	public void setDelayUnit(String delayUnit) {
		_delayUnit = delayUnit;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setDelayUnit", String.class);

				method.invoke(_spMailCampaignEDMRemoteModel, delayUnit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_spMailCampaignEDMRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDelayAmount() {
		return _delayAmount;
	}

	@Override
	public void setDelayAmount(int delayAmount) {
		_delayAmount = delayAmount;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setDelayAmount", int.class);

				method.invoke(_spMailCampaignEDMRemoteModel, delayAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCroneType() {
		return _croneType;
	}

	@Override
	public void setCroneType(String croneType) {
		_croneType = croneType;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setCroneType", String.class);

				method.invoke(_spMailCampaignEDMRemoteModel, croneType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNextScheduleDateTime() {
		return _nextScheduleDateTime;
	}

	@Override
	public void setNextScheduleDateTime(Date nextScheduleDateTime) {
		_nextScheduleDateTime = nextScheduleDateTime;

		if (_spMailCampaignEDMRemoteModel != null) {
			try {
				Class<?> clazz = _spMailCampaignEDMRemoteModel.getClass();

				Method method = clazz.getMethod("setNextScheduleDateTime",
						Date.class);

				method.invoke(_spMailCampaignEDMRemoteModel,
					nextScheduleDateTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPMailCampaignEDMRemoteModel() {
		return _spMailCampaignEDMRemoteModel;
	}

	public void setSPMailCampaignEDMRemoteModel(
		BaseModel<?> spMailCampaignEDMRemoteModel) {
		_spMailCampaignEDMRemoteModel = spMailCampaignEDMRemoteModel;
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

		Class<?> remoteModelClass = _spMailCampaignEDMRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spMailCampaignEDMRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailCampaignEDMLocalServiceUtil.addSPMailCampaignEDM(this);
		}
		else {
			SPMailCampaignEDMLocalServiceUtil.updateSPMailCampaignEDM(this);
		}
	}

	@Override
	public SPMailCampaignEDM toEscapedModel() {
		return (SPMailCampaignEDM)ProxyUtil.newProxyInstance(SPMailCampaignEDM.class.getClassLoader(),
			new Class[] { SPMailCampaignEDM.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPMailCampaignEDMClp clone = new SPMailCampaignEDMClp();

		clone.setSpMailCampaignEDMId(getSpMailCampaignEDMId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setSpMailCampaignId(getSpMailCampaignId());
		clone.setSpMailTemplateId(getSpMailTemplateId());
		clone.setSeqNo(getSeqNo());
		clone.setDayOfWeek(getDayOfWeek());
		clone.setDayOfMonth(getDayOfMonth());
		clone.setDelayUnit(getDelayUnit());
		clone.setStatus(getStatus());
		clone.setDelayAmount(getDelayAmount());
		clone.setCroneType(getCroneType());
		clone.setNextScheduleDateTime(getNextScheduleDateTime());

		return clone;
	}

	@Override
	public int compareTo(SPMailCampaignEDM spMailCampaignEDM) {
		int value = 0;

		if (getSeqNo() < spMailCampaignEDM.getSeqNo()) {
			value = -1;
		}
		else if (getSeqNo() > spMailCampaignEDM.getSeqNo()) {
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

		if (!(obj instanceof SPMailCampaignEDMClp)) {
			return false;
		}

		SPMailCampaignEDMClp spMailCampaignEDM = (SPMailCampaignEDMClp)obj;

		long primaryKey = spMailCampaignEDM.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{spMailCampaignEDMId=");
		sb.append(getSpMailCampaignEDMId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", spMailCampaignId=");
		sb.append(getSpMailCampaignId());
		sb.append(", spMailTemplateId=");
		sb.append(getSpMailTemplateId());
		sb.append(", seqNo=");
		sb.append(getSeqNo());
		sb.append(", dayOfWeek=");
		sb.append(getDayOfWeek());
		sb.append(", dayOfMonth=");
		sb.append(getDayOfMonth());
		sb.append(", delayUnit=");
		sb.append(getDelayUnit());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", delayAmount=");
		sb.append(getDelayAmount());
		sb.append(", croneType=");
		sb.append(getCroneType());
		sb.append(", nextScheduleDateTime=");
		sb.append(getNextScheduleDateTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.mail.model.SPMailCampaignEDM");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMailCampaignEDMId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignEDMId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailCampaignId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailTemplateId</column-name><column-value><![CDATA[");
		sb.append(getSpMailTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seqNo</column-name><column-value><![CDATA[");
		sb.append(getSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayOfWeek</column-name><column-value><![CDATA[");
		sb.append(getDayOfWeek());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayOfMonth</column-name><column-value><![CDATA[");
		sb.append(getDayOfMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>delayUnit</column-name><column-value><![CDATA[");
		sb.append(getDelayUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>delayAmount</column-name><column-value><![CDATA[");
		sb.append(getDelayAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>croneType</column-name><column-value><![CDATA[");
		sb.append(getCroneType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextScheduleDateTime</column-name><column-value><![CDATA[");
		sb.append(getNextScheduleDateTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spMailCampaignEDMId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _spMailCampaignId;
	private long _spMailTemplateId;
	private int _seqNo;
	private int _dayOfWeek;
	private int _dayOfMonth;
	private String _delayUnit;
	private String _status;
	private int _delayAmount;
	private String _croneType;
	private Date _nextScheduleDateTime;
	private BaseModel<?> _spMailCampaignEDMRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}