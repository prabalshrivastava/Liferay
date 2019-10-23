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
import com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class RsvpTicketClp extends BaseModelImpl<RsvpTicket>
	implements RsvpTicket {
	public RsvpTicketClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpTicket.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpTicket.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _rsvpTicketId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRsvpTicketId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rsvpTicketId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpTicketId", getRsvpTicketId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("price", getPrice());
		attributes.put("quantity", getQuantity());
		attributes.put("soldQuantity", getSoldQuantity());
		attributes.put("ticketSequence", getTicketSequence());
		attributes.put("lastSequenceNumber", getLastSequenceNumber());
		attributes.put("sequencePrefix", getSequencePrefix());
		attributes.put("sequenceSuffix", getSequenceSuffix());
		attributes.put("ticketTemplateUrl", getTicketTemplateUrl());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpTicketId = (Long)attributes.get("rsvpTicketId");

		if (rsvpTicketId != null) {
			setRsvpTicketId(rsvpTicketId);
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

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Integer soldQuantity = (Integer)attributes.get("soldQuantity");

		if (soldQuantity != null) {
			setSoldQuantity(soldQuantity);
		}

		Integer ticketSequence = (Integer)attributes.get("ticketSequence");

		if (ticketSequence != null) {
			setTicketSequence(ticketSequence);
		}

		Integer lastSequenceNumber = (Integer)attributes.get(
				"lastSequenceNumber");

		if (lastSequenceNumber != null) {
			setLastSequenceNumber(lastSequenceNumber);
		}

		String sequencePrefix = (String)attributes.get("sequencePrefix");

		if (sequencePrefix != null) {
			setSequencePrefix(sequencePrefix);
		}

		String sequenceSuffix = (String)attributes.get("sequenceSuffix");

		if (sequenceSuffix != null) {
			setSequenceSuffix(sequenceSuffix);
		}

		String ticketTemplateUrl = (String)attributes.get("ticketTemplateUrl");

		if (ticketTemplateUrl != null) {
			setTicketTemplateUrl(ticketTemplateUrl);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_rsvpTicketRemoteModel, uuid);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpTicketId", long.class);

				method.invoke(_rsvpTicketRemoteModel, rsvpTicketId);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_rsvpTicketRemoteModel, groupId);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_rsvpTicketRemoteModel, companyId);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rsvpTicketRemoteModel, userId);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_rsvpTicketRemoteModel, userName);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_rsvpTicketRemoteModel, createDate);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_rsvpTicketRemoteModel, modifiedDate);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpId", long.class);

				method.invoke(_rsvpTicketRemoteModel, rsvpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_rsvpTicketRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", int.class);

				method.invoke(_rsvpTicketRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSoldQuantity() {
		return _soldQuantity;
	}

	@Override
	public void setSoldQuantity(int soldQuantity) {
		_soldQuantity = soldQuantity;

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setSoldQuantity", int.class);

				method.invoke(_rsvpTicketRemoteModel, soldQuantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTicketSequence() {
		return _ticketSequence;
	}

	@Override
	public void setTicketSequence(int ticketSequence) {
		_ticketSequence = ticketSequence;

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketSequence", int.class);

				method.invoke(_rsvpTicketRemoteModel, ticketSequence);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLastSequenceNumber() {
		return _lastSequenceNumber;
	}

	@Override
	public void setLastSequenceNumber(int lastSequenceNumber) {
		_lastSequenceNumber = lastSequenceNumber;

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setLastSequenceNumber",
						int.class);

				method.invoke(_rsvpTicketRemoteModel, lastSequenceNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSequencePrefix() {
		return _sequencePrefix;
	}

	@Override
	public void setSequencePrefix(String sequencePrefix) {
		_sequencePrefix = sequencePrefix;

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setSequencePrefix",
						String.class);

				method.invoke(_rsvpTicketRemoteModel, sequencePrefix);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSequenceSuffix() {
		return _sequenceSuffix;
	}

	@Override
	public void setSequenceSuffix(String sequenceSuffix) {
		_sequenceSuffix = sequenceSuffix;

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setSequenceSuffix",
						String.class);

				method.invoke(_rsvpTicketRemoteModel, sequenceSuffix);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTicketTemplateUrl() {
		return _ticketTemplateUrl;
	}

	@Override
	public void setTicketTemplateUrl(String ticketTemplateUrl) {
		_ticketTemplateUrl = ticketTemplateUrl;

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setTicketTemplateUrl",
						String.class);

				method.invoke(_rsvpTicketRemoteModel, ticketTemplateUrl);
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

		if (_rsvpTicketRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpTicketRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_rsvpTicketRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RsvpTicket.class.getName()));
	}

	public BaseModel<?> getRsvpTicketRemoteModel() {
		return _rsvpTicketRemoteModel;
	}

	public void setRsvpTicketRemoteModel(BaseModel<?> rsvpTicketRemoteModel) {
		_rsvpTicketRemoteModel = rsvpTicketRemoteModel;
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

		Class<?> remoteModelClass = _rsvpTicketRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rsvpTicketRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RsvpTicketLocalServiceUtil.addRsvpTicket(this);
		}
		else {
			RsvpTicketLocalServiceUtil.updateRsvpTicket(this);
		}
	}

	@Override
	public RsvpTicket toEscapedModel() {
		return (RsvpTicket)ProxyUtil.newProxyInstance(RsvpTicket.class.getClassLoader(),
			new Class[] { RsvpTicket.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RsvpTicketClp clone = new RsvpTicketClp();

		clone.setUuid(getUuid());
		clone.setRsvpTicketId(getRsvpTicketId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRsvpId(getRsvpId());
		clone.setPrice(getPrice());
		clone.setQuantity(getQuantity());
		clone.setSoldQuantity(getSoldQuantity());
		clone.setTicketSequence(getTicketSequence());
		clone.setLastSequenceNumber(getLastSequenceNumber());
		clone.setSequencePrefix(getSequencePrefix());
		clone.setSequenceSuffix(getSequenceSuffix());
		clone.setTicketTemplateUrl(getTicketTemplateUrl());
		clone.setModifiedBy(getModifiedBy());

		return clone;
	}

	@Override
	public int compareTo(RsvpTicket rsvpTicket) {
		long primaryKey = rsvpTicket.getPrimaryKey();

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

		if (!(obj instanceof RsvpTicketClp)) {
			return false;
		}

		RsvpTicketClp rsvpTicket = (RsvpTicketClp)obj;

		long primaryKey = rsvpTicket.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", rsvpTicketId=");
		sb.append(getRsvpTicketId());
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
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", soldQuantity=");
		sb.append(getSoldQuantity());
		sb.append(", ticketSequence=");
		sb.append(getTicketSequence());
		sb.append(", lastSequenceNumber=");
		sb.append(getLastSequenceNumber());
		sb.append(", sequencePrefix=");
		sb.append(getSequencePrefix());
		sb.append(", sequenceSuffix=");
		sb.append(getSequenceSuffix());
		sb.append(", ticketTemplateUrl=");
		sb.append(getTicketTemplateUrl());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.rsvp.model.RsvpTicket");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpTicketId</column-name><column-value><![CDATA[");
		sb.append(getRsvpTicketId());
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
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soldQuantity</column-name><column-value><![CDATA[");
		sb.append(getSoldQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketSequence</column-name><column-value><![CDATA[");
		sb.append(getTicketSequence());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastSequenceNumber</column-name><column-value><![CDATA[");
		sb.append(getLastSequenceNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequencePrefix</column-name><column-value><![CDATA[");
		sb.append(getSequencePrefix());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceSuffix</column-name><column-value><![CDATA[");
		sb.append(getSequenceSuffix());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketTemplateUrl</column-name><column-value><![CDATA[");
		sb.append(getTicketTemplateUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _rsvpTicketId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rsvpId;
	private double _price;
	private int _quantity;
	private int _soldQuantity;
	private int _ticketSequence;
	private int _lastSequenceNumber;
	private String _sequencePrefix;
	private String _sequenceSuffix;
	private String _ticketTemplateUrl;
	private long _modifiedBy;
	private BaseModel<?> _rsvpTicketRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.rsvp.service.ClpSerializer.class;
}