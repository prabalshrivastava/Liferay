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

package com.sambaash.platform.srv.spservices.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spservices.NoSuchSPSiteException;
import com.sambaash.platform.srv.spservices.model.SPSite;
import com.sambaash.platform.srv.spservices.model.impl.SPSiteImpl;
import com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPSitePersistence
 * @see SPSiteUtil
 * @generated
 */
public class SPSitePersistenceImpl extends BasePersistenceImpl<SPSite>
	implements SPSitePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPSiteUtil} to access the s p site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPSiteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPSiteModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p sites where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sites where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @return the range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p sites where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<SPSite> list = (List<SPSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSite spSite : list) {
				if (!Validator.equals(uuid, spSite.getUuid())) {
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

			query.append(_SQL_SELECT_SPSITE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSite>(list);
				}
				else {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first s p site in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUuid_First(uuid, orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the first s p site in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSite> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUuid_Last(uuid, orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the last s p site in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPSite> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sites before and after the current s p site in the ordered set where uuid = &#63;.
	 *
	 * @param spSiteId the primary key of the current s p site
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite[] findByUuid_PrevAndNext(long spSiteId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = findByPrimaryKey(spSiteId);

		Session session = null;

		try {
			session = openSession();

			SPSite[] array = new SPSiteImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spSite, uuid,
					orderByComparator, true);

			array[1] = spSite;

			array[2] = getByUuid_PrevAndNext(session, spSite, uuid,
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

	protected SPSite getByUuid_PrevAndNext(Session session, SPSite spSite,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			query.append(SPSiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sites where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPSite spSite : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spSite);
		}
	}

	/**
	 * Returns the number of s p sites where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSITE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spSite.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spSite.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spSite.uuid IS NULL OR spSite.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPSiteModelImpl.UUID_COLUMN_BITMASK |
			SPSiteModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p site where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUUID_G(String uuid, long groupId)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUUID_G(uuid, groupId);

		if (spSite == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPSiteException(msg.toString());
		}

		return spSite;
	}

	/**
	 * Returns the s p site where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p site where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPSite) {
			SPSite spSite = (SPSite)result;

			if (!Validator.equals(uuid, spSite.getUuid()) ||
					(groupId != spSite.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPSITE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<SPSite> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPSite spSite = list.get(0);

					result = spSite;

					cacheResult(spSite);

					if ((spSite.getUuid() == null) ||
							!spSite.getUuid().equals(uuid) ||
							(spSite.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spSite);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (SPSite)result;
		}
	}

	/**
	 * Removes the s p site where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p site that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = findByUUID_G(uuid, groupId);

		return remove(spSite);
	}

	/**
	 * Returns the number of s p sites where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSITE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spSite.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spSite.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spSite.uuid IS NULL OR spSite.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spSite.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPSiteModelImpl.UUID_COLUMN_BITMASK |
			SPSiteModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p sites where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sites where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @return the range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p sites where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<SPSite> list = (List<SPSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSite spSite : list) {
				if (!Validator.equals(uuid, spSite.getUuid()) ||
						(companyId != spSite.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPSITE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSite>(list);
				}
				else {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the first s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSite> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the last s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPSite> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sites before and after the current s p site in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spSiteId the primary key of the current s p site
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite[] findByUuid_C_PrevAndNext(long spSiteId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = findByPrimaryKey(spSiteId);

		Session session = null;

		try {
			session = openSession();

			SPSite[] array = new SPSiteImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spSite, uuid,
					companyId, orderByComparator, true);

			array[1] = spSite;

			array[2] = getByUuid_C_PrevAndNext(session, spSite, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSite getByUuid_C_PrevAndNext(Session session, SPSite spSite,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(SPSiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sites where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPSite spSite : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spSite);
		}
	}

	/**
	 * Returns the number of s p sites where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSITE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spSite.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spSite.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spSite.uuid IS NULL OR spSite.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spSite.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			SPSiteModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p sites where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sites where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @return the range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p sites where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<SPSite> list = (List<SPSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSite spSite : list) {
				if ((userId != spSite.getUserId())) {
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

			query.append(_SQL_SELECT_SPSITE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSite>(list);
				}
				else {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first s p site in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUserId_First(userId, orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the first s p site in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSite> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUserId_Last(userId, orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the last s p site in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SPSite> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sites before and after the current s p site in the ordered set where userId = &#63;.
	 *
	 * @param spSiteId the primary key of the current s p site
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite[] findByUserId_PrevAndNext(long spSiteId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = findByPrimaryKey(spSiteId);

		Session session = null;

		try {
			session = openSession();

			SPSite[] array = new SPSiteImpl[3];

			array[0] = getByUserId_PrevAndNext(session, spSite, userId,
					orderByComparator, true);

			array[1] = spSite;

			array[2] = getByUserId_PrevAndNext(session, spSite, userId,
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

	protected SPSite getByUserId_PrevAndNext(Session session, SPSite spSite,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITE_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(SPSiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sites where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (SPSite spSite : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spSite);
		}
	}

	/**
	 * Returns the number of s p sites where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSITE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "spSite.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDVIRTUALHOSTID =
		new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdAndVirtualHostId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDVIRTUALHOSTID =
		new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndVirtualHostId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPSiteModelImpl.USERID_COLUMN_BITMASK |
			SPSiteModelImpl.VIRTUALHOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDVIRTUALHOSTID = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndVirtualHostId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p sites where userId = &#63; and virtualHostId = &#63;.
	 *
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @return the matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUserIdAndVirtualHostId(long userId,
		long virtualHostId) throws SystemException {
		return findByUserIdAndVirtualHostId(userId, virtualHostId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sites where userId = &#63; and virtualHostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @return the range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUserIdAndVirtualHostId(long userId,
		long virtualHostId, int start, int end) throws SystemException {
		return findByUserIdAndVirtualHostId(userId, virtualHostId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p sites where userId = &#63; and virtualHostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUserIdAndVirtualHostId(long userId,
		long virtualHostId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDVIRTUALHOSTID;
			finderArgs = new Object[] { userId, virtualHostId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDVIRTUALHOSTID;
			finderArgs = new Object[] {
					userId, virtualHostId,
					
					start, end, orderByComparator
				};
		}

		List<SPSite> list = (List<SPSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSite spSite : list) {
				if ((userId != spSite.getUserId()) ||
						(virtualHostId != spSite.getVirtualHostId())) {
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

			query.append(_SQL_SELECT_SPSITE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDVIRTUALHOSTID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDVIRTUALHOSTID_VIRTUALHOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(virtualHostId);

				if (!pagination) {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSite>(list);
				}
				else {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	 *
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUserIdAndVirtualHostId_First(long userId,
		long virtualHostId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUserIdAndVirtualHostId_First(userId,
				virtualHostId, orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", virtualHostId=");
		msg.append(virtualHostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the first s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	 *
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUserIdAndVirtualHostId_First(long userId,
		long virtualHostId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPSite> list = findByUserIdAndVirtualHostId(userId, virtualHostId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	 *
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUserIdAndVirtualHostId_Last(long userId,
		long virtualHostId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUserIdAndVirtualHostId_Last(userId,
				virtualHostId, orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", virtualHostId=");
		msg.append(virtualHostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the last s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	 *
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUserIdAndVirtualHostId_Last(long userId,
		long virtualHostId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdAndVirtualHostId(userId, virtualHostId);

		if (count == 0) {
			return null;
		}

		List<SPSite> list = findByUserIdAndVirtualHostId(userId, virtualHostId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sites before and after the current s p site in the ordered set where userId = &#63; and virtualHostId = &#63;.
	 *
	 * @param spSiteId the primary key of the current s p site
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite[] findByUserIdAndVirtualHostId_PrevAndNext(long spSiteId,
		long userId, long virtualHostId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = findByPrimaryKey(spSiteId);

		Session session = null;

		try {
			session = openSession();

			SPSite[] array = new SPSiteImpl[3];

			array[0] = getByUserIdAndVirtualHostId_PrevAndNext(session, spSite,
					userId, virtualHostId, orderByComparator, true);

			array[1] = spSite;

			array[2] = getByUserIdAndVirtualHostId_PrevAndNext(session, spSite,
					userId, virtualHostId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSite getByUserIdAndVirtualHostId_PrevAndNext(Session session,
		SPSite spSite, long userId, long virtualHostId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITE_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDVIRTUALHOSTID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDANDVIRTUALHOSTID_VIRTUALHOSTID_2);

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
			query.append(SPSiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(virtualHostId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sites where userId = &#63; and virtualHostId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndVirtualHostId(long userId, long virtualHostId)
		throws SystemException {
		for (SPSite spSite : findByUserIdAndVirtualHostId(userId,
				virtualHostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSite);
		}
	}

	/**
	 * Returns the number of s p sites where userId = &#63; and virtualHostId = &#63;.
	 *
	 * @param userId the user ID
	 * @param virtualHostId the virtual host ID
	 * @return the number of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndVirtualHostId(long userId, long virtualHostId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDVIRTUALHOSTID;

		Object[] finderArgs = new Object[] { userId, virtualHostId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSITE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDVIRTUALHOSTID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDVIRTUALHOSTID_VIRTUALHOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(virtualHostId);

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

	private static final String _FINDER_COLUMN_USERIDANDVIRTUALHOSTID_USERID_2 = "spSite.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDVIRTUALHOSTID_VIRTUALHOSTID_2 =
		"spSite.virtualHostId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDAUTHACCESSID =
		new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdAndAuthAccessId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDAUTHACCESSID =
		new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, SPSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndAuthAccessId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPSiteModelImpl.USERID_COLUMN_BITMASK |
			SPSiteModelImpl.AUTHACCESSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDAUTHACCESSID = new FinderPath(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndAuthAccessId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p sites where userId = &#63; and authAccessId = &#63;.
	 *
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @return the matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUserIdAndAuthAccessId(long userId,
		long authAccessId) throws SystemException {
		return findByUserIdAndAuthAccessId(userId, authAccessId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sites where userId = &#63; and authAccessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @return the range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUserIdAndAuthAccessId(long userId,
		long authAccessId, int start, int end) throws SystemException {
		return findByUserIdAndAuthAccessId(userId, authAccessId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p sites where userId = &#63; and authAccessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findByUserIdAndAuthAccessId(long userId,
		long authAccessId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDAUTHACCESSID;
			finderArgs = new Object[] { userId, authAccessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDAUTHACCESSID;
			finderArgs = new Object[] {
					userId, authAccessId,
					
					start, end, orderByComparator
				};
		}

		List<SPSite> list = (List<SPSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSite spSite : list) {
				if ((userId != spSite.getUserId()) ||
						(authAccessId != spSite.getAuthAccessId())) {
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

			query.append(_SQL_SELECT_SPSITE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDAUTHACCESSID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDAUTHACCESSID_AUTHACCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(authAccessId);

				if (!pagination) {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSite>(list);
				}
				else {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	 *
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUserIdAndAuthAccessId_First(long userId,
		long authAccessId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUserIdAndAuthAccessId_First(userId,
				authAccessId, orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", authAccessId=");
		msg.append(authAccessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the first s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	 *
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUserIdAndAuthAccessId_First(long userId,
		long authAccessId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPSite> list = findByUserIdAndAuthAccessId(userId, authAccessId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	 *
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByUserIdAndAuthAccessId_Last(long userId,
		long authAccessId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByUserIdAndAuthAccessId_Last(userId, authAccessId,
				orderByComparator);

		if (spSite != null) {
			return spSite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", authAccessId=");
		msg.append(authAccessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteException(msg.toString());
	}

	/**
	 * Returns the last s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	 *
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site, or <code>null</code> if a matching s p site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByUserIdAndAuthAccessId_Last(long userId,
		long authAccessId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdAndAuthAccessId(userId, authAccessId);

		if (count == 0) {
			return null;
		}

		List<SPSite> list = findByUserIdAndAuthAccessId(userId, authAccessId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p sites before and after the current s p site in the ordered set where userId = &#63; and authAccessId = &#63;.
	 *
	 * @param spSiteId the primary key of the current s p site
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite[] findByUserIdAndAuthAccessId_PrevAndNext(long spSiteId,
		long userId, long authAccessId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = findByPrimaryKey(spSiteId);

		Session session = null;

		try {
			session = openSession();

			SPSite[] array = new SPSiteImpl[3];

			array[0] = getByUserIdAndAuthAccessId_PrevAndNext(session, spSite,
					userId, authAccessId, orderByComparator, true);

			array[1] = spSite;

			array[2] = getByUserIdAndAuthAccessId_PrevAndNext(session, spSite,
					userId, authAccessId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSite getByUserIdAndAuthAccessId_PrevAndNext(Session session,
		SPSite spSite, long userId, long authAccessId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITE_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDAUTHACCESSID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDANDAUTHACCESSID_AUTHACCESSID_2);

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
			query.append(SPSiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(authAccessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p sites where userId = &#63; and authAccessId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndAuthAccessId(long userId, long authAccessId)
		throws SystemException {
		for (SPSite spSite : findByUserIdAndAuthAccessId(userId, authAccessId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSite);
		}
	}

	/**
	 * Returns the number of s p sites where userId = &#63; and authAccessId = &#63;.
	 *
	 * @param userId the user ID
	 * @param authAccessId the auth access ID
	 * @return the number of matching s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndAuthAccessId(long userId, long authAccessId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDAUTHACCESSID;

		Object[] finderArgs = new Object[] { userId, authAccessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSITE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDAUTHACCESSID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDAUTHACCESSID_AUTHACCESSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(authAccessId);

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

	private static final String _FINDER_COLUMN_USERIDANDAUTHACCESSID_USERID_2 = "spSite.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDAUTHACCESSID_AUTHACCESSID_2 =
		"spSite.authAccessId = ?";

	public SPSitePersistenceImpl() {
		setModelClass(SPSite.class);
	}

	/**
	 * Caches the s p site in the entity cache if it is enabled.
	 *
	 * @param spSite the s p site
	 */
	@Override
	public void cacheResult(SPSite spSite) {
		EntityCacheUtil.putResult(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteImpl.class, spSite.getPrimaryKey(), spSite);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spSite.getUuid(), spSite.getGroupId() }, spSite);

		spSite.resetOriginalValues();
	}

	/**
	 * Caches the s p sites in the entity cache if it is enabled.
	 *
	 * @param spSites the s p sites
	 */
	@Override
	public void cacheResult(List<SPSite> spSites) {
		for (SPSite spSite : spSites) {
			if (EntityCacheUtil.getResult(
						SPSiteModelImpl.ENTITY_CACHE_ENABLED, SPSiteImpl.class,
						spSite.getPrimaryKey()) == null) {
				cacheResult(spSite);
			}
			else {
				spSite.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p sites.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPSiteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPSiteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p site.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPSite spSite) {
		EntityCacheUtil.removeResult(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteImpl.class, spSite.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spSite);
	}

	@Override
	public void clearCache(List<SPSite> spSites) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPSite spSite : spSites) {
			EntityCacheUtil.removeResult(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
				SPSiteImpl.class, spSite.getPrimaryKey());

			clearUniqueFindersCache(spSite);
		}
	}

	protected void cacheUniqueFindersCache(SPSite spSite) {
		if (spSite.isNew()) {
			Object[] args = new Object[] { spSite.getUuid(), spSite.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, spSite);
		}
		else {
			SPSiteModelImpl spSiteModelImpl = (SPSiteModelImpl)spSite;

			if ((spSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSite.getUuid(), spSite.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spSite);
			}
		}
	}

	protected void clearUniqueFindersCache(SPSite spSite) {
		SPSiteModelImpl spSiteModelImpl = (SPSiteModelImpl)spSite;

		Object[] args = new Object[] { spSite.getUuid(), spSite.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spSiteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSiteModelImpl.getOriginalUuid(),
					spSiteModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new s p site with the primary key. Does not add the s p site to the database.
	 *
	 * @param spSiteId the primary key for the new s p site
	 * @return the new s p site
	 */
	@Override
	public SPSite create(long spSiteId) {
		SPSite spSite = new SPSiteImpl();

		spSite.setNew(true);
		spSite.setPrimaryKey(spSiteId);

		String uuid = PortalUUIDUtil.generate();

		spSite.setUuid(uuid);

		return spSite;
	}

	/**
	 * Removes the s p site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spSiteId the primary key of the s p site
	 * @return the s p site that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite remove(long spSiteId)
		throws NoSuchSPSiteException, SystemException {
		return remove((Serializable)spSiteId);
	}

	/**
	 * Removes the s p site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p site
	 * @return the s p site that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite remove(Serializable primaryKey)
		throws NoSuchSPSiteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPSite spSite = (SPSite)session.get(SPSiteImpl.class, primaryKey);

			if (spSite == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spSite);
		}
		catch (NoSuchSPSiteException nsee) {
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
	protected SPSite removeImpl(SPSite spSite) throws SystemException {
		spSite = toUnwrappedModel(spSite);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spSite)) {
				spSite = (SPSite)session.get(SPSiteImpl.class,
						spSite.getPrimaryKeyObj());
			}

			if (spSite != null) {
				session.delete(spSite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spSite != null) {
			clearCache(spSite);
		}

		return spSite;
	}

	@Override
	public SPSite updateImpl(
		com.sambaash.platform.srv.spservices.model.SPSite spSite)
		throws SystemException {
		spSite = toUnwrappedModel(spSite);

		boolean isNew = spSite.isNew();

		SPSiteModelImpl spSiteModelImpl = (SPSiteModelImpl)spSite;

		if (Validator.isNull(spSite.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spSite.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spSite.isNew()) {
				session.save(spSite);

				spSite.setNew(false);
			}
			else {
				session.merge(spSite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPSiteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spSiteModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spSiteModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteModelImpl.getOriginalUuid(),
						spSiteModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spSiteModelImpl.getUuid(),
						spSiteModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spSiteModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { spSiteModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((spSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDVIRTUALHOSTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteModelImpl.getOriginalUserId(),
						spSiteModelImpl.getOriginalVirtualHostId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDVIRTUALHOSTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDVIRTUALHOSTID,
					args);

				args = new Object[] {
						spSiteModelImpl.getUserId(),
						spSiteModelImpl.getVirtualHostId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDVIRTUALHOSTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDVIRTUALHOSTID,
					args);
			}

			if ((spSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDAUTHACCESSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteModelImpl.getOriginalUserId(),
						spSiteModelImpl.getOriginalAuthAccessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDAUTHACCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDAUTHACCESSID,
					args);

				args = new Object[] {
						spSiteModelImpl.getUserId(),
						spSiteModelImpl.getAuthAccessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDAUTHACCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDAUTHACCESSID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteImpl.class, spSite.getPrimaryKey(), spSite);

		clearUniqueFindersCache(spSite);
		cacheUniqueFindersCache(spSite);

		return spSite;
	}

	protected SPSite toUnwrappedModel(SPSite spSite) {
		if (spSite instanceof SPSiteImpl) {
			return spSite;
		}

		SPSiteImpl spSiteImpl = new SPSiteImpl();

		spSiteImpl.setNew(spSite.isNew());
		spSiteImpl.setPrimaryKey(spSite.getPrimaryKey());

		spSiteImpl.setUuid(spSite.getUuid());
		spSiteImpl.setSpSiteId(spSite.getSpSiteId());
		spSiteImpl.setGroupId(spSite.getGroupId());
		spSiteImpl.setCompanyId(spSite.getCompanyId());
		spSiteImpl.setUserId(spSite.getUserId());
		spSiteImpl.setUserName(spSite.getUserName());
		spSiteImpl.setCreateDate(spSite.getCreateDate());
		spSiteImpl.setModifiedDate(spSite.getModifiedDate());
		spSiteImpl.setVirtualHostId(spSite.getVirtualHostId());
		spSiteImpl.setLayoutSetId(spSite.getLayoutSetId());
		spSiteImpl.setAuthAccessId(spSite.getAuthAccessId());
		spSiteImpl.setLoginType(spSite.getLoginType());
		spSiteImpl.setPassword(spSite.getPassword());
		spSiteImpl.setActive(spSite.isActive());

		return spSiteImpl;
	}

	/**
	 * Returns the s p site with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p site
	 * @return the s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPSiteException, SystemException {
		SPSite spSite = fetchByPrimaryKey(primaryKey);

		if (spSite == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spSite;
	}

	/**
	 * Returns the s p site with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteException} if it could not be found.
	 *
	 * @param spSiteId the primary key of the s p site
	 * @return the s p site
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteException if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite findByPrimaryKey(long spSiteId)
		throws NoSuchSPSiteException, SystemException {
		return findByPrimaryKey((Serializable)spSiteId);
	}

	/**
	 * Returns the s p site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p site
	 * @return the s p site, or <code>null</code> if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPSite spSite = (SPSite)EntityCacheUtil.getResult(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
				SPSiteImpl.class, primaryKey);

		if (spSite == _nullSPSite) {
			return null;
		}

		if (spSite == null) {
			Session session = null;

			try {
				session = openSession();

				spSite = (SPSite)session.get(SPSiteImpl.class, primaryKey);

				if (spSite != null) {
					cacheResult(spSite);
				}
				else {
					EntityCacheUtil.putResult(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
						SPSiteImpl.class, primaryKey, _nullSPSite);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPSiteModelImpl.ENTITY_CACHE_ENABLED,
					SPSiteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spSite;
	}

	/**
	 * Returns the s p site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spSiteId the primary key of the s p site
	 * @return the s p site, or <code>null</code> if a s p site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSite fetchByPrimaryKey(long spSiteId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spSiteId);
	}

	/**
	 * Returns all the s p sites.
	 *
	 * @return the s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @return the range of s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p sites
	 * @param end the upper bound of the range of s p sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSite> findAll(int start, int end,
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

		List<SPSite> list = (List<SPSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSITE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSITE;

				if (pagination) {
					sql = sql.concat(SPSiteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSite>(list);
				}
				else {
					list = (List<SPSite>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the s p sites from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPSite spSite : findAll()) {
			remove(spSite);
		}
	}

	/**
	 * Returns the number of s p sites.
	 *
	 * @return the number of s p sites
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

				Query q = session.createQuery(_SQL_COUNT_SPSITE);

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
	 * Initializes the s p site persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.SPSite")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPSite>> listenersList = new ArrayList<ModelListener<SPSite>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPSite>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPSiteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSITE = "SELECT spSite FROM SPSite spSite";
	private static final String _SQL_SELECT_SPSITE_WHERE = "SELECT spSite FROM SPSite spSite WHERE ";
	private static final String _SQL_COUNT_SPSITE = "SELECT COUNT(spSite) FROM SPSite spSite";
	private static final String _SQL_COUNT_SPSITE_WHERE = "SELECT COUNT(spSite) FROM SPSite spSite WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spSite.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPSite exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPSite exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPSitePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "password", "active"
			});
	private static SPSite _nullSPSite = new SPSiteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPSite> toCacheModel() {
				return _nullSPSiteCacheModel;
			}
		};

	private static CacheModel<SPSite> _nullSPSiteCacheModel = new CacheModel<SPSite>() {
			@Override
			public SPSite toEntityModel() {
				return _nullSPSite;
			}
		};
}