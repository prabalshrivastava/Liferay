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

import com.sambaash.platform.srv.NoSuchMiscellaneousFeesException;
import com.sambaash.platform.srv.model.MiscellaneousFees;
import com.sambaash.platform.srv.model.impl.MiscellaneousFeesImpl;
import com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the miscellaneous fees service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MiscellaneousFeesPersistence
 * @see MiscellaneousFeesUtil
 * @generated
 */
public class MiscellaneousFeesPersistenceImpl extends BasePersistenceImpl<MiscellaneousFees>
	implements MiscellaneousFeesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MiscellaneousFeesUtil} to access the miscellaneous fees persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MiscellaneousFeesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesModelImpl.FINDER_CACHE_ENABLED,
			MiscellaneousFeesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesModelImpl.FINDER_CACHE_ENABLED,
			MiscellaneousFeesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesModelImpl.FINDER_CACHE_ENABLED,
			MiscellaneousFeesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesModelImpl.FINDER_CACHE_ENABLED,
			MiscellaneousFeesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			MiscellaneousFeesModelImpl.SPCOURSEID_COLUMN_BITMASK |
			MiscellaneousFeesModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the miscellaneous feeses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching miscellaneous feeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MiscellaneousFees> findByCourseIdAndGroupId(long spCourseId,
		long groupId) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the miscellaneous feeses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of miscellaneous feeses
	 * @param end the upper bound of the range of miscellaneous feeses (not inclusive)
	 * @return the range of matching miscellaneous feeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MiscellaneousFees> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the miscellaneous feeses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of miscellaneous feeses
	 * @param end the upper bound of the range of miscellaneous feeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching miscellaneous feeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MiscellaneousFees> findByCourseIdAndGroupId(long spCourseId,
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

		List<MiscellaneousFees> list = (List<MiscellaneousFees>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MiscellaneousFees miscellaneousFees : list) {
				if ((spCourseId != miscellaneousFees.getSpCourseId()) ||
						(groupId != miscellaneousFees.getGroupId())) {
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

			query.append(_SQL_SELECT_MISCELLANEOUSFEES_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MiscellaneousFeesModelImpl.ORDER_BY_JPQL);
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
					list = (List<MiscellaneousFees>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MiscellaneousFees>(list);
				}
				else {
					list = (List<MiscellaneousFees>)QueryUtil.list(q,
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
	 * Returns the first miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching miscellaneous fees
	 * @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a matching miscellaneous fees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchMiscellaneousFeesException, SystemException {
		MiscellaneousFees miscellaneousFees = fetchByCourseIdAndGroupId_First(spCourseId,
				groupId, orderByComparator);

		if (miscellaneousFees != null) {
			return miscellaneousFees;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMiscellaneousFeesException(msg.toString());
	}

	/**
	 * Returns the first miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching miscellaneous fees, or <code>null</code> if a matching miscellaneous fees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MiscellaneousFees> list = findByCourseIdAndGroupId(spCourseId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching miscellaneous fees
	 * @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a matching miscellaneous fees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees findByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchMiscellaneousFeesException, SystemException {
		MiscellaneousFees miscellaneousFees = fetchByCourseIdAndGroupId_Last(spCourseId,
				groupId, orderByComparator);

		if (miscellaneousFees != null) {
			return miscellaneousFees;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMiscellaneousFeesException(msg.toString());
	}

	/**
	 * Returns the last miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching miscellaneous fees, or <code>null</code> if a matching miscellaneous fees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<MiscellaneousFees> list = findByCourseIdAndGroupId(spCourseId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the miscellaneous feeses before and after the current miscellaneous fees in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spMiscFeesId the primary key of the current miscellaneous fees
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next miscellaneous fees
	 * @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a miscellaneous fees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees[] findByCourseIdAndGroupId_PrevAndNext(
		long spMiscFeesId, long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchMiscellaneousFeesException, SystemException {
		MiscellaneousFees miscellaneousFees = findByPrimaryKey(spMiscFeesId);

		Session session = null;

		try {
			session = openSession();

			MiscellaneousFees[] array = new MiscellaneousFeesImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session,
					miscellaneousFees, spCourseId, groupId, orderByComparator,
					true);

			array[1] = miscellaneousFees;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session,
					miscellaneousFees, spCourseId, groupId, orderByComparator,
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

	protected MiscellaneousFees getByCourseIdAndGroupId_PrevAndNext(
		Session session, MiscellaneousFees miscellaneousFees, long spCourseId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MISCELLANEOUSFEES_WHERE);

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
			query.append(MiscellaneousFeesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(miscellaneousFees);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MiscellaneousFees> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the miscellaneous feeses where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (MiscellaneousFees miscellaneousFees : findByCourseIdAndGroupId(
				spCourseId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(miscellaneousFees);
		}
	}

	/**
	 * Returns the number of miscellaneous feeses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching miscellaneous feeses
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

			query.append(_SQL_COUNT_MISCELLANEOUSFEES_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "miscellaneousFees.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "miscellaneousFees.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COURSEIDFEETYPE = new FinderPath(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesModelImpl.FINDER_CACHE_ENABLED,
			MiscellaneousFeesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCourseIdFeeType",
			new String[] { Long.class.getName(), Long.class.getName() },
			MiscellaneousFeesModelImpl.SPCOURSEID_COLUMN_BITMASK |
			MiscellaneousFeesModelImpl.MISCFEETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDFEETYPE = new FinderPath(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdFeeType",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the miscellaneous fees where spCourseId = &#63; and miscFeeType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchMiscellaneousFeesException} if it could not be found.
	 *
	 * @param spCourseId the sp course ID
	 * @param miscFeeType the misc fee type
	 * @return the matching miscellaneous fees
	 * @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a matching miscellaneous fees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees findByCourseIdFeeType(long spCourseId,
		long miscFeeType)
		throws NoSuchMiscellaneousFeesException, SystemException {
		MiscellaneousFees miscellaneousFees = fetchByCourseIdFeeType(spCourseId,
				miscFeeType);

		if (miscellaneousFees == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spCourseId=");
			msg.append(spCourseId);

			msg.append(", miscFeeType=");
			msg.append(miscFeeType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMiscellaneousFeesException(msg.toString());
		}

		return miscellaneousFees;
	}

	/**
	 * Returns the miscellaneous fees where spCourseId = &#63; and miscFeeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @param miscFeeType the misc fee type
	 * @return the matching miscellaneous fees, or <code>null</code> if a matching miscellaneous fees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees fetchByCourseIdFeeType(long spCourseId,
		long miscFeeType) throws SystemException {
		return fetchByCourseIdFeeType(spCourseId, miscFeeType, true);
	}

	/**
	 * Returns the miscellaneous fees where spCourseId = &#63; and miscFeeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @param miscFeeType the misc fee type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching miscellaneous fees, or <code>null</code> if a matching miscellaneous fees could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees fetchByCourseIdFeeType(long spCourseId,
		long miscFeeType, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spCourseId, miscFeeType };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COURSEIDFEETYPE,
					finderArgs, this);
		}

		if (result instanceof MiscellaneousFees) {
			MiscellaneousFees miscellaneousFees = (MiscellaneousFees)result;

			if ((spCourseId != miscellaneousFees.getSpCourseId()) ||
					(miscFeeType != miscellaneousFees.getMiscFeeType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MISCELLANEOUSFEES_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDFEETYPE_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDFEETYPE_MISCFEETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(miscFeeType);

				List<MiscellaneousFees> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFEETYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"MiscellaneousFeesPersistenceImpl.fetchByCourseIdFeeType(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					MiscellaneousFees miscellaneousFees = list.get(0);

					result = miscellaneousFees;

					cacheResult(miscellaneousFees);

					if ((miscellaneousFees.getSpCourseId() != spCourseId) ||
							(miscellaneousFees.getMiscFeeType() != miscFeeType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFEETYPE,
							finderArgs, miscellaneousFees);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEIDFEETYPE,
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
			return (MiscellaneousFees)result;
		}
	}

	/**
	 * Removes the miscellaneous fees where spCourseId = &#63; and miscFeeType = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param miscFeeType the misc fee type
	 * @return the miscellaneous fees that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees removeByCourseIdFeeType(long spCourseId,
		long miscFeeType)
		throws NoSuchMiscellaneousFeesException, SystemException {
		MiscellaneousFees miscellaneousFees = findByCourseIdFeeType(spCourseId,
				miscFeeType);

		return remove(miscellaneousFees);
	}

	/**
	 * Returns the number of miscellaneous feeses where spCourseId = &#63; and miscFeeType = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param miscFeeType the misc fee type
	 * @return the number of matching miscellaneous feeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseIdFeeType(long spCourseId, long miscFeeType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEIDFEETYPE;

		Object[] finderArgs = new Object[] { spCourseId, miscFeeType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MISCELLANEOUSFEES_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDFEETYPE_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDFEETYPE_MISCFEETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(miscFeeType);

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

	private static final String _FINDER_COLUMN_COURSEIDFEETYPE_SPCOURSEID_2 = "miscellaneousFees.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDFEETYPE_MISCFEETYPE_2 = "miscellaneousFees.miscFeeType = ?";

	public MiscellaneousFeesPersistenceImpl() {
		setModelClass(MiscellaneousFees.class);
	}

	/**
	 * Caches the miscellaneous fees in the entity cache if it is enabled.
	 *
	 * @param miscellaneousFees the miscellaneous fees
	 */
	@Override
	public void cacheResult(MiscellaneousFees miscellaneousFees) {
		EntityCacheUtil.putResult(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesImpl.class, miscellaneousFees.getPrimaryKey(),
			miscellaneousFees);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFEETYPE,
			new Object[] {
				miscellaneousFees.getSpCourseId(),
				miscellaneousFees.getMiscFeeType()
			}, miscellaneousFees);

		miscellaneousFees.resetOriginalValues();
	}

	/**
	 * Caches the miscellaneous feeses in the entity cache if it is enabled.
	 *
	 * @param miscellaneousFeeses the miscellaneous feeses
	 */
	@Override
	public void cacheResult(List<MiscellaneousFees> miscellaneousFeeses) {
		for (MiscellaneousFees miscellaneousFees : miscellaneousFeeses) {
			if (EntityCacheUtil.getResult(
						MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
						MiscellaneousFeesImpl.class,
						miscellaneousFees.getPrimaryKey()) == null) {
				cacheResult(miscellaneousFees);
			}
			else {
				miscellaneousFees.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all miscellaneous feeses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MiscellaneousFeesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MiscellaneousFeesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the miscellaneous fees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MiscellaneousFees miscellaneousFees) {
		EntityCacheUtil.removeResult(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesImpl.class, miscellaneousFees.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(miscellaneousFees);
	}

	@Override
	public void clearCache(List<MiscellaneousFees> miscellaneousFeeses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MiscellaneousFees miscellaneousFees : miscellaneousFeeses) {
			EntityCacheUtil.removeResult(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
				MiscellaneousFeesImpl.class, miscellaneousFees.getPrimaryKey());

			clearUniqueFindersCache(miscellaneousFees);
		}
	}

	protected void cacheUniqueFindersCache(MiscellaneousFees miscellaneousFees) {
		if (miscellaneousFees.isNew()) {
			Object[] args = new Object[] {
					miscellaneousFees.getSpCourseId(),
					miscellaneousFees.getMiscFeeType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEIDFEETYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFEETYPE,
				args, miscellaneousFees);
		}
		else {
			MiscellaneousFeesModelImpl miscellaneousFeesModelImpl = (MiscellaneousFeesModelImpl)miscellaneousFees;

			if ((miscellaneousFeesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COURSEIDFEETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						miscellaneousFees.getSpCourseId(),
						miscellaneousFees.getMiscFeeType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEIDFEETYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFEETYPE,
					args, miscellaneousFees);
			}
		}
	}

	protected void clearUniqueFindersCache(MiscellaneousFees miscellaneousFees) {
		MiscellaneousFeesModelImpl miscellaneousFeesModelImpl = (MiscellaneousFeesModelImpl)miscellaneousFees;

		Object[] args = new Object[] {
				miscellaneousFees.getSpCourseId(),
				miscellaneousFees.getMiscFeeType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDFEETYPE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEIDFEETYPE, args);

		if ((miscellaneousFeesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COURSEIDFEETYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					miscellaneousFeesModelImpl.getOriginalSpCourseId(),
					miscellaneousFeesModelImpl.getOriginalMiscFeeType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDFEETYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEIDFEETYPE,
				args);
		}
	}

	/**
	 * Creates a new miscellaneous fees with the primary key. Does not add the miscellaneous fees to the database.
	 *
	 * @param spMiscFeesId the primary key for the new miscellaneous fees
	 * @return the new miscellaneous fees
	 */
	@Override
	public MiscellaneousFees create(long spMiscFeesId) {
		MiscellaneousFees miscellaneousFees = new MiscellaneousFeesImpl();

		miscellaneousFees.setNew(true);
		miscellaneousFees.setPrimaryKey(spMiscFeesId);

		return miscellaneousFees;
	}

	/**
	 * Removes the miscellaneous fees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spMiscFeesId the primary key of the miscellaneous fees
	 * @return the miscellaneous fees that was removed
	 * @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a miscellaneous fees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees remove(long spMiscFeesId)
		throws NoSuchMiscellaneousFeesException, SystemException {
		return remove((Serializable)spMiscFeesId);
	}

	/**
	 * Removes the miscellaneous fees with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the miscellaneous fees
	 * @return the miscellaneous fees that was removed
	 * @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a miscellaneous fees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees remove(Serializable primaryKey)
		throws NoSuchMiscellaneousFeesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MiscellaneousFees miscellaneousFees = (MiscellaneousFees)session.get(MiscellaneousFeesImpl.class,
					primaryKey);

			if (miscellaneousFees == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMiscellaneousFeesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(miscellaneousFees);
		}
		catch (NoSuchMiscellaneousFeesException nsee) {
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
	protected MiscellaneousFees removeImpl(MiscellaneousFees miscellaneousFees)
		throws SystemException {
		miscellaneousFees = toUnwrappedModel(miscellaneousFees);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(miscellaneousFees)) {
				miscellaneousFees = (MiscellaneousFees)session.get(MiscellaneousFeesImpl.class,
						miscellaneousFees.getPrimaryKeyObj());
			}

			if (miscellaneousFees != null) {
				session.delete(miscellaneousFees);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (miscellaneousFees != null) {
			clearCache(miscellaneousFees);
		}

		return miscellaneousFees;
	}

	@Override
	public MiscellaneousFees updateImpl(
		com.sambaash.platform.srv.model.MiscellaneousFees miscellaneousFees)
		throws SystemException {
		miscellaneousFees = toUnwrappedModel(miscellaneousFees);

		boolean isNew = miscellaneousFees.isNew();

		MiscellaneousFeesModelImpl miscellaneousFeesModelImpl = (MiscellaneousFeesModelImpl)miscellaneousFees;

		Session session = null;

		try {
			session = openSession();

			if (miscellaneousFees.isNew()) {
				session.save(miscellaneousFees);

				miscellaneousFees.setNew(false);
			}
			else {
				session.merge(miscellaneousFees);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MiscellaneousFeesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((miscellaneousFeesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						miscellaneousFeesModelImpl.getOriginalSpCourseId(),
						miscellaneousFeesModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						miscellaneousFeesModelImpl.getSpCourseId(),
						miscellaneousFeesModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
			MiscellaneousFeesImpl.class, miscellaneousFees.getPrimaryKey(),
			miscellaneousFees);

		clearUniqueFindersCache(miscellaneousFees);
		cacheUniqueFindersCache(miscellaneousFees);

		return miscellaneousFees;
	}

	protected MiscellaneousFees toUnwrappedModel(
		MiscellaneousFees miscellaneousFees) {
		if (miscellaneousFees instanceof MiscellaneousFeesImpl) {
			return miscellaneousFees;
		}

		MiscellaneousFeesImpl miscellaneousFeesImpl = new MiscellaneousFeesImpl();

		miscellaneousFeesImpl.setNew(miscellaneousFees.isNew());
		miscellaneousFeesImpl.setPrimaryKey(miscellaneousFees.getPrimaryKey());

		miscellaneousFeesImpl.setSpMiscFeesId(miscellaneousFees.getSpMiscFeesId());
		miscellaneousFeesImpl.setGroupId(miscellaneousFees.getGroupId());
		miscellaneousFeesImpl.setCompanyId(miscellaneousFees.getCompanyId());
		miscellaneousFeesImpl.setUserId(miscellaneousFees.getUserId());
		miscellaneousFeesImpl.setUserName(miscellaneousFees.getUserName());
		miscellaneousFeesImpl.setCreateDate(miscellaneousFees.getCreateDate());
		miscellaneousFeesImpl.setModifiedDate(miscellaneousFees.getModifiedDate());
		miscellaneousFeesImpl.setMiscFeeType(miscellaneousFees.getMiscFeeType());
		miscellaneousFeesImpl.setAmount(miscellaneousFees.getAmount());
		miscellaneousFeesImpl.setPayable(miscellaneousFees.getPayable());
		miscellaneousFeesImpl.setSpCourseId(miscellaneousFees.getSpCourseId());

		return miscellaneousFeesImpl;
	}

	/**
	 * Returns the miscellaneous fees with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the miscellaneous fees
	 * @return the miscellaneous fees
	 * @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a miscellaneous fees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMiscellaneousFeesException, SystemException {
		MiscellaneousFees miscellaneousFees = fetchByPrimaryKey(primaryKey);

		if (miscellaneousFees == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMiscellaneousFeesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return miscellaneousFees;
	}

	/**
	 * Returns the miscellaneous fees with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchMiscellaneousFeesException} if it could not be found.
	 *
	 * @param spMiscFeesId the primary key of the miscellaneous fees
	 * @return the miscellaneous fees
	 * @throws com.sambaash.platform.srv.NoSuchMiscellaneousFeesException if a miscellaneous fees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees findByPrimaryKey(long spMiscFeesId)
		throws NoSuchMiscellaneousFeesException, SystemException {
		return findByPrimaryKey((Serializable)spMiscFeesId);
	}

	/**
	 * Returns the miscellaneous fees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the miscellaneous fees
	 * @return the miscellaneous fees, or <code>null</code> if a miscellaneous fees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MiscellaneousFees miscellaneousFees = (MiscellaneousFees)EntityCacheUtil.getResult(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
				MiscellaneousFeesImpl.class, primaryKey);

		if (miscellaneousFees == _nullMiscellaneousFees) {
			return null;
		}

		if (miscellaneousFees == null) {
			Session session = null;

			try {
				session = openSession();

				miscellaneousFees = (MiscellaneousFees)session.get(MiscellaneousFeesImpl.class,
						primaryKey);

				if (miscellaneousFees != null) {
					cacheResult(miscellaneousFees);
				}
				else {
					EntityCacheUtil.putResult(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
						MiscellaneousFeesImpl.class, primaryKey,
						_nullMiscellaneousFees);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MiscellaneousFeesModelImpl.ENTITY_CACHE_ENABLED,
					MiscellaneousFeesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return miscellaneousFees;
	}

	/**
	 * Returns the miscellaneous fees with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spMiscFeesId the primary key of the miscellaneous fees
	 * @return the miscellaneous fees, or <code>null</code> if a miscellaneous fees with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MiscellaneousFees fetchByPrimaryKey(long spMiscFeesId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spMiscFeesId);
	}

	/**
	 * Returns all the miscellaneous feeses.
	 *
	 * @return the miscellaneous feeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MiscellaneousFees> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the miscellaneous feeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of miscellaneous feeses
	 * @param end the upper bound of the range of miscellaneous feeses (not inclusive)
	 * @return the range of miscellaneous feeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MiscellaneousFees> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the miscellaneous feeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.MiscellaneousFeesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of miscellaneous feeses
	 * @param end the upper bound of the range of miscellaneous feeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of miscellaneous feeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MiscellaneousFees> findAll(int start, int end,
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

		List<MiscellaneousFees> list = (List<MiscellaneousFees>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MISCELLANEOUSFEES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MISCELLANEOUSFEES;

				if (pagination) {
					sql = sql.concat(MiscellaneousFeesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MiscellaneousFees>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MiscellaneousFees>(list);
				}
				else {
					list = (List<MiscellaneousFees>)QueryUtil.list(q,
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
	 * Removes all the miscellaneous feeses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MiscellaneousFees miscellaneousFees : findAll()) {
			remove(miscellaneousFees);
		}
	}

	/**
	 * Returns the number of miscellaneous feeses.
	 *
	 * @return the number of miscellaneous feeses
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

				Query q = session.createQuery(_SQL_COUNT_MISCELLANEOUSFEES);

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
	 * Initializes the miscellaneous fees persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.MiscellaneousFees")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MiscellaneousFees>> listenersList = new ArrayList<ModelListener<MiscellaneousFees>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MiscellaneousFees>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MiscellaneousFeesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MISCELLANEOUSFEES = "SELECT miscellaneousFees FROM MiscellaneousFees miscellaneousFees";
	private static final String _SQL_SELECT_MISCELLANEOUSFEES_WHERE = "SELECT miscellaneousFees FROM MiscellaneousFees miscellaneousFees WHERE ";
	private static final String _SQL_COUNT_MISCELLANEOUSFEES = "SELECT COUNT(miscellaneousFees) FROM MiscellaneousFees miscellaneousFees";
	private static final String _SQL_COUNT_MISCELLANEOUSFEES_WHERE = "SELECT COUNT(miscellaneousFees) FROM MiscellaneousFees miscellaneousFees WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "miscellaneousFees.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MiscellaneousFees exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MiscellaneousFees exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MiscellaneousFeesPersistenceImpl.class);
	private static MiscellaneousFees _nullMiscellaneousFees = new MiscellaneousFeesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MiscellaneousFees> toCacheModel() {
				return _nullMiscellaneousFeesCacheModel;
			}
		};

	private static CacheModel<MiscellaneousFees> _nullMiscellaneousFeesCacheModel =
		new CacheModel<MiscellaneousFees>() {
			@Override
			public MiscellaneousFees toEntityModel() {
				return _nullMiscellaneousFees;
			}
		};
}