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
import com.sambaash.platform.srv.spinbox.service.IBMessageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class IBMessageClp extends BaseModelImpl<IBMessage> implements IBMessage {
	public IBMessageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return IBMessage.class;
	}

	@Override
	public String getModelClassName() {
		return IBMessage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _messageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _messageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("messageId", getMessageId());
		attributes.put("parentMessageId", getParentMessageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("subject", getSubject());
		attributes.put("content", getContent());
		attributes.put("from", getFrom());
		attributes.put("to", getTo());
		attributes.put("allowOpen", getAllowOpen());
		attributes.put("sendDate", getSendDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("createByUserId", getCreateByUserId());
		attributes.put("draft", getDraft());
		attributes.put("deleteStatus", getDeleteStatus());
		attributes.put("draftStatus", getDraftStatus());
		attributes.put("sentMeCopy", getSentMeCopy());
		attributes.put("belongToGroupDetailId", getBelongToGroupDetailId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long parentMessageId = (Long)attributes.get("parentMessageId");

		if (parentMessageId != null) {
			setParentMessageId(parentMessageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String from = (String)attributes.get("from");

		if (from != null) {
			setFrom(from);
		}

		String to = (String)attributes.get("to");

		if (to != null) {
			setTo(to);
		}

		Boolean allowOpen = (Boolean)attributes.get("allowOpen");

		if (allowOpen != null) {
			setAllowOpen(allowOpen);
		}

		Date sendDate = (Date)attributes.get("sendDate");

		if (sendDate != null) {
			setSendDate(sendDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String createBy = (String)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		String createByUserId = (String)attributes.get("createByUserId");

		if (createByUserId != null) {
			setCreateByUserId(createByUserId);
		}

		Boolean draft = (Boolean)attributes.get("draft");

		if (draft != null) {
			setDraft(draft);
		}

		Boolean deleteStatus = (Boolean)attributes.get("deleteStatus");

		if (deleteStatus != null) {
			setDeleteStatus(deleteStatus);
		}

		String draftStatus = (String)attributes.get("draftStatus");

		if (draftStatus != null) {
			setDraftStatus(draftStatus);
		}

		Boolean sentMeCopy = (Boolean)attributes.get("sentMeCopy");

		if (sentMeCopy != null) {
			setSentMeCopy(sentMeCopy);
		}

		Long belongToGroupDetailId = (Long)attributes.get(
				"belongToGroupDetailId");

		if (belongToGroupDetailId != null) {
			setBelongToGroupDetailId(belongToGroupDetailId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_ibMessageRemoteModel, uuid);
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

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageId", long.class);

				method.invoke(_ibMessageRemoteModel, messageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentMessageId() {
		return _parentMessageId;
	}

	@Override
	public void setParentMessageId(long parentMessageId) {
		_parentMessageId = parentMessageId;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setParentMessageId", long.class);

				method.invoke(_ibMessageRemoteModel, parentMessageId);
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

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_ibMessageRemoteModel, groupId);
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

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_ibMessageRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubject() {
		return _subject;
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_ibMessageRemoteModel, subject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_ibMessageRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFrom() {
		return _from;
	}

	@Override
	public void setFrom(String from) {
		_from = from;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setFrom", String.class);

				method.invoke(_ibMessageRemoteModel, from);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTo() {
		return _to;
	}

	@Override
	public void setTo(String to) {
		_to = to;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setTo", String.class);

				method.invoke(_ibMessageRemoteModel, to);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAllowOpen() {
		return _allowOpen;
	}

	@Override
	public boolean isAllowOpen() {
		return _allowOpen;
	}

	@Override
	public void setAllowOpen(boolean allowOpen) {
		_allowOpen = allowOpen;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setAllowOpen", boolean.class);

				method.invoke(_ibMessageRemoteModel, allowOpen);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSendDate() {
		return _sendDate;
	}

	@Override
	public void setSendDate(Date sendDate) {
		_sendDate = sendDate;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setSendDate", Date.class);

				method.invoke(_ibMessageRemoteModel, sendDate);
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

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_ibMessageRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateBy() {
		return _createBy;
	}

	@Override
	public void setCreateBy(String createBy) {
		_createBy = createBy;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateBy", String.class);

				method.invoke(_ibMessageRemoteModel, createBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateByUserId() {
		return _createByUserId;
	}

	@Override
	public void setCreateByUserId(String createByUserId) {
		_createByUserId = createByUserId;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateByUserId",
						String.class);

				method.invoke(_ibMessageRemoteModel, createByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDraft() {
		return _draft;
	}

	@Override
	public boolean isDraft() {
		return _draft;
	}

	@Override
	public void setDraft(boolean draft) {
		_draft = draft;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setDraft", boolean.class);

				method.invoke(_ibMessageRemoteModel, draft);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeleteStatus() {
		return _deleteStatus;
	}

	@Override
	public boolean isDeleteStatus() {
		return _deleteStatus;
	}

	@Override
	public void setDeleteStatus(boolean deleteStatus) {
		_deleteStatus = deleteStatus;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleteStatus", boolean.class);

				method.invoke(_ibMessageRemoteModel, deleteStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDraftStatus() {
		return _draftStatus;
	}

	@Override
	public void setDraftStatus(String draftStatus) {
		_draftStatus = draftStatus;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setDraftStatus", String.class);

				method.invoke(_ibMessageRemoteModel, draftStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSentMeCopy() {
		return _sentMeCopy;
	}

	@Override
	public boolean isSentMeCopy() {
		return _sentMeCopy;
	}

	@Override
	public void setSentMeCopy(boolean sentMeCopy) {
		_sentMeCopy = sentMeCopy;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setSentMeCopy", boolean.class);

				method.invoke(_ibMessageRemoteModel, sentMeCopy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBelongToGroupDetailId() {
		return _belongToGroupDetailId;
	}

	@Override
	public void setBelongToGroupDetailId(long belongToGroupDetailId) {
		_belongToGroupDetailId = belongToGroupDetailId;

		if (_ibMessageRemoteModel != null) {
			try {
				Class<?> clazz = _ibMessageRemoteModel.getClass();

				Method method = clazz.getMethod("setBelongToGroupDetailId",
						long.class);

				method.invoke(_ibMessageRemoteModel, belongToGroupDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getIBMessageRemoteModel() {
		return _ibMessageRemoteModel;
	}

	public void setIBMessageRemoteModel(BaseModel<?> ibMessageRemoteModel) {
		_ibMessageRemoteModel = ibMessageRemoteModel;
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

		Class<?> remoteModelClass = _ibMessageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_ibMessageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			IBMessageLocalServiceUtil.addIBMessage(this);
		}
		else {
			IBMessageLocalServiceUtil.updateIBMessage(this);
		}
	}

	@Override
	public IBMessage toEscapedModel() {
		return (IBMessage)ProxyUtil.newProxyInstance(IBMessage.class.getClassLoader(),
			new Class[] { IBMessage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		IBMessageClp clone = new IBMessageClp();

		clone.setUuid(getUuid());
		clone.setMessageId(getMessageId());
		clone.setParentMessageId(getParentMessageId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setSubject(getSubject());
		clone.setContent(getContent());
		clone.setFrom(getFrom());
		clone.setTo(getTo());
		clone.setAllowOpen(getAllowOpen());
		clone.setSendDate(getSendDate());
		clone.setCreateDate(getCreateDate());
		clone.setCreateBy(getCreateBy());
		clone.setCreateByUserId(getCreateByUserId());
		clone.setDraft(getDraft());
		clone.setDeleteStatus(getDeleteStatus());
		clone.setDraftStatus(getDraftStatus());
		clone.setSentMeCopy(getSentMeCopy());
		clone.setBelongToGroupDetailId(getBelongToGroupDetailId());

		return clone;
	}

	@Override
	public int compareTo(IBMessage ibMessage) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), ibMessage.getCreateDate());

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

		if (!(obj instanceof IBMessageClp)) {
			return false;
		}

		IBMessageClp ibMessage = (IBMessageClp)obj;

		long primaryKey = ibMessage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", parentMessageId=");
		sb.append(getParentMessageId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", from=");
		sb.append(getFrom());
		sb.append(", to=");
		sb.append(getTo());
		sb.append(", allowOpen=");
		sb.append(getAllowOpen());
		sb.append(", sendDate=");
		sb.append(getSendDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", createBy=");
		sb.append(getCreateBy());
		sb.append(", createByUserId=");
		sb.append(getCreateByUserId());
		sb.append(", draft=");
		sb.append(getDraft());
		sb.append(", deleteStatus=");
		sb.append(getDeleteStatus());
		sb.append(", draftStatus=");
		sb.append(getDraftStatus());
		sb.append(", sentMeCopy=");
		sb.append(getSentMeCopy());
		sb.append(", belongToGroupDetailId=");
		sb.append(getBelongToGroupDetailId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spinbox.model.IBMessage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentMessageId</column-name><column-value><![CDATA[");
		sb.append(getParentMessageId());
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
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>from</column-name><column-value><![CDATA[");
		sb.append(getFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>to</column-name><column-value><![CDATA[");
		sb.append(getTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>allowOpen</column-name><column-value><![CDATA[");
		sb.append(getAllowOpen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendDate</column-name><column-value><![CDATA[");
		sb.append(getSendDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createBy</column-name><column-value><![CDATA[");
		sb.append(getCreateBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createByUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>draft</column-name><column-value><![CDATA[");
		sb.append(getDraft());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleteStatus</column-name><column-value><![CDATA[");
		sb.append(getDeleteStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>draftStatus</column-name><column-value><![CDATA[");
		sb.append(getDraftStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentMeCopy</column-name><column-value><![CDATA[");
		sb.append(getSentMeCopy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>belongToGroupDetailId</column-name><column-value><![CDATA[");
		sb.append(getBelongToGroupDetailId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _messageId;
	private long _parentMessageId;
	private long _groupId;
	private long _companyId;
	private String _subject;
	private String _content;
	private String _from;
	private String _to;
	private boolean _allowOpen;
	private Date _sendDate;
	private Date _createDate;
	private String _createBy;
	private String _createByUserId;
	private boolean _draft;
	private boolean _deleteStatus;
	private String _draftStatus;
	private boolean _sentMeCopy;
	private long _belongToGroupDetailId;
	private BaseModel<?> _ibMessageRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spinbox.service.ClpSerializer.class;
}