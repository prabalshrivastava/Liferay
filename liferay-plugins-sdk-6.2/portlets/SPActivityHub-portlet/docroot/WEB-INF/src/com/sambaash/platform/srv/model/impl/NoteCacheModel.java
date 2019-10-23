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

import com.sambaash.platform.srv.model.Note;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Note in entity cache.
 *
 * @author aishwarya
 * @see Note
 * @generated
 */
public class NoteCacheModel implements CacheModel<Note>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{spNoteId=");
		sb.append(spNoteId);
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
		sb.append(", entityClassId=");
		sb.append(entityClassId);
		sb.append(", entityClassName=");
		sb.append(entityClassName);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", savedByUserId=");
		sb.append(savedByUserId);
		sb.append(", noteTitle=");
		sb.append(noteTitle);
		sb.append(", noteContent=");
		sb.append(noteContent);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", associatedWith=");
		sb.append(associatedWith);
		sb.append(", status=");
		sb.append(status);
		sb.append(", parentNoteId=");
		sb.append(parentNoteId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Note toEntityModel() {
		NoteImpl noteImpl = new NoteImpl();

		noteImpl.setSpNoteId(spNoteId);
		noteImpl.setGroupId(groupId);
		noteImpl.setCompanyId(companyId);
		noteImpl.setUserId(userId);

		if (userName == null) {
			noteImpl.setUserName(StringPool.BLANK);
		}
		else {
			noteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			noteImpl.setCreateDate(null);
		}
		else {
			noteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			noteImpl.setModifiedDate(null);
		}
		else {
			noteImpl.setModifiedDate(new Date(modifiedDate));
		}

		noteImpl.setEntityClassId(entityClassId);

		if (entityClassName == null) {
			noteImpl.setEntityClassName(StringPool.BLANK);
		}
		else {
			noteImpl.setEntityClassName(entityClassName);
		}

		noteImpl.setEntityId(entityId);
		noteImpl.setSavedByUserId(savedByUserId);

		if (noteTitle == null) {
			noteImpl.setNoteTitle(StringPool.BLANK);
		}
		else {
			noteImpl.setNoteTitle(noteTitle);
		}

		if (noteContent == null) {
			noteImpl.setNoteContent(StringPool.BLANK);
		}
		else {
			noteImpl.setNoteContent(noteContent);
		}

		if (fileEntryId == null) {
			noteImpl.setFileEntryId(StringPool.BLANK);
		}
		else {
			noteImpl.setFileEntryId(fileEntryId);
		}

		noteImpl.setAssociatedWith(associatedWith);
		noteImpl.setStatus(status);
		noteImpl.setParentNoteId(parentNoteId);

		noteImpl.resetOriginalValues();

		return noteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spNoteId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		entityClassId = objectInput.readLong();
		entityClassName = objectInput.readUTF();
		entityId = objectInput.readLong();
		savedByUserId = objectInput.readLong();
		noteTitle = objectInput.readUTF();
		noteContent = objectInput.readUTF();
		fileEntryId = objectInput.readUTF();
		associatedWith = objectInput.readLong();
		status = objectInput.readInt();
		parentNoteId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spNoteId);
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
		objectOutput.writeLong(entityClassId);

		if (entityClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entityClassName);
		}

		objectOutput.writeLong(entityId);
		objectOutput.writeLong(savedByUserId);

		if (noteTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(noteTitle);
		}

		if (noteContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(noteContent);
		}

		if (fileEntryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryId);
		}

		objectOutput.writeLong(associatedWith);
		objectOutput.writeInt(status);
		objectOutput.writeLong(parentNoteId);
	}

	public long spNoteId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long entityClassId;
	public String entityClassName;
	public long entityId;
	public long savedByUserId;
	public String noteTitle;
	public String noteContent;
	public String fileEntryId;
	public long associatedWith;
	public int status;
	public long parentNoteId;
}