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

package com.sambaash.platform.srv.sharing.service.persistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import com.sambaash.platform.srv.sharing.NoSuchSPSharingException;
import com.sambaash.platform.srv.sharing.model.SPSharing;
import com.sambaash.platform.srv.sharing.model.impl.SPSharingImpl;
import com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the s p sharing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPSharingPersistence
 * @see SPSharingUtil
 * @generated
 */
public class SPSharingPersistenceImpl extends BasePersistenceImpl<SPSharing>
	implements SPSharingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPSharingUtil} to access the s p sharing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPSharingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserIdClassNameIdAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPSharingModelImpl.USERID_COLUMN_BITMASK |
			SPSharingModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			SPSharingModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDANDCLASSPK =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdClassNameIdAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; or throws a {@link com.sambaash.platform.srv.sharing.NoSuchSPSharingException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByUserIdClassNameIdAndClassPK(long userId,
		long classNameId, long classPK)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByUserIdClassNameIdAndClassPK(userId,
				classNameId, classPK);

		if (spSharing == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPSharingException(msg.toString());
		}

		return spSharing;
	}

	/**
	 * Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByUserIdClassNameIdAndClassPK(long userId,
		long classNameId, long classPK) throws SystemException {
		return fetchByUserIdClassNameIdAndClassPK(userId, classNameId, classPK,
			true);
	}

	/**
	 * Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByUserIdClassNameIdAndClassPK(long userId,
		long classNameId, long classPK, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, classNameId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK,
					finderArgs, this);
		}

		if (result instanceof SPSharing) {
			SPSharing spSharing = (SPSharing)result;

			if ((userId != spSharing.getUserId()) ||
					(classNameId != spSharing.getClassNameId()) ||
					(classPK != spSharing.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDANDCLASSPK_USERID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDANDCLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDANDCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(classNameId);

				qPos.add(classPK);

				List<SPSharing> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPSharingPersistenceImpl.fetchByUserIdClassNameIdAndClassPK(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPSharing spSharing = list.get(0);

					result = spSharing;

					cacheResult(spSharing);

					if ((spSharing.getUserId() != userId) ||
							(spSharing.getClassNameId() != classNameId) ||
							(spSharing.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK,
							finderArgs, spSharing);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK,
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
			return (SPSharing)result;
		}
	}

	/**
	 * Removes the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the s p sharing that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing removeByUserIdClassNameIdAndClassPK(long userId,
		long classNameId, long classPK)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = findByUserIdClassNameIdAndClassPK(userId,
				classNameId, classPK);

		return remove(spSharing);
	}

	/**
	 * Returns the number of s p sharings where userId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdClassNameIdAndClassPK(long userId,
		long classNameId, long classPK) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDANDCLASSPK;

		Object[] finderArgs = new Object[] { userId, classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDANDCLASSPK_USERID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDANDCLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDANDCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(classNameId);

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDANDCLASSPK_USERID_2 =
		"spSharing.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDANDCLASSPK_CLASSNAMEID_2 =
		"spSharing.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDANDCLASSPK_CLASSPK_2 =
		"spSharing.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDDATESEXPIRED =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdDatesExpired",
			new String[] {
				Long.class.getName(), Date.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDDATESEXPIRED =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByUserIdDatesExpired",
			new String[] {
				Long.class.getName(), Date.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByUserIdDatesExpired(long userId,
		Date startDate, Date endDate) throws SystemException {
		return findByUserIdDatesExpired(userId, startDate, endDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @return the range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByUserIdDatesExpired(long userId,
		Date startDate, Date endDate, int start, int end)
		throws SystemException {
		return findByUserIdDatesExpired(userId, startDate, endDate, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByUserIdDatesExpired(long userId,
		Date startDate, Date endDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDDATESEXPIRED;
		finderArgs = new Object[] {
				userId, startDate, endDate,
				
				start, end, orderByComparator
			};

		List<SPSharing> list = (List<SPSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSharing spSharing : list) {
				if ((userId != spSharing.getUserId()) ||
						(startDate.getTime() <= spSharing.getStartDate()
															 .getTime()) ||
						(endDate.getTime() >= spSharing.getEndDate().getTime())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_USERID_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSharingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				if (!pagination) {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSharing>(list);
				}
				else {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByUserIdDatesExpired_First(long userId,
		Date startDate, Date endDate, OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByUserIdDatesExpired_First(userId,
				startDate, endDate, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the first s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByUserIdDatesExpired_First(long userId,
		Date startDate, Date endDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPSharing> list = findByUserIdDatesExpired(userId, startDate,
				endDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByUserIdDatesExpired_Last(long userId, Date startDate,
		Date endDate, OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByUserIdDatesExpired_Last(userId, startDate,
				endDate, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the last s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByUserIdDatesExpired_Last(long userId,
		Date startDate, Date endDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdDatesExpired(userId, startDate, endDate);

		if (count == 0) {
			return null;
		}

		List<SPSharing> list = findByUserIdDatesExpired(userId, startDate,
				endDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sharings before and after the current s p sharing in the ordered set where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param spSharingId the primary key of the current s p sharing
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing[] findByUserIdDatesExpired_PrevAndNext(long spSharingId,
		long userId, Date startDate, Date endDate,
		OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = findByPrimaryKey(spSharingId);

		Session session = null;

		try {
			session = openSession();

			SPSharing[] array = new SPSharingImpl[3];

			array[0] = getByUserIdDatesExpired_PrevAndNext(session, spSharing,
					userId, startDate, endDate, orderByComparator, true);

			array[1] = spSharing;

			array[2] = getByUserIdDatesExpired_PrevAndNext(session, spSharing,
					userId, startDate, endDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSharing getByUserIdDatesExpired_PrevAndNext(Session session,
		SPSharing spSharing, long userId, Date startDate, Date endDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSHARING_WHERE);

		query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_USERID_2);

		boolean bindStartDate = false;

		if (startDate == null) {
			query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_STARTDATE_2);
		}

		boolean bindEndDate = false;

		if (endDate == null) {
			query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_ENDDATE_2);
		}

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
			query.append(SPSharingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindStartDate) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		if (bindEndDate) {
			qPos.add(CalendarUtil.getTimestamp(endDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdDatesExpired(long userId, Date startDate,
		Date endDate) throws SystemException {
		for (SPSharing spSharing : findByUserIdDatesExpired(userId, startDate,
				endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSharing);
		}
	}

	/**
	 * Returns the number of s p sharings where userId = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdDatesExpired(long userId, Date startDate,
		Date endDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDDATESEXPIRED;

		Object[] finderArgs = new Object[] { userId, startDate, endDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_USERID_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_USERIDDATESEXPIRED_ENDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
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

	private static final String _FINDER_COLUMN_USERIDDATESEXPIRED_USERID_2 = "spSharing.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDDATESEXPIRED_STARTDATE_1 = "spSharing.startDate < NULL AND ";
	private static final String _FINDER_COLUMN_USERIDDATESEXPIRED_STARTDATE_2 = "spSharing.startDate < ? AND ";
	private static final String _FINDER_COLUMN_USERIDDATESEXPIRED_ENDDATE_1 = "spSharing.endDate > NULL AND  spSharing.expired = 0 ";
	private static final String _FINDER_COLUMN_USERIDDATESEXPIRED_ENDDATE_2 = "spSharing.endDate > ? AND  spSharing.expired = 0 ";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBYDATESEXPIRED =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreatedByDatesExpired",
			new String[] {
				Long.class.getName(), Date.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CREATEDBYDATESEXPIRED =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByCreatedByDatesExpired",
			new String[] {
				Long.class.getName(), Date.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByCreatedByDatesExpired(long createdBy,
		Date startDate, Date endDate) throws SystemException {
		return findByCreatedByDatesExpired(createdBy, startDate, endDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @return the range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByCreatedByDatesExpired(long createdBy,
		Date startDate, Date endDate, int start, int end)
		throws SystemException {
		return findByCreatedByDatesExpired(createdBy, startDate, endDate,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByCreatedByDatesExpired(long createdBy,
		Date startDate, Date endDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBYDATESEXPIRED;
		finderArgs = new Object[] {
				createdBy, startDate, endDate,
				
				start, end, orderByComparator
			};

		List<SPSharing> list = (List<SPSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSharing spSharing : list) {
				if ((createdBy != spSharing.getCreatedBy()) ||
						(startDate.getTime() <= spSharing.getStartDate()
															 .getTime()) ||
						(endDate.getTime() >= spSharing.getEndDate().getTime())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_CREATEDBY_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSharingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				if (!pagination) {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSharing>(list);
				}
				else {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByCreatedByDatesExpired_First(long createdBy,
		Date startDate, Date endDate, OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByCreatedByDatesExpired_First(createdBy,
				startDate, endDate, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the first s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByCreatedByDatesExpired_First(long createdBy,
		Date startDate, Date endDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPSharing> list = findByCreatedByDatesExpired(createdBy,
				startDate, endDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByCreatedByDatesExpired_Last(long createdBy,
		Date startDate, Date endDate, OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByCreatedByDatesExpired_Last(createdBy,
				startDate, endDate, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the last s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByCreatedByDatesExpired_Last(long createdBy,
		Date startDate, Date endDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCreatedByDatesExpired(createdBy, startDate, endDate);

		if (count == 0) {
			return null;
		}

		List<SPSharing> list = findByCreatedByDatesExpired(createdBy,
				startDate, endDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sharings before and after the current s p sharing in the ordered set where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param spSharingId the primary key of the current s p sharing
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing[] findByCreatedByDatesExpired_PrevAndNext(
		long spSharingId, long createdBy, Date startDate, Date endDate,
		OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = findByPrimaryKey(spSharingId);

		Session session = null;

		try {
			session = openSession();

			SPSharing[] array = new SPSharingImpl[3];

			array[0] = getByCreatedByDatesExpired_PrevAndNext(session,
					spSharing, createdBy, startDate, endDate,
					orderByComparator, true);

			array[1] = spSharing;

			array[2] = getByCreatedByDatesExpired_PrevAndNext(session,
					spSharing, createdBy, startDate, endDate,
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

	protected SPSharing getByCreatedByDatesExpired_PrevAndNext(
		Session session, SPSharing spSharing, long createdBy, Date startDate,
		Date endDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSHARING_WHERE);

		query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_CREATEDBY_2);

		boolean bindStartDate = false;

		if (startDate == null) {
			query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_STARTDATE_2);
		}

		boolean bindEndDate = false;

		if (endDate == null) {
			query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_ENDDATE_2);
		}

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
			query.append(SPSharingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(createdBy);

		if (bindStartDate) {
			qPos.add(CalendarUtil.getTimestamp(startDate));
		}

		if (bindEndDate) {
			qPos.add(CalendarUtil.getTimestamp(endDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreatedByDatesExpired(long createdBy, Date startDate,
		Date endDate) throws SystemException {
		for (SPSharing spSharing : findByCreatedByDatesExpired(createdBy,
				startDate, endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSharing);
		}
	}

	/**
	 * Returns the number of s p sharings where createdBy = &#63; and startDate &lt; &#63; and endDate &gt; &#63;.
	 *
	 * @param createdBy the created by
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the number of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreatedByDatesExpired(long createdBy, Date startDate,
		Date endDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_CREATEDBYDATESEXPIRED;

		Object[] finderArgs = new Object[] { createdBy, startDate, endDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_CREATEDBY_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_CREATEDBYDATESEXPIRED_ENDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				if (bindStartDate) {
					qPos.add(CalendarUtil.getTimestamp(startDate));
				}

				if (bindEndDate) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
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

	private static final String _FINDER_COLUMN_CREATEDBYDATESEXPIRED_CREATEDBY_2 =
		"spSharing.createdBy = ? AND ";
	private static final String _FINDER_COLUMN_CREATEDBYDATESEXPIRED_STARTDATE_1 =
		"spSharing.startDate < NULL AND ";
	private static final String _FINDER_COLUMN_CREATEDBYDATESEXPIRED_STARTDATE_2 =
		"spSharing.startDate < ? AND ";
	private static final String _FINDER_COLUMN_CREATEDBYDATESEXPIRED_ENDDATE_1 = "spSharing.endDate > NULL AND  spSharing.expired = 0 ";
	private static final String _FINDER_COLUMN_CREATEDBYDATESEXPIRED_ENDDATE_2 = "spSharing.endDate > ? AND  spSharing.expired = 0 ";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdClassNameIdClassPKAndShareType",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			SPSharingModelImpl.USERID_COLUMN_BITMASK |
			SPSharingModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			SPSharingModelImpl.CLASSPK_COLUMN_BITMASK |
			SPSharingModelImpl.INTERNALSHARE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdClassNameIdClassPKAndShareType",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or throws a {@link com.sambaash.platform.srv.sharing.NoSuchSPSharingException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @return the matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByUserIdClassNameIdClassPKAndShareType(long userId,
		long classNameId, long classPK, boolean internalShare)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByUserIdClassNameIdClassPKAndShareType(userId,
				classNameId, classPK, internalShare);

		if (spSharing == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(", internalShare=");
			msg.append(internalShare);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPSharingException(msg.toString());
		}

		return spSharing;
	}

	/**
	 * Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByUserIdClassNameIdClassPKAndShareType(long userId,
		long classNameId, long classPK, boolean internalShare)
		throws SystemException {
		return fetchByUserIdClassNameIdClassPKAndShareType(userId, classNameId,
			classPK, internalShare, true);
	}

	/**
	 * Returns the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByUserIdClassNameIdClassPKAndShareType(long userId,
		long classNameId, long classPK, boolean internalShare,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				userId, classNameId, classPK, internalShare
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
					finderArgs, this);
		}

		if (result instanceof SPSharing) {
			SPSharing spSharing = (SPSharing)result;

			if ((userId != spSharing.getUserId()) ||
					(classNameId != spSharing.getClassNameId()) ||
					(classPK != spSharing.getClassPK()) ||
					(internalShare != spSharing.getInternalShare())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_USERID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSPK_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_INTERNALSHARE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(internalShare);

				List<SPSharing> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPSharingPersistenceImpl.fetchByUserIdClassNameIdClassPKAndShareType(long, long, long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPSharing spSharing = list.get(0);

					result = spSharing;

					cacheResult(spSharing);

					if ((spSharing.getUserId() != userId) ||
							(spSharing.getClassNameId() != classNameId) ||
							(spSharing.getClassPK() != classPK) ||
							(spSharing.getInternalShare() != internalShare)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
							finderArgs, spSharing);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
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
			return (SPSharing)result;
		}
	}

	/**
	 * Removes the s p sharing where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @return the s p sharing that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing removeByUserIdClassNameIdClassPKAndShareType(long userId,
		long classNameId, long classPK, boolean internalShare)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = findByUserIdClassNameIdClassPKAndShareType(userId,
				classNameId, classPK, internalShare);

		return remove(spSharing);
	}

	/**
	 * Returns the number of s p sharings where userId = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63;.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @return the number of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdClassNameIdClassPKAndShareType(long userId,
		long classNameId, long classPK, boolean internalShare)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE;

		Object[] finderArgs = new Object[] {
				userId, classNameId, classPK, internalShare
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_USERID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSPK_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_INTERNALSHARE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(internalShare);

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

	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_USERID_2 =
		"spSharing.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSNAMEID_2 =
		"spSharing.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSPK_2 =
		"spSharing.classPK = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE_INTERNALSHARE_2 =
		"spSharing.internalShare = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByEmailClassNameIdClassPKAndShareType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			},
			SPSharingModelImpl.EMAILADDRESS_COLUMN_BITMASK |
			SPSharingModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			SPSharingModelImpl.CLASSPK_COLUMN_BITMASK |
			SPSharingModelImpl.INTERNALSHARE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailClassNameIdClassPKAndShareType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});

	/**
	 * Returns the s p sharing where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or throws a {@link com.sambaash.platform.srv.sharing.NoSuchSPSharingException} if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @return the matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByEmailClassNameIdClassPKAndShareType(
		String emailAddress, long classNameId, long classPK,
		boolean internalShare) throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByEmailClassNameIdClassPKAndShareType(emailAddress,
				classNameId, classPK, internalShare);

		if (spSharing == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailAddress=");
			msg.append(emailAddress);

			msg.append(", classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(", internalShare=");
			msg.append(internalShare);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPSharingException(msg.toString());
		}

		return spSharing;
	}

	/**
	 * Returns the s p sharing where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByEmailClassNameIdClassPKAndShareType(
		String emailAddress, long classNameId, long classPK,
		boolean internalShare) throws SystemException {
		return fetchByEmailClassNameIdClassPKAndShareType(emailAddress,
			classNameId, classPK, internalShare, true);
	}

	/**
	 * Returns the s p sharing where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByEmailClassNameIdClassPKAndShareType(
		String emailAddress, long classNameId, long classPK,
		boolean internalShare, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				emailAddress, classNameId, classPK, internalShare
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
					finderArgs, this);
		}

		if (result instanceof SPSharing) {
			SPSharing spSharing = (SPSharing)result;

			if (!Validator.equals(emailAddress, spSharing.getEmailAddress()) ||
					(classNameId != spSharing.getClassNameId()) ||
					(classPK != spSharing.getClassPK()) ||
					(internalShare != spSharing.getInternalShare())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_SPSHARING_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_EMAILADDRESS_2);
			}

			query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSPK_2);

			query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_INTERNALSHARE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(internalShare);

				List<SPSharing> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPSharingPersistenceImpl.fetchByEmailClassNameIdClassPKAndShareType(String, long, long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPSharing spSharing = list.get(0);

					result = spSharing;

					cacheResult(spSharing);

					if ((spSharing.getEmailAddress() == null) ||
							!spSharing.getEmailAddress().equals(emailAddress) ||
							(spSharing.getClassNameId() != classNameId) ||
							(spSharing.getClassPK() != classPK) ||
							(spSharing.getInternalShare() != internalShare)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
							finderArgs, spSharing);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
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
			return (SPSharing)result;
		}
	}

	/**
	 * Removes the s p sharing where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @return the s p sharing that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing removeByEmailClassNameIdClassPKAndShareType(
		String emailAddress, long classNameId, long classPK,
		boolean internalShare) throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = findByEmailClassNameIdClassPKAndShareType(emailAddress,
				classNameId, classPK, internalShare);

		return remove(spSharing);
	}

	/**
	 * Returns the number of s p sharings where emailAddress = &#63; and classNameId = &#63; and classPK = &#63; and internalShare = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param internalShare the internal share
	 * @return the number of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailClassNameIdClassPKAndShareType(String emailAddress,
		long classNameId, long classPK, boolean internalShare)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE;

		Object[] finderArgs = new Object[] {
				emailAddress, classNameId, classPK, internalShare
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SPSHARING_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_EMAILADDRESS_2);
			}

			query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSPK_2);

			query.append(_FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_INTERNALSHARE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(internalShare);

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

	private static final String _FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_EMAILADDRESS_1 =
		"spSharing.emailAddress IS NULL AND ";
	private static final String _FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_EMAILADDRESS_2 =
		"spSharing.emailAddress = ? AND ";
	private static final String _FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_EMAILADDRESS_3 =
		"(spSharing.emailAddress IS NULL OR spSharing.emailAddress = '') AND ";
	private static final String _FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSNAMEID_2 =
		"spSharing.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_CLASSPK_2 =
		"spSharing.classPK = ? AND ";
	private static final String _FINDER_COLUMN_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE_INTERNALSHARE_2 =
		"spSharing.internalShare = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSPKANDCLASSNAMEID =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByClassPKAndClassNameId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSPKANDCLASSNAMEID =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByClassPKAndClassNameId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPSharingModelImpl.CLASSPK_COLUMN_BITMASK |
			SPSharingModelImpl.CLASSNAMEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSPKANDCLASSNAMEID = new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassPKAndClassNameId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p sharings where classPK = &#63; and classNameId = &#63;.
	 *
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @return the matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByClassPKAndClassNameId(long classPK,
		long classNameId) throws SystemException {
		return findByClassPKAndClassNameId(classPK, classNameId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sharings where classPK = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @return the range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByClassPKAndClassNameId(long classPK,
		long classNameId, int start, int end) throws SystemException {
		return findByClassPKAndClassNameId(classPK, classNameId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p sharings where classPK = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByClassPKAndClassNameId(long classPK,
		long classNameId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSPKANDCLASSNAMEID;
			finderArgs = new Object[] { classPK, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSPKANDCLASSNAMEID;
			finderArgs = new Object[] {
					classPK, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<SPSharing> list = (List<SPSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSharing spSharing : list) {
				if ((classPK != spSharing.getClassPK()) ||
						(classNameId != spSharing.getClassNameId())) {
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

			query.append(_SQL_SELECT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_CLASSPKANDCLASSNAMEID_CLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSPKANDCLASSNAMEID_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSharingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classPK);

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSharing>(list);
				}
				else {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	 *
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByClassPKAndClassNameId_First(long classPK,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByClassPKAndClassNameId_First(classPK,
				classNameId, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classPK=");
		msg.append(classPK);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the first s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	 *
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByClassPKAndClassNameId_First(long classPK,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPSharing> list = findByClassPKAndClassNameId(classPK,
				classNameId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	 *
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByClassPKAndClassNameId_Last(long classPK,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByClassPKAndClassNameId_Last(classPK,
				classNameId, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classPK=");
		msg.append(classPK);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the last s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	 *
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByClassPKAndClassNameId_Last(long classPK,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByClassPKAndClassNameId(classPK, classNameId);

		if (count == 0) {
			return null;
		}

		List<SPSharing> list = findByClassPKAndClassNameId(classPK,
				classNameId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sharings before and after the current s p sharing in the ordered set where classPK = &#63; and classNameId = &#63;.
	 *
	 * @param spSharingId the primary key of the current s p sharing
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing[] findByClassPKAndClassNameId_PrevAndNext(
		long spSharingId, long classPK, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = findByPrimaryKey(spSharingId);

		Session session = null;

		try {
			session = openSession();

			SPSharing[] array = new SPSharingImpl[3];

			array[0] = getByClassPKAndClassNameId_PrevAndNext(session,
					spSharing, classPK, classNameId, orderByComparator, true);

			array[1] = spSharing;

			array[2] = getByClassPKAndClassNameId_PrevAndNext(session,
					spSharing, classPK, classNameId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSharing getByClassPKAndClassNameId_PrevAndNext(
		Session session, SPSharing spSharing, long classPK, long classNameId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSHARING_WHERE);

		query.append(_FINDER_COLUMN_CLASSPKANDCLASSNAMEID_CLASSPK_2);

		query.append(_FINDER_COLUMN_CLASSPKANDCLASSNAMEID_CLASSNAMEID_2);

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
			query.append(SPSharingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(classPK);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sharings where classPK = &#63; and classNameId = &#63; from the database.
	 *
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassPKAndClassNameId(long classPK, long classNameId)
		throws SystemException {
		for (SPSharing spSharing : findByClassPKAndClassNameId(classPK,
				classNameId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSharing);
		}
	}

	/**
	 * Returns the number of s p sharings where classPK = &#63; and classNameId = &#63;.
	 *
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @return the number of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassPKAndClassNameId(long classPK, long classNameId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSPKANDCLASSNAMEID;

		Object[] finderArgs = new Object[] { classPK, classNameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_CLASSPKANDCLASSNAMEID_CLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSPKANDCLASSNAMEID_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classPK);

				qPos.add(classNameId);

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

	private static final String _FINDER_COLUMN_CLASSPKANDCLASSNAMEID_CLASSPK_2 = "spSharing.classPK = ? AND ";
	private static final String _FINDER_COLUMN_CLASSPKANDCLASSNAMEID_CLASSNAMEID_2 =
		"spSharing.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBYCLASSPKANDCLASSNAMEID =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreatedByClassPKAndClassNameId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYCLASSPKANDCLASSNAMEID =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreatedByClassPKAndClassNameId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPSharingModelImpl.CREATEDBY_COLUMN_BITMASK |
			SPSharingModelImpl.CLASSPK_COLUMN_BITMASK |
			SPSharingModelImpl.CLASSNAMEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDBYCLASSPKANDCLASSNAMEID =
		new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCreatedByClassPKAndClassNameId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @return the matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByCreatedByClassPKAndClassNameId(
		long createdBy, long classPK, long classNameId)
		throws SystemException {
		return findByCreatedByClassPKAndClassNameId(createdBy, classPK,
			classNameId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @return the range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByCreatedByClassPKAndClassNameId(
		long createdBy, long classPK, long classNameId, int start, int end)
		throws SystemException {
		return findByCreatedByClassPKAndClassNameId(createdBy, classPK,
			classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByCreatedByClassPKAndClassNameId(
		long createdBy, long classPK, long classNameId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYCLASSPKANDCLASSNAMEID;
			finderArgs = new Object[] { createdBy, classPK, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBYCLASSPKANDCLASSNAMEID;
			finderArgs = new Object[] {
					createdBy, classPK, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<SPSharing> list = (List<SPSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSharing spSharing : list) {
				if ((createdBy != spSharing.getCreatedBy()) ||
						(classPK != spSharing.getClassPK()) ||
						(classNameId != spSharing.getClassNameId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CREATEDBY_2);

			query.append(_FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CLASSPK_2);

			query.append(_FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSharingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				qPos.add(classPK);

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSharing>(list);
				}
				else {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByCreatedByClassPKAndClassNameId_First(
		long createdBy, long classPK, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByCreatedByClassPKAndClassNameId_First(createdBy,
				classPK, classNameId, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the first s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByCreatedByClassPKAndClassNameId_First(
		long createdBy, long classPK, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSharing> list = findByCreatedByClassPKAndClassNameId(createdBy,
				classPK, classNameId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByCreatedByClassPKAndClassNameId_Last(long createdBy,
		long classPK, long classNameId, OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByCreatedByClassPKAndClassNameId_Last(createdBy,
				classPK, classNameId, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the last s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByCreatedByClassPKAndClassNameId_Last(
		long createdBy, long classPK, long classNameId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreatedByClassPKAndClassNameId(createdBy, classPK,
				classNameId);

		if (count == 0) {
			return null;
		}

		List<SPSharing> list = findByCreatedByClassPKAndClassNameId(createdBy,
				classPK, classNameId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sharings before and after the current s p sharing in the ordered set where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	 *
	 * @param spSharingId the primary key of the current s p sharing
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing[] findByCreatedByClassPKAndClassNameId_PrevAndNext(
		long spSharingId, long createdBy, long classPK, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = findByPrimaryKey(spSharingId);

		Session session = null;

		try {
			session = openSession();

			SPSharing[] array = new SPSharingImpl[3];

			array[0] = getByCreatedByClassPKAndClassNameId_PrevAndNext(session,
					spSharing, createdBy, classPK, classNameId,
					orderByComparator, true);

			array[1] = spSharing;

			array[2] = getByCreatedByClassPKAndClassNameId_PrevAndNext(session,
					spSharing, createdBy, classPK, classNameId,
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

	protected SPSharing getByCreatedByClassPKAndClassNameId_PrevAndNext(
		Session session, SPSharing spSharing, long createdBy, long classPK,
		long classNameId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSHARING_WHERE);

		query.append(_FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CREATEDBY_2);

		query.append(_FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CLASSPK_2);

		query.append(_FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CLASSNAMEID_2);

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
			query.append(SPSharingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(createdBy);

		qPos.add(classPK);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreatedByClassPKAndClassNameId(long createdBy,
		long classPK, long classNameId) throws SystemException {
		for (SPSharing spSharing : findByCreatedByClassPKAndClassNameId(
				createdBy, classPK, classNameId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spSharing);
		}
	}

	/**
	 * Returns the number of s p sharings where createdBy = &#63; and classPK = &#63; and classNameId = &#63;.
	 *
	 * @param createdBy the created by
	 * @param classPK the class p k
	 * @param classNameId the class name ID
	 * @return the number of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreatedByClassPKAndClassNameId(long createdBy,
		long classPK, long classNameId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDBYCLASSPKANDCLASSNAMEID;

		Object[] finderArgs = new Object[] { createdBy, classPK, classNameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPSHARING_WHERE);

			query.append(_FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CREATEDBY_2);

			query.append(_FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CLASSPK_2);

			query.append(_FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				qPos.add(classPK);

				qPos.add(classNameId);

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

	private static final String _FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CREATEDBY_2 =
		"spSharing.createdBy = ? AND ";
	private static final String _FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CLASSPK_2 =
		"spSharing.classPK = ? AND ";
	private static final String _FINDER_COLUMN_CREATEDBYCLASSPKANDCLASSNAMEID_CLASSNAMEID_2 =
		"spSharing.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, SPSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] { String.class.getName() },
			SPSharingModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p sharings where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByEmail(String emailAddress)
		throws SystemException {
		return findByEmail(emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the s p sharings where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @return the range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByEmail(String emailAddress, int start, int end)
		throws SystemException {
		return findByEmail(emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p sharings where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findByEmail(String emailAddress, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { emailAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] {
					emailAddress,
					
					start, end, orderByComparator
				};
		}

		List<SPSharing> list = (List<SPSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSharing spSharing : list) {
				if (!Validator.equals(emailAddress, spSharing.getEmailAddress())) {
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

			query.append(_SQL_SELECT_SPSHARING_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSharingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				if (!pagination) {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSharing>(list);
				}
				else {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p sharing in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByEmail_First(String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByEmail_First(emailAddress, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the first s p sharing in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByEmail_First(String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSharing> list = findByEmail(emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p sharing in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByEmail_Last(String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByEmail_Last(emailAddress, orderByComparator);

		if (spSharing != null) {
			return spSharing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSharingException(msg.toString());
	}

	/**
	 * Returns the last s p sharing in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p sharing, or <code>null</code> if a matching s p sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByEmail_Last(String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmail(emailAddress);

		if (count == 0) {
			return null;
		}

		List<SPSharing> list = findByEmail(emailAddress, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sharings before and after the current s p sharing in the ordered set where emailAddress = &#63;.
	 *
	 * @param spSharingId the primary key of the current s p sharing
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing[] findByEmail_PrevAndNext(long spSharingId,
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = findByPrimaryKey(spSharingId);

		Session session = null;

		try {
			session = openSession();

			SPSharing[] array = new SPSharingImpl[3];

			array[0] = getByEmail_PrevAndNext(session, spSharing, emailAddress,
					orderByComparator, true);

			array[1] = spSharing;

			array[2] = getByEmail_PrevAndNext(session, spSharing, emailAddress,
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

	protected SPSharing getByEmail_PrevAndNext(Session session,
		SPSharing spSharing, String emailAddress,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSHARING_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_EMAIL_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAIL_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_EMAIL_EMAILADDRESS_2);
		}

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
			query.append(SPSharingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmailAddress) {
			qPos.add(emailAddress);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sharings where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmail(String emailAddress) throws SystemException {
		for (SPSharing spSharing : findByEmail(emailAddress, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spSharing);
		}
	}

	/**
	 * Returns the number of s p sharings where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmail(String emailAddress) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSHARING_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAILADDRESS_1 = "spSharing.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAILADDRESS_2 = "spSharing.emailAddress = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAILADDRESS_3 = "(spSharing.emailAddress IS NULL OR spSharing.emailAddress = '')";

	public SPSharingPersistenceImpl() {
		setModelClass(SPSharing.class);
	}

	/**
	 * Caches the s p sharing in the entity cache if it is enabled.
	 *
	 * @param spSharing the s p sharing
	 */
	@Override
	public void cacheResult(SPSharing spSharing) {
		EntityCacheUtil.putResult(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingImpl.class, spSharing.getPrimaryKey(), spSharing);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK,
			new Object[] {
				spSharing.getUserId(), spSharing.getClassNameId(),
				spSharing.getClassPK()
			}, spSharing);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
			new Object[] {
				spSharing.getUserId(), spSharing.getClassNameId(),
				spSharing.getClassPK(), spSharing.getInternalShare()
			}, spSharing);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
			new Object[] {
				spSharing.getEmailAddress(), spSharing.getClassNameId(),
				spSharing.getClassPK(), spSharing.getInternalShare()
			}, spSharing);

		spSharing.resetOriginalValues();
	}

	/**
	 * Caches the s p sharings in the entity cache if it is enabled.
	 *
	 * @param spSharings the s p sharings
	 */
	@Override
	public void cacheResult(List<SPSharing> spSharings) {
		for (SPSharing spSharing : spSharings) {
			if (EntityCacheUtil.getResult(
						SPSharingModelImpl.ENTITY_CACHE_ENABLED,
						SPSharingImpl.class, spSharing.getPrimaryKey()) == null) {
				cacheResult(spSharing);
			}
			else {
				spSharing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p sharings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPSharingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPSharingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p sharing.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPSharing spSharing) {
		EntityCacheUtil.removeResult(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingImpl.class, spSharing.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spSharing);
	}

	@Override
	public void clearCache(List<SPSharing> spSharings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPSharing spSharing : spSharings) {
			EntityCacheUtil.removeResult(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
				SPSharingImpl.class, spSharing.getPrimaryKey());

			clearUniqueFindersCache(spSharing);
		}
	}

	protected void cacheUniqueFindersCache(SPSharing spSharing) {
		if (spSharing.isNew()) {
			Object[] args = new Object[] {
					spSharing.getUserId(), spSharing.getClassNameId(),
					spSharing.getClassPK()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDANDCLASSPK,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK,
				args, spSharing);

			args = new Object[] {
					spSharing.getUserId(), spSharing.getClassNameId(),
					spSharing.getClassPK(), spSharing.getInternalShare()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
				args, spSharing);

			args = new Object[] {
					spSharing.getEmailAddress(), spSharing.getClassNameId(),
					spSharing.getClassPK(), spSharing.getInternalShare()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
				args, spSharing);
		}
		else {
			SPSharingModelImpl spSharingModelImpl = (SPSharingModelImpl)spSharing;

			if ((spSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSharing.getUserId(), spSharing.getClassNameId(),
						spSharing.getClassPK()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDANDCLASSPK,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK,
					args, spSharing);
			}

			if ((spSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSharing.getUserId(), spSharing.getClassNameId(),
						spSharing.getClassPK(), spSharing.getInternalShare()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
					args, spSharing);
			}

			if ((spSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSharing.getEmailAddress(), spSharing.getClassNameId(),
						spSharing.getClassPK(), spSharing.getInternalShare()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
					args, spSharing);
			}
		}
	}

	protected void clearUniqueFindersCache(SPSharing spSharing) {
		SPSharingModelImpl spSharingModelImpl = (SPSharingModelImpl)spSharing;

		Object[] args = new Object[] {
				spSharing.getUserId(), spSharing.getClassNameId(),
				spSharing.getClassPK()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDANDCLASSPK,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK,
			args);

		if ((spSharingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSharingModelImpl.getOriginalUserId(),
					spSharingModelImpl.getOriginalClassNameId(),
					spSharingModelImpl.getOriginalClassPK()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDANDCLASSPK,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDANDCLASSPK,
				args);
		}

		args = new Object[] {
				spSharing.getUserId(), spSharing.getClassNameId(),
				spSharing.getClassPK(), spSharing.getInternalShare()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
			args);

		if ((spSharingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSharingModelImpl.getOriginalUserId(),
					spSharingModelImpl.getOriginalClassNameId(),
					spSharingModelImpl.getOriginalClassPK(),
					spSharingModelImpl.getOriginalInternalShare()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDCLASSPKANDSHARETYPE,
				args);
		}

		args = new Object[] {
				spSharing.getEmailAddress(), spSharing.getClassNameId(),
				spSharing.getClassPK(), spSharing.getInternalShare()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
			args);

		if ((spSharingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSharingModelImpl.getOriginalEmailAddress(),
					spSharingModelImpl.getOriginalClassNameId(),
					spSharingModelImpl.getOriginalClassPK(),
					spSharingModelImpl.getOriginalInternalShare()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILCLASSNAMEIDCLASSPKANDSHARETYPE,
				args);
		}
	}

	/**
	 * Creates a new s p sharing with the primary key. Does not add the s p sharing to the database.
	 *
	 * @param spSharingId the primary key for the new s p sharing
	 * @return the new s p sharing
	 */
	@Override
	public SPSharing create(long spSharingId) {
		SPSharing spSharing = new SPSharingImpl();

		spSharing.setNew(true);
		spSharing.setPrimaryKey(spSharingId);

		return spSharing;
	}

	/**
	 * Removes the s p sharing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spSharingId the primary key of the s p sharing
	 * @return the s p sharing that was removed
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing remove(long spSharingId)
		throws NoSuchSPSharingException, SystemException {
		return remove((Serializable)spSharingId);
	}

	/**
	 * Removes the s p sharing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p sharing
	 * @return the s p sharing that was removed
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing remove(Serializable primaryKey)
		throws NoSuchSPSharingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPSharing spSharing = (SPSharing)session.get(SPSharingImpl.class,
					primaryKey);

			if (spSharing == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPSharingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spSharing);
		}
		catch (NoSuchSPSharingException nsee) {
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
	protected SPSharing removeImpl(SPSharing spSharing)
		throws SystemException {
		spSharing = toUnwrappedModel(spSharing);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spSharing)) {
				spSharing = (SPSharing)session.get(SPSharingImpl.class,
						spSharing.getPrimaryKeyObj());
			}

			if (spSharing != null) {
				session.delete(spSharing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spSharing != null) {
			clearCache(spSharing);
		}

		return spSharing;
	}

	@Override
	public SPSharing updateImpl(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing)
		throws SystemException {
		spSharing = toUnwrappedModel(spSharing);

		boolean isNew = spSharing.isNew();

		SPSharingModelImpl spSharingModelImpl = (SPSharingModelImpl)spSharing;

		Session session = null;

		try {
			session = openSession();

			if (spSharing.isNew()) {
				session.save(spSharing);

				spSharing.setNew(false);
			}
			else {
				session.merge(spSharing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPSharingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSPKANDCLASSNAMEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSharingModelImpl.getOriginalClassPK(),
						spSharingModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSPKANDCLASSNAMEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSPKANDCLASSNAMEID,
					args);

				args = new Object[] {
						spSharingModelImpl.getClassPK(),
						spSharingModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSPKANDCLASSNAMEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSPKANDCLASSNAMEID,
					args);
			}

			if ((spSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYCLASSPKANDCLASSNAMEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSharingModelImpl.getOriginalCreatedBy(),
						spSharingModelImpl.getOriginalClassPK(),
						spSharingModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDBYCLASSPKANDCLASSNAMEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYCLASSPKANDCLASSNAMEID,
					args);

				args = new Object[] {
						spSharingModelImpl.getCreatedBy(),
						spSharingModelImpl.getClassPK(),
						spSharingModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDBYCLASSPKANDCLASSNAMEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYCLASSPKANDCLASSNAMEID,
					args);
			}

			if ((spSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSharingModelImpl.getOriginalEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);

				args = new Object[] { spSharingModelImpl.getEmailAddress() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);
			}
		}

		EntityCacheUtil.putResult(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSharingImpl.class, spSharing.getPrimaryKey(), spSharing);

		clearUniqueFindersCache(spSharing);
		cacheUniqueFindersCache(spSharing);

		return spSharing;
	}

	protected SPSharing toUnwrappedModel(SPSharing spSharing) {
		if (spSharing instanceof SPSharingImpl) {
			return spSharing;
		}

		SPSharingImpl spSharingImpl = new SPSharingImpl();

		spSharingImpl.setNew(spSharing.isNew());
		spSharingImpl.setPrimaryKey(spSharing.getPrimaryKey());

		spSharingImpl.setSpSharingId(spSharing.getSpSharingId());
		spSharingImpl.setGroupId(spSharing.getGroupId());
		spSharingImpl.setCompanyId(spSharing.getCompanyId());
		spSharingImpl.setCreatedBy(spSharing.getCreatedBy());
		spSharingImpl.setUserName(spSharing.getUserName());
		spSharingImpl.setCreateDate(spSharing.getCreateDate());
		spSharingImpl.setModifiedDate(spSharing.getModifiedDate());
		spSharingImpl.setUserId(spSharing.getUserId());
		spSharingImpl.setEmailAddress(spSharing.getEmailAddress());
		spSharingImpl.setClassNameId(spSharing.getClassNameId());
		spSharingImpl.setClassPK(spSharing.getClassPK());
		spSharingImpl.setDuration(spSharing.getDuration());
		spSharingImpl.setStartDate(spSharing.getStartDate());
		spSharingImpl.setEndDate(spSharing.getEndDate());
		spSharingImpl.setUrl(spSharing.getUrl());
		spSharingImpl.setExpired(spSharing.isExpired());
		spSharingImpl.setInternalShare(spSharing.isInternalShare());
		spSharingImpl.setWritePermission(spSharing.isWritePermission());
		spSharingImpl.setViewCount(spSharing.getViewCount());

		return spSharingImpl;
	}

	/**
	 * Returns the s p sharing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p sharing
	 * @return the s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPSharingException, SystemException {
		SPSharing spSharing = fetchByPrimaryKey(primaryKey);

		if (spSharing == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPSharingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spSharing;
	}

	/**
	 * Returns the s p sharing with the primary key or throws a {@link com.sambaash.platform.srv.sharing.NoSuchSPSharingException} if it could not be found.
	 *
	 * @param spSharingId the primary key of the s p sharing
	 * @return the s p sharing
	 * @throws com.sambaash.platform.srv.sharing.NoSuchSPSharingException if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing findByPrimaryKey(long spSharingId)
		throws NoSuchSPSharingException, SystemException {
		return findByPrimaryKey((Serializable)spSharingId);
	}

	/**
	 * Returns the s p sharing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p sharing
	 * @return the s p sharing, or <code>null</code> if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPSharing spSharing = (SPSharing)EntityCacheUtil.getResult(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
				SPSharingImpl.class, primaryKey);

		if (spSharing == _nullSPSharing) {
			return null;
		}

		if (spSharing == null) {
			Session session = null;

			try {
				session = openSession();

				spSharing = (SPSharing)session.get(SPSharingImpl.class,
						primaryKey);

				if (spSharing != null) {
					cacheResult(spSharing);
				}
				else {
					EntityCacheUtil.putResult(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
						SPSharingImpl.class, primaryKey, _nullSPSharing);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPSharingModelImpl.ENTITY_CACHE_ENABLED,
					SPSharingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spSharing;
	}

	/**
	 * Returns the s p sharing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spSharingId the primary key of the s p sharing
	 * @return the s p sharing, or <code>null</code> if a s p sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSharing fetchByPrimaryKey(long spSharingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spSharingId);
	}

	/**
	 * Returns all the s p sharings.
	 *
	 * @return the s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sharings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @return the range of s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p sharings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sharing.model.impl.SPSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p sharings
	 * @param end the upper bound of the range of s p sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSharing> findAll(int start, int end,
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

		List<SPSharing> list = (List<SPSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSHARING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSHARING;

				if (pagination) {
					sql = sql.concat(SPSharingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSharing>(list);
				}
				else {
					list = (List<SPSharing>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p sharings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPSharing spSharing : findAll()) {
			remove(spSharing);
		}
	}

	/**
	 * Returns the number of s p sharings.
	 *
	 * @return the number of s p sharings
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

				Query q = session.createQuery(_SQL_COUNT_SPSHARING);

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
	 * Initializes the s p sharing persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.sharing.model.SPSharing")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPSharing>> listenersList = new ArrayList<ModelListener<SPSharing>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPSharing>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPSharingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSHARING = "SELECT spSharing FROM SPSharing spSharing";
	private static final String _SQL_SELECT_SPSHARING_WHERE = "SELECT spSharing FROM SPSharing spSharing WHERE ";
	private static final String _SQL_COUNT_SPSHARING = "SELECT COUNT(spSharing) FROM SPSharing spSharing";
	private static final String _SQL_COUNT_SPSHARING_WHERE = "SELECT COUNT(spSharing) FROM SPSharing spSharing WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spSharing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPSharing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPSharing exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPSharingPersistenceImpl.class);
	private static SPSharing _nullSPSharing = new SPSharingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPSharing> toCacheModel() {
				return _nullSPSharingCacheModel;
			}
		};

	private static CacheModel<SPSharing> _nullSPSharingCacheModel = new CacheModel<SPSharing>() {
			@Override
			public SPSharing toEntityModel() {
				return _nullSPSharing;
			}
		};
}