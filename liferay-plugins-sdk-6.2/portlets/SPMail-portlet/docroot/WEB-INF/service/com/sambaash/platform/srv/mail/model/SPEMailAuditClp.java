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
import com.sambaash.platform.srv.mail.service.SPEMailAuditLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPEMailAuditClp extends BaseModelImpl<SPEMailAudit>
	implements SPEMailAudit {
	public SPEMailAuditClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPEMailAudit.class;
	}

	@Override
	public String getModelClassName() {
		return SPEMailAudit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spEMailAudit;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpEMailAudit(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spEMailAudit;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spEMailAudit", getSpEMailAudit());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("sentTo", getSentTo());
		attributes.put("cc", getCc());
		attributes.put("bcc", getBcc());
		attributes.put("category", getCategory());
		attributes.put("subject", getSubject());
		attributes.put("content", getContent());
		attributes.put("sentDate", getSentDate());
		attributes.put("messasgeId", getMessasgeId());
		attributes.put("userId", getUserId());
		attributes.put("orgId", getOrgId());
		attributes.put("processStateId", getProcessStateId());
		attributes.put("nodeId", getNodeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spEMailAudit = (Long)attributes.get("spEMailAudit");

		if (spEMailAudit != null) {
			setSpEMailAudit(spEMailAudit);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String sentTo = (String)attributes.get("sentTo");

		if (sentTo != null) {
			setSentTo(sentTo);
		}

		String cc = (String)attributes.get("cc");

		if (cc != null) {
			setCc(cc);
		}

		String bcc = (String)attributes.get("bcc");

		if (bcc != null) {
			setBcc(bcc);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Date sentDate = (Date)attributes.get("sentDate");

		if (sentDate != null) {
			setSentDate(sentDate);
		}

		String messasgeId = (String)attributes.get("messasgeId");

		if (messasgeId != null) {
			setMessasgeId(messasgeId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long orgId = (Long)attributes.get("orgId");

		if (orgId != null) {
			setOrgId(orgId);
		}

		Long processStateId = (Long)attributes.get("processStateId");

		if (processStateId != null) {
			setProcessStateId(processStateId);
		}

		Long nodeId = (Long)attributes.get("nodeId");

		if (nodeId != null) {
			setNodeId(nodeId);
		}
	}

	@Override
	public long getSpEMailAudit() {
		return _spEMailAudit;
	}

	@Override
	public void setSpEMailAudit(long spEMailAudit) {
		_spEMailAudit = spEMailAudit;

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSpEMailAudit", long.class);

				method.invoke(_speMailAuditRemoteModel, spEMailAudit);
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

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_speMailAuditRemoteModel, groupId);
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

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_speMailAuditRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSentTo() {
		return _sentTo;
	}

	@Override
	public void setSentTo(String sentTo) {
		_sentTo = sentTo;

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSentTo", String.class);

				method.invoke(_speMailAuditRemoteModel, sentTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCc() {
		return _cc;
	}

	@Override
	public void setCc(String cc) {
		_cc = cc;

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCc", String.class);

				method.invoke(_speMailAuditRemoteModel, cc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBcc() {
		return _bcc;
	}

	@Override
	public void setBcc(String bcc) {
		_bcc = bcc;

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setBcc", String.class);

				method.invoke(_speMailAuditRemoteModel, bcc);
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

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_speMailAuditRemoteModel, category);
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

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_speMailAuditRemoteModel, subject);
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

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_speMailAuditRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSentDate() {
		return _sentDate;
	}

	@Override
	public void setSentDate(Date sentDate) {
		_sentDate = sentDate;

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSentDate", Date.class);

				method.invoke(_speMailAuditRemoteModel, sentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessasgeId() {
		return _messasgeId;
	}

	@Override
	public void setMessasgeId(String messasgeId) {
		_messasgeId = messasgeId;

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setMessasgeId", String.class);

				method.invoke(_speMailAuditRemoteModel, messasgeId);
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

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_speMailAuditRemoteModel, userId);
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
	public long getOrgId() {
		return _orgId;
	}

	@Override
	public void setOrgId(long orgId) {
		_orgId = orgId;

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgId", long.class);

				method.invoke(_speMailAuditRemoteModel, orgId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProcessStateId() {
		return _processStateId;
	}

	@Override
	public void setProcessStateId(long processStateId) {
		_processStateId = processStateId;

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessStateId", long.class);

				method.invoke(_speMailAuditRemoteModel, processStateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNodeId() {
		return _nodeId;
	}

	@Override
	public void setNodeId(long nodeId) {
		_nodeId = nodeId;

		if (_speMailAuditRemoteModel != null) {
			try {
				Class<?> clazz = _speMailAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setNodeId", long.class);

				method.invoke(_speMailAuditRemoteModel, nodeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPEMailAuditRemoteModel() {
		return _speMailAuditRemoteModel;
	}

	public void setSPEMailAuditRemoteModel(BaseModel<?> speMailAuditRemoteModel) {
		_speMailAuditRemoteModel = speMailAuditRemoteModel;
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

		Class<?> remoteModelClass = _speMailAuditRemoteModel.getClass();

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

		Object returnValue = method.invoke(_speMailAuditRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPEMailAuditLocalServiceUtil.addSPEMailAudit(this);
		}
		else {
			SPEMailAuditLocalServiceUtil.updateSPEMailAudit(this);
		}
	}

	@Override
	public SPEMailAudit toEscapedModel() {
		return (SPEMailAudit)ProxyUtil.newProxyInstance(SPEMailAudit.class.getClassLoader(),
			new Class[] { SPEMailAudit.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPEMailAuditClp clone = new SPEMailAuditClp();

		clone.setSpEMailAudit(getSpEMailAudit());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setSentTo(getSentTo());
		clone.setCc(getCc());
		clone.setBcc(getBcc());
		clone.setCategory(getCategory());
		clone.setSubject(getSubject());
		clone.setContent(getContent());
		clone.setSentDate(getSentDate());
		clone.setMessasgeId(getMessasgeId());
		clone.setUserId(getUserId());
		clone.setOrgId(getOrgId());
		clone.setProcessStateId(getProcessStateId());
		clone.setNodeId(getNodeId());

		return clone;
	}

	@Override
	public int compareTo(SPEMailAudit speMailAudit) {
		long primaryKey = speMailAudit.getPrimaryKey();

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

		if (!(obj instanceof SPEMailAuditClp)) {
			return false;
		}

		SPEMailAuditClp speMailAudit = (SPEMailAuditClp)obj;

		long primaryKey = speMailAudit.getPrimaryKey();

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

		sb.append("{spEMailAudit=");
		sb.append(getSpEMailAudit());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", sentTo=");
		sb.append(getSentTo());
		sb.append(", cc=");
		sb.append(getCc());
		sb.append(", bcc=");
		sb.append(getBcc());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", sentDate=");
		sb.append(getSentDate());
		sb.append(", messasgeId=");
		sb.append(getMessasgeId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", processStateId=");
		sb.append(getProcessStateId());
		sb.append(", nodeId=");
		sb.append(getNodeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.mail.model.SPEMailAudit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spEMailAudit</column-name><column-value><![CDATA[");
		sb.append(getSpEMailAudit());
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
			"<column><column-name>sentTo</column-name><column-value><![CDATA[");
		sb.append(getSentTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cc</column-name><column-value><![CDATA[");
		sb.append(getCc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bcc</column-name><column-value><![CDATA[");
		sb.append(getBcc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
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
			"<column><column-name>sentDate</column-name><column-value><![CDATA[");
		sb.append(getSentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messasgeId</column-name><column-value><![CDATA[");
		sb.append(getMessasgeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processStateId</column-name><column-value><![CDATA[");
		sb.append(getProcessStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nodeId</column-name><column-value><![CDATA[");
		sb.append(getNodeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spEMailAudit;
	private long _groupId;
	private long _companyId;
	private String _sentTo;
	private String _cc;
	private String _bcc;
	private String _category;
	private String _subject;
	private String _content;
	private Date _sentDate;
	private String _messasgeId;
	private long _userId;
	private String _userUuid;
	private long _orgId;
	private long _processStateId;
	private long _nodeId;
	private BaseModel<?> _speMailAuditRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}