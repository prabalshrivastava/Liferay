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

import com.sambaash.platform.srv.model.ProductCourse;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductCourse in entity cache.
 *
 * @author gauravvijayvergia
 * @see ProductCourse
 * @generated
 */
public class ProductCourseCacheModel implements CacheModel<ProductCourse>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{spProductCourseId=");
		sb.append(spProductCourseId);
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
		sb.append(", spProductId=");
		sb.append(spProductId);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductCourse toEntityModel() {
		ProductCourseImpl productCourseImpl = new ProductCourseImpl();

		productCourseImpl.setSpProductCourseId(spProductCourseId);
		productCourseImpl.setGroupId(groupId);
		productCourseImpl.setCompanyId(companyId);
		productCourseImpl.setUserId(userId);

		if (userName == null) {
			productCourseImpl.setUserName(StringPool.BLANK);
		}
		else {
			productCourseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productCourseImpl.setCreateDate(null);
		}
		else {
			productCourseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productCourseImpl.setModifiedDate(null);
		}
		else {
			productCourseImpl.setModifiedDate(new Date(modifiedDate));
		}

		productCourseImpl.setSpProductId(spProductId);
		productCourseImpl.setSpCourseId(spCourseId);

		productCourseImpl.resetOriginalValues();

		return productCourseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spProductCourseId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spProductId = objectInput.readLong();
		spCourseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spProductCourseId);
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
		objectOutput.writeLong(spProductId);
		objectOutput.writeLong(spCourseId);
	}

	public long spProductCourseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spProductId;
	public long spCourseId;
}