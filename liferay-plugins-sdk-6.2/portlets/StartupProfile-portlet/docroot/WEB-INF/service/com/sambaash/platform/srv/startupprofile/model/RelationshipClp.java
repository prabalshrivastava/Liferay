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
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.RelationshipLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class RelationshipClp extends BaseModelImpl<Relationship>
	implements Relationship {
	public RelationshipClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Relationship.class;
	}

	@Override
	public String getModelClassName() {
		return Relationship.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _relationshipId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRelationshipId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _relationshipId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("relationshipId", getRelationshipId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("refId", getRefId());
		attributes.put("refTypeId", getRefTypeId());
		attributes.put("relation", getRelation());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long relationshipId = (Long)attributes.get("relationshipId");

		if (relationshipId != null) {
			setRelationshipId(relationshipId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long refId = (Long)attributes.get("refId");

		if (refId != null) {
			setRefId(refId);
		}

		Long refTypeId = (Long)attributes.get("refTypeId");

		if (refTypeId != null) {
			setRefTypeId(refTypeId);
		}

		Long relation = (Long)attributes.get("relation");

		if (relation != null) {
			setRelation(relation);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public long getRelationshipId() {
		return _relationshipId;
	}

	@Override
	public void setRelationshipId(long relationshipId) {
		_relationshipId = relationshipId;

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setRelationshipId", long.class);

				method.invoke(_relationshipRemoteModel, relationshipId);
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

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_relationshipRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRefId() {
		return _refId;
	}

	@Override
	public void setRefId(long refId) {
		_refId = refId;

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setRefId", long.class);

				method.invoke(_relationshipRemoteModel, refId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRefTypeId() {
		return _refTypeId;
	}

	@Override
	public void setRefTypeId(long refTypeId) {
		_refTypeId = refTypeId;

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setRefTypeId", long.class);

				method.invoke(_relationshipRemoteModel, refTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRelation() {
		return _relation;
	}

	@Override
	public void setRelation(long relation) {
		_relation = relation;

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setRelation", long.class);

				method.invoke(_relationshipRemoteModel, relation);
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

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_relationshipRemoteModel, groupId);
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

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_relationshipRemoteModel, companyId);
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

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_relationshipRemoteModel, userId);
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

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_relationshipRemoteModel, userName);
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

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_relationshipRemoteModel, createDate);
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

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_relationshipRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_relationshipRemoteModel != null) {
			try {
				Class<?> clazz = _relationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_relationshipRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRelationshipRemoteModel() {
		return _relationshipRemoteModel;
	}

	public void setRelationshipRemoteModel(BaseModel<?> relationshipRemoteModel) {
		_relationshipRemoteModel = relationshipRemoteModel;
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

		Class<?> remoteModelClass = _relationshipRemoteModel.getClass();

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

		Object returnValue = method.invoke(_relationshipRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RelationshipLocalServiceUtil.addRelationship(this);
		}
		else {
			RelationshipLocalServiceUtil.updateRelationship(this);
		}
	}

	@Override
	public Relationship toEscapedModel() {
		return (Relationship)ProxyUtil.newProxyInstance(Relationship.class.getClassLoader(),
			new Class[] { Relationship.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RelationshipClp clone = new RelationshipClp();

		clone.setRelationshipId(getRelationshipId());
		clone.setOrganizationId(getOrganizationId());
		clone.setRefId(getRefId());
		clone.setRefTypeId(getRefTypeId());
		clone.setRelation(getRelation());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(Relationship relationship) {
		long primaryKey = relationship.getPrimaryKey();

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

		if (!(obj instanceof RelationshipClp)) {
			return false;
		}

		RelationshipClp relationship = (RelationshipClp)obj;

		long primaryKey = relationship.getPrimaryKey();

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

		sb.append("{relationshipId=");
		sb.append(getRelationshipId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", refId=");
		sb.append(getRefId());
		sb.append(", refTypeId=");
		sb.append(getRefTypeId());
		sb.append(", relation=");
		sb.append(getRelation());
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
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.startupprofile.model.Relationship");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>relationshipId</column-name><column-value><![CDATA[");
		sb.append(getRelationshipId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>refId</column-name><column-value><![CDATA[");
		sb.append(getRefId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>refTypeId</column-name><column-value><![CDATA[");
		sb.append(getRefTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>relation</column-name><column-value><![CDATA[");
		sb.append(getRelation());
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
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _relationshipId;
	private long _organizationId;
	private long _refId;
	private long _refTypeId;
	private long _relation;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private BaseModel<?> _relationshipRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}