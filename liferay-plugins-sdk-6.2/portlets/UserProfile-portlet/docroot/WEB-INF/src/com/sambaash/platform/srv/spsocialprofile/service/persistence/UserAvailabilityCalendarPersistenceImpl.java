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

package com.sambaash.platform.srv.spsocialprofile.service.persistence;

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

import com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException;
import com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar;
import com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarImpl;
import com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the user availability calendar service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see UserAvailabilityCalendarPersistence
 * @see UserAvailabilityCalendarUtil
 * @generated
 */
public class UserAvailabilityCalendarPersistenceImpl extends BasePersistenceImpl<UserAvailabilityCalendar>
	implements UserAvailabilityCalendarPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserAvailabilityCalendarUtil} to access the user availability calendar persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserAvailabilityCalendarImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
			UserAvailabilityCalendarModelImpl.FINDER_CACHE_ENABLED,
			UserAvailabilityCalendarImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
			UserAvailabilityCalendarModelImpl.FINDER_CACHE_ENABLED,
			UserAvailabilityCalendarImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
			UserAvailabilityCalendarModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDCOMPANYID =
		new FinderPath(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
			UserAvailabilityCalendarModelImpl.FINDER_CACHE_ENABLED,
			UserAvailabilityCalendarImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdAndCompanyId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCOMPANYID =
		new FinderPath(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
			UserAvailabilityCalendarModelImpl.FINDER_CACHE_ENABLED,
			UserAvailabilityCalendarImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndCompanyId",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserAvailabilityCalendarModelImpl.COMPANYID_COLUMN_BITMASK |
			UserAvailabilityCalendarModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID = new FinderPath(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
			UserAvailabilityCalendarModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndCompanyId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user availability calendars where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching user availability calendars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAvailabilityCalendar> findByUserIdAndCompanyId(
		long companyId, long userId) throws SystemException {
		return findByUserIdAndCompanyId(companyId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user availability calendars where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of user availability calendars
	 * @param end the upper bound of the range of user availability calendars (not inclusive)
	 * @return the range of matching user availability calendars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAvailabilityCalendar> findByUserIdAndCompanyId(
		long companyId, long userId, int start, int end)
		throws SystemException {
		return findByUserIdAndCompanyId(companyId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user availability calendars where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of user availability calendars
	 * @param end the upper bound of the range of user availability calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user availability calendars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAvailabilityCalendar> findByUserIdAndCompanyId(
		long companyId, long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCOMPANYID;
			finderArgs = new Object[] { companyId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDCOMPANYID;
			finderArgs = new Object[] {
					companyId, userId,
					
					start, end, orderByComparator
				};
		}

		List<UserAvailabilityCalendar> list = (List<UserAvailabilityCalendar>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserAvailabilityCalendar userAvailabilityCalendar : list) {
				if ((companyId != userAvailabilityCalendar.getCompanyId()) ||
						(userId != userAvailabilityCalendar.getUserId())) {
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

			query.append(_SQL_SELECT_USERAVAILABILITYCALENDAR_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserAvailabilityCalendarModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserAvailabilityCalendar>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserAvailabilityCalendar>(list);
				}
				else {
					list = (List<UserAvailabilityCalendar>)QueryUtil.list(q,
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
	 * Returns the first user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user availability calendar
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a matching user availability calendar could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar findByUserIdAndCompanyId_First(
		long companyId, long userId, OrderByComparator orderByComparator)
		throws NoSuchUserAvailabilityCalendarException, SystemException {
		UserAvailabilityCalendar userAvailabilityCalendar = fetchByUserIdAndCompanyId_First(companyId,
				userId, orderByComparator);

		if (userAvailabilityCalendar != null) {
			return userAvailabilityCalendar;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAvailabilityCalendarException(msg.toString());
	}

	/**
	 * Returns the first user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user availability calendar, or <code>null</code> if a matching user availability calendar could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar fetchByUserIdAndCompanyId_First(
		long companyId, long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<UserAvailabilityCalendar> list = findByUserIdAndCompanyId(companyId,
				userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user availability calendar
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a matching user availability calendar could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar findByUserIdAndCompanyId_Last(
		long companyId, long userId, OrderByComparator orderByComparator)
		throws NoSuchUserAvailabilityCalendarException, SystemException {
		UserAvailabilityCalendar userAvailabilityCalendar = fetchByUserIdAndCompanyId_Last(companyId,
				userId, orderByComparator);

		if (userAvailabilityCalendar != null) {
			return userAvailabilityCalendar;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserAvailabilityCalendarException(msg.toString());
	}

	/**
	 * Returns the last user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user availability calendar, or <code>null</code> if a matching user availability calendar could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar fetchByUserIdAndCompanyId_Last(
		long companyId, long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdAndCompanyId(companyId, userId);

		if (count == 0) {
			return null;
		}

		List<UserAvailabilityCalendar> list = findByUserIdAndCompanyId(companyId,
				userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user availability calendars before and after the current user availability calendar in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param userAvailabilityCalendarId the primary key of the current user availability calendar
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user availability calendar
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a user availability calendar with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar[] findByUserIdAndCompanyId_PrevAndNext(
		long userAvailabilityCalendarId, long companyId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserAvailabilityCalendarException, SystemException {
		UserAvailabilityCalendar userAvailabilityCalendar = findByPrimaryKey(userAvailabilityCalendarId);

		Session session = null;

		try {
			session = openSession();

			UserAvailabilityCalendar[] array = new UserAvailabilityCalendarImpl[3];

			array[0] = getByUserIdAndCompanyId_PrevAndNext(session,
					userAvailabilityCalendar, companyId, userId,
					orderByComparator, true);

			array[1] = userAvailabilityCalendar;

			array[2] = getByUserIdAndCompanyId_PrevAndNext(session,
					userAvailabilityCalendar, companyId, userId,
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

	protected UserAvailabilityCalendar getByUserIdAndCompanyId_PrevAndNext(
		Session session, UserAvailabilityCalendar userAvailabilityCalendar,
		long companyId, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERAVAILABILITYCALENDAR_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2);

		query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2);

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
			query.append(UserAvailabilityCalendarModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userAvailabilityCalendar);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserAvailabilityCalendar> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user availability calendars where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndCompanyId(long companyId, long userId)
		throws SystemException {
		for (UserAvailabilityCalendar userAvailabilityCalendar : findByUserIdAndCompanyId(
				companyId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userAvailabilityCalendar);
		}
	}

	/**
	 * Returns the number of user availability calendars where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching user availability calendars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndCompanyId(long companyId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID;

		Object[] finderArgs = new Object[] { companyId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERAVAILABILITYCALENDAR_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2 = "userAvailabilityCalendar.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2 = "userAvailabilityCalendar.userId = ?";

	public UserAvailabilityCalendarPersistenceImpl() {
		setModelClass(UserAvailabilityCalendar.class);
	}

	/**
	 * Caches the user availability calendar in the entity cache if it is enabled.
	 *
	 * @param userAvailabilityCalendar the user availability calendar
	 */
	@Override
	public void cacheResult(UserAvailabilityCalendar userAvailabilityCalendar) {
		EntityCacheUtil.putResult(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
			UserAvailabilityCalendarImpl.class,
			userAvailabilityCalendar.getPrimaryKey(), userAvailabilityCalendar);

		userAvailabilityCalendar.resetOriginalValues();
	}

	/**
	 * Caches the user availability calendars in the entity cache if it is enabled.
	 *
	 * @param userAvailabilityCalendars the user availability calendars
	 */
	@Override
	public void cacheResult(
		List<UserAvailabilityCalendar> userAvailabilityCalendars) {
		for (UserAvailabilityCalendar userAvailabilityCalendar : userAvailabilityCalendars) {
			if (EntityCacheUtil.getResult(
						UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
						UserAvailabilityCalendarImpl.class,
						userAvailabilityCalendar.getPrimaryKey()) == null) {
				cacheResult(userAvailabilityCalendar);
			}
			else {
				userAvailabilityCalendar.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user availability calendars.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserAvailabilityCalendarImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserAvailabilityCalendarImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user availability calendar.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserAvailabilityCalendar userAvailabilityCalendar) {
		EntityCacheUtil.removeResult(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
			UserAvailabilityCalendarImpl.class,
			userAvailabilityCalendar.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<UserAvailabilityCalendar> userAvailabilityCalendars) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserAvailabilityCalendar userAvailabilityCalendar : userAvailabilityCalendars) {
			EntityCacheUtil.removeResult(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
				UserAvailabilityCalendarImpl.class,
				userAvailabilityCalendar.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user availability calendar with the primary key. Does not add the user availability calendar to the database.
	 *
	 * @param userAvailabilityCalendarId the primary key for the new user availability calendar
	 * @return the new user availability calendar
	 */
	@Override
	public UserAvailabilityCalendar create(long userAvailabilityCalendarId) {
		UserAvailabilityCalendar userAvailabilityCalendar = new UserAvailabilityCalendarImpl();

		userAvailabilityCalendar.setNew(true);
		userAvailabilityCalendar.setPrimaryKey(userAvailabilityCalendarId);

		return userAvailabilityCalendar;
	}

	/**
	 * Removes the user availability calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userAvailabilityCalendarId the primary key of the user availability calendar
	 * @return the user availability calendar that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a user availability calendar with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar remove(long userAvailabilityCalendarId)
		throws NoSuchUserAvailabilityCalendarException, SystemException {
		return remove((Serializable)userAvailabilityCalendarId);
	}

	/**
	 * Removes the user availability calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user availability calendar
	 * @return the user availability calendar that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a user availability calendar with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar remove(Serializable primaryKey)
		throws NoSuchUserAvailabilityCalendarException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserAvailabilityCalendar userAvailabilityCalendar = (UserAvailabilityCalendar)session.get(UserAvailabilityCalendarImpl.class,
					primaryKey);

			if (userAvailabilityCalendar == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserAvailabilityCalendarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userAvailabilityCalendar);
		}
		catch (NoSuchUserAvailabilityCalendarException nsee) {
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
	protected UserAvailabilityCalendar removeImpl(
		UserAvailabilityCalendar userAvailabilityCalendar)
		throws SystemException {
		userAvailabilityCalendar = toUnwrappedModel(userAvailabilityCalendar);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userAvailabilityCalendar)) {
				userAvailabilityCalendar = (UserAvailabilityCalendar)session.get(UserAvailabilityCalendarImpl.class,
						userAvailabilityCalendar.getPrimaryKeyObj());
			}

			if (userAvailabilityCalendar != null) {
				session.delete(userAvailabilityCalendar);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userAvailabilityCalendar != null) {
			clearCache(userAvailabilityCalendar);
		}

		return userAvailabilityCalendar;
	}

	@Override
	public UserAvailabilityCalendar updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar userAvailabilityCalendar)
		throws SystemException {
		userAvailabilityCalendar = toUnwrappedModel(userAvailabilityCalendar);

		boolean isNew = userAvailabilityCalendar.isNew();

		UserAvailabilityCalendarModelImpl userAvailabilityCalendarModelImpl = (UserAvailabilityCalendarModelImpl)userAvailabilityCalendar;

		Session session = null;

		try {
			session = openSession();

			if (userAvailabilityCalendar.isNew()) {
				session.save(userAvailabilityCalendar);

				userAvailabilityCalendar.setNew(false);
			}
			else {
				session.merge(userAvailabilityCalendar);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserAvailabilityCalendarModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userAvailabilityCalendarModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCOMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userAvailabilityCalendarModelImpl.getOriginalCompanyId(),
						userAvailabilityCalendarModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCOMPANYID,
					args);

				args = new Object[] {
						userAvailabilityCalendarModelImpl.getCompanyId(),
						userAvailabilityCalendarModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCOMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
			UserAvailabilityCalendarImpl.class,
			userAvailabilityCalendar.getPrimaryKey(), userAvailabilityCalendar);

		return userAvailabilityCalendar;
	}

	protected UserAvailabilityCalendar toUnwrappedModel(
		UserAvailabilityCalendar userAvailabilityCalendar) {
		if (userAvailabilityCalendar instanceof UserAvailabilityCalendarImpl) {
			return userAvailabilityCalendar;
		}

		UserAvailabilityCalendarImpl userAvailabilityCalendarImpl = new UserAvailabilityCalendarImpl();

		userAvailabilityCalendarImpl.setNew(userAvailabilityCalendar.isNew());
		userAvailabilityCalendarImpl.setPrimaryKey(userAvailabilityCalendar.getPrimaryKey());

		userAvailabilityCalendarImpl.setUserAvailabilityCalendarId(userAvailabilityCalendar.getUserAvailabilityCalendarId());
		userAvailabilityCalendarImpl.setGroupId(userAvailabilityCalendar.getGroupId());
		userAvailabilityCalendarImpl.setCompanyId(userAvailabilityCalendar.getCompanyId());
		userAvailabilityCalendarImpl.setCreateDate(userAvailabilityCalendar.getCreateDate());
		userAvailabilityCalendarImpl.setModifiedDate(userAvailabilityCalendar.getModifiedDate());
		userAvailabilityCalendarImpl.setUserId(userAvailabilityCalendar.getUserId());
		userAvailabilityCalendarImpl.setAvailableFor(userAvailabilityCalendar.getAvailableFor());
		userAvailabilityCalendarImpl.setStartDate(userAvailabilityCalendar.getStartDate());
		userAvailabilityCalendarImpl.setEndDate(userAvailabilityCalendar.getEndDate());
		userAvailabilityCalendarImpl.setActive(userAvailabilityCalendar.isActive());

		return userAvailabilityCalendarImpl;
	}

	/**
	 * Returns the user availability calendar with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user availability calendar
	 * @return the user availability calendar
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a user availability calendar with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserAvailabilityCalendarException, SystemException {
		UserAvailabilityCalendar userAvailabilityCalendar = fetchByPrimaryKey(primaryKey);

		if (userAvailabilityCalendar == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserAvailabilityCalendarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userAvailabilityCalendar;
	}

	/**
	 * Returns the user availability calendar with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException} if it could not be found.
	 *
	 * @param userAvailabilityCalendarId the primary key of the user availability calendar
	 * @return the user availability calendar
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchUserAvailabilityCalendarException if a user availability calendar with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar findByPrimaryKey(
		long userAvailabilityCalendarId)
		throws NoSuchUserAvailabilityCalendarException, SystemException {
		return findByPrimaryKey((Serializable)userAvailabilityCalendarId);
	}

	/**
	 * Returns the user availability calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user availability calendar
	 * @return the user availability calendar, or <code>null</code> if a user availability calendar with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserAvailabilityCalendar userAvailabilityCalendar = (UserAvailabilityCalendar)EntityCacheUtil.getResult(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
				UserAvailabilityCalendarImpl.class, primaryKey);

		if (userAvailabilityCalendar == _nullUserAvailabilityCalendar) {
			return null;
		}

		if (userAvailabilityCalendar == null) {
			Session session = null;

			try {
				session = openSession();

				userAvailabilityCalendar = (UserAvailabilityCalendar)session.get(UserAvailabilityCalendarImpl.class,
						primaryKey);

				if (userAvailabilityCalendar != null) {
					cacheResult(userAvailabilityCalendar);
				}
				else {
					EntityCacheUtil.putResult(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
						UserAvailabilityCalendarImpl.class, primaryKey,
						_nullUserAvailabilityCalendar);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserAvailabilityCalendarModelImpl.ENTITY_CACHE_ENABLED,
					UserAvailabilityCalendarImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userAvailabilityCalendar;
	}

	/**
	 * Returns the user availability calendar with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userAvailabilityCalendarId the primary key of the user availability calendar
	 * @return the user availability calendar, or <code>null</code> if a user availability calendar with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserAvailabilityCalendar fetchByPrimaryKey(
		long userAvailabilityCalendarId) throws SystemException {
		return fetchByPrimaryKey((Serializable)userAvailabilityCalendarId);
	}

	/**
	 * Returns all the user availability calendars.
	 *
	 * @return the user availability calendars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAvailabilityCalendar> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user availability calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user availability calendars
	 * @param end the upper bound of the range of user availability calendars (not inclusive)
	 * @return the range of user availability calendars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAvailabilityCalendar> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user availability calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.UserAvailabilityCalendarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user availability calendars
	 * @param end the upper bound of the range of user availability calendars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user availability calendars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserAvailabilityCalendar> findAll(int start, int end,
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

		List<UserAvailabilityCalendar> list = (List<UserAvailabilityCalendar>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERAVAILABILITYCALENDAR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERAVAILABILITYCALENDAR;

				if (pagination) {
					sql = sql.concat(UserAvailabilityCalendarModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserAvailabilityCalendar>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserAvailabilityCalendar>(list);
				}
				else {
					list = (List<UserAvailabilityCalendar>)QueryUtil.list(q,
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
	 * Removes all the user availability calendars from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserAvailabilityCalendar userAvailabilityCalendar : findAll()) {
			remove(userAvailabilityCalendar);
		}
	}

	/**
	 * Returns the number of user availability calendars.
	 *
	 * @return the number of user availability calendars
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

				Query q = session.createQuery(_SQL_COUNT_USERAVAILABILITYCALENDAR);

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
	 * Initializes the user availability calendar persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserAvailabilityCalendar>> listenersList = new ArrayList<ModelListener<UserAvailabilityCalendar>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserAvailabilityCalendar>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserAvailabilityCalendarImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERAVAILABILITYCALENDAR = "SELECT userAvailabilityCalendar FROM UserAvailabilityCalendar userAvailabilityCalendar";
	private static final String _SQL_SELECT_USERAVAILABILITYCALENDAR_WHERE = "SELECT userAvailabilityCalendar FROM UserAvailabilityCalendar userAvailabilityCalendar WHERE ";
	private static final String _SQL_COUNT_USERAVAILABILITYCALENDAR = "SELECT COUNT(userAvailabilityCalendar) FROM UserAvailabilityCalendar userAvailabilityCalendar";
	private static final String _SQL_COUNT_USERAVAILABILITYCALENDAR_WHERE = "SELECT COUNT(userAvailabilityCalendar) FROM UserAvailabilityCalendar userAvailabilityCalendar WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userAvailabilityCalendar.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserAvailabilityCalendar exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserAvailabilityCalendar exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserAvailabilityCalendarPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"userAvailabilityCalendarId", "active"
			});
	private static UserAvailabilityCalendar _nullUserAvailabilityCalendar = new UserAvailabilityCalendarImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserAvailabilityCalendar> toCacheModel() {
				return _nullUserAvailabilityCalendarCacheModel;
			}
		};

	private static CacheModel<UserAvailabilityCalendar> _nullUserAvailabilityCalendarCacheModel =
		new CacheModel<UserAvailabilityCalendar>() {
			@Override
			public UserAvailabilityCalendar toEntityModel() {
				return _nullUserAvailabilityCalendar;
			}
		};
}