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

package com.sambaash.platform.srv.roles.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.roles.model.SPCategoriesMapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPCategoriesMapping in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPCategoriesMapping
 * @generated
 */
public class SPCategoriesMappingCacheModel implements CacheModel<SPCategoriesMapping>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spCategoryMappingId=");
		sb.append(spCategoryMappingId);
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
		sb.append(", createdVocabularyId=");
		sb.append(createdVocabularyId);
		sb.append(", mainCategoryId=");
		sb.append(mainCategoryId);
		sb.append(", subCategoryId=");
		sb.append(subCategoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPCategoriesMapping toEntityModel() {
		SPCategoriesMappingImpl spCategoriesMappingImpl = new SPCategoriesMappingImpl();

		if (uuid == null) {
			spCategoriesMappingImpl.setUuid(StringPool.BLANK);
		}
		else {
			spCategoriesMappingImpl.setUuid(uuid);
		}

		spCategoriesMappingImpl.setSpCategoryMappingId(spCategoryMappingId);
		spCategoriesMappingImpl.setGroupId(groupId);
		spCategoriesMappingImpl.setCompanyId(companyId);
		spCategoriesMappingImpl.setUserId(userId);

		if (userName == null) {
			spCategoriesMappingImpl.setUserName(StringPool.BLANK);
		}
		else {
			spCategoriesMappingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spCategoriesMappingImpl.setCreateDate(null);
		}
		else {
			spCategoriesMappingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spCategoriesMappingImpl.setModifiedDate(null);
		}
		else {
			spCategoriesMappingImpl.setModifiedDate(new Date(modifiedDate));
		}

		spCategoriesMappingImpl.setCreatedVocabularyId(createdVocabularyId);
		spCategoriesMappingImpl.setMainCategoryId(mainCategoryId);
		spCategoriesMappingImpl.setSubCategoryId(subCategoryId);

		spCategoriesMappingImpl.resetOriginalValues();

		return spCategoriesMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spCategoryMappingId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		createdVocabularyId = objectInput.readLong();
		mainCategoryId = objectInput.readLong();
		subCategoryId = objectInput.readLong();
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

		objectOutput.writeLong(spCategoryMappingId);
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
		objectOutput.writeLong(createdVocabularyId);
		objectOutput.writeLong(mainCategoryId);
		objectOutput.writeLong(subCategoryId);
	}

	public String uuid;
	public long spCategoryMappingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long createdVocabularyId;
	public long mainCategoryId;
	public long subCategoryId;
}