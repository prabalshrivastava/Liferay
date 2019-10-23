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

package com.sambaash.platform.srv.enrolment.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException;
import com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords;
import com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsImpl;
import com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the enroll uploaded temp records service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Baxture
 * @see EnrollUploadedTempRecordsPersistence
 * @see EnrollUploadedTempRecordsUtil
 * @generated
 */
public class EnrollUploadedTempRecordsPersistenceImpl
	extends BasePersistenceImpl<EnrollUploadedTempRecords>
	implements EnrollUploadedTempRecordsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnrollUploadedTempRecordsUtil} to access the enroll uploaded temp records persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnrollUploadedTempRecordsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
			EnrollUploadedTempRecordsModelImpl.FINDER_CACHE_ENABLED,
			EnrollUploadedTempRecordsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
			EnrollUploadedTempRecordsModelImpl.FINDER_CACHE_ENABLED,
			EnrollUploadedTempRecordsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
			EnrollUploadedTempRecordsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_UPLOADTRANSACTID = new FinderPath(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
			EnrollUploadedTempRecordsModelImpl.FINDER_CACHE_ENABLED,
			EnrollUploadedTempRecordsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUploadTransactId", new String[] { String.class.getName() },
			EnrollUploadedTempRecordsModelImpl.UPLOADTRANSACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UPLOADTRANSACTID = new FinderPath(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
			EnrollUploadedTempRecordsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUploadTransactId", new String[] { String.class.getName() });

	/**
	 * Returns the enroll uploaded temp records where uploadTransactId = &#63; or throws a {@link com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException} if it could not be found.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @return the matching enroll uploaded temp records
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException if a matching enroll uploaded temp records could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords findByUploadTransactId(
		String uploadTransactId)
		throws NoSuchEnrollUploadedTempRecordsException, SystemException {
		EnrollUploadedTempRecords enrollUploadedTempRecords = fetchByUploadTransactId(uploadTransactId);

		if (enrollUploadedTempRecords == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uploadTransactId=");
			msg.append(uploadTransactId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEnrollUploadedTempRecordsException(msg.toString());
		}

		return enrollUploadedTempRecords;
	}

	/**
	 * Returns the enroll uploaded temp records where uploadTransactId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @return the matching enroll uploaded temp records, or <code>null</code> if a matching enroll uploaded temp records could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords fetchByUploadTransactId(
		String uploadTransactId) throws SystemException {
		return fetchByUploadTransactId(uploadTransactId, true);
	}

	/**
	 * Returns the enroll uploaded temp records where uploadTransactId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching enroll uploaded temp records, or <code>null</code> if a matching enroll uploaded temp records could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords fetchByUploadTransactId(
		String uploadTransactId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { uploadTransactId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UPLOADTRANSACTID,
					finderArgs, this);
		}

		if (result instanceof EnrollUploadedTempRecords) {
			EnrollUploadedTempRecords enrollUploadedTempRecords = (EnrollUploadedTempRecords)result;

			if (!Validator.equals(uploadTransactId,
						enrollUploadedTempRecords.getUploadTransactId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ENROLLUPLOADEDTEMPRECORDS_WHERE);

			boolean bindUploadTransactId = false;

			if (uploadTransactId == null) {
				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_1);
			}
			else if (uploadTransactId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_3);
			}
			else {
				bindUploadTransactId = true;

				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUploadTransactId) {
					qPos.add(uploadTransactId);
				}

				List<EnrollUploadedTempRecords> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPLOADTRANSACTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EnrollUploadedTempRecordsPersistenceImpl.fetchByUploadTransactId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EnrollUploadedTempRecords enrollUploadedTempRecords = list.get(0);

					result = enrollUploadedTempRecords;

					cacheResult(enrollUploadedTempRecords);

					if ((enrollUploadedTempRecords.getUploadTransactId() == null) ||
							!enrollUploadedTempRecords.getUploadTransactId()
														  .equals(uploadTransactId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPLOADTRANSACTID,
							finderArgs, enrollUploadedTempRecords);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UPLOADTRANSACTID,
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
			return (EnrollUploadedTempRecords)result;
		}
	}

	/**
	 * Removes the enroll uploaded temp records where uploadTransactId = &#63; from the database.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @return the enroll uploaded temp records that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords removeByUploadTransactId(
		String uploadTransactId)
		throws NoSuchEnrollUploadedTempRecordsException, SystemException {
		EnrollUploadedTempRecords enrollUploadedTempRecords = findByUploadTransactId(uploadTransactId);

		return remove(enrollUploadedTempRecords);
	}

	/**
	 * Returns the number of enroll uploaded temp recordses where uploadTransactId = &#63;.
	 *
	 * @param uploadTransactId the upload transact ID
	 * @return the number of matching enroll uploaded temp recordses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUploadTransactId(String uploadTransactId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UPLOADTRANSACTID;

		Object[] finderArgs = new Object[] { uploadTransactId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENROLLUPLOADEDTEMPRECORDS_WHERE);

			boolean bindUploadTransactId = false;

			if (uploadTransactId == null) {
				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_1);
			}
			else if (uploadTransactId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_3);
			}
			else {
				bindUploadTransactId = true;

				query.append(_FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUploadTransactId) {
					qPos.add(uploadTransactId);
				}

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

	private static final String _FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_1 =
		"enrollUploadedTempRecords.uploadTransactId IS NULL";
	private static final String _FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_2 =
		"enrollUploadedTempRecords.uploadTransactId = ?";
	private static final String _FINDER_COLUMN_UPLOADTRANSACTID_UPLOADTRANSACTID_3 =
		"(enrollUploadedTempRecords.uploadTransactId IS NULL OR enrollUploadedTempRecords.uploadTransactId = '')";

	public EnrollUploadedTempRecordsPersistenceImpl() {
		setModelClass(EnrollUploadedTempRecords.class);
	}

	/**
	 * Caches the enroll uploaded temp records in the entity cache if it is enabled.
	 *
	 * @param enrollUploadedTempRecords the enroll uploaded temp records
	 */
	@Override
	public void cacheResult(EnrollUploadedTempRecords enrollUploadedTempRecords) {
		EntityCacheUtil.putResult(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
			EnrollUploadedTempRecordsImpl.class,
			enrollUploadedTempRecords.getPrimaryKey(), enrollUploadedTempRecords);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPLOADTRANSACTID,
			new Object[] { enrollUploadedTempRecords.getUploadTransactId() },
			enrollUploadedTempRecords);

		enrollUploadedTempRecords.resetOriginalValues();
	}

	/**
	 * Caches the enroll uploaded temp recordses in the entity cache if it is enabled.
	 *
	 * @param enrollUploadedTempRecordses the enroll uploaded temp recordses
	 */
	@Override
	public void cacheResult(
		List<EnrollUploadedTempRecords> enrollUploadedTempRecordses) {
		for (EnrollUploadedTempRecords enrollUploadedTempRecords : enrollUploadedTempRecordses) {
			if (EntityCacheUtil.getResult(
						EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
						EnrollUploadedTempRecordsImpl.class,
						enrollUploadedTempRecords.getPrimaryKey()) == null) {
				cacheResult(enrollUploadedTempRecords);
			}
			else {
				enrollUploadedTempRecords.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all enroll uploaded temp recordses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EnrollUploadedTempRecordsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EnrollUploadedTempRecordsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the enroll uploaded temp records.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EnrollUploadedTempRecords enrollUploadedTempRecords) {
		EntityCacheUtil.removeResult(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
			EnrollUploadedTempRecordsImpl.class,
			enrollUploadedTempRecords.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(enrollUploadedTempRecords);
	}

	@Override
	public void clearCache(
		List<EnrollUploadedTempRecords> enrollUploadedTempRecordses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EnrollUploadedTempRecords enrollUploadedTempRecords : enrollUploadedTempRecordses) {
			EntityCacheUtil.removeResult(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
				EnrollUploadedTempRecordsImpl.class,
				enrollUploadedTempRecords.getPrimaryKey());

			clearUniqueFindersCache(enrollUploadedTempRecords);
		}
	}

	protected void cacheUniqueFindersCache(
		EnrollUploadedTempRecords enrollUploadedTempRecords) {
		if (enrollUploadedTempRecords.isNew()) {
			Object[] args = new Object[] {
					enrollUploadedTempRecords.getUploadTransactId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPLOADTRANSACTID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPLOADTRANSACTID,
				args, enrollUploadedTempRecords);
		}
		else {
			EnrollUploadedTempRecordsModelImpl enrollUploadedTempRecordsModelImpl =
				(EnrollUploadedTempRecordsModelImpl)enrollUploadedTempRecords;

			if ((enrollUploadedTempRecordsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UPLOADTRANSACTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						enrollUploadedTempRecords.getUploadTransactId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPLOADTRANSACTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UPLOADTRANSACTID,
					args, enrollUploadedTempRecords);
			}
		}
	}

	protected void clearUniqueFindersCache(
		EnrollUploadedTempRecords enrollUploadedTempRecords) {
		EnrollUploadedTempRecordsModelImpl enrollUploadedTempRecordsModelImpl = (EnrollUploadedTempRecordsModelImpl)enrollUploadedTempRecords;

		Object[] args = new Object[] {
				enrollUploadedTempRecords.getUploadTransactId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPLOADTRANSACTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UPLOADTRANSACTID, args);

		if ((enrollUploadedTempRecordsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UPLOADTRANSACTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					enrollUploadedTempRecordsModelImpl.getOriginalUploadTransactId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPLOADTRANSACTID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UPLOADTRANSACTID,
				args);
		}
	}

	/**
	 * Creates a new enroll uploaded temp records with the primary key. Does not add the enroll uploaded temp records to the database.
	 *
	 * @param uploadedRecId the primary key for the new enroll uploaded temp records
	 * @return the new enroll uploaded temp records
	 */
	@Override
	public EnrollUploadedTempRecords create(long uploadedRecId) {
		EnrollUploadedTempRecords enrollUploadedTempRecords = new EnrollUploadedTempRecordsImpl();

		enrollUploadedTempRecords.setNew(true);
		enrollUploadedTempRecords.setPrimaryKey(uploadedRecId);

		return enrollUploadedTempRecords;
	}

	/**
	 * Removes the enroll uploaded temp records with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uploadedRecId the primary key of the enroll uploaded temp records
	 * @return the enroll uploaded temp records that was removed
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException if a enroll uploaded temp records with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords remove(long uploadedRecId)
		throws NoSuchEnrollUploadedTempRecordsException, SystemException {
		return remove((Serializable)uploadedRecId);
	}

	/**
	 * Removes the enroll uploaded temp records with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the enroll uploaded temp records
	 * @return the enroll uploaded temp records that was removed
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException if a enroll uploaded temp records with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords remove(Serializable primaryKey)
		throws NoSuchEnrollUploadedTempRecordsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EnrollUploadedTempRecords enrollUploadedTempRecords = (EnrollUploadedTempRecords)session.get(EnrollUploadedTempRecordsImpl.class,
					primaryKey);

			if (enrollUploadedTempRecords == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnrollUploadedTempRecordsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(enrollUploadedTempRecords);
		}
		catch (NoSuchEnrollUploadedTempRecordsException nsee) {
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
	protected EnrollUploadedTempRecords removeImpl(
		EnrollUploadedTempRecords enrollUploadedTempRecords)
		throws SystemException {
		enrollUploadedTempRecords = toUnwrappedModel(enrollUploadedTempRecords);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(enrollUploadedTempRecords)) {
				enrollUploadedTempRecords = (EnrollUploadedTempRecords)session.get(EnrollUploadedTempRecordsImpl.class,
						enrollUploadedTempRecords.getPrimaryKeyObj());
			}

			if (enrollUploadedTempRecords != null) {
				session.delete(enrollUploadedTempRecords);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (enrollUploadedTempRecords != null) {
			clearCache(enrollUploadedTempRecords);
		}

		return enrollUploadedTempRecords;
	}

	@Override
	public EnrollUploadedTempRecords updateImpl(
		com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords enrollUploadedTempRecords)
		throws SystemException {
		enrollUploadedTempRecords = toUnwrappedModel(enrollUploadedTempRecords);

		boolean isNew = enrollUploadedTempRecords.isNew();

		Session session = null;

		try {
			session = openSession();

			if (enrollUploadedTempRecords.isNew()) {
				session.save(enrollUploadedTempRecords);

				enrollUploadedTempRecords.setNew(false);
			}
			else {
				session.merge(enrollUploadedTempRecords);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!EnrollUploadedTempRecordsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
			EnrollUploadedTempRecordsImpl.class,
			enrollUploadedTempRecords.getPrimaryKey(), enrollUploadedTempRecords);

		clearUniqueFindersCache(enrollUploadedTempRecords);
		cacheUniqueFindersCache(enrollUploadedTempRecords);

		return enrollUploadedTempRecords;
	}

	protected EnrollUploadedTempRecords toUnwrappedModel(
		EnrollUploadedTempRecords enrollUploadedTempRecords) {
		if (enrollUploadedTempRecords instanceof EnrollUploadedTempRecordsImpl) {
			return enrollUploadedTempRecords;
		}

		EnrollUploadedTempRecordsImpl enrollUploadedTempRecordsImpl = new EnrollUploadedTempRecordsImpl();

		enrollUploadedTempRecordsImpl.setNew(enrollUploadedTempRecords.isNew());
		enrollUploadedTempRecordsImpl.setPrimaryKey(enrollUploadedTempRecords.getPrimaryKey());

		enrollUploadedTempRecordsImpl.setUploadedRecId(enrollUploadedTempRecords.getUploadedRecId());
		enrollUploadedTempRecordsImpl.setUploadTransactId(enrollUploadedTempRecords.getUploadTransactId());
		enrollUploadedTempRecordsImpl.setSprCode(enrollUploadedTempRecords.getSprCode());
		enrollUploadedTempRecordsImpl.setTitle(enrollUploadedTempRecords.getTitle());
		enrollUploadedTempRecordsImpl.setFullOfficialName(enrollUploadedTempRecords.getFullOfficialName());
		enrollUploadedTempRecordsImpl.setGender(enrollUploadedTempRecords.getGender());
		enrollUploadedTempRecordsImpl.setDateofBirth(enrollUploadedTempRecords.getDateofBirth());
		enrollUploadedTempRecordsImpl.setEmail(enrollUploadedTempRecords.getEmail());
		enrollUploadedTempRecordsImpl.setUserId(enrollUploadedTempRecords.getUserId());
		enrollUploadedTempRecordsImpl.setCreateDate(enrollUploadedTempRecords.getCreateDate());
		enrollUploadedTempRecordsImpl.setModifiedDate(enrollUploadedTempRecords.getModifiedDate());

		return enrollUploadedTempRecordsImpl;
	}

	/**
	 * Returns the enroll uploaded temp records with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the enroll uploaded temp records
	 * @return the enroll uploaded temp records
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException if a enroll uploaded temp records with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEnrollUploadedTempRecordsException, SystemException {
		EnrollUploadedTempRecords enrollUploadedTempRecords = fetchByPrimaryKey(primaryKey);

		if (enrollUploadedTempRecords == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEnrollUploadedTempRecordsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return enrollUploadedTempRecords;
	}

	/**
	 * Returns the enroll uploaded temp records with the primary key or throws a {@link com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException} if it could not be found.
	 *
	 * @param uploadedRecId the primary key of the enroll uploaded temp records
	 * @return the enroll uploaded temp records
	 * @throws com.sambaash.platform.srv.enrolment.NoSuchEnrollUploadedTempRecordsException if a enroll uploaded temp records with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords findByPrimaryKey(long uploadedRecId)
		throws NoSuchEnrollUploadedTempRecordsException, SystemException {
		return findByPrimaryKey((Serializable)uploadedRecId);
	}

	/**
	 * Returns the enroll uploaded temp records with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the enroll uploaded temp records
	 * @return the enroll uploaded temp records, or <code>null</code> if a enroll uploaded temp records with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EnrollUploadedTempRecords enrollUploadedTempRecords = (EnrollUploadedTempRecords)EntityCacheUtil.getResult(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
				EnrollUploadedTempRecordsImpl.class, primaryKey);

		if (enrollUploadedTempRecords == _nullEnrollUploadedTempRecords) {
			return null;
		}

		if (enrollUploadedTempRecords == null) {
			Session session = null;

			try {
				session = openSession();

				enrollUploadedTempRecords = (EnrollUploadedTempRecords)session.get(EnrollUploadedTempRecordsImpl.class,
						primaryKey);

				if (enrollUploadedTempRecords != null) {
					cacheResult(enrollUploadedTempRecords);
				}
				else {
					EntityCacheUtil.putResult(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
						EnrollUploadedTempRecordsImpl.class, primaryKey,
						_nullEnrollUploadedTempRecords);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EnrollUploadedTempRecordsModelImpl.ENTITY_CACHE_ENABLED,
					EnrollUploadedTempRecordsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return enrollUploadedTempRecords;
	}

	/**
	 * Returns the enroll uploaded temp records with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uploadedRecId the primary key of the enroll uploaded temp records
	 * @return the enroll uploaded temp records, or <code>null</code> if a enroll uploaded temp records with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrollUploadedTempRecords fetchByPrimaryKey(long uploadedRecId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)uploadedRecId);
	}

	/**
	 * Returns all the enroll uploaded temp recordses.
	 *
	 * @return the enroll uploaded temp recordses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollUploadedTempRecords> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enroll uploaded temp recordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enroll uploaded temp recordses
	 * @param end the upper bound of the range of enroll uploaded temp recordses (not inclusive)
	 * @return the range of enroll uploaded temp recordses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollUploadedTempRecords> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the enroll uploaded temp recordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of enroll uploaded temp recordses
	 * @param end the upper bound of the range of enroll uploaded temp recordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enroll uploaded temp recordses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EnrollUploadedTempRecords> findAll(int start, int end,
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

		List<EnrollUploadedTempRecords> list = (List<EnrollUploadedTempRecords>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENROLLUPLOADEDTEMPRECORDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENROLLUPLOADEDTEMPRECORDS;

				if (pagination) {
					sql = sql.concat(EnrollUploadedTempRecordsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EnrollUploadedTempRecords>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EnrollUploadedTempRecords>(list);
				}
				else {
					list = (List<EnrollUploadedTempRecords>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the enroll uploaded temp recordses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EnrollUploadedTempRecords enrollUploadedTempRecords : findAll()) {
			remove(enrollUploadedTempRecords);
		}
	}

	/**
	 * Returns the number of enroll uploaded temp recordses.
	 *
	 * @return the number of enroll uploaded temp recordses
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

				Query q = session.createQuery(_SQL_COUNT_ENROLLUPLOADEDTEMPRECORDS);

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
	 * Initializes the enroll uploaded temp records persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EnrollUploadedTempRecords>> listenersList = new ArrayList<ModelListener<EnrollUploadedTempRecords>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EnrollUploadedTempRecords>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EnrollUploadedTempRecordsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ENROLLUPLOADEDTEMPRECORDS = "SELECT enrollUploadedTempRecords FROM EnrollUploadedTempRecords enrollUploadedTempRecords";
	private static final String _SQL_SELECT_ENROLLUPLOADEDTEMPRECORDS_WHERE = "SELECT enrollUploadedTempRecords FROM EnrollUploadedTempRecords enrollUploadedTempRecords WHERE ";
	private static final String _SQL_COUNT_ENROLLUPLOADEDTEMPRECORDS = "SELECT COUNT(enrollUploadedTempRecords) FROM EnrollUploadedTempRecords enrollUploadedTempRecords";
	private static final String _SQL_COUNT_ENROLLUPLOADEDTEMPRECORDS_WHERE = "SELECT COUNT(enrollUploadedTempRecords) FROM EnrollUploadedTempRecords enrollUploadedTempRecords WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enrollUploadedTempRecords.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EnrollUploadedTempRecords exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EnrollUploadedTempRecords exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EnrollUploadedTempRecordsPersistenceImpl.class);
	private static EnrollUploadedTempRecords _nullEnrollUploadedTempRecords = new EnrollUploadedTempRecordsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EnrollUploadedTempRecords> toCacheModel() {
				return _nullEnrollUploadedTempRecordsCacheModel;
			}
		};

	private static CacheModel<EnrollUploadedTempRecords> _nullEnrollUploadedTempRecordsCacheModel =
		new CacheModel<EnrollUploadedTempRecords>() {
			@Override
			public EnrollUploadedTempRecords toEntityModel() {
				return _nullEnrollUploadedTempRecords;
			}
		};
}