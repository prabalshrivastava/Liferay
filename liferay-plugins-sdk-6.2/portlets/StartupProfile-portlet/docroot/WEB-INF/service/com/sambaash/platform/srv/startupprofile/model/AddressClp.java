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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.startupprofile.service.AddressLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class AddressClp extends BaseModelImpl<Address> implements Address {
	public AddressClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Address.class;
	}

	@Override
	public String getModelClassName() {
		return Address.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _addressId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAddressId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _addressId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("addressId", getAddressId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("name", getName());
		attributes.put("street1", getStreet1());
		attributes.put("street2", getStreet2());
		attributes.put("street3", getStreet3());
		attributes.put("street4", getStreet4());
		attributes.put("city", getCity());
		attributes.put("region", getRegion());
		attributes.put("country", getCountry());
		attributes.put("postalCode", getPostalCode());
		attributes.put("hq", getHq());
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
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String street1 = (String)attributes.get("street1");

		if (street1 != null) {
			setStreet1(street1);
		}

		String street2 = (String)attributes.get("street2");

		if (street2 != null) {
			setStreet2(street2);
		}

		String street3 = (String)attributes.get("street3");

		if (street3 != null) {
			setStreet3(street3);
		}

		String street4 = (String)attributes.get("street4");

		if (street4 != null) {
			setStreet4(street4);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String region = (String)attributes.get("region");

		if (region != null) {
			setRegion(region);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		Boolean hq = (Boolean)attributes.get("hq");

		if (hq != null) {
			setHq(hq);
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
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_addressRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAddressId() {
		return _addressId;
	}

	@Override
	public void setAddressId(long addressId) {
		_addressId = addressId;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressId", long.class);

				method.invoke(_addressRemoteModel, addressId);
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

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_addressRemoteModel, organizationId);
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

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_addressRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreet1() {
		return _street1;
	}

	@Override
	public void setStreet1(String street1) {
		_street1 = street1;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setStreet1", String.class);

				method.invoke(_addressRemoteModel, street1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreet2() {
		return _street2;
	}

	@Override
	public void setStreet2(String street2) {
		_street2 = street2;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setStreet2", String.class);

				method.invoke(_addressRemoteModel, street2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreet3() {
		return _street3;
	}

	@Override
	public void setStreet3(String street3) {
		_street3 = street3;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setStreet3", String.class);

				method.invoke(_addressRemoteModel, street3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreet4() {
		return _street4;
	}

	@Override
	public void setStreet4(String street4) {
		_street4 = street4;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setStreet4", String.class);

				method.invoke(_addressRemoteModel, street4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_addressRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegion() {
		return _region;
	}

	@Override
	public void setRegion(String region) {
		_region = region;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setRegion", String.class);

				method.invoke(_addressRemoteModel, region);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_addressRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostalCode() {
		return _postalCode;
	}

	@Override
	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setPostalCode", String.class);

				method.invoke(_addressRemoteModel, postalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHq() {
		return _hq;
	}

	@Override
	public boolean isHq() {
		return _hq;
	}

	@Override
	public void setHq(boolean hq) {
		_hq = hq;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setHq", boolean.class);

				method.invoke(_addressRemoteModel, hq);
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

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_addressRemoteModel, groupId);
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

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_addressRemoteModel, companyId);
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

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_addressRemoteModel, userId);
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

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_addressRemoteModel, userName);
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

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_addressRemoteModel, createDate);
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

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_addressRemoteModel, modifiedDate);
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

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_addressRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Address.class.getName()));
	}

	public BaseModel<?> getAddressRemoteModel() {
		return _addressRemoteModel;
	}

	public void setAddressRemoteModel(BaseModel<?> addressRemoteModel) {
		_addressRemoteModel = addressRemoteModel;
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

		Class<?> remoteModelClass = _addressRemoteModel.getClass();

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

		Object returnValue = method.invoke(_addressRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AddressLocalServiceUtil.addAddress(this);
		}
		else {
			AddressLocalServiceUtil.updateAddress(this);
		}
	}

	@Override
	public Address toEscapedModel() {
		return (Address)ProxyUtil.newProxyInstance(Address.class.getClassLoader(),
			new Class[] { Address.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AddressClp clone = new AddressClp();

		clone.setUuid(getUuid());
		clone.setAddressId(getAddressId());
		clone.setOrganizationId(getOrganizationId());
		clone.setName(getName());
		clone.setStreet1(getStreet1());
		clone.setStreet2(getStreet2());
		clone.setStreet3(getStreet3());
		clone.setStreet4(getStreet4());
		clone.setCity(getCity());
		clone.setRegion(getRegion());
		clone.setCountry(getCountry());
		clone.setPostalCode(getPostalCode());
		clone.setHq(getHq());
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
	public int compareTo(Address address) {
		long primaryKey = address.getPrimaryKey();

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

		if (!(obj instanceof AddressClp)) {
			return false;
		}

		AddressClp address = (AddressClp)obj;

		long primaryKey = address.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", addressId=");
		sb.append(getAddressId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", street1=");
		sb.append(getStreet1());
		sb.append(", street2=");
		sb.append(getStreet2());
		sb.append(", street3=");
		sb.append(getStreet3());
		sb.append(", street4=");
		sb.append(getStreet4());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", region=");
		sb.append(getRegion());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", postalCode=");
		sb.append(getPostalCode());
		sb.append(", hq=");
		sb.append(getHq());
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
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.startupprofile.model.Address");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addressId</column-name><column-value><![CDATA[");
		sb.append(getAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>street1</column-name><column-value><![CDATA[");
		sb.append(getStreet1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>street2</column-name><column-value><![CDATA[");
		sb.append(getStreet2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>street3</column-name><column-value><![CDATA[");
		sb.append(getStreet3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>street4</column-name><column-value><![CDATA[");
		sb.append(getStreet4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>region</column-name><column-value><![CDATA[");
		sb.append(getRegion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postalCode</column-name><column-value><![CDATA[");
		sb.append(getPostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hq</column-name><column-value><![CDATA[");
		sb.append(getHq());
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

	private String _uuid;
	private long _addressId;
	private long _organizationId;
	private String _name;
	private String _street1;
	private String _street2;
	private String _street3;
	private String _street4;
	private String _city;
	private String _region;
	private String _country;
	private String _postalCode;
	private boolean _hq;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private BaseModel<?> _addressRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}