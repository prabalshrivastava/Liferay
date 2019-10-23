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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPSiteSetupClp extends BaseModelImpl<SPSiteSetup>
	implements SPSiteSetup {
	public SPSiteSetupClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPSiteSetup.class;
	}

	@Override
	public String getModelClassName() {
		return SPSiteSetup.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spSiteSetupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpSiteSetupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spSiteSetupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spSiteSetupId", getSpSiteSetupId());
		attributes.put("groupId", getGroupId());
		attributes.put("productId", getProductId());
		attributes.put("productName", getProductName());
		attributes.put("subProductId", getSubProductId());
		attributes.put("subProductName", getSubProductName());
		attributes.put("virtualHostId", getVirtualHostId());
		attributes.put("backOfficeVirtualHostId", getBackOfficeVirtualHostId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spSiteSetupId = (Long)attributes.get("spSiteSetupId");

		if (spSiteSetupId != null) {
			setSpSiteSetupId(spSiteSetupId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		Long subProductId = (Long)attributes.get("subProductId");

		if (subProductId != null) {
			setSubProductId(subProductId);
		}

		String subProductName = (String)attributes.get("subProductName");

		if (subProductName != null) {
			setSubProductName(subProductName);
		}

		Long virtualHostId = (Long)attributes.get("virtualHostId");

		if (virtualHostId != null) {
			setVirtualHostId(virtualHostId);
		}

		Long backOfficeVirtualHostId = (Long)attributes.get(
				"backOfficeVirtualHostId");

		if (backOfficeVirtualHostId != null) {
			setBackOfficeVirtualHostId(backOfficeVirtualHostId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spSiteSetupRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpSiteSetupId() {
		return _spSiteSetupId;
	}

	@Override
	public void setSpSiteSetupId(long spSiteSetupId) {
		_spSiteSetupId = spSiteSetupId;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setSpSiteSetupId", long.class);

				method.invoke(_spSiteSetupRemoteModel, spSiteSetupId);
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

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spSiteSetupRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		_productId = productId;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setProductId", long.class);

				method.invoke(_spSiteSetupRemoteModel, productId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductName() {
		return _productName;
	}

	@Override
	public void setProductName(String productName) {
		_productName = productName;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setProductName", String.class);

				method.invoke(_spSiteSetupRemoteModel, productName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubProductId() {
		return _subProductId;
	}

	@Override
	public void setSubProductId(long subProductId) {
		_subProductId = subProductId;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setSubProductId", long.class);

				method.invoke(_spSiteSetupRemoteModel, subProductId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubProductName() {
		return _subProductName;
	}

	@Override
	public void setSubProductName(String subProductName) {
		_subProductName = subProductName;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setSubProductName",
						String.class);

				method.invoke(_spSiteSetupRemoteModel, subProductName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVirtualHostId() {
		return _virtualHostId;
	}

	@Override
	public void setVirtualHostId(long virtualHostId) {
		_virtualHostId = virtualHostId;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualHostId", long.class);

				method.invoke(_spSiteSetupRemoteModel, virtualHostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBackOfficeVirtualHostId() {
		return _backOfficeVirtualHostId;
	}

	@Override
	public void setBackOfficeVirtualHostId(long backOfficeVirtualHostId) {
		_backOfficeVirtualHostId = backOfficeVirtualHostId;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setBackOfficeVirtualHostId",
						long.class);

				method.invoke(_spSiteSetupRemoteModel, backOfficeVirtualHostId);
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

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spSiteSetupRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_spSiteSetupRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_spSiteSetupRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_spSiteSetupRemoteModel, createdDate);
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

		if (_spSiteSetupRemoteModel != null) {
			try {
				Class<?> clazz = _spSiteSetupRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spSiteSetupRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPSiteSetupRemoteModel() {
		return _spSiteSetupRemoteModel;
	}

	public void setSPSiteSetupRemoteModel(BaseModel<?> spSiteSetupRemoteModel) {
		_spSiteSetupRemoteModel = spSiteSetupRemoteModel;
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

		Class<?> remoteModelClass = _spSiteSetupRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spSiteSetupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPSiteSetupLocalServiceUtil.addSPSiteSetup(this);
		}
		else {
			SPSiteSetupLocalServiceUtil.updateSPSiteSetup(this);
		}
	}

	@Override
	public SPSiteSetup toEscapedModel() {
		return (SPSiteSetup)ProxyUtil.newProxyInstance(SPSiteSetup.class.getClassLoader(),
			new Class[] { SPSiteSetup.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPSiteSetupClp clone = new SPSiteSetupClp();

		clone.setUuid(getUuid());
		clone.setSpSiteSetupId(getSpSiteSetupId());
		clone.setGroupId(getGroupId());
		clone.setProductId(getProductId());
		clone.setProductName(getProductName());
		clone.setSubProductId(getSubProductId());
		clone.setSubProductName(getSubProductName());
		clone.setVirtualHostId(getVirtualHostId());
		clone.setBackOfficeVirtualHostId(getBackOfficeVirtualHostId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedBy(getCreatedBy());
		clone.setModifiedBy(getModifiedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPSiteSetup spSiteSetup) {
		long primaryKey = spSiteSetup.getPrimaryKey();

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

		if (!(obj instanceof SPSiteSetupClp)) {
			return false;
		}

		SPSiteSetupClp spSiteSetup = (SPSiteSetupClp)obj;

		long primaryKey = spSiteSetup.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spSiteSetupId=");
		sb.append(getSpSiteSetupId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", productName=");
		sb.append(getProductName());
		sb.append(", subProductId=");
		sb.append(getSubProductId());
		sb.append(", subProductName=");
		sb.append(getSubProductName());
		sb.append(", virtualHostId=");
		sb.append(getVirtualHostId());
		sb.append(", backOfficeVirtualHostId=");
		sb.append(getBackOfficeVirtualHostId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPSiteSetup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spSiteSetupId</column-name><column-value><![CDATA[");
		sb.append(getSpSiteSetupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productName</column-name><column-value><![CDATA[");
		sb.append(getProductName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subProductId</column-name><column-value><![CDATA[");
		sb.append(getSubProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subProductName</column-name><column-value><![CDATA[");
		sb.append(getSubProductName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualHostId</column-name><column-value><![CDATA[");
		sb.append(getVirtualHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backOfficeVirtualHostId</column-name><column-value><![CDATA[");
		sb.append(getBackOfficeVirtualHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spSiteSetupId;
	private long _groupId;
	private long _productId;
	private String _productName;
	private long _subProductId;
	private String _subProductName;
	private long _virtualHostId;
	private long _backOfficeVirtualHostId;
	private long _companyId;
	private long _createdBy;
	private long _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;
	private BaseModel<?> _spSiteSetupRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}