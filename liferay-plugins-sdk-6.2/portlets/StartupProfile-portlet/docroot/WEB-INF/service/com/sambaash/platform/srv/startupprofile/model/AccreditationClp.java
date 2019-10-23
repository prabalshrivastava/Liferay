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

import com.sambaash.platform.srv.startupprofile.service.AccreditationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class AccreditationClp extends BaseModelImpl<Accreditation>
	implements Accreditation {
	public AccreditationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Accreditation.class;
	}

	@Override
	public String getModelClassName() {
		return Accreditation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _accreditationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAccreditationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _accreditationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("accreditationId", getAccreditationId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("aselected", getAselected());
		attributes.put("avalue", getAvalue());
		attributes.put("bselected", getBselected());
		attributes.put("bvalue", getBvalue());
		attributes.put("cselected", getCselected());
		attributes.put("cvalue", getCvalue());
		attributes.put("ccompanyName", getCcompanyName());
		attributes.put("csamepolicy", getCsamepolicy());
		attributes.put("celaborate", getCelaborate());
		attributes.put("dselected", getDselected());
		attributes.put("dvalue", getDvalue());
		attributes.put("accreditationStatus", getAccreditationStatus());
		attributes.put("dateOfAccreditation", getDateOfAccreditation());
		attributes.put("dateOfExpiry", getDateOfExpiry());
		attributes.put("latestPaymentDate", getLatestPaymentDate());
		attributes.put("startDateOfReaccreditation",
			getStartDateOfReaccreditation());
		attributes.put("dateOfReaccdtReview", getDateOfReaccdtReview());
		attributes.put("AccreditationBy", getAccreditationBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long accreditationId = (Long)attributes.get("accreditationId");

		if (accreditationId != null) {
			setAccreditationId(accreditationId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Boolean aselected = (Boolean)attributes.get("aselected");

		if (aselected != null) {
			setAselected(aselected);
		}

		String avalue = (String)attributes.get("avalue");

		if (avalue != null) {
			setAvalue(avalue);
		}

		Boolean bselected = (Boolean)attributes.get("bselected");

		if (bselected != null) {
			setBselected(bselected);
		}

		String bvalue = (String)attributes.get("bvalue");

		if (bvalue != null) {
			setBvalue(bvalue);
		}

		Boolean cselected = (Boolean)attributes.get("cselected");

		if (cselected != null) {
			setCselected(cselected);
		}

		String cvalue = (String)attributes.get("cvalue");

		if (cvalue != null) {
			setCvalue(cvalue);
		}

		String ccompanyName = (String)attributes.get("ccompanyName");

		if (ccompanyName != null) {
			setCcompanyName(ccompanyName);
		}

		Boolean csamepolicy = (Boolean)attributes.get("csamepolicy");

		if (csamepolicy != null) {
			setCsamepolicy(csamepolicy);
		}

		String celaborate = (String)attributes.get("celaborate");

		if (celaborate != null) {
			setCelaborate(celaborate);
		}

		Boolean dselected = (Boolean)attributes.get("dselected");

		if (dselected != null) {
			setDselected(dselected);
		}

		String dvalue = (String)attributes.get("dvalue");

		if (dvalue != null) {
			setDvalue(dvalue);
		}

		String accreditationStatus = (String)attributes.get(
				"accreditationStatus");

		if (accreditationStatus != null) {
			setAccreditationStatus(accreditationStatus);
		}

		Date dateOfAccreditation = (Date)attributes.get("dateOfAccreditation");

		if (dateOfAccreditation != null) {
			setDateOfAccreditation(dateOfAccreditation);
		}

		Date dateOfExpiry = (Date)attributes.get("dateOfExpiry");

		if (dateOfExpiry != null) {
			setDateOfExpiry(dateOfExpiry);
		}

		Date latestPaymentDate = (Date)attributes.get("latestPaymentDate");

		if (latestPaymentDate != null) {
			setLatestPaymentDate(latestPaymentDate);
		}

		Date startDateOfReaccreditation = (Date)attributes.get(
				"startDateOfReaccreditation");

		if (startDateOfReaccreditation != null) {
			setStartDateOfReaccreditation(startDateOfReaccreditation);
		}

		Date dateOfReaccdtReview = (Date)attributes.get("dateOfReaccdtReview");

		if (dateOfReaccdtReview != null) {
			setDateOfReaccdtReview(dateOfReaccdtReview);
		}

		String AccreditationBy = (String)attributes.get("AccreditationBy");

		if (AccreditationBy != null) {
			setAccreditationBy(AccreditationBy);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_accreditationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAccreditationId() {
		return _accreditationId;
	}

	@Override
	public void setAccreditationId(long accreditationId) {
		_accreditationId = accreditationId;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setAccreditationId", long.class);

				method.invoke(_accreditationRemoteModel, accreditationId);
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

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_accreditationRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAselected() {
		return _aselected;
	}

	@Override
	public boolean isAselected() {
		return _aselected;
	}

	@Override
	public void setAselected(boolean aselected) {
		_aselected = aselected;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setAselected", boolean.class);

				method.invoke(_accreditationRemoteModel, aselected);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAvalue() {
		return _avalue;
	}

	@Override
	public void setAvalue(String avalue) {
		_avalue = avalue;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setAvalue", String.class);

				method.invoke(_accreditationRemoteModel, avalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBselected() {
		return _bselected;
	}

	@Override
	public boolean isBselected() {
		return _bselected;
	}

	@Override
	public void setBselected(boolean bselected) {
		_bselected = bselected;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setBselected", boolean.class);

				method.invoke(_accreditationRemoteModel, bselected);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBvalue() {
		return _bvalue;
	}

	@Override
	public void setBvalue(String bvalue) {
		_bvalue = bvalue;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setBvalue", String.class);

				method.invoke(_accreditationRemoteModel, bvalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCselected() {
		return _cselected;
	}

	@Override
	public boolean isCselected() {
		return _cselected;
	}

	@Override
	public void setCselected(boolean cselected) {
		_cselected = cselected;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setCselected", boolean.class);

				method.invoke(_accreditationRemoteModel, cselected);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCvalue() {
		return _cvalue;
	}

	@Override
	public void setCvalue(String cvalue) {
		_cvalue = cvalue;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setCvalue", String.class);

				method.invoke(_accreditationRemoteModel, cvalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCcompanyName() {
		return _ccompanyName;
	}

	@Override
	public void setCcompanyName(String ccompanyName) {
		_ccompanyName = ccompanyName;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setCcompanyName", String.class);

				method.invoke(_accreditationRemoteModel, ccompanyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCsamepolicy() {
		return _csamepolicy;
	}

	@Override
	public boolean isCsamepolicy() {
		return _csamepolicy;
	}

	@Override
	public void setCsamepolicy(boolean csamepolicy) {
		_csamepolicy = csamepolicy;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setCsamepolicy", boolean.class);

				method.invoke(_accreditationRemoteModel, csamepolicy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCelaborate() {
		return _celaborate;
	}

	@Override
	public void setCelaborate(String celaborate) {
		_celaborate = celaborate;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setCelaborate", String.class);

				method.invoke(_accreditationRemoteModel, celaborate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDselected() {
		return _dselected;
	}

	@Override
	public boolean isDselected() {
		return _dselected;
	}

	@Override
	public void setDselected(boolean dselected) {
		_dselected = dselected;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setDselected", boolean.class);

				method.invoke(_accreditationRemoteModel, dselected);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDvalue() {
		return _dvalue;
	}

	@Override
	public void setDvalue(String dvalue) {
		_dvalue = dvalue;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setDvalue", String.class);

				method.invoke(_accreditationRemoteModel, dvalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccreditationStatus() {
		return _accreditationStatus;
	}

	@Override
	public void setAccreditationStatus(String accreditationStatus) {
		_accreditationStatus = accreditationStatus;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setAccreditationStatus",
						String.class);

				method.invoke(_accreditationRemoteModel, accreditationStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateOfAccreditation() {
		return _dateOfAccreditation;
	}

	@Override
	public void setDateOfAccreditation(Date dateOfAccreditation) {
		_dateOfAccreditation = dateOfAccreditation;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfAccreditation",
						Date.class);

				method.invoke(_accreditationRemoteModel, dateOfAccreditation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateOfExpiry() {
		return _dateOfExpiry;
	}

	@Override
	public void setDateOfExpiry(Date dateOfExpiry) {
		_dateOfExpiry = dateOfExpiry;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfExpiry", Date.class);

				method.invoke(_accreditationRemoteModel, dateOfExpiry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLatestPaymentDate() {
		return _latestPaymentDate;
	}

	@Override
	public void setLatestPaymentDate(Date latestPaymentDate) {
		_latestPaymentDate = latestPaymentDate;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setLatestPaymentDate",
						Date.class);

				method.invoke(_accreditationRemoteModel, latestPaymentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDateOfReaccreditation() {
		return _startDateOfReaccreditation;
	}

	@Override
	public void setStartDateOfReaccreditation(Date startDateOfReaccreditation) {
		_startDateOfReaccreditation = startDateOfReaccreditation;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDateOfReaccreditation",
						Date.class);

				method.invoke(_accreditationRemoteModel,
					startDateOfReaccreditation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateOfReaccdtReview() {
		return _dateOfReaccdtReview;
	}

	@Override
	public void setDateOfReaccdtReview(Date dateOfReaccdtReview) {
		_dateOfReaccdtReview = dateOfReaccdtReview;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfReaccdtReview",
						Date.class);

				method.invoke(_accreditationRemoteModel, dateOfReaccdtReview);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccreditationBy() {
		return _AccreditationBy;
	}

	@Override
	public void setAccreditationBy(String AccreditationBy) {
		_AccreditationBy = AccreditationBy;

		if (_accreditationRemoteModel != null) {
			try {
				Class<?> clazz = _accreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setAccreditationBy",
						String.class);

				method.invoke(_accreditationRemoteModel, AccreditationBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAccreditationRemoteModel() {
		return _accreditationRemoteModel;
	}

	public void setAccreditationRemoteModel(
		BaseModel<?> accreditationRemoteModel) {
		_accreditationRemoteModel = accreditationRemoteModel;
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

		Class<?> remoteModelClass = _accreditationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_accreditationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AccreditationLocalServiceUtil.addAccreditation(this);
		}
		else {
			AccreditationLocalServiceUtil.updateAccreditation(this);
		}
	}

	@Override
	public Accreditation toEscapedModel() {
		return (Accreditation)ProxyUtil.newProxyInstance(Accreditation.class.getClassLoader(),
			new Class[] { Accreditation.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AccreditationClp clone = new AccreditationClp();

		clone.setUuid(getUuid());
		clone.setAccreditationId(getAccreditationId());
		clone.setOrganizationId(getOrganizationId());
		clone.setAselected(getAselected());
		clone.setAvalue(getAvalue());
		clone.setBselected(getBselected());
		clone.setBvalue(getBvalue());
		clone.setCselected(getCselected());
		clone.setCvalue(getCvalue());
		clone.setCcompanyName(getCcompanyName());
		clone.setCsamepolicy(getCsamepolicy());
		clone.setCelaborate(getCelaborate());
		clone.setDselected(getDselected());
		clone.setDvalue(getDvalue());
		clone.setAccreditationStatus(getAccreditationStatus());
		clone.setDateOfAccreditation(getDateOfAccreditation());
		clone.setDateOfExpiry(getDateOfExpiry());
		clone.setLatestPaymentDate(getLatestPaymentDate());
		clone.setStartDateOfReaccreditation(getStartDateOfReaccreditation());
		clone.setDateOfReaccdtReview(getDateOfReaccdtReview());
		clone.setAccreditationBy(getAccreditationBy());

		return clone;
	}

	@Override
	public int compareTo(Accreditation accreditation) {
		long primaryKey = accreditation.getPrimaryKey();

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

		if (!(obj instanceof AccreditationClp)) {
			return false;
		}

		AccreditationClp accreditation = (AccreditationClp)obj;

		long primaryKey = accreditation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", accreditationId=");
		sb.append(getAccreditationId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", aselected=");
		sb.append(getAselected());
		sb.append(", avalue=");
		sb.append(getAvalue());
		sb.append(", bselected=");
		sb.append(getBselected());
		sb.append(", bvalue=");
		sb.append(getBvalue());
		sb.append(", cselected=");
		sb.append(getCselected());
		sb.append(", cvalue=");
		sb.append(getCvalue());
		sb.append(", ccompanyName=");
		sb.append(getCcompanyName());
		sb.append(", csamepolicy=");
		sb.append(getCsamepolicy());
		sb.append(", celaborate=");
		sb.append(getCelaborate());
		sb.append(", dselected=");
		sb.append(getDselected());
		sb.append(", dvalue=");
		sb.append(getDvalue());
		sb.append(", accreditationStatus=");
		sb.append(getAccreditationStatus());
		sb.append(", dateOfAccreditation=");
		sb.append(getDateOfAccreditation());
		sb.append(", dateOfExpiry=");
		sb.append(getDateOfExpiry());
		sb.append(", latestPaymentDate=");
		sb.append(getLatestPaymentDate());
		sb.append(", startDateOfReaccreditation=");
		sb.append(getStartDateOfReaccreditation());
		sb.append(", dateOfReaccdtReview=");
		sb.append(getDateOfReaccdtReview());
		sb.append(", AccreditationBy=");
		sb.append(getAccreditationBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.Accreditation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accreditationId</column-name><column-value><![CDATA[");
		sb.append(getAccreditationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aselected</column-name><column-value><![CDATA[");
		sb.append(getAselected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>avalue</column-name><column-value><![CDATA[");
		sb.append(getAvalue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bselected</column-name><column-value><![CDATA[");
		sb.append(getBselected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bvalue</column-name><column-value><![CDATA[");
		sb.append(getBvalue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cselected</column-name><column-value><![CDATA[");
		sb.append(getCselected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cvalue</column-name><column-value><![CDATA[");
		sb.append(getCvalue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccompanyName</column-name><column-value><![CDATA[");
		sb.append(getCcompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>csamepolicy</column-name><column-value><![CDATA[");
		sb.append(getCsamepolicy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>celaborate</column-name><column-value><![CDATA[");
		sb.append(getCelaborate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dselected</column-name><column-value><![CDATA[");
		sb.append(getDselected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dvalue</column-name><column-value><![CDATA[");
		sb.append(getDvalue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accreditationStatus</column-name><column-value><![CDATA[");
		sb.append(getAccreditationStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfAccreditation</column-name><column-value><![CDATA[");
		sb.append(getDateOfAccreditation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfExpiry</column-name><column-value><![CDATA[");
		sb.append(getDateOfExpiry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latestPaymentDate</column-name><column-value><![CDATA[");
		sb.append(getLatestPaymentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDateOfReaccreditation</column-name><column-value><![CDATA[");
		sb.append(getStartDateOfReaccreditation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfReaccdtReview</column-name><column-value><![CDATA[");
		sb.append(getDateOfReaccdtReview());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AccreditationBy</column-name><column-value><![CDATA[");
		sb.append(getAccreditationBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _accreditationId;
	private long _organizationId;
	private boolean _aselected;
	private String _avalue;
	private boolean _bselected;
	private String _bvalue;
	private boolean _cselected;
	private String _cvalue;
	private String _ccompanyName;
	private boolean _csamepolicy;
	private String _celaborate;
	private boolean _dselected;
	private String _dvalue;
	private String _accreditationStatus;
	private Date _dateOfAccreditation;
	private Date _dateOfExpiry;
	private Date _latestPaymentDate;
	private Date _startDateOfReaccreditation;
	private Date _dateOfReaccdtReview;
	private String _AccreditationBy;
	private BaseModel<?> _accreditationRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}