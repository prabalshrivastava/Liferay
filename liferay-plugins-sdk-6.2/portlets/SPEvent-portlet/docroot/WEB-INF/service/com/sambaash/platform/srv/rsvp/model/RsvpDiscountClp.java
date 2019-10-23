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
import com.sambaash.platform.srv.rsvp.service.RsvpDiscountLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class RsvpDiscountClp extends BaseModelImpl<RsvpDiscount>
	implements RsvpDiscount {
	public RsvpDiscountClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpDiscount.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpDiscount.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _rsvpDiscountId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRsvpDiscountId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rsvpDiscountId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpDiscountId", getRsvpDiscountId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("rsvpTicketId", getRsvpTicketId());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("noOfTickets", getNoOfTickets());
		attributes.put("discount", getDiscount());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpDiscountId = (Long)attributes.get("rsvpDiscountId");

		if (rsvpDiscountId != null) {
			setRsvpDiscountId(rsvpDiscountId);
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

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
		}

		Long rsvpTicketId = (Long)attributes.get("rsvpTicketId");

		if (rsvpTicketId != null) {
			setRsvpTicketId(rsvpTicketId);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Integer noOfTickets = (Integer)attributes.get("noOfTickets");

		if (noOfTickets != null) {
			setNoOfTickets(noOfTickets);
		}

		Double discount = (Double)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_rsvpDiscountRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpDiscountId() {
		return _rsvpDiscountId;
	}

	@Override
	public void setRsvpDiscountId(long rsvpDiscountId) {
		_rsvpDiscountId = rsvpDiscountId;

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpDiscountId", long.class);

				method.invoke(_rsvpDiscountRemoteModel, rsvpDiscountId);
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

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_rsvpDiscountRemoteModel, groupId);
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

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_rsvpDiscountRemoteModel, companyId);
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

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rsvpDiscountRemoteModel, userId);
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

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_rsvpDiscountRemoteModel, userName);
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

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_rsvpDiscountRemoteModel, createDate);
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

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_rsvpDiscountRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpId() {
		return _rsvpId;
	}

	@Override
	public void setRsvpId(long rsvpId) {
		_rsvpId = rsvpId;

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpId", long.class);

				method.invoke(_rsvpDiscountRemoteModel, rsvpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpTicketId() {
		return _rsvpTicketId;
	}

	@Override
	public void setRsvpTicketId(long rsvpTicketId) {
		_rsvpTicketId = rsvpTicketId;

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpTicketId", long.class);

				method.invoke(_rsvpDiscountRemoteModel, rsvpTicketId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFromDate() {
		return _fromDate;
	}

	@Override
	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setFromDate", Date.class);

				method.invoke(_rsvpDiscountRemoteModel, fromDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getToDate() {
		return _toDate;
	}

	@Override
	public void setToDate(Date toDate) {
		_toDate = toDate;

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setToDate", Date.class);

				method.invoke(_rsvpDiscountRemoteModel, toDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNoOfTickets() {
		return _noOfTickets;
	}

	@Override
	public void setNoOfTickets(int noOfTickets) {
		_noOfTickets = noOfTickets;

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setNoOfTickets", int.class);

				method.invoke(_rsvpDiscountRemoteModel, noOfTickets);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getDiscount() {
		return _discount;
	}

	@Override
	public void setDiscount(double discount) {
		_discount = discount;

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", double.class);

				method.invoke(_rsvpDiscountRemoteModel, discount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_rsvpDiscountRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDiscountRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_rsvpDiscountRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RsvpDiscount.class.getName()));
	}

	public BaseModel<?> getRsvpDiscountRemoteModel() {
		return _rsvpDiscountRemoteModel;
	}

	public void setRsvpDiscountRemoteModel(BaseModel<?> rsvpDiscountRemoteModel) {
		_rsvpDiscountRemoteModel = rsvpDiscountRemoteModel;
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

		Class<?> remoteModelClass = _rsvpDiscountRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rsvpDiscountRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RsvpDiscountLocalServiceUtil.addRsvpDiscount(this);
		}
		else {
			RsvpDiscountLocalServiceUtil.updateRsvpDiscount(this);
		}
	}

	@Override
	public RsvpDiscount toEscapedModel() {
		return (RsvpDiscount)ProxyUtil.newProxyInstance(RsvpDiscount.class.getClassLoader(),
			new Class[] { RsvpDiscount.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RsvpDiscountClp clone = new RsvpDiscountClp();

		clone.setUuid(getUuid());
		clone.setRsvpDiscountId(getRsvpDiscountId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRsvpId(getRsvpId());
		clone.setRsvpTicketId(getRsvpTicketId());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setNoOfTickets(getNoOfTickets());
		clone.setDiscount(getDiscount());
		clone.setModifiedBy(getModifiedBy());

		return clone;
	}

	@Override
	public int compareTo(RsvpDiscount rsvpDiscount) {
		long primaryKey = rsvpDiscount.getPrimaryKey();

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

		if (!(obj instanceof RsvpDiscountClp)) {
			return false;
		}

		RsvpDiscountClp rsvpDiscount = (RsvpDiscountClp)obj;

		long primaryKey = rsvpDiscount.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", rsvpDiscountId=");
		sb.append(getRsvpDiscountId());
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
		sb.append(", rsvpId=");
		sb.append(getRsvpId());
		sb.append(", rsvpTicketId=");
		sb.append(getRsvpTicketId());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", noOfTickets=");
		sb.append(getNoOfTickets());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.rsvp.model.RsvpDiscount");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpDiscountId</column-name><column-value><![CDATA[");
		sb.append(getRsvpDiscountId());
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
			"<column><column-name>rsvpId</column-name><column-value><![CDATA[");
		sb.append(getRsvpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpTicketId</column-name><column-value><![CDATA[");
		sb.append(getRsvpTicketId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromDate</column-name><column-value><![CDATA[");
		sb.append(getFromDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toDate</column-name><column-value><![CDATA[");
		sb.append(getToDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noOfTickets</column-name><column-value><![CDATA[");
		sb.append(getNoOfTickets());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _rsvpDiscountId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rsvpId;
	private long _rsvpTicketId;
	private Date _fromDate;
	private Date _toDate;
	private int _noOfTickets;
	private double _discount;
	private long _modifiedBy;
	private BaseModel<?> _rsvpDiscountRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.rsvp.service.ClpSerializer.class;
}