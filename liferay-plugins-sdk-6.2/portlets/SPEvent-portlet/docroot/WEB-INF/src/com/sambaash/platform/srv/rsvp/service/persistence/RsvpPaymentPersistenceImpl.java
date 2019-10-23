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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;
import com.sambaash.platform.srv.rsvp.model.RsvpPayment;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentImpl;
import com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rsvp payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPaymentPersistence
 * @see RsvpPaymentUtil
 * @generated
 */
public class RsvpPaymentPersistenceImpl extends BasePersistenceImpl<RsvpPayment>
	implements RsvpPaymentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RsvpPaymentUtil} to access the rsvp payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RsvpPaymentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RsvpPaymentModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rsvp payments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp payments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @return the range of matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp payments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByUuid(String uuid, int start, int end,
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

		List<RsvpPayment> list = (List<RsvpPayment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpPayment rsvpPayment : list) {
				if (!Validator.equals(uuid, rsvpPayment.getUuid())) {
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

			query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

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
				query.append(RsvpPaymentModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPayment>(list);
				}
				else {
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp payment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByUuid_First(uuid, orderByComparator);

		if (rsvpPayment != null) {
			return rsvpPayment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPaymentException(msg.toString());
	}

	/**
	 * Returns the first rsvp payment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpPayment> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp payment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByUuid_Last(uuid, orderByComparator);

		if (rsvpPayment != null) {
			return rsvpPayment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPaymentException(msg.toString());
	}

	/**
	 * Returns the last rsvp payment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RsvpPayment> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp payments before and after the current rsvp payment in the ordered set where uuid = &#63;.
	 *
	 * @param rsvpPaymentId the primary key of the current rsvp payment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment[] findByUuid_PrevAndNext(long rsvpPaymentId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = findByPrimaryKey(rsvpPaymentId);

		Session session = null;

		try {
			session = openSession();

			RsvpPayment[] array = new RsvpPaymentImpl[3];

			array[0] = getByUuid_PrevAndNext(session, rsvpPayment, uuid,
					orderByComparator, true);

			array[1] = rsvpPayment;

			array[2] = getByUuid_PrevAndNext(session, rsvpPayment, uuid,
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

	protected RsvpPayment getByUuid_PrevAndNext(Session session,
		RsvpPayment rsvpPayment, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

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
			query.append(RsvpPaymentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpPayment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpPayment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp payments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RsvpPayment rsvpPayment : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvpPayment);
		}
	}

	/**
	 * Returns the number of rsvp payments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rsvp payments
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

			query.append(_SQL_COUNT_RSVPPAYMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "rsvpPayment.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "rsvpPayment.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(rsvpPayment.uuid IS NULL OR rsvpPayment.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpPaymentModelImpl.UUID_COLUMN_BITMASK |
			RsvpPaymentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rsvp payment where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByUUID_G(uuid, groupId);

		if (rsvpPayment == null) {
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

			throw new NoSuchRsvpPaymentException(msg.toString());
		}

		return rsvpPayment;
	}

	/**
	 * Returns the rsvp payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rsvp payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RsvpPayment) {
			RsvpPayment rsvpPayment = (RsvpPayment)result;

			if (!Validator.equals(uuid, rsvpPayment.getUuid()) ||
					(groupId != rsvpPayment.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

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

				List<RsvpPayment> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RsvpPayment rsvpPayment = list.get(0);

					result = rsvpPayment;

					cacheResult(rsvpPayment);

					if ((rsvpPayment.getUuid() == null) ||
							!rsvpPayment.getUuid().equals(uuid) ||
							(rsvpPayment.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, rsvpPayment);
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
			return (RsvpPayment)result;
		}
	}

	/**
	 * Removes the rsvp payment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rsvp payment that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment removeByUUID_G(String uuid, long groupId)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = findByUUID_G(uuid, groupId);

		return remove(rsvpPayment);
	}

	/**
	 * Returns the number of rsvp payments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rsvp payments
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

			query.append(_SQL_COUNT_RSVPPAYMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "rsvpPayment.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "rsvpPayment.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(rsvpPayment.uuid IS NULL OR rsvpPayment.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "rsvpPayment.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RsvpPaymentModelImpl.UUID_COLUMN_BITMASK |
			RsvpPaymentModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rsvp payments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp payments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @return the range of matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp payments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByUuid_C(String uuid, long companyId,
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

		List<RsvpPayment> list = (List<RsvpPayment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpPayment rsvpPayment : list) {
				if (!Validator.equals(uuid, rsvpPayment.getUuid()) ||
						(companyId != rsvpPayment.getCompanyId())) {
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

			query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

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
				query.append(RsvpPaymentModelImpl.ORDER_BY_JPQL);
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
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPayment>(list);
				}
				else {
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (rsvpPayment != null) {
			return rsvpPayment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPaymentException(msg.toString());
	}

	/**
	 * Returns the first rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpPayment> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (rsvpPayment != null) {
			return rsvpPayment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPaymentException(msg.toString());
	}

	/**
	 * Returns the last rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RsvpPayment> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp payments before and after the current rsvp payment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rsvpPaymentId the primary key of the current rsvp payment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment[] findByUuid_C_PrevAndNext(long rsvpPaymentId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = findByPrimaryKey(rsvpPaymentId);

		Session session = null;

		try {
			session = openSession();

			RsvpPayment[] array = new RsvpPaymentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, rsvpPayment, uuid,
					companyId, orderByComparator, true);

			array[1] = rsvpPayment;

			array[2] = getByUuid_C_PrevAndNext(session, rsvpPayment, uuid,
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

	protected RsvpPayment getByUuid_C_PrevAndNext(Session session,
		RsvpPayment rsvpPayment, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

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
			query.append(RsvpPaymentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpPayment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpPayment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp payments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (RsvpPayment rsvpPayment : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpPayment);
		}
	}

	/**
	 * Returns the number of rsvp payments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rsvp payments
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

			query.append(_SQL_COUNT_RSVPPAYMENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "rsvpPayment.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "rsvpPayment.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(rsvpPayment.uuid IS NULL OR rsvpPayment.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "rsvpPayment.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPDETAILID =
		new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRsvpDetailId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILID =
		new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRsvpDetailId",
			new String[] { Long.class.getName() },
			RsvpPaymentModelImpl.RSVPDETAILID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPDETAILID = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRsvpDetailId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rsvp payments where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @return the matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByRsvpDetailId(long rsvpDetailId)
		throws SystemException {
		return findByRsvpDetailId(rsvpDetailId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp payments where rsvpDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @return the range of matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByRsvpDetailId(long rsvpDetailId, int start,
		int end) throws SystemException {
		return findByRsvpDetailId(rsvpDetailId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp payments where rsvpDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByRsvpDetailId(long rsvpDetailId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<RsvpPayment> list = (List<RsvpPayment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpPayment rsvpPayment : list) {
				if ((rsvpDetailId != rsvpPayment.getRsvpDetailId())) {
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

			query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

			query.append(_FINDER_COLUMN_RSVPDETAILID_RSVPDETAILID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpPaymentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpDetailId);

				if (!pagination) {
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPayment>(list);
				}
				else {
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByRsvpDetailId_First(long rsvpDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByRsvpDetailId_First(rsvpDetailId,
				orderByComparator);

		if (rsvpPayment != null) {
			return rsvpPayment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpDetailId=");
		msg.append(rsvpDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPaymentException(msg.toString());
	}

	/**
	 * Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByRsvpDetailId_First(long rsvpDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpPayment> list = findByRsvpDetailId(rsvpDetailId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByRsvpDetailId_Last(long rsvpDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByRsvpDetailId_Last(rsvpDetailId,
				orderByComparator);

		if (rsvpPayment != null) {
			return rsvpPayment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpDetailId=");
		msg.append(rsvpDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPaymentException(msg.toString());
	}

	/**
	 * Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByRsvpDetailId_Last(long rsvpDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRsvpDetailId(rsvpDetailId);

		if (count == 0) {
			return null;
		}

		List<RsvpPayment> list = findByRsvpDetailId(rsvpDetailId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp payments before and after the current rsvp payment in the ordered set where rsvpDetailId = &#63;.
	 *
	 * @param rsvpPaymentId the primary key of the current rsvp payment
	 * @param rsvpDetailId the rsvp detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment[] findByRsvpDetailId_PrevAndNext(long rsvpPaymentId,
		long rsvpDetailId, OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = findByPrimaryKey(rsvpPaymentId);

		Session session = null;

		try {
			session = openSession();

			RsvpPayment[] array = new RsvpPaymentImpl[3];

			array[0] = getByRsvpDetailId_PrevAndNext(session, rsvpPayment,
					rsvpDetailId, orderByComparator, true);

			array[1] = rsvpPayment;

			array[2] = getByRsvpDetailId_PrevAndNext(session, rsvpPayment,
					rsvpDetailId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RsvpPayment getByRsvpDetailId_PrevAndNext(Session session,
		RsvpPayment rsvpPayment, long rsvpDetailId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

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
			query.append(RsvpPaymentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpDetailId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpPayment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpPayment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp payments where rsvpDetailId = &#63; from the database.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRsvpDetailId(long rsvpDetailId)
		throws SystemException {
		for (RsvpPayment rsvpPayment : findByRsvpDetailId(rsvpDetailId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rsvpPayment);
		}
	}

	/**
	 * Returns the number of rsvp payments where rsvpDetailId = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @return the number of matching rsvp payments
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

			query.append(_SQL_COUNT_RSVPPAYMENT_WHERE);

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

	private static final String _FINDER_COLUMN_RSVPDETAILID_RSVPDETAILID_2 = "rsvpPayment.rsvpDetailId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TICKETNUMBER = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTicketNumber",
			new String[] { String.class.getName() },
			RsvpPaymentModelImpl.TICKETNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TICKETNUMBER = new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketNumber",
			new String[] { String.class.getName() });

	/**
	 * Returns the rsvp payment where ticketNumber = &#63; or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException} if it could not be found.
	 *
	 * @param ticketNumber the ticket number
	 * @return the matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByTicketNumber(String ticketNumber)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByTicketNumber(ticketNumber);

		if (rsvpPayment == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ticketNumber=");
			msg.append(ticketNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRsvpPaymentException(msg.toString());
		}

		return rsvpPayment;
	}

	/**
	 * Returns the rsvp payment where ticketNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketNumber the ticket number
	 * @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByTicketNumber(String ticketNumber)
		throws SystemException {
		return fetchByTicketNumber(ticketNumber, true);
	}

	/**
	 * Returns the rsvp payment where ticketNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketNumber the ticket number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByTicketNumber(String ticketNumber,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ticketNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
					finderArgs, this);
		}

		if (result instanceof RsvpPayment) {
			RsvpPayment rsvpPayment = (RsvpPayment)result;

			if (!Validator.equals(ticketNumber, rsvpPayment.getTicketNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

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

				List<RsvpPayment> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
						finderArgs, list);
				}
				else {
					RsvpPayment rsvpPayment = list.get(0);

					result = rsvpPayment;

					cacheResult(rsvpPayment);

					if ((rsvpPayment.getTicketNumber() == null) ||
							!rsvpPayment.getTicketNumber().equals(ticketNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
							finderArgs, rsvpPayment);
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
			return (RsvpPayment)result;
		}
	}

	/**
	 * Removes the rsvp payment where ticketNumber = &#63; from the database.
	 *
	 * @param ticketNumber the ticket number
	 * @return the rsvp payment that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment removeByTicketNumber(String ticketNumber)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = findByTicketNumber(ticketNumber);

		return remove(rsvpPayment);
	}

	/**
	 * Returns the number of rsvp payments where ticketNumber = &#63;.
	 *
	 * @param ticketNumber the ticket number
	 * @return the number of matching rsvp payments
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

			query.append(_SQL_COUNT_RSVPPAYMENT_WHERE);

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

	private static final String _FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_1 = "rsvpPayment.ticketNumber IS NULL";
	private static final String _FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_2 = "rsvpPayment.ticketNumber = ?";
	private static final String _FINDER_COLUMN_TICKETNUMBER_TICKETNUMBER_3 = "(rsvpPayment.ticketNumber IS NULL OR rsvpPayment.ticketNumber = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPDETAILIDTRANSACTIONSTATUS =
		new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRsvpDetailIdTransactionStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDTRANSACTIONSTATUS =
		new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, RsvpPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRsvpDetailIdTransactionStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			RsvpPaymentModelImpl.RSVPDETAILID_COLUMN_BITMASK |
			RsvpPaymentModelImpl.TRANSACTIONSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPDETAILIDTRANSACTIONSTATUS =
		new FinderPath(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRsvpDetailIdTransactionStatus",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @return the matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, String transactionStatus) throws SystemException {
		return findByRsvpDetailIdTransactionStatus(rsvpDetailId,
			transactionStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @return the range of matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, String transactionStatus, int start, int end)
		throws SystemException {
		return findByRsvpDetailIdTransactionStatus(rsvpDetailId,
			transactionStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findByRsvpDetailIdTransactionStatus(
		long rsvpDetailId, String transactionStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDTRANSACTIONSTATUS;
			finderArgs = new Object[] { rsvpDetailId, transactionStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RSVPDETAILIDTRANSACTIONSTATUS;
			finderArgs = new Object[] {
					rsvpDetailId, transactionStatus,
					
					start, end, orderByComparator
				};
		}

		List<RsvpPayment> list = (List<RsvpPayment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RsvpPayment rsvpPayment : list) {
				if ((rsvpDetailId != rsvpPayment.getRsvpDetailId()) ||
						!Validator.equals(transactionStatus,
							rsvpPayment.getTransactionStatus())) {
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

			query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

			query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_RSVPDETAILID_2);

			boolean bindTransactionStatus = false;

			if (transactionStatus == null) {
				query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_1);
			}
			else if (transactionStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_3);
			}
			else {
				bindTransactionStatus = true;

				query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RsvpPaymentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpDetailId);

				if (bindTransactionStatus) {
					qPos.add(transactionStatus);
				}

				if (!pagination) {
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPayment>(list);
				}
				else {
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByRsvpDetailIdTransactionStatus_First(
		long rsvpDetailId, String transactionStatus,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByRsvpDetailIdTransactionStatus_First(rsvpDetailId,
				transactionStatus, orderByComparator);

		if (rsvpPayment != null) {
			return rsvpPayment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpDetailId=");
		msg.append(rsvpDetailId);

		msg.append(", transactionStatus=");
		msg.append(transactionStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPaymentException(msg.toString());
	}

	/**
	 * Returns the first rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByRsvpDetailIdTransactionStatus_First(
		long rsvpDetailId, String transactionStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<RsvpPayment> list = findByRsvpDetailIdTransactionStatus(rsvpDetailId,
				transactionStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByRsvpDetailIdTransactionStatus_Last(
		long rsvpDetailId, String transactionStatus,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByRsvpDetailIdTransactionStatus_Last(rsvpDetailId,
				transactionStatus, orderByComparator);

		if (rsvpPayment != null) {
			return rsvpPayment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rsvpDetailId=");
		msg.append(rsvpDetailId);

		msg.append(", transactionStatus=");
		msg.append(transactionStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRsvpPaymentException(msg.toString());
	}

	/**
	 * Returns the last rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rsvp payment, or <code>null</code> if a matching rsvp payment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByRsvpDetailIdTransactionStatus_Last(
		long rsvpDetailId, String transactionStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRsvpDetailIdTransactionStatus(rsvpDetailId,
				transactionStatus);

		if (count == 0) {
			return null;
		}

		List<RsvpPayment> list = findByRsvpDetailIdTransactionStatus(rsvpDetailId,
				transactionStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rsvp payments before and after the current rsvp payment in the ordered set where rsvpDetailId = &#63; and transactionStatus = &#63;.
	 *
	 * @param rsvpPaymentId the primary key of the current rsvp payment
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment[] findByRsvpDetailIdTransactionStatus_PrevAndNext(
		long rsvpPaymentId, long rsvpDetailId, String transactionStatus,
		OrderByComparator orderByComparator)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = findByPrimaryKey(rsvpPaymentId);

		Session session = null;

		try {
			session = openSession();

			RsvpPayment[] array = new RsvpPaymentImpl[3];

			array[0] = getByRsvpDetailIdTransactionStatus_PrevAndNext(session,
					rsvpPayment, rsvpDetailId, transactionStatus,
					orderByComparator, true);

			array[1] = rsvpPayment;

			array[2] = getByRsvpDetailIdTransactionStatus_PrevAndNext(session,
					rsvpPayment, rsvpDetailId, transactionStatus,
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

	protected RsvpPayment getByRsvpDetailIdTransactionStatus_PrevAndNext(
		Session session, RsvpPayment rsvpPayment, long rsvpDetailId,
		String transactionStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RSVPPAYMENT_WHERE);

		query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_RSVPDETAILID_2);

		boolean bindTransactionStatus = false;

		if (transactionStatus == null) {
			query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_1);
		}
		else if (transactionStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_3);
		}
		else {
			bindTransactionStatus = true;

			query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_2);
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
			query.append(RsvpPaymentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rsvpDetailId);

		if (bindTransactionStatus) {
			qPos.add(transactionStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rsvpPayment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RsvpPayment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63; from the database.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRsvpDetailIdTransactionStatus(long rsvpDetailId,
		String transactionStatus) throws SystemException {
		for (RsvpPayment rsvpPayment : findByRsvpDetailIdTransactionStatus(
				rsvpDetailId, transactionStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rsvpPayment);
		}
	}

	/**
	 * Returns the number of rsvp payments where rsvpDetailId = &#63; and transactionStatus = &#63;.
	 *
	 * @param rsvpDetailId the rsvp detail ID
	 * @param transactionStatus the transaction status
	 * @return the number of matching rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRsvpDetailIdTransactionStatus(long rsvpDetailId,
		String transactionStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RSVPDETAILIDTRANSACTIONSTATUS;

		Object[] finderArgs = new Object[] { rsvpDetailId, transactionStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RSVPPAYMENT_WHERE);

			query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_RSVPDETAILID_2);

			boolean bindTransactionStatus = false;

			if (transactionStatus == null) {
				query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_1);
			}
			else if (transactionStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_3);
			}
			else {
				bindTransactionStatus = true;

				query.append(_FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpDetailId);

				if (bindTransactionStatus) {
					qPos.add(transactionStatus);
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

	private static final String _FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_RSVPDETAILID_2 =
		"rsvpPayment.rsvpDetailId = ? AND ";
	private static final String _FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_1 =
		"rsvpPayment.transactionStatus IS NULL";
	private static final String _FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_2 =
		"rsvpPayment.transactionStatus = ?";
	private static final String _FINDER_COLUMN_RSVPDETAILIDTRANSACTIONSTATUS_TRANSACTIONSTATUS_3 =
		"(rsvpPayment.transactionStatus IS NULL OR rsvpPayment.transactionStatus = '')";

	public RsvpPaymentPersistenceImpl() {
		setModelClass(RsvpPayment.class);
	}

	/**
	 * Caches the rsvp payment in the entity cache if it is enabled.
	 *
	 * @param rsvpPayment the rsvp payment
	 */
	@Override
	public void cacheResult(RsvpPayment rsvpPayment) {
		EntityCacheUtil.putResult(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentImpl.class, rsvpPayment.getPrimaryKey(), rsvpPayment);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { rsvpPayment.getUuid(), rsvpPayment.getGroupId() },
			rsvpPayment);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
			new Object[] { rsvpPayment.getTicketNumber() }, rsvpPayment);

		rsvpPayment.resetOriginalValues();
	}

	/**
	 * Caches the rsvp payments in the entity cache if it is enabled.
	 *
	 * @param rsvpPayments the rsvp payments
	 */
	@Override
	public void cacheResult(List<RsvpPayment> rsvpPayments) {
		for (RsvpPayment rsvpPayment : rsvpPayments) {
			if (EntityCacheUtil.getResult(
						RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
						RsvpPaymentImpl.class, rsvpPayment.getPrimaryKey()) == null) {
				cacheResult(rsvpPayment);
			}
			else {
				rsvpPayment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rsvp payments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RsvpPaymentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RsvpPaymentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rsvp payment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RsvpPayment rsvpPayment) {
		EntityCacheUtil.removeResult(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentImpl.class, rsvpPayment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rsvpPayment);
	}

	@Override
	public void clearCache(List<RsvpPayment> rsvpPayments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RsvpPayment rsvpPayment : rsvpPayments) {
			EntityCacheUtil.removeResult(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
				RsvpPaymentImpl.class, rsvpPayment.getPrimaryKey());

			clearUniqueFindersCache(rsvpPayment);
		}
	}

	protected void cacheUniqueFindersCache(RsvpPayment rsvpPayment) {
		if (rsvpPayment.isNew()) {
			Object[] args = new Object[] {
					rsvpPayment.getUuid(), rsvpPayment.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				rsvpPayment);

			args = new Object[] { rsvpPayment.getTicketNumber() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TICKETNUMBER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER, args,
				rsvpPayment);
		}
		else {
			RsvpPaymentModelImpl rsvpPaymentModelImpl = (RsvpPaymentModelImpl)rsvpPayment;

			if ((rsvpPaymentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPayment.getUuid(), rsvpPayment.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					rsvpPayment);
			}

			if ((rsvpPaymentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TICKETNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { rsvpPayment.getTicketNumber() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TICKETNUMBER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNUMBER,
					args, rsvpPayment);
			}
		}
	}

	protected void clearUniqueFindersCache(RsvpPayment rsvpPayment) {
		RsvpPaymentModelImpl rsvpPaymentModelImpl = (RsvpPaymentModelImpl)rsvpPayment;

		Object[] args = new Object[] {
				rsvpPayment.getUuid(), rsvpPayment.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((rsvpPaymentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					rsvpPaymentModelImpl.getOriginalUuid(),
					rsvpPaymentModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { rsvpPayment.getTicketNumber() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNUMBER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNUMBER, args);

		if ((rsvpPaymentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TICKETNUMBER.getColumnBitmask()) != 0) {
			args = new Object[] { rsvpPaymentModelImpl.getOriginalTicketNumber() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNUMBER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNUMBER, args);
		}
	}

	/**
	 * Creates a new rsvp payment with the primary key. Does not add the rsvp payment to the database.
	 *
	 * @param rsvpPaymentId the primary key for the new rsvp payment
	 * @return the new rsvp payment
	 */
	@Override
	public RsvpPayment create(long rsvpPaymentId) {
		RsvpPayment rsvpPayment = new RsvpPaymentImpl();

		rsvpPayment.setNew(true);
		rsvpPayment.setPrimaryKey(rsvpPaymentId);

		String uuid = PortalUUIDUtil.generate();

		rsvpPayment.setUuid(uuid);

		return rsvpPayment;
	}

	/**
	 * Removes the rsvp payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rsvpPaymentId the primary key of the rsvp payment
	 * @return the rsvp payment that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment remove(long rsvpPaymentId)
		throws NoSuchRsvpPaymentException, SystemException {
		return remove((Serializable)rsvpPaymentId);
	}

	/**
	 * Removes the rsvp payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rsvp payment
	 * @return the rsvp payment that was removed
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment remove(Serializable primaryKey)
		throws NoSuchRsvpPaymentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RsvpPayment rsvpPayment = (RsvpPayment)session.get(RsvpPaymentImpl.class,
					primaryKey);

			if (rsvpPayment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRsvpPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rsvpPayment);
		}
		catch (NoSuchRsvpPaymentException nsee) {
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
	protected RsvpPayment removeImpl(RsvpPayment rsvpPayment)
		throws SystemException {
		rsvpPayment = toUnwrappedModel(rsvpPayment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rsvpPayment)) {
				rsvpPayment = (RsvpPayment)session.get(RsvpPaymentImpl.class,
						rsvpPayment.getPrimaryKeyObj());
			}

			if (rsvpPayment != null) {
				session.delete(rsvpPayment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rsvpPayment != null) {
			clearCache(rsvpPayment);
		}

		return rsvpPayment;
	}

	@Override
	public RsvpPayment updateImpl(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment)
		throws SystemException {
		rsvpPayment = toUnwrappedModel(rsvpPayment);

		boolean isNew = rsvpPayment.isNew();

		RsvpPaymentModelImpl rsvpPaymentModelImpl = (RsvpPaymentModelImpl)rsvpPayment;

		if (Validator.isNull(rsvpPayment.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rsvpPayment.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (rsvpPayment.isNew()) {
				session.save(rsvpPayment);

				rsvpPayment.setNew(false);
			}
			else {
				session.merge(rsvpPayment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RsvpPaymentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rsvpPaymentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPaymentModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { rsvpPaymentModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((rsvpPaymentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPaymentModelImpl.getOriginalUuid(),
						rsvpPaymentModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						rsvpPaymentModelImpl.getUuid(),
						rsvpPaymentModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((rsvpPaymentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPaymentModelImpl.getOriginalRsvpDetailId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILID,
					args);

				args = new Object[] { rsvpPaymentModelImpl.getRsvpDetailId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILID,
					args);
			}

			if ((rsvpPaymentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDTRANSACTIONSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rsvpPaymentModelImpl.getOriginalRsvpDetailId(),
						rsvpPaymentModelImpl.getOriginalTransactionStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPDETAILIDTRANSACTIONSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDTRANSACTIONSTATUS,
					args);

				args = new Object[] {
						rsvpPaymentModelImpl.getRsvpDetailId(),
						rsvpPaymentModelImpl.getTransactionStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPDETAILIDTRANSACTIONSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RSVPDETAILIDTRANSACTIONSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
			RsvpPaymentImpl.class, rsvpPayment.getPrimaryKey(), rsvpPayment);

		clearUniqueFindersCache(rsvpPayment);
		cacheUniqueFindersCache(rsvpPayment);

		return rsvpPayment;
	}

	protected RsvpPayment toUnwrappedModel(RsvpPayment rsvpPayment) {
		if (rsvpPayment instanceof RsvpPaymentImpl) {
			return rsvpPayment;
		}

		RsvpPaymentImpl rsvpPaymentImpl = new RsvpPaymentImpl();

		rsvpPaymentImpl.setNew(rsvpPayment.isNew());
		rsvpPaymentImpl.setPrimaryKey(rsvpPayment.getPrimaryKey());

		rsvpPaymentImpl.setUuid(rsvpPayment.getUuid());
		rsvpPaymentImpl.setRsvpPaymentId(rsvpPayment.getRsvpPaymentId());
		rsvpPaymentImpl.setGroupId(rsvpPayment.getGroupId());
		rsvpPaymentImpl.setCompanyId(rsvpPayment.getCompanyId());
		rsvpPaymentImpl.setUserId(rsvpPayment.getUserId());
		rsvpPaymentImpl.setUserName(rsvpPayment.getUserName());
		rsvpPaymentImpl.setCreateDate(rsvpPayment.getCreateDate());
		rsvpPaymentImpl.setModifiedDate(rsvpPayment.getModifiedDate());
		rsvpPaymentImpl.setRsvpDetailId(rsvpPayment.getRsvpDetailId());
		rsvpPaymentImpl.setRsvpId(rsvpPayment.getRsvpId());
		rsvpPaymentImpl.setRsvpTicketId(rsvpPayment.getRsvpTicketId());
		rsvpPaymentImpl.setRsvpDiscountId(rsvpPayment.getRsvpDiscountId());
		rsvpPaymentImpl.setRsvpPromoCodeId(rsvpPayment.getRsvpPromoCodeId());
		rsvpPaymentImpl.setPrice(rsvpPayment.getPrice());
		rsvpPaymentImpl.setNumberOfPeople(rsvpPayment.getNumberOfPeople());
		rsvpPaymentImpl.setDiscount(rsvpPayment.getDiscount());
		rsvpPaymentImpl.setNetTotal(rsvpPayment.getNetTotal());
		rsvpPaymentImpl.setTicketNumber(rsvpPayment.getTicketNumber());
		rsvpPaymentImpl.setPayerEmailAddress(rsvpPayment.getPayerEmailAddress());
		rsvpPaymentImpl.setReceiverEmailAddress(rsvpPayment.getReceiverEmailAddress());
		rsvpPaymentImpl.setTransactionId(rsvpPayment.getTransactionId());
		rsvpPaymentImpl.setTransactionStatus(rsvpPayment.getTransactionStatus());
		rsvpPaymentImpl.setTransactionAmount(rsvpPayment.getTransactionAmount());
		rsvpPaymentImpl.setTransactionDate(rsvpPayment.getTransactionDate());
		rsvpPaymentImpl.setEmailStatus(rsvpPayment.isEmailStatus());

		return rsvpPaymentImpl;
	}

	/**
	 * Returns the rsvp payment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp payment
	 * @return the rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRsvpPaymentException, SystemException {
		RsvpPayment rsvpPayment = fetchByPrimaryKey(primaryKey);

		if (rsvpPayment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRsvpPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rsvpPayment;
	}

	/**
	 * Returns the rsvp payment with the primary key or throws a {@link com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException} if it could not be found.
	 *
	 * @param rsvpPaymentId the primary key of the rsvp payment
	 * @return the rsvp payment
	 * @throws com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment findByPrimaryKey(long rsvpPaymentId)
		throws NoSuchRsvpPaymentException, SystemException {
		return findByPrimaryKey((Serializable)rsvpPaymentId);
	}

	/**
	 * Returns the rsvp payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rsvp payment
	 * @return the rsvp payment, or <code>null</code> if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RsvpPayment rsvpPayment = (RsvpPayment)EntityCacheUtil.getResult(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
				RsvpPaymentImpl.class, primaryKey);

		if (rsvpPayment == _nullRsvpPayment) {
			return null;
		}

		if (rsvpPayment == null) {
			Session session = null;

			try {
				session = openSession();

				rsvpPayment = (RsvpPayment)session.get(RsvpPaymentImpl.class,
						primaryKey);

				if (rsvpPayment != null) {
					cacheResult(rsvpPayment);
				}
				else {
					EntityCacheUtil.putResult(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
						RsvpPaymentImpl.class, primaryKey, _nullRsvpPayment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RsvpPaymentModelImpl.ENTITY_CACHE_ENABLED,
					RsvpPaymentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rsvpPayment;
	}

	/**
	 * Returns the rsvp payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rsvpPaymentId the primary key of the rsvp payment
	 * @return the rsvp payment, or <code>null</code> if a rsvp payment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RsvpPayment fetchByPrimaryKey(long rsvpPaymentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)rsvpPaymentId);
	}

	/**
	 * Returns all the rsvp payments.
	 *
	 * @return the rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rsvp payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @return the range of rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rsvp payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rsvp payments
	 * @param end the upper bound of the range of rsvp payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rsvp payments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RsvpPayment> findAll(int start, int end,
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

		List<RsvpPayment> list = (List<RsvpPayment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RSVPPAYMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RSVPPAYMENT;

				if (pagination) {
					sql = sql.concat(RsvpPaymentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RsvpPayment>(list);
				}
				else {
					list = (List<RsvpPayment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rsvp payments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RsvpPayment rsvpPayment : findAll()) {
			remove(rsvpPayment);
		}
	}

	/**
	 * Returns the number of rsvp payments.
	 *
	 * @return the number of rsvp payments
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

				Query q = session.createQuery(_SQL_COUNT_RSVPPAYMENT);

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
	 * Initializes the rsvp payment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.rsvp.model.RsvpPayment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RsvpPayment>> listenersList = new ArrayList<ModelListener<RsvpPayment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RsvpPayment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RsvpPaymentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RSVPPAYMENT = "SELECT rsvpPayment FROM RsvpPayment rsvpPayment";
	private static final String _SQL_SELECT_RSVPPAYMENT_WHERE = "SELECT rsvpPayment FROM RsvpPayment rsvpPayment WHERE ";
	private static final String _SQL_COUNT_RSVPPAYMENT = "SELECT COUNT(rsvpPayment) FROM RsvpPayment rsvpPayment";
	private static final String _SQL_COUNT_RSVPPAYMENT_WHERE = "SELECT COUNT(rsvpPayment) FROM RsvpPayment rsvpPayment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rsvpPayment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RsvpPayment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RsvpPayment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RsvpPaymentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "rsvpPaymentId", "rsvpDetailId", "rsvpId",
				"rsvpTicketId", "rsvpDiscountId", "rsvpPromoCodeId"
			});
	private static RsvpPayment _nullRsvpPayment = new RsvpPaymentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RsvpPayment> toCacheModel() {
				return _nullRsvpPaymentCacheModel;
			}
		};

	private static CacheModel<RsvpPayment> _nullRsvpPaymentCacheModel = new CacheModel<RsvpPayment>() {
			@Override
			public RsvpPayment toEntityModel() {
				return _nullRsvpPayment;
			}
		};
}