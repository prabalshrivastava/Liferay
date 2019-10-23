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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException;
import com.sambaash.platform.srv.rsvp.model.RsvpTicket;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketImpl;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rsvp ticket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpTicketPersistence
 * @see RsvpTicketUtil
 * @generated
 */
public class RsvpTicketPersistenceImpl extends BasePersistenceImpl<RsvpTicket>
	implements RsvpTicketPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RsvpTicketUtil} to access the rsvp ticket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RsvpTicketImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, RsvpTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, RsvpTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, RsvpTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, RsvpTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RsvpTicketModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rsvp tickets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp tickets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp tickets
	 * @param end the upper bound of the range of rsvp tickets (not inclusive)
	 * @return the range of matching rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp tickets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp tickets
	 * @param end the upper bound of the range of rsvp tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findByUuid(String uuid, int start, int end,
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

		List<RsvpTicket> list = (List<RsvpTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpTicket rsvpTicket : list) {
				if (!Validator.equals(uuid, rsvpTicket.getUuid())) {
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

			query.append(_SQL_SELECT_RSVPTICKET_WHERE);

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
				query.append(RsvpTicketModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpTicket>(list);
				}
				else {
					list = (List<RsvpTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp ticket in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = fetchByUuid_First(uuid, orderByComparator);

		if (rsvpTicket != null) {
			return rsvpTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpTicketException(msg.toString());
	}

	/**
	 * Returns the first rsvp ticket in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpTicket> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp ticket in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = fetchByUuid_Last(uuid, orderByComparator);

		if (rsvpTicket != null) {
			return rsvpTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpTicketException(msg.toString());
	}

	/**
	 * Returns the last rsvp ticket in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RsvpTicket> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp tickets before and after the current rsvp ticket in the ordered set where uuid = &#63;.
	 *
	 * @param rsvpTicketId the primary key of the current rsvp ticket
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a rsvp ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket[] findByUuid_PrevAndNext(long rsvpTicketId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = findByPrimaryKey(rsvpTicketId);

		Session session = null;

		try {
			session = openSession();

			RsvpTicket[] array = new RsvpTicketImpl[3];

			array[0] = getByUuid_PrevAndNext(session, rsvpTicket, uuid,
					orderByComparator, true);

			array[1] = rsvpTicket;

			array[2] = getByUuid_PrevAndNext(session, rsvpTicket, uuid,
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

	protected RsvpTicket getByUuid_PrevAndNext(Session session,
		RsvpTicket rsvpTicket, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPTICKET_WHERE);

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
			query.append(RsvpTicketModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp tickets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RsvpTicket rsvpTicket : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvpTicket);
		}
	}

	/**
	 * Returns the number of rsvp tickets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rsvp tickets
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

			query.append(_SQL_COUNT_RSVPTICKET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "rsvpTicket.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "rsvpTicket.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(rsvpTicket.uuid IS NULL OR rsvpTicket.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, RsvpTicketImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpTicketModelImpl.UUID_COLUMN_BITMASK |
			RsvpTicketModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rsvp ticket where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket findByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = fetchByUUID_G(uuid, groupId);

		if (rsvpTicket == null) {
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

			throw new NoSuchRsvpTicketException(msg.toString());
		}

		return rsvpTicket;
	}

	/**
	 * Returns the rsvp ticket where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rsvp ticket where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RsvpTicket) {
			RsvpTicket rsvpTicket = (RsvpTicket)result;

			if (!Validator.equals(uuid, rsvpTicket.getUuid()) ||
					(groupId != rsvpTicket.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RSVPTICKET_WHERE);

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

				List<RsvpTicket> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RsvpTicket rsvpTicket = list.get(0);

					result = rsvpTicket;

					cacheResult(rsvpTicket);

					if ((rsvpTicket.getUuid() == null) ||
							!rsvpTicket.getUuid().equals(uuid) ||
							(rsvpTicket.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, rsvpTicket);
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
			return (RsvpTicket)result;
		}
	}

	/**
	 * Removes the rsvp ticket where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rsvp ticket that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket removeByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = findByUUID_G(uuid, groupId);

		return remove(rsvpTicket);
	}

	/**
	 * Returns the number of rsvp tickets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rsvp tickets
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

			query.append(_SQL_COUNT_RSVPTICKET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "rsvpTicket.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "rsvpTicket.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(rsvpTicket.uuid IS NULL OR rsvpTicket.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "rsvpTicket.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, RsvpTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, RsvpTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpTicketModelImpl.UUID_COLUMN_BITMASK |
			RsvpTicketModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rsvp tickets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp tickets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp tickets
	 * @param end the upper bound of the range of rsvp tickets (not inclusive)
	 * @return the range of matching rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp tickets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp tickets
	 * @param end the upper bound of the range of rsvp tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findByUuid_C(String uuid, long companyId,
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

		List<RsvpTicket> list = (List<RsvpTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpTicket rsvpTicket : list) {
				if (!Validator.equals(uuid, rsvpTicket.getUuid()) ||
						(companyId != rsvpTicket.getCompanyId())) {
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

			query.append(_SQL_SELECT_RSVPTICKET_WHERE);

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
				query.append(RsvpTicketModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpTicket>(list);
				}
				else {
					list = (List<RsvpTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (rsvpTicket != null) {
			return rsvpTicket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpTicketException(msg.toString());
	}

	/**
	 * Returns the first rsvp ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpTicket> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (rsvpTicket != null) {
			return rsvpTicket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpTicketException(msg.toString());
	}

	/**
	 * Returns the last rsvp ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RsvpTicket> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp tickets before and after the current rsvp ticket in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rsvpTicketId the primary key of the current rsvp ticket
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a rsvp ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket[] findByUuid_C_PrevAndNext(long rsvpTicketId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = findByPrimaryKey(rsvpTicketId);

		Session session = null;

		try {
			session = openSession();

			RsvpTicket[] array = new RsvpTicketImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, rsvpTicket, uuid,
					companyId, orderByComparator, true);

			array[1] = rsvpTicket;

			array[2] = getByUuid_C_PrevAndNext(session, rsvpTicket, uuid,
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

	protected RsvpTicket getByUuid_C_PrevAndNext(Session session,
		RsvpTicket rsvpTicket, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPTICKET_WHERE);

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
			query.append(RsvpTicketModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp tickets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (RsvpTicket rsvpTicket : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpTicket);
		}
	}

	/**
	 * Returns the number of rsvp tickets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rsvp tickets
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

			query.append(_SQL_COUNT_RSVPTICKET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "rsvpTicket.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "rsvpTicket.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(rsvpTicket.uuid IS NULL OR rsvpTicket.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "rsvpTicket.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPID = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, RsvpTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByrsvpId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID =
		new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, RsvpTicketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrsvpId",
			new String[] { Long.class.getName() },
			RsvpTicketModelImpl.RSVPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPID = new FinderPath(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrsvpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rsvp tickets where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the matching rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findByrsvpId(long rsvpId) throws SystemException {
		return findByrsvpId(rsvpId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp tickets where rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp tickets
	 * @param end the upper bound of the range of rsvp tickets (not inclusive)
	 * @return the range of matching rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findByrsvpId(long rsvpId, int start, int end)
		throws SystemException {
		return findByrsvpId(rsvpId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp tickets where rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp tickets
	 * @param end the upper bound of the range of rsvp tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findByrsvpId(long rsvpId, int start, int end,
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

		List<RsvpTicket> list = (List<RsvpTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpTicket rsvpTicket : list) {
				if ((rsvpId != rsvpTicket.getRsvpId())) {
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

			query.append(_SQL_SELECT_RSVPTICKET_WHERE);

			query.append(_FINDER_COLUMN_RSVPID_RSVPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpTicketModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				if (!pagination) {
					list = (List<RsvpTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpTicket>(list);
				}
				else {
					list = (List<RsvpTicket>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp ticket in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket findByrsvpId_First(long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = fetchByrsvpId_First(rsvpId, orderByComparator);

		if (rsvpTicket != null) {
			return rsvpTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpTicketException(msg.toString());
	}

	/**
	 * Returns the first rsvp ticket in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByrsvpId_First(long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpTicket> list = findByrsvpId(rsvpId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp ticket in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket findByrsvpId_Last(long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = fetchByrsvpId_Last(rsvpId, orderByComparator);

		if (rsvpTicket != null) {
			return rsvpTicket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpTicketException(msg.toString());
	}

	/**
	 * Returns the last rsvp ticket in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp ticket, or <code>null</code> if a matching rsvp ticket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByrsvpId_Last(long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByrsvpId(rsvpId);

		if (count == 0) {
			return null;
		}

		List<RsvpTicket> list = findByrsvpId(rsvpId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp tickets before and after the current rsvp ticket in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpTicketId the primary key of the current rsvp ticket
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a rsvp ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket[] findByrsvpId_PrevAndNext(long rsvpTicketId,
		long rsvpId, OrderByComparator orderByComparator)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = findByPrimaryKey(rsvpTicketId);

		Session session = null;

		try {
			session = openSession();

			RsvpTicket[] array = new RsvpTicketImpl[3];

			array[0] = getByrsvpId_PrevAndNext(session, rsvpTicket, rsvpId,
					orderByComparator, true);

			array[1] = rsvpTicket;

			array[2] = getByrsvpId_PrevAndNext(session, rsvpTicket, rsvpId,
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

	protected RsvpTicket getByrsvpId_PrevAndNext(Session session,
		RsvpTicket rsvpTicket, long rsvpId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPTICKET_WHERE);

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
			query.append(RsvpTicketModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpTicket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpTicket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp tickets where rsvpId = &#63; from the database.
	 *
	 * @param rsvpId the rsvp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByrsvpId(long rsvpId) throws SystemException {
		for (RsvpTicket rsvpTicket : findByrsvpId(rsvpId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvpTicket);
		}
	}

	/**
	 * Returns the number of rsvp tickets where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the number of matching rsvp tickets
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

			query.append(_SQL_COUNT_RSVPTICKET_WHERE);

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

	private static final String _FINDER_COLUMN_RSVPID_RSVPID_2 = "rsvpTicket.rsvpId = ?";

	public RsvpTicketPersistenceImpl() {
		setModelClass(RsvpTicket.class);
	}

	/**
	 * Caches the rsvp ticket in the entity cache if it is enabled.
	 *
	 * @param rsvpTicket the rsvp ticket
	 */
	@Override
	public void cacheResult(RsvpTicket rsvpTicket) {
		EntityCacheUtil.putResult(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketImpl.class, rsvpTicket.getPrimaryKey(), rsvpTicket);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { rsvpTicket.getUuid(), rsvpTicket.getGroupId() },
			rsvpTicket);

		rsvpTicket.resetOriginalValues();
	}

	/**
	 * Caches the rsvp tickets in the entity cache if it is enabled.
	 *
	 * @param rsvpTickets the rsvp tickets
	 */
	@Override
	public void cacheResult(List<RsvpTicket> rsvpTickets) {
		for (RsvpTicket rsvpTicket : rsvpTickets) {
			if (EntityCacheUtil.getResult(
						RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
						RsvpTicketImpl.class, rsvpTicket.getPrimaryKey()) == null) {
				cacheResult(rsvpTicket);
			}
			else {
				rsvpTicket.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rsvp tickets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RsvpTicketImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RsvpTicketImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rsvp ticket.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RsvpTicket rsvpTicket) {
		EntityCacheUtil.removeResult(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketImpl.class, rsvpTicket.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rsvpTicket);
	}

	@Override
	public void clearCache(List<RsvpTicket> rsvpTickets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RsvpTicket rsvpTicket : rsvpTickets) {
			EntityCacheUtil.removeResult(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
				RsvpTicketImpl.class, rsvpTicket.getPrimaryKey());

			clearUniqueFindersCache(rsvpTicket);
		}
	}

	protected void cacheUniqueFindersCache(RsvpTicket rsvpTicket) {
		if (rsvpTicket.isNew()) {
			Object[] args = new Object[] {
					rsvpTicket.getUuid(), rsvpTicket.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				rsvpTicket);
		}
		else {
			RsvpTicketModelImpl rsvpTicketModelImpl = (RsvpTicketModelImpl)rsvpTicket;

			if ((rsvpTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpTicket.getUuid(), rsvpTicket.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					rsvpTicket);
			}
		}
	}

	protected void clearUniqueFindersCache(RsvpTicket rsvpTicket) {
		RsvpTicketModelImpl rsvpTicketModelImpl = (RsvpTicketModelImpl)rsvpTicket;

		Object[] args = new Object[] {
				rsvpTicket.getUuid(), rsvpTicket.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((rsvpTicketModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					rsvpTicketModelImpl.getOriginalUuid(),
					rsvpTicketModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new rsvp ticket with the primary key. Does not add the rsvp ticket to the database.
	 *
	 * @param rsvpTicketId the primary key for the new rsvp ticket
	 * @return the new rsvp ticket
	 */
	@Override
	public RsvpTicket create(long rsvpTicketId) {
		RsvpTicket rsvpTicket = new RsvpTicketImpl();

		rsvpTicket.setNew(true);
		rsvpTicket.setPrimaryKey(rsvpTicketId);

		String uuid = PortalUUIDUtil.generate();

		rsvpTicket.setUuid(uuid);

		return rsvpTicket;
	}

	/**
	 * Removes the rsvp ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rsvpTicketId the primary key of the rsvp ticket
	 * @return the rsvp ticket that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a rsvp ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket remove(long rsvpTicketId)
		throws NoSuchRsvpTicketException, SystemException {
		return remove((Serializable)rsvpTicketId);
	}

	/**
	 * Removes the rsvp ticket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rsvp ticket
	 * @return the rsvp ticket that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a rsvp ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket remove(Serializable primaryKey)
		throws NoSuchRsvpTicketException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RsvpTicket rsvpTicket = (RsvpTicket)session.get(RsvpTicketImpl.class,
					primaryKey);

			if (rsvpTicket == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRsvpTicketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rsvpTicket);
		}
		catch (NoSuchRsvpTicketException nsee) {
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
	protected RsvpTicket removeImpl(RsvpTicket rsvpTicket)
		throws SystemException {
		rsvpTicket = toUnwrappedModel(rsvpTicket);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rsvpTicket)) {
				rsvpTicket = (RsvpTicket)session.get(RsvpTicketImpl.class,
						rsvpTicket.getPrimaryKeyObj());
			}

			if (rsvpTicket != null) {
				session.delete(rsvpTicket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rsvpTicket != null) {
			clearCache(rsvpTicket);
		}

		return rsvpTicket;
	}

	@Override
	public RsvpTicket updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpTicket rsvpTicket)
		throws SystemException {
		rsvpTicket = toUnwrappedModel(rsvpTicket);

		boolean isNew = rsvpTicket.isNew();

		RsvpTicketModelImpl rsvpTicketModelImpl = (RsvpTicketModelImpl)rsvpTicket;

		if (Validator.isNull(rsvpTicket.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rsvpTicket.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (rsvpTicket.isNew()) {
				session.save(rsvpTicket);

				rsvpTicket.setNew(false);
			}
			else {
				session.merge(rsvpTicket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RsvpTicketModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rsvpTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpTicketModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { rsvpTicketModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((rsvpTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpTicketModelImpl.getOriginalUuid(),
						rsvpTicketModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						rsvpTicketModelImpl.getUuid(),
						rsvpTicketModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((rsvpTicketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpTicketModelImpl.getOriginalRsvpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID,
					args);

				args = new Object[] { rsvpTicketModelImpl.getRsvpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID,
					args);
			}
		}

		EntityCacheUtil.putResult(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
			RsvpTicketImpl.class, rsvpTicket.getPrimaryKey(), rsvpTicket);

		clearUniqueFindersCache(rsvpTicket);
		cacheUniqueFindersCache(rsvpTicket);

		return rsvpTicket;
	}

	protected RsvpTicket toUnwrappedModel(RsvpTicket rsvpTicket) {
		if (rsvpTicket instanceof RsvpTicketImpl) {
			return rsvpTicket;
		}

		RsvpTicketImpl rsvpTicketImpl = new RsvpTicketImpl();

		rsvpTicketImpl.setNew(rsvpTicket.isNew());
		rsvpTicketImpl.setPrimaryKey(rsvpTicket.getPrimaryKey());

		rsvpTicketImpl.setUuid(rsvpTicket.getUuid());
		rsvpTicketImpl.setRsvpTicketId(rsvpTicket.getRsvpTicketId());
		rsvpTicketImpl.setGroupId(rsvpTicket.getGroupId());
		rsvpTicketImpl.setCompanyId(rsvpTicket.getCompanyId());
		rsvpTicketImpl.setUserId(rsvpTicket.getUserId());
		rsvpTicketImpl.setUserName(rsvpTicket.getUserName());
		rsvpTicketImpl.setCreateDate(rsvpTicket.getCreateDate());
		rsvpTicketImpl.setModifiedDate(rsvpTicket.getModifiedDate());
		rsvpTicketImpl.setRsvpId(rsvpTicket.getRsvpId());
		rsvpTicketImpl.setPrice(rsvpTicket.getPrice());
		rsvpTicketImpl.setQuantity(rsvpTicket.getQuantity());
		rsvpTicketImpl.setSoldQuantity(rsvpTicket.getSoldQuantity());
		rsvpTicketImpl.setTicketSequence(rsvpTicket.getTicketSequence());
		rsvpTicketImpl.setLastSequenceNumber(rsvpTicket.getLastSequenceNumber());
		rsvpTicketImpl.setSequencePrefix(rsvpTicket.getSequencePrefix());
		rsvpTicketImpl.setSequenceSuffix(rsvpTicket.getSequenceSuffix());
		rsvpTicketImpl.setTicketTemplateUrl(rsvpTicket.getTicketTemplateUrl());
		rsvpTicketImpl.setModifiedBy(rsvpTicket.getModifiedBy());

		return rsvpTicketImpl;
	}

	/**
	 * Returns the rsvp ticket with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp ticket
	 * @return the rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a rsvp ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRsvpTicketException, SystemException {
		RsvpTicket rsvpTicket = fetchByPrimaryKey(primaryKey);

		if (rsvpTicket == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRsvpTicketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rsvpTicket;
	}

	/**
	 * Returns the rsvp ticket with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException} if it could not be found.
	 *
	 * @param rsvpTicketId the primary key of the rsvp ticket
	 * @return the rsvp ticket
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpTicketException if a rsvp ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket findByPrimaryKey(long rsvpTicketId)
		throws NoSuchRsvpTicketException, SystemException {
		return findByPrimaryKey((Serializable)rsvpTicketId);
	}

	/**
	 * Returns the rsvp ticket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp ticket
	 * @return the rsvp ticket, or <code>null</code> if a rsvp ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RsvpTicket rsvpTicket = (RsvpTicket)EntityCacheUtil.getResult(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
				RsvpTicketImpl.class, primaryKey);

		if (rsvpTicket == _nullRsvpTicket) {
			return null;
		}

		if (rsvpTicket == null) {
			Session session = null;

			try {
				session = openSession();

				rsvpTicket = (RsvpTicket)session.get(RsvpTicketImpl.class,
						primaryKey);

				if (rsvpTicket != null) {
					cacheResult(rsvpTicket);
				}
				else {
					EntityCacheUtil.putResult(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
						RsvpTicketImpl.class, primaryKey, _nullRsvpTicket);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RsvpTicketModelImpl.ENTITY_CACHE_ENABLED,
					RsvpTicketImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rsvpTicket;
	}

	/**
	 * Returns the rsvp ticket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rsvpTicketId the primary key of the rsvp ticket
	 * @return the rsvp ticket, or <code>null</code> if a rsvp ticket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpTicket fetchByPrimaryKey(long rsvpTicketId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)rsvpTicketId);
	}

	/**
	 * Returns all the rsvp tickets.
	 *
	 * @return the rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp tickets
	 * @param end the upper bound of the range of rsvp tickets (not inclusive)
	 * @return the range of rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp tickets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp tickets
	 * @param end the upper bound of the range of rsvp tickets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rsvp tickets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpTicket> findAll(int start, int end,
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

		List<RsvpTicket> list = (List<RsvpTicket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RSVPTICKET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RSVPTICKET;

				if (pagination) {
					sql = sql.concat(RsvpTicketModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RsvpTicket>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpTicket>(list);
				}
				else {
					list = (List<RsvpTicket>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rsvp tickets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RsvpTicket rsvpTicket : findAll()) {
			remove(rsvpTicket);
		}
	}

	/**
	 * Returns the number of rsvp tickets.
	 *
	 * @return the number of rsvp tickets
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

				Query q = session.createQuery(_SQL_COUNT_RSVPTICKET);

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
	 * Initializes the rsvp ticket persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.rsvp.model.RsvpTicket")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RsvpTicket>> listenersList = new ArrayList<ModelListener<RsvpTicket>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RsvpTicket>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RsvpTicketImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RSVPTICKET = "SELECT rsvpTicket FROM RsvpTicket rsvpTicket";
	private static final String _SQL_SELECT_RSVPTICKET_WHERE = "SELECT rsvpTicket FROM RsvpTicket rsvpTicket WHERE ";
	private static final String _SQL_COUNT_RSVPTICKET = "SELECT COUNT(rsvpTicket) FROM RsvpTicket rsvpTicket";
	private static final String _SQL_COUNT_RSVPTICKET_WHERE = "SELECT COUNT(rsvpTicket) FROM RsvpTicket rsvpTicket WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rsvpTicket.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RsvpTicket exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RsvpTicket exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RsvpTicketPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "rsvpTicketId", "rsvpId"
			});
	private static RsvpTicket _nullRsvpTicket = new RsvpTicketImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RsvpTicket> toCacheModel() {
				return _nullRsvpTicketCacheModel;
			}
		};

	private static CacheModel<RsvpTicket> _nullRsvpTicketCacheModel = new CacheModel<RsvpTicket>() {
			@Override
			public RsvpTicket toEntityModel() {
				return _nullRsvpTicket;
			}
		};
}