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

package com.sambaash.platform.srv.sppayment.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.sppayment.service.ClpSerializer;
import com.sambaash.platform.srv.sppayment.service.SPPaymentCustomerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPPaymentCustomerClp extends BaseModelImpl<SPPaymentCustomer>
	implements SPPaymentCustomer {
	public SPPaymentCustomerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPPaymentCustomer.class;
	}

	@Override
	public String getModelClassName() {
		return SPPaymentCustomer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _sPPaymentCustomerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSPPaymentCustomerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sPPaymentCustomerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sPPaymentCustomerId", getSPPaymentCustomerId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("providerCustomerId", getProviderCustomerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sPPaymentCustomerId = (Long)attributes.get("sPPaymentCustomerId");

		if (sPPaymentCustomerId != null) {
			setSPPaymentCustomerId(sPPaymentCustomerId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String providerCustomerId = (String)attributes.get("providerCustomerId");

		if (providerCustomerId != null) {
			setProviderCustomerId(providerCustomerId);
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
	}

	@Override
	public long getSPPaymentCustomerId() {
		return _sPPaymentCustomerId;
	}

	@Override
	public void setSPPaymentCustomerId(long sPPaymentCustomerId) {
		_sPPaymentCustomerId = sPPaymentCustomerId;

		if (_spPaymentCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _spPaymentCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setSPPaymentCustomerId",
						long.class);

				method.invoke(_spPaymentCustomerRemoteModel, sPPaymentCustomerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_spPaymentCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _spPaymentCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_spPaymentCustomerRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProviderCustomerId() {
		return _providerCustomerId;
	}

	@Override
	public void setProviderCustomerId(String providerCustomerId) {
		_providerCustomerId = providerCustomerId;

		if (_spPaymentCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _spPaymentCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setProviderCustomerId",
						String.class);

				method.invoke(_spPaymentCustomerRemoteModel, providerCustomerId);
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

		if (_spPaymentCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _spPaymentCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spPaymentCustomerRemoteModel, groupId);
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

		if (_spPaymentCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _spPaymentCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spPaymentCustomerRemoteModel, companyId);
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

		if (_spPaymentCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _spPaymentCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spPaymentCustomerRemoteModel, userId);
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

		if (_spPaymentCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _spPaymentCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spPaymentCustomerRemoteModel, userName);
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

		if (_spPaymentCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _spPaymentCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spPaymentCustomerRemoteModel, createDate);
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

		if (_spPaymentCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _spPaymentCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spPaymentCustomerRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPPaymentCustomerRemoteModel() {
		return _spPaymentCustomerRemoteModel;
	}

	public void setSPPaymentCustomerRemoteModel(
		BaseModel<?> spPaymentCustomerRemoteModel) {
		_spPaymentCustomerRemoteModel = spPaymentCustomerRemoteModel;
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

		Class<?> remoteModelClass = _spPaymentCustomerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spPaymentCustomerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPPaymentCustomerLocalServiceUtil.addSPPaymentCustomer(this);
		}
		else {
			SPPaymentCustomerLocalServiceUtil.updateSPPaymentCustomer(this);
		}
	}

	@Override
	public SPPaymentCustomer toEscapedModel() {
		return (SPPaymentCustomer)ProxyUtil.newProxyInstance(SPPaymentCustomer.class.getClassLoader(),
			new Class[] { SPPaymentCustomer.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPPaymentCustomerClp clone = new SPPaymentCustomerClp();

		clone.setSPPaymentCustomerId(getSPPaymentCustomerId());
		clone.setEmailAddress(getEmailAddress());
		clone.setProviderCustomerId(getProviderCustomerId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPPaymentCustomer spPaymentCustomer) {
		long primaryKey = spPaymentCustomer.getPrimaryKey();

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

		if (!(obj instanceof SPPaymentCustomerClp)) {
			return false;
		}

		SPPaymentCustomerClp spPaymentCustomer = (SPPaymentCustomerClp)obj;

		long primaryKey = spPaymentCustomer.getPrimaryKey();

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

		sb.append("{sPPaymentCustomerId=");
		sb.append(getSPPaymentCustomerId());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", providerCustomerId=");
		sb.append(getProviderCustomerId());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sPPaymentCustomerId</column-name><column-value><![CDATA[");
		sb.append(getSPPaymentCustomerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>providerCustomerId</column-name><column-value><![CDATA[");
		sb.append(getProviderCustomerId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _sPPaymentCustomerId;
	private String _emailAddress;
	private String _providerCustomerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spPaymentCustomerRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.sppayment.service.ClpSerializer.class;
}