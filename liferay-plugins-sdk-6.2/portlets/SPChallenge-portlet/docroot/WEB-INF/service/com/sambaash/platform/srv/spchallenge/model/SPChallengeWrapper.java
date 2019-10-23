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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPChallenge}.
 * </p>
 *
 * @author pradeep
 * @see SPChallenge
 * @generated
 */
public class SPChallengeWrapper implements SPChallenge,
	ModelWrapper<SPChallenge> {
	public SPChallengeWrapper(SPChallenge spChallenge) {
		_spChallenge = spChallenge;
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

	/**
	* Returns the primary key of this s p challenge.
	*
	* @return the primary key of this s p challenge
	*/
	@Override
	public long getPrimaryKey() {
		return _spChallenge.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p challenge.
	*
	* @param primaryKey the primary key of this s p challenge
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spChallenge.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p challenge.
	*
	* @return the uuid of this s p challenge
	*/
	@Override
	public java.lang.String getUuid() {
		return _spChallenge.getUuid();
	}

	/**
	* Sets the uuid of this s p challenge.
	*
	* @param uuid the uuid of this s p challenge
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spChallenge.setUuid(uuid);
	}

	/**
	* Returns the sp challenge ID of this s p challenge.
	*
	* @return the sp challenge ID of this s p challenge
	*/
	@Override
	public long getSpChallengeId() {
		return _spChallenge.getSpChallengeId();
	}

	/**
	* Sets the sp challenge ID of this s p challenge.
	*
	* @param spChallengeId the sp challenge ID of this s p challenge
	*/
	@Override
	public void setSpChallengeId(long spChallengeId) {
		_spChallenge.setSpChallengeId(spChallengeId);
	}

	/**
	* Returns the group ID of this s p challenge.
	*
	* @return the group ID of this s p challenge
	*/
	@Override
	public long getGroupId() {
		return _spChallenge.getGroupId();
	}

	/**
	* Sets the group ID of this s p challenge.
	*
	* @param groupId the group ID of this s p challenge
	*/
	@Override
	public void setGroupId(long groupId) {
		_spChallenge.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p challenge.
	*
	* @return the company ID of this s p challenge
	*/
	@Override
	public long getCompanyId() {
		return _spChallenge.getCompanyId();
	}

	/**
	* Sets the company ID of this s p challenge.
	*
	* @param companyId the company ID of this s p challenge
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spChallenge.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p challenge.
	*
	* @return the user ID of this s p challenge
	*/
	@Override
	public long getUserId() {
		return _spChallenge.getUserId();
	}

	/**
	* Sets the user ID of this s p challenge.
	*
	* @param userId the user ID of this s p challenge
	*/
	@Override
	public void setUserId(long userId) {
		_spChallenge.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p challenge.
	*
	* @return the user uuid of this s p challenge
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spChallenge.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p challenge.
	*
	* @param userUuid the user uuid of this s p challenge
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spChallenge.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p challenge.
	*
	* @return the user name of this s p challenge
	*/
	@Override
	public java.lang.String getUserName() {
		return _spChallenge.getUserName();
	}

	/**
	* Sets the user name of this s p challenge.
	*
	* @param userName the user name of this s p challenge
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spChallenge.setUserName(userName);
	}

	/**
	* Returns the create date of this s p challenge.
	*
	* @return the create date of this s p challenge
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spChallenge.getCreateDate();
	}

	/**
	* Sets the create date of this s p challenge.
	*
	* @param createDate the create date of this s p challenge
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spChallenge.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p challenge.
	*
	* @return the modified date of this s p challenge
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spChallenge.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p challenge.
	*
	* @param modifiedDate the modified date of this s p challenge
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spChallenge.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this s p challenge.
	*
	* @return the name of this s p challenge
	*/
	@Override
	public java.lang.String getName() {
		return _spChallenge.getName();
	}

	/**
	* Sets the name of this s p challenge.
	*
	* @param name the name of this s p challenge
	*/
	@Override
	public void setName(java.lang.String name) {
		_spChallenge.setName(name);
	}

	/**
	* Returns the open to of this s p challenge.
	*
	* @return the open to of this s p challenge
	*/
	@Override
	public java.lang.String getOpenTo() {
		return _spChallenge.getOpenTo();
	}

	/**
	* Sets the open to of this s p challenge.
	*
	* @param openTo the open to of this s p challenge
	*/
	@Override
	public void setOpenTo(java.lang.String openTo) {
		_spChallenge.setOpenTo(openTo);
	}

	/**
	* Returns the type of this s p challenge.
	*
	* @return the type of this s p challenge
	*/
	@Override
	public java.lang.String getType() {
		return _spChallenge.getType();
	}

	/**
	* Sets the type of this s p challenge.
	*
	* @param type the type of this s p challenge
	*/
	@Override
	public void setType(java.lang.String type) {
		_spChallenge.setType(type);
	}

	/**
	* Returns the background of this s p challenge.
	*
	* @return the background of this s p challenge
	*/
	@Override
	public java.lang.String getBackground() {
		return _spChallenge.getBackground();
	}

	/**
	* Sets the background of this s p challenge.
	*
	* @param background the background of this s p challenge
	*/
	@Override
	public void setBackground(java.lang.String background) {
		_spChallenge.setBackground(background);
	}

	/**
	* Returns the description of this s p challenge.
	*
	* @return the description of this s p challenge
	*/
	@Override
	public java.lang.String getDescription() {
		return _spChallenge.getDescription();
	}

	/**
	* Sets the description of this s p challenge.
	*
	* @param description the description of this s p challenge
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_spChallenge.setDescription(description);
	}

	/**
	* Returns the scope of this s p challenge.
	*
	* @return the scope of this s p challenge
	*/
	@Override
	public java.lang.String getScope() {
		return _spChallenge.getScope();
	}

	/**
	* Sets the scope of this s p challenge.
	*
	* @param scope the scope of this s p challenge
	*/
	@Override
	public void setScope(java.lang.String scope) {
		_spChallenge.setScope(scope);
	}

	/**
	* Returns the benefits of this s p challenge.
	*
	* @return the benefits of this s p challenge
	*/
	@Override
	public java.lang.String getBenefits() {
		return _spChallenge.getBenefits();
	}

	/**
	* Sets the benefits of this s p challenge.
	*
	* @param benefits the benefits of this s p challenge
	*/
	@Override
	public void setBenefits(java.lang.String benefits) {
		_spChallenge.setBenefits(benefits);
	}

	/**
	* Returns the budget of this s p challenge.
	*
	* @return the budget of this s p challenge
	*/
	@Override
	public java.lang.String getBudget() {
		return _spChallenge.getBudget();
	}

	/**
	* Sets the budget of this s p challenge.
	*
	* @param budget the budget of this s p challenge
	*/
	@Override
	public void setBudget(java.lang.String budget) {
		_spChallenge.setBudget(budget);
	}

	/**
	* Returns the start date of this s p challenge.
	*
	* @return the start date of this s p challenge
	*/
	@Override
	public java.util.Date getStartDate() {
		return _spChallenge.getStartDate();
	}

	/**
	* Sets the start date of this s p challenge.
	*
	* @param startDate the start date of this s p challenge
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_spChallenge.setStartDate(startDate);
	}

	/**
	* Returns the end date of this s p challenge.
	*
	* @return the end date of this s p challenge
	*/
	@Override
	public java.util.Date getEndDate() {
		return _spChallenge.getEndDate();
	}

	/**
	* Sets the end date of this s p challenge.
	*
	* @param endDate the end date of this s p challenge
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_spChallenge.setEndDate(endDate);
	}

	/**
	* Returns the apply by of this s p challenge.
	*
	* @return the apply by of this s p challenge
	*/
	@Override
	public java.util.Date getApplyBy() {
		return _spChallenge.getApplyBy();
	}

	/**
	* Sets the apply by of this s p challenge.
	*
	* @param applyBy the apply by of this s p challenge
	*/
	@Override
	public void setApplyBy(java.util.Date applyBy) {
		_spChallenge.setApplyBy(applyBy);
	}

	/**
	* Returns the extras of this s p challenge.
	*
	* @return the extras of this s p challenge
	*/
	@Override
	public java.lang.String getExtras() {
		return _spChallenge.getExtras();
	}

	/**
	* Sets the extras of this s p challenge.
	*
	* @param extras the extras of this s p challenge
	*/
	@Override
	public void setExtras(java.lang.String extras) {
		_spChallenge.setExtras(extras);
	}

	/**
	* Returns the active of this s p challenge.
	*
	* @return the active of this s p challenge
	*/
	@Override
	public boolean getActive() {
		return _spChallenge.getActive();
	}

	/**
	* Returns <code>true</code> if this s p challenge is active.
	*
	* @return <code>true</code> if this s p challenge is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _spChallenge.isActive();
	}

	/**
	* Sets whether this s p challenge is active.
	*
	* @param active the active of this s p challenge
	*/
	@Override
	public void setActive(boolean active) {
		_spChallenge.setActive(active);
	}

	/**
	* Returns the notify to of this s p challenge.
	*
	* @return the notify to of this s p challenge
	*/
	@Override
	public java.lang.String getNotifyTo() {
		return _spChallenge.getNotifyTo();
	}

	/**
	* Sets the notify to of this s p challenge.
	*
	* @param notifyTo the notify to of this s p challenge
	*/
	@Override
	public void setNotifyTo(java.lang.String notifyTo) {
		_spChallenge.setNotifyTo(notifyTo);
	}

	/**
	* Returns the scout of this s p challenge.
	*
	* @return the scout of this s p challenge
	*/
	@Override
	public java.lang.String getScout() {
		return _spChallenge.getScout();
	}

	/**
	* Sets the scout of this s p challenge.
	*
	* @param scout the scout of this s p challenge
	*/
	@Override
	public void setScout(java.lang.String scout) {
		_spChallenge.setScout(scout);
	}

	/**
	* Returns the logo ID of this s p challenge.
	*
	* @return the logo ID of this s p challenge
	*/
	@Override
	public long getLogoId() {
		return _spChallenge.getLogoId();
	}

	/**
	* Sets the logo ID of this s p challenge.
	*
	* @param logoId the logo ID of this s p challenge
	*/
	@Override
	public void setLogoId(long logoId) {
		_spChallenge.setLogoId(logoId);
	}

	/**
	* Returns the draft of this s p challenge.
	*
	* @return the draft of this s p challenge
	*/
	@Override
	public boolean getDraft() {
		return _spChallenge.getDraft();
	}

	/**
	* Returns <code>true</code> if this s p challenge is draft.
	*
	* @return <code>true</code> if this s p challenge is draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _spChallenge.isDraft();
	}

	/**
	* Sets whether this s p challenge is draft.
	*
	* @param draft the draft of this s p challenge
	*/
	@Override
	public void setDraft(boolean draft) {
		_spChallenge.setDraft(draft);
	}

	/**
	* Returns the budget ccy sign of this s p challenge.
	*
	* @return the budget ccy sign of this s p challenge
	*/
	@Override
	public java.lang.String getBudgetCcySign() {
		return _spChallenge.getBudgetCcySign();
	}

	/**
	* Sets the budget ccy sign of this s p challenge.
	*
	* @param budgetCcySign the budget ccy sign of this s p challenge
	*/
	@Override
	public void setBudgetCcySign(java.lang.String budgetCcySign) {
		_spChallenge.setBudgetCcySign(budgetCcySign);
	}

	/**
	* Returns the brand of this s p challenge.
	*
	* @return the brand of this s p challenge
	*/
	@Override
	public long getBrand() {
		return _spChallenge.getBrand();
	}

	/**
	* Sets the brand of this s p challenge.
	*
	* @param brand the brand of this s p challenge
	*/
	@Override
	public void setBrand(long brand) {
		_spChallenge.setBrand(brand);
	}

	/**
	* Returns the vp approver of this s p challenge.
	*
	* @return the vp approver of this s p challenge
	*/
	@Override
	public java.lang.String getVpApprover() {
		return _spChallenge.getVpApprover();
	}

	/**
	* Sets the vp approver of this s p challenge.
	*
	* @param vpApprover the vp approver of this s p challenge
	*/
	@Override
	public void setVpApprover(java.lang.String vpApprover) {
		_spChallenge.setVpApprover(vpApprover);
	}

	/**
	* Returns the budget approver of this s p challenge.
	*
	* @return the budget approver of this s p challenge
	*/
	@Override
	public java.lang.String getBudgetApprover() {
		return _spChallenge.getBudgetApprover();
	}

	/**
	* Sets the budget approver of this s p challenge.
	*
	* @param budgetApprover the budget approver of this s p challenge
	*/
	@Override
	public void setBudgetApprover(java.lang.String budgetApprover) {
		_spChallenge.setBudgetApprover(budgetApprover);
	}

	@Override
	public boolean isNew() {
		return _spChallenge.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spChallenge.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spChallenge.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spChallenge.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spChallenge.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spChallenge.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spChallenge.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spChallenge.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spChallenge.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spChallenge.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spChallenge.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPChallengeWrapper((SPChallenge)_spChallenge.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spchallenge.model.SPChallenge spChallenge) {
		return _spChallenge.compareTo(spChallenge);
	}

	@Override
	public int hashCode() {
		return _spChallenge.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spchallenge.model.SPChallenge> toCacheModel() {
		return _spChallenge.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spchallenge.model.SPChallenge toEscapedModel() {
		return new SPChallengeWrapper(_spChallenge.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spchallenge.model.SPChallenge toUnescapedModel() {
		return new SPChallengeWrapper(_spChallenge.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spChallenge.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spChallenge.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spChallenge.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPChallengeWrapper)) {
			return false;
		}

		SPChallengeWrapper spChallengeWrapper = (SPChallengeWrapper)obj;

		if (Validator.equals(_spChallenge, spChallengeWrapper._spChallenge)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spChallenge.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPChallenge getWrappedSPChallenge() {
		return _spChallenge;
	}

	@Override
	public SPChallenge getWrappedModel() {
		return _spChallenge;
	}

	@Override
	public void resetOriginalValues() {
		_spChallenge.resetOriginalValues();
	}

	private SPChallenge _spChallenge;
}