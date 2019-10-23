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

package com.sambaash.platform.srv.spsocialprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileViewAuditLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SocialProfileViewAuditClp extends BaseModelImpl<SocialProfileViewAudit>
	implements SocialProfileViewAudit {
	public SocialProfileViewAuditClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfileViewAudit.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfileViewAudit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _socialProfileViewAuditId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSocialProfileViewAuditId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _socialProfileViewAuditId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("socialProfileViewAuditId", getSocialProfileViewAuditId());
		attributes.put("loggedInUserId", getLoggedInUserId());
		attributes.put("profileUserId", getProfileUserId());
		attributes.put("lastViewDate", getLastViewDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long socialProfileViewAuditId = (Long)attributes.get(
				"socialProfileViewAuditId");

		if (socialProfileViewAuditId != null) {
			setSocialProfileViewAuditId(socialProfileViewAuditId);
		}

		Long loggedInUserId = (Long)attributes.get("loggedInUserId");

		if (loggedInUserId != null) {
			setLoggedInUserId(loggedInUserId);
		}

		Long profileUserId = (Long)attributes.get("profileUserId");

		if (profileUserId != null) {
			setProfileUserId(profileUserId);
		}

		Date lastViewDate = (Date)attributes.get("lastViewDate");

		if (lastViewDate != null) {
			setLastViewDate(lastViewDate);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_socialProfileViewAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileViewAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_socialProfileViewAuditRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSocialProfileViewAuditId() {
		return _socialProfileViewAuditId;
	}

	@Override
	public void setSocialProfileViewAuditId(long socialProfileViewAuditId) {
		_socialProfileViewAuditId = socialProfileViewAuditId;

		if (_socialProfileViewAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileViewAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialProfileViewAuditId",
						long.class);

				method.invoke(_socialProfileViewAuditRemoteModel,
					socialProfileViewAuditId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLoggedInUserId() {
		return _loggedInUserId;
	}

	@Override
	public void setLoggedInUserId(long loggedInUserId) {
		_loggedInUserId = loggedInUserId;

		if (_socialProfileViewAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileViewAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setLoggedInUserId", long.class);

				method.invoke(_socialProfileViewAuditRemoteModel, loggedInUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLoggedInUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getLoggedInUserId(), "uuid",
			_loggedInUserUuid);
	}

	@Override
	public void setLoggedInUserUuid(String loggedInUserUuid) {
		_loggedInUserUuid = loggedInUserUuid;
	}

	@Override
	public long getProfileUserId() {
		return _profileUserId;
	}

	@Override
	public void setProfileUserId(long profileUserId) {
		_profileUserId = profileUserId;

		if (_socialProfileViewAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileViewAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setProfileUserId", long.class);

				method.invoke(_socialProfileViewAuditRemoteModel, profileUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProfileUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getProfileUserId(), "uuid",
			_profileUserUuid);
	}

	@Override
	public void setProfileUserUuid(String profileUserUuid) {
		_profileUserUuid = profileUserUuid;
	}

	@Override
	public Date getLastViewDate() {
		return _lastViewDate;
	}

	@Override
	public void setLastViewDate(Date lastViewDate) {
		_lastViewDate = lastViewDate;

		if (_socialProfileViewAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileViewAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setLastViewDate", Date.class);

				method.invoke(_socialProfileViewAuditRemoteModel, lastViewDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSocialProfileViewAuditRemoteModel() {
		return _socialProfileViewAuditRemoteModel;
	}

	public void setSocialProfileViewAuditRemoteModel(
		BaseModel<?> socialProfileViewAuditRemoteModel) {
		_socialProfileViewAuditRemoteModel = socialProfileViewAuditRemoteModel;
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

		Class<?> remoteModelClass = _socialProfileViewAuditRemoteModel.getClass();

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

		Object returnValue = method.invoke(_socialProfileViewAuditRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SocialProfileViewAuditLocalServiceUtil.addSocialProfileViewAudit(this);
		}
		else {
			SocialProfileViewAuditLocalServiceUtil.updateSocialProfileViewAudit(this);
		}
	}

	@Override
	public SocialProfileViewAudit toEscapedModel() {
		return (SocialProfileViewAudit)ProxyUtil.newProxyInstance(SocialProfileViewAudit.class.getClassLoader(),
			new Class[] { SocialProfileViewAudit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SocialProfileViewAuditClp clone = new SocialProfileViewAuditClp();

		clone.setUuid(getUuid());
		clone.setSocialProfileViewAuditId(getSocialProfileViewAuditId());
		clone.setLoggedInUserId(getLoggedInUserId());
		clone.setProfileUserId(getProfileUserId());
		clone.setLastViewDate(getLastViewDate());

		return clone;
	}

	@Override
	public int compareTo(SocialProfileViewAudit socialProfileViewAudit) {
		long primaryKey = socialProfileViewAudit.getPrimaryKey();

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

		if (!(obj instanceof SocialProfileViewAuditClp)) {
			return false;
		}

		SocialProfileViewAuditClp socialProfileViewAudit = (SocialProfileViewAuditClp)obj;

		long primaryKey = socialProfileViewAudit.getPrimaryKey();

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
		sb.append(", socialProfileViewAuditId=");
		sb.append(getSocialProfileViewAuditId());
		sb.append(", loggedInUserId=");
		sb.append(getLoggedInUserId());
		sb.append(", profileUserId=");
		sb.append(getProfileUserId());
		sb.append(", lastViewDate=");
		sb.append(getLastViewDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialProfileViewAuditId</column-name><column-value><![CDATA[");
		sb.append(getSocialProfileViewAuditId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loggedInUserId</column-name><column-value><![CDATA[");
		sb.append(getLoggedInUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profileUserId</column-name><column-value><![CDATA[");
		sb.append(getProfileUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastViewDate</column-name><column-value><![CDATA[");
		sb.append(getLastViewDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _socialProfileViewAuditId;
	private long _loggedInUserId;
	private String _loggedInUserUuid;
	private long _profileUserId;
	private String _profileUserUuid;
	private Date _lastViewDate;
	private BaseModel<?> _socialProfileViewAuditRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.class;
}