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
import com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPMailLinkTrackingClp extends BaseModelImpl<SPMailLinkTracking>
	implements SPMailLinkTracking {
	public SPMailLinkTrackingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailLinkTracking.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailLinkTracking.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spMailLinkTrackingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpMailLinkTrackingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spMailLinkTrackingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailLinkTrackingId", getSpMailLinkTrackingId());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("spMailCampaignEDMId", getSpMailCampaignEDMId());
		attributes.put("spMailCampaignSubscribersId",
			getSpMailCampaignSubscribersId());
		attributes.put("label", getLabel());
		attributes.put("link", getLink());
		attributes.put("encryptedlink", getEncryptedlink());
		attributes.put("status", getStatus());
		attributes.put("openedDate", getOpenedDate());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailLinkTrackingId = (Long)attributes.get("spMailLinkTrackingId");

		if (spMailLinkTrackingId != null) {
			setSpMailLinkTrackingId(spMailLinkTrackingId);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		Long spMailCampaignEDMId = (Long)attributes.get("spMailCampaignEDMId");

		if (spMailCampaignEDMId != null) {
			setSpMailCampaignEDMId(spMailCampaignEDMId);
		}

		Long spMailCampaignSubscribersId = (Long)attributes.get(
				"spMailCampaignSubscribersId");

		if (spMailCampaignSubscribersId != null) {
			setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String encryptedlink = (String)attributes.get("encryptedlink");

		if (encryptedlink != null) {
			setEncryptedlink(encryptedlink);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date openedDate = (Date)attributes.get("openedDate");

		if (openedDate != null) {
			setOpenedDate(openedDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getSpMailLinkTrackingId() {
		return _spMailLinkTrackingId;
	}

	@Override
	public void setSpMailLinkTrackingId(long spMailLinkTrackingId) {
		_spMailLinkTrackingId = spMailLinkTrackingId;

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailLinkTrackingId",
						long.class);

				method.invoke(_spMailLinkTrackingRemoteModel,
					spMailLinkTrackingId);
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

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignId",
						long.class);

				method.invoke(_spMailLinkTrackingRemoteModel, spMailCampaignId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpMailCampaignEDMId() {
		return _spMailCampaignEDMId;
	}

	@Override
	public void setSpMailCampaignEDMId(long spMailCampaignEDMId) {
		_spMailCampaignEDMId = spMailCampaignEDMId;

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignEDMId",
						long.class);

				method.invoke(_spMailLinkTrackingRemoteModel,
					spMailCampaignEDMId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpMailCampaignSubscribersId() {
		return _spMailCampaignSubscribersId;
	}

	@Override
	public void setSpMailCampaignSubscribersId(long spMailCampaignSubscribersId) {
		_spMailCampaignSubscribersId = spMailCampaignSubscribersId;

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpMailCampaignSubscribersId",
						long.class);

				method.invoke(_spMailLinkTrackingRemoteModel,
					spMailCampaignSubscribersId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLabel() {
		return _label;
	}

	@Override
	public void setLabel(String label) {
		_label = label;

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setLabel", String.class);

				method.invoke(_spMailLinkTrackingRemoteModel, label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLink() {
		return _link;
	}

	@Override
	public void setLink(String link) {
		_link = link;

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setLink", String.class);

				method.invoke(_spMailLinkTrackingRemoteModel, link);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEncryptedlink() {
		return _encryptedlink;
	}

	@Override
	public void setEncryptedlink(String encryptedlink) {
		_encryptedlink = encryptedlink;

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setEncryptedlink", String.class);

				method.invoke(_spMailLinkTrackingRemoteModel, encryptedlink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_spMailLinkTrackingRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getOpenedDate() {
		return _openedDate;
	}

	@Override
	public void setOpenedDate(Date openedDate) {
		_openedDate = openedDate;

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setOpenedDate", Date.class);

				method.invoke(_spMailLinkTrackingRemoteModel, openedDate);
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

		if (_spMailLinkTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _spMailLinkTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spMailLinkTrackingRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPMailLinkTrackingRemoteModel() {
		return _spMailLinkTrackingRemoteModel;
	}

	public void setSPMailLinkTrackingRemoteModel(
		BaseModel<?> spMailLinkTrackingRemoteModel) {
		_spMailLinkTrackingRemoteModel = spMailLinkTrackingRemoteModel;
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

		Class<?> remoteModelClass = _spMailLinkTrackingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spMailLinkTrackingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPMailLinkTrackingLocalServiceUtil.addSPMailLinkTracking(this);
		}
		else {
			SPMailLinkTrackingLocalServiceUtil.updateSPMailLinkTracking(this);
		}
	}

	@Override
	public SPMailLinkTracking toEscapedModel() {
		return (SPMailLinkTracking)ProxyUtil.newProxyInstance(SPMailLinkTracking.class.getClassLoader(),
			new Class[] { SPMailLinkTracking.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPMailLinkTrackingClp clone = new SPMailLinkTrackingClp();

		clone.setSpMailLinkTrackingId(getSpMailLinkTrackingId());
		clone.setSpMailCampaignId(getSpMailCampaignId());
		clone.setSpMailCampaignEDMId(getSpMailCampaignEDMId());
		clone.setSpMailCampaignSubscribersId(getSpMailCampaignSubscribersId());
		clone.setLabel(getLabel());
		clone.setLink(getLink());
		clone.setEncryptedlink(getEncryptedlink());
		clone.setStatus(getStatus());
		clone.setOpenedDate(getOpenedDate());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(SPMailLinkTracking spMailLinkTracking) {
		long primaryKey = spMailLinkTracking.getPrimaryKey();

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

		if (!(obj instanceof SPMailLinkTrackingClp)) {
			return false;
		}

		SPMailLinkTrackingClp spMailLinkTracking = (SPMailLinkTrackingClp)obj;

		long primaryKey = spMailLinkTracking.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{spMailLinkTrackingId=");
		sb.append(getSpMailLinkTrackingId());
		sb.append(", spMailCampaignId=");
		sb.append(getSpMailCampaignId());
		sb.append(", spMailCampaignEDMId=");
		sb.append(getSpMailCampaignEDMId());
		sb.append(", spMailCampaignSubscribersId=");
		sb.append(getSpMailCampaignSubscribersId());
		sb.append(", label=");
		sb.append(getLabel());
		sb.append(", link=");
		sb.append(getLink());
		sb.append(", encryptedlink=");
		sb.append(getEncryptedlink());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", openedDate=");
		sb.append(getOpenedDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.mail.model.SPMailLinkTracking");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spMailLinkTrackingId</column-name><column-value><![CDATA[");
		sb.append(getSpMailLinkTrackingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailCampaignId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailCampaignEDMId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignEDMId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spMailCampaignSubscribersId</column-name><column-value><![CDATA[");
		sb.append(getSpMailCampaignSubscribersId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>label</column-name><column-value><![CDATA[");
		sb.append(getLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>link</column-name><column-value><![CDATA[");
		sb.append(getLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>encryptedlink</column-name><column-value><![CDATA[");
		sb.append(getEncryptedlink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openedDate</column-name><column-value><![CDATA[");
		sb.append(getOpenedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spMailLinkTrackingId;
	private long _spMailCampaignId;
	private long _spMailCampaignEDMId;
	private long _spMailCampaignSubscribersId;
	private String _label;
	private String _link;
	private String _encryptedlink;
	private boolean _status;
	private Date _openedDate;
	private Date _createDate;
	private BaseModel<?> _spMailLinkTrackingRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.mail.service.ClpSerializer.class;
}