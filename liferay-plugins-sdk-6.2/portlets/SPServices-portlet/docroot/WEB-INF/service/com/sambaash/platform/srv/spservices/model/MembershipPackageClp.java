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
import com.sambaash.platform.srv.spservices.service.MembershipPackageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class MembershipPackageClp extends BaseModelImpl<MembershipPackage>
	implements MembershipPackage {
	public MembershipPackageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MembershipPackage.class;
	}

	@Override
	public String getModelClassName() {
		return MembershipPackage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _mpId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMpId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mpId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mpId", getMpId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("type", getType());
		attributes.put("version", getVersion());
		attributes.put("cost", getCost());
		attributes.put("costCurrency", getCostCurrency());
		attributes.put("costPeriod", getCostPeriod());
		attributes.put("costPeriodType", getCostPeriodType());
		attributes.put("promotionCode", getPromotionCode());
		attributes.put("promotionFrom", getPromotionFrom());
		attributes.put("promotionTo", getPromotionTo());
		attributes.put("discount", getDiscount());
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
		attributes.put("extra7", getExtra7());
		attributes.put("extra8", getExtra8());
		attributes.put("extra9", getExtra9());
		attributes.put("extra10", getExtra10());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mpId = (Long)attributes.get("mpId");

		if (mpId != null) {
			setMpId(mpId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Float cost = (Float)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
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

		String extra7 = (String)attributes.get("extra7");

		if (extra7 != null) {
			setExtra7(extra7);
		}

		String extra8 = (String)attributes.get("extra8");

		if (extra8 != null) {
			setExtra8(extra8);
		}

		String extra9 = (String)attributes.get("extra9");

		if (extra9 != null) {
			setExtra9(extra9);
		}

		String extra10 = (String)attributes.get("extra10");

		if (extra10 != null) {
			setExtra10(extra10);
		}
	}

	@Override
	public long getMpId() {
		return _mpId;
	}

	@Override
	public void setMpId(long mpId) {
		_mpId = mpId;

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setMpId", long.class);

				method.invoke(_membershipPackageRemoteModel, mpId);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_membershipPackageRemoteModel, name);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_membershipPackageRemoteModel, description);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_membershipPackageRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_membershipPackageRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_membershipPackageRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public float getCost() {
		return _cost;
	}

	@Override
	public void setCost(float cost) {
		_cost = cost;

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCost", float.class);

				method.invoke(_membershipPackageRemoteModel, cost);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCostCurrency", String.class);

				method.invoke(_membershipPackageRemoteModel, costCurrency);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCostPeriod", String.class);

				method.invoke(_membershipPackageRemoteModel, costPeriod);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCostPeriodType",
						String.class);

				method.invoke(_membershipPackageRemoteModel, costPeriodType);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionCode", String.class);

				method.invoke(_membershipPackageRemoteModel, promotionCode);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionFrom", Date.class);

				method.invoke(_membershipPackageRemoteModel, promotionFrom);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotionTo", Date.class);

				method.invoke(_membershipPackageRemoteModel, promotionTo);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", String.class);

				method.invoke(_membershipPackageRemoteModel, discount);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setDateAdded", Date.class);

				method.invoke(_membershipPackageRemoteModel, dateAdded);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setDateModified", Date.class);

				method.invoke(_membershipPackageRemoteModel, dateModified);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_membershipPackageRemoteModel, createdBy);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", String.class);

				method.invoke(_membershipPackageRemoteModel, modifiedBy);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra1", String.class);

				method.invoke(_membershipPackageRemoteModel, extra1);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra2", String.class);

				method.invoke(_membershipPackageRemoteModel, extra2);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra3", String.class);

				method.invoke(_membershipPackageRemoteModel, extra3);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra4", String.class);

				method.invoke(_membershipPackageRemoteModel, extra4);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra5", Date.class);

				method.invoke(_membershipPackageRemoteModel, extra5);
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

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra6", Date.class);

				method.invoke(_membershipPackageRemoteModel, extra6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra7() {
		return _extra7;
	}

	@Override
	public void setExtra7(String extra7) {
		_extra7 = extra7;

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra7", String.class);

				method.invoke(_membershipPackageRemoteModel, extra7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra8() {
		return _extra8;
	}

	@Override
	public void setExtra8(String extra8) {
		_extra8 = extra8;

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra8", String.class);

				method.invoke(_membershipPackageRemoteModel, extra8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra9() {
		return _extra9;
	}

	@Override
	public void setExtra9(String extra9) {
		_extra9 = extra9;

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra9", String.class);

				method.invoke(_membershipPackageRemoteModel, extra9);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtra10() {
		return _extra10;
	}

	@Override
	public void setExtra10(String extra10) {
		_extra10 = extra10;

		if (_membershipPackageRemoteModel != null) {
			try {
				Class<?> clazz = _membershipPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setExtra10", String.class);

				method.invoke(_membershipPackageRemoteModel, extra10);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMembershipPackageRemoteModel() {
		return _membershipPackageRemoteModel;
	}

	public void setMembershipPackageRemoteModel(
		BaseModel<?> membershipPackageRemoteModel) {
		_membershipPackageRemoteModel = membershipPackageRemoteModel;
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

		Class<?> remoteModelClass = _membershipPackageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_membershipPackageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MembershipPackageLocalServiceUtil.addMembershipPackage(this);
		}
		else {
			MembershipPackageLocalServiceUtil.updateMembershipPackage(this);
		}
	}

	@Override
	public MembershipPackage toEscapedModel() {
		return (MembershipPackage)ProxyUtil.newProxyInstance(MembershipPackage.class.getClassLoader(),
			new Class[] { MembershipPackage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MembershipPackageClp clone = new MembershipPackageClp();

		clone.setMpId(getMpId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setStatus(getStatus());
		clone.setType(getType());
		clone.setVersion(getVersion());
		clone.setCost(getCost());
		clone.setCostCurrency(getCostCurrency());
		clone.setCostPeriod(getCostPeriod());
		clone.setCostPeriodType(getCostPeriodType());
		clone.setPromotionCode(getPromotionCode());
		clone.setPromotionFrom(getPromotionFrom());
		clone.setPromotionTo(getPromotionTo());
		clone.setDiscount(getDiscount());
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
		clone.setExtra7(getExtra7());
		clone.setExtra8(getExtra8());
		clone.setExtra9(getExtra9());
		clone.setExtra10(getExtra10());

		return clone;
	}

	@Override
	public int compareTo(MembershipPackage membershipPackage) {
		int value = 0;

		value = getName().compareTo(membershipPackage.getName());

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

		if (!(obj instanceof MembershipPackageClp)) {
			return false;
		}

		MembershipPackageClp membershipPackage = (MembershipPackageClp)obj;

		long primaryKey = membershipPackage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(57);

		sb.append("{mpId=");
		sb.append(getMpId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", cost=");
		sb.append(getCost());
		sb.append(", costCurrency=");
		sb.append(getCostCurrency());
		sb.append(", costPeriod=");
		sb.append(getCostPeriod());
		sb.append(", costPeriodType=");
		sb.append(getCostPeriodType());
		sb.append(", promotionCode=");
		sb.append(getPromotionCode());
		sb.append(", promotionFrom=");
		sb.append(getPromotionFrom());
		sb.append(", promotionTo=");
		sb.append(getPromotionTo());
		sb.append(", discount=");
		sb.append(getDiscount());
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
		sb.append(", extra7=");
		sb.append(getExtra7());
		sb.append(", extra8=");
		sb.append(getExtra8());
		sb.append(", extra9=");
		sb.append(getExtra9());
		sb.append(", extra10=");
		sb.append(getExtra10());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spservices.model.MembershipPackage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mpId</column-name><column-value><![CDATA[");
		sb.append(getMpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
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
			"<column><column-name>extra7</column-name><column-value><![CDATA[");
		sb.append(getExtra7());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra8</column-name><column-value><![CDATA[");
		sb.append(getExtra8());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra9</column-name><column-value><![CDATA[");
		sb.append(getExtra9());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extra10</column-name><column-value><![CDATA[");
		sb.append(getExtra10());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mpId;
	private String _name;
	private String _description;
	private String _status;
	private String _type;
	private String _version;
	private float _cost;
	private String _costCurrency;
	private String _costPeriod;
	private String _costPeriodType;
	private String _promotionCode;
	private Date _promotionFrom;
	private Date _promotionTo;
	private String _discount;
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
	private String _extra7;
	private String _extra8;
	private String _extra9;
	private String _extra10;
	private BaseModel<?> _membershipPackageRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}