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

import com.sambaash.platform.srv.sprating.NoSuchRatingAttrException;
import com.sambaash.platform.srv.sprating.model.RatingAttr;
import com.sambaash.platform.srv.sprating.model.impl.RatingAttrImpl;
import com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rating attr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see RatingAttrPersistence
 * @see RatingAttrUtil
 * @generated
 */
public class RatingAttrPersistenceImpl extends BasePersistenceImpl<RatingAttr>
	implements RatingAttrPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RatingAttrUtil} to access the rating attr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RatingAttrImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RatingAttrModelImpl.UUID_COLUMN_BITMASK |
			RatingAttrModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rating attrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating attrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @return the range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating attrs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByUuid(String uuid, int start, int end,
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

		List<RatingAttr> list = (List<RatingAttr>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RatingAttr ratingAttr : list) {
				if (!Validator.equals(uuid, ratingAttr.getUuid())) {
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

			query.append(_SQL_SELECT_RATINGATTR_WHERE);

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
				query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
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
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingAttr>(list);
				}
				else {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating attr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByUuid_First(uuid, orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the first rating attr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RatingAttr> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rating attr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByUuid_Last(uuid, orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the last rating attr in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RatingAttr> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rating attrs before and after the current rating attr in the ordered set where uuid = &#63;.
	 *
	 * @param spRatingAttrId the primary key of the current rating attr
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr[] findByUuid_PrevAndNext(long spRatingAttrId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = findByPrimaryKey(spRatingAttrId);

		Session session = null;

		try {
			session = openSession();

			RatingAttr[] array = new RatingAttrImpl[3];

			array[0] = getByUuid_PrevAndNext(session, ratingAttr, uuid,
					orderByComparator, true);

			array[1] = ratingAttr;

			array[2] = getByUuid_PrevAndNext(session, ratingAttr, uuid,
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

	protected RatingAttr getByUuid_PrevAndNext(Session session,
		RatingAttr ratingAttr, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGATTR_WHERE);

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
			query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ratingAttr);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingAttr> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rating attrs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RatingAttr ratingAttr : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ratingAttr);
		}
	}

	/**
	 * Returns the number of rating attrs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rating attrs
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

			query.append(_SQL_COUNT_RATINGATTR_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "ratingAttr.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ratingAttr.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(ratingAttr.uuid IS NULL OR ratingAttr.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RatingAttrModelImpl.UUID_COLUMN_BITMASK |
			RatingAttrModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rating attr where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.sprating.NoSuchRatingAttrException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByUUID_G(String uuid, long groupId)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByUUID_G(uuid, groupId);

		if (ratingAttr == null) {
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

			throw new NoSuchRatingAttrException(msg.toString());
		}

		return ratingAttr;
	}

	/**
	 * Returns the rating attr where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rating attr where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RatingAttr) {
			RatingAttr ratingAttr = (RatingAttr)result;

			if (!Validator.equals(uuid, ratingAttr.getUuid()) ||
					(groupId != ratingAttr.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RATINGATTR_WHERE);

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

				List<RatingAttr> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RatingAttr ratingAttr = list.get(0);

					result = ratingAttr;

					cacheResult(ratingAttr);

					if ((ratingAttr.getUuid() == null) ||
							!ratingAttr.getUuid().equals(uuid) ||
							(ratingAttr.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, ratingAttr);
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
			return (RatingAttr)result;
		}
	}

	/**
	 * Removes the rating attr where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rating attr that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr removeByUUID_G(String uuid, long groupId)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = findByUUID_G(uuid, groupId);

		return remove(ratingAttr);
	}

	/**
	 * Returns the number of rating attrs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rating attrs
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

			query.append(_SQL_COUNT_RATINGATTR_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "ratingAttr.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "ratingAttr.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(ratingAttr.uuid IS NULL OR ratingAttr.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "ratingAttr.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RatingAttrModelImpl.UUID_COLUMN_BITMASK |
			RatingAttrModelImpl.COMPANYID_COLUMN_BITMASK |
			RatingAttrModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rating attrs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating attrs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @return the range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating attrs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByUuid_C(String uuid, long companyId,
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

		List<RatingAttr> list = (List<RatingAttr>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RatingAttr ratingAttr : list) {
				if (!Validator.equals(uuid, ratingAttr.getUuid()) ||
						(companyId != ratingAttr.getCompanyId())) {
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

			query.append(_SQL_SELECT_RATINGATTR_WHERE);

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
				query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
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
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingAttr>(list);
				}
				else {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the first rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RatingAttr> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the last rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RatingAttr> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rating attrs before and after the current rating attr in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spRatingAttrId the primary key of the current rating attr
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr[] findByUuid_C_PrevAndNext(long spRatingAttrId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = findByPrimaryKey(spRatingAttrId);

		Session session = null;

		try {
			session = openSession();

			RatingAttr[] array = new RatingAttrImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, ratingAttr, uuid,
					companyId, orderByComparator, true);

			array[1] = ratingAttr;

			array[2] = getByUuid_C_PrevAndNext(session, ratingAttr, uuid,
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

	protected RatingAttr getByUuid_C_PrevAndNext(Session session,
		RatingAttr ratingAttr, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGATTR_WHERE);

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
			query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ratingAttr);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingAttr> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rating attrs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (RatingAttr ratingAttr : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ratingAttr);
		}
	}

	/**
	 * Returns the number of rating attrs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rating attrs
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

			query.append(_SQL_COUNT_RATINGATTR_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "ratingAttr.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "ratingAttr.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(ratingAttr.uuid IS NULL OR ratingAttr.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "ratingAttr.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGCOMPONENTID_GETVISIBLEONLY =
		new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRatingComponentId_GetVisibleOnly",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID_GETVISIBLEONLY =
		new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRatingComponentId_GetVisibleOnly",
			new String[] { Long.class.getName() },
			RatingAttrModelImpl.RATINGCOMPONENTID_COLUMN_BITMASK |
			RatingAttrModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RATINGCOMPONENTID_GETVISIBLEONLY =
		new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRatingComponentId_GetVisibleOnly",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rating attrs where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @return the matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByRatingComponentId_GetVisibleOnly(
		long ratingComponentId) throws SystemException {
		return findByRatingComponentId_GetVisibleOnly(ratingComponentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating attrs where ratingComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratingComponentId the rating component ID
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @return the range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByRatingComponentId_GetVisibleOnly(
		long ratingComponentId, int start, int end) throws SystemException {
		return findByRatingComponentId_GetVisibleOnly(ratingComponentId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the rating attrs where ratingComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratingComponentId the rating component ID
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByRatingComponentId_GetVisibleOnly(
		long ratingComponentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID_GETVISIBLEONLY;
			finderArgs = new Object[] { ratingComponentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGCOMPONENTID_GETVISIBLEONLY;
			finderArgs = new Object[] {
					ratingComponentId,
					
					start, end, orderByComparator
				};
		}

		List<RatingAttr> list = (List<RatingAttr>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RatingAttr ratingAttr : list) {
				if ((ratingComponentId != ratingAttr.getRatingComponentId())) {
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

			query.append(_SQL_SELECT_RATINGATTR_WHERE);

			query.append(_FINDER_COLUMN_RATINGCOMPONENTID_GETVISIBLEONLY_RATINGCOMPONENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ratingComponentId);

				if (!pagination) {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingAttr>(list);
				}
				else {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByRatingComponentId_GetVisibleOnly_First(
		long ratingComponentId, OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByRatingComponentId_GetVisibleOnly_First(ratingComponentId,
				orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ratingComponentId=");
		msg.append(ratingComponentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the first rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByRatingComponentId_GetVisibleOnly_First(
		long ratingComponentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<RatingAttr> list = findByRatingComponentId_GetVisibleOnly(ratingComponentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByRatingComponentId_GetVisibleOnly_Last(
		long ratingComponentId, OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByRatingComponentId_GetVisibleOnly_Last(ratingComponentId,
				orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ratingComponentId=");
		msg.append(ratingComponentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the last rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByRatingComponentId_GetVisibleOnly_Last(
		long ratingComponentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRatingComponentId_GetVisibleOnly(ratingComponentId);

		if (count == 0) {
			return null;
		}

		List<RatingAttr> list = findByRatingComponentId_GetVisibleOnly(ratingComponentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rating attrs before and after the current rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param spRatingAttrId the primary key of the current rating attr
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr[] findByRatingComponentId_GetVisibleOnly_PrevAndNext(
		long spRatingAttrId, long ratingComponentId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = findByPrimaryKey(spRatingAttrId);

		Session session = null;

		try {
			session = openSession();

			RatingAttr[] array = new RatingAttrImpl[3];

			array[0] = getByRatingComponentId_GetVisibleOnly_PrevAndNext(session,
					ratingAttr, ratingComponentId, orderByComparator, true);

			array[1] = ratingAttr;

			array[2] = getByRatingComponentId_GetVisibleOnly_PrevAndNext(session,
					ratingAttr, ratingComponentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RatingAttr getByRatingComponentId_GetVisibleOnly_PrevAndNext(
		Session session, RatingAttr ratingAttr, long ratingComponentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGATTR_WHERE);

		query.append(_FINDER_COLUMN_RATINGCOMPONENTID_GETVISIBLEONLY_RATINGCOMPONENTID_2);

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
			query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ratingComponentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ratingAttr);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingAttr> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rating attrs where ratingComponentId = &#63; from the database.
	 *
	 * @param ratingComponentId the rating component ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRatingComponentId_GetVisibleOnly(long ratingComponentId)
		throws SystemException {
		for (RatingAttr ratingAttr : findByRatingComponentId_GetVisibleOnly(
				ratingComponentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ratingAttr);
		}
	}

	/**
	 * Returns the number of rating attrs where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @return the number of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRatingComponentId_GetVisibleOnly(long ratingComponentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RATINGCOMPONENTID_GETVISIBLEONLY;

		Object[] finderArgs = new Object[] { ratingComponentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RATINGATTR_WHERE);

			query.append(_FINDER_COLUMN_RATINGCOMPONENTID_GETVISIBLEONLY_RATINGCOMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ratingComponentId);

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

	private static final String _FINDER_COLUMN_RATINGCOMPONENTID_GETVISIBLEONLY_RATINGCOMPONENTID_2 =
		"ratingAttr.ratingComponentId = ? AND ratingAttr.visible=1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGCOMPONENTID =
		new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByratingComponentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID =
		new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByratingComponentId", new String[] { Long.class.getName() },
			RatingAttrModelImpl.RATINGCOMPONENTID_COLUMN_BITMASK |
			RatingAttrModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RATINGCOMPONENTID = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByratingComponentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the rating attrs where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @return the matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByratingComponentId(long ratingComponentId)
		throws SystemException {
		return findByratingComponentId(ratingComponentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating attrs where ratingComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratingComponentId the rating component ID
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @return the range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByratingComponentId(long ratingComponentId,
		int start, int end) throws SystemException {
		return findByratingComponentId(ratingComponentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating attrs where ratingComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratingComponentId the rating component ID
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByratingComponentId(long ratingComponentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID;
			finderArgs = new Object[] { ratingComponentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGCOMPONENTID;
			finderArgs = new Object[] {
					ratingComponentId,
					
					start, end, orderByComparator
				};
		}

		List<RatingAttr> list = (List<RatingAttr>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RatingAttr ratingAttr : list) {
				if ((ratingComponentId != ratingAttr.getRatingComponentId())) {
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

			query.append(_SQL_SELECT_RATINGATTR_WHERE);

			query.append(_FINDER_COLUMN_RATINGCOMPONENTID_RATINGCOMPONENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ratingComponentId);

				if (!pagination) {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingAttr>(list);
				}
				else {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByratingComponentId_First(long ratingComponentId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByratingComponentId_First(ratingComponentId,
				orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ratingComponentId=");
		msg.append(ratingComponentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the first rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByratingComponentId_First(long ratingComponentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RatingAttr> list = findByratingComponentId(ratingComponentId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByratingComponentId_Last(long ratingComponentId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByratingComponentId_Last(ratingComponentId,
				orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ratingComponentId=");
		msg.append(ratingComponentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the last rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByratingComponentId_Last(long ratingComponentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByratingComponentId(ratingComponentId);

		if (count == 0) {
			return null;
		}

		List<RatingAttr> list = findByratingComponentId(ratingComponentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rating attrs before and after the current rating attr in the ordered set where ratingComponentId = &#63;.
	 *
	 * @param spRatingAttrId the primary key of the current rating attr
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr[] findByratingComponentId_PrevAndNext(
		long spRatingAttrId, long ratingComponentId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = findByPrimaryKey(spRatingAttrId);

		Session session = null;

		try {
			session = openSession();

			RatingAttr[] array = new RatingAttrImpl[3];

			array[0] = getByratingComponentId_PrevAndNext(session, ratingAttr,
					ratingComponentId, orderByComparator, true);

			array[1] = ratingAttr;

			array[2] = getByratingComponentId_PrevAndNext(session, ratingAttr,
					ratingComponentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RatingAttr getByratingComponentId_PrevAndNext(Session session,
		RatingAttr ratingAttr, long ratingComponentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGATTR_WHERE);

		query.append(_FINDER_COLUMN_RATINGCOMPONENTID_RATINGCOMPONENTID_2);

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
			query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ratingComponentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ratingAttr);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingAttr> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rating attrs where ratingComponentId = &#63; from the database.
	 *
	 * @param ratingComponentId the rating component ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByratingComponentId(long ratingComponentId)
		throws SystemException {
		for (RatingAttr ratingAttr : findByratingComponentId(
				ratingComponentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ratingAttr);
		}
	}

	/**
	 * Returns the number of rating attrs where ratingComponentId = &#63;.
	 *
	 * @param ratingComponentId the rating component ID
	 * @return the number of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByratingComponentId(long ratingComponentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RATINGCOMPONENTID;

		Object[] finderArgs = new Object[] { ratingComponentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RATINGATTR_WHERE);

			query.append(_FINDER_COLUMN_RATINGCOMPONENTID_RATINGCOMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ratingComponentId);

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

	private static final String _FINDER_COLUMN_RATINGCOMPONENTID_RATINGCOMPONENTID_2 =
		"ratingAttr.ratingComponentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMERATINGCOMPONENTID =
		new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNameRatingComponentId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMERATINGCOMPONENTID =
		new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, RatingAttrImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNameRatingComponentId",
			new String[] { String.class.getName(), Long.class.getName() },
			RatingAttrModelImpl.NAME_COLUMN_BITMASK |
			RatingAttrModelImpl.RATINGCOMPONENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMERATINGCOMPONENTID = new FinderPath(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNameRatingComponentId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rating attrs where name = &#63; and ratingComponentId = &#63;.
	 *
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @return the matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByNameRatingComponentId(String name,
		long ratingComponentId) throws SystemException {
		return findByNameRatingComponentId(name, ratingComponentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating attrs where name = &#63; and ratingComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @return the range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByNameRatingComponentId(String name,
		long ratingComponentId, int start, int end) throws SystemException {
		return findByNameRatingComponentId(name, ratingComponentId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the rating attrs where name = &#63; and ratingComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findByNameRatingComponentId(String name,
		long ratingComponentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMERATINGCOMPONENTID;
			finderArgs = new Object[] { name, ratingComponentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMERATINGCOMPONENTID;
			finderArgs = new Object[] {
					name, ratingComponentId,
					
					start, end, orderByComparator
				};
		}

		List<RatingAttr> list = (List<RatingAttr>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RatingAttr ratingAttr : list) {
				if (!Validator.equals(name, ratingAttr.getName()) ||
						(ratingComponentId != ratingAttr.getRatingComponentId())) {
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

			query.append(_SQL_SELECT_RATINGATTR_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_RATINGCOMPONENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(ratingComponentId);

				if (!pagination) {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingAttr>(list);
				}
				else {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	 *
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByNameRatingComponentId_First(String name,
		long ratingComponentId, OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByNameRatingComponentId_First(name,
				ratingComponentId, orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", ratingComponentId=");
		msg.append(ratingComponentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the first rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	 *
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByNameRatingComponentId_First(String name,
		long ratingComponentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<RatingAttr> list = findByNameRatingComponentId(name,
				ratingComponentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	 *
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByNameRatingComponentId_Last(String name,
		long ratingComponentId, OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByNameRatingComponentId_Last(name,
				ratingComponentId, orderByComparator);

		if (ratingAttr != null) {
			return ratingAttr;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", ratingComponentId=");
		msg.append(ratingComponentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingAttrException(msg.toString());
	}

	/**
	 * Returns the last rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	 *
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating attr, or <code>null</code> if a matching rating attr could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByNameRatingComponentId_Last(String name,
		long ratingComponentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNameRatingComponentId(name, ratingComponentId);

		if (count == 0) {
			return null;
		}

		List<RatingAttr> list = findByNameRatingComponentId(name,
				ratingComponentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rating attrs before and after the current rating attr in the ordered set where name = &#63; and ratingComponentId = &#63;.
	 *
	 * @param spRatingAttrId the primary key of the current rating attr
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr[] findByNameRatingComponentId_PrevAndNext(
		long spRatingAttrId, String name, long ratingComponentId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = findByPrimaryKey(spRatingAttrId);

		Session session = null;

		try {
			session = openSession();

			RatingAttr[] array = new RatingAttrImpl[3];

			array[0] = getByNameRatingComponentId_PrevAndNext(session,
					ratingAttr, name, ratingComponentId, orderByComparator, true);

			array[1] = ratingAttr;

			array[2] = getByNameRatingComponentId_PrevAndNext(session,
					ratingAttr, name, ratingComponentId, orderByComparator,
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

	protected RatingAttr getByNameRatingComponentId_PrevAndNext(
		Session session, RatingAttr ratingAttr, String name,
		long ratingComponentId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGATTR_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_2);
		}

		query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_RATINGCOMPONENTID_2);

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
			query.append(RatingAttrModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		qPos.add(ratingComponentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ratingAttr);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingAttr> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rating attrs where name = &#63; and ratingComponentId = &#63; from the database.
	 *
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNameRatingComponentId(String name,
		long ratingComponentId) throws SystemException {
		for (RatingAttr ratingAttr : findByNameRatingComponentId(name,
				ratingComponentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ratingAttr);
		}
	}

	/**
	 * Returns the number of rating attrs where name = &#63; and ratingComponentId = &#63;.
	 *
	 * @param name the name
	 * @param ratingComponentId the rating component ID
	 * @return the number of matching rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameRatingComponentId(String name, long ratingComponentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMERATINGCOMPONENTID;

		Object[] finderArgs = new Object[] { name, ratingComponentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RATINGATTR_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMERATINGCOMPONENTID_RATINGCOMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(ratingComponentId);

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

	private static final String _FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_1 = "ratingAttr.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_2 = "ratingAttr.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMERATINGCOMPONENTID_NAME_3 = "(ratingAttr.name IS NULL OR ratingAttr.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMERATINGCOMPONENTID_RATINGCOMPONENTID_2 =
		"ratingAttr.ratingComponentId = ?";

	public RatingAttrPersistenceImpl() {
		setModelClass(RatingAttr.class);
	}

	/**
	 * Caches the rating attr in the entity cache if it is enabled.
	 *
	 * @param ratingAttr the rating attr
	 */
	@Override
	public void cacheResult(RatingAttr ratingAttr) {
		EntityCacheUtil.putResult(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrImpl.class, ratingAttr.getPrimaryKey(), ratingAttr);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { ratingAttr.getUuid(), ratingAttr.getGroupId() },
			ratingAttr);

		ratingAttr.resetOriginalValues();
	}

	/**
	 * Caches the rating attrs in the entity cache if it is enabled.
	 *
	 * @param ratingAttrs the rating attrs
	 */
	@Override
	public void cacheResult(List<RatingAttr> ratingAttrs) {
		for (RatingAttr ratingAttr : ratingAttrs) {
			if (EntityCacheUtil.getResult(
						RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
						RatingAttrImpl.class, ratingAttr.getPrimaryKey()) == null) {
				cacheResult(ratingAttr);
			}
			else {
				ratingAttr.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rating attrs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RatingAttrImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RatingAttrImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rating attr.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RatingAttr ratingAttr) {
		EntityCacheUtil.removeResult(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrImpl.class, ratingAttr.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ratingAttr);
	}

	@Override
	public void clearCache(List<RatingAttr> ratingAttrs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RatingAttr ratingAttr : ratingAttrs) {
			EntityCacheUtil.removeResult(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
				RatingAttrImpl.class, ratingAttr.getPrimaryKey());

			clearUniqueFindersCache(ratingAttr);
		}
	}

	protected void cacheUniqueFindersCache(RatingAttr ratingAttr) {
		if (ratingAttr.isNew()) {
			Object[] args = new Object[] {
					ratingAttr.getUuid(), ratingAttr.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				ratingAttr);
		}
		else {
			RatingAttrModelImpl ratingAttrModelImpl = (RatingAttrModelImpl)ratingAttr;

			if ((ratingAttrModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingAttr.getUuid(), ratingAttr.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					ratingAttr);
			}
		}
	}

	protected void clearUniqueFindersCache(RatingAttr ratingAttr) {
		RatingAttrModelImpl ratingAttrModelImpl = (RatingAttrModelImpl)ratingAttr;

		Object[] args = new Object[] {
				ratingAttr.getUuid(), ratingAttr.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((ratingAttrModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					ratingAttrModelImpl.getOriginalUuid(),
					ratingAttrModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new rating attr with the primary key. Does not add the rating attr to the database.
	 *
	 * @param spRatingAttrId the primary key for the new rating attr
	 * @return the new rating attr
	 */
	@Override
	public RatingAttr create(long spRatingAttrId) {
		RatingAttr ratingAttr = new RatingAttrImpl();

		ratingAttr.setNew(true);
		ratingAttr.setPrimaryKey(spRatingAttrId);

		String uuid = PortalUUIDUtil.generate();

		ratingAttr.setUuid(uuid);

		return ratingAttr;
	}

	/**
	 * Removes the rating attr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spRatingAttrId the primary key of the rating attr
	 * @return the rating attr that was removed
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr remove(long spRatingAttrId)
		throws NoSuchRatingAttrException, SystemException {
		return remove((Serializable)spRatingAttrId);
	}

	/**
	 * Removes the rating attr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rating attr
	 * @return the rating attr that was removed
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr remove(Serializable primaryKey)
		throws NoSuchRatingAttrException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RatingAttr ratingAttr = (RatingAttr)session.get(RatingAttrImpl.class,
					primaryKey);

			if (ratingAttr == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRatingAttrException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ratingAttr);
		}
		catch (NoSuchRatingAttrException nsee) {
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
	protected RatingAttr removeImpl(RatingAttr ratingAttr)
		throws SystemException {
		ratingAttr = toUnwrappedModel(ratingAttr);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ratingAttr)) {
				ratingAttr = (RatingAttr)session.get(RatingAttrImpl.class,
						ratingAttr.getPrimaryKeyObj());
			}

			if (ratingAttr != null) {
				session.delete(ratingAttr);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ratingAttr != null) {
			clearCache(ratingAttr);
		}

		return ratingAttr;
	}

	@Override
	public RatingAttr updateImpl(
		com.sambaash.platform.srv.sprating.model.RatingAttr ratingAttr)
		throws SystemException {
		ratingAttr = toUnwrappedModel(ratingAttr);

		boolean isNew = ratingAttr.isNew();

		RatingAttrModelImpl ratingAttrModelImpl = (RatingAttrModelImpl)ratingAttr;

		if (Validator.isNull(ratingAttr.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ratingAttr.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (ratingAttr.isNew()) {
				session.save(ratingAttr);

				ratingAttr.setNew(false);
			}
			else {
				session.merge(ratingAttr);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RatingAttrModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ratingAttrModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingAttrModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { ratingAttrModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((ratingAttrModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingAttrModelImpl.getOriginalUuid(),
						ratingAttrModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						ratingAttrModelImpl.getUuid(),
						ratingAttrModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((ratingAttrModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID_GETVISIBLEONLY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingAttrModelImpl.getOriginalRatingComponentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGCOMPONENTID_GETVISIBLEONLY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID_GETVISIBLEONLY,
					args);

				args = new Object[] { ratingAttrModelImpl.getRatingComponentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGCOMPONENTID_GETVISIBLEONLY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID_GETVISIBLEONLY,
					args);
			}

			if ((ratingAttrModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingAttrModelImpl.getOriginalRatingComponentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGCOMPONENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID,
					args);

				args = new Object[] { ratingAttrModelImpl.getRatingComponentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGCOMPONENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCOMPONENTID,
					args);
			}

			if ((ratingAttrModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMERATINGCOMPONENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingAttrModelImpl.getOriginalName(),
						ratingAttrModelImpl.getOriginalRatingComponentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMERATINGCOMPONENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMERATINGCOMPONENTID,
					args);

				args = new Object[] {
						ratingAttrModelImpl.getName(),
						ratingAttrModelImpl.getRatingComponentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMERATINGCOMPONENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMERATINGCOMPONENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
			RatingAttrImpl.class, ratingAttr.getPrimaryKey(), ratingAttr);

		clearUniqueFindersCache(ratingAttr);
		cacheUniqueFindersCache(ratingAttr);

		return ratingAttr;
	}

	protected RatingAttr toUnwrappedModel(RatingAttr ratingAttr) {
		if (ratingAttr instanceof RatingAttrImpl) {
			return ratingAttr;
		}

		RatingAttrImpl ratingAttrImpl = new RatingAttrImpl();

		ratingAttrImpl.setNew(ratingAttr.isNew());
		ratingAttrImpl.setPrimaryKey(ratingAttr.getPrimaryKey());

		ratingAttrImpl.setUuid(ratingAttr.getUuid());
		ratingAttrImpl.setSpRatingAttrId(ratingAttr.getSpRatingAttrId());
		ratingAttrImpl.setGroupId(ratingAttr.getGroupId());
		ratingAttrImpl.setCompanyId(ratingAttr.getCompanyId());
		ratingAttrImpl.setUserId(ratingAttr.getUserId());
		ratingAttrImpl.setUserName(ratingAttr.getUserName());
		ratingAttrImpl.setCreateDate(ratingAttr.getCreateDate());
		ratingAttrImpl.setModifiedDate(ratingAttr.getModifiedDate());
		ratingAttrImpl.setRatingComponentId(ratingAttr.getRatingComponentId());
		ratingAttrImpl.setName(ratingAttr.getName());
		ratingAttrImpl.setWeight(ratingAttr.getWeight());
		ratingAttrImpl.setVisible(ratingAttr.isVisible());

		return ratingAttrImpl;
	}

	/**
	 * Returns the rating attr with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rating attr
	 * @return the rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRatingAttrException, SystemException {
		RatingAttr ratingAttr = fetchByPrimaryKey(primaryKey);

		if (ratingAttr == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRatingAttrException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ratingAttr;
	}

	/**
	 * Returns the rating attr with the primary key or throws a {@link com.sambaash.platform.srv.sprating.NoSuchRatingAttrException} if it could not be found.
	 *
	 * @param spRatingAttrId the primary key of the rating attr
	 * @return the rating attr
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingAttrException if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr findByPrimaryKey(long spRatingAttrId)
		throws NoSuchRatingAttrException, SystemException {
		return findByPrimaryKey((Serializable)spRatingAttrId);
	}

	/**
	 * Returns the rating attr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rating attr
	 * @return the rating attr, or <code>null</code> if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RatingAttr ratingAttr = (RatingAttr)EntityCacheUtil.getResult(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
				RatingAttrImpl.class, primaryKey);

		if (ratingAttr == _nullRatingAttr) {
			return null;
		}

		if (ratingAttr == null) {
			Session session = null;

			try {
				session = openSession();

				ratingAttr = (RatingAttr)session.get(RatingAttrImpl.class,
						primaryKey);

				if (ratingAttr != null) {
					cacheResult(ratingAttr);
				}
				else {
					EntityCacheUtil.putResult(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
						RatingAttrImpl.class, primaryKey, _nullRatingAttr);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RatingAttrModelImpl.ENTITY_CACHE_ENABLED,
					RatingAttrImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ratingAttr;
	}

	/**
	 * Returns the rating attr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spRatingAttrId the primary key of the rating attr
	 * @return the rating attr, or <code>null</code> if a rating attr with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingAttr fetchByPrimaryKey(long spRatingAttrId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spRatingAttrId);
	}

	/**
	 * Returns all the rating attrs.
	 *
	 * @return the rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating attrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @return the range of rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating attrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingAttrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating attrs
	 * @param end the upper bound of the range of rating attrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rating attrs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingAttr> findAll(int start, int end,
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

		List<RatingAttr> list = (List<RatingAttr>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RATINGATTR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RATINGATTR;

				if (pagination) {
					sql = sql.concat(RatingAttrModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingAttr>(list);
				}
				else {
					list = (List<RatingAttr>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rating attrs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RatingAttr ratingAttr : findAll()) {
			remove(ratingAttr);
		}
	}

	/**
	 * Returns the number of rating attrs.
	 *
	 * @return the number of rating attrs
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

				Query q = session.createQuery(_SQL_COUNT_RATINGATTR);

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
	 * Initializes the rating attr persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.sprating.model.RatingAttr")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RatingAttr>> listenersList = new ArrayList<ModelListener<RatingAttr>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RatingAttr>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RatingAttrImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RATINGATTR = "SELECT ratingAttr FROM RatingAttr ratingAttr";
	private static final String _SQL_SELECT_RATINGATTR_WHERE = "SELECT ratingAttr FROM RatingAttr ratingAttr WHERE ";
	private static final String _SQL_COUNT_RATINGATTR = "SELECT COUNT(ratingAttr) FROM RatingAttr ratingAttr";
	private static final String _SQL_COUNT_RATINGATTR_WHERE = "SELECT COUNT(ratingAttr) FROM RatingAttr ratingAttr WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ratingAttr.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RatingAttr exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RatingAttr exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RatingAttrPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static RatingAttr _nullRatingAttr = new RatingAttrImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RatingAttr> toCacheModel() {
				return _nullRatingAttrCacheModel;
			}
		};

	private static CacheModel<RatingAttr> _nullRatingAttrCacheModel = new CacheModel<RatingAttr>() {
			@Override
			public RatingAttr toEntityModel() {
				return _nullRatingAttr;
			}
		};
}