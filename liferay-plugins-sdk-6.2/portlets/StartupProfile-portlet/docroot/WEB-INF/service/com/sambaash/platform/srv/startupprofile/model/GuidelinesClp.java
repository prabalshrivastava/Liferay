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
import com.sambaash.platform.srv.startupprofile.service.GuidelinesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class GuidelinesClp extends BaseModelImpl<Guidelines>
	implements Guidelines {
	public GuidelinesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Guidelines.class;
	}

	@Override
	public String getModelClassName() {
		return Guidelines.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _guidelineId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGuidelineId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _guidelineId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("guidelineId", getGuidelineId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("principleId", getPrincipleId());
		attributes.put("guideline1", getGuideline1());
		attributes.put("guideline2", getGuideline2());
		attributes.put("guideline3", getGuideline3());
		attributes.put("guideline4", getGuideline4());
		attributes.put("guideline5", getGuideline5());
		attributes.put("guideline6", getGuideline6());
		attributes.put("guideline7", getGuideline7());
		attributes.put("guideline8", getGuideline8());
		attributes.put("moreInfo", getMoreInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long guidelineId = (Long)attributes.get("guidelineId");

		if (guidelineId != null) {
			setGuidelineId(guidelineId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long principleId = (Long)attributes.get("principleId");

		if (principleId != null) {
			setPrincipleId(principleId);
		}

		Boolean guideline1 = (Boolean)attributes.get("guideline1");

		if (guideline1 != null) {
			setGuideline1(guideline1);
		}

		Boolean guideline2 = (Boolean)attributes.get("guideline2");

		if (guideline2 != null) {
			setGuideline2(guideline2);
		}

		Boolean guideline3 = (Boolean)attributes.get("guideline3");

		if (guideline3 != null) {
			setGuideline3(guideline3);
		}

		Boolean guideline4 = (Boolean)attributes.get("guideline4");

		if (guideline4 != null) {
			setGuideline4(guideline4);
		}

		Boolean guideline5 = (Boolean)attributes.get("guideline5");

		if (guideline5 != null) {
			setGuideline5(guideline5);
		}

		Boolean guideline6 = (Boolean)attributes.get("guideline6");

		if (guideline6 != null) {
			setGuideline6(guideline6);
		}

		Boolean guideline7 = (Boolean)attributes.get("guideline7");

		if (guideline7 != null) {
			setGuideline7(guideline7);
		}

		Boolean guideline8 = (Boolean)attributes.get("guideline8");

		if (guideline8 != null) {
			setGuideline8(guideline8);
		}

		String moreInfo = (String)attributes.get("moreInfo");

		if (moreInfo != null) {
			setMoreInfo(moreInfo);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_guidelinesRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGuidelineId() {
		return _guidelineId;
	}

	@Override
	public void setGuidelineId(long guidelineId) {
		_guidelineId = guidelineId;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuidelineId", long.class);

				method.invoke(_guidelinesRemoteModel, guidelineId);
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

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_guidelinesRemoteModel, organizationId);
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

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipleId", long.class);

				method.invoke(_guidelinesRemoteModel, principleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGuideline1() {
		return _guideline1;
	}

	@Override
	public boolean isGuideline1() {
		return _guideline1;
	}

	@Override
	public void setGuideline1(boolean guideline1) {
		_guideline1 = guideline1;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline1", boolean.class);

				method.invoke(_guidelinesRemoteModel, guideline1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGuideline2() {
		return _guideline2;
	}

	@Override
	public boolean isGuideline2() {
		return _guideline2;
	}

	@Override
	public void setGuideline2(boolean guideline2) {
		_guideline2 = guideline2;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline2", boolean.class);

				method.invoke(_guidelinesRemoteModel, guideline2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGuideline3() {
		return _guideline3;
	}

	@Override
	public boolean isGuideline3() {
		return _guideline3;
	}

	@Override
	public void setGuideline3(boolean guideline3) {
		_guideline3 = guideline3;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline3", boolean.class);

				method.invoke(_guidelinesRemoteModel, guideline3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGuideline4() {
		return _guideline4;
	}

	@Override
	public boolean isGuideline4() {
		return _guideline4;
	}

	@Override
	public void setGuideline4(boolean guideline4) {
		_guideline4 = guideline4;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline4", boolean.class);

				method.invoke(_guidelinesRemoteModel, guideline4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGuideline5() {
		return _guideline5;
	}

	@Override
	public boolean isGuideline5() {
		return _guideline5;
	}

	@Override
	public void setGuideline5(boolean guideline5) {
		_guideline5 = guideline5;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline5", boolean.class);

				method.invoke(_guidelinesRemoteModel, guideline5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGuideline6() {
		return _guideline6;
	}

	@Override
	public boolean isGuideline6() {
		return _guideline6;
	}

	@Override
	public void setGuideline6(boolean guideline6) {
		_guideline6 = guideline6;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline6", boolean.class);

				method.invoke(_guidelinesRemoteModel, guideline6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGuideline7() {
		return _guideline7;
	}

	@Override
	public boolean isGuideline7() {
		return _guideline7;
	}

	@Override
	public void setGuideline7(boolean guideline7) {
		_guideline7 = guideline7;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline7", boolean.class);

				method.invoke(_guidelinesRemoteModel, guideline7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGuideline8() {
		return _guideline8;
	}

	@Override
	public boolean isGuideline8() {
		return _guideline8;
	}

	@Override
	public void setGuideline8(boolean guideline8) {
		_guideline8 = guideline8;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setGuideline8", boolean.class);

				method.invoke(_guidelinesRemoteModel, guideline8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMoreInfo() {
		return _moreInfo;
	}

	@Override
	public void setMoreInfo(String moreInfo) {
		_moreInfo = moreInfo;

		if (_guidelinesRemoteModel != null) {
			try {
				Class<?> clazz = _guidelinesRemoteModel.getClass();

				Method method = clazz.getMethod("setMoreInfo", String.class);

				method.invoke(_guidelinesRemoteModel, moreInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGuidelinesRemoteModel() {
		return _guidelinesRemoteModel;
	}

	public void setGuidelinesRemoteModel(BaseModel<?> guidelinesRemoteModel) {
		_guidelinesRemoteModel = guidelinesRemoteModel;
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

		Class<?> remoteModelClass = _guidelinesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_guidelinesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GuidelinesLocalServiceUtil.addGuidelines(this);
		}
		else {
			GuidelinesLocalServiceUtil.updateGuidelines(this);
		}
	}

	@Override
	public Guidelines toEscapedModel() {
		return (Guidelines)ProxyUtil.newProxyInstance(Guidelines.class.getClassLoader(),
			new Class[] { Guidelines.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GuidelinesClp clone = new GuidelinesClp();

		clone.setUuid(getUuid());
		clone.setGuidelineId(getGuidelineId());
		clone.setOrganizationId(getOrganizationId());
		clone.setPrincipleId(getPrincipleId());
		clone.setGuideline1(getGuideline1());
		clone.setGuideline2(getGuideline2());
		clone.setGuideline3(getGuideline3());
		clone.setGuideline4(getGuideline4());
		clone.setGuideline5(getGuideline5());
		clone.setGuideline6(getGuideline6());
		clone.setGuideline7(getGuideline7());
		clone.setGuideline8(getGuideline8());
		clone.setMoreInfo(getMoreInfo());

		return clone;
	}

	@Override
	public int compareTo(Guidelines guidelines) {
		long primaryKey = guidelines.getPrimaryKey();

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

		if (!(obj instanceof GuidelinesClp)) {
			return false;
		}

		GuidelinesClp guidelines = (GuidelinesClp)obj;

		long primaryKey = guidelines.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", guidelineId=");
		sb.append(getGuidelineId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", principleId=");
		sb.append(getPrincipleId());
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
		sb.append(", moreInfo=");
		sb.append(getMoreInfo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.startupprofile.model.Guidelines");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guidelineId</column-name><column-value><![CDATA[");
		sb.append(getGuidelineId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principleId</column-name><column-value><![CDATA[");
		sb.append(getPrincipleId());
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
		sb.append(
			"<column><column-name>moreInfo</column-name><column-value><![CDATA[");
		sb.append(getMoreInfo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _guidelineId;
	private long _organizationId;
	private long _principleId;
	private boolean _guideline1;
	private boolean _guideline2;
	private boolean _guideline3;
	private boolean _guideline4;
	private boolean _guideline5;
	private boolean _guideline6;
	private boolean _guideline7;
	private boolean _guideline8;
	private String _moreInfo;
	private BaseModel<?> _guidelinesRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}