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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class SPChallengeSoap implements Serializable {
	public static SPChallengeSoap toSoapModel(SPChallenge model) {
		SPChallengeSoap soapModel = new SPChallengeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpChallengeId(model.getSpChallengeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setOpenTo(model.getOpenTo());
		soapModel.setType(model.getType());
		soapModel.setBackground(model.getBackground());
		soapModel.setDescription(model.getDescription());
		soapModel.setScope(model.getScope());
		soapModel.setBenefits(model.getBenefits());
		soapModel.setBudget(model.getBudget());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setApplyBy(model.getApplyBy());
		soapModel.setExtras(model.getExtras());
		soapModel.setActive(model.getActive());
		soapModel.setNotifyTo(model.getNotifyTo());
		soapModel.setScout(model.getScout());
		soapModel.setLogoId(model.getLogoId());
		soapModel.setDraft(model.getDraft());
		soapModel.setBudgetCcySign(model.getBudgetCcySign());
		soapModel.setBrand(model.getBrand());
		soapModel.setVpApprover(model.getVpApprover());
		soapModel.setBudgetApprover(model.getBudgetApprover());

		return soapModel;
	}

	public static SPChallengeSoap[] toSoapModels(SPChallenge[] models) {
		SPChallengeSoap[] soapModels = new SPChallengeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPChallengeSoap[][] toSoapModels(SPChallenge[][] models) {
		SPChallengeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPChallengeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPChallengeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPChallengeSoap[] toSoapModels(List<SPChallenge> models) {
		List<SPChallengeSoap> soapModels = new ArrayList<SPChallengeSoap>(models.size());

		for (SPChallenge model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPChallengeSoap[soapModels.size()]);
	}

	public SPChallengeSoap() {
	}

	public long getPrimaryKey() {
		return _spChallengeId;
	}

	public void setPrimaryKey(long pk) {
		setSpChallengeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpChallengeId() {
		return _spChallengeId;
	}

	public void setSpChallengeId(long spChallengeId) {
		_spChallengeId = spChallengeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getOpenTo() {
		return _openTo;
	}

	public void setOpenTo(String openTo) {
		_openTo = openTo;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getBackground() {
		return _background;
	}

	public void setBackground(String background) {
		_background = background;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getScope() {
		return _scope;
	}

	public void setScope(String scope) {
		_scope = scope;
	}

	public String getBenefits() {
		return _benefits;
	}

	public void setBenefits(String benefits) {
		_benefits = benefits;
	}

	public String getBudget() {
		return _budget;
	}

	public void setBudget(String budget) {
		_budget = budget;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getApplyBy() {
		return _applyBy;
	}

	public void setApplyBy(Date applyBy) {
		_applyBy = applyBy;
	}

	public String getExtras() {
		return _extras;
	}

	public void setExtras(String extras) {
		_extras = extras;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public String getNotifyTo() {
		return _notifyTo;
	}

	public void setNotifyTo(String notifyTo) {
		_notifyTo = notifyTo;
	}

	public String getScout() {
		return _scout;
	}

	public void setScout(String scout) {
		_scout = scout;
	}

	public long getLogoId() {
		return _logoId;
	}

	public void setLogoId(long logoId) {
		_logoId = logoId;
	}

	public boolean getDraft() {
		return _draft;
	}

	public boolean isDraft() {
		return _draft;
	}

	public void setDraft(boolean draft) {
		_draft = draft;
	}

	public String getBudgetCcySign() {
		return _budgetCcySign;
	}

	public void setBudgetCcySign(String budgetCcySign) {
		_budgetCcySign = budgetCcySign;
	}

	public long getBrand() {
		return _brand;
	}

	public void setBrand(long brand) {
		_brand = brand;
	}

	public String getVpApprover() {
		return _vpApprover;
	}

	public void setVpApprover(String vpApprover) {
		_vpApprover = vpApprover;
	}

	public String getBudgetApprover() {
		return _budgetApprover;
	}

	public void setBudgetApprover(String budgetApprover) {
		_budgetApprover = budgetApprover;
	}

	private String _uuid;
	private long _spChallengeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}