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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.service.ClpSerializer;
import com.sambaash.platform.srv.service.NoteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aishwarya
 */
public class NoteClp extends BaseModelImpl<Note> implements Note {
	public NoteClp() {
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
	public long getPrimaryKey() {
		return _spNoteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpNoteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spNoteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpNoteId() {
		return _spNoteId;
	}

	@Override
	public void setSpNoteId(long spNoteId) {
		_spNoteId = spNoteId;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setSpNoteId", long.class);

				method.invoke(_noteRemoteModel, spNoteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_noteRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_noteRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_noteRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_noteRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_noteRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_noteRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityClassId() {
		return _entityClassId;
	}

	@Override
	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassId", long.class);

				method.invoke(_noteRemoteModel, entityClassId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntityClassName() {
		return _entityClassName;
	}

	@Override
	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassName",
						String.class);

				method.invoke(_noteRemoteModel, entityClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		_entityId = entityId;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityId", long.class);

				method.invoke(_noteRemoteModel, entityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSavedByUserId() {
		return _savedByUserId;
	}

	@Override
	public void setSavedByUserId(long savedByUserId) {
		_savedByUserId = savedByUserId;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setSavedByUserId", long.class);

				method.invoke(_noteRemoteModel, savedByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSavedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSavedByUserId(), "uuid",
			_savedByUserUuid);
	}

	@Override
	public void setSavedByUserUuid(String savedByUserUuid) {
		_savedByUserUuid = savedByUserUuid;
	}

	@Override
	public String getNoteTitle() {
		return _noteTitle;
	}

	@Override
	public void setNoteTitle(String noteTitle) {
		_noteTitle = noteTitle;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setNoteTitle", String.class);

				method.invoke(_noteRemoteModel, noteTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNoteContent() {
		return _noteContent;
	}

	@Override
	public void setNoteContent(String noteContent) {
		_noteContent = noteContent;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setNoteContent", String.class);

				method.invoke(_noteRemoteModel, noteContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(String fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", String.class);

				method.invoke(_noteRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssociatedWith() {
		return _associatedWith;
	}

	@Override
	public void setAssociatedWith(long associatedWith) {
		_associatedWith = associatedWith;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setAssociatedWith", long.class);

				method.invoke(_noteRemoteModel, associatedWith);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_noteRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentNoteId() {
		return _parentNoteId;
	}

	@Override
	public void setParentNoteId(long parentNoteId) {
		_parentNoteId = parentNoteId;

		if (_noteRemoteModel != null) {
			try {
				Class<?> clazz = _noteRemoteModel.getClass();

				Method method = clazz.getMethod("setParentNoteId", long.class);

				method.invoke(_noteRemoteModel, parentNoteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNoteRemoteModel() {
		return _noteRemoteModel;
	}

	public void setNoteRemoteModel(BaseModel<?> noteRemoteModel) {
		_noteRemoteModel = noteRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _noteRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_noteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NoteLocalServiceUtil.addNote(this);
		}
		else {
			NoteLocalServiceUtil.updateNote(this);
		}
	}

	@Override
	public Note toEscapedModel() {
		return (Note)ProxyUtil.newProxyInstance(Note.class.getClassLoader(),
			new Class[] { Note.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NoteClp clone = new NoteClp();

		clone.setSpNoteId(getSpNoteId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEntityClassId(getEntityClassId());
		clone.setEntityClassName(getEntityClassName());
		clone.setEntityId(getEntityId());
		clone.setSavedByUserId(getSavedByUserId());
		clone.setNoteTitle(getNoteTitle());
		clone.setNoteContent(getNoteContent());
		clone.setFileEntryId(getFileEntryId());
		clone.setAssociatedWith(getAssociatedWith());
		clone.setStatus(getStatus());
		clone.setParentNoteId(getParentNoteId());

		return clone;
	}

	@Override
	public int compareTo(Note note) {
		long primaryKey = note.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NoteClp)) {
			return false;
		}

		NoteClp note = (NoteClp)obj;

		long primaryKey = note.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{spNoteId=");
		sb.append(getSpNoteId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", entityClassId=");
		sb.append(getEntityClassId());
		sb.append(", entityClassName=");
		sb.append(getEntityClassName());
		sb.append(", entityId=");
		sb.append(getEntityId());
		sb.append(", savedByUserId=");
		sb.append(getSavedByUserId());
		sb.append(", noteTitle=");
		sb.append(getNoteTitle());
		sb.append(", noteContent=");
		sb.append(getNoteContent());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", associatedWith=");
		sb.append(getAssociatedWith());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", parentNoteId=");
		sb.append(getParentNoteId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Note");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spNoteId</column-name><column-value><![CDATA[");
		sb.append(getSpNoteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassId</column-name><column-value><![CDATA[");
		sb.append(getEntityClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassName</column-name><column-value><![CDATA[");
		sb.append(getEntityClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>savedByUserId</column-name><column-value><![CDATA[");
		sb.append(getSavedByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noteTitle</column-name><column-value><![CDATA[");
		sb.append(getNoteTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noteContent</column-name><column-value><![CDATA[");
		sb.append(getNoteContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>associatedWith</column-name><column-value><![CDATA[");
		sb.append(getAssociatedWith());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentNoteId</column-name><column-value><![CDATA[");
		sb.append(getParentNoteId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spNoteId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _entityClassId;
	private String _entityClassName;
	private long _entityId;
	private long _savedByUserId;
	private String _savedByUserUuid;
	private String _noteTitle;
	private String _noteContent;
	private String _fileEntryId;
	private long _associatedWith;
	private int _status;
	private long _parentNoteId;
	private BaseModel<?> _noteRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}