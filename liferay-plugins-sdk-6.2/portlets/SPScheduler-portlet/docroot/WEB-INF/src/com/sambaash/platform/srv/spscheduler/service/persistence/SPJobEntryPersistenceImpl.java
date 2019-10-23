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

package com.sambaash.platform.srv.spscheduler.service.persistence;

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

import com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;
import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;
import com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryImpl;
import com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p job entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPJobEntryPersistence
 * @see SPJobEntryUtil
 * @generated
 */
public class SPJobEntryPersistenceImpl extends BasePersistenceImpl<SPJobEntry>
	implements SPJobEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPJobEntryUtil} to access the s p job entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPJobEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, SPJobEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, SPJobEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, SPJobEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, SPJobEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPJobEntryModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p job entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p job entries
	 * @param end the upper bound of the range of s p job entries (not inclusive)
	 * @return the range of matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p job entries
	 * @param end the upper bound of the range of s p job entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findByUuid(String uuid, int start, int end,
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

		List<SPJobEntry> list = (List<SPJobEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJobEntry spJobEntry : list) {
				if (!Validator.equals(uuid, spJobEntry.getUuid())) {
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

			query.append(_SQL_SELECT_SPJOBENTRY_WHERE);

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
				query.append(SPJobEntryModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPJobEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobEntry>(list);
				}
				else {
					list = (List<SPJobEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p job entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = fetchByUuid_First(uuid, orderByComparator);

		if (spJobEntry != null) {
			return spJobEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobEntryException(msg.toString());
	}

	/**
	 * Returns the first s p job entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJobEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (spJobEntry != null) {
			return spJobEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobEntryException(msg.toString());
	}

	/**
	 * Returns the last s p job entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPJobEntry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p job entries before and after the current s p job entry in the ordered set where uuid = &#63;.
	 *
	 * @param spJobEntryId the primary key of the current s p job entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry[] findByUuid_PrevAndNext(long spJobEntryId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = findByPrimaryKey(spJobEntryId);

		Session session = null;

		try {
			session = openSession();

			SPJobEntry[] array = new SPJobEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spJobEntry, uuid,
					orderByComparator, true);

			array[1] = spJobEntry;

			array[2] = getByUuid_PrevAndNext(session, spJobEntry, uuid,
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

	protected SPJobEntry getByUuid_PrevAndNext(Session session,
		SPJobEntry spJobEntry, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOBENTRY_WHERE);

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
			query.append(SPJobEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spJobEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJobEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p job entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPJobEntry spJobEntry : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spJobEntry);
		}
	}

	/**
	 * Returns the number of s p job entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p job entries
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

			query.append(_SQL_COUNT_SPJOBENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spJobEntry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spJobEntry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spJobEntry.uuid IS NULL OR spJobEntry.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, SPJobEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPJobEntryModelImpl.UUID_COLUMN_BITMASK |
			SPJobEntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p job entry where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = fetchByUUID_G(uuid, groupId);

		if (spJobEntry == null) {
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

			throw new NoSuchSPJobEntryException(msg.toString());
		}

		return spJobEntry;
	}

	/**
	 * Returns the s p job entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p job entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPJobEntry) {
			SPJobEntry spJobEntry = (SPJobEntry)result;

			if (!Validator.equals(uuid, spJobEntry.getUuid()) ||
					(groupId != spJobEntry.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPJOBENTRY_WHERE);

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

				List<SPJobEntry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPJobEntry spJobEntry = list.get(0);

					result = spJobEntry;

					cacheResult(spJobEntry);

					if ((spJobEntry.getUuid() == null) ||
							!spJobEntry.getUuid().equals(uuid) ||
							(spJobEntry.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spJobEntry);
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
			return (SPJobEntry)result;
		}
	}

	/**
	 * Removes the s p job entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p job entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = findByUUID_G(uuid, groupId);

		return remove(spJobEntry);
	}

	/**
	 * Returns the number of s p job entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p job entries
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

			query.append(_SQL_COUNT_SPJOBENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spJobEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spJobEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spJobEntry.uuid IS NULL OR spJobEntry.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spJobEntry.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, SPJobEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, SPJobEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPJobEntryModelImpl.UUID_COLUMN_BITMASK |
			SPJobEntryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p job entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p job entries
	 * @param end the upper bound of the range of s p job entries (not inclusive)
	 * @return the range of matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p job entries
	 * @param end the upper bound of the range of s p job entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findByUuid_C(String uuid, long companyId,
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

		List<SPJobEntry> list = (List<SPJobEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJobEntry spJobEntry : list) {
				if (!Validator.equals(uuid, spJobEntry.getUuid()) ||
						(companyId != spJobEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPJOBENTRY_WHERE);

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
				query.append(SPJobEntryModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPJobEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobEntry>(list);
				}
				else {
					list = (List<SPJobEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spJobEntry != null) {
			return spJobEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobEntryException(msg.toString());
	}

	/**
	 * Returns the first s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJobEntry> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spJobEntry != null) {
			return spJobEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobEntryException(msg.toString());
	}

	/**
	 * Returns the last s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPJobEntry> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p job entries before and after the current s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spJobEntryId the primary key of the current s p job entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry[] findByUuid_C_PrevAndNext(long spJobEntryId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = findByPrimaryKey(spJobEntryId);

		Session session = null;

		try {
			session = openSession();

			SPJobEntry[] array = new SPJobEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spJobEntry, uuid,
					companyId, orderByComparator, true);

			array[1] = spJobEntry;

			array[2] = getByUuid_C_PrevAndNext(session, spJobEntry, uuid,
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

	protected SPJobEntry getByUuid_C_PrevAndNext(Session session,
		SPJobEntry spJobEntry, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOBENTRY_WHERE);

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
			query.append(SPJobEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spJobEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJobEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p job entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPJobEntry spJobEntry : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJobEntry);
		}
	}

	/**
	 * Returns the number of s p job entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p job entries
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

			query.append(_SQL_COUNT_SPJOBENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spJobEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spJobEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spJobEntry.uuid IS NULL OR spJobEntry.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spJobEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBNAMEANDJOBCLASS =
		new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, SPJobEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobNameAndJobClass",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBNAMEANDJOBCLASS =
		new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, SPJobEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByJobNameAndJobClass",
			new String[] { String.class.getName(), String.class.getName() },
			SPJobEntryModelImpl.JOBNAME_COLUMN_BITMASK |
			SPJobEntryModelImpl.JOBCLASS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBNAMEANDJOBCLASS = new FinderPath(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJobNameAndJobClass",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the s p job entries where jobName = &#63; and jobClass = &#63;.
	 *
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @return the matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findByJobNameAndJobClass(String jobName,
		String jobClass) throws SystemException {
		return findByJobNameAndJobClass(jobName, jobClass, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job entries where jobName = &#63; and jobClass = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @param start the lower bound of the range of s p job entries
	 * @param end the upper bound of the range of s p job entries (not inclusive)
	 * @return the range of matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findByJobNameAndJobClass(String jobName,
		String jobClass, int start, int end) throws SystemException {
		return findByJobNameAndJobClass(jobName, jobClass, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job entries where jobName = &#63; and jobClass = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @param start the lower bound of the range of s p job entries
	 * @param end the upper bound of the range of s p job entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findByJobNameAndJobClass(String jobName,
		String jobClass, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBNAMEANDJOBCLASS;
			finderArgs = new Object[] { jobName, jobClass };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBNAMEANDJOBCLASS;
			finderArgs = new Object[] {
					jobName, jobClass,
					
					start, end, orderByComparator
				};
		}

		List<SPJobEntry> list = (List<SPJobEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJobEntry spJobEntry : list) {
				if (!Validator.equals(jobName, spJobEntry.getJobName()) ||
						!Validator.equals(jobClass, spJobEntry.getJobClass())) {
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

			query.append(_SQL_SELECT_SPJOBENTRY_WHERE);

			boolean bindJobName = false;

			if (jobName == null) {
				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_1);
			}
			else if (jobName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_3);
			}
			else {
				bindJobName = true;

				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_2);
			}

			boolean bindJobClass = false;

			if (jobClass == null) {
				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_1);
			}
			else if (jobClass.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_3);
			}
			else {
				bindJobClass = true;

				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobName) {
					qPos.add(jobName);
				}

				if (bindJobClass) {
					qPos.add(jobClass);
				}

				if (!pagination) {
					list = (List<SPJobEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobEntry>(list);
				}
				else {
					list = (List<SPJobEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	 *
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry findByJobNameAndJobClass_First(String jobName,
		String jobClass, OrderByComparator orderByComparator)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = fetchByJobNameAndJobClass_First(jobName,
				jobClass, orderByComparator);

		if (spJobEntry != null) {
			return spJobEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobName=");
		msg.append(jobName);

		msg.append(", jobClass=");
		msg.append(jobClass);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobEntryException(msg.toString());
	}

	/**
	 * Returns the first s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	 *
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByJobNameAndJobClass_First(String jobName,
		String jobClass, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPJobEntry> list = findByJobNameAndJobClass(jobName, jobClass, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	 *
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry findByJobNameAndJobClass_Last(String jobName,
		String jobClass, OrderByComparator orderByComparator)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = fetchByJobNameAndJobClass_Last(jobName,
				jobClass, orderByComparator);

		if (spJobEntry != null) {
			return spJobEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobName=");
		msg.append(jobName);

		msg.append(", jobClass=");
		msg.append(jobClass);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobEntryException(msg.toString());
	}

	/**
	 * Returns the last s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	 *
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByJobNameAndJobClass_Last(String jobName,
		String jobClass, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByJobNameAndJobClass(jobName, jobClass);

		if (count == 0) {
			return null;
		}

		List<SPJobEntry> list = findByJobNameAndJobClass(jobName, jobClass,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p job entries before and after the current s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	 *
	 * @param spJobEntryId the primary key of the current s p job entry
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry[] findByJobNameAndJobClass_PrevAndNext(
		long spJobEntryId, String jobName, String jobClass,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = findByPrimaryKey(spJobEntryId);

		Session session = null;

		try {
			session = openSession();

			SPJobEntry[] array = new SPJobEntryImpl[3];

			array[0] = getByJobNameAndJobClass_PrevAndNext(session, spJobEntry,
					jobName, jobClass, orderByComparator, true);

			array[1] = spJobEntry;

			array[2] = getByJobNameAndJobClass_PrevAndNext(session, spJobEntry,
					jobName, jobClass, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPJobEntry getByJobNameAndJobClass_PrevAndNext(Session session,
		SPJobEntry spJobEntry, String jobName, String jobClass,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOBENTRY_WHERE);

		boolean bindJobName = false;

		if (jobName == null) {
			query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_1);
		}
		else if (jobName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_3);
		}
		else {
			bindJobName = true;

			query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_2);
		}

		boolean bindJobClass = false;

		if (jobClass == null) {
			query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_1);
		}
		else if (jobClass.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_3);
		}
		else {
			bindJobClass = true;

			query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_2);
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
			query.append(SPJobEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobName) {
			qPos.add(jobName);
		}

		if (bindJobClass) {
			qPos.add(jobClass);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJobEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJobEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p job entries where jobName = &#63; and jobClass = &#63; from the database.
	 *
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByJobNameAndJobClass(String jobName, String jobClass)
		throws SystemException {
		for (SPJobEntry spJobEntry : findByJobNameAndJobClass(jobName,
				jobClass, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJobEntry);
		}
	}

	/**
	 * Returns the number of s p job entries where jobName = &#63; and jobClass = &#63;.
	 *
	 * @param jobName the job name
	 * @param jobClass the job class
	 * @return the number of matching s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJobNameAndJobClass(String jobName, String jobClass)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBNAMEANDJOBCLASS;

		Object[] finderArgs = new Object[] { jobName, jobClass };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPJOBENTRY_WHERE);

			boolean bindJobName = false;

			if (jobName == null) {
				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_1);
			}
			else if (jobName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_3);
			}
			else {
				bindJobName = true;

				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_2);
			}

			boolean bindJobClass = false;

			if (jobClass == null) {
				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_1);
			}
			else if (jobClass.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_3);
			}
			else {
				bindJobClass = true;

				query.append(_FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobName) {
					qPos.add(jobName);
				}

				if (bindJobClass) {
					qPos.add(jobClass);
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

	private static final String _FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_1 = "spJobEntry.jobName IS NULL AND ";
	private static final String _FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_2 = "spJobEntry.jobName = ? AND ";
	private static final String _FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBNAME_3 = "(spJobEntry.jobName IS NULL OR spJobEntry.jobName = '') AND ";
	private static final String _FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_1 = "spJobEntry.jobClass IS NULL";
	private static final String _FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_2 = "spJobEntry.jobClass = ?";
	private static final String _FINDER_COLUMN_JOBNAMEANDJOBCLASS_JOBCLASS_3 = "(spJobEntry.jobClass IS NULL OR spJobEntry.jobClass = '')";

	public SPJobEntryPersistenceImpl() {
		setModelClass(SPJobEntry.class);
	}

	/**
	 * Caches the s p job entry in the entity cache if it is enabled.
	 *
	 * @param spJobEntry the s p job entry
	 */
	@Override
	public void cacheResult(SPJobEntry spJobEntry) {
		EntityCacheUtil.putResult(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryImpl.class, spJobEntry.getPrimaryKey(), spJobEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spJobEntry.getUuid(), spJobEntry.getGroupId() },
			spJobEntry);

		spJobEntry.resetOriginalValues();
	}

	/**
	 * Caches the s p job entries in the entity cache if it is enabled.
	 *
	 * @param spJobEntries the s p job entries
	 */
	@Override
	public void cacheResult(List<SPJobEntry> spJobEntries) {
		for (SPJobEntry spJobEntry : spJobEntries) {
			if (EntityCacheUtil.getResult(
						SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
						SPJobEntryImpl.class, spJobEntry.getPrimaryKey()) == null) {
				cacheResult(spJobEntry);
			}
			else {
				spJobEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p job entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPJobEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPJobEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p job entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPJobEntry spJobEntry) {
		EntityCacheUtil.removeResult(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryImpl.class, spJobEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spJobEntry);
	}

	@Override
	public void clearCache(List<SPJobEntry> spJobEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPJobEntry spJobEntry : spJobEntries) {
			EntityCacheUtil.removeResult(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
				SPJobEntryImpl.class, spJobEntry.getPrimaryKey());

			clearUniqueFindersCache(spJobEntry);
		}
	}

	protected void cacheUniqueFindersCache(SPJobEntry spJobEntry) {
		if (spJobEntry.isNew()) {
			Object[] args = new Object[] {
					spJobEntry.getUuid(), spJobEntry.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spJobEntry);
		}
		else {
			SPJobEntryModelImpl spJobEntryModelImpl = (SPJobEntryModelImpl)spJobEntry;

			if ((spJobEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobEntry.getUuid(), spJobEntry.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spJobEntry);
			}
		}
	}

	protected void clearUniqueFindersCache(SPJobEntry spJobEntry) {
		SPJobEntryModelImpl spJobEntryModelImpl = (SPJobEntryModelImpl)spJobEntry;

		Object[] args = new Object[] {
				spJobEntry.getUuid(), spJobEntry.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spJobEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spJobEntryModelImpl.getOriginalUuid(),
					spJobEntryModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new s p job entry with the primary key. Does not add the s p job entry to the database.
	 *
	 * @param spJobEntryId the primary key for the new s p job entry
	 * @return the new s p job entry
	 */
	@Override
	public SPJobEntry create(long spJobEntryId) {
		SPJobEntry spJobEntry = new SPJobEntryImpl();

		spJobEntry.setNew(true);
		spJobEntry.setPrimaryKey(spJobEntryId);

		String uuid = PortalUUIDUtil.generate();

		spJobEntry.setUuid(uuid);

		return spJobEntry;
	}

	/**
	 * Removes the s p job entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spJobEntryId the primary key of the s p job entry
	 * @return the s p job entry that was removed
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry remove(long spJobEntryId)
		throws NoSuchSPJobEntryException, SystemException {
		return remove((Serializable)spJobEntryId);
	}

	/**
	 * Removes the s p job entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p job entry
	 * @return the s p job entry that was removed
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry remove(Serializable primaryKey)
		throws NoSuchSPJobEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPJobEntry spJobEntry = (SPJobEntry)session.get(SPJobEntryImpl.class,
					primaryKey);

			if (spJobEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPJobEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spJobEntry);
		}
		catch (NoSuchSPJobEntryException nsee) {
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
	protected SPJobEntry removeImpl(SPJobEntry spJobEntry)
		throws SystemException {
		spJobEntry = toUnwrappedModel(spJobEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spJobEntry)) {
				spJobEntry = (SPJobEntry)session.get(SPJobEntryImpl.class,
						spJobEntry.getPrimaryKeyObj());
			}

			if (spJobEntry != null) {
				session.delete(spJobEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spJobEntry != null) {
			clearCache(spJobEntry);
		}

		return spJobEntry;
	}

	@Override
	public SPJobEntry updateImpl(
		com.sambaash.platform.srv.spscheduler.model.SPJobEntry spJobEntry)
		throws SystemException {
		spJobEntry = toUnwrappedModel(spJobEntry);

		boolean isNew = spJobEntry.isNew();

		SPJobEntryModelImpl spJobEntryModelImpl = (SPJobEntryModelImpl)spJobEntry;

		if (Validator.isNull(spJobEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spJobEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spJobEntry.isNew()) {
				session.save(spJobEntry);

				spJobEntry.setNew(false);
			}
			else {
				session.merge(spJobEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPJobEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spJobEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobEntryModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spJobEntryModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spJobEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobEntryModelImpl.getOriginalUuid(),
						spJobEntryModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spJobEntryModelImpl.getUuid(),
						spJobEntryModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spJobEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBNAMEANDJOBCLASS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobEntryModelImpl.getOriginalJobName(),
						spJobEntryModelImpl.getOriginalJobClass()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBNAMEANDJOBCLASS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBNAMEANDJOBCLASS,
					args);

				args = new Object[] {
						spJobEntryModelImpl.getJobName(),
						spJobEntryModelImpl.getJobClass()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBNAMEANDJOBCLASS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBNAMEANDJOBCLASS,
					args);
			}
		}

		EntityCacheUtil.putResult(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPJobEntryImpl.class, spJobEntry.getPrimaryKey(), spJobEntry);

		clearUniqueFindersCache(spJobEntry);
		cacheUniqueFindersCache(spJobEntry);

		return spJobEntry;
	}

	protected SPJobEntry toUnwrappedModel(SPJobEntry spJobEntry) {
		if (spJobEntry instanceof SPJobEntryImpl) {
			return spJobEntry;
		}

		SPJobEntryImpl spJobEntryImpl = new SPJobEntryImpl();

		spJobEntryImpl.setNew(spJobEntry.isNew());
		spJobEntryImpl.setPrimaryKey(spJobEntry.getPrimaryKey());

		spJobEntryImpl.setUuid(spJobEntry.getUuid());
		spJobEntryImpl.setSpJobEntryId(spJobEntry.getSpJobEntryId());
		spJobEntryImpl.setGroupId(spJobEntry.getGroupId());
		spJobEntryImpl.setJobName(spJobEntry.getJobName());
		spJobEntryImpl.setJobClass(spJobEntry.getJobClass());
		spJobEntryImpl.setPortletId(spJobEntry.getPortletId());
		spJobEntryImpl.setStatus(spJobEntry.getStatus());
		spJobEntryImpl.setStatusMsg(spJobEntry.getStatusMsg());
		spJobEntryImpl.setCronExpression(spJobEntry.getCronExpression());
		spJobEntryImpl.setCompanyId(spJobEntry.getCompanyId());
		spJobEntryImpl.setUserId(spJobEntry.getUserId());
		spJobEntryImpl.setUserName(spJobEntry.getUserName());
		spJobEntryImpl.setCreateDate(spJobEntry.getCreateDate());
		spJobEntryImpl.setModifiedDate(spJobEntry.getModifiedDate());

		return spJobEntryImpl;
	}

	/**
	 * Returns the s p job entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job entry
	 * @return the s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPJobEntryException, SystemException {
		SPJobEntry spJobEntry = fetchByPrimaryKey(primaryKey);

		if (spJobEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPJobEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spJobEntry;
	}

	/**
	 * Returns the s p job entry with the primary key or throws a {@link com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException} if it could not be found.
	 *
	 * @param spJobEntryId the primary key of the s p job entry
	 * @return the s p job entry
	 * @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry findByPrimaryKey(long spJobEntryId)
		throws NoSuchSPJobEntryException, SystemException {
		return findByPrimaryKey((Serializable)spJobEntryId);
	}

	/**
	 * Returns the s p job entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job entry
	 * @return the s p job entry, or <code>null</code> if a s p job entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPJobEntry spJobEntry = (SPJobEntry)EntityCacheUtil.getResult(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
				SPJobEntryImpl.class, primaryKey);

		if (spJobEntry == _nullSPJobEntry) {
			return null;
		}

		if (spJobEntry == null) {
			Session session = null;

			try {
				session = openSession();

				spJobEntry = (SPJobEntry)session.get(SPJobEntryImpl.class,
						primaryKey);

				if (spJobEntry != null) {
					cacheResult(spJobEntry);
				}
				else {
					EntityCacheUtil.putResult(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
						SPJobEntryImpl.class, primaryKey, _nullSPJobEntry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPJobEntryModelImpl.ENTITY_CACHE_ENABLED,
					SPJobEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spJobEntry;
	}

	/**
	 * Returns the s p job entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spJobEntryId the primary key of the s p job entry
	 * @return the s p job entry, or <code>null</code> if a s p job entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobEntry fetchByPrimaryKey(long spJobEntryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spJobEntryId);
	}

	/**
	 * Returns all the s p job entries.
	 *
	 * @return the s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p job entries
	 * @param end the upper bound of the range of s p job entries (not inclusive)
	 * @return the range of s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p job entries
	 * @param end the upper bound of the range of s p job entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p job entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobEntry> findAll(int start, int end,
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

		List<SPJobEntry> list = (List<SPJobEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPJOBENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPJOBENTRY;

				if (pagination) {
					sql = sql.concat(SPJobEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPJobEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobEntry>(list);
				}
				else {
					list = (List<SPJobEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p job entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPJobEntry spJobEntry : findAll()) {
			remove(spJobEntry);
		}
	}

	/**
	 * Returns the number of s p job entries.
	 *
	 * @return the number of s p job entries
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

				Query q = session.createQuery(_SQL_COUNT_SPJOBENTRY);

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
	 * Initializes the s p job entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spscheduler.model.SPJobEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPJobEntry>> listenersList = new ArrayList<ModelListener<SPJobEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPJobEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPJobEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPJOBENTRY = "SELECT spJobEntry FROM SPJobEntry spJobEntry";
	private static final String _SQL_SELECT_SPJOBENTRY_WHERE = "SELECT spJobEntry FROM SPJobEntry spJobEntry WHERE ";
	private static final String _SQL_COUNT_SPJOBENTRY = "SELECT COUNT(spJobEntry) FROM SPJobEntry spJobEntry";
	private static final String _SQL_COUNT_SPJOBENTRY_WHERE = "SELECT COUNT(spJobEntry) FROM SPJobEntry spJobEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spJobEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPJobEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPJobEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPJobEntryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPJobEntry _nullSPJobEntry = new SPJobEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPJobEntry> toCacheModel() {
				return _nullSPJobEntryCacheModel;
			}
		};

	private static CacheModel<SPJobEntry> _nullSPJobEntryCacheModel = new CacheModel<SPJobEntry>() {
			@Override
			public SPJobEntry toEntityModel() {
				return _nullSPJobEntry;
			}
		};
}