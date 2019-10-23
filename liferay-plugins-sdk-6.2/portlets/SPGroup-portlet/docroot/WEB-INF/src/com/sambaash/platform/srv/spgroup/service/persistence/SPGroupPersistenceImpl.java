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

package com.sambaash.platform.srv.spgroup.service.persistence;

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

import com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.impl.SPGroupImpl;
import com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPGroupPersistence
 * @see SPGroupUtil
 * @generated
 */
public class SPGroupPersistenceImpl extends BasePersistenceImpl<SPGroup>
	implements SPGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPGroupUtil} to access the s p group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPGroupModelImpl.UUID_COLUMN_BITMASK |
			SPGroupModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p groups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @return the range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p groups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUuid(String uuid, int start, int end,
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

		List<SPGroup> list = (List<SPGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroup spGroup : list) {
				if (!Validator.equals(uuid, spGroup.getUuid())) {
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

			query.append(_SQL_SELECT_SPGROUP_WHERE);

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
				query.append(SPGroupModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroup>(list);
				}
				else {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByUuid_First(uuid, orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the first s p group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPGroup> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByUuid_Last(uuid, orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the last s p group in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPGroup> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p groups before and after the current s p group in the ordered set where uuid = &#63;.
	 *
	 * @param spGroupId the primary key of the current s p group
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup[] findByUuid_PrevAndNext(long spGroupId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = findByPrimaryKey(spGroupId);

		Session session = null;

		try {
			session = openSession();

			SPGroup[] array = new SPGroupImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spGroup, uuid,
					orderByComparator, true);

			array[1] = spGroup;

			array[2] = getByUuid_PrevAndNext(session, spGroup, uuid,
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

	protected SPGroup getByUuid_PrevAndNext(Session session, SPGroup spGroup,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPGROUP_WHERE);

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
			query.append(SPGroupModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p groups where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPGroup spGroup : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spGroup);
		}
	}

	/**
	 * Returns the number of s p groups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p groups
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

			query.append(_SQL_COUNT_SPGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spGroup.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spGroup.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spGroup.uuid IS NULL OR spGroup.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPGroupModelImpl.UUID_COLUMN_BITMASK |
			SPGroupModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p group where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchSPGroupException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByUUID_G(String uuid, long groupId)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByUUID_G(uuid, groupId);

		if (spGroup == null) {
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

			throw new NoSuchSPGroupException(msg.toString());
		}

		return spGroup;
	}

	/**
	 * Returns the s p group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPGroup) {
			SPGroup spGroup = (SPGroup)result;

			if (!Validator.equals(uuid, spGroup.getUuid()) ||
					(groupId != spGroup.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPGROUP_WHERE);

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

				List<SPGroup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPGroup spGroup = list.get(0);

					result = spGroup;

					cacheResult(spGroup);

					if ((spGroup.getUuid() == null) ||
							!spGroup.getUuid().equals(uuid) ||
							(spGroup.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spGroup);
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
			return (SPGroup)result;
		}
	}

	/**
	 * Removes the s p group where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p group that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = findByUUID_G(uuid, groupId);

		return remove(spGroup);
	}

	/**
	 * Returns the number of s p groups where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p groups
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

			query.append(_SQL_COUNT_SPGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spGroup.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spGroup.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spGroup.uuid IS NULL OR spGroup.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spGroup.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPGroupModelImpl.UUID_COLUMN_BITMASK |
			SPGroupModelImpl.COMPANYID_COLUMN_BITMASK |
			SPGroupModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p groups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @return the range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p groups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUuid_C(String uuid, long companyId, int start,
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

		List<SPGroup> list = (List<SPGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroup spGroup : list) {
				if (!Validator.equals(uuid, spGroup.getUuid()) ||
						(companyId != spGroup.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPGROUP_WHERE);

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
				query.append(SPGroupModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroup>(list);
				}
				else {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the first s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPGroup> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the last s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPGroup> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p groups before and after the current s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spGroupId the primary key of the current s p group
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup[] findByUuid_C_PrevAndNext(long spGroupId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = findByPrimaryKey(spGroupId);

		Session session = null;

		try {
			session = openSession();

			SPGroup[] array = new SPGroupImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spGroup, uuid,
					companyId, orderByComparator, true);

			array[1] = spGroup;

			array[2] = getByUuid_C_PrevAndNext(session, spGroup, uuid,
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

	protected SPGroup getByUuid_C_PrevAndNext(Session session, SPGroup spGroup,
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

		query.append(_SQL_SELECT_SPGROUP_WHERE);

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
			query.append(SPGroupModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p groups where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPGroup spGroup : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spGroup);
		}
	}

	/**
	 * Returns the number of s p groups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p groups
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

			query.append(_SQL_COUNT_SPGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spGroup.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spGroup.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spGroup.uuid IS NULL OR spGroup.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spGroup.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			SPGroupModelImpl.USERID_COLUMN_BITMASK |
			SPGroupModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @return the range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<SPGroup> list = (List<SPGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroup spGroup : list) {
				if ((userId != spGroup.getUserId())) {
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

			query.append(_SQL_SELECT_SPGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroup>(list);
				}
				else {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByUserId_First(userId, orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the first s p group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPGroup> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByUserId_Last(userId, orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the last s p group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SPGroup> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p groups before and after the current s p group in the ordered set where userId = &#63;.
	 *
	 * @param spGroupId the primary key of the current s p group
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup[] findByUserId_PrevAndNext(long spGroupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = findByPrimaryKey(spGroupId);

		Session session = null;

		try {
			session = openSession();

			SPGroup[] array = new SPGroupImpl[3];

			array[0] = getByUserId_PrevAndNext(session, spGroup, userId,
					orderByComparator, true);

			array[1] = spGroup;

			array[2] = getByUserId_PrevAndNext(session, spGroup, userId,
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

	protected SPGroup getByUserId_PrevAndNext(Session session, SPGroup spGroup,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPGROUP_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(SPGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p groups where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (SPGroup spGroup : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spGroup);
		}
	}

	/**
	 * Returns the number of s p groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "spGroup.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDSTATUS =
		new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS =
		new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SPGroupModelImpl.USERID_COLUMN_BITMASK |
			SPGroupModelImpl.STATUS_COLUMN_BITMASK |
			SPGroupModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDSTATUS = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the s p groups where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUserIdAndStatus(long userId, int status)
		throws SystemException {
		return findByUserIdAndStatus(userId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p groups where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @return the range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUserIdAndStatus(long userId, int status,
		int start, int end) throws SystemException {
		return findByUserIdAndStatus(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p groups where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByUserIdAndStatus(long userId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS;
			finderArgs = new Object[] { userId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDSTATUS;
			finderArgs = new Object[] {
					userId, status,
					
					start, end, orderByComparator
				};
		}

		List<SPGroup> list = (List<SPGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroup spGroup : list) {
				if ((userId != spGroup.getUserId()) ||
						(status != spGroup.getStatus())) {
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

			query.append(_SQL_SELECT_SPGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSTATUS_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

				if (!pagination) {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroup>(list);
				}
				else {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByUserIdAndStatus_First(long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByUserIdAndStatus_First(userId, status,
				orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the first s p group in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUserIdAndStatus_First(long userId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPGroup> list = findByUserIdAndStatus(userId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByUserIdAndStatus_Last(long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByUserIdAndStatus_Last(userId, status,
				orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the last s p group in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByUserIdAndStatus_Last(long userId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdAndStatus(userId, status);

		if (count == 0) {
			return null;
		}

		List<SPGroup> list = findByUserIdAndStatus(userId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p groups before and after the current s p group in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param spGroupId the primary key of the current s p group
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup[] findByUserIdAndStatus_PrevAndNext(long spGroupId,
		long userId, int status, OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = findByPrimaryKey(spGroupId);

		Session session = null;

		try {
			session = openSession();

			SPGroup[] array = new SPGroupImpl[3];

			array[0] = getByUserIdAndStatus_PrevAndNext(session, spGroup,
					userId, status, orderByComparator, true);

			array[1] = spGroup;

			array[2] = getByUserIdAndStatus_PrevAndNext(session, spGroup,
					userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPGroup getByUserIdAndStatus_PrevAndNext(Session session,
		SPGroup spGroup, long userId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPGROUP_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDSTATUS_USERID_2);

		query.append(_FINDER_COLUMN_USERIDANDSTATUS_STATUS_2);

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
			query.append(SPGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p groups where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndStatus(long userId, int status)
		throws SystemException {
		for (SPGroup spGroup : findByUserIdAndStatus(userId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spGroup);
		}
	}

	/**
	 * Returns the number of s p groups where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndStatus(long userId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDSTATUS;

		Object[] finderArgs = new Object[] { userId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSTATUS_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_USERIDANDSTATUS_USERID_2 = "spGroup.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDSTATUS_STATUS_2 = "spGroup.status = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByURLTitleAndGroupId",
			new String[] { Long.class.getName(), String.class.getName() },
			SPGroupModelImpl.GROUPID_COLUMN_BITMASK |
			SPGroupModelImpl.URLTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_URLTITLEANDGROUPID = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByURLTitleAndGroupId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the s p group where groupId = &#63; and urlTitle = &#63; or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchSPGroupException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByURLTitleAndGroupId(long groupId, String urlTitle)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByURLTitleAndGroupId(groupId, urlTitle);

		if (spGroup == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", urlTitle=");
			msg.append(urlTitle);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPGroupException(msg.toString());
		}

		return spGroup;
	}

	/**
	 * Returns the s p group where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByURLTitleAndGroupId(long groupId, String urlTitle)
		throws SystemException {
		return fetchByURLTitleAndGroupId(groupId, urlTitle, true);
	}

	/**
	 * Returns the s p group where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByURLTitleAndGroupId(long groupId, String urlTitle,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, urlTitle };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID,
					finderArgs, this);
		}

		if (result instanceof SPGroup) {
			SPGroup spGroup = (SPGroup)result;

			if ((groupId != spGroup.getGroupId()) ||
					!Validator.equals(urlTitle, spGroup.getUrlTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPGROUP_WHERE);

			query.append(_FINDER_COLUMN_URLTITLEANDGROUPID_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_URLTITLEANDGROUPID_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_URLTITLEANDGROUPID_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_URLTITLEANDGROUPID_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				List<SPGroup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID,
						finderArgs, list);
				}
				else {
					SPGroup spGroup = list.get(0);

					result = spGroup;

					cacheResult(spGroup);

					if ((spGroup.getGroupId() != groupId) ||
							(spGroup.getUrlTitle() == null) ||
							!spGroup.getUrlTitle().equals(urlTitle)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID,
							finderArgs, spGroup);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID,
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
			return (SPGroup)result;
		}
	}

	/**
	 * Removes the s p group where groupId = &#63; and urlTitle = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the s p group that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup removeByURLTitleAndGroupId(long groupId, String urlTitle)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = findByURLTitleAndGroupId(groupId, urlTitle);

		return remove(spGroup);
	}

	/**
	 * Returns the number of s p groups where groupId = &#63; and urlTitle = &#63;.
	 *
	 * @param groupId the group ID
	 * @param urlTitle the url title
	 * @return the number of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByURLTitleAndGroupId(long groupId, String urlTitle)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_URLTITLEANDGROUPID;

		Object[] finderArgs = new Object[] { groupId, urlTitle };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPGROUP_WHERE);

			query.append(_FINDER_COLUMN_URLTITLEANDGROUPID_GROUPID_2);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_URLTITLEANDGROUPID_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_URLTITLEANDGROUPID_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_URLTITLEANDGROUPID_URLTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
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

	private static final String _FINDER_COLUMN_URLTITLEANDGROUPID_GROUPID_2 = "spGroup.groupId = ? AND ";
	private static final String _FINDER_COLUMN_URLTITLEANDGROUPID_URLTITLE_1 = "spGroup.urlTitle IS NULL";
	private static final String _FINDER_COLUMN_URLTITLEANDGROUPID_URLTITLE_2 = "spGroup.urlTitle = ?";
	private static final String _FINDER_COLUMN_URLTITLEANDGROUPID_URLTITLE_3 = "(spGroup.urlTitle IS NULL OR spGroup.urlTitle = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDSTATUS =
		new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTypeAndStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDSTATUS =
		new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, SPGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTypeAndStatus",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			SPGroupModelImpl.TYPE_COLUMN_BITMASK |
			SPGroupModelImpl.STATUS_COLUMN_BITMASK |
			SPGroupModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDSTATUS = new FinderPath(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndStatus",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the s p groups where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByTypeAndStatus(int type, int status)
		throws SystemException {
		return findByTypeAndStatus(type, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p groups where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @return the range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByTypeAndStatus(int type, int status, int start,
		int end) throws SystemException {
		return findByTypeAndStatus(type, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p groups where type = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param status the status
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findByTypeAndStatus(int type, int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDSTATUS;
			finderArgs = new Object[] { type, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDSTATUS;
			finderArgs = new Object[] {
					type, status,
					
					start, end, orderByComparator
				};
		}

		List<SPGroup> list = (List<SPGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroup spGroup : list) {
				if ((type != spGroup.getType()) ||
						(status != spGroup.getStatus())) {
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

			query.append(_SQL_SELECT_SPGROUP_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_2);

			query.append(_FINDER_COLUMN_TYPEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				qPos.add(status);

				if (!pagination) {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroup>(list);
				}
				else {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByTypeAndStatus_First(int type, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByTypeAndStatus_First(type, status,
				orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the first s p group in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByTypeAndStatus_First(int type, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPGroup> list = findByTypeAndStatus(type, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByTypeAndStatus_Last(int type, int status,
		OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByTypeAndStatus_Last(type, status,
				orderByComparator);

		if (spGroup != null) {
			return spGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPGroupException(msg.toString());
	}

	/**
	 * Returns the last s p group in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByTypeAndStatus_Last(int type, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTypeAndStatus(type, status);

		if (count == 0) {
			return null;
		}

		List<SPGroup> list = findByTypeAndStatus(type, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p groups before and after the current s p group in the ordered set where type = &#63; and status = &#63;.
	 *
	 * @param spGroupId the primary key of the current s p group
	 * @param type the type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup[] findByTypeAndStatus_PrevAndNext(long spGroupId, int type,
		int status, OrderByComparator orderByComparator)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = findByPrimaryKey(spGroupId);

		Session session = null;

		try {
			session = openSession();

			SPGroup[] array = new SPGroupImpl[3];

			array[0] = getByTypeAndStatus_PrevAndNext(session, spGroup, type,
					status, orderByComparator, true);

			array[1] = spGroup;

			array[2] = getByTypeAndStatus_PrevAndNext(session, spGroup, type,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPGroup getByTypeAndStatus_PrevAndNext(Session session,
		SPGroup spGroup, int type, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPGROUP_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_2);

		query.append(_FINDER_COLUMN_TYPEANDSTATUS_STATUS_2);

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
			query.append(SPGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p groups where type = &#63; and status = &#63; from the database.
	 *
	 * @param type the type
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeAndStatus(int type, int status)
		throws SystemException {
		for (SPGroup spGroup : findByTypeAndStatus(type, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spGroup);
		}
	}

	/**
	 * Returns the number of s p groups where type = &#63; and status = &#63;.
	 *
	 * @param type the type
	 * @param status the status
	 * @return the number of matching s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeAndStatus(int type, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEANDSTATUS;

		Object[] finderArgs = new Object[] { type, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPGROUP_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDSTATUS_TYPE_2);

			query.append(_FINDER_COLUMN_TYPEANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_TYPEANDSTATUS_TYPE_2 = "spGroup.type = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDSTATUS_STATUS_2 = "spGroup.status = ?";

	public SPGroupPersistenceImpl() {
		setModelClass(SPGroup.class);
	}

	/**
	 * Caches the s p group in the entity cache if it is enabled.
	 *
	 * @param spGroup the s p group
	 */
	@Override
	public void cacheResult(SPGroup spGroup) {
		EntityCacheUtil.putResult(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupImpl.class, spGroup.getPrimaryKey(), spGroup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spGroup.getUuid(), spGroup.getGroupId() }, spGroup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID,
			new Object[] { spGroup.getGroupId(), spGroup.getUrlTitle() },
			spGroup);

		spGroup.resetOriginalValues();
	}

	/**
	 * Caches the s p groups in the entity cache if it is enabled.
	 *
	 * @param spGroups the s p groups
	 */
	@Override
	public void cacheResult(List<SPGroup> spGroups) {
		for (SPGroup spGroup : spGroups) {
			if (EntityCacheUtil.getResult(
						SPGroupModelImpl.ENTITY_CACHE_ENABLED,
						SPGroupImpl.class, spGroup.getPrimaryKey()) == null) {
				cacheResult(spGroup);
			}
			else {
				spGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPGroup spGroup) {
		EntityCacheUtil.removeResult(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupImpl.class, spGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spGroup);
	}

	@Override
	public void clearCache(List<SPGroup> spGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPGroup spGroup : spGroups) {
			EntityCacheUtil.removeResult(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
				SPGroupImpl.class, spGroup.getPrimaryKey());

			clearUniqueFindersCache(spGroup);
		}
	}

	protected void cacheUniqueFindersCache(SPGroup spGroup) {
		if (spGroup.isNew()) {
			Object[] args = new Object[] { spGroup.getUuid(), spGroup.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, spGroup);

			args = new Object[] { spGroup.getGroupId(), spGroup.getUrlTitle() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URLTITLEANDGROUPID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID,
				args, spGroup);
		}
		else {
			SPGroupModelImpl spGroupModelImpl = (SPGroupModelImpl)spGroup;

			if ((spGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroup.getUuid(), spGroup.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spGroup);
			}

			if ((spGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroup.getGroupId(), spGroup.getUrlTitle()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URLTITLEANDGROUPID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID,
					args, spGroup);
			}
		}
	}

	protected void clearUniqueFindersCache(SPGroup spGroup) {
		SPGroupModelImpl spGroupModelImpl = (SPGroupModelImpl)spGroup;

		Object[] args = new Object[] { spGroup.getUuid(), spGroup.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spGroupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spGroupModelImpl.getOriginalUuid(),
					spGroupModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { spGroup.getGroupId(), spGroup.getUrlTitle() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URLTITLEANDGROUPID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID,
			args);

		if ((spGroupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spGroupModelImpl.getOriginalGroupId(),
					spGroupModelImpl.getOriginalUrlTitle()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URLTITLEANDGROUPID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URLTITLEANDGROUPID,
				args);
		}
	}

	/**
	 * Creates a new s p group with the primary key. Does not add the s p group to the database.
	 *
	 * @param spGroupId the primary key for the new s p group
	 * @return the new s p group
	 */
	@Override
	public SPGroup create(long spGroupId) {
		SPGroup spGroup = new SPGroupImpl();

		spGroup.setNew(true);
		spGroup.setPrimaryKey(spGroupId);

		String uuid = PortalUUIDUtil.generate();

		spGroup.setUuid(uuid);

		return spGroup;
	}

	/**
	 * Removes the s p group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spGroupId the primary key of the s p group
	 * @return the s p group that was removed
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup remove(long spGroupId)
		throws NoSuchSPGroupException, SystemException {
		return remove((Serializable)spGroupId);
	}

	/**
	 * Removes the s p group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p group
	 * @return the s p group that was removed
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup remove(Serializable primaryKey)
		throws NoSuchSPGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPGroup spGroup = (SPGroup)session.get(SPGroupImpl.class, primaryKey);

			if (spGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spGroup);
		}
		catch (NoSuchSPGroupException nsee) {
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
	protected SPGroup removeImpl(SPGroup spGroup) throws SystemException {
		spGroup = toUnwrappedModel(spGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spGroup)) {
				spGroup = (SPGroup)session.get(SPGroupImpl.class,
						spGroup.getPrimaryKeyObj());
			}

			if (spGroup != null) {
				session.delete(spGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spGroup != null) {
			clearCache(spGroup);
		}

		return spGroup;
	}

	@Override
	public SPGroup updateImpl(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup)
		throws SystemException {
		spGroup = toUnwrappedModel(spGroup);

		boolean isNew = spGroup.isNew();

		SPGroupModelImpl spGroupModelImpl = (SPGroupModelImpl)spGroup;

		if (Validator.isNull(spGroup.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spGroup.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spGroup.isNew()) {
				session.save(spGroup);

				spGroup.setNew(false);
			}
			else {
				session.merge(spGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spGroupModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spGroupModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupModelImpl.getOriginalUuid(),
						spGroupModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spGroupModelImpl.getUuid(),
						spGroupModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { spGroupModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((spGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupModelImpl.getOriginalUserId(),
						spGroupModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS,
					args);

				args = new Object[] {
						spGroupModelImpl.getUserId(),
						spGroupModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS,
					args);
			}

			if ((spGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupModelImpl.getOriginalType(),
						spGroupModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDSTATUS,
					args);

				args = new Object[] {
						spGroupModelImpl.getType(), spGroupModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupImpl.class, spGroup.getPrimaryKey(), spGroup);

		clearUniqueFindersCache(spGroup);
		cacheUniqueFindersCache(spGroup);

		return spGroup;
	}

	protected SPGroup toUnwrappedModel(SPGroup spGroup) {
		if (spGroup instanceof SPGroupImpl) {
			return spGroup;
		}

		SPGroupImpl spGroupImpl = new SPGroupImpl();

		spGroupImpl.setNew(spGroup.isNew());
		spGroupImpl.setPrimaryKey(spGroup.getPrimaryKey());

		spGroupImpl.setUuid(spGroup.getUuid());
		spGroupImpl.setSpGroupId(spGroup.getSpGroupId());
		spGroupImpl.setGroupId(spGroup.getGroupId());
		spGroupImpl.setCompanyId(spGroup.getCompanyId());
		spGroupImpl.setUserId(spGroup.getUserId());
		spGroupImpl.setUserName(spGroup.getUserName());
		spGroupImpl.setCreateDate(spGroup.getCreateDate());
		spGroupImpl.setModifiedDate(spGroup.getModifiedDate());
		spGroupImpl.setTitle(spGroup.getTitle());
		spGroupImpl.setUrlTitle(spGroup.getUrlTitle());
		spGroupImpl.setDescription(spGroup.getDescription());
		spGroupImpl.setImageId(spGroup.getImageId());
		spGroupImpl.setType(spGroup.getType());
		spGroupImpl.setStatus(spGroup.getStatus());

		return spGroupImpl;
	}

	/**
	 * Returns the s p group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p group
	 * @return the s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPGroupException, SystemException {
		SPGroup spGroup = fetchByPrimaryKey(primaryKey);

		if (spGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spGroup;
	}

	/**
	 * Returns the s p group with the primary key or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchSPGroupException} if it could not be found.
	 *
	 * @param spGroupId the primary key of the s p group
	 * @return the s p group
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup findByPrimaryKey(long spGroupId)
		throws NoSuchSPGroupException, SystemException {
		return findByPrimaryKey((Serializable)spGroupId);
	}

	/**
	 * Returns the s p group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p group
	 * @return the s p group, or <code>null</code> if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPGroup spGroup = (SPGroup)EntityCacheUtil.getResult(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
				SPGroupImpl.class, primaryKey);

		if (spGroup == _nullSPGroup) {
			return null;
		}

		if (spGroup == null) {
			Session session = null;

			try {
				session = openSession();

				spGroup = (SPGroup)session.get(SPGroupImpl.class, primaryKey);

				if (spGroup != null) {
					cacheResult(spGroup);
				}
				else {
					EntityCacheUtil.putResult(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
						SPGroupImpl.class, primaryKey, _nullSPGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPGroupModelImpl.ENTITY_CACHE_ENABLED,
					SPGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spGroup;
	}

	/**
	 * Returns the s p group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spGroupId the primary key of the s p group
	 * @return the s p group, or <code>null</code> if a s p group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroup fetchByPrimaryKey(long spGroupId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spGroupId);
	}

	/**
	 * Returns all the s p groups.
	 *
	 * @return the s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @return the range of s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p groups
	 * @param end the upper bound of the range of s p groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroup> findAll(int start, int end,
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

		List<SPGroup> list = (List<SPGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPGROUP;

				if (pagination) {
					sql = sql.concat(SPGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroup>(list);
				}
				else {
					list = (List<SPGroup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPGroup spGroup : findAll()) {
			remove(spGroup);
		}
	}

	/**
	 * Returns the number of s p groups.
	 *
	 * @return the number of s p groups
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

				Query q = session.createQuery(_SQL_COUNT_SPGROUP);

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
	 * Initializes the s p group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spgroup.model.SPGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPGroup>> listenersList = new ArrayList<ModelListener<SPGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPGROUP = "SELECT spGroup FROM SPGroup spGroup";
	private static final String _SQL_SELECT_SPGROUP_WHERE = "SELECT spGroup FROM SPGroup spGroup WHERE ";
	private static final String _SQL_COUNT_SPGROUP = "SELECT COUNT(spGroup) FROM SPGroup spGroup";
	private static final String _SQL_COUNT_SPGROUP_WHERE = "SELECT COUNT(spGroup) FROM SPGroup spGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPGroupPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "type"
			});
	private static SPGroup _nullSPGroup = new SPGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPGroup> toCacheModel() {
				return _nullSPGroupCacheModel;
			}
		};

	private static CacheModel<SPGroup> _nullSPGroupCacheModel = new CacheModel<SPGroup>() {
			@Override
			public SPGroup toEntityModel() {
				return _nullSPGroup;
			}
		};
}