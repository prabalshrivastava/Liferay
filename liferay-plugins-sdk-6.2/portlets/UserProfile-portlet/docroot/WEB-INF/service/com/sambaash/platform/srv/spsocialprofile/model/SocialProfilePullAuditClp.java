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
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfilePullAuditLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePullAuditPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SocialProfilePullAuditClp extends BaseModelImpl<SocialProfilePullAudit>
	implements SocialProfilePullAudit {
	public SocialProfilePullAuditClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfilePullAudit.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfilePullAudit.class.getName();
	}

	@Override
	public SocialProfilePullAuditPK getPrimaryKey() {
		return new SocialProfilePullAuditPK(_userId, _socialNetworkProfileId);
	}

	@Override
	public void setPrimaryKey(SocialProfilePullAuditPK primaryKey) {
		setUserId(primaryKey.userId);
		setSocialNetworkProfileId(primaryKey.socialNetworkProfileId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SocialProfilePullAuditPK(_userId, _socialNetworkProfileId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SocialProfilePullAuditPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("socialNetworkProfileId", getSocialNetworkProfileId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("lastQueriedDate", getLastQueriedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long socialNetworkProfileId = (Long)attributes.get(
				"socialNetworkProfileId");

		if (socialNetworkProfileId != null) {
			setSocialNetworkProfileId(socialNetworkProfileId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date lastQueriedDate = (Date)attributes.get("lastQueriedDate");

		if (lastQueriedDate != null) {
			setLastQueriedDate(lastQueriedDate);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_socialProfilePullAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfilePullAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_socialProfilePullAuditRemoteModel, userId);
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
	public long getSocialNetworkProfileId() {
		return _socialNetworkProfileId;
	}

	@Override
	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_socialNetworkProfileId = socialNetworkProfileId;

		if (_socialProfilePullAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfilePullAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialNetworkProfileId",
						long.class);

				method.invoke(_socialProfilePullAuditRemoteModel,
					socialNetworkProfileId);
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

		if (_socialProfilePullAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfilePullAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_socialProfilePullAuditRemoteModel, companyId);
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

		if (_socialProfilePullAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfilePullAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_socialProfilePullAuditRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastQueriedDate() {
		return _lastQueriedDate;
	}

	@Override
	public void setLastQueriedDate(Date lastQueriedDate) {
		_lastQueriedDate = lastQueriedDate;

		if (_socialProfilePullAuditRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfilePullAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setLastQueriedDate", Date.class);

				method.invoke(_socialProfilePullAuditRemoteModel,
					lastQueriedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSocialProfilePullAuditRemoteModel() {
		return _socialProfilePullAuditRemoteModel;
	}

	public void setSocialProfilePullAuditRemoteModel(
		BaseModel<?> socialProfilePullAuditRemoteModel) {
		_socialProfilePullAuditRemoteModel = socialProfilePullAuditRemoteModel;
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

		Class<?> remoteModelClass = _socialProfilePullAuditRemoteModel.getClass();

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

		Object returnValue = method.invoke(_socialProfilePullAuditRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SocialProfilePullAuditLocalServiceUtil.addSocialProfilePullAudit(this);
		}
		else {
			SocialProfilePullAuditLocalServiceUtil.updateSocialProfilePullAudit(this);
		}
	}

	@Override
	public SocialProfilePullAudit toEscapedModel() {
		return (SocialProfilePullAudit)ProxyUtil.newProxyInstance(SocialProfilePullAudit.class.getClassLoader(),
			new Class[] { SocialProfilePullAudit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SocialProfilePullAuditClp clone = new SocialProfilePullAuditClp();

		clone.setUserId(getUserId());
		clone.setSocialNetworkProfileId(getSocialNetworkProfileId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setLastQueriedDate(getLastQueriedDate());

		return clone;
	}

	@Override
	public int compareTo(SocialProfilePullAudit socialProfilePullAudit) {
		SocialProfilePullAuditPK primaryKey = socialProfilePullAudit.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialProfilePullAuditClp)) {
			return false;
		}

		SocialProfilePullAuditClp socialProfilePullAudit = (SocialProfilePullAuditClp)obj;

		SocialProfilePullAuditPK primaryKey = socialProfilePullAudit.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", socialNetworkProfileId=");
		sb.append(getSocialNetworkProfileId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", lastQueriedDate=");
		sb.append(getLastQueriedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialNetworkProfileId</column-name><column-value><![CDATA[");
		sb.append(getSocialNetworkProfileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastQueriedDate</column-name><column-value><![CDATA[");
		sb.append(getLastQueriedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private long _socialNetworkProfileId;
	private long _companyId;
	private Date _createDate;
	private Date _lastQueriedDate;
	private BaseModel<?> _socialProfilePullAuditRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.class;
}