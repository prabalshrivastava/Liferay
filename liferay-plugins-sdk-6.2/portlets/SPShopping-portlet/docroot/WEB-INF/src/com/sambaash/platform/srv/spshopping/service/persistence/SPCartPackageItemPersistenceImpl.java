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

import com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException;
import com.sambaash.platform.srv.spshopping.model.SPCartPackageItem;
import com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p cart package item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPCartPackageItemPersistence
 * @see SPCartPackageItemUtil
 * @generated
 */
public class SPCartPackageItemPersistenceImpl extends BasePersistenceImpl<SPCartPackageItem>
	implements SPCartPackageItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPCartPackageItemUtil} to access the s p cart package item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPCartPackageItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageItemModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageItemModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPCARTPACKAGEID =
		new FinderPath(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageItemModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySPCartPackageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCARTPACKAGEID =
		new FinderPath(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageItemModelImpl.FINDER_CACHE_ENABLED,
			SPCartPackageItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySPCartPackageId",
			new String[] { Long.class.getName() },
			SPCartPackageItemModelImpl.SPCARTPACKAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPCARTPACKAGEID = new FinderPath(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySPCartPackageId", new String[] { Long.class.getName() });

	/**
	 * Returns all the s p cart package items where spCartPackageId = &#63;.
	 *
	 * @param spCartPackageId the sp cart package ID
	 * @return the matching s p cart package items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackageItem> findBySPCartPackageId(long spCartPackageId)
		throws SystemException {
		return findBySPCartPackageId(spCartPackageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p cart package items where spCartPackageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCartPackageId the sp cart package ID
	 * @param start the lower bound of the range of s p cart package items
	 * @param end the upper bound of the range of s p cart package items (not inclusive)
	 * @return the range of matching s p cart package items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackageItem> findBySPCartPackageId(long spCartPackageId,
		int start, int end) throws SystemException {
		return findBySPCartPackageId(spCartPackageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p cart package items where spCartPackageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCartPackageId the sp cart package ID
	 * @param start the lower bound of the range of s p cart package items
	 * @param end the upper bound of the range of s p cart package items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p cart package items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackageItem> findBySPCartPackageId(long spCartPackageId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCARTPACKAGEID;
			finderArgs = new Object[] { spCartPackageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPCARTPACKAGEID;
			finderArgs = new Object[] {
					spCartPackageId,
					
					start, end, orderByComparator
				};
		}

		List<SPCartPackageItem> list = (List<SPCartPackageItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCartPackageItem spCartPackageItem : list) {
				if ((spCartPackageId != spCartPackageItem.getSpCartPackageId())) {
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

			query.append(_SQL_SELECT_SPCARTPACKAGEITEM_WHERE);

			query.append(_FINDER_COLUMN_SPCARTPACKAGEID_SPCARTPACKAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPCartPackageItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCartPackageId);

				if (!pagination) {
					list = (List<SPCartPackageItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCartPackageItem>(list);
				}
				else {
					list = (List<SPCartPackageItem>)QueryUtil.list(q,
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
	 * Returns the first s p cart package item in the ordered set where spCartPackageId = &#63;.
	 *
	 * @param spCartPackageId the sp cart package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p cart package item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a matching s p cart package item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem findBySPCartPackageId_First(long spCartPackageId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCartPackageItemException, SystemException {
		SPCartPackageItem spCartPackageItem = fetchBySPCartPackageId_First(spCartPackageId,
				orderByComparator);

		if (spCartPackageItem != null) {
			return spCartPackageItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCartPackageId=");
		msg.append(spCartPackageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCartPackageItemException(msg.toString());
	}

	/**
	 * Returns the first s p cart package item in the ordered set where spCartPackageId = &#63;.
	 *
	 * @param spCartPackageId the sp cart package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p cart package item, or <code>null</code> if a matching s p cart package item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem fetchBySPCartPackageId_First(
		long spCartPackageId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPCartPackageItem> list = findBySPCartPackageId(spCartPackageId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p cart package item in the ordered set where spCartPackageId = &#63;.
	 *
	 * @param spCartPackageId the sp cart package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p cart package item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a matching s p cart package item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem findBySPCartPackageId_Last(long spCartPackageId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCartPackageItemException, SystemException {
		SPCartPackageItem spCartPackageItem = fetchBySPCartPackageId_Last(spCartPackageId,
				orderByComparator);

		if (spCartPackageItem != null) {
			return spCartPackageItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCartPackageId=");
		msg.append(spCartPackageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCartPackageItemException(msg.toString());
	}

	/**
	 * Returns the last s p cart package item in the ordered set where spCartPackageId = &#63;.
	 *
	 * @param spCartPackageId the sp cart package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p cart package item, or <code>null</code> if a matching s p cart package item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem fetchBySPCartPackageId_Last(long spCartPackageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySPCartPackageId(spCartPackageId);

		if (count == 0) {
			return null;
		}

		List<SPCartPackageItem> list = findBySPCartPackageId(spCartPackageId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p cart package items before and after the current s p cart package item in the ordered set where spCartPackageId = &#63;.
	 *
	 * @param spCartPackageItemId the primary key of the current s p cart package item
	 * @param spCartPackageId the sp cart package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p cart package item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a s p cart package item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem[] findBySPCartPackageId_PrevAndNext(
		long spCartPackageItemId, long spCartPackageId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCartPackageItemException, SystemException {
		SPCartPackageItem spCartPackageItem = findByPrimaryKey(spCartPackageItemId);

		Session session = null;

		try {
			session = openSession();

			SPCartPackageItem[] array = new SPCartPackageItemImpl[3];

			array[0] = getBySPCartPackageId_PrevAndNext(session,
					spCartPackageItem, spCartPackageId, orderByComparator, true);

			array[1] = spCartPackageItem;

			array[2] = getBySPCartPackageId_PrevAndNext(session,
					spCartPackageItem, spCartPackageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPCartPackageItem getBySPCartPackageId_PrevAndNext(
		Session session, SPCartPackageItem spCartPackageItem,
		long spCartPackageId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCARTPACKAGEITEM_WHERE);

		query.append(_FINDER_COLUMN_SPCARTPACKAGEID_SPCARTPACKAGEID_2);

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
			query.append(SPCartPackageItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCartPackageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spCartPackageItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCartPackageItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p cart package items where spCartPackageId = &#63; from the database.
	 *
	 * @param spCartPackageId the sp cart package ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySPCartPackageId(long spCartPackageId)
		throws SystemException {
		for (SPCartPackageItem spCartPackageItem : findBySPCartPackageId(
				spCartPackageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spCartPackageItem);
		}
	}

	/**
	 * Returns the number of s p cart package items where spCartPackageId = &#63;.
	 *
	 * @param spCartPackageId the sp cart package ID
	 * @return the number of matching s p cart package items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySPCartPackageId(long spCartPackageId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPCARTPACKAGEID;

		Object[] finderArgs = new Object[] { spCartPackageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPCARTPACKAGEITEM_WHERE);

			query.append(_FINDER_COLUMN_SPCARTPACKAGEID_SPCARTPACKAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCartPackageId);

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

	private static final String _FINDER_COLUMN_SPCARTPACKAGEID_SPCARTPACKAGEID_2 =
		"spCartPackageItem.spCartPackageId = ?";

	public SPCartPackageItemPersistenceImpl() {
		setModelClass(SPCartPackageItem.class);
	}

	/**
	 * Caches the s p cart package item in the entity cache if it is enabled.
	 *
	 * @param spCartPackageItem the s p cart package item
	 */
	@Override
	public void cacheResult(SPCartPackageItem spCartPackageItem) {
		EntityCacheUtil.putResult(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageItemImpl.class, spCartPackageItem.getPrimaryKey(),
			spCartPackageItem);

		spCartPackageItem.resetOriginalValues();
	}

	/**
	 * Caches the s p cart package items in the entity cache if it is enabled.
	 *
	 * @param spCartPackageItems the s p cart package items
	 */
	@Override
	public void cacheResult(List<SPCartPackageItem> spCartPackageItems) {
		for (SPCartPackageItem spCartPackageItem : spCartPackageItems) {
			if (EntityCacheUtil.getResult(
						SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
						SPCartPackageItemImpl.class,
						spCartPackageItem.getPrimaryKey()) == null) {
				cacheResult(spCartPackageItem);
			}
			else {
				spCartPackageItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p cart package items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPCartPackageItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPCartPackageItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p cart package item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPCartPackageItem spCartPackageItem) {
		EntityCacheUtil.removeResult(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageItemImpl.class, spCartPackageItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPCartPackageItem> spCartPackageItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPCartPackageItem spCartPackageItem : spCartPackageItems) {
			EntityCacheUtil.removeResult(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
				SPCartPackageItemImpl.class, spCartPackageItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p cart package item with the primary key. Does not add the s p cart package item to the database.
	 *
	 * @param spCartPackageItemId the primary key for the new s p cart package item
	 * @return the new s p cart package item
	 */
	@Override
	public SPCartPackageItem create(long spCartPackageItemId) {
		SPCartPackageItem spCartPackageItem = new SPCartPackageItemImpl();

		spCartPackageItem.setNew(true);
		spCartPackageItem.setPrimaryKey(spCartPackageItemId);

		return spCartPackageItem;
	}

	/**
	 * Removes the s p cart package item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCartPackageItemId the primary key of the s p cart package item
	 * @return the s p cart package item that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a s p cart package item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem remove(long spCartPackageItemId)
		throws NoSuchSPCartPackageItemException, SystemException {
		return remove((Serializable)spCartPackageItemId);
	}

	/**
	 * Removes the s p cart package item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p cart package item
	 * @return the s p cart package item that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a s p cart package item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem remove(Serializable primaryKey)
		throws NoSuchSPCartPackageItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPCartPackageItem spCartPackageItem = (SPCartPackageItem)session.get(SPCartPackageItemImpl.class,
					primaryKey);

			if (spCartPackageItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPCartPackageItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spCartPackageItem);
		}
		catch (NoSuchSPCartPackageItemException nsee) {
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
	protected SPCartPackageItem removeImpl(SPCartPackageItem spCartPackageItem)
		throws SystemException {
		spCartPackageItem = toUnwrappedModel(spCartPackageItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spCartPackageItem)) {
				spCartPackageItem = (SPCartPackageItem)session.get(SPCartPackageItemImpl.class,
						spCartPackageItem.getPrimaryKeyObj());
			}

			if (spCartPackageItem != null) {
				session.delete(spCartPackageItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spCartPackageItem != null) {
			clearCache(spCartPackageItem);
		}

		return spCartPackageItem;
	}

	@Override
	public SPCartPackageItem updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPCartPackageItem spCartPackageItem)
		throws SystemException {
		spCartPackageItem = toUnwrappedModel(spCartPackageItem);

		boolean isNew = spCartPackageItem.isNew();

		SPCartPackageItemModelImpl spCartPackageItemModelImpl = (SPCartPackageItemModelImpl)spCartPackageItem;

		Session session = null;

		try {
			session = openSession();

			if (spCartPackageItem.isNew()) {
				session.save(spCartPackageItem);

				spCartPackageItem.setNew(false);
			}
			else {
				session.merge(spCartPackageItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPCartPackageItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spCartPackageItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCARTPACKAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCartPackageItemModelImpl.getOriginalSpCartPackageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPCARTPACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCARTPACKAGEID,
					args);

				args = new Object[] {
						spCartPackageItemModelImpl.getSpCartPackageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPCARTPACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCARTPACKAGEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
			SPCartPackageItemImpl.class, spCartPackageItem.getPrimaryKey(),
			spCartPackageItem);

		return spCartPackageItem;
	}

	protected SPCartPackageItem toUnwrappedModel(
		SPCartPackageItem spCartPackageItem) {
		if (spCartPackageItem instanceof SPCartPackageItemImpl) {
			return spCartPackageItem;
		}

		SPCartPackageItemImpl spCartPackageItemImpl = new SPCartPackageItemImpl();

		spCartPackageItemImpl.setNew(spCartPackageItem.isNew());
		spCartPackageItemImpl.setPrimaryKey(spCartPackageItem.getPrimaryKey());

		spCartPackageItemImpl.setSpCartPackageItemId(spCartPackageItem.getSpCartPackageItemId());
		spCartPackageItemImpl.setGroupId(spCartPackageItem.getGroupId());
		spCartPackageItemImpl.setSpCartPackageId(spCartPackageItem.getSpCartPackageId());
		spCartPackageItemImpl.setTitle(spCartPackageItem.getTitle());
		spCartPackageItemImpl.setItemCode(spCartPackageItem.getItemCode());
		spCartPackageItemImpl.setQuantity(spCartPackageItem.getQuantity());
		spCartPackageItemImpl.setEntityClassPk(spCartPackageItem.getEntityClassPk());
		spCartPackageItemImpl.setEntityClassName(spCartPackageItem.getEntityClassName());
		spCartPackageItemImpl.setTotalPrice(spCartPackageItem.getTotalPrice());
		spCartPackageItemImpl.setCompanyId(spCartPackageItem.getCompanyId());
		spCartPackageItemImpl.setUserId(spCartPackageItem.getUserId());
		spCartPackageItemImpl.setUserName(spCartPackageItem.getUserName());
		spCartPackageItemImpl.setCreateDate(spCartPackageItem.getCreateDate());
		spCartPackageItemImpl.setModifiedDate(spCartPackageItem.getModifiedDate());

		return spCartPackageItemImpl;
	}

	/**
	 * Returns the s p cart package item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p cart package item
	 * @return the s p cart package item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a s p cart package item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPCartPackageItemException, SystemException {
		SPCartPackageItem spCartPackageItem = fetchByPrimaryKey(primaryKey);

		if (spCartPackageItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPCartPackageItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spCartPackageItem;
	}

	/**
	 * Returns the s p cart package item with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException} if it could not be found.
	 *
	 * @param spCartPackageItemId the primary key of the s p cart package item
	 * @return the s p cart package item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPCartPackageItemException if a s p cart package item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem findByPrimaryKey(long spCartPackageItemId)
		throws NoSuchSPCartPackageItemException, SystemException {
		return findByPrimaryKey((Serializable)spCartPackageItemId);
	}

	/**
	 * Returns the s p cart package item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p cart package item
	 * @return the s p cart package item, or <code>null</code> if a s p cart package item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPCartPackageItem spCartPackageItem = (SPCartPackageItem)EntityCacheUtil.getResult(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
				SPCartPackageItemImpl.class, primaryKey);

		if (spCartPackageItem == _nullSPCartPackageItem) {
			return null;
		}

		if (spCartPackageItem == null) {
			Session session = null;

			try {
				session = openSession();

				spCartPackageItem = (SPCartPackageItem)session.get(SPCartPackageItemImpl.class,
						primaryKey);

				if (spCartPackageItem != null) {
					cacheResult(spCartPackageItem);
				}
				else {
					EntityCacheUtil.putResult(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
						SPCartPackageItemImpl.class, primaryKey,
						_nullSPCartPackageItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPCartPackageItemModelImpl.ENTITY_CACHE_ENABLED,
					SPCartPackageItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spCartPackageItem;
	}

	/**
	 * Returns the s p cart package item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCartPackageItemId the primary key of the s p cart package item
	 * @return the s p cart package item, or <code>null</code> if a s p cart package item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCartPackageItem fetchByPrimaryKey(long spCartPackageItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCartPackageItemId);
	}

	/**
	 * Returns all the s p cart package items.
	 *
	 * @return the s p cart package items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackageItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p cart package items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p cart package items
	 * @param end the upper bound of the range of s p cart package items (not inclusive)
	 * @return the range of s p cart package items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackageItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p cart package items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p cart package items
	 * @param end the upper bound of the range of s p cart package items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p cart package items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCartPackageItem> findAll(int start, int end,
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

		List<SPCartPackageItem> list = (List<SPCartPackageItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCARTPACKAGEITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCARTPACKAGEITEM;

				if (pagination) {
					sql = sql.concat(SPCartPackageItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPCartPackageItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCartPackageItem>(list);
				}
				else {
					list = (List<SPCartPackageItem>)QueryUtil.list(q,
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
	 * Removes all the s p cart package items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPCartPackageItem spCartPackageItem : findAll()) {
			remove(spCartPackageItem);
		}
	}

	/**
	 * Returns the number of s p cart package items.
	 *
	 * @return the number of s p cart package items
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

				Query q = session.createQuery(_SQL_COUNT_SPCARTPACKAGEITEM);

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
	 * Initializes the s p cart package item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spshopping.model.SPCartPackageItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPCartPackageItem>> listenersList = new ArrayList<ModelListener<SPCartPackageItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPCartPackageItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPCartPackageItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCARTPACKAGEITEM = "SELECT spCartPackageItem FROM SPCartPackageItem spCartPackageItem";
	private static final String _SQL_SELECT_SPCARTPACKAGEITEM_WHERE = "SELECT spCartPackageItem FROM SPCartPackageItem spCartPackageItem WHERE ";
	private static final String _SQL_COUNT_SPCARTPACKAGEITEM = "SELECT COUNT(spCartPackageItem) FROM SPCartPackageItem spCartPackageItem";
	private static final String _SQL_COUNT_SPCARTPACKAGEITEM_WHERE = "SELECT COUNT(spCartPackageItem) FROM SPCartPackageItem spCartPackageItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spCartPackageItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPCartPackageItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPCartPackageItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPCartPackageItemPersistenceImpl.class);
	private static SPCartPackageItem _nullSPCartPackageItem = new SPCartPackageItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPCartPackageItem> toCacheModel() {
				return _nullSPCartPackageItemCacheModel;
			}
		};

	private static CacheModel<SPCartPackageItem> _nullSPCartPackageItemCacheModel =
		new CacheModel<SPCartPackageItem>() {
			@Override
			public SPCartPackageItem toEntityModel() {
				return _nullSPCartPackageItem;
			}
		};
}