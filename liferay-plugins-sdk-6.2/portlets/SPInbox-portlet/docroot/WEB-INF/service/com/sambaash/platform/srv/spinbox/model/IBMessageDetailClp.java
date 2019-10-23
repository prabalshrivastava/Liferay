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

package com.sambaash.platform.srv.spinbox.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.spinbox.service.ClpSerializer;
import com.sambaash.platform.srv.spinbox.service.IBMessageDetailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class IBMessageDetailClp extends BaseModelImpl<IBMessageDetail>
	implements IBMessageDetail {
	public IBMessageDetailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return IBMessageDetail.class;
	}

	@Override
	public String getModelClassName() {
		return IBMessageDetail.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ibMsgDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIbMsgDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ibMsgDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ibMsgDetailId", getIbMsgDetailId());
		attributes.put("receiverId", getReceiverId());
		attributes.put("messageId", getMessageId());
		attributes.put("receiverMsgStatus", getReceiverMsgStatus());
		attributes.put("senderMsgStatus", getSenderMsgStatus());
		attributes.put("status", getStatus());
		attributes.put("receiveDate", getReceiveDate());
		attributes.put("receiveBy", getReceiveBy());
		attributes.put("archived", getArchived());
		attributes.put("updateDate", getUpdateDate());
		attributes.put("updateBy", getUpdateBy());
		attributes.put("category", getCategory());
		attributes.put("processId", getProcessId());
		attributes.put("corpProfileId", getCorpProfileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ibMsgDetailId = (Long)attributes.get("ibMsgDetailId");

		if (ibMsgDetailId != null) {
			setIbMsgDetailId(ibMsgDetailId);
		}

		Long receiverId = (Long)attributes.get("receiverId");

		if (receiverId != null) {
			setReceiverId(receiverId);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		String receiverMsgStatus = (String)attributes.get("receiverMsgStatus");

		if (receiverMsgStatus != null) {
			setReceiverMsgStatus(receiverMsgStatus);
		}

		String senderMsgStatus = (String)attributes.get("senderMsgStatus");

		if (senderMsgStatus != null) {
			setSenderMsgStatus(senderMsgStatus);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date receiveDate = (Date)attributes.get("receiveDate");

		if (receiveDate != null) {
			setReceiveDate(receiveDate);
		}

		String receiveBy = (String)attributes.get("receiveBy");

		if (receiveBy != null) {
			setReceiveBy(receiveBy);
		}

		Boolean archived = (Boolean)attributes.get("archived");

		if (archived != null) {
			setArchived(archived);
		}

		Date updateDate = (Date)attributes.get("updateDate");

		if (updateDate != null) {
			setUpdateDate(updateDate);
		}

		String updateBy = (String)attributes.get("updateBy");

		if (updateBy != null) {
			setUpdateBy(updateBy);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long processId = (Long)attributes.get("processId");

		if (processId != null) {
			setProcessId(processId);
		}

		Long corpProfileId = (Long)attributes.get("corpProfileId");

		if (corpProfileId != null) {
			setCorpProfileId(corpProfileId);
		}
	}

	@Override
	public long getIbMsgDetailId() {
		return _ibMsgDetailId;
	}

	@Override
	public void setIbMsgDetailId(long ibMsgDetailId) {
		_ibMsgDetailId = ibMsgDetailId;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setIbMsgDetailId", long.class);

				method.invoke(_ibMessageDetailRemoteModel, ibMsgDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReceiverId() {
		return _receiverId;
	}

	@Override
	public void setReceiverId(long receiverId) {
		_receiverId = receiverId;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setReceiverId", long.class);

				method.invoke(_ibMessageDetailRemoteModel, receiverId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(long messageId) {
		_messageId = messageId;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageId", long.class);

				method.invoke(_ibMessageDetailRemoteModel, messageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceiverMsgStatus() {
		return _receiverMsgStatus;
	}

	@Override
	public void setReceiverMsgStatus(String receiverMsgStatus) {
		_receiverMsgStatus = receiverMsgStatus;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setReceiverMsgStatus",
						String.class);

				method.invoke(_ibMessageDetailRemoteModel, receiverMsgStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSenderMsgStatus() {
		return _senderMsgStatus;
	}

	@Override
	public void setSenderMsgStatus(String senderMsgStatus) {
		_senderMsgStatus = senderMsgStatus;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderMsgStatus",
						String.class);

				method.invoke(_ibMessageDetailRemoteModel, senderMsgStatus);
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

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_ibMessageDetailRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReceiveDate() {
		return _receiveDate;
	}

	@Override
	public void setReceiveDate(Date receiveDate) {
		_receiveDate = receiveDate;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setReceiveDate", Date.class);

				method.invoke(_ibMessageDetailRemoteModel, receiveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceiveBy() {
		return _receiveBy;
	}

	@Override
	public void setReceiveBy(String receiveBy) {
		_receiveBy = receiveBy;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setReceiveBy", String.class);

				method.invoke(_ibMessageDetailRemoteModel, receiveBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getArchived() {
		return _archived;
	}

	@Override
	public boolean isArchived() {
		return _archived;
	}

	@Override
	public void setArchived(boolean archived) {
		_archived = archived;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setArchived", boolean.class);

				method.invoke(_ibMessageDetailRemoteModel, archived);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDate", Date.class);

				method.invoke(_ibMessageDetailRemoteModel, updateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdateBy() {
		return _updateBy;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		_updateBy = updateBy;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateBy", String.class);

				method.invoke(_ibMessageDetailRemoteModel, updateBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_ibMessageDetailRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProcessId() {
		return _processId;
	}

	@Override
	public void setProcessId(long processId) {
		_processId = processId;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessId", long.class);

				method.invoke(_ibMessageDetailRemoteModel, processId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCorpProfileId() {
		return _corpProfileId;
	}

	@Override
	public void setCorpProfileId(long corpProfileId) {
		_corpProfileId = corpProfileId;

		if (_ibMessageDetailRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCorpProfileId", long.class);

				method.invoke(_ibMessageDetailRemoteModel, corpProfileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getIBMessageDetailRemoteModel() {
		return _ibMessageDetailRemoteModel;
	}

	public void setIBMessageDetailRemoteModel(
		BaseModel<?> ibMessageDetailRemoteModel) {
		_ibMessageDetailRemoteModel = ibMessageDetailRemoteModel;
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

		Class<?> remoteModelClass = _ibMessageDetailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_ibMessageDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			IBMessageDetailLocalServiceUtil.addIBMessageDetail(this);
		}
		else {
			IBMessageDetailLocalServiceUtil.updateIBMessageDetail(this);
		}
	}

	@Override
	public IBMessageDetail toEscapedModel() {
		return (IBMessageDetail)ProxyUtil.newProxyInstance(IBMessageDetail.class.getClassLoader(),
			new Class[] { IBMessageDetail.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		IBMessageDetailClp clone = new IBMessageDetailClp();

		clone.setIbMsgDetailId(getIbMsgDetailId());
		clone.setReceiverId(getReceiverId());
		clone.setMessageId(getMessageId());
		clone.setReceiverMsgStatus(getReceiverMsgStatus());
		clone.setSenderMsgStatus(getSenderMsgStatus());
		clone.setStatus(getStatus());
		clone.setReceiveDate(getReceiveDate());
		clone.setReceiveBy(getReceiveBy());
		clone.setArchived(getArchived());
		clone.setUpdateDate(getUpdateDate());
		clone.setUpdateBy(getUpdateBy());
		clone.setCategory(getCategory());
		clone.setProcessId(getProcessId());
		clone.setCorpProfileId(getCorpProfileId());

		return clone;
	}

	@Override
	public int compareTo(IBMessageDetail ibMessageDetail) {
		int value = 0;

		value = DateUtil.compareTo(getReceiveDate(),
				ibMessageDetail.getReceiveDate());

		value = value * -1;

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

		if (!(obj instanceof IBMessageDetailClp)) {
			return false;
		}

		IBMessageDetailClp ibMessageDetail = (IBMessageDetailClp)obj;

		long primaryKey = ibMessageDetail.getPrimaryKey();

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

		sb.append("{ibMsgDetailId=");
		sb.append(getIbMsgDetailId());
		sb.append(", receiverId=");
		sb.append(getReceiverId());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", receiverMsgStatus=");
		sb.append(getReceiverMsgStatus());
		sb.append(", senderMsgStatus=");
		sb.append(getSenderMsgStatus());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", receiveDate=");
		sb.append(getReceiveDate());
		sb.append(", receiveBy=");
		sb.append(getReceiveBy());
		sb.append(", archived=");
		sb.append(getArchived());
		sb.append(", updateDate=");
		sb.append(getUpdateDate());
		sb.append(", updateBy=");
		sb.append(getUpdateBy());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", processId=");
		sb.append(getProcessId());
		sb.append(", corpProfileId=");
		sb.append(getCorpProfileId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spinbox.model.IBMessageDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ibMsgDetailId</column-name><column-value><![CDATA[");
		sb.append(getIbMsgDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiverId</column-name><column-value><![CDATA[");
		sb.append(getReceiverId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiverMsgStatus</column-name><column-value><![CDATA[");
		sb.append(getReceiverMsgStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderMsgStatus</column-name><column-value><![CDATA[");
		sb.append(getSenderMsgStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiveDate</column-name><column-value><![CDATA[");
		sb.append(getReceiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiveBy</column-name><column-value><![CDATA[");
		sb.append(getReceiveBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archived</column-name><column-value><![CDATA[");
		sb.append(getArchived());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDate</column-name><column-value><![CDATA[");
		sb.append(getUpdateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateBy</column-name><column-value><![CDATA[");
		sb.append(getUpdateBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processId</column-name><column-value><![CDATA[");
		sb.append(getProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corpProfileId</column-name><column-value><![CDATA[");
		sb.append(getCorpProfileId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ibMsgDetailId;
	private long _receiverId;
	private long _messageId;
	private String _receiverMsgStatus;
	private String _senderMsgStatus;
	private String _status;
	private Date _receiveDate;
	private String _receiveBy;
	private boolean _archived;
	private Date _updateDate;
	private String _updateBy;
	private String _category;
	private long _processId;
	private long _corpProfileId;
	private BaseModel<?> _ibMessageDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spinbox.service.ClpSerializer.class;
}