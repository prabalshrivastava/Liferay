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

package com.sambaash.platform.srv.roles.service.persistence;

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

import com.sambaash.platform.srv.roles.NoSuchSPRolesException;
import com.sambaash.platform.srv.roles.model.SPRoles;
import com.sambaash.platform.srv.roles.model.impl.SPRolesImpl;
import com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p roles service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPRolesPersistence
 * @see SPRolesUtil
 * @generated
 */
public class SPRolesPersistenceImpl extends BasePersistenceImpl<SPRoles>
	implements SPRolesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPRolesUtil} to access the s p roles persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPRolesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPRolesModelImpl.UUID_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p roleses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p roleses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByUuid(String uuid, int start, int end,
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

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPRoles spRoles : list) {
				if (!Validator.equals(uuid, spRoles.getUuid())) {
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

			query.append(_SQL_SELECT_SPROLES_WHERE);

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
				query.append(SPRolesModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p roles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByUuid_First(uuid, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the first s p roles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPRoles> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p roles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByUuid_Last(uuid, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the last s p roles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPRoles> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p roleses before and after the current s p roles in the ordered set where uuid = &#63;.
	 *
	 * @param spRoleId the primary key of the current s p roles
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles[] findByUuid_PrevAndNext(long spRoleId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByPrimaryKey(spRoleId);

		Session session = null;

		try {
			session = openSession();

			SPRoles[] array = new SPRolesImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spRoles, uuid,
					orderByComparator, true);

			array[1] = spRoles;

			array[2] = getByUuid_PrevAndNext(session, spRoles, uuid,
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

	protected SPRoles getByUuid_PrevAndNext(Session session, SPRoles spRoles,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPROLES_WHERE);

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
			query.append(SPRolesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p roleses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPRoles spRoles : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p roleses
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

			query.append(_SQL_COUNT_SPROLES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spRoles.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spRoles.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spRoles.uuid IS NULL OR spRoles.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPRolesModelImpl.UUID_COLUMN_BITMASK |
			SPRolesModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p roles where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPRolesException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByUUID_G(String uuid, long groupId)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByUUID_G(uuid, groupId);

		if (spRoles == null) {
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

			throw new NoSuchSPRolesException(msg.toString());
		}

		return spRoles;
	}

	/**
	 * Returns the s p roles where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p roles where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPRoles) {
			SPRoles spRoles = (SPRoles)result;

			if (!Validator.equals(uuid, spRoles.getUuid()) ||
					(groupId != spRoles.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPROLES_WHERE);

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

				List<SPRoles> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPRoles spRoles = list.get(0);

					result = spRoles;

					cacheResult(spRoles);

					if ((spRoles.getUuid() == null) ||
							!spRoles.getUuid().equals(uuid) ||
							(spRoles.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spRoles);
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
			return (SPRoles)result;
		}
	}

	/**
	 * Removes the s p roles where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p roles that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByUUID_G(uuid, groupId);

		return remove(spRoles);
	}

	/**
	 * Returns the number of s p roleses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p roleses
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

			query.append(_SQL_COUNT_SPROLES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spRoles.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spRoles.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spRoles.uuid IS NULL OR spRoles.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spRoles.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPRolesModelImpl.UUID_COLUMN_BITMASK |
			SPRolesModelImpl.COMPANYID_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p roleses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p roleses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByUuid_C(String uuid, long companyId, int start,
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

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPRoles spRoles : list) {
				if (!Validator.equals(uuid, spRoles.getUuid()) ||
						(companyId != spRoles.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPROLES_WHERE);

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
				query.append(SPRolesModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the first s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPRoles> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the last s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPRoles> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p roleses before and after the current s p roles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spRoleId the primary key of the current s p roles
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles[] findByUuid_C_PrevAndNext(long spRoleId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByPrimaryKey(spRoleId);

		Session session = null;

		try {
			session = openSession();

			SPRoles[] array = new SPRolesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spRoles, uuid,
					companyId, orderByComparator, true);

			array[1] = spRoles;

			array[2] = getByUuid_C_PrevAndNext(session, spRoles, uuid,
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

	protected SPRoles getByUuid_C_PrevAndNext(Session session, SPRoles spRoles,
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

		query.append(_SQL_SELECT_SPROLES_WHERE);

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
			query.append(SPRolesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p roleses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPRoles spRoles : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p roleses
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

			query.append(_SQL_COUNT_SPROLES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spRoles.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spRoles.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spRoles.uuid IS NULL OR spRoles.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spRoles.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEID = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoleId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoleId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPRolesModelImpl.GROUPID_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoleId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p roleses where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByRoleId(long groupId, long roleId)
		throws SystemException {
		return findByRoleId(groupId, roleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByRoleId(long groupId, long roleId, int start,
		int end) throws SystemException {
		return findByRoleId(groupId, roleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p roleses where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByRoleId(long groupId, long roleId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID;
			finderArgs = new Object[] { groupId, roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEID;
			finderArgs = new Object[] {
					groupId, roleId,
					
					start, end, orderByComparator
				};
		}

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPRoles spRoles : list) {
				if ((groupId != spRoles.getGroupId()) ||
						(roleId != spRoles.getRoleId())) {
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

			query.append(_SQL_SELECT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEID_GROUPID_2);

			query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				if (!pagination) {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByRoleId_First(long groupId, long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByRoleId_First(groupId, roleId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByRoleId_First(long groupId, long roleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPRoles> list = findByRoleId(groupId, roleId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByRoleId_Last(long groupId, long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByRoleId_Last(groupId, roleId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByRoleId_Last(long groupId, long roleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRoleId(groupId, roleId);

		if (count == 0) {
			return null;
		}

		List<SPRoles> list = findByRoleId(groupId, roleId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param spRoleId the primary key of the current s p roles
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles[] findByRoleId_PrevAndNext(long spRoleId, long groupId,
		long roleId, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByPrimaryKey(spRoleId);

		Session session = null;

		try {
			session = openSession();

			SPRoles[] array = new SPRolesImpl[3];

			array[0] = getByRoleId_PrevAndNext(session, spRoles, groupId,
					roleId, orderByComparator, true);

			array[1] = spRoles;

			array[2] = getByRoleId_PrevAndNext(session, spRoles, groupId,
					roleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPRoles getByRoleId_PrevAndNext(Session session, SPRoles spRoles,
		long groupId, long roleId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPROLES_WHERE);

		query.append(_FINDER_COLUMN_ROLEID_GROUPID_2);

		query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

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
			query.append(SPRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p roleses where groupId = &#63; and roleId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRoleId(long groupId, long roleId)
		throws SystemException {
		for (SPRoles spRoles : findByRoleId(groupId, roleId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the number of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRoleId(long groupId, long roleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEID;

		Object[] finderArgs = new Object[] { groupId, roleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEID_GROUPID_2);

			query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

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

	private static final String _FINDER_COLUMN_ROLEID_GROUPID_2 = "spRoles.groupId = ? AND ";
	private static final String _FINDER_COLUMN_ROLEID_ROLEID_2 = "spRoles.roleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID1 =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryId1",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID1 =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId1",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPRolesModelImpl.GROUPID_COLUMN_BITMASK |
			SPRolesModelImpl.CATEGORYID1_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID1 = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId1",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p roleses where groupId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @return the matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByCategoryId1(long groupId, long categoryId1)
		throws SystemException {
		return findByCategoryId1(groupId, categoryId1, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses where groupId = &#63; and categoryId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByCategoryId1(long groupId, long categoryId1,
		int start, int end) throws SystemException {
		return findByCategoryId1(groupId, categoryId1, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p roleses where groupId = &#63; and categoryId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByCategoryId1(long groupId, long categoryId1,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID1;
			finderArgs = new Object[] { groupId, categoryId1 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID1;
			finderArgs = new Object[] {
					groupId, categoryId1,
					
					start, end, orderByComparator
				};
		}

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPRoles spRoles : list) {
				if ((groupId != spRoles.getGroupId()) ||
						(categoryId1 != spRoles.getCategoryId1())) {
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

			query.append(_SQL_SELECT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID1_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYID1_CATEGORYID1_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId1);

				if (!pagination) {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByCategoryId1_First(long groupId, long categoryId1,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByCategoryId1_First(groupId, categoryId1,
				orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId1=");
		msg.append(categoryId1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the first s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByCategoryId1_First(long groupId, long categoryId1,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPRoles> list = findByCategoryId1(groupId, categoryId1, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByCategoryId1_Last(long groupId, long categoryId1,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByCategoryId1_Last(groupId, categoryId1,
				orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId1=");
		msg.append(categoryId1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByCategoryId1_Last(long groupId, long categoryId1,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryId1(groupId, categoryId1);

		if (count == 0) {
			return null;
		}

		List<SPRoles> list = findByCategoryId1(groupId, categoryId1, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and categoryId1 = &#63;.
	 *
	 * @param spRoleId the primary key of the current s p roles
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles[] findByCategoryId1_PrevAndNext(long spRoleId, long groupId,
		long categoryId1, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByPrimaryKey(spRoleId);

		Session session = null;

		try {
			session = openSession();

			SPRoles[] array = new SPRolesImpl[3];

			array[0] = getByCategoryId1_PrevAndNext(session, spRoles, groupId,
					categoryId1, orderByComparator, true);

			array[1] = spRoles;

			array[2] = getByCategoryId1_PrevAndNext(session, spRoles, groupId,
					categoryId1, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPRoles getByCategoryId1_PrevAndNext(Session session,
		SPRoles spRoles, long groupId, long categoryId1,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPROLES_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID1_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYID1_CATEGORYID1_2);

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
			query.append(SPRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId1);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p roleses where groupId = &#63; and categoryId1 = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryId1(long groupId, long categoryId1)
		throws SystemException {
		for (SPRoles spRoles : findByCategoryId1(groupId, categoryId1,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses where groupId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId1 the category id1
	 * @return the number of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryId1(long groupId, long categoryId1)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYID1;

		Object[] finderArgs = new Object[] { groupId, categoryId1 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID1_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYID1_CATEGORYID1_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId1);

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

	private static final String _FINDER_COLUMN_CATEGORYID1_GROUPID_2 = "spRoles.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYID1_CATEGORYID1_2 = "spRoles.categoryId1 = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDCATEGORYID1 =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoleIdCategoryId1",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID1 =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRoleIdCategoryId1",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPRolesModelImpl.GROUPID_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK |
			SPRolesModelImpl.CATEGORYID1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1 = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRoleIdCategoryId1",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @return the matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByRoleIdCategoryId1(long groupId, long roleId,
		long categoryId1) throws SystemException {
		return findByRoleIdCategoryId1(groupId, roleId, categoryId1,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByRoleIdCategoryId1(long groupId, long roleId,
		long categoryId1, int start, int end) throws SystemException {
		return findByRoleIdCategoryId1(groupId, roleId, categoryId1, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByRoleIdCategoryId1(long groupId, long roleId,
		long categoryId1, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID1;
			finderArgs = new Object[] { groupId, roleId, categoryId1 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDCATEGORYID1;
			finderArgs = new Object[] {
					groupId, roleId, categoryId1,
					
					start, end, orderByComparator
				};
		}

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPRoles spRoles : list) {
				if ((groupId != spRoles.getGroupId()) ||
						(roleId != spRoles.getRoleId()) ||
						(categoryId1 != spRoles.getCategoryId1())) {
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

			query.append(_SQL_SELECT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1_GROUPID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1_ROLEID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1_CATEGORYID1_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				qPos.add(categoryId1);

				if (!pagination) {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByRoleIdCategoryId1_First(long groupId, long roleId,
		long categoryId1, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByRoleIdCategoryId1_First(groupId, roleId,
				categoryId1, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(", categoryId1=");
		msg.append(categoryId1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByRoleIdCategoryId1_First(long groupId, long roleId,
		long categoryId1, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPRoles> list = findByRoleIdCategoryId1(groupId, roleId,
				categoryId1, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByRoleIdCategoryId1_Last(long groupId, long roleId,
		long categoryId1, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByRoleIdCategoryId1_Last(groupId, roleId,
				categoryId1, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(", categoryId1=");
		msg.append(categoryId1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByRoleIdCategoryId1_Last(long groupId, long roleId,
		long categoryId1, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRoleIdCategoryId1(groupId, roleId, categoryId1);

		if (count == 0) {
			return null;
		}

		List<SPRoles> list = findByRoleIdCategoryId1(groupId, roleId,
				categoryId1, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	 *
	 * @param spRoleId the primary key of the current s p roles
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles[] findByRoleIdCategoryId1_PrevAndNext(long spRoleId,
		long groupId, long roleId, long categoryId1,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByPrimaryKey(spRoleId);

		Session session = null;

		try {
			session = openSession();

			SPRoles[] array = new SPRolesImpl[3];

			array[0] = getByRoleIdCategoryId1_PrevAndNext(session, spRoles,
					groupId, roleId, categoryId1, orderByComparator, true);

			array[1] = spRoles;

			array[2] = getByRoleIdCategoryId1_PrevAndNext(session, spRoles,
					groupId, roleId, categoryId1, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPRoles getByRoleIdCategoryId1_PrevAndNext(Session session,
		SPRoles spRoles, long groupId, long roleId, long categoryId1,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPROLES_WHERE);

		query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1_GROUPID_2);

		query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1_ROLEID_2);

		query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1_CATEGORYID1_2);

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
			query.append(SPRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(roleId);

		qPos.add(categoryId1);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRoleIdCategoryId1(long groupId, long roleId,
		long categoryId1) throws SystemException {
		for (SPRoles spRoles : findByRoleIdCategoryId1(groupId, roleId,
				categoryId1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @return the number of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRoleIdCategoryId1(long groupId, long roleId,
		long categoryId1) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1;

		Object[] finderArgs = new Object[] { groupId, roleId, categoryId1 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1_GROUPID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1_ROLEID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1_CATEGORYID1_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				qPos.add(categoryId1);

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

	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID1_GROUPID_2 = "spRoles.groupId = ? AND ";
	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID1_ROLEID_2 = "spRoles.roleId = ? AND ";
	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID1_CATEGORYID1_2 = "spRoles.categoryId1 = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDCATEGORYID2 =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoleIdCategoryId2",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID2 =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRoleIdCategoryId2",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPRolesModelImpl.GROUPID_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK |
			SPRolesModelImpl.CATEGORYID2_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID2 = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRoleIdCategoryId2",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @return the matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByRoleIdCategoryId2(long groupId, long roleId,
		long categoryId2) throws SystemException {
		return findByRoleIdCategoryId2(groupId, roleId, categoryId2,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByRoleIdCategoryId2(long groupId, long roleId,
		long categoryId2, int start, int end) throws SystemException {
		return findByRoleIdCategoryId2(groupId, roleId, categoryId2, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByRoleIdCategoryId2(long groupId, long roleId,
		long categoryId2, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID2;
			finderArgs = new Object[] { groupId, roleId, categoryId2 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDCATEGORYID2;
			finderArgs = new Object[] {
					groupId, roleId, categoryId2,
					
					start, end, orderByComparator
				};
		}

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPRoles spRoles : list) {
				if ((groupId != spRoles.getGroupId()) ||
						(roleId != spRoles.getRoleId()) ||
						(categoryId2 != spRoles.getCategoryId2())) {
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

			query.append(_SQL_SELECT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID2_GROUPID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID2_ROLEID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID2_CATEGORYID2_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				qPos.add(categoryId2);

				if (!pagination) {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByRoleIdCategoryId2_First(long groupId, long roleId,
		long categoryId2, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByRoleIdCategoryId2_First(groupId, roleId,
				categoryId2, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(", categoryId2=");
		msg.append(categoryId2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the first s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByRoleIdCategoryId2_First(long groupId, long roleId,
		long categoryId2, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPRoles> list = findByRoleIdCategoryId2(groupId, roleId,
				categoryId2, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByRoleIdCategoryId2_Last(long groupId, long roleId,
		long categoryId2, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByRoleIdCategoryId2_Last(groupId, roleId,
				categoryId2, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(", categoryId2=");
		msg.append(categoryId2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByRoleIdCategoryId2_Last(long groupId, long roleId,
		long categoryId2, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRoleIdCategoryId2(groupId, roleId, categoryId2);

		if (count == 0) {
			return null;
		}

		List<SPRoles> list = findByRoleIdCategoryId2(groupId, roleId,
				categoryId2, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	 *
	 * @param spRoleId the primary key of the current s p roles
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles[] findByRoleIdCategoryId2_PrevAndNext(long spRoleId,
		long groupId, long roleId, long categoryId2,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByPrimaryKey(spRoleId);

		Session session = null;

		try {
			session = openSession();

			SPRoles[] array = new SPRolesImpl[3];

			array[0] = getByRoleIdCategoryId2_PrevAndNext(session, spRoles,
					groupId, roleId, categoryId2, orderByComparator, true);

			array[1] = spRoles;

			array[2] = getByRoleIdCategoryId2_PrevAndNext(session, spRoles,
					groupId, roleId, categoryId2, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPRoles getByRoleIdCategoryId2_PrevAndNext(Session session,
		SPRoles spRoles, long groupId, long roleId, long categoryId2,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPROLES_WHERE);

		query.append(_FINDER_COLUMN_ROLEIDCATEGORYID2_GROUPID_2);

		query.append(_FINDER_COLUMN_ROLEIDCATEGORYID2_ROLEID_2);

		query.append(_FINDER_COLUMN_ROLEIDCATEGORYID2_CATEGORYID2_2);

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
			query.append(SPRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(roleId);

		qPos.add(categoryId2);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRoleIdCategoryId2(long groupId, long roleId,
		long categoryId2) throws SystemException {
		for (SPRoles spRoles : findByRoleIdCategoryId2(groupId, roleId,
				categoryId2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses where groupId = &#63; and roleId = &#63; and categoryId2 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId2 the category id2
	 * @return the number of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRoleIdCategoryId2(long groupId, long roleId,
		long categoryId2) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID2;

		Object[] finderArgs = new Object[] { groupId, roleId, categoryId2 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID2_GROUPID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID2_ROLEID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID2_CATEGORYID2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				qPos.add(categoryId2);

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

	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID2_GROUPID_2 = "spRoles.groupId = ? AND ";
	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID2_ROLEID_2 = "spRoles.roleId = ? AND ";
	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID2_CATEGORYID2_2 = "spRoles.categoryId2 = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2 =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRoleIdCategoryId1AndCategoryId2",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			SPRolesModelImpl.GROUPID_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK |
			SPRolesModelImpl.CATEGORYID1_COLUMN_BITMASK |
			SPRolesModelImpl.CATEGORYID2_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1ANDCATEGORYID2 =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRoleIdCategoryId1AndCategoryId2",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the s p roles where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63; or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPRolesException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param categoryId2 the category id2
	 * @return the matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByRoleIdCategoryId1AndCategoryId2(long groupId,
		long roleId, long categoryId1, long categoryId2)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByRoleIdCategoryId1AndCategoryId2(groupId,
				roleId, categoryId1, categoryId2);

		if (spRoles == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", roleId=");
			msg.append(roleId);

			msg.append(", categoryId1=");
			msg.append(categoryId1);

			msg.append(", categoryId2=");
			msg.append(categoryId2);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPRolesException(msg.toString());
		}

		return spRoles;
	}

	/**
	 * Returns the s p roles where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param categoryId2 the category id2
	 * @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByRoleIdCategoryId1AndCategoryId2(long groupId,
		long roleId, long categoryId1, long categoryId2)
		throws SystemException {
		return fetchByRoleIdCategoryId1AndCategoryId2(groupId, roleId,
			categoryId1, categoryId2, true);
	}

	/**
	 * Returns the s p roles where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param categoryId2 the category id2
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByRoleIdCategoryId1AndCategoryId2(long groupId,
		long roleId, long categoryId1, long categoryId2,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, roleId, categoryId1, categoryId2
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
					finderArgs, this);
		}

		if (result instanceof SPRoles) {
			SPRoles spRoles = (SPRoles)result;

			if ((groupId != spRoles.getGroupId()) ||
					(roleId != spRoles.getRoleId()) ||
					(categoryId1 != spRoles.getCategoryId1()) ||
					(categoryId2 != spRoles.getCategoryId2())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_GROUPID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_ROLEID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_CATEGORYID1_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_CATEGORYID2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				qPos.add(categoryId1);

				qPos.add(categoryId2);

				List<SPRoles> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPRolesPersistenceImpl.fetchByRoleIdCategoryId1AndCategoryId2(long, long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPRoles spRoles = list.get(0);

					result = spRoles;

					cacheResult(spRoles);

					if ((spRoles.getGroupId() != groupId) ||
							(spRoles.getRoleId() != roleId) ||
							(spRoles.getCategoryId1() != categoryId1) ||
							(spRoles.getCategoryId2() != categoryId2)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
							finderArgs, spRoles);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
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
			return (SPRoles)result;
		}
	}

	/**
	 * Removes the s p roles where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param categoryId2 the category id2
	 * @return the s p roles that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles removeByRoleIdCategoryId1AndCategoryId2(long groupId,
		long roleId, long categoryId1, long categoryId2)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByRoleIdCategoryId1AndCategoryId2(groupId,
				roleId, categoryId1, categoryId2);

		return remove(spRoles);
	}

	/**
	 * Returns the number of s p roleses where groupId = &#63; and roleId = &#63; and categoryId1 = &#63; and categoryId2 = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param categoryId1 the category id1
	 * @param categoryId2 the category id2
	 * @return the number of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRoleIdCategoryId1AndCategoryId2(long groupId,
		long roleId, long categoryId1, long categoryId2)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1ANDCATEGORYID2;

		Object[] finderArgs = new Object[] {
				groupId, roleId, categoryId1, categoryId2
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_GROUPID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_ROLEID_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_CATEGORYID1_2);

			query.append(_FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_CATEGORYID2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				qPos.add(categoryId1);

				qPos.add(categoryId2);

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

	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_GROUPID_2 =
		"spRoles.groupId = ? AND ";
	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_ROLEID_2 =
		"spRoles.roleId = ? AND ";
	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_CATEGORYID1_2 =
		"spRoles.categoryId1 = ? AND ";
	private static final String _FINDER_COLUMN_ROLEIDCATEGORYID1ANDCATEGORYID2_CATEGORYID2_2 =
		"spRoles.categoryId2 = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYCATEGORYID =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCountryCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYID =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPRolesModelImpl.GROUPID_COLUMN_BITMASK |
			SPRolesModelImpl.COUNTRYCATEGORYID_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYCATEGORYID = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p roleses where groupId = &#63; and countryCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @return the matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByCountryCategoryId(long groupId,
		long countryCategoryId) throws SystemException {
		return findByCountryCategoryId(groupId, countryCategoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses where groupId = &#63; and countryCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByCountryCategoryId(long groupId,
		long countryCategoryId, int start, int end) throws SystemException {
		return findByCountryCategoryId(groupId, countryCategoryId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p roleses where groupId = &#63; and countryCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByCountryCategoryId(long groupId,
		long countryCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYID;
			finderArgs = new Object[] { groupId, countryCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYCATEGORYID;
			finderArgs = new Object[] {
					groupId, countryCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPRoles spRoles : list) {
				if ((groupId != spRoles.getGroupId()) ||
						(countryCategoryId != spRoles.getCountryCategoryId())) {
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

			query.append(_SQL_SELECT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYID_COUNTRYCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(countryCategoryId);

				if (!pagination) {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByCountryCategoryId_First(long groupId,
		long countryCategoryId, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByCountryCategoryId_First(groupId,
				countryCategoryId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", countryCategoryId=");
		msg.append(countryCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the first s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByCountryCategoryId_First(long groupId,
		long countryCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPRoles> list = findByCountryCategoryId(groupId,
				countryCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByCountryCategoryId_Last(long groupId,
		long countryCategoryId, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByCountryCategoryId_Last(groupId,
				countryCategoryId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", countryCategoryId=");
		msg.append(countryCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByCountryCategoryId_Last(long groupId,
		long countryCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCountryCategoryId(groupId, countryCategoryId);

		if (count == 0) {
			return null;
		}

		List<SPRoles> list = findByCountryCategoryId(groupId,
				countryCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63;.
	 *
	 * @param spRoleId the primary key of the current s p roles
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles[] findByCountryCategoryId_PrevAndNext(long spRoleId,
		long groupId, long countryCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByPrimaryKey(spRoleId);

		Session session = null;

		try {
			session = openSession();

			SPRoles[] array = new SPRolesImpl[3];

			array[0] = getByCountryCategoryId_PrevAndNext(session, spRoles,
					groupId, countryCategoryId, orderByComparator, true);

			array[1] = spRoles;

			array[2] = getByCountryCategoryId_PrevAndNext(session, spRoles,
					groupId, countryCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPRoles getByCountryCategoryId_PrevAndNext(Session session,
		SPRoles spRoles, long groupId, long countryCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPROLES_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYCATEGORYID_GROUPID_2);

		query.append(_FINDER_COLUMN_COUNTRYCATEGORYID_COUNTRYCATEGORYID_2);

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
			query.append(SPRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(countryCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p roleses where groupId = &#63; and countryCategoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryCategoryId(long groupId, long countryCategoryId)
		throws SystemException {
		for (SPRoles spRoles : findByCountryCategoryId(groupId,
				countryCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses where groupId = &#63; and countryCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @return the number of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryCategoryId(long groupId, long countryCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYCATEGORYID;

		Object[] finderArgs = new Object[] { groupId, countryCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYID_COUNTRYCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(countryCategoryId);

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

	private static final String _FINDER_COLUMN_COUNTRYCATEGORYID_GROUPID_2 = "spRoles.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYCATEGORYID_COUNTRYCATEGORYID_2 =
		"spRoles.countryCategoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTCATEGORYID =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartmentCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCATEGORYID =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPRolesModelImpl.GROUPID_COLUMN_BITMASK |
			SPRolesModelImpl.DEPARTMENTCATEGORYID_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTCATEGORYID = new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p roleses where groupId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @return the matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByDepartmentCategoryId(long groupId,
		long departmentCategoryId) throws SystemException {
		return findByDepartmentCategoryId(groupId, departmentCategoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses where groupId = &#63; and departmentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByDepartmentCategoryId(long groupId,
		long departmentCategoryId, int start, int end)
		throws SystemException {
		return findByDepartmentCategoryId(groupId, departmentCategoryId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p roleses where groupId = &#63; and departmentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByDepartmentCategoryId(long groupId,
		long departmentCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCATEGORYID;
			finderArgs = new Object[] { groupId, departmentCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTCATEGORYID;
			finderArgs = new Object[] {
					groupId, departmentCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPRoles spRoles : list) {
				if ((groupId != spRoles.getGroupId()) ||
						(departmentCategoryId != spRoles.getDepartmentCategoryId())) {
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

			query.append(_SQL_SELECT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTCATEGORYID_DEPARTMENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(departmentCategoryId);

				if (!pagination) {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByDepartmentCategoryId_First(long groupId,
		long departmentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByDepartmentCategoryId_First(groupId,
				departmentCategoryId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", departmentCategoryId=");
		msg.append(departmentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the first s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByDepartmentCategoryId_First(long groupId,
		long departmentCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPRoles> list = findByDepartmentCategoryId(groupId,
				departmentCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByDepartmentCategoryId_Last(long groupId,
		long departmentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByDepartmentCategoryId_Last(groupId,
				departmentCategoryId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", departmentCategoryId=");
		msg.append(departmentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByDepartmentCategoryId_Last(long groupId,
		long departmentCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDepartmentCategoryId(groupId, departmentCategoryId);

		if (count == 0) {
			return null;
		}

		List<SPRoles> list = findByDepartmentCategoryId(groupId,
				departmentCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param spRoleId the primary key of the current s p roles
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles[] findByDepartmentCategoryId_PrevAndNext(long spRoleId,
		long groupId, long departmentCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByPrimaryKey(spRoleId);

		Session session = null;

		try {
			session = openSession();

			SPRoles[] array = new SPRolesImpl[3];

			array[0] = getByDepartmentCategoryId_PrevAndNext(session, spRoles,
					groupId, departmentCategoryId, orderByComparator, true);

			array[1] = spRoles;

			array[2] = getByDepartmentCategoryId_PrevAndNext(session, spRoles,
					groupId, departmentCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPRoles getByDepartmentCategoryId_PrevAndNext(Session session,
		SPRoles spRoles, long groupId, long departmentCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPROLES_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTCATEGORYID_GROUPID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTCATEGORYID_DEPARTMENTCATEGORYID_2);

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
			query.append(SPRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(departmentCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p roleses where groupId = &#63; and departmentCategoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDepartmentCategoryId(long groupId,
		long departmentCategoryId) throws SystemException {
		for (SPRoles spRoles : findByDepartmentCategoryId(groupId,
				departmentCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses where groupId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param departmentCategoryId the department category ID
	 * @return the number of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDepartmentCategoryId(long groupId,
		long departmentCategoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPARTMENTCATEGORYID;

		Object[] finderArgs = new Object[] { groupId, departmentCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTCATEGORYID_DEPARTMENTCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(departmentCategoryId);

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

	private static final String _FINDER_COLUMN_DEPARTMENTCATEGORYID_GROUPID_2 = "spRoles.groupId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTCATEGORYID_DEPARTMENTCATEGORYID_2 =
		"spRoles.departmentCategoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryCategoryIdAndDepartmentCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, SPRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryCategoryIdAndDepartmentCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPRolesModelImpl.GROUPID_COLUMN_BITMASK |
			SPRolesModelImpl.COUNTRYCATEGORYID_COLUMN_BITMASK |
			SPRolesModelImpl.DEPARTMENTCATEGORYID_COLUMN_BITMASK |
			SPRolesModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID =
		new FinderPath(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryCategoryIdAndDepartmentCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @return the matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByCountryCategoryIdAndDepartmentCategoryId(
		long groupId, long countryCategoryId, long departmentCategoryId)
		throws SystemException {
		return findByCountryCategoryIdAndDepartmentCategoryId(groupId,
			countryCategoryId, departmentCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByCountryCategoryIdAndDepartmentCategoryId(
		long groupId, long countryCategoryId, long departmentCategoryId,
		int start, int end) throws SystemException {
		return findByCountryCategoryIdAndDepartmentCategoryId(groupId,
			countryCategoryId, departmentCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findByCountryCategoryIdAndDepartmentCategoryId(
		long groupId, long countryCategoryId, long departmentCategoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID;
			finderArgs = new Object[] {
					groupId, countryCategoryId, departmentCategoryId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID;
			finderArgs = new Object[] {
					groupId, countryCategoryId, departmentCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPRoles spRoles : list) {
				if ((groupId != spRoles.getGroupId()) ||
						(countryCategoryId != spRoles.getCountryCategoryId()) ||
						(departmentCategoryId != spRoles.getDepartmentCategoryId())) {
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

			query.append(_SQL_SELECT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_COUNTRYCATEGORYID_2);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_DEPARTMENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(countryCategoryId);

				qPos.add(departmentCategoryId);

				if (!pagination) {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByCountryCategoryIdAndDepartmentCategoryId_First(
		long groupId, long countryCategoryId, long departmentCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByCountryCategoryIdAndDepartmentCategoryId_First(groupId,
				countryCategoryId, departmentCategoryId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", countryCategoryId=");
		msg.append(countryCategoryId);

		msg.append(", departmentCategoryId=");
		msg.append(departmentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the first s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByCountryCategoryIdAndDepartmentCategoryId_First(
		long groupId, long countryCategoryId, long departmentCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPRoles> list = findByCountryCategoryIdAndDepartmentCategoryId(groupId,
				countryCategoryId, departmentCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByCountryCategoryIdAndDepartmentCategoryId_Last(
		long groupId, long countryCategoryId, long departmentCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByCountryCategoryIdAndDepartmentCategoryId_Last(groupId,
				countryCategoryId, departmentCategoryId, orderByComparator);

		if (spRoles != null) {
			return spRoles;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", countryCategoryId=");
		msg.append(countryCategoryId);

		msg.append(", departmentCategoryId=");
		msg.append(departmentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPRolesException(msg.toString());
	}

	/**
	 * Returns the last s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p roles, or <code>null</code> if a matching s p roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByCountryCategoryIdAndDepartmentCategoryId_Last(
		long groupId, long countryCategoryId, long departmentCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountryCategoryIdAndDepartmentCategoryId(groupId,
				countryCategoryId, departmentCategoryId);

		if (count == 0) {
			return null;
		}

		List<SPRoles> list = findByCountryCategoryIdAndDepartmentCategoryId(groupId,
				countryCategoryId, departmentCategoryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p roleses before and after the current s p roles in the ordered set where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param spRoleId the primary key of the current s p roles
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles[] findByCountryCategoryIdAndDepartmentCategoryId_PrevAndNext(
		long spRoleId, long groupId, long countryCategoryId,
		long departmentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = findByPrimaryKey(spRoleId);

		Session session = null;

		try {
			session = openSession();

			SPRoles[] array = new SPRolesImpl[3];

			array[0] = getByCountryCategoryIdAndDepartmentCategoryId_PrevAndNext(session,
					spRoles, groupId, countryCategoryId, departmentCategoryId,
					orderByComparator, true);

			array[1] = spRoles;

			array[2] = getByCountryCategoryIdAndDepartmentCategoryId_PrevAndNext(session,
					spRoles, groupId, countryCategoryId, departmentCategoryId,
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

	protected SPRoles getByCountryCategoryIdAndDepartmentCategoryId_PrevAndNext(
		Session session, SPRoles spRoles, long groupId, long countryCategoryId,
		long departmentCategoryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPROLES_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_GROUPID_2);

		query.append(_FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_COUNTRYCATEGORYID_2);

		query.append(_FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_DEPARTMENTCATEGORYID_2);

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
			query.append(SPRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(countryCategoryId);

		qPos.add(departmentCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryCategoryIdAndDepartmentCategoryId(long groupId,
		long countryCategoryId, long departmentCategoryId)
		throws SystemException {
		for (SPRoles spRoles : findByCountryCategoryIdAndDepartmentCategoryId(
				groupId, countryCategoryId, departmentCategoryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses where groupId = &#63; and countryCategoryId = &#63; and departmentCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryCategoryId the country category ID
	 * @param departmentCategoryId the department category ID
	 * @return the number of matching s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryCategoryIdAndDepartmentCategoryId(long groupId,
		long countryCategoryId, long departmentCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID;

		Object[] finderArgs = new Object[] {
				groupId, countryCategoryId, departmentCategoryId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPROLES_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_COUNTRYCATEGORYID_2);

			query.append(_FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_DEPARTMENTCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(countryCategoryId);

				qPos.add(departmentCategoryId);

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

	private static final String _FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_GROUPID_2 =
		"spRoles.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_COUNTRYCATEGORYID_2 =
		"spRoles.countryCategoryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID_DEPARTMENTCATEGORYID_2 =
		"spRoles.departmentCategoryId = ?";

	public SPRolesPersistenceImpl() {
		setModelClass(SPRoles.class);
	}

	/**
	 * Caches the s p roles in the entity cache if it is enabled.
	 *
	 * @param spRoles the s p roles
	 */
	@Override
	public void cacheResult(SPRoles spRoles) {
		EntityCacheUtil.putResult(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesImpl.class, spRoles.getPrimaryKey(), spRoles);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spRoles.getUuid(), spRoles.getGroupId() }, spRoles);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
			new Object[] {
				spRoles.getGroupId(), spRoles.getRoleId(),
				spRoles.getCategoryId1(), spRoles.getCategoryId2()
			}, spRoles);

		spRoles.resetOriginalValues();
	}

	/**
	 * Caches the s p roleses in the entity cache if it is enabled.
	 *
	 * @param spRoleses the s p roleses
	 */
	@Override
	public void cacheResult(List<SPRoles> spRoleses) {
		for (SPRoles spRoles : spRoleses) {
			if (EntityCacheUtil.getResult(
						SPRolesModelImpl.ENTITY_CACHE_ENABLED,
						SPRolesImpl.class, spRoles.getPrimaryKey()) == null) {
				cacheResult(spRoles);
			}
			else {
				spRoles.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p roleses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPRolesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPRolesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPRoles spRoles) {
		EntityCacheUtil.removeResult(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesImpl.class, spRoles.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spRoles);
	}

	@Override
	public void clearCache(List<SPRoles> spRoleses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPRoles spRoles : spRoleses) {
			EntityCacheUtil.removeResult(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
				SPRolesImpl.class, spRoles.getPrimaryKey());

			clearUniqueFindersCache(spRoles);
		}
	}

	protected void cacheUniqueFindersCache(SPRoles spRoles) {
		if (spRoles.isNew()) {
			Object[] args = new Object[] { spRoles.getUuid(), spRoles.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, spRoles);

			args = new Object[] {
					spRoles.getGroupId(), spRoles.getRoleId(),
					spRoles.getCategoryId1(), spRoles.getCategoryId2()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
				args, spRoles);
		}
		else {
			SPRolesModelImpl spRolesModelImpl = (SPRolesModelImpl)spRoles;

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRoles.getUuid(), spRoles.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spRoles);
			}

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRoles.getGroupId(), spRoles.getRoleId(),
						spRoles.getCategoryId1(), spRoles.getCategoryId2()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
					args, spRoles);
			}
		}
	}

	protected void clearUniqueFindersCache(SPRoles spRoles) {
		SPRolesModelImpl spRolesModelImpl = (SPRolesModelImpl)spRoles;

		Object[] args = new Object[] { spRoles.getUuid(), spRoles.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spRolesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spRolesModelImpl.getOriginalUuid(),
					spRolesModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				spRoles.getGroupId(), spRoles.getRoleId(),
				spRoles.getCategoryId1(), spRoles.getCategoryId2()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
			args);

		if ((spRolesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2.getColumnBitmask()) != 0) {
			args = new Object[] {
					spRolesModelImpl.getOriginalGroupId(),
					spRolesModelImpl.getOriginalRoleId(),
					spRolesModelImpl.getOriginalCategoryId1(),
					spRolesModelImpl.getOriginalCategoryId2()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ROLEIDCATEGORYID1ANDCATEGORYID2,
				args);
		}
	}

	/**
	 * Creates a new s p roles with the primary key. Does not add the s p roles to the database.
	 *
	 * @param spRoleId the primary key for the new s p roles
	 * @return the new s p roles
	 */
	@Override
	public SPRoles create(long spRoleId) {
		SPRoles spRoles = new SPRolesImpl();

		spRoles.setNew(true);
		spRoles.setPrimaryKey(spRoleId);

		String uuid = PortalUUIDUtil.generate();

		spRoles.setUuid(uuid);

		return spRoles;
	}

	/**
	 * Removes the s p roles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spRoleId the primary key of the s p roles
	 * @return the s p roles that was removed
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles remove(long spRoleId)
		throws NoSuchSPRolesException, SystemException {
		return remove((Serializable)spRoleId);
	}

	/**
	 * Removes the s p roles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p roles
	 * @return the s p roles that was removed
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles remove(Serializable primaryKey)
		throws NoSuchSPRolesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPRoles spRoles = (SPRoles)session.get(SPRolesImpl.class, primaryKey);

			if (spRoles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPRolesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spRoles);
		}
		catch (NoSuchSPRolesException nsee) {
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
	protected SPRoles removeImpl(SPRoles spRoles) throws SystemException {
		spRoles = toUnwrappedModel(spRoles);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spRoles)) {
				spRoles = (SPRoles)session.get(SPRolesImpl.class,
						spRoles.getPrimaryKeyObj());
			}

			if (spRoles != null) {
				session.delete(spRoles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spRoles != null) {
			clearCache(spRoles);
		}

		return spRoles;
	}

	@Override
	public SPRoles updateImpl(
		com.sambaash.platform.srv.roles.model.SPRoles spRoles)
		throws SystemException {
		spRoles = toUnwrappedModel(spRoles);

		boolean isNew = spRoles.isNew();

		SPRolesModelImpl spRolesModelImpl = (SPRolesModelImpl)spRoles;

		if (Validator.isNull(spRoles.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spRoles.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spRoles.isNew()) {
				session.save(spRoles);

				spRoles.setNew(false);
			}
			else {
				session.merge(spRoles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPRolesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spRolesModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spRolesModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRolesModelImpl.getOriginalUuid(),
						spRolesModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spRolesModelImpl.getUuid(),
						spRolesModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRolesModelImpl.getOriginalGroupId(),
						spRolesModelImpl.getOriginalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID,
					args);

				args = new Object[] {
						spRolesModelImpl.getGroupId(),
						spRolesModelImpl.getRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID,
					args);
			}

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID1.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRolesModelImpl.getOriginalGroupId(),
						spRolesModelImpl.getOriginalCategoryId1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID1,
					args);

				args = new Object[] {
						spRolesModelImpl.getGroupId(),
						spRolesModelImpl.getCategoryId1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID1,
					args);
			}

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID1.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRolesModelImpl.getOriginalGroupId(),
						spRolesModelImpl.getOriginalRoleId(),
						spRolesModelImpl.getOriginalCategoryId1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID1,
					args);

				args = new Object[] {
						spRolesModelImpl.getGroupId(),
						spRolesModelImpl.getRoleId(),
						spRolesModelImpl.getCategoryId1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID1,
					args);
			}

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRolesModelImpl.getOriginalGroupId(),
						spRolesModelImpl.getOriginalRoleId(),
						spRolesModelImpl.getOriginalCategoryId2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID2,
					args);

				args = new Object[] {
						spRolesModelImpl.getGroupId(),
						spRolesModelImpl.getRoleId(),
						spRolesModelImpl.getCategoryId2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDCATEGORYID2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDCATEGORYID2,
					args);
			}

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRolesModelImpl.getOriginalGroupId(),
						spRolesModelImpl.getOriginalCountryCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYID,
					args);

				args = new Object[] {
						spRolesModelImpl.getGroupId(),
						spRolesModelImpl.getCountryCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYID,
					args);
			}

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRolesModelImpl.getOriginalGroupId(),
						spRolesModelImpl.getOriginalDepartmentCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCATEGORYID,
					args);

				args = new Object[] {
						spRolesModelImpl.getGroupId(),
						spRolesModelImpl.getDepartmentCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCATEGORYID,
					args);
			}

			if ((spRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spRolesModelImpl.getOriginalGroupId(),
						spRolesModelImpl.getOriginalCountryCategoryId(),
						spRolesModelImpl.getOriginalDepartmentCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID,
					args);

				args = new Object[] {
						spRolesModelImpl.getGroupId(),
						spRolesModelImpl.getCountryCategoryId(),
						spRolesModelImpl.getDepartmentCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYCATEGORYIDANDDEPARTMENTCATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
			SPRolesImpl.class, spRoles.getPrimaryKey(), spRoles);

		clearUniqueFindersCache(spRoles);
		cacheUniqueFindersCache(spRoles);

		return spRoles;
	}

	protected SPRoles toUnwrappedModel(SPRoles spRoles) {
		if (spRoles instanceof SPRolesImpl) {
			return spRoles;
		}

		SPRolesImpl spRolesImpl = new SPRolesImpl();

		spRolesImpl.setNew(spRoles.isNew());
		spRolesImpl.setPrimaryKey(spRoles.getPrimaryKey());

		spRolesImpl.setUuid(spRoles.getUuid());
		spRolesImpl.setSpRoleId(spRoles.getSpRoleId());
		spRolesImpl.setGroupId(spRoles.getGroupId());
		spRolesImpl.setCompanyId(spRoles.getCompanyId());
		spRolesImpl.setUserId(spRoles.getUserId());
		spRolesImpl.setUserName(spRoles.getUserName());
		spRolesImpl.setCreateDate(spRoles.getCreateDate());
		spRolesImpl.setModifiedDate(spRoles.getModifiedDate());
		spRolesImpl.setRoleId(spRoles.getRoleId());
		spRolesImpl.setCategoryId1(spRoles.getCategoryId1());
		spRolesImpl.setCategoryId2(spRoles.getCategoryId2());
		spRolesImpl.setCountryCategoryId(spRoles.getCountryCategoryId());
		spRolesImpl.setDepartmentCategoryId(spRoles.getDepartmentCategoryId());

		return spRolesImpl;
	}

	/**
	 * Returns the s p roles with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p roles
	 * @return the s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPRolesException, SystemException {
		SPRoles spRoles = fetchByPrimaryKey(primaryKey);

		if (spRoles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPRolesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spRoles;
	}

	/**
	 * Returns the s p roles with the primary key or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPRolesException} if it could not be found.
	 *
	 * @param spRoleId the primary key of the s p roles
	 * @return the s p roles
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPRolesException if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles findByPrimaryKey(long spRoleId)
		throws NoSuchSPRolesException, SystemException {
		return findByPrimaryKey((Serializable)spRoleId);
	}

	/**
	 * Returns the s p roles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p roles
	 * @return the s p roles, or <code>null</code> if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPRoles spRoles = (SPRoles)EntityCacheUtil.getResult(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
				SPRolesImpl.class, primaryKey);

		if (spRoles == _nullSPRoles) {
			return null;
		}

		if (spRoles == null) {
			Session session = null;

			try {
				session = openSession();

				spRoles = (SPRoles)session.get(SPRolesImpl.class, primaryKey);

				if (spRoles != null) {
					cacheResult(spRoles);
				}
				else {
					EntityCacheUtil.putResult(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
						SPRolesImpl.class, primaryKey, _nullSPRoles);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPRolesModelImpl.ENTITY_CACHE_ENABLED,
					SPRolesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spRoles;
	}

	/**
	 * Returns the s p roles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spRoleId the primary key of the s p roles
	 * @return the s p roles, or <code>null</code> if a s p roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPRoles fetchByPrimaryKey(long spRoleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spRoleId);
	}

	/**
	 * Returns all the s p roleses.
	 *
	 * @return the s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p roleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @return the range of s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p roleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p roleses
	 * @param end the upper bound of the range of s p roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPRoles> findAll(int start, int end,
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

		List<SPRoles> list = (List<SPRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPROLES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPROLES;

				if (pagination) {
					sql = sql.concat(SPRolesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPRoles>(list);
				}
				else {
					list = (List<SPRoles>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p roleses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPRoles spRoles : findAll()) {
			remove(spRoles);
		}
	}

	/**
	 * Returns the number of s p roleses.
	 *
	 * @return the number of s p roleses
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

				Query q = session.createQuery(_SQL_COUNT_SPROLES);

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
	 * Initializes the s p roles persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.roles.model.SPRoles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPRoles>> listenersList = new ArrayList<ModelListener<SPRoles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPRoles>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPRolesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPROLES = "SELECT spRoles FROM SPRoles spRoles";
	private static final String _SQL_SELECT_SPROLES_WHERE = "SELECT spRoles FROM SPRoles spRoles WHERE ";
	private static final String _SQL_COUNT_SPROLES = "SELECT COUNT(spRoles) FROM SPRoles spRoles";
	private static final String _SQL_COUNT_SPROLES_WHERE = "SELECT COUNT(spRoles) FROM SPRoles spRoles WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spRoles.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPRoles exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPRoles exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPRolesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPRoles _nullSPRoles = new SPRolesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPRoles> toCacheModel() {
				return _nullSPRolesCacheModel;
			}
		};

	private static CacheModel<SPRoles> _nullSPRolesCacheModel = new CacheModel<SPRoles>() {
			@Override
			public SPRoles toEntityModel() {
				return _nullSPRoles;
			}
		};
}