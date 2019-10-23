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

package com.sambaash.platform.srv.startupprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.startupprofile.service.ATODocumentLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class ATODocumentClp extends BaseModelImpl<ATODocument>
	implements ATODocument {
	public ATODocumentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ATODocument.class;
	}

	@Override
	public String getModelClassName() {
		return ATODocument.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _atoDocumentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAtoDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _atoDocumentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("atoDocumentId", getAtoDocumentId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("documentType", getDocumentType());
		attributes.put("documentFileId", getDocumentFileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long atoDocumentId = (Long)attributes.get("atoDocumentId");

		if (atoDocumentId != null) {
			setAtoDocumentId(atoDocumentId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String documentType = (String)attributes.get("documentType");

		if (documentType != null) {
			setDocumentType(documentType);
		}

		String documentFileId = (String)attributes.get("documentFileId");

		if (documentFileId != null) {
			setDocumentFileId(documentFileId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_atoDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _atoDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_atoDocumentRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAtoDocumentId() {
		return _atoDocumentId;
	}

	@Override
	public void setAtoDocumentId(long atoDocumentId) {
		_atoDocumentId = atoDocumentId;

		if (_atoDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _atoDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setAtoDocumentId", long.class);

				method.invoke(_atoDocumentRemoteModel, atoDocumentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_atoDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _atoDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_atoDocumentRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDocumentType() {
		return _documentType;
	}

	@Override
	public void setDocumentType(String documentType) {
		_documentType = documentType;

		if (_atoDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _atoDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDocumentType", String.class);

				method.invoke(_atoDocumentRemoteModel, documentType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDocumentFileId() {
		return _documentFileId;
	}

	@Override
	public void setDocumentFileId(String documentFileId) {
		_documentFileId = documentFileId;

		if (_atoDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _atoDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDocumentFileId",
						String.class);

				method.invoke(_atoDocumentRemoteModel, documentFileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getATODocumentRemoteModel() {
		return _atoDocumentRemoteModel;
	}

	public void setATODocumentRemoteModel(BaseModel<?> atoDocumentRemoteModel) {
		_atoDocumentRemoteModel = atoDocumentRemoteModel;
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

		Class<?> remoteModelClass = _atoDocumentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_atoDocumentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ATODocumentLocalServiceUtil.addATODocument(this);
		}
		else {
			ATODocumentLocalServiceUtil.updateATODocument(this);
		}
	}

	@Override
	public ATODocument toEscapedModel() {
		return (ATODocument)ProxyUtil.newProxyInstance(ATODocument.class.getClassLoader(),
			new Class[] { ATODocument.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ATODocumentClp clone = new ATODocumentClp();

		clone.setUuid(getUuid());
		clone.setAtoDocumentId(getAtoDocumentId());
		clone.setOrganizationId(getOrganizationId());
		clone.setDocumentType(getDocumentType());
		clone.setDocumentFileId(getDocumentFileId());

		return clone;
	}

	@Override
	public int compareTo(ATODocument atoDocument) {
		long primaryKey = atoDocument.getPrimaryKey();

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

		if (!(obj instanceof ATODocumentClp)) {
			return false;
		}

		ATODocumentClp atoDocument = (ATODocumentClp)obj;

		long primaryKey = atoDocument.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", atoDocumentId=");
		sb.append(getAtoDocumentId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", documentType=");
		sb.append(getDocumentType());
		sb.append(", documentFileId=");
		sb.append(getDocumentFileId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.startupprofile.model.ATODocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>atoDocumentId</column-name><column-value><![CDATA[");
		sb.append(getAtoDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentType</column-name><column-value><![CDATA[");
		sb.append(getDocumentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentFileId</column-name><column-value><![CDATA[");
		sb.append(getDocumentFileId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _atoDocumentId;
	private long _organizationId;
	private String _documentType;
	private String _documentFileId;
	private BaseModel<?> _atoDocumentRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}