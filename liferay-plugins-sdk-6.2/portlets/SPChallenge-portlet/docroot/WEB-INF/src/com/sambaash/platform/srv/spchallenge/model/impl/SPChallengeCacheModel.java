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

package com.sambaash.platform.srv.spchallenge.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spchallenge.model.SPChallenge;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPChallenge in entity cache.
 *
 * @author pradeep
 * @see SPChallenge
 * @generated
 */
public class SPChallengeCacheModel implements CacheModel<SPChallenge>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spChallengeId=");
		sb.append(spChallengeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", openTo=");
		sb.append(openTo);
		sb.append(", type=");
		sb.append(type);
		sb.append(", background=");
		sb.append(background);
		sb.append(", description=");
		sb.append(description);
		sb.append(", scope=");
		sb.append(scope);
		sb.append(", benefits=");
		sb.append(benefits);
		sb.append(", budget=");
		sb.append(budget);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", applyBy=");
		sb.append(applyBy);
		sb.append(", extras=");
		sb.append(extras);
		sb.append(", active=");
		sb.append(active);
		sb.append(", notifyTo=");
		sb.append(notifyTo);
		sb.append(", scout=");
		sb.append(scout);
		sb.append(", logoId=");
		sb.append(logoId);
		sb.append(", draft=");
		sb.append(draft);
		sb.append(", budgetCcySign=");
		sb.append(budgetCcySign);
		sb.append(", brand=");
		sb.append(brand);
		sb.append(", vpApprover=");
		sb.append(vpApprover);
		sb.append(", budgetApprover=");
		sb.append(budgetApprover);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPChallenge toEntityModel() {
		SPChallengeImpl spChallengeImpl = new SPChallengeImpl();

		if (uuid == null) {
			spChallengeImpl.setUuid(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setUuid(uuid);
		}

		spChallengeImpl.setSpChallengeId(spChallengeId);
		spChallengeImpl.setGroupId(groupId);
		spChallengeImpl.setCompanyId(companyId);
		spChallengeImpl.setUserId(userId);

		if (userName == null) {
			spChallengeImpl.setUserName(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spChallengeImpl.setCreateDate(null);
		}
		else {
			spChallengeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spChallengeImpl.setModifiedDate(null);
		}
		else {
			spChallengeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			spChallengeImpl.setName(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setName(name);
		}

		if (openTo == null) {
			spChallengeImpl.setOpenTo(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setOpenTo(openTo);
		}

		if (type == null) {
			spChallengeImpl.setType(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setType(type);
		}

		if (background == null) {
			spChallengeImpl.setBackground(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setBackground(background);
		}

		if (description == null) {
			spChallengeImpl.setDescription(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setDescription(description);
		}

		if (scope == null) {
			spChallengeImpl.setScope(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setScope(scope);
		}

		if (benefits == null) {
			spChallengeImpl.setBenefits(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setBenefits(benefits);
		}

		if (budget == null) {
			spChallengeImpl.setBudget(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setBudget(budget);
		}

		if (startDate == Long.MIN_VALUE) {
			spChallengeImpl.setStartDate(null);
		}
		else {
			spChallengeImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			spChallengeImpl.setEndDate(null);
		}
		else {
			spChallengeImpl.setEndDate(new Date(endDate));
		}

		if (applyBy == Long.MIN_VALUE) {
			spChallengeImpl.setApplyBy(null);
		}
		else {
			spChallengeImpl.setApplyBy(new Date(applyBy));
		}

		if (extras == null) {
			spChallengeImpl.setExtras(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setExtras(extras);
		}

		spChallengeImpl.setActive(active);

		if (notifyTo == null) {
			spChallengeImpl.setNotifyTo(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setNotifyTo(notifyTo);
		}

		if (scout == null) {
			spChallengeImpl.setScout(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setScout(scout);
		}

		spChallengeImpl.setLogoId(logoId);
		spChallengeImpl.setDraft(draft);

		if (budgetCcySign == null) {
			spChallengeImpl.setBudgetCcySign(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setBudgetCcySign(budgetCcySign);
		}

		spChallengeImpl.setBrand(brand);

		if (vpApprover == null) {
			spChallengeImpl.setVpApprover(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setVpApprover(vpApprover);
		}

		if (budgetApprover == null) {
			spChallengeImpl.setBudgetApprover(StringPool.BLANK);
		}
		else {
			spChallengeImpl.setBudgetApprover(budgetApprover);
		}

		spChallengeImpl.resetOriginalValues();

		return spChallengeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spChallengeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		openTo = objectInput.readUTF();
		type = objectInput.readUTF();
		background = objectInput.readUTF();
		description = objectInput.readUTF();
		scope = objectInput.readUTF();
		benefits = objectInput.readUTF();
		budget = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		applyBy = objectInput.readLong();
		extras = objectInput.readUTF();
		active = objectInput.readBoolean();
		notifyTo = objectInput.readUTF();
		scout = objectInput.readUTF();
		logoId = objectInput.readLong();
		draft = objectInput.readBoolean();
		budgetCcySign = objectInput.readUTF();
		brand = objectInput.readLong();
		vpApprover = objectInput.readUTF();
		budgetApprover = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(spChallengeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (openTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(openTo);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (background == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(background);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (scope == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scope);
		}

		if (benefits == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(benefits);
		}

		if (budget == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(budget);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(applyBy);

		if (extras == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extras);
		}

		objectOutput.writeBoolean(active);

		if (notifyTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notifyTo);
		}

		if (scout == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scout);
		}

		objectOutput.writeLong(logoId);
		objectOutput.writeBoolean(draft);

		if (budgetCcySign == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(budgetCcySign);
		}

		objectOutput.writeLong(brand);

		if (vpApprover == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vpApprover);
		}

		if (budgetApprover == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(budgetApprover);
		}
	}

	public String uuid;
	public long spChallengeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String openTo;
	public String type;
	public String background;
	public String description;
	public String scope;
	public String benefits;
	public String budget;
	public long startDate;
	public long endDate;
	public long applyBy;
	public String extras;
	public boolean active;
	public String notifyTo;
	public String scout;
	public long logoId;
	public boolean draft;
	public String budgetCcySign;
	public long brand;
	public String vpApprover;
	public String budgetApprover;
}