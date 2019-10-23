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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchStudyOptionException;
import com.sambaash.platform.srv.model.StudyOption;
import com.sambaash.platform.srv.model.impl.StudyOptionImpl;
import com.sambaash.platform.srv.model.impl.StudyOptionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the study option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudyOptionPersistence
 * @see StudyOptionUtil
 * @generated
 */
public class StudyOptionPersistenceImpl extends BasePersistenceImpl<StudyOption>
	implements StudyOptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudyOptionUtil} to access the study option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudyOptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
			StudyOptionModelImpl.FINDER_CACHE_ENABLED, StudyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
			StudyOptionModelImpl.FINDER_CACHE_ENABLED, StudyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
			StudyOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
			StudyOptionModelImpl.FINDER_CACHE_ENABLED, StudyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
		new FinderPath(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
			StudyOptionModelImpl.FINDER_CACHE_ENABLED, StudyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseId",
			new String[] { Long.class.getName() },
			StudyOptionModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
			StudyOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the study options where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @return the matching study options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudyOption> findByCourseId(long spCourseId)
		throws SystemException {
		return findByCourseId(spCourseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the study options where spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of study options
	 * @param end the upper bound of the range of study options (not inclusive)
	 * @return the range of matching study options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudyOption> findByCourseId(long spCourseId, int start, int end)
		throws SystemException {
		return findByCourseId(spCourseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the study options where spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of study options
	 * @param end the upper bound of the range of study options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching study options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudyOption> findByCourseId(long spCourseId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { spCourseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { spCourseId, start, end, orderByComparator };
		}

		List<StudyOption> list = (List<StudyOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StudyOption studyOption : list) {
				if ((spCourseId != studyOption.getSpCourseId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDYOPTION_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_SPCOURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudyOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				if (!pagination) {
					list = (List<StudyOption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StudyOption>(list);
				}
				else {
					list = (List<StudyOption>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first study option in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching study option
	 * @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a matching study option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption findByCourseId_First(long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchStudyOptionException, SystemException {
		StudyOption studyOption = fetchByCourseId_First(spCourseId,
				orderByComparator);

		if (studyOption != null) {
			return studyOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudyOptionException(msg.toString());
	}

	/**
	 * Returns the first study option in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching study option, or <code>null</code> if a matching study option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption fetchByCourseId_First(long spCourseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StudyOption> list = findByCourseId(spCourseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last study option in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching study option
	 * @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a matching study option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption findByCourseId_Last(long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchStudyOptionException, SystemException {
		StudyOption studyOption = fetchByCourseId_Last(spCourseId,
				orderByComparator);

		if (studyOption != null) {
			return studyOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudyOptionException(msg.toString());
	}

	/**
	 * Returns the last study option in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching study option, or <code>null</code> if a matching study option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption fetchByCourseId_Last(long spCourseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseId(spCourseId);

		if (count == 0) {
			return null;
		}

		List<StudyOption> list = findByCourseId(spCourseId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the study options before and after the current study option in the ordered set where spCourseId = &#63;.
	 *
	 * @param spStudyOptionId the primary key of the current study option
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next study option
	 * @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption[] findByCourseId_PrevAndNext(long spStudyOptionId,
		long spCourseId, OrderByComparator orderByComparator)
		throws NoSuchStudyOptionException, SystemException {
		StudyOption studyOption = findByPrimaryKey(spStudyOptionId);

		Session session = null;

		try {
			session = openSession();

			StudyOption[] array = new StudyOptionImpl[3];

			array[0] = getByCourseId_PrevAndNext(session, studyOption,
					spCourseId, orderByComparator, true);

			array[1] = studyOption;

			array[2] = getByCourseId_PrevAndNext(session, studyOption,
					spCourseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudyOption getByCourseId_PrevAndNext(Session session,
		StudyOption studyOption, long spCourseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDYOPTION_WHERE);

		query.append(_FINDER_COLUMN_COURSEID_SPCOURSEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudyOptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(studyOption);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudyOption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the study options where spCourseId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseId(long spCourseId) throws SystemException {
		for (StudyOption studyOption : findByCourseId(spCourseId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(studyOption);
		}
	}

	/**
	 * Returns the number of study options where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @return the number of matching study options
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

			query.append(_SQL_COUNT_STUDYOPTION_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEID_SPCOURSEID_2 = "studyOption.spCourseId = ?";

	public StudyOptionPersistenceImpl() {
		setModelClass(StudyOption.class);
	}

	/**
	 * Caches the study option in the entity cache if it is enabled.
	 *
	 * @param studyOption the study option
	 */
	@Override
	public void cacheResult(StudyOption studyOption) {
		EntityCacheUtil.putResult(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
			StudyOptionImpl.class, studyOption.getPrimaryKey(), studyOption);

		studyOption.resetOriginalValues();
	}

	/**
	 * Caches the study options in the entity cache if it is enabled.
	 *
	 * @param studyOptions the study options
	 */
	@Override
	public void cacheResult(List<StudyOption> studyOptions) {
		for (StudyOption studyOption : studyOptions) {
			if (EntityCacheUtil.getResult(
						StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
						StudyOptionImpl.class, studyOption.getPrimaryKey()) == null) {
				cacheResult(studyOption);
			}
			else {
				studyOption.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all study options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudyOptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudyOptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the study option.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudyOption studyOption) {
		EntityCacheUtil.removeResult(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
			StudyOptionImpl.class, studyOption.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StudyOption> studyOptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StudyOption studyOption : studyOptions) {
			EntityCacheUtil.removeResult(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
				StudyOptionImpl.class, studyOption.getPrimaryKey());
		}
	}

	/**
	 * Creates a new study option with the primary key. Does not add the study option to the database.
	 *
	 * @param spStudyOptionId the primary key for the new study option
	 * @return the new study option
	 */
	@Override
	public StudyOption create(long spStudyOptionId) {
		StudyOption studyOption = new StudyOptionImpl();

		studyOption.setNew(true);
		studyOption.setPrimaryKey(spStudyOptionId);

		return studyOption;
	}

	/**
	 * Removes the study option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spStudyOptionId the primary key of the study option
	 * @return the study option that was removed
	 * @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption remove(long spStudyOptionId)
		throws NoSuchStudyOptionException, SystemException {
		return remove((Serializable)spStudyOptionId);
	}

	/**
	 * Removes the study option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the study option
	 * @return the study option that was removed
	 * @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption remove(Serializable primaryKey)
		throws NoSuchStudyOptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StudyOption studyOption = (StudyOption)session.get(StudyOptionImpl.class,
					primaryKey);

			if (studyOption == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudyOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(studyOption);
		}
		catch (NoSuchStudyOptionException nsee) {
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
	protected StudyOption removeImpl(StudyOption studyOption)
		throws SystemException {
		studyOption = toUnwrappedModel(studyOption);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studyOption)) {
				studyOption = (StudyOption)session.get(StudyOptionImpl.class,
						studyOption.getPrimaryKeyObj());
			}

			if (studyOption != null) {
				session.delete(studyOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (studyOption != null) {
			clearCache(studyOption);
		}

		return studyOption;
	}

	@Override
	public StudyOption updateImpl(
		com.sambaash.platform.srv.model.StudyOption studyOption)
		throws SystemException {
		studyOption = toUnwrappedModel(studyOption);

		boolean isNew = studyOption.isNew();

		StudyOptionModelImpl studyOptionModelImpl = (StudyOptionModelImpl)studyOption;

		Session session = null;

		try {
			session = openSession();

			if (studyOption.isNew()) {
				session.save(studyOption);

				studyOption.setNew(false);
			}
			else {
				session.merge(studyOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudyOptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((studyOptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studyOptionModelImpl.getOriginalSpCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);

				args = new Object[] { studyOptionModelImpl.getSpCourseId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);
			}
		}

		EntityCacheUtil.putResult(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
			StudyOptionImpl.class, studyOption.getPrimaryKey(), studyOption);

		return studyOption;
	}

	protected StudyOption toUnwrappedModel(StudyOption studyOption) {
		if (studyOption instanceof StudyOptionImpl) {
			return studyOption;
		}

		StudyOptionImpl studyOptionImpl = new StudyOptionImpl();

		studyOptionImpl.setNew(studyOption.isNew());
		studyOptionImpl.setPrimaryKey(studyOption.getPrimaryKey());

		studyOptionImpl.setSpStudyOptionId(studyOption.getSpStudyOptionId());
		studyOptionImpl.setGroupId(studyOption.getGroupId());
		studyOptionImpl.setCompanyId(studyOption.getCompanyId());
		studyOptionImpl.setUserId(studyOption.getUserId());
		studyOptionImpl.setUserName(studyOption.getUserName());
		studyOptionImpl.setCreateDate(studyOption.getCreateDate());
		studyOptionImpl.setModifiedDate(studyOption.getModifiedDate());
		studyOptionImpl.setSpCourseId(studyOption.getSpCourseId());
		studyOptionImpl.setTitle(studyOption.getTitle());
		studyOptionImpl.setDesc(studyOption.getDesc());
		studyOptionImpl.setCoverImageFileEntryId(studyOption.getCoverImageFileEntryId());

		return studyOptionImpl;
	}

	/**
	 * Returns the study option with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the study option
	 * @return the study option
	 * @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudyOptionException, SystemException {
		StudyOption studyOption = fetchByPrimaryKey(primaryKey);

		if (studyOption == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudyOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return studyOption;
	}

	/**
	 * Returns the study option with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchStudyOptionException} if it could not be found.
	 *
	 * @param spStudyOptionId the primary key of the study option
	 * @return the study option
	 * @throws com.sambaash.platform.srv.NoSuchStudyOptionException if a study option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption findByPrimaryKey(long spStudyOptionId)
		throws NoSuchStudyOptionException, SystemException {
		return findByPrimaryKey((Serializable)spStudyOptionId);
	}

	/**
	 * Returns the study option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the study option
	 * @return the study option, or <code>null</code> if a study option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StudyOption studyOption = (StudyOption)EntityCacheUtil.getResult(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
				StudyOptionImpl.class, primaryKey);

		if (studyOption == _nullStudyOption) {
			return null;
		}

		if (studyOption == null) {
			Session session = null;

			try {
				session = openSession();

				studyOption = (StudyOption)session.get(StudyOptionImpl.class,
						primaryKey);

				if (studyOption != null) {
					cacheResult(studyOption);
				}
				else {
					EntityCacheUtil.putResult(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
						StudyOptionImpl.class, primaryKey, _nullStudyOption);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StudyOptionModelImpl.ENTITY_CACHE_ENABLED,
					StudyOptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return studyOption;
	}

	/**
	 * Returns the study option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spStudyOptionId the primary key of the study option
	 * @return the study option, or <code>null</code> if a study option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudyOption fetchByPrimaryKey(long spStudyOptionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spStudyOptionId);
	}

	/**
	 * Returns all the study options.
	 *
	 * @return the study options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudyOption> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the study options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of study options
	 * @param end the upper bound of the range of study options (not inclusive)
	 * @return the range of study options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudyOption> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the study options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of study options
	 * @param end the upper bound of the range of study options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of study options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudyOption> findAll(int start, int end,
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

		List<StudyOption> list = (List<StudyOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDYOPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDYOPTION;

				if (pagination) {
					sql = sql.concat(StudyOptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StudyOption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StudyOption>(list);
				}
				else {
					list = (List<StudyOption>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the study options from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StudyOption studyOption : findAll()) {
			remove(studyOption);
		}
	}

	/**
	 * Returns the number of study options.
	 *
	 * @return the number of study options
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

				Query q = session.createQuery(_SQL_COUNT_STUDYOPTION);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the study option persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.StudyOption")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StudyOption>> listenersList = new ArrayList<ModelListener<StudyOption>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StudyOption>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StudyOptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STUDYOPTION = "SELECT studyOption FROM StudyOption studyOption";
	private static final String _SQL_SELECT_STUDYOPTION_WHERE = "SELECT studyOption FROM StudyOption studyOption WHERE ";
	private static final String _SQL_COUNT_STUDYOPTION = "SELECT COUNT(studyOption) FROM StudyOption studyOption";
	private static final String _SQL_COUNT_STUDYOPTION_WHERE = "SELECT COUNT(studyOption) FROM StudyOption studyOption WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "studyOption.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StudyOption exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StudyOption exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudyOptionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"desc"
			});
	private static StudyOption _nullStudyOption = new StudyOptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StudyOption> toCacheModel() {
				return _nullStudyOptionCacheModel;
			}
		};

	private static CacheModel<StudyOption> _nullStudyOptionCacheModel = new CacheModel<StudyOption>() {
			@Override
			public StudyOption toEntityModel() {
				return _nullStudyOption;
			}
		};
}