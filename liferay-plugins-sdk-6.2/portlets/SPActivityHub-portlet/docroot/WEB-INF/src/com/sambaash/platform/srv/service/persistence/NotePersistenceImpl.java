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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchNoteException;
import com.sambaash.platform.srv.model.Note;
import com.sambaash.platform.srv.model.impl.NoteImpl;
import com.sambaash.platform.srv.model.impl.NoteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author aishwarya
 * @see NotePersistence
 * @see NoteUtil
 * @generated
 */
public class NotePersistenceImpl extends BasePersistenceImpl<Note>
	implements NotePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NoteUtil} to access the note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NoteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
			NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
			NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
			NoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID =
		new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
			NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByentityClassIdEntityIdParentNoteId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			NoteModelImpl.ENTITYCLASSID_COLUMN_BITMASK |
			NoteModelImpl.ENTITYID_COLUMN_BITMASK |
			NoteModelImpl.PARENTNOTEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID =
		new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
			NoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByentityClassIdEntityIdParentNoteId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

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
	@Override
	public Note findByentityClassIdEntityIdParentNoteId(long entityClassId,
		long entityId, long parentNoteId)
		throws NoSuchNoteException, SystemException {
		Note note = fetchByentityClassIdEntityIdParentNoteId(entityClassId,
				entityId, parentNoteId);

		if (note == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entityClassId=");
			msg.append(entityClassId);

			msg.append(", entityId=");
			msg.append(entityId);

			msg.append(", parentNoteId=");
			msg.append(parentNoteId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNoteException(msg.toString());
		}

		return note;
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
	@Override
	public Note fetchByentityClassIdEntityIdParentNoteId(long entityClassId,
		long entityId, long parentNoteId) throws SystemException {
		return fetchByentityClassIdEntityIdParentNoteId(entityClassId,
			entityId, parentNoteId, true);
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
	@Override
	public Note fetchByentityClassIdEntityIdParentNoteId(long entityClassId,
		long entityId, long parentNoteId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { entityClassId, entityId, parentNoteId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
					finderArgs, this);
		}

		if (result instanceof Note) {
			Note note = (Note)result;

			if ((entityClassId != note.getEntityClassId()) ||
					(entityId != note.getEntityId()) ||
					(parentNoteId != note.getParentNoteId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_NOTE_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTNOTEID_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTNOTEID_ENTITYID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTNOTEID_PARENTNOTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(parentNoteId);

				List<Note> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"NotePersistenceImpl.fetchByentityClassIdEntityIdParentNoteId(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Note note = list.get(0);

					result = note;

					cacheResult(note);

					if ((note.getEntityClassId() != entityClassId) ||
							(note.getEntityId() != entityId) ||
							(note.getParentNoteId() != parentNoteId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
							finderArgs, note);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Note)result;
		}
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
	@Override
	public Note removeByentityClassIdEntityIdParentNoteId(long entityClassId,
		long entityId, long parentNoteId)
		throws NoSuchNoteException, SystemException {
		Note note = findByentityClassIdEntityIdParentNoteId(entityClassId,
				entityId, parentNoteId);

		return remove(note);
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
	@Override
	public int countByentityClassIdEntityIdParentNoteId(long entityClassId,
		long entityId, long parentNoteId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID;

		Object[] finderArgs = new Object[] { entityClassId, entityId, parentNoteId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_NOTE_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTNOTEID_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTNOTEID_ENTITYID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTNOTEID_PARENTNOTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(parentNoteId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTNOTEID_ENTITYCLASSID_2 =
		"note.entityClassId = ? AND ";
	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTNOTEID_ENTITYID_2 =
		"note.entityId = ? AND ";
	private static final String _FINDER_COLUMN_ENTITYCLASSIDENTITYIDPARENTNOTEID_PARENTNOTEID_2 =
		"note.parentNoteId = ?";

	public NotePersistenceImpl() {
		setModelClass(Note.class);
	}

	/**
	 * Caches the note in the entity cache if it is enabled.
	 *
	 * @param note the note
	 */
	@Override
	public void cacheResult(Note note) {
		EntityCacheUtil.putResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
			NoteImpl.class, note.getPrimaryKey(), note);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
			new Object[] {
				note.getEntityClassId(), note.getEntityId(),
				note.getParentNoteId()
			}, note);

		note.resetOriginalValues();
	}

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	@Override
	public void cacheResult(List<Note> notes) {
		for (Note note : notes) {
			if (EntityCacheUtil.getResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
						NoteImpl.class, note.getPrimaryKey()) == null) {
				cacheResult(note);
			}
			else {
				note.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NoteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NoteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the note.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Note note) {
		EntityCacheUtil.removeResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
			NoteImpl.class, note.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(note);
	}

	@Override
	public void clearCache(List<Note> notes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Note note : notes) {
			EntityCacheUtil.removeResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
				NoteImpl.class, note.getPrimaryKey());

			clearUniqueFindersCache(note);
		}
	}

	protected void cacheUniqueFindersCache(Note note) {
		if (note.isNew()) {
			Object[] args = new Object[] {
					note.getEntityClassId(), note.getEntityId(),
					note.getParentNoteId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
				args, note);
		}
		else {
			NoteModelImpl noteModelImpl = (NoteModelImpl)note;

			if ((noteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						note.getEntityClassId(), note.getEntityId(),
						note.getParentNoteId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
					args, note);
			}
		}
	}

	protected void clearUniqueFindersCache(Note note) {
		NoteModelImpl noteModelImpl = (NoteModelImpl)note;

		Object[] args = new Object[] {
				note.getEntityClassId(), note.getEntityId(),
				note.getParentNoteId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
			args);

		if ((noteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					noteModelImpl.getOriginalEntityClassId(),
					noteModelImpl.getOriginalEntityId(),
					noteModelImpl.getOriginalParentNoteId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSIDENTITYIDPARENTNOTEID,
				args);
		}
	}

	/**
	 * Creates a new note with the primary key. Does not add the note to the database.
	 *
	 * @param spNoteId the primary key for the new note
	 * @return the new note
	 */
	@Override
	public Note create(long spNoteId) {
		Note note = new NoteImpl();

		note.setNew(true);
		note.setPrimaryKey(spNoteId);

		return note;
	}

	/**
	 * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spNoteId the primary key of the note
	 * @return the note that was removed
	 * @throws com.sambaash.platform.srv.NoSuchNoteException if a note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Note remove(long spNoteId)
		throws NoSuchNoteException, SystemException {
		return remove((Serializable)spNoteId);
	}

	/**
	 * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the note
	 * @return the note that was removed
	 * @throws com.sambaash.platform.srv.NoSuchNoteException if a note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Note remove(Serializable primaryKey)
		throws NoSuchNoteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Note note = (Note)session.get(NoteImpl.class, primaryKey);

			if (note == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(note);
		}
		catch (NoSuchNoteException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Note removeImpl(Note note) throws SystemException {
		note = toUnwrappedModel(note);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(note)) {
				note = (Note)session.get(NoteImpl.class, note.getPrimaryKeyObj());
			}

			if (note != null) {
				session.delete(note);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (note != null) {
			clearCache(note);
		}

		return note;
	}

	@Override
	public Note updateImpl(com.sambaash.platform.srv.model.Note note)
		throws SystemException {
		note = toUnwrappedModel(note);

		boolean isNew = note.isNew();

		Session session = null;

		try {
			session = openSession();

			if (note.isNew()) {
				session.save(note);

				note.setNew(false);
			}
			else {
				session.merge(note);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NoteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
			NoteImpl.class, note.getPrimaryKey(), note);

		clearUniqueFindersCache(note);
		cacheUniqueFindersCache(note);

		return note;
	}

	protected Note toUnwrappedModel(Note note) {
		if (note instanceof NoteImpl) {
			return note;
		}

		NoteImpl noteImpl = new NoteImpl();

		noteImpl.setNew(note.isNew());
		noteImpl.setPrimaryKey(note.getPrimaryKey());

		noteImpl.setSpNoteId(note.getSpNoteId());
		noteImpl.setGroupId(note.getGroupId());
		noteImpl.setCompanyId(note.getCompanyId());
		noteImpl.setUserId(note.getUserId());
		noteImpl.setUserName(note.getUserName());
		noteImpl.setCreateDate(note.getCreateDate());
		noteImpl.setModifiedDate(note.getModifiedDate());
		noteImpl.setEntityClassId(note.getEntityClassId());
		noteImpl.setEntityClassName(note.getEntityClassName());
		noteImpl.setEntityId(note.getEntityId());
		noteImpl.setSavedByUserId(note.getSavedByUserId());
		noteImpl.setNoteTitle(note.getNoteTitle());
		noteImpl.setNoteContent(note.getNoteContent());
		noteImpl.setFileEntryId(note.getFileEntryId());
		noteImpl.setAssociatedWith(note.getAssociatedWith());
		noteImpl.setStatus(note.getStatus());
		noteImpl.setParentNoteId(note.getParentNoteId());

		return noteImpl;
	}

	/**
	 * Returns the note with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the note
	 * @return the note
	 * @throws com.sambaash.platform.srv.NoSuchNoteException if a note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Note findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNoteException, SystemException {
		Note note = fetchByPrimaryKey(primaryKey);

		if (note == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return note;
	}

	/**
	 * Returns the note with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchNoteException} if it could not be found.
	 *
	 * @param spNoteId the primary key of the note
	 * @return the note
	 * @throws com.sambaash.platform.srv.NoSuchNoteException if a note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Note findByPrimaryKey(long spNoteId)
		throws NoSuchNoteException, SystemException {
		return findByPrimaryKey((Serializable)spNoteId);
	}

	/**
	 * Returns the note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the note
	 * @return the note, or <code>null</code> if a note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Note fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Note note = (Note)EntityCacheUtil.getResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
				NoteImpl.class, primaryKey);

		if (note == _nullNote) {
			return null;
		}

		if (note == null) {
			Session session = null;

			try {
				session = openSession();

				note = (Note)session.get(NoteImpl.class, primaryKey);

				if (note != null) {
					cacheResult(note);
				}
				else {
					EntityCacheUtil.putResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
						NoteImpl.class, primaryKey, _nullNote);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
					NoteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return note;
	}

	/**
	 * Returns the note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spNoteId the primary key of the note
	 * @return the note, or <code>null</code> if a note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Note fetchByPrimaryKey(long spNoteId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spNoteId);
	}

	/**
	 * Returns all the notes.
	 *
	 * @return the notes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Note> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Note> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Note> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Note> list = (List<Note>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NOTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTE;

				if (pagination) {
					sql = sql.concat(NoteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Note>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Note>(list);
				}
				else {
					list = (List<Note>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the notes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Note note : findAll()) {
			remove(note);
		}
	}

	/**
	 * Returns the number of notes.
	 *
	 * @return the number of notes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the note persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Note")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Note>> listenersList = new ArrayList<ModelListener<Note>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Note>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(NoteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NOTE = "SELECT note FROM Note note";
	private static final String _SQL_SELECT_NOTE_WHERE = "SELECT note FROM Note note WHERE ";
	private static final String _SQL_COUNT_NOTE = "SELECT COUNT(note) FROM Note note";
	private static final String _SQL_COUNT_NOTE_WHERE = "SELECT COUNT(note) FROM Note note WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "note.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Note exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Note exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NotePersistenceImpl.class);
	private static Note _nullNote = new NoteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Note> toCacheModel() {
				return _nullNoteCacheModel;
			}
		};

	private static CacheModel<Note> _nullNoteCacheModel = new CacheModel<Note>() {
			@Override
			public Note toEntityModel() {
				return _nullNote;
			}
		};
}