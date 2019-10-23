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

import com.sambaash.platform.srv.spservices.NoSuchSPLikesException;
import com.sambaash.platform.srv.spservices.model.SPLikes;
import com.sambaash.platform.srv.spservices.model.impl.SPLikesImpl;
import com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p likes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLikesPersistence
 * @see SPLikesUtil
 * @generated
 */
public class SPLikesPersistenceImpl extends BasePersistenceImpl<SPLikes>
	implements SPLikesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPLikesUtil} to access the s p likes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPLikesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPLikesModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p likeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p likeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p likeses
	 * @param end the upper bound of the range of s p likeses (not inclusive)
	 * @return the range of matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p likeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p likeses
	 * @param end the upper bound of the range of s p likeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findByUuid(String uuid, int start, int end,
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

		List<SPLikes> list = (List<SPLikes>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPLikes spLikes : list) {
				if (!Validator.equals(uuid, spLikes.getUuid())) {
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

			query.append(_SQL_SELECT_SPLIKES_WHERE);

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
				query.append(SPLikesModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPLikes>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPLikes>(list);
				}
				else {
					list = (List<SPLikes>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p likes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = fetchByUuid_First(uuid, orderByComparator);

		if (spLikes != null) {
			return spLikes;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPLikesException(msg.toString());
	}

	/**
	 * Returns the first s p likes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPLikes> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p likes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = fetchByUuid_Last(uuid, orderByComparator);

		if (spLikes != null) {
			return spLikes;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPLikesException(msg.toString());
	}

	/**
	 * Returns the last s p likes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPLikes> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p likeses before and after the current s p likes in the ordered set where uuid = &#63;.
	 *
	 * @param spLikesId the primary key of the current s p likes
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes[] findByUuid_PrevAndNext(long spLikesId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = findByPrimaryKey(spLikesId);

		Session session = null;

		try {
			session = openSession();

			SPLikes[] array = new SPLikesImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spLikes, uuid,
					orderByComparator, true);

			array[1] = spLikes;

			array[2] = getByUuid_PrevAndNext(session, spLikes, uuid,
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

	protected SPLikes getByUuid_PrevAndNext(Session session, SPLikes spLikes,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPLIKES_WHERE);

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
			query.append(SPLikesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spLikes);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPLikes> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p likeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPLikes spLikes : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spLikes);
		}
	}

	/**
	 * Returns the number of s p likeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p likeses
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

			query.append(_SQL_COUNT_SPLIKES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spLikes.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spLikes.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spLikes.uuid IS NULL OR spLikes.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPLikesModelImpl.UUID_COLUMN_BITMASK |
			SPLikesModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p likes where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLikesException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByUUID_G(String uuid, long groupId)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = fetchByUUID_G(uuid, groupId);

		if (spLikes == null) {
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

			throw new NoSuchSPLikesException(msg.toString());
		}

		return spLikes;
	}

	/**
	 * Returns the s p likes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p likes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPLikes) {
			SPLikes spLikes = (SPLikes)result;

			if (!Validator.equals(uuid, spLikes.getUuid()) ||
					(groupId != spLikes.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPLIKES_WHERE);

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

				List<SPLikes> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPLikes spLikes = list.get(0);

					result = spLikes;

					cacheResult(spLikes);

					if ((spLikes.getUuid() == null) ||
							!spLikes.getUuid().equals(uuid) ||
							(spLikes.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spLikes);
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
			return (SPLikes)result;
		}
	}

	/**
	 * Removes the s p likes where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p likes that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = findByUUID_G(uuid, groupId);

		return remove(spLikes);
	}

	/**
	 * Returns the number of s p likeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p likeses
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

			query.append(_SQL_COUNT_SPLIKES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spLikes.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spLikes.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spLikes.uuid IS NULL OR spLikes.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spLikes.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPLikesModelImpl.UUID_COLUMN_BITMASK |
			SPLikesModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p likeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p likeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p likeses
	 * @param end the upper bound of the range of s p likeses (not inclusive)
	 * @return the range of matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p likeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p likeses
	 * @param end the upper bound of the range of s p likeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findByUuid_C(String uuid, long companyId, int start,
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

		List<SPLikes> list = (List<SPLikes>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPLikes spLikes : list) {
				if (!Validator.equals(uuid, spLikes.getUuid()) ||
						(companyId != spLikes.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPLIKES_WHERE);

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
				query.append(SPLikesModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPLikes>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPLikes>(list);
				}
				else {
					list = (List<SPLikes>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (spLikes != null) {
			return spLikes;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPLikesException(msg.toString());
	}

	/**
	 * Returns the first s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPLikes> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (spLikes != null) {
			return spLikes;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPLikesException(msg.toString());
	}

	/**
	 * Returns the last s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPLikes> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p likeses before and after the current s p likes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spLikesId the primary key of the current s p likes
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes[] findByUuid_C_PrevAndNext(long spLikesId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = findByPrimaryKey(spLikesId);

		Session session = null;

		try {
			session = openSession();

			SPLikes[] array = new SPLikesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spLikes, uuid,
					companyId, orderByComparator, true);

			array[1] = spLikes;

			array[2] = getByUuid_C_PrevAndNext(session, spLikes, uuid,
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

	protected SPLikes getByUuid_C_PrevAndNext(Session session, SPLikes spLikes,
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

		query.append(_SQL_SELECT_SPLIKES_WHERE);

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
			query.append(SPLikesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spLikes);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPLikes> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p likeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPLikes spLikes : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spLikes);
		}
	}

	/**
	 * Returns the number of s p likeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p likeses
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

			query.append(_SQL_COUNT_SPLIKES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spLikes.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spLikes.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spLikes.uuid IS NULL OR spLikes.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spLikes.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK =
		new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByClassNameAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK =
		new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByClassNameAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			SPLikesModelImpl.COMPANYID_COLUMN_BITMASK |
			SPLikesModelImpl.GROUPID_COLUMN_BITMASK |
			SPLikesModelImpl.CLASSNAME_COLUMN_BITMASK |
			SPLikesModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK = new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findByClassNameAndClassPK(long companyId,
		long groupId, String className, long classPK) throws SystemException {
		return findByClassNameAndClassPK(companyId, groupId, className,
			classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of s p likeses
	 * @param end the upper bound of the range of s p likeses (not inclusive)
	 * @return the range of matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findByClassNameAndClassPK(long companyId,
		long groupId, String className, long classPK, int start, int end)
		throws SystemException {
		return findByClassNameAndClassPK(companyId, groupId, className,
			classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of s p likeses
	 * @param end the upper bound of the range of s p likeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findByClassNameAndClassPK(long companyId,
		long groupId, String className, long classPK, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK;
			finderArgs = new Object[] { companyId, groupId, className, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK;
			finderArgs = new Object[] {
					companyId, groupId, className, classPK,
					
					start, end, orderByComparator
				};
		}

		List<SPLikes> list = (List<SPLikes>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPLikes spLikes : list) {
				if ((companyId != spLikes.getCompanyId()) ||
						(groupId != spLikes.getGroupId()) ||
						!Validator.equals(className, spLikes.getClassName()) ||
						(classPK != spLikes.getClassPK())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_SPLIKES_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_COMPANYID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_GROUPID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPLikesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (!pagination) {
					list = (List<SPLikes>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPLikes>(list);
				}
				else {
					list = (List<SPLikes>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByClassNameAndClassPK_First(long companyId,
		long groupId, String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = fetchByClassNameAndClassPK_First(companyId, groupId,
				className, classPK, orderByComparator);

		if (spLikes != null) {
			return spLikes;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPLikesException(msg.toString());
	}

	/**
	 * Returns the first s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByClassNameAndClassPK_First(long companyId,
		long groupId, String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPLikes> list = findByClassNameAndClassPK(companyId, groupId,
				className, classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByClassNameAndClassPK_Last(long companyId, long groupId,
		String className, long classPK, OrderByComparator orderByComparator)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = fetchByClassNameAndClassPK_Last(companyId, groupId,
				className, classPK, orderByComparator);

		if (spLikes != null) {
			return spLikes;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPLikesException(msg.toString());
	}

	/**
	 * Returns the last s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByClassNameAndClassPK_Last(long companyId,
		long groupId, String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByClassNameAndClassPK(companyId, groupId, className,
				classPK);

		if (count == 0) {
			return null;
		}

		List<SPLikes> list = findByClassNameAndClassPK(companyId, groupId,
				className, classPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p likeses before and after the current s p likes in the ordered set where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param spLikesId the primary key of the current s p likes
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes[] findByClassNameAndClassPK_PrevAndNext(long spLikesId,
		long companyId, long groupId, String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = findByPrimaryKey(spLikesId);

		Session session = null;

		try {
			session = openSession();

			SPLikes[] array = new SPLikesImpl[3];

			array[0] = getByClassNameAndClassPK_PrevAndNext(session, spLikes,
					companyId, groupId, className, classPK, orderByComparator,
					true);

			array[1] = spLikes;

			array[2] = getByClassNameAndClassPK_PrevAndNext(session, spLikes,
					companyId, groupId, className, classPK, orderByComparator,
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

	protected SPLikes getByClassNameAndClassPK_PrevAndNext(Session session,
		SPLikes spLikes, long companyId, long groupId, String className,
		long classPK, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPLIKES_WHERE);

		query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_COMPANYID_2);

		query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_GROUPID_2);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

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
			query.append(SPLikesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spLikes);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPLikes> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassNameAndClassPK(long companyId, long groupId,
		String className, long classPK) throws SystemException {
		for (SPLikes spLikes : findByClassNameAndClassPK(companyId, groupId,
				className, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spLikes);
		}
	}

	/**
	 * Returns the number of s p likeses where companyId = &#63; and groupId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassNameAndClassPK(long companyId, long groupId,
		String className, long classPK) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK;

		Object[] finderArgs = new Object[] {
				companyId, groupId, className, classPK
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SPLIKES_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_COMPANYID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_GROUPID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_COMPANYID_2 = "spLikes.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_GROUPID_2 = "spLikes.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_1 = "spLikes.className IS NULL AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2 = "spLikes.className = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3 = "(spLikes.className IS NULL OR spLikes.className = '') AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2 = "spLikes.classPK = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK =
		new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, SPLikesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserIdWithClassNameAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			SPLikesModelImpl.COMPANYID_COLUMN_BITMASK |
			SPLikesModelImpl.GROUPID_COLUMN_BITMASK |
			SPLikesModelImpl.USERID_COLUMN_BITMASK |
			SPLikesModelImpl.CLASSNAME_COLUMN_BITMASK |
			SPLikesModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDWITHCLASSNAMEANDCLASSPK =
		new FinderPath(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdWithClassNameAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the s p likes where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLikesException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByUserIdWithClassNameAndClassPK(long companyId,
		long groupId, long userId, String className, long classPK)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = fetchByUserIdWithClassNameAndClassPK(companyId,
				groupId, userId, className, classPK);

		if (spLikes == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(", className=");
			msg.append(className);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPLikesException(msg.toString());
		}

		return spLikes;
	}

	/**
	 * Returns the s p likes where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByUserIdWithClassNameAndClassPK(long companyId,
		long groupId, long userId, String className, long classPK)
		throws SystemException {
		return fetchByUserIdWithClassNameAndClassPK(companyId, groupId, userId,
			className, classPK, true);
	}

	/**
	 * Returns the s p likes where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p likes, or <code>null</code> if a matching s p likes could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByUserIdWithClassNameAndClassPK(long companyId,
		long groupId, long userId, String className, long classPK,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, userId, className, classPK
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK,
					finderArgs, this);
		}

		if (result instanceof SPLikes) {
			SPLikes spLikes = (SPLikes)result;

			if ((companyId != spLikes.getCompanyId()) ||
					(groupId != spLikes.getGroupId()) ||
					(userId != spLikes.getUserId()) ||
					!Validator.equals(className, spLikes.getClassName()) ||
					(classPK != spLikes.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_SPLIKES_WHERE);

			query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_GROUPID_2);

			query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_USERID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				List<SPLikes> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK,
						finderArgs, list);
				}
				else {
					SPLikes spLikes = list.get(0);

					result = spLikes;

					cacheResult(spLikes);

					if ((spLikes.getCompanyId() != companyId) ||
							(spLikes.getGroupId() != groupId) ||
							(spLikes.getUserId() != userId) ||
							(spLikes.getClassName() == null) ||
							!spLikes.getClassName().equals(className) ||
							(spLikes.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK,
							finderArgs, spLikes);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK,
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
			return (SPLikes)result;
		}
	}

	/**
	 * Removes the s p likes where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the s p likes that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes removeByUserIdWithClassNameAndClassPK(long companyId,
		long groupId, long userId, String className, long classPK)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = findByUserIdWithClassNameAndClassPK(companyId,
				groupId, userId, className, classPK);

		return remove(spLikes);
	}

	/**
	 * Returns the number of s p likeses where companyId = &#63; and groupId = &#63; and userId = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdWithClassNameAndClassPK(long companyId,
		long groupId, long userId, String className, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDWITHCLASSNAMEANDCLASSPK;

		Object[] finderArgs = new Object[] {
				companyId, groupId, userId, className, classPK
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_SPLIKES_WHERE);

			query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_GROUPID_2);

			query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_USERID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_COMPANYID_2 =
		"spLikes.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_GROUPID_2 =
		"spLikes.groupId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_USERID_2 =
		"spLikes.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSNAME_1 =
		"spLikes.className IS NULL AND ";
	private static final String _FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSNAME_2 =
		"spLikes.className = ? AND ";
	private static final String _FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSNAME_3 =
		"(spLikes.className IS NULL OR spLikes.className = '') AND ";
	private static final String _FINDER_COLUMN_USERIDWITHCLASSNAMEANDCLASSPK_CLASSPK_2 =
		"spLikes.classPK = ?";

	public SPLikesPersistenceImpl() {
		setModelClass(SPLikes.class);
	}

	/**
	 * Caches the s p likes in the entity cache if it is enabled.
	 *
	 * @param spLikes the s p likes
	 */
	@Override
	public void cacheResult(SPLikes spLikes) {
		EntityCacheUtil.putResult(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesImpl.class, spLikes.getPrimaryKey(), spLikes);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spLikes.getUuid(), spLikes.getGroupId() }, spLikes);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK,
			new Object[] {
				spLikes.getCompanyId(), spLikes.getGroupId(),
				spLikes.getUserId(), spLikes.getClassName(),
				spLikes.getClassPK()
			}, spLikes);

		spLikes.resetOriginalValues();
	}

	/**
	 * Caches the s p likeses in the entity cache if it is enabled.
	 *
	 * @param spLikeses the s p likeses
	 */
	@Override
	public void cacheResult(List<SPLikes> spLikeses) {
		for (SPLikes spLikes : spLikeses) {
			if (EntityCacheUtil.getResult(
						SPLikesModelImpl.ENTITY_CACHE_ENABLED,
						SPLikesImpl.class, spLikes.getPrimaryKey()) == null) {
				cacheResult(spLikes);
			}
			else {
				spLikes.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p likeses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPLikesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPLikesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p likes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPLikes spLikes) {
		EntityCacheUtil.removeResult(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesImpl.class, spLikes.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spLikes);
	}

	@Override
	public void clearCache(List<SPLikes> spLikeses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPLikes spLikes : spLikeses) {
			EntityCacheUtil.removeResult(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
				SPLikesImpl.class, spLikes.getPrimaryKey());

			clearUniqueFindersCache(spLikes);
		}
	}

	protected void cacheUniqueFindersCache(SPLikes spLikes) {
		if (spLikes.isNew()) {
			Object[] args = new Object[] { spLikes.getUuid(), spLikes.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, spLikes);

			args = new Object[] {
					spLikes.getCompanyId(), spLikes.getGroupId(),
					spLikes.getUserId(), spLikes.getClassName(),
					spLikes.getClassPK()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDWITHCLASSNAMEANDCLASSPK,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK,
				args, spLikes);
		}
		else {
			SPLikesModelImpl spLikesModelImpl = (SPLikesModelImpl)spLikes;

			if ((spLikesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spLikes.getUuid(), spLikes.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spLikes);
			}

			if ((spLikesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spLikes.getCompanyId(), spLikes.getGroupId(),
						spLikes.getUserId(), spLikes.getClassName(),
						spLikes.getClassPK()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDWITHCLASSNAMEANDCLASSPK,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK,
					args, spLikes);
			}
		}
	}

	protected void clearUniqueFindersCache(SPLikes spLikes) {
		SPLikesModelImpl spLikesModelImpl = (SPLikesModelImpl)spLikes;

		Object[] args = new Object[] { spLikes.getUuid(), spLikes.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spLikesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spLikesModelImpl.getOriginalUuid(),
					spLikesModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				spLikes.getCompanyId(), spLikes.getGroupId(),
				spLikes.getUserId(), spLikes.getClassName(),
				spLikes.getClassPK()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDWITHCLASSNAMEANDCLASSPK,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK,
			args);

		if ((spLikesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK.getColumnBitmask()) != 0) {
			args = new Object[] {
					spLikesModelImpl.getOriginalCompanyId(),
					spLikesModelImpl.getOriginalGroupId(),
					spLikesModelImpl.getOriginalUserId(),
					spLikesModelImpl.getOriginalClassName(),
					spLikesModelImpl.getOriginalClassPK()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDWITHCLASSNAMEANDCLASSPK,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDWITHCLASSNAMEANDCLASSPK,
				args);
		}
	}

	/**
	 * Creates a new s p likes with the primary key. Does not add the s p likes to the database.
	 *
	 * @param spLikesId the primary key for the new s p likes
	 * @return the new s p likes
	 */
	@Override
	public SPLikes create(long spLikesId) {
		SPLikes spLikes = new SPLikesImpl();

		spLikes.setNew(true);
		spLikes.setPrimaryKey(spLikesId);

		String uuid = PortalUUIDUtil.generate();

		spLikes.setUuid(uuid);

		return spLikes;
	}

	/**
	 * Removes the s p likes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spLikesId the primary key of the s p likes
	 * @return the s p likes that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes remove(long spLikesId)
		throws NoSuchSPLikesException, SystemException {
		return remove((Serializable)spLikesId);
	}

	/**
	 * Removes the s p likes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p likes
	 * @return the s p likes that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes remove(Serializable primaryKey)
		throws NoSuchSPLikesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPLikes spLikes = (SPLikes)session.get(SPLikesImpl.class, primaryKey);

			if (spLikes == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPLikesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spLikes);
		}
		catch (NoSuchSPLikesException nsee) {
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
	protected SPLikes removeImpl(SPLikes spLikes) throws SystemException {
		spLikes = toUnwrappedModel(spLikes);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spLikes)) {
				spLikes = (SPLikes)session.get(SPLikesImpl.class,
						spLikes.getPrimaryKeyObj());
			}

			if (spLikes != null) {
				session.delete(spLikes);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spLikes != null) {
			clearCache(spLikes);
		}

		return spLikes;
	}

	@Override
	public SPLikes updateImpl(
		com.sambaash.platform.srv.spservices.model.SPLikes spLikes)
		throws SystemException {
		spLikes = toUnwrappedModel(spLikes);

		boolean isNew = spLikes.isNew();

		SPLikesModelImpl spLikesModelImpl = (SPLikesModelImpl)spLikes;

		if (Validator.isNull(spLikes.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spLikes.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spLikes.isNew()) {
				session.save(spLikes);

				spLikes.setNew(false);
			}
			else {
				session.merge(spLikes);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPLikesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spLikesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spLikesModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spLikesModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spLikesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spLikesModelImpl.getOriginalUuid(),
						spLikesModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spLikesModelImpl.getUuid(),
						spLikesModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spLikesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spLikesModelImpl.getOriginalCompanyId(),
						spLikesModelImpl.getOriginalGroupId(),
						spLikesModelImpl.getOriginalClassName(),
						spLikesModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK,
					args);

				args = new Object[] {
						spLikesModelImpl.getCompanyId(),
						spLikesModelImpl.getGroupId(),
						spLikesModelImpl.getClassName(),
						spLikesModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK,
					args);
			}
		}

		EntityCacheUtil.putResult(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
			SPLikesImpl.class, spLikes.getPrimaryKey(), spLikes);

		clearUniqueFindersCache(spLikes);
		cacheUniqueFindersCache(spLikes);

		return spLikes;
	}

	protected SPLikes toUnwrappedModel(SPLikes spLikes) {
		if (spLikes instanceof SPLikesImpl) {
			return spLikes;
		}

		SPLikesImpl spLikesImpl = new SPLikesImpl();

		spLikesImpl.setNew(spLikes.isNew());
		spLikesImpl.setPrimaryKey(spLikes.getPrimaryKey());

		spLikesImpl.setUuid(spLikes.getUuid());
		spLikesImpl.setSpLikesId(spLikes.getSpLikesId());
		spLikesImpl.setGroupId(spLikes.getGroupId());
		spLikesImpl.setCompanyId(spLikes.getCompanyId());
		spLikesImpl.setUserId(spLikes.getUserId());
		spLikesImpl.setUserName(spLikes.getUserName());
		spLikesImpl.setCreateDate(spLikes.getCreateDate());
		spLikesImpl.setModifiedDate(spLikes.getModifiedDate());
		spLikesImpl.setLayoutSetId(spLikes.getLayoutSetId());
		spLikesImpl.setAction(spLikes.getAction());
		spLikesImpl.setActorUserId(spLikes.getActorUserId());
		spLikesImpl.setClassId(spLikes.getClassId());
		spLikesImpl.setClassName(spLikes.getClassName());
		spLikesImpl.setClassPK(spLikes.getClassPK());

		return spLikesImpl;
	}

	/**
	 * Returns the s p likes with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p likes
	 * @return the s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPLikesException, SystemException {
		SPLikes spLikes = fetchByPrimaryKey(primaryKey);

		if (spLikes == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPLikesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spLikes;
	}

	/**
	 * Returns the s p likes with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLikesException} if it could not be found.
	 *
	 * @param spLikesId the primary key of the s p likes
	 * @return the s p likes
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPLikesException if a s p likes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes findByPrimaryKey(long spLikesId)
		throws NoSuchSPLikesException, SystemException {
		return findByPrimaryKey((Serializable)spLikesId);
	}

	/**
	 * Returns the s p likes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p likes
	 * @return the s p likes, or <code>null</code> if a s p likes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPLikes spLikes = (SPLikes)EntityCacheUtil.getResult(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
				SPLikesImpl.class, primaryKey);

		if (spLikes == _nullSPLikes) {
			return null;
		}

		if (spLikes == null) {
			Session session = null;

			try {
				session = openSession();

				spLikes = (SPLikes)session.get(SPLikesImpl.class, primaryKey);

				if (spLikes != null) {
					cacheResult(spLikes);
				}
				else {
					EntityCacheUtil.putResult(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
						SPLikesImpl.class, primaryKey, _nullSPLikes);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPLikesModelImpl.ENTITY_CACHE_ENABLED,
					SPLikesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spLikes;
	}

	/**
	 * Returns the s p likes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spLikesId the primary key of the s p likes
	 * @return the s p likes, or <code>null</code> if a s p likes with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPLikes fetchByPrimaryKey(long spLikesId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spLikesId);
	}

	/**
	 * Returns all the s p likeses.
	 *
	 * @return the s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p likeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p likeses
	 * @param end the upper bound of the range of s p likeses (not inclusive)
	 * @return the range of s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p likeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLikesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p likeses
	 * @param end the upper bound of the range of s p likeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p likeses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPLikes> findAll(int start, int end,
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

		List<SPLikes> list = (List<SPLikes>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPLIKES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPLIKES;

				if (pagination) {
					sql = sql.concat(SPLikesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPLikes>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPLikes>(list);
				}
				else {
					list = (List<SPLikes>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p likeses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPLikes spLikes : findAll()) {
			remove(spLikes);
		}
	}

	/**
	 * Returns the number of s p likeses.
	 *
	 * @return the number of s p likeses
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

				Query q = session.createQuery(_SQL_COUNT_SPLIKES);

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
	 * Initializes the s p likes persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.SPLikes")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPLikes>> listenersList = new ArrayList<ModelListener<SPLikes>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPLikes>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPLikesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPLIKES = "SELECT spLikes FROM SPLikes spLikes";
	private static final String _SQL_SELECT_SPLIKES_WHERE = "SELECT spLikes FROM SPLikes spLikes WHERE ";
	private static final String _SQL_COUNT_SPLIKES = "SELECT COUNT(spLikes) FROM SPLikes spLikes";
	private static final String _SQL_COUNT_SPLIKES_WHERE = "SELECT COUNT(spLikes) FROM SPLikes spLikes WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spLikes.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPLikes exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPLikes exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPLikesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPLikes _nullSPLikes = new SPLikesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPLikes> toCacheModel() {
				return _nullSPLikesCacheModel;
			}
		};

	private static CacheModel<SPLikes> _nullSPLikesCacheModel = new CacheModel<SPLikes>() {
			@Override
			public SPLikes toEntityModel() {
				return _nullSPLikes;
			}
		};
}