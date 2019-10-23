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

import com.sambaash.platform.srv.NoSuchOutcomeException;
import com.sambaash.platform.srv.model.Outcome;
import com.sambaash.platform.srv.model.impl.OutcomeImpl;
import com.sambaash.platform.srv.model.impl.OutcomeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the outcome service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see OutcomePersistence
 * @see OutcomeUtil
 * @generated
 */
public class OutcomePersistenceImpl extends BasePersistenceImpl<Outcome>
	implements OutcomePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OutcomeUtil} to access the outcome persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OutcomeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			OutcomeModelImpl.GROUPID_COLUMN_BITMASK |
			OutcomeModelImpl.OUTCOMECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the outcomes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the outcomes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @return the range of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the outcomes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByGroupId(long groupId, int start, int end,
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

		List<Outcome> list = (List<Outcome>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Outcome outcome : list) {
				if ((groupId != outcome.getGroupId())) {
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

			query.append(_SQL_SELECT_OUTCOME_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OutcomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Outcome>(list);
				}
				else {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first outcome in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = fetchByGroupId_First(groupId, orderByComparator);

		if (outcome != null) {
			return outcome;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutcomeException(msg.toString());
	}

	/**
	 * Returns the first outcome in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Outcome> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last outcome in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = fetchByGroupId_Last(groupId, orderByComparator);

		if (outcome != null) {
			return outcome;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutcomeException(msg.toString());
	}

	/**
	 * Returns the last outcome in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Outcome> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the outcomes before and after the current outcome in the ordered set where groupId = &#63;.
	 *
	 * @param spOutcomeId the primary key of the current outcome
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome[] findByGroupId_PrevAndNext(long spOutcomeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = findByPrimaryKey(spOutcomeId);

		Session session = null;

		try {
			session = openSession();

			Outcome[] array = new OutcomeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, outcome, groupId,
					orderByComparator, true);

			array[1] = outcome;

			array[2] = getByGroupId_PrevAndNext(session, outcome, groupId,
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

	protected Outcome getByGroupId_PrevAndNext(Session session,
		Outcome outcome, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OUTCOME_WHERE);

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
			query.append(OutcomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(outcome);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Outcome> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the outcomes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Outcome outcome : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(outcome);
		}
	}

	/**
	 * Returns the number of outcomes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching outcomes
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

			query.append(_SQL_COUNT_OUTCOME_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "outcome.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			OutcomeModelImpl.COUNTRYID_COLUMN_BITMASK |
			OutcomeModelImpl.GROUPID_COLUMN_BITMASK |
			OutcomeModelImpl.OUTCOMECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID = new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the outcomes where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the outcomes where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @return the range of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByCountryIdAndGroupId(long countryId,
		long groupId, int start, int end) throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the outcomes where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByCountryIdAndGroupId(long countryId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID;
			finderArgs = new Object[] { countryId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID;
			finderArgs = new Object[] {
					countryId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Outcome> list = (List<Outcome>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Outcome outcome : list) {
				if ((countryId != outcome.getCountryId()) ||
						(groupId != outcome.getGroupId())) {
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

			query.append(_SQL_SELECT_OUTCOME_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OutcomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Outcome>(list);
				}
				else {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByCountryIdAndGroupId_First(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = fetchByCountryIdAndGroupId_First(countryId, groupId,
				orderByComparator);

		if (outcome != null) {
			return outcome;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutcomeException(msg.toString());
	}

	/**
	 * Returns the first outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByCountryIdAndGroupId_First(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Outcome> list = findByCountryIdAndGroupId(countryId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByCountryIdAndGroupId_Last(long countryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = fetchByCountryIdAndGroupId_Last(countryId, groupId,
				orderByComparator);

		if (outcome != null) {
			return outcome;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutcomeException(msg.toString());
	}

	/**
	 * Returns the last outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByCountryIdAndGroupId_Last(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCountryIdAndGroupId(countryId, groupId);

		if (count == 0) {
			return null;
		}

		List<Outcome> list = findByCountryIdAndGroupId(countryId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the outcomes before and after the current outcome in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param spOutcomeId the primary key of the current outcome
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome[] findByCountryIdAndGroupId_PrevAndNext(long spOutcomeId,
		long countryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = findByPrimaryKey(spOutcomeId);

		Session session = null;

		try {
			session = openSession();

			Outcome[] array = new OutcomeImpl[3];

			array[0] = getByCountryIdAndGroupId_PrevAndNext(session, outcome,
					countryId, groupId, orderByComparator, true);

			array[1] = outcome;

			array[2] = getByCountryIdAndGroupId_PrevAndNext(session, outcome,
					countryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Outcome getByCountryIdAndGroupId_PrevAndNext(Session session,
		Outcome outcome, long countryId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OUTCOME_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

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
			query.append(OutcomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(outcome);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Outcome> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the outcomes where countryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		for (Outcome outcome : findByCountryIdAndGroupId(countryId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(outcome);
		}
	}

	/**
	 * Returns the number of outcomes where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the number of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID;

		Object[] finderArgs = new Object[] { countryId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OUTCOME_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

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

	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2 = "outcome.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2 = "outcome.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID =
		new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryIdAndGroupIdAndCompetencyUnitId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID =
		new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryIdAndGroupIdAndCompetencyUnitId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			OutcomeModelImpl.COUNTRYID_COLUMN_BITMASK |
			OutcomeModelImpl.GROUPID_COLUMN_BITMASK |
			OutcomeModelImpl.SPCOMPETENCYUNITID_COLUMN_BITMASK |
			OutcomeModelImpl.OUTCOMECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID =
		new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryIdAndGroupIdAndCompetencyUnitId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @return the matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId)
		throws SystemException {
		return findByCountryIdAndGroupIdAndCompetencyUnitId(countryId, groupId,
			spCompetencyUnitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @return the range of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId, int start,
		int end) throws SystemException {
		return findByCountryIdAndGroupIdAndCompetencyUnitId(countryId, groupId,
			spCompetencyUnitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByCountryIdAndGroupIdAndCompetencyUnitId(
		long countryId, long groupId, long spCompetencyUnitId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID;
			finderArgs = new Object[] { countryId, groupId, spCompetencyUnitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID;
			finderArgs = new Object[] {
					countryId, groupId, spCompetencyUnitId,
					
					start, end, orderByComparator
				};
		}

		List<Outcome> list = (List<Outcome>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Outcome outcome : list) {
				if ((countryId != outcome.getCountryId()) ||
						(groupId != outcome.getGroupId()) ||
						(spCompetencyUnitId != outcome.getSpCompetencyUnitId())) {
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

			query.append(_SQL_SELECT_OUTCOME_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_GROUPID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OutcomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				qPos.add(spCompetencyUnitId);

				if (!pagination) {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Outcome>(list);
				}
				else {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByCountryIdAndGroupIdAndCompetencyUnitId_First(
		long countryId, long groupId, long spCompetencyUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = fetchByCountryIdAndGroupIdAndCompetencyUnitId_First(countryId,
				groupId, spCompetencyUnitId, orderByComparator);

		if (outcome != null) {
			return outcome;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", spCompetencyUnitId=");
		msg.append(spCompetencyUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutcomeException(msg.toString());
	}

	/**
	 * Returns the first outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByCountryIdAndGroupIdAndCompetencyUnitId_First(
		long countryId, long groupId, long spCompetencyUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Outcome> list = findByCountryIdAndGroupIdAndCompetencyUnitId(countryId,
				groupId, spCompetencyUnitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByCountryIdAndGroupIdAndCompetencyUnitId_Last(
		long countryId, long groupId, long spCompetencyUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = fetchByCountryIdAndGroupIdAndCompetencyUnitId_Last(countryId,
				groupId, spCompetencyUnitId, orderByComparator);

		if (outcome != null) {
			return outcome;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", spCompetencyUnitId=");
		msg.append(spCompetencyUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutcomeException(msg.toString());
	}

	/**
	 * Returns the last outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByCountryIdAndGroupIdAndCompetencyUnitId_Last(
		long countryId, long groupId, long spCompetencyUnitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountryIdAndGroupIdAndCompetencyUnitId(countryId,
				groupId, spCompetencyUnitId);

		if (count == 0) {
			return null;
		}

		List<Outcome> list = findByCountryIdAndGroupIdAndCompetencyUnitId(countryId,
				groupId, spCompetencyUnitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the outcomes before and after the current outcome in the ordered set where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param spOutcomeId the primary key of the current outcome
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome[] findByCountryIdAndGroupIdAndCompetencyUnitId_PrevAndNext(
		long spOutcomeId, long countryId, long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = findByPrimaryKey(spOutcomeId);

		Session session = null;

		try {
			session = openSession();

			Outcome[] array = new OutcomeImpl[3];

			array[0] = getByCountryIdAndGroupIdAndCompetencyUnitId_PrevAndNext(session,
					outcome, countryId, groupId, spCompetencyUnitId,
					orderByComparator, true);

			array[1] = outcome;

			array[2] = getByCountryIdAndGroupIdAndCompetencyUnitId_PrevAndNext(session,
					outcome, countryId, groupId, spCompetencyUnitId,
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

	protected Outcome getByCountryIdAndGroupIdAndCompetencyUnitId_PrevAndNext(
		Session session, Outcome outcome, long countryId, long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OUTCOME_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_COUNTRYID_2);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_GROUPID_2);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2);

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
			query.append(OutcomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryId);

		qPos.add(groupId);

		qPos.add(spCompetencyUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(outcome);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Outcome> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryIdAndGroupIdAndCompetencyUnitId(long countryId,
		long groupId, long spCompetencyUnitId) throws SystemException {
		for (Outcome outcome : findByCountryIdAndGroupIdAndCompetencyUnitId(
				countryId, groupId, spCompetencyUnitId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(outcome);
		}
	}

	/**
	 * Returns the number of outcomes where countryId = &#63; and groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @return the number of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryIdAndGroupIdAndCompetencyUnitId(long countryId,
		long groupId, long spCompetencyUnitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID;

		Object[] finderArgs = new Object[] {
				countryId, groupId, spCompetencyUnitId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_OUTCOME_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_GROUPID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				qPos.add(spCompetencyUnitId);

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

	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_COUNTRYID_2 =
		"outcome.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_GROUPID_2 =
		"outcome.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2 =
		"outcome.spCompetencyUnitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID =
		new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdAndCompetencyUnitId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID =
		new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, OutcomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndCompetencyUnitId",
			new String[] { Long.class.getName(), Long.class.getName() },
			OutcomeModelImpl.GROUPID_COLUMN_BITMASK |
			OutcomeModelImpl.SPCOMPETENCYUNITID_COLUMN_BITMASK |
			OutcomeModelImpl.OUTCOMECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDCOMPETENCYUNITID =
		new FinderPath(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndCompetencyUnitId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @return the matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId) throws SystemException {
		return findByGroupIdAndCompetencyUnitId(groupId, spCompetencyUnitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @return the range of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId, int start, int end) throws SystemException {
		return findByGroupIdAndCompetencyUnitId(groupId, spCompetencyUnitId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID;
			finderArgs = new Object[] { groupId, spCompetencyUnitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID;
			finderArgs = new Object[] {
					groupId, spCompetencyUnitId,
					
					start, end, orderByComparator
				};
		}

		List<Outcome> list = (List<Outcome>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Outcome outcome : list) {
				if ((groupId != outcome.getGroupId()) ||
						(spCompetencyUnitId != outcome.getSpCompetencyUnitId())) {
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

			query.append(_SQL_SELECT_OUTCOME_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OutcomeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spCompetencyUnitId);

				if (!pagination) {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Outcome>(list);
				}
				else {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByGroupIdAndCompetencyUnitId_First(long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = fetchByGroupIdAndCompetencyUnitId_First(groupId,
				spCompetencyUnitId, orderByComparator);

		if (outcome != null) {
			return outcome;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spCompetencyUnitId=");
		msg.append(spCompetencyUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutcomeException(msg.toString());
	}

	/**
	 * Returns the first outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outcome, or <code>null</code> if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByGroupIdAndCompetencyUnitId_First(long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Outcome> list = findByGroupIdAndCompetencyUnitId(groupId,
				spCompetencyUnitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByGroupIdAndCompetencyUnitId_Last(long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = fetchByGroupIdAndCompetencyUnitId_Last(groupId,
				spCompetencyUnitId, orderByComparator);

		if (outcome != null) {
			return outcome;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spCompetencyUnitId=");
		msg.append(spCompetencyUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutcomeException(msg.toString());
	}

	/**
	 * Returns the last outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outcome, or <code>null</code> if a matching outcome could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByGroupIdAndCompetencyUnitId_Last(long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdAndCompetencyUnitId(groupId,
				spCompetencyUnitId);

		if (count == 0) {
			return null;
		}

		List<Outcome> list = findByGroupIdAndCompetencyUnitId(groupId,
				spCompetencyUnitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the outcomes before and after the current outcome in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param spOutcomeId the primary key of the current outcome
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome[] findByGroupIdAndCompetencyUnitId_PrevAndNext(
		long spOutcomeId, long groupId, long spCompetencyUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = findByPrimaryKey(spOutcomeId);

		Session session = null;

		try {
			session = openSession();

			Outcome[] array = new OutcomeImpl[3];

			array[0] = getByGroupIdAndCompetencyUnitId_PrevAndNext(session,
					outcome, groupId, spCompetencyUnitId, orderByComparator,
					true);

			array[1] = outcome;

			array[2] = getByGroupIdAndCompetencyUnitId_PrevAndNext(session,
					outcome, groupId, spCompetencyUnitId, orderByComparator,
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

	protected Outcome getByGroupIdAndCompetencyUnitId_PrevAndNext(
		Session session, Outcome outcome, long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OUTCOME_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2);

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
			query.append(OutcomeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(spCompetencyUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(outcome);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Outcome> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the outcomes where groupId = &#63; and spCompetencyUnitId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId) throws SystemException {
		for (Outcome outcome : findByGroupIdAndCompetencyUnitId(groupId,
				spCompetencyUnitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(outcome);
		}
	}

	/**
	 * Returns the number of outcomes where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @return the number of matching outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDCOMPETENCYUNITID;

		Object[] finderArgs = new Object[] { groupId, spCompetencyUnitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OUTCOME_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spCompetencyUnitId);

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

	private static final String _FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_GROUPID_2 =
		"outcome.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2 =
		"outcome.spCompetencyUnitId = ?";

	public OutcomePersistenceImpl() {
		setModelClass(Outcome.class);
	}

	/**
	 * Caches the outcome in the entity cache if it is enabled.
	 *
	 * @param outcome the outcome
	 */
	@Override
	public void cacheResult(Outcome outcome) {
		EntityCacheUtil.putResult(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeImpl.class, outcome.getPrimaryKey(), outcome);

		outcome.resetOriginalValues();
	}

	/**
	 * Caches the outcomes in the entity cache if it is enabled.
	 *
	 * @param outcomes the outcomes
	 */
	@Override
	public void cacheResult(List<Outcome> outcomes) {
		for (Outcome outcome : outcomes) {
			if (EntityCacheUtil.getResult(
						OutcomeModelImpl.ENTITY_CACHE_ENABLED,
						OutcomeImpl.class, outcome.getPrimaryKey()) == null) {
				cacheResult(outcome);
			}
			else {
				outcome.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all outcomes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OutcomeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OutcomeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the outcome.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Outcome outcome) {
		EntityCacheUtil.removeResult(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeImpl.class, outcome.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Outcome> outcomes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Outcome outcome : outcomes) {
			EntityCacheUtil.removeResult(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
				OutcomeImpl.class, outcome.getPrimaryKey());
		}
	}

	/**
	 * Creates a new outcome with the primary key. Does not add the outcome to the database.
	 *
	 * @param spOutcomeId the primary key for the new outcome
	 * @return the new outcome
	 */
	@Override
	public Outcome create(long spOutcomeId) {
		Outcome outcome = new OutcomeImpl();

		outcome.setNew(true);
		outcome.setPrimaryKey(spOutcomeId);

		return outcome;
	}

	/**
	 * Removes the outcome with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spOutcomeId the primary key of the outcome
	 * @return the outcome that was removed
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome remove(long spOutcomeId)
		throws NoSuchOutcomeException, SystemException {
		return remove((Serializable)spOutcomeId);
	}

	/**
	 * Removes the outcome with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the outcome
	 * @return the outcome that was removed
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome remove(Serializable primaryKey)
		throws NoSuchOutcomeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Outcome outcome = (Outcome)session.get(OutcomeImpl.class, primaryKey);

			if (outcome == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOutcomeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(outcome);
		}
		catch (NoSuchOutcomeException nsee) {
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
	protected Outcome removeImpl(Outcome outcome) throws SystemException {
		outcome = toUnwrappedModel(outcome);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(outcome)) {
				outcome = (Outcome)session.get(OutcomeImpl.class,
						outcome.getPrimaryKeyObj());
			}

			if (outcome != null) {
				session.delete(outcome);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (outcome != null) {
			clearCache(outcome);
		}

		return outcome;
	}

	@Override
	public Outcome updateImpl(com.sambaash.platform.srv.model.Outcome outcome)
		throws SystemException {
		outcome = toUnwrappedModel(outcome);

		boolean isNew = outcome.isNew();

		OutcomeModelImpl outcomeModelImpl = (OutcomeModelImpl)outcome;

		Session session = null;

		try {
			session = openSession();

			if (outcome.isNew()) {
				session.save(outcome);

				outcome.setNew(false);
			}
			else {
				session.merge(outcome);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OutcomeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((outcomeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						outcomeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { outcomeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((outcomeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						outcomeModelImpl.getOriginalCountryId(),
						outcomeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);

				args = new Object[] {
						outcomeModelImpl.getCountryId(),
						outcomeModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);
			}

			if ((outcomeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						outcomeModelImpl.getOriginalCountryId(),
						outcomeModelImpl.getOriginalGroupId(),
						outcomeModelImpl.getOriginalSpCompetencyUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID,
					args);

				args = new Object[] {
						outcomeModelImpl.getCountryId(),
						outcomeModelImpl.getGroupId(),
						outcomeModelImpl.getSpCompetencyUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDCOMPETENCYUNITID,
					args);
			}

			if ((outcomeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						outcomeModelImpl.getOriginalGroupId(),
						outcomeModelImpl.getOriginalSpCompetencyUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOMPETENCYUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID,
					args);

				args = new Object[] {
						outcomeModelImpl.getGroupId(),
						outcomeModelImpl.getSpCompetencyUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOMPETENCYUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID,
					args);
			}
		}

		EntityCacheUtil.putResult(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
			OutcomeImpl.class, outcome.getPrimaryKey(), outcome);

		return outcome;
	}

	protected Outcome toUnwrappedModel(Outcome outcome) {
		if (outcome instanceof OutcomeImpl) {
			return outcome;
		}

		OutcomeImpl outcomeImpl = new OutcomeImpl();

		outcomeImpl.setNew(outcome.isNew());
		outcomeImpl.setPrimaryKey(outcome.getPrimaryKey());

		outcomeImpl.setSpOutcomeId(outcome.getSpOutcomeId());
		outcomeImpl.setGroupId(outcome.getGroupId());
		outcomeImpl.setCompanyId(outcome.getCompanyId());
		outcomeImpl.setUserId(outcome.getUserId());
		outcomeImpl.setUserName(outcome.getUserName());
		outcomeImpl.setCreateDate(outcome.getCreateDate());
		outcomeImpl.setModifiedDate(outcome.getModifiedDate());
		outcomeImpl.setCountryId(outcome.getCountryId());
		outcomeImpl.setOutcomeCode(outcome.getOutcomeCode());
		outcomeImpl.setOutcomeDesc(outcome.getOutcomeDesc());
		outcomeImpl.setOutcomeType(outcome.getOutcomeType());
		outcomeImpl.setOutcomeFolderId(outcome.getOutcomeFolderId());
		outcomeImpl.setSpCompetencyUnitId(outcome.getSpCompetencyUnitId());

		return outcomeImpl;
	}

	/**
	 * Returns the outcome with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the outcome
	 * @return the outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOutcomeException, SystemException {
		Outcome outcome = fetchByPrimaryKey(primaryKey);

		if (outcome == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOutcomeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return outcome;
	}

	/**
	 * Returns the outcome with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchOutcomeException} if it could not be found.
	 *
	 * @param spOutcomeId the primary key of the outcome
	 * @return the outcome
	 * @throws com.sambaash.platform.srv.NoSuchOutcomeException if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome findByPrimaryKey(long spOutcomeId)
		throws NoSuchOutcomeException, SystemException {
		return findByPrimaryKey((Serializable)spOutcomeId);
	}

	/**
	 * Returns the outcome with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the outcome
	 * @return the outcome, or <code>null</code> if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Outcome outcome = (Outcome)EntityCacheUtil.getResult(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
				OutcomeImpl.class, primaryKey);

		if (outcome == _nullOutcome) {
			return null;
		}

		if (outcome == null) {
			Session session = null;

			try {
				session = openSession();

				outcome = (Outcome)session.get(OutcomeImpl.class, primaryKey);

				if (outcome != null) {
					cacheResult(outcome);
				}
				else {
					EntityCacheUtil.putResult(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
						OutcomeImpl.class, primaryKey, _nullOutcome);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OutcomeModelImpl.ENTITY_CACHE_ENABLED,
					OutcomeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return outcome;
	}

	/**
	 * Returns the outcome with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spOutcomeId the primary key of the outcome
	 * @return the outcome, or <code>null</code> if a outcome with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outcome fetchByPrimaryKey(long spOutcomeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spOutcomeId);
	}

	/**
	 * Returns all the outcomes.
	 *
	 * @return the outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the outcomes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @return the range of outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the outcomes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of outcomes
	 * @param end the upper bound of the range of outcomes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of outcomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outcome> findAll(int start, int end,
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

		List<Outcome> list = (List<Outcome>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OUTCOME);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OUTCOME;

				if (pagination) {
					sql = sql.concat(OutcomeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Outcome>(list);
				}
				else {
					list = (List<Outcome>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the outcomes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Outcome outcome : findAll()) {
			remove(outcome);
		}
	}

	/**
	 * Returns the number of outcomes.
	 *
	 * @return the number of outcomes
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

				Query q = session.createQuery(_SQL_COUNT_OUTCOME);

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
	 * Initializes the outcome persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Outcome")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Outcome>> listenersList = new ArrayList<ModelListener<Outcome>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Outcome>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OutcomeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OUTCOME = "SELECT outcome FROM Outcome outcome";
	private static final String _SQL_SELECT_OUTCOME_WHERE = "SELECT outcome FROM Outcome outcome WHERE ";
	private static final String _SQL_COUNT_OUTCOME = "SELECT COUNT(outcome) FROM Outcome outcome";
	private static final String _SQL_COUNT_OUTCOME_WHERE = "SELECT COUNT(outcome) FROM Outcome outcome WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "outcome.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Outcome exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Outcome exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OutcomePersistenceImpl.class);
	private static Outcome _nullOutcome = new OutcomeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Outcome> toCacheModel() {
				return _nullOutcomeCacheModel;
			}
		};

	private static CacheModel<Outcome> _nullOutcomeCacheModel = new CacheModel<Outcome>() {
			@Override
			public Outcome toEntityModel() {
				return _nullOutcome;
			}
		};
}