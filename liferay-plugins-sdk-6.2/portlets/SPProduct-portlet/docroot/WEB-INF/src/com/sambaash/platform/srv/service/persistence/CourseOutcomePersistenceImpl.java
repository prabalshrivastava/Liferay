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

import com.sambaash.platform.srv.NoSuchCourseOutcomeException;
import com.sambaash.platform.srv.model.CourseOutcome;
import com.sambaash.platform.srv.model.impl.CourseOutcomeImpl;
import com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course outcome service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseOutcomePersistence
 * @see CourseOutcomeUtil
 * @generated
 */
public class CourseOutcomePersistenceImpl extends BasePersistenceImpl<CourseOutcome>
	implements CourseOutcomePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseOutcomeUtil} to access the course outcome persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseOutcomeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeModelImpl.FINDER_CACHE_ENABLED,
			CourseOutcomeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeModelImpl.FINDER_CACHE_ENABLED,
			CourseOutcomeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeModelImpl.FINDER_CACHE_ENABLED,
			CourseOutcomeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeModelImpl.FINDER_CACHE_ENABLED,
			CourseOutcomeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			CourseOutcomeModelImpl.GROUPID_COLUMN_BITMASK |
			CourseOutcomeModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the course outcomes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseOutcome> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course outcomes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course outcomes
	 * @param end the upper bound of the range of course outcomes (not inclusive)
	 * @return the range of matching course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseOutcome> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course outcomes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course outcomes
	 * @param end the upper bound of the range of course outcomes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseOutcome> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<CourseOutcome> list = (List<CourseOutcome>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseOutcome courseOutcome : list) {
				if ((groupId != courseOutcome.getGroupId())) {
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

			query.append(_SQL_SELECT_COURSEOUTCOME_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseOutcomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CourseOutcome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseOutcome>(list);
				}
				else {
					list = (List<CourseOutcome>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first course outcome in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course outcome
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a matching course outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseOutcomeException, SystemException {
		CourseOutcome courseOutcome = fetchByGroupId_First(groupId,
				orderByComparator);

		if (courseOutcome != null) {
			return courseOutcome;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseOutcomeException(msg.toString());
	}

	/**
	 * Returns the first course outcome in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course outcome, or <code>null</code> if a matching course outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseOutcome> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course outcome in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course outcome
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a matching course outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseOutcomeException, SystemException {
		CourseOutcome courseOutcome = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (courseOutcome != null) {
			return courseOutcome;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseOutcomeException(msg.toString());
	}

	/**
	 * Returns the last course outcome in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course outcome, or <code>null</code> if a matching course outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CourseOutcome> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course outcomes before and after the current course outcome in the ordered set where groupId = &#63;.
	 *
	 * @param spCourseOutcomeId the primary key of the current course outcome
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course outcome
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a course outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome[] findByGroupId_PrevAndNext(long spCourseOutcomeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseOutcomeException, SystemException {
		CourseOutcome courseOutcome = findByPrimaryKey(spCourseOutcomeId);

		Session session = null;

		try {
			session = openSession();

			CourseOutcome[] array = new CourseOutcomeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, courseOutcome,
					groupId, orderByComparator, true);

			array[1] = courseOutcome;

			array[2] = getByGroupId_PrevAndNext(session, courseOutcome,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseOutcome getByGroupId_PrevAndNext(Session session,
		CourseOutcome courseOutcome, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEOUTCOME_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(CourseOutcomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseOutcome);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseOutcome> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course outcomes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (CourseOutcome courseOutcome : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseOutcome);
		}
	}

	/**
	 * Returns the number of course outcomes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSEOUTCOME_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "courseOutcome.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeModelImpl.FINDER_CACHE_ENABLED,
			CourseOutcomeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeModelImpl.FINDER_CACHE_ENABLED,
			CourseOutcomeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CourseOutcomeModelImpl.SPCOURSEID_COLUMN_BITMASK |
			CourseOutcomeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the course outcomes where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseOutcome> findByCourseIdAndGroupId(long spCourseId,
		long groupId) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course outcomes where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course outcomes
	 * @param end the upper bound of the range of course outcomes (not inclusive)
	 * @return the range of matching course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseOutcome> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course outcomes where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course outcomes
	 * @param end the upper bound of the range of course outcomes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseOutcome> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID;
			finderArgs = new Object[] { spCourseId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID;
			finderArgs = new Object[] {
					spCourseId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CourseOutcome> list = (List<CourseOutcome>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseOutcome courseOutcome : list) {
				if ((spCourseId != courseOutcome.getSpCourseId()) ||
						(groupId != courseOutcome.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COURSEOUTCOME_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseOutcomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CourseOutcome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseOutcome>(list);
				}
				else {
					list = (List<CourseOutcome>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first course outcome in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course outcome
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a matching course outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseOutcomeException, SystemException {
		CourseOutcome courseOutcome = fetchByCourseIdAndGroupId_First(spCourseId,
				groupId, orderByComparator);

		if (courseOutcome != null) {
			return courseOutcome;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseOutcomeException(msg.toString());
	}

	/**
	 * Returns the first course outcome in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course outcome, or <code>null</code> if a matching course outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CourseOutcome> list = findByCourseIdAndGroupId(spCourseId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course outcome in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course outcome
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a matching course outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome findByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseOutcomeException, SystemException {
		CourseOutcome courseOutcome = fetchByCourseIdAndGroupId_Last(spCourseId,
				groupId, orderByComparator);

		if (courseOutcome != null) {
			return courseOutcome;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseOutcomeException(msg.toString());
	}

	/**
	 * Returns the last course outcome in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course outcome, or <code>null</code> if a matching course outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<CourseOutcome> list = findByCourseIdAndGroupId(spCourseId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course outcomes before and after the current course outcome in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseOutcomeId the primary key of the current course outcome
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course outcome
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a course outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome[] findByCourseIdAndGroupId_PrevAndNext(
		long spCourseOutcomeId, long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseOutcomeException, SystemException {
		CourseOutcome courseOutcome = findByPrimaryKey(spCourseOutcomeId);

		Session session = null;

		try {
			session = openSession();

			CourseOutcome[] array = new CourseOutcomeImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session,
					courseOutcome, spCourseId, groupId, orderByComparator, true);

			array[1] = courseOutcome;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session,
					courseOutcome, spCourseId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseOutcome getByCourseIdAndGroupId_PrevAndNext(
		Session session, CourseOutcome courseOutcome, long spCourseId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEOUTCOME_WHERE);

		query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

		query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

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
			query.append(CourseOutcomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseOutcome);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseOutcome> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course outcomes where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (CourseOutcome courseOutcome : findByCourseIdAndGroupId(
				spCourseId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseOutcome);
		}
	}

	/**
	 * Returns the number of course outcomes where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID;

		Object[] finderArgs = new Object[] { spCourseId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSEOUTCOME_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "courseOutcome.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "courseOutcome.groupId = ?";

	public CourseOutcomePersistenceImpl() {
		setModelClass(CourseOutcome.class);
	}

	/**
	 * Caches the course outcome in the entity cache if it is enabled.
	 *
	 * @param courseOutcome the course outcome
	 */
	@Override
	public void cacheResult(CourseOutcome courseOutcome) {
		EntityCacheUtil.putResult(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeImpl.class, courseOutcome.getPrimaryKey(),
			courseOutcome);

		courseOutcome.resetOriginalValues();
	}

	/**
	 * Caches the course outcomes in the entity cache if it is enabled.
	 *
	 * @param courseOutcomes the course outcomes
	 */
	@Override
	public void cacheResult(List<CourseOutcome> courseOutcomes) {
		for (CourseOutcome courseOutcome : courseOutcomes) {
			if (EntityCacheUtil.getResult(
						CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
						CourseOutcomeImpl.class, courseOutcome.getPrimaryKey()) == null) {
				cacheResult(courseOutcome);
			}
			else {
				courseOutcome.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course outcomes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseOutcomeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseOutcomeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course outcome.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseOutcome courseOutcome) {
		EntityCacheUtil.removeResult(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeImpl.class, courseOutcome.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CourseOutcome> courseOutcomes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseOutcome courseOutcome : courseOutcomes) {
			EntityCacheUtil.removeResult(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
				CourseOutcomeImpl.class, courseOutcome.getPrimaryKey());
		}
	}

	/**
	 * Creates a new course outcome with the primary key. Does not add the course outcome to the database.
	 *
	 * @param spCourseOutcomeId the primary key for the new course outcome
	 * @return the new course outcome
	 */
	@Override
	public CourseOutcome create(long spCourseOutcomeId) {
		CourseOutcome courseOutcome = new CourseOutcomeImpl();

		courseOutcome.setNew(true);
		courseOutcome.setPrimaryKey(spCourseOutcomeId);

		return courseOutcome;
	}

	/**
	 * Removes the course outcome with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCourseOutcomeId the primary key of the course outcome
	 * @return the course outcome that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a course outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome remove(long spCourseOutcomeId)
		throws NoSuchCourseOutcomeException, SystemException {
		return remove((Serializable)spCourseOutcomeId);
	}

	/**
	 * Removes the course outcome with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course outcome
	 * @return the course outcome that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a course outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome remove(Serializable primaryKey)
		throws NoSuchCourseOutcomeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseOutcome courseOutcome = (CourseOutcome)session.get(CourseOutcomeImpl.class,
					primaryKey);

			if (courseOutcome == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseOutcomeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseOutcome);
		}
		catch (NoSuchCourseOutcomeException nsee) {
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
	protected CourseOutcome removeImpl(CourseOutcome courseOutcome)
		throws SystemException {
		courseOutcome = toUnwrappedModel(courseOutcome);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseOutcome)) {
				courseOutcome = (CourseOutcome)session.get(CourseOutcomeImpl.class,
						courseOutcome.getPrimaryKeyObj());
			}

			if (courseOutcome != null) {
				session.delete(courseOutcome);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseOutcome != null) {
			clearCache(courseOutcome);
		}

		return courseOutcome;
	}

	@Override
	public CourseOutcome updateImpl(
		com.sambaash.platform.srv.model.CourseOutcome courseOutcome)
		throws SystemException {
		courseOutcome = toUnwrappedModel(courseOutcome);

		boolean isNew = courseOutcome.isNew();

		CourseOutcomeModelImpl courseOutcomeModelImpl = (CourseOutcomeModelImpl)courseOutcome;

		Session session = null;

		try {
			session = openSession();

			if (courseOutcome.isNew()) {
				session.save(courseOutcome);

				courseOutcome.setNew(false);
			}
			else {
				session.merge(courseOutcome);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseOutcomeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseOutcomeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseOutcomeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { courseOutcomeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((courseOutcomeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseOutcomeModelImpl.getOriginalSpCourseId(),
						courseOutcomeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						courseOutcomeModelImpl.getSpCourseId(),
						courseOutcomeModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
			CourseOutcomeImpl.class, courseOutcome.getPrimaryKey(),
			courseOutcome);

		return courseOutcome;
	}

	protected CourseOutcome toUnwrappedModel(CourseOutcome courseOutcome) {
		if (courseOutcome instanceof CourseOutcomeImpl) {
			return courseOutcome;
		}

		CourseOutcomeImpl courseOutcomeImpl = new CourseOutcomeImpl();

		courseOutcomeImpl.setNew(courseOutcome.isNew());
		courseOutcomeImpl.setPrimaryKey(courseOutcome.getPrimaryKey());

		courseOutcomeImpl.setSpCourseOutcomeId(courseOutcome.getSpCourseOutcomeId());
		courseOutcomeImpl.setGroupId(courseOutcome.getGroupId());
		courseOutcomeImpl.setCompanyId(courseOutcome.getCompanyId());
		courseOutcomeImpl.setUserId(courseOutcome.getUserId());
		courseOutcomeImpl.setUserName(courseOutcome.getUserName());
		courseOutcomeImpl.setCreateDate(courseOutcome.getCreateDate());
		courseOutcomeImpl.setModifiedDate(courseOutcome.getModifiedDate());
		courseOutcomeImpl.setSpCourseId(courseOutcome.getSpCourseId());
		courseOutcomeImpl.setOutcomeId(courseOutcome.getOutcomeId());
		courseOutcomeImpl.setOutcomeDesc(courseOutcome.getOutcomeDesc());

		return courseOutcomeImpl;
	}

	/**
	 * Returns the course outcome with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course outcome
	 * @return the course outcome
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a course outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseOutcomeException, SystemException {
		CourseOutcome courseOutcome = fetchByPrimaryKey(primaryKey);

		if (courseOutcome == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseOutcomeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseOutcome;
	}

	/**
	 * Returns the course outcome with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseOutcomeException} if it could not be found.
	 *
	 * @param spCourseOutcomeId the primary key of the course outcome
	 * @return the course outcome
	 * @throws com.sambaash.platform.srv.NoSuchCourseOutcomeException if a course outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome findByPrimaryKey(long spCourseOutcomeId)
		throws NoSuchCourseOutcomeException, SystemException {
		return findByPrimaryKey((Serializable)spCourseOutcomeId);
	}

	/**
	 * Returns the course outcome with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course outcome
	 * @return the course outcome, or <code>null</code> if a course outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseOutcome courseOutcome = (CourseOutcome)EntityCacheUtil.getResult(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
				CourseOutcomeImpl.class, primaryKey);

		if (courseOutcome == _nullCourseOutcome) {
			return null;
		}

		if (courseOutcome == null) {
			Session session = null;

			try {
				session = openSession();

				courseOutcome = (CourseOutcome)session.get(CourseOutcomeImpl.class,
						primaryKey);

				if (courseOutcome != null) {
					cacheResult(courseOutcome);
				}
				else {
					EntityCacheUtil.putResult(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
						CourseOutcomeImpl.class, primaryKey, _nullCourseOutcome);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseOutcomeModelImpl.ENTITY_CACHE_ENABLED,
					CourseOutcomeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseOutcome;
	}

	/**
	 * Returns the course outcome with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCourseOutcomeId the primary key of the course outcome
	 * @return the course outcome, or <code>null</code> if a course outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseOutcome fetchByPrimaryKey(long spCourseOutcomeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCourseOutcomeId);
	}

	/**
	 * Returns all the course outcomes.
	 *
	 * @return the course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseOutcome> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course outcomes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course outcomes
	 * @param end the upper bound of the range of course outcomes (not inclusive)
	 * @return the range of course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseOutcome> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course outcomes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course outcomes
	 * @param end the upper bound of the range of course outcomes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseOutcome> findAll(int start, int end,
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

		List<CourseOutcome> list = (List<CourseOutcome>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSEOUTCOME);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSEOUTCOME;

				if (pagination) {
					sql = sql.concat(CourseOutcomeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseOutcome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseOutcome>(list);
				}
				else {
					list = (List<CourseOutcome>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the course outcomes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseOutcome courseOutcome : findAll()) {
			remove(courseOutcome);
		}
	}

	/**
	 * Returns the number of course outcomes.
	 *
	 * @return the number of course outcomes
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

				Query q = session.createQuery(_SQL_COUNT_COURSEOUTCOME);

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
	 * Initializes the course outcome persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CourseOutcome")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseOutcome>> listenersList = new ArrayList<ModelListener<CourseOutcome>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseOutcome>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseOutcomeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSEOUTCOME = "SELECT courseOutcome FROM CourseOutcome courseOutcome";
	private static final String _SQL_SELECT_COURSEOUTCOME_WHERE = "SELECT courseOutcome FROM CourseOutcome courseOutcome WHERE ";
	private static final String _SQL_COUNT_COURSEOUTCOME = "SELECT COUNT(courseOutcome) FROM CourseOutcome courseOutcome";
	private static final String _SQL_COUNT_COURSEOUTCOME_WHERE = "SELECT COUNT(courseOutcome) FROM CourseOutcome courseOutcome WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseOutcome.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseOutcome exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseOutcome exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseOutcomePersistenceImpl.class);
	private static CourseOutcome _nullCourseOutcome = new CourseOutcomeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseOutcome> toCacheModel() {
				return _nullCourseOutcomeCacheModel;
			}
		};

	private static CacheModel<CourseOutcome> _nullCourseOutcomeCacheModel = new CacheModel<CourseOutcome>() {
			@Override
			public CourseOutcome toEntityModel() {
				return _nullCourseOutcome;
			}
		};
}