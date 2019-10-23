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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;
import com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailImpl;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rsvp co participant detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpCoParticipantDetailPersistence
 * @see RsvpCoParticipantDetailUtil
 * @generated
 */
public class RsvpCoParticipantDetailPersistenceImpl extends BasePersistenceImpl<RsvpCoParticipantDetail>
	implements RsvpCoParticipantDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RsvpCoParticipantDetailUtil} to access the rsvp co participant detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RsvpCoParticipantDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RsvpCoParticipantDetailModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rsvp co participant details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp co participant details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @return the range of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp co participant details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<RsvpCoParticipantDetail> list = (List<RsvpCoParticipantDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpCoParticipantDetail rsvpCoParticipantDetail : list) {
				if (!Validator.equals(uuid, rsvpCoParticipantDetail.getUuid())) {
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

			query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

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
				query.append(RsvpCoParticipantDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpCoParticipantDetail>(list);
				}
				else {
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
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
	 * Returns the first rsvp co participant detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByUuid_First(uuid,
				orderByComparator);

		if (rsvpCoParticipantDetail != null) {
			return rsvpCoParticipantDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp co participant detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpCoParticipantDetail> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp co participant detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByUuid_Last(uuid,
				orderByComparator);

		if (rsvpCoParticipantDetail != null) {
			return rsvpCoParticipantDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp co participant detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RsvpCoParticipantDetail> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp co participant details before and after the current rsvp co participant detail in the ordered set where uuid = &#63;.
	 *
	 * @param rsvpCoParticipantDetailId the primary key of the current rsvp co participant detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail[] findByUuid_PrevAndNext(
		long rsvpCoParticipantDetailId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = findByPrimaryKey(rsvpCoParticipantDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpCoParticipantDetail[] array = new RsvpCoParticipantDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(session, rsvpCoParticipantDetail,
					uuid, orderByComparator, true);

			array[1] = rsvpCoParticipantDetail;

			array[2] = getByUuid_PrevAndNext(session, rsvpCoParticipantDetail,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RsvpCoParticipantDetail getByUuid_PrevAndNext(Session session,
		RsvpCoParticipantDetail rsvpCoParticipantDetail, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

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
			query.append(RsvpCoParticipantDetailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpCoParticipantDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpCoParticipantDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp co participant details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RsvpCoParticipantDetail rsvpCoParticipantDetail : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpCoParticipantDetail);
		}
	}

	/**
	 * Returns the number of rsvp co participant details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rsvp co participant details
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

			query.append(_SQL_COUNT_RSVPCOPARTICIPANTDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "rsvpCoParticipantDetail.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "rsvpCoParticipantDetail.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(rsvpCoParticipantDetail.uuid IS NULL OR rsvpCoParticipantDetail.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpCoParticipantDetailModelImpl.UUID_COLUMN_BITMASK |
			RsvpCoParticipantDetailModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rsvp co participant detail where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByUUID_G(uuid,
				groupId);

		if (rsvpCoParticipantDetail == null) {
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

			throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
		}

		return rsvpCoParticipantDetail;
	}

	/**
	 * Returns the rsvp co participant detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rsvp co participant detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RsvpCoParticipantDetail) {
			RsvpCoParticipantDetail rsvpCoParticipantDetail = (RsvpCoParticipantDetail)result;

			if (!Validator.equals(uuid, rsvpCoParticipantDetail.getUuid()) ||
					(groupId != rsvpCoParticipantDetail.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

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

				List<RsvpCoParticipantDetail> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RsvpCoParticipantDetail rsvpCoParticipantDetail = list.get(0);

					result = rsvpCoParticipantDetail;

					cacheResult(rsvpCoParticipantDetail);

					if ((rsvpCoParticipantDetail.getUuid() == null) ||
							!rsvpCoParticipantDetail.getUuid().equals(uuid) ||
							(rsvpCoParticipantDetail.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, rsvpCoParticipantDetail);
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
			return (RsvpCoParticipantDetail)result;
		}
	}

	/**
	 * Removes the rsvp co participant detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rsvp co participant detail that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = findByUUID_G(uuid,
				groupId);

		return remove(rsvpCoParticipantDetail);
	}

	/**
	 * Returns the number of rsvp co participant details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rsvp co participant details
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

			query.append(_SQL_COUNT_RSVPCOPARTICIPANTDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "rsvpCoParticipantDetail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "rsvpCoParticipantDetail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(rsvpCoParticipantDetail.uuid IS NULL OR rsvpCoParticipantDetail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "rsvpCoParticipantDetail.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpCoParticipantDetailModelImpl.UUID_COLUMN_BITMASK |
			RsvpCoParticipantDetailModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rsvp co participant details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByUuid_C(String uuid,
		long companyId) throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp co participant details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @return the range of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp co participant details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByUuid_C(String uuid,
		long companyId, int start, int end, OrderByComparator orderByComparator)
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

		List<RsvpCoParticipantDetail> list = (List<RsvpCoParticipantDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpCoParticipantDetail rsvpCoParticipantDetail : list) {
				if (!Validator.equals(uuid, rsvpCoParticipantDetail.getUuid()) ||
						(companyId != rsvpCoParticipantDetail.getCompanyId())) {
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

			query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

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
				query.append(RsvpCoParticipantDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpCoParticipantDetail>(list);
				}
				else {
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
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
	 * Returns the first rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (rsvpCoParticipantDetail != null) {
			return rsvpCoParticipantDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<RsvpCoParticipantDetail> list = findByUuid_C(uuid, companyId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (rsvpCoParticipantDetail != null) {
			return rsvpCoParticipantDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RsvpCoParticipantDetail> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp co participant details before and after the current rsvp co participant detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rsvpCoParticipantDetailId the primary key of the current rsvp co participant detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail[] findByUuid_C_PrevAndNext(
		long rsvpCoParticipantDetailId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = findByPrimaryKey(rsvpCoParticipantDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpCoParticipantDetail[] array = new RsvpCoParticipantDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session,
					rsvpCoParticipantDetail, uuid, companyId,
					orderByComparator, true);

			array[1] = rsvpCoParticipantDetail;

			array[2] = getByUuid_C_PrevAndNext(session,
					rsvpCoParticipantDetail, uuid, companyId,
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

	protected RsvpCoParticipantDetail getByUuid_C_PrevAndNext(Session session,
		RsvpCoParticipantDetail rsvpCoParticipantDetail, String uuid,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

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
			query.append(RsvpCoParticipantDetailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpCoParticipantDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpCoParticipantDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp co participant details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (RsvpCoParticipantDetail rsvpCoParticipantDetail : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpCoParticipantDetail);
		}
	}

	/**
	 * Returns the number of rsvp co participant details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rsvp co participant details
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

			query.append(_SQL_COUNT_RSVPCOPARTICIPANTDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "rsvpCoParticipantDetail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "rsvpCoParticipantDetail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(rsvpCoParticipantDetail.uuid IS NULL OR rsvpCoParticipantDetail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "rsvpCoParticipantDetail.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPDETAILID =
		new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRsvpDetailId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILID =
		new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRsvpDetailId",
			new String[] { Long.class.getName() },
			RsvpCoParticipantDetailModelImpl.RSVPDETAILID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPDETAILID = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRsvpDetailId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rsvp co participant details where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @return the matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByRsvpDetailId(long rsvpDetailId)
		throws SystemException {
		return findByRsvpDetailId(rsvpDetailId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp co participant details where rsvpDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @return the range of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByRsvpDetailId(long rsvpDetailId,
		int start, int end) throws SystemException {
		return findByRsvpDetailId(rsvpDetailId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp co participant details where rsvpDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByRsvpDetailId(long rsvpDetailId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILID;
			finderArgs = new Object[] { rsvpDetailId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPDETAILID;
			finderArgs = new Object[] {
					rsvpDetailId,
					
					start, end, orderByComparator
				};
		}

		List<RsvpCoParticipantDetail> list = (List<RsvpCoParticipantDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpCoParticipantDetail rsvpCoParticipantDetail : list) {
				if ((rsvpDetailId != rsvpCoParticipantDetail.getRsvpDetailId())) {
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

			query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPDETAILID_RSVPDETAILID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpCoParticipantDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpDetailId);

				if (!pagination) {
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpCoParticipantDetail>(list);
				}
				else {
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
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
	 * Returns the first rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByRsvpDetailId_First(long rsvpDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByRsvpDetailId_First(rsvpDetailId,
				orderByComparator);

		if (rsvpCoParticipantDetail != null) {
			return rsvpCoParticipantDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpDetailId=");
		msg.append(rsvpDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByRsvpDetailId_First(
		long rsvpDetailId, OrderByComparator orderByComparator)
		throws SystemException {
		List<RsvpCoParticipantDetail> list = findByRsvpDetailId(rsvpDetailId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByRsvpDetailId_Last(long rsvpDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByRsvpDetailId_Last(rsvpDetailId,
				orderByComparator);

		if (rsvpCoParticipantDetail != null) {
			return rsvpCoParticipantDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpDetailId=");
		msg.append(rsvpDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByRsvpDetailId_Last(long rsvpDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRsvpDetailId(rsvpDetailId);

		if (count == 0) {
			return null;
		}

		List<RsvpCoParticipantDetail> list = findByRsvpDetailId(rsvpDetailId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp co participant details before and after the current rsvp co participant detail in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpCoParticipantDetailId the primary key of the current rsvp co participant detail
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail[] findByRsvpDetailId_PrevAndNext(
		long rsvpCoParticipantDetailId, long rsvpDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = findByPrimaryKey(rsvpCoParticipantDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpCoParticipantDetail[] array = new RsvpCoParticipantDetailImpl[3];

			array[0] = getByRsvpDetailId_PrevAndNext(session,
					rsvpCoParticipantDetail, rsvpDetailId, orderByComparator,
					true);

			array[1] = rsvpCoParticipantDetail;

			array[2] = getByRsvpDetailId_PrevAndNext(session,
					rsvpCoParticipantDetail, rsvpDetailId, orderByComparator,
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

	protected RsvpCoParticipantDetail getByRsvpDetailId_PrevAndNext(
		Session session, RsvpCoParticipantDetail rsvpCoParticipantDetail,
		long rsvpDetailId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RSVPDETAILID_RSVPDETAILID_2);

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
			query.append(RsvpCoParticipantDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpDetailId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpCoParticipantDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpCoParticipantDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp co participant details where rsvpDetailId = &#63; from the database.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRsvpDetailId(long rsvpDetailId)
		throws SystemException {
		for (RsvpCoParticipantDetail rsvpCoParticipantDetail : findByRsvpDetailId(
				rsvpDetailId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpCoParticipantDetail);
		}
	}

	/**
	 * Returns the number of rsvp co participant details where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @return the number of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRsvpDetailId(long rsvpDetailId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RSVPDETAILID;

		Object[] finderArgs = new Object[] { rsvpDetailId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RSVPCOPARTICIPANTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPDETAILID_RSVPDETAILID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpDetailId);

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

	private static final String _FINDER_COLUMN_RSVPDETAILID_RSVPDETAILID_2 = "rsvpCoParticipantDetail.rsvpDetailId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TICKETNUMBER = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTicketNumber", new String[] { String.class.getName() },
			RsvpCoParticipantDetailModelImpl.TICKETNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TICKETNUMBER = new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketNumber",
			new String[] { String.class.getName() });

	/**
	 * Returns the rsvp co participant detail where ticketNumber = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException} if it could not be found.
	 *
	 * @param ticketNumber the ticket number
	 * @return the matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByTicketNumber(String ticketNumber)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByTicketNumber(ticketNumber);

		if (rsvpCoParticipantDetail == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ticketNumber=");
			msg.append(ticketNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
		}

		return rsvpCoParticipantDetail;
	}

	/**
	 * Returns the rsvp co participant detail where ticketNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketNumber the ticket number
	 * @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByTicketNumber(String ticketNumber)
		throws SystemException {
		return fetchByTicketNumber(ticketNumber, true);
	}

	/**
	 * Returns the rsvp co participant detail where ticketNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketNumber the ticket number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByTicketNumber(String ticketNumber,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ticketNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
					finderArgs, this);
		}

		if (result instanceof RsvpCoParticipantDetail) {
			RsvpCoParticipantDetail rsvpCoParticipantDetail = (RsvpCoParticipantDetail)result;

			if (!Validator.equals(ticketNumber,
						rsvpCoParticipantDetail.getTicketNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

			boolean bindTicketNumber = false;

			if (ticketNumber == null) {
				query.append(_FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_1);
			}
			else if (ticketNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_3);
			}
			else {
				bindTicketNumber = true;

				query.append(_FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTicketNumber) {
					qPos.add(ticketNumber);
				}

				List<RsvpCoParticipantDetail> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
						finderArgs, list);
				}
				else {
					RsvpCoParticipantDetail rsvpCoParticipantDetail = list.get(0);

					result = rsvpCoParticipantDetail;

					cacheResult(rsvpCoParticipantDetail);

					if ((rsvpCoParticipantDetail.getTicketNumber() == null) ||
							!rsvpCoParticipantDetail.getTicketNumber()
														.equals(ticketNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
							finderArgs, rsvpCoParticipantDetail);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
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
			return (RsvpCoParticipantDetail)result;
		}
	}

	/**
	 * Removes the rsvp co participant detail where ticketNumber = &#63; from the database.
	 *
	 * @param ticketNumber the ticket number
	 * @return the rsvp co participant detail that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail removeByTicketNumber(String ticketNumber)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = findByTicketNumber(ticketNumber);

		return remove(rsvpCoParticipantDetail);
	}

	/**
	 * Returns the number of rsvp co participant details where ticketNumber = &#63;.
	 *
	 * @param ticketNumber the ticket number
	 * @return the number of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTicketNumber(String ticketNumber)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TICKETNUMBER;

		Object[] finderArgs = new Object[] { ticketNumber };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RSVPCOPARTICIPANTDETAIL_WHERE);

			boolean bindTicketNumber = false;

			if (ticketNumber == null) {
				query.append(_FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_1);
			}
			else if (ticketNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_3);
			}
			else {
				bindTicketNumber = true;

				query.append(_FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTicketNumber) {
					qPos.add(ticketNumber);
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

	private static final String _FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_1 = "rsvpCoParticipantDetail.ticketNumber IS NULL";
	private static final String _FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_2 = "rsvpCoParticipantDetail.ticketNumber = ?";
	private static final String _FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_3 = "(rsvpCoParticipantDetail.ticketNumber IS NULL OR rsvpCoParticipantDetail.ticketNumber = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPDETAILIDANDSPRSVPPAYMENTID =
		new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRsvpDetailIdAndSPRsvpPaymentId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDANDSPRSVPPAYMENTID =
		new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRsvpDetailIdAndSPRsvpPaymentId",
			new String[] { Long.class.getName(), Long.class.getName() },
			RsvpCoParticipantDetailModelImpl.RSVPDETAILID_COLUMN_BITMASK |
			RsvpCoParticipantDetailModelImpl.RSVPPAYMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPDETAILIDANDSPRSVPPAYMENTID =
		new FinderPath(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRsvpDetailIdAndSPRsvpPaymentId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @return the matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByRsvpDetailIdAndSPRsvpPaymentId(
		long rsvpDetailId, long rsvpPaymentId) throws SystemException {
		return findByRsvpDetailIdAndSPRsvpPaymentId(rsvpDetailId,
			rsvpPaymentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @return the range of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByRsvpDetailIdAndSPRsvpPaymentId(
		long rsvpDetailId, long rsvpPaymentId, int start, int end)
		throws SystemException {
		return findByRsvpDetailIdAndSPRsvpPaymentId(rsvpDetailId,
			rsvpPaymentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findByRsvpDetailIdAndSPRsvpPaymentId(
		long rsvpDetailId, long rsvpPaymentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDANDSPRSVPPAYMENTID;
			finderArgs = new Object[] { rsvpDetailId, rsvpPaymentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPDETAILIDANDSPRSVPPAYMENTID;
			finderArgs = new Object[] {
					rsvpDetailId, rsvpPaymentId,
					
					start, end, orderByComparator
				};
		}

		List<RsvpCoParticipantDetail> list = (List<RsvpCoParticipantDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpCoParticipantDetail rsvpCoParticipantDetail : list) {
				if ((rsvpDetailId != rsvpCoParticipantDetail.getRsvpDetailId()) ||
						(rsvpPaymentId != rsvpCoParticipantDetail.getRsvpPaymentId())) {
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

			query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPDETAILIDANDSPRSVPPAYMENTID_RSVPDETAILID_2);

			query.append(_FINDER_COLUMN_RSVPDETAILIDANDSPRSVPPAYMENTID_RSVPPAYMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpCoParticipantDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpDetailId);

				qPos.add(rsvpPaymentId);

				if (!pagination) {
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpCoParticipantDetail>(list);
				}
				else {
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
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
	 * Returns the first rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByRsvpDetailIdAndSPRsvpPaymentId_First(
		long rsvpDetailId, long rsvpPaymentId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByRsvpDetailIdAndSPRsvpPaymentId_First(rsvpDetailId,
				rsvpPaymentId, orderByComparator);

		if (rsvpCoParticipantDetail != null) {
			return rsvpCoParticipantDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpDetailId=");
		msg.append(rsvpDetailId);

		msg.append(", rsvpPaymentId=");
		msg.append(rsvpPaymentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
	}

	/**
	 * Returns the first rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByRsvpDetailIdAndSPRsvpPaymentId_First(
		long rsvpDetailId, long rsvpPaymentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpCoParticipantDetail> list = findByRsvpDetailIdAndSPRsvpPaymentId(rsvpDetailId,
				rsvpPaymentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByRsvpDetailIdAndSPRsvpPaymentId_Last(
		long rsvpDetailId, long rsvpPaymentId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByRsvpDetailIdAndSPRsvpPaymentId_Last(rsvpDetailId,
				rsvpPaymentId, orderByComparator);

		if (rsvpCoParticipantDetail != null) {
			return rsvpCoParticipantDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpDetailId=");
		msg.append(rsvpDetailId);

		msg.append(", rsvpPaymentId=");
		msg.append(rsvpPaymentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpCoParticipantDetailException(msg.toString());
	}

	/**
	 * Returns the last rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp co participant detail, or <code>null</code> if a matching rsvp co participant detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByRsvpDetailIdAndSPRsvpPaymentId_Last(
		long rsvpDetailId, long rsvpPaymentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRsvpDetailIdAndSPRsvpPaymentId(rsvpDetailId,
				rsvpPaymentId);

		if (count == 0) {
			return null;
		}

		List<RsvpCoParticipantDetail> list = findByRsvpDetailIdAndSPRsvpPaymentId(rsvpDetailId,
				rsvpPaymentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp co participant details before and after the current rsvp co participant detail in the ordered set where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	 *
	 * @param rsvpCoParticipantDetailId the primary key of the current rsvp co participant detail
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail[] findByRsvpDetailIdAndSPRsvpPaymentId_PrevAndNext(
		long rsvpCoParticipantDetailId, long rsvpDetailId, long rsvpPaymentId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = findByPrimaryKey(rsvpCoParticipantDetailId);

		Session session = null;

		try {
			session = openSession();

			RsvpCoParticipantDetail[] array = new RsvpCoParticipantDetailImpl[3];

			array[0] = getByRsvpDetailIdAndSPRsvpPaymentId_PrevAndNext(session,
					rsvpCoParticipantDetail, rsvpDetailId, rsvpPaymentId,
					orderByComparator, true);

			array[1] = rsvpCoParticipantDetail;

			array[2] = getByRsvpDetailIdAndSPRsvpPaymentId_PrevAndNext(session,
					rsvpCoParticipantDetail, rsvpDetailId, rsvpPaymentId,
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

	protected RsvpCoParticipantDetail getByRsvpDetailIdAndSPRsvpPaymentId_PrevAndNext(
		Session session, RsvpCoParticipantDetail rsvpCoParticipantDetail,
		long rsvpDetailId, long rsvpPaymentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RSVPDETAILIDANDSPRSVPPAYMENTID_RSVPDETAILID_2);

		query.append(_FINDER_COLUMN_RSVPDETAILIDANDSPRSVPPAYMENTID_RSVPPAYMENTID_2);

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
			query.append(RsvpCoParticipantDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpDetailId);

		qPos.add(rsvpPaymentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpCoParticipantDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpCoParticipantDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63; from the database.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRsvpDetailIdAndSPRsvpPaymentId(long rsvpDetailId,
		long rsvpPaymentId) throws SystemException {
		for (RsvpCoParticipantDetail rsvpCoParticipantDetail : findByRsvpDetailIdAndSPRsvpPaymentId(
				rsvpDetailId, rsvpPaymentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvpCoParticipantDetail);
		}
	}

	/**
	 * Returns the number of rsvp co participant details where rsvpDetailId = &#63; and rsvpPaymentId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param rsvpPaymentId the rsvp payment ID
	 * @return the number of matching rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRsvpDetailIdAndSPRsvpPaymentId(long rsvpDetailId,
		long rsvpPaymentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RSVPDETAILIDANDSPRSVPPAYMENTID;

		Object[] finderArgs = new Object[] { rsvpDetailId, rsvpPaymentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RSVPCOPARTICIPANTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RSVPDETAILIDANDSPRSVPPAYMENTID_RSVPDETAILID_2);

			query.append(_FINDER_COLUMN_RSVPDETAILIDANDSPRSVPPAYMENTID_RSVPPAYMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpDetailId);

				qPos.add(rsvpPaymentId);

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

	private static final String _FINDER_COLUMN_RSVPDETAILIDANDSPRSVPPAYMENTID_RSVPDETAILID_2 =
		"rsvpCoParticipantDetail.rsvpDetailId = ? AND ";
	private static final String _FINDER_COLUMN_RSVPDETAILIDANDSPRSVPPAYMENTID_RSVPPAYMENTID_2 =
		"rsvpCoParticipantDetail.rsvpPaymentId = ?";

	public RsvpCoParticipantDetailPersistenceImpl() {
		setModelClass(RsvpCoParticipantDetail.class);
	}

	/**
	 * Caches the rsvp co participant detail in the entity cache if it is enabled.
	 *
	 * @param rsvpCoParticipantDetail the rsvp co participant detail
	 */
	@Override
	public void cacheResult(RsvpCoParticipantDetail rsvpCoParticipantDetail) {
		EntityCacheUtil.putResult(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			rsvpCoParticipantDetail.getPrimaryKey(), rsvpCoParticipantDetail);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				rsvpCoParticipantDetail.getUuid(),
				rsvpCoParticipantDetail.getGroupId()
			}, rsvpCoParticipantDetail);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
			new Object[] { rsvpCoParticipantDetail.getTicketNumber() },
			rsvpCoParticipantDetail);

		rsvpCoParticipantDetail.resetOriginalValues();
	}

	/**
	 * Caches the rsvp co participant details in the entity cache if it is enabled.
	 *
	 * @param rsvpCoParticipantDetails the rsvp co participant details
	 */
	@Override
	public void cacheResult(
		List<RsvpCoParticipantDetail> rsvpCoParticipantDetails) {
		for (RsvpCoParticipantDetail rsvpCoParticipantDetail : rsvpCoParticipantDetails) {
			if (EntityCacheUtil.getResult(
						RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
						RsvpCoParticipantDetailImpl.class,
						rsvpCoParticipantDetail.getPrimaryKey()) == null) {
				cacheResult(rsvpCoParticipantDetail);
			}
			else {
				rsvpCoParticipantDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rsvp co participant details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RsvpCoParticipantDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RsvpCoParticipantDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rsvp co participant detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RsvpCoParticipantDetail rsvpCoParticipantDetail) {
		EntityCacheUtil.removeResult(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			rsvpCoParticipantDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rsvpCoParticipantDetail);
	}

	@Override
	public void clearCache(
		List<RsvpCoParticipantDetail> rsvpCoParticipantDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RsvpCoParticipantDetail rsvpCoParticipantDetail : rsvpCoParticipantDetails) {
			EntityCacheUtil.removeResult(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
				RsvpCoParticipantDetailImpl.class,
				rsvpCoParticipantDetail.getPrimaryKey());

			clearUniqueFindersCache(rsvpCoParticipantDetail);
		}
	}

	protected void cacheUniqueFindersCache(
		RsvpCoParticipantDetail rsvpCoParticipantDetail) {
		if (rsvpCoParticipantDetail.isNew()) {
			Object[] args = new Object[] {
					rsvpCoParticipantDetail.getUuid(),
					rsvpCoParticipantDetail.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				rsvpCoParticipantDetail);

			args = new Object[] { rsvpCoParticipantDetail.getTicketNumber() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TICKETNUMBER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER, args,
				rsvpCoParticipantDetail);
		}
		else {
			RsvpCoParticipantDetailModelImpl rsvpCoParticipantDetailModelImpl = (RsvpCoParticipantDetailModelImpl)rsvpCoParticipantDetail;

			if ((rsvpCoParticipantDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpCoParticipantDetail.getUuid(),
						rsvpCoParticipantDetail.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					rsvpCoParticipantDetail);
			}

			if ((rsvpCoParticipantDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TICKETNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpCoParticipantDetail.getTicketNumber()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TICKETNUMBER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
					args, rsvpCoParticipantDetail);
			}
		}
	}

	protected void clearUniqueFindersCache(
		RsvpCoParticipantDetail rsvpCoParticipantDetail) {
		RsvpCoParticipantDetailModelImpl rsvpCoParticipantDetailModelImpl = (RsvpCoParticipantDetailModelImpl)rsvpCoParticipantDetail;

		Object[] args = new Object[] {
				rsvpCoParticipantDetail.getUuid(),
				rsvpCoParticipantDetail.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((rsvpCoParticipantDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					rsvpCoParticipantDetailModelImpl.getOriginalUuid(),
					rsvpCoParticipantDetailModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { rsvpCoParticipantDetail.getTicketNumber() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNUMBER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNUMBER, args);

		if ((rsvpCoParticipantDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TICKETNUMBER.getColumnBitmask()) != 0) {
			args = new Object[] {
					rsvpCoParticipantDetailModelImpl.getOriginalTicketNumber()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNUMBER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNUMBER, args);
		}
	}

	/**
	 * Creates a new rsvp co participant detail with the primary key. Does not add the rsvp co participant detail to the database.
	 *
	 * @param rsvpCoParticipantDetailId the primary key for the new rsvp co participant detail
	 * @return the new rsvp co participant detail
	 */
	@Override
	public RsvpCoParticipantDetail create(long rsvpCoParticipantDetailId) {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = new RsvpCoParticipantDetailImpl();

		rsvpCoParticipantDetail.setNew(true);
		rsvpCoParticipantDetail.setPrimaryKey(rsvpCoParticipantDetailId);

		String uuid = PortalUUIDUtil.generate();

		rsvpCoParticipantDetail.setUuid(uuid);

		return rsvpCoParticipantDetail;
	}

	/**
	 * Removes the rsvp co participant detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rsvpCoParticipantDetailId the primary key of the rsvp co participant detail
	 * @return the rsvp co participant detail that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail remove(long rsvpCoParticipantDetailId)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		return remove((Serializable)rsvpCoParticipantDetailId);
	}

	/**
	 * Removes the rsvp co participant detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rsvp co participant detail
	 * @return the rsvp co participant detail that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail remove(Serializable primaryKey)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RsvpCoParticipantDetail rsvpCoParticipantDetail = (RsvpCoParticipantDetail)session.get(RsvpCoParticipantDetailImpl.class,
					primaryKey);

			if (rsvpCoParticipantDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRsvpCoParticipantDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rsvpCoParticipantDetail);
		}
		catch (NoSuchRsvpCoParticipantDetailException nsee) {
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
	protected RsvpCoParticipantDetail removeImpl(
		RsvpCoParticipantDetail rsvpCoParticipantDetail)
		throws SystemException {
		rsvpCoParticipantDetail = toUnwrappedModel(rsvpCoParticipantDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rsvpCoParticipantDetail)) {
				rsvpCoParticipantDetail = (RsvpCoParticipantDetail)session.get(RsvpCoParticipantDetailImpl.class,
						rsvpCoParticipantDetail.getPrimaryKeyObj());
			}

			if (rsvpCoParticipantDetail != null) {
				session.delete(rsvpCoParticipantDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rsvpCoParticipantDetail != null) {
			clearCache(rsvpCoParticipantDetail);
		}

		return rsvpCoParticipantDetail;
	}

	@Override
	public RsvpCoParticipantDetail updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail rsvpCoParticipantDetail)
		throws SystemException {
		rsvpCoParticipantDetail = toUnwrappedModel(rsvpCoParticipantDetail);

		boolean isNew = rsvpCoParticipantDetail.isNew();

		RsvpCoParticipantDetailModelImpl rsvpCoParticipantDetailModelImpl = (RsvpCoParticipantDetailModelImpl)rsvpCoParticipantDetail;

		if (Validator.isNull(rsvpCoParticipantDetail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rsvpCoParticipantDetail.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (rsvpCoParticipantDetail.isNew()) {
				session.save(rsvpCoParticipantDetail);

				rsvpCoParticipantDetail.setNew(false);
			}
			else {
				session.merge(rsvpCoParticipantDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RsvpCoParticipantDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rsvpCoParticipantDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpCoParticipantDetailModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { rsvpCoParticipantDetailModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((rsvpCoParticipantDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpCoParticipantDetailModelImpl.getOriginalUuid(),
						rsvpCoParticipantDetailModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						rsvpCoParticipantDetailModelImpl.getUuid(),
						rsvpCoParticipantDetailModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((rsvpCoParticipantDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpCoParticipantDetailModelImpl.getOriginalRsvpDetailId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILID,
					args);

				args = new Object[] {
						rsvpCoParticipantDetailModelImpl.getRsvpDetailId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILID,
					args);
			}

			if ((rsvpCoParticipantDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDANDSPRSVPPAYMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpCoParticipantDetailModelImpl.getOriginalRsvpDetailId(),
						rsvpCoParticipantDetailModelImpl.getOriginalRsvpPaymentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPDETAILIDANDSPRSVPPAYMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDANDSPRSVPPAYMENTID,
					args);

				args = new Object[] {
						rsvpCoParticipantDetailModelImpl.getRsvpDetailId(),
						rsvpCoParticipantDetailModelImpl.getRsvpPaymentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPDETAILIDANDSPRSVPPAYMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDANDSPRSVPPAYMENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
			RsvpCoParticipantDetailImpl.class,
			rsvpCoParticipantDetail.getPrimaryKey(), rsvpCoParticipantDetail);

		clearUniqueFindersCache(rsvpCoParticipantDetail);
		cacheUniqueFindersCache(rsvpCoParticipantDetail);

		return rsvpCoParticipantDetail;
	}

	protected RsvpCoParticipantDetail toUnwrappedModel(
		RsvpCoParticipantDetail rsvpCoParticipantDetail) {
		if (rsvpCoParticipantDetail instanceof RsvpCoParticipantDetailImpl) {
			return rsvpCoParticipantDetail;
		}

		RsvpCoParticipantDetailImpl rsvpCoParticipantDetailImpl = new RsvpCoParticipantDetailImpl();

		rsvpCoParticipantDetailImpl.setNew(rsvpCoParticipantDetail.isNew());
		rsvpCoParticipantDetailImpl.setPrimaryKey(rsvpCoParticipantDetail.getPrimaryKey());

		rsvpCoParticipantDetailImpl.setUuid(rsvpCoParticipantDetail.getUuid());
		rsvpCoParticipantDetailImpl.setRsvpCoParticipantDetailId(rsvpCoParticipantDetail.getRsvpCoParticipantDetailId());
		rsvpCoParticipantDetailImpl.setGroupId(rsvpCoParticipantDetail.getGroupId());
		rsvpCoParticipantDetailImpl.setCompanyId(rsvpCoParticipantDetail.getCompanyId());
		rsvpCoParticipantDetailImpl.setUserName(rsvpCoParticipantDetail.getUserName());
		rsvpCoParticipantDetailImpl.setCreateDate(rsvpCoParticipantDetail.getCreateDate());
		rsvpCoParticipantDetailImpl.setModifiedDate(rsvpCoParticipantDetail.getModifiedDate());
		rsvpCoParticipantDetailImpl.setRsvpDetailId(rsvpCoParticipantDetail.getRsvpDetailId());
		rsvpCoParticipantDetailImpl.setRsvpPaymentId(rsvpCoParticipantDetail.getRsvpPaymentId());
		rsvpCoParticipantDetailImpl.setUserId(rsvpCoParticipantDetail.getUserId());
		rsvpCoParticipantDetailImpl.setFirstName(rsvpCoParticipantDetail.getFirstName());
		rsvpCoParticipantDetailImpl.setLastName(rsvpCoParticipantDetail.getLastName());
		rsvpCoParticipantDetailImpl.setNric(rsvpCoParticipantDetail.getNric());
		rsvpCoParticipantDetailImpl.setIdentificationType(rsvpCoParticipantDetail.getIdentificationType());
		rsvpCoParticipantDetailImpl.setEmailAddress(rsvpCoParticipantDetail.getEmailAddress());
		rsvpCoParticipantDetailImpl.setRsvpStatus(rsvpCoParticipantDetail.getRsvpStatus());
		rsvpCoParticipantDetailImpl.setAttendance(rsvpCoParticipantDetail.getAttendance());
		rsvpCoParticipantDetailImpl.setAttendanceBy(rsvpCoParticipantDetail.getAttendanceBy());
		rsvpCoParticipantDetailImpl.setAttendanceDate(rsvpCoParticipantDetail.getAttendanceDate());
		rsvpCoParticipantDetailImpl.setTicketNumber(rsvpCoParticipantDetail.getTicketNumber());

		return rsvpCoParticipantDetailImpl;
	}

	/**
	 * Returns the rsvp co participant detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp co participant detail
	 * @return the rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = fetchByPrimaryKey(primaryKey);

		if (rsvpCoParticipantDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRsvpCoParticipantDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rsvpCoParticipantDetail;
	}

	/**
	 * Returns the rsvp co participant detail with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException} if it could not be found.
	 *
	 * @param rsvpCoParticipantDetailId the primary key of the rsvp co participant detail
	 * @return the rsvp co participant detail
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail findByPrimaryKey(
		long rsvpCoParticipantDetailId)
		throws NoSuchRsvpCoParticipantDetailException, SystemException {
		return findByPrimaryKey((Serializable)rsvpCoParticipantDetailId);
	}

	/**
	 * Returns the rsvp co participant detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp co participant detail
	 * @return the rsvp co participant detail, or <code>null</code> if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RsvpCoParticipantDetail rsvpCoParticipantDetail = (RsvpCoParticipantDetail)EntityCacheUtil.getResult(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
				RsvpCoParticipantDetailImpl.class, primaryKey);

		if (rsvpCoParticipantDetail == _nullRsvpCoParticipantDetail) {
			return null;
		}

		if (rsvpCoParticipantDetail == null) {
			Session session = null;

			try {
				session = openSession();

				rsvpCoParticipantDetail = (RsvpCoParticipantDetail)session.get(RsvpCoParticipantDetailImpl.class,
						primaryKey);

				if (rsvpCoParticipantDetail != null) {
					cacheResult(rsvpCoParticipantDetail);
				}
				else {
					EntityCacheUtil.putResult(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
						RsvpCoParticipantDetailImpl.class, primaryKey,
						_nullRsvpCoParticipantDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RsvpCoParticipantDetailModelImpl.ENTITY_CACHE_ENABLED,
					RsvpCoParticipantDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rsvpCoParticipantDetail;
	}

	/**
	 * Returns the rsvp co participant detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rsvpCoParticipantDetailId the primary key of the rsvp co participant detail
	 * @return the rsvp co participant detail, or <code>null</code> if a rsvp co participant detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpCoParticipantDetail fetchByPrimaryKey(
		long rsvpCoParticipantDetailId) throws SystemException {
		return fetchByPrimaryKey((Serializable)rsvpCoParticipantDetailId);
	}

	/**
	 * Returns all the rsvp co participant details.
	 *
	 * @return the rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp co participant details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @return the range of rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp co participant details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp co participant details
	 * @param end the upper bound of the range of rsvp co participant details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rsvp co participant details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpCoParticipantDetail> findAll(int start, int end,
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

		List<RsvpCoParticipantDetail> list = (List<RsvpCoParticipantDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RSVPCOPARTICIPANTDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RSVPCOPARTICIPANTDETAIL;

				if (pagination) {
					sql = sql.concat(RsvpCoParticipantDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpCoParticipantDetail>(list);
				}
				else {
					list = (List<RsvpCoParticipantDetail>)QueryUtil.list(q,
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
	 * Removes all the rsvp co participant details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RsvpCoParticipantDetail rsvpCoParticipantDetail : findAll()) {
			remove(rsvpCoParticipantDetail);
		}
	}

	/**
	 * Returns the number of rsvp co participant details.
	 *
	 * @return the number of rsvp co participant details
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

				Query q = session.createQuery(_SQL_COUNT_RSVPCOPARTICIPANTDETAIL);

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
	 * Initializes the rsvp co participant detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RsvpCoParticipantDetail>> listenersList = new ArrayList<ModelListener<RsvpCoParticipantDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RsvpCoParticipantDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RsvpCoParticipantDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RSVPCOPARTICIPANTDETAIL = "SELECT rsvpCoParticipantDetail FROM RsvpCoParticipantDetail rsvpCoParticipantDetail";
	private static final String _SQL_SELECT_RSVPCOPARTICIPANTDETAIL_WHERE = "SELECT rsvpCoParticipantDetail FROM RsvpCoParticipantDetail rsvpCoParticipantDetail WHERE ";
	private static final String _SQL_COUNT_RSVPCOPARTICIPANTDETAIL = "SELECT COUNT(rsvpCoParticipantDetail) FROM RsvpCoParticipantDetail rsvpCoParticipantDetail";
	private static final String _SQL_COUNT_RSVPCOPARTICIPANTDETAIL_WHERE = "SELECT COUNT(rsvpCoParticipantDetail) FROM RsvpCoParticipantDetail rsvpCoParticipantDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rsvpCoParticipantDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RsvpCoParticipantDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RsvpCoParticipantDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RsvpCoParticipantDetailPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "rsvpCoParticipantDetailId", "rsvpDetailId",
				"rsvpPaymentId"
			});
	private static RsvpCoParticipantDetail _nullRsvpCoParticipantDetail = new RsvpCoParticipantDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RsvpCoParticipantDetail> toCacheModel() {
				return _nullRsvpCoParticipantDetailCacheModel;
			}
		};

	private static CacheModel<RsvpCoParticipantDetail> _nullRsvpCoParticipantDetailCacheModel =
		new CacheModel<RsvpCoParticipantDetail>() {
			@Override
			public RsvpCoParticipantDetail toEntityModel() {
				return _nullRsvpCoParticipantDetail;
			}
		};
}