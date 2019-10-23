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

package com.sambaash.platform.srv.filter.service.persistence;

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

import com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;
import com.sambaash.platform.srv.filter.model.SPSearchFilter;
import com.sambaash.platform.srv.filter.model.impl.SPSearchFilterImpl;
import com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p search filter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPSearchFilterPersistence
 * @see SPSearchFilterUtil
 * @generated
 */
public class SPSearchFilterPersistenceImpl extends BasePersistenceImpl<SPSearchFilter>
	implements SPSearchFilterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPSearchFilterUtil} to access the s p search filter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPSearchFilterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED,
			SPSearchFilterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED,
			SPSearchFilterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED,
			SPSearchFilterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED,
			SPSearchFilterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPSearchFilterModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p search filters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p search filters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p search filters
	 * @param end the upper bound of the range of s p search filters (not inclusive)
	 * @return the range of matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p search filters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p search filters
	 * @param end the upper bound of the range of s p search filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findByUuid(String uuid, int start, int end,
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

		List<SPSearchFilter> list = (List<SPSearchFilter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSearchFilter spSearchFilter : list) {
				if (!Validator.equals(uuid, spSearchFilter.getUuid())) {
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

			query.append(_SQL_SELECT_SPSEARCHFILTER_WHERE);

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
				query.append(SPSearchFilterModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPSearchFilter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSearchFilter>(list);
				}
				else {
					list = (List<SPSearchFilter>)QueryUtil.list(q,
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
	 * Returns the first s p search filter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = fetchByUuid_First(uuid,
				orderByComparator);

		if (spSearchFilter != null) {
			return spSearchFilter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSearchFilterException(msg.toString());
	}

	/**
	 * Returns the first s p search filter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSearchFilter> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p search filter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = fetchByUuid_Last(uuid, orderByComparator);

		if (spSearchFilter != null) {
			return spSearchFilter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSearchFilterException(msg.toString());
	}

	/**
	 * Returns the last s p search filter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPSearchFilter> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p search filters before and after the current s p search filter in the ordered set where uuid = &#63;.
	 *
	 * @param spSearchFilterId the primary key of the current s p search filter
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter[] findByUuid_PrevAndNext(long spSearchFilterId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = findByPrimaryKey(spSearchFilterId);

		Session session = null;

		try {
			session = openSession();

			SPSearchFilter[] array = new SPSearchFilterImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spSearchFilter, uuid,
					orderByComparator, true);

			array[1] = spSearchFilter;

			array[2] = getByUuid_PrevAndNext(session, spSearchFilter, uuid,
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

	protected SPSearchFilter getByUuid_PrevAndNext(Session session,
		SPSearchFilter spSearchFilter, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSEARCHFILTER_WHERE);

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
			query.append(SPSearchFilterModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spSearchFilter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSearchFilter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p search filters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPSearchFilter spSearchFilter : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSearchFilter);
		}
	}

	/**
	 * Returns the number of s p search filters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p search filters
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

			query.append(_SQL_COUNT_SPSEARCHFILTER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spSearchFilter.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spSearchFilter.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spSearchFilter.uuid IS NULL OR spSearchFilter.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED,
			SPSearchFilterImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPSearchFilterModelImpl.UUID_COLUMN_BITMASK |
			SPSearchFilterModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p search filter where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter findByUUID_G(String uuid, long groupId)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = fetchByUUID_G(uuid, groupId);

		if (spSearchFilter == null) {
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

			throw new NoSuchSPSearchFilterException(msg.toString());
		}

		return spSearchFilter;
	}

	/**
	 * Returns the s p search filter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p search filter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPSearchFilter) {
			SPSearchFilter spSearchFilter = (SPSearchFilter)result;

			if (!Validator.equals(uuid, spSearchFilter.getUuid()) ||
					(groupId != spSearchFilter.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPSEARCHFILTER_WHERE);

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

				List<SPSearchFilter> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPSearchFilter spSearchFilter = list.get(0);

					result = spSearchFilter;

					cacheResult(spSearchFilter);

					if ((spSearchFilter.getUuid() == null) ||
							!spSearchFilter.getUuid().equals(uuid) ||
							(spSearchFilter.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spSearchFilter);
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
			return (SPSearchFilter)result;
		}
	}

	/**
	 * Removes the s p search filter where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p search filter that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = findByUUID_G(uuid, groupId);

		return remove(spSearchFilter);
	}

	/**
	 * Returns the number of s p search filters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p search filters
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

			query.append(_SQL_COUNT_SPSEARCHFILTER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spSearchFilter.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spSearchFilter.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spSearchFilter.uuid IS NULL OR spSearchFilter.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spSearchFilter.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED,
			SPSearchFilterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED,
			SPSearchFilterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPSearchFilterModelImpl.UUID_COLUMN_BITMASK |
			SPSearchFilterModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p search filters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p search filters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p search filters
	 * @param end the upper bound of the range of s p search filters (not inclusive)
	 * @return the range of matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p search filters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p search filters
	 * @param end the upper bound of the range of s p search filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<SPSearchFilter> list = (List<SPSearchFilter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSearchFilter spSearchFilter : list) {
				if (!Validator.equals(uuid, spSearchFilter.getUuid()) ||
						(companyId != spSearchFilter.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPSEARCHFILTER_WHERE);

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
				query.append(SPSearchFilterModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPSearchFilter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSearchFilter>(list);
				}
				else {
					list = (List<SPSearchFilter>)QueryUtil.list(q,
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
	 * Returns the first s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spSearchFilter != null) {
			return spSearchFilter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSearchFilterException(msg.toString());
	}

	/**
	 * Returns the first s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSearchFilter> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spSearchFilter != null) {
			return spSearchFilter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSearchFilterException(msg.toString());
	}

	/**
	 * Returns the last s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPSearchFilter> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p search filters before and after the current s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spSearchFilterId the primary key of the current s p search filter
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter[] findByUuid_C_PrevAndNext(long spSearchFilterId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = findByPrimaryKey(spSearchFilterId);

		Session session = null;

		try {
			session = openSession();

			SPSearchFilter[] array = new SPSearchFilterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spSearchFilter, uuid,
					companyId, orderByComparator, true);

			array[1] = spSearchFilter;

			array[2] = getByUuid_C_PrevAndNext(session, spSearchFilter, uuid,
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

	protected SPSearchFilter getByUuid_C_PrevAndNext(Session session,
		SPSearchFilter spSearchFilter, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSEARCHFILTER_WHERE);

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
			query.append(SPSearchFilterModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spSearchFilter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSearchFilter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p search filters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPSearchFilter spSearchFilter : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSearchFilter);
		}
	}

	/**
	 * Returns the number of s p search filters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p search filters
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

			query.append(_SQL_COUNT_SPSEARCHFILTER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spSearchFilter.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spSearchFilter.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spSearchFilter.uuid IS NULL OR spSearchFilter.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spSearchFilter.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED,
			SPSearchFilterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED,
			SPSearchFilterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			SPSearchFilterModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p search filters where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findByuserId(long userId)
		throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p search filters where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p search filters
	 * @param end the upper bound of the range of s p search filters (not inclusive)
	 * @return the range of matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p search filters where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p search filters
	 * @param end the upper bound of the range of s p search filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findByuserId(long userId, int start, int end,
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

		List<SPSearchFilter> list = (List<SPSearchFilter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSearchFilter spSearchFilter : list) {
				if ((userId != spSearchFilter.getUserId())) {
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

			query.append(_SQL_SELECT_SPSEARCHFILTER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSearchFilterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPSearchFilter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSearchFilter>(list);
				}
				else {
					list = (List<SPSearchFilter>)QueryUtil.list(q,
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
	 * Returns the first s p search filter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = fetchByuserId_First(userId,
				orderByComparator);

		if (spSearchFilter != null) {
			return spSearchFilter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSearchFilterException(msg.toString());
	}

	/**
	 * Returns the first s p search filter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSearchFilter> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p search filter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = fetchByuserId_Last(userId,
				orderByComparator);

		if (spSearchFilter != null) {
			return spSearchFilter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSearchFilterException(msg.toString());
	}

	/**
	 * Returns the last s p search filter in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<SPSearchFilter> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p search filters before and after the current s p search filter in the ordered set where userId = &#63;.
	 *
	 * @param spSearchFilterId the primary key of the current s p search filter
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter[] findByuserId_PrevAndNext(long spSearchFilterId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = findByPrimaryKey(spSearchFilterId);

		Session session = null;

		try {
			session = openSession();

			SPSearchFilter[] array = new SPSearchFilterImpl[3];

			array[0] = getByuserId_PrevAndNext(session, spSearchFilter, userId,
					orderByComparator, true);

			array[1] = spSearchFilter;

			array[2] = getByuserId_PrevAndNext(session, spSearchFilter, userId,
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

	protected SPSearchFilter getByuserId_PrevAndNext(Session session,
		SPSearchFilter spSearchFilter, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSEARCHFILTER_WHERE);

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
			query.append(SPSearchFilterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSearchFilter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSearchFilter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p search filters where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (SPSearchFilter spSearchFilter : findByuserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSearchFilter);
		}
	}

	/**
	 * Returns the number of s p search filters where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSEARCHFILTER_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "spSearchFilter.userId = ?";

	public SPSearchFilterPersistenceImpl() {
		setModelClass(SPSearchFilter.class);
	}

	/**
	 * Caches the s p search filter in the entity cache if it is enabled.
	 *
	 * @param spSearchFilter the s p search filter
	 */
	@Override
	public void cacheResult(SPSearchFilter spSearchFilter) {
		EntityCacheUtil.putResult(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterImpl.class, spSearchFilter.getPrimaryKey(),
			spSearchFilter);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spSearchFilter.getUuid(), spSearchFilter.getGroupId() },
			spSearchFilter);

		spSearchFilter.resetOriginalValues();
	}

	/**
	 * Caches the s p search filters in the entity cache if it is enabled.
	 *
	 * @param spSearchFilters the s p search filters
	 */
	@Override
	public void cacheResult(List<SPSearchFilter> spSearchFilters) {
		for (SPSearchFilter spSearchFilter : spSearchFilters) {
			if (EntityCacheUtil.getResult(
						SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
						SPSearchFilterImpl.class, spSearchFilter.getPrimaryKey()) == null) {
				cacheResult(spSearchFilter);
			}
			else {
				spSearchFilter.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p search filters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPSearchFilterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPSearchFilterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p search filter.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPSearchFilter spSearchFilter) {
		EntityCacheUtil.removeResult(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterImpl.class, spSearchFilter.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spSearchFilter);
	}

	@Override
	public void clearCache(List<SPSearchFilter> spSearchFilters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPSearchFilter spSearchFilter : spSearchFilters) {
			EntityCacheUtil.removeResult(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
				SPSearchFilterImpl.class, spSearchFilter.getPrimaryKey());

			clearUniqueFindersCache(spSearchFilter);
		}
	}

	protected void cacheUniqueFindersCache(SPSearchFilter spSearchFilter) {
		if (spSearchFilter.isNew()) {
			Object[] args = new Object[] {
					spSearchFilter.getUuid(), spSearchFilter.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spSearchFilter);
		}
		else {
			SPSearchFilterModelImpl spSearchFilterModelImpl = (SPSearchFilterModelImpl)spSearchFilter;

			if ((spSearchFilterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSearchFilter.getUuid(), spSearchFilter.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spSearchFilter);
			}
		}
	}

	protected void clearUniqueFindersCache(SPSearchFilter spSearchFilter) {
		SPSearchFilterModelImpl spSearchFilterModelImpl = (SPSearchFilterModelImpl)spSearchFilter;

		Object[] args = new Object[] {
				spSearchFilter.getUuid(), spSearchFilter.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spSearchFilterModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSearchFilterModelImpl.getOriginalUuid(),
					spSearchFilterModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new s p search filter with the primary key. Does not add the s p search filter to the database.
	 *
	 * @param spSearchFilterId the primary key for the new s p search filter
	 * @return the new s p search filter
	 */
	@Override
	public SPSearchFilter create(long spSearchFilterId) {
		SPSearchFilter spSearchFilter = new SPSearchFilterImpl();

		spSearchFilter.setNew(true);
		spSearchFilter.setPrimaryKey(spSearchFilterId);

		String uuid = PortalUUIDUtil.generate();

		spSearchFilter.setUuid(uuid);

		return spSearchFilter;
	}

	/**
	 * Removes the s p search filter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spSearchFilterId the primary key of the s p search filter
	 * @return the s p search filter that was removed
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter remove(long spSearchFilterId)
		throws NoSuchSPSearchFilterException, SystemException {
		return remove((Serializable)spSearchFilterId);
	}

	/**
	 * Removes the s p search filter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p search filter
	 * @return the s p search filter that was removed
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter remove(Serializable primaryKey)
		throws NoSuchSPSearchFilterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPSearchFilter spSearchFilter = (SPSearchFilter)session.get(SPSearchFilterImpl.class,
					primaryKey);

			if (spSearchFilter == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPSearchFilterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spSearchFilter);
		}
		catch (NoSuchSPSearchFilterException nsee) {
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
	protected SPSearchFilter removeImpl(SPSearchFilter spSearchFilter)
		throws SystemException {
		spSearchFilter = toUnwrappedModel(spSearchFilter);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spSearchFilter)) {
				spSearchFilter = (SPSearchFilter)session.get(SPSearchFilterImpl.class,
						spSearchFilter.getPrimaryKeyObj());
			}

			if (spSearchFilter != null) {
				session.delete(spSearchFilter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spSearchFilter != null) {
			clearCache(spSearchFilter);
		}

		return spSearchFilter;
	}

	@Override
	public SPSearchFilter updateImpl(
		com.sambaash.platform.srv.filter.model.SPSearchFilter spSearchFilter)
		throws SystemException {
		spSearchFilter = toUnwrappedModel(spSearchFilter);

		boolean isNew = spSearchFilter.isNew();

		SPSearchFilterModelImpl spSearchFilterModelImpl = (SPSearchFilterModelImpl)spSearchFilter;

		if (Validator.isNull(spSearchFilter.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spSearchFilter.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spSearchFilter.isNew()) {
				session.save(spSearchFilter);

				spSearchFilter.setNew(false);
			}
			else {
				session.merge(spSearchFilter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPSearchFilterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spSearchFilterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSearchFilterModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spSearchFilterModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spSearchFilterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSearchFilterModelImpl.getOriginalUuid(),
						spSearchFilterModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spSearchFilterModelImpl.getUuid(),
						spSearchFilterModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spSearchFilterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSearchFilterModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { spSearchFilterModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
			SPSearchFilterImpl.class, spSearchFilter.getPrimaryKey(),
			spSearchFilter);

		clearUniqueFindersCache(spSearchFilter);
		cacheUniqueFindersCache(spSearchFilter);

		return spSearchFilter;
	}

	protected SPSearchFilter toUnwrappedModel(SPSearchFilter spSearchFilter) {
		if (spSearchFilter instanceof SPSearchFilterImpl) {
			return spSearchFilter;
		}

		SPSearchFilterImpl spSearchFilterImpl = new SPSearchFilterImpl();

		spSearchFilterImpl.setNew(spSearchFilter.isNew());
		spSearchFilterImpl.setPrimaryKey(spSearchFilter.getPrimaryKey());

		spSearchFilterImpl.setUuid(spSearchFilter.getUuid());
		spSearchFilterImpl.setSpSearchFilterId(spSearchFilter.getSpSearchFilterId());
		spSearchFilterImpl.setGroupId(spSearchFilter.getGroupId());
		spSearchFilterImpl.setCompanyId(spSearchFilter.getCompanyId());
		spSearchFilterImpl.setUserId(spSearchFilter.getUserId());
		spSearchFilterImpl.setUserName(spSearchFilter.getUserName());
		spSearchFilterImpl.setCreateDate(spSearchFilter.getCreateDate());
		spSearchFilterImpl.setModifiedDate(spSearchFilter.getModifiedDate());
		spSearchFilterImpl.setFilterName(spSearchFilter.getFilterName());
		spSearchFilterImpl.setFilterParameter(spSearchFilter.getFilterParameter());

		return spSearchFilterImpl;
	}

	/**
	 * Returns the s p search filter with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p search filter
	 * @return the s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPSearchFilterException, SystemException {
		SPSearchFilter spSearchFilter = fetchByPrimaryKey(primaryKey);

		if (spSearchFilter == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPSearchFilterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spSearchFilter;
	}

	/**
	 * Returns the s p search filter with the primary key or throws a {@link com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException} if it could not be found.
	 *
	 * @param spSearchFilterId the primary key of the s p search filter
	 * @return the s p search filter
	 * @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter findByPrimaryKey(long spSearchFilterId)
		throws NoSuchSPSearchFilterException, SystemException {
		return findByPrimaryKey((Serializable)spSearchFilterId);
	}

	/**
	 * Returns the s p search filter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p search filter
	 * @return the s p search filter, or <code>null</code> if a s p search filter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPSearchFilter spSearchFilter = (SPSearchFilter)EntityCacheUtil.getResult(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
				SPSearchFilterImpl.class, primaryKey);

		if (spSearchFilter == _nullSPSearchFilter) {
			return null;
		}

		if (spSearchFilter == null) {
			Session session = null;

			try {
				session = openSession();

				spSearchFilter = (SPSearchFilter)session.get(SPSearchFilterImpl.class,
						primaryKey);

				if (spSearchFilter != null) {
					cacheResult(spSearchFilter);
				}
				else {
					EntityCacheUtil.putResult(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
						SPSearchFilterImpl.class, primaryKey,
						_nullSPSearchFilter);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPSearchFilterModelImpl.ENTITY_CACHE_ENABLED,
					SPSearchFilterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spSearchFilter;
	}

	/**
	 * Returns the s p search filter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spSearchFilterId the primary key of the s p search filter
	 * @return the s p search filter, or <code>null</code> if a s p search filter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSearchFilter fetchByPrimaryKey(long spSearchFilterId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spSearchFilterId);
	}

	/**
	 * Returns all the s p search filters.
	 *
	 * @return the s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p search filters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p search filters
	 * @param end the upper bound of the range of s p search filters (not inclusive)
	 * @return the range of s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p search filters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p search filters
	 * @param end the upper bound of the range of s p search filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p search filters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSearchFilter> findAll(int start, int end,
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

		List<SPSearchFilter> list = (List<SPSearchFilter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSEARCHFILTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSEARCHFILTER;

				if (pagination) {
					sql = sql.concat(SPSearchFilterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPSearchFilter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSearchFilter>(list);
				}
				else {
					list = (List<SPSearchFilter>)QueryUtil.list(q,
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
	 * Removes all the s p search filters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPSearchFilter spSearchFilter : findAll()) {
			remove(spSearchFilter);
		}
	}

	/**
	 * Returns the number of s p search filters.
	 *
	 * @return the number of s p search filters
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

				Query q = session.createQuery(_SQL_COUNT_SPSEARCHFILTER);

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
	 * Initializes the s p search filter persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.filter.model.SPSearchFilter")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPSearchFilter>> listenersList = new ArrayList<ModelListener<SPSearchFilter>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPSearchFilter>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPSearchFilterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSEARCHFILTER = "SELECT spSearchFilter FROM SPSearchFilter spSearchFilter";
	private static final String _SQL_SELECT_SPSEARCHFILTER_WHERE = "SELECT spSearchFilter FROM SPSearchFilter spSearchFilter WHERE ";
	private static final String _SQL_COUNT_SPSEARCHFILTER = "SELECT COUNT(spSearchFilter) FROM SPSearchFilter spSearchFilter";
	private static final String _SQL_COUNT_SPSEARCHFILTER_WHERE = "SELECT COUNT(spSearchFilter) FROM SPSearchFilter spSearchFilter WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spSearchFilter.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPSearchFilter exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPSearchFilter exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPSearchFilterPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPSearchFilter _nullSPSearchFilter = new SPSearchFilterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPSearchFilter> toCacheModel() {
				return _nullSPSearchFilterCacheModel;
			}
		};

	private static CacheModel<SPSearchFilter> _nullSPSearchFilterCacheModel = new CacheModel<SPSearchFilter>() {
			@Override
			public SPSearchFilter toEntityModel() {
				return _nullSPSearchFilter;
			}
		};
}