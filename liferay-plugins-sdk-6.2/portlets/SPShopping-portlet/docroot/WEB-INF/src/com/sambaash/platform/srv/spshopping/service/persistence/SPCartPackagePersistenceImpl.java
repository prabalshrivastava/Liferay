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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException;
import com.sambaash.platform.srv.spshopping.model.SPCartPackage;
import com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p cart package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPCartPackagePersistence
 * @see SPCartPackageUtil
 * @generated
 */
public class SPCartPackagePersistenceImpl extends BasePersistenceImpl<SPCartPackage>
	implements SPCartPackagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPCartPackageUtil} to access the s p cart package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPCartPackageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CARTID = new FinderPath(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycartId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID =
		new FinderPath(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycartId", new String[] { Long.class.getName() },
			SPCartPackageModelImpl.CARTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARTID = new FinderPath(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycartId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p cart packages where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @return the matching s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackage> findBycartId(long cartId)
		throws SystemException {
		return findBycartId(cartId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p cart packages where cartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cartId the cart ID
	 * @param start the lower bound of the range of s p cart packages
	 * @param end the upper bound of the range of s p cart packages (not inclusive)
	 * @return the range of matching s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackage> findBycartId(long cartId, int start, int end)
		throws SystemException {
		return findBycartId(cartId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p cart packages where cartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cartId the cart ID
	 * @param start the lower bound of the range of s p cart packages
	 * @param end the upper bound of the range of s p cart packages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackage> findBycartId(long cartId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID;
			finderArgs = new Object[] { cartId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CARTID;
			finderArgs = new Object[] { cartId, start, end, orderByComparator };
		}

		List<SPCartPackage> list = (List<SPCartPackage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCartPackage spCartPackage : list) {
				if ((cartId != spCartPackage.getCartId())) {
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

			query.append(_SQL_SELECT_SPCARTPACKAGE_WHERE);

			query.append(_FINDER_COLUMN_CARTID_CARTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPCartPackageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cartId);

				if (!pagination) {
					list = (List<SPCartPackage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCartPackage>(list);
				}
				else {
					list = (List<SPCartPackage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p cart package in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p cart package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a matching s p cart package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage findBycartId_First(long cartId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCartPackageException, SystemException {
		SPCartPackage spCartPackage = fetchBycartId_First(cartId,
				orderByComparator);

		if (spCartPackage != null) {
			return spCartPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cartId=");
		msg.append(cartId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCartPackageException(msg.toString());
	}

	/**
	 * Returns the first s p cart package in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p cart package, or <code>null</code> if a matching s p cart package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage fetchBycartId_First(long cartId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPCartPackage> list = findBycartId(cartId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p cart package in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p cart package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a matching s p cart package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage findBycartId_Last(long cartId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCartPackageException, SystemException {
		SPCartPackage spCartPackage = fetchBycartId_Last(cartId,
				orderByComparator);

		if (spCartPackage != null) {
			return spCartPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cartId=");
		msg.append(cartId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCartPackageException(msg.toString());
	}

	/**
	 * Returns the last s p cart package in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p cart package, or <code>null</code> if a matching s p cart package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage fetchBycartId_Last(long cartId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycartId(cartId);

		if (count == 0) {
			return null;
		}

		List<SPCartPackage> list = findBycartId(cartId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p cart packages before and after the current s p cart package in the ordered set where cartId = &#63;.
	 *
	 * @param spCartPackageId the primary key of the current s p cart package
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p cart package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage[] findBycartId_PrevAndNext(long spCartPackageId,
		long cartId, OrderByComparator orderByComparator)
		throws NoSuchSPCartPackageException, SystemException {
		SPCartPackage spCartPackage = findByPrimaryKey(spCartPackageId);

		Session session = null;

		try {
			session = openSession();

			SPCartPackage[] array = new SPCartPackageImpl[3];

			array[0] = getBycartId_PrevAndNext(session, spCartPackage, cartId,
					orderByComparator, true);

			array[1] = spCartPackage;

			array[2] = getBycartId_PrevAndNext(session, spCartPackage, cartId,
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

	protected SPCartPackage getBycartId_PrevAndNext(Session session,
		SPCartPackage spCartPackage, long cartId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCARTPACKAGE_WHERE);

		query.append(_FINDER_COLUMN_CARTID_CARTID_2);

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
			query.append(SPCartPackageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cartId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spCartPackage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCartPackage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p cart packages where cartId = &#63; from the database.
	 *
	 * @param cartId the cart ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycartId(long cartId) throws SystemException {
		for (SPCartPackage spCartPackage : findBycartId(cartId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spCartPackage);
		}
	}

	/**
	 * Returns the number of s p cart packages where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @return the number of matching s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycartId(long cartId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARTID;

		Object[] finderArgs = new Object[] { cartId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPCARTPACKAGE_WHERE);

			query.append(_FINDER_COLUMN_CARTID_CARTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cartId);

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

	private static final String _FINDER_COLUMN_CARTID_CARTID_2 = "spCartPackage.cartId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
		new FinderPath(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPackageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
		new FinderPath(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPackageId", new String[] { Long.class.getName() },
			SPCartPackageModelImpl.PACKAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p cart packages where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @return the matching s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackage> findByPackageId(long packageId)
		throws SystemException {
		return findByPackageId(packageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the s p cart packages where packageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param start the lower bound of the range of s p cart packages
	 * @param end the upper bound of the range of s p cart packages (not inclusive)
	 * @return the range of matching s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackage> findByPackageId(long packageId, int start,
		int end) throws SystemException {
		return findByPackageId(packageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p cart packages where packageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param start the lower bound of the range of s p cart packages
	 * @param end the upper bound of the range of s p cart packages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackage> findByPackageId(long packageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<SPCartPackage> list = (List<SPCartPackage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCartPackage spCartPackage : list) {
				if ((packageId != spCartPackage.getPackageId())) {
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

			query.append(_SQL_SELECT_SPCARTPACKAGE_WHERE);

			query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPCartPackageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(packageId);

				if (!pagination) {
					list = (List<SPCartPackage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCartPackage>(list);
				}
				else {
					list = (List<SPCartPackage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p cart package in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p cart package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a matching s p cart package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage findByPackageId_First(long packageId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCartPackageException, SystemException {
		SPCartPackage spCartPackage = fetchByPackageId_First(packageId,
				orderByComparator);

		if (spCartPackage != null) {
			return spCartPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("packageId=");
		msg.append(packageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCartPackageException(msg.toString());
	}

	/**
	 * Returns the first s p cart package in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p cart package, or <code>null</code> if a matching s p cart package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage fetchByPackageId_First(long packageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPCartPackage> list = findByPackageId(packageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p cart package in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p cart package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a matching s p cart package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage findByPackageId_Last(long packageId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCartPackageException, SystemException {
		SPCartPackage spCartPackage = fetchByPackageId_Last(packageId,
				orderByComparator);

		if (spCartPackage != null) {
			return spCartPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("packageId=");
		msg.append(packageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCartPackageException(msg.toString());
	}

	/**
	 * Returns the last s p cart package in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p cart package, or <code>null</code> if a matching s p cart package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage fetchByPackageId_Last(long packageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPackageId(packageId);

		if (count == 0) {
			return null;
		}

		List<SPCartPackage> list = findByPackageId(packageId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p cart packages before and after the current s p cart package in the ordered set where packageId = &#63;.
	 *
	 * @param spCartPackageId the primary key of the current s p cart package
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p cart package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage[] findByPackageId_PrevAndNext(long spCartPackageId,
		long packageId, OrderByComparator orderByComparator)
		throws NoSuchSPCartPackageException, SystemException {
		SPCartPackage spCartPackage = findByPrimaryKey(spCartPackageId);

		Session session = null;

		try {
			session = openSession();

			SPCartPackage[] array = new SPCartPackageImpl[3];

			array[0] = getByPackageId_PrevAndNext(session, spCartPackage,
					packageId, orderByComparator, true);

			array[1] = spCartPackage;

			array[2] = getByPackageId_PrevAndNext(session, spCartPackage,
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

	protected SPCartPackage getByPackageId_PrevAndNext(Session session,
		SPCartPackage spCartPackage, long packageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCARTPACKAGE_WHERE);

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
			query.append(SPCartPackageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(packageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spCartPackage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCartPackage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p cart packages where packageId = &#63; from the database.
	 *
	 * @param packageId the package ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPackageId(long packageId) throws SystemException {
		for (SPCartPackage spCartPackage : findByPackageId(packageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spCartPackage);
		}
	}

	/**
	 * Returns the number of s p cart packages where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @return the number of matching s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPackageId(long packageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEID;

		Object[] finderArgs = new Object[] { packageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPCARTPACKAGE_WHERE);

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

	private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "spCartPackage.packageId = ?";

	public SPCartPackagePersistenceImpl() {
		setModelClass(SPCartPackage.class);
	}

	/**
	 * Caches the s p cart package in the entity cache if it is enabled.
	 *
	 * @param spCartPackage the s p cart package
	 */
	@Override
	public void cacheResult(SPCartPackage spCartPackage) {
		EntityCacheUtil.putResult(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageImpl.class, spCartPackage.getPrimaryKey(),
			spCartPackage);

		spCartPackage.resetOriginalValues();
	}

	/**
	 * Caches the s p cart packages in the entity cache if it is enabled.
	 *
	 * @param spCartPackages the s p cart packages
	 */
	@Override
	public void cacheResult(List<SPCartPackage> spCartPackages) {
		for (SPCartPackage spCartPackage : spCartPackages) {
			if (EntityCacheUtil.getResult(
						SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
						SPCartPackageImpl.class, spCartPackage.getPrimaryKey()) == null) {
				cacheResult(spCartPackage);
			}
			else {
				spCartPackage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p cart packages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPCartPackageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPCartPackageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p cart package.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPCartPackage spCartPackage) {
		EntityCacheUtil.removeResult(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageImpl.class, spCartPackage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPCartPackage> spCartPackages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPCartPackage spCartPackage : spCartPackages) {
			EntityCacheUtil.removeResult(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
				SPCartPackageImpl.class, spCartPackage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p cart package with the primary key. Does not add the s p cart package to the database.
	 *
	 * @param spCartPackageId the primary key for the new s p cart package
	 * @return the new s p cart package
	 */
	@Override
	public SPCartPackage create(long spCartPackageId) {
		SPCartPackage spCartPackage = new SPCartPackageImpl();

		spCartPackage.setNew(true);
		spCartPackage.setPrimaryKey(spCartPackageId);

		return spCartPackage;
	}

	/**
	 * Removes the s p cart package with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCartPackageId the primary key of the s p cart package
	 * @return the s p cart package that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage remove(long spCartPackageId)
		throws NoSuchSPCartPackageException, SystemException {
		return remove((Serializable)spCartPackageId);
	}

	/**
	 * Removes the s p cart package with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p cart package
	 * @return the s p cart package that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage remove(Serializable primaryKey)
		throws NoSuchSPCartPackageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPCartPackage spCartPackage = (SPCartPackage)session.get(SPCartPackageImpl.class,
					primaryKey);

			if (spCartPackage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPCartPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spCartPackage);
		}
		catch (NoSuchSPCartPackageException nsee) {
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
	protected SPCartPackage removeImpl(SPCartPackage spCartPackage)
		throws SystemException {
		spCartPackage = toUnwrappedModel(spCartPackage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spCartPackage)) {
				spCartPackage = (SPCartPackage)session.get(SPCartPackageImpl.class,
						spCartPackage.getPrimaryKeyObj());
			}

			if (spCartPackage != null) {
				session.delete(spCartPackage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spCartPackage != null) {
			clearCache(spCartPackage);
		}

		return spCartPackage;
	}

	@Override
	public SPCartPackage updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPCartPackage spCartPackage)
		throws SystemException {
		spCartPackage = toUnwrappedModel(spCartPackage);

		boolean isNew = spCartPackage.isNew();

		SPCartPackageModelImpl spCartPackageModelImpl = (SPCartPackageModelImpl)spCartPackage;

		Session session = null;

		try {
			session = openSession();

			if (spCartPackage.isNew()) {
				session.save(spCartPackage);

				spCartPackage.setNew(false);
			}
			else {
				session.merge(spCartPackage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPCartPackageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spCartPackageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCartPackageModelImpl.getOriginalCartId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID,
					args);

				args = new Object[] { spCartPackageModelImpl.getCartId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID,
					args);
			}

			if ((spCartPackageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCartPackageModelImpl.getOriginalPackageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
					args);

				args = new Object[] { spCartPackageModelImpl.getPackageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageImpl.class, spCartPackage.getPrimaryKey(),
			spCartPackage);

		return spCartPackage;
	}

	protected SPCartPackage toUnwrappedModel(SPCartPackage spCartPackage) {
		if (spCartPackage instanceof SPCartPackageImpl) {
			return spCartPackage;
		}

		SPCartPackageImpl spCartPackageImpl = new SPCartPackageImpl();

		spCartPackageImpl.setNew(spCartPackage.isNew());
		spCartPackageImpl.setPrimaryKey(spCartPackage.getPrimaryKey());

		spCartPackageImpl.setSpCartPackageId(spCartPackage.getSpCartPackageId());
		spCartPackageImpl.setGroupId(spCartPackage.getGroupId());
		spCartPackageImpl.setCartId(spCartPackage.getCartId());
		spCartPackageImpl.setPackageId(spCartPackage.getPackageId());
		spCartPackageImpl.setSelectedCurrency(spCartPackage.getSelectedCurrency());
		spCartPackageImpl.setUsedDiscountRefId(spCartPackage.getUsedDiscountRefId());
		spCartPackageImpl.setUsedDiscountRefPCId(spCartPackage.getUsedDiscountRefPCId());
		spCartPackageImpl.setDiscount(spCartPackage.getDiscount());
		spCartPackageImpl.setInitialPrice(spCartPackage.getInitialPrice());
		spCartPackageImpl.setTotalPrice(spCartPackage.getTotalPrice());
		spCartPackageImpl.setRemarks(spCartPackage.getRemarks());
		spCartPackageImpl.setCompanyId(spCartPackage.getCompanyId());
		spCartPackageImpl.setUserId(spCartPackage.getUserId());
		spCartPackageImpl.setUserName(spCartPackage.getUserName());
		spCartPackageImpl.setCreateDate(spCartPackage.getCreateDate());
		spCartPackageImpl.setModifiedDate(spCartPackage.getModifiedDate());

		return spCartPackageImpl;
	}

	/**
	 * Returns the s p cart package with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p cart package
	 * @return the s p cart package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPCartPackageException, SystemException {
		SPCartPackage spCartPackage = fetchByPrimaryKey(primaryKey);

		if (spCartPackage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPCartPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spCartPackage;
	}

	/**
	 * Returns the s p cart package with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException} if it could not be found.
	 *
	 * @param spCartPackageId the primary key of the s p cart package
	 * @return the s p cart package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageException if a s p cart package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage findByPrimaryKey(long spCartPackageId)
		throws NoSuchSPCartPackageException, SystemException {
		return findByPrimaryKey((Serializable)spCartPackageId);
	}

	/**
	 * Returns the s p cart package with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p cart package
	 * @return the s p cart package, or <code>null</code> if a s p cart package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPCartPackage spCartPackage = (SPCartPackage)EntityCacheUtil.getResult(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
				SPCartPackageImpl.class, primaryKey);

		if (spCartPackage == _nullSPCartPackage) {
			return null;
		}

		if (spCartPackage == null) {
			Session session = null;

			try {
				session = openSession();

				spCartPackage = (SPCartPackage)session.get(SPCartPackageImpl.class,
						primaryKey);

				if (spCartPackage != null) {
					cacheResult(spCartPackage);
				}
				else {
					EntityCacheUtil.putResult(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
						SPCartPackageImpl.class, primaryKey, _nullSPCartPackage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPCartPackageModelImpl.ENTITY_CACHE_ENABLED,
					SPCartPackageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spCartPackage;
	}

	/**
	 * Returns the s p cart package with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCartPackageId the primary key of the s p cart package
	 * @return the s p cart package, or <code>null</code> if a s p cart package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackage fetchByPrimaryKey(long spCartPackageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCartPackageId);
	}

	/**
	 * Returns all the s p cart packages.
	 *
	 * @return the s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p cart packages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p cart packages
	 * @param end the upper bound of the range of s p cart packages (not inclusive)
	 * @return the range of s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p cart packages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p cart packages
	 * @param end the upper bound of the range of s p cart packages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p cart packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackage> findAll(int start, int end,
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

		List<SPCartPackage> list = (List<SPCartPackage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCARTPACKAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCARTPACKAGE;

				if (pagination) {
					sql = sql.concat(SPCartPackageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPCartPackage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCartPackage>(list);
				}
				else {
					list = (List<SPCartPackage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p cart packages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPCartPackage spCartPackage : findAll()) {
			remove(spCartPackage);
		}
	}

	/**
	 * Returns the number of s p cart packages.
	 *
	 * @return the number of s p cart packages
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

				Query q = session.createQuery(_SQL_COUNT_SPCARTPACKAGE);

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
	 * Initializes the s p cart package persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spshopping.model.SPCartPackage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPCartPackage>> listenersList = new ArrayList<ModelListener<SPCartPackage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPCartPackage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPCartPackageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCARTPACKAGE = "SELECT spCartPackage FROM SPCartPackage spCartPackage";
	private static final String _SQL_SELECT_SPCARTPACKAGE_WHERE = "SELECT spCartPackage FROM SPCartPackage spCartPackage WHERE ";
	private static final String _SQL_COUNT_SPCARTPACKAGE = "SELECT COUNT(spCartPackage) FROM SPCartPackage spCartPackage";
	private static final String _SQL_COUNT_SPCARTPACKAGE_WHERE = "SELECT COUNT(spCartPackage) FROM SPCartPackage spCartPackage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spCartPackage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPCartPackage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPCartPackage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPCartPackagePersistenceImpl.class);
	private static SPCartPackage _nullSPCartPackage = new SPCartPackageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPCartPackage> toCacheModel() {
				return _nullSPCartPackageCacheModel;
			}
		};

	private static CacheModel<SPCartPackage> _nullSPCartPackageCacheModel = new CacheModel<SPCartPackage>() {
			@Override
			public SPCartPackage toEntityModel() {
				return _nullSPCartPackage;
			}
		};
}