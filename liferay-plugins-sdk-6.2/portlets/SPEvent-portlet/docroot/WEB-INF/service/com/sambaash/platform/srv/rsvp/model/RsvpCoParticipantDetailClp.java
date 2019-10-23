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

package com.sambaash.platform.srv.rsvp.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.rsvp.service.ClpSerializer;
import com.sambaash.platform.srv.rsvp.service.RsvpCoParticipantDetailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class RsvpCoParticipantDetailClp extends BaseModelImpl<RsvpCoParticipantDetail>
	implements RsvpCoParticipantDetail {
	public RsvpCoParticipantDetailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpCoParticipantDetail.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpCoParticipantDetail.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _rsvpCoParticipantDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRsvpCoParticipantDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rsvpCoParticipantDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpCoParticipantDetailId",
			getRsvpCoParticipantDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpDetailId", getRsvpDetailId());
		attributes.put("rsvpPaymentId", getRsvpPaymentId());
		attributes.put("userId", getUserId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("nric", getNric());
		attributes.put("identificationType", getIdentificationType());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("rsvpStatus", getRsvpStatus());
		attributes.put("attendance", getAttendance());
		attributes.put("attendanceBy", getAttendanceBy());
		attributes.put("attendanceDate", getAttendanceDate());
		attributes.put("ticketNumber", getTicketNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpCoParticipantDetailId = (Long)attributes.get(
				"rsvpCoParticipantDetailId");

		if (rsvpCoParticipantDetailId != null) {
			setRsvpCoParticipantDetailId(rsvpCoParticipantDetailId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long rsvpDetailId = (Long)attributes.get("rsvpDetailId");

		if (rsvpDetailId != null) {
			setRsvpDetailId(rsvpDetailId);
		}

		Long rsvpPaymentId = (Long)attributes.get("rsvpPaymentId");

		if (rsvpPaymentId != null) {
			setRsvpPaymentId(rsvpPaymentId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String nric = (String)attributes.get("nric");

		if (nric != null) {
			setNric(nric);
		}

		String identificationType = (String)attributes.get("identificationType");

		if (identificationType != null) {
			setIdentificationType(identificationType);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Integer rsvpStatus = (Integer)attributes.get("rsvpStatus");

		if (rsvpStatus != null) {
			setRsvpStatus(rsvpStatus);
		}

		Integer attendance = (Integer)attributes.get("attendance");

		if (attendance != null) {
			setAttendance(attendance);
		}

		Long attendanceBy = (Long)attributes.get("attendanceBy");

		if (attendanceBy != null) {
			setAttendanceBy(attendanceBy);
		}

		Date attendanceDate = (Date)attributes.get("attendanceDate");

		if (attendanceDate != null) {
			setAttendanceDate(attendanceDate);
		}

		String ticketNumber = (String)attributes.get("ticketNumber");

		if (ticketNumber != null) {
			setTicketNumber(ticketNumber);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpCoParticipantDetailId() {
		return _rsvpCoParticipantDetailId;
	}

	@Override
	public void setRsvpCoParticipantDetailId(long rsvpCoParticipantDetailId) {
		_rsvpCoParticipantDetailId = rsvpCoParticipantDetailId;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpCoParticipantDetailId",
						long.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel,
					rsvpCoParticipantDetailId);
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

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, groupId);
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

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, companyId);
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

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, userName);
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

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, createDate);
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

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpDetailId() {
		return _rsvpDetailId;
	}

	@Override
	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpDetailId = rsvpDetailId;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpDetailId", long.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, rsvpDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpPaymentId() {
		return _rsvpPaymentId;
	}

	@Override
	public void setRsvpPaymentId(long rsvpPaymentId) {
		_rsvpPaymentId = rsvpPaymentId;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpPaymentId", long.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, rsvpPaymentId);
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

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, userId);
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
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNric() {
		return _nric;
	}

	@Override
	public void setNric(String nric) {
		_nric = nric;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setNric", String.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, nric);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdentificationType() {
		return _identificationType;
	}

	@Override
	public void setIdentificationType(String identificationType) {
		_identificationType = identificationType;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setIdentificationType",
						String.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel,
					identificationType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRsvpStatus() {
		return _rsvpStatus;
	}

	@Override
	public void setRsvpStatus(int rsvpStatus) {
		_rsvpStatus = rsvpStatus;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpStatus", int.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, rsvpStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAttendance() {
		return _attendance;
	}

	@Override
	public void setAttendance(int attendance) {
		_attendance = attendance;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAttendance", int.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, attendance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAttendanceBy() {
		return _attendanceBy;
	}

	@Override
	public void setAttendanceBy(long attendanceBy) {
		_attendanceBy = attendanceBy;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAttendanceBy", long.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, attendanceBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAttendanceDate() {
		return _attendanceDate;
	}

	@Override
	public void setAttendanceDate(Date attendanceDate) {
		_attendanceDate = attendanceDate;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAttendanceDate", Date.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel,
					attendanceDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTicketNumber() {
		return _ticketNumber;
	}

	@Override
	public void setTicketNumber(String ticketNumber) {
		_ticketNumber = ticketNumber;

		if (_rsvpCoParticipantDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpCoParticipantDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketNumber", String.class);

				method.invoke(_rsvpCoParticipantDetailRemoteModel, ticketNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RsvpCoParticipantDetail.class.getName()));
	}

	public BaseModel<?> getRsvpCoParticipantDetailRemoteModel() {
		return _rsvpCoParticipantDetailRemoteModel;
	}

	public void setRsvpCoParticipantDetailRemoteModel(
		BaseModel<?> rsvpCoParticipantDetailRemoteModel) {
		_rsvpCoParticipantDetailRemoteModel = rsvpCoParticipantDetailRemoteModel;
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

		Class<?> remoteModelClass = _rsvpCoParticipantDetailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rsvpCoParticipantDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RsvpCoParticipantDetailLocalServiceUtil.addRsvpCoParticipantDetail(this);
		}
		else {
			RsvpCoParticipantDetailLocalServiceUtil.updateRsvpCoParticipantDetail(this);
		}
	}

	@Override
	public RsvpCoParticipantDetail toEscapedModel() {
		return (RsvpCoParticipantDetail)ProxyUtil.newProxyInstance(RsvpCoParticipantDetail.class.getClassLoader(),
			new Class[] { RsvpCoParticipantDetail.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RsvpCoParticipantDetailClp clone = new RsvpCoParticipantDetailClp();

		clone.setUuid(getUuid());
		clone.setRsvpCoParticipantDetailId(getRsvpCoParticipantDetailId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRsvpDetailId(getRsvpDetailId());
		clone.setRsvpPaymentId(getRsvpPaymentId());
		clone.setUserId(getUserId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setNric(getNric());
		clone.setIdentificationType(getIdentificationType());
		clone.setEmailAddress(getEmailAddress());
		clone.setRsvpStatus(getRsvpStatus());
		clone.setAttendance(getAttendance());
		clone.setAttendanceBy(getAttendanceBy());
		clone.setAttendanceDate(getAttendanceDate());
		clone.setTicketNumber(getTicketNumber());

		return clone;
	}

	@Override
	public int compareTo(RsvpCoParticipantDetail rsvpCoParticipantDetail) {
		long primaryKey = rsvpCoParticipantDetail.getPrimaryKey();

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

		if (!(obj instanceof RsvpCoParticipantDetailClp)) {
			return false;
		}

		RsvpCoParticipantDetailClp rsvpCoParticipantDetail = (RsvpCoParticipantDetailClp)obj;

		long primaryKey = rsvpCoParticipantDetail.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", rsvpCoParticipantDetailId=");
		sb.append(getRsvpCoParticipantDetailId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", rsvpDetailId=");
		sb.append(getRsvpDetailId());
		sb.append(", rsvpPaymentId=");
		sb.append(getRsvpPaymentId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", nric=");
		sb.append(getNric());
		sb.append(", identificationType=");
		sb.append(getIdentificationType());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", rsvpStatus=");
		sb.append(getRsvpStatus());
		sb.append(", attendance=");
		sb.append(getAttendance());
		sb.append(", attendanceBy=");
		sb.append(getAttendanceBy());
		sb.append(", attendanceDate=");
		sb.append(getAttendanceDate());
		sb.append(", ticketNumber=");
		sb.append(getTicketNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpCoParticipantDetailId</column-name><column-value><![CDATA[");
		sb.append(getRsvpCoParticipantDetailId());
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
			"<column><column-name>rsvpDetailId</column-name><column-value><![CDATA[");
		sb.append(getRsvpDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpPaymentId</column-name><column-value><![CDATA[");
		sb.append(getRsvpPaymentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nric</column-name><column-value><![CDATA[");
		sb.append(getNric());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>identificationType</column-name><column-value><![CDATA[");
		sb.append(getIdentificationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpStatus</column-name><column-value><![CDATA[");
		sb.append(getRsvpStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attendance</column-name><column-value><![CDATA[");
		sb.append(getAttendance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attendanceBy</column-name><column-value><![CDATA[");
		sb.append(getAttendanceBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attendanceDate</column-name><column-value><![CDATA[");
		sb.append(getAttendanceDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNumber</column-name><column-value><![CDATA[");
		sb.append(getTicketNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _rsvpCoParticipantDetailId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rsvpDetailId;
	private long _rsvpPaymentId;
	private long _userId;
	private String _userUuid;
	private String _firstName;
	private String _lastName;
	private String _nric;
	private String _identificationType;
	private String _emailAddress;
	private int _rsvpStatus;
	private int _attendance;
	private long _attendanceBy;
	private Date _attendanceDate;
	private String _ticketNumber;
	private BaseModel<?> _rsvpCoParticipantDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.rsvp.service.ClpSerializer.class;
}