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

import com.sambaash.platform.srv.mail.service.ClpSerializer;
import com.sambaash.platform.srv.mail.service.SPMailTemplateAttachmentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPMailTemplateAttachmentClp extends BaseModelImpl<SPMailTemplateAttachment>
	implements SPMailTemplateAttachment {
	public SPMailTemplateAttachmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailTemplateAttachment.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailTemplateAttachment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spTemplateAttachmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpTemplateAttachmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spTemplateAttachmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spTemplateAttachmentId", getSpTemplateAttachmentId());
		attributes.put("templateId", getTemplateId());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spTemplateAttachmentId = (Long)attributes.get(
				"spTemplateAttachmentId");

		if (spTemplateAttachmentId != null) {
			setSpTemplateAttachmentId(spTemplateAttachmentId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	@Override
	public long getSpTemplateAttachmentId() {
		return _spTemplateAttachmentId;
	}

	@Override
	public void setSpTemplateAttachmentId(long spTemplateAttachmentId) {
		_spTemplateAttachmentId = spTemplateAttachmentId;

		if (_spMailTemplateAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setSpTemplateAttachmentId",
						long.class);

				method.invoke(_spMailTemplateAttachmentRemoteModel,
					spTemplateAttachmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_templateId = templateId;

		if (_spMailTemplateAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateId", long.class);

				method.invoke(_spMailTemplateAttachmentRemoteModel, templateId);
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

		if (_spMailTemplateAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpId", long.class);

				method.invoke(_spMailTemplateAttachmentRemoteModel, rsvpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_spMailTemplateAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _spMailTemplateAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", long.class);

				method.invoke(_spMailTemplateAttachmentRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPMailTemplateAttachmentRemoteModel() {
		return _spMailTemplateAttachmentRemoteModel;
	}

	public void setSPMailTemplateAttachmentRemoteModel(
		BaseModel<?> spMailTemplateAttachmentRemoteModel) {
		_spMailTemplateAttachmentRemoteModel = spMailTemplateAttachmentRemoteModel;
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

		Class<?> remoteModelClass = _spMailTemplateAttachmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spMailTemplateAttachmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailTemplateAttachmentLocalServiceUtil.addSPMailTemplateAttachment(this);
		}
		else {
			SPMailTemplateAttachmentLocalServiceUtil.updateSPMailTemplateAttachment(this);
		}
	}

	@Override
	public SPMailTemplateAttachment toEscapedModel() {
		return (SPMailTemplateAttachment)ProxyUtil.newProxyInstance(SPMailTemplateAttachment.class.getClassLoader(),
			new Class[] { SPMailTemplateAttachment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPMailTemplateAttachmentClp clone = new SPMailTemplateAttachmentClp();

		clone.setSpTemplateAttachmentId(getSpTemplateAttachmentId());
		clone.setTemplateId(getTemplateId());
		clone.setRsvpId(getRsvpId());
		clone.setFileEntryId(getFileEntryId());

		return clone;
	}

	@Override
	public int compareTo(SPMailTemplateAttachment spMailTemplateAttachment) {
		long primaryKey = spMailTemplateAttachment.getPrimaryKey();

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

		if (!(obj instanceof SPMailTemplateAttachmentClp)) {
			return false;
		}

		SPMailTemplateAttachmentClp spMailTemplateAttachment = (SPMailTemplateAttachmentClp)obj;

		long primaryKey = spMailTemplateAttachment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{spTemplateAttachmentId=");
		sb.append(getSpTemplateAttachmentId());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", rsvpId=");
		sb.append(getRsvpId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spTemplateAttachmentId</column-name><column-value><![CDATA[");
		sb.append(getSpTemplateAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpId</column-name><column-value><![CDATA[");
		sb.append(getRsvpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spTemplateAttachmentId;
	private long _templateId;
	private long _rsvpId;
	private long _fileEntryId;
	private BaseModel<?> _spMailTemplateAttachmentRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}