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

package com.sambaash.platform.srv.spjob.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spjob.service.ClpSerializer;
import com.sambaash.platform.srv.spjob.service.SPJobApplicantsPortfolioLocalServiceUtil;
import com.sambaash.platform.srv.spjob.service.persistence.SPJobApplicantsPortfolioPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author harini
 */
public class SPJobApplicantsPortfolioClp extends BaseModelImpl<SPJobApplicantsPortfolio>
	implements SPJobApplicantsPortfolio {
	public SPJobApplicantsPortfolioClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPJobApplicantsPortfolio.class;
	}

	@Override
	public String getModelClassName() {
		return SPJobApplicantsPortfolio.class.getName();
	}

	@Override
	public SPJobApplicantsPortfolioPK getPrimaryKey() {
		return new SPJobApplicantsPortfolioPK(_jobApplyId, _porfolioId);
	}

	@Override
	public void setPrimaryKey(SPJobApplicantsPortfolioPK primaryKey) {
		setJobApplyId(primaryKey.jobApplyId);
		setPorfolioId(primaryKey.porfolioId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SPJobApplicantsPortfolioPK(_jobApplyId, _porfolioId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SPJobApplicantsPortfolioPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobApplyId", getJobApplyId());
		attributes.put("porfolioId", getPorfolioId());
		attributes.put("userId", getUserId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobApplyId = (Long)attributes.get("jobApplyId");

		if (jobApplyId != null) {
			setJobApplyId(jobApplyId);
		}

		Long porfolioId = (Long)attributes.get("porfolioId");

		if (porfolioId != null) {
			setPorfolioId(porfolioId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long updatedBy = (Long)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}
	}

	@Override
	public long getJobApplyId() {
		return _jobApplyId;
	}

	@Override
	public void setJobApplyId(long jobApplyId) {
		_jobApplyId = jobApplyId;

		if (_spJobApplicantsPortfolioRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsPortfolioRemoteModel.getClass();

				Method method = clazz.getMethod("setJobApplyId", long.class);

				method.invoke(_spJobApplicantsPortfolioRemoteModel, jobApplyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPorfolioId() {
		return _porfolioId;
	}

	@Override
	public void setPorfolioId(long porfolioId) {
		_porfolioId = porfolioId;

		if (_spJobApplicantsPortfolioRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsPortfolioRemoteModel.getClass();

				Method method = clazz.getMethod("setPorfolioId", long.class);

				method.invoke(_spJobApplicantsPortfolioRemoteModel, porfolioId);
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

		if (_spJobApplicantsPortfolioRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsPortfolioRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spJobApplicantsPortfolioRemoteModel, userId);
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
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_spJobApplicantsPortfolioRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsPortfolioRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_spJobApplicantsPortfolioRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUpdatedBy() {
		return _updatedBy;
	}

	@Override
	public void setUpdatedBy(long updatedBy) {
		_updatedBy = updatedBy;

		if (_spJobApplicantsPortfolioRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsPortfolioRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", long.class);

				method.invoke(_spJobApplicantsPortfolioRemoteModel, updatedBy);
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

		if (_spJobApplicantsPortfolioRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsPortfolioRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spJobApplicantsPortfolioRemoteModel, createDate);
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

		if (_spJobApplicantsPortfolioRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsPortfolioRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spJobApplicantsPortfolioRemoteModel, modifiedDate);
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

		if (_spJobApplicantsPortfolioRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsPortfolioRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_spJobApplicantsPortfolioRemoteModel, extra1);
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

		if (_spJobApplicantsPortfolioRemoteModel != null) {
			try {
				Class<?> clazz = _spJobApplicantsPortfolioRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_spJobApplicantsPortfolioRemoteModel, extra2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPJobApplicantsPortfolioRemoteModel() {
		return _spJobApplicantsPortfolioRemoteModel;
	}

	public void setSPJobApplicantsPortfolioRemoteModel(
		BaseModel<?> spJobApplicantsPortfolioRemoteModel) {
		_spJobApplicantsPortfolioRemoteModel = spJobApplicantsPortfolioRemoteModel;
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

		Class<?> remoteModelClass = _spJobApplicantsPortfolioRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spJobApplicantsPortfolioRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPJobApplicantsPortfolioLocalServiceUtil.addSPJobApplicantsPortfolio(this);
		}
		else {
			SPJobApplicantsPortfolioLocalServiceUtil.updateSPJobApplicantsPortfolio(this);
		}
	}

	@Override
	public SPJobApplicantsPortfolio toEscapedModel() {
		return (SPJobApplicantsPortfolio)ProxyUtil.newProxyInstance(SPJobApplicantsPortfolio.class.getClassLoader(),
			new Class[] { SPJobApplicantsPortfolio.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPJobApplicantsPortfolioClp clone = new SPJobApplicantsPortfolioClp();

		clone.setJobApplyId(getJobApplyId());
		clone.setPorfolioId(getPorfolioId());
		clone.setUserId(getUserId());
		clone.setCreatedBy(getCreatedBy());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setExtra1(getExtra1());
		clone.setExtra2(getExtra2());

		return clone;
	}

	@Override
	public int compareTo(SPJobApplicantsPortfolio spJobApplicantsPortfolio) {
		SPJobApplicantsPortfolioPK primaryKey = spJobApplicantsPortfolio.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPJobApplicantsPortfolioClp)) {
			return false;
		}

		SPJobApplicantsPortfolioClp spJobApplicantsPortfolio = (SPJobApplicantsPortfolioClp)obj;

		SPJobApplicantsPortfolioPK primaryKey = spJobApplicantsPortfolio.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{jobApplyId=");
		sb.append(getJobApplyId());
		sb.append(", porfolioId=");
		sb.append(getPorfolioId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", extra1=");
		sb.append(getExtra1());
		sb.append(", extra2=");
		sb.append(getExtra2());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jobApplyId</column-name><column-value><![CDATA[");
		sb.append(getJobApplyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>porfolioId</column-name><column-value><![CDATA[");
		sb.append(getPorfolioId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
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
			"<column><column-name>extra1</column-name><column-value><![CDATA[");
		sb.append(getExtra1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra2</column-name><column-value><![CDATA[");
		sb.append(getExtra2());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _jobApplyId;
	private long _porfolioId;
	private long _userId;
	private String _userUuid;
	private long _createdBy;
	private long _updatedBy;
	private Date _createDate;
	private Date _modifiedDate;
	private String _extra1;
	private String _extra2;
	private BaseModel<?> _spJobApplicantsPortfolioRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spjob.service.ClpSerializer.class;
}