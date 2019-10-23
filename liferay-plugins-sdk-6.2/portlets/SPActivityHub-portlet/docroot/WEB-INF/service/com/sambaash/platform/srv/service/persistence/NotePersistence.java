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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.model.Note;

/**
 * The persistence interface for the note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see NotePersistenceImpl
 * @see NoteUtil
 * @generated
 */
public interface NotePersistence extends BasePersistence<Note> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NoteUtil} to access the note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the note where entityClassId = &#63; and entityId = &#63; and parentNoteId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchNoteException} if it could not be found.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentNoteId the parent note ID
	* @return the matching note
	* @throws com.sambaash.platform.srv.NoSuchNoteException if a matching note could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Note findByentityClassIdEntityIdParentNoteId(
		long entityClassId, long entityId, long parentNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchNoteException;

	/**
	* Returns the note where entityClassId = &#63; and entityId = &#63; and parentNoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentNoteId the parent note ID
	* @return the matching note, or <code>null</code> if a matching note could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Note fetchByentityClassIdEntityIdParentNoteId(
		long entityClassId, long entityId, long parentNoteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the note where entityClassId = &#63; and entityId = &#63; and parentNoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentNoteId the parent note ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching note, or <code>null</code> if a matching note could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Note fetchByentityClassIdEntityIdParentNoteId(
		long entityClassId, long entityId, long parentNoteId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the note where entityClassId = &#63; and entityId = &#63; and parentNoteId = &#63; from the database.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentNoteId the parent note ID
	* @return the note that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Note removeByentityClassIdEntityIdParentNoteId(
		long entityClassId, long entityId, long parentNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchNoteException;

	/**
	* Returns the number of notes where entityClassId = &#63; and entityId = &#63; and parentNoteId = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentNoteId the parent note ID
	* @return the number of matching notes
	* @throws SystemException if a system exception occurred
	*/
	public int countByentityClassIdEntityIdParentNoteId(long entityClassId,
		long entityId, long parentNoteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the note in the entity cache if it is enabled.
	*
	* @param note the note
	*/
	public void cacheResult(com.sambaash.platform.srv.model.Note note);

	/**
	* Caches the notes in the entity cache if it is enabled.
	*
	* @param notes the notes
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Note> notes);

	/**
	* Creates a new note with the primary key. Does not add the note to the database.
	*
	* @param spNoteId the primary key for the new note
	* @return the new note
	*/
	public com.sambaash.platform.srv.model.Note create(long spNoteId);

	/**
	* Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spNoteId the primary key of the note
	* @return the note that was removed
	* @throws com.sambaash.platform.srv.NoSuchNoteException if a note with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Note remove(long spNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchNoteException;

	public com.sambaash.platform.srv.model.Note updateImpl(
		com.sambaash.platform.srv.model.Note note)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the note with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchNoteException} if it could not be found.
	*
	* @param spNoteId the primary key of the note
	* @return the note
	* @throws com.sambaash.platform.srv.NoSuchNoteException if a note with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Note findByPrimaryKey(long spNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchNoteException;

	/**
	* Returns the note with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spNoteId the primary key of the note
	* @return the note, or <code>null</code> if a note with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Note fetchByPrimaryKey(long spNoteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the notes.
	*
	* @return the notes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Note> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notes
	* @param end the upper bound of the range of notes (not inclusive)
	* @return the range of notes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Note> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notes
	* @param end the upper bound of the range of notes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Note> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the notes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notes.
	*
	* @return the number of notes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}