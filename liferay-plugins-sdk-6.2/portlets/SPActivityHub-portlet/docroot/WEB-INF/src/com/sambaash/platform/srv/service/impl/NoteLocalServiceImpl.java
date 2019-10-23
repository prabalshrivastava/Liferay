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

package com.sambaash.platform.srv.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.sambaash.platform.srv.model.Note;
import com.sambaash.platform.srv.service.base.NoteLocalServiceBaseImpl;
import com.sambaash.platform.srv.service.persistence.NoteUtil;

/**
 * The implementation of the note local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.NoteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author aishwarya
 * @see com.sambaash.platform.srv.service.base.NoteLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.NoteLocalServiceUtil
 */
public class NoteLocalServiceImpl extends NoteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.NoteLocalServiceUtil} to access the note local service.
	 */
	
	public Note fetchByentityClassIdEntityIdParentNoteId(long entityClassId, long entityId, long parentNoteId) throws SystemException {
		Note note = null;
		note = NoteUtil.fetchByentityClassIdEntityIdParentNoteId(entityClassId, entityId, parentNoteId);
		return note;
	}
	
	public Note updateNote(Note spNote) throws SystemException{
		Note note = null;
		try {
			note = notePersistence.update(spNote);
			Indexer indexer = IndexerRegistryUtil.getIndexer(Note.class);
			indexer.reindex(note);
		} catch (SearchException e) {
			_log.error(e);
		}
		return note;
	}
	
	private static Log _log = LogFactoryUtil.getLog(NoteLocalServiceImpl.class);
}