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

package com.sambaash.platform.srv.template.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.template.model.SPTemplate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPTemplate in entity cache.
 *
 * @author WattabyteIT
 * @see SPTemplate
 * @generated
 */
public class SPTemplateCacheModel implements CacheModel<SPTemplate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spTemplateId=");
		sb.append(spTemplateId);
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
		sb.append(", createBy=");
		sb.append(createBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", templateName=");
		sb.append(templateName);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPTemplate toEntityModel() {
		SPTemplateImpl spTemplateImpl = new SPTemplateImpl();

		if (uuid == null) {
			spTemplateImpl.setUuid(StringPool.BLANK);
		}
		else {
			spTemplateImpl.setUuid(uuid);
		}

		spTemplateImpl.setSpTemplateId(spTemplateId);
		spTemplateImpl.setGroupId(groupId);
		spTemplateImpl.setCompanyId(companyId);
		spTemplateImpl.setUserId(userId);

		if (userName == null) {
			spTemplateImpl.setUserName(StringPool.BLANK);
		}
		else {
			spTemplateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spTemplateImpl.setCreateDate(null);
		}
		else {
			spTemplateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spTemplateImpl.setModifiedDate(null);
		}
		else {
			spTemplateImpl.setModifiedDate(new Date(modifiedDate));
		}

		spTemplateImpl.setCreateBy(createBy);
		spTemplateImpl.setModifiedBy(modifiedBy);
		spTemplateImpl.setClassNameId(classNameId);
		spTemplateImpl.setClassPK(classPK);

		if (templateName == null) {
			spTemplateImpl.setTemplateName(StringPool.BLANK);
		}
		else {
			spTemplateImpl.setTemplateName(templateName);
		}

		spTemplateImpl.setStatus(status);

		spTemplateImpl.resetOriginalValues();

		return spTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spTemplateId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		createBy = objectInput.readLong();
		modifiedBy = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		templateName = objectInput.readUTF();
		status = objectInput.readInt();
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

		objectOutput.writeLong(spTemplateId);
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
		objectOutput.writeLong(createBy);
		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);

		if (templateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateName);
		}

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long spTemplateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long createBy;
	public long modifiedBy;
	public long classNameId;
	public long classPK;
	public String templateName;
	public int status;
}