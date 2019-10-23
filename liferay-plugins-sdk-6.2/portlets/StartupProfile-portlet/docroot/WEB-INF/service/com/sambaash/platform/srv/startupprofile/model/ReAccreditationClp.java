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

import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.ReAccreditationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class ReAccreditationClp extends BaseModelImpl<ReAccreditation>
	implements ReAccreditation {
	public ReAccreditationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ReAccreditation.class;
	}

	@Override
	public String getModelClassName() {
		return ReAccreditation.class.getName();
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_reAccreditationRemoteModel, uuid);
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setAccreditationId", long.class);

				method.invoke(_reAccreditationRemoteModel, accreditationId);
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_reAccreditationRemoteModel, organizationId);
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setAccreditationStatus",
						String.class);

				method.invoke(_reAccreditationRemoteModel, accreditationStatus);
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfAccreditation",
						Date.class);

				method.invoke(_reAccreditationRemoteModel, dateOfAccreditation);
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfExpiry", Date.class);

				method.invoke(_reAccreditationRemoteModel, dateOfExpiry);
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setLatestPaymentDate",
						Date.class);

				method.invoke(_reAccreditationRemoteModel, latestPaymentDate);
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDateOfReaccreditation",
						Date.class);

				method.invoke(_reAccreditationRemoteModel,
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfReaccdtReview",
						Date.class);

				method.invoke(_reAccreditationRemoteModel, dateOfReaccdtReview);
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

		if (_reAccreditationRemoteModel != null) {
			try {
				Class<?> clazz = _reAccreditationRemoteModel.getClass();

				Method method = clazz.getMethod("setAccreditationBy",
						String.class);

				method.invoke(_reAccreditationRemoteModel, AccreditationBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getReAccreditationRemoteModel() {
		return _reAccreditationRemoteModel;
	}

	public void setReAccreditationRemoteModel(
		BaseModel<?> reAccreditationRemoteModel) {
		_reAccreditationRemoteModel = reAccreditationRemoteModel;
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

		Class<?> remoteModelClass = _reAccreditationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_reAccreditationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ReAccreditationLocalServiceUtil.addReAccreditation(this);
		}
		else {
			ReAccreditationLocalServiceUtil.updateReAccreditation(this);
		}
	}

	@Override
	public ReAccreditation toEscapedModel() {
		return (ReAccreditation)ProxyUtil.newProxyInstance(ReAccreditation.class.getClassLoader(),
			new Class[] { ReAccreditation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ReAccreditationClp clone = new ReAccreditationClp();

		clone.setUuid(getUuid());
		clone.setAccreditationId(getAccreditationId());
		clone.setOrganizationId(getOrganizationId());
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
	public int compareTo(ReAccreditation reAccreditation) {
		long primaryKey = reAccreditation.getPrimaryKey();

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

		if (!(obj instanceof ReAccreditationClp)) {
			return false;
		}

		ReAccreditationClp reAccreditation = (ReAccreditationClp)obj;

		long primaryKey = reAccreditation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", accreditationId=");
		sb.append(getAccreditationId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.ReAccreditation");
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
	private String _accreditationStatus;
	private Date _dateOfAccreditation;
	private Date _dateOfExpiry;
	private Date _latestPaymentDate;
	private Date _startDateOfReaccreditation;
	private Date _dateOfReaccdtReview;
	private String _AccreditationBy;
	private BaseModel<?> _reAccreditationRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}