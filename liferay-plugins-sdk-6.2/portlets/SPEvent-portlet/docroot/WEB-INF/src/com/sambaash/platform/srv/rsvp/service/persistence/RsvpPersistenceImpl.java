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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpException;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpImpl;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rsvp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPersistence
 * @see RsvpUtil
 * @generated
 */
public class RsvpPersistenceImpl extends BasePersistenceImpl<Rsvp>
	implements RsvpPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RsvpUtil} to access the rsvp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RsvpImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RsvpModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rsvps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rsvp> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvps
	 * @param end the upper bound of the range of rsvps (not inclusive)
	 * @return the range of matching rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rsvp> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvps
	 * @param end the upper bound of the range of rsvps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rsvp> findByUuid(String uuid, int start, int end,
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

		List<Rsvp> list = (List<Rsvp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Rsvp rsvp : list) {
				if (!Validator.equals(uuid, rsvp.getUuid())) {
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

			query.append(_SQL_SELECT_RSVP_WHERE);

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
				query.append(RsvpModelImpl.ORDER_BY_JPQL);
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
					list = (List<Rsvp>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Rsvp>(list);
				}
				else {
					list = (List<Rsvp>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first rsvp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = fetchByUuid_First(uuid, orderByComparator);

		if (rsvp != null) {
			return rsvp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpException(msg.toString());
	}

	/**
	 * Returns the first rsvp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Rsvp> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByUuid_Last(String uuid, OrderByComparator orderByComparator)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = fetchByUuid_Last(uuid, orderByComparator);

		if (rsvp != null) {
			return rsvp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpException(msg.toString());
	}

	/**
	 * Returns the last rsvp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Rsvp> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvps before and after the current rsvp in the ordered set where uuid = &#63;.
	 *
	 * @param rsvpId the primary key of the current rsvp
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp[] findByUuid_PrevAndNext(long rsvpId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = findByPrimaryKey(rsvpId);

		Session session = null;

		try {
			session = openSession();

			Rsvp[] array = new RsvpImpl[3];

			array[0] = getByUuid_PrevAndNext(session, rsvp, uuid,
					orderByComparator, true);

			array[1] = rsvp;

			array[2] = getByUuid_PrevAndNext(session, rsvp, uuid,
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

	protected Rsvp getByUuid_PrevAndNext(Session session, Rsvp rsvp,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVP_WHERE);

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
			query.append(RsvpModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Rsvp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Rsvp rsvp : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(rsvp);
		}
	}

	/**
	 * Returns the number of rsvps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rsvps
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

			query.append(_SQL_COUNT_RSVP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "rsvp.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "rsvp.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(rsvp.uuid IS NULL OR rsvp.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpModelImpl.UUID_COLUMN_BITMASK |
			RsvpModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rsvp where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = fetchByUUID_G(uuid, groupId);

		if (rsvp == null) {
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

			throw new NoSuchRsvpException(msg.toString());
		}

		return rsvp;
	}

	/**
	 * Returns the rsvp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rsvp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Rsvp) {
			Rsvp rsvp = (Rsvp)result;

			if (!Validator.equals(uuid, rsvp.getUuid()) ||
					(groupId != rsvp.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RSVP_WHERE);

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

				List<Rsvp> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Rsvp rsvp = list.get(0);

					result = rsvp;

					cacheResult(rsvp);

					if ((rsvp.getUuid() == null) ||
							!rsvp.getUuid().equals(uuid) ||
							(rsvp.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, rsvp);
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
			return (Rsvp)result;
		}
	}

	/**
	 * Removes the rsvp where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rsvp that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp removeByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = findByUUID_G(uuid, groupId);

		return remove(rsvp);
	}

	/**
	 * Returns the number of rsvps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rsvps
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

			query.append(_SQL_COUNT_RSVP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "rsvp.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "rsvp.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(rsvp.uuid IS NULL OR rsvp.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "rsvp.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpModelImpl.UUID_COLUMN_BITMASK |
			RsvpModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rsvps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rsvp> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvps
	 * @param end the upper bound of the range of rsvps (not inclusive)
	 * @return the range of matching rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rsvp> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvps
	 * @param end the upper bound of the range of rsvps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rsvp> findByUuid_C(String uuid, long companyId, int start,
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

		List<Rsvp> list = (List<Rsvp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Rsvp rsvp : list) {
				if (!Validator.equals(uuid, rsvp.getUuid()) ||
						(companyId != rsvp.getCompanyId())) {
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

			query.append(_SQL_SELECT_RSVP_WHERE);

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
				query.append(RsvpModelImpl.ORDER_BY_JPQL);
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
					list = (List<Rsvp>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Rsvp>(list);
				}
				else {
					list = (List<Rsvp>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (rsvp != null) {
			return rsvp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpException(msg.toString());
	}

	/**
	 * Returns the first rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Rsvp> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (rsvp != null) {
			return rsvp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpException(msg.toString());
	}

	/**
	 * Returns the last rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Rsvp> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvps before and after the current rsvp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rsvpId the primary key of the current rsvp
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp[] findByUuid_C_PrevAndNext(long rsvpId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = findByPrimaryKey(rsvpId);

		Session session = null;

		try {
			session = openSession();

			Rsvp[] array = new RsvpImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, rsvp, uuid, companyId,
					orderByComparator, true);

			array[1] = rsvp;

			array[2] = getByUuid_C_PrevAndNext(session, rsvp, uuid, companyId,
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

	protected Rsvp getByUuid_C_PrevAndNext(Session session, Rsvp rsvp,
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

		query.append(_SQL_SELECT_RSVP_WHERE);

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
			query.append(RsvpModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Rsvp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Rsvp rsvp : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvp);
		}
	}

	/**
	 * Returns the number of rsvps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rsvps
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

			query.append(_SQL_COUNT_RSVP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "rsvp.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "rsvp.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(rsvp.uuid IS NULL OR rsvp.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "rsvp.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EVENTID = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByeventId",
			new String[] { Long.class.getName() },
			RsvpModelImpl.EVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTID = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByeventId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the rsvp where eventId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	 *
	 * @param eventId the event ID
	 * @return the matching rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByeventId(long eventId)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = fetchByeventId(eventId);

		if (rsvp == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("eventId=");
			msg.append(eventId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRsvpException(msg.toString());
		}

		return rsvp;
	}

	/**
	 * Returns the rsvp where eventId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventId the event ID
	 * @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByeventId(long eventId) throws SystemException {
		return fetchByeventId(eventId, true);
	}

	/**
	 * Returns the rsvp where eventId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventId the event ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByeventId(long eventId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { eventId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EVENTID,
					finderArgs, this);
		}

		if (result instanceof Rsvp) {
			Rsvp rsvp = (Rsvp)result;

			if ((eventId != rsvp.getEventId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RSVP_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				List<Rsvp> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RsvpPersistenceImpl.fetchByeventId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Rsvp rsvp = list.get(0);

					result = rsvp;

					cacheResult(rsvp);

					if ((rsvp.getEventId() != eventId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTID,
							finderArgs, rsvp);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTID,
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
			return (Rsvp)result;
		}
	}

	/**
	 * Removes the rsvp where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @return the rsvp that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp removeByeventId(long eventId)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = findByeventId(eventId);

		return remove(rsvp);
	}

	/**
	 * Returns the number of rsvps where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByeventId(long eventId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTID;

		Object[] finderArgs = new Object[] { eventId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RSVP_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

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

	private static final String _FINDER_COLUMN_EVENTID_EVENTID_2 = "rsvp.eventId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_SPASSETTYPEID = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByspAssetTypeId",
			new String[] { Long.class.getName() },
			RsvpModelImpl.SPASSETTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPASSETTYPEID = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByspAssetTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the rsvp where spAssetTypeId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @return the matching rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByspAssetTypeId(long spAssetTypeId)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = fetchByspAssetTypeId(spAssetTypeId);

		if (rsvp == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spAssetTypeId=");
			msg.append(spAssetTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRsvpException(msg.toString());
		}

		return rsvp;
	}

	/**
	 * Returns the rsvp where spAssetTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByspAssetTypeId(long spAssetTypeId)
		throws SystemException {
		return fetchByspAssetTypeId(spAssetTypeId, true);
	}

	/**
	 * Returns the rsvp where spAssetTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByspAssetTypeId(long spAssetTypeId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spAssetTypeId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SPASSETTYPEID,
					finderArgs, this);
		}

		if (result instanceof Rsvp) {
			Rsvp rsvp = (Rsvp)result;

			if ((spAssetTypeId != rsvp.getSpAssetTypeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RSVP_WHERE);

			query.append(_FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spAssetTypeId);

				List<Rsvp> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPASSETTYPEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RsvpPersistenceImpl.fetchByspAssetTypeId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Rsvp rsvp = list.get(0);

					result = rsvp;

					cacheResult(rsvp);

					if ((rsvp.getSpAssetTypeId() != spAssetTypeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPASSETTYPEID,
							finderArgs, rsvp);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPASSETTYPEID,
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
			return (Rsvp)result;
		}
	}

	/**
	 * Removes the rsvp where spAssetTypeId = &#63; from the database.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @return the rsvp that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp removeByspAssetTypeId(long spAssetTypeId)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = findByspAssetTypeId(spAssetTypeId);

		return remove(rsvp);
	}

	/**
	 * Returns the number of rsvps where spAssetTypeId = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @return the number of matching rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByspAssetTypeId(long spAssetTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPASSETTYPEID;

		Object[] finderArgs = new Object[] { spAssetTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RSVP_WHERE);

			query.append(_FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spAssetTypeId);

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

	private static final String _FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2 = "rsvp.spAssetTypeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, RsvpImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByeventIdAndSpAssetTypeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			RsvpModelImpl.EVENTID_COLUMN_BITMASK |
			RsvpModelImpl.SPASSETTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTIDANDSPASSETTYPEID = new FinderPath(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByeventIdAndSpAssetTypeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the rsvp where eventId = &#63; and spAssetTypeId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	 *
	 * @param eventId the event ID
	 * @param spAssetTypeId the sp asset type ID
	 * @return the matching rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByeventIdAndSpAssetTypeId(long eventId, long spAssetTypeId)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = fetchByeventIdAndSpAssetTypeId(eventId, spAssetTypeId);

		if (rsvp == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("eventId=");
			msg.append(eventId);

			msg.append(", spAssetTypeId=");
			msg.append(spAssetTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRsvpException(msg.toString());
		}

		return rsvp;
	}

	/**
	 * Returns the rsvp where eventId = &#63; and spAssetTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventId the event ID
	 * @param spAssetTypeId the sp asset type ID
	 * @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByeventIdAndSpAssetTypeId(long eventId, long spAssetTypeId)
		throws SystemException {
		return fetchByeventIdAndSpAssetTypeId(eventId, spAssetTypeId, true);
	}

	/**
	 * Returns the rsvp where eventId = &#63; and spAssetTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventId the event ID
	 * @param spAssetTypeId the sp asset type ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp, or <code>null</code> if a matching rsvp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByeventIdAndSpAssetTypeId(long eventId,
		long spAssetTypeId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { eventId, spAssetTypeId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID,
					finderArgs, this);
		}

		if (result instanceof Rsvp) {
			Rsvp rsvp = (Rsvp)result;

			if ((eventId != rsvp.getEventId()) ||
					(spAssetTypeId != rsvp.getSpAssetTypeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RSVP_WHERE);

			query.append(_FINDER_COLUMN_EVENTIDANDSPASSETTYPEID_EVENTID_2);

			query.append(_FINDER_COLUMN_EVENTIDANDSPASSETTYPEID_SPASSETTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				qPos.add(spAssetTypeId);

				List<Rsvp> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RsvpPersistenceImpl.fetchByeventIdAndSpAssetTypeId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Rsvp rsvp = list.get(0);

					result = rsvp;

					cacheResult(rsvp);

					if ((rsvp.getEventId() != eventId) ||
							(rsvp.getSpAssetTypeId() != spAssetTypeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID,
							finderArgs, rsvp);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID,
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
			return (Rsvp)result;
		}
	}

	/**
	 * Removes the rsvp where eventId = &#63; and spAssetTypeId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @param spAssetTypeId the sp asset type ID
	 * @return the rsvp that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp removeByeventIdAndSpAssetTypeId(long eventId, long spAssetTypeId)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = findByeventIdAndSpAssetTypeId(eventId, spAssetTypeId);

		return remove(rsvp);
	}

	/**
	 * Returns the number of rsvps where eventId = &#63; and spAssetTypeId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param spAssetTypeId the sp asset type ID
	 * @return the number of matching rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByeventIdAndSpAssetTypeId(long eventId, long spAssetTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTIDANDSPASSETTYPEID;

		Object[] finderArgs = new Object[] { eventId, spAssetTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RSVP_WHERE);

			query.append(_FINDER_COLUMN_EVENTIDANDSPASSETTYPEID_EVENTID_2);

			query.append(_FINDER_COLUMN_EVENTIDANDSPASSETTYPEID_SPASSETTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				qPos.add(spAssetTypeId);

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

	private static final String _FINDER_COLUMN_EVENTIDANDSPASSETTYPEID_EVENTID_2 =
		"rsvp.eventId = ? AND ";
	private static final String _FINDER_COLUMN_EVENTIDANDSPASSETTYPEID_SPASSETTYPEID_2 =
		"rsvp.spAssetTypeId = ?";

	public RsvpPersistenceImpl() {
		setModelClass(Rsvp.class);
	}

	/**
	 * Caches the rsvp in the entity cache if it is enabled.
	 *
	 * @param rsvp the rsvp
	 */
	@Override
	public void cacheResult(Rsvp rsvp) {
		EntityCacheUtil.putResult(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpImpl.class, rsvp.getPrimaryKey(), rsvp);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { rsvp.getUuid(), rsvp.getGroupId() }, rsvp);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTID,
			new Object[] { rsvp.getEventId() }, rsvp);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPASSETTYPEID,
			new Object[] { rsvp.getSpAssetTypeId() }, rsvp);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID,
			new Object[] { rsvp.getEventId(), rsvp.getSpAssetTypeId() }, rsvp);

		rsvp.resetOriginalValues();
	}

	/**
	 * Caches the rsvps in the entity cache if it is enabled.
	 *
	 * @param rsvps the rsvps
	 */
	@Override
	public void cacheResult(List<Rsvp> rsvps) {
		for (Rsvp rsvp : rsvps) {
			if (EntityCacheUtil.getResult(RsvpModelImpl.ENTITY_CACHE_ENABLED,
						RsvpImpl.class, rsvp.getPrimaryKey()) == null) {
				cacheResult(rsvp);
			}
			else {
				rsvp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rsvps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RsvpImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RsvpImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rsvp.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Rsvp rsvp) {
		EntityCacheUtil.removeResult(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpImpl.class, rsvp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rsvp);
	}

	@Override
	public void clearCache(List<Rsvp> rsvps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Rsvp rsvp : rsvps) {
			EntityCacheUtil.removeResult(RsvpModelImpl.ENTITY_CACHE_ENABLED,
				RsvpImpl.class, rsvp.getPrimaryKey());

			clearUniqueFindersCache(rsvp);
		}
	}

	protected void cacheUniqueFindersCache(Rsvp rsvp) {
		if (rsvp.isNew()) {
			Object[] args = new Object[] { rsvp.getUuid(), rsvp.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, rsvp);

			args = new Object[] { rsvp.getEventId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTID, args, rsvp);

			args = new Object[] { rsvp.getSpAssetTypeId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SPASSETTYPEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPASSETTYPEID, args,
				rsvp);

			args = new Object[] { rsvp.getEventId(), rsvp.getSpAssetTypeId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTIDANDSPASSETTYPEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID,
				args, rsvp);
		}
		else {
			RsvpModelImpl rsvpModelImpl = (RsvpModelImpl)rsvp;

			if ((rsvpModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { rsvp.getUuid(), rsvp.getGroupId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					rsvp);
			}

			if ((rsvpModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { rsvp.getEventId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTID, args,
					rsvp);
			}

			if ((rsvpModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SPASSETTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { rsvp.getSpAssetTypeId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SPASSETTYPEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPASSETTYPEID,
					args, rsvp);
			}

			if ((rsvpModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvp.getEventId(), rsvp.getSpAssetTypeId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTIDANDSPASSETTYPEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID,
					args, rsvp);
			}
		}
	}

	protected void clearUniqueFindersCache(Rsvp rsvp) {
		RsvpModelImpl rsvpModelImpl = (RsvpModelImpl)rsvp;

		Object[] args = new Object[] { rsvp.getUuid(), rsvp.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((rsvpModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					rsvpModelImpl.getOriginalUuid(),
					rsvpModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { rsvp.getEventId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTID, args);

		if ((rsvpModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EVENTID.getColumnBitmask()) != 0) {
			args = new Object[] { rsvpModelImpl.getOriginalEventId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTID, args);
		}

		args = new Object[] { rsvp.getSpAssetTypeId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPASSETTYPEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPASSETTYPEID, args);

		if ((rsvpModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SPASSETTYPEID.getColumnBitmask()) != 0) {
			args = new Object[] { rsvpModelImpl.getOriginalSpAssetTypeId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPASSETTYPEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPASSETTYPEID,
				args);
		}

		args = new Object[] { rsvp.getEventId(), rsvp.getSpAssetTypeId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTIDANDSPASSETTYPEID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID,
			args);

		if ((rsvpModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					rsvpModelImpl.getOriginalEventId(),
					rsvpModelImpl.getOriginalSpAssetTypeId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTIDANDSPASSETTYPEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVENTIDANDSPASSETTYPEID,
				args);
		}
	}

	/**
	 * Creates a new rsvp with the primary key. Does not add the rsvp to the database.
	 *
	 * @param rsvpId the primary key for the new rsvp
	 * @return the new rsvp
	 */
	@Override
	public Rsvp create(long rsvpId) {
		Rsvp rsvp = new RsvpImpl();

		rsvp.setNew(true);
		rsvp.setPrimaryKey(rsvpId);

		String uuid = PortalUUIDUtil.generate();

		rsvp.setUuid(uuid);

		return rsvp;
	}

	/**
	 * Removes the rsvp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rsvpId the primary key of the rsvp
	 * @return the rsvp that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp remove(long rsvpId) throws NoSuchRsvpException, SystemException {
		return remove((Serializable)rsvpId);
	}

	/**
	 * Removes the rsvp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rsvp
	 * @return the rsvp that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp remove(Serializable primaryKey)
		throws NoSuchRsvpException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Rsvp rsvp = (Rsvp)session.get(RsvpImpl.class, primaryKey);

			if (rsvp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRsvpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rsvp);
		}
		catch (NoSuchRsvpException nsee) {
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
	protected Rsvp removeImpl(Rsvp rsvp) throws SystemException {
		rsvp = toUnwrappedModel(rsvp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rsvp)) {
				rsvp = (Rsvp)session.get(RsvpImpl.class, rsvp.getPrimaryKeyObj());
			}

			if (rsvp != null) {
				session.delete(rsvp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rsvp != null) {
			clearCache(rsvp);
		}

		return rsvp;
	}

	@Override
	public Rsvp updateImpl(com.sambaash.platform.srv.rsvp.model.Rsvp rsvp)
		throws SystemException {
		rsvp = toUnwrappedModel(rsvp);

		boolean isNew = rsvp.isNew();

		RsvpModelImpl rsvpModelImpl = (RsvpModelImpl)rsvp;

		if (Validator.isNull(rsvp.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rsvp.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (rsvp.isNew()) {
				session.save(rsvp);

				rsvp.setNew(false);
			}
			else {
				session.merge(rsvp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RsvpModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rsvpModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { rsvpModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { rsvpModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((rsvpModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpModelImpl.getOriginalUuid(),
						rsvpModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						rsvpModelImpl.getUuid(), rsvpModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(RsvpModelImpl.ENTITY_CACHE_ENABLED,
			RsvpImpl.class, rsvp.getPrimaryKey(), rsvp);

		clearUniqueFindersCache(rsvp);
		cacheUniqueFindersCache(rsvp);

		return rsvp;
	}

	protected Rsvp toUnwrappedModel(Rsvp rsvp) {
		if (rsvp instanceof RsvpImpl) {
			return rsvp;
		}

		RsvpImpl rsvpImpl = new RsvpImpl();

		rsvpImpl.setNew(rsvp.isNew());
		rsvpImpl.setPrimaryKey(rsvp.getPrimaryKey());

		rsvpImpl.setUuid(rsvp.getUuid());
		rsvpImpl.setRsvpId(rsvp.getRsvpId());
		rsvpImpl.setGroupId(rsvp.getGroupId());
		rsvpImpl.setCompanyId(rsvp.getCompanyId());
		rsvpImpl.setUserId(rsvp.getUserId());
		rsvpImpl.setUserName(rsvp.getUserName());
		rsvpImpl.setCreateDate(rsvp.getCreateDate());
		rsvpImpl.setModifiedDate(rsvp.getModifiedDate());
		rsvpImpl.setTitle(rsvp.getTitle());
		rsvpImpl.setDescription(rsvp.getDescription());
		rsvpImpl.setEventId(rsvp.getEventId());
		rsvpImpl.setSpAssetTypeId(rsvp.getSpAssetTypeId());
		rsvpImpl.setStatus(rsvp.isStatus());
		rsvpImpl.setRsvpUrl(rsvp.getRsvpUrl());
		rsvpImpl.setProcessing(rsvp.getProcessing());
		rsvpImpl.setPrice(rsvp.getPrice());
		rsvpImpl.setCurrency(rsvp.getCurrency());
		rsvpImpl.setTax(rsvp.getTax());
		rsvpImpl.setAccountId(rsvp.getAccountId());
		rsvpImpl.setPaymentFlag(rsvp.isPaymentFlag());
		rsvpImpl.setRegisterFlag(rsvp.isRegisterFlag());
		rsvpImpl.setTicketFlag(rsvp.isTicketFlag());
		rsvpImpl.setDynamicSectionName(rsvp.getDynamicSectionName());
		rsvpImpl.setCcEmail(rsvp.isCcEmail());

		return rsvpImpl;
	}

	/**
	 * Returns the rsvp with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp
	 * @return the rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRsvpException, SystemException {
		Rsvp rsvp = fetchByPrimaryKey(primaryKey);

		if (rsvp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRsvpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rsvp;
	}

	/**
	 * Returns the rsvp with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpException} if it could not be found.
	 *
	 * @param rsvpId the primary key of the rsvp
	 * @return the rsvp
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpException if a rsvp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp findByPrimaryKey(long rsvpId)
		throws NoSuchRsvpException, SystemException {
		return findByPrimaryKey((Serializable)rsvpId);
	}

	/**
	 * Returns the rsvp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp
	 * @return the rsvp, or <code>null</code> if a rsvp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Rsvp rsvp = (Rsvp)EntityCacheUtil.getResult(RsvpModelImpl.ENTITY_CACHE_ENABLED,
				RsvpImpl.class, primaryKey);

		if (rsvp == _nullRsvp) {
			return null;
		}

		if (rsvp == null) {
			Session session = null;

			try {
				session = openSession();

				rsvp = (Rsvp)session.get(RsvpImpl.class, primaryKey);

				if (rsvp != null) {
					cacheResult(rsvp);
				}
				else {
					EntityCacheUtil.putResult(RsvpModelImpl.ENTITY_CACHE_ENABLED,
						RsvpImpl.class, primaryKey, _nullRsvp);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RsvpModelImpl.ENTITY_CACHE_ENABLED,
					RsvpImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rsvp;
	}

	/**
	 * Returns the rsvp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rsvpId the primary key of the rsvp
	 * @return the rsvp, or <code>null</code> if a rsvp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rsvp fetchByPrimaryKey(long rsvpId) throws SystemException {
		return fetchByPrimaryKey((Serializable)rsvpId);
	}

	/**
	 * Returns all the rsvps.
	 *
	 * @return the rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rsvp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvps
	 * @param end the upper bound of the range of rsvps (not inclusive)
	 * @return the range of rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rsvp> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvps
	 * @param end the upper bound of the range of rsvps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rsvps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rsvp> findAll(int start, int end,
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

		List<Rsvp> list = (List<Rsvp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RSVP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RSVP;

				if (pagination) {
					sql = sql.concat(RsvpModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Rsvp>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Rsvp>(list);
				}
				else {
					list = (List<Rsvp>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the rsvps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Rsvp rsvp : findAll()) {
			remove(rsvp);
		}
	}

	/**
	 * Returns the number of rsvps.
	 *
	 * @return the number of rsvps
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

				Query q = session.createQuery(_SQL_COUNT_RSVP);

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
	 * Initializes the rsvp persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.rsvp.model.Rsvp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Rsvp>> listenersList = new ArrayList<ModelListener<Rsvp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Rsvp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RsvpImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RSVP = "SELECT rsvp FROM Rsvp rsvp";
	private static final String _SQL_SELECT_RSVP_WHERE = "SELECT rsvp FROM Rsvp rsvp WHERE ";
	private static final String _SQL_COUNT_RSVP = "SELECT COUNT(rsvp) FROM Rsvp rsvp";
	private static final String _SQL_COUNT_RSVP_WHERE = "SELECT COUNT(rsvp) FROM Rsvp rsvp WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rsvp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Rsvp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Rsvp exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RsvpPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "rsvpId", "currency"
			});
	private static Rsvp _nullRsvp = new RsvpImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Rsvp> toCacheModel() {
				return _nullRsvpCacheModel;
			}
		};

	private static CacheModel<Rsvp> _nullRsvpCacheModel = new CacheModel<Rsvp>() {
			@Override
			public Rsvp toEntityModel() {
				return _nullRsvp;
			}
		};
}