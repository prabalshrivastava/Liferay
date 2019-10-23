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

import com.sambaash.platform.srv.mail.model.SPMailTemplate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPMailTemplate in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPMailTemplate
 * @generated
 */
public class SPMailTemplateCacheModel implements CacheModel<SPMailTemplate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{spMailTemplateId=");
		sb.append(spMailTemplateId);
		sb.append(", productTypeId=");
		sb.append(productTypeId);
		sb.append(", subProductTypeId=");
		sb.append(subProductTypeId);
		sb.append(", templateName=");
		sb.append(templateName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", htmlContent=");
		sb.append(htmlContent);
		sb.append(", textContent=");
		sb.append(textContent);
		sb.append(", htmlUpload=");
		sb.append(htmlUpload);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createBy=");
		sb.append(createBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", parentTempalteId=");
		sb.append(parentTempalteId);
		sb.append(", versionNumber=");
		sb.append(versionNumber);
		sb.append(", fromAddress=");
		sb.append(fromAddress);
		sb.append(", fromName=");
		sb.append(fromName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPMailTemplate toEntityModel() {
		SPMailTemplateImpl spMailTemplateImpl = new SPMailTemplateImpl();

		spMailTemplateImpl.setSpMailTemplateId(spMailTemplateId);
		spMailTemplateImpl.setProductTypeId(productTypeId);
		spMailTemplateImpl.setSubProductTypeId(subProductTypeId);

		if (templateName == null) {
			spMailTemplateImpl.setTemplateName(StringPool.BLANK);
		}
		else {
			spMailTemplateImpl.setTemplateName(templateName);
		}

		spMailTemplateImpl.setGroupId(groupId);
		spMailTemplateImpl.setCompanyId(companyId);

		if (subject == null) {
			spMailTemplateImpl.setSubject(StringPool.BLANK);
		}
		else {
			spMailTemplateImpl.setSubject(subject);
		}

		if (htmlContent == null) {
			spMailTemplateImpl.setHtmlContent(StringPool.BLANK);
		}
		else {
			spMailTemplateImpl.setHtmlContent(htmlContent);
		}

		if (textContent == null) {
			spMailTemplateImpl.setTextContent(StringPool.BLANK);
		}
		else {
			spMailTemplateImpl.setTextContent(textContent);
		}

		spMailTemplateImpl.setHtmlUpload(htmlUpload);
		spMailTemplateImpl.setStatus(status);
		spMailTemplateImpl.setCreateBy(createBy);

		if (createDate == Long.MIN_VALUE) {
			spMailTemplateImpl.setCreateDate(null);
		}
		else {
			spMailTemplateImpl.setCreateDate(new Date(createDate));
		}

		spMailTemplateImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			spMailTemplateImpl.setModifiedDate(null);
		}
		else {
			spMailTemplateImpl.setModifiedDate(new Date(modifiedDate));
		}

		spMailTemplateImpl.setParentTempalteId(parentTempalteId);

		if (versionNumber == null) {
			spMailTemplateImpl.setVersionNumber(StringPool.BLANK);
		}
		else {
			spMailTemplateImpl.setVersionNumber(versionNumber);
		}

		if (fromAddress == null) {
			spMailTemplateImpl.setFromAddress(StringPool.BLANK);
		}
		else {
			spMailTemplateImpl.setFromAddress(fromAddress);
		}

		if (fromName == null) {
			spMailTemplateImpl.setFromName(StringPool.BLANK);
		}
		else {
			spMailTemplateImpl.setFromName(fromName);
		}

		spMailTemplateImpl.resetOriginalValues();

		return spMailTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spMailTemplateId = objectInput.readLong();
		productTypeId = objectInput.readLong();
		subProductTypeId = objectInput.readLong();
		templateName = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		subject = objectInput.readUTF();
		htmlContent = objectInput.readUTF();
		textContent = objectInput.readUTF();
		htmlUpload = objectInput.readBoolean();
		status = objectInput.readBoolean();
		createBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		parentTempalteId = objectInput.readLong();
		versionNumber = objectInput.readUTF();
		fromAddress = objectInput.readUTF();
		fromName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spMailTemplateId);
		objectOutput.writeLong(productTypeId);
		objectOutput.writeLong(subProductTypeId);

		if (templateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateName);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (htmlContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htmlContent);
		}

		if (textContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(textContent);
		}

		objectOutput.writeBoolean(htmlUpload);
		objectOutput.writeBoolean(status);
		objectOutput.writeLong(createBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(parentTempalteId);

		if (versionNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(versionNumber);
		}

		if (fromAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromAddress);
		}

		if (fromName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromName);
		}
	}

	public long spMailTemplateId;
	public long productTypeId;
	public long subProductTypeId;
	public String templateName;
	public long groupId;
	public long companyId;
	public String subject;
	public String htmlContent;
	public String textContent;
	public boolean htmlUpload;
	public boolean status;
	public long createBy;
	public long createDate;
	public long modifiedBy;
	public long modifiedDate;
	public long parentTempalteId;
	public String versionNumber;
	public String fromAddress;
	public String fromName;
}