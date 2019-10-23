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

import com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException;
import com.sambaash.platform.srv.spservices.model.SPApiAuditLogs;
import com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsImpl;
import com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p api audit logs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPApiAuditLogsPersistence
 * @see SPApiAuditLogsUtil
 * @generated
 */
public class SPApiAuditLogsPersistenceImpl extends BasePersistenceImpl<SPApiAuditLogs>
	implements SPApiAuditLogsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPApiAuditLogsUtil} to access the s p api audit logs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPApiAuditLogsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED,
			SPApiAuditLogsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED,
			SPApiAuditLogsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED,
			SPApiAuditLogsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED,
			SPApiAuditLogsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPApiAuditLogsModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p api audit logses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p api audit logses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPApiAuditLogs> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p api audit logses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p api audit logses
	 * @param end the upper bound of the range of s p api audit logses (not inclusive)
	 * @return the range of matching s p api audit logses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPApiAuditLogs> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p api audit logses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p api audit logses
	 * @param end the upper bound of the range of s p api audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p api audit logses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPApiAuditLogs> findByUuid(String uuid, int start, int end,
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

		List<SPApiAuditLogs> list = (List<SPApiAuditLogs>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPApiAuditLogs spApiAuditLogs : list) {
				if (!Validator.equals(uuid, spApiAuditLogs.getUuid())) {
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

			query.append(_SQL_SELECT_SPAPIAUDITLOGS_WHERE);

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
				query.append(SPApiAuditLogsModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPApiAuditLogs>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPApiAuditLogs>(list);
				}
				else {
					list = (List<SPApiAuditLogs>)QueryUtil.list(q,
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
	 * Returns the first s p api audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p api audit logs
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPApiAuditLogsException, SystemException {
		SPApiAuditLogs spApiAuditLogs = fetchByUuid_First(uuid,
				orderByComparator);

		if (spApiAuditLogs != null) {
			return spApiAuditLogs;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPApiAuditLogsException(msg.toString());
	}

	/**
	 * Returns the first s p api audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p api audit logs, or <code>null</code> if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPApiAuditLogs> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p api audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p api audit logs
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPApiAuditLogsException, SystemException {
		SPApiAuditLogs spApiAuditLogs = fetchByUuid_Last(uuid, orderByComparator);

		if (spApiAuditLogs != null) {
			return spApiAuditLogs;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPApiAuditLogsException(msg.toString());
	}

	/**
	 * Returns the last s p api audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p api audit logs, or <code>null</code> if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPApiAuditLogs> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p api audit logses before and after the current s p api audit logs in the ordered set where uuid = &#63;.
	 *
	 * @param spApiAuditLogsId the primary key of the current s p api audit logs
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p api audit logs
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a s p api audit logs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs[] findByUuid_PrevAndNext(long spApiAuditLogsId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchSPApiAuditLogsException, SystemException {
		SPApiAuditLogs spApiAuditLogs = findByPrimaryKey(spApiAuditLogsId);

		Session session = null;

		try {
			session = openSession();

			SPApiAuditLogs[] array = new SPApiAuditLogsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spApiAuditLogs, uuid,
					orderByComparator, true);

			array[1] = spApiAuditLogs;

			array[2] = getByUuid_PrevAndNext(session, spApiAuditLogs, uuid,
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

	protected SPApiAuditLogs getByUuid_PrevAndNext(Session session,
		SPApiAuditLogs spApiAuditLogs, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPAPIAUDITLOGS_WHERE);

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
			query.append(SPApiAuditLogsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spApiAuditLogs);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPApiAuditLogs> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p api audit logses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPApiAuditLogs spApiAuditLogs : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spApiAuditLogs);
		}
	}

	/**
	 * Returns the number of s p api audit logses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p api audit logses
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

			query.append(_SQL_COUNT_SPAPIAUDITLOGS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spApiAuditLogs.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spApiAuditLogs.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spApiAuditLogs.uuid IS NULL OR spApiAuditLogs.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED,
			SPApiAuditLogsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPApiAuditLogsModelImpl.UUID_COLUMN_BITMASK |
			SPApiAuditLogsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p api audit logs where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p api audit logs
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs findByUUID_G(String uuid, long groupId)
		throws NoSuchSPApiAuditLogsException, SystemException {
		SPApiAuditLogs spApiAuditLogs = fetchByUUID_G(uuid, groupId);

		if (spApiAuditLogs == null) {
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

			throw new NoSuchSPApiAuditLogsException(msg.toString());
		}

		return spApiAuditLogs;
	}

	/**
	 * Returns the s p api audit logs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p api audit logs, or <code>null</code> if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p api audit logs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p api audit logs, or <code>null</code> if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPApiAuditLogs) {
			SPApiAuditLogs spApiAuditLogs = (SPApiAuditLogs)result;

			if (!Validator.equals(uuid, spApiAuditLogs.getUuid()) ||
					(groupId != spApiAuditLogs.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPAPIAUDITLOGS_WHERE);

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

				List<SPApiAuditLogs> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPApiAuditLogs spApiAuditLogs = list.get(0);

					result = spApiAuditLogs;

					cacheResult(spApiAuditLogs);

					if ((spApiAuditLogs.getUuid() == null) ||
							!spApiAuditLogs.getUuid().equals(uuid) ||
							(spApiAuditLogs.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spApiAuditLogs);
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
			return (SPApiAuditLogs)result;
		}
	}

	/**
	 * Removes the s p api audit logs where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p api audit logs that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPApiAuditLogsException, SystemException {
		SPApiAuditLogs spApiAuditLogs = findByUUID_G(uuid, groupId);

		return remove(spApiAuditLogs);
	}

	/**
	 * Returns the number of s p api audit logses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p api audit logses
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

			query.append(_SQL_COUNT_SPAPIAUDITLOGS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spApiAuditLogs.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spApiAuditLogs.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spApiAuditLogs.uuid IS NULL OR spApiAuditLogs.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spApiAuditLogs.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED,
			SPApiAuditLogsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED,
			SPApiAuditLogsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPApiAuditLogsModelImpl.UUID_COLUMN_BITMASK |
			SPApiAuditLogsModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p api audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p api audit logses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPApiAuditLogs> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p api audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p api audit logses
	 * @param end the upper bound of the range of s p api audit logses (not inclusive)
	 * @return the range of matching s p api audit logses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPApiAuditLogs> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p api audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p api audit logses
	 * @param end the upper bound of the range of s p api audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p api audit logses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPApiAuditLogs> findByUuid_C(String uuid, long companyId,
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

		List<SPApiAuditLogs> list = (List<SPApiAuditLogs>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPApiAuditLogs spApiAuditLogs : list) {
				if (!Validator.equals(uuid, spApiAuditLogs.getUuid()) ||
						(companyId != spApiAuditLogs.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPAPIAUDITLOGS_WHERE);

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
				query.append(SPApiAuditLogsModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPApiAuditLogs>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPApiAuditLogs>(list);
				}
				else {
					list = (List<SPApiAuditLogs>)QueryUtil.list(q,
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
	 * Returns the first s p api audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p api audit logs
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPApiAuditLogsException, SystemException {
		SPApiAuditLogs spApiAuditLogs = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spApiAuditLogs != null) {
			return spApiAuditLogs;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPApiAuditLogsException(msg.toString());
	}

	/**
	 * Returns the first s p api audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p api audit logs, or <code>null</code> if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPApiAuditLogs> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p api audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p api audit logs
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPApiAuditLogsException, SystemException {
		SPApiAuditLogs spApiAuditLogs = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spApiAuditLogs != null) {
			return spApiAuditLogs;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPApiAuditLogsException(msg.toString());
	}

	/**
	 * Returns the last s p api audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p api audit logs, or <code>null</code> if a matching s p api audit logs could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPApiAuditLogs> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p api audit logses before and after the current s p api audit logs in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spApiAuditLogsId the primary key of the current s p api audit logs
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p api audit logs
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a s p api audit logs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs[] findByUuid_C_PrevAndNext(long spApiAuditLogsId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPApiAuditLogsException, SystemException {
		SPApiAuditLogs spApiAuditLogs = findByPrimaryKey(spApiAuditLogsId);

		Session session = null;

		try {
			session = openSession();

			SPApiAuditLogs[] array = new SPApiAuditLogsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spApiAuditLogs, uuid,
					companyId, orderByComparator, true);

			array[1] = spApiAuditLogs;

			array[2] = getByUuid_C_PrevAndNext(session, spApiAuditLogs, uuid,
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

	protected SPApiAuditLogs getByUuid_C_PrevAndNext(Session session,
		SPApiAuditLogs spApiAuditLogs, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPAPIAUDITLOGS_WHERE);

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
			query.append(SPApiAuditLogsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spApiAuditLogs);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPApiAuditLogs> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p api audit logses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPApiAuditLogs spApiAuditLogs : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spApiAuditLogs);
		}
	}

	/**
	 * Returns the number of s p api audit logses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p api audit logses
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

			query.append(_SQL_COUNT_SPAPIAUDITLOGS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spApiAuditLogs.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spApiAuditLogs.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spApiAuditLogs.uuid IS NULL OR spApiAuditLogs.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spApiAuditLogs.companyId = ?";

	public SPApiAuditLogsPersistenceImpl() {
		setModelClass(SPApiAuditLogs.class);
	}

	/**
	 * Caches the s p api audit logs in the entity cache if it is enabled.
	 *
	 * @param spApiAuditLogs the s p api audit logs
	 */
	@Override
	public void cacheResult(SPApiAuditLogs spApiAuditLogs) {
		EntityCacheUtil.putResult(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsImpl.class, spApiAuditLogs.getPrimaryKey(),
			spApiAuditLogs);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spApiAuditLogs.getUuid(), spApiAuditLogs.getGroupId() },
			spApiAuditLogs);

		spApiAuditLogs.resetOriginalValues();
	}

	/**
	 * Caches the s p api audit logses in the entity cache if it is enabled.
	 *
	 * @param spApiAuditLogses the s p api audit logses
	 */
	@Override
	public void cacheResult(List<SPApiAuditLogs> spApiAuditLogses) {
		for (SPApiAuditLogs spApiAuditLogs : spApiAuditLogses) {
			if (EntityCacheUtil.getResult(
						SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
						SPApiAuditLogsImpl.class, spApiAuditLogs.getPrimaryKey()) == null) {
				cacheResult(spApiAuditLogs);
			}
			else {
				spApiAuditLogs.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p api audit logses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPApiAuditLogsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPApiAuditLogsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p api audit logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPApiAuditLogs spApiAuditLogs) {
		EntityCacheUtil.removeResult(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsImpl.class, spApiAuditLogs.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spApiAuditLogs);
	}

	@Override
	public void clearCache(List<SPApiAuditLogs> spApiAuditLogses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPApiAuditLogs spApiAuditLogs : spApiAuditLogses) {
			EntityCacheUtil.removeResult(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
				SPApiAuditLogsImpl.class, spApiAuditLogs.getPrimaryKey());

			clearUniqueFindersCache(spApiAuditLogs);
		}
	}

	protected void cacheUniqueFindersCache(SPApiAuditLogs spApiAuditLogs) {
		if (spApiAuditLogs.isNew()) {
			Object[] args = new Object[] {
					spApiAuditLogs.getUuid(), spApiAuditLogs.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spApiAuditLogs);
		}
		else {
			SPApiAuditLogsModelImpl spApiAuditLogsModelImpl = (SPApiAuditLogsModelImpl)spApiAuditLogs;

			if ((spApiAuditLogsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spApiAuditLogs.getUuid(), spApiAuditLogs.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spApiAuditLogs);
			}
		}
	}

	protected void clearUniqueFindersCache(SPApiAuditLogs spApiAuditLogs) {
		SPApiAuditLogsModelImpl spApiAuditLogsModelImpl = (SPApiAuditLogsModelImpl)spApiAuditLogs;

		Object[] args = new Object[] {
				spApiAuditLogs.getUuid(), spApiAuditLogs.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spApiAuditLogsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spApiAuditLogsModelImpl.getOriginalUuid(),
					spApiAuditLogsModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new s p api audit logs with the primary key. Does not add the s p api audit logs to the database.
	 *
	 * @param spApiAuditLogsId the primary key for the new s p api audit logs
	 * @return the new s p api audit logs
	 */
	@Override
	public SPApiAuditLogs create(long spApiAuditLogsId) {
		SPApiAuditLogs spApiAuditLogs = new SPApiAuditLogsImpl();

		spApiAuditLogs.setNew(true);
		spApiAuditLogs.setPrimaryKey(spApiAuditLogsId);

		String uuid = PortalUUIDUtil.generate();

		spApiAuditLogs.setUuid(uuid);

		return spApiAuditLogs;
	}

	/**
	 * Removes the s p api audit logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spApiAuditLogsId the primary key of the s p api audit logs
	 * @return the s p api audit logs that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a s p api audit logs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs remove(long spApiAuditLogsId)
		throws NoSuchSPApiAuditLogsException, SystemException {
		return remove((Serializable)spApiAuditLogsId);
	}

	/**
	 * Removes the s p api audit logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p api audit logs
	 * @return the s p api audit logs that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a s p api audit logs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs remove(Serializable primaryKey)
		throws NoSuchSPApiAuditLogsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPApiAuditLogs spApiAuditLogs = (SPApiAuditLogs)session.get(SPApiAuditLogsImpl.class,
					primaryKey);

			if (spApiAuditLogs == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPApiAuditLogsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spApiAuditLogs);
		}
		catch (NoSuchSPApiAuditLogsException nsee) {
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
	protected SPApiAuditLogs removeImpl(SPApiAuditLogs spApiAuditLogs)
		throws SystemException {
		spApiAuditLogs = toUnwrappedModel(spApiAuditLogs);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spApiAuditLogs)) {
				spApiAuditLogs = (SPApiAuditLogs)session.get(SPApiAuditLogsImpl.class,
						spApiAuditLogs.getPrimaryKeyObj());
			}

			if (spApiAuditLogs != null) {
				session.delete(spApiAuditLogs);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spApiAuditLogs != null) {
			clearCache(spApiAuditLogs);
		}

		return spApiAuditLogs;
	}

	@Override
	public SPApiAuditLogs updateImpl(
		com.sambaash.platform.srv.spservices.model.SPApiAuditLogs spApiAuditLogs)
		throws SystemException {
		spApiAuditLogs = toUnwrappedModel(spApiAuditLogs);

		boolean isNew = spApiAuditLogs.isNew();

		SPApiAuditLogsModelImpl spApiAuditLogsModelImpl = (SPApiAuditLogsModelImpl)spApiAuditLogs;

		if (Validator.isNull(spApiAuditLogs.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spApiAuditLogs.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spApiAuditLogs.isNew()) {
				session.save(spApiAuditLogs);

				spApiAuditLogs.setNew(false);
			}
			else {
				session.merge(spApiAuditLogs);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPApiAuditLogsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spApiAuditLogsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spApiAuditLogsModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spApiAuditLogsModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spApiAuditLogsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spApiAuditLogsModelImpl.getOriginalUuid(),
						spApiAuditLogsModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spApiAuditLogsModelImpl.getUuid(),
						spApiAuditLogsModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
			SPApiAuditLogsImpl.class, spApiAuditLogs.getPrimaryKey(),
			spApiAuditLogs);

		clearUniqueFindersCache(spApiAuditLogs);
		cacheUniqueFindersCache(spApiAuditLogs);

		return spApiAuditLogs;
	}

	protected SPApiAuditLogs toUnwrappedModel(SPApiAuditLogs spApiAuditLogs) {
		if (spApiAuditLogs instanceof SPApiAuditLogsImpl) {
			return spApiAuditLogs;
		}

		SPApiAuditLogsImpl spApiAuditLogsImpl = new SPApiAuditLogsImpl();

		spApiAuditLogsImpl.setNew(spApiAuditLogs.isNew());
		spApiAuditLogsImpl.setPrimaryKey(spApiAuditLogs.getPrimaryKey());

		spApiAuditLogsImpl.setUuid(spApiAuditLogs.getUuid());
		spApiAuditLogsImpl.setSpApiAuditLogsId(spApiAuditLogs.getSpApiAuditLogsId());
		spApiAuditLogsImpl.setGroupId(spApiAuditLogs.getGroupId());
		spApiAuditLogsImpl.setCompanyId(spApiAuditLogs.getCompanyId());
		spApiAuditLogsImpl.setUserId(spApiAuditLogs.getUserId());
		spApiAuditLogsImpl.setUserName(spApiAuditLogs.getUserName());
		spApiAuditLogsImpl.setCreateDate(spApiAuditLogs.getCreateDate());
		spApiAuditLogsImpl.setModifiedDate(spApiAuditLogs.getModifiedDate());
		spApiAuditLogsImpl.setApiName(spApiAuditLogs.getApiName());
		spApiAuditLogsImpl.setParameters(spApiAuditLogs.getParameters());
		spApiAuditLogsImpl.setResult(spApiAuditLogs.getResult());

		return spApiAuditLogsImpl;
	}

	/**
	 * Returns the s p api audit logs with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p api audit logs
	 * @return the s p api audit logs
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a s p api audit logs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPApiAuditLogsException, SystemException {
		SPApiAuditLogs spApiAuditLogs = fetchByPrimaryKey(primaryKey);

		if (spApiAuditLogs == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPApiAuditLogsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spApiAuditLogs;
	}

	/**
	 * Returns the s p api audit logs with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException} if it could not be found.
	 *
	 * @param spApiAuditLogsId the primary key of the s p api audit logs
	 * @return the s p api audit logs
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPApiAuditLogsException if a s p api audit logs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs findByPrimaryKey(long spApiAuditLogsId)
		throws NoSuchSPApiAuditLogsException, SystemException {
		return findByPrimaryKey((Serializable)spApiAuditLogsId);
	}

	/**
	 * Returns the s p api audit logs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p api audit logs
	 * @return the s p api audit logs, or <code>null</code> if a s p api audit logs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPApiAuditLogs spApiAuditLogs = (SPApiAuditLogs)EntityCacheUtil.getResult(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
				SPApiAuditLogsImpl.class, primaryKey);

		if (spApiAuditLogs == _nullSPApiAuditLogs) {
			return null;
		}

		if (spApiAuditLogs == null) {
			Session session = null;

			try {
				session = openSession();

				spApiAuditLogs = (SPApiAuditLogs)session.get(SPApiAuditLogsImpl.class,
						primaryKey);

				if (spApiAuditLogs != null) {
					cacheResult(spApiAuditLogs);
				}
				else {
					EntityCacheUtil.putResult(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
						SPApiAuditLogsImpl.class, primaryKey,
						_nullSPApiAuditLogs);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPApiAuditLogsModelImpl.ENTITY_CACHE_ENABLED,
					SPApiAuditLogsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spApiAuditLogs;
	}

	/**
	 * Returns the s p api audit logs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spApiAuditLogsId the primary key of the s p api audit logs
	 * @return the s p api audit logs, or <code>null</code> if a s p api audit logs with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPApiAuditLogs fetchByPrimaryKey(long spApiAuditLogsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spApiAuditLogsId);
	}

	/**
	 * Returns all the s p api audit logses.
	 *
	 * @return the s p api audit logses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPApiAuditLogs> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p api audit logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p api audit logses
	 * @param end the upper bound of the range of s p api audit logses (not inclusive)
	 * @return the range of s p api audit logses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPApiAuditLogs> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p api audit logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPApiAuditLogsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p api audit logses
	 * @param end the upper bound of the range of s p api audit logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p api audit logses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPApiAuditLogs> findAll(int start, int end,
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

		List<SPApiAuditLogs> list = (List<SPApiAuditLogs>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPAPIAUDITLOGS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPAPIAUDITLOGS;

				if (pagination) {
					sql = sql.concat(SPApiAuditLogsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPApiAuditLogs>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPApiAuditLogs>(list);
				}
				else {
					list = (List<SPApiAuditLogs>)QueryUtil.list(q,
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
	 * Removes all the s p api audit logses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPApiAuditLogs spApiAuditLogs : findAll()) {
			remove(spApiAuditLogs);
		}
	}

	/**
	 * Returns the number of s p api audit logses.
	 *
	 * @return the number of s p api audit logses
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

				Query q = session.createQuery(_SQL_COUNT_SPAPIAUDITLOGS);

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
	 * Initializes the s p api audit logs persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.SPApiAuditLogs")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPApiAuditLogs>> listenersList = new ArrayList<ModelListener<SPApiAuditLogs>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPApiAuditLogs>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPApiAuditLogsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPAPIAUDITLOGS = "SELECT spApiAuditLogs FROM SPApiAuditLogs spApiAuditLogs";
	private static final String _SQL_SELECT_SPAPIAUDITLOGS_WHERE = "SELECT spApiAuditLogs FROM SPApiAuditLogs spApiAuditLogs WHERE ";
	private static final String _SQL_COUNT_SPAPIAUDITLOGS = "SELECT COUNT(spApiAuditLogs) FROM SPApiAuditLogs spApiAuditLogs";
	private static final String _SQL_COUNT_SPAPIAUDITLOGS_WHERE = "SELECT COUNT(spApiAuditLogs) FROM SPApiAuditLogs spApiAuditLogs WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spApiAuditLogs.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPApiAuditLogs exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPApiAuditLogs exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPApiAuditLogsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPApiAuditLogs _nullSPApiAuditLogs = new SPApiAuditLogsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPApiAuditLogs> toCacheModel() {
				return _nullSPApiAuditLogsCacheModel;
			}
		};

	private static CacheModel<SPApiAuditLogs> _nullSPApiAuditLogsCacheModel = new CacheModel<SPApiAuditLogs>() {
			@Override
			public SPApiAuditLogs toEntityModel() {
				return _nullSPApiAuditLogs;
			}
		};
}