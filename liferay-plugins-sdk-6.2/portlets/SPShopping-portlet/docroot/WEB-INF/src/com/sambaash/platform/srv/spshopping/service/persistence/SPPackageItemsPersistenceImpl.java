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

import com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException;
import com.sambaash.platform.srv.spshopping.model.SPPackageItems;
import com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p package items service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPPackageItemsPersistence
 * @see SPPackageItemsUtil
 * @generated
 */
public class SPPackageItemsPersistenceImpl extends BasePersistenceImpl<SPPackageItems>
	implements SPPackageItemsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPPackageItemsUtil} to access the s p package items persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPPackageItemsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsModelImpl.FINDER_CACHE_ENABLED,
			SPPackageItemsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsModelImpl.FINDER_CACHE_ENABLED,
			SPPackageItemsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
		new FinderPath(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsModelImpl.FINDER_CACHE_ENABLED,
			SPPackageItemsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypackageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
		new FinderPath(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsModelImpl.FINDER_CACHE_ENABLED,
			SPPackageItemsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypackageId",
			new String[] { Long.class.getName() },
			SPPackageItemsModelImpl.PACKAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypackageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p package itemses where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @return the matching s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPackageItems> findBypackageId(long packageId)
		throws SystemException {
		return findBypackageId(packageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the s p package itemses where packageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param start the lower bound of the range of s p package itemses
	 * @param end the upper bound of the range of s p package itemses (not inclusive)
	 * @return the range of matching s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPackageItems> findBypackageId(long packageId, int start,
		int end) throws SystemException {
		return findBypackageId(packageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p package itemses where packageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param start the lower bound of the range of s p package itemses
	 * @param end the upper bound of the range of s p package itemses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPackageItems> findBypackageId(long packageId, int start,
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

		List<SPPackageItems> list = (List<SPPackageItems>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPPackageItems spPackageItems : list) {
				if ((packageId != spPackageItems.getPackageId())) {
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

			query.append(_SQL_SELECT_SPPACKAGEITEMS_WHERE);

			query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPPackageItemsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(packageId);

				if (!pagination) {
					list = (List<SPPackageItems>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPPackageItems>(list);
				}
				else {
					list = (List<SPPackageItems>)QueryUtil.list(q,
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
	 * Returns the first s p package items in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p package items
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a matching s p package items could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems findBypackageId_First(long packageId,
		OrderByComparator orderByComparator)
		throws NoSuchSPPackageItemsException, SystemException {
		SPPackageItems spPackageItems = fetchBypackageId_First(packageId,
				orderByComparator);

		if (spPackageItems != null) {
			return spPackageItems;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("packageId=");
		msg.append(packageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPPackageItemsException(msg.toString());
	}

	/**
	 * Returns the first s p package items in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p package items, or <code>null</code> if a matching s p package items could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems fetchBypackageId_First(long packageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPPackageItems> list = findBypackageId(packageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p package items in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p package items
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a matching s p package items could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems findBypackageId_Last(long packageId,
		OrderByComparator orderByComparator)
		throws NoSuchSPPackageItemsException, SystemException {
		SPPackageItems spPackageItems = fetchBypackageId_Last(packageId,
				orderByComparator);

		if (spPackageItems != null) {
			return spPackageItems;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("packageId=");
		msg.append(packageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPPackageItemsException(msg.toString());
	}

	/**
	 * Returns the last s p package items in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p package items, or <code>null</code> if a matching s p package items could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems fetchBypackageId_Last(long packageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBypackageId(packageId);

		if (count == 0) {
			return null;
		}

		List<SPPackageItems> list = findBypackageId(packageId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p package itemses before and after the current s p package items in the ordered set where packageId = &#63;.
	 *
	 * @param spPackageItemsId the primary key of the current s p package items
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p package items
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems[] findBypackageId_PrevAndNext(long spPackageItemsId,
		long packageId, OrderByComparator orderByComparator)
		throws NoSuchSPPackageItemsException, SystemException {
		SPPackageItems spPackageItems = findByPrimaryKey(spPackageItemsId);

		Session session = null;

		try {
			session = openSession();

			SPPackageItems[] array = new SPPackageItemsImpl[3];

			array[0] = getBypackageId_PrevAndNext(session, spPackageItems,
					packageId, orderByComparator, true);

			array[1] = spPackageItems;

			array[2] = getBypackageId_PrevAndNext(session, spPackageItems,
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

	protected SPPackageItems getBypackageId_PrevAndNext(Session session,
		SPPackageItems spPackageItems, long packageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPPACKAGEITEMS_WHERE);

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
			query.append(SPPackageItemsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(packageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spPackageItems);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPPackageItems> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p package itemses where packageId = &#63; from the database.
	 *
	 * @param packageId the package ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypackageId(long packageId) throws SystemException {
		for (SPPackageItems spPackageItems : findBypackageId(packageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spPackageItems);
		}
	}

	/**
	 * Returns the number of s p package itemses where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @return the number of matching s p package itemses
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

			query.append(_SQL_COUNT_SPPACKAGEITEMS_WHERE);

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

	private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "spPackageItems.packageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID = new FinderPath(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsModelImpl.FINDER_CACHE_ENABLED,
			SPPackageItemsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID =
		new FinderPath(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsModelImpl.FINDER_CACHE_ENABLED,
			SPPackageItemsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemId",
			new String[] { Long.class.getName() },
			SPPackageItemsModelImpl.ITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMID = new FinderPath(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p package itemses where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPackageItems> findByItemId(long itemId)
		throws SystemException {
		return findByItemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p package itemses where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of s p package itemses
	 * @param end the upper bound of the range of s p package itemses (not inclusive)
	 * @return the range of matching s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPackageItems> findByItemId(long itemId, int start, int end)
		throws SystemException {
		return findByItemId(itemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p package itemses where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of s p package itemses
	 * @param end the upper bound of the range of s p package itemses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPackageItems> findByItemId(long itemId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID;
			finderArgs = new Object[] { itemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID;
			finderArgs = new Object[] { itemId, start, end, orderByComparator };
		}

		List<SPPackageItems> list = (List<SPPackageItems>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPPackageItems spPackageItems : list) {
				if ((itemId != spPackageItems.getItemId())) {
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

			query.append(_SQL_SELECT_SPPACKAGEITEMS_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPPackageItemsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				if (!pagination) {
					list = (List<SPPackageItems>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPPackageItems>(list);
				}
				else {
					list = (List<SPPackageItems>)QueryUtil.list(q,
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
	 * Returns the first s p package items in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p package items
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a matching s p package items could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems findByItemId_First(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchSPPackageItemsException, SystemException {
		SPPackageItems spPackageItems = fetchByItemId_First(itemId,
				orderByComparator);

		if (spPackageItems != null) {
			return spPackageItems;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPPackageItemsException(msg.toString());
	}

	/**
	 * Returns the first s p package items in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p package items, or <code>null</code> if a matching s p package items could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems fetchByItemId_First(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPPackageItems> list = findByItemId(itemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p package items in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p package items
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a matching s p package items could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems findByItemId_Last(long itemId,
		OrderByComparator orderByComparator)
		throws NoSuchSPPackageItemsException, SystemException {
		SPPackageItems spPackageItems = fetchByItemId_Last(itemId,
				orderByComparator);

		if (spPackageItems != null) {
			return spPackageItems;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPPackageItemsException(msg.toString());
	}

	/**
	 * Returns the last s p package items in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p package items, or <code>null</code> if a matching s p package items could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems fetchByItemId_Last(long itemId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemId(itemId);

		if (count == 0) {
			return null;
		}

		List<SPPackageItems> list = findByItemId(itemId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p package itemses before and after the current s p package items in the ordered set where itemId = &#63;.
	 *
	 * @param spPackageItemsId the primary key of the current s p package items
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p package items
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems[] findByItemId_PrevAndNext(long spPackageItemsId,
		long itemId, OrderByComparator orderByComparator)
		throws NoSuchSPPackageItemsException, SystemException {
		SPPackageItems spPackageItems = findByPrimaryKey(spPackageItemsId);

		Session session = null;

		try {
			session = openSession();

			SPPackageItems[] array = new SPPackageItemsImpl[3];

			array[0] = getByItemId_PrevAndNext(session, spPackageItems, itemId,
					orderByComparator, true);

			array[1] = spPackageItems;

			array[2] = getByItemId_PrevAndNext(session, spPackageItems, itemId,
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

	protected SPPackageItems getByItemId_PrevAndNext(Session session,
		SPPackageItems spPackageItems, long itemId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPPACKAGEITEMS_WHERE);

		query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

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
			query.append(SPPackageItemsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spPackageItems);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPPackageItems> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p package itemses where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemId(long itemId) throws SystemException {
		for (SPPackageItems spPackageItems : findByItemId(itemId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spPackageItems);
		}
	}

	/**
	 * Returns the number of s p package itemses where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByItemId(long itemId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMID;

		Object[] finderArgs = new Object[] { itemId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPPACKAGEITEMS_WHERE);

			query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

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

	private static final String _FINDER_COLUMN_ITEMID_ITEMID_2 = "spPackageItems.itemId = ?";

	public SPPackageItemsPersistenceImpl() {
		setModelClass(SPPackageItems.class);
	}

	/**
	 * Caches the s p package items in the entity cache if it is enabled.
	 *
	 * @param spPackageItems the s p package items
	 */
	@Override
	public void cacheResult(SPPackageItems spPackageItems) {
		EntityCacheUtil.putResult(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsImpl.class, spPackageItems.getPrimaryKey(),
			spPackageItems);

		spPackageItems.resetOriginalValues();
	}

	/**
	 * Caches the s p package itemses in the entity cache if it is enabled.
	 *
	 * @param spPackageItemses the s p package itemses
	 */
	@Override
	public void cacheResult(List<SPPackageItems> spPackageItemses) {
		for (SPPackageItems spPackageItems : spPackageItemses) {
			if (EntityCacheUtil.getResult(
						SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
						SPPackageItemsImpl.class, spPackageItems.getPrimaryKey()) == null) {
				cacheResult(spPackageItems);
			}
			else {
				spPackageItems.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p package itemses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPPackageItemsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPPackageItemsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p package items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPPackageItems spPackageItems) {
		EntityCacheUtil.removeResult(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsImpl.class, spPackageItems.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPPackageItems> spPackageItemses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPPackageItems spPackageItems : spPackageItemses) {
			EntityCacheUtil.removeResult(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
				SPPackageItemsImpl.class, spPackageItems.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p package items with the primary key. Does not add the s p package items to the database.
	 *
	 * @param spPackageItemsId the primary key for the new s p package items
	 * @return the new s p package items
	 */
	@Override
	public SPPackageItems create(long spPackageItemsId) {
		SPPackageItems spPackageItems = new SPPackageItemsImpl();

		spPackageItems.setNew(true);
		spPackageItems.setPrimaryKey(spPackageItemsId);

		return spPackageItems;
	}

	/**
	 * Removes the s p package items with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPackageItemsId the primary key of the s p package items
	 * @return the s p package items that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems remove(long spPackageItemsId)
		throws NoSuchSPPackageItemsException, SystemException {
		return remove((Serializable)spPackageItemsId);
	}

	/**
	 * Removes the s p package items with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p package items
	 * @return the s p package items that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems remove(Serializable primaryKey)
		throws NoSuchSPPackageItemsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPPackageItems spPackageItems = (SPPackageItems)session.get(SPPackageItemsImpl.class,
					primaryKey);

			if (spPackageItems == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPPackageItemsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spPackageItems);
		}
		catch (NoSuchSPPackageItemsException nsee) {
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
	protected SPPackageItems removeImpl(SPPackageItems spPackageItems)
		throws SystemException {
		spPackageItems = toUnwrappedModel(spPackageItems);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spPackageItems)) {
				spPackageItems = (SPPackageItems)session.get(SPPackageItemsImpl.class,
						spPackageItems.getPrimaryKeyObj());
			}

			if (spPackageItems != null) {
				session.delete(spPackageItems);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spPackageItems != null) {
			clearCache(spPackageItems);
		}

		return spPackageItems;
	}

	@Override
	public SPPackageItems updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPPackageItems spPackageItems)
		throws SystemException {
		spPackageItems = toUnwrappedModel(spPackageItems);

		boolean isNew = spPackageItems.isNew();

		SPPackageItemsModelImpl spPackageItemsModelImpl = (SPPackageItemsModelImpl)spPackageItems;

		Session session = null;

		try {
			session = openSession();

			if (spPackageItems.isNew()) {
				session.save(spPackageItems);

				spPackageItems.setNew(false);
			}
			else {
				session.merge(spPackageItems);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPPackageItemsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spPackageItemsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spPackageItemsModelImpl.getOriginalPackageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
					args);

				args = new Object[] { spPackageItemsModelImpl.getPackageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
					args);
			}

			if ((spPackageItemsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spPackageItemsModelImpl.getOriginalItemId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);

				args = new Object[] { spPackageItemsModelImpl.getItemId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
			SPPackageItemsImpl.class, spPackageItems.getPrimaryKey(),
			spPackageItems);

		return spPackageItems;
	}

	protected SPPackageItems toUnwrappedModel(SPPackageItems spPackageItems) {
		if (spPackageItems instanceof SPPackageItemsImpl) {
			return spPackageItems;
		}

		SPPackageItemsImpl spPackageItemsImpl = new SPPackageItemsImpl();

		spPackageItemsImpl.setNew(spPackageItems.isNew());
		spPackageItemsImpl.setPrimaryKey(spPackageItems.getPrimaryKey());

		spPackageItemsImpl.setSpPackageItemsId(spPackageItems.getSpPackageItemsId());
		spPackageItemsImpl.setGroupId(spPackageItems.getGroupId());
		spPackageItemsImpl.setPackageId(spPackageItems.getPackageId());
		spPackageItemsImpl.setItemId(spPackageItems.getItemId());
		spPackageItemsImpl.setQuantity(spPackageItems.getQuantity());
		spPackageItemsImpl.setCompanyId(spPackageItems.getCompanyId());
		spPackageItemsImpl.setUserId(spPackageItems.getUserId());
		spPackageItemsImpl.setUserName(spPackageItems.getUserName());
		spPackageItemsImpl.setCreateDate(spPackageItems.getCreateDate());
		spPackageItemsImpl.setModifiedDate(spPackageItems.getModifiedDate());

		return spPackageItemsImpl;
	}

	/**
	 * Returns the s p package items with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p package items
	 * @return the s p package items
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPPackageItemsException, SystemException {
		SPPackageItems spPackageItems = fetchByPrimaryKey(primaryKey);

		if (spPackageItems == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPPackageItemsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spPackageItems;
	}

	/**
	 * Returns the s p package items with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException} if it could not be found.
	 *
	 * @param spPackageItemsId the primary key of the s p package items
	 * @return the s p package items
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPPackageItemsException if a s p package items with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems findByPrimaryKey(long spPackageItemsId)
		throws NoSuchSPPackageItemsException, SystemException {
		return findByPrimaryKey((Serializable)spPackageItemsId);
	}

	/**
	 * Returns the s p package items with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p package items
	 * @return the s p package items, or <code>null</code> if a s p package items with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPPackageItems spPackageItems = (SPPackageItems)EntityCacheUtil.getResult(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
				SPPackageItemsImpl.class, primaryKey);

		if (spPackageItems == _nullSPPackageItems) {
			return null;
		}

		if (spPackageItems == null) {
			Session session = null;

			try {
				session = openSession();

				spPackageItems = (SPPackageItems)session.get(SPPackageItemsImpl.class,
						primaryKey);

				if (spPackageItems != null) {
					cacheResult(spPackageItems);
				}
				else {
					EntityCacheUtil.putResult(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
						SPPackageItemsImpl.class, primaryKey,
						_nullSPPackageItems);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPPackageItemsModelImpl.ENTITY_CACHE_ENABLED,
					SPPackageItemsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spPackageItems;
	}

	/**
	 * Returns the s p package items with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPackageItemsId the primary key of the s p package items
	 * @return the s p package items, or <code>null</code> if a s p package items with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPackageItems fetchByPrimaryKey(long spPackageItemsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPackageItemsId);
	}

	/**
	 * Returns all the s p package itemses.
	 *
	 * @return the s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPackageItems> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p package itemses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p package itemses
	 * @param end the upper bound of the range of s p package itemses (not inclusive)
	 * @return the range of s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPackageItems> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p package itemses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPPackageItemsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p package itemses
	 * @param end the upper bound of the range of s p package itemses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p package itemses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPackageItems> findAll(int start, int end,
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

		List<SPPackageItems> list = (List<SPPackageItems>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPPACKAGEITEMS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPPACKAGEITEMS;

				if (pagination) {
					sql = sql.concat(SPPackageItemsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPPackageItems>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPPackageItems>(list);
				}
				else {
					list = (List<SPPackageItems>)QueryUtil.list(q,
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
	 * Removes all the s p package itemses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPPackageItems spPackageItems : findAll()) {
			remove(spPackageItems);
		}
	}

	/**
	 * Returns the number of s p package itemses.
	 *
	 * @return the number of s p package itemses
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

				Query q = session.createQuery(_SQL_COUNT_SPPACKAGEITEMS);

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
	 * Initializes the s p package items persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spshopping.model.SPPackageItems")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPPackageItems>> listenersList = new ArrayList<ModelListener<SPPackageItems>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPPackageItems>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPPackageItemsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPPACKAGEITEMS = "SELECT spPackageItems FROM SPPackageItems spPackageItems";
	private static final String _SQL_SELECT_SPPACKAGEITEMS_WHERE = "SELECT spPackageItems FROM SPPackageItems spPackageItems WHERE ";
	private static final String _SQL_COUNT_SPPACKAGEITEMS = "SELECT COUNT(spPackageItems) FROM SPPackageItems spPackageItems";
	private static final String _SQL_COUNT_SPPACKAGEITEMS_WHERE = "SELECT COUNT(spPackageItems) FROM SPPackageItems spPackageItems WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spPackageItems.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPPackageItems exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPPackageItems exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPPackageItemsPersistenceImpl.class);
	private static SPPackageItems _nullSPPackageItems = new SPPackageItemsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPPackageItems> toCacheModel() {
				return _nullSPPackageItemsCacheModel;
			}
		};

	private static CacheModel<SPPackageItems> _nullSPPackageItemsCacheModel = new CacheModel<SPPackageItems>() {
			@Override
			public SPPackageItems toEntityModel() {
				return _nullSPPackageItems;
			}
		};
}