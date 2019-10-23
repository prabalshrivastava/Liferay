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

package com.sambaash.platform.srv.rsvp.service.persistence;

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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException;
import com.sambaash.platform.srv.rsvp.model.RsvpDiscount;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountImpl;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rsvp discount service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpDiscountPersistence
 * @see RsvpDiscountUtil
 * @generated
 */
public class RsvpDiscountPersistenceImpl extends BasePersistenceImpl<RsvpDiscount>
	implements RsvpDiscountPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RsvpDiscountUtil} to access the rsvp discount persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RsvpDiscountImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, RsvpDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, RsvpDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, RsvpDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, RsvpDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RsvpDiscountModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rsvp discounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp discounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp discounts
	 * @param end the upper bound of the range of rsvp discounts (not inclusive)
	 * @return the range of matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp discounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp discounts
	 * @param end the upper bound of the range of rsvp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findByUuid(String uuid, int start, int end,
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

		List<RsvpDiscount> list = (List<RsvpDiscount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDiscount rsvpDiscount : list) {
				if (!Validator.equals(uuid, rsvpDiscount.getUuid())) {
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

			query.append(_SQL_SELECT_RSVPDISCOUNT_WHERE);

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
				query.append(RsvpDiscountModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpDiscount>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDiscount>(list);
				}
				else {
					list = (List<RsvpDiscount>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp discount in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = fetchByUuid_First(uuid, orderByComparator);

		if (rsvpDiscount != null) {
			return rsvpDiscount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDiscountException(msg.toString());
	}

	/**
	 * Returns the first rsvp discount in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpDiscount> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp discount in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = fetchByUuid_Last(uuid, orderByComparator);

		if (rsvpDiscount != null) {
			return rsvpDiscount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDiscountException(msg.toString());
	}

	/**
	 * Returns the last rsvp discount in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RsvpDiscount> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp discounts before and after the current rsvp discount in the ordered set where uuid = &#63;.
	 *
	 * @param rsvpDiscountId the primary key of the current rsvp discount
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount[] findByUuid_PrevAndNext(long rsvpDiscountId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = findByPrimaryKey(rsvpDiscountId);

		Session session = null;

		try {
			session = openSession();

			RsvpDiscount[] array = new RsvpDiscountImpl[3];

			array[0] = getByUuid_PrevAndNext(session, rsvpDiscount, uuid,
					orderByComparator, true);

			array[1] = rsvpDiscount;

			array[2] = getByUuid_PrevAndNext(session, rsvpDiscount, uuid,
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

	protected RsvpDiscount getByUuid_PrevAndNext(Session session,
		RsvpDiscount rsvpDiscount, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDISCOUNT_WHERE);

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
			query.append(RsvpDiscountModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDiscount);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDiscount> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp discounts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RsvpDiscount rsvpDiscount : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvpDiscount);
		}
	}

	/**
	 * Returns the number of rsvp discounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rsvp discounts
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

			query.append(_SQL_COUNT_RSVPDISCOUNT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "rsvpDiscount.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "rsvpDiscount.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(rsvpDiscount.uuid IS NULL OR rsvpDiscount.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, RsvpDiscountImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpDiscountModelImpl.UUID_COLUMN_BITMASK |
			RsvpDiscountModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rsvp discount where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount findByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = fetchByUUID_G(uuid, groupId);

		if (rsvpDiscount == null) {
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

			throw new NoSuchRsvpDiscountException(msg.toString());
		}

		return rsvpDiscount;
	}

	/**
	 * Returns the rsvp discount where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rsvp discount where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RsvpDiscount) {
			RsvpDiscount rsvpDiscount = (RsvpDiscount)result;

			if (!Validator.equals(uuid, rsvpDiscount.getUuid()) ||
					(groupId != rsvpDiscount.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RSVPDISCOUNT_WHERE);

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

				List<RsvpDiscount> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RsvpDiscount rsvpDiscount = list.get(0);

					result = rsvpDiscount;

					cacheResult(rsvpDiscount);

					if ((rsvpDiscount.getUuid() == null) ||
							!rsvpDiscount.getUuid().equals(uuid) ||
							(rsvpDiscount.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, rsvpDiscount);
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
			return (RsvpDiscount)result;
		}
	}

	/**
	 * Removes the rsvp discount where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rsvp discount that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount removeByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = findByUUID_G(uuid, groupId);

		return remove(rsvpDiscount);
	}

	/**
	 * Returns the number of rsvp discounts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rsvp discounts
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

			query.append(_SQL_COUNT_RSVPDISCOUNT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "rsvpDiscount.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "rsvpDiscount.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(rsvpDiscount.uuid IS NULL OR rsvpDiscount.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "rsvpDiscount.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, RsvpDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, RsvpDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpDiscountModelImpl.UUID_COLUMN_BITMASK |
			RsvpDiscountModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rsvp discounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp discounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp discounts
	 * @param end the upper bound of the range of rsvp discounts (not inclusive)
	 * @return the range of matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp discounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp discounts
	 * @param end the upper bound of the range of rsvp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findByUuid_C(String uuid, long companyId,
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

		List<RsvpDiscount> list = (List<RsvpDiscount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDiscount rsvpDiscount : list) {
				if (!Validator.equals(uuid, rsvpDiscount.getUuid()) ||
						(companyId != rsvpDiscount.getCompanyId())) {
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

			query.append(_SQL_SELECT_RSVPDISCOUNT_WHERE);

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
				query.append(RsvpDiscountModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpDiscount>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDiscount>(list);
				}
				else {
					list = (List<RsvpDiscount>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (rsvpDiscount != null) {
			return rsvpDiscount;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDiscountException(msg.toString());
	}

	/**
	 * Returns the first rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpDiscount> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (rsvpDiscount != null) {
			return rsvpDiscount;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDiscountException(msg.toString());
	}

	/**
	 * Returns the last rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RsvpDiscount> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp discounts before and after the current rsvp discount in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rsvpDiscountId the primary key of the current rsvp discount
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount[] findByUuid_C_PrevAndNext(long rsvpDiscountId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = findByPrimaryKey(rsvpDiscountId);

		Session session = null;

		try {
			session = openSession();

			RsvpDiscount[] array = new RsvpDiscountImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, rsvpDiscount, uuid,
					companyId, orderByComparator, true);

			array[1] = rsvpDiscount;

			array[2] = getByUuid_C_PrevAndNext(session, rsvpDiscount, uuid,
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

	protected RsvpDiscount getByUuid_C_PrevAndNext(Session session,
		RsvpDiscount rsvpDiscount, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDISCOUNT_WHERE);

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
			query.append(RsvpDiscountModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDiscount);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDiscount> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp discounts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (RsvpDiscount rsvpDiscount : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpDiscount);
		}
	}

	/**
	 * Returns the number of rsvp discounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rsvp discounts
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

			query.append(_SQL_COUNT_RSVPDISCOUNT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "rsvpDiscount.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "rsvpDiscount.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(rsvpDiscount.uuid IS NULL OR rsvpDiscount.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "rsvpDiscount.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPID = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, RsvpDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByrsvpId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID =
		new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, RsvpDiscountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrsvpId",
			new String[] { Long.class.getName() },
			RsvpDiscountModelImpl.RSVPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPID = new FinderPath(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrsvpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rsvp discounts where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findByrsvpId(long rsvpId)
		throws SystemException {
		return findByrsvpId(rsvpId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp discounts where rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp discounts
	 * @param end the upper bound of the range of rsvp discounts (not inclusive)
	 * @return the range of matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findByrsvpId(long rsvpId, int start, int end)
		throws SystemException {
		return findByrsvpId(rsvpId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp discounts where rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp discounts
	 * @param end the upper bound of the range of rsvp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findByrsvpId(long rsvpId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID;
			finderArgs = new Object[] { rsvpId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPID;
			finderArgs = new Object[] { rsvpId, start, end, orderByComparator };
		}

		List<RsvpDiscount> list = (List<RsvpDiscount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDiscount rsvpDiscount : list) {
				if ((rsvpId != rsvpDiscount.getRsvpId())) {
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

			query.append(_SQL_SELECT_RSVPDISCOUNT_WHERE);

			query.append(_FINDER_COLUMN_RSVPID_RSVPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpDiscountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				if (!pagination) {
					list = (List<RsvpDiscount>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDiscount>(list);
				}
				else {
					list = (List<RsvpDiscount>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp discount in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount findByrsvpId_First(long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = fetchByrsvpId_First(rsvpId,
				orderByComparator);

		if (rsvpDiscount != null) {
			return rsvpDiscount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDiscountException(msg.toString());
	}

	/**
	 * Returns the first rsvp discount in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByrsvpId_First(long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpDiscount> list = findByrsvpId(rsvpId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp discount in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount findByrsvpId_Last(long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = fetchByrsvpId_Last(rsvpId, orderByComparator);

		if (rsvpDiscount != null) {
			return rsvpDiscount;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDiscountException(msg.toString());
	}

	/**
	 * Returns the last rsvp discount in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp discount, or <code>null</code> if a matching rsvp discount could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByrsvpId_Last(long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByrsvpId(rsvpId);

		if (count == 0) {
			return null;
		}

		List<RsvpDiscount> list = findByrsvpId(rsvpId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp discounts before and after the current rsvp discount in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpDiscountId the primary key of the current rsvp discount
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount[] findByrsvpId_PrevAndNext(long rsvpDiscountId,
		long rsvpId, OrderByComparator orderByComparator)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = findByPrimaryKey(rsvpDiscountId);

		Session session = null;

		try {
			session = openSession();

			RsvpDiscount[] array = new RsvpDiscountImpl[3];

			array[0] = getByrsvpId_PrevAndNext(session, rsvpDiscount, rsvpId,
					orderByComparator, true);

			array[1] = rsvpDiscount;

			array[2] = getByrsvpId_PrevAndNext(session, rsvpDiscount, rsvpId,
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

	protected RsvpDiscount getByrsvpId_PrevAndNext(Session session,
		RsvpDiscount rsvpDiscount, long rsvpId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDISCOUNT_WHERE);

		query.append(_FINDER_COLUMN_RSVPID_RSVPID_2);

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
			query.append(RsvpDiscountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDiscount);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDiscount> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp discounts where rsvpId = &#63; from the database.
	 *
	 * @param rsvpId the rsvp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByrsvpId(long rsvpId) throws SystemException {
		for (RsvpDiscount rsvpDiscount : findByrsvpId(rsvpId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpDiscount);
		}
	}

	/**
	 * Returns the number of rsvp discounts where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the number of matching rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByrsvpId(long rsvpId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RSVPID;

		Object[] finderArgs = new Object[] { rsvpId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RSVPDISCOUNT_WHERE);

			query.append(_FINDER_COLUMN_RSVPID_RSVPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

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

	private static final String _FINDER_COLUMN_RSVPID_RSVPID_2 = "rsvpDiscount.rsvpId = ?";

	public RsvpDiscountPersistenceImpl() {
		setModelClass(RsvpDiscount.class);
	}

	/**
	 * Caches the rsvp discount in the entity cache if it is enabled.
	 *
	 * @param rsvpDiscount the rsvp discount
	 */
	@Override
	public void cacheResult(RsvpDiscount rsvpDiscount) {
		EntityCacheUtil.putResult(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountImpl.class, rsvpDiscount.getPrimaryKey(), rsvpDiscount);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { rsvpDiscount.getUuid(), rsvpDiscount.getGroupId() },
			rsvpDiscount);

		rsvpDiscount.resetOriginalValues();
	}

	/**
	 * Caches the rsvp discounts in the entity cache if it is enabled.
	 *
	 * @param rsvpDiscounts the rsvp discounts
	 */
	@Override
	public void cacheResult(List<RsvpDiscount> rsvpDiscounts) {
		for (RsvpDiscount rsvpDiscount : rsvpDiscounts) {
			if (EntityCacheUtil.getResult(
						RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
						RsvpDiscountImpl.class, rsvpDiscount.getPrimaryKey()) == null) {
				cacheResult(rsvpDiscount);
			}
			else {
				rsvpDiscount.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rsvp discounts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RsvpDiscountImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RsvpDiscountImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rsvp discount.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RsvpDiscount rsvpDiscount) {
		EntityCacheUtil.removeResult(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountImpl.class, rsvpDiscount.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rsvpDiscount);
	}

	@Override
	public void clearCache(List<RsvpDiscount> rsvpDiscounts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RsvpDiscount rsvpDiscount : rsvpDiscounts) {
			EntityCacheUtil.removeResult(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
				RsvpDiscountImpl.class, rsvpDiscount.getPrimaryKey());

			clearUniqueFindersCache(rsvpDiscount);
		}
	}

	protected void cacheUniqueFindersCache(RsvpDiscount rsvpDiscount) {
		if (rsvpDiscount.isNew()) {
			Object[] args = new Object[] {
					rsvpDiscount.getUuid(), rsvpDiscount.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				rsvpDiscount);
		}
		else {
			RsvpDiscountModelImpl rsvpDiscountModelImpl = (RsvpDiscountModelImpl)rsvpDiscount;

			if ((rsvpDiscountModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDiscount.getUuid(), rsvpDiscount.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					rsvpDiscount);
			}
		}
	}

	protected void clearUniqueFindersCache(RsvpDiscount rsvpDiscount) {
		RsvpDiscountModelImpl rsvpDiscountModelImpl = (RsvpDiscountModelImpl)rsvpDiscount;

		Object[] args = new Object[] {
				rsvpDiscount.getUuid(), rsvpDiscount.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((rsvpDiscountModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					rsvpDiscountModelImpl.getOriginalUuid(),
					rsvpDiscountModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new rsvp discount with the primary key. Does not add the rsvp discount to the database.
	 *
	 * @param rsvpDiscountId the primary key for the new rsvp discount
	 * @return the new rsvp discount
	 */
	@Override
	public RsvpDiscount create(long rsvpDiscountId) {
		RsvpDiscount rsvpDiscount = new RsvpDiscountImpl();

		rsvpDiscount.setNew(true);
		rsvpDiscount.setPrimaryKey(rsvpDiscountId);

		String uuid = PortalUUIDUtil.generate();

		rsvpDiscount.setUuid(uuid);

		return rsvpDiscount;
	}

	/**
	 * Removes the rsvp discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rsvpDiscountId the primary key of the rsvp discount
	 * @return the rsvp discount that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount remove(long rsvpDiscountId)
		throws NoSuchRsvpDiscountException, SystemException {
		return remove((Serializable)rsvpDiscountId);
	}

	/**
	 * Removes the rsvp discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rsvp discount
	 * @return the rsvp discount that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount remove(Serializable primaryKey)
		throws NoSuchRsvpDiscountException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RsvpDiscount rsvpDiscount = (RsvpDiscount)session.get(RsvpDiscountImpl.class,
					primaryKey);

			if (rsvpDiscount == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRsvpDiscountException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rsvpDiscount);
		}
		catch (NoSuchRsvpDiscountException nsee) {
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
	protected RsvpDiscount removeImpl(RsvpDiscount rsvpDiscount)
		throws SystemException {
		rsvpDiscount = toUnwrappedModel(rsvpDiscount);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rsvpDiscount)) {
				rsvpDiscount = (RsvpDiscount)session.get(RsvpDiscountImpl.class,
						rsvpDiscount.getPrimaryKeyObj());
			}

			if (rsvpDiscount != null) {
				session.delete(rsvpDiscount);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rsvpDiscount != null) {
			clearCache(rsvpDiscount);
		}

		return rsvpDiscount;
	}

	@Override
	public RsvpDiscount updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpDiscount rsvpDiscount)
		throws SystemException {
		rsvpDiscount = toUnwrappedModel(rsvpDiscount);

		boolean isNew = rsvpDiscount.isNew();

		RsvpDiscountModelImpl rsvpDiscountModelImpl = (RsvpDiscountModelImpl)rsvpDiscount;

		if (Validator.isNull(rsvpDiscount.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rsvpDiscount.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (rsvpDiscount.isNew()) {
				session.save(rsvpDiscount);

				rsvpDiscount.setNew(false);
			}
			else {
				session.merge(rsvpDiscount);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RsvpDiscountModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rsvpDiscountModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDiscountModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { rsvpDiscountModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((rsvpDiscountModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDiscountModelImpl.getOriginalUuid(),
						rsvpDiscountModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						rsvpDiscountModelImpl.getUuid(),
						rsvpDiscountModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((rsvpDiscountModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDiscountModelImpl.getOriginalRsvpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID,
					args);

				args = new Object[] { rsvpDiscountModelImpl.getRsvpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID,
					args);
			}
		}

		EntityCacheUtil.putResult(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDiscountImpl.class, rsvpDiscount.getPrimaryKey(), rsvpDiscount);

		clearUniqueFindersCache(rsvpDiscount);
		cacheUniqueFindersCache(rsvpDiscount);

		return rsvpDiscount;
	}

	protected RsvpDiscount toUnwrappedModel(RsvpDiscount rsvpDiscount) {
		if (rsvpDiscount instanceof RsvpDiscountImpl) {
			return rsvpDiscount;
		}

		RsvpDiscountImpl rsvpDiscountImpl = new RsvpDiscountImpl();

		rsvpDiscountImpl.setNew(rsvpDiscount.isNew());
		rsvpDiscountImpl.setPrimaryKey(rsvpDiscount.getPrimaryKey());

		rsvpDiscountImpl.setUuid(rsvpDiscount.getUuid());
		rsvpDiscountImpl.setRsvpDiscountId(rsvpDiscount.getRsvpDiscountId());
		rsvpDiscountImpl.setGroupId(rsvpDiscount.getGroupId());
		rsvpDiscountImpl.setCompanyId(rsvpDiscount.getCompanyId());
		rsvpDiscountImpl.setUserId(rsvpDiscount.getUserId());
		rsvpDiscountImpl.setUserName(rsvpDiscount.getUserName());
		rsvpDiscountImpl.setCreateDate(rsvpDiscount.getCreateDate());
		rsvpDiscountImpl.setModifiedDate(rsvpDiscount.getModifiedDate());
		rsvpDiscountImpl.setRsvpId(rsvpDiscount.getRsvpId());
		rsvpDiscountImpl.setRsvpTicketId(rsvpDiscount.getRsvpTicketId());
		rsvpDiscountImpl.setFromDate(rsvpDiscount.getFromDate());
		rsvpDiscountImpl.setToDate(rsvpDiscount.getToDate());
		rsvpDiscountImpl.setNoOfTickets(rsvpDiscount.getNoOfTickets());
		rsvpDiscountImpl.setDiscount(rsvpDiscount.getDiscount());
		rsvpDiscountImpl.setModifiedBy(rsvpDiscount.getModifiedBy());

		return rsvpDiscountImpl;
	}

	/**
	 * Returns the rsvp discount with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp discount
	 * @return the rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRsvpDiscountException, SystemException {
		RsvpDiscount rsvpDiscount = fetchByPrimaryKey(primaryKey);

		if (rsvpDiscount == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRsvpDiscountException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rsvpDiscount;
	}

	/**
	 * Returns the rsvp discount with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException} if it could not be found.
	 *
	 * @param rsvpDiscountId the primary key of the rsvp discount
	 * @return the rsvp discount
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDiscountException if a rsvp discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount findByPrimaryKey(long rsvpDiscountId)
		throws NoSuchRsvpDiscountException, SystemException {
		return findByPrimaryKey((Serializable)rsvpDiscountId);
	}

	/**
	 * Returns the rsvp discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp discount
	 * @return the rsvp discount, or <code>null</code> if a rsvp discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RsvpDiscount rsvpDiscount = (RsvpDiscount)EntityCacheUtil.getResult(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
				RsvpDiscountImpl.class, primaryKey);

		if (rsvpDiscount == _nullRsvpDiscount) {
			return null;
		}

		if (rsvpDiscount == null) {
			Session session = null;

			try {
				session = openSession();

				rsvpDiscount = (RsvpDiscount)session.get(RsvpDiscountImpl.class,
						primaryKey);

				if (rsvpDiscount != null) {
					cacheResult(rsvpDiscount);
				}
				else {
					EntityCacheUtil.putResult(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
						RsvpDiscountImpl.class, primaryKey, _nullRsvpDiscount);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RsvpDiscountModelImpl.ENTITY_CACHE_ENABLED,
					RsvpDiscountImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rsvpDiscount;
	}

	/**
	 * Returns the rsvp discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rsvpDiscountId the primary key of the rsvp discount
	 * @return the rsvp discount, or <code>null</code> if a rsvp discount with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDiscount fetchByPrimaryKey(long rsvpDiscountId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)rsvpDiscountId);
	}

	/**
	 * Returns all the rsvp discounts.
	 *
	 * @return the rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp discounts
	 * @param end the upper bound of the range of rsvp discounts (not inclusive)
	 * @return the range of rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp discounts
	 * @param end the upper bound of the range of rsvp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rsvp discounts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDiscount> findAll(int start, int end,
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

		List<RsvpDiscount> list = (List<RsvpDiscount>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RSVPDISCOUNT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RSVPDISCOUNT;

				if (pagination) {
					sql = sql.concat(RsvpDiscountModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RsvpDiscount>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDiscount>(list);
				}
				else {
					list = (List<RsvpDiscount>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rsvp discounts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RsvpDiscount rsvpDiscount : findAll()) {
			remove(rsvpDiscount);
		}
	}

	/**
	 * Returns the number of rsvp discounts.
	 *
	 * @return the number of rsvp discounts
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

				Query q = session.createQuery(_SQL_COUNT_RSVPDISCOUNT);

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
	 * Initializes the rsvp discount persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.rsvp.model.RsvpDiscount")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RsvpDiscount>> listenersList = new ArrayList<ModelListener<RsvpDiscount>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RsvpDiscount>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RsvpDiscountImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RSVPDISCOUNT = "SELECT rsvpDiscount FROM RsvpDiscount rsvpDiscount";
	private static final String _SQL_SELECT_RSVPDISCOUNT_WHERE = "SELECT rsvpDiscount FROM RsvpDiscount rsvpDiscount WHERE ";
	private static final String _SQL_COUNT_RSVPDISCOUNT = "SELECT COUNT(rsvpDiscount) FROM RsvpDiscount rsvpDiscount";
	private static final String _SQL_COUNT_RSVPDISCOUNT_WHERE = "SELECT COUNT(rsvpDiscount) FROM RsvpDiscount rsvpDiscount WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rsvpDiscount.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RsvpDiscount exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RsvpDiscount exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RsvpDiscountPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "rsvpDiscountId", "rsvpId", "rsvpTicketId"
			});
	private static RsvpDiscount _nullRsvpDiscount = new RsvpDiscountImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RsvpDiscount> toCacheModel() {
				return _nullRsvpDiscountCacheModel;
			}
		};

	private static CacheModel<RsvpDiscount> _nullRsvpDiscountCacheModel = new CacheModel<RsvpDiscount>() {
			@Override
			public RsvpDiscount toEntityModel() {
				return _nullRsvpDiscount;
			}
		};
}