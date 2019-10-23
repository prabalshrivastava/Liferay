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

import com.sambaash.platform.srv.NoSuchCourseDurationException;
import com.sambaash.platform.srv.model.CourseDuration;
import com.sambaash.platform.srv.model.impl.CourseDurationImpl;
import com.sambaash.platform.srv.model.impl.CourseDurationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course duration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseDurationPersistence
 * @see CourseDurationUtil
 * @generated
 */
public class CourseDurationPersistenceImpl extends BasePersistenceImpl<CourseDuration>
	implements CourseDurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseDurationUtil} to access the course duration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseDurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationModelImpl.FINDER_CACHE_ENABLED,
			CourseDurationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationModelImpl.FINDER_CACHE_ENABLED,
			CourseDurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COURSEID = new FinderPath(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationModelImpl.FINDER_CACHE_ENABLED,
			CourseDurationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCourseId", new String[] { Long.class.getName() },
			CourseDurationModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the course duration where spCourseId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseDurationException} if it could not be found.
	 *
	 * @param spCourseId the sp course ID
	 * @return the matching course duration
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a matching course duration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration findByCourseId(long spCourseId)
		throws NoSuchCourseDurationException, SystemException {
		CourseDuration courseDuration = fetchByCourseId(spCourseId);

		if (courseDuration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spCourseId=");
			msg.append(spCourseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseDurationException(msg.toString());
		}

		return courseDuration;
	}

	/**
	 * Returns the course duration where spCourseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @return the matching course duration, or <code>null</code> if a matching course duration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration fetchByCourseId(long spCourseId)
		throws SystemException {
		return fetchByCourseId(spCourseId, true);
	}

	/**
	 * Returns the course duration where spCourseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course duration, or <code>null</code> if a matching course duration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration fetchByCourseId(long spCourseId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spCourseId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COURSEID,
					finderArgs, this);
		}

		if (result instanceof CourseDuration) {
			CourseDuration courseDuration = (CourseDuration)result;

			if ((spCourseId != courseDuration.getSpCourseId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSEDURATION_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_SPCOURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				List<CourseDuration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CourseDurationPersistenceImpl.fetchByCourseId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CourseDuration courseDuration = list.get(0);

					result = courseDuration;

					cacheResult(courseDuration);

					if ((courseDuration.getSpCourseId() != spCourseId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
							finderArgs, courseDuration);
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
			return (CourseDuration)result;
		}
	}

	/**
	 * Removes the course duration where spCourseId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @return the course duration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration removeByCourseId(long spCourseId)
		throws NoSuchCourseDurationException, SystemException {
		CourseDuration courseDuration = findByCourseId(spCourseId);

		return remove(courseDuration);
	}

	/**
	 * Returns the number of course durations where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @return the number of matching course durations
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

			query.append(_SQL_COUNT_COURSEDURATION_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEID_SPCOURSEID_2 = "courseDuration.spCourseId = ?";

	public CourseDurationPersistenceImpl() {
		setModelClass(CourseDuration.class);
	}

	/**
	 * Caches the course duration in the entity cache if it is enabled.
	 *
	 * @param courseDuration the course duration
	 */
	@Override
	public void cacheResult(CourseDuration courseDuration) {
		EntityCacheUtil.putResult(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationImpl.class, courseDuration.getPrimaryKey(),
			courseDuration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
			new Object[] { courseDuration.getSpCourseId() }, courseDuration);

		courseDuration.resetOriginalValues();
	}

	/**
	 * Caches the course durations in the entity cache if it is enabled.
	 *
	 * @param courseDurations the course durations
	 */
	@Override
	public void cacheResult(List<CourseDuration> courseDurations) {
		for (CourseDuration courseDuration : courseDurations) {
			if (EntityCacheUtil.getResult(
						CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
						CourseDurationImpl.class, courseDuration.getPrimaryKey()) == null) {
				cacheResult(courseDuration);
			}
			else {
				courseDuration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course durations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseDurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseDurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course duration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseDuration courseDuration) {
		EntityCacheUtil.removeResult(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationImpl.class, courseDuration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(courseDuration);
	}

	@Override
	public void clearCache(List<CourseDuration> courseDurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseDuration courseDuration : courseDurations) {
			EntityCacheUtil.removeResult(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
				CourseDurationImpl.class, courseDuration.getPrimaryKey());

			clearUniqueFindersCache(courseDuration);
		}
	}

	protected void cacheUniqueFindersCache(CourseDuration courseDuration) {
		if (courseDuration.isNew()) {
			Object[] args = new Object[] { courseDuration.getSpCourseId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
				courseDuration);
		}
		else {
			CourseDurationModelImpl courseDurationModelImpl = (CourseDurationModelImpl)courseDuration;

			if ((courseDurationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { courseDuration.getSpCourseId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
					courseDuration);
			}
		}
	}

	protected void clearUniqueFindersCache(CourseDuration courseDuration) {
		CourseDurationModelImpl courseDurationModelImpl = (CourseDurationModelImpl)courseDuration;

		Object[] args = new Object[] { courseDuration.getSpCourseId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);

		if ((courseDurationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
			args = new Object[] { courseDurationModelImpl.getOriginalSpCourseId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);
		}
	}

	/**
	 * Creates a new course duration with the primary key. Does not add the course duration to the database.
	 *
	 * @param spCourseDurationId the primary key for the new course duration
	 * @return the new course duration
	 */
	@Override
	public CourseDuration create(long spCourseDurationId) {
		CourseDuration courseDuration = new CourseDurationImpl();

		courseDuration.setNew(true);
		courseDuration.setPrimaryKey(spCourseDurationId);

		return courseDuration;
	}

	/**
	 * Removes the course duration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCourseDurationId the primary key of the course duration
	 * @return the course duration that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a course duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration remove(long spCourseDurationId)
		throws NoSuchCourseDurationException, SystemException {
		return remove((Serializable)spCourseDurationId);
	}

	/**
	 * Removes the course duration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course duration
	 * @return the course duration that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a course duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration remove(Serializable primaryKey)
		throws NoSuchCourseDurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseDuration courseDuration = (CourseDuration)session.get(CourseDurationImpl.class,
					primaryKey);

			if (courseDuration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseDurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseDuration);
		}
		catch (NoSuchCourseDurationException nsee) {
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
	protected CourseDuration removeImpl(CourseDuration courseDuration)
		throws SystemException {
		courseDuration = toUnwrappedModel(courseDuration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseDuration)) {
				courseDuration = (CourseDuration)session.get(CourseDurationImpl.class,
						courseDuration.getPrimaryKeyObj());
			}

			if (courseDuration != null) {
				session.delete(courseDuration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseDuration != null) {
			clearCache(courseDuration);
		}

		return courseDuration;
	}

	@Override
	public CourseDuration updateImpl(
		com.sambaash.platform.srv.model.CourseDuration courseDuration)
		throws SystemException {
		courseDuration = toUnwrappedModel(courseDuration);

		boolean isNew = courseDuration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (courseDuration.isNew()) {
				session.save(courseDuration);

				courseDuration.setNew(false);
			}
			else {
				session.merge(courseDuration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseDurationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationImpl.class, courseDuration.getPrimaryKey(),
			courseDuration);

		clearUniqueFindersCache(courseDuration);
		cacheUniqueFindersCache(courseDuration);

		return courseDuration;
	}

	protected CourseDuration toUnwrappedModel(CourseDuration courseDuration) {
		if (courseDuration instanceof CourseDurationImpl) {
			return courseDuration;
		}

		CourseDurationImpl courseDurationImpl = new CourseDurationImpl();

		courseDurationImpl.setNew(courseDuration.isNew());
		courseDurationImpl.setPrimaryKey(courseDuration.getPrimaryKey());

		courseDurationImpl.setSpCourseDurationId(courseDuration.getSpCourseDurationId());
		courseDurationImpl.setGroupId(courseDuration.getGroupId());
		courseDurationImpl.setCompanyId(courseDuration.getCompanyId());
		courseDurationImpl.setUserId(courseDuration.getUserId());
		courseDurationImpl.setUserName(courseDuration.getUserName());
		courseDurationImpl.setCreateDate(courseDuration.getCreateDate());
		courseDurationImpl.setModifiedDate(courseDuration.getModifiedDate());
		courseDurationImpl.setSpCourseId(courseDuration.getSpCourseId());
		courseDurationImpl.setSpCourseLearningId(courseDuration.getSpCourseLearningId());
		courseDurationImpl.setTitle(courseDuration.getTitle());

		return courseDurationImpl;
	}

	/**
	 * Returns the course duration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course duration
	 * @return the course duration
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a course duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseDurationException, SystemException {
		CourseDuration courseDuration = fetchByPrimaryKey(primaryKey);

		if (courseDuration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseDurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseDuration;
	}

	/**
	 * Returns the course duration with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseDurationException} if it could not be found.
	 *
	 * @param spCourseDurationId the primary key of the course duration
	 * @return the course duration
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a course duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration findByPrimaryKey(long spCourseDurationId)
		throws NoSuchCourseDurationException, SystemException {
		return findByPrimaryKey((Serializable)spCourseDurationId);
	}

	/**
	 * Returns the course duration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course duration
	 * @return the course duration, or <code>null</code> if a course duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseDuration courseDuration = (CourseDuration)EntityCacheUtil.getResult(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
				CourseDurationImpl.class, primaryKey);

		if (courseDuration == _nullCourseDuration) {
			return null;
		}

		if (courseDuration == null) {
			Session session = null;

			try {
				session = openSession();

				courseDuration = (CourseDuration)session.get(CourseDurationImpl.class,
						primaryKey);

				if (courseDuration != null) {
					cacheResult(courseDuration);
				}
				else {
					EntityCacheUtil.putResult(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
						CourseDurationImpl.class, primaryKey,
						_nullCourseDuration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseDurationModelImpl.ENTITY_CACHE_ENABLED,
					CourseDurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseDuration;
	}

	/**
	 * Returns the course duration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCourseDurationId the primary key of the course duration
	 * @return the course duration, or <code>null</code> if a course duration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDuration fetchByPrimaryKey(long spCourseDurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCourseDurationId);
	}

	/**
	 * Returns all the course durations.
	 *
	 * @return the course durations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDuration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course durations
	 * @param end the upper bound of the range of course durations (not inclusive)
	 * @return the range of course durations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDuration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course durations
	 * @param end the upper bound of the range of course durations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course durations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDuration> findAll(int start, int end,
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

		List<CourseDuration> list = (List<CourseDuration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSEDURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSEDURATION;

				if (pagination) {
					sql = sql.concat(CourseDurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseDuration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseDuration>(list);
				}
				else {
					list = (List<CourseDuration>)QueryUtil.list(q,
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
	 * Removes all the course durations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseDuration courseDuration : findAll()) {
			remove(courseDuration);
		}
	}

	/**
	 * Returns the number of course durations.
	 *
	 * @return the number of course durations
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

				Query q = session.createQuery(_SQL_COUNT_COURSEDURATION);

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
	 * Initializes the course duration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CourseDuration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseDuration>> listenersList = new ArrayList<ModelListener<CourseDuration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseDuration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseDurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSEDURATION = "SELECT courseDuration FROM CourseDuration courseDuration";
	private static final String _SQL_SELECT_COURSEDURATION_WHERE = "SELECT courseDuration FROM CourseDuration courseDuration WHERE ";
	private static final String _SQL_COUNT_COURSEDURATION = "SELECT COUNT(courseDuration) FROM CourseDuration courseDuration";
	private static final String _SQL_COUNT_COURSEDURATION_WHERE = "SELECT COUNT(courseDuration) FROM CourseDuration courseDuration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseDuration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseDuration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseDuration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseDurationPersistenceImpl.class);
	private static CourseDuration _nullCourseDuration = new CourseDurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseDuration> toCacheModel() {
				return _nullCourseDurationCacheModel;
			}
		};

	private static CacheModel<CourseDuration> _nullCourseDurationCacheModel = new CacheModel<CourseDuration>() {
			@Override
			public CourseDuration toEntityModel() {
				return _nullCourseDuration;
			}
		};
}