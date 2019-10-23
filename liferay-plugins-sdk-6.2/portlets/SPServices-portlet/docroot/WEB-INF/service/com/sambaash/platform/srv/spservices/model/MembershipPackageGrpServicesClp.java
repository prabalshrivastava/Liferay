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
import com.sambaash.platform.srv.spservices.service.MembershipPackageGrpServicesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class MembershipPackageGrpServicesClp extends BaseModelImpl<MembershipPackageGrpServices>
	implements MembershipPackageGrpServices {
	public MembershipPackageGrpServicesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackageGrpServices.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackageGrpServices.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _mpgsscId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMpgsscId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mpgsscId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mpgsscId", getMpgsscId());
		attributes.put("mpId", getMpId());
		attributes.put("scorder", getScorder());
		attributes.put("scgId", getScgId());
		attributes.put("scId", getScId());
		attributes.put("paramType", getParamType());
		attributes.put("paramFrom", getParamFrom());
		attributes.put("paramUpto", getParamUpto());
		attributes.put("duration", getDuration());
		attributes.put("durationType", getDurationType());
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
		attributes.put("serviceCharges", getServiceCharges());
		attributes.put("costCurrency", getCostCurrency());
		attributes.put("costPeriod", getCostPeriod());
		attributes.put("costPeriodType", getCostPeriodType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mpgsscId = (Long)attributes.get("mpgsscId");

		if (mpgsscId != null) {
			setMpgsscId(mpgsscId);
		}

		Long mpId = (Long)attributes.get("mpId");

		if (mpId != null) {
			setMpId(mpId);
		}

		Integer scorder = (Integer)attributes.get("scorder");

		if (scorder != null) {
			setScorder(scorder);
		}

		String scgId = (String)attributes.get("scgId");

		if (scgId != null) {
			setScgId(scgId);
		}

		String scId = (String)attributes.get("scId");

		if (scId != null) {
			setScId(scId);
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

		Float serviceCharges = (Float)attributes.get("serviceCharges");

		if (serviceCharges != null) {
			setServiceCharges(serviceCharges);
		}

		String costCurrency = (String)attributes.get("costCurrency");

		if (costCurrency != null) {
			setCostCurrency(costCurrency);
		}

		String costPeriod = (String)attributes.get("costPeriod");

		if (costPeriod != null) {
			setCostPeriod(costPeriod);
		}

		String costPeriodType = (String)attributes.get("costPeriodType");

		if (costPeriodType != null) {
			setCostPeriodType(costPeriodType);
		}
	}

	@Override
	public long getMpgsscId() {
		return _mpgsscId;
	}

	@Override
	public void setMpgsscId(long mpgsscId) {
		_mpgsscId = mpgsscId;

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setMpgsscId", long.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, mpgsscId);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setMpId", long.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, mpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getScorder() {
		return _scorder;
	}

	@Override
	public void setScorder(int scorder) {
		_scorder = scorder;

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setScorder", int.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, scorder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScgId() {
		return _scgId;
	}

	@Override
	public void setScgId(String scgId) {
		_scgId = scgId;

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setScgId", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, scgId);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setScId", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, scId);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setParamType", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setParamFrom", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setParamUpto", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, duration);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDurationType", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
					durationType);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, status);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDateAdded", Date.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setDateModified", Date.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, extra1);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, extra2);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra3", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, extra3);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra4", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, extra4);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra5", Date.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, extra5);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra6", Date.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel, extra6);
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

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceCharges", float.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
					serviceCharges);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCostCurrency() {
		return _costCurrency;
	}

	@Override
	public void setCostCurrency(String costCurrency) {
		_costCurrency = costCurrency;

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setCostCurrency", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
					costCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCostPeriod() {
		return _costPeriod;
	}

	@Override
	public void setCostPeriod(String costPeriod) {
		_costPeriod = costPeriod;

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setCostPeriod", String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
					costPeriod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCostPeriodType() {
		return _costPeriodType;
	}

	@Override
	public void setCostPeriodType(String costPeriodType) {
		_costPeriodType = costPeriodType;

		if (_membershipPackageGrpServicesRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageGrpServicesRemoteModel.getClass();

				Method method = clazz.getMethod("setCostPeriodType",
						String.class);

				method.invoke(_membershipPackageGrpServicesRemoteModel,
					costPeriodType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMembershipPackageGrpServicesRemoteModel() {
		return _membershipPackageGrpServicesRemoteModel;
	}

	public void setMembershipPackageGrpServicesRemoteModel(
		BaseModel<?> membershipPackageGrpServicesRemoteModel) {
		_membershipPackageGrpServicesRemoteModel = membershipPackageGrpServicesRemoteModel;
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

		Class<?> remoteModelClass = _membershipPackageGrpServicesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_membershipPackageGrpServicesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MembershipPackageGrpServicesLocalServiceUtil.addMembershipPackageGrpServices(this);
		}
		else {
			MembershipPackageGrpServicesLocalServiceUtil.updateMembershipPackageGrpServices(this);
		}
	}

	@Override
	public MembershipPackageGrpServices toEscapedModel() {
		return (MembershipPackageGrpServices)ProxyUtil.newProxyInstance(MembershipPackageGrpServices.class.getClassLoader(),
			new Class[] { MembershipPackageGrpServices.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MembershipPackageGrpServicesClp clone = new MembershipPackageGrpServicesClp();

		clone.setMpgsscId(getMpgsscId());
		clone.setMpId(getMpId());
		clone.setScorder(getScorder());
		clone.setScgId(getScgId());
		clone.setScId(getScId());
		clone.setParamType(getParamType());
		clone.setParamFrom(getParamFrom());
		clone.setParamUpto(getParamUpto());
		clone.setDuration(getDuration());
		clone.setDurationType(getDurationType());
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
		clone.setServiceCharges(getServiceCharges());
		clone.setCostCurrency(getCostCurrency());
		clone.setCostPeriod(getCostPeriod());
		clone.setCostPeriodType(getCostPeriodType());

		return clone;
	}

	@Override
	public int compareTo(
		MembershipPackageGrpServices membershipPackageGrpServices) {
		int value = 0;

		value = getScgId().compareTo(membershipPackageGrpServices.getScgId());

		if (value != 0) {
			return value;
		}

		if (getScorder() < membershipPackageGrpServices.getScorder()) {
			value = -1;
		}
		else if (getScorder() > membershipPackageGrpServices.getScorder()) {
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

		if (!(obj instanceof MembershipPackageGrpServicesClp)) {
			return false;
		}

		MembershipPackageGrpServicesClp membershipPackageGrpServices = (MembershipPackageGrpServicesClp)obj;

		long primaryKey = membershipPackageGrpServices.getPrimaryKey();

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
		StringBundler sb = new StringBundler(53);

		sb.append("{mpgsscId=");
		sb.append(getMpgsscId());
		sb.append(", mpId=");
		sb.append(getMpId());
		sb.append(", scorder=");
		sb.append(getScorder());
		sb.append(", scgId=");
		sb.append(getScgId());
		sb.append(", scId=");
		sb.append(getScId());
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
		sb.append(", serviceCharges=");
		sb.append(getServiceCharges());
		sb.append(", costCurrency=");
		sb.append(getCostCurrency());
		sb.append(", costPeriod=");
		sb.append(getCostPeriod());
		sb.append(", costPeriodType=");
		sb.append(getCostPeriodType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mpgsscId</column-name><column-value><![CDATA[");
		sb.append(getMpgsscId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mpId</column-name><column-value><![CDATA[");
		sb.append(getMpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scorder</column-name><column-value><![CDATA[");
		sb.append(getScorder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scgId</column-name><column-value><![CDATA[");
		sb.append(getScgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scId</column-name><column-value><![CDATA[");
		sb.append(getScId());
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
		sb.append(
			"<column><column-name>serviceCharges</column-name><column-value><![CDATA[");
		sb.append(getServiceCharges());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costCurrency</column-name><column-value><![CDATA[");
		sb.append(getCostCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costPeriod</column-name><column-value><![CDATA[");
		sb.append(getCostPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costPeriodType</column-name><column-value><![CDATA[");
		sb.append(getCostPeriodType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mpgsscId;
	private long _mpId;
	private int _scorder;
	private String _scgId;
	private String _scId;
	private String _paramType;
	private String _paramFrom;
	private String _paramUpto;
	private String _duration;
	private String _durationType;
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
	private float _serviceCharges;
	private String _costCurrency;
	private String _costPeriod;
	private String _costPeriodType;
	private BaseModel<?> _membershipPackageGrpServicesRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}