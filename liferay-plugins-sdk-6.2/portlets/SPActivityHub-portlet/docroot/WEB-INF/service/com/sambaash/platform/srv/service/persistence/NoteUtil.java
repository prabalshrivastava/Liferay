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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.Note;

import java.util.List;

/**
 * The persistence utility for the note service. This utility wraps {@link NotePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see NotePersistence
 * @see NotePersistenceImpl
 * @generated
 */
public class NoteUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Note note) {
		getPersistence().clearCache(note);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Note> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Note> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Note> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Note update(Note note) throws SystemException {
		return getPersistence().update(note);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Note update(Note note, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(note, serviceContext);
	}

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
	public static com.sambaash.platform.srv.model.Note findByentityClassIdEntityIdParentNoteId(
		long entityClassId, long entityId, long parentNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchNoteException {
		return getPersistence()
				   .findByentityClassIdEntityIdParentNoteId(entityClassId,
			entityId, parentNoteId);
	}

	/**
	* Returns the note where entityClassId = &#63; and entityId = &#63; and parentNoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentNoteId the parent note ID
	* @return the matching note, or <code>null</code> if a matching note could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Note fetchByentityClassIdEntityIdParentNoteId(
		long entityClassId, long entityId, long parentNoteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityClassIdEntityIdParentNoteId(entityClassId,
			entityId, parentNoteId);
	}

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
	public static com.sambaash.platform.srv.model.Note fetchByentityClassIdEntityIdParentNoteId(
		long entityClassId, long entityId, long parentNoteId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByentityClassIdEntityIdParentNoteId(entityClassId,
			entityId, parentNoteId, retrieveFromCache);
	}

	/**
	* Removes the note where entityClassId = &#63; and entityId = &#63; and parentNoteId = &#63; from the database.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentNoteId the parent note ID
	* @return the note that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Note removeByentityClassIdEntityIdParentNoteId(
		long entityClassId, long entityId, long parentNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchNoteException {
		return getPersistence()
				   .removeByentityClassIdEntityIdParentNoteId(entityClassId,
			entityId, parentNoteId);
	}

	/**
	* Returns the number of notes where entityClassId = &#63; and entityId = &#63; and parentNoteId = &#63;.
	*
	* @param entityClassId the entity class ID
	* @param entityId the entity ID
	* @param parentNoteId the parent note ID
	* @return the number of matching notes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByentityClassIdEntityIdParentNoteId(
		long entityClassId, long entityId, long parentNoteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByentityClassIdEntityIdParentNoteId(entityClassId,
			entityId, parentNoteId);
	}

	/**
	* Caches the note in the entity cache if it is enabled.
	*
	* @param note the note
	*/
	public static void cacheResult(com.sambaash.platform.srv.model.Note note) {
		getPersistence().cacheResult(note);
	}

	/**
	* Caches the notes in the entity cache if it is enabled.
	*
	* @param notes the notes
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Note> notes) {
		getPersistence().cacheResult(notes);
	}

	/**
	* Creates a new note with the primary key. Does not add the note to the database.
	*
	* @param spNoteId the primary key for the new note
	* @return the new note
	*/
	public static com.sambaash.platform.srv.model.Note create(long spNoteId) {
		return getPersistence().create(spNoteId);
	}

	/**
	* Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spNoteId the primary key of the note
	* @return the note that was removed
	* @throws com.sambaash.platform.srv.NoSuchNoteException if a note with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Note remove(long spNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchNoteException {
		return getPersistence().remove(spNoteId);
	}

	public static com.sambaash.platform.srv.model.Note updateImpl(
		com.sambaash.platform.srv.model.Note note)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(note);
	}

	/**
	* Returns the note with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchNoteException} if it could not be found.
	*
	* @param spNoteId the primary key of the note
	* @return the note
	* @throws com.sambaash.platform.srv.NoSuchNoteException if a note with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Note findByPrimaryKey(
		long spNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchNoteException {
		return getPersistence().findByPrimaryKey(spNoteId);
	}

	/**
	* Returns the note with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spNoteId the primary key of the note
	* @return the note, or <code>null</code> if a note with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.Note fetchByPrimaryKey(
		long spNoteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spNoteId);
	}

	/**
	* Returns all the notes.
	*
	* @return the notes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.Note> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Note> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.Note> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the notes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of notes.
	*
	* @return the number of notes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NotePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NotePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					NotePersistence.class.getName());

			ReferenceRegistry.registerReference(NoteUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NotePersistence persistence) {
	}

	private static NotePersistence _persistence;
}