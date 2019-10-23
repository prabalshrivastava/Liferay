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

import com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.model.impl.SPListTypeImpl;
import com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p list type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPListTypePersistence
 * @see SPListTypeUtil
 * @generated
 */
public class SPListTypePersistenceImpl extends BasePersistenceImpl<SPListType>
	implements SPListTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPListTypeUtil} to access the s p list type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPListTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPListTypeModelImpl.UUID_COLUMN_BITMASK |
			SPListTypeModelImpl.DISPLAYORDER_COLUMN_BITMASK |
			SPListTypeModelImpl.ITEMVALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p list types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p list types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @return the range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p list types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByUuid(String uuid, int start, int end,
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

		List<SPListType> list = (List<SPListType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPListType spListType : list) {
				if (!Validator.equals(uuid, spListType.getUuid())) {
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

			query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

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
				query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPListType>(list);
				}
				else {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p list type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByUuid_First(uuid, orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the first s p list type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPListType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p list type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByUuid_Last(uuid, orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the last s p list type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPListType> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p list types before and after the current s p list type in the ordered set where uuid = &#63;.
	 *
	 * @param spListTypeId the primary key of the current s p list type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType[] findByUuid_PrevAndNext(long spListTypeId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = findByPrimaryKey(spListTypeId);

		Session session = null;

		try {
			session = openSession();

			SPListType[] array = new SPListTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spListType, uuid,
					orderByComparator, true);

			array[1] = spListType;

			array[2] = getByUuid_PrevAndNext(session, spListType, uuid,
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

	protected SPListType getByUuid_PrevAndNext(Session session,
		SPListType spListType, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

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
			query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spListType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPListType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p list types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPListType spListType : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spListType);
		}
	}

	/**
	 * Returns the number of s p list types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p list types
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

			query.append(_SQL_COUNT_SPLISTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spListType.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spListType.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spListType.uuid IS NULL OR spListType.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPListTypeModelImpl.UUID_COLUMN_BITMASK |
			SPListTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p list type where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPListTypeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByUUID_G(String uuid, long groupId)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByUUID_G(uuid, groupId);

		if (spListType == null) {
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

			throw new NoSuchSPListTypeException(msg.toString());
		}

		return spListType;
	}

	/**
	 * Returns the s p list type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p list type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPListType) {
			SPListType spListType = (SPListType)result;

			if (!Validator.equals(uuid, spListType.getUuid()) ||
					(groupId != spListType.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

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

				List<SPListType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPListType spListType = list.get(0);

					result = spListType;

					cacheResult(spListType);

					if ((spListType.getUuid() == null) ||
							!spListType.getUuid().equals(uuid) ||
							(spListType.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spListType);
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
			return (SPListType)result;
		}
	}

	/**
	 * Removes the s p list type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p list type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = findByUUID_G(uuid, groupId);

		return remove(spListType);
	}

	/**
	 * Returns the number of s p list types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p list types
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

			query.append(_SQL_COUNT_SPLISTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spListType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spListType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spListType.uuid IS NULL OR spListType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spListType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPListTypeModelImpl.UUID_COLUMN_BITMASK |
			SPListTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			SPListTypeModelImpl.DISPLAYORDER_COLUMN_BITMASK |
			SPListTypeModelImpl.ITEMVALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p list types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p list types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @return the range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p list types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByUuid_C(String uuid, long companyId,
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

		List<SPListType> list = (List<SPListType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPListType spListType : list) {
				if (!Validator.equals(uuid, spListType.getUuid()) ||
						(companyId != spListType.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

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
				query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPListType>(list);
				}
				else {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the first s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPListType> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the last s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPListType> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p list types before and after the current s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spListTypeId the primary key of the current s p list type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType[] findByUuid_C_PrevAndNext(long spListTypeId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = findByPrimaryKey(spListTypeId);

		Session session = null;

		try {
			session = openSession();

			SPListType[] array = new SPListTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spListType, uuid,
					companyId, orderByComparator, true);

			array[1] = spListType;

			array[2] = getByUuid_C_PrevAndNext(session, spListType, uuid,
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

	protected SPListType getByUuid_C_PrevAndNext(Session session,
		SPListType spListType, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

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
			query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spListType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPListType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p list types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPListType spListType : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spListType);
		}
	}

	/**
	 * Returns the number of s p list types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p list types
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

			query.append(_SQL_COUNT_SPLISTTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spListType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spListType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spListType.uuid IS NULL OR spListType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spListType.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMKEYS = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByItemKeys",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMKEYS =
		new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemKeys",
			new String[] { String.class.getName(), Long.class.getName() },
			SPListTypeModelImpl.ITEMKEY_COLUMN_BITMASK |
			SPListTypeModelImpl.GROUPID_COLUMN_BITMASK |
			SPListTypeModelImpl.DISPLAYORDER_COLUMN_BITMASK |
			SPListTypeModelImpl.ITEMVALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMKEYS = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemKeys",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p list types where itemKey = &#63; and groupId = &#63;.
	 *
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @return the matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByItemKeys(String itemKey, long groupId)
		throws SystemException {
		return findByItemKeys(itemKey, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p list types where itemKey = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @return the range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByItemKeys(String itemKey, long groupId,
		int start, int end) throws SystemException {
		return findByItemKeys(itemKey, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p list types where itemKey = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByItemKeys(String itemKey, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMKEYS;
			finderArgs = new Object[] { itemKey, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMKEYS;
			finderArgs = new Object[] {
					itemKey, groupId,
					
					start, end, orderByComparator
				};
		}

		List<SPListType> list = (List<SPListType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPListType spListType : list) {
				if (!Validator.equals(itemKey, spListType.getItemKey()) ||
						(groupId != spListType.getGroupId())) {
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

			query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

			boolean bindItemKey = false;

			if (itemKey == null) {
				query.append(_FINDER_COLUMN_ITEMKEYS_ITEMKEY_1);
			}
			else if (itemKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ITEMKEYS_ITEMKEY_3);
			}
			else {
				bindItemKey = true;

				query.append(_FINDER_COLUMN_ITEMKEYS_ITEMKEY_2);
			}

			query.append(_FINDER_COLUMN_ITEMKEYS_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindItemKey) {
					qPos.add(itemKey);
				}

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPListType>(list);
				}
				else {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	 *
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByItemKeys_First(String itemKey, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByItemKeys_First(itemKey, groupId,
				orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemKey=");
		msg.append(itemKey);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the first s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	 *
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByItemKeys_First(String itemKey, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPListType> list = findByItemKeys(itemKey, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	 *
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByItemKeys_Last(String itemKey, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByItemKeys_Last(itemKey, groupId,
				orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemKey=");
		msg.append(itemKey);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the last s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	 *
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByItemKeys_Last(String itemKey, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemKeys(itemKey, groupId);

		if (count == 0) {
			return null;
		}

		List<SPListType> list = findByItemKeys(itemKey, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p list types before and after the current s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	 *
	 * @param spListTypeId the primary key of the current s p list type
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType[] findByItemKeys_PrevAndNext(long spListTypeId,
		String itemKey, long groupId, OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = findByPrimaryKey(spListTypeId);

		Session session = null;

		try {
			session = openSession();

			SPListType[] array = new SPListTypeImpl[3];

			array[0] = getByItemKeys_PrevAndNext(session, spListType, itemKey,
					groupId, orderByComparator, true);

			array[1] = spListType;

			array[2] = getByItemKeys_PrevAndNext(session, spListType, itemKey,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPListType getByItemKeys_PrevAndNext(Session session,
		SPListType spListType, String itemKey, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

		boolean bindItemKey = false;

		if (itemKey == null) {
			query.append(_FINDER_COLUMN_ITEMKEYS_ITEMKEY_1);
		}
		else if (itemKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ITEMKEYS_ITEMKEY_3);
		}
		else {
			bindItemKey = true;

			query.append(_FINDER_COLUMN_ITEMKEYS_ITEMKEY_2);
		}

		query.append(_FINDER_COLUMN_ITEMKEYS_GROUPID_2);

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
			query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindItemKey) {
			qPos.add(itemKey);
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spListType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPListType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p list types where itemKey = &#63; and groupId = &#63; from the database.
	 *
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemKeys(String itemKey, long groupId)
		throws SystemException {
		for (SPListType spListType : findByItemKeys(itemKey, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spListType);
		}
	}

	/**
	 * Returns the number of s p list types where itemKey = &#63; and groupId = &#63;.
	 *
	 * @param itemKey the item key
	 * @param groupId the group ID
	 * @return the number of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByItemKeys(String itemKey, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMKEYS;

		Object[] finderArgs = new Object[] { itemKey, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPLISTTYPE_WHERE);

			boolean bindItemKey = false;

			if (itemKey == null) {
				query.append(_FINDER_COLUMN_ITEMKEYS_ITEMKEY_1);
			}
			else if (itemKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ITEMKEYS_ITEMKEY_3);
			}
			else {
				bindItemKey = true;

				query.append(_FINDER_COLUMN_ITEMKEYS_ITEMKEY_2);
			}

			query.append(_FINDER_COLUMN_ITEMKEYS_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindItemKey) {
					qPos.add(itemKey);
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

	private static final String _FINDER_COLUMN_ITEMKEYS_ITEMKEY_1 = "spListType.itemKey IS NULL AND ";
	private static final String _FINDER_COLUMN_ITEMKEYS_ITEMKEY_2 = "spListType.itemKey = ? AND ";
	private static final String _FINDER_COLUMN_ITEMKEYS_ITEMKEY_3 = "(spListType.itemKey IS NULL OR spListType.itemKey = '') AND ";
	private static final String _FINDER_COLUMN_ITEMKEYS_GROUPID_2 = "spListType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMVALUES =
		new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByItemValues",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMVALUES =
		new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemValues",
			new String[] { String.class.getName(), Long.class.getName() },
			SPListTypeModelImpl.ITEMVALUE_COLUMN_BITMASK |
			SPListTypeModelImpl.GROUPID_COLUMN_BITMASK |
			SPListTypeModelImpl.DISPLAYORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMVALUES = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByItemValues",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p list types where itemValue = &#63; and groupId = &#63;.
	 *
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @return the matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByItemValues(String itemValue, long groupId)
		throws SystemException {
		return findByItemValues(itemValue, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p list types where itemValue = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @return the range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByItemValues(String itemValue, long groupId,
		int start, int end) throws SystemException {
		return findByItemValues(itemValue, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p list types where itemValue = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByItemValues(String itemValue, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMVALUES;
			finderArgs = new Object[] { itemValue, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMVALUES;
			finderArgs = new Object[] {
					itemValue, groupId,
					
					start, end, orderByComparator
				};
		}

		List<SPListType> list = (List<SPListType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPListType spListType : list) {
				if (!Validator.equals(itemValue, spListType.getItemValue()) ||
						(groupId != spListType.getGroupId())) {
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

			query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

			boolean bindItemValue = false;

			if (itemValue == null) {
				query.append(_FINDER_COLUMN_ITEMVALUES_ITEMVALUE_1);
			}
			else if (itemValue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ITEMVALUES_ITEMVALUE_3);
			}
			else {
				bindItemValue = true;

				query.append(_FINDER_COLUMN_ITEMVALUES_ITEMVALUE_2);
			}

			query.append(_FINDER_COLUMN_ITEMVALUES_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindItemValue) {
					qPos.add(itemValue);
				}

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPListType>(list);
				}
				else {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	 *
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByItemValues_First(String itemValue, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByItemValues_First(itemValue, groupId,
				orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemValue=");
		msg.append(itemValue);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the first s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	 *
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByItemValues_First(String itemValue, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPListType> list = findByItemValues(itemValue, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	 *
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByItemValues_Last(String itemValue, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByItemValues_Last(itemValue, groupId,
				orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemValue=");
		msg.append(itemValue);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the last s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	 *
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByItemValues_Last(String itemValue, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByItemValues(itemValue, groupId);

		if (count == 0) {
			return null;
		}

		List<SPListType> list = findByItemValues(itemValue, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p list types before and after the current s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	 *
	 * @param spListTypeId the primary key of the current s p list type
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType[] findByItemValues_PrevAndNext(long spListTypeId,
		String itemValue, long groupId, OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = findByPrimaryKey(spListTypeId);

		Session session = null;

		try {
			session = openSession();

			SPListType[] array = new SPListTypeImpl[3];

			array[0] = getByItemValues_PrevAndNext(session, spListType,
					itemValue, groupId, orderByComparator, true);

			array[1] = spListType;

			array[2] = getByItemValues_PrevAndNext(session, spListType,
					itemValue, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPListType getByItemValues_PrevAndNext(Session session,
		SPListType spListType, String itemValue, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

		boolean bindItemValue = false;

		if (itemValue == null) {
			query.append(_FINDER_COLUMN_ITEMVALUES_ITEMVALUE_1);
		}
		else if (itemValue.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ITEMVALUES_ITEMVALUE_3);
		}
		else {
			bindItemValue = true;

			query.append(_FINDER_COLUMN_ITEMVALUES_ITEMVALUE_2);
		}

		query.append(_FINDER_COLUMN_ITEMVALUES_GROUPID_2);

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
			query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindItemValue) {
			qPos.add(itemValue);
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spListType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPListType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p list types where itemValue = &#63; and groupId = &#63; from the database.
	 *
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByItemValues(String itemValue, long groupId)
		throws SystemException {
		for (SPListType spListType : findByItemValues(itemValue, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spListType);
		}
	}

	/**
	 * Returns the number of s p list types where itemValue = &#63; and groupId = &#63;.
	 *
	 * @param itemValue the item value
	 * @param groupId the group ID
	 * @return the number of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByItemValues(String itemValue, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMVALUES;

		Object[] finderArgs = new Object[] { itemValue, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPLISTTYPE_WHERE);

			boolean bindItemValue = false;

			if (itemValue == null) {
				query.append(_FINDER_COLUMN_ITEMVALUES_ITEMVALUE_1);
			}
			else if (itemValue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ITEMVALUES_ITEMVALUE_3);
			}
			else {
				bindItemValue = true;

				query.append(_FINDER_COLUMN_ITEMVALUES_ITEMVALUE_2);
			}

			query.append(_FINDER_COLUMN_ITEMVALUES_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindItemValue) {
					qPos.add(itemValue);
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

	private static final String _FINDER_COLUMN_ITEMVALUES_ITEMVALUE_1 = "spListType.itemValue IS NULL AND ";
	private static final String _FINDER_COLUMN_ITEMVALUES_ITEMVALUE_2 = "spListType.itemValue = ? AND ";
	private static final String _FINDER_COLUMN_ITEMVALUES_ITEMVALUE_3 = "(spListType.itemValue IS NULL OR spListType.itemValue = '') AND ";
	private static final String _FINDER_COLUMN_ITEMVALUES_GROUPID_2 = "spListType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYIDGROUPID =
		new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDGROUPID =
		new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, SPListTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPListTypeModelImpl.GROUPID_COLUMN_BITMASK |
			SPListTypeModelImpl.CATEGORYID_COLUMN_BITMASK |
			SPListTypeModelImpl.DISPLAYORDER_COLUMN_BITMASK |
			SPListTypeModelImpl.ITEMVALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYIDGROUPID = new FinderPath(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p list types where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByCategoryIdGroupId(long groupId,
		long categoryId) throws SystemException {
		return findByCategoryIdGroupId(groupId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p list types where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @return the range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByCategoryIdGroupId(long groupId,
		long categoryId, int start, int end) throws SystemException {
		return findByCategoryIdGroupId(groupId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p list types where groupId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findByCategoryIdGroupId(long groupId,
		long categoryId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDGROUPID;
			finderArgs = new Object[] { groupId, categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYIDGROUPID;
			finderArgs = new Object[] {
					groupId, categoryId,
					
					start, end, orderByComparator
				};
		}

		List<SPListType> list = (List<SPListType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPListType spListType : list) {
				if ((groupId != spListType.getGroupId()) ||
						(categoryId != spListType.getCategoryId())) {
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

			query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYIDGROUPID_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYIDGROUPID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPListType>(list);
				}
				else {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByCategoryIdGroupId_First(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByCategoryIdGroupId_First(groupId,
				categoryId, orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the first s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByCategoryIdGroupId_First(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPListType> list = findByCategoryIdGroupId(groupId, categoryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByCategoryIdGroupId_Last(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByCategoryIdGroupId_Last(groupId,
				categoryId, orderByComparator);

		if (spListType != null) {
			return spListType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPListTypeException(msg.toString());
	}

	/**
	 * Returns the last s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByCategoryIdGroupId_Last(long groupId,
		long categoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCategoryIdGroupId(groupId, categoryId);

		if (count == 0) {
			return null;
		}

		List<SPListType> list = findByCategoryIdGroupId(groupId, categoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p list types before and after the current s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param spListTypeId the primary key of the current s p list type
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType[] findByCategoryIdGroupId_PrevAndNext(long spListTypeId,
		long groupId, long categoryId, OrderByComparator orderByComparator)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = findByPrimaryKey(spListTypeId);

		Session session = null;

		try {
			session = openSession();

			SPListType[] array = new SPListTypeImpl[3];

			array[0] = getByCategoryIdGroupId_PrevAndNext(session, spListType,
					groupId, categoryId, orderByComparator, true);

			array[1] = spListType;

			array[2] = getByCategoryIdGroupId_PrevAndNext(session, spListType,
					groupId, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPListType getByCategoryIdGroupId_PrevAndNext(Session session,
		SPListType spListType, long groupId, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPLISTTYPE_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYIDGROUPID_GROUPID_2);

		query.append(_FINDER_COLUMN_CATEGORYIDGROUPID_CATEGORYID_2);

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
			query.append(SPListTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spListType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPListType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p list types where groupId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryIdGroupId(long groupId, long categoryId)
		throws SystemException {
		for (SPListType spListType : findByCategoryIdGroupId(groupId,
				categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spListType);
		}
	}

	/**
	 * Returns the number of s p list types where groupId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param categoryId the category ID
	 * @return the number of matching s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryIdGroupId(long groupId, long categoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYIDGROUPID;

		Object[] finderArgs = new Object[] { groupId, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPLISTTYPE_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYIDGROUPID_GROUPID_2);

			query.append(_FINDER_COLUMN_CATEGORYIDGROUPID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORYIDGROUPID_GROUPID_2 = "spListType.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYIDGROUPID_CATEGORYID_2 = "spListType.categoryId = ?";

	public SPListTypePersistenceImpl() {
		setModelClass(SPListType.class);
	}

	/**
	 * Caches the s p list type in the entity cache if it is enabled.
	 *
	 * @param spListType the s p list type
	 */
	@Override
	public void cacheResult(SPListType spListType) {
		EntityCacheUtil.putResult(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeImpl.class, spListType.getPrimaryKey(), spListType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spListType.getUuid(), spListType.getGroupId() },
			spListType);

		spListType.resetOriginalValues();
	}

	/**
	 * Caches the s p list types in the entity cache if it is enabled.
	 *
	 * @param spListTypes the s p list types
	 */
	@Override
	public void cacheResult(List<SPListType> spListTypes) {
		for (SPListType spListType : spListTypes) {
			if (EntityCacheUtil.getResult(
						SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
						SPListTypeImpl.class, spListType.getPrimaryKey()) == null) {
				cacheResult(spListType);
			}
			else {
				spListType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p list types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPListTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPListTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p list type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPListType spListType) {
		EntityCacheUtil.removeResult(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeImpl.class, spListType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spListType);
	}

	@Override
	public void clearCache(List<SPListType> spListTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPListType spListType : spListTypes) {
			EntityCacheUtil.removeResult(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
				SPListTypeImpl.class, spListType.getPrimaryKey());

			clearUniqueFindersCache(spListType);
		}
	}

	protected void cacheUniqueFindersCache(SPListType spListType) {
		if (spListType.isNew()) {
			Object[] args = new Object[] {
					spListType.getUuid(), spListType.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spListType);
		}
		else {
			SPListTypeModelImpl spListTypeModelImpl = (SPListTypeModelImpl)spListType;

			if ((spListTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spListType.getUuid(), spListType.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spListType);
			}
		}
	}

	protected void clearUniqueFindersCache(SPListType spListType) {
		SPListTypeModelImpl spListTypeModelImpl = (SPListTypeModelImpl)spListType;

		Object[] args = new Object[] {
				spListType.getUuid(), spListType.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spListTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spListTypeModelImpl.getOriginalUuid(),
					spListTypeModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new s p list type with the primary key. Does not add the s p list type to the database.
	 *
	 * @param spListTypeId the primary key for the new s p list type
	 * @return the new s p list type
	 */
	@Override
	public SPListType create(long spListTypeId) {
		SPListType spListType = new SPListTypeImpl();

		spListType.setNew(true);
		spListType.setPrimaryKey(spListTypeId);

		String uuid = PortalUUIDUtil.generate();

		spListType.setUuid(uuid);

		return spListType;
	}

	/**
	 * Removes the s p list type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spListTypeId the primary key of the s p list type
	 * @return the s p list type that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType remove(long spListTypeId)
		throws NoSuchSPListTypeException, SystemException {
		return remove((Serializable)spListTypeId);
	}

	/**
	 * Removes the s p list type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p list type
	 * @return the s p list type that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType remove(Serializable primaryKey)
		throws NoSuchSPListTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPListType spListType = (SPListType)session.get(SPListTypeImpl.class,
					primaryKey);

			if (spListType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPListTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spListType);
		}
		catch (NoSuchSPListTypeException nsee) {
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
	protected SPListType removeImpl(SPListType spListType)
		throws SystemException {
		spListType = toUnwrappedModel(spListType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spListType)) {
				spListType = (SPListType)session.get(SPListTypeImpl.class,
						spListType.getPrimaryKeyObj());
			}

			if (spListType != null) {
				session.delete(spListType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spListType != null) {
			clearCache(spListType);
		}

		return spListType;
	}

	@Override
	public SPListType updateImpl(
		com.sambaash.platform.srv.spservices.model.SPListType spListType)
		throws SystemException {
		spListType = toUnwrappedModel(spListType);

		boolean isNew = spListType.isNew();

		SPListTypeModelImpl spListTypeModelImpl = (SPListTypeModelImpl)spListType;

		if (Validator.isNull(spListType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spListType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spListType.isNew()) {
				session.save(spListType);

				spListType.setNew(false);
			}
			else {
				session.merge(spListType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPListTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spListTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spListTypeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spListTypeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spListTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spListTypeModelImpl.getOriginalUuid(),
						spListTypeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spListTypeModelImpl.getUuid(),
						spListTypeModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spListTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMKEYS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spListTypeModelImpl.getOriginalItemKey(),
						spListTypeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMKEYS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMKEYS,
					args);

				args = new Object[] {
						spListTypeModelImpl.getItemKey(),
						spListTypeModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMKEYS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMKEYS,
					args);
			}

			if ((spListTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMVALUES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spListTypeModelImpl.getOriginalItemValue(),
						spListTypeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMVALUES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMVALUES,
					args);

				args = new Object[] {
						spListTypeModelImpl.getItemValue(),
						spListTypeModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMVALUES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMVALUES,
					args);
			}

			if ((spListTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spListTypeModelImpl.getOriginalGroupId(),
						spListTypeModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDGROUPID,
					args);

				args = new Object[] {
						spListTypeModelImpl.getGroupId(),
						spListTypeModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYIDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPListTypeImpl.class, spListType.getPrimaryKey(), spListType);

		clearUniqueFindersCache(spListType);
		cacheUniqueFindersCache(spListType);

		return spListType;
	}

	protected SPListType toUnwrappedModel(SPListType spListType) {
		if (spListType instanceof SPListTypeImpl) {
			return spListType;
		}

		SPListTypeImpl spListTypeImpl = new SPListTypeImpl();

		spListTypeImpl.setNew(spListType.isNew());
		spListTypeImpl.setPrimaryKey(spListType.getPrimaryKey());

		spListTypeImpl.setUuid(spListType.getUuid());
		spListTypeImpl.setSpListTypeId(spListType.getSpListTypeId());
		spListTypeImpl.setGroupId(spListType.getGroupId());
		spListTypeImpl.setCompanyId(spListType.getCompanyId());
		spListTypeImpl.setUserId(spListType.getUserId());
		spListTypeImpl.setUserName(spListType.getUserName());
		spListTypeImpl.setCreateDate(spListType.getCreateDate());
		spListTypeImpl.setModifiedDate(spListType.getModifiedDate());
		spListTypeImpl.setItemKey(spListType.getItemKey());
		spListTypeImpl.setItemValue(spListType.getItemValue());
		spListTypeImpl.setDisplayName(spListType.getDisplayName());
		spListTypeImpl.setDisplayOrder(spListType.getDisplayOrder());
		spListTypeImpl.setCategoryId(spListType.getCategoryId());
		spListTypeImpl.setModeldata(spListType.getModeldata());

		return spListTypeImpl;
	}

	/**
	 * Returns the s p list type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p list type
	 * @return the s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPListTypeException, SystemException {
		SPListType spListType = fetchByPrimaryKey(primaryKey);

		if (spListType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPListTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spListType;
	}

	/**
	 * Returns the s p list type with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPListTypeException} if it could not be found.
	 *
	 * @param spListTypeId the primary key of the s p list type
	 * @return the s p list type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType findByPrimaryKey(long spListTypeId)
		throws NoSuchSPListTypeException, SystemException {
		return findByPrimaryKey((Serializable)spListTypeId);
	}

	/**
	 * Returns the s p list type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p list type
	 * @return the s p list type, or <code>null</code> if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPListType spListType = (SPListType)EntityCacheUtil.getResult(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
				SPListTypeImpl.class, primaryKey);

		if (spListType == _nullSPListType) {
			return null;
		}

		if (spListType == null) {
			Session session = null;

			try {
				session = openSession();

				spListType = (SPListType)session.get(SPListTypeImpl.class,
						primaryKey);

				if (spListType != null) {
					cacheResult(spListType);
				}
				else {
					EntityCacheUtil.putResult(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
						SPListTypeImpl.class, primaryKey, _nullSPListType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPListTypeModelImpl.ENTITY_CACHE_ENABLED,
					SPListTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spListType;
	}

	/**
	 * Returns the s p list type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spListTypeId the primary key of the s p list type
	 * @return the s p list type, or <code>null</code> if a s p list type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPListType fetchByPrimaryKey(long spListTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spListTypeId);
	}

	/**
	 * Returns all the s p list types.
	 *
	 * @return the s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p list types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @return the range of s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p list types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p list types
	 * @param end the upper bound of the range of s p list types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p list types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPListType> findAll(int start, int end,
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

		List<SPListType> list = (List<SPListType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPLISTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPLISTTYPE;

				if (pagination) {
					sql = sql.concat(SPListTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPListType>(list);
				}
				else {
					list = (List<SPListType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p list types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPListType spListType : findAll()) {
			remove(spListType);
		}
	}

	/**
	 * Returns the number of s p list types.
	 *
	 * @return the number of s p list types
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

				Query q = session.createQuery(_SQL_COUNT_SPLISTTYPE);

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
	 * Initializes the s p list type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.SPListType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPListType>> listenersList = new ArrayList<ModelListener<SPListType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPListType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPListTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPLISTTYPE = "SELECT spListType FROM SPListType spListType";
	private static final String _SQL_SELECT_SPLISTTYPE_WHERE = "SELECT spListType FROM SPListType spListType WHERE ";
	private static final String _SQL_COUNT_SPLISTTYPE = "SELECT COUNT(spListType) FROM SPListType spListType";
	private static final String _SQL_COUNT_SPLISTTYPE_WHERE = "SELECT COUNT(spListType) FROM SPListType spListType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spListType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPListType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPListType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPListTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPListType _nullSPListType = new SPListTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPListType> toCacheModel() {
				return _nullSPListTypeCacheModel;
			}
		};

	private static CacheModel<SPListType> _nullSPListTypeCacheModel = new CacheModel<SPListType>() {
			@Override
			public SPListType toEntityModel() {
				return _nullSPListType;
			}
		};
}