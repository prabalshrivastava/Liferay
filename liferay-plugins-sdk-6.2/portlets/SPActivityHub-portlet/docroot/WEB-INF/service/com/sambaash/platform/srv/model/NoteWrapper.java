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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Note}.
 * </p>
 *
 * @author aishwarya
 * @see Note
 * @generated
 */
public class NoteWrapper implements Note, ModelWrapper<Note> {
	public NoteWrapper(Note note) {
		_note = note;
	}

	@Override
	public Class<?> getModelClass() {
		return Note.class;
	}

	@Override
	public String getModelClassName() {
		return Note.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spNoteId", getSpNoteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("entityClassName", getEntityClassName());
		attributes.put("entityId", getEntityId());
		attributes.put("savedByUserId", getSavedByUserId());
		attributes.put("noteTitle", getNoteTitle());
		attributes.put("noteContent", getNoteContent());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("associatedWith", getAssociatedWith());
		attributes.put("status", getStatus());
		attributes.put("parentNoteId", getParentNoteId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spNoteId = (Long)attributes.get("spNoteId");

		if (spNoteId != null) {
			setSpNoteId(spNoteId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long entityClassId = (Long)attributes.get("entityClassId");

		if (entityClassId != null) {
			setEntityClassId(entityClassId);
		}

		String entityClassName = (String)attributes.get("entityClassName");

		if (entityClassName != null) {
			setEntityClassName(entityClassName);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long savedByUserId = (Long)attributes.get("savedByUserId");

		if (savedByUserId != null) {
			setSavedByUserId(savedByUserId);
		}

		String noteTitle = (String)attributes.get("noteTitle");

		if (noteTitle != null) {
			setNoteTitle(noteTitle);
		}

		String noteContent = (String)attributes.get("noteContent");

		if (noteContent != null) {
			setNoteContent(noteContent);
		}

		String fileEntryId = (String)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long associatedWith = (Long)attributes.get("associatedWith");

		if (associatedWith != null) {
			setAssociatedWith(associatedWith);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long parentNoteId = (Long)attributes.get("parentNoteId");

		if (parentNoteId != null) {
			setParentNoteId(parentNoteId);
		}
	}

	/**
	* Returns the primary key of this note.
	*
	* @return the primary key of this note
	*/
	@Override
	public long getPrimaryKey() {
		return _note.getPrimaryKey();
	}

	/**
	* Sets the primary key of this note.
	*
	* @param primaryKey the primary key of this note
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_note.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp note ID of this note.
	*
	* @return the sp note ID of this note
	*/
	@Override
	public long getSpNoteId() {
		return _note.getSpNoteId();
	}

	/**
	* Sets the sp note ID of this note.
	*
	* @param spNoteId the sp note ID of this note
	*/
	@Override
	public void setSpNoteId(long spNoteId) {
		_note.setSpNoteId(spNoteId);
	}

	/**
	* Returns the group ID of this note.
	*
	* @return the group ID of this note
	*/
	@Override
	public long getGroupId() {
		return _note.getGroupId();
	}

	/**
	* Sets the group ID of this note.
	*
	* @param groupId the group ID of this note
	*/
	@Override
	public void setGroupId(long groupId) {
		_note.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this note.
	*
	* @return the company ID of this note
	*/
	@Override
	public long getCompanyId() {
		return _note.getCompanyId();
	}

	/**
	* Sets the company ID of this note.
	*
	* @param companyId the company ID of this note
	*/
	@Override
	public void setCompanyId(long companyId) {
		_note.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this note.
	*
	* @return the user ID of this note
	*/
	@Override
	public long getUserId() {
		return _note.getUserId();
	}

	/**
	* Sets the user ID of this note.
	*
	* @param userId the user ID of this note
	*/
	@Override
	public void setUserId(long userId) {
		_note.setUserId(userId);
	}

	/**
	* Returns the user uuid of this note.
	*
	* @return the user uuid of this note
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _note.getUserUuid();
	}

	/**
	* Sets the user uuid of this note.
	*
	* @param userUuid the user uuid of this note
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_note.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this note.
	*
	* @return the user name of this note
	*/
	@Override
	public java.lang.String getUserName() {
		return _note.getUserName();
	}

	/**
	* Sets the user name of this note.
	*
	* @param userName the user name of this note
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_note.setUserName(userName);
	}

	/**
	* Returns the create date of this note.
	*
	* @return the create date of this note
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _note.getCreateDate();
	}

	/**
	* Sets the create date of this note.
	*
	* @param createDate the create date of this note
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_note.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this note.
	*
	* @return the modified date of this note
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _note.getModifiedDate();
	}

	/**
	* Sets the modified date of this note.
	*
	* @param modifiedDate the modified date of this note
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_note.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the entity class ID of this note.
	*
	* @return the entity class ID of this note
	*/
	@Override
	public long getEntityClassId() {
		return _note.getEntityClassId();
	}

	/**
	* Sets the entity class ID of this note.
	*
	* @param entityClassId the entity class ID of this note
	*/
	@Override
	public void setEntityClassId(long entityClassId) {
		_note.setEntityClassId(entityClassId);
	}

	/**
	* Returns the entity class name of this note.
	*
	* @return the entity class name of this note
	*/
	@Override
	public java.lang.String getEntityClassName() {
		return _note.getEntityClassName();
	}

	/**
	* Sets the entity class name of this note.
	*
	* @param entityClassName the entity class name of this note
	*/
	@Override
	public void setEntityClassName(java.lang.String entityClassName) {
		_note.setEntityClassName(entityClassName);
	}

	/**
	* Returns the entity ID of this note.
	*
	* @return the entity ID of this note
	*/
	@Override
	public long getEntityId() {
		return _note.getEntityId();
	}

	/**
	* Sets the entity ID of this note.
	*
	* @param entityId the entity ID of this note
	*/
	@Override
	public void setEntityId(long entityId) {
		_note.setEntityId(entityId);
	}

	/**
	* Returns the saved by user ID of this note.
	*
	* @return the saved by user ID of this note
	*/
	@Override
	public long getSavedByUserId() {
		return _note.getSavedByUserId();
	}

	/**
	* Sets the saved by user ID of this note.
	*
	* @param savedByUserId the saved by user ID of this note
	*/
	@Override
	public void setSavedByUserId(long savedByUserId) {
		_note.setSavedByUserId(savedByUserId);
	}

	/**
	* Returns the saved by user uuid of this note.
	*
	* @return the saved by user uuid of this note
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getSavedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _note.getSavedByUserUuid();
	}

	/**
	* Sets the saved by user uuid of this note.
	*
	* @param savedByUserUuid the saved by user uuid of this note
	*/
	@Override
	public void setSavedByUserUuid(java.lang.String savedByUserUuid) {
		_note.setSavedByUserUuid(savedByUserUuid);
	}

	/**
	* Returns the note title of this note.
	*
	* @return the note title of this note
	*/
	@Override
	public java.lang.String getNoteTitle() {
		return _note.getNoteTitle();
	}

	/**
	* Sets the note title of this note.
	*
	* @param noteTitle the note title of this note
	*/
	@Override
	public void setNoteTitle(java.lang.String noteTitle) {
		_note.setNoteTitle(noteTitle);
	}

	/**
	* Returns the note content of this note.
	*
	* @return the note content of this note
	*/
	@Override
	public java.lang.String getNoteContent() {
		return _note.getNoteContent();
	}

	/**
	* Sets the note content of this note.
	*
	* @param noteContent the note content of this note
	*/
	@Override
	public void setNoteContent(java.lang.String noteContent) {
		_note.setNoteContent(noteContent);
	}

	/**
	* Returns the file entry ID of this note.
	*
	* @return the file entry ID of this note
	*/
	@Override
	public java.lang.String getFileEntryId() {
		return _note.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this note.
	*
	* @param fileEntryId the file entry ID of this note
	*/
	@Override
	public void setFileEntryId(java.lang.String fileEntryId) {
		_note.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the associated with of this note.
	*
	* @return the associated with of this note
	*/
	@Override
	public long getAssociatedWith() {
		return _note.getAssociatedWith();
	}

	/**
	* Sets the associated with of this note.
	*
	* @param associatedWith the associated with of this note
	*/
	@Override
	public void setAssociatedWith(long associatedWith) {
		_note.setAssociatedWith(associatedWith);
	}

	/**
	* Returns the status of this note.
	*
	* @return the status of this note
	*/
	@Override
	public int getStatus() {
		return _note.getStatus();
	}

	/**
	* Sets the status of this note.
	*
	* @param status the status of this note
	*/
	@Override
	public void setStatus(int status) {
		_note.setStatus(status);
	}

	/**
	* Returns the parent note ID of this note.
	*
	* @return the parent note ID of this note
	*/
	@Override
	public long getParentNoteId() {
		return _note.getParentNoteId();
	}

	/**
	* Sets the parent note ID of this note.
	*
	* @param parentNoteId the parent note ID of this note
	*/
	@Override
	public void setParentNoteId(long parentNoteId) {
		_note.setParentNoteId(parentNoteId);
	}

	@Override
	public boolean isNew() {
		return _note.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_note.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _note.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_note.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _note.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _note.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_note.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _note.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_note.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_note.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_note.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NoteWrapper((Note)_note.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Note note) {
		return _note.compareTo(note);
	}

	@Override
	public int hashCode() {
		return _note.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Note> toCacheModel() {
		return _note.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Note toEscapedModel() {
		return new NoteWrapper(_note.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Note toUnescapedModel() {
		return new NoteWrapper(_note.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _note.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _note.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_note.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NoteWrapper)) {
			return false;
		}

		NoteWrapper noteWrapper = (NoteWrapper)obj;

		if (Validator.equals(_note, noteWrapper._note)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Note getWrappedNote() {
		return _note;
	}

	@Override
	public Note getWrappedModel() {
		return _note;
	}

	@Override
	public void resetOriginalValues() {
		_note.resetOriginalValues();
	}

	private Note _note;
}