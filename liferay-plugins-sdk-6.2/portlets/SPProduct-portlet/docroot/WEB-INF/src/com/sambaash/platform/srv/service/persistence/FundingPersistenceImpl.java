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

import com.sambaash.platform.srv.NoSuchFundingException;
import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.model.impl.FundingImpl;
import com.sambaash.platform.srv.model.impl.FundingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the funding service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see FundingPersistence
 * @see FundingUtil
 * @generated
 */
public class FundingPersistenceImpl extends BasePersistenceImpl<Funding>
	implements FundingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FundingUtil} to access the funding persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FundingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			FundingModelImpl.GROUPID_COLUMN_BITMASK |
			FundingModelImpl.FUNDORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fundings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fundings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @return the range of matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fundings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findByGroupId(long groupId, int start, int end,
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

		List<Funding> list = (List<Funding>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding funding : list) {
				if ((groupId != funding.getGroupId())) {
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

			query.append(_SQL_SELECT_FUNDING_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding>(list);
				}
				else {
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = fetchByGroupId_First(groupId, orderByComparator);

		if (funding != null) {
			return funding;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundingException(msg.toString());
	}

	/**
	 * Returns the first funding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding, or <code>null</code> if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funding> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = fetchByGroupId_Last(groupId, orderByComparator);

		if (funding != null) {
			return funding;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundingException(msg.toString());
	}

	/**
	 * Returns the last funding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding, or <code>null</code> if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Funding> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fundings before and after the current funding in the ordered set where groupId = &#63;.
	 *
	 * @param spFundingId the primary key of the current funding
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding[] findByGroupId_PrevAndNext(long spFundingId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = findByPrimaryKey(spFundingId);

		Session session = null;

		try {
			session = openSession();

			Funding[] array = new FundingImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, funding, groupId,
					orderByComparator, true);

			array[1] = funding;

			array[2] = getByGroupId_PrevAndNext(session, funding, groupId,
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

	protected Funding getByGroupId_PrevAndNext(Session session,
		Funding funding, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDING_WHERE);

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
			query.append(FundingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fundings where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Funding funding : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(funding);
		}
	}

	/**
	 * Returns the number of fundings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching fundings
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

			query.append(_SQL_COUNT_FUNDING_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "funding.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FundingModelImpl.SPCOURSEID_COLUMN_BITMASK |
			FundingModelImpl.GROUPID_COLUMN_BITMASK |
			FundingModelImpl.FUNDORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the fundings where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fundings where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @return the range of matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fundings where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findByCourseIdAndGroupId(long spCourseId,
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

		List<Funding> list = (List<Funding>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding funding : list) {
				if ((spCourseId != funding.getSpCourseId()) ||
						(groupId != funding.getGroupId())) {
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

			query.append(_SQL_SELECT_FUNDING_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundingModelImpl.ORDER_BY_JPQL);
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
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding>(list);
				}
				else {
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funding in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = fetchByCourseIdAndGroupId_First(spCourseId, groupId,
				orderByComparator);

		if (funding != null) {
			return funding;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundingException(msg.toString());
	}

	/**
	 * Returns the first funding in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding, or <code>null</code> if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Funding> list = findByCourseIdAndGroupId(spCourseId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findByCourseIdAndGroupId_Last(long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = fetchByCourseIdAndGroupId_Last(spCourseId, groupId,
				orderByComparator);

		if (funding != null) {
			return funding;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundingException(msg.toString());
	}

	/**
	 * Returns the last funding in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding, or <code>null</code> if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<Funding> list = findByCourseIdAndGroupId(spCourseId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fundings before and after the current funding in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spFundingId the primary key of the current funding
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding[] findByCourseIdAndGroupId_PrevAndNext(long spFundingId,
		long spCourseId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = findByPrimaryKey(spFundingId);

		Session session = null;

		try {
			session = openSession();

			Funding[] array = new FundingImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session, funding,
					spCourseId, groupId, orderByComparator, true);

			array[1] = funding;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session, funding,
					spCourseId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Funding getByCourseIdAndGroupId_PrevAndNext(Session session,
		Funding funding, long spCourseId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDING_WHERE);

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
			query.append(FundingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fundings where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (Funding funding : findByCourseIdAndGroupId(spCourseId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funding);
		}
	}

	/**
	 * Returns the number of fundings where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching fundings
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

			query.append(_SQL_COUNT_FUNDING_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "funding.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "funding.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
		new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseId",
			new String[] { Long.class.getName() },
			FundingModelImpl.SPCOURSEID_COLUMN_BITMASK |
			FundingModelImpl.FUNDORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fundings where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @return the matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findByCourseId(long spCourseId)
		throws SystemException {
		return findByCourseId(spCourseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fundings where spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @return the range of matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findByCourseId(long spCourseId, int start, int end)
		throws SystemException {
		return findByCourseId(spCourseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fundings where spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findByCourseId(long spCourseId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Funding> list = (List<Funding>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding funding : list) {
				if ((spCourseId != funding.getSpCourseId())) {
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

			query.append(_SQL_SELECT_FUNDING_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_SPCOURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				if (!pagination) {
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding>(list);
				}
				else {
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funding in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findByCourseId_First(long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = fetchByCourseId_First(spCourseId, orderByComparator);

		if (funding != null) {
			return funding;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundingException(msg.toString());
	}

	/**
	 * Returns the first funding in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding, or <code>null</code> if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchByCourseId_First(long spCourseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funding> list = findByCourseId(spCourseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findByCourseId_Last(long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = fetchByCourseId_Last(spCourseId, orderByComparator);

		if (funding != null) {
			return funding;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundingException(msg.toString());
	}

	/**
	 * Returns the last funding in the ordered set where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding, or <code>null</code> if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchByCourseId_Last(long spCourseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseId(spCourseId);

		if (count == 0) {
			return null;
		}

		List<Funding> list = findByCourseId(spCourseId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fundings before and after the current funding in the ordered set where spCourseId = &#63;.
	 *
	 * @param spFundingId the primary key of the current funding
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding[] findByCourseId_PrevAndNext(long spFundingId,
		long spCourseId, OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = findByPrimaryKey(spFundingId);

		Session session = null;

		try {
			session = openSession();

			Funding[] array = new FundingImpl[3];

			array[0] = getByCourseId_PrevAndNext(session, funding, spCourseId,
					orderByComparator, true);

			array[1] = funding;

			array[2] = getByCourseId_PrevAndNext(session, funding, spCourseId,
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

	protected Funding getByCourseId_PrevAndNext(Session session,
		Funding funding, long spCourseId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDING_WHERE);

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
			query.append(FundingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fundings where spCourseId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseId(long spCourseId) throws SystemException {
		for (Funding funding : findByCourseId(spCourseId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(funding);
		}
	}

	/**
	 * Returns the number of fundings where spCourseId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @return the number of matching fundings
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

			query.append(_SQL_COUNT_FUNDING_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEID_SPCOURSEID_2 = "funding.spCourseId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPONSORBYCOURSEID =
		new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySponsorByCourseId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPONSORBYCOURSEID =
		new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, FundingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySponsorByCourseId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FundingModelImpl.SPCOURSEID_COLUMN_BITMASK |
			FundingModelImpl.SPONSOREDBY_COLUMN_BITMASK |
			FundingModelImpl.FUNDORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPONSORBYCOURSEID = new FinderPath(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySponsorByCourseId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the fundings where spCourseId = &#63; and sponsoredBy = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @return the matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findBySponsorByCourseId(long spCourseId,
		long sponsoredBy) throws SystemException {
		return findBySponsorByCourseId(spCourseId, sponsoredBy,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fundings where spCourseId = &#63; and sponsoredBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @return the range of matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findBySponsorByCourseId(long spCourseId,
		long sponsoredBy, int start, int end) throws SystemException {
		return findBySponsorByCourseId(spCourseId, sponsoredBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fundings where spCourseId = &#63; and sponsoredBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findBySponsorByCourseId(long spCourseId,
		long sponsoredBy, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPONSORBYCOURSEID;
			finderArgs = new Object[] { spCourseId, sponsoredBy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPONSORBYCOURSEID;
			finderArgs = new Object[] {
					spCourseId, sponsoredBy,
					
					start, end, orderByComparator
				};
		}

		List<Funding> list = (List<Funding>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding funding : list) {
				if ((spCourseId != funding.getSpCourseId()) ||
						(sponsoredBy != funding.getSponsoredBy())) {
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

			query.append(_SQL_SELECT_FUNDING_WHERE);

			query.append(_FINDER_COLUMN_SPONSORBYCOURSEID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_SPONSORBYCOURSEID_SPONSOREDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(sponsoredBy);

				if (!pagination) {
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding>(list);
				}
				else {
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first funding in the ordered set where spCourseId = &#63; and sponsoredBy = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findBySponsorByCourseId_First(long spCourseId,
		long sponsoredBy, OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = fetchBySponsorByCourseId_First(spCourseId,
				sponsoredBy, orderByComparator);

		if (funding != null) {
			return funding;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", sponsoredBy=");
		msg.append(sponsoredBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundingException(msg.toString());
	}

	/**
	 * Returns the first funding in the ordered set where spCourseId = &#63; and sponsoredBy = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding, or <code>null</code> if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchBySponsorByCourseId_First(long spCourseId,
		long sponsoredBy, OrderByComparator orderByComparator)
		throws SystemException {
		List<Funding> list = findBySponsorByCourseId(spCourseId, sponsoredBy,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding in the ordered set where spCourseId = &#63; and sponsoredBy = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findBySponsorByCourseId_Last(long spCourseId,
		long sponsoredBy, OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = fetchBySponsorByCourseId_Last(spCourseId,
				sponsoredBy, orderByComparator);

		if (funding != null) {
			return funding;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", sponsoredBy=");
		msg.append(sponsoredBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFundingException(msg.toString());
	}

	/**
	 * Returns the last funding in the ordered set where spCourseId = &#63; and sponsoredBy = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding, or <code>null</code> if a matching funding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchBySponsorByCourseId_Last(long spCourseId,
		long sponsoredBy, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySponsorByCourseId(spCourseId, sponsoredBy);

		if (count == 0) {
			return null;
		}

		List<Funding> list = findBySponsorByCourseId(spCourseId, sponsoredBy,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fundings before and after the current funding in the ordered set where spCourseId = &#63; and sponsoredBy = &#63;.
	 *
	 * @param spFundingId the primary key of the current funding
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding[] findBySponsorByCourseId_PrevAndNext(long spFundingId,
		long spCourseId, long sponsoredBy, OrderByComparator orderByComparator)
		throws NoSuchFundingException, SystemException {
		Funding funding = findByPrimaryKey(spFundingId);

		Session session = null;

		try {
			session = openSession();

			Funding[] array = new FundingImpl[3];

			array[0] = getBySponsorByCourseId_PrevAndNext(session, funding,
					spCourseId, sponsoredBy, orderByComparator, true);

			array[1] = funding;

			array[2] = getBySponsorByCourseId_PrevAndNext(session, funding,
					spCourseId, sponsoredBy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Funding getBySponsorByCourseId_PrevAndNext(Session session,
		Funding funding, long spCourseId, long sponsoredBy,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDING_WHERE);

		query.append(_FINDER_COLUMN_SPONSORBYCOURSEID_SPCOURSEID_2);

		query.append(_FINDER_COLUMN_SPONSORBYCOURSEID_SPONSOREDBY_2);

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
			query.append(FundingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(sponsoredBy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fundings where spCourseId = &#63; and sponsoredBy = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySponsorByCourseId(long spCourseId, long sponsoredBy)
		throws SystemException {
		for (Funding funding : findBySponsorByCourseId(spCourseId, sponsoredBy,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funding);
		}
	}

	/**
	 * Returns the number of fundings where spCourseId = &#63; and sponsoredBy = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param sponsoredBy the sponsored by
	 * @return the number of matching fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySponsorByCourseId(long spCourseId, long sponsoredBy)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPONSORBYCOURSEID;

		Object[] finderArgs = new Object[] { spCourseId, sponsoredBy };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FUNDING_WHERE);

			query.append(_FINDER_COLUMN_SPONSORBYCOURSEID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_SPONSORBYCOURSEID_SPONSOREDBY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(sponsoredBy);

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

	private static final String _FINDER_COLUMN_SPONSORBYCOURSEID_SPCOURSEID_2 = "funding.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_SPONSORBYCOURSEID_SPONSOREDBY_2 = "funding.sponsoredBy = ?";

	public FundingPersistenceImpl() {
		setModelClass(Funding.class);
	}

	/**
	 * Caches the funding in the entity cache if it is enabled.
	 *
	 * @param funding the funding
	 */
	@Override
	public void cacheResult(Funding funding) {
		EntityCacheUtil.putResult(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingImpl.class, funding.getPrimaryKey(), funding);

		funding.resetOriginalValues();
	}

	/**
	 * Caches the fundings in the entity cache if it is enabled.
	 *
	 * @param fundings the fundings
	 */
	@Override
	public void cacheResult(List<Funding> fundings) {
		for (Funding funding : fundings) {
			if (EntityCacheUtil.getResult(
						FundingModelImpl.ENTITY_CACHE_ENABLED,
						FundingImpl.class, funding.getPrimaryKey()) == null) {
				cacheResult(funding);
			}
			else {
				funding.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fundings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FundingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FundingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the funding.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Funding funding) {
		EntityCacheUtil.removeResult(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingImpl.class, funding.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Funding> fundings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Funding funding : fundings) {
			EntityCacheUtil.removeResult(FundingModelImpl.ENTITY_CACHE_ENABLED,
				FundingImpl.class, funding.getPrimaryKey());
		}
	}

	/**
	 * Creates a new funding with the primary key. Does not add the funding to the database.
	 *
	 * @param spFundingId the primary key for the new funding
	 * @return the new funding
	 */
	@Override
	public Funding create(long spFundingId) {
		Funding funding = new FundingImpl();

		funding.setNew(true);
		funding.setPrimaryKey(spFundingId);

		return funding;
	}

	/**
	 * Removes the funding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spFundingId the primary key of the funding
	 * @return the funding that was removed
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding remove(long spFundingId)
		throws NoSuchFundingException, SystemException {
		return remove((Serializable)spFundingId);
	}

	/**
	 * Removes the funding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the funding
	 * @return the funding that was removed
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding remove(Serializable primaryKey)
		throws NoSuchFundingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Funding funding = (Funding)session.get(FundingImpl.class, primaryKey);

			if (funding == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFundingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(funding);
		}
		catch (NoSuchFundingException nsee) {
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
	protected Funding removeImpl(Funding funding) throws SystemException {
		funding = toUnwrappedModel(funding);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(funding)) {
				funding = (Funding)session.get(FundingImpl.class,
						funding.getPrimaryKeyObj());
			}

			if (funding != null) {
				session.delete(funding);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (funding != null) {
			clearCache(funding);
		}

		return funding;
	}

	@Override
	public Funding updateImpl(com.sambaash.platform.srv.model.Funding funding)
		throws SystemException {
		funding = toUnwrappedModel(funding);

		boolean isNew = funding.isNew();

		FundingModelImpl fundingModelImpl = (FundingModelImpl)funding;

		Session session = null;

		try {
			session = openSession();

			if (funding.isNew()) {
				session.save(funding);

				funding.setNew(false);
			}
			else {
				session.merge(funding);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FundingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((fundingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundingModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { fundingModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((fundingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundingModelImpl.getOriginalSpCourseId(),
						fundingModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						fundingModelImpl.getSpCourseId(),
						fundingModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}

			if ((fundingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundingModelImpl.getOriginalSpCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);

				args = new Object[] { fundingModelImpl.getSpCourseId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);
			}

			if ((fundingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPONSORBYCOURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundingModelImpl.getOriginalSpCourseId(),
						fundingModelImpl.getOriginalSponsoredBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPONSORBYCOURSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPONSORBYCOURSEID,
					args);

				args = new Object[] {
						fundingModelImpl.getSpCourseId(),
						fundingModelImpl.getSponsoredBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPONSORBYCOURSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPONSORBYCOURSEID,
					args);
			}
		}

		EntityCacheUtil.putResult(FundingModelImpl.ENTITY_CACHE_ENABLED,
			FundingImpl.class, funding.getPrimaryKey(), funding);

		return funding;
	}

	protected Funding toUnwrappedModel(Funding funding) {
		if (funding instanceof FundingImpl) {
			return funding;
		}

		FundingImpl fundingImpl = new FundingImpl();

		fundingImpl.setNew(funding.isNew());
		fundingImpl.setPrimaryKey(funding.getPrimaryKey());

		fundingImpl.setSpFundingId(funding.getSpFundingId());
		fundingImpl.setGroupId(funding.getGroupId());
		fundingImpl.setCompanyId(funding.getCompanyId());
		fundingImpl.setUserId(funding.getUserId());
		fundingImpl.setUserName(funding.getUserName());
		fundingImpl.setCreateDate(funding.getCreateDate());
		fundingImpl.setModifiedDate(funding.getModifiedDate());
		fundingImpl.setCourseType(funding.getCourseType());
		fundingImpl.setFundingDesc(funding.getFundingDesc());
		fundingImpl.setFundingCriteria(funding.getFundingCriteria());
		fundingImpl.setFundOrder(funding.getFundOrder());
		fundingImpl.setSponsoredBy(funding.getSponsoredBy());
		fundingImpl.setResidenceStatus(funding.getResidenceStatus());
		fundingImpl.setAgeOperator(funding.getAgeOperator());
		fundingImpl.setAge(funding.getAge());
		fundingImpl.setEarningStatus(funding.getEarningStatus());
		fundingImpl.setSalaryOperator(funding.getSalaryOperator());
		fundingImpl.setSalary(funding.getSalary());
		fundingImpl.setFundingHour(funding.getFundingHour());
		fundingImpl.setFundingAmount(funding.getFundingAmount());
		fundingImpl.setNetFees(funding.getNetFees());
		fundingImpl.setAbsenteePayroll(funding.getAbsenteePayroll());
		fundingImpl.setFundingCourseFee(funding.getFundingCourseFee());
		fundingImpl.setSpCourseId(funding.getSpCourseId());

		return fundingImpl;
	}

	/**
	 * Returns the funding with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the funding
	 * @return the funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFundingException, SystemException {
		Funding funding = fetchByPrimaryKey(primaryKey);

		if (funding == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFundingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return funding;
	}

	/**
	 * Returns the funding with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchFundingException} if it could not be found.
	 *
	 * @param spFundingId the primary key of the funding
	 * @return the funding
	 * @throws com.sambaash.platform.srv.NoSuchFundingException if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding findByPrimaryKey(long spFundingId)
		throws NoSuchFundingException, SystemException {
		return findByPrimaryKey((Serializable)spFundingId);
	}

	/**
	 * Returns the funding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the funding
	 * @return the funding, or <code>null</code> if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Funding funding = (Funding)EntityCacheUtil.getResult(FundingModelImpl.ENTITY_CACHE_ENABLED,
				FundingImpl.class, primaryKey);

		if (funding == _nullFunding) {
			return null;
		}

		if (funding == null) {
			Session session = null;

			try {
				session = openSession();

				funding = (Funding)session.get(FundingImpl.class, primaryKey);

				if (funding != null) {
					cacheResult(funding);
				}
				else {
					EntityCacheUtil.putResult(FundingModelImpl.ENTITY_CACHE_ENABLED,
						FundingImpl.class, primaryKey, _nullFunding);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FundingModelImpl.ENTITY_CACHE_ENABLED,
					FundingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return funding;
	}

	/**
	 * Returns the funding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spFundingId the primary key of the funding
	 * @return the funding, or <code>null</code> if a funding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding fetchByPrimaryKey(long spFundingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spFundingId);
	}

	/**
	 * Returns all the fundings.
	 *
	 * @return the fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fundings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @return the range of fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fundings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FundingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fundings
	 * @param end the upper bound of the range of fundings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fundings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding> findAll(int start, int end,
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

		List<Funding> list = (List<Funding>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FUNDING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUNDING;

				if (pagination) {
					sql = sql.concat(FundingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding>(list);
				}
				else {
					list = (List<Funding>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fundings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Funding funding : findAll()) {
			remove(funding);
		}
	}

	/**
	 * Returns the number of fundings.
	 *
	 * @return the number of fundings
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

				Query q = session.createQuery(_SQL_COUNT_FUNDING);

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
	 * Initializes the funding persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Funding")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Funding>> listenersList = new ArrayList<ModelListener<Funding>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Funding>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FundingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FUNDING = "SELECT funding FROM Funding funding";
	private static final String _SQL_SELECT_FUNDING_WHERE = "SELECT funding FROM Funding funding WHERE ";
	private static final String _SQL_COUNT_FUNDING = "SELECT COUNT(funding) FROM Funding funding";
	private static final String _SQL_COUNT_FUNDING_WHERE = "SELECT COUNT(funding) FROM Funding funding WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "funding.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Funding exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Funding exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FundingPersistenceImpl.class);
	private static Funding _nullFunding = new FundingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Funding> toCacheModel() {
				return _nullFundingCacheModel;
			}
		};

	private static CacheModel<Funding> _nullFundingCacheModel = new CacheModel<Funding>() {
			@Override
			public Funding toEntityModel() {
				return _nullFunding;
			}
		};
}