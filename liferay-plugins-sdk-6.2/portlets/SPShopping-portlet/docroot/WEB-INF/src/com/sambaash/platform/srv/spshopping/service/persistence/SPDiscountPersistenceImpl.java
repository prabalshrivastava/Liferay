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

package com.sambaash.platform.srv.spshopping.service.persistence;

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

import com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException;
import com.sambaash.platform.srv.spshopping.model.SPDiscount;
import com.sambaash.platform.srv.spshopping.model.impl.SPDiscountImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p discount service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPDiscountPersistence
 * @see SPDiscountUtil
 * @generated
 */
public class SPDiscountPersistenceImpl extends BasePersistenceImpl<SPDiscount>
	implements SPDiscountPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPDiscountUtil} to access the s p discount persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPDiscountImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountModelImpl.FINDER_CACHE_ENABLED, SPDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountModelImpl.FINDER_CACHE_ENABLED, SPDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
		new FinderPath(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountModelImpl.FINDER_CACHE_ENABLED, SPDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypackageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
		new FinderPath(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountModelImpl.FINDER_CACHE_ENABLED, SPDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypackageId",
			new String[] { Long.class.getName() },
			SPDiscountModelImpl.PACKAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypackageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p discounts where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @return the matching s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPDiscount> findBypackageId(long packageId)
		throws SystemException {
		return findBypackageId(packageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the s p discounts where packageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param start the lower bound of the range of s p discounts
	 * @param end the upper bound of the range of s p discounts (not inclusive)
	 * @return the range of matching s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPDiscount> findBypackageId(long packageId, int start, int end)
		throws SystemException {
		return findBypackageId(packageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p discounts where packageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param start the lower bound of the range of s p discounts
	 * @param end the upper bound of the range of s p discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPDiscount> findBypackageId(long packageId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID;
			finderArgs = new Object[] { packageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID;
			finderArgs = new Object[] { packageId, start, end, orderByComparator };
		}

		List<SPDiscount> list = (List<SPDiscount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPDiscount spDiscount : list) {
				if ((packageId != spDiscount.getPackageId())) {
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

			query.append(_SQL_SELECT_SPDISCOUNT_WHERE);

			query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPDiscountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(packageId);

				if (!pagination) {
					list = (List<SPDiscount>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPDiscount>(list);
				}
				else {
					list = (List<SPDiscount>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p discount in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p discount
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a matching s p discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount findBypackageId_First(long packageId,
		OrderByComparator orderByComparator)
		throws NoSuchSPDiscountException, SystemException {
		SPDiscount spDiscount = fetchBypackageId_First(packageId,
				orderByComparator);

		if (spDiscount != null) {
			return spDiscount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("packageId=");
		msg.append(packageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPDiscountException(msg.toString());
	}

	/**
	 * Returns the first s p discount in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p discount, or <code>null</code> if a matching s p discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount fetchBypackageId_First(long packageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPDiscount> list = findBypackageId(packageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p discount in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p discount
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a matching s p discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount findBypackageId_Last(long packageId,
		OrderByComparator orderByComparator)
		throws NoSuchSPDiscountException, SystemException {
		SPDiscount spDiscount = fetchBypackageId_Last(packageId,
				orderByComparator);

		if (spDiscount != null) {
			return spDiscount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("packageId=");
		msg.append(packageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPDiscountException(msg.toString());
	}

	/**
	 * Returns the last s p discount in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p discount, or <code>null</code> if a matching s p discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount fetchBypackageId_Last(long packageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBypackageId(packageId);

		if (count == 0) {
			return null;
		}

		List<SPDiscount> list = findBypackageId(packageId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p discounts before and after the current s p discount in the ordered set where packageId = &#63;.
	 *
	 * @param spDiscountId the primary key of the current s p discount
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p discount
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount[] findBypackageId_PrevAndNext(long spDiscountId,
		long packageId, OrderByComparator orderByComparator)
		throws NoSuchSPDiscountException, SystemException {
		SPDiscount spDiscount = findByPrimaryKey(spDiscountId);

		Session session = null;

		try {
			session = openSession();

			SPDiscount[] array = new SPDiscountImpl[3];

			array[0] = getBypackageId_PrevAndNext(session, spDiscount,
					packageId, orderByComparator, true);

			array[1] = spDiscount;

			array[2] = getBypackageId_PrevAndNext(session, spDiscount,
					packageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPDiscount getBypackageId_PrevAndNext(Session session,
		SPDiscount spDiscount, long packageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPDISCOUNT_WHERE);

		query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);

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
			query.append(SPDiscountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(packageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spDiscount);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPDiscount> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p discounts where packageId = &#63; from the database.
	 *
	 * @param packageId the package ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypackageId(long packageId) throws SystemException {
		for (SPDiscount spDiscount : findBypackageId(packageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spDiscount);
		}
	}

	/**
	 * Returns the number of s p discounts where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @return the number of matching s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypackageId(long packageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEID;

		Object[] finderArgs = new Object[] { packageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPDISCOUNT_WHERE);

			query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(packageId);

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

	private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "spDiscount.packageId = ? AND  spDiscount.active = 1 ";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountModelImpl.FINDER_CACHE_ENABLED, SPDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByactive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountModelImpl.FINDER_CACHE_ENABLED, SPDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactive",
			new String[] { Boolean.class.getName() },
			SPDiscountModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the s p discounts where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPDiscount> findByactive(boolean active)
		throws SystemException {
		return findByactive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p discounts where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of s p discounts
	 * @param end the upper bound of the range of s p discounts (not inclusive)
	 * @return the range of matching s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPDiscount> findByactive(boolean active, int start, int end)
		throws SystemException {
		return findByactive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p discounts where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of s p discounts
	 * @param end the upper bound of the range of s p discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPDiscount> findByactive(boolean active, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active, start, end, orderByComparator };
		}

		List<SPDiscount> list = (List<SPDiscount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPDiscount spDiscount : list) {
				if ((active != spDiscount.getActive())) {
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

			query.append(_SQL_SELECT_SPDISCOUNT_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPDiscountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<SPDiscount>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPDiscount>(list);
				}
				else {
					list = (List<SPDiscount>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p discount in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p discount
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a matching s p discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount findByactive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchSPDiscountException, SystemException {
		SPDiscount spDiscount = fetchByactive_First(active, orderByComparator);

		if (spDiscount != null) {
			return spDiscount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPDiscountException(msg.toString());
	}

	/**
	 * Returns the first s p discount in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p discount, or <code>null</code> if a matching s p discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount fetchByactive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPDiscount> list = findByactive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p discount in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p discount
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a matching s p discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount findByactive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchSPDiscountException, SystemException {
		SPDiscount spDiscount = fetchByactive_Last(active, orderByComparator);

		if (spDiscount != null) {
			return spDiscount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPDiscountException(msg.toString());
	}

	/**
	 * Returns the last s p discount in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p discount, or <code>null</code> if a matching s p discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount fetchByactive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByactive(active);

		if (count == 0) {
			return null;
		}

		List<SPDiscount> list = findByactive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p discounts before and after the current s p discount in the ordered set where active = &#63;.
	 *
	 * @param spDiscountId the primary key of the current s p discount
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p discount
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount[] findByactive_PrevAndNext(long spDiscountId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchSPDiscountException, SystemException {
		SPDiscount spDiscount = findByPrimaryKey(spDiscountId);

		Session session = null;

		try {
			session = openSession();

			SPDiscount[] array = new SPDiscountImpl[3];

			array[0] = getByactive_PrevAndNext(session, spDiscount, active,
					orderByComparator, true);

			array[1] = spDiscount;

			array[2] = getByactive_PrevAndNext(session, spDiscount, active,
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

	protected SPDiscount getByactive_PrevAndNext(Session session,
		SPDiscount spDiscount, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPDISCOUNT_WHERE);

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

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
			query.append(SPDiscountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spDiscount);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPDiscount> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p discounts where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByactive(boolean active) throws SystemException {
		for (SPDiscount spDiscount : findByactive(active, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spDiscount);
		}
	}

	/**
	 * Returns the number of s p discounts where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByactive(boolean active) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVE;

		Object[] finderArgs = new Object[] { active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPDISCOUNT_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "spDiscount.active = ?";

	public SPDiscountPersistenceImpl() {
		setModelClass(SPDiscount.class);
	}

	/**
	 * Caches the s p discount in the entity cache if it is enabled.
	 *
	 * @param spDiscount the s p discount
	 */
	@Override
	public void cacheResult(SPDiscount spDiscount) {
		EntityCacheUtil.putResult(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountImpl.class, spDiscount.getPrimaryKey(), spDiscount);

		spDiscount.resetOriginalValues();
	}

	/**
	 * Caches the s p discounts in the entity cache if it is enabled.
	 *
	 * @param spDiscounts the s p discounts
	 */
	@Override
	public void cacheResult(List<SPDiscount> spDiscounts) {
		for (SPDiscount spDiscount : spDiscounts) {
			if (EntityCacheUtil.getResult(
						SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
						SPDiscountImpl.class, spDiscount.getPrimaryKey()) == null) {
				cacheResult(spDiscount);
			}
			else {
				spDiscount.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p discounts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPDiscountImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPDiscountImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p discount.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPDiscount spDiscount) {
		EntityCacheUtil.removeResult(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountImpl.class, spDiscount.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPDiscount> spDiscounts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPDiscount spDiscount : spDiscounts) {
			EntityCacheUtil.removeResult(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
				SPDiscountImpl.class, spDiscount.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p discount with the primary key. Does not add the s p discount to the database.
	 *
	 * @param spDiscountId the primary key for the new s p discount
	 * @return the new s p discount
	 */
	@Override
	public SPDiscount create(long spDiscountId) {
		SPDiscount spDiscount = new SPDiscountImpl();

		spDiscount.setNew(true);
		spDiscount.setPrimaryKey(spDiscountId);

		return spDiscount;
	}

	/**
	 * Removes the s p discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spDiscountId the primary key of the s p discount
	 * @return the s p discount that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount remove(long spDiscountId)
		throws NoSuchSPDiscountException, SystemException {
		return remove((Serializable)spDiscountId);
	}

	/**
	 * Removes the s p discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p discount
	 * @return the s p discount that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount remove(Serializable primaryKey)
		throws NoSuchSPDiscountException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPDiscount spDiscount = (SPDiscount)session.get(SPDiscountImpl.class,
					primaryKey);

			if (spDiscount == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPDiscountException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spDiscount);
		}
		catch (NoSuchSPDiscountException nsee) {
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
	protected SPDiscount removeImpl(SPDiscount spDiscount)
		throws SystemException {
		spDiscount = toUnwrappedModel(spDiscount);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spDiscount)) {
				spDiscount = (SPDiscount)session.get(SPDiscountImpl.class,
						spDiscount.getPrimaryKeyObj());
			}

			if (spDiscount != null) {
				session.delete(spDiscount);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spDiscount != null) {
			clearCache(spDiscount);
		}

		return spDiscount;
	}

	@Override
	public SPDiscount updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPDiscount spDiscount)
		throws SystemException {
		spDiscount = toUnwrappedModel(spDiscount);

		boolean isNew = spDiscount.isNew();

		SPDiscountModelImpl spDiscountModelImpl = (SPDiscountModelImpl)spDiscount;

		Session session = null;

		try {
			session = openSession();

			if (spDiscount.isNew()) {
				session.save(spDiscount);

				spDiscount.setNew(false);
			}
			else {
				session.merge(spDiscount);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPDiscountModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spDiscountModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spDiscountModelImpl.getOriginalPackageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
					args);

				args = new Object[] { spDiscountModelImpl.getPackageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
					args);
			}

			if ((spDiscountModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spDiscountModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { spDiscountModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
			SPDiscountImpl.class, spDiscount.getPrimaryKey(), spDiscount);

		return spDiscount;
	}

	protected SPDiscount toUnwrappedModel(SPDiscount spDiscount) {
		if (spDiscount instanceof SPDiscountImpl) {
			return spDiscount;
		}

		SPDiscountImpl spDiscountImpl = new SPDiscountImpl();

		spDiscountImpl.setNew(spDiscount.isNew());
		spDiscountImpl.setPrimaryKey(spDiscount.getPrimaryKey());

		spDiscountImpl.setSpDiscountId(spDiscount.getSpDiscountId());
		spDiscountImpl.setGroupId(spDiscount.getGroupId());
		spDiscountImpl.setTitle(spDiscount.getTitle());
		spDiscountImpl.setPercent(spDiscount.isPercent());
		spDiscountImpl.setPackageId(spDiscount.getPackageId());
		spDiscountImpl.setValue(spDiscount.getValue());
		spDiscountImpl.setCouponCode(spDiscount.getCouponCode());
		spDiscountImpl.setDescription(spDiscount.getDescription());
		spDiscountImpl.setStartDate(spDiscount.getStartDate());
		spDiscountImpl.setEndDate(spDiscount.getEndDate());
		spDiscountImpl.setMinQuantity(spDiscount.getMinQuantity());
		spDiscountImpl.setMaxQuantity(spDiscount.getMaxQuantity());
		spDiscountImpl.setActive(spDiscount.isActive());
		spDiscountImpl.setCompanyId(spDiscount.getCompanyId());
		spDiscountImpl.setUserId(spDiscount.getUserId());
		spDiscountImpl.setUserName(spDiscount.getUserName());
		spDiscountImpl.setCreateDate(spDiscount.getCreateDate());
		spDiscountImpl.setModifiedDate(spDiscount.getModifiedDate());

		return spDiscountImpl;
	}

	/**
	 * Returns the s p discount with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p discount
	 * @return the s p discount
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPDiscountException, SystemException {
		SPDiscount spDiscount = fetchByPrimaryKey(primaryKey);

		if (spDiscount == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPDiscountException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spDiscount;
	}

	/**
	 * Returns the s p discount with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException} if it could not be found.
	 *
	 * @param spDiscountId the primary key of the s p discount
	 * @return the s p discount
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPDiscountException if a s p discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount findByPrimaryKey(long spDiscountId)
		throws NoSuchSPDiscountException, SystemException {
		return findByPrimaryKey((Serializable)spDiscountId);
	}

	/**
	 * Returns the s p discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p discount
	 * @return the s p discount, or <code>null</code> if a s p discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPDiscount spDiscount = (SPDiscount)EntityCacheUtil.getResult(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
				SPDiscountImpl.class, primaryKey);

		if (spDiscount == _nullSPDiscount) {
			return null;
		}

		if (spDiscount == null) {
			Session session = null;

			try {
				session = openSession();

				spDiscount = (SPDiscount)session.get(SPDiscountImpl.class,
						primaryKey);

				if (spDiscount != null) {
					cacheResult(spDiscount);
				}
				else {
					EntityCacheUtil.putResult(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
						SPDiscountImpl.class, primaryKey, _nullSPDiscount);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPDiscountModelImpl.ENTITY_CACHE_ENABLED,
					SPDiscountImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spDiscount;
	}

	/**
	 * Returns the s p discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spDiscountId the primary key of the s p discount
	 * @return the s p discount, or <code>null</code> if a s p discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPDiscount fetchByPrimaryKey(long spDiscountId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spDiscountId);
	}

	/**
	 * Returns all the s p discounts.
	 *
	 * @return the s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPDiscount> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p discounts
	 * @param end the upper bound of the range of s p discounts (not inclusive)
	 * @return the range of s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPDiscount> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p discounts
	 * @param end the upper bound of the range of s p discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPDiscount> findAll(int start, int end,
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

		List<SPDiscount> list = (List<SPDiscount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPDISCOUNT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPDISCOUNT;

				if (pagination) {
					sql = sql.concat(SPDiscountModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPDiscount>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPDiscount>(list);
				}
				else {
					list = (List<SPDiscount>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p discounts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPDiscount spDiscount : findAll()) {
			remove(spDiscount);
		}
	}

	/**
	 * Returns the number of s p discounts.
	 *
	 * @return the number of s p discounts
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

				Query q = session.createQuery(_SQL_COUNT_SPDISCOUNT);

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
	 * Initializes the s p discount persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spshopping.model.SPDiscount")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPDiscount>> listenersList = new ArrayList<ModelListener<SPDiscount>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPDiscount>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPDiscountImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPDISCOUNT = "SELECT spDiscount FROM SPDiscount spDiscount";
	private static final String _SQL_SELECT_SPDISCOUNT_WHERE = "SELECT spDiscount FROM SPDiscount spDiscount WHERE ";
	private static final String _SQL_COUNT_SPDISCOUNT = "SELECT COUNT(spDiscount) FROM SPDiscount spDiscount";
	private static final String _SQL_COUNT_SPDISCOUNT_WHERE = "SELECT COUNT(spDiscount) FROM SPDiscount spDiscount WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spDiscount.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPDiscount exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPDiscount exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPDiscountPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static SPDiscount _nullSPDiscount = new SPDiscountImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPDiscount> toCacheModel() {
				return _nullSPDiscountCacheModel;
			}
		};

	private static CacheModel<SPDiscount> _nullSPDiscountCacheModel = new CacheModel<SPDiscount>() {
			@Override
			public SPDiscount toEntityModel() {
				return _nullSPDiscount;
			}
		};
}