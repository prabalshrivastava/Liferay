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

import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPChallengeApplicant in entity cache.
 *
 * @author pradeep
 * @see SPChallengeApplicant
 * @generated
 */
public class SPChallengeApplicantCacheModel implements CacheModel<SPChallengeApplicant>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spChallengeApplicantId=");
		sb.append(spChallengeApplicantId);
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
		sb.append(", applicantRefId=");
		sb.append(applicantRefId);
		sb.append(", applicantType=");
		sb.append(applicantType);
		sb.append(", spChallengeId=");
		sb.append(spChallengeId);
		sb.append(", q1=");
		sb.append(q1);
		sb.append(", q2=");
		sb.append(q2);
		sb.append(", q3=");
		sb.append(q3);
		sb.append(", q4=");
		sb.append(q4);
		sb.append(", q5=");
		sb.append(q5);
		sb.append(", q6=");
		sb.append(q6);
		sb.append(", q7=");
		sb.append(q7);
		sb.append(", q8=");
		sb.append(q8);
		sb.append(", q9=");
		sb.append(q9);
		sb.append(", q10=");
		sb.append(q10);
		sb.append(", q11=");
		sb.append(q11);
		sb.append(", q12=");
		sb.append(q12);
		sb.append(", q13=");
		sb.append(q13);
		sb.append(", q14=");
		sb.append(q14);
		sb.append(", q15=");
		sb.append(q15);
		sb.append(", q16=");
		sb.append(q16);
		sb.append(", q17=");
		sb.append(q17);
		sb.append(", q18=");
		sb.append(q18);
		sb.append(", q19=");
		sb.append(q19);
		sb.append(", q20=");
		sb.append(q20);
		sb.append(", customStatus1=");
		sb.append(customStatus1);
		sb.append(", customStatus2=");
		sb.append(customStatus2);
		sb.append(", active=");
		sb.append(active);
		sb.append(", applicationStatus=");
		sb.append(applicationStatus);
		sb.append(", notificationStatus=");
		sb.append(notificationStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPChallengeApplicant toEntityModel() {
		SPChallengeApplicantImpl spChallengeApplicantImpl = new SPChallengeApplicantImpl();

		if (uuid == null) {
			spChallengeApplicantImpl.setUuid(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setUuid(uuid);
		}

		spChallengeApplicantImpl.setSpChallengeApplicantId(spChallengeApplicantId);
		spChallengeApplicantImpl.setGroupId(groupId);
		spChallengeApplicantImpl.setCompanyId(companyId);
		spChallengeApplicantImpl.setUserId(userId);

		if (userName == null) {
			spChallengeApplicantImpl.setUserName(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spChallengeApplicantImpl.setCreateDate(null);
		}
		else {
			spChallengeApplicantImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spChallengeApplicantImpl.setModifiedDate(null);
		}
		else {
			spChallengeApplicantImpl.setModifiedDate(new Date(modifiedDate));
		}

		spChallengeApplicantImpl.setApplicantRefId(applicantRefId);

		if (applicantType == null) {
			spChallengeApplicantImpl.setApplicantType(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setApplicantType(applicantType);
		}

		spChallengeApplicantImpl.setSpChallengeId(spChallengeId);

		if (q1 == null) {
			spChallengeApplicantImpl.setQ1(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ1(q1);
		}

		if (q2 == null) {
			spChallengeApplicantImpl.setQ2(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ2(q2);
		}

		if (q3 == null) {
			spChallengeApplicantImpl.setQ3(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ3(q3);
		}

		if (q4 == null) {
			spChallengeApplicantImpl.setQ4(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ4(q4);
		}

		if (q5 == null) {
			spChallengeApplicantImpl.setQ5(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ5(q5);
		}

		if (q6 == null) {
			spChallengeApplicantImpl.setQ6(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ6(q6);
		}

		if (q7 == null) {
			spChallengeApplicantImpl.setQ7(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ7(q7);
		}

		if (q8 == null) {
			spChallengeApplicantImpl.setQ8(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ8(q8);
		}

		if (q9 == null) {
			spChallengeApplicantImpl.setQ9(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ9(q9);
		}

		if (q10 == null) {
			spChallengeApplicantImpl.setQ10(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ10(q10);
		}

		if (q11 == null) {
			spChallengeApplicantImpl.setQ11(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ11(q11);
		}

		if (q12 == null) {
			spChallengeApplicantImpl.setQ12(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ12(q12);
		}

		if (q13 == null) {
			spChallengeApplicantImpl.setQ13(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ13(q13);
		}

		if (q14 == null) {
			spChallengeApplicantImpl.setQ14(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ14(q14);
		}

		if (q15 == null) {
			spChallengeApplicantImpl.setQ15(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ15(q15);
		}

		if (q16 == null) {
			spChallengeApplicantImpl.setQ16(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ16(q16);
		}

		if (q17 == null) {
			spChallengeApplicantImpl.setQ17(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ17(q17);
		}

		if (q18 == null) {
			spChallengeApplicantImpl.setQ18(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ18(q18);
		}

		if (q19 == null) {
			spChallengeApplicantImpl.setQ19(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ19(q19);
		}

		if (q20 == null) {
			spChallengeApplicantImpl.setQ20(StringPool.BLANK);
		}
		else {
			spChallengeApplicantImpl.setQ20(q20);
		}

		spChallengeApplicantImpl.setCustomStatus1(customStatus1);
		spChallengeApplicantImpl.setCustomStatus2(customStatus2);
		spChallengeApplicantImpl.setActive(active);
		spChallengeApplicantImpl.setApplicationStatus(applicationStatus);
		spChallengeApplicantImpl.setNotificationStatus(notificationStatus);

		spChallengeApplicantImpl.resetOriginalValues();

		return spChallengeApplicantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spChallengeApplicantId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		applicantRefId = objectInput.readLong();
		applicantType = objectInput.readUTF();
		spChallengeId = objectInput.readLong();
		q1 = objectInput.readUTF();
		q2 = objectInput.readUTF();
		q3 = objectInput.readUTF();
		q4 = objectInput.readUTF();
		q5 = objectInput.readUTF();
		q6 = objectInput.readUTF();
		q7 = objectInput.readUTF();
		q8 = objectInput.readUTF();
		q9 = objectInput.readUTF();
		q10 = objectInput.readUTF();
		q11 = objectInput.readUTF();
		q12 = objectInput.readUTF();
		q13 = objectInput.readUTF();
		q14 = objectInput.readUTF();
		q15 = objectInput.readUTF();
		q16 = objectInput.readUTF();
		q17 = objectInput.readUTF();
		q18 = objectInput.readUTF();
		q19 = objectInput.readUTF();
		q20 = objectInput.readUTF();
		customStatus1 = objectInput.readBoolean();
		customStatus2 = objectInput.readBoolean();
		active = objectInput.readBoolean();
		applicationStatus = objectInput.readInt();
		notificationStatus = objectInput.readInt();
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

		objectOutput.writeLong(spChallengeApplicantId);
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
		objectOutput.writeLong(applicantRefId);

		if (applicantType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantType);
		}

		objectOutput.writeLong(spChallengeId);

		if (q1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q1);
		}

		if (q2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q2);
		}

		if (q3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q3);
		}

		if (q4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q4);
		}

		if (q5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q5);
		}

		if (q6 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q6);
		}

		if (q7 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q7);
		}

		if (q8 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q8);
		}

		if (q9 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q9);
		}

		if (q10 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q10);
		}

		if (q11 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q11);
		}

		if (q12 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q12);
		}

		if (q13 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q13);
		}

		if (q14 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q14);
		}

		if (q15 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q15);
		}

		if (q16 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q16);
		}

		if (q17 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q17);
		}

		if (q18 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q18);
		}

		if (q19 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q19);
		}

		if (q20 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(q20);
		}

		objectOutput.writeBoolean(customStatus1);
		objectOutput.writeBoolean(customStatus2);
		objectOutput.writeBoolean(active);
		objectOutput.writeInt(applicationStatus);
		objectOutput.writeInt(notificationStatus);
	}

	public String uuid;
	public long spChallengeApplicantId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long applicantRefId;
	public String applicantType;
	public long spChallengeId;
	public String q1;
	public String q2;
	public String q3;
	public String q4;
	public String q5;
	public String q6;
	public String q7;
	public String q8;
	public String q9;
	public String q10;
	public String q11;
	public String q12;
	public String q13;
	public String q14;
	public String q15;
	public String q16;
	public String q17;
	public String q18;
	public String q19;
	public String q20;
	public boolean customStatus1;
	public boolean customStatus2;
	public boolean active;
	public int applicationStatus;
	public int notificationStatus;
}