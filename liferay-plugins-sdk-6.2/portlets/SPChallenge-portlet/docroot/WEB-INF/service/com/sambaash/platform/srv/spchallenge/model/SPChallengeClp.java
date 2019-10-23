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

package com.sambaash.platform.srv.spchallenge.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spchallenge.service.ClpSerializer;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPChallengeClp extends BaseModelImpl<SPChallenge>
	implements SPChallenge {
	public SPChallengeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPChallenge.class;
	}

	@Override
	public String getModelClassName() {
		return SPChallenge.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spChallengeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpChallengeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spChallengeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spChallengeId", getSpChallengeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("openTo", getOpenTo());
		attributes.put("type", getType());
		attributes.put("background", getBackground());
		attributes.put("description", getDescription());
		attributes.put("scope", getScope());
		attributes.put("benefits", getBenefits());
		attributes.put("budget", getBudget());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("applyBy", getApplyBy());
		attributes.put("extras", getExtras());
		attributes.put("active", getActive());
		attributes.put("notifyTo", getNotifyTo());
		attributes.put("scout", getScout());
		attributes.put("logoId", getLogoId());
		attributes.put("draft", getDraft());
		attributes.put("budgetCcySign", getBudgetCcySign());
		attributes.put("brand", getBrand());
		attributes.put("vpApprover", getVpApprover());
		attributes.put("budgetApprover", getBudgetApprover());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spChallengeId = (Long)attributes.get("spChallengeId");

		if (spChallengeId != null) {
			setSpChallengeId(spChallengeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String openTo = (String)attributes.get("openTo");

		if (openTo != null) {
			setOpenTo(openTo);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String background = (String)attributes.get("background");

		if (background != null) {
			setBackground(background);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String benefits = (String)attributes.get("benefits");

		if (benefits != null) {
			setBenefits(benefits);
		}

		String budget = (String)attributes.get("budget");

		if (budget != null) {
			setBudget(budget);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date applyBy = (Date)attributes.get("applyBy");

		if (applyBy != null) {
			setApplyBy(applyBy);
		}

		String extras = (String)attributes.get("extras");

		if (extras != null) {
			setExtras(extras);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String notifyTo = (String)attributes.get("notifyTo");

		if (notifyTo != null) {
			setNotifyTo(notifyTo);
		}

		String scout = (String)attributes.get("scout");

		if (scout != null) {
			setScout(scout);
		}

		Long logoId = (Long)attributes.get("logoId");

		if (logoId != null) {
			setLogoId(logoId);
		}

		Boolean draft = (Boolean)attributes.get("draft");

		if (draft != null) {
			setDraft(draft);
		}

		String budgetCcySign = (String)attributes.get("budgetCcySign");

		if (budgetCcySign != null) {
			setBudgetCcySign(budgetCcySign);
		}

		Long brand = (Long)attributes.get("brand");

		if (brand != null) {
			setBrand(brand);
		}

		String vpApprover = (String)attributes.get("vpApprover");

		if (vpApprover != null) {
			setVpApprover(vpApprover);
		}

		String budgetApprover = (String)attributes.get("budgetApprover");

		if (budgetApprover != null) {
			setBudgetApprover(budgetApprover);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spChallengeRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpChallengeId() {
		return _spChallengeId;
	}

	@Override
	public void setSpChallengeId(long spChallengeId) {
		_spChallengeId = spChallengeId;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpChallengeId", long.class);

				method.invoke(_spChallengeRemoteModel, spChallengeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spChallengeRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spChallengeRemoteModel, companyId);
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

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spChallengeRemoteModel, userId);
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spChallengeRemoteModel, userName);
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

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spChallengeRemoteModel, createDate);
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

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spChallengeRemoteModel, modifiedDate);
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

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_spChallengeRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOpenTo() {
		return _openTo;
	}

	@Override
	public void setOpenTo(String openTo) {
		_openTo = openTo;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setOpenTo", String.class);

				method.invoke(_spChallengeRemoteModel, openTo);
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

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_spChallengeRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBackground() {
		return _background;
	}

	@Override
	public void setBackground(String background) {
		_background = background;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setBackground", String.class);

				method.invoke(_spChallengeRemoteModel, background);
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

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_spChallengeRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScope() {
		return _scope;
	}

	@Override
	public void setScope(String scope) {
		_scope = scope;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setScope", String.class);

				method.invoke(_spChallengeRemoteModel, scope);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBenefits() {
		return _benefits;
	}

	@Override
	public void setBenefits(String benefits) {
		_benefits = benefits;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setBenefits", String.class);

				method.invoke(_spChallengeRemoteModel, benefits);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBudget() {
		return _budget;
	}

	@Override
	public void setBudget(String budget) {
		_budget = budget;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setBudget", String.class);

				method.invoke(_spChallengeRemoteModel, budget);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_spChallengeRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_spChallengeRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getApplyBy() {
		return _applyBy;
	}

	@Override
	public void setApplyBy(Date applyBy) {
		_applyBy = applyBy;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setApplyBy", Date.class);

				method.invoke(_spChallengeRemoteModel, applyBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtras() {
		return _extras;
	}

	@Override
	public void setExtras(String extras) {
		_extras = extras;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setExtras", String.class);

				method.invoke(_spChallengeRemoteModel, extras);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_spChallengeRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotifyTo() {
		return _notifyTo;
	}

	@Override
	public void setNotifyTo(String notifyTo) {
		_notifyTo = notifyTo;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setNotifyTo", String.class);

				method.invoke(_spChallengeRemoteModel, notifyTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScout() {
		return _scout;
	}

	@Override
	public void setScout(String scout) {
		_scout = scout;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setScout", String.class);

				method.invoke(_spChallengeRemoteModel, scout);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLogoId() {
		return _logoId;
	}

	@Override
	public void setLogoId(long logoId) {
		_logoId = logoId;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setLogoId", long.class);

				method.invoke(_spChallengeRemoteModel, logoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDraft() {
		return _draft;
	}

	@Override
	public boolean isDraft() {
		return _draft;
	}

	@Override
	public void setDraft(boolean draft) {
		_draft = draft;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setDraft", boolean.class);

				method.invoke(_spChallengeRemoteModel, draft);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBudgetCcySign() {
		return _budgetCcySign;
	}

	@Override
	public void setBudgetCcySign(String budgetCcySign) {
		_budgetCcySign = budgetCcySign;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setBudgetCcySign", String.class);

				method.invoke(_spChallengeRemoteModel, budgetCcySign);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBrand() {
		return _brand;
	}

	@Override
	public void setBrand(long brand) {
		_brand = brand;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setBrand", long.class);

				method.invoke(_spChallengeRemoteModel, brand);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVpApprover() {
		return _vpApprover;
	}

	@Override
	public void setVpApprover(String vpApprover) {
		_vpApprover = vpApprover;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setVpApprover", String.class);

				method.invoke(_spChallengeRemoteModel, vpApprover);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBudgetApprover() {
		return _budgetApprover;
	}

	@Override
	public void setBudgetApprover(String budgetApprover) {
		_budgetApprover = budgetApprover;

		if (_spChallengeRemoteModel != null) {
			try {
				Class<?> clazz = _spChallengeRemoteModel.getClass();

				Method method = clazz.getMethod("setBudgetApprover",
						String.class);

				method.invoke(_spChallengeRemoteModel, budgetApprover);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPChallenge.class.getName()));
	}

	public BaseModel<?> getSPChallengeRemoteModel() {
		return _spChallengeRemoteModel;
	}

	public void setSPChallengeRemoteModel(BaseModel<?> spChallengeRemoteModel) {
		_spChallengeRemoteModel = spChallengeRemoteModel;
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

		Class<?> remoteModelClass = _spChallengeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spChallengeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPChallengeLocalServiceUtil.addSPChallenge(this);
		}
		else {
			SPChallengeLocalServiceUtil.updateSPChallenge(this);
		}
	}

	@Override
	public SPChallenge toEscapedModel() {
		return (SPChallenge)ProxyUtil.newProxyInstance(SPChallenge.class.getClassLoader(),
			new Class[] { SPChallenge.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPChallengeClp clone = new SPChallengeClp();

		clone.setUuid(getUuid());
		clone.setSpChallengeId(getSpChallengeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setOpenTo(getOpenTo());
		clone.setType(getType());
		clone.setBackground(getBackground());
		clone.setDescription(getDescription());
		clone.setScope(getScope());
		clone.setBenefits(getBenefits());
		clone.setBudget(getBudget());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setApplyBy(getApplyBy());
		clone.setExtras(getExtras());
		clone.setActive(getActive());
		clone.setNotifyTo(getNotifyTo());
		clone.setScout(getScout());
		clone.setLogoId(getLogoId());
		clone.setDraft(getDraft());
		clone.setBudgetCcySign(getBudgetCcySign());
		clone.setBrand(getBrand());
		clone.setVpApprover(getVpApprover());
		clone.setBudgetApprover(getBudgetApprover());

		return clone;
	}

	@Override
	public int compareTo(SPChallenge spChallenge) {
		long primaryKey = spChallenge.getPrimaryKey();

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

		if (!(obj instanceof SPChallengeClp)) {
			return false;
		}

		SPChallengeClp spChallenge = (SPChallengeClp)obj;

		long primaryKey = spChallenge.getPrimaryKey();

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
		StringBundler sb = new StringBundler(59);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spChallengeId=");
		sb.append(getSpChallengeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", openTo=");
		sb.append(getOpenTo());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", background=");
		sb.append(getBackground());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", scope=");
		sb.append(getScope());
		sb.append(", benefits=");
		sb.append(getBenefits());
		sb.append(", budget=");
		sb.append(getBudget());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", applyBy=");
		sb.append(getApplyBy());
		sb.append(", extras=");
		sb.append(getExtras());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", notifyTo=");
		sb.append(getNotifyTo());
		sb.append(", scout=");
		sb.append(getScout());
		sb.append(", logoId=");
		sb.append(getLogoId());
		sb.append(", draft=");
		sb.append(getDraft());
		sb.append(", budgetCcySign=");
		sb.append(getBudgetCcySign());
		sb.append(", brand=");
		sb.append(getBrand());
		sb.append(", vpApprover=");
		sb.append(getVpApprover());
		sb.append(", budgetApprover=");
		sb.append(getBudgetApprover());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(91);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spchallenge.model.SPChallenge");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spChallengeId</column-name><column-value><![CDATA[");
		sb.append(getSpChallengeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openTo</column-name><column-value><![CDATA[");
		sb.append(getOpenTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>background</column-name><column-value><![CDATA[");
		sb.append(getBackground());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scope</column-name><column-value><![CDATA[");
		sb.append(getScope());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>benefits</column-name><column-value><![CDATA[");
		sb.append(getBenefits());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>budget</column-name><column-value><![CDATA[");
		sb.append(getBudget());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applyBy</column-name><column-value><![CDATA[");
		sb.append(getApplyBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extras</column-name><column-value><![CDATA[");
		sb.append(getExtras());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notifyTo</column-name><column-value><![CDATA[");
		sb.append(getNotifyTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scout</column-name><column-value><![CDATA[");
		sb.append(getScout());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logoId</column-name><column-value><![CDATA[");
		sb.append(getLogoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>draft</column-name><column-value><![CDATA[");
		sb.append(getDraft());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>budgetCcySign</column-name><column-value><![CDATA[");
		sb.append(getBudgetCcySign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brand</column-name><column-value><![CDATA[");
		sb.append(getBrand());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vpApprover</column-name><column-value><![CDATA[");
		sb.append(getVpApprover());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>budgetApprover</column-name><column-value><![CDATA[");
		sb.append(getBudgetApprover());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spChallengeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _openTo;
	private String _type;
	private String _background;
	private String _description;
	private String _scope;
	private String _benefits;
	private String _budget;
	private Date _startDate;
	private Date _endDate;
	private Date _applyBy;
	private String _extras;
	private boolean _active;
	private String _notifyTo;
	private String _scout;
	private long _logoId;
	private boolean _draft;
	private String _budgetCcySign;
	private long _brand;
	private String _vpApprover;
	private String _budgetApprover;
	private BaseModel<?> _spChallengeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spchallenge.service.ClpSerializer.class;
}