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

import com.sambaash.platform.srv.model.Product;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author gauravvijayvergia
 * @see Product
 * @generated
 */
public class ProductCacheModel implements CacheModel<Product>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

		sb.append("{spProductId=");
		sb.append(spProductId);
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
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", productCode=");
		sb.append(productCode);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", productDesc=");
		sb.append(productDesc);
		sb.append(", productImageId=");
		sb.append(productImageId);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append(", productBrochuresFolderId=");
		sb.append(productBrochuresFolderId);
		sb.append(", productVideoFolderId=");
		sb.append(productVideoFolderId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", creditValues=");
		sb.append(creditValues);
		sb.append(", PEProcessId=");
		sb.append(PEProcessId);
		sb.append(", productTemplateName=");
		sb.append(productTemplateName);
		sb.append(", productTemplateLanguage=");
		sb.append(productTemplateLanguage);
		sb.append(", registrationEnabled=");
		sb.append(registrationEnabled);
		sb.append(", samePageRegistration=");
		sb.append(samePageRegistration);
		sb.append(", productFormImageId=");
		sb.append(productFormImageId);
		sb.append(", productFormName=");
		sb.append(productFormName);
		sb.append(", productFormButtonName=");
		sb.append(productFormButtonName);
		sb.append(", productFormUrl=");
		sb.append(productFormUrl);
		sb.append(", productBannerImageId=");
		sb.append(productBannerImageId);
		sb.append(", hasInventory=");
		sb.append(hasInventory);
		sb.append(", bannerDetailsEnabled=");
		sb.append(bannerDetailsEnabled);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Product toEntityModel() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setSpProductId(spProductId);
		productImpl.setGroupId(groupId);
		productImpl.setCompanyId(companyId);
		productImpl.setUserId(userId);

		if (userName == null) {
			productImpl.setUserName(StringPool.BLANK);
		}
		else {
			productImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			productImpl.setCreateDate(null);
		}
		else {
			productImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productImpl.setModifiedDate(null);
		}
		else {
			productImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (countryId == null) {
			productImpl.setCountryId(StringPool.BLANK);
		}
		else {
			productImpl.setCountryId(countryId);
		}

		if (productCode == null) {
			productImpl.setProductCode(StringPool.BLANK);
		}
		else {
			productImpl.setProductCode(productCode);
		}

		if (productName == null) {
			productImpl.setProductName(StringPool.BLANK);
		}
		else {
			productImpl.setProductName(productName);
		}

		if (productDesc == null) {
			productImpl.setProductDesc(StringPool.BLANK);
		}
		else {
			productImpl.setProductDesc(productDesc);
		}

		productImpl.setProductImageId(productImageId);
		productImpl.setSpCourseId(spCourseId);
		productImpl.setProductBrochuresFolderId(productBrochuresFolderId);
		productImpl.setProductVideoFolderId(productVideoFolderId);
		productImpl.setStatus(status);
		productImpl.setCreditValues(creditValues);
		productImpl.setPEProcessId(PEProcessId);

		if (productTemplateName == null) {
			productImpl.setProductTemplateName(StringPool.BLANK);
		}
		else {
			productImpl.setProductTemplateName(productTemplateName);
		}

		if (productTemplateLanguage == null) {
			productImpl.setProductTemplateLanguage(StringPool.BLANK);
		}
		else {
			productImpl.setProductTemplateLanguage(productTemplateLanguage);
		}

		if (registrationEnabled == null) {
			productImpl.setRegistrationEnabled(StringPool.BLANK);
		}
		else {
			productImpl.setRegistrationEnabled(registrationEnabled);
		}

		if (samePageRegistration == null) {
			productImpl.setSamePageRegistration(StringPool.BLANK);
		}
		else {
			productImpl.setSamePageRegistration(samePageRegistration);
		}

		productImpl.setProductFormImageId(productFormImageId);

		if (productFormName == null) {
			productImpl.setProductFormName(StringPool.BLANK);
		}
		else {
			productImpl.setProductFormName(productFormName);
		}

		if (productFormButtonName == null) {
			productImpl.setProductFormButtonName(StringPool.BLANK);
		}
		else {
			productImpl.setProductFormButtonName(productFormButtonName);
		}

		if (productFormUrl == null) {
			productImpl.setProductFormUrl(StringPool.BLANK);
		}
		else {
			productImpl.setProductFormUrl(productFormUrl);
		}

		productImpl.setProductBannerImageId(productBannerImageId);
		productImpl.setHasInventory(hasInventory);

		if (bannerDetailsEnabled == null) {
			productImpl.setBannerDetailsEnabled(StringPool.BLANK);
		}
		else {
			productImpl.setBannerDetailsEnabled(bannerDetailsEnabled);
		}

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spProductId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryId = objectInput.readUTF();
		productCode = objectInput.readUTF();
		productName = objectInput.readUTF();
		productDesc = objectInput.readUTF();
		productImageId = objectInput.readLong();
		spCourseId = objectInput.readLong();
		productBrochuresFolderId = objectInput.readLong();
		productVideoFolderId = objectInput.readLong();
		status = objectInput.readInt();
		creditValues = objectInput.readLong();
		PEProcessId = objectInput.readLong();
		productTemplateName = objectInput.readUTF();
		productTemplateLanguage = objectInput.readUTF();
		registrationEnabled = objectInput.readUTF();
		samePageRegistration = objectInput.readUTF();
		productFormImageId = objectInput.readLong();
		productFormName = objectInput.readUTF();
		productFormButtonName = objectInput.readUTF();
		productFormUrl = objectInput.readUTF();
		productBannerImageId = objectInput.readLong();
		hasInventory = objectInput.readBoolean();
		bannerDetailsEnabled = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spProductId);
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

		if (countryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryId);
		}

		if (productCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productCode);
		}

		if (productName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productName);
		}

		if (productDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productDesc);
		}

		objectOutput.writeLong(productImageId);
		objectOutput.writeLong(spCourseId);
		objectOutput.writeLong(productBrochuresFolderId);
		objectOutput.writeLong(productVideoFolderId);
		objectOutput.writeInt(status);
		objectOutput.writeLong(creditValues);
		objectOutput.writeLong(PEProcessId);

		if (productTemplateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productTemplateName);
		}

		if (productTemplateLanguage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productTemplateLanguage);
		}

		if (registrationEnabled == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(registrationEnabled);
		}

		if (samePageRegistration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(samePageRegistration);
		}

		objectOutput.writeLong(productFormImageId);

		if (productFormName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productFormName);
		}

		if (productFormButtonName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productFormButtonName);
		}

		if (productFormUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productFormUrl);
		}

		objectOutput.writeLong(productBannerImageId);
		objectOutput.writeBoolean(hasInventory);

		if (bannerDetailsEnabled == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bannerDetailsEnabled);
		}
	}

	public long spProductId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String countryId;
	public String productCode;
	public String productName;
	public String productDesc;
	public long productImageId;
	public long spCourseId;
	public long productBrochuresFolderId;
	public long productVideoFolderId;
	public int status;
	public long creditValues;
	public long PEProcessId;
	public String productTemplateName;
	public String productTemplateLanguage;
	public String registrationEnabled;
	public String samePageRegistration;
	public long productFormImageId;
	public String productFormName;
	public String productFormButtonName;
	public String productFormUrl;
	public long productBannerImageId;
	public boolean hasInventory;
	public String bannerDetailsEnabled;
}