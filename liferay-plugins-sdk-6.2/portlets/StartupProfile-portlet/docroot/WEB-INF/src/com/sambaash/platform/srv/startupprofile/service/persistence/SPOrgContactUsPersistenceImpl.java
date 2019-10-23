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

package com.sambaash.platform.srv.startupprofile.service.persistence;

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

import com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException;
import com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs;
import com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p org contact us service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPOrgContactUsPersistence
 * @see SPOrgContactUsUtil
 * @generated
 */
public class SPOrgContactUsPersistenceImpl extends BasePersistenceImpl<SPOrgContactUs>
	implements SPOrgContactUsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPOrgContactUsUtil} to access the s p org contact us persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPOrgContactUsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPOrgContactUsModelImpl.FINDER_CACHE_ENABLED,
			SPOrgContactUsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPOrgContactUsModelImpl.FINDER_CACHE_ENABLED,
			SPOrgContactUsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPOrgContactUsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPOrgContactUsModelImpl.FINDER_CACHE_ENABLED,
			SPOrgContactUsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPOrgContactUsModelImpl.FINDER_CACHE_ENABLED,
			SPOrgContactUsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			SPOrgContactUsModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPOrgContactUsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p org contact uses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching s p org contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPOrgContactUs> findByOrganizationId(long organizationId)
		throws SystemException {
		return findByOrganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p org contact uses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of s p org contact uses
	 * @param end the upper bound of the range of s p org contact uses (not inclusive)
	 * @return the range of matching s p org contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPOrgContactUs> findByOrganizationId(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p org contact uses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of s p org contact uses
	 * @param end the upper bound of the range of s p org contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p org contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPOrgContactUs> findByOrganizationId(long organizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<SPOrgContactUs> list = (List<SPOrgContactUs>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPOrgContactUs spOrgContactUs : list) {
				if ((organizationId != spOrgContactUs.getOrganizationId())) {
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

			query.append(_SQL_SELECT_SPORGCONTACTUS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPOrgContactUsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<SPOrgContactUs>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPOrgContactUs>(list);
				}
				else {
					list = (List<SPOrgContactUs>)QueryUtil.list(q,
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
	 * Returns the first s p org contact us in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p org contact us
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a matching s p org contact us could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs findByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchSPOrgContactUsException, SystemException {
		SPOrgContactUs spOrgContactUs = fetchByOrganizationId_First(organizationId,
				orderByComparator);

		if (spOrgContactUs != null) {
			return spOrgContactUs;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPOrgContactUsException(msg.toString());
	}

	/**
	 * Returns the first s p org contact us in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p org contact us, or <code>null</code> if a matching s p org contact us could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs fetchByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPOrgContactUs> list = findByOrganizationId(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p org contact us in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p org contact us
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a matching s p org contact us could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs findByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchSPOrgContactUsException, SystemException {
		SPOrgContactUs spOrgContactUs = fetchByOrganizationId_Last(organizationId,
				orderByComparator);

		if (spOrgContactUs != null) {
			return spOrgContactUs;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPOrgContactUsException(msg.toString());
	}

	/**
	 * Returns the last s p org contact us in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p org contact us, or <code>null</code> if a matching s p org contact us could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs fetchByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<SPOrgContactUs> list = findByOrganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p org contact uses before and after the current s p org contact us in the ordered set where organizationId = &#63;.
	 *
	 * @param spContactUsId the primary key of the current s p org contact us
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p org contact us
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a s p org contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs[] findByOrganizationId_PrevAndNext(
		long spContactUsId, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchSPOrgContactUsException, SystemException {
		SPOrgContactUs spOrgContactUs = findByPrimaryKey(spContactUsId);

		Session session = null;

		try {
			session = openSession();

			SPOrgContactUs[] array = new SPOrgContactUsImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session, spOrgContactUs,
					organizationId, orderByComparator, true);

			array[1] = spOrgContactUs;

			array[2] = getByOrganizationId_PrevAndNext(session, spOrgContactUs,
					organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPOrgContactUs getByOrganizationId_PrevAndNext(Session session,
		SPOrgContactUs spOrgContactUs, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPORGCONTACTUS_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

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
			query.append(SPOrgContactUsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spOrgContactUs);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPOrgContactUs> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p org contact uses where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationId)
		throws SystemException {
		for (SPOrgContactUs spOrgContactUs : findByOrganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spOrgContactUs);
		}
	}

	/**
	 * Returns the number of s p org contact uses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching s p org contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationId(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPORGCONTACTUS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "spOrgContactUs.organizationId = ?";

	public SPOrgContactUsPersistenceImpl() {
		setModelClass(SPOrgContactUs.class);
	}

	/**
	 * Caches the s p org contact us in the entity cache if it is enabled.
	 *
	 * @param spOrgContactUs the s p org contact us
	 */
	@Override
	public void cacheResult(SPOrgContactUs spOrgContactUs) {
		EntityCacheUtil.putResult(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPOrgContactUsImpl.class, spOrgContactUs.getPrimaryKey(),
			spOrgContactUs);

		spOrgContactUs.resetOriginalValues();
	}

	/**
	 * Caches the s p org contact uses in the entity cache if it is enabled.
	 *
	 * @param spOrgContactUses the s p org contact uses
	 */
	@Override
	public void cacheResult(List<SPOrgContactUs> spOrgContactUses) {
		for (SPOrgContactUs spOrgContactUs : spOrgContactUses) {
			if (EntityCacheUtil.getResult(
						SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
						SPOrgContactUsImpl.class, spOrgContactUs.getPrimaryKey()) == null) {
				cacheResult(spOrgContactUs);
			}
			else {
				spOrgContactUs.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p org contact uses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPOrgContactUsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPOrgContactUsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p org contact us.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPOrgContactUs spOrgContactUs) {
		EntityCacheUtil.removeResult(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPOrgContactUsImpl.class, spOrgContactUs.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPOrgContactUs> spOrgContactUses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPOrgContactUs spOrgContactUs : spOrgContactUses) {
			EntityCacheUtil.removeResult(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
				SPOrgContactUsImpl.class, spOrgContactUs.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p org contact us with the primary key. Does not add the s p org contact us to the database.
	 *
	 * @param spContactUsId the primary key for the new s p org contact us
	 * @return the new s p org contact us
	 */
	@Override
	public SPOrgContactUs create(long spContactUsId) {
		SPOrgContactUs spOrgContactUs = new SPOrgContactUsImpl();

		spOrgContactUs.setNew(true);
		spOrgContactUs.setPrimaryKey(spContactUsId);

		return spOrgContactUs;
	}

	/**
	 * Removes the s p org contact us with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spContactUsId the primary key of the s p org contact us
	 * @return the s p org contact us that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a s p org contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs remove(long spContactUsId)
		throws NoSuchSPOrgContactUsException, SystemException {
		return remove((Serializable)spContactUsId);
	}

	/**
	 * Removes the s p org contact us with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p org contact us
	 * @return the s p org contact us that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a s p org contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs remove(Serializable primaryKey)
		throws NoSuchSPOrgContactUsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPOrgContactUs spOrgContactUs = (SPOrgContactUs)session.get(SPOrgContactUsImpl.class,
					primaryKey);

			if (spOrgContactUs == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPOrgContactUsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spOrgContactUs);
		}
		catch (NoSuchSPOrgContactUsException nsee) {
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
	protected SPOrgContactUs removeImpl(SPOrgContactUs spOrgContactUs)
		throws SystemException {
		spOrgContactUs = toUnwrappedModel(spOrgContactUs);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spOrgContactUs)) {
				spOrgContactUs = (SPOrgContactUs)session.get(SPOrgContactUsImpl.class,
						spOrgContactUs.getPrimaryKeyObj());
			}

			if (spOrgContactUs != null) {
				session.delete(spOrgContactUs);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spOrgContactUs != null) {
			clearCache(spOrgContactUs);
		}

		return spOrgContactUs;
	}

	@Override
	public SPOrgContactUs updateImpl(
		com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs spOrgContactUs)
		throws SystemException {
		spOrgContactUs = toUnwrappedModel(spOrgContactUs);

		boolean isNew = spOrgContactUs.isNew();

		SPOrgContactUsModelImpl spOrgContactUsModelImpl = (SPOrgContactUsModelImpl)spOrgContactUs;

		Session session = null;

		try {
			session = openSession();

			if (spOrgContactUs.isNew()) {
				session.save(spOrgContactUs);

				spOrgContactUs.setNew(false);
			}
			else {
				session.merge(spOrgContactUs);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPOrgContactUsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spOrgContactUsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spOrgContactUsModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { spOrgContactUsModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
			SPOrgContactUsImpl.class, spOrgContactUs.getPrimaryKey(),
			spOrgContactUs);

		return spOrgContactUs;
	}

	protected SPOrgContactUs toUnwrappedModel(SPOrgContactUs spOrgContactUs) {
		if (spOrgContactUs instanceof SPOrgContactUsImpl) {
			return spOrgContactUs;
		}

		SPOrgContactUsImpl spOrgContactUsImpl = new SPOrgContactUsImpl();

		spOrgContactUsImpl.setNew(spOrgContactUs.isNew());
		spOrgContactUsImpl.setPrimaryKey(spOrgContactUs.getPrimaryKey());

		spOrgContactUsImpl.setSpContactUsId(spOrgContactUs.getSpContactUsId());
		spOrgContactUsImpl.setGroupId(spOrgContactUs.getGroupId());
		spOrgContactUsImpl.setOrganizationId(spOrgContactUs.getOrganizationId());
		spOrgContactUsImpl.setUserId(spOrgContactUs.getUserId());
		spOrgContactUsImpl.setUserName(spOrgContactUs.getUserName());
		spOrgContactUsImpl.setCreateDate(spOrgContactUs.getCreateDate());
		spOrgContactUsImpl.setModifiedDate(spOrgContactUs.getModifiedDate());
		spOrgContactUsImpl.setSalutation(spOrgContactUs.getSalutation());
		spOrgContactUsImpl.setPerson(spOrgContactUs.getPerson());
		spOrgContactUsImpl.setFirstName(spOrgContactUs.getFirstName());
		spOrgContactUsImpl.setLastName(spOrgContactUs.getLastName());
		spOrgContactUsImpl.setDesignation(spOrgContactUs.getDesignation());
		spOrgContactUsImpl.setQualification(spOrgContactUs.getQualification());
		spOrgContactUsImpl.setQualificationDate(spOrgContactUs.getQualificationDate());
		spOrgContactUsImpl.setEmailAddress(spOrgContactUs.getEmailAddress());
		spOrgContactUsImpl.setDepartment(spOrgContactUs.getDepartment());
		spOrgContactUsImpl.setMobileNumber(spOrgContactUs.getMobileNumber());
		spOrgContactUsImpl.setTelephoneNumber(spOrgContactUs.getTelephoneNumber());
		spOrgContactUsImpl.setFaxNumber(spOrgContactUs.getFaxNumber());
		spOrgContactUsImpl.setBillingContact(spOrgContactUs.isBillingContact());
		spOrgContactUsImpl.setOperationsContact(spOrgContactUs.isOperationsContact());
		spOrgContactUsImpl.setActive(spOrgContactUs.isActive());

		return spOrgContactUsImpl;
	}

	/**
	 * Returns the s p org contact us with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p org contact us
	 * @return the s p org contact us
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a s p org contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPOrgContactUsException, SystemException {
		SPOrgContactUs spOrgContactUs = fetchByPrimaryKey(primaryKey);

		if (spOrgContactUs == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPOrgContactUsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spOrgContactUs;
	}

	/**
	 * Returns the s p org contact us with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException} if it could not be found.
	 *
	 * @param spContactUsId the primary key of the s p org contact us
	 * @return the s p org contact us
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchSPOrgContactUsException if a s p org contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs findByPrimaryKey(long spContactUsId)
		throws NoSuchSPOrgContactUsException, SystemException {
		return findByPrimaryKey((Serializable)spContactUsId);
	}

	/**
	 * Returns the s p org contact us with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p org contact us
	 * @return the s p org contact us, or <code>null</code> if a s p org contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPOrgContactUs spOrgContactUs = (SPOrgContactUs)EntityCacheUtil.getResult(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
				SPOrgContactUsImpl.class, primaryKey);

		if (spOrgContactUs == _nullSPOrgContactUs) {
			return null;
		}

		if (spOrgContactUs == null) {
			Session session = null;

			try {
				session = openSession();

				spOrgContactUs = (SPOrgContactUs)session.get(SPOrgContactUsImpl.class,
						primaryKey);

				if (spOrgContactUs != null) {
					cacheResult(spOrgContactUs);
				}
				else {
					EntityCacheUtil.putResult(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
						SPOrgContactUsImpl.class, primaryKey,
						_nullSPOrgContactUs);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPOrgContactUsModelImpl.ENTITY_CACHE_ENABLED,
					SPOrgContactUsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spOrgContactUs;
	}

	/**
	 * Returns the s p org contact us with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spContactUsId the primary key of the s p org contact us
	 * @return the s p org contact us, or <code>null</code> if a s p org contact us with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPOrgContactUs fetchByPrimaryKey(long spContactUsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spContactUsId);
	}

	/**
	 * Returns all the s p org contact uses.
	 *
	 * @return the s p org contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPOrgContactUs> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p org contact uses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p org contact uses
	 * @param end the upper bound of the range of s p org contact uses (not inclusive)
	 * @return the range of s p org contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPOrgContactUs> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p org contact uses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.SPOrgContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p org contact uses
	 * @param end the upper bound of the range of s p org contact uses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p org contact uses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPOrgContactUs> findAll(int start, int end,
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

		List<SPOrgContactUs> list = (List<SPOrgContactUs>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPORGCONTACTUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPORGCONTACTUS;

				if (pagination) {
					sql = sql.concat(SPOrgContactUsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPOrgContactUs>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPOrgContactUs>(list);
				}
				else {
					list = (List<SPOrgContactUs>)QueryUtil.list(q,
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
	 * Removes all the s p org contact uses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPOrgContactUs spOrgContactUs : findAll()) {
			remove(spOrgContactUs);
		}
	}

	/**
	 * Returns the number of s p org contact uses.
	 *
	 * @return the number of s p org contact uses
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

				Query q = session.createQuery(_SQL_COUNT_SPORGCONTACTUS);

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
	 * Initializes the s p org contact us persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPOrgContactUs>> listenersList = new ArrayList<ModelListener<SPOrgContactUs>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPOrgContactUs>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPOrgContactUsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPORGCONTACTUS = "SELECT spOrgContactUs FROM SPOrgContactUs spOrgContactUs";
	private static final String _SQL_SELECT_SPORGCONTACTUS_WHERE = "SELECT spOrgContactUs FROM SPOrgContactUs spOrgContactUs WHERE ";
	private static final String _SQL_COUNT_SPORGCONTACTUS = "SELECT COUNT(spOrgContactUs) FROM SPOrgContactUs spOrgContactUs";
	private static final String _SQL_COUNT_SPORGCONTACTUS_WHERE = "SELECT COUNT(spOrgContactUs) FROM SPOrgContactUs spOrgContactUs WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spOrgContactUs.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPOrgContactUs exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPOrgContactUs exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPOrgContactUsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static SPOrgContactUs _nullSPOrgContactUs = new SPOrgContactUsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPOrgContactUs> toCacheModel() {
				return _nullSPOrgContactUsCacheModel;
			}
		};

	private static CacheModel<SPOrgContactUs> _nullSPOrgContactUsCacheModel = new CacheModel<SPOrgContactUs>() {
			@Override
			public SPOrgContactUs toEntityModel() {
				return _nullSPOrgContactUs;
			}
		};
}