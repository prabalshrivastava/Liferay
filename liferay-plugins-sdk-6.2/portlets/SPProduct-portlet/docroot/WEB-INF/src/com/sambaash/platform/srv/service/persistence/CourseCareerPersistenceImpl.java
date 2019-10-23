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

import com.sambaash.platform.srv.NoSuchCourseCareerException;
import com.sambaash.platform.srv.model.CourseCareer;
import com.sambaash.platform.srv.model.impl.CourseCareerImpl;
import com.sambaash.platform.srv.model.impl.CourseCareerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course career service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseCareerPersistence
 * @see CourseCareerUtil
 * @generated
 */
public class CourseCareerPersistenceImpl extends BasePersistenceImpl<CourseCareer>
	implements CourseCareerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseCareerUtil} to access the course career persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseCareerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
			CourseCareerModelImpl.FINDER_CACHE_ENABLED, CourseCareerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
			CourseCareerModelImpl.FINDER_CACHE_ENABLED, CourseCareerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
			CourseCareerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COURSEID = new FinderPath(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
			CourseCareerModelImpl.FINDER_CACHE_ENABLED, CourseCareerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCourseId",
			new String[] { Long.class.getName() },
			CourseCareerModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
			CourseCareerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the course career where spCourseId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseCareerException} if it could not be found.
	 *
	 * @param spCourseId the sp course ID
	 * @return the matching course career
	 * @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a matching course career could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer findByCourseId(long spCourseId)
		throws NoSuchCourseCareerException, SystemException {
		CourseCareer courseCareer = fetchByCourseId(spCourseId);

		if (courseCareer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spCourseId=");
			msg.append(spCourseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseCareerException(msg.toString());
		}

		return courseCareer;
	}

	/**
	 * Returns the course career where spCourseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @return the matching course career, or <code>null</code> if a matching course career could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer fetchByCourseId(long spCourseId)
		throws SystemException {
		return fetchByCourseId(spCourseId, true);
	}

	/**
	 * Returns the course career where spCourseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course career, or <code>null</code> if a matching course career could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer fetchByCourseId(long spCourseId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spCourseId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COURSEID,
					finderArgs, this);
		}

		if (result instanceof CourseCareer) {
			CourseCareer courseCareer = (CourseCareer)result;

			if ((spCourseId != courseCareer.getSpCourseId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSECAREER_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_SPCOURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				List<CourseCareer> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CourseCareerPersistenceImpl.fetchByCourseId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CourseCareer courseCareer = list.get(0);

					result = courseCareer;

					cacheResult(courseCareer);

					if ((courseCareer.getSpCourseId() != spCourseId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
							finderArgs, courseCareer);
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
			return (CourseCareer)result;
		}
	}

	/**
	 * Removes the course career where spCourseId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @return the course career that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer removeByCourseId(long spCourseId)
		throws NoSuchCourseCareerException, SystemException {
		CourseCareer courseCareer = findByCourseId(spCourseId);

		return remove(courseCareer);
	}

	/**
	 * Returns the number of course careers where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @return the number of matching course careers
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

			query.append(_SQL_COUNT_COURSECAREER_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEID_SPCOURSEID_2 = "courseCareer.spCourseId = ?";

	public CourseCareerPersistenceImpl() {
		setModelClass(CourseCareer.class);
	}

	/**
	 * Caches the course career in the entity cache if it is enabled.
	 *
	 * @param courseCareer the course career
	 */
	@Override
	public void cacheResult(CourseCareer courseCareer) {
		EntityCacheUtil.putResult(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
			CourseCareerImpl.class, courseCareer.getPrimaryKey(), courseCareer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID,
			new Object[] { courseCareer.getSpCourseId() }, courseCareer);

		courseCareer.resetOriginalValues();
	}

	/**
	 * Caches the course careers in the entity cache if it is enabled.
	 *
	 * @param courseCareers the course careers
	 */
	@Override
	public void cacheResult(List<CourseCareer> courseCareers) {
		for (CourseCareer courseCareer : courseCareers) {
			if (EntityCacheUtil.getResult(
						CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
						CourseCareerImpl.class, courseCareer.getPrimaryKey()) == null) {
				cacheResult(courseCareer);
			}
			else {
				courseCareer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course careers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseCareerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseCareerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course career.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseCareer courseCareer) {
		EntityCacheUtil.removeResult(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
			CourseCareerImpl.class, courseCareer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(courseCareer);
	}

	@Override
	public void clearCache(List<CourseCareer> courseCareers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseCareer courseCareer : courseCareers) {
			EntityCacheUtil.removeResult(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
				CourseCareerImpl.class, courseCareer.getPrimaryKey());

			clearUniqueFindersCache(courseCareer);
		}
	}

	protected void cacheUniqueFindersCache(CourseCareer courseCareer) {
		if (courseCareer.isNew()) {
			Object[] args = new Object[] { courseCareer.getSpCourseId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
				courseCareer);
		}
		else {
			CourseCareerModelImpl courseCareerModelImpl = (CourseCareerModelImpl)courseCareer;

			if ((courseCareerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { courseCareer.getSpCourseId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEID, args,
					courseCareer);
			}
		}
	}

	protected void clearUniqueFindersCache(CourseCareer courseCareer) {
		CourseCareerModelImpl courseCareerModelImpl = (CourseCareerModelImpl)courseCareer;

		Object[] args = new Object[] { courseCareer.getSpCourseId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);

		if ((courseCareerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COURSEID.getColumnBitmask()) != 0) {
			args = new Object[] { courseCareerModelImpl.getOriginalSpCourseId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEID, args);
		}
	}

	/**
	 * Creates a new course career with the primary key. Does not add the course career to the database.
	 *
	 * @param spCourseCareerId the primary key for the new course career
	 * @return the new course career
	 */
	@Override
	public CourseCareer create(long spCourseCareerId) {
		CourseCareer courseCareer = new CourseCareerImpl();

		courseCareer.setNew(true);
		courseCareer.setPrimaryKey(spCourseCareerId);

		return courseCareer;
	}

	/**
	 * Removes the course career with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCourseCareerId the primary key of the course career
	 * @return the course career that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a course career with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer remove(long spCourseCareerId)
		throws NoSuchCourseCareerException, SystemException {
		return remove((Serializable)spCourseCareerId);
	}

	/**
	 * Removes the course career with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course career
	 * @return the course career that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a course career with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer remove(Serializable primaryKey)
		throws NoSuchCourseCareerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseCareer courseCareer = (CourseCareer)session.get(CourseCareerImpl.class,
					primaryKey);

			if (courseCareer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseCareerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseCareer);
		}
		catch (NoSuchCourseCareerException nsee) {
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
	protected CourseCareer removeImpl(CourseCareer courseCareer)
		throws SystemException {
		courseCareer = toUnwrappedModel(courseCareer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseCareer)) {
				courseCareer = (CourseCareer)session.get(CourseCareerImpl.class,
						courseCareer.getPrimaryKeyObj());
			}

			if (courseCareer != null) {
				session.delete(courseCareer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseCareer != null) {
			clearCache(courseCareer);
		}

		return courseCareer;
	}

	@Override
	public CourseCareer updateImpl(
		com.sambaash.platform.srv.model.CourseCareer courseCareer)
		throws SystemException {
		courseCareer = toUnwrappedModel(courseCareer);

		boolean isNew = courseCareer.isNew();

		Session session = null;

		try {
			session = openSession();

			if (courseCareer.isNew()) {
				session.save(courseCareer);

				courseCareer.setNew(false);
			}
			else {
				session.merge(courseCareer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseCareerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
			CourseCareerImpl.class, courseCareer.getPrimaryKey(), courseCareer);

		clearUniqueFindersCache(courseCareer);
		cacheUniqueFindersCache(courseCareer);

		return courseCareer;
	}

	protected CourseCareer toUnwrappedModel(CourseCareer courseCareer) {
		if (courseCareer instanceof CourseCareerImpl) {
			return courseCareer;
		}

		CourseCareerImpl courseCareerImpl = new CourseCareerImpl();

		courseCareerImpl.setNew(courseCareer.isNew());
		courseCareerImpl.setPrimaryKey(courseCareer.getPrimaryKey());

		courseCareerImpl.setSpCourseCareerId(courseCareer.getSpCourseCareerId());
		courseCareerImpl.setGroupId(courseCareer.getGroupId());
		courseCareerImpl.setCompanyId(courseCareer.getCompanyId());
		courseCareerImpl.setUserId(courseCareer.getUserId());
		courseCareerImpl.setUserName(courseCareer.getUserName());
		courseCareerImpl.setCreateDate(courseCareer.getCreateDate());
		courseCareerImpl.setModifiedDate(courseCareer.getModifiedDate());
		courseCareerImpl.setSpCourseId(courseCareer.getSpCourseId());
		courseCareerImpl.setIntro(courseCareer.getIntro());

		return courseCareerImpl;
	}

	/**
	 * Returns the course career with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course career
	 * @return the course career
	 * @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a course career with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseCareerException, SystemException {
		CourseCareer courseCareer = fetchByPrimaryKey(primaryKey);

		if (courseCareer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseCareerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseCareer;
	}

	/**
	 * Returns the course career with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseCareerException} if it could not be found.
	 *
	 * @param spCourseCareerId the primary key of the course career
	 * @return the course career
	 * @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a course career with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer findByPrimaryKey(long spCourseCareerId)
		throws NoSuchCourseCareerException, SystemException {
		return findByPrimaryKey((Serializable)spCourseCareerId);
	}

	/**
	 * Returns the course career with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course career
	 * @return the course career, or <code>null</code> if a course career with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseCareer courseCareer = (CourseCareer)EntityCacheUtil.getResult(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
				CourseCareerImpl.class, primaryKey);

		if (courseCareer == _nullCourseCareer) {
			return null;
		}

		if (courseCareer == null) {
			Session session = null;

			try {
				session = openSession();

				courseCareer = (CourseCareer)session.get(CourseCareerImpl.class,
						primaryKey);

				if (courseCareer != null) {
					cacheResult(courseCareer);
				}
				else {
					EntityCacheUtil.putResult(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
						CourseCareerImpl.class, primaryKey, _nullCourseCareer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseCareerModelImpl.ENTITY_CACHE_ENABLED,
					CourseCareerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseCareer;
	}

	/**
	 * Returns the course career with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCourseCareerId the primary key of the course career
	 * @return the course career, or <code>null</code> if a course career with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCareer fetchByPrimaryKey(long spCourseCareerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCourseCareerId);
	}

	/**
	 * Returns all the course careers.
	 *
	 * @return the course careers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCareer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course careers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCareerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course careers
	 * @param end the upper bound of the range of course careers (not inclusive)
	 * @return the range of course careers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCareer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course careers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCareerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course careers
	 * @param end the upper bound of the range of course careers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course careers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCareer> findAll(int start, int end,
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

		List<CourseCareer> list = (List<CourseCareer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSECAREER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSECAREER;

				if (pagination) {
					sql = sql.concat(CourseCareerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseCareer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseCareer>(list);
				}
				else {
					list = (List<CourseCareer>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the course careers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseCareer courseCareer : findAll()) {
			remove(courseCareer);
		}
	}

	/**
	 * Returns the number of course careers.
	 *
	 * @return the number of course careers
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

				Query q = session.createQuery(_SQL_COUNT_COURSECAREER);

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
	 * Initializes the course career persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CourseCareer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseCareer>> listenersList = new ArrayList<ModelListener<CourseCareer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseCareer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseCareerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSECAREER = "SELECT courseCareer FROM CourseCareer courseCareer";
	private static final String _SQL_SELECT_COURSECAREER_WHERE = "SELECT courseCareer FROM CourseCareer courseCareer WHERE ";
	private static final String _SQL_COUNT_COURSECAREER = "SELECT COUNT(courseCareer) FROM CourseCareer courseCareer";
	private static final String _SQL_COUNT_COURSECAREER_WHERE = "SELECT COUNT(courseCareer) FROM CourseCareer courseCareer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseCareer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseCareer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseCareer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseCareerPersistenceImpl.class);
	private static CourseCareer _nullCourseCareer = new CourseCareerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseCareer> toCacheModel() {
				return _nullCourseCareerCacheModel;
			}
		};

	private static CacheModel<CourseCareer> _nullCourseCareerCacheModel = new CacheModel<CourseCareer>() {
			@Override
			public CourseCareer toEntityModel() {
				return _nullCourseCareer;
			}
		};
}