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

import com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException;
import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p selling price service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPSellingPricePersistence
 * @see SPSellingPriceUtil
 * @generated
 */
public class SPSellingPricePersistenceImpl extends BasePersistenceImpl<SPSellingPrice>
	implements SPSellingPricePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPSellingPriceUtil} to access the s p selling price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPSellingPriceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceModelImpl.FINDER_CACHE_ENABLED,
			SPSellingPriceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceModelImpl.FINDER_CACHE_ENABLED,
			SPSellingPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SELLINGITEMID =
		new FinderPath(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceModelImpl.FINDER_CACHE_ENABLED,
			SPSellingPriceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBysellingItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELLINGITEMID =
		new FinderPath(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceModelImpl.FINDER_CACHE_ENABLED,
			SPSellingPriceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysellingItemId",
			new String[] { Long.class.getName() },
			SPSellingPriceModelImpl.PRICEREFID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SELLINGITEMID = new FinderPath(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysellingItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p selling prices where priceRefId = &#63;.
	 *
	 * @param priceRefId the price ref ID
	 * @return the matching s p selling prices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPrice> findBysellingItemId(long priceRefId)
		throws SystemException {
		return findBysellingItemId(priceRefId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p selling prices where priceRefId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param priceRefId the price ref ID
	 * @param start the lower bound of the range of s p selling prices
	 * @param end the upper bound of the range of s p selling prices (not inclusive)
	 * @return the range of matching s p selling prices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPrice> findBysellingItemId(long priceRefId, int start,
		int end) throws SystemException {
		return findBysellingItemId(priceRefId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p selling prices where priceRefId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param priceRefId the price ref ID
	 * @param start the lower bound of the range of s p selling prices
	 * @param end the upper bound of the range of s p selling prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p selling prices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPrice> findBysellingItemId(long priceRefId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELLINGITEMID;
			finderArgs = new Object[] { priceRefId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SELLINGITEMID;
			finderArgs = new Object[] { priceRefId, start, end, orderByComparator };
		}

		List<SPSellingPrice> list = (List<SPSellingPrice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSellingPrice spSellingPrice : list) {
				if ((priceRefId != spSellingPrice.getPriceRefId())) {
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

			query.append(_SQL_SELECT_SPSELLINGPRICE_WHERE);

			query.append(_FINDER_COLUMN_SELLINGITEMID_PRICEREFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSellingPriceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priceRefId);

				if (!pagination) {
					list = (List<SPSellingPrice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSellingPrice>(list);
				}
				else {
					list = (List<SPSellingPrice>)QueryUtil.list(q,
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
	 * Returns the first s p selling price in the ordered set where priceRefId = &#63;.
	 *
	 * @param priceRefId the price ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p selling price
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a matching s p selling price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice findBysellingItemId_First(long priceRefId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSellingPriceException, SystemException {
		SPSellingPrice spSellingPrice = fetchBysellingItemId_First(priceRefId,
				orderByComparator);

		if (spSellingPrice != null) {
			return spSellingPrice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("priceRefId=");
		msg.append(priceRefId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSellingPriceException(msg.toString());
	}

	/**
	 * Returns the first s p selling price in the ordered set where priceRefId = &#63;.
	 *
	 * @param priceRefId the price ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice fetchBysellingItemId_First(long priceRefId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSellingPrice> list = findBysellingItemId(priceRefId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p selling price in the ordered set where priceRefId = &#63;.
	 *
	 * @param priceRefId the price ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p selling price
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a matching s p selling price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice findBysellingItemId_Last(long priceRefId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSellingPriceException, SystemException {
		SPSellingPrice spSellingPrice = fetchBysellingItemId_Last(priceRefId,
				orderByComparator);

		if (spSellingPrice != null) {
			return spSellingPrice;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("priceRefId=");
		msg.append(priceRefId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSellingPriceException(msg.toString());
	}

	/**
	 * Returns the last s p selling price in the ordered set where priceRefId = &#63;.
	 *
	 * @param priceRefId the price ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice fetchBysellingItemId_Last(long priceRefId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBysellingItemId(priceRefId);

		if (count == 0) {
			return null;
		}

		List<SPSellingPrice> list = findBysellingItemId(priceRefId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p selling prices before and after the current s p selling price in the ordered set where priceRefId = &#63;.
	 *
	 * @param spSellingPriceId the primary key of the current s p selling price
	 * @param priceRefId the price ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p selling price
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice[] findBysellingItemId_PrevAndNext(
		long spSellingPriceId, long priceRefId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSellingPriceException, SystemException {
		SPSellingPrice spSellingPrice = findByPrimaryKey(spSellingPriceId);

		Session session = null;

		try {
			session = openSession();

			SPSellingPrice[] array = new SPSellingPriceImpl[3];

			array[0] = getBysellingItemId_PrevAndNext(session, spSellingPrice,
					priceRefId, orderByComparator, true);

			array[1] = spSellingPrice;

			array[2] = getBysellingItemId_PrevAndNext(session, spSellingPrice,
					priceRefId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSellingPrice getBysellingItemId_PrevAndNext(Session session,
		SPSellingPrice spSellingPrice, long priceRefId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSELLINGPRICE_WHERE);

		query.append(_FINDER_COLUMN_SELLINGITEMID_PRICEREFID_2);

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
			query.append(SPSellingPriceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(priceRefId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSellingPrice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSellingPrice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p selling prices where priceRefId = &#63; from the database.
	 *
	 * @param priceRefId the price ref ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysellingItemId(long priceRefId)
		throws SystemException {
		for (SPSellingPrice spSellingPrice : findBysellingItemId(priceRefId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSellingPrice);
		}
	}

	/**
	 * Returns the number of s p selling prices where priceRefId = &#63;.
	 *
	 * @param priceRefId the price ref ID
	 * @return the number of matching s p selling prices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysellingItemId(long priceRefId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SELLINGITEMID;

		Object[] finderArgs = new Object[] { priceRefId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSELLINGPRICE_WHERE);

			query.append(_FINDER_COLUMN_SELLINGITEMID_PRICEREFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priceRefId);

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

	private static final String _FINDER_COLUMN_SELLINGITEMID_PRICEREFID_2 = "spSellingPrice.priceRefId = ? AND spSellingPrice.priceRefTypeId = 1";
	public static final FinderPath FINDER_PATH_FETCH_BY_SELLINGPACKAGEID = new FinderPath(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceModelImpl.FINDER_CACHE_ENABLED,
			SPSellingPriceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBysellingPackageId", new String[] { Long.class.getName() },
			SPSellingPriceModelImpl.PRICEREFID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SELLINGPACKAGEID = new FinderPath(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysellingPackageId", new String[] { Long.class.getName() });

	/**
	 * Returns the s p selling price where priceRefId = &#63; or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException} if it could not be found.
	 *
	 * @param priceRefId the price ref ID
	 * @return the matching s p selling price
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a matching s p selling price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice findBysellingPackageId(long priceRefId)
		throws NoSuchSPSellingPriceException, SystemException {
		SPSellingPrice spSellingPrice = fetchBysellingPackageId(priceRefId);

		if (spSellingPrice == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("priceRefId=");
			msg.append(priceRefId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPSellingPriceException(msg.toString());
		}

		return spSellingPrice;
	}

	/**
	 * Returns the s p selling price where priceRefId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param priceRefId the price ref ID
	 * @return the matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice fetchBysellingPackageId(long priceRefId)
		throws SystemException {
		return fetchBysellingPackageId(priceRefId, true);
	}

	/**
	 * Returns the s p selling price where priceRefId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param priceRefId the price ref ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p selling price, or <code>null</code> if a matching s p selling price could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice fetchBysellingPackageId(long priceRefId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { priceRefId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SELLINGPACKAGEID,
					finderArgs, this);
		}

		if (result instanceof SPSellingPrice) {
			SPSellingPrice spSellingPrice = (SPSellingPrice)result;

			if ((priceRefId != spSellingPrice.getPriceRefId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPSELLINGPRICE_WHERE);

			query.append(_FINDER_COLUMN_SELLINGPACKAGEID_PRICEREFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priceRefId);

				List<SPSellingPrice> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELLINGPACKAGEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPSellingPricePersistenceImpl.fetchBysellingPackageId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPSellingPrice spSellingPrice = list.get(0);

					result = spSellingPrice;

					cacheResult(spSellingPrice);

					if ((spSellingPrice.getPriceRefId() != priceRefId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELLINGPACKAGEID,
							finderArgs, spSellingPrice);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SELLINGPACKAGEID,
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
			return (SPSellingPrice)result;
		}
	}

	/**
	 * Removes the s p selling price where priceRefId = &#63; from the database.
	 *
	 * @param priceRefId the price ref ID
	 * @return the s p selling price that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice removeBysellingPackageId(long priceRefId)
		throws NoSuchSPSellingPriceException, SystemException {
		SPSellingPrice spSellingPrice = findBysellingPackageId(priceRefId);

		return remove(spSellingPrice);
	}

	/**
	 * Returns the number of s p selling prices where priceRefId = &#63;.
	 *
	 * @param priceRefId the price ref ID
	 * @return the number of matching s p selling prices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysellingPackageId(long priceRefId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SELLINGPACKAGEID;

		Object[] finderArgs = new Object[] { priceRefId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSELLINGPRICE_WHERE);

			query.append(_FINDER_COLUMN_SELLINGPACKAGEID_PRICEREFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(priceRefId);

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

	private static final String _FINDER_COLUMN_SELLINGPACKAGEID_PRICEREFID_2 = "spSellingPrice.priceRefId = ? AND spSellingPrice.priceRefTypeId = 2";

	public SPSellingPricePersistenceImpl() {
		setModelClass(SPSellingPrice.class);
	}

	/**
	 * Caches the s p selling price in the entity cache if it is enabled.
	 *
	 * @param spSellingPrice the s p selling price
	 */
	@Override
	public void cacheResult(SPSellingPrice spSellingPrice) {
		EntityCacheUtil.putResult(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceImpl.class, spSellingPrice.getPrimaryKey(),
			spSellingPrice);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELLINGPACKAGEID,
			new Object[] { spSellingPrice.getPriceRefId() }, spSellingPrice);

		spSellingPrice.resetOriginalValues();
	}

	/**
	 * Caches the s p selling prices in the entity cache if it is enabled.
	 *
	 * @param spSellingPrices the s p selling prices
	 */
	@Override
	public void cacheResult(List<SPSellingPrice> spSellingPrices) {
		for (SPSellingPrice spSellingPrice : spSellingPrices) {
			if (EntityCacheUtil.getResult(
						SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
						SPSellingPriceImpl.class, spSellingPrice.getPrimaryKey()) == null) {
				cacheResult(spSellingPrice);
			}
			else {
				spSellingPrice.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p selling prices.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPSellingPriceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPSellingPriceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p selling price.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPSellingPrice spSellingPrice) {
		EntityCacheUtil.removeResult(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceImpl.class, spSellingPrice.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spSellingPrice);
	}

	@Override
	public void clearCache(List<SPSellingPrice> spSellingPrices) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPSellingPrice spSellingPrice : spSellingPrices) {
			EntityCacheUtil.removeResult(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
				SPSellingPriceImpl.class, spSellingPrice.getPrimaryKey());

			clearUniqueFindersCache(spSellingPrice);
		}
	}

	protected void cacheUniqueFindersCache(SPSellingPrice spSellingPrice) {
		if (spSellingPrice.isNew()) {
			Object[] args = new Object[] { spSellingPrice.getPriceRefId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SELLINGPACKAGEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELLINGPACKAGEID,
				args, spSellingPrice);
		}
		else {
			SPSellingPriceModelImpl spSellingPriceModelImpl = (SPSellingPriceModelImpl)spSellingPrice;

			if ((spSellingPriceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SELLINGPACKAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spSellingPrice.getPriceRefId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SELLINGPACKAGEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELLINGPACKAGEID,
					args, spSellingPrice);
			}
		}
	}

	protected void clearUniqueFindersCache(SPSellingPrice spSellingPrice) {
		SPSellingPriceModelImpl spSellingPriceModelImpl = (SPSellingPriceModelImpl)spSellingPrice;

		Object[] args = new Object[] { spSellingPrice.getPriceRefId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELLINGPACKAGEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SELLINGPACKAGEID, args);

		if ((spSellingPriceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SELLINGPACKAGEID.getColumnBitmask()) != 0) {
			args = new Object[] { spSellingPriceModelImpl.getOriginalPriceRefId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELLINGPACKAGEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SELLINGPACKAGEID,
				args);
		}
	}

	/**
	 * Creates a new s p selling price with the primary key. Does not add the s p selling price to the database.
	 *
	 * @param spSellingPriceId the primary key for the new s p selling price
	 * @return the new s p selling price
	 */
	@Override
	public SPSellingPrice create(long spSellingPriceId) {
		SPSellingPrice spSellingPrice = new SPSellingPriceImpl();

		spSellingPrice.setNew(true);
		spSellingPrice.setPrimaryKey(spSellingPriceId);

		return spSellingPrice;
	}

	/**
	 * Removes the s p selling price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spSellingPriceId the primary key of the s p selling price
	 * @return the s p selling price that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice remove(long spSellingPriceId)
		throws NoSuchSPSellingPriceException, SystemException {
		return remove((Serializable)spSellingPriceId);
	}

	/**
	 * Removes the s p selling price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p selling price
	 * @return the s p selling price that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice remove(Serializable primaryKey)
		throws NoSuchSPSellingPriceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPSellingPrice spSellingPrice = (SPSellingPrice)session.get(SPSellingPriceImpl.class,
					primaryKey);

			if (spSellingPrice == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPSellingPriceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spSellingPrice);
		}
		catch (NoSuchSPSellingPriceException nsee) {
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
	protected SPSellingPrice removeImpl(SPSellingPrice spSellingPrice)
		throws SystemException {
		spSellingPrice = toUnwrappedModel(spSellingPrice);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spSellingPrice)) {
				spSellingPrice = (SPSellingPrice)session.get(SPSellingPriceImpl.class,
						spSellingPrice.getPrimaryKeyObj());
			}

			if (spSellingPrice != null) {
				session.delete(spSellingPrice);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spSellingPrice != null) {
			clearCache(spSellingPrice);
		}

		return spSellingPrice;
	}

	@Override
	public SPSellingPrice updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice)
		throws SystemException {
		spSellingPrice = toUnwrappedModel(spSellingPrice);

		boolean isNew = spSellingPrice.isNew();

		SPSellingPriceModelImpl spSellingPriceModelImpl = (SPSellingPriceModelImpl)spSellingPrice;

		Session session = null;

		try {
			session = openSession();

			if (spSellingPrice.isNew()) {
				session.save(spSellingPrice);

				spSellingPrice.setNew(false);
			}
			else {
				session.merge(spSellingPrice);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPSellingPriceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spSellingPriceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELLINGITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSellingPriceModelImpl.getOriginalPriceRefId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELLINGITEMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELLINGITEMID,
					args);

				args = new Object[] { spSellingPriceModelImpl.getPriceRefId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELLINGITEMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELLINGITEMID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPriceImpl.class, spSellingPrice.getPrimaryKey(),
			spSellingPrice);

		clearUniqueFindersCache(spSellingPrice);
		cacheUniqueFindersCache(spSellingPrice);

		return spSellingPrice;
	}

	protected SPSellingPrice toUnwrappedModel(SPSellingPrice spSellingPrice) {
		if (spSellingPrice instanceof SPSellingPriceImpl) {
			return spSellingPrice;
		}

		SPSellingPriceImpl spSellingPriceImpl = new SPSellingPriceImpl();

		spSellingPriceImpl.setNew(spSellingPrice.isNew());
		spSellingPriceImpl.setPrimaryKey(spSellingPrice.getPrimaryKey());

		spSellingPriceImpl.setSpSellingPriceId(spSellingPrice.getSpSellingPriceId());
		spSellingPriceImpl.setGroupId(spSellingPrice.getGroupId());
		spSellingPriceImpl.setPriceRefId(spSellingPrice.getPriceRefId());
		spSellingPriceImpl.setPriceRefTypeId(spSellingPrice.getPriceRefTypeId());
		spSellingPriceImpl.setCurrencyCode(spSellingPrice.getCurrencyCode());
		spSellingPriceImpl.setBasePrice(spSellingPrice.getBasePrice());
		spSellingPriceImpl.setTaxName(spSellingPrice.getTaxName());
		spSellingPriceImpl.setTaxValue(spSellingPrice.getTaxValue());
		spSellingPriceImpl.setTotalPrice(spSellingPrice.getTotalPrice());
		spSellingPriceImpl.setCompanyId(spSellingPrice.getCompanyId());
		spSellingPriceImpl.setUserId(spSellingPrice.getUserId());
		spSellingPriceImpl.setUserName(spSellingPrice.getUserName());
		spSellingPriceImpl.setCreateDate(spSellingPrice.getCreateDate());
		spSellingPriceImpl.setModifiedDate(spSellingPrice.getModifiedDate());

		return spSellingPriceImpl;
	}

	/**
	 * Returns the s p selling price with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p selling price
	 * @return the s p selling price
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPSellingPriceException, SystemException {
		SPSellingPrice spSellingPrice = fetchByPrimaryKey(primaryKey);

		if (spSellingPrice == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPSellingPriceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spSellingPrice;
	}

	/**
	 * Returns the s p selling price with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException} if it could not be found.
	 *
	 * @param spSellingPriceId the primary key of the s p selling price
	 * @return the s p selling price
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException if a s p selling price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice findByPrimaryKey(long spSellingPriceId)
		throws NoSuchSPSellingPriceException, SystemException {
		return findByPrimaryKey((Serializable)spSellingPriceId);
	}

	/**
	 * Returns the s p selling price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p selling price
	 * @return the s p selling price, or <code>null</code> if a s p selling price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPSellingPrice spSellingPrice = (SPSellingPrice)EntityCacheUtil.getResult(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
				SPSellingPriceImpl.class, primaryKey);

		if (spSellingPrice == _nullSPSellingPrice) {
			return null;
		}

		if (spSellingPrice == null) {
			Session session = null;

			try {
				session = openSession();

				spSellingPrice = (SPSellingPrice)session.get(SPSellingPriceImpl.class,
						primaryKey);

				if (spSellingPrice != null) {
					cacheResult(spSellingPrice);
				}
				else {
					EntityCacheUtil.putResult(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
						SPSellingPriceImpl.class, primaryKey,
						_nullSPSellingPrice);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPSellingPriceModelImpl.ENTITY_CACHE_ENABLED,
					SPSellingPriceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spSellingPrice;
	}

	/**
	 * Returns the s p selling price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spSellingPriceId the primary key of the s p selling price
	 * @return the s p selling price, or <code>null</code> if a s p selling price with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPrice fetchByPrimaryKey(long spSellingPriceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spSellingPriceId);
	}

	/**
	 * Returns all the s p selling prices.
	 *
	 * @return the s p selling prices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPrice> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p selling prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p selling prices
	 * @param end the upper bound of the range of s p selling prices (not inclusive)
	 * @return the range of s p selling prices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPrice> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p selling prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p selling prices
	 * @param end the upper bound of the range of s p selling prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p selling prices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPrice> findAll(int start, int end,
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

		List<SPSellingPrice> list = (List<SPSellingPrice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSELLINGPRICE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSELLINGPRICE;

				if (pagination) {
					sql = sql.concat(SPSellingPriceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPSellingPrice>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSellingPrice>(list);
				}
				else {
					list = (List<SPSellingPrice>)QueryUtil.list(q,
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
	 * Removes all the s p selling prices from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPSellingPrice spSellingPrice : findAll()) {
			remove(spSellingPrice);
		}
	}

	/**
	 * Returns the number of s p selling prices.
	 *
	 * @return the number of s p selling prices
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

				Query q = session.createQuery(_SQL_COUNT_SPSELLINGPRICE);

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
	 * Initializes the s p selling price persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spshopping.model.SPSellingPrice")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPSellingPrice>> listenersList = new ArrayList<ModelListener<SPSellingPrice>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPSellingPrice>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPSellingPriceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSELLINGPRICE = "SELECT spSellingPrice FROM SPSellingPrice spSellingPrice";
	private static final String _SQL_SELECT_SPSELLINGPRICE_WHERE = "SELECT spSellingPrice FROM SPSellingPrice spSellingPrice WHERE ";
	private static final String _SQL_COUNT_SPSELLINGPRICE = "SELECT COUNT(spSellingPrice) FROM SPSellingPrice spSellingPrice";
	private static final String _SQL_COUNT_SPSELLINGPRICE_WHERE = "SELECT COUNT(spSellingPrice) FROM SPSellingPrice spSellingPrice WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spSellingPrice.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPSellingPrice exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPSellingPrice exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPSellingPricePersistenceImpl.class);
	private static SPSellingPrice _nullSPSellingPrice = new SPSellingPriceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPSellingPrice> toCacheModel() {
				return _nullSPSellingPriceCacheModel;
			}
		};

	private static CacheModel<SPSellingPrice> _nullSPSellingPriceCacheModel = new CacheModel<SPSellingPrice>() {
			@Override
			public SPSellingPrice toEntityModel() {
				return _nullSPSellingPrice;
			}
		};
}