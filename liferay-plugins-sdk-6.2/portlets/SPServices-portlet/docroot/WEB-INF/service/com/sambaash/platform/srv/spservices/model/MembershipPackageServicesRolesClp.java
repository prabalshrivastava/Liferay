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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.MembershipPackageServicesRolesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class MembershipPackageServicesRolesClp extends BaseModelImpl<MembershipPackageServicesRoles>
	implements MembershipPackageServicesRoles {
	public MembershipPackageServicesRolesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackageServicesRoles.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackageServicesRoles.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _mpgsrlId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMpgsrlId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mpgsrlId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mpgsrlId", getMpgsrlId());
		attributes.put("mpId", getMpId());
		attributes.put("serviceId", getServiceId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("roleId", getRoleId());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());
		attributes.put("extra6", getExtra6());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mpgsrlId = (Long)attributes.get("mpgsrlId");

		if (mpgsrlId != null) {
			setMpgsrlId(mpgsrlId);
		}

		Long mpId = (Long)attributes.get("mpId");

		if (mpId != null) {
			setMpId(mpId);
		}

		Long serviceId = (Long)attributes.get("serviceId");

		if (serviceId != null) {
			setServiceId(serviceId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}

		String extra3 = (String)attributes.get("extra3");

		if (extra3 != null) {
			setExtra3(extra3);
		}

		String extra4 = (String)attributes.get("extra4");

		if (extra4 != null) {
			setExtra4(extra4);
		}

		Date extra5 = (Date)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}

		Date extra6 = (Date)attributes.get("extra6");

		if (extra6 != null) {
			setExtra6(extra6);
		}
	}

	@Override
	public long getMpgsrlId() {
		return _mpgsrlId;
	}

	@Override
	public void setMpgsrlId(long mpgsrlId) {
		_mpgsrlId = mpgsrlId;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setMpgsrlId", long.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel,
					mpgsrlId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMpId() {
		return _mpId;
	}

	@Override
	public void setMpId(long mpId) {
		_mpId = mpId;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setMpId", long.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel, mpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getServiceId() {
		return _serviceId;
	}

	@Override
	public void setServiceId(long serviceId) {
		_serviceId = serviceId;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceId", long.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel,
					serviceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel,
					classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleId", long.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel, roleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra1() {
		return _extra1;
	}

	@Override
	public void setExtra1(String extra1) {
		_extra1 = extra1;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel, extra1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra2() {
		return _extra2;
	}

	@Override
	public void setExtra2(String extra2) {
		_extra2 = extra2;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel, extra2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra3() {
		return _extra3;
	}

	@Override
	public void setExtra3(String extra3) {
		_extra3 = extra3;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra3", String.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel, extra3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra4() {
		return _extra4;
	}

	@Override
	public void setExtra4(String extra4) {
		_extra4 = extra4;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra4", String.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel, extra4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExtra5() {
		return _extra5;
	}

	@Override
	public void setExtra5(Date extra5) {
		_extra5 = extra5;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra5", Date.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel, extra5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExtra6() {
		return _extra6;
	}

	@Override
	public void setExtra6(Date extra6) {
		_extra6 = extra6;

		if (_membershipPackageServicesRolesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageServicesRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra6", Date.class);

				method.invoke(_membershipPackageServicesRolesRemoteModel, extra6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMembershipPackageServicesRolesRemoteModel() {
		return _membershipPackageServicesRolesRemoteModel;
	}

	public void setMembershipPackageServicesRolesRemoteModel(
		BaseModel<?> membershipPackageServicesRolesRemoteModel) {
		_membershipPackageServicesRolesRemoteModel = membershipPackageServicesRolesRemoteModel;
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

		Class<?> remoteModelClass = _membershipPackageServicesRolesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_membershipPackageServicesRolesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MembershipPackageServicesRolesLocalServiceUtil.addMembershipPackageServicesRoles(this);
		}
		else {
			MembershipPackageServicesRolesLocalServiceUtil.updateMembershipPackageServicesRoles(this);
		}
	}

	@Override
	public MembershipPackageServicesRoles toEscapedModel() {
		return (MembershipPackageServicesRoles)ProxyUtil.newProxyInstance(MembershipPackageServicesRoles.class.getClassLoader(),
			new Class[] { MembershipPackageServicesRoles.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MembershipPackageServicesRolesClp clone = new MembershipPackageServicesRolesClp();

		clone.setMpgsrlId(getMpgsrlId());
		clone.setMpId(getMpId());
		clone.setServiceId(getServiceId());
		clone.setClassNameId(getClassNameId());
		clone.setRoleId(getRoleId());
		clone.setExtra1(getExtra1());
		clone.setExtra2(getExtra2());
		clone.setExtra3(getExtra3());
		clone.setExtra4(getExtra4());
		clone.setExtra5(getExtra5());
		clone.setExtra6(getExtra6());

		return clone;
	}

	@Override
	public int compareTo(
		MembershipPackageServicesRoles membershipPackageServicesRoles) {
		int value = 0;

		if (getMpgsrlId() < membershipPackageServicesRoles.getMpgsrlId()) {
			value = -1;
		}
		else if (getMpgsrlId() > membershipPackageServicesRoles.getMpgsrlId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getMpId() < membershipPackageServicesRoles.getMpId()) {
			value = -1;
		}
		else if (getMpId() > membershipPackageServicesRoles.getMpId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof MembershipPackageServicesRolesClp)) {
			return false;
		}

		MembershipPackageServicesRolesClp membershipPackageServicesRoles = (MembershipPackageServicesRolesClp)obj;

		long primaryKey = membershipPackageServicesRoles.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{mpgsrlId=");
		sb.append(getMpgsrlId());
		sb.append(", mpId=");
		sb.append(getMpId());
		sb.append(", serviceId=");
		sb.append(getServiceId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", extra1=");
		sb.append(getExtra1());
		sb.append(", extra2=");
		sb.append(getExtra2());
		sb.append(", extra3=");
		sb.append(getExtra3());
		sb.append(", extra4=");
		sb.append(getExtra4());
		sb.append(", extra5=");
		sb.append(getExtra5());
		sb.append(", extra6=");
		sb.append(getExtra6());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mpgsrlId</column-name><column-value><![CDATA[");
		sb.append(getMpgsrlId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpId</column-name><column-value><![CDATA[");
		sb.append(getMpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceId</column-name><column-value><![CDATA[");
		sb.append(getServiceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra1</column-name><column-value><![CDATA[");
		sb.append(getExtra1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra2</column-name><column-value><![CDATA[");
		sb.append(getExtra2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra3</column-name><column-value><![CDATA[");
		sb.append(getExtra3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra4</column-name><column-value><![CDATA[");
		sb.append(getExtra4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra5</column-name><column-value><![CDATA[");
		sb.append(getExtra5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra6</column-name><column-value><![CDATA[");
		sb.append(getExtra6());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mpgsrlId;
	private long _mpId;
	private long _serviceId;
	private long _classNameId;
	private long _roleId;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private Date _extra5;
	private Date _extra6;
	private BaseModel<?> _membershipPackageServicesRolesRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}