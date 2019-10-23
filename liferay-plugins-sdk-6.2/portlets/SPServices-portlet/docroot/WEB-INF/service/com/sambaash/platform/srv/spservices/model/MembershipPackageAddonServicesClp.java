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
import com.sambaash.platform.srv.spservices.service.MembershipPackageAddonServicesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class MembershipPackageAddonServicesClp extends BaseModelImpl<MembershipPackageAddonServices>
	implements MembershipPackageAddonServices {
	public MembershipPackageAddonServicesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackageAddonServices.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackageAddonServices.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _mpAddonId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMpAddonId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mpAddonId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mpAddonId", getMpAddonId());
		attributes.put("scId", getScId());
		attributes.put("scName", getScName());
		attributes.put("paramType", getParamType());
		attributes.put("paramFrom", getParamFrom());
		attributes.put("paramUpto", getParamUpto());
		attributes.put("duration", getDuration());
		attributes.put("durationType", getDurationType());
		attributes.put("serviceCharges", getServiceCharges());
		attributes.put("serviceChargesCurrency", getServiceChargesCurrency());
		attributes.put("serviceChargesPeriod", getServiceChargesPeriod());
		attributes.put("serviceChargesPeriodType", getServiceChargesPeriodType());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());
		attributes.put("dateAdded", getDateAdded());
		attributes.put("dateModified", getDateModified());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
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
		Long mpAddonId = (Long)attributes.get("mpAddonId");

		if (mpAddonId != null) {
			setMpAddonId(mpAddonId);
		}

		String scId = (String)attributes.get("scId");

		if (scId != null) {
			setScId(scId);
		}

		String scName = (String)attributes.get("scName");

		if (scName != null) {
			setScName(scName);
		}

		String paramType = (String)attributes.get("paramType");

		if (paramType != null) {
			setParamType(paramType);
		}

		String paramFrom = (String)attributes.get("paramFrom");

		if (paramFrom != null) {
			setParamFrom(paramFrom);
		}

		String paramUpto = (String)attributes.get("paramUpto");

		if (paramUpto != null) {
			setParamUpto(paramUpto);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String durationType = (String)attributes.get("durationType");

		if (durationType != null) {
			setDurationType(durationType);
		}

		Float serviceCharges = (Float)attributes.get("serviceCharges");

		if (serviceCharges != null) {
			setServiceCharges(serviceCharges);
		}

		String serviceChargesCurrency = (String)attributes.get(
				"serviceChargesCurrency");

		if (serviceChargesCurrency != null) {
			setServiceChargesCurrency(serviceChargesCurrency);
		}

		String serviceChargesPeriod = (String)attributes.get(
				"serviceChargesPeriod");

		if (serviceChargesPeriod != null) {
			setServiceChargesPeriod(serviceChargesPeriod);
		}

		String serviceChargesPeriodType = (String)attributes.get(
				"serviceChargesPeriodType");

		if (serviceChargesPeriodType != null) {
			setServiceChargesPeriodType(serviceChargesPeriodType);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date dateAdded = (Date)attributes.get("dateAdded");

		if (dateAdded != null) {
			setDateAdded(dateAdded);
		}

		Date dateModified = (Date)attributes.get("dateModified");

		if (dateModified != null) {
			setDateModified(dateModified);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
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
	public long getMpAddonId() {
		return _mpAddonId;
	}

	@Override
	public void setMpAddonId(long mpAddonId) {
		_mpAddonId = mpAddonId;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setMpAddonId", long.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					mpAddonId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScId() {
		return _scId;
	}

	@Override
	public void setScId(String scId) {
		_scId = scId;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setScId", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel, scId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScName() {
		return _scName;
	}

	@Override
	public void setScName(String scName) {
		_scName = scName;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setScName", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel, scName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParamType() {
		return _paramType;
	}

	@Override
	public void setParamType(String paramType) {
		_paramType = paramType;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setParamType", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					paramType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParamFrom() {
		return _paramFrom;
	}

	@Override
	public void setParamFrom(String paramFrom) {
		_paramFrom = paramFrom;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setParamFrom", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					paramFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParamUpto() {
		return _paramUpto;
	}

	@Override
	public void setParamUpto(String paramUpto) {
		_paramUpto = paramUpto;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setParamUpto", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					paramUpto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuration() {
		return _duration;
	}

	@Override
	public void setDuration(String duration) {
		_duration = duration;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					duration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDurationType() {
		return _durationType;
	}

	@Override
	public void setDurationType(String durationType) {
		_durationType = durationType;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDurationType", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					durationType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getServiceCharges() {
		return _serviceCharges;
	}

	@Override
	public void setServiceCharges(float serviceCharges) {
		_serviceCharges = serviceCharges;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceCharges", float.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					serviceCharges);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceChargesCurrency() {
		return _serviceChargesCurrency;
	}

	@Override
	public void setServiceChargesCurrency(String serviceChargesCurrency) {
		_serviceChargesCurrency = serviceChargesCurrency;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceChargesCurrency",
						String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					serviceChargesCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceChargesPeriod() {
		return _serviceChargesPeriod;
	}

	@Override
	public void setServiceChargesPeriod(String serviceChargesPeriod) {
		_serviceChargesPeriod = serviceChargesPeriod;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceChargesPeriod",
						String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					serviceChargesPeriod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceChargesPeriodType() {
		return _serviceChargesPeriodType;
	}

	@Override
	public void setServiceChargesPeriodType(String serviceChargesPeriodType) {
		_serviceChargesPeriodType = serviceChargesPeriodType;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceChargesPeriodType",
						String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					serviceChargesPeriodType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateAdded() {
		return _dateAdded;
	}

	@Override
	public void setDateAdded(Date dateAdded) {
		_dateAdded = dateAdded;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDateAdded", Date.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					dateAdded);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateModified() {
		return _dateModified;
	}

	@Override
	public void setDateModified(Date dateModified) {
		_dateModified = dateModified;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDateModified", Date.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					dateModified);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel,
					modifiedBy);
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

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel, extra1);
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

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel, extra2);
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

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra3", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel, extra3);
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

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra4", String.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel, extra4);
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

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra5", Date.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel, extra5);
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

		if (_membershipPackageAddonServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageAddonServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra6", Date.class);

				method.invoke(_membershipPackageAddonServicesRemoteModel, extra6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMembershipPackageAddonServicesRemoteModel() {
		return _membershipPackageAddonServicesRemoteModel;
	}

	public void setMembershipPackageAddonServicesRemoteModel(
		BaseModel<?> membershipPackageAddonServicesRemoteModel) {
		_membershipPackageAddonServicesRemoteModel = membershipPackageAddonServicesRemoteModel;
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

		Class<?> remoteModelClass = _membershipPackageAddonServicesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_membershipPackageAddonServicesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MembershipPackageAddonServicesLocalServiceUtil.addMembershipPackageAddonServices(this);
		}
		else {
			MembershipPackageAddonServicesLocalServiceUtil.updateMembershipPackageAddonServices(this);
		}
	}

	@Override
	public MembershipPackageAddonServices toEscapedModel() {
		return (MembershipPackageAddonServices)ProxyUtil.newProxyInstance(MembershipPackageAddonServices.class.getClassLoader(),
			new Class[] { MembershipPackageAddonServices.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MembershipPackageAddonServicesClp clone = new MembershipPackageAddonServicesClp();

		clone.setMpAddonId(getMpAddonId());
		clone.setScId(getScId());
		clone.setScName(getScName());
		clone.setParamType(getParamType());
		clone.setParamFrom(getParamFrom());
		clone.setParamUpto(getParamUpto());
		clone.setDuration(getDuration());
		clone.setDurationType(getDurationType());
		clone.setServiceCharges(getServiceCharges());
		clone.setServiceChargesCurrency(getServiceChargesCurrency());
		clone.setServiceChargesPeriod(getServiceChargesPeriod());
		clone.setServiceChargesPeriodType(getServiceChargesPeriodType());
		clone.setStatus(getStatus());
		clone.setDescription(getDescription());
		clone.setDateAdded(getDateAdded());
		clone.setDateModified(getDateModified());
		clone.setCreatedBy(getCreatedBy());
		clone.setModifiedBy(getModifiedBy());
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
		MembershipPackageAddonServices membershipPackageAddonServices) {
		int value = 0;

		value = getScName().compareTo(membershipPackageAddonServices.getScName());

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

		if (!(obj instanceof MembershipPackageAddonServicesClp)) {
			return false;
		}

		MembershipPackageAddonServicesClp membershipPackageAddonServices = (MembershipPackageAddonServicesClp)obj;

		long primaryKey = membershipPackageAddonServices.getPrimaryKey();

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
		StringBundler sb = new StringBundler(49);

		sb.append("{mpAddonId=");
		sb.append(getMpAddonId());
		sb.append(", scId=");
		sb.append(getScId());
		sb.append(", scName=");
		sb.append(getScName());
		sb.append(", paramType=");
		sb.append(getParamType());
		sb.append(", paramFrom=");
		sb.append(getParamFrom());
		sb.append(", paramUpto=");
		sb.append(getParamUpto());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", durationType=");
		sb.append(getDurationType());
		sb.append(", serviceCharges=");
		sb.append(getServiceCharges());
		sb.append(", serviceChargesCurrency=");
		sb.append(getServiceChargesCurrency());
		sb.append(", serviceChargesPeriod=");
		sb.append(getServiceChargesPeriod());
		sb.append(", serviceChargesPeriodType=");
		sb.append(getServiceChargesPeriodType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", dateAdded=");
		sb.append(getDateAdded());
		sb.append(", dateModified=");
		sb.append(getDateModified());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
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
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mpAddonId</column-name><column-value><![CDATA[");
		sb.append(getMpAddonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scId</column-name><column-value><![CDATA[");
		sb.append(getScId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scName</column-name><column-value><![CDATA[");
		sb.append(getScName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paramType</column-name><column-value><![CDATA[");
		sb.append(getParamType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paramFrom</column-name><column-value><![CDATA[");
		sb.append(getParamFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paramUpto</column-name><column-value><![CDATA[");
		sb.append(getParamUpto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>durationType</column-name><column-value><![CDATA[");
		sb.append(getDurationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceCharges</column-name><column-value><![CDATA[");
		sb.append(getServiceCharges());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceChargesCurrency</column-name><column-value><![CDATA[");
		sb.append(getServiceChargesCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceChargesPeriod</column-name><column-value><![CDATA[");
		sb.append(getServiceChargesPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceChargesPeriodType</column-name><column-value><![CDATA[");
		sb.append(getServiceChargesPeriodType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateAdded</column-name><column-value><![CDATA[");
		sb.append(getDateAdded());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateModified</column-name><column-value><![CDATA[");
		sb.append(getDateModified());
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

	private long _mpAddonId;
	private String _scId;
	private String _scName;
	private String _paramType;
	private String _paramFrom;
	private String _paramUpto;
	private String _duration;
	private String _durationType;
	private float _serviceCharges;
	private String _serviceChargesCurrency;
	private String _serviceChargesPeriod;
	private String _serviceChargesPeriodType;
	private String _status;
	private String _description;
	private Date _dateAdded;
	private Date _dateModified;
	private String _createdBy;
	private String _modifiedBy;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private Date _extra5;
	private Date _extra6;
	private BaseModel<?> _membershipPackageAddonServicesRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}