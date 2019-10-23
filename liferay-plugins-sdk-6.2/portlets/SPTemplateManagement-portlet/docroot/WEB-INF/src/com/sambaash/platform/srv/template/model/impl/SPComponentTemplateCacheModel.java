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

import com.sambaash.platform.srv.template.model.SPComponentTemplate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPComponentTemplate in entity cache.
 *
 * @author WattabyteIT
 * @see SPComponentTemplate
 * @generated
 */
public class SPComponentTemplateCacheModel implements CacheModel<SPComponentTemplate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(69);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spComponentTemplateId=");
		sb.append(spComponentTemplateId);
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
		sb.append(", spTemplateId=");
		sb.append(spTemplateId);
		sb.append(", level0ClassNameId=");
		sb.append(level0ClassNameId);
		sb.append(", level0FormId=");
		sb.append(level0FormId);
		sb.append(", level1ClassNameId=");
		sb.append(level1ClassNameId);
		sb.append(", level1FormId=");
		sb.append(level1FormId);
		sb.append(", level2ClassNameId=");
		sb.append(level2ClassNameId);
		sb.append(", level2FormId=");
		sb.append(level2FormId);
		sb.append(", level3ClassNameId=");
		sb.append(level3ClassNameId);
		sb.append(", level3FormId=");
		sb.append(level3FormId);
		sb.append(", level4ClassNameId=");
		sb.append(level4ClassNameId);
		sb.append(", level4FormId=");
		sb.append(level4FormId);
		sb.append(", level5ClassNameId=");
		sb.append(level5ClassNameId);
		sb.append(", level5FormId=");
		sb.append(level5FormId);
		sb.append(", level6ClassNameId=");
		sb.append(level6ClassNameId);
		sb.append(", level6FormId=");
		sb.append(level6FormId);
		sb.append(", level7ClassNameId=");
		sb.append(level7ClassNameId);
		sb.append(", level7FormId=");
		sb.append(level7FormId);
		sb.append(", level8ClassNameId=");
		sb.append(level8ClassNameId);
		sb.append(", level8FormId=");
		sb.append(level8FormId);
		sb.append(", level9ClassNameId=");
		sb.append(level9ClassNameId);
		sb.append(", level9FormId=");
		sb.append(level9FormId);
		sb.append(", level10ClassNameId=");
		sb.append(level10ClassNameId);
		sb.append(", level10FormId=");
		sb.append(level10FormId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPComponentTemplate toEntityModel() {
		SPComponentTemplateImpl spComponentTemplateImpl = new SPComponentTemplateImpl();

		if (uuid == null) {
			spComponentTemplateImpl.setUuid(StringPool.BLANK);
		}
		else {
			spComponentTemplateImpl.setUuid(uuid);
		}

		spComponentTemplateImpl.setSpComponentTemplateId(spComponentTemplateId);
		spComponentTemplateImpl.setGroupId(groupId);
		spComponentTemplateImpl.setCompanyId(companyId);
		spComponentTemplateImpl.setUserId(userId);

		if (userName == null) {
			spComponentTemplateImpl.setUserName(StringPool.BLANK);
		}
		else {
			spComponentTemplateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spComponentTemplateImpl.setCreateDate(null);
		}
		else {
			spComponentTemplateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spComponentTemplateImpl.setModifiedDate(null);
		}
		else {
			spComponentTemplateImpl.setModifiedDate(new Date(modifiedDate));
		}

		spComponentTemplateImpl.setCreateBy(createBy);
		spComponentTemplateImpl.setModifiedBy(modifiedBy);
		spComponentTemplateImpl.setSpTemplateId(spTemplateId);
		spComponentTemplateImpl.setLevel0ClassNameId(level0ClassNameId);
		spComponentTemplateImpl.setLevel0FormId(level0FormId);
		spComponentTemplateImpl.setLevel1ClassNameId(level1ClassNameId);
		spComponentTemplateImpl.setLevel1FormId(level1FormId);
		spComponentTemplateImpl.setLevel2ClassNameId(level2ClassNameId);
		spComponentTemplateImpl.setLevel2FormId(level2FormId);
		spComponentTemplateImpl.setLevel3ClassNameId(level3ClassNameId);
		spComponentTemplateImpl.setLevel3FormId(level3FormId);
		spComponentTemplateImpl.setLevel4ClassNameId(level4ClassNameId);
		spComponentTemplateImpl.setLevel4FormId(level4FormId);
		spComponentTemplateImpl.setLevel5ClassNameId(level5ClassNameId);
		spComponentTemplateImpl.setLevel5FormId(level5FormId);
		spComponentTemplateImpl.setLevel6ClassNameId(level6ClassNameId);
		spComponentTemplateImpl.setLevel6FormId(level6FormId);
		spComponentTemplateImpl.setLevel7ClassNameId(level7ClassNameId);
		spComponentTemplateImpl.setLevel7FormId(level7FormId);
		spComponentTemplateImpl.setLevel8ClassNameId(level8ClassNameId);
		spComponentTemplateImpl.setLevel8FormId(level8FormId);
		spComponentTemplateImpl.setLevel9ClassNameId(level9ClassNameId);
		spComponentTemplateImpl.setLevel9FormId(level9FormId);
		spComponentTemplateImpl.setLevel10ClassNameId(level10ClassNameId);
		spComponentTemplateImpl.setLevel10FormId(level10FormId);
		spComponentTemplateImpl.setStatus(status);

		spComponentTemplateImpl.resetOriginalValues();

		return spComponentTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spComponentTemplateId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		createBy = objectInput.readLong();
		modifiedBy = objectInput.readLong();
		spTemplateId = objectInput.readLong();
		level0ClassNameId = objectInput.readLong();
		level0FormId = objectInput.readLong();
		level1ClassNameId = objectInput.readLong();
		level1FormId = objectInput.readLong();
		level2ClassNameId = objectInput.readLong();
		level2FormId = objectInput.readLong();
		level3ClassNameId = objectInput.readLong();
		level3FormId = objectInput.readLong();
		level4ClassNameId = objectInput.readLong();
		level4FormId = objectInput.readLong();
		level5ClassNameId = objectInput.readLong();
		level5FormId = objectInput.readLong();
		level6ClassNameId = objectInput.readLong();
		level6FormId = objectInput.readLong();
		level7ClassNameId = objectInput.readLong();
		level7FormId = objectInput.readLong();
		level8ClassNameId = objectInput.readLong();
		level8FormId = objectInput.readLong();
		level9ClassNameId = objectInput.readLong();
		level9FormId = objectInput.readLong();
		level10ClassNameId = objectInput.readLong();
		level10FormId = objectInput.readLong();
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

		objectOutput.writeLong(spComponentTemplateId);
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
		objectOutput.writeLong(spTemplateId);
		objectOutput.writeLong(level0ClassNameId);
		objectOutput.writeLong(level0FormId);
		objectOutput.writeLong(level1ClassNameId);
		objectOutput.writeLong(level1FormId);
		objectOutput.writeLong(level2ClassNameId);
		objectOutput.writeLong(level2FormId);
		objectOutput.writeLong(level3ClassNameId);
		objectOutput.writeLong(level3FormId);
		objectOutput.writeLong(level4ClassNameId);
		objectOutput.writeLong(level4FormId);
		objectOutput.writeLong(level5ClassNameId);
		objectOutput.writeLong(level5FormId);
		objectOutput.writeLong(level6ClassNameId);
		objectOutput.writeLong(level6FormId);
		objectOutput.writeLong(level7ClassNameId);
		objectOutput.writeLong(level7FormId);
		objectOutput.writeLong(level8ClassNameId);
		objectOutput.writeLong(level8FormId);
		objectOutput.writeLong(level9ClassNameId);
		objectOutput.writeLong(level9FormId);
		objectOutput.writeLong(level10ClassNameId);
		objectOutput.writeLong(level10FormId);
		objectOutput.writeInt(status);
	}

	public String uuid;
	public long spComponentTemplateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long createBy;
	public long modifiedBy;
	public long spTemplateId;
	public long level0ClassNameId;
	public long level0FormId;
	public long level1ClassNameId;
	public long level1FormId;
	public long level2ClassNameId;
	public long level2FormId;
	public long level3ClassNameId;
	public long level3FormId;
	public long level4ClassNameId;
	public long level4FormId;
	public long level5ClassNameId;
	public long level5FormId;
	public long level6ClassNameId;
	public long level6FormId;
	public long level7ClassNameId;
	public long level7FormId;
	public long level8ClassNameId;
	public long level8FormId;
	public long level9ClassNameId;
	public long level9FormId;
	public long level10ClassNameId;
	public long level10FormId;
	public int status;
}