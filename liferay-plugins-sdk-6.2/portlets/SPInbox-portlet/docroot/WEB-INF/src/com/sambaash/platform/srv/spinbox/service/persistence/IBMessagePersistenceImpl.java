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

package com.sambaash.platform.srv.spinbox.service.persistence;

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

import com.sambaash.platform.srv.spinbox.NoSuchIBMessageException;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.model.impl.IBMessageImpl;
import com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the i b message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessagePersistence
 * @see IBMessageUtil
 * @generated
 */
public class IBMessagePersistenceImpl extends BasePersistenceImpl<IBMessage>
	implements IBMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IBMessageUtil} to access the i b message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IBMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			IBMessageModelImpl.UUID_COLUMN_BITMASK |
			IBMessageModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the i b messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @return the range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByUuid(String uuid, int start, int end,
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

		List<IBMessage> list = (List<IBMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessage ibMessage : list) {
				if (!Validator.equals(uuid, ibMessage.getUuid())) {
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

			query.append(_SQL_SELECT_IBMESSAGE_WHERE);

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
				query.append(IBMessageModelImpl.ORDER_BY_JPQL);
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
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessage>(list);
				}
				else {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first i b message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByUuid_First(uuid, orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the first i b message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessage> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByUuid_Last(uuid, orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the last i b message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<IBMessage> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b messages before and after the current i b message in the ordered set where uuid = &#63;.
	 *
	 * @param messageId the primary key of the current i b message
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage[] findByUuid_PrevAndNext(long messageId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			IBMessage[] array = new IBMessageImpl[3];

			array[0] = getByUuid_PrevAndNext(session, ibMessage, uuid,
					orderByComparator, true);

			array[1] = ibMessage;

			array[2] = getByUuid_PrevAndNext(session, ibMessage, uuid,
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

	protected IBMessage getByUuid_PrevAndNext(Session session,
		IBMessage ibMessage, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGE_WHERE);

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
			query.append(IBMessageModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b messages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (IBMessage ibMessage : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ibMessage);
		}
	}

	/**
	 * Returns the number of i b messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching i b messages
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

			query.append(_SQL_COUNT_IBMESSAGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "ibMessage.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ibMessage.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(ibMessage.uuid IS NULL OR ibMessage.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			IBMessageModelImpl.UUID_COLUMN_BITMASK |
			IBMessageModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the i b message where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByUUID_G(String uuid, long groupId)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByUUID_G(uuid, groupId);

		if (ibMessage == null) {
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

			throw new NoSuchIBMessageException(msg.toString());
		}

		return ibMessage;
	}

	/**
	 * Returns the i b message where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the i b message where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof IBMessage) {
			IBMessage ibMessage = (IBMessage)result;

			if (!Validator.equals(uuid, ibMessage.getUuid()) ||
					(groupId != ibMessage.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_IBMESSAGE_WHERE);

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

				List<IBMessage> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					IBMessage ibMessage = list.get(0);

					result = ibMessage;

					cacheResult(ibMessage);

					if ((ibMessage.getUuid() == null) ||
							!ibMessage.getUuid().equals(uuid) ||
							(ibMessage.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, ibMessage);
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
			return (IBMessage)result;
		}
	}

	/**
	 * Removes the i b message where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the i b message that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage removeByUUID_G(String uuid, long groupId)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = findByUUID_G(uuid, groupId);

		return remove(ibMessage);
	}

	/**
	 * Returns the number of i b messages where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching i b messages
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

			query.append(_SQL_COUNT_IBMESSAGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "ibMessage.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "ibMessage.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(ibMessage.uuid IS NULL OR ibMessage.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "ibMessage.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			IBMessageModelImpl.UUID_COLUMN_BITMASK |
			IBMessageModelImpl.COMPANYID_COLUMN_BITMASK |
			IBMessageModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the i b messages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b messages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @return the range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b messages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByUuid_C(String uuid, long companyId, int start,
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

		List<IBMessage> list = (List<IBMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessage ibMessage : list) {
				if (!Validator.equals(uuid, ibMessage.getUuid()) ||
						(companyId != ibMessage.getCompanyId())) {
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

			query.append(_SQL_SELECT_IBMESSAGE_WHERE);

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
				query.append(IBMessageModelImpl.ORDER_BY_JPQL);
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
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessage>(list);
				}
				else {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the first i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessage> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the last i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<IBMessage> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b messages before and after the current i b message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param messageId the primary key of the current i b message
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage[] findByUuid_C_PrevAndNext(long messageId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			IBMessage[] array = new IBMessageImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, ibMessage, uuid,
					companyId, orderByComparator, true);

			array[1] = ibMessage;

			array[2] = getByUuid_C_PrevAndNext(session, ibMessage, uuid,
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

	protected IBMessage getByUuid_C_PrevAndNext(Session session,
		IBMessage ibMessage, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGE_WHERE);

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
			query.append(IBMessageModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b messages where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (IBMessage ibMessage : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessage);
		}
	}

	/**
	 * Returns the number of i b messages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching i b messages
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

			query.append(_SQL_COUNT_IBMESSAGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "ibMessage.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "ibMessage.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(ibMessage.uuid IS NULL OR ibMessage.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "ibMessage.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEUSERID =
		new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreateUserId",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERID =
		new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreateUserId",
			new String[] { String.class.getName(), Boolean.class.getName() },
			IBMessageModelImpl.CREATEBYUSERID_COLUMN_BITMASK |
			IBMessageModelImpl.DELETESTATUS_COLUMN_BITMASK |
			IBMessageModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEUSERID = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreateUserId",
			new String[] { String.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @return the matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreateUserId(String createByUserId,
		boolean deleteStatus) throws SystemException {
		return findByCreateUserId(createByUserId, deleteStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @return the range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreateUserId(String createByUserId,
		boolean deleteStatus, int start, int end) throws SystemException {
		return findByCreateUserId(createByUserId, deleteStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreateUserId(String createByUserId,
		boolean deleteStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERID;
			finderArgs = new Object[] { createByUserId, deleteStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEUSERID;
			finderArgs = new Object[] {
					createByUserId, deleteStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessage> list = (List<IBMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessage ibMessage : list) {
				if (!Validator.equals(createByUserId,
							ibMessage.getCreateByUserId()) ||
						(deleteStatus != ibMessage.getDeleteStatus())) {
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

			query.append(_SQL_SELECT_IBMESSAGE_WHERE);

			boolean bindCreateByUserId = false;

			if (createByUserId == null) {
				query.append(_FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_1);
			}
			else if (createByUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_3);
			}
			else {
				bindCreateByUserId = true;

				query.append(_FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_2);
			}

			query.append(_FINDER_COLUMN_CREATEUSERID_DELETESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateByUserId) {
					qPos.add(createByUserId);
				}

				qPos.add(deleteStatus);

				if (!pagination) {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessage>(list);
				}
				else {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByCreateUserId_First(String createByUserId,
		boolean deleteStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByCreateUserId_First(createByUserId,
				deleteStatus, orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createByUserId=");
		msg.append(createByUserId);

		msg.append(", deleteStatus=");
		msg.append(deleteStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByCreateUserId_First(String createByUserId,
		boolean deleteStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessage> list = findByCreateUserId(createByUserId, deleteStatus,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByCreateUserId_Last(String createByUserId,
		boolean deleteStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByCreateUserId_Last(createByUserId,
				deleteStatus, orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createByUserId=");
		msg.append(createByUserId);

		msg.append(", deleteStatus=");
		msg.append(deleteStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByCreateUserId_Last(String createByUserId,
		boolean deleteStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCreateUserId(createByUserId, deleteStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessage> list = findByCreateUserId(createByUserId, deleteStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b messages before and after the current i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63;.
	 *
	 * @param messageId the primary key of the current i b message
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage[] findByCreateUserId_PrevAndNext(long messageId,
		String createByUserId, boolean deleteStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			IBMessage[] array = new IBMessageImpl[3];

			array[0] = getByCreateUserId_PrevAndNext(session, ibMessage,
					createByUserId, deleteStatus, orderByComparator, true);

			array[1] = ibMessage;

			array[2] = getByCreateUserId_PrevAndNext(session, ibMessage,
					createByUserId, deleteStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessage getByCreateUserId_PrevAndNext(Session session,
		IBMessage ibMessage, String createByUserId, boolean deleteStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGE_WHERE);

		boolean bindCreateByUserId = false;

		if (createByUserId == null) {
			query.append(_FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_1);
		}
		else if (createByUserId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_3);
		}
		else {
			bindCreateByUserId = true;

			query.append(_FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_2);
		}

		query.append(_FINDER_COLUMN_CREATEUSERID_DELETESTATUS_2);

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
			query.append(IBMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreateByUserId) {
			qPos.add(createByUserId);
		}

		qPos.add(deleteStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b messages where createByUserId = &#63; and deleteStatus = &#63; from the database.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreateUserId(String createByUserId, boolean deleteStatus)
		throws SystemException {
		for (IBMessage ibMessage : findByCreateUserId(createByUserId,
				deleteStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessage);
		}
	}

	/**
	 * Returns the number of i b messages where createByUserId = &#63; and deleteStatus = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @return the number of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreateUserId(String createByUserId, boolean deleteStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEUSERID;

		Object[] finderArgs = new Object[] { createByUserId, deleteStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IBMESSAGE_WHERE);

			boolean bindCreateByUserId = false;

			if (createByUserId == null) {
				query.append(_FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_1);
			}
			else if (createByUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_3);
			}
			else {
				bindCreateByUserId = true;

				query.append(_FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_2);
			}

			query.append(_FINDER_COLUMN_CREATEUSERID_DELETESTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateByUserId) {
					qPos.add(createByUserId);
				}

				qPos.add(deleteStatus);

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

	private static final String _FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_1 = "ibMessage.createByUserId IS NULL AND ";
	private static final String _FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_2 = "ibMessage.createByUserId = ? AND ";
	private static final String _FINDER_COLUMN_CREATEUSERID_CREATEBYUSERID_3 = "(ibMessage.createByUserId IS NULL OR ibMessage.createByUserId = '') AND ";
	private static final String _FINDER_COLUMN_CREATEUSERID_DELETESTATUS_2 = "ibMessage.deleteStatus = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEUSERIDANDDRAFT =
		new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreateUserIdAndDraft",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERIDANDDRAFT =
		new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreateUserIdAndDraft",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			IBMessageModelImpl.CREATEBYUSERID_COLUMN_BITMASK |
			IBMessageModelImpl.DELETESTATUS_COLUMN_BITMASK |
			IBMessageModelImpl.DRAFT_COLUMN_BITMASK |
			IBMessageModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEUSERIDANDDRAFT = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCreateUserIdAndDraft",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @return the matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreateUserIdAndDraft(String createByUserId,
		boolean deleteStatus, boolean draft) throws SystemException {
		return findByCreateUserIdAndDraft(createByUserId, deleteStatus, draft,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @return the range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreateUserIdAndDraft(String createByUserId,
		boolean deleteStatus, boolean draft, int start, int end)
		throws SystemException {
		return findByCreateUserIdAndDraft(createByUserId, deleteStatus, draft,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreateUserIdAndDraft(String createByUserId,
		boolean deleteStatus, boolean draft, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERIDANDDRAFT;
			finderArgs = new Object[] { createByUserId, deleteStatus, draft };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEUSERIDANDDRAFT;
			finderArgs = new Object[] {
					createByUserId, deleteStatus, draft,
					
					start, end, orderByComparator
				};
		}

		List<IBMessage> list = (List<IBMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessage ibMessage : list) {
				if (!Validator.equals(createByUserId,
							ibMessage.getCreateByUserId()) ||
						(deleteStatus != ibMessage.getDeleteStatus()) ||
						(draft != ibMessage.getDraft())) {
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

			query.append(_SQL_SELECT_IBMESSAGE_WHERE);

			boolean bindCreateByUserId = false;

			if (createByUserId == null) {
				query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_1);
			}
			else if (createByUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_3);
			}
			else {
				bindCreateByUserId = true;

				query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_2);
			}

			query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_DELETESTATUS_2);

			query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_DRAFT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateByUserId) {
					qPos.add(createByUserId);
				}

				qPos.add(deleteStatus);

				qPos.add(draft);

				if (!pagination) {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessage>(list);
				}
				else {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByCreateUserIdAndDraft_First(String createByUserId,
		boolean deleteStatus, boolean draft, OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByCreateUserIdAndDraft_First(createByUserId,
				deleteStatus, draft, orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createByUserId=");
		msg.append(createByUserId);

		msg.append(", deleteStatus=");
		msg.append(deleteStatus);

		msg.append(", draft=");
		msg.append(draft);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the first i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByCreateUserIdAndDraft_First(String createByUserId,
		boolean deleteStatus, boolean draft, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessage> list = findByCreateUserIdAndDraft(createByUserId,
				deleteStatus, draft, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByCreateUserIdAndDraft_Last(String createByUserId,
		boolean deleteStatus, boolean draft, OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByCreateUserIdAndDraft_Last(createByUserId,
				deleteStatus, draft, orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createByUserId=");
		msg.append(createByUserId);

		msg.append(", deleteStatus=");
		msg.append(deleteStatus);

		msg.append(", draft=");
		msg.append(draft);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the last i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByCreateUserIdAndDraft_Last(String createByUserId,
		boolean deleteStatus, boolean draft, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCreateUserIdAndDraft(createByUserId, deleteStatus,
				draft);

		if (count == 0) {
			return null;
		}

		List<IBMessage> list = findByCreateUserIdAndDraft(createByUserId,
				deleteStatus, draft, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b messages before and after the current i b message in the ordered set where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param messageId the primary key of the current i b message
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage[] findByCreateUserIdAndDraft_PrevAndNext(long messageId,
		String createByUserId, boolean deleteStatus, boolean draft,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			IBMessage[] array = new IBMessageImpl[3];

			array[0] = getByCreateUserIdAndDraft_PrevAndNext(session,
					ibMessage, createByUserId, deleteStatus, draft,
					orderByComparator, true);

			array[1] = ibMessage;

			array[2] = getByCreateUserIdAndDraft_PrevAndNext(session,
					ibMessage, createByUserId, deleteStatus, draft,
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

	protected IBMessage getByCreateUserIdAndDraft_PrevAndNext(Session session,
		IBMessage ibMessage, String createByUserId, boolean deleteStatus,
		boolean draft, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGE_WHERE);

		boolean bindCreateByUserId = false;

		if (createByUserId == null) {
			query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_1);
		}
		else if (createByUserId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_3);
		}
		else {
			bindCreateByUserId = true;

			query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_2);
		}

		query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_DELETESTATUS_2);

		query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_DRAFT_2);

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
			query.append(IBMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreateByUserId) {
			qPos.add(createByUserId);
		}

		qPos.add(deleteStatus);

		qPos.add(draft);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63; from the database.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreateUserIdAndDraft(String createByUserId,
		boolean deleteStatus, boolean draft) throws SystemException {
		for (IBMessage ibMessage : findByCreateUserIdAndDraft(createByUserId,
				deleteStatus, draft, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessage);
		}
	}

	/**
	 * Returns the number of i b messages where createByUserId = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createByUserId the create by user ID
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @return the number of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreateUserIdAndDraft(String createByUserId,
		boolean deleteStatus, boolean draft) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEUSERIDANDDRAFT;

		Object[] finderArgs = new Object[] { createByUserId, deleteStatus, draft };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IBMESSAGE_WHERE);

			boolean bindCreateByUserId = false;

			if (createByUserId == null) {
				query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_1);
			}
			else if (createByUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_3);
			}
			else {
				bindCreateByUserId = true;

				query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_2);
			}

			query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_DELETESTATUS_2);

			query.append(_FINDER_COLUMN_CREATEUSERIDANDDRAFT_DRAFT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateByUserId) {
					qPos.add(createByUserId);
				}

				qPos.add(deleteStatus);

				qPos.add(draft);

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

	private static final String _FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_1 =
		"ibMessage.createByUserId IS NULL AND ";
	private static final String _FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_2 =
		"ibMessage.createByUserId = ? AND ";
	private static final String _FINDER_COLUMN_CREATEUSERIDANDDRAFT_CREATEBYUSERID_3 =
		"(ibMessage.createByUserId IS NULL OR ibMessage.createByUserId = '') AND ";
	private static final String _FINDER_COLUMN_CREATEUSERIDANDDRAFT_DELETESTATUS_2 =
		"ibMessage.deleteStatus = ? AND ";
	private static final String _FINDER_COLUMN_CREATEUSERIDANDDRAFT_DRAFT_2 = "ibMessage.draft = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORNAME =
		new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreatorName",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAME =
		new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreatorName",
			new String[] { String.class.getName(), Boolean.class.getName() },
			IBMessageModelImpl.CREATEBY_COLUMN_BITMASK |
			IBMessageModelImpl.DELETESTATUS_COLUMN_BITMASK |
			IBMessageModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATORNAME = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreatorName",
			new String[] { String.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the i b messages where createBy = &#63; and deleteStatus = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @return the matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreatorName(String createBy,
		boolean deleteStatus) throws SystemException {
		return findByCreatorName(createBy, deleteStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b messages where createBy = &#63; and deleteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @return the range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreatorName(String createBy,
		boolean deleteStatus, int start, int end) throws SystemException {
		return findByCreatorName(createBy, deleteStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b messages where createBy = &#63; and deleteStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreatorName(String createBy,
		boolean deleteStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAME;
			finderArgs = new Object[] { createBy, deleteStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORNAME;
			finderArgs = new Object[] {
					createBy, deleteStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessage> list = (List<IBMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessage ibMessage : list) {
				if (!Validator.equals(createBy, ibMessage.getCreateBy()) ||
						(deleteStatus != ibMessage.getDeleteStatus())) {
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

			query.append(_SQL_SELECT_IBMESSAGE_WHERE);

			boolean bindCreateBy = false;

			if (createBy == null) {
				query.append(_FINDER_COLUMN_CREATORNAME_CREATEBY_1);
			}
			else if (createBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATORNAME_CREATEBY_3);
			}
			else {
				bindCreateBy = true;

				query.append(_FINDER_COLUMN_CREATORNAME_CREATEBY_2);
			}

			query.append(_FINDER_COLUMN_CREATORNAME_DELETESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateBy) {
					qPos.add(createBy);
				}

				qPos.add(deleteStatus);

				if (!pagination) {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessage>(list);
				}
				else {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByCreatorName_First(String createBy,
		boolean deleteStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByCreatorName_First(createBy, deleteStatus,
				orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createBy=");
		msg.append(createBy);

		msg.append(", deleteStatus=");
		msg.append(deleteStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByCreatorName_First(String createBy,
		boolean deleteStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessage> list = findByCreatorName(createBy, deleteStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByCreatorName_Last(String createBy,
		boolean deleteStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByCreatorName_Last(createBy, deleteStatus,
				orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createBy=");
		msg.append(createBy);

		msg.append(", deleteStatus=");
		msg.append(deleteStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByCreatorName_Last(String createBy,
		boolean deleteStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCreatorName(createBy, deleteStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessage> list = findByCreatorName(createBy, deleteStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b messages before and after the current i b message in the ordered set where createBy = &#63; and deleteStatus = &#63;.
	 *
	 * @param messageId the primary key of the current i b message
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage[] findByCreatorName_PrevAndNext(long messageId,
		String createBy, boolean deleteStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			IBMessage[] array = new IBMessageImpl[3];

			array[0] = getByCreatorName_PrevAndNext(session, ibMessage,
					createBy, deleteStatus, orderByComparator, true);

			array[1] = ibMessage;

			array[2] = getByCreatorName_PrevAndNext(session, ibMessage,
					createBy, deleteStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessage getByCreatorName_PrevAndNext(Session session,
		IBMessage ibMessage, String createBy, boolean deleteStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGE_WHERE);

		boolean bindCreateBy = false;

		if (createBy == null) {
			query.append(_FINDER_COLUMN_CREATORNAME_CREATEBY_1);
		}
		else if (createBy.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CREATORNAME_CREATEBY_3);
		}
		else {
			bindCreateBy = true;

			query.append(_FINDER_COLUMN_CREATORNAME_CREATEBY_2);
		}

		query.append(_FINDER_COLUMN_CREATORNAME_DELETESTATUS_2);

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
			query.append(IBMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreateBy) {
			qPos.add(createBy);
		}

		qPos.add(deleteStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b messages where createBy = &#63; and deleteStatus = &#63; from the database.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreatorName(String createBy, boolean deleteStatus)
		throws SystemException {
		for (IBMessage ibMessage : findByCreatorName(createBy, deleteStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessage);
		}
	}

	/**
	 * Returns the number of i b messages where createBy = &#63; and deleteStatus = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @return the number of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreatorName(String createBy, boolean deleteStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATORNAME;

		Object[] finderArgs = new Object[] { createBy, deleteStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IBMESSAGE_WHERE);

			boolean bindCreateBy = false;

			if (createBy == null) {
				query.append(_FINDER_COLUMN_CREATORNAME_CREATEBY_1);
			}
			else if (createBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATORNAME_CREATEBY_3);
			}
			else {
				bindCreateBy = true;

				query.append(_FINDER_COLUMN_CREATORNAME_CREATEBY_2);
			}

			query.append(_FINDER_COLUMN_CREATORNAME_DELETESTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateBy) {
					qPos.add(createBy);
				}

				qPos.add(deleteStatus);

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

	private static final String _FINDER_COLUMN_CREATORNAME_CREATEBY_1 = "ibMessage.createBy IS NULL AND ";
	private static final String _FINDER_COLUMN_CREATORNAME_CREATEBY_2 = "ibMessage.createBy = ? AND ";
	private static final String _FINDER_COLUMN_CREATORNAME_CREATEBY_3 = "(ibMessage.createBy IS NULL OR ibMessage.createBy = '') AND ";
	private static final String _FINDER_COLUMN_CREATORNAME_DELETESTATUS_2 = "ibMessage.deleteStatus = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORNAMEANDDRAFT =
		new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreatorNameAndDraft",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAMEANDDRAFT =
		new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, IBMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreatorNameAndDraft",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			IBMessageModelImpl.CREATEBY_COLUMN_BITMASK |
			IBMessageModelImpl.DELETESTATUS_COLUMN_BITMASK |
			IBMessageModelImpl.DRAFT_COLUMN_BITMASK |
			IBMessageModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATORNAMEANDDRAFT = new FinderPath(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCreatorNameAndDraft",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @return the matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreatorNameAndDraft(String createBy,
		boolean deleteStatus, boolean draft) throws SystemException {
		return findByCreatorNameAndDraft(createBy, deleteStatus, draft,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @return the range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreatorNameAndDraft(String createBy,
		boolean deleteStatus, boolean draft, int start, int end)
		throws SystemException {
		return findByCreatorNameAndDraft(createBy, deleteStatus, draft, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findByCreatorNameAndDraft(String createBy,
		boolean deleteStatus, boolean draft, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAMEANDDRAFT;
			finderArgs = new Object[] { createBy, deleteStatus, draft };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORNAMEANDDRAFT;
			finderArgs = new Object[] {
					createBy, deleteStatus, draft,
					
					start, end, orderByComparator
				};
		}

		List<IBMessage> list = (List<IBMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessage ibMessage : list) {
				if (!Validator.equals(createBy, ibMessage.getCreateBy()) ||
						(deleteStatus != ibMessage.getDeleteStatus()) ||
						(draft != ibMessage.getDraft())) {
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

			query.append(_SQL_SELECT_IBMESSAGE_WHERE);

			boolean bindCreateBy = false;

			if (createBy == null) {
				query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_1);
			}
			else if (createBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_3);
			}
			else {
				bindCreateBy = true;

				query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_2);
			}

			query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_DELETESTATUS_2);

			query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_DRAFT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateBy) {
					qPos.add(createBy);
				}

				qPos.add(deleteStatus);

				qPos.add(draft);

				if (!pagination) {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessage>(list);
				}
				else {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByCreatorNameAndDraft_First(String createBy,
		boolean deleteStatus, boolean draft, OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByCreatorNameAndDraft_First(createBy,
				deleteStatus, draft, orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createBy=");
		msg.append(createBy);

		msg.append(", deleteStatus=");
		msg.append(deleteStatus);

		msg.append(", draft=");
		msg.append(draft);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the first i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByCreatorNameAndDraft_First(String createBy,
		boolean deleteStatus, boolean draft, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessage> list = findByCreatorNameAndDraft(createBy,
				deleteStatus, draft, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByCreatorNameAndDraft_Last(String createBy,
		boolean deleteStatus, boolean draft, OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByCreatorNameAndDraft_Last(createBy,
				deleteStatus, draft, orderByComparator);

		if (ibMessage != null) {
			return ibMessage;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createBy=");
		msg.append(createBy);

		msg.append(", deleteStatus=");
		msg.append(deleteStatus);

		msg.append(", draft=");
		msg.append(draft);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageException(msg.toString());
	}

	/**
	 * Returns the last i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message, or <code>null</code> if a matching i b message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByCreatorNameAndDraft_Last(String createBy,
		boolean deleteStatus, boolean draft, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCreatorNameAndDraft(createBy, deleteStatus, draft);

		if (count == 0) {
			return null;
		}

		List<IBMessage> list = findByCreatorNameAndDraft(createBy,
				deleteStatus, draft, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b messages before and after the current i b message in the ordered set where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param messageId the primary key of the current i b message
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage[] findByCreatorNameAndDraft_PrevAndNext(long messageId,
		String createBy, boolean deleteStatus, boolean draft,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			IBMessage[] array = new IBMessageImpl[3];

			array[0] = getByCreatorNameAndDraft_PrevAndNext(session, ibMessage,
					createBy, deleteStatus, draft, orderByComparator, true);

			array[1] = ibMessage;

			array[2] = getByCreatorNameAndDraft_PrevAndNext(session, ibMessage,
					createBy, deleteStatus, draft, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessage getByCreatorNameAndDraft_PrevAndNext(Session session,
		IBMessage ibMessage, String createBy, boolean deleteStatus,
		boolean draft, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGE_WHERE);

		boolean bindCreateBy = false;

		if (createBy == null) {
			query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_1);
		}
		else if (createBy.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_3);
		}
		else {
			bindCreateBy = true;

			query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_2);
		}

		query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_DELETESTATUS_2);

		query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_DRAFT_2);

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
			query.append(IBMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreateBy) {
			qPos.add(createBy);
		}

		qPos.add(deleteStatus);

		qPos.add(draft);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63; from the database.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreatorNameAndDraft(String createBy,
		boolean deleteStatus, boolean draft) throws SystemException {
		for (IBMessage ibMessage : findByCreatorNameAndDraft(createBy,
				deleteStatus, draft, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessage);
		}
	}

	/**
	 * Returns the number of i b messages where createBy = &#63; and deleteStatus = &#63; and draft = &#63;.
	 *
	 * @param createBy the create by
	 * @param deleteStatus the delete status
	 * @param draft the draft
	 * @return the number of matching i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreatorNameAndDraft(String createBy,
		boolean deleteStatus, boolean draft) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATORNAMEANDDRAFT;

		Object[] finderArgs = new Object[] { createBy, deleteStatus, draft };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IBMESSAGE_WHERE);

			boolean bindCreateBy = false;

			if (createBy == null) {
				query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_1);
			}
			else if (createBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_3);
			}
			else {
				bindCreateBy = true;

				query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_2);
			}

			query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_DELETESTATUS_2);

			query.append(_FINDER_COLUMN_CREATORNAMEANDDRAFT_DRAFT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateBy) {
					qPos.add(createBy);
				}

				qPos.add(deleteStatus);

				qPos.add(draft);

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

	private static final String _FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_1 = "ibMessage.createBy IS NULL AND ";
	private static final String _FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_2 = "ibMessage.createBy = ? AND ";
	private static final String _FINDER_COLUMN_CREATORNAMEANDDRAFT_CREATEBY_3 = "(ibMessage.createBy IS NULL OR ibMessage.createBy = '') AND ";
	private static final String _FINDER_COLUMN_CREATORNAMEANDDRAFT_DELETESTATUS_2 =
		"ibMessage.deleteStatus = ? AND ";
	private static final String _FINDER_COLUMN_CREATORNAMEANDDRAFT_DRAFT_2 = "ibMessage.draft = ?";

	public IBMessagePersistenceImpl() {
		setModelClass(IBMessage.class);
	}

	/**
	 * Caches the i b message in the entity cache if it is enabled.
	 *
	 * @param ibMessage the i b message
	 */
	@Override
	public void cacheResult(IBMessage ibMessage) {
		EntityCacheUtil.putResult(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageImpl.class, ibMessage.getPrimaryKey(), ibMessage);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { ibMessage.getUuid(), ibMessage.getGroupId() },
			ibMessage);

		ibMessage.resetOriginalValues();
	}

	/**
	 * Caches the i b messages in the entity cache if it is enabled.
	 *
	 * @param ibMessages the i b messages
	 */
	@Override
	public void cacheResult(List<IBMessage> ibMessages) {
		for (IBMessage ibMessage : ibMessages) {
			if (EntityCacheUtil.getResult(
						IBMessageModelImpl.ENTITY_CACHE_ENABLED,
						IBMessageImpl.class, ibMessage.getPrimaryKey()) == null) {
				cacheResult(ibMessage);
			}
			else {
				ibMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all i b messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IBMessageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IBMessageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the i b message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IBMessage ibMessage) {
		EntityCacheUtil.removeResult(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageImpl.class, ibMessage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ibMessage);
	}

	@Override
	public void clearCache(List<IBMessage> ibMessages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (IBMessage ibMessage : ibMessages) {
			EntityCacheUtil.removeResult(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
				IBMessageImpl.class, ibMessage.getPrimaryKey());

			clearUniqueFindersCache(ibMessage);
		}
	}

	protected void cacheUniqueFindersCache(IBMessage ibMessage) {
		if (ibMessage.isNew()) {
			Object[] args = new Object[] {
					ibMessage.getUuid(), ibMessage.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				ibMessage);
		}
		else {
			IBMessageModelImpl ibMessageModelImpl = (IBMessageModelImpl)ibMessage;

			if ((ibMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessage.getUuid(), ibMessage.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					ibMessage);
			}
		}
	}

	protected void clearUniqueFindersCache(IBMessage ibMessage) {
		IBMessageModelImpl ibMessageModelImpl = (IBMessageModelImpl)ibMessage;

		Object[] args = new Object[] { ibMessage.getUuid(), ibMessage.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((ibMessageModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					ibMessageModelImpl.getOriginalUuid(),
					ibMessageModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new i b message with the primary key. Does not add the i b message to the database.
	 *
	 * @param messageId the primary key for the new i b message
	 * @return the new i b message
	 */
	@Override
	public IBMessage create(long messageId) {
		IBMessage ibMessage = new IBMessageImpl();

		ibMessage.setNew(true);
		ibMessage.setPrimaryKey(messageId);

		String uuid = PortalUUIDUtil.generate();

		ibMessage.setUuid(uuid);

		return ibMessage;
	}

	/**
	 * Removes the i b message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the i b message
	 * @return the i b message that was removed
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage remove(long messageId)
		throws NoSuchIBMessageException, SystemException {
		return remove((Serializable)messageId);
	}

	/**
	 * Removes the i b message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the i b message
	 * @return the i b message that was removed
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage remove(Serializable primaryKey)
		throws NoSuchIBMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			IBMessage ibMessage = (IBMessage)session.get(IBMessageImpl.class,
					primaryKey);

			if (ibMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIBMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ibMessage);
		}
		catch (NoSuchIBMessageException nsee) {
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
	protected IBMessage removeImpl(IBMessage ibMessage)
		throws SystemException {
		ibMessage = toUnwrappedModel(ibMessage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ibMessage)) {
				ibMessage = (IBMessage)session.get(IBMessageImpl.class,
						ibMessage.getPrimaryKeyObj());
			}

			if (ibMessage != null) {
				session.delete(ibMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ibMessage != null) {
			clearCache(ibMessage);
		}

		return ibMessage;
	}

	@Override
	public IBMessage updateImpl(
		com.sambaash.platform.srv.spinbox.model.IBMessage ibMessage)
		throws SystemException {
		ibMessage = toUnwrappedModel(ibMessage);

		boolean isNew = ibMessage.isNew();

		IBMessageModelImpl ibMessageModelImpl = (IBMessageModelImpl)ibMessage;

		if (Validator.isNull(ibMessage.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ibMessage.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (ibMessage.isNew()) {
				session.save(ibMessage);

				ibMessage.setNew(false);
			}
			else {
				session.merge(ibMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !IBMessageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ibMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { ibMessageModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((ibMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageModelImpl.getOriginalUuid(),
						ibMessageModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						ibMessageModelImpl.getUuid(),
						ibMessageModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((ibMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageModelImpl.getOriginalCreateByUserId(),
						ibMessageModelImpl.getOriginalDeleteStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERID,
					args);

				args = new Object[] {
						ibMessageModelImpl.getCreateByUserId(),
						ibMessageModelImpl.getDeleteStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERID,
					args);
			}

			if ((ibMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERIDANDDRAFT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageModelImpl.getOriginalCreateByUserId(),
						ibMessageModelImpl.getOriginalDeleteStatus(),
						ibMessageModelImpl.getOriginalDraft()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEUSERIDANDDRAFT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERIDANDDRAFT,
					args);

				args = new Object[] {
						ibMessageModelImpl.getCreateByUserId(),
						ibMessageModelImpl.getDeleteStatus(),
						ibMessageModelImpl.getDraft()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEUSERIDANDDRAFT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEUSERIDANDDRAFT,
					args);
			}

			if ((ibMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageModelImpl.getOriginalCreateBy(),
						ibMessageModelImpl.getOriginalDeleteStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAME,
					args);

				args = new Object[] {
						ibMessageModelImpl.getCreateBy(),
						ibMessageModelImpl.getDeleteStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAME,
					args);
			}

			if ((ibMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAMEANDDRAFT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageModelImpl.getOriginalCreateBy(),
						ibMessageModelImpl.getOriginalDeleteStatus(),
						ibMessageModelImpl.getOriginalDraft()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORNAMEANDDRAFT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAMEANDDRAFT,
					args);

				args = new Object[] {
						ibMessageModelImpl.getCreateBy(),
						ibMessageModelImpl.getDeleteStatus(),
						ibMessageModelImpl.getDraft()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORNAMEANDDRAFT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORNAMEANDDRAFT,
					args);
			}
		}

		EntityCacheUtil.putResult(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageImpl.class, ibMessage.getPrimaryKey(), ibMessage);

		clearUniqueFindersCache(ibMessage);
		cacheUniqueFindersCache(ibMessage);

		return ibMessage;
	}

	protected IBMessage toUnwrappedModel(IBMessage ibMessage) {
		if (ibMessage instanceof IBMessageImpl) {
			return ibMessage;
		}

		IBMessageImpl ibMessageImpl = new IBMessageImpl();

		ibMessageImpl.setNew(ibMessage.isNew());
		ibMessageImpl.setPrimaryKey(ibMessage.getPrimaryKey());

		ibMessageImpl.setUuid(ibMessage.getUuid());
		ibMessageImpl.setMessageId(ibMessage.getMessageId());
		ibMessageImpl.setParentMessageId(ibMessage.getParentMessageId());
		ibMessageImpl.setGroupId(ibMessage.getGroupId());
		ibMessageImpl.setCompanyId(ibMessage.getCompanyId());
		ibMessageImpl.setSubject(ibMessage.getSubject());
		ibMessageImpl.setContent(ibMessage.getContent());
		ibMessageImpl.setFrom(ibMessage.getFrom());
		ibMessageImpl.setTo(ibMessage.getTo());
		ibMessageImpl.setAllowOpen(ibMessage.isAllowOpen());
		ibMessageImpl.setSendDate(ibMessage.getSendDate());
		ibMessageImpl.setCreateDate(ibMessage.getCreateDate());
		ibMessageImpl.setCreateBy(ibMessage.getCreateBy());
		ibMessageImpl.setCreateByUserId(ibMessage.getCreateByUserId());
		ibMessageImpl.setDraft(ibMessage.isDraft());
		ibMessageImpl.setDeleteStatus(ibMessage.isDeleteStatus());
		ibMessageImpl.setDraftStatus(ibMessage.getDraftStatus());
		ibMessageImpl.setSentMeCopy(ibMessage.isSentMeCopy());
		ibMessageImpl.setBelongToGroupDetailId(ibMessage.getBelongToGroupDetailId());

		return ibMessageImpl;
	}

	/**
	 * Returns the i b message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the i b message
	 * @return the i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIBMessageException, SystemException {
		IBMessage ibMessage = fetchByPrimaryKey(primaryKey);

		if (ibMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIBMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ibMessage;
	}

	/**
	 * Returns the i b message with the primary key or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageException} if it could not be found.
	 *
	 * @param messageId the primary key of the i b message
	 * @return the i b message
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageException if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage findByPrimaryKey(long messageId)
		throws NoSuchIBMessageException, SystemException {
		return findByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns the i b message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the i b message
	 * @return the i b message, or <code>null</code> if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		IBMessage ibMessage = (IBMessage)EntityCacheUtil.getResult(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
				IBMessageImpl.class, primaryKey);

		if (ibMessage == _nullIBMessage) {
			return null;
		}

		if (ibMessage == null) {
			Session session = null;

			try {
				session = openSession();

				ibMessage = (IBMessage)session.get(IBMessageImpl.class,
						primaryKey);

				if (ibMessage != null) {
					cacheResult(ibMessage);
				}
				else {
					EntityCacheUtil.putResult(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
						IBMessageImpl.class, primaryKey, _nullIBMessage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(IBMessageModelImpl.ENTITY_CACHE_ENABLED,
					IBMessageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ibMessage;
	}

	/**
	 * Returns the i b message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the i b message
	 * @return the i b message, or <code>null</code> if a i b message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessage fetchByPrimaryKey(long messageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns all the i b messages.
	 *
	 * @return the i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @return the range of i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of i b messages
	 * @param end the upper bound of the range of i b messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of i b messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessage> findAll(int start, int end,
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

		List<IBMessage> list = (List<IBMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IBMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IBMESSAGE;

				if (pagination) {
					sql = sql.concat(IBMessageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessage>(list);
				}
				else {
					list = (List<IBMessage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the i b messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (IBMessage ibMessage : findAll()) {
			remove(ibMessage);
		}
	}

	/**
	 * Returns the number of i b messages.
	 *
	 * @return the number of i b messages
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

				Query q = session.createQuery(_SQL_COUNT_IBMESSAGE);

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
	 * Initializes the i b message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spinbox.model.IBMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<IBMessage>> listenersList = new ArrayList<ModelListener<IBMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<IBMessage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IBMessageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IBMESSAGE = "SELECT ibMessage FROM IBMessage ibMessage";
	private static final String _SQL_SELECT_IBMESSAGE_WHERE = "SELECT ibMessage FROM IBMessage ibMessage WHERE ";
	private static final String _SQL_COUNT_IBMESSAGE = "SELECT COUNT(ibMessage) FROM IBMessage ibMessage";
	private static final String _SQL_COUNT_IBMESSAGE_WHERE = "SELECT COUNT(ibMessage) FROM IBMessage ibMessage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ibMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IBMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No IBMessage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IBMessagePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "from", "to"
			});
	private static IBMessage _nullIBMessage = new IBMessageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<IBMessage> toCacheModel() {
				return _nullIBMessageCacheModel;
			}
		};

	private static CacheModel<IBMessage> _nullIBMessageCacheModel = new CacheModel<IBMessage>() {
			@Override
			public IBMessage toEntityModel() {
				return _nullIBMessage;
			}
		};
}