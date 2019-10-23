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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Note service. Represents a row in the &quot;SPNote&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.NoteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.NoteImpl}.
 * </p>
 *
 * @author aishwarya
 * @see Note
 * @see com.sambaash.platform.srv.model.impl.NoteImpl
 * @see com.sambaash.platform.srv.model.impl.NoteModelImpl
 * @generated
 */
public interface NoteModel extends BaseModel<Note>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a note model instance should use the {@link Note} interface instead.
	 */

	/**
	 * Returns the primary key of this note.
	 *
	 * @return the primary key of this note
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this note.
	 *
	 * @param primaryKey the primary key of this note
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp note ID of this note.
	 *
	 * @return the sp note ID of this note
	 */
	public long getSpNoteId();

	/**
	 * Sets the sp note ID of this note.
	 *
	 * @param spNoteId the sp note ID of this note
	 */
	public void setSpNoteId(long spNoteId);

	/**
	 * Returns the group ID of this note.
	 *
	 * @return the group ID of this note
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this note.
	 *
	 * @param groupId the group ID of this note
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this note.
	 *
	 * @return the company ID of this note
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this note.
	 *
	 * @param companyId the company ID of this note
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this note.
	 *
	 * @return the user ID of this note
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this note.
	 *
	 * @param userId the user ID of this note
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this note.
	 *
	 * @return the user uuid of this note
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this note.
	 *
	 * @param userUuid the user uuid of this note
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this note.
	 *
	 * @return the user name of this note
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this note.
	 *
	 * @param userName the user name of this note
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this note.
	 *
	 * @return the create date of this note
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this note.
	 *
	 * @param createDate the create date of this note
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this note.
	 *
	 * @return the modified date of this note
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this note.
	 *
	 * @param modifiedDate the modified date of this note
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the entity class ID of this note.
	 *
	 * @return the entity class ID of this note
	 */
	public long getEntityClassId();

	/**
	 * Sets the entity class ID of this note.
	 *
	 * @param entityClassId the entity class ID of this note
	 */
	public void setEntityClassId(long entityClassId);

	/**
	 * Returns the entity class name of this note.
	 *
	 * @return the entity class name of this note
	 */
	@AutoEscape
	public String getEntityClassName();

	/**
	 * Sets the entity class name of this note.
	 *
	 * @param entityClassName the entity class name of this note
	 */
	public void setEntityClassName(String entityClassName);

	/**
	 * Returns the entity ID of this note.
	 *
	 * @return the entity ID of this note
	 */
	public long getEntityId();

	/**
	 * Sets the entity ID of this note.
	 *
	 * @param entityId the entity ID of this note
	 */
	public void setEntityId(long entityId);

	/**
	 * Returns the saved by user ID of this note.
	 *
	 * @return the saved by user ID of this note
	 */
	public long getSavedByUserId();

	/**
	 * Sets the saved by user ID of this note.
	 *
	 * @param savedByUserId the saved by user ID of this note
	 */
	public void setSavedByUserId(long savedByUserId);

	/**
	 * Returns the saved by user uuid of this note.
	 *
	 * @return the saved by user uuid of this note
	 * @throws SystemException if a system exception occurred
	 */
	public String getSavedByUserUuid() throws SystemException;

	/**
	 * Sets the saved by user uuid of this note.
	 *
	 * @param savedByUserUuid the saved by user uuid of this note
	 */
	public void setSavedByUserUuid(String savedByUserUuid);

	/**
	 * Returns the note title of this note.
	 *
	 * @return the note title of this note
	 */
	@AutoEscape
	public String getNoteTitle();

	/**
	 * Sets the note title of this note.
	 *
	 * @param noteTitle the note title of this note
	 */
	public void setNoteTitle(String noteTitle);

	/**
	 * Returns the note content of this note.
	 *
	 * @return the note content of this note
	 */
	@AutoEscape
	public String getNoteContent();

	/**
	 * Sets the note content of this note.
	 *
	 * @param noteContent the note content of this note
	 */
	public void setNoteContent(String noteContent);

	/**
	 * Returns the file entry ID of this note.
	 *
	 * @return the file entry ID of this note
	 */
	@AutoEscape
	public String getFileEntryId();

	/**
	 * Sets the file entry ID of this note.
	 *
	 * @param fileEntryId the file entry ID of this note
	 */
	public void setFileEntryId(String fileEntryId);

	/**
	 * Returns the associated with of this note.
	 *
	 * @return the associated with of this note
	 */
	public long getAssociatedWith();

	/**
	 * Sets the associated with of this note.
	 *
	 * @param associatedWith the associated with of this note
	 */
	public void setAssociatedWith(long associatedWith);

	/**
	 * Returns the status of this note.
	 *
	 * @return the status of this note
	 */
	public int getStatus();

	/**
	 * Sets the status of this note.
	 *
	 * @param status the status of this note
	 */
	public void setStatus(int status);

	/**
	 * Returns the parent note ID of this note.
	 *
	 * @return the parent note ID of this note
	 */
	public long getParentNoteId();

	/**
	 * Sets the parent note ID of this note.
	 *
	 * @param parentNoteId the parent note ID of this note
	 */
	public void setParentNoteId(long parentNoteId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Note note);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.Note> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.Note toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.Note toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}