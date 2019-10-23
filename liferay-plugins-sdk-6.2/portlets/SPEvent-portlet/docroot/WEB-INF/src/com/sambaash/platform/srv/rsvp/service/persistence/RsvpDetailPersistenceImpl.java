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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailImpl;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rsvp detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpDetailPersistence
 * @see RsvpDetailUtil
 * @generated
 */
public class RsvpDetailPersistenceImpl extends BasePersistenceImpl<RsvpDetail>
	implements RsvpDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RsvpDetailUtil} to access the rsvp detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RsvpDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RsvpDetailModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rsvp details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByUuid(String uuid, int start, int end,
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

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDetail rsvpDetail : list) {
				if (!Validator.equals(uuid, rsvpDetail.getUuid())) {
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

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

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
				query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByUuid_First(uuid, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpDetail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByUuid_Last(uuid, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RsvpDetail> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp details before and after the current rsvp detail in the ordered set where uuid = &#63;.
	 *
	 * @param rsvpDetailId the primary key of the current rsvp detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail[] findByUuid_PrevAndNext(long rsvpDetailId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByPrimaryKey(rsvpDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpDetail[] array = new RsvpDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(session, rsvpDetail, uuid,
					orderByComparator, true);

			array[1] = rsvpDetail;

			array[2] = getByUuid_PrevAndNext(session, rsvpDetail, uuid,
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

	protected RsvpDetail getByUuid_PrevAndNext(Session session,
		RsvpDetail rsvpDetail, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

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
			query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RsvpDetail rsvpDetail : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rsvp details
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

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "rsvpDetail.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "rsvpDetail.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(rsvpDetail.uuid IS NULL OR rsvpDetail.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpDetailModelImpl.UUID_COLUMN_BITMASK |
			RsvpDetailModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rsvp detail where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByUUID_G(uuid, groupId);

		if (rsvpDetail == null) {
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

			throw new NoSuchRsvpDetailException(msg.toString());
		}

		return rsvpDetail;
	}

	/**
	 * Returns the rsvp detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rsvp detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RsvpDetail) {
			RsvpDetail rsvpDetail = (RsvpDetail)result;

			if (!Validator.equals(uuid, rsvpDetail.getUuid()) ||
					(groupId != rsvpDetail.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

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

				List<RsvpDetail> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RsvpDetail rsvpDetail = list.get(0);

					result = rsvpDetail;

					cacheResult(rsvpDetail);

					if ((rsvpDetail.getUuid() == null) ||
							!rsvpDetail.getUuid().equals(uuid) ||
							(rsvpDetail.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, rsvpDetail);
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
			return (RsvpDetail)result;
		}
	}

	/**
	 * Removes the rsvp detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rsvp detail that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByUUID_G(uuid, groupId);

		return remove(rsvpDetail);
	}

	/**
	 * Returns the number of rsvp details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rsvp details
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

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "rsvpDetail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "rsvpDetail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(rsvpDetail.uuid IS NULL OR rsvpDetail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "rsvpDetail.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpDetailModelImpl.UUID_COLUMN_BITMASK |
			RsvpDetailModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rsvp details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByUuid_C(String uuid, long companyId,
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

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDetail rsvpDetail : list) {
				if (!Validator.equals(uuid, rsvpDetail.getUuid()) ||
						(companyId != rsvpDetail.getCompanyId())) {
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

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

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
				query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpDetail> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RsvpDetail> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp details before and after the current rsvp detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rsvpDetailId the primary key of the current rsvp detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail[] findByUuid_C_PrevAndNext(long rsvpDetailId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByPrimaryKey(rsvpDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpDetail[] array = new RsvpDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, rsvpDetail, uuid,
					companyId, orderByComparator, true);

			array[1] = rsvpDetail;

			array[2] = getByUuid_C_PrevAndNext(session, rsvpDetail, uuid,
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

	protected RsvpDetail getByUuid_C_PrevAndNext(Session session,
		RsvpDetail rsvpDetail, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

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
			query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (RsvpDetail rsvpDetail : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rsvp details
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

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "rsvpDetail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "rsvpDetail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(rsvpDetail.uuid IS NULL OR rsvpDetail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "rsvpDetail.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPID = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRsvpId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRsvpId",
			new String[] { Long.class.getName() },
			RsvpDetailModelImpl.RSVPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPID = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRsvpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rsvp details where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByRsvpId(long rsvpId) throws SystemException {
		return findByRsvpId(rsvpId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details where rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByRsvpId(long rsvpId, int start, int end)
		throws SystemException {
		return findByRsvpId(rsvpId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp details where rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByRsvpId(long rsvpId, int start, int end,
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

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDetail rsvpDetail : list) {
				if ((rsvpId != rsvpDetail.getRsvpId())) {
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

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPID_RSVPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				if (!pagination) {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByRsvpId_First(long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByRsvpId_First(rsvpId, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByRsvpId_First(long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpDetail> list = findByRsvpId(rsvpId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByRsvpId_Last(long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByRsvpId_Last(rsvpId, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByRsvpId_Last(long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRsvpId(rsvpId);

		if (count == 0) {
			return null;
		}

		List<RsvpDetail> list = findByRsvpId(rsvpId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpDetailId the primary key of the current rsvp detail
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail[] findByRsvpId_PrevAndNext(long rsvpDetailId,
		long rsvpId, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByPrimaryKey(rsvpDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpDetail[] array = new RsvpDetailImpl[3];

			array[0] = getByRsvpId_PrevAndNext(session, rsvpDetail, rsvpId,
					orderByComparator, true);

			array[1] = rsvpDetail;

			array[2] = getByRsvpId_PrevAndNext(session, rsvpDetail, rsvpId,
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

	protected RsvpDetail getByRsvpId_PrevAndNext(Session session,
		RsvpDetail rsvpDetail, long rsvpId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

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
			query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp details where rsvpId = &#63; from the database.
	 *
	 * @param rsvpId the rsvp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRsvpId(long rsvpId) throws SystemException {
		for (RsvpDetail rsvpDetail : findByRsvpId(rsvpId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the number of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRsvpId(long rsvpId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RSVPID;

		Object[] finderArgs = new Object[] { rsvpId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_RSVPID_RSVPID_2 = "rsvpDetail.rsvpId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESSANDRSVPID =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemailAddressAndRsvpId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDRSVPID =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemailAddressAndRsvpId",
			new String[] { Long.class.getName(), String.class.getName() },
			RsvpDetailModelImpl.RSVPID_COLUMN_BITMASK |
			RsvpDetailModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESSANDRSVPID = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemailAddressAndRsvpId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @return the matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByemailAddressAndRsvpId(long rsvpId,
		String emailAddress) throws SystemException {
		return findByemailAddressAndRsvpId(rsvpId, emailAddress,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByemailAddressAndRsvpId(long rsvpId,
		String emailAddress, int start, int end) throws SystemException {
		return findByemailAddressAndRsvpId(rsvpId, emailAddress, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByemailAddressAndRsvpId(long rsvpId,
		String emailAddress, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDRSVPID;
			finderArgs = new Object[] { rsvpId, emailAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESSANDRSVPID;
			finderArgs = new Object[] {
					rsvpId, emailAddress,
					
					start, end, orderByComparator
				};
		}

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDetail rsvpDetail : list) {
				if ((rsvpId != rsvpDetail.getRsvpId()) ||
						!Validator.equals(emailAddress,
							rsvpDetail.getEmailAddress())) {
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

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_RSVPID_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				if (!pagination) {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByemailAddressAndRsvpId_First(long rsvpId,
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByemailAddressAndRsvpId_First(rsvpId,
				emailAddress, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(", emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByemailAddressAndRsvpId_First(long rsvpId,
		String emailAddress, OrderByComparator orderByComparator)
		throws SystemException {
		List<RsvpDetail> list = findByemailAddressAndRsvpId(rsvpId,
				emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByemailAddressAndRsvpId_Last(long rsvpId,
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByemailAddressAndRsvpId_Last(rsvpId,
				emailAddress, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(", emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByemailAddressAndRsvpId_Last(long rsvpId,
		String emailAddress, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByemailAddressAndRsvpId(rsvpId, emailAddress);

		if (count == 0) {
			return null;
		}

		List<RsvpDetail> list = findByemailAddressAndRsvpId(rsvpId,
				emailAddress, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63; and emailAddress = &#63;.
	 *
	 * @param rsvpDetailId the primary key of the current rsvp detail
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail[] findByemailAddressAndRsvpId_PrevAndNext(
		long rsvpDetailId, long rsvpId, String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByPrimaryKey(rsvpDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpDetail[] array = new RsvpDetailImpl[3];

			array[0] = getByemailAddressAndRsvpId_PrevAndNext(session,
					rsvpDetail, rsvpId, emailAddress, orderByComparator, true);

			array[1] = rsvpDetail;

			array[2] = getByemailAddressAndRsvpId_PrevAndNext(session,
					rsvpDetail, rsvpId, emailAddress, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RsvpDetail getByemailAddressAndRsvpId_PrevAndNext(
		Session session, RsvpDetail rsvpDetail, long rsvpId,
		String emailAddress, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

		query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_RSVPID_2);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_2);
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
			query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpId);

		if (bindEmailAddress) {
			qPos.add(emailAddress);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp details where rsvpId = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemailAddressAndRsvpId(long rsvpId, String emailAddress)
		throws SystemException {
		for (RsvpDetail rsvpDetail : findByemailAddressAndRsvpId(rsvpId,
				emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details where rsvpId = &#63; and emailAddress = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param emailAddress the email address
	 * @return the number of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByemailAddressAndRsvpId(long rsvpId, String emailAddress)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESSANDRSVPID;

		Object[] finderArgs = new Object[] { rsvpId, emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_RSVPID_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAILADDRESSANDRSVPID_RSVPID_2 = "rsvpDetail.rsvpId = ? AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_1 =
		"rsvpDetail.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_2 =
		"rsvpDetail.emailAddress = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDRSVPID_EMAILADDRESS_3 =
		"(rsvpDetail.emailAddress IS NULL OR rsvpDetail.emailAddress = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDRSVPID =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynameAndRsvpId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDRSVPID =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBynameAndRsvpId",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpDetailModelImpl.FIRSTNAME_COLUMN_BITMASK |
			RsvpDetailModelImpl.RSVPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDRSVPID = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynameAndRsvpId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rsvp details where firstName = &#63; and rsvpId = &#63;.
	 *
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @return the matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findBynameAndRsvpId(String firstName, long rsvpId)
		throws SystemException {
		return findBynameAndRsvpId(firstName, rsvpId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details where firstName = &#63; and rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findBynameAndRsvpId(String firstName, long rsvpId,
		int start, int end) throws SystemException {
		return findBynameAndRsvpId(firstName, rsvpId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp details where firstName = &#63; and rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findBynameAndRsvpId(String firstName, long rsvpId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDRSVPID;
			finderArgs = new Object[] { firstName, rsvpId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDRSVPID;
			finderArgs = new Object[] {
					firstName, rsvpId,
					
					start, end, orderByComparator
				};
		}

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDetail rsvpDetail : list) {
				if (!Validator.equals(firstName, rsvpDetail.getFirstName()) ||
						(rsvpId != rsvpDetail.getRsvpId())) {
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

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDRSVPID_RSVPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				qPos.add(rsvpId);

				if (!pagination) {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	 *
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findBynameAndRsvpId_First(String firstName, long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchBynameAndRsvpId_First(firstName, rsvpId,
				orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	 *
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchBynameAndRsvpId_First(String firstName, long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpDetail> list = findBynameAndRsvpId(firstName, rsvpId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	 *
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findBynameAndRsvpId_Last(String firstName, long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchBynameAndRsvpId_Last(firstName, rsvpId,
				orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	 *
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchBynameAndRsvpId_Last(String firstName, long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBynameAndRsvpId(firstName, rsvpId);

		if (count == 0) {
			return null;
		}

		List<RsvpDetail> list = findBynameAndRsvpId(firstName, rsvpId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp details before and after the current rsvp detail in the ordered set where firstName = &#63; and rsvpId = &#63;.
	 *
	 * @param rsvpDetailId the primary key of the current rsvp detail
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail[] findBynameAndRsvpId_PrevAndNext(long rsvpDetailId,
		String firstName, long rsvpId, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByPrimaryKey(rsvpDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpDetail[] array = new RsvpDetailImpl[3];

			array[0] = getBynameAndRsvpId_PrevAndNext(session, rsvpDetail,
					firstName, rsvpId, orderByComparator, true);

			array[1] = rsvpDetail;

			array[2] = getBynameAndRsvpId_PrevAndNext(session, rsvpDetail,
					firstName, rsvpId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RsvpDetail getBynameAndRsvpId_PrevAndNext(Session session,
		RsvpDetail rsvpDetail, String firstName, long rsvpId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_2);
		}

		query.append(_FINDER_COLUMN_NAMEANDRSVPID_RSVPID_2);

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
			query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstName) {
			qPos.add(firstName);
		}

		qPos.add(rsvpId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp details where firstName = &#63; and rsvpId = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBynameAndRsvpId(String firstName, long rsvpId)
		throws SystemException {
		for (RsvpDetail rsvpDetail : findBynameAndRsvpId(firstName, rsvpId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details where firstName = &#63; and rsvpId = &#63;.
	 *
	 * @param firstName the first name
	 * @param rsvpId the rsvp ID
	 * @return the number of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBynameAndRsvpId(String firstName, long rsvpId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEANDRSVPID;

		Object[] finderArgs = new Object[] { firstName, rsvpId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDRSVPID_RSVPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

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

	private static final String _FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_1 = "rsvpDetail.firstName IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_2 = "rsvpDetail.firstName = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDRSVPID_FIRSTNAME_3 = "(rsvpDetail.firstName IS NULL OR rsvpDetail.firstName = '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDRSVPID_RSVPID_2 = "rsvpDetail.rsvpId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESS =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemailAddress",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemailAddress",
			new String[] { String.class.getName() },
			RsvpDetailModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailAddress",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rsvp details where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByemailAddress(String emailAddress)
		throws SystemException {
		return findByemailAddress(emailAddress, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByemailAddress(String emailAddress, int start,
		int end) throws SystemException {
		return findByemailAddress(emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp details where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByemailAddress(String emailAddress, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS;
			finderArgs = new Object[] { emailAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESS;
			finderArgs = new Object[] {
					emailAddress,
					
					start, end, orderByComparator
				};
		}

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDetail rsvpDetail : list) {
				if (!Validator.equals(emailAddress, rsvpDetail.getEmailAddress())) {
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

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				if (!pagination) {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp detail in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByemailAddress_First(String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByemailAddress_First(emailAddress,
				orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp detail in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByemailAddress_First(String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpDetail> list = findByemailAddress(emailAddress, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp detail in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByemailAddress_Last(String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByemailAddress_Last(emailAddress,
				orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp detail in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByemailAddress_Last(String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemailAddress(emailAddress);

		if (count == 0) {
			return null;
		}

		List<RsvpDetail> list = findByemailAddress(emailAddress, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp details before and after the current rsvp detail in the ordered set where emailAddress = &#63;.
	 *
	 * @param rsvpDetailId the primary key of the current rsvp detail
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail[] findByemailAddress_PrevAndNext(long rsvpDetailId,
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByPrimaryKey(rsvpDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpDetail[] array = new RsvpDetailImpl[3];

			array[0] = getByemailAddress_PrevAndNext(session, rsvpDetail,
					emailAddress, orderByComparator, true);

			array[1] = rsvpDetail;

			array[2] = getByemailAddress_PrevAndNext(session, rsvpDetail,
					emailAddress, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RsvpDetail getByemailAddress_PrevAndNext(Session session,
		RsvpDetail rsvpDetail, String emailAddress,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
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
			query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmailAddress) {
			qPos.add(emailAddress);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp details where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemailAddress(String emailAddress)
		throws SystemException {
		for (RsvpDetail rsvpDetail : findByemailAddress(emailAddress,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByemailAddress(String emailAddress)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESS;

		Object[] finderArgs = new Object[] { emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1 = "rsvpDetail.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 = "rsvpDetail.emailAddress = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 = "(rsvpDetail.emailAddress IS NULL OR rsvpDetail.emailAddress = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPSTATUSANDRSVPID =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrsvpStatusAndRsvpId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPSTATUSANDRSVPID =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByrsvpStatusAndRsvpId",
			new String[] { Long.class.getName(), Integer.class.getName() },
			RsvpDetailModelImpl.RSVPID_COLUMN_BITMASK |
			RsvpDetailModelImpl.RSVPSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPSTATUSANDRSVPID = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrsvpStatusAndRsvpId",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @return the matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByrsvpStatusAndRsvpId(long rsvpId,
		int rsvpStatus) throws SystemException {
		return findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByrsvpStatusAndRsvpId(long rsvpId,
		int rsvpStatus, int start, int end) throws SystemException {
		return findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByrsvpStatusAndRsvpId(long rsvpId,
		int rsvpStatus, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPSTATUSANDRSVPID;
			finderArgs = new Object[] { rsvpId, rsvpStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPSTATUSANDRSVPID;
			finderArgs = new Object[] {
					rsvpId, rsvpStatus,
					
					start, end, orderByComparator
				};
		}

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDetail rsvpDetail : list) {
				if ((rsvpId != rsvpDetail.getRsvpId()) ||
						(rsvpStatus != rsvpDetail.getRsvpStatus())) {
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

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPSTATUSANDRSVPID_RSVPID_2);

			query.append(_FINDER_COLUMN_RSVPSTATUSANDRSVPID_RSVPSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				qPos.add(rsvpStatus);

				if (!pagination) {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByrsvpStatusAndRsvpId_First(long rsvpId,
		int rsvpStatus, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByrsvpStatusAndRsvpId_First(rsvpId,
				rsvpStatus, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(", rsvpStatus=");
		msg.append(rsvpStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByrsvpStatusAndRsvpId_First(long rsvpId,
		int rsvpStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<RsvpDetail> list = findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByrsvpStatusAndRsvpId_Last(long rsvpId,
		int rsvpStatus, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByrsvpStatusAndRsvpId_Last(rsvpId,
				rsvpStatus, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(", rsvpStatus=");
		msg.append(rsvpStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByrsvpStatusAndRsvpId_Last(long rsvpId,
		int rsvpStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByrsvpStatusAndRsvpId(rsvpId, rsvpStatus);

		if (count == 0) {
			return null;
		}

		List<RsvpDetail> list = findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63; and rsvpStatus = &#63;.
	 *
	 * @param rsvpDetailId the primary key of the current rsvp detail
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail[] findByrsvpStatusAndRsvpId_PrevAndNext(
		long rsvpDetailId, long rsvpId, int rsvpStatus,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByPrimaryKey(rsvpDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpDetail[] array = new RsvpDetailImpl[3];

			array[0] = getByrsvpStatusAndRsvpId_PrevAndNext(session,
					rsvpDetail, rsvpId, rsvpStatus, orderByComparator, true);

			array[1] = rsvpDetail;

			array[2] = getByrsvpStatusAndRsvpId_PrevAndNext(session,
					rsvpDetail, rsvpId, rsvpStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RsvpDetail getByrsvpStatusAndRsvpId_PrevAndNext(Session session,
		RsvpDetail rsvpDetail, long rsvpId, int rsvpStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RSVPSTATUSANDRSVPID_RSVPID_2);

		query.append(_FINDER_COLUMN_RSVPSTATUSANDRSVPID_RSVPSTATUS_2);

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
			query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpId);

		qPos.add(rsvpStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp details where rsvpId = &#63; and rsvpStatus = &#63; from the database.
	 *
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByrsvpStatusAndRsvpId(long rsvpId, int rsvpStatus)
		throws SystemException {
		for (RsvpDetail rsvpDetail : findByrsvpStatusAndRsvpId(rsvpId,
				rsvpStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details where rsvpId = &#63; and rsvpStatus = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param rsvpStatus the rsvp status
	 * @return the number of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByrsvpStatusAndRsvpId(long rsvpId, int rsvpStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RSVPSTATUSANDRSVPID;

		Object[] finderArgs = new Object[] { rsvpId, rsvpStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPSTATUSANDRSVPID_RSVPID_2);

			query.append(_FINDER_COLUMN_RSVPSTATUSANDRSVPID_RSVPSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				qPos.add(rsvpStatus);

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

	private static final String _FINDER_COLUMN_RSVPSTATUSANDRSVPID_RSVPID_2 = "rsvpDetail.rsvpId = ? AND ";
	private static final String _FINDER_COLUMN_RSVPSTATUSANDRSVPID_RSVPSTATUS_2 = "rsvpDetail.rsvpStatus = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPIDANDSOURCE =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByrsvpIdAndSource",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDSOURCE =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrsvpIdAndSource",
			new String[] { Long.class.getName(), Integer.class.getName() },
			RsvpDetailModelImpl.RSVPID_COLUMN_BITMASK |
			RsvpDetailModelImpl.SOURCE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPIDANDSOURCE = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrsvpIdAndSource",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the rsvp details where rsvpId = &#63; and source = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @return the matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByrsvpIdAndSource(long rsvpId, int source)
		throws SystemException {
		return findByrsvpIdAndSource(rsvpId, source, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details where rsvpId = &#63; and source = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByrsvpIdAndSource(long rsvpId, int source,
		int start, int end) throws SystemException {
		return findByrsvpIdAndSource(rsvpId, source, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp details where rsvpId = &#63; and source = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByrsvpIdAndSource(long rsvpId, int source,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDSOURCE;
			finderArgs = new Object[] { rsvpId, source };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPIDANDSOURCE;
			finderArgs = new Object[] {
					rsvpId, source,
					
					start, end, orderByComparator
				};
		}

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDetail rsvpDetail : list) {
				if ((rsvpId != rsvpDetail.getRsvpId()) ||
						(source != rsvpDetail.getSource())) {
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

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPIDANDSOURCE_RSVPID_2);

			query.append(_FINDER_COLUMN_RSVPIDANDSOURCE_SOURCE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				qPos.add(source);

				if (!pagination) {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByrsvpIdAndSource_First(long rsvpId, int source,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByrsvpIdAndSource_First(rsvpId, source,
				orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(", source=");
		msg.append(source);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByrsvpIdAndSource_First(long rsvpId, int source,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpDetail> list = findByrsvpIdAndSource(rsvpId, source, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByrsvpIdAndSource_Last(long rsvpId, int source,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByrsvpIdAndSource_Last(rsvpId, source,
				orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(", source=");
		msg.append(source);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByrsvpIdAndSource_Last(long rsvpId, int source,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByrsvpIdAndSource(rsvpId, source);

		if (count == 0) {
			return null;
		}

		List<RsvpDetail> list = findByrsvpIdAndSource(rsvpId, source,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63; and source = &#63;.
	 *
	 * @param rsvpDetailId the primary key of the current rsvp detail
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail[] findByrsvpIdAndSource_PrevAndNext(long rsvpDetailId,
		long rsvpId, int source, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByPrimaryKey(rsvpDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpDetail[] array = new RsvpDetailImpl[3];

			array[0] = getByrsvpIdAndSource_PrevAndNext(session, rsvpDetail,
					rsvpId, source, orderByComparator, true);

			array[1] = rsvpDetail;

			array[2] = getByrsvpIdAndSource_PrevAndNext(session, rsvpDetail,
					rsvpId, source, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RsvpDetail getByrsvpIdAndSource_PrevAndNext(Session session,
		RsvpDetail rsvpDetail, long rsvpId, int source,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RSVPIDANDSOURCE_RSVPID_2);

		query.append(_FINDER_COLUMN_RSVPIDANDSOURCE_SOURCE_2);

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
			query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpId);

		qPos.add(source);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp details where rsvpId = &#63; and source = &#63; from the database.
	 *
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByrsvpIdAndSource(long rsvpId, int source)
		throws SystemException {
		for (RsvpDetail rsvpDetail : findByrsvpIdAndSource(rsvpId, source,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details where rsvpId = &#63; and source = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param source the source
	 * @return the number of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByrsvpIdAndSource(long rsvpId, int source)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RSVPIDANDSOURCE;

		Object[] finderArgs = new Object[] { rsvpId, source };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPIDANDSOURCE_RSVPID_2);

			query.append(_FINDER_COLUMN_RSVPIDANDSOURCE_SOURCE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				qPos.add(source);

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

	private static final String _FINDER_COLUMN_RSVPIDANDSOURCE_RSVPID_2 = "rsvpDetail.rsvpId = ? AND ";
	private static final String _FINDER_COLUMN_RSVPIDANDSOURCE_SOURCE_2 = "rsvpDetail.source = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPIDANDATTENDANCE =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrsvpIdAndAttendance",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDATTENDANCE =
		new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, RsvpDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByrsvpIdAndAttendance",
			new String[] { Long.class.getName(), Integer.class.getName() },
			RsvpDetailModelImpl.RSVPID_COLUMN_BITMASK |
			RsvpDetailModelImpl.ATTENDANCE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPIDANDATTENDANCE = new FinderPath(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrsvpIdAndAttendance",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the rsvp details where rsvpId = &#63; and attendance = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @return the matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByrsvpIdAndAttendance(long rsvpId,
		int attendance) throws SystemException {
		return findByrsvpIdAndAttendance(rsvpId, attendance, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details where rsvpId = &#63; and attendance = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByrsvpIdAndAttendance(long rsvpId,
		int attendance, int start, int end) throws SystemException {
		return findByrsvpIdAndAttendance(rsvpId, attendance, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp details where rsvpId = &#63; and attendance = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findByrsvpIdAndAttendance(long rsvpId,
		int attendance, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDATTENDANCE;
			finderArgs = new Object[] { rsvpId, attendance };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPIDANDATTENDANCE;
			finderArgs = new Object[] {
					rsvpId, attendance,
					
					start, end, orderByComparator
				};
		}

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpDetail rsvpDetail : list) {
				if ((rsvpId != rsvpDetail.getRsvpId()) ||
						(attendance != rsvpDetail.getAttendance())) {
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

			query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPIDANDATTENDANCE_RSVPID_2);

			query.append(_FINDER_COLUMN_RSVPIDANDATTENDANCE_ATTENDANCE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				qPos.add(attendance);

				if (!pagination) {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByrsvpIdAndAttendance_First(long rsvpId,
		int attendance, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByrsvpIdAndAttendance_First(rsvpId,
				attendance, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(", attendance=");
		msg.append(attendance);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByrsvpIdAndAttendance_First(long rsvpId,
		int attendance, OrderByComparator orderByComparator)
		throws SystemException {
		List<RsvpDetail> list = findByrsvpIdAndAttendance(rsvpId, attendance,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByrsvpIdAndAttendance_Last(long rsvpId,
		int attendance, OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByrsvpIdAndAttendance_Last(rsvpId,
				attendance, orderByComparator);

		if (rsvpDetail != null) {
			return rsvpDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(", attendance=");
		msg.append(attendance);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByrsvpIdAndAttendance_Last(long rsvpId,
		int attendance, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByrsvpIdAndAttendance(rsvpId, attendance);

		if (count == 0) {
			return null;
		}

		List<RsvpDetail> list = findByrsvpIdAndAttendance(rsvpId, attendance,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp details before and after the current rsvp detail in the ordered set where rsvpId = &#63; and attendance = &#63;.
	 *
	 * @param rsvpDetailId the primary key of the current rsvp detail
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail[] findByrsvpIdAndAttendance_PrevAndNext(
		long rsvpDetailId, long rsvpId, int attendance,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = findByPrimaryKey(rsvpDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpDetail[] array = new RsvpDetailImpl[3];

			array[0] = getByrsvpIdAndAttendance_PrevAndNext(session,
					rsvpDetail, rsvpId, attendance, orderByComparator, true);

			array[1] = rsvpDetail;

			array[2] = getByrsvpIdAndAttendance_PrevAndNext(session,
					rsvpDetail, rsvpId, attendance, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RsvpDetail getByrsvpIdAndAttendance_PrevAndNext(Session session,
		RsvpDetail rsvpDetail, long rsvpId, int attendance,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RSVPIDANDATTENDANCE_RSVPID_2);

		query.append(_FINDER_COLUMN_RSVPIDANDATTENDANCE_ATTENDANCE_2);

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
			query.append(RsvpDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpId);

		qPos.add(attendance);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp details where rsvpId = &#63; and attendance = &#63; from the database.
	 *
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByrsvpIdAndAttendance(long rsvpId, int attendance)
		throws SystemException {
		for (RsvpDetail rsvpDetail : findByrsvpIdAndAttendance(rsvpId,
				attendance, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details where rsvpId = &#63; and attendance = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param attendance the attendance
	 * @return the number of matching rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByrsvpIdAndAttendance(long rsvpId, int attendance)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RSVPIDANDATTENDANCE;

		Object[] finderArgs = new Object[] { rsvpId, attendance };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RSVPDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPIDANDATTENDANCE_RSVPID_2);

			query.append(_FINDER_COLUMN_RSVPIDANDATTENDANCE_ATTENDANCE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				qPos.add(attendance);

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

	private static final String _FINDER_COLUMN_RSVPIDANDATTENDANCE_RSVPID_2 = "rsvpDetail.rsvpId = ? AND ";
	private static final String _FINDER_COLUMN_RSVPIDANDATTENDANCE_ATTENDANCE_2 = "rsvpDetail.attendance = ?";

	public RsvpDetailPersistenceImpl() {
		setModelClass(RsvpDetail.class);
	}

	/**
	 * Caches the rsvp detail in the entity cache if it is enabled.
	 *
	 * @param rsvpDetail the rsvp detail
	 */
	@Override
	public void cacheResult(RsvpDetail rsvpDetail) {
		EntityCacheUtil.putResult(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailImpl.class, rsvpDetail.getPrimaryKey(), rsvpDetail);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { rsvpDetail.getUuid(), rsvpDetail.getGroupId() },
			rsvpDetail);

		rsvpDetail.resetOriginalValues();
	}

	/**
	 * Caches the rsvp details in the entity cache if it is enabled.
	 *
	 * @param rsvpDetails the rsvp details
	 */
	@Override
	public void cacheResult(List<RsvpDetail> rsvpDetails) {
		for (RsvpDetail rsvpDetail : rsvpDetails) {
			if (EntityCacheUtil.getResult(
						RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
						RsvpDetailImpl.class, rsvpDetail.getPrimaryKey()) == null) {
				cacheResult(rsvpDetail);
			}
			else {
				rsvpDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rsvp details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RsvpDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RsvpDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rsvp detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RsvpDetail rsvpDetail) {
		EntityCacheUtil.removeResult(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailImpl.class, rsvpDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rsvpDetail);
	}

	@Override
	public void clearCache(List<RsvpDetail> rsvpDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RsvpDetail rsvpDetail : rsvpDetails) {
			EntityCacheUtil.removeResult(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
				RsvpDetailImpl.class, rsvpDetail.getPrimaryKey());

			clearUniqueFindersCache(rsvpDetail);
		}
	}

	protected void cacheUniqueFindersCache(RsvpDetail rsvpDetail) {
		if (rsvpDetail.isNew()) {
			Object[] args = new Object[] {
					rsvpDetail.getUuid(), rsvpDetail.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				rsvpDetail);
		}
		else {
			RsvpDetailModelImpl rsvpDetailModelImpl = (RsvpDetailModelImpl)rsvpDetail;

			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetail.getUuid(), rsvpDetail.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					rsvpDetail);
			}
		}
	}

	protected void clearUniqueFindersCache(RsvpDetail rsvpDetail) {
		RsvpDetailModelImpl rsvpDetailModelImpl = (RsvpDetailModelImpl)rsvpDetail;

		Object[] args = new Object[] {
				rsvpDetail.getUuid(), rsvpDetail.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((rsvpDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					rsvpDetailModelImpl.getOriginalUuid(),
					rsvpDetailModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new rsvp detail with the primary key. Does not add the rsvp detail to the database.
	 *
	 * @param rsvpDetailId the primary key for the new rsvp detail
	 * @return the new rsvp detail
	 */
	@Override
	public RsvpDetail create(long rsvpDetailId) {
		RsvpDetail rsvpDetail = new RsvpDetailImpl();

		rsvpDetail.setNew(true);
		rsvpDetail.setPrimaryKey(rsvpDetailId);

		String uuid = PortalUUIDUtil.generate();

		rsvpDetail.setUuid(uuid);

		return rsvpDetail;
	}

	/**
	 * Removes the rsvp detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rsvpDetailId the primary key of the rsvp detail
	 * @return the rsvp detail that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail remove(long rsvpDetailId)
		throws NoSuchRsvpDetailException, SystemException {
		return remove((Serializable)rsvpDetailId);
	}

	/**
	 * Removes the rsvp detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rsvp detail
	 * @return the rsvp detail that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail remove(Serializable primaryKey)
		throws NoSuchRsvpDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RsvpDetail rsvpDetail = (RsvpDetail)session.get(RsvpDetailImpl.class,
					primaryKey);

			if (rsvpDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRsvpDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rsvpDetail);
		}
		catch (NoSuchRsvpDetailException nsee) {
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
	protected RsvpDetail removeImpl(RsvpDetail rsvpDetail)
		throws SystemException {
		rsvpDetail = toUnwrappedModel(rsvpDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rsvpDetail)) {
				rsvpDetail = (RsvpDetail)session.get(RsvpDetailImpl.class,
						rsvpDetail.getPrimaryKeyObj());
			}

			if (rsvpDetail != null) {
				session.delete(rsvpDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rsvpDetail != null) {
			clearCache(rsvpDetail);
		}

		return rsvpDetail;
	}

	@Override
	public RsvpDetail updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail)
		throws SystemException {
		rsvpDetail = toUnwrappedModel(rsvpDetail);

		boolean isNew = rsvpDetail.isNew();

		RsvpDetailModelImpl rsvpDetailModelImpl = (RsvpDetailModelImpl)rsvpDetail;

		if (Validator.isNull(rsvpDetail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rsvpDetail.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (rsvpDetail.isNew()) {
				session.save(rsvpDetail);

				rsvpDetail.setNew(false);
			}
			else {
				session.merge(rsvpDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RsvpDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetailModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { rsvpDetailModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetailModelImpl.getOriginalUuid(),
						rsvpDetailModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						rsvpDetailModelImpl.getUuid(),
						rsvpDetailModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetailModelImpl.getOriginalRsvpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID,
					args);

				args = new Object[] { rsvpDetailModelImpl.getRsvpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID,
					args);
			}

			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDRSVPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetailModelImpl.getOriginalRsvpId(),
						rsvpDetailModelImpl.getOriginalEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDRSVPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDRSVPID,
					args);

				args = new Object[] {
						rsvpDetailModelImpl.getRsvpId(),
						rsvpDetailModelImpl.getEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDRSVPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDRSVPID,
					args);
			}

			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDRSVPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetailModelImpl.getOriginalFirstName(),
						rsvpDetailModelImpl.getOriginalRsvpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDRSVPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDRSVPID,
					args);

				args = new Object[] {
						rsvpDetailModelImpl.getFirstName(),
						rsvpDetailModelImpl.getRsvpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDRSVPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDRSVPID,
					args);
			}

			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetailModelImpl.getOriginalEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS,
					args);

				args = new Object[] { rsvpDetailModelImpl.getEmailAddress() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS,
					args);
			}

			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPSTATUSANDRSVPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetailModelImpl.getOriginalRsvpId(),
						rsvpDetailModelImpl.getOriginalRsvpStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPSTATUSANDRSVPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPSTATUSANDRSVPID,
					args);

				args = new Object[] {
						rsvpDetailModelImpl.getRsvpId(),
						rsvpDetailModelImpl.getRsvpStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPSTATUSANDRSVPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPSTATUSANDRSVPID,
					args);
			}

			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDSOURCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetailModelImpl.getOriginalRsvpId(),
						rsvpDetailModelImpl.getOriginalSource()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPIDANDSOURCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDSOURCE,
					args);

				args = new Object[] {
						rsvpDetailModelImpl.getRsvpId(),
						rsvpDetailModelImpl.getSource()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPIDANDSOURCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDSOURCE,
					args);
			}

			if ((rsvpDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDATTENDANCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpDetailModelImpl.getOriginalRsvpId(),
						rsvpDetailModelImpl.getOriginalAttendance()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPIDANDATTENDANCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDATTENDANCE,
					args);

				args = new Object[] {
						rsvpDetailModelImpl.getRsvpId(),
						rsvpDetailModelImpl.getAttendance()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPIDANDATTENDANCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPIDANDATTENDANCE,
					args);
			}
		}

		EntityCacheUtil.putResult(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpDetailImpl.class, rsvpDetail.getPrimaryKey(), rsvpDetail);

		clearUniqueFindersCache(rsvpDetail);
		cacheUniqueFindersCache(rsvpDetail);

		return rsvpDetail;
	}

	protected RsvpDetail toUnwrappedModel(RsvpDetail rsvpDetail) {
		if (rsvpDetail instanceof RsvpDetailImpl) {
			return rsvpDetail;
		}

		RsvpDetailImpl rsvpDetailImpl = new RsvpDetailImpl();

		rsvpDetailImpl.setNew(rsvpDetail.isNew());
		rsvpDetailImpl.setPrimaryKey(rsvpDetail.getPrimaryKey());

		rsvpDetailImpl.setUuid(rsvpDetail.getUuid());
		rsvpDetailImpl.setRsvpDetailId(rsvpDetail.getRsvpDetailId());
		rsvpDetailImpl.setGroupId(rsvpDetail.getGroupId());
		rsvpDetailImpl.setCompanyId(rsvpDetail.getCompanyId());
		rsvpDetailImpl.setUserName(rsvpDetail.getUserName());
		rsvpDetailImpl.setCreateDate(rsvpDetail.getCreateDate());
		rsvpDetailImpl.setModifiedDate(rsvpDetail.getModifiedDate());
		rsvpDetailImpl.setRsvpId(rsvpDetail.getRsvpId());
		rsvpDetailImpl.setUserId(rsvpDetail.getUserId());
		rsvpDetailImpl.setFirstName(rsvpDetail.getFirstName());
		rsvpDetailImpl.setLastName(rsvpDetail.getLastName());
		rsvpDetailImpl.setIdentifiactionType(rsvpDetail.getIdentifiactionType());
		rsvpDetailImpl.setNric(rsvpDetail.getNric());
		rsvpDetailImpl.setEmailAddress(rsvpDetail.getEmailAddress());
		rsvpDetailImpl.setRsvpStatus(rsvpDetail.getRsvpStatus());
		rsvpDetailImpl.setSource(rsvpDetail.getSource());
		rsvpDetailImpl.setAttendance(rsvpDetail.getAttendance());
		rsvpDetailImpl.setAttendanceBy(rsvpDetail.getAttendanceBy());
		rsvpDetailImpl.setAttendanceDate(rsvpDetail.getAttendanceDate());
		rsvpDetailImpl.setRsvpStatusDate(rsvpDetail.getRsvpStatusDate());
		rsvpDetailImpl.setRsvpStatusBy(rsvpDetail.getRsvpStatusBy());
		rsvpDetailImpl.setNumberOfPeople(rsvpDetail.getNumberOfPeople());
		rsvpDetailImpl.setStreetAddress1(rsvpDetail.getStreetAddress1());
		rsvpDetailImpl.setStreetAddress2(rsvpDetail.getStreetAddress2());
		rsvpDetailImpl.setPostalCode(rsvpDetail.getPostalCode());
		rsvpDetailImpl.setCity(rsvpDetail.getCity());
		rsvpDetailImpl.setCountry(rsvpDetail.getCountry());
		rsvpDetailImpl.setState(rsvpDetail.getState());
		rsvpDetailImpl.setGender(rsvpDetail.getGender());
		rsvpDetailImpl.setPhoneNumber1(rsvpDetail.getPhoneNumber1());
		rsvpDetailImpl.setPhoneNumber2(rsvpDetail.getPhoneNumber2());
		rsvpDetailImpl.setHearAboutUs(rsvpDetail.getHearAboutUs());
		rsvpDetailImpl.setAttendedWebinar(rsvpDetail.getAttendedWebinar());
		rsvpDetailImpl.setAgeGroup(rsvpDetail.getAgeGroup());
		rsvpDetailImpl.setTermsOfUse(rsvpDetail.isTermsOfUse());
		rsvpDetailImpl.setAgeRestriction(rsvpDetail.isAgeRestriction());

		return rsvpDetailImpl;
	}

	/**
	 * Returns the rsvp detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp detail
	 * @return the rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRsvpDetailException, SystemException {
		RsvpDetail rsvpDetail = fetchByPrimaryKey(primaryKey);

		if (rsvpDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRsvpDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rsvpDetail;
	}

	/**
	 * Returns the rsvp detail with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException} if it could not be found.
	 *
	 * @param rsvpDetailId the primary key of the rsvp detail
	 * @return the rsvp detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail findByPrimaryKey(long rsvpDetailId)
		throws NoSuchRsvpDetailException, SystemException {
		return findByPrimaryKey((Serializable)rsvpDetailId);
	}

	/**
	 * Returns the rsvp detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp detail
	 * @return the rsvp detail, or <code>null</code> if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RsvpDetail rsvpDetail = (RsvpDetail)EntityCacheUtil.getResult(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
				RsvpDetailImpl.class, primaryKey);

		if (rsvpDetail == _nullRsvpDetail) {
			return null;
		}

		if (rsvpDetail == null) {
			Session session = null;

			try {
				session = openSession();

				rsvpDetail = (RsvpDetail)session.get(RsvpDetailImpl.class,
						primaryKey);

				if (rsvpDetail != null) {
					cacheResult(rsvpDetail);
				}
				else {
					EntityCacheUtil.putResult(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
						RsvpDetailImpl.class, primaryKey, _nullRsvpDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RsvpDetailModelImpl.ENTITY_CACHE_ENABLED,
					RsvpDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rsvpDetail;
	}

	/**
	 * Returns the rsvp detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rsvpDetailId the primary key of the rsvp detail
	 * @return the rsvp detail, or <code>null</code> if a rsvp detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpDetail fetchByPrimaryKey(long rsvpDetailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)rsvpDetailId);
	}

	/**
	 * Returns all the rsvp details.
	 *
	 * @return the rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @return the range of rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp details
	 * @param end the upper bound of the range of rsvp details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rsvp details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpDetail> findAll(int start, int end,
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

		List<RsvpDetail> list = (List<RsvpDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RSVPDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RSVPDETAIL;

				if (pagination) {
					sql = sql.concat(RsvpDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpDetail>(list);
				}
				else {
					list = (List<RsvpDetail>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rsvp details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RsvpDetail rsvpDetail : findAll()) {
			remove(rsvpDetail);
		}
	}

	/**
	 * Returns the number of rsvp details.
	 *
	 * @return the number of rsvp details
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

				Query q = session.createQuery(_SQL_COUNT_RSVPDETAIL);

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
	 * Initializes the rsvp detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.rsvp.model.RsvpDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RsvpDetail>> listenersList = new ArrayList<ModelListener<RsvpDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RsvpDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RsvpDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RSVPDETAIL = "SELECT rsvpDetail FROM RsvpDetail rsvpDetail";
	private static final String _SQL_SELECT_RSVPDETAIL_WHERE = "SELECT rsvpDetail FROM RsvpDetail rsvpDetail WHERE ";
	private static final String _SQL_COUNT_RSVPDETAIL = "SELECT COUNT(rsvpDetail) FROM RsvpDetail rsvpDetail";
	private static final String _SQL_COUNT_RSVPDETAIL_WHERE = "SELECT COUNT(rsvpDetail) FROM RsvpDetail rsvpDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rsvpDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RsvpDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RsvpDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RsvpDetailPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "rsvpDetailId", "rsvpId", "state"
			});
	private static RsvpDetail _nullRsvpDetail = new RsvpDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RsvpDetail> toCacheModel() {
				return _nullRsvpDetailCacheModel;
			}
		};

	private static CacheModel<RsvpDetail> _nullRsvpDetailCacheModel = new CacheModel<RsvpDetail>() {
			@Override
			public RsvpDetail toEntityModel() {
				return _nullRsvpDetail;
			}
		};
}