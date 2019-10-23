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

import com.sambaash.platform.srv.NoSuchCourseLearningException;
import com.sambaash.platform.srv.model.CourseLearning;
import com.sambaash.platform.srv.model.impl.CourseLearningImpl;
import com.sambaash.platform.srv.model.impl.CourseLearningModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course learning service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseLearningPersistence
 * @see CourseLearningUtil
 * @generated
 */
public class CourseLearningPersistenceImpl extends BasePersistenceImpl<CourseLearning>
	implements CourseLearningPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseLearningUtil} to access the course learning persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseLearningImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
			CourseLearningModelImpl.FINDER_CACHE_ENABLED,
			CourseLearningImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
			CourseLearningModelImpl.FINDER_CACHE_ENABLED,
			CourseLearningImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
			CourseLearningModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COURSEID = new FinderPath(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
			CourseLearningModelImpl.FINDER_CACHE_ENABLED,
			CourseLearningImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCourseId", new String[] { Long.class.getName() },
			CourseLearningModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
			CourseLearningModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the course learning where spCourseId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseLearningException} if it could not be found.
	 *
	 * @param spCourseId the sp course ID
	 * @return the matching course learning
	 * @throws com.sambaash.platform.srv.NoSuchCourseLearningException if a matching course learning could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning findByCourseId(long spCourseId)
		throws NoSuchCourseLearningException, SystemException {
		CourseLearning courseLearning = fetchByCourseId(spCourseId);

		if (courseLearning == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spCourseId=");
			msg.append(spCourseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseLearningException(msg.toString());
		}

		return courseLearning;
	}

	/**
	 * Returns the course learning where spCourseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @return the matching course learning, or <code>null</code> if a matching course learning could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning fetchByCourseId(long spCourseId)
		throws SystemException {
		return fetchByCourseId(spCourseId, true);
	}

	/**
	 * Returns the course learning where spCourseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course learning, or <code>null</code> if a matching course learning could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning fetchByCourseId(long spCourseId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spCourseId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COURSEID,
					finderArgs, this);
		}

		if (result instanceof CourseLearning) {
			CourseLearning courseLearning = (CourseLearning)result;

			if ((spCourseId != courseLearning.getSpCourseId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSELEARNING_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_SPCOURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				List<CourseLearning> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CourseLearningPersistenceImpl.fetchByCourseId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CourseLearning courseLearning = list.get(0);

					result = courseLearning;

					cacheResult(courseLearning);

					if ((courseLearning.getSpCourseId() != spCourseId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
							finderArgs, courseLearning);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID,
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
			return (CourseLearning)result;
		}
	}

	/**
	 * Removes the course learning where spCourseId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @return the course learning that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning removeByCourseId(long spCourseId)
		throws NoSuchCourseLearningException, SystemException {
		CourseLearning courseLearning = findByCourseId(spCourseId);

		return remove(courseLearning);
	}

	/**
	 * Returns the number of course learnings where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @return the number of matching course learnings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseId(long spCourseId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

		Object[] finderArgs = new Object[] { spCourseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSELEARNING_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_SPCOURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

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

	private static final String _FINDER_COLUMN_COURSEID_SPCOURSEID_2 = "courseLearning.spCourseId = ?";

	public CourseLearningPersistenceImpl() {
		setModelClass(CourseLearning.class);
	}

	/**
	 * Caches the course learning in the entity cache if it is enabled.
	 *
	 * @param courseLearning the course learning
	 */
	@Override
	public void cacheResult(CourseLearning courseLearning) {
		EntityCacheUtil.putResult(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
			CourseLearningImpl.class, courseLearning.getPrimaryKey(),
			courseLearning);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
			new Object[] { courseLearning.getSpCourseId() }, courseLearning);

		courseLearning.resetOriginalValues();
	}

	/**
	 * Caches the course learnings in the entity cache if it is enabled.
	 *
	 * @param courseLearnings the course learnings
	 */
	@Override
	public void cacheResult(List<CourseLearning> courseLearnings) {
		for (CourseLearning courseLearning : courseLearnings) {
			if (EntityCacheUtil.getResult(
						CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
						CourseLearningImpl.class, courseLearning.getPrimaryKey()) == null) {
				cacheResult(courseLearning);
			}
			else {
				courseLearning.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course learnings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseLearningImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseLearningImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course learning.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseLearning courseLearning) {
		EntityCacheUtil.removeResult(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
			CourseLearningImpl.class, courseLearning.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(courseLearning);
	}

	@Override
	public void clearCache(List<CourseLearning> courseLearnings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseLearning courseLearning : courseLearnings) {
			EntityCacheUtil.removeResult(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
				CourseLearningImpl.class, courseLearning.getPrimaryKey());

			clearUniqueFindersCache(courseLearning);
		}
	}

	protected void cacheUniqueFindersCache(CourseLearning courseLearning) {
		if (courseLearning.isNew()) {
			Object[] args = new Object[] { courseLearning.getSpCourseId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
				courseLearning);
		}
		else {
			CourseLearningModelImpl courseLearningModelImpl = (CourseLearningModelImpl)courseLearning;

			if ((courseLearningModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { courseLearning.getSpCourseId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
					courseLearning);
			}
		}
	}

	protected void clearUniqueFindersCache(CourseLearning courseLearning) {
		CourseLearningModelImpl courseLearningModelImpl = (CourseLearningModelImpl)courseLearning;

		Object[] args = new Object[] { courseLearning.getSpCourseId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);

		if ((courseLearningModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
			args = new Object[] { courseLearningModelImpl.getOriginalSpCourseId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);
		}
	}

	/**
	 * Creates a new course learning with the primary key. Does not add the course learning to the database.
	 *
	 * @param spCourseLearningId the primary key for the new course learning
	 * @return the new course learning
	 */
	@Override
	public CourseLearning create(long spCourseLearningId) {
		CourseLearning courseLearning = new CourseLearningImpl();

		courseLearning.setNew(true);
		courseLearning.setPrimaryKey(spCourseLearningId);

		return courseLearning;
	}

	/**
	 * Removes the course learning with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCourseLearningId the primary key of the course learning
	 * @return the course learning that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseLearningException if a course learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning remove(long spCourseLearningId)
		throws NoSuchCourseLearningException, SystemException {
		return remove((Serializable)spCourseLearningId);
	}

	/**
	 * Removes the course learning with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course learning
	 * @return the course learning that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseLearningException if a course learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning remove(Serializable primaryKey)
		throws NoSuchCourseLearningException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseLearning courseLearning = (CourseLearning)session.get(CourseLearningImpl.class,
					primaryKey);

			if (courseLearning == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseLearningException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseLearning);
		}
		catch (NoSuchCourseLearningException nsee) {
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
	protected CourseLearning removeImpl(CourseLearning courseLearning)
		throws SystemException {
		courseLearning = toUnwrappedModel(courseLearning);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseLearning)) {
				courseLearning = (CourseLearning)session.get(CourseLearningImpl.class,
						courseLearning.getPrimaryKeyObj());
			}

			if (courseLearning != null) {
				session.delete(courseLearning);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseLearning != null) {
			clearCache(courseLearning);
		}

		return courseLearning;
	}

	@Override
	public CourseLearning updateImpl(
		com.sambaash.platform.srv.model.CourseLearning courseLearning)
		throws SystemException {
		courseLearning = toUnwrappedModel(courseLearning);

		boolean isNew = courseLearning.isNew();

		Session session = null;

		try {
			session = openSession();

			if (courseLearning.isNew()) {
				session.save(courseLearning);

				courseLearning.setNew(false);
			}
			else {
				session.merge(courseLearning);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseLearningModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
			CourseLearningImpl.class, courseLearning.getPrimaryKey(),
			courseLearning);

		clearUniqueFindersCache(courseLearning);
		cacheUniqueFindersCache(courseLearning);

		return courseLearning;
	}

	protected CourseLearning toUnwrappedModel(CourseLearning courseLearning) {
		if (courseLearning instanceof CourseLearningImpl) {
			return courseLearning;
		}

		CourseLearningImpl courseLearningImpl = new CourseLearningImpl();

		courseLearningImpl.setNew(courseLearning.isNew());
		courseLearningImpl.setPrimaryKey(courseLearning.getPrimaryKey());

		courseLearningImpl.setSpCourseLearningId(courseLearning.getSpCourseLearningId());
		courseLearningImpl.setGroupId(courseLearning.getGroupId());
		courseLearningImpl.setCompanyId(courseLearning.getCompanyId());
		courseLearningImpl.setUserId(courseLearning.getUserId());
		courseLearningImpl.setUserName(courseLearning.getUserName());
		courseLearningImpl.setCreateDate(courseLearning.getCreateDate());
		courseLearningImpl.setModifiedDate(courseLearning.getModifiedDate());
		courseLearningImpl.setSpCourseId(courseLearning.getSpCourseId());
		courseLearningImpl.setIntro(courseLearning.getIntro());
		courseLearningImpl.setOptionTitle(courseLearning.getOptionTitle());
		courseLearningImpl.setOption1(courseLearning.getOption1());
		courseLearningImpl.setOption2(courseLearning.getOption2());
		courseLearningImpl.setNote(courseLearning.getNote());

		return courseLearningImpl;
	}

	/**
	 * Returns the course learning with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course learning
	 * @return the course learning
	 * @throws com.sambaash.platform.srv.NoSuchCourseLearningException if a course learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseLearningException, SystemException {
		CourseLearning courseLearning = fetchByPrimaryKey(primaryKey);

		if (courseLearning == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseLearningException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseLearning;
	}

	/**
	 * Returns the course learning with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseLearningException} if it could not be found.
	 *
	 * @param spCourseLearningId the primary key of the course learning
	 * @return the course learning
	 * @throws com.sambaash.platform.srv.NoSuchCourseLearningException if a course learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning findByPrimaryKey(long spCourseLearningId)
		throws NoSuchCourseLearningException, SystemException {
		return findByPrimaryKey((Serializable)spCourseLearningId);
	}

	/**
	 * Returns the course learning with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course learning
	 * @return the course learning, or <code>null</code> if a course learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseLearning courseLearning = (CourseLearning)EntityCacheUtil.getResult(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
				CourseLearningImpl.class, primaryKey);

		if (courseLearning == _nullCourseLearning) {
			return null;
		}

		if (courseLearning == null) {
			Session session = null;

			try {
				session = openSession();

				courseLearning = (CourseLearning)session.get(CourseLearningImpl.class,
						primaryKey);

				if (courseLearning != null) {
					cacheResult(courseLearning);
				}
				else {
					EntityCacheUtil.putResult(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
						CourseLearningImpl.class, primaryKey,
						_nullCourseLearning);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseLearningModelImpl.ENTITY_CACHE_ENABLED,
					CourseLearningImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseLearning;
	}

	/**
	 * Returns the course learning with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCourseLearningId the primary key of the course learning
	 * @return the course learning, or <code>null</code> if a course learning with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseLearning fetchByPrimaryKey(long spCourseLearningId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCourseLearningId);
	}

	/**
	 * Returns all the course learnings.
	 *
	 * @return the course learnings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseLearning> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course learnings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseLearningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course learnings
	 * @param end the upper bound of the range of course learnings (not inclusive)
	 * @return the range of course learnings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseLearning> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course learnings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseLearningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course learnings
	 * @param end the upper bound of the range of course learnings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course learnings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseLearning> findAll(int start, int end,
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

		List<CourseLearning> list = (List<CourseLearning>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSELEARNING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSELEARNING;

				if (pagination) {
					sql = sql.concat(CourseLearningModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseLearning>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseLearning>(list);
				}
				else {
					list = (List<CourseLearning>)QueryUtil.list(q,
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
	 * Removes all the course learnings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseLearning courseLearning : findAll()) {
			remove(courseLearning);
		}
	}

	/**
	 * Returns the number of course learnings.
	 *
	 * @return the number of course learnings
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

				Query q = session.createQuery(_SQL_COUNT_COURSELEARNING);

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
	 * Initializes the course learning persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CourseLearning")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseLearning>> listenersList = new ArrayList<ModelListener<CourseLearning>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseLearning>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseLearningImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSELEARNING = "SELECT courseLearning FROM CourseLearning courseLearning";
	private static final String _SQL_SELECT_COURSELEARNING_WHERE = "SELECT courseLearning FROM CourseLearning courseLearning WHERE ";
	private static final String _SQL_COUNT_COURSELEARNING = "SELECT COUNT(courseLearning) FROM CourseLearning courseLearning";
	private static final String _SQL_COUNT_COURSELEARNING_WHERE = "SELECT COUNT(courseLearning) FROM CourseLearning courseLearning WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseLearning.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseLearning exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseLearning exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseLearningPersistenceImpl.class);
	private static CourseLearning _nullCourseLearning = new CourseLearningImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseLearning> toCacheModel() {
				return _nullCourseLearningCacheModel;
			}
		};

	private static CacheModel<CourseLearning> _nullCourseLearningCacheModel = new CacheModel<CourseLearning>() {
			@Override
			public CourseLearning toEntityModel() {
				return _nullCourseLearning;
			}
		};
}