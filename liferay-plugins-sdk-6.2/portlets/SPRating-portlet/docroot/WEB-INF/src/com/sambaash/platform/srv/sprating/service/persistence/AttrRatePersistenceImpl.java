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

package com.sambaash.platform.srv.sprating.service.persistence;

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

import com.sambaash.platform.srv.sprating.NoSuchAttrRateException;
import com.sambaash.platform.srv.sprating.model.AttrRate;
import com.sambaash.platform.srv.sprating.model.impl.AttrRateImpl;
import com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the attr rate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see AttrRatePersistence
 * @see AttrRateUtil
 * @generated
 */
public class AttrRatePersistenceImpl extends BasePersistenceImpl<AttrRate>
	implements AttrRatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AttrRateUtil} to access the attr rate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AttrRateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AttrRateModelImpl.UUID_COLUMN_BITMASK |
			AttrRateModelImpl.VALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the attr rates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attr rates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @return the range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attr rates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByUuid(String uuid, int start, int end,
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

		List<AttrRate> list = (List<AttrRate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttrRate attrRate : list) {
				if (!Validator.equals(uuid, attrRate.getUuid())) {
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

			query.append(_SQL_SELECT_ATTRRATE_WHERE);

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
				query.append(AttrRateModelImpl.ORDER_BY_JPQL);
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
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttrRate>(list);
				}
				else {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first attr rate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByUuid_First(uuid, orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the first attr rate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<AttrRate> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attr rate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByUuid_Last(uuid, orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the last attr rate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AttrRate> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attr rates before and after the current attr rate in the ordered set where uuid = &#63;.
	 *
	 * @param spAttrRateId the primary key of the current attr rate
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate[] findByUuid_PrevAndNext(long spAttrRateId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = findByPrimaryKey(spAttrRateId);

		Session session = null;

		try {
			session = openSession();

			AttrRate[] array = new AttrRateImpl[3];

			array[0] = getByUuid_PrevAndNext(session, attrRate, uuid,
					orderByComparator, true);

			array[1] = attrRate;

			array[2] = getByUuid_PrevAndNext(session, attrRate, uuid,
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

	protected AttrRate getByUuid_PrevAndNext(Session session,
		AttrRate attrRate, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTRRATE_WHERE);

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
			query.append(AttrRateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(attrRate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttrRate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attr rates where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (AttrRate attrRate : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(attrRate);
		}
	}

	/**
	 * Returns the number of attr rates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching attr rates
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

			query.append(_SQL_COUNT_ATTRRATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "attrRate.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "attrRate.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(attrRate.uuid IS NULL OR attrRate.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			AttrRateModelImpl.UUID_COLUMN_BITMASK |
			AttrRateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the attr rate where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.sprating.NoSuchAttrRateException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByUUID_G(String uuid, long groupId)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByUUID_G(uuid, groupId);

		if (attrRate == null) {
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

			throw new NoSuchAttrRateException(msg.toString());
		}

		return attrRate;
	}

	/**
	 * Returns the attr rate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the attr rate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof AttrRate) {
			AttrRate attrRate = (AttrRate)result;

			if (!Validator.equals(uuid, attrRate.getUuid()) ||
					(groupId != attrRate.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ATTRRATE_WHERE);

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

				List<AttrRate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					AttrRate attrRate = list.get(0);

					result = attrRate;

					cacheResult(attrRate);

					if ((attrRate.getUuid() == null) ||
							!attrRate.getUuid().equals(uuid) ||
							(attrRate.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, attrRate);
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
			return (AttrRate)result;
		}
	}

	/**
	 * Removes the attr rate where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the attr rate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate removeByUUID_G(String uuid, long groupId)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = findByUUID_G(uuid, groupId);

		return remove(attrRate);
	}

	/**
	 * Returns the number of attr rates where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching attr rates
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

			query.append(_SQL_COUNT_ATTRRATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "attrRate.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "attrRate.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(attrRate.uuid IS NULL OR attrRate.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "attrRate.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			AttrRateModelImpl.UUID_COLUMN_BITMASK |
			AttrRateModelImpl.COMPANYID_COLUMN_BITMASK |
			AttrRateModelImpl.VALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the attr rates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attr rates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @return the range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attr rates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByUuid_C(String uuid, long companyId, int start,
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

		List<AttrRate> list = (List<AttrRate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttrRate attrRate : list) {
				if (!Validator.equals(uuid, attrRate.getUuid()) ||
						(companyId != attrRate.getCompanyId())) {
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

			query.append(_SQL_SELECT_ATTRRATE_WHERE);

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
				query.append(AttrRateModelImpl.ORDER_BY_JPQL);
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
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttrRate>(list);
				}
				else {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the first attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AttrRate> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the last attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AttrRate> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attr rates before and after the current attr rate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spAttrRateId the primary key of the current attr rate
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate[] findByUuid_C_PrevAndNext(long spAttrRateId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = findByPrimaryKey(spAttrRateId);

		Session session = null;

		try {
			session = openSession();

			AttrRate[] array = new AttrRateImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, attrRate, uuid,
					companyId, orderByComparator, true);

			array[1] = attrRate;

			array[2] = getByUuid_C_PrevAndNext(session, attrRate, uuid,
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

	protected AttrRate getByUuid_C_PrevAndNext(Session session,
		AttrRate attrRate, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTRRATE_WHERE);

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
			query.append(AttrRateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(attrRate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttrRate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attr rates where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (AttrRate attrRate : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attrRate);
		}
	}

	/**
	 * Returns the number of attr rates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching attr rates
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

			query.append(_SQL_COUNT_ATTRRATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "attrRate.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "attrRate.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(attrRate.uuid IS NULL OR attrRate.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "attrRate.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCLASSNAMEIDOBJID =
		new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdClassNameIdObjId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCLASSNAMEIDOBJID =
		new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdClassNameIdObjId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			AttrRateModelImpl.USERID_COLUMN_BITMASK |
			AttrRateModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			AttrRateModelImpl.OBJID_COLUMN_BITMASK |
			AttrRateModelImpl.VALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDOBJID = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdClassNameIdObjId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the attr rates where userId = &#63; and classNameId = &#63; and objId = &#63;.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @return the matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByUserIdClassNameIdObjId(long userId,
		long classNameId, String objId) throws SystemException {
		return findByUserIdClassNameIdObjId(userId, classNameId, objId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attr rates where userId = &#63; and classNameId = &#63; and objId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @return the range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByUserIdClassNameIdObjId(long userId,
		long classNameId, String objId, int start, int end)
		throws SystemException {
		return findByUserIdClassNameIdObjId(userId, classNameId, objId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the attr rates where userId = &#63; and classNameId = &#63; and objId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByUserIdClassNameIdObjId(long userId,
		long classNameId, String objId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCLASSNAMEIDOBJID;
			finderArgs = new Object[] { userId, classNameId, objId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCLASSNAMEIDOBJID;
			finderArgs = new Object[] {
					userId, classNameId, objId,
					
					start, end, orderByComparator
				};
		}

		List<AttrRate> list = (List<AttrRate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttrRate attrRate : list) {
				if ((userId != attrRate.getUserId()) ||
						(classNameId != attrRate.getClassNameId()) ||
						!Validator.equals(objId, attrRate.getObjId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_CLASSNAMEID_2);

			boolean bindObjId = false;

			if (objId == null) {
				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_1);
			}
			else if (objId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_3);
			}
			else {
				bindObjId = true;

				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttrRateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(classNameId);

				if (bindObjId) {
					qPos.add(objId);
				}

				if (!pagination) {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttrRate>(list);
				}
				else {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByUserIdClassNameIdObjId_First(long userId,
		long classNameId, String objId, OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByUserIdClassNameIdObjId_First(userId,
				classNameId, objId, orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", objId=");
		msg.append(objId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the first attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUserIdClassNameIdObjId_First(long userId,
		long classNameId, String objId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AttrRate> list = findByUserIdClassNameIdObjId(userId, classNameId,
				objId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByUserIdClassNameIdObjId_Last(long userId,
		long classNameId, String objId, OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByUserIdClassNameIdObjId_Last(userId,
				classNameId, objId, orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", objId=");
		msg.append(objId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the last attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUserIdClassNameIdObjId_Last(long userId,
		long classNameId, String objId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdClassNameIdObjId(userId, classNameId, objId);

		if (count == 0) {
			return null;
		}

		List<AttrRate> list = findByUserIdClassNameIdObjId(userId, classNameId,
				objId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attr rates before and after the current attr rate in the ordered set where userId = &#63; and classNameId = &#63; and objId = &#63;.
	 *
	 * @param spAttrRateId the primary key of the current attr rate
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate[] findByUserIdClassNameIdObjId_PrevAndNext(
		long spAttrRateId, long userId, long classNameId, String objId,
		OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = findByPrimaryKey(spAttrRateId);

		Session session = null;

		try {
			session = openSession();

			AttrRate[] array = new AttrRateImpl[3];

			array[0] = getByUserIdClassNameIdObjId_PrevAndNext(session,
					attrRate, userId, classNameId, objId, orderByComparator,
					true);

			array[1] = attrRate;

			array[2] = getByUserIdClassNameIdObjId_PrevAndNext(session,
					attrRate, userId, classNameId, objId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AttrRate getByUserIdClassNameIdObjId_PrevAndNext(
		Session session, AttrRate attrRate, long userId, long classNameId,
		String objId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTRRATE_WHERE);

		query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_CLASSNAMEID_2);

		boolean bindObjId = false;

		if (objId == null) {
			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_1);
		}
		else if (objId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_3);
		}
		else {
			bindObjId = true;

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_2);
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
			query.append(AttrRateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(classNameId);

		if (bindObjId) {
			qPos.add(objId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attrRate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttrRate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attr rates where userId = &#63; and classNameId = &#63; and objId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdClassNameIdObjId(long userId, long classNameId,
		String objId) throws SystemException {
		for (AttrRate attrRate : findByUserIdClassNameIdObjId(userId,
				classNameId, objId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attrRate);
		}
	}

	/**
	 * Returns the number of attr rates where userId = &#63; and classNameId = &#63; and objId = &#63;.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param objId the obj ID
	 * @return the number of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdClassNameIdObjId(long userId, long classNameId,
		String objId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDOBJID;

		Object[] finderArgs = new Object[] { userId, classNameId, objId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_CLASSNAMEID_2);

			boolean bindObjId = false;

			if (objId == null) {
				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_1);
			}
			else if (objId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_3);
			}
			else {
				bindObjId = true;

				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(classNameId);

				if (bindObjId) {
					qPos.add(objId);
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

	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_USERID_2 = "attrRate.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_CLASSNAMEID_2 =
		"attrRate.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_1 = "attrRate.objId IS NULL";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_2 = "attrRate.objId = ?";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDOBJID_OBJID_3 = "(attrRate.objId IS NULL OR attrRate.objId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID =
		new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdClassNameIdRatingAttrIdObjId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			AttrRateModelImpl.USERID_COLUMN_BITMASK |
			AttrRateModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			AttrRateModelImpl.RATINGATTRID_COLUMN_BITMASK |
			AttrRateModelImpl.OBJID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID =
		new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdClassNameIdRatingAttrIdObjId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the attr rate where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63; or throws a {@link com.sambaash.platform.srv.sprating.NoSuchAttrRateException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByUserIdClassNameIdRatingAttrIdObjId(long userId,
		long classNameId, long ratingAttrId, String objId)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByUserIdClassNameIdRatingAttrIdObjId(userId,
				classNameId, ratingAttrId, objId);

		if (attrRate == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", classNameId=");
			msg.append(classNameId);

			msg.append(", ratingAttrId=");
			msg.append(ratingAttrId);

			msg.append(", objId=");
			msg.append(objId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAttrRateException(msg.toString());
		}

		return attrRate;
	}

	/**
	 * Returns the attr rate where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUserIdClassNameIdRatingAttrIdObjId(long userId,
		long classNameId, long ratingAttrId, String objId)
		throws SystemException {
		return fetchByUserIdClassNameIdRatingAttrIdObjId(userId, classNameId,
			ratingAttrId, objId, true);
	}

	/**
	 * Returns the attr rate where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUserIdClassNameIdRatingAttrIdObjId(long userId,
		long classNameId, long ratingAttrId, String objId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				userId, classNameId, ratingAttrId, objId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
					finderArgs, this);
		}

		if (result instanceof AttrRate) {
			AttrRate attrRate = (AttrRate)result;

			if ((userId != attrRate.getUserId()) ||
					(classNameId != attrRate.getClassNameId()) ||
					(ratingAttrId != attrRate.getRatingAttrId()) ||
					!Validator.equals(objId, attrRate.getObjId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_RATINGATTRID_2);

			boolean bindObjId = false;

			if (objId == null) {
				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_OBJID_1);
			}
			else if (objId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_OBJID_3);
			}
			else {
				bindObjId = true;

				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_OBJID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(classNameId);

				qPos.add(ratingAttrId);

				if (bindObjId) {
					qPos.add(objId);
				}

				List<AttrRate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AttrRatePersistenceImpl.fetchByUserIdClassNameIdRatingAttrIdObjId(long, long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					AttrRate attrRate = list.get(0);

					result = attrRate;

					cacheResult(attrRate);

					if ((attrRate.getUserId() != userId) ||
							(attrRate.getClassNameId() != classNameId) ||
							(attrRate.getRatingAttrId() != ratingAttrId) ||
							(attrRate.getObjId() == null) ||
							!attrRate.getObjId().equals(objId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
							finderArgs, attrRate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
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
			return (AttrRate)result;
		}
	}

	/**
	 * Removes the attr rate where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the attr rate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate removeByUserIdClassNameIdRatingAttrIdObjId(long userId,
		long classNameId, long ratingAttrId, String objId)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = findByUserIdClassNameIdRatingAttrIdObjId(userId,
				classNameId, ratingAttrId, objId);

		return remove(attrRate);
	}

	/**
	 * Returns the number of attr rates where userId = &#63; and classNameId = &#63; and ratingAttrId = &#63; and objId = &#63;.
	 *
	 * @param userId the user ID
	 * @param classNameId the class name ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the number of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdClassNameIdRatingAttrIdObjId(long userId,
		long classNameId, long ratingAttrId, String objId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID;

		Object[] finderArgs = new Object[] {
				userId, classNameId, ratingAttrId, objId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_RATINGATTRID_2);

			boolean bindObjId = false;

			if (objId == null) {
				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_OBJID_1);
			}
			else if (objId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_OBJID_3);
			}
			else {
				bindObjId = true;

				query.append(_FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_OBJID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(classNameId);

				qPos.add(ratingAttrId);

				if (bindObjId) {
					qPos.add(objId);
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

	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_USERID_2 =
		"attrRate.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_CLASSNAMEID_2 =
		"attrRate.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_RATINGATTRID_2 =
		"attrRate.ratingAttrId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_OBJID_1 =
		"attrRate.objId IS NULL";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_OBJID_2 =
		"attrRate.objId = ?";
	private static final String _FINDER_COLUMN_USERIDCLASSNAMEIDRATINGATTRIDOBJID_OBJID_3 =
		"(attrRate.objId IS NULL OR attrRate.objId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserIdRatingAttrIdObjId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			AttrRateModelImpl.USERID_COLUMN_BITMASK |
			AttrRateModelImpl.RATINGATTRID_COLUMN_BITMASK |
			AttrRateModelImpl.OBJID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDRATINGATTRIDOBJID = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdRatingAttrIdObjId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the attr rate where userId = &#63; and ratingAttrId = &#63; and objId = &#63; or throws a {@link com.sambaash.platform.srv.sprating.NoSuchAttrRateException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByUserIdRatingAttrIdObjId(long userId,
		long ratingAttrId, String objId)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByUserIdRatingAttrIdObjId(userId,
				ratingAttrId, objId);

		if (attrRate == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", ratingAttrId=");
			msg.append(ratingAttrId);

			msg.append(", objId=");
			msg.append(objId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAttrRateException(msg.toString());
		}

		return attrRate;
	}

	/**
	 * Returns the attr rate where userId = &#63; and ratingAttrId = &#63; and objId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUserIdRatingAttrIdObjId(long userId,
		long ratingAttrId, String objId) throws SystemException {
		return fetchByUserIdRatingAttrIdObjId(userId, ratingAttrId, objId, true);
	}

	/**
	 * Returns the attr rate where userId = &#63; and ratingAttrId = &#63; and objId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByUserIdRatingAttrIdObjId(long userId,
		long ratingAttrId, String objId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, ratingAttrId, objId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID,
					finderArgs, this);
		}

		if (result instanceof AttrRate) {
			AttrRate attrRate = (AttrRate)result;

			if ((userId != attrRate.getUserId()) ||
					(ratingAttrId != attrRate.getRatingAttrId()) ||
					!Validator.equals(objId, attrRate.getObjId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_RATINGATTRID_2);

			boolean bindObjId = false;

			if (objId == null) {
				query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_OBJID_1);
			}
			else if (objId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_OBJID_3);
			}
			else {
				bindObjId = true;

				query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_OBJID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(ratingAttrId);

				if (bindObjId) {
					qPos.add(objId);
				}

				List<AttrRate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AttrRatePersistenceImpl.fetchByUserIdRatingAttrIdObjId(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					AttrRate attrRate = list.get(0);

					result = attrRate;

					cacheResult(attrRate);

					if ((attrRate.getUserId() != userId) ||
							(attrRate.getRatingAttrId() != ratingAttrId) ||
							(attrRate.getObjId() == null) ||
							!attrRate.getObjId().equals(objId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID,
							finderArgs, attrRate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID,
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
			return (AttrRate)result;
		}
	}

	/**
	 * Removes the attr rate where userId = &#63; and ratingAttrId = &#63; and objId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the attr rate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate removeByUserIdRatingAttrIdObjId(long userId,
		long ratingAttrId, String objId)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = findByUserIdRatingAttrIdObjId(userId, ratingAttrId,
				objId);

		return remove(attrRate);
	}

	/**
	 * Returns the number of attr rates where userId = &#63; and ratingAttrId = &#63; and objId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the number of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdRatingAttrIdObjId(long userId, long ratingAttrId,
		String objId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDRATINGATTRIDOBJID;

		Object[] finderArgs = new Object[] { userId, ratingAttrId, objId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_RATINGATTRID_2);

			boolean bindObjId = false;

			if (objId == null) {
				query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_OBJID_1);
			}
			else if (objId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_OBJID_3);
			}
			else {
				bindObjId = true;

				query.append(_FINDER_COLUMN_USERIDRATINGATTRIDOBJID_OBJID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(ratingAttrId);

				if (bindObjId) {
					qPos.add(objId);
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

	private static final String _FINDER_COLUMN_USERIDRATINGATTRIDOBJID_USERID_2 = "attrRate.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDRATINGATTRIDOBJID_RATINGATTRID_2 =
		"attrRate.ratingAttrId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDRATINGATTRIDOBJID_OBJID_1 = "attrRate.objId IS NULL";
	private static final String _FINDER_COLUMN_USERIDRATINGATTRIDOBJID_OBJID_2 = "attrRate.objId = ?";
	private static final String _FINDER_COLUMN_USERIDRATINGATTRIDOBJID_OBJID_3 = "(attrRate.objId IS NULL OR attrRate.objId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGATTRIDOBJID =
		new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRatingAttrIdObjId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRIDOBJID =
		new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRatingAttrIdObjId",
			new String[] { Long.class.getName(), String.class.getName() },
			AttrRateModelImpl.RATINGATTRID_COLUMN_BITMASK |
			AttrRateModelImpl.OBJID_COLUMN_BITMASK |
			AttrRateModelImpl.VALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RATINGATTRIDOBJID = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRatingAttrIdObjId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the attr rates where ratingAttrId = &#63; and objId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByRatingAttrIdObjId(long ratingAttrId,
		String objId) throws SystemException {
		return findByRatingAttrIdObjId(ratingAttrId, objId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attr rates where ratingAttrId = &#63; and objId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @return the range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByRatingAttrIdObjId(long ratingAttrId,
		String objId, int start, int end) throws SystemException {
		return findByRatingAttrIdObjId(ratingAttrId, objId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attr rates where ratingAttrId = &#63; and objId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByRatingAttrIdObjId(long ratingAttrId,
		String objId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRIDOBJID;
			finderArgs = new Object[] { ratingAttrId, objId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGATTRIDOBJID;
			finderArgs = new Object[] {
					ratingAttrId, objId,
					
					start, end, orderByComparator
				};
		}

		List<AttrRate> list = (List<AttrRate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttrRate attrRate : list) {
				if ((ratingAttrId != attrRate.getRatingAttrId()) ||
						!Validator.equals(objId, attrRate.getObjId())) {
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

			query.append(_SQL_SELECT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_RATINGATTRID_2);

			boolean bindObjId = false;

			if (objId == null) {
				query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_1);
			}
			else if (objId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_3);
			}
			else {
				bindObjId = true;

				query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttrRateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ratingAttrId);

				if (bindObjId) {
					qPos.add(objId);
				}

				if (!pagination) {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttrRate>(list);
				}
				else {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByRatingAttrIdObjId_First(long ratingAttrId,
		String objId, OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByRatingAttrIdObjId_First(ratingAttrId, objId,
				orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ratingAttrId=");
		msg.append(ratingAttrId);

		msg.append(", objId=");
		msg.append(objId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the first attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByRatingAttrIdObjId_First(long ratingAttrId,
		String objId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AttrRate> list = findByRatingAttrIdObjId(ratingAttrId, objId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByRatingAttrIdObjId_Last(long ratingAttrId,
		String objId, OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByRatingAttrIdObjId_Last(ratingAttrId, objId,
				orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ratingAttrId=");
		msg.append(ratingAttrId);

		msg.append(", objId=");
		msg.append(objId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the last attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByRatingAttrIdObjId_Last(long ratingAttrId,
		String objId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRatingAttrIdObjId(ratingAttrId, objId);

		if (count == 0) {
			return null;
		}

		List<AttrRate> list = findByRatingAttrIdObjId(ratingAttrId, objId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attr rates before and after the current attr rate in the ordered set where ratingAttrId = &#63; and objId = &#63;.
	 *
	 * @param spAttrRateId the primary key of the current attr rate
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate[] findByRatingAttrIdObjId_PrevAndNext(long spAttrRateId,
		long ratingAttrId, String objId, OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = findByPrimaryKey(spAttrRateId);

		Session session = null;

		try {
			session = openSession();

			AttrRate[] array = new AttrRateImpl[3];

			array[0] = getByRatingAttrIdObjId_PrevAndNext(session, attrRate,
					ratingAttrId, objId, orderByComparator, true);

			array[1] = attrRate;

			array[2] = getByRatingAttrIdObjId_PrevAndNext(session, attrRate,
					ratingAttrId, objId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AttrRate getByRatingAttrIdObjId_PrevAndNext(Session session,
		AttrRate attrRate, long ratingAttrId, String objId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTRRATE_WHERE);

		query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_RATINGATTRID_2);

		boolean bindObjId = false;

		if (objId == null) {
			query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_1);
		}
		else if (objId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_3);
		}
		else {
			bindObjId = true;

			query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_2);
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
			query.append(AttrRateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ratingAttrId);

		if (bindObjId) {
			qPos.add(objId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attrRate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttrRate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attr rates where ratingAttrId = &#63; and objId = &#63; from the database.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRatingAttrIdObjId(long ratingAttrId, String objId)
		throws SystemException {
		for (AttrRate attrRate : findByRatingAttrIdObjId(ratingAttrId, objId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attrRate);
		}
	}

	/**
	 * Returns the number of attr rates where ratingAttrId = &#63; and objId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param objId the obj ID
	 * @return the number of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRatingAttrIdObjId(long ratingAttrId, String objId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RATINGATTRIDOBJID;

		Object[] finderArgs = new Object[] { ratingAttrId, objId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_RATINGATTRID_2);

			boolean bindObjId = false;

			if (objId == null) {
				query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_1);
			}
			else if (objId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_3);
			}
			else {
				bindObjId = true;

				query.append(_FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ratingAttrId);

				if (bindObjId) {
					qPos.add(objId);
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

	private static final String _FINDER_COLUMN_RATINGATTRIDOBJID_RATINGATTRID_2 = "attrRate.ratingAttrId = ? AND ";
	private static final String _FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_1 = "attrRate.objId IS NULL";
	private static final String _FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_2 = "attrRate.objId = ?";
	private static final String _FINDER_COLUMN_RATINGATTRIDOBJID_OBJID_3 = "(attrRate.objId IS NULL OR attrRate.objId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGATTRID =
		new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRatingAttrId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRID =
		new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, AttrRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRatingAttrId",
			new String[] { Long.class.getName() },
			AttrRateModelImpl.RATINGATTRID_COLUMN_BITMASK |
			AttrRateModelImpl.VALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RATINGATTRID = new FinderPath(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRatingAttrId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the attr rates where ratingAttrId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @return the matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByRatingAttrId(long ratingAttrId)
		throws SystemException {
		return findByRatingAttrId(ratingAttrId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attr rates where ratingAttrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @return the range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByRatingAttrId(long ratingAttrId, int start,
		int end) throws SystemException {
		return findByRatingAttrId(ratingAttrId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the attr rates where ratingAttrId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findByRatingAttrId(long ratingAttrId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRID;
			finderArgs = new Object[] { ratingAttrId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGATTRID;
			finderArgs = new Object[] {
					ratingAttrId,
					
					start, end, orderByComparator
				};
		}

		List<AttrRate> list = (List<AttrRate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AttrRate attrRate : list) {
				if ((ratingAttrId != attrRate.getRatingAttrId())) {
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

			query.append(_SQL_SELECT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_RATINGATTRID_RATINGATTRID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AttrRateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ratingAttrId);

				if (!pagination) {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttrRate>(list);
				}
				else {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first attr rate in the ordered set where ratingAttrId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByRatingAttrId_First(long ratingAttrId,
		OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByRatingAttrId_First(ratingAttrId,
				orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ratingAttrId=");
		msg.append(ratingAttrId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the first attr rate in the ordered set where ratingAttrId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByRatingAttrId_First(long ratingAttrId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AttrRate> list = findByRatingAttrId(ratingAttrId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last attr rate in the ordered set where ratingAttrId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByRatingAttrId_Last(long ratingAttrId,
		OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByRatingAttrId_Last(ratingAttrId,
				orderByComparator);

		if (attrRate != null) {
			return attrRate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ratingAttrId=");
		msg.append(ratingAttrId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAttrRateException(msg.toString());
	}

	/**
	 * Returns the last attr rate in the ordered set where ratingAttrId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching attr rate, or <code>null</code> if a matching attr rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByRatingAttrId_Last(long ratingAttrId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRatingAttrId(ratingAttrId);

		if (count == 0) {
			return null;
		}

		List<AttrRate> list = findByRatingAttrId(ratingAttrId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the attr rates before and after the current attr rate in the ordered set where ratingAttrId = &#63;.
	 *
	 * @param spAttrRateId the primary key of the current attr rate
	 * @param ratingAttrId the rating attr ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate[] findByRatingAttrId_PrevAndNext(long spAttrRateId,
		long ratingAttrId, OrderByComparator orderByComparator)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = findByPrimaryKey(spAttrRateId);

		Session session = null;

		try {
			session = openSession();

			AttrRate[] array = new AttrRateImpl[3];

			array[0] = getByRatingAttrId_PrevAndNext(session, attrRate,
					ratingAttrId, orderByComparator, true);

			array[1] = attrRate;

			array[2] = getByRatingAttrId_PrevAndNext(session, attrRate,
					ratingAttrId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AttrRate getByRatingAttrId_PrevAndNext(Session session,
		AttrRate attrRate, long ratingAttrId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ATTRRATE_WHERE);

		query.append(_FINDER_COLUMN_RATINGATTRID_RATINGATTRID_2);

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
			query.append(AttrRateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ratingAttrId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(attrRate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AttrRate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the attr rates where ratingAttrId = &#63; from the database.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRatingAttrId(long ratingAttrId)
		throws SystemException {
		for (AttrRate attrRate : findByRatingAttrId(ratingAttrId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(attrRate);
		}
	}

	/**
	 * Returns the number of attr rates where ratingAttrId = &#63;.
	 *
	 * @param ratingAttrId the rating attr ID
	 * @return the number of matching attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRatingAttrId(long ratingAttrId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RATINGATTRID;

		Object[] finderArgs = new Object[] { ratingAttrId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ATTRRATE_WHERE);

			query.append(_FINDER_COLUMN_RATINGATTRID_RATINGATTRID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ratingAttrId);

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

	private static final String _FINDER_COLUMN_RATINGATTRID_RATINGATTRID_2 = "attrRate.ratingAttrId = ?";

	public AttrRatePersistenceImpl() {
		setModelClass(AttrRate.class);
	}

	/**
	 * Caches the attr rate in the entity cache if it is enabled.
	 *
	 * @param attrRate the attr rate
	 */
	@Override
	public void cacheResult(AttrRate attrRate) {
		EntityCacheUtil.putResult(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateImpl.class, attrRate.getPrimaryKey(), attrRate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { attrRate.getUuid(), attrRate.getGroupId() }, attrRate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
			new Object[] {
				attrRate.getUserId(), attrRate.getClassNameId(),
				attrRate.getRatingAttrId(), attrRate.getObjId()
			}, attrRate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID,
			new Object[] {
				attrRate.getUserId(), attrRate.getRatingAttrId(),
				attrRate.getObjId()
			}, attrRate);

		attrRate.resetOriginalValues();
	}

	/**
	 * Caches the attr rates in the entity cache if it is enabled.
	 *
	 * @param attrRates the attr rates
	 */
	@Override
	public void cacheResult(List<AttrRate> attrRates) {
		for (AttrRate attrRate : attrRates) {
			if (EntityCacheUtil.getResult(
						AttrRateModelImpl.ENTITY_CACHE_ENABLED,
						AttrRateImpl.class, attrRate.getPrimaryKey()) == null) {
				cacheResult(attrRate);
			}
			else {
				attrRate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attr rates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AttrRateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AttrRateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attr rate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttrRate attrRate) {
		EntityCacheUtil.removeResult(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateImpl.class, attrRate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(attrRate);
	}

	@Override
	public void clearCache(List<AttrRate> attrRates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AttrRate attrRate : attrRates) {
			EntityCacheUtil.removeResult(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
				AttrRateImpl.class, attrRate.getPrimaryKey());

			clearUniqueFindersCache(attrRate);
		}
	}

	protected void cacheUniqueFindersCache(AttrRate attrRate) {
		if (attrRate.isNew()) {
			Object[] args = new Object[] {
					attrRate.getUuid(), attrRate.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				attrRate);

			args = new Object[] {
					attrRate.getUserId(), attrRate.getClassNameId(),
					attrRate.getRatingAttrId(), attrRate.getObjId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
				args, attrRate);

			args = new Object[] {
					attrRate.getUserId(), attrRate.getRatingAttrId(),
					attrRate.getObjId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDRATINGATTRIDOBJID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID,
				args, attrRate);
		}
		else {
			AttrRateModelImpl attrRateModelImpl = (AttrRateModelImpl)attrRate;

			if ((attrRateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attrRate.getUuid(), attrRate.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					attrRate);
			}

			if ((attrRateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attrRate.getUserId(), attrRate.getClassNameId(),
						attrRate.getRatingAttrId(), attrRate.getObjId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
					args, attrRate);
			}

			if ((attrRateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attrRate.getUserId(), attrRate.getRatingAttrId(),
						attrRate.getObjId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDRATINGATTRIDOBJID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID,
					args, attrRate);
			}
		}
	}

	protected void clearUniqueFindersCache(AttrRate attrRate) {
		AttrRateModelImpl attrRateModelImpl = (AttrRateModelImpl)attrRate;

		Object[] args = new Object[] { attrRate.getUuid(), attrRate.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((attrRateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					attrRateModelImpl.getOriginalUuid(),
					attrRateModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				attrRate.getUserId(), attrRate.getClassNameId(),
				attrRate.getRatingAttrId(), attrRate.getObjId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
			args);

		if ((attrRateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID.getColumnBitmask()) != 0) {
			args = new Object[] {
					attrRateModelImpl.getOriginalUserId(),
					attrRateModelImpl.getOriginalClassNameId(),
					attrRateModelImpl.getOriginalRatingAttrId(),
					attrRateModelImpl.getOriginalObjId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCLASSNAMEIDRATINGATTRIDOBJID,
				args);
		}

		args = new Object[] {
				attrRate.getUserId(), attrRate.getRatingAttrId(),
				attrRate.getObjId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDRATINGATTRIDOBJID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID,
			args);

		if ((attrRateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID.getColumnBitmask()) != 0) {
			args = new Object[] {
					attrRateModelImpl.getOriginalUserId(),
					attrRateModelImpl.getOriginalRatingAttrId(),
					attrRateModelImpl.getOriginalObjId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDRATINGATTRIDOBJID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDRATINGATTRIDOBJID,
				args);
		}
	}

	/**
	 * Creates a new attr rate with the primary key. Does not add the attr rate to the database.
	 *
	 * @param spAttrRateId the primary key for the new attr rate
	 * @return the new attr rate
	 */
	@Override
	public AttrRate create(long spAttrRateId) {
		AttrRate attrRate = new AttrRateImpl();

		attrRate.setNew(true);
		attrRate.setPrimaryKey(spAttrRateId);

		String uuid = PortalUUIDUtil.generate();

		attrRate.setUuid(uuid);

		return attrRate;
	}

	/**
	 * Removes the attr rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAttrRateId the primary key of the attr rate
	 * @return the attr rate that was removed
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate remove(long spAttrRateId)
		throws NoSuchAttrRateException, SystemException {
		return remove((Serializable)spAttrRateId);
	}

	/**
	 * Removes the attr rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attr rate
	 * @return the attr rate that was removed
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate remove(Serializable primaryKey)
		throws NoSuchAttrRateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AttrRate attrRate = (AttrRate)session.get(AttrRateImpl.class,
					primaryKey);

			if (attrRate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttrRateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(attrRate);
		}
		catch (NoSuchAttrRateException nsee) {
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
	protected AttrRate removeImpl(AttrRate attrRate) throws SystemException {
		attrRate = toUnwrappedModel(attrRate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attrRate)) {
				attrRate = (AttrRate)session.get(AttrRateImpl.class,
						attrRate.getPrimaryKeyObj());
			}

			if (attrRate != null) {
				session.delete(attrRate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (attrRate != null) {
			clearCache(attrRate);
		}

		return attrRate;
	}

	@Override
	public AttrRate updateImpl(
		com.sambaash.platform.srv.sprating.model.AttrRate attrRate)
		throws SystemException {
		attrRate = toUnwrappedModel(attrRate);

		boolean isNew = attrRate.isNew();

		AttrRateModelImpl attrRateModelImpl = (AttrRateModelImpl)attrRate;

		if (Validator.isNull(attrRate.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			attrRate.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (attrRate.isNew()) {
				session.save(attrRate);

				attrRate.setNew(false);
			}
			else {
				session.merge(attrRate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AttrRateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((attrRateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { attrRateModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { attrRateModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((attrRateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attrRateModelImpl.getOriginalUuid(),
						attrRateModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						attrRateModelImpl.getUuid(),
						attrRateModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((attrRateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCLASSNAMEIDOBJID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attrRateModelImpl.getOriginalUserId(),
						attrRateModelImpl.getOriginalClassNameId(),
						attrRateModelImpl.getOriginalObjId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDOBJID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCLASSNAMEIDOBJID,
					args);

				args = new Object[] {
						attrRateModelImpl.getUserId(),
						attrRateModelImpl.getClassNameId(),
						attrRateModelImpl.getObjId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCLASSNAMEIDOBJID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCLASSNAMEIDOBJID,
					args);
			}

			if ((attrRateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRIDOBJID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attrRateModelImpl.getOriginalRatingAttrId(),
						attrRateModelImpl.getOriginalObjId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGATTRIDOBJID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRIDOBJID,
					args);

				args = new Object[] {
						attrRateModelImpl.getRatingAttrId(),
						attrRateModelImpl.getObjId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGATTRIDOBJID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRIDOBJID,
					args);
			}

			if ((attrRateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						attrRateModelImpl.getOriginalRatingAttrId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGATTRID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRID,
					args);

				args = new Object[] { attrRateModelImpl.getRatingAttrId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGATTRID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGATTRID,
					args);
			}
		}

		EntityCacheUtil.putResult(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
			AttrRateImpl.class, attrRate.getPrimaryKey(), attrRate);

		clearUniqueFindersCache(attrRate);
		cacheUniqueFindersCache(attrRate);

		return attrRate;
	}

	protected AttrRate toUnwrappedModel(AttrRate attrRate) {
		if (attrRate instanceof AttrRateImpl) {
			return attrRate;
		}

		AttrRateImpl attrRateImpl = new AttrRateImpl();

		attrRateImpl.setNew(attrRate.isNew());
		attrRateImpl.setPrimaryKey(attrRate.getPrimaryKey());

		attrRateImpl.setUuid(attrRate.getUuid());
		attrRateImpl.setSpAttrRateId(attrRate.getSpAttrRateId());
		attrRateImpl.setGroupId(attrRate.getGroupId());
		attrRateImpl.setCompanyId(attrRate.getCompanyId());
		attrRateImpl.setUserId(attrRate.getUserId());
		attrRateImpl.setUserName(attrRate.getUserName());
		attrRateImpl.setCreateDate(attrRate.getCreateDate());
		attrRateImpl.setModifiedDate(attrRate.getModifiedDate());
		attrRateImpl.setObjId(attrRate.getObjId());
		attrRateImpl.setClassNameId(attrRate.getClassNameId());
		attrRateImpl.setRatingAttrId(attrRate.getRatingAttrId());
		attrRateImpl.setValue(attrRate.getValue());

		return attrRateImpl;
	}

	/**
	 * Returns the attr rate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the attr rate
	 * @return the attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttrRateException, SystemException {
		AttrRate attrRate = fetchByPrimaryKey(primaryKey);

		if (attrRate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttrRateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return attrRate;
	}

	/**
	 * Returns the attr rate with the primary key or throws a {@link com.sambaash.platform.srv.sprating.NoSuchAttrRateException} if it could not be found.
	 *
	 * @param spAttrRateId the primary key of the attr rate
	 * @return the attr rate
	 * @throws com.sambaash.platform.srv.sprating.NoSuchAttrRateException if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate findByPrimaryKey(long spAttrRateId)
		throws NoSuchAttrRateException, SystemException {
		return findByPrimaryKey((Serializable)spAttrRateId);
	}

	/**
	 * Returns the attr rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attr rate
	 * @return the attr rate, or <code>null</code> if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AttrRate attrRate = (AttrRate)EntityCacheUtil.getResult(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
				AttrRateImpl.class, primaryKey);

		if (attrRate == _nullAttrRate) {
			return null;
		}

		if (attrRate == null) {
			Session session = null;

			try {
				session = openSession();

				attrRate = (AttrRate)session.get(AttrRateImpl.class, primaryKey);

				if (attrRate != null) {
					cacheResult(attrRate);
				}
				else {
					EntityCacheUtil.putResult(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
						AttrRateImpl.class, primaryKey, _nullAttrRate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AttrRateModelImpl.ENTITY_CACHE_ENABLED,
					AttrRateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return attrRate;
	}

	/**
	 * Returns the attr rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spAttrRateId the primary key of the attr rate
	 * @return the attr rate, or <code>null</code> if a attr rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AttrRate fetchByPrimaryKey(long spAttrRateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spAttrRateId);
	}

	/**
	 * Returns all the attr rates.
	 *
	 * @return the attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attr rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @return the range of attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attr rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.AttrRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attr rates
	 * @param end the upper bound of the range of attr rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attr rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AttrRate> findAll(int start, int end,
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

		List<AttrRate> list = (List<AttrRate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ATTRRATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTRRATE;

				if (pagination) {
					sql = sql.concat(AttrRateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AttrRate>(list);
				}
				else {
					list = (List<AttrRate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the attr rates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AttrRate attrRate : findAll()) {
			remove(attrRate);
		}
	}

	/**
	 * Returns the number of attr rates.
	 *
	 * @return the number of attr rates
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

				Query q = session.createQuery(_SQL_COUNT_ATTRRATE);

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
	 * Initializes the attr rate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.sprating.model.AttrRate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AttrRate>> listenersList = new ArrayList<ModelListener<AttrRate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AttrRate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AttrRateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ATTRRATE = "SELECT attrRate FROM AttrRate attrRate";
	private static final String _SQL_SELECT_ATTRRATE_WHERE = "SELECT attrRate FROM AttrRate attrRate WHERE ";
	private static final String _SQL_COUNT_ATTRRATE = "SELECT COUNT(attrRate) FROM AttrRate attrRate";
	private static final String _SQL_COUNT_ATTRRATE_WHERE = "SELECT COUNT(attrRate) FROM AttrRate attrRate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "attrRate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AttrRate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AttrRate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AttrRatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static AttrRate _nullAttrRate = new AttrRateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AttrRate> toCacheModel() {
				return _nullAttrRateCacheModel;
			}
		};

	private static CacheModel<AttrRate> _nullAttrRateCacheModel = new CacheModel<AttrRate>() {
			@Override
			public AttrRate toEntityModel() {
				return _nullAttrRate;
			}
		};
}