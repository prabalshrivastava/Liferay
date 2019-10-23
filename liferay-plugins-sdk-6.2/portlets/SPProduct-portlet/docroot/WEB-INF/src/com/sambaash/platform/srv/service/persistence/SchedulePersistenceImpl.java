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

import com.sambaash.platform.srv.NoSuchScheduleException;
import com.sambaash.platform.srv.model.Schedule;
import com.sambaash.platform.srv.model.impl.ScheduleImpl;
import com.sambaash.platform.srv.model.impl.ScheduleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SchedulePersistence
 * @see ScheduleUtil
 * @generated
 */
public class SchedulePersistenceImpl extends BasePersistenceImpl<Schedule>
	implements SchedulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScheduleUtil} to access the schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScheduleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, ScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, ScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, ScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, ScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ScheduleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the schedules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Schedule> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of schedules
	 * @param end the upper bound of the range of schedules (not inclusive)
	 * @return the range of matching schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Schedule> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of schedules
	 * @param end the upper bound of the range of schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Schedule> findByGroupId(long groupId, int start, int end,
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

		List<Schedule> list = (List<Schedule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Schedule schedule : list) {
				if ((groupId != schedule.getGroupId())) {
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

			query.append(_SQL_SELECT_SCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScheduleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Schedule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Schedule>(list);
				}
				else {
					list = (List<Schedule>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first schedule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a matching schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchScheduleException, SystemException {
		Schedule schedule = fetchByGroupId_First(groupId, orderByComparator);

		if (schedule != null) {
			return schedule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScheduleException(msg.toString());
	}

	/**
	 * Returns the first schedule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule, or <code>null</code> if a matching schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Schedule> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last schedule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a matching schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchScheduleException, SystemException {
		Schedule schedule = fetchByGroupId_Last(groupId, orderByComparator);

		if (schedule != null) {
			return schedule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScheduleException(msg.toString());
	}

	/**
	 * Returns the last schedule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule, or <code>null</code> if a matching schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Schedule> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the schedules before and after the current schedule in the ordered set where groupId = &#63;.
	 *
	 * @param spScheduleId the primary key of the current schedule
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next schedule
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule[] findByGroupId_PrevAndNext(long spScheduleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchScheduleException, SystemException {
		Schedule schedule = findByPrimaryKey(spScheduleId);

		Session session = null;

		try {
			session = openSession();

			Schedule[] array = new ScheduleImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, schedule, groupId,
					orderByComparator, true);

			array[1] = schedule;

			array[2] = getByGroupId_PrevAndNext(session, schedule, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Schedule getByGroupId_PrevAndNext(Session session,
		Schedule schedule, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCHEDULE_WHERE);

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
			query.append(ScheduleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(schedule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Schedule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the schedules where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Schedule schedule : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(schedule);
		}
	}

	/**
	 * Returns the number of schedules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching schedules
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

			query.append(_SQL_COUNT_SCHEDULE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "schedule.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDMODULEID =
		new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, ScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndModuleId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID =
		new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, ScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndModuleId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ScheduleModelImpl.GROUPID_COLUMN_BITMASK |
			ScheduleModelImpl.SPMODULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDMODULEID = new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndModuleId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the schedules where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @return the matching schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Schedule> findByGroupIdAndModuleId(long groupId, long spModuleId)
		throws SystemException {
		return findByGroupIdAndModuleId(groupId, spModuleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedules where groupId = &#63; and spModuleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param start the lower bound of the range of schedules
	 * @param end the upper bound of the range of schedules (not inclusive)
	 * @return the range of matching schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Schedule> findByGroupIdAndModuleId(long groupId,
		long spModuleId, int start, int end) throws SystemException {
		return findByGroupIdAndModuleId(groupId, spModuleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedules where groupId = &#63; and spModuleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param start the lower bound of the range of schedules
	 * @param end the upper bound of the range of schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Schedule> findByGroupIdAndModuleId(long groupId,
		long spModuleId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID;
			finderArgs = new Object[] { groupId, spModuleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDMODULEID;
			finderArgs = new Object[] {
					groupId, spModuleId,
					
					start, end, orderByComparator
				};
		}

		List<Schedule> list = (List<Schedule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Schedule schedule : list) {
				if ((groupId != schedule.getGroupId()) ||
						(spModuleId != schedule.getSpModuleId())) {
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

			query.append(_SQL_SELECT_SCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_SPMODULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScheduleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spModuleId);

				if (!pagination) {
					list = (List<Schedule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Schedule>(list);
				}
				else {
					list = (List<Schedule>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a matching schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule findByGroupIdAndModuleId_First(long groupId,
		long spModuleId, OrderByComparator orderByComparator)
		throws NoSuchScheduleException, SystemException {
		Schedule schedule = fetchByGroupIdAndModuleId_First(groupId,
				spModuleId, orderByComparator);

		if (schedule != null) {
			return schedule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spModuleId=");
		msg.append(spModuleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScheduleException(msg.toString());
	}

	/**
	 * Returns the first schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule, or <code>null</code> if a matching schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule fetchByGroupIdAndModuleId_First(long groupId,
		long spModuleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Schedule> list = findByGroupIdAndModuleId(groupId, spModuleId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a matching schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule findByGroupIdAndModuleId_Last(long groupId,
		long spModuleId, OrderByComparator orderByComparator)
		throws NoSuchScheduleException, SystemException {
		Schedule schedule = fetchByGroupIdAndModuleId_Last(groupId, spModuleId,
				orderByComparator);

		if (schedule != null) {
			return schedule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spModuleId=");
		msg.append(spModuleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScheduleException(msg.toString());
	}

	/**
	 * Returns the last schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule, or <code>null</code> if a matching schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule fetchByGroupIdAndModuleId_Last(long groupId,
		long spModuleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdAndModuleId(groupId, spModuleId);

		if (count == 0) {
			return null;
		}

		List<Schedule> list = findByGroupIdAndModuleId(groupId, spModuleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the schedules before and after the current schedule in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param spScheduleId the primary key of the current schedule
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next schedule
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule[] findByGroupIdAndModuleId_PrevAndNext(long spScheduleId,
		long groupId, long spModuleId, OrderByComparator orderByComparator)
		throws NoSuchScheduleException, SystemException {
		Schedule schedule = findByPrimaryKey(spScheduleId);

		Session session = null;

		try {
			session = openSession();

			Schedule[] array = new ScheduleImpl[3];

			array[0] = getByGroupIdAndModuleId_PrevAndNext(session, schedule,
					groupId, spModuleId, orderByComparator, true);

			array[1] = schedule;

			array[2] = getByGroupIdAndModuleId_PrevAndNext(session, schedule,
					groupId, spModuleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Schedule getByGroupIdAndModuleId_PrevAndNext(Session session,
		Schedule schedule, long groupId, long spModuleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCHEDULE_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_SPMODULEID_2);

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
			query.append(ScheduleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(spModuleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(schedule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Schedule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the schedules where groupId = &#63; and spModuleId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdAndModuleId(long groupId, long spModuleId)
		throws SystemException {
		for (Schedule schedule : findByGroupIdAndModuleId(groupId, spModuleId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(schedule);
		}
	}

	/**
	 * Returns the number of schedules where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @return the number of matching schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdAndModuleId(long groupId, long spModuleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDMODULEID;

		Object[] finderArgs = new Object[] { groupId, spModuleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_SPMODULEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spModuleId);

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

	private static final String _FINDER_COLUMN_GROUPIDANDMODULEID_GROUPID_2 = "schedule.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDMODULEID_SPMODULEID_2 = "schedule.spModuleId = ?";

	public SchedulePersistenceImpl() {
		setModelClass(Schedule.class);
	}

	/**
	 * Caches the schedule in the entity cache if it is enabled.
	 *
	 * @param schedule the schedule
	 */
	@Override
	public void cacheResult(Schedule schedule) {
		EntityCacheUtil.putResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleImpl.class, schedule.getPrimaryKey(), schedule);

		schedule.resetOriginalValues();
	}

	/**
	 * Caches the schedules in the entity cache if it is enabled.
	 *
	 * @param schedules the schedules
	 */
	@Override
	public void cacheResult(List<Schedule> schedules) {
		for (Schedule schedule : schedules) {
			if (EntityCacheUtil.getResult(
						ScheduleModelImpl.ENTITY_CACHE_ENABLED,
						ScheduleImpl.class, schedule.getPrimaryKey()) == null) {
				cacheResult(schedule);
			}
			else {
				schedule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all schedules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScheduleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScheduleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the schedule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Schedule schedule) {
		EntityCacheUtil.removeResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleImpl.class, schedule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Schedule> schedules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Schedule schedule : schedules) {
			EntityCacheUtil.removeResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
				ScheduleImpl.class, schedule.getPrimaryKey());
		}
	}

	/**
	 * Creates a new schedule with the primary key. Does not add the schedule to the database.
	 *
	 * @param spScheduleId the primary key for the new schedule
	 * @return the new schedule
	 */
	@Override
	public Schedule create(long spScheduleId) {
		Schedule schedule = new ScheduleImpl();

		schedule.setNew(true);
		schedule.setPrimaryKey(spScheduleId);

		return schedule;
	}

	/**
	 * Removes the schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spScheduleId the primary key of the schedule
	 * @return the schedule that was removed
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule remove(long spScheduleId)
		throws NoSuchScheduleException, SystemException {
		return remove((Serializable)spScheduleId);
	}

	/**
	 * Removes the schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the schedule
	 * @return the schedule that was removed
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule remove(Serializable primaryKey)
		throws NoSuchScheduleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Schedule schedule = (Schedule)session.get(ScheduleImpl.class,
					primaryKey);

			if (schedule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(schedule);
		}
		catch (NoSuchScheduleException nsee) {
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
	protected Schedule removeImpl(Schedule schedule) throws SystemException {
		schedule = toUnwrappedModel(schedule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(schedule)) {
				schedule = (Schedule)session.get(ScheduleImpl.class,
						schedule.getPrimaryKeyObj());
			}

			if (schedule != null) {
				session.delete(schedule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (schedule != null) {
			clearCache(schedule);
		}

		return schedule;
	}

	@Override
	public Schedule updateImpl(
		com.sambaash.platform.srv.model.Schedule schedule)
		throws SystemException {
		schedule = toUnwrappedModel(schedule);

		boolean isNew = schedule.isNew();

		ScheduleModelImpl scheduleModelImpl = (ScheduleModelImpl)schedule;

		Session session = null;

		try {
			session = openSession();

			if (schedule.isNew()) {
				session.save(schedule);

				schedule.setNew(false);
			}
			else {
				session.merge(schedule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScheduleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scheduleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scheduleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { scheduleModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((scheduleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scheduleModelImpl.getOriginalGroupId(),
						scheduleModelImpl.getOriginalSpModuleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDMODULEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID,
					args);

				args = new Object[] {
						scheduleModelImpl.getGroupId(),
						scheduleModelImpl.getSpModuleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDMODULEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleImpl.class, schedule.getPrimaryKey(), schedule);

		return schedule;
	}

	protected Schedule toUnwrappedModel(Schedule schedule) {
		if (schedule instanceof ScheduleImpl) {
			return schedule;
		}

		ScheduleImpl scheduleImpl = new ScheduleImpl();

		scheduleImpl.setNew(schedule.isNew());
		scheduleImpl.setPrimaryKey(schedule.getPrimaryKey());

		scheduleImpl.setSpScheduleId(schedule.getSpScheduleId());
		scheduleImpl.setGroupId(schedule.getGroupId());
		scheduleImpl.setCompanyId(schedule.getCompanyId());
		scheduleImpl.setUserId(schedule.getUserId());
		scheduleImpl.setUserName(schedule.getUserName());
		scheduleImpl.setCreateDate(schedule.getCreateDate());
		scheduleImpl.setModifiedDate(schedule.getModifiedDate());
		scheduleImpl.setSpModuleId(schedule.getSpModuleId());
		scheduleImpl.setSessionNumber(schedule.getSessionNumber());
		scheduleImpl.setDescription(schedule.getDescription());
		scheduleImpl.setSessionType(schedule.getSessionType());
		scheduleImpl.setSessionDuration(schedule.getSessionDuration());

		return scheduleImpl;
	}

	/**
	 * Returns the schedule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedule
	 * @return the schedule
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScheduleException, SystemException {
		Schedule schedule = fetchByPrimaryKey(primaryKey);

		if (schedule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return schedule;
	}

	/**
	 * Returns the schedule with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchScheduleException} if it could not be found.
	 *
	 * @param spScheduleId the primary key of the schedule
	 * @return the schedule
	 * @throws com.sambaash.platform.srv.NoSuchScheduleException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule findByPrimaryKey(long spScheduleId)
		throws NoSuchScheduleException, SystemException {
		return findByPrimaryKey((Serializable)spScheduleId);
	}

	/**
	 * Returns the schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedule
	 * @return the schedule, or <code>null</code> if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Schedule schedule = (Schedule)EntityCacheUtil.getResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
				ScheduleImpl.class, primaryKey);

		if (schedule == _nullSchedule) {
			return null;
		}

		if (schedule == null) {
			Session session = null;

			try {
				session = openSession();

				schedule = (Schedule)session.get(ScheduleImpl.class, primaryKey);

				if (schedule != null) {
					cacheResult(schedule);
				}
				else {
					EntityCacheUtil.putResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
						ScheduleImpl.class, primaryKey, _nullSchedule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
					ScheduleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return schedule;
	}

	/**
	 * Returns the schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spScheduleId the primary key of the schedule
	 * @return the schedule, or <code>null</code> if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule fetchByPrimaryKey(long spScheduleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spScheduleId);
	}

	/**
	 * Returns all the schedules.
	 *
	 * @return the schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Schedule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules
	 * @param end the upper bound of the range of schedules (not inclusive)
	 * @return the range of schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Schedule> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules
	 * @param end the upper bound of the range of schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Schedule> findAll(int start, int end,
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

		List<Schedule> list = (List<Schedule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCHEDULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCHEDULE;

				if (pagination) {
					sql = sql.concat(ScheduleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Schedule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Schedule>(list);
				}
				else {
					list = (List<Schedule>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the schedules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Schedule schedule : findAll()) {
			remove(schedule);
		}
	}

	/**
	 * Returns the number of schedules.
	 *
	 * @return the number of schedules
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

				Query q = session.createQuery(_SQL_COUNT_SCHEDULE);

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
	 * Initializes the schedule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Schedule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Schedule>> listenersList = new ArrayList<ModelListener<Schedule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Schedule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScheduleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCHEDULE = "SELECT schedule FROM Schedule schedule";
	private static final String _SQL_SELECT_SCHEDULE_WHERE = "SELECT schedule FROM Schedule schedule WHERE ";
	private static final String _SQL_COUNT_SCHEDULE = "SELECT COUNT(schedule) FROM Schedule schedule";
	private static final String _SQL_COUNT_SCHEDULE_WHERE = "SELECT COUNT(schedule) FROM Schedule schedule WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "schedule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Schedule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Schedule exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SchedulePersistenceImpl.class);
	private static Schedule _nullSchedule = new ScheduleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Schedule> toCacheModel() {
				return _nullScheduleCacheModel;
			}
		};

	private static CacheModel<Schedule> _nullScheduleCacheModel = new CacheModel<Schedule>() {
			@Override
			public Schedule toEntityModel() {
				return _nullSchedule;
			}
		};
}