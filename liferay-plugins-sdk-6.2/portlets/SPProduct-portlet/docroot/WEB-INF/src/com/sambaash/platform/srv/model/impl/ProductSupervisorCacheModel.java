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

package com.sambaash.platform.srv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.model.ProductSupervisor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductSupervisor in entity cache.
 *
 * @author gauravvijayvergia
 * @see ProductSupervisor
 * @generated
 */
public class ProductSupervisorCacheModel implements CacheModel<ProductSupervisor>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spProductSupervisorId=");
		sb.append(spProductSupervisorId);
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
		sb.append(", countryName=");
		sb.append(countryName);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", supervisorId=");
		sb.append(supervisorId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductSupervisor toEntityModel() {
		ProductSupervisorImpl productSupervisorImpl = new ProductSupervisorImpl();

		productSupervisorImpl.setSpProductSupervisorId(spProductSupervisorId);
		productSupervisorImpl.setGroupId(groupId);
		productSupervisorImpl.setCompanyId(companyId);
		productSupervisorImpl.setUserId(userId);

		if (userName == null) {
			productSupervisorImpl.setUserName(StringPool.BLANK);
		}
		else {
			productSupervisorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productSupervisorImpl.setCreateDate(null);
		}
		else {
			productSupervisorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productSupervisorImpl.setModifiedDate(null);
		}
		else {
			productSupervisorImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (countryName == null) {
			productSupervisorImpl.setCountryName(StringPool.BLANK);
		}
		else {
			productSupervisorImpl.setCountryName(countryName);
		}

		productSupervisorImpl.setCountryId(countryId);
		productSupervisorImpl.setProductId(productId);
		productSupervisorImpl.setSupervisorId(supervisorId);

		productSupervisorImpl.resetOriginalValues();

		return productSupervisorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spProductSupervisorId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryName = objectInput.readUTF();
		countryId = objectInput.readLong();
		productId = objectInput.readLong();
		supervisorId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spProductSupervisorId);
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

		if (countryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryName);
		}

		objectOutput.writeLong(countryId);
		objectOutput.writeLong(productId);
		objectOutput.writeLong(supervisorId);
	}

	public long spProductSupervisorId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String countryName;
	public long countryId;
	public long productId;
	public long supervisorId;
}