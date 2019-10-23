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

package com.sambaash.platform.srv.mail.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.mail.model.SPEMailAudit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPEMailAudit in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPEMailAudit
 * @generated
 */
public class SPEMailAuditCacheModel implements CacheModel<SPEMailAudit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{spEMailAudit=");
		sb.append(spEMailAudit);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", sentTo=");
		sb.append(sentTo);
		sb.append(", cc=");
		sb.append(cc);
		sb.append(", bcc=");
		sb.append(bcc);
		sb.append(", category=");
		sb.append(category);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", content=");
		sb.append(content);
		sb.append(", sentDate=");
		sb.append(sentDate);
		sb.append(", messasgeId=");
		sb.append(messasgeId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", orgId=");
		sb.append(orgId);
		sb.append(", processStateId=");
		sb.append(processStateId);
		sb.append(", nodeId=");
		sb.append(nodeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPEMailAudit toEntityModel() {
		SPEMailAuditImpl speMailAuditImpl = new SPEMailAuditImpl();

		speMailAuditImpl.setSpEMailAudit(spEMailAudit);
		speMailAuditImpl.setGroupId(groupId);
		speMailAuditImpl.setCompanyId(companyId);

		if (sentTo == null) {
			speMailAuditImpl.setSentTo(StringPool.BLANK);
		}
		else {
			speMailAuditImpl.setSentTo(sentTo);
		}

		if (cc == null) {
			speMailAuditImpl.setCc(StringPool.BLANK);
		}
		else {
			speMailAuditImpl.setCc(cc);
		}

		if (bcc == null) {
			speMailAuditImpl.setBcc(StringPool.BLANK);
		}
		else {
			speMailAuditImpl.setBcc(bcc);
		}

		if (category == null) {
			speMailAuditImpl.setCategory(StringPool.BLANK);
		}
		else {
			speMailAuditImpl.setCategory(category);
		}

		if (subject == null) {
			speMailAuditImpl.setSubject(StringPool.BLANK);
		}
		else {
			speMailAuditImpl.setSubject(subject);
		}

		if (content == null) {
			speMailAuditImpl.setContent(StringPool.BLANK);
		}
		else {
			speMailAuditImpl.setContent(content);
		}

		if (sentDate == Long.MIN_VALUE) {
			speMailAuditImpl.setSentDate(null);
		}
		else {
			speMailAuditImpl.setSentDate(new Date(sentDate));
		}

		if (messasgeId == null) {
			speMailAuditImpl.setMessasgeId(StringPool.BLANK);
		}
		else {
			speMailAuditImpl.setMessasgeId(messasgeId);
		}

		speMailAuditImpl.setUserId(userId);
		speMailAuditImpl.setOrgId(orgId);
		speMailAuditImpl.setProcessStateId(processStateId);
		speMailAuditImpl.setNodeId(nodeId);

		speMailAuditImpl.resetOriginalValues();

		return speMailAuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spEMailAudit = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		sentTo = objectInput.readUTF();
		cc = objectInput.readUTF();
		bcc = objectInput.readUTF();
		category = objectInput.readUTF();
		subject = objectInput.readUTF();
		content = objectInput.readUTF();
		sentDate = objectInput.readLong();
		messasgeId = objectInput.readUTF();
		userId = objectInput.readLong();
		orgId = objectInput.readLong();
		processStateId = objectInput.readLong();
		nodeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spEMailAudit);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (sentTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sentTo);
		}

		if (cc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cc);
		}

		if (bcc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bcc);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(sentDate);

		if (messasgeId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messasgeId);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(orgId);
		objectOutput.writeLong(processStateId);
		objectOutput.writeLong(nodeId);
	}

	public long spEMailAudit;
	public long groupId;
	public long companyId;
	public String sentTo;
	public String cc;
	public String bcc;
	public String category;
	public String subject;
	public String content;
	public long sentDate;
	public String messasgeId;
	public long userId;
	public long orgId;
	public long processStateId;
	public long nodeId;
}