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

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.startupprofile.model.ATODocument;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ATODocument in entity cache.
 *
 * @author pradeep
 * @see ATODocument
 * @generated
 */
public class ATODocumentCacheModel implements CacheModel<ATODocument>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", atoDocumentId=");
		sb.append(atoDocumentId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", documentType=");
		sb.append(documentType);
		sb.append(", documentFileId=");
		sb.append(documentFileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ATODocument toEntityModel() {
		ATODocumentImpl atoDocumentImpl = new ATODocumentImpl();

		if (uuid == null) {
			atoDocumentImpl.setUuid(StringPool.BLANK);
		}
		else {
			atoDocumentImpl.setUuid(uuid);
		}

		atoDocumentImpl.setAtoDocumentId(atoDocumentId);
		atoDocumentImpl.setOrganizationId(organizationId);

		if (documentType == null) {
			atoDocumentImpl.setDocumentType(StringPool.BLANK);
		}
		else {
			atoDocumentImpl.setDocumentType(documentType);
		}

		if (documentFileId == null) {
			atoDocumentImpl.setDocumentFileId(StringPool.BLANK);
		}
		else {
			atoDocumentImpl.setDocumentFileId(documentFileId);
		}

		atoDocumentImpl.resetOriginalValues();

		return atoDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		atoDocumentId = objectInput.readLong();
		organizationId = objectInput.readLong();
		documentType = objectInput.readUTF();
		documentFileId = objectInput.readUTF();
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

		objectOutput.writeLong(atoDocumentId);
		objectOutput.writeLong(organizationId);

		if (documentType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(documentType);
		}

		if (documentFileId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(documentFileId);
		}
	}

	public String uuid;
	public long atoDocumentId;
	public long organizationId;
	public String documentType;
	public String documentFileId;
}