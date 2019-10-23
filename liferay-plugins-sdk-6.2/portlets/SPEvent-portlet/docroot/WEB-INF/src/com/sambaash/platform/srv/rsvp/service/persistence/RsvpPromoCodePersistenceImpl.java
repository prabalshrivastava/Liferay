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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException;
import com.sambaash.platform.srv.rsvp.model.RsvpPromoCode;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeImpl;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rsvp promo code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPromoCodePersistence
 * @see RsvpPromoCodeUtil
 * @generated
 */
public class RsvpPromoCodePersistenceImpl extends BasePersistenceImpl<RsvpPromoCode>
	implements RsvpPromoCodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RsvpPromoCodeUtil} to access the rsvp promo code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RsvpPromoCodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			RsvpPromoCodeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rsvp promo codes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp promo codes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @return the range of matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp promo codes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByUuid(String uuid, int start, int end,
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

		List<RsvpPromoCode> list = (List<RsvpPromoCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpPromoCode rsvpPromoCode : list) {
				if (!Validator.equals(uuid, rsvpPromoCode.getUuid())) {
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

			query.append(_SQL_SELECT_RSVPPROMOCODE_WHERE);

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
				query.append(RsvpPromoCodeModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPromoCode>(list);
				}
				else {
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp promo code in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByUuid_First(uuid, orderByComparator);

		if (rsvpPromoCode != null) {
			return rsvpPromoCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPromoCodeException(msg.toString());
	}

	/**
	 * Returns the first rsvp promo code in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpPromoCode> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp promo code in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByUuid_Last(uuid, orderByComparator);

		if (rsvpPromoCode != null) {
			return rsvpPromoCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPromoCodeException(msg.toString());
	}

	/**
	 * Returns the last rsvp promo code in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RsvpPromoCode> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp promo codes before and after the current rsvp promo code in the ordered set where uuid = &#63;.
	 *
	 * @param rsvpPromoCodeId the primary key of the current rsvp promo code
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode[] findByUuid_PrevAndNext(long rsvpPromoCodeId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = findByPrimaryKey(rsvpPromoCodeId);

		Session session = null;

		try {
			session = openSession();

			RsvpPromoCode[] array = new RsvpPromoCodeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, rsvpPromoCode, uuid,
					orderByComparator, true);

			array[1] = rsvpPromoCode;

			array[2] = getByUuid_PrevAndNext(session, rsvpPromoCode, uuid,
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

	protected RsvpPromoCode getByUuid_PrevAndNext(Session session,
		RsvpPromoCode rsvpPromoCode, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPPROMOCODE_WHERE);

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
			query.append(RsvpPromoCodeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpPromoCode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpPromoCode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp promo codes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RsvpPromoCode rsvpPromoCode : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvpPromoCode);
		}
	}

	/**
	 * Returns the number of rsvp promo codes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rsvp promo codes
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

			query.append(_SQL_COUNT_RSVPPROMOCODE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "rsvpPromoCode.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "rsvpPromoCode.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(rsvpPromoCode.uuid IS NULL OR rsvpPromoCode.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpPromoCodeModelImpl.UUID_COLUMN_BITMASK |
			RsvpPromoCodeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rsvp promo code where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByUUID_G(uuid, groupId);

		if (rsvpPromoCode == null) {
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

			throw new NoSuchRsvpPromoCodeException(msg.toString());
		}

		return rsvpPromoCode;
	}

	/**
	 * Returns the rsvp promo code where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rsvp promo code where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RsvpPromoCode) {
			RsvpPromoCode rsvpPromoCode = (RsvpPromoCode)result;

			if (!Validator.equals(uuid, rsvpPromoCode.getUuid()) ||
					(groupId != rsvpPromoCode.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RSVPPROMOCODE_WHERE);

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

				List<RsvpPromoCode> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RsvpPromoCode rsvpPromoCode = list.get(0);

					result = rsvpPromoCode;

					cacheResult(rsvpPromoCode);

					if ((rsvpPromoCode.getUuid() == null) ||
							!rsvpPromoCode.getUuid().equals(uuid) ||
							(rsvpPromoCode.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, rsvpPromoCode);
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
			return (RsvpPromoCode)result;
		}
	}

	/**
	 * Removes the rsvp promo code where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rsvp promo code that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode removeByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = findByUUID_G(uuid, groupId);

		return remove(rsvpPromoCode);
	}

	/**
	 * Returns the number of rsvp promo codes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rsvp promo codes
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

			query.append(_SQL_COUNT_RSVPPROMOCODE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "rsvpPromoCode.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "rsvpPromoCode.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(rsvpPromoCode.uuid IS NULL OR rsvpPromoCode.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "rsvpPromoCode.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpPromoCodeModelImpl.UUID_COLUMN_BITMASK |
			RsvpPromoCodeModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rsvp promo codes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp promo codes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @return the range of matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp promo codes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByUuid_C(String uuid, long companyId,
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

		List<RsvpPromoCode> list = (List<RsvpPromoCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpPromoCode rsvpPromoCode : list) {
				if (!Validator.equals(uuid, rsvpPromoCode.getUuid()) ||
						(companyId != rsvpPromoCode.getCompanyId())) {
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

			query.append(_SQL_SELECT_RSVPPROMOCODE_WHERE);

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
				query.append(RsvpPromoCodeModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPromoCode>(list);
				}
				else {
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (rsvpPromoCode != null) {
			return rsvpPromoCode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPromoCodeException(msg.toString());
	}

	/**
	 * Returns the first rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpPromoCode> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (rsvpPromoCode != null) {
			return rsvpPromoCode;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPromoCodeException(msg.toString());
	}

	/**
	 * Returns the last rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RsvpPromoCode> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp promo codes before and after the current rsvp promo code in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rsvpPromoCodeId the primary key of the current rsvp promo code
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode[] findByUuid_C_PrevAndNext(long rsvpPromoCodeId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = findByPrimaryKey(rsvpPromoCodeId);

		Session session = null;

		try {
			session = openSession();

			RsvpPromoCode[] array = new RsvpPromoCodeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, rsvpPromoCode, uuid,
					companyId, orderByComparator, true);

			array[1] = rsvpPromoCode;

			array[2] = getByUuid_C_PrevAndNext(session, rsvpPromoCode, uuid,
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

	protected RsvpPromoCode getByUuid_C_PrevAndNext(Session session,
		RsvpPromoCode rsvpPromoCode, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPPROMOCODE_WHERE);

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
			query.append(RsvpPromoCodeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpPromoCode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpPromoCode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp promo codes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (RsvpPromoCode rsvpPromoCode : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpPromoCode);
		}
	}

	/**
	 * Returns the number of rsvp promo codes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rsvp promo codes
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

			query.append(_SQL_COUNT_RSVPPROMOCODE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "rsvpPromoCode.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "rsvpPromoCode.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(rsvpPromoCode.uuid IS NULL OR rsvpPromoCode.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "rsvpPromoCode.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPID = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrsvpId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID =
		new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByrsvpId", new String[] { Long.class.getName() },
			RsvpPromoCodeModelImpl.RSVPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPID = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrsvpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rsvp promo codes where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByrsvpId(long rsvpId)
		throws SystemException {
		return findByrsvpId(rsvpId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp promo codes where rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @return the range of matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByrsvpId(long rsvpId, int start, int end)
		throws SystemException {
		return findByrsvpId(rsvpId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp promo codes where rsvpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpId the rsvp ID
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByrsvpId(long rsvpId, int start, int end,
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

		List<RsvpPromoCode> list = (List<RsvpPromoCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpPromoCode rsvpPromoCode : list) {
				if ((rsvpId != rsvpPromoCode.getRsvpId())) {
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

			query.append(_SQL_SELECT_RSVPPROMOCODE_WHERE);

			query.append(_FINDER_COLUMN_RSVPID_RSVPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpPromoCodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				if (!pagination) {
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPromoCode>(list);
				}
				else {
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp promo code in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByrsvpId_First(long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByrsvpId_First(rsvpId,
				orderByComparator);

		if (rsvpPromoCode != null) {
			return rsvpPromoCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPromoCodeException(msg.toString());
	}

	/**
	 * Returns the first rsvp promo code in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByrsvpId_First(long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpPromoCode> list = findByrsvpId(rsvpId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp promo code in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByrsvpId_Last(long rsvpId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByrsvpId_Last(rsvpId,
				orderByComparator);

		if (rsvpPromoCode != null) {
			return rsvpPromoCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpId=");
		msg.append(rsvpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPromoCodeException(msg.toString());
	}

	/**
	 * Returns the last rsvp promo code in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByrsvpId_Last(long rsvpId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByrsvpId(rsvpId);

		if (count == 0) {
			return null;
		}

		List<RsvpPromoCode> list = findByrsvpId(rsvpId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp promo codes before and after the current rsvp promo code in the ordered set where rsvpId = &#63;.
	 *
	 * @param rsvpPromoCodeId the primary key of the current rsvp promo code
	 * @param rsvpId the rsvp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode[] findByrsvpId_PrevAndNext(long rsvpPromoCodeId,
		long rsvpId, OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = findByPrimaryKey(rsvpPromoCodeId);

		Session session = null;

		try {
			session = openSession();

			RsvpPromoCode[] array = new RsvpPromoCodeImpl[3];

			array[0] = getByrsvpId_PrevAndNext(session, rsvpPromoCode, rsvpId,
					orderByComparator, true);

			array[1] = rsvpPromoCode;

			array[2] = getByrsvpId_PrevAndNext(session, rsvpPromoCode, rsvpId,
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

	protected RsvpPromoCode getByrsvpId_PrevAndNext(Session session,
		RsvpPromoCode rsvpPromoCode, long rsvpId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPPROMOCODE_WHERE);

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
			query.append(RsvpPromoCodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpPromoCode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpPromoCode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp promo codes where rsvpId = &#63; from the database.
	 *
	 * @param rsvpId the rsvp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByrsvpId(long rsvpId) throws SystemException {
		for (RsvpPromoCode rsvpPromoCode : findByrsvpId(rsvpId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpPromoCode);
		}
	}

	/**
	 * Returns the number of rsvp promo codes where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the number of matching rsvp promo codes
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

			query.append(_SQL_COUNT_RSVPPROMOCODE_WHERE);

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

	private static final String _FINDER_COLUMN_RSVPID_RSVPID_2 = "rsvpPromoCode.rsvpId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROMOCODE =
		new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPromoCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOCODE =
		new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPromoCode", new String[] { String.class.getName() },
			RsvpPromoCodeModelImpl.PROMOCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROMOCODE = new FinderPath(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPromoCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rsvp promo codes where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @return the matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByPromoCode(String promoCode)
		throws SystemException {
		return findByPromoCode(promoCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the rsvp promo codes where promoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param promoCode the promo code
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @return the range of matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByPromoCode(String promoCode, int start,
		int end) throws SystemException {
		return findByPromoCode(promoCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp promo codes where promoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param promoCode the promo code
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findByPromoCode(String promoCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOCODE;
			finderArgs = new Object[] { promoCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROMOCODE;
			finderArgs = new Object[] { promoCode, start, end, orderByComparator };
		}

		List<RsvpPromoCode> list = (List<RsvpPromoCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpPromoCode rsvpPromoCode : list) {
				if (!Validator.equals(promoCode, rsvpPromoCode.getPromoCode())) {
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

			query.append(_SQL_SELECT_RSVPPROMOCODE_WHERE);

			boolean bindPromoCode = false;

			if (promoCode == null) {
				query.append(_FINDER_COLUMN_PROMOCODE_PROMOCODE_1);
			}
			else if (promoCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROMOCODE_PROMOCODE_3);
			}
			else {
				bindPromoCode = true;

				query.append(_FINDER_COLUMN_PROMOCODE_PROMOCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpPromoCodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPromoCode) {
					qPos.add(promoCode);
				}

				if (!pagination) {
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPromoCode>(list);
				}
				else {
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByPromoCode_First(String promoCode,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByPromoCode_First(promoCode,
				orderByComparator);

		if (rsvpPromoCode != null) {
			return rsvpPromoCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("promoCode=");
		msg.append(promoCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPromoCodeException(msg.toString());
	}

	/**
	 * Returns the first rsvp promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByPromoCode_First(String promoCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpPromoCode> list = findByPromoCode(promoCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByPromoCode_Last(String promoCode,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByPromoCode_Last(promoCode,
				orderByComparator);

		if (rsvpPromoCode != null) {
			return rsvpPromoCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("promoCode=");
		msg.append(promoCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPromoCodeException(msg.toString());
	}

	/**
	 * Returns the last rsvp promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByPromoCode_Last(String promoCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPromoCode(promoCode);

		if (count == 0) {
			return null;
		}

		List<RsvpPromoCode> list = findByPromoCode(promoCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp promo codes before and after the current rsvp promo code in the ordered set where promoCode = &#63;.
	 *
	 * @param rsvpPromoCodeId the primary key of the current rsvp promo code
	 * @param promoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode[] findByPromoCode_PrevAndNext(long rsvpPromoCodeId,
		String promoCode, OrderByComparator orderByComparator)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = findByPrimaryKey(rsvpPromoCodeId);

		Session session = null;

		try {
			session = openSession();

			RsvpPromoCode[] array = new RsvpPromoCodeImpl[3];

			array[0] = getByPromoCode_PrevAndNext(session, rsvpPromoCode,
					promoCode, orderByComparator, true);

			array[1] = rsvpPromoCode;

			array[2] = getByPromoCode_PrevAndNext(session, rsvpPromoCode,
					promoCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RsvpPromoCode getByPromoCode_PrevAndNext(Session session,
		RsvpPromoCode rsvpPromoCode, String promoCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPPROMOCODE_WHERE);

		boolean bindPromoCode = false;

		if (promoCode == null) {
			query.append(_FINDER_COLUMN_PROMOCODE_PROMOCODE_1);
		}
		else if (promoCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PROMOCODE_PROMOCODE_3);
		}
		else {
			bindPromoCode = true;

			query.append(_FINDER_COLUMN_PROMOCODE_PROMOCODE_2);
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
			query.append(RsvpPromoCodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPromoCode) {
			qPos.add(promoCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpPromoCode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpPromoCode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp promo codes where promoCode = &#63; from the database.
	 *
	 * @param promoCode the promo code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPromoCode(String promoCode) throws SystemException {
		for (RsvpPromoCode rsvpPromoCode : findByPromoCode(promoCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpPromoCode);
		}
	}

	/**
	 * Returns the number of rsvp promo codes where promoCode = &#63;.
	 *
	 * @param promoCode the promo code
	 * @return the number of matching rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPromoCode(String promoCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROMOCODE;

		Object[] finderArgs = new Object[] { promoCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RSVPPROMOCODE_WHERE);

			boolean bindPromoCode = false;

			if (promoCode == null) {
				query.append(_FINDER_COLUMN_PROMOCODE_PROMOCODE_1);
			}
			else if (promoCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROMOCODE_PROMOCODE_3);
			}
			else {
				bindPromoCode = true;

				query.append(_FINDER_COLUMN_PROMOCODE_PROMOCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPromoCode) {
					qPos.add(promoCode);
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

	private static final String _FINDER_COLUMN_PROMOCODE_PROMOCODE_1 = "rsvpPromoCode.promoCode IS NULL";
	private static final String _FINDER_COLUMN_PROMOCODE_PROMOCODE_2 = "rsvpPromoCode.promoCode = ?";
	private static final String _FINDER_COLUMN_PROMOCODE_PROMOCODE_3 = "(rsvpPromoCode.promoCode IS NULL OR rsvpPromoCode.promoCode = '')";

	public RsvpPromoCodePersistenceImpl() {
		setModelClass(RsvpPromoCode.class);
	}

	/**
	 * Caches the rsvp promo code in the entity cache if it is enabled.
	 *
	 * @param rsvpPromoCode the rsvp promo code
	 */
	@Override
	public void cacheResult(RsvpPromoCode rsvpPromoCode) {
		EntityCacheUtil.putResult(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, rsvpPromoCode.getPrimaryKey(),
			rsvpPromoCode);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { rsvpPromoCode.getUuid(), rsvpPromoCode.getGroupId() },
			rsvpPromoCode);

		rsvpPromoCode.resetOriginalValues();
	}

	/**
	 * Caches the rsvp promo codes in the entity cache if it is enabled.
	 *
	 * @param rsvpPromoCodes the rsvp promo codes
	 */
	@Override
	public void cacheResult(List<RsvpPromoCode> rsvpPromoCodes) {
		for (RsvpPromoCode rsvpPromoCode : rsvpPromoCodes) {
			if (EntityCacheUtil.getResult(
						RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
						RsvpPromoCodeImpl.class, rsvpPromoCode.getPrimaryKey()) == null) {
				cacheResult(rsvpPromoCode);
			}
			else {
				rsvpPromoCode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rsvp promo codes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RsvpPromoCodeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RsvpPromoCodeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rsvp promo code.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RsvpPromoCode rsvpPromoCode) {
		EntityCacheUtil.removeResult(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, rsvpPromoCode.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rsvpPromoCode);
	}

	@Override
	public void clearCache(List<RsvpPromoCode> rsvpPromoCodes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RsvpPromoCode rsvpPromoCode : rsvpPromoCodes) {
			EntityCacheUtil.removeResult(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
				RsvpPromoCodeImpl.class, rsvpPromoCode.getPrimaryKey());

			clearUniqueFindersCache(rsvpPromoCode);
		}
	}

	protected void cacheUniqueFindersCache(RsvpPromoCode rsvpPromoCode) {
		if (rsvpPromoCode.isNew()) {
			Object[] args = new Object[] {
					rsvpPromoCode.getUuid(), rsvpPromoCode.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				rsvpPromoCode);
		}
		else {
			RsvpPromoCodeModelImpl rsvpPromoCodeModelImpl = (RsvpPromoCodeModelImpl)rsvpPromoCode;

			if ((rsvpPromoCodeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPromoCode.getUuid(), rsvpPromoCode.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					rsvpPromoCode);
			}
		}
	}

	protected void clearUniqueFindersCache(RsvpPromoCode rsvpPromoCode) {
		RsvpPromoCodeModelImpl rsvpPromoCodeModelImpl = (RsvpPromoCodeModelImpl)rsvpPromoCode;

		Object[] args = new Object[] {
				rsvpPromoCode.getUuid(), rsvpPromoCode.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((rsvpPromoCodeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					rsvpPromoCodeModelImpl.getOriginalUuid(),
					rsvpPromoCodeModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new rsvp promo code with the primary key. Does not add the rsvp promo code to the database.
	 *
	 * @param rsvpPromoCodeId the primary key for the new rsvp promo code
	 * @return the new rsvp promo code
	 */
	@Override
	public RsvpPromoCode create(long rsvpPromoCodeId) {
		RsvpPromoCode rsvpPromoCode = new RsvpPromoCodeImpl();

		rsvpPromoCode.setNew(true);
		rsvpPromoCode.setPrimaryKey(rsvpPromoCodeId);

		String uuid = PortalUUIDUtil.generate();

		rsvpPromoCode.setUuid(uuid);

		return rsvpPromoCode;
	}

	/**
	 * Removes the rsvp promo code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rsvpPromoCodeId the primary key of the rsvp promo code
	 * @return the rsvp promo code that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode remove(long rsvpPromoCodeId)
		throws NoSuchRsvpPromoCodeException, SystemException {
		return remove((Serializable)rsvpPromoCodeId);
	}

	/**
	 * Removes the rsvp promo code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rsvp promo code
	 * @return the rsvp promo code that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode remove(Serializable primaryKey)
		throws NoSuchRsvpPromoCodeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RsvpPromoCode rsvpPromoCode = (RsvpPromoCode)session.get(RsvpPromoCodeImpl.class,
					primaryKey);

			if (rsvpPromoCode == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRsvpPromoCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rsvpPromoCode);
		}
		catch (NoSuchRsvpPromoCodeException nsee) {
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
	protected RsvpPromoCode removeImpl(RsvpPromoCode rsvpPromoCode)
		throws SystemException {
		rsvpPromoCode = toUnwrappedModel(rsvpPromoCode);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rsvpPromoCode)) {
				rsvpPromoCode = (RsvpPromoCode)session.get(RsvpPromoCodeImpl.class,
						rsvpPromoCode.getPrimaryKeyObj());
			}

			if (rsvpPromoCode != null) {
				session.delete(rsvpPromoCode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rsvpPromoCode != null) {
			clearCache(rsvpPromoCode);
		}

		return rsvpPromoCode;
	}

	@Override
	public RsvpPromoCode updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpPromoCode rsvpPromoCode)
		throws SystemException {
		rsvpPromoCode = toUnwrappedModel(rsvpPromoCode);

		boolean isNew = rsvpPromoCode.isNew();

		RsvpPromoCodeModelImpl rsvpPromoCodeModelImpl = (RsvpPromoCodeModelImpl)rsvpPromoCode;

		if (Validator.isNull(rsvpPromoCode.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rsvpPromoCode.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (rsvpPromoCode.isNew()) {
				session.save(rsvpPromoCode);

				rsvpPromoCode.setNew(false);
			}
			else {
				session.merge(rsvpPromoCode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RsvpPromoCodeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rsvpPromoCodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPromoCodeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { rsvpPromoCodeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((rsvpPromoCodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPromoCodeModelImpl.getOriginalUuid(),
						rsvpPromoCodeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						rsvpPromoCodeModelImpl.getUuid(),
						rsvpPromoCodeModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((rsvpPromoCodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPromoCodeModelImpl.getOriginalRsvpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID,
					args);

				args = new Object[] { rsvpPromoCodeModelImpl.getRsvpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPID,
					args);
			}

			if ((rsvpPromoCodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPromoCodeModelImpl.getOriginalPromoCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROMOCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOCODE,
					args);

				args = new Object[] { rsvpPromoCodeModelImpl.getPromoCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROMOCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPromoCodeImpl.class, rsvpPromoCode.getPrimaryKey(),
			rsvpPromoCode);

		clearUniqueFindersCache(rsvpPromoCode);
		cacheUniqueFindersCache(rsvpPromoCode);

		return rsvpPromoCode;
	}

	protected RsvpPromoCode toUnwrappedModel(RsvpPromoCode rsvpPromoCode) {
		if (rsvpPromoCode instanceof RsvpPromoCodeImpl) {
			return rsvpPromoCode;
		}

		RsvpPromoCodeImpl rsvpPromoCodeImpl = new RsvpPromoCodeImpl();

		rsvpPromoCodeImpl.setNew(rsvpPromoCode.isNew());
		rsvpPromoCodeImpl.setPrimaryKey(rsvpPromoCode.getPrimaryKey());

		rsvpPromoCodeImpl.setUuid(rsvpPromoCode.getUuid());
		rsvpPromoCodeImpl.setRsvpPromoCodeId(rsvpPromoCode.getRsvpPromoCodeId());
		rsvpPromoCodeImpl.setGroupId(rsvpPromoCode.getGroupId());
		rsvpPromoCodeImpl.setCompanyId(rsvpPromoCode.getCompanyId());
		rsvpPromoCodeImpl.setUserId(rsvpPromoCode.getUserId());
		rsvpPromoCodeImpl.setUserName(rsvpPromoCode.getUserName());
		rsvpPromoCodeImpl.setCreateDate(rsvpPromoCode.getCreateDate());
		rsvpPromoCodeImpl.setModifiedDate(rsvpPromoCode.getModifiedDate());
		rsvpPromoCodeImpl.setRsvpId(rsvpPromoCode.getRsvpId());
		rsvpPromoCodeImpl.setRsvpTicketId(rsvpPromoCode.getRsvpTicketId());
		rsvpPromoCodeImpl.setPromoCode(rsvpPromoCode.getPromoCode());
		rsvpPromoCodeImpl.setFromDate(rsvpPromoCode.getFromDate());
		rsvpPromoCodeImpl.setToDate(rsvpPromoCode.getToDate());
		rsvpPromoCodeImpl.setNoOfTickets(rsvpPromoCode.getNoOfTickets());
		rsvpPromoCodeImpl.setDiscount(rsvpPromoCode.getDiscount());
		rsvpPromoCodeImpl.setModifiedBy(rsvpPromoCode.getModifiedBy());

		return rsvpPromoCodeImpl;
	}

	/**
	 * Returns the rsvp promo code with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp promo code
	 * @return the rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRsvpPromoCodeException, SystemException {
		RsvpPromoCode rsvpPromoCode = fetchByPrimaryKey(primaryKey);

		if (rsvpPromoCode == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRsvpPromoCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rsvpPromoCode;
	}

	/**
	 * Returns the rsvp promo code with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException} if it could not be found.
	 *
	 * @param rsvpPromoCodeId the primary key of the rsvp promo code
	 * @return the rsvp promo code
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPromoCodeException if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode findByPrimaryKey(long rsvpPromoCodeId)
		throws NoSuchRsvpPromoCodeException, SystemException {
		return findByPrimaryKey((Serializable)rsvpPromoCodeId);
	}

	/**
	 * Returns the rsvp promo code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp promo code
	 * @return the rsvp promo code, or <code>null</code> if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RsvpPromoCode rsvpPromoCode = (RsvpPromoCode)EntityCacheUtil.getResult(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
				RsvpPromoCodeImpl.class, primaryKey);

		if (rsvpPromoCode == _nullRsvpPromoCode) {
			return null;
		}

		if (rsvpPromoCode == null) {
			Session session = null;

			try {
				session = openSession();

				rsvpPromoCode = (RsvpPromoCode)session.get(RsvpPromoCodeImpl.class,
						primaryKey);

				if (rsvpPromoCode != null) {
					cacheResult(rsvpPromoCode);
				}
				else {
					EntityCacheUtil.putResult(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
						RsvpPromoCodeImpl.class, primaryKey, _nullRsvpPromoCode);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RsvpPromoCodeModelImpl.ENTITY_CACHE_ENABLED,
					RsvpPromoCodeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rsvpPromoCode;
	}

	/**
	 * Returns the rsvp promo code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rsvpPromoCodeId the primary key of the rsvp promo code
	 * @return the rsvp promo code, or <code>null</code> if a rsvp promo code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPromoCode fetchByPrimaryKey(long rsvpPromoCodeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)rsvpPromoCodeId);
	}

	/**
	 * Returns all the rsvp promo codes.
	 *
	 * @return the rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp promo codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @return the range of rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp promo codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp promo codes
	 * @param end the upper bound of the range of rsvp promo codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rsvp promo codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPromoCode> findAll(int start, int end,
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

		List<RsvpPromoCode> list = (List<RsvpPromoCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RSVPPROMOCODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RSVPPROMOCODE;

				if (pagination) {
					sql = sql.concat(RsvpPromoCodeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPromoCode>(list);
				}
				else {
					list = (List<RsvpPromoCode>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rsvp promo codes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RsvpPromoCode rsvpPromoCode : findAll()) {
			remove(rsvpPromoCode);
		}
	}

	/**
	 * Returns the number of rsvp promo codes.
	 *
	 * @return the number of rsvp promo codes
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

				Query q = session.createQuery(_SQL_COUNT_RSVPPROMOCODE);

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
	 * Initializes the rsvp promo code persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.rsvp.model.RsvpPromoCode")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RsvpPromoCode>> listenersList = new ArrayList<ModelListener<RsvpPromoCode>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RsvpPromoCode>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RsvpPromoCodeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RSVPPROMOCODE = "SELECT rsvpPromoCode FROM RsvpPromoCode rsvpPromoCode";
	private static final String _SQL_SELECT_RSVPPROMOCODE_WHERE = "SELECT rsvpPromoCode FROM RsvpPromoCode rsvpPromoCode WHERE ";
	private static final String _SQL_COUNT_RSVPPROMOCODE = "SELECT COUNT(rsvpPromoCode) FROM RsvpPromoCode rsvpPromoCode";
	private static final String _SQL_COUNT_RSVPPROMOCODE_WHERE = "SELECT COUNT(rsvpPromoCode) FROM RsvpPromoCode rsvpPromoCode WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rsvpPromoCode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RsvpPromoCode exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RsvpPromoCode exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RsvpPromoCodePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "rsvpPromoCodeId", "rsvpId", "rsvpTicketId"
			});
	private static RsvpPromoCode _nullRsvpPromoCode = new RsvpPromoCodeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RsvpPromoCode> toCacheModel() {
				return _nullRsvpPromoCodeCacheModel;
			}
		};

	private static CacheModel<RsvpPromoCode> _nullRsvpPromoCodeCacheModel = new CacheModel<RsvpPromoCode>() {
			@Override
			public RsvpPromoCode toEntityModel() {
				return _nullRsvpPromoCode;
			}
		};
}