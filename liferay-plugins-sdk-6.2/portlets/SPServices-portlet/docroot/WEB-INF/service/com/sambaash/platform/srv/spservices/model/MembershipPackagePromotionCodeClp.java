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
import com.sambaash.platform.srv.spservices.service.MembershipPackagePromotionCodeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class MembershipPackagePromotionCodeClp extends BaseModelImpl<MembershipPackagePromotionCode>
	implements MembershipPackagePromotionCode {
	public MembershipPackagePromotionCodeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackagePromotionCode.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackagePromotionCode.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _promotionCode_id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPromotionCode_id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _promotionCode_id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("promotionCode_id", getPromotionCode_id());
		attributes.put("membershipPackage_id", getMembershipPackage_id());
		attributes.put("promotionCode", getPromotionCode());
		attributes.put("promotionFrom", getPromotionFrom());
		attributes.put("promotionTo", getPromotionTo());
		attributes.put("discount", getDiscount());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long promotionCode_id = (Long)attributes.get("promotionCode_id");

		if (promotionCode_id != null) {
			setPromotionCode_id(promotionCode_id);
		}

		Long membershipPackage_id = (Long)attributes.get("membershipPackage_id");

		if (membershipPackage_id != null) {
			setMembershipPackage_id(membershipPackage_id);
		}

		String promotionCode = (String)attributes.get("promotionCode");

		if (promotionCode != null) {
			setPromotionCode(promotionCode);
		}

		Date promotionFrom = (Date)attributes.get("promotionFrom");

		if (promotionFrom != null) {
			setPromotionFrom(promotionFrom);
		}

		Date promotionTo = (Date)attributes.get("promotionTo");

		if (promotionTo != null) {
			setPromotionTo(promotionTo);
		}

		String discount = (String)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
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

		String extra5 = (String)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}
	}

	@Override
	public long getPromotionCode_id() {
		return _promotionCode_id;
	}

	@Override
	public void setPromotionCode_id(long promotionCode_id) {
		_promotionCode_id = promotionCode_id;

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionCode_id",
						long.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel,
					promotionCode_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMembershipPackage_id() {
		return _membershipPackage_id;
	}

	@Override
	public void setMembershipPackage_id(long membershipPackage_id) {
		_membershipPackage_id = membershipPackage_id;

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setMembershipPackage_id",
						long.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel,
					membershipPackage_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPromotionCode() {
		return _promotionCode;
	}

	@Override
	public void setPromotionCode(String promotionCode) {
		_promotionCode = promotionCode;

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionCode", String.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel,
					promotionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPromotionFrom() {
		return _promotionFrom;
	}

	@Override
	public void setPromotionFrom(Date promotionFrom) {
		_promotionFrom = promotionFrom;

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionFrom", Date.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel,
					promotionFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPromotionTo() {
		return _promotionTo;
	}

	@Override
	public void setPromotionTo(Date promotionTo) {
		_promotionTo = promotionTo;

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionTo", Date.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel,
					promotionTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiscount() {
		return _discount;
	}

	@Override
	public void setDiscount(String discount) {
		_discount = discount;

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", String.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel,
					discount);
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

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel, extra1);
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

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel, extra2);
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

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra3", String.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel, extra3);
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

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra4", String.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel, extra4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra5() {
		return _extra5;
	}

	@Override
	public void setExtra5(String extra5) {
		_extra5 = extra5;

		if (_membershipPackagePromotionCodeRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackagePromotionCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra5", String.class);

				method.invoke(_membershipPackagePromotionCodeRemoteModel, extra5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMembershipPackagePromotionCodeRemoteModel() {
		return _membershipPackagePromotionCodeRemoteModel;
	}

	public void setMembershipPackagePromotionCodeRemoteModel(
		BaseModel<?> membershipPackagePromotionCodeRemoteModel) {
		_membershipPackagePromotionCodeRemoteModel = membershipPackagePromotionCodeRemoteModel;
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

		Class<?> remoteModelClass = _membershipPackagePromotionCodeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_membershipPackagePromotionCodeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MembershipPackagePromotionCodeLocalServiceUtil.addMembershipPackagePromotionCode(this);
		}
		else {
			MembershipPackagePromotionCodeLocalServiceUtil.updateMembershipPackagePromotionCode(this);
		}
	}

	@Override
	public MembershipPackagePromotionCode toEscapedModel() {
		return (MembershipPackagePromotionCode)ProxyUtil.newProxyInstance(MembershipPackagePromotionCode.class.getClassLoader(),
			new Class[] { MembershipPackagePromotionCode.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MembershipPackagePromotionCodeClp clone = new MembershipPackagePromotionCodeClp();

		clone.setPromotionCode_id(getPromotionCode_id());
		clone.setMembershipPackage_id(getMembershipPackage_id());
		clone.setPromotionCode(getPromotionCode());
		clone.setPromotionFrom(getPromotionFrom());
		clone.setPromotionTo(getPromotionTo());
		clone.setDiscount(getDiscount());
		clone.setExtra1(getExtra1());
		clone.setExtra2(getExtra2());
		clone.setExtra3(getExtra3());
		clone.setExtra4(getExtra4());
		clone.setExtra5(getExtra5());

		return clone;
	}

	@Override
	public int compareTo(
		MembershipPackagePromotionCode membershipPackagePromotionCode) {
		long primaryKey = membershipPackagePromotionCode.getPrimaryKey();

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

		if (!(obj instanceof MembershipPackagePromotionCodeClp)) {
			return false;
		}

		MembershipPackagePromotionCodeClp membershipPackagePromotionCode = (MembershipPackagePromotionCodeClp)obj;

		long primaryKey = membershipPackagePromotionCode.getPrimaryKey();

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

		sb.append("{promotionCode_id=");
		sb.append(getPromotionCode_id());
		sb.append(", membershipPackage_id=");
		sb.append(getMembershipPackage_id());
		sb.append(", promotionCode=");
		sb.append(getPromotionCode());
		sb.append(", promotionFrom=");
		sb.append(getPromotionFrom());
		sb.append(", promotionTo=");
		sb.append(getPromotionTo());
		sb.append(", discount=");
		sb.append(getDiscount());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>promotionCode_id</column-name><column-value><![CDATA[");
		sb.append(getPromotionCode_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>membershipPackage_id</column-name><column-value><![CDATA[");
		sb.append(getMembershipPackage_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotionCode</column-name><column-value><![CDATA[");
		sb.append(getPromotionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotionFrom</column-name><column-value><![CDATA[");
		sb.append(getPromotionFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotionTo</column-name><column-value><![CDATA[");
		sb.append(getPromotionTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _promotionCode_id;
	private long _membershipPackage_id;
	private String _promotionCode;
	private Date _promotionFrom;
	private Date _promotionTo;
	private String _discount;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private String _extra5;
	private BaseModel<?> _membershipPackagePromotionCodeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}