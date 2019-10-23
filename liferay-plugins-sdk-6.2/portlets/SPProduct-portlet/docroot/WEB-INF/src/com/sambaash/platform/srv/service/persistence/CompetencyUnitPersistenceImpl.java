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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchCompetencyUnitException;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.impl.CompetencyUnitImpl;
import com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the competency unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CompetencyUnitPersistence
 * @see CompetencyUnitUtil
 * @generated
 */
public class CompetencyUnitPersistenceImpl extends BasePersistenceImpl<CompetencyUnit>
	implements CompetencyUnitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CompetencyUnitUtil} to access the competency unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CompetencyUnitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			CompetencyUnitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			CompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			CompetencyUnitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			CompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			CompetencyUnitModelImpl.GROUPID_COLUMN_BITMASK |
			CompetencyUnitModelImpl.COMPETENCYUNITCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the competency units where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the competency units where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of competency units
	 * @param end the upper bound of the range of competency units (not inclusive)
	 * @return the range of matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the competency units where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of competency units
	 * @param end the upper bound of the range of competency units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findByGroupId(long groupId, int start, int end,
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

		List<CompetencyUnit> list = (List<CompetencyUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CompetencyUnit competencyUnit : list) {
				if ((groupId != competencyUnit.getGroupId())) {
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

			query.append(_SQL_SELECT_COMPETENCYUNIT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CompetencyUnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CompetencyUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompetencyUnit>(list);
				}
				else {
					list = (List<CompetencyUnit>)QueryUtil.list(q,
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
	 * Returns the first competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = fetchByGroupId_First(groupId,
				orderByComparator);

		if (competencyUnit != null) {
			return competencyUnit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the first competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competency unit, or <code>null</code> if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CompetencyUnit> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (competencyUnit != null) {
			return competencyUnit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the last competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competency unit, or <code>null</code> if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CompetencyUnit> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the competency units before and after the current competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param spCompetencyUnitId the primary key of the current competency unit
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit[] findByGroupId_PrevAndNext(long spCompetencyUnitId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = findByPrimaryKey(spCompetencyUnitId);

		Session session = null;

		try {
			session = openSession();

			CompetencyUnit[] array = new CompetencyUnitImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, competencyUnit,
					groupId, orderByComparator, true);

			array[1] = competencyUnit;

			array[2] = getByGroupId_PrevAndNext(session, competencyUnit,
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

	protected CompetencyUnit getByGroupId_PrevAndNext(Session session,
		CompetencyUnit competencyUnit, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPETENCYUNIT_WHERE);

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
			query.append(CompetencyUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(competencyUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CompetencyUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the competency units where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (CompetencyUnit competencyUnit : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(competencyUnit);
		}
	}

	/**
	 * Returns the number of competency units where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching competency units
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

			query.append(_SQL_COUNT_COMPETENCYUNIT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "competencyUnit.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			CompetencyUnitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			CompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CompetencyUnitModelImpl.COUNTRYID_COLUMN_BITMASK |
			CompetencyUnitModelImpl.GROUPID_COLUMN_BITMASK |
			CompetencyUnitModelImpl.COMPETENCYUNITCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID = new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the competency units where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findByCountryIdAndGroupId(long countryId,
		long groupId) throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the competency units where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of competency units
	 * @param end the upper bound of the range of competency units (not inclusive)
	 * @return the range of matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findByCountryIdAndGroupId(long countryId,
		long groupId, int start, int end) throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the competency units where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of competency units
	 * @param end the upper bound of the range of competency units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findByCountryIdAndGroupId(long countryId,
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

		List<CompetencyUnit> list = (List<CompetencyUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CompetencyUnit competencyUnit : list) {
				if ((countryId != competencyUnit.getCountryId()) ||
						(groupId != competencyUnit.getGroupId())) {
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

			query.append(_SQL_SELECT_COMPETENCYUNIT_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CompetencyUnitModelImpl.ORDER_BY_JPQL);
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
					list = (List<CompetencyUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompetencyUnit>(list);
				}
				else {
					list = (List<CompetencyUnit>)QueryUtil.list(q,
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
	 * Returns the first competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit findByCountryIdAndGroupId_First(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = fetchByCountryIdAndGroupId_First(countryId,
				groupId, orderByComparator);

		if (competencyUnit != null) {
			return competencyUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the first competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competency unit, or <code>null</code> if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByCountryIdAndGroupId_First(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CompetencyUnit> list = findByCountryIdAndGroupId(countryId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit findByCountryIdAndGroupId_Last(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = fetchByCountryIdAndGroupId_Last(countryId,
				groupId, orderByComparator);

		if (competencyUnit != null) {
			return competencyUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the last competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competency unit, or <code>null</code> if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByCountryIdAndGroupId_Last(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCountryIdAndGroupId(countryId, groupId);

		if (count == 0) {
			return null;
		}

		List<CompetencyUnit> list = findByCountryIdAndGroupId(countryId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the competency units before and after the current competency unit in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param spCompetencyUnitId the primary key of the current competency unit
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit[] findByCountryIdAndGroupId_PrevAndNext(
		long spCompetencyUnitId, long countryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = findByPrimaryKey(spCompetencyUnitId);

		Session session = null;

		try {
			session = openSession();

			CompetencyUnit[] array = new CompetencyUnitImpl[3];

			array[0] = getByCountryIdAndGroupId_PrevAndNext(session,
					competencyUnit, countryId, groupId, orderByComparator, true);

			array[1] = competencyUnit;

			array[2] = getByCountryIdAndGroupId_PrevAndNext(session,
					competencyUnit, countryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CompetencyUnit getByCountryIdAndGroupId_PrevAndNext(
		Session session, CompetencyUnit competencyUnit, long countryId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPETENCYUNIT_WHERE);

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
			query.append(CompetencyUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(competencyUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CompetencyUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the competency units where countryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		for (CompetencyUnit competencyUnit : findByCountryIdAndGroupId(
				countryId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(competencyUnit);
		}
	}

	/**
	 * Returns the number of competency units where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the number of matching competency units
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

			query.append(_SQL_COUNT_COMPETENCYUNIT_WHERE);

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

	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2 = "competencyUnit.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2 = "competencyUnit.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID =
		new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			CompetencyUnitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryIdAndGroupIdAndFrameworkId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID =
		new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			CompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryIdAndGroupIdAndFrameworkId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			CompetencyUnitModelImpl.COUNTRYID_COLUMN_BITMASK |
			CompetencyUnitModelImpl.GROUPID_COLUMN_BITMASK |
			CompetencyUnitModelImpl.SPFRAMEWORKID_COLUMN_BITMASK |
			CompetencyUnitModelImpl.COMPETENCYUNITCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID =
		new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryIdAndGroupIdAndFrameworkId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @return the matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId)
		throws SystemException {
		return findByCountryIdAndGroupIdAndFrameworkId(countryId, groupId,
			spFrameworkId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @param start the lower bound of the range of competency units
	 * @param end the upper bound of the range of competency units (not inclusive)
	 * @return the range of matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId, int start, int end)
		throws SystemException {
		return findByCountryIdAndGroupIdAndFrameworkId(countryId, groupId,
			spFrameworkId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @param start the lower bound of the range of competency units
	 * @param end the upper bound of the range of competency units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findByCountryIdAndGroupIdAndFrameworkId(
		long countryId, long groupId, long spFrameworkId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID;
			finderArgs = new Object[] { countryId, groupId, spFrameworkId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID;
			finderArgs = new Object[] {
					countryId, groupId, spFrameworkId,
					
					start, end, orderByComparator
				};
		}

		List<CompetencyUnit> list = (List<CompetencyUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CompetencyUnit competencyUnit : list) {
				if ((countryId != competencyUnit.getCountryId()) ||
						(groupId != competencyUnit.getGroupId()) ||
						(spFrameworkId != competencyUnit.getSpFrameworkId())) {
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

			query.append(_SQL_SELECT_COMPETENCYUNIT_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_GROUPID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_SPFRAMEWORKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CompetencyUnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				qPos.add(spFrameworkId);

				if (!pagination) {
					list = (List<CompetencyUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompetencyUnit>(list);
				}
				else {
					list = (List<CompetencyUnit>)QueryUtil.list(q,
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
	 * Returns the first competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit findByCountryIdAndGroupIdAndFrameworkId_First(
		long countryId, long groupId, long spFrameworkId,
		OrderByComparator orderByComparator)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = fetchByCountryIdAndGroupIdAndFrameworkId_First(countryId,
				groupId, spFrameworkId, orderByComparator);

		if (competencyUnit != null) {
			return competencyUnit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", spFrameworkId=");
		msg.append(spFrameworkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the first competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching competency unit, or <code>null</code> if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByCountryIdAndGroupIdAndFrameworkId_First(
		long countryId, long groupId, long spFrameworkId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CompetencyUnit> list = findByCountryIdAndGroupIdAndFrameworkId(countryId,
				groupId, spFrameworkId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit findByCountryIdAndGroupIdAndFrameworkId_Last(
		long countryId, long groupId, long spFrameworkId,
		OrderByComparator orderByComparator)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = fetchByCountryIdAndGroupIdAndFrameworkId_Last(countryId,
				groupId, spFrameworkId, orderByComparator);

		if (competencyUnit != null) {
			return competencyUnit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", spFrameworkId=");
		msg.append(spFrameworkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the last competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching competency unit, or <code>null</code> if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByCountryIdAndGroupIdAndFrameworkId_Last(
		long countryId, long groupId, long spFrameworkId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountryIdAndGroupIdAndFrameworkId(countryId,
				groupId, spFrameworkId);

		if (count == 0) {
			return null;
		}

		List<CompetencyUnit> list = findByCountryIdAndGroupIdAndFrameworkId(countryId,
				groupId, spFrameworkId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the competency units before and after the current competency unit in the ordered set where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	 *
	 * @param spCompetencyUnitId the primary key of the current competency unit
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit[] findByCountryIdAndGroupIdAndFrameworkId_PrevAndNext(
		long spCompetencyUnitId, long countryId, long groupId,
		long spFrameworkId, OrderByComparator orderByComparator)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = findByPrimaryKey(spCompetencyUnitId);

		Session session = null;

		try {
			session = openSession();

			CompetencyUnit[] array = new CompetencyUnitImpl[3];

			array[0] = getByCountryIdAndGroupIdAndFrameworkId_PrevAndNext(session,
					competencyUnit, countryId, groupId, spFrameworkId,
					orderByComparator, true);

			array[1] = competencyUnit;

			array[2] = getByCountryIdAndGroupIdAndFrameworkId_PrevAndNext(session,
					competencyUnit, countryId, groupId, spFrameworkId,
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

	protected CompetencyUnit getByCountryIdAndGroupIdAndFrameworkId_PrevAndNext(
		Session session, CompetencyUnit competencyUnit, long countryId,
		long groupId, long spFrameworkId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPETENCYUNIT_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_COUNTRYID_2);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_GROUPID_2);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_SPFRAMEWORKID_2);

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
			query.append(CompetencyUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryId);

		qPos.add(groupId);

		qPos.add(spFrameworkId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(competencyUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CompetencyUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryIdAndGroupIdAndFrameworkId(long countryId,
		long groupId, long spFrameworkId) throws SystemException {
		for (CompetencyUnit competencyUnit : findByCountryIdAndGroupIdAndFrameworkId(
				countryId, groupId, spFrameworkId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(competencyUnit);
		}
	}

	/**
	 * Returns the number of competency units where countryId = &#63; and groupId = &#63; and spFrameworkId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param spFrameworkId the sp framework ID
	 * @return the number of matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryIdAndGroupIdAndFrameworkId(long countryId,
		long groupId, long spFrameworkId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID;

		Object[] finderArgs = new Object[] { countryId, groupId, spFrameworkId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_COMPETENCYUNIT_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_GROUPID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_SPFRAMEWORKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				qPos.add(spFrameworkId);

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

	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_COUNTRYID_2 =
		"competencyUnit.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_GROUPID_2 =
		"competencyUnit.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDFRAMEWORKID_SPFRAMEWORKID_2 =
		"competencyUnit.spFrameworkId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE = new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			CompetencyUnitImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCompetencyUnitCode",
			new String[] { String.class.getName() },
			CompetencyUnitModelImpl.COMPETENCYUNITCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPETENCYUNITCODE = new FinderPath(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompetencyUnitCode", new String[] { String.class.getName() });

	/**
	 * Returns the competency unit where competencyUnitCode = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCompetencyUnitException} if it could not be found.
	 *
	 * @param competencyUnitCode the competency unit code
	 * @return the matching competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit findByCompetencyUnitCode(String competencyUnitCode)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = fetchByCompetencyUnitCode(competencyUnitCode);

		if (competencyUnit == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("competencyUnitCode=");
			msg.append(competencyUnitCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCompetencyUnitException(msg.toString());
		}

		return competencyUnit;
	}

	/**
	 * Returns the competency unit where competencyUnitCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param competencyUnitCode the competency unit code
	 * @return the matching competency unit, or <code>null</code> if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByCompetencyUnitCode(String competencyUnitCode)
		throws SystemException {
		return fetchByCompetencyUnitCode(competencyUnitCode, true);
	}

	/**
	 * Returns the competency unit where competencyUnitCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param competencyUnitCode the competency unit code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching competency unit, or <code>null</code> if a matching competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByCompetencyUnitCode(String competencyUnitCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { competencyUnitCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE,
					finderArgs, this);
		}

		if (result instanceof CompetencyUnit) {
			CompetencyUnit competencyUnit = (CompetencyUnit)result;

			if (!Validator.equals(competencyUnitCode,
						competencyUnit.getCompetencyUnitCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COMPETENCYUNIT_WHERE);

			boolean bindCompetencyUnitCode = false;

			if (competencyUnitCode == null) {
				query.append(_FINDER_COLUMN_COMPETENCYUNITCODE_COMPETENCYUNITCODE_1);
			}
			else if (competencyUnitCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPETENCYUNITCODE_COMPETENCYUNITCODE_3);
			}
			else {
				bindCompetencyUnitCode = true;

				query.append(_FINDER_COLUMN_COMPETENCYUNITCODE_COMPETENCYUNITCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCompetencyUnitCode) {
					qPos.add(competencyUnitCode.toLowerCase());
				}

				List<CompetencyUnit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CompetencyUnitPersistenceImpl.fetchByCompetencyUnitCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CompetencyUnit competencyUnit = list.get(0);

					result = competencyUnit;

					cacheResult(competencyUnit);

					if ((competencyUnit.getCompetencyUnitCode() == null) ||
							!competencyUnit.getCompetencyUnitCode()
											   .equals(competencyUnitCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE,
							finderArgs, competencyUnit);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE,
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
			return (CompetencyUnit)result;
		}
	}

	/**
	 * Removes the competency unit where competencyUnitCode = &#63; from the database.
	 *
	 * @param competencyUnitCode the competency unit code
	 * @return the competency unit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit removeByCompetencyUnitCode(String competencyUnitCode)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = findByCompetencyUnitCode(competencyUnitCode);

		return remove(competencyUnit);
	}

	/**
	 * Returns the number of competency units where competencyUnitCode = &#63;.
	 *
	 * @param competencyUnitCode the competency unit code
	 * @return the number of matching competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompetencyUnitCode(String competencyUnitCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPETENCYUNITCODE;

		Object[] finderArgs = new Object[] { competencyUnitCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPETENCYUNIT_WHERE);

			boolean bindCompetencyUnitCode = false;

			if (competencyUnitCode == null) {
				query.append(_FINDER_COLUMN_COMPETENCYUNITCODE_COMPETENCYUNITCODE_1);
			}
			else if (competencyUnitCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPETENCYUNITCODE_COMPETENCYUNITCODE_3);
			}
			else {
				bindCompetencyUnitCode = true;

				query.append(_FINDER_COLUMN_COMPETENCYUNITCODE_COMPETENCYUNITCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCompetencyUnitCode) {
					qPos.add(competencyUnitCode.toLowerCase());
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

	private static final String _FINDER_COLUMN_COMPETENCYUNITCODE_COMPETENCYUNITCODE_1 =
		"competencyUnit.competencyUnitCode IS NULL";
	private static final String _FINDER_COLUMN_COMPETENCYUNITCODE_COMPETENCYUNITCODE_2 =
		"lower(competencyUnit.competencyUnitCode) = ?";
	private static final String _FINDER_COLUMN_COMPETENCYUNITCODE_COMPETENCYUNITCODE_3 =
		"(competencyUnit.competencyUnitCode IS NULL OR competencyUnit.competencyUnitCode = '')";

	public CompetencyUnitPersistenceImpl() {
		setModelClass(CompetencyUnit.class);
	}

	/**
	 * Caches the competency unit in the entity cache if it is enabled.
	 *
	 * @param competencyUnit the competency unit
	 */
	@Override
	public void cacheResult(CompetencyUnit competencyUnit) {
		EntityCacheUtil.putResult(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitImpl.class, competencyUnit.getPrimaryKey(),
			competencyUnit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE,
			new Object[] { competencyUnit.getCompetencyUnitCode() },
			competencyUnit);

		competencyUnit.resetOriginalValues();
	}

	/**
	 * Caches the competency units in the entity cache if it is enabled.
	 *
	 * @param competencyUnits the competency units
	 */
	@Override
	public void cacheResult(List<CompetencyUnit> competencyUnits) {
		for (CompetencyUnit competencyUnit : competencyUnits) {
			if (EntityCacheUtil.getResult(
						CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
						CompetencyUnitImpl.class, competencyUnit.getPrimaryKey()) == null) {
				cacheResult(competencyUnit);
			}
			else {
				competencyUnit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all competency units.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CompetencyUnitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CompetencyUnitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the competency unit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompetencyUnit competencyUnit) {
		EntityCacheUtil.removeResult(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitImpl.class, competencyUnit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(competencyUnit);
	}

	@Override
	public void clearCache(List<CompetencyUnit> competencyUnits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CompetencyUnit competencyUnit : competencyUnits) {
			EntityCacheUtil.removeResult(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
				CompetencyUnitImpl.class, competencyUnit.getPrimaryKey());

			clearUniqueFindersCache(competencyUnit);
		}
	}

	protected void cacheUniqueFindersCache(CompetencyUnit competencyUnit) {
		if (competencyUnit.isNew()) {
			Object[] args = new Object[] { competencyUnit.getCompetencyUnitCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPETENCYUNITCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE,
				args, competencyUnit);
		}
		else {
			CompetencyUnitModelImpl competencyUnitModelImpl = (CompetencyUnitModelImpl)competencyUnit;

			if ((competencyUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						competencyUnit.getCompetencyUnitCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPETENCYUNITCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE,
					args, competencyUnit);
			}
		}
	}

	protected void clearUniqueFindersCache(CompetencyUnit competencyUnit) {
		CompetencyUnitModelImpl competencyUnitModelImpl = (CompetencyUnitModelImpl)competencyUnit;

		Object[] args = new Object[] { competencyUnit.getCompetencyUnitCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPETENCYUNITCODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE,
			args);

		if ((competencyUnitModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					competencyUnitModelImpl.getOriginalCompetencyUnitCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPETENCYUNITCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPETENCYUNITCODE,
				args);
		}
	}

	/**
	 * Creates a new competency unit with the primary key. Does not add the competency unit to the database.
	 *
	 * @param spCompetencyUnitId the primary key for the new competency unit
	 * @return the new competency unit
	 */
	@Override
	public CompetencyUnit create(long spCompetencyUnitId) {
		CompetencyUnit competencyUnit = new CompetencyUnitImpl();

		competencyUnit.setNew(true);
		competencyUnit.setPrimaryKey(spCompetencyUnitId);

		return competencyUnit;
	}

	/**
	 * Removes the competency unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCompetencyUnitId the primary key of the competency unit
	 * @return the competency unit that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit remove(long spCompetencyUnitId)
		throws NoSuchCompetencyUnitException, SystemException {
		return remove((Serializable)spCompetencyUnitId);
	}

	/**
	 * Removes the competency unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the competency unit
	 * @return the competency unit that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit remove(Serializable primaryKey)
		throws NoSuchCompetencyUnitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CompetencyUnit competencyUnit = (CompetencyUnit)session.get(CompetencyUnitImpl.class,
					primaryKey);

			if (competencyUnit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompetencyUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(competencyUnit);
		}
		catch (NoSuchCompetencyUnitException nsee) {
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
	protected CompetencyUnit removeImpl(CompetencyUnit competencyUnit)
		throws SystemException {
		competencyUnit = toUnwrappedModel(competencyUnit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(competencyUnit)) {
				competencyUnit = (CompetencyUnit)session.get(CompetencyUnitImpl.class,
						competencyUnit.getPrimaryKeyObj());
			}

			if (competencyUnit != null) {
				session.delete(competencyUnit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (competencyUnit != null) {
			clearCache(competencyUnit);
		}

		return competencyUnit;
	}

	@Override
	public CompetencyUnit updateImpl(
		com.sambaash.platform.srv.model.CompetencyUnit competencyUnit)
		throws SystemException {
		competencyUnit = toUnwrappedModel(competencyUnit);

		boolean isNew = competencyUnit.isNew();

		CompetencyUnitModelImpl competencyUnitModelImpl = (CompetencyUnitModelImpl)competencyUnit;

		Session session = null;

		try {
			session = openSession();

			if (competencyUnit.isNew()) {
				session.save(competencyUnit);

				competencyUnit.setNew(false);
			}
			else {
				session.merge(competencyUnit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CompetencyUnitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((competencyUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						competencyUnitModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { competencyUnitModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((competencyUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						competencyUnitModelImpl.getOriginalCountryId(),
						competencyUnitModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);

				args = new Object[] {
						competencyUnitModelImpl.getCountryId(),
						competencyUnitModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);
			}

			if ((competencyUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						competencyUnitModelImpl.getOriginalCountryId(),
						competencyUnitModelImpl.getOriginalGroupId(),
						competencyUnitModelImpl.getOriginalSpFrameworkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID,
					args);

				args = new Object[] {
						competencyUnitModelImpl.getCountryId(),
						competencyUnitModelImpl.getGroupId(),
						competencyUnitModelImpl.getSpFrameworkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDFRAMEWORKID,
					args);
			}
		}

		EntityCacheUtil.putResult(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			CompetencyUnitImpl.class, competencyUnit.getPrimaryKey(),
			competencyUnit);

		clearUniqueFindersCache(competencyUnit);
		cacheUniqueFindersCache(competencyUnit);

		return competencyUnit;
	}

	protected CompetencyUnit toUnwrappedModel(CompetencyUnit competencyUnit) {
		if (competencyUnit instanceof CompetencyUnitImpl) {
			return competencyUnit;
		}

		CompetencyUnitImpl competencyUnitImpl = new CompetencyUnitImpl();

		competencyUnitImpl.setNew(competencyUnit.isNew());
		competencyUnitImpl.setPrimaryKey(competencyUnit.getPrimaryKey());

		competencyUnitImpl.setSpCompetencyUnitId(competencyUnit.getSpCompetencyUnitId());
		competencyUnitImpl.setGroupId(competencyUnit.getGroupId());
		competencyUnitImpl.setCompanyId(competencyUnit.getCompanyId());
		competencyUnitImpl.setUserId(competencyUnit.getUserId());
		competencyUnitImpl.setUserName(competencyUnit.getUserName());
		competencyUnitImpl.setCreateDate(competencyUnit.getCreateDate());
		competencyUnitImpl.setModifiedDate(competencyUnit.getModifiedDate());
		competencyUnitImpl.setCountryId(competencyUnit.getCountryId());
		competencyUnitImpl.setSpFrameworkId(competencyUnit.getSpFrameworkId());
		competencyUnitImpl.setCompetencyUnitCode(competencyUnit.getCompetencyUnitCode());
		competencyUnitImpl.setCompetencyUnitDesc(competencyUnit.getCompetencyUnitDesc());
		competencyUnitImpl.setJobFamily(competencyUnit.getJobFamily());
		competencyUnitImpl.setCompetencyLevel(competencyUnit.getCompetencyLevel());
		competencyUnitImpl.setCreditValue(competencyUnit.getCreditValue());

		return competencyUnitImpl;
	}

	/**
	 * Returns the competency unit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the competency unit
	 * @return the competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompetencyUnitException, SystemException {
		CompetencyUnit competencyUnit = fetchByPrimaryKey(primaryKey);

		if (competencyUnit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompetencyUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return competencyUnit;
	}

	/**
	 * Returns the competency unit with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCompetencyUnitException} if it could not be found.
	 *
	 * @param spCompetencyUnitId the primary key of the competency unit
	 * @return the competency unit
	 * @throws com.sambaash.platform.srv.NoSuchCompetencyUnitException if a competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit findByPrimaryKey(long spCompetencyUnitId)
		throws NoSuchCompetencyUnitException, SystemException {
		return findByPrimaryKey((Serializable)spCompetencyUnitId);
	}

	/**
	 * Returns the competency unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the competency unit
	 * @return the competency unit, or <code>null</code> if a competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CompetencyUnit competencyUnit = (CompetencyUnit)EntityCacheUtil.getResult(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
				CompetencyUnitImpl.class, primaryKey);

		if (competencyUnit == _nullCompetencyUnit) {
			return null;
		}

		if (competencyUnit == null) {
			Session session = null;

			try {
				session = openSession();

				competencyUnit = (CompetencyUnit)session.get(CompetencyUnitImpl.class,
						primaryKey);

				if (competencyUnit != null) {
					cacheResult(competencyUnit);
				}
				else {
					EntityCacheUtil.putResult(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
						CompetencyUnitImpl.class, primaryKey,
						_nullCompetencyUnit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
					CompetencyUnitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return competencyUnit;
	}

	/**
	 * Returns the competency unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCompetencyUnitId the primary key of the competency unit
	 * @return the competency unit, or <code>null</code> if a competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompetencyUnit fetchByPrimaryKey(long spCompetencyUnitId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCompetencyUnitId);
	}

	/**
	 * Returns all the competency units.
	 *
	 * @return the competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the competency units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of competency units
	 * @param end the upper bound of the range of competency units (not inclusive)
	 * @return the range of competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the competency units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of competency units
	 * @param end the upper bound of the range of competency units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompetencyUnit> findAll(int start, int end,
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

		List<CompetencyUnit> list = (List<CompetencyUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPETENCYUNIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPETENCYUNIT;

				if (pagination) {
					sql = sql.concat(CompetencyUnitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CompetencyUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompetencyUnit>(list);
				}
				else {
					list = (List<CompetencyUnit>)QueryUtil.list(q,
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
	 * Removes all the competency units from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CompetencyUnit competencyUnit : findAll()) {
			remove(competencyUnit);
		}
	}

	/**
	 * Returns the number of competency units.
	 *
	 * @return the number of competency units
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

				Query q = session.createQuery(_SQL_COUNT_COMPETENCYUNIT);

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
	 * Initializes the competency unit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CompetencyUnit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CompetencyUnit>> listenersList = new ArrayList<ModelListener<CompetencyUnit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CompetencyUnit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CompetencyUnitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMPETENCYUNIT = "SELECT competencyUnit FROM CompetencyUnit competencyUnit";
	private static final String _SQL_SELECT_COMPETENCYUNIT_WHERE = "SELECT competencyUnit FROM CompetencyUnit competencyUnit WHERE ";
	private static final String _SQL_COUNT_COMPETENCYUNIT = "SELECT COUNT(competencyUnit) FROM CompetencyUnit competencyUnit";
	private static final String _SQL_COUNT_COMPETENCYUNIT_WHERE = "SELECT COUNT(competencyUnit) FROM CompetencyUnit competencyUnit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "competencyUnit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CompetencyUnit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CompetencyUnit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CompetencyUnitPersistenceImpl.class);
	private static CompetencyUnit _nullCompetencyUnit = new CompetencyUnitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CompetencyUnit> toCacheModel() {
				return _nullCompetencyUnitCacheModel;
			}
		};

	private static CacheModel<CompetencyUnit> _nullCompetencyUnitCacheModel = new CacheModel<CompetencyUnit>() {
			@Override
			public CompetencyUnit toEntityModel() {
				return _nullCompetencyUnit;
			}
		};
}