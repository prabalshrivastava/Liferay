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

import com.sambaash.platform.srv.NoSuchCourseDurationTypeException;
import com.sambaash.platform.srv.model.CourseDurationType;
import com.sambaash.platform.srv.model.impl.CourseDurationTypeImpl;
import com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course duration type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseDurationTypePersistence
 * @see CourseDurationTypeUtil
 * @generated
 */
public class CourseDurationTypePersistenceImpl extends BasePersistenceImpl<CourseDurationType>
	implements CourseDurationTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseDurationTypeUtil} to access the course duration type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseDurationTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeModelImpl.FINDER_CACHE_ENABLED,
			CourseDurationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeModelImpl.FINDER_CACHE_ENABLED,
			CourseDurationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeModelImpl.FINDER_CACHE_ENABLED,
			CourseDurationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
		new FinderPath(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeModelImpl.FINDER_CACHE_ENABLED,
			CourseDurationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseId",
			new String[] { Long.class.getName() },
			CourseDurationTypeModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the course duration types where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @return the matching course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDurationType> findByCourseId(long spCourseId)
		throws SystemException {
		return findByCourseId(spCourseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the course duration types where spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of course duration types
	 * @param end the upper bound of the range of course duration types (not inclusive)
	 * @return the range of matching course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDurationType> findByCourseId(long spCourseId, int start,
		int end) throws SystemException {
		return findByCourseId(spCourseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course duration types where spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of course duration types
	 * @param end the upper bound of the range of course duration types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDurationType> findByCourseId(long spCourseId, int start,
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

		List<CourseDurationType> list = (List<CourseDurationType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseDurationType courseDurationType : list) {
				if ((spCourseId != courseDurationType.getSpCourseId())) {
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

			query.append(_SQL_SELECT_COURSEDURATIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_SPCOURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseDurationTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				if (!pagination) {
					list = (List<CourseDurationType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseDurationType>(list);
				}
				else {
					list = (List<CourseDurationType>)QueryUtil.list(q,
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
	 * Returns the first course duration type in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course duration type
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType findByCourseId_First(long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseDurationTypeException, SystemException {
		CourseDurationType courseDurationType = fetchByCourseId_First(spCourseId,
				orderByComparator);

		if (courseDurationType != null) {
			return courseDurationType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseDurationTypeException(msg.toString());
	}

	/**
	 * Returns the first course duration type in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course duration type, or <code>null</code> if a matching course duration type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType fetchByCourseId_First(long spCourseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseDurationType> list = findByCourseId(spCourseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course duration type in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course duration type
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType findByCourseId_Last(long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseDurationTypeException, SystemException {
		CourseDurationType courseDurationType = fetchByCourseId_Last(spCourseId,
				orderByComparator);

		if (courseDurationType != null) {
			return courseDurationType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseDurationTypeException(msg.toString());
	}

	/**
	 * Returns the last course duration type in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course duration type, or <code>null</code> if a matching course duration type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType fetchByCourseId_Last(long spCourseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseId(spCourseId);

		if (count == 0) {
			return null;
		}

		List<CourseDurationType> list = findByCourseId(spCourseId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course duration types before and after the current course duration type in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseDurationTypeId the primary key of the current course duration type
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course duration type
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType[] findByCourseId_PrevAndNext(
		long spCourseDurationTypeId, long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseDurationTypeException, SystemException {
		CourseDurationType courseDurationType = findByPrimaryKey(spCourseDurationTypeId);

		Session session = null;

		try {
			session = openSession();

			CourseDurationType[] array = new CourseDurationTypeImpl[3];

			array[0] = getByCourseId_PrevAndNext(session, courseDurationType,
					spCourseId, orderByComparator, true);

			array[1] = courseDurationType;

			array[2] = getByCourseId_PrevAndNext(session, courseDurationType,
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

	protected CourseDurationType getByCourseId_PrevAndNext(Session session,
		CourseDurationType courseDurationType, long spCourseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEDURATIONTYPE_WHERE);

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
			query.append(CourseDurationTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseDurationType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseDurationType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course duration types where spCourseId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseId(long spCourseId) throws SystemException {
		for (CourseDurationType courseDurationType : findByCourseId(
				spCourseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseDurationType);
		}
	}

	/**
	 * Returns the number of course duration types where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @return the number of matching course duration types
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

			query.append(_SQL_COUNT_COURSEDURATIONTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEID_SPCOURSEID_2 = "courseDurationType.spCourseId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEDURATIONID =
		new FinderPath(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeModelImpl.FINDER_CACHE_ENABLED,
			CourseDurationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseDurationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEDURATIONID =
		new FinderPath(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeModelImpl.FINDER_CACHE_ENABLED,
			CourseDurationTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseDurationId", new String[] { Long.class.getName() },
			CourseDurationTypeModelImpl.SPCOURSEDURATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEDURATIONID = new FinderPath(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseDurationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the course duration types where spCourseDurationId = &#63;.
	 *
	 * @param spCourseDurationId the sp course duration ID
	 * @return the matching course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDurationType> findByCourseDurationId(
		long spCourseDurationId) throws SystemException {
		return findByCourseDurationId(spCourseDurationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course duration types where spCourseDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseDurationId the sp course duration ID
	 * @param start the lower bound of the range of course duration types
	 * @param end the upper bound of the range of course duration types (not inclusive)
	 * @return the range of matching course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDurationType> findByCourseDurationId(
		long spCourseDurationId, int start, int end) throws SystemException {
		return findByCourseDurationId(spCourseDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course duration types where spCourseDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseDurationId the sp course duration ID
	 * @param start the lower bound of the range of course duration types
	 * @param end the upper bound of the range of course duration types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDurationType> findByCourseDurationId(
		long spCourseDurationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEDURATIONID;
			finderArgs = new Object[] { spCourseDurationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEDURATIONID;
			finderArgs = new Object[] {
					spCourseDurationId,
					
					start, end, orderByComparator
				};
		}

		List<CourseDurationType> list = (List<CourseDurationType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseDurationType courseDurationType : list) {
				if ((spCourseDurationId != courseDurationType.getSpCourseDurationId())) {
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

			query.append(_SQL_SELECT_COURSEDURATIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_COURSEDURATIONID_SPCOURSEDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseDurationTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseDurationId);

				if (!pagination) {
					list = (List<CourseDurationType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseDurationType>(list);
				}
				else {
					list = (List<CourseDurationType>)QueryUtil.list(q,
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
	 * Returns the first course duration type in the ordered set where spCourseDurationId = &#63;.
	 *
	 * @param spCourseDurationId the sp course duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course duration type
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType findByCourseDurationId_First(
		long spCourseDurationId, OrderByComparator orderByComparator)
		throws NoSuchCourseDurationTypeException, SystemException {
		CourseDurationType courseDurationType = fetchByCourseDurationId_First(spCourseDurationId,
				orderByComparator);

		if (courseDurationType != null) {
			return courseDurationType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseDurationId=");
		msg.append(spCourseDurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseDurationTypeException(msg.toString());
	}

	/**
	 * Returns the first course duration type in the ordered set where spCourseDurationId = &#63;.
	 *
	 * @param spCourseDurationId the sp course duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course duration type, or <code>null</code> if a matching course duration type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType fetchByCourseDurationId_First(
		long spCourseDurationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CourseDurationType> list = findByCourseDurationId(spCourseDurationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course duration type in the ordered set where spCourseDurationId = &#63;.
	 *
	 * @param spCourseDurationId the sp course duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course duration type
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType findByCourseDurationId_Last(
		long spCourseDurationId, OrderByComparator orderByComparator)
		throws NoSuchCourseDurationTypeException, SystemException {
		CourseDurationType courseDurationType = fetchByCourseDurationId_Last(spCourseDurationId,
				orderByComparator);

		if (courseDurationType != null) {
			return courseDurationType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseDurationId=");
		msg.append(spCourseDurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseDurationTypeException(msg.toString());
	}

	/**
	 * Returns the last course duration type in the ordered set where spCourseDurationId = &#63;.
	 *
	 * @param spCourseDurationId the sp course duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course duration type, or <code>null</code> if a matching course duration type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType fetchByCourseDurationId_Last(
		long spCourseDurationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseDurationId(spCourseDurationId);

		if (count == 0) {
			return null;
		}

		List<CourseDurationType> list = findByCourseDurationId(spCourseDurationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course duration types before and after the current course duration type in the ordered set where spCourseDurationId = &#63;.
	 *
	 * @param spCourseDurationTypeId the primary key of the current course duration type
	 * @param spCourseDurationId the sp course duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course duration type
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType[] findByCourseDurationId_PrevAndNext(
		long spCourseDurationTypeId, long spCourseDurationId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseDurationTypeException, SystemException {
		CourseDurationType courseDurationType = findByPrimaryKey(spCourseDurationTypeId);

		Session session = null;

		try {
			session = openSession();

			CourseDurationType[] array = new CourseDurationTypeImpl[3];

			array[0] = getByCourseDurationId_PrevAndNext(session,
					courseDurationType, spCourseDurationId, orderByComparator,
					true);

			array[1] = courseDurationType;

			array[2] = getByCourseDurationId_PrevAndNext(session,
					courseDurationType, spCourseDurationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseDurationType getByCourseDurationId_PrevAndNext(
		Session session, CourseDurationType courseDurationType,
		long spCourseDurationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEDURATIONTYPE_WHERE);

		query.append(_FINDER_COLUMN_COURSEDURATIONID_SPCOURSEDURATIONID_2);

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
			query.append(CourseDurationTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseDurationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseDurationType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseDurationType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course duration types where spCourseDurationId = &#63; from the database.
	 *
	 * @param spCourseDurationId the sp course duration ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseDurationId(long spCourseDurationId)
		throws SystemException {
		for (CourseDurationType courseDurationType : findByCourseDurationId(
				spCourseDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseDurationType);
		}
	}

	/**
	 * Returns the number of course duration types where spCourseDurationId = &#63;.
	 *
	 * @param spCourseDurationId the sp course duration ID
	 * @return the number of matching course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseDurationId(long spCourseDurationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEDURATIONID;

		Object[] finderArgs = new Object[] { spCourseDurationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEDURATIONTYPE_WHERE);

			query.append(_FINDER_COLUMN_COURSEDURATIONID_SPCOURSEDURATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseDurationId);

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

	private static final String _FINDER_COLUMN_COURSEDURATIONID_SPCOURSEDURATIONID_2 =
		"courseDurationType.spCourseDurationId = ?";

	public CourseDurationTypePersistenceImpl() {
		setModelClass(CourseDurationType.class);
	}

	/**
	 * Caches the course duration type in the entity cache if it is enabled.
	 *
	 * @param courseDurationType the course duration type
	 */
	@Override
	public void cacheResult(CourseDurationType courseDurationType) {
		EntityCacheUtil.putResult(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeImpl.class, courseDurationType.getPrimaryKey(),
			courseDurationType);

		courseDurationType.resetOriginalValues();
	}

	/**
	 * Caches the course duration types in the entity cache if it is enabled.
	 *
	 * @param courseDurationTypes the course duration types
	 */
	@Override
	public void cacheResult(List<CourseDurationType> courseDurationTypes) {
		for (CourseDurationType courseDurationType : courseDurationTypes) {
			if (EntityCacheUtil.getResult(
						CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
						CourseDurationTypeImpl.class,
						courseDurationType.getPrimaryKey()) == null) {
				cacheResult(courseDurationType);
			}
			else {
				courseDurationType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course duration types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseDurationTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseDurationTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course duration type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseDurationType courseDurationType) {
		EntityCacheUtil.removeResult(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeImpl.class, courseDurationType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CourseDurationType> courseDurationTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseDurationType courseDurationType : courseDurationTypes) {
			EntityCacheUtil.removeResult(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
				CourseDurationTypeImpl.class, courseDurationType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new course duration type with the primary key. Does not add the course duration type to the database.
	 *
	 * @param spCourseDurationTypeId the primary key for the new course duration type
	 * @return the new course duration type
	 */
	@Override
	public CourseDurationType create(long spCourseDurationTypeId) {
		CourseDurationType courseDurationType = new CourseDurationTypeImpl();

		courseDurationType.setNew(true);
		courseDurationType.setPrimaryKey(spCourseDurationTypeId);

		return courseDurationType;
	}

	/**
	 * Removes the course duration type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCourseDurationTypeId the primary key of the course duration type
	 * @return the course duration type that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType remove(long spCourseDurationTypeId)
		throws NoSuchCourseDurationTypeException, SystemException {
		return remove((Serializable)spCourseDurationTypeId);
	}

	/**
	 * Removes the course duration type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course duration type
	 * @return the course duration type that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType remove(Serializable primaryKey)
		throws NoSuchCourseDurationTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseDurationType courseDurationType = (CourseDurationType)session.get(CourseDurationTypeImpl.class,
					primaryKey);

			if (courseDurationType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseDurationTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseDurationType);
		}
		catch (NoSuchCourseDurationTypeException nsee) {
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
	protected CourseDurationType removeImpl(
		CourseDurationType courseDurationType) throws SystemException {
		courseDurationType = toUnwrappedModel(courseDurationType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseDurationType)) {
				courseDurationType = (CourseDurationType)session.get(CourseDurationTypeImpl.class,
						courseDurationType.getPrimaryKeyObj());
			}

			if (courseDurationType != null) {
				session.delete(courseDurationType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseDurationType != null) {
			clearCache(courseDurationType);
		}

		return courseDurationType;
	}

	@Override
	public CourseDurationType updateImpl(
		com.sambaash.platform.srv.model.CourseDurationType courseDurationType)
		throws SystemException {
		courseDurationType = toUnwrappedModel(courseDurationType);

		boolean isNew = courseDurationType.isNew();

		CourseDurationTypeModelImpl courseDurationTypeModelImpl = (CourseDurationTypeModelImpl)courseDurationType;

		Session session = null;

		try {
			session = openSession();

			if (courseDurationType.isNew()) {
				session.save(courseDurationType);

				courseDurationType.setNew(false);
			}
			else {
				session.merge(courseDurationType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseDurationTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseDurationTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseDurationTypeModelImpl.getOriginalSpCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);

				args = new Object[] { courseDurationTypeModelImpl.getSpCourseId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);
			}

			if ((courseDurationTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEDURATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseDurationTypeModelImpl.getOriginalSpCourseDurationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEDURATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEDURATIONID,
					args);

				args = new Object[] {
						courseDurationTypeModelImpl.getSpCourseDurationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEDURATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEDURATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseDurationTypeImpl.class, courseDurationType.getPrimaryKey(),
			courseDurationType);

		return courseDurationType;
	}

	protected CourseDurationType toUnwrappedModel(
		CourseDurationType courseDurationType) {
		if (courseDurationType instanceof CourseDurationTypeImpl) {
			return courseDurationType;
		}

		CourseDurationTypeImpl courseDurationTypeImpl = new CourseDurationTypeImpl();

		courseDurationTypeImpl.setNew(courseDurationType.isNew());
		courseDurationTypeImpl.setPrimaryKey(courseDurationType.getPrimaryKey());

		courseDurationTypeImpl.setSpCourseDurationTypeId(courseDurationType.getSpCourseDurationTypeId());
		courseDurationTypeImpl.setGroupId(courseDurationType.getGroupId());
		courseDurationTypeImpl.setCompanyId(courseDurationType.getCompanyId());
		courseDurationTypeImpl.setUserId(courseDurationType.getUserId());
		courseDurationTypeImpl.setUserName(courseDurationType.getUserName());
		courseDurationTypeImpl.setCreateDate(courseDurationType.getCreateDate());
		courseDurationTypeImpl.setModifiedDate(courseDurationType.getModifiedDate());
		courseDurationTypeImpl.setSpCourseDurationId(courseDurationType.getSpCourseDurationId());
		courseDurationTypeImpl.setSpCourseId(courseDurationType.getSpCourseId());
		courseDurationTypeImpl.setTitle1(courseDurationType.getTitle1());
		courseDurationTypeImpl.setDuration1(courseDurationType.getDuration1());
		courseDurationTypeImpl.setTitle2(courseDurationType.getTitle2());
		courseDurationTypeImpl.setDuration2(courseDurationType.getDuration2());

		return courseDurationTypeImpl;
	}

	/**
	 * Returns the course duration type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course duration type
	 * @return the course duration type
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseDurationTypeException, SystemException {
		CourseDurationType courseDurationType = fetchByPrimaryKey(primaryKey);

		if (courseDurationType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseDurationTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseDurationType;
	}

	/**
	 * Returns the course duration type with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseDurationTypeException} if it could not be found.
	 *
	 * @param spCourseDurationTypeId the primary key of the course duration type
	 * @return the course duration type
	 * @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType findByPrimaryKey(long spCourseDurationTypeId)
		throws NoSuchCourseDurationTypeException, SystemException {
		return findByPrimaryKey((Serializable)spCourseDurationTypeId);
	}

	/**
	 * Returns the course duration type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course duration type
	 * @return the course duration type, or <code>null</code> if a course duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseDurationType courseDurationType = (CourseDurationType)EntityCacheUtil.getResult(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
				CourseDurationTypeImpl.class, primaryKey);

		if (courseDurationType == _nullCourseDurationType) {
			return null;
		}

		if (courseDurationType == null) {
			Session session = null;

			try {
				session = openSession();

				courseDurationType = (CourseDurationType)session.get(CourseDurationTypeImpl.class,
						primaryKey);

				if (courseDurationType != null) {
					cacheResult(courseDurationType);
				}
				else {
					EntityCacheUtil.putResult(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
						CourseDurationTypeImpl.class, primaryKey,
						_nullCourseDurationType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseDurationTypeModelImpl.ENTITY_CACHE_ENABLED,
					CourseDurationTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseDurationType;
	}

	/**
	 * Returns the course duration type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCourseDurationTypeId the primary key of the course duration type
	 * @return the course duration type, or <code>null</code> if a course duration type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseDurationType fetchByPrimaryKey(long spCourseDurationTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCourseDurationTypeId);
	}

	/**
	 * Returns all the course duration types.
	 *
	 * @return the course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDurationType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course duration types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course duration types
	 * @param end the upper bound of the range of course duration types (not inclusive)
	 * @return the range of course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDurationType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course duration types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course duration types
	 * @param end the upper bound of the range of course duration types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course duration types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseDurationType> findAll(int start, int end,
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

		List<CourseDurationType> list = (List<CourseDurationType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSEDURATIONTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSEDURATIONTYPE;

				if (pagination) {
					sql = sql.concat(CourseDurationTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseDurationType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseDurationType>(list);
				}
				else {
					list = (List<CourseDurationType>)QueryUtil.list(q,
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
	 * Removes all the course duration types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseDurationType courseDurationType : findAll()) {
			remove(courseDurationType);
		}
	}

	/**
	 * Returns the number of course duration types.
	 *
	 * @return the number of course duration types
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

				Query q = session.createQuery(_SQL_COUNT_COURSEDURATIONTYPE);

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
	 * Initializes the course duration type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CourseDurationType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseDurationType>> listenersList = new ArrayList<ModelListener<CourseDurationType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseDurationType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseDurationTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSEDURATIONTYPE = "SELECT courseDurationType FROM CourseDurationType courseDurationType";
	private static final String _SQL_SELECT_COURSEDURATIONTYPE_WHERE = "SELECT courseDurationType FROM CourseDurationType courseDurationType WHERE ";
	private static final String _SQL_COUNT_COURSEDURATIONTYPE = "SELECT COUNT(courseDurationType) FROM CourseDurationType courseDurationType";
	private static final String _SQL_COUNT_COURSEDURATIONTYPE_WHERE = "SELECT COUNT(courseDurationType) FROM CourseDurationType courseDurationType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseDurationType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseDurationType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseDurationType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseDurationTypePersistenceImpl.class);
	private static CourseDurationType _nullCourseDurationType = new CourseDurationTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseDurationType> toCacheModel() {
				return _nullCourseDurationTypeCacheModel;
			}
		};

	private static CacheModel<CourseDurationType> _nullCourseDurationTypeCacheModel =
		new CacheModel<CourseDurationType>() {
			@Override
			public CourseDurationType toEntityModel() {
				return _nullCourseDurationType;
			}
		};
}