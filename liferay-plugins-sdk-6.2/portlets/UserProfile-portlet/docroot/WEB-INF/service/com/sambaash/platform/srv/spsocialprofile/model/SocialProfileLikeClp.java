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

import com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLikeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SocialProfileLikeClp extends BaseModelImpl<SocialProfileLike>
	implements SocialProfileLike {
	public SocialProfileLikeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfileLike.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfileLike.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _socialProfileLikeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSocialProfileLikeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _socialProfileLikeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("socialProfileLikeId", getSocialProfileLikeId());
		attributes.put("socialNetworkProfileId", getSocialNetworkProfileId());
		attributes.put("name", getName());
		attributes.put("category", getCategory());
		attributes.put("socialNetworkLikeId", getSocialNetworkLikeId());
		attributes.put("socialNetworkType", getSocialNetworkType());
		attributes.put("socialNetworkCreateDate", getSocialNetworkCreateDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long socialProfileLikeId = (Long)attributes.get("socialProfileLikeId");

		if (socialProfileLikeId != null) {
			setSocialProfileLikeId(socialProfileLikeId);
		}

		Long socialNetworkProfileId = (Long)attributes.get(
				"socialNetworkProfileId");

		if (socialNetworkProfileId != null) {
			setSocialNetworkProfileId(socialNetworkProfileId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long socialNetworkLikeId = (Long)attributes.get("socialNetworkLikeId");

		if (socialNetworkLikeId != null) {
			setSocialNetworkLikeId(socialNetworkLikeId);
		}

		Integer socialNetworkType = (Integer)attributes.get("socialNetworkType");

		if (socialNetworkType != null) {
			setSocialNetworkType(socialNetworkType);
		}

		Date socialNetworkCreateDate = (Date)attributes.get(
				"socialNetworkCreateDate");

		if (socialNetworkCreateDate != null) {
			setSocialNetworkCreateDate(socialNetworkCreateDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getSocialProfileLikeId() {
		return _socialProfileLikeId;
	}

	@Override
	public void setSocialProfileLikeId(long socialProfileLikeId) {
		_socialProfileLikeId = socialProfileLikeId;

		if (_socialProfileLikeRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileLikeRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialProfileLikeId",
						long.class);

				method.invoke(_socialProfileLikeRemoteModel, socialProfileLikeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSocialNetworkProfileId() {
		return _socialNetworkProfileId;
	}

	@Override
	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_socialNetworkProfileId = socialNetworkProfileId;

		if (_socialProfileLikeRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileLikeRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialNetworkProfileId",
						long.class);

				method.invoke(_socialProfileLikeRemoteModel,
					socialNetworkProfileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_socialProfileLikeRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileLikeRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_socialProfileLikeRemoteModel, name);
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

		if (_socialProfileLikeRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileLikeRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_socialProfileLikeRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSocialNetworkLikeId() {
		return _socialNetworkLikeId;
	}

	@Override
	public void setSocialNetworkLikeId(long socialNetworkLikeId) {
		_socialNetworkLikeId = socialNetworkLikeId;

		if (_socialProfileLikeRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileLikeRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialNetworkLikeId",
						long.class);

				method.invoke(_socialProfileLikeRemoteModel, socialNetworkLikeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSocialNetworkType() {
		return _socialNetworkType;
	}

	@Override
	public void setSocialNetworkType(int socialNetworkType) {
		_socialNetworkType = socialNetworkType;

		if (_socialProfileLikeRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileLikeRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialNetworkType",
						int.class);

				method.invoke(_socialProfileLikeRemoteModel, socialNetworkType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSocialNetworkCreateDate() {
		return _socialNetworkCreateDate;
	}

	@Override
	public void setSocialNetworkCreateDate(Date socialNetworkCreateDate) {
		_socialNetworkCreateDate = socialNetworkCreateDate;

		if (_socialProfileLikeRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileLikeRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialNetworkCreateDate",
						Date.class);

				method.invoke(_socialProfileLikeRemoteModel,
					socialNetworkCreateDate);
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

		if (_socialProfileLikeRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileLikeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_socialProfileLikeRemoteModel, createDate);
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

		if (_socialProfileLikeRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileLikeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_socialProfileLikeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSocialProfileLikeRemoteModel() {
		return _socialProfileLikeRemoteModel;
	}

	public void setSocialProfileLikeRemoteModel(
		BaseModel<?> socialProfileLikeRemoteModel) {
		_socialProfileLikeRemoteModel = socialProfileLikeRemoteModel;
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

		Class<?> remoteModelClass = _socialProfileLikeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_socialProfileLikeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SocialProfileLikeLocalServiceUtil.addSocialProfileLike(this);
		}
		else {
			SocialProfileLikeLocalServiceUtil.updateSocialProfileLike(this);
		}
	}

	@Override
	public SocialProfileLike toEscapedModel() {
		return (SocialProfileLike)ProxyUtil.newProxyInstance(SocialProfileLike.class.getClassLoader(),
			new Class[] { SocialProfileLike.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SocialProfileLikeClp clone = new SocialProfileLikeClp();

		clone.setSocialProfileLikeId(getSocialProfileLikeId());
		clone.setSocialNetworkProfileId(getSocialNetworkProfileId());
		clone.setName(getName());
		clone.setCategory(getCategory());
		clone.setSocialNetworkLikeId(getSocialNetworkLikeId());
		clone.setSocialNetworkType(getSocialNetworkType());
		clone.setSocialNetworkCreateDate(getSocialNetworkCreateDate());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SocialProfileLike socialProfileLike) {
		long primaryKey = socialProfileLike.getPrimaryKey();

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

		if (!(obj instanceof SocialProfileLikeClp)) {
			return false;
		}

		SocialProfileLikeClp socialProfileLike = (SocialProfileLikeClp)obj;

		long primaryKey = socialProfileLike.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{socialProfileLikeId=");
		sb.append(getSocialProfileLikeId());
		sb.append(", socialNetworkProfileId=");
		sb.append(getSocialNetworkProfileId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", socialNetworkLikeId=");
		sb.append(getSocialNetworkLikeId());
		sb.append(", socialNetworkType=");
		sb.append(getSocialNetworkType());
		sb.append(", socialNetworkCreateDate=");
		sb.append(getSocialNetworkCreateDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>socialProfileLikeId</column-name><column-value><![CDATA[");
		sb.append(getSocialProfileLikeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialNetworkProfileId</column-name><column-value><![CDATA[");
		sb.append(getSocialNetworkProfileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialNetworkLikeId</column-name><column-value><![CDATA[");
		sb.append(getSocialNetworkLikeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialNetworkType</column-name><column-value><![CDATA[");
		sb.append(getSocialNetworkType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialNetworkCreateDate</column-name><column-value><![CDATA[");
		sb.append(getSocialNetworkCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _socialProfileLikeId;
	private long _socialNetworkProfileId;
	private String _name;
	private String _category;
	private long _socialNetworkLikeId;
	private int _socialNetworkType;
	private Date _socialNetworkCreateDate;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _socialProfileLikeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.class;
}