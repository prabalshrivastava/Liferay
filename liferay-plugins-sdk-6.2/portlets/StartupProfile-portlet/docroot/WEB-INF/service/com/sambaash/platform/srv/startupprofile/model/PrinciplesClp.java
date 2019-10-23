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
import com.sambaash.platform.srv.startupprofile.service.PrinciplesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class PrinciplesClp extends BaseModelImpl<Principles>
	implements Principles {
	public PrinciplesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Principles.class;
	}

	@Override
	public String getModelClassName() {
		return Principles.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _principleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPrincipleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _principleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("siteId", getSiteId());
		attributes.put("principleId", getPrincipleId());
		attributes.put("principleText", getPrincipleText());
		attributes.put("guideline1", getGuideline1());
		attributes.put("guideline2", getGuideline2());
		attributes.put("guideline3", getGuideline3());
		attributes.put("guideline4", getGuideline4());
		attributes.put("guideline5", getGuideline5());
		attributes.put("guideline6", getGuideline6());
		attributes.put("guideline7", getGuideline7());
		attributes.put("guideline8", getGuideline8());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long siteId = (Long)attributes.get("siteId");

		if (siteId != null) {
			setSiteId(siteId);
		}

		Long principleId = (Long)attributes.get("principleId");

		if (principleId != null) {
			setPrincipleId(principleId);
		}

		String principleText = (String)attributes.get("principleText");

		if (principleText != null) {
			setPrincipleText(principleText);
		}

		String guideline1 = (String)attributes.get("guideline1");

		if (guideline1 != null) {
			setGuideline1(guideline1);
		}

		String guideline2 = (String)attributes.get("guideline2");

		if (guideline2 != null) {
			setGuideline2(guideline2);
		}

		String guideline3 = (String)attributes.get("guideline3");

		if (guideline3 != null) {
			setGuideline3(guideline3);
		}

		String guideline4 = (String)attributes.get("guideline4");

		if (guideline4 != null) {
			setGuideline4(guideline4);
		}

		String guideline5 = (String)attributes.get("guideline5");

		if (guideline5 != null) {
			setGuideline5(guideline5);
		}

		String guideline6 = (String)attributes.get("guideline6");

		if (guideline6 != null) {
			setGuideline6(guideline6);
		}

		String guideline7 = (String)attributes.get("guideline7");

		if (guideline7 != null) {
			setGuideline7(guideline7);
		}

		String guideline8 = (String)attributes.get("guideline8");

		if (guideline8 != null) {
			setGuideline8(guideline8);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_principlesRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSiteId() {
		return _siteId;
	}

	@Override
	public void setSiteId(long siteId) {
		_siteId = siteId;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setSiteId", long.class);

				method.invoke(_principlesRemoteModel, siteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPrincipleId() {
		return _principleId;
	}

	@Override
	public void setPrincipleId(long principleId) {
		_principleId = principleId;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipleId", long.class);

				method.invoke(_principlesRemoteModel, principleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipleText() {
		return _principleText;
	}

	@Override
	public void setPrincipleText(String principleText) {
		_principleText = principleText;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipleText", String.class);

				method.invoke(_principlesRemoteModel, principleText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuideline1() {
		return _guideline1;
	}

	@Override
	public void setGuideline1(String guideline1) {
		_guideline1 = guideline1;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline1", String.class);

				method.invoke(_principlesRemoteModel, guideline1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuideline2() {
		return _guideline2;
	}

	@Override
	public void setGuideline2(String guideline2) {
		_guideline2 = guideline2;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline2", String.class);

				method.invoke(_principlesRemoteModel, guideline2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuideline3() {
		return _guideline3;
	}

	@Override
	public void setGuideline3(String guideline3) {
		_guideline3 = guideline3;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline3", String.class);

				method.invoke(_principlesRemoteModel, guideline3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuideline4() {
		return _guideline4;
	}

	@Override
	public void setGuideline4(String guideline4) {
		_guideline4 = guideline4;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline4", String.class);

				method.invoke(_principlesRemoteModel, guideline4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuideline5() {
		return _guideline5;
	}

	@Override
	public void setGuideline5(String guideline5) {
		_guideline5 = guideline5;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline5", String.class);

				method.invoke(_principlesRemoteModel, guideline5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuideline6() {
		return _guideline6;
	}

	@Override
	public void setGuideline6(String guideline6) {
		_guideline6 = guideline6;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline6", String.class);

				method.invoke(_principlesRemoteModel, guideline6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuideline7() {
		return _guideline7;
	}

	@Override
	public void setGuideline7(String guideline7) {
		_guideline7 = guideline7;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline7", String.class);

				method.invoke(_principlesRemoteModel, guideline7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGuideline8() {
		return _guideline8;
	}

	@Override
	public void setGuideline8(String guideline8) {
		_guideline8 = guideline8;

		if (_principlesRemoteModel != null) {
			try {
				Class<?> clazz = _principlesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline8", String.class);

				method.invoke(_principlesRemoteModel, guideline8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPrinciplesRemoteModel() {
		return _principlesRemoteModel;
	}

	public void setPrinciplesRemoteModel(BaseModel<?> principlesRemoteModel) {
		_principlesRemoteModel = principlesRemoteModel;
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

		Class<?> remoteModelClass = _principlesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_principlesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PrinciplesLocalServiceUtil.addPrinciples(this);
		}
		else {
			PrinciplesLocalServiceUtil.updatePrinciples(this);
		}
	}

	@Override
	public Principles toEscapedModel() {
		return (Principles)ProxyUtil.newProxyInstance(Principles.class.getClassLoader(),
			new Class[] { Principles.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PrinciplesClp clone = new PrinciplesClp();

		clone.setUuid(getUuid());
		clone.setSiteId(getSiteId());
		clone.setPrincipleId(getPrincipleId());
		clone.setPrincipleText(getPrincipleText());
		clone.setGuideline1(getGuideline1());
		clone.setGuideline2(getGuideline2());
		clone.setGuideline3(getGuideline3());
		clone.setGuideline4(getGuideline4());
		clone.setGuideline5(getGuideline5());
		clone.setGuideline6(getGuideline6());
		clone.setGuideline7(getGuideline7());
		clone.setGuideline8(getGuideline8());

		return clone;
	}

	@Override
	public int compareTo(Principles principles) {
		long primaryKey = principles.getPrimaryKey();

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

		if (!(obj instanceof PrinciplesClp)) {
			return false;
		}

		PrinciplesClp principles = (PrinciplesClp)obj;

		long primaryKey = principles.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", siteId=");
		sb.append(getSiteId());
		sb.append(", principleId=");
		sb.append(getPrincipleId());
		sb.append(", principleText=");
		sb.append(getPrincipleText());
		sb.append(", guideline1=");
		sb.append(getGuideline1());
		sb.append(", guideline2=");
		sb.append(getGuideline2());
		sb.append(", guideline3=");
		sb.append(getGuideline3());
		sb.append(", guideline4=");
		sb.append(getGuideline4());
		sb.append(", guideline5=");
		sb.append(getGuideline5());
		sb.append(", guideline6=");
		sb.append(getGuideline6());
		sb.append(", guideline7=");
		sb.append(getGuideline7());
		sb.append(", guideline8=");
		sb.append(getGuideline8());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.startupprofile.model.Principles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteId</column-name><column-value><![CDATA[");
		sb.append(getSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principleId</column-name><column-value><![CDATA[");
		sb.append(getPrincipleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principleText</column-name><column-value><![CDATA[");
		sb.append(getPrincipleText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guideline1</column-name><column-value><![CDATA[");
		sb.append(getGuideline1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guideline2</column-name><column-value><![CDATA[");
		sb.append(getGuideline2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guideline3</column-name><column-value><![CDATA[");
		sb.append(getGuideline3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guideline4</column-name><column-value><![CDATA[");
		sb.append(getGuideline4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guideline5</column-name><column-value><![CDATA[");
		sb.append(getGuideline5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guideline6</column-name><column-value><![CDATA[");
		sb.append(getGuideline6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guideline7</column-name><column-value><![CDATA[");
		sb.append(getGuideline7());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guideline8</column-name><column-value><![CDATA[");
		sb.append(getGuideline8());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _siteId;
	private long _principleId;
	private String _principleText;
	private String _guideline1;
	private String _guideline2;
	private String _guideline3;
	private String _guideline4;
	private String _guideline5;
	private String _guideline6;
	private String _guideline7;
	private String _guideline8;
	private BaseModel<?> _principlesRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}