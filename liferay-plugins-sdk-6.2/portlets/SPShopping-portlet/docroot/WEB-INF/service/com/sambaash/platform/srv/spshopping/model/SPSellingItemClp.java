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

package com.sambaash.platform.srv.spshopping.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spshopping.service.ClpSerializer;
import com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPSellingItemClp extends BaseModelImpl<SPSellingItem>
	implements SPSellingItem {
	public SPSellingItemClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPSellingItem.class;
	}

	@Override
	public String getModelClassName() {
		return SPSellingItem.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spSellingItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpSellingItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spSellingItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spSellingItemId", getSpSellingItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("itemCode", getItemCode());
		attributes.put("entityClassPk", getEntityClassPk());
		attributes.put("entityClassNameId", getEntityClassNameId());
		attributes.put("entityClassName", getEntityClassName());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("longDescription", getLongDescription());
		attributes.put("active", getActive());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spSellingItemId = (Long)attributes.get("spSellingItemId");

		if (spSellingItemId != null) {
			setSpSellingItemId(spSellingItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String itemCode = (String)attributes.get("itemCode");

		if (itemCode != null) {
			setItemCode(itemCode);
		}

		Long entityClassPk = (Long)attributes.get("entityClassPk");

		if (entityClassPk != null) {
			setEntityClassPk(entityClassPk);
		}

		Long entityClassNameId = (Long)attributes.get("entityClassNameId");

		if (entityClassNameId != null) {
			setEntityClassNameId(entityClassNameId);
		}

		String entityClassName = (String)attributes.get("entityClassName");

		if (entityClassName != null) {
			setEntityClassName(entityClassName);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String longDescription = (String)attributes.get("longDescription");

		if (longDescription != null) {
			setLongDescription(longDescription);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
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
	}

	@Override
	public long getSpSellingItemId() {
		return _spSellingItemId;
	}

	@Override
	public void setSpSellingItemId(long spSellingItemId) {
		_spSellingItemId = spSellingItemId;

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSpSellingItemId", long.class);

				method.invoke(_spSellingItemRemoteModel, spSellingItemId);
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

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spSellingItemRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_spSellingItemRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemCode() {
		return _itemCode;
	}

	@Override
	public void setItemCode(String itemCode) {
		_itemCode = itemCode;

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCode", String.class);

				method.invoke(_spSellingItemRemoteModel, itemCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityClassPk() {
		return _entityClassPk;
	}

	@Override
	public void setEntityClassPk(long entityClassPk) {
		_entityClassPk = entityClassPk;

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassPk", long.class);

				method.invoke(_spSellingItemRemoteModel, entityClassPk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityClassNameId() {
		return _entityClassNameId;
	}

	@Override
	public void setEntityClassNameId(long entityClassNameId) {
		_entityClassNameId = entityClassNameId;

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassNameId",
						long.class);

				method.invoke(_spSellingItemRemoteModel, entityClassNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntityClassName() {
		return _entityClassName;
	}

	@Override
	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassName",
						String.class);

				method.invoke(_spSellingItemRemoteModel, entityClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortDescription() {
		return _shortDescription;
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setShortDescription",
						String.class);

				method.invoke(_spSellingItemRemoteModel, shortDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongDescription() {
		return _longDescription;
	}

	@Override
	public void setLongDescription(String longDescription) {
		_longDescription = longDescription;

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLongDescription",
						String.class);

				method.invoke(_spSellingItemRemoteModel, longDescription);
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

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_spSellingItemRemoteModel, active);
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

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spSellingItemRemoteModel, companyId);
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

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spSellingItemRemoteModel, userId);
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

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spSellingItemRemoteModel, userName);
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

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spSellingItemRemoteModel, createDate);
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

		if (_spSellingItemRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spSellingItemRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPSellingItemRemoteModel() {
		return _spSellingItemRemoteModel;
	}

	public void setSPSellingItemRemoteModel(
		BaseModel<?> spSellingItemRemoteModel) {
		_spSellingItemRemoteModel = spSellingItemRemoteModel;
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

		Class<?> remoteModelClass = _spSellingItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spSellingItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPSellingItemLocalServiceUtil.addSPSellingItem(this);
		}
		else {
			SPSellingItemLocalServiceUtil.updateSPSellingItem(this);
		}
	}

	@Override
	public SPSellingItem toEscapedModel() {
		return (SPSellingItem)ProxyUtil.newProxyInstance(SPSellingItem.class.getClassLoader(),
			new Class[] { SPSellingItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPSellingItemClp clone = new SPSellingItemClp();

		clone.setSpSellingItemId(getSpSellingItemId());
		clone.setGroupId(getGroupId());
		clone.setTitle(getTitle());
		clone.setItemCode(getItemCode());
		clone.setEntityClassPk(getEntityClassPk());
		clone.setEntityClassNameId(getEntityClassNameId());
		clone.setEntityClassName(getEntityClassName());
		clone.setShortDescription(getShortDescription());
		clone.setLongDescription(getLongDescription());
		clone.setActive(getActive());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPSellingItem spSellingItem) {
		long primaryKey = spSellingItem.getPrimaryKey();

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

		if (!(obj instanceof SPSellingItemClp)) {
			return false;
		}

		SPSellingItemClp spSellingItem = (SPSellingItemClp)obj;

		long primaryKey = spSellingItem.getPrimaryKey();

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

		sb.append("{spSellingItemId=");
		sb.append(getSpSellingItemId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", itemCode=");
		sb.append(getItemCode());
		sb.append(", entityClassPk=");
		sb.append(getEntityClassPk());
		sb.append(", entityClassNameId=");
		sb.append(getEntityClassNameId());
		sb.append(", entityClassName=");
		sb.append(getEntityClassName());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", longDescription=");
		sb.append(getLongDescription());
		sb.append(", active=");
		sb.append(getActive());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spshopping.model.SPSellingItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spSellingItemId</column-name><column-value><![CDATA[");
		sb.append(getSpSellingItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCode</column-name><column-value><![CDATA[");
		sb.append(getItemCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassPk</column-name><column-value><![CDATA[");
		sb.append(getEntityClassPk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassNameId</column-name><column-value><![CDATA[");
		sb.append(getEntityClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassName</column-name><column-value><![CDATA[");
		sb.append(getEntityClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longDescription</column-name><column-value><![CDATA[");
		sb.append(getLongDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _spSellingItemId;
	private long _groupId;
	private String _title;
	private String _itemCode;
	private long _entityClassPk;
	private long _entityClassNameId;
	private String _entityClassName;
	private String _shortDescription;
	private String _longDescription;
	private boolean _active;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spSellingItemRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spshopping.service.ClpSerializer.class;
}