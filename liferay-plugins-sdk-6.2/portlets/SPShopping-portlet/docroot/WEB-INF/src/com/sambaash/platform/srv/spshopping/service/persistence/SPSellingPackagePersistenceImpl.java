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

import com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException;
import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p selling package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPSellingPackagePersistence
 * @see SPSellingPackageUtil
 * @generated
 */
public class SPSellingPackagePersistenceImpl extends BasePersistenceImpl<SPSellingPackage>
	implements SPSellingPackagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPSellingPackageUtil} to access the s p selling package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPSellingPackageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPackageModelImpl.FINDER_CACHE_ENABLED,
			SPSellingPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPackageModelImpl.FINDER_CACHE_ENABLED,
			SPSellingPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPackageModelImpl.FINDER_CACHE_ENABLED,
			SPSellingPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByactive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPackageModelImpl.FINDER_CACHE_ENABLED,
			SPSellingPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactive",
			new String[] { Boolean.class.getName() },
			SPSellingPackageModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the s p selling packages where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching s p selling packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPackage> findByactive(boolean active)
		throws SystemException {
		return findByactive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p selling packages where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of s p selling packages
	 * @param end the upper bound of the range of s p selling packages (not inclusive)
	 * @return the range of matching s p selling packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPackage> findByactive(boolean active, int start,
		int end) throws SystemException {
		return findByactive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p selling packages where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of s p selling packages
	 * @param end the upper bound of the range of s p selling packages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p selling packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPackage> findByactive(boolean active, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<SPSellingPackage> list = (List<SPSellingPackage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSellingPackage spSellingPackage : list) {
				if ((active != spSellingPackage.getActive())) {
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

			query.append(_SQL_SELECT_SPSELLINGPACKAGE_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSellingPackageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<SPSellingPackage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSellingPackage>(list);
				}
				else {
					list = (List<SPSellingPackage>)QueryUtil.list(q,
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
	 * Returns the first s p selling package in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p selling package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a matching s p selling package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage findByactive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchSPSellingPackageException, SystemException {
		SPSellingPackage spSellingPackage = fetchByactive_First(active,
				orderByComparator);

		if (spSellingPackage != null) {
			return spSellingPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSellingPackageException(msg.toString());
	}

	/**
	 * Returns the first s p selling package in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p selling package, or <code>null</code> if a matching s p selling package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage fetchByactive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSellingPackage> list = findByactive(active, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p selling package in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p selling package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a matching s p selling package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage findByactive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchSPSellingPackageException, SystemException {
		SPSellingPackage spSellingPackage = fetchByactive_Last(active,
				orderByComparator);

		if (spSellingPackage != null) {
			return spSellingPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSellingPackageException(msg.toString());
	}

	/**
	 * Returns the last s p selling package in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p selling package, or <code>null</code> if a matching s p selling package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage fetchByactive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByactive(active);

		if (count == 0) {
			return null;
		}

		List<SPSellingPackage> list = findByactive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p selling packages before and after the current s p selling package in the ordered set where active = &#63;.
	 *
	 * @param spSellingPackageId the primary key of the current s p selling package
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p selling package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a s p selling package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage[] findByactive_PrevAndNext(
		long spSellingPackageId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchSPSellingPackageException, SystemException {
		SPSellingPackage spSellingPackage = findByPrimaryKey(spSellingPackageId);

		Session session = null;

		try {
			session = openSession();

			SPSellingPackage[] array = new SPSellingPackageImpl[3];

			array[0] = getByactive_PrevAndNext(session, spSellingPackage,
					active, orderByComparator, true);

			array[1] = spSellingPackage;

			array[2] = getByactive_PrevAndNext(session, spSellingPackage,
					active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSellingPackage getByactive_PrevAndNext(Session session,
		SPSellingPackage spSellingPackage, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSELLINGPACKAGE_WHERE);

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
			query.append(SPSellingPackageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSellingPackage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSellingPackage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p selling packages where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByactive(boolean active) throws SystemException {
		for (SPSellingPackage spSellingPackage : findByactive(active,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSellingPackage);
		}
	}

	/**
	 * Returns the number of s p selling packages where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching s p selling packages
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

			query.append(_SQL_COUNT_SPSELLINGPACKAGE_WHERE);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "spSellingPackage.active = ?";

	public SPSellingPackagePersistenceImpl() {
		setModelClass(SPSellingPackage.class);
	}

	/**
	 * Caches the s p selling package in the entity cache if it is enabled.
	 *
	 * @param spSellingPackage the s p selling package
	 */
	@Override
	public void cacheResult(SPSellingPackage spSellingPackage) {
		EntityCacheUtil.putResult(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPackageImpl.class, spSellingPackage.getPrimaryKey(),
			spSellingPackage);

		spSellingPackage.resetOriginalValues();
	}

	/**
	 * Caches the s p selling packages in the entity cache if it is enabled.
	 *
	 * @param spSellingPackages the s p selling packages
	 */
	@Override
	public void cacheResult(List<SPSellingPackage> spSellingPackages) {
		for (SPSellingPackage spSellingPackage : spSellingPackages) {
			if (EntityCacheUtil.getResult(
						SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
						SPSellingPackageImpl.class,
						spSellingPackage.getPrimaryKey()) == null) {
				cacheResult(spSellingPackage);
			}
			else {
				spSellingPackage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p selling packages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPSellingPackageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPSellingPackageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p selling package.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPSellingPackage spSellingPackage) {
		EntityCacheUtil.removeResult(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPackageImpl.class, spSellingPackage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPSellingPackage> spSellingPackages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPSellingPackage spSellingPackage : spSellingPackages) {
			EntityCacheUtil.removeResult(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
				SPSellingPackageImpl.class, spSellingPackage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p selling package with the primary key. Does not add the s p selling package to the database.
	 *
	 * @param spSellingPackageId the primary key for the new s p selling package
	 * @return the new s p selling package
	 */
	@Override
	public SPSellingPackage create(long spSellingPackageId) {
		SPSellingPackage spSellingPackage = new SPSellingPackageImpl();

		spSellingPackage.setNew(true);
		spSellingPackage.setPrimaryKey(spSellingPackageId);

		return spSellingPackage;
	}

	/**
	 * Removes the s p selling package with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spSellingPackageId the primary key of the s p selling package
	 * @return the s p selling package that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a s p selling package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage remove(long spSellingPackageId)
		throws NoSuchSPSellingPackageException, SystemException {
		return remove((Serializable)spSellingPackageId);
	}

	/**
	 * Removes the s p selling package with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p selling package
	 * @return the s p selling package that was removed
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a s p selling package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage remove(Serializable primaryKey)
		throws NoSuchSPSellingPackageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPSellingPackage spSellingPackage = (SPSellingPackage)session.get(SPSellingPackageImpl.class,
					primaryKey);

			if (spSellingPackage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPSellingPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spSellingPackage);
		}
		catch (NoSuchSPSellingPackageException nsee) {
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
	protected SPSellingPackage removeImpl(SPSellingPackage spSellingPackage)
		throws SystemException {
		spSellingPackage = toUnwrappedModel(spSellingPackage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spSellingPackage)) {
				spSellingPackage = (SPSellingPackage)session.get(SPSellingPackageImpl.class,
						spSellingPackage.getPrimaryKeyObj());
			}

			if (spSellingPackage != null) {
				session.delete(spSellingPackage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spSellingPackage != null) {
			clearCache(spSellingPackage);
		}

		return spSellingPackage;
	}

	@Override
	public SPSellingPackage updateImpl(
		com.sambaash.platform.srv.spshopping.model.SPSellingPackage spSellingPackage)
		throws SystemException {
		spSellingPackage = toUnwrappedModel(spSellingPackage);

		boolean isNew = spSellingPackage.isNew();

		SPSellingPackageModelImpl spSellingPackageModelImpl = (SPSellingPackageModelImpl)spSellingPackage;

		Session session = null;

		try {
			session = openSession();

			if (spSellingPackage.isNew()) {
				session.save(spSellingPackage);

				spSellingPackage.setNew(false);
			}
			else {
				session.merge(spSellingPackage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPSellingPackageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spSellingPackageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSellingPackageModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { spSellingPackageModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
			SPSellingPackageImpl.class, spSellingPackage.getPrimaryKey(),
			spSellingPackage);

		return spSellingPackage;
	}

	protected SPSellingPackage toUnwrappedModel(
		SPSellingPackage spSellingPackage) {
		if (spSellingPackage instanceof SPSellingPackageImpl) {
			return spSellingPackage;
		}

		SPSellingPackageImpl spSellingPackageImpl = new SPSellingPackageImpl();

		spSellingPackageImpl.setNew(spSellingPackage.isNew());
		spSellingPackageImpl.setPrimaryKey(spSellingPackage.getPrimaryKey());

		spSellingPackageImpl.setSpSellingPackageId(spSellingPackage.getSpSellingPackageId());
		spSellingPackageImpl.setGroupId(spSellingPackage.getGroupId());
		spSellingPackageImpl.setTitle(spSellingPackage.getTitle());
		spSellingPackageImpl.setPkgCode(spSellingPackage.getPkgCode());
		spSellingPackageImpl.setShortDescription(spSellingPackage.getShortDescription());
		spSellingPackageImpl.setLongDescription(spSellingPackage.getLongDescription());
		spSellingPackageImpl.setCurrencyCode(spSellingPackage.getCurrencyCode());
		spSellingPackageImpl.setStartDate(spSellingPackage.getStartDate());
		spSellingPackageImpl.setEndDate(spSellingPackage.getEndDate());
		spSellingPackageImpl.setNotify(spSellingPackage.getNotify());
		spSellingPackageImpl.setNeedsPayment(spSellingPackage.isNeedsPayment());
		spSellingPackageImpl.setOrderPage(spSellingPackage.getOrderPage());
		spSellingPackageImpl.setOrderSequence(spSellingPackage.getOrderSequence());
		spSellingPackageImpl.setActive(spSellingPackage.isActive());
		spSellingPackageImpl.setCompanyId(spSellingPackage.getCompanyId());
		spSellingPackageImpl.setUserId(spSellingPackage.getUserId());
		spSellingPackageImpl.setUserName(spSellingPackage.getUserName());
		spSellingPackageImpl.setCreateDate(spSellingPackage.getCreateDate());
		spSellingPackageImpl.setModifiedDate(spSellingPackage.getModifiedDate());

		return spSellingPackageImpl;
	}

	/**
	 * Returns the s p selling package with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p selling package
	 * @return the s p selling package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a s p selling package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPSellingPackageException, SystemException {
		SPSellingPackage spSellingPackage = fetchByPrimaryKey(primaryKey);

		if (spSellingPackage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPSellingPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spSellingPackage;
	}

	/**
	 * Returns the s p selling package with the primary key or throws a {@link com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException} if it could not be found.
	 *
	 * @param spSellingPackageId the primary key of the s p selling package
	 * @return the s p selling package
	 * @throws com.sambaash.platform.srv.spshopping.NoSuchSPSellingPackageException if a s p selling package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage findByPrimaryKey(long spSellingPackageId)
		throws NoSuchSPSellingPackageException, SystemException {
		return findByPrimaryKey((Serializable)spSellingPackageId);
	}

	/**
	 * Returns the s p selling package with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p selling package
	 * @return the s p selling package, or <code>null</code> if a s p selling package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPSellingPackage spSellingPackage = (SPSellingPackage)EntityCacheUtil.getResult(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
				SPSellingPackageImpl.class, primaryKey);

		if (spSellingPackage == _nullSPSellingPackage) {
			return null;
		}

		if (spSellingPackage == null) {
			Session session = null;

			try {
				session = openSession();

				spSellingPackage = (SPSellingPackage)session.get(SPSellingPackageImpl.class,
						primaryKey);

				if (spSellingPackage != null) {
					cacheResult(spSellingPackage);
				}
				else {
					EntityCacheUtil.putResult(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
						SPSellingPackageImpl.class, primaryKey,
						_nullSPSellingPackage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPSellingPackageModelImpl.ENTITY_CACHE_ENABLED,
					SPSellingPackageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spSellingPackage;
	}

	/**
	 * Returns the s p selling package with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spSellingPackageId the primary key of the s p selling package
	 * @return the s p selling package, or <code>null</code> if a s p selling package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSellingPackage fetchByPrimaryKey(long spSellingPackageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spSellingPackageId);
	}

	/**
	 * Returns all the s p selling packages.
	 *
	 * @return the s p selling packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPackage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p selling packages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p selling packages
	 * @param end the upper bound of the range of s p selling packages (not inclusive)
	 * @return the range of s p selling packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPackage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p selling packages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p selling packages
	 * @param end the upper bound of the range of s p selling packages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p selling packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSellingPackage> findAll(int start, int end,
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

		List<SPSellingPackage> list = (List<SPSellingPackage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSELLINGPACKAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSELLINGPACKAGE;

				if (pagination) {
					sql = sql.concat(SPSellingPackageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPSellingPackage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSellingPackage>(list);
				}
				else {
					list = (List<SPSellingPackage>)QueryUtil.list(q,
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
	 * Removes all the s p selling packages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPSellingPackage spSellingPackage : findAll()) {
			remove(spSellingPackage);
		}
	}

	/**
	 * Returns the number of s p selling packages.
	 *
	 * @return the number of s p selling packages
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

				Query q = session.createQuery(_SQL_COUNT_SPSELLINGPACKAGE);

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
	 * Initializes the s p selling package persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spshopping.model.SPSellingPackage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPSellingPackage>> listenersList = new ArrayList<ModelListener<SPSellingPackage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPSellingPackage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPSellingPackageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSELLINGPACKAGE = "SELECT spSellingPackage FROM SPSellingPackage spSellingPackage";
	private static final String _SQL_SELECT_SPSELLINGPACKAGE_WHERE = "SELECT spSellingPackage FROM SPSellingPackage spSellingPackage WHERE ";
	private static final String _SQL_COUNT_SPSELLINGPACKAGE = "SELECT COUNT(spSellingPackage) FROM SPSellingPackage spSellingPackage";
	private static final String _SQL_COUNT_SPSELLINGPACKAGE_WHERE = "SELECT COUNT(spSellingPackage) FROM SPSellingPackage spSellingPackage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spSellingPackage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPSellingPackage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPSellingPackage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPSellingPackagePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static SPSellingPackage _nullSPSellingPackage = new SPSellingPackageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPSellingPackage> toCacheModel() {
				return _nullSPSellingPackageCacheModel;
			}
		};

	private static CacheModel<SPSellingPackage> _nullSPSellingPackageCacheModel = new CacheModel<SPSellingPackage>() {
			@Override
			public SPSellingPackage toEntityModel() {
				return _nullSPSellingPackage;
			}
		};
}