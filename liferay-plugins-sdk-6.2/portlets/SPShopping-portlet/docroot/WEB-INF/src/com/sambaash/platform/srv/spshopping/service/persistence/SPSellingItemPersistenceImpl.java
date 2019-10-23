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

import com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException;
import com.sambaash.platform.srv.spshopping.model.SPSellingItem;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p selling item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPSellingItemPersistence
 * @see SPSellingItemUtil
 * @generated
 */
public class SPSellingItemPersistenceImpl extends BasePersistenceImpl<SPSellingItem>
	implements SPSellingItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPSellingItemUtil} to access the s p selling item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPSellingItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemModelImpl.FINDER_CACHE_ENABLED,
			SPSellingItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemModelImpl.FINDER_CACHE_ENABLED,
			SPSellingItemImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemModelImpl.FINDER_CACHE_ENABLED,
			SPSellingItemImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByactive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemModelImpl.FINDER_CACHE_ENABLED,
			SPSellingItemImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByactive", new String[] { Boolean.class.getName() },
			SPSellingItemModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the s p selling items where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching s p selling items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingItem> findByactive(boolean active)
		throws SystemException {
		return findByactive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p selling items where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of s p selling items
	 * @param end the upper bound of the range of s p selling items (not inclusive)
	 * @return the range of matching s p selling items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingItem> findByactive(boolean active, int start, int end)
		throws SystemException {
		return findByactive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p selling items where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of s p selling items
	 * @param end the upper bound of the range of s p selling items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p selling items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingItem> findByactive(boolean active, int start, int end,
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

		List<SPSellingItem> list = (List<SPSellingItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSellingItem spSellingItem : list) {
				if ((active != spSellingItem.getActive())) {
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

			query.append(_SQL_SELECT_SPSELLINGITEM_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSellingItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<SPSellingItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSellingItem>(list);
				}
				else {
					list = (List<SPSellingItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p selling item in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p selling item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a matching s p selling item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem findByactive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchSPSellingItemException, SystemException {
		SPSellingItem spSellingItem = fetchByactive_First(active,
				orderByComparator);

		if (spSellingItem != null) {
			return spSellingItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSellingItemException(msg.toString());
	}

	/**
	 * Returns the first s p selling item in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p selling item, or <code>null</code> if a matching s p selling item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem fetchByactive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSellingItem> list = findByactive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p selling item in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p selling item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a matching s p selling item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem findByactive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchSPSellingItemException, SystemException {
		SPSellingItem spSellingItem = fetchByactive_Last(active,
				orderByComparator);

		if (spSellingItem != null) {
			return spSellingItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSellingItemException(msg.toString());
	}

	/**
	 * Returns the last s p selling item in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p selling item, or <code>null</code> if a matching s p selling item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem fetchByactive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByactive(active);

		if (count == 0) {
			return null;
		}

		List<SPSellingItem> list = findByactive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p selling items before and after the current s p selling item in the ordered set where active = &#63;.
	 *
	 * @param spSellingItemId the primary key of the current s p selling item
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p selling item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a s p selling item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem[] findByactive_PrevAndNext(long spSellingItemId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchSPSellingItemException, SystemException {
		SPSellingItem spSellingItem = findByPrimaryKey(spSellingItemId);

		Session session = null;

		try {
			session = openSession();

			SPSellingItem[] array = new SPSellingItemImpl[3];

			array[0] = getByactive_PrevAndNext(session, spSellingItem, active,
					orderByComparator, true);

			array[1] = spSellingItem;

			array[2] = getByactive_PrevAndNext(session, spSellingItem, active,
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

	protected SPSellingItem getByactive_PrevAndNext(Session session,
		SPSellingItem spSellingItem, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSELLINGITEM_WHERE);

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
			query.append(SPSellingItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSellingItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSellingItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p selling items where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByactive(boolean active) throws SystemException {
		for (SPSellingItem spSellingItem : findByactive(active,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSellingItem);
		}
	}

	/**
	 * Returns the number of s p selling items where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching s p selling items
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

			query.append(_SQL_COUNT_SPSELLINGITEM_WHERE);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "spSellingItem.active = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK =
		new FinderPath(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemModelImpl.FINDER_CACHE_ENABLED,
			SPSellingItemImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEntityClassNameIdAndEntityClassPk",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPSellingItemModelImpl.ENTITYCLASSNAMEID_COLUMN_BITMASK |
			SPSellingItemModelImpl.ENTITYCLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK =
		new FinderPath(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEntityClassNameIdAndEntityClassPk",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p selling item where entityClassNameId = &#63; and entityClassPk = &#63; or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException} if it could not be found.
	 *
	 * @param entityClassNameId the entity class name ID
	 * @param entityClassPk the entity class pk
	 * @return the matching s p selling item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a matching s p selling item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem findByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk)
		throws NoSuchSPSellingItemException, SystemException {
		SPSellingItem spSellingItem = fetchByEntityClassNameIdAndEntityClassPk(entityClassNameId,
				entityClassPk);

		if (spSellingItem == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entityClassNameId=");
			msg.append(entityClassNameId);

			msg.append(", entityClassPk=");
			msg.append(entityClassPk);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPSellingItemException(msg.toString());
		}

		return spSellingItem;
	}

	/**
	 * Returns the s p selling item where entityClassNameId = &#63; and entityClassPk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param entityClassNameId the entity class name ID
	 * @param entityClassPk the entity class pk
	 * @return the matching s p selling item, or <code>null</code> if a matching s p selling item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem fetchByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk) throws SystemException {
		return fetchByEntityClassNameIdAndEntityClassPk(entityClassNameId,
			entityClassPk, true);
	}

	/**
	 * Returns the s p selling item where entityClassNameId = &#63; and entityClassPk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param entityClassNameId the entity class name ID
	 * @param entityClassPk the entity class pk
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p selling item, or <code>null</code> if a matching s p selling item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem fetchByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { entityClassNameId, entityClassPk };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
					finderArgs, this);
		}

		if (result instanceof SPSellingItem) {
			SPSellingItem spSellingItem = (SPSellingItem)result;

			if ((entityClassNameId != spSellingItem.getEntityClassNameId()) ||
					(entityClassPk != spSellingItem.getEntityClassPk())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPSELLINGITEM_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSNAMEIDANDENTITYCLASSPK_ENTITYCLASSNAMEID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSNAMEIDANDENTITYCLASSPK_ENTITYCLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassNameId);

				qPos.add(entityClassPk);

				List<SPSellingItem> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPSellingItemPersistenceImpl.fetchByEntityClassNameIdAndEntityClassPk(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPSellingItem spSellingItem = list.get(0);

					result = spSellingItem;

					cacheResult(spSellingItem);

					if ((spSellingItem.getEntityClassNameId() != entityClassNameId) ||
							(spSellingItem.getEntityClassPk() != entityClassPk)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
							finderArgs, spSellingItem);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
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
			return (SPSellingItem)result;
		}
	}

	/**
	 * Removes the s p selling item where entityClassNameId = &#63; and entityClassPk = &#63; from the database.
	 *
	 * @param entityClassNameId the entity class name ID
	 * @param entityClassPk the entity class pk
	 * @return the s p selling item that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem removeByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk)
		throws NoSuchSPSellingItemException, SystemException {
		SPSellingItem spSellingItem = findByEntityClassNameIdAndEntityClassPk(entityClassNameId,
				entityClassPk);

		return remove(spSellingItem);
	}

	/**
	 * Returns the number of s p selling items where entityClassNameId = &#63; and entityClassPk = &#63;.
	 *
	 * @param entityClassNameId the entity class name ID
	 * @param entityClassPk the entity class pk
	 * @return the number of matching s p selling items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEntityClassNameIdAndEntityClassPk(
		long entityClassNameId, long entityClassPk) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK;

		Object[] finderArgs = new Object[] { entityClassNameId, entityClassPk };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSELLINGITEM_WHERE);

			query.append(_FINDER_COLUMN_ENTITYCLASSNAMEIDANDENTITYCLASSPK_ENTITYCLASSNAMEID_2);

			query.append(_FINDER_COLUMN_ENTITYCLASSNAMEIDANDENTITYCLASSPK_ENTITYCLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(entityClassNameId);

				qPos.add(entityClassPk);

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

	private static final String _FINDER_COLUMN_ENTITYCLASSNAMEIDANDENTITYCLASSPK_ENTITYCLASSNAMEID_2 =
		"spSellingItem.entityClassNameId = ? AND ";
	private static final String _FINDER_COLUMN_ENTITYCLASSNAMEIDANDENTITYCLASSPK_ENTITYCLASSPK_2 =
		"spSellingItem.entityClassPk = ?";

	public SPSellingItemPersistenceImpl() {
		setModelClass(SPSellingItem.class);
	}

	/**
	 * Caches the s p selling item in the entity cache if it is enabled.
	 *
	 * @param spSellingItem the s p selling item
	 */
	@Override
	public void cacheResult(SPSellingItem spSellingItem) {
		EntityCacheUtil.putResult(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemImpl.class, spSellingItem.getPrimaryKey(),
			spSellingItem);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
			new Object[] {
				spSellingItem.getEntityClassNameId(),
				spSellingItem.getEntityClassPk()
			}, spSellingItem);

		spSellingItem.resetOriginalValues();
	}

	/**
	 * Caches the s p selling items in the entity cache if it is enabled.
	 *
	 * @param spSellingItems the s p selling items
	 */
	@Override
	public void cacheResult(List<SPSellingItem> spSellingItems) {
		for (SPSellingItem spSellingItem : spSellingItems) {
			if (EntityCacheUtil.getResult(
						SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
						SPSellingItemImpl.class, spSellingItem.getPrimaryKey()) == null) {
				cacheResult(spSellingItem);
			}
			else {
				spSellingItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p selling items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPSellingItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPSellingItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p selling item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPSellingItem spSellingItem) {
		EntityCacheUtil.removeResult(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemImpl.class, spSellingItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spSellingItem);
	}

	@Override
	public void clearCache(List<SPSellingItem> spSellingItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPSellingItem spSellingItem : spSellingItems) {
			EntityCacheUtil.removeResult(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
				SPSellingItemImpl.class, spSellingItem.getPrimaryKey());

			clearUniqueFindersCache(spSellingItem);
		}
	}

	protected void cacheUniqueFindersCache(SPSellingItem spSellingItem) {
		if (spSellingItem.isNew()) {
			Object[] args = new Object[] {
					spSellingItem.getEntityClassNameId(),
					spSellingItem.getEntityClassPk()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
				args, spSellingItem);
		}
		else {
			SPSellingItemModelImpl spSellingItemModelImpl = (SPSellingItemModelImpl)spSellingItem;

			if ((spSellingItemModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSellingItem.getEntityClassNameId(),
						spSellingItem.getEntityClassPk()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
					args, spSellingItem);
			}
		}
	}

	protected void clearUniqueFindersCache(SPSellingItem spSellingItem) {
		SPSellingItemModelImpl spSellingItemModelImpl = (SPSellingItemModelImpl)spSellingItem;

		Object[] args = new Object[] {
				spSellingItem.getEntityClassNameId(),
				spSellingItem.getEntityClassPk()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
			args);

		if ((spSellingItemModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSellingItemModelImpl.getOriginalEntityClassNameId(),
					spSellingItemModelImpl.getOriginalEntityClassPk()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYCLASSNAMEIDANDENTITYCLASSPK,
				args);
		}
	}

	/**
	 * Creates a new s p selling item with the primary key. Does not add the s p selling item to the database.
	 *
	 * @param spSellingItemId the primary key for the new s p selling item
	 * @return the new s p selling item
	 */
	@Override
	public SPSellingItem create(long spSellingItemId) {
		SPSellingItem spSellingItem = new SPSellingItemImpl();

		spSellingItem.setNew(true);
		spSellingItem.setPrimaryKey(spSellingItemId);

		return spSellingItem;
	}

	/**
	 * Removes the s p selling item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spSellingItemId the primary key of the s p selling item
	 * @return the s p selling item that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a s p selling item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem remove(long spSellingItemId)
		throws NoSuchSPSellingItemException, SystemException {
		return remove((Serializable)spSellingItemId);
	}

	/**
	 * Removes the s p selling item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p selling item
	 * @return the s p selling item that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a s p selling item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem remove(Serializable primaryKey)
		throws NoSuchSPSellingItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPSellingItem spSellingItem = (SPSellingItem)session.get(SPSellingItemImpl.class,
					primaryKey);

			if (spSellingItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPSellingItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spSellingItem);
		}
		catch (NoSuchSPSellingItemException nsee) {
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
	protected SPSellingItem removeImpl(SPSellingItem spSellingItem)
		throws SystemException {
		spSellingItem = toUnwrappedModel(spSellingItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spSellingItem)) {
				spSellingItem = (SPSellingItem)session.get(SPSellingItemImpl.class,
						spSellingItem.getPrimaryKeyObj());
			}

			if (spSellingItem != null) {
				session.delete(spSellingItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spSellingItem != null) {
			clearCache(spSellingItem);
		}

		return spSellingItem;
	}

	@Override
	public SPSellingItem updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPSellingItem spSellingItem)
		throws SystemException {
		spSellingItem = toUnwrappedModel(spSellingItem);

		boolean isNew = spSellingItem.isNew();

		SPSellingItemModelImpl spSellingItemModelImpl = (SPSellingItemModelImpl)spSellingItem;

		Session session = null;

		try {
			session = openSession();

			if (spSellingItem.isNew()) {
				session.save(spSellingItem);

				spSellingItem.setNew(false);
			}
			else {
				session.merge(spSellingItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPSellingItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spSellingItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSellingItemModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { spSellingItemModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingItemImpl.class, spSellingItem.getPrimaryKey(),
			spSellingItem);

		clearUniqueFindersCache(spSellingItem);
		cacheUniqueFindersCache(spSellingItem);

		return spSellingItem;
	}

	protected SPSellingItem toUnwrappedModel(SPSellingItem spSellingItem) {
		if (spSellingItem instanceof SPSellingItemImpl) {
			return spSellingItem;
		}

		SPSellingItemImpl spSellingItemImpl = new SPSellingItemImpl();

		spSellingItemImpl.setNew(spSellingItem.isNew());
		spSellingItemImpl.setPrimaryKey(spSellingItem.getPrimaryKey());

		spSellingItemImpl.setSpSellingItemId(spSellingItem.getSpSellingItemId());
		spSellingItemImpl.setGroupId(spSellingItem.getGroupId());
		spSellingItemImpl.setTitle(spSellingItem.getTitle());
		spSellingItemImpl.setItemCode(spSellingItem.getItemCode());
		spSellingItemImpl.setEntityClassPk(spSellingItem.getEntityClassPk());
		spSellingItemImpl.setEntityClassNameId(spSellingItem.getEntityClassNameId());
		spSellingItemImpl.setEntityClassName(spSellingItem.getEntityClassName());
		spSellingItemImpl.setShortDescription(spSellingItem.getShortDescription());
		spSellingItemImpl.setLongDescription(spSellingItem.getLongDescription());
		spSellingItemImpl.setActive(spSellingItem.isActive());
		spSellingItemImpl.setCompanyId(spSellingItem.getCompanyId());
		spSellingItemImpl.setUserId(spSellingItem.getUserId());
		spSellingItemImpl.setUserName(spSellingItem.getUserName());
		spSellingItemImpl.setCreateDate(spSellingItem.getCreateDate());
		spSellingItemImpl.setModifiedDate(spSellingItem.getModifiedDate());

		return spSellingItemImpl;
	}

	/**
	 * Returns the s p selling item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p selling item
	 * @return the s p selling item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a s p selling item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPSellingItemException, SystemException {
		SPSellingItem spSellingItem = fetchByPrimaryKey(primaryKey);

		if (spSellingItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPSellingItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spSellingItem;
	}

	/**
	 * Returns the s p selling item with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException} if it could not be found.
	 *
	 * @param spSellingItemId the primary key of the s p selling item
	 * @return the s p selling item
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingItemException if a s p selling item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem findByPrimaryKey(long spSellingItemId)
		throws NoSuchSPSellingItemException, SystemException {
		return findByPrimaryKey((Serializable)spSellingItemId);
	}

	/**
	 * Returns the s p selling item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p selling item
	 * @return the s p selling item, or <code>null</code> if a s p selling item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPSellingItem spSellingItem = (SPSellingItem)EntityCacheUtil.getResult(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
				SPSellingItemImpl.class, primaryKey);

		if (spSellingItem == _nullSPSellingItem) {
			return null;
		}

		if (spSellingItem == null) {
			Session session = null;

			try {
				session = openSession();

				spSellingItem = (SPSellingItem)session.get(SPSellingItemImpl.class,
						primaryKey);

				if (spSellingItem != null) {
					cacheResult(spSellingItem);
				}
				else {
					EntityCacheUtil.putResult(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
						SPSellingItemImpl.class, primaryKey, _nullSPSellingItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPSellingItemModelImpl.ENTITY_CACHE_ENABLED,
					SPSellingItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spSellingItem;
	}

	/**
	 * Returns the s p selling item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spSellingItemId the primary key of the s p selling item
	 * @return the s p selling item, or <code>null</code> if a s p selling item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingItem fetchByPrimaryKey(long spSellingItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spSellingItemId);
	}

	/**
	 * Returns all the s p selling items.
	 *
	 * @return the s p selling items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p selling items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p selling items
	 * @param end the upper bound of the range of s p selling items (not inclusive)
	 * @return the range of s p selling items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p selling items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p selling items
	 * @param end the upper bound of the range of s p selling items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p selling items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingItem> findAll(int start, int end,
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

		List<SPSellingItem> list = (List<SPSellingItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSELLINGITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSELLINGITEM;

				if (pagination) {
					sql = sql.concat(SPSellingItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPSellingItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSellingItem>(list);
				}
				else {
					list = (List<SPSellingItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p selling items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPSellingItem spSellingItem : findAll()) {
			remove(spSellingItem);
		}
	}

	/**
	 * Returns the number of s p selling items.
	 *
	 * @return the number of s p selling items
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

				Query q = session.createQuery(_SQL_COUNT_SPSELLINGITEM);

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
	 * Initializes the s p selling item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spshopping.model.SPSellingItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPSellingItem>> listenersList = new ArrayList<ModelListener<SPSellingItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPSellingItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPSellingItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSELLINGITEM = "SELECT spSellingItem FROM SPSellingItem spSellingItem";
	private static final String _SQL_SELECT_SPSELLINGITEM_WHERE = "SELECT spSellingItem FROM SPSellingItem spSellingItem WHERE ";
	private static final String _SQL_COUNT_SPSELLINGITEM = "SELECT COUNT(spSellingItem) FROM SPSellingItem spSellingItem";
	private static final String _SQL_COUNT_SPSELLINGITEM_WHERE = "SELECT COUNT(spSellingItem) FROM SPSellingItem spSellingItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spSellingItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPSellingItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPSellingItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPSellingItemPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static SPSellingItem _nullSPSellingItem = new SPSellingItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPSellingItem> toCacheModel() {
				return _nullSPSellingItemCacheModel;
			}
		};

	private static CacheModel<SPSellingItem> _nullSPSellingItemCacheModel = new CacheModel<SPSellingItem>() {
			@Override
			public SPSellingItem toEntityModel() {
				return _nullSPSellingItem;
			}
		};
}