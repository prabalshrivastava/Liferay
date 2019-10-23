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

package com.sambaash.platform.srv.sprating.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.sprating.service.ClpSerializer;
import com.sambaash.platform.srv.sprating.service.RatingAttrLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class RatingAttrClp extends BaseModelImpl<RatingAttr>
	implements RatingAttr {
	public RatingAttrClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RatingAttr.class;
	}

	@Override
	public String getModelClassName() {
		return RatingAttr.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spRatingAttrId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpRatingAttrId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spRatingAttrId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spRatingAttrId", getSpRatingAttrId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ratingComponentId", getRatingComponentId());
		attributes.put("name", getName());
		attributes.put("weight", getWeight());
		attributes.put("visible", getVisible());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spRatingAttrId = (Long)attributes.get("spRatingAttrId");

		if (spRatingAttrId != null) {
			setSpRatingAttrId(spRatingAttrId);
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

		Long ratingComponentId = (Long)attributes.get("ratingComponentId");

		if (ratingComponentId != null) {
			setRatingComponentId(ratingComponentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Boolean visible = (Boolean)attributes.get("visible");

		if (visible != null) {
			setVisible(visible);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_ratingAttrRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpRatingAttrId() {
		return _spRatingAttrId;
	}

	@Override
	public void setSpRatingAttrId(long spRatingAttrId) {
		_spRatingAttrId = spRatingAttrId;

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setSpRatingAttrId", long.class);

				method.invoke(_ratingAttrRemoteModel, spRatingAttrId);
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

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_ratingAttrRemoteModel, groupId);
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

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_ratingAttrRemoteModel, companyId);
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

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_ratingAttrRemoteModel, userId);
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

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_ratingAttrRemoteModel, userName);
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

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_ratingAttrRemoteModel, createDate);
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

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_ratingAttrRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRatingComponentId() {
		return _ratingComponentId;
	}

	@Override
	public void setRatingComponentId(long ratingComponentId) {
		_ratingComponentId = ratingComponentId;

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setRatingComponentId",
						long.class);

				method.invoke(_ratingAttrRemoteModel, ratingComponentId);
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

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_ratingAttrRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getWeight() {
		return _weight;
	}

	@Override
	public void setWeight(double weight) {
		_weight = weight;

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setWeight", double.class);

				method.invoke(_ratingAttrRemoteModel, weight);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getVisible() {
		return _visible;
	}

	@Override
	public boolean isVisible() {
		return _visible;
	}

	@Override
	public void setVisible(boolean visible) {
		_visible = visible;

		if (_ratingAttrRemoteModel != null) {
			try {
				Class<?> clazz = _ratingAttrRemoteModel.getClass();

				Method method = clazz.getMethod("setVisible", boolean.class);

				method.invoke(_ratingAttrRemoteModel, visible);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RatingAttr.class.getName()));
	}

	public BaseModel<?> getRatingAttrRemoteModel() {
		return _ratingAttrRemoteModel;
	}

	public void setRatingAttrRemoteModel(BaseModel<?> ratingAttrRemoteModel) {
		_ratingAttrRemoteModel = ratingAttrRemoteModel;
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

		Class<?> remoteModelClass = _ratingAttrRemoteModel.getClass();

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

		Object returnValue = method.invoke(_ratingAttrRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RatingAttrLocalServiceUtil.addRatingAttr(this);
		}
		else {
			RatingAttrLocalServiceUtil.updateRatingAttr(this);
		}
	}

	@Override
	public RatingAttr toEscapedModel() {
		return (RatingAttr)ProxyUtil.newProxyInstance(RatingAttr.class.getClassLoader(),
			new Class[] { RatingAttr.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RatingAttrClp clone = new RatingAttrClp();

		clone.setUuid(getUuid());
		clone.setSpRatingAttrId(getSpRatingAttrId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRatingComponentId(getRatingComponentId());
		clone.setName(getName());
		clone.setWeight(getWeight());
		clone.setVisible(getVisible());

		return clone;
	}

	@Override
	public int compareTo(RatingAttr ratingAttr) {
		int value = 0;

		value = getName().compareTo(ratingAttr.getName());

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

		if (!(obj instanceof RatingAttrClp)) {
			return false;
		}

		RatingAttrClp ratingAttr = (RatingAttrClp)obj;

		long primaryKey = ratingAttr.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spRatingAttrId=");
		sb.append(getSpRatingAttrId());
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
		sb.append(", ratingComponentId=");
		sb.append(getRatingComponentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append(", visible=");
		sb.append(getVisible());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.sprating.model.RatingAttr");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spRatingAttrId</column-name><column-value><![CDATA[");
		sb.append(getSpRatingAttrId());
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
			"<column><column-name>ratingComponentId</column-name><column-value><![CDATA[");
		sb.append(getRatingComponentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visible</column-name><column-value><![CDATA[");
		sb.append(getVisible());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spRatingAttrId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _ratingComponentId;
	private String _name;
	private double _weight;
	private boolean _visible;
	private BaseModel<?> _ratingAttrRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.sprating.service.ClpSerializer.class;
}