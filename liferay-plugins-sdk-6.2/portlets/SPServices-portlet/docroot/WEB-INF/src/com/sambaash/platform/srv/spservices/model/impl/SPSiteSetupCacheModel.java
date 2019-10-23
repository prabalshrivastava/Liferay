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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.SPSiteSetup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPSiteSetup in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPSiteSetup
 * @generated
 */
public class SPSiteSetupCacheModel implements CacheModel<SPSiteSetup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spSiteSetupId=");
		sb.append(spSiteSetupId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", subProductId=");
		sb.append(subProductId);
		sb.append(", subProductName=");
		sb.append(subProductName);
		sb.append(", virtualHostId=");
		sb.append(virtualHostId);
		sb.append(", backOfficeVirtualHostId=");
		sb.append(backOfficeVirtualHostId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPSiteSetup toEntityModel() {
		SPSiteSetupImpl spSiteSetupImpl = new SPSiteSetupImpl();

		if (uuid == null) {
			spSiteSetupImpl.setUuid(StringPool.BLANK);
		}
		else {
			spSiteSetupImpl.setUuid(uuid);
		}

		spSiteSetupImpl.setSpSiteSetupId(spSiteSetupId);
		spSiteSetupImpl.setGroupId(groupId);
		spSiteSetupImpl.setProductId(productId);

		if (productName == null) {
			spSiteSetupImpl.setProductName(StringPool.BLANK);
		}
		else {
			spSiteSetupImpl.setProductName(productName);
		}

		spSiteSetupImpl.setSubProductId(subProductId);

		if (subProductName == null) {
			spSiteSetupImpl.setSubProductName(StringPool.BLANK);
		}
		else {
			spSiteSetupImpl.setSubProductName(subProductName);
		}

		spSiteSetupImpl.setVirtualHostId(virtualHostId);
		spSiteSetupImpl.setBackOfficeVirtualHostId(backOfficeVirtualHostId);
		spSiteSetupImpl.setCompanyId(companyId);
		spSiteSetupImpl.setCreatedBy(createdBy);
		spSiteSetupImpl.setModifiedBy(modifiedBy);

		if (createdDate == Long.MIN_VALUE) {
			spSiteSetupImpl.setCreatedDate(null);
		}
		else {
			spSiteSetupImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spSiteSetupImpl.setModifiedDate(null);
		}
		else {
			spSiteSetupImpl.setModifiedDate(new Date(modifiedDate));
		}

		spSiteSetupImpl.resetOriginalValues();

		return spSiteSetupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spSiteSetupId = objectInput.readLong();
		groupId = objectInput.readLong();
		productId = objectInput.readLong();
		productName = objectInput.readUTF();
		subProductId = objectInput.readLong();
		subProductName = objectInput.readUTF();
		virtualHostId = objectInput.readLong();
		backOfficeVirtualHostId = objectInput.readLong();
		companyId = objectInput.readLong();
		createdBy = objectInput.readLong();
		modifiedBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(spSiteSetupId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(productId);

		if (productName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productName);
		}

		objectOutput.writeLong(subProductId);

		if (subProductName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subProductName);
		}

		objectOutput.writeLong(virtualHostId);
		objectOutput.writeLong(backOfficeVirtualHostId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long spSiteSetupId;
	public long groupId;
	public long productId;
	public String productName;
	public long subProductId;
	public String subProductName;
	public long virtualHostId;
	public long backOfficeVirtualHostId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long createdDate;
	public long modifiedDate;
}