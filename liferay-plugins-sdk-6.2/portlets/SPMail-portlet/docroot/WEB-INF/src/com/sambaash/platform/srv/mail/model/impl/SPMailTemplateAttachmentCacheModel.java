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
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SPMailTemplateAttachment in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPMailTemplateAttachment
 * @generated
 */
public class SPMailTemplateAttachmentCacheModel implements CacheModel<SPMailTemplateAttachment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{spTemplateAttachmentId=");
		sb.append(spTemplateAttachmentId);
		sb.append(", templateId=");
		sb.append(templateId);
		sb.append(", rsvpId=");
		sb.append(rsvpId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPMailTemplateAttachment toEntityModel() {
		SPMailTemplateAttachmentImpl spMailTemplateAttachmentImpl = new SPMailTemplateAttachmentImpl();

		spMailTemplateAttachmentImpl.setSpTemplateAttachmentId(spTemplateAttachmentId);
		spMailTemplateAttachmentImpl.setTemplateId(templateId);
		spMailTemplateAttachmentImpl.setRsvpId(rsvpId);
		spMailTemplateAttachmentImpl.setFileEntryId(fileEntryId);

		spMailTemplateAttachmentImpl.resetOriginalValues();

		return spMailTemplateAttachmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spTemplateAttachmentId = objectInput.readLong();
		templateId = objectInput.readLong();
		rsvpId = objectInput.readLong();
		fileEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spTemplateAttachmentId);
		objectOutput.writeLong(templateId);
		objectOutput.writeLong(rsvpId);
		objectOutput.writeLong(fileEntryId);
	}

	public long spTemplateAttachmentId;
	public long templateId;
	public long rsvpId;
	public long fileEntryId;
}