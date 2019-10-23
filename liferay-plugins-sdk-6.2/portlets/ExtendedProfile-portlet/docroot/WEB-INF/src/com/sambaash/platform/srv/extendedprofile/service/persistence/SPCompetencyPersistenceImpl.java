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

package com.sambaash.platform.srv.extendedprofile.service.persistence;

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

import com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;
import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;
import com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyImpl;
import com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p competency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPCompetencyPersistence
 * @see SPCompetencyUtil
 * @generated
 */
public class SPCompetencyPersistenceImpl extends BasePersistenceImpl<SPCompetency>
	implements SPCompetencyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPCompetencyUtil} to access the s p competency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPCompetencyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, SPCompetencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, SPCompetencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPETENCYLISTBYJOBROLE =
		new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, SPCompetencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompetencyListByJobRole",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLISTBYJOBROLE =
		new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, SPCompetencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompetencyListByJobRole",
			new String[] { Long.class.getName() },
			SPCompetencyModelImpl.BELONGSTOJOBROLE_COLUMN_BITMASK |
			SPCompetencyModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPETENCYLISTBYJOBROLE = new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompetencyListByJobRole",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p competencies where belongsToJobRole = &#63;.
	 *
	 * @param belongsToJobRole the belongs to job role
	 * @return the matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole) throws SystemException {
		return findByCompetencyListByJobRole(belongsToJobRole,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p competencies where belongsToJobRole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param belongsToJobRole the belongs to job role
	 * @param start the lower bound of the range of s p competencies
	 * @param end the upper bound of the range of s p competencies (not inclusive)
	 * @return the range of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole, int start, int end) throws SystemException {
		return findByCompetencyListByJobRole(belongsToJobRole, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p competencies where belongsToJobRole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param belongsToJobRole the belongs to job role
	 * @param start the lower bound of the range of s p competencies
	 * @param end the upper bound of the range of s p competencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findByCompetencyListByJobRole(
		long belongsToJobRole, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLISTBYJOBROLE;
			finderArgs = new Object[] { belongsToJobRole };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPETENCYLISTBYJOBROLE;
			finderArgs = new Object[] {
					belongsToJobRole,
					
					start, end, orderByComparator
				};
		}

		List<SPCompetency> list = (List<SPCompetency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCompetency spCompetency : list) {
				if ((belongsToJobRole != spCompetency.getBelongsToJobRole())) {
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

			query.append(_SQL_SELECT_SPCOMPETENCY_WHERE);

			query.append(_FINDER_COLUMN_COMPETENCYLISTBYJOBROLE_BELONGSTOJOBROLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPCompetencyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(belongsToJobRole);

				if (!pagination) {
					list = (List<SPCompetency>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCompetency>(list);
				}
				else {
					list = (List<SPCompetency>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p competency in the ordered set where belongsToJobRole = &#63;.
	 *
	 * @param belongsToJobRole the belongs to job role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency findByCompetencyListByJobRole_First(
		long belongsToJobRole, OrderByComparator orderByComparator)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = fetchByCompetencyListByJobRole_First(belongsToJobRole,
				orderByComparator);

		if (spCompetency != null) {
			return spCompetency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("belongsToJobRole=");
		msg.append(belongsToJobRole);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCompetencyException(msg.toString());
	}

	/**
	 * Returns the first s p competency in the ordered set where belongsToJobRole = &#63;.
	 *
	 * @param belongsToJobRole the belongs to job role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p competency, or <code>null</code> if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByCompetencyListByJobRole_First(
		long belongsToJobRole, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPCompetency> list = findByCompetencyListByJobRole(belongsToJobRole,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p competency in the ordered set where belongsToJobRole = &#63;.
	 *
	 * @param belongsToJobRole the belongs to job role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency findByCompetencyListByJobRole_Last(
		long belongsToJobRole, OrderByComparator orderByComparator)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = fetchByCompetencyListByJobRole_Last(belongsToJobRole,
				orderByComparator);

		if (spCompetency != null) {
			return spCompetency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("belongsToJobRole=");
		msg.append(belongsToJobRole);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCompetencyException(msg.toString());
	}

	/**
	 * Returns the last s p competency in the ordered set where belongsToJobRole = &#63;.
	 *
	 * @param belongsToJobRole the belongs to job role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p competency, or <code>null</code> if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByCompetencyListByJobRole_Last(
		long belongsToJobRole, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompetencyListByJobRole(belongsToJobRole);

		if (count == 0) {
			return null;
		}

		List<SPCompetency> list = findByCompetencyListByJobRole(belongsToJobRole,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p competencies before and after the current s p competency in the ordered set where belongsToJobRole = &#63;.
	 *
	 * @param classpk the primary key of the current s p competency
	 * @param belongsToJobRole the belongs to job role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency[] findByCompetencyListByJobRole_PrevAndNext(
		long classpk, long belongsToJobRole, OrderByComparator orderByComparator)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = findByPrimaryKey(classpk);

		Session session = null;

		try {
			session = openSession();

			SPCompetency[] array = new SPCompetencyImpl[3];

			array[0] = getByCompetencyListByJobRole_PrevAndNext(session,
					spCompetency, belongsToJobRole, orderByComparator, true);

			array[1] = spCompetency;

			array[2] = getByCompetencyListByJobRole_PrevAndNext(session,
					spCompetency, belongsToJobRole, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPCompetency getByCompetencyListByJobRole_PrevAndNext(
		Session session, SPCompetency spCompetency, long belongsToJobRole,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCOMPETENCY_WHERE);

		query.append(_FINDER_COLUMN_COMPETENCYLISTBYJOBROLE_BELONGSTOJOBROLE_2);

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
			query.append(SPCompetencyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(belongsToJobRole);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spCompetency);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCompetency> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p competencies where belongsToJobRole = &#63; from the database.
	 *
	 * @param belongsToJobRole the belongs to job role
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompetencyListByJobRole(long belongsToJobRole)
		throws SystemException {
		for (SPCompetency spCompetency : findByCompetencyListByJobRole(
				belongsToJobRole, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spCompetency);
		}
	}

	/**
	 * Returns the number of s p competencies where belongsToJobRole = &#63;.
	 *
	 * @param belongsToJobRole the belongs to job role
	 * @return the number of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompetencyListByJobRole(long belongsToJobRole)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPETENCYLISTBYJOBROLE;

		Object[] finderArgs = new Object[] { belongsToJobRole };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPCOMPETENCY_WHERE);

			query.append(_FINDER_COLUMN_COMPETENCYLISTBYJOBROLE_BELONGSTOJOBROLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(belongsToJobRole);

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

	private static final String _FINDER_COLUMN_COMPETENCYLISTBYJOBROLE_BELONGSTOJOBROLE_2 =
		"spCompetency.belongsToJobRole = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPETENCYLIST =
		new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, SPCompetencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompetencyList",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLIST =
		new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, SPCompetencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompetencyList",
			new String[] { Long.class.getName() },
			SPCompetencyModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPETENCYLIST = new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompetencyList",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p competencies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findByCompetencyList(long userId)
		throws SystemException {
		return findByCompetencyList(userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p competencies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p competencies
	 * @param end the upper bound of the range of s p competencies (not inclusive)
	 * @return the range of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findByCompetencyList(long userId, int start,
		int end) throws SystemException {
		return findByCompetencyList(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p competencies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p competencies
	 * @param end the upper bound of the range of s p competencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findByCompetencyList(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLIST;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPETENCYLIST;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<SPCompetency> list = (List<SPCompetency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCompetency spCompetency : list) {
				if ((userId != spCompetency.getUserId())) {
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

			query.append(_SQL_SELECT_SPCOMPETENCY_WHERE);

			query.append(_FINDER_COLUMN_COMPETENCYLIST_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPCompetencyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPCompetency>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCompetency>(list);
				}
				else {
					list = (List<SPCompetency>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p competency in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency findByCompetencyList_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = fetchByCompetencyList_First(userId,
				orderByComparator);

		if (spCompetency != null) {
			return spCompetency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCompetencyException(msg.toString());
	}

	/**
	 * Returns the first s p competency in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p competency, or <code>null</code> if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByCompetencyList_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPCompetency> list = findByCompetencyList(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p competency in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency findByCompetencyList_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = fetchByCompetencyList_Last(userId,
				orderByComparator);

		if (spCompetency != null) {
			return spCompetency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCompetencyException(msg.toString());
	}

	/**
	 * Returns the last s p competency in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p competency, or <code>null</code> if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByCompetencyList_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompetencyList(userId);

		if (count == 0) {
			return null;
		}

		List<SPCompetency> list = findByCompetencyList(userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p competencies before and after the current s p competency in the ordered set where userId = &#63;.
	 *
	 * @param classpk the primary key of the current s p competency
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency[] findByCompetencyList_PrevAndNext(long classpk,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = findByPrimaryKey(classpk);

		Session session = null;

		try {
			session = openSession();

			SPCompetency[] array = new SPCompetencyImpl[3];

			array[0] = getByCompetencyList_PrevAndNext(session, spCompetency,
					userId, orderByComparator, true);

			array[1] = spCompetency;

			array[2] = getByCompetencyList_PrevAndNext(session, spCompetency,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPCompetency getByCompetencyList_PrevAndNext(Session session,
		SPCompetency spCompetency, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCOMPETENCY_WHERE);

		query.append(_FINDER_COLUMN_COMPETENCYLIST_USERID_2);

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
			query.append(SPCompetencyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spCompetency);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCompetency> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p competencies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompetencyList(long userId) throws SystemException {
		for (SPCompetency spCompetency : findByCompetencyList(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spCompetency);
		}
	}

	/**
	 * Returns the number of s p competencies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompetencyList(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPETENCYLIST;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPCOMPETENCY_WHERE);

			query.append(_FINDER_COLUMN_COMPETENCYLIST_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_COMPETENCYLIST_USERID_2 = "spCompetency.userId = ? AND spCompetency.belongsToJobRole = 0";
	public static final FinderPath FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID =
		new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, SPCompetencyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCategoryIdAndCompetencyId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPCompetencyModelImpl.USERID_COLUMN_BITMASK |
			SPCompetencyModelImpl.CATEGORYID_COLUMN_BITMASK |
			SPCompetencyModelImpl.COMPETENCYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYIDANDCOMPETENCYID =
		new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryIdAndCompetencyId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param competencyId the competency ID
	 * @return the matching s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency findByCategoryIdAndCompetencyId(long userId,
		long categoryId, long competencyId)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = fetchByCategoryIdAndCompetencyId(userId,
				categoryId, competencyId);

		if (spCompetency == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", categoryId=");
			msg.append(categoryId);

			msg.append(", competencyId=");
			msg.append(competencyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPCompetencyException(msg.toString());
		}

		return spCompetency;
	}

	/**
	 * Returns the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param competencyId the competency ID
	 * @return the matching s p competency, or <code>null</code> if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByCategoryIdAndCompetencyId(long userId,
		long categoryId, long competencyId) throws SystemException {
		return fetchByCategoryIdAndCompetencyId(userId, categoryId,
			competencyId, true);
	}

	/**
	 * Returns the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param competencyId the competency ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p competency, or <code>null</code> if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByCategoryIdAndCompetencyId(long userId,
		long categoryId, long competencyId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, categoryId, competencyId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID,
					finderArgs, this);
		}

		if (result instanceof SPCompetency) {
			SPCompetency spCompetency = (SPCompetency)result;

			if ((userId != spCompetency.getUserId()) ||
					(categoryId != spCompetency.getCategoryId()) ||
					(competencyId != spCompetency.getCompetencyId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SPCOMPETENCY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYIDANDCOMPETENCYID_USERID_2);

			query.append(_FINDER_COLUMN_CATEGORYIDANDCOMPETENCYID_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYIDANDCOMPETENCYID_COMPETENCYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(categoryId);

				qPos.add(competencyId);

				List<SPCompetency> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID,
						finderArgs, list);
				}
				else {
					SPCompetency spCompetency = list.get(0);

					result = spCompetency;

					cacheResult(spCompetency);

					if ((spCompetency.getUserId() != userId) ||
							(spCompetency.getCategoryId() != categoryId) ||
							(spCompetency.getCompetencyId() != competencyId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID,
							finderArgs, spCompetency);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID,
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
			return (SPCompetency)result;
		}
	}

	/**
	 * Removes the s p competency where userId = &#63; and categoryId = &#63; and competencyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param competencyId the competency ID
	 * @return the s p competency that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency removeByCategoryIdAndCompetencyId(long userId,
		long categoryId, long competencyId)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = findByCategoryIdAndCompetencyId(userId,
				categoryId, competencyId);

		return remove(spCompetency);
	}

	/**
	 * Returns the number of s p competencies where userId = &#63; and categoryId = &#63; and competencyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param competencyId the competency ID
	 * @return the number of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryIdAndCompetencyId(long userId, long categoryId,
		long competencyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYIDANDCOMPETENCYID;

		Object[] finderArgs = new Object[] { userId, categoryId, competencyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPCOMPETENCY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYIDANDCOMPETENCYID_USERID_2);

			query.append(_FINDER_COLUMN_CATEGORYIDANDCOMPETENCYID_CATEGORYID_2);

			query.append(_FINDER_COLUMN_CATEGORYIDANDCOMPETENCYID_COMPETENCYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(categoryId);

				qPos.add(competencyId);

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

	private static final String _FINDER_COLUMN_CATEGORYIDANDCOMPETENCYID_USERID_2 =
		"spCompetency.userId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYIDANDCOMPETENCYID_CATEGORYID_2 =
		"spCompetency.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYIDANDCOMPETENCYID_COMPETENCYID_2 =
		"spCompetency.competencyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, SPCompetencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, SPCompetencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPCompetencyModelImpl.USERID_COLUMN_BITMASK |
			SPCompetencyModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p competencies where userId = &#63; and categoryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @return the matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findByCategoryId(long userId, long categoryId)
		throws SystemException {
		return findByCategoryId(userId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p competencies where userId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of s p competencies
	 * @param end the upper bound of the range of s p competencies (not inclusive)
	 * @return the range of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findByCategoryId(long userId, long categoryId,
		int start, int end) throws SystemException {
		return findByCategoryId(userId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p competencies where userId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of s p competencies
	 * @param end the upper bound of the range of s p competencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findByCategoryId(long userId, long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { userId, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] {
					userId, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<SPCompetency> list = (List<SPCompetency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCompetency spCompetency : list) {
				if ((userId != spCompetency.getUserId()) ||
						(categoryId != spCompetency.getCategoryId())) {
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

			query.append(_SQL_SELECT_SPCOMPETENCY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_USERID_2);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPCompetencyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<SPCompetency>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCompetency>(list);
				}
				else {
					list = (List<SPCompetency>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency findByCategoryId_First(long userId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = fetchByCategoryId_First(userId, categoryId,
				orderByComparator);

		if (spCompetency != null) {
			return spCompetency;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCompetencyException(msg.toString());
	}

	/**
	 * Returns the first s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p competency, or <code>null</code> if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByCategoryId_First(long userId, long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPCompetency> list = findByCategoryId(userId, categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency findByCategoryId_Last(long userId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = fetchByCategoryId_Last(userId, categoryId,
				orderByComparator);

		if (spCompetency != null) {
			return spCompetency;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCompetencyException(msg.toString());
	}

	/**
	 * Returns the last s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p competency, or <code>null</code> if a matching s p competency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByCategoryId_Last(long userId, long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryId(userId, categoryId);

		if (count == 0) {
			return null;
		}

		List<SPCompetency> list = findByCategoryId(userId, categoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p competencies before and after the current s p competency in the ordered set where userId = &#63; and categoryId = &#63;.
	 *
	 * @param classpk the primary key of the current s p competency
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency[] findByCategoryId_PrevAndNext(long classpk,
		long userId, long categoryId, OrderByComparator orderByComparator)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = findByPrimaryKey(classpk);

		Session session = null;

		try {
			session = openSession();

			SPCompetency[] array = new SPCompetencyImpl[3];

			array[0] = getByCategoryId_PrevAndNext(session, spCompetency,
					userId, categoryId, orderByComparator, true);

			array[1] = spCompetency;

			array[2] = getByCategoryId_PrevAndNext(session, spCompetency,
					userId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPCompetency getByCategoryId_PrevAndNext(Session session,
		SPCompetency spCompetency, long userId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCOMPETENCY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_USERID_2);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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
			query.append(SPCompetencyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spCompetency);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCompetency> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p competencies where userId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryId(long userId, long categoryId)
		throws SystemException {
		for (SPCompetency spCompetency : findByCategoryId(userId, categoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spCompetency);
		}
	}

	/**
	 * Returns the number of s p competencies where userId = &#63; and categoryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param categoryId the category ID
	 * @return the number of matching s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryId(long userId, long categoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYID;

		Object[] finderArgs = new Object[] { userId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPCOMPETENCY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_USERID_2);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORYID_USERID_2 = "spCompetency.userId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "spCompetency.categoryId = ?";

	public SPCompetencyPersistenceImpl() {
		setModelClass(SPCompetency.class);
	}

	/**
	 * Caches the s p competency in the entity cache if it is enabled.
	 *
	 * @param spCompetency the s p competency
	 */
	@Override
	public void cacheResult(SPCompetency spCompetency) {
		EntityCacheUtil.putResult(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyImpl.class, spCompetency.getPrimaryKey(), spCompetency);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID,
			new Object[] {
				spCompetency.getUserId(), spCompetency.getCategoryId(),
				spCompetency.getCompetencyId()
			}, spCompetency);

		spCompetency.resetOriginalValues();
	}

	/**
	 * Caches the s p competencies in the entity cache if it is enabled.
	 *
	 * @param spCompetencies the s p competencies
	 */
	@Override
	public void cacheResult(List<SPCompetency> spCompetencies) {
		for (SPCompetency spCompetency : spCompetencies) {
			if (EntityCacheUtil.getResult(
						SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
						SPCompetencyImpl.class, spCompetency.getPrimaryKey()) == null) {
				cacheResult(spCompetency);
			}
			else {
				spCompetency.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p competencies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPCompetencyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPCompetencyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p competency.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPCompetency spCompetency) {
		EntityCacheUtil.removeResult(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyImpl.class, spCompetency.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spCompetency);
	}

	@Override
	public void clearCache(List<SPCompetency> spCompetencies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPCompetency spCompetency : spCompetencies) {
			EntityCacheUtil.removeResult(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
				SPCompetencyImpl.class, spCompetency.getPrimaryKey());

			clearUniqueFindersCache(spCompetency);
		}
	}

	protected void cacheUniqueFindersCache(SPCompetency spCompetency) {
		if (spCompetency.isNew()) {
			Object[] args = new Object[] {
					spCompetency.getUserId(), spCompetency.getCategoryId(),
					spCompetency.getCompetencyId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYIDANDCOMPETENCYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID,
				args, spCompetency);
		}
		else {
			SPCompetencyModelImpl spCompetencyModelImpl = (SPCompetencyModelImpl)spCompetency;

			if ((spCompetencyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCompetency.getUserId(), spCompetency.getCategoryId(),
						spCompetency.getCompetencyId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYIDANDCOMPETENCYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID,
					args, spCompetency);
			}
		}
	}

	protected void clearUniqueFindersCache(SPCompetency spCompetency) {
		SPCompetencyModelImpl spCompetencyModelImpl = (SPCompetencyModelImpl)spCompetency;

		Object[] args = new Object[] {
				spCompetency.getUserId(), spCompetency.getCategoryId(),
				spCompetency.getCompetencyId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYIDANDCOMPETENCYID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID,
			args);

		if ((spCompetencyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spCompetencyModelImpl.getOriginalUserId(),
					spCompetencyModelImpl.getOriginalCategoryId(),
					spCompetencyModelImpl.getOriginalCompetencyId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYIDANDCOMPETENCYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYIDANDCOMPETENCYID,
				args);
		}
	}

	/**
	 * Creates a new s p competency with the primary key. Does not add the s p competency to the database.
	 *
	 * @param classpk the primary key for the new s p competency
	 * @return the new s p competency
	 */
	@Override
	public SPCompetency create(long classpk) {
		SPCompetency spCompetency = new SPCompetencyImpl();

		spCompetency.setNew(true);
		spCompetency.setPrimaryKey(classpk);

		return spCompetency;
	}

	/**
	 * Removes the s p competency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param classpk the primary key of the s p competency
	 * @return the s p competency that was removed
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency remove(long classpk)
		throws NoSuchSPCompetencyException, SystemException {
		return remove((Serializable)classpk);
	}

	/**
	 * Removes the s p competency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p competency
	 * @return the s p competency that was removed
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency remove(Serializable primaryKey)
		throws NoSuchSPCompetencyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPCompetency spCompetency = (SPCompetency)session.get(SPCompetencyImpl.class,
					primaryKey);

			if (spCompetency == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPCompetencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spCompetency);
		}
		catch (NoSuchSPCompetencyException nsee) {
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
	protected SPCompetency removeImpl(SPCompetency spCompetency)
		throws SystemException {
		spCompetency = toUnwrappedModel(spCompetency);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spCompetency)) {
				spCompetency = (SPCompetency)session.get(SPCompetencyImpl.class,
						spCompetency.getPrimaryKeyObj());
			}

			if (spCompetency != null) {
				session.delete(spCompetency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spCompetency != null) {
			clearCache(spCompetency);
		}

		return spCompetency;
	}

	@Override
	public SPCompetency updateImpl(
		com.sambaash.platform.srv.extendedprofile.model.SPCompetency spCompetency)
		throws SystemException {
		spCompetency = toUnwrappedModel(spCompetency);

		boolean isNew = spCompetency.isNew();

		SPCompetencyModelImpl spCompetencyModelImpl = (SPCompetencyModelImpl)spCompetency;

		Session session = null;

		try {
			session = openSession();

			if (spCompetency.isNew()) {
				session.save(spCompetency);

				spCompetency.setNew(false);
			}
			else {
				session.merge(spCompetency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPCompetencyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spCompetencyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLISTBYJOBROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCompetencyModelImpl.getOriginalBelongsToJobRole()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPETENCYLISTBYJOBROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLISTBYJOBROLE,
					args);

				args = new Object[] { spCompetencyModelImpl.getBelongsToJobRole() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPETENCYLISTBYJOBROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLISTBYJOBROLE,
					args);
			}

			if ((spCompetencyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLIST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCompetencyModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPETENCYLIST,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLIST,
					args);

				args = new Object[] { spCompetencyModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPETENCYLIST,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYLIST,
					args);
			}

			if ((spCompetencyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCompetencyModelImpl.getOriginalUserId(),
						spCompetencyModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);

				args = new Object[] {
						spCompetencyModelImpl.getUserId(),
						spCompetencyModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
			SPCompetencyImpl.class, spCompetency.getPrimaryKey(), spCompetency);

		clearUniqueFindersCache(spCompetency);
		cacheUniqueFindersCache(spCompetency);

		return spCompetency;
	}

	protected SPCompetency toUnwrappedModel(SPCompetency spCompetency) {
		if (spCompetency instanceof SPCompetencyImpl) {
			return spCompetency;
		}

		SPCompetencyImpl spCompetencyImpl = new SPCompetencyImpl();

		spCompetencyImpl.setNew(spCompetency.isNew());
		spCompetencyImpl.setPrimaryKey(spCompetency.getPrimaryKey());

		spCompetencyImpl.setClasspk(spCompetency.getClasspk());
		spCompetencyImpl.setGroupId(spCompetency.getGroupId());
		spCompetencyImpl.setCompanyId(spCompetency.getCompanyId());
		spCompetencyImpl.setUserId(spCompetency.getUserId());
		spCompetencyImpl.setUserName(spCompetency.getUserName());
		spCompetencyImpl.setCreateDate(spCompetency.getCreateDate());
		spCompetencyImpl.setModifiedDate(spCompetency.getModifiedDate());
		spCompetencyImpl.setCategoryId(spCompetency.getCategoryId());
		spCompetencyImpl.setCompetencyId(spCompetency.getCompetencyId());
		spCompetencyImpl.setCompetencyLevelId(spCompetency.getCompetencyLevelId());
		spCompetencyImpl.setBelongsToJobRole(spCompetency.getBelongsToJobRole());
		spCompetencyImpl.setPublicView(spCompetency.isPublicView());

		return spCompetencyImpl;
	}

	/**
	 * Returns the s p competency with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p competency
	 * @return the s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPCompetencyException, SystemException {
		SPCompetency spCompetency = fetchByPrimaryKey(primaryKey);

		if (spCompetency == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPCompetencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spCompetency;
	}

	/**
	 * Returns the s p competency with the primary key or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException} if it could not be found.
	 *
	 * @param classpk the primary key of the s p competency
	 * @return the s p competency
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException if a s p competency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency findByPrimaryKey(long classpk)
		throws NoSuchSPCompetencyException, SystemException {
		return findByPrimaryKey((Serializable)classpk);
	}

	/**
	 * Returns the s p competency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p competency
	 * @return the s p competency, or <code>null</code> if a s p competency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPCompetency spCompetency = (SPCompetency)EntityCacheUtil.getResult(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
				SPCompetencyImpl.class, primaryKey);

		if (spCompetency == _nullSPCompetency) {
			return null;
		}

		if (spCompetency == null) {
			Session session = null;

			try {
				session = openSession();

				spCompetency = (SPCompetency)session.get(SPCompetencyImpl.class,
						primaryKey);

				if (spCompetency != null) {
					cacheResult(spCompetency);
				}
				else {
					EntityCacheUtil.putResult(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
						SPCompetencyImpl.class, primaryKey, _nullSPCompetency);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPCompetencyModelImpl.ENTITY_CACHE_ENABLED,
					SPCompetencyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spCompetency;
	}

	/**
	 * Returns the s p competency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param classpk the primary key of the s p competency
	 * @return the s p competency, or <code>null</code> if a s p competency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCompetency fetchByPrimaryKey(long classpk)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)classpk);
	}

	/**
	 * Returns all the s p competencies.
	 *
	 * @return the s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p competencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p competencies
	 * @param end the upper bound of the range of s p competencies (not inclusive)
	 * @return the range of s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p competencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCompetencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p competencies
	 * @param end the upper bound of the range of s p competencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p competencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCompetency> findAll(int start, int end,
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

		List<SPCompetency> list = (List<SPCompetency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCOMPETENCY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCOMPETENCY;

				if (pagination) {
					sql = sql.concat(SPCompetencyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPCompetency>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCompetency>(list);
				}
				else {
					list = (List<SPCompetency>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p competencies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPCompetency spCompetency : findAll()) {
			remove(spCompetency);
		}
	}

	/**
	 * Returns the number of s p competencies.
	 *
	 * @return the number of s p competencies
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

				Query q = session.createQuery(_SQL_COUNT_SPCOMPETENCY);

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
	 * Initializes the s p competency persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.extendedprofile.model.SPCompetency")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPCompetency>> listenersList = new ArrayList<ModelListener<SPCompetency>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPCompetency>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPCompetencyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCOMPETENCY = "SELECT spCompetency FROM SPCompetency spCompetency";
	private static final String _SQL_SELECT_SPCOMPETENCY_WHERE = "SELECT spCompetency FROM SPCompetency spCompetency WHERE ";
	private static final String _SQL_COUNT_SPCOMPETENCY = "SELECT COUNT(spCompetency) FROM SPCompetency spCompetency";
	private static final String _SQL_COUNT_SPCOMPETENCY_WHERE = "SELECT COUNT(spCompetency) FROM SPCompetency spCompetency WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spCompetency.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPCompetency exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPCompetency exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPCompetencyPersistenceImpl.class);
	private static SPCompetency _nullSPCompetency = new SPCompetencyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPCompetency> toCacheModel() {
				return _nullSPCompetencyCacheModel;
			}
		};

	private static CacheModel<SPCompetency> _nullSPCompetencyCacheModel = new CacheModel<SPCompetency>() {
			@Override
			public SPCompetency toEntityModel() {
				return _nullSPCompetency;
			}
		};
}